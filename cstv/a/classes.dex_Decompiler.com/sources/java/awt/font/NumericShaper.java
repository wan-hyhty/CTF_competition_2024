package java.awt.font;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public final class NumericShaper implements Serializable {
    public static final int ALL_RANGES = 524287;
    public static final int ARABIC = 2;
    private static final int ARABIC_KEY = 1;
    public static final int BENGALI = 16;
    private static final int BENGALI_KEY = 4;
    private static final int BSEARCH_THRESHOLD = 3;
    private static final int CONTEXTUAL_MASK = Integer.MIN_VALUE;
    public static final int DEVANAGARI = 8;
    private static final int DEVANAGARI_KEY = 3;
    public static final int EASTERN_ARABIC = 4;
    private static final int EASTERN_ARABIC_KEY = 2;
    public static final int ETHIOPIC = 65536;
    private static final int ETHIOPIC_KEY = 16;
    public static final int EUROPEAN = 1;
    private static final int EUROPEAN_KEY = 0;
    public static final int GUJARATI = 64;
    private static final int GUJARATI_KEY = 6;
    public static final int GURMUKHI = 32;
    private static final int GURMUKHI_KEY = 5;
    public static final int KANNADA = 1024;
    private static final int KANNADA_KEY = 10;
    public static final int KHMER = 131072;
    private static final int KHMER_KEY = 17;
    public static final int LAO = 8192;
    private static final int LAO_KEY = 13;
    public static final int MALAYALAM = 2048;
    private static final int MALAYALAM_KEY = 11;
    public static final int MONGOLIAN = 262144;
    private static final int MONGOLIAN_KEY = 18;
    public static final int MYANMAR = 32768;
    private static final int MYANMAR_KEY = 15;
    private static final int NUM_KEYS = 19;
    public static final int ORIYA = 128;
    private static final int ORIYA_KEY = 7;
    public static final int TAMIL = 256;
    private static final int TAMIL_KEY = 8;
    public static final int TELUGU = 512;
    private static final int TELUGU_KEY = 9;
    public static final int THAI = 4096;
    private static final int THAI_KEY = 12;
    public static final int TIBETAN = 16384;
    private static final int TIBETAN_KEY = 14;
    private static final char[] bases = null;
    private static final char[] contexts = null;
    private static int ctCache = 0;
    private static int ctCacheLimit = 0;
    private static final long serialVersionUID = -8022764705923730308L;
    private static int[] strongTable;
    private volatile transient Range currentRange;
    private int key;
    private int mask;
    private transient Range[] rangeArray;
    private transient Set<Range> rangeSet;
    private Range shapingRange;
    private volatile transient int stCache;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.awt.font.NumericShaper.<clinit>():void, dex: classes.dex
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.awt.font.NumericShaper.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.<clinit>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.awt.font.NumericShaper.<init>(int, int):void, dex: classes.dex in method: java.awt.font.NumericShaper.<init>(int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.awt.font.NumericShaper.<init>(int, int):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    private NumericShaper(int r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.awt.font.NumericShaper.<init>(int, int):void, dex: classes.dex in method: java.awt.font.NumericShaper.<init>(int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.<init>(int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.awt.font.NumericShaper.<init>(java.awt.font.NumericShaper$Range, java.util.Set):void, dex: classes.dex
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
    private NumericShaper(java.awt.font.NumericShaper.Range r1, java.util.Set<java.awt.font.NumericShaper.Range> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.awt.font.NumericShaper.<init>(java.awt.font.NumericShaper$Range, java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.<init>(java.awt.font.NumericShaper$Range, java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.checkParams(char[], int, int):void, dex: classes.dex
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
    private void checkParams(char[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.checkParams(char[], int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.checkParams(char[], int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: java.awt.font.NumericShaper.getContextualShaper(java.util.Set):java.awt.font.NumericShaper, dex: classes.dex
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
    public static java.awt.font.NumericShaper getContextualShaper(java.util.Set<java.awt.font.NumericShaper.Range> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: java.awt.font.NumericShaper.getContextualShaper(java.util.Set):java.awt.font.NumericShaper, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.getContextualShaper(java.util.Set):java.awt.font.NumericShaper");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: java.awt.font.NumericShaper.getContextualShaper(java.util.Set, java.awt.font.NumericShaper$Range):java.awt.font.NumericShaper, dex: classes.dex
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
    public static java.awt.font.NumericShaper getContextualShaper(java.util.Set<java.awt.font.NumericShaper.Range> r1, java.awt.font.NumericShaper.Range r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: java.awt.font.NumericShaper.getContextualShaper(java.util.Set, java.awt.font.NumericShaper$Range):java.awt.font.NumericShaper, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.getContextualShaper(java.util.Set, java.awt.font.NumericShaper$Range):java.awt.font.NumericShaper");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.getKeyFromMask(int):int, dex: classes.dex
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
    private static int getKeyFromMask(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.getKeyFromMask(int):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.getKeyFromMask(int):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.rangeForCodePoint(int):java.awt.font.NumericShaper$Range, dex: classes.dex
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
    private java.awt.font.NumericShaper.Range rangeForCodePoint(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.rangeForCodePoint(int):java.awt.font.NumericShaper$Range, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.rangeForCodePoint(int):java.awt.font.NumericShaper$Range");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.shapeContextually(char[], int, int, int):void, dex: classes.dex
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
    private synchronized void shapeContextually(char[] r1, int r2, int r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.shapeContextually(char[], int, int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.shapeContextually(char[], int, int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.shapeContextually(char[], int, int, java.awt.font.NumericShaper$Range):void, dex: classes.dex
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
    private void shapeContextually(char[] r1, int r2, int r3, java.awt.font.NumericShaper.Range r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.shapeContextually(char[], int, int, java.awt.font.NumericShaper$Range):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.shapeContextually(char[], int, int, java.awt.font.NumericShaper$Range):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.shapeNonContextually(char[], int, int):void, dex: classes.dex
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
    private void shapeNonContextually(char[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.shapeNonContextually(char[], int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.shapeNonContextually(char[], int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
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
    private void writeObject(java.io.ObjectOutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.writeObject(java.io.ObjectOutputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.equals(java.lang.Object):boolean, dex: classes.dex
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
    public boolean equals(java.lang.Object r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.equals(java.lang.Object):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.equals(java.lang.Object):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.getRangeSet():java.util.Set<java.awt.font.NumericShaper$Range>, dex: classes.dex
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
    public java.util.Set<java.awt.font.NumericShaper.Range> getRangeSet() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.awt.font.NumericShaper.getRangeSet():java.util.Set<java.awt.font.NumericShaper$Range>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.getRangeSet():java.util.Set");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.getRanges():int, dex: classes.dex
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
    public int getRanges() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.getRanges():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.getRanges():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.hashCode():int, dex: classes.dex
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
    public int hashCode() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.hashCode():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.hashCode():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.isContextual():boolean, dex: classes.dex
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
    public boolean isContextual() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.isContextual():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.isContextual():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.shape(char[], int, int):void, dex: classes.dex
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
    public void shape(char[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.shape(char[], int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.shape(char[], int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.shape(char[], int, int, int):void, dex: classes.dex
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
    public void shape(char[] r1, int r2, int r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.shape(char[], int, int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.shape(char[], int, int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.shape(char[], int, int, java.awt.font.NumericShaper$Range):void, dex: classes.dex
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
    public void shape(char[] r1, int r2, int r3, java.awt.font.NumericShaper.Range r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.shape(char[], int, int, java.awt.font.NumericShaper$Range):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.shape(char[], int, int, java.awt.font.NumericShaper$Range):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.toString():java.lang.String, dex: classes.dex
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
    public java.lang.String toString() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.toString():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.toString():java.lang.String");
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum Range {
        ;
        
        private final int base;
        private final int end;
        private final int start;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.awt.font.NumericShaper.Range.<clinit>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.awt.font.NumericShaper.Range.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.Range.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.awt.font.NumericShaper.Range.<init>(java.lang.String, int, int, int, int):void, dex: classes.dex in method: java.awt.font.NumericShaper.Range.<init>(java.lang.String, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.awt.font.NumericShaper.Range.<init>(java.lang.String, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        private Range(int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.awt.font.NumericShaper.Range.<init>(java.lang.String, int, int, int, int):void, dex: classes.dex in method: java.awt.font.NumericShaper.Range.<init>(java.lang.String, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.Range.<init>(java.lang.String, int, int, int, int):void");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.Range.getDigitBase():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public int getDigitBase() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.Range.getDigitBase():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.Range.getDigitBase():int");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.Range.inRange(int):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean inRange(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.awt.font.NumericShaper.Range.inRange(int):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.Range.inRange(int):boolean");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.Range.toRangeIndex(java.awt.font.NumericShaper$Range):int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public static int toRangeIndex(java.awt.font.NumericShaper.Range r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.Range.toRangeIndex(java.awt.font.NumericShaper$Range):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.Range.toRangeIndex(java.awt.font.NumericShaper$Range):int");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.Range.toRangeMask(java.util.Set):int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public static int toRangeMask(java.util.Set<java.awt.font.NumericShaper.Range> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.awt.font.NumericShaper.Range.toRangeMask(java.util.Set):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.awt.font.NumericShaper.Range.toRangeMask(java.util.Set):int");
        }

        /* access modifiers changed from: private */
        public static Range indexToRange(int index) {
            if (index < 19) {
                return values()[index];
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static Set<Range> maskToRangeSet(int mask) {
            Set<Range> set = EnumSet.noneOf(Range.class);
            Range[] a = values();
            for (int i = 0; i < 19; i++) {
                if (((1 << i) & mask) != 0) {
                    set.add(a[i]);
                }
            }
            return set;
        }

        /* access modifiers changed from: package-private */
        public char getNumericBase() {
            return 0;
        }
    }

    private static int getContextKey(char c) {
        if (c < contexts[ctCache]) {
            while (ctCache > 0 && c < contexts[ctCache]) {
                ctCache--;
            }
        } else if (c >= contexts[ctCache + 1]) {
            while (ctCache < ctCacheLimit && c >= contexts[ctCache + 1]) {
                ctCache++;
            }
        }
        if ((ctCache & 1) == 0) {
            return ctCache / 2;
        }
        return 0;
    }

    private boolean isStrongDirectional(char c) {
        int cachedIndex = this.stCache;
        if (c < strongTable[cachedIndex]) {
            cachedIndex = search(c, strongTable, 0, cachedIndex);
        } else if (c >= strongTable[cachedIndex + 1]) {
            cachedIndex = search(c, strongTable, cachedIndex + 1, (strongTable.length - cachedIndex) - 1);
        }
        boolean val = (cachedIndex & 1) == 1;
        this.stCache = cachedIndex;
        return val;
    }

    public static NumericShaper getShaper(int singleRange) {
        return new NumericShaper(getKeyFromMask(singleRange), singleRange);
    }

    public static NumericShaper getShaper(Range singleRange) {
        return new NumericShaper(singleRange, (Set<Range>) EnumSet.of(singleRange));
    }

    public static NumericShaper getContextualShaper(int ranges) {
        return new NumericShaper(0, ranges | Integer.MIN_VALUE);
    }

    public static NumericShaper getContextualShaper(int ranges, int defaultContext) {
        return new NumericShaper(getKeyFromMask(defaultContext), ranges | Integer.MIN_VALUE);
    }

    private static int getHighBit(int value) {
        if (value <= 0) {
            return -32;
        }
        int bit = 0;
        if (value >= 65536) {
            value >>= 16;
            bit = 16;
        }
        if (value >= 256) {
            value >>= 8;
            bit += 8;
        }
        if (value >= 16) {
            value >>= 4;
            bit += 4;
        }
        if (value >= 4) {
            value >>= 2;
            bit += 2;
        }
        if (value >= 2) {
            return bit + 1;
        }
        return bit;
    }

    private static int search(int value, int[] array, int start, int length) {
        int power = 1 << getHighBit(length);
        int extra = length - power;
        int probe = power;
        int index = start;
        if (value >= array[start + extra]) {
            index = start + extra;
        }
        while (probe > 1) {
            probe >>= 1;
            if (value >= array[index + probe]) {
                index += probe;
            }
        }
        return index;
    }
}
