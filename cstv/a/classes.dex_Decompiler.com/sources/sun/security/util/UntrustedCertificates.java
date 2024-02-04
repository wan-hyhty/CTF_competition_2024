package sun.security.util;

import java.security.cert.X509Certificate;
import java.util.Set;

public final class UntrustedCertificates {
    private static final Set<X509Certificate> untrustedCerts = null;

    public static boolean isUntrusted(X509Certificate cert) {
        return untrustedCerts.contains(cert);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        throw new java.lang.RuntimeException("Incorrect untrusted certificate: " + r10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047 A[SYNTHETIC, Splitter:B:16:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[SYNTHETIC, Splitter:B:19:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d A[ExcHandler: IOException | CertificateException (e java.lang.Throwable), Splitter:B:16:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070 A[ExcHandler: IOException | CertificateException (e java.lang.Throwable), Splitter:B:25:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080 A[Catch:{ IOException | CertificateException -> 0x004d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void add(java.lang.String r10, java.lang.String r11) {
        /*
            r6 = 0
            r3 = 0
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Throwable -> 0x0087, all -> 0x0082 }
            byte[] r5 = r11.getBytes()     // Catch:{ Throwable -> 0x0087, all -> 0x0082 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0087, all -> 0x0082 }
            java.lang.String r5 = "X.509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r5)     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            java.security.cert.Certificate r0 = r1.generateCertificate(r4)     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            java.util.Set<java.security.cert.X509Certificate> r5 = untrustedCerts     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            boolean r5 = r5.add(r0)     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            if (r5 != 0) goto L_0x0068
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            r7.<init>()     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            java.lang.String r8 = "Duplicate untrusted certificate: "
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            javax.security.auth.x500.X500Principal r8 = r0.getSubjectX500Principal()     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            java.lang.StringBuilder r7 = r7.append((java.lang.Object) r8)     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            r5.<init>((java.lang.String) r7)     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
            throw r5     // Catch:{ Throwable -> 0x003e, all -> 0x0084 }
        L_0x003e:
            r5 = move-exception
            r3 = r4
        L_0x0040:
            throw r5     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r6 = move-exception
            r9 = r6
            r6 = r5
            r5 = r9
        L_0x0045:
            if (r3 == 0) goto L_0x004a
            r3.close()     // Catch:{ Throwable -> 0x0075, IOException | CertificateException -> 0x004d }
        L_0x004a:
            if (r6 == 0) goto L_0x0080
            throw r6     // Catch:{ IOException | CertificateException -> 0x004d }
        L_0x004d:
            r2 = move-exception
        L_0x004e:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Incorrect untrusted certificate: "
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r10)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6, r2)
            throw r5
        L_0x0068:
            if (r4 == 0) goto L_0x006d
            r4.close()     // Catch:{ Throwable -> 0x0073, IOException | CertificateException -> 0x0070 }
        L_0x006d:
            if (r6 == 0) goto L_0x0081
            throw r6     // Catch:{ IOException | CertificateException -> 0x0070 }
        L_0x0070:
            r2 = move-exception
            r3 = r4
            goto L_0x004e
        L_0x0073:
            r6 = move-exception
            goto L_0x006d
        L_0x0075:
            r7 = move-exception
            if (r6 != 0) goto L_0x007a
            r6 = r7
            goto L_0x004a
        L_0x007a:
            if (r6 == r7) goto L_0x004a
            r6.addSuppressed(r7)     // Catch:{ IOException | CertificateException -> 0x004d }
            goto L_0x004a
        L_0x0080:
            throw r5     // Catch:{ IOException | CertificateException -> 0x004d }
        L_0x0081:
            return
        L_0x0082:
            r5 = move-exception
            goto L_0x0045
        L_0x0084:
            r5 = move-exception
            r3 = r4
            goto L_0x0045
        L_0x0087:
            r5 = move-exception
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.util.UntrustedCertificates.add(java.lang.String, java.lang.String):void");
    }
}
