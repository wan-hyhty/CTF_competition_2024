package java.security.cert;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class PKIXCertPathBuilderResult extends PKIXCertPathValidatorResult implements CertPathBuilderResult {
    private CertPath certPath;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.cert.PKIXCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey):void, dex: classes.dex in method: java.security.cert.PKIXCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.cert.PKIXCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public PKIXCertPathBuilderResult(java.security.cert.CertPath r1, java.security.cert.TrustAnchor r2, java.security.cert.PolicyNode r3, java.security.PublicKey r4) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.security.cert.PKIXCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey):void, dex: classes.dex in method: java.security.cert.PKIXCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.PKIXCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.cert.PKIXCertPathBuilderResult.getCertPath():java.security.cert.CertPath, dex: classes.dex in method: java.security.cert.PKIXCertPathBuilderResult.getCertPath():java.security.cert.CertPath, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.cert.PKIXCertPathBuilderResult.getCertPath():java.security.cert.CertPath, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public java.security.cert.CertPath getCertPath() {
        /*
        // Can't load method instructions: Load method exception: null in method: java.security.cert.PKIXCertPathBuilderResult.getCertPath():java.security.cert.CertPath, dex: classes.dex in method: java.security.cert.PKIXCertPathBuilderResult.getCertPath():java.security.cert.CertPath, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.PKIXCertPathBuilderResult.getCertPath():java.security.cert.CertPath");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.PKIXCertPathBuilderResult.toString():java.lang.String, dex: classes.dex
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
    public java.lang.String toString() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.PKIXCertPathBuilderResult.toString():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.PKIXCertPathBuilderResult.toString():java.lang.String");
    }
}
