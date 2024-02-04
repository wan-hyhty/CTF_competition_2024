package sun.security.pkcs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import sun.misc.HexDumpEncoder;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.x509.AlgorithmId;
import sun.security.x509.X500Name;

public class SignerInfo implements DerEncoder {
    PKCS9Attributes authenticatedAttributes;
    BigInteger certificateSerialNumber;
    AlgorithmId digestAlgorithmId;
    AlgorithmId digestEncryptionAlgorithmId;
    byte[] encryptedDigest;
    X500Name issuerName;
    PKCS9Attributes unauthenticatedAttributes;
    BigInteger version;

    public SignerInfo(X500Name issuerName2, BigInteger serial, AlgorithmId digestAlgorithmId2, AlgorithmId digestEncryptionAlgorithmId2, byte[] encryptedDigest2) {
        this.version = BigInteger.ONE;
        this.issuerName = issuerName2;
        this.certificateSerialNumber = serial;
        this.digestAlgorithmId = digestAlgorithmId2;
        this.digestEncryptionAlgorithmId = digestEncryptionAlgorithmId2;
        this.encryptedDigest = encryptedDigest2;
    }

    public SignerInfo(X500Name issuerName2, BigInteger serial, AlgorithmId digestAlgorithmId2, PKCS9Attributes authenticatedAttributes2, AlgorithmId digestEncryptionAlgorithmId2, byte[] encryptedDigest2, PKCS9Attributes unauthenticatedAttributes2) {
        this.version = BigInteger.ONE;
        this.issuerName = issuerName2;
        this.certificateSerialNumber = serial;
        this.digestAlgorithmId = digestAlgorithmId2;
        this.authenticatedAttributes = authenticatedAttributes2;
        this.digestEncryptionAlgorithmId = digestEncryptionAlgorithmId2;
        this.encryptedDigest = encryptedDigest2;
        this.unauthenticatedAttributes = unauthenticatedAttributes2;
    }

    public SignerInfo(DerInputStream derin) throws IOException, ParsingException {
        this(derin, false);
    }

    public SignerInfo(DerInputStream derin, boolean oldStyle) throws IOException, ParsingException {
        this.version = derin.getBigInteger();
        DerValue[] issuerAndSerialNumber = derin.getSequence(2);
        this.issuerName = new X500Name(new DerValue((byte) 48, issuerAndSerialNumber[0].toByteArray()));
        this.certificateSerialNumber = issuerAndSerialNumber[1].getBigInteger();
        this.digestAlgorithmId = AlgorithmId.parse(derin.getDerValue());
        if (oldStyle) {
            derin.getSet(0);
        } else if (((byte) derin.peekByte()) == -96) {
            this.authenticatedAttributes = new PKCS9Attributes(derin);
        }
        this.digestEncryptionAlgorithmId = AlgorithmId.parse(derin.getDerValue());
        this.encryptedDigest = derin.getOctetString();
        if (oldStyle) {
            derin.getSet(0);
        } else if (derin.available() != 0 && ((byte) derin.peekByte()) == -95) {
            this.unauthenticatedAttributes = new PKCS9Attributes(derin, true);
        }
        if (derin.available() != 0) {
            throw new ParsingException("extra data at the end");
        }
    }

    public void encode(DerOutputStream out) throws IOException {
        derEncode(out);
    }

    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream seq = new DerOutputStream();
        seq.putInteger(this.version);
        DerOutputStream issuerAndSerialNumber = new DerOutputStream();
        this.issuerName.encode(issuerAndSerialNumber);
        issuerAndSerialNumber.putInteger(this.certificateSerialNumber);
        seq.write((byte) 48, issuerAndSerialNumber);
        this.digestAlgorithmId.encode(seq);
        if (this.authenticatedAttributes != null) {
            this.authenticatedAttributes.encode((byte) -96, seq);
        }
        this.digestEncryptionAlgorithmId.encode(seq);
        seq.putOctetString(this.encryptedDigest);
        if (this.unauthenticatedAttributes != null) {
            this.unauthenticatedAttributes.encode((byte) -95, seq);
        }
        DerOutputStream tmp = new DerOutputStream();
        tmp.write((byte) 48, seq);
        out.write(tmp.toByteArray());
    }

    public X509Certificate getCertificate(PKCS7 block) throws IOException {
        return block.getCertificate(this.certificateSerialNumber, this.issuerName);
    }

    public ArrayList<X509Certificate> getCertificateChain(PKCS7 block) throws IOException {
        boolean match;
        X509Certificate userCert = block.getCertificate(this.certificateSerialNumber, this.issuerName);
        if (userCert == null) {
            return null;
        }
        ArrayList<X509Certificate> certList = new ArrayList<>();
        certList.add(userCert);
        X509Certificate[] pkcsCerts = block.getCertificates();
        if (pkcsCerts == null || userCert.getSubjectDN().equals(userCert.getIssuerDN())) {
            return certList;
        }
        Principal issuer = userCert.getIssuerDN();
        int start = 0;
        do {
            match = false;
            int i = start;
            while (true) {
                if (i >= pkcsCerts.length) {
                    break;
                } else if (issuer.equals(pkcsCerts[i].getSubjectDN())) {
                    certList.add(pkcsCerts[i]);
                    if (pkcsCerts[i].getSubjectDN().equals(pkcsCerts[i].getIssuerDN())) {
                        start = pkcsCerts.length;
                    } else {
                        issuer = pkcsCerts[i].getIssuerDN();
                        X509Certificate tmpCert = pkcsCerts[start];
                        pkcsCerts[start] = pkcsCerts[i];
                        pkcsCerts[i] = tmpCert;
                        start++;
                    }
                    match = true;
                    continue;
                } else {
                    i++;
                }
            }
        } while (match);
        return certList;
    }

    private static String convertToStandardName(String internalName) {
        if (internalName.equals("SHA")) {
            return "SHA-1";
        }
        if (internalName.equals("SHA224")) {
            return "SHA-224";
        }
        if (internalName.equals("SHA256")) {
            return "SHA-256";
        }
        if (internalName.equals("SHA384")) {
            return "SHA-384";
        }
        if (internalName.equals("SHA512")) {
            return "SHA-512";
        }
        return internalName;
    }

    /* access modifiers changed from: package-private */
    public SignerInfo verify(PKCS7 block, byte[] data) throws NoSuchAlgorithmException, SignatureException {
        try {
            return verify(block, (InputStream) new ByteArrayInputStream(data));
        } catch (IOException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0114, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0132, code lost:
        throw new java.security.SignatureException("InvalidKey: " + r13.getMessage());
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0114 A[ExcHandler: InvalidKeyException (r13v0 'e' java.security.InvalidKeyException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public sun.security.pkcs.SignerInfo verify(sun.security.pkcs.PKCS7 r31, java.io.InputStream r32) throws java.security.NoSuchAlgorithmException, java.security.SignatureException, java.io.IOException {
        /*
            r30 = this;
            sun.security.pkcs.ContentInfo r7 = r31.getContentInfo()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r32 != 0) goto L_0x0015
            java.io.ByteArrayInputStream r16 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            byte[] r27 = r7.getContentBytes()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r0 = r16
            r1 = r27
            r0.<init>(r1)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r32 = r16
        L_0x0015:
            sun.security.x509.AlgorithmId r27 = r30.getDigestAlgorithmId()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.String r11 = r27.getName()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r0 = r30
            sun.security.pkcs.PKCS9Attributes r0 = r0.authenticatedAttributes     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            if (r27 != 0) goto L_0x0048
            r9 = r32
        L_0x0027:
            sun.security.x509.AlgorithmId r27 = r30.getDigestEncryptionAlgorithmId()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.String r14 = r27.getName()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.String r26 = sun.security.x509.AlgorithmId.getEncAlgFromSigAlg(r14)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r26 == 0) goto L_0x0037
            r14 = r26
        L_0x0037:
            java.lang.String r3 = sun.security.x509.AlgorithmId.makeSigAlg(r11, r14)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.security.Signature r25 = java.security.Signature.getInstance(r3)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.security.cert.X509Certificate r5 = r30.getCertificate(r31)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r5 != 0) goto L_0x0105
            r27 = 0
            return r27
        L_0x0048:
            r0 = r30
            sun.security.pkcs.PKCS9Attributes r0 = r0.authenticatedAttributes     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            sun.security.util.ObjectIdentifier r28 = sun.security.pkcs.PKCS9Attribute.CONTENT_TYPE_OID     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.Object r8 = r27.getAttributeValue((sun.security.util.ObjectIdentifier) r28)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            sun.security.util.ObjectIdentifier r8 = (sun.security.util.ObjectIdentifier) r8     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r8 == 0) goto L_0x0077
            sun.security.util.ObjectIdentifier r0 = r7.contentType     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            r0 = r27
            boolean r27 = r8.equals((sun.security.util.ObjectIdentifier) r0)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r27 == 0) goto L_0x0077
            r0 = r30
            sun.security.pkcs.PKCS9Attributes r0 = r0.authenticatedAttributes     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            sun.security.util.ObjectIdentifier r28 = sun.security.pkcs.PKCS9Attribute.MESSAGE_DIGEST_OID     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.Object r22 = r27.getAttributeValue((sun.security.util.ObjectIdentifier) r28)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            byte[] r22 = (byte[]) r22     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r22 != 0) goto L_0x007a
            r27 = 0
            return r27
        L_0x0077:
            r27 = 0
            return r27
        L_0x007a:
            java.lang.String r27 = convertToStandardName(r11)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.security.MessageDigest r21 = java.security.MessageDigest.getInstance(r27)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = 4096(0x1000, float:5.74E-42)
            r0 = r27
            byte[] r4 = new byte[r0]     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r24 = 0
        L_0x008a:
            r0 = r32
            int r24 = r0.read(r4)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = -1
            r0 = r24
            r1 = r27
            if (r0 == r1) goto L_0x00c3
            r27 = 0
            r0 = r21
            r1 = r27
            r2 = r24
            r0.update(r4, r1, r2)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            goto L_0x008a
        L_0x00a4:
            r12 = move-exception
            java.security.SignatureException r27 = new java.security.SignatureException
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r28.<init>()
            java.lang.String r29 = "IO error verifying signature:\n"
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r29 = r12.getMessage()
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r28 = r28.toString()
            r27.<init>((java.lang.String) r28)
            throw r27
        L_0x00c3:
            byte[] r6 = r21.digest()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r0 = r22
            int r0 = r0.length     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            int r0 = r6.length     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r28 = r0
            r0 = r27
            r1 = r28
            if (r0 == r1) goto L_0x00d8
            r27 = 0
            return r27
        L_0x00d8:
            r15 = 0
        L_0x00d9:
            r0 = r22
            int r0 = r0.length     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            r0 = r27
            if (r15 >= r0) goto L_0x00f2
            byte r27 = r22[r15]     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            byte r28 = r6[r15]     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r0 = r27
            r1 = r28
            if (r0 == r1) goto L_0x00ef
            r27 = 0
            return r27
        L_0x00ef:
            int r15 = r15 + 1
            goto L_0x00d9
        L_0x00f2:
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r0 = r30
            sun.security.pkcs.PKCS9Attributes r0 = r0.authenticatedAttributes     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            byte[] r27 = r27.getDerEncoding()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r0 = r27
            r9.<init>(r0)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            goto L_0x0027
        L_0x0105:
            boolean r27 = r5.hasUnsupportedCriticalExtension()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r27 == 0) goto L_0x0133
            java.security.SignatureException r27 = new java.security.SignatureException     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.String r28 = "Certificate has unsupported critical extension(s)"
            r27.<init>((java.lang.String) r28)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            throw r27     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
        L_0x0114:
            r13 = move-exception
            java.security.SignatureException r27 = new java.security.SignatureException
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r28.<init>()
            java.lang.String r29 = "InvalidKey: "
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r29 = r13.getMessage()
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r28 = r28.toString()
            r27.<init>((java.lang.String) r28)
            throw r27
        L_0x0133:
            boolean[] r20 = r5.getKeyUsage()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r20 == 0) goto L_0x0164
            sun.security.x509.KeyUsageExtension r19 = new sun.security.x509.KeyUsageExtension     // Catch:{ IOException -> 0x018f, InvalidKeyException -> 0x0114 }
            r19.<init>((boolean[]) r20)     // Catch:{ IOException -> 0x018f, InvalidKeyException -> 0x0114 }
            java.lang.String r27 = "digital_signature"
            r0 = r19
            r1 = r27
            java.lang.Object r27 = r0.get(r1)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.Boolean r27 = (java.lang.Boolean) r27     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            boolean r10 = r27.booleanValue()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.String r27 = "non_repudiation"
            r0 = r19
            r1 = r27
            java.lang.Object r27 = r0.get(r1)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.Boolean r27 = (java.lang.Boolean) r27     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            boolean r23 = r27.booleanValue()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r10 != 0) goto L_0x0164
            if (r23 == 0) goto L_0x0199
        L_0x0164:
            java.security.PublicKey r18 = r5.getPublicKey()     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r0 = r25
            r1 = r18
            r0.initVerify((java.security.PublicKey) r1)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = 4096(0x1000, float:5.74E-42)
            r0 = r27
            byte[] r4 = new byte[r0]     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r24 = 0
        L_0x0177:
            int r24 = r9.read(r4)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = -1
            r0 = r24
            r1 = r27
            if (r0 == r1) goto L_0x01a2
            r27 = 0
            r0 = r25
            r1 = r27
            r2 = r24
            r0.update(r4, r1, r2)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            goto L_0x0177
        L_0x018f:
            r17 = move-exception
            java.security.SignatureException r27 = new java.security.SignatureException     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.String r28 = "Failed to parse keyUsage extension"
            r27.<init>((java.lang.String) r28)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            throw r27     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
        L_0x0199:
            java.security.SignatureException r27 = new java.security.SignatureException     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            java.lang.String r28 = "Key usage restricted: cannot be used for digital signatures"
            r27.<init>((java.lang.String) r28)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            throw r27     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
        L_0x01a2:
            r0 = r30
            byte[] r0 = r0.encryptedDigest     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            r27 = r0
            r0 = r25
            r1 = r27
            boolean r27 = r0.verify(r1)     // Catch:{ IOException -> 0x00a4, InvalidKeyException -> 0x0114 }
            if (r27 == 0) goto L_0x01b3
            return r30
        L_0x01b3:
            r27 = 0
            return r27
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.SignerInfo.verify(sun.security.pkcs.PKCS7, java.io.InputStream):sun.security.pkcs.SignerInfo");
    }

    /* access modifiers changed from: package-private */
    public SignerInfo verify(PKCS7 block) throws NoSuchAlgorithmException, SignatureException {
        return verify(block, (byte[]) null);
    }

    public BigInteger getVersion() {
        return this.version;
    }

    public X500Name getIssuerName() {
        return this.issuerName;
    }

    public BigInteger getCertificateSerialNumber() {
        return this.certificateSerialNumber;
    }

    public AlgorithmId getDigestAlgorithmId() {
        return this.digestAlgorithmId;
    }

    public PKCS9Attributes getAuthenticatedAttributes() {
        return this.authenticatedAttributes;
    }

    public AlgorithmId getDigestEncryptionAlgorithmId() {
        return this.digestEncryptionAlgorithmId;
    }

    public byte[] getEncryptedDigest() {
        return this.encryptedDigest;
    }

    public PKCS9Attributes getUnauthenticatedAttributes() {
        return this.unauthenticatedAttributes;
    }

    public String toString() {
        HexDumpEncoder hexDump = new HexDumpEncoder();
        String out = ((("" + "Signer Info for (issuer): " + this.issuerName + "\n") + "\tversion: " + Debug.toHexString(this.version) + "\n") + "\tcertificateSerialNumber: " + Debug.toHexString(this.certificateSerialNumber) + "\n") + "\tdigestAlgorithmId: " + this.digestAlgorithmId + "\n";
        if (this.authenticatedAttributes != null) {
            out = out + "\tauthenticatedAttributes: " + this.authenticatedAttributes + "\n";
        }
        String out2 = (out + "\tdigestEncryptionAlgorithmId: " + this.digestEncryptionAlgorithmId + "\n") + "\tencryptedDigest: \n" + hexDump.encodeBuffer(this.encryptedDigest) + "\n";
        if (this.unauthenticatedAttributes != null) {
            return out2 + "\tunauthenticatedAttributes: " + this.unauthenticatedAttributes + "\n";
        }
        return out2;
    }
}
