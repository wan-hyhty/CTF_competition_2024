package java.util.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
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
public interface DoubleStream extends BaseStream<Double, DoubleStream> {
    boolean allMatch(DoublePredicate doublePredicate);

    boolean anyMatch(DoublePredicate doublePredicate);

    OptionalDouble average();

    Stream<Double> boxed();

    <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> objDoubleConsumer, BiConsumer<R, R> biConsumer);

    long count();

    DoubleStream distinct();

    DoubleStream filter(DoublePredicate doublePredicate);

    OptionalDouble findAny();

    OptionalDouble findFirst();

    DoubleStream flatMap(DoubleFunction<? extends DoubleStream> doubleFunction);

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    PrimitiveIterator.OfDouble iterator();

    DoubleStream limit(long j);

    DoubleStream map(DoubleUnaryOperator doubleUnaryOperator);

    IntStream mapToInt(DoubleToIntFunction doubleToIntFunction);

    LongStream mapToLong(DoubleToLongFunction doubleToLongFunction);

    <U> Stream<U> mapToObj(DoubleFunction<? extends U> doubleFunction);

    OptionalDouble max();

    OptionalDouble min();

    boolean noneMatch(DoublePredicate doublePredicate);

    DoubleStream parallel();

    DoubleStream peek(DoubleConsumer doubleConsumer);

    double reduce(double d, DoubleBinaryOperator doubleBinaryOperator);

    OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator);

    DoubleStream sequential();

    DoubleStream skip(long j);

    DoubleStream sorted();

    Spliterator.OfDouble spliterator();

    double sum();

    DoubleSummaryStatistics summaryStatistics();

    double[] toArray();

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
        return new Streams.DoubleStreamBuilderImpl();
    }

    static DoubleStream empty() {
        return StreamSupport.doubleStream(Spliterators.emptyDoubleSpliterator(), false);
    }

    static DoubleStream of(double t) {
        return StreamSupport.doubleStream(new Streams.DoubleStreamBuilderImpl(t), false);
    }

    static DoubleStream of(double... values) {
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
    static java.util.stream.DoubleStream iterate(double r4, java.util.function.DoubleUnaryOperator r6) {
        /*
            java.util.Objects.requireNonNull(r6)
            java.util.stream.DoubleStream$1 r0 = new java.util.stream.DoubleStream$1
            r0.<init>(r4, r6)
            r1 = 1296(0x510, float:1.816E-42)
            java.util.Spliterator$OfDouble r1 = java.util.Spliterators.spliteratorUnknownSize((java.util.PrimitiveIterator.OfDouble) r0, (int) r1)
            r2 = 0
            java.util.stream.DoubleStream r1 = java.util.stream.StreamSupport.doubleStream(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.DoubleStream.iterate(double, java.util.function.DoubleUnaryOperator):java.util.stream.DoubleStream");
    }

    static DoubleStream generate(DoubleSupplier s) {
        Objects.requireNonNull(s);
        return StreamSupport.doubleStream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble(Long.MAX_VALUE, s), false);
    }

    static DoubleStream concat(DoubleStream a, DoubleStream b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        return (DoubleStream) StreamSupport.doubleStream(new Streams.ConcatSpliterator.OfDouble(a.spliterator(), b.spliterator()), !a.isParallel() ? b.isParallel() : true).onClose(Streams.composedClose(a, b));
    }

    public interface Builder extends DoubleConsumer {
        void accept(double d);

        DoubleStream build();

        Builder add(double t) {
            accept(t);
            return this;
        }
    }
}
