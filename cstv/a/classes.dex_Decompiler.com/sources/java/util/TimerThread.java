package java.util;

/* compiled from: Timer */
class TimerThread extends Thread {
    boolean newTasksMayBeScheduled = true;
    private TaskQueue queue;

    TimerThread(TaskQueue queue2) {
        this.queue = queue2;
    }

    public void run() {
        try {
            mainLoop();
            synchronized (this.queue) {
                this.newTasksMayBeScheduled = false;
                this.queue.clear();
            }
        } catch (Throwable th) {
            synchronized (this.queue) {
                this.newTasksMayBeScheduled = false;
                this.queue.clear();
                throw th;
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void mainLoop() {
        /*
            r14 = this;
            r12 = 0
        L_0x0002:
            java.util.TaskQueue r10 = r14.queue     // Catch:{ InterruptedException -> 0x001a }
            monitor-enter(r10)     // Catch:{ InterruptedException -> 0x001a }
        L_0x0005:
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x0017 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0017 }
            if (r7 == 0) goto L_0x001c
            boolean r7 = r14.newTasksMayBeScheduled     // Catch:{ all -> 0x0017 }
            if (r7 == 0) goto L_0x001c
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x0017 }
            r7.wait()     // Catch:{ all -> 0x0017 }
            goto L_0x0005
        L_0x0017:
            r7 = move-exception
            monitor-exit(r10)     // Catch:{ InterruptedException -> 0x001a }
            throw r7     // Catch:{ InterruptedException -> 0x001a }
        L_0x001a:
            r2 = move-exception
            goto L_0x0002
        L_0x001c:
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x0017 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0017 }
            if (r7 == 0) goto L_0x0026
            monitor-exit(r10)     // Catch:{ InterruptedException -> 0x001a }
            return
        L_0x0026:
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x0017 }
            java.util.TimerTask r3 = r7.getMin()     // Catch:{ all -> 0x0017 }
            java.lang.Object r11 = r3.lock     // Catch:{ all -> 0x0017 }
            monitor-enter(r11)     // Catch:{ all -> 0x0017 }
            int r7 = r3.state     // Catch:{ all -> 0x007a }
            r8 = 3
            if (r7 != r8) goto L_0x003c
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x007a }
            r7.removeMin()     // Catch:{ all -> 0x007a }
            monitor-exit(r11)     // Catch:{ all -> 0x0017 }
            monitor-exit(r10)     // Catch:{ InterruptedException -> 0x001a }
            goto L_0x0002
        L_0x003c:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007a }
            long r4 = r3.nextExecutionTime     // Catch:{ all -> 0x007a }
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 > 0) goto L_0x0068
            r6 = 1
        L_0x0047:
            if (r6 == 0) goto L_0x0057
            long r8 = r3.period     // Catch:{ all -> 0x007a }
            int r7 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x006a
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x007a }
            r7.removeMin()     // Catch:{ all -> 0x007a }
            r7 = 2
            r3.state = r7     // Catch:{ all -> 0x007a }
        L_0x0057:
            monitor-exit(r11)     // Catch:{ all -> 0x0017 }
            if (r6 != 0) goto L_0x0061
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x0017 }
            long r8 = r4 - r0
            r7.wait(r8)     // Catch:{ all -> 0x0017 }
        L_0x0061:
            monitor-exit(r10)     // Catch:{ InterruptedException -> 0x001a }
            if (r6 == 0) goto L_0x0002
            r3.run()     // Catch:{ InterruptedException -> 0x001a }
            goto L_0x0002
        L_0x0068:
            r6 = 0
            goto L_0x0047
        L_0x006a:
            java.util.TaskQueue r7 = r14.queue     // Catch:{ all -> 0x007a }
            long r8 = r3.period     // Catch:{ all -> 0x007a }
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 >= 0) goto L_0x007d
            long r8 = r3.period     // Catch:{ all -> 0x007a }
            long r8 = r0 - r8
        L_0x0076:
            r7.rescheduleMin(r8)     // Catch:{ all -> 0x007a }
            goto L_0x0057
        L_0x007a:
            r7 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0017 }
            throw r7     // Catch:{ all -> 0x0017 }
        L_0x007d:
            long r8 = r3.period     // Catch:{ all -> 0x007a }
            long r8 = r8 + r4
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimerThread.mainLoop():void");
    }
}
