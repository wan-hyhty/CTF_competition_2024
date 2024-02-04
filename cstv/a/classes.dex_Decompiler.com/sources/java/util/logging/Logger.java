package java.util.logging;

import dalvik.system.VMStack;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.LogManager;
import sun.reflect.CallerSensitive;

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
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class Logger {
    public static final String GLOBAL_LOGGER_NAME = "global";
    static final String SYSTEM_LOGGER_RB_NAME = "sun.util.logging.resources.logging";
    private static final Handler[] emptyHandlers = null;
    @Deprecated
    public static final Logger global = null;
    private static final int offValue = 0;
    private static Object treeLock;
    private boolean anonymous;
    private WeakReference<ClassLoader> callersClassLoaderRef;
    private ResourceBundle catalog;
    private Locale catalogLocale;
    private String catalogName;
    private volatile Filter filter;
    private final CopyOnWriteArrayList<Handler> handlers;
    private ArrayList<LogManager.LoggerWeakRef> kids;
    private volatile Level levelObject;
    private volatile int levelValue;
    private LogManager manager;
    private String name;
    private volatile Logger parent;
    private String resourceBundleName;
    private volatile boolean useParentHandlers;

    private static class LoggerHelper {
        static boolean allowStackWalkSearch;
        static boolean disableCallerCheck;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.logging.Logger.LoggerHelper.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.logging.Logger.LoggerHelper.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Logger.LoggerHelper.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.logging.Logger.LoggerHelper.<init>():void, dex: classes.dex
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
        private LoggerHelper() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.logging.Logger.LoggerHelper.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Logger.LoggerHelper.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.logging.Logger.LoggerHelper.getBooleanProperty(java.lang.String):boolean, dex: classes.dex
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
        private static boolean getBooleanProperty(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.logging.Logger.LoggerHelper.getBooleanProperty(java.lang.String):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Logger.LoggerHelper.getBooleanProperty(java.lang.String):boolean");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.logging.Logger.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.logging.Logger.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Logger.<clinit>():void");
    }

    public static final Logger getGlobal() {
        return global;
    }

    protected Logger(String name2, String resourceBundleName2) {
        this(name2, resourceBundleName2, (Class<?>) null);
    }

    Logger(String name2, String resourceBundleName2, Class<?> caller) {
        this.handlers = new CopyOnWriteArrayList<>();
        this.useParentHandlers = true;
        this.manager = LogManager.getLogManager();
        setupResourceInfo(resourceBundleName2, caller);
        this.name = name2;
        this.levelValue = Level.INFO.intValue();
    }

    private void setCallersClassLoaderRef(Class<?> caller) {
        ClassLoader callersClassLoader = null;
        if (caller != null) {
            callersClassLoader = caller.getClassLoader();
        }
        if (callersClassLoader != null) {
            this.callersClassLoaderRef = new WeakReference<>(callersClassLoader);
        }
    }

    private ClassLoader getCallersClassLoader() {
        if (this.callersClassLoaderRef != null) {
            return this.callersClassLoaderRef.get();
        }
        return null;
    }

    private Logger(String name2) {
        this.handlers = new CopyOnWriteArrayList<>();
        this.useParentHandlers = true;
        this.name = name2;
        this.levelValue = Level.INFO.intValue();
    }

    /* access modifiers changed from: package-private */
    public void setLogManager(LogManager manager2) {
        this.manager = manager2;
    }

    private void checkPermission() throws SecurityException {
        if (!this.anonymous) {
            if (this.manager == null) {
                this.manager = LogManager.getLogManager();
            }
            this.manager.checkPermission();
        }
    }

    private static Logger demandLogger(String name2, String resourceBundleName2, Class<?> caller) {
        LogManager manager2 = LogManager.getLogManager();
        if (System.getSecurityManager() == null || LoggerHelper.disableCallerCheck || caller.getClassLoader() != null) {
            return manager2.demandLogger(name2, resourceBundleName2, caller);
        }
        return manager2.demandSystemLogger(name2, resourceBundleName2);
    }

    @CallerSensitive
    public static Logger getLogger(String name2) {
        return demandLogger(name2, (String) null, VMStack.getStackClass1());
    }

    @CallerSensitive
    public static Logger getLogger(String name2, String resourceBundleName2) {
        Class<?> callerClass = VMStack.getStackClass1();
        Logger result = demandLogger(name2, resourceBundleName2, callerClass);
        if (result.resourceBundleName == null) {
            result.setupResourceInfo(resourceBundleName2, callerClass);
        } else if (!result.resourceBundleName.equals(resourceBundleName2)) {
            throw new IllegalArgumentException(result.resourceBundleName + " != " + resourceBundleName2);
        }
        return result;
    }

    static Logger getPlatformLogger(String name2) {
        return LogManager.getLogManager().demandSystemLogger(name2, SYSTEM_LOGGER_RB_NAME);
    }

    public static Logger getAnonymousLogger() {
        return getAnonymousLogger((String) null);
    }

    @CallerSensitive
    public static Logger getAnonymousLogger(String resourceBundleName2) {
        LogManager manager2 = LogManager.getLogManager();
        manager2.drainLoggerRefQueueBounded();
        Logger result = new Logger((String) null, resourceBundleName2, VMStack.getStackClass1());
        result.anonymous = true;
        result.doSetParent(manager2.getLogger(""));
        return result;
    }

    public ResourceBundle getResourceBundle() {
        return findResourceBundle(getResourceBundleName(), true);
    }

    public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    public void setFilter(Filter newFilter) throws SecurityException {
        checkPermission();
        this.filter = newFilter;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public void log(LogRecord record) {
        if (record.getLevel().intValue() >= this.levelValue && this.levelValue != offValue) {
            Filter theFilter = this.filter;
            if (theFilter == null || theFilter.isLoggable(record)) {
                Logger logger = this;
                while (logger != null) {
                    for (Handler handler : logger.getHandlers()) {
                        handler.publish(record);
                    }
                    if (logger.getUseParentHandlers()) {
                        logger = logger.getParent();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void doLog(LogRecord lr) {
        lr.setLoggerName(this.name);
        String ebname = getEffectiveResourceBundleName();
        if (ebname != null && !ebname.equals(SYSTEM_LOGGER_RB_NAME)) {
            lr.setResourceBundleName(ebname);
            lr.setResourceBundle(findResourceBundle(ebname, true));
        }
        log(lr);
    }

    public void log(Level level, String msg) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            doLog(new LogRecord(level, msg));
        }
    }

    public void log(Level level, String msg, Object param1) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setParameters(new Object[]{param1});
            doLog(lr);
        }
    }

    public void log(Level level, String msg, Object[] params) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setParameters(params);
            doLog(lr);
        }
    }

    public void log(Level level, String msg, Throwable thrown) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setThrown(thrown);
            doLog(lr);
        }
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            doLog(lr);
        }
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object param1) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            lr.setParameters(new Object[]{param1});
            doLog(lr);
        }
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object[] params) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            lr.setParameters(params);
            doLog(lr);
        }
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Throwable thrown) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            lr.setThrown(thrown);
            doLog(lr);
        }
    }

    private void doLog(LogRecord lr, String rbname) {
        lr.setLoggerName(this.name);
        if (rbname != null) {
            lr.setResourceBundleName(rbname);
            lr.setResourceBundle(findResourceBundle(rbname, false));
        }
        log(lr);
    }

    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            doLog(lr, bundleName);
        }
    }

    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object param1) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            lr.setParameters(new Object[]{param1});
            doLog(lr, bundleName);
        }
    }

    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object[] params) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            lr.setParameters(params);
            doLog(lr, bundleName);
        }
    }

    public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Throwable thrown) {
        if (level.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(level, msg);
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            lr.setThrown(thrown);
            doLog(lr, bundleName);
        }
    }

    public void entering(String sourceClass, String sourceMethod) {
        if (Level.FINER.intValue() >= this.levelValue) {
            logp(Level.FINER, sourceClass, sourceMethod, "ENTRY");
        }
    }

    public void entering(String sourceClass, String sourceMethod, Object param1) {
        if (Level.FINER.intValue() >= this.levelValue) {
            logp(Level.FINER, sourceClass, sourceMethod, "ENTRY {0}", new Object[]{param1});
        }
    }

    public void entering(String sourceClass, String sourceMethod, Object[] params) {
        if (Level.FINER.intValue() >= this.levelValue) {
            String msg = "ENTRY";
            if (params == null) {
                logp(Level.FINER, sourceClass, sourceMethod, msg);
                return;
            }
            for (int i = 0; i < params.length; i++) {
                msg = msg + " {" + i + "}";
            }
            logp(Level.FINER, sourceClass, sourceMethod, msg, params);
        }
    }

    public void exiting(String sourceClass, String sourceMethod) {
        if (Level.FINER.intValue() >= this.levelValue) {
            logp(Level.FINER, sourceClass, sourceMethod, "RETURN");
        }
    }

    public void exiting(String sourceClass, String sourceMethod, Object result) {
        if (Level.FINER.intValue() >= this.levelValue) {
            new Object[1][0] = result;
            logp(Level.FINER, sourceClass, sourceMethod, "RETURN {0}", result);
        }
    }

    public void throwing(String sourceClass, String sourceMethod, Throwable thrown) {
        if (Level.FINER.intValue() >= this.levelValue && this.levelValue != offValue) {
            LogRecord lr = new LogRecord(Level.FINER, "THROW");
            lr.setSourceClassName(sourceClass);
            lr.setSourceMethodName(sourceMethod);
            lr.setThrown(thrown);
            doLog(lr);
        }
    }

    public void severe(String msg) {
        if (Level.SEVERE.intValue() >= this.levelValue) {
            log(Level.SEVERE, msg);
        }
    }

    public void warning(String msg) {
        if (Level.WARNING.intValue() >= this.levelValue) {
            log(Level.WARNING, msg);
        }
    }

    public void info(String msg) {
        if (Level.INFO.intValue() >= this.levelValue) {
            log(Level.INFO, msg);
        }
    }

    public void config(String msg) {
        if (Level.CONFIG.intValue() >= this.levelValue) {
            log(Level.CONFIG, msg);
        }
    }

    public void fine(String msg) {
        if (Level.FINE.intValue() >= this.levelValue) {
            log(Level.FINE, msg);
        }
    }

    public void finer(String msg) {
        if (Level.FINER.intValue() >= this.levelValue) {
            log(Level.FINER, msg);
        }
    }

    public void finest(String msg) {
        if (Level.FINEST.intValue() >= this.levelValue) {
            log(Level.FINEST, msg);
        }
    }

    public void setLevel(Level newLevel) throws SecurityException {
        checkPermission();
        synchronized (treeLock) {
            this.levelObject = newLevel;
            updateEffectiveLevel();
        }
    }

    public Level getLevel() {
        return this.levelObject;
    }

    public boolean isLoggable(Level level) {
        if (level.intValue() < this.levelValue || this.levelValue == offValue) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

    public void addHandler(Handler handler) throws SecurityException {
        handler.getClass();
        checkPermission();
        this.handlers.add(handler);
    }

    public void removeHandler(Handler handler) throws SecurityException {
        checkPermission();
        if (handler != null) {
            this.handlers.remove(handler);
        }
    }

    public Handler[] getHandlers() {
        return (Handler[]) this.handlers.toArray(emptyHandlers);
    }

    public void setUseParentHandlers(boolean useParentHandlers2) {
        checkPermission();
        this.useParentHandlers = useParentHandlers2;
    }

    public boolean getUseParentHandlers() {
        return this.useParentHandlers;
    }

    private static ResourceBundle findSystemResourceBundle(final Locale locale) {
        return (ResourceBundle) AccessController.doPrivileged(new PrivilegedAction<ResourceBundle>() {
            public ResourceBundle run() {
                try {
                    return ResourceBundle.getBundle(Logger.SYSTEM_LOGGER_RB_NAME, locale, ClassLoader.getSystemClassLoader());
                } catch (MissingResourceException e) {
                    throw new InternalError(e.toString());
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0073 A[Catch:{ MissingResourceException -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.ResourceBundle findResourceBundle(java.lang.String r7, boolean r8) {
        /*
            r6 = this;
            r5 = 0
            monitor-enter(r6)
            if (r7 != 0) goto L_0x0006
            monitor-exit(r6)
            return r5
        L_0x0006:
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x007b }
            java.util.ResourceBundle r4 = r6.catalog     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x0022
            java.util.Locale r4 = r6.catalogLocale     // Catch:{ all -> 0x007b }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x0022
            java.lang.String r4 = r6.catalogName     // Catch:{ all -> 0x007b }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x0022
            java.util.ResourceBundle r4 = r6.catalog     // Catch:{ all -> 0x007b }
            monitor-exit(r6)
            return r4
        L_0x0022:
            java.lang.String r4 = "sun.util.logging.resources.logging"
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x0039
            java.util.ResourceBundle r4 = findSystemResourceBundle(r2)     // Catch:{ all -> 0x007b }
            r6.catalog = r4     // Catch:{ all -> 0x007b }
            r6.catalogName = r7     // Catch:{ all -> 0x007b }
            r6.catalogLocale = r2     // Catch:{ all -> 0x007b }
            java.util.ResourceBundle r4 = r6.catalog     // Catch:{ all -> 0x007b }
            monitor-exit(r6)
            return r4
        L_0x0039:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x007b }
            java.lang.ClassLoader r1 = r4.getContextClassLoader()     // Catch:{ all -> 0x007b }
            if (r1 != 0) goto L_0x0047
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x007b }
        L_0x0047:
            java.util.ResourceBundle r4 = java.util.ResourceBundle.getBundle((java.lang.String) r7, (java.util.Locale) r2, (java.lang.ClassLoader) r1)     // Catch:{ MissingResourceException -> 0x0055 }
            r6.catalog = r4     // Catch:{ MissingResourceException -> 0x0055 }
            r6.catalogName = r7     // Catch:{ MissingResourceException -> 0x0055 }
            r6.catalogLocale = r2     // Catch:{ MissingResourceException -> 0x0055 }
            java.util.ResourceBundle r4 = r6.catalog     // Catch:{ MissingResourceException -> 0x0055 }
            monitor-exit(r6)
            return r4
        L_0x0055:
            r3 = move-exception
            if (r8 == 0) goto L_0x006f
            java.lang.ClassLoader r0 = r6.getCallersClassLoader()     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x006f
            if (r0 == r1) goto L_0x006f
            java.util.ResourceBundle r4 = java.util.ResourceBundle.getBundle((java.lang.String) r7, (java.util.Locale) r2, (java.lang.ClassLoader) r0)     // Catch:{ MissingResourceException -> 0x006e }
            r6.catalog = r4     // Catch:{ MissingResourceException -> 0x006e }
            r6.catalogName = r7     // Catch:{ MissingResourceException -> 0x006e }
            r6.catalogLocale = r2     // Catch:{ MissingResourceException -> 0x006e }
            java.util.ResourceBundle r4 = r6.catalog     // Catch:{ MissingResourceException -> 0x006e }
            monitor-exit(r6)
            return r4
        L_0x006e:
            r3 = move-exception
        L_0x006f:
            boolean r4 = java.util.logging.Logger.LoggerHelper.allowStackWalkSearch     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x0079
            java.util.ResourceBundle r4 = r6.findResourceBundleFromStack(r7, r2, r1)     // Catch:{ all -> 0x007b }
            monitor-exit(r6)
            return r4
        L_0x0079:
            monitor-exit(r6)
            return r5
        L_0x007b:
            r4 = move-exception
            monitor-exit(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Logger.findResourceBundle(java.lang.String, boolean):java.util.ResourceBundle");
    }

    @CallerSensitive
    private synchronized ResourceBundle findResourceBundleFromStack(String name2, Locale locale, ClassLoader cl) {
        StackTraceElement[] stack = VMStack.getThreadStackTrace(Thread.currentThread());
        int ix = 0;
        while (true) {
            Class<?> clz = null;
            try {
                clz = Class.forName(stack[ix].getClassName());
            } catch (ClassNotFoundException e) {
            }
            if (clz == null) {
                return null;
            }
            ClassLoader cl2 = clz.getClassLoader();
            if (cl2 == null) {
                cl2 = ClassLoader.getSystemClassLoader();
            }
            if (cl != cl2) {
                cl = cl2;
                try {
                    this.catalog = ResourceBundle.getBundle(name2, locale, cl);
                    this.catalogName = name2;
                    this.catalogLocale = locale;
                    return this.catalog;
                } catch (MissingResourceException e2) {
                }
            }
            ix++;
        }
    }

    private synchronized void setupResourceInfo(String name2, Class<?> callersClass) {
        if (name2 != null) {
            setCallersClassLoaderRef(callersClass);
            if (findResourceBundle(name2, true) == null) {
                this.callersClassLoaderRef = null;
                throw new MissingResourceException("Can't find " + name2 + " bundle", name2, "");
            } else {
                this.resourceBundleName = name2;
            }
        }
    }

    public Logger getParent() {
        return this.parent;
    }

    public void setParent(Logger parent2) {
        if (parent2 == null) {
            throw new NullPointerException();
        }
        this.manager.checkPermission();
        doSetParent(parent2);
    }

    private void doSetParent(Logger newParent) {
        LogManager.LoggerWeakRef ref;
        LogManager.LoggerWeakRef ref2;
        synchronized (treeLock) {
            LogManager.LoggerWeakRef ref3 = null;
            try {
                if (this.parent != null) {
                    Iterator<LogManager.LoggerWeakRef> iter = this.parent.kids.iterator();
                    while (true) {
                        if (!iter.hasNext()) {
                            break;
                        }
                        LogManager.LoggerWeakRef ref4 = iter.next();
                        if (((Logger) ref4.get()) == this) {
                            iter.remove();
                            ref = ref4;
                            break;
                        }
                        ref3 = null;
                    }
                }
                ref = ref3;
                try {
                    this.parent = newParent;
                    if (this.parent.kids == null) {
                        this.parent.kids = new ArrayList<>(2);
                    }
                    if (ref == null) {
                        LogManager logManager = this.manager;
                        logManager.getClass();
                        ref2 = new LogManager.LoggerWeakRef(logManager, this);
                    } else {
                        ref2 = ref;
                    }
                    ref2.setParentRef(new WeakReference(this.parent));
                    this.parent.kids.add(ref2);
                    updateEffectiveLevel();
                } catch (Throwable th) {
                    th = th;
                    LogManager.LoggerWeakRef loggerWeakRef = ref;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void removeChildLogger(LogManager.LoggerWeakRef child) {
        synchronized (treeLock) {
            Iterator<LogManager.LoggerWeakRef> iter = this.kids.iterator();
            while (iter.hasNext()) {
                if (iter.next() == child) {
                    iter.remove();
                    return;
                }
            }
        }
    }

    private void updateEffectiveLevel() {
        int newLevelValue;
        if (this.levelObject != null) {
            newLevelValue = this.levelObject.intValue();
        } else if (this.parent != null) {
            newLevelValue = this.parent.levelValue;
        } else {
            newLevelValue = Level.INFO.intValue();
        }
        if (this.levelValue != newLevelValue) {
            this.levelValue = newLevelValue;
            if (this.kids != null) {
                for (int i = 0; i < this.kids.size(); i++) {
                    Logger kid = (Logger) this.kids.get(i).get();
                    if (kid != null) {
                        kid.updateEffectiveLevel();
                    }
                }
            }
        }
    }

    private String getEffectiveResourceBundleName() {
        for (Logger target = this; target != null; target = target.getParent()) {
            String rbn = target.getResourceBundleName();
            if (rbn != null) {
                return rbn;
            }
        }
        return null;
    }
}
