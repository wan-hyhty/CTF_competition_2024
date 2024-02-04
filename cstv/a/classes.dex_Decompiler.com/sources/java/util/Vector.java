package java.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final long serialVersionUID = -2767605614048989439L;
    protected int capacityIncrement;
    protected int elementCount;
    protected Object[] elementData;

    final class ListItr extends Vector<E>.Itr implements ListIterator<E> {
        final /* synthetic */ Vector this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Vector.ListItr.<init>(java.util.Vector, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        ListItr(java.util.Vector r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Vector.ListItr.<init>(java.util.Vector, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.ListItr.<init>(java.util.Vector, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.add(java.lang.Object):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void add(E r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.add(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.ListItr.add(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.hasPrevious():boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean hasPrevious() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.hasPrevious():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.ListItr.hasPrevious():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.nextIndex():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public int nextIndex() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.nextIndex():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.ListItr.nextIndex():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Vector.ListItr.previous():E, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public E previous() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Vector.ListItr.previous():E, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.ListItr.previous():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.previousIndex():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public int previousIndex() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.previousIndex():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.ListItr.previousIndex():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.set(java.lang.Object):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void set(E r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.ListItr.set(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.ListItr.set(java.lang.Object):void");
        }
    }

    public Vector(int initialCapacity, int capacityIncrement2) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement2;
    }

    public Vector(int initialCapacity) {
        this(initialCapacity, 0);
    }

    public Vector() {
        this(10);
    }

    public Vector(Collection<? extends E> c) {
        this.elementData = c.toArray();
        this.elementCount = this.elementData.length;
        if (this.elementData.getClass() != Object[].class) {
            this.elementData = Arrays.copyOf(this.elementData, this.elementCount, Object[].class);
        }
    }

    public synchronized void copyInto(Object[] anArray) {
        System.arraycopy((Object) this.elementData, 0, (Object) anArray, 0, this.elementCount);
    }

    public synchronized void trimToSize() {
        this.modCount++;
        if (this.elementCount < this.elementData.length) {
            this.elementData = Arrays.copyOf((T[]) this.elementData, this.elementCount);
        }
    }

    public synchronized void ensureCapacity(int minCapacity) {
        if (minCapacity > 0) {
            this.modCount++;
            ensureCapacityHelper(minCapacity);
        }
    }

    private void ensureCapacityHelper(int minCapacity) {
        if (minCapacity - this.elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int i;
        int oldCapacity = this.elementData.length;
        if (this.capacityIncrement > 0) {
            i = this.capacityIncrement;
        } else {
            i = oldCapacity;
        }
        int newCapacity = oldCapacity + i;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        this.elementData = Arrays.copyOf((T[]) this.elementData, newCapacity);
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

    public synchronized void setSize(int newSize) {
        this.modCount++;
        if (newSize > this.elementCount) {
            ensureCapacityHelper(newSize);
        } else {
            for (int i = newSize; i < this.elementCount; i++) {
                this.elementData[i] = null;
            }
        }
        this.elementCount = newSize;
    }

    public synchronized int capacity() {
        return this.elementData.length;
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public synchronized boolean isEmpty() {
        boolean z = false;
        synchronized (this) {
            if (this.elementCount == 0) {
                z = true;
            }
        }
        return z;
    }

    public Enumeration<E> elements() {
        return new Enumeration<E>() {
            int count = 0;

            public boolean hasMoreElements() {
                return this.count < Vector.this.elementCount;
            }

            public E nextElement() {
                synchronized (Vector.this) {
                    if (this.count < Vector.this.elementCount) {
                        Vector vector = Vector.this;
                        int i = this.count;
                        this.count = i + 1;
                        E elementData = vector.elementData(i);
                        return elementData;
                    }
                    throw new NoSuchElementException("Vector Enumeration");
                }
            }
        };
    }

    public boolean contains(Object o) {
        return indexOf(o, 0) >= 0;
    }

    public int indexOf(Object o) {
        return indexOf(o, 0);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:3:0x0004=Splitter:B:3:0x0004, B:12:0x0014=Splitter:B:12:0x0014} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int indexOf(java.lang.Object r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0013
            r0 = r4
        L_0x0004:
            int r1 = r2.elementCount     // Catch:{ all -> 0x002a }
            if (r0 >= r1) goto L_0x0027
            java.lang.Object[] r1 = r2.elementData     // Catch:{ all -> 0x002a }
            r1 = r1[r0]     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r2)
            return r0
        L_0x0010:
            int r0 = r0 + 1
            goto L_0x0004
        L_0x0013:
            r0 = r4
        L_0x0014:
            int r1 = r2.elementCount     // Catch:{ all -> 0x002a }
            if (r0 >= r1) goto L_0x0027
            java.lang.Object[] r1 = r2.elementData     // Catch:{ all -> 0x002a }
            r1 = r1[r0]     // Catch:{ all -> 0x002a }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0024
            monitor-exit(r2)
            return r0
        L_0x0024:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0027:
            r1 = -1
            monitor-exit(r2)
            return r1
        L_0x002a:
            r1 = move-exception
            monitor-exit(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.indexOf(java.lang.Object, int):int");
    }

    public synchronized int lastIndexOf(Object o) {
        return lastIndexOf(o, this.elementCount - 1);
    }

    public synchronized int lastIndexOf(Object o, int index) {
        if (index >= this.elementCount) {
            throw new IndexOutOfBoundsException(index + " >= " + this.elementCount);
        }
        if (o == null) {
            for (int i = index; i >= 0; i--) {
                if (this.elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i2 = index; i2 >= 0; i2--) {
                if (o.equals(this.elementData[i2])) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public synchronized E elementAt(int index) {
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + this.elementCount);
        }
        return elementData(index);
    }

    public synchronized E firstElement() {
        if (this.elementCount == 0) {
            throw new NoSuchElementException();
        }
        return elementData(0);
    }

    public synchronized E lastElement() {
        if (this.elementCount == 0) {
            throw new NoSuchElementException();
        }
        return elementData(this.elementCount - 1);
    }

    public synchronized void setElementAt(E obj, int index) {
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + this.elementCount);
        }
        this.elementData[index] = obj;
    }

    public synchronized void removeElementAt(int index) {
        this.modCount++;
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + this.elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            int j = (this.elementCount - index) - 1;
            if (j > 0) {
                System.arraycopy((Object) this.elementData, index + 1, (Object) this.elementData, index, j);
            }
            this.elementCount--;
            this.elementData[this.elementCount] = null;
        }
    }

    public synchronized void insertElementAt(E obj, int index) {
        this.modCount++;
        if (index > this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " > " + this.elementCount);
        }
        ensureCapacityHelper(this.elementCount + 1);
        System.arraycopy((Object) this.elementData, index, (Object) this.elementData, index + 1, this.elementCount - index);
        this.elementData[index] = obj;
        this.elementCount++;
    }

    public synchronized void addElement(E obj) {
        this.modCount++;
        ensureCapacityHelper(this.elementCount + 1);
        Object[] objArr = this.elementData;
        int i = this.elementCount;
        this.elementCount = i + 1;
        objArr[i] = obj;
    }

    public synchronized boolean removeElement(Object obj) {
        this.modCount++;
        int i = indexOf(obj);
        if (i < 0) {
            return false;
        }
        removeElementAt(i);
        return true;
    }

    public synchronized void removeAllElements() {
        this.modCount++;
        for (int i = 0; i < this.elementCount; i++) {
            this.elementData[i] = null;
        }
        this.elementCount = 0;
    }

    public synchronized Object clone() {
        Vector<E> v;
        try {
            v = (Vector) super.clone();
            v.elementData = Arrays.copyOf((T[]) this.elementData, this.elementCount);
            v.modCount = 0;
        } catch (CloneNotSupportedException e) {
            throw new InternalError((Throwable) e);
        }
        return v;
    }

    public synchronized Object[] toArray() {
        return Arrays.copyOf((T[]) this.elementData, this.elementCount);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T[] toArray(T[] r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r5.length     // Catch:{ all -> 0x0029 }
            int r1 = r4.elementCount     // Catch:{ all -> 0x0029 }
            if (r0 >= r1) goto L_0x0014
            java.lang.Object[] r0 = r4.elementData     // Catch:{ all -> 0x0029 }
            int r1 = r4.elementCount     // Catch:{ all -> 0x0029 }
            java.lang.Class r2 = r5.getClass()     // Catch:{ all -> 0x0029 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1, r2)     // Catch:{ all -> 0x0029 }
            monitor-exit(r4)
            return r0
        L_0x0014:
            java.lang.Object[] r0 = r4.elementData     // Catch:{ all -> 0x0029 }
            int r1 = r4.elementCount     // Catch:{ all -> 0x0029 }
            r2 = 0
            r3 = 0
            java.lang.System.arraycopy((java.lang.Object) r0, (int) r2, (java.lang.Object) r5, (int) r3, (int) r1)     // Catch:{ all -> 0x0029 }
            int r0 = r5.length     // Catch:{ all -> 0x0029 }
            int r1 = r4.elementCount     // Catch:{ all -> 0x0029 }
            if (r0 <= r1) goto L_0x0027
            int r0 = r4.elementCount     // Catch:{ all -> 0x0029 }
            r1 = 0
            r5[r0] = r1     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r4)
            return r5
        L_0x0029:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.toArray(java.lang.Object[]):java.lang.Object[]");
    }

    /* access modifiers changed from: package-private */
    public E elementData(int index) {
        return this.elementData[index];
    }

    public synchronized E get(int index) {
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return elementData(index);
    }

    public synchronized E set(int index, E element) {
        E oldValue;
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        oldValue = elementData(index);
        this.elementData[index] = element;
        return oldValue;
    }

    public synchronized boolean add(E e) {
        this.modCount++;
        ensureCapacityHelper(this.elementCount + 1);
        Object[] objArr = this.elementData;
        int i = this.elementCount;
        this.elementCount = i + 1;
        objArr[i] = e;
        return true;
    }

    public boolean remove(Object o) {
        return removeElement(o);
    }

    public void add(int index, E element) {
        insertElementAt(element, index);
    }

    public synchronized E remove(int index) {
        E oldValue;
        this.modCount++;
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        oldValue = elementData(index);
        int numMoved = (this.elementCount - index) - 1;
        if (numMoved > 0) {
            System.arraycopy((Object) this.elementData, index + 1, (Object) this.elementData, index, numMoved);
        }
        Object[] objArr = this.elementData;
        int i = this.elementCount - 1;
        this.elementCount = i;
        objArr[i] = null;
        return oldValue;
    }

    public void clear() {
        removeAllElements();
    }

    public synchronized boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    public synchronized boolean addAll(Collection<? extends E> c) {
        boolean z = false;
        synchronized (this) {
            this.modCount++;
            Object[] a = c.toArray();
            int numNew = a.length;
            ensureCapacityHelper(this.elementCount + numNew);
            System.arraycopy((Object) a, 0, (Object) this.elementData, this.elementCount, numNew);
            this.elementCount += numNew;
            if (numNew != 0) {
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    public synchronized boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    public synchronized boolean addAll(int index, Collection<? extends E> c) {
        boolean z = false;
        synchronized (this) {
            this.modCount++;
            if (index < 0 || index > this.elementCount) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            Object[] a = c.toArray();
            int numNew = a.length;
            ensureCapacityHelper(this.elementCount + numNew);
            int numMoved = this.elementCount - index;
            if (numMoved > 0) {
                System.arraycopy((Object) this.elementData, index, (Object) this.elementData, index + numNew, numMoved);
            }
            System.arraycopy((Object) a, 0, (Object) this.elementData, index, numNew);
            this.elementCount += numNew;
            if (numNew != 0) {
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean equals(Object o) {
        return super.equals(o);
    }

    public synchronized int hashCode() {
        return super.hashCode();
    }

    public synchronized String toString() {
        return super.toString();
    }

    public synchronized List<E> subList(int fromIndex, int toIndex) {
        return Collections.synchronizedList(super.subList(fromIndex, toIndex), this);
    }

    /* access modifiers changed from: protected */
    public synchronized void removeRange(int fromIndex, int toIndex) {
        this.modCount++;
        System.arraycopy((Object) this.elementData, toIndex, (Object) this.elementData, fromIndex, this.elementCount - toIndex);
        int newElementCount = this.elementCount - (toIndex - fromIndex);
        while (this.elementCount != newElementCount) {
            Object[] objArr = this.elementData;
            int i = this.elementCount - 1;
            this.elementCount = i;
            objArr[i] = null;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        Object[] data;
        ObjectOutputStream.PutField fields = s.putFields();
        synchronized (this) {
            fields.put("capacityIncrement", this.capacityIncrement);
            fields.put("elementCount", this.elementCount);
            data = (Object[]) this.elementData.clone();
        }
        fields.put("elementData", (Object) data);
        s.writeFields();
    }

    public synchronized ListIterator<E> listIterator(int index) {
        if (index >= 0) {
            if (index <= this.elementCount) {
            }
        }
        throw new IndexOutOfBoundsException("Index: " + index);
        return new ListItr(this, index);
    }

    public synchronized ListIterator<E> listIterator() {
        return new ListItr(this, 0);
    }

    public synchronized Iterator<E> iterator() {
        return new Itr(this, (Itr) null);
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;
        protected int limit;

        /* synthetic */ Itr(Vector this$02, Itr itr) {
            this();
        }

        private Itr() {
            this.limit = Vector.this.elementCount;
            this.lastRet = -1;
            this.expectedModCount = Vector.this.modCount;
        }

        public boolean hasNext() {
            return this.cursor < this.limit;
        }

        public E next() {
            E elementData;
            synchronized (Vector.this) {
                checkForComodification();
                int i = this.cursor;
                if (i >= this.limit) {
                    throw new NoSuchElementException();
                }
                this.cursor = i + 1;
                Vector vector = Vector.this;
                this.lastRet = i;
                elementData = vector.elementData(i);
            }
            return elementData;
        }

        public void remove() {
            if (this.lastRet == -1) {
                throw new IllegalStateException();
            }
            synchronized (Vector.this) {
                checkForComodification();
                Vector.this.remove(this.lastRet);
                this.expectedModCount = Vector.this.modCount;
                this.limit--;
            }
            this.cursor = this.lastRet;
            this.lastRet = -1;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            int i;
            Objects.requireNonNull(action);
            synchronized (Vector.this) {
                int size = this.limit;
                int i2 = this.cursor;
                if (i2 < size) {
                    E[] elementData = Vector.this.elementData;
                    if (i2 >= elementData.length) {
                        throw new ConcurrentModificationException();
                    }
                    while (true) {
                        i = i2;
                        if (i != size) {
                            if (Vector.this.modCount != this.expectedModCount) {
                                break;
                            }
                            i2 = i + 1;
                            action.accept(elementData[i]);
                        } else {
                            break;
                        }
                    }
                    this.cursor = i;
                    this.lastRet = i - 1;
                    checkForComodification();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void checkForComodification() {
            if (Vector.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public synchronized void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        int expectedModCount = this.modCount;
        E[] elementData2 = this.elementData;
        int elementCount2 = this.elementCount;
        int i = 0;
        while (this.modCount == expectedModCount && i < elementCount2) {
            action.accept(elementData2[i]);
            i++;
        }
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public Spliterator<E> spliterator() {
        return new VectorSpliterator(this, (Object[]) null, 0, -1, 0);
    }

    static final class VectorSpliterator<E> implements Spliterator<E> {
        private Object[] array;
        private int expectedModCount;
        private int fence;
        private int index;
        private final Vector<E> list;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Vector.VectorSpliterator.<init>(java.util.Vector, java.lang.Object[], int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        VectorSpliterator(java.util.Vector<E> r1, java.lang.Object[] r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Vector.VectorSpliterator.<init>(java.util.Vector, java.lang.Object[], int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.VectorSpliterator.<init>(java.util.Vector, java.lang.Object[], int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.VectorSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private int getFence() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.VectorSpliterator.getFence():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.VectorSpliterator.getFence():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.Vector.VectorSpliterator.estimateSize():long, dex: classes.dex in method: java.util.Vector.VectorSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.Vector.VectorSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.Vector.VectorSpliterator.estimateSize():long, dex: classes.dex in method: java.util.Vector.VectorSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.VectorSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Vector.VectorSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public void forEachRemaining(java.util.function.Consumer<? super E> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Vector.VectorSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.VectorSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.VectorSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean tryAdvance(java.util.function.Consumer<? super E> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.VectorSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.VectorSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.VectorSpliterator.trySplit():java.util.Spliterator<E>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public java.util.Spliterator<E> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.Vector.VectorSpliterator.trySplit():java.util.Spliterator<E>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Vector.VectorSpliterator.trySplit():java.util.Spliterator");
        }

        public int characteristics() {
            return 16464;
        }
    }

    public synchronized boolean removeIf(Predicate<? super E> filter) {
        boolean anyToRemove = false;
        synchronized (this) {
            Objects.requireNonNull(filter);
            int removeCount = 0;
            int size = this.elementCount;
            BitSet removeSet = new BitSet(size);
            int expectedModCount = this.modCount;
            int i = 0;
            while (this.modCount == expectedModCount && i < size) {
                if (filter.test(this.elementData[i])) {
                    removeSet.set(i);
                    removeCount++;
                }
                i++;
            }
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (removeCount > 0) {
                anyToRemove = true;
            }
            if (anyToRemove) {
                int newSize = size - removeCount;
                int i2 = 0;
                int j = 0;
                while (i2 < size && j < newSize) {
                    int i3 = removeSet.nextClearBit(i2);
                    this.elementData[j] = this.elementData[i3];
                    i2 = i3 + 1;
                    j++;
                }
                for (int k = newSize; k < size; k++) {
                    this.elementData[k] = null;
                }
                this.elementCount = newSize;
                if (this.modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                this.modCount++;
            }
        }
        return anyToRemove;
    }

    public synchronized void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        int expectedModCount = this.modCount;
        int size = this.elementCount;
        int i = 0;
        while (this.modCount == expectedModCount && i < size) {
            this.elementData[i] = operator.apply(this.elementData[i]);
            i++;
        }
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.modCount++;
    }

    public synchronized void sort(Comparator<? super E> c) {
        int expectedModCount = this.modCount;
        Arrays.sort(this.elementData, 0, this.elementCount, c);
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.modCount++;
    }
}
