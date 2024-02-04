package java.util.logging;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import sun.util.logging.PlatformLogger;

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
public class LogManager {
    public static final String LOGGING_MXBEAN_NAME = "java.util.logging:type=Logging";
    private static final int MAX_ITERATIONS = 400;
    /* access modifiers changed from: private */
    public static final Level defaultLevel = null;
    private static LoggingMXBean loggingMXBean;
    /* access modifiers changed from: private */
    public static LogManager manager;
    private PropertyChangeSupport changes;
    private final Permission controlPermission;
    /* access modifiers changed from: private */
    public boolean deathImminent;
    /* access modifiers changed from: private */
    public boolean initializedGlobalHandlers;
    /* access modifiers changed from: private */
    public final ReferenceQueue<Logger> loggerRefQueue;
    private Properties props;
    private volatile boolean readPrimordialConfiguration;
    /* access modifiers changed from: private */
    public Logger rootLogger;
    /* access modifiers changed from: private */
    public final LoggerContext systemContext;
    /* access modifiers changed from: private */
    public final LoggerContext userContext;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.logging.LogManager.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.logging.LogManager.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.LogManager.<clinit>():void");
    }

    private class Cleaner extends Thread {
        final /* synthetic */ LogManager this$0;

        /* synthetic */ Cleaner(LogManager this$02, Cleaner cleaner) {
            this(this$02);
        }

        private Cleaner(LogManager this$02) {
            this.this$0 = this$02;
            setContextClassLoader((ClassLoader) null);
        }

        public void run() {
            LogManager r0 = LogManager.manager;
            synchronized (this.this$0) {
                boolean unused = this.this$0.deathImminent = true;
                boolean unused2 = this.this$0.initializedGlobalHandlers = true;
            }
            this.this$0.reset();
        }
    }

    protected LogManager() {
        this.props = new Properties();
        this.changes = new PropertyChangeSupport(LogManager.class);
        this.systemContext = new SystemLoggerContext();
        this.userContext = new LoggerContext((LoggerContext) null);
        this.initializedGlobalHandlers = true;
        this.loggerRefQueue = new ReferenceQueue<>();
        this.controlPermission = new LoggingPermission("control", (String) null);
        try {
            Runtime.getRuntime().addShutdownHook(new Cleaner(this, (Cleaner) null));
        } catch (IllegalStateException e) {
        }
    }

    public static LogManager getLogManager() {
        if (manager != null) {
            manager.readPrimordialConfiguration();
        }
        return manager;
    }

    private void readPrimordialConfiguration() {
        if (!this.readPrimordialConfiguration) {
            synchronized (this) {
                if (!this.readPrimordialConfiguration) {
                    if (System.out != null) {
                        this.readPrimordialConfiguration = true;
                        try {
                            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                                public Void run() throws Exception {
                                    LogManager.this.readConfiguration();
                                    PlatformLogger.redirectPlatformLoggers();
                                    return null;
                                }
                            });
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener l) throws SecurityException {
        if (l == null) {
            throw new NullPointerException();
        }
        checkPermission();
        this.changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) throws SecurityException {
        checkPermission();
        this.changes.removePropertyChangeListener(l);
    }

    private LoggerContext getUserContext() {
        return this.userContext;
    }

    private List<LoggerContext> contexts() {
        List<LoggerContext> cxs = new ArrayList<>();
        cxs.add(this.systemContext);
        cxs.add(getUserContext());
        return cxs;
    }

    /* access modifiers changed from: package-private */
    public Logger demandLogger(String name, String resourceBundleName, Class<?> caller) {
        Logger result = getLogger(name);
        if (result == null) {
            Logger newLogger = new Logger(name, resourceBundleName, caller);
            while (!addLogger(newLogger)) {
                result = getLogger(name);
                if (result != null) {
                }
            }
            return newLogger;
        }
        return result;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    java.util.logging.Logger demandSystemLogger(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.util.logging.LogManager$LoggerContext r3 = r4.systemContext
            java.util.logging.Logger r2 = r3.demandLogger(r5, r6)
        L_0x0006:
            boolean r3 = r4.addLogger(r2)
            if (r3 == 0) goto L_0x0022
            r1 = r2
        L_0x000d:
            if (r1 == 0) goto L_0x0006
            if (r1 == r2) goto L_0x0021
            java.util.logging.Handler[] r3 = r2.getHandlers()
            int r3 = r3.length
            if (r3 != 0) goto L_0x0021
            r0 = r1
            java.util.logging.LogManager$3 r3 = new java.util.logging.LogManager$3
            r3.<init>(r4, r0, r2)
            java.security.AccessController.doPrivileged(r3)
        L_0x0021:
            return r2
        L_0x0022:
            java.util.logging.Logger r1 = r4.getLogger(r5)
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.LogManager.demandSystemLogger(java.lang.String, java.lang.String):java.util.logging.Logger");
    }

    /* access modifiers changed from: private */
    public static Class getClassInstance(String cname) {
        if (cname == null) {
            return null;
        }
        try {
            return ClassLoader.getSystemClassLoader().loadClass(cname);
        } catch (ClassNotFoundException e) {
            try {
                return Thread.currentThread().getContextClassLoader().loadClass(cname);
            } catch (ClassNotFoundException e2) {
                return null;
            }
        }
    }

    static class LoggerContext {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f58assertionsDisabled = false;
        private final Hashtable<String, LoggerWeakRef> namedLoggers;
        private final boolean requiresDefaultLoggers;
        private final LogNode root;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.logging.LogManager.LoggerContext.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.logging.LogManager.LoggerContext.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.logging.LogManager.LoggerContext.<clinit>():void");
        }

        /* synthetic */ LoggerContext(LoggerContext loggerContext) {
            this();
        }

        private LoggerContext() {
            this(false);
        }

        private LoggerContext(boolean requiresDefaultLoggers2) {
            this.namedLoggers = new Hashtable<>();
            this.root = new LogNode((LogNode) null, this);
            this.requiresDefaultLoggers = requiresDefaultLoggers2;
        }

        /* access modifiers changed from: package-private */
        public Logger demandLogger(String name, String resourceBundleName) {
            return LogManager.manager.demandLogger(name, resourceBundleName, (Class<?>) null);
        }

        private void ensureInitialized() {
            if (this.requiresDefaultLoggers) {
                ensureDefaultLogger(LogManager.manager.rootLogger);
                ensureDefaultLogger(Logger.global);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized java.util.logging.Logger findLogger(java.lang.String r5) {
            /*
                r4 = this;
                r3 = 0
                monitor-enter(r4)
                r4.ensureInitialized()     // Catch:{ all -> 0x001e }
                java.util.Hashtable<java.lang.String, java.util.logging.LogManager$LoggerWeakRef> r2 = r4.namedLoggers     // Catch:{ all -> 0x001e }
                java.lang.Object r1 = r2.get(r5)     // Catch:{ all -> 0x001e }
                java.util.logging.LogManager$LoggerWeakRef r1 = (java.util.logging.LogManager.LoggerWeakRef) r1     // Catch:{ all -> 0x001e }
                if (r1 != 0) goto L_0x0011
                monitor-exit(r4)
                return r3
            L_0x0011:
                java.lang.Object r0 = r1.get()     // Catch:{ all -> 0x001e }
                java.util.logging.Logger r0 = (java.util.logging.Logger) r0     // Catch:{ all -> 0x001e }
                if (r0 != 0) goto L_0x001c
                r4.removeLogger(r5)     // Catch:{ all -> 0x001e }
            L_0x001c:
                monitor-exit(r4)
                return r0
            L_0x001e:
                r2 = move-exception
                monitor-exit(r4)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.logging.LogManager.LoggerContext.findLogger(java.lang.String):java.util.logging.Logger");
        }

        private void ensureAllDefaultLoggers(Logger logger) {
            if (this.requiresDefaultLoggers) {
                String name = logger.getName();
                if (!name.isEmpty()) {
                    ensureDefaultLogger(LogManager.manager.rootLogger);
                }
                if (!Logger.GLOBAL_LOGGER_NAME.equals(name)) {
                    ensureDefaultLogger(Logger.global);
                }
            }
        }

        private void ensureDefaultLogger(Logger logger) {
            boolean z = false;
            if (!this.requiresDefaultLoggers || logger == null || !(logger == Logger.global || logger == LogManager.manager.rootLogger)) {
                if (!f58assertionsDisabled) {
                    if (logger == null) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            } else if (!this.namedLoggers.containsKey(logger.getName())) {
                addLocalLogger(logger, false);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean addLocalLogger(Logger logger) {
            return addLocalLogger(logger, this.requiresDefaultLoggers);
        }

        /* access modifiers changed from: package-private */
        public boolean addLocalLogger(Logger logger, LogManager manager) {
            return addLocalLogger(logger, this.requiresDefaultLoggers, manager);
        }

        /* access modifiers changed from: package-private */
        public boolean addLocalLogger(Logger logger, boolean addDefaultLoggersIfNeeded) {
            return addLocalLogger(logger, addDefaultLoggersIfNeeded, LogManager.manager);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean addLocalLogger(Logger logger, boolean addDefaultLoggersIfNeeded, LogManager manager) {
            if (addDefaultLoggersIfNeeded) {
                ensureAllDefaultLoggers(logger);
            }
            String name = logger.getName();
            if (name == null) {
                throw new NullPointerException();
            }
            LoggerWeakRef ref = this.namedLoggers.get(name);
            if (ref != null) {
                if (ref.get() != null) {
                    return false;
                }
                removeLogger(name);
            }
            manager.getClass();
            LoggerWeakRef ref2 = new LoggerWeakRef(manager, logger);
            this.namedLoggers.put(name, ref2);
            Level level = manager.getLevelProperty(name + ".level", (Level) null);
            if (level != null) {
                LogManager.doSetLevel(logger, level);
            }
            processParentHandlers(logger, name);
            LogNode node = getNode(name);
            node.loggerRef = ref2;
            Logger parent = null;
            for (LogNode nodep = node.parent; nodep != null; nodep = nodep.parent) {
                LoggerWeakRef nodeRef = nodep.loggerRef;
                if (nodeRef != null && (parent = (Logger) nodeRef.get()) != null) {
                    break;
                }
            }
            if (parent != null) {
                LogManager.doSetParent(logger, parent);
            }
            node.walkAndSetParent(logger);
            ref2.setNode(node);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void removeLogger(String name) {
            this.namedLoggers.remove(name);
        }

        /* access modifiers changed from: package-private */
        public synchronized Enumeration<String> getLoggerNames() {
            ensureInitialized();
            return this.namedLoggers.keys();
        }

        private void processParentHandlers(final Logger logger, final String name) {
            AccessController.doPrivileged(new PrivilegedAction<Void>(this) {
                final /* synthetic */ LoggerContext this$1;

                {
                    this.this$1 = this$1;
                    logger = val$logger;
                    name = val$name;
                }

                public /* bridge */ /* synthetic */ Object run() {
                    return run();
                }

                public Void run() {
                    if (logger == LogManager.manager.rootLogger || LogManager.manager.getBooleanProperty(name + ".useParentHandlers", true)) {
                        return null;
                    }
                    logger.setUseParentHandlers(false);
                    return null;
                }
            });
            int ix = 1;
            while (true) {
                int ix2 = name.indexOf(".", ix);
                if (ix2 >= 0) {
                    String pname = name.substring(0, ix2);
                    if (LogManager.manager.getProperty(pname + ".level") != null || LogManager.manager.getProperty(pname + ".handlers") != null) {
                        demandLogger(pname, (String) null);
                    }
                    ix = ix2 + 1;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public LogNode getNode(String name) {
            String head;
            if (name == null || name.equals("")) {
                return this.root;
            }
            LogNode node = this.root;
            while (name.length() > 0) {
                int ix = name.indexOf(".");
                if (ix > 0) {
                    head = name.substring(0, ix);
                    name = name.substring(ix + 1);
                } else {
                    head = name;
                    name = "";
                }
                if (node.children == null) {
                    node.children = new HashMap<>();
                }
                LogNode child = node.children.get(head);
                if (child == null) {
                    child = new LogNode(node, this);
                    node.children.put(head, child);
                }
                node = child;
            }
            return node;
        }
    }

    static class SystemLoggerContext extends LoggerContext {
        SystemLoggerContext() {
            super((LoggerContext) null);
        }

        /* access modifiers changed from: package-private */
        public Logger demandLogger(String name, String resourceBundleName) {
            Logger result = findLogger(name);
            if (result == null) {
                Logger newLogger = new Logger(name, resourceBundleName);
                do {
                    if (addLocalLogger(newLogger)) {
                        result = newLogger;
                        continue;
                    } else {
                        result = findLogger(name);
                        continue;
                    }
                } while (result == null);
            }
            return result;
        }
    }

    private void loadLoggerHandlers(final Logger logger, String name, final String handlersPropertyName) {
        AccessController.doPrivileged(new PrivilegedAction<Object>(this) {
            final /* synthetic */ LogManager this$0;

            {
                this.this$0 = this$0;
                handlersPropertyName = val$handlersPropertyName;
                logger = val$logger;
            }

            public Object run() {
                String[] names = this.this$0.parseClassNames(handlersPropertyName);
                for (String word : names) {
                    try {
                        Handler hdl = (Handler) LogManager.getClassInstance(word).newInstance();
                        String levs = this.this$0.getProperty(word + ".level");
                        if (levs != null) {
                            Level l = Level.findLevel(levs);
                            if (l != null) {
                                hdl.setLevel(l);
                            } else {
                                System.err.println("Can't set level for " + word);
                            }
                        }
                        logger.addHandler(hdl);
                    } catch (Exception ex) {
                        System.err.println("Can't load log handler \"" + word + "\"");
                        System.err.println("" + ex);
                        ex.printStackTrace();
                    }
                }
                return null;
            }
        });
    }

    final class LoggerWeakRef extends WeakReference<Logger> {
        private String name;
        private LogNode node;
        private WeakReference<Logger> parentRef;
        final /* synthetic */ LogManager this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        LoggerWeakRef(LogManager this$02, Logger logger) {
            super(logger, this$02.loggerRefQueue);
            this.this$0 = this$02;
            this.name = logger.getName();
        }

        /* access modifiers changed from: package-private */
        public void dispose() {
            if (this.node != null) {
                this.node.context.removeLogger(this.name);
                this.name = null;
                this.node.loggerRef = null;
                this.node = null;
            }
            if (this.parentRef != null) {
                Logger parent = this.parentRef.get();
                if (parent != null) {
                    parent.removeChildLogger(this);
                }
                this.parentRef = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void setNode(LogNode node2) {
            this.node = node2;
        }

        /* access modifiers changed from: package-private */
        public void setParentRef(WeakReference<Logger> parentRef2) {
            this.parentRef = parentRef2;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void drainLoggerRefQueueBounded() {
        int i = 0;
        while (i < 400) {
            if (this.loggerRefQueue != null) {
                LoggerWeakRef ref = (LoggerWeakRef) this.loggerRefQueue.poll();
                if (ref == null) {
                    break;
                }
                ref.dispose();
                i++;
            } else {
                break;
            }
        }
    }

    public boolean addLogger(Logger logger) {
        String name = logger.getName();
        if (name == null) {
            throw new NullPointerException();
        }
        drainLoggerRefQueueBounded();
        if (!getUserContext().addLocalLogger(logger, this)) {
            return false;
        }
        loadLoggerHandlers(logger, name, name + ".handlers");
        return true;
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static void doSetLevel(java.util.logging.Logger r2, java.util.logging.Level r3) {
        /*
            java.lang.SecurityManager r0 = java.lang.System.getSecurityManager()
            if (r0 != 0) goto L_0x000a
            r2.setLevel(r3)
            return
        L_0x000a:
            java.util.logging.LogManager$5 r1 = new java.util.logging.LogManager$5
            r1.<init>(r2, r3)
            java.security.AccessController.doPrivileged(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.LogManager.doSetLevel(java.util.logging.Logger, java.util.logging.Level):void");
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public static void doSetParent(java.util.logging.Logger r2, java.util.logging.Logger r3) {
        /*
            java.lang.SecurityManager r0 = java.lang.System.getSecurityManager()
            if (r0 != 0) goto L_0x000a
            r2.setParent(r3)
            return
        L_0x000a:
            java.util.logging.LogManager$6 r1 = new java.util.logging.LogManager$6
            r1.<init>(r2, r3)
            java.security.AccessController.doPrivileged(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.LogManager.doSetParent(java.util.logging.Logger, java.util.logging.Logger):void");
    }

    public Logger getLogger(String name) {
        return getUserContext().findLogger(name);
    }

    public Enumeration<String> getLoggerNames() {
        return getUserContext().getLoggerNames();
    }

    public void readConfiguration() throws IOException, SecurityException {
        InputStream in;
        checkPermission();
        String cname = System.getProperty("java.util.logging.config.class");
        if (cname != null) {
            try {
                getClassInstance(cname).newInstance();
                return;
            } catch (Exception ex) {
                System.err.println("Logging configuration class \"" + cname + "\" failed");
                System.err.println("" + ex);
            }
        }
        String fname = System.getProperty("java.util.logging.config.file");
        if (fname == null) {
            String fname2 = System.getProperty("java.home");
            if (fname2 == null) {
                throw new Error("Can't find java.home ??");
            }
            fname = new File(new File(fname2, "lib"), "logging.properties").getCanonicalPath();
        }
        try {
            in = new FileInputStream(fname);
        } catch (Exception e) {
            in = LogManager.class.getResourceAsStream("logging.properties");
            if (in == null) {
                throw e;
            }
        }
        try {
            readConfiguration(new BufferedInputStream(in));
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void reset() throws SecurityException {
        checkPermission();
        synchronized (this) {
            this.props = new Properties();
            this.initializedGlobalHandlers = true;
        }
        for (LoggerContext cx : contexts()) {
            Enumeration<String> enum_ = cx.getLoggerNames();
            while (enum_.hasMoreElements()) {
                Logger logger = cx.findLogger(enum_.nextElement());
                if (logger != null) {
                    resetLogger(logger);
                }
            }
        }
    }

    private void resetLogger(Logger logger) {
        Handler[] targets = logger.getHandlers();
        for (Handler h : targets) {
            logger.removeHandler(h);
            try {
                h.close();
            } catch (Exception e) {
            }
        }
        String name = logger.getName();
        if (name == null || !name.equals("")) {
            logger.setLevel((Level) null);
        } else {
            logger.setLevel(defaultLevel);
        }
    }

    /* access modifiers changed from: private */
    public String[] parseClassNames(String propertyName) {
        String hands = getProperty(propertyName);
        if (hands == null) {
            return new String[0];
        }
        String hands2 = hands.trim();
        int ix = 0;
        Vector<String> result = new Vector<>();
        while (ix < hands2.length()) {
            int end = ix;
            while (end < hands2.length() && !Character.isWhitespace(hands2.charAt(end)) && hands2.charAt(end) != ',') {
                end++;
            }
            String word = hands2.substring(ix, end);
            ix = end + 1;
            String word2 = word.trim();
            if (word2.length() != 0) {
                result.add(word2);
            }
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    public void readConfiguration(InputStream ins) throws IOException, SecurityException {
        checkPermission();
        reset();
        this.props.load(ins);
        String[] names = parseClassNames("config");
        for (String word : names) {
            try {
                getClassInstance(word).newInstance();
            } catch (Exception ex) {
                System.err.println("Can't load config class \"" + word + "\"");
                System.err.println("" + ex);
            }
        }
        setLevelsOnExistingLoggers();
        this.changes.firePropertyChange((String) null, (Object) null, (Object) null);
        synchronized (this) {
            this.initializedGlobalHandlers = false;
        }
    }

    public String getProperty(String name) {
        return this.props.getProperty(name);
    }

    /* access modifiers changed from: package-private */
    public String getStringProperty(String name, String defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        return val.trim();
    }

    /* access modifiers changed from: package-private */
    public int getIntProperty(String name, int defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(val.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean getBooleanProperty(String name, boolean defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        String val2 = val.toLowerCase();
        if (val2.equals("true") || val2.equals("1")) {
            return true;
        }
        if (val2.equals("false") || val2.equals("0")) {
            return false;
        }
        return defaultValue;
    }

    /* access modifiers changed from: package-private */
    public Level getLevelProperty(String name, Level defaultValue) {
        String val = getProperty(name);
        if (val == null) {
            return defaultValue;
        }
        Level l = Level.findLevel(val.trim());
        return l != null ? l : defaultValue;
    }

    /* access modifiers changed from: package-private */
    public Filter getFilterProperty(String name, Filter defaultValue) {
        String val = getProperty(name);
        if (val != null) {
            try {
                return (Filter) getClassInstance(val).newInstance();
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    /* access modifiers changed from: package-private */
    public Formatter getFormatterProperty(String name, Formatter defaultValue) {
        String val = getProperty(name);
        if (val != null) {
            try {
                return (Formatter) getClassInstance(val).newInstance();
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    /* access modifiers changed from: private */
    public synchronized void initializeGlobalHandlers() {
        if (!this.initializedGlobalHandlers) {
            this.initializedGlobalHandlers = true;
            if (!this.deathImminent) {
                loadLoggerHandlers(this.rootLogger, (String) null, "handlers");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(this.controlPermission);
        }
    }

    public void checkAccess() throws SecurityException {
        checkPermission();
    }

    private static class LogNode {
        HashMap<String, LogNode> children;
        final LoggerContext context;
        LoggerWeakRef loggerRef;
        LogNode parent;

        LogNode(LogNode parent2, LoggerContext context2) {
            this.parent = parent2;
            this.context = context2;
        }

        /* access modifiers changed from: package-private */
        public void walkAndSetParent(Logger parent2) {
            if (this.children != null) {
                for (LogNode node : this.children.values()) {
                    LoggerWeakRef ref = node.loggerRef;
                    Logger logger = ref == null ? null : (Logger) ref.get();
                    if (logger == null) {
                        node.walkAndSetParent(parent2);
                    } else {
                        LogManager.doSetParent(logger, parent2);
                    }
                }
            }
        }
    }

    private class RootLogger extends Logger {
        final /* synthetic */ LogManager this$0;

        /* synthetic */ RootLogger(LogManager this$02, RootLogger rootLogger) {
            this(this$02);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private RootLogger(LogManager this$02) {
            super("", (String) null);
            this.this$0 = this$02;
            setLevel(LogManager.defaultLevel);
        }

        public void log(LogRecord record) {
            this.this$0.initializeGlobalHandlers();
            super.log(record);
        }

        public void addHandler(Handler h) {
            this.this$0.initializeGlobalHandlers();
            super.addHandler(h);
        }

        public void removeHandler(Handler h) {
            this.this$0.initializeGlobalHandlers();
            super.removeHandler(h);
        }

        public Handler[] getHandlers() {
            this.this$0.initializeGlobalHandlers();
            return super.getHandlers();
        }
    }

    private synchronized void setLevelsOnExistingLoggers() {
        Enumeration<?> enum_ = this.props.propertyNames();
        while (enum_.hasMoreElements()) {
            String key = (String) enum_.nextElement();
            if (key.endsWith(".level")) {
                String name = key.substring(0, key.length() - 6);
                Level level = getLevelProperty(key, (Level) null);
                if (level == null) {
                    System.err.println("Bad level value for property: " + key);
                } else {
                    for (LoggerContext cx : contexts()) {
                        Logger l = cx.findLogger(name);
                        if (l != null) {
                            l.setLevel(level);
                        }
                    }
                }
            }
        }
    }

    public static synchronized LoggingMXBean getLoggingMXBean() {
        LoggingMXBean loggingMXBean2;
        synchronized (LogManager.class) {
            if (loggingMXBean == null) {
                loggingMXBean = new Logging();
            }
            loggingMXBean2 = loggingMXBean;
        }
        return loggingMXBean2;
    }
}
