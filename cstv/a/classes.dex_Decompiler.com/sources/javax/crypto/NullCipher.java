package javax.crypto;

import java.security.Provider;

public class NullCipher extends Cipher {
    public NullCipher() {
        super(new NullCipherSpi(), (Provider) null, (String) null);
    }
}
