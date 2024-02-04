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
public interface PrimitiveIterator<T, T_CONS> extends Iterator<T> {
    void forEachRemaining(T_CONS t_cons);

    public interface OfInt extends PrimitiveIterator<Integer, IntConsumer> {

        /* renamed from: java.util.PrimitiveIterator$OfInt$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements IntConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f44val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.PrimitiveIterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.PrimitiveIterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfInt.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.PrimitiveIterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(int):void, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.PrimitiveIterator.OfInt.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfInt.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(int):void");
            }
        }

        int nextInt();

        /* bridge */ /* synthetic */ void forEachRemaining(Object action) {
            forEachRemaining((IntConsumer) action);
        }

        void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            while (hasNext()) {
                action.accept(nextInt());
            }
        }

        /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        Integer next() {
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling PrimitiveIterator.OfInt.nextInt()");
            }
            return Integer.valueOf(nextInt());
        }

        void forEachRemaining(Consumer<? super Integer> action) {
            if (action instanceof IntConsumer) {
                forEachRemaining((IntConsumer) action);
                return;
            }
            Objects.requireNonNull(action);
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
            }
            action.getClass();
            forEachRemaining((IntConsumer) new void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(action));
        }
    }

    public interface OfLong extends PrimitiveIterator<Long, LongConsumer> {

        /* renamed from: java.util.PrimitiveIterator$OfLong$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements LongConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f45val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.PrimitiveIterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.PrimitiveIterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfLong.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.PrimitiveIterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(long):void, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.PrimitiveIterator.OfLong.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfLong.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(long):void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.-java_util_PrimitiveIterator$OfLong-mthref-0(java.util.function.Consumer, long):void, dex: classes.dex
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
        /* renamed from: -java_util_PrimitiveIterator$OfLong-mthref-0 */
        static /* synthetic */ void m268java_util_PrimitiveIterator$OfLongmthref0(java.util.function.Consumer r1, long r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.-java_util_PrimitiveIterator$OfLong-mthref-0(java.util.function.Consumer, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfLong.m268java_util_PrimitiveIterator$OfLongmthref0(java.util.function.Consumer, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
        /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        void forEachRemaining(java.util.function.Consumer<? super java.lang.Long> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
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
        void forEachRemaining(java.util.function.LongConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.PrimitiveIterator.OfLong.next():java.lang.Long, dex: classes.dex
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
        java.lang.Long next() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.PrimitiveIterator.OfLong.next():java.lang.Long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfLong.next():java.lang.Long");
        }

        long nextLong();

        /* bridge */ /* synthetic */ Object next() {
            return next();
        }
    }

    public interface OfDouble extends PrimitiveIterator<Double, DoubleConsumer> {

        /* renamed from: java.util.PrimitiveIterator$OfDouble$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements DoubleConsumer {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f43val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.PrimitiveIterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.PrimitiveIterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfDouble.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.PrimitiveIterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(double):void, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.PrimitiveIterator.OfDouble.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfDouble.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(double):void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.-java_util_PrimitiveIterator$OfDouble-mthref-0(java.util.function.Consumer, double):void, dex: classes.dex
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
        /* renamed from: -java_util_PrimitiveIterator$OfDouble-mthref-0 */
        static /* synthetic */ void m266java_util_PrimitiveIterator$OfDoublemthref0(java.util.function.Consumer r1, double r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.-java_util_PrimitiveIterator$OfDouble-mthref-0(java.util.function.Consumer, double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfDouble.m266java_util_PrimitiveIterator$OfDoublemthref0(java.util.function.Consumer, double):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
        /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        void forEachRemaining(java.util.function.Consumer<? super java.lang.Double> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
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
        void forEachRemaining(java.util.function.DoubleConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.PrimitiveIterator.OfDouble.next():java.lang.Double, dex: classes.dex
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
        java.lang.Double next() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.PrimitiveIterator.OfDouble.next():java.lang.Double, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.PrimitiveIterator.OfDouble.next():java.lang.Double");
        }

        double nextDouble();

        /* bridge */ /* synthetic */ Object next() {
            return next();
        }
    }
}
