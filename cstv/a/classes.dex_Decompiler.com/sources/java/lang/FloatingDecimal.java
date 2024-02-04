package java.lang;

import java.sql.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.FDBigInt;
import sun.misc.FpUtils;

public class FloatingDecimal {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f3assertionsDisabled = false;
    private static final ThreadLocal<FloatingDecimal> TL_INSTANCE = null;
    private static FDBigInt[] b5p = null;
    private static final double[] big10pow = null;
    static final int bigDecimalExponent = 324;
    static final int expBias = 1023;
    static final long expMask = 9218868437227405312L;
    static final long expOne = 4607182418800017408L;
    static final int expShift = 52;
    static final long fractHOB = 4503599627370496L;
    static final long fractMask = 4503599627370495L;
    private static Pattern hexFloatPattern = null;
    static final long highbit = Long.MIN_VALUE;
    static final long highbyte = -72057594037927936L;
    private static final char[] infinity = null;
    static final int intDecimalDigits = 9;
    private static final long[] long5pow = null;
    static final long lowbytes = 72057594037927935L;
    static final int maxDecimalDigits = 15;
    static final int maxDecimalExponent = 308;
    static final int maxSmallBinExp = 62;
    private static final int maxSmallTen = 0;
    static final int minDecimalExponent = -324;
    static final int minSmallBinExp = -21;
    private static final int[] n5bits = null;
    private static final char[] notANumber = null;
    private static ThreadLocal perThreadBuffer = null;
    static final long signMask = Long.MIN_VALUE;
    static final int singleExpBias = 127;
    static final int singleExpMask = 2139095040;
    static final int singleExpShift = 23;
    static final int singleFractHOB = 8388608;
    static final int singleFractMask = 8388607;
    static final int singleMaxDecimalDigits = 7;
    static final int singleMaxDecimalExponent = 38;
    private static final int singleMaxSmallTen = 0;
    static final int singleMinDecimalExponent = -45;
    static final int singleSignMask = Integer.MIN_VALUE;
    private static final float[] singleSmall10pow = null;
    private static final double[] small10pow = null;
    private static final int[] small5pow = null;
    private static final double[] tiny10pow = null;
    private static final char[] zero = null;
    int bigIntExp;
    int bigIntNBits;
    int decExponent;
    char[] digits;
    boolean fromHex;
    boolean isExceptional;
    boolean isNegative;
    boolean mustSetRoundDir;
    int nDigits;
    int roundDir;

    /* synthetic */ FloatingDecimal(FloatingDecimal floatingDecimal) {
        this();
    }

    private static int countBits(long v) {
        if (v == 0) {
            return 0;
        }
        while ((highbyte & v) == 0) {
            v <<= 8;
        }
        while (v > 0) {
            v <<= 1;
        }
        int n = 0;
        while ((lowbytes & v) != 0) {
            v <<= 8;
            n += 8;
        }
        while (v != 0) {
            v <<= 1;
            n++;
        }
        return n;
    }

    private static synchronized FDBigInt big5pow(int p) {
        boolean z = f3assertionsDisabled;
        synchronized (FloatingDecimal.class) {
            if (!f3assertionsDisabled) {
                if (p >= 0) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError((Object) Integer.valueOf(p));
                }
            }
            if (b5p == null) {
                b5p = new FDBigInt[(p + 1)];
            } else if (b5p.length <= p) {
                FDBigInt[] t = new FDBigInt[(p + 1)];
                System.arraycopy((Object) b5p, 0, (Object) t, 0, b5p.length);
                b5p = t;
            }
            if (b5p[p] != null) {
                FDBigInt fDBigInt = b5p[p];
                return fDBigInt;
            } else if (p < small5pow.length) {
                FDBigInt fDBigInt2 = new FDBigInt(small5pow[p]);
                b5p[p] = fDBigInt2;
                return fDBigInt2;
            } else if (p < long5pow.length) {
                FDBigInt fDBigInt3 = new FDBigInt(long5pow[p]);
                b5p[p] = fDBigInt3;
                return fDBigInt3;
            } else {
                int q = p >> 1;
                int r = p - q;
                FDBigInt bigq = b5p[q];
                if (bigq == null) {
                    bigq = big5pow(q);
                }
                if (r < small5pow.length) {
                    FDBigInt mult = bigq.mult(small5pow[r]);
                    b5p[p] = mult;
                    return mult;
                }
                FDBigInt bigr = b5p[r];
                if (bigr == null) {
                    bigr = big5pow(r);
                }
                FDBigInt mult2 = bigq.mult(bigr);
                b5p[p] = mult2;
                return mult2;
            }
        }
    }

    private static FDBigInt multPow52(FDBigInt v, int p5, int p2) {
        if (p5 != 0) {
            if (p5 < small5pow.length) {
                v = v.mult(small5pow[p5]);
            } else {
                v = v.mult(big5pow(p5));
            }
        }
        if (p2 != 0) {
            v.lshiftMe(p2);
        }
        return v;
    }

    private static FDBigInt constructPow52(int p5, int p2) {
        FDBigInt v = new FDBigInt(big5pow(p5));
        if (p2 != 0) {
            v.lshiftMe(p2);
        }
        return v;
    }

    private FDBigInt doubleToBigInt(double dval) {
        long lbits = Double.doubleToLongBits(dval) & Long.MAX_VALUE;
        int binexp = (int) (lbits >>> 52);
        long lbits2 = lbits & 4503599627370495L;
        if (binexp > 0) {
            lbits2 |= fractHOB;
        } else {
            if (!f3assertionsDisabled) {
                if (!(lbits2 != 0 ? true : f3assertionsDisabled)) {
                    throw new AssertionError((Object) Long.valueOf(lbits2));
                }
            }
            binexp++;
            while ((fractHOB & lbits2) == 0) {
                lbits2 <<= 1;
                binexp--;
            }
        }
        int nbits = countBits(lbits2);
        this.bigIntExp = ((binexp - 1023) + 1) - nbits;
        this.bigIntNBits = nbits;
        return new FDBigInt(lbits2 >>> (53 - nbits));
    }

    private static double ulp(double dval, boolean subtracting) {
        double ulpval;
        long lbits = Double.doubleToLongBits(dval) & Long.MAX_VALUE;
        int binexp = (int) (lbits >>> 52);
        if (subtracting && binexp >= expShift && (4503599627370495L & lbits) == 0) {
            binexp--;
        }
        if (binexp > expShift) {
            ulpval = Double.longBitsToDouble(((long) (binexp - 52)) << 52);
        } else if (binexp == 0) {
            ulpval = Double.MIN_VALUE;
        } else {
            ulpval = Double.longBitsToDouble(1 << (binexp - 1));
        }
        if (subtracting) {
            return -ulpval;
        }
        return ulpval;
    }

    /* access modifiers changed from: package-private */
    public float stickyRound(double dval) {
        long lbits = Double.doubleToLongBits(dval);
        long binexp = lbits & 9218868437227405312L;
        if (binexp == 0 || binexp == 9218868437227405312L) {
            return (float) dval;
        }
        return (float) Double.longBitsToDouble(lbits + ((long) this.roundDir));
    }

    private void developLongDigits(int decExponent2, long lvalue, long insignificant) {
        int ndigits;
        char[] digits2;
        int digitno;
        int digitno2;
        int digitno3;
        int i = 0;
        while (insignificant >= 10) {
            insignificant /= 10;
            i++;
        }
        if (i != 0) {
            long pow10 = long5pow[i] << i;
            long residue = lvalue % pow10;
            lvalue /= pow10;
            decExponent2 += i;
            if (residue >= (pow10 >> 1)) {
                lvalue++;
            }
        }
        if (lvalue <= 2147483647L) {
            if (!f3assertionsDisabled) {
                if (!(lvalue > 0 ? true : f3assertionsDisabled)) {
                    throw new AssertionError((Object) Long.valueOf(lvalue));
                }
            }
            int ivalue = (int) lvalue;
            ndigits = 10;
            digits2 = (char[]) perThreadBuffer.get();
            int digitno4 = 9;
            int c = ivalue % 10;
            int ivalue2 = ivalue / 10;
            while (c == 0) {
                decExponent2++;
                c = ivalue2 % 10;
                ivalue2 /= 10;
            }
            while (true) {
                digitno3 = digitno4;
                if (ivalue2 == 0) {
                    break;
                }
                digitno4 = digitno3 - 1;
                digits2[digitno3] = (char) (c + 48);
                decExponent2++;
                c = ivalue2 % 10;
                ivalue2 /= 10;
            }
            digits2[digitno3] = (char) (c + 48);
            digitno2 = digitno3;
        } else {
            ndigits = 20;
            digits2 = (char[]) perThreadBuffer.get();
            int digitno5 = 19;
            int c2 = (int) (lvalue % 10);
            long lvalue2 = lvalue / 10;
            while (c2 == 0) {
                decExponent2++;
                c2 = (int) (lvalue2 % 10);
                lvalue2 /= 10;
            }
            while (true) {
                digitno = digitno5;
                if (lvalue2 == 0) {
                    break;
                }
                digitno5 = digitno - 1;
                digits2[digitno] = (char) (c2 + 48);
                decExponent2++;
                c2 = (int) (lvalue2 % 10);
                lvalue2 /= 10;
            }
            digits2[digitno] = (char) (c2 + 48);
            digitno2 = digitno;
        }
        int ndigits2 = ndigits - digitno2;
        char[] result = new char[ndigits2];
        System.arraycopy(digits2, digitno2, result, 0, ndigits2);
        this.digits = result;
        this.decExponent = decExponent2 + 1;
        this.nDigits = ndigits2;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r1v0, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r1v3, types: [char] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void roundup() {
        /*
            r6 = this;
            r5 = 0
            r4 = 57
            char[] r2 = r6.digits
            int r3 = r6.nDigits
            int r0 = r3 + -1
            char r1 = r2[r0]
            if (r1 != r4) goto L_0x002d
        L_0x000d:
            if (r1 != r4) goto L_0x001e
            if (r0 <= 0) goto L_0x001e
            char[] r2 = r6.digits
            r3 = 48
            r2[r0] = r3
            char[] r2 = r6.digits
            int r0 = r0 + -1
            char r1 = r2[r0]
            goto L_0x000d
        L_0x001e:
            if (r1 != r4) goto L_0x002d
            int r2 = r6.decExponent
            int r2 = r2 + 1
            r6.decExponent = r2
            char[] r2 = r6.digits
            r3 = 49
            r2[r5] = r3
            return
        L_0x002d:
            char[] r2 = r6.digits
            int r3 = r1 + 1
            char r3 = (char) r3
            r2[r0] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.FloatingDecimal.roundup():void");
    }

    private FloatingDecimal() {
        this.mustSetRoundDir = f3assertionsDisabled;
        this.fromHex = f3assertionsDisabled;
        this.roundDir = 0;
    }

    public static FloatingDecimal getThreadLocalInstance() {
        return TL_INSTANCE.get();
    }

    public FloatingDecimal loadDouble(double d) {
        int nSignificantBits;
        long dBits = Double.doubleToLongBits(d);
        this.mustSetRoundDir = f3assertionsDisabled;
        this.fromHex = f3assertionsDisabled;
        this.roundDir = 0;
        if ((Long.MIN_VALUE & dBits) != 0) {
            this.isNegative = true;
            dBits ^= Long.MIN_VALUE;
        } else {
            this.isNegative = f3assertionsDisabled;
        }
        int binExp = (int) ((9218868437227405312L & dBits) >> 52);
        long fractBits = dBits & 4503599627370495L;
        if (binExp == 2047) {
            this.isExceptional = true;
            if (fractBits == 0) {
                this.digits = infinity;
            } else {
                this.digits = notANumber;
                this.isNegative = f3assertionsDisabled;
            }
            this.nDigits = this.digits.length;
            return this;
        }
        this.isExceptional = f3assertionsDisabled;
        if (binExp != 0) {
            fractBits |= fractHOB;
            nSignificantBits = 53;
        } else if (fractBits == 0) {
            this.decExponent = 0;
            this.digits = zero;
            this.nDigits = 1;
            return this;
        } else {
            while ((fractHOB & fractBits) == 0) {
                fractBits <<= 1;
                binExp--;
            }
            nSignificantBits = binExp + expShift + 1;
            binExp++;
        }
        dtoa(binExp - 1023, fractBits, nSignificantBits);
        return this;
    }

    public FloatingDecimal loadFloat(float f) {
        int nSignificantBits;
        int fBits = Float.floatToIntBits(f);
        this.mustSetRoundDir = f3assertionsDisabled;
        this.fromHex = f3assertionsDisabled;
        this.roundDir = 0;
        if ((fBits & Integer.MIN_VALUE) != 0) {
            this.isNegative = true;
            fBits ^= Integer.MIN_VALUE;
        } else {
            this.isNegative = f3assertionsDisabled;
        }
        int binExp = (2139095040 & fBits) >> 23;
        int fractBits = fBits & 8388607;
        if (binExp == 255) {
            this.isExceptional = true;
            if (((long) fractBits) == 0) {
                this.digits = infinity;
            } else {
                this.digits = notANumber;
                this.isNegative = f3assertionsDisabled;
            }
            this.nDigits = this.digits.length;
            return this;
        }
        this.isExceptional = f3assertionsDisabled;
        if (binExp != 0) {
            fractBits |= singleFractHOB;
            nSignificantBits = 24;
        } else if (fractBits == 0) {
            this.decExponent = 0;
            this.digits = zero;
            this.nDigits = 1;
            return this;
        } else {
            while ((fractBits & singleFractHOB) == 0) {
                fractBits <<= 1;
                binExp--;
            }
            nSignificantBits = binExp + 23 + 1;
            binExp++;
        }
        dtoa(binExp - 127, ((long) fractBits) << 29, nSignificantBits);
        return this;
    }

    private void dtoa(int binExp, long fractBits, int nSignificantBits) {
        int i;
        int ndigit;
        boolean low;
        boolean high;
        long lowDigitDifference;
        int ndigit2;
        int ndigit3;
        boolean low2;
        boolean high2;
        int ndigit4;
        boolean z;
        long halfULP;
        long fractBits2;
        int nFractBits = countBits(fractBits);
        int nTinyBits = Math.max(0, (nFractBits - binExp) - 1);
        if (binExp > maxSmallBinExp || binExp < minSmallBinExp || nTinyBits >= long5pow.length || n5bits[nTinyBits] + nFractBits >= 64 || nTinyBits != 0) {
            int decExp = (int) Math.floor(((Double.longBitsToDouble((-4503599627370497L & fractBits) | expOne) - 1.5d) * 0.289529654d) + 0.176091259d + (((double) binExp) * 0.301029995663981d));
            int B5 = Math.max(0, -decExp);
            int B2 = B5 + nTinyBits + binExp;
            int S5 = Math.max(0, decExp);
            int S2 = S5 + nTinyBits;
            int i2 = B5;
            int M2 = B2 - nSignificantBits;
            long fractBits3 = fractBits >>> (53 - nFractBits);
            int B22 = B2 - (nFractBits - 1);
            int common2factor = Math.min(B22, S2);
            int B23 = B22 - common2factor;
            int S22 = S2 - common2factor;
            int M22 = M2 - common2factor;
            if (nFractBits == 1) {
                M22--;
            }
            if (M22 < 0) {
                B23 -= M22;
                S22 -= M22;
                M22 = 0;
            }
            char[] digits2 = new char[18];
            this.digits = digits2;
            int Bbits = nFractBits + B23 + (B5 < n5bits.length ? n5bits[B5] : B5 * 3);
            int i3 = S22 + 1;
            if (S5 + 1 < n5bits.length) {
                i = n5bits[S5 + 1];
            } else {
                i = (S5 + 1) * 3;
            }
            int tenSbits = i3 + i;
            if (Bbits >= 64 || tenSbits >= 64) {
                FDBigInt Bval = multPow52(new FDBigInt(fractBits3), B5, B23);
                FDBigInt Sval = constructPow52(S5, S22);
                FDBigInt Mval = constructPow52(B5, M22);
                int shiftBias = Sval.normalizeMe();
                Bval.lshiftMe(shiftBias);
                Mval.lshiftMe(shiftBias);
                FDBigInt tenSval = Sval.mult(10);
                int ndigit5 = 0;
                int q = Bval.quoRemIteration(Sval);
                FDBigInt Mval2 = Mval.mult(10);
                boolean low3 = Bval.cmp(Mval2) < 0 ? true : f3assertionsDisabled;
                boolean high3 = Bval.add(Mval2).cmp(tenSval) > 0 ? true : f3assertionsDisabled;
                if (!f3assertionsDisabled) {
                    if (!(q < 10 ? true : f3assertionsDisabled)) {
                        throw new AssertionError((Object) Integer.valueOf(q));
                    }
                }
                if (q != 0 || high3) {
                    ndigit5 = 1;
                    digits2[0] = (char) (q + 48);
                } else {
                    decExp--;
                }
                if (decExp < -3 || decExp >= 8) {
                    low3 = f3assertionsDisabled;
                    high3 = f3assertionsDisabled;
                    ndigit = ndigit5;
                } else {
                    ndigit = ndigit5;
                }
                while (!low && !high) {
                    int q2 = Bval.quoRemIteration(Sval);
                    Mval2 = Mval2.mult(10);
                    if (!f3assertionsDisabled) {
                        if (!(q2 < 10 ? true : f3assertionsDisabled)) {
                            throw new AssertionError((Object) Integer.valueOf(q2));
                        }
                    }
                    boolean low4 = Bval.cmp(Mval2) < 0 ? true : f3assertionsDisabled;
                    boolean high4 = Bval.add(Mval2).cmp(tenSval) > 0 ? true : f3assertionsDisabled;
                    digits2[ndigit] = (char) (q2 + 48);
                    ndigit++;
                }
                if (!high || !low) {
                    lowDigitDifference = 0;
                    ndigit2 = ndigit;
                } else {
                    Bval.lshiftMe(1);
                    lowDigitDifference = (long) Bval.cmp(tenSval);
                    ndigit2 = ndigit;
                }
            } else if (Bbits >= 32 || tenSbits >= 32) {
                long b = (long5pow[B5] * fractBits3) << B23;
                long s = long5pow[S5] << S22;
                long tens = s * 10;
                int ndigit6 = 0;
                int q3 = (int) (b / s);
                long b2 = 10 * (b % s);
                long m = (long5pow[B5] << M22) * 10;
                boolean low5 = b2 < m ? true : f3assertionsDisabled;
                boolean high5 = b2 + m > tens ? true : f3assertionsDisabled;
                if (!f3assertionsDisabled) {
                    if (!(q3 < 10 ? true : f3assertionsDisabled)) {
                        throw new AssertionError((Object) Integer.valueOf(q3));
                    }
                }
                if (q3 != 0 || high5) {
                    ndigit6 = 1;
                    digits2[0] = (char) (q3 + 48);
                } else {
                    decExp--;
                }
                if (decExp < -3 || decExp >= 8) {
                    low5 = f3assertionsDisabled;
                    high5 = f3assertionsDisabled;
                    ndigit3 = ndigit6;
                } else {
                    ndigit3 = ndigit6;
                }
                while (!low && !high) {
                    int q4 = (int) (b2 / s);
                    b2 = 10 * (b2 % s);
                    m *= 10;
                    if (!f3assertionsDisabled) {
                        if (!(q4 < 10 ? true : f3assertionsDisabled)) {
                            throw new AssertionError((Object) Integer.valueOf(q4));
                        }
                    }
                    if (m > 0) {
                        low2 = b2 < m ? true : f3assertionsDisabled;
                        high2 = b2 + m > tens ? true : f3assertionsDisabled;
                    } else {
                        low2 = true;
                        high2 = true;
                    }
                    digits2[ndigit3] = (char) (q4 + 48);
                    ndigit3++;
                }
                lowDigitDifference = (b2 << 1) - tens;
                ndigit2 = ndigit3;
            } else {
                int b3 = (((int) fractBits3) * small5pow[B5]) << B23;
                int s2 = small5pow[S5] << S22;
                int tens2 = s2 * 10;
                int ndigit7 = 0;
                int q5 = b3 / s2;
                int b4 = (b3 % s2) * 10;
                int m2 = (small5pow[B5] << M22) * 10;
                boolean low6 = b4 < m2 ? true : f3assertionsDisabled;
                boolean high6 = b4 + m2 > tens2 ? true : f3assertionsDisabled;
                if (!f3assertionsDisabled) {
                    if (q5 < 10) {
                        z = true;
                    } else {
                        z = f3assertionsDisabled;
                    }
                    if (!z) {
                        throw new AssertionError((Object) Integer.valueOf(q5));
                    }
                }
                if (q5 != 0 || high6) {
                    ndigit7 = 1;
                    digits2[0] = (char) (q5 + 48);
                } else {
                    decExp--;
                }
                if (decExp < -3 || decExp >= 8) {
                    low6 = f3assertionsDisabled;
                    high6 = f3assertionsDisabled;
                    ndigit4 = ndigit7;
                } else {
                    ndigit4 = ndigit7;
                }
                while (!low && !high) {
                    int q6 = b4 / s2;
                    b4 = (b4 % s2) * 10;
                    m2 *= 10;
                    if (!f3assertionsDisabled) {
                        if (!(q6 < 10 ? true : f3assertionsDisabled)) {
                            throw new AssertionError((Object) Integer.valueOf(q6));
                        }
                    }
                    if (((long) m2) > 0) {
                        low = b4 < m2 ? true : f3assertionsDisabled;
                        high = b4 + m2 > tens2 ? true : f3assertionsDisabled;
                    } else {
                        low = true;
                        high = true;
                    }
                    digits2[ndigit4] = (char) (q6 + 48);
                    ndigit4++;
                }
                lowDigitDifference = (long) ((b4 << 1) - tens2);
                ndigit2 = ndigit4;
            }
            this.decExponent = decExp + 1;
            this.digits = digits2;
            this.nDigits = ndigit2;
            if (!high) {
                return;
            }
            if (!low) {
                roundup();
            } else if (lowDigitDifference == 0) {
                if ((digits2[this.nDigits - 1] & 1) != 0) {
                    roundup();
                }
            } else if (lowDigitDifference > 0) {
                roundup();
            }
        } else {
            if (binExp > nSignificantBits) {
                halfULP = 1 << ((binExp - nSignificantBits) - 1);
            } else {
                halfULP = 0;
            }
            if (binExp >= expShift) {
                fractBits2 = fractBits << (binExp - 52);
            } else {
                fractBits2 = fractBits >>> (52 - binExp);
            }
            developLongDigits(0, fractBits2, halfULP);
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer(this.nDigits + 8);
        if (this.isNegative) {
            result.append('-');
        }
        if (this.isExceptional) {
            result.append(this.digits, 0, this.nDigits);
        } else {
            result.append("0.");
            result.append(this.digits, 0, this.nDigits);
            result.append('e');
            result.append(this.decExponent);
        }
        return new String(result);
    }

    public String toJavaFormatString() {
        char[] result = (char[]) perThreadBuffer.get();
        return new String(result, 0, getChars(result));
    }

    private int getChars(char[] result) {
        int i;
        int e;
        if (!f3assertionsDisabled) {
            if (!(this.nDigits <= 19)) {
                throw new AssertionError((Object) Integer.valueOf(this.nDigits));
            }
        }
        int i2 = 0;
        if (this.isNegative) {
            result[0] = '-';
            i2 = 1;
        }
        if (this.isExceptional) {
            System.arraycopy(this.digits, 0, result, i2, this.nDigits);
            return i2 + this.nDigits;
        } else if (this.decExponent > 0 && this.decExponent < 8) {
            int charLength = Math.min(this.nDigits, this.decExponent);
            System.arraycopy(this.digits, 0, result, i2, charLength);
            int i3 = i2 + charLength;
            if (charLength < this.decExponent) {
                int charLength2 = this.decExponent - charLength;
                System.arraycopy(zero, 0, result, i3, charLength2);
                int i4 = i3 + charLength2;
                int i5 = i4 + 1;
                result[i4] = '.';
                int i6 = i5 + 1;
                result[i5] = '0';
                return i6;
            }
            int i7 = i3 + 1;
            result[i3] = '.';
            if (charLength < this.nDigits) {
                int t = this.nDigits - charLength;
                System.arraycopy(this.digits, charLength, result, i7, t);
                return i7 + t;
            }
            int i8 = i7 + 1;
            result[i7] = '0';
            return i8;
        } else if (this.decExponent > 0 || this.decExponent <= -3) {
            int i9 = i2 + 1;
            result[i2] = this.digits[0];
            int i10 = i9 + 1;
            result[i9] = '.';
            if (this.nDigits > 1) {
                System.arraycopy(this.digits, 1, result, i10, this.nDigits - 1);
                i = i10 + (this.nDigits - 1);
            } else {
                result[i10] = '0';
                i = i10 + 1;
            }
            int i11 = i + 1;
            result[i] = 'E';
            if (this.decExponent <= 0) {
                result[i11] = '-';
                e = (-this.decExponent) + 1;
                i11++;
            } else {
                e = this.decExponent - 1;
            }
            if (e <= 9) {
                int i12 = i11 + 1;
                result[i11] = (char) (e + 48);
                return i12;
            } else if (e <= 99) {
                int i13 = i11 + 1;
                result[i11] = (char) ((e / 10) + 48);
                result[i13] = (char) ((e % 10) + 48);
                return i13 + 1;
            } else {
                int i14 = i11 + 1;
                result[i11] = (char) ((e / 100) + 48);
                int e2 = e % 100;
                int i15 = i14 + 1;
                result[i14] = (char) ((e2 / 10) + 48);
                int i16 = i15 + 1;
                result[i15] = (char) ((e2 % 10) + 48);
                return i16;
            }
        } else {
            int i17 = i2 + 1;
            result[i2] = '0';
            int i18 = i17 + 1;
            result[i17] = '.';
            if (this.decExponent != 0) {
                System.arraycopy(zero, 0, result, i18, -this.decExponent);
                i18 -= this.decExponent;
            }
            System.arraycopy(this.digits, 0, result, i18, this.nDigits);
            return i18 + this.nDigits;
        }
    }

    public void appendTo(AbstractStringBuilder buf) {
        int e;
        if (this.isNegative) {
            buf.append('-');
        }
        if (this.isExceptional) {
            buf.append(this.digits, 0, this.nDigits);
        } else if (this.decExponent > 0 && this.decExponent < 8) {
            int charLength = Math.min(this.nDigits, this.decExponent);
            buf.append(this.digits, 0, charLength);
            if (charLength < this.decExponent) {
                buf.append(zero, 0, this.decExponent - charLength);
                buf.append(".0");
                return;
            }
            buf.append('.');
            if (charLength < this.nDigits) {
                buf.append(this.digits, charLength, this.nDigits - charLength);
            } else {
                buf.append('0');
            }
        } else if (this.decExponent > 0 || this.decExponent <= -3) {
            buf.append(this.digits[0]);
            buf.append('.');
            if (this.nDigits > 1) {
                buf.append(this.digits, 1, this.nDigits - 1);
            } else {
                buf.append('0');
            }
            buf.append('E');
            if (this.decExponent <= 0) {
                buf.append('-');
                e = (-this.decExponent) + 1;
            } else {
                e = this.decExponent - 1;
            }
            if (e <= 9) {
                buf.append((char) (e + 48));
            } else if (e <= 99) {
                buf.append((char) ((e / 10) + 48));
                buf.append((char) ((e % 10) + 48));
            } else {
                buf.append((char) ((e / 100) + 48));
                int e2 = e % 100;
                buf.append((char) ((e2 / 10) + 48));
                buf.append((char) ((e2 % 10) + 48));
            }
        } else {
            buf.append("0.");
            if (this.decExponent != 0) {
                buf.append(zero, 0, -this.decExponent);
            }
            buf.append(this.digits, 0, this.nDigits);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ea, code lost:
        r16 = r16 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0118, code lost:
        if (r23 != 0) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0179, code lost:
        if (r16 == r11) goto L_0x0018;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0231 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0114 A[Catch:{ StringIndexOutOfBoundsException -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x011c A[Catch:{ StringIndexOutOfBoundsException -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0152 A[Catch:{ StringIndexOutOfBoundsException -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.FloatingDecimal readJavaFormatString(java.lang.String r32) throws java.lang.NumberFormatException {
        /*
            r31 = this;
            r18 = 0
            r26 = 0
            java.lang.String r32 = r32.trim()     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            int r20 = r32.length()     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            if (r20 != 0) goto L_0x003d
            java.lang.NumberFormatException r28 = new java.lang.NumberFormatException     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            java.lang.String r29 = "empty String"
            r28.<init>(r29)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            throw r28     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
        L_0x0017:
            r10 = move-exception
        L_0x0018:
            java.lang.NumberFormatException r28 = new java.lang.NumberFormatException
            java.lang.StringBuilder r29 = new java.lang.StringBuilder
            r29.<init>()
            java.lang.String r30 = "For input string: \""
            java.lang.StringBuilder r29 = r29.append((java.lang.String) r30)
            r0 = r29
            r1 = r32
            java.lang.StringBuilder r29 = r0.append((java.lang.String) r1)
            java.lang.String r30 = "\""
            java.lang.StringBuilder r29 = r29.append((java.lang.String) r30)
            java.lang.String r29 = r29.toString()
            r28.<init>(r29)
            throw r28
        L_0x003d:
            r16 = 0
            r0 = r32
            r1 = r16
            char r4 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            switch(r4) {
                case 43: goto L_0x0096;
                case 44: goto L_0x004a;
                case 45: goto L_0x0094;
                default: goto L_0x004a;
            }     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
        L_0x004a:
            r0 = r32
            r1 = r16
            char r4 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r28 = 78
            r0 = r28
            if (r4 == r0) goto L_0x005e
            r28 = 73
            r0 = r28
            if (r4 != r0) goto L_0x00cc
        L_0x005e:
            r25 = 0
            r27 = 0
            r28 = 78
            r0 = r28
            if (r4 != r0) goto L_0x009b
            char[] r27 = notANumber     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r25 = 1
        L_0x006c:
            r19 = 0
        L_0x006e:
            r0 = r16
            r1 = r20
            if (r0 >= r1) goto L_0x009e
            r0 = r27
            int r0 = r0.length     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r28 = r0
            r0 = r19
            r1 = r28
            if (r0 >= r1) goto L_0x009e
            r0 = r32
            r1 = r16
            char r28 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            char r29 = r27[r19]     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r0 = r28
            r1 = r29
            if (r0 != r1) goto L_0x0018
            int r16 = r16 + 1
            int r19 = r19 + 1
            goto L_0x006e
        L_0x0094:
            r18 = 1
        L_0x0096:
            r16 = 1
            r26 = 1
            goto L_0x004a
        L_0x009b:
            char[] r27 = infinity     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            goto L_0x006c
        L_0x009e:
            r0 = r27
            int r0 = r0.length     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r28 = r0
            r0 = r19
            r1 = r28
            if (r0 != r1) goto L_0x0018
            r0 = r16
            r1 = r20
            if (r0 != r1) goto L_0x0018
            if (r25 == 0) goto L_0x00bc
            r28 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r0 = r31
            r1 = r28
            java.lang.FloatingDecimal r28 = r0.loadDouble(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
        L_0x00bb:
            return r28
        L_0x00bc:
            if (r18 == 0) goto L_0x00c9
            r28 = -4503599627370496(0xfff0000000000000, double:-Infinity)
        L_0x00c0:
            r0 = r31
            r1 = r28
            java.lang.FloatingDecimal r28 = r0.loadDouble(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            goto L_0x00bb
        L_0x00c9:
            r28 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x00c0
        L_0x00cc:
            r28 = 48
            r0 = r28
            if (r4 != r0) goto L_0x00f5
            int r28 = r16 + 1
            r0 = r20
            r1 = r28
            if (r0 <= r1) goto L_0x00f5
            int r28 = r16 + 1
            r0 = r32
            r1 = r28
            char r5 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r28 = 120(0x78, float:1.68E-43)
            r0 = r28
            if (r5 == r0) goto L_0x00f0
            r28 = 88
            r0 = r28
            if (r5 != r0) goto L_0x00f5
        L_0x00f0:
            java.lang.FloatingDecimal r28 = r31.parseHexString(r32)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            return r28
        L_0x00f5:
            r0 = r20
            char[] r9 = new char[r0]     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r21 = 0
            r8 = 0
            r7 = 0
            r23 = 0
            r24 = 0
        L_0x0101:
            r0 = r16
            r1 = r20
            if (r0 >= r1) goto L_0x0112
            r0 = r32
            r1 = r16
            char r4 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            switch(r4) {
                case 46: goto L_0x0205;
                case 47: goto L_0x0112;
                case 48: goto L_0x01e6;
                case 49: goto L_0x01f1;
                case 50: goto L_0x01f1;
                case 51: goto L_0x01f1;
                case 52: goto L_0x01f1;
                case 53: goto L_0x01f1;
                case 54: goto L_0x01f1;
                case 55: goto L_0x01f1;
                case 56: goto L_0x01f1;
                case 57: goto L_0x01f1;
                default: goto L_0x0112;
            }     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
        L_0x0112:
            if (r21 != 0) goto L_0x011a
            char[] r9 = zero     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r21 = 1
            if (r23 == 0) goto L_0x0018
        L_0x011a:
            if (r8 == 0) goto L_0x0218
            int r6 = r7 - r23
        L_0x011e:
            r0 = r16
            r1 = r20
            if (r0 >= r1) goto L_0x017b
            r0 = r32
            r1 = r16
            char r4 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r28 = 101(0x65, float:1.42E-43)
            r0 = r28
            if (r4 == r0) goto L_0x0138
            r28 = 69
            r0 = r28
            if (r4 != r0) goto L_0x017b
        L_0x0138:
            r14 = 1
            r15 = 0
            r13 = 0
            int r16 = r16 + 1
            r0 = r32
            r1 = r16
            char r28 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            switch(r28) {
                case 43: goto L_0x021d;
                case 44: goto L_0x0148;
                case 45: goto L_0x021c;
                default: goto L_0x0148;
            }     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
        L_0x0148:
            r11 = r16
            r17 = r16
        L_0x014c:
            r0 = r17
            r1 = r20
            if (r0 >= r1) goto L_0x0231
            r28 = 214748364(0xccccccc, float:3.1554434E-31)
            r0 = r28
            if (r15 < r0) goto L_0x015a
            r13 = 1
        L_0x015a:
            int r16 = r17 + 1
            r0 = r32
            r1 = r17
            char r4 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            switch(r4) {
                case 48: goto L_0x0221;
                case 49: goto L_0x0221;
                case 50: goto L_0x0221;
                case 51: goto L_0x0221;
                case 52: goto L_0x0221;
                case 53: goto L_0x0221;
                case 54: goto L_0x0221;
                case 55: goto L_0x0221;
                case 56: goto L_0x0221;
                case 57: goto L_0x0221;
                default: goto L_0x0167;
            }     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
        L_0x0167:
            int r16 = r16 + -1
        L_0x0169:
            r0 = r21
            int r0 = r0 + 324
            r28 = r0
            int r12 = r28 + r24
            if (r13 != 0) goto L_0x0175
            if (r15 <= r12) goto L_0x022b
        L_0x0175:
            int r6 = r14 * r12
        L_0x0177:
            r0 = r16
            if (r0 == r11) goto L_0x0018
        L_0x017b:
            r0 = r16
            r1 = r20
            if (r0 >= r1) goto L_0x01c9
            int r28 = r20 + -1
            r0 = r16
            r1 = r28
            if (r0 != r1) goto L_0x0018
            r0 = r32
            r1 = r16
            char r28 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r29 = 102(0x66, float:1.43E-43)
            r0 = r28
            r1 = r29
            if (r0 == r1) goto L_0x01c9
            r0 = r32
            r1 = r16
            char r28 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r29 = 70
            r0 = r28
            r1 = r29
            if (r0 == r1) goto L_0x01c9
            r0 = r32
            r1 = r16
            char r28 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r29 = 100
            r0 = r28
            r1 = r29
            if (r0 == r1) goto L_0x01c9
            r0 = r32
            r1 = r16
            char r28 = r0.charAt(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r29 = 68
            r0 = r28
            r1 = r29
            if (r0 != r1) goto L_0x0018
        L_0x01c9:
            r0 = r18
            r1 = r31
            r1.isNegative = r0     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r0 = r31
            r0.decExponent = r6     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r0 = r31
            r0.digits = r9     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r0 = r21
            r1 = r31
            r1.nDigits = r0     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            r28 = 0
            r0 = r28
            r1 = r31
            r1.isExceptional = r0     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            return r31
        L_0x01e6:
            if (r21 <= 0) goto L_0x01ee
            int r24 = r24 + 1
        L_0x01ea:
            int r16 = r16 + 1
            goto L_0x0101
        L_0x01ee:
            int r23 = r23 + 1
            goto L_0x01ea
        L_0x01f1:
            r22 = r21
        L_0x01f3:
            if (r24 <= 0) goto L_0x0200
            int r21 = r22 + 1
            r28 = 48
            r9[r22] = r28     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            int r24 = r24 + -1
            r22 = r21
            goto L_0x01f3
        L_0x0200:
            int r21 = r22 + 1
            r9[r22] = r4     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            goto L_0x01ea
        L_0x0205:
            if (r8 == 0) goto L_0x0210
            java.lang.NumberFormatException r28 = new java.lang.NumberFormatException     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            java.lang.String r29 = "multiple points"
            r28.<init>(r29)     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
            throw r28     // Catch:{ StringIndexOutOfBoundsException -> 0x0017 }
        L_0x0210:
            r7 = r16
            if (r26 == 0) goto L_0x0216
            int r7 = r7 + -1
        L_0x0216:
            r8 = 1
            goto L_0x01ea
        L_0x0218:
            int r6 = r21 + r24
            goto L_0x011e
        L_0x021c:
            r14 = -1
        L_0x021d:
            int r16 = r16 + 1
            goto L_0x0148
        L_0x0221:
            int r28 = r15 * 10
            int r29 = r4 + -48
            int r15 = r28 + r29
            r17 = r16
            goto L_0x014c
        L_0x022b:
            int r28 = r14 * r15
            int r6 = r6 + r28
            goto L_0x0177
        L_0x0231:
            r16 = r17
            goto L_0x0169
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.FloatingDecimal.readJavaFormatString(java.lang.String):java.lang.FloatingDecimal");
    }

    public double doubleValue() {
        int B5;
        int B2;
        int D5;
        int D2;
        int hulpbias;
        boolean overvalue;
        FDBigInt diff;
        int i;
        int i2;
        int i3;
        int i4;
        int kDigits = Math.min(this.nDigits, 16);
        if (this.digits != infinity && this.digits != notANumber) {
            if (this.mustSetRoundDir) {
                this.roundDir = 0;
            }
            int iValue = this.digits[0] - '0';
            int iDigits = Math.min(kDigits, 9);
            for (int i5 = 1; i5 < iDigits; i5++) {
                iValue = ((iValue * 10) + this.digits[i5]) - 48;
            }
            long lValue = (long) iValue;
            for (int i6 = iDigits; i6 < kDigits; i6++) {
                lValue = (10 * lValue) + ((long) (this.digits[i6] - '0'));
            }
            double dValue = (double) lValue;
            int exp = this.decExponent - kDigits;
            if (this.nDigits <= 15) {
                if (exp == 0 || dValue == 0.0d) {
                    return this.isNegative ? -dValue : dValue;
                }
                if (exp >= 0) {
                    if (exp <= maxSmallTen) {
                        double rValue = dValue * small10pow[exp];
                        if (this.mustSetRoundDir) {
                            double tValue = rValue / small10pow[exp];
                            if (tValue == dValue) {
                                i4 = 0;
                            } else if (tValue < dValue) {
                                i4 = 1;
                            } else {
                                i4 = -1;
                            }
                            this.roundDir = i4;
                        }
                        return this.isNegative ? -rValue : rValue;
                    }
                    int slop = 15 - kDigits;
                    if (exp <= maxSmallTen + slop) {
                        double dValue2 = dValue * small10pow[slop];
                        double rValue2 = dValue2 * small10pow[exp - slop];
                        if (this.mustSetRoundDir) {
                            double tValue2 = rValue2 / small10pow[exp - slop];
                            if (tValue2 == dValue2) {
                                i3 = 0;
                            } else if (tValue2 < dValue2) {
                                i3 = 1;
                            } else {
                                i3 = -1;
                            }
                            this.roundDir = i3;
                        }
                        return this.isNegative ? -rValue2 : rValue2;
                    }
                } else if (exp >= (-maxSmallTen)) {
                    double rValue3 = dValue / small10pow[-exp];
                    double tValue3 = rValue3 * small10pow[-exp];
                    if (this.mustSetRoundDir) {
                        if (tValue3 == dValue) {
                            i2 = 0;
                        } else if (tValue3 < dValue) {
                            i2 = 1;
                        } else {
                            i2 = -1;
                        }
                        this.roundDir = i2;
                    }
                    return this.isNegative ? -rValue3 : rValue3;
                }
            }
            if (exp > 0) {
                if (this.decExponent > 309) {
                    return this.isNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                }
                if ((exp & 15) != 0) {
                    dValue *= small10pow[exp & 15];
                }
                int exp2 = exp >> 4;
                if (exp2 != 0) {
                    int j = 0;
                    while (exp2 > 1) {
                        if ((exp2 & 1) != 0) {
                            dValue *= big10pow[j];
                        }
                        j++;
                        exp2 >>= 1;
                    }
                    double t = dValue * big10pow[j];
                    if (Double.isInfinite(t)) {
                        if (Double.isInfinite((dValue / 2.0d) * big10pow[j])) {
                            return this.isNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                        }
                        t = Double.MAX_VALUE;
                    }
                    dValue = t;
                }
            } else if (exp < 0) {
                int exp3 = -exp;
                if (this.decExponent < -325) {
                    return this.isNegative ? -0.0d : 0.0d;
                }
                if ((exp3 & 15) != 0) {
                    dValue /= small10pow[exp3 & 15];
                }
                int exp4 = exp3 >> 4;
                if (exp4 != 0) {
                    int j2 = 0;
                    while (exp4 > 1) {
                        if ((exp4 & 1) != 0) {
                            dValue *= tiny10pow[j2];
                        }
                        j2++;
                        exp4 >>= 1;
                    }
                    double t2 = dValue * tiny10pow[j2];
                    if (t2 == 0.0d) {
                        if (dValue * 2.0d * tiny10pow[j2] == 0.0d) {
                            return this.isNegative ? -0.0d : 0.0d;
                        }
                        t2 = Double.MIN_VALUE;
                    }
                    dValue = t2;
                }
            }
            FDBigInt bigD0 = new FDBigInt(lValue, this.digits, kDigits, this.nDigits);
            int exp5 = this.decExponent - this.nDigits;
            while (true) {
                FDBigInt bigB = doubleToBigInt(dValue);
                if (exp5 >= 0) {
                    B5 = 0;
                    B2 = 0;
                    D5 = exp5;
                    D2 = exp5;
                } else {
                    B5 = -exp5;
                    B2 = B5;
                    D5 = 0;
                    D2 = 0;
                }
                if (this.bigIntExp >= 0) {
                    B2 += this.bigIntExp;
                } else {
                    D2 -= this.bigIntExp;
                }
                int Ulp2 = B2;
                if (this.bigIntExp + this.bigIntNBits <= -1022) {
                    hulpbias = this.bigIntExp + 1023 + expShift;
                } else {
                    hulpbias = 54 - this.bigIntNBits;
                }
                int B22 = B2 + hulpbias;
                int D22 = D2 + hulpbias;
                int common2 = Math.min(B22, Math.min(D22, Ulp2));
                int Ulp22 = Ulp2 - common2;
                FDBigInt bigB2 = multPow52(bigB, B5, B22 - common2);
                FDBigInt bigD = multPow52(new FDBigInt(bigD0), D5, D22 - common2);
                int cmpResult = bigB2.cmp(bigD);
                if (cmpResult <= 0) {
                    if (cmpResult >= 0) {
                        break;
                    }
                    overvalue = f3assertionsDisabled;
                    diff = bigD.sub(bigB2);
                } else {
                    overvalue = true;
                    diff = bigB2.sub(bigD);
                    if (this.bigIntNBits == 1 && this.bigIntExp > -1022 && Ulp22 - 1 < 0) {
                        Ulp22 = 0;
                        diff.lshiftMe(1);
                    }
                }
                int cmpResult2 = diff.cmp(constructPow52(B5, Ulp22));
                if (cmpResult2 >= 0) {
                    if (cmpResult2 != 0) {
                        dValue += ulp(dValue, overvalue);
                        if (dValue != 0.0d) {
                            if (dValue == Double.POSITIVE_INFINITY) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        dValue += ulp(dValue, overvalue) * 0.5d;
                        if (this.mustSetRoundDir) {
                            this.roundDir = overvalue ? -1 : 1;
                        }
                    }
                } else if (this.mustSetRoundDir) {
                    if (overvalue) {
                        i = -1;
                    } else {
                        i = 1;
                    }
                    this.roundDir = i;
                }
            }
            return this.isNegative ? -dValue : dValue;
        } else if (this.digits == notANumber) {
            return Double.NaN;
        } else {
            return this.isNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
    }

    public float floatValue() {
        int kDigits = Math.min(this.nDigits, 8);
        if (this.digits != infinity && this.digits != notANumber) {
            int iValue = this.digits[0] - '0';
            for (int i = 1; i < kDigits; i++) {
                iValue = ((iValue * 10) + this.digits[i]) - 48;
            }
            float fValue = (float) iValue;
            int exp = this.decExponent - kDigits;
            if (this.nDigits <= 7) {
                if (exp == 0 || fValue == 0.0f) {
                    return this.isNegative ? -fValue : fValue;
                }
                if (exp >= 0) {
                    if (exp <= singleMaxSmallTen) {
                        float fValue2 = fValue * singleSmall10pow[exp];
                        return this.isNegative ? -fValue2 : fValue2;
                    }
                    int slop = 7 - kDigits;
                    if (exp <= singleMaxSmallTen + slop) {
                        float fValue3 = fValue * singleSmall10pow[slop] * singleSmall10pow[exp - slop];
                        return this.isNegative ? -fValue3 : fValue3;
                    }
                } else if (exp >= (-singleMaxSmallTen)) {
                    float fValue4 = fValue / singleSmall10pow[-exp];
                    return this.isNegative ? -fValue4 : fValue4;
                }
            } else if (this.decExponent >= this.nDigits && this.nDigits + this.decExponent <= 15) {
                long lValue = (long) iValue;
                for (int i2 = kDigits; i2 < this.nDigits; i2++) {
                    lValue = (10 * lValue) + ((long) (this.digits[i2] - '0'));
                }
                float fValue5 = (float) (((double) lValue) * small10pow[this.decExponent - this.nDigits]);
                return this.isNegative ? -fValue5 : fValue5;
            }
            if (this.decExponent > 39) {
                return this.isNegative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            }
            if (this.decExponent < -46) {
                return this.isNegative ? -0.0f : 0.0f;
            }
            this.mustSetRoundDir = this.fromHex ? f3assertionsDisabled : true;
            return stickyRound(doubleValue());
        } else if (this.digits == notANumber) {
            return Float.NaN;
        } else {
            return this.isNegative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
    }

    private static synchronized Pattern getHexFloatPattern() {
        Pattern pattern;
        synchronized (FloatingDecimal.class) {
            if (hexFloatPattern == null) {
                hexFloatPattern = Pattern.compile("([-+])?0[xX](((\\p{XDigit}+)\\.?)|((\\p{XDigit}*)\\.(\\p{XDigit}+)))[pP]([-+])?(\\p{Digit}+)[fFdD]?");
            }
            pattern = hexFloatPattern;
        }
        return pattern;
    }

    /* access modifiers changed from: package-private */
    public FloatingDecimal parseHexString(String s) {
        double sign;
        int leftDigits;
        String significandString;
        int exponentAdjust;
        long significand;
        int nextShift;
        long significand2;
        boolean z;
        Matcher m = getHexFloatPattern().matcher(s);
        if (!m.matches()) {
            throw new NumberFormatException("For input string: \"" + s + "\"");
        }
        String group1 = m.group(1);
        if (group1 == null || group1.equals("+")) {
            sign = 1.0d;
        } else {
            sign = -1.0d;
        }
        int rightDigits = 0;
        String group4 = m.group(4);
        if (group4 != null) {
            significandString = stripLeadingZeros(group4);
            leftDigits = significandString.length();
        } else {
            String group6 = stripLeadingZeros(m.group(6));
            leftDigits = group6.length();
            String group7 = m.group(7);
            rightDigits = group7.length();
            StringBuilder sb = new StringBuilder();
            if (group6 == null) {
                group6 = "";
            }
            significandString = sb.append(group6).append(group7).toString();
        }
        String significandString2 = stripLeadingZeros(significandString);
        int signifLength = significandString2.length();
        if (leftDigits >= 1) {
            exponentAdjust = (leftDigits - 1) * 4;
        } else {
            exponentAdjust = ((rightDigits - signifLength) + 1) * -4;
        }
        if (signifLength == 0) {
            return loadDouble(0.0d * sign);
        }
        String group8 = m.group(8);
        boolean equals = group8 != null ? group8.equals("+") : true;
        try {
            long exponent = ((equals ? 1 : -1) * ((long) Integer.parseInt(m.group(9)))) + ((long) exponentAdjust);
            boolean round = f3assertionsDisabled;
            boolean sticky = f3assertionsDisabled;
            long leadingDigit = (long) getHexDigit(significandString2, 0);
            if (leadingDigit == 1) {
                significand = 0 | (leadingDigit << 52);
                nextShift = 48;
            } else if (leadingDigit <= 3) {
                significand = 0 | (leadingDigit << 51);
                nextShift = 47;
                exponent++;
            } else if (leadingDigit <= 7) {
                significand = 0 | (leadingDigit << 50);
                nextShift = 46;
                exponent += 2;
            } else if (leadingDigit <= 15) {
                significand = 0 | (leadingDigit << 49);
                nextShift = 45;
                exponent += 3;
            } else {
                throw new AssertionError((Object) "Result from digit conversion too large!");
            }
            int i = 1;
            while (i < signifLength && nextShift >= 0) {
                significand |= ((long) getHexDigit(significandString2, i)) << nextShift;
                nextShift -= 4;
                i++;
            }
            if (i < signifLength) {
                long currentDigit = (long) getHexDigit(significandString2, i);
                switch (nextShift) {
                    case Types.LONGVARBINARY /*-4*/:
                        round = (8 & currentDigit) != 0 ? true : f3assertionsDisabled;
                        if ((7 & currentDigit) == 0) {
                            sticky = f3assertionsDisabled;
                            break;
                        } else {
                            sticky = true;
                            break;
                        }
                    case -3:
                        significand |= (8 & currentDigit) >> 3;
                        round = (4 & currentDigit) != 0 ? true : f3assertionsDisabled;
                        if ((3 & currentDigit) == 0) {
                            sticky = f3assertionsDisabled;
                            break;
                        } else {
                            sticky = true;
                            break;
                        }
                    case -2:
                        significand |= (12 & currentDigit) >> 2;
                        round = (2 & currentDigit) != 0 ? true : f3assertionsDisabled;
                        if ((1 & currentDigit) == 0) {
                            sticky = f3assertionsDisabled;
                            break;
                        } else {
                            sticky = true;
                            break;
                        }
                    case -1:
                        significand |= (14 & currentDigit) >> 1;
                        if ((1 & currentDigit) == 0) {
                            round = f3assertionsDisabled;
                            break;
                        } else {
                            round = true;
                            break;
                        }
                    default:
                        throw new AssertionError((Object) "Unexpected shift distance remainder.");
                }
                while (true) {
                    i++;
                    if (i < signifLength && !sticky) {
                        sticky = (sticky || ((long) getHexDigit(significandString2, i)) != 0) ? true : f3assertionsDisabled;
                    }
                }
            }
            if (exponent > 1023) {
                return loadDouble(Double.POSITIVE_INFINITY * sign);
            }
            if (exponent <= 1023 && exponent >= -1022) {
                significand2 = (((1023 + exponent) << 52) & 9218868437227405312L) | (4503599627370495L & significand);
            } else if (exponent < -1075) {
                return loadDouble(0.0d * sign);
            } else {
                boolean sticky2 = !sticky ? round : true;
                int bitsDiscarded = 53 - ((((int) exponent) + 1074) + 1);
                if (!f3assertionsDisabled) {
                    if (bitsDiscarded < 1 || bitsDiscarded > 53) {
                        z = f3assertionsDisabled;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                round = ((1 << (bitsDiscarded + -1)) & significand) != 0 ? true : f3assertionsDisabled;
                if (bitsDiscarded > 1) {
                    sticky2 = (sticky2 || (significand & (~(-1 << (bitsDiscarded + -1)))) != 0) ? true : f3assertionsDisabled;
                }
                significand2 = 0 | (4503599627370495L & (significand >> bitsDiscarded));
            }
            boolean leastZero = (1 & significand2) == 0 ? true : f3assertionsDisabled;
            if ((leastZero && round && sticky) || (!leastZero && round)) {
                significand2++;
            }
            loadDouble(FpUtils.rawCopySign(Double.longBitsToDouble(significand2), sign));
            if (exponent >= -150 && exponent <= 127 && (268435455 & significand2) == 0 && (round || sticky)) {
                if (leastZero) {
                    if (round ^ sticky) {
                        this.roundDir = 1;
                    }
                } else if (round) {
                    this.roundDir = -1;
                }
            }
            this.fromHex = true;
            return this;
        } catch (NumberFormatException e) {
            return loadDouble((equals ? Double.POSITIVE_INFINITY : 0.0d) * sign);
        }
    }

    static String stripLeadingZeros(String s) {
        return s.replaceFirst("^0+", "");
    }

    static int getHexDigit(String s, int position) {
        int value = Character.digit(s.charAt(position), 16);
        if (value > -1 && value < 16) {
            return value;
        }
        throw new AssertionError((Object) "Unexpected failure of digit conversion of " + s.charAt(position));
    }
}
