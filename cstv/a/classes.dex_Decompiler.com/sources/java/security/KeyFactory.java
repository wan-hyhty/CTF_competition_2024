package java.security;

import java.security.Provider;
import java.util.Iterator;
import sun.security.jca.GetInstance;
import sun.security.util.Debug;

public class KeyFactory {
    private static final Debug debug = null;
    private final String algorithm;
    private final Object lock = new Object();
    private Provider provider;
    private Iterator<Provider.Service> serviceIterator;
    private volatile KeyFactorySpi spi;

    protected KeyFactory(KeyFactorySpi keyFacSpi, Provider provider2, String algorithm2) {
        this.spi = keyFacSpi;
        this.provider = provider2;
        this.algorithm = algorithm2;
    }

    private KeyFactory(String algorithm2) throws NoSuchAlgorithmException {
        this.algorithm = algorithm2;
        this.serviceIterator = GetInstance.getServices("KeyFactory", algorithm2).iterator();
        if (nextSpi((KeyFactorySpi) null) == null) {
            throw new NoSuchAlgorithmException(algorithm2 + " KeyFactory not available");
        }
    }

    public static KeyFactory getInstance(String algorithm2) throws NoSuchAlgorithmException {
        return new KeyFactory(algorithm2);
    }

    public static KeyFactory getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = GetInstance.getInstance("KeyFactory", KeyFactorySpi.class, algorithm2, provider2);
        return new KeyFactory((KeyFactorySpi) instance.impl, instance.provider, algorithm2);
    }

    public static KeyFactory getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("KeyFactory", KeyFactorySpi.class, algorithm2, provider2);
        return new KeyFactory((KeyFactorySpi) instance.impl, instance.provider, algorithm2);
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

    private KeyFactorySpi nextSpi(KeyFactorySpi oldSpi) {
        synchronized (this.lock) {
            if (oldSpi != null) {
                if (oldSpi != this.spi) {
                    KeyFactorySpi keyFactorySpi = this.spi;
                    return keyFactorySpi;
                }
            }
            if (this.serviceIterator == null) {
                return null;
            }
            while (this.serviceIterator.hasNext()) {
                Provider.Service s = this.serviceIterator.next();
                try {
                    Object obj = s.newInstance((Object) null);
                    if (obj instanceof KeyFactorySpi) {
                        KeyFactorySpi spi2 = (KeyFactorySpi) obj;
                        this.provider = s.getProvider();
                        this.spi = spi2;
                        return spi2;
                    }
                } catch (NoSuchAlgorithmException e) {
                }
            }
            this.serviceIterator = null;
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.PublicKey generatePublic(java.security.spec.KeySpec r6) throws java.security.spec.InvalidKeySpecException {
        /*
            r5 = this;
            java.util.Iterator<java.security.Provider$Service> r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            java.security.KeyFactorySpi r3 = r5.spi
            java.security.PublicKey r3 = r3.engineGeneratePublic(r6)
            return r3
        L_0x000b:
            r1 = 0
            java.security.KeyFactorySpi r2 = r5.spi
        L_0x000e:
            java.security.PublicKey r3 = r2.engineGeneratePublic(r6)     // Catch:{ Exception -> 0x0013 }
            return r3
        L_0x0013:
            r0 = move-exception
            if (r1 != 0) goto L_0x0017
            r1 = r0
        L_0x0017:
            java.security.KeyFactorySpi r2 = r5.nextSpi(r2)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0024
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1
            throw r1
        L_0x0024:
            boolean r3 = r1 instanceof java.security.spec.InvalidKeySpecException
            if (r3 == 0) goto L_0x002b
            java.security.spec.InvalidKeySpecException r1 = (java.security.spec.InvalidKeySpecException) r1
            throw r1
        L_0x002b:
            java.security.spec.InvalidKeySpecException r3 = new java.security.spec.InvalidKeySpecException
            java.lang.String r4 = "Could not generate public key"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.KeyFactory.generatePublic(java.security.spec.KeySpec):java.security.PublicKey");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.PrivateKey generatePrivate(java.security.spec.KeySpec r6) throws java.security.spec.InvalidKeySpecException {
        /*
            r5 = this;
            java.util.Iterator<java.security.Provider$Service> r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            java.security.KeyFactorySpi r3 = r5.spi
            java.security.PrivateKey r3 = r3.engineGeneratePrivate(r6)
            return r3
        L_0x000b:
            r1 = 0
            java.security.KeyFactorySpi r2 = r5.spi
        L_0x000e:
            java.security.PrivateKey r3 = r2.engineGeneratePrivate(r6)     // Catch:{ Exception -> 0x0013 }
            return r3
        L_0x0013:
            r0 = move-exception
            if (r1 != 0) goto L_0x0017
            r1 = r0
        L_0x0017:
            java.security.KeyFactorySpi r2 = r5.nextSpi(r2)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0024
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1
            throw r1
        L_0x0024:
            boolean r3 = r1 instanceof java.security.spec.InvalidKeySpecException
            if (r3 == 0) goto L_0x002b
            java.security.spec.InvalidKeySpecException r1 = (java.security.spec.InvalidKeySpecException) r1
            throw r1
        L_0x002b:
            java.security.spec.InvalidKeySpecException r3 = new java.security.spec.InvalidKeySpecException
            java.lang.String r4 = "Could not generate private key"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.KeyFactory.generatePrivate(java.security.spec.KeySpec):java.security.PrivateKey");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends java.security.spec.KeySpec> T getKeySpec(java.security.Key r6, java.lang.Class<T> r7) throws java.security.spec.InvalidKeySpecException {
        /*
            r5 = this;
            java.util.Iterator<java.security.Provider$Service> r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            java.security.KeyFactorySpi r3 = r5.spi
            java.security.spec.KeySpec r3 = r3.engineGetKeySpec(r6, r7)
            return r3
        L_0x000b:
            r1 = 0
            java.security.KeyFactorySpi r2 = r5.spi
        L_0x000e:
            java.security.spec.KeySpec r3 = r2.engineGetKeySpec(r6, r7)     // Catch:{ Exception -> 0x0013 }
            return r3
        L_0x0013:
            r0 = move-exception
            if (r1 != 0) goto L_0x0017
            r1 = r0
        L_0x0017:
            java.security.KeyFactorySpi r2 = r5.nextSpi(r2)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0024
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1
            throw r1
        L_0x0024:
            boolean r3 = r1 instanceof java.security.spec.InvalidKeySpecException
            if (r3 == 0) goto L_0x002b
            java.security.spec.InvalidKeySpecException r1 = (java.security.spec.InvalidKeySpecException) r1
            throw r1
        L_0x002b:
            java.security.spec.InvalidKeySpecException r3 = new java.security.spec.InvalidKeySpecException
            java.lang.String r4 = "Could not get key spec"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.KeyFactory.getKeySpec(java.security.Key, java.lang.Class):java.security.spec.KeySpec");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.Key translateKey(java.security.Key r6) throws java.security.InvalidKeyException {
        /*
            r5 = this;
            java.util.Iterator<java.security.Provider$Service> r3 = r5.serviceIterator
            if (r3 != 0) goto L_0x000b
            java.security.KeyFactorySpi r3 = r5.spi
            java.security.Key r3 = r3.engineTranslateKey(r6)
            return r3
        L_0x000b:
            r1 = 0
            java.security.KeyFactorySpi r2 = r5.spi
        L_0x000e:
            java.security.Key r3 = r2.engineTranslateKey(r6)     // Catch:{ Exception -> 0x0013 }
            return r3
        L_0x0013:
            r0 = move-exception
            if (r1 != 0) goto L_0x0017
            r1 = r0
        L_0x0017:
            java.security.KeyFactorySpi r2 = r5.nextSpi(r2)
            if (r2 != 0) goto L_0x000e
            boolean r3 = r1 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0024
            java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1
            throw r1
        L_0x0024:
            boolean r3 = r1 instanceof java.security.InvalidKeyException
            if (r3 == 0) goto L_0x002b
            java.security.InvalidKeyException r1 = (java.security.InvalidKeyException) r1
            throw r1
        L_0x002b:
            java.security.InvalidKeyException r3 = new java.security.InvalidKeyException
            java.lang.String r4 = "Could not translate key"
            r3.<init>(r4, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.KeyFactory.translateKey(java.security.Key):java.security.Key");
    }
}
