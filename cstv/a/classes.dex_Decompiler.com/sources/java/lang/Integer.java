package java.lang;

import sun.util.locale.LanguageTag;

public final class Integer extends Number implements Comparable<Integer> {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f4assertionsDisabled = false;
    public static final int BYTES = 4;
    static final char[] DigitOnes = null;
    static final char[] DigitTens = null;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;
    public static final int SIZE = 32;
    private static final String[] SMALL_NEG_VALUES = null;
    private static final String[] SMALL_NONNEG_VALUES = null;
    public static final Class<Integer> TYPE = null;
    static final char[] digits = null;
    private static final long serialVersionUID = 1360826667806852920L;
    static final int[] sizeTable = null;
    private final int value;

    public static String toString(int i, int radix) {
        int charPos;
        int charPos2;
        boolean negative = f4assertionsDisabled;
        if (radix < 2 || radix > 36) {
            radix = 10;
        }
        if (radix == 10) {
            return toString(i);
        }
        char[] buf = new char[33];
        if (i < 0) {
            negative = true;
        }
        int charPos3 = 32;
        if (!negative) {
            i = -i;
        }
        while (true) {
            charPos = charPos3;
            if (i > (-radix)) {
                break;
            }
            int q = i / radix;
            charPos3 = charPos - 1;
            buf[charPos] = digits[(radix * q) - i];
            i = q;
        }
        buf[charPos] = digits[-i];
        if (negative) {
            charPos2 = charPos - 1;
            buf[charPos2] = '-';
        } else {
            charPos2 = charPos;
        }
        return new String(buf, charPos2, 33 - charPos2);
    }

    public static String toHexString(int i) {
        return toUnsignedString(i, 4);
    }

    public static String toOctalString(int i) {
        return toUnsignedString(i, 3);
    }

    public static String toBinaryString(int i) {
        return toUnsignedString(i, 1);
    }

    private static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int mask = (1 << shift) - 1;
        do {
            charPos--;
            buf[charPos] = digits[i & mask];
            i >>>= shift;
        } while (i != 0);
        return new String(buf, charPos, 32 - charPos);
    }

    public static String toString(int i) {
        boolean negative;
        boolean small;
        String str;
        String str2;
        if (i == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        if (i < 0) {
            negative = true;
        } else {
            negative = false;
        }
        if (!negative ? i >= 100 : i <= -100) {
            small = false;
        } else {
            small = true;
        }
        if (small) {
            String[] smallValues = negative ? SMALL_NEG_VALUES : SMALL_NONNEG_VALUES;
            if (negative) {
                i = -i;
                if (smallValues[i] == null) {
                    if (i < 10) {
                        str2 = new String(new char[]{'-', DigitOnes[i]});
                    } else {
                        str2 = new String(new char[]{'-', DigitTens[i], DigitOnes[i]});
                    }
                    smallValues[i] = str2;
                }
            } else if (smallValues[i] == null) {
                if (i < 10) {
                    str = new String(new char[]{DigitOnes[i]});
                } else {
                    str = new String(new char[]{DigitTens[i], DigitOnes[i]});
                }
                smallValues[i] = str;
            }
            return smallValues[i];
        }
        int size = negative ? stringSize(-i) + 1 : stringSize(i);
        char[] buf = new char[size];
        getChars(i, size, buf);
        return new String(buf);
    }

    static void getChars(int i, int index, char[] buf) {
        int q;
        int charPos = index;
        char sign = 0;
        if (i < 0) {
            sign = '-';
            i = -i;
        }
        while (i >= 65536) {
            int q2 = i / 100;
            int r = i - (((q2 << 6) + (q2 << 5)) + (q2 << 2));
            i = q2;
            int charPos2 = charPos - 1;
            buf[charPos2] = DigitOnes[r];
            charPos = charPos2 - 1;
            buf[charPos] = DigitTens[r];
        }
        do {
            q = (52429 * i) >>> 19;
            charPos--;
            buf[charPos] = digits[i - ((q << 3) + (q << 1))];
            i = q;
        } while (q != 0);
        if (sign != 0) {
            buf[charPos - 1] = sign;
        }
    }

    static int stringSize(int x) {
        int i = 0;
        while (x > sizeTable[i]) {
            i++;
        }
        return i + 1;
    }

    public static int parseInt(String s, int radix) throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null");
        } else if (radix < 2) {
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        } else if (radix > 36) {
            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        } else {
            int result = 0;
            boolean negative = f4assertionsDisabled;
            int i = 0;
            int len = s.length();
            int limit = -2147483647;
            if (len > 0) {
                char firstChar = s.charAt(0);
                if (firstChar < '0') {
                    if (firstChar == '-') {
                        negative = true;
                        limit = Integer.MIN_VALUE;
                    } else if (firstChar != '+') {
                        throw NumberFormatException.forInputString(s);
                    }
                    if (len == 1) {
                        throw NumberFormatException.forInputString(s);
                    }
                    i = 1;
                }
                int multmin = limit / radix;
                int i2 = i;
                while (i2 < len) {
                    int i3 = i2 + 1;
                    int digit = Character.digit(s.charAt(i2), radix);
                    if (digit < 0) {
                        throw NumberFormatException.forInputString(s);
                    } else if (result < multmin) {
                        throw NumberFormatException.forInputString(s);
                    } else {
                        int result2 = result * radix;
                        if (result2 < limit + digit) {
                            throw NumberFormatException.forInputString(s);
                        }
                        result = result2 - digit;
                        i2 = i3;
                    }
                }
                return negative ? result : -result;
            }
            throw NumberFormatException.forInputString(s);
        }
    }

    public static int parseInt(String s) throws NumberFormatException {
        return parseInt(s, 10);
    }

    public static Integer valueOf(String s, int radix) throws NumberFormatException {
        return valueOf(parseInt(s, radix));
    }

    public static Integer valueOf(String s) throws NumberFormatException {
        return valueOf(parseInt(s, 10));
    }

    private static class IntegerCache {
        static final Integer[] cache = null;
        static final int high = 0;
        static final int low = -128;

        private IntegerCache() {
        }
    }

    public static Integer valueOf(int i) {
        if (!f4assertionsDisabled) {
            if (!(IntegerCache.high >= 127 ? true : f4assertionsDisabled)) {
                throw new AssertionError();
            }
        }
        if (i < -128 || i > IntegerCache.high) {
            return new Integer(i);
        }
        return IntegerCache.cache[i + 128];
    }

    public Integer(int value2) {
        this.value = value2;
    }

    public Integer(String s) throws NumberFormatException {
        this.value = parseInt(s, 10);
    }

    public byte byteValue() {
        return (byte) this.value;
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
        return toString(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public static int hashCode(int value2) {
        return value2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Integer) || this.value != ((Integer) obj).intValue()) {
            return f4assertionsDisabled;
        }
        return true;
    }

    public static Integer getInteger(String nm) {
        return getInteger(nm, (Integer) null);
    }

    public static Integer getInteger(String nm, int val) {
        Integer result = getInteger(nm, (Integer) null);
        return result == null ? valueOf(val) : result;
    }

    public static Integer getInteger(String nm, Integer val) {
        String v = null;
        try {
            v = System.getProperty(nm);
        } catch (IllegalArgumentException e) {
        } catch (NullPointerException e2) {
        }
        if (v != null) {
            try {
                return decode(v);
            } catch (NumberFormatException e3) {
            }
        }
        return val;
    }

    public static Integer decode(String nm) throws NumberFormatException {
        String constant;
        int radix = 10;
        int index = 0;
        boolean negative = f4assertionsDisabled;
        if (nm.length() == 0) {
            throw new NumberFormatException("Zero length string");
        }
        char firstChar = nm.charAt(0);
        if (firstChar == '-') {
            negative = true;
            index = 1;
        } else if (firstChar == '+') {
            index = 1;
        }
        if (nm.startsWith("0x", index) || nm.startsWith("0X", index)) {
            index += 2;
            radix = 16;
        } else if (nm.startsWith("#", index)) {
            index++;
            radix = 16;
        } else if (nm.startsWith("0", index) && nm.length() > index + 1) {
            index++;
            radix = 8;
        }
        if (nm.startsWith(LanguageTag.SEP, index) || nm.startsWith("+", index)) {
            throw new NumberFormatException("Sign character in wrong position");
        }
        try {
            Integer result = valueOf(nm.substring(index), radix);
            if (negative) {
                return valueOf(-result.intValue());
            }
            return result;
        } catch (NumberFormatException e) {
            if (negative) {
                constant = LanguageTag.SEP + nm.substring(index);
            } else {
                constant = nm.substring(index);
            }
            return valueOf(constant, radix);
        }
    }

    public int compareTo(Integer anotherInteger) {
        return compare(this.value, anotherInteger.value);
    }

    public static int compare(int x, int y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }

    public static int highestOneBit(int i) {
        int i2 = i | (i >> 1);
        int i3 = i2 | (i2 >> 2);
        int i4 = i3 | (i3 >> 4);
        int i5 = i4 | (i4 >> 8);
        int i6 = i5 | (i5 >> 16);
        return i6 - (i6 >>> 1);
    }

    public static int lowestOneBit(int i) {
        return (-i) & i;
    }

    public static int numberOfLeadingZeros(int i) {
        if (i == 0) {
            return 32;
        }
        int n = 1;
        if ((i >>> 16) == 0) {
            n = 17;
            i <<= 16;
        }
        if ((i >>> 24) == 0) {
            n += 8;
            i <<= 8;
        }
        if ((i >>> 28) == 0) {
            n += 4;
            i <<= 4;
        }
        if ((i >>> 30) == 0) {
            n += 2;
            i <<= 2;
        }
        return n - (i >>> 31);
    }

    public static int numberOfTrailingZeros(int i) {
        if (i == 0) {
            return 32;
        }
        int n = 31;
        int y = i << 16;
        if (y != 0) {
            n = 15;
            i = y;
        }
        int y2 = i << 8;
        if (y2 != 0) {
            n -= 8;
            i = y2;
        }
        int y3 = i << 4;
        if (y3 != 0) {
            n -= 4;
            i = y3;
        }
        int y4 = i << 2;
        if (y4 != 0) {
            n -= 2;
            i = y4;
        }
        return n - ((i << 1) >>> 31);
    }

    public static int bitCount(int i) {
        int i2 = i - ((i >>> 1) & 1431655765);
        int i3 = (i2 & 858993459) + ((i2 >>> 2) & 858993459);
        int i4 = ((i3 >>> 4) + i3) & 252645135;
        int i5 = i4 + (i4 >>> 8);
        return (i5 + (i5 >>> 16)) & 63;
    }

    public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> (-distance));
    }

    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << (-distance));
    }

    public static int reverse(int i) {
        int i2 = ((i & 1431655765) << 1) | ((i >>> 1) & 1431655765);
        int i3 = ((i2 & 858993459) << 2) | ((i2 >>> 2) & 858993459);
        int i4 = ((i3 & 252645135) << 4) | ((i3 >>> 4) & 252645135);
        return (i4 << 24) | ((i4 & 65280) << 8) | ((i4 >>> 8) & 65280) | (i4 >>> 24);
    }

    public static int signum(int i) {
        return (i >> 31) | ((-i) >>> 31);
    }

    public static int reverseBytes(int i) {
        return (i >>> 24) | ((i >> 8) & 65280) | ((i << 8) & 16711680) | (i << 24);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }
}
