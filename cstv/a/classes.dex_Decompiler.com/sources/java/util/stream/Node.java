package java.util.stream;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
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
    */
public interface Node<T> {

    /* renamed from: java.util.stream.Node$-java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0 implements Consumer {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.-java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.-java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.-java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
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
        public void accept(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.-java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0.accept(java.lang.Object):void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.-java_util_stream_Node_lambda$4(java.lang.Object):void, dex: classes.dex
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
    /* renamed from: -java_util_stream_Node_lambda$4 */
    static /* synthetic */ void m563java_util_stream_Node_lambda$4(java.lang.Object r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.-java_util_stream_Node_lambda$4(java.lang.Object):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.m563java_util_stream_Node_lambda$4(java.lang.Object):void");
    }

    T[] asArray(IntFunction<T[]> intFunction);

    void copyInto(T[] tArr, int i);

    long count();

    void forEach(Consumer<? super T> consumer);

    Spliterator<T> spliterator();

    int getChildCount() {
        return 0;
    }

    Node<T> getChild(int i) {
        throw new IndexOutOfBoundsException();
    }

    Node<T> truncate(long from, long to, IntFunction<T[]> generator) {
        if (from == 0 && to == count()) {
            return this;
        }
        Spliterator<T> spliterator = spliterator();
        long size = to - from;
        Builder<T> nodeBuilder = Nodes.builder(size, generator);
        nodeBuilder.begin(size);
        for (int i = 0; ((long) i) < from && spliterator.tryAdvance(new java_util_stream_Node_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0()); i++) {
        }
        for (int i2 = 0; ((long) i2) < size && spliterator.tryAdvance(nodeBuilder); i2++) {
        }
        nodeBuilder.end();
        return nodeBuilder.build();
    }

    StreamShape getShape() {
        return StreamShape.REFERENCE;
    }

    public interface Builder<T> extends Sink<T> {
        Node<T> build();

        public interface OfInt extends Builder<Integer>, Sink.OfInt {
            OfInt build();

            /* bridge */ /* synthetic */ Node build() {
                return build();
            }
        }

        public interface OfLong extends Builder<Long>, Sink.OfLong {
            OfLong build();

            /* bridge */ /* synthetic */ Node build() {
                return build();
            }
        }

        public interface OfDouble extends Builder<Double>, Sink.OfDouble {
            OfDouble build();

            /* bridge */ /* synthetic */ Node build() {
                return build();
            }
        }
    }

    public interface OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends Node<T> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfPrimitive.asArray(java.util.function.IntFunction):T[], dex: classes.dex
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
        T[] asArray(java.util.function.IntFunction<T[]> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfPrimitive.asArray(java.util.function.IntFunction):T[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfPrimitive.asArray(java.util.function.IntFunction):java.lang.Object[]");
        }

        T_ARR asPrimitiveArray();

        void copyInto(T_ARR t_arr, int i);

        void forEach(T_CONS t_cons);

        T_ARR newArray(int i);

        T_SPLITR spliterator();

        T_NODE truncate(long j, long j2, IntFunction<T[]> intFunction);

        /* bridge */ /* synthetic */ Spliterator spliterator() {
            return spliterator();
        }

        /* bridge */ /* synthetic */ Node getChild(int i) {
            return getChild(i);
        }

        T_NODE getChild(int i) {
            throw new IndexOutOfBoundsException();
        }

        /* bridge */ /* synthetic */ Node truncate(long from, long to, IntFunction generator) {
            return truncate(from, to, (IntFunction<T[]>) generator);
        }
    }

    public interface OfInt extends OfPrimitive<Integer, IntConsumer, int[], Spliterator.OfInt, OfInt> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfInt.-java_util_stream_Node$OfInt_lambda$1(int):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_Node$OfInt_lambda$1 */
        static /* synthetic */ void m565java_util_stream_Node$OfInt_lambda$1(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfInt.-java_util_stream_Node$OfInt_lambda$1(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfInt.m565java_util_stream_Node$OfInt_lambda$1(int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfInt.copyInto(java.lang.Integer[], int):void, dex: classes.dex
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
        void copyInto(java.lang.Integer[] r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfInt.copyInto(java.lang.Integer[], int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfInt.copyInto(java.lang.Integer[], int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfInt.copyInto(java.lang.Object[], int):void, dex: classes.dex
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
        /* bridge */ /* synthetic */ void copyInto(java.lang.Object[] r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfInt.copyInto(java.lang.Object[], int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfInt.copyInto(java.lang.Object[], int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfInt.forEach(java.util.function.Consumer):void, dex: classes.dex
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
        void forEach(java.util.function.Consumer<? super java.lang.Integer> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfInt.forEach(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfInt.forEach(java.util.function.Consumer):void");
        }

        /* bridge */ /* synthetic */ OfPrimitive truncate(long from, long to, IntFunction generator) {
            return truncate(from, to, (IntFunction<Integer[]>) generator);
        }

        /* bridge */ /* synthetic */ Node truncate(long from, long to, IntFunction generator) {
            return truncate(from, to, (IntFunction<Integer[]>) generator);
        }

        OfInt truncate(long from, long to, IntFunction<Integer[]> intFunction) {
            if (from == 0 && to == count()) {
                return this;
            }
            long size = to - from;
            Spliterator.OfInt spliterator = (Spliterator.OfInt) spliterator();
            Builder.OfInt nodeBuilder = Nodes.intBuilder(size);
            nodeBuilder.begin(size);
            for (int i = 0; ((long) i) < from && spliterator.tryAdvance((IntConsumer) new Node$OfInt$java_util_stream_Node$OfInt_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0()); i++) {
            }
            for (int i2 = 0; ((long) i2) < size && spliterator.tryAdvance((IntConsumer) nodeBuilder); i2++) {
            }
            nodeBuilder.end();
            return nodeBuilder.build();
        }

        /* bridge */ /* synthetic */ Object newArray(int count) {
            return newArray(count);
        }

        int[] newArray(int count) {
            return new int[count];
        }

        StreamShape getShape() {
            return StreamShape.INT_VALUE;
        }
    }

    public interface OfLong extends OfPrimitive<Long, LongConsumer, long[], Spliterator.OfLong, OfLong> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfLong.-java_util_stream_Node$OfLong_lambda$2(long):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_Node$OfLong_lambda$2 */
        static /* synthetic */ void m566java_util_stream_Node$OfLong_lambda$2(long r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfLong.-java_util_stream_Node$OfLong_lambda$2(long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfLong.m566java_util_stream_Node$OfLong_lambda$2(long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfLong.copyInto(java.lang.Long[], int):void, dex: classes.dex
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
        void copyInto(java.lang.Long[] r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfLong.copyInto(java.lang.Long[], int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfLong.copyInto(java.lang.Long[], int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfLong.copyInto(java.lang.Object[], int):void, dex: classes.dex
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
        /* bridge */ /* synthetic */ void copyInto(java.lang.Object[] r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfLong.copyInto(java.lang.Object[], int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfLong.copyInto(java.lang.Object[], int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfLong.forEach(java.util.function.Consumer):void, dex: classes.dex
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
        void forEach(java.util.function.Consumer<? super java.lang.Long> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfLong.forEach(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfLong.forEach(java.util.function.Consumer):void");
        }

        /* bridge */ /* synthetic */ OfPrimitive truncate(long from, long to, IntFunction generator) {
            return truncate(from, to, (IntFunction<Long[]>) generator);
        }

        /* bridge */ /* synthetic */ Node truncate(long from, long to, IntFunction generator) {
            return truncate(from, to, (IntFunction<Long[]>) generator);
        }

        OfLong truncate(long from, long to, IntFunction<Long[]> intFunction) {
            if (from == 0 && to == count()) {
                return this;
            }
            long size = to - from;
            Spliterator.OfLong spliterator = (Spliterator.OfLong) spliterator();
            Builder.OfLong nodeBuilder = Nodes.longBuilder(size);
            nodeBuilder.begin(size);
            for (int i = 0; ((long) i) < from && spliterator.tryAdvance((LongConsumer) new Node$OfLong$java_util_stream_Node$OfLong_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0()); i++) {
            }
            for (int i2 = 0; ((long) i2) < size && spliterator.tryAdvance((LongConsumer) nodeBuilder); i2++) {
            }
            nodeBuilder.end();
            return nodeBuilder.build();
        }

        /* bridge */ /* synthetic */ Object newArray(int count) {
            return newArray(count);
        }

        long[] newArray(int count) {
            return new long[count];
        }

        StreamShape getShape() {
            return StreamShape.LONG_VALUE;
        }
    }

    public interface OfDouble extends OfPrimitive<Double, DoubleConsumer, double[], Spliterator.OfDouble, OfDouble> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfDouble.-java_util_stream_Node$OfDouble_lambda$3(double):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_Node$OfDouble_lambda$3 */
        static /* synthetic */ void m564java_util_stream_Node$OfDouble_lambda$3(double r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfDouble.-java_util_stream_Node$OfDouble_lambda$3(double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfDouble.m564java_util_stream_Node$OfDouble_lambda$3(double):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfDouble.copyInto(java.lang.Double[], int):void, dex: classes.dex
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
        void copyInto(java.lang.Double[] r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.Node.OfDouble.copyInto(java.lang.Double[], int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfDouble.copyInto(java.lang.Double[], int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfDouble.copyInto(java.lang.Object[], int):void, dex: classes.dex
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
        /* bridge */ /* synthetic */ void copyInto(java.lang.Object[] r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfDouble.copyInto(java.lang.Object[], int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfDouble.copyInto(java.lang.Object[], int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfDouble.forEach(java.util.function.Consumer):void, dex: classes.dex
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
        void forEach(java.util.function.Consumer<? super java.lang.Double> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.Node.OfDouble.forEach(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Node.OfDouble.forEach(java.util.function.Consumer):void");
        }

        /* bridge */ /* synthetic */ OfPrimitive truncate(long from, long to, IntFunction generator) {
            return truncate(from, to, (IntFunction<Double[]>) generator);
        }

        /* bridge */ /* synthetic */ Node truncate(long from, long to, IntFunction generator) {
            return truncate(from, to, (IntFunction<Double[]>) generator);
        }

        OfDouble truncate(long from, long to, IntFunction<Double[]> intFunction) {
            if (from == 0 && to == count()) {
                return this;
            }
            long size = to - from;
            Spliterator.OfDouble spliterator = (Spliterator.OfDouble) spliterator();
            Builder.OfDouble nodeBuilder = Nodes.doubleBuilder(size);
            nodeBuilder.begin(size);
            for (int i = 0; ((long) i) < from && spliterator.tryAdvance((DoubleConsumer) new Node$OfDouble$java_util_stream_Node$OfDouble_truncate_long_from_long_to_java_util_function_IntFunction_generator_LambdaImpl0()); i++) {
            }
            for (int i2 = 0; ((long) i2) < size && spliterator.tryAdvance((DoubleConsumer) nodeBuilder); i2++) {
            }
            nodeBuilder.end();
            return nodeBuilder.build();
        }

        /* bridge */ /* synthetic */ Object newArray(int count) {
            return newArray(count);
        }

        double[] newArray(int count) {
            return new double[count];
        }

        StreamShape getShape() {
            return StreamShape.DOUBLE_VALUE;
        }
    }
}
