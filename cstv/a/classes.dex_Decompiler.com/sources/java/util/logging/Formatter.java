package java.util.logging;

public abstract class Formatter {
    public abstract String format(LogRecord logRecord);

    protected Formatter() {
    }

    public String getHead(Handler h) {
        return "";
    }

    public String getTail(Handler h) {
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String formatMessage(java.util.logging.LogRecord r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r3 = r7.getMessage()     // Catch:{ all -> 0x0053 }
            java.util.ResourceBundle r0 = r7.getResourceBundle()     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0013
            java.lang.String r5 = r7.getMessage()     // Catch:{ MissingResourceException -> 0x001e }
            java.lang.String r3 = r0.getString(r5)     // Catch:{ MissingResourceException -> 0x001e }
        L_0x0013:
            java.lang.Object[] r4 = r7.getParameters()     // Catch:{ Exception -> 0x0050 }
            if (r4 == 0) goto L_0x001c
            int r5 = r4.length     // Catch:{ Exception -> 0x0050 }
            if (r5 != 0) goto L_0x0024
        L_0x001c:
            monitor-exit(r6)
            return r3
        L_0x001e:
            r2 = move-exception
            java.lang.String r3 = r7.getMessage()     // Catch:{ all -> 0x0053 }
            goto L_0x0013
        L_0x0024:
            java.lang.String r5 = "{0"
            int r5 = r3.indexOf((java.lang.String) r5)     // Catch:{ Exception -> 0x0050 }
            if (r5 >= 0) goto L_0x0036
            java.lang.String r5 = "{1"
            int r5 = r3.indexOf((java.lang.String) r5)     // Catch:{ Exception -> 0x0050 }
            if (r5 < 0) goto L_0x003c
        L_0x0036:
            java.lang.String r5 = java.text.MessageFormat.format(r3, r4)     // Catch:{ Exception -> 0x0050 }
            monitor-exit(r6)
            return r5
        L_0x003c:
            java.lang.String r5 = "{2"
            int r5 = r3.indexOf((java.lang.String) r5)     // Catch:{ Exception -> 0x0050 }
            if (r5 >= 0) goto L_0x0036
            java.lang.String r5 = "{3"
            int r5 = r3.indexOf((java.lang.String) r5)     // Catch:{ Exception -> 0x0050 }
            if (r5 >= 0) goto L_0x0036
            monitor-exit(r6)
            return r3
        L_0x0050:
            r1 = move-exception
            monitor-exit(r6)
            return r3
        L_0x0053:
            r5 = move-exception
            monitor-exit(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Formatter.formatMessage(java.util.logging.LogRecord):java.lang.String");
    }
}
