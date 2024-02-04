package java.util.function;

import java.util.Objects;

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
@FunctionalInterface
public interface BiPredicate<T, U> {

    /* renamed from: java.util.function.BiPredicate$-java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0 implements BiPredicate {
        private /* synthetic */ BiPredicate val$other;
        private /* synthetic */ BiPredicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0.<init>(java.util.function.BiPredicate, java.util.function.BiPredicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0(java.util.function.BiPredicate r1, java.util.function.BiPredicate r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0.<init>(java.util.function.BiPredicate, java.util.function.BiPredicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BiPredicate.java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0.<init>(java.util.function.BiPredicate, java.util.function.BiPredicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BiPredicate.java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean");
        }
    }

    /* renamed from: java.util.function.BiPredicate$-java_util_function_BiPredicate_negate__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_BiPredicate_negate__LambdaImpl0 implements BiPredicate {
        private /* synthetic */ BiPredicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_negate__LambdaImpl0.<init>(java.util.function.BiPredicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_BiPredicate_negate__LambdaImpl0(java.util.function.BiPredicate r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_negate__LambdaImpl0.<init>(java.util.function.BiPredicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BiPredicate.java_util_function_BiPredicate_negate__LambdaImpl0.<init>(java.util.function.BiPredicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_negate__LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_negate__LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BiPredicate.java_util_function_BiPredicate_negate__LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean");
        }
    }

    /* renamed from: java.util.function.BiPredicate$-java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0 implements BiPredicate {
        private /* synthetic */ BiPredicate val$other;
        private /* synthetic */ BiPredicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0.<init>(java.util.function.BiPredicate, java.util.function.BiPredicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0(java.util.function.BiPredicate r1, java.util.function.BiPredicate r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0.<init>(java.util.function.BiPredicate, java.util.function.BiPredicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BiPredicate.java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0.<init>(java.util.function.BiPredicate, java.util.function.BiPredicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.BiPredicate.-java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.BiPredicate.java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0.test(java.lang.Object, java.lang.Object):boolean");
        }
    }

    boolean test(T t, U u);

    BiPredicate<T, U> and(BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return new java_util_function_BiPredicate_and_java_util_function_BiPredicate_other_LambdaImpl0(this, other);
    }

    /* renamed from: -java_util_function_BiPredicate_lambda$1  reason: not valid java name */
    /* synthetic */ boolean m311java_util_function_BiPredicate_lambda$1(BiPredicate other, Object t, Object u) {
        if (test(t, u)) {
            return other.test(t, u);
        }
        return false;
    }

    /* renamed from: -java_util_function_BiPredicate_lambda$2  reason: not valid java name */
    /* synthetic */ boolean m312java_util_function_BiPredicate_lambda$2(Object t, Object u) {
        return !test(t, u);
    }

    BiPredicate<T, U> negate() {
        return new java_util_function_BiPredicate_negate__LambdaImpl0(this);
    }

    BiPredicate<T, U> or(BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return new java_util_function_BiPredicate_or_java_util_function_BiPredicate_other_LambdaImpl0(this, other);
    }

    /* renamed from: -java_util_function_BiPredicate_lambda$3  reason: not valid java name */
    /* synthetic */ boolean m313java_util_function_BiPredicate_lambda$3(BiPredicate other, Object t, Object u) {
        if (!test(t, u)) {
            return other.test(t, u);
        }
        return true;
    }
}
