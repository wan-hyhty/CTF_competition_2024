package sun.nio.ch;

import java.nio.ByteBuffer;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class IOVecWrapper {
    private static final int BASE_OFFSET = 0;
    private static final int LEN_OFFSET = 0;
    private static final int SIZE_IOVEC = 0;
    static int addressSize;
    private static final ThreadLocal<IOVecWrapper> cached = null;
    final long address;
    private final ByteBuffer[] buf;
    private final int[] position;
    private final int[] remaining;
    private final ByteBuffer[] shadow;
    private final int size;
    private final AllocatedNativeObject vecArray;

    private static class Deallocator implements Runnable {
        private final AllocatedNativeObject obj;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.IOVecWrapper.Deallocator.<init>(sun.nio.ch.AllocatedNativeObject):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        Deallocator(sun.nio.ch.AllocatedNativeObject r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.IOVecWrapper.Deallocator.<init>(sun.nio.ch.AllocatedNativeObject):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.Deallocator.<init>(sun.nio.ch.AllocatedNativeObject):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.Deallocator.run():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void run() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.Deallocator.run():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.Deallocator.run():void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.nio.ch.IOVecWrapper.<init>(int):void, dex: classes.dex
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
    private IOVecWrapper(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.nio.ch.IOVecWrapper.<init>(int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.<init>(int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.IOVecWrapper.get(int):sun.nio.ch.IOVecWrapper, dex: classes.dex
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
    static sun.nio.ch.IOVecWrapper get(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.IOVecWrapper.get(int):sun.nio.ch.IOVecWrapper, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.get(int):sun.nio.ch.IOVecWrapper");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus element_width: 20e5 in method: sun.nio.ch.IOVecWrapper.clearRefs(int):void, dex: classes.dex in method: sun.nio.ch.IOVecWrapper.clearRefs(int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: bogus element_width: 20e5 in method: sun.nio.ch.IOVecWrapper.clearRefs(int):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: com.android.dex.DexException: bogus element_width: 20e5
        	at com.android.dx.io.instructions.InstructionCodec$36.decode(InstructionCodec.java:871)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    void clearRefs(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus element_width: 20e5 in method: sun.nio.ch.IOVecWrapper.clearRefs(int):void, dex: classes.dex in method: sun.nio.ch.IOVecWrapper.clearRefs(int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.clearRefs(int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.nio.ch.IOVecWrapper.getBuffer(int):java.nio.ByteBuffer, dex: classes.dex in method: sun.nio.ch.IOVecWrapper.getBuffer(int):java.nio.ByteBuffer, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.nio.ch.IOVecWrapper.getBuffer(int):java.nio.ByteBuffer, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:61)
        	at com.android.dx.io.instructions.InstructionCodec$35.decode(InstructionCodec.java:790)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    java.nio.ByteBuffer getBuffer(int r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.nio.ch.IOVecWrapper.getBuffer(int):java.nio.ByteBuffer, dex: classes.dex in method: sun.nio.ch.IOVecWrapper.getBuffer(int):java.nio.ByteBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.getBuffer(int):java.nio.ByteBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.getPosition(int):int, dex: classes.dex
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
    int getPosition(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.getPosition(int):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.getPosition(int):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.getRemaining(int):int, dex: classes.dex
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
    int getRemaining(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.getRemaining(int):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.getRemaining(int):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.getShadow(int):java.nio.ByteBuffer, dex: classes.dex
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
    java.nio.ByteBuffer getShadow(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.getShadow(int):java.nio.ByteBuffer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.getShadow(int):java.nio.ByteBuffer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.putBase(int, long):void, dex: classes.dex
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
    void putBase(int r1, long r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.putBase(int, long):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.putBase(int, long):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.putLen(int, long):void, dex: classes.dex
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
    void putLen(int r1, long r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.putLen(int, long):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.putLen(int, long):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.nio.ch.IOVecWrapper.setBuffer(int, java.nio.ByteBuffer, int, int):void, dex: classes.dex in method: sun.nio.ch.IOVecWrapper.setBuffer(int, java.nio.ByteBuffer, int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.nio.ch.IOVecWrapper.setBuffer(int, java.nio.ByteBuffer, int, int):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:61)
        	at com.android.dx.io.instructions.InstructionCodec$35.decode(InstructionCodec.java:790)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    void setBuffer(int r1, java.nio.ByteBuffer r2, int r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.nio.ch.IOVecWrapper.setBuffer(int, java.nio.ByteBuffer, int, int):void, dex: classes.dex in method: sun.nio.ch.IOVecWrapper.setBuffer(int, java.nio.ByteBuffer, int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.setBuffer(int, java.nio.ByteBuffer, int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.setShadow(int, java.nio.ByteBuffer):void, dex: classes.dex
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
    void setShadow(int r1, java.nio.ByteBuffer r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.IOVecWrapper.setShadow(int, java.nio.ByteBuffer):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.IOVecWrapper.setShadow(int, java.nio.ByteBuffer):void");
    }
}
