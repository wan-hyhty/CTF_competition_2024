package java.util.stream;

import java.util.Map;
import java.util.Spliterator;

/*  JADX ERROR: NullPointerException in pass: EnumVisitor
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
    */
public enum StreamOpFlag {
    ;
    
    private static final int CLEAR_BITS = 2;
    private static final int FLAG_MASK = 0;
    private static final int FLAG_MASK_IS = 0;
    private static final int FLAG_MASK_NOT = 0;
    public static final int INITIAL_OPS_VALUE = 0;
    public static final int IS_DISTINCT = 0;
    public static final int IS_ORDERED = 0;
    public static final int IS_SHORT_CIRCUIT = 0;
    public static final int IS_SIZED = 0;
    public static final int IS_SORTED = 0;
    public static final int NOT_DISTINCT = 0;
    public static final int NOT_ORDERED = 0;
    public static final int NOT_SIZED = 0;
    public static final int NOT_SORTED = 0;
    public static final int OP_MASK = 0;
    private static final int PRESERVE_BITS = 3;
    private static final int SET_BITS = 1;
    public static final int SPLITERATOR_CHARACTERISTICS_MASK = 0;
    public static final int STREAM_MASK = 0;
    public static final int TERMINAL_OP_MASK = 0;
    public static final int UPSTREAM_TERMINAL_OP_MASK = 0;
    private final int bitPosition;
    private final int clear;
    private final Map<Type, Integer> maskTable;
    private final int preserve;
    private final int set;

    private static class MaskBuilder {
        final Map<Type, Integer> map;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamOpFlag.MaskBuilder.<init>(java.util.Map):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        MaskBuilder(java.util.Map<java.util.stream.StreamOpFlag.Type, java.lang.Integer> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamOpFlag.MaskBuilder.<init>(java.util.Map):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.MaskBuilder.<init>(java.util.Map):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.MaskBuilder.build():java.util.Map<java.util.stream.StreamOpFlag$Type, java.lang.Integer>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        java.util.Map<java.util.stream.StreamOpFlag.Type, java.lang.Integer> build() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.MaskBuilder.build():java.util.Map<java.util.stream.StreamOpFlag$Type, java.lang.Integer>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.MaskBuilder.build():java.util.Map");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.MaskBuilder.clear(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        java.util.stream.StreamOpFlag.MaskBuilder clear(java.util.stream.StreamOpFlag.Type r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.MaskBuilder.clear(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.MaskBuilder.clear(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.MaskBuilder.mask(java.util.stream.StreamOpFlag$Type, java.lang.Integer):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        java.util.stream.StreamOpFlag.MaskBuilder mask(java.util.stream.StreamOpFlag.Type r1, java.lang.Integer r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.MaskBuilder.mask(java.util.stream.StreamOpFlag$Type, java.lang.Integer):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.MaskBuilder.mask(java.util.stream.StreamOpFlag$Type, java.lang.Integer):java.util.stream.StreamOpFlag$MaskBuilder");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.MaskBuilder.set(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        java.util.stream.StreamOpFlag.MaskBuilder set(java.util.stream.StreamOpFlag.Type r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.MaskBuilder.set(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.MaskBuilder.set(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.MaskBuilder.setAndClear(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        java.util.stream.StreamOpFlag.MaskBuilder setAndClear(java.util.stream.StreamOpFlag.Type r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.MaskBuilder.setAndClear(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.MaskBuilder.setAndClear(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.<init>(java.lang.String, int, int, java.util.stream.StreamOpFlag$MaskBuilder):void, dex: classes.dex
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
    private StreamOpFlag(int r3, java.util.stream.StreamOpFlag.MaskBuilder r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.<init>(java.lang.String, int, int, java.util.stream.StreamOpFlag$MaskBuilder):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.<init>(java.lang.String, int, int, java.util.stream.StreamOpFlag$MaskBuilder):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.createFlagMask():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private static int createFlagMask() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.createFlagMask():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.createFlagMask():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.createMask(java.util.stream.StreamOpFlag$Type):int, dex: classes.dex
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
    private static int createMask(java.util.stream.StreamOpFlag.Type r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.createMask(java.util.stream.StreamOpFlag$Type):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.createMask(java.util.stream.StreamOpFlag$Type):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.set(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
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
    private static java.util.stream.StreamOpFlag.MaskBuilder set(java.util.stream.StreamOpFlag.Type r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamOpFlag.set(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.set(java.util.stream.StreamOpFlag$Type):java.util.stream.StreamOpFlag$MaskBuilder");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.canSet(java.util.stream.StreamOpFlag$Type):boolean, dex: classes.dex
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
    public boolean canSet(java.util.stream.StreamOpFlag.Type r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.canSet(java.util.stream.StreamOpFlag$Type):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.canSet(java.util.stream.StreamOpFlag$Type):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamOpFlag.clear():int, dex: classes.dex in method: java.util.stream.StreamOpFlag.clear():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamOpFlag.clear():int, dex: classes.dex
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
    public int clear() {
        /*
        // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamOpFlag.clear():int, dex: classes.dex in method: java.util.stream.StreamOpFlag.clear():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.clear():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.isCleared(int):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public boolean isCleared(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.isCleared(int):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.isCleared(int):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.isKnown(int):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public boolean isKnown(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.isKnown(int):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.isKnown(int):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.isPreserved(int):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public boolean isPreserved(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.isPreserved(int):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.isPreserved(int):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.isStreamFlag():boolean, dex: classes.dex
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
    public boolean isStreamFlag() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamOpFlag.isStreamFlag():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.isStreamFlag():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.set():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public int set() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamOpFlag.set():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.set():int");
    }

    enum Type {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type OP = null;
        public static final Type SPLITERATOR = null;
        public static final Type STREAM = null;
        public static final Type TERMINAL_OP = null;
        public static final Type UPSTREAM_TERMINAL_OP = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamOpFlag.Type.<init>(java.lang.String, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        private Type(java.lang.String r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamOpFlag.Type.<init>(java.lang.String, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamOpFlag.Type.<init>(java.lang.String, int):void");
        }

        public static Type valueOf(String name) {
            return (Type) Enum.valueOf(Type.class, name);
        }

        public static Type[] values() {
            return $VALUES;
        }
    }

    private static int getMask(int flags) {
        if (flags == 0) {
            return FLAG_MASK;
        }
        return ~(((FLAG_MASK_IS & flags) << 1) | flags | ((FLAG_MASK_NOT & flags) >> 1));
    }

    public static int combineOpFlags(int newStreamOrOpFlags, int prevCombOpFlags) {
        return (getMask(newStreamOrOpFlags) & prevCombOpFlags) | newStreamOrOpFlags;
    }

    public static int toStreamFlags(int combOpFlags) {
        return ((~combOpFlags) >> 1) & FLAG_MASK_IS & combOpFlags;
    }

    public static int toCharacteristics(int streamFlags) {
        return SPLITERATOR_CHARACTERISTICS_MASK & streamFlags;
    }

    public static int fromCharacteristics(Spliterator<?> spliterator) {
        int characteristics = spliterator.characteristics();
        if ((characteristics & 4) == 0 || spliterator.getComparator() == null) {
            return SPLITERATOR_CHARACTERISTICS_MASK & characteristics;
        }
        return SPLITERATOR_CHARACTERISTICS_MASK & characteristics & -5;
    }

    public static int fromCharacteristics(int characteristics) {
        return SPLITERATOR_CHARACTERISTICS_MASK & characteristics;
    }
}
