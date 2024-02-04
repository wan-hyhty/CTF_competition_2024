package java.util;

import dalvik.system.VMStack;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.ConcurrentMap;
import java.util.jar.JarEntry;
import sun.reflect.CallerSensitive;
import sun.util.locale.BaseLocale;
import sun.util.locale.LocaleExtensions;
import sun.util.locale.LocaleObjectCache;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class ResourceBundle {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f46assertionsDisabled = false;
    private static final int INITIAL_CACHE_SIZE = 32;
    private static final ResourceBundle NONEXISTENT_BUNDLE = null;
    private static final ConcurrentMap<CacheKey, BundleReference> cacheList = null;
    /* access modifiers changed from: private */
    public static final ReferenceQueue referenceQueue = null;
    private volatile CacheKey cacheKey;
    private volatile boolean expired;
    private volatile Set<String> keySet;
    private Locale locale;
    private String name;
    protected ResourceBundle parent;

    private interface CacheKeyReference {
        CacheKey getCacheKey();
    }

    private static class SingleFormatControl extends Control {
        /* access modifiers changed from: private */
        public static final Control CLASS_ONLY = null;
        /* access modifiers changed from: private */
        public static final Control PROPERTIES_ONLY = null;
        private final List<String> formats;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ResourceBundle.SingleFormatControl.<init>(java.util.List):void, dex: classes.dex
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
        protected SingleFormatControl(java.util.List<java.lang.String> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ResourceBundle.SingleFormatControl.<init>(java.util.List):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.SingleFormatControl.<init>(java.util.List):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ResourceBundle.SingleFormatControl.getFormats(java.lang.String):java.util.List<java.lang.String>, dex: classes.dex
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
        public java.util.List<java.lang.String> getFormats(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ResourceBundle.SingleFormatControl.getFormats(java.lang.String):java.util.List<java.lang.String>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.SingleFormatControl.getFormats(java.lang.String):java.util.List");
        }
    }

    public abstract Enumeration<String> getKeys();

    /* access modifiers changed from: protected */
    public abstract Object handleGetObject(String str);

    public ResourceBundle() {
        this.parent = null;
        this.locale = null;
    }

    public final String getString(String key) {
        return (String) getObject(key);
    }

    public final String[] getStringArray(String key) {
        return (String[]) getObject(key);
    }

    public final Object getObject(String key) {
        Object obj = handleGetObject(key);
        if (obj == null) {
            if (this.parent != null) {
                obj = this.parent.getObject(key);
            }
            if (obj == null) {
                throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + key, getClass().getName(), key);
            }
        }
        return obj;
    }

    public Locale getLocale() {
        return this.locale;
    }

    private static ClassLoader getLoader(ClassLoader cl) {
        if (cl == null) {
            return RBClassLoader.INSTANCE;
        }
        return cl;
    }

    private static class RBClassLoader extends ClassLoader {
        /* access modifiers changed from: private */
        public static final RBClassLoader INSTANCE = null;
        private static final ClassLoader loader = null;

        /* synthetic */ RBClassLoader(RBClassLoader rBClassLoader) {
            this();
        }

        private RBClassLoader() {
        }

        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (loader != null) {
                return loader.loadClass(name);
            }
            return Class.forName(name);
        }

        public URL getResource(String name) {
            if (loader != null) {
                return loader.getResource(name);
            }
            return ClassLoader.getSystemResource(name);
        }

        public InputStream getResourceAsStream(String name) {
            if (loader != null) {
                return loader.getResourceAsStream(name);
            }
            return ClassLoader.getSystemResourceAsStream(name);
        }
    }

    /* access modifiers changed from: protected */
    public void setParent(ResourceBundle parent2) {
        if (!f46assertionsDisabled) {
            if (!(parent2 != NONEXISTENT_BUNDLE ? true : f46assertionsDisabled)) {
                throw new AssertionError();
            }
        }
        this.parent = parent2;
    }

    private static final class CacheKey implements Cloneable {
        private Throwable cause;
        /* access modifiers changed from: private */
        public volatile long expirationTime;
        private String format;
        private int hashCodeCache;
        /* access modifiers changed from: private */
        public volatile long loadTime;
        private LoaderReference loaderRef;
        private Locale locale;
        private String name;

        CacheKey(String baseName, Locale locale2, ClassLoader loader) {
            this.name = baseName;
            this.locale = locale2;
            if (loader == null) {
                this.loaderRef = null;
            } else {
                this.loaderRef = new LoaderReference(loader, ResourceBundle.referenceQueue, this);
            }
            calculateHashCode();
        }

        /* access modifiers changed from: package-private */
        public String getName() {
            return this.name;
        }

        /* access modifiers changed from: package-private */
        public CacheKey setName(String baseName) {
            if (!this.name.equals(baseName)) {
                this.name = baseName;
                calculateHashCode();
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Locale getLocale() {
            return this.locale;
        }

        /* access modifiers changed from: package-private */
        public CacheKey setLocale(Locale locale2) {
            if (!this.locale.equals(locale2)) {
                this.locale = locale2;
                calculateHashCode();
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public ClassLoader getLoader() {
            if (this.loaderRef != null) {
                return (ClassLoader) this.loaderRef.get();
            }
            return null;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            try {
                CacheKey otherEntry = (CacheKey) other;
                if (this.hashCodeCache != otherEntry.hashCodeCache || !this.name.equals(otherEntry.name) || !this.locale.equals(otherEntry.locale)) {
                    return ResourceBundle.f46assertionsDisabled;
                }
                if (this.loaderRef != null) {
                    ClassLoader loader = (ClassLoader) this.loaderRef.get();
                    if (otherEntry.loaderRef == null || loader == null) {
                        return ResourceBundle.f46assertionsDisabled;
                    }
                    if (loader == otherEntry.loaderRef.get()) {
                        return true;
                    }
                    return ResourceBundle.f46assertionsDisabled;
                } else if (otherEntry.loaderRef == null) {
                    return true;
                } else {
                    return ResourceBundle.f46assertionsDisabled;
                }
            } catch (NullPointerException e) {
                return ResourceBundle.f46assertionsDisabled;
            } catch (ClassCastException e2) {
                return ResourceBundle.f46assertionsDisabled;
            }
        }

        public int hashCode() {
            return this.hashCodeCache;
        }

        private void calculateHashCode() {
            this.hashCodeCache = this.name.hashCode() << 3;
            this.hashCodeCache ^= this.locale.hashCode();
            ClassLoader loader = getLoader();
            if (loader != null) {
                this.hashCodeCache ^= loader.hashCode();
            }
        }

        public Object clone() {
            try {
                CacheKey clone = (CacheKey) super.clone();
                if (this.loaderRef != null) {
                    clone.loaderRef = new LoaderReference((ClassLoader) this.loaderRef.get(), ResourceBundle.referenceQueue, clone);
                }
                clone.cause = null;
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }

        /* access modifiers changed from: package-private */
        public String getFormat() {
            return this.format;
        }

        /* access modifiers changed from: package-private */
        public void setFormat(String format2) {
            this.format = format2;
        }

        /* access modifiers changed from: private */
        public void setCause(Throwable cause2) {
            if (this.cause == null) {
                this.cause = cause2;
            } else if (this.cause instanceof ClassNotFoundException) {
                this.cause = cause2;
            }
        }

        /* access modifiers changed from: private */
        public Throwable getCause() {
            return this.cause;
        }

        public String toString() {
            String l = this.locale.toString();
            if (l.length() == 0) {
                if (this.locale.getVariant().length() != 0) {
                    l = "__" + this.locale.getVariant();
                } else {
                    l = "\"\"";
                }
            }
            return "CacheKey[" + this.name + ", lc=" + l + ", ldr=" + getLoader() + "(format=" + this.format + ")]";
        }
    }

    private static final class LoaderReference extends WeakReference<ClassLoader> implements CacheKeyReference {
        private CacheKey cacheKey;

        LoaderReference(ClassLoader referent, ReferenceQueue q, CacheKey key) {
            super(referent, q);
            this.cacheKey = key;
        }

        public CacheKey getCacheKey() {
            return this.cacheKey;
        }
    }

    private static final class BundleReference extends SoftReference<ResourceBundle> implements CacheKeyReference {
        private CacheKey cacheKey;

        BundleReference(ResourceBundle referent, ReferenceQueue q, CacheKey key) {
            super(referent, q);
            this.cacheKey = key;
        }

        public CacheKey getCacheKey() {
            return this.cacheKey;
        }
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName) {
        return getBundleImpl(baseName, Locale.getDefault(), getLoader(VMStack.getCallingClassLoader()), Control.INSTANCE);
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName, Control control) {
        return getBundleImpl(baseName, Locale.getDefault(), getLoader(VMStack.getCallingClassLoader()), control);
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName, Locale locale2) {
        return getBundleImpl(baseName, locale2, getLoader(VMStack.getCallingClassLoader()), Control.INSTANCE);
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName, Locale targetLocale, Control control) {
        return getBundleImpl(baseName, targetLocale, getLoader(VMStack.getCallingClassLoader()), control);
    }

    public static ResourceBundle getBundle(String baseName, Locale locale2, ClassLoader loader) {
        if (loader != null) {
            return getBundleImpl(baseName, locale2, loader, Control.INSTANCE);
        }
        throw new NullPointerException();
    }

    public static ResourceBundle getBundle(String baseName, Locale targetLocale, ClassLoader loader, Control control) {
        if (loader != null && control != null) {
            return getBundleImpl(baseName, targetLocale, loader, control);
        }
        throw new NullPointerException();
    }

    private static ResourceBundle getBundleImpl(String baseName, Locale locale2, ClassLoader loader, Control control) {
        boolean z;
        if (locale2 == null || control == null) {
            throw new NullPointerException();
        }
        CacheKey cacheKey2 = new CacheKey(baseName, locale2, loader);
        ResourceBundle bundle = null;
        BundleReference bundleRef = (BundleReference) cacheList.get(cacheKey2);
        if (bundleRef != null) {
            bundle = (ResourceBundle) bundleRef.get();
        }
        if (isValidBundle(bundle) && hasValidParentChain(bundle)) {
            return bundle;
        }
        if (control != Control.INSTANCE) {
            z = control instanceof SingleFormatControl;
        } else {
            z = true;
        }
        List<String> formats = control.getFormats(baseName);
        if (z || checkList(formats)) {
            ResourceBundle baseBundle = null;
            Locale targetLocale = locale2;
            while (targetLocale != null) {
                List<Locale> candidateLocales = control.getCandidateLocales(baseName, targetLocale);
                if (z || checkList(candidateLocales)) {
                    bundle = findBundle(cacheKey2, candidateLocales, formats, 0, control, baseBundle);
                    if (isValidBundle(bundle)) {
                        boolean isBaseBundle = Locale.ROOT.equals(bundle.locale);
                        if (!isBaseBundle || bundle.locale.equals(locale2) || (candidateLocales.size() == 1 && bundle.locale.equals(candidateLocales.get(0)))) {
                            break;
                        } else if (isBaseBundle && baseBundle == null) {
                            baseBundle = bundle;
                        }
                    }
                    targetLocale = control.getFallbackLocale(baseName, targetLocale);
                } else {
                    throw new IllegalArgumentException("Invalid Control: getCandidateLocales");
                }
            }
            if (bundle != null) {
                return bundle;
            }
            if (baseBundle == null) {
                throwMissingResourceException(baseName, locale2, cacheKey2.getCause());
            }
            return baseBundle;
        }
        throw new IllegalArgumentException("Invalid Control: getFormats");
    }

    private static final boolean checkList(List a) {
        boolean valid;
        boolean valid2 = f46assertionsDisabled;
        if (!(a == null || a.size() == 0)) {
            valid2 = true;
        }
        if (valid) {
            int size = a.size();
            int i = 0;
            while (valid && i < size) {
                valid = a.get(i) != null ? true : f46assertionsDisabled;
                i++;
            }
        }
        return valid;
    }

    private static final ResourceBundle findBundle(CacheKey cacheKey2, List<Locale> candidateLocales, List<String> formats, int index, Control control, ResourceBundle baseBundle) {
        Locale targetLocale = candidateLocales.get(index);
        ResourceBundle parent2 = null;
        if (index != candidateLocales.size() - 1) {
            parent2 = findBundle(cacheKey2, candidateLocales, formats, index + 1, control, baseBundle);
        } else if (baseBundle != null && Locale.ROOT.equals(targetLocale)) {
            return baseBundle;
        }
        while (true) {
            Object ref = referenceQueue.poll();
            if (ref == null) {
                break;
            }
            cacheList.remove(((CacheKeyReference) ref).getCacheKey());
        }
        boolean expiredBundle = f46assertionsDisabled;
        cacheKey2.setLocale(targetLocale);
        ResourceBundle bundle = findBundleInCache(cacheKey2, control);
        if (isValidBundle(bundle) && !(expiredBundle = bundle.expired)) {
            if (bundle.parent == parent2) {
                return bundle;
            }
            BundleReference bundleRef = (BundleReference) cacheList.get(cacheKey2);
            if (bundleRef != null && bundleRef.get() == bundle) {
                cacheList.remove(cacheKey2, bundleRef);
            }
        }
        if (bundle != NONEXISTENT_BUNDLE) {
            CacheKey constKey = (CacheKey) cacheKey2.clone();
            try {
                ResourceBundle bundle2 = loadBundle(cacheKey2, formats, control, expiredBundle);
                if (bundle2 != null) {
                    if (bundle2.parent == null) {
                        bundle2.setParent(parent2);
                    }
                    bundle2.locale = targetLocale;
                    return putBundleInCache(cacheKey2, bundle2, control);
                }
                putBundleInCache(cacheKey2, NONEXISTENT_BUNDLE, control);
                if (constKey.getCause() instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                if (constKey.getCause() instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return parent2;
    }

    private static final ResourceBundle loadBundle(CacheKey cacheKey2, List<String> formats, Control control, boolean reload) {
        Locale targetLocale = cacheKey2.getLocale();
        ResourceBundle bundle = null;
        int size = formats.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String format = formats.get(i);
            try {
                bundle = control.newBundle(cacheKey2.getName(), targetLocale, format, cacheKey2.getLoader(), reload);
            } catch (LinkageError error) {
                cacheKey2.setCause(error);
            } catch (Exception cause) {
                cacheKey2.setCause(cause);
            }
            if (bundle != null) {
                cacheKey2.setFormat(format);
                bundle.name = cacheKey2.getName();
                bundle.locale = targetLocale;
                bundle.expired = f46assertionsDisabled;
                break;
            }
            i++;
        }
        return bundle;
    }

    private static final boolean isValidBundle(ResourceBundle bundle) {
        if (bundle == null || bundle == NONEXISTENT_BUNDLE) {
            return f46assertionsDisabled;
        }
        return true;
    }

    private static final boolean hasValidParentChain(ResourceBundle bundle) {
        long now = System.currentTimeMillis();
        while (bundle != null) {
            if (bundle.expired) {
                return f46assertionsDisabled;
            }
            CacheKey key = bundle.cacheKey;
            if (key != null) {
                long expirationTime = key.expirationTime;
                if (expirationTime >= 0 && expirationTime <= now) {
                    return f46assertionsDisabled;
                }
            }
            bundle = bundle.parent;
        }
        return true;
    }

    private static final void throwMissingResourceException(String baseName, Locale locale2, Throwable cause) {
        if (cause instanceof MissingResourceException) {
            cause = null;
        }
        throw new MissingResourceException("Can't find bundle for base name " + baseName + ", locale " + locale2, baseName + BaseLocale.SEP + locale2, "", cause);
    }

    private static final ResourceBundle findBundleInCache(CacheKey cacheKey2, Control control) {
        ResourceBundle bundle;
        boolean z = f46assertionsDisabled;
        BundleReference bundleRef = (BundleReference) cacheList.get(cacheKey2);
        if (bundleRef == null || (bundle = (ResourceBundle) bundleRef.get()) == null) {
            return null;
        }
        ResourceBundle p = bundle.parent;
        if (!f46assertionsDisabled) {
            if (!(p != NONEXISTENT_BUNDLE)) {
                throw new AssertionError();
            }
        }
        if (p == null || !p.expired) {
            CacheKey key = bundleRef.getCacheKey();
            long expirationTime = key.expirationTime;
            if (bundle.expired || expirationTime < 0 || expirationTime > System.currentTimeMillis()) {
                return bundle;
            }
            if (bundle != NONEXISTENT_BUNDLE) {
                synchronized (bundle) {
                    long expirationTime2 = key.expirationTime;
                    if (!bundle.expired && expirationTime2 >= 0 && expirationTime2 <= System.currentTimeMillis()) {
                        try {
                            bundle.expired = control.needsReload(key.getName(), key.getLocale(), key.getFormat(), key.getLoader(), bundle, key.loadTime);
                        } catch (Exception e) {
                            cacheKey2.setCause(e);
                        }
                        if (bundle.expired) {
                            bundle.cacheKey = null;
                            cacheList.remove(cacheKey2, bundleRef);
                        } else {
                            setExpirationTime(key, control);
                        }
                    }
                }
                return bundle;
            }
            cacheList.remove(cacheKey2, bundleRef);
            return null;
        }
        if (!f46assertionsDisabled) {
            if (bundle != NONEXISTENT_BUNDLE) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        bundle.expired = true;
        bundle.cacheKey = null;
        cacheList.remove(cacheKey2, bundleRef);
        return null;
    }

    private static final ResourceBundle putBundleInCache(CacheKey cacheKey2, ResourceBundle bundle, Control control) {
        setExpirationTime(cacheKey2, control);
        if (cacheKey2.expirationTime == -1) {
            return bundle;
        }
        CacheKey key = (CacheKey) cacheKey2.clone();
        BundleReference bundleRef = new BundleReference(bundle, referenceQueue, key);
        bundle.cacheKey = key;
        BundleReference result = cacheList.putIfAbsent(key, bundleRef);
        if (result == null) {
            return bundle;
        }
        ResourceBundle rb = (ResourceBundle) result.get();
        if (rb == null || rb.expired) {
            cacheList.put(key, bundleRef);
            return bundle;
        }
        bundle.cacheKey = null;
        ResourceBundle bundle2 = rb;
        bundleRef.clear();
        return bundle2;
    }

    private static final void setExpirationTime(CacheKey cacheKey2, Control control) {
        long ttl = control.getTimeToLive(cacheKey2.getName(), cacheKey2.getLocale());
        if (ttl >= 0) {
            long now = System.currentTimeMillis();
            long unused = cacheKey2.loadTime = now;
            long unused2 = cacheKey2.expirationTime = now + ttl;
        } else if (ttl >= -2) {
            long unused3 = cacheKey2.expirationTime = ttl;
        } else {
            throw new IllegalArgumentException("Invalid Control: TTL=" + ttl);
        }
    }

    @CallerSensitive
    public static final void clearCache() {
        clearCache(getLoader(VMStack.getCallingClassLoader()));
    }

    public static final void clearCache(ClassLoader loader) {
        if (loader == null) {
            throw new NullPointerException();
        }
        Set<CacheKey> set = cacheList.keySet();
        for (CacheKey key : set) {
            if (key.getLoader() == loader) {
                set.remove(key);
            }
        }
    }

    public boolean containsKey(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        for (ResourceBundle rb = this; rb != null; rb = rb.parent) {
            if (rb.handleKeySet().contains(key)) {
                return true;
            }
        }
        return f46assertionsDisabled;
    }

    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        for (ResourceBundle rb = this; rb != null; rb = rb.parent) {
            keys.addAll(rb.handleKeySet());
        }
        return keys;
    }

    /* access modifiers changed from: protected */
    public Set<String> handleKeySet() {
        if (this.keySet == null) {
            synchronized (this) {
                if (this.keySet == null) {
                    Set<String> keys = new HashSet<>();
                    Enumeration<String> enumKeys = getKeys();
                    while (enumKeys.hasMoreElements()) {
                        String key = enumKeys.nextElement();
                        if (handleGetObject(key) != null) {
                            keys.add(key);
                        }
                    }
                    this.keySet = keys;
                }
            }
        }
        return this.keySet;
    }

    public static class Control {
        private static final CandidateListCache CANDIDATES_CACHE = null;
        public static final List<String> FORMAT_CLASS = null;
        public static final List<String> FORMAT_DEFAULT = null;
        public static final List<String> FORMAT_PROPERTIES = null;
        /* access modifiers changed from: private */
        public static final Control INSTANCE = null;
        public static final long TTL_DONT_CACHE = -1;
        public static final long TTL_NO_EXPIRATION_CONTROL = -2;

        protected Control() {
        }

        public static final Control getControl(List<String> formats) {
            if (formats.equals(FORMAT_PROPERTIES)) {
                return SingleFormatControl.PROPERTIES_ONLY;
            }
            if (formats.equals(FORMAT_CLASS)) {
                return SingleFormatControl.CLASS_ONLY;
            }
            if (formats.equals(FORMAT_DEFAULT)) {
                return INSTANCE;
            }
            throw new IllegalArgumentException();
        }

        public static final Control getNoFallbackControl(List<String> formats) {
            if (formats.equals(FORMAT_DEFAULT)) {
                return NoFallbackControl.NO_FALLBACK;
            }
            if (formats.equals(FORMAT_PROPERTIES)) {
                return NoFallbackControl.PROPERTIES_ONLY_NO_FALLBACK;
            }
            if (formats.equals(FORMAT_CLASS)) {
                return NoFallbackControl.CLASS_ONLY_NO_FALLBACK;
            }
            throw new IllegalArgumentException();
        }

        public List<String> getFormats(String baseName) {
            if (baseName != null) {
                return FORMAT_DEFAULT;
            }
            throw new NullPointerException();
        }

        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            if (baseName != null) {
                return new ArrayList((Collection) CANDIDATES_CACHE.get(locale.getBaseLocale()));
            }
            throw new NullPointerException();
        }

        private static class CandidateListCache extends LocaleObjectCache<BaseLocale, List<Locale>> {
            /* synthetic */ CandidateListCache(CandidateListCache candidateListCache) {
                this();
            }

            private CandidateListCache() {
            }

            /* access modifiers changed from: protected */
            public List<Locale> createObject(BaseLocale base) {
                String language = base.getLanguage();
                String script = base.getScript();
                String region = base.getRegion();
                String variant = base.getVariant();
                boolean isNorwegianBokmal = ResourceBundle.f46assertionsDisabled;
                boolean isNorwegianNynorsk = ResourceBundle.f46assertionsDisabled;
                if (language.equals("no")) {
                    if (!region.equals("NO") || !variant.equals("NY")) {
                        isNorwegianBokmal = true;
                    } else {
                        variant = "";
                        isNorwegianNynorsk = true;
                    }
                }
                if (language.equals("nb") || isNorwegianBokmal) {
                    List<Locale> tmpList = getDefaultList("nb", script, region, variant);
                    List<Locale> bokmalList = new LinkedList<>();
                    for (Locale l : tmpList) {
                        bokmalList.add(l);
                        if (l.getLanguage().length() == 0) {
                            break;
                        }
                        bokmalList.add(Locale.getInstance("no", l.getScript(), l.getCountry(), l.getVariant(), (LocaleExtensions) null));
                    }
                    return bokmalList;
                } else if (language.equals("nn") || isNorwegianNynorsk) {
                    List<Locale> nynorskList = getDefaultList("nn", script, region, variant);
                    int idx = nynorskList.size() - 1;
                    int idx2 = idx + 1;
                    nynorskList.add(idx, Locale.getInstance("no", "NO", "NY"));
                    int idx3 = idx2 + 1;
                    nynorskList.add(idx2, Locale.getInstance("no", "NO", ""));
                    int i = idx3 + 1;
                    nynorskList.add(idx3, Locale.getInstance("no", "", ""));
                    return nynorskList;
                } else {
                    if (language.equals("zh")) {
                        if (script.length() != 0 || region.length() <= 0) {
                            if (script.length() > 0 && region.length() == 0) {
                                if (script.equals("Hans")) {
                                    region = "CN";
                                } else if (script.equals("Hant")) {
                                    region = "TW";
                                }
                            }
                        } else if (region.equals("TW") || region.equals("HK") || region.equals("MO")) {
                            script = "Hant";
                        } else if (region.equals("CN") || region.equals("SG")) {
                            script = "Hans";
                        }
                    }
                    return getDefaultList(language, script, region, variant);
                }
            }

            private static List<Locale> getDefaultList(String language, String script, String region, String variant) {
                List<String> variants = null;
                if (variant.length() > 0) {
                    variants = new LinkedList<>();
                    int idx = variant.length();
                    while (idx != -1) {
                        variants.add(variant.substring(0, idx));
                        idx = variant.lastIndexOf(95, idx - 1);
                    }
                }
                List<Locale> list = new LinkedList<>();
                if (variants != null) {
                    for (String v : variants) {
                        list.add(Locale.getInstance(language, script, region, v, (LocaleExtensions) null));
                    }
                }
                if (region.length() > 0) {
                    list.add(Locale.getInstance(language, script, region, "", (LocaleExtensions) null));
                }
                if (script.length() > 0) {
                    list.add(Locale.getInstance(language, script, "", "", (LocaleExtensions) null));
                    if (variants != null) {
                        for (String v2 : variants) {
                            list.add(Locale.getInstance(language, "", region, v2, (LocaleExtensions) null));
                        }
                    }
                    if (region.length() > 0) {
                        list.add(Locale.getInstance(language, "", region, "", (LocaleExtensions) null));
                    }
                }
                if (language.length() > 0) {
                    list.add(Locale.getInstance(language, "", "", "", (LocaleExtensions) null));
                }
                list.add(Locale.ROOT);
                return list;
            }
        }

        public Locale getFallbackLocale(String baseName, Locale locale) {
            if (baseName == null) {
                throw new NullPointerException();
            }
            Locale defaultLocale = Locale.getDefault();
            if (locale.equals(defaultLocale)) {
                return null;
            }
            return defaultLocale;
        }

        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
            String bundleName = toBundleName(baseName, locale);
            if (format.equals("java.class")) {
                try {
                    Class<?> loadClass = loader.loadClass(bundleName);
                    if (ResourceBundle.class.isAssignableFrom(loadClass)) {
                        return (ResourceBundle) loadClass.newInstance();
                    }
                    throw new ClassCastException(loadClass.getName() + " cannot be cast to ResourceBundle");
                } catch (ClassNotFoundException e) {
                    return null;
                }
            } else if (format.equals("java.properties")) {
                final String resourceName = toResourceName(bundleName, "properties");
                ClassLoader classLoader = loader;
                boolean z = reload;
                try {
                    final boolean z2 = reload;
                    final ClassLoader classLoader2 = loader;
                    InputStream stream = (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() {
                        public InputStream run() throws IOException {
                            URLConnection connection;
                            if (!z2) {
                                return classLoader2.getResourceAsStream(resourceName);
                            }
                            URL url = classLoader2.getResource(resourceName);
                            if (url == null || (connection = url.openConnection()) == null) {
                                return null;
                            }
                            connection.setUseCaches(ResourceBundle.f46assertionsDisabled);
                            return connection.getInputStream();
                        }
                    });
                    if (stream == null) {
                        return null;
                    }
                    try {
                        return new PropertyResourceBundle((Reader) new InputStreamReader(stream, StandardCharsets.UTF_8));
                    } finally {
                        stream.close();
                    }
                } catch (PrivilegedActionException e2) {
                    throw ((IOException) e2.getException());
                }
            } else {
                throw new IllegalArgumentException("unknown format: " + format);
            }
        }

        public long getTimeToLive(String baseName, Locale locale) {
            if (baseName != null && locale != null) {
                return -2;
            }
            throw new NullPointerException();
        }

        public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
            if (bundle == null) {
                throw new NullPointerException();
            }
            if (format.equals("java.class") || format.equals("java.properties")) {
                format = format.substring(5);
            }
            try {
                URL url = loader.getResource(toResourceName(toBundleName(baseName, locale), format));
                if (url == null) {
                    return ResourceBundle.f46assertionsDisabled;
                }
                long lastModified = 0;
                URLConnection connection = url.openConnection();
                if (connection != null) {
                    connection.setUseCaches(ResourceBundle.f46assertionsDisabled);
                    if (connection instanceof JarURLConnection) {
                        JarEntry ent = ((JarURLConnection) connection).getJarEntry();
                        if (ent != null) {
                            lastModified = ent.getTime();
                            if (lastModified == -1) {
                                lastModified = 0;
                            }
                        }
                    } else {
                        lastModified = connection.getLastModified();
                    }
                }
                if (lastModified >= loadTime) {
                    return true;
                }
                return ResourceBundle.f46assertionsDisabled;
            } catch (NullPointerException npe) {
                throw npe;
            } catch (Exception e) {
                return ResourceBundle.f46assertionsDisabled;
            }
        }

        public String toBundleName(String baseName, Locale locale) {
            if (locale == Locale.ROOT) {
                return baseName;
            }
            String language = locale.getLanguage();
            String script = locale.getScript();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            if (language == "" && country == "" && variant == "") {
                return baseName;
            }
            StringBuilder sb = new StringBuilder(baseName);
            sb.append('_');
            if (script != "") {
                if (variant != "") {
                    sb.append(language).append('_').append(script).append('_').append(country).append('_').append(variant);
                } else if (country != "") {
                    sb.append(language).append('_').append(script).append('_').append(country);
                } else {
                    sb.append(language).append('_').append(script);
                }
            } else if (variant != "") {
                sb.append(language).append('_').append(country).append('_').append(variant);
            } else if (country != "") {
                sb.append(language).append('_').append(country);
            } else {
                sb.append(language);
            }
            return sb.toString();
        }

        public final String toResourceName(String bundleName, String suffix) {
            StringBuilder sb = new StringBuilder(bundleName.length() + 1 + suffix.length());
            sb.append(bundleName.replace('.', '/')).append('.').append(suffix);
            return sb.toString();
        }
    }

    private static final class NoFallbackControl extends SingleFormatControl {
        /* access modifiers changed from: private */
        public static final Control CLASS_ONLY_NO_FALLBACK = null;
        /* access modifiers changed from: private */
        public static final Control NO_FALLBACK = null;
        /* access modifiers changed from: private */
        public static final Control PROPERTIES_ONLY_NO_FALLBACK = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ResourceBundle.NoFallbackControl.<init>(java.util.List):void, dex: classes.dex
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
        protected NoFallbackControl(java.util.List<java.lang.String> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ResourceBundle.NoFallbackControl.<init>(java.util.List):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.NoFallbackControl.<init>(java.util.List):void");
        }

        public Locale getFallbackLocale(String baseName, Locale locale) {
            if (baseName != null && locale != null) {
                return null;
            }
            throw new NullPointerException();
        }
    }
}
