package sun.security.jca;

import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.ProviderException;
import sun.security.util.Debug;

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
final class ProviderConfig {
    private static final Class[] CL_STRING = null;
    private static final int MAX_LOAD_TRIES = 30;
    private static final String P11_SOL_ARG = "${java.home}/lib/security/sunpkcs11-solaris.cfg";
    private static final String P11_SOL_NAME = "sun.security.pkcs11.SunPKCS11";
    /* access modifiers changed from: private */
    public static final Debug debug = null;
    private final String argument;
    /* access modifiers changed from: private */
    public final String className;
    private boolean isLoading;
    private volatile Provider provider;
    private int tries;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.jca.ProviderConfig.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.jca.ProviderConfig.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.jca.ProviderConfig.<clinit>():void");
    }

    ProviderConfig(String className2, String argument2) {
        if (className2.equals(P11_SOL_NAME) && argument2.equals(P11_SOL_ARG)) {
            checkSunPKCS11Solaris();
        }
        this.className = className2;
        this.argument = expand(argument2);
    }

    ProviderConfig(String className2) {
        this(className2, "");
    }

    ProviderConfig(Provider provider2) {
        this.className = provider2.getClass().getName();
        this.argument = "";
        this.provider = provider2;
    }

    private void checkSunPKCS11Solaris() {
        if (((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>(this) {
            final /* synthetic */ ProviderConfig this$0;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.jca.ProviderConfig.1.run():java.lang.Boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 5 more
                */
            public java.lang.Boolean run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.jca.ProviderConfig.1.run():java.lang.Boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: sun.security.jca.ProviderConfig.AnonymousClass1.run():java.lang.Boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.jca.ProviderConfig.1.run():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 5 more
                */
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.jca.ProviderConfig.1.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: sun.security.jca.ProviderConfig.AnonymousClass1.run():java.lang.Object");
            }
        })) == Boolean.FALSE) {
            this.tries = 30;
        }
    }

    private boolean hasArgument() {
        return this.argument.length() != 0;
    }

    private boolean shouldLoad() {
        return this.tries < 30;
    }

    /* access modifiers changed from: private */
    public void disableLoad() {
        this.tries = 30;
    }

    /* access modifiers changed from: package-private */
    public boolean isLoaded() {
        return this.provider != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProviderConfig)) {
            return false;
        }
        ProviderConfig other = (ProviderConfig) obj;
        if (this.className.equals(other.className)) {
            return this.argument.equals(other.argument);
        }
        return false;
    }

    public int hashCode() {
        return this.className.hashCode() + this.argument.hashCode();
    }

    public String toString() {
        if (hasArgument()) {
            return this.className + "('" + this.argument + "')";
        }
        return this.className;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.security.Provider getProvider() {
        /*
            r5 = this;
            r4 = 0
            monitor-enter(r5)
            java.security.Provider r0 = r5.provider     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x0008
            monitor-exit(r5)
            return r0
        L_0x0008:
            boolean r1 = r5.shouldLoad()     // Catch:{ all -> 0x0057 }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r5)
            return r4
        L_0x0010:
            boolean r1 = r5.isLoading     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x003e
            sun.security.util.Debug r1 = debug     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x003c
            sun.security.util.Debug r1 = debug     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r2.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "Recursion loading provider: "
            java.lang.StringBuilder r2 = r2.append((java.lang.String) r3)     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r2 = r2.append((java.lang.Object) r5)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0057 }
            r1.println(r2)     // Catch:{ all -> 0x0057 }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "Call trace"
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0057 }
            r1.printStackTrace()     // Catch:{ all -> 0x0057 }
        L_0x003c:
            monitor-exit(r5)
            return r4
        L_0x003e:
            r1 = 1
            r5.isLoading = r1     // Catch:{ all -> 0x0052 }
            int r1 = r5.tries     // Catch:{ all -> 0x0052 }
            int r1 = r1 + 1
            r5.tries = r1     // Catch:{ all -> 0x0052 }
            java.security.Provider r0 = r5.doLoadProvider()     // Catch:{ all -> 0x0052 }
            r1 = 0
            r5.isLoading = r1     // Catch:{ all -> 0x0057 }
            r5.provider = r0     // Catch:{ all -> 0x0057 }
            monitor-exit(r5)
            return r0
        L_0x0052:
            r1 = move-exception
            r2 = 0
            r5.isLoading = r2     // Catch:{ all -> 0x0057 }
            throw r1     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r1 = move-exception
            monitor-exit(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.jca.ProviderConfig.getProvider():java.security.Provider");
    }

    private Provider doLoadProvider() {
        return (Provider) AccessController.doPrivileged(new PrivilegedAction<Provider>(this) {
            final /* synthetic */ ProviderConfig this$0;

            {
                this.this$0 = this$0;
            }

            public /* bridge */ /* synthetic */ Object run() {
                return run();
            }

            public Provider run() {
                Throwable t;
                if (ProviderConfig.debug != null) {
                    ProviderConfig.debug.println("Loading provider: " + this.this$0);
                }
                try {
                    return this.this$0.initProvider(this.this$0.className, Object.class.getClassLoader());
                } catch (Exception e) {
                    try {
                        return this.this$0.initProvider(this.this$0.className, ClassLoader.getSystemClassLoader());
                    } catch (Exception e2) {
                        if (e2 instanceof InvocationTargetException) {
                            t = ((InvocationTargetException) e2).getCause();
                        } else {
                            t = e2;
                        }
                        if (ProviderConfig.debug != null) {
                            ProviderConfig.debug.println("Error loading provider " + this.this$0);
                            t.printStackTrace();
                        }
                        if (t instanceof ProviderException) {
                            throw ((ProviderException) t);
                        }
                        if (t instanceof UnsupportedOperationException) {
                            this.this$0.disableLoad();
                        }
                        return null;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public Provider initProvider(String className2, ClassLoader cl) throws Exception {
        Class<?> provClass;
        Object obj;
        if (cl != null) {
            provClass = cl.loadClass(className2);
        } else {
            provClass = Class.forName(className2);
        }
        if (!hasArgument()) {
            obj = provClass.newInstance();
        } else {
            obj = provClass.getConstructor(CL_STRING).newInstance(this.argument);
        }
        if (obj instanceof Provider) {
            if (debug != null) {
                debug.println("Loaded provider " + obj);
            }
            return (Provider) obj;
        }
        if (debug != null) {
            debug.println(className2 + " is not a provider");
        }
        disableLoad();
        return null;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private static java.lang.String expand(java.lang.String r1) {
        /*
            java.lang.String r0 = "${"
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            sun.security.jca.ProviderConfig$3 r0 = new sun.security.jca.ProviderConfig$3
            r0.<init>(r1)
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.jca.ProviderConfig.expand(java.lang.String):java.lang.String");
    }
}
