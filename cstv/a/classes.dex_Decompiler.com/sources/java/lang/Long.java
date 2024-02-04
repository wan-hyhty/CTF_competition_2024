package java.lang;

import sun.util.locale.LanguageTag;

public final class Long extends Number implements Comparable<Long> {
    public static final int BYTES = 8;
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public static final long MIN_VALUE = Long.MIN_VALUE;
    public static final int SIZE = 64;
    public static final Class<Long> TYPE = null;
    private static final long serialVersionUID = 4290774380558885855L;
    private final long value;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(long r8, int r10) {
        /*
            r4 = 2
            if (r10 < r4) goto L_0x0007
            r4 = 36
            if (r10 <= r4) goto L_0x0009
        L_0x0007:
            r10 = 10
        L_0x0009:
            r4 = 10
            if (r10 != r4) goto L_0x0012
            java.lang.String r4 = toString(r8)
            return r4
        L_0x0012:
            r4 = 65
            char[] r0 = new char[r4]
            r1 = 64
            r4 = 0
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x003a
            r3 = 1
        L_0x001f:
            if (r3 != 0) goto L_0x0038
            long r8 = -r8
            r2 = r1
        L_0x0023:
            int r4 = -r10
            long r4 = (long) r4
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x003c
            int r1 = r2 + -1
            char[] r4 = java.lang.Integer.digits
            long r6 = (long) r10
            long r6 = r8 % r6
            long r6 = -r6
            int r5 = (int) r6
            char r4 = r4[r5]
            r0[r2] = r4
            long r4 = (long) r10
            long r8 = r8 / r4
        L_0x0038:
            r2 = r1
            goto L_0x0023
        L_0x003a:
            r3 = 0
            goto L_0x001f
        L_0x003c:
            char[] r4 = java.lang.Integer.digits
            long r6 = -r8
            int r5 = (int) r6
            char r4 = r4[r5]
            r0[r2] = r4
            if (r3 == 0) goto L_0x0054
            int r1 = r2 + -1
            r4 = 45
            r0[r1] = r4
        L_0x004c:
            java.lang.String r4 = new java.lang.String
            int r5 = 65 - r1
            r4.<init>((char[]) r0, (int) r1, (int) r5)
            return r4
        L_0x0054:
            r1 = r2
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Long.toString(long, int):java.lang.String");
    }

    public static String toHexString(long i) {
        return toUnsignedString(i, 4);
    }

    public static String toOctalString(long i) {
        return toUnsignedString(i, 3);
    }

    public static String toBinaryString(long i) {
        return toUnsignedString(i, 1);
    }

    private static String toUnsignedString(long i, int shift) {
        char[] buf = new char[64];
        int charPos = 64;
        long mask = (long) ((1 << shift) - 1);
        do {
            charPos--;
            buf[charPos] = Integer.digits[(int) (i & mask)];
            i >>>= shift;
        } while (i != 0);
        return new String(buf, charPos, 64 - charPos);
    }

    public static String toString(long i) {
        if (i == Long.MIN_VALUE) {
            return "-9223372036854775808";
        }
        int size = i < 0 ? stringSize(-i) + 1 : stringSize(i);
        char[] buf = new char[size];
        getChars(i, size, buf);
        return new String(buf);
    }

    static void getChars(long i, int index, char[] buf) {
        int q2;
        int charPos = index;
        char sign = 0;
        if (i < 0) {
            sign = '-';
            i = -i;
        }
        while (i > 2147483647L) {
            long q = i / 100;
            int r = (int) (i - (((q << 6) + (q << 5)) + (q << 2)));
            i = q;
            int charPos2 = charPos - 1;
            buf[charPos2] = Integer.DigitOnes[r];
            charPos = charPos2 - 1;
            buf[charPos] = Integer.DigitTens[r];
        }
        int i2 = (int) i;
        while (i2 >= 65536) {
            int q22 = i2 / 100;
            int r2 = i2 - (((q22 << 6) + (q22 << 5)) + (q22 << 2));
            i2 = q22;
            int charPos3 = charPos - 1;
            buf[charPos3] = Integer.DigitOnes[r2];
            charPos = charPos3 - 1;
            buf[charPos] = Integer.DigitTens[r2];
        }
        do {
            q2 = (52429 * i2) >>> 19;
            charPos--;
            buf[charPos] = Integer.digits[i2 - ((q2 << 3) + (q2 << 1))];
            i2 = q2;
        } while (q2 != 0);
        if (sign != 0) {
            buf[charPos - 1] = sign;
        }
    }

    static int stringSize(long x) {
        long p = 10;
        for (int i = 1; i < 19; i++) {
            if (x < p) {
                return i;
            }
            p *= 10;
        }
        return 19;
    }

    public static long parseLong(String s, int radix) throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null");
        } else if (radix < 2) {
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        } else if (radix > 36) {
            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        } else {
            long result = 0;
            boolean negative = false;
            int i = 0;
            int len = s.length();
            long limit = -9223372036854775807L;
            if (len > 0) {
                char firstChar = s.charAt(0);
                if (firstChar < '0') {
                    if (firstChar == '-') {
                        negative = true;
                        limit = Long.MIN_VALUE;
                    } else if (firstChar != '+') {
                        throw NumberFormatException.forInputString(s);
                    }
                    if (len == 1) {
                        throw NumberFormatException.forInputString(s);
                    }
                    i = 1;
                }
                long multmin = limit / ((long) radix);
                int i2 = i;
                while (i2 < len) {
                    int i3 = i2 + 1;
                    int digit = Character.digit(s.charAt(i2), radix);
                    if (digit < 0) {
                        throw NumberFormatException.forInputString(s);
                    } else if (result < multmin) {
                        throw NumberFormatException.forInputString(s);
                    } else {
                        long result2 = result * ((long) radix);
                        if (result2 < ((long) digit) + limit) {
                            throw NumberFormatException.forInputString(s);
                        }
                        result = result2 - ((long) digit);
                        i2 = i3;
                    }
                }
                return negative ? result : -result;
            }
            throw NumberFormatException.forInputString(s);
        }
    }

    public static long parseLong(String s) throws NumberFormatException {
        return parseLong(s, 10);
    }

    public static Long valueOf(String s, int radix) throws NumberFormatException {
        return valueOf(parseLong(s, radix));
    }

    public static Long valueOf(String s) throws NumberFormatException {
        return valueOf(parseLong(s, 10));
    }

    private static class LongCache {
        static final Long[] cache = null;

        private LongCache() {
        }
    }

    public static Long valueOf(long l) {
        if (l < -128 || l > 127) {
            return new Long(l);
        }
        return LongCache.cache[((int) l) + 128];
    }

    public static Long decode(String nm) throws NumberFormatException {
        String constant;
        int radix = 10;
        int index = 0;
        boolean negative = false;
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
            Long result = valueOf(nm.substring(index), radix);
            if (negative) {
                return valueOf(-result.longValue());
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

    public Long(long value2) {
        this.value = value2;
    }

    public Long(String s) throws NumberFormatException {
        this.value = parseLong(s, 10);
    }

    public byte byteValue() {
        return (byte) ((int) this.value);
    }

    public short shortValue() {
        return (short) ((int) this.value);
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
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
        return hashCode(this.value);
    }

    public static int hashCode(long value2) {
        return (int) ((value2 >>> 32) ^ value2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Long) || this.value != ((Long) obj).longValue()) {
            return false;
        }
        return true;
    }

    public static Long getLong(String nm) {
        return getLong(nm, (Long) null);
    }

    public static Long getLong(String nm, long val) {
        Long result = getLong(nm, (Long) null);
        return result == null ? valueOf(val) : result;
    }

    public static Long getLong(String nm, Long val) {
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

    public int compareTo(Long anotherLong) {
        return compare(this.value, anotherLong.value);
    }

    public static int compare(long x, long y) {
        if (x < y) {
            return -1;
        }
        return x == y ? 0 : 1;
    }

    public static long highestOneBit(long i) {
        long i2 = i | (i >> 1);
        long i3 = i2 | (i2 >> 2);
        long i4 = i3 | (i3 >> 4);
        long i5 = i4 | (i4 >> 8);
        long i6 = i5 | (i5 >> 16);
        long i7 = i6 | (i6 >> 32);
        return i7 - (i7 >>> 1);
    }

    public static long lowestOneBit(long i) {
        return (-i) & i;
    }

    public static int numberOfLeadingZeros(long i) {
        if (i == 0) {
            return 64;
        }
        int n = 1;
        int x = (int) (i >>> 32);
        if (x == 0) {
            n = 33;
            x = (int) i;
        }
        if ((x >>> 16) == 0) {
            n += 16;
            x <<= 16;
        }
        if ((x >>> 24) == 0) {
            n += 8;
            x <<= 8;
        }
        if ((x >>> 28) == 0) {
            n += 4;
            x <<= 4;
        }
        if ((x >>> 30) == 0) {
            n += 2;
            x <<= 2;
        }
        return n - (x >>> 31);
    }

    public static int numberOfTrailingZeros(long i) {
        int x;
        if (i == 0) {
            return 64;
        }
        int n = 63;
        int y = (int) i;
        if (y != 0) {
            n = 31;
            x = y;
        } else {
            x = (int) (i >>> 32);
        }
        int y2 = x << 16;
        if (y2 != 0) {
            n -= 16;
            x = y2;
        }
        int y3 = x << 8;
        if (y3 != 0) {
            n -= 8;
            x = y3;
        }
        int y4 = x << 4;
        if (y4 != 0) {
            n -= 4;
            x = y4;
        }
        int y5 = x << 2;
        if (y5 != 0) {
            n -= 2;
            x = y5;
        }
        return n - ((x << 1) >>> 31);
    }

    public static int bitCount(long i) {
        long i2 = i - ((i >>> 1) & 6148914691236517205L);
        long i3 = (i2 & 3689348814741910323L) + ((i2 >>> 2) & 3689348814741910323L);
        long i4 = ((i3 >>> 4) + i3) & 1085102592571150095L;
        long i5 = i4 + (i4 >>> 8);
        long i6 = i5 + (i5 >>> 16);
        return ((int) (i6 + (i6 >>> 32))) & 127;
    }

    public static long rotateLeft(long i, int distance) {
        return (i << distance) | (i >>> (-distance));
    }

    public static long rotateRight(long i, int distance) {
        return (i >>> distance) | (i << (-distance));
    }

    public static long reverse(long i) {
        long i2 = ((6148914691236517205L & i) << 1) | ((i >>> 1) & 6148914691236517205L);
        long i3 = ((3689348814741910323L & i2) << 2) | ((i2 >>> 2) & 3689348814741910323L);
        long i4 = ((1085102592571150095L & i3) << 4) | ((i3 >>> 4) & 1085102592571150095L);
        long i5 = ((71777214294589695L & i4) << 8) | ((i4 >>> 8) & 71777214294589695L);
        return (i5 << 48) | ((4294901760L & i5) << 16) | ((i5 >>> 16) & 4294901760L) | (i5 >>> 48);
    }

    public static int signum(long i) {
        return (int) ((i >> 63) | ((-i) >>> 63));
    }

    public static long reverseBytes(long i) {
        long i2 = ((i & 71777214294589695L) << 8) | ((i >>> 8) & 71777214294589695L);
        return (i2 << 48) | ((i2 & 4294901760L) << 16) | ((i2 >>> 16) & 4294901760L) | (i2 >>> 48);
    }

    public static long sum(long a, long b) {
        return a + b;
    }

    public static long max(long a, long b) {
        return Math.max(a, b);
    }

    public static long min(long a, long b) {
        return Math.min(a, b);
    }
}
