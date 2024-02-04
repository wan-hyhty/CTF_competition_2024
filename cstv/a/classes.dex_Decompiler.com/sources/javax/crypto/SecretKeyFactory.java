package javax.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Iterator;
import sun.security.jca.GetInstance;

public class SecretKeyFactory {
    private final String algorithm;
    private final Object lock = new Object();
    private Provider provider;
    private Iterator serviceIterator;
    private volatile SecretKeyFactorySpi spi;

    protected SecretKeyFactory(SecretKeyFactorySpi keyFacSpi, Provider provider2, String algorithm2) {
        this.spi = keyFacSpi;
        this.provider = provider2;
        this.algorithm = algorithm2;
    }

    private SecretKeyFactory(String algorithm2) throws NoSuchAlgorithmException {
        this.algorithm = algorithm2;
        this.serviceIterator = GetInstance.getServices("SecretKeyFactory", algorithm2).iterator();
        if (nextSpi((SecretKeyFactorySpi) null) == null) {
            throw new NoSuchAlgorithmException(algorithm2 + " SecretKeyFactory not available");
        }
    }

    public static final SecretKeyFactory getInstance(String algorithm2) throws NoSuchAlgorithmException {
        return new SecretKeyFactory(algorithm2);
    }

    public static final SecretKeyFactory getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = JceSecurity.getInstance("SecretKeyFactory", SecretKeyFactorySpi.class, algorithm2, provider2);
        return new SecretKeyFactory((SecretKeyFactorySpi) instance.impl, instance.provider, algorithm2);
    }

    public static final SecretKeyFactory getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = JceSecurity.getInstance("SecretKeyFactory", SecretKeyFactorySpi.class, algorithm2, provider2);
        return new SecretKeyFactory((SecretKeyFactorySpi) instance.impl, instance.provider, algorithm2);
    }

    public final Provider getProvider() {
        Provider provider2;
        synchronized (this.lock) {
            this.serviceIterator = null;
            provider2 = this.provider;
        }
        return provider2;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    private SecretKeyFactorySpi nextSpi(SecretKeyFactorySpi oldSpi) {
        synchronized (this.lock) {
            if (oldSpi != null) {
                if (oldSpi != this.spi) {
                    SecretKeyFactorySpi secretKeyFactorySpi = this.spi;
                    return secretKeyFactorySpi;
                }
            }
            if (this.serviceIterator == null) {
                return null;
            }
            while (this.serviceIterator.hasNext()) {
                Provider.Service s = (Provider.Service) this.serviceIterator.next();
                if (JceSecurity.canUseProvider(s.getProvider())) {
                    try {
                        Object obj = s.newInstance((Object) null);
                        if (obj instanceof SecretKeyFactorySpi) {
                            SecretKeyFactorySpi spi2 = (SecretKeyFactorySpi) obj;
                            this.provider = s.getProvider();
                            this.spi = spi2;
                            return spi2;
                        }
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
            }
            this.serviceIterator = null;
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final javax.crypto.SecretKey generateSecret(java.security.spec.KeySpec r6) throws java.security.spec.InvalidKeySpecException {
        /*
            r5 = this;
            java.util.Iterator r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            javax.crypto.SecretKeyFactorySpi r3 = r5.spi
            javax.crypto.SecretKey r3 = r3.engineGenerateSecret(r6)
            return r3
        L_0x000b:
            r1 = 0
            javax.crypto.SecretKeyFactorySpi r2 = r5.spi
        L_0x000e:
            javax.crypto.SecretKey r3 = r2.engineGenerateSecret(r6)     // Catch:{ Exception -> 0x0013 }
            return r3
        L_0x0013:
            r0 = move-exception
            if (r1 != 0) goto L_0x0017
            r1 = r0
        L_0x0017:
            javax.crypto.SecretKeyFactorySpi r2 = r5.nextSpi(r2)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.security.spec.InvalidKeySpecException
            if (r3 == 0) goto L_0x0024
            java.security.spec.InvalidKeySpecException r1 = (java.security.spec.InvalidKeySpecException) r1
            throw r1
        L_0x0024:
            java.security.spec.InvalidKeySpecException r3 = new java.security.spec.InvalidKeySpecException
            java.lang.String r4 = "Could not generate secret key"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.SecretKeyFactory.generateSecret(java.security.spec.KeySpec):javax.crypto.SecretKey");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.spec.KeySpec getKeySpec(javax.crypto.SecretKey r6, java.lang.Class r7) throws java.security.spec.InvalidKeySpecException {
        /*
            r5 = this;
            java.util.Iterator r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            javax.crypto.SecretKeyFactorySpi r3 = r5.spi
            java.security.spec.KeySpec r3 = r3.engineGetKeySpec(r6, r7)
            return r3
        L_0x000b:
            r1 = 0
            javax.crypto.SecretKeyFactorySpi r2 = r5.spi
        L_0x000e:
            java.security.spec.KeySpec r3 = r2.engineGetKeySpec(r6, r7)     // Catch:{ Exception -> 0x0013 }
            return r3
        L_0x0013:
            r0 = move-exception
            if (r1 != 0) goto L_0x0017
            r1 = r0
        L_0x0017:
            javax.crypto.SecretKeyFactorySpi r2 = r5.nextSpi(r2)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.security.spec.InvalidKeySpecException
            if (r3 == 0) goto L_0x0024
            java.security.spec.InvalidKeySpecException r1 = (java.security.spec.InvalidKeySpecException) r1
            throw r1
        L_0x0024:
            java.security.spec.InvalidKeySpecException r3 = new java.security.spec.InvalidKeySpecException
            java.lang.String r4 = "Could not get key spec"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.SecretKeyFactory.getKeySpec(javax.crypto.SecretKey, java.lang.Class):java.security.spec.KeySpec");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final javax.crypto.SecretKey translateKey(javax.crypto.SecretKey r6) throws java.security.InvalidKeyException {
        /*
            r5 = this;
            java.util.Iterator r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            javax.crypto.SecretKeyFactorySpi r3 = r5.spi
            javax.crypto.SecretKey r3 = r3.engineTranslateKey(r6)
            return r3
        L_0x000b:
            r1 = 0
            javax.crypto.SecretKeyFactorySpi r2 = r5.spi
        L_0x000e:
            javax.crypto.SecretKey r3 = r2.engineTranslateKey(r6)     // Catch:{ Exception -> 0x0013 }
            return r3
        L_0x0013:
            r0 = move-exception
            if (r1 != 0) goto L_0x0017
            r1 = r0
        L_0x0017:
            javax.crypto.SecretKeyFactorySpi r2 = r5.nextSpi(r2)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.security.InvalidKeyException
            if (r3 == 0) goto L_0x0024
            java.security.InvalidKeyException r1 = (java.security.InvalidKeyException) r1
            throw r1
        L_0x0024:
            java.security.InvalidKeyException r3 = new java.security.InvalidKeyException
            java.lang.String r4 = "Could not translate key"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.SecretKeyFactory.translateKey(javax.crypto.SecretKey):javax.crypto.SecretKey");
    }
}
