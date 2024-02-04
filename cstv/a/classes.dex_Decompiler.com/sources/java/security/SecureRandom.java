package java.security;

import dalvik.system.VMRuntime;
import java.security.Provider;
import java.util.Iterator;
import java.util.Random;
import sun.security.jca.GetInstance;
import sun.security.jca.Providers;

public class SecureRandom extends Random {
    public static final int DEFAULT_SDK_TARGET_FOR_CRYPTO_PROVIDER_WORKAROUND = 23;
    private static int sdkTargetForCryptoProviderWorkaround = 0;
    private static volatile SecureRandom seedGenerator = null;
    static final long serialVersionUID = 4940670005562187L;
    private String algorithm;
    private long counter;
    private MessageDigest digest;
    private Provider provider;
    private byte[] randomBytes;
    private int randomBytesUsed;
    private SecureRandomSpi secureRandomSpi;
    private byte[] state;

    public SecureRandom() {
        super(0);
        this.provider = null;
        this.secureRandomSpi = null;
        this.digest = null;
        getDefaultPRNG(false, (byte[]) null);
    }

    public SecureRandom(byte[] seed) {
        super(0);
        this.provider = null;
        this.secureRandomSpi = null;
        this.digest = null;
        getDefaultPRNG(true, seed);
    }

    private void getDefaultPRNG(boolean setSeed, byte[] seed) {
        String prng = getPrngAlgorithm();
        if (prng == null) {
            throw new IllegalStateException("No SecureRandom implementation!");
        }
        try {
            SecureRandom random = getInstance(prng);
            this.secureRandomSpi = random.getSecureRandomSpi();
            this.provider = random.getProvider();
            if (setSeed) {
                this.secureRandomSpi.engineSetSeed(seed);
            }
            if (getClass() == SecureRandom.class) {
                this.algorithm = prng;
            }
        } catch (NoSuchAlgorithmException nsae) {
            throw new RuntimeException((Throwable) nsae);
        }
    }

    protected SecureRandom(SecureRandomSpi secureRandomSpi2, Provider provider2) {
        this(secureRandomSpi2, provider2, (String) null);
    }

    private SecureRandom(SecureRandomSpi secureRandomSpi2, Provider provider2, String algorithm2) {
        super(0);
        this.provider = null;
        this.secureRandomSpi = null;
        this.digest = null;
        this.secureRandomSpi = secureRandomSpi2;
        this.provider = provider2;
        this.algorithm = algorithm2;
    }

    public static SecureRandom getInstance(String algorithm2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("SecureRandom", SecureRandomSpi.class, algorithm2);
        return new SecureRandom((SecureRandomSpi) instance.impl, instance.provider, algorithm2);
    }

    public static void setSdkTargetForCryptoProviderWorkaround(int sdkTargetVersion) {
        sdkTargetForCryptoProviderWorkaround = sdkTargetVersion;
    }

    public static int getSdkTargetForCryptoProviderWorkaround() {
        return sdkTargetForCryptoProviderWorkaround;
    }

    public static SecureRandom getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        try {
            GetInstance.Instance instance = GetInstance.getInstance("SecureRandom", SecureRandomSpi.class, algorithm2, provider2);
            return new SecureRandom((SecureRandomSpi) instance.impl, instance.provider, algorithm2);
        } catch (NoSuchProviderException nspe) {
            if ("Crypto".equals(provider2)) {
                System.logE(" ********** PLEASE READ ************ ");
                System.logE(" * ");
                System.logE(" * New versions of the Android SDK no longer support the Crypto provider.");
                System.logE(" * If your app was relying on setSeed() to derive keys from strings, you");
                System.logE(" * should switch to using SecretKeySpec to load raw key bytes directly OR");
                System.logE(" * use a real key derivation function (KDF). See advice here : ");
                System.logE(" * http://android-developers.blogspot.com/2016/06/security-crypto-provider-deprecated-in.html ");
                System.logE(" *********************************** ");
                if (VMRuntime.getRuntime().getTargetSdkVersion() <= sdkTargetForCryptoProviderWorkaround) {
                    System.logE(" Returning an instance of SecureRandom from the Crypto provider");
                    System.logE(" as a temporary measure so that the apps targeting earlier SDKs");
                    System.logE(" keep working. Please do not rely on the presence of the Crypto");
                    System.logE(" provider in the codebase, as our plan is to delete it");
                    System.logE(" completely in the future.");
                    return getInstanceFromCryptoProvider(algorithm2);
                }
            }
            throw nspe;
        }
    }

    private static SecureRandom getInstanceFromCryptoProvider(String algorithm2) throws NoSuchAlgorithmException {
        try {
            GetInstance.Instance instance = GetInstance.getInstance(((Provider) SecureRandom.class.getClassLoader().loadClass("org.apache.harmony.security.provider.crypto.CryptoProvider").newInstance()).getService("SecureRandom", algorithm2), SecureRandomSpi.class);
            return new SecureRandom((SecureRandomSpi) instance.impl, instance.provider, algorithm2);
        } catch (Exception e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static SecureRandom getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("SecureRandom", SecureRandomSpi.class, algorithm2, provider2);
        return new SecureRandom((SecureRandomSpi) instance.impl, instance.provider, algorithm2);
    }

    /* access modifiers changed from: package-private */
    public SecureRandomSpi getSecureRandomSpi() {
        return this.secureRandomSpi;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public String getAlgorithm() {
        return this.algorithm != null ? this.algorithm : "unknown";
    }

    public synchronized void setSeed(byte[] seed) {
        this.secureRandomSpi.engineSetSeed(seed);
    }

    public void setSeed(long seed) {
        if (seed != 0) {
            this.secureRandomSpi.engineSetSeed(longToByteArray(seed));
        }
    }

    public synchronized void nextBytes(byte[] bytes) {
        this.secureRandomSpi.engineNextBytes(bytes);
    }

    /* access modifiers changed from: protected */
    public final int next(int numBits) {
        int numBytes = (numBits + 7) / 8;
        byte[] b = new byte[numBytes];
        int next = 0;
        nextBytes(b);
        for (int i = 0; i < numBytes; i++) {
            next = (next << 8) + (b[i] & Character.DIRECTIONALITY_UNDEFINED);
        }
        return next >>> ((numBytes * 8) - numBits);
    }

    public static byte[] getSeed(int numBytes) {
        if (seedGenerator == null) {
            seedGenerator = new SecureRandom();
        }
        return seedGenerator.generateSeed(numBytes);
    }

    public byte[] generateSeed(int numBytes) {
        return this.secureRandomSpi.engineGenerateSeed(numBytes);
    }

    private static byte[] longToByteArray(long l) {
        byte[] retVal = new byte[8];
        for (int i = 0; i < 8; i++) {
            retVal[i] = (byte) ((int) l);
            l >>= 8;
        }
        return retVal;
    }

    private static String getPrngAlgorithm() {
        for (Provider p : Providers.getProviderList().providers()) {
            Iterator s$iterator = p.getServices().iterator();
            while (true) {
                if (s$iterator.hasNext()) {
                    Provider.Service s = (Provider.Service) s$iterator.next();
                    if (s.getType().equals("SecureRandom")) {
                        return s.getAlgorithm();
                    }
                }
            }
        }
        return null;
    }
}
