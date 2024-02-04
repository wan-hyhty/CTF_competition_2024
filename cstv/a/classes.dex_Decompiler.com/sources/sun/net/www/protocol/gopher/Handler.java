package sun.net.www.protocol.gopher;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import sun.net.www.protocol.http.HttpURLConnection;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class Handler extends URLStreamHandler {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.gopher.Handler.openConnection(java.net.URL):java.net.URLConnection, dex: classes.dex
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
    public java.net.URLConnection openConnection(java.net.URL r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.gopher.Handler.openConnection(java.net.URL):java.net.URLConnection, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.gopher.Handler.openConnection(java.net.URL):java.net.URLConnection");
    }

    /* access modifiers changed from: protected */
    public int getDefaultPort() {
        return 70;
    }

    public URLConnection openConnection(URL u, Proxy p) throws IOException {
        String host;
        if (p == null && GopherClient.getUseGopherProxy() && (host = GopherClient.getGopherProxyHost()) != null) {
            p = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(host, GopherClient.getGopherProxyPort()));
        }
        if (p != null) {
            return new HttpURLConnection(u, p);
        }
        return new GopherURLConnection(u);
    }
}
