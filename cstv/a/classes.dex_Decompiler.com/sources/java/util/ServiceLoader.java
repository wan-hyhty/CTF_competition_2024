package java.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public final class ServiceLoader<S> implements Iterable<S> {
    private static final String PREFIX = "META-INF/services/";
    private ClassLoader loader;
    /* access modifiers changed from: private */
    public ServiceLoader<S>.LazyIterator lookupIterator;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, S> providers = new LinkedHashMap<>();
    private Class<S> service;

    public void reload() {
        this.providers.clear();
        this.lookupIterator = new LazyIterator(this, this.service, this.loader, (LazyIterator) null);
    }

    private ServiceLoader(Class<S> svc, ClassLoader cl) {
        this.service = svc;
        this.loader = cl;
        reload();
    }

    /* access modifiers changed from: private */
    public static void fail(Class service2, String msg, Throwable cause) throws ServiceConfigurationError {
        throw new ServiceConfigurationError(service2.getName() + ": " + msg, cause);
    }

    private static void fail(Class service2, String msg) throws ServiceConfigurationError {
        throw new ServiceConfigurationError(service2.getName() + ": " + msg);
    }

    private static void fail(Class service2, URL u, int line, String msg) throws ServiceConfigurationError {
        fail(service2, u + ":" + line + ": " + msg);
    }

    private int parseLine(Class service2, URL u, BufferedReader r, int lc, List<String> names) throws IOException, ServiceConfigurationError {
        String ln = r.readLine();
        if (ln == null) {
            return -1;
        }
        int ci = ln.indexOf(35);
        if (ci >= 0) {
            ln = ln.substring(0, ci);
        }
        String ln2 = ln.trim();
        int n = ln2.length();
        if (n != 0) {
            if (ln2.indexOf(32) >= 0 || ln2.indexOf(9) >= 0) {
                fail(service2, u, lc, "Illegal configuration-file syntax");
            }
            int cp = ln2.codePointAt(0);
            if (!Character.isJavaIdentifierStart(cp)) {
                fail(service2, u, lc, "Illegal provider-class name: " + ln2);
            }
            int i = Character.charCount(cp);
            while (i < n) {
                int cp2 = ln2.codePointAt(i);
                if (!Character.isJavaIdentifierPart(cp2) && cp2 != 46) {
                    fail(service2, u, lc, "Illegal provider-class name: " + ln2);
                }
                i += Character.charCount(cp2);
            }
            if (!this.providers.containsKey(ln2) && !names.contains(ln2)) {
                names.add(ln2);
            }
        }
        return lc + 1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058 A[SYNTHETIC, Splitter:B:32:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005d A[Catch:{ IOException -> 0x0061 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Iterator<java.lang.String> parse(java.lang.Class r11, java.net.URL r12) throws java.util.ServiceConfigurationError {
        /*
            r10 = this;
            r6 = 0
            r7 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.io.InputStream r6 = r12.openStream()     // Catch:{ IOException -> 0x0039, all -> 0x0054 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0039, all -> 0x0054 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039, all -> 0x0054 }
            java.lang.String r1 = "utf-8"
            r0.<init>((java.io.InputStream) r6, (java.lang.String) r1)     // Catch:{ IOException -> 0x0039, all -> 0x0054 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0039, all -> 0x0054 }
            r4 = 1
        L_0x0019:
            r0 = r10
            r1 = r11
            r2 = r12
            int r4 = r0.parseLine(r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x006b }
            if (r4 >= 0) goto L_0x0019
            if (r3 == 0) goto L_0x0027
            r3.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0027:
            if (r6 == 0) goto L_0x002c
            r6.close()     // Catch:{ IOException -> 0x0031 }
        L_0x002c:
            java.util.Iterator r0 = r5.iterator()
            return r0
        L_0x0031:
            r9 = move-exception
            java.lang.String r0 = "Error closing configuration file"
            fail(r11, r0, r9)
            goto L_0x002c
        L_0x0039:
            r8 = move-exception
            r3 = r7
        L_0x003b:
            java.lang.String r0 = "Error reading configuration file"
            fail(r11, r0, r8)     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x0046
            r3.close()     // Catch:{ IOException -> 0x004c }
        L_0x0046:
            if (r6 == 0) goto L_0x002c
            r6.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x002c
        L_0x004c:
            r9 = move-exception
            java.lang.String r0 = "Error closing configuration file"
            fail(r11, r0, r9)
            goto L_0x002c
        L_0x0054:
            r0 = move-exception
            r3 = r7
        L_0x0056:
            if (r3 == 0) goto L_0x005b
            r3.close()     // Catch:{ IOException -> 0x0061 }
        L_0x005b:
            if (r6 == 0) goto L_0x0060
            r6.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0060:
            throw r0
        L_0x0061:
            r9 = move-exception
            java.lang.String r1 = "Error closing configuration file"
            fail(r11, r1, r9)
            goto L_0x0060
        L_0x0069:
            r0 = move-exception
            goto L_0x0056
        L_0x006b:
            r8 = move-exception
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ServiceLoader.parse(java.lang.Class, java.net.URL):java.util.Iterator");
    }

    private class LazyIterator implements Iterator<S> {
        Enumeration<URL> configs;
        ClassLoader loader;
        String nextName;
        Iterator<String> pending;
        Class<S> service;

        /* synthetic */ LazyIterator(ServiceLoader this$02, Class service2, ClassLoader loader2, LazyIterator lazyIterator) {
            this(service2, loader2);
        }

        private LazyIterator(Class<S> service2, ClassLoader loader2) {
            this.configs = null;
            this.pending = null;
            this.nextName = null;
            this.service = service2;
            this.loader = loader2;
        }

        public boolean hasNext() {
            if (this.nextName != null) {
                return true;
            }
            if (this.configs == null) {
                try {
                    String fullName = ServiceLoader.PREFIX + this.service.getName();
                    if (this.loader == null) {
                        this.configs = ClassLoader.getSystemResources(fullName);
                    } else {
                        this.configs = this.loader.getResources(fullName);
                    }
                } catch (IOException x) {
                    ServiceLoader.fail(this.service, "Error locating configuration files", x);
                }
            }
            while (true) {
                if (this.pending != null && this.pending.hasNext()) {
                    this.nextName = this.pending.next();
                    return true;
                } else if (!this.configs.hasMoreElements()) {
                    return false;
                } else {
                    this.pending = ServiceLoader.this.parse(this.service, this.configs.nextElement());
                }
            }
        }

        public S next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String cn = this.nextName;
            this.nextName = null;
            Class<?> c = null;
            try {
                c = Class.forName(cn, false, this.loader);
            } catch (ClassNotFoundException x) {
                ServiceLoader.fail(this.service, "Provider " + cn + " not found", x);
            }
            if (!this.service.isAssignableFrom(c)) {
                ServiceLoader.fail(this.service, "Provider " + cn + " not a subtype", new ClassCastException(this.service.getCanonicalName() + " is not assignable from " + c.getCanonicalName()));
            }
            try {
                S p = this.service.cast(c.newInstance());
                ServiceLoader.this.providers.put(cn, p);
                return p;
            } catch (Throwable x2) {
                ServiceLoader.fail(this.service, "Provider " + cn + " could not be instantiated: " + x2, x2);
                throw new Error();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<S> iterator() {
        return new Iterator<S>() {
            Iterator<Map.Entry<String, S>> knownProviders = ServiceLoader.this.providers.entrySet().iterator();

            public boolean hasNext() {
                if (this.knownProviders.hasNext()) {
                    return true;
                }
                return ServiceLoader.this.lookupIterator.hasNext();
            }

            public S next() {
                if (this.knownProviders.hasNext()) {
                    return this.knownProviders.next().getValue();
                }
                return ServiceLoader.this.lookupIterator.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static <S> ServiceLoader<S> load(Class<S> service2, ClassLoader loader2) {
        return new ServiceLoader<>(service2, loader2);
    }

    public static <S> ServiceLoader<S> load(Class<S> service2) {
        return load(service2, Thread.currentThread().getContextClassLoader());
    }

    public static <S> ServiceLoader<S> loadInstalled(Class<S> service2) {
        ClassLoader prev = null;
        for (ClassLoader cl = ClassLoader.getSystemClassLoader(); cl != null; cl = cl.getParent()) {
            prev = cl;
        }
        return load(service2, prev);
    }

    public static <S> S loadFromSystemProperty(Class<S> service2) {
        try {
            String className = System.getProperty(service2.getName());
            if (className != null) {
                return ClassLoader.getSystemClassLoader().loadClass(className).newInstance();
            }
            return null;
        } catch (Exception e) {
            throw new Error((Throwable) e);
        }
    }

    public String toString() {
        return "java.util.ServiceLoader[" + this.service.getName() + "]";
    }
}
