package sun.security.internal.spec;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
@Deprecated
public class TlsKeyMaterialParameterSpec implements AlgorithmParameterSpec {
    private final String cipherAlgorithm;
    private final int cipherKeyLength;
    private final byte[] clientRandom;
    private final int expandedCipherKeyLength;
    private final int ivLength;
    private final int macKeyLength;
    private final int majorVersion;
    private final SecretKey masterSecret;
    private final int minorVersion;
    private final int prfBlockSize;
    private final String prfHashAlg;
    private final int prfHashLength;
    private final byte[] serverRandom;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.<init>(javax.crypto.SecretKey, int, int, byte[], byte[], java.lang.String, int, int, int, int, java.lang.String, int, int):void, dex: classes.dex
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
    public TlsKeyMaterialParameterSpec(javax.crypto.SecretKey r1, int r2, int r3, byte[] r4, byte[] r5, java.lang.String r6, int r7, int r8, int r9, int r10, java.lang.String r11, int r12, int r13) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.<init>(javax.crypto.SecretKey, int, int, byte[], byte[], java.lang.String, int, int, int, int, java.lang.String, int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.<init>(javax.crypto.SecretKey, int, int, byte[], byte[], java.lang.String, int, int, int, int, java.lang.String, int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getCipherAlgorithm():java.lang.String, dex: classes.dex
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
    public java.lang.String getCipherAlgorithm() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getCipherAlgorithm():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getCipherAlgorithm():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getCipherKeyLength():int, dex: classes.dex
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
    public int getCipherKeyLength() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getCipherKeyLength():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getCipherKeyLength():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getClientRandom():byte[], dex: classes.dex
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
    public byte[] getClientRandom() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getClientRandom():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getClientRandom():byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getExpandedCipherKeyLength():int, dex: classes.dex
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
    public int getExpandedCipherKeyLength() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getExpandedCipherKeyLength():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getExpandedCipherKeyLength():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getIvLength():int, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getIvLength():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getIvLength():int, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
        	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public int getIvLength() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getIvLength():int, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getIvLength():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getIvLength():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMacKeyLength():int, dex: classes.dex
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
    public int getMacKeyLength() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMacKeyLength():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMacKeyLength():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMajorVersion():int, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMajorVersion():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMajorVersion():int, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$23.decode(InstructionCodec.java:514)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public int getMajorVersion() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMajorVersion():int, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMajorVersion():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMajorVersion():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMasterSecret():javax.crypto.SecretKey, dex: classes.dex
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
    public javax.crypto.SecretKey getMasterSecret() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMasterSecret():javax.crypto.SecretKey, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMasterSecret():javax.crypto.SecretKey");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMinorVersion():int, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMinorVersion():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getMinorVersion():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFBlockSize():int, dex: classes.dex
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
    public int getPRFBlockSize() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFBlockSize():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFBlockSize():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashAlg():java.lang.String, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashAlg():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashAlg():java.lang.String, dex: classes.dex
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
    public java.lang.String getPRFHashAlg() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashAlg():java.lang.String, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashAlg():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashAlg():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashLength():int, dex: classes.dex
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
    public int getPRFHashLength() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashLength():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getPRFHashLength():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getServerRandom():byte[], dex: classes.dex
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
    public byte[] getServerRandom() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getServerRandom():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialParameterSpec.getServerRandom():byte[]");
    }

    private static int checkSign(int k) {
        if (k >= 0) {
            return k;
        }
        throw new IllegalArgumentException("Value must not be negative");
    }
}
