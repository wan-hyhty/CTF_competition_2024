package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = null;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final long serialVersionUID = 8683452581122892189L;
    transient Object[] elementData;
    /* access modifiers changed from: private */
    public int size;

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
    }

    public ArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public ArrayList(Collection<? extends E> c) {
        this.elementData = c.toArray();
        this.size = this.elementData.length;
        if (this.elementData.getClass() != Object[].class) {
            this.elementData = Arrays.copyOf(this.elementData, this.size, Object[].class);
        }
    }

    public void trimToSize() {
        this.modCount++;
        if (this.size < this.elementData.length) {
            this.elementData = Arrays.copyOf((T[]) this.elementData, this.size);
        }
    }

    public void ensureCapacity(int minCapacity) {
        int minExpand;
        if (this.elementData != EMPTY_ELEMENTDATA) {
            minExpand = 0;
        } else {
            minExpand = 10;
        }
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (this.elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(10, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        this.modCount++;
        if (minCapacity - this.elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
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

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elementData[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = 0; i2 < this.size; i2++) {
            if (o.equals(this.elementData[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = this.size - 1; i >= 0; i--) {
                if (this.elementData[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            if (o.equals(this.elementData[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public Object clone() {
        try {
            ArrayList<?> v = (ArrayList) super.clone();
            v.elementData = Arrays.copyOf((T[]) this.elementData, this.size);
            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            throw new InternalError((Throwable) e);
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf((T[]) this.elementData, this.size);
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < this.size) {
            return Arrays.copyOf(this.elementData, this.size, a.getClass());
        }
        System.arraycopy((Object) this.elementData, 0, (Object) a, 0, this.size);
        if (a.length > this.size) {
            a[this.size] = null;
        }
        return a;
    }

    public E get(int index) {
        if (index < this.size) {
            return this.elementData[index];
        }
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    public E set(int index, E element) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        E oldValue = this.elementData[index];
        this.elementData[index] = element;
        return oldValue;
    }

    public boolean add(E e) {
        ensureCapacityInternal(this.size + 1);
        Object[] objArr = this.elementData;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return true;
    }

    public void add(int index, E element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        ensureCapacityInternal(this.size + 1);
        System.arraycopy((Object) this.elementData, index, (Object) this.elementData, index + 1, this.size - index);
        this.elementData[index] = element;
        this.size++;
    }

    public E remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        this.modCount++;
        E oldValue = this.elementData[index];
        int numMoved = (this.size - index) - 1;
        if (numMoved > 0) {
            System.arraycopy((Object) this.elementData, index + 1, (Object) this.elementData, index, numMoved);
        }
        Object[] objArr = this.elementData;
        int i = this.size - 1;
        this.size = i;
        objArr[i] = null;
        return oldValue;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < this.size; index++) {
                if (this.elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
            return false;
        }
        for (int index2 = 0; index2 < this.size; index2++) {
            if (o.equals(this.elementData[index2])) {
                fastRemove(index2);
                return true;
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        this.modCount++;
        int numMoved = (this.size - index) - 1;
        if (numMoved > 0) {
            System.arraycopy((Object) this.elementData, index + 1, (Object) this.elementData, index, numMoved);
        }
        Object[] objArr = this.elementData;
        int i = this.size - 1;
        this.size = i;
        objArr[i] = null;
    }

    public void clear() {
        this.modCount++;
        for (int i = 0; i < this.size; i++) {
            this.elementData[i] = null;
        }
        this.size = 0;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(this.size + numNew);
        System.arraycopy((Object) a, 0, (Object) this.elementData, this.size, numNew);
        this.size += numNew;
        if (numNew != 0) {
            return true;
        }
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(this.size + numNew);
        int numMoved = this.size - index;
        if (numMoved > 0) {
            System.arraycopy((Object) this.elementData, index, (Object) this.elementData, index + numNew, numMoved);
        }
        System.arraycopy((Object) a, 0, (Object) this.elementData, index, numNew);
        this.size += numNew;
        if (numNew != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int fromIndex, int toIndex) {
        if (toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        this.modCount++;
        System.arraycopy((Object) this.elementData, toIndex, (Object) this.elementData, fromIndex, this.size - toIndex);
        int newSize = this.size - (toIndex - fromIndex);
        for (int i = newSize; i < this.size; i++) {
            this.elementData[i] = null;
        }
        this.size = newSize;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    public boolean removeAll(Collection<?> c) {
        return batchRemove(c, false);
    }

    public boolean retainAll(Collection<?> c) {
        return batchRemove(c, true);
    }

    private boolean batchRemove(Collection<?> c, boolean complement) {
        int w;
        int w2;
        Object[] elementData2 = this.elementData;
        int r = 0;
        int w3 = 0;
        while (true) {
            try {
                w = w3;
                if (r >= this.size) {
                    break;
                }
                if (c.contains(elementData2[r]) == complement) {
                    w3 = w + 1;
                    try {
                        elementData2[w] = elementData2[r];
                    } catch (Throwable th) {
                        th = th;
                    }
                } else {
                    w3 = w;
                }
                r++;
            } catch (Throwable th2) {
                th = th2;
                w3 = w;
                if (r != this.size) {
                    System.arraycopy((Object) elementData2, r, (Object) elementData2, w3, this.size - r);
                    w3 += this.size - r;
                }
                if (w3 != this.size) {
                    for (int i = w3; i < this.size; i++) {
                        elementData2[i] = null;
                    }
                    this.modCount += this.size - w3;
                    this.size = w3;
                }
                throw th;
            }
        }
        if (r != this.size) {
            System.arraycopy((Object) elementData2, r, (Object) elementData2, w, this.size - r);
            w2 = w + (this.size - r);
        } else {
            w2 = w;
        }
        if (w2 == this.size) {
            return false;
        }
        for (int i2 = w2; i2 < this.size; i2++) {
            elementData2[i2] = null;
        }
        this.modCount += this.size - w2;
        this.size = w2;
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        int expectedModCount = this.modCount;
        s.defaultWriteObject();
        s.writeInt(this.size);
        for (int i = 0; i < this.size; i++) {
            s.writeObject(this.elementData[i]);
        }
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        this.elementData = EMPTY_ELEMENTDATA;
        s.defaultReadObject();
        s.readInt();
        if (this.size > 0) {
            ensureCapacityInternal(this.size);
            Object[] a = this.elementData;
            for (int i = 0; i < this.size; i++) {
                a[i] = s.readObject();
            }
        }
    }

    public ListIterator<E> listIterator(int index) {
        if (index >= 0 && index <= this.size) {
            return new ListItr(index);
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    public Iterator<E> iterator() {
        return new Itr(this, (Itr) null);
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;
        protected int limit;

        /* synthetic */ Itr(ArrayList this$02, Itr itr) {
            this();
        }

        private Itr() {
            this.limit = ArrayList.this.size;
            this.lastRet = -1;
            this.expectedModCount = ArrayList.this.modCount;
        }

        public boolean hasNext() {
            return this.cursor < this.limit;
        }

        public E next() {
            if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            int i = this.cursor;
            if (i >= this.limit) {
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            this.cursor = i + 1;
            this.lastRet = i;
            return elementData[i];
        }

        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            } else if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                try {
                    ArrayList.this.remove(this.lastRet);
                    this.cursor = this.lastRet;
                    this.lastRet = -1;
                    this.expectedModCount = ArrayList.this.modCount;
                    this.limit--;
                } catch (IndexOutOfBoundsException e) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        public void forEachRemaining(Consumer<? super E> consumer) {
            int i;
            Objects.requireNonNull(consumer);
            int size = ArrayList.this.size;
            int i2 = this.cursor;
            if (i2 < size) {
                Object[] elementData = ArrayList.this.elementData;
                if (i2 >= elementData.length) {
                    throw new ConcurrentModificationException();
                }
                while (true) {
                    i = i2;
                    if (i == size || ArrayList.this.modCount != this.expectedModCount) {
                        this.cursor = i;
                        this.lastRet = i - 1;
                    } else {
                        i2 = i + 1;
                        consumer.accept(elementData[i]);
                    }
                }
                this.cursor = i;
                this.lastRet = i - 1;
                if (ArrayList.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    private class ListItr extends ArrayList<E>.Itr implements ListIterator<E> {
        ListItr(int index) {
            super(ArrayList.this, (Itr) null);
            this.cursor = index;
        }

        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        public int nextIndex() {
            return this.cursor;
        }

        public int previousIndex() {
            return this.cursor - 1;
        }

        public E previous() {
            if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            int i = this.cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            this.cursor = i;
            this.lastRet = i;
            return elementData[i];
        }

        public void set(E e) {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            } else if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                try {
                    ArrayList.this.set(this.lastRet, e);
                } catch (IndexOutOfBoundsException e2) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        public void add(E e) {
            if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            try {
                int i = this.cursor;
                ArrayList.this.add(i, e);
                this.cursor = i + 1;
                this.lastRet = -1;
                this.expectedModCount = ArrayList.this.modCount;
                this.limit++;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, this.size);
        return new SubList(this, 0, fromIndex, toIndex);
    }

    static void subListRangeCheck(int fromIndex, int toIndex, int size2) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        } else if (toIndex > size2) {
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        } else if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
    }

    private class SubList extends AbstractList<E> implements RandomAccess {
        private final int offset;
        private final AbstractList<E> parent;
        private final int parentOffset;
        int size;

        SubList(AbstractList<E> parent2, int offset2, int fromIndex, int toIndex) {
            this.parent = parent2;
            this.parentOffset = fromIndex;
            this.offset = offset2 + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = ArrayList.this.modCount;
        }

        public E set(int index, E e) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            } else if (ArrayList.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            } else {
                E oldValue = ArrayList.this.elementData[this.offset + index];
                ArrayList.this.elementData[this.offset + index] = e;
                return oldValue;
            }
        }

        public E get(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            } else if (ArrayList.this.modCount == this.modCount) {
                return ArrayList.this.elementData[this.offset + index];
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public int size() {
            if (ArrayList.this.modCount == this.modCount) {
                return this.size;
            }
            throw new ConcurrentModificationException();
        }

        public void add(int index, E e) {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            } else if (ArrayList.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            } else {
                this.parent.add(this.parentOffset + index, e);
                this.modCount = this.parent.modCount;
                this.size++;
            }
        }

        public E remove(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            } else if (ArrayList.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            } else {
                E result = this.parent.remove(this.parentOffset + index);
                this.modCount = this.parent.modCount;
                this.size--;
                return result;
            }
        }

        /* access modifiers changed from: protected */
        public void removeRange(int fromIndex, int toIndex) {
            if (ArrayList.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
            this.parent.removeRange(this.parentOffset + fromIndex, this.parentOffset + toIndex);
            this.modCount = this.parent.modCount;
            this.size -= toIndex - fromIndex;
        }

        public boolean addAll(Collection<? extends E> c) {
            return addAll(this.size, c);
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            }
            int cSize = c.size();
            if (cSize == 0) {
                return false;
            }
            if (ArrayList.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
            this.parent.addAll(this.parentOffset + index, c);
            this.modCount = this.parent.modCount;
            this.size += cSize;
            return true;
        }

        public Iterator<E> iterator() {
            return listIterator();
        }

        public ListIterator<E> listIterator(final int index) {
            if (ArrayList.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            } else if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            } else {
                final int offset2 = this.offset;
                return new ListIterator<E>() {
                    int cursor = index;
                    int expectedModCount = ArrayList.this.modCount;
                    int lastRet = -1;

                    public boolean hasNext() {
                        return this.cursor != SubList.this.size;
                    }

                    public E next() {
                        if (this.expectedModCount != ArrayList.this.modCount) {
                            throw new ConcurrentModificationException();
                        }
                        int i = this.cursor;
                        if (i >= SubList.this.size) {
                            throw new NoSuchElementException();
                        }
                        Object[] elementData = ArrayList.this.elementData;
                        if (offset2 + i >= elementData.length) {
                            throw new ConcurrentModificationException();
                        }
                        this.cursor = i + 1;
                        int i2 = offset2;
                        this.lastRet = i;
                        return elementData[i2 + i];
                    }

                    public boolean hasPrevious() {
                        return this.cursor != 0;
                    }

                    public E previous() {
                        if (this.expectedModCount != ArrayList.this.modCount) {
                            throw new ConcurrentModificationException();
                        }
                        int i = this.cursor - 1;
                        if (i < 0) {
                            throw new NoSuchElementException();
                        }
                        Object[] elementData = ArrayList.this.elementData;
                        if (offset2 + i >= elementData.length) {
                            throw new ConcurrentModificationException();
                        }
                        this.cursor = i;
                        int i2 = offset2;
                        this.lastRet = i;
                        return elementData[i2 + i];
                    }

                    public void forEachRemaining(Consumer<? super E> consumer) {
                        int i;
                        Objects.requireNonNull(consumer);
                        int size = SubList.this.size;
                        int i2 = this.cursor;
                        if (i2 < size) {
                            Object[] elementData = ArrayList.this.elementData;
                            if (offset2 + i2 >= elementData.length) {
                                throw new ConcurrentModificationException();
                            }
                            while (true) {
                                i = i2;
                                if (i == size || SubList.this.modCount != this.expectedModCount) {
                                    this.cursor = i;
                                    this.lastRet = i;
                                } else {
                                    i2 = i + 1;
                                    consumer.accept(elementData[offset2 + i]);
                                }
                            }
                            this.cursor = i;
                            this.lastRet = i;
                            if (this.expectedModCount != ArrayList.this.modCount) {
                                throw new ConcurrentModificationException();
                            }
                        }
                    }

                    public int nextIndex() {
                        return this.cursor;
                    }

                    public int previousIndex() {
                        return this.cursor - 1;
                    }

                    public void remove() {
                        if (this.lastRet < 0) {
                            throw new IllegalStateException();
                        } else if (this.expectedModCount != ArrayList.this.modCount) {
                            throw new ConcurrentModificationException();
                        } else {
                            try {
                                SubList.this.remove(this.lastRet);
                                this.cursor = this.lastRet;
                                this.lastRet = -1;
                                this.expectedModCount = ArrayList.this.modCount;
                            } catch (IndexOutOfBoundsException e) {
                                throw new ConcurrentModificationException();
                            }
                        }
                    }

                    public void set(E e) {
                        if (this.lastRet < 0) {
                            throw new IllegalStateException();
                        } else if (this.expectedModCount != ArrayList.this.modCount) {
                            throw new ConcurrentModificationException();
                        } else {
                            try {
                                ArrayList.this.set(offset2 + this.lastRet, e);
                            } catch (IndexOutOfBoundsException e2) {
                                throw new ConcurrentModificationException();
                            }
                        }
                    }

                    public void add(E e) {
                        if (this.expectedModCount != ArrayList.this.modCount) {
                            throw new ConcurrentModificationException();
                        }
                        try {
                            int i = this.cursor;
                            SubList.this.add(i, e);
                            this.cursor = i + 1;
                            this.lastRet = -1;
                            this.expectedModCount = ArrayList.this.modCount;
                        } catch (IndexOutOfBoundsException e2) {
                            throw new ConcurrentModificationException();
                        }
                    }
                };
            }
        }

        public List<E> subList(int fromIndex, int toIndex) {
            ArrayList.subListRangeCheck(fromIndex, toIndex, this.size);
            return new SubList(this, this.offset, fromIndex, toIndex);
        }

        private String outOfBoundsMsg(int index) {
            return "Index: " + index + ", Size: " + this.size;
        }

        public Spliterator<E> spliterator() {
            if (this.modCount == ArrayList.this.modCount) {
                return new ArrayListSpliterator(ArrayList.this, this.offset, this.offset + this.size, this.modCount);
            }
            throw new ConcurrentModificationException();
        }
    }

    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        int expectedModCount = this.modCount;
        E[] elementData2 = this.elementData;
        int size2 = this.size;
        int i = 0;
        while (this.modCount == expectedModCount && i < size2) {
            action.accept(elementData2[i]);
            i++;
        }
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public Spliterator<E> spliterator() {
        return new ArrayListSpliterator(this, 0, -1, 0);
    }

    static final class ArrayListSpliterator<E> implements Spliterator<E> {
        private int expectedModCount;
        private int fence;
        private int index;
        private final ArrayList<E> list;

        ArrayListSpliterator(ArrayList<E> list2, int origin, int fence2, int expectedModCount2) {
            this.list = list2;
            this.index = origin;
            this.fence = fence2;
            this.expectedModCount = expectedModCount2;
        }

        private int getFence() {
            int hi = this.fence;
            if (hi >= 0) {
                return hi;
            }
            ArrayList<E> lst = this.list;
            if (lst == null) {
                this.fence = 0;
                return 0;
            }
            this.expectedModCount = lst.modCount;
            int hi2 = lst.size;
            this.fence = hi2;
            return hi2;
        }

        public ArrayListSpliterator<E> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            ArrayList<E> arrayList = this.list;
            this.index = mid;
            return new ArrayListSpliterator<>(arrayList, lo, mid, this.expectedModCount);
        }

        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int hi = getFence();
            int i = this.index;
            if (i >= hi) {
                return false;
            }
            this.index = i + 1;
            action.accept(this.list.elementData[i]);
            if (this.list.modCount == this.expectedModCount) {
                return true;
            }
            throw new ConcurrentModificationException();
        }

        public void forEachRemaining(Consumer<? super E> action) {
            E[] a;
            int mc;
            if (action == null) {
                throw new NullPointerException();
            }
            ArrayList<E> lst = this.list;
            if (!(lst == null || (a = lst.elementData) == null)) {
                int hi = this.fence;
                if (hi < 0) {
                    mc = lst.modCount;
                    hi = lst.size;
                } else {
                    mc = this.expectedModCount;
                }
                int i = this.index;
                if (i >= 0) {
                    this.index = hi;
                    if (hi <= a.length) {
                        while (i < hi) {
                            action.accept(a[i]);
                            i++;
                        }
                        if (lst.modCount == mc) {
                            return;
                        }
                    }
                }
            }
            throw new ConcurrentModificationException();
        }

        public long estimateSize() {
            return (long) (getFence() - this.index);
        }

        public int characteristics() {
            return 16464;
        }
    }

    public boolean removeIf(Predicate<? super E> filter) {
        boolean anyToRemove = false;
        Objects.requireNonNull(filter);
        int removeCount = 0;
        BitSet removeSet = new BitSet(this.size);
        int expectedModCount = this.modCount;
        int size2 = this.size;
        int i = 0;
        while (this.modCount == expectedModCount && i < size2) {
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
            int newSize = size2 - removeCount;
            int i2 = 0;
            int j = 0;
            while (i2 < size2 && j < newSize) {
                int i3 = removeSet.nextClearBit(i2);
                this.elementData[j] = this.elementData[i3];
                i2 = i3 + 1;
                j++;
            }
            for (int k = newSize; k < size2; k++) {
                this.elementData[k] = null;
            }
            this.size = newSize;
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.modCount++;
        }
        return anyToRemove;
    }

    public void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        int expectedModCount = this.modCount;
        int size2 = this.size;
        int i = 0;
        while (this.modCount == expectedModCount && i < size2) {
            this.elementData[i] = operator.apply(this.elementData[i]);
            i++;
        }
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.modCount++;
    }

    public void sort(Comparator<? super E> c) {
        int expectedModCount = this.modCount;
        Arrays.sort(this.elementData, 0, this.size, c);
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.modCount++;
    }
}
