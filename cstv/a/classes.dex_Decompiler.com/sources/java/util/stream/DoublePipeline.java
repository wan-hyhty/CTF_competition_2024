package java.util.stream;

import java.util.DoubleSummaryStatistics;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
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
public abstract class DoublePipeline<E_IN> extends AbstractPipeline<E_IN, Double, DoubleStream> implements DoubleStream {

    /* renamed from: java.util.stream.DoublePipeline$-double__toArray__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class double__toArray__LambdaImpl0 implements IntFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double__toArray__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ double__toArray__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double__toArray__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.double__toArray__LambdaImpl0.<init>():void");
        }

        public Object apply(int arg0) {
            return DoublePipeline.m502java_util_stream_DoublePipelinemthref7(arg0);
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-double_sum__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class double_sum__LambdaImpl0 implements Supplier {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ double_sum__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.double_sum__LambdaImpl0.<init>():void");
        }

        public Object get() {
            return DoublePipeline.m509java_util_stream_DoublePipeline_lambda$5();
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-double_sum__LambdaImpl1  reason: invalid class name */
    final /* synthetic */ class double_sum__LambdaImpl1 implements ObjDoubleConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl1.<init>():void, dex: classes.dex
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
        public /* synthetic */ double_sum__LambdaImpl1() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl1.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.double_sum__LambdaImpl1.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl1.accept(java.lang.Object, double):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, double r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl1.accept(java.lang.Object, double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.double_sum__LambdaImpl1.accept(java.lang.Object, double):void");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-double_sum__LambdaImpl2  reason: invalid class name */
    final /* synthetic */ class double_sum__LambdaImpl2 implements BiConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl2.<init>():void, dex: classes.dex
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
        public /* synthetic */ double_sum__LambdaImpl2() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl2.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.double_sum__LambdaImpl2.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-double_sum__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.double_sum__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0 implements BinaryOperator {
        private /* synthetic */ BiConsumer val$combiner;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.DoublePipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.<init>(java.util.function.BiConsumer):void, dex: classes.dex
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
        public /* synthetic */ java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0(java.util.function.BiConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.DoublePipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.<init>(java.util.function.BiConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.<init>(java.util.function.BiConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.DoublePipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
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
        public java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.DoublePipeline.-java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_lang_Object_collect_java_util_function_Supplier_supplier_java_util_function_ObjDoubleConsumer_accumulator_java_util_function_BiConsumer_combiner_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl0 implements Supplier {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl0.<init>():void");
        }

        public Object get() {
            return DoublePipeline.m499java_util_stream_DoublePipelinemthref4();
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1  reason: invalid class name */
    final /* synthetic */ class java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1 implements ObjDoubleConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1.accept(java.lang.Object, double):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, double r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1.accept(java.lang.Object, double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl1.accept(java.lang.Object, double):void");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2  reason: invalid class name */
    final /* synthetic */ class java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2 implements BiConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_DoubleSummaryStatistics_summaryStatistics__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_OptionalDouble_average__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_average__LambdaImpl0 implements Supplier {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_average__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_OptionalDouble_average__LambdaImpl0.<init>():void");
        }

        public Object get() {
            return DoublePipeline.m503java_util_stream_DoublePipeline_lambda$10();
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_OptionalDouble_average__LambdaImpl1  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_average__LambdaImpl1 implements ObjDoubleConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl1.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_average__LambdaImpl1() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl1.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_OptionalDouble_average__LambdaImpl1.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl1.accept(java.lang.Object, double):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, double r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl1.accept(java.lang.Object, double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_OptionalDouble_average__LambdaImpl1.accept(java.lang.Object, double):void");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_OptionalDouble_average__LambdaImpl2  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_average__LambdaImpl2 implements BiConsumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl2.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_average__LambdaImpl2() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl2.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_OptionalDouble_average__LambdaImpl2.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
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
        public void accept(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_average__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_OptionalDouble_average__LambdaImpl2.accept(java.lang.Object, java.lang.Object):void");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_OptionalDouble_max__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_max__LambdaImpl0 implements DoubleBinaryOperator {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_max__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_max__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_max__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_OptionalDouble_max__LambdaImpl0.<init>():void");
        }

        public double applyAsDouble(double arg0, double arg1) {
            return Math.max(arg0, arg1);
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_OptionalDouble_min__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_OptionalDouble_min__LambdaImpl0 implements DoubleBinaryOperator {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_min__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_OptionalDouble_min__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_OptionalDouble_min__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_OptionalDouble_min__LambdaImpl0.<init>():void");
        }

        public double applyAsDouble(double arg0, double arg1) {
            return Math.min(arg0, arg1);
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0 implements DoubleConsumer {

        /* renamed from: val$-lambdaCtx  reason: not valid java name */
        private /* synthetic */ Sink f60val$lambdaCtx;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.DoublePipeline.-java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.<init>(java.util.stream.Sink):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0(java.util.stream.Sink r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.DoublePipeline.-java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.<init>(java.util.stream.Sink):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.<init>(java.util.stream.Sink):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.DoublePipeline.-java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.accept(double):void, dex: classes.dex
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
        public void accept(double r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.DoublePipeline.-java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.accept(double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_function_DoubleConsumer_adapt_java_util_stream_Sink_sink_LambdaImpl0.accept(double):void");
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_stream_DoubleStream_distinct__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_DoubleStream_distinct__LambdaImpl0 implements ToDoubleFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoubleStream_distinct__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_stream_DoubleStream_distinct__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoubleStream_distinct__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_stream_DoubleStream_distinct__LambdaImpl0.<init>():void");
        }

        public double applyAsDouble(Object arg0) {
            return DoublePipeline.m508java_util_stream_DoublePipeline_lambda$4((Double) arg0);
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-java_util_stream_Stream_boxed__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_Stream_boxed__LambdaImpl0 implements DoubleFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_Stream_boxed__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_stream_Stream_boxed__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_Stream_boxed__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.java_util_stream_Stream_boxed__LambdaImpl0.<init>():void");
        }

        public Object apply(double arg0) {
            return Double.valueOf(arg0);
        }
    }

    /* renamed from: java.util.stream.DoublePipeline$-long_count__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class long_count__LambdaImpl0 implements DoubleToLongFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-long_count__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ long_count__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-long_count__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.long_count__LambdaImpl0.<init>():void");
        }

        public long applyAsLong(double arg0) {
            return DoublePipeline.m506java_util_stream_DoublePipeline_lambda$13(arg0);
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline-mthref-0(java.util.stream.Sink, double):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline-mthref-0 */
    static /* synthetic */ void m495java_util_stream_DoublePipelinemthref0(java.util.stream.Sink r1, double r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline-mthref-0(java.util.stream.Sink, double):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m495java_util_stream_DoublePipelinemthref0(java.util.stream.Sink, double):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline-mthref-5(java.util.DoubleSummaryStatistics, double):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline-mthref-5 */
    static /* synthetic */ void m500java_util_stream_DoublePipelinemthref5(java.util.DoubleSummaryStatistics r1, double r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline-mthref-5(java.util.DoubleSummaryStatistics, double):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m500java_util_stream_DoublePipelinemthref5(java.util.DoubleSummaryStatistics, double):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline-mthref-6(java.util.DoubleSummaryStatistics, java.util.DoubleSummaryStatistics):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline-mthref-6 */
    static /* synthetic */ void m501java_util_stream_DoublePipelinemthref6(java.util.DoubleSummaryStatistics r1, java.util.DoubleSummaryStatistics r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline-mthref-6(java.util.DoubleSummaryStatistics, java.util.DoubleSummaryStatistics):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m501java_util_stream_DoublePipelinemthref6(java.util.DoubleSummaryStatistics, java.util.DoubleSummaryStatistics):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$11(double[], double):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline_lambda$11 */
    static /* synthetic */ void m504java_util_stream_DoublePipeline_lambda$11(double[] r1, double r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$11(double[], double):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m504java_util_stream_DoublePipeline_lambda$11(double[], double):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$12(double[], double[]):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline_lambda$12 */
    static /* synthetic */ void m505java_util_stream_DoublePipeline_lambda$12(double[] r1, double[] r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$12(double[], double[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m505java_util_stream_DoublePipeline_lambda$12(double[], double[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$4(java.lang.Double):double, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline_lambda$4 */
    static /* synthetic */ double m508java_util_stream_DoublePipeline_lambda$4(java.lang.Double r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$4(java.lang.Double):double, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m508java_util_stream_DoublePipeline_lambda$4(java.lang.Double):double");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$6(double[], double):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline_lambda$6 */
    static /* synthetic */ void m510java_util_stream_DoublePipeline_lambda$6(double[] r1, double r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$6(double[], double):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m510java_util_stream_DoublePipeline_lambda$6(double[], double):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$7(double[], double[]):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_DoublePipeline_lambda$7 */
    static /* synthetic */ void m511java_util_stream_DoublePipeline_lambda$7(double[] r1, double[] r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.-java_util_stream_DoublePipeline_lambda$7(double[], double[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.m511java_util_stream_DoublePipeline_lambda$7(double[], double[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
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
    DoublePipeline(java.util.Spliterator<java.lang.Double> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.<init>(java.util.Spliterator, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
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
    DoublePipeline(java.util.function.Supplier<? extends java.util.Spliterator<java.lang.Double>> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.<init>(java.util.function.Supplier, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
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
    DoublePipeline(java.util.stream.AbstractPipeline<?, E_IN, ?> r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.<init>(java.util.stream.AbstractPipeline, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.adapt(java.util.stream.Sink):java.util.function.DoubleConsumer, dex: classes.dex
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
    private static java.util.function.DoubleConsumer adapt(java.util.stream.Sink<java.lang.Double> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.adapt(java.util.stream.Sink):java.util.function.DoubleConsumer, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.adapt(java.util.stream.Sink):java.util.function.DoubleConsumer");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.allMatch(java.util.function.DoublePredicate):boolean, dex: classes.dex
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
    public final boolean allMatch(java.util.function.DoublePredicate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.allMatch(java.util.function.DoublePredicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.allMatch(java.util.function.DoublePredicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.anyMatch(java.util.function.DoublePredicate):boolean, dex: classes.dex
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
    public final boolean anyMatch(java.util.function.DoublePredicate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.anyMatch(java.util.function.DoublePredicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.anyMatch(java.util.function.DoublePredicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.average():java.util.OptionalDouble, dex: classes.dex
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
    public final java.util.OptionalDouble average() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.average():java.util.OptionalDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.average():java.util.OptionalDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.boxed():java.util.stream.Stream<java.lang.Double>, dex: classes.dex
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
    public final java.util.stream.Stream<java.lang.Double> boxed() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.boxed():java.util.stream.Stream<java.lang.Double>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.boxed():java.util.stream.Stream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.collect(java.util.function.Supplier, java.util.function.ObjDoubleConsumer, java.util.function.BiConsumer):R, dex: classes.dex
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
    public final <R> R collect(java.util.function.Supplier<R> r1, java.util.function.ObjDoubleConsumer<R> r2, java.util.function.BiConsumer<R, R> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.collect(java.util.function.Supplier, java.util.function.ObjDoubleConsumer, java.util.function.BiConsumer):R, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.collect(java.util.function.Supplier, java.util.function.ObjDoubleConsumer, java.util.function.BiConsumer):java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.count():long, dex: classes.dex
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
    public final long count() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.count():long, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.count():long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.distinct():java.util.stream.DoubleStream, dex: classes.dex
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
    public final java.util.stream.DoubleStream distinct() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.distinct():java.util.stream.DoubleStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.distinct():java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.findAny():java.util.OptionalDouble, dex: classes.dex
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
    public final java.util.OptionalDouble findAny() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.findAny():java.util.OptionalDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.findAny():java.util.OptionalDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.findFirst():java.util.OptionalDouble, dex: classes.dex
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
    public final java.util.OptionalDouble findFirst() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.findFirst():java.util.OptionalDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.findFirst():java.util.OptionalDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.forEach(java.util.function.DoubleConsumer):void, dex: classes.dex
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
    public void forEach(java.util.function.DoubleConsumer r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.forEach(java.util.function.DoubleConsumer):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.forEach(java.util.function.DoubleConsumer):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.forEachOrdered(java.util.function.DoubleConsumer):void, dex: classes.dex
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
    public void forEachOrdered(java.util.function.DoubleConsumer r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.forEachOrdered(java.util.function.DoubleConsumer):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.forEachOrdered(java.util.function.DoubleConsumer):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
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
    public final void forEachWithCancel(java.util.Spliterator<java.lang.Double> r1, java.util.stream.Sink<java.lang.Double> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.iterator():java.util.Iterator, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.iterator():java.util.Iterator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.iterator():java.util.Iterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.iterator():java.util.PrimitiveIterator$OfDouble, dex: classes.dex
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
    public final java.util.PrimitiveIterator.OfDouble iterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.iterator():java.util.PrimitiveIterator$OfDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.iterator():java.util.PrimitiveIterator$OfDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.lazySpliterator(java.util.function.Supplier):java.util.Spliterator, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.Spliterator lazySpliterator(java.util.function.Supplier r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.lazySpliterator(java.util.function.Supplier):java.util.Spliterator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.lazySpliterator(java.util.function.Supplier):java.util.Spliterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.max():java.util.OptionalDouble, dex: classes.dex
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
    public final java.util.OptionalDouble max() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.max():java.util.OptionalDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.max():java.util.OptionalDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.min():java.util.OptionalDouble, dex: classes.dex
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
    public final java.util.OptionalDouble min() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.min():java.util.OptionalDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.min():java.util.OptionalDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.noneMatch(java.util.function.DoublePredicate):boolean, dex: classes.dex
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
    public final boolean noneMatch(java.util.function.DoublePredicate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.noneMatch(java.util.function.DoublePredicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.noneMatch(java.util.function.DoublePredicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.parallel():java.util.stream.DoubleStream, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.stream.DoubleStream parallel() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.parallel():java.util.stream.DoubleStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.parallel():java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.reduce(double, java.util.function.DoubleBinaryOperator):double, dex: classes.dex
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
    public final double reduce(double r1, java.util.function.DoubleBinaryOperator r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.reduce(double, java.util.function.DoubleBinaryOperator):double, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.reduce(double, java.util.function.DoubleBinaryOperator):double");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.reduce(java.util.function.DoubleBinaryOperator):java.util.OptionalDouble, dex: classes.dex
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
    public final java.util.OptionalDouble reduce(java.util.function.DoubleBinaryOperator r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.reduce(java.util.function.DoubleBinaryOperator):java.util.OptionalDouble, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.reduce(java.util.function.DoubleBinaryOperator):java.util.OptionalDouble");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.sequential():java.util.stream.DoubleStream, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.stream.DoubleStream sequential() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.sequential():java.util.stream.DoubleStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.sequential():java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.spliterator():java.util.Spliterator, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.Spliterator spliterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.spliterator():java.util.Spliterator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.spliterator():java.util.Spliterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.sum():double, dex: classes.dex
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
    public final double sum() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.sum():double, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.sum():double");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.summaryStatistics():java.util.DoubleSummaryStatistics, dex: classes.dex
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
    public final java.util.DoubleSummaryStatistics summaryStatistics() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.summaryStatistics():java.util.DoubleSummaryStatistics, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.summaryStatistics():java.util.DoubleSummaryStatistics");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.toArray():double[], dex: classes.dex
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
    public final double[] toArray() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.toArray():double[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.toArray():double[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.unordered():java.util.stream.BaseStream, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.util.stream.BaseStream unordered() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.unordered():java.util.stream.BaseStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.unordered():java.util.stream.BaseStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.unordered():java.util.stream.DoubleStream, dex: classes.dex
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
    public java.util.stream.DoubleStream unordered() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.unordered():java.util.stream.DoubleStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.unordered():java.util.stream.DoubleStream");
    }

    /* access modifiers changed from: private */
    public static Spliterator.OfDouble adapt(Spliterator<Double> s) {
        if (s instanceof Spliterator.OfDouble) {
            return (Spliterator.OfDouble) s;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    public final StreamShape getOutputShape() {
        return StreamShape.DOUBLE_VALUE;
    }

    public final <P_IN> Node<Double> evaluateToNode(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<Double[]> intFunction) {
        return Nodes.collectDouble(helper, spliterator, flattenTree);
    }

    public final <P_IN> Spliterator<Double> wrap(PipelineHelper<Double> ph, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.DoubleWrappingSpliterator(ph, supplier, isParallel);
    }

    public final Spliterator.OfDouble lazySpliterator(Supplier<? extends Spliterator<Double>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator.OfDouble(supplier);
    }

    public final Node.Builder<Double> makeNodeBuilder(long exactSizeIfKnown, IntFunction<Double[]> intFunction) {
        return Nodes.doubleBuilder(exactSizeIfKnown);
    }

    public final Spliterator.OfDouble spliterator() {
        return adapt((Spliterator<Double>) super.spliterator());
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream map(java.util.function.DoubleUnaryOperator r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.DoublePipeline$1 r0 = new java.util.stream.DoublePipeline$1
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.DOUBLE_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.map(java.util.function.DoubleUnaryOperator):java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final <U> java.util.stream.Stream<U> mapToObj(java.util.function.DoubleFunction<? extends U> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.DoublePipeline$2 r0 = new java.util.stream.DoublePipeline$2
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.DOUBLE_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.mapToObj(java.util.function.DoubleFunction):java.util.stream.Stream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.IntStream mapToInt(java.util.function.DoubleToIntFunction r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.DoublePipeline$3 r0 = new java.util.stream.DoublePipeline$3
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.DOUBLE_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.mapToInt(java.util.function.DoubleToIntFunction):java.util.stream.IntStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.LongStream mapToLong(java.util.function.DoubleToLongFunction r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.DoublePipeline$4 r0 = new java.util.stream.DoublePipeline$4
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.DOUBLE_VALUE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.mapToLong(java.util.function.DoubleToLongFunction):java.util.stream.LongStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream flatMap(java.util.function.DoubleFunction<? extends java.util.stream.DoubleStream> r7) {
        /*
            r6 = this;
            java.util.stream.DoublePipeline$5 r0 = new java.util.stream.DoublePipeline$5
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.DOUBLE_VALUE
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
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.flatMap(java.util.function.DoubleFunction):java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream filter(java.util.function.DoublePredicate r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.DoublePipeline$7 r0 = new java.util.stream.DoublePipeline$7
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.DOUBLE_VALUE
            int r4 = java.util.stream.StreamOpFlag.NOT_SIZED
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.filter(java.util.function.DoublePredicate):java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream peek(java.util.function.DoubleConsumer r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.DoublePipeline$8 r0 = new java.util.stream.DoublePipeline$8
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.DOUBLE_VALUE
            r4 = 0
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.peek(java.util.function.DoubleConsumer):java.util.stream.DoubleStream");
    }

    public final DoubleStream limit(long maxSize) {
        if (maxSize >= 0) {
            return SliceOps.makeDouble(this, 0, maxSize);
        }
        throw new IllegalArgumentException(Long.toString(maxSize));
    }

    public final DoubleStream skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(Long.toString(n));
        } else if (n == 0) {
            return this;
        } else {
            return SliceOps.makeDouble(this, n, -1);
        }
    }

    public final DoubleStream sorted() {
        return SortedOps.makeDouble(this);
    }

    /* renamed from: -java_util_stream_DoublePipeline_lambda$5  reason: not valid java name */
    static /* synthetic */ double[] m509java_util_stream_DoublePipeline_lambda$5() {
        return new double[3];
    }

    /* renamed from: -java_util_stream_DoublePipeline_lambda$10  reason: not valid java name */
    static /* synthetic */ double[] m503java_util_stream_DoublePipeline_lambda$10() {
        return new double[4];
    }

    /* renamed from: -java_util_stream_DoublePipeline_lambda$13  reason: not valid java name */
    static /* synthetic */ long m506java_util_stream_DoublePipeline_lambda$13(double e) {
        return 1;
    }

    /* renamed from: -java_util_stream_DoublePipeline-mthref-4  reason: not valid java name */
    static /* synthetic */ DoubleSummaryStatistics m499java_util_stream_DoublePipelinemthref4() {
        return new DoubleSummaryStatistics();
    }

    /* renamed from: -java_util_stream_DoublePipeline-mthref-7  reason: not valid java name */
    static /* synthetic */ Double[] m502java_util_stream_DoublePipelinemthref7(int i) {
        return new Double[i];
    }

    public static class Head<E_IN> extends DoublePipeline<E_IN> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.Head.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
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
        public Head(java.util.Spliterator<java.lang.Double> r1, int r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.Head.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.Head.<init>(java.util.Spliterator, int, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.Head.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
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
        public Head(java.util.function.Supplier<? extends java.util.Spliterator<java.lang.Double>> r1, int r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.DoublePipeline.Head.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.Head.<init>(java.util.function.Supplier, int, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.Head.forEach(java.util.function.DoubleConsumer):void, dex: classes.dex
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
        public void forEach(java.util.function.DoubleConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.Head.forEach(java.util.function.DoubleConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.Head.forEach(java.util.function.DoubleConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.Head.forEachOrdered(java.util.function.DoubleConsumer):void, dex: classes.dex
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
        public void forEachOrdered(java.util.function.DoubleConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.Head.forEachOrdered(java.util.function.DoubleConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.Head.forEachOrdered(java.util.function.DoubleConsumer):void");
        }

        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        public final Sink<E_IN> opWrapSink(int flags, Sink<Double> sink) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class StatelessOp<E_IN> extends DoublePipeline<E_IN> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f62assertionsDisabled = false;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatelessOp.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatelessOp.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.StatelessOp.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
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
        public StatelessOp(java.util.stream.AbstractPipeline<?, E_IN, ?> r1, java.util.stream.StreamShape r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void");
        }

        public final boolean opIsStateful() {
            return false;
        }
    }

    public static abstract class StatefulOp<E_IN> extends DoublePipeline<E_IN> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f61assertionsDisabled = false;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatefulOp.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatefulOp.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.StatefulOp.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
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
        public StatefulOp(java.util.stream.AbstractPipeline<?, E_IN, ?> r1, java.util.stream.StreamShape r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.DoublePipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoublePipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void");
        }

        public abstract <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Double[]> intFunction);

        public final boolean opIsStateful() {
            return true;
        }
    }
}
