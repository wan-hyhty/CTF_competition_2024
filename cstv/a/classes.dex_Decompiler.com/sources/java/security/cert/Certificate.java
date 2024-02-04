package java.security.cert;

import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;
import sun.security.x509.X509CertImpl;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class Certificate implements Serializable {
    private static final long serialVersionUID = -3585440601605666277L;
    private final String type;

    protected static class CertificateRep implements Serializable {
        private static final long serialVersionUID = -8563758940495660020L;
        private byte[] data;
        private String type;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.cert.Certificate.CertificateRep.<init>(java.lang.String, byte[]):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        protected CertificateRep(java.lang.String r1, byte[] r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.cert.Certificate.CertificateRep.<init>(java.lang.String, byte[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.cert.Certificate.CertificateRep.<init>(java.lang.String, byte[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.Certificate.CertificateRep.readResolve():java.lang.Object, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        protected java.lang.Object readResolve() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.Certificate.CertificateRep.readResolve():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.cert.Certificate.CertificateRep.readResolve():java.lang.Object");
        }
    }

    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract PublicKey getPublicKey();

    public abstract String toString();

    public abstract void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    protected Certificate(String type2) {
        this.type = type2;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Certificate)) {
            return false;
        }
        try {
            return Arrays.equals(X509CertImpl.getEncodedInternal(this), X509CertImpl.getEncodedInternal((Certificate) other));
        } catch (CertificateException e) {
            return false;
        }
    }

    public int hashCode() {
        int retval = 0;
        try {
            byte[] certData = X509CertImpl.getEncodedInternal(this);
            for (int i = 1; i < certData.length; i++) {
                retval += certData[i] * i;
            }
            return retval;
        } catch (CertificateException e) {
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        try {
            return new CertificateRep(this.type, getEncoded());
        } catch (CertificateException e) {
            throw new NotSerializableException("java.security.cert.Certificate: " + this.type + ": " + e.getMessage());
        }
    }
}
