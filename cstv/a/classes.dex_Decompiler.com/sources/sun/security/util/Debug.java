package sun.security.util;

import java.math.BigInteger;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.util.locale.LanguageTag;

public class Debug {
    private static final String args = null;
    private static final char[] hexDigits = null;
    private final String prefix;

    private Debug(String prefix2) {
        this.prefix = prefix2;
    }

    public static Debug getInstance(String option) {
        return getInstance(option, option);
    }

    public static Debug getInstance(String option, String prefix2) {
        if (isOn(option)) {
            return new Debug(prefix2);
        }
        return null;
    }

    public static boolean isOn(String option) {
        if (args == null) {
            return false;
        }
        if (args.indexOf("all") == -1 && args.indexOf(option) == -1) {
            return false;
        }
        return true;
    }

    public void println(String message) {
        System.err.println(this.prefix + ": " + message);
    }

    public void println() {
        System.err.println(this.prefix + ":");
    }

    public static String toHexString(BigInteger b) {
        String hexValue = b.toString(16);
        StringBuffer buf = new StringBuffer(hexValue.length() * 2);
        if (hexValue.startsWith(LanguageTag.SEP)) {
            buf.append("   -");
            hexValue = hexValue.substring(1);
        } else {
            buf.append("    ");
        }
        if (hexValue.length() % 2 != 0) {
            hexValue = "0" + hexValue;
        }
        int i = 0;
        while (i < hexValue.length()) {
            buf.append(hexValue.substring(i, i + 2));
            i += 2;
            if (i != hexValue.length()) {
                if (i % 64 == 0) {
                    buf.append("\n    ");
                } else if (i % 8 == 0) {
                    buf.append(" ");
                }
            }
        }
        return buf.toString();
    }

    private static String marshal(String args2) {
        if (args2 == null) {
            return null;
        }
        StringBuffer target = new StringBuffer();
        Matcher matcher = Pattern.compile("[Pp][Ee][Rr][Mm][Ii][Ss][Ss][Ii][Oo][Nn]=" + "[a-zA-Z_$][a-zA-Z0-9_$]*([.][a-zA-Z_$][a-zA-Z0-9_$]*)*").matcher(new StringBuffer(args2));
        StringBuffer left = new StringBuffer();
        while (matcher.find()) {
            target.append(matcher.group().replaceFirst("[Pp][Ee][Rr][Mm][Ii][Ss][Ss][Ii][Oo][Nn]=", "permission="));
            target.append("  ");
            matcher.appendReplacement(left, "");
        }
        matcher.appendTail(left);
        StringBuffer source = left;
        Matcher matcher2 = Pattern.compile("[Cc][Oo][Dd][Ee][Bb][Aa][Ss][Ee]=" + "[^, ;]*").matcher(left);
        StringBuffer left2 = new StringBuffer();
        while (matcher2.find()) {
            target.append(matcher2.group().replaceFirst("[Cc][Oo][Dd][Ee][Bb][Aa][Ss][Ee]=", "codebase="));
            target.append("  ");
            matcher2.appendReplacement(left2, "");
        }
        matcher2.appendTail(left2);
        StringBuffer source2 = left2;
        target.append(left2.toString().toLowerCase(Locale.ENGLISH));
        return target.toString();
    }

    public static String toString(byte[] b) {
        if (b == null) {
            return "(null)";
        }
        StringBuilder sb = new StringBuilder(b.length * 3);
        for (int i = 0; i < b.length; i++) {
            int k = b[i] & 255;
            if (i != 0) {
                sb.append(':');
            }
            sb.append(hexDigits[k >>> 4]);
            sb.append(hexDigits[k & 15]);
        }
        return sb.toString();
    }
}
