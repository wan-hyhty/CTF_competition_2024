package java.util.logging;

public class ErrorManager {
    public static final int CLOSE_FAILURE = 3;
    public static final int FLUSH_FAILURE = 2;
    public static final int FORMAT_FAILURE = 5;
    public static final int GENERIC_FAILURE = 0;
    public static final int OPEN_FAILURE = 4;
    public static final int WRITE_FAILURE = 1;
    private boolean reported = false;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void error(java.lang.String r4, java.lang.Exception r5, int r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r1 = r3.reported     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            r1 = 1
            r3.reported = r1     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r1.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "java.util.logging.ErrorManager: "
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r2)     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r1 = r1.append((int) r6)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0044 }
            if (r4 == 0) goto L_0x0038
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r1.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = ": "
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r2)     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0044 }
        L_0x0038:
            java.io.PrintStream r1 = java.lang.System.err     // Catch:{ all -> 0x0044 }
            r1.println((java.lang.String) r0)     // Catch:{ all -> 0x0044 }
            if (r5 == 0) goto L_0x0042
            r5.printStackTrace()     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r3)
            return
        L_0x0044:
            r1 = move-exception
            monitor-exit(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.ErrorManager.error(java.lang.String, java.lang.Exception, int):void");
    }
}
