package sun.security.internal.spec;

import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
@Deprecated
public class TlsKeyMaterialSpec implements KeySpec, SecretKey {
    static final long serialVersionUID = 812912859129525028L;
    private final SecretKey clientCipherKey;
    private final IvParameterSpec clientIv;
    private final SecretKey clientMacKey;
    private final SecretKey serverCipherKey;
    private final IvParameterSpec serverIv;
    private final SecretKey serverMacKey;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.<init>(javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec):void, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialSpec.<init>(javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.<init>(javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec):void, dex: classes.dex
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
    public TlsKeyMaterialSpec(javax.crypto.SecretKey r1, javax.crypto.SecretKey r2, javax.crypto.SecretKey r3, javax.crypto.spec.IvParameterSpec r4, javax.crypto.SecretKey r5, javax.crypto.spec.IvParameterSpec r6) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.<init>(javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec):void, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialSpec.<init>(javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialSpec.<init>(javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec, javax.crypto.SecretKey, javax.crypto.spec.IvParameterSpec):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getClientCipherKey():javax.crypto.SecretKey, dex: classes.dex
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
    public javax.crypto.SecretKey getClientCipherKey() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getClientCipherKey():javax.crypto.SecretKey, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialSpec.getClientCipherKey():javax.crypto.SecretKey");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getClientIv():javax.crypto.spec.IvParameterSpec, dex: classes.dex
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
    public javax.crypto.spec.IvParameterSpec getClientIv() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getClientIv():javax.crypto.spec.IvParameterSpec, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialSpec.getClientIv():javax.crypto.spec.IvParameterSpec");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getClientMacKey():javax.crypto.SecretKey, dex: classes.dex
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
    public javax.crypto.SecretKey getClientMacKey() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getClientMacKey():javax.crypto.SecretKey, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialSpec.getClientMacKey():javax.crypto.SecretKey");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerCipherKey():javax.crypto.SecretKey, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerCipherKey():javax.crypto.SecretKey, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerCipherKey():javax.crypto.SecretKey, dex: classes.dex
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
    public javax.crypto.SecretKey getServerCipherKey() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerCipherKey():javax.crypto.SecretKey, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerCipherKey():javax.crypto.SecretKey, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialSpec.getServerCipherKey():javax.crypto.SecretKey");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerIv():javax.crypto.spec.IvParameterSpec, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerIv():javax.crypto.spec.IvParameterSpec, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerIv():javax.crypto.spec.IvParameterSpec, dex: classes.dex
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
    public javax.crypto.spec.IvParameterSpec getServerIv() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerIv():javax.crypto.spec.IvParameterSpec, dex: classes.dex in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerIv():javax.crypto.spec.IvParameterSpec, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialSpec.getServerIv():javax.crypto.spec.IvParameterSpec");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerMacKey():javax.crypto.SecretKey, dex: classes.dex
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
    public javax.crypto.SecretKey getServerMacKey() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.internal.spec.TlsKeyMaterialSpec.getServerMacKey():javax.crypto.SecretKey, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.internal.spec.TlsKeyMaterialSpec.getServerMacKey():javax.crypto.SecretKey");
    }

    public TlsKeyMaterialSpec(SecretKey clientMacKey2, SecretKey serverMacKey2) {
        this(clientMacKey2, serverMacKey2, (SecretKey) null, (IvParameterSpec) null, (SecretKey) null, (IvParameterSpec) null);
    }

    public TlsKeyMaterialSpec(SecretKey clientMacKey2, SecretKey serverMacKey2, SecretKey clientCipherKey2, SecretKey serverCipherKey2) {
        this(clientMacKey2, serverMacKey2, clientCipherKey2, (IvParameterSpec) null, serverCipherKey2, (IvParameterSpec) null);
    }

    public String getAlgorithm() {
        return "TlsKeyMaterial";
    }

    public String getFormat() {
        return null;
    }

    public byte[] getEncoded() {
        return null;
    }
}
