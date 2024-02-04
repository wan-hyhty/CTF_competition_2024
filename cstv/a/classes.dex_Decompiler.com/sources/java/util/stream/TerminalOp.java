package java.util.stream;

import java.util.Spliterator;

interface TerminalOp<E_IN, R> {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.TerminalOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):R, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    <P_IN> R evaluateParallel(java.util.stream.PipelineHelper<E_IN> r1, java.util.Spliterator<P_IN> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.TerminalOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):R, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.TerminalOp.evaluateParallel(java.util.stream.PipelineHelper, java.util.Spliterator):java.lang.Object");
    }

    <P_IN> R evaluateSequential(PipelineHelper<E_IN> pipelineHelper, Spliterator<P_IN> spliterator);

    StreamShape inputShape() {
        return StreamShape.REFERENCE;
    }

    int getOpFlags() {
        return 0;
    }
}
