package java.net;

public interface CookiePolicy {
    public static final CookiePolicy ACCEPT_ALL = null;
    public static final CookiePolicy ACCEPT_NONE = null;
    public static final CookiePolicy ACCEPT_ORIGINAL_SERVER = null;

    boolean shouldAccept(URI uri, HttpCookie httpCookie);
}
