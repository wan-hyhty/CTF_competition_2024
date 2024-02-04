package java.util.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.StreamSpliterators;
import java.util.stream.Streams;

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
public interface IntStream extends BaseStream<Integer, IntStream> {
    boolean allMatch(IntPredicate intPredicate);

    boolean anyMatch(IntPredicate intPredicate);

    DoubleStream asDoubleStream();

    LongStream asLongStream();

    OptionalDouble average();

    Stream<Integer> boxed();

    <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> objIntConsumer, BiConsumer<R, R> biConsumer);

    long count();

    IntStream distinct();

    IntStream filter(IntPredicate intPredicate);

    OptionalInt findAny();

    OptionalInt findFirst();

    IntStream flatMap(IntFunction<? extends IntStream> intFunction);

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    PrimitiveIterator.OfInt iterator();

    IntStream limit(long j);

    IntStream map(IntUnaryOperator intUnaryOperator);

    DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction);

    LongStream mapToLong(IntToLongFunction intToLongFunction);

    <U> Stream<U> mapToObj(IntFunction<? extends U> intFunction);

    OptionalInt max();

    OptionalInt min();

    boolean noneMatch(IntPredicate intPredicate);

    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    int reduce(int i, IntBinaryOperator intBinaryOperator);

    OptionalInt reduce(IntBinaryOperator intBinaryOperator);

    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    Spliterator.OfInt spliterator();

    int sum();

    IntSummaryStatistics summaryStatistics();

    int[] toArray();

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
        return new Streams.IntStreamBuilderImpl();
    }

    static IntStream empty() {
        return StreamSupport.intStream(Spliterators.emptyIntSpliterator(), false);
    }

    static IntStream of(int t) {
        return StreamSupport.intStream(new Streams.IntStreamBuilderImpl(t), false);
    }

    static IntStream of(int... values) {
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
    static java.util.stream.IntStream iterate(int r3, java.util.function.IntUnaryOperator r4) {
        /*
            java.util.Objects.requireNonNull(r4)
            java.util.stream.IntStream$1 r0 = new java.util.stream.IntStream$1
            r0.<init>(r3, r4)
            r1 = 1296(0x510, float:1.816E-42)
            java.util.Spliterator$OfInt r1 = java.util.Spliterators.spliteratorUnknownSize((java.util.PrimitiveIterator.OfInt) r0, (int) r1)
            r2 = 0
            java.util.stream.IntStream r1 = java.util.stream.StreamSupport.intStream(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.IntStream.iterate(int, java.util.function.IntUnaryOperator):java.util.stream.IntStream");
    }

    static IntStream generate(IntSupplier s) {
        Objects.requireNonNull(s);
        return StreamSupport.intStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfInt(Long.MAX_VALUE, s), false);
    }

    static IntStream range(int startInclusive, int endExclusive) {
        if (startInclusive >= endExclusive) {
            return empty();
        }
        return StreamSupport.intStream(new Streams.RangeIntSpliterator(startInclusive, endExclusive, false), false);
    }

    static IntStream rangeClosed(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            return empty();
        }
        return StreamSupport.intStream(new Streams.RangeIntSpliterator(startInclusive, endInclusive, true), false);
    }

    static IntStream concat(IntStream a, IntStream b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        return (IntStream) StreamSupport.intStream(new Streams.ConcatSpliterator.OfInt(a.spliterator(), b.spliterator()), !a.isParallel() ? b.isParallel() : true).onClose(Streams.composedClose(a, b));
    }

    public interface Builder extends IntConsumer {
        void accept(int i);

        IntStream build();

        Builder add(int t) {
            accept(t);
            return this;
        }
    }
}
