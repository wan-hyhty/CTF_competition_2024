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
public class TlsMasterSecretParameterSpec implements AlgorithmParameterSpec {
    private final byte[] clientRandom;
    private final int majorVersion;
    private final int minorVersion;
    private final SecretKey premasterSecret;
    private final int prfBlockSize;
    private final String prfHashAlg;
    private final int prfHashLength;
    private final byte[] serverRandom;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.<init>(javax.crypto.SecretKey, int, int, byte[], byte[], java.lang.String, int, int):void, dex: classes.dex
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
    public TlsMasterSecretParameterSpec(javax.crypto.SecretKey r1, int r2, int r3, byte[] r4, byte[] r5, java.lang.String r6, int r7, int r8) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.<init>(javax.crypto.SecretKey, int, int, byte[], byte[], java.lang.String, int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.<init>(javax.crypto.SecretKey, int, int, byte[], byte[], java.lang.String, int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getClientRandom():byte[], dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getClientRandom():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getClientRandom():byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMajorVersion():int, dex: classes.dex in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMajorVersion():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMajorVersion():int, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public int getMajorVersion() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMajorVersion():int, dex: classes.dex in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMajorVersion():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMajorVersion():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMinorVersion():int, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMinorVersion():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getMinorVersion():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFBlockSize():int, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFBlockSize():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFBlockSize():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashAlg():java.lang.String, dex: classes.dex
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
    public java.lang.String getPRFHashAlg() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashAlg():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashAlg():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashLength():int, dex: classes.dex in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashLength():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashLength():int, dex: classes.dex
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
    public int getPRFHashLength() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashLength():int, dex: classes.dex in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashLength():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPRFHashLength():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPremasterSecret():javax.crypto.SecretKey, dex: classes.dex
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
    public javax.crypto.SecretKey getPremasterSecret() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPremasterSecret():javax.crypto.SecretKey, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getPremasterSecret():javax.crypto.SecretKey");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getServerRandom():byte[], dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsMasterSecretParameterSpec.getServerRandom():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsMasterSecretParameterSpec.getServerRandom():byte[]");
    }

    static int checkVersion(int version) {
        if (version >= 0 && version <= 255) {
            return version;
        }
        throw new IllegalArgumentException("Version must be between 0 and 255");
    }
}
