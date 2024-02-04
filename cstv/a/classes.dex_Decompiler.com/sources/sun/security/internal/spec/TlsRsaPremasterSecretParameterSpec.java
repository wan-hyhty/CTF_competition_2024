package sun.security.internal.spec;

import java.security.spec.AlgorithmParameterSpec;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
@Deprecated
public class TlsRsaPremasterSecretParameterSpec implements AlgorithmParameterSpec {
    private final int majorVersion;
    private final int minorVersion;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.<init>(int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public TlsRsaPremasterSecretParameterSpec(int r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.<init>(int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.<init>(int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.getMajorVersion():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public int getMajorVersion() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.getMajorVersion():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.getMajorVersion():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.getMinorVersion():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public int getMinorVersion() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.getMinorVersion():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsRsaPremasterSecretParameterSpec.getMinorVersion():int");
    }
}
