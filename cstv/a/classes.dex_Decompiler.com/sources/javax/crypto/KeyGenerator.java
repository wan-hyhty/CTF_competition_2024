package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import sun.security.jca.GetInstance;

public class KeyGenerator {
    private static final int I_NONE = 1;
    private static final int I_PARAMS = 3;
    private static final int I_RANDOM = 2;
    private static final int I_SIZE = 4;
    private final String algorithm;
    private int initKeySize;
    private AlgorithmParameterSpec initParams;
    private SecureRandom initRandom;
    private int initType;
    private final Object lock = new Object();
    private Provider provider;
    private Iterator serviceIterator;
    private volatile KeyGeneratorSpi spi;

    protected KeyGenerator(KeyGeneratorSpi keyGenSpi, Provider provider2, String algorithm2) {
        this.spi = keyGenSpi;
        this.provider = provider2;
        this.algorithm = algorithm2;
    }

    private KeyGenerator(String algorithm2) throws NoSuchAlgorithmException {
        this.algorithm = algorithm2;
        this.serviceIterator = GetInstance.getServices("KeyGenerator", algorithm2).iterator();
        this.initType = 1;
        if (nextSpi((KeyGeneratorSpi) null, false) == null) {
            throw new NoSuchAlgorithmException(algorithm2 + " KeyGenerator not available");
        }
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public static final KeyGenerator getInstance(String algorithm2) throws NoSuchAlgorithmException {
        return new KeyGenerator(algorithm2);
    }

    public static final KeyGenerator getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = JceSecurity.getInstance("KeyGenerator", KeyGeneratorSpi.class, algorithm2, provider2);
        return new KeyGenerator((KeyGeneratorSpi) instance.impl, instance.provider, algorithm2);
    }

    public static final KeyGenerator getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = JceSecurity.getInstance("KeyGenerator", KeyGeneratorSpi.class, algorithm2, provider2);
        return new KeyGenerator((KeyGeneratorSpi) instance.impl, instance.provider, algorithm2);
    }

    public final Provider getProvider() {
        Provider provider2;
        synchronized (this.lock) {
            disableFailover();
            provider2 = this.provider;
        }
        return provider2;
    }

    private KeyGeneratorSpi nextSpi(KeyGeneratorSpi oldSpi, boolean reinit) {
        synchronized (this.lock) {
            if (oldSpi != null) {
                if (oldSpi != this.spi) {
                    KeyGeneratorSpi keyGeneratorSpi = this.spi;
                    return keyGeneratorSpi;
                }
            }
            if (this.serviceIterator == null) {
                return null;
            }
            while (this.serviceIterator.hasNext()) {
                Provider.Service s = (Provider.Service) this.serviceIterator.next();
                if (JceSecurity.canUseProvider(s.getProvider())) {
                    try {
                        Object inst = s.newInstance((Object) null);
                        if (inst instanceof KeyGeneratorSpi) {
                            KeyGeneratorSpi spi2 = (KeyGeneratorSpi) inst;
                            if (reinit) {
                                if (this.initType == 4) {
                                    spi2.engineInit(this.initKeySize, this.initRandom);
                                } else if (this.initType == 3) {
                                    spi2.engineInit(this.initParams, this.initRandom);
                                } else if (this.initType == 2) {
                                    spi2.engineInit(this.initRandom);
                                } else if (this.initType != 1) {
                                    throw new AssertionError((Object) "KeyGenerator initType: " + this.initType);
                                }
                            }
                            this.provider = s.getProvider();
                            this.spi = spi2;
                            return spi2;
                        }
                    } catch (Exception e) {
                    }
                }
            }
            disableFailover();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void disableFailover() {
        this.serviceIterator = null;
        this.initType = 0;
        this.initParams = null;
        this.initRandom = null;
    }

    public final void init(SecureRandom random) {
        if (this.serviceIterator == null) {
            this.spi.engineInit(random);
            return;
        }
        RuntimeException failure = null;
        KeyGeneratorSpi mySpi = this.spi;
        do {
            try {
                mySpi.engineInit(random);
                this.initType = 2;
                this.initKeySize = 0;
                this.initParams = null;
                this.initRandom = random;
                return;
            } catch (RuntimeException e) {
                if (failure == null) {
                    failure = e;
                }
                mySpi = nextSpi(mySpi, false);
                if (mySpi == null) {
                    throw failure;
                }
            }
        } while (mySpi == null);
        throw failure;
    }

    public final void init(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        init(params, JceSecurity.RANDOM);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init(java.security.spec.AlgorithmParameterSpec r6, java.security.SecureRandom r7) throws java.security.InvalidAlgorithmParameterException {
        /*
            r5 = this;
            r4 = 0
            java.util.Iterator r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            javax.crypto.KeyGeneratorSpi r3 = r5.spi
            r3.engineInit((java.security.spec.AlgorithmParameterSpec) r6, (java.security.SecureRandom) r7)
            return
        L_0x000b:
            r1 = 0
            javax.crypto.KeyGeneratorSpi r2 = r5.spi
        L_0x000e:
            r2.engineInit((java.security.spec.AlgorithmParameterSpec) r6, (java.security.SecureRandom) r7)     // Catch:{ Exception -> 0x001c }
            r3 = 3
            r5.initType = r3     // Catch:{ Exception -> 0x001c }
            r3 = 0
            r5.initKeySize = r3     // Catch:{ Exception -> 0x001c }
            r5.initParams = r6     // Catch:{ Exception -> 0x001c }
            r5.initRandom = r7     // Catch:{ Exception -> 0x001c }
            return
        L_0x001c:
            r0 = move-exception
            if (r1 != 0) goto L_0x0020
            r1 = r0
        L_0x0020:
            javax.crypto.KeyGeneratorSpi r2 = r5.nextSpi(r2, r4)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.security.InvalidAlgorithmParameterException
            if (r3 == 0) goto L_0x002d
            java.security.InvalidAlgorithmParameterException r1 = (java.security.InvalidAlgorithmParameterException) r1
            throw r1
        L_0x002d:
            boolean r3 = r1 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0034
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1
            throw r1
        L_0x0034:
            java.security.InvalidAlgorithmParameterException r3 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r4 = "init() failed"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.KeyGenerator.init(java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    public final void init(int keysize) {
        init(keysize, JceSecurity.RANDOM);
    }

    public final void init(int keysize, SecureRandom random) {
        if (this.serviceIterator == null) {
            this.spi.engineInit(keysize, random);
            return;
        }
        RuntimeException failure = null;
        KeyGeneratorSpi mySpi = this.spi;
        do {
            try {
                mySpi.engineInit(keysize, random);
                this.initType = 4;
                this.initKeySize = keysize;
                this.initParams = null;
                this.initRandom = random;
                return;
            } catch (RuntimeException e) {
                if (failure == null) {
                    failure = e;
                }
                mySpi = nextSpi(mySpi, false);
                if (mySpi == null) {
                    throw failure;
                }
            }
        } while (mySpi == null);
        throw failure;
    }

    public final SecretKey generateKey() {
        if (this.serviceIterator == null) {
            return this.spi.engineGenerateKey();
        }
        RuntimeException failure = null;
        KeyGeneratorSpi mySpi = this.spi;
        do {
            try {
                return mySpi.engineGenerateKey();
            } catch (RuntimeException e) {
                if (failure == null) {
                    failure = e;
                }
                mySpi = nextSpi(mySpi, true);
                if (mySpi == null) {
                    throw failure;
                }
            }
        } while (mySpi == null);
        throw failure;
    }
}
