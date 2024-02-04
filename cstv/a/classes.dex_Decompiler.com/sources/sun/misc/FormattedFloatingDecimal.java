package sun.misc;

public class FormattedFloatingDecimal {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f109assertionsDisabled = false;

    /* renamed from: -sun-misc-FormattedFloatingDecimal$FormSwitchesValues  reason: not valid java name */
    private static final /* synthetic */ int[] f110sunmiscFormattedFloatingDecimal$FormSwitchesValues = null;
    private static FDBigInt[] b5p = null;
    private static final double[] big10pow = null;
    static final int bigDecimalExponent = 324;
    static final int expBias = 1023;
    static final long expMask = 9218868437227405312L;
    static final long expOne = 4607182418800017408L;
    static final int expShift = 52;
    static final long fractHOB = 4503599627370496L;
    static final long fractMask = 4503599627370495L;
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
    int decExponentRounded;
    char[] digits;
    private Form form;
    boolean fromHex;
    boolean isExceptional;
    boolean isNegative;
    boolean mustSetRoundDir;
    int nDigits;
    int precision;
    int roundDir;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum Form {
    }

    /* renamed from: -getsun-misc-FormattedFloatingDecimal$FormSwitchesValues  reason: not valid java name */
    private static /* synthetic */ int[] m638getsunmiscFormattedFloatingDecimal$FormSwitchesValues() {
        if (f110sunmiscFormattedFloatingDecimal$FormSwitchesValues != null) {
            return f110sunmiscFormattedFloatingDecimal$FormSwitchesValues;
        }
        int[] iArr = new int[Form.values().length];
        try {
            iArr[Form.COMPATIBLE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            iArr[Form.DECIMAL_FLOAT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            iArr[Form.GENERAL.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            iArr[Form.SCIENTIFIC.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f110sunmiscFormattedFloatingDecimal$FormSwitchesValues = iArr;
        return iArr;
    }

    private FormattedFloatingDecimal(boolean negSign, int decExponent2, char[] digits2, int n, boolean e, int precision2, Form form2) {
        this.mustSetRoundDir = f109assertionsDisabled;
        this.fromHex = f109assertionsDisabled;
        this.roundDir = 0;
        this.isNegative = negSign;
        this.isExceptional = e;
        this.decExponent = decExponent2;
        this.digits = digits2;
        this.nDigits = n;
        this.precision = precision2;
        this.form = form2;
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
        boolean z = f109assertionsDisabled;
        synchronized (FormattedFloatingDecimal.class) {
            if (!f109assertionsDisabled) {
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
            if (!f109assertionsDisabled) {
                if (!(lbits2 != 0 ? true : f109assertionsDisabled)) {
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
            if (!f109assertionsDisabled) {
                if (!(lvalue > 0 ? true : f109assertionsDisabled)) {
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
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.FormattedFloatingDecimal.roundup():void");
    }

    private int checkExponent(int length) {
        int i = 0;
        if (length >= this.nDigits || length < 0) {
            return this.decExponent;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (this.digits[i2] != '9') {
                return this.decExponent;
            }
        }
        int i3 = this.decExponent;
        if (this.digits[length] >= '5') {
            i = 1;
        }
        return i + i3;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r1v1, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r1v4, types: [char] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private char[] applyPrecision(int r9) {
        /*
            r8 = this;
            r7 = 53
            r6 = 49
            r4 = 57
            r5 = 0
            int r3 = r8.nDigits
            char[] r2 = new char[r3]
            r0 = 0
        L_0x000c:
            int r3 = r2.length
            if (r0 >= r3) goto L_0x0016
            r3 = 48
            r2[r0] = r3
            int r0 = r0 + 1
            goto L_0x000c
        L_0x0016:
            int r3 = r8.nDigits
            if (r9 >= r3) goto L_0x001c
            if (r9 >= 0) goto L_0x0024
        L_0x001c:
            char[] r3 = r8.digits
            int r4 = r8.nDigits
            java.lang.System.arraycopy((char[]) r3, (int) r5, (char[]) r2, (int) r5, (int) r4)
            return r2
        L_0x0024:
            if (r9 != 0) goto L_0x002f
            char[] r3 = r8.digits
            char r3 = r3[r5]
            if (r3 < r7) goto L_0x002e
            r2[r5] = r6
        L_0x002e:
            return r2
        L_0x002f:
            r0 = r9
            char[] r3 = r8.digits
            char r1 = r3[r9]
            if (r1 < r7) goto L_0x0055
            if (r9 <= 0) goto L_0x0055
            char[] r3 = r8.digits
            int r0 = r9 + -1
            char r1 = r3[r0]
            if (r1 != r4) goto L_0x0050
        L_0x0040:
            if (r1 != r4) goto L_0x004b
            if (r0 <= 0) goto L_0x004b
            char[] r3 = r8.digits
            int r0 = r0 + -1
            char r1 = r3[r0]
            goto L_0x0040
        L_0x004b:
            if (r1 != r4) goto L_0x0050
            r2[r5] = r6
            return r2
        L_0x0050:
            int r3 = r1 + 1
            char r3 = (char) r3
            r2[r0] = r3
        L_0x0055:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0060
            char[] r3 = r8.digits
            char r3 = r3[r0]
            r2[r0] = r3
            goto L_0x0055
        L_0x0060:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.FormattedFloatingDecimal.applyPrecision(int):char[]");
    }

    public FormattedFloatingDecimal(double d) {
        this(d, Integer.MAX_VALUE, Form.COMPATIBLE);
    }

    public FormattedFloatingDecimal(double d, int precision2, Form form2) {
        int nSignificantBits;
        this.mustSetRoundDir = f109assertionsDisabled;
        this.fromHex = f109assertionsDisabled;
        this.roundDir = 0;
        long dBits = Double.doubleToLongBits(d);
        this.precision = precision2;
        this.form = form2;
        if ((Long.MIN_VALUE & dBits) != 0) {
            this.isNegative = true;
            dBits ^= Long.MIN_VALUE;
        } else {
            this.isNegative = f109assertionsDisabled;
        }
        int binExp = (int) ((9218868437227405312L & dBits) >> 52);
        long fractBits = dBits & 4503599627370495L;
        if (binExp == 2047) {
            this.isExceptional = true;
            if (fractBits == 0) {
                this.digits = infinity;
            } else {
                this.digits = notANumber;
                this.isNegative = f109assertionsDisabled;
            }
            this.nDigits = this.digits.length;
            return;
        }
        this.isExceptional = f109assertionsDisabled;
        if (binExp != 0) {
            fractBits |= fractHOB;
            nSignificantBits = 53;
        } else if (fractBits == 0) {
            this.decExponent = 0;
            this.digits = zero;
            this.nDigits = 1;
            return;
        } else {
            while ((fractHOB & fractBits) == 0) {
                fractBits <<= 1;
                binExp--;
            }
            nSignificantBits = binExp + expShift + 1;
            binExp++;
        }
        dtoa(binExp - 1023, fractBits, nSignificantBits);
    }

    public FormattedFloatingDecimal(float f) {
        this(f, Integer.MAX_VALUE, Form.COMPATIBLE);
    }

    public FormattedFloatingDecimal(float f, int precision2, Form form2) {
        int nSignificantBits;
        this.mustSetRoundDir = f109assertionsDisabled;
        this.fromHex = f109assertionsDisabled;
        this.roundDir = 0;
        int fBits = Float.floatToIntBits(f);
        this.precision = precision2;
        this.form = form2;
        if ((fBits & Integer.MIN_VALUE) != 0) {
            this.isNegative = true;
            fBits ^= Integer.MIN_VALUE;
        } else {
            this.isNegative = f109assertionsDisabled;
        }
        int binExp = (2139095040 & fBits) >> 23;
        int fractBits = fBits & 8388607;
        if (binExp == 255) {
            this.isExceptional = true;
            if (((long) fractBits) == 0) {
                this.digits = infinity;
            } else {
                this.digits = notANumber;
                this.isNegative = f109assertionsDisabled;
            }
            this.nDigits = this.digits.length;
            return;
        }
        this.isExceptional = f109assertionsDisabled;
        if (binExp != 0) {
            fractBits |= singleFractHOB;
            nSignificantBits = 24;
        } else if (fractBits == 0) {
            this.decExponent = 0;
            this.digits = zero;
            this.nDigits = 1;
            return;
        } else {
            while ((fractBits & singleFractHOB) == 0) {
                fractBits <<= 1;
                binExp--;
            }
            nSignificantBits = binExp + 23 + 1;
            binExp++;
        }
        dtoa(binExp - 127, ((long) fractBits) << 29, nSignificantBits);
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
                boolean low3 = Bval.cmp(Mval2) < 0 ? true : f109assertionsDisabled;
                boolean high3 = Bval.add(Mval2).cmp(tenSval) > 0 ? true : f109assertionsDisabled;
                if (!f109assertionsDisabled) {
                    if (!(q < 10 ? true : f109assertionsDisabled)) {
                        throw new AssertionError((Object) Integer.valueOf(q));
                    }
                }
                if (q != 0 || high3) {
                    ndigit5 = 1;
                    digits2[0] = (char) (q + 48);
                } else {
                    decExp--;
                }
                if (this.form != Form.COMPATIBLE || -3 >= decExp || decExp >= 8) {
                    low3 = f109assertionsDisabled;
                    high3 = f109assertionsDisabled;
                    ndigit = ndigit5;
                } else {
                    ndigit = ndigit5;
                }
                while (!low && !high) {
                    int q2 = Bval.quoRemIteration(Sval);
                    Mval2 = Mval2.mult(10);
                    if (!f109assertionsDisabled) {
                        if (!(q2 < 10 ? true : f109assertionsDisabled)) {
                            throw new AssertionError((Object) Integer.valueOf(q2));
                        }
                    }
                    boolean low4 = Bval.cmp(Mval2) < 0 ? true : f109assertionsDisabled;
                    boolean high4 = Bval.add(Mval2).cmp(tenSval) > 0 ? true : f109assertionsDisabled;
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
                boolean low5 = b2 < m ? true : f109assertionsDisabled;
                boolean high5 = b2 + m > tens ? true : f109assertionsDisabled;
                if (!f109assertionsDisabled) {
                    if (!(q3 < 10 ? true : f109assertionsDisabled)) {
                        throw new AssertionError((Object) Integer.valueOf(q3));
                    }
                }
                if (q3 != 0 || high5) {
                    ndigit6 = 1;
                    digits2[0] = (char) (q3 + 48);
                } else {
                    decExp--;
                }
                if (this.form != Form.COMPATIBLE || -3 >= decExp || decExp >= 8) {
                    low5 = f109assertionsDisabled;
                    high5 = f109assertionsDisabled;
                    ndigit3 = ndigit6;
                } else {
                    ndigit3 = ndigit6;
                }
                while (!low && !high) {
                    int q4 = (int) (b2 / s);
                    b2 = 10 * (b2 % s);
                    m *= 10;
                    if (!f109assertionsDisabled) {
                        if (!(q4 < 10 ? true : f109assertionsDisabled)) {
                            throw new AssertionError((Object) Integer.valueOf(q4));
                        }
                    }
                    if (m > 0) {
                        low2 = b2 < m ? true : f109assertionsDisabled;
                        high2 = b2 + m > tens ? true : f109assertionsDisabled;
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
                boolean low6 = b4 < m2 ? true : f109assertionsDisabled;
                boolean high6 = b4 + m2 > tens2 ? true : f109assertionsDisabled;
                if (!f109assertionsDisabled) {
                    if (q5 < 10) {
                        z = true;
                    } else {
                        z = f109assertionsDisabled;
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
                if (this.form != Form.COMPATIBLE || -3 >= decExp || decExp >= 8) {
                    low6 = f109assertionsDisabled;
                    high6 = f109assertionsDisabled;
                    ndigit4 = ndigit7;
                } else {
                    ndigit4 = ndigit7;
                }
                while (!low && !high) {
                    int q6 = b4 / s2;
                    b4 = (b4 % s2) * 10;
                    m2 *= 10;
                    if (!f109assertionsDisabled) {
                        if (!(q6 < 10 ? true : f109assertionsDisabled)) {
                            throw new AssertionError((Object) Integer.valueOf(q6));
                        }
                    }
                    if (((long) m2) > 0) {
                        low = b4 < m2 ? true : f109assertionsDisabled;
                        high = b4 + m2 > tens2 ? true : f109assertionsDisabled;
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

    public int getExponent() {
        return this.decExponent - 1;
    }

    public int getExponentRounded() {
        return this.decExponentRounded - 1;
    }

    public int getChars(char[] result) {
        int i;
        int i2;
        int t;
        int i3;
        int e;
        int i4;
        int i5;
        int i6;
        int t2;
        if (!f109assertionsDisabled) {
            if (!(this.nDigits <= 19 ? true : f109assertionsDisabled)) {
                throw new AssertionError((Object) Integer.valueOf(this.nDigits));
            }
        }
        int i7 = 0;
        if (this.isNegative) {
            result[0] = '-';
            i7 = 1;
        }
        if (this.isExceptional) {
            System.arraycopy(this.digits, 0, result, i7, this.nDigits);
            return i7 + this.nDigits;
        }
        char[] digits2 = this.digits;
        int exp = this.decExponent;
        switch (m638getsunmiscFormattedFloatingDecimal$FormSwitchesValues()[this.form.ordinal()]) {
            case 1:
                break;
            case 2:
                exp = checkExponent(this.decExponent + this.precision);
                digits2 = applyPrecision(this.decExponent + this.precision);
                break;
            case 3:
                exp = checkExponent(this.precision);
                digits2 = applyPrecision(this.precision);
                if (exp - 1 >= -4 && exp - 1 < this.precision) {
                    this.form = Form.DECIMAL_FLOAT;
                    this.precision -= exp;
                    break;
                } else {
                    this.form = Form.SCIENTIFIC;
                    this.precision--;
                    break;
                }
                break;
            case 4:
                exp = checkExponent(this.precision + 1);
                digits2 = applyPrecision(this.precision + 1);
                break;
            default:
                if (!f109assertionsDisabled) {
                    throw new AssertionError();
                }
                break;
        }
        this.decExponentRounded = exp;
        if (exp > 0 && ((this.form == Form.COMPATIBLE && exp < 8) || this.form == Form.DECIMAL_FLOAT)) {
            int charLength = Math.min(this.nDigits, exp);
            System.arraycopy(digits2, 0, result, i7, charLength);
            int i8 = i7 + charLength;
            if (charLength < exp) {
                int charLength2 = exp - charLength;
                int nz = 0;
                int i9 = i8;
                while (nz < charLength2) {
                    result[i9] = '0';
                    nz++;
                    i9++;
                }
                if (this.form != Form.COMPATIBLE) {
                    return i9;
                }
                int i10 = i9 + 1;
                result[i9] = '.';
                result[i10] = '0';
                return i10 + 1;
            } else if (this.form == Form.COMPATIBLE) {
                int i11 = i8 + 1;
                result[i8] = '.';
                if (charLength < this.nDigits) {
                    int t3 = Math.min(this.nDigits - charLength, this.precision);
                    System.arraycopy(digits2, charLength, result, i11, t3);
                    return i11 + t3;
                }
                int i12 = i11 + 1;
                result[i11] = '0';
                return i12;
            } else {
                int t4 = Math.min(this.nDigits - charLength, this.precision);
                if (t4 <= 0) {
                    return i8;
                }
                int i13 = i8 + 1;
                result[i8] = '.';
                System.arraycopy(digits2, charLength, result, i13, t4);
                return i13 + t4;
            }
        } else if (exp > 0 || ((this.form != Form.COMPATIBLE || exp <= -3) && this.form != Form.DECIMAL_FLOAT)) {
            int i14 = i7 + 1;
            result[i7] = digits2[0];
            if (this.form == Form.COMPATIBLE) {
                int i15 = i14 + 1;
                result[i14] = '.';
                if (this.nDigits > 1) {
                    System.arraycopy(digits2, 1, result, i15, this.nDigits - 1);
                    i6 = i15 + (this.nDigits - 1);
                } else {
                    result[i15] = '0';
                    i6 = i15 + 1;
                }
                i2 = i6 + 1;
                result[i6] = 'E';
            } else {
                if (this.nDigits <= 1 || (t = Math.min(this.nDigits - 1, this.precision)) <= 0) {
                    i = i14;
                } else {
                    int i16 = i14 + 1;
                    result[i14] = '.';
                    System.arraycopy(digits2, 1, result, i16, t);
                    i = i16 + t;
                }
                i2 = i + 1;
                result[i] = 'e';
            }
            if (exp <= 0) {
                result[i2] = '-';
                e = (-exp) + 1;
                i4 = i2 + 1;
            } else {
                if (this.form != Form.COMPATIBLE) {
                    i3 = i2 + 1;
                    result[i2] = '+';
                } else {
                    i3 = i2;
                }
                e = exp - 1;
                i4 = i3;
            }
            if (e <= 9) {
                if (this.form != Form.COMPATIBLE) {
                    i5 = i4 + 1;
                    result[i4] = '0';
                } else {
                    i5 = i4;
                }
                result[i5] = (char) (e + 48);
                return i5 + 1;
            } else if (e <= 99) {
                int i17 = i4 + 1;
                result[i4] = (char) ((e / 10) + 48);
                result[i17] = (char) ((e % 10) + 48);
                return i17 + 1;
            } else {
                int i18 = i4 + 1;
                result[i4] = (char) ((e / 100) + 48);
                int e2 = e % 100;
                int i19 = i18 + 1;
                result[i18] = (char) ((e2 / 10) + 48);
                int i20 = i19 + 1;
                result[i19] = (char) ((e2 % 10) + 48);
                return i20;
            }
        } else {
            int i21 = i7 + 1;
            result[i7] = '0';
            if (exp != 0 && (t2 = Math.min(-exp, this.precision)) > 0) {
                result[i21] = '.';
                int nz2 = 0;
                i21++;
                while (nz2 < t2) {
                    result[i21] = '0';
                    nz2++;
                    i21++;
                }
            }
            int i22 = i21;
            int t5 = Math.min(digits2.length, this.precision + exp);
            if (t5 <= 0) {
                return i22;
            }
            if (i22 == 1) {
                result[i22] = '.';
                i22++;
            }
            System.arraycopy(digits2, 0, result, i22, t5);
            return i22 + t5;
        }
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
                    overvalue = f109assertionsDisabled;
                    diff = bigD.sub(bigB2);
                } else {
                    overvalue = true;
                    diff = bigB2.sub(bigD);
                    if (this.bigIntNBits == 1 && this.bigIntExp > -1023 && Ulp22 - 1 < 0) {
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
            this.mustSetRoundDir = this.fromHex ? f109assertionsDisabled : true;
            return stickyRound(doubleValue());
        } else if (this.digits == notANumber) {
            return Float.NaN;
        } else {
            return this.isNegative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
    }
}
