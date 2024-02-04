package java.util.zip;

import java.nio.ByteBuffer;
import sun.nio.ch.DirectBuffer;

public class Adler32 implements Checksum {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f101assertionsDisabled = false;
    private int adler = 1;

    private static native int update(int i, int i2);

    private static native int updateByteBuffer(int i, long j, int i2, int i3);

    private static native int updateBytes(int i, byte[] bArr, int i2, int i3);

    public void update(int b) {
        this.adler = update(this.adler, b);
    }

    public void update(byte[] b, int off, int len) {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || off > b.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            this.adler = updateBytes(this.adler, b, off, len);
        }
    }

    public void update(byte[] b) {
        this.adler = updateBytes(this.adler, b, 0, b.length);
    }

    private void update(ByteBuffer buffer) {
        int pos = buffer.position();
        int limit = buffer.limit();
        if (!f101assertionsDisabled) {
            if (!(pos <= limit)) {
                throw new AssertionError();
            }
        }
        int rem = limit - pos;
        if (rem > 0) {
            if (buffer instanceof DirectBuffer) {
                this.adler = updateByteBuffer(this.adler, ((DirectBuffer) buffer).address(), pos, rem);
            } else if (buffer.hasArray()) {
                this.adler = updateBytes(this.adler, buffer.array(), buffer.arrayOffset() + pos, rem);
            } else {
                byte[] b = new byte[rem];
                buffer.get(b);
                this.adler = updateBytes(this.adler, b, 0, b.length);
            }
            buffer.position(limit);
        }
    }

    public void reset() {
        this.adler = 1;
    }

    public long getValue() {
        return ((long) this.adler) & 4294967295L;
    }
}
