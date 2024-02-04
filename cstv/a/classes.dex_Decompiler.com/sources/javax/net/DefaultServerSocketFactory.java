package javax.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
/* compiled from: ServerSocketFactory */
class DefaultServerSocketFactory extends ServerSocketFactory {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.net.DefaultServerSocketFactory.<init>():void, dex: classes.dex
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
    DefaultServerSocketFactory() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.net.DefaultServerSocketFactory.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.DefaultServerSocketFactory.<init>():void");
    }

    public ServerSocket createServerSocket() throws IOException {
        return new ServerSocket();
    }

    public ServerSocket createServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        return new ServerSocket(port, backlog);
    }

    public ServerSocket createServerSocket(int port, int backlog, InetAddress ifAddress) throws IOException {
        return new ServerSocket(port, backlog, ifAddress);
    }
}
