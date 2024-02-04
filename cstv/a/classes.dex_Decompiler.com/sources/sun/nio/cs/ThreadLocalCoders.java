package sun.nio.cs;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class ThreadLocalCoders {
    private static final int CACHE_SIZE = 3;
    private static Cache decoderCache;
    private static Cache encoderCache;

    private static abstract class Cache {
        private ThreadLocal cache = new ThreadLocal();
        private final int size;

        /* access modifiers changed from: package-private */
        public abstract Object create(Object obj);

        /* access modifiers changed from: package-private */
        public abstract boolean hasName(Object obj, Object obj2);

        Cache(int size2) {
            this.size = size2;
        }

        private void moveToFront(Object[] oa, int i) {
            Object ob = oa[i];
            for (int j = i; j > 0; j--) {
                oa[j] = oa[j - 1];
            }
            oa[0] = ob;
        }

        /* access modifiers changed from: package-private */
        public Object forName(Object name) {
            Object[] oa = (Object[]) this.cache.get();
            if (oa == null) {
                oa = new Object[this.size];
                this.cache.set(oa);
            } else {
                for (int i = 0; i < oa.length; i++) {
                    Object ob = oa[i];
                    if (ob != null && hasName(ob, name)) {
                        if (i > 0) {
                            moveToFront(oa, i);
                        }
                        return ob;
                    }
                }
            }
            Object ob2 = create(name);
            oa[oa.length - 1] = ob2;
            moveToFront(oa, oa.length - 1);
            return ob2;
        }
    }

    public static CharsetDecoder decoderFor(Object name) {
        CharsetDecoder cd = (CharsetDecoder) decoderCache.forName(name);
        cd.reset();
        return cd;
    }

    public static CharsetEncoder encoderFor(Object name) {
        CharsetEncoder ce = (CharsetEncoder) encoderCache.forName(name);
        ce.reset();
        return ce;
    }
}
