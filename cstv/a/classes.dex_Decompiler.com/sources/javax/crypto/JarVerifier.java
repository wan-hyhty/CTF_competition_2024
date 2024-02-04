package javax.crypto;

import java.net.URL;
import java.security.cert.Certificate;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
final class JarVerifier {
    private CryptoPermissions appPerms;
    private URL jarURL;
    private boolean savePerms;

    JarVerifier(URL jarURL2, boolean savePerms2) {
        this.appPerms = null;
        this.jarURL = jarURL2;
        this.savePerms = savePerms2;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    void verify() throws java.util.jar.JarException, java.io.IOException {
        /*
            r10 = this;
            boolean r8 = r10.savePerms
            if (r8 != 0) goto L_0x0005
            return
        L_0x0005:
            java.net.URL r8 = r10.jarURL
            java.lang.String r8 = r8.getProtocol()
            java.lang.String r9 = "jar"
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x003f
            java.net.URL r7 = r10.jarURL
        L_0x0016:
            r4 = 0
            javax.crypto.JarVerifier$1 r8 = new javax.crypto.JarVerifier$1     // Catch:{ PrivilegedActionException -> 0x0066 }
            r8.<init>(r10, r7)     // Catch:{ PrivilegedActionException -> 0x0066 }
            java.lang.Object r8 = java.security.AccessController.doPrivileged(r8)     // Catch:{ PrivilegedActionException -> 0x0066 }
            r0 = r8
            java.util.jar.JarFile r0 = (java.util.jar.JarFile) r0     // Catch:{ PrivilegedActionException -> 0x0066 }
            r4 = r0
            if (r4 == 0) goto L_0x0098
            java.lang.String r8 = "cryptoPerms"
            java.util.jar.JarEntry r2 = r4.getJarEntry(r8)     // Catch:{ all -> 0x0038 }
            if (r2 != 0) goto L_0x0088
            java.util.jar.JarException r8 = new java.util.jar.JarException     // Catch:{ all -> 0x0038 }
            java.lang.String r9 = "Can not find cryptoPerms"
            r8.<init>(r9)     // Catch:{ all -> 0x0038 }
            throw r8     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r8 = move-exception
            if (r4 == 0) goto L_0x003e
            r4.close()
        L_0x003e:
            throw r8
        L_0x003f:
            java.net.URL r7 = new java.net.URL
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "jar:"
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)
            java.net.URL r9 = r10.jarURL
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)
            java.lang.String r9 = "!/"
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            goto L_0x0016
        L_0x0066:
            r5 = move-exception
            java.lang.SecurityException r6 = new java.lang.SecurityException     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r8.<init>()     // Catch:{ all -> 0x0038 }
            java.lang.String r9 = "Cannot load "
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)     // Catch:{ all -> 0x0038 }
            java.lang.String r9 = r7.toString()     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)     // Catch:{ all -> 0x0038 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0038 }
            r6.<init>((java.lang.String) r8)     // Catch:{ all -> 0x0038 }
            r6.initCause(r5)     // Catch:{ all -> 0x0038 }
            throw r6     // Catch:{ all -> 0x0038 }
        L_0x0088:
            javax.crypto.CryptoPermissions r8 = new javax.crypto.CryptoPermissions     // Catch:{ Exception -> 0x009e }
            r8.<init>()     // Catch:{ Exception -> 0x009e }
            r10.appPerms = r8     // Catch:{ Exception -> 0x009e }
            javax.crypto.CryptoPermissions r8 = r10.appPerms     // Catch:{ Exception -> 0x009e }
            java.io.InputStream r9 = r4.getInputStream(r2)     // Catch:{ Exception -> 0x009e }
            r8.load(r9)     // Catch:{ Exception -> 0x009e }
        L_0x0098:
            if (r4 == 0) goto L_0x009d
            r4.close()
        L_0x009d:
            return
        L_0x009e:
            r1 = move-exception
            java.util.jar.JarException r3 = new java.util.jar.JarException     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r8.<init>()     // Catch:{ all -> 0x0038 }
            java.lang.String r9 = "Cannot load/parse"
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)     // Catch:{ all -> 0x0038 }
            java.net.URL r9 = r10.jarURL     // Catch:{ all -> 0x0038 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)     // Catch:{ all -> 0x0038 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0038 }
            r3.<init>(r8)     // Catch:{ all -> 0x0038 }
            r3.initCause(r1)     // Catch:{ all -> 0x0038 }
            throw r3     // Catch:{ all -> 0x0038 }
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.JarVerifier.verify():void");
    }

    static void verifyPolicySigned(Certificate[] certs) throws Exception {
    }

    /* access modifiers changed from: package-private */
    public CryptoPermissions getPermissions() {
        return this.appPerms;
    }
}
