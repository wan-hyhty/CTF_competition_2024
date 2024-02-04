package java.nio.charset;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.spi.CharsetProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedMap;
import sun.misc.VM;
import sun.nio.cs.ThreadLocalCoders;
import sun.security.action.GetPropertyAction;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ClassModifier.cleanInsnsInAnonymousConstructor(ClassModifier.java:334)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:60)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class Charset implements Comparable<Charset> {
    private static volatile String bugLevel;
    private static volatile Map.Entry<String, Charset> cache1;
    private static final HashMap<String, Charset> cache2 = null;
    private static Charset defaultCharset;
    private static ThreadLocal<ThreadLocal> gate;
    private Set<String> aliasSet;
    private final String[] aliases;
    private final String name;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.nio.charset.Charset.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.nio.charset.Charset.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.Charset.<clinit>():void");
    }

    public abstract boolean contains(Charset charset);

    public abstract CharsetDecoder newDecoder();

    public abstract CharsetEncoder newEncoder();

    static boolean atBugLevel(String bl) {
        String level = bugLevel;
        if (level == null) {
            if (!VM.isBooted()) {
                return false;
            }
            level = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.cs.bugLevel", ""));
            bugLevel = level;
        }
        return level.equals(bl);
    }

    private static void checkName(String s) {
        int n = s.length();
        if (atBugLevel("1.4") || n != 0) {
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && ((c < '0' || c > '9') && ((c != '-' || i == 0) && ((c != '+' || i == 0) && ((c != ':' || i == 0) && ((c != '_' || i == 0) && (c != '.' || i == 0)))))))) {
                    throw new IllegalCharsetNameException(s);
                }
            }
            return;
        }
        throw new IllegalCharsetNameException(s);
    }

    private static void cache(String charsetName, Charset cs) {
        synchronized (cache2) {
            String canonicalName = cs.name();
            Charset canonicalCharset = cache2.get(canonicalName);
            if (canonicalCharset != null) {
                cs = canonicalCharset;
            } else {
                cache2.put(canonicalName, cs);
                for (String alias : cs.aliases()) {
                    cache2.put(alias, cs);
                }
            }
            cache2.put(charsetName, cs);
        }
        cache1 = new AbstractMap.SimpleImmutableEntry(charsetName, cs);
    }

    /* access modifiers changed from: private */
    public static Iterator providers() {
        return new Iterator() {
            Iterator<CharsetProvider> i;
            Object next;
            ServiceLoader<CharsetProvider> sl;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.charset.Charset.1.getNext():boolean, dex: classes.dex
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
            private boolean getNext() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.charset.Charset.1.getNext():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.Charset.AnonymousClass1.getNext():boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.charset.Charset.1.next():java.lang.Object, dex: classes.dex
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
            public java.lang.Object next() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.charset.Charset.1.next():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.Charset.AnonymousClass1.next():java.lang.Object");
            }

            public boolean hasNext() {
                return getNext();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private static java.nio.charset.Charset lookupViaProviders(java.lang.String r3) {
        /*
            r2 = 0
            boolean r0 = sun.misc.VM.isBooted()
            if (r0 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.ThreadLocal<java.lang.ThreadLocal> r0 = gate
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x0011
            return r2
        L_0x0011:
            java.lang.ThreadLocal<java.lang.ThreadLocal> r0 = gate     // Catch:{ all -> 0x0029 }
            java.lang.ThreadLocal<java.lang.ThreadLocal> r1 = gate     // Catch:{ all -> 0x0029 }
            r0.set(r1)     // Catch:{ all -> 0x0029 }
            java.nio.charset.Charset$2 r0 = new java.nio.charset.Charset$2     // Catch:{ all -> 0x0029 }
            r0.<init>(r3)     // Catch:{ all -> 0x0029 }
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ all -> 0x0029 }
            java.nio.charset.Charset r0 = (java.nio.charset.Charset) r0     // Catch:{ all -> 0x0029 }
            java.lang.ThreadLocal<java.lang.ThreadLocal> r1 = gate
            r1.set(r2)
            return r0
        L_0x0029:
            r0 = move-exception
            java.lang.ThreadLocal<java.lang.ThreadLocal> r1 = gate
            r1.set(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.Charset.lookupViaProviders(java.lang.String):java.nio.charset.Charset");
    }

    private static Charset lookup(String charsetName) {
        if (charsetName == null) {
            throw new IllegalArgumentException("Null charset name");
        }
        Map.Entry<String, Charset> cached = cache1;
        if (cached == null || !charsetName.equals(cached.getKey())) {
            return lookup2(charsetName);
        }
        return cached.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r0 = lookupViaProviders(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r0 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        cache(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        checkName(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0 = libcore.icu.NativeConverter.charsetForName(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.charset.Charset lookup2(java.lang.String r4) {
        /*
            r3 = 0
            java.util.HashMap<java.lang.String, java.nio.charset.Charset> r2 = cache2
            monitor-enter(r2)
            java.util.HashMap<java.lang.String, java.nio.charset.Charset> r1 = cache2     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r1.get(r4)     // Catch:{ all -> 0x0028 }
            java.nio.charset.Charset r0 = (java.nio.charset.Charset) r0     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017
            java.util.AbstractMap$SimpleImmutableEntry r1 = new java.util.AbstractMap$SimpleImmutableEntry     // Catch:{ all -> 0x0028 }
            r1.<init>(r4, r0)     // Catch:{ all -> 0x0028 }
            cache1 = r1     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)
            return r0
        L_0x0017:
            monitor-exit(r2)
            java.nio.charset.Charset r0 = libcore.icu.NativeConverter.charsetForName(r4)
            if (r0 != 0) goto L_0x0024
            java.nio.charset.Charset r0 = lookupViaProviders(r4)
            if (r0 == 0) goto L_0x002b
        L_0x0024:
            cache(r4, r0)
            return r0
        L_0x0028:
            r1 = move-exception
            monitor-exit(r2)
            throw r1
        L_0x002b:
            checkName(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.Charset.lookup2(java.lang.String):java.nio.charset.Charset");
    }

    public static boolean isSupported(String charsetName) {
        return lookup(charsetName) != null;
    }

    public static Charset forName(String charsetName) {
        Charset cs = lookup(charsetName);
        if (cs != null) {
            return cs;
        }
        throw new UnsupportedCharsetException(charsetName);
    }

    public static Charset forNameUEE(String charsetName) throws UnsupportedEncodingException {
        try {
            return forName(charsetName);
        } catch (Exception cause) {
            UnsupportedEncodingException ex = new UnsupportedEncodingException(charsetName);
            ex.initCause(cause);
            throw ex;
        }
    }

    /* access modifiers changed from: private */
    public static void put(Iterator<Charset> i, Map<String, Charset> m) {
        while (i.hasNext()) {
            Charset cs = i.next();
            if (!m.containsKey(cs.name())) {
                m.put(cs.name(), cs);
            }
        }
    }

    public static SortedMap<String, Charset> availableCharsets() {
        return (SortedMap) AccessController.doPrivileged(new PrivilegedAction<SortedMap<String, Charset>>() {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.nio.charset.Charset.3.run():java.lang.Object, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.nio.charset.Charset.3.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.Charset.AnonymousClass3.run():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.nio.charset.Charset.3.run():java.util.SortedMap<java.lang.String, java.nio.charset.Charset>, dex: classes.dex
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
            public java.util.SortedMap<java.lang.String, java.nio.charset.Charset> run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.nio.charset.Charset.3.run():java.util.SortedMap<java.lang.String, java.nio.charset.Charset>, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.Charset.AnonymousClass3.run():java.util.SortedMap");
            }
        });
    }

    public static Charset defaultCharset() {
        Charset charset;
        synchronized (Charset.class) {
            if (defaultCharset == null) {
                defaultCharset = StandardCharsets.UTF_8;
            }
            charset = defaultCharset;
        }
        return charset;
    }

    protected Charset(String canonicalName, String[] aliases2) {
        this.aliasSet = null;
        checkName(canonicalName);
        String[] as = aliases2 == null ? new String[0] : aliases2;
        for (String checkName : as) {
            checkName(checkName);
        }
        this.name = canonicalName;
        this.aliases = as;
    }

    public final String name() {
        return this.name;
    }

    public final Set<String> aliases() {
        if (this.aliasSet != null) {
            return this.aliasSet;
        }
        HashSet<String> hs = new HashSet<>(n);
        for (String add : this.aliases) {
            hs.add(add);
        }
        this.aliasSet = Collections.unmodifiableSet(hs);
        return this.aliasSet;
    }

    public String displayName() {
        return this.name;
    }

    public final boolean isRegistered() {
        return !this.name.startsWith("X-") && !this.name.startsWith("x-");
    }

    public String displayName(Locale locale) {
        return this.name;
    }

    public boolean canEncode() {
        return true;
    }

    public final CharBuffer decode(ByteBuffer bb) {
        try {
            return ThreadLocalCoders.decoderFor(this).onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(bb);
        } catch (CharacterCodingException x) {
            throw new Error((Throwable) x);
        }
    }

    public final ByteBuffer encode(CharBuffer cb) {
        try {
            return ThreadLocalCoders.encoderFor(this).onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).encode(cb);
        } catch (CharacterCodingException x) {
            throw new Error((Throwable) x);
        }
    }

    public final ByteBuffer encode(String str) {
        return encode(CharBuffer.wrap((CharSequence) str));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object that) {
        return compareTo((Charset) that);
    }

    public final int compareTo(Charset that) {
        return name().compareToIgnoreCase(that.name());
    }

    public final int hashCode() {
        return name().hashCode();
    }

    public final boolean equals(Object ob) {
        if (!(ob instanceof Charset)) {
            return false;
        }
        if (this == ob) {
            return true;
        }
        return this.name.equals(((Charset) ob).name());
    }

    public final String toString() {
        return name();
    }
}
