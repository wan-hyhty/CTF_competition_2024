package java.util.stream;

import java.util.Objects;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.Sink;

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
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
final class ForEachOps {

    static final class ForEachTask<S, T> extends CountedCompleter<Void> {
        private final PipelineHelper<T> helper;
        private final Sink<S> sink;
        private Spliterator<S> spliterator;
        private long targetSize;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachTask.<init>(java.util.stream.ForEachOps$ForEachTask, java.util.Spliterator):void, dex: classes.dex
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
        ForEachTask(java.util.stream.ForEachOps.ForEachTask<S, T> r1, java.util.Spliterator<S> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachTask.<init>(java.util.stream.ForEachOps$ForEachTask, java.util.Spliterator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachTask.<init>(java.util.stream.ForEachOps$ForEachTask, java.util.Spliterator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachTask.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
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
        ForEachTask(java.util.stream.PipelineHelper<T> r1, java.util.Spliterator<S> r2, java.util.stream.Sink<S> r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachTask.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachTask.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, java.util.stream.Sink):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachTask.compute():void, dex: classes.dex
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
        public void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachTask.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachTask.compute():void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ForEachOps.<init>():void, dex: classes.dex
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
    private ForEachOps() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ForEachOps.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.<init>():void");
    }

    public static <T> TerminalOp<T, Void> makeRef(Consumer<? super T> action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfRef(action, ordered);
    }

    public static TerminalOp<Integer, Void> makeInt(IntConsumer action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfInt(action, ordered);
    }

    public static TerminalOp<Long, Void> makeLong(LongConsumer action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfLong(action, ordered);
    }

    public static TerminalOp<Double, Void> makeDouble(DoubleConsumer action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfDouble(action, ordered);
    }

    static abstract class ForEachOp<T> implements TerminalOp<T, Void>, TerminalSink<T, Void> {
        private final boolean ordered;

        static final class OfRef<T> extends ForEachOp<T> {
            final Consumer<? super T> consumer;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfRef.<init>(java.util.function.Consumer, boolean):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            OfRef(java.util.function.Consumer<? super T> r1, boolean r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfRef.<init>(java.util.function.Consumer, boolean):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfRef.<init>(java.util.function.Consumer, boolean):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfRef.accept(java.lang.Object):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            public void accept(T r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfRef.accept(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfRef.accept(java.lang.Object):void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00eb in method: java.util.stream.ForEachOps.ForEachOp.<init>(boolean):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00eb
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected ForEachOp(boolean r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00eb in method: java.util.stream.ForEachOps.ForEachOp.<init>(boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.<init>(boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.lang.Object evaluateParallel(java.util.stream.PipelineHelper r1, java.util.Spliterator r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.util.stream.ForEachOps.ForEachOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public <S> java.lang.Void evaluateParallel(java.util.stream.PipelineHelper<T> r1, java.util.Spliterator<S> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.util.stream.ForEachOps.ForEachOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.lang.Object evaluateSequential(java.util.stream.PipelineHelper r1, java.util.Spliterator r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Void, dex: classes.dex
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
        public <S> java.lang.Void evaluateSequential(java.util.stream.PipelineHelper<T> r1, java.util.Spliterator<S> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.get():java.lang.Object, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.lang.Object get() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ForEachOps.ForEachOp.get():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.get():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.util.stream.ForEachOps.ForEachOp.getOpFlags():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public int getOpFlags() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.util.stream.ForEachOps.ForEachOp.getOpFlags():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.getOpFlags():int");
        }

        public Void get() {
            return null;
        }

        static final class OfInt extends ForEachOp<Integer> implements Sink.OfInt {
            final IntConsumer consumer;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfInt.<init>(java.util.function.IntConsumer, boolean):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            OfInt(java.util.function.IntConsumer r1, boolean r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfInt.<init>(java.util.function.IntConsumer, boolean):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfInt.<init>(java.util.function.IntConsumer, boolean):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfInt.accept(int):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            public void accept(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfInt.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfInt.accept(int):void");
            }

            public StreamShape inputShape() {
                return StreamShape.INT_VALUE;
            }
        }

        static final class OfLong extends ForEachOp<Long> implements Sink.OfLong {
            final LongConsumer consumer;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfLong.<init>(java.util.function.LongConsumer, boolean):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            OfLong(java.util.function.LongConsumer r1, boolean r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfLong.<init>(java.util.function.LongConsumer, boolean):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfLong.<init>(java.util.function.LongConsumer, boolean):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfLong.accept(long):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            public void accept(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfLong.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfLong.accept(long):void");
            }

            public StreamShape inputShape() {
                return StreamShape.LONG_VALUE;
            }
        }

        static final class OfDouble extends ForEachOp<Double> implements Sink.OfDouble {
            final DoubleConsumer consumer;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfDouble.<init>(java.util.function.DoubleConsumer, boolean):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            OfDouble(java.util.function.DoubleConsumer r1, boolean r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOp.OfDouble.<init>(java.util.function.DoubleConsumer, boolean):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfDouble.<init>(java.util.function.DoubleConsumer, boolean):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfDouble.accept(double):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            public void accept(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOp.OfDouble.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOp.OfDouble.accept(double):void");
            }

            public StreamShape inputShape() {
                return StreamShape.DOUBLE_VALUE;
            }
        }
    }

    static final class ForEachOrderedTask<S, T> extends CountedCompleter<Void> {
        private final Sink<T> action;
        private final ConcurrentHashMap<ForEachOrderedTask<S, T>, ForEachOrderedTask<S, T>> completionMap;
        private final PipelineHelper<T> helper;
        private final ForEachOrderedTask<S, T> leftPredecessor;
        private Node<T> node;
        private Spliterator<S> spliterator;
        private final long targetSize;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOrderedTask.<init>(java.util.stream.ForEachOps$ForEachOrderedTask, java.util.Spliterator, java.util.stream.ForEachOps$ForEachOrderedTask):void, dex: classes.dex
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
        ForEachOrderedTask(java.util.stream.ForEachOps.ForEachOrderedTask<S, T> r1, java.util.Spliterator<S> r2, java.util.stream.ForEachOps.ForEachOrderedTask<S, T> r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOrderedTask.<init>(java.util.stream.ForEachOps$ForEachOrderedTask, java.util.Spliterator, java.util.stream.ForEachOps$ForEachOrderedTask):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOrderedTask.<init>(java.util.stream.ForEachOps$ForEachOrderedTask, java.util.Spliterator, java.util.stream.ForEachOps$ForEachOrderedTask):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOrderedTask.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
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
        protected ForEachOrderedTask(java.util.stream.PipelineHelper<T> r1, java.util.Spliterator<S> r2, java.util.stream.Sink<T> r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ForEachOps.ForEachOrderedTask.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, java.util.stream.Sink):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOrderedTask.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, java.util.stream.Sink):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOrderedTask.doCompute(java.util.stream.ForEachOps$ForEachOrderedTask):void, dex: classes.dex
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
        private static <S, T> void doCompute(java.util.stream.ForEachOps.ForEachOrderedTask<S, T> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOrderedTask.doCompute(java.util.stream.ForEachOps$ForEachOrderedTask):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOrderedTask.doCompute(java.util.stream.ForEachOps$ForEachOrderedTask):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ForEachOps.ForEachOrderedTask.compute():void, dex: classes.dex
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
        public final void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ForEachOps.ForEachOrderedTask.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOrderedTask.compute():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOrderedTask.onCompletion(java.util.concurrent.CountedCompleter):void, dex: classes.dex
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
        public void onCompletion(java.util.concurrent.CountedCompleter<?> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ForEachOps.ForEachOrderedTask.onCompletion(java.util.concurrent.CountedCompleter):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps.ForEachOrderedTask.onCompletion(java.util.concurrent.CountedCompleter):void");
        }

        /* renamed from: -java_util_stream_ForEachOps$ForEachOrderedTask_lambda$1  reason: not valid java name */
        static /* synthetic */ Object[] m522java_util_stream_ForEachOps$ForEachOrderedTask_lambda$1(int size) {
            return new Object[size];
        }
    }
}
