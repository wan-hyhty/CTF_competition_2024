package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import sun.misc.Hashing;

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
public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final HashMapEntry<?, ?>[] EMPTY_TABLE = null;
    static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Map.Entry<K, V>> entrySet;
    final float loadFactor;
    transient int modCount;
    transient int size;
    transient HashMapEntry<K, V>[] table;
    int threshold;

    static final class EntrySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.EntrySpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
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
        EntrySpliterator(java.util.HashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.EntrySpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.EntrySpliterator.<init>(java.util.HashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.HashMap.EntrySpliterator.characteristics():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.HashMap.EntrySpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.EntrySpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.EntrySpliterator.trySplit():java.util.HashMap$EntrySpliterator<K, V>, dex: classes.dex
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
        public java.util.HashMap.EntrySpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.EntrySpliterator.trySplit():java.util.HashMap$EntrySpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.EntrySpliterator.trySplit():java.util.HashMap$EntrySpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.EntrySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.EntrySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.EntrySpliterator.trySplit():java.util.Spliterator");
        }
    }

    static class HashMapSpliterator<K, V> {
        HashMapEntry<K, V> current;
        int est;
        int expectedModCount;
        int fence;
        int index;
        final HashMap<K, V> map;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.HashMap.HashMapSpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
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
        HashMapSpliterator(java.util.HashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.HashMap.HashMapSpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.HashMapSpliterator.<init>(java.util.HashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.HashMapSpliterator.estimateSize():long, dex: classes.dex
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
        public final long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.HashMapSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.HashMapSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.HashMap.HashMapSpliterator.getFence():int, dex: classes.dex in method: java.util.HashMap.HashMapSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.HashMap.HashMapSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        final int getFence() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.HashMap.HashMapSpliterator.getFence():int, dex: classes.dex in method: java.util.HashMap.HashMapSpliterator.getFence():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.HashMapSpliterator.getFence():int");
        }
    }

    static final class KeySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<K> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.KeySpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
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
        KeySpliterator(java.util.HashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.KeySpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.KeySpliterator.<init>(java.util.HashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.HashMap.KeySpliterator.characteristics():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.HashMap.KeySpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.KeySpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super K> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super K> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.KeySpliterator.trySplit():java.util.HashMap$KeySpliterator<K, V>, dex: classes.dex
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
        public java.util.HashMap.KeySpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.KeySpliterator.trySplit():java.util.HashMap$KeySpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.KeySpliterator.trySplit():java.util.HashMap$KeySpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.KeySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.KeySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.KeySpliterator.trySplit():java.util.Spliterator");
        }
    }

    static final class ValueSpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<V> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.ValueSpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
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
        ValueSpliterator(java.util.HashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.ValueSpliterator.<init>(java.util.HashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.ValueSpliterator.<init>(java.util.HashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.HashMap.ValueSpliterator.characteristics():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.HashMap.ValueSpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.ValueSpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super V> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super V> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.HashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.ValueSpliterator.trySplit():java.util.HashMap$ValueSpliterator<K, V>, dex: classes.dex
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
        public java.util.HashMap.ValueSpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.ValueSpliterator.trySplit():java.util.HashMap$ValueSpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.ValueSpliterator.trySplit():java.util.HashMap$ValueSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.ValueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.HashMap.ValueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.ValueSpliterator.trySplit():java.util.Spliterator");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.HashMap.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.<clinit>():void");
    }

    public HashMap(int initialCapacity, float loadFactor2) {
        this.table = EMPTY_TABLE;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.entrySet = null;
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        } else if (initialCapacity < 4) {
            initialCapacity = 4;
        }
        if (loadFactor2 <= 0.0f || Float.isNaN(loadFactor2)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor2);
        }
        this.threshold = initialCapacity;
        init();
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap() {
        this(4, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(Map<? extends K, ? extends V> m) {
        this(Math.max(((int) (((float) m.size()) / DEFAULT_LOAD_FACTOR)) + 1, 4), DEFAULT_LOAD_FACTOR);
        inflateTable(this.threshold);
        putAllForCreate(m);
    }

    private static int roundUpToPowerOf2(int number) {
        if (number >= MAXIMUM_CAPACITY) {
            return MAXIMUM_CAPACITY;
        }
        int rounded = Integer.highestOneBit(number);
        if (rounded == 0) {
            return 1;
        }
        if (Integer.bitCount(number) > 1) {
            return rounded << 1;
        }
        return rounded;
    }

    private void inflateTable(int toSize) {
        int capacity = roundUpToPowerOf2(toSize);
        float thresholdFloat = ((float) capacity) * DEFAULT_LOAD_FACTOR;
        if (thresholdFloat > 1.07374182E9f) {
            thresholdFloat = 1.07374182E9f;
        }
        this.threshold = (int) thresholdFloat;
        this.table = new HashMapEntry[capacity];
    }

    /* access modifiers changed from: package-private */
    public void init() {
    }

    static int indexFor(int h, int length) {
        return (length - 1) & h;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public V get(Object key) {
        if (key == null) {
            return getForNullKey();
        }
        Map.Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    private V getForNullKey() {
        if (this.size == 0) {
            return null;
        }
        for (HashMapEntry<K, V> e = this.table[0]; e != null; e = e.next) {
            if (e.key == null) {
                return e.value;
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    /* access modifiers changed from: package-private */
    public final Map.Entry<K, V> getEntry(Object key) {
        Object k;
        if (this.size == 0) {
            return null;
        }
        int hash = key == null ? 0 : Hashing.singleWordWangJenkinsHash(key);
        for (HashMapEntry<K, V> e = this.table[indexFor(hash, this.table.length)]; e != null; e = e.next) {
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                return e;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        Object k;
        if (this.table == EMPTY_TABLE) {
            inflateTable(this.threshold);
        }
        if (key == null) {
            return putForNullKey(value);
        }
        int hash = Hashing.singleWordWangJenkinsHash(key);
        int i = indexFor(hash, this.table.length);
        HashMapEntry<K, V> e = this.table[i];
        while (e != null) {
            if (e.hash != hash || ((k = e.key) != key && !key.equals(k))) {
                e = e.next;
            } else {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        this.modCount++;
        addEntry(hash, key, value, i);
        return null;
    }

    private V putForNullKey(V value) {
        for (HashMapEntry<K, V> e = this.table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        this.modCount++;
        addEntry(0, (Object) null, value, 0);
        return null;
    }

    private void putForCreate(K key, V value) {
        Object k;
        int hash = key == null ? 0 : Hashing.singleWordWangJenkinsHash(key);
        int i = indexFor(hash, this.table.length);
        HashMapEntry<K, V> e = this.table[i];
        while (e != null) {
            if (e.hash != hash || ((k = e.key) != key && (key == null || !key.equals(k)))) {
                e = e.next;
            } else {
                e.value = value;
                return;
            }
        }
        createEntry(hash, key, value, i);
    }

    private void putAllForCreate(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            putForCreate(e.getKey(), e.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void resize(int newCapacity) {
        if (this.table.length == MAXIMUM_CAPACITY) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        HashMapEntry[] newTable = new HashMapEntry[newCapacity];
        transfer(newTable);
        this.table = newTable;
        this.threshold = (int) Math.min(((float) newCapacity) * DEFAULT_LOAD_FACTOR, 1.07374182E9f);
    }

    /* access modifiers changed from: package-private */
    public void transfer(HashMapEntry[] newTable) {
        int newCapacity = newTable.length;
        for (HashMapEntry<K, V> e : this.table) {
            while (e != null) {
                HashMapEntry<K, V> next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        int numKeysToBeAdded = m.size();
        if (numKeysToBeAdded != 0) {
            if (this.table == EMPTY_TABLE) {
                inflateTable((int) Math.max(((float) numKeysToBeAdded) * DEFAULT_LOAD_FACTOR, (float) this.threshold));
            }
            if (numKeysToBeAdded > this.threshold) {
                int targetCapacity = (int) ((((float) numKeysToBeAdded) / DEFAULT_LOAD_FACTOR) + 1.0f);
                if (targetCapacity > MAXIMUM_CAPACITY) {
                    targetCapacity = MAXIMUM_CAPACITY;
                }
                int newCapacity = this.table.length;
                while (newCapacity < targetCapacity) {
                    newCapacity <<= 1;
                }
                if (newCapacity > this.table.length) {
                    resize(newCapacity);
                }
            }
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                put(e.getKey(), e.getValue());
            }
        }
    }

    public V remove(Object key) {
        Map.Entry<K, V> e = removeEntryForKey(key);
        if (e == null) {
            return null;
        }
        return e.getValue();
    }

    /* access modifiers changed from: package-private */
    public final Map.Entry<K, V> removeEntryForKey(Object key) {
        Object k;
        if (this.size == 0) {
            return null;
        }
        int hash = key == null ? 0 : Hashing.singleWordWangJenkinsHash(key);
        int i = indexFor(hash, this.table.length);
        HashMapEntry<K, V> prev = this.table[i];
        HashMapEntry<K, V> e = prev;
        while (e != null) {
            HashMapEntry<K, V> next = e.next;
            if (e.hash != hash || ((k = e.key) != key && (key == null || !key.equals(k)))) {
                prev = e;
                e = next;
            } else {
                this.modCount++;
                this.size--;
                if (prev == e) {
                    this.table[i] = next;
                } else {
                    prev.next = next;
                }
                e.recordRemoval(this);
                return e;
            }
        }
        return e;
    }

    /* access modifiers changed from: package-private */
    public final Map.Entry<K, V> removeMapping(Object o) {
        if (this.size == 0 || !(o instanceof Map.Entry)) {
            return null;
        }
        Map.Entry<K, V> entry = (Map.Entry) o;
        Object key = entry.getKey();
        int hash = key == null ? 0 : Hashing.singleWordWangJenkinsHash(key);
        int i = indexFor(hash, this.table.length);
        HashMapEntry<K, V> prev = this.table[i];
        HashMapEntry<K, V> e = prev;
        while (e != null) {
            HashMapEntry<K, V> next = e.next;
            if (e.hash != hash || !e.equals(entry)) {
                prev = e;
                e = next;
            } else {
                this.modCount++;
                this.size--;
                if (prev == e) {
                    this.table[i] = next;
                } else {
                    prev.next = next;
                }
                e.recordRemoval(this);
                return e;
            }
        }
        return e;
    }

    public void clear() {
        this.modCount++;
        Arrays.fill((Object[]) this.table, (Object) null);
        this.size = 0;
    }

    public boolean containsValue(Object value) {
        if (value == null) {
            return containsNullValue();
        }
        HashMapEntry[] tab = this.table;
        for (HashMapEntry e : tab) {
            while (e != null) {
                if (value.equals(e.value)) {
                    return true;
                }
                e = e.next;
            }
        }
        return false;
    }

    private boolean containsNullValue() {
        HashMapEntry[] tab = this.table;
        for (HashMapEntry e : tab) {
            while (e != null) {
                if (e.value == null) {
                    return true;
                }
                e = e.next;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.HashMap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object clone() {
        /*
            r7 = this;
            r6 = 0
            r2 = 0
            java.lang.Object r3 = super.clone()     // Catch:{ CloneNotSupportedException -> 0x003c }
            r0 = r3
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ CloneNotSupportedException -> 0x003c }
            r2 = r0
        L_0x000a:
            java.util.HashMap$HashMapEntry<K, V>[] r3 = r2.table
            java.util.HashMap$HashMapEntry<?, ?>[] r4 = EMPTY_TABLE
            if (r3 == r4) goto L_0x002e
            int r3 = r7.size
            float r3 = (float) r3
            r4 = 1068149419(0x3faaaaab, float:1.3333334)
            r5 = 1082130432(0x40800000, float:4.0)
            float r4 = java.lang.Math.min((float) r4, (float) r5)
            float r3 = r3 * r4
            r4 = 1317011456(0x4e800000, float:1.07374182E9)
            float r3 = java.lang.Math.min((float) r3, (float) r4)
            int r3 = (int) r3
            java.util.HashMap$HashMapEntry<K, V>[] r4 = r7.table
            int r4 = r4.length
            int r3 = java.lang.Math.min((int) r3, (int) r4)
            r2.inflateTable(r3)
        L_0x002e:
            r3 = 0
            r2.entrySet = r3
            r2.modCount = r6
            r2.size = r6
            r2.init()
            r2.putAllForCreate(r7)
            return r2
        L_0x003c:
            r1 = move-exception
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.clone():java.lang.Object");
    }

    static class HashMapEntry<K, V> implements Map.Entry<K, V> {
        int hash;
        final K key;
        HashMapEntry<K, V> next;
        V value;

        HashMapEntry(int h, K k, V v, HashMapEntry<K, V> n) {
            this.value = v;
            this.next = n;
            this.key = k;
            this.hash = h;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2) {
                    return true;
                }
                if (v1 == null || !v1.equals(v2)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        /* access modifiers changed from: package-private */
        public void recordAccess(HashMap<K, V> hashMap) {
        }

        /* access modifiers changed from: package-private */
        public void recordRemoval(HashMap<K, V> hashMap) {
        }
    }

    /* access modifiers changed from: package-private */
    public void addEntry(int hash, K key, V value, int bucketIndex) {
        if (this.size >= this.threshold && this.table[bucketIndex] != null) {
            resize(this.table.length * 2);
            hash = key != null ? Hashing.singleWordWangJenkinsHash(key) : 0;
            bucketIndex = indexFor(hash, this.table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    /* access modifiers changed from: package-private */
    public void createEntry(int hash, K key, V value, int bucketIndex) {
        this.table[bucketIndex] = new HashMapEntry<>(hash, key, value, this.table[bucketIndex]);
        this.size++;
    }

    private abstract class HashIterator<E> implements Iterator<E> {
        HashMapEntry<K, V> current;
        int expectedModCount;
        int index;
        HashMapEntry<K, V> next;
        final /* synthetic */ HashMap this$0;

        HashIterator(HashMap this$02) {
            this.this$0 = this$02;
            this.expectedModCount = this$02.modCount;
            if (this$02.size > 0) {
                HashMapEntry[] t = this$02.table;
                while (this.index < t.length) {
                    int i = this.index;
                    this.index = i + 1;
                    HashMapEntry hashMapEntry = t[i];
                    this.next = hashMapEntry;
                    if (hashMapEntry != null) {
                        return;
                    }
                }
            }
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        /* access modifiers changed from: package-private */
        public final Map.Entry<K, V> nextEntry() {
            if (this.this$0.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            HashMapEntry<K, V> e = this.next;
            if (e == null) {
                throw new NoSuchElementException();
            }
            HashMapEntry<K, V> hashMapEntry = e.next;
            this.next = hashMapEntry;
            if (hashMapEntry == null) {
                HashMapEntry[] t = this.this$0.table;
                while (this.index < t.length) {
                    int i = this.index;
                    this.index = i + 1;
                    HashMapEntry hashMapEntry2 = t[i];
                    this.next = hashMapEntry2;
                    if (hashMapEntry2 != null) {
                        break;
                    }
                }
            }
            this.current = e;
            return e;
        }

        public void remove() {
            if (this.current == null) {
                throw new IllegalStateException();
            } else if (this.this$0.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                Object k = this.current.key;
                this.current = null;
                this.this$0.removeEntryForKey(k);
                this.expectedModCount = this.this$0.modCount;
            }
        }
    }

    private final class ValueIterator extends HashMap<K, V>.HashIterator<V> {
        final /* synthetic */ HashMap this$0;

        /* synthetic */ ValueIterator(HashMap this$02, ValueIterator valueIterator) {
            this(this$02);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private ValueIterator(HashMap this$02) {
            super(this$02);
            this.this$0 = this$02;
        }

        public V next() {
            return nextEntry().getValue();
        }
    }

    private final class KeyIterator extends HashMap<K, V>.HashIterator<K> {
        final /* synthetic */ HashMap this$0;

        /* synthetic */ KeyIterator(HashMap this$02, KeyIterator keyIterator) {
            this(this$02);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private KeyIterator(HashMap this$02) {
            super(this$02);
            this.this$0 = this$02;
        }

        public K next() {
            return nextEntry().getKey();
        }
    }

    private final class EntryIterator extends HashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        /* synthetic */ EntryIterator(HashMap this$02, EntryIterator entryIterator) {
            this();
        }

        private EntryIterator() {
            super(HashMap.this);
        }

        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> newKeyIterator() {
        return new KeyIterator(this, (KeyIterator) null);
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> newValueIterator() {
        return new ValueIterator(this, (ValueIterator) null);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator(this, (EntryIterator) null);
    }

    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        Set<K> ks2 = new KeySet(this, (KeySet) null);
        this.keySet = ks2;
        return ks2;
    }

    private final class KeySet extends AbstractSet<K> {
        final /* synthetic */ HashMap this$0;

        /* synthetic */ KeySet(HashMap this$02, KeySet keySet) {
            this(this$02);
        }

        private KeySet(HashMap this$02) {
            this.this$0 = this$02;
        }

        public Iterator<K> iterator() {
            return this.this$0.newKeyIterator();
        }

        public int size() {
            return this.this$0.size;
        }

        public boolean contains(Object o) {
            return this.this$0.containsKey(o);
        }

        public boolean remove(Object o) {
            return this.this$0.removeEntryForKey(o) != null;
        }

        public void clear() {
            this.this$0.clear();
        }

        public final Spliterator<K> spliterator() {
            return new KeySpliterator(this.this$0, 0, -1, 0, 0);
        }

        public final void forEach(Consumer<? super K> action) {
            HashMapEntry<K, V>[] tab;
            if (action == null) {
                throw new NullPointerException();
            } else if (this.this$0.size > 0 && (tab = this.this$0.table) != null) {
                int mc = this.this$0.modCount;
                for (HashMapEntry<K, V> e : tab) {
                    while (e != null) {
                        action.accept(e.key);
                        if (this.this$0.modCount != mc) {
                            throw new ConcurrentModificationException();
                        }
                        e = e.next;
                    }
                }
            }
        }
    }

    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        Collection<V> vs2 = new Values(this, (Values) null);
        this.values = vs2;
        return vs2;
    }

    private final class Values extends AbstractCollection<V> {
        final /* synthetic */ HashMap this$0;

        /* synthetic */ Values(HashMap this$02, Values values) {
            this(this$02);
        }

        private Values(HashMap this$02) {
            this.this$0 = this$02;
        }

        public Iterator<V> iterator() {
            return this.this$0.newValueIterator();
        }

        public int size() {
            return this.this$0.size;
        }

        public boolean contains(Object o) {
            return this.this$0.containsValue(o);
        }

        public void clear() {
            this.this$0.clear();
        }

        public final Spliterator<V> spliterator() {
            return new ValueSpliterator(this.this$0, 0, -1, 0, 0);
        }

        public final void forEach(Consumer<? super V> action) {
            HashMapEntry<K, V>[] tab;
            if (action == null) {
                throw new NullPointerException();
            } else if (this.this$0.size > 0 && (tab = this.this$0.table) != null) {
                int mc = this.this$0.modCount;
                for (HashMapEntry<K, V> e : tab) {
                    while (e != null) {
                        action.accept(e.value);
                        if (this.this$0.modCount != mc) {
                            throw new ConcurrentModificationException();
                        }
                        e = e.next;
                    }
                }
            }
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        Set<Map.Entry<K, V>> es2 = new EntrySet(this, (EntrySet) null);
        this.entrySet = es2;
        return es2;
    }

    private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        /* synthetic */ EntrySet(HashMap this$02, EntrySet entrySet) {
            this();
        }

        private EntrySet() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return HashMap.this.newEntryIterator();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<K, V> e = (Map.Entry) o;
            Map.Entry<K, V> candidate = HashMap.this.getEntry(e.getKey());
            if (candidate != null) {
                return candidate.equals(e);
            }
            return false;
        }

        public boolean remove(Object o) {
            return HashMap.this.removeMapping(o) != null;
        }

        public int size() {
            return HashMap.this.size;
        }

        public void clear() {
            HashMap.this.clear();
        }

        public final Spliterator<Map.Entry<K, V>> spliterator() {
            return new EntrySpliterator(HashMap.this, 0, -1, 0, 0);
        }

        public final void forEach(Consumer<? super Map.Entry<K, V>> action) {
            HashMapEntry<K, V>[] tab;
            if (action == null) {
                throw new NullPointerException();
            } else if (HashMap.this.size > 0 && (tab = HashMap.this.table) != null) {
                int mc = HashMap.this.modCount;
                for (HashMapEntry<K, V> e : tab) {
                    while (e != null) {
                        action.accept(e);
                        if (HashMap.this.modCount != mc) {
                            throw new ConcurrentModificationException();
                        }
                        e = e.next;
                    }
                }
            }
        }
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        HashMapEntry<K, V>[] tab;
        if (action == null) {
            throw new NullPointerException();
        } else if (this.size > 0 && (tab = this.table) != null) {
            int mc = this.modCount;
            for (HashMapEntry<K, V> e : tab) {
                while (e != null) {
                    action.accept(e.key, e.value);
                    if (this.modCount != mc) {
                        throw new ConcurrentModificationException();
                    }
                    e = e.next;
                }
            }
        }
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        HashMapEntry<K, V>[] tab;
        if (function == null) {
            throw new NullPointerException();
        } else if (this.size > 0 && (tab = this.table) != null) {
            int mc = this.modCount;
            for (HashMapEntry<K, V> e : tab) {
                while (e != null) {
                    e.value = function.apply(e.key, e.value);
                    e = e.next;
                }
            }
            if (this.modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        if (this.table == EMPTY_TABLE) {
            s.writeInt(roundUpToPowerOf2(this.threshold));
        } else {
            s.writeInt(this.table.length);
        }
        s.writeInt(this.size);
        if (this.size > 0) {
            for (Map.Entry<K, V> e : entrySet0()) {
                s.writeObject(e.getKey());
                s.writeObject(e.getValue());
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        if (Float.isNaN(DEFAULT_LOAD_FACTOR)) {
            throw new InvalidObjectException("Illegal load factor: 0.75");
        }
        this.table = EMPTY_TABLE;
        s.readInt();
        int mappings = s.readInt();
        if (mappings < 0) {
            throw new InvalidObjectException("Illegal mappings count: " + mappings);
        }
        int capacity = (int) Math.min(((float) mappings) * Math.min(1.3333334f, 4.0f), 1.07374182E9f);
        if (mappings > 0) {
            inflateTable(capacity);
        } else {
            this.threshold = capacity;
        }
        init();
        for (int i = 0; i < mappings; i++) {
            putForCreate(s.readObject(), s.readObject());
        }
    }

    public boolean replace(K key, V oldValue, V newValue) {
        HashMapEntry<K, V> e = (HashMapEntry) getEntry(key);
        if (e == null) {
            return false;
        }
        V v = e.value;
        if (v != oldValue && (v == null || !v.equals(oldValue))) {
            return false;
        }
        e.value = newValue;
        e.recordAccess(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public int capacity() {
        return this.table.length;
    }

    /* access modifiers changed from: package-private */
    public float loadFactor() {
        return DEFAULT_LOAD_FACTOR;
    }
}
