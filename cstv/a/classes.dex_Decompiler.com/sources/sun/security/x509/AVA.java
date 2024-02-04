package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import sun.security.pkcs.PKCS9Attribute;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

public class AVA implements DerEncoder {
    static final int DEFAULT = 1;
    private static final boolean PRESERVE_OLD_DC_ENCODING = false;
    static final int RFC1779 = 2;
    static final int RFC2253 = 3;
    private static final Debug debug = null;
    private static final String hexDigits = "0123456789ABCDEF";
    private static final String specialChars = ",+=\n<>#;";
    private static final String specialChars2253 = ",+\"\\<>;";
    private static final String specialCharsAll = ",=\n+<>#;\\\" ";
    final ObjectIdentifier oid;
    final DerValue value;

    public AVA(ObjectIdentifier type, DerValue val) {
        if (type == null || val == null) {
            throw new NullPointerException();
        }
        this.oid = type;
        this.value = val;
    }

    AVA(Reader in) throws IOException {
        this(in, 1);
    }

    AVA(Reader in, Map<String, String> keywordMap) throws IOException {
        this(in, 1, keywordMap);
    }

    AVA(Reader in, int format) throws IOException {
        this(in, format, Collections.emptyMap());
    }

    AVA(Reader in, int format, Map<String, String> keywordMap) throws IOException {
        int c;
        StringBuilder temp = new StringBuilder();
        while (true) {
            int c2 = readChar(in, "Incorrect AVA format");
            if (c2 == 61) {
                break;
            }
            temp.append((char) c2);
        }
        this.oid = AVAKeyword.getOID(temp.toString(), format, keywordMap);
        temp.setLength(0);
        if (format != 3) {
            while (true) {
                c = in.read();
                if (c != 32 && c != 10) {
                    break;
                }
            }
        } else {
            c = in.read();
            if (c == 32) {
                throw new IOException("Incorrect AVA RFC2253 format - leading space must be escaped");
            }
        }
        if (c == -1) {
            this.value = new DerValue("");
        } else if (c == 35) {
            this.value = parseHexString(in, format);
        } else if (c != 34 || format == 3) {
            this.value = parseString(in, c, format, temp);
        } else {
            this.value = parseQuotedString(in, temp);
        }
    }

    public ObjectIdentifier getObjectIdentifier() {
        return this.oid;
    }

    public DerValue getDerValue() {
        return this.value;
    }

    public String getValueString() {
        try {
            String s = this.value.getAsString();
            if (s != null) {
                return s;
            }
            throw new RuntimeException("AVA string is null");
        } catch (IOException e) {
            throw new RuntimeException("AVA error: " + e, e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        throw new java.io.IOException("AVA parse, invalid hex digit: " + ((char) r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r2 = r10.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        if (isTerminator(r2, r11) != false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r2 == 32) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r2 == 10) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static sun.security.util.DerValue parseHexString(java.io.Reader r10, int r11) throws java.io.IOException {
        /*
            r9 = 32
            r8 = 10
            r7 = 1
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r0 = 0
            r3 = 0
        L_0x000c:
            int r2 = r10.read()
            boolean r5 = isTerminator(r2, r11)
            if (r5 == 0) goto L_0x0021
        L_0x0016:
            if (r3 != 0) goto L_0x008a
            java.io.IOException r5 = new java.io.IOException
            java.lang.String r6 = "AVA parse, zero hex digits"
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0021:
            if (r2 == r9) goto L_0x0025
            if (r2 != r8) goto L_0x004f
        L_0x0025:
            if (r2 == r9) goto L_0x0044
            if (r2 == r8) goto L_0x0044
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "AVA parse, invalid hex digit: "
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)
            char r7 = (char) r2
            java.lang.StringBuilder r6 = r6.append((char) r7)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0044:
            int r2 = r10.read()
            boolean r5 = isTerminator(r2, r11)
            if (r5 != 0) goto L_0x0016
            goto L_0x0025
        L_0x004f:
            java.lang.String r5 = "0123456789ABCDEF"
            char r6 = (char) r2
            char r6 = java.lang.Character.toUpperCase((char) r6)
            int r4 = r5.indexOf((int) r6)
            r5 = -1
            if (r4 != r5) goto L_0x0079
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "AVA parse, invalid hex digit: "
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)
            char r7 = (char) r2
            java.lang.StringBuilder r6 = r6.append((char) r7)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0079:
            int r5 = r3 % 2
            if (r5 != r7) goto L_0x0088
            int r5 = r0 * 16
            byte r6 = (byte) r4
            int r5 = r5 + r6
            byte r0 = (byte) r5
            r1.write(r0)
        L_0x0085:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0088:
            byte r0 = (byte) r4
            goto L_0x0085
        L_0x008a:
            int r5 = r3 % 2
            if (r5 != r7) goto L_0x0097
            java.io.IOException r5 = new java.io.IOException
            java.lang.String r6 = "AVA parse, odd number of hex digits"
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0097:
            sun.security.util.DerValue r5 = new sun.security.util.DerValue
            byte[] r6 = r1.toByteArray()
            r5.<init>((byte[]) r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.AVA.parseHexString(java.io.Reader, int):sun.security.util.DerValue");
    }

    private DerValue parseQuotedString(Reader in, StringBuilder temp) throws IOException {
        int c;
        int c2 = readChar(in, "Quoted string did not end in quote");
        List<Byte> embeddedHex = new ArrayList<>();
        boolean z = true;
        while (c2 != 34) {
            if (c2 == 92) {
                c2 = readChar(in, "Quoted string did not end in quote");
                Byte hexByte = getEmbeddedHexPair(c2, in);
                if (hexByte != null) {
                    z = PRESERVE_OLD_DC_ENCODING;
                    embeddedHex.add(hexByte);
                    c2 = in.read();
                } else if (!(c2 == 92 || c2 == 34 || specialChars.indexOf((int) (char) c2) >= 0)) {
                    throw new IOException("Invalid escaped character in AVA: " + ((char) c2));
                }
            }
            if (embeddedHex.size() > 0) {
                temp.append(getEmbeddedHexString(embeddedHex));
                embeddedHex.clear();
            }
            z &= DerValue.isPrintableStringChar((char) c2);
            temp.append((char) c2);
            c2 = readChar(in, "Quoted string did not end in quote");
        }
        if (embeddedHex.size() > 0) {
            temp.append(getEmbeddedHexString(embeddedHex));
            embeddedHex.clear();
        }
        while (true) {
            c = in.read();
            if (c != 10 && c != 32) {
                break;
            }
        }
        if (c != -1) {
            throw new IOException("AVA had characters other than whitespace after terminating quote");
        } else if (this.oid.equals(PKCS9Attribute.EMAIL_ADDRESS_OID) || (this.oid.equals(X500Name.DOMAIN_COMPONENT_OID) && !PRESERVE_OLD_DC_ENCODING)) {
            return new DerValue((byte) 22, temp.toString());
        } else {
            if (z) {
                return new DerValue(temp.toString());
            }
            return new DerValue((byte) 12, temp.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0139 A[LOOP:2: B:63:0x0137->B:64:0x0139, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private sun.security.util.DerValue parseString(java.io.Reader r12, int r13, int r14, java.lang.StringBuilder r15) throws java.io.IOException {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5 = 1
            r1 = 0
            r6 = 1
            r7 = 0
        L_0x0009:
            r1 = 0
            r8 = 92
            if (r13 != r8) goto L_0x00e6
            r1 = 1
            java.lang.String r8 = "Invalid trailing backslash"
            int r13 = readChar(r12, r8)
            r2 = 0
            java.lang.Byte r2 = getEmbeddedHexPair(r13, r12)
            if (r2 == 0) goto L_0x003a
            r5 = 0
            r0.add(r2)
            int r13 = r12.read()
            r6 = 0
        L_0x0026:
            boolean r8 = isTerminator(r13, r14)
            if (r8 == 0) goto L_0x0009
            r8 = 3
            if (r14 != r8) goto L_0x0148
            if (r7 <= 0) goto L_0x0148
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "Incorrect AVA RFC2253 format - trailing space must be escaped"
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x003a:
            r8 = 1
            if (r14 != r8) goto L_0x006a
            java.lang.String r8 = ",=\n+<>#;\\\" "
            char r9 = (char) r13
            int r8 = r8.indexOf((int) r9)
            r9 = -1
            if (r8 != r9) goto L_0x006a
        L_0x0048:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Invalid escaped character in AVA: '"
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            char r10 = (char) r13
            java.lang.StringBuilder r9 = r9.append((char) r10)
            java.lang.String r10 = "'"
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            java.lang.String r9 = r9.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x006a:
            r8 = 2
            if (r14 != r8) goto L_0x0080
            java.lang.String r8 = ",+=\n<>#;"
            char r9 = (char) r13
            int r8 = r8.indexOf((int) r9)
            r9 = -1
            if (r8 != r9) goto L_0x0080
            r8 = 92
            if (r13 == r8) goto L_0x0080
            r8 = 34
            if (r13 != r8) goto L_0x0048
        L_0x0080:
            r8 = 3
            if (r14 != r8) goto L_0x008f
            r8 = 32
            if (r13 != r8) goto L_0x00aa
            if (r6 != 0) goto L_0x008f
            boolean r8 = trailingSpace(r12)
            if (r8 == 0) goto L_0x00a1
        L_0x008f:
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x0121
            r4 = 0
        L_0x0096:
            if (r4 >= r7) goto L_0x0116
            java.lang.String r8 = " "
            r15.append((java.lang.String) r8)
            int r4 = r4 + 1
            goto L_0x0096
        L_0x00a1:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "Invalid escaped space character in AVA.  Only a leading or trailing space character can be escaped."
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x00aa:
            r8 = 35
            if (r13 != r8) goto L_0x00b9
            if (r6 != 0) goto L_0x008f
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "Invalid escaped '#' character in AVA.  Only a leading '#' can be escaped."
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x00b9:
            java.lang.String r8 = ",+\"\\<>;"
            char r9 = (char) r13
            int r8 = r8.indexOf((int) r9)
            r9 = -1
            if (r8 != r9) goto L_0x008f
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Invalid escaped character in AVA: '"
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            char r10 = (char) r13
            java.lang.StringBuilder r9 = r9.append((char) r10)
            java.lang.String r10 = "'"
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            java.lang.String r9 = r9.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x00e6:
            r8 = 3
            if (r14 != r8) goto L_0x008f
            java.lang.String r8 = ",+\"\\<>;"
            char r9 = (char) r13
            int r8 = r8.indexOf((int) r9)
            r9 = -1
            if (r8 == r9) goto L_0x008f
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Character '"
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            char r10 = (char) r13
            java.lang.StringBuilder r9 = r9.append((char) r10)
            java.lang.String r10 = "' in AVA appears without escape"
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            java.lang.String r9 = r9.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x0116:
            r7 = 0
            java.lang.String r3 = getEmbeddedHexString(r0)
            r15.append((java.lang.String) r3)
            r0.clear()
        L_0x0121:
            char r8 = (char) r13
            boolean r8 = sun.security.util.DerValue.isPrintableStringChar(r8)
            r5 = r5 & r8
            r8 = 32
            if (r13 != r8) goto L_0x0136
            if (r1 != 0) goto L_0x0136
            int r7 = r7 + 1
        L_0x012f:
            int r13 = r12.read()
            r6 = 0
            goto L_0x0026
        L_0x0136:
            r4 = 0
        L_0x0137:
            if (r4 >= r7) goto L_0x0142
            java.lang.String r8 = " "
            r15.append((java.lang.String) r8)
            int r4 = r4 + 1
            goto L_0x0137
        L_0x0142:
            r7 = 0
            char r8 = (char) r13
            r15.append((char) r8)
            goto L_0x012f
        L_0x0148:
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x0158
            java.lang.String r3 = getEmbeddedHexString(r0)
            r15.append((java.lang.String) r3)
            r0.clear()
        L_0x0158:
            sun.security.util.ObjectIdentifier r8 = r11.oid
            sun.security.util.ObjectIdentifier r9 = sun.security.pkcs.PKCS9Attribute.EMAIL_ADDRESS_OID
            boolean r8 = r8.equals((sun.security.util.ObjectIdentifier) r9)
            if (r8 != 0) goto L_0x0170
            sun.security.util.ObjectIdentifier r8 = r11.oid
            sun.security.util.ObjectIdentifier r9 = sun.security.x509.X500Name.DOMAIN_COMPONENT_OID
            boolean r8 = r8.equals((sun.security.util.ObjectIdentifier) r9)
            if (r8 == 0) goto L_0x017c
            boolean r8 = PRESERVE_OLD_DC_ENCODING
            if (r8 != 0) goto L_0x017c
        L_0x0170:
            sun.security.util.DerValue r8 = new sun.security.util.DerValue
            java.lang.String r9 = r15.toString()
            r10 = 22
            r8.<init>((byte) r10, (java.lang.String) r9)
            return r8
        L_0x017c:
            if (r5 == 0) goto L_0x0188
            sun.security.util.DerValue r8 = new sun.security.util.DerValue
            java.lang.String r9 = r15.toString()
            r8.<init>((java.lang.String) r9)
            return r8
        L_0x0188:
            sun.security.util.DerValue r8 = new sun.security.util.DerValue
            java.lang.String r9 = r15.toString()
            r10 = 12
            r8.<init>((byte) r10, (java.lang.String) r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.AVA.parseString(java.io.Reader, int, int, java.lang.StringBuilder):sun.security.util.DerValue");
    }

    private static Byte getEmbeddedHexPair(int c1, Reader in) throws IOException {
        if (hexDigits.indexOf((int) Character.toUpperCase((char) c1)) < 0) {
            return null;
        }
        int c2 = readChar(in, "unexpected EOF - escaped hex value must include two valid digits");
        if (hexDigits.indexOf((int) Character.toUpperCase((char) c2)) >= 0) {
            return new Byte((byte) ((Character.digit((char) c1, 16) << 4) + Character.digit((char) c2, 16)));
        }
        throw new IOException("escaped hex value must include two valid digits");
    }

    private static String getEmbeddedHexString(List<Byte> hexList) throws IOException {
        int n = hexList.size();
        byte[] hexBytes = new byte[n];
        for (int i = 0; i < n; i++) {
            hexBytes[i] = hexList.get(i).byteValue();
        }
        return new String(hexBytes, "UTF8");
    }

    private static boolean isTerminator(int ch, int format) {
        switch (ch) {
            case -1:
            case 43:
            case 44:
                return true;
            case 59:
            case 62:
                if (format != 3) {
                    return true;
                }
                return PRESERVE_OLD_DC_ENCODING;
            default:
                return PRESERVE_OLD_DC_ENCODING;
        }
    }

    private static int readChar(Reader in, String errMsg) throws IOException {
        int c = in.read();
        if (c != -1) {
            return c;
        }
        throw new IOException(errMsg);
    }

    private static boolean trailingSpace(Reader in) throws IOException {
        boolean trailing;
        if (!in.markSupported()) {
            return true;
        }
        in.mark(9999);
        while (true) {
            int nextChar = in.read();
            if (nextChar != -1) {
                if (nextChar != 32) {
                    if (nextChar != 92) {
                        trailing = PRESERVE_OLD_DC_ENCODING;
                        break;
                    } else if (in.read() != 32) {
                        trailing = PRESERVE_OLD_DC_ENCODING;
                        break;
                    }
                }
            } else {
                trailing = true;
                break;
            }
        }
        in.reset();
        return trailing;
    }

    AVA(DerValue derval) throws IOException {
        if (derval.tag != 48) {
            throw new IOException("AVA not a sequence");
        }
        this.oid = X500Name.intern(derval.data.getOID());
        this.value = derval.data.getDerValue();
        if (derval.data.available() != 0) {
            throw new IOException("AVA, extra bytes = " + derval.data.available());
        }
    }

    AVA(DerInputStream in) throws IOException {
        this(in.getDerValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AVA)) {
            return PRESERVE_OLD_DC_ENCODING;
        }
        return toRFC2253CanonicalString().equals(((AVA) obj).toRFC2253CanonicalString());
    }

    public int hashCode() {
        return toRFC2253CanonicalString().hashCode();
    }

    public void encode(DerOutputStream out) throws IOException {
        derEncode(out);
    }

    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        DerOutputStream tmp2 = new DerOutputStream();
        tmp.putOID(this.oid);
        this.value.encode(tmp);
        tmp2.write((byte) 48, tmp);
        out.write(tmp2.toByteArray());
    }

    private String toKeyword(int format, Map<String, String> oidMap) {
        return AVAKeyword.getKeyword(this.oid, format, oidMap);
    }

    public String toString() {
        return toKeywordValueString(toKeyword(1, Collections.emptyMap()));
    }

    public String toRFC1779String() {
        return toRFC1779String(Collections.emptyMap());
    }

    public String toRFC1779String(Map<String, String> oidMap) {
        return toKeywordValueString(toKeyword(2, oidMap));
    }

    public String toRFC2253String() {
        return toRFC2253String(Collections.emptyMap());
    }

    public String toRFC2253String(Map<String, String> oidMap) {
        StringBuilder typeAndValue = new StringBuilder(100);
        typeAndValue.append(toKeyword(3, oidMap));
        typeAndValue.append('=');
        if ((typeAndValue.charAt(0) < '0' || typeAndValue.charAt(0) > '9') && isDerString(this.value, PRESERVE_OLD_DC_ENCODING)) {
            try {
                String str = new String(this.value.getDataBytes(), "UTF8");
                StringBuilder sbuffer = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (DerValue.isPrintableStringChar(c) || ",=+<>#;\"\\".indexOf((int) c) >= 0) {
                        if (",=+<>#;\"\\".indexOf((int) c) >= 0) {
                            sbuffer.append('\\');
                        }
                        sbuffer.append(c);
                    } else if (c == 0) {
                        sbuffer.append("\\00");
                    } else if (debug == null || !Debug.isOn("ava")) {
                        sbuffer.append(c);
                    } else {
                        try {
                            byte[] valueBytes = Character.toString(c).getBytes("UTF8");
                            for (int j = 0; j < valueBytes.length; j++) {
                                sbuffer.append('\\');
                                sbuffer.append(Character.toUpperCase(Character.forDigit((valueBytes[j] >>> 4) & 15, 16)));
                                sbuffer.append(Character.toUpperCase(Character.forDigit(valueBytes[j] & 15, 16)));
                            }
                        } catch (IOException e) {
                            throw new IllegalArgumentException("DER Value conversion");
                        }
                    }
                }
                char[] chars = sbuffer.toString().toCharArray();
                StringBuilder sbuffer2 = new StringBuilder();
                int lead = 0;
                while (lead < chars.length && (chars[lead] == ' ' || chars[lead] == 13)) {
                    lead++;
                }
                int trail = chars.length - 1;
                while (trail >= 0 && (chars[trail] == ' ' || chars[trail] == 13)) {
                    trail--;
                }
                for (int i2 = 0; i2 < chars.length; i2++) {
                    char c2 = chars[i2];
                    if (i2 < lead || i2 > trail) {
                        sbuffer2.append('\\');
                    }
                    sbuffer2.append(c2);
                }
                typeAndValue.append(sbuffer2.toString());
            } catch (IOException e2) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        } else {
            try {
                byte[] data = this.value.toByteArray();
                typeAndValue.append('#');
                for (byte b : data) {
                    typeAndValue.append(Character.forDigit((b >>> 4) & 15, 16));
                    typeAndValue.append(Character.forDigit(b & 15, 16));
                }
            } catch (IOException e3) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        }
        return typeAndValue.toString();
    }

    public String toRFC2253CanonicalString() {
        StringBuilder typeAndValue = new StringBuilder(40);
        typeAndValue.append(toKeyword(3, Collections.emptyMap()));
        typeAndValue.append('=');
        if ((typeAndValue.charAt(0) < '0' || typeAndValue.charAt(0) > '9') && (isDerString(this.value, true) || this.value.tag == 20)) {
            try {
                String valStr = new String(this.value.getDataBytes(), "UTF8");
                StringBuilder sbuffer = new StringBuilder();
                boolean previousWhite = PRESERVE_OLD_DC_ENCODING;
                for (int i = 0; i < valStr.length(); i++) {
                    char c = valStr.charAt(i);
                    if (DerValue.isPrintableStringChar(c) || ",+<>;\"\\".indexOf((int) c) >= 0 || (i == 0 && c == '#')) {
                        if ((i == 0 && c == '#') || ",+<>;\"\\".indexOf((int) c) >= 0) {
                            sbuffer.append('\\');
                        }
                        if (!Character.isWhitespace(c)) {
                            previousWhite = PRESERVE_OLD_DC_ENCODING;
                            sbuffer.append(c);
                        } else if (!previousWhite) {
                            previousWhite = true;
                            sbuffer.append(c);
                        }
                    } else if (debug == null || !Debug.isOn("ava")) {
                        previousWhite = PRESERVE_OLD_DC_ENCODING;
                        sbuffer.append(c);
                    } else {
                        previousWhite = PRESERVE_OLD_DC_ENCODING;
                        try {
                            byte[] valueBytes = Character.toString(c).getBytes("UTF8");
                            for (int j = 0; j < valueBytes.length; j++) {
                                sbuffer.append('\\');
                                sbuffer.append(Character.forDigit((valueBytes[j] >>> 4) & 15, 16));
                                sbuffer.append(Character.forDigit(valueBytes[j] & 15, 16));
                            }
                        } catch (IOException e) {
                            throw new IllegalArgumentException("DER Value conversion");
                        }
                    }
                }
                typeAndValue.append(sbuffer.toString().trim());
            } catch (IOException e2) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        } else {
            try {
                byte[] data = this.value.toByteArray();
                typeAndValue.append('#');
                for (byte b : data) {
                    typeAndValue.append(Character.forDigit((b >>> 4) & 15, 16));
                    typeAndValue.append(Character.forDigit(b & 15, 16));
                }
            } catch (IOException e3) {
                throw new IllegalArgumentException("DER Value conversion");
            }
        }
        return Normalizer.normalize(typeAndValue.toString().toUpperCase(Locale.US).toLowerCase(Locale.US), Normalizer.Form.NFKD);
    }

    private static boolean isDerString(DerValue value2, boolean canonical) {
        if (canonical) {
            switch (value2.tag) {
                case 12:
                case DigitList.MAX_COUNT:
                    return true;
                default:
                    return PRESERVE_OLD_DC_ENCODING;
            }
        } else {
            switch (value2.tag) {
                case 12:
                case DigitList.MAX_COUNT:
                case 20:
                case 22:
                case 27:
                case 30:
                    return true;
                default:
                    return PRESERVE_OLD_DC_ENCODING;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasRFC2253Keyword() {
        return AVAKeyword.hasKeyword(this.oid, 3);
    }

    private String toKeywordValueString(String keyword) {
        boolean alreadyQuoted;
        char trailChar;
        StringBuilder retval = new StringBuilder(40);
        retval.append(keyword);
        retval.append("=");
        try {
            String valStr = this.value.getAsString();
            if (valStr == null) {
                byte[] data = this.value.toByteArray();
                retval.append('#');
                for (int i = 0; i < data.length; i++) {
                    retval.append(hexDigits.charAt((data[i] >> 4) & 15));
                    retval.append(hexDigits.charAt(data[i] & 15));
                }
            } else {
                boolean quoteNeeded = PRESERVE_OLD_DC_ENCODING;
                StringBuilder sbuffer = new StringBuilder();
                boolean previousWhite = PRESERVE_OLD_DC_ENCODING;
                int length = valStr.length();
                if (length <= 1 || valStr.charAt(0) != '\"') {
                    alreadyQuoted = PRESERVE_OLD_DC_ENCODING;
                } else {
                    alreadyQuoted = valStr.charAt(length + -1) == '\"' ? true : PRESERVE_OLD_DC_ENCODING;
                }
                for (int i2 = 0; i2 < length; i2++) {
                    char c = valStr.charAt(i2);
                    if (alreadyQuoted && (i2 == 0 || i2 == length - 1)) {
                        sbuffer.append(c);
                    } else if (DerValue.isPrintableStringChar(c) || ",+=\n<>#;\\\"".indexOf((int) c) >= 0) {
                        if (!quoteNeeded) {
                            if (!(i2 == 0 && (c == ' ' || c == 10))) {
                                if (",+=\n<>#;\\\"".indexOf((int) c) >= 0) {
                                }
                            }
                            quoteNeeded = true;
                        }
                        if (c == ' ' || c == 10) {
                            if (!quoteNeeded && previousWhite) {
                                quoteNeeded = true;
                            }
                            previousWhite = true;
                        } else {
                            if (c == '\"' || c == '\\') {
                                sbuffer.append('\\');
                            }
                            previousWhite = PRESERVE_OLD_DC_ENCODING;
                        }
                        sbuffer.append(c);
                    } else if (debug == null || !Debug.isOn("ava")) {
                        previousWhite = PRESERVE_OLD_DC_ENCODING;
                        sbuffer.append(c);
                    } else {
                        previousWhite = PRESERVE_OLD_DC_ENCODING;
                        byte[] valueBytes = Character.toString(c).getBytes("UTF8");
                        for (int j = 0; j < valueBytes.length; j++) {
                            sbuffer.append('\\');
                            sbuffer.append(Character.toUpperCase(Character.forDigit((valueBytes[j] >>> 4) & 15, 16)));
                            sbuffer.append(Character.toUpperCase(Character.forDigit(valueBytes[j] & 15, 16)));
                        }
                    }
                }
                if (sbuffer.length() > 0 && ((trailChar = sbuffer.charAt(sbuffer.length() - 1)) == ' ' || trailChar == 10)) {
                    quoteNeeded = true;
                }
                if (alreadyQuoted || !quoteNeeded) {
                    retval.append(sbuffer.toString());
                } else {
                    retval.append("\"").append(sbuffer.toString()).append("\"");
                }
            }
            return retval.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("DER Value conversion");
        }
    }
}
