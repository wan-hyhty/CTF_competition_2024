package java.lang;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
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
final class ProcessEnvironment {
    static final int MIN_NAME_LENGTH = 0;
    private static final HashMap<Variable, Value> theEnvironment = null;
    private static final Map<String, String> theUnmodifiableEnvironment = null;

    private static class StringEntry implements Map.Entry<String, String> {
        private final Map.Entry<Variable, Value> e;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.-get0(java.lang.ProcessEnvironment$StringEntry):java.util.Map$Entry, dex: classes.dex
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
        /* renamed from: -get0 */
        static /* synthetic */ java.util.Map.Entry m68get0(java.lang.ProcessEnvironment.StringEntry r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.-get0(java.lang.ProcessEnvironment$StringEntry):java.util.Map$Entry, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.m68get0(java.lang.ProcessEnvironment$StringEntry):java.util.Map$Entry");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringEntry.<init>(java.util.Map$Entry):void, dex: classes.dex
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
        public StringEntry(java.util.Map.Entry<java.lang.ProcessEnvironment.Variable, java.lang.ProcessEnvironment.Value> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringEntry.<init>(java.util.Map$Entry):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.<init>(java.util.Map$Entry):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.equals(java.lang.Object):boolean, dex: classes.dex
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
        public boolean equals(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.equals(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.equals(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.getKey():java.lang.Object, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.lang.Object getKey() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.getKey():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.getKey():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.getKey():java.lang.String, dex: classes.dex
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
        public java.lang.String getKey() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.getKey():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.getKey():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.getValue():java.lang.Object, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.lang.Object getValue() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.getValue():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.getValue():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.getValue():java.lang.String, dex: classes.dex
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
        public java.lang.String getValue() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.getValue():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.getValue():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.hashCode():int, dex: classes.dex
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
        public int hashCode() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.hashCode():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.hashCode():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.setValue(java.lang.Object):java.lang.Object, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.lang.Object setValue(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.setValue(java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.setValue(java.lang.Object):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.setValue(java.lang.String):java.lang.String, dex: classes.dex
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
        public java.lang.String setValue(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntry.setValue(java.lang.String):java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.setValue(java.lang.String):java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.toString():java.lang.String, dex: classes.dex
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
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntry.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntry.toString():java.lang.String");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.<clinit>():void");
    }

    private static native byte[][] environ();

    static String getenv(String name) {
        return theUnmodifiableEnvironment.get(name);
    }

    static Map<String, String> getenv() {
        return theUnmodifiableEnvironment;
    }

    static Map<String, String> environment() {
        return new StringEnvironment((Map) theEnvironment.clone());
    }

    static Map<String, String> emptyEnvironment(int capacity) {
        return new StringEnvironment(new HashMap(capacity));
    }

    private ProcessEnvironment() {
    }

    /* access modifiers changed from: private */
    public static void validateVariable(String name) {
        if (name.indexOf(61) != -1 || name.indexOf(0) != -1) {
            throw new IllegalArgumentException("Invalid environment variable name: \"" + name + "\"");
        }
    }

    /* access modifiers changed from: private */
    public static void validateValue(String value) {
        if (value.indexOf(0) != -1) {
            throw new IllegalArgumentException("Invalid environment variable value: \"" + value + "\"");
        }
    }

    private static abstract class ExternalData {
        protected final byte[] bytes;
        protected final String str;

        protected ExternalData(String str2, byte[] bytes2) {
            this.str = str2;
            this.bytes = bytes2;
        }

        public byte[] getBytes() {
            return this.bytes;
        }

        public String toString() {
            return this.str;
        }

        public boolean equals(Object o) {
            if (o instanceof ExternalData) {
                return ProcessEnvironment.arrayEquals(getBytes(), ((ExternalData) o).getBytes());
            }
            return false;
        }

        public int hashCode() {
            return ProcessEnvironment.arrayHash(getBytes());
        }
    }

    private static class Variable extends ExternalData implements Comparable<Variable> {
        protected Variable(String str, byte[] bytes) {
            super(str, bytes);
        }

        public static Variable valueOfQueryOnly(Object str) {
            return valueOfQueryOnly((String) str);
        }

        public static Variable valueOfQueryOnly(String str) {
            return new Variable(str, str.getBytes());
        }

        public static Variable valueOf(String str) {
            ProcessEnvironment.validateVariable(str);
            return valueOfQueryOnly(str);
        }

        public static Variable valueOf(byte[] bytes) {
            return new Variable(new String(bytes), bytes);
        }

        public /* bridge */ /* synthetic */ int compareTo(Object variable) {
            return compareTo((Variable) variable);
        }

        public int compareTo(Variable variable) {
            return ProcessEnvironment.arrayCompare(getBytes(), variable.getBytes());
        }

        public boolean equals(Object o) {
            if (o instanceof Variable) {
                return super.equals(o);
            }
            return false;
        }
    }

    private static class Value extends ExternalData implements Comparable<Value> {
        protected Value(String str, byte[] bytes) {
            super(str, bytes);
        }

        public static Value valueOfQueryOnly(Object str) {
            return valueOfQueryOnly((String) str);
        }

        public static Value valueOfQueryOnly(String str) {
            return new Value(str, str.getBytes());
        }

        public static Value valueOf(String str) {
            ProcessEnvironment.validateValue(str);
            return valueOfQueryOnly(str);
        }

        public static Value valueOf(byte[] bytes) {
            return new Value(new String(bytes), bytes);
        }

        public /* bridge */ /* synthetic */ int compareTo(Object value) {
            return compareTo((Value) value);
        }

        public int compareTo(Value value) {
            return ProcessEnvironment.arrayCompare(getBytes(), value.getBytes());
        }

        public boolean equals(Object o) {
            if (o instanceof Value) {
                return super.equals(o);
            }
            return false;
        }
    }

    private static class StringEnvironment extends AbstractMap<String, String> {
        private Map<Variable, Value> m;

        private static String toString(Value v) {
            if (v == null) {
                return null;
            }
            return v.toString();
        }

        public StringEnvironment(Map<Variable, Value> m2) {
            this.m = m2;
        }

        public int size() {
            return this.m.size();
        }

        public boolean isEmpty() {
            return this.m.isEmpty();
        }

        public void clear() {
            this.m.clear();
        }

        public boolean containsKey(Object key) {
            return this.m.containsKey(Variable.valueOfQueryOnly(key));
        }

        public boolean containsValue(Object value) {
            return this.m.containsValue(Value.valueOfQueryOnly(value));
        }

        public /* bridge */ /* synthetic */ Object get(Object key) {
            return get(key);
        }

        public String get(Object key) {
            return toString(this.m.get(Variable.valueOfQueryOnly(key)));
        }

        public /* bridge */ /* synthetic */ Object put(Object key, Object value) {
            return put((String) key, (String) value);
        }

        public String put(String key, String value) {
            return toString(this.m.put(Variable.valueOf(key), Value.valueOf(value)));
        }

        public /* bridge */ /* synthetic */ Object remove(Object key) {
            return remove(key);
        }

        public String remove(Object key) {
            return toString(this.m.remove(Variable.valueOfQueryOnly(key)));
        }

        public Set<String> keySet() {
            return new StringKeySet(this.m.keySet());
        }

        public Set<Map.Entry<String, String>> entrySet() {
            return new StringEntrySet(this.m.entrySet());
        }

        public Collection<String> values() {
            return new StringValues(this.m.values());
        }

        public byte[] toEnvironmentBlock(int[] envc) {
            int count = this.m.size() * 2;
            for (Map.Entry<Variable, Value> entry : this.m.entrySet()) {
                count = count + entry.getKey().getBytes().length + entry.getValue().getBytes().length;
            }
            byte[] block = new byte[count];
            int i = 0;
            for (Map.Entry<Variable, Value> entry2 : this.m.entrySet()) {
                byte[] key = entry2.getKey().getBytes();
                byte[] value = entry2.getValue().getBytes();
                System.arraycopy(key, 0, block, i, key.length);
                int i2 = i + key.length;
                int i3 = i2 + 1;
                block[i2] = 61;
                System.arraycopy(value, 0, block, i3, value.length);
                i = i3 + value.length + 1;
            }
            envc[0] = this.m.size();
            return block;
        }
    }

    static byte[] toEnvironmentBlock(Map<String, String> map, int[] envc) {
        if (map == null) {
            return null;
        }
        return ((StringEnvironment) map).toEnvironmentBlock(envc);
    }

    private static class StringEntrySet extends AbstractSet<Map.Entry<String, String>> {
        private final Set<Map.Entry<Variable, Value>> s;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.-get0(java.lang.ProcessEnvironment$StringEntrySet):java.util.Set, dex: classes.dex
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
        /* renamed from: -get0 */
        static /* synthetic */ java.util.Set m69get0(java.lang.ProcessEnvironment.StringEntrySet r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.-get0(java.lang.ProcessEnvironment$StringEntrySet):java.util.Set, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.m69get0(java.lang.ProcessEnvironment$StringEntrySet):java.util.Set");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringEntrySet.<init>(java.util.Set):void, dex: classes.dex
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
        public StringEntrySet(java.util.Set<java.util.Map.Entry<java.lang.ProcessEnvironment.Variable, java.lang.ProcessEnvironment.Value>> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringEntrySet.<init>(java.util.Set):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.<init>(java.util.Set):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.clear():void, dex: classes.dex
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
        public void clear() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.clear():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.clear():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.contains(java.lang.Object):boolean, dex: classes.dex
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
        public boolean contains(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.contains(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.contains(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.equals(java.lang.Object):boolean, dex: classes.dex
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
        public boolean equals(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.equals(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.equals(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.hashCode():int, dex: classes.dex
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
        public int hashCode() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.hashCode():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.hashCode():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.isEmpty():boolean, dex: classes.dex
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
        public boolean isEmpty() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.isEmpty():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.isEmpty():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.remove(java.lang.Object):boolean, dex: classes.dex
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
        public boolean remove(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.remove(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.remove(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.size():int, dex: classes.dex
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
        public int size() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.size():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.size():int");
        }

        public Iterator<Map.Entry<String, String>> iterator() {
            return new Iterator<Map.Entry<String, String>>(this) {
                Iterator<Map.Entry<Variable, Value>> i;
                final /* synthetic */ StringEntrySet this$1;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.1.hasNext():boolean, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public boolean hasNext() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.1.hasNext():boolean, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.AnonymousClass1.hasNext():boolean");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntrySet.1.next():java.lang.Object, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public /* bridge */ /* synthetic */ java.lang.Object next() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringEntrySet.1.next():java.lang.Object, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.AnonymousClass1.next():java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.1.next():java.util.Map$Entry<java.lang.String, java.lang.String>, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public java.util.Map.Entry<java.lang.String, java.lang.String> next() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.1.next():java.util.Map$Entry<java.lang.String, java.lang.String>, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.AnonymousClass1.next():java.util.Map$Entry");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.1.remove():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public void remove() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringEntrySet.1.remove():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.AnonymousClass1.remove():void");
                }
            };
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, java.lang.ProcessEnvironment$StringEntry] */
        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        private static java.util.Map.Entry<java.lang.ProcessEnvironment.Variable, java.lang.ProcessEnvironment.Value> vvEntry(java.lang.Object r1) {
            /*
                boolean r0 = r1 instanceof java.lang.ProcessEnvironment.StringEntry
                if (r0 == 0) goto L_0x000b
                java.util.Map$Entry r0 = java.lang.ProcessEnvironment.StringEntry.m68get0(r1)
                return r0
            L_0x000b:
                java.lang.ProcessEnvironment$StringEntrySet$2 r0 = new java.lang.ProcessEnvironment$StringEntrySet$2
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringEntrySet.vvEntry(java.lang.Object):java.util.Map$Entry");
        }
    }

    private static class StringValues extends AbstractCollection<String> {
        private final Collection<Value> c;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.-get0(java.lang.ProcessEnvironment$StringValues):java.util.Collection, dex: classes.dex
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
        /* renamed from: -get0 */
        static /* synthetic */ java.util.Collection m71get0(java.lang.ProcessEnvironment.StringValues r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.-get0(java.lang.ProcessEnvironment$StringValues):java.util.Collection, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.m71get0(java.lang.ProcessEnvironment$StringValues):java.util.Collection");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringValues.<init>(java.util.Collection):void, dex: classes.dex
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
        public StringValues(java.util.Collection<java.lang.ProcessEnvironment.Value> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringValues.<init>(java.util.Collection):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.<init>(java.util.Collection):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.clear():void, dex: classes.dex
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
        public void clear() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.clear():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.clear():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.contains(java.lang.Object):boolean, dex: classes.dex
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
        public boolean contains(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.contains(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.contains(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.equals(java.lang.Object):boolean, dex: classes.dex
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
        public boolean equals(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.equals(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.equals(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.hashCode():int, dex: classes.dex
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
        public int hashCode() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.hashCode():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.hashCode():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.isEmpty():boolean, dex: classes.dex
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
        public boolean isEmpty() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.isEmpty():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.isEmpty():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.remove(java.lang.Object):boolean, dex: classes.dex
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
        public boolean remove(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.remove(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.remove(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.size():int, dex: classes.dex
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
        public int size() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.size():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.size():int");
        }

        public Iterator<String> iterator() {
            return new Iterator<String>(this) {
                Iterator<Value> i;
                final /* synthetic */ StringValues this$1;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.1.hasNext():boolean, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public boolean hasNext() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.1.hasNext():boolean, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.AnonymousClass1.hasNext():boolean");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringValues.1.next():java.lang.Object, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public /* bridge */ /* synthetic */ java.lang.Object next() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringValues.1.next():java.lang.Object, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.AnonymousClass1.next():java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.1.next():java.lang.String, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public java.lang.String next() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.1.next():java.lang.String, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.AnonymousClass1.next():java.lang.String");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.1.remove():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public void remove() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringValues.1.remove():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringValues.AnonymousClass1.remove():void");
                }
            };
        }
    }

    private static class StringKeySet extends AbstractSet<String> {
        private final Set<Variable> s;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.-get0(java.lang.ProcessEnvironment$StringKeySet):java.util.Set, dex: classes.dex
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
        /* renamed from: -get0 */
        static /* synthetic */ java.util.Set m70get0(java.lang.ProcessEnvironment.StringKeySet r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.-get0(java.lang.ProcessEnvironment$StringKeySet):java.util.Set, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.m70get0(java.lang.ProcessEnvironment$StringKeySet):java.util.Set");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringKeySet.<init>(java.util.Set):void, dex: classes.dex
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
        public StringKeySet(java.util.Set<java.lang.ProcessEnvironment.Variable> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.lang.ProcessEnvironment.StringKeySet.<init>(java.util.Set):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.<init>(java.util.Set):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.clear():void, dex: classes.dex
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
        public void clear() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.clear():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.clear():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.contains(java.lang.Object):boolean, dex: classes.dex
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
        public boolean contains(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.contains(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.contains(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.isEmpty():boolean, dex: classes.dex
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
        public boolean isEmpty() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.isEmpty():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.isEmpty():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.remove(java.lang.Object):boolean, dex: classes.dex
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
        public boolean remove(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.remove(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.remove(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.size():int, dex: classes.dex
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
        public int size() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.size():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.size():int");
        }

        public Iterator<String> iterator() {
            return new Iterator<String>(this) {
                Iterator<Variable> i;
                final /* synthetic */ StringKeySet this$1;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.1.hasNext():boolean, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public boolean hasNext() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.1.hasNext():boolean, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.AnonymousClass1.hasNext():boolean");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringKeySet.1.next():java.lang.Object, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public /* bridge */ /* synthetic */ java.lang.Object next() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessEnvironment.StringKeySet.1.next():java.lang.Object, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.AnonymousClass1.next():java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.1.next():java.lang.String, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public java.lang.String next() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.1.next():java.lang.String, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.AnonymousClass1.next():java.lang.String");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.1.remove():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 6 more
                    */
                public void remove() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.ProcessEnvironment.StringKeySet.1.remove():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessEnvironment.StringKeySet.AnonymousClass1.remove():void");
                }
            };
        }
    }

    /* access modifiers changed from: private */
    public static int arrayCompare(byte[] x, byte[] y) {
        int min = x.length < y.length ? x.length : y.length;
        for (int i = 0; i < min; i++) {
            if (x[i] != y[i]) {
                return x[i] - y[i];
            }
        }
        return x.length - y.length;
    }

    /* access modifiers changed from: private */
    public static boolean arrayEquals(byte[] x, byte[] y) {
        if (x.length != y.length) {
            return false;
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i]) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int arrayHash(byte[] x) {
        int hash = 0;
        for (byte b : x) {
            hash = (hash * 31) + b;
        }
        return hash;
    }
}
