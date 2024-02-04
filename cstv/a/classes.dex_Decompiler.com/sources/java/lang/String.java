package java.lang;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import libcore.util.CharsetUtils;

public final class String implements Serializable, Comparable<String>, CharSequence {
    public static final Comparator<String> CASE_INSENSITIVE_ORDER = null;
    private static final ObjectStreamField[] serialPersistentFields = null;
    private static final long serialVersionUID = -6849794470754667710L;
    private final int count;
    private int hash;

    private native int fastIndexOf(int i, int i2);

    private native String fastSubstring(int i, int i2);

    public native char charAt(int i);

    public native int compareTo(String str);

    public native String concat(String str);

    /* access modifiers changed from: package-private */
    public native void getCharsNoCheck(int i, int i2, char[] cArr, int i3);

    public native String intern();

    /* access modifiers changed from: package-private */
    public native void setCharAt(int i, char c);

    public native char[] toCharArray();

    public String() {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(String original) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(char[] value) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(char[] value, int offset, int count2) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(int[] codePoints, int offset, int count2) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    @Deprecated
    public String(byte[] ascii, int hibyte, int offset, int count2) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    @Deprecated
    public String(byte[] ascii, int hibyte) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, int offset, int length, String charsetName) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, int offset, int length, Charset charset) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, String charsetName) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, Charset charset) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes, int offset, int length) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(byte[] bytes) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(StringBuffer buffer) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public String(StringBuilder builder) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    @Deprecated
    String(int offset, int count2, char[] value) {
        throw new UnsupportedOperationException("Use StringFactory instead.");
    }

    public int length() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int codePointAt(int index) {
        if (index >= 0 && index < this.count) {
            return Character.codePointAt((CharSequence) this, index);
        }
        throw new StringIndexOutOfBoundsException(index);
    }

    public int codePointBefore(int index) {
        int i = index - 1;
        if (i >= 0 && i < this.count) {
            return Character.codePointBefore((CharSequence) this, index);
        }
        throw new StringIndexOutOfBoundsException(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        if (beginIndex >= 0 && endIndex <= this.count && beginIndex <= endIndex) {
            return Character.codePointCount((CharSequence) this, beginIndex, endIndex);
        }
        throw new IndexOutOfBoundsException();
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        if (index >= 0 && index <= this.count) {
            return Character.offsetByCodePoints(this, index, codePointOffset);
        }
        throw new IndexOutOfBoundsException();
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        if (dst == null) {
            throw new NullPointerException("dst == null");
        } else if (srcBegin < 0) {
            throw new StringIndexOutOfBoundsException(this, srcBegin);
        } else if (srcEnd > this.count) {
            throw new StringIndexOutOfBoundsException(this, srcEnd);
        } else {
            int n = srcEnd - srcBegin;
            if (srcEnd < srcBegin) {
                throw new StringIndexOutOfBoundsException(this, srcBegin, n);
            } else if (dstBegin < 0) {
                throw new ArrayIndexOutOfBoundsException("dstBegin < 0. dstBegin=" + dstBegin);
            } else if (dstBegin > dst.length) {
                throw new ArrayIndexOutOfBoundsException("dstBegin > dst.length. dstBegin=" + dstBegin + ", dst.length=" + dst.length);
            } else if (n > dst.length - dstBegin) {
                throw new ArrayIndexOutOfBoundsException("n > dst.length - dstBegin. n=" + n + ", dst.length=" + dst.length + "dstBegin=" + dstBegin);
            } else {
                getCharsNoCheck(srcBegin, srcEnd, dst, dstBegin);
            }
        }
    }

    @Deprecated
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        if (srcBegin < 0) {
            throw new StringIndexOutOfBoundsException(this, srcBegin);
        } else if (srcEnd > this.count) {
            throw new StringIndexOutOfBoundsException(this, srcEnd);
        } else if (srcBegin > srcEnd) {
            throw new StringIndexOutOfBoundsException(this, srcEnd - srcBegin);
        } else {
            int i = srcEnd;
            int i2 = srcBegin;
            int j = dstBegin;
            while (i2 < srcEnd) {
                dst[j] = (byte) charAt(i2);
                i2++;
                j++;
            }
        }
    }

    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return getBytes(Charset.forNameUEE(charsetName));
    }

    public byte[] getBytes(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        String name = charset.name();
        if ("UTF-8".equals(name)) {
            return CharsetUtils.toUtf8Bytes(this, 0, this.count);
        }
        if ("ISO-8859-1".equals(name)) {
            return CharsetUtils.toIsoLatin1Bytes(this, 0, this.count);
        }
        if ("US-ASCII".equals(name)) {
            return CharsetUtils.toAsciiBytes(this, 0, this.count);
        }
        if ("UTF-16BE".equals(name)) {
            return CharsetUtils.toBigEndianUtf16Bytes(this, 0, this.count);
        }
        return StringCoding.encode(charset, this);
    }

    public byte[] getBytes() {
        return getBytes(Charset.defaultCharset());
    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String) anObject;
            int n = this.count;
            if (n == anotherString.count) {
                int i = 0;
                while (true) {
                    int n2 = n;
                    n = n2 - 1;
                    if (n2 == 0) {
                        return true;
                    }
                    if (charAt(i) != anotherString.charAt(i)) {
                        return false;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    public boolean contentEquals(StringBuffer sb) {
        boolean contentEquals;
        synchronized (sb) {
            contentEquals = contentEquals((CharSequence) sb);
        }
        return contentEquals;
    }

    public boolean contentEquals(CharSequence cs) {
        if (this.count != cs.length()) {
            return false;
        }
        if (cs instanceof AbstractStringBuilder) {
            char[] v2 = ((AbstractStringBuilder) cs).getValue();
            int i = 0;
            int n = this.count;
            while (true) {
                int n2 = n;
                n = n2 - 1;
                if (n2 == 0) {
                    return true;
                }
                if (charAt(i) != v2[i]) {
                    return false;
                }
                i++;
            }
        } else if (cs.equals(this)) {
            return true;
        } else {
            int i2 = 0;
            int n3 = this.count;
            while (true) {
                int n4 = n3;
                n3 = n4 - 1;
                if (n4 == 0) {
                    return true;
                }
                if (charAt(i2) != cs.charAt(i2)) {
                    return false;
                }
                i2++;
            }
        }
    }

    public boolean equalsIgnoreCase(String anotherString) {
        if (this == anotherString) {
            return true;
        }
        if (anotherString == null || anotherString.count != this.count) {
            return false;
        }
        return regionMatches(true, 0, anotherString, 0, this.count);
    }

    private static class CaseInsensitiveComparator implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 8575799808933029326L;

        /* synthetic */ CaseInsensitiveComparator(CaseInsensitiveComparator caseInsensitiveComparator) {
            this();
        }

        private CaseInsensitiveComparator() {
        }

        public int compare(String s1, String s2) {
            char c1;
            char c2;
            char c12;
            char c22;
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c13 = s1.charAt(i);
                char c23 = s2.charAt(i);
                if (c13 != c23 && (c1 = Character.toUpperCase(c13)) != (c2 = Character.toUpperCase(c23)) && (c12 = Character.toLowerCase(c1)) != (c22 = Character.toLowerCase(c2))) {
                    return c12 - c22;
                }
            }
            return n1 - n2;
        }
    }

    public int compareToIgnoreCase(String str) {
        return CASE_INSENSITIVE_ORDER.compare(this, str);
    }

    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        int to = toffset;
        int po = ooffset;
        if (ooffset < 0 || toffset < 0 || ((long) toffset) > ((long) this.count) - ((long) len) || ((long) ooffset) > ((long) other.count) - ((long) len)) {
            return false;
        }
        while (true) {
            int po2 = po;
            int to2 = to;
            int len2 = len;
            len = len2 - 1;
            if (len2 <= 0) {
                return true;
            }
            to = to2 + 1;
            po = po2 + 1;
            if (charAt(to2) != other.charAt(po2)) {
                return false;
            }
        }
    }

    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        int to = toffset;
        int po = ooffset;
        if (ooffset < 0 || toffset < 0 || ((long) toffset) > ((long) this.count) - ((long) len) || ((long) ooffset) > ((long) other.count) - ((long) len)) {
            return false;
        }
        while (true) {
            int po2 = po;
            int to2 = to;
            int len2 = len;
            len = len2 - 1;
            if (len2 <= 0) {
                return true;
            }
            to = to2 + 1;
            char c1 = charAt(to2);
            po = po2 + 1;
            char c2 = other.charAt(po2);
            if (c1 != c2) {
                if (!ignoreCase) {
                    return false;
                }
                char u1 = Character.toUpperCase(c1);
                char u2 = Character.toUpperCase(c2);
                if (u1 != u2) {
                    if (Character.toLowerCase(u1) != Character.toLowerCase(u2)) {
                        return false;
                    }
                }
            }
        }
    }

    public boolean startsWith(String prefix, int toffset) {
        int to = toffset;
        int po = 0;
        int pc = prefix.count;
        if (toffset < 0 || toffset > this.count - pc) {
            return false;
        }
        while (true) {
            int po2 = po;
            int to2 = to;
            pc--;
            if (pc < 0) {
                return true;
            }
            to = to2 + 1;
            po = po2 + 1;
            if (charAt(to2) != prefix.charAt(po2)) {
                return false;
            }
        }
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    public boolean endsWith(String suffix) {
        return startsWith(suffix, this.count - suffix.count);
    }

    public int hashCode() {
        int h = this.hash;
        if (h == 0 && this.count > 0) {
            for (int i = 0; i < this.count; i++) {
                h = (h * 31) + charAt(i);
            }
            this.hash = h;
        }
        return h;
    }

    public int indexOf(int ch) {
        return indexOf(ch, 0);
    }

    public int indexOf(int ch, int fromIndex) {
        int max = this.count;
        if (fromIndex < 0) {
            fromIndex = 0;
        } else if (fromIndex >= max) {
            return -1;
        }
        if (ch >= 65536) {
            return indexOfSupplementary(ch, fromIndex);
        }
        for (int i = fromIndex; i < max; i++) {
            if (charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    private int indexOfSupplementary(int ch, int fromIndex) {
        if (!Character.isValidCodePoint(ch)) {
            return -1;
        }
        char hi = Character.highSurrogate(ch);
        char lo = Character.lowSurrogate(ch);
        int max = this.count - 1;
        for (int i = fromIndex; i < max; i++) {
            if (charAt(i) == hi && charAt(i + 1) == lo) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int ch) {
        return lastIndexOf(ch, this.count - 1);
    }

    public int lastIndexOf(int ch, int fromIndex) {
        if (ch >= 65536) {
            return lastIndexOfSupplementary(ch, fromIndex);
        }
        for (int i = Math.min(fromIndex, this.count - 1); i >= 0; i--) {
            if (charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    private int lastIndexOfSupplementary(int ch, int fromIndex) {
        if (!Character.isValidCodePoint(ch)) {
            return -1;
        }
        char hi = Character.highSurrogate(ch);
        char lo = Character.lowSurrogate(ch);
        for (int i = Math.min(fromIndex, this.count - 2); i >= 0; i--) {
            if (charAt(i) == hi && charAt(i + 1) == lo) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public int indexOf(String str, int fromIndex) {
        return indexOf(this, str, fromIndex);
    }

    static int indexOf(String source, String target, int fromIndex) {
        if (fromIndex < source.count) {
            if (fromIndex < 0) {
                fromIndex = 0;
            }
            if (target.count == 0) {
                return fromIndex;
            }
            char first = target.charAt(0);
            int max = source.count - target.count;
            int i = fromIndex;
            while (i <= max) {
                if (source.charAt(i) != first) {
                    do {
                        i++;
                        if (i > max) {
                            break;
                        }
                    } while (source.charAt(i) == first);
                }
                if (i <= max) {
                    int j = i + 1;
                    int end = (target.count + j) - 1;
                    int k = 1;
                    while (j < end && source.charAt(j) == target.charAt(k)) {
                        j++;
                        k++;
                    }
                    if (j == end) {
                        return i;
                    }
                }
                i++;
            }
            return -1;
        } else if (target.count == 0) {
            return source.count;
        } else {
            return -1;
        }
    }

    static int indexOf(char[] source, int sourceOffset, int sourceCount, char[] target, int targetOffset, int targetCount, int fromIndex) {
        if (fromIndex < sourceCount) {
            if (fromIndex < 0) {
                fromIndex = 0;
            }
            if (targetCount == 0) {
                return fromIndex;
            }
            char first = target[targetOffset];
            int max = sourceOffset + (sourceCount - targetCount);
            int i = sourceOffset + fromIndex;
            while (i <= max) {
                if (source[i] != first) {
                    do {
                        i++;
                        if (i > max) {
                            break;
                        }
                    } while (source[i] == first);
                }
                if (i <= max) {
                    int j = i + 1;
                    int end = (j + targetCount) - 1;
                    int k = targetOffset + 1;
                    while (j < end && source[j] == target[k]) {
                        j++;
                        k++;
                    }
                    if (j == end) {
                        return i - sourceOffset;
                    }
                }
                i++;
            }
            return -1;
        } else if (targetCount == 0) {
            return sourceCount;
        } else {
            return -1;
        }
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.count);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return lastIndexOf(this, str, fromIndex);
    }

    static int lastIndexOf(String source, String target, int fromIndex) {
        int rightIndex = source.count - target.count;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        if (target.count == 0) {
            return fromIndex;
        }
        int strLastIndex = target.count - 1;
        char strLastChar = target.charAt(strLastIndex);
        int min = target.count - 1;
        int i = min + fromIndex;
        while (true) {
            if (i >= min && source.charAt(i) != strLastChar) {
                i--;
            } else if (i < min) {
                return -1;
            } else {
                int j = i - 1;
                int start = j - (target.count - 1);
                int k = strLastIndex - 1;
                int j2 = j;
                while (j2 > start) {
                    int j3 = j2 - 1;
                    int k2 = k - 1;
                    if (source.charAt(j2) != target.charAt(k)) {
                        i--;
                    } else {
                        k = k2;
                        j2 = j3;
                    }
                }
                return start + 1;
            }
        }
    }

    static int lastIndexOf(char[] source, int sourceOffset, int sourceCount, char[] target, int targetOffset, int targetCount, int fromIndex) {
        int rightIndex = sourceCount - targetCount;
        if (fromIndex < 0) {
            return -1;
        }
        if (fromIndex > rightIndex) {
            fromIndex = rightIndex;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        int strLastIndex = (targetOffset + targetCount) - 1;
        char strLastChar = target[strLastIndex];
        int min = (sourceOffset + targetCount) - 1;
        int i = min + fromIndex;
        while (true) {
            if (i >= min && source[i] != strLastChar) {
                i--;
            } else if (i < min) {
                return -1;
            } else {
                int j = i - 1;
                int start = j - (targetCount - 1);
                int k = strLastIndex - 1;
                int j2 = j;
                while (j2 > start) {
                    int j3 = j2 - 1;
                    int k2 = k - 1;
                    if (source[j2] != target[k]) {
                        i--;
                    } else {
                        k = k2;
                        j2 = j3;
                    }
                }
                return (start - sourceOffset) + 1;
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public String substring(int beginIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(this, beginIndex);
        }
        int subLen = this.count - beginIndex;
        if (subLen >= 0) {
            return beginIndex == 0 ? this : fastSubstring(beginIndex, subLen);
        }
        throw new StringIndexOutOfBoundsException(this, beginIndex);
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public String substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(this, beginIndex);
        }
        int subLen = endIndex - beginIndex;
        if (endIndex > this.count || subLen < 0) {
            throw new StringIndexOutOfBoundsException(this, beginIndex, subLen);
        } else if (beginIndex == 0 && endIndex == this.count) {
            return this;
        } else {
            return fastSubstring(beginIndex, subLen);
        }
    }

    public CharSequence subSequence(int beginIndex, int endIndex) {
        return substring(beginIndex, endIndex);
    }

    public String replace(char oldChar, char newChar) {
        String replaced = this;
        if (oldChar != newChar) {
            for (int i = 0; i < this.count; i++) {
                if (charAt(i) == oldChar) {
                    if (replaced == this) {
                        replaced = StringFactory.newStringFromString(this);
                    }
                    replaced.setCharAt(i, newChar);
                }
            }
        }
        return replaced;
    }

    public boolean matches(String regex) {
        return Pattern.matches(regex, this);
    }

    public boolean contains(CharSequence s) {
        return indexOf(s.toString()) > -1;
    }

    public String replaceFirst(String regex, String replacement) {
        return Pattern.compile(regex).matcher(this).replaceFirst(replacement);
    }

    public String replaceAll(String regex, String replacement) {
        return Pattern.compile(regex).matcher(this).replaceAll(replacement);
    }

    public String replace(CharSequence target, CharSequence replacement) {
        if (target == null) {
            throw new NullPointerException("target == null");
        } else if (replacement == null) {
            throw new NullPointerException("replacement == null");
        } else {
            String replacementStr = replacement.toString();
            String targetStr = target.toString();
            if (targetStr.isEmpty()) {
                StringBuilder sb = new StringBuilder((replacementStr.length() * (this.count + 2)) + this.count);
                sb.append(replacementStr);
                for (int i = 0; i < this.count; i++) {
                    sb.append(charAt(i));
                    sb.append(replacementStr);
                }
                return sb.toString();
            }
            int lastMatch = 0;
            StringBuilder sb2 = null;
            while (true) {
                int currentMatch = indexOf(this, targetStr, lastMatch);
                if (currentMatch == -1) {
                    break;
                }
                if (sb2 == null) {
                    sb2 = new StringBuilder(this.count);
                }
                sb2.append((CharSequence) this, lastMatch, currentMatch);
                sb2.append(replacementStr);
                lastMatch = currentMatch + targetStr.count;
            }
            if (sb2 == null) {
                return this;
            }
            sb2.append((CharSequence) this, lastMatch, this.count);
            return sb2.toString();
        }
    }

    public String[] split(String regex, int limit) {
        String[] fast = Pattern.fastSplit(regex, this, limit);
        if (fast != null) {
            return fast;
        }
        return Pattern.compile(regex).split(this, limit);
    }

    public String[] split(String regex) {
        return split(regex, 0);
    }

    public String toLowerCase(Locale locale) {
        return CaseMapper.toLowerCase(locale, this);
    }

    public String toLowerCase() {
        return toLowerCase(Locale.getDefault());
    }

    public String toUpperCase(Locale locale) {
        return CaseMapper.toUpperCase(locale, this, this.count);
    }

    public String toUpperCase() {
        return toUpperCase(Locale.getDefault());
    }

    public String trim() {
        int len = this.count;
        int st = 0;
        while (st < len && charAt(st) <= ' ') {
            st++;
        }
        while (st < len && charAt(len - 1) <= ' ') {
            len--;
        }
        return (st > 0 || len < this.count) ? substring(st, len) : this;
    }

    public String toString() {
        return this;
    }

    public static String format(String format, Object... args) {
        return new Formatter().format(format, args).toString();
    }

    public static String format(Locale l, String format, Object... args) {
        return new Formatter(l).format(format, args).toString();
    }

    public static String valueOf(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    public static String valueOf(char[] data) {
        return StringFactory.newStringFromChars(data);
    }

    public static String valueOf(char[] data, int offset, int count2) {
        return StringFactory.newStringFromChars(data, offset, count2);
    }

    public static String copyValueOf(char[] data, int offset, int count2) {
        return StringFactory.newStringFromChars(data, offset, count2);
    }

    public static String copyValueOf(char[] data) {
        return StringFactory.newStringFromChars(data);
    }

    public static String valueOf(boolean b) {
        return b ? "true" : "false";
    }

    public static String valueOf(char c) {
        return StringFactory.newStringFromChars(0, 1, new char[]{c});
    }

    public static String valueOf(int i) {
        return Integer.toString(i);
    }

    public static String valueOf(long l) {
        return Long.toString(l);
    }

    public static String valueOf(float f) {
        return Float.toString(f);
    }

    public static String valueOf(double d) {
        return Double.toString(d);
    }

    public static String join(CharSequence delimiter, CharSequence... elements) {
        Objects.requireNonNull(delimiter);
        Objects.requireNonNull(elements);
        StringJoiner joiner = new StringJoiner(delimiter);
        for (CharSequence cs : elements) {
            joiner.add(cs);
        }
        return joiner.toString();
    }

    public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
        Objects.requireNonNull(delimiter);
        Objects.requireNonNull(elements);
        StringJoiner joiner = new StringJoiner(delimiter);
        for (CharSequence cs : elements) {
            joiner.add(cs);
        }
        return joiner.toString();
    }
}
