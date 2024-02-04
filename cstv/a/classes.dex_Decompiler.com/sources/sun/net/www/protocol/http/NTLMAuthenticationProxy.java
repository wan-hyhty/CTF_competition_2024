package sun.net.www.protocol.http;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
class NTLMAuthenticationProxy {
    private static final String clazzStr = "sun.net.www.protocol.http.ntlm.NTLMAuthentication";
    private static Method isTrustedSite = null;
    private static final String isTrustedSiteStr = "isTrustedSite";
    static final NTLMAuthenticationProxy proxy = null;
    static final boolean supported = false;
    private static Method supportsTA = null;
    private static final String supportsTAStr = "supportsTransparentAuth";
    static final boolean supportsTransparentAuth = false;
    private final Constructor<? extends AuthenticationInfo> fiveArgCtr;
    private final Constructor<? extends AuthenticationInfo> threeArgCtr;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.<init>(java.lang.reflect.Constructor, java.lang.reflect.Constructor):void, dex: classes.dex
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
    private NTLMAuthenticationProxy(java.lang.reflect.Constructor<? extends sun.net.www.protocol.http.AuthenticationInfo> r1, java.lang.reflect.Constructor<? extends sun.net.www.protocol.http.AuthenticationInfo> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.<init>(java.lang.reflect.Constructor, java.lang.reflect.Constructor):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NTLMAuthenticationProxy.<init>(java.lang.reflect.Constructor, java.lang.reflect.Constructor):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.finest(java.lang.Exception):void, dex: classes.dex
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
    static void finest(java.lang.Exception r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.finest(java.lang.Exception):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NTLMAuthenticationProxy.finest(java.lang.Exception):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.isTrustedSite(java.net.URL):boolean, dex: classes.dex
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
    public static boolean isTrustedSite(java.net.URL r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.isTrustedSite(java.net.URL):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NTLMAuthenticationProxy.isTrustedSite(java.net.URL):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.supportsTransparentAuth():boolean, dex: classes.dex
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
    private static boolean supportsTransparentAuth() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.supportsTransparentAuth():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NTLMAuthenticationProxy.supportsTransparentAuth():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.tryLoadNTLMAuthentication():sun.net.www.protocol.http.NTLMAuthenticationProxy, dex: classes.dex
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
    private static sun.net.www.protocol.http.NTLMAuthenticationProxy tryLoadNTLMAuthentication() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.tryLoadNTLMAuthentication():sun.net.www.protocol.http.NTLMAuthenticationProxy, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NTLMAuthenticationProxy.tryLoadNTLMAuthentication():sun.net.www.protocol.http.NTLMAuthenticationProxy");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.create(boolean, java.lang.String, int, java.net.PasswordAuthentication):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
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
    sun.net.www.protocol.http.AuthenticationInfo create(boolean r1, java.lang.String r2, int r3, java.net.PasswordAuthentication r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.create(boolean, java.lang.String, int, java.net.PasswordAuthentication):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NTLMAuthenticationProxy.create(boolean, java.lang.String, int, java.net.PasswordAuthentication):sun.net.www.protocol.http.AuthenticationInfo");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.create(boolean, java.net.URL, java.net.PasswordAuthentication):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
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
    sun.net.www.protocol.http.AuthenticationInfo create(boolean r1, java.net.URL r2, java.net.PasswordAuthentication r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.www.protocol.http.NTLMAuthenticationProxy.create(boolean, java.net.URL, java.net.PasswordAuthentication):sun.net.www.protocol.http.AuthenticationInfo, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.http.NTLMAuthenticationProxy.create(boolean, java.net.URL, java.net.PasswordAuthentication):sun.net.www.protocol.http.AuthenticationInfo");
    }
}
