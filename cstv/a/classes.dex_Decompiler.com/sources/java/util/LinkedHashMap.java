package java.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {
    private static final long serialVersionUID = 3801124242820219131L;
    /* access modifiers changed from: private */
    public final boolean accessOrder;
    /* access modifiers changed from: private */
    public transient LinkedHashMapEntry<K, V> header;

    public LinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        this.accessOrder = false;
    }

    public LinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        this.accessOrder = false;
    }

    public LinkedHashMap() {
        this.accessOrder = false;
    }

    public LinkedHashMap(Map<? extends K, ? extends V> m) {
        super(m);
        this.accessOrder = false;
    }

    public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder2) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder2;
    }

    /* access modifiers changed from: package-private */
    public void init() {
        this.header = new LinkedHashMapEntry<>(-1, null, null, (HashMap.HashMapEntry) null);
        LinkedHashMapEntry<K, V> linkedHashMapEntry = this.header;
        LinkedHashMapEntry<K, V> linkedHashMapEntry2 = this.header;
        this.header.after = linkedHashMapEntry2;
        linkedHashMapEntry.before = linkedHashMapEntry2;
    }

    /* access modifiers changed from: package-private */
    public void transfer(HashMap.HashMapEntry[] newTable) {
        int newCapacity = newTable.length;
        for (LinkedHashMapEntry<K, V> e = this.header.after; e != this.header; e = e.after) {
            int index = indexFor(e.hash, newCapacity);
            e.next = newTable[index];
            newTable[index] = e;
        }
    }

    public boolean containsValue(Object value) {
        if (value == null) {
            for (LinkedHashMapEntry e = this.header.after; e != this.header; e = e.after) {
                if (e.value == null) {
                    return true;
                }
            }
            return false;
        }
        for (LinkedHashMapEntry e2 = this.header.after; e2 != this.header; e2 = e2.after) {
            if (value.equals(e2.value)) {
                return true;
            }
        }
        return false;
    }

    public V get(Object key) {
        LinkedHashMapEntry<K, V> e = (LinkedHashMapEntry) getEntry(key);
        if (e == null) {
            return null;
        }
        e.recordAccess(this);
        return e.value;
    }

    public void clear() {
        super.clear();
        LinkedHashMapEntry<K, V> linkedHashMapEntry = this.header;
        LinkedHashMapEntry<K, V> linkedHashMapEntry2 = this.header;
        this.header.after = linkedHashMapEntry2;
        linkedHashMapEntry.before = linkedHashMapEntry2;
    }

    private static class LinkedHashMapEntry<K, V> extends HashMap.HashMapEntry<K, V> {
        LinkedHashMapEntry<K, V> after;
        LinkedHashMapEntry<K, V> before;

        LinkedHashMapEntry(int hash, K key, V value, HashMap.HashMapEntry<K, V> next) {
            super(hash, key, value, next);
        }

        private void remove() {
            this.before.after = this.after;
            this.after.before = this.before;
        }

        /* access modifiers changed from: private */
        public void addBefore(LinkedHashMapEntry<K, V> existingEntry) {
            this.after = existingEntry;
            this.before = existingEntry.before;
            this.before.after = this;
            this.after.before = this;
        }

        /* access modifiers changed from: package-private */
        public void recordAccess(HashMap<K, V> m) {
            LinkedHashMap<K, V> lm = (LinkedHashMap) m;
            if (lm.accessOrder) {
                lm.modCount++;
                remove();
                addBefore(lm.header);
            }
        }

        /* access modifiers changed from: package-private */
        public void recordRemoval(HashMap<K, V> hashMap) {
            remove();
        }
    }

    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        int expectedModCount;
        LinkedHashMapEntry<K, V> lastReturned;
        LinkedHashMapEntry<K, V> nextEntry;

        /* synthetic */ LinkedHashIterator(LinkedHashMap this$02, LinkedHashIterator linkedHashIterator) {
            this();
        }

        private LinkedHashIterator() {
            this.nextEntry = LinkedHashMap.this.header.after;
            this.lastReturned = null;
            this.expectedModCount = LinkedHashMap.this.modCount;
        }

        public boolean hasNext() {
            return this.nextEntry != LinkedHashMap.this.header;
        }

        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            } else if (LinkedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                LinkedHashMap.this.remove(this.lastReturned.key);
                this.lastReturned = null;
                this.expectedModCount = LinkedHashMap.this.modCount;
            }
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, V> nextEntry() {
            if (LinkedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else if (this.nextEntry == LinkedHashMap.this.header) {
                throw new NoSuchElementException();
            } else {
                LinkedHashMapEntry<K, V> e = this.nextEntry;
                this.lastReturned = e;
                this.nextEntry = e.after;
                return e;
            }
        }
    }

    private class KeyIterator extends LinkedHashMap<K, V>.LinkedHashIterator<K> {
        /* synthetic */ KeyIterator(LinkedHashMap this$02, KeyIterator keyIterator) {
            this();
        }

        private KeyIterator() {
            super(LinkedHashMap.this, (LinkedHashIterator) null);
        }

        public K next() {
            return nextEntry().getKey();
        }
    }

    private class ValueIterator extends LinkedHashMap<K, V>.LinkedHashIterator<V> {
        /* synthetic */ ValueIterator(LinkedHashMap this$02, ValueIterator valueIterator) {
            this();
        }

        private ValueIterator() {
            super(LinkedHashMap.this, (LinkedHashIterator) null);
        }

        public V next() {
            return nextEntry().getValue();
        }
    }

    private class EntryIterator extends LinkedHashMap<K, V>.LinkedHashIterator<Map.Entry<K, V>> {
        /* synthetic */ EntryIterator(LinkedHashMap this$02, EntryIterator entryIterator) {
            this();
        }

        private EntryIterator() {
            super(LinkedHashMap.this, (LinkedHashIterator) null);
        }

        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> newKeyIterator() {
        return new KeyIterator(this, (KeyIterator) null);
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> newValueIterator() {
        return new ValueIterator(this, (ValueIterator) null);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator(this, (EntryIterator) null);
    }

    /* access modifiers changed from: package-private */
    public void addEntry(int hash, K key, V value, int bucketIndex) {
        LinkedHashMapEntry<K, V> eldest = this.header.after;
        if (eldest != this.header) {
            this.size++;
            try {
                if (removeEldestEntry(eldest)) {
                    removeEntryForKey(eldest.key);
                }
            } finally {
                this.size--;
            }
        }
        super.addEntry(hash, key, value, bucketIndex);
    }

    public Map.Entry<K, V> eldest() {
        Map.Entry<K, V> eldest = this.header.after;
        if (eldest != this.header) {
            return eldest;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void createEntry(int hash, K key, V value, int bucketIndex) {
        LinkedHashMapEntry<K, V> e = new LinkedHashMapEntry<>(hash, key, value, this.table[bucketIndex]);
        this.table[bucketIndex] = e;
        e.addBefore(this.header);
        this.size++;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return false;
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        int mc = this.modCount;
        LinkedHashMapEntry<K, V> e = this.header.after;
        while (this.modCount == mc && e != this.header) {
            action.accept(e.key, e.value);
            e = e.after;
        }
        if (this.modCount != mc) {
            throw new ConcurrentModificationException();
        }
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        int mc = this.modCount;
        LinkedHashMapEntry<K, V> e = this.header.after;
        while (this.modCount == mc && e != this.header) {
            e.value = function.apply(e.key, e.value);
            e = e.after;
        }
        if (this.modCount != mc) {
            throw new ConcurrentModificationException();
        }
    }
}
