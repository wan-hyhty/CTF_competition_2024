package java.net;

import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;

public final class HttpCookie implements Cloneable {
    private static final String[] COOKIE_DATE_FORMATS = null;
    static final TimeZone GMT = null;
    private static final long MAX_AGE_UNSPECIFIED = -1;
    private static final Set<String> RESERVED_NAMES = null;
    private static final String SET_COOKIE = "set-cookie:";
    private static final String SET_COOKIE2 = "set-cookie2:";
    static Map<String, CookieAttributeAssignor> assignors = null;
    private static final String tspecials = ",;= \t";
    private String comment;
    private String commentURL;
    private String domain;
    public final String header;
    private boolean httpOnly;
    private long maxAge;
    private String name;
    private String path;
    private String portlist;
    private boolean secure;
    private boolean toDiscard;
    private String value;
    private int version;
    private long whenCreated;

    interface CookieAttributeAssignor {
        void assign(HttpCookie httpCookie, String str, String str2);
    }

    public HttpCookie(String name2, String value2) {
        this(name2, value2, (String) null);
    }

    private HttpCookie(String name2, String value2, String header2) {
        this.maxAge = -1;
        this.version = 1;
        this.whenCreated = 0;
        String name3 = name2.trim();
        if (name3.length() == 0 || !isToken(name3) || name3.charAt(0) == '$') {
            throw new IllegalArgumentException("Illegal cookie name");
        }
        this.name = name3;
        this.value = value2;
        this.toDiscard = false;
        this.secure = false;
        this.whenCreated = System.currentTimeMillis();
        this.portlist = null;
        this.header = header2;
    }

    public static List<HttpCookie> parse(String header2) {
        return parse(header2, false);
    }

    public static List<HttpCookie> parse(String header2, boolean retainHeader) {
        int version2 = guessCookieVersion(header2);
        if (startsWithIgnoreCase(header2, SET_COOKIE2)) {
            header2 = header2.substring(SET_COOKIE2.length());
        } else if (startsWithIgnoreCase(header2, SET_COOKIE)) {
            header2 = header2.substring(SET_COOKIE.length());
        }
        List<HttpCookie> cookies = new ArrayList<>();
        if (version2 == 0) {
            HttpCookie cookie = parseInternal(header2, retainHeader);
            cookie.setVersion(0);
            cookies.add(cookie);
        } else {
            for (String cookieStr : splitMultiCookies(header2)) {
                HttpCookie cookie2 = parseInternal(cookieStr, retainHeader);
                cookie2.setVersion(1);
                cookies.add(cookie2);
            }
        }
        return cookies;
    }

    public boolean hasExpired() {
        if (this.maxAge == 0) {
            return true;
        }
        return this.maxAge != -1 && (System.currentTimeMillis() - this.whenCreated) / 1000 > this.maxAge;
    }

    public void setComment(String purpose) {
        this.comment = purpose;
    }

    public String getComment() {
        return this.comment;
    }

    public void setCommentURL(String purpose) {
        this.commentURL = purpose;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public void setDiscard(boolean discard) {
        this.toDiscard = discard;
    }

    public boolean getDiscard() {
        return this.toDiscard;
    }

    public void setPortlist(String ports) {
        this.portlist = ports;
    }

    public String getPortlist() {
        return this.portlist;
    }

    public void setDomain(String pattern) {
        if (pattern != null) {
            this.domain = pattern.toLowerCase();
        } else {
            this.domain = pattern;
        }
    }

    public String getDomain() {
        return this.domain;
    }

    public void setMaxAge(long expiry) {
        this.maxAge = expiry;
    }

    public long getMaxAge() {
        return this.maxAge;
    }

    public void setPath(String uri) {
        this.path = uri;
    }

    public String getPath() {
        return this.path;
    }

    public void setSecure(boolean flag) {
        this.secure = flag;
    }

    public boolean getSecure() {
        return this.secure;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int v) {
        if (v == 0 || v == 1) {
            this.version = v;
            return;
        }
        throw new IllegalArgumentException("cookie version should be 0 or 1");
    }

    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    public void setHttpOnly(boolean httpOnly2) {
        this.httpOnly = httpOnly2;
    }

    public static boolean domainMatches(String domain2, String host) {
        if (domain2 == null || host == null) {
            return false;
        }
        boolean isLocalDomain = ".local".equalsIgnoreCase(domain2);
        int embeddedDotInDomain = domain2.indexOf(46);
        if (embeddedDotInDomain == 0) {
            embeddedDotInDomain = domain2.indexOf(46, 1);
        }
        if (!isLocalDomain && (embeddedDotInDomain == -1 || embeddedDotInDomain == domain2.length() - 1)) {
            return false;
        }
        if (host.indexOf(46) == -1 && isLocalDomain) {
            return true;
        }
        int lengthDiff = host.length() - domain2.length();
        if (lengthDiff == 0) {
            return host.equalsIgnoreCase(domain2);
        }
        if (lengthDiff > 0) {
            String substring = host.substring(0, lengthDiff);
            if (!host.substring(lengthDiff).equalsIgnoreCase(domain2)) {
                return false;
            }
            if (!domain2.startsWith(".") || !isFullyQualifiedDomainName(domain2, 1)) {
                return isLocalDomain;
            }
            return true;
        } else if (lengthDiff == -1 && domain2.charAt(0) == '.') {
            return host.equalsIgnoreCase(domain2.substring(1));
        } else {
            return false;
        }
    }

    private static boolean isFullyQualifiedDomainName(String s, int firstCharacter) {
        int dotPosition = s.indexOf(46, firstCharacter + 1);
        if (dotPosition == -1 || dotPosition >= s.length() - 1) {
            return false;
        }
        return true;
    }

    public String toString() {
        if (getVersion() > 0) {
            return toRFC2965HeaderString();
        }
        return toNetscapeHeaderString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpCookie)) {
            return false;
        }
        HttpCookie other = (HttpCookie) obj;
        if (!equalsIgnoreCase(getName(), other.getName()) || !equalsIgnoreCase(getDomain(), other.getDomain())) {
            return false;
        }
        return Objects.equals(getPath(), other.getPath());
    }

    public int hashCode() {
        return this.name.toLowerCase().hashCode() + (this.domain != null ? this.domain.toLowerCase().hashCode() : 0) + (this.path != null ? this.path.hashCode() : 0);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static boolean isToken(String value2) {
        if (RESERVED_NAMES.contains(value2.toLowerCase(Locale.US))) {
            return false;
        }
        int len = value2.length();
        for (int i = 0; i < len; i++) {
            char c = value2.charAt(i);
            if (c < ' ' || c >= 127 || tspecials.indexOf((int) c) != -1) {
                return false;
            }
        }
        return true;
    }

    private static HttpCookie parseInternal(String header2, boolean retainHeader) {
        HttpCookie cookie;
        String name2;
        String str;
        StringTokenizer tokenizer = new StringTokenizer(header2, ";");
        try {
            String namevaluePair = tokenizer.nextToken();
            int index = namevaluePair.indexOf(61);
            if (index != -1) {
                String name3 = namevaluePair.substring(0, index).trim();
                String value2 = namevaluePair.substring(index + 1).trim();
                if (retainHeader) {
                    cookie = new HttpCookie(name3, stripOffSurroundingQuote(value2), header2);
                } else {
                    cookie = new HttpCookie(name3, stripOffSurroundingQuote(value2));
                }
                while (tokenizer.hasMoreTokens()) {
                    String namevaluePair2 = tokenizer.nextToken();
                    int index2 = namevaluePair2.indexOf(61);
                    if (index2 != -1) {
                        name2 = namevaluePair2.substring(0, index2).trim();
                        str = namevaluePair2.substring(index2 + 1).trim();
                    } else {
                        name2 = namevaluePair2.trim();
                        str = null;
                    }
                    assignAttribute(cookie, name2, str);
                }
                return cookie;
            }
            throw new IllegalArgumentException("Invalid cookie name-value pair");
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Empty cookie header string");
        }
    }

    private static void assignAttribute(HttpCookie cookie, String attrName, String attrValue) {
        String attrValue2 = stripOffSurroundingQuote(attrValue);
        CookieAttributeAssignor assignor = assignors.get(attrName.toLowerCase());
        if (assignor != null) {
            assignor.assign(cookie, attrName, attrValue2);
        }
    }

    private String header() {
        return this.header;
    }

    private String toNetscapeHeaderString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("=").append(getValue());
        return sb.toString();
    }

    private String toRFC2965HeaderString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("=\"").append(getValue()).append('\"');
        if (getPath() != null) {
            sb.append(";$Path=\"").append(getPath()).append('\"');
        }
        if (getDomain() != null) {
            sb.append(";$Domain=\"").append(getDomain()).append('\"');
        }
        if (getPortlist() != null) {
            sb.append(";$Port=\"").append(getPortlist()).append('\"');
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public long expiryDate2DeltaSeconds(String dateString) {
        int year;
        Calendar cal = new GregorianCalendar(GMT);
        int i = 0;
        while (i < COOKIE_DATE_FORMATS.length) {
            SimpleDateFormat df = new SimpleDateFormat(COOKIE_DATE_FORMATS[i], Locale.US);
            cal.set(1970, 0, 1, 0, 0, 0);
            df.setTimeZone(GMT);
            df.setLenient(false);
            df.set2DigitYearStart(cal.getTime());
            try {
                cal.setTime(df.parse(dateString));
                if (!COOKIE_DATE_FORMATS[i].contains("yyyy")) {
                    int year2 = cal.get(1) % 100;
                    if (year2 < 70) {
                        year = year2 + Types.JAVA_OBJECT;
                    } else {
                        year = year2 + 1900;
                    }
                    cal.set(1, year);
                }
                return (cal.getTimeInMillis() - this.whenCreated) / 1000;
            } catch (Exception e) {
                i++;
            }
        }
        return 0;
    }

    private static int guessCookieVersion(String header2) {
        String header3 = header2.toLowerCase();
        if (header3.indexOf("expires=") != -1) {
            return 0;
        }
        if (header3.indexOf("version=") == -1 && header3.indexOf("max-age") == -1 && !startsWithIgnoreCase(header3, SET_COOKIE2)) {
            return 0;
        }
        return 1;
    }

    private static String stripOffSurroundingQuote(String str) {
        if (str != null && str.length() > 2 && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
            return str.substring(1, str.length() - 1);
        }
        if (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') {
            return str;
        }
        return str.substring(1, str.length() - 1);
    }

    private static boolean equalsIgnoreCase(String s, String t) {
        if (s == t) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.equalsIgnoreCase(t);
    }

    private static boolean startsWithIgnoreCase(String s, String start) {
        if (s == null || start == null || s.length() < start.length() || !start.equalsIgnoreCase(s.substring(0, start.length()))) {
            return false;
        }
        return true;
    }

    private static List<String> splitMultiCookies(String header2) {
        List<String> cookies = new ArrayList<>();
        int quoteCount = 0;
        int q = 0;
        for (int p = 0; p < header2.length(); p++) {
            char c = header2.charAt(p);
            if (c == '\"') {
                quoteCount++;
            }
            if (c == ',' && quoteCount % 2 == 0) {
                cookies.add(header2.substring(q, p));
                q = p + 1;
            }
        }
        cookies.add(header2.substring(q));
        return cookies;
    }
}
