package java.util;

class ComparableTimSort {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f38assertionsDisabled = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;
    private final Object[] a;
    private int minGallop = 7;
    private final int[] runBase;
    private final int[] runLen;
    private int stackSize = 0;
    private Object[] tmp;
    private int tmpBase;
    private int tmpLen;

    private ComparableTimSort(Object[] a2, Object[] work, int workBase, int workLen) {
        int stackLen;
        this.a = a2;
        int len = a2.length;
        int tlen = len < 512 ? len >>> 1 : 256;
        if (work == null || workLen < tlen || workBase + tlen > work.length) {
            this.tmp = new Object[tlen];
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

    static void sort(Object[] a2, int lo, int hi, Object[] work, int workBase, int workLen) {
        boolean z;
        boolean z2 = true;
        if (!f38assertionsDisabled) {
            if (!(a2 != null && lo >= 0 && lo <= hi && hi <= a2.length)) {
                throw new AssertionError();
            }
        }
        int nRemaining = hi - lo;
        if (nRemaining >= 2) {
            if (nRemaining < 32) {
                binarySort(a2, lo, hi, lo + countRunAndMakeAscending(a2, lo, hi));
                return;
            }
            ComparableTimSort ts = new ComparableTimSort(a2, work, workBase, workLen);
            int minRun = minRunLength(nRemaining);
            do {
                int runLen2 = countRunAndMakeAscending(a2, lo, hi);
                if (runLen2 < minRun) {
                    int force = nRemaining <= minRun ? nRemaining : minRun;
                    binarySort(a2, lo, lo + force, lo + runLen2);
                    runLen2 = force;
                }
                ts.pushRun(lo, runLen2);
                ts.mergeCollapse();
                lo += runLen2;
                nRemaining -= runLen2;
            } while (nRemaining != 0);
            if (!f38assertionsDisabled) {
                if (lo == hi) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            ts.mergeForceCollapse();
            if (!f38assertionsDisabled) {
                if (ts.stackSize != 1) {
                    z2 = false;
                }
                if (!z2) {
                    throw new AssertionError();
                }
            }
        }
    }

    private static void binarySort(Object[] a2, int lo, int hi, int start) {
        if (!f38assertionsDisabled) {
            if (!(lo <= start && start <= hi)) {
                throw new AssertionError();
            }
        }
        if (start == lo) {
            start++;
        }
        while (start < hi) {
            Comparable pivot = (Comparable) a2[start];
            int left = lo;
            int right = start;
            if (!f38assertionsDisabled) {
                if (!(lo <= right)) {
                    throw new AssertionError();
                }
            }
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (pivot.compareTo(a2[mid]) < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (!f38assertionsDisabled) {
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

    private static int countRunAndMakeAscending(Object[] a2, int lo, int hi) {
        int runHi;
        boolean z = f38assertionsDisabled;
        if (!f38assertionsDisabled) {
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
        if (a2[runHi2].compareTo(a2[lo]) < 0) {
            runHi = runHi3;
            while (runHi < hi && a2[runHi].compareTo(a2[runHi - 1]) < 0) {
                runHi++;
            }
            reverseRange(a2, lo, runHi);
        } else {
            int runHi4 = runHi3;
            while (runHi < hi && a2[runHi].compareTo(a2[runHi - 1]) >= 0) {
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
        boolean z = f38assertionsDisabled;
        if (!f38assertionsDisabled) {
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
        if (!f38assertionsDisabled) {
            if (!(this.stackSize >= 2)) {
                throw new AssertionError();
            }
        }
        if (!f38assertionsDisabled) {
            if (!(i >= 0)) {
                throw new AssertionError();
            }
        }
        if (!f38assertionsDisabled) {
            if (!(i == this.stackSize + -2 || i == this.stackSize + -3)) {
                throw new AssertionError();
            }
        }
        int base1 = this.runBase[i];
        int len1 = this.runLen[i];
        int base2 = this.runBase[i + 1];
        int len2 = this.runLen[i + 1];
        if (!f38assertionsDisabled) {
            if (!(len1 > 0 && len2 > 0)) {
                throw new AssertionError();
            }
        }
        if (!f38assertionsDisabled) {
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
        int k = gallopRight((Comparable) this.a[base2], this.a, base1, len1, 0);
        if (!f38assertionsDisabled) {
            if (!(k >= 0)) {
                throw new AssertionError();
            }
        }
        int base12 = base1 + k;
        int len12 = len1 - k;
        if (len12 != 0) {
            int len22 = gallopLeft((Comparable) this.a[(base12 + len12) - 1], this.a, base2, len2, len2 - 1);
            if (!f38assertionsDisabled) {
                if (!(len22 >= 0)) {
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

    private static int gallopLeft(Comparable<Object> key, Object[] a2, int base, int len, int hint) {
        int lastOfs;
        int ofs;
        boolean z;
        boolean z2 = true;
        if (!f38assertionsDisabled) {
            if (!(len > 0 && hint >= 0 && hint < len)) {
                throw new AssertionError();
            }
        }
        int lastOfs2 = 0;
        int ofs2 = 1;
        if (key.compareTo(a2[base + hint]) > 0) {
            int maxOfs = len - hint;
            while (ofs2 < maxOfs && key.compareTo(a2[base + hint + ofs2]) > 0) {
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
            while (ofs2 < maxOfs2 && key.compareTo(a2[(base + hint) - ofs2]) <= 0) {
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
        if (!f38assertionsDisabled) {
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
            if (key.compareTo(a2[base + m]) > 0) {
                lastOfs3 = m + 1;
            } else {
                ofs = m;
            }
        }
        if (!f38assertionsDisabled) {
            if (lastOfs3 != ofs) {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        return ofs;
    }

    private static int gallopRight(Comparable<Object> key, Object[] a2, int base, int len, int hint) {
        int lastOfs;
        int ofs;
        boolean z;
        boolean z2 = true;
        if (!f38assertionsDisabled) {
            if (!(len > 0 && hint >= 0 && hint < len)) {
                throw new AssertionError();
            }
        }
        int ofs2 = 1;
        int lastOfs2 = 0;
        if (key.compareTo(a2[base + hint]) < 0) {
            int maxOfs = hint + 1;
            while (ofs2 < maxOfs && key.compareTo(a2[(base + hint) - ofs2]) < 0) {
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
            while (ofs2 < maxOfs2 && key.compareTo(a2[base + hint + ofs2]) >= 0) {
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
        if (!f38assertionsDisabled) {
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
            if (key.compareTo(a2[base + m]) < 0) {
                ofs = m;
            } else {
                lastOfs3 = m + 1;
            }
        }
        if (!f38assertionsDisabled) {
            if (lastOfs3 != ofs) {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        return ofs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0187, code lost:
        r8 = r9;
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bc, code lost:
        if (f38assertionsDisabled != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c1, code lost:
        if (r16 <= 1) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c3, code lost:
        if (r18 <= 0) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c5, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c6, code lost:
        if (r12 != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00cd, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ce, code lost:
        r12 = f38assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d0, code lost:
        r2 = gallopRight((java.lang.Comparable) r1[r6], r11, r4, r16, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00db, code lost:
        if (r2 == 0) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00dd, code lost:
        java.lang.System.arraycopy((java.lang.Object) r11, r4, (java.lang.Object) r1, r8, r2);
        r8 = r8 + r2;
        r4 = r4 + r2;
        r16 = r16 - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e7, code lost:
        if (r16 <= 1) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e9, code lost:
        r9 = r8 + 1;
        r7 = r6 + 1;
        r1[r8] = r1[r6];
        r18 = r18 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00f3, code lost:
        if (r18 != 0) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f5, code lost:
        r8 = r9;
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f8, code lost:
        r3 = gallopLeft((java.lang.Comparable) r11[r4], r1, r7, r18, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0103, code lost:
        if (r3 == 0) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0105, code lost:
        java.lang.System.arraycopy((java.lang.Object) r1, r7, (java.lang.Object) r1, r9, r3);
        r8 = r9 + r3;
        r6 = r7 + r3;
        r18 = r18 - r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x010e, code lost:
        if (r18 == 0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0110, code lost:
        r9 = r8 + 1;
        r5 = r4 + 1;
        r1[r8] = r11[r4];
        r16 = r16 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x011d, code lost:
        if (r16 != 1) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011f, code lost:
        r8 = r9;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0123, code lost:
        r10 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0126, code lost:
        if (r2 < 7) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0128, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x012b, code lost:
        if (r3 < 7) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x012d, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x012f, code lost:
        if ((r12 | r13) == false) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0131, code lost:
        r8 = r9;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0134, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0137, code lost:
        r12 = f38assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0139, code lost:
        if (r10 >= 0) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x013b, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x00ba A[EDGE_INSN: B:127:0x00ba->B:54:0x00ba ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeLo(int r15, int r16, int r17, int r18) {
        /*
            r14 = this;
            boolean r12 = f38assertionsDisabled
            if (r12 != 0) goto L_0x0019
            if (r16 <= 0) goto L_0x0017
            if (r18 <= 0) goto L_0x0017
            int r12 = r15 + r16
            r0 = r17
            if (r12 != r0) goto L_0x0017
            r12 = 1
        L_0x000f:
            if (r12 != 0) goto L_0x0019
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x0017:
            r12 = 0
            goto L_0x000f
        L_0x0019:
            java.lang.Object[] r1 = r14.a
            r0 = r16
            java.lang.Object[] r11 = r14.ensureCapacity(r0)
            int r4 = r14.tmpBase
            r6 = r17
            r8 = r15
            r0 = r16
            java.lang.System.arraycopy((java.lang.Object) r1, (int) r15, (java.lang.Object) r11, (int) r4, (int) r0)
            int r8 = r15 + 1
            int r6 = r17 + 1
            r12 = r1[r17]
            r1[r15] = r12
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x003d
            r0 = r16
            java.lang.System.arraycopy((java.lang.Object) r11, (int) r4, (java.lang.Object) r1, (int) r8, (int) r0)
            return
        L_0x003d:
            r12 = 1
            r0 = r16
            if (r0 != r12) goto L_0x004e
            r0 = r18
            java.lang.System.arraycopy((java.lang.Object) r1, (int) r6, (java.lang.Object) r1, (int) r8, (int) r0)
            int r12 = r8 + r18
            r13 = r11[r4]
            r1[r12] = r13
            return
        L_0x004e:
            int r10 = r14.minGallop
        L_0x0050:
            r2 = 0
            r3 = 0
        L_0x0052:
            boolean r12 = f38assertionsDisabled
            if (r12 != 0) goto L_0x0068
            r12 = 1
            r0 = r16
            if (r0 <= r12) goto L_0x0066
            if (r18 <= 0) goto L_0x0066
            r12 = 1
        L_0x005e:
            if (r12 != 0) goto L_0x0068
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x0066:
            r12 = 0
            goto L_0x005e
        L_0x0068:
            r12 = r1[r6]
            java.lang.Comparable r12 = (java.lang.Comparable) r12
            r13 = r11[r4]
            int r12 = r12.compareTo(r13)
            if (r12 >= 0) goto L_0x009f
            int r9 = r8 + 1
            int r7 = r6 + 1
            r12 = r1[r6]
            r1[r8] = r12
            int r3 = r3 + 1
            r2 = 0
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x018a
            r8 = r9
            r6 = r7
        L_0x0085:
            r12 = 1
            if (r10 >= r12) goto L_0x0089
            r10 = 1
        L_0x0089:
            r14.minGallop = r10
            r12 = 1
            r0 = r16
            if (r0 != r12) goto L_0x0151
            boolean r12 = f38assertionsDisabled
            if (r12 != 0) goto L_0x0145
            if (r18 <= 0) goto L_0x0142
            r12 = 1
        L_0x0097:
            if (r12 != 0) goto L_0x0145
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x009f:
            int r9 = r8 + 1
            int r5 = r4 + 1
            r12 = r11[r4]
            r1[r8] = r12
            int r2 = r2 + 1
            r3 = 0
            int r16 = r16 + -1
            r12 = 1
            r0 = r16
            if (r0 != r12) goto L_0x00b4
            r8 = r9
            r4 = r5
            goto L_0x0085
        L_0x00b4:
            r8 = r9
            r4 = r5
        L_0x00b6:
            r12 = r2 | r3
            if (r12 < r10) goto L_0x0052
        L_0x00ba:
            boolean r12 = f38assertionsDisabled
            if (r12 != 0) goto L_0x00d0
            r12 = 1
            r0 = r16
            if (r0 <= r12) goto L_0x00ce
            if (r18 <= 0) goto L_0x00ce
            r12 = 1
        L_0x00c6:
            if (r12 != 0) goto L_0x00d0
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x00ce:
            r12 = 0
            goto L_0x00c6
        L_0x00d0:
            r12 = r1[r6]
            java.lang.Comparable r12 = (java.lang.Comparable) r12
            r13 = 0
            r0 = r16
            int r2 = gallopRight(r12, r11, r4, r0, r13)
            if (r2 == 0) goto L_0x00e9
            java.lang.System.arraycopy((java.lang.Object) r11, (int) r4, (java.lang.Object) r1, (int) r8, (int) r2)
            int r8 = r8 + r2
            int r4 = r4 + r2
            int r16 = r16 - r2
            r12 = 1
            r0 = r16
            if (r0 <= r12) goto L_0x0085
        L_0x00e9:
            int r9 = r8 + 1
            int r7 = r6 + 1
            r12 = r1[r6]
            r1[r8] = r12
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x00f8
            r8 = r9
            r6 = r7
            goto L_0x0085
        L_0x00f8:
            r12 = r11[r4]
            java.lang.Comparable r12 = (java.lang.Comparable) r12
            r13 = 0
            r0 = r18
            int r3 = gallopLeft(r12, r1, r7, r0, r13)
            if (r3 == 0) goto L_0x0187
            java.lang.System.arraycopy((java.lang.Object) r1, (int) r7, (java.lang.Object) r1, (int) r9, (int) r3)
            int r8 = r9 + r3
            int r6 = r7 + r3
            int r18 = r18 - r3
            if (r18 == 0) goto L_0x0085
        L_0x0110:
            int r9 = r8 + 1
            int r5 = r4 + 1
            r12 = r11[r4]
            r1[r8] = r12
            int r16 = r16 + -1
            r12 = 1
            r0 = r16
            if (r0 != r12) goto L_0x0123
            r8 = r9
            r4 = r5
            goto L_0x0085
        L_0x0123:
            int r10 = r10 + -1
            r12 = 7
            if (r2 < r12) goto L_0x0134
            r12 = 1
            r13 = r12
        L_0x012a:
            r12 = 7
            if (r3 < r12) goto L_0x0137
            r12 = 1
        L_0x012e:
            r12 = r12 | r13
            if (r12 == 0) goto L_0x0139
            r8 = r9
            r4 = r5
            goto L_0x00ba
        L_0x0134:
            r12 = 0
            r13 = r12
            goto L_0x012a
        L_0x0137:
            r12 = 0
            goto L_0x012e
        L_0x0139:
            if (r10 >= 0) goto L_0x013c
            r10 = 0
        L_0x013c:
            int r10 = r10 + 2
            r8 = r9
            r4 = r5
            goto L_0x0050
        L_0x0142:
            r12 = 0
            goto L_0x0097
        L_0x0145:
            r0 = r18
            java.lang.System.arraycopy((java.lang.Object) r1, (int) r6, (java.lang.Object) r1, (int) r8, (int) r0)
            int r12 = r8 + r18
            r13 = r11[r4]
            r1[r12] = r13
        L_0x0150:
            return
        L_0x0151:
            if (r16 != 0) goto L_0x015c
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Comparison method violates its general contract!"
            r12.<init>((java.lang.String) r13)
            throw r12
        L_0x015c:
            boolean r12 = f38assertionsDisabled
            if (r12 != 0) goto L_0x016d
            if (r18 != 0) goto L_0x016b
            r12 = 1
        L_0x0163:
            if (r12 != 0) goto L_0x016d
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x016b:
            r12 = 0
            goto L_0x0163
        L_0x016d:
            boolean r12 = f38assertionsDisabled
            if (r12 != 0) goto L_0x0181
            r12 = 1
            r0 = r16
            if (r0 <= r12) goto L_0x017f
            r12 = 1
        L_0x0177:
            if (r12 != 0) goto L_0x0181
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x017f:
            r12 = 0
            goto L_0x0177
        L_0x0181:
            r0 = r16
            java.lang.System.arraycopy((java.lang.Object) r11, (int) r4, (java.lang.Object) r1, (int) r8, (int) r0)
            goto L_0x0150
        L_0x0187:
            r8 = r9
            r6 = r7
            goto L_0x0110
        L_0x018a:
            r8 = r9
            r6 = r7
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ComparableTimSort.mergeLo(int, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01c0, code lost:
        r9 = r10;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00dd, code lost:
        if (f38assertionsDisabled != false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00df, code lost:
        if (r18 <= 0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e4, code lost:
        if (r20 <= 1) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e6, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e7, code lost:
        if (r14 != false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ee, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ef, code lost:
        r14 = f38assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f1, code lost:
        r3 = r18 - gallopRight((java.lang.Comparable) r12[r7], r2, r17, r18, r18 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0101, code lost:
        if (r3 == 0) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0103, code lost:
        r9 = r9 - r3;
        r5 = r5 - r3;
        r18 = r18 - r3;
        java.lang.System.arraycopy((java.lang.Object) r2, r5 + 1, (java.lang.Object) r2, r9 + 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010e, code lost:
        if (r18 == 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0110, code lost:
        r10 = r9 - 1;
        r8 = r7 - 1;
        r2[r9] = r12[r7];
        r20 = r20 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011d, code lost:
        if (r20 != 1) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x011f, code lost:
        r9 = r10;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0122, code lost:
        r4 = r20 - gallopLeft((java.lang.Comparable) r2[r5], r12, r13, r20, r20 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0130, code lost:
        if (r4 == 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0132, code lost:
        r9 = r10 - r4;
        r7 = r8 - r4;
        r20 = r20 - r4;
        java.lang.System.arraycopy((java.lang.Object) r12, r7 + 1, (java.lang.Object) r2, r9 + 1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0142, code lost:
        if (r20 <= 1) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0144, code lost:
        r10 = r9 - 1;
        r6 = r5 - 1;
        r2[r9] = r2[r5];
        r18 = r18 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014e, code lost:
        if (r18 != 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0150, code lost:
        r9 = r10;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0154, code lost:
        r11 = r11 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0157, code lost:
        if (r3 < 7) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0159, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x015c, code lost:
        if (r4 < 7) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x015e, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0160, code lost:
        if ((r14 | r15) == false) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0162, code lost:
        r9 = r10;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0166, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0169, code lost:
        r14 = f38assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x016b, code lost:
        if (r11 >= 0) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x016d, code lost:
        r11 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x00db A[EDGE_INSN: B:126:0x00db->B:54:0x00db ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeHi(int r17, int r18, int r19, int r20) {
        /*
            r16 = this;
            boolean r14 = f38assertionsDisabled
            if (r14 != 0) goto L_0x0019
            if (r18 <= 0) goto L_0x0017
            if (r20 <= 0) goto L_0x0017
            int r14 = r17 + r18
            r0 = r19
            if (r14 != r0) goto L_0x0017
            r14 = 1
        L_0x000f:
            if (r14 != 0) goto L_0x0019
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>()
            throw r14
        L_0x0017:
            r14 = 0
            goto L_0x000f
        L_0x0019:
            r0 = r16
            java.lang.Object[] r2 = r0.a
            r0 = r16
            r1 = r20
            java.lang.Object[] r12 = r0.ensureCapacity(r1)
            r0 = r16
            int r13 = r0.tmpBase
            r0 = r19
            r1 = r20
            java.lang.System.arraycopy((java.lang.Object) r2, (int) r0, (java.lang.Object) r12, (int) r13, (int) r1)
            int r14 = r17 + r18
            int r5 = r14 + -1
            int r14 = r13 + r20
            int r7 = r14 + -1
            int r14 = r19 + r20
            int r9 = r14 + -1
            int r10 = r9 + -1
            int r6 = r5 + -1
            r14 = r2[r5]
            r2[r9] = r14
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x0052
            int r14 = r20 + -1
            int r14 = r10 - r14
            r0 = r20
            java.lang.System.arraycopy((java.lang.Object) r12, (int) r13, (java.lang.Object) r2, (int) r14, (int) r0)
            return
        L_0x0052:
            r14 = 1
            r0 = r20
            if (r0 != r14) goto L_0x0069
            int r9 = r10 - r18
            int r5 = r6 - r18
            int r14 = r5 + 1
            int r15 = r9 + 1
            r0 = r18
            java.lang.System.arraycopy((java.lang.Object) r2, (int) r14, (java.lang.Object) r2, (int) r15, (int) r0)
            r14 = r12[r7]
            r2[r9] = r14
            return
        L_0x0069:
            r0 = r16
            int r11 = r0.minGallop
            r9 = r10
            r5 = r6
        L_0x006f:
            r3 = 0
            r4 = 0
        L_0x0071:
            boolean r14 = f38assertionsDisabled
            if (r14 != 0) goto L_0x0087
            if (r18 <= 0) goto L_0x0085
            r14 = 1
            r0 = r20
            if (r0 <= r14) goto L_0x0085
            r14 = 1
        L_0x007d:
            if (r14 != 0) goto L_0x0087
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>()
            throw r14
        L_0x0085:
            r14 = 0
            goto L_0x007d
        L_0x0087:
            r14 = r12[r7]
            java.lang.Comparable r14 = (java.lang.Comparable) r14
            r15 = r2[r5]
            int r14 = r14.compareTo(r15)
            if (r14 >= 0) goto L_0x00c0
            int r10 = r9 + -1
            int r6 = r5 + -1
            r14 = r2[r5]
            r2[r9] = r14
            int r3 = r3 + 1
            r4 = 0
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x01c3
            r9 = r10
            r5 = r6
        L_0x00a4:
            r14 = 1
            if (r11 >= r14) goto L_0x00a8
            r11 = 1
        L_0x00a8:
            r0 = r16
            r0.minGallop = r11
            r14 = 1
            r0 = r20
            if (r0 != r14) goto L_0x0189
            boolean r14 = f38assertionsDisabled
            if (r14 != 0) goto L_0x0177
            if (r18 <= 0) goto L_0x0174
            r14 = 1
        L_0x00b8:
            if (r14 != 0) goto L_0x0177
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>()
            throw r14
        L_0x00c0:
            int r10 = r9 + -1
            int r8 = r7 + -1
            r14 = r12[r7]
            r2[r9] = r14
            int r4 = r4 + 1
            r3 = 0
            int r20 = r20 + -1
            r14 = 1
            r0 = r20
            if (r0 != r14) goto L_0x00d5
            r9 = r10
            r7 = r8
            goto L_0x00a4
        L_0x00d5:
            r9 = r10
            r7 = r8
        L_0x00d7:
            r14 = r3 | r4
            if (r14 < r11) goto L_0x0071
        L_0x00db:
            boolean r14 = f38assertionsDisabled
            if (r14 != 0) goto L_0x00f1
            if (r18 <= 0) goto L_0x00ef
            r14 = 1
            r0 = r20
            if (r0 <= r14) goto L_0x00ef
            r14 = 1
        L_0x00e7:
            if (r14 != 0) goto L_0x00f1
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>()
            throw r14
        L_0x00ef:
            r14 = 0
            goto L_0x00e7
        L_0x00f1:
            r14 = r12[r7]
            java.lang.Comparable r14 = (java.lang.Comparable) r14
            int r15 = r18 + -1
            r0 = r17
            r1 = r18
            int r14 = gallopRight(r14, r2, r0, r1, r15)
            int r3 = r18 - r14
            if (r3 == 0) goto L_0x0110
            int r9 = r9 - r3
            int r5 = r5 - r3
            int r18 = r18 - r3
            int r14 = r5 + 1
            int r15 = r9 + 1
            java.lang.System.arraycopy((java.lang.Object) r2, (int) r14, (java.lang.Object) r2, (int) r15, (int) r3)
            if (r18 == 0) goto L_0x00a4
        L_0x0110:
            int r10 = r9 + -1
            int r8 = r7 + -1
            r14 = r12[r7]
            r2[r9] = r14
            int r20 = r20 + -1
            r14 = 1
            r0 = r20
            if (r0 != r14) goto L_0x0122
            r9 = r10
            r7 = r8
            goto L_0x00a4
        L_0x0122:
            r14 = r2[r5]
            java.lang.Comparable r14 = (java.lang.Comparable) r14
            int r15 = r20 + -1
            r0 = r20
            int r14 = gallopLeft(r14, r12, r13, r0, r15)
            int r4 = r20 - r14
            if (r4 == 0) goto L_0x01c0
            int r9 = r10 - r4
            int r7 = r8 - r4
            int r20 = r20 - r4
            int r14 = r7 + 1
            int r15 = r9 + 1
            java.lang.System.arraycopy((java.lang.Object) r12, (int) r14, (java.lang.Object) r2, (int) r15, (int) r4)
            r14 = 1
            r0 = r20
            if (r0 <= r14) goto L_0x00a4
        L_0x0144:
            int r10 = r9 + -1
            int r6 = r5 + -1
            r14 = r2[r5]
            r2[r9] = r14
            int r18 = r18 + -1
            if (r18 != 0) goto L_0x0154
            r9 = r10
            r5 = r6
            goto L_0x00a4
        L_0x0154:
            int r11 = r11 + -1
            r14 = 7
            if (r3 < r14) goto L_0x0166
            r14 = 1
            r15 = r14
        L_0x015b:
            r14 = 7
            if (r4 < r14) goto L_0x0169
            r14 = 1
        L_0x015f:
            r14 = r14 | r15
            if (r14 == 0) goto L_0x016b
            r9 = r10
            r5 = r6
            goto L_0x00db
        L_0x0166:
            r14 = 0
            r15 = r14
            goto L_0x015b
        L_0x0169:
            r14 = 0
            goto L_0x015f
        L_0x016b:
            if (r11 >= 0) goto L_0x016e
            r11 = 0
        L_0x016e:
            int r11 = r11 + 2
            r9 = r10
            r5 = r6
            goto L_0x006f
        L_0x0174:
            r14 = 0
            goto L_0x00b8
        L_0x0177:
            int r9 = r9 - r18
            int r5 = r5 - r18
            int r14 = r5 + 1
            int r15 = r9 + 1
            r0 = r18
            java.lang.System.arraycopy((java.lang.Object) r2, (int) r14, (java.lang.Object) r2, (int) r15, (int) r0)
            r14 = r12[r7]
            r2[r9] = r14
        L_0x0188:
            return
        L_0x0189:
            if (r20 != 0) goto L_0x0194
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "Comparison method violates its general contract!"
            r14.<init>((java.lang.String) r15)
            throw r14
        L_0x0194:
            boolean r14 = f38assertionsDisabled
            if (r14 != 0) goto L_0x01a5
            if (r18 != 0) goto L_0x01a3
            r14 = 1
        L_0x019b:
            if (r14 != 0) goto L_0x01a5
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>()
            throw r14
        L_0x01a3:
            r14 = 0
            goto L_0x019b
        L_0x01a5:
            boolean r14 = f38assertionsDisabled
            if (r14 != 0) goto L_0x01b6
            if (r20 <= 0) goto L_0x01b4
            r14 = 1
        L_0x01ac:
            if (r14 != 0) goto L_0x01b6
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>()
            throw r14
        L_0x01b4:
            r14 = 0
            goto L_0x01ac
        L_0x01b6:
            int r14 = r20 + -1
            int r14 = r9 - r14
            r0 = r20
            java.lang.System.arraycopy((java.lang.Object) r12, (int) r13, (java.lang.Object) r2, (int) r14, (int) r0)
            goto L_0x0188
        L_0x01c0:
            r9 = r10
            r7 = r8
            goto L_0x0144
        L_0x01c3:
            r9 = r10
            r5 = r6
            goto L_0x00d7
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ComparableTimSort.mergeHi(int, int, int, int):void");
    }

    private Object[] ensureCapacity(int minCapacity) {
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
            this.tmp = new Object[newSize];
            this.tmpLen = newSize;
            this.tmpBase = 0;
        }
        return this.tmp;
    }
}
