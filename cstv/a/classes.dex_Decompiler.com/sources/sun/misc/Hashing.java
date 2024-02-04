package sun.misc;

public class Hashing {
    private Hashing() {
        throw new Error("No instances");
    }

    public static int singleWordWangJenkinsHash(Object k) {
        int h = k.hashCode();
        int h2 = h + ((h << 15) ^ -12931);
        int h3 = h2 ^ (h2 >>> 10);
        int h4 = h3 + (h3 << 3);
        int h5 = h4 ^ (h4 >>> 6);
        int h6 = h5 + (h5 << 2) + (h5 << 14);
        return (h6 >>> 16) ^ h6;
    }
}
