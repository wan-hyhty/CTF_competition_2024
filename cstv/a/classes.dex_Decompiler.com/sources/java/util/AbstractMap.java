package java.util;

import java.io.Serializable;
import java.util.Map;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    volatile transient Set<K> keySet = null;
    volatile transient Collection<V> values = null;

    public abstract Set<Map.Entry<K, V>> entrySet();

    protected AbstractMap() {
    }

    public int size() {
        return entrySet().size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsValue(Object value) {
        Iterator<Map.Entry<K, V>> i = entrySet().iterator();
        if (value == null) {
            while (i.hasNext()) {
                if (i.next().getValue() == null) {
                    return true;
                }
            }
            return false;
        }
        while (i.hasNext()) {
            if (value.equals(i.next().getValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(Object key) {
        Iterator<Map.Entry<K, V>> i = entrySet().iterator();
        if (key == null) {
            while (i.hasNext()) {
                if (i.next().getKey() == null) {
                    return true;
                }
            }
            return false;
        }
        while (i.hasNext()) {
            if (key.equals(i.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    public V get(Object key) {
        Iterator<Map.Entry<K, V>> i = entrySet().iterator();
        if (key == null) {
            while (i.hasNext()) {
                Map.Entry<K, V> e = i.next();
                if (e.getKey() == null) {
                    return e.getValue();
                }
            }
        } else {
            while (i.hasNext()) {
                Map.Entry<K, V> e2 = i.next();
                if (key.equals(e2.getKey())) {
                    return e2.getValue();
                }
            }
        }
        return null;
    }

    public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public V remove(Object key) {
        Iterator<Map.Entry<K, V>> i = entrySet().iterator();
        Map.Entry<K, V> correctEntry = null;
        if (key == null) {
            while (correctEntry == null && i.hasNext()) {
                Map.Entry<K, V> e = i.next();
                if (e.getKey() == null) {
                    correctEntry = e;
                }
            }
        } else {
            while (correctEntry == null && i.hasNext()) {
                Map.Entry<K, V> e2 = i.next();
                if (key.equals(e2.getKey())) {
                    correctEntry = e2;
                }
            }
        }
        if (correctEntry == null) {
            return null;
        }
        V oldValue = correctEntry.getValue();
        i.remove();
        return oldValue;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    public void clear() {
        entrySet().clear();
    }

    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractSet<K>() {
                public Iterator<K> iterator() {
                    return new Iterator<K>() {
                        private Iterator<Map.Entry<K, V>> i = AbstractMap.this.entrySet().iterator();

                        public boolean hasNext() {
                            return this.i.hasNext();
                        }

                        public K next() {
                            return this.i.next().getKey();
                        }

                        public void remove() {
                            this.i.remove();
                        }
                    };
                }

                public int size() {
                    return AbstractMap.this.size();
                }

                public boolean isEmpty() {
                    return AbstractMap.this.isEmpty();
                }

                public void clear() {
                    AbstractMap.this.clear();
                }

                public boolean contains(Object k) {
                    return AbstractMap.this.containsKey(k);
                }
            };
        }
        return this.keySet;
    }

    public Collection<V> values() {
        if (this.values == null) {
            this.values = new AbstractCollection<V>() {
                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        private Iterator<Map.Entry<K, V>> i = AbstractMap.this.entrySet().iterator();

                        public boolean hasNext() {
                            return this.i.hasNext();
                        }

                        public V next() {
                            return this.i.next().getValue();
                        }

                        public void remove() {
                            this.i.remove();
                        }
                    };
                }

                public int size() {
                    return AbstractMap.this.size();
                }

                public boolean isEmpty() {
                    return AbstractMap.this.isEmpty();
                }

                public void clear() {
                    AbstractMap.this.clear();
                }

                public boolean contains(Object v) {
                    return AbstractMap.this.containsValue(v);
                }
            };
        }
        return this.values;
    }

    public boolean equals(Object o) {
        boolean z;
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map)) {
            return false;
        }
        Map<K, V> m = (Map) o;
        if (m.size() != size()) {
            return false;
        }
        try {
            for (Map.Entry<K, V> e : entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
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
            return true;
        } catch (ClassCastException e2) {
            return false;
        } catch (NullPointerException e3) {
            return false;
        }
    }

    public int hashCode() {
        int h = 0;
        for (Map.Entry<K, V> hashCode : entrySet()) {
            h += hashCode.hashCode();
        }
        return h;
    }

    public String toString() {
        Iterator<Map.Entry<K, V>> i = entrySet().iterator();
        if (!i.hasNext()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        while (true) {
            Map.Entry<K, V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            if (key == this) {
                key = "(this Map)";
            }
            sb.append((Object) key);
            sb.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sb.append((Object) value);
            if (!i.hasNext()) {
                return sb.append('}').toString();
            }
            sb.append(',').append(' ');
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        AbstractMap<K, V> result = (AbstractMap) super.clone();
        result.keySet = null;
        result.values = null;
        return result;
    }

    /* access modifiers changed from: private */
    public static boolean eq(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }

    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = -8499721149061103585L;
        private final K key;
        private V value;

        public SimpleEntry(K key2, V value2) {
            this.key = key2;
            this.value = value2;
        }

        public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value2) {
            V oldValue = this.value;
            this.value = value2;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry) o;
            if (AbstractMap.eq(this.key, e.getKey())) {
                return AbstractMap.eq(this.value, e.getValue());
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = 7138329143949025153L;
        private final K key;
        private final V value;

        public SimpleImmutableEntry(K key2, V value2) {
            this.key = key2;
            this.value = value2;
        }

        public SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry) o;
            if (AbstractMap.eq(this.key, e.getKey())) {
                return AbstractMap.eq(this.value, e.getValue());
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}
