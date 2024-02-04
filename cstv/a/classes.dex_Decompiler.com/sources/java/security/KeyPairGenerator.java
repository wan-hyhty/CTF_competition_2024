package java.security;

import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import sun.security.jca.GetInstance;
import sun.security.jca.JCAUtil;

public abstract class KeyPairGenerator extends KeyPairGeneratorSpi {
    private final String algorithm;
    Provider provider;

    protected KeyPairGenerator(String algorithm2) {
        this.algorithm = algorithm2;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    private static KeyPairGenerator getInstance(GetInstance.Instance instance, String algorithm2) {
        KeyPairGenerator kpg;
        if (instance.impl instanceof KeyPairGenerator) {
            kpg = (KeyPairGenerator) instance.impl;
        } else {
            kpg = new Delegate((KeyPairGeneratorSpi) instance.impl, algorithm2);
        }
        kpg.provider = instance.provider;
        return kpg;
    }

    public static KeyPairGenerator getInstance(String algorithm2) throws NoSuchAlgorithmException {
        Iterator<Provider.Service> t = GetInstance.getServices("KeyPairGenerator", algorithm2).iterator();
        if (!t.hasNext()) {
            throw new NoSuchAlgorithmException(algorithm2 + " KeyPairGenerator not available");
        }
        NoSuchAlgorithmException noSuchAlgorithmException = null;
        do {
            try {
                GetInstance.Instance instance = GetInstance.getInstance(t.next(), KeyPairGeneratorSpi.class);
                if (instance.impl instanceof KeyPairGenerator) {
                    return getInstance(instance, algorithm2);
                }
                return new Delegate(instance, t, algorithm2);
            } catch (NoSuchAlgorithmException e) {
                if (noSuchAlgorithmException == null) {
                    noSuchAlgorithmException = e;
                }
                if (!t.hasNext()) {
                    throw noSuchAlgorithmException;
                }
            }
        } while (!t.hasNext());
        throw noSuchAlgorithmException;
    }

    public static KeyPairGenerator getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        return getInstance(GetInstance.getInstance("KeyPairGenerator", KeyPairGeneratorSpi.class, algorithm2, provider2), algorithm2);
    }

    public static KeyPairGenerator getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        return getInstance(GetInstance.getInstance("KeyPairGenerator", KeyPairGeneratorSpi.class, algorithm2, provider2), algorithm2);
    }

    public final Provider getProvider() {
        disableFailover();
        return this.provider;
    }

    /* access modifiers changed from: package-private */
    public void disableFailover() {
    }

    public void initialize(int keysize) {
        initialize(keysize, JCAUtil.getSecureRandom());
    }

    public void initialize(int keysize, SecureRandom random) {
    }

    public void initialize(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        initialize(params, JCAUtil.getSecureRandom());
    }

    public void initialize(AlgorithmParameterSpec params, SecureRandom random) throws InvalidAlgorithmParameterException {
    }

    public final KeyPair genKeyPair() {
        return generateKeyPair();
    }

    public KeyPair generateKeyPair() {
        return null;
    }

    private static final class Delegate extends KeyPairGenerator {
        private static final int I_NONE = 1;
        private static final int I_PARAMS = 3;
        private static final int I_SIZE = 2;
        private int initKeySize;
        private AlgorithmParameterSpec initParams;
        private SecureRandom initRandom;
        private int initType;
        private final Object lock = new Object();
        private Iterator<Provider.Service> serviceIterator;
        private volatile KeyPairGeneratorSpi spi;

        Delegate(KeyPairGeneratorSpi spi2, String algorithm) {
            super(algorithm);
            this.spi = spi2;
        }

        Delegate(GetInstance.Instance instance, Iterator<Provider.Service> serviceIterator2, String algorithm) {
            super(algorithm);
            this.spi = (KeyPairGeneratorSpi) instance.impl;
            this.provider = instance.provider;
            this.serviceIterator = serviceIterator2;
            this.initType = 1;
        }

        private KeyPairGeneratorSpi nextSpi(KeyPairGeneratorSpi oldSpi, boolean reinit) {
            synchronized (this.lock) {
                if (oldSpi != null) {
                    if (oldSpi != this.spi) {
                        KeyPairGeneratorSpi keyPairGeneratorSpi = this.spi;
                        return keyPairGeneratorSpi;
                    }
                }
                if (this.serviceIterator == null) {
                    return null;
                }
                while (this.serviceIterator.hasNext()) {
                    Provider.Service s = this.serviceIterator.next();
                    try {
                        Object inst = s.newInstance((Object) null);
                        if ((inst instanceof KeyPairGeneratorSpi) && !(inst instanceof KeyPairGenerator)) {
                            KeyPairGeneratorSpi spi2 = (KeyPairGeneratorSpi) inst;
                            if (reinit) {
                                if (this.initType == 2) {
                                    spi2.initialize(this.initKeySize, this.initRandom);
                                } else if (this.initType == 3) {
                                    spi2.initialize(this.initParams, this.initRandom);
                                } else if (this.initType != 1) {
                                    throw new AssertionError((Object) "KeyPairGenerator initType: " + this.initType);
                                }
                            }
                            this.provider = s.getProvider();
                            this.spi = spi2;
                            return spi2;
                        }
                    } catch (Exception e) {
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

        public void initialize(int keysize, SecureRandom random) {
            if (this.serviceIterator == null) {
                this.spi.initialize(keysize, random);
                return;
            }
            RuntimeException failure = null;
            KeyPairGeneratorSpi mySpi = this.spi;
            do {
                try {
                    mySpi.initialize(keysize, random);
                    this.initType = 2;
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

        /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void initialize(java.security.spec.AlgorithmParameterSpec r6, java.security.SecureRandom r7) throws java.security.InvalidAlgorithmParameterException {
            /*
                r5 = this;
                r4 = 0
                java.util.Iterator<java.security.Provider$Service> r3 = r5.serviceIterator
                if (r3 != 0) goto L_0x000b
                java.security.KeyPairGeneratorSpi r3 = r5.spi
                r3.initialize((java.security.spec.AlgorithmParameterSpec) r6, (java.security.SecureRandom) r7)
                return
            L_0x000b:
                r1 = 0
                java.security.KeyPairGeneratorSpi r2 = r5.spi
            L_0x000e:
                r2.initialize((java.security.spec.AlgorithmParameterSpec) r6, (java.security.SecureRandom) r7)     // Catch:{ Exception -> 0x001c }
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
                java.security.KeyPairGeneratorSpi r2 = r5.nextSpi(r2, r4)
                if (r2 != 0) goto L_0x000e
                boolean r3 = r1 instanceof java.lang.RuntimeException
                if (r3 == 0) goto L_0x002d
                java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1
                throw r1
            L_0x002d:
                java.security.InvalidAlgorithmParameterException r1 = (java.security.InvalidAlgorithmParameterException) r1
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyPairGenerator.Delegate.initialize(java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
        }

        public KeyPair generateKeyPair() {
            if (this.serviceIterator == null) {
                return this.spi.generateKeyPair();
            }
            RuntimeException failure = null;
            KeyPairGeneratorSpi mySpi = this.spi;
            do {
                try {
                    return mySpi.generateKeyPair();
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
}
