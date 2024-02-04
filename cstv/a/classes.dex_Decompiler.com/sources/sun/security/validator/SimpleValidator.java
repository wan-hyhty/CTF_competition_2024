package sun.security.validator;

import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import sun.security.util.ObjectIdentifier;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public final class SimpleValidator extends Validator {
    private static final String NSCT_CODE_SIGNING_CA = "object_signing_ca";
    private static final String NSCT_SSL_CA = "ssl_ca";
    static final ObjectIdentifier OBJID_NETSCAPE_CERT_TYPE = null;
    static final String OID_BASIC_CONSTRAINTS = "2.5.29.19";
    static final String OID_EKU_ANY_USAGE = "2.5.29.37.0";
    static final String OID_EXTENDED_KEY_USAGE = "2.5.29.37";
    static final String OID_KEY_USAGE = "2.5.29.15";
    static final String OID_NETSCAPE_CERT_TYPE = "2.16.840.1.113730.1.1";
    private final Collection<X509Certificate> trustedCerts;
    private final Map<X500Principal, List<X509Certificate>> trustedX500Principals;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.validator.SimpleValidator.<init>(java.lang.String, java.util.Collection):void, dex: classes.dex
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
    SimpleValidator(java.lang.String r1, java.util.Collection<java.security.cert.X509Certificate> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.validator.SimpleValidator.<init>(java.lang.String, java.util.Collection):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.<init>(java.lang.String, java.util.Collection):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.buildTrustedChain(java.security.cert.X509Certificate[]):java.security.cert.X509Certificate[], dex: classes.dex
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
    private java.security.cert.X509Certificate[] buildTrustedChain(java.security.cert.X509Certificate[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.buildTrustedChain(java.security.cert.X509Certificate[]):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.buildTrustedChain(java.security.cert.X509Certificate[]):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.checkBasicConstraints(java.security.cert.X509Certificate, java.util.Set, int):int, dex: classes.dex
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
    private int checkBasicConstraints(java.security.cert.X509Certificate r1, java.util.Set<java.lang.String> r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.checkBasicConstraints(java.security.cert.X509Certificate, java.util.Set, int):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.checkBasicConstraints(java.security.cert.X509Certificate, java.util.Set, int):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.checkExtensions(java.security.cert.X509Certificate, int):int, dex: classes.dex
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
    private int checkExtensions(java.security.cert.X509Certificate r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.checkExtensions(java.security.cert.X509Certificate, int):int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.checkExtensions(java.security.cert.X509Certificate, int):int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.checkKeyUsage(java.security.cert.X509Certificate, java.util.Set):void, dex: classes.dex
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
    private void checkKeyUsage(java.security.cert.X509Certificate r1, java.util.Set<java.lang.String> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.checkKeyUsage(java.security.cert.X509Certificate, java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.checkKeyUsage(java.security.cert.X509Certificate, java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.SimpleValidator.checkNetscapeCertType(java.security.cert.X509Certificate, java.util.Set):void, dex: classes.dex
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
    private void checkNetscapeCertType(java.security.cert.X509Certificate r1, java.util.Set<java.lang.String> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.SimpleValidator.checkNetscapeCertType(java.security.cert.X509Certificate, java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.checkNetscapeCertType(java.security.cert.X509Certificate, java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.getNetscapeCertTypeBit(java.security.cert.X509Certificate, java.lang.String):boolean, dex: classes.dex
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
    static boolean getNetscapeCertTypeBit(java.security.cert.X509Certificate r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.getNetscapeCertTypeBit(java.security.cert.X509Certificate, java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.getNetscapeCertTypeBit(java.security.cert.X509Certificate, java.lang.String):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.getTrustedCertificate(java.security.cert.X509Certificate):java.security.cert.X509Certificate, dex: classes.dex
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
    private java.security.cert.X509Certificate getTrustedCertificate(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.getTrustedCertificate(java.security.cert.X509Certificate):java.security.cert.X509Certificate, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.getTrustedCertificate(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.engineValidate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
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
    java.security.cert.X509Certificate[] engineValidate(java.security.cert.X509Certificate[] r1, java.util.Collection<java.security.cert.X509Certificate> r2, java.security.AlgorithmConstraints r3, java.lang.Object r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.SimpleValidator.engineValidate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.engineValidate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.validator.SimpleValidator.getTrustedCertificates():java.util.Collection<java.security.cert.X509Certificate>, dex: classes.dex in method: sun.security.validator.SimpleValidator.getTrustedCertificates():java.util.Collection<java.security.cert.X509Certificate>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.validator.SimpleValidator.getTrustedCertificates():java.util.Collection<java.security.cert.X509Certificate>, dex: classes.dex
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
    public java.util.Collection<java.security.cert.X509Certificate> getTrustedCertificates() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.validator.SimpleValidator.getTrustedCertificates():java.util.Collection<java.security.cert.X509Certificate>, dex: classes.dex in method: sun.security.validator.SimpleValidator.getTrustedCertificates():java.util.Collection<java.security.cert.X509Certificate>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.SimpleValidator.getTrustedCertificates():java.util.Collection");
    }
}
