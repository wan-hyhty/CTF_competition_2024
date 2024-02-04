package sun.net.www.protocol.http;

import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.HashMap;
import sun.net.www.HeaderParser;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class AuthenticationInfo extends AuthCacheValue implements Cloneable {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f115assertionsDisabled = false;
    public static final char PROXY_AUTHENTICATION = 'p';
    public static final char SERVER_AUTHENTICATION = 's';
    private static HashMap<String, Thread> requests;
    static boolean serializeAuth;
    AuthScheme authScheme;
    String host;
    String path;
    int port;
    String protocol;
    protected transient PasswordAuthentication pw;
    String realm;
    String s1;
    String s2;
    char type;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ed in method: sun.net.www.protocol.http.AuthenticationInfo.<init>(char, sun.net.www.protocol.http.AuthScheme, java.lang.String, int, java.lang.String):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ed
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public AuthenticationInfo(char r1, sun.net.www.protocol.http.AuthScheme r2, java.lang.String r3, int r4, java.lang.String r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ed in method: sun.net.www.protocol.http.AuthenticationInfo.<init>(char, sun.net.www.protocol.http.AuthScheme, java.lang.String, int, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.<init>(char, sun.net.www.protocol.http.AuthScheme, java.lang.String, int, java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ed in method: sun.net.www.protocol.http.AuthenticationInfo.<init>(char, sun.net.www.protocol.http.AuthScheme, java.net.URL, java.lang.String):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ed
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public AuthenticationInfo(char r1, sun.net.www.protocol.http.AuthScheme r2, java.net.URL r3, java.lang.String r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ed in method: sun.net.www.protocol.http.AuthenticationInfo.<init>(char, sun.net.www.protocol.http.AuthScheme, java.net.URL, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.<init>(char, sun.net.www.protocol.http.AuthScheme, java.net.URL, java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.net.www.protocol.http.AuthenticationInfo.endAuthRequest(java.lang.String):void, dex: classes.dex
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
    static void endAuthRequest(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.net.www.protocol.http.AuthenticationInfo.endAuthRequest(java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.endAuthRequest(java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getAuth(java.lang.String, java.net.URL):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
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
    static sun.net.www.protocol.http.AuthenticationInfo getAuth(java.lang.String r1, java.net.URL r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getAuth(java.lang.String, java.net.URL):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getAuth(java.lang.String, java.net.URL):sun.net.www.protocol.http.AuthenticationInfo");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getProxyAuth(java.lang.String, int):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
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
    static sun.net.www.protocol.http.AuthenticationInfo getProxyAuth(java.lang.String r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getProxyAuth(java.lang.String, int):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getProxyAuth(java.lang.String, int):sun.net.www.protocol.http.AuthenticationInfo");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getProxyAuthKey(java.lang.String, int, java.lang.String, sun.net.www.protocol.http.AuthScheme):java.lang.String, dex: classes.dex
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
    static java.lang.String getProxyAuthKey(java.lang.String r1, int r2, java.lang.String r3, sun.net.www.protocol.http.AuthScheme r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getProxyAuthKey(java.lang.String, int, java.lang.String, sun.net.www.protocol.http.AuthScheme):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getProxyAuthKey(java.lang.String, int, java.lang.String, sun.net.www.protocol.http.AuthScheme):java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getServerAuth(java.net.URL):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
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
    static sun.net.www.protocol.http.AuthenticationInfo getServerAuth(java.net.URL r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getServerAuth(java.net.URL):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getServerAuth(java.net.URL):sun.net.www.protocol.http.AuthenticationInfo");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getServerAuthKey(java.net.URL, java.lang.String, sun.net.www.protocol.http.AuthScheme):java.lang.String, dex: classes.dex
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
    static java.lang.String getServerAuthKey(java.net.URL r1, java.lang.String r2, sun.net.www.protocol.http.AuthScheme r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.getServerAuthKey(java.net.URL, java.lang.String, sun.net.www.protocol.http.AuthScheme):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getServerAuthKey(java.net.URL, java.lang.String, sun.net.www.protocol.http.AuthScheme):java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.readObject(java.io.ObjectInputStream):void, dex: classes.dex
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
    private void readObject(java.io.ObjectInputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.readObject(java.io.ObjectInputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.readObject(java.io.ObjectInputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.reducePath(java.lang.String):java.lang.String, dex: classes.dex
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
    static java.lang.String reducePath(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.reducePath(java.lang.String):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.reducePath(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.requestCompleted(java.lang.String):void, dex: classes.dex
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
    private static void requestCompleted(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.requestCompleted(java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.requestCompleted(java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.requestIsInProgress(java.lang.String):boolean, dex: classes.dex
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
    private static boolean requestIsInProgress(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.requestIsInProgress(java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.requestIsInProgress(java.lang.String):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
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
    private synchronized void writeObject(java.io.ObjectOutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.writeObject(java.io.ObjectOutputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.addToCache():void, dex: classes.dex
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
    void addToCache() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.addToCache():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.addToCache():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00f1 in method: sun.net.www.protocol.http.AuthenticationInfo.cacheKey(boolean):java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00f1
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    java.lang.String cacheKey(boolean r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00f1 in method: sun.net.www.protocol.http.AuthenticationInfo.cacheKey(boolean):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.cacheKey(boolean):java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.www.protocol.http.AuthenticationInfo.credentials():java.net.PasswordAuthentication, dex: classes.dex in method: sun.net.www.protocol.http.AuthenticationInfo.credentials():java.net.PasswordAuthentication, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.www.protocol.http.AuthenticationInfo.credentials():java.net.PasswordAuthentication, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    public java.net.PasswordAuthentication credentials() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.net.www.protocol.http.AuthenticationInfo.credentials():java.net.PasswordAuthentication, dex: classes.dex in method: sun.net.www.protocol.http.AuthenticationInfo.credentials():java.net.PasswordAuthentication, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.credentials():java.net.PasswordAuthentication");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getAuthScheme():sun.net.www.protocol.http.AuthScheme, dex: classes.dex
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
    sun.net.www.protocol.http.AuthScheme getAuthScheme() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getAuthScheme():sun.net.www.protocol.http.AuthScheme, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getAuthScheme():sun.net.www.protocol.http.AuthScheme");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00f1 in method: sun.net.www.protocol.http.AuthenticationInfo.getAuthType():sun.net.www.protocol.http.AuthCacheValue$Type, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00f1
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.www.protocol.http.AuthCacheValue.Type getAuthType() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00f1 in method: sun.net.www.protocol.http.AuthenticationInfo.getAuthType():sun.net.www.protocol.http.AuthCacheValue$Type, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getAuthType():sun.net.www.protocol.http.AuthCacheValue$Type");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00f1 in method: sun.net.www.protocol.http.AuthenticationInfo.getHeaderName():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00f1
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getHeaderName() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00f1 in method: sun.net.www.protocol.http.AuthenticationInfo.getHeaderName():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getHeaderName():java.lang.String");
    }

    public abstract String getHeaderValue(URL url, String str);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getHost():java.lang.String, dex: classes.dex
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
    public java.lang.String getHost() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getHost():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getHost():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getPath():java.lang.String, dex: classes.dex
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
    public java.lang.String getPath() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getPath():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getPath():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.net.www.protocol.http.AuthenticationInfo.getPort():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public int getPort() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.net.www.protocol.http.AuthenticationInfo.getPort():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getPort():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.www.protocol.http.AuthenticationInfo.getProtocolScheme():java.lang.String, dex: classes.dex in method: sun.net.www.protocol.http.AuthenticationInfo.getProtocolScheme():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.www.protocol.http.AuthenticationInfo.getProtocolScheme():java.lang.String, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    public java.lang.String getProtocolScheme() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.net.www.protocol.http.AuthenticationInfo.getProtocolScheme():java.lang.String, dex: classes.dex in method: sun.net.www.protocol.http.AuthenticationInfo.getProtocolScheme():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getProtocolScheme():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getRealm():java.lang.String, dex: classes.dex
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
    public java.lang.String getRealm() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.AuthenticationInfo.getRealm():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.getRealm():java.lang.String");
    }

    public abstract boolean isAuthorizationStale(String str);

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.removeFromCache():void, dex: classes.dex
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
    void removeFromCache() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.AuthenticationInfo.removeFromCache():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.AuthenticationInfo.removeFromCache():void");
    }

    public abstract boolean setHeaders(HttpURLConnection httpURLConnection, HeaderParser headerParser, String str);

    public abstract boolean supportsPreemptiveAuthorization();

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    static AuthenticationInfo getServerAuth(String key) {
        AuthenticationInfo cached = getAuth(key, (URL) null);
        if (cached != null || !requestIsInProgress(key)) {
            return cached;
        }
        return getAuth(key, (URL) null);
    }

    static AuthenticationInfo getProxyAuth(String key) {
        AuthenticationInfo cached = (AuthenticationInfo) cache.get(key, (String) null);
        if (cached != null || !requestIsInProgress(key)) {
            return cached;
        }
        return (AuthenticationInfo) cache.get(key, (String) null);
    }
}
