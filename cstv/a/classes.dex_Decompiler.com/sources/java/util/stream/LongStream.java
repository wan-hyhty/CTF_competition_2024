package java.util.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LongSummaryStatistics;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.StreamSpliterators;
import java.util.stream.Streams;

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
public interface LongStream extends BaseStream<Long, LongStream> {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.LongStream.range(long, long):java.util.stream.LongStream, dex: classes.dex
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
    static java.util.stream.LongStream range(long r1, long r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.LongStream.range(long, long):java.util.stream.LongStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.LongStream.range(long, long):java.util.stream.LongStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.LongStream.rangeClosed(long, long):java.util.stream.LongStream, dex: classes.dex
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
    static java.util.stream.LongStream rangeClosed(long r1, long r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.LongStream.rangeClosed(long, long):java.util.stream.LongStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.LongStream.rangeClosed(long, long):java.util.stream.LongStream");
    }

    boolean allMatch(LongPredicate longPredicate);

    boolean anyMatch(LongPredicate longPredicate);

    DoubleStream asDoubleStream();

    OptionalDouble average();

    Stream<Long> boxed();

    <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> objLongConsumer, BiConsumer<R, R> biConsumer);

    long count();

    LongStream distinct();

    LongStream filter(LongPredicate longPredicate);

    OptionalLong findAny();

    OptionalLong findFirst();

    LongStream flatMap(LongFunction<? extends LongStream> longFunction);

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    PrimitiveIterator.OfLong iterator();

    LongStream limit(long j);

    LongStream map(LongUnaryOperator longUnaryOperator);

    DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction);

    IntStream mapToInt(LongToIntFunction longToIntFunction);

    <U> Stream<U> mapToObj(LongFunction<? extends U> longFunction);

    OptionalLong max();

    OptionalLong min();

    boolean noneMatch(LongPredicate longPredicate);

    LongStream parallel();

    LongStream peek(LongConsumer longConsumer);

    long reduce(long j, LongBinaryOperator longBinaryOperator);

    OptionalLong reduce(LongBinaryOperator longBinaryOperator);

    LongStream sequential();

    LongStream skip(long j);

    LongStream sorted();

    Spliterator.OfLong spliterator();

    long sum();

    LongSummaryStatistics summaryStatistics();

    long[] toArray();

    /* bridge */ /* synthetic */ BaseStream sequential() {
        return sequential();
    }

    /* bridge */ /* synthetic */ BaseStream parallel() {
        return parallel();
    }

    /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    static Builder builder() {
        return new Streams.LongStreamBuilderImpl();
    }

    static LongStream empty() {
        return StreamSupport.longStream(Spliterators.emptyLongSpliterator(), false);
    }

    static LongStream of(long t) {
        return StreamSupport.longStream(new Streams.LongStreamBuilderImpl(t), false);
    }

    static LongStream of(long... values) {
        return Arrays.stream(values);
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    static java.util.stream.LongStream iterate(long r4, java.util.function.LongUnaryOperator r6) {
        /*
            java.util.Objects.requireNonNull(r6)
            java.util.stream.LongStream$1 r0 = new java.util.stream.LongStream$1
            r0.<init>(r4, r6)
            r1 = 1296(0x510, float:1.816E-42)
            java.util.Spliterator$OfLong r1 = java.util.Spliterators.spliteratorUnknownSize((java.util.PrimitiveIterator.OfLong) r0, (int) r1)
            r2 = 0
            java.util.stream.LongStream r1 = java.util.stream.StreamSupport.longStream(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.LongStream.iterate(long, java.util.function.LongUnaryOperator):java.util.stream.LongStream");
    }

    static LongStream generate(LongSupplier s) {
        Objects.requireNonNull(s);
        return StreamSupport.longStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfLong(Long.MAX_VALUE, s), false);
    }

    static LongStream concat(LongStream a, LongStream b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        return (LongStream) StreamSupport.longStream(new Streams.ConcatSpliterator.OfLong(a.spliterator(), b.spliterator()), !a.isParallel() ? b.isParallel() : true).onClose(Streams.composedClose(a, b));
    }

    public interface Builder extends LongConsumer {
        void accept(long j);

        LongStream build();

        Builder add(long t) {
            accept(t);
            return this;
        }
    }
}
