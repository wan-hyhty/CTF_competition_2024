package java.util.stream;

import java.util.IntSummaryStatistics;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Node;
import java.util.stream.StreamSpliterators;

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
public abstract class IntPipeline<E_IN> extends AbstractPipeline<E_IN, Integer, IntStream> implements IntStream {

    /* renamed from: java.util.stream.IntPipeline$-int__toArray__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class int__toArray__LambdaImpl0 implements IntFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-int__toArray__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ int__toArray__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-int__toArray__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.int__toArray__LambdaImpl0.<init>():void");
        }

        public Object apply(int arg0) {
            return IntPipeline.m531java_util_stream_IntPipelinemthref8(arg0);
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-int_sum__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class int_sum__LambdaImpl0 implements IntBinaryOperator {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-int_sum__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ int_sum__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-int_sum__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.int_sum__LambdaImpl0.<init>():void");
        }

        public int applyAsInt(int arg0, int arg1) {
            return Integer.sum(arg0, arg1);
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0 implements BinaryOperator {
        private /* synthetic */ BiConsumer val$combiner;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.IntPipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.<init>(java.util.function.BiConsumer):void, dex: classes.dex
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
        public /* synthetic */ java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0(java.util.function.BiConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.IntPipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.<init>(java.util.function.BiConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.<init>(java.util.function.BiConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.IntPipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.IntPipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjIntConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl0 implements Supplier {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl0.<init>():void");
        }

        public Object get() {
            return IntPipeline.m528java_util_stream_IntPipelinemthref5();
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1  reason: invalid class name */
    final /* synthetic */ class java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1 implements ObjIntConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1.accept(java.lang.Object, int):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1.accept(java.lang.Object, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl1.accept(java.lang.Object, int):void");
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2  reason: invalid class name */
    final /* synthetic */ class java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2 implements BiConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_IntSummaryStatistics_summaryStatistics__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void");
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_OptionalDouble_average__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_average__LambdaImpl0 implements Supplier {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_average__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_OptionalDouble_average__LambdaImpl0.<init>():void");
        }

        public Object get() {
            return IntPipeline.m537java_util_stream_IntPipeline_lambda$9();
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_OptionalDouble_average__LambdaImpl1  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_average__LambdaImpl1 implements ObjIntConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl1.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_average__LambdaImpl1() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl1.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_OptionalDouble_average__LambdaImpl1.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl1.accept(java.lang.Object, int):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl1.accept(java.lang.Object, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_OptionalDouble_average__LambdaImpl1.accept(java.lang.Object, int):void");
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_OptionalDouble_average__LambdaImpl2  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_average__LambdaImpl2 implements BiConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl2.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_average__LambdaImpl2() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl2.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_OptionalDouble_average__LambdaImpl2.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalDouble_average__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_OptionalDouble_average__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void");
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_OptionalInt_max__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalInt_max__LambdaImpl0 implements IntBinaryOperator {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalInt_max__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalInt_max__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalInt_max__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_OptionalInt_max__LambdaImpl0.<init>():void");
        }

        public int applyAsInt(int arg0, int arg1) {
            return Math.max(arg0, arg1);
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_OptionalInt_min__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalInt_min__LambdaImpl0 implements IntBinaryOperator {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalInt_min__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalInt_min__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_OptionalInt_min__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_OptionalInt_min__LambdaImpl0.<init>():void");
        }

        public int applyAsInt(int arg0, int arg1) {
            return Math.min(arg0, arg1);
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0 implements IntConsumer {

        /* renamed from: val$-lambdaCtx  reason: not valid java name */
        private /* synthetic */ Sink f63val$lambdaCtx;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.IntPipeline.-java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.<init>(java.util.stream.Sink):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0(java.util.stream.Sink r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.IntPipeline.-java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.<init>(java.util.stream.Sink):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.<init>(java.util.stream.Sink):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.IntPipeline.-java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.accept(int):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.IntPipeline.-java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.accept(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_function_IntConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.accept(int):void");
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_stream_IntStream_distinct__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_IntStream_distinct__LambdaImpl0 implements ToIntFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntStream_distinct__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_stream_IntStream_distinct__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntStream_distinct__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_stream_IntStream_distinct__LambdaImpl0.<init>():void");
        }

        public int applyAsInt(Object arg0) {
            return IntPipeline.m535java_util_stream_IntPipeline_lambda$4((Integer) arg0);
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-java_util_stream_Stream_boxed__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_Stream_boxed__LambdaImpl0 implements IntFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_Stream_boxed__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_stream_Stream_boxed__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_Stream_boxed__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.java_util_stream_Stream_boxed__LambdaImpl0.<init>():void");
        }

        public Object apply(int arg0) {
            return Integer.valueOf(arg0);
        }
    }

    /* renamed from: java.util.stream.IntPipeline$-long_count__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class long_count__LambdaImpl0 implements IntToLongFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-long_count__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ long_count__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-long_count__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.long_count__LambdaImpl0.<init>():void");
        }

        public long applyAsLong(int arg0) {
            return IntPipeline.m536java_util_stream_IntPipeline_lambda$8(arg0);
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline-mthref-0(java.util.stream.Sink, int):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_IntPipeline-mthref-0 */
    static /* synthetic */ void m523java_util_stream_IntPipelinemthref0(java.util.stream.Sink r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline-mthref-0(java.util.stream.Sink, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.m523java_util_stream_IntPipelinemthref0(java.util.stream.Sink, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline-mthref-6(java.util.IntSummaryStatistics, int):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_IntPipeline-mthref-6 */
    static /* synthetic */ void m529java_util_stream_IntPipelinemthref6(java.util.IntSummaryStatistics r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline-mthref-6(java.util.IntSummaryStatistics, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.m529java_util_stream_IntPipelinemthref6(java.util.IntSummaryStatistics, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline-mthref-7(java.util.IntSummaryStatistics, java.util.IntSummaryStatistics):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_IntPipeline-mthref-7 */
    static /* synthetic */ void m530java_util_stream_IntPipelinemthref7(java.util.IntSummaryStatistics r1, java.util.IntSummaryStatistics r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline-mthref-7(java.util.IntSummaryStatistics, java.util.IntSummaryStatistics):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.m530java_util_stream_IntPipelinemthref7(java.util.IntSummaryStatistics, java.util.IntSummaryStatistics):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline_lambda$10(long[], int):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_IntPipeline_lambda$10 */
    static /* synthetic */ void m532java_util_stream_IntPipeline_lambda$10(long[] r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline_lambda$10(long[], int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.m532java_util_stream_IntPipeline_lambda$10(long[], int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline_lambda$11(long[], long[]):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_IntPipeline_lambda$11 */
    static /* synthetic */ void m533java_util_stream_IntPipeline_lambda$11(long[] r1, long[] r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline_lambda$11(long[], long[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.m533java_util_stream_IntPipeline_lambda$11(long[], long[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline_lambda$4(java.lang.Integer):int, dex: classes.dex
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
    /* renamed from: -java_util_stream_IntPipeline_lambda$4 */
    static /* synthetic */ int m535java_util_stream_IntPipeline_lambda$4(java.lang.Integer r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.-java_util_stream_IntPipeline_lambda$4(java.lang.Integer):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.m535java_util_stream_IntPipeline_lambda$4(java.lang.Integer):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
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
    IntPipeline(java.util.Spliterator<java.lang.Integer> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.<init>(java.util.Spliterator, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
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
    IntPipeline(java.util.function.Supplier<? extends java.util.Spliterator<java.lang.Integer>> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.<init>(java.util.function.Supplier, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
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
    IntPipeline(java.util.stream.AbstractPipeline<?, E_IN, ?> r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.<init>(java.util.stream.AbstractPipeline, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.adapt(java.util.stream.Sink):java.util.function.IntConsumer, dex: classes.dex
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
    private static java.util.function.IntConsumer adapt(java.util.stream.Sink<java.lang.Integer> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.adapt(java.util.stream.Sink):java.util.function.IntConsumer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.adapt(java.util.stream.Sink):java.util.function.IntConsumer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.allMatch(java.util.function.IntPredicate):boolean, dex: classes.dex
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
    public final boolean allMatch(java.util.function.IntPredicate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.allMatch(java.util.function.IntPredicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.allMatch(java.util.function.IntPredicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.anyMatch(java.util.function.IntPredicate):boolean, dex: classes.dex
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
    public final boolean anyMatch(java.util.function.IntPredicate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.anyMatch(java.util.function.IntPredicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.anyMatch(java.util.function.IntPredicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.average():java.util.OptionalDouble, dex: classes.dex
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
    public final java.util.OptionalDouble average() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.average():java.util.OptionalDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.average():java.util.OptionalDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.boxed():java.util.stream.Stream<java.lang.Integer>, dex: classes.dex
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
    public final java.util.stream.Stream<java.lang.Integer> boxed() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.boxed():java.util.stream.Stream<java.lang.Integer>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.boxed():java.util.stream.Stream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.collect(java.util.function.Supplier, java.util.function.ObjIntConsumer, java.util.function.BiConsumer):R, dex: classes.dex
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
    public final <R> R collect(java.util.function.Supplier<R> r1, java.util.function.ObjIntConsumer<R> r2, java.util.function.BiConsumer<R, R> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.collect(java.util.function.Supplier, java.util.function.ObjIntConsumer, java.util.function.BiConsumer):R, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.collect(java.util.function.Supplier, java.util.function.ObjIntConsumer, java.util.function.BiConsumer):java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.count():long, dex: classes.dex
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
    public final long count() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.count():long, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.count():long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.distinct():java.util.stream.IntStream, dex: classes.dex
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
    public final java.util.stream.IntStream distinct() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.distinct():java.util.stream.IntStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.distinct():java.util.stream.IntStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.findAny():java.util.OptionalInt, dex: classes.dex
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
    public final java.util.OptionalInt findAny() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.findAny():java.util.OptionalInt, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.findAny():java.util.OptionalInt");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.findFirst():java.util.OptionalInt, dex: classes.dex
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
    public final java.util.OptionalInt findFirst() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.findFirst():java.util.OptionalInt, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.findFirst():java.util.OptionalInt");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.forEach(java.util.function.IntConsumer):void, dex: classes.dex
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
    public void forEach(java.util.function.IntConsumer r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.forEach(java.util.function.IntConsumer):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.forEach(java.util.function.IntConsumer):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.forEachOrdered(java.util.function.IntConsumer):void, dex: classes.dex
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
    public void forEachOrdered(java.util.function.IntConsumer r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.forEachOrdered(java.util.function.IntConsumer):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.forEachOrdered(java.util.function.IntConsumer):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
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
    public final void forEachWithCancel(java.util.Spliterator<java.lang.Integer> r1, java.util.stream.Sink<java.lang.Integer> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.iterator():java.util.Iterator, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.iterator():java.util.Iterator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.iterator():java.util.Iterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.iterator():java.util.PrimitiveIterator$OfInt, dex: classes.dex
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
    public final java.util.PrimitiveIterator.OfInt iterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.iterator():java.util.PrimitiveIterator$OfInt, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.iterator():java.util.PrimitiveIterator$OfInt");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.lazySpliterator(java.util.function.Supplier):java.util.Spliterator, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.Spliterator lazySpliterator(java.util.function.Supplier r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.lazySpliterator(java.util.function.Supplier):java.util.Spliterator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.lazySpliterator(java.util.function.Supplier):java.util.Spliterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.max():java.util.OptionalInt, dex: classes.dex
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
    public final java.util.OptionalInt max() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.max():java.util.OptionalInt, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.max():java.util.OptionalInt");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.min():java.util.OptionalInt, dex: classes.dex
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
    public final java.util.OptionalInt min() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.min():java.util.OptionalInt, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.min():java.util.OptionalInt");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.noneMatch(java.util.function.IntPredicate):boolean, dex: classes.dex
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
    public final boolean noneMatch(java.util.function.IntPredicate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.noneMatch(java.util.function.IntPredicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.noneMatch(java.util.function.IntPredicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.parallel():java.util.stream.IntStream, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.stream.IntStream parallel() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.parallel():java.util.stream.IntStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.parallel():java.util.stream.IntStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.reduce(int, java.util.function.IntBinaryOperator):int, dex: classes.dex
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
    public final int reduce(int r1, java.util.function.IntBinaryOperator r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.reduce(int, java.util.function.IntBinaryOperator):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.reduce(int, java.util.function.IntBinaryOperator):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.reduce(java.util.function.IntBinaryOperator):java.util.OptionalInt, dex: classes.dex
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
    public final java.util.OptionalInt reduce(java.util.function.IntBinaryOperator r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.reduce(java.util.function.IntBinaryOperator):java.util.OptionalInt, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.reduce(java.util.function.IntBinaryOperator):java.util.OptionalInt");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.sequential():java.util.stream.IntStream, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.stream.IntStream sequential() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.sequential():java.util.stream.IntStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.sequential():java.util.stream.IntStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.spliterator():java.util.Spliterator, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.Spliterator spliterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.spliterator():java.util.Spliterator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.spliterator():java.util.Spliterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.sum():int, dex: classes.dex
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
    public final int sum() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.sum():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.sum():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.summaryStatistics():java.util.IntSummaryStatistics, dex: classes.dex
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
    public final java.util.IntSummaryStatistics summaryStatistics() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.summaryStatistics():java.util.IntSummaryStatistics, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.summaryStatistics():java.util.IntSummaryStatistics");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.toArray():int[], dex: classes.dex
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
    public final int[] toArray() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.toArray():int[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.toArray():int[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.unordered():java.util.stream.BaseStream, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.stream.BaseStream unordered() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.unordered():java.util.stream.BaseStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.unordered():java.util.stream.BaseStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.unordered():java.util.stream.IntStream, dex: classes.dex
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
    public java.util.stream.IntStream unordered() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.unordered():java.util.stream.IntStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.unordered():java.util.stream.IntStream");
    }

    /* access modifiers changed from: private */
    public static Spliterator.OfInt adapt(Spliterator<Integer> s) {
        if (s instanceof Spliterator.OfInt) {
            return (Spliterator.OfInt) s;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using IntStream.adapt(Spliterator<Integer> s)");
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    public final StreamShape getOutputShape() {
        return StreamShape.INT_VALUE;
    }

    public final <P_IN> Node<Integer> evaluateToNode(PipelineHelper<Integer> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<Integer[]> intFunction) {
        return Nodes.collectInt(helper, spliterator, flattenTree);
    }

    public final <P_IN> Spliterator<Integer> wrap(PipelineHelper<Integer> ph, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.IntWrappingSpliterator(ph, supplier, isParallel);
    }

    public final Spliterator.OfInt lazySpliterator(Supplier<? extends Spliterator<Integer>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator.OfInt(supplier);
    }

    public final Node.Builder<Integer> makeNodeBuilder(long exactSizeIfKnown, IntFunction<Integer[]> intFunction) {
        return Nodes.intBuilder(exactSizeIfKnown);
    }

    public final Spliterator.OfInt spliterator() {
        return adapt((Spliterator<Integer>) super.spliterator());
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.LongStream asLongStream() {
        /*
            r4 = this;
            java.util.stream.IntPipeline$1 r0 = new java.util.stream.IntPipeline$1
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.INT_VALUE
            int r2 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r3 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r2 = r2 | r3
            r0.<init>(r4, r4, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.asLongStream():java.util.stream.LongStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream asDoubleStream() {
        /*
            r4 = this;
            java.util.stream.IntPipeline$2 r0 = new java.util.stream.IntPipeline$2
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.INT_VALUE
            int r2 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r3 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r2 = r2 | r3
            r0.<init>(r4, r4, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.asDoubleStream():java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.IntStream map(java.util.function.IntUnaryOperator r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.IntPipeline$3 r0 = new java.util.stream.IntPipeline$3
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.INT_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.map(java.util.function.IntUnaryOperator):java.util.stream.IntStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final <U> java.util.stream.Stream<U> mapToObj(java.util.function.IntFunction<? extends U> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.IntPipeline$4 r0 = new java.util.stream.IntPipeline$4
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.INT_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.mapToObj(java.util.function.IntFunction):java.util.stream.Stream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.LongStream mapToLong(java.util.function.IntToLongFunction r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.IntPipeline$5 r0 = new java.util.stream.IntPipeline$5
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.INT_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.mapToLong(java.util.function.IntToLongFunction):java.util.stream.LongStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream mapToDouble(java.util.function.IntToDoubleFunction r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.IntPipeline$6 r0 = new java.util.stream.IntPipeline$6
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.INT_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.mapToDouble(java.util.function.IntToDoubleFunction):java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.IntStream flatMap(java.util.function.IntFunction<? extends java.util.stream.IntStream> r7) {
        /*
            r6 = this;
            java.util.stream.IntPipeline$7 r0 = new java.util.stream.IntPipeline$7
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.INT_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r1 = r1 | r2
            int r2 = java.util.stream.StreamOpFlag.NOT_SIZED
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.flatMap(java.util.function.IntFunction):java.util.stream.IntStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.IntStream filter(java.util.function.IntPredicate r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.IntPipeline$9 r0 = new java.util.stream.IntPipeline$9
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.INT_VALUE
            int r4 = java.util.stream.StreamOpFlag.NOT_SIZED
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.filter(java.util.function.IntPredicate):java.util.stream.IntStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.IntStream peek(java.util.function.IntConsumer r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.IntPipeline$10 r0 = new java.util.stream.IntPipeline$10
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.INT_VALUE
            r4 = 0
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.peek(java.util.function.IntConsumer):java.util.stream.IntStream");
    }

    public final IntStream limit(long maxSize) {
        if (maxSize >= 0) {
            return SliceOps.makeInt(this, 0, maxSize);
        }
        throw new IllegalArgumentException(Long.toString(maxSize));
    }

    public final IntStream skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(Long.toString(n));
        } else if (n == 0) {
            return this;
        } else {
            return SliceOps.makeInt(this, n, -1);
        }
    }

    public final IntStream sorted() {
        return SortedOps.makeInt(this);
    }

    /* renamed from: -java_util_stream_IntPipeline_lambda$8  reason: not valid java name */
    static /* synthetic */ long m536java_util_stream_IntPipeline_lambda$8(int e) {
        return 1;
    }

    /* renamed from: -java_util_stream_IntPipeline_lambda$9  reason: not valid java name */
    static /* synthetic */ long[] m537java_util_stream_IntPipeline_lambda$9() {
        return new long[2];
    }

    /* renamed from: -java_util_stream_IntPipeline-mthref-5  reason: not valid java name */
    static /* synthetic */ IntSummaryStatistics m528java_util_stream_IntPipelinemthref5() {
        return new IntSummaryStatistics();
    }

    /* renamed from: -java_util_stream_IntPipeline-mthref-8  reason: not valid java name */
    static /* synthetic */ Integer[] m531java_util_stream_IntPipelinemthref8(int i) {
        return new Integer[i];
    }

    public static class Head<E_IN> extends IntPipeline<E_IN> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.Head.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
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
        public Head(java.util.Spliterator<java.lang.Integer> r1, int r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.Head.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.Head.<init>(java.util.Spliterator, int, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.Head.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
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
        public Head(java.util.function.Supplier<? extends java.util.Spliterator<java.lang.Integer>> r1, int r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.IntPipeline.Head.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.Head.<init>(java.util.function.Supplier, int, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.Head.forEach(java.util.function.IntConsumer):void, dex: classes.dex
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
        public void forEach(java.util.function.IntConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.Head.forEach(java.util.function.IntConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.Head.forEach(java.util.function.IntConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.Head.forEachOrdered(java.util.function.IntConsumer):void, dex: classes.dex
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
        public void forEachOrdered(java.util.function.IntConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.Head.forEachOrdered(java.util.function.IntConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.Head.forEachOrdered(java.util.function.IntConsumer):void");
        }

        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        public final Sink<E_IN> opWrapSink(int flags, Sink<Integer> sink) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class StatelessOp<E_IN> extends IntPipeline<E_IN> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f65assertionsDisabled = false;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatelessOp.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatelessOp.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.StatelessOp.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
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
        public StatelessOp(java.util.stream.AbstractPipeline<?, E_IN, ?> r1, java.util.stream.StreamShape r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void");
        }

        public final boolean opIsStateful() {
            return false;
        }
    }

    public static abstract class StatefulOp<E_IN> extends IntPipeline<E_IN> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f64assertionsDisabled = false;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatefulOp.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatefulOp.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.StatefulOp.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
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
        public StatefulOp(java.util.stream.AbstractPipeline<?, E_IN, ?> r1, java.util.stream.StreamShape r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.IntPipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntPipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void");
        }

        public abstract <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> intFunction);

        public final boolean opIsStateful() {
            return true;
        }
    }
}
