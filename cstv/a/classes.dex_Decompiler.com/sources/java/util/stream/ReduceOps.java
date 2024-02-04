package java.util.stream;

import java.util.Spliterator;

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
final class ReduceOps {

    private interface AccumulatingSink<T, R, K extends AccumulatingSink<T, R, K>> extends TerminalSink<T, R> {
        void combine(K k);
    }

    private static abstract class Box<U> {
        U state;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReduceOps.Box.<init>():void, dex: classes.dex
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
        Box() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReduceOps.Box.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.Box.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.Box.get():U, dex: classes.dex
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
        public U get() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.Box.get():U, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.Box.get():java.lang.Object");
        }
    }

    private static abstract class ReduceOp<T, R, S extends AccumulatingSink<T, R, S>> implements TerminalOp<T, R> {
        private final StreamShape inputShape;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ReduceOps.ReduceOp.<init>(java.util.stream.StreamShape):void, dex: classes.dex
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
        ReduceOp(java.util.stream.StreamShape r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ReduceOps.ReduceOp.<init>(java.util.stream.StreamShape):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceOp.<init>(java.util.stream.StreamShape):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):R, dex: classes.dex
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
        public <P_IN> R evaluateParallel(java.util.stream.PipelineHelper<T> r1, java.util.Spliterator<P_IN> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):R, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):R, dex: classes.dex
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
        public <P_IN> R evaluateSequential(java.util.stream.PipelineHelper<T> r1, java.util.Spliterator<P_IN> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):R, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceOp.evaluateSequential(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.ReduceOp.inputShape():java.util.stream.StreamShape, dex: classes.dex
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
        public java.util.stream.StreamShape inputShape() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.ReduceOp.inputShape():java.util.stream.StreamShape, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceOp.inputShape():java.util.stream.StreamShape");
        }

        public abstract S makeSink();
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReduceOps.<init>():void, dex: classes.dex
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
    private ReduceOps() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ReduceOps.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.<init>():void");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static <T, U> java.util.stream.TerminalOp<T, U> makeRef(U r2, java.util.function.BiFunction<U, ? super T, U> r3, java.util.function.BinaryOperator<U> r4) {
        /*
            java.util.Objects.requireNonNull(r3)
            java.util.Objects.requireNonNull(r4)
            java.util.stream.ReduceOps$1 r0 = new java.util.stream.ReduceOps$1
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.REFERENCE
            r0.<init>(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeRef(java.lang.Object, java.util.function.BiFunction, java.util.function.BinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static <T> java.util.stream.TerminalOp<T, java.util.Optional<T>> makeRef(java.util.function.BinaryOperator<T> r2) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.stream.ReduceOps$2 r0 = new java.util.stream.ReduceOps$2
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.REFERENCE
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeRef(java.util.function.BinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static <T, I> java.util.stream.TerminalOp<T, I> makeRef(java.util.stream.Collector<? super T, I, ?> r6) {
        /*
            java.lang.Object r0 = java.util.Objects.requireNonNull(r6)
            java.util.stream.Collector r0 = (java.util.stream.Collector) r0
            java.util.function.Supplier r3 = r0.supplier()
            java.util.function.BiConsumer r4 = r6.accumulator()
            java.util.function.BinaryOperator r5 = r6.combiner()
            java.util.stream.ReduceOps$3 r0 = new java.util.stream.ReduceOps$3
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.REFERENCE
            r2 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeRef(java.util.stream.Collector):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static <T, R> java.util.stream.TerminalOp<T, R> makeRef(java.util.function.Supplier<R> r2, java.util.function.BiConsumer<R, ? super T> r3, java.util.function.BiConsumer<R, R> r4) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.Objects.requireNonNull(r3)
            java.util.Objects.requireNonNull(r4)
            java.util.stream.ReduceOps$4 r0 = new java.util.stream.ReduceOps$4
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.REFERENCE
            r0.<init>(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeRef(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BiConsumer):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static java.util.stream.TerminalOp<java.lang.Integer, java.lang.Integer> makeInt(int r2, java.util.function.IntBinaryOperator r3) {
        /*
            java.util.Objects.requireNonNull(r3)
            java.util.stream.ReduceOps$5 r0 = new java.util.stream.ReduceOps$5
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.INT_VALUE
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeInt(int, java.util.function.IntBinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static java.util.stream.TerminalOp<java.lang.Integer, java.util.OptionalInt> makeInt(java.util.function.IntBinaryOperator r2) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.stream.ReduceOps$6 r0 = new java.util.stream.ReduceOps$6
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.INT_VALUE
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeInt(java.util.function.IntBinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static <R> java.util.stream.TerminalOp<java.lang.Integer, R> makeInt(java.util.function.Supplier<R> r2, java.util.function.ObjIntConsumer<R> r3, java.util.function.BinaryOperator<R> r4) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.Objects.requireNonNull(r3)
            java.util.Objects.requireNonNull(r4)
            java.util.stream.ReduceOps$7 r0 = new java.util.stream.ReduceOps$7
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.INT_VALUE
            r0.<init>(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeInt(java.util.function.Supplier, java.util.function.ObjIntConsumer, java.util.function.BinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static java.util.stream.TerminalOp<java.lang.Long, java.lang.Long> makeLong(long r2, java.util.function.LongBinaryOperator r4) {
        /*
            java.util.Objects.requireNonNull(r4)
            java.util.stream.ReduceOps$8 r0 = new java.util.stream.ReduceOps$8
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.LONG_VALUE
            r0.<init>(r1, r2, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeLong(long, java.util.function.LongBinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static java.util.stream.TerminalOp<java.lang.Long, java.util.OptionalLong> makeLong(java.util.function.LongBinaryOperator r2) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.stream.ReduceOps$9 r0 = new java.util.stream.ReduceOps$9
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.LONG_VALUE
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeLong(java.util.function.LongBinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static <R> java.util.stream.TerminalOp<java.lang.Long, R> makeLong(java.util.function.Supplier<R> r2, java.util.function.ObjLongConsumer<R> r3, java.util.function.BinaryOperator<R> r4) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.Objects.requireNonNull(r3)
            java.util.Objects.requireNonNull(r4)
            java.util.stream.ReduceOps$10 r0 = new java.util.stream.ReduceOps$10
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.LONG_VALUE
            r0.<init>(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeLong(java.util.function.Supplier, java.util.function.ObjLongConsumer, java.util.function.BinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static java.util.stream.TerminalOp<java.lang.Double, java.lang.Double> makeDouble(double r2, java.util.function.DoubleBinaryOperator r4) {
        /*
            java.util.Objects.requireNonNull(r4)
            java.util.stream.ReduceOps$11 r0 = new java.util.stream.ReduceOps$11
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.DOUBLE_VALUE
            r0.<init>(r1, r2, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeDouble(double, java.util.function.DoubleBinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static java.util.stream.TerminalOp<java.lang.Double, java.util.OptionalDouble> makeDouble(java.util.function.DoubleBinaryOperator r2) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.stream.ReduceOps$12 r0 = new java.util.stream.ReduceOps$12
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.DOUBLE_VALUE
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeDouble(java.util.function.DoubleBinaryOperator):java.util.stream.TerminalOp");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static <R> java.util.stream.TerminalOp<java.lang.Double, R> makeDouble(java.util.function.Supplier<R> r2, java.util.function.ObjDoubleConsumer<R> r3, java.util.function.BinaryOperator<R> r4) {
        /*
            java.util.Objects.requireNonNull(r2)
            java.util.Objects.requireNonNull(r3)
            java.util.Objects.requireNonNull(r4)
            java.util.stream.ReduceOps$13 r0 = new java.util.stream.ReduceOps$13
            java.util.stream.StreamShape r1 = java.util.stream.StreamShape.DOUBLE_VALUE
            r0.<init>(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.makeDouble(java.util.function.Supplier, java.util.function.ObjDoubleConsumer, java.util.function.BinaryOperator):java.util.stream.TerminalOp");
    }

    private static final class ReduceTask<P_IN, P_OUT, R, S extends AccumulatingSink<P_OUT, R, S>> extends AbstractTask<P_IN, P_OUT, S, ReduceTask<P_IN, P_OUT, R, S>> {
        private final ReduceOp<P_OUT, R, S> op;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ReduceOps.ReduceTask.<init>(java.util.stream.ReduceOps$ReduceOp, java.util.stream.PipelineHelper, java.util.Spliterator):void, dex: classes.dex
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
        ReduceTask(java.util.stream.ReduceOps.ReduceOp<P_OUT, R, S> r1, java.util.stream.PipelineHelper<P_OUT> r2, java.util.Spliterator<P_IN> r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.ReduceOps.ReduceTask.<init>(java.util.stream.ReduceOps$ReduceOp, java.util.stream.PipelineHelper, java.util.Spliterator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceTask.<init>(java.util.stream.ReduceOps$ReduceOp, java.util.stream.PipelineHelper, java.util.Spliterator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.ReduceTask.<init>(java.util.stream.ReduceOps$ReduceTask, java.util.Spliterator):void, dex: classes.dex
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
        ReduceTask(java.util.stream.ReduceOps.ReduceTask<P_IN, P_OUT, R, S> r1, java.util.Spliterator<P_IN> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.ReduceTask.<init>(java.util.stream.ReduceOps$ReduceTask, java.util.Spliterator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceTask.<init>(java.util.stream.ReduceOps$ReduceTask, java.util.Spliterator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceTask.doLeaf():java.lang.Object, dex: classes.dex
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
        protected /* bridge */ /* synthetic */ java.lang.Object doLeaf() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceTask.doLeaf():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceTask.doLeaf():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.ReduceTask.doLeaf():S, dex: classes.dex
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
        protected S doLeaf() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.ReduceOps.ReduceTask.doLeaf():S, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceTask.doLeaf():java.util.stream.ReduceOps$AccumulatingSink");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceTask.makeChild(java.util.Spliterator):java.util.stream.AbstractTask, dex: classes.dex
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
        protected /* bridge */ /* synthetic */ java.util.stream.AbstractTask makeChild(java.util.Spliterator r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceTask.makeChild(java.util.Spliterator):java.util.stream.AbstractTask, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceTask.makeChild(java.util.Spliterator):java.util.stream.AbstractTask");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceTask.onCompletion(java.util.concurrent.CountedCompleter):void, dex: classes.dex
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
        public void onCompletion(java.util.concurrent.CountedCompleter<?> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.ReduceOps.ReduceTask.onCompletion(java.util.concurrent.CountedCompleter):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ReduceOps.ReduceTask.onCompletion(java.util.concurrent.CountedCompleter):void");
        }

        /* access modifiers changed from: protected */
        public ReduceTask<P_IN, P_OUT, R, S> makeChild(Spliterator<P_IN> spliterator) {
            return new ReduceTask<>(this, spliterator);
        }
    }
}
