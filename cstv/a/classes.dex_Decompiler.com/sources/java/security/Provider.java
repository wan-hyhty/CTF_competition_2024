package java.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import sun.security.util.Debug;

public abstract class Provider extends Properties {
    private static final int ALIAS_LENGTH = 0;
    private static final String ALIAS_PREFIX = "Alg.Alias.";
    private static final String ALIAS_PREFIX_LOWER = "alg.alias.";
    private static final Debug debug = null;
    /* access modifiers changed from: private */
    public static final Map<String, EngineDescription> knownEngines = null;
    private static volatile ServiceKey previousKey = null;
    static final long serialVersionUID = -4298000515446427739L;
    private transient Set<Map.Entry<Object, Object>> entrySet = null;
    private transient int entrySetCallCount = 0;
    private String info;
    private transient boolean initialized;
    private transient boolean legacyChanged;
    private transient Map<ServiceKey, Service> legacyMap;
    private transient Map<String, String> legacyStrings;
    private String name;
    private volatile boolean registered = false;
    private transient Map<ServiceKey, Service> serviceMap;
    private transient Set<Service> serviceSet;
    private transient boolean servicesChanged;
    private double version;

    protected Provider(String name2, double version2, String info2) {
        this.name = name2;
        this.version = version2;
        this.info = info2;
        putId();
        this.initialized = true;
    }

    public String getName() {
        return this.name;
    }

    public double getVersion() {
        return this.version;
    }

    public String getInfo() {
        return this.info;
    }

    public String toString() {
        return this.name + " version " + this.version;
    }

    public synchronized void clear() {
        check("clearProviderProperties." + this.name);
        if (debug != null) {
            debug.println("Remove " + this.name + " provider properties");
        }
        implClear();
    }

    public synchronized void load(InputStream inStream) throws IOException {
        check("putProviderProperty." + this.name);
        if (debug != null) {
            debug.println("Load " + this.name + " provider properties");
        }
        Properties tempProperties = new Properties();
        tempProperties.load(inStream);
        implPutAll(tempProperties);
    }

    public synchronized void putAll(Map<?, ?> t) {
        check("putProviderProperty." + this.name);
        if (debug != null) {
            debug.println("Put all " + this.name + " provider properties");
        }
        implPutAll(t);
    }

    public synchronized Set<Map.Entry<Object, Object>> entrySet() {
        checkInitialized();
        if (this.entrySet == null) {
            int i = this.entrySetCallCount;
            this.entrySetCallCount = i + 1;
            if (i == 0) {
                this.entrySet = Collections.unmodifiableMap(this).entrySet();
            } else {
                return super.entrySet();
            }
        }
        if (this.entrySetCallCount != 2) {
            throw new RuntimeException("Internal error.");
        }
        return this.entrySet;
    }

    public Set<Object> keySet() {
        checkInitialized();
        return Collections.unmodifiableSet(super.keySet());
    }

    public Collection<Object> values() {
        checkInitialized();
        return Collections.unmodifiableCollection(super.values());
    }

    public synchronized Object put(Object key, Object value) {
        check("putProviderProperty." + this.name);
        if (debug != null) {
            debug.println("Set " + this.name + " provider property [" + key + "/" + value + "]");
        }
        return implPut(key, value);
    }

    public synchronized Object remove(Object key) {
        check("removeProviderProperty." + this.name);
        if (debug != null) {
            debug.println("Remove " + this.name + " provider property " + key);
        }
        return implRemove(key);
    }

    public Object get(Object key) {
        checkInitialized();
        return super.get(key);
    }

    public synchronized void forEach(BiConsumer<? super Object, ? super Object> action) {
        checkInitialized();
        super.forEach(action);
    }

    public Enumeration<Object> keys() {
        checkInitialized();
        return super.keys();
    }

    public Enumeration<Object> elements() {
        checkInitialized();
        return super.elements();
    }

    public String getProperty(String key) {
        checkInitialized();
        return super.getProperty(key);
    }

    private void checkInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException();
        }
    }

    private void check(String directive) {
        checkInitialized();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkSecurityAccess(directive);
        }
    }

    private void putId() {
        super.put("Provider.id name", String.valueOf((Object) this.name));
        super.put("Provider.id version", String.valueOf(this.version));
        super.put("Provider.id info", String.valueOf((Object) this.info));
        super.put("Provider.id className", getClass().getName());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.registered = false;
        Map<Object, Object> copy = new HashMap<>();
        for (Map.Entry<Object, Object> entry : super.entrySet()) {
            copy.put(entry.getKey(), entry.getValue());
        }
        this.defaults = null;
        in.defaultReadObject();
        implClear();
        this.initialized = true;
        putAll(copy);
    }

    private void implPutAll(Map t) {
        for (Map.Entry e : t.entrySet()) {
            implPut(e.getKey(), e.getValue());
        }
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    private Object implRemove(Object key) {
        if (this.registered) {
            Security.increaseVersion();
        }
        if (key instanceof String) {
            String keyString = (String) key;
            if (keyString.startsWith("Provider.")) {
                return null;
            }
            this.legacyChanged = true;
            if (this.legacyStrings == null) {
                this.legacyStrings = new LinkedHashMap();
            }
            this.legacyStrings.remove(keyString);
        }
        return super.remove(key);
    }

    private Object implPut(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            String keyString = (String) key;
            if (keyString.startsWith("Provider.")) {
                return null;
            }
            if (this.registered) {
                Security.increaseVersion();
            }
            this.legacyChanged = true;
            if (this.legacyStrings == null) {
                this.legacyStrings = new LinkedHashMap();
            }
            this.legacyStrings.put(keyString, (String) value);
        }
        return super.put(key, value);
    }

    private void implClear() {
        if (this.legacyStrings != null) {
            this.legacyStrings.clear();
        }
        if (this.legacyMap != null) {
            this.legacyMap.clear();
        }
        if (this.serviceMap != null) {
            this.serviceMap.clear();
        }
        this.legacyChanged = false;
        this.servicesChanged = false;
        this.serviceSet = null;
        super.clear();
        putId();
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    private static class ServiceKey {
        private final String algorithm;
        private final String originalAlgorithm;
        private final String type;

        /* synthetic */ ServiceKey(String type2, String algorithm2, boolean intern, ServiceKey serviceKey) {
            this(type2, algorithm2, intern);
        }

        private ServiceKey(String type2, String algorithm2, boolean intern) {
            this.type = type2;
            this.originalAlgorithm = algorithm2;
            String algorithm3 = algorithm2.toUpperCase(Locale.ENGLISH);
            this.algorithm = intern ? algorithm3.intern() : algorithm3;
        }

        public int hashCode() {
            return this.type.hashCode() + this.algorithm.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServiceKey)) {
                return false;
            }
            ServiceKey other = (ServiceKey) obj;
            if (this.type.equals(other.type)) {
                return this.algorithm.equals(other.algorithm);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean matches(String type2, String algorithm2) {
            return this.type == type2 && this.originalAlgorithm == algorithm2;
        }
    }

    private void ensureLegacyParsed() {
        if (this.legacyChanged && this.legacyStrings != null) {
            this.serviceSet = null;
            if (this.legacyMap == null) {
                this.legacyMap = new LinkedHashMap();
            } else {
                this.legacyMap.clear();
            }
            for (Map.Entry<String, String> entry : this.legacyStrings.entrySet()) {
                parseLegacyPut(entry.getKey(), entry.getValue());
            }
            removeInvalidServices(this.legacyMap);
            this.legacyChanged = false;
        }
    }

    private void removeInvalidServices(Map<ServiceKey, Service> map) {
        Iterator t = map.entrySet().iterator();
        while (t.hasNext()) {
            if (!((Service) t.next().getValue()).isValid()) {
                t.remove();
            }
        }
    }

    private String[] getTypeAndAlgorithm(String key) {
        int i = key.indexOf(".");
        if (i < 1) {
            if (debug != null) {
                debug.println("Ignoring invalid entry in provider " + this.name + ":" + key);
            }
            return null;
        }
        return new String[]{key.substring(0, i), key.substring(i + 1)};
    }

    private void parseLegacyPut(String name2, String value) {
        if (name2.toLowerCase(Locale.ENGLISH).startsWith(ALIAS_PREFIX_LOWER)) {
            String str = value;
            String[] typeAndAlg = getTypeAndAlgorithm(name2.substring(ALIAS_LENGTH));
            if (typeAndAlg != null) {
                String type = typeAndAlg[0];
                String aliasAlg = typeAndAlg[1].intern();
                ServiceKey key = new ServiceKey(type, value, true, (ServiceKey) null);
                Service s = this.legacyMap.get(key);
                if (s == null) {
                    s = new Service(this, (Service) null);
                    String unused = s.type = type;
                    String unused2 = s.algorithm = value;
                    this.legacyMap.put(key, s);
                }
                this.legacyMap.put(new ServiceKey(type, aliasAlg, true, (ServiceKey) null), s);
                s.addAlias(aliasAlg);
                return;
            }
            return;
        }
        String[] typeAndAlg2 = getTypeAndAlgorithm(name2);
        if (typeAndAlg2 != null) {
            int i = typeAndAlg2[1].indexOf(32);
            if (i == -1) {
                String type2 = typeAndAlg2[0];
                String stdAlg = typeAndAlg2[1].intern();
                String str2 = value;
                ServiceKey key2 = new ServiceKey(type2, stdAlg, true, (ServiceKey) null);
                Service s2 = this.legacyMap.get(key2);
                if (s2 == null) {
                    s2 = new Service(this, (Service) null);
                    String unused3 = s2.type = type2;
                    String unused4 = s2.algorithm = stdAlg;
                    this.legacyMap.put(key2, s2);
                }
                String unused5 = s2.className = value;
                return;
            }
            String str3 = value;
            String type3 = typeAndAlg2[0];
            String attributeString = typeAndAlg2[1];
            String stdAlg2 = attributeString.substring(0, i).intern();
            String attributeName = attributeString.substring(i + 1);
            while (attributeName.startsWith(" ")) {
                attributeName = attributeName.substring(1);
            }
            String attributeName2 = attributeName.intern();
            ServiceKey key3 = new ServiceKey(type3, stdAlg2, true, (ServiceKey) null);
            Service s3 = this.legacyMap.get(key3);
            if (s3 == null) {
                s3 = new Service(this, (Service) null);
                String unused6 = s3.type = type3;
                String unused7 = s3.algorithm = stdAlg2;
                this.legacyMap.put(key3, s3);
            }
            s3.addAttribute(attributeName2, value);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.security.Provider.Service getService(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            r2 = 0
            monitor-enter(r5)
            r5.checkInitialized()     // Catch:{ all -> 0x0037 }
            java.security.Provider$ServiceKey r0 = previousKey     // Catch:{ all -> 0x0037 }
            boolean r3 = r0.matches(r6, r7)     // Catch:{ all -> 0x0037 }
            if (r3 != 0) goto L_0x0016
            java.security.Provider$ServiceKey r0 = new java.security.Provider$ServiceKey     // Catch:{ all -> 0x0037 }
            r3 = 0
            r4 = 0
            r0.<init>(r6, r7, r3, r4)     // Catch:{ all -> 0x0037 }
            previousKey = r0     // Catch:{ all -> 0x0037 }
        L_0x0016:
            java.util.Map<java.security.Provider$ServiceKey, java.security.Provider$Service> r3 = r5.serviceMap     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0026
            java.util.Map<java.security.Provider$ServiceKey, java.security.Provider$Service> r3 = r5.serviceMap     // Catch:{ all -> 0x0037 }
            java.lang.Object r1 = r3.get(r0)     // Catch:{ all -> 0x0037 }
            java.security.Provider$Service r1 = (java.security.Provider.Service) r1     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r5)
            return r1
        L_0x0026:
            r5.ensureLegacyParsed()     // Catch:{ all -> 0x0037 }
            java.util.Map<java.security.Provider$ServiceKey, java.security.Provider$Service> r3 = r5.legacyMap     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0035
            java.util.Map<java.security.Provider$ServiceKey, java.security.Provider$Service> r2 = r5.legacyMap     // Catch:{ all -> 0x0037 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0037 }
            java.security.Provider$Service r2 = (java.security.Provider.Service) r2     // Catch:{ all -> 0x0037 }
        L_0x0035:
            monitor-exit(r5)
            return r2
        L_0x0037:
            r2 = move-exception
            monitor-exit(r5)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.Provider.getService(java.lang.String, java.lang.String):java.security.Provider$Service");
    }

    public synchronized Set<Service> getServices() {
        checkInitialized();
        if (this.legacyChanged || this.servicesChanged) {
            this.serviceSet = null;
        }
        if (this.serviceSet == null) {
            ensureLegacyParsed();
            Set<Service> set = new LinkedHashSet<>();
            if (this.serviceMap != null) {
                set.addAll(this.serviceMap.values());
            }
            if (this.legacyMap != null) {
                set.addAll(this.legacyMap.values());
            }
            this.serviceSet = Collections.unmodifiableSet(set);
            this.servicesChanged = false;
        }
        return this.serviceSet;
    }

    /* access modifiers changed from: protected */
    public synchronized void putService(Service s) {
        check("putProviderProperty." + this.name);
        if (debug != null) {
            debug.println(this.name + ".putService(): " + s);
        }
        if (s == null) {
            throw new NullPointerException();
        } else if (s.getProvider() != this) {
            throw new IllegalArgumentException("service.getProvider() must match this Provider object");
        } else {
            if (this.serviceMap == null) {
                this.serviceMap = new LinkedHashMap();
            }
            this.servicesChanged = true;
            String type = s.getType();
            ServiceKey key = new ServiceKey(type, s.getAlgorithm(), true, (ServiceKey) null);
            implRemoveService(this.serviceMap.get(key));
            this.serviceMap.put(key, s);
            for (String alias : s.getAliases()) {
                this.serviceMap.put(new ServiceKey(type, alias, true, (ServiceKey) null), s);
            }
            putPropertyStrings(s);
        }
    }

    private void putPropertyStrings(Service s) {
        String type = s.getType();
        String algorithm = s.getAlgorithm();
        super.put(type + "." + algorithm, s.getClassName());
        for (String alias : s.getAliases()) {
            super.put(ALIAS_PREFIX + type + "." + alias, algorithm);
        }
        for (Map.Entry<UString, String> entry : s.attributes.entrySet()) {
            super.put(type + "." + algorithm + " " + entry.getKey(), entry.getValue());
        }
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    private void removePropertyStrings(Service s) {
        String type = s.getType();
        String algorithm = s.getAlgorithm();
        super.remove(type + "." + algorithm);
        for (String alias : s.getAliases()) {
            super.remove(ALIAS_PREFIX + type + "." + alias);
        }
        for (Map.Entry<UString, String> entry : s.attributes.entrySet()) {
            super.remove(type + "." + algorithm + " " + entry.getKey());
        }
        if (this.registered) {
            Security.increaseVersion();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void removeService(Service s) {
        check("removeProviderProperty." + this.name);
        if (debug != null) {
            debug.println(this.name + ".removeService(): " + s);
        }
        if (s == null) {
            throw new NullPointerException();
        }
        implRemoveService(s);
    }

    private void implRemoveService(Service s) {
        if (s != null && this.serviceMap != null) {
            String type = s.getType();
            ServiceKey key = new ServiceKey(type, s.getAlgorithm(), false, (ServiceKey) null);
            if (s == this.serviceMap.get(key)) {
                this.servicesChanged = true;
                this.serviceMap.remove(key);
                for (String alias : s.getAliases()) {
                    this.serviceMap.remove(new ServiceKey(type, alias, false, (ServiceKey) null));
                }
                removePropertyStrings(s);
            }
        }
    }

    private static class UString {
        final String lowerString;
        final String string;

        UString(String s) {
            this.string = s;
            this.lowerString = s.toLowerCase(Locale.ENGLISH);
        }

        public int hashCode() {
            return this.lowerString.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UString)) {
                return false;
            }
            return this.lowerString.equals(((UString) obj).lowerString);
        }

        public String toString() {
            return this.string;
        }
    }

    private static class EngineDescription {
        private volatile Class constructorParameterClass;
        final String constructorParameterClassName;
        final String name;
        final boolean supportsParameter;

        EngineDescription(String name2, boolean sp, String paramName) {
            this.name = name2;
            this.supportsParameter = sp;
            this.constructorParameterClassName = paramName;
        }

        /* access modifiers changed from: package-private */
        public Class getConstructorParameterClass() throws ClassNotFoundException {
            Class clazz = this.constructorParameterClass;
            if (clazz != null) {
                return clazz;
            }
            Class clazz2 = Class.forName(this.constructorParameterClassName);
            this.constructorParameterClass = clazz2;
            return clazz2;
        }
    }

    private static void addEngine(String name2, boolean sp, String paramName) {
        knownEngines.put(name2, new EngineDescription(name2, sp, paramName));
    }

    public static class Service {
        private static final Class[] CLASS0 = null;
        /* access modifiers changed from: private */
        public String algorithm;
        private List<String> aliases;
        /* access modifiers changed from: private */
        public Map<UString, String> attributes;
        /* access modifiers changed from: private */
        public String className;
        private volatile Reference<Class> classRef;
        private volatile Boolean hasKeyAttributes;
        private final Provider provider;
        private boolean registered;
        private Class[] supportedClasses;
        private String[] supportedFormats;
        /* access modifiers changed from: private */
        public String type;

        /* synthetic */ Service(Provider provider2, Service service) {
            this(provider2);
        }

        private Service(Provider provider2) {
            this.provider = provider2;
            this.aliases = Collections.emptyList();
            this.attributes = Collections.emptyMap();
        }

        /* access modifiers changed from: private */
        public boolean isValid() {
            return (this.type == null || this.algorithm == null || this.className == null) ? false : true;
        }

        /* access modifiers changed from: private */
        public void addAlias(String alias) {
            if (this.aliases.isEmpty()) {
                this.aliases = new ArrayList(2);
            }
            this.aliases.add(alias);
        }

        /* access modifiers changed from: package-private */
        public void addAttribute(String type2, String value) {
            if (this.attributes.isEmpty()) {
                this.attributes = new HashMap(8);
            }
            this.attributes.put(new UString(type2), value);
        }

        public Service(Provider provider2, String type2, String algorithm2, String className2, List<String> aliases2, Map<String, String> attributes2) {
            if (provider2 == null || type2 == null || algorithm2 == null || className2 == null) {
                throw new NullPointerException();
            }
            this.provider = provider2;
            this.type = type2;
            this.algorithm = algorithm2;
            this.className = className2;
            if (aliases2 == null) {
                this.aliases = Collections.emptyList();
            } else {
                this.aliases = new ArrayList(aliases2);
            }
            if (attributes2 == null) {
                this.attributes = Collections.emptyMap();
                return;
            }
            this.attributes = new HashMap();
            for (Map.Entry<String, String> entry : attributes2.entrySet()) {
                this.attributes.put(new UString(entry.getKey()), entry.getValue());
            }
        }

        public final String getType() {
            return this.type;
        }

        public final String getAlgorithm() {
            return this.algorithm;
        }

        public final Provider getProvider() {
            return this.provider;
        }

        public final String getClassName() {
            return this.className;
        }

        /* access modifiers changed from: private */
        public final List<String> getAliases() {
            return this.aliases;
        }

        public final String getAttribute(String name) {
            if (name != null) {
                return this.attributes.get(new UString(name));
            }
            throw new NullPointerException();
        }

        public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            if (!this.registered) {
                if (this.provider.getService(this.type, this.algorithm) != this) {
                    throw new NoSuchAlgorithmException("Service not registered with Provider " + this.provider.getName() + ": " + this);
                }
                this.registered = true;
            }
            try {
                EngineDescription cap = (EngineDescription) Provider.knownEngines.get(this.type);
                if (cap == null) {
                    return newInstanceGeneric(constructorParameter);
                }
                if (cap.constructorParameterClassName != null) {
                    Class paramClass = cap.getConstructorParameterClass();
                    if (constructorParameter == null || paramClass.isAssignableFrom(constructorParameter.getClass())) {
                        return getImplClass().getConstructor(paramClass).newInstance(constructorParameter);
                    }
                    throw new InvalidParameterException("constructorParameter must be instanceof " + cap.constructorParameterClassName.replace('$', '.') + " for engine type " + this.type);
                } else if (constructorParameter == null) {
                    return getImplClass().newInstance();
                } else {
                    throw new InvalidParameterException("constructorParameter not used with " + this.type + " engines");
                }
            } catch (NoSuchAlgorithmException e) {
                throw e;
            } catch (InvocationTargetException e2) {
                throw new NoSuchAlgorithmException("Error constructing implementation (algorithm: " + this.algorithm + ", provider: " + this.provider.getName() + ", class: " + this.className + ")", e2.getCause());
            } catch (Exception e3) {
                throw new NoSuchAlgorithmException("Error constructing implementation (algorithm: " + this.algorithm + ", provider: " + this.provider.getName() + ", class: " + this.className + ")", e3);
            }
        }

        private Class getImplClass() throws NoSuchAlgorithmException {
            try {
                Reference<Class> ref = this.classRef;
                Class clazz = ref == null ? null : ref.get();
                if (clazz == null) {
                    ClassLoader cl = this.provider.getClass().getClassLoader();
                    if (cl == null) {
                        clazz = Class.forName(this.className);
                    } else {
                        clazz = cl.loadClass(this.className);
                    }
                    this.classRef = new WeakReference(clazz);
                }
                return clazz;
            } catch (ClassNotFoundException e) {
                throw new NoSuchAlgorithmException("class configured for " + this.type + "(provider: " + this.provider.getName() + ")" + "cannot be found.", e);
            }
        }

        private Object newInstanceGeneric(Object constructorParameter) throws Exception {
            Class clazz = getImplClass();
            if (constructorParameter == null) {
                return clazz.newInstance();
            }
            Class argClass = constructorParameter.getClass();
            Constructor[] cons = clazz.getConstructors();
            for (Constructor con : cons) {
                Class[] paramTypes = con.getParameterTypes();
                if (paramTypes.length == 1 && paramTypes[0].isAssignableFrom(argClass)) {
                    return con.newInstance(constructorParameter);
                }
            }
            throw new NoSuchAlgorithmException("No constructor matching " + argClass.getName() + " found in class " + this.className);
        }

        public boolean supportsParameter(Object parameter) {
            EngineDescription cap = (EngineDescription) Provider.knownEngines.get(this.type);
            if (cap == null) {
                return true;
            }
            if (!cap.supportsParameter) {
                throw new InvalidParameterException("supportsParameter() not used with " + this.type + " engines");
            } else if (parameter != null && !(parameter instanceof Key)) {
                throw new InvalidParameterException("Parameter must be instanceof Key for engine " + this.type);
            } else if (!hasKeyAttributes()) {
                return true;
            } else {
                if (parameter == null) {
                    return false;
                }
                Key key = (Key) parameter;
                return supportsKeyFormat(key) || supportsKeyClass(key);
            }
        }

        private boolean hasKeyAttributes() {
            boolean bool = true;
            Boolean b = this.hasKeyAttributes;
            if (b == null) {
                synchronized (this) {
                    String s = getAttribute("SupportedKeyFormats");
                    if (s != null) {
                        this.supportedFormats = s.split("\\|");
                    }
                    String s2 = getAttribute("SupportedKeyClasses");
                    if (s2 != null) {
                        String[] classNames = s2.split("\\|");
                        List<Class> classList = new ArrayList<>(classNames.length);
                        for (String className2 : classNames) {
                            Class clazz = getKeyClass(className2);
                            if (clazz != null) {
                                classList.add(clazz);
                            }
                        }
                        this.supportedClasses = (Class[]) classList.toArray(CLASS0);
                    }
                    if (this.supportedFormats == null && this.supportedClasses == null) {
                        bool = false;
                    }
                    b = Boolean.valueOf(bool);
                    this.hasKeyAttributes = b;
                }
            }
            return b.booleanValue();
        }

        private Class getKeyClass(String name) {
            try {
                return Class.forName(name);
            } catch (ClassNotFoundException e) {
                try {
                    ClassLoader cl = this.provider.getClass().getClassLoader();
                    if (cl != null) {
                        return cl.loadClass(name);
                    }
                } catch (ClassNotFoundException e2) {
                }
                return null;
            }
        }

        private boolean supportsKeyFormat(Key key) {
            String format;
            if (this.supportedFormats == null || (format = key.getFormat()) == null) {
                return false;
            }
            for (String supportedFormat : this.supportedFormats) {
                if (supportedFormat.equals(format)) {
                    return true;
                }
            }
            return false;
        }

        private boolean supportsKeyClass(Key key) {
            if (this.supportedClasses == null) {
                return false;
            }
            Class keyClass = key.getClass();
            for (Class clazz : this.supportedClasses) {
                if (clazz.isAssignableFrom(keyClass)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return this.provider.getName() + ": " + this.type + "." + this.algorithm + " -> " + this.className + (this.aliases.isEmpty() ? "" : "\r\n  aliases: " + this.aliases.toString()) + (this.attributes.isEmpty() ? "" : "\r\n  attributes: " + this.attributes.toString()) + "\r\n";
        }
    }

    public void setRegistered() {
        this.registered = true;
    }

    public void setUnregistered() {
        this.registered = false;
    }

    public boolean isRegistered() {
        return this.registered;
    }

    public synchronized void warmUpServiceProvision() {
        checkInitialized();
        ensureLegacyParsed();
        getServices();
    }
}
