package sun.security.util;

import java.security.MessageDigest;
import java.util.HashMap;

public class ManifestDigester {
    public static final String MF_MAIN_ATTRS = "Manifest-Main-Attributes";
    private HashMap<String, Entry> entries = new HashMap<>();
    private byte[] rawBytes;

    static class Position {
        int endOfFirstLine;
        int endOfSection;
        int startOfNext;

        Position() {
        }
    }

    private boolean findSection(int offset, Position pos) {
        int i = offset;
        int len = this.rawBytes.length;
        int last = offset;
        boolean allBlank = true;
        pos.endOfFirstLine = -1;
        while (i < len) {
            switch (this.rawBytes[i]) {
                case 10:
                    break;
                case 13:
                    if (pos.endOfFirstLine == -1) {
                        pos.endOfFirstLine = i - 1;
                    }
                    if (i < len && this.rawBytes[i + 1] == 10) {
                        i++;
                        break;
                    }
                default:
                    allBlank = false;
                    continue;
            }
            if (pos.endOfFirstLine == -1) {
                pos.endOfFirstLine = i - 1;
            }
            if (allBlank || i == len - 1) {
                if (i == len - 1) {
                    pos.endOfSection = i;
                } else {
                    pos.endOfSection = last;
                }
                pos.startOfNext = i + 1;
                return true;
            }
            last = i;
            allBlank = true;
            i++;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c3 A[Catch:{ UnsupportedEncodingException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0124 A[Catch:{ UnsupportedEncodingException -> 0x0145 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ManifestDigester(byte[] r25) {
        /*
            r24 = this;
            r24.<init>()
            r0 = r25
            r1 = r24
            r1.rawBytes = r0
            java.util.HashMap r17 = new java.util.HashMap
            r17.<init>()
            r0 = r17
            r1 = r24
            r1.entries = r0
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream
            r5.<init>()
            sun.security.util.ManifestDigester$Position r10 = new sun.security.util.ManifestDigester$Position
            r10.<init>()
            r17 = 0
            r0 = r24
            r1 = r17
            boolean r17 = r0.findSection(r1, r10)
            if (r17 != 0) goto L_0x002b
            return
        L_0x002b:
            r0 = r24
            java.util.HashMap<java.lang.String, sun.security.util.ManifestDigester$Entry> r0 = r0.entries
            r17 = r0
            java.lang.String r18 = "Manifest-Main-Attributes"
            sun.security.util.ManifestDigester$Entry r19 = new sun.security.util.ManifestDigester$Entry
            int r0 = r10.endOfSection
            r20 = r0
            int r20 = r20 + 1
            int r0 = r10.startOfNext
            r21 = r0
            r0 = r24
            byte[] r0 = r0.rawBytes
            r22 = r0
            r23 = 0
            r0 = r19
            r1 = r23
            r2 = r20
            r3 = r21
            r4 = r22
            r0.<init>(r1, r2, r3, r4)
            r17.put(r18, r19)
            int r13 = r10.startOfNext
        L_0x005a:
            r0 = r24
            boolean r17 = r0.findSection(r13, r10)
            if (r17 == 0) goto L_0x014f
            int r0 = r10.endOfFirstLine
            r17 = r0
            int r17 = r17 - r13
            int r8 = r17 + 1
            int r0 = r10.endOfSection
            r17 = r0
            int r17 = r17 - r13
            int r11 = r17 + 1
            int r0 = r10.startOfNext
            r17 = r0
            int r12 = r17 - r13
            r17 = 6
            r0 = r17
            if (r8 <= r0) goto L_0x0141
            r0 = r24
            r1 = r25
            boolean r17 = r0.isNameAttr(r1, r13)
            if (r17 == 0) goto L_0x0141
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>((int) r11)
            java.lang.String r17 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            int r18 = r13 + 6
            int r19 = r8 + -6
            java.lang.String r20 = "UTF8"
            r0 = r17
            r1 = r25
            r2 = r18
            r3 = r19
            r4 = r20
            r0.<init>((byte[]) r1, (int) r2, (int) r3, (java.lang.String) r4)     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r0 = r17
            r9.append((java.lang.String) r0)     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            int r6 = r13 + r8
            int r17 = r6 - r13
            r0 = r17
            if (r0 >= r11) goto L_0x011d
            byte r17 = r25[r6]     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r18 = 13
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x00e6
            int r6 = r6 + 2
            r7 = r6
        L_0x00bd:
            int r17 = r7 - r13
            r0 = r17
            if (r0 >= r11) goto L_0x0124
            int r6 = r7 + 1
            byte r17 = r25[r7]     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r18 = 32
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x0125
            r16 = r6
            r7 = r6
        L_0x00d2:
            int r17 = r7 - r13
            r0 = r17
            if (r0 >= r11) goto L_0x00ea
            int r6 = r7 + 1
            byte r17 = r25[r7]     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r18 = 10
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x00eb
            r7 = r6
            goto L_0x00d2
        L_0x00e6:
            int r6 = r6 + 1
            r7 = r6
            goto L_0x00bd
        L_0x00ea:
            r6 = r7
        L_0x00eb:
            int r17 = r6 + -1
            byte r17 = r25[r17]     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r18 = 10
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x00f8
            return
        L_0x00f8:
            int r17 = r6 + -2
            byte r17 = r25[r17]     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r18 = 13
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x011f
            int r17 = r6 - r16
            int r15 = r17 + -2
        L_0x0108:
            java.lang.String r17 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            java.lang.String r18 = "UTF8"
            r0 = r17
            r1 = r25
            r2 = r16
            r3 = r18
            r0.<init>((byte[]) r1, (int) r2, (int) r15, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r0 = r17
            r9.append((java.lang.String) r0)     // Catch:{ UnsupportedEncodingException -> 0x0145 }
        L_0x011d:
            r7 = r6
            goto L_0x00bd
        L_0x011f:
            int r17 = r6 - r16
            int r15 = r17 + -1
            goto L_0x0108
        L_0x0124:
            r6 = r7
        L_0x0125:
            r0 = r24
            java.util.HashMap<java.lang.String, sun.security.util.ManifestDigester$Entry> r0 = r0.entries     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r17 = r0
            java.lang.String r18 = r9.toString()     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            sun.security.util.ManifestDigester$Entry r19 = new sun.security.util.ManifestDigester$Entry     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r0 = r24
            byte[] r0 = r0.rawBytes     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r20 = r0
            r0 = r19
            r1 = r20
            r0.<init>(r13, r11, r12, r1)     // Catch:{ UnsupportedEncodingException -> 0x0145 }
            r17.put(r18, r19)     // Catch:{ UnsupportedEncodingException -> 0x0145 }
        L_0x0141:
            int r13 = r10.startOfNext
            goto L_0x005a
        L_0x0145:
            r14 = move-exception
            java.lang.IllegalStateException r17 = new java.lang.IllegalStateException
            java.lang.String r18 = "UTF8 not available on platform"
            r17.<init>((java.lang.String) r18)
            throw r17
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.util.ManifestDigester.<init>(byte[]):void");
    }

    private boolean isNameAttr(byte[] bytes, int start) {
        if (bytes[start] != 78 && bytes[start] != 110) {
            return false;
        }
        if (bytes[start + 1] != 97 && bytes[start + 1] != 65) {
            return false;
        }
        if (bytes[start + 2] == 109 || bytes[start + 2] == 77) {
            return (bytes[start + 3] == 101 || bytes[start + 3] == 69) && bytes[start + 4] == 58 && bytes[start + 5] == 32;
        }
        return false;
    }

    public static class Entry {
        int length;
        int lengthWithBlankLine;
        int offset;
        boolean oldStyle;
        byte[] rawBytes;

        public Entry(int offset2, int length2, int lengthWithBlankLine2, byte[] rawBytes2) {
            this.offset = offset2;
            this.length = length2;
            this.lengthWithBlankLine = lengthWithBlankLine2;
            this.rawBytes = rawBytes2;
        }

        public byte[] digest(MessageDigest md) {
            md.reset();
            if (this.oldStyle) {
                doOldStyle(md, this.rawBytes, this.offset, this.lengthWithBlankLine);
            } else {
                md.update(this.rawBytes, this.offset, this.lengthWithBlankLine);
            }
            return md.digest();
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v2, types: [byte] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void doOldStyle(java.security.MessageDigest r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                r0 = r9
                r3 = r9
                int r1 = r9 + r10
                r2 = -1
            L_0x0005:
                if (r0 >= r1) goto L_0x001e
                byte r4 = r8[r0]
                r5 = 13
                if (r4 != r5) goto L_0x0019
                r4 = 32
                if (r2 != r4) goto L_0x0019
                int r4 = r0 - r3
                int r4 = r4 + -1
                r7.update(r8, r3, r4)
                r3 = r0
            L_0x0019:
                byte r2 = r8[r0]
                int r0 = r0 + 1
                goto L_0x0005
            L_0x001e:
                int r4 = r0 - r3
                r7.update(r8, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.util.ManifestDigester.Entry.doOldStyle(java.security.MessageDigest, byte[], int, int):void");
        }

        public byte[] digestWorkaround(MessageDigest md) {
            md.reset();
            md.update(this.rawBytes, this.offset, this.length);
            return md.digest();
        }
    }

    public Entry get(String name, boolean oldStyle) {
        Entry e = this.entries.get(name);
        if (e != null) {
            e.oldStyle = oldStyle;
        }
        return e;
    }

    public byte[] manifestDigest(MessageDigest md) {
        md.reset();
        md.update(this.rawBytes, 0, this.rawBytes.length);
        return md.digest();
    }
}
