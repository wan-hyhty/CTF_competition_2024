package java.util.prefs;

import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
public abstract class AbstractPreferences extends Preferences {
    private static final AbstractPreferences[] EMPTY_ABSTRACT_PREFS_ARRAY = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static Thread eventDispatchThread;
    /* access modifiers changed from: private */
    public static final List<EventObject> eventQueue = null;
    private final String absolutePath;
    private Map<String, AbstractPreferences> kidCache;
    protected final Object lock;
    private final String name;
    protected boolean newNode;
    private final ArrayList<NodeChangeListener> nodeListeners;
    final AbstractPreferences parent;
    private final ArrayList<PreferenceChangeListener> prefListeners;
    private boolean removed;
    /* access modifiers changed from: private */
    public final AbstractPreferences root;

    private static class EventDispatchThread extends Thread {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.prefs.AbstractPreferences.EventDispatchThread.<init>():void, dex: classes.dex
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
        private EventDispatchThread() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.prefs.AbstractPreferences.EventDispatchThread.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.EventDispatchThread.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.prefs.AbstractPreferences.EventDispatchThread.<init>(java.util.prefs.AbstractPreferences$EventDispatchThread):void, dex: classes.dex
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
        /* synthetic */ EventDispatchThread(java.util.prefs.AbstractPreferences.EventDispatchThread r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.prefs.AbstractPreferences.EventDispatchThread.<init>(java.util.prefs.AbstractPreferences$EventDispatchThread):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.EventDispatchThread.<init>(java.util.prefs.AbstractPreferences$EventDispatchThread):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.AbstractPreferences.EventDispatchThread.run():void, dex: classes.dex
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
        public void run() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.AbstractPreferences.EventDispatchThread.run():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.EventDispatchThread.run():void");
        }
    }

    private class NodeAddedEvent extends NodeChangeEvent {
        private static final long serialVersionUID = -6743557530157328528L;
        final /* synthetic */ AbstractPreferences this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.AbstractPreferences.NodeAddedEvent.<init>(java.util.prefs.AbstractPreferences, java.util.prefs.Preferences, java.util.prefs.Preferences):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        NodeAddedEvent(java.util.prefs.AbstractPreferences r1, java.util.prefs.Preferences r2, java.util.prefs.Preferences r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.AbstractPreferences.NodeAddedEvent.<init>(java.util.prefs.AbstractPreferences, java.util.prefs.Preferences, java.util.prefs.Preferences):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.NodeAddedEvent.<init>(java.util.prefs.AbstractPreferences, java.util.prefs.Preferences, java.util.prefs.Preferences):void");
        }
    }

    private class NodeRemovedEvent extends NodeChangeEvent {
        private static final long serialVersionUID = 8735497392918824837L;
        final /* synthetic */ AbstractPreferences this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.AbstractPreferences.NodeRemovedEvent.<init>(java.util.prefs.AbstractPreferences, java.util.prefs.Preferences, java.util.prefs.Preferences):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        NodeRemovedEvent(java.util.prefs.AbstractPreferences r1, java.util.prefs.Preferences r2, java.util.prefs.Preferences r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.AbstractPreferences.NodeRemovedEvent.<init>(java.util.prefs.AbstractPreferences, java.util.prefs.Preferences, java.util.prefs.Preferences):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.NodeRemovedEvent.<init>(java.util.prefs.AbstractPreferences, java.util.prefs.Preferences, java.util.prefs.Preferences):void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.prefs.AbstractPreferences.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.prefs.AbstractPreferences.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.<clinit>():void");
    }

    /* access modifiers changed from: protected */
    public abstract AbstractPreferences childSpi(String str);

    /* access modifiers changed from: protected */
    public abstract String[] childrenNamesSpi() throws BackingStoreException;

    /* access modifiers changed from: protected */
    public abstract void flushSpi() throws BackingStoreException;

    /* access modifiers changed from: protected */
    public abstract String getSpi(String str);

    /* access modifiers changed from: protected */
    public abstract String[] keysSpi() throws BackingStoreException;

    /* access modifiers changed from: protected */
    public abstract void putSpi(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract void removeNodeSpi() throws BackingStoreException;

    /* access modifiers changed from: protected */
    public abstract void removeSpi(String str);

    /* access modifiers changed from: protected */
    public abstract void syncSpi() throws BackingStoreException;

    protected AbstractPreferences(AbstractPreferences parent2, String name2) {
        String str;
        this.newNode = false;
        this.kidCache = new HashMap();
        this.removed = false;
        this.prefListeners = new ArrayList<>();
        this.nodeListeners = new ArrayList<>();
        this.lock = new Object();
        if (parent2 == null) {
            if (!name2.equals("")) {
                throw new IllegalArgumentException("Root name '" + name2 + "' must be \"\"");
            }
            this.absolutePath = "/";
            this.root = this;
        } else if (name2.indexOf(47) != -1) {
            throw new IllegalArgumentException("Name '" + name2 + "' contains '/'");
        } else if (name2.equals("")) {
            throw new IllegalArgumentException("Illegal name: empty string");
        } else {
            this.root = parent2.root;
            if (parent2 == this.root) {
                str = "/" + name2;
            } else {
                str = parent2.absolutePath() + "/" + name2;
            }
            this.absolutePath = str;
        }
        this.name = name2;
        this.parent = parent2;
    }

    public void put(String key, String value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        } else if (key.length() > 80) {
            throw new IllegalArgumentException("Key too long: " + key);
        } else if (value.length() > 8192) {
            throw new IllegalArgumentException("Value too long: " + value);
        } else {
            synchronized (this.lock) {
                if (this.removed) {
                    throw new IllegalStateException("Node has been removed.");
                }
                putSpi(key, value);
                enqueuePreferenceChangeEvent(key, value);
            }
        }
    }

    public String get(String key, String def) {
        if (key == null) {
            throw new NullPointerException("Null key");
        }
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            String result = null;
            try {
                result = getSpi(key);
            } catch (Exception e) {
            }
            if (result != null) {
                def = result;
            }
        }
        return def;
    }

    public void remove(String key) {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            removeSpi(key);
            enqueuePreferenceChangeEvent(key, (String) null);
        }
    }

    public void clear() throws BackingStoreException {
        synchronized (this.lock) {
            String[] keys = keys();
            for (String remove : keys) {
                remove(remove);
            }
        }
    }

    public void putInt(String key, int value) {
        put(key, Integer.toString(value));
    }

    public int getInt(String key, int def) {
        int result = def;
        try {
            String value = get(key, (String) null);
            if (value != null) {
                return Integer.parseInt(value);
            }
            return result;
        } catch (NumberFormatException e) {
            return result;
        }
    }

    public void putLong(String key, long value) {
        put(key, Long.toString(value));
    }

    public long getLong(String key, long def) {
        long result = def;
        try {
            String value = get(key, (String) null);
            if (value != null) {
                return Long.parseLong(value);
            }
            return result;
        } catch (NumberFormatException e) {
            return result;
        }
    }

    public void putBoolean(String key, boolean value) {
        put(key, String.valueOf(value));
    }

    public boolean getBoolean(String key, boolean def) {
        boolean result = def;
        String value = get(key, (String) null);
        if (value == null) {
            return result;
        }
        if (value.equalsIgnoreCase("true")) {
            return true;
        }
        if (value.equalsIgnoreCase("false")) {
            return false;
        }
        return result;
    }

    public void putFloat(String key, float value) {
        put(key, Float.toString(value));
    }

    public float getFloat(String key, float def) {
        float result = def;
        try {
            String value = get(key, (String) null);
            if (value != null) {
                return Float.parseFloat(value);
            }
            return result;
        } catch (NumberFormatException e) {
            return result;
        }
    }

    public void putDouble(String key, double value) {
        put(key, Double.toString(value));
    }

    public double getDouble(String key, double def) {
        double result = def;
        try {
            String value = get(key, (String) null);
            if (value != null) {
                return Double.parseDouble(value);
            }
            return result;
        } catch (NumberFormatException e) {
            return result;
        }
    }

    public void putByteArray(String key, byte[] value) {
        put(key, Base64.byteArrayToBase64(value));
    }

    public byte[] getByteArray(String key, byte[] def) {
        byte[] result = def;
        String value = get(key, (String) null);
        if (value == null) {
            return result;
        }
        try {
            return Base64.base64ToByteArray(value);
        } catch (RuntimeException e) {
            return result;
        }
    }

    public String[] keys() throws BackingStoreException {
        String[] keysSpi;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            keysSpi = keysSpi();
        }
        return keysSpi;
    }

    public String[] childrenNames() throws BackingStoreException {
        String[] strArr;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            Set<String> s = new TreeSet<>(this.kidCache.keySet());
            for (String kid : childrenNamesSpi()) {
                s.add(kid);
            }
            strArr = (String[]) s.toArray(EMPTY_STRING_ARRAY);
        }
        return strArr;
    }

    /* access modifiers changed from: protected */
    public final AbstractPreferences[] cachedChildren() {
        return (AbstractPreferences[]) this.kidCache.values().toArray(EMPTY_ABSTRACT_PREFS_ARRAY);
    }

    public Preferences parent() {
        AbstractPreferences abstractPreferences;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            abstractPreferences = this.parent;
        }
        return abstractPreferences;
    }

    public Preferences node(String path) {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            } else if (path.equals("")) {
                return this;
            } else {
                if (path.equals("/")) {
                    AbstractPreferences abstractPreferences = this.root;
                    return abstractPreferences;
                } else if (path.charAt(0) == '/') {
                    return this.root.node(new StringTokenizer(path.substring(1), "/", true));
                } else {
                    Preferences node = node(new StringTokenizer(path, "/", true));
                    return node;
                }
            }
        }
    }

    private Preferences node(StringTokenizer path) {
        String token = path.nextToken();
        if (token.equals("/")) {
            throw new IllegalArgumentException("Consecutive slashes in path");
        }
        synchronized (this.lock) {
            AbstractPreferences child = this.kidCache.get(token);
            if (child == null) {
                if (token.length() > 80) {
                    throw new IllegalArgumentException("Node name " + token + " too long");
                }
                child = childSpi(token);
                if (child.newNode) {
                    enqueueNodeAddedEvent(child);
                }
                this.kidCache.put(token, child);
            }
            if (!path.hasMoreTokens()) {
                return child;
            }
            path.nextToken();
            if (!path.hasMoreTokens()) {
                throw new IllegalArgumentException("Path ends with slash");
            }
            Preferences node = child.node(path);
            return node;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean nodeExists(java.lang.String r6) throws java.util.prefs.BackingStoreException {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            java.lang.Object r2 = r5.lock
            monitor-enter(r2)
            java.lang.String r3 = ""
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r5.removed     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x0014
        L_0x0012:
            monitor-exit(r2)
            return r0
        L_0x0014:
            r0 = r1
            goto L_0x0012
        L_0x0016:
            boolean r0 = r5.removed     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0026
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "Node has been removed."
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x0023 }
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0026:
            java.lang.String r0 = "/"
            boolean r0 = r6.equals(r0)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0031
            monitor-exit(r2)
            return r1
        L_0x0031:
            r0 = 0
            char r0 = r6.charAt(r0)     // Catch:{ all -> 0x0023 }
            r3 = 47
            if (r0 == r3) goto L_0x0049
            java.util.StringTokenizer r0 = new java.util.StringTokenizer     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "/"
            r3 = 1
            r0.<init>(r6, r1, r3)     // Catch:{ all -> 0x0023 }
            boolean r0 = r5.nodeExists((java.util.StringTokenizer) r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return r0
        L_0x0049:
            monitor-exit(r2)
            java.util.prefs.AbstractPreferences r0 = r5.root
            java.util.StringTokenizer r2 = new java.util.StringTokenizer
            java.lang.String r3 = r6.substring(r1)
            java.lang.String r4 = "/"
            r2.<init>(r3, r4, r1)
            boolean r0 = r0.nodeExists((java.util.StringTokenizer) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.nodeExists(java.lang.String):boolean");
    }

    private boolean nodeExists(StringTokenizer path) throws BackingStoreException {
        String token = path.nextToken();
        if (token.equals("/")) {
            throw new IllegalArgumentException("Consecutive slashes in path");
        }
        synchronized (this.lock) {
            AbstractPreferences child = this.kidCache.get(token);
            if (child == null) {
                child = getChild(token);
            }
            if (child == null) {
                return false;
            }
            if (!path.hasMoreTokens()) {
                return true;
            }
            path.nextToken();
            if (!path.hasMoreTokens()) {
                throw new IllegalArgumentException("Path ends with slash");
            }
            boolean nodeExists = child.nodeExists(path);
            return nodeExists;
        }
    }

    public void removeNode() throws BackingStoreException {
        if (this == this.root) {
            throw new UnsupportedOperationException("Can't remove the root!");
        }
        synchronized (this.parent.lock) {
            removeNode2();
            this.parent.kidCache.remove(this.name);
        }
    }

    private void removeNode2() throws BackingStoreException {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node already removed.");
            }
            String[] kidNames = childrenNamesSpi();
            for (int i = 0; i < kidNames.length; i++) {
                if (!this.kidCache.containsKey(kidNames[i])) {
                    this.kidCache.put(kidNames[i], childSpi(kidNames[i]));
                }
            }
            Iterator<AbstractPreferences> i2 = this.kidCache.values().iterator();
            while (i2.hasNext()) {
                try {
                    i2.next().removeNode2();
                    i2.remove();
                } catch (BackingStoreException e) {
                }
            }
            removeNodeSpi();
            this.removed = true;
            this.parent.enqueueNodeRemovedEvent(this);
        }
    }

    public String name() {
        return this.name;
    }

    public String absolutePath() {
        return this.absolutePath;
    }

    public boolean isUserNode() {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>(this) {
            final /* synthetic */ AbstractPreferences this$0;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.AbstractPreferences.1.run():java.lang.Boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 5 more
                */
            public java.lang.Boolean run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.AbstractPreferences.1.run():java.lang.Boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.AnonymousClass1.run():java.lang.Boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.AbstractPreferences.1.run():java.lang.Object, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.AbstractPreferences.1.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.AnonymousClass1.run():java.lang.Object");
            }
        })).booleanValue();
    }

    public void addPreferenceChangeListener(PreferenceChangeListener pcl) {
        if (pcl == null) {
            throw new NullPointerException("Change listener is null.");
        }
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            this.prefListeners.add(pcl);
        }
        startEventDispatchThreadIfNecessary();
    }

    public void removePreferenceChangeListener(PreferenceChangeListener pcl) {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            } else if (!this.prefListeners.contains(pcl)) {
                throw new IllegalArgumentException("Listener not registered.");
            } else {
                this.prefListeners.remove((Object) pcl);
            }
        }
    }

    public void addNodeChangeListener(NodeChangeListener ncl) {
        if (ncl == null) {
            throw new NullPointerException("Change listener is null.");
        }
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            }
            this.nodeListeners.add(ncl);
        }
        startEventDispatchThreadIfNecessary();
    }

    public void removeNodeChangeListener(NodeChangeListener ncl) {
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed.");
            } else if (!this.nodeListeners.contains(ncl)) {
                throw new IllegalArgumentException("Listener not registered.");
            } else {
                this.nodeListeners.remove((Object) ncl);
            }
        }
    }

    /* access modifiers changed from: protected */
    public AbstractPreferences getChild(String nodeName) throws BackingStoreException {
        synchronized (this.lock) {
            String[] kidNames = childrenNames();
            for (int i = 0; i < kidNames.length; i++) {
                if (kidNames[i].equals(nodeName)) {
                    AbstractPreferences childSpi = childSpi(kidNames[i]);
                    return childSpi;
                }
            }
            return null;
        }
    }

    public String toString() {
        return (isUserNode() ? "User" : "System") + " Preference Node: " + absolutePath();
    }

    public void sync() throws BackingStoreException {
        sync2();
    }

    private void sync2() throws BackingStoreException {
        AbstractPreferences[] cachedKids;
        synchronized (this.lock) {
            if (this.removed) {
                throw new IllegalStateException("Node has been removed");
            }
            syncSpi();
            cachedKids = cachedChildren();
        }
        for (AbstractPreferences sync2 : cachedKids) {
            sync2.sync2();
        }
    }

    public void flush() throws BackingStoreException {
        flush2();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        if (r1 >= r0.length) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        r0[r1].flush2();
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flush2() throws java.util.prefs.BackingStoreException {
        /*
            r4 = this;
            java.lang.Object r3 = r4.lock
            monitor-enter(r3)
            r4.flushSpi()     // Catch:{ all -> 0x001d }
            boolean r2 = r4.removed     // Catch:{ all -> 0x001d }
            if (r2 == 0) goto L_0x000c
            monitor-exit(r3)
            return
        L_0x000c:
            java.util.prefs.AbstractPreferences[] r0 = r4.cachedChildren()     // Catch:{ all -> 0x001d }
            monitor-exit(r3)
            r1 = 0
        L_0x0012:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0020
            r2 = r0[r1]
            r2.flush2()
            int r1 = r1 + 1
            goto L_0x0012
        L_0x001d:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.AbstractPreferences.flush2():void");
    }

    /* access modifiers changed from: protected */
    public boolean isRemoved() {
        boolean z;
        synchronized (this.lock) {
            z = this.removed;
        }
        return z;
    }

    private static synchronized void startEventDispatchThreadIfNecessary() {
        synchronized (AbstractPreferences.class) {
            if (eventDispatchThread == null) {
                eventDispatchThread = new EventDispatchThread((EventDispatchThread) null);
                eventDispatchThread.setDaemon(true);
                eventDispatchThread.start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PreferenceChangeListener[] prefListeners() {
        PreferenceChangeListener[] preferenceChangeListenerArr;
        synchronized (this.lock) {
            preferenceChangeListenerArr = (PreferenceChangeListener[]) this.prefListeners.toArray(new PreferenceChangeListener[this.prefListeners.size()]);
        }
        return preferenceChangeListenerArr;
    }

    /* access modifiers changed from: package-private */
    public NodeChangeListener[] nodeListeners() {
        NodeChangeListener[] nodeChangeListenerArr;
        synchronized (this.lock) {
            nodeChangeListenerArr = (NodeChangeListener[]) this.nodeListeners.toArray(new NodeChangeListener[this.nodeListeners.size()]);
        }
        return nodeChangeListenerArr;
    }

    private void enqueuePreferenceChangeEvent(String key, String newValue) {
        if (!this.prefListeners.isEmpty()) {
            synchronized (eventQueue) {
                eventQueue.add(new PreferenceChangeEvent(this, key, newValue));
                eventQueue.notify();
            }
        }
    }

    private void enqueueNodeAddedEvent(Preferences child) {
        if (!this.nodeListeners.isEmpty()) {
            synchronized (eventQueue) {
                eventQueue.add(new NodeAddedEvent(this, this, child));
                eventQueue.notify();
            }
        }
    }

    private void enqueueNodeRemovedEvent(Preferences child) {
        if (!this.nodeListeners.isEmpty()) {
            synchronized (eventQueue) {
                eventQueue.add(new NodeRemovedEvent(this, this, child));
                eventQueue.notify();
            }
        }
    }

    public void exportNode(OutputStream os) throws IOException, BackingStoreException {
        XmlSupport.export(os, this, false);
    }

    public void exportSubtree(OutputStream os) throws IOException, BackingStoreException {
        XmlSupport.export(os, this, true);
    }
}
