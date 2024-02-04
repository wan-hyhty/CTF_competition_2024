package java.io;

public class FileNotFoundException extends IOException {
    private static final long serialVersionUID = -897856973823710492L;

    public FileNotFoundException() {
    }

    public FileNotFoundException(String s) {
        super(s);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FileNotFoundException(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = r0.append((java.lang.String) r4)
            if (r5 != 0) goto L_0x001a
            java.lang.String r0 = ""
        L_0x000e:
            java.lang.StringBuilder r0 = r1.append((java.lang.String) r0)
            java.lang.String r0 = r0.toString()
            r3.<init>((java.lang.String) r0)
            return
        L_0x001a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " ("
            java.lang.StringBuilder r0 = r0.append((java.lang.String) r2)
            java.lang.StringBuilder r0 = r0.append((java.lang.String) r5)
            java.lang.String r2 = ")"
            java.lang.StringBuilder r0 = r0.append((java.lang.String) r2)
            java.lang.String r0 = r0.toString()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.FileNotFoundException.<init>(java.lang.String, java.lang.String):void");
    }
}
