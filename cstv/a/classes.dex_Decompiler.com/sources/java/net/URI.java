package java.net;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.text.Normalizer;
import sun.nio.cs.ThreadLocalCoders;

public final class URI implements Comparable<URI>, Serializable {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f10assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final long H_ALPHA = 0;
    /* access modifiers changed from: private */
    public static final long H_ALPHANUM = 0;
    /* access modifiers changed from: private */
    public static final long H_DASH = 0;
    private static final long H_DIGIT = 0;
    /* access modifiers changed from: private */
    public static final long H_DOT = 0;
    private static final long H_ESCAPED = 0;
    /* access modifiers changed from: private */
    public static final long H_HEX = 0;
    private static final long H_LEFT_BRACKET = 0;
    private static final long H_LOWALPHA = 0;
    private static final long H_MARK = 0;
    /* access modifiers changed from: private */
    public static final long H_PATH = 0;
    private static final long H_PCHAR = 0;
    /* access modifiers changed from: private */
    public static final long H_REG_NAME = 0;
    private static final long H_RESERVED = 0;
    /* access modifiers changed from: private */
    public static final long H_SCHEME = 0;
    /* access modifiers changed from: private */
    public static final long H_SERVER = 0;
    /* access modifiers changed from: private */
    public static final long H_SERVER_PERCENT = 0;
    /* access modifiers changed from: private */
    public static final long H_UNDERSCORE = 0;
    private static final long H_UNRESERVED = 0;
    private static final long H_UPALPHA = 0;
    /* access modifiers changed from: private */
    public static final long H_URIC = 0;
    private static final long H_URIC_NO_SLASH = 0;
    /* access modifiers changed from: private */
    public static final long H_USERINFO = 0;
    private static final long L_ALPHA = 0;
    /* access modifiers changed from: private */
    public static final long L_ALPHANUM = 0;
    /* access modifiers changed from: private */
    public static final long L_DASH = 0;
    /* access modifiers changed from: private */
    public static final long L_DIGIT = 0;
    /* access modifiers changed from: private */
    public static final long L_DOT = 0;
    private static final long L_ESCAPED = 1;
    /* access modifiers changed from: private */
    public static final long L_HEX = 0;
    private static final long L_LEFT_BRACKET = 0;
    private static final long L_LOWALPHA = 0;
    private static final long L_MARK = 0;
    /* access modifiers changed from: private */
    public static final long L_PATH = 0;
    private static final long L_PCHAR = 0;
    /* access modifiers changed from: private */
    public static final long L_REG_NAME = 0;
    private static final long L_RESERVED = 0;
    /* access modifiers changed from: private */
    public static final long L_SCHEME = 0;
    /* access modifiers changed from: private */
    public static final long L_SERVER = 0;
    /* access modifiers changed from: private */
    public static final long L_SERVER_PERCENT = 0;
    /* access modifiers changed from: private */
    public static final long L_UNDERSCORE = 0;
    private static final long L_UNRESERVED = 0;
    private static final long L_UPALPHA = 0;
    /* access modifiers changed from: private */
    public static final long L_URIC = 0;
    private static final long L_URIC_NO_SLASH = 0;
    /* access modifiers changed from: private */
    public static final long L_USERINFO = 0;
    private static final char[] hexDigits = null;
    static final long serialVersionUID = -6052424284110960213L;
    /* access modifiers changed from: private */
    public transient String authority;
    private volatile transient String decodedAuthority;
    private volatile transient String decodedFragment;
    private volatile transient String decodedPath;
    private volatile transient String decodedQuery;
    private volatile transient String decodedSchemeSpecificPart;
    private volatile transient String decodedUserInfo;
    /* access modifiers changed from: private */
    public transient String fragment;
    private volatile transient int hash;
    /* access modifiers changed from: private */
    public transient String host;
    /* access modifiers changed from: private */
    public transient String path;
    /* access modifiers changed from: private */
    public transient int port;
    /* access modifiers changed from: private */
    public transient String query;
    /* access modifiers changed from: private */
    public transient String scheme;
    /* access modifiers changed from: private */
    public volatile transient String schemeSpecificPart;
    /* access modifiers changed from: private */
    public volatile String string;
    /* access modifiers changed from: private */
    public transient String userInfo;

    private URI() {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
    }

    public URI(String str) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        new Parser(str).parse(f10assertionsDisabled);
    }

    public URI(String scheme2, String userInfo2, String host2, int port2, String path2, String query2, String fragment2) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        String s = toString(scheme2, (String) null, (String) null, userInfo2, host2, port2, path2, query2, fragment2);
        checkPath(s, scheme2, path2);
        new Parser(s).parse(true);
    }

    public URI(String scheme2, String authority2, String path2, String query2, String fragment2) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        String s = toString(scheme2, (String) null, authority2, (String) null, (String) null, -1, path2, query2, fragment2);
        checkPath(s, scheme2, path2);
        new Parser(s).parse(f10assertionsDisabled);
    }

    public URI(String scheme2, String host2, String path2, String fragment2) throws URISyntaxException {
        this(scheme2, (String) null, host2, -1, path2, (String) null, fragment2);
    }

    public URI(String scheme2, String ssp, String fragment2) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        new Parser(toString(scheme2, ssp, (String) null, (String) null, (String) null, -1, (String) null, (String) null, fragment2)).parse(f10assertionsDisabled);
    }

    public static URI create(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException x) {
            throw new IllegalArgumentException(x.getMessage(), x);
        }
    }

    public URI parseServerAuthority() throws URISyntaxException {
        if (this.host != null || this.authority == null) {
            return this;
        }
        defineString();
        new Parser(this.string).parse(true);
        return this;
    }

    public URI normalize() {
        return normalize(this);
    }

    public URI resolve(URI uri) {
        return resolve(this, uri);
    }

    public URI resolve(String str) {
        return resolve(create(str));
    }

    public URI relativize(URI uri) {
        return relativize(this, uri);
    }

    public URL toURL() throws MalformedURLException {
        if (isAbsolute()) {
            return new URL(toString());
        }
        throw new IllegalArgumentException("URI is not absolute");
    }

    public String getScheme() {
        return this.scheme;
    }

    public boolean isAbsolute() {
        if (this.scheme != null) {
            return true;
        }
        return f10assertionsDisabled;
    }

    public boolean isOpaque() {
        if (this.path == null) {
            return true;
        }
        return f10assertionsDisabled;
    }

    public String getRawSchemeSpecificPart() {
        defineSchemeSpecificPart();
        return this.schemeSpecificPart;
    }

    public String getSchemeSpecificPart() {
        if (this.decodedSchemeSpecificPart == null) {
            this.decodedSchemeSpecificPart = decode(getRawSchemeSpecificPart());
        }
        return this.decodedSchemeSpecificPart;
    }

    public String getRawAuthority() {
        return this.authority;
    }

    public String getAuthority() {
        if (this.decodedAuthority == null) {
            this.decodedAuthority = decode(this.authority);
        }
        return this.decodedAuthority;
    }

    public String getRawUserInfo() {
        return this.userInfo;
    }

    public String getUserInfo() {
        if (this.decodedUserInfo == null && this.userInfo != null) {
            this.decodedUserInfo = decode(this.userInfo);
        }
        return this.decodedUserInfo;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getRawPath() {
        return this.path;
    }

    public String getPath() {
        if (this.decodedPath == null && this.path != null) {
            this.decodedPath = decode(this.path);
        }
        return this.decodedPath;
    }

    public String getRawQuery() {
        return this.query;
    }

    public String getQuery() {
        if (this.decodedQuery == null && this.query != null) {
            this.decodedQuery = decode(this.query);
        }
        return this.decodedQuery;
    }

    public String getRawFragment() {
        return this.fragment;
    }

    public String getFragment() {
        if (this.decodedFragment == null && this.fragment != null) {
            this.decodedFragment = decode(this.fragment);
        }
        return this.decodedFragment;
    }

    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }
        if (!(ob instanceof URI)) {
            return f10assertionsDisabled;
        }
        URI that = (URI) ob;
        if (isOpaque() != that.isOpaque() || !equalIgnoringCase(this.scheme, that.scheme) || !equal(this.fragment, that.fragment)) {
            return f10assertionsDisabled;
        }
        if (isOpaque()) {
            return equal(this.schemeSpecificPart, that.schemeSpecificPart);
        }
        if (!equal(this.path, that.path) || !equal(this.query, that.query)) {
            return f10assertionsDisabled;
        }
        if (this.authority == that.authority) {
            return true;
        }
        if (this.host != null) {
            if (equal(this.userInfo, that.userInfo) && equalIgnoringCase(this.host, that.host) && this.port == that.port) {
                return true;
            }
            return f10assertionsDisabled;
        } else if (this.authority != null) {
            if (!equal(this.authority, that.authority)) {
                return f10assertionsDisabled;
            }
        } else if (this.authority != that.authority) {
            return f10assertionsDisabled;
        }
        return true;
    }

    public int hashCode() {
        int h;
        if (this.hash != 0) {
            return this.hash;
        }
        int h2 = hash(hashIgnoringCase(0, this.scheme), this.fragment);
        if (isOpaque()) {
            h = hash(h2, this.schemeSpecificPart);
        } else {
            int h3 = hash(hash(h2, this.path), this.query);
            if (this.host != null) {
                h = hashIgnoringCase(hash(h3, this.userInfo), this.host) + (this.port * 1949);
            } else {
                h = hash(h3, this.authority);
            }
        }
        this.hash = h;
        return h;
    }

    public int compareTo(URI that) {
        int c = compareIgnoringCase(this.scheme, that.scheme);
        if (c != 0) {
            return c;
        }
        if (isOpaque()) {
            if (!that.isOpaque()) {
                return 1;
            }
            int c2 = compare(this.schemeSpecificPart, that.schemeSpecificPart);
            if (c2 != 0) {
                return c2;
            }
            return compare(this.fragment, that.fragment);
        } else if (that.isOpaque()) {
            return -1;
        } else {
            if (this.host == null || that.host == null) {
                int c3 = compare(this.authority, that.authority);
                if (c3 != 0) {
                    return c3;
                }
            } else {
                int c4 = compare(this.userInfo, that.userInfo);
                if (c4 != 0) {
                    return c4;
                }
                int c5 = compareIgnoringCase(this.host, that.host);
                if (c5 != 0) {
                    return c5;
                }
                int c6 = this.port - that.port;
                if (c6 != 0) {
                    return c6;
                }
            }
            int c7 = compare(this.path, that.path);
            if (c7 != 0) {
                return c7;
            }
            int c8 = compare(this.query, that.query);
            if (c8 != 0) {
                return c8;
            }
            return compare(this.fragment, that.fragment);
        }
    }

    public String toString() {
        defineString();
        return this.string;
    }

    public String toASCIIString() {
        defineString();
        return encode(this.string);
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        defineString();
        os.defaultWriteObject();
    }

    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
        this.port = -1;
        is.defaultReadObject();
        try {
            new Parser(this.string).parse(f10assertionsDisabled);
        } catch (URISyntaxException x) {
            IOException y = new InvalidObjectException("Invalid URI");
            y.initCause(x);
            throw y;
        }
    }

    private static int toLower(char c) {
        if (c < 'A' || c > 'Z') {
            return c;
        }
        return c + ' ';
    }

    private static boolean equal(String s, String t) {
        if (s == t) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return f10assertionsDisabled;
        }
        if (s.indexOf(37) < 0) {
            return s.equals(t);
        }
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (c != '%') {
                if (c != d) {
                    return f10assertionsDisabled;
                }
                i++;
            } else if (d != '%') {
                return f10assertionsDisabled;
            } else {
                int i2 = i + 1;
                if (toLower(s.charAt(i2)) != toLower(t.charAt(i2))) {
                    return f10assertionsDisabled;
                }
                int i3 = i2 + 1;
                if (toLower(s.charAt(i3)) != toLower(t.charAt(i3))) {
                    return f10assertionsDisabled;
                }
                i = i3 + 1;
            }
        }
        return true;
    }

    private static boolean equalIgnoringCase(String s, String t) {
        int n;
        if (s == t) {
            return true;
        }
        if (s == null || t == null || t.length() != (n = s.length())) {
            return f10assertionsDisabled;
        }
        for (int i = 0; i < n; i++) {
            if (toLower(s.charAt(i)) != toLower(t.charAt(i))) {
                return f10assertionsDisabled;
            }
        }
        return true;
    }

    private static int hash(int hash2, String s) {
        if (s == null) {
            return hash2;
        }
        return (hash2 * 127) + s.hashCode();
    }

    private static int hashIgnoringCase(int hash2, String s) {
        if (s == null) {
            return hash2;
        }
        int h = hash2;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            h = (h * 31) + toLower(s.charAt(i));
        }
        return h;
    }

    private static int compare(String s, String t) {
        if (s == t) {
            return 0;
        }
        if (s == null) {
            return -1;
        }
        if (t != null) {
            return s.compareTo(t);
        }
        return 1;
    }

    private static int compareIgnoringCase(String s, String t) {
        if (s == t) {
            return 0;
        }
        if (s == null) {
            return -1;
        }
        if (t == null) {
            return 1;
        }
        int sn = s.length();
        int tn = t.length();
        int n = sn < tn ? sn : tn;
        for (int i = 0; i < n; i++) {
            int c = toLower(s.charAt(i)) - toLower(t.charAt(i));
            if (c != 0) {
                return c;
            }
        }
        return sn - tn;
    }

    private static void checkPath(String s, String scheme2, String path2) throws URISyntaxException {
        if (scheme2 != null && path2 != null && path2.length() > 0 && path2.charAt(0) != '/') {
            throw new URISyntaxException(s, "Relative path in absolute URI");
        }
    }

    private void appendAuthority(StringBuffer sb, String authority2, String userInfo2, String host2, int port2) {
        boolean needBrackets;
        if (host2 != null) {
            sb.append("//");
            if (userInfo2 != null) {
                sb.append(quote(userInfo2, L_USERINFO, H_USERINFO));
                sb.append('@');
            }
            if (host2.indexOf(58) < 0 || host2.startsWith("[")) {
                needBrackets = f10assertionsDisabled;
            } else {
                needBrackets = host2.endsWith("]") ? f10assertionsDisabled : true;
            }
            if (needBrackets) {
                sb.append('[');
            }
            sb.append(host2);
            if (needBrackets) {
                sb.append(']');
            }
            if (port2 != -1) {
                sb.append(':');
                sb.append(port2);
            }
        } else if (authority2 != null) {
            sb.append("//");
            if (authority2.startsWith("[")) {
                int end = authority2.indexOf("]");
                String doquote = authority2;
                String dontquote = "";
                if (!(end == -1 || authority2.indexOf(":") == -1)) {
                    if (end == authority2.length()) {
                        dontquote = authority2;
                        doquote = "";
                    } else {
                        dontquote = authority2.substring(0, end + 1);
                        doquote = authority2.substring(end + 1);
                    }
                }
                sb.append(dontquote);
                sb.append(quote(doquote, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
                return;
            }
            sb.append(quote(authority2, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
        }
    }

    private void appendSchemeSpecificPart(StringBuffer sb, String opaquePart, String authority2, String userInfo2, String host2, int port2, String path2, String query2) {
        String dontquote;
        String doquote;
        if (opaquePart == null) {
            appendAuthority(sb, authority2, userInfo2, host2, port2);
            if (path2 != null) {
                sb.append(quote(path2, L_PATH, H_PATH));
            }
            if (query2 != null) {
                sb.append('?');
                sb.append(quote(query2, L_URIC, H_URIC));
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

    private void appendFragment(StringBuffer sb, String fragment2) {
        if (fragment2 != null) {
            sb.append('#');
            sb.append(quote(fragment2, L_URIC, H_URIC));
        }
    }

    private String toString(String scheme2, String opaquePart, String authority2, String userInfo2, String host2, int port2, String path2, String query2, String fragment2) {
        StringBuffer sb = new StringBuffer();
        if (scheme2 != null) {
            sb.append(scheme2);
            sb.append(':');
        }
        appendSchemeSpecificPart(sb, opaquePart, authority2, userInfo2, host2, port2, path2, query2);
        appendFragment(sb, fragment2);
        return sb.toString();
    }

    private void defineSchemeSpecificPart() {
        if (this.schemeSpecificPart == null) {
            StringBuffer sb = new StringBuffer();
            appendSchemeSpecificPart(sb, (String) null, getAuthority(), getUserInfo(), this.host, this.port, getPath(), getQuery());
            if (sb.length() != 0) {
                this.schemeSpecificPart = sb.toString();
            }
        }
    }

    private void defineString() {
        boolean needBrackets;
        boolean z = f10assertionsDisabled;
        if (this.string == null) {
            StringBuffer sb = new StringBuffer();
            if (this.scheme != null) {
                sb.append(this.scheme);
                sb.append(':');
            }
            if (isOpaque()) {
                sb.append(this.schemeSpecificPart);
            } else {
                if (this.host != null) {
                    sb.append("//");
                    if (this.userInfo != null) {
                        sb.append(this.userInfo);
                        sb.append('@');
                    }
                    if (this.host.indexOf(58) < 0 || this.host.startsWith("[")) {
                        needBrackets = false;
                    } else {
                        if (!this.host.endsWith("]")) {
                            z = true;
                        }
                        needBrackets = z;
                    }
                    if (needBrackets) {
                        sb.append('[');
                    }
                    sb.append(this.host);
                    if (needBrackets) {
                        sb.append(']');
                    }
                    if (this.port != -1) {
                        sb.append(':');
                        sb.append(this.port);
                    }
                } else if (this.authority != null) {
                    sb.append("//");
                    sb.append(this.authority);
                }
                if (this.path != null) {
                    sb.append(this.path);
                }
                if (this.query != null) {
                    sb.append('?');
                    sb.append(this.query);
                }
            }
            if (this.fragment != null) {
                sb.append('#');
                sb.append(this.fragment);
            }
            this.string = sb.toString();
        }
    }

    private static String resolvePath(String base, String child, boolean absolute) {
        int i = base.lastIndexOf(47);
        int cn = child.length();
        String path2 = "";
        if (cn != 0) {
            StringBuffer sb = new StringBuffer(base.length() + cn);
            if (i >= 0) {
                sb.append(base.substring(0, i + 1));
            }
            sb.append(child);
            path2 = sb.toString();
        } else if (i >= 0) {
            path2 = base.substring(0, i + 1);
        }
        return normalize(path2, true);
    }

    private static URI resolve(URI base, URI child) {
        String str;
        if (child.isOpaque() || base.isOpaque()) {
            return child;
        }
        if (child.scheme == null && child.authority == null && child.path.equals("") && child.fragment != null && child.query == null) {
            if (base.fragment != null && child.fragment.equals(base.fragment)) {
                return base;
            }
            URI ru = new URI();
            ru.scheme = base.scheme;
            ru.authority = base.authority;
            ru.userInfo = base.userInfo;
            ru.host = base.host;
            ru.port = base.port;
            ru.path = base.path;
            ru.fragment = child.fragment;
            ru.query = base.query;
            return ru;
        } else if (child.scheme != null) {
            return child;
        } else {
            URI ru2 = new URI();
            ru2.scheme = base.scheme;
            ru2.query = child.query;
            ru2.fragment = child.fragment;
            if (child.authority == null) {
                ru2.authority = base.authority;
                ru2.host = base.host;
                ru2.userInfo = base.userInfo;
                ru2.port = base.port;
                if (child.path == null || child.path.isEmpty()) {
                    ru2.path = base.path;
                    if (child.query != null) {
                        str = child.query;
                    } else {
                        str = base.query;
                    }
                    ru2.query = str;
                } else if (child.path.length() <= 0 || child.path.charAt(0) != '/') {
                    ru2.path = resolvePath(base.path, child.path, base.isAbsolute());
                } else {
                    ru2.path = normalize(child.path, true);
                }
            } else {
                ru2.authority = child.authority;
                ru2.host = child.host;
                ru2.userInfo = child.userInfo;
                ru2.host = child.host;
                ru2.port = child.port;
                ru2.path = child.path;
            }
            return ru2;
        }
    }

    private static URI normalize(URI u) {
        String np;
        if (u.isOpaque() || u.path == null || u.path.length() == 0 || (np = normalize(u.path)) == u.path) {
            return u;
        }
        URI v = new URI();
        v.scheme = u.scheme;
        v.fragment = u.fragment;
        v.authority = u.authority;
        v.userInfo = u.userInfo;
        v.host = u.host;
        v.port = u.port;
        v.path = np;
        v.query = u.query;
        return v;
    }

    private static URI relativize(URI base, URI child) {
        if (child.isOpaque() || base.isOpaque() || !equalIgnoringCase(base.scheme, child.scheme) || !equal(base.authority, child.authority)) {
            return child;
        }
        String bp = normalize(base.path);
        String cp = normalize(child.path);
        if (!bp.equals(cp)) {
            if (bp.indexOf(47) != -1) {
                bp = bp.substring(0, bp.lastIndexOf(47) + 1);
            }
            if (!cp.startsWith(bp)) {
                return child;
            }
        }
        URI v = new URI();
        v.path = cp.substring(bp.length());
        v.query = child.query;
        v.fragment = child.fragment;
        return v;
    }

    private static int needsNormalization(String path2) {
        int p;
        boolean normal = true;
        int ns = 0;
        int end = path2.length() - 1;
        int p2 = 0;
        while (p <= end && path2.charAt(p) == '/') {
            p2 = p + 1;
        }
        if (p > 1) {
            normal = f10assertionsDisabled;
        }
        while (p <= end) {
            if (path2.charAt(p) == '.' && (p == end || path2.charAt(p + 1) == '/' || (path2.charAt(p + 1) == '.' && (p + 1 == end || path2.charAt(p + 2) == '/')))) {
                normal = f10assertionsDisabled;
            }
            ns++;
            int p3 = p;
            while (true) {
                if (p3 > end) {
                    p = p3;
                    break;
                }
                p = p3 + 1;
                if (path2.charAt(p3) != '/') {
                    p3 = p;
                } else {
                    while (p <= end && path2.charAt(p) == '/') {
                        normal = f10assertionsDisabled;
                        p++;
                    }
                }
            }
        }
        if (normal) {
            return -1;
        }
        return ns;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r8[r3 - 1] = 0;
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r4 > r0) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r8[r4] == '/') goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r8[r4] = 0;
        r4 = r4 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void split(char[] r8, int[] r9) {
        /*
            r7 = 47
            r6 = 0
            int r5 = r8.length
            int r0 = r5 + -1
            r3 = 0
            r1 = 0
        L_0x0008:
            if (r3 > r0) goto L_0x0034
            char r5 = r8[r3]
            if (r5 == r7) goto L_0x0023
            r2 = r1
            r4 = r3
        L_0x0010:
            if (r4 > r0) goto L_0x003d
            int r1 = r2 + 1
            int r3 = r4 + 1
            r9[r2] = r4
            r4 = r3
        L_0x0019:
            if (r4 > r0) goto L_0x0047
            int r3 = r4 + 1
            char r5 = r8[r4]
            if (r5 == r7) goto L_0x0028
            r4 = r3
            goto L_0x0019
        L_0x0023:
            r8[r3] = r6
            int r3 = r3 + 1
            goto L_0x0008
        L_0x0028:
            int r5 = r3 + -1
            r8[r5] = r6
            r4 = r3
        L_0x002d:
            if (r4 > r0) goto L_0x0033
            char r5 = r8[r4]
            if (r5 == r7) goto L_0x0037
        L_0x0033:
            r3 = r4
        L_0x0034:
            r2 = r1
            r4 = r3
            goto L_0x0010
        L_0x0037:
            int r3 = r4 + 1
            r8[r4] = r6
            r4 = r3
            goto L_0x002d
        L_0x003d:
            int r5 = r9.length
            if (r2 == r5) goto L_0x0046
            java.lang.InternalError r5 = new java.lang.InternalError
            r5.<init>()
            throw r5
        L_0x0046:
            return
        L_0x0047:
            r3 = r4
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URI.split(char[], int[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int join(char[] r10, int[] r11) {
        /*
            r9 = 47
            r8 = 0
            int r2 = r11.length
            int r7 = r10.length
            int r0 = r7 + -1
            r3 = 0
            char r7 = r10[r3]
            if (r7 != 0) goto L_0x000f
            r3 = 1
            r10[r8] = r9
        L_0x000f:
            r1 = 0
        L_0x0010:
            if (r1 >= r2) goto L_0x004f
            r5 = r11[r1]
            r7 = -1
            if (r5 != r7) goto L_0x001a
        L_0x0017:
            int r1 = r1 + 1
            goto L_0x0010
        L_0x001a:
            if (r3 != r5) goto L_0x002e
            r4 = r3
        L_0x001d:
            if (r4 > r0) goto L_0x0027
            char r7 = r10[r4]
            if (r7 == 0) goto L_0x0027
            int r3 = r4 + 1
            r4 = r3
            goto L_0x001d
        L_0x0027:
            if (r4 > r0) goto L_0x0053
            int r3 = r4 + 1
            r10[r4] = r9
            goto L_0x0017
        L_0x002e:
            if (r3 >= r5) goto L_0x0049
        L_0x0030:
            r6 = r5
            r4 = r3
            if (r6 > r0) goto L_0x0041
            char r7 = r10[r6]
            if (r7 == 0) goto L_0x0041
            int r3 = r4 + 1
            int r5 = r6 + 1
            char r7 = r10[r6]
            r10[r4] = r7
            goto L_0x0030
        L_0x0041:
            if (r6 > r0) goto L_0x0050
            int r3 = r4 + 1
            r10[r4] = r9
            r5 = r6
            goto L_0x0017
        L_0x0049:
            java.lang.InternalError r7 = new java.lang.InternalError
            r7.<init>()
            throw r7
        L_0x004f:
            return r3
        L_0x0050:
            r5 = r6
            r3 = r4
            goto L_0x0017
        L_0x0053:
            r3 = r4
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URI.join(char[], int[]):int");
    }

    private static void removeDots(char[] path2, int[] segs, boolean removeLeading) {
        int ns = segs.length;
        int end = path2.length - 1;
        int i = 0;
        while (i < ns) {
            int dots = 0;
            while (true) {
                int p = segs[i];
                if (path2[p] == '.') {
                    if (p == end) {
                        dots = 1;
                        break;
                    } else if (path2[p + 1] == 0) {
                        dots = 1;
                        break;
                    } else if (path2[p + 1] == '.' && (p + 1 == end || path2[p + 2] == 0)) {
                        dots = 2;
                    }
                }
                i++;
                if (i >= ns) {
                    break;
                }
            }
            if (i <= ns && dots != 0) {
                if (dots == 1) {
                    segs[i] = -1;
                } else {
                    int j = i - 1;
                    while (j >= 0 && segs[j] == -1) {
                        j--;
                    }
                    if (j >= 0) {
                        int q = segs[j];
                        if (path2[q] != '.' || path2[q + 1] != '.' || path2[q + 2] != 0) {
                            segs[i] = -1;
                            segs[j] = -1;
                        }
                    } else if (removeLeading) {
                        segs[i] = -1;
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    private static void maybeAddLeadingDot(char[] path2, int[] segs) {
        if (path2[0] != 0) {
            int ns = segs.length;
            int f = 0;
            while (f < ns && segs[f] < 0) {
                f++;
            }
            if (f < ns && f != 0) {
                int p = segs[f];
                while (p < path2.length && path2[p] != ':' && path2[p] != 0) {
                    p++;
                }
                if (p < path2.length && path2[p] != 0) {
                    path2[0] = '.';
                    path2[1] = 0;
                    segs[0] = 0;
                }
            }
        }
    }

    private static String normalize(String ps) {
        return normalize(ps, f10assertionsDisabled);
    }

    private static String normalize(String ps, boolean removeLeading) {
        int ns = needsNormalization(ps);
        if (ns < 0) {
            return ps;
        }
        char[] path2 = ps.toCharArray();
        int[] segs = new int[ns];
        split(path2, segs);
        removeDots(path2, segs, removeLeading);
        maybeAddLeadingDot(path2, segs);
        String s = new String(path2, 0, join(path2, segs));
        if (s.equals(ps)) {
            return ps;
        }
        return s;
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

    private static long lowMask(char first, char last) {
        long m = 0;
        int f = Math.max(Math.min((int) first, 63), 0);
        int l = Math.max(Math.min((int) last, 63), 0);
        for (int i = f; i <= l; i++) {
            m |= L_ESCAPED << i;
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

    /* access modifiers changed from: private */
    public static boolean match(char c, long lowMask, long highMask) {
        if (c == 0) {
            return f10assertionsDisabled;
        }
        if (c < '@') {
            if (((L_ESCAPED << c) & lowMask) != 0) {
                return true;
            }
            return f10assertionsDisabled;
        } else if (c >= 128) {
            return f10assertionsDisabled;
        } else {
            if (((L_ESCAPED << (c - '@')) & highMask) != 0) {
                return true;
            }
            return f10assertionsDisabled;
        }
    }

    private static void appendEscape(StringBuffer sb, byte b) {
        sb.append('%');
        sb.append(hexDigits[(b >> 4) & 15]);
        sb.append(hexDigits[(b >> 0) & 15]);
    }

    private static void appendEncoded(StringBuffer sb, char c) {
        ByteBuffer bb = null;
        try {
            bb = ThreadLocalCoders.encoderFor("UTF-8").encode(CharBuffer.wrap((CharSequence) "" + c));
        } catch (CharacterCodingException e) {
            if (!f10assertionsDisabled) {
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

    private static String quote(String s, long lowMask, long highMask) {
        int length = s.length();
        StringBuffer sb = null;
        boolean allowNonASCII = (L_ESCAPED & lowMask) != 0 ? true : f10assertionsDisabled;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 128) {
                if (!match(c, lowMask, highMask)) {
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

    private static String encode(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }
        int i = 0;
        while (s.charAt(i) < 128) {
            i++;
            if (i >= n) {
                return s;
            }
        }
        ByteBuffer bb = null;
        try {
            bb = ThreadLocalCoders.encoderFor("UTF-8").encode(CharBuffer.wrap((CharSequence) Normalizer.normalize(s, Normalizer.Form.NFC)));
        } catch (CharacterCodingException e) {
            if (!f10assertionsDisabled) {
                throw new AssertionError();
            }
        }
        StringBuffer sb = new StringBuffer();
        while (bb.hasRemaining()) {
            int b = bb.get() & 255;
            if (b >= 128) {
                appendEscape(sb, (byte) b);
            } else {
                sb.append((char) b);
            }
        }
        return sb.toString();
    }

    private static int decode(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        if (f10assertionsDisabled) {
            return -1;
        }
        throw new AssertionError();
    }

    private static byte decode(char c1, char c2) {
        return (byte) (((decode(c1) & 15) << 4) | ((decode(c2) & 15) << 0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String decode(java.lang.String r15) {
        /*
            r14 = 37
            r11 = 1
            r12 = 0
            if (r15 != 0) goto L_0x0007
            return r15
        L_0x0007:
            int r7 = r15.length()
            if (r7 != 0) goto L_0x000e
            return r15
        L_0x000e:
            int r10 = r15.indexOf((int) r14)
            if (r10 >= 0) goto L_0x0015
            return r15
        L_0x0015:
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>((int) r7)
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r7)
            java.nio.CharBuffer r3 = java.nio.CharBuffer.allocate(r7)
            java.lang.String r10 = "UTF-8"
            java.nio.charset.CharsetDecoder r10 = sun.nio.cs.ThreadLocalCoders.decoderFor(r10)
            java.nio.charset.CodingErrorAction r13 = java.nio.charset.CodingErrorAction.REPLACE
            java.nio.charset.CharsetDecoder r10 = r10.onMalformedInput(r13)
            java.nio.charset.CodingErrorAction r13 = java.nio.charset.CodingErrorAction.REPLACE
            java.nio.charset.CharsetDecoder r5 = r10.onUnmappableCharacter(r13)
            char r2 = r15.charAt(r12)
            r1 = 0
            r6 = 0
        L_0x003b:
            if (r6 >= r7) goto L_0x0062
            boolean r10 = f10assertionsDisabled
            if (r10 != 0) goto L_0x0052
            char r10 = r15.charAt(r6)
            if (r2 != r10) goto L_0x0050
            r10 = r11
        L_0x0048:
            if (r10 != 0) goto L_0x0052
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x0050:
            r10 = r12
            goto L_0x0048
        L_0x0052:
            r10 = 91
            if (r2 != r10) goto L_0x0067
            r1 = 1
        L_0x0057:
            if (r2 != r14) goto L_0x005b
            if (r1 == 0) goto L_0x0074
        L_0x005b:
            r8.append((char) r2)
            int r6 = r6 + 1
            if (r6 < r7) goto L_0x006f
        L_0x0062:
            java.lang.String r10 = r8.toString()
            return r10
        L_0x0067:
            if (r1 == 0) goto L_0x0057
            r10 = 93
            if (r2 != r10) goto L_0x0057
            r1 = 0
            goto L_0x0057
        L_0x006f:
            char r2 = r15.charAt(r6)
            goto L_0x003b
        L_0x0074:
            r0.clear()
            r9 = r6
        L_0x0078:
            boolean r10 = f10assertionsDisabled
            if (r10 != 0) goto L_0x008c
            int r10 = r7 - r6
            r13 = 2
            if (r10 < r13) goto L_0x008a
            r10 = r11
        L_0x0082:
            if (r10 != 0) goto L_0x008c
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x008a:
            r10 = r12
            goto L_0x0082
        L_0x008c:
            int r6 = r6 + 1
            char r10 = r15.charAt(r6)
            int r6 = r6 + 1
            char r13 = r15.charAt(r6)
            byte r10 = decode(r10, r13)
            r0.put((byte) r10)
            int r6 = r6 + 1
            if (r6 < r7) goto L_0x00c0
        L_0x00a3:
            r0.flip()
            r3.clear()
            r5.reset()
            java.nio.charset.CoderResult r4 = r5.decode(r0, r3, r11)
            boolean r10 = f10assertionsDisabled
            if (r10 != 0) goto L_0x00c7
            boolean r10 = r4.isUnderflow()
            if (r10 != 0) goto L_0x00c7
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x00c0:
            char r2 = r15.charAt(r6)
            if (r2 == r14) goto L_0x0078
            goto L_0x00a3
        L_0x00c7:
            java.nio.charset.CoderResult r4 = r5.flush(r3)
            boolean r10 = f10assertionsDisabled
            if (r10 != 0) goto L_0x00db
            boolean r10 = r4.isUnderflow()
            if (r10 != 0) goto L_0x00db
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x00db:
            java.nio.Buffer r10 = r3.flip()
            java.lang.String r10 = r10.toString()
            r8.append((java.lang.String) r10)
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URI.decode(java.lang.String):java.lang.String");
    }

    private class Parser {
        private String input;
        private int ipv6byteCount = 0;
        private boolean requireServerAuthority = URI.f10assertionsDisabled;

        Parser(String s) {
            this.input = s;
            String unused = URI.this.string = s;
        }

        private void fail(String reason) throws URISyntaxException {
            throw new URISyntaxException(this.input, reason);
        }

        private void fail(String reason, int p) throws URISyntaxException {
            throw new URISyntaxException(this.input, reason, p);
        }

        private void failExpecting(String expected, int p) throws URISyntaxException {
            fail("Expected " + expected, p);
        }

        private void failExpecting(String expected, String prior, int p) throws URISyntaxException {
            fail("Expected " + expected + " following " + prior, p);
        }

        private String substring(int start, int end) {
            return this.input.substring(start, end);
        }

        private char charAt(int p) {
            return this.input.charAt(p);
        }

        private boolean at(int start, int end, char c) {
            if (start >= end || charAt(start) != c) {
                return URI.f10assertionsDisabled;
            }
            return true;
        }

        private boolean at(int start, int end, String s) {
            int p = start;
            int sn = s.length();
            if (sn > end - start) {
                return URI.f10assertionsDisabled;
            }
            int i = 0;
            int p2 = p;
            while (true) {
                if (i >= sn) {
                    int i2 = p2;
                    break;
                }
                int p3 = p2 + 1;
                if (charAt(p2) != s.charAt(i)) {
                    break;
                }
                i++;
                p2 = p3;
            }
            if (i == sn) {
                return true;
            }
            return URI.f10assertionsDisabled;
        }

        private int scan(int start, int end, char c) {
            if (start >= end || charAt(start) != c) {
                return start;
            }
            return start + 1;
        }

        private int scan(int start, int end, String err, String stop) {
            int p = start;
            while (p < end) {
                char c = charAt(p);
                if (err.indexOf((int) c) >= 0) {
                    return -1;
                }
                if (stop.indexOf((int) c) >= 0) {
                    break;
                }
                p++;
            }
            return p;
        }

        private int scanEscape(int start, int n, char first) throws URISyntaxException {
            int i = start;
            char c = first;
            if (first == '%') {
                if (start + 3 <= n && URI.match(charAt(start + 1), URI.L_HEX, URI.H_HEX) && URI.match(charAt(start + 2), URI.L_HEX, URI.H_HEX)) {
                    return start + 3;
                }
                fail("Malformed escape pair", start);
            } else if (first > 128 && !Character.isSpaceChar(first) && !Character.isISOControl(first)) {
                return start + 1;
            }
            return start;
        }

        private int scan(int start, int n, long lowMask, long highMask) throws URISyntaxException {
            int q;
            int p = start;
            while (p < n) {
                char c = charAt(p);
                if (!URI.match(c, lowMask, highMask)) {
                    if ((URI.L_ESCAPED & lowMask) == 0 || (q = scanEscape(p, n, c)) <= p) {
                        break;
                    }
                    p = q;
                } else {
                    p++;
                }
            }
            return p;
        }

        private void checkChars(int start, int end, long lowMask, long highMask, String what) throws URISyntaxException {
            int p = scan(start, end, lowMask, highMask);
            if (p < end) {
                fail("Illegal character in " + what, p);
            }
        }

        private void checkChar(int p, long lowMask, long highMask, String what) throws URISyntaxException {
            checkChars(p, p + 1, lowMask, highMask, what);
        }

        /* access modifiers changed from: package-private */
        public void parse(boolean rsa) throws URISyntaxException {
            int ssp;
            int p;
            this.requireServerAuthority = rsa;
            int n = this.input.length();
            int p2 = scan(0, n, "/?#", ":");
            if (p2 < 0 || !at(p2, n, ':')) {
                ssp = 0;
                p = parseHierarchical(0, n);
            } else {
                if (p2 == 0) {
                    failExpecting("scheme name", 0);
                }
                checkChar(0, 0, URI.H_ALPHA, "scheme name");
                checkChars(1, p2, URI.L_SCHEME, URI.H_SCHEME, "scheme name");
                String unused = URI.this.scheme = substring(0, p2);
                int p3 = p2 + 1;
                ssp = p3;
                if (at(p3, n, '/')) {
                    p = parseHierarchical(p3, n);
                } else {
                    int q = scan(p3, n, "", "#");
                    if (q <= p3) {
                        failExpecting("scheme-specific part", p3);
                    }
                    checkChars(p3, q, URI.L_URIC, URI.H_URIC, "opaque part");
                    p = q;
                }
            }
            String unused2 = URI.this.schemeSpecificPart = substring(ssp, p);
            if (at(p, n, '#')) {
                checkChars(p + 1, n, URI.L_URIC, URI.H_URIC, "fragment");
                String unused3 = URI.this.fragment = substring(p + 1, n);
                p = n;
            }
            if (p < n) {
                fail("end of URI", p);
            }
        }

        private int parseHierarchical(int start, int n) throws URISyntaxException {
            int p = start;
            if (at(start, n, '/') && at(start + 1, n, '/')) {
                p = start + 2;
                int q = scan(p, n, "", "/?#");
                if (q > p) {
                    p = parseAuthority(p, q);
                } else if (q >= n) {
                    failExpecting("authority", p);
                }
            }
            int q2 = scan(p, n, "", "?#");
            checkChars(p, q2, URI.L_PATH, URI.H_PATH, "path");
            String unused = URI.this.path = substring(p, q2);
            int p2 = q2;
            if (!at(q2, n, '?')) {
                return p2;
            }
            int p3 = q2 + 1;
            int q3 = scan(p3, n, "", "#");
            checkChars(p3, q3, URI.L_URIC, URI.H_URIC, "query");
            String unused2 = URI.this.query = substring(p3, q3);
            return q3;
        }

        private int parseAuthority(int start, int n) throws URISyntaxException {
            boolean serverChars;
            int i = start;
            int q = start;
            URISyntaxException ex = null;
            if (scan(start, n, "", "]") > start) {
                serverChars = scan(start, n, URI.L_SERVER_PERCENT, URI.H_SERVER_PERCENT) == n ? true : URI.f10assertionsDisabled;
            } else {
                serverChars = scan(start, n, URI.L_SERVER, URI.H_SERVER) == n ? true : URI.f10assertionsDisabled;
            }
            boolean regChars = scan(start, n, URI.L_REG_NAME, URI.H_REG_NAME) == n ? true : URI.f10assertionsDisabled;
            if (!regChars || serverChars) {
                if (serverChars) {
                    try {
                        q = parseServer(start, n);
                        if (q < n) {
                            failExpecting("end of authority", q);
                        }
                        String unused = URI.this.authority = substring(start, n);
                    } catch (URISyntaxException x) {
                        String unused2 = URI.this.userInfo = null;
                        String unused3 = URI.this.host = null;
                        int unused4 = URI.this.port = -1;
                        if (this.requireServerAuthority) {
                            throw x;
                        }
                        ex = x;
                        q = start;
                    }
                }
                if (q < n) {
                    if (regChars) {
                        String unused5 = URI.this.authority = substring(start, n);
                    } else if (ex != null) {
                        throw ex;
                    } else {
                        fail("Illegal character in authority", q);
                    }
                }
                return n;
            }
            String unused6 = URI.this.authority = substring(start, n);
            return n;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x008f, code lost:
            r2 = r2 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int parseServer(int r12, int r13) throws java.net.URISyntaxException {
            /*
                r11 = this;
                r2 = r12
                java.lang.String r1 = "/?#"
                java.lang.String r4 = "@"
                int r3 = r11.scan((int) r12, (int) r13, (java.lang.String) r1, (java.lang.String) r4)
                if (r3 < r12) goto L_0x0030
                r1 = 64
                boolean r1 = r11.at((int) r3, (int) r13, (char) r1)
                if (r1 == 0) goto L_0x0030
                long r4 = java.net.URI.L_USERINFO
                long r6 = java.net.URI.H_USERINFO
                java.lang.String r8 = "user info"
                r1 = r11
                r2 = r12
                r1.checkChars(r2, r3, r4, r6, r8)
                java.net.URI r1 = java.net.URI.this
                java.lang.String r4 = r11.substring(r12, r3)
                java.lang.String unused = r1.userInfo = r4
                int r2 = r3 + 1
            L_0x0030:
                r1 = 91
                boolean r1 = r11.at((int) r2, (int) r13, (char) r1)
                if (r1 == 0) goto L_0x00cd
                int r0 = r2 + 1
                java.lang.String r1 = "/?#"
                java.lang.String r4 = "]"
                int r3 = r11.scan((int) r0, (int) r13, (java.lang.String) r1, (java.lang.String) r4)
                if (r3 <= r0) goto L_0x00c5
                r1 = 93
                boolean r1 = r11.at((int) r3, (int) r13, (char) r1)
                if (r1 == 0) goto L_0x00c5
                java.lang.String r1 = ""
                java.lang.String r4 = "%"
                int r9 = r11.scan((int) r0, (int) r3, (java.lang.String) r1, (java.lang.String) r4)
                if (r9 <= r0) goto L_0x00c1
                r11.parseIPv6Reference(r0, r9)
                int r1 = r9 + 1
                if (r1 != r3) goto L_0x0067
                java.lang.String r1 = "scope id expected"
                r11.fail(r1)
            L_0x0067:
                int r2 = r9 + 1
                long r4 = java.net.URI.L_ALPHANUM
                long r6 = java.net.URI.H_ALPHANUM
                java.lang.String r8 = "scope id"
                r1 = r11
                r1.checkChars(r2, r3, r4, r6, r8)
            L_0x0078:
                java.net.URI r1 = java.net.URI.this
                int r4 = r0 + -1
                int r5 = r3 + 1
                java.lang.String r4 = r11.substring(r4, r5)
                java.lang.String unused = r1.host = r4
                int r2 = r3 + 1
            L_0x0087:
                r1 = 58
                boolean r1 = r11.at((int) r2, (int) r13, (char) r1)
                if (r1 == 0) goto L_0x00b8
                int r2 = r2 + 1
                java.lang.String r1 = ""
                java.lang.String r4 = "/"
                int r3 = r11.scan((int) r2, (int) r13, (java.lang.String) r1, (java.lang.String) r4)
                if (r3 <= r2) goto L_0x00b8
                long r4 = java.net.URI.L_DIGIT
                java.lang.String r8 = "port number"
                r6 = 0
                r1 = r11
                r1.checkChars(r2, r3, r4, r6, r8)
                java.net.URI r1 = java.net.URI.this     // Catch:{ NumberFormatException -> 0x00d9 }
                java.lang.String r4 = r11.substring(r2, r3)     // Catch:{ NumberFormatException -> 0x00d9 }
                int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x00d9 }
                int unused = r1.port = r4     // Catch:{ NumberFormatException -> 0x00d9 }
            L_0x00b7:
                r2 = r3
            L_0x00b8:
                if (r2 >= r13) goto L_0x00c0
                java.lang.String r1 = "port number"
                r11.failExpecting(r1, r2)
            L_0x00c0:
                return r2
            L_0x00c1:
                r11.parseIPv6Reference(r0, r3)
                goto L_0x0078
            L_0x00c5:
                java.lang.String r1 = "closing bracket for IPv6 address"
                r11.failExpecting(r1, r3)
                r2 = r0
                goto L_0x0087
            L_0x00cd:
                int r3 = r11.parseIPv4Address(r2, r13)
                if (r3 > r2) goto L_0x00d7
                int r3 = r11.parseHostname(r2, r13)
            L_0x00d7:
                r2 = r3
                goto L_0x0087
            L_0x00d9:
                r10 = move-exception
                java.lang.String r1 = "Malformed port number"
                r11.fail(r1, r2)
                goto L_0x00b7
            */
            throw new UnsupportedOperationException("Method not decompiled: java.net.URI.Parser.parseServer(int, int):int");
        }

        private int scanByte(int start, int n) throws URISyntaxException {
            int i = start;
            int q = scan(start, n, URI.L_DIGIT, 0);
            if (q > start && Integer.parseInt(substring(start, q)) > 255) {
                return start;
            }
            return q;
        }

        private int scanIPv4Address(int start, int n, boolean strict) throws URISyntaxException {
            int i = start;
            int m = scan(start, n, URI.L_DOT | URI.L_DIGIT, 0 | URI.H_DOT);
            if (m <= start) {
                return -1;
            }
            if (strict && m != n) {
                return -1;
            }
            int q = scanByte(start, m);
            if (q > start) {
                int p = q;
                int q2 = scan(q, m, '.');
                if (q2 <= q) {
                    q = q2;
                } else {
                    int p2 = q2;
                    q = scanByte(q2, m);
                    if (q > q2) {
                        int p3 = q;
                        int q3 = scan(q, m, '.');
                        if (q3 <= q) {
                            q = q3;
                        } else {
                            int p4 = q3;
                            q = scanByte(q3, m);
                            if (q > q3) {
                                int p5 = q;
                                int q4 = scan(q, m, '.');
                                if (q4 <= q) {
                                    q = q4;
                                } else {
                                    int p6 = q4;
                                    q = scanByte(q4, m);
                                    if (q > q4) {
                                        int p7 = q;
                                        if (q >= m) {
                                            return q;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            fail("Malformed IPv4 address", q);
            return -1;
        }

        private int takeIPv4Address(int start, int n, String expected) throws URISyntaxException {
            int p = scanIPv4Address(start, n, true);
            if (p <= start) {
                failExpecting(expected, start);
            }
            return p;
        }

        private int parseIPv4Address(int start, int n) {
            try {
                int p = scanIPv4Address(start, n, URI.f10assertionsDisabled);
                if (p > start && p < n && charAt(p) != ':') {
                    p = -1;
                }
                if (p > start) {
                    String unused = URI.this.host = substring(start, p);
                }
                return p;
            } catch (URISyntaxException e) {
                return -1;
            } catch (NumberFormatException e2) {
                return -1;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
            r2 = r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int parseHostname(int r14, int r15) throws java.net.URISyntaxException {
            /*
                r13 = this;
                r12 = 46
                r2 = r14
                r0 = -1
            L_0x0004:
                if (r2 >= r15) goto L_0x006f
                char r1 = r13.charAt(r2)
                if (r1 != r12) goto L_0x006f
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "URI "
                java.lang.StringBuilder r1 = r1.append((java.lang.String) r3)
                java.lang.String r3 = r13.substring(r14, r15)
                java.lang.StringBuilder r1 = r1.append((java.lang.String) r3)
                java.lang.String r3 = " has empty labels in "
                java.lang.StringBuilder r1 = r1.append((java.lang.String) r3)
                java.lang.String r3 = "the hostname. This is malformed and will not be accepted"
                java.lang.StringBuilder r1 = r1.append((java.lang.String) r3)
                java.lang.String r3 = "in future Android releases."
                java.lang.StringBuilder r1 = r1.append((java.lang.String) r3)
                java.lang.String r1 = r1.toString()
                java.lang.System.logE(r1)
                int r2 = r2 + 1
                r4 = r2
            L_0x003f:
                if (r2 < r15) goto L_0x0004
            L_0x0041:
                if (r2 >= r15) goto L_0x004b
                r1 = 58
                boolean r1 = r13.at((int) r2, (int) r15, (char) r1)
                if (r1 == 0) goto L_0x00c3
            L_0x004b:
                if (r0 >= 0) goto L_0x0053
                java.lang.String r1 = "hostname"
                r13.failExpecting(r1, r14)
            L_0x0053:
                if (r0 <= r14) goto L_0x0065
                char r1 = r13.charAt(r0)
                long r6 = java.net.URI.H_ALPHA
                r8 = 0
                boolean r1 = java.net.URI.match(r1, r8, r6)
                if (r1 == 0) goto L_0x00ca
            L_0x0065:
                java.net.URI r1 = java.net.URI.this
                java.lang.String r3 = r13.substring(r14, r2)
                java.lang.String unused = r1.host = r3
                return r2
            L_0x006f:
                long r4 = java.net.URI.L_ALPHANUM
                long r6 = java.net.URI.H_ALPHANUM
                r1 = r13
                r3 = r15
                int r4 = r1.scan((int) r2, (int) r3, (long) r4, (long) r6)
                if (r4 <= r2) goto L_0x0041
                r0 = r2
                if (r4 <= r2) goto L_0x00ba
                r2 = r4
                long r6 = java.net.URI.L_ALPHANUM
                long r8 = java.net.URI.L_DASH
                long r6 = r6 | r8
                long r8 = java.net.URI.L_UNDERSCORE
                long r6 = r6 | r8
                long r8 = java.net.URI.H_ALPHANUM
                long r10 = java.net.URI.H_DASH
                long r8 = r8 | r10
                long r10 = java.net.URI.H_UNDERSCORE
                long r8 = r8 | r10
                r3 = r13
                r5 = r15
                int r4 = r3.scan((int) r4, (int) r5, (long) r6, (long) r8)
                if (r4 <= r2) goto L_0x00ba
                int r1 = r4 + -1
                char r1 = r13.charAt(r1)
                r3 = 45
                if (r1 != r3) goto L_0x00b9
                java.lang.String r1 = "Illegal character in hostname"
                int r3 = r4 + -1
                r13.fail(r1, r3)
            L_0x00b9:
                r2 = r4
            L_0x00ba:
                int r4 = r13.scan(r2, r15, r12)
                if (r4 <= r2) goto L_0x0041
                r2 = r4
                goto L_0x003f
            L_0x00c3:
                java.lang.String r1 = "Illegal character in hostname"
                r13.fail(r1, r2)
                goto L_0x004b
            L_0x00ca:
                java.lang.String r1 = "Illegal character in hostname"
                r13.fail(r1, r0)
                goto L_0x0065
            */
            throw new UnsupportedOperationException("Method not decompiled: java.net.URI.Parser.parseHostname(int, int):int");
        }

        private int parseIPv6Reference(int start, int n) throws URISyntaxException {
            int p = start;
            boolean compressedZeros = URI.f10assertionsDisabled;
            int q = scanHexSeq(start, n);
            if (q > start) {
                p = q;
                if (at(q, n, "::")) {
                    compressedZeros = true;
                    p = scanHexPost(q + 2, n);
                } else if (at(q, n, ':')) {
                    p = takeIPv4Address(q + 1, n, "IPv4 address");
                    this.ipv6byteCount += 4;
                }
            } else if (at(start, n, "::")) {
                compressedZeros = true;
                p = scanHexPost(start + 2, n);
            }
            if (p < n) {
                fail("Malformed IPv6 address", start);
            }
            if (this.ipv6byteCount > 16) {
                fail("IPv6 address too long", start);
            }
            if (!compressedZeros && this.ipv6byteCount < 16) {
                fail("IPv6 address too short", start);
            }
            if (compressedZeros && this.ipv6byteCount == 16) {
                fail("Malformed IPv6 address", start);
            }
            return p;
        }

        private int scanHexPost(int start, int n) throws URISyntaxException {
            int i = start;
            if (start == n) {
                return start;
            }
            int q = scanHexSeq(start, n);
            if (q > start) {
                int p = q;
                if (!at(q, n, ':')) {
                    return p;
                }
                int p2 = takeIPv4Address(q + 1, n, "hex digits or IPv4 address");
                this.ipv6byteCount += 4;
                return p2;
            }
            int p3 = takeIPv4Address(start, n, "hex digits or IPv4 address");
            this.ipv6byteCount += 4;
            return p3;
        }

        private int scanHexSeq(int start, int n) throws URISyntaxException {
            int i = start;
            int q = scan(start, n, URI.L_HEX, URI.H_HEX);
            if (q <= start || at(q, n, '.')) {
                return -1;
            }
            if (q > start + 4) {
                fail("IPv6 hexadecimal digit sequence too long", start);
            }
            this.ipv6byteCount += 2;
            int p = q;
            while (p < n && at(p, n, ':') && !at(p + 1, n, ':')) {
                int p2 = p + 1;
                int q2 = scan(p2, n, URI.L_HEX, URI.H_HEX);
                if (q2 <= p2) {
                    failExpecting("digits for an IPv6 address", p2);
                }
                if (at(q2, n, '.')) {
                    return p2 - 1;
                }
                if (q2 > p2 + 4) {
                    fail("IPv6 hexadecimal digit sequence too long", p2);
                }
                this.ipv6byteCount += 2;
                p = q2;
            }
            return p;
        }
    }
}
