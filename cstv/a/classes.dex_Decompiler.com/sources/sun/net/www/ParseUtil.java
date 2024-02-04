package sun.net.www;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.BitSet;
import sun.nio.cs.ThreadLocalCoders;

public class ParseUtil {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f113assertionsDisabled = false;
    private static final long H_ALPHA = 0;
    private static final long H_ALPHANUM = 0;
    private static final long H_DASH = 0;
    private static final long H_DIGIT = 0;
    private static final long H_ESCAPED = 0;
    private static final long H_HEX = 0;
    private static final long H_LOWALPHA = 0;
    private static final long H_MARK = 0;
    private static final long H_PATH = 0;
    private static final long H_PCHAR = 0;
    private static final long H_REG_NAME = 0;
    private static final long H_RESERVED = 0;
    private static final long H_SERVER = 0;
    private static final long H_UNRESERVED = 0;
    private static final long H_UPALPHA = 0;
    private static final long H_URIC = 0;
    private static final long H_USERINFO = 0;
    private static final long L_ALPHA = 0;
    private static final long L_ALPHANUM = 0;
    private static final long L_DASH = 0;
    private static final long L_DIGIT = 0;
    private static final long L_ESCAPED = 1;
    private static final long L_HEX = 0;
    private static final long L_LOWALPHA = 0;
    private static final long L_MARK = 0;
    private static final long L_PATH = 0;
    private static final long L_PCHAR = 0;
    private static final long L_REG_NAME = 0;
    private static final long L_RESERVED = 0;
    private static final long L_SERVER = 0;
    private static final long L_UNRESERVED = 0;
    private static final long L_UPALPHA = 0;
    private static final long L_URIC = 0;
    private static final long L_USERINFO = 0;
    static BitSet encodedInPath;
    private static final char[] hexDigits = null;

    public static String encodePath(String path) {
        return encodePath(path, true);
    }

    public static String encodePath(String path, boolean flag) {
        int retLen;
        char[] retCC = new char[((path.length() * 2) + 16)];
        char[] pathCC = path.toCharArray();
        int n = path.length();
        int i = 0;
        int retLen2 = 0;
        while (i < n) {
            char c = pathCC[i];
            if ((!flag && c == '/') || (flag && c == File.separatorChar)) {
                retLen = retLen2 + 1;
                retCC[retLen2] = '/';
            } else if (c <= 127) {
                if ((c >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                    retLen = retLen2 + 1;
                    retCC[retLen2] = c;
                } else if (encodedInPath.get(c)) {
                    retLen = escape(retCC, c, retLen2);
                } else {
                    retLen = retLen2 + 1;
                    retCC[retLen2] = c;
                }
            } else if (c > 2047) {
                retLen = escape(retCC, (char) (((c >> 0) & 63) | 128), escape(retCC, (char) (((c >> 6) & 63) | 128), escape(retCC, (char) (((c >> 12) & 15) | 224), retLen2)));
            } else {
                retLen = escape(retCC, (char) (((c >> 0) & 63) | 128), escape(retCC, (char) (((c >> 6) & 31) | 192), retLen2));
            }
            if (retLen + 9 > retCC.length) {
                int newLen = (retCC.length * 2) + 16;
                if (newLen < 0) {
                    newLen = Integer.MAX_VALUE;
                }
                char[] buf = new char[newLen];
                System.arraycopy(retCC, 0, buf, 0, retLen);
                retCC = buf;
            }
            i++;
            retLen2 = retLen;
        }
        return new String(retCC, 0, retLen2);
    }

    private static int escape(char[] cc, char c, int index) {
        int index2 = index + 1;
        cc[index] = '%';
        int index3 = index2 + 1;
        cc[index2] = Character.forDigit((c >> 4) & 15, 16);
        int index4 = index3 + 1;
        cc[index3] = Character.forDigit(c & 15, 16);
        return index4;
    }

    private static byte unescape(String s, int i) {
        return (byte) Integer.parseInt(s.substring(i + 1, i + 3), 16);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decode(java.lang.String r15) {
        /*
            r14 = 37
            r11 = 1
            r12 = 0
            int r7 = r15.length()
            if (r7 == 0) goto L_0x0010
            int r10 = r15.indexOf((int) r14)
            if (r10 >= 0) goto L_0x0011
        L_0x0010:
            return r15
        L_0x0011:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>((int) r7)
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r7)
            java.nio.CharBuffer r2 = java.nio.CharBuffer.allocate(r7)
            java.lang.String r10 = "UTF-8"
            java.nio.charset.CharsetDecoder r10 = sun.nio.cs.ThreadLocalCoders.decoderFor(r10)
            java.nio.charset.CodingErrorAction r13 = java.nio.charset.CodingErrorAction.REPORT
            java.nio.charset.CharsetDecoder r10 = r10.onMalformedInput(r13)
            java.nio.charset.CodingErrorAction r13 = java.nio.charset.CodingErrorAction.REPORT
            java.nio.charset.CharsetDecoder r4 = r10.onUnmappableCharacter(r13)
            char r1 = r15.charAt(r12)
            r6 = 0
        L_0x0036:
            if (r6 >= r7) goto L_0x0056
            boolean r10 = f113assertionsDisabled
            if (r10 != 0) goto L_0x004d
            char r10 = r15.charAt(r6)
            if (r1 != r10) goto L_0x004b
            r10 = r11
        L_0x0043:
            if (r10 != 0) goto L_0x004d
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x004b:
            r10 = r12
            goto L_0x0043
        L_0x004d:
            if (r1 == r14) goto L_0x0060
            r8.append((char) r1)
            int r6 = r6 + 1
            if (r6 < r7) goto L_0x005b
        L_0x0056:
            java.lang.String r10 = r8.toString()
            return r10
        L_0x005b:
            char r1 = r15.charAt(r6)
            goto L_0x0036
        L_0x0060:
            r0.clear()
            r9 = r6
        L_0x0064:
            boolean r10 = f113assertionsDisabled
            if (r10 != 0) goto L_0x0078
            int r10 = r7 - r6
            r13 = 2
            if (r10 < r13) goto L_0x0076
            r10 = r11
        L_0x006e:
            if (r10 != 0) goto L_0x0078
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x0076:
            r10 = r12
            goto L_0x006e
        L_0x0078:
            byte r10 = unescape(r15, r6)     // Catch:{ NumberFormatException -> 0x009f }
            r0.put((byte) r10)     // Catch:{ NumberFormatException -> 0x009f }
            int r6 = r6 + 3
            if (r6 < r7) goto L_0x00a6
        L_0x0083:
            r0.flip()
            r2.clear()
            r4.reset()
            java.nio.charset.CoderResult r3 = r4.decode(r0, r2, r11)
            boolean r10 = r3.isError()
            if (r10 == 0) goto L_0x00ad
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Error decoding percent encoded characters"
            r10.<init>((java.lang.String) r11)
            throw r10
        L_0x009f:
            r5 = move-exception
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L_0x00a6:
            char r1 = r15.charAt(r6)
            if (r1 == r14) goto L_0x0064
            goto L_0x0083
        L_0x00ad:
            java.nio.charset.CoderResult r3 = r4.flush(r2)
            boolean r10 = r3.isError()
            if (r10 == 0) goto L_0x00c0
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Error decoding percent encoded characters"
            r10.<init>((java.lang.String) r11)
            throw r10
        L_0x00c0:
            java.nio.Buffer r10 = r2.flip()
            java.lang.String r10 = r10.toString()
            r8.append((java.lang.String) r10)
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.ParseUtil.decode(java.lang.String):java.lang.String");
    }

    public String canonizeString(String file) {
        int length = file.length();
        while (true) {
            int i = file.indexOf("/../");
            if (i < 0) {
                break;
            }
            int lim = file.lastIndexOf(47, i - 1);
            if (lim >= 0) {
                file = file.substring(0, lim) + file.substring(i + 3);
            } else {
                file = file.substring(i + 3);
            }
        }
        while (true) {
            int i2 = file.indexOf("/./");
            if (i2 < 0) {
                break;
            }
            file = file.substring(0, i2) + file.substring(i2 + 2);
        }
        while (file.endsWith("/..")) {
            int i3 = file.indexOf("/..");
            int lim2 = file.lastIndexOf(47, i3 - 1);
            if (lim2 >= 0) {
                file = file.substring(0, lim2 + 1);
            } else {
                file = file.substring(0, i3);
            }
        }
        if (file.endsWith("/.")) {
            return file.substring(0, file.length() - 1);
        }
        return file;
    }

    public static URL fileToEncodedURL(File file) throws MalformedURLException {
        String path = encodePath(file.getAbsolutePath());
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        if (!path.endsWith("/") && file.isDirectory()) {
            path = path + "/";
        }
        return new URL("file", "", path);
    }

    public static URI toURI(URL url) {
        String protocol = url.getProtocol();
        String auth = url.getAuthority();
        String path = url.getPath();
        String query = url.getQuery();
        String ref = url.getRef();
        if (path != null && !path.startsWith("/")) {
            path = "/" + path;
        }
        if (auth != null && auth.endsWith(":-1")) {
            auth = auth.substring(0, auth.length() - 3);
        }
        try {
            return createURI(protocol, auth, path, query, ref);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    private static URI createURI(String scheme, String authority, String path, String query, String fragment) throws URISyntaxException {
        String s = toString(scheme, (String) null, authority, (String) null, (String) null, -1, path, query, fragment);
        checkPath(s, scheme, path);
        return new URI(s);
    }

    private static String toString(String scheme, String opaquePart, String authority, String userInfo, String host, int port, String path, String query, String fragment) {
        StringBuffer sb = new StringBuffer();
        if (scheme != null) {
            sb.append(scheme);
            sb.append(':');
        }
        appendSchemeSpecificPart(sb, opaquePart, authority, userInfo, host, port, path, query);
        appendFragment(sb, fragment);
        return sb.toString();
    }

    private static void appendSchemeSpecificPart(StringBuffer sb, String opaquePart, String authority, String userInfo, String host, int port, String path, String query) {
        String dontquote;
        String doquote;
        if (opaquePart == null) {
            appendAuthority(sb, authority, userInfo, host, port);
            if (path != null) {
                sb.append(quote(path, L_PATH, H_PATH));
            }
            if (query != null) {
                sb.append('?');
                sb.append(quote(query, L_URIC, H_URIC));
            }
        } else if (opaquePart.startsWith("//[")) {
            int end = opaquePart.indexOf("]");
            if (end != -1 && opaquePart.indexOf(":") != -1) {
                if (end == opaquePart.length()) {
                    dontquote = opaquePart;
                    doquote = "";
                } else {
                    dontquote = opaquePart.substring(0, end + 1);
                    doquote = opaquePart.substring(end + 1);
                }
                sb.append(dontquote);
                sb.append(quote(doquote, L_URIC, H_URIC));
            }
        } else {
            sb.append(quote(opaquePart, L_URIC, H_URIC));
        }
    }

    private static void appendAuthority(StringBuffer sb, String authority, String userInfo, String host, int port) {
        String dontquote;
        String doquote;
        boolean needBrackets;
        if (host != null) {
            sb.append("//");
            if (userInfo != null) {
                sb.append(quote(userInfo, L_USERINFO, H_USERINFO));
                sb.append('@');
            }
            if (host.indexOf(58) < 0 || host.startsWith("[")) {
                needBrackets = f113assertionsDisabled;
            } else {
                needBrackets = host.endsWith("]") ? f113assertionsDisabled : true;
            }
            if (needBrackets) {
                sb.append('[');
            }
            sb.append(host);
            if (needBrackets) {
                sb.append(']');
            }
            if (port != -1) {
                sb.append(':');
                sb.append(port);
            }
        } else if (authority != null) {
            sb.append("//");
            if (authority.startsWith("[")) {
                int end = authority.indexOf("]");
                if (end != -1 && authority.indexOf(":") != -1) {
                    if (end == authority.length()) {
                        dontquote = authority;
                        doquote = "";
                    } else {
                        dontquote = authority.substring(0, end + 1);
                        doquote = authority.substring(end + 1);
                    }
                    sb.append(dontquote);
                    sb.append(quote(doquote, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
                    return;
                }
                return;
            }
            sb.append(quote(authority, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
        }
    }

    private static void appendFragment(StringBuffer sb, String fragment) {
        if (fragment != null) {
            sb.append('#');
            sb.append(quote(fragment, L_URIC, H_URIC));
        }
    }

    private static String quote(String s, long lowMask, long highMask) {
        int length = s.length();
        StringBuffer sb = null;
        boolean allowNonASCII = (L_ESCAPED & lowMask) != 0 ? true : f113assertionsDisabled;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 128) {
                if (!match(c, lowMask, highMask) && !isEscaped(s, i)) {
                    if (sb == null) {
                        sb = new StringBuffer();
                        sb.append(s.substring(0, i));
                    }
                    appendEscape(sb, (byte) c);
                } else if (sb != null) {
                    sb.append(c);
                }
            } else if (allowNonASCII && (Character.isSpaceChar(c) || Character.isISOControl(c))) {
                if (sb == null) {
                    sb = new StringBuffer();
                    sb.append(s.substring(0, i));
                }
                appendEncoded(sb, c);
            } else if (sb != null) {
                sb.append(c);
            }
        }
        return sb == null ? s : sb.toString();
    }

    private static boolean isEscaped(String s, int pos) {
        if (s == null || s.length() <= pos + 2 || s.charAt(pos) != '%' || !match(s.charAt(pos + 1), L_HEX, H_HEX)) {
            return f113assertionsDisabled;
        }
        return match(s.charAt(pos + 2), L_HEX, H_HEX);
    }

    private static void appendEncoded(StringBuffer sb, char c) {
        ByteBuffer bb = null;
        try {
            bb = ThreadLocalCoders.encoderFor("UTF-8").encode(CharBuffer.wrap((CharSequence) "" + c));
        } catch (CharacterCodingException e) {
            if (!f113assertionsDisabled) {
                throw new AssertionError();
            }
        }
        while (bb.hasRemaining()) {
            int b = bb.get() & 255;
            if (b >= 128) {
                appendEscape(sb, (byte) b);
            } else {
                sb.append((char) b);
            }
        }
    }

    private static void appendEscape(StringBuffer sb, byte b) {
        sb.append('%');
        sb.append(hexDigits[(b >> 4) & 15]);
        sb.append(hexDigits[(b >> 0) & 15]);
    }

    private static boolean match(char c, long lowMask, long highMask) {
        if (c < '@') {
            if (((L_ESCAPED << c) & lowMask) != 0) {
                return true;
            }
            return f113assertionsDisabled;
        } else if (c >= 128) {
            return f113assertionsDisabled;
        } else {
            if (((L_ESCAPED << (c - '@')) & highMask) != 0) {
                return true;
            }
            return f113assertionsDisabled;
        }
    }

    private static void checkPath(String s, String scheme, String path) throws URISyntaxException {
        if (scheme != null && path != null && path.length() > 0 && path.charAt(0) != '/') {
            throw new URISyntaxException(s, "Relative path in absolute URI");
        }
    }

    private static long lowMask(char first, char last) {
        long m = 0;
        int f = Math.max(Math.min((int) first, 63), 0);
        int l = Math.max(Math.min((int) last, 63), 0);
        for (int i = f; i <= l; i++) {
            m |= L_ESCAPED << i;
        }
        return m;
    }

    private static long lowMask(String chars) {
        int n = chars.length();
        long m = 0;
        for (int i = 0; i < n; i++) {
            char c = chars.charAt(i);
            if (c < '@') {
                m |= L_ESCAPED << c;
            }
        }
        return m;
    }

    private static long highMask(char first, char last) {
        long m = 0;
        int f = Math.max(Math.min((int) first, 127), 64) - 64;
        int l = Math.max(Math.min((int) last, 127), 64) - 64;
        for (int i = f; i <= l; i++) {
            m |= L_ESCAPED << i;
        }
        return m;
    }

    private static long highMask(String chars) {
        int n = chars.length();
        long m = 0;
        for (int i = 0; i < n; i++) {
            char c = chars.charAt(i);
            if (c >= '@' && c < 128) {
                m |= L_ESCAPED << (c - '@');
            }
        }
        return m;
    }
}
