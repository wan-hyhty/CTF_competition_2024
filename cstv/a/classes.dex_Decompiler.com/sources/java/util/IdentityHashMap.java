package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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
public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable, Cloneable {
    private static final int DEFAULT_CAPACITY = 32;
    private static final int MAXIMUM_CAPACITY = 536870912;
    private static final int MINIMUM_CAPACITY = 4;
    private static final Object NULL_KEY = null;
    private static final long serialVersionUID = 8188218128353913216L;
    private transient Set<Map.Entry<K, V>> entrySet;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public int size;
    /* access modifiers changed from: private */
    public transient Object[] table;
    private transient int threshold;

    static final class EntrySpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.EntrySpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
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
        EntrySpliterator(java.util.IdentityHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.EntrySpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.EntrySpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.IdentityHashMap.EntrySpliterator.characteristics():int, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.IdentityHashMap.EntrySpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.EntrySpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.IdentityHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex in method: java.util.IdentityHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.IdentityHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$35.decode(InstructionCodec.java:790)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public void forEachRemaining(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.IdentityHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex in method: java.util.IdentityHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.EntrySpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.EntrySpliterator.trySplit():java.util.IdentityHashMap$EntrySpliterator<K, V>, dex: classes.dex
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
        public java.util.IdentityHashMap.EntrySpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.EntrySpliterator.trySplit():java.util.IdentityHashMap$EntrySpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.EntrySpliterator.trySplit():java.util.IdentityHashMap$EntrySpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.EntrySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.EntrySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.EntrySpliterator.trySplit():java.util.Spliterator");
        }
    }

    static class IdentityHashMapSpliterator<K, V> {
        int est;
        int expectedModCount;
        int fence;
        int index;
        final IdentityHashMap<K, V> map;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
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
        IdentityHashMapSpliterator(java.util.IdentityHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.IdentityHashMapSpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.estimateSize():long, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.IdentityHashMapSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.getFence():int, dex: classes.dex in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.getFence():int, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        final int getFence() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.getFence():int, dex: classes.dex in method: java.util.IdentityHashMap.IdentityHashMapSpliterator.getFence():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.IdentityHashMapSpliterator.getFence():int");
        }
    }

    static final class KeySpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<K> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.KeySpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
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
        KeySpliterator(java.util.IdentityHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.KeySpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.KeySpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.IdentityHashMap.KeySpliterator.characteristics():int, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.IdentityHashMap.KeySpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.KeySpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.KeySpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.KeySpliterator.trySplit():java.util.IdentityHashMap$KeySpliterator<K, V>, dex: classes.dex
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
        public java.util.IdentityHashMap.KeySpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.KeySpliterator.trySplit():java.util.IdentityHashMap$KeySpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.KeySpliterator.trySplit():java.util.IdentityHashMap$KeySpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.KeySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.KeySpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.KeySpliterator.trySplit():java.util.Spliterator");
        }
    }

    static final class ValueSpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<V> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.ValueSpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
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
        ValueSpliterator(java.util.IdentityHashMap<K, V> r1, int r2, int r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.ValueSpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.ValueSpliterator.<init>(java.util.IdentityHashMap, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.IdentityHashMap.ValueSpliterator.characteristics():int, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.IdentityHashMap.ValueSpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.ValueSpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.ValueSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.IdentityHashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.ValueSpliterator.trySplit():java.util.IdentityHashMap$ValueSpliterator<K, V>, dex: classes.dex
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
        public java.util.IdentityHashMap.ValueSpliterator<K, V> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.ValueSpliterator.trySplit():java.util.IdentityHashMap$ValueSpliterator<K, V>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.ValueSpliterator.trySplit():java.util.IdentityHashMap$ValueSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.ValueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.IdentityHashMap.ValueSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.ValueSpliterator.trySplit():java.util.Spliterator");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.IdentityHashMap.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.<clinit>():void");
    }

    private static Object maskNull(Object key) {
        return key == null ? NULL_KEY : key;
    }

    /* access modifiers changed from: private */
    public static Object unmaskNull(Object key) {
        if (key == NULL_KEY) {
            return null;
        }
        return key;
    }

    public IdentityHashMap() {
        this.entrySet = null;
        init(32);
    }

    public IdentityHashMap(int expectedMaxSize) {
        this.entrySet = null;
        if (expectedMaxSize < 0) {
            throw new IllegalArgumentException("expectedMaxSize is negative: " + expectedMaxSize);
        }
        init(capacity(expectedMaxSize));
    }

    private int capacity(int expectedMaxSize) {
        int minCapacity = (expectedMaxSize * 3) / 2;
        if (minCapacity > MAXIMUM_CAPACITY || minCapacity < 0) {
            return MAXIMUM_CAPACITY;
        }
        int result = 4;
        while (result < minCapacity) {
            result <<= 1;
        }
        return result;
    }

    private void init(int initCapacity) {
        this.threshold = (initCapacity * 2) / 3;
        this.table = new Object[(initCapacity * 2)];
    }

    public IdentityHashMap(Map<? extends K, ? extends V> m) {
        this((int) (((double) (m.size() + 1)) * 1.1d));
        putAll(m);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: private */
    public static int hash(Object x, int length) {
        int h = System.identityHashCode(x);
        return ((h << 1) - (h << 8)) & (length - 1);
    }

    /* access modifiers changed from: private */
    public static int nextKeyIndex(int i, int len) {
        if (i + 2 < len) {
            return i + 2;
        }
        return 0;
    }

    public V get(Object key) {
        Object k = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == k) {
                return tab[i + 1];
            }
            if (item == null) {
                return null;
            }
            i = nextKeyIndex(i, len);
        }
    }

    public boolean containsKey(Object key) {
        Object k = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == k) {
                return true;
            }
            if (item == null) {
                return false;
            }
            i = nextKeyIndex(i, len);
        }
    }

    public boolean containsValue(Object value) {
        Object[] tab = this.table;
        for (int i = 1; i < tab.length; i += 2) {
            if (tab[i] == value && tab[i - 1] != null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean containsMapping(Object key, Object value) {
        Object k = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == k) {
                if (tab[i + 1] == value) {
                    return true;
                }
                return false;
            } else if (item == null) {
                return false;
            } else {
                i = nextKeyIndex(i, len);
            }
        }
    }

    public V put(K key, V value) {
        V k = maskNull(key);
        V[] tab = this.table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            V item = tab[i];
            if (item == null) {
                this.modCount++;
                tab[i] = k;
                tab[i + 1] = value;
                int i2 = this.size + 1;
                this.size = i2;
                if (i2 >= this.threshold) {
                    resize(len);
                }
                return null;
            } else if (item == k) {
                V oldValue = tab[i + 1];
                tab[i + 1] = value;
                return oldValue;
            } else {
                i = nextKeyIndex(i, len);
            }
        }
    }

    private void resize(int newCapacity) {
        int newLength = newCapacity * 2;
        Object[] oldTable = this.table;
        int oldLength = oldTable.length;
        if (oldLength == 1073741824) {
            if (this.threshold == 536870911) {
                throw new IllegalStateException("Capacity exhausted.");
            }
            this.threshold = 536870911;
        } else if (oldLength < newLength) {
            Object[] newTable = new Object[newLength];
            this.threshold = newLength / 3;
            for (int j = 0; j < oldLength; j += 2) {
                Object key = oldTable[j];
                if (key != null) {
                    Object value = oldTable[j + 1];
                    oldTable[j] = null;
                    oldTable[j + 1] = null;
                    int i = hash(key, newLength);
                    while (newTable[i] != null) {
                        i = nextKeyIndex(i, newLength);
                    }
                    newTable[i] = key;
                    newTable[i + 1] = value;
                }
            }
            this.table = newTable;
        }
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        int n = m.size();
        if (n != 0) {
            if (n > this.threshold) {
                resize(capacity(n));
            }
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                put(e.getKey(), e.getValue());
            }
        }
    }

    public V remove(Object key) {
        V k = maskNull(key);
        V[] tab = this.table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            V item = tab[i];
            if (item == k) {
                this.modCount++;
                this.size--;
                V oldValue = tab[i + 1];
                tab[i + 1] = null;
                tab[i] = null;
                closeDeletion(i);
                return oldValue;
            } else if (item == null) {
                return null;
            } else {
                i = nextKeyIndex(i, len);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean removeMapping(Object key, Object value) {
        Object k = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == k) {
                if (tab[i + 1] != value) {
                    return false;
                }
                this.modCount++;
                this.size--;
                tab[i] = null;
                tab[i + 1] = null;
                closeDeletion(i);
                return true;
            } else if (item == null) {
                return false;
            } else {
                i = nextKeyIndex(i, len);
            }
        }
    }

    private void closeDeletion(int d) {
        Object[] tab = this.table;
        int len = tab.length;
        int i = nextKeyIndex(d, len);
        while (true) {
            Object item = tab[i];
            if (item != null) {
                int r = hash(item, len);
                if ((i < r && (r <= d || d <= i)) || (r <= d && d <= i)) {
                    tab[d] = item;
                    tab[d + 1] = tab[i + 1];
                    tab[i] = null;
                    tab[i + 1] = null;
                    d = i;
                }
                i = nextKeyIndex(i, len);
            } else {
                return;
            }
        }
    }

    public void clear() {
        this.modCount++;
        Object[] tab = this.table;
        for (int i = 0; i < tab.length; i++) {
            tab[i] = null;
        }
        this.size = 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof IdentityHashMap) {
            IdentityHashMap<?, ?> m = (IdentityHashMap) o;
            if (m.size() != this.size) {
                return false;
            }
            Object[] tab = m.table;
            for (int i = 0; i < tab.length; i += 2) {
                Object k = tab[i];
                if (k != null && !containsMapping(k, tab[i + 1])) {
                    return false;
                }
            }
            return true;
        } else if (o instanceof Map) {
            return entrySet().equals(((Map) o).entrySet());
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = 0;
        Object[] tab = this.table;
        for (int i = 0; i < tab.length; i += 2) {
            Object key = tab[i];
            if (key != null) {
                result += System.identityHashCode(unmaskNull(key)) ^ System.identityHashCode(tab[i + 1]);
            }
        }
        return result;
    }

    public Object clone() {
        try {
            IdentityHashMap<?, ?> m = (IdentityHashMap) super.clone();
            m.entrySet = null;
            m.table = (Object[]) this.table.clone();
            return m;
        } catch (CloneNotSupportedException e) {
            throw new InternalError((Throwable) e);
        }
    }

    private abstract class IdentityHashMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        int index;
        boolean indexValid;
        int lastReturnedIndex;
        final /* synthetic */ IdentityHashMap this$0;
        Object[] traversalTable;

        /* synthetic */ IdentityHashMapIterator(IdentityHashMap this$02, IdentityHashMapIterator identityHashMapIterator) {
            this(this$02);
        }

        private IdentityHashMapIterator(IdentityHashMap this$02) {
            int i = 0;
            this.this$0 = this$02;
            this.index = this.this$0.size == 0 ? this.this$0.table.length : i;
            this.expectedModCount = this.this$0.modCount;
            this.lastReturnedIndex = -1;
            this.traversalTable = this.this$0.table;
        }

        public boolean hasNext() {
            Object[] tab = this.traversalTable;
            for (int i = this.index; i < tab.length; i += 2) {
                if (tab[i] != null) {
                    this.index = i;
                    this.indexValid = true;
                    return true;
                }
            }
            this.index = tab.length;
            return false;
        }

        /* access modifiers changed from: protected */
        public int nextIndex() {
            if (this.this$0.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else if (this.indexValid || hasNext()) {
                this.indexValid = false;
                this.lastReturnedIndex = this.index;
                this.index += 2;
                return this.lastReturnedIndex;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (this.lastReturnedIndex == -1) {
                throw new IllegalStateException();
            } else if (this.this$0.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                IdentityHashMap identityHashMap = this.this$0;
                this.expectedModCount = identityHashMap.modCount = identityHashMap.modCount + 1;
                int deletedSlot = this.lastReturnedIndex;
                this.lastReturnedIndex = -1;
                this.index = deletedSlot;
                this.indexValid = false;
                Object[] tab = this.traversalTable;
                int len = tab.length;
                int d = deletedSlot;
                Object key = tab[deletedSlot];
                tab[deletedSlot] = null;
                tab[deletedSlot + 1] = null;
                if (tab != this.this$0.table) {
                    this.this$0.remove(key);
                    this.expectedModCount = this.this$0.modCount;
                    return;
                }
                IdentityHashMap identityHashMap2 = this.this$0;
                int unused = identityHashMap2.size = identityHashMap2.size - 1;
                int i = IdentityHashMap.nextKeyIndex(deletedSlot, len);
                while (true) {
                    Object item = tab[i];
                    if (item != null) {
                        int r = IdentityHashMap.hash(item, len);
                        if ((i < r && (r <= d || d <= i)) || (r <= d && d <= i)) {
                            if (i < deletedSlot && d >= deletedSlot && this.traversalTable == this.this$0.table) {
                                int remaining = len - deletedSlot;
                                Object[] newTable = new Object[remaining];
                                System.arraycopy((Object) tab, deletedSlot, (Object) newTable, 0, remaining);
                                this.traversalTable = newTable;
                                this.index = 0;
                            }
                            tab[d] = item;
                            tab[d + 1] = tab[i + 1];
                            tab[i] = null;
                            tab[i + 1] = null;
                            d = i;
                        }
                        i = IdentityHashMap.nextKeyIndex(i, len);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private class KeyIterator extends IdentityHashMap<K, V>.IdentityHashMapIterator<K> {
        final /* synthetic */ IdentityHashMap this$0;

        /* synthetic */ KeyIterator(IdentityHashMap this$02, KeyIterator keyIterator) {
            this(this$02);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private KeyIterator(IdentityHashMap this$02) {
            super(this$02, (IdentityHashMapIterator) null);
            this.this$0 = this$02;
        }

        public K next() {
            return IdentityHashMap.unmaskNull(this.traversalTable[nextIndex()]);
        }
    }

    private class ValueIterator extends IdentityHashMap<K, V>.IdentityHashMapIterator<V> {
        final /* synthetic */ IdentityHashMap this$0;

        /* synthetic */ ValueIterator(IdentityHashMap this$02, ValueIterator valueIterator) {
            this(this$02);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private ValueIterator(IdentityHashMap this$02) {
            super(this$02, (IdentityHashMapIterator) null);
            this.this$0 = this$02;
        }

        public V next() {
            return this.traversalTable[nextIndex() + 1];
        }
    }

    private class EntryIterator extends IdentityHashMap<K, V>.IdentityHashMapIterator<Map.Entry<K, V>> {
        private IdentityHashMap<K, V>.EntryIterator.Entry lastReturnedEntry;

        /* synthetic */ EntryIterator(IdentityHashMap this$02, EntryIterator entryIterator) {
            this();
        }

        private EntryIterator() {
            super(IdentityHashMap.this, (IdentityHashMapIterator) null);
            this.lastReturnedEntry = null;
        }

        public Map.Entry<K, V> next() {
            this.lastReturnedEntry = new Entry(this, nextIndex(), (Entry) null);
            return this.lastReturnedEntry;
        }

        public void remove() {
            this.lastReturnedIndex = this.lastReturnedEntry == null ? -1 : this.lastReturnedEntry.index;
            super.remove();
            int unused = this.lastReturnedEntry.index = this.lastReturnedIndex;
            this.lastReturnedEntry = null;
        }

        private class Entry implements Map.Entry<K, V> {
            /* access modifiers changed from: private */
            public int index;

            /* synthetic */ Entry(EntryIterator this$12, int index2, Entry entry) {
                this(index2);
            }

            private Entry(int index2) {
                this.index = index2;
            }

            public K getKey() {
                checkIndexForEntryUse();
                return IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index]);
            }

            public V getValue() {
                checkIndexForEntryUse();
                return EntryIterator.this.traversalTable[this.index + 1];
            }

            public V setValue(V value) {
                checkIndexForEntryUse();
                V oldValue = EntryIterator.this.traversalTable[this.index + 1];
                EntryIterator.this.traversalTable[this.index + 1] = value;
                if (EntryIterator.this.traversalTable != IdentityHashMap.this.table) {
                    IdentityHashMap.this.put(EntryIterator.this.traversalTable[this.index], value);
                }
                return oldValue;
            }

            public boolean equals(Object o) {
                if (this.index < 0) {
                    return super.equals(o);
                }
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e = (Map.Entry) o;
                if (e.getKey() == IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index]) && e.getValue() == EntryIterator.this.traversalTable[this.index + 1]) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                if (EntryIterator.this.lastReturnedIndex < 0) {
                    return super.hashCode();
                }
                return System.identityHashCode(IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index])) ^ System.identityHashCode(EntryIterator.this.traversalTable[this.index + 1]);
            }

            public String toString() {
                if (this.index < 0) {
                    return super.toString();
                }
                return IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index]) + "=" + EntryIterator.this.traversalTable[this.index + 1];
            }

            private void checkIndexForEntryUse() {
                if (this.index < 0) {
                    throw new IllegalStateException("Entry was removed");
                }
            }
        }
    }

    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        KeySet keySet = new KeySet(this, (KeySet) null);
        this.keySet = keySet;
        return keySet;
    }

    private class KeySet extends AbstractSet<K> {
        final /* synthetic */ IdentityHashMap this$0;

        /* synthetic */ KeySet(IdentityHashMap this$02, KeySet keySet) {
            this(this$02);
        }

        private KeySet(IdentityHashMap this$02) {
            this.this$0 = this$02;
        }

        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0, (KeyIterator) null);
        }

        public int size() {
            return this.this$0.size;
        }

        public boolean contains(Object o) {
            return this.this$0.containsKey(o);
        }

        public boolean remove(Object o) {
            int oldSize = this.this$0.size;
            this.this$0.remove(o);
            return this.this$0.size != oldSize;
        }

        public boolean removeAll(Collection<?> c) {
            Objects.requireNonNull(c);
            boolean modified = false;
            Iterator<K> i = iterator();
            while (i.hasNext()) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
            return modified;
        }

        public void clear() {
            this.this$0.clear();
        }

        public int hashCode() {
            int result = 0;
            Iterator key$iterator = iterator();
            while (key$iterator.hasNext()) {
                result += System.identityHashCode(key$iterator.next());
            }
            return result;
        }

        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        public <T> T[] toArray(T[] a) {
            int expectedModCount = this.this$0.modCount;
            int size = size();
            if (a.length < size) {
                a = (Object[]) Array.newInstance(a.getClass().getComponentType(), size);
            }
            Object[] tab = this.this$0.table;
            int ti = 0;
            for (int si = 0; si < tab.length; si += 2) {
                Object key = tab[si];
                if (key != null) {
                    if (ti >= size) {
                        throw new ConcurrentModificationException();
                    }
                    a[ti] = IdentityHashMap.unmaskNull(key);
                    ti++;
                }
            }
            if (ti < size || expectedModCount != this.this$0.modCount) {
                throw new ConcurrentModificationException();
            }
            if (ti < a.length) {
                a[ti] = null;
            }
            return a;
        }

        public Spliterator<K> spliterator() {
            return new KeySpliterator(this.this$0, 0, -1, 0, 0);
        }
    }

    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        Values values = new Values(this, (Values) null);
        this.values = values;
        return values;
    }

    private class Values extends AbstractCollection<V> {
        final /* synthetic */ IdentityHashMap this$0;

        /* synthetic */ Values(IdentityHashMap this$02, Values values) {
            this(this$02);
        }

        private Values(IdentityHashMap this$02) {
            this.this$0 = this$02;
        }

        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0, (ValueIterator) null);
        }

        public int size() {
            return this.this$0.size;
        }

        public boolean contains(Object o) {
            return this.this$0.containsValue(o);
        }

        public boolean remove(Object o) {
            Iterator<V> i = iterator();
            while (i.hasNext()) {
                if (i.next() == o) {
                    i.remove();
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            this.this$0.clear();
        }

        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        public <T> T[] toArray(T[] a) {
            int expectedModCount = this.this$0.modCount;
            int size = size();
            if (a.length < size) {
                a = (Object[]) Array.newInstance(a.getClass().getComponentType(), size);
            }
            Object[] tab = this.this$0.table;
            int ti = 0;
            for (int si = 0; si < tab.length; si += 2) {
                if (tab[si] != null) {
                    if (ti >= size) {
                        throw new ConcurrentModificationException();
                    }
                    a[ti] = tab[si + 1];
                    ti++;
                }
            }
            if (ti < size || expectedModCount != this.this$0.modCount) {
                throw new ConcurrentModificationException();
            }
            if (ti < a.length) {
                a[ti] = null;
            }
            return a;
        }

        public Spliterator<V> spliterator() {
            return new ValueSpliterator(this.this$0, 0, -1, 0, 0);
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        EntrySet entrySet2 = new EntrySet(this, (EntrySet) null);
        this.entrySet = entrySet2;
        return entrySet2;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        /* synthetic */ EntrySet(IdentityHashMap this$02, EntrySet entrySet) {
            this();
        }

        private EntrySet() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(IdentityHashMap.this, (EntryIterator) null);
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            return IdentityHashMap.this.containsMapping(entry.getKey(), entry.getValue());
        }

        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            return IdentityHashMap.this.removeMapping(entry.getKey(), entry.getValue());
        }

        public int size() {
            return IdentityHashMap.this.size;
        }

        public void clear() {
            IdentityHashMap.this.clear();
        }

        public boolean removeAll(Collection<?> c) {
            Objects.requireNonNull(c);
            boolean modified = false;
            Iterator<Map.Entry<K, V>> i = iterator();
            while (i.hasNext()) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
            return modified;
        }

        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        public <T> T[] toArray(T[] a) {
            int expectedModCount = IdentityHashMap.this.modCount;
            int size = size();
            if (a.length < size) {
                a = (Object[]) Array.newInstance(a.getClass().getComponentType(), size);
            }
            Object[] tab = IdentityHashMap.this.table;
            int ti = 0;
            for (int si = 0; si < tab.length; si += 2) {
                Object key = tab[si];
                if (key != null) {
                    if (ti >= size) {
                        throw new ConcurrentModificationException();
                    }
                    a[ti] = new AbstractMap.SimpleEntry(IdentityHashMap.unmaskNull(key), tab[si + 1]);
                    ti++;
                }
            }
            if (ti < size || expectedModCount != IdentityHashMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (ti < a.length) {
                a[ti] = null;
            }
            return a;
        }

        public Spliterator<Map.Entry<K, V>> spliterator() {
            return new EntrySpliterator(IdentityHashMap.this, 0, -1, 0, 0);
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.size);
        Object[] tab = this.table;
        for (int i = 0; i < tab.length; i += 2) {
            Object key = tab[i];
            if (key != null) {
                s.writeObject(unmaskNull(key));
                s.writeObject(tab[i + 1]);
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size2 = s.readInt();
        init(capacity((size2 * 4) / 3));
        for (int i = 0; i < size2; i++) {
            putForCreate(s.readObject(), s.readObject());
        }
    }

    private void putForCreate(K key, V value) throws IOException {
        Object k = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == null) {
                tab[i] = k;
                tab[i + 1] = value;
                return;
            } else if (item == k) {
                throw new StreamCorruptedException();
            } else {
                i = nextKeyIndex(i, len);
            }
        }
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        int expectedModCount = this.modCount;
        Object[] t = this.table;
        for (int index = 0; index < t.length; index += 2) {
            Object k = t[index];
            if (k != null) {
                action.accept(unmaskNull(k), t[index + 1]);
            }
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        int expectedModCount = this.modCount;
        Object[] t = this.table;
        for (int index = 0; index < t.length; index += 2) {
            Object k = t[index];
            if (k != null) {
                t[index + 1] = function.apply(unmaskNull(k), t[index + 1]);
            }
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
