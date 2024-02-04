package sun.security.util;

import java.io.IOException;
import java.util.ArrayList;

class DerIndefLenConverter {
    private static final int CLASS_MASK = 192;
    private static final int FORM_MASK = 32;
    private static final int LEN_LONG = 128;
    private static final int LEN_MASK = 127;
    private static final int SKIP_EOC_BYTES = 2;
    private static final int TAG_MASK = 31;
    private byte[] data;
    private int dataPos;
    private int dataSize;
    private int index;
    private ArrayList<Object> ndefsList = new ArrayList<>();
    private byte[] newData;
    private int newDataPos;
    private int numOfTotalLenBytes = 0;
    private int unresolved = 0;

    private boolean isEOC(int tag) {
        if ((tag & 31) == 0 && (tag & 32) == 0 && (tag & CLASS_MASK) == 0) {
            return true;
        }
        return false;
    }

    static boolean isLongForm(int lengthByte) {
        return (lengthByte & 128) == 128;
    }

    DerIndefLenConverter() {
    }

    static boolean isIndefinite(int lengthByte) {
        return isLongForm(lengthByte) && (lengthByte & 127) == 0;
    }

    private void parseTag() throws IOException {
        if (this.dataPos != this.dataSize) {
            if (isEOC(this.data[this.dataPos]) && this.data[this.dataPos + 1] == 0) {
                int numOfEncapsulatedLenBytes = 0;
                Object elem = null;
                int index2 = this.ndefsList.size() - 1;
                while (index2 >= 0) {
                    elem = this.ndefsList.get(index2);
                    if (elem instanceof Integer) {
                        break;
                    }
                    numOfEncapsulatedLenBytes += ((byte[]) elem).length - 3;
                    index2--;
                }
                if (index2 < 0) {
                    throw new IOException("EOC does not have matching indefinite-length tag");
                }
                byte[] sectionLenBytes = getLengthBytes((this.dataPos - ((Integer) elem).intValue()) + numOfEncapsulatedLenBytes);
                this.ndefsList.set(index2, sectionLenBytes);
                this.unresolved--;
                this.numOfTotalLenBytes += sectionLenBytes.length - 3;
            }
            this.dataPos++;
        }
    }

    private void writeTag() {
        if (this.dataPos != this.dataSize) {
            byte[] bArr = this.data;
            int i = this.dataPos;
            this.dataPos = i + 1;
            byte tag = bArr[i];
            if (!isEOC(tag) || this.data[this.dataPos] != 0) {
                byte[] bArr2 = this.newData;
                int i2 = this.newDataPos;
                this.newDataPos = i2 + 1;
                bArr2[i2] = (byte) tag;
                return;
            }
            this.dataPos++;
            writeTag();
        }
    }

    private int parseLength() throws IOException {
        int curLen = 0;
        if (this.dataPos == this.dataSize) {
            return 0;
        }
        byte[] bArr = this.data;
        int i = this.dataPos;
        this.dataPos = i + 1;
        int lenByte = bArr[i] & 255;
        if (isIndefinite(lenByte)) {
            this.ndefsList.add(new Integer(this.dataPos));
            this.unresolved++;
            return 0;
        } else if (!isLongForm(lenByte)) {
            return lenByte & 127;
        } else {
            int lenByte2 = lenByte & 127;
            if (lenByte2 > 4) {
                throw new IOException("Too much data");
            } else if (this.dataSize - this.dataPos < lenByte2 + 1) {
                throw new IOException("Too little data");
            } else {
                for (int i2 = 0; i2 < lenByte2; i2++) {
                    byte[] bArr2 = this.data;
                    int i3 = this.dataPos;
                    this.dataPos = i3 + 1;
                    curLen = (curLen << 8) + (bArr2[i3] & Character.DIRECTIONALITY_UNDEFINED);
                }
                if (curLen >= 0) {
                    return curLen;
                }
                throw new IOException("Invalid length bytes");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeLengthAndValue() throws java.io.IOException {
        /*
            r8 = this;
            r7 = 0
            int r4 = r8.dataPos
            int r5 = r8.dataSize
            if (r4 != r5) goto L_0x0008
            return
        L_0x0008:
            r0 = 0
            byte[] r4 = r8.data
            int r5 = r8.dataPos
            int r6 = r5 + 1
            r8.dataPos = r6
            byte r4 = r4[r5]
            r2 = r4 & 255(0xff, float:3.57E-43)
            boolean r4 = isIndefinite(r2)
            if (r4 == 0) goto L_0x0038
            java.util.ArrayList<java.lang.Object> r4 = r8.ndefsList
            int r5 = r8.index
            int r6 = r5 + 1
            r8.index = r6
            java.lang.Object r3 = r4.get(r5)
            byte[] r3 = (byte[]) r3
            byte[] r4 = r8.newData
            int r5 = r8.newDataPos
            int r6 = r3.length
            java.lang.System.arraycopy((byte[]) r3, (int) r7, (byte[]) r4, (int) r5, (int) r6)
            int r4 = r8.newDataPos
            int r5 = r3.length
            int r4 = r4 + r5
            r8.newDataPos = r4
            return
        L_0x0038:
            boolean r4 = isLongForm(r2)
            if (r4 == 0) goto L_0x0061
            r2 = r2 & 127(0x7f, float:1.78E-43)
            r1 = 0
        L_0x0041:
            if (r1 >= r2) goto L_0x0056
            int r4 = r0 << 8
            byte[] r5 = r8.data
            int r6 = r8.dataPos
            int r7 = r6 + 1
            r8.dataPos = r7
            byte r5 = r5[r6]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r0 = r4 + r5
            int r1 = r1 + 1
            goto L_0x0041
        L_0x0056:
            if (r0 >= 0) goto L_0x0063
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "Invalid length bytes"
            r4.<init>((java.lang.String) r5)
            throw r4
        L_0x0061:
            r0 = r2 & 127(0x7f, float:1.78E-43)
        L_0x0063:
            r8.writeLength(r0)
            r8.writeValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.util.DerIndefLenConverter.writeLengthAndValue():void");
    }

    private void writeLength(int curLen) {
        if (curLen < 128) {
            byte[] bArr = this.newData;
            int i = this.newDataPos;
            this.newDataPos = i + 1;
            bArr[i] = (byte) curLen;
        } else if (curLen < 256) {
            byte[] bArr2 = this.newData;
            int i2 = this.newDataPos;
            this.newDataPos = i2 + 1;
            bArr2[i2] = -127;
            byte[] bArr3 = this.newData;
            int i3 = this.newDataPos;
            this.newDataPos = i3 + 1;
            bArr3[i3] = (byte) curLen;
        } else if (curLen < 65536) {
            byte[] bArr4 = this.newData;
            int i4 = this.newDataPos;
            this.newDataPos = i4 + 1;
            bArr4[i4] = -126;
            byte[] bArr5 = this.newData;
            int i5 = this.newDataPos;
            this.newDataPos = i5 + 1;
            bArr5[i5] = (byte) (curLen >> 8);
            byte[] bArr6 = this.newData;
            int i6 = this.newDataPos;
            this.newDataPos = i6 + 1;
            bArr6[i6] = (byte) curLen;
        } else if (curLen < 16777216) {
            byte[] bArr7 = this.newData;
            int i7 = this.newDataPos;
            this.newDataPos = i7 + 1;
            bArr7[i7] = -125;
            byte[] bArr8 = this.newData;
            int i8 = this.newDataPos;
            this.newDataPos = i8 + 1;
            bArr8[i8] = (byte) (curLen >> 16);
            byte[] bArr9 = this.newData;
            int i9 = this.newDataPos;
            this.newDataPos = i9 + 1;
            bArr9[i9] = (byte) (curLen >> 8);
            byte[] bArr10 = this.newData;
            int i10 = this.newDataPos;
            this.newDataPos = i10 + 1;
            bArr10[i10] = (byte) curLen;
        } else {
            byte[] bArr11 = this.newData;
            int i11 = this.newDataPos;
            this.newDataPos = i11 + 1;
            bArr11[i11] = -124;
            byte[] bArr12 = this.newData;
            int i12 = this.newDataPos;
            this.newDataPos = i12 + 1;
            bArr12[i12] = (byte) (curLen >> 24);
            byte[] bArr13 = this.newData;
            int i13 = this.newDataPos;
            this.newDataPos = i13 + 1;
            bArr13[i13] = (byte) (curLen >> 16);
            byte[] bArr14 = this.newData;
            int i14 = this.newDataPos;
            this.newDataPos = i14 + 1;
            bArr14[i14] = (byte) (curLen >> 8);
            byte[] bArr15 = this.newData;
            int i15 = this.newDataPos;
            this.newDataPos = i15 + 1;
            bArr15[i15] = (byte) curLen;
        }
    }

    private byte[] getLengthBytes(int curLen) {
        if (curLen < 128) {
            return new byte[]{(byte) curLen};
        } else if (curLen < 256) {
            int i = 1 + 1;
            return new byte[]{-127, (byte) curLen};
        } else if (curLen < 65536) {
            byte[] lenBytes = new byte[3];
            lenBytes[0] = -126;
            int index2 = 1 + 1;
            lenBytes[1] = (byte) (curLen >> 8);
            int i2 = index2 + 1;
            lenBytes[index2] = (byte) curLen;
            return lenBytes;
        } else if (curLen < 16777216) {
            byte[] lenBytes2 = new byte[4];
            lenBytes2[0] = -125;
            int index3 = 1 + 1;
            lenBytes2[1] = (byte) (curLen >> 16);
            int index4 = index3 + 1;
            lenBytes2[index3] = (byte) (curLen >> 8);
            lenBytes2[index4] = (byte) curLen;
            int i3 = index4 + 1;
            return lenBytes2;
        } else {
            byte[] lenBytes3 = new byte[5];
            lenBytes3[0] = -124;
            int index5 = 1 + 1;
            lenBytes3[1] = (byte) (curLen >> 24);
            int index6 = index5 + 1;
            lenBytes3[index5] = (byte) (curLen >> 16);
            int index7 = index6 + 1;
            lenBytes3[index6] = (byte) (curLen >> 8);
            int i4 = index7 + 1;
            lenBytes3[index7] = (byte) curLen;
            return lenBytes3;
        }
    }

    private int getNumOfLenBytes(int len) {
        if (len < 128) {
            return 1;
        }
        if (len < 256) {
            return 2;
        }
        if (len < 65536) {
            return 3;
        }
        if (len < 16777216) {
            return 4;
        }
        return 5;
    }

    private void parseValue(int curLen) {
        this.dataPos += curLen;
    }

    private void writeValue(int curLen) {
        for (int i = 0; i < curLen; i++) {
            byte[] bArr = this.newData;
            int i2 = this.newDataPos;
            this.newDataPos = i2 + 1;
            byte[] bArr2 = this.data;
            int i3 = this.dataPos;
            this.dataPos = i3 + 1;
            bArr[i2] = bArr2[i3];
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] convert(byte[] indefData) throws IOException {
        this.data = indefData;
        this.dataPos = 0;
        this.index = 0;
        this.dataSize = this.data.length;
        int unused = 0;
        while (true) {
            if (this.dataPos >= this.dataSize) {
                break;
            }
            parseTag();
            parseValue(parseLength());
            if (this.unresolved == 0) {
                unused = this.dataSize - this.dataPos;
                this.dataSize = this.dataPos;
                break;
            }
        }
        if (this.unresolved != 0) {
            throw new IOException("not all indef len BER resolved");
        }
        this.newData = new byte[(this.dataSize + this.numOfTotalLenBytes + unused)];
        this.dataPos = 0;
        this.newDataPos = 0;
        this.index = 0;
        while (this.dataPos < this.dataSize) {
            writeTag();
            writeLengthAndValue();
        }
        System.arraycopy(indefData, this.dataSize, this.newData, this.dataSize + this.numOfTotalLenBytes, unused);
        return this.newData;
    }
}
