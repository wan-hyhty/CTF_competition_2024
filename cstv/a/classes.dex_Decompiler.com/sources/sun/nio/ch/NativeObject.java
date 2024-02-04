package sun.nio.ch;

import java.nio.ByteOrder;
import sun.misc.Unsafe;

class NativeObject {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f128assertionsDisabled = false;
    private static ByteOrder byteOrder;
    private static int pageSize;
    protected static final Unsafe unsafe = null;
    private final long address;
    protected long allocationAddress;

    NativeObject(long address2) {
        this.allocationAddress = address2;
        this.address = address2;
    }

    NativeObject(long address2, long offset) {
        this.allocationAddress = address2;
        this.address = address2 + offset;
    }

    protected NativeObject(int size, boolean pageAligned) {
        if (!pageAligned) {
            this.allocationAddress = unsafe.allocateMemory((long) size);
            this.address = this.allocationAddress;
            return;
        }
        int ps = pageSize();
        long a = unsafe.allocateMemory((long) (size + ps));
        this.allocationAddress = a;
        this.address = (((long) ps) + a) - (((long) (ps - 1)) & a);
    }

    /* access modifiers changed from: package-private */
    public long address() {
        return this.address;
    }

    /* access modifiers changed from: package-private */
    public long allocationAddress() {
        return this.allocationAddress;
    }

    /* access modifiers changed from: package-private */
    public NativeObject subObject(int offset) {
        return new NativeObject(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public NativeObject getObject(int offset) {
        long newAddress;
        switch (addressSize()) {
            case 4:
                newAddress = (long) (unsafe.getInt(((long) offset) + this.address) & -1);
                break;
            case 8:
                newAddress = unsafe.getLong(((long) offset) + this.address);
                break;
            default:
                throw new InternalError("Address size not supported");
        }
        return new NativeObject(newAddress);
    }

    /* access modifiers changed from: package-private */
    public void putObject(int offset, NativeObject ob) {
        switch (addressSize()) {
            case 4:
                putInt(offset, (int) (ob.address & -1));
                return;
            case 8:
                putLong(offset, ob.address);
                return;
            default:
                throw new InternalError("Address size not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public final byte getByte(int offset) {
        return unsafe.getByte(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public final void putByte(int offset, byte value) {
        unsafe.putByte(((long) offset) + this.address, value);
    }

    /* access modifiers changed from: package-private */
    public final short getShort(int offset) {
        return unsafe.getShort(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public final void putShort(int offset, short value) {
        unsafe.putShort(((long) offset) + this.address, value);
    }

    /* access modifiers changed from: package-private */
    public final char getChar(int offset) {
        return unsafe.getChar(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public final void putChar(int offset, char value) {
        unsafe.putChar(((long) offset) + this.address, value);
    }

    /* access modifiers changed from: package-private */
    public final int getInt(int offset) {
        return unsafe.getInt(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public final void putInt(int offset, int value) {
        unsafe.putInt(((long) offset) + this.address, value);
    }

    /* access modifiers changed from: package-private */
    public final long getLong(int offset) {
        return unsafe.getLong(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public final void putLong(int offset, long value) {
        unsafe.putLong(((long) offset) + this.address, value);
    }

    /* access modifiers changed from: package-private */
    public final float getFloat(int offset) {
        return unsafe.getFloat(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public final void putFloat(int offset, float value) {
        unsafe.putFloat(((long) offset) + this.address, value);
    }

    /* access modifiers changed from: package-private */
    public final double getDouble(int offset) {
        return unsafe.getDouble(((long) offset) + this.address);
    }

    /* access modifiers changed from: package-private */
    public final void putDouble(int offset, double value) {
        unsafe.putDouble(((long) offset) + this.address, value);
    }

    static int addressSize() {
        return unsafe.addressSize();
    }

    /* JADX INFO: finally extract failed */
    static ByteOrder byteOrder() {
        if (byteOrder != null) {
            return byteOrder;
        }
        long a = unsafe.allocateMemory(8);
        try {
            unsafe.putLong(a, 72623859790382856L);
            switch (unsafe.getByte(a)) {
                case 1:
                    byteOrder = ByteOrder.BIG_ENDIAN;
                    break;
                case 8:
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                    break;
                default:
                    if (!f128assertionsDisabled) {
                        throw new AssertionError();
                    }
                    break;
            }
            unsafe.freeMemory(a);
            return byteOrder;
        } catch (Throwable th) {
            unsafe.freeMemory(a);
            throw th;
        }
    }

    static int pageSize() {
        if (pageSize == -1) {
            pageSize = unsafe.pageSize();
        }
        return pageSize;
    }
}
