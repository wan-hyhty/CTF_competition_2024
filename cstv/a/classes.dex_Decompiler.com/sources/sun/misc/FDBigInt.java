package sun.misc;

public class FDBigInt {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f107assertionsDisabled = false;
    int[] data;
    int nWords;

    public FDBigInt(int v) {
        this.nWords = 1;
        this.data = new int[1];
        this.data[0] = v;
    }

    public FDBigInt(long v) {
        int i = 1;
        this.data = new int[2];
        this.data[0] = (int) v;
        this.data[1] = (int) (v >>> 32);
        this.nWords = this.data[1] != 0 ? 2 : i;
    }

    public FDBigInt(FDBigInt other) {
        int i = other.nWords;
        this.nWords = i;
        this.data = new int[i];
        System.arraycopy(other.data, 0, this.data, 0, this.nWords);
    }

    private FDBigInt(int[] d, int n) {
        this.data = d;
        this.nWords = n;
    }

    public FDBigInt(long seed, char[] digit, int nd0, int nd) {
        int n = (nd + 8) / 9;
        this.data = new int[(n < 2 ? 2 : n)];
        this.data[0] = (int) seed;
        this.data[1] = (int) (seed >>> 32);
        this.nWords = this.data[1] == 0 ? 1 : 2;
        int limit = nd - 5;
        int i = nd0;
        while (i < limit) {
            int ilim = i + 5;
            int v = digit[i] - '0';
            i++;
            while (i < ilim) {
                v = ((v * 10) + digit[i]) - 48;
                i++;
            }
            multaddMe(100000, v);
        }
        int factor = 1;
        int v2 = 0;
        while (i < nd) {
            v2 = ((v2 * 10) + digit[i]) - 48;
            factor *= 10;
            i++;
        }
        if (factor != 1) {
            multaddMe(factor, v2);
        }
    }

    public void lshiftMe(int c) throws IllegalArgumentException {
        int target;
        if (c > 0) {
            int wordcount = c >> 5;
            int bitcount = c & 31;
            int anticount = 32 - bitcount;
            int[] t = this.data;
            int[] s = this.data;
            if (this.nWords + wordcount + 1 > t.length) {
                t = new int[(this.nWords + wordcount + 1)];
            }
            int target2 = this.nWords + wordcount;
            int src = this.nWords - 1;
            if (bitcount == 0) {
                System.arraycopy(s, 0, t, wordcount, this.nWords);
                target = wordcount - 1;
            } else {
                int target3 = target2 - 1;
                t[target2] = s[src] >>> anticount;
                while (src >= 1) {
                    src--;
                    t[target3] = (s[src] << bitcount) | (s[src] >>> anticount);
                    target3--;
                }
                t[target3] = s[src] << bitcount;
                target = target3 - 1;
            }
            while (target >= 0) {
                t[target] = 0;
                target--;
            }
            this.data = t;
            this.nWords += wordcount + 1;
            while (this.nWords > 1 && this.data[this.nWords - 1] == 0) {
                this.nWords--;
            }
        } else if (c != 0) {
            throw new IllegalArgumentException("negative shift count");
        }
    }

    public int normalizeMe() throws IllegalArgumentException {
        int bitcount;
        int wordcount = 0;
        int bitcount2 = 0;
        int v = 0;
        int src = this.nWords - 1;
        while (src >= 0) {
            v = this.data[src];
            if (v != 0) {
                break;
            }
            wordcount++;
            src--;
        }
        if (src < 0) {
            throw new IllegalArgumentException("zero value");
        }
        this.nWords -= wordcount;
        if ((v & -268435456) != 0) {
            bitcount = 32;
            while ((v & -268435456) != 0) {
                v >>>= 1;
                bitcount--;
            }
        } else {
            while (v <= 1048575) {
                v <<= 8;
                bitcount2 += 8;
            }
            while (v <= 134217727) {
                v <<= 1;
                bitcount2 = bitcount + 1;
            }
        }
        if (bitcount != 0) {
            lshiftMe(bitcount);
        }
        return bitcount;
    }

    public FDBigInt mult(int iv) {
        long v = (long) iv;
        int[] r = new int[((((long) this.data[this.nWords + -1]) & 4294967295L) * v > 268435455 ? this.nWords + 1 : this.nWords)];
        long p = 0;
        for (int i = 0; i < this.nWords; i++) {
            long p2 = p + ((((long) this.data[i]) & 4294967295L) * v);
            r[i] = (int) p2;
            p = p2 >>> 32;
        }
        if (p == 0) {
            return new FDBigInt(r, this.nWords);
        }
        r[this.nWords] = (int) p;
        return new FDBigInt(r, this.nWords + 1);
    }

    public void multaddMe(int iv, int addend) {
        long v = (long) iv;
        long p = ((((long) this.data[0]) & 4294967295L) * v) + (((long) addend) & 4294967295L);
        this.data[0] = (int) p;
        long p2 = p >>> 32;
        for (int i = 1; i < this.nWords; i++) {
            long p3 = p2 + ((((long) this.data[i]) & 4294967295L) * v);
            this.data[i] = (int) p3;
            p2 = p3 >>> 32;
        }
        if (p2 != 0) {
            this.data[this.nWords] = (int) p2;
            this.nWords++;
        }
    }

    public FDBigInt mult(FDBigInt other) {
        int[] r = new int[(this.nWords + other.nWords)];
        for (int i = 0; i < this.nWords; i++) {
            long v = ((long) this.data[i]) & 4294967295L;
            long p = 0;
            int j = 0;
            while (j < other.nWords) {
                long p2 = p + (((long) r[i + j]) & 4294967295L) + ((((long) other.data[j]) & 4294967295L) * v);
                r[i + j] = (int) p2;
                p = p2 >>> 32;
                j++;
            }
            r[i + j] = (int) p;
        }
        int i2 = r.length - 1;
        while (i2 > 0 && r[i2] == 0) {
            i2--;
        }
        return new FDBigInt(r, i2 + 1);
    }

    public FDBigInt add(FDBigInt other) {
        int[] a;
        int n;
        int[] b;
        int m;
        long c = 0;
        if (this.nWords >= other.nWords) {
            a = this.data;
            n = this.nWords;
            b = other.data;
            m = other.nWords;
        } else {
            a = other.data;
            n = other.nWords;
            b = this.data;
            m = this.nWords;
        }
        int[] r = new int[n];
        int i = 0;
        while (i < n) {
            long c2 = c + (((long) a[i]) & 4294967295L);
            if (i < m) {
                c2 += ((long) b[i]) & 4294967295L;
            }
            r[i] = (int) c2;
            c = c2 >> 32;
            i++;
        }
        if (c == 0) {
            return new FDBigInt(r, i);
        }
        int[] s = new int[(r.length + 1)];
        System.arraycopy(r, 0, s, 0, r.length);
        s[i] = (int) c;
        return new FDBigInt(s, i + 1);
    }

    public FDBigInt sub(FDBigInt other) {
        boolean z = false;
        int[] r = new int[this.nWords];
        int n = this.nWords;
        int m = other.nWords;
        int nzeros = 0;
        long c = 0;
        int i = 0;
        while (i < n) {
            long c2 = c + (((long) this.data[i]) & 4294967295L);
            if (i < m) {
                c2 -= ((long) other.data[i]) & 4294967295L;
            }
            int i2 = (int) c2;
            r[i] = i2;
            if (i2 == 0) {
                nzeros++;
            } else {
                nzeros = 0;
            }
            c = c2 >> 32;
            i++;
        }
        if (!f107assertionsDisabled) {
            if (c == 0) {
                z = true;
            }
            if (!z) {
                throw new AssertionError((Object) Long.valueOf(c));
            }
        }
        if (f107assertionsDisabled || dataInRangeIsZero(i, m, other)) {
            return new FDBigInt(r, n - nzeros);
        }
        throw new AssertionError();
    }

    private static boolean dataInRangeIsZero(int i, int m, FDBigInt other) {
        int i2 = i;
        while (i2 < m) {
            int i3 = i2 + 1;
            if (other.data[i2] != 0) {
                return false;
            }
            i2 = i3;
        }
        return true;
    }

    public int cmp(FDBigInt other) {
        int i;
        if (this.nWords > other.nWords) {
            int j = other.nWords - 1;
            i = this.nWords - 1;
            while (i > j) {
                if (this.data[i] != 0) {
                    return 1;
                }
                i--;
            }
        } else if (this.nWords < other.nWords) {
            int j2 = this.nWords - 1;
            int i2 = other.nWords - 1;
            while (i > j2) {
                if (other.data[i] != 0) {
                    return -1;
                }
                i2 = i - 1;
            }
        } else {
            i = this.nWords - 1;
        }
        while (i > 0 && this.data[i] == other.data[i]) {
            i--;
        }
        int a = this.data[i];
        int b = other.data[i];
        if (a < 0) {
            if (b < 0) {
                return a - b;
            }
            return 1;
        } else if (b < 0) {
            return -1;
        } else {
            return a - b;
        }
    }

    public int quoRemIteration(FDBigInt S) throws IllegalArgumentException {
        if (this.nWords != S.nWords) {
            throw new IllegalArgumentException("disparate values");
        }
        int n = this.nWords - 1;
        long q = (((long) this.data[n]) & 4294967295L) / ((long) S.data[n]);
        long diff = 0;
        for (int i = 0; i <= n; i++) {
            long diff2 = diff + ((((long) this.data[i]) & 4294967295L) - ((((long) S.data[i]) & 4294967295L) * q));
            this.data[i] = (int) diff2;
            diff = diff2 >> 32;
        }
        if (diff != 0) {
            long sum = 0;
            while (sum == 0) {
                sum = 0;
                for (int i2 = 0; i2 <= n; i2++) {
                    long sum2 = sum + (((long) this.data[i2]) & 4294967295L) + (((long) S.data[i2]) & 4294967295L);
                    this.data[i2] = (int) sum2;
                    sum = sum2 >> 32;
                }
                if (!f107assertionsDisabled) {
                    if (!(sum == 0 || sum == 1)) {
                        throw new AssertionError((Object) Long.valueOf(sum));
                    }
                }
                q--;
            }
        }
        long p = 0;
        for (int i3 = 0; i3 <= n; i3++) {
            long p2 = p + ((((long) this.data[i3]) & 4294967295L) * 10);
            this.data[i3] = (int) p2;
            p = p2 >> 32;
        }
        if (!f107assertionsDisabled) {
            if (!(p == 0)) {
                throw new AssertionError((Object) Long.valueOf(p));
            }
        }
        return (int) q;
    }

    public long longValue() {
        if (!f107assertionsDisabled) {
            if (!(this.nWords > 0)) {
                throw new AssertionError((Object) Integer.valueOf(this.nWords));
            }
        }
        if (this.nWords == 1) {
            return ((long) this.data[0]) & 4294967295L;
        }
        if (f107assertionsDisabled || dataInRangeIsZero(2, this.nWords, this)) {
            if (!f107assertionsDisabled) {
                if (!(this.data[1] >= 0)) {
                    throw new AssertionError();
                }
            }
            return (((long) this.data[1]) << 32) | (((long) this.data[0]) & 4294967295L);
        }
        throw new AssertionError();
    }

    public String toString() {
        StringBuffer r = new StringBuffer(30);
        r.append('[');
        if (this.nWords > this.data.length) {
            r.append("(" + this.data.length + "<" + this.nWords + "!)");
        }
        for (int i = Math.min(this.nWords - 1, this.data.length - 1); i > 0; i--) {
            r.append(Integer.toHexString(this.data[i]));
            r.append(' ');
        }
        r.append(Integer.toHexString(this.data[0]));
        r.append(']');
        return new String(r);
    }
}
