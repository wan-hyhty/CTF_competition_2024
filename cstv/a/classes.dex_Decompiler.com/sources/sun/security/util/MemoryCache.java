package sun.security.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import sun.security.util.Cache;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
/* compiled from: Cache */
class MemoryCache<K, V> extends Cache<K, V> {
    private static final boolean DEBUG = false;
    private static final float LOAD_FACTOR = 0.75f;
    private final Map<K, CacheEntry<K, V>> cacheMap;
    private long lifetime;
    private int maxSize;
    private final ReferenceQueue<V> queue;

    /* compiled from: Cache */
    private interface CacheEntry<K, V> {
        K getKey();

        V getValue();

        void invalidate();

        boolean isValid(long j);
    }

    /* compiled from: Cache */
    private static class HardCacheEntry<K, V> implements CacheEntry<K, V> {
        private long expirationTime;
        private K key;
        private V value;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.util.MemoryCache.HardCacheEntry.<init>(java.lang.Object, java.lang.Object, long):void, dex: classes.dex
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
        HardCacheEntry(K r1, V r2, long r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.util.MemoryCache.HardCacheEntry.<init>(java.lang.Object, java.lang.Object, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.util.MemoryCache.HardCacheEntry.<init>(java.lang.Object, java.lang.Object, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.util.MemoryCache.HardCacheEntry.getKey():K, dex: classes.dex
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
        public K getKey() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.util.MemoryCache.HardCacheEntry.getKey():K, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.util.MemoryCache.HardCacheEntry.getKey():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.util.MemoryCache.HardCacheEntry.getValue():V, dex: classes.dex
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
        public V getValue() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.util.MemoryCache.HardCacheEntry.getValue():V, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.util.MemoryCache.HardCacheEntry.getValue():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.util.MemoryCache.HardCacheEntry.invalidate():void, dex: classes.dex
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
        public void invalidate() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.util.MemoryCache.HardCacheEntry.invalidate():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.util.MemoryCache.HardCacheEntry.invalidate():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: sun.security.util.MemoryCache.HardCacheEntry.isValid(long):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean isValid(long r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: sun.security.util.MemoryCache.HardCacheEntry.isValid(long):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.util.MemoryCache.HardCacheEntry.isValid(long):boolean");
        }
    }

    public MemoryCache(boolean soft, int maxSize2) {
        this(soft, maxSize2, 0);
    }

    public MemoryCache(boolean soft, int maxSize2, int lifetime2) {
        this.maxSize = maxSize2;
        this.lifetime = (long) (lifetime2 * 1000);
        if (soft) {
            this.queue = new ReferenceQueue<>();
        } else {
            this.queue = null;
        }
        this.cacheMap = new LinkedHashMap(((int) (((float) maxSize2) / LOAD_FACTOR)) + 1, LOAD_FACTOR, true);
    }

    private void emptyQueue() {
        CacheEntry<K, V> currentEntry;
        if (this.queue != null) {
            int size = this.cacheMap.size();
            while (true) {
                CacheEntry<K, V> entry = (CacheEntry) this.queue.poll();
                if (entry != null) {
                    K key = entry.getKey();
                    if (!(key == null || (currentEntry = this.cacheMap.remove(key)) == null || entry == currentEntry)) {
                        this.cacheMap.put(key, currentEntry);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void expungeExpiredEntries() {
        emptyQueue();
        if (this.lifetime != 0) {
            int cnt = 0;
            long time = System.currentTimeMillis();
            Iterator<CacheEntry<K, V>> t = this.cacheMap.values().iterator();
            while (t.hasNext()) {
                if (!t.next().isValid(time)) {
                    t.remove();
                    cnt++;
                }
            }
        }
    }

    public synchronized int size() {
        expungeExpiredEntries();
        return this.cacheMap.size();
    }

    public synchronized void clear() {
        if (this.queue != null) {
            for (CacheEntry<K, V> entry : this.cacheMap.values()) {
                entry.invalidate();
            }
            do {
            } while (this.queue.poll() != null);
        }
        this.cacheMap.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(K r13, V r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            r12.emptyQueue()     // Catch:{ all -> 0x0062 }
            long r2 = r12.lifetime     // Catch:{ all -> 0x0062 }
            r10 = 0
            int r1 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x0026
            r4 = 0
        L_0x000e:
            java.lang.ref.ReferenceQueue<V> r6 = r12.queue     // Catch:{ all -> 0x0062 }
            r1 = r12
            r2 = r13
            r3 = r14
            sun.security.util.MemoryCache$CacheEntry r7 = r1.newEntry(r2, r3, r4, r6)     // Catch:{ all -> 0x0062 }
            java.util.Map<K, sun.security.util.MemoryCache$CacheEntry<K, V>> r1 = r12.cacheMap     // Catch:{ all -> 0x0062 }
            java.lang.Object r8 = r1.put(r13, r7)     // Catch:{ all -> 0x0062 }
            sun.security.util.MemoryCache$CacheEntry r8 = (sun.security.util.MemoryCache.CacheEntry) r8     // Catch:{ all -> 0x0062 }
            if (r8 == 0) goto L_0x002f
            r8.invalidate()     // Catch:{ all -> 0x0062 }
            monitor-exit(r12)
            return
        L_0x0026:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0062 }
            long r10 = r12.lifetime     // Catch:{ all -> 0x0062 }
            long r4 = r2 + r10
            goto L_0x000e
        L_0x002f:
            int r1 = r12.maxSize     // Catch:{ all -> 0x0062 }
            if (r1 <= 0) goto L_0x0060
            java.util.Map<K, sun.security.util.MemoryCache$CacheEntry<K, V>> r1 = r12.cacheMap     // Catch:{ all -> 0x0062 }
            int r1 = r1.size()     // Catch:{ all -> 0x0062 }
            int r2 = r12.maxSize     // Catch:{ all -> 0x0062 }
            if (r1 <= r2) goto L_0x0060
            r12.expungeExpiredEntries()     // Catch:{ all -> 0x0062 }
            java.util.Map<K, sun.security.util.MemoryCache$CacheEntry<K, V>> r1 = r12.cacheMap     // Catch:{ all -> 0x0062 }
            int r1 = r1.size()     // Catch:{ all -> 0x0062 }
            int r2 = r12.maxSize     // Catch:{ all -> 0x0062 }
            if (r1 <= r2) goto L_0x0060
            java.util.Map<K, sun.security.util.MemoryCache$CacheEntry<K, V>> r1 = r12.cacheMap     // Catch:{ all -> 0x0062 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0062 }
            java.util.Iterator r9 = r1.iterator()     // Catch:{ all -> 0x0062 }
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x0062 }
            sun.security.util.MemoryCache$CacheEntry r0 = (sun.security.util.MemoryCache.CacheEntry) r0     // Catch:{ all -> 0x0062 }
            r9.remove()     // Catch:{ all -> 0x0062 }
            r0.invalidate()     // Catch:{ all -> 0x0062 }
        L_0x0060:
            monitor-exit(r12)
            return
        L_0x0062:
            r1 = move-exception
            monitor-exit(r12)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.util.MemoryCache.put(java.lang.Object, java.lang.Object):void");
    }

    public synchronized V get(Object key) {
        long time = 0;
        synchronized (this) {
            emptyQueue();
            CacheEntry<K, V> entry = this.cacheMap.get(key);
            if (entry == null) {
                return null;
            }
            if (this.lifetime != 0) {
                time = System.currentTimeMillis();
            }
            if (!entry.isValid(time)) {
                this.cacheMap.remove(key);
                return null;
            }
            V value = entry.getValue();
            return value;
        }
    }

    public synchronized void remove(Object key) {
        emptyQueue();
        CacheEntry<K, V> entry = this.cacheMap.remove(key);
        if (entry != null) {
            entry.invalidate();
        }
    }

    public synchronized void setCapacity(int size) {
        expungeExpiredEntries();
        if (size > 0 && this.cacheMap.size() > size) {
            Iterator<CacheEntry<K, V>> t = this.cacheMap.values().iterator();
            for (int i = this.cacheMap.size() - size; i > 0; i--) {
                t.remove();
                t.next().invalidate();
            }
        }
        if (size <= 0) {
            size = 0;
        }
        this.maxSize = size;
    }

    public synchronized void setTimeout(int timeout) {
        emptyQueue();
        this.lifetime = timeout > 0 ? ((long) timeout) * 1000 : 0;
    }

    public synchronized void accept(Cache.CacheVisitor<K, V> visitor) {
        expungeExpiredEntries();
        visitor.visit(getCachedEntries());
    }

    private Map<K, V> getCachedEntries() {
        Map<K, V> kvmap = new HashMap<>(this.cacheMap.size());
        for (CacheEntry<K, V> entry : this.cacheMap.values()) {
            kvmap.put(entry.getKey(), entry.getValue());
        }
        return kvmap;
    }

    /* access modifiers changed from: protected */
    public CacheEntry<K, V> newEntry(K key, V value, long expirationTime, ReferenceQueue<V> queue2) {
        if (queue2 != null) {
            return new SoftCacheEntry(key, value, expirationTime, queue2);
        }
        return new HardCacheEntry(key, value, expirationTime);
    }

    /* compiled from: Cache */
    private static class SoftCacheEntry<K, V> extends SoftReference<V> implements CacheEntry<K, V> {
        private long expirationTime;
        private K key;

        SoftCacheEntry(K key2, V value, long expirationTime2, ReferenceQueue<V> queue) {
            super(value, queue);
            this.key = key2;
            this.expirationTime = expirationTime2;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return get();
        }

        public boolean isValid(long currentTime) {
            boolean valid = MemoryCache.DEBUG;
            if (currentTime <= this.expirationTime && get() != null) {
                valid = true;
            }
            if (!valid) {
                invalidate();
            }
            return valid;
        }

        public void invalidate() {
            clear();
            this.key = null;
            this.expirationTime = -1;
        }
    }
}
