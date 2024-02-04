package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

public class IvParameterSpec implements AlgorithmParameterSpec {
    private byte[] iv;

    public IvParameterSpec(byte[] iv2) {
        this(iv2, 0, iv2.length);
    }

    public IvParameterSpec(byte[] iv2, int offset, int len) {
        if (iv2 == null) {
            throw new IllegalArgumentException("IV missing");
        } else if (iv2.length - offset < len) {
            throw new IllegalArgumentException("IV buffer too short for given offset/length combination");
        } else if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("len is negative");
        } else {
            this.iv = new byte[len];
            System.arraycopy(iv2, offset, this.iv, 0, len);
        }
    }

    public byte[] getIV() {
        return (byte[]) this.iv.clone();
    }
}
