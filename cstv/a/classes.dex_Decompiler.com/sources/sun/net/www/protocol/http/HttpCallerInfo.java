package sun.net.www.protocol.http;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.URL;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public final class HttpCallerInfo {
    public final InetAddress addr;
    public final Authenticator.RequestorType authType;
    public final String host;
    public final int port;
    public final String prompt;
    public final String protocol;
    public final String scheme;
    public final URL url;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.HttpCallerInfo.<init>(java.net.URL):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public HttpCallerInfo(java.net.URL r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.HttpCallerInfo.<init>(java.net.URL):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.HttpCallerInfo.<init>(java.net.URL):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.HttpCallerInfo.<init>(java.net.URL, java.lang.String, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public HttpCallerInfo(java.net.URL r1, java.lang.String r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.HttpCallerInfo.<init>(java.net.URL, java.lang.String, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.HttpCallerInfo.<init>(java.net.URL, java.lang.String, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.HttpCallerInfo.<init>(sun.net.www.protocol.http.HttpCallerInfo, java.lang.String):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public HttpCallerInfo(sun.net.www.protocol.http.HttpCallerInfo r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.HttpCallerInfo.<init>(sun.net.www.protocol.http.HttpCallerInfo, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.HttpCallerInfo.<init>(sun.net.www.protocol.http.HttpCallerInfo, java.lang.String):void");
    }
}
