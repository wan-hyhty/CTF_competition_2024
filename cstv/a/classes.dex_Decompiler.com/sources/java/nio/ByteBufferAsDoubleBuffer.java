package java.nio;

import libcore.io.Memory;

class ByteBufferAsDoubleBuffer extends DoubleBuffer {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f13assertionsDisabled = false;
    protected final ByteBuffer bb;
    protected final int offset;
    private final ByteOrder order;

    ByteBufferAsDoubleBuffer(ByteBuffer bb2, int mark, int pos, int lim, int cap, int off, ByteOrder order2) {
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

    public DoubleBuffer slice() {
        boolean z = true;
        int pos = position();
        int lim = limit();
        if (!f13assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        int off = (pos << 3) + this.offset;
        if (!f13assertionsDisabled) {
            if (off < 0) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return new ByteBufferAsDoubleBuffer(this.bb, -1, 0, rem, rem, off, this.order);
    }

    public DoubleBuffer duplicate() {
        return new ByteBufferAsDoubleBuffer(this.bb, markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    public DoubleBuffer asReadOnlyBuffer() {
        return new ByteBufferAsDoubleBuffer(this.bb.asReadOnlyBuffer(), markValue(), position(), limit(), capacity(), this.offset, this.order);
    }

    /* access modifiers changed from: protected */
    public int ix(int i) {
        return (i << 3) + this.offset;
    }

    public double get() {
        return get(nextGetIndex());
    }

    public double get(int i) {
        return this.bb.getDoubleUnchecked(ix(checkIndex(i)));
    }

    public DoubleBuffer get(double[] dst, int offset2, int length) {
        checkBounds(offset2, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        this.bb.getUnchecked(ix(this.position), dst, offset2, length);
        this.position += length;
        return this;
    }

    public DoubleBuffer put(double x) {
        put(nextPutIndex(), x);
        return this;
    }

    public DoubleBuffer put(int i, double x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        this.bb.putDoubleUnchecked(ix(checkIndex(i)), x);
        return this;
    }

    public DoubleBuffer put(double[] src, int offset2, int length) {
        checkBounds(offset2, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        this.bb.putUnchecked(ix(this.position), src, offset2, length);
        this.position += length;
        return this;
    }

    public DoubleBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        if (!f13assertionsDisabled) {
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
