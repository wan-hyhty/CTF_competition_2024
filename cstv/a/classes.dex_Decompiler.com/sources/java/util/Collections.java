package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ClassModifier.cleanInsnsInAnonymousConstructor(ClassModifier.java:334)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:60)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
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
public class Collections {
    private static final int BINARYSEARCH_THRESHOLD = 5000;
    private static final int COPY_THRESHOLD = 10;
    public static final List EMPTY_LIST = null;
    public static final Map EMPTY_MAP = null;
    public static final Set EMPTY_SET = null;
    private static final int FILL_THRESHOLD = 25;
    private static final int INDEXOFSUBLIST_THRESHOLD = 35;
    private static final int REPLACEALL_THRESHOLD = 11;
    private static final int REVERSE_THRESHOLD = 18;
    private static final int ROTATE_THRESHOLD = 100;
    private static final int SHUFFLE_THRESHOLD = 5;
    private static Random r;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Collections.<clinit>():void, dex: classes.dex
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Collections.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.<clinit>():void");
    }

    private Collections() {
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        if (list.getClass() == ArrayList.class) {
            Arrays.sort(((ArrayList) list).elementData, 0, list.size());
            return;
        }
        Object[] a = list.toArray();
        Arrays.sort(a);
        ListIterator<T> i = list.listIterator();
        for (Object obj : a) {
            i.next();
            i.set((Comparable) obj);
        }
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        if (list.getClass() == ArrayList.class) {
            Arrays.sort(((ArrayList) list).elementData, 0, list.size(), c);
            return;
        }
        Object[] a = list.toArray();
        Arrays.sort(a, c);
        ListIterator<T> i = list.listIterator();
        for (Object obj : a) {
            i.next();
            i.set(obj);
        }
    }

    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        if ((list instanceof RandomAccess) || list.size() < BINARYSEARCH_THRESHOLD) {
            return indexedBinarySearch(list, key);
        }
        return iteratorBinarySearch(list, key);
    }

    private static <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = ((Comparable) list.get(mid)).compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private static <T> int iteratorBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;
        ListIterator<? extends Comparable<? super T>> i = list.listIterator();
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = ((Comparable) get(i, mid)).compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private static <T> T get(ListIterator<? extends T> i, int index) {
        T obj;
        int pos;
        int pos2 = i.nextIndex();
        if (pos2 <= index) {
            while (true) {
                obj = i.next();
                pos = pos2 + 1;
                if (pos2 >= index) {
                    break;
                }
                pos2 = pos;
            }
        } else {
            do {
                obj = i.previous();
                pos2--;
            } while (pos2 > index);
        }
        return obj;
    }

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        if (c == null) {
            return binarySearch(list, key);
        }
        if ((list instanceof RandomAccess) || list.size() < BINARYSEARCH_THRESHOLD) {
            return indexedBinarySearch(list, key, c);
        }
        return iteratorBinarySearch(list, key, c);
    }

    private static <T> int indexedBinarySearch(List<? extends T> l, T key, Comparator<? super T> c) {
        int low = 0;
        int high = l.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = c.compare(l.get(mid), key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private static <T> int iteratorBinarySearch(List<? extends T> l, T key, Comparator<? super T> c) {
        int low = 0;
        int high = l.size() - 1;
        ListIterator<? extends T> i = l.listIterator();
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = c.compare(get(i, mid), key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    public static void reverse(List<?> list) {
        int size = list.size();
        if (size < 18 || (list instanceof RandomAccess)) {
            int i = 0;
            int mid = size >> 1;
            int j = size - 1;
            while (i < mid) {
                swap(list, i, j);
                i++;
                j--;
            }
            return;
        }
        ListIterator fwd = list.listIterator();
        ListIterator rev = list.listIterator(size);
        int mid2 = list.size() >> 1;
        for (int i2 = 0; i2 < mid2; i2++) {
            Object tmp = fwd.next();
            fwd.set(rev.previous());
            rev.set(tmp);
        }
    }

    public static void shuffle(List<?> list) {
        Random rnd = r;
        if (rnd == null) {
            rnd = new Random();
            r = rnd;
        }
        shuffle(list, rnd);
    }

    public static void shuffle(List<?> list, Random rnd) {
        int size = list.size();
        if (size < 5 || (list instanceof RandomAccess)) {
            for (int i = size; i > 1; i--) {
                swap(list, i - 1, rnd.nextInt(i));
            }
            return;
        }
        Object[] arr = list.toArray();
        for (int i2 = size; i2 > 1; i2--) {
            swap(arr, i2 - 1, rnd.nextInt(i2));
        }
        ListIterator it = list.listIterator();
        for (Object obj : arr) {
            it.next();
            it.set(obj);
        }
    }

    public static void swap(List<?> list, int i, int j) {
        List<?> list2 = list;
        list.set(i, list.set(j, list.get(i)));
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <T> void fill(List<? super T> list, T obj) {
        int size = list.size();
        if (size < FILL_THRESHOLD || (list instanceof RandomAccess)) {
            for (int i = 0; i < size; i++) {
                list.set(i, obj);
            }
            return;
        }
        ListIterator<? super T> itr = list.listIterator();
        for (int i2 = 0; i2 < size; i2++) {
            itr.next();
            itr.set(obj);
        }
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
        if (srcSize > dest.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        } else if (srcSize < 10 || ((src instanceof RandomAccess) && (dest instanceof RandomAccess))) {
            for (int i = 0; i < srcSize; i++) {
                dest.set(i, src.get(i));
            }
        } else {
            ListIterator<? super T> di = dest.listIterator();
            ListIterator<? extends T> si = src.listIterator();
            for (int i2 = 0; i2 < srcSize; i2++) {
                di.next();
                di.set(si.next());
            }
        }
    }

    public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (((Comparable) next).compareTo(candidate) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp) {
        if (comp == null) {
            return min(coll);
        }
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (comp.compare(next, candidate) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (((Comparable) next).compareTo(candidate) > 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
        if (comp == null) {
            return max(coll);
        }
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (comp.compare(next, candidate) > 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    public static void rotate(List<?> list, int distance) {
        if ((list instanceof RandomAccess) || list.size() < ROTATE_THRESHOLD) {
            rotate1(list, distance);
        } else {
            rotate2(list, distance);
        }
    }

    private static <T> void rotate1(List<T> list, int distance) {
        int size = list.size();
        if (size != 0) {
            int distance2 = distance % size;
            if (distance2 < 0) {
                distance2 += size;
            }
            if (distance2 != 0) {
                int cycleStart = 0;
                int nMoved = 0;
                while (nMoved != size) {
                    T displaced = list.get(cycleStart);
                    int i = cycleStart;
                    do {
                        i += distance2;
                        if (i >= size) {
                            i -= size;
                        }
                        displaced = list.set(i, displaced);
                        nMoved++;
                    } while (i != cycleStart);
                    cycleStart++;
                }
            }
        }
    }

    private static void rotate2(List<?> list, int distance) {
        int size = list.size();
        if (size != 0) {
            int mid = (-distance) % size;
            if (mid < 0) {
                mid += size;
            }
            if (mid != 0) {
                reverse(list.subList(0, mid));
                reverse(list.subList(mid, size));
                reverse(list);
            }
        }
    }

    public static <T> boolean replaceAll(List<T> list, T oldVal, T newVal) {
        boolean result = false;
        int size = list.size();
        if (size >= 11 && !(list instanceof RandomAccess)) {
            ListIterator<T> itr = list.listIterator();
            if (oldVal == null) {
                for (int i = 0; i < size; i++) {
                    if (itr.next() == null) {
                        itr.set(newVal);
                        result = true;
                    }
                }
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    if (oldVal.equals(itr.next())) {
                        itr.set(newVal);
                        result = true;
                    }
                }
            }
        } else if (oldVal == null) {
            for (int i3 = 0; i3 < size; i3++) {
                if (list.get(i3) == null) {
                    list.set(i3, newVal);
                    result = true;
                }
            }
        } else {
            for (int i4 = 0; i4 < size; i4++) {
                if (oldVal.equals(list.get(i4))) {
                    list.set(i4, newVal);
                    result = true;
                }
            }
        }
        return result;
    }

    public static int indexOfSubList(List<?> source, List<?> target) {
        int sourceSize = source.size();
        int targetSize = target.size();
        int maxCandidate = sourceSize - targetSize;
        if (sourceSize < INDEXOFSUBLIST_THRESHOLD || ((source instanceof RandomAccess) && (target instanceof RandomAccess))) {
            int candidate = 0;
            while (candidate <= maxCandidate) {
                int i = 0;
                int j = candidate;
                while (i < targetSize) {
                    if (!eq(target.get(i), source.get(j))) {
                        candidate++;
                    } else {
                        i++;
                        j++;
                    }
                }
                return candidate;
            }
            return -1;
        }
        ListIterator<?> si = source.listIterator();
        int candidate2 = 0;
        while (candidate2 <= maxCandidate) {
            ListIterator<?> ti = target.listIterator();
            int i2 = 0;
            while (i2 < targetSize) {
                if (!eq(ti.next(), si.next())) {
                    for (int j2 = 0; j2 < i2; j2++) {
                        si.previous();
                    }
                    candidate2++;
                } else {
                    i2++;
                }
            }
            return candidate2;
        }
        return -1;
    }

    public static int lastIndexOfSubList(List<?> source, List<?> target) {
        int sourceSize = source.size();
        int targetSize = target.size();
        int maxCandidate = sourceSize - targetSize;
        if (sourceSize < INDEXOFSUBLIST_THRESHOLD || (source instanceof RandomAccess)) {
            int candidate = maxCandidate;
            while (candidate >= 0) {
                int i = 0;
                int j = candidate;
                while (i < targetSize) {
                    if (!eq(target.get(i), source.get(j))) {
                        candidate--;
                    } else {
                        i++;
                        j++;
                    }
                }
                return candidate;
            }
        } else if (maxCandidate < 0) {
            return -1;
        } else {
            ListIterator<?> si = source.listIterator(maxCandidate);
            int candidate2 = maxCandidate;
            while (candidate2 >= 0) {
                ListIterator<?> ti = target.listIterator();
                int i2 = 0;
                while (i2 < targetSize) {
                    if (!eq(ti.next(), si.next())) {
                        if (candidate2 != 0) {
                            for (int j2 = 0; j2 <= i2 + 1; j2++) {
                                si.previous();
                            }
                        }
                        candidate2--;
                    } else {
                        i2++;
                    }
                }
                return candidate2;
            }
        }
        return -1;
    }

    public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c) {
        return new UnmodifiableCollection(c);
    }

    static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1820017752578914078L;
        final Collection<? extends E> c;

        UnmodifiableCollection(Collection<? extends E> c2) {
            if (c2 == null) {
                throw new NullPointerException();
            }
            this.c = c2;
        }

        public int size() {
            return this.c.size();
        }

        public boolean isEmpty() {
            return this.c.isEmpty();
        }

        public boolean contains(Object o) {
            return this.c.contains(o);
        }

        public Object[] toArray() {
            return this.c.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return this.c.toArray(a);
        }

        public String toString() {
            return this.c.toString();
        }

        public Iterator<E> iterator() {
            return new Iterator<E>(this) {
                private final Iterator<? extends E> i;
                final /* synthetic */ UnmodifiableCollection this$1;

                {
                    this.this$1 = this$1;
                    this.i = this.this$1.c.iterator();
                }

                public boolean hasNext() {
                    return this.i.hasNext();
                }

                public E next() {
                    return this.i.next();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }

                public void forEachRemaining(Consumer<? super E> action) {
                    this.i.forEachRemaining(action);
                }
            };
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        public boolean containsAll(Collection<?> coll) {
            return this.c.containsAll(coll);
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public void forEach(Consumer<? super E> action) {
            this.c.forEach(action);
        }

        public boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        public Spliterator<E> spliterator() {
            return this.c.spliterator();
        }

        public Stream<E> stream() {
            return this.c.stream();
        }

        public Stream<E> parallelStream() {
            return this.c.parallelStream();
        }
    }

    public static <T> Set<T> unmodifiableSet(Set<? extends T> s) {
        return new UnmodifiableSet(s);
    }

    static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E>, Serializable {
        private static final long serialVersionUID = -9215047833775013803L;

        UnmodifiableSet(Set<? extends E> s) {
            super(s);
        }

        public boolean equals(Object o) {
            if (o != this) {
                return this.c.equals(o);
            }
            return true;
        }

        public int hashCode() {
            return this.c.hashCode();
        }
    }

    public static <T> SortedSet<T> unmodifiableSortedSet(SortedSet<T> s) {
        return new UnmodifiableSortedSet(s);
    }

    static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E>, Serializable {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;

        UnmodifiableSortedSet(SortedSet<E> s) {
            super(s);
            this.ss = s;
        }

        public Comparator<? super E> comparator() {
            return this.ss.comparator();
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            return new UnmodifiableSortedSet(this.ss.subSet(fromElement, toElement));
        }

        public SortedSet<E> headSet(E toElement) {
            return new UnmodifiableSortedSet(this.ss.headSet(toElement));
        }

        public SortedSet<E> tailSet(E fromElement) {
            return new UnmodifiableSortedSet(this.ss.tailSet(fromElement));
        }

        public E first() {
            return this.ss.first();
        }

        public E last() {
            return this.ss.last();
        }
    }

    public static <T> List<T> unmodifiableList(List<? extends T> list) {
        if (list instanceof RandomAccess) {
            return new UnmodifiableRandomAccessList(list);
        }
        return new UnmodifiableList(list);
    }

    static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        private static final long serialVersionUID = -283967356065247728L;
        final List<? extends E> list;

        UnmodifiableList(List<? extends E> list2) {
            super(list2);
            this.list = list2;
        }

        public boolean equals(Object o) {
            if (o != this) {
                return this.list.equals(o);
            }
            return true;
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public E get(int index) {
            return this.list.get(index);
        }

        public E set(int index, E e) {
            throw new UnsupportedOperationException();
        }

        public void add(int index, E e) {
            throw new UnsupportedOperationException();
        }

        public E remove(int index) {
            throw new UnsupportedOperationException();
        }

        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        public boolean addAll(int index, Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public void replaceAll(UnaryOperator<E> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        public void sort(Comparator<? super E> comparator) {
            throw new UnsupportedOperationException();
        }

        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        public ListIterator<E> listIterator(final int index) {
            return new ListIterator<E>(this) {
                private final ListIterator<? extends E> i;
                final /* synthetic */ UnmodifiableList this$1;

                {
                    this.this$1 = this$1;
                    index = val$index;
                    this.i = this.this$1.list.listIterator(index);
                }

                public boolean hasNext() {
                    return this.i.hasNext();
                }

                public E next() {
                    return this.i.next();
                }

                public boolean hasPrevious() {
                    return this.i.hasPrevious();
                }

                public E previous() {
                    return this.i.previous();
                }

                public int nextIndex() {
                    return this.i.nextIndex();
                }

                public int previousIndex() {
                    return this.i.previousIndex();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }

                public void set(E e) {
                    throw new UnsupportedOperationException();
                }

                public void add(E e) {
                    throw new UnsupportedOperationException();
                }

                public void forEachRemaining(Consumer<? super E> action) {
                    this.i.forEachRemaining(action);
                }
            };
        }

        public List<E> subList(int fromIndex, int toIndex) {
            return new UnmodifiableList(this.list.subList(fromIndex, toIndex));
        }

        private Object readResolve() {
            if (this.list instanceof RandomAccess) {
                return new UnmodifiableRandomAccessList<>(this.list);
            }
            return this;
        }
    }

    static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        private static final long serialVersionUID = -2542308836966382001L;

        UnmodifiableRandomAccessList(List<? extends E> list) {
            super(list);
        }

        public List<E> subList(int fromIndex, int toIndex) {
            return new UnmodifiableRandomAccessList(this.list.subList(fromIndex, toIndex));
        }

        private Object writeReplace() {
            return new UnmodifiableList(this.list);
        }
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m) {
        return new UnmodifiableMap(m);
    }

    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = -1034234728574286014L;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private final Map<? extends K, ? extends V> m;
        private transient Collection<V> values;

        UnmodifiableMap(Map<? extends K, ? extends V> m2) {
            this.keySet = null;
            this.entrySet = null;
            this.values = null;
            if (m2 == null) {
                throw new NullPointerException();
            }
            this.m = m2;
        }

        public int size() {
            return this.m.size();
        }

        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        public boolean containsKey(Object key) {
            return this.m.containsKey(key);
        }

        public boolean containsValue(Object val) {
            return this.m.containsValue(val);
        }

        public V get(Object key) {
            return this.m.get(key);
        }

        public V put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<K> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.m.keySet());
            }
            return this.keySet;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = new UnmodifiableEntrySet(this.m.entrySet());
            }
            return this.entrySet;
        }

        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.unmodifiableCollection(this.m.values());
            }
            return this.values;
        }

        public boolean equals(Object o) {
            if (o != this) {
                return this.m.equals(o);
            }
            return true;
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        public String toString() {
            return this.m.toString();
        }

        public V getOrDefault(Object k, V defaultValue) {
            return this.m.getOrDefault(k, defaultValue);
        }

        public void forEach(BiConsumer<? super K, ? super V> action) {
            this.m.forEach(action);
        }

        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V putIfAbsent(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        public boolean replace(K k, V v, V v2) {
            throw new UnsupportedOperationException();
        }

        public V replace(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            private static final long serialVersionUID = 7854390611657943733L;

            /* renamed from: java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$-java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
            final /* synthetic */ class java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0 implements Consumer {
                private /* synthetic */ Consumer val$action;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.-java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public /* synthetic */ java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0(java.util.function.Consumer r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.-java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.-java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public void accept(java.lang.Object r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.-java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void");
                }
            }

            static final class UnmodifiableEntrySetSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
                final Spliterator<Map.Entry<K, V>> s;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.<init>(java.util.Spliterator):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                UnmodifiableEntrySetSpliterator(java.util.Spliterator<java.util.Map.Entry<K, V>> r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.<init>(java.util.Spliterator):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.<init>(java.util.Spliterator):void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.characteristics():int, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public int characteristics() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.characteristics():int, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.characteristics():int");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.estimateSize():long, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public long estimateSize() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.estimateSize():long, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.estimateSize():long");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public void forEachRemaining(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.forEachRemaining(java.util.function.Consumer):void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.getComparator():java.util.Comparator<? super java.util.Map$Entry<K, V>>, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public java.util.Comparator<? super java.util.Map.Entry<K, V>> getComparator() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.getComparator():java.util.Comparator<? super java.util.Map$Entry<K, V>>, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.getComparator():java.util.Comparator");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.getExactSizeIfKnown():long, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public long getExactSizeIfKnown() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.getExactSizeIfKnown():long, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.getExactSizeIfKnown():long");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.hasCharacteristics(int):boolean, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public boolean hasCharacteristics(int r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.hasCharacteristics(int):boolean, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.hasCharacteristics(int):boolean");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public boolean tryAdvance(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.tryAdvance(java.util.function.Consumer):boolean");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.trySplit():java.util.Spliterator<java.util.Map$Entry<K, V>>, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public java.util.Spliterator<java.util.Map.Entry<K, V>> trySplit() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.trySplit():java.util.Spliterator<java.util.Map$Entry<K, V>>, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntrySetSpliterator.trySplit():java.util.Spliterator");
                }
            }

            UnmodifiableEntrySet(Set<? extends Map.Entry<? extends K, ? extends V>> s) {
                super(s);
            }

            static <K, V> Consumer<Map.Entry<K, V>> entryConsumer(Consumer<? super Map.Entry<K, V>> action) {
                return new java_util_function_Consumer_entryConsumer_java_util_function_Consumer_action_LambdaImpl0(action);
            }

            public void forEach(Consumer<? super Map.Entry<K, V>> action) {
                Objects.requireNonNull(action);
                this.c.forEach(entryConsumer(action));
            }

            public Spliterator<Map.Entry<K, V>> spliterator() {
                return new UnmodifiableEntrySetSpliterator(this.c.spliterator());
            }

            public Stream<Map.Entry<K, V>> stream() {
                return StreamSupport.stream(spliterator(), false);
            }

            public Stream<Map.Entry<K, V>> parallelStream() {
                return StreamSupport.stream(spliterator(), true);
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new Iterator<Map.Entry<K, V>>(this) {
                    private final Iterator<? extends Map.Entry<? extends K, ? extends V>> i;
                    final /* synthetic */ UnmodifiableEntrySet this$2;

                    {
                        this.this$2 = this$2;
                        this.i = this.this$2.c.iterator();
                    }

                    public boolean hasNext() {
                        return this.i.hasNext();
                    }

                    public /* bridge */ /* synthetic */ Object next() {
                        return next();
                    }

                    public Map.Entry<K, V> next() {
                        return new UnmodifiableEntry((Map.Entry) this.i.next());
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            public Object[] toArray() {
                Object[] a = this.c.toArray();
                for (int i = 0; i < a.length; i++) {
                    a[i] = new UnmodifiableEntry((Map.Entry) a[i]);
                }
                return a;
            }

            public <T> T[] toArray(T[] a) {
                Object[] arr = this.c.toArray(a.length == 0 ? a : Arrays.copyOf(a, 0));
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = new UnmodifiableEntry((Map.Entry) arr[i]);
                }
                if (arr.length > a.length) {
                    return arr;
                }
                System.arraycopy((Object) arr, 0, (Object) a, 0, arr.length);
                if (a.length > arr.length) {
                    a[arr.length] = null;
                }
                return a;
            }

            public boolean contains(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                return this.c.contains(new UnmodifiableEntry((Map.Entry) o));
            }

            public boolean containsAll(Collection<?> coll) {
                for (Object e : coll) {
                    if (!contains(e)) {
                        return false;
                    }
                }
                return true;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Set)) {
                    return false;
                }
                Set<?> s = (Set) o;
                if (s.size() != this.c.size()) {
                    return false;
                }
                return containsAll(s);
            }

            private static class UnmodifiableEntry<K, V> implements Map.Entry<K, V> {
                private Map.Entry<? extends K, ? extends V> e;

                UnmodifiableEntry(Map.Entry<? extends K, ? extends V> e2) {
                    this.e = (Map.Entry) Objects.requireNonNull(e2);
                }

                public K getKey() {
                    return this.e.getKey();
                }

                public V getValue() {
                    return this.e.getValue();
                }

                public V setValue(V v) {
                    throw new UnsupportedOperationException();
                }

                public int hashCode() {
                    return this.e.hashCode();
                }

                public boolean equals(Object o) {
                    if (this == o) {
                        return true;
                    }
                    if (!(o instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> t = (Map.Entry) o;
                    if (Collections.eq(this.e.getKey(), t.getKey())) {
                        return Collections.eq(this.e.getValue(), t.getValue());
                    }
                    return false;
                }

                public String toString() {
                    return this.e.toString();
                }
            }
        }
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> m) {
        return new UnmodifiableSortedMap(m);
    }

    static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap<K, ? extends V> sm;

        UnmodifiableSortedMap(SortedMap<K, ? extends V> m) {
            super(m);
            this.sm = m;
        }

        public Comparator<? super K> comparator() {
            return this.sm.comparator();
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new UnmodifiableSortedMap(this.sm.subMap(fromKey, toKey));
        }

        public SortedMap<K, V> headMap(K toKey) {
            return new UnmodifiableSortedMap(this.sm.headMap(toKey));
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return new UnmodifiableSortedMap(this.sm.tailMap(fromKey));
        }

        public K firstKey() {
            return this.sm.firstKey();
        }

        public K lastKey() {
            return this.sm.lastKey();
        }
    }

    public static <T> Collection<T> synchronizedCollection(Collection<T> c) {
        return new SynchronizedCollection(c);
    }

    static <T> Collection<T> synchronizedCollection(Collection<T> c, Object mutex) {
        return new SynchronizedCollection(c, mutex);
    }

    static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 3053995032091335093L;
        final Collection<E> c;
        final Object mutex;

        SynchronizedCollection(Collection<E> c2) {
            this.c = (Collection) Objects.requireNonNull(c2);
            this.mutex = this;
        }

        SynchronizedCollection(Collection<E> c2, Object mutex2) {
            this.c = (Collection) Objects.requireNonNull(c2);
            this.mutex = Objects.requireNonNull(mutex2);
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.c.size();
            }
            return size;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.c.isEmpty();
            }
            return isEmpty;
        }

        public boolean contains(Object o) {
            boolean contains;
            synchronized (this.mutex) {
                contains = this.c.contains(o);
            }
            return contains;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = this.c.toArray();
            }
            return array;
        }

        public <T> T[] toArray(T[] a) {
            T[] array;
            synchronized (this.mutex) {
                array = this.c.toArray(a);
            }
            return array;
        }

        public Iterator<E> iterator() {
            return this.c.iterator();
        }

        public boolean add(E e) {
            boolean add;
            synchronized (this.mutex) {
                add = this.c.add(e);
            }
            return add;
        }

        public boolean remove(Object o) {
            boolean remove;
            synchronized (this.mutex) {
                remove = this.c.remove(o);
            }
            return remove;
        }

        public boolean containsAll(Collection<?> coll) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = this.c.containsAll(coll);
            }
            return containsAll;
        }

        public boolean addAll(Collection<? extends E> coll) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = this.c.addAll(coll);
            }
            return addAll;
        }

        public boolean removeAll(Collection<?> coll) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = this.c.removeAll(coll);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> coll) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = this.c.retainAll(coll);
            }
            return retainAll;
        }

        public void clear() {
            synchronized (this.mutex) {
                this.c.clear();
            }
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.c.toString();
            }
            return obj;
        }

        public void forEach(Consumer<? super E> consumer) {
            synchronized (this.mutex) {
                this.c.forEach(consumer);
            }
        }

        public boolean removeIf(Predicate<? super E> filter) {
            boolean removeIf;
            synchronized (this.mutex) {
                removeIf = this.c.removeIf(filter);
            }
            return removeIf;
        }

        public Spliterator<E> spliterator() {
            return this.c.spliterator();
        }

        public Stream<E> stream() {
            return this.c.stream();
        }

        public Stream<E> parallelStream() {
            return this.c.parallelStream();
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.mutex) {
                s.defaultWriteObject();
            }
        }
    }

    public static <T> Set<T> synchronizedSet(Set<T> s) {
        return new SynchronizedSet(s);
    }

    static <T> Set<T> synchronizedSet(Set<T> s, Object mutex) {
        return new SynchronizedSet(s, mutex);
    }

    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 487447009682186044L;

        SynchronizedSet(Set<E> s) {
            super(s);
        }

        SynchronizedSet(Set<E> s, Object mutex) {
            super(s, mutex);
        }

        public boolean equals(Object o) {
            boolean equals;
            if (this == o) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.c.equals(o);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.c.hashCode();
            }
            return hashCode;
        }
    }

    public static <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> s) {
        return new SynchronizedSortedSet(s);
    }

    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 8695801310862127406L;
        private final SortedSet<E> ss;

        SynchronizedSortedSet(SortedSet<E> s) {
            super(s);
            this.ss = s;
        }

        SynchronizedSortedSet(SortedSet<E> s, Object mutex) {
            super(s, mutex);
            this.ss = s;
        }

        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = this.ss.comparator();
            }
            return comparator;
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.subSet(fromElement, toElement), this.mutex);
            }
            return synchronizedSortedSet;
        }

        public SortedSet<E> headSet(E toElement) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.headSet(toElement), this.mutex);
            }
            return synchronizedSortedSet;
        }

        public SortedSet<E> tailSet(E fromElement) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.tailSet(fromElement), this.mutex);
            }
            return synchronizedSortedSet;
        }

        public E first() {
            E first;
            synchronized (this.mutex) {
                first = this.ss.first();
            }
            return first;
        }

        public E last() {
            E last;
            synchronized (this.mutex) {
                last = this.ss.last();
            }
            return last;
        }
    }

    public static <T> List<T> synchronizedList(List<T> list) {
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list);
        }
        return new SynchronizedList(list);
    }

    static <T> List<T> synchronizedList(List<T> list, Object mutex) {
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list, mutex);
        }
        return new SynchronizedList(list, mutex);
    }

    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = -7754090372962971524L;
        final List<E> list;

        SynchronizedList(List<E> list2) {
            super(list2);
            this.list = list2;
        }

        SynchronizedList(List<E> list2, Object mutex) {
            super(list2, mutex);
            this.list = list2;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (this == o) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.list.equals(o);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        public E get(int index) {
            E e;
            synchronized (this.mutex) {
                e = this.list.get(index);
            }
            return e;
        }

        public E set(int index, E element) {
            E e;
            synchronized (this.mutex) {
                e = this.list.set(index, element);
            }
            return e;
        }

        public void add(int index, E element) {
            synchronized (this.mutex) {
                this.list.add(index, element);
            }
        }

        public E remove(int index) {
            E remove;
            synchronized (this.mutex) {
                remove = this.list.remove(index);
            }
            return remove;
        }

        public int indexOf(Object o) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = this.list.indexOf(o);
            }
            return indexOf;
        }

        public int lastIndexOf(Object o) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = this.list.lastIndexOf(o);
            }
            return lastIndexOf;
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = this.list.addAll(index, c);
            }
            return addAll;
        }

        public ListIterator<E> listIterator() {
            return this.list.listIterator();
        }

        public ListIterator<E> listIterator(int index) {
            return this.list.listIterator(index);
        }

        public List<E> subList(int fromIndex, int toIndex) {
            SynchronizedList synchronizedList;
            synchronized (this.mutex) {
                synchronizedList = new SynchronizedList(this.list.subList(fromIndex, toIndex), this.mutex);
            }
            return synchronizedList;
        }

        public void replaceAll(UnaryOperator<E> operator) {
            synchronized (this.mutex) {
                this.list.replaceAll(operator);
            }
        }

        public void sort(Comparator<? super E> c) {
            synchronized (this.mutex) {
                this.list.sort(c);
            }
        }

        private Object readResolve() {
            if (this.list instanceof RandomAccess) {
                return new SynchronizedRandomAccessList<>(this.list);
            }
            return this;
        }
    }

    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1530674583602358482L;

        SynchronizedRandomAccessList(List<E> list) {
            super(list);
        }

        SynchronizedRandomAccessList(List<E> list, Object mutex) {
            super(list, mutex);
        }

        public List<E> subList(int fromIndex, int toIndex) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.mutex) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(fromIndex, toIndex), this.mutex);
            }
            return synchronizedRandomAccessList;
        }

        private Object writeReplace() {
            return new SynchronizedList(this.list);
        }
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> m) {
        return new SynchronizedMap(m);
    }

    private static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 1978198479659022715L;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private final Map<K, V> m;
        final Object mutex;
        private transient Collection<V> values;

        SynchronizedMap(Map<K, V> m2) {
            this.keySet = null;
            this.entrySet = null;
            this.values = null;
            this.m = (Map) Objects.requireNonNull(m2);
            this.mutex = this;
        }

        SynchronizedMap(Map<K, V> m2, Object mutex2) {
            this.keySet = null;
            this.entrySet = null;
            this.values = null;
            this.m = m2;
            this.mutex = mutex2;
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.m.size();
            }
            return size;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.m.isEmpty();
            }
            return isEmpty;
        }

        public boolean containsKey(Object key) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = this.m.containsKey(key);
            }
            return containsKey;
        }

        public boolean containsValue(Object value) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = this.m.containsValue(value);
            }
            return containsValue;
        }

        public V get(Object key) {
            V v;
            synchronized (this.mutex) {
                v = this.m.get(key);
            }
            return v;
        }

        public V put(K key, V value) {
            V put;
            synchronized (this.mutex) {
                put = this.m.put(key, value);
            }
            return put;
        }

        public V remove(Object key) {
            V remove;
            synchronized (this.mutex) {
                remove = this.m.remove(key);
            }
            return remove;
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                this.m.putAll(map);
            }
        }

        public void clear() {
            synchronized (this.mutex) {
                this.m.clear();
            }
        }

        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = new SynchronizedSet(this.m.keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = new SynchronizedSet(this.m.entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = new SynchronizedCollection(this.m.values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }

        public boolean equals(Object o) {
            boolean equals;
            if (this == o) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.m.equals(o);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.m.hashCode();
            }
            return hashCode;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.m.toString();
            }
            return obj;
        }

        public V getOrDefault(Object k, V defaultValue) {
            V orDefault;
            synchronized (this.mutex) {
                orDefault = this.m.getOrDefault(k, defaultValue);
            }
            return orDefault;
        }

        public void forEach(BiConsumer<? super K, ? super V> action) {
            synchronized (this.mutex) {
                this.m.forEach(action);
            }
        }

        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            synchronized (this.mutex) {
                this.m.replaceAll(function);
            }
        }

        public V putIfAbsent(K key, V value) {
            V putIfAbsent;
            synchronized (this.mutex) {
                putIfAbsent = this.m.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.mutex) {
                remove = this.m.remove(key, value);
            }
            return remove;
        }

        public boolean replace(K key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.mutex) {
                replace = this.m.replace(key, oldValue, newValue);
            }
            return replace;
        }

        public V replace(K key, V value) {
            V replace;
            synchronized (this.mutex) {
                replace = this.m.replace(key, value);
            }
            return replace;
        }

        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.mutex) {
                computeIfAbsent = this.m.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.mutex) {
                computeIfPresent = this.m.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.mutex) {
                compute = this.m.compute(key, remappingFunction);
            }
            return compute;
        }

        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.mutex) {
                merge = this.m.merge(key, value, remappingFunction);
            }
            return merge;
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            synchronized (this.mutex) {
                s.defaultWriteObject();
            }
        }
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m) {
        return new SynchronizedSortedMap(m);
    }

    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap<K, V> sm;

        SynchronizedSortedMap(SortedMap<K, V> m) {
            super(m);
            this.sm = m;
        }

        SynchronizedSortedMap(SortedMap<K, V> m, Object mutex) {
            super(m, mutex);
            this.sm = m;
        }

        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = this.sm.comparator();
            }
            return comparator;
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.subMap(fromKey, toKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        public SortedMap<K, V> headMap(K toKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.headMap(toKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.tailMap(fromKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = this.sm.firstKey();
            }
            return firstKey;
        }

        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = this.sm.lastKey();
            }
            return lastKey;
        }
    }

    public static <E> Collection<E> checkedCollection(Collection<E> c, Class<E> type) {
        return new CheckedCollection(c, type);
    }

    static <T> T[] zeroLengthArray(Class<T> type) {
        return (Object[]) Array.newInstance((Class<?>) type, 0);
    }

    static class CheckedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1578914078182001775L;
        final Collection<E> c;
        final Class<E> type;
        private E[] zeroLengthElementArray;

        /* access modifiers changed from: package-private */
        public void typeCheck(Object o) {
            if (o != null && !this.type.isInstance(o)) {
                throw new ClassCastException(badElementMsg(o));
            }
        }

        private String badElementMsg(Object o) {
            return "Attempt to insert " + o.getClass() + " element into collection with element type " + this.type;
        }

        CheckedCollection(Collection<E> c2, Class<E> type2) {
            this.zeroLengthElementArray = null;
            if (c2 == null || type2 == null) {
                throw new NullPointerException();
            }
            this.c = c2;
            this.type = type2;
        }

        public int size() {
            return this.c.size();
        }

        public boolean isEmpty() {
            return this.c.isEmpty();
        }

        public boolean contains(Object o) {
            return this.c.contains(o);
        }

        public Object[] toArray() {
            return this.c.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return this.c.toArray(a);
        }

        public String toString() {
            return this.c.toString();
        }

        public boolean remove(Object o) {
            return this.c.remove(o);
        }

        public void clear() {
            this.c.clear();
        }

        public boolean containsAll(Collection<?> coll) {
            return this.c.containsAll(coll);
        }

        public boolean removeAll(Collection<?> coll) {
            return this.c.removeAll(coll);
        }

        public boolean retainAll(Collection<?> coll) {
            return this.c.retainAll(coll);
        }

        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        public java.util.Iterator<E> iterator() {
            /*
                r2 = this;
                java.util.Collection<E> r1 = r2.c
                java.util.Iterator r0 = r1.iterator()
                java.util.Collections$CheckedCollection$1 r1 = new java.util.Collections$CheckedCollection$1
                r1.<init>(r2, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedCollection.iterator():java.util.Iterator");
        }

        public boolean add(E e) {
            typeCheck(e);
            return this.c.add(e);
        }

        private E[] zeroLengthElementArray() {
            if (this.zeroLengthElementArray != null) {
                return this.zeroLengthElementArray;
            }
            E[] zeroLengthArray = Collections.zeroLengthArray(this.type);
            this.zeroLengthElementArray = zeroLengthArray;
            return zeroLengthArray;
        }

        /* access modifiers changed from: package-private */
        public Collection<E> checkedCopyOf(Collection<? extends E> coll) {
            Object[] a;
            try {
                E[] z = zeroLengthElementArray();
                a = coll.toArray(z);
                if (a.getClass() != z.getClass()) {
                    a = Arrays.copyOf(a, a.length, z.getClass());
                }
            } catch (ArrayStoreException e) {
                a = (Object[]) coll.toArray().clone();
                for (Object o : a) {
                    typeCheck(o);
                }
            }
            return Arrays.asList(a);
        }

        public boolean addAll(Collection<? extends E> coll) {
            return this.c.addAll(checkedCopyOf(coll));
        }

        public void forEach(Consumer<? super E> action) {
            this.c.forEach(action);
        }

        public boolean removeIf(Predicate<? super E> filter) {
            return this.c.removeIf(filter);
        }

        public Spliterator<E> spliterator() {
            return this.c.spliterator();
        }

        public Stream<E> stream() {
            return this.c.stream();
        }

        public Stream<E> parallelStream() {
            return this.c.parallelStream();
        }
    }

    public static <E> Set<E> checkedSet(Set<E> s, Class<E> type) {
        return new CheckedSet(s, type);
    }

    static class CheckedSet<E> extends CheckedCollection<E> implements Set<E>, Serializable {
        private static final long serialVersionUID = 4694047833775013803L;

        CheckedSet(Set<E> s, Class<E> elementType) {
            super(s, elementType);
        }

        public boolean equals(Object o) {
            if (o != this) {
                return this.c.equals(o);
            }
            return true;
        }

        public int hashCode() {
            return this.c.hashCode();
        }
    }

    public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s, Class<E> type) {
        return new CheckedSortedSet(s, type);
    }

    static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E>, Serializable {
        private static final long serialVersionUID = 1599911165492914959L;
        private final SortedSet<E> ss;

        CheckedSortedSet(SortedSet<E> s, Class<E> type) {
            super(s, type);
            this.ss = s;
        }

        public Comparator<? super E> comparator() {
            return this.ss.comparator();
        }

        public E first() {
            return this.ss.first();
        }

        public E last() {
            return this.ss.last();
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            return Collections.checkedSortedSet(this.ss.subSet(fromElement, toElement), this.type);
        }

        public SortedSet<E> headSet(E toElement) {
            return Collections.checkedSortedSet(this.ss.headSet(toElement), this.type);
        }

        public SortedSet<E> tailSet(E fromElement) {
            return Collections.checkedSortedSet(this.ss.tailSet(fromElement), this.type);
        }
    }

    public static <E> List<E> checkedList(List<E> list, Class<E> type) {
        if (list instanceof RandomAccess) {
            return new CheckedRandomAccessList(list, type);
        }
        return new CheckedList(list, type);
    }

    static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        private static final long serialVersionUID = 65247728283967356L;
        final List<E> list;

        /* renamed from: java.util.Collections$CheckedList$-void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0 implements UnaryOperator {
            private /* synthetic */ UnaryOperator val$operator;
            private /* synthetic */ CheckedList val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedList.-void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0.<init>(java.util.Collections$CheckedList, java.util.function.UnaryOperator):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0(java.util.Collections.CheckedList r1, java.util.function.UnaryOperator r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedList.-void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0.<init>(java.util.Collections$CheckedList, java.util.function.UnaryOperator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedList.void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0.<init>(java.util.Collections$CheckedList, java.util.function.UnaryOperator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedList.-void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.Object apply(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedList.-void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedList.void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0.apply(java.lang.Object):java.lang.Object");
            }
        }

        CheckedList(List<E> list2, Class<E> type) {
            super(list2, type);
            this.list = list2;
        }

        public boolean equals(Object o) {
            if (o != this) {
                return this.list.equals(o);
            }
            return true;
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public E get(int index) {
            return this.list.get(index);
        }

        public E remove(int index) {
            return this.list.remove(index);
        }

        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        public E set(int index, E element) {
            typeCheck(element);
            return this.list.set(index, element);
        }

        public void add(int index, E element) {
            typeCheck(element);
            this.list.add(index, element);
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            return this.list.addAll(index, checkedCopyOf(c));
        }

        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        public java.util.ListIterator<E> listIterator(int r3) {
            /*
                r2 = this;
                java.util.List<E> r1 = r2.list
                java.util.ListIterator r0 = r1.listIterator(r3)
                java.util.Collections$CheckedList$1 r1 = new java.util.Collections$CheckedList$1
                r1.<init>(r2, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedList.listIterator(int):java.util.ListIterator");
        }

        public List<E> subList(int fromIndex, int toIndex) {
            return new CheckedList(this.list.subList(fromIndex, toIndex), this.type);
        }

        public void replaceAll(UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
            this.list.replaceAll(new void_replaceAll_java_util_function_UnaryOperator_operator_LambdaImpl0(this, operator));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: -java_util_Collections$CheckedList_lambda$2  reason: not valid java name */
        public /* synthetic */ Object m200java_util_Collections$CheckedList_lambda$2(UnaryOperator operator, Object e) {
            E newValue = operator.apply(e);
            typeCheck(newValue);
            return newValue;
        }

        public void sort(Comparator<? super E> c) {
            this.list.sort(c);
        }
    }

    static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1638200125423088369L;

        CheckedRandomAccessList(List<E> list, Class<E> type) {
            super(list, type);
        }

        public List<E> subList(int fromIndex, int toIndex) {
            return new CheckedRandomAccessList(this.list.subList(fromIndex, toIndex), this.type);
        }
    }

    public static <K, V> Map<K, V> checkedMap(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
        return new CheckedMap(m, keyType, valueType);
    }

    private static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 5742860141034234728L;
        private transient Set<Map.Entry<K, V>> entrySet;
        final Class<K> keyType;
        private final Map<K, V> m;
        final Class<V> valueType;

        /* renamed from: java.util.Collections$CheckedMap$-java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0 implements Function {
            private /* synthetic */ Function val$mappingFunction;
            private /* synthetic */ CheckedMap val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.-java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.Function):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0(java.util.Collections.CheckedMap r1, java.util.function.Function r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.-java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.Function):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.Function):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.-java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.Object apply(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.-java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0.apply(java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: java.util.Collections$CheckedMap$-java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0 implements BiFunction {
            private /* synthetic */ BiFunction val$remappingFunction;
            private /* synthetic */ CheckedMap val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.-java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.BiFunction):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0(java.util.Collections.CheckedMap r1, java.util.function.BiFunction r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.-java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.BiFunction):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.BiFunction):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.-java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.-java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* renamed from: java.util.Collections$CheckedMap$-java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0 implements BiFunction {
            private /* synthetic */ BiFunction val$func;
            private /* synthetic */ CheckedMap val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.-java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.BiFunction):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0(java.util.Collections.CheckedMap r1, java.util.function.BiFunction r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.-java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.BiFunction):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0.<init>(java.util.Collections$CheckedMap, java.util.function.BiFunction):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.-java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.Object apply(java.lang.Object r1, java.lang.Object r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.-java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        private void typeCheck(Object key, Object value) {
            if (key != null && !this.keyType.isInstance(key)) {
                throw new ClassCastException(badKeyMsg(key));
            } else if (value != null && !this.valueType.isInstance(value)) {
                throw new ClassCastException(badValueMsg(value));
            }
        }

        private BiFunction<? super K, ? super V, ? extends V> typeCheck(BiFunction<? super K, ? super V, ? extends V> func) {
            Objects.requireNonNull(func);
            return new java_util_function_BiFunction_typeCheck_java_util_function_BiFunction_func_LambdaImpl0(this, func);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: -java_util_Collections$CheckedMap_lambda$3  reason: not valid java name */
        public /* synthetic */ Object m201java_util_Collections$CheckedMap_lambda$3(BiFunction func, Object k, Object v) {
            V newValue = func.apply(k, v);
            typeCheck(k, newValue);
            return newValue;
        }

        private String badKeyMsg(Object key) {
            return "Attempt to insert " + key.getClass() + " key into map with key type " + this.keyType;
        }

        private String badValueMsg(Object value) {
            return "Attempt to insert " + value.getClass() + " value into map with value type " + this.valueType;
        }

        CheckedMap(Map<K, V> m2, Class<K> keyType2, Class<V> valueType2) {
            this.entrySet = null;
            this.m = (Map) Objects.requireNonNull(m2);
            this.keyType = (Class) Objects.requireNonNull(keyType2);
            this.valueType = (Class) Objects.requireNonNull(valueType2);
        }

        public int size() {
            return this.m.size();
        }

        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        public boolean containsKey(Object key) {
            return this.m.containsKey(key);
        }

        public boolean containsValue(Object v) {
            return this.m.containsValue(v);
        }

        public V get(Object key) {
            return this.m.get(key);
        }

        public V remove(Object key) {
            return this.m.remove(key);
        }

        public void clear() {
            this.m.clear();
        }

        public Set<K> keySet() {
            return this.m.keySet();
        }

        public Collection<V> values() {
            return this.m.values();
        }

        public boolean equals(Object o) {
            if (o != this) {
                return this.m.equals(o);
            }
            return true;
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        public String toString() {
            return this.m.toString();
        }

        public V put(K key, V value) {
            typeCheck(key, value);
            return this.m.put(key, value);
        }

        public void putAll(Map<? extends K, ? extends V> t) {
            Object[] entries = t.entrySet().toArray();
            List<Map.Entry<K, V>> checked = new ArrayList<>(entries.length);
            for (Object o : entries) {
                Map.Entry<?, ?> e = (Map.Entry) o;
                Object k = e.getKey();
                Object v = e.getValue();
                typeCheck(k, v);
                checked.add(new AbstractMap.SimpleImmutableEntry(k, v));
            }
            for (Map.Entry<K, V> e2 : checked) {
                this.m.put(e2.getKey(), e2.getValue());
            }
        }

        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = new CheckedEntrySet(this.m.entrySet(), this.valueType);
            }
            return this.entrySet;
        }

        public void forEach(BiConsumer<? super K, ? super V> action) {
            this.m.forEach(action);
        }

        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            this.m.replaceAll(typeCheck(function));
        }

        public V putIfAbsent(K key, V value) {
            typeCheck(key, value);
            return this.m.putIfAbsent(key, value);
        }

        public boolean remove(Object key, Object value) {
            return this.m.remove(key, value);
        }

        public boolean replace(K key, V oldValue, V newValue) {
            typeCheck(key, newValue);
            return this.m.replace(key, oldValue, newValue);
        }

        public V replace(K key, V value) {
            typeCheck(key, value);
            return this.m.replace(key, value);
        }

        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            Objects.requireNonNull(mappingFunction);
            return this.m.computeIfAbsent(key, new java_lang_Object_computeIfAbsent_java_lang_Object_key_java_util_function_Function_mappingFunction_LambdaImpl0(this, mappingFunction));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: -java_util_Collections$CheckedMap_lambda$4  reason: not valid java name */
        public /* synthetic */ Object m202java_util_Collections$CheckedMap_lambda$4(Function mappingFunction, Object k) {
            V value = mappingFunction.apply(k);
            typeCheck(k, value);
            return value;
        }

        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            return this.m.computeIfPresent(key, typeCheck(remappingFunction));
        }

        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            return this.m.compute(key, typeCheck(remappingFunction));
        }

        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            Objects.requireNonNull(remappingFunction);
            return this.m.merge(key, value, new java_lang_Object_merge_java_lang_Object_key_java_lang_Object_value_java_util_function_BiFunction_remappingFunction_LambdaImpl0(this, remappingFunction));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: -java_util_Collections$CheckedMap_lambda$5  reason: not valid java name */
        public /* synthetic */ Object m203java_util_Collections$CheckedMap_lambda$5(BiFunction remappingFunction, Object v1, Object v2) {
            V newValue = remappingFunction.apply(v1, v2);
            typeCheck((Object) null, newValue);
            return newValue;
        }

        static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, V>> s;
            private final Class<V> valueType;

            private static class CheckedEntry<K, V, T> implements Map.Entry<K, V> {
                private final Map.Entry<K, V> e;
                private final Class<T> valueType;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.<init>(java.util.Map$Entry, java.lang.Class):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                CheckedEntry(java.util.Map.Entry<K, V> r1, java.lang.Class<T> r2) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.<init>(java.util.Map$Entry, java.lang.Class):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.<init>(java.util.Map$Entry, java.lang.Class):void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.badValueMsg(java.lang.Object):java.lang.String, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                private java.lang.String badValueMsg(java.lang.Object r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.badValueMsg(java.lang.Object):java.lang.String, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.badValueMsg(java.lang.Object):java.lang.String");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.equals(java.lang.Object):boolean, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public boolean equals(java.lang.Object r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.equals(java.lang.Object):boolean, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.equals(java.lang.Object):boolean");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.getKey():K, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public K getKey() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.getKey():K, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.getKey():java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.getValue():V, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public V getValue() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.getValue():V, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.getValue():java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.hashCode():int, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public int hashCode() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.hashCode():int, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.hashCode():int");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.setValue(java.lang.Object):V, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public V setValue(V r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.setValue(java.lang.Object):V, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.setValue(java.lang.Object):java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.toString():java.lang.String, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public java.lang.String toString() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.toString():java.lang.String, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.CheckedEntry.toString():java.lang.String");
                }
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.CheckedEntrySet.<init>(java.util.Set, java.lang.Class):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            CheckedEntrySet(java.util.Set<java.util.Map.Entry<K, V>> r1, java.lang.Class<V> r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CheckedMap.CheckedEntrySet.<init>(java.util.Set, java.lang.Class):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.<init>(java.util.Set, java.lang.Class):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.batchRemove(java.util.Collection, boolean):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            private boolean batchRemove(java.util.Collection<?> r1, boolean r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.batchRemove(java.util.Collection, boolean):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.batchRemove(java.util.Collection, boolean):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.add(java.lang.Object):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* bridge */ /* synthetic */ boolean add(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.add(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.add(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.clear():void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public void clear() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.clear():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.clear():void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.contains(java.lang.Object):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public boolean contains(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.contains(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.contains(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.containsAll(java.util.Collection):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public boolean containsAll(java.util.Collection<?> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CheckedMap.CheckedEntrySet.containsAll(java.util.Collection):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.containsAll(java.util.Collection):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.equals(java.lang.Object):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public boolean equals(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.equals(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.equals(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.hashCode():int, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public int hashCode() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.hashCode():int, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.hashCode():int");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.isEmpty():boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public boolean isEmpty() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.isEmpty():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.isEmpty():boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.iterator():java.util.Iterator<java.util.Map$Entry<K, V>>, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.iterator():java.util.Iterator<java.util.Map$Entry<K, V>>, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.iterator():java.util.Iterator");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.remove(java.lang.Object):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public boolean remove(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.remove(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.remove(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.size():int, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public int size() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.size():int, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.size():int");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.toArray():java.lang.Object[], dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.Object[] toArray() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.toArray():java.lang.Object[], dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.toArray():java.lang.Object[]");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.toArray(java.lang.Object[]):T[], dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public <T> T[] toArray(T[] r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.toArray(java.lang.Object[]):T[], dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.toArray(java.lang.Object[]):java.lang.Object[]");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.toString():java.lang.String, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.String toString() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CheckedMap.CheckedEntrySet.toString():java.lang.String, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CheckedMap.CheckedEntrySet.toString():java.lang.String");
            }

            public boolean add(Map.Entry<K, V> entry) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
                throw new UnsupportedOperationException();
            }

            public boolean removeAll(Collection<?> c) {
                return batchRemove(c, false);
            }

            public boolean retainAll(Collection<?> c) {
                return batchRemove(c, true);
            }

            static <K, V, T> CheckedEntry<K, V, T> checkedEntry(Map.Entry<K, V> e, Class<T> valueType2) {
                return new CheckedEntry<>(e, valueType2);
            }
        }
    }

    public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
        return new CheckedSortedMap(m, keyType, valueType);
    }

    static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V>, Serializable {
        private static final long serialVersionUID = 1599671320688067438L;
        private final SortedMap<K, V> sm;

        CheckedSortedMap(SortedMap<K, V> m, Class<K> keyType, Class<V> valueType) {
            super(m, keyType, valueType);
            this.sm = m;
        }

        public Comparator<? super K> comparator() {
            return this.sm.comparator();
        }

        public K firstKey() {
            return this.sm.firstKey();
        }

        public K lastKey() {
            return this.sm.lastKey();
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return Collections.checkedSortedMap(this.sm.subMap(fromKey, toKey), this.keyType, this.valueType);
        }

        public SortedMap<K, V> headMap(K toKey) {
            return Collections.checkedSortedMap(this.sm.headMap(toKey), this.keyType, this.valueType);
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return Collections.checkedSortedMap(this.sm.tailMap(fromKey), this.keyType, this.valueType);
        }
    }

    public static <T> Iterator<T> emptyIterator() {
        return EmptyIterator.EMPTY_ITERATOR;
    }

    private static class EmptyIterator<E> implements Iterator<E> {
        static final EmptyIterator<Object> EMPTY_ITERATOR = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Collections.EmptyIterator.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Collections.EmptyIterator.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.EmptyIterator.<clinit>():void");
        }

        /* synthetic */ EmptyIterator(EmptyIterator emptyIterator) {
            this();
        }

        private EmptyIterator() {
        }

        public boolean hasNext() {
            return false;
        }

        public E next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
        }
    }

    public static <T> ListIterator<T> emptyListIterator() {
        return EmptyListIterator.EMPTY_ITERATOR;
    }

    private static class EmptyListIterator<E> extends EmptyIterator<E> implements ListIterator<E> {
        static final EmptyListIterator<Object> EMPTY_ITERATOR = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Collections.EmptyListIterator.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Collections.EmptyListIterator.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.EmptyListIterator.<clinit>():void");
        }

        private EmptyListIterator() {
            super((EmptyIterator) null);
        }

        public boolean hasPrevious() {
            return false;
        }

        public E previous() {
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return -1;
        }

        public void set(E e) {
            throw new IllegalStateException();
        }

        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    public static <T> Enumeration<T> emptyEnumeration() {
        return EmptyEnumeration.EMPTY_ENUMERATION;
    }

    private static class EmptyEnumeration<E> implements Enumeration<E> {
        static final EmptyEnumeration<Object> EMPTY_ENUMERATION = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Collections.EmptyEnumeration.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Collections.EmptyEnumeration.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.EmptyEnumeration.<clinit>():void");
        }

        private EmptyEnumeration() {
        }

        public boolean hasMoreElements() {
            return false;
        }

        public E nextElement() {
            throw new NoSuchElementException();
        }
    }

    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }

    private static class EmptySet<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 1582296315990362920L;

        /* synthetic */ EmptySet(EmptySet emptySet) {
            this();
        }

        private EmptySet() {
        }

        public Iterator<E> iterator() {
            return Collections.emptyIterator();
        }

        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean contains(Object obj) {
            return false;
        }

        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        public Object[] toArray() {
            return new Object[0];
        }

        public <T> T[] toArray(T[] a) {
            if (a.length > 0) {
                a[0] = null;
            }
            return a;
        }

        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
        }

        public boolean removeIf(Predicate<? super E> filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        public Spliterator<E> spliterator() {
            return Spliterators.emptySpliterator();
        }

        private Object readResolve() {
            return Collections.EMPTY_SET;
        }
    }

    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }

    private static class EmptyList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 8842843931221139166L;

        /* synthetic */ EmptyList(EmptyList emptyList) {
            this();
        }

        private EmptyList() {
        }

        public Iterator<E> iterator() {
            return Collections.emptyIterator();
        }

        public ListIterator<E> listIterator() {
            return Collections.emptyListIterator();
        }

        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean contains(Object obj) {
            return false;
        }

        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        public Object[] toArray() {
            return new Object[0];
        }

        public <T> T[] toArray(T[] a) {
            if (a.length > 0) {
                a[0] = null;
            }
            return a;
        }

        public E get(int index) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        public boolean equals(Object o) {
            if (o instanceof List) {
                return ((List) o).isEmpty();
            }
            return false;
        }

        public int hashCode() {
            return 1;
        }

        public boolean removeIf(Predicate<? super E> filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
        }

        public Spliterator<E> spliterator() {
            return Spliterators.emptySpliterator();
        }

        public void replaceAll(UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
        }

        public void sort(Comparator<? super E> comparator) {
        }

        private Object readResolve() {
            return Collections.EMPTY_LIST;
        }
    }

    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    private static class EmptyMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = 6428348081105594320L;

        /* synthetic */ EmptyMap(EmptyMap emptyMap) {
            this();
        }

        private EmptyMap() {
        }

        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean containsKey(Object key) {
            return false;
        }

        public boolean containsValue(Object value) {
            return false;
        }

        public V get(Object key) {
            return null;
        }

        public Set<K> keySet() {
            return Collections.emptySet();
        }

        public Collection<V> values() {
            return Collections.emptySet();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }

        public boolean equals(Object o) {
            if (o instanceof Map) {
                return ((Map) o).isEmpty();
            }
            return false;
        }

        public int hashCode() {
            return 0;
        }

        public V getOrDefault(Object k, V defaultValue) {
            return defaultValue;
        }

        public void forEach(BiConsumer<? super K, ? super V> action) {
            Objects.requireNonNull(action);
        }

        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            Objects.requireNonNull(function);
        }

        public V putIfAbsent(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        public boolean replace(K k, V v, V v2) {
            throw new UnsupportedOperationException();
        }

        public V replace(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        private Object readResolve() {
            return Collections.EMPTY_MAP;
        }
    }

    public static <E> Set<E> singleton(E o) {
        return new SingletonSet(o);
    }

    static <E> Iterator<E> singletonIterator(final E e) {
        return new Iterator<E>() {
            private boolean hasNext = true;

            public boolean hasNext() {
                return this.hasNext;
            }

            public E next() {
                if (this.hasNext) {
                    this.hasNext = false;
                    return e;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void forEachRemaining(Consumer<? super E> action) {
                Objects.requireNonNull(action);
                if (this.hasNext) {
                    action.accept(e);
                    this.hasNext = false;
                }
            }
        };
    }

    static <T> Spliterator<T> singletonSpliterator(final T element) {
        return new Spliterator<T>() {
            long est = 1;

            public Spliterator<T> trySplit() {
                return null;
            }

            public boolean tryAdvance(Consumer<? super T> consumer) {
                Objects.requireNonNull(consumer);
                if (this.est <= 0) {
                    return false;
                }
                this.est--;
                consumer.accept(element);
                return true;
            }

            public void forEachRemaining(Consumer<? super T> consumer) {
                tryAdvance(consumer);
            }

            public long estimateSize() {
                return this.est;
            }

            public int characteristics() {
                return (element != null ? 256 : 0) | 64 | 16384 | 1024 | 1 | 16;
            }
        };
    }

    private static class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 3193687207550431679L;
        private final E element;

        SingletonSet(E e) {
            this.element = e;
        }

        public Iterator<E> iterator() {
            return Collections.singletonIterator(this.element);
        }

        public int size() {
            return 1;
        }

        public boolean contains(Object o) {
            return Collections.eq(o, this.element);
        }

        public void forEach(Consumer<? super E> action) {
            action.accept(this.element);
        }

        public Spliterator<E> spliterator() {
            return Collections.singletonSpliterator(this.element);
        }

        public boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }
    }

    public static <E> List<E> singletonList(E o) {
        return new SingletonList(o);
    }

    private static class SingletonList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 3093736618740652951L;
        private final E element;

        SingletonList(E obj) {
            this.element = obj;
        }

        public Iterator<E> iterator() {
            return Collections.singletonIterator(this.element);
        }

        public int size() {
            return 1;
        }

        public boolean contains(Object obj) {
            return Collections.eq(obj, this.element);
        }

        public E get(int index) {
            if (index == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: 1");
        }

        public void forEach(Consumer<? super E> action) {
            action.accept(this.element);
        }

        public boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        public Spliterator<E> spliterator() {
            return Collections.singletonSpliterator(this.element);
        }

        public void replaceAll(UnaryOperator<E> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        public void sort(Comparator<? super E> comparator) {
        }
    }

    public static <K, V> Map<K, V> singletonMap(K key, V value) {
        return new SingletonMap(key, value);
    }

    private static class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -6979724477215052911L;
        private transient Set<Map.Entry<K, V>> entrySet;
        private final K k;
        private transient Set<K> keySet;
        private final V v;
        private transient Collection<V> values;

        SingletonMap(K key, V value) {
            this.keySet = null;
            this.entrySet = null;
            this.values = null;
            this.k = key;
            this.v = value;
        }

        public int size() {
            return 1;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean containsKey(Object key) {
            return Collections.eq(key, this.k);
        }

        public boolean containsValue(Object value) {
            return Collections.eq(value, this.v);
        }

        public V get(Object key) {
            if (Collections.eq(key, this.k)) {
                return this.v;
            }
            return null;
        }

        public Set<K> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.singleton(this.k);
            }
            return this.keySet;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.singleton(new AbstractMap.SimpleImmutableEntry(this.k, this.v));
            }
            return this.entrySet;
        }

        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.singleton(this.v);
            }
            return this.values;
        }

        public V getOrDefault(Object key, V defaultValue) {
            return Collections.eq(key, this.k) ? this.v : defaultValue;
        }

        public void forEach(BiConsumer<? super K, ? super V> action) {
            action.accept(this.k, this.v);
        }

        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V putIfAbsent(K k2, V v2) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        public boolean replace(K k2, V v2, V v3) {
            throw new UnsupportedOperationException();
        }

        public V replace(K k2, V v2) {
            throw new UnsupportedOperationException();
        }

        public V computeIfAbsent(K k2, Function<? super K, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        public V computeIfPresent(K k2, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V compute(K k2, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }

        public V merge(K k2, V v2, BiFunction<? super V, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException();
        }
    }

    public static <T> List<T> nCopies(int n, T o) {
        if (n >= 0) {
            return new CopiesList(n, o);
        }
        throw new IllegalArgumentException("List length = " + n);
    }

    private static class CopiesList<E> extends AbstractList<E> implements RandomAccess, Serializable {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f36assertionsDisabled = false;
        private static final long serialVersionUID = 2739099268398711800L;
        final E element;
        final int n;

        /* renamed from: java.util.Collections$CopiesList$-java_util_stream_Stream_parallelStream__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_util_stream_Stream_parallelStream__LambdaImpl0 implements IntFunction {
            private /* synthetic */ CopiesList val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_parallelStream__LambdaImpl0.<init>(java.util.Collections$CopiesList):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_util_stream_Stream_parallelStream__LambdaImpl0(java.util.Collections.CopiesList r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_parallelStream__LambdaImpl0.<init>(java.util.Collections$CopiesList):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CopiesList.java_util_stream_Stream_parallelStream__LambdaImpl0.<init>(java.util.Collections$CopiesList):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_parallelStream__LambdaImpl0.apply(int):java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.Object apply(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_parallelStream__LambdaImpl0.apply(int):java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CopiesList.java_util_stream_Stream_parallelStream__LambdaImpl0.apply(int):java.lang.Object");
            }
        }

        /* renamed from: java.util.Collections$CopiesList$-java_util_stream_Stream_stream__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_util_stream_Stream_stream__LambdaImpl0 implements IntFunction {
            private /* synthetic */ CopiesList val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_stream__LambdaImpl0.<init>(java.util.Collections$CopiesList):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_util_stream_Stream_stream__LambdaImpl0(java.util.Collections.CopiesList r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_stream__LambdaImpl0.<init>(java.util.Collections$CopiesList):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CopiesList.java_util_stream_Stream_stream__LambdaImpl0.<init>(java.util.Collections$CopiesList):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_stream__LambdaImpl0.apply(int):java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.lang.Object apply(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Collections.CopiesList.-java_util_stream_Stream_stream__LambdaImpl0.apply(int):java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CopiesList.java_util_stream_Stream_stream__LambdaImpl0.apply(int):java.lang.Object");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CopiesList.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.CopiesList.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.CopiesList.<clinit>():void");
        }

        CopiesList(int n2, E e) {
            boolean z = f36assertionsDisabled;
            if (!f36assertionsDisabled) {
                if (!(n2 >= 0 ? true : z)) {
                    throw new AssertionError();
                }
            }
            this.n = n2;
            this.element = e;
        }

        public int size() {
            return this.n;
        }

        public boolean contains(Object obj) {
            return this.n != 0 ? Collections.eq(obj, this.element) : f36assertionsDisabled;
        }

        public int indexOf(Object o) {
            return contains(o) ? 0 : -1;
        }

        public int lastIndexOf(Object o) {
            if (contains(o)) {
                return this.n - 1;
            }
            return -1;
        }

        public E get(int index) {
            if (index >= 0 && index < this.n) {
                return this.element;
            }
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.n);
        }

        public Object[] toArray() {
            Object[] a = new Object[this.n];
            if (this.element != null) {
                Arrays.fill(a, 0, this.n, (Object) this.element);
            }
            return a;
        }

        public <T> T[] toArray(T[] a) {
            int n2 = this.n;
            if (a.length < n2) {
                a = (Object[]) Array.newInstance(a.getClass().getComponentType(), n2);
                if (this.element != null) {
                    Arrays.fill((Object[]) a, 0, n2, (Object) this.element);
                }
            } else {
                Arrays.fill((Object[]) a, 0, n2, (Object) this.element);
                if (a.length > n2) {
                    a[n2] = null;
                }
            }
            return a;
        }

        public List<E> subList(int fromIndex, int toIndex) {
            if (fromIndex < 0) {
                throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
            } else if (toIndex > this.n) {
                throw new IndexOutOfBoundsException("toIndex = " + toIndex);
            } else if (fromIndex <= toIndex) {
                return new CopiesList(toIndex - fromIndex, this.element);
            } else {
                throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: -java_util_Collections$CopiesList_lambda$6  reason: not valid java name */
        public /* synthetic */ Object m204java_util_Collections$CopiesList_lambda$6(int i) {
            return this.element;
        }

        public Stream<E> stream() {
            return IntStream.range(0, this.n).mapToObj(new java_util_stream_Stream_stream__LambdaImpl0(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: -java_util_Collections$CopiesList_lambda$7  reason: not valid java name */
        public /* synthetic */ Object m205java_util_Collections$CopiesList_lambda$7(int i) {
            return this.element;
        }

        public Stream<E> parallelStream() {
            return IntStream.range(0, this.n).parallel().mapToObj(new java_util_stream_Stream_parallelStream__LambdaImpl0(this));
        }

        public Spliterator<E> spliterator() {
            return stream().spliterator();
        }
    }

    public static <T> Comparator<T> reverseOrder() {
        return ReverseComparator.REVERSE_ORDER;
    }

    private static class ReverseComparator implements Comparator<Comparable<Object>>, Serializable {
        static final ReverseComparator REVERSE_ORDER = null;
        private static final long serialVersionUID = 7207038068494060240L;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Collections.ReverseComparator.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Collections.ReverseComparator.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.ReverseComparator.<clinit>():void");
        }

        private ReverseComparator() {
        }

        public /* bridge */ /* synthetic */ int compare(Object c1, Object c2) {
            return compare((Comparable<Object>) (Comparable) c1, (Comparable<Object>) (Comparable) c2);
        }

        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c2.compareTo(c1);
        }

        private Object readResolve() {
            return Collections.reverseOrder();
        }

        public Comparator<Comparable<Object>> reversed() {
            return Comparator.naturalOrder();
        }
    }

    public static <T> Comparator<T> reverseOrder(Comparator<T> cmp) {
        if (cmp == null) {
            return reverseOrder();
        }
        if (cmp instanceof ReverseComparator2) {
            return ((ReverseComparator2) cmp).cmp;
        }
        return new ReverseComparator2(cmp);
    }

    private static class ReverseComparator2<T> implements Comparator<T>, Serializable {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f37assertionsDisabled = false;
        private static final long serialVersionUID = 4374092139857L;
        final Comparator<T> cmp;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.ReverseComparator2.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Collections.ReverseComparator2.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.ReverseComparator2.<clinit>():void");
        }

        ReverseComparator2(Comparator<T> cmp2) {
            if (!f37assertionsDisabled) {
                if (!(cmp2 != null ? true : f37assertionsDisabled)) {
                    throw new AssertionError();
                }
            }
            this.cmp = cmp2;
        }

        public int compare(T t1, T t2) {
            return this.cmp.compare(t2, t1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof ReverseComparator2) {
                return this.cmp.equals(((ReverseComparator2) o).cmp);
            }
            return f37assertionsDisabled;
        }

        public int hashCode() {
            return this.cmp.hashCode() ^ Integer.MIN_VALUE;
        }

        public Comparator<T> reversed() {
            return this.cmp;
        }
    }

    public static <T> Enumeration<T> enumeration(final Collection<T> c) {
        return new Enumeration<T>() {
            private final Iterator<T> i = c.iterator();

            public boolean hasMoreElements() {
                return this.i.hasNext();
            }

            public T nextElement() {
                return this.i.next();
            }
        };
    }

    public static <T> ArrayList<T> list(Enumeration<T> e) {
        ArrayList<T> l = new ArrayList<>();
        while (e.hasMoreElements()) {
            l.add(e.nextElement());
        }
        return l;
    }

    static boolean eq(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }

    public static int frequency(Collection<?> c, Object o) {
        int result = 0;
        if (o == null) {
            for (Object e : c) {
                if (e == null) {
                    result++;
                }
            }
        } else {
            for (Object e2 : c) {
                if (o.equals(e2)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean disjoint(Collection<?> c1, Collection<?> c2) {
        Collection<?> contains = c2;
        Collection<?> iterate = c1;
        if (c1 instanceof Set) {
            iterate = c2;
            contains = c1;
        } else if (!(c2 instanceof Set)) {
            int c1size = c1.size();
            int c2size = c2.size();
            if (c1size == 0 || c2size == 0) {
                return true;
            }
            if (c1size > c2size) {
                iterate = c2;
                contains = c1;
            }
        }
        for (Object e : iterate) {
            if (contains.contains(e)) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static <T> boolean addAll(Collection<? super T> c, T... elements) {
        boolean result = false;
        for (T element : elements) {
            result |= c.add(element);
        }
        return result;
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return new SetFromMap(map);
    }

    private static class SetFromMap<E> extends AbstractSet<E> implements Set<E>, Serializable {
        private static final long serialVersionUID = 2454657854757543876L;
        private final Map<E, Boolean> m;
        private transient Set<E> s;

        SetFromMap(Map<E, Boolean> map) {
            if (!map.isEmpty()) {
                throw new IllegalArgumentException("Map is non-empty");
            }
            this.m = map;
            this.s = map.keySet();
        }

        public void clear() {
            this.m.clear();
        }

        public int size() {
            return this.m.size();
        }

        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        public boolean contains(Object o) {
            return this.m.containsKey(o);
        }

        public boolean remove(Object o) {
            return this.m.remove(o) != null;
        }

        public boolean add(E e) {
            return this.m.put(e, Boolean.TRUE) == null;
        }

        public Iterator<E> iterator() {
            return this.s.iterator();
        }

        public Object[] toArray() {
            return this.s.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return this.s.toArray(a);
        }

        public String toString() {
            return this.s.toString();
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public boolean equals(Object o) {
            if (o != this) {
                return this.s.equals(o);
            }
            return true;
        }

        public boolean containsAll(Collection<?> c) {
            return this.s.containsAll(c);
        }

        public boolean removeAll(Collection<?> c) {
            return this.s.removeAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            return this.s.retainAll(c);
        }

        public void forEach(Consumer<? super E> action) {
            this.s.forEach(action);
        }

        public boolean removeIf(Predicate<? super E> filter) {
            return this.s.removeIf(filter);
        }

        public Spliterator<E> spliterator() {
            return this.s.spliterator();
        }

        public Stream<E> stream() {
            return this.s.stream();
        }

        public Stream<E> parallelStream() {
            return this.s.parallelStream();
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.s = this.m.keySet();
        }
    }

    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue(deque);
    }

    static class AsLIFOQueue<E> extends AbstractQueue<E> implements Queue<E>, Serializable {
        private static final long serialVersionUID = 1802017725587941708L;
        private final Deque<E> q;

        AsLIFOQueue(Deque<E> q2) {
            this.q = q2;
        }

        public boolean add(E e) {
            this.q.addFirst(e);
            return true;
        }

        public boolean offer(E e) {
            return this.q.offerFirst(e);
        }

        public E poll() {
            return this.q.pollFirst();
        }

        public E remove() {
            return this.q.removeFirst();
        }

        public E peek() {
            return this.q.peekFirst();
        }

        public E element() {
            return this.q.getFirst();
        }

        public void clear() {
            this.q.clear();
        }

        public int size() {
            return this.q.size();
        }

        public boolean isEmpty() {
            return this.q.isEmpty();
        }

        public boolean contains(Object o) {
            return this.q.contains(o);
        }

        public boolean remove(Object o) {
            return this.q.remove(o);
        }

        public Iterator<E> iterator() {
            return this.q.iterator();
        }

        public Object[] toArray() {
            return this.q.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return this.q.toArray(a);
        }

        public String toString() {
            return this.q.toString();
        }

        public boolean containsAll(Collection<?> c) {
            return this.q.containsAll(c);
        }

        public boolean removeAll(Collection<?> c) {
            return this.q.removeAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            return this.q.retainAll(c);
        }

        public void forEach(Consumer<? super E> action) {
            this.q.forEach(action);
        }

        public boolean removeIf(Predicate<? super E> filter) {
            return this.q.removeIf(filter);
        }

        public Spliterator<E> spliterator() {
            return this.q.spliterator();
        }

        public Stream<E> stream() {
            return this.q.stream();
        }

        public Stream<E> parallelStream() {
            return this.q.parallelStream();
        }
    }
}
