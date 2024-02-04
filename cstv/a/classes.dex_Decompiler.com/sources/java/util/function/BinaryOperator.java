package java.util.function;

import java.util.Comparator;
import java.util.Objects;

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
public interface BinaryOperator<T> extends BiFunction<T, T, T> {

    /* renamed from: java.util.function.BinaryOperator$-java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0 implements BinaryOperator {
        private /* synthetic */ Comparator val$comparator;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0(java.util.Comparator r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BinaryOperator.java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0.<init>(java.util.Comparator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
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
        public java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BinaryOperator.java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: java.util.function.BinaryOperator$-java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0 implements BinaryOperator {
        private /* synthetic */ Comparator val$comparator;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0(java.util.Comparator r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BinaryOperator.java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0.<init>(java.util.Comparator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
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
        public java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.BinaryOperator.-java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BinaryOperator.java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new java_util_function_BinaryOperator_minBy_java_util_Comparator_comparator_LambdaImpl0(comparator);
    }

    /* renamed from: -java_util_function_BinaryOperator_lambda$1  reason: not valid java name */
    static /* synthetic */ Object m314java_util_function_BinaryOperator_lambda$1(Comparator comparator, Object a, Object b) {
        return comparator.compare(a, b) <= 0 ? a : b;
    }

    static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new java_util_function_BinaryOperator_maxBy_java_util_Comparator_comparator_LambdaImpl0(comparator);
    }

    /* renamed from: -java_util_function_BinaryOperator_lambda$2  reason: not valid java name */
    static /* synthetic */ Object m315java_util_function_BinaryOperator_lambda$2(Comparator comparator, Object a, Object b) {
        return comparator.compare(a, b) >= 0 ? a : b;
    }
}
