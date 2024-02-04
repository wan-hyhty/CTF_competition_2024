package java.util.function;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {

    /* renamed from: java.util.function.UnaryOperator$-java_util_function_UnaryOperator_identity__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_UnaryOperator_identity__LambdaImpl0 implements UnaryOperator {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.function.UnaryOperator.-java_util_function_UnaryOperator_identity__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_function_UnaryOperator_identity__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.function.UnaryOperator.-java_util_function_UnaryOperator_identity__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.UnaryOperator.java_util_function_UnaryOperator_identity__LambdaImpl0.<init>():void");
        }

        public Object apply(Object arg0) {
            return UnaryOperator.m346java_util_function_UnaryOperator_lambda$1(arg0);
        }
    }

    /* renamed from: -java_util_function_UnaryOperator_lambda$1  reason: not valid java name */
    static /* synthetic */ Object m346java_util_function_UnaryOperator_lambda$1(Object t) {
        return t;
    }

    static <T> UnaryOperator<T> identity() {
        return new java_util_function_UnaryOperator_identity__LambdaImpl0();
    }
}
