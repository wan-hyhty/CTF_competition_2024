package sun.net.www.protocol.http;

import java.net.URL;
import java.util.HashMap;
import sun.misc.BASE64Encoder;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class NegotiateAuthentication extends AuthenticationInfo {
    static HashMap<String, Negotiator> cache = null;
    private static final long serialVersionUID = 100;
    static HashMap<String, Boolean> supported;
    private final HttpCallerInfo hci;
    private Negotiator negotiator;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NegotiateAuthentication.<init>(sun.net.www.protocol.http.HttpCallerInfo):void, dex: classes.dex
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
    public NegotiateAuthentication(sun.net.www.protocol.http.HttpCallerInfo r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NegotiateAuthentication.<init>(sun.net.www.protocol.http.HttpCallerInfo):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NegotiateAuthentication.<init>(sun.net.www.protocol.http.HttpCallerInfo):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.NegotiateAuthentication.firstToken():byte[], dex: classes.dex
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
    private byte[] firstToken() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.NegotiateAuthentication.firstToken():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NegotiateAuthentication.firstToken():byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NegotiateAuthentication.isSupported(sun.net.www.protocol.http.HttpCallerInfo):boolean, dex: classes.dex
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
    public static synchronized boolean isSupported(sun.net.www.protocol.http.HttpCallerInfo r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NegotiateAuthentication.isSupported(sun.net.www.protocol.http.HttpCallerInfo):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NegotiateAuthentication.isSupported(sun.net.www.protocol.http.HttpCallerInfo):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NegotiateAuthentication.nextToken(byte[]):byte[], dex: classes.dex
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
    private byte[] nextToken(byte[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NegotiateAuthentication.nextToken(byte[]):byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NegotiateAuthentication.nextToken(byte[]):byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NegotiateAuthentication.setHeaders(sun.net.www.protocol.http.HttpURLConnection, sun.net.www.HeaderParser, java.lang.String):boolean, dex: classes.dex
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
    public synchronized boolean setHeaders(sun.net.www.protocol.http.HttpURLConnection r1, sun.net.www.HeaderParser r2, java.lang.String r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NegotiateAuthentication.setHeaders(sun.net.www.protocol.http.HttpURLConnection, sun.net.www.HeaderParser, java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NegotiateAuthentication.setHeaders(sun.net.www.protocol.http.HttpURLConnection, sun.net.www.HeaderParser, java.lang.String):boolean");
    }

    public boolean supportsPreemptiveAuthorization() {
        return false;
    }

    public String getHeaderValue(URL url, String method) {
        throw new RuntimeException("getHeaderValue not supported");
    }

    public boolean isAuthorizationStale(String header) {
        return false;
    }

    class B64Encoder extends BASE64Encoder {
        final /* synthetic */ NegotiateAuthentication this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.NegotiateAuthentication.B64Encoder.<init>(sun.net.www.protocol.http.NegotiateAuthentication):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        B64Encoder(sun.net.www.protocol.http.NegotiateAuthentication r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.NegotiateAuthentication.B64Encoder.<init>(sun.net.www.protocol.http.NegotiateAuthentication):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NegotiateAuthentication.B64Encoder.<init>(sun.net.www.protocol.http.NegotiateAuthentication):void");
        }

        /* access modifiers changed from: protected */
        public int bytesPerLine() {
            return 100000;
        }
    }
}
