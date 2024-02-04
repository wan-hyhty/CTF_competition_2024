package java.util.stream;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;
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
public abstract class ReferencePipeline<P_IN, P_OUT> extends AbstractPipeline<P_IN, P_OUT, Stream<P_OUT>> implements Stream<P_OUT> {

    /* renamed from: java.util.stream.ReferencePipeline$-java_lang_Object__toArray__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_lang_Object__toArray__LambdaImpl0 implements IntFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.-java_lang_Object__toArray__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_lang_Object__toArray__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.-java_lang_Object__toArray__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.java_lang_Object__toArray__LambdaImpl0.<init>():void");
        }

        public Object apply(int arg0) {
            return ReferencePipeline.m579java_util_stream_ReferencePipelinemthref0(arg0);
        }
    }

    /* renamed from: java.util.stream.ReferencePipeline$-java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0 implements Consumer {
        private /* synthetic */ BiConsumer val$accumulator;
        private /* synthetic */ Object val$container;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ReferencePipeline.-java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0.<init>(java.util.function.BiConsumer, java.lang.Object):void, dex: classes.dex
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
        public /* synthetic */ java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0(java.util.function.BiConsumer r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ReferencePipeline.-java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0.<init>(java.util.function.BiConsumer, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0.<init>(java.util.function.BiConsumer, java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReferencePipeline.-java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
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
        public void accept(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReferencePipeline.-java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.java_lang_Object_collect_java_util_stream_Collector_collector_LambdaImpl0.accept(java.lang.Object):void");
        }
    }

    /* renamed from: java.util.stream.ReferencePipeline$-long_count__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class long_count__LambdaImpl0 implements ToLongFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.-long_count__LambdaImpl0.<init>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.-long_count__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.long_count__LambdaImpl0.<init>():void");
        }

        public long applyAsLong(Object arg0) {
            return ReferencePipeline.m581java_util_stream_ReferencePipeline_lambda$6(arg0);
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.-java_util_stream_ReferencePipeline_lambda$5(java.util.function.BiConsumer, java.lang.Object, java.lang.Object):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_ReferencePipeline_lambda$5 */
    static /* synthetic */ void m580java_util_stream_ReferencePipeline_lambda$5(java.util.function.BiConsumer r1, java.lang.Object r2, java.lang.Object r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.-java_util_stream_ReferencePipeline_lambda$5(java.util.function.BiConsumer, java.lang.Object, java.lang.Object):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.m580java_util_stream_ReferencePipeline_lambda$5(java.util.function.BiConsumer, java.lang.Object, java.lang.Object):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
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
    ReferencePipeline(java.util.Spliterator<?> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.<init>(java.util.Spliterator, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
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
    ReferencePipeline(java.util.function.Supplier<? extends java.util.Spliterator<?>> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.<init>(java.util.function.Supplier, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
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
    ReferencePipeline(java.util.stream.AbstractPipeline<?, P_IN, ?> r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.<init>(java.util.stream.AbstractPipeline, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.allMatch(java.util.function.Predicate):boolean, dex: classes.dex
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
    public final boolean allMatch(java.util.function.Predicate<? super P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.allMatch(java.util.function.Predicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.allMatch(java.util.function.Predicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.anyMatch(java.util.function.Predicate):boolean, dex: classes.dex
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
    public final boolean anyMatch(java.util.function.Predicate<? super P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.anyMatch(java.util.function.Predicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.anyMatch(java.util.function.Predicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.collect(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BiConsumer):R, dex: classes.dex
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
    public final <R> R collect(java.util.function.Supplier<R> r1, java.util.function.BiConsumer<R, ? super P_OUT> r2, java.util.function.BiConsumer<R, R> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.collect(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BiConsumer):R, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.collect(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BiConsumer):java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.collect(java.util.stream.Collector):R, dex: classes.dex
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
    public final <R, A> R collect(java.util.stream.Collector<? super P_OUT, A, R> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.collect(java.util.stream.Collector):R, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.collect(java.util.stream.Collector):java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.count():long, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.count():long, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.count():long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.findAny():java.util.Optional<P_OUT>, dex: classes.dex
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
    public final java.util.Optional<P_OUT> findAny() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.findAny():java.util.Optional<P_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.findAny():java.util.Optional");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.findFirst():java.util.Optional<P_OUT>, dex: classes.dex
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
    public final java.util.Optional<P_OUT> findFirst() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.findFirst():java.util.Optional<P_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.findFirst():java.util.Optional");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.forEach(java.util.function.Consumer):void, dex: classes.dex
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
    public void forEach(java.util.function.Consumer<? super P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.forEach(java.util.function.Consumer):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.forEach(java.util.function.Consumer):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.forEachOrdered(java.util.function.Consumer):void, dex: classes.dex
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
    public void forEachOrdered(java.util.function.Consumer<? super P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.forEachOrdered(java.util.function.Consumer):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.forEachOrdered(java.util.function.Consumer):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
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
    public final void forEachWithCancel(java.util.Spliterator<P_OUT> r1, java.util.stream.Sink<P_OUT> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.forEachWithCancel(java.util.Spliterator, java.util.stream.Sink):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.iterator():java.util.Iterator<P_OUT>, dex: classes.dex
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
    public final java.util.Iterator<P_OUT> iterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.iterator():java.util.Iterator<P_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.iterator():java.util.Iterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.max(java.util.Comparator):java.util.Optional<P_OUT>, dex: classes.dex
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
    public final java.util.Optional<P_OUT> max(java.util.Comparator<? super P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.max(java.util.Comparator):java.util.Optional<P_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.max(java.util.Comparator):java.util.Optional");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.min(java.util.Comparator):java.util.Optional<P_OUT>, dex: classes.dex
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
    public final java.util.Optional<P_OUT> min(java.util.Comparator<? super P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.min(java.util.Comparator):java.util.Optional<P_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.min(java.util.Comparator):java.util.Optional");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.noneMatch(java.util.function.Predicate):boolean, dex: classes.dex
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
    public final boolean noneMatch(java.util.function.Predicate<? super P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.noneMatch(java.util.function.Predicate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.noneMatch(java.util.function.Predicate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.reduce(java.lang.Object, java.util.function.BiFunction, java.util.function.BinaryOperator):R, dex: classes.dex
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
    public final <R> R reduce(R r1, java.util.function.BiFunction<R, ? super P_OUT, R> r2, java.util.function.BinaryOperator<R> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.reduce(java.lang.Object, java.util.function.BiFunction, java.util.function.BinaryOperator):R, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.reduce(java.lang.Object, java.util.function.BiFunction, java.util.function.BinaryOperator):java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.reduce(java.lang.Object, java.util.function.BinaryOperator):P_OUT, dex: classes.dex
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
    public final P_OUT reduce(P_OUT r1, java.util.function.BinaryOperator<P_OUT> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.reduce(java.lang.Object, java.util.function.BinaryOperator):P_OUT, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.reduce(java.lang.Object, java.util.function.BinaryOperator):java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.reduce(java.util.function.BinaryOperator):java.util.Optional<P_OUT>, dex: classes.dex
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
    public final java.util.Optional<P_OUT> reduce(java.util.function.BinaryOperator<P_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.reduce(java.util.function.BinaryOperator):java.util.Optional<P_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.reduce(java.util.function.BinaryOperator):java.util.Optional");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.toArray():java.lang.Object[], dex: classes.dex
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
    public final java.lang.Object[] toArray() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.toArray():java.lang.Object[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.toArray():java.lang.Object[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.toArray(java.util.function.IntFunction):A[], dex: classes.dex
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
    public final <A> A[] toArray(java.util.function.IntFunction<A[]> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.toArray(java.util.function.IntFunction):A[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.toArray(java.util.function.IntFunction):java.lang.Object[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.unordered():java.util.stream.BaseStream, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.unordered():java.util.stream.BaseStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.unordered():java.util.stream.BaseStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.unordered():java.util.stream.Stream<P_OUT>, dex: classes.dex
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
    public java.util.stream.Stream<P_OUT> unordered() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.unordered():java.util.stream.Stream<P_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.unordered():java.util.stream.Stream");
    }

    public final StreamShape getOutputShape() {
        return StreamShape.REFERENCE;
    }

    public final <P_IN> Node<P_OUT> evaluateToNode(PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<P_OUT[]> generator) {
        return Nodes.collect(helper, spliterator, flattenTree, generator);
    }

    public final <P_IN> Spliterator<P_OUT> wrap(PipelineHelper<P_OUT> ph, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.WrappingSpliterator(ph, supplier, isParallel);
    }

    public final Spliterator<P_OUT> lazySpliterator(Supplier<? extends Spliterator<P_OUT>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator(supplier);
    }

    public final Node.Builder<P_OUT> makeNodeBuilder(long exactSizeIfKnown, IntFunction<P_OUT[]> generator) {
        return Nodes.builder(exactSizeIfKnown, generator);
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.Stream<P_OUT> filter(java.util.function.Predicate<? super P_OUT> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$2 r0 = new java.util.stream.ReferencePipeline$2
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
            int r4 = java.util.stream.StreamOpFlag.NOT_SIZED
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.filter(java.util.function.Predicate):java.util.stream.Stream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final <R> java.util.stream.Stream<R> map(java.util.function.Function<? super P_OUT, ? extends R> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$3 r0 = new java.util.stream.ReferencePipeline$3
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.map(java.util.function.Function):java.util.stream.Stream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.IntStream mapToInt(java.util.function.ToIntFunction<? super P_OUT> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$4 r0 = new java.util.stream.ReferencePipeline$4
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.mapToInt(java.util.function.ToIntFunction):java.util.stream.IntStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.LongStream mapToLong(java.util.function.ToLongFunction<? super P_OUT> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$5 r0 = new java.util.stream.ReferencePipeline$5
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.mapToLong(java.util.function.ToLongFunction):java.util.stream.LongStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream mapToDouble(java.util.function.ToDoubleFunction<? super P_OUT> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$6 r0 = new java.util.stream.ReferencePipeline$6
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
            int r1 = java.util.stream.StreamOpFlag.NOT_SORTED
            int r2 = java.util.stream.StreamOpFlag.NOT_DISTINCT
            r4 = r1 | r2
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.mapToDouble(java.util.function.ToDoubleFunction):java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final <R> java.util.stream.Stream<R> flatMap(java.util.function.Function<? super P_OUT, ? extends java.util.stream.Stream<? extends R>> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$7 r0 = new java.util.stream.ReferencePipeline$7
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
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
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.flatMap(java.util.function.Function):java.util.stream.Stream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.IntStream flatMapToInt(java.util.function.Function<? super P_OUT, ? extends java.util.stream.IntStream> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$8 r0 = new java.util.stream.ReferencePipeline$8
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
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
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.flatMapToInt(java.util.function.Function):java.util.stream.IntStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.DoubleStream flatMapToDouble(java.util.function.Function<? super P_OUT, ? extends java.util.stream.DoubleStream> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$9 r0 = new java.util.stream.ReferencePipeline$9
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
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
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.flatMapToDouble(java.util.function.Function):java.util.stream.DoubleStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.LongStream flatMapToLong(java.util.function.Function<? super P_OUT, ? extends java.util.stream.LongStream> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$10 r0 = new java.util.stream.ReferencePipeline$10
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
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
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.flatMapToLong(java.util.function.Function):java.util.stream.LongStream");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public final java.util.stream.Stream<P_OUT> peek(java.util.function.Consumer<? super P_OUT> r7) {
        /*
            r6 = this;
            java.util.Objects.requireNonNull(r7)
            java.util.stream.ReferencePipeline$11 r0 = new java.util.stream.ReferencePipeline$11
            java.util.stream.StreamShape r3 = java.util.stream.StreamShape.REFERENCE
            r4 = 0
            r1 = r6
            r2 = r6
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.peek(java.util.function.Consumer):java.util.stream.Stream");
    }

    public final Stream<P_OUT> distinct() {
        return DistinctOps.makeRef(this);
    }

    public final Stream<P_OUT> sorted() {
        return SortedOps.makeRef(this);
    }

    public final Stream<P_OUT> sorted(Comparator<? super P_OUT> comparator) {
        return SortedOps.makeRef(this, comparator);
    }

    public final Stream<P_OUT> limit(long maxSize) {
        if (maxSize >= 0) {
            return SliceOps.makeRef(this, 0, maxSize);
        }
        throw new IllegalArgumentException(Long.toString(maxSize));
    }

    public final Stream<P_OUT> skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(Long.toString(n));
        } else if (n == 0) {
            return this;
        } else {
            return SliceOps.makeRef(this, n, -1);
        }
    }

    /* renamed from: -java_util_stream_ReferencePipeline-mthref-0  reason: not valid java name */
    static /* synthetic */ Object[] m579java_util_stream_ReferencePipelinemthref0(int i) {
        return new Object[i];
    }

    /* renamed from: -java_util_stream_ReferencePipeline_lambda$6  reason: not valid java name */
    static /* synthetic */ long m581java_util_stream_ReferencePipeline_lambda$6(Object e) {
        return 1;
    }

    public static class Head<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.Head.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
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
        public Head(java.util.Spliterator<?> r1, int r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.Head.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.Head.<init>(java.util.Spliterator, int, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.Head.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
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
        public Head(java.util.function.Supplier<? extends java.util.Spliterator<?>> r1, int r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReferencePipeline.Head.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.Head.<init>(java.util.function.Supplier, int, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.Head.forEach(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEach(java.util.function.Consumer<? super E_OUT> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.Head.forEach(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.Head.forEach(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.Head.forEachOrdered(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachOrdered(java.util.function.Consumer<? super E_OUT> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.Head.forEachOrdered(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.Head.forEachOrdered(java.util.function.Consumer):void");
        }

        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        public final Sink<E_IN> opWrapSink(int flags, Sink<E_OUT> sink) {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class StatelessOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f83assertionsDisabled = false;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatelessOp.<clinit>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatelessOp.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.StatelessOp.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.StatelessOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void");
        }

        public final boolean opIsStateful() {
            return false;
        }
    }

    public static abstract class StatefulOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f82assertionsDisabled = false;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatefulOp.<clinit>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatefulOp.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.StatefulOp.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReferencePipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReferencePipeline.StatefulOp.<init>(java.util.stream.AbstractPipeline, java.util.stream.StreamShape, int):void");
        }

        public abstract <P_IN> Node<E_OUT> opEvaluateParallel(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<E_OUT[]> intFunction);

        public final boolean opIsStateful() {
            return true;
        }
    }
}
