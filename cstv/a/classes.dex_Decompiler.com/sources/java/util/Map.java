package java.util;

import java.io.Serializable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public interface Map<K, V> {
    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Set<Entry<K, V>> entrySet();

    boolean equals(Object obj);

    V get(Object obj);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    V put(K k, V v);

    void putAll(Map<? extends K, ? extends V> map);

    V remove(Object obj);

    int size();

    Collection<V> values();

    public interface Entry<K, V> {

        /* renamed from: java.util.Map$Entry$-java_util_Comparator_comparingByKey__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_util_Comparator_comparingByKey__LambdaImpl0 implements Comparator, Serializable {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Map.Entry.-java_util_Comparator_comparingByKey__LambdaImpl0.<init>():void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_util_Comparator_comparingByKey__LambdaImpl0() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Map.Entry.-java_util_Comparator_comparingByKey__LambdaImpl0.<init>():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Map.Entry.java_util_Comparator_comparingByKey__LambdaImpl0.<init>():void");
            }

            public int compare(Object arg0, Object arg1) {
                return ((Comparable) ((Entry) arg0).getKey()).compareTo(((Entry) arg1).getKey());
            }
        }

        /* renamed from: java.util.Map$Entry$-java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0 implements Comparator, Serializable {
            private /* synthetic */ Comparator val$cmp;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Map.Entry.-java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0(java.util.Comparator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Map.Entry.-java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Map.Entry.java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0.<init>(java.util.Comparator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Map.Entry.-java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0.compare(java.lang.Object, java.lang.Object):int, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public int compare(java.lang.Object r1, java.lang.Object r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Map.Entry.-java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0.compare(java.lang.Object, java.lang.Object):int, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Map.Entry.java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0.compare(java.lang.Object, java.lang.Object):int");
            }
        }

        /* renamed from: java.util.Map$Entry$-java_util_Comparator_comparingByValue__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_util_Comparator_comparingByValue__LambdaImpl0 implements Comparator, Serializable {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Map.Entry.-java_util_Comparator_comparingByValue__LambdaImpl0.<init>():void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_util_Comparator_comparingByValue__LambdaImpl0() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Map.Entry.-java_util_Comparator_comparingByValue__LambdaImpl0.<init>():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Map.Entry.java_util_Comparator_comparingByValue__LambdaImpl0.<init>():void");
            }

            public int compare(Object arg0, Object arg1) {
                return ((Comparable) ((Entry) arg0).getValue()).compareTo(((Entry) arg1).getValue());
            }
        }

        /* renamed from: java.util.Map$Entry$-java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0 implements Comparator, Serializable {
            private /* synthetic */ Comparator val$cmp;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Map.Entry.-java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public /* synthetic */ java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0(java.util.Comparator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Map.Entry.-java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0.<init>(java.util.Comparator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Map.Entry.java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0.<init>(java.util.Comparator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Map.Entry.-java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0.compare(java.lang.Object, java.lang.Object):int, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public int compare(java.lang.Object r1, java.lang.Object r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Map.Entry.-java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0.compare(java.lang.Object, java.lang.Object):int, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Map.Entry.java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0.compare(java.lang.Object, java.lang.Object):int");
            }
        }

        boolean equals(Object obj);

        K getKey();

        V getValue();

        int hashCode();

        V setValue(V v);

        /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<java.util.Map$Entry<K, V>>, java.io.Serializable] */
        static <K extends Comparable<? super K>, V> Comparator<Entry<K, V>> comparingByKey() {
            return new java_util_Comparator_comparingByKey__LambdaImpl0();
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<java.util.Map$Entry<K, V>>, java.io.Serializable] */
        static <K, V extends Comparable<? super V>> Comparator<Entry<K, V>> comparingByValue() {
            return new java_util_Comparator_comparingByValue__LambdaImpl0();
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<java.util.Map$Entry<K, V>>, java.io.Serializable] */
        static <K, V> Comparator<Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
            Objects.requireNonNull(cmp);
            return new java_util_Comparator_comparingByKey_java_util_Comparator_cmp_LambdaImpl0(cmp);
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Comparator<java.util.Map$Entry<K, V>>, java.io.Serializable] */
        static <K, V> Comparator<Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
            Objects.requireNonNull(cmp);
            return new java_util_Comparator_comparingByValue_java_util_Comparator_cmp_LambdaImpl0(cmp);
        }
    }

    V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        return (v != null || containsKey(key)) ? v : defaultValue;
    }

    void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Entry<K, V> entry : entrySet()) {
            try {
                action.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException ise) {
                throw new ConcurrentModificationException((Throwable) ise);
            }
        }
    }

    void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        for (Entry<K, V> entry : entrySet()) {
            try {
                try {
                    entry.setValue(function.apply(entry.getKey(), entry.getValue()));
                } catch (IllegalStateException ise) {
                    throw new ConcurrentModificationException((Throwable) ise);
                }
            } catch (IllegalStateException ise2) {
                throw new ConcurrentModificationException((Throwable) ise2);
            }
        }
    }

    V putIfAbsent(K key, V value) {
        V v = get(key);
        if (v == null) {
            return put(key, value);
        }
        return v;
    }

    boolean remove(Object key, Object value) {
        Object curValue = get(key);
        if (!Objects.equals(curValue, value)) {
            return false;
        }
        if (curValue == null && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    boolean replace(K key, V oldValue, V newValue) {
        Object curValue = get(key);
        if (!Objects.equals(curValue, oldValue)) {
            return false;
        }
        if (curValue == null && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    V replace(K key, V value) {
        V curValue = get(key);
        if (curValue != null || containsKey(key)) {
            return put(key, value);
        }
        return curValue;
    }

    V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        V newValue;
        Objects.requireNonNull(mappingFunction);
        V v = get(key);
        if (v != null || (newValue = mappingFunction.apply(key)) == null) {
            return v;
        }
        put(key, newValue);
        return newValue;
    }

    V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        if (oldValue == null) {
            return null;
        }
        V newValue = remappingFunction.apply(key, oldValue);
        if (newValue != null) {
            put(key, newValue);
            return newValue;
        }
        remove(key);
        return null;
    }

    V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        V newValue = remappingFunction.apply(key, oldValue);
        if (newValue != null) {
            put(key, newValue);
            return newValue;
        } else if (oldValue == null && !containsKey(key)) {
            return null;
        } else {
            remove(key);
            return null;
        }
    }

    V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        V newValue;
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = get(key);
        if (oldValue == null) {
            newValue = value;
        } else {
            newValue = remappingFunction.apply(oldValue, value);
        }
        if (newValue == null) {
            remove(key);
        } else {
            put(key, newValue);
        }
        return newValue;
    }
}
