package java.lang;

import java.io.PrintStream;
import java.lang.Thread;
import java.util.Arrays;
import sun.misc.VM;

public class ThreadGroup implements Thread.UncaughtExceptionHandler {
    static final ThreadGroup mainThreadGroup = null;
    static final ThreadGroup systemThreadGroup = null;
    boolean daemon;
    boolean destroyed;
    ThreadGroup[] groups;
    int maxPriority;
    int nUnstartedThreads;
    String name;
    int ngroups;
    int nthreads;
    private final ThreadGroup parent;
    Thread[] threads;
    boolean vmAllowSuspension;

    private ThreadGroup() {
        this.nUnstartedThreads = 0;
        this.name = "system";
        this.maxPriority = 10;
        this.parent = null;
    }

    public ThreadGroup(String name2) {
        this(Thread.currentThread().getThreadGroup(), name2);
    }

    public ThreadGroup(ThreadGroup parent2, String name2) {
        this(checkParentAccess(parent2), parent2, name2);
    }

    private ThreadGroup(Void unused, ThreadGroup parent2, String name2) {
        this.nUnstartedThreads = 0;
        this.name = name2;
        this.maxPriority = parent2.maxPriority;
        this.daemon = parent2.daemon;
        this.vmAllowSuspension = parent2.vmAllowSuspension;
        this.parent = parent2;
        parent2.add(this);
    }

    private static Void checkParentAccess(ThreadGroup parent2) {
        parent2.checkAccess();
        return null;
    }

    public final String getName() {
        return this.name;
    }

    public final ThreadGroup getParent() {
        if (this.parent != null) {
            this.parent.checkAccess();
        }
        return this.parent;
    }

    public final int getMaxPriority() {
        return this.maxPriority;
    }

    public final boolean isDaemon() {
        return this.daemon;
    }

    public synchronized boolean isDestroyed() {
        return this.destroyed;
    }

    public final void setDaemon(boolean daemon2) {
        checkAccess();
        this.daemon = daemon2;
    }

    public final void setMaxPriority(int pri) {
        int i;
        int ngroupsSnapshot;
        ThreadGroup[] threadGroupArr;
        synchronized (this) {
            checkAccess();
            if (pri < 1) {
                pri = 1;
            }
            if (pri > 10) {
                pri = 10;
            }
            if (this.parent != null) {
                i = Math.min(pri, this.parent.maxPriority);
            } else {
                i = pri;
            }
            this.maxPriority = i;
            ngroupsSnapshot = this.ngroups;
            if (this.groups != null) {
                threadGroupArr = (ThreadGroup[]) Arrays.copyOf((T[]) this.groups, ngroupsSnapshot);
            } else {
                threadGroupArr = null;
            }
        }
        for (int i2 = 0; i2 < ngroupsSnapshot; i2++) {
            threadGroupArr[i2].setMaxPriority(pri);
        }
    }

    public final boolean parentOf(ThreadGroup g) {
        while (g != null) {
            if (g == this) {
                return true;
            }
            g = g.parent;
        }
        return false;
    }

    public final void checkAccess() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        if (r1 >= r2) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r3 = r3 + r0[r1].activeCount();
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int activeCount() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r4 = r5.destroyed     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x0008
            r4 = 0
            monitor-exit(r5)
            return r4
        L_0x0008:
            int r3 = r5.nthreads     // Catch:{ all -> 0x0028 }
            int r2 = r5.ngroups     // Catch:{ all -> 0x0028 }
            java.lang.ThreadGroup[] r4 = r5.groups     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x0026
            java.lang.ThreadGroup[] r4 = r5.groups     // Catch:{ all -> 0x0028 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf((T[]) r4, (int) r2)     // Catch:{ all -> 0x0028 }
            java.lang.ThreadGroup[] r0 = (java.lang.ThreadGroup[]) r0     // Catch:{ all -> 0x0028 }
        L_0x0018:
            monitor-exit(r5)
            r1 = 0
        L_0x001a:
            if (r1 >= r2) goto L_0x002b
            r4 = r0[r1]
            int r4 = r4.activeCount()
            int r3 = r3 + r4
            int r1 = r1 + 1
            goto L_0x001a
        L_0x0026:
            r0 = 0
            goto L_0x0018
        L_0x0028:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        L_0x002b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ThreadGroup.activeCount():int");
    }

    public int enumerate(Thread[] list) {
        checkAccess();
        return enumerate(list, 0, true);
    }

    public int enumerate(Thread[] list, boolean recurse) {
        checkAccess();
        return enumerate(list, 0, recurse);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003e, code lost:
        if (r10 == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0040, code lost:
        r1 = 0;
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0042, code lost:
        if (r1 >= r3) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        r9 = r0[r1].enumerate(r8, r9, true);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int enumerate(java.lang.Thread[] r8, int r9, boolean r10) {
        /*
            r7 = this;
            r3 = 0
            r0 = 0
            monitor-enter(r7)
            boolean r5 = r7.destroyed     // Catch:{ all -> 0x0050 }
            if (r5 == 0) goto L_0x000a
            r5 = 0
            monitor-exit(r7)
            return r5
        L_0x000a:
            int r4 = r7.nthreads     // Catch:{ all -> 0x0050 }
            int r5 = r8.length     // Catch:{ all -> 0x0050 }
            int r5 = r5 - r9
            if (r4 <= r5) goto L_0x0013
            int r5 = r8.length     // Catch:{ all -> 0x0050 }
            int r4 = r5 - r9
        L_0x0013:
            r1 = 0
            r2 = r9
        L_0x0015:
            if (r1 >= r4) goto L_0x002d
            java.lang.Thread[] r5 = r7.threads     // Catch:{ all -> 0x0055 }
            r5 = r5[r1]     // Catch:{ all -> 0x0055 }
            boolean r5 = r5.isAlive()     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0058
            int r9 = r2 + 1
            java.lang.Thread[] r5 = r7.threads     // Catch:{ all -> 0x0050 }
            r5 = r5[r1]     // Catch:{ all -> 0x0050 }
            r8[r2] = r5     // Catch:{ all -> 0x0050 }
        L_0x0029:
            int r1 = r1 + 1
            r2 = r9
            goto L_0x0015
        L_0x002d:
            if (r10 == 0) goto L_0x003d
            int r3 = r7.ngroups     // Catch:{ all -> 0x0055 }
            java.lang.ThreadGroup[] r5 = r7.groups     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x004e
            java.lang.ThreadGroup[] r5 = r7.groups     // Catch:{ all -> 0x0055 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf((T[]) r5, (int) r3)     // Catch:{ all -> 0x0055 }
            java.lang.ThreadGroup[] r0 = (java.lang.ThreadGroup[]) r0     // Catch:{ all -> 0x0055 }
        L_0x003d:
            monitor-exit(r7)
            if (r10 == 0) goto L_0x0053
            r1 = 0
            r9 = r2
        L_0x0042:
            if (r1 >= r3) goto L_0x0054
            r5 = r0[r1]
            r6 = 1
            int r9 = r5.enumerate((java.lang.Thread[]) r8, (int) r9, (boolean) r6)
            int r1 = r1 + 1
            goto L_0x0042
        L_0x004e:
            r0 = 0
            goto L_0x003d
        L_0x0050:
            r5 = move-exception
        L_0x0051:
            monitor-exit(r7)
            throw r5
        L_0x0053:
            r9 = r2
        L_0x0054:
            return r9
        L_0x0055:
            r5 = move-exception
            r9 = r2
            goto L_0x0051
        L_0x0058:
            r9 = r2
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ThreadGroup.enumerate(java.lang.Thread[], int, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r2 = r3;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r1 >= r3) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r2 = r2 + r0[r1].activeGroupCount();
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int activeGroupCount() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r4 = r5.destroyed     // Catch:{ all -> 0x0027 }
            if (r4 == 0) goto L_0x0008
            r4 = 0
            monitor-exit(r5)
            return r4
        L_0x0008:
            int r3 = r5.ngroups     // Catch:{ all -> 0x0027 }
            java.lang.ThreadGroup[] r4 = r5.groups     // Catch:{ all -> 0x0027 }
            if (r4 == 0) goto L_0x0025
            java.lang.ThreadGroup[] r4 = r5.groups     // Catch:{ all -> 0x0027 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf((T[]) r4, (int) r3)     // Catch:{ all -> 0x0027 }
            java.lang.ThreadGroup[] r0 = (java.lang.ThreadGroup[]) r0     // Catch:{ all -> 0x0027 }
        L_0x0016:
            monitor-exit(r5)
            r2 = r3
            r1 = 0
        L_0x0019:
            if (r1 >= r3) goto L_0x002a
            r4 = r0[r1]
            int r4 = r4.activeGroupCount()
            int r2 = r2 + r4
            int r1 = r1 + 1
            goto L_0x0019
        L_0x0025:
            r0 = 0
            goto L_0x0016
        L_0x0027:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ThreadGroup.activeGroupCount():int");
    }

    public int enumerate(ThreadGroup[] list) {
        checkAccess();
        return enumerate(list, 0, true);
    }

    public int enumerate(ThreadGroup[] list, boolean recurse) {
        checkAccess();
        return enumerate(list, 0, recurse);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r9 == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r1 >= r3) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        r8 = r0[r1].enumerate(r7, r8, true);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int enumerate(java.lang.ThreadGroup[] r7, int r8, boolean r9) {
        /*
            r6 = this;
            r5 = 0
            r3 = 0
            r0 = 0
            monitor-enter(r6)
            boolean r4 = r6.destroyed     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x000a
            monitor-exit(r6)
            return r5
        L_0x000a:
            int r2 = r6.ngroups     // Catch:{ all -> 0x003e }
            int r4 = r7.length     // Catch:{ all -> 0x003e }
            int r4 = r4 - r8
            if (r2 <= r4) goto L_0x0013
            int r4 = r7.length     // Catch:{ all -> 0x003e }
            int r2 = r4 - r8
        L_0x0013:
            if (r2 <= 0) goto L_0x001c
            java.lang.ThreadGroup[] r4 = r6.groups     // Catch:{ all -> 0x003e }
            r5 = 0
            java.lang.System.arraycopy((java.lang.Object) r4, (int) r5, (java.lang.Object) r7, (int) r8, (int) r2)     // Catch:{ all -> 0x003e }
            int r8 = r8 + r2
        L_0x001c:
            if (r9 == 0) goto L_0x002c
            int r3 = r6.ngroups     // Catch:{ all -> 0x003e }
            java.lang.ThreadGroup[] r4 = r6.groups     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x003c
            java.lang.ThreadGroup[] r4 = r6.groups     // Catch:{ all -> 0x003e }
            java.lang.Object[] r0 = java.util.Arrays.copyOf((T[]) r4, (int) r3)     // Catch:{ all -> 0x003e }
            java.lang.ThreadGroup[] r0 = (java.lang.ThreadGroup[]) r0     // Catch:{ all -> 0x003e }
        L_0x002c:
            monitor-exit(r6)
            if (r9 == 0) goto L_0x0041
            r1 = 0
        L_0x0030:
            if (r1 >= r3) goto L_0x0041
            r4 = r0[r1]
            r5 = 1
            int r8 = r4.enumerate((java.lang.ThreadGroup[]) r7, (int) r8, (boolean) r5)
            int r1 = r1 + 1
            goto L_0x0030
        L_0x003c:
            r0 = 0
            goto L_0x002c
        L_0x003e:
            r4 = move-exception
            monitor-exit(r6)
            throw r4
        L_0x0041:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ThreadGroup.enumerate(java.lang.ThreadGroup[], int, boolean):int");
    }

    @Deprecated
    public final void stop() {
        if (stopOrSuspend(false)) {
            Thread.currentThread().stop();
        }
    }

    public final void interrupt() {
        int ngroupsSnapshot;
        ThreadGroup[] threadGroupArr;
        synchronized (this) {
            checkAccess();
            for (int i = 0; i < this.nthreads; i++) {
                this.threads[i].interrupt();
            }
            ngroupsSnapshot = this.ngroups;
            if (this.groups != null) {
                threadGroupArr = (ThreadGroup[]) Arrays.copyOf((T[]) this.groups, ngroupsSnapshot);
            } else {
                threadGroupArr = null;
            }
        }
        for (int i2 = 0; i2 < ngroupsSnapshot; i2++) {
            threadGroupArr[i2].interrupt();
        }
    }

    @Deprecated
    public final void suspend() {
        if (stopOrSuspend(true)) {
            Thread.currentThread().suspend();
        }
    }

    private boolean stopOrSuspend(boolean suspend) {
        int ngroupsSnapshot;
        boolean suicide = false;
        Thread us = Thread.currentThread();
        ThreadGroup[] groupsSnapshot = null;
        synchronized (this) {
            checkAccess();
            for (int i = 0; i < this.nthreads; i++) {
                if (this.threads[i] == us) {
                    suicide = true;
                } else if (suspend) {
                    this.threads[i].suspend();
                } else {
                    this.threads[i].stop();
                }
            }
            ngroupsSnapshot = this.ngroups;
            if (this.groups != null) {
                groupsSnapshot = (ThreadGroup[]) Arrays.copyOf((T[]) this.groups, ngroupsSnapshot);
            }
        }
        for (int i2 = 0; i2 < ngroupsSnapshot; i2++) {
            if (groupsSnapshot[i2].stopOrSuspend(suspend)) {
                suicide = true;
            }
        }
        return suicide;
    }

    @Deprecated
    public final void resume() {
        int ngroupsSnapshot;
        ThreadGroup[] threadGroupArr;
        synchronized (this) {
            checkAccess();
            for (int i = 0; i < this.nthreads; i++) {
                this.threads[i].resume();
            }
            ngroupsSnapshot = this.ngroups;
            if (this.groups != null) {
                threadGroupArr = (ThreadGroup[]) Arrays.copyOf((T[]) this.groups, ngroupsSnapshot);
            } else {
                threadGroupArr = null;
            }
        }
        for (int i2 = 0; i2 < ngroupsSnapshot; i2++) {
            threadGroupArr[i2].resume();
        }
    }

    public final void destroy() {
        int ngroupsSnapshot;
        ThreadGroup[] threadGroupArr;
        synchronized (this) {
            checkAccess();
            if (this.destroyed || this.nthreads > 0) {
                throw new IllegalThreadStateException();
            }
            ngroupsSnapshot = this.ngroups;
            if (this.groups != null) {
                threadGroupArr = (ThreadGroup[]) Arrays.copyOf((T[]) this.groups, ngroupsSnapshot);
            } else {
                threadGroupArr = null;
            }
            if (this.parent != null) {
                this.destroyed = true;
                this.ngroups = 0;
                this.groups = null;
                this.nthreads = 0;
                this.threads = null;
            }
        }
        for (int i = 0; i < ngroupsSnapshot; i++) {
            threadGroupArr[i].destroy();
        }
        if (this.parent != null) {
            this.parent.remove(this);
        }
    }

    private final void add(ThreadGroup g) {
        synchronized (this) {
            if (this.destroyed) {
                throw new IllegalThreadStateException();
            }
            if (this.groups == null) {
                this.groups = new ThreadGroup[4];
            } else if (this.ngroups == this.groups.length) {
                this.groups = (ThreadGroup[]) Arrays.copyOf((T[]) this.groups, this.ngroups * 2);
            }
            this.groups[this.ngroups] = g;
            this.ngroups++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void remove(java.lang.ThreadGroup r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r1 = r5.destroyed     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0007
            monitor-exit(r5)
            return
        L_0x0007:
            r0 = 0
        L_0x0008:
            int r1 = r5.ngroups     // Catch:{ all -> 0x004a }
            if (r0 >= r1) goto L_0x002b
            java.lang.ThreadGroup[] r1 = r5.groups     // Catch:{ all -> 0x004a }
            r1 = r1[r0]     // Catch:{ all -> 0x004a }
            if (r1 != r6) goto L_0x0047
            int r1 = r5.ngroups     // Catch:{ all -> 0x004a }
            int r1 = r1 + -1
            r5.ngroups = r1     // Catch:{ all -> 0x004a }
            java.lang.ThreadGroup[] r1 = r5.groups     // Catch:{ all -> 0x004a }
            int r2 = r0 + 1
            java.lang.ThreadGroup[] r3 = r5.groups     // Catch:{ all -> 0x004a }
            int r4 = r5.ngroups     // Catch:{ all -> 0x004a }
            int r4 = r4 - r0
            java.lang.System.arraycopy((java.lang.Object) r1, (int) r2, (java.lang.Object) r3, (int) r0, (int) r4)     // Catch:{ all -> 0x004a }
            java.lang.ThreadGroup[] r1 = r5.groups     // Catch:{ all -> 0x004a }
            int r2 = r5.ngroups     // Catch:{ all -> 0x004a }
            r3 = 0
            r1[r2] = r3     // Catch:{ all -> 0x004a }
        L_0x002b:
            int r1 = r5.nthreads     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0032
            r5.notifyAll()     // Catch:{ all -> 0x004a }
        L_0x0032:
            boolean r1 = r5.daemon     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0045
            int r1 = r5.nthreads     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0045
            int r1 = r5.nUnstartedThreads     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0045
            int r1 = r5.ngroups     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0045
            r5.destroy()     // Catch:{ all -> 0x004a }
        L_0x0045:
            monitor-exit(r5)
            return
        L_0x0047:
            int r0 = r0 + 1
            goto L_0x0008
        L_0x004a:
            r1 = move-exception
            monitor-exit(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ThreadGroup.remove(java.lang.ThreadGroup):void");
    }

    /* access modifiers changed from: package-private */
    public void addUnstarted() {
        synchronized (this) {
            if (this.destroyed) {
                throw new IllegalThreadStateException();
            }
            this.nUnstartedThreads++;
        }
    }

    /* access modifiers changed from: package-private */
    public void add(Thread t) {
        synchronized (this) {
            if (this.destroyed) {
                throw new IllegalThreadStateException();
            }
            if (this.threads == null) {
                this.threads = new Thread[4];
            } else if (this.nthreads == this.threads.length) {
                this.threads = (Thread[]) Arrays.copyOf((T[]) this.threads, this.nthreads * 2);
            }
            this.threads[this.nthreads] = t;
            this.nthreads++;
            this.nUnstartedThreads--;
        }
    }

    /* access modifiers changed from: package-private */
    public void threadStartFailed(Thread t) {
        synchronized (this) {
            remove(t);
            this.nUnstartedThreads++;
        }
    }

    /* access modifiers changed from: package-private */
    public void threadTerminated(Thread t) {
        synchronized (this) {
            remove(t);
            if (this.nthreads == 0) {
                notifyAll();
            }
            if (this.daemon && this.nthreads == 0 && this.nUnstartedThreads == 0 && this.ngroups == 0) {
                destroy();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void remove(java.lang.Thread r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r1 = r5.destroyed     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0007
            monitor-exit(r5)
            return
        L_0x0007:
            r0 = 0
        L_0x0008:
            int r1 = r5.nthreads     // Catch:{ all -> 0x002e }
            if (r0 >= r1) goto L_0x0029
            java.lang.Thread[] r1 = r5.threads     // Catch:{ all -> 0x002e }
            r1 = r1[r0]     // Catch:{ all -> 0x002e }
            if (r1 != r6) goto L_0x002b
            java.lang.Thread[] r1 = r5.threads     // Catch:{ all -> 0x002e }
            int r2 = r0 + 1
            java.lang.Thread[] r3 = r5.threads     // Catch:{ all -> 0x002e }
            int r4 = r5.nthreads     // Catch:{ all -> 0x002e }
            int r4 = r4 + -1
            r5.nthreads = r4     // Catch:{ all -> 0x002e }
            int r4 = r4 - r0
            java.lang.System.arraycopy((java.lang.Object) r1, (int) r2, (java.lang.Object) r3, (int) r0, (int) r4)     // Catch:{ all -> 0x002e }
            java.lang.Thread[] r1 = r5.threads     // Catch:{ all -> 0x002e }
            int r2 = r5.nthreads     // Catch:{ all -> 0x002e }
            r3 = 0
            r1[r2] = r3     // Catch:{ all -> 0x002e }
        L_0x0029:
            monitor-exit(r5)
            return
        L_0x002b:
            int r0 = r0 + 1
            goto L_0x0008
        L_0x002e:
            r1 = move-exception
            monitor-exit(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ThreadGroup.remove(java.lang.Thread):void");
    }

    public void list() {
        list(System.out, 0);
    }

    /* access modifiers changed from: package-private */
    public void list(PrintStream out, int indent) {
        int indent2;
        int ngroupsSnapshot;
        ThreadGroup[] threadGroupArr;
        synchronized (this) {
            for (int j = 0; j < indent; j++) {
                out.print(" ");
            }
            out.println((Object) this);
            indent2 = indent + 4;
            for (int i = 0; i < this.nthreads; i++) {
                for (int j2 = 0; j2 < indent2; j2++) {
                    out.print(" ");
                }
                out.println((Object) this.threads[i]);
            }
            ngroupsSnapshot = this.ngroups;
            if (this.groups != null) {
                threadGroupArr = (ThreadGroup[]) Arrays.copyOf((T[]) this.groups, ngroupsSnapshot);
            } else {
                threadGroupArr = null;
            }
        }
        for (int i2 = 0; i2 < ngroupsSnapshot; i2++) {
            threadGroupArr[i2].list(out, indent2);
        }
    }

    public void uncaughtException(Thread t, Throwable e) {
        if (this.parent != null) {
            this.parent.uncaughtException(t, e);
            return;
        }
        Thread.UncaughtExceptionHandler ueh = Thread.getDefaultUncaughtExceptionHandler();
        if (ueh != null) {
            ueh.uncaughtException(t, e);
        } else if (!(e instanceof ThreadDeath)) {
            System.err.print("Exception in thread \"" + t.getName() + "\" ");
            e.printStackTrace(System.err);
        }
    }

    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        this.vmAllowSuspension = b;
        if (b) {
            return true;
        }
        VM.unsuspendSomeThreads();
        return true;
    }

    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",maxpri=" + this.maxPriority + "]";
    }
}
