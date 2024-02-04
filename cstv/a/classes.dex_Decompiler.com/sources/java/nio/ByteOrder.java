package java.nio;

public final class ByteOrder {
    public static final ByteOrder BIG_ENDIAN = null;
    public static final ByteOrder LITTLE_ENDIAN = null;
    private String name;

    private ByteOrder(String name2) {
        this.name = name2;
    }

    public static ByteOrder nativeOrder() {
        return Bits.byteOrder();
    }

    public String toString() {
        return this.name;
    }
}
