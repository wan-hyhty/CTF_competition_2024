package java.security.spec;

import java.math.BigInteger;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class DSAPrivateKeySpec implements KeySpec {
    private BigInteger g;
    private BigInteger p;
    private BigInteger q;
    private BigInteger x;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.spec.DSAPrivateKeySpec.<init>(java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public DSAPrivateKeySpec(java.math.BigInteger r1, java.math.BigInteger r2, java.math.BigInteger r3, java.math.BigInteger r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.spec.DSAPrivateKeySpec.<init>(java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.spec.DSAPrivateKeySpec.<init>(java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.spec.DSAPrivateKeySpec.getG():java.math.BigInteger, dex: classes.dex
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
    public java.math.BigInteger getG() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.spec.DSAPrivateKeySpec.getG():java.math.BigInteger, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.spec.DSAPrivateKeySpec.getG():java.math.BigInteger");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.spec.DSAPrivateKeySpec.getP():java.math.BigInteger, dex: classes.dex
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
    public java.math.BigInteger getP() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.spec.DSAPrivateKeySpec.getP():java.math.BigInteger, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.spec.DSAPrivateKeySpec.getP():java.math.BigInteger");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.spec.DSAPrivateKeySpec.getQ():java.math.BigInteger, dex: classes.dex
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
    public java.math.BigInteger getQ() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.spec.DSAPrivateKeySpec.getQ():java.math.BigInteger, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.spec.DSAPrivateKeySpec.getQ():java.math.BigInteger");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.spec.DSAPrivateKeySpec.getX():java.math.BigInteger, dex: classes.dex in method: java.security.spec.DSAPrivateKeySpec.getX():java.math.BigInteger, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.spec.DSAPrivateKeySpec.getX():java.math.BigInteger, dex: classes.dex
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
    public java.math.BigInteger getX() {
        /*
        // Can't load method instructions: Load method exception: null in method: java.security.spec.DSAPrivateKeySpec.getX():java.math.BigInteger, dex: classes.dex in method: java.security.spec.DSAPrivateKeySpec.getX():java.math.BigInteger, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.spec.DSAPrivateKeySpec.getX():java.math.BigInteger");
    }
}
