package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    private static final Object PRESENT = null;
    private static final long serialVersionUID = -2479143000061671589L;
    private transient NavigableMap<E, Object> m;

    TreeSet(NavigableMap<E, Object> m2) {
        this.m = m2;
    }

    public TreeSet() {
        this(new TreeMap());
    }

    public TreeSet(Comparator<? super E> comparator) {
        this(new TreeMap(comparator));
    }

    public TreeSet(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public TreeSet(SortedSet<E> s) {
        this(s.comparator());
        addAll(s);
    }

    public Iterator<E> iterator() {
        return this.m.navigableKeySet().iterator();
    }

    public Iterator<E> descendingIterator() {
        return this.m.descendingKeySet().iterator();
    }

    public NavigableSet<E> descendingSet() {
        return new TreeSet(this.m.descendingMap());
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

    public boolean add(E e) {
        return this.m.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return this.m.remove(o) == PRESENT;
    }

    public void clear() {
        this.m.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        r3 = (java.util.SortedSet) r6;
        r1 = (java.util.TreeMap) r5.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean addAll(java.util.Collection<? extends E> r6) {
        /*
            r5 = this;
            java.util.NavigableMap<E, java.lang.Object> r4 = r5.m
            int r4 = r4.size()
            if (r4 != 0) goto L_0x0038
            int r4 = r6.size()
            if (r4 <= 0) goto L_0x0038
            boolean r4 = r6 instanceof java.util.SortedSet
            if (r4 == 0) goto L_0x0038
            java.util.NavigableMap<E, java.lang.Object> r4 = r5.m
            boolean r4 = r4 instanceof java.util.TreeMap
            if (r4 == 0) goto L_0x0038
            r3 = r6
            java.util.SortedSet r3 = (java.util.SortedSet) r3
            java.util.NavigableMap<E, java.lang.Object> r1 = r5.m
            java.util.TreeMap r1 = (java.util.TreeMap) r1
            java.util.Comparator r0 = r3.comparator()
            java.util.Comparator r2 = r1.comparator()
            if (r0 == r2) goto L_0x0031
            if (r0 == 0) goto L_0x0038
            boolean r4 = r0.equals(r2)
            if (r4 == 0) goto L_0x0038
        L_0x0031:
            java.lang.Object r4 = PRESENT
            r1.addAllForTreeSet(r3, r4)
            r4 = 1
            return r4
        L_0x0038:
            boolean r4 = super.addAll(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TreeSet.addAll(java.util.Collection):boolean");
    }

    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return new TreeSet(this.m.subMap(fromElement, fromInclusive, toElement, toInclusive));
    }

    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return new TreeSet(this.m.headMap(toElement, inclusive));
    }

    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return new TreeSet(this.m.tailMap(fromElement, inclusive));
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    public SortedSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    public SortedSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }

    public Comparator<? super E> comparator() {
        return this.m.comparator();
    }

    public E first() {
        return this.m.firstKey();
    }

    public E last() {
        return this.m.lastKey();
    }

    public E lower(E e) {
        return this.m.lowerKey(e);
    }

    public E floor(E e) {
        return this.m.floorKey(e);
    }

    public E ceiling(E e) {
        return this.m.ceilingKey(e);
    }

    public E higher(E e) {
        return this.m.higherKey(e);
    }

    public E pollFirst() {
        Map.Entry<E, Object> pollFirstEntry = this.m.pollFirstEntry();
        if (pollFirstEntry == null) {
            return null;
        }
        return pollFirstEntry.getKey();
    }

    public E pollLast() {
        Map.Entry<E, Object> pollLastEntry = this.m.pollLastEntry();
        if (pollLastEntry == null) {
            return null;
        }
        return pollLastEntry.getKey();
    }

    public Object clone() {
        try {
            TreeSet<E> clone = (TreeSet) super.clone();
            clone.m = new TreeMap(this.m);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError((Throwable) e);
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(this.m.comparator());
        s.writeInt(this.m.size());
        for (E e : this.m.keySet()) {
            s.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        TreeMap<E, Object> tm = new TreeMap<>((Comparator) s.readObject());
        this.m = tm;
        tm.readTreeSet(s.readInt(), s, PRESENT);
    }

    public Spliterator<E> spliterator() {
        return TreeMap.keySpliteratorFor(this.m);
    }
}
