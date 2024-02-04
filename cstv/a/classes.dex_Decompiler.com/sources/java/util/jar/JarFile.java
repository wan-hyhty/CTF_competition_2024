package java.util.jar;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Locale;
import java.util.jar.JarVerifier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import sun.security.action.GetPropertyAction;

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
public class JarFile extends ZipFile {
    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    static final String META_DIR = "META-INF/";
    private static String[] jarNames;
    private static String javaHome;
    private static int[] lastOcc;
    private static int[] optoSft;
    private static char[] src;
    private boolean computedHasClassPathAttribute;
    private boolean hasClassPathAttribute;
    /* access modifiers changed from: private */
    public JarVerifier jv;
    private boolean jvInitialized;
    private JarEntry manEntry;
    private SoftReference<Manifest> manRef;
    private boolean verify;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.jar.JarFile.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.jar.JarFile.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarFile.<clinit>():void");
    }

    private native String[] getMetaInfEntryNames();

    public JarFile(String name) throws IOException {
        this(new File(name), true, 1);
    }

    public JarFile(String name, boolean verify2) throws IOException {
        this(new File(name), verify2, 1);
    }

    public JarFile(File file) throws IOException {
        this(file, true, 1);
    }

    public JarFile(File file, boolean verify2) throws IOException {
        this(file, verify2, 1);
    }

    public JarFile(File file, boolean verify2, int mode) throws IOException {
        super(file, mode);
        this.verify = verify2;
    }

    public Manifest getManifest() throws IOException {
        return getManifestFromReference();
    }

    private synchronized Manifest getManifestFromReference() throws IOException {
        Manifest man;
        JarEntry manEntry2;
        man = this.manRef != null ? this.manRef.get() : null;
        if (man == null && (manEntry2 = getManEntry()) != null) {
            if (this.verify) {
                byte[] b = getBytes(manEntry2);
                man = new Manifest((InputStream) new ByteArrayInputStream(b));
                if (!this.jvInitialized) {
                    this.jv = new JarVerifier(b);
                }
            } else {
                man = new Manifest(super.getInputStream(manEntry2));
            }
            this.manRef = new SoftReference<>(man);
        }
        return man;
    }

    public JarEntry getJarEntry(String name) {
        return (JarEntry) getEntry(name);
    }

    public ZipEntry getEntry(String name) {
        ZipEntry ze = super.getEntry(name);
        if (ze != null) {
            return new JarFileEntry(this, ze);
        }
        return null;
    }

    public Enumeration<JarEntry> entries() {
        final Enumeration enum_ = super.entries();
        return new Enumeration<JarEntry>() {
            public boolean hasMoreElements() {
                return enum_.hasMoreElements();
            }

            public JarFileEntry nextElement() {
                return new JarFileEntry(JarFile.this, (ZipEntry) enum_.nextElement());
            }
        };
    }

    private class JarFileEntry extends JarEntry {
        final /* synthetic */ JarFile this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        JarFileEntry(JarFile this$02, ZipEntry ze) {
            super(ze);
            this.this$0 = this$02;
        }

        public Attributes getAttributes() throws IOException {
            Manifest man = this.this$0.getManifest();
            if (man != null) {
                return man.getAttributes(getName());
            }
            return null;
        }

        public Certificate[] getCertificates() {
            try {
                this.this$0.maybeInstantiateVerifier();
                if (this.certs == null && this.this$0.jv != null) {
                    this.certs = this.this$0.jv.getCerts(this.this$0, this);
                }
                if (this.certs == null) {
                    return null;
                }
                return (Certificate[]) this.certs.clone();
            } catch (IOException e) {
                throw new RuntimeException((Throwable) e);
            }
        }

        public CodeSigner[] getCodeSigners() {
            try {
                this.this$0.maybeInstantiateVerifier();
                if (this.signers == null && this.this$0.jv != null) {
                    this.signers = this.this$0.jv.getCodeSigners(this.this$0, this);
                }
                if (this.signers == null) {
                    return null;
                }
                return (CodeSigner[]) this.signers.clone();
            } catch (IOException e) {
                throw new RuntimeException((Throwable) e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void maybeInstantiateVerifier() throws IOException {
        if (this.jv == null && this.verify) {
            String[] names = getMetaInfEntryNames();
            if (names != null) {
                for (String upperCase : names) {
                    String name = upperCase.toUpperCase(Locale.ENGLISH);
                    if (name.endsWith(".DSA") || name.endsWith(".RSA") || name.endsWith(".EC") || name.endsWith(".SF")) {
                        getManifest();
                        return;
                    }
                }
            }
            this.verify = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initializeVerifier() {
        /*
            r18 = this;
            r6 = 0
            java.lang.String[] r17 = r18.getMetaInfEntryNames()     // Catch:{ IOException -> 0x00b7 }
            if (r17 == 0) goto L_0x003e
            r15 = 0
            r16 = r6
        L_0x000a:
            r0 = r17
            int r1 = r0.length     // Catch:{ IOException -> 0x0022 }
            if (r15 >= r1) goto L_0x00c0
            r1 = r17[r15]     // Catch:{ IOException -> 0x0022 }
            r0 = r18
            java.util.jar.JarEntry r13 = r0.getJarEntry(r1)     // Catch:{ IOException -> 0x0022 }
            if (r13 != 0) goto L_0x0078
            java.util.jar.JarException r1 = new java.util.jar.JarException     // Catch:{ IOException -> 0x0022 }
            java.lang.String r2 = "corrupted jar file"
            r1.<init>(r2)     // Catch:{ IOException -> 0x0022 }
            throw r1     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            r14 = move-exception
            r6 = r16
        L_0x0025:
            r1 = 0
            r0 = r18
            r0.jv = r1
            r1 = 0
            r0 = r18
            r0.verify = r1
            sun.security.util.Debug r1 = java.util.jar.JarVerifier.debug
            if (r1 == 0) goto L_0x003e
            sun.security.util.Debug r1 = java.util.jar.JarVerifier.debug
            java.lang.String r2 = "jarfile parsing error!"
            r1.println(r2)
            r14.printStackTrace()
        L_0x003e:
            r0 = r18
            java.util.jar.JarVerifier r1 = r0.jv
            if (r1 == 0) goto L_0x0077
            r0 = r18
            java.util.jar.JarVerifier r1 = r0.jv
            r1.doneWithMeta()
            sun.security.util.Debug r1 = java.util.jar.JarVerifier.debug
            if (r1 == 0) goto L_0x0057
            sun.security.util.Debug r1 = java.util.jar.JarVerifier.debug
            java.lang.String r2 = "done with meta!"
            r1.println(r2)
        L_0x0057:
            r0 = r18
            java.util.jar.JarVerifier r1 = r0.jv
            boolean r1 = r1.nothingToVerify()
            if (r1 == 0) goto L_0x0077
            sun.security.util.Debug r1 = java.util.jar.JarVerifier.debug
            if (r1 == 0) goto L_0x006d
            sun.security.util.Debug r1 = java.util.jar.JarVerifier.debug
            java.lang.String r2 = "nothing to verify!"
            r1.println(r2)
        L_0x006d:
            r1 = 0
            r0 = r18
            r0.jv = r1
            r1 = 0
            r0 = r18
            r0.verify = r1
        L_0x0077:
            return
        L_0x0078:
            boolean r1 = r13.isDirectory()     // Catch:{ IOException -> 0x0022 }
            if (r1 != 0) goto L_0x00bd
            if (r16 != 0) goto L_0x00ba
            sun.security.util.ManifestEntryVerifier r6 = new sun.security.util.ManifestEntryVerifier     // Catch:{ IOException -> 0x0022 }
            java.util.jar.Manifest r1 = r18.getManifestFromReference()     // Catch:{ IOException -> 0x0022 }
            r6.<init>(r1)     // Catch:{ IOException -> 0x0022 }
        L_0x0089:
            r0 = r18
            byte[] r3 = r0.getBytes(r13)     // Catch:{ IOException -> 0x00b7 }
            if (r3 == 0) goto L_0x00b1
            int r1 = r3.length     // Catch:{ IOException -> 0x00b7 }
            if (r1 <= 0) goto L_0x00b1
            r0 = r18
            java.util.jar.JarVerifier r1 = r0.jv     // Catch:{ IOException -> 0x00b7 }
            r1.beginEntry(r13, r6)     // Catch:{ IOException -> 0x00b7 }
            r0 = r18
            java.util.jar.JarVerifier r1 = r0.jv     // Catch:{ IOException -> 0x00b7 }
            int r2 = r3.length     // Catch:{ IOException -> 0x00b7 }
            int r5 = r3.length     // Catch:{ IOException -> 0x00b7 }
            r4 = 0
            r1.update(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00b7 }
            r0 = r18
            java.util.jar.JarVerifier r7 = r0.jv     // Catch:{ IOException -> 0x00b7 }
            r8 = -1
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = r6
            r7.update(r8, r9, r10, r11, r12)     // Catch:{ IOException -> 0x00b7 }
        L_0x00b1:
            int r15 = r15 + 1
            r16 = r6
            goto L_0x000a
        L_0x00b7:
            r14 = move-exception
            goto L_0x0025
        L_0x00ba:
            r6 = r16
            goto L_0x0089
        L_0x00bd:
            r6 = r16
            goto L_0x00b1
        L_0x00c0:
            r6 = r16
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarFile.initializeVerifier():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r6 = r2;
        r2 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        r1 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] getBytes(java.util.zip.ZipEntry r8) throws java.io.IOException {
        /*
            r7 = this;
            r2 = 0
            r0 = 0
            java.io.InputStream r0 = super.getInputStream(r8)     // Catch:{ Throwable -> 0x001b, all -> 0x0035 }
            long r4 = r8.getSize()     // Catch:{ Throwable -> 0x001b, all -> 0x0035 }
            int r1 = (int) r4     // Catch:{ Throwable -> 0x001b, all -> 0x0035 }
            r3 = 1
            byte[] r1 = sun.misc.IOUtils.readFully(r0, r1, r3)     // Catch:{ Throwable -> 0x001b, all -> 0x0035 }
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ Throwable -> 0x0018 }
        L_0x0015:
            if (r2 == 0) goto L_0x001a
            throw r2
        L_0x0018:
            r2 = move-exception
            goto L_0x0015
        L_0x001a:
            return r1
        L_0x001b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001d }
        L_0x001d:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L_0x0021:
            if (r0 == 0) goto L_0x0026
            r0.close()     // Catch:{ Throwable -> 0x0029 }
        L_0x0026:
            if (r2 == 0) goto L_0x0034
            throw r2
        L_0x0029:
            r3 = move-exception
            if (r2 != 0) goto L_0x002e
            r2 = r3
            goto L_0x0026
        L_0x002e:
            if (r2 == r3) goto L_0x0026
            r2.addSuppressed(r3)
            goto L_0x0026
        L_0x0034:
            throw r1
        L_0x0035:
            r1 = move-exception
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarFile.getBytes(java.util.zip.ZipEntry):byte[]");
    }

    public synchronized InputStream getInputStream(ZipEntry ze) throws IOException {
        maybeInstantiateVerifier();
        if (this.jv == null) {
            return super.getInputStream(ze);
        }
        if (!this.jvInitialized) {
            initializeVerifier();
            this.jvInitialized = true;
            if (this.jv == null) {
                return super.getInputStream(ze);
            }
        }
        return new JarVerifier.VerifierStream(getManifestFromReference(), ze instanceof JarFileEntry ? (JarEntry) ze : getJarEntry(ze.getName()), super.getInputStream(ze), this.jv);
    }

    private synchronized JarEntry getManEntry() {
        String[] names;
        if (this.manEntry == null) {
            this.manEntry = getJarEntry(MANIFEST_NAME);
            if (this.manEntry == null && (names = getMetaInfEntryNames()) != null) {
                int i = 0;
                while (true) {
                    if (i >= names.length) {
                        break;
                    } else if (MANIFEST_NAME.equals(names[i].toUpperCase(Locale.ENGLISH))) {
                        this.manEntry = getJarEntry(names[i]);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return this.manEntry;
    }

    public boolean hasClassPathAttribute() throws IOException {
        JarEntry manEntry2;
        if (this.computedHasClassPathAttribute) {
            return this.hasClassPathAttribute;
        }
        this.hasClassPathAttribute = false;
        if (!isKnownToNotHaveClassPathAttribute() && (manEntry2 = getManEntry()) != null) {
            byte[] b = getBytes(manEntry2);
            int last = b.length - src.length;
            int i = 0;
            loop0:
            while (true) {
                if (i > last) {
                    break;
                }
                int j = 9;
                while (j >= 0) {
                    char c = (char) b[i + j];
                    if (((c - 'A') | ('Z' - c)) >= 0) {
                        c = (char) (c + ' ');
                    }
                    if (c != src[j]) {
                        i += Math.max((j + 1) - lastOcc[c & 127], optoSft[j]);
                    } else {
                        j--;
                    }
                }
                this.hasClassPathAttribute = true;
                break loop0;
            }
        }
        this.computedHasClassPathAttribute = true;
        return this.hasClassPathAttribute;
    }

    private boolean isKnownToNotHaveClassPathAttribute() {
        if (javaHome == null) {
            javaHome = (String) AccessController.doPrivileged(new GetPropertyAction("java.home"));
        }
        if (jarNames == null) {
            String[] names = new String[10];
            String fileSep = File.separator;
            names[0] = fileSep + "rt.jar";
            int i = 1 + 1;
            names[1] = fileSep + "sunrsasign.jar";
            int i2 = i + 1;
            names[i] = fileSep + "jsse.jar";
            int i3 = i2 + 1;
            names[i2] = fileSep + "jce.jar";
            int i4 = i3 + 1;
            names[i3] = fileSep + "charsets.jar";
            int i5 = i4 + 1;
            names[i4] = fileSep + "dnsns.jar";
            int i6 = i5 + 1;
            names[i5] = fileSep + "ldapsec.jar";
            int i7 = i6 + 1;
            names[i6] = fileSep + "localedata.jar";
            int i8 = i7 + 1;
            names[i7] = fileSep + "sunjce_provider.jar";
            int i9 = i8 + 1;
            names[i8] = fileSep + "sunpkcs11.jar";
            jarNames = names;
        }
        String name = getName();
        if (name.startsWith(javaHome)) {
            String[] names2 = jarNames;
            for (String endsWith : names2) {
                if (name.endsWith(endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    private synchronized void ensureInitialization() {
        try {
            maybeInstantiateVerifier();
            if (this.jv != null && !this.jvInitialized) {
                initializeVerifier();
                this.jvInitialized = true;
            }
        } catch (IOException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public JarEntry newEntry(ZipEntry ze) {
        return new JarFileEntry(this, ze);
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private java.util.Enumeration<java.lang.String> unsignedEntryNames() {
        /*
            r2 = this;
            java.util.Enumeration r0 = r2.entries()
            java.util.jar.JarFile$2 r1 = new java.util.jar.JarFile$2
            r1.<init>(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarFile.unsignedEntryNames():java.util.Enumeration");
    }
}
