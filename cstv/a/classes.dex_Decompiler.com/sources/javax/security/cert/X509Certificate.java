package javax.security.cert;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Date;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class X509Certificate extends Certificate {
    private static final String DEFAULT_X509_CERT_CLASS = null;
    private static String X509Provider = null;
    private static final String X509_PROVIDER = "cert.provider.x509v1";

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: javax.security.cert.X509Certificate.<clinit>():void, dex: classes.dex
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: javax.security.cert.X509Certificate.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.security.cert.X509Certificate.<clinit>():void");
    }

    public abstract void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException;

    public abstract void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException;

    public abstract Principal getIssuerDN();

    public abstract Date getNotAfter();

    public abstract Date getNotBefore();

    public abstract BigInteger getSerialNumber();

    public abstract String getSigAlgName();

    public abstract String getSigAlgOID();

    public abstract byte[] getSigAlgParams();

    public abstract Principal getSubjectDN();

    public abstract int getVersion();

    public X509Certificate() {
    }

    public static final X509Certificate getInstance(InputStream inStream) throws CertificateException {
        return getInst(inStream);
    }

    public static final X509Certificate getInstance(byte[] certData) throws CertificateException {
        return getInst(certData);
    }

    private static final X509Certificate getInst(Object value) throws CertificateException {
        Class[] params;
        String className = X509Provider;
        if (className == null || className.length() == 0) {
            className = DEFAULT_X509_CERT_CLASS;
        }
        try {
            if (value instanceof InputStream) {
                params = new Class[]{InputStream.class};
            } else if (value instanceof byte[]) {
                params = new Class[]{value.getClass()};
            } else {
                throw new CertificateException("Unsupported argument type");
            }
            return (X509Certificate) Class.forName(className).getConstructor(params).newInstance(value);
        } catch (ClassNotFoundException e) {
            throw new CertificateException("Could not find class: " + e);
        } catch (IllegalAccessException e2) {
            throw new CertificateException("Could not access class: " + e2);
        } catch (InstantiationException e3) {
            throw new CertificateException("Problems instantiating: " + e3);
        } catch (InvocationTargetException e4) {
            throw new CertificateException("InvocationTargetException: " + e4.getTargetException());
        } catch (NoSuchMethodException e5) {
            throw new CertificateException("Could not find class method: " + e5.getMessage());
        }
    }
}
