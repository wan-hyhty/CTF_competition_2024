package java.lang;

final class ProcessImpl {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f7assertionsDisabled = false;

    private ProcessImpl() {
    }

    private static byte[] toCString(String s) {
        if (s == null) {
            return null;
        }
        byte[] bytes = s.getBytes();
        byte[] result = new byte[(bytes.length + 1)];
        System.arraycopy(bytes, 0, result, 0, bytes.length);
        result[result.length - 1] = 0;
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b8 A[SYNTHETIC, Splitter:B:45:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd A[SYNTHETIC, Splitter:B:48:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Process start(java.lang.String[] r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23, java.lang.ProcessBuilder.Redirect[] r24, boolean r25) throws java.io.IOException {
        /*
            boolean r1 = f7assertionsDisabled
            if (r1 != 0) goto L_0x0016
            if (r21 == 0) goto L_0x0014
            r0 = r21
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0014
            r1 = 1
        L_0x000c:
            if (r1 != 0) goto L_0x0016
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0014:
            r1 = 0
            goto L_0x000c
        L_0x0016:
            r0 = r21
            int r1 = r0.length
            int r1 = r1 + -1
            byte[][] r11 = new byte[r1][]
            int r0 = r11.length
            r20 = r0
            r19 = 0
        L_0x0022:
            int r1 = r11.length
            r0 = r19
            if (r0 >= r1) goto L_0x0039
            int r1 = r19 + 1
            r1 = r21[r1]
            byte[] r1 = r1.getBytes()
            r11[r19] = r1
            r1 = r11[r19]
            int r1 = r1.length
            int r20 = r20 + r1
            int r19 = r19 + 1
            goto L_0x0022
        L_0x0039:
            r0 = r20
            byte[] r3 = new byte[r0]
            r19 = 0
            r1 = 0
            int r2 = r11.length
        L_0x0041:
            if (r1 >= r2) goto L_0x0054
            r10 = r11[r1]
            int r4 = r10.length
            r6 = 0
            r0 = r19
            java.lang.System.arraycopy((byte[]) r10, (int) r6, (byte[]) r3, (int) r0, (int) r4)
            int r4 = r10.length
            int r4 = r4 + 1
            int r19 = r19 + r4
            int r1 = r1 + 1
            goto L_0x0041
        L_0x0054:
            r1 = 1
            int[] r12 = new int[r1]
            r0 = r22
            byte[] r5 = java.lang.ProcessEnvironment.toEnvironmentBlock(r0, r12)
            r13 = 0
            r15 = 0
            r17 = 0
            if (r24 != 0) goto L_0x0090
            r1 = -1
            r2 = -1
            r4 = -1
            int[] r8 = new int[]{r1, r2, r4}     // Catch:{ all -> 0x00b5 }
        L_0x006a:
            java.lang.UNIXProcess r1 = new java.lang.UNIXProcess     // Catch:{ all -> 0x00b5 }
            r2 = 0
            r2 = r21[r2]     // Catch:{ all -> 0x00b5 }
            byte[] r2 = toCString(r2)     // Catch:{ all -> 0x00b5 }
            int r4 = r11.length     // Catch:{ all -> 0x00b5 }
            r6 = 0
            r6 = r12[r6]     // Catch:{ all -> 0x00b5 }
            byte[] r7 = toCString(r23)     // Catch:{ all -> 0x00b5 }
            r9 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00b5 }
            if (r13 == 0) goto L_0x0085
            r13.close()     // Catch:{ all -> 0x0152 }
        L_0x0085:
            if (r15 == 0) goto L_0x008a
            r15.close()     // Catch:{ all -> 0x014b }
        L_0x008a:
            if (r17 == 0) goto L_0x008f
            r17.close()
        L_0x008f:
            return r1
        L_0x0090:
            r1 = 3
            int[] r8 = new int[r1]     // Catch:{ all -> 0x00b5 }
            r1 = 0
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.lang.ProcessBuilder$Redirect r2 = java.lang.ProcessBuilder.Redirect.PIPE     // Catch:{ all -> 0x00b5 }
            if (r1 != r2) goto L_0x00c6
            r1 = -1
            r2 = 0
            r8[r2] = r1     // Catch:{ all -> 0x00b5 }
        L_0x009e:
            r1 = 1
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.lang.ProcessBuilder$Redirect r2 = java.lang.ProcessBuilder.Redirect.PIPE     // Catch:{ all -> 0x00b5 }
            if (r1 != r2) goto L_0x00eb
            r1 = -1
            r2 = 1
            r8[r2] = r1     // Catch:{ all -> 0x00b5 }
        L_0x00a9:
            r1 = 2
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.lang.ProcessBuilder$Redirect r2 = java.lang.ProcessBuilder.Redirect.PIPE     // Catch:{ all -> 0x00b5 }
            if (r1 != r2) goto L_0x011a
            r1 = -1
            r2 = 2
            r8[r2] = r1     // Catch:{ all -> 0x00b5 }
            goto L_0x006a
        L_0x00b5:
            r1 = move-exception
        L_0x00b6:
            if (r13 == 0) goto L_0x00bb
            r13.close()     // Catch:{ all -> 0x016c }
        L_0x00bb:
            if (r15 == 0) goto L_0x00c0
            r15.close()     // Catch:{ all -> 0x0165 }
        L_0x00c0:
            if (r17 == 0) goto L_0x00c5
            r17.close()
        L_0x00c5:
            throw r1
        L_0x00c6:
            r1 = 0
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.lang.ProcessBuilder$Redirect r2 = java.lang.ProcessBuilder.Redirect.INHERIT     // Catch:{ all -> 0x00b5 }
            if (r1 != r2) goto L_0x00d2
            r1 = 0
            r2 = 0
            r8[r2] = r1     // Catch:{ all -> 0x00b5 }
            goto L_0x009e
        L_0x00d2:
            java.io.FileInputStream r14 = new java.io.FileInputStream     // Catch:{ all -> 0x00b5 }
            r1 = 0
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.io.File r1 = r1.file()     // Catch:{ all -> 0x00b5 }
            r14.<init>((java.io.File) r1)     // Catch:{ all -> 0x00b5 }
            java.io.FileDescriptor r1 = r14.getFD()     // Catch:{ all -> 0x017f }
            int r1 = r1.getInt$()     // Catch:{ all -> 0x017f }
            r2 = 0
            r8[r2] = r1     // Catch:{ all -> 0x017f }
            r13 = r14
            goto L_0x009e
        L_0x00eb:
            r1 = 1
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.lang.ProcessBuilder$Redirect r2 = java.lang.ProcessBuilder.Redirect.INHERIT     // Catch:{ all -> 0x00b5 }
            if (r1 != r2) goto L_0x00f7
            r1 = 1
            r2 = 1
            r8[r2] = r1     // Catch:{ all -> 0x00b5 }
            goto L_0x00a9
        L_0x00f7:
            java.io.FileOutputStream r16 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b5 }
            r1 = 1
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.io.File r1 = r1.file()     // Catch:{ all -> 0x00b5 }
            r2 = 1
            r2 = r24[r2]     // Catch:{ all -> 0x00b5 }
            boolean r2 = r2.append()     // Catch:{ all -> 0x00b5 }
            r0 = r16
            r0.<init>((java.io.File) r1, (boolean) r2)     // Catch:{ all -> 0x00b5 }
            java.io.FileDescriptor r1 = r16.getFD()     // Catch:{ all -> 0x0183 }
            int r1 = r1.getInt$()     // Catch:{ all -> 0x0183 }
            r2 = 1
            r8[r2] = r1     // Catch:{ all -> 0x0183 }
            r15 = r16
            goto L_0x00a9
        L_0x011a:
            r1 = 2
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.lang.ProcessBuilder$Redirect r2 = java.lang.ProcessBuilder.Redirect.INHERIT     // Catch:{ all -> 0x00b5 }
            if (r1 != r2) goto L_0x0127
            r1 = 2
            r2 = 2
            r8[r2] = r1     // Catch:{ all -> 0x00b5 }
            goto L_0x006a
        L_0x0127:
            java.io.FileOutputStream r18 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b5 }
            r1 = 2
            r1 = r24[r1]     // Catch:{ all -> 0x00b5 }
            java.io.File r1 = r1.file()     // Catch:{ all -> 0x00b5 }
            r2 = 2
            r2 = r24[r2]     // Catch:{ all -> 0x00b5 }
            boolean r2 = r2.append()     // Catch:{ all -> 0x00b5 }
            r0 = r18
            r0.<init>((java.io.File) r1, (boolean) r2)     // Catch:{ all -> 0x00b5 }
            java.io.FileDescriptor r1 = r18.getFD()     // Catch:{ all -> 0x0188 }
            int r1 = r1.getInt$()     // Catch:{ all -> 0x0188 }
            r2 = 2
            r8[r2] = r1     // Catch:{ all -> 0x0188 }
            r17 = r18
            goto L_0x006a
        L_0x014b:
            r1 = move-exception
            if (r17 == 0) goto L_0x0151
            r17.close()
        L_0x0151:
            throw r1
        L_0x0152:
            r1 = move-exception
            if (r15 == 0) goto L_0x0158
            r15.close()     // Catch:{ all -> 0x015e }
        L_0x0158:
            if (r17 == 0) goto L_0x015d
            r17.close()
        L_0x015d:
            throw r1
        L_0x015e:
            r1 = move-exception
            if (r17 == 0) goto L_0x0164
            r17.close()
        L_0x0164:
            throw r1
        L_0x0165:
            r1 = move-exception
            if (r17 == 0) goto L_0x016b
            r17.close()
        L_0x016b:
            throw r1
        L_0x016c:
            r1 = move-exception
            if (r15 == 0) goto L_0x0172
            r15.close()     // Catch:{ all -> 0x0178 }
        L_0x0172:
            if (r17 == 0) goto L_0x0177
            r17.close()
        L_0x0177:
            throw r1
        L_0x0178:
            r1 = move-exception
            if (r17 == 0) goto L_0x017e
            r17.close()
        L_0x017e:
            throw r1
        L_0x017f:
            r1 = move-exception
            r13 = r14
            goto L_0x00b6
        L_0x0183:
            r1 = move-exception
            r15 = r16
            goto L_0x00b6
        L_0x0188:
            r1 = move-exception
            r17 = r18
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessImpl.start(java.lang.String[], java.util.Map, java.lang.String, java.lang.ProcessBuilder$Redirect[], boolean):java.lang.Process");
    }
}
