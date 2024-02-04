package javax.crypto.spec;

import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;

public class SecretKeySpec implements KeySpec, SecretKey {
    private static final long serialVersionUID = 6577238317307289933L;
    private String algorithm;
    private byte[] key;

    public SecretKeySpec(byte[] key2, String algorithm2) {
        if (key2 == null || algorithm2 == null) {
            throw new IllegalArgumentException("Missing argument");
        } else if (key2.length == 0) {
            throw new IllegalArgumentException("Empty key");
        } else {
            this.key = (byte[]) key2.clone();
            this.algorithm = algorithm2;
        }
    }

    public SecretKeySpec(byte[] key2, int offset, int len, String algorithm2) {
        if (key2 == null || algorithm2 == null) {
            throw new IllegalArgumentException("Missing argument");
        } else if (key2.length == 0) {
            throw new IllegalArgumentException("Empty key");
        } else if (key2.length - offset < len) {
            throw new IllegalArgumentException("Invalid offset/length combination");
        } else if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("len is negative");
        } else {
            this.key = new byte[len];
            System.arraycopy(key2, offset, this.key, 0, len);
            this.algorithm = algorithm2;
        }
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getFormat() {
        return "RAW";
    }

    public byte[] getEncoded() {
        return (byte[]) this.key.clone();
    }

    public int hashCode() {
        int retval = 0;
        for (int i = 1; i < this.key.length; i++) {
            retval += this.key[i] * i;
        }
        if (this.algorithm.equalsIgnoreCase("TripleDES")) {
            return retval ^ "desede".hashCode();
        }
        return retval ^ this.algorithm.toLowerCase().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SecretKey)) {
            return false;
        }
        String thatAlg = ((SecretKey) obj).getAlgorithm();
        if (!thatAlg.equalsIgnoreCase(this.algorithm) && ((!thatAlg.equalsIgnoreCase("DESede") || !this.algorithm.equalsIgnoreCase("TripleDES")) && (!thatAlg.equalsIgnoreCase("TripleDES") || !this.algorithm.equalsIgnoreCase("DESede")))) {
            return false;
        }
        return Arrays.equals(this.key, ((SecretKey) obj).getEncoded());
    }
}
