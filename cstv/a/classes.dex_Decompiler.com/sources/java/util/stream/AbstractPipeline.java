package java.util.stream;

import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Node;

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
public abstract class AbstractPipeline<E_IN, E_OUT, S extends BaseStream<E_OUT, S>> extends PipelineHelper<E_OUT> implements BaseStream<E_OUT, S> {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f59assertionsDisabled = false;
    private static final String MSG_CONSUMED = "source already consumed or closed";
    private static final String MSG_STREAM_LINKED = "stream has already been operated upon or closed";
    private int combinedFlags;
    private int depth;
    private boolean linkedOrConsumed;
    private AbstractPipeline nextStage;
    private boolean parallel;
    private final AbstractPipeline previousStage;
    private boolean sourceAnyStateful;
    private Runnable sourceCloseAction;
    protected final int sourceOrOpFlags;
    private Spliterator<?> sourceSpliterator;
    private final AbstractPipeline sourceStage;
    private Supplier<? extends Spliterator<?>> sourceSupplier;

    /* renamed from: java.util.stream.AbstractPipeline$-java_util_Spliterator_opEvaluateParallelLazy_java_util_stream_PipelineHelper_helper_java_util_Spliterator_spliterator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Spliterator_opEvaluateParallelLazy_java_util_stream_PipelineHelper_helper_java_util_Spliterator_spliterator_LambdaImpl0 implements IntFunction {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_opEvaluateParallelLazy_java_util_stream_PipelineHelper_helper_java_util_Spliterator_spliterator_LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_Spliterator_opEvaluateParallelLazy_java_util_stream_PipelineHelper_helper_java_util_Spliterator_spliterator_LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_opEvaluateParallelLazy_java_util_stream_PipelineHelper_helper_java_util_Spliterator_spliterator_LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.java_util_Spliterator_opEvaluateParallelLazy_java_util_stream_PipelineHelper_helper_java_util_Spliterator_spliterator_LambdaImpl0.<init>():void");
        }

        public Object apply(int arg0) {
            return AbstractPipeline.m399java_util_stream_AbstractPipeline_lambda$3(arg0);
        }
    }

    /* renamed from: java.util.stream.AbstractPipeline$-java_util_Spliterator_spliterator__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Spliterator_spliterator__LambdaImpl0 implements Supplier {
        private /* synthetic */ AbstractPipeline val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_spliterator__LambdaImpl0.<init>(java.util.stream.AbstractPipeline):void, dex: classes.dex
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
        public /* synthetic */ java_util_Spliterator_spliterator__LambdaImpl0(java.util.stream.AbstractPipeline r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_spliterator__LambdaImpl0.<init>(java.util.stream.AbstractPipeline):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.java_util_Spliterator_spliterator__LambdaImpl0.<init>(java.util.stream.AbstractPipeline):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_spliterator__LambdaImpl0.get():java.lang.Object, dex: classes.dex
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
        public java.lang.Object get() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_spliterator__LambdaImpl0.get():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.java_util_Spliterator_spliterator__LambdaImpl0.get():java.lang.Object");
        }
    }

    /* renamed from: java.util.stream.AbstractPipeline$-java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0 implements Supplier {
        private /* synthetic */ Spliterator val$sourceSpliterator;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0.<init>(java.util.Spliterator):void, dex: classes.dex
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
        public /* synthetic */ java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0(java.util.Spliterator r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0.<init>(java.util.Spliterator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0.<init>(java.util.Spliterator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0.get():java.lang.Object, dex: classes.dex
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
        public java.lang.Object get() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.-java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0.get():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.java_util_Spliterator_wrapSpliterator_java_util_Spliterator_sourceSpliterator_LambdaImpl0.get():java.lang.Object");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.<clinit>():void, dex: classes.dex
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.<clinit>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
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
    AbstractPipeline(java.util.Spliterator<?> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.<init>(java.util.Spliterator, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.<init>(java.util.Spliterator, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
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
    AbstractPipeline(java.util.function.Supplier<? extends java.util.Spliterator<?>> r1, int r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.AbstractPipeline.<init>(java.util.function.Supplier, int, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.<init>(java.util.function.Supplier, int, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.AbstractPipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex in method: java.util.stream.AbstractPipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.AbstractPipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
        	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    AbstractPipeline(java.util.stream.AbstractPipeline<?, E_IN, ?> r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.util.stream.AbstractPipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex in method: java.util.stream.AbstractPipeline.<init>(java.util.stream.AbstractPipeline, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.<init>(java.util.stream.AbstractPipeline, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.sourceSpliterator(int):java.util.Spliterator<?>, dex: classes.dex
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
    private java.util.Spliterator<?> sourceSpliterator(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.sourceSpliterator(int):java.util.Spliterator<?>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.sourceSpliterator(int):java.util.Spliterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00eb in method: java.util.stream.AbstractPipeline.close():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00eb
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public void close() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00eb in method: java.util.stream.AbstractPipeline.close():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.close():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.copyInto(java.util.stream.Sink, java.util.Spliterator):void, dex: classes.dex
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
    final <P_IN> void copyInto(java.util.stream.Sink<P_IN> r1, java.util.Spliterator<P_IN> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.copyInto(java.util.stream.Sink, java.util.Spliterator):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.copyInto(java.util.stream.Sink, java.util.Spliterator):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.copyIntoWithCancel(java.util.stream.Sink, java.util.Spliterator):void, dex: classes.dex
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
    final <P_IN> void copyIntoWithCancel(java.util.stream.Sink<P_IN> r1, java.util.Spliterator<P_IN> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.copyIntoWithCancel(java.util.stream.Sink, java.util.Spliterator):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.copyIntoWithCancel(java.util.stream.Sink, java.util.Spliterator):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.evaluate(java.util.stream.TerminalOp):R, dex: classes.dex
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
    final <R> R evaluate(java.util.stream.TerminalOp<E_OUT, R> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.evaluate(java.util.stream.TerminalOp):R, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.evaluate(java.util.stream.TerminalOp):java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus registerCount: 7 in method: java.util.stream.AbstractPipeline.evaluate(java.util.Spliterator, boolean, java.util.function.IntFunction):java.util.stream.Node<E_OUT>, dex: classes.dex in method: java.util.stream.AbstractPipeline.evaluate(java.util.Spliterator, boolean, java.util.function.IntFunction):java.util.stream.Node<E_OUT>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: bogus registerCount: 7 in method: java.util.stream.AbstractPipeline.evaluate(java.util.Spliterator, boolean, java.util.function.IntFunction):java.util.stream.Node<E_OUT>, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: com.android.dex.DexException: bogus registerCount: 7
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:962)
        	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public final <P_IN> java.util.stream.Node<E_OUT> evaluate(java.util.Spliterator<P_IN> r1, boolean r2, java.util.function.IntFunction<E_OUT[]> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus registerCount: 7 in method: java.util.stream.AbstractPipeline.evaluate(java.util.Spliterator, boolean, java.util.function.IntFunction):java.util.stream.Node<E_OUT>, dex: classes.dex in method: java.util.stream.AbstractPipeline.evaluate(java.util.Spliterator, boolean, java.util.function.IntFunction):java.util.stream.Node<E_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.evaluate(java.util.Spliterator, boolean, java.util.function.IntFunction):java.util.stream.Node");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.util.stream.AbstractPipeline.evaluateToArrayNode(java.util.function.IntFunction):java.util.stream.Node<E_OUT>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public final java.util.stream.Node<E_OUT> evaluateToArrayNode(java.util.function.IntFunction<E_OUT[]> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.util.stream.AbstractPipeline.evaluateToArrayNode(java.util.function.IntFunction):java.util.stream.Node<E_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.evaluateToArrayNode(java.util.function.IntFunction):java.util.stream.Node");
    }

    public abstract <P_IN> Node<E_OUT> evaluateToNode(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, boolean z, IntFunction<E_OUT[]> intFunction);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.exactOutputSizeIfKnown(java.util.Spliterator):long, dex: classes.dex
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
    final <P_IN> long exactOutputSizeIfKnown(java.util.Spliterator<P_IN> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.exactOutputSizeIfKnown(java.util.Spliterator):long, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.exactOutputSizeIfKnown(java.util.Spliterator):long");
    }

    public abstract void forEachWithCancel(Spliterator<E_OUT> spliterator, Sink<E_OUT> sink);

    public abstract StreamShape getOutputShape();

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.getSourceShape():java.util.stream.StreamShape, dex: classes.dex
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
    final java.util.stream.StreamShape getSourceShape() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.getSourceShape():java.util.stream.StreamShape, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.getSourceShape():java.util.stream.StreamShape");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.getStreamAndOpFlags():int, dex: classes.dex
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
    public final int getStreamAndOpFlags() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.getStreamAndOpFlags():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.getStreamAndOpFlags():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.getStreamFlags():int, dex: classes.dex
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
    public final int getStreamFlags() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.getStreamFlags():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.getStreamFlags():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.isOrdered():boolean, dex: classes.dex
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
    final boolean isOrdered() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.isOrdered():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.isOrdered():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.AbstractPipeline.isParallel():boolean, dex: classes.dex in method: java.util.stream.AbstractPipeline.isParallel():boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.AbstractPipeline.isParallel():boolean, dex: classes.dex
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
    public final boolean isParallel() {
        /*
        // Can't load method instructions: Load method exception: null in method: java.util.stream.AbstractPipeline.isParallel():boolean, dex: classes.dex in method: java.util.stream.AbstractPipeline.isParallel():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.isParallel():boolean");
    }

    public abstract Spliterator<E_OUT> lazySpliterator(Supplier<? extends Spliterator<E_OUT>> supplier);

    public abstract Node.Builder<E_OUT> makeNodeBuilder(long j, IntFunction<E_OUT[]> intFunction);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.onClose(java.lang.Runnable):S, dex: classes.dex
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
    public S onClose(java.lang.Runnable r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.onClose(java.lang.Runnable):S, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.onClose(java.lang.Runnable):java.util.stream.BaseStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.opEvaluateParallelLazy(java.util.stream.PipelineHelper, java.util.Spliterator):java.util.Spliterator<E_OUT>, dex: classes.dex
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
    public <P_IN> java.util.Spliterator<E_OUT> opEvaluateParallelLazy(java.util.stream.PipelineHelper<E_OUT> r1, java.util.Spliterator<P_IN> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.opEvaluateParallelLazy(java.util.stream.PipelineHelper, java.util.Spliterator):java.util.Spliterator<E_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.opEvaluateParallelLazy(java.util.stream.PipelineHelper, java.util.Spliterator):java.util.Spliterator");
    }

    public abstract boolean opIsStateful();

    public abstract Sink<E_IN> opWrapSink(int i, Sink<E_OUT> sink);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.parallel():S, dex: classes.dex
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
    public final S parallel() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.parallel():S, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.parallel():java.util.stream.BaseStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.sequential():S, dex: classes.dex
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
    public final S sequential() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.sequential():S, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.sequential():java.util.stream.BaseStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.sourceStageSpliterator():java.util.Spliterator<E_OUT>, dex: classes.dex
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
    final java.util.Spliterator<E_OUT> sourceStageSpliterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.AbstractPipeline.sourceStageSpliterator():java.util.Spliterator<E_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.sourceStageSpliterator():java.util.Spliterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.util.stream.AbstractPipeline.spliterator():java.util.Spliterator<E_OUT>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.util.Spliterator<E_OUT> spliterator() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.util.stream.AbstractPipeline.spliterator():java.util.Spliterator<E_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.spliterator():java.util.Spliterator");
    }

    public abstract <P_IN> Spliterator<E_OUT> wrap(PipelineHelper<E_OUT> pipelineHelper, Supplier<Spliterator<P_IN>> supplier, boolean z);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.wrapAndCopyInto(java.util.stream.Sink, java.util.Spliterator):S, dex: classes.dex
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
    final <P_IN, S extends java.util.stream.Sink<E_OUT>> S wrapAndCopyInto(S r1, java.util.Spliterator<P_IN> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.AbstractPipeline.wrapAndCopyInto(java.util.stream.Sink, java.util.Spliterator):S, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.wrapAndCopyInto(java.util.stream.Sink, java.util.Spliterator):java.util.stream.Sink");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.wrapSink(java.util.stream.Sink):java.util.stream.Sink<P_IN>, dex: classes.dex
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
    public final <P_IN> java.util.stream.Sink<P_IN> wrapSink(java.util.stream.Sink<E_OUT> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.wrapSink(java.util.stream.Sink):java.util.stream.Sink<P_IN>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.wrapSink(java.util.stream.Sink):java.util.stream.Sink");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.wrapSpliterator(java.util.Spliterator):java.util.Spliterator<E_OUT>, dex: classes.dex
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
    final <P_IN> java.util.Spliterator<E_OUT> wrapSpliterator(java.util.Spliterator<P_IN> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.AbstractPipeline.wrapSpliterator(java.util.Spliterator):java.util.Spliterator<E_OUT>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractPipeline.wrapSpliterator(java.util.Spliterator):java.util.Spliterator");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: -java_util_stream_AbstractPipeline_lambda$1  reason: not valid java name */
    public /* synthetic */ Spliterator m400java_util_stream_AbstractPipeline_lambda$1() {
        return sourceSpliterator(0);
    }

    /* renamed from: -java_util_stream_AbstractPipeline_lambda$2  reason: not valid java name */
    static /* synthetic */ Spliterator m398java_util_stream_AbstractPipeline_lambda$2(Spliterator sourceSpliterator2) {
        return sourceSpliterator2;
    }

    public <P_IN> Node<E_OUT> opEvaluateParallel(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<E_OUT[]> intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    /* renamed from: -java_util_stream_AbstractPipeline_lambda$3  reason: not valid java name */
    static /* synthetic */ Object[] m399java_util_stream_AbstractPipeline_lambda$3(int i) {
        return new Object[i];
    }
}
