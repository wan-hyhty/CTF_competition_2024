package javax.net.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
/* compiled from: SSLSocketFactory */
class DefaultSSLSocketFactory extends SSLSocketFactory {
    private Exception reason;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: javax.net.ssl.DefaultSSLSocketFactory.<init>(java.lang.Exception):void, dex: classes.dex
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
    DefaultSSLSocketFactory(java.lang.Exception r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: javax.net.ssl.DefaultSSLSocketFactory.<init>(java.lang.Exception):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.DefaultSSLSocketFactory.<init>(java.lang.Exception):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: javax.net.ssl.DefaultSSLSocketFactory.throwException():java.net.Socket, dex: classes.dex
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
    private java.net.Socket throwException() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: javax.net.ssl.DefaultSSLSocketFactory.throwException():java.net.Socket, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.DefaultSSLSocketFactory.throwException():java.net.Socket");
    }

    public Socket createSocket() throws IOException {
        return throwException();
    }

    public Socket createSocket(String host, int port) throws IOException {
        return throwException();
    }

    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return throwException();
    }

    public Socket createSocket(InetAddress address, int port) throws IOException {
        return throwException();
    }

    public Socket createSocket(String host, int port, InetAddress clientAddress, int clientPort) throws IOException {
        return throwException();
    }

    public Socket createSocket(InetAddress address, int port, InetAddress clientAddress, int clientPort) throws IOException {
        return throwException();
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
