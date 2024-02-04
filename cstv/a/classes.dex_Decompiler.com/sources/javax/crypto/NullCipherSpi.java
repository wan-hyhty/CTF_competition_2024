package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.Key;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
final class NullCipherSpi extends CipherSpi {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.<init>():void, dex: classes.dex
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
    protected NullCipherSpi() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: javax.crypto.NullCipherSpi.engineDoFinal(byte[], int, int, byte[], int):int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ea
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    protected int engineDoFinal(byte[] r1, int r2, int r3, byte[] r4, int r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: javax.crypto.NullCipherSpi.engineDoFinal(byte[], int, int, byte[], int):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.engineDoFinal(byte[], int, int, byte[], int):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: javax.crypto.NullCipherSpi.engineDoFinal(byte[], int, int):byte[], dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    protected byte[] engineDoFinal(byte[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: javax.crypto.NullCipherSpi.engineDoFinal(byte[], int, int):byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.engineDoFinal(byte[], int, int):byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.AlgorithmParameters, java.security.SecureRandom):void, dex: classes.dex
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
    protected void engineInit(int r1, java.security.Key r2, java.security.AlgorithmParameters r3, java.security.SecureRandom r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.AlgorithmParameters, java.security.SecureRandom):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.AlgorithmParameters, java.security.SecureRandom):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.SecureRandom):void, dex: classes.dex
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
    protected void engineInit(int r1, java.security.Key r2, java.security.SecureRandom r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.SecureRandom):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.SecureRandom):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void, dex: classes.dex
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
    protected void engineInit(int r1, java.security.Key r2, java.security.spec.AlgorithmParameterSpec r3, java.security.SecureRandom r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineSetMode(java.lang.String):void, dex: classes.dex
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
    public void engineSetMode(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineSetMode(java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.engineSetMode(java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineSetPadding(java.lang.String):void, dex: classes.dex
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
    public void engineSetPadding(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.crypto.NullCipherSpi.engineSetPadding(java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.NullCipherSpi.engineSetPadding(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int inputLen) {
        return inputLen;
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        return new byte[8];
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        if (input == null) {
            return null;
        }
        byte[] x = new byte[inputLen];
        System.arraycopy(input, inputOffset, x, 0, inputLen);
        return x;
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) {
        if (input == null) {
            return 0;
        }
        System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        return inputLen;
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        return 0;
    }
}
