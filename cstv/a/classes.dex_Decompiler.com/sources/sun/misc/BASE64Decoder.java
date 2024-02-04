package sun.misc;

public class BASE64Decoder extends CharacterDecoder {
    private static final char[] pem_array = null;
    private static final byte[] pem_convert_array = null;
    byte[] decode_buffer = new byte[4];

    /* access modifiers changed from: protected */
    public int bytesPerAtom() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public int bytesPerLine() {
        return 72;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: CFG modification limit reached, blocks count: 136 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        switch(r15) {
            case 2: goto L_0x0083;
            case 3: goto L_0x0091;
            case 4: goto L_0x00ac;
            default: goto L_0x0059;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        r2 = pem_convert_array[r12.decode_buffer[2] & java.lang.Character.DIRECTIONALITY_UNDEFINED];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        r1 = pem_convert_array[r12.decode_buffer[1] & java.lang.Character.DIRECTIONALITY_UNDEFINED];
        r0 = pem_convert_array[r12.decode_buffer[0] & java.lang.Character.DIRECTIONALITY_UNDEFINED];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        r14.write((int) (byte) (((r0 << 2) & 252) | ((r1 >>> 4) & 3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r14.write((int) (byte) (((r0 << 2) & 252) | ((r1 >>> 4) & 3)));
        r14.write((int) (byte) (((r1 << 4) & 240) | ((r2 >>> 2) & 15)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ac, code lost:
        r14.write((int) (byte) (((r0 << 2) & 252) | ((r1 >>> 4) & 3)));
        r14.write((int) (byte) (((r1 << 4) & 240) | ((r2 >>> 2) & 15)));
        r14.write((int) (byte) (((r2 << 6) & sun.security.util.DerValue.TAG_PRIVATE) | (r3 & 63)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decodeAtom(java.io.PushbackInputStream r13, java.io.OutputStream r14, int r15) throws java.io.IOException {
        /*
            r12 = this;
            r11 = 1
            r10 = 0
            r9 = -1
            r8 = 3
            r7 = 2
            r0 = -1
            r1 = -1
            r2 = -1
            r3 = -1
            if (r15 >= r7) goto L_0x001c
            sun.misc.CEFormatException r5 = new sun.misc.CEFormatException
            java.lang.String r6 = "BASE64Decoder: Not enough bytes for an atom."
            r5.<init>(r6)
            throw r5
        L_0x0014:
            r5 = 10
            if (r4 == r5) goto L_0x001c
            r5 = 13
            if (r4 != r5) goto L_0x0028
        L_0x001c:
            int r4 = r13.read()
            if (r4 != r9) goto L_0x0014
            sun.misc.CEStreamExhausted r5 = new sun.misc.CEStreamExhausted
            r5.<init>()
            throw r5
        L_0x0028:
            byte[] r5 = r12.decode_buffer
            byte r6 = (byte) r4
            r5[r10] = r6
            byte[] r5 = r12.decode_buffer
            int r6 = r15 + -1
            int r4 = r12.readFully(r13, r5, r11, r6)
            if (r4 != r9) goto L_0x003d
            sun.misc.CEStreamExhausted r5 = new sun.misc.CEStreamExhausted
            r5.<init>()
            throw r5
        L_0x003d:
            if (r15 <= r8) goto L_0x0048
            byte[] r5 = r12.decode_buffer
            byte r5 = r5[r8]
            r6 = 61
            if (r5 != r6) goto L_0x0048
            r15 = 3
        L_0x0048:
            if (r15 <= r7) goto L_0x0053
            byte[] r5 = r12.decode_buffer
            byte r5 = r5[r7]
            r6 = 61
            if (r5 != r6) goto L_0x0053
            r15 = 2
        L_0x0053:
            switch(r15) {
                case 2: goto L_0x006e;
                case 3: goto L_0x0064;
                case 4: goto L_0x005a;
                default: goto L_0x0056;
            }
        L_0x0056:
            switch(r15) {
                case 2: goto L_0x0083;
                case 3: goto L_0x0091;
                case 4: goto L_0x00ac;
                default: goto L_0x0059;
            }
        L_0x0059:
            return
        L_0x005a:
            byte[] r5 = pem_convert_array
            byte[] r6 = r12.decode_buffer
            byte r6 = r6[r8]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r6]
        L_0x0064:
            byte[] r5 = pem_convert_array
            byte[] r6 = r12.decode_buffer
            byte r6 = r6[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r2 = r5[r6]
        L_0x006e:
            byte[] r5 = pem_convert_array
            byte[] r6 = r12.decode_buffer
            byte r6 = r6[r11]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r1 = r5[r6]
            byte[] r5 = pem_convert_array
            byte[] r6 = r12.decode_buffer
            byte r6 = r6[r10]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r0 = r5[r6]
            goto L_0x0056
        L_0x0083:
            int r5 = r0 << 2
            r5 = r5 & 252(0xfc, float:3.53E-43)
            int r6 = r1 >>> 4
            r6 = r6 & 3
            r5 = r5 | r6
            byte r5 = (byte) r5
            r14.write((int) r5)
            goto L_0x0059
        L_0x0091:
            int r5 = r0 << 2
            r5 = r5 & 252(0xfc, float:3.53E-43)
            int r6 = r1 >>> 4
            r6 = r6 & 3
            r5 = r5 | r6
            byte r5 = (byte) r5
            r14.write((int) r5)
            int r5 = r1 << 4
            r5 = r5 & 240(0xf0, float:3.36E-43)
            int r6 = r2 >>> 2
            r6 = r6 & 15
            r5 = r5 | r6
            byte r5 = (byte) r5
            r14.write((int) r5)
            goto L_0x0059
        L_0x00ac:
            int r5 = r0 << 2
            r5 = r5 & 252(0xfc, float:3.53E-43)
            int r6 = r1 >>> 4
            r6 = r6 & 3
            r5 = r5 | r6
            byte r5 = (byte) r5
            r14.write((int) r5)
            int r5 = r1 << 4
            r5 = r5 & 240(0xf0, float:3.36E-43)
            int r6 = r2 >>> 2
            r6 = r6 & 15
            r5 = r5 | r6
            byte r5 = (byte) r5
            r14.write((int) r5)
            int r5 = r2 << 6
            r5 = r5 & 192(0xc0, float:2.69E-43)
            r6 = r3 & 63
            r5 = r5 | r6
            byte r5 = (byte) r5
            r14.write((int) r5)
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.BASE64Decoder.decodeAtom(java.io.PushbackInputStream, java.io.OutputStream, int):void");
    }
}
