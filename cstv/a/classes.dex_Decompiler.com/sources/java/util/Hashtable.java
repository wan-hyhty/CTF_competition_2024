package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable {
    private static final int ENTRIES = 2;
    private static final int KEYS = 0;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int VALUES = 1;
    private static final long serialVersionUID = 1421746759512286392L;
    /* access modifiers changed from: private */
    public transient int count;
    private volatile transient Set<Map.Entry<K, V>> entrySet;
    private volatile transient Set<K> keySet;
    private float loadFactor;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient HashtableEntry<K, V>[] table;
    private int threshold;
    private volatile transient Collection<V> values;

    /* access modifiers changed from: private */
    public static int hash(Object k) {
        return k.hashCode();
    }

    public Hashtable(int initialCapacity, float loadFactor2) {
        this.modCount = 0;
        this.keySet = null;
        this.entrySet = null;
        this.values = null;
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        } else if (loadFactor2 <= 0.0f || Float.isNaN(loadFactor2)) {
            throw new IllegalArgumentException("Illegal Load: " + loadFactor2);
        } else {
            initialCapacity = initialCapacity == 0 ? 1 : initialCapacity;
            this.loadFactor = loadFactor2;
            this.table = new HashtableEntry[initialCapacity];
            this.threshold = initialCapacity > 2147483640 ? 2147483640 : initialCapacity;
        }
    }

    public Hashtable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public Hashtable() {
        this(11, 0.75f);
    }

    public Hashtable(Map<? extends K, ? extends V> t) {
        this(Math.max(t.size() * 2, 11), 0.75f);
        putAll(t);
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized boolean isEmpty() {
        boolean z = false;
        synchronized (this) {
            if (this.count == 0) {
                z = true;
            }
        }
        return z;
    }

    public synchronized Enumeration<K> keys() {
        return getEnumeration(0);
    }

    public synchronized Enumeration<V> elements() {
        return getEnumeration(1);
    }

    public synchronized boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        HashtableEntry<K, V>[] tab = this.table;
        int i = tab.length;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return false;
            }
            for (HashtableEntry<K, V> e = tab[i2]; e != null; e = e.next) {
                if (e.value.equals(value)) {
                    return true;
                }
            }
            i = i2;
        }
    }

    public boolean containsValue(Object value) {
        return contains(value);
    }

    public synchronized boolean containsKey(Object key) {
        HashtableEntry<K, V>[] tab = this.table;
        int hash = hash(key);
        for (HashtableEntry<K, V> e = tab[(Integer.MAX_VALUE & hash) % tab.length]; e != null; e = e.next) {
            if (e.hash == hash && e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public synchronized V get(Object key) {
        HashtableEntry<K, V>[] tab = this.table;
        int hash = hash(key);
        HashtableEntry<K, V> e = tab[(Integer.MAX_VALUE & hash) % tab.length];
        while (e != null) {
            if (e.hash != hash || !e.key.equals(key)) {
                e = e.next;
            } else {
                return e.value;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void rehash() {
        int oldCapacity = this.table.length;
        HashtableEntry<K, V>[] oldMap = this.table;
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity != MAX_ARRAY_SIZE) {
                newCapacity = MAX_ARRAY_SIZE;
            } else {
                return;
            }
        }
        HashtableEntry<K, V>[] newMap = new HashtableEntry[newCapacity];
        this.modCount++;
        this.threshold = (int) Math.min(((float) newCapacity) * this.loadFactor, 2.14748365E9f);
        this.table = newMap;
        int i = oldCapacity;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 > 0) {
                HashtableEntry<K, V> old = oldMap[i];
                while (old != null) {
                    HashtableEntry<K, V> e = old;
                    old = old.next;
                    int index = (e.hash & Integer.MAX_VALUE) % newCapacity;
                    e.next = newMap[index];
                    newMap[index] = e;
                }
            } else {
                return;
            }
        }
    }

    public synchronized V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        HashtableEntry<K, V>[] tab = this.table;
        int hash = hash(key);
        int index = (hash & Integer.MAX_VALUE) % tab.length;
        HashtableEntry<K, V> e = tab[index];
        while (e != null) {
            if (e.hash != hash || !e.key.equals(key)) {
                e = e.next;
            } else {
                V old = e.value;
                e.value = value;
                return old;
            }
        }
        this.modCount++;
        if (this.count >= this.threshold) {
            rehash();
            tab = this.table;
            hash = hash(key);
            index = (hash & Integer.MAX_VALUE) % tab.length;
        }
        tab[index] = new HashtableEntry<>(hash, key, value, tab[index]);
        this.count++;
        return null;
    }

    public synchronized V remove(Object key) {
        HashtableEntry<K, V>[] tab = this.table;
        int hash = hash(key);
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        HashtableEntry<K, V> e = tab[index];
        HashtableEntry<K, V> hashtableEntry = null;
        while (e != null) {
            if (e.hash != hash || !e.key.equals(key)) {
                hashtableEntry = e;
                e = e.next;
            } else {
                this.modCount++;
                if (hashtableEntry != null) {
                    hashtableEntry.next = e.next;
                } else {
                    tab[index] = e.next;
                }
                this.count--;
                V oldValue = e.value;
                e.value = null;
                return oldValue;
            }
        }
        return null;
    }

    public synchronized void putAll(Map<? extends K, ? extends V> t) {
        for (Map.Entry<? extends K, ? extends V> e : t.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    public synchronized void clear() {
        HashtableEntry[] tab = this.table;
        this.modCount++;
        int index = tab.length;
        while (true) {
            index--;
            if (index >= 0) {
                tab[index] = null;
            } else {
                this.count = 0;
            }
        }
    }

    public synchronized Object clone() {
        Hashtable<K, V> t;
        HashtableEntry<K, V> hashtableEntry;
        try {
            t = (Hashtable) super.clone();
            t.table = new HashtableEntry[this.table.length];
            int i = this.table.length;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    HashtableEntry<K, V>[] hashtableEntryArr = t.table;
                    if (this.table[i2] != null) {
                        hashtableEntry = (HashtableEntry) this.table[i2].clone();
                    } else {
                        hashtableEntry = null;
                    }
                    hashtableEntryArr[i2] = hashtableEntry;
                    i = i2;
                } else {
                    t.keySet = null;
                    t.entrySet = null;
                    t.values = null;
                    t.modCount = 0;
                }
            }
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return t;
    }

    public synchronized String toString() {
        int max = size() - 1;
        if (max == -1) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        sb.append('{');
        int i = 0;
        while (true) {
            Map.Entry<K, V> e = it.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key == this ? "(this Map)" : key.toString());
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value.toString());
            if (i == max) {
                return sb.append('}').toString();
            }
            sb.append(", ");
            i++;
        }
    }

    private <T> Enumeration<T> getEnumeration(int type) {
        if (this.count == 0) {
            return Collections.emptyEnumeration();
        }
        return new Enumerator(type, false);
    }

    /* access modifiers changed from: private */
    public <T> Iterator<T> getIterator(int type) {
        if (this.count == 0) {
            return Collections.emptyIterator();
        }
        return new Enumerator(type, true);
    }

    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.synchronizedSet(new KeySet(this, (KeySet) null), this);
        }
        return this.keySet;
    }

    private class KeySet extends AbstractSet<K> {
        /* synthetic */ KeySet(Hashtable this$02, KeySet keySet) {
            this();
        }

        private KeySet() {
        }

        public Iterator<K> iterator() {
            return Hashtable.this.getIterator(0);
        }

        public int size() {
            return Hashtable.this.count;
        }

        public boolean contains(Object o) {
            return Hashtable.this.containsKey(o);
        }

        public boolean remove(Object o) {
            return Hashtable.this.remove(o) != null;
        }

        public void clear() {
            Hashtable.this.clear();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = Collections.synchronizedSet(new EntrySet(this, (EntrySet) null), this);
        }
        return this.entrySet;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        /* synthetic */ EntrySet(Hashtable this$02, EntrySet entrySet) {
            this();
        }

        private EntrySet() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return Hashtable.this.getIterator(2);
        }

        public boolean add(Map.Entry<K, V> o) {
            return super.add(o);
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o;
            Object key = entry.getKey();
            HashtableEntry[] tab = Hashtable.this.table;
            int hash = Hashtable.hash(key);
            for (HashtableEntry e = tab[(Integer.MAX_VALUE & hash) % tab.length]; e != null; e = e.next) {
                if (e.hash == hash && e.equals(entry)) {
                    return true;
                }
            }
            return false;
        }

        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> entry = (Map.Entry) o;
            K key = entry.getKey();
            HashtableEntry<K, V>[] tab = Hashtable.this.table;
            int hash = Hashtable.hash(key);
            int index = (Integer.MAX_VALUE & hash) % tab.length;
            HashtableEntry<K, V> e = tab[index];
            HashtableEntry<K, V> hashtableEntry = null;
            while (e != null) {
                if (e.hash != hash || !e.equals(entry)) {
                    hashtableEntry = e;
                    e = e.next;
                } else {
                    Hashtable hashtable = Hashtable.this;
                    int unused = hashtable.modCount = hashtable.modCount + 1;
                    if (hashtableEntry != null) {
                        hashtableEntry.next = e.next;
                    } else {
                        tab[index] = e.next;
                    }
                    Hashtable hashtable2 = Hashtable.this;
                    int unused2 = hashtable2.count = hashtable2.count - 1;
                    e.value = null;
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return Hashtable.this.count;
        }

        public void clear() {
            Hashtable.this.clear();
        }
    }

    public Collection<V> values() {
        if (this.values == null) {
            this.values = Collections.synchronizedCollection(new ValueCollection(this, (ValueCollection) null), this);
        }
        return this.values;
    }

    private class ValueCollection extends AbstractCollection<V> {
        /* synthetic */ ValueCollection(Hashtable this$02, ValueCollection valueCollection) {
            this();
        }

        private ValueCollection() {
        }

        public Iterator<V> iterator() {
            return Hashtable.this.getIterator(1);
        }

        public int size() {
            return Hashtable.this.count;
        }

        public boolean contains(Object o) {
            return Hashtable.this.containsValue(o);
        }

        public void clear() {
            Hashtable.this.clear();
        }
    }

    public synchronized boolean equals(Object o) {
        boolean z;
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map)) {
            return false;
        }
        Map<K, V> t = (Map) o;
        if (t.size() != size()) {
            return false;
        }
        try {
            for (Map.Entry<K, V> e : entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
                if (value == null) {
                    if (t.get(key) == null) {
                        z = t.containsKey(key);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return false;
                    }
                } else if (!value.equals(t.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e2) {
            return false;
        } catch (NullPointerException e3) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int hashCode() {
        /*
            r6 = this;
            r3 = 0
            monitor-enter(r6)
            r1 = 0
            int r4 = r6.count     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x000e
            float r4 = r6.loadFactor     // Catch:{ all -> 0x0030 }
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0010
        L_0x000e:
            monitor-exit(r6)
            return r3
        L_0x0010:
            float r4 = r6.loadFactor     // Catch:{ all -> 0x0030 }
            float r4 = -r4
            r6.loadFactor = r4     // Catch:{ all -> 0x0030 }
            java.util.Hashtable$HashtableEntry<K, V>[] r2 = r6.table     // Catch:{ all -> 0x0030 }
            int r4 = r2.length     // Catch:{ all -> 0x0030 }
        L_0x0018:
            if (r3 >= r4) goto L_0x0029
            r0 = r2[r3]     // Catch:{ all -> 0x0030 }
        L_0x001c:
            if (r0 == 0) goto L_0x0026
            int r5 = r0.hashCode()     // Catch:{ all -> 0x0030 }
            int r1 = r1 + r5
            java.util.Hashtable$HashtableEntry<K, V> r0 = r0.next     // Catch:{ all -> 0x0030 }
            goto L_0x001c
        L_0x0026:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x0029:
            float r3 = r6.loadFactor     // Catch:{ all -> 0x0030 }
            float r3 = -r3
            r6.loadFactor = r3     // Catch:{ all -> 0x0030 }
            monitor-exit(r6)
            return r1
        L_0x0030:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Hashtable.hashCode():int");
    }

    public synchronized void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        int expectedModCount = this.modCount;
        for (HashtableEntry<K, V> hashtableEntry : this.table) {
            while (hashtableEntry != null) {
                action.accept(hashtableEntry.key, hashtableEntry.value);
                hashtableEntry = hashtableEntry.next;
                if (expectedModCount != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    public synchronized void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        int expectedModCount = this.modCount;
        for (HashtableEntry<K, V> entry : this.table) {
            while (entry != null) {
                entry.value = Objects.requireNonNull(function.apply(entry.key, entry.value));
                entry = entry.next;
                if (expectedModCount != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    public synchronized V getOrDefault(Object key, V defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

    public synchronized V putIfAbsent(K key, V value) {
        return super.putIfAbsent(key, value);
    }

    public synchronized boolean remove(Object key, Object value) {
        return super.remove(key, value);
    }

    public synchronized boolean replace(K key, V oldValue, V newValue) {
        return super.replace(key, oldValue, newValue);
    }

    public synchronized V replace(K key, V value) {
        return super.replace(key, value);
    }

    public synchronized V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return super.computeIfAbsent(key, mappingFunction);
    }

    public synchronized V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.computeIfPresent(key, remappingFunction);
    }

    public synchronized V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.compute(key, remappingFunction);
    }

    public synchronized V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return super.merge(key, value, remappingFunction);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        if (r1 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r8.writeObject(r1.key);
        r8.writeObject(r1.value);
        r1 = r1.next;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeObject(java.io.ObjectOutputStream r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
            monitor-enter(r7)
            r8.defaultWriteObject()     // Catch:{ all -> 0x003f }
            java.util.Hashtable$HashtableEntry<K, V>[] r4 = r7.table     // Catch:{ all -> 0x003f }
            int r4 = r4.length     // Catch:{ all -> 0x003f }
            r8.writeInt(r4)     // Catch:{ all -> 0x003f }
            int r4 = r7.count     // Catch:{ all -> 0x003f }
            r8.writeInt(r4)     // Catch:{ all -> 0x003f }
            r3 = 0
        L_0x0011:
            java.util.Hashtable$HashtableEntry<K, V>[] r4 = r7.table     // Catch:{ all -> 0x003f }
            int r4 = r4.length     // Catch:{ all -> 0x003f }
            if (r3 >= r4) goto L_0x002f
            java.util.Hashtable$HashtableEntry<K, V>[] r4 = r7.table     // Catch:{ all -> 0x003f }
            r0 = r4[r3]     // Catch:{ all -> 0x003f }
            r2 = r1
        L_0x001b:
            if (r0 == 0) goto L_0x002b
            java.util.Hashtable$HashtableEntry r1 = new java.util.Hashtable$HashtableEntry     // Catch:{ all -> 0x0043 }
            K r4 = r0.key     // Catch:{ all -> 0x0043 }
            V r5 = r0.value     // Catch:{ all -> 0x0043 }
            r6 = 0
            r1.<init>(r6, r4, r5, r2)     // Catch:{ all -> 0x0043 }
            java.util.Hashtable$HashtableEntry<K, V> r0 = r0.next     // Catch:{ all -> 0x003f }
            r2 = r1
            goto L_0x001b
        L_0x002b:
            int r3 = r3 + 1
            r1 = r2
            goto L_0x0011
        L_0x002f:
            monitor-exit(r7)
        L_0x0030:
            if (r1 == 0) goto L_0x0042
            K r4 = r1.key
            r8.writeObject(r4)
            V r4 = r1.value
            r8.writeObject(r4)
            java.util.Hashtable$HashtableEntry<K, V> r1 = r1.next
            goto L_0x0030
        L_0x003f:
            r4 = move-exception
        L_0x0040:
            monitor-exit(r7)
            throw r4
        L_0x0042:
            return
        L_0x0043:
            r4 = move-exception
            r1 = r2
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Hashtable.writeObject(java.io.ObjectOutputStream):void");
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int origlength = s.readInt();
        int elements = s.readInt();
        int length = ((int) (((float) elements) * this.loadFactor)) + (elements / 20) + 3;
        if (length > elements && (length & 1) == 0) {
            length--;
        }
        if (origlength > 0 && length > origlength) {
            length = origlength;
        }
        HashtableEntry<K, V>[] newTable = new HashtableEntry[length];
        this.threshold = (int) Math.min(((float) length) * this.loadFactor, 2.14748365E9f);
        this.count = 0;
        while (elements > 0) {
            reconstitutionPut(newTable, s.readObject(), s.readObject());
            elements--;
        }
        this.table = newTable;
    }

    private void reconstitutionPut(HashtableEntry<K, V>[] tab, K key, V value) throws StreamCorruptedException {
        if (value == null) {
            throw new StreamCorruptedException();
        }
        int hash = hash(key);
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        HashtableEntry<K, V> e = tab[index];
        while (e != null) {
            if (e.hash != hash || !e.key.equals(key)) {
                e = e.next;
            } else {
                throw new StreamCorruptedException();
            }
        }
        tab[index] = new HashtableEntry<>(hash, key, value, tab[index]);
        this.count++;
    }

    static class HashtableEntry<K, V> implements Map.Entry<K, V> {
        int hash;
        final K key;
        HashtableEntry<K, V> next;
        V value;

        protected HashtableEntry(int hash2, K key2, V value2, HashtableEntry<K, V> next2) {
            this.hash = hash2;
            this.key = key2;
            this.value = value2;
            this.next = next2;
        }

        /* access modifiers changed from: protected */
        public Object clone() {
            HashtableEntry hashtableEntry = null;
            int i = this.hash;
            K k = this.key;
            V v = this.value;
            if (this.next != null) {
                hashtableEntry = (HashtableEntry) this.next.clone();
            }
            return new HashtableEntry(i, k, v, hashtableEntry);
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value2) {
            if (value2 == null) {
                throw new NullPointerException();
            }
            V oldValue = this.value;
            this.value = value2;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            if (this.key.equals(e.getKey())) {
                return this.value.equals(e.getValue());
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.key) ^ Objects.hashCode(this.value);
        }

        public String toString() {
            return this.key.toString() + "=" + this.value.toString();
        }
    }

    private class Enumerator<T> implements Enumeration<T>, Iterator<T> {
        HashtableEntry<K, V> entry = null;
        protected int expectedModCount = Hashtable.this.modCount;
        int index = this.table.length;
        boolean iterator;
        HashtableEntry<K, V> lastReturned = null;
        HashtableEntry[] table = Hashtable.this.table;
        int type;

        Enumerator(int type2, boolean iterator2) {
            this.type = type2;
            this.iterator = iterator2;
        }

        public boolean hasMoreElements() {
            HashtableEntry<K, V> e = this.entry;
            int i = this.index;
            HashtableEntry<K, V>[] t = this.table;
            while (e == null && i > 0) {
                i--;
                e = t[i];
            }
            this.entry = e;
            this.index = i;
            if (e != null) {
                return true;
            }
            return false;
        }

        public T nextElement() {
            HashtableEntry<K, V> et = this.entry;
            int i = this.index;
            HashtableEntry<K, V>[] t = this.table;
            while (et == null && i > 0) {
                i--;
                et = t[i];
            }
            this.entry = et;
            this.index = i;
            if (et != null) {
                HashtableEntry<K, V> e = this.entry;
                this.lastReturned = e;
                this.entry = e.next;
                if (this.type == 0) {
                    return e.key;
                }
                return this.type == 1 ? e.value : e;
            }
            throw new NoSuchElementException("Hashtable Enumerator");
        }

        public boolean hasNext() {
            return hasMoreElements();
        }

        public T next() {
            if (Hashtable.this.modCount == this.expectedModCount) {
                return nextElement();
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            if (!this.iterator) {
                throw new UnsupportedOperationException();
            } else if (this.lastReturned == null) {
                throw new IllegalStateException("Hashtable Enumerator");
            } else if (Hashtable.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                synchronized (Hashtable.this) {
                    HashtableEntry<K, V>[] tab = Hashtable.this.table;
                    int index2 = (this.lastReturned.hash & Integer.MAX_VALUE) % tab.length;
                    HashtableEntry<K, V> e = tab[index2];
                    HashtableEntry<K, V> hashtableEntry = null;
                    while (e != null) {
                        if (e == this.lastReturned) {
                            Hashtable hashtable = Hashtable.this;
                            int unused = hashtable.modCount = hashtable.modCount + 1;
                            this.expectedModCount++;
                            if (hashtableEntry == null) {
                                tab[index2] = e.next;
                            } else {
                                hashtableEntry.next = e.next;
                            }
                            Hashtable hashtable2 = Hashtable.this;
                            int unused2 = hashtable2.count = hashtable2.count - 1;
                            this.lastReturned = null;
                        } else {
                            hashtableEntry = e;
                            e = e.next;
                        }
                    }
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
