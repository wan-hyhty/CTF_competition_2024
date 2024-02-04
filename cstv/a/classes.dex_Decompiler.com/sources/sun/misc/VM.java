package sun.misc;

import java.lang.Thread;
import java.util.Properties;

public class VM {
    private static final int JVMTI_THREAD_STATE_ALIVE = 1;
    private static final int JVMTI_THREAD_STATE_BLOCKED_ON_MONITOR_ENTER = 1024;
    private static final int JVMTI_THREAD_STATE_RUNNABLE = 4;
    private static final int JVMTI_THREAD_STATE_TERMINATED = 2;
    private static final int JVMTI_THREAD_STATE_WAITING_INDEFINITELY = 16;
    private static final int JVMTI_THREAD_STATE_WAITING_WITH_TIMEOUT = 32;
    @Deprecated
    public static final int STATE_GREEN = 1;
    @Deprecated
    public static final int STATE_RED = 3;
    @Deprecated
    public static final int STATE_YELLOW = 2;
    private static boolean allowArraySyntax;
    private static boolean allowGetCallerClass;
    private static volatile boolean booted;
    private static boolean defaultAllowArraySyntax;
    private static long directMemory;
    private static volatile int finalRefCount;
    private static boolean pageAlignDirectMemory;
    private static volatile int peakFinalRefCount;
    private static final Properties savedProps = null;
    private static boolean suspended;

    @Deprecated
    public static boolean threadsSuspended() {
        return suspended;
    }

    public static boolean allowThreadSuspension(ThreadGroup g, boolean b) {
        return g.allowThreadSuspension(b);
    }

    @Deprecated
    public static boolean suspendThreads() {
        suspended = true;
        return true;
    }

    @Deprecated
    public static void unsuspendThreads() {
        suspended = false;
    }

    @Deprecated
    public static void unsuspendSomeThreads() {
    }

    @Deprecated
    public static final int getState() {
        return 1;
    }

    @Deprecated
    public static void asChange(int as_old, int as_new) {
    }

    @Deprecated
    public static void asChange_otherthread(int as_old, int as_new) {
    }

    public static void booted() {
        booted = true;
    }

    public static boolean isBooted() {
        return booted;
    }

    public static long maxDirectMemory() {
        return directMemory;
    }

    public static boolean isDirectMemoryPageAligned() {
        return pageAlignDirectMemory;
    }

    public static boolean allowArraySyntax() {
        return allowArraySyntax;
    }

    public static boolean allowGetCallerClass() {
        return allowGetCallerClass;
    }

    public static String getSavedProperty(String key) {
        return savedProps.getProperty(key);
    }

    public static void saveAndRemoveProperties(Properties props) {
        boolean parseBoolean;
        boolean z;
        if (booted) {
            throw new IllegalStateException("System initialization has completed");
        }
        savedProps.putAll(props);
        String s = (String) props.remove("sun.nio.MaxDirectMemorySize");
        if (s != null) {
            if (s.equals("-1")) {
                directMemory = Runtime.getRuntime().maxMemory();
            } else {
                long l = Long.parseLong(s);
                if (l > -1) {
                    directMemory = l;
                }
            }
        }
        if ("true".equals((String) props.remove("sun.nio.PageAlignDirectMemory"))) {
            pageAlignDirectMemory = true;
        }
        String s2 = props.getProperty("sun.lang.ClassLoader.allowArraySyntax");
        if (s2 == null) {
            parseBoolean = defaultAllowArraySyntax;
        } else {
            parseBoolean = Boolean.parseBoolean(s2);
        }
        allowArraySyntax = parseBoolean;
        String s3 = props.getProperty("jdk.reflect.allowGetCallerClass");
        if (s3 == null || s3.isEmpty() || Boolean.parseBoolean(s3)) {
            z = true;
        } else {
            z = Boolean.valueOf(props.getProperty("jdk.logging.allowStackWalkSearch")).booleanValue();
        }
        allowGetCallerClass = z;
        props.remove("java.lang.Integer.IntegerCache.high");
        props.remove("sun.zip.disableMemoryMapping");
        props.remove("sun.java.launcher.diag");
    }

    public static void initializeOSEnvironment() {
    }

    public static int getFinalRefCount() {
        return finalRefCount;
    }

    public static int getPeakFinalRefCount() {
        return peakFinalRefCount;
    }

    public static void addFinalRefCount(int n) {
        finalRefCount += n;
        if (finalRefCount > peakFinalRefCount) {
            peakFinalRefCount = finalRefCount;
        }
    }

    public static Thread.State toThreadState(int threadStatus) {
        if ((threadStatus & 4) != 0) {
            return Thread.State.RUNNABLE;
        }
        if ((threadStatus & 1024) != 0) {
            return Thread.State.BLOCKED;
        }
        if ((threadStatus & 16) != 0) {
            return Thread.State.WAITING;
        }
        if ((threadStatus & 32) != 0) {
            return Thread.State.TIMED_WAITING;
        }
        if ((threadStatus & 2) != 0) {
            return Thread.State.TERMINATED;
        }
        if ((threadStatus & 1) == 0) {
            return Thread.State.NEW;
        }
        return Thread.State.RUNNABLE;
    }
}
