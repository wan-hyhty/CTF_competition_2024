package java.util;

import java.lang.reflect.Array;

class TimSort<T> {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f55assertionsDisabled = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;
    private final T[] a;
    private final Comparator<? super T> c;
    private int minGallop = 7;
    private final int[] runBase;
    private final int[] runLen;
    private int stackSize = 0;
    private T[] tmp;
    private int tmpBase;
    private int tmpLen;

    private TimSort(T[] a2, Comparator<? super T> c2, T[] work, int workBase, int workLen) {
        int stackLen;
        this.a = a2;
        this.c = c2;
        int len = a2.length;
        int tlen = len < 512 ? len >>> 1 : 256;
        if (work == null || workLen < tlen || workBase + tlen > work.length) {
            this.tmp = (Object[]) Array.newInstance(a2.getClass().getComponentType(), tlen);
            this.tmpBase = 0;
            this.tmpLen = tlen;
        } else {
            this.tmp = work;
            this.tmpBase = workBase;
            this.tmpLen = workLen;
        }
        if (len < 120) {
            stackLen = 5;
        } else if (len < 1542) {
            stackLen = 10;
        } else {
            stackLen = len < 119151 ? 24 : 40;
        }
        this.runBase = new int[stackLen];
        this.runLen = new int[stackLen];
    }

    static <T> void sort(T[] a2, int lo, int hi, Comparator<? super T> c2, T[] work, int workBase, int workLen) {
        boolean z;
        if (!f55assertionsDisabled) {
            if (!((c2 == null || a2 == null || lo < 0 || lo > hi || hi > a2.length) ? f55assertionsDisabled : true)) {
                throw new AssertionError();
            }
        }
        int nRemaining = hi - lo;
        if (nRemaining >= 2) {
            if (nRemaining < 32) {
                binarySort(a2, lo, hi, lo + countRunAndMakeAscending(a2, lo, hi, c2), c2);
                return;
            }
            TimSort<T> ts = new TimSort<>(a2, c2, work, workBase, workLen);
            int minRun = minRunLength(nRemaining);
            do {
                int runLen2 = countRunAndMakeAscending(a2, lo, hi, c2);
                if (runLen2 < minRun) {
                    int force = nRemaining <= minRun ? nRemaining : minRun;
                    binarySort(a2, lo, lo + force, lo + runLen2, c2);
                    runLen2 = force;
                }
                ts.pushRun(lo, runLen2);
                ts.mergeCollapse();
                lo += runLen2;
                nRemaining -= runLen2;
            } while (nRemaining != 0);
            if (!f55assertionsDisabled) {
                if (lo == hi) {
                    z = true;
                } else {
                    z = f55assertionsDisabled;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            ts.mergeForceCollapse();
            if (!f55assertionsDisabled) {
                if (!(ts.stackSize == 1 ? true : f55assertionsDisabled)) {
                    throw new AssertionError();
                }
            }
        }
    }

    private static <T> void binarySort(T[] a2, int lo, int hi, int start, Comparator<? super T> c2) {
        if (!f55assertionsDisabled) {
            if (!(lo <= start && start <= hi)) {
                throw new AssertionError();
            }
        }
        if (start == lo) {
            start++;
        }
        while (start < hi) {
            T pivot = a2[start];
            int left = lo;
            int right = start;
            if (!f55assertionsDisabled) {
                if (!(lo <= right)) {
                    throw new AssertionError();
                }
            }
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (c2.compare(pivot, a2[mid]) < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (!f55assertionsDisabled) {
                if (!(left == right)) {
                    throw new AssertionError();
                }
            }
            int n = start - left;
            switch (n) {
                case 1:
                    break;
                case 2:
                    a2[left + 2] = a2[left + 1];
                    break;
                default:
                    System.arraycopy((Object) a2, left, (Object) a2, left + 1, n);
                    continue;
            }
            a2[left + 1] = a2[left];
            a2[left] = pivot;
            start++;
        }
    }

    private static <T> int countRunAndMakeAscending(T[] a2, int lo, int hi, Comparator<? super T> c2) {
        int runHi;
        boolean z = f55assertionsDisabled;
        if (!f55assertionsDisabled) {
            if (lo < hi) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        int runHi2 = lo + 1;
        if (runHi2 == hi) {
            return 1;
        }
        int runHi3 = runHi2 + 1;
        if (c2.compare(a2[runHi2], a2[lo]) < 0) {
            runHi = runHi3;
            while (runHi < hi && c2.compare(a2[runHi], a2[runHi - 1]) < 0) {
                runHi++;
            }
            reverseRange(a2, lo, runHi);
        } else {
            int runHi4 = runHi3;
            while (runHi < hi && c2.compare(a2[runHi], a2[runHi - 1]) >= 0) {
                runHi4 = runHi + 1;
            }
        }
        return runHi - lo;
    }

    private static void reverseRange(Object[] a2, int lo, int hi) {
        int hi2 = hi - 1;
        for (int lo2 = lo; lo2 < hi2; lo2++) {
            Object t = a2[lo2];
            a2[lo2] = a2[hi2];
            a2[hi2] = t;
            hi2--;
        }
    }

    private static int minRunLength(int n) {
        boolean z = f55assertionsDisabled;
        if (!f55assertionsDisabled) {
            if (n >= 0) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        int r = 0;
        while (n >= 32) {
            r |= n & 1;
            n >>= 1;
        }
        return n + r;
    }

    private void pushRun(int runBase2, int runLen2) {
        this.runBase[this.stackSize] = runBase2;
        this.runLen[this.stackSize] = runLen2;
        this.stackSize++;
    }

    private void mergeCollapse() {
        while (this.stackSize > 1) {
            int n = this.stackSize - 2;
            if (n > 0 && this.runLen[n - 1] <= this.runLen[n] + this.runLen[n + 1]) {
                if (this.runLen[n - 1] < this.runLen[n + 1]) {
                    n--;
                }
                mergeAt(n);
            } else if (this.runLen[n] <= this.runLen[n + 1]) {
                mergeAt(n);
            } else {
                return;
            }
        }
    }

    private void mergeForceCollapse() {
        while (this.stackSize > 1) {
            int n = this.stackSize - 2;
            if (n > 0 && this.runLen[n - 1] < this.runLen[n + 1]) {
                n--;
            }
            mergeAt(n);
        }
    }

    private void mergeAt(int i) {
        boolean z = f55assertionsDisabled;
        if (!f55assertionsDisabled) {
            if (!(this.stackSize >= 2)) {
                throw new AssertionError();
            }
        }
        if (!f55assertionsDisabled) {
            if (!(i >= 0)) {
                throw new AssertionError();
            }
        }
        if (!f55assertionsDisabled) {
            if (!(i == this.stackSize + -2 || i == this.stackSize + -3)) {
                throw new AssertionError();
            }
        }
        int base1 = this.runBase[i];
        int len1 = this.runLen[i];
        int base2 = this.runBase[i + 1];
        int len2 = this.runLen[i + 1];
        if (!f55assertionsDisabled) {
            if (!(len1 > 0 && len2 > 0)) {
                throw new AssertionError();
            }
        }
        if (!f55assertionsDisabled) {
            if (!(base1 + len1 == base2)) {
                throw new AssertionError();
            }
        }
        this.runLen[i] = len1 + len2;
        if (i == this.stackSize - 3) {
            this.runBase[i + 1] = this.runBase[i + 2];
            this.runLen[i + 1] = this.runLen[i + 2];
        }
        this.stackSize--;
        int k = gallopRight(this.a[base2], this.a, base1, len1, 0, this.c);
        if (!f55assertionsDisabled) {
            if (!(k >= 0)) {
                throw new AssertionError();
            }
        }
        int base12 = base1 + k;
        int len12 = len1 - k;
        if (len12 != 0) {
            int len22 = gallopLeft(this.a[(base12 + len12) - 1], this.a, base2, len2, len2 - 1, this.c);
            if (!f55assertionsDisabled) {
                if (len22 >= 0) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (len22 != 0) {
                if (len12 <= len22) {
                    mergeLo(base12, len12, base2, len22);
                } else {
                    mergeHi(base12, len12, base2, len22);
                }
            }
        }
    }

    private static <T> int gallopLeft(T key, T[] a2, int base, int len, int hint, Comparator<? super T> c2) {
        int lastOfs;
        int ofs;
        boolean z;
        boolean z2 = true;
        if (!f55assertionsDisabled) {
            if (!(len > 0 && hint >= 0 && hint < len)) {
                throw new AssertionError();
            }
        }
        int lastOfs2 = 0;
        int ofs2 = 1;
        if (c2.compare(key, a2[base + hint]) > 0) {
            int maxOfs = len - hint;
            while (ofs2 < maxOfs && c2.compare(key, a2[base + hint + ofs2]) > 0) {
                lastOfs2 = ofs2;
                ofs2 = (ofs2 << 1) + 1;
                if (ofs2 <= 0) {
                    ofs2 = maxOfs;
                }
            }
            if (ofs2 > maxOfs) {
                ofs2 = maxOfs;
            }
            lastOfs = lastOfs2 + hint;
            ofs = ofs2 + hint;
        } else {
            int maxOfs2 = hint + 1;
            while (ofs2 < maxOfs2 && c2.compare(key, a2[(base + hint) - ofs2]) <= 0) {
                lastOfs2 = ofs2;
                int ofs3 = (ofs2 << 1) + 1;
                if (ofs3 <= 0) {
                    ofs3 = maxOfs2;
                }
            }
            if (ofs2 > maxOfs2) {
                ofs2 = maxOfs2;
            }
            int tmp2 = lastOfs2;
            lastOfs = hint - ofs2;
            ofs = hint - tmp2;
        }
        if (!f55assertionsDisabled) {
            if (-1 > lastOfs || lastOfs >= ofs || ofs > len) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        int lastOfs3 = lastOfs + 1;
        while (lastOfs3 < ofs) {
            int m = lastOfs3 + ((ofs - lastOfs3) >>> 1);
            if (c2.compare(key, a2[base + m]) > 0) {
                lastOfs3 = m + 1;
            } else {
                ofs = m;
            }
        }
        if (!f55assertionsDisabled) {
            if (lastOfs3 != ofs) {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        return ofs;
    }

    private static <T> int gallopRight(T key, T[] a2, int base, int len, int hint, Comparator<? super T> c2) {
        int lastOfs;
        int ofs;
        boolean z;
        boolean z2 = true;
        if (!f55assertionsDisabled) {
            if (!(len > 0 && hint >= 0 && hint < len)) {
                throw new AssertionError();
            }
        }
        int ofs2 = 1;
        int lastOfs2 = 0;
        if (c2.compare(key, a2[base + hint]) < 0) {
            int maxOfs = hint + 1;
            while (ofs2 < maxOfs && c2.compare(key, a2[(base + hint) - ofs2]) < 0) {
                lastOfs2 = ofs2;
                ofs2 = (ofs2 << 1) + 1;
                if (ofs2 <= 0) {
                    ofs2 = maxOfs;
                }
            }
            if (ofs2 > maxOfs) {
                ofs2 = maxOfs;
            }
            int tmp2 = lastOfs2;
            lastOfs = hint - ofs2;
            ofs = hint - tmp2;
        } else {
            int maxOfs2 = len - hint;
            while (ofs2 < maxOfs2 && c2.compare(key, a2[base + hint + ofs2]) >= 0) {
                lastOfs2 = ofs2;
                int ofs3 = (ofs2 << 1) + 1;
                if (ofs3 <= 0) {
                    ofs3 = maxOfs2;
                }
            }
            if (ofs2 > maxOfs2) {
                ofs2 = maxOfs2;
            }
            lastOfs = lastOfs2 + hint;
            ofs = ofs2 + hint;
        }
        if (!f55assertionsDisabled) {
            if (-1 > lastOfs || lastOfs >= ofs || ofs > len) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        int lastOfs3 = lastOfs + 1;
        while (lastOfs3 < ofs) {
            int m = lastOfs3 + ((ofs - lastOfs3) >>> 1);
            if (c2.compare(key, a2[base + m]) < 0) {
                ofs = m;
            } else {
                lastOfs3 = m + 1;
            }
        }
        if (!f55assertionsDisabled) {
            if (lastOfs3 != ofs) {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        return ofs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01be, code lost:
        r18 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00dc, code lost:
        r17 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e0, code lost:
        if (f55assertionsDisabled != false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e5, code lost:
        if (r23 <= 1) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e7, code lost:
        if (r25 <= 0) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e9, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ea, code lost:
        if (r2 != false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f1, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f2, code lost:
        r2 = f55assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f4, code lost:
        r14 = gallopRight(r9[r17], r3, r4, r23, 0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fd, code lost:
        if (r14 == 0) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ff, code lost:
        java.lang.System.arraycopy((java.lang.Object) r3, r4, (java.lang.Object) r9, r18, r14);
        r18 = r18 + r14;
        r4 = r4 + r14;
        r23 = r23 - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x010c, code lost:
        if (r23 > 1) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010e, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0111, code lost:
        r19 = r18 + 1;
        r10 = r17 + 1;
        r9[r18] = r9[r17];
        r25 = r25 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
        if (r25 != 0) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x011d, code lost:
        r18 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0121, code lost:
        r15 = gallopLeft(r3[r4], r9, r10, r25, 0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012b, code lost:
        if (r15 == 0) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012d, code lost:
        java.lang.System.arraycopy((java.lang.Object) r9, r10, (java.lang.Object) r9, r19, r15);
        r18 = r19 + r15;
        r10 = r10 + r15;
        r25 = r25 - r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0137, code lost:
        if (r25 == 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0139, code lost:
        r19 = r18 + 1;
        r16 = r4 + 1;
        r9[r18] = r3[r4];
        r23 = r23 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0146, code lost:
        if (r23 != 1) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0148, code lost:
        r18 = r19;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x014e, code lost:
        r20 = r20 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0151, code lost:
        if (r14 < 7) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0153, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0156, code lost:
        if (r15 < 7) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0158, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015a, code lost:
        if ((r2 | r5) == false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x015c, code lost:
        r18 = r19;
        r17 = r10;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0164, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0167, code lost:
        r2 = f55assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0169, code lost:
        if (r20 >= 0) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x016b, code lost:
        r20 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x00dc A[EDGE_INSN: B:129:0x00dc->B:54:0x00dc ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeLo(int r22, int r23, int r24, int r25) {
        /*
            r21 = this;
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x0019
            if (r23 <= 0) goto L_0x0017
            if (r25 <= 0) goto L_0x0017
            int r2 = r22 + r23
            r0 = r24
            if (r2 != r0) goto L_0x0017
            r2 = 1
        L_0x000f:
            if (r2 != 0) goto L_0x0019
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0017:
            r2 = 0
            goto L_0x000f
        L_0x0019:
            r0 = r21
            T[] r9 = r0.a
            r0 = r21
            r1 = r23
            java.lang.Object[] r3 = r0.ensureCapacity(r1)
            r0 = r21
            int r4 = r0.tmpBase
            r10 = r24
            r18 = r22
            r0 = r22
            r1 = r23
            java.lang.System.arraycopy((java.lang.Object) r9, (int) r0, (java.lang.Object) r3, (int) r4, (int) r1)
            int r18 = r22 + 1
            int r10 = r24 + 1
            r2 = r9[r24]
            r9[r22] = r2
            int r25 = r25 + -1
            if (r25 != 0) goto L_0x0048
            r0 = r18
            r1 = r23
            java.lang.System.arraycopy((java.lang.Object) r3, (int) r4, (java.lang.Object) r9, (int) r0, (int) r1)
            return
        L_0x0048:
            r2 = 1
            r0 = r23
            if (r0 != r2) goto L_0x005b
            r0 = r18
            r1 = r25
            java.lang.System.arraycopy((java.lang.Object) r9, (int) r10, (java.lang.Object) r9, (int) r0, (int) r1)
            int r2 = r18 + r25
            r5 = r3[r4]
            r9[r2] = r5
            return
        L_0x005b:
            r0 = r21
            java.util.Comparator<? super T> r7 = r0.c
            r0 = r21
            int r0 = r0.minGallop
            r20 = r0
        L_0x0065:
            r14 = 0
            r15 = 0
        L_0x0067:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x007d
            r2 = 1
            r0 = r23
            if (r0 <= r2) goto L_0x007b
            if (r25 <= 0) goto L_0x007b
            r2 = 1
        L_0x0073:
            if (r2 != 0) goto L_0x007d
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x007b:
            r2 = 0
            goto L_0x0073
        L_0x007d:
            r2 = r9[r10]
            r5 = r3[r4]
            int r2 = r7.compare(r2, r5)
            if (r2 >= 0) goto L_0x00bb
            int r19 = r18 + 1
            int r17 = r10 + 1
            r2 = r9[r10]
            r9[r18] = r2
            int r15 = r15 + 1
            r14 = 0
            int r25 = r25 + -1
            if (r25 != 0) goto L_0x01c2
            r18 = r19
            r10 = r17
        L_0x009a:
            r2 = 1
            r0 = r20
            if (r0 >= r2) goto L_0x00a1
            r20 = 1
        L_0x00a1:
            r0 = r20
            r1 = r21
            r1.minGallop = r0
            r2 = 1
            r0 = r23
            if (r0 != r2) goto L_0x0186
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x0178
            if (r25 <= 0) goto L_0x0175
            r2 = 1
        L_0x00b3:
            if (r2 != 0) goto L_0x0178
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x00bb:
            int r19 = r18 + 1
            int r16 = r4 + 1
            r2 = r3[r4]
            r9[r18] = r2
            int r14 = r14 + 1
            r15 = 0
            int r23 = r23 + -1
            r2 = 1
            r0 = r23
            if (r0 != r2) goto L_0x00d2
            r18 = r19
            r4 = r16
            goto L_0x009a
        L_0x00d2:
            r18 = r19
            r4 = r16
        L_0x00d6:
            r2 = r14 | r15
            r0 = r20
            if (r2 < r0) goto L_0x0067
            r17 = r10
        L_0x00de:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x00f4
            r2 = 1
            r0 = r23
            if (r0 <= r2) goto L_0x00f2
            if (r25 <= 0) goto L_0x00f2
            r2 = 1
        L_0x00ea:
            if (r2 != 0) goto L_0x00f4
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x00f2:
            r2 = 0
            goto L_0x00ea
        L_0x00f4:
            r2 = r9[r17]
            r6 = 0
            r5 = r23
            int r14 = gallopRight(r2, r3, r4, r5, r6, r7)
            if (r14 == 0) goto L_0x0111
            r0 = r18
            java.lang.System.arraycopy((java.lang.Object) r3, (int) r4, (java.lang.Object) r9, (int) r0, (int) r14)
            int r18 = r18 + r14
            int r4 = r4 + r14
            int r23 = r23 - r14
            r2 = 1
            r0 = r23
            if (r0 > r2) goto L_0x0111
            r10 = r17
            goto L_0x009a
        L_0x0111:
            int r19 = r18 + 1
            int r10 = r17 + 1
            r2 = r9[r17]
            r9[r18] = r2
            int r25 = r25 + -1
            if (r25 != 0) goto L_0x0121
            r18 = r19
            goto L_0x009a
        L_0x0121:
            r8 = r3[r4]
            r12 = 0
            r11 = r25
            r13 = r7
            int r15 = gallopLeft(r8, r9, r10, r11, r12, r13)
            if (r15 == 0) goto L_0x01be
            r0 = r19
            java.lang.System.arraycopy((java.lang.Object) r9, (int) r10, (java.lang.Object) r9, (int) r0, (int) r15)
            int r18 = r19 + r15
            int r10 = r10 + r15
            int r25 = r25 - r15
            if (r25 == 0) goto L_0x009a
        L_0x0139:
            int r19 = r18 + 1
            int r16 = r4 + 1
            r2 = r3[r4]
            r9[r18] = r2
            int r23 = r23 + -1
            r2 = 1
            r0 = r23
            if (r0 != r2) goto L_0x014e
            r18 = r19
            r4 = r16
            goto L_0x009a
        L_0x014e:
            int r20 = r20 + -1
            r2 = 7
            if (r14 < r2) goto L_0x0164
            r2 = 1
            r5 = r2
        L_0x0155:
            r2 = 7
            if (r15 < r2) goto L_0x0167
            r2 = 1
        L_0x0159:
            r2 = r2 | r5
            if (r2 == 0) goto L_0x0169
            r18 = r19
            r17 = r10
            r4 = r16
            goto L_0x00de
        L_0x0164:
            r2 = 0
            r5 = r2
            goto L_0x0155
        L_0x0167:
            r2 = 0
            goto L_0x0159
        L_0x0169:
            if (r20 >= 0) goto L_0x016d
            r20 = 0
        L_0x016d:
            int r20 = r20 + 2
            r18 = r19
            r4 = r16
            goto L_0x0065
        L_0x0175:
            r2 = 0
            goto L_0x00b3
        L_0x0178:
            r0 = r18
            r1 = r25
            java.lang.System.arraycopy((java.lang.Object) r9, (int) r10, (java.lang.Object) r9, (int) r0, (int) r1)
            int r2 = r18 + r25
            r5 = r3[r4]
            r9[r2] = r5
        L_0x0185:
            return
        L_0x0186:
            if (r23 != 0) goto L_0x0191
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Comparison method violates its general contract!"
            r2.<init>((java.lang.String) r5)
            throw r2
        L_0x0191:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x01a2
            if (r25 != 0) goto L_0x01a0
            r2 = 1
        L_0x0198:
            if (r2 != 0) goto L_0x01a2
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x01a0:
            r2 = 0
            goto L_0x0198
        L_0x01a2:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x01b6
            r2 = 1
            r0 = r23
            if (r0 <= r2) goto L_0x01b4
            r2 = 1
        L_0x01ac:
            if (r2 != 0) goto L_0x01b6
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x01b4:
            r2 = 0
            goto L_0x01ac
        L_0x01b6:
            r0 = r18
            r1 = r23
            java.lang.System.arraycopy((java.lang.Object) r3, (int) r4, (java.lang.Object) r9, (int) r0, (int) r1)
            goto L_0x0185
        L_0x01be:
            r18 = r19
            goto L_0x0139
        L_0x01c2:
            r18 = r19
            r10 = r17
            goto L_0x00d6
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimSort.mergeLo(int, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01dc, code lost:
        r20 = r21;
        r18 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f0, code lost:
        if (f55assertionsDisabled != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f2, code lost:
        if (r25 <= 0) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (r27 <= 1) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f9, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fa, code lost:
        if (r2 != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0101, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0102, code lost:
        r2 = f55assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0104, code lost:
        r14 = r25 - gallopRight(r9[r18], r3, r24, r25, r25 - 1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0112, code lost:
        if (r14 == 0) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0114, code lost:
        r20 = r20 - r14;
        r16 = r16 - r14;
        r25 = r25 - r14;
        java.lang.System.arraycopy((java.lang.Object) r3, r16 + 1, (java.lang.Object) r3, r20 + 1, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0121, code lost:
        if (r25 == 0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0123, code lost:
        r21 = r20 - 1;
        r19 = r18 - 1;
        r3[r20] = r9[r18];
        r27 = r27 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        if (r27 != 1) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0132, code lost:
        r20 = r21;
        r18 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0138, code lost:
        r15 = r27 - gallopLeft(r3[r16], r9, r10, r27, r27 - 1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0145, code lost:
        if (r15 == 0) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0147, code lost:
        r20 = r21 - r15;
        r18 = r19 - r15;
        r27 = r27 - r15;
        java.lang.System.arraycopy((java.lang.Object) r9, r18 + 1, (java.lang.Object) r3, r20 + 1, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0157, code lost:
        if (r27 <= 1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0159, code lost:
        r21 = r20 - 1;
        r17 = r16 - 1;
        r3[r20] = r3[r16];
        r25 = r25 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0163, code lost:
        if (r25 != 0) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0165, code lost:
        r20 = r21;
        r16 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016b, code lost:
        r22 = r22 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x016e, code lost:
        if (r14 < 7) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0170, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0173, code lost:
        if (r15 < 7) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0175, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0177, code lost:
        if ((r2 | r4) == false) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0179, code lost:
        r20 = r21;
        r16 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x017f, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0182, code lost:
        r2 = f55assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0184, code lost:
        if (r22 >= 0) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0186, code lost:
        r22 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x00ee A[EDGE_INSN: B:126:0x00ee->B:54:0x00ee ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeHi(int r24, int r25, int r26, int r27) {
        /*
            r23 = this;
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x0019
            if (r25 <= 0) goto L_0x0017
            if (r27 <= 0) goto L_0x0017
            int r2 = r24 + r25
            r0 = r26
            if (r2 != r0) goto L_0x0017
            r2 = 1
        L_0x000f:
            if (r2 != 0) goto L_0x0019
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0017:
            r2 = 0
            goto L_0x000f
        L_0x0019:
            r0 = r23
            T[] r3 = r0.a
            r0 = r23
            r1 = r27
            java.lang.Object[] r9 = r0.ensureCapacity(r1)
            r0 = r23
            int r10 = r0.tmpBase
            r0 = r26
            r1 = r27
            java.lang.System.arraycopy((java.lang.Object) r3, (int) r0, (java.lang.Object) r9, (int) r10, (int) r1)
            int r2 = r24 + r25
            int r16 = r2 + -1
            int r2 = r10 + r27
            int r18 = r2 + -1
            int r2 = r26 + r27
            int r20 = r2 + -1
            int r21 = r20 + -1
            int r17 = r16 + -1
            r2 = r3[r16]
            r3[r20] = r2
            int r25 = r25 + -1
            if (r25 != 0) goto L_0x0052
            int r2 = r27 + -1
            int r2 = r21 - r2
            r0 = r27
            java.lang.System.arraycopy((java.lang.Object) r9, (int) r10, (java.lang.Object) r3, (int) r2, (int) r0)
            return
        L_0x0052:
            r2 = 1
            r0 = r27
            if (r0 != r2) goto L_0x0069
            int r20 = r21 - r25
            int r16 = r17 - r25
            int r2 = r16 + 1
            int r4 = r20 + 1
            r0 = r25
            java.lang.System.arraycopy((java.lang.Object) r3, (int) r2, (java.lang.Object) r3, (int) r4, (int) r0)
            r2 = r9[r18]
            r3[r20] = r2
            return
        L_0x0069:
            r0 = r23
            java.util.Comparator<? super T> r7 = r0.c
            r0 = r23
            int r0 = r0.minGallop
            r22 = r0
            r20 = r21
            r16 = r17
        L_0x0077:
            r14 = 0
            r15 = 0
        L_0x0079:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x008f
            if (r25 <= 0) goto L_0x008d
            r2 = 1
            r0 = r27
            if (r0 <= r2) goto L_0x008d
            r2 = 1
        L_0x0085:
            if (r2 != 0) goto L_0x008f
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x008d:
            r2 = 0
            goto L_0x0085
        L_0x008f:
            r2 = r9[r18]
            r4 = r3[r16]
            int r2 = r7.compare(r2, r4)
            if (r2 >= 0) goto L_0x00cd
            int r21 = r20 + -1
            int r17 = r16 + -1
            r2 = r3[r16]
            r3[r20] = r2
            int r14 = r14 + 1
            r15 = 0
            int r25 = r25 + -1
            if (r25 != 0) goto L_0x01e2
            r20 = r21
            r16 = r17
        L_0x00ac:
            r2 = 1
            r0 = r22
            if (r0 >= r2) goto L_0x00b3
            r22 = 1
        L_0x00b3:
            r0 = r22
            r1 = r23
            r1.minGallop = r0
            r2 = 1
            r0 = r27
            if (r0 != r2) goto L_0x01a5
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x0193
            if (r25 <= 0) goto L_0x0190
            r2 = 1
        L_0x00c5:
            if (r2 != 0) goto L_0x0193
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x00cd:
            int r21 = r20 + -1
            int r19 = r18 + -1
            r2 = r9[r18]
            r3[r20] = r2
            int r15 = r15 + 1
            r14 = 0
            int r27 = r27 + -1
            r2 = 1
            r0 = r27
            if (r0 != r2) goto L_0x00e4
            r20 = r21
            r18 = r19
            goto L_0x00ac
        L_0x00e4:
            r20 = r21
            r18 = r19
        L_0x00e8:
            r2 = r14 | r15
            r0 = r22
            if (r2 < r0) goto L_0x0079
        L_0x00ee:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x0104
            if (r25 <= 0) goto L_0x0102
            r2 = 1
            r0 = r27
            if (r0 <= r2) goto L_0x0102
            r2 = 1
        L_0x00fa:
            if (r2 != 0) goto L_0x0104
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0102:
            r2 = 0
            goto L_0x00fa
        L_0x0104:
            r2 = r9[r18]
            int r6 = r25 + -1
            r4 = r24
            r5 = r25
            int r2 = gallopRight(r2, r3, r4, r5, r6, r7)
            int r14 = r25 - r2
            if (r14 == 0) goto L_0x0123
            int r20 = r20 - r14
            int r16 = r16 - r14
            int r25 = r25 - r14
            int r2 = r16 + 1
            int r4 = r20 + 1
            java.lang.System.arraycopy((java.lang.Object) r3, (int) r2, (java.lang.Object) r3, (int) r4, (int) r14)
            if (r25 == 0) goto L_0x00ac
        L_0x0123:
            int r21 = r20 + -1
            int r19 = r18 + -1
            r2 = r9[r18]
            r3[r20] = r2
            int r27 = r27 + -1
            r2 = 1
            r0 = r27
            if (r0 != r2) goto L_0x0138
            r20 = r21
            r18 = r19
            goto L_0x00ac
        L_0x0138:
            r8 = r3[r16]
            int r12 = r27 + -1
            r11 = r27
            r13 = r7
            int r2 = gallopLeft(r8, r9, r10, r11, r12, r13)
            int r15 = r27 - r2
            if (r15 == 0) goto L_0x01dc
            int r20 = r21 - r15
            int r18 = r19 - r15
            int r27 = r27 - r15
            int r2 = r18 + 1
            int r4 = r20 + 1
            java.lang.System.arraycopy((java.lang.Object) r9, (int) r2, (java.lang.Object) r3, (int) r4, (int) r15)
            r2 = 1
            r0 = r27
            if (r0 <= r2) goto L_0x00ac
        L_0x0159:
            int r21 = r20 + -1
            int r17 = r16 + -1
            r2 = r3[r16]
            r3[r20] = r2
            int r25 = r25 + -1
            if (r25 != 0) goto L_0x016b
            r20 = r21
            r16 = r17
            goto L_0x00ac
        L_0x016b:
            int r22 = r22 + -1
            r2 = 7
            if (r14 < r2) goto L_0x017f
            r2 = 1
            r4 = r2
        L_0x0172:
            r2 = 7
            if (r15 < r2) goto L_0x0182
            r2 = 1
        L_0x0176:
            r2 = r2 | r4
            if (r2 == 0) goto L_0x0184
            r20 = r21
            r16 = r17
            goto L_0x00ee
        L_0x017f:
            r2 = 0
            r4 = r2
            goto L_0x0172
        L_0x0182:
            r2 = 0
            goto L_0x0176
        L_0x0184:
            if (r22 >= 0) goto L_0x0188
            r22 = 0
        L_0x0188:
            int r22 = r22 + 2
            r20 = r21
            r16 = r17
            goto L_0x0077
        L_0x0190:
            r2 = 0
            goto L_0x00c5
        L_0x0193:
            int r20 = r20 - r25
            int r16 = r16 - r25
            int r2 = r16 + 1
            int r4 = r20 + 1
            r0 = r25
            java.lang.System.arraycopy((java.lang.Object) r3, (int) r2, (java.lang.Object) r3, (int) r4, (int) r0)
            r2 = r9[r18]
            r3[r20] = r2
        L_0x01a4:
            return
        L_0x01a5:
            if (r27 != 0) goto L_0x01b0
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Comparison method violates its general contract!"
            r2.<init>((java.lang.String) r4)
            throw r2
        L_0x01b0:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x01c1
            if (r25 != 0) goto L_0x01bf
            r2 = 1
        L_0x01b7:
            if (r2 != 0) goto L_0x01c1
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x01bf:
            r2 = 0
            goto L_0x01b7
        L_0x01c1:
            boolean r2 = f55assertionsDisabled
            if (r2 != 0) goto L_0x01d2
            if (r27 <= 0) goto L_0x01d0
            r2 = 1
        L_0x01c8:
            if (r2 != 0) goto L_0x01d2
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x01d0:
            r2 = 0
            goto L_0x01c8
        L_0x01d2:
            int r2 = r27 + -1
            int r2 = r20 - r2
            r0 = r27
            java.lang.System.arraycopy((java.lang.Object) r9, (int) r10, (java.lang.Object) r3, (int) r2, (int) r0)
            goto L_0x01a4
        L_0x01dc:
            r20 = r21
            r18 = r19
            goto L_0x0159
        L_0x01e2:
            r20 = r21
            r16 = r17
            goto L_0x00e8
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimSort.mergeHi(int, int, int, int):void");
    }

    private T[] ensureCapacity(int minCapacity) {
        int newSize;
        if (this.tmpLen < minCapacity) {
            int i = minCapacity;
            int newSize2 = minCapacity | (minCapacity >> 1);
            int newSize3 = newSize2 | (newSize2 >> 2);
            int newSize4 = newSize3 | (newSize3 >> 4);
            int newSize5 = newSize4 | (newSize4 >> 8);
            int newSize6 = (newSize5 | (newSize5 >> 16)) + 1;
            if (newSize6 < 0) {
                newSize = minCapacity;
            } else {
                newSize = Math.min(newSize6, this.a.length >>> 1);
            }
            this.tmp = (Object[]) Array.newInstance(this.a.getClass().getComponentType(), newSize);
            this.tmpLen = newSize;
            this.tmpBase = 0;
        }
        return this.tmp;
    }
}
