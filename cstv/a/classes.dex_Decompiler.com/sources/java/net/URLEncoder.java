package java.net;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;

public class URLEncoder {
    static final int caseDiff = 32;
    static String dfltEncName;
    static BitSet dontNeedEncoding;

    private URLEncoder() {
    }

    @Deprecated
    public static String encode(String s) {
        try {
            return encode(s, dfltEncName);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String encode(String s, String enc) throws UnsupportedEncodingException {
        BitSet bitSet;
        int d;
        boolean needToChange = false;
        StringBuffer out = new StringBuffer(s.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (enc == null) {
            throw new NullPointerException("charsetName");
        }
        try {
            Charset charset = Charset.forName(enc);
            int i = 0;
            while (i < s.length()) {
                int c = s.charAt(i);
                if (dontNeedEncoding.get(c)) {
                    if (c == 32) {
                        c = 43;
                        needToChange = true;
                    }
                    out.append((char) c);
                    i++;
                } else {
                    do {
                        charArrayWriter.write(c);
                        if (c >= 55296 && c <= 56319 && i + 1 < s.length() && (d = s.charAt(i + 1)) >= 56320 && d <= 57343) {
                            charArrayWriter.write(d);
                            i++;
                        }
                        i++;
                        if (i >= s.length()) {
                            break;
                        }
                        bitSet = dontNeedEncoding;
                        c = s.charAt(i);
                    } while (!bitSet.get(c));
                    charArrayWriter.flush();
                    byte[] ba = new String(charArrayWriter.toCharArray()).getBytes(charset);
                    for (int j = 0; j < ba.length; j++) {
                        out.append('%');
                        char ch = Character.forDigit((ba[j] >> 4) & 15, 16);
                        if (Character.isLetter(ch)) {
                            ch = (char) (ch - ' ');
                        }
                        out.append(ch);
                        char ch2 = Character.forDigit(ba[j] & 15, 16);
                        if (Character.isLetter(ch2)) {
                            ch2 = (char) (ch2 - ' ');
                        }
                        out.append(ch2);
                    }
                    charArrayWriter.reset();
                    needToChange = true;
                }
            }
            return needToChange ? out.toString() : s;
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(enc);
        } catch (UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(enc);
        }
    }
}
