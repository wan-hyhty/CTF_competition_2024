package java.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayPrefixHelpers;
import java.util.ArraysParallelSortHelpers;
import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
public class Arrays {
    private static final int INSERTIONSORT_THRESHOLD = 7;
    public static final int MIN_ARRAY_SORT_GRAN = 8192;

    /* renamed from: java.util.Arrays$-void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0 implements IntConsumer {
        private /* synthetic */ double[] val$array;
        private /* synthetic */ IntToDoubleFunction val$generator;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0.<init>(double[], java.util.function.IntToDoubleFunction):void, dex: classes.dex
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
        public /* synthetic */ void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0(double[] r1, java.util.function.IntToDoubleFunction r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0.<init>(double[], java.util.function.IntToDoubleFunction):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0.<init>(double[], java.util.function.IntToDoubleFunction):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0.accept(int):void, dex: classes.dex
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
        public void accept(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0.accept(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0.accept(int):void");
        }
    }

    /* renamed from: java.util.Arrays$-void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0 implements IntConsumer {
        private /* synthetic */ int[] val$array;
        private /* synthetic */ IntUnaryOperator val$generator;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0.<init>(int[], java.util.function.IntUnaryOperator):void, dex: classes.dex
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
        public /* synthetic */ void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0(int[] r1, java.util.function.IntUnaryOperator r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0.<init>(int[], java.util.function.IntUnaryOperator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0.<init>(int[], java.util.function.IntUnaryOperator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0.accept(int):void, dex: classes.dex
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
        public void accept(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0.accept(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0.accept(int):void");
        }
    }

    /* renamed from: java.util.Arrays$-void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0 implements IntConsumer {
        private /* synthetic */ Object[] val$array;
        private /* synthetic */ IntFunction val$generator;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0.<init>(java.lang.Object[], java.util.function.IntFunction):void, dex: classes.dex
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
        public /* synthetic */ void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0(java.lang.Object[] r1, java.util.function.IntFunction r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0.<init>(java.lang.Object[], java.util.function.IntFunction):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0.<init>(java.lang.Object[], java.util.function.IntFunction):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0.accept(int):void, dex: classes.dex
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
        public void accept(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0.accept(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0.accept(int):void");
        }
    }

    /* renamed from: java.util.Arrays$-void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0 implements IntConsumer {
        private /* synthetic */ long[] val$array;
        private /* synthetic */ IntToLongFunction val$generator;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0.<init>(long[], java.util.function.IntToLongFunction):void, dex: classes.dex
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
        public /* synthetic */ void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0(long[] r1, java.util.function.IntToLongFunction r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Arrays.-void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0.<init>(long[], java.util.function.IntToLongFunction):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0.<init>(long[], java.util.function.IntToLongFunction):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0.accept(int):void, dex: classes.dex
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
        public void accept(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Arrays.-void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0.accept(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0.accept(int):void");
        }
    }

    static final class LegacyMergeSort {
        private static final boolean userRequested = false;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Arrays.LegacyMergeSort.<init>():void, dex: classes.dex
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
        LegacyMergeSort() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Arrays.LegacyMergeSort.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.LegacyMergeSort.<init>():void");
        }
    }

    static final class NaturalOrder implements Comparator<Object> {
        static final NaturalOrder INSTANCE = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Arrays.NaturalOrder.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Arrays.NaturalOrder.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.NaturalOrder.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Arrays.NaturalOrder.<init>():void, dex: classes.dex
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
        NaturalOrder() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Arrays.NaturalOrder.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.NaturalOrder.<init>():void");
        }

        public int compare(Object first, Object second) {
            return ((Comparable) first).compareTo(second);
        }
    }

    private Arrays() {
    }

    public static void sort(int[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, (int[]) null, 0, 0);
    }

    public static void sort(int[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (int[]) null, 0, 0);
    }

    public static void sort(long[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, (long[]) null, 0, 0);
    }

    public static void sort(long[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (long[]) null, 0, 0);
    }

    public static void sort(short[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, (short[]) null, 0, 0);
    }

    public static void sort(short[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (short[]) null, 0, 0);
    }

    public static void sort(char[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, (char[]) null, 0, 0);
    }

    public static void sort(char[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (char[]) null, 0, 0);
    }

    public static void sort(byte[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1);
    }

    public static void sort(byte[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1);
    }

    public static void sort(float[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, (float[]) null, 0, 0);
    }

    public static void sort(float[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (float[]) null, 0, 0);
    }

    public static void sort(double[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, (double[]) null, 0, 0);
    }

    public static void sort(double[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (double[]) null, 0, 0);
    }

    public static void parallelSort(byte[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, 0, n - 1);
            return;
        }
        byte[] bArr = new byte[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJByte.Sorter((CountedCompleter<?>) null, a, bArr, 0, n, 0, i).invoke();
    }

    public static void parallelSort(byte[] a, int fromIndex, int toIndex) {
        int p;
        int i = 8192;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, fromIndex, toIndex - 1);
            return;
        }
        byte[] bArr = new byte[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJByte.Sorter((CountedCompleter<?>) null, a, bArr, fromIndex, n, 0, i).invoke();
    }

    public static void parallelSort(char[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, 0, n - 1, (char[]) null, 0, 0);
            return;
        }
        char[] cArr = new char[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJChar.Sorter((CountedCompleter<?>) null, a, cArr, 0, n, 0, i).invoke();
    }

    public static void parallelSort(char[] a, int fromIndex, int toIndex) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (char[]) null, 0, 0);
            return;
        }
        char[] cArr = new char[n];
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJChar.Sorter((CountedCompleter<?>) null, a, cArr, fromIndex, n, 0, i).invoke();
    }

    public static void parallelSort(short[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, 0, n - 1, (short[]) null, 0, 0);
            return;
        }
        short[] sArr = new short[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJShort.Sorter((CountedCompleter<?>) null, a, sArr, 0, n, 0, i).invoke();
    }

    public static void parallelSort(short[] a, int fromIndex, int toIndex) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (short[]) null, 0, 0);
            return;
        }
        short[] sArr = new short[n];
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJShort.Sorter((CountedCompleter<?>) null, a, sArr, fromIndex, n, 0, i).invoke();
    }

    public static void parallelSort(int[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, 0, n - 1, (int[]) null, 0, 0);
            return;
        }
        int[] iArr = new int[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJInt.Sorter((CountedCompleter<?>) null, a, iArr, 0, n, 0, i).invoke();
    }

    public static void parallelSort(int[] a, int fromIndex, int toIndex) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (int[]) null, 0, 0);
            return;
        }
        int[] iArr = new int[n];
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJInt.Sorter((CountedCompleter<?>) null, a, iArr, fromIndex, n, 0, i).invoke();
    }

    public static void parallelSort(long[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, 0, n - 1, (long[]) null, 0, 0);
            return;
        }
        long[] jArr = new long[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJLong.Sorter((CountedCompleter<?>) null, a, jArr, 0, n, 0, i).invoke();
    }

    public static void parallelSort(long[] a, int fromIndex, int toIndex) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (long[]) null, 0, 0);
            return;
        }
        long[] jArr = new long[n];
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJLong.Sorter((CountedCompleter<?>) null, a, jArr, fromIndex, n, 0, i).invoke();
    }

    public static void parallelSort(float[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, 0, n - 1, (float[]) null, 0, 0);
            return;
        }
        float[] fArr = new float[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJFloat.Sorter((CountedCompleter<?>) null, a, fArr, 0, n, 0, i).invoke();
    }

    public static void parallelSort(float[] a, int fromIndex, int toIndex) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (float[]) null, 0, 0);
            return;
        }
        float[] fArr = new float[n];
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJFloat.Sorter((CountedCompleter<?>) null, a, fArr, fromIndex, n, 0, i).invoke();
    }

    public static void parallelSort(double[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, 0, n - 1, (double[]) null, 0, 0);
            return;
        }
        double[] dArr = new double[n];
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJDouble.Sorter((CountedCompleter<?>) null, a, dArr, 0, n, 0, i).invoke();
    }

    public static void parallelSort(double[] a, int fromIndex, int toIndex) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            DualPivotQuicksort.sort(a, fromIndex, toIndex - 1, (double[]) null, 0, 0);
            return;
        }
        double[] dArr = new double[n];
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJDouble.Sorter((CountedCompleter<?>) null, a, dArr, fromIndex, n, 0, i).invoke();
    }

    public static <T extends Comparable<? super T>> void parallelSort(T[] a) {
        int p;
        int i = 8192;
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a, 0, n, NaturalOrder.INSTANCE, (T[]) null, 0, 0);
            return;
        }
        Comparable[] comparableArr = (Comparable[]) Array.newInstance(a.getClass().getComponentType(), n);
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJObject.Sorter((CountedCompleter<?>) null, a, comparableArr, 0, n, 0, i, NaturalOrder.INSTANCE).invoke();
    }

    public static <T extends Comparable<? super T>> void parallelSort(T[] a, int fromIndex, int toIndex) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a, fromIndex, toIndex, NaturalOrder.INSTANCE, (T[]) null, 0, 0);
            return;
        }
        Comparable[] comparableArr = (Comparable[]) Array.newInstance(a.getClass().getComponentType(), n);
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJObject.Sorter((CountedCompleter<?>) null, a, comparableArr, fromIndex, n, 0, i, NaturalOrder.INSTANCE).invoke();
    }

    public static <T> void parallelSort(T[] a, Comparator<? super T> cmp) {
        int p;
        int i = 8192;
        if (cmp == null) {
            cmp = NaturalOrder.INSTANCE;
        }
        int n = a.length;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a, 0, n, cmp, (T[]) null, 0, 0);
            return;
        }
        Object[] objArr = (Object[]) Array.newInstance(a.getClass().getComponentType(), n);
        int g = n / (p << 2);
        if (g > 8192) {
            i = g;
        }
        new ArraysParallelSortHelpers.FJObject.Sorter((CountedCompleter<?>) null, a, objArr, 0, n, 0, i, cmp).invoke();
    }

    public static <T> void parallelSort(T[] a, int fromIndex, int toIndex, Comparator<? super T> cmp) {
        int p;
        int i;
        rangeCheck(a.length, fromIndex, toIndex);
        if (cmp == null) {
            cmp = NaturalOrder.INSTANCE;
        }
        int n = toIndex - fromIndex;
        if (n <= 8192 || (p = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a, fromIndex, toIndex, cmp, (T[]) null, 0, 0);
            return;
        }
        Object[] objArr = (Object[]) Array.newInstance(a.getClass().getComponentType(), n);
        int g = n / (p << 2);
        if (g <= 8192) {
            i = 8192;
        } else {
            i = g;
        }
        new ArraysParallelSortHelpers.FJObject.Sorter((CountedCompleter<?>) null, a, objArr, fromIndex, n, 0, i, cmp).invoke();
    }

    public static void sort(Object[] a) {
        ComparableTimSort.sort(a, 0, a.length, (Object[]) null, 0, 0);
    }

    private static void legacyMergeSort(Object[] a) {
        mergeSort((Object[]) a.clone(), a, 0, a.length, 0);
    }

    public static void sort(Object[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        ComparableTimSort.sort(a, fromIndex, toIndex, (Object[]) null, 0, 0);
    }

    private static void legacyMergeSort(Object[] a, int fromIndex, int toIndex) {
        rangeCheck(a.length, fromIndex, toIndex);
        mergeSort(copyOfRange((T[]) a, fromIndex, toIndex), a, fromIndex, toIndex, -fromIndex);
    }

    private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
        int q;
        int p;
        int length = high - low;
        if (length < 7) {
            for (int i = low; i < high; i++) {
                int j = i;
                while (j > low && dest[j - 1].compareTo(dest[j]) > 0) {
                    swap(dest, j, j - 1);
                    j--;
                }
            }
            return;
        }
        int destLow = low;
        int destHigh = high;
        int low2 = low + off;
        int high2 = high + off;
        int mid = (low2 + high2) >>> 1;
        mergeSort(dest, src, low2, mid, -off);
        mergeSort(dest, src, mid, high2, -off);
        if (src[mid - 1].compareTo(src[mid]) <= 0) {
            System.arraycopy((Object) src, low2, (Object) dest, destLow, length);
            return;
        }
        int i2 = destLow;
        int q2 = mid;
        int p2 = low2;
        while (i2 < destHigh) {
            if (q2 >= high2 || (p2 < mid && src[p2].compareTo(src[q2]) <= 0)) {
                p = p2 + 1;
                dest[i2] = src[p2];
                q = q2;
            } else {
                q = q2 + 1;
                dest[i2] = src[q2];
                p = p2;
            }
            i2++;
            q2 = q;
            p2 = p;
        }
    }

    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static <T> void sort(T[] a, Comparator<? super T> c) {
        if (c == null) {
            sort((Object[]) a);
            return;
        }
        TimSort.sort(a, 0, a.length, c, (T[]) null, 0, 0);
    }

    private static <T> void legacyMergeSort(T[] a, Comparator<? super T> c) {
        T[] aux = (Object[]) a.clone();
        if (c == null) {
            mergeSort(aux, a, 0, a.length, 0);
            return;
        }
        mergeSort(aux, a, 0, a.length, 0, c);
    }

    public static <T> void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c) {
        if (c == null) {
            sort((Object[]) a, fromIndex, toIndex);
            return;
        }
        rangeCheck(a.length, fromIndex, toIndex);
        TimSort.sort(a, fromIndex, toIndex, c, (T[]) null, 0, 0);
    }

    private static <T> void legacyMergeSort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c) {
        rangeCheck(a.length, fromIndex, toIndex);
        T[] aux = copyOfRange(a, fromIndex, toIndex);
        if (c == null) {
            mergeSort(aux, a, fromIndex, toIndex, -fromIndex);
            return;
        }
        mergeSort(aux, a, fromIndex, toIndex, -fromIndex, c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        if (r24.compare(r19[r16], r19[r18]) <= 0) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void mergeSort(java.lang.Object[] r19, java.lang.Object[] r20, int r21, int r22, int r23, java.util.Comparator r24) {
        /*
            int r14 = r22 - r21
            r3 = 7
            if (r14 >= r3) goto L_0x002c
            r12 = r21
        L_0x0007:
            r0 = r22
            if (r12 >= r0) goto L_0x002b
            r13 = r12
        L_0x000c:
            r0 = r21
            if (r13 <= r0) goto L_0x0028
            int r3 = r13 + -1
            r3 = r20[r3]
            r4 = r20[r13]
            r0 = r24
            int r3 = r0.compare(r3, r4)
            if (r3 <= 0) goto L_0x0028
            int r3 = r13 + -1
            r0 = r20
            swap(r0, r13, r3)
            int r13 = r13 + -1
            goto L_0x000c
        L_0x0028:
            int r12 = r12 + 1
            goto L_0x0007
        L_0x002b:
            return
        L_0x002c:
            r11 = r21
            r10 = r22
            int r21 = r21 + r23
            int r22 = r22 + r23
            int r3 = r21 + r22
            int r6 = r3 >>> 1
            r0 = r23
            int r7 = -r0
            r3 = r20
            r4 = r19
            r5 = r21
            r8 = r24
            mergeSort(r3, r4, r5, r6, r7, r8)
            r0 = r23
            int r8 = -r0
            r4 = r20
            r5 = r19
            r7 = r22
            r9 = r24
            mergeSort(r4, r5, r6, r7, r8, r9)
            int r3 = r6 + -1
            r3 = r19[r3]
            r4 = r19[r6]
            r0 = r24
            int r3 = r0.compare(r3, r4)
            if (r3 > 0) goto L_0x006c
            r0 = r19
            r1 = r21
            r2 = r20
            java.lang.System.arraycopy((java.lang.Object) r0, (int) r1, (java.lang.Object) r2, (int) r11, (int) r14)
            return
        L_0x006c:
            r12 = r11
            r15 = r21
            r17 = r6
            r18 = r17
            r16 = r15
        L_0x0075:
            if (r12 >= r10) goto L_0x00a5
            r0 = r18
            r1 = r22
            if (r0 >= r1) goto L_0x008d
            r0 = r16
            if (r0 >= r6) goto L_0x009c
            r3 = r19[r16]
            r4 = r19[r18]
            r0 = r24
            int r3 = r0.compare(r3, r4)
            if (r3 > 0) goto L_0x009c
        L_0x008d:
            int r15 = r16 + 1
            r3 = r19[r16]
            r20[r12] = r3
            r17 = r18
        L_0x0095:
            int r12 = r12 + 1
            r18 = r17
            r16 = r15
            goto L_0x0075
        L_0x009c:
            int r17 = r18 + 1
            r3 = r19[r18]
            r20[r12] = r3
            r15 = r16
            goto L_0x0095
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Arrays.mergeSort(java.lang.Object[], java.lang.Object[], int, int, int, java.util.Comparator):void");
    }

    private static void rangeCheck(int length, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        } else if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        } else if (toIndex > length) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    public static <T> void parallelPrefix(T[] array, BinaryOperator<T> op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.CumulateTask((ArrayPrefixHelpers.CumulateTask) null, op, array, 0, array.length).invoke();
        }
    }

    public static <T> void parallelPrefix(T[] array, int fromIndex, int toIndex, BinaryOperator<T> op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.CumulateTask((ArrayPrefixHelpers.CumulateTask) null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static void parallelPrefix(long[] array, LongBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.LongCumulateTask((ArrayPrefixHelpers.LongCumulateTask) null, op, array, 0, array.length).invoke();
        }
    }

    public static void parallelPrefix(long[] array, int fromIndex, int toIndex, LongBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.LongCumulateTask((ArrayPrefixHelpers.LongCumulateTask) null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static void parallelPrefix(double[] array, DoubleBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.DoubleCumulateTask((ArrayPrefixHelpers.DoubleCumulateTask) null, op, array, 0, array.length).invoke();
        }
    }

    public static void parallelPrefix(double[] array, int fromIndex, int toIndex, DoubleBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.DoubleCumulateTask((ArrayPrefixHelpers.DoubleCumulateTask) null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static void parallelPrefix(int[] array, IntBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.IntCumulateTask((ArrayPrefixHelpers.IntCumulateTask) null, op, array, 0, array.length).invoke();
        }
    }

    public static void parallelPrefix(int[] array, int fromIndex, int toIndex, IntBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.IntCumulateTask((ArrayPrefixHelpers.IntCumulateTask) null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static int binarySearch(long[] a, long key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(long[] a, int fromIndex, int toIndex, long key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal <= key) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(int[] a, int key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal <= key) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(short[] a, short key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(short[] a, int fromIndex, int toIndex, short key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal <= key) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(char[] a, char key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(char[] a, int fromIndex, int toIndex, char key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            char midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal <= key) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(byte[] a, byte key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(byte[] a, int fromIndex, int toIndex, byte key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal <= key) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(double[] a, double key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(double[] a, int fromIndex, int toIndex, double key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                long midBits = Double.doubleToLongBits(midVal);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits) {
                    return mid;
                }
                if (midBits < keyBits) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(float[] a, float key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(float[] a, int fromIndex, int toIndex, float key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            float midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                int midBits = Float.floatToIntBits(midVal);
                int keyBits = Float.floatToIntBits(key);
                if (midBits == keyBits) {
                    return mid;
                }
                if (midBits < keyBits) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(Object[] a, Object key) {
        return binarySearch0(a, 0, a.length, key);
    }

    public static int binarySearch(Object[] a, int fromIndex, int toIndex, Object key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key);
    }

    private static int binarySearch0(Object[] a, int fromIndex, int toIndex, Object key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = a[mid].compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        return binarySearch0(a, 0, a.length, key, c);
    }

    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch0(a, fromIndex, toIndex, key, c);
    }

    private static <T> int binarySearch0(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        if (c == null) {
            return binarySearch0((Object[]) a, fromIndex, toIndex, (Object) key);
        }
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = c.compare(a[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static boolean equals(long[] a, long[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(int[] a, int[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(short[] a, short[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(char[] a, char[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(byte[] a, byte[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(boolean[] a, boolean[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(double[] a, double[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Double.doubleToLongBits(a[i]) != Double.doubleToLongBits(a2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(float[] a, float[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Float.floatToIntBits(a[i]) != Float.floatToIntBits(a2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(Object[] a, Object[] a2) {
        int length;
        if (a == a2) {
            return true;
        }
        if (a == null || a2 == null || a2.length != (length = a.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Object o1 = a[i];
            Object o2 = a2[i];
            if (!(o1 == null ? o2 == null : o1.equals(o2))) {
                return false;
            }
        }
        return true;
    }

    public static void fill(long[] a, long val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(long[] a, int fromIndex, int toIndex, long val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(int[] a, int val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(int[] a, int fromIndex, int toIndex, int val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(short[] a, short val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(short[] a, int fromIndex, int toIndex, short val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(char[] a, char val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(char[] a, int fromIndex, int toIndex, char val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(byte[] a, byte val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(byte[] a, int fromIndex, int toIndex, byte val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(boolean[] a, boolean val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(boolean[] a, int fromIndex, int toIndex, boolean val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(double[] a, double val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(double[] a, int fromIndex, int toIndex, double val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(float[] a, float val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(float[] a, int fromIndex, int toIndex, float val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static void fill(Object[] a, Object val) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = val;
        }
    }

    public static void fill(Object[] a, int fromIndex, int toIndex, Object val) {
        rangeCheck(a.length, fromIndex, toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            a[i] = val;
        }
    }

    public static <T> T[] copyOf(T[] original, int newLength) {
        return copyOf(original, newLength, original.getClass());
    }

    public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        T[] copy;
        if (newType == Object[].class) {
            copy = new Object[newLength];
        } else {
            copy = (Object[]) Array.newInstance(newType.getComponentType(), newLength);
        }
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static byte[] copyOf(byte[] original, int newLength) {
        byte[] copy = new byte[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static short[] copyOf(short[] original, int newLength) {
        short[] copy = new short[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static long[] copyOf(long[] original, int newLength) {
        long[] copy = new long[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static char[] copyOf(char[] original, int newLength) {
        char[] copy = new char[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static float[] copyOf(float[] original, int newLength) {
        float[] copy = new float[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static double[] copyOf(double[] original, int newLength) {
        double[] copy = new double[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static boolean[] copyOf(boolean[] original, int newLength) {
        boolean[] copy = new boolean[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static <T> T[] copyOfRange(T[] original, int from, int to) {
        return copyOfRange(original, from, to, original.getClass());
    }

    public static <T, U> T[] copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType) {
        T[] copy;
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        if (newType == Object[].class) {
            copy = new Object[newLength];
        } else {
            copy = (Object[]) Array.newInstance(newType.getComponentType(), newLength);
        }
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static byte[] copyOfRange(byte[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        byte[] copy = new byte[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static short[] copyOfRange(short[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        short[] copy = new short[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static int[] copyOfRange(int[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        int[] copy = new int[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static long[] copyOfRange(long[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        long[] copy = new long[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static char[] copyOfRange(char[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        char[] copy = new char[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static float[] copyOfRange(float[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        float[] copy = new float[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static double[] copyOfRange(double[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        double[] copy = new double[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static boolean[] copyOfRange(boolean[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        boolean[] copy = new boolean[newLength];
        System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    @SafeVarargs
    public static <T> List<T> asList(T... a) {
        return new ArrayList(a);
    }

    private static class ArrayList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        private static final long serialVersionUID = -2764017481108945198L;
        private final E[] a;

        ArrayList(E[] array) {
            this.a = (Object[]) Objects.requireNonNull(array);
        }

        public int size() {
            return this.a.length;
        }

        public Object[] toArray() {
            return (Object[]) this.a.clone();
        }

        public <T> T[] toArray(T[] a2) {
            int size = size();
            if (a2.length < size) {
                return Arrays.copyOf(this.a, size, a2.getClass());
            }
            System.arraycopy((Object) this.a, 0, (Object) a2, 0, size);
            if (a2.length > size) {
                a2[size] = null;
            }
            return a2;
        }

        public E get(int index) {
            return this.a[index];
        }

        public E set(int index, E element) {
            E oldValue = this.a[index];
            this.a[index] = element;
            return oldValue;
        }

        public int indexOf(Object o) {
            if (o == null) {
                for (int i = 0; i < this.a.length; i++) {
                    if (this.a[i] == null) {
                        return i;
                    }
                }
                return -1;
            }
            for (int i2 = 0; i2 < this.a.length; i2++) {
                if (o.equals(this.a[i2])) {
                    return i2;
                }
            }
            return -1;
        }

        public boolean contains(Object o) {
            return indexOf(o) != -1;
        }

        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            for (E e : this.a) {
                action.accept(e);
            }
        }

        public void replaceAll(UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
            E[] a2 = this.a;
            for (int i = 0; i < a2.length; i++) {
                a2[i] = operator.apply(a2[i]);
            }
        }

        public Spliterator<E> spliterator() {
            return Spliterators.spliterator((Object[]) this.a, 16);
        }
    }

    public static int hashCode(long[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (long element : a) {
            result = (result * 31) + ((int) ((element >>> 32) ^ element));
        }
        return result;
    }

    public static int hashCode(int[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (int element : a) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(short[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (short element : a) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(char[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (char element : a) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(byte[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (byte element : a) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(boolean[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            result = (result * 31) + (a[i] ? 1231 : 1237);
        }
        return result;
    }

    public static int hashCode(float[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (float element : a) {
            result = (result * 31) + Float.floatToIntBits(element);
        }
        return result;
    }

    public static int hashCode(double[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (double element : a) {
            long bits = Double.doubleToLongBits(element);
            result = (result * 31) + ((int) ((bits >>> 32) ^ bits));
        }
        return result;
    }

    public static int hashCode(Object[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            Object element = a[i];
            result = (result * 31) + (element == null ? 0 : element.hashCode());
        }
        return result;
    }

    public static int deepHashCode(Object[] a) {
        if (a == null) {
            return 0;
        }
        int result = 1;
        for (Object element : a) {
            int elementHash = 0;
            if (element != null) {
                Class<?> cl = element.getClass().getComponentType();
                if (cl == null) {
                    elementHash = element.hashCode();
                } else if (element instanceof Object[]) {
                    elementHash = deepHashCode((Object[]) element);
                } else if (cl == Byte.TYPE) {
                    elementHash = hashCode((byte[]) element);
                } else if (cl == Short.TYPE) {
                    elementHash = hashCode((short[]) element);
                } else if (cl == Integer.TYPE) {
                    elementHash = hashCode((int[]) element);
                } else if (cl == Long.TYPE) {
                    elementHash = hashCode((long[]) element);
                } else if (cl == Character.TYPE) {
                    elementHash = hashCode((char[]) element);
                } else if (cl == Float.TYPE) {
                    elementHash = hashCode((float[]) element);
                } else if (cl == Double.TYPE) {
                    elementHash = hashCode((double[]) element);
                } else if (cl == Boolean.TYPE) {
                    elementHash = hashCode((boolean[]) element);
                } else {
                    elementHash = element.hashCode();
                }
            }
            result = (result * 31) + elementHash;
        }
        return result;
    }

    public static boolean deepEquals(Object[] a1, Object[] a2) {
        int length;
        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null || a2.length != (length = a1.length)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Object e1 = a1[i];
            Object e2 = a2[i];
            if (e1 != e2 && (e1 == null || e2 == null || !deepEquals0(e1, e2))) {
                return false;
            }
        }
        return true;
    }

    static boolean deepEquals0(Object e1, Object e2) {
        Class<?> cl1 = e1.getClass().getComponentType();
        if (cl1 != e2.getClass().getComponentType()) {
            return false;
        }
        if (e1 instanceof Object[]) {
            return deepEquals((Object[]) e1, (Object[]) e2);
        }
        if (cl1 == Byte.TYPE) {
            return equals((byte[]) e1, (byte[]) e2);
        }
        if (cl1 == Short.TYPE) {
            return equals((short[]) e1, (short[]) e2);
        }
        if (cl1 == Integer.TYPE) {
            return equals((int[]) e1, (int[]) e2);
        }
        if (cl1 == Long.TYPE) {
            return equals((long[]) e1, (long[]) e2);
        }
        if (cl1 == Character.TYPE) {
            return equals((char[]) e1, (char[]) e2);
        }
        if (cl1 == Float.TYPE) {
            return equals((float[]) e1, (float[]) e2);
        }
        if (cl1 == Double.TYPE) {
            return equals((double[]) e1, (double[]) e2);
        }
        if (cl1 == Boolean.TYPE) {
            return equals((boolean[]) e1, (boolean[]) e2);
        }
        return e1.equals(e2);
    }

    public static String toString(long[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(int[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(short[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append((int) a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(char[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(byte[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append((int) a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(boolean[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(float[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(double[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String toString(Object[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(String.valueOf(a[i]));
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
            i++;
        }
    }

    public static String deepToString(Object[] a) {
        if (a == null) {
            return "null";
        }
        int bufLen = a.length * 20;
        if (a.length != 0 && bufLen <= 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuilder buf = new StringBuilder(bufLen);
        deepToString(a, buf, new HashSet());
        return buf.toString();
    }

    private static void deepToString(Object[] a, StringBuilder buf, Set<Object[]> dejaVu) {
        if (a == null) {
            buf.append("null");
            return;
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            buf.append("[]");
            return;
        }
        dejaVu.add(a);
        buf.append('[');
        int i = 0;
        while (true) {
            Object element = a[i];
            if (element == null) {
                buf.append("null");
            } else {
                Class eClass = element.getClass();
                if (!eClass.isArray()) {
                    buf.append(element.toString());
                } else if (eClass == byte[].class) {
                    buf.append(toString((byte[]) element));
                } else if (eClass == short[].class) {
                    buf.append(toString((short[]) element));
                } else if (eClass == int[].class) {
                    buf.append(toString((int[]) element));
                } else if (eClass == long[].class) {
                    buf.append(toString((long[]) element));
                } else if (eClass == char[].class) {
                    buf.append(toString((char[]) element));
                } else if (eClass == float[].class) {
                    buf.append(toString((float[]) element));
                } else if (eClass == double[].class) {
                    buf.append(toString((double[]) element));
                } else if (eClass == boolean[].class) {
                    buf.append(toString((boolean[]) element));
                } else if (dejaVu.contains(element)) {
                    buf.append("[...]");
                } else {
                    deepToString((Object[]) element, buf, dejaVu);
                }
            }
            if (i == iMax) {
                buf.append(']');
                dejaVu.remove(a);
                return;
            }
            buf.append(", ");
            i++;
        }
    }

    public static <T> void setAll(T[] array, IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.apply(i);
        }
    }

    public static <T> void parallelSetAll(T[] array, IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new void_parallelSetAll_java_lang_Object__array_java_util_function_IntFunction_generator_LambdaImpl0(array, generator));
    }

    /* renamed from: -java_util_Arrays_lambda$1  reason: not valid java name */
    static /* synthetic */ void m195java_util_Arrays_lambda$1(Object[] array, IntFunction generator, int i) {
        array[i] = generator.apply(i);
    }

    public static void setAll(int[] array, IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsInt(i);
        }
    }

    public static void parallelSetAll(int[] array, IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new void_parallelSetAll_int__array_java_util_function_IntUnaryOperator_generator_LambdaImpl0(array, generator));
    }

    /* renamed from: -java_util_Arrays_lambda$2  reason: not valid java name */
    static /* synthetic */ void m196java_util_Arrays_lambda$2(int[] array, IntUnaryOperator generator, int i) {
        array[i] = generator.applyAsInt(i);
    }

    public static void setAll(long[] array, IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsLong(i);
        }
    }

    public static void parallelSetAll(long[] array, IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new void_parallelSetAll_long__array_java_util_function_IntToLongFunction_generator_LambdaImpl0(array, generator));
    }

    /* renamed from: -java_util_Arrays_lambda$3  reason: not valid java name */
    static /* synthetic */ void m197java_util_Arrays_lambda$3(long[] array, IntToLongFunction generator, int i) {
        array[i] = generator.applyAsLong(i);
    }

    public static void setAll(double[] array, IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.applyAsDouble(i);
        }
    }

    public static void parallelSetAll(double[] array, IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new void_parallelSetAll_double__array_java_util_function_IntToDoubleFunction_generator_LambdaImpl0(array, generator));
    }

    /* renamed from: -java_util_Arrays_lambda$4  reason: not valid java name */
    static /* synthetic */ void m198java_util_Arrays_lambda$4(double[] array, IntToDoubleFunction generator, int i) {
        array[i] = generator.applyAsDouble(i);
    }

    public static void checkOffsetAndCount(int arrayLength, int offset, int count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException(arrayLength, offset, count);
        }
    }

    public static <T> Spliterator<T> spliterator(T[] array) {
        return Spliterators.spliterator((Object[]) array, 1040);
    }

    public static <T> Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator((Object[]) array, startInclusive, endExclusive, 1040);
    }

    public static Spliterator.OfInt spliterator(int[] array) {
        return Spliterators.spliterator(array, 1040);
    }

    public static Spliterator.OfInt spliterator(int[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, 1040);
    }

    public static Spliterator.OfLong spliterator(long[] array) {
        return Spliterators.spliterator(array, 1040);
    }

    public static Spliterator.OfLong spliterator(long[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, 1040);
    }

    public static Spliterator.OfDouble spliterator(double[] array) {
        return Spliterators.spliterator(array, 1040);
    }

    public static Spliterator.OfDouble spliterator(double[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, 1040);
    }

    public static <T> Stream<T> stream(T[] array) {
        return stream(array, 0, array.length);
    }

    public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
        return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static IntStream stream(int[] array) {
        return stream(array, 0, array.length);
    }

    public static IntStream stream(int[] array, int startInclusive, int endExclusive) {
        return StreamSupport.intStream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static LongStream stream(long[] array) {
        return stream(array, 0, array.length);
    }

    public static LongStream stream(long[] array, int startInclusive, int endExclusive) {
        return StreamSupport.longStream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static DoubleStream stream(double[] array) {
        return stream(array, 0, array.length);
    }

    public static DoubleStream stream(double[] array, int startInclusive, int endExclusive) {
        return StreamSupport.doubleStream(spliterator(array, startInclusive, endExclusive), false);
    }
}
