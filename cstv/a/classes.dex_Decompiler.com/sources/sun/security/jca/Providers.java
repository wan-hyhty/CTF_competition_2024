package sun.security.jca;

import java.security.Provider;

public class Providers {
    private static final String BACKUP_PROVIDER_CLASSNAME = "sun.security.provider.VerificationProvider";
    private static final String[] jarVerificationProviders = null;
    private static volatile ProviderList providerList;
    private static final ThreadLocal<ProviderList> threadLists = null;
    private static volatile int threadListsUsed;

    private Providers() {
    }

    public static Provider getSunProvider() {
        try {
            return (Provider) Class.forName(jarVerificationProviders[0]).newInstance();
        } catch (Exception e) {
            try {
                return (Provider) Class.forName(BACKUP_PROVIDER_CLASSNAME).newInstance();
            } catch (Exception e2) {
                throw new RuntimeException("Sun provider not found", e);
            }
        }
    }

    public static Object startJarVerification() {
        return beginThreadProviderList(getProviderList().getJarList(jarVerificationProviders));
    }

    public static void stopJarVerification(Object obj) {
        endThreadProviderList((ProviderList) obj);
    }

    public static ProviderList getProviderList() {
        ProviderList list = getThreadProviderList();
        if (list == null) {
            return getSystemProviderList();
        }
        return list;
    }

    public static void setProviderList(ProviderList newList) {
        if (getThreadProviderList() == null) {
            setSystemProviderList(newList);
        } else {
            changeThreadProviderList(newList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r0 = getSystemProviderList();
        r1 = r0.removeInvalid();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r1 == r0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        setSystemProviderList(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static sun.security.jca.ProviderList getFullProviderList() {
        /*
            java.lang.Class<sun.security.jca.Providers> r3 = sun.security.jca.Providers.class
            monitor-enter(r3)
            sun.security.jca.ProviderList r0 = getThreadProviderList()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0015
            sun.security.jca.ProviderList r1 = r0.removeInvalid()     // Catch:{ all -> 0x0025 }
            if (r1 == r0) goto L_0x0013
            changeThreadProviderList(r1)     // Catch:{ all -> 0x0025 }
            r0 = r1
        L_0x0013:
            monitor-exit(r3)
            return r0
        L_0x0015:
            monitor-exit(r3)
            sun.security.jca.ProviderList r0 = getSystemProviderList()
            sun.security.jca.ProviderList r1 = r0.removeInvalid()
            if (r1 == r0) goto L_0x0024
            setSystemProviderList(r1)
            r0 = r1
        L_0x0024:
            return r0
        L_0x0025:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.jca.Providers.getFullProviderList():sun.security.jca.ProviderList");
    }

    private static ProviderList getSystemProviderList() {
        return providerList;
    }

    private static void setSystemProviderList(ProviderList list) {
        providerList = list;
    }

    public static ProviderList getThreadProviderList() {
        if (threadListsUsed == 0) {
            return null;
        }
        return threadLists.get();
    }

    private static void changeThreadProviderList(ProviderList list) {
        threadLists.set(list);
    }

    public static synchronized ProviderList beginThreadProviderList(ProviderList list) {
        ProviderList oldList;
        synchronized (Providers.class) {
            if (ProviderList.debug != null) {
                ProviderList.debug.println("ThreadLocal providers: " + list);
            }
            oldList = threadLists.get();
            threadListsUsed++;
            threadLists.set(list);
        }
        return oldList;
    }

    public static synchronized void endThreadProviderList(ProviderList list) {
        synchronized (Providers.class) {
            if (list == null) {
                if (ProviderList.debug != null) {
                    ProviderList.debug.println("Disabling ThreadLocal providers");
                }
                threadLists.remove();
            } else {
                if (ProviderList.debug != null) {
                    ProviderList.debug.println("Restoring previous ThreadLocal providers: " + list);
                }
                threadLists.set(list);
            }
            threadListsUsed--;
        }
    }
}
