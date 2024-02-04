package sun.misc;

public class FpUtils {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f111assertionsDisabled = false;
    static double twoToTheDoubleScaleDown;
    static double twoToTheDoubleScaleUp;

    private FpUtils() {
    }

    public static int getExponent(double d) {
        return (int) (((Double.doubleToRawLongBits(d) & DoubleConsts.EXP_BIT_MASK) >> 52) - 1023);
    }

    public static int getExponent(float f) {
        return ((Float.floatToRawIntBits(f) & FloatConsts.EXP_BIT_MASK) >> 23) - 127;
    }

    static double powerOfTwoD(int n) {
        boolean z = false;
        if (!f111assertionsDisabled) {
            if (n >= -1022 && n <= 1023) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return Double.longBitsToDouble(((((long) n) + 1023) << 52) & DoubleConsts.EXP_BIT_MASK);
    }

    static float powerOfTwoF(int n) {
        boolean z = false;
        if (!f111assertionsDisabled) {
            if (n >= -126 && n <= 127) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return Float.intBitsToFloat(((n + 127) << 23) & FloatConsts.EXP_BIT_MASK);
    }

    public static double rawCopySign(double magnitude, double sign) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(sign) & Long.MIN_VALUE) | (Double.doubleToRawLongBits(magnitude) & Long.MAX_VALUE));
    }

    public static float rawCopySign(float magnitude, float sign) {
        return Float.intBitsToFloat((Float.floatToRawIntBits(sign) & Integer.MIN_VALUE) | (Float.floatToRawIntBits(magnitude) & Integer.MAX_VALUE));
    }

    public static boolean isFinite(double d) {
        return Math.abs(d) <= Double.MAX_VALUE;
    }

    public static boolean isFinite(float f) {
        return Math.abs(f) <= Float.MAX_VALUE;
    }

    public static boolean isInfinite(double d) {
        return Double.isInfinite(d);
    }

    public static boolean isInfinite(float f) {
        return Float.isInfinite(f);
    }

    public static boolean isNaN(double d) {
        return Double.isNaN(d);
    }

    public static boolean isNaN(float f) {
        return Float.isNaN(f);
    }

    public static boolean isUnordered(double arg1, double arg2) {
        if (!isNaN(arg1)) {
            return isNaN(arg2);
        }
        return true;
    }

    public static boolean isUnordered(float arg1, float arg2) {
        if (!isNaN(arg1)) {
            return isNaN(arg2);
        }
        return true;
    }

    public static int ilogb(double d) {
        boolean z = true;
        boolean z2 = false;
        int exponent = getExponent(d);
        switch (exponent) {
            case -1023:
                if (d == 0.0d) {
                    return -268435456;
                }
                long transducer = Double.doubleToRawLongBits(d) & DoubleConsts.SIGNIF_BIT_MASK;
                if (!f111assertionsDisabled) {
                    if (!(transducer != 0)) {
                        throw new AssertionError();
                    }
                }
                while (transducer < 4503599627370496L) {
                    transducer *= 2;
                    exponent--;
                }
                int exponent2 = exponent + 1;
                if (!f111assertionsDisabled) {
                    if (exponent2 >= -1074 && exponent2 < -1022) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                return exponent2;
            case 1024:
                if (isNaN(d)) {
                    return 1073741824;
                }
                return 268435456;
            default:
                if (!f111assertionsDisabled) {
                    if (exponent < -1022) {
                        z = false;
                    } else if (exponent > 1023) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                return exponent;
        }
    }

    public static int ilogb(float f) {
        boolean z = true;
        boolean z2 = false;
        int exponent = getExponent(f);
        switch (exponent) {
            case -127:
                if (f == 0.0f) {
                    return -268435456;
                }
                int transducer = Float.floatToRawIntBits(f) & FloatConsts.SIGNIF_BIT_MASK;
                if (!f111assertionsDisabled) {
                    if (!(transducer != 0)) {
                        throw new AssertionError();
                    }
                }
                while (transducer < 8388608) {
                    transducer *= 2;
                    exponent--;
                }
                int exponent2 = exponent + 1;
                if (!f111assertionsDisabled) {
                    if (exponent2 >= -149 && exponent2 < -126) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                return exponent2;
            case 128:
                if (isNaN(f)) {
                    return 1073741824;
                }
                return 268435456;
            default:
                if (!f111assertionsDisabled) {
                    if (exponent < -126) {
                        z = false;
                    } else if (exponent > 127) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                return exponent;
        }
    }

    public static double scalb(double d, int scale_factor) {
        int scale_factor2;
        int scale_increment;
        double exp_delta;
        if (scale_factor < 0) {
            scale_factor2 = Math.max(scale_factor, -2099);
            scale_increment = -512;
            exp_delta = twoToTheDoubleScaleDown;
        } else {
            scale_factor2 = Math.min(scale_factor, 2099);
            scale_increment = 512;
            exp_delta = twoToTheDoubleScaleUp;
        }
        int t = (scale_factor2 >> 8) >>> 23;
        int exp_adjust = ((scale_factor2 + t) & 511) - t;
        double d2 = d * powerOfTwoD(exp_adjust);
        for (int scale_factor3 = scale_factor2 - exp_adjust; scale_factor3 != 0; scale_factor3 -= scale_increment) {
            d2 *= exp_delta;
        }
        return d2;
    }

    public static float scalb(float f, int scale_factor) {
        return (float) (((double) f) * powerOfTwoD(Math.max(Math.min(scale_factor, 278), -278)));
    }

    public static double nextAfter(double start, double direction) {
        long transducer;
        long j = 1;
        if (isNaN(start) || isNaN(direction)) {
            return start + direction;
        }
        if (start == direction) {
            return direction;
        }
        long transducer2 = Double.doubleToRawLongBits(0.0d + start);
        if (direction > start) {
            if (transducer2 < 0) {
                j = -1;
            }
            transducer = transducer2 + j;
        } else {
            if (!f111assertionsDisabled) {
                if (!(direction < start)) {
                    throw new AssertionError();
                }
            }
            if (transducer2 > 0) {
                transducer = transducer2 - 1;
            } else if (transducer2 < 0) {
                transducer = transducer2 + 1;
            } else {
                transducer = -9223372036854775807L;
            }
        }
        return Double.longBitsToDouble(transducer);
    }

    public static float nextAfter(float start, double direction) {
        int transducer;
        int i = 1;
        if (isNaN(start) || isNaN(direction)) {
            return ((float) direction) + start;
        }
        if (((double) start) == direction) {
            return (float) direction;
        }
        int transducer2 = Float.floatToRawIntBits(0.0f + start);
        if (direction > ((double) start)) {
            if (transducer2 < 0) {
                i = -1;
            }
            transducer = transducer2 + i;
        } else {
            if (!f111assertionsDisabled) {
                if (direction >= ((double) start)) {
                    i = 0;
                }
                if (i == 0) {
                    throw new AssertionError();
                }
            }
            if (transducer2 > 0) {
                transducer = transducer2 - 1;
            } else if (transducer2 < 0) {
                transducer = transducer2 + 1;
            } else {
                transducer = -2147483647;
            }
        }
        return Float.intBitsToFloat(transducer);
    }

    public static double nextUp(double d) {
        if (isNaN(d) || d == Double.POSITIVE_INFINITY) {
            return d;
        }
        double d2 = d + 0.0d;
        return Double.longBitsToDouble((d2 >= 0.0d ? 1 : -1) + Double.doubleToRawLongBits(d2));
    }

    public static float nextUp(float f) {
        if (isNaN(f) || f == Float.POSITIVE_INFINITY) {
            return f;
        }
        float f2 = f + 0.0f;
        return Float.intBitsToFloat((f2 >= 0.0f ? 1 : -1) + Float.floatToRawIntBits(f2));
    }

    public static double nextDown(double d) {
        if (isNaN(d) || d == Double.NEGATIVE_INFINITY) {
            return d;
        }
        if (d == 0.0d) {
            return -4.9E-324d;
        }
        return Double.longBitsToDouble((d > 0.0d ? -1 : 1) + Double.doubleToRawLongBits(d));
    }

    public static double nextDown(float f) {
        if (isNaN(f) || f == Float.NEGATIVE_INFINITY) {
            return (double) f;
        }
        if (f == 0.0f) {
            return -1.401298464324817E-45d;
        }
        return (double) Float.intBitsToFloat((f > 0.0f ? -1 : 1) + Float.floatToRawIntBits(f));
    }

    public static double copySign(double magnitude, double sign) {
        if (isNaN(sign)) {
            sign = 1.0d;
        }
        return rawCopySign(magnitude, sign);
    }

    public static float copySign(float magnitude, float sign) {
        if (isNaN(sign)) {
            sign = 1.0f;
        }
        return rawCopySign(magnitude, sign);
    }

    public static double ulp(double d) {
        boolean z = false;
        int exp = getExponent(d);
        switch (exp) {
            case -1023:
                return Double.MIN_VALUE;
            case 1024:
                return Math.abs(d);
            default:
                if (!f111assertionsDisabled) {
                    if (exp <= 1023 && exp >= -1022) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                int exp2 = exp - 52;
                if (exp2 >= -1022) {
                    return powerOfTwoD(exp2);
                }
                return Double.longBitsToDouble(1 << (exp2 + 1074));
        }
    }

    public static float ulp(float f) {
        boolean z = false;
        int exp = getExponent(f);
        switch (exp) {
            case -127:
                return Float.MIN_VALUE;
            case 128:
                return Math.abs(f);
            default:
                if (!f111assertionsDisabled) {
                    if (exp <= 127 && exp >= -126) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                int exp2 = exp - 23;
                if (exp2 >= -126) {
                    return powerOfTwoF(exp2);
                }
                return Float.intBitsToFloat(1 << (exp2 + 149));
        }
    }

    public static double signum(double d) {
        return (d == 0.0d || isNaN(d)) ? d : copySign(1.0d, d);
    }

    public static float signum(float f) {
        return (f == 0.0f || isNaN(f)) ? f : copySign(1.0f, f);
    }
}
