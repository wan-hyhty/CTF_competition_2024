package java.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

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
public interface Spliterator<T> {
    public static final int CONCURRENT = 4096;
    public static final int DISTINCT = 1;
    public static final int IMMUTABLE = 1024;
    public static final int NONNULL = 256;
    public static final int ORDERED = 16;
    public static final int SIZED = 64;
    public static final int SORTED = 4;
    public static final int SUBSIZED = 16384;

    int characteristics();

    long estimateSize();

    boolean tryAdvance(Consumer<? super T> consumer);

    Spliterator<T> trySplit();

    void forEachRemaining(Consumer<? super T> action) {
        do {
        } while (tryAdvance(action));
    }

    long getExactSizeIfKnown() {
        if ((characteristics() & 64) == 0) {
            return -1;
        }
        return estimateSize();
    }

    boolean hasCharacteristics(int characteristics) {
        return (characteristics() & characteristics) == characteristics;
    }

    Comparator<? super T> getComparator() {
        throw new IllegalStateException();
    }

    public interface OfPrimitive<T, T_CONS, T_SPLITR extends OfPrimitive<T, T_CONS, T_SPLITR>> extends Spliterator<T> {
        boolean tryAdvance(T_CONS t_cons);

        T_SPLITR trySplit();

        /* bridge */ /* synthetic */ Spliterator trySplit() {
            return trySplit();
        }

        void forEachRemaining(T_CONS action) {
            do {
            } while (tryAdvance(action));
        }
    }

    public interface OfInt extends OfPrimitive<Integer, IntConsumer, OfInt> {

        /* renamed from: java.util.Spliterator$OfInt$-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0 implements IntConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f50val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfInt.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0(java.util.function.Consumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfInt.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfInt.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfInt.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(int):void, dex: classes.dex
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
            public void accept(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfInt.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfInt.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(int):void");
            }
        }

        /* renamed from: java.util.Spliterator$OfInt$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements IntConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f51val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(java.util.function.Consumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfInt.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(int):void, dex: classes.dex
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
            public void accept(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfInt.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(int):void");
            }
        }

        boolean tryAdvance(IntConsumer intConsumer);

        OfInt trySplit();

        /* bridge */ /* synthetic */ OfPrimitive trySplit() {
            return trySplit();
        }

        /* bridge */ /* synthetic */ Spliterator trySplit() {
            return trySplit();
        }

        /* bridge */ /* synthetic */ boolean tryAdvance(Object action) {
            return tryAdvance((IntConsumer) action);
        }

        /* bridge */ /* synthetic */ void forEachRemaining(Object action) {
            forEachRemaining((IntConsumer) action);
        }

        void forEachRemaining(IntConsumer action) {
            do {
            } while (tryAdvance(action));
        }

        boolean tryAdvance(Consumer<? super Integer> action) {
            if (action instanceof IntConsumer) {
                return tryAdvance((IntConsumer) action);
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            }
            action.getClass();
            return tryAdvance((IntConsumer) new boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0(action));
        }

        void forEachRemaining(Consumer<? super Integer> action) {
            if (action instanceof IntConsumer) {
                forEachRemaining((IntConsumer) action);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            }
            action.getClass();
            forEachRemaining((IntConsumer) new void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(action));
        }
    }

    public interface OfLong extends OfPrimitive<Long, LongConsumer, OfLong> {

        /* renamed from: java.util.Spliterator$OfLong$-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0 implements LongConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f52val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfLong.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0(java.util.function.Consumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfLong.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfLong.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfLong.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(long):void, dex: classes.dex
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
            public void accept(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfLong.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfLong.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(long):void");
            }
        }

        /* renamed from: java.util.Spliterator$OfLong$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements LongConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f53val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(java.util.function.Consumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfLong.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(long):void, dex: classes.dex
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
            public void accept(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfLong.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(long):void");
            }
        }

        boolean tryAdvance(LongConsumer longConsumer);

        OfLong trySplit();

        /* bridge */ /* synthetic */ OfPrimitive trySplit() {
            return trySplit();
        }

        /* bridge */ /* synthetic */ Spliterator trySplit() {
            return trySplit();
        }

        /* bridge */ /* synthetic */ boolean tryAdvance(Object action) {
            return tryAdvance((LongConsumer) action);
        }

        /* bridge */ /* synthetic */ void forEachRemaining(Object action) {
            forEachRemaining((LongConsumer) action);
        }

        void forEachRemaining(LongConsumer action) {
            do {
            } while (tryAdvance(action));
        }

        boolean tryAdvance(Consumer<? super Long> action) {
            if (action instanceof LongConsumer) {
                return tryAdvance((LongConsumer) action);
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            }
            action.getClass();
            return tryAdvance((LongConsumer) new boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0(action));
        }

        void forEachRemaining(Consumer<? super Long> action) {
            if (action instanceof LongConsumer) {
                forEachRemaining((LongConsumer) action);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            }
            action.getClass();
            forEachRemaining((LongConsumer) new void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(action));
        }
    }

    public interface OfDouble extends OfPrimitive<Double, DoubleConsumer, OfDouble> {

        /* renamed from: java.util.Spliterator$OfDouble$-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0 implements DoubleConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f48val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfDouble.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0(java.util.function.Consumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfDouble.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfDouble.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfDouble.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(double):void, dex: classes.dex
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
            public void accept(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfDouble.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfDouble.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(double):void");
            }
        }

        /* renamed from: java.util.Spliterator$OfDouble$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements DoubleConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f49val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(java.util.function.Consumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Spliterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfDouble.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(double):void, dex: classes.dex
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
            public void accept(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Spliterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Spliterator.OfDouble.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(double):void");
            }
        }

        boolean tryAdvance(DoubleConsumer doubleConsumer);

        OfDouble trySplit();

        /* bridge */ /* synthetic */ OfPrimitive trySplit() {
            return trySplit();
        }

        /* bridge */ /* synthetic */ Spliterator trySplit() {
            return trySplit();
        }

        /* bridge */ /* synthetic */ boolean tryAdvance(Object action) {
            return tryAdvance((DoubleConsumer) action);
        }

        /* bridge */ /* synthetic */ void forEachRemaining(Object action) {
            forEachRemaining((DoubleConsumer) action);
        }

        void forEachRemaining(DoubleConsumer action) {
            do {
            } while (tryAdvance(action));
        }

        boolean tryAdvance(Consumer<? super Double> action) {
            if (action instanceof DoubleConsumer) {
                return tryAdvance((DoubleConsumer) action);
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            }
            action.getClass();
            return tryAdvance((DoubleConsumer) new boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0(action));
        }

        void forEachRemaining(Consumer<? super Double> action) {
            if (action instanceof DoubleConsumer) {
                forEachRemaining((DoubleConsumer) action);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            }
            action.getClass();
            forEachRemaining((DoubleConsumer) new void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(action));
        }
    }
}
