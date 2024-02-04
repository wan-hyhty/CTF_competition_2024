package java.security;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import sun.security.jca.GetInstance;
import sun.security.jca.ServiceId;
import sun.security.util.Debug;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class Signature extends SignatureSpi {
    private static final String RSA_CIPHER = "RSA/ECB/PKCS1Padding";
    private static final String RSA_SIGNATURE = "NONEwithRSA";
    protected static final int SIGN = 2;
    protected static final int UNINITIALIZED = 0;
    protected static final int VERIFY = 3;
    /* access modifiers changed from: private */
    public static final Debug debug = null;
    /* access modifiers changed from: private */
    public static final List<ServiceId> rsaIds = null;
    private static final Map<String, Boolean> signatureInfo = null;
    /* access modifiers changed from: private */
    public String algorithm;
    Provider provider;
    protected int state;

    protected Signature(String algorithm2) {
        this.state = 0;
        this.algorithm = algorithm2;
    }

    public static Signature getInstance(String algorithm2) throws NoSuchAlgorithmException {
        List<Provider.Service> list;
        if (algorithm2.equalsIgnoreCase(RSA_SIGNATURE)) {
            list = GetInstance.getServices(rsaIds);
        } else {
            list = GetInstance.getServices("Signature", algorithm2);
        }
        Iterator<Provider.Service> t = list.iterator();
        if (!t.hasNext()) {
            throw new NoSuchAlgorithmException(algorithm2 + " Signature not available");
        }
        do {
            Provider.Service s = t.next();
            if (isSpi(s)) {
                return new Delegate(algorithm2);
            }
            try {
                return getInstance(GetInstance.getInstance(s, SignatureSpi.class), algorithm2);
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException noSuchAlgorithmException = e;
                if (!t.hasNext()) {
                    throw e;
                }
            }
        } while (!t.hasNext());
        throw e;
    }

    private static Signature getInstance(GetInstance.Instance instance, String algorithm2) {
        Signature sig;
        if (instance.impl instanceof Signature) {
            sig = (Signature) instance.impl;
        } else {
            sig = new Delegate((SignatureSpi) instance.impl, algorithm2);
        }
        sig.provider = instance.provider;
        return sig;
    }

    /* access modifiers changed from: private */
    public static boolean isSpi(Provider.Service s) {
        boolean r;
        if (s.getType().equals("Cipher")) {
            return true;
        }
        String className = s.getClassName();
        Boolean result = signatureInfo.get(className);
        if (result == null) {
            try {
                Object instance = s.newInstance((Object) null);
                if (instance instanceof SignatureSpi) {
                    r = !(instance instanceof Signature);
                } else {
                    r = false;
                }
                if (debug != null && !r) {
                    debug.println("Not a SignatureSpi " + className);
                    debug.println("Delayed provider selection may not be available for algorithm " + s.getAlgorithm());
                }
                result = Boolean.valueOf(r);
                signatureInfo.put(className, result);
            } catch (Exception e) {
                return false;
            }
        }
        return result.booleanValue();
    }

    public static Signature getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (!algorithm2.equalsIgnoreCase(RSA_SIGNATURE)) {
            return getInstance(GetInstance.getInstance("Signature", SignatureSpi.class, algorithm2, provider2), algorithm2);
        }
        if (provider2 == null || provider2.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        Provider p = Security.getProvider(provider2);
        if (p != null) {
            return getInstanceRSA(p);
        }
        throw new NoSuchProviderException("no such provider: " + provider2);
    }

    public static Signature getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        if (!algorithm2.equalsIgnoreCase(RSA_SIGNATURE)) {
            return getInstance(GetInstance.getInstance("Signature", SignatureSpi.class, algorithm2, provider2), algorithm2);
        }
        if (provider2 != null) {
            return getInstanceRSA(provider2);
        }
        throw new IllegalArgumentException("missing provider");
    }

    private static Signature getInstanceRSA(Provider p) throws NoSuchAlgorithmException {
        Provider.Service s = p.getService("Signature", RSA_SIGNATURE);
        if (s != null) {
            return getInstance(GetInstance.getInstance(s, SignatureSpi.class), RSA_SIGNATURE);
        }
        try {
            return new Delegate(new CipherAdapter(Cipher.getInstance(RSA_CIPHER, p)), RSA_SIGNATURE);
        } catch (GeneralSecurityException e) {
            throw new NoSuchAlgorithmException("no such algorithm: NONEwithRSA for provider " + p.getName(), e);
        }
    }

    public final Provider getProvider() {
        chooseFirstProvider();
        return this.provider;
    }

    /* access modifiers changed from: package-private */
    public void chooseFirstProvider() {
    }

    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        engineInitVerify(publicKey);
        this.state = 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (java.security.cert.X509Certificate) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initVerify(java.security.cert.Certificate r7) throws java.security.InvalidKeyException {
        /*
            r6 = this;
            boolean r4 = r7 instanceof java.security.cert.X509Certificate
            if (r4 == 0) goto L_0x0013
            r0 = r7
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.util.Set r1 = r0.getCriticalExtensionOIDs()
            if (r1 == 0) goto L_0x0013
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x001e
        L_0x0013:
            java.security.PublicKey r3 = r7.getPublicKey()
            r6.engineInitVerify(r3)
            r4 = 3
            r6.state = r4
            return
        L_0x001e:
            java.lang.String r4 = "2.5.29.15"
            boolean r4 = r1.contains(r4)
            if (r4 == 0) goto L_0x0013
            boolean[] r2 = r0.getKeyUsage()
            if (r2 == 0) goto L_0x0013
            r4 = 0
            boolean r4 = r2[r4]
            if (r4 != 0) goto L_0x0013
            java.security.InvalidKeyException r4 = new java.security.InvalidKeyException
            java.lang.String r5 = "Wrong key usage"
            r4.<init>((java.lang.String) r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.initVerify(java.security.cert.Certificate):void");
    }

    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        engineInitSign(privateKey);
        this.state = 2;
    }

    public final void initSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        engineInitSign(privateKey, random);
        this.state = 2;
    }

    public final byte[] sign() throws SignatureException {
        if (this.state == 2) {
            return engineSign();
        }
        throw new SignatureException("object not initialized for signing");
    }

    public final int sign(byte[] outbuf, int offset, int len) throws SignatureException {
        if (outbuf == null) {
            throw new IllegalArgumentException("No output buffer given");
        } else if (outbuf.length - offset < len) {
            throw new IllegalArgumentException("Output buffer too small for specified offset and length");
        } else if (this.state == 2) {
            return engineSign(outbuf, offset, len);
        } else {
            throw new SignatureException("object not initialized for signing");
        }
    }

    public final boolean verify(byte[] signature) throws SignatureException {
        if (this.state == 3) {
            return engineVerify(signature);
        }
        throw new SignatureException("object not initialized for verification");
    }

    public final boolean verify(byte[] signature, int offset, int length) throws SignatureException {
        if (this.state != 3) {
            throw new SignatureException("object not initialized for verification");
        } else if (signature != null && offset >= 0 && length >= 0 && length <= signature.length - offset) {
            return engineVerify(signature, offset, length);
        } else {
            throw new IllegalArgumentException("Bad arguments");
        }
    }

    public final void update(byte b) throws SignatureException {
        if (this.state == 3 || this.state == 2) {
            engineUpdate(b);
            return;
        }
        throw new SignatureException("object not initialized for signature or verification");
    }

    public final void update(byte[] data) throws SignatureException {
        update(data, 0, data.length);
    }

    public final void update(byte[] data, int off, int len) throws SignatureException {
        if (data == null) {
            throw new IllegalArgumentException("data == null");
        } else if (off < 0 || len < 0 || off + len > data.length) {
            throw new IllegalArgumentException();
        } else if (this.state == 2 || this.state == 3) {
            engineUpdate(data, off, len);
        } else {
            throw new SignatureException("object not initialized for signature or verification");
        }
    }

    public final void update(ByteBuffer data) throws SignatureException {
        if (this.state != 2 && this.state != 3) {
            throw new SignatureException("object not initialized for signature or verification");
        } else if (data == null) {
            throw new NullPointerException();
        } else {
            engineUpdate(data);
        }
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public String toString() {
        String initState = "";
        switch (this.state) {
            case 0:
                initState = "<not initialized>";
                break;
            case 2:
                initState = "<initialized for signing>";
                break;
            case 3:
                initState = "<initialized for verifying>";
                break;
        }
        return "Signature object: " + getAlgorithm() + initState;
    }

    @Deprecated
    public final void setParameter(String param, Object value) throws InvalidParameterException {
        engineSetParameter(param, value);
    }

    public final void setParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        engineSetParameter(params);
    }

    public final AlgorithmParameters getParameters() {
        return engineGetParameters();
    }

    @Deprecated
    public final Object getParameter(String param) throws InvalidParameterException {
        return engineGetParameter(param);
    }

    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }

    public SignatureSpi getCurrentSpi() {
        return null;
    }

    private static class Delegate extends Signature {
        private static final int I_PRIV = 2;
        private static final int I_PRIV_SR = 3;
        private static final int I_PUB = 1;
        private static int warnCount;
        private final Object lock;
        private SignatureSpi sigSpi;

        Delegate(SignatureSpi sigSpi2, String algorithm) {
            super(algorithm);
            this.sigSpi = sigSpi2;
            this.lock = null;
        }

        Delegate(String algorithm) {
            super(algorithm);
            this.lock = new Object();
        }

        public Object clone() throws CloneNotSupportedException {
            chooseFirstProvider();
            if (this.sigSpi instanceof Cloneable) {
                Signature that = new Delegate((SignatureSpi) this.sigSpi.clone(), this.algorithm);
                that.provider = this.provider;
                return that;
            }
            throw new CloneNotSupportedException();
        }

        private static SignatureSpi newInstance(Provider.Service s) throws NoSuchAlgorithmException {
            if (s.getType().equals("Cipher")) {
                try {
                    return new CipherAdapter(Cipher.getInstance(Signature.RSA_CIPHER, s.getProvider()));
                } catch (NoSuchPaddingException e) {
                    throw new NoSuchAlgorithmException((Throwable) e);
                }
            } else {
                Object o = s.newInstance((Object) null);
                if (o instanceof SignatureSpi) {
                    return (SignatureSpi) o;
                }
                throw new NoSuchAlgorithmException("Not a SignatureSpi: " + o.getClass().getName());
            }
        }

        /* access modifiers changed from: package-private */
        public void chooseFirstProvider() {
            List<Provider.Service> list;
            if (this.sigSpi == null) {
                synchronized (this.lock) {
                    if (this.sigSpi == null) {
                        if (Signature.debug != null) {
                            int w = warnCount - 1;
                            warnCount = w;
                            if (w >= 0) {
                                Signature.debug.println("Signature.init() not first method called, disabling delayed provider selection");
                                if (w == 0) {
                                    Signature.debug.println("Further warnings of this type will be suppressed");
                                }
                                new Exception("Call trace").printStackTrace();
                            }
                        }
                        Exception lastException = null;
                        if (this.algorithm.equalsIgnoreCase(Signature.RSA_SIGNATURE)) {
                            list = GetInstance.getServices(Signature.rsaIds);
                        } else {
                            list = GetInstance.getServices("Signature", this.algorithm);
                        }
                        for (Provider.Service s : list) {
                            if (Signature.isSpi(s)) {
                                try {
                                    this.sigSpi = newInstance(s);
                                    this.provider = s.getProvider();
                                    return;
                                } catch (NoSuchAlgorithmException e) {
                                    lastException = e;
                                }
                            }
                        }
                        ProviderException e2 = new ProviderException("Could not construct SignatureSpi instance");
                        if (lastException != null) {
                            e2.initCause(lastException);
                        }
                        throw e2;
                    }
                }
            }
        }

        private void chooseProvider(int type, Key key, SecureRandom random) throws InvalidKeyException {
            List<Provider.Service> list;
            synchronized (this.lock) {
                if (this.sigSpi == null || key != null) {
                    Exception lastException = null;
                    if (this.algorithm.equalsIgnoreCase(Signature.RSA_SIGNATURE)) {
                        list = GetInstance.getServices(Signature.rsaIds);
                    } else {
                        list = GetInstance.getServices("Signature", this.algorithm);
                    }
                    for (Provider.Service s : list) {
                        if (s.supportsParameter(key) && Signature.isSpi(s)) {
                            try {
                                SignatureSpi spi = newInstance(s);
                                init(spi, type, key, random);
                                this.provider = s.getProvider();
                                this.sigSpi = spi;
                                return;
                            } catch (Exception e) {
                                if (lastException == null) {
                                    lastException = e;
                                }
                                if (lastException instanceof InvalidKeyException) {
                                    throw ((InvalidKeyException) lastException);
                                }
                            }
                        }
                    }
                    if (lastException instanceof InvalidKeyException) {
                        throw ((InvalidKeyException) lastException);
                    } else if (lastException instanceof RuntimeException) {
                        throw ((RuntimeException) lastException);
                    } else {
                        throw new InvalidKeyException("No installed provider supports this key: " + (key != null ? key.getClass().getName() : "(null)"), lastException);
                    }
                } else {
                    init(this.sigSpi, type, key, random);
                }
            }
        }

        private void init(SignatureSpi spi, int type, Key key, SecureRandom random) throws InvalidKeyException {
            switch (type) {
                case 1:
                    spi.engineInitVerify((PublicKey) key);
                    return;
                case 2:
                    spi.engineInitSign((PrivateKey) key);
                    return;
                case 3:
                    spi.engineInitSign((PrivateKey) key, random);
                    return;
                default:
                    throw new AssertionError((Object) "Internal error: " + type);
            }
        }

        /* access modifiers changed from: protected */
        public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
            if (this.sigSpi == null || !(this.lock == null || publicKey == null)) {
                chooseProvider(1, publicKey, (SecureRandom) null);
            } else {
                this.sigSpi.engineInitVerify(publicKey);
            }
        }

        /* access modifiers changed from: protected */
        public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            if (this.sigSpi == null || !(this.lock == null || privateKey == null)) {
                chooseProvider(2, privateKey, (SecureRandom) null);
            } else {
                this.sigSpi.engineInitSign(privateKey);
            }
        }

        /* access modifiers changed from: protected */
        public void engineInitSign(PrivateKey privateKey, SecureRandom sr) throws InvalidKeyException {
            if (this.sigSpi == null || !(this.lock == null || privateKey == null)) {
                chooseProvider(3, privateKey, sr);
            } else {
                this.sigSpi.engineInitSign(privateKey, sr);
            }
        }

        /* access modifiers changed from: protected */
        public void engineUpdate(byte b) throws SignatureException {
            chooseFirstProvider();
            this.sigSpi.engineUpdate(b);
        }

        /* access modifiers changed from: protected */
        public void engineUpdate(byte[] b, int off, int len) throws SignatureException {
            chooseFirstProvider();
            this.sigSpi.engineUpdate(b, off, len);
        }

        /* access modifiers changed from: protected */
        public void engineUpdate(ByteBuffer data) {
            chooseFirstProvider();
            this.sigSpi.engineUpdate(data);
        }

        /* access modifiers changed from: protected */
        public byte[] engineSign() throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineSign();
        }

        /* access modifiers changed from: protected */
        public int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineSign(outbuf, offset, len);
        }

        /* access modifiers changed from: protected */
        public boolean engineVerify(byte[] sigBytes) throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineVerify(sigBytes);
        }

        /* access modifiers changed from: protected */
        public boolean engineVerify(byte[] sigBytes, int offset, int length) throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineVerify(sigBytes, offset, length);
        }

        /* access modifiers changed from: protected */
        public void engineSetParameter(String param, Object value) throws InvalidParameterException {
            chooseFirstProvider();
            this.sigSpi.engineSetParameter(param, value);
        }

        /* access modifiers changed from: protected */
        public void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
            chooseFirstProvider();
            this.sigSpi.engineSetParameter(params);
        }

        /* access modifiers changed from: protected */
        public Object engineGetParameter(String param) throws InvalidParameterException {
            chooseFirstProvider();
            return this.sigSpi.engineGetParameter(param);
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGetParameters() {
            chooseFirstProvider();
            return this.sigSpi.engineGetParameters();
        }

        public SignatureSpi getCurrentSpi() {
            SignatureSpi signatureSpi;
            synchronized (this.lock) {
                signatureSpi = this.sigSpi;
            }
            return signatureSpi;
        }
    }

    private static class CipherAdapter extends SignatureSpi {
        private final Cipher cipher;
        private ByteArrayOutputStream data;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.Signature.CipherAdapter.<init>(javax.crypto.Cipher):void, dex: classes.dex
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
        CipherAdapter(javax.crypto.Cipher r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.Signature.CipherAdapter.<init>(javax.crypto.Cipher):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.<init>(javax.crypto.Cipher):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineInitSign(java.security.PrivateKey):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected void engineInitSign(java.security.PrivateKey r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineInitSign(java.security.PrivateKey):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.engineInitSign(java.security.PrivateKey):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineInitSign(java.security.PrivateKey, java.security.SecureRandom):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected void engineInitSign(java.security.PrivateKey r1, java.security.SecureRandom r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineInitSign(java.security.PrivateKey, java.security.SecureRandom):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.engineInitSign(java.security.PrivateKey, java.security.SecureRandom):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineInitVerify(java.security.PublicKey):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected void engineInitVerify(java.security.PublicKey r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineInitVerify(java.security.PublicKey):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.engineInitVerify(java.security.PublicKey):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineSign():byte[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected byte[] engineSign() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineSign():byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.engineSign():byte[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.Signature.CipherAdapter.engineUpdate(byte):void, dex: classes.dex
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
        protected void engineUpdate(byte r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.Signature.CipherAdapter.engineUpdate(byte):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.engineUpdate(byte):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineUpdate(byte[], int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected void engineUpdate(byte[] r1, int r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineUpdate(byte[], int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.engineUpdate(byte[], int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineVerify(byte[]):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected boolean engineVerify(byte[] r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.Signature.CipherAdapter.engineVerify(byte[]):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Signature.CipherAdapter.engineVerify(byte[]):boolean");
        }

        /* access modifiers changed from: protected */
        public void engineSetParameter(String param, Object value) throws InvalidParameterException {
            throw new InvalidParameterException("Parameters not supported");
        }

        /* access modifiers changed from: protected */
        public Object engineGetParameter(String param) throws InvalidParameterException {
            throw new InvalidParameterException("Parameters not supported");
        }
    }
}
