package sun.security.jca;

import java.security.SecureRandom;

public final class JCAUtil {
    private static final int ARRAY_SIZE = 4096;
    private static final Object LOCK = null;
    private static volatile SecureRandom secureRandom;

    private JCAUtil() {
    }

    public static int getTempArraySize(int totalSize) {
        return Math.min(4096, totalSize);
    }

    public static SecureRandom getSecureRandom() {
        SecureRandom r = secureRandom;
        if (r == null) {
            synchronized (LOCK) {
                try {
                    r = secureRandom;
                    if (r == null) {
                        SecureRandom r2 = new SecureRandom();
                        try {
                            secureRandom = r2;
                            r = r2;
                        } catch (Throwable th) {
                            th = th;
                            SecureRandom secureRandom2 = r2;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
        return r;
    }
}
