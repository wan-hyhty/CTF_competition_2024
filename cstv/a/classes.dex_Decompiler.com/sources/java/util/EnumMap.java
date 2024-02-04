package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Map;

public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable {
    private static final Object NULL = null;
    private static final Enum[] ZERO_LENGTH_ENUM_ARRAY = null;
    private static final long serialVersionUID = 458661240069192865L;
    private transient Set<Map.Entry<K, V>> entrySet = null;
    private final Class<K> keyType;
    /* access modifiers changed from: private */
    public transient K[] keyUniverse;
    /* access modifiers changed from: private */
    public transient int size = 0;
    /* access modifiers changed from: private */
    public transient Object[] vals;

    /* access modifiers changed from: private */
    public Object maskNull(Object value) {
        return value == null ? NULL : value;
    }

    /* access modifiers changed from: private */
    public V unmaskNull(Object value) {
        if (value == NULL) {
            return null;
        }
        return value;
    }

    public EnumMap(Class<K> keyType2) {
        this.keyType = keyType2;
        this.keyUniverse = getKeyUniverse(keyType2);
        this.vals = new Object[this.keyUniverse.length];
    }

    public EnumMap(EnumMap<K, ? extends V> m) {
        this.keyType = m.keyType;
        this.keyUniverse = m.keyUniverse;
        this.vals = (Object[]) m.vals.clone();
        this.size = m.size;
    }

    public EnumMap(Map<K, ? extends V> m) {
        if (m instanceof EnumMap) {
            EnumMap<K, ? extends V> em = (EnumMap) m;
            this.keyType = em.keyType;
            this.keyUniverse = em.keyUniverse;
            this.vals = (Object[]) em.vals.clone();
            this.size = em.size;
        } else if (m.isEmpty()) {
            throw new IllegalArgumentException("Specified map is empty");
        } else {
            this.keyType = ((Enum) m.keySet().iterator().next()).getDeclaringClass();
            this.keyUniverse = getKeyUniverse(this.keyType);
            this.vals = new Object[this.keyUniverse.length];
            putAll(m);
        }
    }

    public int size() {
        return this.size;
    }

    public boolean containsValue(Object value) {
        Object value2 = maskNull(value);
        for (Object val : this.vals) {
            if (value2.equals(val)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(Object key) {
        return isValidKey(key) && this.vals[((Enum) key).ordinal()] != null;
    }

    /* access modifiers changed from: private */
    public boolean containsMapping(Object key, Object value) {
        if (isValidKey(key)) {
            return maskNull(value).equals(this.vals[((Enum) key).ordinal()]);
        }
        return false;
    }

    public V get(Object key) {
        if (isValidKey(key)) {
            return unmaskNull(this.vals[((Enum) key).ordinal()]);
        }
        return null;
    }

    public V put(K key, V value) {
        typeCheck(key);
        int index = key.ordinal();
        Object oldValue = this.vals[index];
        this.vals[index] = maskNull(value);
        if (oldValue == null) {
            this.size++;
        }
        return unmaskNull(oldValue);
    }

    public V remove(Object key) {
        if (!isValidKey(key)) {
            return null;
        }
        int index = ((Enum) key).ordinal();
        Object oldValue = this.vals[index];
        this.vals[index] = null;
        if (oldValue != null) {
            this.size--;
        }
        return unmaskNull(oldValue);
    }

    /* access modifiers changed from: private */
    public boolean removeMapping(Object key, Object value) {
        if (!isValidKey(key)) {
            return false;
        }
        int index = ((Enum) key).ordinal();
        if (!maskNull(value).equals(this.vals[index])) {
            return false;
        }
        this.vals[index] = null;
        this.size--;
        return true;
    }

    private boolean isValidKey(Object key) {
        if (key == null) {
            return false;
        }
        Class keyClass = key.getClass();
        if (keyClass == this.keyType || keyClass.getSuperclass() == this.keyType) {
            return true;
        }
        return false;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        if (m instanceof EnumMap) {
            EnumMap<? extends K, ? extends V> em = (EnumMap) m;
            if (em.keyType == this.keyType) {
                for (int i = 0; i < this.keyUniverse.length; i++) {
                    Object emValue = em.vals[i];
                    if (emValue != null) {
                        if (this.vals[i] == null) {
                            this.size++;
                        }
                        this.vals[i] = emValue;
                    }
                }
            } else if (!em.isEmpty()) {
                throw new ClassCastException(em.keyType + " != " + this.keyType);
            }
        } else {
            super.putAll(m);
        }
    }

    public void clear() {
        Arrays.fill(this.vals, (Object) null);
        this.size = 0;
    }

    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        KeySet keySet = new KeySet(this, (KeySet) null);
        this.keySet = keySet;
        return keySet;
    }

    private class KeySet extends AbstractSet<K> {
        /* synthetic */ KeySet(EnumMap this$02, KeySet keySet) {
            this();
        }

        private KeySet() {
        }

        public Iterator<K> iterator() {
            return new KeyIterator(EnumMap.this, (KeyIterator) null);
        }

        public int size() {
            return EnumMap.this.size;
        }

        public boolean contains(Object o) {
            return EnumMap.this.containsKey(o);
        }

        public boolean remove(Object o) {
            int oldSize = EnumMap.this.size;
            EnumMap.this.remove(o);
            return EnumMap.this.size != oldSize;
        }

        public void clear() {
            EnumMap.this.clear();
        }
    }

    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        Values values = new Values(this, (Values) null);
        this.values = values;
        return values;
    }

    private class Values extends AbstractCollection<V> {
        /* synthetic */ Values(EnumMap this$02, Values values) {
            this();
        }

        private Values() {
        }

        public Iterator<V> iterator() {
            return new ValueIterator(EnumMap.this, (ValueIterator) null);
        }

        public int size() {
            return EnumMap.this.size;
        }

        public boolean contains(Object o) {
            return EnumMap.this.containsValue(o);
        }

        public boolean remove(Object o) {
            Object o2 = EnumMap.this.maskNull(o);
            for (int i = 0; i < EnumMap.this.vals.length; i++) {
                if (o2.equals(EnumMap.this.vals[i])) {
                    EnumMap.this.vals[i] = null;
                    EnumMap enumMap = EnumMap.this;
                    int unused = enumMap.size = enumMap.size - 1;
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            EnumMap.this.clear();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        EntrySet entrySet2 = new EntrySet(this, (EntrySet) null);
        this.entrySet = entrySet2;
        return entrySet2;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        /* synthetic */ EntrySet(EnumMap this$02, EntrySet entrySet) {
            this();
        }

        private EntrySet() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(EnumMap.this, (EntryIterator) null);
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o;
            return EnumMap.this.containsMapping(entry.getKey(), entry.getValue());
        }

        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o;
            return EnumMap.this.removeMapping(entry.getKey(), entry.getValue());
        }

        public int size() {
            return EnumMap.this.size;
        }

        public void clear() {
            EnumMap.this.clear();
        }

        public Object[] toArray() {
            return fillEntryArray(new Object[EnumMap.this.size]);
        }

        public <T> T[] toArray(T[] a) {
            int size = size();
            if (a.length < size) {
                a = (Object[]) Array.newInstance(a.getClass().getComponentType(), size);
            }
            if (a.length > size) {
                a[size] = null;
            }
            return fillEntryArray(a);
        }

        private Object[] fillEntryArray(Object[] a) {
            int j = 0;
            for (int i = 0; i < EnumMap.this.vals.length; i++) {
                if (EnumMap.this.vals[i] != null) {
                    a[j] = new AbstractMap.SimpleEntry(EnumMap.this.keyUniverse[i], EnumMap.this.unmaskNull(EnumMap.this.vals[i]));
                    j++;
                }
            }
            return a;
        }
    }

    private abstract class EnumMapIterator<T> implements Iterator<T> {
        int index;
        int lastReturnedIndex;

        /* synthetic */ EnumMapIterator(EnumMap this$02, EnumMapIterator enumMapIterator) {
            this();
        }

        private EnumMapIterator() {
            this.index = 0;
            this.lastReturnedIndex = -1;
        }

        public boolean hasNext() {
            while (this.index < EnumMap.this.vals.length && EnumMap.this.vals[this.index] == null) {
                this.index++;
            }
            return this.index != EnumMap.this.vals.length;
        }

        public void remove() {
            checkLastReturnedIndex();
            if (EnumMap.this.vals[this.lastReturnedIndex] != null) {
                EnumMap.this.vals[this.lastReturnedIndex] = null;
                EnumMap enumMap = EnumMap.this;
                int unused = enumMap.size = enumMap.size - 1;
            }
            this.lastReturnedIndex = -1;
        }

        private void checkLastReturnedIndex() {
            if (this.lastReturnedIndex < 0) {
                throw new IllegalStateException();
            }
        }
    }

    private class KeyIterator extends EnumMap<K, V>.EnumMapIterator<K> {
        /* synthetic */ KeyIterator(EnumMap this$02, KeyIterator keyIterator) {
            this();
        }

        private KeyIterator() {
            super(EnumMap.this, (EnumMapIterator) null);
        }

        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastReturnedIndex = i;
            return EnumMap.this.keyUniverse[this.lastReturnedIndex];
        }
    }

    private class ValueIterator extends EnumMap<K, V>.EnumMapIterator<V> {
        /* synthetic */ ValueIterator(EnumMap this$02, ValueIterator valueIterator) {
            this();
        }

        private ValueIterator() {
            super(EnumMap.this, (EnumMapIterator) null);
        }

        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastReturnedIndex = i;
            return EnumMap.this.unmaskNull(EnumMap.this.vals[this.lastReturnedIndex]);
        }
    }

    private class EntryIterator extends EnumMap<K, V>.EnumMapIterator<Map.Entry<K, V>> {
        private EnumMap<K, V>.EntryIterator.Entry lastReturnedEntry;

        /* synthetic */ EntryIterator(EnumMap this$02, EntryIterator entryIterator) {
            this();
        }

        private EntryIterator() {
            super(EnumMap.this, (EnumMapIterator) null);
            this.lastReturnedEntry = null;
        }

        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastReturnedEntry = new Entry(this, i, (Entry) null);
            return this.lastReturnedEntry;
        }

        public void remove() {
            this.lastReturnedIndex = this.lastReturnedEntry == null ? -1 : this.lastReturnedEntry.index;
            super.remove();
            int unused = this.lastReturnedEntry.index = this.lastReturnedIndex;
            this.lastReturnedEntry = null;
        }

        private class Entry implements Map.Entry<K, V> {
            /* access modifiers changed from: private */
            public int index;

            /* synthetic */ Entry(EntryIterator this$12, int index2, Entry entry) {
                this(index2);
            }

            private Entry(int index2) {
                this.index = index2;
            }

            public K getKey() {
                checkIndexForEntryUse();
                return EnumMap.this.keyUniverse[this.index];
            }

            public V getValue() {
                checkIndexForEntryUse();
                return EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
            }

            public V setValue(V value) {
                checkIndexForEntryUse();
                V oldValue = EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
                EnumMap.this.vals[this.index] = EnumMap.this.maskNull(value);
                return oldValue;
            }

            public boolean equals(Object o) {
                if (this.index < 0) {
                    if (o == this) {
                        return true;
                    }
                    return false;
                } else if (!(o instanceof Map.Entry)) {
                    return false;
                } else {
                    Map.Entry e = (Map.Entry) o;
                    Object ourValue = EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
                    Object hisValue = e.getValue();
                    if (e.getKey() != EnumMap.this.keyUniverse[this.index]) {
                        return false;
                    }
                    if (ourValue == hisValue) {
                        return true;
                    }
                    if (ourValue != null) {
                        return ourValue.equals(hisValue);
                    }
                    return false;
                }
            }

            public int hashCode() {
                if (this.index < 0) {
                    return super.hashCode();
                }
                return EnumMap.this.entryHashCode(this.index);
            }

            public String toString() {
                if (this.index < 0) {
                    return super.toString();
                }
                return EnumMap.this.keyUniverse[this.index] + "=" + EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
            }

            private void checkIndexForEntryUse() {
                if (this.index < 0) {
                    throw new IllegalStateException("Entry was removed");
                }
            }
        }
    }

    public boolean equals(Object o) {
        boolean z;
        if (this == o) {
            return true;
        }
        if (o instanceof EnumMap) {
            return equals((EnumMap) o);
        }
        if (!(o instanceof Map)) {
            return false;
        }
        Map<K, V> m = (Map) o;
        if (this.size != m.size()) {
            return false;
        }
        for (int i = 0; i < this.keyUniverse.length; i++) {
            if (this.vals[i] != null) {
                K key = this.keyUniverse[i];
                V value = unmaskNull(this.vals[i]);
                if (value == null) {
                    if (m.get(key) == null) {
                        z = m.containsKey(key);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return false;
                    }
                } else if (!value.equals(m.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean equals(EnumMap em) {
        if (em.keyType == this.keyType) {
            for (int i = 0; i < this.keyUniverse.length; i++) {
                Object ourValue = this.vals[i];
                Object hisValue = em.vals[i];
                if (hisValue != ourValue && (hisValue == null || !hisValue.equals(ourValue))) {
                    return false;
                }
            }
            return true;
        } else if (this.size == 0 && em.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int h = 0;
        for (int i = 0; i < this.keyUniverse.length; i++) {
            if (this.vals[i] != null) {
                h += entryHashCode(i);
            }
        }
        return h;
    }

    /* access modifiers changed from: private */
    public int entryHashCode(int index) {
        return this.keyUniverse[index].hashCode() ^ this.vals[index].hashCode();
    }

    public EnumMap<K, V> clone() {
        try {
            EnumMap<K, V> result = (EnumMap) super.clone();
            result.vals = (Object[]) result.vals.clone();
            result.entrySet = null;
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private void typeCheck(K key) {
        Class keyClass = key.getClass();
        if (keyClass != this.keyType && keyClass.getSuperclass() != this.keyType) {
            throw new ClassCastException(keyClass + " != " + this.keyType);
        }
    }

    private static <K extends Enum<K>> K[] getKeyUniverse(Class<K> keyType2) {
        return JavaLangAccess.getEnumConstantsShared(keyType2);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.size);
        int entriesToBeWritten = this.size;
        int i = 0;
        while (entriesToBeWritten > 0) {
            if (this.vals[i] != null) {
                s.writeObject(this.keyUniverse[i]);
                s.writeObject(unmaskNull(this.vals[i]));
                entriesToBeWritten--;
            }
            i++;
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.keyUniverse = getKeyUniverse(this.keyType);
        this.vals = new Object[this.keyUniverse.length];
        int size2 = s.readInt();
        for (int i = 0; i < size2; i++) {
            put((Enum) s.readObject(), s.readObject());
        }
    }
}
