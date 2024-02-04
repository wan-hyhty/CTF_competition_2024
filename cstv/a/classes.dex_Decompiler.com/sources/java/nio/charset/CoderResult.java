package java.nio.charset;

import java.lang.ref.WeakReference;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.HashMap;
import java.util.Map;

public class CoderResult {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f24assertionsDisabled = false;
    private static final int CR_ERROR_MIN = 2;
    private static final int CR_MALFORMED = 2;
    private static final int CR_OVERFLOW = 1;
    private static final int CR_UNDERFLOW = 0;
    private static final int CR_UNMAPPABLE = 3;
    public static final CoderResult OVERFLOW = null;
    public static final CoderResult UNDERFLOW = null;
    private static Cache malformedCache;
    private static final String[] names = null;
    private static Cache unmappableCache;
    private final int length;
    private final int type;

    /* synthetic */ CoderResult(int type2, int length2, CoderResult coderResult) {
        this(type2, length2);
    }

    private CoderResult(int type2, int length2) {
        this.type = type2;
        this.length = length2;
    }

    public String toString() {
        String nm = names[this.type];
        return isError() ? nm + "[" + this.length + "]" : nm;
    }

    public boolean isUnderflow() {
        if (this.type == 0) {
            return true;
        }
        return f24assertionsDisabled;
    }

    public boolean isOverflow() {
        if (this.type == 1) {
            return true;
        }
        return f24assertionsDisabled;
    }

    public boolean isError() {
        if (this.type >= 2) {
            return true;
        }
        return f24assertionsDisabled;
    }

    public boolean isMalformed() {
        if (this.type == 2) {
            return true;
        }
        return f24assertionsDisabled;
    }

    public boolean isUnmappable() {
        if (this.type == 3) {
            return true;
        }
        return f24assertionsDisabled;
    }

    public int length() {
        if (isError()) {
            return this.length;
        }
        throw new UnsupportedOperationException();
    }

    private static abstract class Cache {
        private Map<Integer, WeakReference<CoderResult>> cache;

        /* synthetic */ Cache(Cache cache2) {
            this();
        }

        /* access modifiers changed from: protected */
        public abstract CoderResult create(int i);

        private Cache() {
            this.cache = null;
        }

        /* access modifiers changed from: private */
        public synchronized CoderResult get(int len) {
            CoderResult e;
            if (len <= 0) {
                throw new IllegalArgumentException("Non-positive length");
            }
            Integer k = new Integer(len);
            e = null;
            if (this.cache == null) {
                this.cache = new HashMap();
            } else {
                WeakReference<CoderResult> w = this.cache.get(k);
                if (w != null) {
                    e = w.get();
                }
            }
            if (e == null) {
                e = create(len);
                this.cache.put(k, new WeakReference(e));
            }
            return e;
        }
    }

    public static CoderResult malformedForLength(int length2) {
        return malformedCache.get(length2);
    }

    public static CoderResult unmappableForLength(int length2) {
        return unmappableCache.get(length2);
    }

    public void throwException() throws CharacterCodingException {
        switch (this.type) {
            case 0:
                throw new BufferUnderflowException();
            case 1:
                throw new BufferOverflowException();
            case 2:
                throw new MalformedInputException(this.length);
            case 3:
                throw new UnmappableCharacterException(this.length);
            default:
                if (!f24assertionsDisabled) {
                    throw new AssertionError();
                }
                return;
        }
    }
}
