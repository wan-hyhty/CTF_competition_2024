package sun.util;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IllformedLocaleException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.spi.LocaleServiceProvider;
import libcore.icu.ICU;
import sun.util.logging.PlatformLogger;
import sun.util.resources.OpenListResourceBundle;

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
public final class LocaleServiceProviderPool {
    private static volatile List<Locale> availableJRELocales;
    private static Locale locale_ja_JP_JP;
    private static Locale locale_th_TH_TH;
    private static ConcurrentMap<Class<? extends LocaleServiceProvider>, LocaleServiceProviderPool> poolOfPools;
    private Set<Locale> availableLocales;
    private Set<Locale> providerLocales;
    /* access modifiers changed from: private */
    public Set<LocaleServiceProvider> providers;
    private Map<Locale, LocaleServiceProvider> providersCache;

    private static class AllAvailableLocales {
        static final Locale[] allAvailableLocales = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.AllAvailableLocales.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.AllAvailableLocales.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.LocaleServiceProviderPool.AllAvailableLocales.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.AllAvailableLocales.<init>():void, dex: classes.dex
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
        private AllAvailableLocales() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.AllAvailableLocales.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.LocaleServiceProviderPool.AllAvailableLocales.<init>():void");
        }
    }

    public interface LocalizedObjectGetter<P, S> {
        S getObject(P p, Locale locale, String str, Object... objArr);
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.util.LocaleServiceProviderPool.<clinit>():void");
    }

    public static LocaleServiceProviderPool getPool(Class<? extends LocaleServiceProvider> providerClass) {
        LocaleServiceProviderPool pool = (LocaleServiceProviderPool) poolOfPools.get(providerClass);
        if (pool != null) {
            return pool;
        }
        LocaleServiceProviderPool newPool = new LocaleServiceProviderPool(providerClass);
        LocaleServiceProviderPool pool2 = poolOfPools.putIfAbsent(providerClass, newPool);
        if (pool2 == null) {
            return newPool;
        }
        return pool2;
    }

    private LocaleServiceProviderPool(final Class<? extends LocaleServiceProvider> c) {
        this.providers = new LinkedHashSet();
        this.providersCache = new ConcurrentHashMap();
        this.availableLocales = null;
        this.providerLocales = null;
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() {
                public Object run() {
                    for (LocaleServiceProvider provider : ServiceLoader.loadInstalled(c)) {
                        LocaleServiceProviderPool.this.providers.add(provider);
                    }
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            config(e.toString());
        }
    }

    private static void config(String message) {
        PlatformLogger.getLogger("sun.util.LocaleServiceProviderPool").config(message);
    }

    public static Locale[] getAllAvailableLocales() {
        return (Locale[]) AllAvailableLocales.allAvailableLocales.clone();
    }

    public synchronized Locale[] getAvailableLocales() {
        Locale[] tmp;
        if (this.availableLocales == null) {
            this.availableLocales = new HashSet(getJRELocales());
            if (hasProviders()) {
                this.availableLocales.addAll(getProviderLocales());
            }
        }
        tmp = new Locale[this.availableLocales.size()];
        this.availableLocales.toArray(tmp);
        return tmp;
    }

    /* access modifiers changed from: private */
    public synchronized Set<Locale> getProviderLocales() {
        if (this.providerLocales == null) {
            this.providerLocales = new HashSet();
            if (hasProviders()) {
                for (LocaleServiceProvider lsp : this.providers) {
                    for (Locale locale : lsp.getAvailableLocales()) {
                        this.providerLocales.add(getLookupLocale(locale));
                    }
                }
            }
        }
        return this.providerLocales;
    }

    public boolean hasProviders() {
        return !this.providers.isEmpty();
    }

    private List<Locale> getJRELocales() {
        if (availableJRELocales == null) {
            synchronized (LocaleServiceProviderPool.class) {
                if (availableJRELocales == null) {
                    Locale[] allLocales = ICU.getAvailableLocales();
                    List<Locale> tmpList = new ArrayList<>(allLocales.length);
                    for (Locale locale : allLocales) {
                        tmpList.add(getLookupLocale(locale));
                    }
                    availableJRELocales = tmpList;
                }
            }
        }
        return availableJRELocales;
    }

    private boolean isJRESupported(Locale locale) {
        return getJRELocales().contains(getLookupLocale(locale));
    }

    public <P, S> S getLocalizedObject(LocalizedObjectGetter<P, S> getter, Locale locale, Object... params) {
        return getLocalizedObjectImpl(getter, locale, true, (String) null, (OpenListResourceBundle) null, (String) null, params);
    }

    public <P, S> S getLocalizedObject(LocalizedObjectGetter<P, S> getter, Locale locale, OpenListResourceBundle bundle, String key, Object... params) {
        return getLocalizedObjectImpl(getter, locale, false, (String) null, bundle, key, params);
    }

    public <P, S> S getLocalizedObject(LocalizedObjectGetter<P, S> getter, Locale locale, String bundleKey, OpenListResourceBundle bundle, String key, Object... params) {
        return getLocalizedObjectImpl(getter, locale, false, bundleKey, bundle, key, params);
    }

    private <P, S> S getLocalizedObjectImpl(LocalizedObjectGetter<P, S> getter, Locale locale, boolean isObjectProvider, String bundleKey, OpenListResourceBundle bundle, String key, Object... params) {
        S providersObj;
        P lsp;
        if (!hasProviders()) {
            return null;
        }
        if (bundleKey == null) {
            bundleKey = key;
        }
        Locale bundleLocale = bundle != null ? bundle.getLocale() : null;
        List<Locale> lookupLocales = getLookupLocales(locale);
        Set<Locale> provLoc = getProviderLocales();
        for (int i = 0; i < lookupLocales.size(); i++) {
            Locale current = lookupLocales.get(i);
            if (bundleLocale == null) {
                if (isJRESupported(current)) {
                    break;
                }
            } else if (current.equals(bundleLocale)) {
                break;
            }
            if (provLoc.contains(current) && (lsp = findProvider(current)) != null) {
                S providersObj2 = getter.getObject(lsp, locale, key, params);
                if (providersObj2 != null) {
                    return providersObj2;
                }
                if (isObjectProvider) {
                    config("A locale sensitive service provider returned null for a localized objects,  which should not happen.  provider: " + lsp + " locale: " + locale);
                }
            }
        }
        while (bundle != null) {
            Locale bundleLocale2 = bundle.getLocale();
            if (bundle.handleGetKeys().contains(bundleKey)) {
                return null;
            }
            P lsp2 = findProvider(bundleLocale2);
            if (lsp2 != null && (providersObj = getter.getObject(lsp2, locale, key, params)) != null) {
                return providersObj;
            }
            bundle = bundle.getParent();
        }
        return null;
    }

    private LocaleServiceProvider findProvider(Locale locale) {
        if (!hasProviders()) {
            return null;
        }
        if (this.providersCache.containsKey(locale)) {
            LocaleServiceProvider provider = this.providersCache.get(locale);
            if (provider != NullProvider.INSTANCE) {
                return provider;
            }
        } else {
            for (LocaleServiceProvider lsp : this.providers) {
                Locale[] locales = lsp.getAvailableLocales();
                int i = 0;
                int length = locales.length;
                while (true) {
                    if (i < length) {
                        if (locale.equals(getLookupLocale(locales[i]))) {
                            LocaleServiceProvider providerInCache = this.providersCache.put(locale, lsp);
                            return providerInCache != null ? providerInCache : lsp;
                        }
                        i++;
                    }
                }
            }
            this.providersCache.put(locale, NullProvider.INSTANCE);
        }
        return null;
    }

    private static List<Locale> getLookupLocales(Locale locale) {
        return new ResourceBundle.Control() {
        }.getCandidateLocales("", locale);
    }

    /* access modifiers changed from: private */
    public static Locale getLookupLocale(Locale locale) {
        Locale lookupLocale = locale;
        if (locale.getExtensionKeys().isEmpty() || locale.equals(locale_ja_JP_JP) || locale.equals(locale_th_TH_TH)) {
            return lookupLocale;
        }
        Locale.Builder locbld = new Locale.Builder();
        try {
            locbld.setLocale(locale);
            locbld.clearExtensions();
            return locbld.build();
        } catch (IllformedLocaleException e) {
            config("A locale(" + locale + ") has non-empty extensions, but has illformed fields.");
            return new Locale(locale.getLanguage(), locale.getCountry(), locale.getVariant());
        }
    }

    private static class NullProvider extends LocaleServiceProvider {
        /* access modifiers changed from: private */
        public static final NullProvider INSTANCE = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.NullProvider.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.NullProvider.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.LocaleServiceProviderPool.NullProvider.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.NullProvider.<init>():void, dex: classes.dex
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
        private NullProvider() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.LocaleServiceProviderPool.NullProvider.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.LocaleServiceProviderPool.NullProvider.<init>():void");
        }

        public Locale[] getAvailableLocales() {
            throw new RuntimeException("Should not get called.");
        }
    }
}
