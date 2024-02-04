package java.util;

public class Observable {
    private boolean changed = false;
    private final ArrayList<Observer> observers = new ArrayList<>();

    public synchronized void addObserver(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        } else if (!this.observers.contains(o)) {
            this.observers.add(o);
        }
    }

    public synchronized void deleteObserver(Observer o) {
        this.observers.remove((Object) o);
    }

    public void notifyObservers() {
        notifyObservers((Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r1 < 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r0[r1].update(r4, r5);
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r1 = r0.length - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyObservers(java.lang.Object r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r2 = r4.hasChanged()     // Catch:{ all -> 0x002a }
            if (r2 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.ArrayList<java.util.Observer> r2 = r4.observers     // Catch:{ all -> 0x002a }
            java.util.ArrayList<java.util.Observer> r3 = r4.observers     // Catch:{ all -> 0x002a }
            int r3 = r3.size()     // Catch:{ all -> 0x002a }
            java.util.Observer[] r3 = new java.util.Observer[r3]     // Catch:{ all -> 0x002a }
            java.lang.Object[] r0 = r2.toArray(r3)     // Catch:{ all -> 0x002a }
            java.util.Observer[] r0 = (java.util.Observer[]) r0     // Catch:{ all -> 0x002a }
            r4.clearChanged()     // Catch:{ all -> 0x002a }
            monitor-exit(r4)
            int r2 = r0.length
            int r1 = r2 + -1
        L_0x0020:
            if (r1 < 0) goto L_0x002d
            r2 = r0[r1]
            r2.update(r4, r5)
            int r1 = r1 + -1
            goto L_0x0020
        L_0x002a:
            r2 = move-exception
            monitor-exit(r4)
            throw r2
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Observable.notifyObservers(java.lang.Object):void");
    }

    public synchronized void deleteObservers() {
        this.observers.clear();
    }

    /* access modifiers changed from: protected */
    public synchronized void setChanged() {
        this.changed = true;
    }

    /* access modifiers changed from: protected */
    public synchronized void clearChanged() {
        this.changed = false;
    }

    public synchronized boolean hasChanged() {
        return this.changed;
    }

    public synchronized int countObservers() {
        return this.observers.size();
    }
}
