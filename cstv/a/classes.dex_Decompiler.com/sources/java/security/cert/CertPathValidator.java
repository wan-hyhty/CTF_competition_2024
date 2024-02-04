package java.security.cert;

import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.Security;
import sun.security.jca.GetInstance;
import sun.security.validator.Validator;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class CertPathValidator {
    private static final String CPV_TYPE = "certpathvalidator.type";
    private final String algorithm;
    private final Provider provider;
    private final CertPathValidatorSpi validatorSpi;

    protected CertPathValidator(CertPathValidatorSpi validatorSpi2, Provider provider2, String algorithm2) {
        this.validatorSpi = validatorSpi2;
        this.provider = provider2;
        this.algorithm = algorithm2;
    }

    public static CertPathValidator getInstance(String algorithm2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("CertPathValidator", CertPathValidatorSpi.class, algorithm2);
        return new CertPathValidator((CertPathValidatorSpi) instance.impl, instance.provider, algorithm2);
    }

    public static CertPathValidator getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = GetInstance.getInstance("CertPathValidator", CertPathValidatorSpi.class, algorithm2, provider2);
        return new CertPathValidator((CertPathValidatorSpi) instance.impl, instance.provider, algorithm2);
    }

    public static CertPathValidator getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("CertPathValidator", CertPathValidatorSpi.class, algorithm2, provider2);
        return new CertPathValidator((CertPathValidatorSpi) instance.impl, instance.provider, algorithm2);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final CertPathValidatorResult validate(CertPath certPath, CertPathParameters params) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        return this.validatorSpi.engineValidate(certPath, params);
    }

    public static final String getDefaultType() {
        String cpvtype = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertPathValidator.1.run():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 5 more
                */
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertPathValidator.1.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathValidator.AnonymousClass1.run():java.lang.Object");
            }

            public String run() {
                return Security.getProperty(CertPathValidator.CPV_TYPE);
            }
        });
        return cpvtype == null ? Validator.TYPE_PKIX : cpvtype;
    }

    public final CertPathChecker getRevocationChecker() {
        return this.validatorSpi.engineGetRevocationChecker();
    }
}
