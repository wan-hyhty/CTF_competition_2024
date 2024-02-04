package sun.security.validator;

import java.util.Collection;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
class EndEntityChecker {
    private static final int KU_KEY_AGREEMENT = 4;
    private static final int KU_KEY_ENCIPHERMENT = 2;
    private static final Collection<String> KU_SERVER_ENCRYPTION = null;
    private static final Collection<String> KU_SERVER_KEY_AGREEMENT = null;
    private static final Collection<String> KU_SERVER_SIGNATURE = null;
    private static final int KU_SIGNATURE = 0;
    private static final String NSCT_CODE_SIGNING = "object_signing";
    private static final String NSCT_SSL_CLIENT = "ssl_client";
    private static final String NSCT_SSL_SERVER = "ssl_server";
    private static final String OID_EKU_ANY_USAGE = "2.5.29.37.0";
    private static final String OID_EKU_CODE_SIGNING = "1.3.6.1.5.5.7.3.3";
    private static final String OID_EKU_MS_SGC = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_EKU_NS_SGC = "2.16.840.1.113730.4.1";
    private static final String OID_EKU_TIME_STAMPING = "1.3.6.1.5.5.7.3.8";
    private static final String OID_EKU_TLS_CLIENT = "1.3.6.1.5.5.7.3.2";
    private static final String OID_EKU_TLS_SERVER = "1.3.6.1.5.5.7.3.1";
    private static final String OID_EXTENDED_KEY_USAGE = "2.5.29.37";
    private static final String OID_SUBJECT_ALT_NAME = "2.5.29.17";
    private final String type;
    private final String variant;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.validator.EndEntityChecker.<init>(java.lang.String, java.lang.String):void, dex: classes.dex
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
    private EndEntityChecker(java.lang.String r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.validator.EndEntityChecker.<init>(java.lang.String, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.<init>(java.lang.String, java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.EndEntityChecker.checkCodeSigning(java.security.cert.X509Certificate):void, dex: classes.dex
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
    private void checkCodeSigning(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.EndEntityChecker.checkCodeSigning(java.security.cert.X509Certificate):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.checkCodeSigning(java.security.cert.X509Certificate):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkEKU(java.security.cert.X509Certificate, java.util.Set, java.lang.String):boolean, dex: classes.dex
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
    private boolean checkEKU(java.security.cert.X509Certificate r1, java.util.Set<java.lang.String> r2, java.lang.String r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkEKU(java.security.cert.X509Certificate, java.util.Set, java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.checkEKU(java.security.cert.X509Certificate, java.util.Set, java.lang.String):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkKeyUsage(java.security.cert.X509Certificate, int):boolean, dex: classes.dex
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
    private boolean checkKeyUsage(java.security.cert.X509Certificate r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkKeyUsage(java.security.cert.X509Certificate, int):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.checkKeyUsage(java.security.cert.X509Certificate, int):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkRemainingExtensions(java.util.Set):void, dex: classes.dex
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
    private void checkRemainingExtensions(java.util.Set<java.lang.String> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkRemainingExtensions(java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.checkRemainingExtensions(java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.validator.EndEntityChecker.checkTLSClient(java.security.cert.X509Certificate):void, dex: classes.dex
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
    private void checkTLSClient(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.validator.EndEntityChecker.checkTLSClient(java.security.cert.X509Certificate):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.checkTLSClient(java.security.cert.X509Certificate):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkTLSServer(java.security.cert.X509Certificate, java.lang.String):void, dex: classes.dex
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
    private void checkTLSServer(java.security.cert.X509Certificate r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkTLSServer(java.security.cert.X509Certificate, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.checkTLSServer(java.security.cert.X509Certificate, java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkTSAServer(java.security.cert.X509Certificate):void, dex: classes.dex
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
    private void checkTSAServer(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.checkTSAServer(java.security.cert.X509Certificate):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.checkTSAServer(java.security.cert.X509Certificate):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.getCriticalExtensions(java.security.cert.X509Certificate):java.util.Set<java.lang.String>, dex: classes.dex
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
    private java.util.Set<java.lang.String> getCriticalExtensions(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.EndEntityChecker.getCriticalExtensions(java.security.cert.X509Certificate):java.util.Set<java.lang.String>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.getCriticalExtensions(java.security.cert.X509Certificate):java.util.Set");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.EndEntityChecker.check(java.security.cert.X509Certificate, java.lang.Object):void, dex: classes.dex
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
    void check(java.security.cert.X509Certificate r1, java.lang.Object r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.EndEntityChecker.check(java.security.cert.X509Certificate, java.lang.Object):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.EndEntityChecker.check(java.security.cert.X509Certificate, java.lang.Object):void");
    }

    static EndEntityChecker getInstance(String type2, String variant2) {
        return new EndEntityChecker(type2, variant2);
    }
}
