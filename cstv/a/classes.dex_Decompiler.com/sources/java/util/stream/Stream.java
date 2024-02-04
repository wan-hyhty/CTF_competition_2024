package java.util.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.StreamSpliterators;
import java.util.stream.Streams;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ClassModifier.cleanInsnsInAnonymousConstructor(ClassModifier.java:334)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:60)
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
public interface Stream<T> extends BaseStream<T, Stream<T>> {
    boolean allMatch(Predicate<? super T> predicate);

    boolean anyMatch(Predicate<? super T> predicate);

    <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> biConsumer, BiConsumer<R, R> biConsumer2);

    <R, A> R collect(Collector<? super T, A, R> collector);

    long count();

    Stream<T> distinct();

    Stream<T> filter(Predicate<? super T> predicate);

    Optional<T> findAny();

    Optional<T> findFirst();

    <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> function);

    DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> function);

    IntStream flatMapToInt(Function<? super T, ? extends IntStream> function);

    LongStream flatMapToLong(Function<? super T, ? extends LongStream> function);

    void forEach(Consumer<? super T> consumer);

    void forEachOrdered(Consumer<? super T> consumer);

    Stream<T> limit(long j);

    <R> Stream<R> map(Function<? super T, ? extends R> function);

    DoubleStream mapToDouble(ToDoubleFunction<? super T> toDoubleFunction);

    IntStream mapToInt(ToIntFunction<? super T> toIntFunction);

    LongStream mapToLong(ToLongFunction<? super T> toLongFunction);

    Optional<T> max(Comparator<? super T> comparator);

    Optional<T> min(Comparator<? super T> comparator);

    boolean noneMatch(Predicate<? super T> predicate);

    Stream<T> peek(Consumer<? super T> consumer);

    <U> U reduce(U u, BiFunction<U, ? super T, U> biFunction, BinaryOperator<U> binaryOperator);

    T reduce(T t, BinaryOperator<T> binaryOperator);

    Optional<T> reduce(BinaryOperator<T> binaryOperator);

    Stream<T> skip(long j);

    Stream<T> sorted();

    Stream<T> sorted(Comparator<? super T> comparator);

    Object[] toArray();

    <A> A[] toArray(IntFunction<A[]> intFunction);

    static <T> Builder<T> builder() {
        return new Streams.StreamBuilderImpl();
    }

    static <T> Stream<T> empty() {
        return StreamSupport.stream(Spliterators.emptySpliterator(), false);
    }

    static <T> Stream<T> of(T t) {
        return StreamSupport.stream(new Streams.StreamBuilderImpl(t), false);
    }

    @SafeVarargs
    static <T> Stream<T> of(T... values) {
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
    static <T> java.util.stream.Stream<T> iterate(T r3, java.util.function.UnaryOperator<T> r4) {
        /*
            java.util.Objects.requireNonNull(r4)
            java.util.stream.Stream$1 r0 = new java.util.stream.Stream$1
            r0.<init>(r3, r4)
            r1 = 1040(0x410, float:1.457E-42)
            java.util.Spliterator r1 = java.util.Spliterators.spliteratorUnknownSize(r0, (int) r1)
            r2 = 0
            java.util.stream.Stream r1 = java.util.stream.StreamSupport.stream(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.Stream.iterate(java.lang.Object, java.util.function.UnaryOperator):java.util.stream.Stream");
    }

    static <T> Stream<T> generate(Supplier<T> s) {
        Objects.requireNonNull(s);
        return StreamSupport.stream(new StreamSpliterators.InfiniteSupplyingSpliterator.OfRef(Long.MAX_VALUE, s), false);
    }

    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        return (Stream) StreamSupport.stream(new Streams.ConcatSpliterator.OfRef<>(a.spliterator(), b.spliterator()), !a.isParallel() ? b.isParallel() : true).onClose(Streams.composedClose(a, b));
    }

    public interface Builder<T> extends Consumer<T> {
        void accept(T t);

        Stream<T> build();

        Builder<T> add(T t) {
            accept(t);
            return this;
        }
    }
}
