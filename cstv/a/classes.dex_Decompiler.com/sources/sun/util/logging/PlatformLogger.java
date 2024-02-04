package sun.util.logging;

import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class PlatformLogger {
    public static final int ALL = Integer.MIN_VALUE;
    public static final int CONFIG = 700;
    /* access modifiers changed from: private */
    public static final Level DEFAULT_LEVEL = null;
    public static final int FINE = 500;
    public static final int FINER = 400;
    public static final int FINEST = 300;
    public static final int INFO = 800;
    public static final int OFF = Integer.MAX_VALUE;
    public static final int SEVERE = 1000;
    public static final int WARNING = 900;
    private static Map<String, WeakReference<PlatformLogger>> loggers;
    private static boolean loggingEnabled;
    private volatile JavaLoggerProxy javaLoggerProxy;
    private volatile LoggerProxy loggerProxy;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum Level {
        ;
        
        private static final int[] levelValues = null;
        Object javaLevel;

        public int intValue() {
            return levelValues[ordinal()];
        }

        static Level valueOf(int level) {
            switch (level) {
                case Integer.MIN_VALUE:
                    return ALL;
                case 300:
                    return FINEST;
                case 400:
                    return FINER;
                case 500:
                    return FINE;
                case PlatformLogger.CONFIG /*700*/:
                    return CONFIG;
                case PlatformLogger.INFO /*800*/:
                    return INFO;
                case PlatformLogger.WARNING /*900*/:
                    return WARNING;
                case 1000:
                    return SEVERE;
                case Integer.MAX_VALUE:
                    return OFF;
                default:
                    int i = Arrays.binarySearch(levelValues, 0, levelValues.length - 2, level);
                    Level[] values = values();
                    if (i < 0) {
                        i = (-i) - 1;
                    }
                    return values[i];
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: sun.util.logging.PlatformLogger} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        return r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized sun.util.logging.PlatformLogger getLogger(java.lang.String r7) {
        /*
            java.lang.Class<sun.util.logging.PlatformLogger> r5 = sun.util.logging.PlatformLogger.class
            monitor-enter(r5)
            r1 = 0
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<sun.util.logging.PlatformLogger>> r4 = loggers     // Catch:{ all -> 0x002a }
            java.lang.Object r3 = r4.get(r7)     // Catch:{ all -> 0x002a }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x0032
            java.lang.Object r4 = r3.get()     // Catch:{ all -> 0x002a }
            r0 = r4
            sun.util.logging.PlatformLogger r0 = (sun.util.logging.PlatformLogger) r0     // Catch:{ all -> 0x002a }
            r1 = r0
            r2 = r1
        L_0x0017:
            if (r2 != 0) goto L_0x0030
            sun.util.logging.PlatformLogger r1 = new sun.util.logging.PlatformLogger     // Catch:{ all -> 0x002d }
            r1.<init>(r7)     // Catch:{ all -> 0x002d }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<sun.util.logging.PlatformLogger>> r4 = loggers     // Catch:{ all -> 0x002a }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x002a }
            r6.<init>(r1)     // Catch:{ all -> 0x002a }
            r4.put(r7, r6)     // Catch:{ all -> 0x002a }
        L_0x0028:
            monitor-exit(r5)
            return r1
        L_0x002a:
            r4 = move-exception
        L_0x002b:
            monitor-exit(r5)
            throw r4
        L_0x002d:
            r4 = move-exception
            r1 = r2
            goto L_0x002b
        L_0x0030:
            r1 = r2
            goto L_0x0028
        L_0x0032:
            r2 = r1
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.getLogger(java.lang.String):sun.util.logging.PlatformLogger");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void redirectPlatformLoggers() {
        /*
            java.lang.Class<sun.util.logging.PlatformLogger> r5 = sun.util.logging.PlatformLogger.class
            monitor-enter(r5)
            boolean r4 = loggingEnabled     // Catch:{ all -> 0x0038 }
            if (r4 != 0) goto L_0x003b
            boolean r4 = sun.util.logging.LoggingSupport.isAvailable()     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x003b
            r4 = 1
            loggingEnabled = r4     // Catch:{ all -> 0x0038 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<sun.util.logging.PlatformLogger>> r4 = loggers     // Catch:{ all -> 0x0038 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x0038 }
            java.util.Iterator r1 = r4.iterator()     // Catch:{ all -> 0x0038 }
        L_0x001a:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x003d
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x0038 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0038 }
            java.lang.Object r3 = r0.getValue()     // Catch:{ all -> 0x0038 }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ all -> 0x0038 }
            java.lang.Object r2 = r3.get()     // Catch:{ all -> 0x0038 }
            sun.util.logging.PlatformLogger r2 = (sun.util.logging.PlatformLogger) r2     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x001a
            r2.redirectToJavaLoggerProxy()     // Catch:{ all -> 0x0038 }
            goto L_0x001a
        L_0x0038:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        L_0x003b:
            monitor-exit(r5)
            return
        L_0x003d:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.redirectPlatformLoggers():void");
    }

    private void redirectToJavaLoggerProxy() {
        DefaultLoggerProxy lp = DefaultLoggerProxy.class.cast(this.loggerProxy);
        JavaLoggerProxy jlp = new JavaLoggerProxy(lp.name, lp.level);
        this.javaLoggerProxy = jlp;
        this.loggerProxy = jlp;
    }

    private PlatformLogger(String name) {
        if (loggingEnabled) {
            JavaLoggerProxy javaLoggerProxy2 = new JavaLoggerProxy(name);
            this.javaLoggerProxy = javaLoggerProxy2;
            this.loggerProxy = javaLoggerProxy2;
            return;
        }
        this.loggerProxy = new DefaultLoggerProxy(name);
    }

    public boolean isEnabled() {
        return this.loggerProxy.isEnabled();
    }

    public String getName() {
        return this.loggerProxy.name;
    }

    @Deprecated
    public boolean isLoggable(int levelValue) {
        return isLoggable(Level.valueOf(levelValue));
    }

    @Deprecated
    public int getLevel() {
        Level level = this.loggerProxy.getLevel();
        if (level != null) {
            return level.intValue();
        }
        return 0;
    }

    @Deprecated
    public void setLevel(int newLevel) {
        this.loggerProxy.setLevel(newLevel == 0 ? null : Level.valueOf(newLevel));
    }

    public boolean isLoggable(Level level) {
        if (level == null) {
            throw new NullPointerException();
        }
        JavaLoggerProxy jlp = this.javaLoggerProxy;
        return jlp != null ? jlp.isLoggable(level) : this.loggerProxy.isLoggable(level);
    }

    public Level level() {
        return this.loggerProxy.getLevel();
    }

    public void setLevel(Level newLevel) {
        this.loggerProxy.setLevel(newLevel);
    }

    public void severe(String msg) {
        this.loggerProxy.doLog(Level.SEVERE, msg);
    }

    public void severe(String msg, Throwable t) {
        this.loggerProxy.doLog(Level.SEVERE, msg, t);
    }

    public void severe(String msg, Object... params) {
        this.loggerProxy.doLog(Level.SEVERE, msg, params);
    }

    public void warning(String msg) {
        this.loggerProxy.doLog(Level.WARNING, msg);
    }

    public void warning(String msg, Throwable t) {
        this.loggerProxy.doLog(Level.WARNING, msg, t);
    }

    public void warning(String msg, Object... params) {
        this.loggerProxy.doLog(Level.WARNING, msg, params);
    }

    public void info(String msg) {
        this.loggerProxy.doLog(Level.INFO, msg);
    }

    public void info(String msg, Throwable t) {
        this.loggerProxy.doLog(Level.INFO, msg, t);
    }

    public void info(String msg, Object... params) {
        this.loggerProxy.doLog(Level.INFO, msg, params);
    }

    public void config(String msg) {
        this.loggerProxy.doLog(Level.CONFIG, msg);
    }

    public void config(String msg, Throwable t) {
        this.loggerProxy.doLog(Level.CONFIG, msg, t);
    }

    public void config(String msg, Object... params) {
        this.loggerProxy.doLog(Level.CONFIG, msg, params);
    }

    public void fine(String msg) {
        this.loggerProxy.doLog(Level.FINE, msg);
    }

    public void fine(String msg, Throwable t) {
        this.loggerProxy.doLog(Level.FINE, msg, t);
    }

    public void fine(String msg, Object... params) {
        this.loggerProxy.doLog(Level.FINE, msg, params);
    }

    public void finer(String msg) {
        this.loggerProxy.doLog(Level.FINER, msg);
    }

    public void finer(String msg, Throwable t) {
        this.loggerProxy.doLog(Level.FINER, msg, t);
    }

    public void finer(String msg, Object... params) {
        this.loggerProxy.doLog(Level.FINER, msg, params);
    }

    public void finest(String msg) {
        this.loggerProxy.doLog(Level.FINEST, msg);
    }

    public void finest(String msg, Throwable t) {
        this.loggerProxy.doLog(Level.FINEST, msg, t);
    }

    public void finest(String msg, Object... params) {
        this.loggerProxy.doLog(Level.FINEST, msg, params);
    }

    private static abstract class LoggerProxy {
        final String name;

        /* access modifiers changed from: package-private */
        public abstract void doLog(Level level, String str);

        /* access modifiers changed from: package-private */
        public abstract void doLog(Level level, String str, Throwable th);

        /* access modifiers changed from: package-private */
        public abstract void doLog(Level level, String str, Object... objArr);

        /* access modifiers changed from: package-private */
        public abstract Level getLevel();

        /* access modifiers changed from: package-private */
        public abstract boolean isEnabled();

        /* access modifiers changed from: package-private */
        public abstract boolean isLoggable(Level level);

        /* access modifiers changed from: package-private */
        public abstract void setLevel(Level level);

        protected LoggerProxy(String name2) {
            this.name = name2;
        }
    }

    private static final class DefaultLoggerProxy extends LoggerProxy {
        private static final String formatString = null;
        private Date date;
        volatile Level effectiveLevel;
        volatile Level level;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.<init>(java.lang.String):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        DefaultLoggerProxy(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.<init>(java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.<init>(java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.format(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Throwable):java.lang.String, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private synchronized java.lang.String format(sun.util.logging.PlatformLogger.Level r1, java.lang.String r2, java.lang.Throwable r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.format(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Throwable):java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.format(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Throwable):java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.formatMessage(java.lang.String, java.lang.Object[]):java.lang.String, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private java.lang.String formatMessage(java.lang.String r1, java.lang.Object... r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.formatMessage(java.lang.String, java.lang.Object[]):java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.formatMessage(java.lang.String, java.lang.Object[]):java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.getCallerInfo():java.lang.String, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private java.lang.String getCallerInfo() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.getCallerInfo():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.getCallerInfo():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        void doLog(sun.util.logging.PlatformLogger.Level r1, java.lang.String r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Throwable):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        void doLog(sun.util.logging.PlatformLogger.Level r1, java.lang.String r2, java.lang.Throwable r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Throwable):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Throwable):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Object[]):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        void doLog(sun.util.logging.PlatformLogger.Level r1, java.lang.String r2, java.lang.Object... r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Object[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.doLog(sun.util.logging.PlatformLogger$Level, java.lang.String, java.lang.Object[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.isLoggable(sun.util.logging.PlatformLogger$Level):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        boolean isLoggable(sun.util.logging.PlatformLogger.Level r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.isLoggable(sun.util.logging.PlatformLogger$Level):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.isLoggable(sun.util.logging.PlatformLogger$Level):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.setLevel(sun.util.logging.PlatformLogger$Level):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        void setLevel(sun.util.logging.PlatformLogger.Level r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.logging.PlatformLogger.DefaultLoggerProxy.setLevel(sun.util.logging.PlatformLogger$Level):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.logging.PlatformLogger.DefaultLoggerProxy.setLevel(sun.util.logging.PlatformLogger$Level):void");
        }

        private static PrintStream outputStream() {
            return System.err;
        }

        /* access modifiers changed from: package-private */
        public boolean isEnabled() {
            return this.effectiveLevel != Level.OFF;
        }

        /* access modifiers changed from: package-private */
        public Level getLevel() {
            return this.level;
        }

        private Level deriveEffectiveLevel(Level level2) {
            return level2 == null ? PlatformLogger.DEFAULT_LEVEL : level2;
        }
    }

    private static final class JavaLoggerProxy extends LoggerProxy {
        private final Object javaLogger;

        JavaLoggerProxy(String name) {
            this(name, (Level) null);
        }

        JavaLoggerProxy(String name, Level level) {
            super(name);
            this.javaLogger = LoggingSupport.getLogger(name);
            if (level != null) {
                LoggingSupport.setLevel(this.javaLogger, level.javaLevel);
            }
        }

        /* access modifiers changed from: package-private */
        public void doLog(Level level, String msg) {
            LoggingSupport.log(this.javaLogger, level.javaLevel, msg);
        }

        /* access modifiers changed from: package-private */
        public void doLog(Level level, String msg, Throwable t) {
            LoggingSupport.log(this.javaLogger, level.javaLevel, msg, t);
        }

        /* access modifiers changed from: package-private */
        public void doLog(Level level, String msg, Object... params) {
            if (isLoggable(level)) {
                int len = params != null ? params.length : 0;
                Object[] sparams = new String[len];
                for (int i = 0; i < len; i++) {
                    sparams[i] = String.valueOf(params[i]);
                }
                LoggingSupport.log(this.javaLogger, level.javaLevel, msg, sparams);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isEnabled() {
            return LoggingSupport.isLoggable(this.javaLogger, Level.OFF.javaLevel);
        }

        /* access modifiers changed from: package-private */
        public Level getLevel() {
            Object javaLevel = LoggingSupport.getLevel(this.javaLogger);
            if (javaLevel == null) {
                return null;
            }
            try {
                return Level.valueOf(LoggingSupport.getLevelName(javaLevel));
            } catch (IllegalArgumentException e) {
                return Level.valueOf(LoggingSupport.getLevelValue(javaLevel));
            }
        }

        /* access modifiers changed from: package-private */
        public void setLevel(Level level) {
            Object obj = null;
            Object obj2 = this.javaLogger;
            if (level != null) {
                obj = level.javaLevel;
            }
            LoggingSupport.setLevel(obj2, obj);
        }

        /* access modifiers changed from: package-private */
        public boolean isLoggable(Level level) {
            return LoggingSupport.isLoggable(this.javaLogger, level.javaLevel);
        }
    }
}
