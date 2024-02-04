package sun.misc;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class DoubleConsts {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f106assertionsDisabled = false;
    public static final int EXP_BIAS = 1023;
    public static final long EXP_BIT_MASK = 9218868437227405312L;
    public static final int MAX_EXPONENT = 1023;
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final int MIN_EXPONENT = -1022;
    public static final double MIN_NORMAL = Double.MIN_NORMAL;
    public static final int MIN_SUB_EXPONENT = -1074;
    public static final double MIN_VALUE = Double.MIN_VALUE;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final double NaN = Double.NaN;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    public static final int SIGNIFICAND_WIDTH = 53;
    public static final long SIGNIF_BIT_MASK = 4503599627370495L;
    public static final long SIGN_BIT_MASK = Long.MIN_VALUE;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.misc.DoubleConsts.<init>():void, dex: classes.dex
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
    private DoubleConsts() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.misc.DoubleConsts.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.DoubleConsts.<init>():void");
    }
}
