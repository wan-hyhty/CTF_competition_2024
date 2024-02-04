package javax.crypto;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.spec.AlgorithmParameterSpec;
import sun.security.jca.GetInstance;
import sun.security.util.Debug;

public class Mac implements Cloneable {
    private static final Debug debug = null;
    private static int warnCount;
    private final String algorithm;
    private boolean initialized = false;
    private final Object lock;
    private Provider provider;
    private MacSpi spi;

    protected Mac(MacSpi macSpi, Provider provider2, String algorithm2) {
        this.spi = macSpi;
        this.provider = provider2;
        this.algorithm = algorithm2;
        this.lock = null;
    }

    private Mac(String algorithm2) {
        this.algorithm = algorithm2;
        this.lock = new Object();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public static final Mac getInstance(String algorithm2) throws NoSuchAlgorithmException {
        for (Provider.Service s : GetInstance.getServices("Mac", algorithm2)) {
            if (JceSecurity.canUseProvider(s.getProvider())) {
                return new Mac(algorithm2);
            }
        }
        throw new NoSuchAlgorithmException("Algorithm " + algorithm2 + " not available");
    }

    public static final Mac getInstance(String algorithm2, String provider2) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = JceSecurity.getInstance("Mac", MacSpi.class, algorithm2, provider2);
        return new Mac((MacSpi) instance.impl, instance.provider, algorithm2);
    }

    public static final Mac getInstance(String algorithm2, Provider provider2) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = JceSecurity.getInstance("Mac", MacSpi.class, algorithm2, provider2);
        return new Mac((MacSpi) instance.impl, instance.provider, algorithm2);
    }

    /* access modifiers changed from: package-private */
    public void chooseFirstProvider() {
        if (this.spi == null && this.lock != null) {
            synchronized (this.lock) {
                if (this.spi == null) {
                    if (debug != null) {
                        int w = warnCount - 1;
                        warnCount = w;
                        if (w >= 0) {
                            debug.println("Mac.init() not first method called, disabling delayed provider selection");
                            if (w == 0) {
                                debug.println("Further warnings of this type will be suppressed");
                            }
                            new Exception("Call trace").printStackTrace();
                        }
                    }
                    Exception lastException = null;
                    for (Provider.Service s : GetInstance.getServices("Mac", this.algorithm)) {
                        if (JceSecurity.canUseProvider(s.getProvider())) {
                            try {
                                Object obj = s.newInstance((Object) null);
                                if (obj instanceof MacSpi) {
                                    this.spi = (MacSpi) obj;
                                    this.provider = s.getProvider();
                                    return;
                                }
                            } catch (NoSuchAlgorithmException e) {
                                lastException = e;
                            }
                        }
                    }
                    ProviderException e2 = new ProviderException("Could not construct MacSpi instance");
                    if (lastException != null) {
                        e2.initCause(lastException);
                    }
                    throw e2;
                }
            }
        }
    }

    private void chooseProvider(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        synchronized (this.lock) {
            if (this.spi == null || !(key == null || this.lock == null)) {
                Exception lastException = null;
                for (Provider.Service s : GetInstance.getServices("Mac", this.algorithm)) {
                    if (s.supportsParameter(key) && JceSecurity.canUseProvider(s.getProvider())) {
                        try {
                            MacSpi spi2 = (MacSpi) s.newInstance((Object) null);
                            spi2.engineInit(key, params);
                            this.provider = s.getProvider();
                            this.spi = spi2;
                            return;
                        } catch (Exception e) {
                            if (lastException == null) {
                                lastException = e;
                            }
                        }
                    }
                }
                if (lastException instanceof InvalidKeyException) {
                    throw ((InvalidKeyException) lastException);
                } else if (lastException instanceof InvalidAlgorithmParameterException) {
                    throw ((InvalidAlgorithmParameterException) lastException);
                } else if (lastException instanceof RuntimeException) {
                    throw ((RuntimeException) lastException);
                } else {
                    throw new InvalidKeyException("No installed provider supports this key: " + (key != null ? key.getClass().getName() : "(null)"), lastException);
                }
            } else {
                this.spi.engineInit(key, params);
            }
        }
    }

    public final Provider getProvider() {
        chooseFirstProvider();
        return this.provider;
    }

    public final int getMacLength() {
        chooseFirstProvider();
        return this.spi.engineGetMacLength();
    }

    public final void init(Key key) throws InvalidKeyException {
        try {
            if (this.spi == null || !(key == null || this.lock == null)) {
                chooseProvider(key, (AlgorithmParameterSpec) null);
            } else {
                this.spi.engineInit(key, (AlgorithmParameterSpec) null);
            }
            this.initialized = true;
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException("init() failed", e);
        }
    }

    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (this.spi == null || !(key == null || this.lock == null)) {
            chooseProvider(key, params);
        } else {
            this.spi.engineInit(key, params);
        }
        this.initialized = true;
    }

    public final void update(byte input) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        this.spi.engineUpdate(input);
    }

    public final void update(byte[] input) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        } else if (input != null) {
            this.spi.engineUpdate(input, 0, input.length);
        }
    }

    public final void update(byte[] input, int offset, int len) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        } else if (input == null) {
        } else {
            if (offset < 0 || len > input.length - offset || len < 0) {
                throw new IllegalArgumentException("Bad arguments");
            }
            this.spi.engineUpdate(input, offset, len);
        }
    }

    public final void update(ByteBuffer input) {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        } else if (input == null) {
            throw new IllegalArgumentException("Buffer must not be null");
        } else {
            this.spi.engineUpdate(input);
        }
    }

    public final byte[] doFinal() throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        byte[] mac = this.spi.engineDoFinal();
        this.spi.engineReset();
        return mac;
    }

    public final void doFinal(byte[] output, int outOffset) throws ShortBufferException, IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        int macLen = getMacLength();
        if (output == null || output.length - outOffset < macLen) {
            throw new ShortBufferException("Cannot store MAC in output buffer");
        }
        System.arraycopy(doFinal(), 0, output, outOffset, macLen);
    }

    public final byte[] doFinal(byte[] input) throws IllegalStateException {
        chooseFirstProvider();
        if (!this.initialized) {
            throw new IllegalStateException("MAC not initialized");
        }
        update(input);
        return doFinal();
    }

    public final void reset() {
        chooseFirstProvider();
        this.spi.engineReset();
    }

    public final Object clone() throws CloneNotSupportedException {
        chooseFirstProvider();
        Mac that = (Mac) super.clone();
        that.spi = (MacSpi) this.spi.clone();
        return that;
    }

    public MacSpi getCurrentSpi() {
        return this.spi;
    }
}
