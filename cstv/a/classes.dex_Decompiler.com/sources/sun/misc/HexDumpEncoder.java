package sun.misc;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class HexDumpEncoder extends CharacterEncoder {
    private int currentByte;
    private int offset;
    private byte[] thisLine;
    private int thisLineLength;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.HexDumpEncoder.hexDigit(java.io.PrintStream, byte):void, dex: classes.dex
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
    static void hexDigit(java.io.PrintStream r1, byte r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.HexDumpEncoder.hexDigit(java.io.PrintStream, byte):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.HexDumpEncoder.hexDigit(java.io.PrintStream, byte):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.HexDumpEncoder.encodeAtom(java.io.OutputStream, byte[], int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    protected void encodeAtom(java.io.OutputStream r1, byte[] r2, int r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.HexDumpEncoder.encodeAtom(java.io.OutputStream, byte[], int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.HexDumpEncoder.encodeAtom(java.io.OutputStream, byte[], int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.misc.HexDumpEncoder.encodeBufferPrefix(java.io.OutputStream):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    protected void encodeBufferPrefix(java.io.OutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.misc.HexDumpEncoder.encodeBufferPrefix(java.io.OutputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.HexDumpEncoder.encodeBufferPrefix(java.io.OutputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.misc.HexDumpEncoder.encodeLinePrefix(java.io.OutputStream, int):void, dex: classes.dex in method: sun.misc.HexDumpEncoder.encodeLinePrefix(java.io.OutputStream, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.misc.HexDumpEncoder.encodeLinePrefix(java.io.OutputStream, int):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    protected void encodeLinePrefix(java.io.OutputStream r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.misc.HexDumpEncoder.encodeLinePrefix(java.io.OutputStream, int):void, dex: classes.dex in method: sun.misc.HexDumpEncoder.encodeLinePrefix(java.io.OutputStream, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.HexDumpEncoder.encodeLinePrefix(java.io.OutputStream, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.misc.HexDumpEncoder.encodeLineSuffix(java.io.OutputStream):void, dex: classes.dex in method: sun.misc.HexDumpEncoder.encodeLineSuffix(java.io.OutputStream):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.misc.HexDumpEncoder.encodeLineSuffix(java.io.OutputStream):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    protected void encodeLineSuffix(java.io.OutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.misc.HexDumpEncoder.encodeLineSuffix(java.io.OutputStream):void, dex: classes.dex in method: sun.misc.HexDumpEncoder.encodeLineSuffix(java.io.OutputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.HexDumpEncoder.encodeLineSuffix(java.io.OutputStream):void");
    }

    /* access modifiers changed from: protected */
    public int bytesPerAtom() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int bytesPerLine() {
        return 16;
    }
}
