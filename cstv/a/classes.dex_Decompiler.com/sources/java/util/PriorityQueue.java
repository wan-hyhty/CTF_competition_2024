package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final long serialVersionUID = -7720805057305804111L;
    private final Comparator<? super E> comparator;
    transient int modCount;
    transient Object[] queue;
    int size;

    public PriorityQueue() {
        this(11, (Comparator) null);
    }

    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, (Comparator) null);
    }

    public PriorityQueue(Comparator<? super E> comparator2) {
        this(11, comparator2);
    }

    public PriorityQueue(int initialCapacity, Comparator<? super E> comparator2) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.queue = new Object[initialCapacity];
        this.comparator = comparator2;
    }

    public PriorityQueue(Collection<? extends E> c) {
        if (c instanceof SortedSet) {
            SortedSet<? extends E> ss = (SortedSet) c;
            this.comparator = ss.comparator();
            initElementsFromCollection(ss);
        } else if (c instanceof PriorityQueue) {
            PriorityQueue<? extends E> pq = (PriorityQueue) c;
            this.comparator = pq.comparator();
            initFromPriorityQueue(pq);
        } else {
            this.comparator = null;
            initFromCollection(c);
        }
    }

    public PriorityQueue(PriorityQueue<? extends E> c) {
        this.comparator = c.comparator();
        initFromPriorityQueue(c);
    }

    public PriorityQueue(SortedSet<? extends E> c) {
        this.comparator = c.comparator();
        initElementsFromCollection(c);
    }

    private void initFromPriorityQueue(PriorityQueue<? extends E> c) {
        if (c.getClass() == PriorityQueue.class) {
            this.queue = c.toArray();
            this.size = c.size();
            return;
        }
        initFromCollection(c);
    }

    private void initElementsFromCollection(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if (a.getClass() != Object[].class) {
            a = Arrays.copyOf(a, a.length, Object[].class);
        }
        if (a.length == 1 || this.comparator != null) {
            for (Object e : a) {
                if (e == null) {
                    throw new NullPointerException();
                }
            }
        }
        this.queue = a;
        this.size = a.length;
    }

    private void initFromCollection(Collection<? extends E> c) {
        initElementsFromCollection(c);
        heapify();
    }

    private void grow(int minCapacity) {
        int i;
        int oldCapacity = this.queue.length;
        if (oldCapacity < 64) {
            i = oldCapacity + 2;
        } else {
            i = oldCapacity >> 1;
        }
        int newCapacity = oldCapacity + i;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        this.queue = Arrays.copyOf((T[]) this.queue, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        } else if (minCapacity > MAX_ARRAY_SIZE) {
            return Integer.MAX_VALUE;
        } else {
            return MAX_ARRAY_SIZE;
        }
    }

    public boolean add(E e) {
        return offer(e);
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        this.modCount++;
        int i = this.size;
        if (i >= this.queue.length) {
            grow(i + 1);
        }
        this.size = i + 1;
        if (i == 0) {
            this.queue[0] = e;
            return true;
        }
        siftUp(i, e);
        return true;
    }

    public E peek() {
        if (this.size == 0) {
            return null;
        }
        return this.queue[0];
    }

    private int indexOf(Object o) {
        if (o == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (o.equals(this.queue[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1) {
            return false;
        }
        removeAt(i);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean removeEq(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (o == this.queue[i]) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf((T[]) this.queue, this.size);
    }

    public <T> T[] toArray(T[] a) {
        int size2 = this.size;
        if (a.length < size2) {
            return Arrays.copyOf(this.queue, size2, a.getClass());
        }
        System.arraycopy((Object) this.queue, 0, (Object) a, 0, size2);
        if (a.length > size2) {
            a[size2] = null;
        }
        return a;
    }

    public Iterator<E> iterator() {
        return new Itr(this, (Itr) null);
    }

    private final class Itr implements Iterator<E> {
        private int cursor;
        private int expectedModCount;
        private ArrayDeque<E> forgetMeNot;
        private int lastRet;
        private E lastRetElt;

        /* synthetic */ Itr(PriorityQueue this$02, Itr itr) {
            this();
        }

        private Itr() {
            this.lastRet = -1;
            this.expectedModCount = PriorityQueue.this.modCount;
        }

        public boolean hasNext() {
            if (this.cursor < PriorityQueue.this.size) {
                return true;
            }
            if (this.forgetMeNot == null || this.forgetMeNot.isEmpty()) {
                return false;
            }
            return true;
        }

        public E next() {
            if (this.expectedModCount != PriorityQueue.this.modCount) {
                throw new ConcurrentModificationException();
            } else if (this.cursor < PriorityQueue.this.size) {
                E[] eArr = PriorityQueue.this.queue;
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return eArr[i];
            } else {
                if (this.forgetMeNot != null) {
                    this.lastRet = -1;
                    this.lastRetElt = this.forgetMeNot.poll();
                    if (this.lastRetElt != null) {
                        return this.lastRetElt;
                    }
                }
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (this.expectedModCount != PriorityQueue.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastRet != -1) {
                E moved = PriorityQueue.this.removeAt(this.lastRet);
                this.lastRet = -1;
                if (moved == null) {
                    this.cursor--;
                } else {
                    if (this.forgetMeNot == null) {
                        this.forgetMeNot = new ArrayDeque<>();
                    }
                    this.forgetMeNot.add(moved);
                }
            } else if (this.lastRetElt != null) {
                PriorityQueue.this.removeEq(this.lastRetElt);
                this.lastRetElt = null;
            } else {
                throw new IllegalStateException();
            }
            this.expectedModCount = PriorityQueue.this.modCount;
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.modCount++;
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = null;
        }
        this.size = 0;
    }

    public E poll() {
        if (this.size == 0) {
            return null;
        }
        int s = this.size - 1;
        this.size = s;
        this.modCount++;
        E result = this.queue[0];
        E x = this.queue[s];
        this.queue[s] = null;
        if (s != 0) {
            siftDown(0, x);
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public E removeAt(int i) {
        this.modCount++;
        int s = this.size - 1;
        this.size = s;
        if (s == i) {
            this.queue[i] = null;
        } else {
            E moved = this.queue[s];
            this.queue[s] = null;
            siftDown(i, moved);
            if (this.queue[i] == moved) {
                siftUp(i, moved);
                if (this.queue[i] != moved) {
                    return moved;
                }
            }
        }
        return null;
    }

    private void siftUp(int k, E x) {
        if (this.comparator != null) {
            siftUpUsingComparator(k, x);
        } else {
            siftUpComparable(k, x);
        }
    }

    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = this.queue[parent];
            if (key.compareTo(e) >= 0) {
                break;
            }
            this.queue[k] = e;
            k = parent;
        }
        this.queue[k] = key;
    }

    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = this.queue[parent];
            if (this.comparator.compare(x, e) >= 0) {
                break;
            }
            this.queue[k] = e;
            k = parent;
        }
        this.queue[k] = x;
    }

    private void siftDown(int k, E x) {
        if (this.comparator != null) {
            siftDownUsingComparator(k, x);
        } else {
            siftDownComparable(k, x);
        }
    }

    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = x;
        int half = this.size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = this.queue[child];
            int right = child + 1;
            if (right < this.size && ((Comparable) c).compareTo(this.queue[right]) > 0) {
                child = right;
                c = this.queue[right];
            }
            if (key.compareTo(c) <= 0) {
                break;
            }
            this.queue[k] = c;
            k = child;
        }
        this.queue[k] = key;
    }

    private void siftDownUsingComparator(int k, E x) {
        int half = this.size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = this.queue[child];
            int right = child + 1;
            if (right < this.size && this.comparator.compare(c, this.queue[right]) > 0) {
                child = right;
                c = this.queue[right];
            }
            if (this.comparator.compare(x, c) <= 0) {
                break;
            }
            this.queue[k] = c;
            k = child;
        }
        this.queue[k] = x;
    }

    private void heapify() {
        for (int i = (this.size >>> 1) - 1; i >= 0; i--) {
            siftDown(i, this.queue[i]);
        }
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(Math.max(2, this.size + 1));
        for (int i = 0; i < this.size; i++) {
            s.writeObject(this.queue[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        s.readInt();
        this.queue = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = s.readObject();
        }
        heapify();
    }

    public final Spliterator<E> spliterator() {
        return new PriorityQueueSpliterator(this, 0, -1, 0);
    }

    static final class PriorityQueueSpliterator<E> implements Spliterator<E> {
        private int expectedModCount;
        private int fence;
        private int index;
        private final PriorityQueue<E> pq;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.PriorityQueue.PriorityQueueSpliterator.<init>(java.util.PriorityQueue, int, int, int):void, dex: classes.dex
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
        PriorityQueueSpliterator(java.util.PriorityQueue<E> r1, int r2, int r3, int r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.PriorityQueue.PriorityQueueSpliterator.<init>(java.util.PriorityQueue, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PriorityQueue.PriorityQueueSpliterator.<init>(java.util.PriorityQueue, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        private int getFence() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.getFence():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PriorityQueue.PriorityQueueSpliterator.getFence():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PriorityQueue.PriorityQueueSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus element_width: 0139 in method: java.util.PriorityQueue.PriorityQueueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex in method: java.util.PriorityQueue.PriorityQueueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: bogus element_width: 0139 in method: java.util.PriorityQueue.PriorityQueueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: com.android.dex.DexException: bogus element_width: 0139
            	at com.android.dx.io.instructions.InstructionCodec$36.decode(InstructionCodec.java:871)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        public void forEachRemaining(java.util.function.Consumer<? super E> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus element_width: 0139 in method: java.util.PriorityQueue.PriorityQueueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex in method: java.util.PriorityQueue.PriorityQueueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PriorityQueue.PriorityQueueSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean tryAdvance(java.util.function.Consumer<? super E> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PriorityQueue.PriorityQueueSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.trySplit():java.util.PriorityQueue$PriorityQueueSpliterator<E>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.PriorityQueue.PriorityQueueSpliterator<E> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.PriorityQueue.PriorityQueueSpliterator.trySplit():java.util.PriorityQueue$PriorityQueueSpliterator<E>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PriorityQueue.PriorityQueueSpliterator.trySplit():java.util.PriorityQueue$PriorityQueueSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.PriorityQueue.PriorityQueueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.PriorityQueue.PriorityQueueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PriorityQueue.PriorityQueueSpliterator.trySplit():java.util.Spliterator");
        }

        public int characteristics() {
            return 16704;
        }
    }
}
