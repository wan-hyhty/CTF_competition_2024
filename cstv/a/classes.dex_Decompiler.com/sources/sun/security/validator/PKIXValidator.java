package sun.security.validator;

import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public final class PKIXValidator extends Validator {
    private static final boolean TRY_VALIDATOR = true;
    private static final boolean checkTLSRevocation = false;
    private int certPathLength;
    private final CertificateFactory factory;
    private final PKIXBuilderParameters parameterTemplate;
    private final boolean plugin;
    private final Set<X509Certificate> trustedCerts;
    private final Map<X500Principal, List<PublicKey>> trustedSubjects;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.security.validator.PKIXValidator.<init>(java.lang.String, java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    PKIXValidator(java.lang.String r1, java.security.cert.PKIXBuilderParameters r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.security.validator.PKIXValidator.<init>(java.lang.String, java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.<init>(java.lang.String, java.security.cert.PKIXBuilderParameters):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.security.validator.PKIXValidator.<init>(java.lang.String, java.util.Collection):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    PKIXValidator(java.lang.String r1, java.util.Collection<java.security.cert.X509Certificate> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.security.validator.PKIXValidator.<init>(java.lang.String, java.util.Collection):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.<init>(java.lang.String, java.util.Collection):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.PKIXValidator.doBuild(java.security.cert.X509Certificate[], java.util.Collection, java.security.cert.PKIXBuilderParameters):java.security.cert.X509Certificate[], dex: classes.dex
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
    private java.security.cert.X509Certificate[] doBuild(java.security.cert.X509Certificate[] r1, java.util.Collection<java.security.cert.X509Certificate> r2, java.security.cert.PKIXBuilderParameters r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.PKIXValidator.doBuild(java.security.cert.X509Certificate[], java.util.Collection, java.security.cert.PKIXBuilderParameters):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.doBuild(java.security.cert.X509Certificate[], java.util.Collection, java.security.cert.PKIXBuilderParameters):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.doValidate(java.security.cert.X509Certificate[], java.security.cert.PKIXBuilderParameters):java.security.cert.X509Certificate[], dex: classes.dex
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
    private java.security.cert.X509Certificate[] doValidate(java.security.cert.X509Certificate[] r1, java.security.cert.PKIXBuilderParameters r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.doValidate(java.security.cert.X509Certificate[], java.security.cert.PKIXBuilderParameters):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.doValidate(java.security.cert.X509Certificate[], java.security.cert.PKIXBuilderParameters):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.security.validator.PKIXValidator.isSignatureValid(java.util.List, java.security.cert.X509Certificate):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    private boolean isSignatureValid(java.util.List<java.security.PublicKey> r1, java.security.cert.X509Certificate r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.security.validator.PKIXValidator.isSignatureValid(java.util.List, java.security.cert.X509Certificate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.isSignatureValid(java.util.List, java.security.cert.X509Certificate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.PKIXValidator.setDate(java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
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
    private void setDate(java.security.cert.PKIXBuilderParameters r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.PKIXValidator.setDate(java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.setDate(java.security.cert.PKIXBuilderParameters):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.setDefaultParameters(java.lang.String):void, dex: classes.dex
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
    private void setDefaultParameters(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.setDefaultParameters(java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.setDefaultParameters(java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.PKIXValidator.toArray(java.security.cert.CertPath, java.security.cert.TrustAnchor):java.security.cert.X509Certificate[], dex: classes.dex
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
    private static java.security.cert.X509Certificate[] toArray(java.security.cert.CertPath r1, java.security.cert.TrustAnchor r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.validator.PKIXValidator.toArray(java.security.cert.CertPath, java.security.cert.TrustAnchor):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.toArray(java.security.cert.CertPath, java.security.cert.TrustAnchor):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.engineValidate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
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
    java.security.cert.X509Certificate[] engineValidate(java.security.cert.X509Certificate[] r1, java.util.Collection<java.security.cert.X509Certificate> r2, java.security.AlgorithmConstraints r3, java.lang.Object r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.engineValidate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.engineValidate(java.security.cert.X509Certificate[], java.util.Collection, java.security.AlgorithmConstraints, java.lang.Object):java.security.cert.X509Certificate[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.validator.PKIXValidator.getCertPathLength():int, dex: classes.dex in method: sun.security.validator.PKIXValidator.getCertPathLength():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.validator.PKIXValidator.getCertPathLength():int, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
        	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public int getCertPathLength() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.validator.PKIXValidator.getCertPathLength():int, dex: classes.dex in method: sun.security.validator.PKIXValidator.getCertPathLength():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.getCertPathLength():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.validator.PKIXValidator.getParameters():java.security.cert.PKIXBuilderParameters, dex: classes.dex in method: sun.security.validator.PKIXValidator.getParameters():java.security.cert.PKIXBuilderParameters, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.validator.PKIXValidator.getParameters():java.security.cert.PKIXBuilderParameters, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public java.security.cert.PKIXBuilderParameters getParameters() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.validator.PKIXValidator.getParameters():java.security.cert.PKIXBuilderParameters, dex: classes.dex in method: sun.security.validator.PKIXValidator.getParameters():java.security.cert.PKIXBuilderParameters, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.getParameters():java.security.cert.PKIXBuilderParameters");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.getTrustedCertificates():java.util.Collection<java.security.cert.X509Certificate>, dex: classes.dex
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
    public java.util.Collection<java.security.cert.X509Certificate> getTrustedCertificates() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.validator.PKIXValidator.getTrustedCertificates():java.util.Collection<java.security.cert.X509Certificate>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.validator.PKIXValidator.getTrustedCertificates():java.util.Collection");
    }
}
