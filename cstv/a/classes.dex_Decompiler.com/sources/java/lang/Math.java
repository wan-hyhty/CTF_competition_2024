package java.lang;

import java.util.Random;
import sun.misc.DoubleConsts;
import sun.misc.FpUtils;

public final class Math {
    public static final double E = 2.718281828459045d;
    public static final double PI = 3.141592653589793d;
    private static long negativeZeroDoubleBits;
    private static long negativeZeroFloatBits;

    public static native double IEEEremainder(double d, double d2);

    public static native double acos(double d);

    public static native double asin(double d);

    public static native double atan(double d);

    public static native double atan2(double d, double d2);

    public static native double cbrt(double d);

    public static native double ceil(double d);

    public static native double cos(double d);

    public static native double cosh(double d);

    public static native double exp(double d);

    public static native double expm1(double d);

    public static native double floor(double d);

    public static native double hypot(double d, double d2);

    public static native double log(double d);

    public static native double log10(double d);

    public static native double log1p(double d);

    public static native double pow(double d, double d2);

    public static native double rint(double d);

    public static native double sin(double d);

    public static native double sinh(double d);

    public static native double sqrt(double d);

    public static native double tan(double d);

    public static native double tanh(double d);

    private Math() {
    }

    public static double toRadians(double angdeg) {
        return (angdeg / 180.0d) * 3.141592653589793d;
    }

    public static double toDegrees(double angrad) {
        return (180.0d * angrad) / 3.141592653589793d;
    }

    public static int round(float a) {
        int intBits = Float.floatToRawIntBits(a);
        int shift = 149 - ((2139095040 & intBits) >> 23);
        if ((shift & -32) != 0) {
            return (int) a;
        }
        int r = (8388607 & intBits) | 8388608;
        if (intBits < 0) {
            r = -r;
        }
        return ((r >> shift) + 1) >> 1;
    }

    public static long round(double a) {
        long longBits = Double.doubleToRawLongBits(a);
        long shift = 1074 - ((DoubleConsts.EXP_BIT_MASK & longBits) >> 52);
        if ((-64 & shift) != 0) {
            return (long) a;
        }
        long r = (DoubleConsts.SIGNIF_BIT_MASK & longBits) | 4503599627370496L;
        if (longBits < 0) {
            r = -r;
        }
        return ((r >> ((int) shift)) + 1) >> 1;
    }

    private static class NoImagePreloadHolder {
        /* access modifiers changed from: private */
        public static final Random INSTANCE = null;

        private NoImagePreloadHolder() {
        }
    }

    public static double random() {
        return NoImagePreloadHolder.INSTANCE.nextDouble();
    }

    public static void setRandomSeedInternal(long seed) {
        NoImagePreloadHolder.INSTANCE.setSeed(seed);
    }

    public static int randomIntInternal() {
        return NoImagePreloadHolder.INSTANCE.nextInt();
    }

    public static int addExact(int x, int y) {
        int r = x + y;
        if (((x ^ r) & (y ^ r)) >= 0) {
            return r;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long x, long y) {
        long r = x + y;
        if (((x ^ r) & (y ^ r)) >= 0) {
            return r;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int subtractExact(int x, int y) {
        int r = x - y;
        if (((x ^ y) & (x ^ r)) >= 0) {
            return r;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long x, long y) {
        long r = x - y;
        if (((x ^ y) & (x ^ r)) >= 0) {
            return r;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int multiplyExact(int x, int y) {
        long r = ((long) x) * ((long) y);
        if (((long) ((int) r)) == r) {
            return (int) r;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long multiplyExact(long x, long y) {
        long r = x * y;
        if (((abs(x) | abs(y)) >>> 31) == 0 || ((y == 0 || r / y == x) && (x != Long.MIN_VALUE || y != -1))) {
            return r;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int incrementExact(int a) {
        if (a != Integer.MAX_VALUE) {
            return a + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long a) {
        if (a != Long.MAX_VALUE) {
            return 1 + a;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int decrementExact(int a) {
        if (a != Integer.MIN_VALUE) {
            return a - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long decrementExact(long a) {
        if (a != Long.MIN_VALUE) {
            return a - 1;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int negateExact(int a) {
        if (a != Integer.MIN_VALUE) {
            return -a;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long a) {
        if (a != Long.MIN_VALUE) {
            return -a;
        }
        throw new ArithmeticException("long overflow");
    }

    public static int toIntExact(long value) {
        if (((long) ((int) value)) == value) {
            return (int) value;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int floorDiv(int x, int y) {
        int r = x / y;
        if ((x ^ y) >= 0 || r * y == x) {
            return r;
        }
        return r - 1;
    }

    public static long floorDiv(long x, long y) {
        long r = x / y;
        if ((x ^ y) >= 0 || r * y == x) {
            return r;
        }
        return r - 1;
    }

    public static int floorMod(int x, int y) {
        return x - (floorDiv(x, y) * y);
    }

    public static long floorMod(long x, long y) {
        return x - (floorDiv(x, y) * y);
    }

    public static int abs(int a) {
        return a < 0 ? -a : a;
    }

    public static long abs(long a) {
        return a < 0 ? -a : a;
    }

    public static float abs(float a) {
        return a <= 0.0f ? 0.0f - a : a;
    }

    public static double abs(double a) {
        return a <= 0.0d ? 0.0d - a : a;
    }

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }

    public static long max(long a, long b) {
        return a >= b ? a : b;
    }

    public static float max(float a, float b) {
        if (a != a) {
            return a;
        }
        if (a == 0.0f && b == 0.0f && ((long) Float.floatToIntBits(a)) == negativeZeroFloatBits) {
            return b;
        }
        return a >= b ? a : b;
    }

    public static double max(double a, double b) {
        if (a != a) {
            return a;
        }
        if (a == 0.0d && b == 0.0d && Double.doubleToLongBits(a) == negativeZeroDoubleBits) {
            return b;
        }
        return a >= b ? a : b;
    }

    public static int min(int a, int b) {
        return a <= b ? a : b;
    }

    public static long min(long a, long b) {
        return a <= b ? a : b;
    }

    public static float min(float a, float b) {
        if (a != a) {
            return a;
        }
        if (a == 0.0f && b == 0.0f && ((long) Float.floatToIntBits(b)) == negativeZeroFloatBits) {
            return b;
        }
        return a <= b ? a : b;
    }

    public static double min(double a, double b) {
        if (a != a) {
            return a;
        }
        if (a == 0.0d && b == 0.0d && Double.doubleToLongBits(b) == negativeZeroDoubleBits) {
            return b;
        }
        return a <= b ? a : b;
    }

    public static double ulp(double d) {
        return FpUtils.ulp(d);
    }

    public static float ulp(float f) {
        return FpUtils.ulp(f);
    }

    public static double signum(double d) {
        return FpUtils.signum(d);
    }

    public static float signum(float f) {
        return FpUtils.signum(f);
    }

    public static double copySign(double magnitude, double sign) {
        return FpUtils.rawCopySign(magnitude, sign);
    }

    public static float copySign(float magnitude, float sign) {
        return FpUtils.rawCopySign(magnitude, sign);
    }

    public static int getExponent(float f) {
        return FpUtils.getExponent(f);
    }

    public static int getExponent(double d) {
        return FpUtils.getExponent(d);
    }

    public static double nextAfter(double start, double direction) {
        return FpUtils.nextAfter(start, direction);
    }

    public static float nextAfter(float start, double direction) {
        return FpUtils.nextAfter(start, direction);
    }

    public static double nextUp(double d) {
        return FpUtils.nextUp(d);
    }

    public static float nextUp(float f) {
        return FpUtils.nextUp(f);
    }

    public static double nextDown(double d) {
        if (Double.isNaN(d) || d == Double.NEGATIVE_INFINITY) {
            return d;
        }
        if (d == 0.0d) {
            return -4.9E-324d;
        }
        return Double.longBitsToDouble((d > 0.0d ? -1 : 1) + Double.doubleToRawLongBits(d));
    }

    public static float nextDown(float f) {
        if (Float.isNaN(f) || f == Float.NEGATIVE_INFINITY) {
            return f;
        }
        if (f == 0.0f) {
            return -1.4E-45f;
        }
        return Float.intBitsToFloat((f > 0.0f ? -1 : 1) + Float.floatToRawIntBits(f));
    }

    public static double scalb(double d, int scaleFactor) {
        return FpUtils.scalb(d, scaleFactor);
    }

    public static float scalb(float f, int scaleFactor) {
        return FpUtils.scalb(f, scaleFactor);
    }
}
