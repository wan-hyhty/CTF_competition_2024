package sun.security.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.util.Arrays;
import sun.misc.HexDumpEncoder;
import sun.security.util.BitArray;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

public class X509Key implements PublicKey {
    private static final long serialVersionUID = -5359250853002055002L;
    protected AlgorithmId algid;
    private BitArray bitStringKey = null;
    protected byte[] encodedKey;
    @Deprecated
    protected byte[] key = null;
    private int unusedBits = 0;

    public X509Key() {
    }

    private X509Key(AlgorithmId algid2, BitArray key2) throws InvalidKeyException {
        this.algid = algid2;
        setKey(key2);
        encode();
    }

    /* access modifiers changed from: protected */
    public void setKey(BitArray key2) {
        this.bitStringKey = (BitArray) key2.clone();
        this.key = key2.toByteArray();
        int remaining = key2.length() % 8;
        this.unusedBits = remaining == 0 ? 0 : 8 - remaining;
    }

    /* access modifiers changed from: protected */
    public BitArray getKey() {
        this.bitStringKey = new BitArray((this.key.length * 8) - this.unusedBits, this.key);
        return (BitArray) this.bitStringKey.clone();
    }

    public static PublicKey parse(DerValue in) throws IOException {
        if (in.tag != 48) {
            throw new IOException("corrupt subject key");
        }
        try {
            PublicKey subjectKey = buildX509Key(AlgorithmId.parse(in.data.getDerValue()), in.data.getUnalignedBitString());
            if (in.data.available() == 0) {
                return subjectKey;
            }
            throw new IOException("excess subject key");
        } catch (InvalidKeyException e) {
            throw new IOException("subject key, " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public void parseKeyBits() throws IOException, InvalidKeyException {
        encode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c2, code lost:
        throw new java.io.IOException(r3 + " [internal error]");
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0075 A[ExcHandler: InstantiationException (e java.lang.InstantiationException), Splitter:B:9:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6 A[ExcHandler: IllegalAccessException (e java.lang.IllegalAccessException), PHI: r3 
      PHI: (r3v1 'classname' java.lang.String) = (r3v0 'classname' java.lang.String), (r3v0 'classname' java.lang.String), (r3v2 'classname' java.lang.String), (r3v2 'classname' java.lang.String), (r3v2 'classname' java.lang.String) binds: [B:9:0x0038, B:17:0x004f, B:24:0x0078, B:28:0x007f, B:25:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.security.PublicKey buildX509Key(sun.security.x509.AlgorithmId r19, sun.security.util.BitArray r20) throws java.io.IOException, java.security.InvalidKeyException {
        /*
            sun.security.util.DerOutputStream r14 = new sun.security.util.DerOutputStream
            r14.<init>()
            r0 = r19
            r1 = r20
            encode(r14, r0, r1)
            java.security.spec.X509EncodedKeySpec r15 = new java.security.spec.X509EncodedKeySpec
            byte[] r16 = r14.toByteArray()
            r15.<init>(r16)
            java.lang.String r16 = r19.getName()     // Catch:{ NoSuchAlgorithmException -> 0x0031, InvalidKeySpecException -> 0x0022 }
            java.security.KeyFactory r11 = java.security.KeyFactory.getInstance(r16)     // Catch:{ NoSuchAlgorithmException -> 0x0031, InvalidKeySpecException -> 0x0022 }
            java.security.PublicKey r16 = r11.generatePublic(r15)     // Catch:{ NoSuchAlgorithmException -> 0x0031, InvalidKeySpecException -> 0x0022 }
            return r16
        L_0x0022:
            r8 = move-exception
            java.security.InvalidKeyException r16 = new java.security.InvalidKeyException
            java.lang.String r17 = r8.getMessage()
            r0 = r16
            r1 = r17
            r0.<init>(r1, r8)
            throw r16
        L_0x0031:
            r7 = move-exception
            java.lang.String r3 = ""
            java.lang.String r16 = "SUN"
            java.security.Provider r13 = java.security.Security.getProvider(r16)     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            if (r13 != 0) goto L_0x004f
            java.lang.InstantiationException r16 = new java.lang.InstantiationException     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r16.<init>()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            throw r16     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
        L_0x0044:
            r4 = move-exception
        L_0x0045:
            sun.security.x509.X509Key r12 = new sun.security.x509.X509Key
            r0 = r19
            r1 = r20
            r12.<init>(r0, r1)
            return r12
        L_0x004f:
            java.lang.StringBuilder r16 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r16.<init>()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            java.lang.String r17 = "PublicKey.X.509."
            java.lang.StringBuilder r16 = r16.append((java.lang.String) r17)     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            java.lang.String r17 = r19.getName()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            java.lang.StringBuilder r16 = r16.append((java.lang.String) r17)     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            java.lang.String r16 = r16.toString()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r0 = r16
            java.lang.String r3 = r13.getProperty(r0)     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            if (r3 != 0) goto L_0x0077
            java.lang.InstantiationException r16 = new java.lang.InstantiationException     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r16.<init>()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            throw r16     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
        L_0x0075:
            r6 = move-exception
            goto L_0x0045
        L_0x0077:
            r10 = 0
            java.lang.Class r10 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x009a, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
        L_0x007c:
            r9 = 0
            if (r10 == 0) goto L_0x0083
            java.lang.Object r9 = r10.newInstance()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
        L_0x0083:
            boolean r0 = r9 instanceof sun.security.x509.X509Key     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r16 = r0
            if (r16 == 0) goto L_0x0045
            r0 = r9
            sun.security.x509.X509Key r0 = (sun.security.x509.X509Key) r0     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r12 = r0
            r0 = r19
            r12.algid = r0     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r0 = r20
            r12.setKey(r0)     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            r12.parseKeyBits()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            return r12
        L_0x009a:
            r4 = move-exception
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            if (r2 == 0) goto L_0x007c
            java.lang.Class r10 = r2.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x0075, IllegalAccessException -> 0x00a6 }
            goto L_0x007c
        L_0x00a6:
            r5 = move-exception
            java.io.IOException r16 = new java.io.IOException
            java.lang.StringBuilder r17 = new java.lang.StringBuilder
            r17.<init>()
            r0 = r17
            java.lang.StringBuilder r17 = r0.append((java.lang.String) r3)
            java.lang.String r18 = " [internal error]"
            java.lang.StringBuilder r17 = r17.append((java.lang.String) r18)
            java.lang.String r17 = r17.toString()
            r16.<init>((java.lang.String) r17)
            throw r16
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.X509Key.buildX509Key(sun.security.x509.AlgorithmId, sun.security.util.BitArray):java.security.PublicKey");
    }

    public String getAlgorithm() {
        return this.algid.getName();
    }

    public AlgorithmId getAlgorithmId() {
        return this.algid;
    }

    public final void encode(DerOutputStream out) throws IOException {
        encode(out, this.algid, getKey());
    }

    public byte[] getEncoded() {
        try {
            return (byte[]) getEncodedInternal().clone();
        } catch (InvalidKeyException e) {
            return null;
        }
    }

    public byte[] getEncodedInternal() throws InvalidKeyException {
        byte[] encoded = this.encodedKey;
        if (encoded == null) {
            try {
                DerOutputStream out = new DerOutputStream();
                encode(out);
                encoded = out.toByteArray();
                this.encodedKey = encoded;
            } catch (IOException e) {
                throw new InvalidKeyException("IOException : " + e.getMessage());
            }
        }
        return encoded;
    }

    public String getFormat() {
        return "X.509";
    }

    public byte[] encode() throws InvalidKeyException {
        return (byte[]) getEncodedInternal().clone();
    }

    public String toString() {
        return "algorithm = " + this.algid.toString() + ", unparsed keybits = \n" + new HexDumpEncoder().encodeBuffer(this.key);
    }

    public void decode(InputStream in) throws InvalidKeyException {
        try {
            DerValue val = new DerValue(in);
            if (val.tag != 48) {
                throw new InvalidKeyException("invalid key format");
            }
            this.algid = AlgorithmId.parse(val.data.getDerValue());
            setKey(val.data.getUnalignedBitString());
            parseKeyBits();
            if (val.data.available() != 0) {
                throw new InvalidKeyException("excess key data");
            }
        } catch (IOException e) {
            throw new InvalidKeyException("IOException: " + e.getMessage());
        }
    }

    public void decode(byte[] encodedKey2) throws InvalidKeyException {
        decode((InputStream) new ByteArrayInputStream(encodedKey2));
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.write(getEncoded());
    }

    private void readObject(ObjectInputStream stream) throws IOException {
        try {
            decode((InputStream) stream);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new IOException("deserialized key is invalid: " + e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        byte[] otherEncoded;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Key)) {
            return false;
        }
        try {
            byte[] thisEncoded = getEncodedInternal();
            if (obj instanceof X509Key) {
                otherEncoded = ((X509Key) obj).getEncodedInternal();
            } else {
                otherEncoded = ((Key) obj).getEncoded();
            }
            return Arrays.equals(thisEncoded, otherEncoded);
        } catch (InvalidKeyException e) {
            return false;
        }
    }

    public int hashCode() {
        try {
            byte[] b1 = getEncodedInternal();
            int r = b1.length;
            for (byte b : b1) {
                r += (b & Character.DIRECTIONALITY_UNDEFINED) * 37;
            }
            return r;
        } catch (InvalidKeyException e) {
            return 0;
        }
    }

    static void encode(DerOutputStream out, AlgorithmId algid2, BitArray key2) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        algid2.encode(tmp);
        tmp.putUnalignedBitString(key2);
        out.write((byte) 48, tmp);
    }
}
