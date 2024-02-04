package java.util.logging;

import dalvik.system.VMStack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Level implements Serializable {
    public static final Level ALL = null;
    public static final Level CONFIG = null;
    public static final Level FINE = null;
    public static final Level FINER = null;
    public static final Level FINEST = null;
    public static final Level INFO = null;
    public static final Level OFF = null;
    public static final Level SEVERE = null;
    public static final Level WARNING = null;
    private static String defaultBundle = null;
    private static final long serialVersionUID = -8176160795706313070L;
    private String localizedLevelName;
    /* access modifiers changed from: private */
    public final String name;
    private transient ResourceBundle rb;
    /* access modifiers changed from: private */
    public final String resourceBundleName;
    /* access modifiers changed from: private */
    public final int value;

    protected Level(String name2, int value2) {
        this(name2, value2, (String) null);
    }

    protected Level(String name2, int value2, String resourceBundleName2) {
        if (name2 == null) {
            throw new NullPointerException();
        }
        this.name = name2;
        this.value = value2;
        this.resourceBundleName = resourceBundleName2;
        if (resourceBundleName2 != null) {
            try {
                ClassLoader cl = VMStack.getCallingClassLoader();
                if (cl != null) {
                    this.rb = ResourceBundle.getBundle(resourceBundleName2, Locale.getDefault(), cl);
                } else {
                    this.rb = ResourceBundle.getBundle(resourceBundleName2);
                }
            } catch (MissingResourceException e) {
                this.rb = null;
            }
        }
        this.localizedLevelName = resourceBundleName2 != null ? null : name2;
        KnownLevel.add(this);
    }

    public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    public String getName() {
        return this.name;
    }

    public String getLocalizedName() {
        return getLocalizedLevelName();
    }

    /* access modifiers changed from: package-private */
    public final String getLevelName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public final synchronized String getLocalizedLevelName() {
        if (this.localizedLevelName != null) {
            return this.localizedLevelName;
        }
        try {
            this.localizedLevelName = this.rb.getString(this.name);
        } catch (Exception e) {
            this.localizedLevelName = this.name;
        }
        return this.localizedLevelName;
    }

    static Level findLevel(String name2) {
        if (name2 == null) {
            throw new NullPointerException();
        }
        KnownLevel level = KnownLevel.findByName(name2);
        if (level != null) {
            return level.mirroredLevel;
        }
        try {
            int x = Integer.parseInt(name2);
            KnownLevel level2 = KnownLevel.findByValue(x);
            if (level2 == null) {
                new Level(name2, x);
                level2 = KnownLevel.findByValue(x);
            }
            return level2.mirroredLevel;
        } catch (NumberFormatException e) {
            KnownLevel level3 = KnownLevel.findByLocalizedLevelName(name2);
            if (level3 != null) {
                return level3.mirroredLevel;
            }
            return null;
        }
    }

    public final String toString() {
        return this.name;
    }

    public final int intValue() {
        return this.value;
    }

    private Object readResolve() {
        KnownLevel o = KnownLevel.matches(this);
        if (o != null) {
            return o.levelObject;
        }
        return new Level(this.name, this.value, this.resourceBundleName);
    }

    public static synchronized Level parse(String name2) throws IllegalArgumentException {
        synchronized (Level.class) {
            name2.length();
            KnownLevel level = KnownLevel.findByName(name2);
            if (level != null) {
                Level level2 = level.levelObject;
                return level2;
            }
            try {
                int x = Integer.parseInt(name2);
                KnownLevel level3 = KnownLevel.findByValue(x);
                if (level3 == null) {
                    new Level(name2, x);
                    level3 = KnownLevel.findByValue(x);
                }
                Level level4 = level3.levelObject;
                return level4;
            } catch (NumberFormatException e) {
                KnownLevel level5 = KnownLevel.findByLocalizedName(name2);
                if (level5 != null) {
                    return level5.levelObject;
                }
                throw new IllegalArgumentException("Bad level \"" + name2 + "\"");
            }
        }
    }

    public boolean equals(Object ox) {
        try {
            if (((Level) ox).value == this.value) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public int hashCode() {
        return this.value;
    }

    static final class KnownLevel {
        private static Map<Integer, List<KnownLevel>> intToLevels;
        private static Map<String, List<KnownLevel>> nameToLevels;
        final Level levelObject;
        final Level mirroredLevel;

        KnownLevel(Level l) {
            this.levelObject = l;
            if (l.getClass() == Level.class) {
                this.mirroredLevel = l;
            } else {
                this.mirroredLevel = new Level(l.name, l.value, l.resourceBundleName);
            }
        }

        static synchronized void add(Level l) {
            synchronized (KnownLevel.class) {
                KnownLevel o = new KnownLevel(l);
                List<KnownLevel> list = nameToLevels.get(l.name);
                if (list == null) {
                    list = new ArrayList<>();
                    nameToLevels.put(l.name, list);
                }
                list.add(o);
                List<KnownLevel> list2 = intToLevels.get(Integer.valueOf(l.value));
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    intToLevels.put(Integer.valueOf(l.value), list2);
                }
                list2.add(o);
            }
        }

        static synchronized KnownLevel findByName(String name) {
            synchronized (KnownLevel.class) {
                List<KnownLevel> list = nameToLevels.get(name);
                if (list == null) {
                    return null;
                }
                KnownLevel knownLevel = list.get(0);
                return knownLevel;
            }
        }

        static synchronized KnownLevel findByValue(int value) {
            synchronized (KnownLevel.class) {
                List<KnownLevel> list = intToLevels.get(Integer.valueOf(value));
                if (list == null) {
                    return null;
                }
                KnownLevel knownLevel = list.get(0);
                return knownLevel;
            }
        }

        static synchronized KnownLevel findByLocalizedLevelName(String name) {
            synchronized (KnownLevel.class) {
                for (List<KnownLevel> levels : nameToLevels.values()) {
                    Iterator l$iterator = levels.iterator();
                    while (true) {
                        if (l$iterator.hasNext()) {
                            KnownLevel l = (KnownLevel) l$iterator.next();
                            if (name.equals(l.levelObject.getLocalizedLevelName())) {
                                return l;
                            }
                        }
                    }
                }
                return null;
            }
        }

        static synchronized KnownLevel findByLocalizedName(String name) {
            synchronized (KnownLevel.class) {
                for (List<KnownLevel> levels : nameToLevels.values()) {
                    Iterator l$iterator = levels.iterator();
                    while (true) {
                        if (l$iterator.hasNext()) {
                            KnownLevel l = (KnownLevel) l$iterator.next();
                            if (name.equals(l.levelObject.getLocalizedName())) {
                                return l;
                            }
                        }
                    }
                }
                return null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static synchronized java.util.logging.Level.KnownLevel matches(java.util.logging.Level r8) {
            /*
                r7 = 0
                java.lang.Class<java.util.logging.Level$KnownLevel> r5 = java.util.logging.Level.KnownLevel.class
                monitor-enter(r5)
                java.util.Map<java.lang.String, java.util.List<java.util.logging.Level$KnownLevel>> r4 = nameToLevels     // Catch:{ all -> 0x0050 }
                java.lang.String r6 = r8.name     // Catch:{ all -> 0x0050 }
                java.lang.Object r2 = r4.get(r6)     // Catch:{ all -> 0x0050 }
                java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0050 }
                if (r2 == 0) goto L_0x004e
                java.util.Iterator r1 = r2.iterator()     // Catch:{ all -> 0x0050 }
            L_0x0016:
                boolean r4 = r1.hasNext()     // Catch:{ all -> 0x0050 }
                if (r4 == 0) goto L_0x004e
                java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x0050 }
                java.util.logging.Level$KnownLevel r0 = (java.util.logging.Level.KnownLevel) r0     // Catch:{ all -> 0x0050 }
                java.util.logging.Level r3 = r0.mirroredLevel     // Catch:{ all -> 0x0050 }
                int r4 = r8.value     // Catch:{ all -> 0x0050 }
                int r6 = r3.value     // Catch:{ all -> 0x0050 }
                if (r4 != r6) goto L_0x0016
                java.lang.String r4 = r8.resourceBundleName     // Catch:{ all -> 0x0050 }
                java.lang.String r6 = r3.resourceBundleName     // Catch:{ all -> 0x0050 }
                if (r4 == r6) goto L_0x004c
                java.lang.String r4 = r8.resourceBundleName     // Catch:{ all -> 0x0050 }
                if (r4 == 0) goto L_0x0016
                java.lang.String r4 = r8.resourceBundleName     // Catch:{ all -> 0x0050 }
                java.lang.String r6 = r3.resourceBundleName     // Catch:{ all -> 0x0050 }
                boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0050 }
                if (r4 == 0) goto L_0x0016
            L_0x004c:
                monitor-exit(r5)
                return r0
            L_0x004e:
                monitor-exit(r5)
                return r7
            L_0x0050:
                r4 = move-exception
                monitor-exit(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.logging.Level.KnownLevel.matches(java.util.logging.Level):java.util.logging.Level$KnownLevel");
        }
    }
}
