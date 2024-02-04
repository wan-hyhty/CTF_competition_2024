package java.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class ChangeListenerMap<L extends EventListener> {
    private Map<String, L[]> map;

    public abstract L extract(L l);

    /* access modifiers changed from: protected */
    public abstract L[] newArray(int i);

    /* access modifiers changed from: protected */
    public abstract L newProxy(String str, L l);

    ChangeListenerMap() {
    }

    public final synchronized void add(String name, L listener) {
        int size;
        if (this.map == null) {
            this.map = new HashMap();
        }
        L[] array = (EventListener[]) this.map.get(name);
        if (array != null) {
            size = array.length;
        } else {
            size = 0;
        }
        L[] clone = newArray(size + 1);
        clone[size] = listener;
        if (array != null) {
            System.arraycopy((Object) array, 0, (Object) clone, 0, size);
        }
        this.map.put(name, clone);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r3 = r0.length - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r3 <= 0) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        r1 = newArray(r3);
        java.lang.System.arraycopy((java.lang.Object) r0, 0, (java.lang.Object) r1, 0, r2);
        java.lang.System.arraycopy((java.lang.Object) r0, r2 + 1, (java.lang.Object) r1, r2, r3 - r2);
        r6.map.put(r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r6.map.remove(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r6.map.isEmpty() == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        r6.map = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void remove(java.lang.String r7, L r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.Map<java.lang.String, L[]> r4 = r6.map     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0035
            java.util.Map<java.lang.String, L[]> r4 = r6.map     // Catch:{ all -> 0x0048 }
            java.lang.Object r0 = r4.get(r7)     // Catch:{ all -> 0x0048 }
            java.util.EventListener[] r0 = (java.util.EventListener[]) r0     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0035
            r2 = 0
        L_0x0010:
            int r4 = r0.length     // Catch:{ all -> 0x0048 }
            if (r2 >= r4) goto L_0x0035
            r4 = r0[r2]     // Catch:{ all -> 0x0048 }
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x004b
            int r4 = r0.length     // Catch:{ all -> 0x0048 }
            int r3 = r4 + -1
            if (r3 <= 0) goto L_0x0037
            java.util.EventListener[] r1 = r6.newArray(r3)     // Catch:{ all -> 0x0048 }
            r4 = 0
            r5 = 0
            java.lang.System.arraycopy((java.lang.Object) r0, (int) r4, (java.lang.Object) r1, (int) r5, (int) r2)     // Catch:{ all -> 0x0048 }
            int r4 = r2 + 1
            int r5 = r3 - r2
            java.lang.System.arraycopy((java.lang.Object) r0, (int) r4, (java.lang.Object) r1, (int) r2, (int) r5)     // Catch:{ all -> 0x0048 }
            java.util.Map<java.lang.String, L[]> r4 = r6.map     // Catch:{ all -> 0x0048 }
            r4.put(r7, r1)     // Catch:{ all -> 0x0048 }
        L_0x0035:
            monitor-exit(r6)
            return
        L_0x0037:
            java.util.Map<java.lang.String, L[]> r4 = r6.map     // Catch:{ all -> 0x0048 }
            r4.remove(r7)     // Catch:{ all -> 0x0048 }
            java.util.Map<java.lang.String, L[]> r4 = r6.map     // Catch:{ all -> 0x0048 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0035
            r4 = 0
            r6.map = r4     // Catch:{ all -> 0x0048 }
            goto L_0x0035
        L_0x0048:
            r4 = move-exception
            monitor-exit(r6)
            throw r4
        L_0x004b:
            int r2 = r2 + 1
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: java.beans.ChangeListenerMap.remove(java.lang.String, java.util.EventListener):void");
    }

    public final synchronized L[] get(String name) {
        L[] lArr = null;
        synchronized (this) {
            if (this.map != null) {
                lArr = (EventListener[]) this.map.get(name);
            }
        }
        return lArr;
    }

    public final void set(String name, L[] listeners) {
        if (listeners != null) {
            if (this.map == null) {
                this.map = new HashMap();
            }
            this.map.put(name, listeners);
        } else if (this.map != null) {
            this.map.remove(name);
            if (this.map.isEmpty()) {
                this.map = null;
            }
        }
    }

    public final synchronized L[] getListeners() {
        if (this.map == null) {
            return newArray(0);
        }
        List<L> list = new ArrayList<>();
        L[] listeners = (EventListener[]) this.map.get((Object) null);
        if (listeners != null) {
            for (L listener : listeners) {
                list.add(listener);
            }
        }
        for (Map.Entry<String, L[]> entry : this.map.entrySet()) {
            String name = entry.getKey();
            if (name != null) {
                for (L listener2 : (EventListener[]) entry.getValue()) {
                    list.add(newProxy(name, listener2));
                }
            }
        }
        return (EventListener[]) list.toArray(newArray(list.size()));
    }

    public final L[] getListeners(String name) {
        L[] listeners;
        if (name == null || (listeners = get(name)) == null) {
            return newArray(0);
        }
        return (EventListener[]) listeners.clone();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean hasListeners(java.lang.String r6) {
        /*
            r5 = this;
            r1 = 1
            r2 = 0
            monitor-enter(r5)
            java.util.Map<java.lang.String, L[]> r3 = r5.map     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x0009
            monitor-exit(r5)
            return r2
        L_0x0009:
            java.util.Map<java.lang.String, L[]> r3 = r5.map     // Catch:{ all -> 0x0022 }
            r4 = 0
            java.lang.Object r0 = r3.get(r4)     // Catch:{ all -> 0x0022 }
            java.util.EventListener[] r0 = (java.util.EventListener[]) r0     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x001e
            if (r6 == 0) goto L_0x0020
            java.util.Map<java.lang.String, L[]> r3 = r5.map     // Catch:{ all -> 0x0022 }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ all -> 0x0022 }
            if (r3 == 0) goto L_0x0020
        L_0x001e:
            monitor-exit(r5)
            return r1
        L_0x0020:
            r1 = r2
            goto L_0x001e
        L_0x0022:
            r1 = move-exception
            monitor-exit(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.beans.ChangeListenerMap.hasListeners(java.lang.String):boolean");
    }

    public final Set<Map.Entry<String, L[]>> getEntries() {
        if (this.map != null) {
            return this.map.entrySet();
        }
        return Collections.emptySet();
    }
}
