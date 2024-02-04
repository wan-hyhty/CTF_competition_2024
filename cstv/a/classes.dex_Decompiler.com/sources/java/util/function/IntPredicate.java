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
public interface IntPredicate {

    /* renamed from: java.util.function.IntPredicate$-java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0 implements IntPredicate {
        private /* synthetic */ IntPredicate val$other;
        private /* synthetic */ IntPredicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0.<init>(java.util.function.IntPredicate, java.util.function.IntPredicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0(java.util.function.IntPredicate r1, java.util.function.IntPredicate r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0.<init>(java.util.function.IntPredicate, java.util.function.IntPredicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.IntPredicate.java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0.<init>(java.util.function.IntPredicate, java.util.function.IntPredicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0.test(int):boolean, dex: classes.dex
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
        public boolean test(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0.test(int):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.IntPredicate.java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0.test(int):boolean");
        }
    }

    /* renamed from: java.util.function.IntPredicate$-java_util_function_IntPredicate_negate__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_IntPredicate_negate__LambdaImpl0 implements IntPredicate {
        private /* synthetic */ IntPredicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_negate__LambdaImpl0.<init>(java.util.function.IntPredicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_IntPredicate_negate__LambdaImpl0(java.util.function.IntPredicate r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_negate__LambdaImpl0.<init>(java.util.function.IntPredicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.IntPredicate.java_util_function_IntPredicate_negate__LambdaImpl0.<init>(java.util.function.IntPredicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_negate__LambdaImpl0.test(int):boolean, dex: classes.dex
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
        public boolean test(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_negate__LambdaImpl0.test(int):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.IntPredicate.java_util_function_IntPredicate_negate__LambdaImpl0.test(int):boolean");
        }
    }

    /* renamed from: java.util.function.IntPredicate$-java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0 implements IntPredicate {
        private /* synthetic */ IntPredicate val$other;
        private /* synthetic */ IntPredicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0.<init>(java.util.function.IntPredicate, java.util.function.IntPredicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0(java.util.function.IntPredicate r1, java.util.function.IntPredicate r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0.<init>(java.util.function.IntPredicate, java.util.function.IntPredicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.IntPredicate.java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0.<init>(java.util.function.IntPredicate, java.util.function.IntPredicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0.test(int):boolean, dex: classes.dex
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
        public boolean test(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.IntPredicate.-java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0.test(int):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.IntPredicate.java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0.test(int):boolean");
        }
    }

    boolean test(int i);

    IntPredicate and(IntPredicate other) {
        Objects.requireNonNull(other);
        return new java_util_function_IntPredicate_and_java_util_function_IntPredicate_other_LambdaImpl0(this, other);
    }

    /* renamed from: -java_util_function_IntPredicate_lambda$1  reason: not valid java name */
    /* synthetic */ boolean m328java_util_function_IntPredicate_lambda$1(IntPredicate other, int value) {
        if (test(value)) {
            return other.test(value);
        }
        return false;
    }

    /* renamed from: -java_util_function_IntPredicate_lambda$2  reason: not valid java name */
    /* synthetic */ boolean m329java_util_function_IntPredicate_lambda$2(int value) {
        return !test(value);
    }

    IntPredicate negate() {
        return new java_util_function_IntPredicate_negate__LambdaImpl0(this);
    }

    IntPredicate or(IntPredicate other) {
        Objects.requireNonNull(other);
        return new java_util_function_IntPredicate_or_java_util_function_IntPredicate_other_LambdaImpl0(this, other);
    }

    /* renamed from: -java_util_function_IntPredicate_lambda$3  reason: not valid java name */
    /* synthetic */ boolean m330java_util_function_IntPredicate_lambda$3(IntPredicate other, int value) {
        if (!test(value)) {
            return other.test(value);
        }
        return true;
    }
}
