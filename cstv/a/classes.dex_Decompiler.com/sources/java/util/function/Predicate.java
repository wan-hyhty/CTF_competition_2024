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
public interface Predicate<T> {

    /* renamed from: java.util.function.Predicate$-java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0 implements Predicate {
        private /* synthetic */ Predicate val$other;
        private /* synthetic */ Predicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0.<init>(java.util.function.Predicate, java.util.function.Predicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0(java.util.function.Predicate r1, java.util.function.Predicate r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0.<init>(java.util.function.Predicate, java.util.function.Predicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0.<init>(java.util.function.Predicate, java.util.function.Predicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0.test(java.lang.Object):boolean");
        }
    }

    /* renamed from: java.util.function.Predicate$-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl0 implements Predicate {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.function.Predicate.-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl0.<init>():void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl0() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.function.Predicate.-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl0.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl0.<init>():void");
        }

        public boolean test(Object arg0) {
            return Objects.isNull(arg0);
        }
    }

    /* renamed from: java.util.function.Predicate$-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1  reason: invalid class name */
    final /* synthetic */ class java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1 implements Predicate {
        private /* synthetic */ Object val$targetRef;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1.<init>(java.lang.Object):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1.<init>(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1.<init>(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1.test(java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1.test(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1.test(java.lang.Object):boolean");
        }
    }

    /* renamed from: java.util.function.Predicate$-java_util_function_Predicate_negate__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Predicate_negate__LambdaImpl0 implements Predicate {
        private /* synthetic */ Predicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_negate__LambdaImpl0.<init>(java.util.function.Predicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Predicate_negate__LambdaImpl0(java.util.function.Predicate r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_negate__LambdaImpl0.<init>(java.util.function.Predicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_negate__LambdaImpl0.<init>(java.util.function.Predicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_negate__LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_negate__LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_negate__LambdaImpl0.test(java.lang.Object):boolean");
        }
    }

    /* renamed from: java.util.function.Predicate$-java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0 implements Predicate {
        private /* synthetic */ Predicate val$other;
        private /* synthetic */ Predicate val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0.<init>(java.util.function.Predicate, java.util.function.Predicate):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0(java.util.function.Predicate r1, java.util.function.Predicate r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.Predicate.-java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0.<init>(java.util.function.Predicate, java.util.function.Predicate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0.<init>(java.util.function.Predicate, java.util.function.Predicate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.Predicate.-java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.Predicate.java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0.test(java.lang.Object):boolean");
        }
    }

    boolean test(T t);

    Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return new java_util_function_Predicate_and_java_util_function_Predicate_other_LambdaImpl0(this, other);
    }

    /* renamed from: -java_util_function_Predicate_lambda$1  reason: not valid java name */
    /* synthetic */ boolean m343java_util_function_Predicate_lambda$1(Predicate other, Object t) {
        if (test(t)) {
            return other.test(t);
        }
        return false;
    }

    /* renamed from: -java_util_function_Predicate_lambda$2  reason: not valid java name */
    /* synthetic */ boolean m344java_util_function_Predicate_lambda$2(Object t) {
        return !test(t);
    }

    Predicate<T> negate() {
        return new java_util_function_Predicate_negate__LambdaImpl0(this);
    }

    Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return new java_util_function_Predicate_or_java_util_function_Predicate_other_LambdaImpl0(this, other);
    }

    /* renamed from: -java_util_function_Predicate_lambda$3  reason: not valid java name */
    /* synthetic */ boolean m345java_util_function_Predicate_lambda$3(Predicate other, Object t) {
        if (!test(t)) {
            return other.test(t);
        }
        return true;
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        if (targetRef == null) {
            return new java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl0();
        }
        return new java_util_function_Predicate_isEqual_java_lang_Object_targetRef_LambdaImpl1(targetRef);
    }
}
