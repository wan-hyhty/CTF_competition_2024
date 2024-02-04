package java.util;

import java.io.Serializable;

class Comparators {
    private Comparators() {
        throw new AssertionError((Object) "no instances");
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        ;

        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c1.compareTo(c2);
        }

        public Comparator<Comparable<Object>> reversed() {
            return Comparator.reverseOrder();
        }
    }

    static final class NullComparator<T> implements Comparator<T>, Serializable {
        private static final long serialVersionUID = -7569533591570686392L;
        private final boolean nullFirst;
        private final Comparator<T> real;

        NullComparator(boolean nullFirst2, Comparator<? super T> real2) {
            this.nullFirst = nullFirst2;
            this.real = real2;
        }

        public int compare(T a, T b) {
            if (a == null) {
                if (b == null) {
                    return 0;
                }
                return this.nullFirst ? -1 : 1;
            } else if (b == null) {
                if (this.nullFirst) {
                    return 1;
                }
                return -1;
            } else if (this.real == null) {
                return 0;
            } else {
                return this.real.compare(a, b);
            }
        }

        public Comparator<T> thenComparing(Comparator<? super T> other) {
            Objects.requireNonNull(other);
            boolean z = this.nullFirst;
            if (this.real != null) {
                other = this.real.thenComparing(other);
            }
            return new NullComparator(z, other);
        }

        public Comparator<T> reversed() {
            Comparator<T> comparator = null;
            boolean z = !this.nullFirst;
            if (this.real != null) {
                comparator = this.real.reversed();
            }
            return new NullComparator(z, comparator);
        }
    }
}
