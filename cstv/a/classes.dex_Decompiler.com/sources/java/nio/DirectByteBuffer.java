package java.nio;

import dalvik.system.VMRuntime;
import java.io.FileDescriptor;
import libcore.io.Memory;
import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

public class DirectByteBuffer extends MappedByteBuffer implements DirectBuffer {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f19assertionsDisabled = false;
    final Cleaner cleaner;
    final MemoryRef memoryRef;

    static class MemoryRef {
        long allocatedAddress;
        byte[] buffer;
        boolean isAccessible;
        final int offset;

        MemoryRef(int capacity) {
            VMRuntime runtime = VMRuntime.getRuntime();
            this.buffer = (byte[]) runtime.newNonMovableArray(Byte.TYPE, capacity + 7);
            this.allocatedAddress = runtime.addressOf(this.buffer);
            this.offset = (int) (((this.allocatedAddress + 7) & -8) - this.allocatedAddress);
            this.isAccessible = true;
        }

        MemoryRef(long allocatedAddress2) {
            this.buffer = null;
            this.allocatedAddress = allocatedAddress2;
            this.offset = 0;
            this.isAccessible = true;
        }

        /* access modifiers changed from: package-private */
        public void free() {
            this.buffer = null;
            this.allocatedAddress = 0;
            this.isAccessible = false;
        }
    }

    DirectByteBuffer(int capacity, MemoryRef memoryRef2) {
        super(-1, 0, capacity, capacity, memoryRef2.buffer, memoryRef2.offset);
        this.memoryRef = memoryRef2;
        this.address = memoryRef2.allocatedAddress + ((long) memoryRef2.offset);
        this.cleaner = null;
        this.isReadOnly = false;
    }

    private DirectByteBuffer(long addr, int cap) {
        super(-1, 0, cap, cap);
        this.memoryRef = new MemoryRef(addr);
        this.address = addr;
        this.cleaner = null;
    }

    public DirectByteBuffer(int cap, long addr, FileDescriptor fd, Runnable unmapper, boolean isReadOnly) {
        super(-1, 0, cap, cap, fd);
        this.isReadOnly = isReadOnly;
        this.memoryRef = new MemoryRef(addr);
        this.address = addr;
        this.cleaner = Cleaner.create(this.memoryRef, unmapper);
    }

    DirectByteBuffer(MemoryRef memoryRef2, int mark, int pos, int lim, int cap, int off) {
        this(memoryRef2, mark, pos, lim, cap, off, false);
    }

    DirectByteBuffer(MemoryRef memoryRef2, int mark, int pos, int lim, int cap, int off, boolean isReadOnly) {
        super(mark, pos, lim, cap, memoryRef2.buffer, off);
        this.isReadOnly = isReadOnly;
        this.memoryRef = memoryRef2;
        this.address = memoryRef2.allocatedAddress + ((long) off);
        this.cleaner = null;
    }

    public Object attachment() {
        return this.memoryRef;
    }

    public Cleaner cleaner() {
        return this.cleaner;
    }

    public ByteBuffer slice() {
        boolean z = true;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int pos = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        int off = pos + this.offset;
        if (!f19assertionsDisabled) {
            if (off < 0) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return new DirectByteBuffer(this.memoryRef, -1, 0, rem, rem, off, this.isReadOnly);
    }

    public ByteBuffer duplicate() {
        if (this.memoryRef.isAccessible) {
            return new DirectByteBuffer(this.memoryRef, markValue(), position(), limit(), capacity(), this.offset, this.isReadOnly);
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public ByteBuffer asReadOnlyBuffer() {
        if (this.memoryRef.isAccessible) {
            return new DirectByteBuffer(this.memoryRef, markValue(), position(), limit(), capacity(), this.offset, true);
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public long address() {
        return this.address;
    }

    private long ix(int i) {
        return this.address + ((long) i);
    }

    private byte get(long a) {
        return Memory.peekByte(a);
    }

    public byte get() {
        if (this.memoryRef.isAccessible) {
            return get(ix(nextGetIndex()));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public byte get(int i) {
        if (this.memoryRef.isAccessible) {
            return get(ix(checkIndex(i)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public ByteBuffer get(byte[] dst, int dstOffset, int length) {
        int rem = 0;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        checkBounds(dstOffset, length, dst.length);
        int pos = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        if (pos <= lim) {
            rem = lim - pos;
        }
        if (length > rem) {
            throw new BufferUnderflowException();
        }
        Memory.peekByteArray(ix(pos), dst, dstOffset, length);
        this.position = pos + length;
        return this;
    }

    public ByteBuffer put(long a, byte x) {
        Memory.pokeByte(a, x);
        return this;
    }

    public ByteBuffer put(byte x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            put(ix(nextPutIndex()), x);
            return this;
        }
    }

    public ByteBuffer put(int i, byte x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            put(ix(checkIndex(i)), x);
            return this;
        }
    }

    public ByteBuffer put(byte[] src, int srcOffset, int length) {
        int rem = 0;
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            checkBounds(srcOffset, length, src.length);
            int pos = position();
            int lim = limit();
            if (!f19assertionsDisabled) {
                if (!(pos <= lim)) {
                    throw new AssertionError();
                }
            }
            if (pos <= lim) {
                rem = lim - pos;
            }
            if (length > rem) {
                throw new BufferOverflowException();
            }
            Memory.pokeByteArray(ix(pos), src, srcOffset, length);
            this.position = pos + length;
            return this;
        }
    }

    public ByteBuffer compact() {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            int pos = position();
            int lim = limit();
            if (!f19assertionsDisabled) {
                if (!(pos <= lim)) {
                    throw new AssertionError();
                }
            }
            int rem = pos <= lim ? lim - pos : 0;
            System.arraycopy(this.hb, this.position + this.offset, this.hb, this.offset, remaining());
            position(rem);
            limit(capacity());
            discardMark();
            return this;
        }
    }

    public boolean isDirect() {
        return true;
    }

    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    /* access modifiers changed from: package-private */
    public byte _get(int i) {
        return get(i);
    }

    /* access modifiers changed from: package-private */
    public void _put(int i, byte b) {
        put(i, b);
    }

    private char getChar(long a) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return (char) Memory.peekShort((long) this.position, !this.nativeByteOrder);
    }

    public char getChar() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int newPosition = this.position + 2;
        if (newPosition > limit()) {
            throw new BufferUnderflowException();
        }
        char x = (char) Memory.peekShort(ix(this.position), !this.nativeByteOrder);
        this.position = newPosition;
        return x;
    }

    public char getChar(int i) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        checkIndex(i, 2);
        return (char) Memory.peekShort(ix(i), !this.nativeByteOrder);
    }

    /* access modifiers changed from: package-private */
    public char getCharUnchecked(int i) {
        return (char) Memory.peekShort(ix(i), !this.nativeByteOrder);
    }

    /* access modifiers changed from: package-private */
    public void getUnchecked(int pos, char[] dst, int dstOffset, int length) {
        Memory.peekCharArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putChar(long a, char x) {
        Memory.pokeShort(a, (short) x, !this.nativeByteOrder);
        return this;
    }

    public ByteBuffer putChar(char x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putChar(ix(nextPutIndex(2)), x);
            return this;
        }
    }

    public ByteBuffer putChar(int i, char x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putChar(ix(checkIndex(i, 2)), x);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void putCharUnchecked(int i, char x) {
        putChar(ix(i), x);
    }

    /* access modifiers changed from: package-private */
    public void putUnchecked(int pos, char[] src, int srcOffset, int length) {
        Memory.pokeCharArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    public CharBuffer asCharBuffer() {
        int rem;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int off = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(off <= lim)) {
                throw new AssertionError();
            }
        }
        if (off <= lim) {
            rem = lim - off;
        } else {
            rem = 0;
        }
        int size = rem >> 1;
        return new ByteBufferAsCharBuffer(this, -1, 0, size, size, off, order());
    }

    private short getShort(long a) {
        return Memory.peekShort(a, !this.nativeByteOrder);
    }

    public short getShort() {
        if (this.memoryRef.isAccessible) {
            return getShort(ix(nextGetIndex(2)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public short getShort(int i) {
        if (this.memoryRef.isAccessible) {
            return getShort(ix(checkIndex(i, 2)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    /* access modifiers changed from: package-private */
    public short getShortUnchecked(int i) {
        return getShort(ix(i));
    }

    /* access modifiers changed from: package-private */
    public void getUnchecked(int pos, short[] dst, int dstOffset, int length) {
        Memory.peekShortArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putShort(long a, short x) {
        Memory.pokeShort(a, x, !this.nativeByteOrder);
        return this;
    }

    public ByteBuffer putShort(short x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putShort(ix(nextPutIndex(2)), x);
            return this;
        }
    }

    public ByteBuffer putShort(int i, short x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putShort(ix(checkIndex(i, 2)), x);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void putShortUnchecked(int i, short x) {
        putShort(ix(i), x);
    }

    /* access modifiers changed from: package-private */
    public void putUnchecked(int pos, short[] src, int srcOffset, int length) {
        Memory.pokeShortArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    public ShortBuffer asShortBuffer() {
        int rem;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int off = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(off <= lim)) {
                throw new AssertionError();
            }
        }
        if (off <= lim) {
            rem = lim - off;
        } else {
            rem = 0;
        }
        int size = rem >> 1;
        return new ByteBufferAsShortBuffer(this, -1, 0, size, size, off, order());
    }

    private int getInt(long a) {
        return Memory.peekInt(a, !this.nativeByteOrder);
    }

    public int getInt() {
        if (this.memoryRef.isAccessible) {
            return getInt(ix(nextGetIndex(4)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public int getInt(int i) {
        if (this.memoryRef.isAccessible) {
            return getInt(ix(checkIndex(i, 4)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    /* access modifiers changed from: package-private */
    public int getIntUnchecked(int i) {
        return getInt(ix(i));
    }

    /* access modifiers changed from: package-private */
    public void getUnchecked(int pos, int[] dst, int dstOffset, int length) {
        Memory.peekIntArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putInt(long a, int x) {
        Memory.pokeInt(a, x, !this.nativeByteOrder);
        return this;
    }

    public ByteBuffer putInt(int x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putInt(ix(nextPutIndex(4)), x);
            return this;
        }
    }

    public ByteBuffer putInt(int i, int x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putInt(ix(checkIndex(i, 4)), x);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void putIntUnchecked(int i, int x) {
        putInt(ix(i), x);
    }

    /* access modifiers changed from: package-private */
    public void putUnchecked(int pos, int[] src, int srcOffset, int length) {
        Memory.pokeIntArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    public IntBuffer asIntBuffer() {
        int rem;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int off = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(off <= lim)) {
                throw new AssertionError();
            }
        }
        if (off <= lim) {
            rem = lim - off;
        } else {
            rem = 0;
        }
        int size = rem >> 2;
        return new ByteBufferAsIntBuffer(this, -1, 0, size, size, off, order());
    }

    private long getLong(long a) {
        return Memory.peekLong(a, !this.nativeByteOrder);
    }

    public long getLong() {
        if (this.memoryRef.isAccessible) {
            return getLong(ix(nextGetIndex(8)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public long getLong(int i) {
        if (this.memoryRef.isAccessible) {
            return getLong(ix(checkIndex(i, 8)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    /* access modifiers changed from: package-private */
    public long getLongUnchecked(int i) {
        return getLong(ix(i));
    }

    /* access modifiers changed from: package-private */
    public void getUnchecked(int pos, long[] dst, int dstOffset, int length) {
        Memory.peekLongArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putLong(long a, long x) {
        Memory.pokeLong(a, x, !this.nativeByteOrder);
        return this;
    }

    public ByteBuffer putLong(long x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putLong(ix(nextPutIndex(8)), x);
            return this;
        }
    }

    public ByteBuffer putLong(int i, long x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putLong(ix(checkIndex(i, 8)), x);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void putLongUnchecked(int i, long x) {
        putLong(ix(i), x);
    }

    /* access modifiers changed from: package-private */
    public void putUnchecked(int pos, long[] src, int srcOffset, int length) {
        Memory.pokeLongArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    public LongBuffer asLongBuffer() {
        int rem;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int off = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(off <= lim)) {
                throw new AssertionError();
            }
        }
        if (off <= lim) {
            rem = lim - off;
        } else {
            rem = 0;
        }
        int size = rem >> 3;
        return new ByteBufferAsLongBuffer(this, -1, 0, size, size, off, order());
    }

    private float getFloat(long a) {
        return Float.intBitsToFloat(Memory.peekInt(a, !this.nativeByteOrder));
    }

    public float getFloat() {
        if (this.memoryRef.isAccessible) {
            return getFloat(ix(nextGetIndex(4)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public float getFloat(int i) {
        if (this.memoryRef.isAccessible) {
            return getFloat(ix(checkIndex(i, 4)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    /* access modifiers changed from: package-private */
    public float getFloatUnchecked(int i) {
        return getFloat(ix(i));
    }

    /* access modifiers changed from: package-private */
    public void getUnchecked(int pos, float[] dst, int dstOffset, int length) {
        Memory.peekFloatArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putFloat(long a, float x) {
        Memory.pokeInt(a, Float.floatToRawIntBits(x), !this.nativeByteOrder);
        return this;
    }

    public ByteBuffer putFloat(float x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putFloat(ix(nextPutIndex(4)), x);
            return this;
        }
    }

    public ByteBuffer putFloat(int i, float x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putFloat(ix(checkIndex(i, 4)), x);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void putFloatUnchecked(int i, float x) {
        putFloat(ix(i), x);
    }

    /* access modifiers changed from: package-private */
    public void putUnchecked(int pos, float[] src, int srcOffset, int length) {
        Memory.pokeFloatArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    public FloatBuffer asFloatBuffer() {
        int rem;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int off = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(off <= lim)) {
                throw new AssertionError();
            }
        }
        if (off <= lim) {
            rem = lim - off;
        } else {
            rem = 0;
        }
        int size = rem >> 2;
        return new ByteBufferAsFloatBuffer(this, -1, 0, size, size, off, order());
    }

    private double getDouble(long a) {
        return Double.longBitsToDouble(Memory.peekLong(a, !this.nativeByteOrder));
    }

    public double getDouble() {
        if (this.memoryRef.isAccessible) {
            return getDouble(ix(nextGetIndex(8)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    public double getDouble(int i) {
        if (this.memoryRef.isAccessible) {
            return getDouble(ix(checkIndex(i, 8)));
        }
        throw new IllegalStateException("buffer is inaccessible");
    }

    /* access modifiers changed from: package-private */
    public double getDoubleUnchecked(int i) {
        return getDouble(ix(i));
    }

    /* access modifiers changed from: package-private */
    public void getUnchecked(int pos, double[] dst, int dstOffset, int length) {
        Memory.peekDoubleArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putDouble(long a, double x) {
        Memory.pokeLong(a, Double.doubleToRawLongBits(x), !this.nativeByteOrder);
        return this;
    }

    public ByteBuffer putDouble(double x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putDouble(ix(nextPutIndex(8)), x);
            return this;
        }
    }

    public ByteBuffer putDouble(int i, double x) {
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        } else if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        } else {
            putDouble(ix(checkIndex(i, 8)), x);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void putDoubleUnchecked(int i, double x) {
        putDouble(ix(i), x);
    }

    /* access modifiers changed from: package-private */
    public void putUnchecked(int pos, double[] src, int srcOffset, int length) {
        Memory.pokeDoubleArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    public DoubleBuffer asDoubleBuffer() {
        int rem;
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int off = position();
        int lim = limit();
        if (!f19assertionsDisabled) {
            if (!(off <= lim)) {
                throw new AssertionError();
            }
        }
        if (off <= lim) {
            rem = lim - off;
        } else {
            rem = 0;
        }
        int size = rem >> 3;
        return new ByteBufferAsDoubleBuffer(this, -1, 0, size, size, off, order());
    }

    public boolean isAccessible() {
        return this.memoryRef.isAccessible;
    }

    public void setAccessible(boolean value) {
        this.memoryRef.isAccessible = value;
    }
}
