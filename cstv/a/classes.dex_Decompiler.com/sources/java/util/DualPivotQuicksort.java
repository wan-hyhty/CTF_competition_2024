package java.util;

final class DualPivotQuicksort {
    private static final int COUNTING_SORT_THRESHOLD_FOR_BYTE = 29;
    private static final int COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR = 3200;
    private static final int INSERTION_SORT_THRESHOLD = 47;
    private static final int MAX_RUN_COUNT = 67;
    private static final int MAX_RUN_LENGTH = 33;
    private static final int NUM_BYTE_VALUES = 256;
    private static final int NUM_CHAR_VALUES = 65536;
    private static final int NUM_SHORT_VALUES = 65536;
    private static final int QUICKSORT_THRESHOLD = 286;

    private DualPivotQuicksort() {
    }

    static void sort(int[] a, int left, int right, int[] work, int workBase, int workLen) {
        int bo;
        int[] b;
        int ao;
        int q;
        int p;
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
        int[] run = new int[68];
        int count = 0;
        run[0] = left;
        int k = left;
        while (k < right) {
            if (a[k] >= a[k + 1]) {
                if (a[k] <= a[k + 1]) {
                    int m = MAX_RUN_LENGTH;
                    while (true) {
                        k++;
                        if (k > right || a[k - 1] != a[k]) {
                            break;
                        }
                        m--;
                        if (m == 0) {
                            sort(a, left, right, true);
                            return;
                        }
                    }
                } else {
                    do {
                        k++;
                        if (k > right || a[k - 1] < a[k]) {
                            int lo = run[count] - 1;
                            int hi = k;
                        }
                        k++;
                        break;
                    } while (a[k - 1] < a[k]);
                    int lo2 = run[count] - 1;
                    int hi2 = k;
                    while (true) {
                        lo2++;
                        hi2--;
                        if (lo2 >= hi2) {
                            break;
                        }
                        int t = a[lo2];
                        a[lo2] = a[hi2];
                        a[hi2] = t;
                    }
                }
            } else {
                do {
                    k++;
                    if (k > right) {
                        break;
                    }
                } while (a[k - 1] > a[k]);
            }
            count++;
            if (count == MAX_RUN_COUNT) {
                sort(a, left, right, true);
                return;
            }
            run[count] = k;
        }
        int right2 = right + 1;
        if (run[count] == right) {
            count++;
            run[count] = right2;
        } else if (count == 1) {
            return;
        }
        byte odd = 0;
        int n = 1;
        while (true) {
            n <<= 1;
            if (n >= count) {
                break;
            }
            odd = (byte) (odd ^ 1);
        }
        int blen = right2 - left;
        if (work == null || workLen < blen || workBase + blen > work.length) {
            work = new int[blen];
            workBase = 0;
        }
        if (odd == 0) {
            System.arraycopy(a, left, work, workBase, blen);
            b = a;
            bo = 0;
            a = work;
            ao = workBase - left;
        } else {
            b = work;
            ao = 0;
            bo = workBase - left;
        }
        while (count > 1) {
            int last = 0;
            for (int k2 = 2; k2 <= count; k2 += 2) {
                int hi3 = run[k2];
                int mi = run[k2 - 1];
                int i = run[k2 - 2];
                int q2 = mi;
                int p2 = i;
                while (i < hi3) {
                    if (q2 >= hi3 || (p2 < mi && a[p2 + ao] <= a[q2 + ao])) {
                        p = p2 + 1;
                        b[i + bo] = a[p2 + ao];
                        q = q2;
                    } else {
                        q = q2 + 1;
                        b[i + bo] = a[q2 + ao];
                        p = p2;
                    }
                    i++;
                    q2 = q;
                    p2 = p;
                }
                last++;
                run[last] = hi3;
            }
            if ((count & 1) != 0) {
                int i2 = right2;
                int lo3 = run[count - 1];
                while (true) {
                    i2--;
                    if (i2 < lo3) {
                        break;
                    }
                    b[i2 + bo] = a[i2 + ao];
                }
                last++;
                run[last] = right2;
            }
            int[] t2 = a;
            a = b;
            b = t2;
            int o = ao;
            ao = bo;
            bo = o;
            count = last;
        }
    }

    private static void sort(int[] a, int left, int right, boolean leftmost) {
        int length = (right - left) + 1;
        if (length >= INSERTION_SORT_THRESHOLD) {
            int seventh = (length >> 3) + (length >> 6) + 1;
            int e3 = (left + right) >>> 1;
            int e2 = e3 - seventh;
            int e1 = e2 - seventh;
            int e4 = e3 + seventh;
            int e5 = e4 + seventh;
            if (a[e2] < a[e1]) {
                int t = a[e2];
                a[e2] = a[e1];
                a[e1] = t;
            }
            if (a[e3] < a[e2]) {
                int t2 = a[e3];
                a[e3] = a[e2];
                a[e2] = t2;
                if (t2 < a[e1]) {
                    a[e2] = a[e1];
                    a[e1] = t2;
                }
            }
            if (a[e4] < a[e3]) {
                int t3 = a[e4];
                a[e4] = a[e3];
                a[e3] = t3;
                if (t3 < a[e2]) {
                    a[e3] = a[e2];
                    a[e2] = t3;
                    if (t3 < a[e1]) {
                        a[e2] = a[e1];
                        a[e1] = t3;
                    }
                }
            }
            if (a[e5] < a[e4]) {
                int t4 = a[e5];
                a[e5] = a[e4];
                a[e4] = t4;
                if (t4 < a[e3]) {
                    a[e4] = a[e3];
                    a[e3] = t4;
                    if (t4 < a[e2]) {
                        a[e3] = a[e2];
                        a[e2] = t4;
                        if (t4 < a[e1]) {
                            a[e2] = a[e1];
                            a[e1] = t4;
                        }
                    }
                }
            }
            int less = left;
            int great = right;
            if (a[e1] == a[e2] || a[e2] == a[e3] || a[e3] == a[e4] || a[e4] == a[e5]) {
                int pivot = a[e3];
                for (int k = left; k <= great; k++) {
                    if (a[k] != pivot) {
                        int ak = a[k];
                        if (ak < pivot) {
                            a[k] = a[less];
                            a[less] = ak;
                            less++;
                        } else {
                            while (a[great] > pivot) {
                                great--;
                            }
                            if (a[great] < pivot) {
                                a[k] = a[less];
                                a[less] = a[great];
                                less++;
                            } else {
                                a[k] = pivot;
                            }
                            a[great] = ak;
                            great--;
                        }
                    }
                }
                sort(a, left, less - 1, leftmost);
                sort(a, great + 1, right, false);
                return;
            }
            int pivot1 = a[e2];
            int pivot2 = a[e4];
            a[e2] = a[left];
            a[e4] = a[right];
            do {
                less++;
            } while (a[less] < pivot1);
            do {
                great--;
            } while (a[great] > pivot2);
            int k2 = less - 1;
            loop9:
            while (true) {
                k2++;
                if (k2 > great) {
                    break;
                }
                int ak2 = a[k2];
                if (ak2 < pivot1) {
                    a[k2] = a[less];
                    a[less] = ak2;
                    less++;
                } else if (ak2 > pivot2) {
                    while (a[great] > pivot2) {
                        int great2 = great - 1;
                        if (great == k2) {
                            great = great2;
                            break loop9;
                        }
                        great = great2;
                    }
                    if (a[great] < pivot1) {
                        a[k2] = a[less];
                        a[less] = a[great];
                        less++;
                    } else {
                        a[k2] = a[great];
                    }
                    a[great] = ak2;
                    great--;
                } else {
                    continue;
                }
            }
            a[left] = a[less - 1];
            a[less - 1] = pivot1;
            a[right] = a[great + 1];
            a[great + 1] = pivot2;
            sort(a, left, less - 2, leftmost);
            sort(a, great + 2, right, false);
            if (less < e1 && e5 < great) {
                while (a[less] == pivot1) {
                    less++;
                }
                while (a[great] == pivot2) {
                    great--;
                }
                int k3 = less - 1;
                loop13:
                while (true) {
                    k3++;
                    if (k3 > great) {
                        break;
                    }
                    int ak3 = a[k3];
                    if (ak3 == pivot1) {
                        a[k3] = a[less];
                        a[less] = ak3;
                        less++;
                    } else if (ak3 == pivot2) {
                        while (a[great] == pivot2) {
                            int great3 = great - 1;
                            if (great == k3) {
                                great = great3;
                                break loop13;
                            }
                            great = great3;
                        }
                        if (a[great] == pivot1) {
                            a[k3] = a[less];
                            a[less] = pivot1;
                            less++;
                        } else {
                            a[k3] = a[great];
                        }
                        a[great] = ak3;
                        great--;
                    } else {
                        continue;
                    }
                }
            }
            sort(a, less, great, false);
        } else if (leftmost) {
            int i = left;
            int j = left;
            while (i < right) {
                int ai = a[i + 1];
                while (true) {
                    if (ai >= a[j]) {
                        break;
                    }
                    a[j + 1] = a[j];
                    int j2 = j - 1;
                    if (j == left) {
                        j = j2;
                        break;
                    }
                    j = j2;
                }
                a[j + 1] = ai;
                i++;
                j = i;
            }
        } else {
            while (left < right) {
                left++;
                if (a[left] < a[left - 1]) {
                    while (true) {
                        int k4 = left;
                        int left2 = left + 1;
                        if (left2 > right) {
                            break;
                        }
                        int a1 = a[k4];
                        int a2 = a[left2];
                        if (a1 < a2) {
                            a2 = a1;
                            a1 = a[left2];
                        }
                        while (true) {
                            k4--;
                            if (a1 >= a[k4]) {
                                break;
                            }
                            a[k4 + 2] = a[k4];
                        }
                        int k5 = k4 + 1;
                        a[k5 + 1] = a1;
                        while (true) {
                            k5--;
                            if (a2 >= a[k5]) {
                                break;
                            }
                            a[k5 + 1] = a[k5];
                        }
                        a[k5 + 1] = a2;
                        left = left2 + 1;
                    }
                    int last = a[right];
                    while (true) {
                        right--;
                        if (last < a[right]) {
                            a[right + 1] = a[right];
                        } else {
                            a[right + 1] = last;
                            return;
                        }
                    }
                }
            }
        }
    }

    static void sort(long[] a, int left, int right, long[] work, int workBase, int workLen) {
        int bo;
        long[] b;
        int ao;
        int q;
        int p;
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
        int[] run = new int[68];
        int count = 0;
        run[0] = left;
        int k = left;
        while (k < right) {
            if (a[k] >= a[k + 1]) {
                if (a[k] <= a[k + 1]) {
                    int m = MAX_RUN_LENGTH;
                    while (true) {
                        k++;
                        if (k > right || a[k - 1] != a[k]) {
                            break;
                        }
                        m--;
                        if (m == 0) {
                            sort(a, left, right, true);
                            return;
                        }
                    }
                } else {
                    do {
                        k++;
                        if (k > right || a[k - 1] < a[k]) {
                            int lo = run[count] - 1;
                            int hi = k;
                        }
                        k++;
                        break;
                    } while (a[k - 1] < a[k]);
                    int lo2 = run[count] - 1;
                    int hi2 = k;
                    while (true) {
                        lo2++;
                        hi2--;
                        if (lo2 >= hi2) {
                            break;
                        }
                        long t = a[lo2];
                        a[lo2] = a[hi2];
                        a[hi2] = t;
                    }
                }
            } else {
                do {
                    k++;
                    if (k > right) {
                        break;
                    }
                } while (a[k - 1] > a[k]);
            }
            count++;
            if (count == MAX_RUN_COUNT) {
                sort(a, left, right, true);
                return;
            }
            run[count] = k;
        }
        int right2 = right + 1;
        if (run[count] == right) {
            count++;
            run[count] = right2;
        } else if (count == 1) {
            return;
        }
        byte odd = 0;
        int n = 1;
        while (true) {
            n <<= 1;
            if (n >= count) {
                break;
            }
            odd = (byte) (odd ^ 1);
        }
        int blen = right2 - left;
        if (work == null || workLen < blen || workBase + blen > work.length) {
            work = new long[blen];
            workBase = 0;
        }
        if (odd == 0) {
            System.arraycopy(a, left, work, workBase, blen);
            b = a;
            bo = 0;
            a = work;
            ao = workBase - left;
        } else {
            b = work;
            ao = 0;
            bo = workBase - left;
        }
        while (count > 1) {
            int last = 0;
            for (int k2 = 2; k2 <= count; k2 += 2) {
                int hi3 = run[k2];
                int mi = run[k2 - 1];
                int i = run[k2 - 2];
                int q2 = mi;
                int p2 = i;
                while (i < hi3) {
                    if (q2 >= hi3 || (p2 < mi && a[p2 + ao] <= a[q2 + ao])) {
                        p = p2 + 1;
                        b[i + bo] = a[p2 + ao];
                        q = q2;
                    } else {
                        q = q2 + 1;
                        b[i + bo] = a[q2 + ao];
                        p = p2;
                    }
                    i++;
                    q2 = q;
                    p2 = p;
                }
                last++;
                run[last] = hi3;
            }
            if ((count & 1) != 0) {
                int i2 = right2;
                int lo3 = run[count - 1];
                while (true) {
                    i2--;
                    if (i2 < lo3) {
                        break;
                    }
                    b[i2 + bo] = a[i2 + ao];
                }
                last++;
                run[last] = right2;
            }
            long[] t2 = a;
            a = b;
            b = t2;
            int o = ao;
            ao = bo;
            bo = o;
            count = last;
        }
    }

    private static void sort(long[] a, int left, int right, boolean leftmost) {
        int length = (right - left) + 1;
        if (length >= INSERTION_SORT_THRESHOLD) {
            int seventh = (length >> 3) + (length >> 6) + 1;
            int e3 = (left + right) >>> 1;
            int e2 = e3 - seventh;
            int e1 = e2 - seventh;
            int e4 = e3 + seventh;
            int e5 = e4 + seventh;
            if (a[e2] < a[e1]) {
                long t = a[e2];
                a[e2] = a[e1];
                a[e1] = t;
            }
            if (a[e3] < a[e2]) {
                long t2 = a[e3];
                a[e3] = a[e2];
                a[e2] = t2;
                if (t2 < a[e1]) {
                    a[e2] = a[e1];
                    a[e1] = t2;
                }
            }
            if (a[e4] < a[e3]) {
                long t3 = a[e4];
                a[e4] = a[e3];
                a[e3] = t3;
                if (t3 < a[e2]) {
                    a[e3] = a[e2];
                    a[e2] = t3;
                    if (t3 < a[e1]) {
                        a[e2] = a[e1];
                        a[e1] = t3;
                    }
                }
            }
            if (a[e5] < a[e4]) {
                long t4 = a[e5];
                a[e5] = a[e4];
                a[e4] = t4;
                if (t4 < a[e3]) {
                    a[e4] = a[e3];
                    a[e3] = t4;
                    if (t4 < a[e2]) {
                        a[e3] = a[e2];
                        a[e2] = t4;
                        if (t4 < a[e1]) {
                            a[e2] = a[e1];
                            a[e1] = t4;
                        }
                    }
                }
            }
            int less = left;
            int great = right;
            if (a[e1] == a[e2] || a[e2] == a[e3] || a[e3] == a[e4] || a[e4] == a[e5]) {
                long pivot = a[e3];
                for (int k = left; k <= great; k++) {
                    if (a[k] != pivot) {
                        long ak = a[k];
                        if (ak < pivot) {
                            a[k] = a[less];
                            a[less] = ak;
                            less++;
                        } else {
                            while (a[great] > pivot) {
                                great--;
                            }
                            if (a[great] < pivot) {
                                a[k] = a[less];
                                a[less] = a[great];
                                less++;
                            } else {
                                a[k] = pivot;
                            }
                            a[great] = ak;
                            great--;
                        }
                    }
                }
                sort(a, left, less - 1, leftmost);
                sort(a, great + 1, right, false);
                return;
            }
            long pivot1 = a[e2];
            long pivot2 = a[e4];
            a[e2] = a[left];
            a[e4] = a[right];
            do {
                less++;
            } while (a[less] < pivot1);
            do {
                great--;
            } while (a[great] > pivot2);
            int k2 = less - 1;
            loop9:
            while (true) {
                k2++;
                if (k2 > great) {
                    break;
                }
                long ak2 = a[k2];
                if (ak2 < pivot1) {
                    a[k2] = a[less];
                    a[less] = ak2;
                    less++;
                } else if (ak2 > pivot2) {
                    while (a[great] > pivot2) {
                        int great2 = great - 1;
                        if (great == k2) {
                            great = great2;
                            break loop9;
                        }
                        great = great2;
                    }
                    if (a[great] < pivot1) {
                        a[k2] = a[less];
                        a[less] = a[great];
                        less++;
                    } else {
                        a[k2] = a[great];
                    }
                    a[great] = ak2;
                    great--;
                } else {
                    continue;
                }
            }
            a[left] = a[less - 1];
            a[less - 1] = pivot1;
            a[right] = a[great + 1];
            a[great + 1] = pivot2;
            sort(a, left, less - 2, leftmost);
            sort(a, great + 2, right, false);
            if (less < e1 && e5 < great) {
                while (a[less] == pivot1) {
                    less++;
                }
                while (a[great] == pivot2) {
                    great--;
                }
                int k3 = less - 1;
                loop13:
                while (true) {
                    k3++;
                    if (k3 > great) {
                        break;
                    }
                    long ak3 = a[k3];
                    if (ak3 == pivot1) {
                        a[k3] = a[less];
                        a[less] = ak3;
                        less++;
                    } else if (ak3 == pivot2) {
                        while (a[great] == pivot2) {
                            int great3 = great - 1;
                            if (great == k3) {
                                great = great3;
                                break loop13;
                            }
                            great = great3;
                        }
                        if (a[great] == pivot1) {
                            a[k3] = a[less];
                            a[less] = pivot1;
                            less++;
                        } else {
                            a[k3] = a[great];
                        }
                        a[great] = ak3;
                        great--;
                    } else {
                        continue;
                    }
                }
            }
            sort(a, less, great, false);
        } else if (leftmost) {
            int i = left;
            int j = left;
            while (i < right) {
                long ai = a[i + 1];
                while (true) {
                    if (ai >= a[j]) {
                        break;
                    }
                    a[j + 1] = a[j];
                    int j2 = j - 1;
                    if (j == left) {
                        j = j2;
                        break;
                    }
                    j = j2;
                }
                a[j + 1] = ai;
                i++;
                j = i;
            }
        } else {
            while (left < right) {
                left++;
                if (a[left] < a[left - 1]) {
                    while (true) {
                        int k4 = left;
                        int left2 = left + 1;
                        if (left2 > right) {
                            break;
                        }
                        long a1 = a[k4];
                        long a2 = a[left2];
                        if (a1 < a2) {
                            a2 = a1;
                            a1 = a[left2];
                        }
                        while (true) {
                            k4--;
                            if (a1 >= a[k4]) {
                                break;
                            }
                            a[k4 + 2] = a[k4];
                        }
                        int k5 = k4 + 1;
                        a[k5 + 1] = a1;
                        while (true) {
                            k5--;
                            if (a2 >= a[k5]) {
                                break;
                            }
                            a[k5 + 1] = a[k5];
                        }
                        a[k5 + 1] = a2;
                        left = left2 + 1;
                    }
                    long last = a[right];
                    while (true) {
                        right--;
                        if (last < a[right]) {
                            a[right + 1] = a[right];
                        } else {
                            a[right + 1] = last;
                            return;
                        }
                    }
                }
            }
        }
    }

    static void sort(short[] a, int left, int right, short[] work, int workBase, int workLen) {
        if (right - left > COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR) {
            int[] count = new int[65536];
            int i = left - 1;
            while (true) {
                i++;
                if (i > right) {
                    break;
                }
                int i2 = a[i] - Short.MIN_VALUE;
                count[i2] = count[i2] + 1;
            }
            int i3 = 65536;
            int k = right + 1;
            while (k > left) {
                do {
                    i3--;
                } while (count[i3] == 0);
                short value = (short) (i3 - 32768);
                int s = count[i3];
                do {
                    k--;
                    a[k] = value;
                    s--;
                } while (s > 0);
            }
            return;
        }
        doSort(a, left, right, work, workBase, workLen);
    }

    private static void doSort(short[] a, int left, int right, short[] work, int workBase, int workLen) {
        int bo;
        short[] b;
        int ao;
        int q;
        int p;
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
        int[] run = new int[68];
        int count = 0;
        run[0] = left;
        int k = left;
        while (k < right) {
            if (a[k] >= a[k + 1]) {
                if (a[k] <= a[k + 1]) {
                    int m = MAX_RUN_LENGTH;
                    while (true) {
                        k++;
                        if (k > right || a[k - 1] != a[k]) {
                            break;
                        }
                        m--;
                        if (m == 0) {
                            sort(a, left, right, true);
                            return;
                        }
                    }
                } else {
                    do {
                        k++;
                        if (k > right || a[k - 1] < a[k]) {
                            int lo = run[count] - 1;
                            int hi = k;
                        }
                        k++;
                        break;
                    } while (a[k - 1] < a[k]);
                    int lo2 = run[count] - 1;
                    int hi2 = k;
                    while (true) {
                        lo2++;
                        hi2--;
                        if (lo2 >= hi2) {
                            break;
                        }
                        short t = a[lo2];
                        a[lo2] = a[hi2];
                        a[hi2] = t;
                    }
                }
            } else {
                do {
                    k++;
                    if (k > right) {
                        break;
                    }
                } while (a[k - 1] > a[k]);
            }
            count++;
            if (count == MAX_RUN_COUNT) {
                sort(a, left, right, true);
                return;
            }
            run[count] = k;
        }
        int right2 = right + 1;
        if (run[count] == right) {
            count++;
            run[count] = right2;
        } else if (count == 1) {
            return;
        }
        byte odd = 0;
        int n = 1;
        while (true) {
            n <<= 1;
            if (n >= count) {
                break;
            }
            odd = (byte) (odd ^ 1);
        }
        int blen = right2 - left;
        if (work == null || workLen < blen || workBase + blen > work.length) {
            work = new short[blen];
            workBase = 0;
        }
        if (odd == 0) {
            System.arraycopy(a, left, work, workBase, blen);
            b = a;
            bo = 0;
            a = work;
            ao = workBase - left;
        } else {
            b = work;
            ao = 0;
            bo = workBase - left;
        }
        while (count > 1) {
            int last = 0;
            for (int k2 = 2; k2 <= count; k2 += 2) {
                int hi3 = run[k2];
                int mi = run[k2 - 1];
                int i = run[k2 - 2];
                int q2 = mi;
                int p2 = i;
                while (i < hi3) {
                    if (q2 >= hi3 || (p2 < mi && a[p2 + ao] <= a[q2 + ao])) {
                        p = p2 + 1;
                        b[i + bo] = a[p2 + ao];
                        q = q2;
                    } else {
                        q = q2 + 1;
                        b[i + bo] = a[q2 + ao];
                        p = p2;
                    }
                    i++;
                    q2 = q;
                    p2 = p;
                }
                last++;
                run[last] = hi3;
            }
            if ((count & 1) != 0) {
                int i2 = right2;
                int lo3 = run[count - 1];
                while (true) {
                    i2--;
                    if (i2 < lo3) {
                        break;
                    }
                    b[i2 + bo] = a[i2 + ao];
                }
                last++;
                run[last] = right2;
            }
            short[] t2 = a;
            a = b;
            b = t2;
            int o = ao;
            ao = bo;
            bo = o;
            count = last;
        }
    }

    private static void sort(short[] a, int left, int right, boolean leftmost) {
        int length = (right - left) + 1;
        if (length >= INSERTION_SORT_THRESHOLD) {
            int seventh = (length >> 3) + (length >> 6) + 1;
            int e3 = (left + right) >>> 1;
            int e2 = e3 - seventh;
            int e1 = e2 - seventh;
            int e4 = e3 + seventh;
            int e5 = e4 + seventh;
            if (a[e2] < a[e1]) {
                short t = a[e2];
                a[e2] = a[e1];
                a[e1] = t;
            }
            if (a[e3] < a[e2]) {
                short t2 = a[e3];
                a[e3] = a[e2];
                a[e2] = t2;
                if (t2 < a[e1]) {
                    a[e2] = a[e1];
                    a[e1] = t2;
                }
            }
            if (a[e4] < a[e3]) {
                short t3 = a[e4];
                a[e4] = a[e3];
                a[e3] = t3;
                if (t3 < a[e2]) {
                    a[e3] = a[e2];
                    a[e2] = t3;
                    if (t3 < a[e1]) {
                        a[e2] = a[e1];
                        a[e1] = t3;
                    }
                }
            }
            if (a[e5] < a[e4]) {
                short t4 = a[e5];
                a[e5] = a[e4];
                a[e4] = t4;
                if (t4 < a[e3]) {
                    a[e4] = a[e3];
                    a[e3] = t4;
                    if (t4 < a[e2]) {
                        a[e3] = a[e2];
                        a[e2] = t4;
                        if (t4 < a[e1]) {
                            a[e2] = a[e1];
                            a[e1] = t4;
                        }
                    }
                }
            }
            int less = left;
            int great = right;
            if (a[e1] == a[e2] || a[e2] == a[e3] || a[e3] == a[e4] || a[e4] == a[e5]) {
                short pivot = a[e3];
                for (int k = left; k <= great; k++) {
                    if (a[k] != pivot) {
                        short ak = a[k];
                        if (ak < pivot) {
                            a[k] = a[less];
                            a[less] = ak;
                            less++;
                        } else {
                            while (a[great] > pivot) {
                                great--;
                            }
                            if (a[great] < pivot) {
                                a[k] = a[less];
                                a[less] = a[great];
                                less++;
                            } else {
                                a[k] = pivot;
                            }
                            a[great] = ak;
                            great--;
                        }
                    }
                }
                sort(a, left, less - 1, leftmost);
                sort(a, great + 1, right, false);
                return;
            }
            short pivot1 = a[e2];
            short pivot2 = a[e4];
            a[e2] = a[left];
            a[e4] = a[right];
            do {
                less++;
            } while (a[less] < pivot1);
            do {
                great--;
            } while (a[great] > pivot2);
            int k2 = less - 1;
            loop9:
            while (true) {
                k2++;
                if (k2 > great) {
                    break;
                }
                short ak2 = a[k2];
                if (ak2 < pivot1) {
                    a[k2] = a[less];
                    a[less] = ak2;
                    less++;
                } else if (ak2 > pivot2) {
                    while (a[great] > pivot2) {
                        int great2 = great - 1;
                        if (great == k2) {
                            great = great2;
                            break loop9;
                        }
                        great = great2;
                    }
                    if (a[great] < pivot1) {
                        a[k2] = a[less];
                        a[less] = a[great];
                        less++;
                    } else {
                        a[k2] = a[great];
                    }
                    a[great] = ak2;
                    great--;
                } else {
                    continue;
                }
            }
            a[left] = a[less - 1];
            a[less - 1] = pivot1;
            a[right] = a[great + 1];
            a[great + 1] = pivot2;
            sort(a, left, less - 2, leftmost);
            sort(a, great + 2, right, false);
            if (less < e1 && e5 < great) {
                while (a[less] == pivot1) {
                    less++;
                }
                while (a[great] == pivot2) {
                    great--;
                }
                int k3 = less - 1;
                loop13:
                while (true) {
                    k3++;
                    if (k3 > great) {
                        break;
                    }
                    short ak3 = a[k3];
                    if (ak3 == pivot1) {
                        a[k3] = a[less];
                        a[less] = ak3;
                        less++;
                    } else if (ak3 == pivot2) {
                        while (a[great] == pivot2) {
                            int great3 = great - 1;
                            if (great == k3) {
                                great = great3;
                                break loop13;
                            }
                            great = great3;
                        }
                        if (a[great] == pivot1) {
                            a[k3] = a[less];
                            a[less] = pivot1;
                            less++;
                        } else {
                            a[k3] = a[great];
                        }
                        a[great] = ak3;
                        great--;
                    } else {
                        continue;
                    }
                }
            }
            sort(a, less, great, false);
        } else if (leftmost) {
            int i = left;
            int j = left;
            while (i < right) {
                short ai = a[i + 1];
                while (true) {
                    if (ai >= a[j]) {
                        break;
                    }
                    a[j + 1] = a[j];
                    int j2 = j - 1;
                    if (j == left) {
                        j = j2;
                        break;
                    }
                    j = j2;
                }
                a[j + 1] = ai;
                i++;
                j = i;
            }
        } else {
            while (left < right) {
                left++;
                if (a[left] < a[left - 1]) {
                    while (true) {
                        int k4 = left;
                        int left2 = left + 1;
                        if (left2 > right) {
                            break;
                        }
                        short a1 = a[k4];
                        short a2 = a[left2];
                        if (a1 < a2) {
                            a2 = a1;
                            a1 = a[left2];
                        }
                        while (true) {
                            k4--;
                            if (a1 >= a[k4]) {
                                break;
                            }
                            a[k4 + 2] = a[k4];
                        }
                        int k5 = k4 + 1;
                        a[k5 + 1] = a1;
                        while (true) {
                            k5--;
                            if (a2 >= a[k5]) {
                                break;
                            }
                            a[k5 + 1] = a[k5];
                        }
                        a[k5 + 1] = a2;
                        left = left2 + 1;
                    }
                    short last = a[right];
                    while (true) {
                        right--;
                        if (last < a[right]) {
                            a[right + 1] = a[right];
                        } else {
                            a[right + 1] = last;
                            return;
                        }
                    }
                }
            }
        }
    }

    static void sort(char[] a, int left, int right, char[] work, int workBase, int workLen) {
        if (right - left > COUNTING_SORT_THRESHOLD_FOR_SHORT_OR_CHAR) {
            int[] count = new int[65536];
            int i = left - 1;
            while (true) {
                i++;
                if (i > right) {
                    break;
                }
                char c = a[i];
                count[c] = count[c] + 1;
            }
            int i2 = 65536;
            int k = right + 1;
            while (k > left) {
                do {
                    i2--;
                } while (count[i2] == 0);
                char value = (char) i2;
                int s = count[i2];
                do {
                    k--;
                    a[k] = value;
                    s--;
                } while (s > 0);
            }
            return;
        }
        doSort(a, left, right, work, workBase, workLen);
    }

    private static void doSort(char[] a, int left, int right, char[] work, int workBase, int workLen) {
        int bo;
        char[] b;
        int ao;
        int q;
        int p;
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
        int[] run = new int[68];
        int count = 0;
        run[0] = left;
        int k = left;
        while (k < right) {
            if (a[k] >= a[k + 1]) {
                if (a[k] <= a[k + 1]) {
                    int m = MAX_RUN_LENGTH;
                    while (true) {
                        k++;
                        if (k > right || a[k - 1] != a[k]) {
                            break;
                        }
                        m--;
                        if (m == 0) {
                            sort(a, left, right, true);
                            return;
                        }
                    }
                } else {
                    do {
                        k++;
                        if (k > right || a[k - 1] < a[k]) {
                            int lo = run[count] - 1;
                            int hi = k;
                        }
                        k++;
                        break;
                    } while (a[k - 1] < a[k]);
                    int lo2 = run[count] - 1;
                    int hi2 = k;
                    while (true) {
                        lo2++;
                        hi2--;
                        if (lo2 >= hi2) {
                            break;
                        }
                        char t = a[lo2];
                        a[lo2] = a[hi2];
                        a[hi2] = t;
                    }
                }
            } else {
                do {
                    k++;
                    if (k > right) {
                        break;
                    }
                } while (a[k - 1] > a[k]);
            }
            count++;
            if (count == MAX_RUN_COUNT) {
                sort(a, left, right, true);
                return;
            }
            run[count] = k;
        }
        int right2 = right + 1;
        if (run[count] == right) {
            count++;
            run[count] = right2;
        } else if (count == 1) {
            return;
        }
        byte odd = 0;
        int n = 1;
        while (true) {
            n <<= 1;
            if (n >= count) {
                break;
            }
            odd = (byte) (odd ^ 1);
        }
        int blen = right2 - left;
        if (work == null || workLen < blen || workBase + blen > work.length) {
            work = new char[blen];
            workBase = 0;
        }
        if (odd == 0) {
            System.arraycopy(a, left, work, workBase, blen);
            b = a;
            bo = 0;
            a = work;
            ao = workBase - left;
        } else {
            b = work;
            ao = 0;
            bo = workBase - left;
        }
        while (count > 1) {
            int last = 0;
            for (int k2 = 2; k2 <= count; k2 += 2) {
                int hi3 = run[k2];
                int mi = run[k2 - 1];
                int i = run[k2 - 2];
                int q2 = mi;
                int p2 = i;
                while (i < hi3) {
                    if (q2 >= hi3 || (p2 < mi && a[p2 + ao] <= a[q2 + ao])) {
                        p = p2 + 1;
                        b[i + bo] = a[p2 + ao];
                        q = q2;
                    } else {
                        q = q2 + 1;
                        b[i + bo] = a[q2 + ao];
                        p = p2;
                    }
                    i++;
                    q2 = q;
                    p2 = p;
                }
                last++;
                run[last] = hi3;
            }
            if ((count & 1) != 0) {
                int i2 = right2;
                int lo3 = run[count - 1];
                while (true) {
                    i2--;
                    if (i2 < lo3) {
                        break;
                    }
                    b[i2 + bo] = a[i2 + ao];
                }
                last++;
                run[last] = right2;
            }
            char[] t2 = a;
            a = b;
            b = t2;
            int o = ao;
            ao = bo;
            bo = o;
            count = last;
        }
    }

    private static void sort(char[] a, int left, int right, boolean leftmost) {
        int length = (right - left) + 1;
        if (length >= INSERTION_SORT_THRESHOLD) {
            int seventh = (length >> 3) + (length >> 6) + 1;
            int e3 = (left + right) >>> 1;
            int e2 = e3 - seventh;
            int e1 = e2 - seventh;
            int e4 = e3 + seventh;
            int e5 = e4 + seventh;
            if (a[e2] < a[e1]) {
                char t = a[e2];
                a[e2] = a[e1];
                a[e1] = t;
            }
            if (a[e3] < a[e2]) {
                char t2 = a[e3];
                a[e3] = a[e2];
                a[e2] = t2;
                if (t2 < a[e1]) {
                    a[e2] = a[e1];
                    a[e1] = t2;
                }
            }
            if (a[e4] < a[e3]) {
                char t3 = a[e4];
                a[e4] = a[e3];
                a[e3] = t3;
                if (t3 < a[e2]) {
                    a[e3] = a[e2];
                    a[e2] = t3;
                    if (t3 < a[e1]) {
                        a[e2] = a[e1];
                        a[e1] = t3;
                    }
                }
            }
            if (a[e5] < a[e4]) {
                char t4 = a[e5];
                a[e5] = a[e4];
                a[e4] = t4;
                if (t4 < a[e3]) {
                    a[e4] = a[e3];
                    a[e3] = t4;
                    if (t4 < a[e2]) {
                        a[e3] = a[e2];
                        a[e2] = t4;
                        if (t4 < a[e1]) {
                            a[e2] = a[e1];
                            a[e1] = t4;
                        }
                    }
                }
            }
            int less = left;
            int great = right;
            if (a[e1] == a[e2] || a[e2] == a[e3] || a[e3] == a[e4] || a[e4] == a[e5]) {
                char pivot = a[e3];
                for (int k = left; k <= great; k++) {
                    if (a[k] != pivot) {
                        char ak = a[k];
                        if (ak < pivot) {
                            a[k] = a[less];
                            a[less] = ak;
                            less++;
                        } else {
                            while (a[great] > pivot) {
                                great--;
                            }
                            if (a[great] < pivot) {
                                a[k] = a[less];
                                a[less] = a[great];
                                less++;
                            } else {
                                a[k] = pivot;
                            }
                            a[great] = ak;
                            great--;
                        }
                    }
                }
                sort(a, left, less - 1, leftmost);
                sort(a, great + 1, right, false);
                return;
            }
            char pivot1 = a[e2];
            char pivot2 = a[e4];
            a[e2] = a[left];
            a[e4] = a[right];
            do {
                less++;
            } while (a[less] < pivot1);
            do {
                great--;
            } while (a[great] > pivot2);
            int k2 = less - 1;
            loop9:
            while (true) {
                k2++;
                if (k2 > great) {
                    break;
                }
                char ak2 = a[k2];
                if (ak2 < pivot1) {
                    a[k2] = a[less];
                    a[less] = ak2;
                    less++;
                } else if (ak2 > pivot2) {
                    while (a[great] > pivot2) {
                        int great2 = great - 1;
                        if (great == k2) {
                            great = great2;
                            break loop9;
                        }
                        great = great2;
                    }
                    if (a[great] < pivot1) {
                        a[k2] = a[less];
                        a[less] = a[great];
                        less++;
                    } else {
                        a[k2] = a[great];
                    }
                    a[great] = ak2;
                    great--;
                } else {
                    continue;
                }
            }
            a[left] = a[less - 1];
            a[less - 1] = pivot1;
            a[right] = a[great + 1];
            a[great + 1] = pivot2;
            sort(a, left, less - 2, leftmost);
            sort(a, great + 2, right, false);
            if (less < e1 && e5 < great) {
                while (a[less] == pivot1) {
                    less++;
                }
                while (a[great] == pivot2) {
                    great--;
                }
                int k3 = less - 1;
                loop13:
                while (true) {
                    k3++;
                    if (k3 > great) {
                        break;
                    }
                    char ak3 = a[k3];
                    if (ak3 == pivot1) {
                        a[k3] = a[less];
                        a[less] = ak3;
                        less++;
                    } else if (ak3 == pivot2) {
                        while (a[great] == pivot2) {
                            int great3 = great - 1;
                            if (great == k3) {
                                great = great3;
                                break loop13;
                            }
                            great = great3;
                        }
                        if (a[great] == pivot1) {
                            a[k3] = a[less];
                            a[less] = pivot1;
                            less++;
                        } else {
                            a[k3] = a[great];
                        }
                        a[great] = ak3;
                        great--;
                    } else {
                        continue;
                    }
                }
            }
            sort(a, less, great, false);
        } else if (leftmost) {
            int i = left;
            int j = left;
            while (i < right) {
                char ai = a[i + 1];
                while (true) {
                    if (ai >= a[j]) {
                        break;
                    }
                    a[j + 1] = a[j];
                    int j2 = j - 1;
                    if (j == left) {
                        j = j2;
                        break;
                    }
                    j = j2;
                }
                a[j + 1] = ai;
                i++;
                j = i;
            }
        } else {
            while (left < right) {
                left++;
                if (a[left] < a[left - 1]) {
                    while (true) {
                        int k4 = left;
                        int left2 = left + 1;
                        if (left2 > right) {
                            break;
                        }
                        char a1 = a[k4];
                        char a2 = a[left2];
                        if (a1 < a2) {
                            a2 = a1;
                            a1 = a[left2];
                        }
                        while (true) {
                            k4--;
                            if (a1 >= a[k4]) {
                                break;
                            }
                            a[k4 + 2] = a[k4];
                        }
                        int k5 = k4 + 1;
                        a[k5 + 1] = a1;
                        while (true) {
                            k5--;
                            if (a2 >= a[k5]) {
                                break;
                            }
                            a[k5 + 1] = a[k5];
                        }
                        a[k5 + 1] = a2;
                        left = left2 + 1;
                    }
                    char last = a[right];
                    while (true) {
                        right--;
                        if (last < a[right]) {
                            a[right + 1] = a[right];
                        } else {
                            a[right + 1] = last;
                            return;
                        }
                    }
                }
            }
        }
    }

    static void sort(byte[] a, int left, int right) {
        if (right - left > COUNTING_SORT_THRESHOLD_FOR_BYTE) {
            int[] count = new int[256];
            int i = left - 1;
            while (true) {
                i++;
                if (i > right) {
                    break;
                }
                int i2 = a[i] + 128;
                count[i2] = count[i2] + 1;
            }
            int i3 = 256;
            int k = right + 1;
            while (k > left) {
                do {
                    i3--;
                } while (count[i3] == 0);
                byte value = (byte) (i3 - 128);
                int s = count[i3];
                do {
                    k--;
                    a[k] = value;
                    s--;
                } while (s > 0);
            }
            return;
        }
        int i4 = left;
        int j = left;
        while (i4 < right) {
            byte ai = a[i4 + 1];
            while (true) {
                if (ai >= a[j]) {
                    break;
                }
                a[j + 1] = a[j];
                int j2 = j - 1;
                if (j == left) {
                    j = j2;
                    break;
                }
                j = j2;
            }
            a[j + 1] = ai;
            i4++;
            j = i4;
        }
    }

    static void sort(float[] a, int left, int right, float[] work, int workBase, int workLen) {
        while (left <= right && Float.isNaN(a[right])) {
            right--;
        }
        int k = right;
        while (true) {
            k--;
            if (k < left) {
                break;
            }
            float ak = a[k];
            if (ak != ak) {
                a[k] = a[right];
                a[right] = ak;
                right--;
            }
        }
        doSort(a, left, right, work, workBase, workLen);
        int hi = right;
        while (left < hi) {
            int middle = (left + hi) >>> 1;
            if (a[middle] < 0.0f) {
                left = middle + 1;
            } else {
                hi = middle;
            }
        }
        while (left <= right && Float.floatToRawIntBits(a[left]) < 0) {
            left++;
        }
        int k2 = left;
        int p = left - 1;
        while (true) {
            k2++;
            if (k2 <= right) {
                float ak2 = a[k2];
                if (ak2 == 0.0f) {
                    if (Float.floatToRawIntBits(ak2) < 0) {
                        a[k2] = 0.0f;
                        p++;
                        a[p] = -0.0f;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void doSort(float[] a, int left, int right, float[] work, int workBase, int workLen) {
        int bo;
        float[] b;
        int ao;
        int q;
        int p;
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
        int[] run = new int[68];
        int count = 0;
        run[0] = left;
        int k = left;
        while (k < right) {
            if (a[k] >= a[k + 1]) {
                if (a[k] <= a[k + 1]) {
                    int m = MAX_RUN_LENGTH;
                    while (true) {
                        k++;
                        if (k > right || a[k - 1] != a[k]) {
                            break;
                        }
                        m--;
                        if (m == 0) {
                            sort(a, left, right, true);
                            return;
                        }
                    }
                } else {
                    do {
                        k++;
                        if (k > right || a[k - 1] < a[k]) {
                            int lo = run[count] - 1;
                            int hi = k;
                        }
                        k++;
                        break;
                    } while (a[k - 1] < a[k]);
                    int lo2 = run[count] - 1;
                    int hi2 = k;
                    while (true) {
                        lo2++;
                        hi2--;
                        if (lo2 >= hi2) {
                            break;
                        }
                        float t = a[lo2];
                        a[lo2] = a[hi2];
                        a[hi2] = t;
                    }
                }
            } else {
                do {
                    k++;
                    if (k > right) {
                        break;
                    }
                } while (a[k - 1] > a[k]);
            }
            count++;
            if (count == MAX_RUN_COUNT) {
                sort(a, left, right, true);
                return;
            }
            run[count] = k;
        }
        int right2 = right + 1;
        if (run[count] == right) {
            count++;
            run[count] = right2;
        } else if (count == 1) {
            return;
        }
        byte odd = 0;
        int n = 1;
        while (true) {
            n <<= 1;
            if (n >= count) {
                break;
            }
            odd = (byte) (odd ^ 1);
        }
        int blen = right2 - left;
        if (work == null || workLen < blen || workBase + blen > work.length) {
            work = new float[blen];
            workBase = 0;
        }
        if (odd == 0) {
            System.arraycopy(a, left, work, workBase, blen);
            b = a;
            bo = 0;
            a = work;
            ao = workBase - left;
        } else {
            b = work;
            ao = 0;
            bo = workBase - left;
        }
        while (count > 1) {
            int last = 0;
            for (int k2 = 2; k2 <= count; k2 += 2) {
                int hi3 = run[k2];
                int mi = run[k2 - 1];
                int i = run[k2 - 2];
                int q2 = mi;
                int p2 = i;
                while (i < hi3) {
                    if (q2 >= hi3 || (p2 < mi && a[p2 + ao] <= a[q2 + ao])) {
                        p = p2 + 1;
                        b[i + bo] = a[p2 + ao];
                        q = q2;
                    } else {
                        q = q2 + 1;
                        b[i + bo] = a[q2 + ao];
                        p = p2;
                    }
                    i++;
                    q2 = q;
                    p2 = p;
                }
                last++;
                run[last] = hi3;
            }
            if ((count & 1) != 0) {
                int i2 = right2;
                int lo3 = run[count - 1];
                while (true) {
                    i2--;
                    if (i2 < lo3) {
                        break;
                    }
                    b[i2 + bo] = a[i2 + ao];
                }
                last++;
                run[last] = right2;
            }
            float[] t2 = a;
            a = b;
            b = t2;
            int o = ao;
            ao = bo;
            bo = o;
            count = last;
        }
    }

    private static void sort(float[] a, int left, int right, boolean leftmost) {
        int length = (right - left) + 1;
        if (length >= INSERTION_SORT_THRESHOLD) {
            int seventh = (length >> 3) + (length >> 6) + 1;
            int e3 = (left + right) >>> 1;
            int e2 = e3 - seventh;
            int e1 = e2 - seventh;
            int e4 = e3 + seventh;
            int e5 = e4 + seventh;
            if (a[e2] < a[e1]) {
                float t = a[e2];
                a[e2] = a[e1];
                a[e1] = t;
            }
            if (a[e3] < a[e2]) {
                float t2 = a[e3];
                a[e3] = a[e2];
                a[e2] = t2;
                if (t2 < a[e1]) {
                    a[e2] = a[e1];
                    a[e1] = t2;
                }
            }
            if (a[e4] < a[e3]) {
                float t3 = a[e4];
                a[e4] = a[e3];
                a[e3] = t3;
                if (t3 < a[e2]) {
                    a[e3] = a[e2];
                    a[e2] = t3;
                    if (t3 < a[e1]) {
                        a[e2] = a[e1];
                        a[e1] = t3;
                    }
                }
            }
            if (a[e5] < a[e4]) {
                float t4 = a[e5];
                a[e5] = a[e4];
                a[e4] = t4;
                if (t4 < a[e3]) {
                    a[e4] = a[e3];
                    a[e3] = t4;
                    if (t4 < a[e2]) {
                        a[e3] = a[e2];
                        a[e2] = t4;
                        if (t4 < a[e1]) {
                            a[e2] = a[e1];
                            a[e1] = t4;
                        }
                    }
                }
            }
            int less = left;
            int great = right;
            if (a[e1] == a[e2] || a[e2] == a[e3] || a[e3] == a[e4] || a[e4] == a[e5]) {
                float pivot = a[e3];
                for (int k = left; k <= great; k++) {
                    if (a[k] != pivot) {
                        float ak = a[k];
                        if (ak < pivot) {
                            a[k] = a[less];
                            a[less] = ak;
                            less++;
                        } else {
                            while (a[great] > pivot) {
                                great--;
                            }
                            if (a[great] < pivot) {
                                a[k] = a[less];
                                a[less] = a[great];
                                less++;
                            } else {
                                a[k] = a[great];
                            }
                            a[great] = ak;
                            great--;
                        }
                    }
                }
                sort(a, left, less - 1, leftmost);
                sort(a, great + 1, right, false);
                return;
            }
            float pivot1 = a[e2];
            float pivot2 = a[e4];
            a[e2] = a[left];
            a[e4] = a[right];
            do {
                less++;
            } while (a[less] < pivot1);
            do {
                great--;
            } while (a[great] > pivot2);
            int k2 = less - 1;
            loop9:
            while (true) {
                k2++;
                if (k2 > great) {
                    break;
                }
                float ak2 = a[k2];
                if (ak2 < pivot1) {
                    a[k2] = a[less];
                    a[less] = ak2;
                    less++;
                } else if (ak2 > pivot2) {
                    while (a[great] > pivot2) {
                        int great2 = great - 1;
                        if (great == k2) {
                            great = great2;
                            break loop9;
                        }
                        great = great2;
                    }
                    if (a[great] < pivot1) {
                        a[k2] = a[less];
                        a[less] = a[great];
                        less++;
                    } else {
                        a[k2] = a[great];
                    }
                    a[great] = ak2;
                    great--;
                } else {
                    continue;
                }
            }
            a[left] = a[less - 1];
            a[less - 1] = pivot1;
            a[right] = a[great + 1];
            a[great + 1] = pivot2;
            sort(a, left, less - 2, leftmost);
            sort(a, great + 2, right, false);
            if (less < e1 && e5 < great) {
                while (a[less] == pivot1) {
                    less++;
                }
                while (a[great] == pivot2) {
                    great--;
                }
                int k3 = less - 1;
                loop13:
                while (true) {
                    k3++;
                    if (k3 > great) {
                        break;
                    }
                    float ak3 = a[k3];
                    if (ak3 == pivot1) {
                        a[k3] = a[less];
                        a[less] = ak3;
                        less++;
                    } else if (ak3 == pivot2) {
                        while (a[great] == pivot2) {
                            int great3 = great - 1;
                            if (great == k3) {
                                great = great3;
                                break loop13;
                            }
                            great = great3;
                        }
                        if (a[great] == pivot1) {
                            a[k3] = a[less];
                            a[less] = a[great];
                            less++;
                        } else {
                            a[k3] = a[great];
                        }
                        a[great] = ak3;
                        great--;
                    } else {
                        continue;
                    }
                }
            }
            sort(a, less, great, false);
        } else if (leftmost) {
            int i = left;
            int j = left;
            while (i < right) {
                float ai = a[i + 1];
                while (true) {
                    if (ai >= a[j]) {
                        break;
                    }
                    a[j + 1] = a[j];
                    int j2 = j - 1;
                    if (j == left) {
                        j = j2;
                        break;
                    }
                    j = j2;
                }
                a[j + 1] = ai;
                i++;
                j = i;
            }
        } else {
            while (left < right) {
                left++;
                if (a[left] < a[left - 1]) {
                    while (true) {
                        int k4 = left;
                        int left2 = left + 1;
                        if (left2 > right) {
                            break;
                        }
                        float a1 = a[k4];
                        float a2 = a[left2];
                        if (a1 < a2) {
                            a2 = a1;
                            a1 = a[left2];
                        }
                        while (true) {
                            k4--;
                            if (a1 >= a[k4]) {
                                break;
                            }
                            a[k4 + 2] = a[k4];
                        }
                        int k5 = k4 + 1;
                        a[k5 + 1] = a1;
                        while (true) {
                            k5--;
                            if (a2 >= a[k5]) {
                                break;
                            }
                            a[k5 + 1] = a[k5];
                        }
                        a[k5 + 1] = a2;
                        left = left2 + 1;
                    }
                    float last = a[right];
                    while (true) {
                        right--;
                        if (last < a[right]) {
                            a[right + 1] = a[right];
                        } else {
                            a[right + 1] = last;
                            return;
                        }
                    }
                }
            }
        }
    }

    static void sort(double[] a, int left, int right, double[] work, int workBase, int workLen) {
        while (left <= right && Double.isNaN(a[right])) {
            right--;
        }
        int k = right;
        while (true) {
            k--;
            if (k < left) {
                break;
            }
            double ak = a[k];
            if (ak != ak) {
                a[k] = a[right];
                a[right] = ak;
                right--;
            }
        }
        doSort(a, left, right, work, workBase, workLen);
        int hi = right;
        while (left < hi) {
            int middle = (left + hi) >>> 1;
            if (a[middle] < 0.0d) {
                left = middle + 1;
            } else {
                hi = middle;
            }
        }
        while (left <= right && Double.doubleToRawLongBits(a[left]) < 0) {
            left++;
        }
        int k2 = left;
        int p = left - 1;
        while (true) {
            k2++;
            if (k2 <= right) {
                double ak2 = a[k2];
                if (ak2 == 0.0d) {
                    if (Double.doubleToRawLongBits(ak2) < 0) {
                        a[k2] = 0.0d;
                        p++;
                        a[p] = -0.0d;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void doSort(double[] a, int left, int right, double[] work, int workBase, int workLen) {
        int bo;
        double[] b;
        int ao;
        int q;
        int p;
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
        int[] run = new int[68];
        int count = 0;
        run[0] = left;
        int k = left;
        while (k < right) {
            if (a[k] >= a[k + 1]) {
                if (a[k] <= a[k + 1]) {
                    int m = MAX_RUN_LENGTH;
                    while (true) {
                        k++;
                        if (k > right || a[k - 1] != a[k]) {
                            break;
                        }
                        m--;
                        if (m == 0) {
                            sort(a, left, right, true);
                            return;
                        }
                    }
                } else {
                    do {
                        k++;
                        if (k > right || a[k - 1] < a[k]) {
                            int lo = run[count] - 1;
                            int hi = k;
                        }
                        k++;
                        break;
                    } while (a[k - 1] < a[k]);
                    int lo2 = run[count] - 1;
                    int hi2 = k;
                    while (true) {
                        lo2++;
                        hi2--;
                        if (lo2 >= hi2) {
                            break;
                        }
                        double t = a[lo2];
                        a[lo2] = a[hi2];
                        a[hi2] = t;
                    }
                }
            } else {
                do {
                    k++;
                    if (k > right) {
                        break;
                    }
                } while (a[k - 1] > a[k]);
            }
            count++;
            if (count == MAX_RUN_COUNT) {
                sort(a, left, right, true);
                return;
            }
            run[count] = k;
        }
        int right2 = right + 1;
        if (run[count] == right) {
            count++;
            run[count] = right2;
        } else if (count == 1) {
            return;
        }
        byte odd = 0;
        int n = 1;
        while (true) {
            n <<= 1;
            if (n >= count) {
                break;
            }
            odd = (byte) (odd ^ 1);
        }
        int blen = right2 - left;
        if (work == null || workLen < blen || workBase + blen > work.length) {
            work = new double[blen];
            workBase = 0;
        }
        if (odd == 0) {
            System.arraycopy(a, left, work, workBase, blen);
            b = a;
            bo = 0;
            a = work;
            ao = workBase - left;
        } else {
            b = work;
            ao = 0;
            bo = workBase - left;
        }
        while (count > 1) {
            int last = 0;
            for (int k2 = 2; k2 <= count; k2 += 2) {
                int hi3 = run[k2];
                int mi = run[k2 - 1];
                int i = run[k2 - 2];
                int q2 = mi;
                int p2 = i;
                while (i < hi3) {
                    if (q2 >= hi3 || (p2 < mi && a[p2 + ao] <= a[q2 + ao])) {
                        p = p2 + 1;
                        b[i + bo] = a[p2 + ao];
                        q = q2;
                    } else {
                        q = q2 + 1;
                        b[i + bo] = a[q2 + ao];
                        p = p2;
                    }
                    i++;
                    q2 = q;
                    p2 = p;
                }
                last++;
                run[last] = hi3;
            }
            if ((count & 1) != 0) {
                int i2 = right2;
                int lo3 = run[count - 1];
                while (true) {
                    i2--;
                    if (i2 < lo3) {
                        break;
                    }
                    b[i2 + bo] = a[i2 + ao];
                }
                last++;
                run[last] = right2;
            }
            double[] t2 = a;
            a = b;
            b = t2;
            int o = ao;
            ao = bo;
            bo = o;
            count = last;
        }
    }

    private static void sort(double[] a, int left, int right, boolean leftmost) {
        int length = (right - left) + 1;
        if (length >= INSERTION_SORT_THRESHOLD) {
            int seventh = (length >> 3) + (length >> 6) + 1;
            int e3 = (left + right) >>> 1;
            int e2 = e3 - seventh;
            int e1 = e2 - seventh;
            int e4 = e3 + seventh;
            int e5 = e4 + seventh;
            if (a[e2] < a[e1]) {
                double t = a[e2];
                a[e2] = a[e1];
                a[e1] = t;
            }
            if (a[e3] < a[e2]) {
                double t2 = a[e3];
                a[e3] = a[e2];
                a[e2] = t2;
                if (t2 < a[e1]) {
                    a[e2] = a[e1];
                    a[e1] = t2;
                }
            }
            if (a[e4] < a[e3]) {
                double t3 = a[e4];
                a[e4] = a[e3];
                a[e3] = t3;
                if (t3 < a[e2]) {
                    a[e3] = a[e2];
                    a[e2] = t3;
                    if (t3 < a[e1]) {
                        a[e2] = a[e1];
                        a[e1] = t3;
                    }
                }
            }
            if (a[e5] < a[e4]) {
                double t4 = a[e5];
                a[e5] = a[e4];
                a[e4] = t4;
                if (t4 < a[e3]) {
                    a[e4] = a[e3];
                    a[e3] = t4;
                    if (t4 < a[e2]) {
                        a[e3] = a[e2];
                        a[e2] = t4;
                        if (t4 < a[e1]) {
                            a[e2] = a[e1];
                            a[e1] = t4;
                        }
                    }
                }
            }
            int less = left;
            int great = right;
            if (a[e1] == a[e2] || a[e2] == a[e3] || a[e3] == a[e4] || a[e4] == a[e5]) {
                double pivot = a[e3];
                for (int k = left; k <= great; k++) {
                    if (a[k] != pivot) {
                        double ak = a[k];
                        if (ak < pivot) {
                            a[k] = a[less];
                            a[less] = ak;
                            less++;
                        } else {
                            while (a[great] > pivot) {
                                great--;
                            }
                            if (a[great] < pivot) {
                                a[k] = a[less];
                                a[less] = a[great];
                                less++;
                            } else {
                                a[k] = a[great];
                            }
                            a[great] = ak;
                            great--;
                        }
                    }
                }
                sort(a, left, less - 1, leftmost);
                sort(a, great + 1, right, false);
                return;
            }
            double pivot1 = a[e2];
            double pivot2 = a[e4];
            a[e2] = a[left];
            a[e4] = a[right];
            do {
                less++;
            } while (a[less] < pivot1);
            do {
                great--;
            } while (a[great] > pivot2);
            int k2 = less - 1;
            loop9:
            while (true) {
                k2++;
                if (k2 > great) {
                    break;
                }
                double ak2 = a[k2];
                if (ak2 < pivot1) {
                    a[k2] = a[less];
                    a[less] = ak2;
                    less++;
                } else if (ak2 > pivot2) {
                    while (a[great] > pivot2) {
                        int great2 = great - 1;
                        if (great == k2) {
                            great = great2;
                            break loop9;
                        }
                        great = great2;
                    }
                    if (a[great] < pivot1) {
                        a[k2] = a[less];
                        a[less] = a[great];
                        less++;
                    } else {
                        a[k2] = a[great];
                    }
                    a[great] = ak2;
                    great--;
                } else {
                    continue;
                }
            }
            a[left] = a[less - 1];
            a[less - 1] = pivot1;
            a[right] = a[great + 1];
            a[great + 1] = pivot2;
            sort(a, left, less - 2, leftmost);
            sort(a, great + 2, right, false);
            if (less < e1 && e5 < great) {
                while (a[less] == pivot1) {
                    less++;
                }
                while (a[great] == pivot2) {
                    great--;
                }
                int k3 = less - 1;
                loop13:
                while (true) {
                    k3++;
                    if (k3 > great) {
                        break;
                    }
                    double ak3 = a[k3];
                    if (ak3 == pivot1) {
                        a[k3] = a[less];
                        a[less] = ak3;
                        less++;
                    } else if (ak3 == pivot2) {
                        while (a[great] == pivot2) {
                            int great3 = great - 1;
                            if (great == k3) {
                                great = great3;
                                break loop13;
                            }
                            great = great3;
                        }
                        if (a[great] == pivot1) {
                            a[k3] = a[less];
                            a[less] = a[great];
                            less++;
                        } else {
                            a[k3] = a[great];
                        }
                        a[great] = ak3;
                        great--;
                    } else {
                        continue;
                    }
                }
            }
            sort(a, less, great, false);
        } else if (leftmost) {
            int i = left;
            int j = left;
            while (i < right) {
                double ai = a[i + 1];
                while (true) {
                    if (ai >= a[j]) {
                        break;
                    }
                    a[j + 1] = a[j];
                    int j2 = j - 1;
                    if (j == left) {
                        j = j2;
                        break;
                    }
                    j = j2;
                }
                a[j + 1] = ai;
                i++;
                j = i;
            }
        } else {
            while (left < right) {
                left++;
                if (a[left] < a[left - 1]) {
                    while (true) {
                        int k4 = left;
                        int left2 = left + 1;
                        if (left2 > right) {
                            break;
                        }
                        double a1 = a[k4];
                        double a2 = a[left2];
                        if (a1 < a2) {
                            a2 = a1;
                            a1 = a[left2];
                        }
                        while (true) {
                            k4--;
                            if (a1 >= a[k4]) {
                                break;
                            }
                            a[k4 + 2] = a[k4];
                        }
                        int k5 = k4 + 1;
                        a[k5 + 1] = a1;
                        while (true) {
                            k5--;
                            if (a2 >= a[k5]) {
                                break;
                            }
                            a[k5 + 1] = a[k5];
                        }
                        a[k5 + 1] = a2;
                        left = left2 + 1;
                    }
                    double last = a[right];
                    while (true) {
                        right--;
                        if (last < a[right]) {
                            a[right + 1] = a[right];
                        } else {
                            a[right + 1] = last;
                            return;
                        }
                    }
                }
            }
        }
    }
}
