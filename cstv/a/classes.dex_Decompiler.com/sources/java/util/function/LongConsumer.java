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
public interface LongConsumer {

    /* renamed from: java.util.function.LongConsumer$-java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0 implements LongConsumer {
        private /* synthetic */ LongConsumer val$after;
        private /* synthetic */ LongConsumer val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.function.LongConsumer.-java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0.<init>(java.util.function.LongConsumer, java.util.function.LongConsumer):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0(java.util.function.LongConsumer r1, java.util.function.LongConsumer r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.function.LongConsumer.-java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0.<init>(java.util.function.LongConsumer, java.util.function.LongConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.LongConsumer.java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0.<init>(java.util.function.LongConsumer, java.util.function.LongConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.function.LongConsumer.-java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0.accept(long):void, dex: classes.dex
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
        public void accept(long r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.function.LongConsumer.-java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0.accept(long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.function.LongConsumer.java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0.accept(long):void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.function.LongConsumer.-java_util_function_LongConsumer_lambda$1(java.util.function.LongConsumer, long):void, dex: classes.dex
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
    /* renamed from: -java_util_function_LongConsumer_lambda$1 */
    /* synthetic */ void m334java_util_function_LongConsumer_lambda$1(java.util.function.LongConsumer r1, long r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.function.LongConsumer.-java_util_function_LongConsumer_lambda$1(java.util.function.LongConsumer, long):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.function.LongConsumer.m334java_util_function_LongConsumer_lambda$1(java.util.function.LongConsumer, long):void");
    }

    void accept(long j);

    LongConsumer andThen(LongConsumer after) {
        Objects.requireNonNull(after);
        return new java_util_function_LongConsumer_andThen_java_util_function_LongConsumer_after_LambdaImpl0(this, after);
    }
}
