package java.lang;

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
public class Shutdown {
    private static final int FINALIZERS = 2;
    private static final int HOOKS = 1;
    private static final int MAX_SYSTEM_HOOKS = 10;
    private static final int RUNNING = 0;
    private static int currentRunningHook;
    private static Object haltLock;
    private static final Runnable[] hooks = null;
    private static Object lock;
    private static boolean runFinalizersOnExit;
    private static int state;

    private static class Lock {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.lang.Shutdown.Lock.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        private Lock() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.lang.Shutdown.Lock.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.Shutdown.Lock.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.lang.Shutdown.Lock.<init>(java.lang.Shutdown$Lock):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        /* synthetic */ Lock(java.lang.Shutdown.Lock r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.lang.Shutdown.Lock.<init>(java.lang.Shutdown$Lock):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.Shutdown.Lock.<init>(java.lang.Shutdown$Lock):void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.lang.Shutdown.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.lang.Shutdown.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Shutdown.<clinit>():void");
    }

    static native void halt0(int i);

    private static native void runAllFinalizers();

    public Shutdown() {
    }

    static void setRunFinalizersOnExit(boolean run) {
        synchronized (lock) {
            runFinalizersOnExit = run;
        }
    }

    public static void add(int slot, boolean registerShutdownInProgress, Runnable hook) {
        synchronized (lock) {
            if (hooks[slot] != null) {
                throw new InternalError("Shutdown hook at slot " + slot + " already registered");
            }
            if (!registerShutdownInProgress) {
                if (state > 0) {
                    throw new IllegalStateException("Shutdown in progress");
                }
            } else if (state > 1 || (state == 1 && slot <= currentRunningHook)) {
                throw new IllegalStateException("Shutdown in progress");
            }
            hooks[slot] = hook;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001d, code lost:
        if ((r2 instanceof java.lang.ThreadDeath) != false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0022, code lost:
        throw ((java.lang.ThreadDeath) r2);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void runHooks() {
        /*
            r1 = 0
        L_0x0001:
            r4 = 10
            if (r1 >= r4) goto L_0x0023
            java.lang.Object r5 = lock     // Catch:{ Throwable -> 0x001a }
            monitor-enter(r5)     // Catch:{ Throwable -> 0x001a }
            currentRunningHook = r1     // Catch:{ all -> 0x0017 }
            java.lang.Runnable[] r4 = hooks     // Catch:{ all -> 0x0017 }
            r0 = r4[r1]     // Catch:{ all -> 0x0017 }
            monitor-exit(r5)     // Catch:{ Throwable -> 0x001a }
            if (r0 == 0) goto L_0x0014
            r0.run()     // Catch:{ Throwable -> 0x001a }
        L_0x0014:
            int r1 = r1 + 1
            goto L_0x0001
        L_0x0017:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ Throwable -> 0x001a }
            throw r4     // Catch:{ Throwable -> 0x001a }
        L_0x001a:
            r2 = move-exception
            boolean r4 = r2 instanceof java.lang.ThreadDeath
            if (r4 == 0) goto L_0x0014
            r3 = r2
            java.lang.ThreadDeath r3 = (java.lang.ThreadDeath) r3
            throw r3
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Shutdown.runHooks():void");
    }

    static void halt(int status) {
        synchronized (haltLock) {
            halt0(status);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        state = 2;
        r0 = runFinalizersOnExit;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0016, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0017, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        runAllFinalizers();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000b, code lost:
        runHooks();
        r2 = lock;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void sequence() {
        /*
            java.lang.Object r1 = lock
            monitor-enter(r1)
            int r2 = state     // Catch:{ all -> 0x001d }
            r3 = 1
            if (r2 == r3) goto L_0x000a
            monitor-exit(r1)
            return
        L_0x000a:
            monitor-exit(r1)
            runHooks()
            java.lang.Object r2 = lock
            monitor-enter(r2)
            r1 = 2
            state = r1     // Catch:{ all -> 0x0020 }
            boolean r0 = runFinalizersOnExit     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)
            if (r0 == 0) goto L_0x001c
            runAllFinalizers()
        L_0x001c:
            return
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0020:
            r1 = move-exception
            monitor-exit(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Shutdown.sequence():void");
    }

    static void exit(int status) {
        boolean runMoreFinalizers = false;
        synchronized (lock) {
            if (status != 0) {
                runFinalizersOnExit = false;
            }
            switch (state) {
                case 0:
                    state = 1;
                    break;
                case 2:
                    if (status == 0) {
                        runMoreFinalizers = runFinalizersOnExit;
                        break;
                    } else {
                        halt(status);
                        break;
                    }
            }
        }
        if (runMoreFinalizers) {
            runAllFinalizers();
            halt(status);
        }
        synchronized (Shutdown.class) {
            sequence();
            halt(status);
        }
    }

    static void shutdown() {
        synchronized (lock) {
            switch (state) {
                case 0:
                    state = 1;
                    break;
            }
        }
        synchronized (Shutdown.class) {
            sequence();
        }
    }
}
