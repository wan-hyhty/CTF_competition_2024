package java.lang;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal<T> {
    private static final int HASH_INCREMENT = 1640531527;
    private static AtomicInteger nextHashCode;
    /* access modifiers changed from: private */
    public final int threadLocalHashCode = nextHashCode();

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    /* access modifiers changed from: protected */
    public T initialValue() {
        return null;
    }

    public T get() {
        ThreadLocalMap.Entry e;
        ThreadLocalMap map = getMap(Thread.currentThread());
        if (map == null || (e = map.getEntry(this)) == null) {
            return setInitialValue();
        }
        return e.value;
    }

    private T setInitialValue() {
        T value = initialValue();
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            map.set(this, value);
        } else {
            createMap(t, value);
        }
        return value;
    }

    public void set(T value) {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            map.set(this, value);
        } else {
            createMap(t, value);
        }
    }

    public void remove() {
        ThreadLocalMap m = getMap(Thread.currentThread());
        if (m != null) {
            m.remove(this);
        }
    }

    /* access modifiers changed from: package-private */
    public ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }

    /* access modifiers changed from: package-private */
    public void createMap(Thread t, T firstValue) {
        t.threadLocals = new ThreadLocalMap(this, (Object) firstValue);
    }

    static ThreadLocalMap createInheritedMap(ThreadLocalMap parentMap) {
        return new ThreadLocalMap(parentMap, (ThreadLocalMap) null);
    }

    /* access modifiers changed from: package-private */
    public T childValue(T t) {
        throw new UnsupportedOperationException();
    }

    static class ThreadLocalMap {
        private static final int INITIAL_CAPACITY = 16;
        private int size;
        private Entry[] table;
        private int threshold;

        /* synthetic */ ThreadLocalMap(ThreadLocalMap parentMap, ThreadLocalMap threadLocalMap) {
            this(parentMap);
        }

        static class Entry extends WeakReference<ThreadLocal> {
            Object value;

            Entry(ThreadLocal k, Object v) {
                super(k);
                this.value = v;
            }
        }

        private void setThreshold(int len) {
            this.threshold = (len * 2) / 3;
        }

        private static int nextIndex(int i, int len) {
            if (i + 1 < len) {
                return i + 1;
            }
            return 0;
        }

        private static int prevIndex(int i, int len) {
            return i + -1 >= 0 ? i - 1 : len - 1;
        }

        ThreadLocalMap(ThreadLocal firstKey, Object firstValue) {
            this.size = 0;
            this.table = new Entry[16];
            this.table[firstKey.threadLocalHashCode & 15] = new Entry(firstKey, firstValue);
            this.size = 1;
            setThreshold(16);
        }

        private ThreadLocalMap(ThreadLocalMap parentMap) {
            ThreadLocal key;
            this.size = 0;
            setThreshold(len);
            this.table = new Entry[len];
            for (Entry e : parentMap.table) {
                if (!(e == null || (key = (ThreadLocal) e.get()) == null)) {
                    Entry c = new Entry(key, key.childValue(e.value));
                    int h = key.threadLocalHashCode & (len - 1);
                    while (this.table[h] != null) {
                        h = nextIndex(h, len);
                    }
                    this.table[h] = c;
                    this.size++;
                }
            }
        }

        /* access modifiers changed from: private */
        public Entry getEntry(ThreadLocal key) {
            int i = key.threadLocalHashCode & (this.table.length - 1);
            Entry e = this.table[i];
            if (e == null || e.get() != key) {
                return getEntryAfterMiss(key, i, e);
            }
            return e;
        }

        private Entry getEntryAfterMiss(ThreadLocal key, int i, Entry e) {
            Entry[] tab = this.table;
            int len = tab.length;
            while (e != null) {
                ThreadLocal k = (ThreadLocal) e.get();
                if (k == key) {
                    return e;
                }
                if (k == null) {
                    expungeStaleEntry(i);
                } else {
                    i = nextIndex(i, len);
                }
                e = tab[i];
            }
            return null;
        }

        /* access modifiers changed from: private */
        public void set(ThreadLocal key, Object value) {
            Entry[] tab = this.table;
            int len = tab.length;
            int i = key.threadLocalHashCode & (len - 1);
            Entry e = tab[i];
            while (e != null) {
                ThreadLocal k = (ThreadLocal) e.get();
                if (k == key) {
                    e.value = value;
                    return;
                } else if (k == null) {
                    replaceStaleEntry(key, value, i);
                    return;
                } else {
                    i = nextIndex(i, len);
                    e = tab[i];
                }
            }
            tab[i] = new Entry(key, value);
            int sz = this.size + 1;
            this.size = sz;
            if (!cleanSomeSlots(i, sz) && sz >= this.threshold) {
                rehash();
            }
        }

        /* access modifiers changed from: private */
        public void remove(ThreadLocal key) {
            Entry[] tab = this.table;
            int len = tab.length;
            int i = key.threadLocalHashCode & (len - 1);
            Entry e = tab[i];
            while (e != null) {
                if (e.get() == key) {
                    e.clear();
                    expungeStaleEntry(i);
                    return;
                }
                i = nextIndex(i, len);
                e = tab[i];
            }
        }

        private void replaceStaleEntry(ThreadLocal key, Object value, int staleSlot) {
            Entry[] tab = this.table;
            int len = tab.length;
            int slotToExpunge = staleSlot;
            int i = prevIndex(staleSlot, len);
            while (true) {
                Entry e = tab[i];
                if (e == null) {
                    break;
                }
                if (e.get() == null) {
                    slotToExpunge = i;
                }
                i = prevIndex(i, len);
            }
            int i2 = nextIndex(staleSlot, len);
            while (true) {
                Entry e2 = tab[i2];
                if (e2 != null) {
                    ThreadLocal k = (ThreadLocal) e2.get();
                    if (k == key) {
                        e2.value = value;
                        tab[i2] = tab[staleSlot];
                        tab[staleSlot] = e2;
                        if (slotToExpunge == staleSlot) {
                            slotToExpunge = i2;
                        }
                        cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
                        return;
                    }
                    if (k == null && slotToExpunge == staleSlot) {
                        slotToExpunge = i2;
                    }
                    i2 = nextIndex(i2, len);
                } else {
                    tab[staleSlot].value = null;
                    tab[staleSlot] = new Entry(key, value);
                    if (slotToExpunge != staleSlot) {
                        cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
                        return;
                    }
                    return;
                }
            }
        }

        private int expungeStaleEntry(int staleSlot) {
            Entry[] tab = this.table;
            int len = tab.length;
            tab[staleSlot].value = null;
            tab[staleSlot] = null;
            this.size--;
            int i = nextIndex(staleSlot, len);
            while (true) {
                Entry e = tab[i];
                if (e == null) {
                    return i;
                }
                ThreadLocal k = (ThreadLocal) e.get();
                if (k == null) {
                    e.value = null;
                    tab[i] = null;
                    this.size--;
                } else {
                    int h = k.threadLocalHashCode & (len - 1);
                    if (h != i) {
                        tab[i] = null;
                        while (tab[h] != null) {
                            h = nextIndex(h, len);
                        }
                        tab[h] = e;
                    }
                }
                i = nextIndex(i, len);
            }
        }

        private boolean cleanSomeSlots(int i, int n) {
            boolean removed = false;
            Entry[] tab = this.table;
            int len = tab.length;
            do {
                i = nextIndex(i, len);
                Entry e = tab[i];
                if (e != null && e.get() == null) {
                    n = len;
                    removed = true;
                    i = expungeStaleEntry(i);
                }
                n >>>= 1;
            } while (n != 0);
            return removed;
        }

        private void rehash() {
            expungeStaleEntries();
            if (this.size >= this.threshold - (this.threshold / 4)) {
                resize();
            }
        }

        private void resize() {
            int newLen = oldLen * 2;
            Entry[] newTab = new Entry[newLen];
            int count = 0;
            for (Entry e : this.table) {
                if (e != null) {
                    ThreadLocal k = (ThreadLocal) e.get();
                    if (k == null) {
                        e.value = null;
                    } else {
                        int h = k.threadLocalHashCode & (newLen - 1);
                        while (newTab[h] != null) {
                            h = nextIndex(h, newLen);
                        }
                        newTab[h] = e;
                        count++;
                    }
                }
            }
            setThreshold(newLen);
            this.size = count;
            this.table = newTab;
        }

        private void expungeStaleEntries() {
            Entry[] tab = this.table;
            int len = tab.length;
            for (int j = 0; j < len; j++) {
                Entry e = tab[j];
                if (e != null && e.get() == null) {
                    expungeStaleEntry(j);
                }
            }
        }
    }
}
