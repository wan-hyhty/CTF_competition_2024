package java.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import sun.misc.Hashing;

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
public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final Object NULL_KEY = null;
    private transient Set<Map.Entry<K, V>> entrySet;
    private final float loadFactor;
    int modCount;
    private final ReferenceQueue<Object> queue;
    private int size;
    Entry<K, V>[] table;
    private int threshold;

    static class WeakHashMapSpliterator<K, V> {
        Entry<K, V> current;
        int est;
        int expectedModCount;
        int fence;
        int index;
        final WeakHashMap<K, V> map;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.WeakHashMap.WeakHashMapSpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
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
        WeakHashMapSpliterator(java.util.WeakHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.WeakHashMap.WeakHashMapSpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.WeakHashMapSpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.WeakHashMapSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public final long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.WeakHashMapSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.WeakHashMapSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.WeakHashMap.WeakHashMapSpliterator.getFence():int, dex: classes.dex in method: java.util.WeakHashMap.WeakHashMapSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.WeakHashMap.WeakHashMapSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        final int getFence() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.WeakHashMap.WeakHashMapSpliterator.getFence():int, dex: classes.dex in method: java.util.WeakHashMap.WeakHashMapSpliterator.getFence():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.WeakHashMapSpliterator.getFence():int");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.<clinit>():void");
    }

    private Entry<K, V>[] newTable(int n) {
        return new Entry[n];
    }

    public WeakHashMap(int initialCapacity, float loadFactor2) {
        this.queue = new ReferenceQueue<>();
        this.entrySet = null;
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Initial Capacity: " + initialCapacity);
        }
        initialCapacity = initialCapacity > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : initialCapacity;
        if (loadFactor2 <= 0.0f || Float.isNaN(loadFactor2)) {
            throw new IllegalArgumentException("Illegal Load factor: " + loadFactor2);
        }
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        this.table = newTable(capacity);
        this.loadFactor = loadFactor2;
        this.threshold = (int) (((float) capacity) * loadFactor2);
    }

    public WeakHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public WeakHashMap() {
        this(16, DEFAULT_LOAD_FACTOR);
    }

    public WeakHashMap(Map<? extends K, ? extends V> m) {
        this(Math.max(((int) (((float) m.size()) / DEFAULT_LOAD_FACTOR)) + 1, 16), DEFAULT_LOAD_FACTOR);
        putAll(m);
    }

    private static Object maskNull(Object key) {
        return key == null ? NULL_KEY : key;
    }

    static Object unmaskNull(Object key) {
        if (key == NULL_KEY) {
            return null;
        }
        return key;
    }

    private static boolean eq(Object x, Object y) {
        if (x != y) {
            return x.equals(y);
        }
        return true;
    }

    private static int indexFor(int h, int length) {
        return (length - 1) & h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r5 != r1) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r10.table[r2] = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r1.value = null;
        r10.size--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r5.next = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void expungeStaleEntries() {
        /*
            r10 = this;
        L_0x0000:
            java.lang.ref.ReferenceQueue<java.lang.Object> r7 = r10.queue
            java.lang.ref.Reference r6 = r7.poll()
            if (r6 == 0) goto L_0x003d
            java.lang.ref.ReferenceQueue<java.lang.Object> r8 = r10.queue
            monitor-enter(r8)
            r0 = r6
            java.util.WeakHashMap$Entry r0 = (java.util.WeakHashMap.Entry) r0     // Catch:{ all -> 0x0037 }
            r1 = r0
            int r7 = r1.hash     // Catch:{ all -> 0x0037 }
            java.util.WeakHashMap$Entry<K, V>[] r9 = r10.table     // Catch:{ all -> 0x0037 }
            int r9 = r9.length     // Catch:{ all -> 0x0037 }
            int r2 = indexFor(r7, r9)     // Catch:{ all -> 0x0037 }
            java.util.WeakHashMap$Entry<K, V>[] r7 = r10.table     // Catch:{ all -> 0x0037 }
            r5 = r7[r2]     // Catch:{ all -> 0x0037 }
            r4 = r5
        L_0x001d:
            if (r4 == 0) goto L_0x0032
            java.util.WeakHashMap$Entry<K, V> r3 = r4.next     // Catch:{ all -> 0x0037 }
            if (r4 != r1) goto L_0x003a
            if (r5 != r1) goto L_0x0034
            java.util.WeakHashMap$Entry<K, V>[] r7 = r10.table     // Catch:{ all -> 0x0037 }
            r7[r2] = r3     // Catch:{ all -> 0x0037 }
        L_0x0029:
            r7 = 0
            r1.value = r7     // Catch:{ all -> 0x0037 }
            int r7 = r10.size     // Catch:{ all -> 0x0037 }
            int r7 = r7 + -1
            r10.size = r7     // Catch:{ all -> 0x0037 }
        L_0x0032:
            monitor-exit(r8)
            goto L_0x0000
        L_0x0034:
            r5.next = r3     // Catch:{ all -> 0x0037 }
            goto L_0x0029
        L_0x0037:
            r7 = move-exception
            monitor-exit(r8)
            throw r7
        L_0x003a:
            r5 = r4
            r4 = r3
            goto L_0x001d
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.expungeStaleEntries():void");
    }

    private Entry<K, V>[] getTable() {
        expungeStaleEntries();
        return this.table;
    }

    public int size() {
        if (this.size == 0) {
            return 0;
        }
        expungeStaleEntries();
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V get(Object key) {
        Object k = maskNull(key);
        int h = Hashing.singleWordWangJenkinsHash(k);
        Entry<K, V>[] tab = getTable();
        for (Entry<K, V> e = tab[indexFor(h, tab.length)]; e != null; e = e.next) {
            if (e.hash == h && eq(k, e.get())) {
                return e.value;
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    /* access modifiers changed from: package-private */
    public Entry<K, V> getEntry(Object key) {
        Object k = maskNull(key);
        int h = Hashing.singleWordWangJenkinsHash(k);
        Entry<K, V>[] tab = getTable();
        Entry<K, V> e = tab[indexFor(h, tab.length)];
        while (e != null && (e.hash != h || !eq(k, e.get()))) {
            e = e.next;
        }
        return e;
    }

    public V put(K key, V value) {
        Object k = maskNull(key);
        int h = Hashing.singleWordWangJenkinsHash(k);
        Entry<K, V>[] tab = getTable();
        int i = indexFor(h, tab.length);
        Entry<K, V> e = tab[i];
        while (e != null) {
            if (h != e.hash || !eq(k, e.get())) {
                e = e.next;
            } else {
                V oldValue = e.value;
                if (value != oldValue) {
                    e.value = value;
                }
                return oldValue;
            }
        }
        this.modCount++;
        tab[i] = new Entry<>(k, value, this.queue, h, tab[i]);
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.threshold) {
            resize(tab.length * 2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void resize(int newCapacity) {
        Entry<K, V>[] oldTable = getTable();
        if (oldTable.length == MAXIMUM_CAPACITY) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        Entry<K, V>[] newTable = newTable(newCapacity);
        transfer(oldTable, newTable);
        this.table = newTable;
        if (this.size >= this.threshold / 2) {
            this.threshold = (int) (((float) newCapacity) * this.loadFactor);
            return;
        }
        expungeStaleEntries();
        transfer(newTable, oldTable);
        this.table = oldTable;
    }

    private void transfer(Entry<K, V>[] src, Entry<K, V>[] dest) {
        for (int j = 0; j < src.length; j++) {
            Entry<K, V> e = src[j];
            src[j] = null;
            while (e != null) {
                Entry<K, V> next = e.next;
                if (e.get() == null) {
                    e.next = null;
                    e.value = null;
                    this.size--;
                } else {
                    int i = indexFor(e.hash, dest.length);
                    e.next = dest[i];
                    dest[i] = e;
                }
                e = next;
            }
        }
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        int numKeysToBeAdded = m.size();
        if (numKeysToBeAdded != 0) {
            if (numKeysToBeAdded > this.threshold) {
                int targetCapacity = (int) ((((float) numKeysToBeAdded) / this.loadFactor) + 1.0f);
                if (targetCapacity > MAXIMUM_CAPACITY) {
                    targetCapacity = MAXIMUM_CAPACITY;
                }
                int newCapacity = this.table.length;
                while (newCapacity < targetCapacity) {
                    newCapacity <<= 1;
                }
                if (newCapacity > this.table.length) {
                    resize(newCapacity);
                }
            }
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                put(e.getKey(), e.getValue());
            }
        }
    }

    public V remove(Object key) {
        Object k = maskNull(key);
        int h = Hashing.singleWordWangJenkinsHash(k);
        Entry<K, V>[] tab = getTable();
        int i = indexFor(h, tab.length);
        Entry<K, V> prev = tab[i];
        Entry<K, V> e = prev;
        while (e != null) {
            Entry<K, V> next = e.next;
            if (h != e.hash || !eq(k, e.get())) {
                prev = e;
                e = next;
            } else {
                this.modCount++;
                this.size--;
                if (prev == e) {
                    tab[i] = next;
                } else {
                    prev.next = next;
                }
                return e.value;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean removeMapping(Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Entry<K, V>[] tab = getTable();
        Map.Entry<?, ?> entry = (Map.Entry) o;
        int h = Hashing.singleWordWangJenkinsHash(maskNull(entry.getKey()));
        int i = indexFor(h, tab.length);
        Entry<K, V> prev = tab[i];
        Entry<K, V> e = prev;
        while (e != null) {
            Entry<K, V> next = e.next;
            if (h != e.hash || !e.equals(entry)) {
                prev = e;
                e = next;
            } else {
                this.modCount++;
                this.size--;
                if (prev == e) {
                    tab[i] = next;
                    return true;
                }
                prev.next = next;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        do {
        } while (this.queue.poll() != null);
        this.modCount++;
        Arrays.fill((Object[]) this.table, (Object) null);
        this.size = 0;
        do {
        } while (this.queue.poll() != null);
    }

    public boolean containsValue(Object value) {
        if (value == null) {
            return containsNullValue();
        }
        Entry<K, V>[] tab = getTable();
        int i = tab.length;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 <= 0) {
                return false;
            }
            for (Entry<K, V> e = tab[i]; e != null; e = e.next) {
                if (value.equals(e.value)) {
                    return true;
                }
            }
        }
    }

    private boolean containsNullValue() {
        Entry<K, V>[] tab = getTable();
        int i = tab.length;
        while (true) {
            int i2 = i;
            i = i2 - 1;
            if (i2 <= 0) {
                return false;
            }
            for (Entry<K, V> e = tab[i]; e != null; e = e.next) {
                if (e.value == null) {
                    return true;
                }
            }
        }
    }

    private static class Entry<K, V> extends WeakReference<Object> implements Map.Entry<K, V> {
        int hash;
        Entry<K, V> next;
        V value;

        Entry(Object key, V value2, ReferenceQueue<Object> queue, int hash2, Entry<K, V> next2) {
            super(key, queue);
            this.value = value2;
            this.hash = hash2;
            this.next = next2;
        }

        public K getKey() {
            return WeakHashMap.unmaskNull(get());
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2) {
                    return true;
                }
                if (v1 == null || !v1.equals(v2)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            K k = getKey();
            V v = getValue();
            int hashCode = k == null ? 0 : k.hashCode();
            if (v != null) {
                i = v.hashCode();
            }
            return i ^ hashCode;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    private abstract class HashIterator<T> implements Iterator<T> {
        private Object currentKey;
        private Entry<K, V> entry;
        private int expectedModCount;
        private int index;
        private Entry<K, V> lastReturned;
        private Object nextKey;
        final /* synthetic */ WeakHashMap this$0;

        HashIterator(WeakHashMap this$02) {
            this.this$0 = this$02;
            this.entry = null;
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
            this.nextKey = null;
            this.currentKey = null;
            this.index = this$02.isEmpty() ? 0 : this$02.table.length;
        }

        public boolean hasNext() {
            Entry<K, V>[] t = this.this$0.table;
            while (this.nextKey == null) {
                Entry<K, V> e = this.entry;
                int i = this.index;
                while (e == null && i > 0) {
                    i--;
                    e = t[i];
                }
                this.entry = e;
                this.index = i;
                if (e == null) {
                    this.currentKey = null;
                    return false;
                }
                this.nextKey = e.get();
                if (this.nextKey == null) {
                    this.entry = this.entry.next;
                }
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public Entry<K, V> nextEntry() {
            if (this.this$0.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else if (this.nextKey != null || hasNext()) {
                this.lastReturned = this.entry;
                this.entry = this.entry.next;
                this.currentKey = this.nextKey;
                this.nextKey = null;
                return this.lastReturned;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            } else if (this.this$0.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                this.this$0.remove(this.currentKey);
                this.expectedModCount = this.this$0.modCount;
                this.lastReturned = null;
                this.currentKey = null;
            }
        }
    }

    private class ValueIterator extends WeakHashMap<K, V>.HashIterator<V> {
        final /* synthetic */ WeakHashMap this$0;

        /* synthetic */ ValueIterator(WeakHashMap this$02, ValueIterator valueIterator) {
            this(this$02);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private ValueIterator(WeakHashMap this$02) {
            super(this$02);
            this.this$0 = this$02;
        }

        public V next() {
            return nextEntry().value;
        }
    }

    private class KeyIterator extends WeakHashMap<K, V>.HashIterator<K> {
        final /* synthetic */ WeakHashMap this$0;

        /* synthetic */ KeyIterator(WeakHashMap this$02, KeyIterator keyIterator) {
            this(this$02);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private KeyIterator(WeakHashMap this$02) {
            super(this$02);
            this.this$0 = this$02;
        }

        public K next() {
            return nextEntry().getKey();
        }
    }

    private class EntryIterator extends WeakHashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        /* synthetic */ EntryIterator(WeakHashMap this$02, EntryIterator entryIterator) {
            this();
        }

        private EntryIterator() {
            super(WeakHashMap.this);
        }

        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        Set<K> ks2 = new KeySet(this, (KeySet) null);
        this.keySet = ks2;
        return ks2;
    }

    private class KeySet extends AbstractSet<K> {
        final /* synthetic */ WeakHashMap this$0;

        /* synthetic */ KeySet(WeakHashMap this$02, KeySet keySet) {
            this(this$02);
        }

        private KeySet(WeakHashMap this$02) {
            this.this$0 = this$02;
        }

        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0, (KeyIterator) null);
        }

        public int size() {
            return this.this$0.size();
        }

        public boolean contains(Object o) {
            return this.this$0.containsKey(o);
        }

        public boolean remove(Object o) {
            if (!this.this$0.containsKey(o)) {
                return false;
            }
            this.this$0.remove(o);
            return true;
        }

        public void clear() {
            this.this$0.clear();
        }

        public Spliterator<K> spliterator() {
            return new KeySpliterator(this.this$0, 0, -1, 0, 0);
        }
    }

    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        Collection<V> vs2 = new Values(this, (Values) null);
        this.values = vs2;
        return vs2;
    }

    private class Values extends AbstractCollection<V> {
        final /* synthetic */ WeakHashMap this$0;

        /* synthetic */ Values(WeakHashMap this$02, Values values) {
            this(this$02);
        }

        private Values(WeakHashMap this$02) {
            this.this$0 = this$02;
        }

        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0, (ValueIterator) null);
        }

        public int size() {
            return this.this$0.size();
        }

        public boolean contains(Object o) {
            return this.this$0.containsValue(o);
        }

        public void clear() {
            this.this$0.clear();
        }

        public Spliterator<V> spliterator() {
            return new ValueSpliterator(this.this$0, 0, -1, 0, 0);
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        Set<Map.Entry<K, V>> es2 = new EntrySet(this, (EntrySet) null);
        this.entrySet = es2;
        return es2;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        /* synthetic */ EntrySet(WeakHashMap this$02, EntrySet entrySet) {
            this();
        }

        private EntrySet() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(WeakHashMap.this, (EntryIterator) null);
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry) o;
            Entry<K, V> candidate = WeakHashMap.this.getEntry(e.getKey());
            if (candidate != null) {
                return candidate.equals(e);
            }
            return false;
        }

        public boolean remove(Object o) {
            return WeakHashMap.this.removeMapping(o);
        }

        public int size() {
            return WeakHashMap.this.size();
        }

        public void clear() {
            WeakHashMap.this.clear();
        }

        private List<Map.Entry<K, V>> deepCopy() {
            List<Map.Entry<K, V>> list = new ArrayList<>(size());
            Iterator e$iterator = iterator();
            while (e$iterator.hasNext()) {
                list.add(new AbstractMap.SimpleEntry((Map.Entry) e$iterator.next()));
            }
            return list;
        }

        public Object[] toArray() {
            return deepCopy().toArray();
        }

        public <T> T[] toArray(T[] a) {
            return deepCopy().toArray(a);
        }

        public Spliterator<Map.Entry<K, V>> spliterator() {
            return new EntrySpliterator(WeakHashMap.this, 0, -1, 0, 0);
        }
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        int expectedModCount = this.modCount;
        for (Entry<K, V> entry : getTable()) {
            while (entry != null) {
                Object key = entry.get();
                if (key != null) {
                    action.accept(unmaskNull(key), entry.value);
                }
                entry = entry.next;
                if (expectedModCount != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        int expectedModCount = this.modCount;
        for (Entry<K, V> entry : getTable()) {
            while (entry != null) {
                Object key = entry.get();
                if (key != null) {
                    entry.value = function.apply(unmaskNull(key), entry.value);
                }
                entry = entry.next;
                if (expectedModCount != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    static final class KeySpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<K> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.KeySpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        KeySpliterator(java.util.WeakHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.KeySpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.KeySpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super K> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super K> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.Spliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.WeakHashMap$KeySpliterator<K, V>, dex: classes.dex in method: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.WeakHashMap$KeySpliterator<K, V>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.WeakHashMap$KeySpliterator<K, V>, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$34.decode(InstructionCodec.java:756)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public java.util.WeakHashMap.KeySpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.WeakHashMap$KeySpliterator<K, V>, dex: classes.dex in method: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.WeakHashMap$KeySpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.KeySpliterator.trySplit():java.util.WeakHashMap$KeySpliterator");
        }

        public int characteristics() {
            return 1;
        }
    }

    static final class ValueSpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<V> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.ValueSpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        ValueSpliterator(java.util.WeakHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.ValueSpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.ValueSpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super V> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super V> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.Spliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.WeakHashMap$ValueSpliterator<K, V>, dex: classes.dex in method: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.WeakHashMap$ValueSpliterator<K, V>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.WeakHashMap$ValueSpliterator<K, V>, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$34.decode(InstructionCodec.java:756)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public java.util.WeakHashMap.ValueSpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.WeakHashMap$ValueSpliterator<K, V>, dex: classes.dex in method: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.WeakHashMap$ValueSpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.ValueSpliterator.trySplit():java.util.WeakHashMap$ValueSpliterator");
        }

        public int characteristics() {
            return 0;
        }
    }

    static final class EntrySpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.EntrySpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        EntrySpliterator(java.util.WeakHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.WeakHashMap.EntrySpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.EntrySpliterator.<init>(java.util.WeakHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.WeakHashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.Spliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.WeakHashMap$EntrySpliterator<K, V>, dex: classes.dex in method: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.WeakHashMap$EntrySpliterator<K, V>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.WeakHashMap$EntrySpliterator<K, V>, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$34.decode(InstructionCodec.java:756)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public java.util.WeakHashMap.EntrySpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.WeakHashMap$EntrySpliterator<K, V>, dex: classes.dex in method: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.WeakHashMap$EntrySpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.WeakHashMap.EntrySpliterator.trySplit():java.util.WeakHashMap$EntrySpliterator");
        }

        public int characteristics() {
            return 1;
        }
    }
}
