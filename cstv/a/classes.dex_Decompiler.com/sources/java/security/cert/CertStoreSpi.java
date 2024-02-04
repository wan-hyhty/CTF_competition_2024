package java.security.cert;

import java.util.Collection;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class CertStoreSpi {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.cert.CertStoreSpi.<init>(java.security.cert.CertStoreParameters):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public CertStoreSpi(java.security.cert.CertStoreParameters r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.cert.CertStoreSpi.<init>(java.security.cert.CertStoreParameters):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertStoreSpi.<init>(java.security.cert.CertStoreParameters):void");
    }

    public abstract Collection<? extends CRL> engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException;

    public abstract Collection<? extends Certificate> engineGetCertificates(CertSelector certSelector) throws CertStoreException;
}
