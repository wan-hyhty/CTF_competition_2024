package sun.nio.ch;

import java.io.IOException;
import java.util.concurrent.Future;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
final class CompletedFuture<V> implements Future<V> {
    private final Throwable exc;
    private final V result;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.CompletedFuture.<init>(java.lang.Object, java.lang.Throwable):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    private CompletedFuture(V r1, java.lang.Throwable r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.CompletedFuture.<init>(java.lang.Object, java.lang.Throwable):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.CompletedFuture.<init>(java.lang.Object, java.lang.Throwable):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.CompletedFuture.get():V, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public V get() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.CompletedFuture.get():V, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.CompletedFuture.get():java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.CompletedFuture.get(long, java.util.concurrent.TimeUnit):V, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public V get(long r1, java.util.concurrent.TimeUnit r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.CompletedFuture.get(long, java.util.concurrent.TimeUnit):V, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.CompletedFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    static <V> CompletedFuture<V> withResult(V result2) {
        return new CompletedFuture<>(result2, (Throwable) null);
    }

    static <V> CompletedFuture<V> withFailure(Throwable exc2) {
        if (!(exc2 instanceof IOException) && !(exc2 instanceof SecurityException)) {
            exc2 = new IOException(exc2);
        }
        return new CompletedFuture<>((Object) null, exc2);
    }

    static <V> CompletedFuture<V> withResult(V result2, Throwable exc2) {
        if (exc2 == null) {
            return withResult(result2);
        }
        return withFailure(exc2);
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }
}
