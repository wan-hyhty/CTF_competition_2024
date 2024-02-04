package java.util.stream;

import java.util.function.IntFunction;
import java.util.stream.ForEachOps;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
/* renamed from: java.util.stream.ForEachOps$ForEachOrderedTask$-void_doCompute_java_util_stream_ForEachOps$ForEachOrderedTask_task_LambdaImpl0  reason: invalid class name */
final /* synthetic */ class ForEachOps$ForEachOrderedTask$void_doCompute_java_util_stream_ForEachOps$ForEachOrderedTask_task_LambdaImpl0 implements IntFunction {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.ForEachOps$ForEachOrderedTask$-void_doCompute_java_util_stream_ForEachOps$ForEachOrderedTask_task_LambdaImpl0.<init>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public /* synthetic */ ForEachOps$ForEachOrderedTask$void_doCompute_java_util_stream_ForEachOps$ForEachOrderedTask_task_LambdaImpl0() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.ForEachOps$ForEachOrderedTask$-void_doCompute_java_util_stream_ForEachOps$ForEachOrderedTask_task_LambdaImpl0.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.ForEachOps$ForEachOrderedTask$void_doCompute_java_util_stream_ForEachOps$ForEachOrderedTask_task_LambdaImpl0.<init>():void");
    }

    public Object apply(int arg0) {
        return ForEachOps.ForEachOrderedTask.m522java_util_stream_ForEachOps$ForEachOrderedTask_lambda$1(arg0);
    }
}
