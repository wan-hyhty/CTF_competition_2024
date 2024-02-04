package java.security.spec;

public class MGF1ParameterSpec implements AlgorithmParameterSpec {
    public static final MGF1ParameterSpec SHA1 = null;
    public static final MGF1ParameterSpec SHA256 = null;
    public static final MGF1ParameterSpec SHA384 = null;
    public static final MGF1ParameterSpec SHA512 = null;
    private String mdName;

    public MGF1ParameterSpec(String mdName2) {
        if (mdName2 == null) {
            throw new NullPointerException("digest algorithm is null");
        }
        this.mdName = mdName2;
    }

    public String getDigestAlgorithm() {
        return this.mdName;
    }
}
