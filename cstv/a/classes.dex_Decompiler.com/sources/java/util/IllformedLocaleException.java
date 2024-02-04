package java.util;

public class IllformedLocaleException extends RuntimeException {
    private static final long serialVersionUID = -5245986824925681401L;
    private int _errIdx;

    public IllformedLocaleException() {
        this._errIdx = -1;
    }

    public IllformedLocaleException(String message) {
        super(message);
        this._errIdx = -1;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IllformedLocaleException(java.lang.String r4, int r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = r0.append((java.lang.String) r4)
            if (r5 >= 0) goto L_0x001f
            java.lang.String r0 = ""
        L_0x000e:
            java.lang.StringBuilder r0 = r1.append((java.lang.String) r0)
            java.lang.String r0 = r0.toString()
            r3.<init>((java.lang.String) r0)
            r0 = -1
            r3._errIdx = r0
            r3._errIdx = r5
            return
        L_0x001f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " [at index "
            java.lang.StringBuilder r0 = r0.append((java.lang.String) r2)
            java.lang.StringBuilder r0 = r0.append((int) r5)
            java.lang.String r2 = "]"
            java.lang.StringBuilder r0 = r0.append((java.lang.String) r2)
            java.lang.String r0 = r0.toString()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.IllformedLocaleException.<init>(java.lang.String, int):void");
    }

    public int getErrorIndex() {
        return this._errIdx;
    }
}
