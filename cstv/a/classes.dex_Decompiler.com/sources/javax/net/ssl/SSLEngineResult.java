package javax.net.ssl;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class SSLEngineResult {
    private final int bytesConsumed;
    private final int bytesProduced;
    private final HandshakeStatus handshakeStatus;
    private final Status status;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum HandshakeStatus {
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum Status {
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: javax.net.ssl.SSLEngineResult.<init>(javax.net.ssl.SSLEngineResult$Status, javax.net.ssl.SSLEngineResult$HandshakeStatus, int, int):void, dex: classes.dex in method: javax.net.ssl.SSLEngineResult.<init>(javax.net.ssl.SSLEngineResult$Status, javax.net.ssl.SSLEngineResult$HandshakeStatus, int, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: javax.net.ssl.SSLEngineResult.<init>(javax.net.ssl.SSLEngineResult$Status, javax.net.ssl.SSLEngineResult$HandshakeStatus, int, int):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public SSLEngineResult(javax.net.ssl.SSLEngineResult.Status r1, javax.net.ssl.SSLEngineResult.HandshakeStatus r2, int r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: null in method: javax.net.ssl.SSLEngineResult.<init>(javax.net.ssl.SSLEngineResult$Status, javax.net.ssl.SSLEngineResult$HandshakeStatus, int, int):void, dex: classes.dex in method: javax.net.ssl.SSLEngineResult.<init>(javax.net.ssl.SSLEngineResult$Status, javax.net.ssl.SSLEngineResult$HandshakeStatus, int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SSLEngineResult.<init>(javax.net.ssl.SSLEngineResult$Status, javax.net.ssl.SSLEngineResult$HandshakeStatus, int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: javax.net.ssl.SSLEngineResult.bytesConsumed():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public final int bytesConsumed() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: javax.net.ssl.SSLEngineResult.bytesConsumed():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SSLEngineResult.bytesConsumed():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: javax.net.ssl.SSLEngineResult.bytesProduced():int, dex: classes.dex in method: javax.net.ssl.SSLEngineResult.bytesProduced():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: javax.net.ssl.SSLEngineResult.bytesProduced():int, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public final int bytesProduced() {
        /*
        // Can't load method instructions: Load method exception: null in method: javax.net.ssl.SSLEngineResult.bytesProduced():int, dex: classes.dex in method: javax.net.ssl.SSLEngineResult.bytesProduced():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SSLEngineResult.bytesProduced():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: javax.net.ssl.SSLEngineResult.getHandshakeStatus():javax.net.ssl.SSLEngineResult$HandshakeStatus, dex: classes.dex
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
    public final javax.net.ssl.SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: javax.net.ssl.SSLEngineResult.getHandshakeStatus():javax.net.ssl.SSLEngineResult$HandshakeStatus, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SSLEngineResult.getHandshakeStatus():javax.net.ssl.SSLEngineResult$HandshakeStatus");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: javax.net.ssl.SSLEngineResult.getStatus():javax.net.ssl.SSLEngineResult$Status, dex: classes.dex
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
    public final javax.net.ssl.SSLEngineResult.Status getStatus() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: javax.net.ssl.SSLEngineResult.getStatus():javax.net.ssl.SSLEngineResult$Status, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SSLEngineResult.getStatus():javax.net.ssl.SSLEngineResult$Status");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: javax.net.ssl.SSLEngineResult.toString():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.lang.String toString() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: javax.net.ssl.SSLEngineResult.toString():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SSLEngineResult.toString():java.lang.String");
    }
}
