package sun.misc;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class FloatConsts {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f108assertionsDisabled = false;
    public static final int EXP_BIAS = 127;
    public static final int EXP_BIT_MASK = 2139095040;
    public static final int MAX_EXPONENT = 127;
    public static final float MAX_VALUE = Float.MAX_VALUE;
    public static final int MIN_EXPONENT = -126;
    public static final float MIN_NORMAL = Float.MIN_NORMAL;
    public static final int MIN_SUB_EXPONENT = -149;
    public static final float MIN_VALUE = Float.MIN_VALUE;
    public static final float NEGATIVE_INFINITY = Float.NEGATIVE_INFINITY;
    public static final float NaN = Float.NaN;
    public static final float POSITIVE_INFINITY = Float.POSITIVE_INFINITY;
    public static final int SIGNIFICAND_WIDTH = 24;
    public static final int SIGNIF_BIT_MASK = 8388607;
    public static final int SIGN_BIT_MASK = Integer.MIN_VALUE;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.misc.FloatConsts.<init>():void, dex: classes.dex
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
    private FloatConsts() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.misc.FloatConsts.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.FloatConsts.<init>():void");
    }
}
