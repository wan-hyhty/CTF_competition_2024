package java.nio;

import libcore.io.Memory;

class ByteBufferAsFloatBuffer extends FloatBuffer {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f14assertionsDisabled = false;
    protected final ByteBuffer bb;
    protected final int offset;
    private final ByteOrder order;

    ByteBufferAsFloatBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order2) {
        super(mark, pos, lim, cap);
        this.bb = bb2.duplicate();
        this.isReadOnly = bb2.isReadOnly;
        if (bb2 instanceof DirectByteBuffer) {
            this.address = bb2.address + ((long) off);
        }
        this.bb.order(order2);
        this.order = order2;
        this.offset = off;
    }

    public FloatBuffer slice() {
        boolean z = true;
        int pos = position();
        int lim = limit();
        if (!f14assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 2) + this.offset;
        if (!f14assertionsDisabled) {
            if (off < 0) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return new ByteBufferAsFloatBuffer(this.bb, -1, 0, rem, rem, off, this.order);
    }

    public FloatBuffer duplicate() {
        return new ByteBufferAsFloatBuffer(this.bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    public FloatBuffer asReadOnlyBuffer() {
        return new ByteBufferAsFloatBuffer(this.bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    /* access modifiers changed from: protected */
    public int ix(int i) {
        return (i << 2) + this.offset;
    }

    public float get() {
        return get(nextGetIndex());
    }

    public float get(int i) {
        return this.bb.getFloatUnchecked(ix(checkIndex(i)));
    }

    public FloatBuffer get(float[] dst, int offset2, int length) {
        checkBounds(offset2, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.bb.getUnchecked(ix(this.position), dst, offset2, length);
        this.position += length;
        return this;
    }

    public FloatBuffer put(float x) {
        put(nextPutIndex(), x);
        return this;
    }

    public FloatBuffer put(int i, float x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.bb.putFloatUnchecked(ix(checkIndex(i)), x);
        return this;
    }

    public FloatBuffer put(float[] src, int offset2, int length) {
        checkBounds(offset2, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.bb.putUnchecked(ix(this.position), src, offset2, length);
        this.position += length;
        return this;
    }

    public FloatBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        if (!f14assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        if (!(this.bb instanceof DirectByteBuffer)) {
            System.arraycopy(this.bb.array(), ix(pos), this.bb.array(), ix(0), rem << 2);
        } else {
            Memory.memmove(this, ix(0), this, ix(pos), (long) (rem << 2));
        }
        position(rem);
        limit(capacity());
        discardMark();
        return this;
    }

    public boolean isDirect() {
        return this.bb.isDirect();
    }

    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    public ByteOrder order() {
        return this.order;
    }
}
