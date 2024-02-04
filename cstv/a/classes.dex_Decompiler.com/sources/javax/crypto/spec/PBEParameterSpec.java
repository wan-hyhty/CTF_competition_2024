package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

public class PBEParameterSpec implements AlgorithmParameterSpec {
    private int iterationCount;
    private byte[] salt;

    public PBEParameterSpec(byte[] salt2, int iterationCount2) {
        this.salt = (byte[]) salt2.clone();
        this.iterationCount = iterationCount2;
    }

    public byte[] getSalt() {
        return (byte[]) this.salt.clone();
    }

    public int getIterationCount() {
        return this.iterationCount;
    }
}
