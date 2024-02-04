package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private static final Object PRESENT = null;
    static final long serialVersionUID = -5024744406713321676L;
    private transient HashMap<E, Object> map;

    public HashSet() {
        this.map = new HashMap<>();
    }

    public HashSet(Collection<? extends E> c) {
        this.map = new HashMap<>(Math.max(((int) (((float) c.size()) / 0.75f)) + 1, 16));
        addAll(c);
    }

    public HashSet(int initialCapacity, float loadFactor) {
        this.map = new HashMap<>(initialCapacity, loadFactor);
    }

    public HashSet(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }

    HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        this.map = new LinkedHashMap(initialCapacity, loadFactor);
    }

    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    public boolean add(E e) {
        return this.map.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        return this.map.remove(o) == PRESENT;
    }

    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        try {
            HashSet<E> newSet = (HashSet) super.clone();
            newSet.map = (HashMap) this.map.clone();
            return newSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.map.capacity());
        s.writeFloat(this.map.loadFactor());
        s.writeInt(this.map.size());
        for (E e : this.map.keySet()) {
            s.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        HashMap<E, Object> hashMap;
        s.defaultReadObject();
        int capacity = s.readInt();
        float loadFactor = s.readFloat();
        if (this instanceof LinkedHashSet) {
            hashMap = new LinkedHashMap<>(capacity, loadFactor);
        } else {
            hashMap = new HashMap<>(capacity, loadFactor);
        }
        this.map = hashMap;
        int size = s.readInt();
        for (int i = 0; i < size; i++) {
            this.map.put(s.readObject(), PRESENT);
        }
    }

    public Spliterator<E> spliterator() {
        return new HashMap.KeySpliterator(this.map, 0, -1, 0, 0);
    }
}
