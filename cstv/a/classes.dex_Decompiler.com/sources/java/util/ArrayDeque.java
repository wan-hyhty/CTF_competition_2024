package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Consumer;

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
public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f33assertionsDisabled = false;
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
    transient Object[] elements;
    transient int head;
    transient int tail;

    private class DescendingIterator implements Iterator<E> {
        private int cursor;
        private int fence;
        private int lastRet;
        final /* synthetic */ ArrayDeque this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.ArrayDeque.DescendingIterator.<init>(java.util.ArrayDeque):void, dex: classes.dex in method: java.util.ArrayDeque.DescendingIterator.<init>(java.util.ArrayDeque):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.ArrayDeque.DescendingIterator.<init>(java.util.ArrayDeque):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        private DescendingIterator(java.util.ArrayDeque r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.ArrayDeque.DescendingIterator.<init>(java.util.ArrayDeque):void, dex: classes.dex in method: java.util.ArrayDeque.DescendingIterator.<init>(java.util.ArrayDeque):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DescendingIterator.<init>(java.util.ArrayDeque):void");
        }

        /* synthetic */ DescendingIterator(ArrayDeque this$02, DescendingIterator descendingIterator) {
            this(this$02);
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DescendingIterator.hasNext():boolean, dex: classes.dex
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
        public boolean hasNext() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DescendingIterator.hasNext():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DescendingIterator.hasNext():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.ArrayDeque.DescendingIterator.next():E, dex: classes.dex in method: java.util.ArrayDeque.DescendingIterator.next():E, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.ArrayDeque.DescendingIterator.next():E, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        public E next() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.ArrayDeque.DescendingIterator.next():E, dex: classes.dex in method: java.util.ArrayDeque.DescendingIterator.next():E, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DescendingIterator.next():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.ArrayDeque.DescendingIterator.remove():void, dex: classes.dex in method: java.util.ArrayDeque.DescendingIterator.remove():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.ArrayDeque.DescendingIterator.remove():void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        public void remove() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.ArrayDeque.DescendingIterator.remove():void, dex: classes.dex in method: java.util.ArrayDeque.DescendingIterator.remove():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DescendingIterator.remove():void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.ArrayDeque.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.ArrayDeque.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.<clinit>():void");
    }

    private void allocateElements(int numElements) {
        int initialCapacity = 8;
        if (numElements >= 8) {
            int initialCapacity2 = numElements;
            int initialCapacity3 = numElements | (numElements >>> 1);
            int initialCapacity4 = initialCapacity3 | (initialCapacity3 >>> 2);
            int initialCapacity5 = initialCapacity4 | (initialCapacity4 >>> 4);
            int initialCapacity6 = initialCapacity5 | (initialCapacity5 >>> 8);
            initialCapacity = (initialCapacity6 | (initialCapacity6 >>> 16)) + 1;
            if (initialCapacity < 0) {
                initialCapacity >>>= 1;
            }
        }
        this.elements = new Object[initialCapacity];
    }

    private void doubleCapacity() {
        if (!f33assertionsDisabled) {
            if (!(this.head == this.tail)) {
                throw new AssertionError();
            }
        }
        int p = this.head;
        int n = this.elements.length;
        int r = n - p;
        int newCapacity = n << 1;
        if (newCapacity < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] a = new Object[newCapacity];
        System.arraycopy((Object) this.elements, p, (Object) a, 0, r);
        System.arraycopy((Object) this.elements, 0, (Object) a, r, p);
        this.elements = a;
        this.head = 0;
        this.tail = n;
    }

    public ArrayDeque() {
        this.elements = new Object[16];
    }

    public ArrayDeque(int numElements) {
        allocateElements(numElements);
    }

    public ArrayDeque(Collection<? extends E> c) {
        allocateElements(c.size());
        addAll(c);
    }

    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Object[] objArr = this.elements;
        int length = (this.head - 1) & (this.elements.length - 1);
        this.head = length;
        objArr[length] = e;
        if (this.head == this.tail) {
            doubleCapacity();
        }
    }

    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        this.elements[this.tail] = e;
        int length = (this.tail + 1) & (this.elements.length - 1);
        this.tail = length;
        if (length == this.head) {
            doubleCapacity();
        }
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E removeFirst() {
        E x = pollFirst();
        if (x != null) {
            return x;
        }
        throw new NoSuchElementException();
    }

    public E removeLast() {
        E x = pollLast();
        if (x != null) {
            return x;
        }
        throw new NoSuchElementException();
    }

    public E pollFirst() {
        E[] elements2 = this.elements;
        int h = this.head;
        E result = elements2[h];
        if (result != null) {
            elements2[h] = null;
            this.head = (h + 1) & (elements2.length - 1);
        }
        return result;
    }

    public E pollLast() {
        E[] elements2 = this.elements;
        int t = (this.tail - 1) & (elements2.length - 1);
        E result = elements2[t];
        if (result != null) {
            elements2[t] = null;
            this.tail = t;
        }
        return result;
    }

    public E getFirst() {
        E result = this.elements[this.head];
        if (result != null) {
            return result;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E result = this.elements[(this.tail - 1) & (this.elements.length - 1)];
        if (result != null) {
            return result;
        }
        throw new NoSuchElementException();
    }

    public E peekFirst() {
        return this.elements[this.head];
    }

    public E peekLast() {
        return this.elements[(this.tail - 1) & (this.elements.length - 1)];
    }

    public boolean removeFirstOccurrence(Object o) {
        if (o == null) {
            return f33assertionsDisabled;
        }
        int mask = this.elements.length - 1;
        int i = this.head;
        while (true) {
            Object x = this.elements[i];
            if (x == null) {
                return f33assertionsDisabled;
            }
            if (o.equals(x)) {
                delete(i);
                return true;
            }
            i = (i + 1) & mask;
        }
    }

    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            return f33assertionsDisabled;
        }
        int mask = this.elements.length - 1;
        int i = this.tail - 1;
        while (true) {
            int i2 = i & mask;
            Object x = this.elements[i2];
            if (x == null) {
                return f33assertionsDisabled;
            }
            if (o.equals(x)) {
                delete(i2);
                return true;
            }
            i = i2 - 1;
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public E remove() {
        return removeFirst();
    }

    public E poll() {
        return pollFirst();
    }

    public E element() {
        return getFirst();
    }

    public E peek() {
        return peekFirst();
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    private void checkInvariants() {
        boolean z;
        boolean z2 = true;
        if (!f33assertionsDisabled) {
            if (!(this.elements[this.tail] == null)) {
                throw new AssertionError();
            }
        }
        if (!f33assertionsDisabled) {
            if (this.head == this.tail) {
                z = this.elements[this.head] == null;
            } else {
                z = this.elements[this.head] != null ? this.elements[(this.tail + -1) & (this.elements.length + -1)] != null : false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (!f33assertionsDisabled) {
            if (this.elements[(this.head - 1) & (this.elements.length - 1)] != null) {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean delete(int i) {
        checkInvariants();
        Object[] elements2 = this.elements;
        int mask = elements2.length - 1;
        int h = this.head;
        int t = this.tail;
        int front = (i - h) & mask;
        int back = (t - i) & mask;
        if (front >= ((t - h) & mask)) {
            throw new ConcurrentModificationException();
        } else if (front < back) {
            if (h <= i) {
                System.arraycopy((Object) elements2, h, (Object) elements2, h + 1, front);
            } else {
                System.arraycopy((Object) elements2, 0, (Object) elements2, 1, i);
                elements2[0] = elements2[mask];
                System.arraycopy((Object) elements2, h, (Object) elements2, h + 1, mask - h);
            }
            elements2[h] = null;
            this.head = (h + 1) & mask;
            return f33assertionsDisabled;
        } else {
            if (i < t) {
                System.arraycopy((Object) elements2, i + 1, (Object) elements2, i, back);
                this.tail = t - 1;
            } else {
                System.arraycopy((Object) elements2, i + 1, (Object) elements2, i, mask - i);
                elements2[mask] = elements2[0];
                System.arraycopy((Object) elements2, 1, (Object) elements2, 0, t);
                this.tail = (t - 1) & mask;
            }
            return true;
        }
    }

    public int size() {
        return (this.tail - this.head) & (this.elements.length - 1);
    }

    public boolean isEmpty() {
        if (this.head == this.tail) {
            return true;
        }
        return f33assertionsDisabled;
    }

    public Iterator<E> iterator() {
        return new DeqIterator(this, (DeqIterator) null);
    }

    public Iterator<E> descendingIterator() {
        return new DescendingIterator(this, (DescendingIterator) null);
    }

    private class DeqIterator implements Iterator<E> {
        private int cursor;
        private int fence;
        private int lastRet;

        /* synthetic */ DeqIterator(ArrayDeque this$02, DeqIterator deqIterator) {
            this();
        }

        private DeqIterator() {
            this.cursor = ArrayDeque.this.head;
            this.fence = ArrayDeque.this.tail;
            this.lastRet = -1;
        }

        public boolean hasNext() {
            if (this.cursor != this.fence) {
                return true;
            }
            return ArrayDeque.f33assertionsDisabled;
        }

        public E next() {
            if (this.cursor == this.fence) {
                throw new NoSuchElementException();
            }
            E result = ArrayDeque.this.elements[this.cursor];
            if (ArrayDeque.this.tail != this.fence || result == null) {
                throw new ConcurrentModificationException();
            }
            this.lastRet = this.cursor;
            this.cursor = (this.cursor + 1) & (ArrayDeque.this.elements.length - 1);
            return result;
        }

        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            if (ArrayDeque.this.delete(this.lastRet)) {
                this.cursor = (this.cursor - 1) & (ArrayDeque.this.elements.length - 1);
                this.fence = ArrayDeque.this.tail;
            }
            this.lastRet = -1;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            E[] a = ArrayDeque.this.elements;
            int m = a.length - 1;
            int f = this.fence;
            int i = this.cursor;
            this.cursor = f;
            while (i != f) {
                E e = a[i];
                i = (i + 1) & m;
                if (e == null) {
                    throw new ConcurrentModificationException();
                }
                action.accept(e);
            }
        }
    }

    public boolean contains(Object o) {
        if (o == null) {
            return f33assertionsDisabled;
        }
        int mask = this.elements.length - 1;
        int i = this.head;
        while (true) {
            Object x = this.elements[i];
            if (x == null) {
                return f33assertionsDisabled;
            }
            if (o.equals(x)) {
                return true;
            }
            i = (i + 1) & mask;
        }
    }

    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    public void clear() {
        int h = this.head;
        int t = this.tail;
        if (h != t) {
            this.tail = 0;
            this.head = 0;
            int i = h;
            int mask = this.elements.length - 1;
            do {
                this.elements[i] = null;
                i = (i + 1) & mask;
            } while (i != t);
        }
    }

    public Object[] toArray() {
        boolean wrap;
        int head2 = this.head;
        int tail2 = this.tail;
        if (tail2 < head2) {
            wrap = true;
        } else {
            wrap = false;
        }
        Object[] a = Arrays.copyOfRange((T[]) this.elements, head2, wrap ? tail2 + this.elements.length : tail2);
        if (wrap) {
            System.arraycopy((Object) this.elements, 0, (Object) a, this.elements.length - head2, tail2);
        }
        return a;
    }

    public <T> T[] toArray(T[] a) {
        boolean wrap;
        int i;
        int i2;
        int head2 = this.head;
        int tail2 = this.tail;
        if (tail2 < head2) {
            wrap = true;
        } else {
            wrap = false;
        }
        int i3 = tail2 - head2;
        if (wrap) {
            i = this.elements.length;
        } else {
            i = 0;
        }
        int size = i3 + i;
        if (wrap) {
            i2 = tail2;
        } else {
            i2 = 0;
        }
        int firstLeg = size - i2;
        int len = a.length;
        if (size > len) {
            a = Arrays.copyOfRange(this.elements, head2, head2 + size, a.getClass());
        } else {
            System.arraycopy((Object) this.elements, head2, (Object) a, 0, firstLeg);
            if (size < len) {
                a[size] = null;
            }
        }
        if (wrap) {
            System.arraycopy((Object) this.elements, 0, (Object) a, firstLeg, tail2);
        }
        return a;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public ArrayDeque<E> clone() {
        try {
            ArrayDeque<E> result = (ArrayDeque) super.clone();
            result.elements = Arrays.copyOf((T[]) this.elements, this.elements.length);
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size());
        int mask = this.elements.length - 1;
        for (int i = this.head; i != this.tail; i = (i + 1) & mask) {
            s.writeObject(this.elements[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        allocateElements(size);
        this.head = 0;
        this.tail = size;
        for (int i = 0; i < size; i++) {
            this.elements[i] = s.readObject();
        }
    }

    public Spliterator<E> spliterator() {
        return new DeqSpliterator(this, -1, -1);
    }

    static final class DeqSpliterator<E> implements Spliterator<E> {
        private final ArrayDeque<E> deq;
        private int fence;
        private int index;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayDeque.DeqSpliterator.<init>(java.util.ArrayDeque, int, int):void, dex: classes.dex
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
        DeqSpliterator(java.util.ArrayDeque<E> r1, int r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayDeque.DeqSpliterator.<init>(java.util.ArrayDeque, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DeqSpliterator.<init>(java.util.ArrayDeque, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DeqSpliterator.getFence():int, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DeqSpliterator.getFence():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DeqSpliterator.getFence():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DeqSpliterator.estimateSize():long, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DeqSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DeqSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayDeque.DeqSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void forEachRemaining(java.util.function.Consumer<? super E> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayDeque.DeqSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DeqSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayDeque.DeqSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean tryAdvance(java.util.function.Consumer<? super E> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayDeque.DeqSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DeqSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DeqSpliterator.trySplit():java.util.ArrayDeque$DeqSpliterator<E>, dex: classes.dex
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
        public java.util.ArrayDeque.DeqSpliterator<E> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.ArrayDeque.DeqSpliterator.trySplit():java.util.ArrayDeque$DeqSpliterator<E>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DeqSpliterator.trySplit():java.util.ArrayDeque$DeqSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.ArrayDeque.DeqSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.ArrayDeque.DeqSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.DeqSpliterator.trySplit():java.util.Spliterator");
        }

        public int characteristics() {
            return 16720;
        }
    }
}
