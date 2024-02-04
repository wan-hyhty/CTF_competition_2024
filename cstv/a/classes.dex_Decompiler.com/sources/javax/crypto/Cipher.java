package javax.crypto;

import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import sun.security.util.Debug;

public class Cipher {

    /* renamed from: -javax-crypto-Cipher$InitTypeSwitchesValues  reason: not valid java name */
    private static final /* synthetic */ int[] f104javaxcryptoCipher$InitTypeSwitchesValues = null;
    private static final String ATTRIBUTE_MODES = "SupportedModes";
    private static final String ATTRIBUTE_PADDINGS = "SupportedPaddings";
    public static final int DECRYPT_MODE = 2;
    public static final int ENCRYPT_MODE = 1;
    private static final String KEY_USAGE_EXTENSION_OID = "2.5.29.15";
    public static final int PRIVATE_KEY = 2;
    public static final int PUBLIC_KEY = 1;
    public static final int SECRET_KEY = 3;
    public static final int UNWRAP_MODE = 4;
    public static final int WRAP_MODE = 3;
    private static final Debug debug = null;
    private ExemptionMechanism exmech;
    private boolean initialized = false;
    private int opmode = 0;
    /* access modifiers changed from: private */
    public Provider provider;
    /* access modifiers changed from: private */
    public CipherSpi spi;
    private final SpiAndProviderUpdater spiAndProviderUpdater;
    /* access modifiers changed from: private */
    public final String[] tokenizedTransformation;
    private final String transformation;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    enum InitType {
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    enum NeedToSet {
    }

    /* renamed from: -getjavax-crypto-Cipher$InitTypeSwitchesValues  reason: not valid java name */
    private static /* synthetic */ int[] m631getjavaxcryptoCipher$InitTypeSwitchesValues() {
        if (f104javaxcryptoCipher$InitTypeSwitchesValues != null) {
            return f104javaxcryptoCipher$InitTypeSwitchesValues;
        }
        int[] iArr = new int[InitType.values().length];
        try {
            iArr[InitType.ALGORITHM_PARAMS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            iArr[InitType.ALGORITHM_PARAM_SPEC.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            iArr[InitType.KEY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        f104javaxcryptoCipher$InitTypeSwitchesValues = iArr;
        return iArr;
    }

    protected Cipher(CipherSpi cipherSpi, Provider provider2, String transformation2) {
        if (cipherSpi == null) {
            throw new NullPointerException("cipherSpi == null");
        } else if ((cipherSpi instanceof NullCipherSpi) || provider2 != null) {
            this.spi = cipherSpi;
            this.provider = provider2;
            this.transformation = transformation2;
            this.tokenizedTransformation = null;
            this.spiAndProviderUpdater = new SpiAndProviderUpdater(provider2, cipherSpi);
        } else {
            throw new NullPointerException("provider == null");
        }
    }

    private Cipher(CipherSpi cipherSpi, Provider provider2, String transformation2, String[] tokenizedTransformation2) {
        this.spi = cipherSpi;
        this.provider = provider2;
        this.transformation = transformation2;
        this.tokenizedTransformation = tokenizedTransformation2;
        this.spiAndProviderUpdater = new SpiAndProviderUpdater(provider2, cipherSpi);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] tokenizeTransformation(java.lang.String r8) throws java.security.NoSuchAlgorithmException {
        /*
            r7 = 3
            r6 = 0
            if (r8 == 0) goto L_0x000a
            boolean r5 = r8.isEmpty()
            if (r5 == 0) goto L_0x0013
        L_0x000a:
            java.security.NoSuchAlgorithmException r5 = new java.security.NoSuchAlgorithmException
            java.lang.String r6 = "No transformation given"
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0013:
            java.lang.String[] r4 = new java.lang.String[r7]
            r0 = 0
            java.util.StringTokenizer r3 = new java.util.StringTokenizer
            java.lang.String r5 = "/"
            r3.<init>(r8, r5)
            r1 = r0
        L_0x001f:
            boolean r5 = r3.hasMoreTokens()     // Catch:{ NoSuchElementException -> 0x0054 }
            if (r5 == 0) goto L_0x0035
            if (r1 >= r7) goto L_0x0035
            int r0 = r1 + 1
            java.lang.String r5 = r3.nextToken()     // Catch:{ NoSuchElementException -> 0x009d }
            java.lang.String r5 = r5.trim()     // Catch:{ NoSuchElementException -> 0x009d }
            r4[r1] = r5     // Catch:{ NoSuchElementException -> 0x009d }
            r1 = r0
            goto L_0x001f
        L_0x0035:
            if (r1 == 0) goto L_0x003a
            r5 = 2
            if (r1 != r5) goto L_0x0070
        L_0x003a:
            java.security.NoSuchAlgorithmException r5 = new java.security.NoSuchAlgorithmException     // Catch:{ NoSuchElementException -> 0x0054 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NoSuchElementException -> 0x0054 }
            r6.<init>()     // Catch:{ NoSuchElementException -> 0x0054 }
            java.lang.String r7 = "Invalid transformation format:"
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)     // Catch:{ NoSuchElementException -> 0x0054 }
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r8)     // Catch:{ NoSuchElementException -> 0x0054 }
            java.lang.String r6 = r6.toString()     // Catch:{ NoSuchElementException -> 0x0054 }
            r5.<init>((java.lang.String) r6)     // Catch:{ NoSuchElementException -> 0x0054 }
            throw r5     // Catch:{ NoSuchElementException -> 0x0054 }
        L_0x0054:
            r2 = move-exception
            r0 = r1
        L_0x0056:
            java.security.NoSuchAlgorithmException r5 = new java.security.NoSuchAlgorithmException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid transformation format:"
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r8)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0070:
            boolean r5 = r3.hasMoreTokens()     // Catch:{ NoSuchElementException -> 0x0054 }
            if (r5 != 0) goto L_0x003a
            r5 = r4[r6]
            if (r5 == 0) goto L_0x0082
            r5 = r4[r6]
            int r5 = r5.length()
            if (r5 != 0) goto L_0x009c
        L_0x0082:
            java.security.NoSuchAlgorithmException r5 = new java.security.NoSuchAlgorithmException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid transformation:algorithm not specified-"
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r8)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x009c:
            return r4
        L_0x009d:
            r2 = move-exception
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.Cipher.tokenizeTransformation(java.lang.String):java.lang.String[]");
    }

    public static final Cipher getInstance(String transformation2) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return createCipher(transformation2, (Provider) null);
    }

    public static final Cipher getInstance(String transformation2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
        if (provider2 == null || provider2.length() == 0) {
            throw new IllegalArgumentException("Missing provider");
        }
        Provider p = Security.getProvider(provider2);
        if (p != null) {
            return createCipher(transformation2, p);
        }
        throw new NoSuchProviderException("No such provider: " + provider2);
    }

    public static final Cipher getInstance(String transformation2, Provider provider2) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (provider2 != null) {
            return createCipher(transformation2, provider2);
        }
        throw new IllegalArgumentException("Missing provider");
    }

    static final Cipher createCipher(String transformation2, Provider provider2) throws NoSuchAlgorithmException, NoSuchPaddingException {
        String[] tokenizedTransformation2 = tokenizeTransformation(transformation2);
        try {
            if (tryCombinations((InitParams) null, provider2, tokenizedTransformation2) != null) {
                return new Cipher((CipherSpi) null, provider2, transformation2, tokenizedTransformation2);
            }
            if (provider2 == null) {
                throw new NoSuchAlgorithmException("No provider found for " + transformation2);
            }
            throw new NoSuchAlgorithmException("Provider " + provider2.getName() + " does not provide " + transformation2);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
            throw new IllegalStateException("Key/Algorithm excepton despite not passing one", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateProviderIfNeeded() {
        try {
            this.spiAndProviderUpdater.updateAndGetSpiAndProvider((InitParams) null, this.spi, this.provider);
        } catch (Exception lastException) {
            ProviderException e = new ProviderException("Could not construct CipherSpi instance");
            if (lastException != null) {
                e.initCause(lastException);
            }
            throw e;
        }
    }

    private void chooseProvider(InitType initType, int opmode2, Key key, AlgorithmParameterSpec paramSpec, AlgorithmParameters params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            this.spiAndProviderUpdater.updateAndGetSpiAndProvider(new InitParams(initType, opmode2, key, random, paramSpec, params), this.spi, this.provider);
        } catch (Exception lastException) {
            if (lastException instanceof InvalidKeyException) {
                throw ((InvalidKeyException) lastException);
            } else if (lastException instanceof InvalidAlgorithmParameterException) {
                throw ((InvalidAlgorithmParameterException) lastException);
            } else if (lastException instanceof RuntimeException) {
                throw ((RuntimeException) lastException);
            } else {
                throw new InvalidKeyException("No installed provider supports this key: " + (key != null ? key.getClass().getName() : "(null)"), lastException);
            }
        }
    }

    public final Provider getProvider() {
        updateProviderIfNeeded();
        return this.provider;
    }

    public final String getAlgorithm() {
        return this.transformation;
    }

    public final int getBlockSize() {
        updateProviderIfNeeded();
        return this.spi.engineGetBlockSize();
    }

    public final int getOutputSize(int inputLen) {
        if (!this.initialized && !(this instanceof NullCipher)) {
            throw new IllegalStateException("Cipher not initialized");
        } else if (inputLen < 0) {
            throw new IllegalArgumentException("Input size must be equal to or greater than zero");
        } else {
            updateProviderIfNeeded();
            return this.spi.engineGetOutputSize(inputLen);
        }
    }

    public final byte[] getIV() {
        updateProviderIfNeeded();
        return this.spi.engineGetIV();
    }

    public final AlgorithmParameters getParameters() {
        updateProviderIfNeeded();
        return this.spi.engineGetParameters();
    }

    public final ExemptionMechanism getExemptionMechanism() {
        updateProviderIfNeeded();
        return this.exmech;
    }

    private static void checkOpmode(int opmode2) {
        if (opmode2 < 1 || opmode2 > 4) {
            throw new InvalidParameterException("Invalid operation mode");
        }
    }

    public final void init(int opmode2, Key key) throws InvalidKeyException {
        init(opmode2, key, JceSecurity.RANDOM);
    }

    public final void init(int opmode2, Key key, SecureRandom random) throws InvalidKeyException {
        this.initialized = false;
        checkOpmode(opmode2);
        try {
            chooseProvider(InitType.KEY, opmode2, key, (AlgorithmParameterSpec) null, (AlgorithmParameters) null, random);
            this.initialized = true;
            this.opmode = opmode2;
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException((Throwable) e);
        }
    }

    public final void init(int opmode2, Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        init(opmode2, key, params, JceSecurity.RANDOM);
    }

    public final void init(int opmode2, Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.initialized = false;
        checkOpmode(opmode2);
        chooseProvider(InitType.ALGORITHM_PARAM_SPEC, opmode2, key, params, (AlgorithmParameters) null, random);
        this.initialized = true;
        this.opmode = opmode2;
    }

    public final void init(int opmode2, Key key, AlgorithmParameters params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        init(opmode2, key, params, JceSecurity.RANDOM);
    }

    public final void init(int opmode2, Key key, AlgorithmParameters params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.initialized = false;
        checkOpmode(opmode2);
        chooseProvider(InitType.ALGORITHM_PARAMS, opmode2, key, (AlgorithmParameterSpec) null, params, random);
        this.initialized = true;
        this.opmode = opmode2;
    }

    public final void init(int opmode2, Certificate certificate) throws InvalidKeyException {
        init(opmode2, certificate, JceSecurity.RANDOM);
    }

    public final void init(int opmode2, Certificate certificate, SecureRandom random) throws InvalidKeyException {
        X509Certificate cert;
        Set critSet;
        boolean[] keyUsageInfo;
        this.initialized = false;
        checkOpmode(opmode2);
        if (!(certificate instanceof X509Certificate) || (critSet = (cert = (X509Certificate) certificate).getCriticalExtensionOIDs()) == null || critSet.isEmpty() || !critSet.contains(KEY_USAGE_EXTENSION_OID) || (keyUsageInfo = cert.getKeyUsage()) == null || ((opmode2 != 1 || keyUsageInfo.length <= 3 || keyUsageInfo[3]) && (opmode2 != 3 || keyUsageInfo.length <= 2 || keyUsageInfo[2]))) {
            try {
                chooseProvider(InitType.KEY, opmode2, certificate == null ? null : certificate.getPublicKey(), (AlgorithmParameterSpec) null, (AlgorithmParameters) null, random);
                this.initialized = true;
                this.opmode = opmode2;
            } catch (InvalidAlgorithmParameterException e) {
                throw new InvalidKeyException((Throwable) e);
            }
        } else {
            throw new InvalidKeyException("Wrong key usage");
        }
    }

    private void checkCipherState() {
        if (this instanceof NullCipher) {
            return;
        }
        if (!this.initialized) {
            throw new IllegalStateException("Cipher not initialized");
        } else if (this.opmode != 1 && this.opmode != 2) {
            throw new IllegalStateException("Cipher not initialized for encryption/decryption");
        }
    }

    public final byte[] update(byte[] input) {
        checkCipherState();
        if (input == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        updateProviderIfNeeded();
        if (input.length == 0) {
            return null;
        }
        return this.spi.engineUpdate(input, 0, input.length);
    }

    public final byte[] update(byte[] input, int inputOffset, int inputLen) {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (inputLen == 0) {
            return null;
        }
        return this.spi.engineUpdate(input, inputOffset, inputLen);
    }

    public final int update(byte[] input, int inputOffset, int inputLen, byte[] output) throws ShortBufferException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (inputLen == 0) {
            return 0;
        }
        return this.spi.engineUpdate(input, inputOffset, inputLen, output, 0);
    }

    public final int update(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws ShortBufferException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0 || outputOffset < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (inputLen == 0) {
            return 0;
        }
        return this.spi.engineUpdate(input, inputOffset, inputLen, output, outputOffset);
    }

    public final int update(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        checkCipherState();
        if (input == null || output == null) {
            throw new IllegalArgumentException("Buffers must not be null");
        } else if (input == output) {
            throw new IllegalArgumentException("Input and output buffers must not be the same object, consider using buffer.duplicate()");
        } else if (output.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else {
            updateProviderIfNeeded();
            return this.spi.engineUpdate(input, output);
        }
    }

    public final byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        updateProviderIfNeeded();
        return this.spi.engineDoFinal((byte[]) null, 0, 0);
    }

    public final int doFinal(byte[] output, int outputOffset) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        checkCipherState();
        if (output == null || outputOffset < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal((byte[]) null, 0, 0, output, outputOffset);
    }

    public final byte[] doFinal(byte[] input) throws IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, 0, input.length);
    }

    public final byte[] doFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, inputOffset, inputLen);
    }

    public final int doFinal(byte[] input, int inputOffset, int inputLen, byte[] output) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, inputOffset, inputLen, output, 0);
    }

    public final int doFinal(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || inputOffset < 0 || inputLen > input.length - inputOffset || inputLen < 0 || outputOffset < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        return this.spi.engineDoFinal(input, inputOffset, inputLen, output, outputOffset);
    }

    public final int doFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        checkCipherState();
        if (input == null || output == null) {
            throw new IllegalArgumentException("Buffers must not be null");
        } else if (input == output) {
            throw new IllegalArgumentException("Input and output buffers must not be the same object, consider using buffer.duplicate()");
        } else if (output.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else {
            updateProviderIfNeeded();
            return this.spi.engineDoFinal(input, output);
        }
    }

    public final byte[] wrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (!(this instanceof NullCipher)) {
            if (!this.initialized) {
                throw new IllegalStateException("Cipher not initialized");
            } else if (this.opmode != 3) {
                throw new IllegalStateException("Cipher not initialized for wrapping keys");
            }
        }
        updateProviderIfNeeded();
        return this.spi.engineWrap(key);
    }

    public final Key unwrap(byte[] wrappedKey, String wrappedKeyAlgorithm, int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        if (!(this instanceof NullCipher)) {
            if (!this.initialized) {
                throw new IllegalStateException("Cipher not initialized");
            } else if (this.opmode != 4) {
                throw new IllegalStateException("Cipher not initialized for unwrapping keys");
            }
        }
        if (wrappedKeyType == 3 || wrappedKeyType == 2 || wrappedKeyType == 1) {
            updateProviderIfNeeded();
            return this.spi.engineUnwrap(wrappedKey, wrappedKeyAlgorithm, wrappedKeyType);
        }
        throw new InvalidParameterException("Invalid key type");
    }

    private AlgorithmParameterSpec getAlgorithmParameterSpec(AlgorithmParameters params) throws InvalidParameterSpecException {
        if (params == null) {
            return null;
        }
        String alg = params.getAlgorithm().toUpperCase(Locale.ENGLISH);
        if (alg.equalsIgnoreCase("RC2")) {
            return params.getParameterSpec(RC2ParameterSpec.class);
        }
        if (alg.equalsIgnoreCase("RC5")) {
            return params.getParameterSpec(RC5ParameterSpec.class);
        }
        if (alg.startsWith("PBE")) {
            return params.getParameterSpec(PBEParameterSpec.class);
        }
        if (alg.startsWith("DES")) {
            return params.getParameterSpec(IvParameterSpec.class);
        }
        return null;
    }

    public static final int getMaxAllowedKeyLength(String transformation2) throws NoSuchAlgorithmException {
        if (transformation2 == null) {
            throw new NullPointerException("transformation == null");
        }
        tokenizeTransformation(transformation2);
        return Integer.MAX_VALUE;
    }

    public static final AlgorithmParameterSpec getMaxAllowedParameterSpec(String transformation2) throws NoSuchAlgorithmException {
        if (transformation2 == null) {
            throw new NullPointerException("transformation == null");
        }
        tokenizeTransformation(transformation2);
        return null;
    }

    public final void updateAAD(byte[] src) {
        if (src == null) {
            throw new IllegalArgumentException("src buffer is null");
        }
        updateAAD(src, 0, src.length);
    }

    public final void updateAAD(byte[] src, int offset, int len) {
        checkCipherState();
        if (src == null || offset < 0 || len < 0 || len + offset > src.length) {
            throw new IllegalArgumentException("Bad arguments");
        }
        updateProviderIfNeeded();
        if (len != 0) {
            this.spi.engineUpdateAAD(src, offset, len);
        }
    }

    public final void updateAAD(ByteBuffer src) {
        checkCipherState();
        if (src == null) {
            throw new IllegalArgumentException("src ByteBuffer is null");
        }
        updateProviderIfNeeded();
        if (src.remaining() != 0) {
            this.spi.engineUpdateAAD(src);
        }
    }

    public CipherSpi getCurrentSpi() {
        return this.spi;
    }

    static boolean matchAttribute(Provider.Service service, String attr, String value) {
        String pattern;
        if (value == null || (pattern = service.getAttribute(attr)) == null) {
            return true;
        }
        return value.toUpperCase(Locale.US).matches(pattern.toUpperCase(Locale.US));
    }

    static class Transform {
        /* access modifiers changed from: private */
        public final String name;
        /* access modifiers changed from: private */
        public final NeedToSet needToSet;

        public Transform(String name2, NeedToSet needToSet2) {
            this.name = name2;
            this.needToSet = needToSet2;
        }
    }

    static class InitParams {
        final InitType initType;
        final Key key;
        final int opmode;
        final AlgorithmParameters params;
        final SecureRandom random;
        final AlgorithmParameterSpec spec;

        InitParams(InitType initType2, int opmode2, Key key2, SecureRandom random2, AlgorithmParameterSpec spec2, AlgorithmParameters params2) {
            this.initType = initType2;
            this.opmode = opmode2;
            this.key = key2;
            this.random = random2;
            this.spec = spec2;
            this.params = params2;
        }
    }

    class SpiAndProviderUpdater {
        private final Object initSpiLock = new Object();
        private final Provider specifiedProvider;
        private final CipherSpi specifiedSpi;

        SpiAndProviderUpdater(Provider specifiedProvider2, CipherSpi specifiedSpi2) {
            this.specifiedProvider = specifiedProvider2;
            this.specifiedSpi = specifiedSpi2;
        }

        /* access modifiers changed from: package-private */
        public void setCipherSpiImplAndProvider(CipherSpi cipherSpi, Provider provider) {
            CipherSpi unused = Cipher.this.spi = cipherSpi;
            Provider unused2 = Cipher.this.provider = provider;
        }

        /* access modifiers changed from: package-private */
        public CipherSpiAndProvider updateAndGetSpiAndProvider(InitParams initParams, CipherSpi spiImpl, Provider provider) throws InvalidKeyException, InvalidAlgorithmParameterException {
            if (this.specifiedSpi != null) {
                return new CipherSpiAndProvider(this.specifiedSpi, provider);
            }
            synchronized (this.initSpiLock) {
                if (spiImpl == null || initParams != null) {
                    CipherSpiAndProvider sap = Cipher.tryCombinations(initParams, this.specifiedProvider, Cipher.this.tokenizedTransformation);
                    if (sap == null) {
                        throw new ProviderException("No provider found for " + Arrays.toString((Object[]) Cipher.this.tokenizedTransformation));
                    }
                    setCipherSpiImplAndProvider(sap.cipherSpi, sap.provider);
                    CipherSpiAndProvider cipherSpiAndProvider = new CipherSpiAndProvider(sap.cipherSpi, sap.provider);
                    return cipherSpiAndProvider;
                }
                CipherSpiAndProvider cipherSpiAndProvider2 = new CipherSpiAndProvider(spiImpl, provider);
                return cipherSpiAndProvider2;
            }
        }

        /* access modifiers changed from: package-private */
        public CipherSpiAndProvider updateAndGetSpiAndProvider(CipherSpi spiImpl, Provider provider) {
            try {
                return updateAndGetSpiAndProvider((InitParams) null, spiImpl, provider);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new ProviderException("Exception thrown when params == null", e);
            }
        }

        /* access modifiers changed from: package-private */
        public CipherSpi getCurrentSpi(CipherSpi spiImpl) {
            if (this.specifiedSpi != null) {
                return this.specifiedSpi;
            }
            synchronized (this.initSpiLock) {
            }
            return spiImpl;
        }
    }

    static CipherSpiAndProvider tryCombinations(InitParams initParams, Provider provider2, String[] tokenizedTransformation2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ArrayList<Transform> transforms = new ArrayList<>();
        if (!(tokenizedTransformation2[1] == null || tokenizedTransformation2[2] == null)) {
            transforms.add(new Transform(tokenizedTransformation2[0] + "/" + tokenizedTransformation2[1] + "/" + tokenizedTransformation2[2], NeedToSet.NONE));
        }
        if (tokenizedTransformation2[1] != null) {
            transforms.add(new Transform(tokenizedTransformation2[0] + "/" + tokenizedTransformation2[1], NeedToSet.PADDING));
        }
        if (tokenizedTransformation2[2] != null) {
            transforms.add(new Transform(tokenizedTransformation2[0] + "//" + tokenizedTransformation2[2], NeedToSet.MODE));
        }
        transforms.add(new Transform(tokenizedTransformation2[0], NeedToSet.BOTH));
        Exception cause = null;
        if (provider2 != null) {
            for (Transform transform : transforms) {
                Provider.Service service = provider2.getService("Cipher", transform.name);
                if (service != null) {
                    return tryTransformWithProvider(initParams, tokenizedTransformation2, transform.needToSet, service);
                }
            }
        } else {
            for (Provider prov : Security.getProviders()) {
                for (Transform transform2 : transforms) {
                    Provider.Service service2 = prov.getService("Cipher", transform2.name);
                    if (service2 != null && (initParams == null || initParams.key == null || service2.supportsParameter(initParams.key))) {
                        try {
                            CipherSpiAndProvider sap = tryTransformWithProvider(initParams, tokenizedTransformation2, transform2.needToSet, service2);
                            if (sap != null) {
                                return sap;
                            }
                        } catch (Exception e) {
                            if (cause == null) {
                                cause = e;
                            }
                        }
                    }
                }
            }
        }
        if (cause instanceof InvalidKeyException) {
            throw ((InvalidKeyException) cause);
        } else if (cause instanceof InvalidAlgorithmParameterException) {
            throw ((InvalidAlgorithmParameterException) cause);
        } else if (cause instanceof RuntimeException) {
            throw ((RuntimeException) cause);
        } else if (cause != null) {
            throw new InvalidKeyException("No provider can be initialized with given key", cause);
        } else if (initParams == null || initParams.key == null) {
            return null;
        } else {
            throw new InvalidKeyException("No provider offers " + Arrays.toString((Object[]) tokenizedTransformation2) + " for " + initParams.key.getAlgorithm() + " key of class " + initParams.key.getClass().getName() + " and export format " + initParams.key.getFormat());
        }
    }

    static class CipherSpiAndProvider {
        CipherSpi cipherSpi;
        Provider provider;

        CipherSpiAndProvider(CipherSpi cipherSpi2, Provider provider2) {
            this.cipherSpi = cipherSpi2;
            this.provider = provider2;
        }
    }

    static CipherSpiAndProvider tryTransformWithProvider(InitParams initParams, String[] tokenizedTransformation2, NeedToSet type, Provider.Service service) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            if (!matchAttribute(service, ATTRIBUTE_MODES, tokenizedTransformation2[1]) || !matchAttribute(service, ATTRIBUTE_PADDINGS, tokenizedTransformation2[2])) {
                return null;
            }
            CipherSpiAndProvider sap = new CipherSpiAndProvider((CipherSpi) service.newInstance((Object) null), service.getProvider());
            if (sap.cipherSpi == null || sap.provider == null) {
                return null;
            }
            CipherSpi spi2 = sap.cipherSpi;
            if ((type == NeedToSet.MODE || type == NeedToSet.BOTH) && tokenizedTransformation2[1] != null) {
                spi2.engineSetMode(tokenizedTransformation2[1]);
            }
            if ((type == NeedToSet.PADDING || type == NeedToSet.BOTH) && tokenizedTransformation2[2] != null) {
                spi2.engineSetPadding(tokenizedTransformation2[2]);
            }
            if (initParams != null) {
                switch (m631getjavaxcryptoCipher$InitTypeSwitchesValues()[initParams.initType.ordinal()]) {
                    case 1:
                        spi2.engineInit(initParams.opmode, initParams.key, initParams.params, initParams.random);
                        break;
                    case 2:
                        spi2.engineInit(initParams.opmode, initParams.key, initParams.spec, initParams.random);
                        break;
                    case 3:
                        spi2.engineInit(initParams.opmode, initParams.key, initParams.random);
                        break;
                    default:
                        throw new AssertionError((Object) "This should never be reached");
                }
            }
            return new CipherSpiAndProvider(spi2, sap.provider);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (NoSuchPaddingException e2) {
            return null;
        }
    }
}
