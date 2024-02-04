package java.nio;

import libcore.io.Memory;

class ByteBufferAsLongBuffer extends LongBuffer {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f16assertionsDisabled = false;
    protected final ByteBuffer bb;
    protected final int offset;
    private final ByteOrder order;

    ByteBufferAsLongBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order2) {
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

    public LongBuffer slice() {
        boolean z = true;
        int pos = position();
        int lim = limit();
        if (!f16assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 3) + this.offset;
        if (!f16assertionsDisabled) {
            if (off < 0) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return new ByteBufferAsLongBuffer(this.bb, -1, 0, rem, rem, off, this.order);
    }

    public LongBuffer duplicate() {
        return new ByteBufferAsLongBuffer(this.bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    public LongBuffer asReadOnlyBuffer() {
        return new ByteBufferAsLongBuffer(this.bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    /* access modifiers changed from: protected */
    public int ix(int i) {
        return (i << 3) + this.offset;
    }

    public long get() {
        return get(nextGetIndex());
    }

    public long get(int i) {
        return this.bb.getLongUnchecked(ix(checkIndex(i)));
    }

    public LongBuffer get(long[] dst, int offset2, int length) {
        checkBounds(offset2, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.bb.getUnchecked(ix(this.position), dst, offset2, length);
        this.position += length;
        return this;
    }

    public LongBuffer put(long x) {
        put(nextPutIndex(), x);
        return this;
    }

    public LongBuffer put(int i, long x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.bb.putLongUnchecked(ix(checkIndex(i)), x);
        return this;
    }

    public LongBuffer put(long[] src, int offset2, int length) {
        checkBounds(offset2, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.bb.putUnchecked(ix(this.position), src, offset2, length);
        this.position += length;
        return this;
    }

    public LongBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        if (!f16assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        if (!(this.bb instanceof DirectByteBuffer)) {
            System.arraycopy(this.bb.array(), ix(pos), this.bb.array(), ix(0), rem << 3);
        } else {
            Memory.memmove(this, ix(0), this, ix(pos), (long) (rem << 3));
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
