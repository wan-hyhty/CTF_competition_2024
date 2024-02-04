package java.security.cert;

import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class CertPath implements Serializable {
    private static final long serialVersionUID = 6068470306649138683L;
    private String type;

    protected static class CertPathRep implements Serializable {
        private static final long serialVersionUID = 3015633072427920915L;
        private byte[] data;
        private String type;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.cert.CertPath.CertPathRep.<init>(java.lang.String, byte[]):void, dex: classes.dex
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
        protected CertPathRep(java.lang.String r1, byte[] r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.cert.CertPath.CertPathRep.<init>(java.lang.String, byte[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPath.CertPathRep.<init>(java.lang.String, byte[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPath.CertPathRep.readResolve():java.lang.Object, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPath.CertPathRep.readResolve():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPath.CertPathRep.readResolve():java.lang.Object");
        }
    }

    public abstract List<? extends Certificate> getCertificates();

    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract byte[] getEncoded(String str) throws CertificateEncodingException;

    public abstract Iterator<String> getEncodings();

    protected CertPath(String type2) {
        this.type = type2;
    }

    public String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CertPath)) {
            return false;
        }
        CertPath otherCP = (CertPath) other;
        if (!otherCP.getType().equals(this.type)) {
            return false;
        }
        return getCertificates().equals(otherCP.getCertificates());
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + getCertificates().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n" + this.type + " Cert Path: length = " + getCertificates().size() + ".\n");
        sb.append("[\n");
        int i = 1;
        for (Certificate stringCert : getCertificates()) {
            sb.append("=========================================================Certificate " + i + " start.\n");
            sb.append(stringCert.toString());
            sb.append("\n=========================================================Certificate " + i + " end.\n\n\n");
            i++;
        }
        sb.append("\n]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        try {
            return new CertPathRep(this.type, getEncoded());
        } catch (CertificateException ce) {
            NotSerializableException nse = new NotSerializableException("java.security.cert.CertPath: " + this.type);
            nse.initCause(ce);
            throw nse;
        }
    }
}
