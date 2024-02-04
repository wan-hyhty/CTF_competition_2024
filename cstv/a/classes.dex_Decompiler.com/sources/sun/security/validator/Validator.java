package sun.security.validator;

import java.security.AlgorithmConstraints;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class Validator {
    static final X509Certificate[] CHAIN0 = null;
    public static final String TYPE_PKIX = "PKIX";
    public static final String TYPE_SIMPLE = "Simple";
    public static final String VAR_CODE_SIGNING = "code signing";
    public static final String VAR_GENERIC = "generic";
    public static final String VAR_JCE_SIGNING = "jce signing";
    public static final String VAR_PLUGIN_CODE_SIGNING = "plugin code signing";
    public static final String VAR_TLS_CLIENT = "tls client";
    public static final String VAR_TLS_SERVER = "tls server";
    public static final String VAR_TSA_SERVER = "tsa server";
    final EndEntityChecker endEntityChecker;
    @Deprecated
    volatile Date validationDate;
    final String variant;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.validator.Validator.<init>(java.lang.String, java.lang.String):void, dex: classes.dex
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
    Validator(java.lang.String r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.validator.Validator.<init>(java.lang.String, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.<init>(java.lang.String, java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.getInstance(java.lang.String, java.lang.String, java.security.cert.PKIXBuilderParameters):sun.security.validator.Validator, dex: classes.dex
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
    public static sun.security.validator.Validator getInstance(java.lang.String r1, java.lang.String r2, java.security.cert.PKIXBuilderParameters r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.getInstance(java.lang.String, java.lang.String, java.security.cert.PKIXBuilderParameters):sun.security.validator.Validator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.getInstance(java.lang.String, java.lang.String, java.security.cert.PKIXBuilderParameters):sun.security.validator.Validator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.getInstance(java.lang.String, java.lang.String, java.util.Collection):sun.security.validator.Validator, dex: classes.dex
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
    public static sun.security.validator.Validator getInstance(java.lang.String r1, java.lang.String r2, java.util.Collection<java.security.cert.X509Certificate> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.getInstance(java.lang.String, java.lang.String, java.util.Collection):sun.security.validator.Validator, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.getInstance(java.lang.String, java.lang.String, java.util.Collection):sun.security.validator.Validator");
    }

    /* access modifiers changed from: package-private */
    public abstract X509Certificate[] engineValidate(X509Certificate[] x509CertificateArr, Collection<X509Certificate> collection, AlgorithmConstraints algorithmConstraints, Object obj) throws CertificateException;

    public abstract Collection<X509Certificate> getTrustedCertificates();

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.validator.Validator.setValidationDate(java.util.Date):void, dex: classes.dex
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
    public void setValidationDate(java.util.Date r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.validator.Validator.setValidationDate(java.util.Date):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.setValidationDate(java.util.Date):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[]):java.security.cert.X509Certificate[], dex: classes.dex
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
    public final java.security.cert.X509Certificate[] validate(java.security.cert.X509Certificate[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[]):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[]):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection):java.security.cert.X509Certificate[], dex: classes.dex
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
    public final java.security.cert.X509Certificate[] validate(java.security.cert.X509Certificate[] r1, java.util.Collection<java.security.cert.X509Certificate> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
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
    public final java.security.cert.X509Certificate[] validate(java.security.cert.X509Certificate[] r1, java.util.Collection<java.security.cert.X509Certificate> r2, java.lang.Object r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection, java.lang.Object):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
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
    public final java.security.cert.X509Certificate[] validate(java.security.cert.X509Certificate[] r1, java.util.Collection<java.security.cert.X509Certificate> r2, java.security.AlgorithmConstraints r3, java.lang.Object r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.Validator.validate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[]");
    }

    public static Validator getInstance(String type, String variant2, KeyStore ks) {
        return getInstance(type, variant2, (Collection<X509Certificate>) KeyStores.getTrustedCerts(ks));
    }
}
