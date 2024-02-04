package java.lang;

import dalvik.system.VMStack;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.URL;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import sun.reflect.CallerSensitive;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class Package implements AnnotatedElement {
    /* access modifiers changed from: private */
    public static Map<String, Manifest> mans;
    /* access modifiers changed from: private */
    public static Map<String, Package> pkgs;
    /* access modifiers changed from: private */
    public static Map<String, URL> urls;
    private final String implTitle;
    private final String implVendor;
    private final String implVersion;
    private final transient ClassLoader loader;
    private transient Class packageInfo;
    private final String pkgName;
    private final URL sealBase;
    private final String specTitle;
    private final String specVendor;
    private final String specVersion;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.lang.Package.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.lang.Package.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Package.<clinit>():void");
    }

    /* synthetic */ Package(String name, Manifest man, URL url, ClassLoader loader2, Package packageR) {
        this(name, man, url, loader2);
    }

    private static native String getSystemPackage0(String str);

    private static native String[] getSystemPackages0();

    public String getName() {
        return this.pkgName;
    }

    public String getSpecificationTitle() {
        return this.specTitle;
    }

    public String getSpecificationVersion() {
        return this.specVersion;
    }

    public String getSpecificationVendor() {
        return this.specVendor;
    }

    public String getImplementationTitle() {
        return this.implTitle;
    }

    public String getImplementationVersion() {
        return this.implVersion;
    }

    public String getImplementationVendor() {
        return this.implVendor;
    }

    public boolean isSealed() {
        return this.sealBase != null;
    }

    public boolean isSealed(URL url) {
        return url.equals(this.sealBase);
    }

    public boolean isCompatibleWith(String desired) throws NumberFormatException {
        int s;
        if (this.specVersion == null || this.specVersion.length() < 1) {
            throw new NumberFormatException("Empty version string");
        }
        String[] sa = this.specVersion.split("\\.", -1);
        int[] si = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            si[i] = Integer.parseInt(sa[i]);
            if (si[i] < 0) {
                throw NumberFormatException.forInputString("" + si[i]);
            }
        }
        String[] da = desired.split("\\.", -1);
        int[] di = new int[da.length];
        for (int i2 = 0; i2 < da.length; i2++) {
            di[i2] = Integer.parseInt(da[i2]);
            if (di[i2] < 0) {
                throw NumberFormatException.forInputString("" + di[i2]);
            }
        }
        int len = Math.max(di.length, si.length);
        int i3 = 0;
        while (i3 < len) {
            int d = i3 < di.length ? di[i3] : 0;
            if (i3 < si.length) {
                s = si[i3];
            } else {
                s = 0;
            }
            if (s < d) {
                return false;
            }
            if (s > d) {
                return true;
            }
            i3++;
        }
        return true;
    }

    @CallerSensitive
    public static Package getPackage(String name) {
        ClassLoader l = VMStack.getCallingClassLoader();
        if (l != null) {
            return l.getPackage(name);
        }
        return getSystemPackage(name);
    }

    @CallerSensitive
    public static Package[] getPackages() {
        ClassLoader l = VMStack.getCallingClassLoader();
        if (l != null) {
            return l.getPackages();
        }
        return getSystemPackages();
    }

    static Package getPackage(Class<?> c) {
        String name = c.getName();
        int i = name.lastIndexOf(46);
        if (i == -1) {
            return null;
        }
        String name2 = name.substring(0, i);
        ClassLoader cl = c.getClassLoader();
        if (cl != null) {
            return cl.getPackage(name2);
        }
        return getSystemPackage(name2);
    }

    public int hashCode() {
        return this.pkgName.hashCode();
    }

    public String toString() {
        return "package " + this.pkgName;
    }

    private Class<?> getPackageInfo() {
        if (this.packageInfo == null) {
            try {
                this.packageInfo = Class.forName(this.pkgName + ".package-info", false, this.loader);
            } catch (ClassNotFoundException e) {
                this.packageInfo = AnonymousClass1PackageInfoProxy.class;
            }
        }
        return this.packageInfo;
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        return getPackageInfo().getAnnotation(annotationClass);
    }

    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass) {
        return getPackageInfo().getAnnotationsByType(annotationClass);
    }

    public Annotation[] getAnnotations() {
        return getPackageInfo().getAnnotations();
    }

    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        return getPackageInfo().getDeclaredAnnotation(annotationClass);
    }

    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> annotationClass) {
        return getPackageInfo().getDeclaredAnnotationsByType(annotationClass);
    }

    public Annotation[] getDeclaredAnnotations() {
        return getPackageInfo().getDeclaredAnnotations();
    }

    Package(String name, String spectitle, String specversion, String specvendor, String impltitle, String implversion, String implvendor, URL sealbase, ClassLoader loader2) {
        this.pkgName = name;
        this.implTitle = impltitle;
        this.implVersion = implversion;
        this.implVendor = implvendor;
        this.specTitle = spectitle;
        this.specVersion = specversion;
        this.specVendor = specvendor;
        this.sealBase = sealbase;
        this.loader = loader2;
    }

    private Package(String name, Manifest man, URL url, ClassLoader loader2) {
        String sealed = null;
        String specTitle2 = null;
        String specVersion2 = null;
        String specVendor2 = null;
        String implTitle2 = null;
        String implVersion2 = null;
        String implVendor2 = null;
        URL sealBase2 = null;
        Attributes attr = man.getAttributes(name.replace('.', '/').concat("/"));
        if (attr != null) {
            specTitle2 = attr.getValue(Attributes.Name.SPECIFICATION_TITLE);
            specVersion2 = attr.getValue(Attributes.Name.SPECIFICATION_VERSION);
            specVendor2 = attr.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            implTitle2 = attr.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            implVersion2 = attr.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            implVendor2 = attr.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            sealed = attr.getValue(Attributes.Name.SEALED);
        }
        Attributes attr2 = man.getMainAttributes();
        if (attr2 != null) {
            specTitle2 = specTitle2 == null ? attr2.getValue(Attributes.Name.SPECIFICATION_TITLE) : specTitle2;
            specVersion2 = specVersion2 == null ? attr2.getValue(Attributes.Name.SPECIFICATION_VERSION) : specVersion2;
            specVendor2 = specVendor2 == null ? attr2.getValue(Attributes.Name.SPECIFICATION_VENDOR) : specVendor2;
            implTitle2 = implTitle2 == null ? attr2.getValue(Attributes.Name.IMPLEMENTATION_TITLE) : implTitle2;
            implVersion2 = implVersion2 == null ? attr2.getValue(Attributes.Name.IMPLEMENTATION_VERSION) : implVersion2;
            implVendor2 = implVendor2 == null ? attr2.getValue(Attributes.Name.IMPLEMENTATION_VENDOR) : implVendor2;
            if (sealed == null) {
                sealed = attr2.getValue(Attributes.Name.SEALED);
            }
        }
        sealBase2 = "true".equalsIgnoreCase(sealed) ? url : sealBase2;
        this.pkgName = name;
        this.specTitle = specTitle2;
        this.specVersion = specVersion2;
        this.specVendor = specVendor2;
        this.implTitle = implTitle2;
        this.implVersion = implVersion2;
        this.implVendor = implVendor2;
        this.sealBase = sealBase2;
        this.loader = loader2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r5 = r5.replace('.', '/').concat("/");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Package getSystemPackage(java.lang.String r5) {
        /*
            java.util.Map<java.lang.String, java.lang.Package> r3 = pkgs
            monitor-enter(r3)
            java.util.Map<java.lang.String, java.lang.Package> r2 = pkgs     // Catch:{ all -> 0x0028 }
            java.lang.Object r1 = r2.get(r5)     // Catch:{ all -> 0x0028 }
            java.lang.Package r1 = (java.lang.Package) r1     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0026
            r2 = 46
            r4 = 47
            java.lang.String r2 = r5.replace((char) r2, (char) r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "/"
            java.lang.String r5 = r2.concat(r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = getSystemPackage0(r5)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            java.lang.Package r1 = defineSystemPackage(r5, r0)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r3)
            return r1
        L_0x0028:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Package.getSystemPackage(java.lang.String):java.lang.Package");
    }

    static Package[] getSystemPackages() {
        Package[] packageArr;
        String[] names = getSystemPackages0();
        synchronized (pkgs) {
            for (int i = 0; i < names.length; i++) {
                defineSystemPackage(names[i], getSystemPackage0(names[i]));
            }
            packageArr = (Package[]) pkgs.values().toArray(new Package[pkgs.size()]);
        }
        return packageArr;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private static java.lang.Package defineSystemPackage(java.lang.String r1, java.lang.String r2) {
        /*
            java.lang.Package$1 r0 = new java.lang.Package$1
            r0.<init>(r1, r2)
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)
            java.lang.Package r0 = (java.lang.Package) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Package.defineSystemPackage(java.lang.String, java.lang.String):java.lang.Package");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x003a A[SYNTHETIC, Splitter:B:35:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0040 A[SYNTHETIC, Splitter:B:39:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0046 A[SYNTHETIC, Splitter:B:43:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x005d A[Catch:{ IOException -> 0x0047 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.jar.Manifest loadManifest(java.lang.String r10) {
        /*
            r7 = 0
            r1 = 0
            r3 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0032, all -> 0x005e }
            r2.<init>((java.lang.String) r10)     // Catch:{ Throwable -> 0x0032, all -> 0x005e }
            java.util.jar.JarInputStream r4 = new java.util.jar.JarInputStream     // Catch:{ Throwable -> 0x006a, all -> 0x0061 }
            r5 = 0
            r4.<init>(r2, r5)     // Catch:{ Throwable -> 0x006a, all -> 0x0061 }
            java.util.jar.Manifest r8 = r4.getManifest()     // Catch:{ Throwable -> 0x006d, all -> 0x0065 }
            if (r4 == 0) goto L_0x0017
            r4.close()     // Catch:{ Throwable -> 0x0025 }
        L_0x0017:
            r6 = r7
        L_0x0018:
            if (r2 == 0) goto L_0x001d
            r2.close()     // Catch:{ Throwable -> 0x0027 }
        L_0x001d:
            r5 = r6
        L_0x001e:
            if (r5 == 0) goto L_0x0031
            throw r5     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            r0 = move-exception
            r3 = r4
            r1 = r2
        L_0x0024:
            return r7
        L_0x0025:
            r6 = move-exception
            goto L_0x0018
        L_0x0027:
            r5 = move-exception
            if (r6 == 0) goto L_0x001e
            if (r6 == r5) goto L_0x001d
            r6.addSuppressed(r5)     // Catch:{ IOException -> 0x0021 }
            r5 = r6
            goto L_0x001e
        L_0x0031:
            return r8
        L_0x0032:
            r5 = move-exception
        L_0x0033:
            throw r5     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r6 = move-exception
            r9 = r6
            r6 = r5
            r5 = r9
        L_0x0038:
            if (r3 == 0) goto L_0x003d
            r3.close()     // Catch:{ Throwable -> 0x0049 }
        L_0x003d:
            r8 = r6
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ Throwable -> 0x0053 }
        L_0x0043:
            r6 = r8
        L_0x0044:
            if (r6 == 0) goto L_0x005d
            throw r6     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            r0 = move-exception
            goto L_0x0024
        L_0x0049:
            r8 = move-exception
            if (r6 == 0) goto L_0x003e
            if (r6 == r8) goto L_0x003d
            r6.addSuppressed(r8)     // Catch:{ IOException -> 0x0047 }
            r8 = r6
            goto L_0x003e
        L_0x0053:
            r6 = move-exception
            if (r8 == 0) goto L_0x0044
            if (r8 == r6) goto L_0x0043
            r8.addSuppressed(r6)     // Catch:{ IOException -> 0x0047 }
            r6 = r8
            goto L_0x0044
        L_0x005d:
            throw r5     // Catch:{ IOException -> 0x0047 }
        L_0x005e:
            r5 = move-exception
            r6 = r7
            goto L_0x0038
        L_0x0061:
            r5 = move-exception
            r6 = r7
            r1 = r2
            goto L_0x0038
        L_0x0065:
            r5 = move-exception
            r6 = r7
            r3 = r4
            r1 = r2
            goto L_0x0038
        L_0x006a:
            r5 = move-exception
            r1 = r2
            goto L_0x0033
        L_0x006d:
            r5 = move-exception
            r3 = r4
            r1 = r2
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Package.loadManifest(java.lang.String):java.util.jar.Manifest");
    }
}
