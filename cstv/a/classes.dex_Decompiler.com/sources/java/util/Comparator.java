package java.util;

import java.io.Serializable;
import java.util.Comparators;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@FunctionalInterface
public interface Comparator<T> {

    /* renamed from: java.util.Comparator$-java_util_Comparator_comparingDouble_java_util_function_ToDoubleFunction_keyExtractor_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Comparator_comparingDouble_java_util_function_ToDoubleFunction_keyExtractor_LambdaImpl0 implements Comparator, Serializable {
        private /* synthetic */ ToDoubleFunction val$keyExtractor;

        public /* synthetic */ java_util_Comparator_comparingDouble_java_util_function_ToDoubleFunction_keyExtractor_LambdaImpl0(ToDoubleFunction toDoubleFunction) {
            this.val$keyExtractor = toDoubleFunction;
        }

        public int compare(Object arg0, Object arg1) {
            return Double.compare(this.val$keyExtractor.applyAsDouble(arg0), this.val$keyExtractor.applyAsDouble(arg1));
        }
    }

    /* renamed from: java.util.Comparator$-java_util_Comparator_comparingInt_java_util_function_ToIntFunction_keyExtractor_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Comparator_comparingInt_java_util_function_ToIntFunction_keyExtractor_LambdaImpl0 implements Comparator, Serializable {
        private /* synthetic */ ToIntFunction val$keyExtractor;

        public /* synthetic */ java_util_Comparator_comparingInt_java_util_function_ToIntFunction_keyExtractor_LambdaImpl0(ToIntFunction toIntFunction) {
            this.val$keyExtractor = toIntFunction;
        }

        public int compare(Object arg0, Object arg1) {
            return Integer.compare(this.val$keyExtractor.applyAsInt(arg0), this.val$keyExtractor.applyAsInt(arg1));
        }
    }

    /* renamed from: java.util.Comparator$-java_util_Comparator_comparingLong_java_util_function_ToLongFunction_keyExtractor_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Comparator_comparingLong_java_util_function_ToLongFunction_keyExtractor_LambdaImpl0 implements Comparator, Serializable {
        private /* synthetic */ ToLongFunction val$keyExtractor;

        public /* synthetic */ java_util_Comparator_comparingLong_java_util_function_ToLongFunction_keyExtractor_LambdaImpl0(ToLongFunction toLongFunction) {
            this.val$keyExtractor = toLongFunction;
        }

        public int compare(Object arg0, Object arg1) {
            return Long.compare(this.val$keyExtractor.applyAsLong(arg0), this.val$keyExtractor.applyAsLong(arg1));
        }
    }

    /* renamed from: java.util.Comparator$-java_util_Comparator_comparing_java_util_function_Function_keyExtractor_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Comparator_comparing_java_util_function_Function_keyExtractor_LambdaImpl0 implements Comparator, Serializable {
        private /* synthetic */ Function val$keyExtractor;

        public /* synthetic */ java_util_Comparator_comparing_java_util_function_Function_keyExtractor_LambdaImpl0(Function function) {
            this.val$keyExtractor = function;
        }

        public int compare(Object arg0, Object arg1) {
            return ((Comparable) this.val$keyExtractor.apply(arg0)).compareTo(this.val$keyExtractor.apply(arg1));
        }
    }

    /* renamed from: java.util.Comparator$-java_util_Comparator_comparing_java_util_function_Function_keyExtractor_java_util_Comparator_keyComparator_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Comparator_comparing_java_util_function_Function_keyExtractor_java_util_Comparator_keyComparator_LambdaImpl0 implements Comparator, Serializable {
        private /* synthetic */ Function val$keyExtractor;

        public /* synthetic */ java_util_Comparator_comparing_java_util_function_Function_keyExtractor_java_util_Comparator_keyComparator_LambdaImpl0(Function function) {
            this.val$keyExtractor = function;
        }

        public int compare(Object arg0, Object arg1) {
            return Comparator.this.compare(this.val$keyExtractor.apply(arg0), this.val$keyExtractor.apply(arg1));
        }
    }

    /* renamed from: java.util.Comparator$-java_util_Comparator_thenComparing_java_util_Comparator_other_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_Comparator_thenComparing_java_util_Comparator_other_LambdaImpl0 implements Comparator, Serializable {
        private /* synthetic */ Comparator val$other;

        public /* synthetic */ java_util_Comparator_thenComparing_java_util_Comparator_other_LambdaImpl0(Comparator comparator) {
            this.val$other = comparator;
        }

        public int compare(Object arg0, Object arg1) {
            return Comparator.this.m212java_util_Comparator_lambda$1(this.val$other, arg0, arg1);
        }
    }

    int compare(T t, T t2);

    boolean equals(Object obj);

    Comparator<T> reversed() {
        return Collections.reverseOrder(this);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<T>, java.io.Serializable] */
    Comparator<T> thenComparing(Comparator<? super T> other) {
        Objects.requireNonNull(other);
        return new java_util_Comparator_thenComparing_java_util_Comparator_other_LambdaImpl0(other);
    }

    /* renamed from: -java_util_Comparator_lambda$1  reason: not valid java name */
    /* synthetic */ int m212java_util_Comparator_lambda$1(Comparator other, Object c1, Object c2) {
        int res = compare(c1, c2);
        return res != 0 ? res : other.compare(c1, c2);
    }

    <U> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }

    <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor) {
        return thenComparing(comparing(keyExtractor));
    }

    Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return thenComparing(comparingInt(keyExtractor));
    }

    Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return thenComparing(comparingLong(keyExtractor));
    }

    Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return thenComparing(comparingDouble(keyExtractor));
    }

    static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return Collections.reverseOrder();
    }

    static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return Comparators.NaturalOrderComparator.INSTANCE;
    }

    static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        return new Comparators.NullComparator(true, comparator);
    }

    static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        return new Comparators.NullComparator(false, comparator);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<T>, java.io.Serializable] */
    static <T, U> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return new java_util_Comparator_comparing_java_util_function_Function_keyExtractor_java_util_Comparator_keyComparator_LambdaImpl0(keyExtractor);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<T>, java.io.Serializable] */
    static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new java_util_Comparator_comparing_java_util_function_Function_keyExtractor_LambdaImpl0(keyExtractor);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<T>, java.io.Serializable] */
    static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new java_util_Comparator_comparingInt_java_util_function_ToIntFunction_keyExtractor_LambdaImpl0(keyExtractor);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<T>, java.io.Serializable] */
    static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new java_util_Comparator_comparingLong_java_util_function_ToLongFunction_keyExtractor_LambdaImpl0(keyExtractor);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<T>, java.io.Serializable] */
    static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return new java_util_Comparator_comparingDouble_java_util_function_ToDoubleFunction_keyExtractor_LambdaImpl0(keyExtractor);
    }
}
