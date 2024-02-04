package java.nio;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
class HeapShortBuffer extends ShortBuffer {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.nio.HeapShortBuffer.<init>(int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    HeapShortBuffer(int r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.nio.HeapShortBuffer.<init>(int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.<init>(int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.nio.HeapShortBuffer.<init>(int, int, boolean):void, dex: classes.dex in method: java.nio.HeapShortBuffer.<init>(int, int, boolean):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.nio.HeapShortBuffer.<init>(int, int, boolean):void, dex: classes.dex
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
    HeapShortBuffer(int r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.nio.HeapShortBuffer.<init>(int, int, boolean):void, dex: classes.dex in method: java.nio.HeapShortBuffer.<init>(int, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.<init>(int, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.nio.HeapShortBuffer.<init>(short[], int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    HeapShortBuffer(short[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.nio.HeapShortBuffer.<init>(short[], int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.<init>(short[], int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    protected HeapShortBuffer(short[] r1, int r2, int r3, int r4, int r5, int r6) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int, boolean):void, dex: classes.dex in method: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int, boolean):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int, boolean):void, dex: classes.dex
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
    protected HeapShortBuffer(short[] r1, int r2, int r3, int r4, int r5, int r6, boolean r7) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int, boolean):void, dex: classes.dex in method: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.<init>(short[], int, int, int, int, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.nio.HeapShortBuffer.<init>(short[], int, int, boolean):void, dex: classes.dex in method: java.nio.HeapShortBuffer.<init>(short[], int, int, boolean):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.nio.HeapShortBuffer.<init>(short[], int, int, boolean):void, dex: classes.dex
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
    HeapShortBuffer(short[] r1, int r2, int r3, boolean r4) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.nio.HeapShortBuffer.<init>(short[], int, int, boolean):void, dex: classes.dex in method: java.nio.HeapShortBuffer.<init>(short[], int, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.<init>(short[], int, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.asReadOnlyBuffer():java.nio.ShortBuffer, dex: classes.dex
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
    public java.nio.ShortBuffer asReadOnlyBuffer() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.asReadOnlyBuffer():java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.asReadOnlyBuffer():java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.compact():java.nio.ShortBuffer, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.nio.ShortBuffer compact() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.compact():java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.compact():java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.duplicate():java.nio.ShortBuffer, dex: classes.dex
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
    public java.nio.ShortBuffer duplicate() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.duplicate():java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.duplicate():java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.nio.HeapShortBuffer.get(short[], int, int):java.nio.ShortBuffer, dex: classes.dex
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
    public java.nio.ShortBuffer get(short[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.nio.HeapShortBuffer.get(short[], int, int):java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.get(short[], int, int):java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.get():short, dex: classes.dex
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
    public short get() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.get():short, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.get():short");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.get(int):short, dex: classes.dex
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
    public short get(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.get(int):short, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.get(int):short");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.nio.HeapShortBuffer.isReadOnly():boolean, dex: classes.dex in method: java.nio.HeapShortBuffer.isReadOnly():boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.nio.HeapShortBuffer.isReadOnly():boolean, dex: classes.dex
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
    public boolean isReadOnly() {
        /*
        // Can't load method instructions: Load method exception: null in method: java.nio.HeapShortBuffer.isReadOnly():boolean, dex: classes.dex in method: java.nio.HeapShortBuffer.isReadOnly():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.isReadOnly():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.nio.HeapShortBuffer.ix(int):int, dex: classes.dex
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
    protected int ix(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.nio.HeapShortBuffer.ix(int):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.ix(int):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.put(int, short):java.nio.ShortBuffer, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.nio.ShortBuffer put(int r1, short r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.put(int, short):java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.put(int, short):java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.nio.HeapShortBuffer.put(java.nio.ShortBuffer):java.nio.ShortBuffer, dex: classes.dex in method: java.nio.HeapShortBuffer.put(java.nio.ShortBuffer):java.nio.ShortBuffer, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.nio.HeapShortBuffer.put(java.nio.ShortBuffer):java.nio.ShortBuffer, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterRange(InstructionCodec.java:985)
        	at com.android.dx.io.instructions.InstructionCodec.access$1100(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$28.decode(InstructionCodec.java:611)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public java.nio.ShortBuffer put(java.nio.ShortBuffer r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.nio.HeapShortBuffer.put(java.nio.ShortBuffer):java.nio.ShortBuffer, dex: classes.dex in method: java.nio.HeapShortBuffer.put(java.nio.ShortBuffer):java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.put(java.nio.ShortBuffer):java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.put(short):java.nio.ShortBuffer, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.nio.ShortBuffer put(short r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.put(short):java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.put(short):java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.put(short[], int, int):java.nio.ShortBuffer, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.nio.ShortBuffer put(short[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.nio.HeapShortBuffer.put(short[], int, int):java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.put(short[], int, int):java.nio.ShortBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.slice():java.nio.ShortBuffer, dex: classes.dex
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
    public java.nio.ShortBuffer slice() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.HeapShortBuffer.slice():java.nio.ShortBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.HeapShortBuffer.slice():java.nio.ShortBuffer");
    }

    public boolean isDirect() {
        return false;
    }

    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }
}
