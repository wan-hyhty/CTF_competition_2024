package java.security.cert;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Date;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.x509.X509CRLImpl;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class X509CRL extends CRL implements X509Extension {
    private transient X500Principal issuerPrincipal;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.cert.X509CRL.<init>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    protected X509CRL() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.cert.X509CRL.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.X509CRL.<init>():void");
    }

    public abstract byte[] getEncoded() throws CRLException;

    public abstract Principal getIssuerDN();

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.X509CRL.getIssuerX500Principal():javax.security.auth.x500.X500Principal, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.X509CRL.getIssuerX500Principal():javax.security.auth.x500.X500Principal, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.X509CRL.getIssuerX500Principal():javax.security.auth.x500.X500Principal");
    }

    public abstract Date getNextUpdate();

    public abstract X509CRLEntry getRevokedCertificate(BigInteger bigInteger);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.X509CRL.getRevokedCertificate(java.security.cert.X509Certificate):java.security.cert.X509CRLEntry, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.security.cert.X509CRLEntry getRevokedCertificate(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.X509CRL.getRevokedCertificate(java.security.cert.X509Certificate):java.security.cert.X509CRLEntry, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.X509CRL.getRevokedCertificate(java.security.cert.X509Certificate):java.security.cert.X509CRLEntry");
    }

    public abstract Set<? extends X509CRLEntry> getRevokedCertificates();

    public abstract String getSigAlgName();

    public abstract String getSigAlgOID();

    public abstract byte[] getSigAlgParams();

    public abstract byte[] getSignature();

    public abstract byte[] getTBSCertList() throws CRLException;

    public abstract Date getThisUpdate();

    public abstract int getVersion();

    public abstract void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    /* JADX WARNING: type inference failed for: r6v0, types: [java.security.cert.X509CRL, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 0
            if (r5 != r6) goto L_0x0005
            r3 = 1
            return r3
        L_0x0005:
            boolean r3 = r6 instanceof java.security.cert.X509CRL
            if (r3 != 0) goto L_0x000a
            return r4
        L_0x000a:
            byte[] r2 = sun.security.x509.X509CRLImpl.getEncodedInternal(r5)     // Catch:{ CRLException -> 0x0019 }
            byte[] r1 = sun.security.x509.X509CRLImpl.getEncodedInternal(r6)     // Catch:{ CRLException -> 0x0019 }
            boolean r3 = java.util.Arrays.equals((byte[]) r2, (byte[]) r1)     // Catch:{ CRLException -> 0x0019 }
            return r3
        L_0x0019:
            r0 = move-exception
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.X509CRL.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int retval = 0;
        try {
            byte[] crlData = X509CRLImpl.getEncodedInternal(this);
            for (int i = 1; i < crlData.length; i++) {
                retval += crlData[i] * i;
            }
            return retval;
        } catch (CRLException e) {
            return 0;
        }
    }
}
