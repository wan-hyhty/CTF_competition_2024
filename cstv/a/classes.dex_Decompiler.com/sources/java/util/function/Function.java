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
public interface Function<T, R> {

    /* renamed from: java.util.function.Function$-java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0 implements Function {
        private /* synthetic */ Function val$after;
        private /* synthetic */ Function val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.Function.-java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0.<init>(java.util.function.Function, java.util.function.Function):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0(java.util.function.Function r1, java.util.function.Function r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.Function.-java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0.<init>(java.util.function.Function, java.util.function.Function):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Function.java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0.<init>(java.util.function.Function, java.util.function.Function):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.Function.-java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
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
        public java.lang.Object apply(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.Function.-java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Function.java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0.apply(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: java.util.function.Function$-java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0 implements Function {
        private /* synthetic */ Function val$before;
        private /* synthetic */ Function val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.Function.-java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0.<init>(java.util.function.Function, java.util.function.Function):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0(java.util.function.Function r1, java.util.function.Function r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.Function.-java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0.<init>(java.util.function.Function, java.util.function.Function):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Function.java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0.<init>(java.util.function.Function, java.util.function.Function):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.Function.-java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
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
        public java.lang.Object apply(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.Function.-java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0.apply(java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Function.java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0.apply(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: java.util.function.Function$-java_util_function_Function_identity__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Function_identity__LambdaImpl0 implements Function {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.function.Function.-java_util_function_Function_identity__LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Function_identity__LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.function.Function.-java_util_function_Function_identity__LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Function.java_util_function_Function_identity__LambdaImpl0.<init>():void");
        }

        public Object apply(Object arg0) {
            return Function.m324java_util_function_Function_lambda$3(arg0);
        }
    }

    R apply(T t);

    <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return new java_util_function_Function_compose_java_util_function_Function_before_LambdaImpl0(this, before);
    }

    /* renamed from: -java_util_function_Function_lambda$1  reason: not valid java name */
    /* synthetic */ Object m325java_util_function_Function_lambda$1(Function before, Object v) {
        return apply(before.apply(v));
    }

    <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new java_util_function_Function_andThen_java_util_function_Function_after_LambdaImpl0(this, after);
    }

    /* renamed from: -java_util_function_Function_lambda$2  reason: not valid java name */
    /* synthetic */ Object m326java_util_function_Function_lambda$2(Function after, Object t) {
        return after.apply(apply(t));
    }

    /* renamed from: -java_util_function_Function_lambda$3  reason: not valid java name */
    static /* synthetic */ Object m324java_util_function_Function_lambda$3(Object t) {
        return t;
    }

    static <T> Function<T, T> identity() {
        return new java_util_function_Function_identity__LambdaImpl0();
    }
}
