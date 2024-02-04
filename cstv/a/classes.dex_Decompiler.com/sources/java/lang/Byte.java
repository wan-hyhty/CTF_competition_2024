package java.lang;

public final class Byte extends Number implements Comparable<Byte> {
    public static final int BYTES = 1;
    private static final char[] DIGITS = null;
    public static final byte MAX_VALUE = Byte.MAX_VALUE;
    public static final byte MIN_VALUE = Byte.MIN_VALUE;
    public static final int SIZE = 8;
    public static final Class<Byte> TYPE = null;
    private static final char[] UPPER_CASE_DIGITS = null;
    private static final long serialVersionUID = -7183698231559129828L;
    private final byte value;

    public static String toString(byte b) {
        return Integer.toString(b, 10);
    }

    private static class ByteCache {
        static final Byte[] cache = null;

        private ByteCache() {
        }
    }

    public static Byte valueOf(byte b) {
        return ByteCache.cache[b + 128];
    }

    public static byte parseByte(String s, int radix) throws NumberFormatException {
        int i = Integer.parseInt(s, radix);
        if (i >= -128 && i <= 127) {
            return (byte) i;
        }
        throw new NumberFormatException("Value out of range. Value:\"" + s + "\" Radix:" + radix);
    }

    public static byte parseByte(String s) throws NumberFormatException {
        return parseByte(s, 10);
    }

    public static Byte valueOf(String s, int radix) throws NumberFormatException {
        return valueOf(parseByte(s, radix));
    }

    public static Byte valueOf(String s) throws NumberFormatException {
        return valueOf(s, 10);
    }

    public static Byte decode(String nm) throws NumberFormatException {
        int i = Integer.decode(nm).intValue();
        if (i >= -128 && i <= 127) {
            return valueOf((byte) i);
        }
        throw new NumberFormatException("Value " + i + " out of range from input " + nm);
    }

    public Byte(byte value2) {
        this.value = value2;
    }

    public Byte(String s) throws NumberFormatException {
        this.value = parseByte(s, 10);
    }

    public byte byteValue() {
        return this.value;
    }

    public short shortValue() {
        return (short) this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(byte value2) {
        return value2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Byte) || this.value != ((Byte) obj).byteValue()) {
            return false;
        }
        return true;
    }

    public int compareTo(Byte anotherByte) {
        return compare(this.value, anotherByte.value);
    }

    public static int compare(byte x, byte y) {
        return x - y;
    }

    public static String toHexString(byte b, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        return new String(0, 2, new char[]{digits[(b >> 4) & 15], digits[b & 15]});
    }
}
