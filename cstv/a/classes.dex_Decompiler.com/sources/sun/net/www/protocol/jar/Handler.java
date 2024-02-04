package sun.net.www.protocol.jar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import sun.net.www.ParseUtil;

public class Handler extends URLStreamHandler {
    private static final String separator = "!/";

    /* access modifiers changed from: protected */
    public URLConnection openConnection(URL u) throws IOException {
        return new JarURLConnection(u, this);
    }

    private static int indexOfBangSlash(String spec) {
        int indexOfBang = spec.length();
        while (true) {
            int indexOfBang2 = spec.lastIndexOf(33, indexOfBang);
            if (indexOfBang2 == -1) {
                return -1;
            }
            if (indexOfBang2 != spec.length() - 1 && spec.charAt(indexOfBang2 + 1) == '/') {
                return indexOfBang2 + 1;
            }
            indexOfBang = indexOfBang2 - 1;
        }
    }

    /* access modifiers changed from: protected */
    public boolean sameFile(URL u1, URL u2) {
        if (!u1.getProtocol().equals("jar") || !u2.getProtocol().equals("jar")) {
            return false;
        }
        String file1 = u1.getFile();
        String file2 = u2.getFile();
        int sep1 = file1.indexOf(separator);
        int sep2 = file2.indexOf(separator);
        if (sep1 == -1 || sep2 == -1) {
            return super.sameFile(u1, u2);
        }
        if (!file1.substring(sep1 + 2).equals(file2.substring(sep2 + 2))) {
            return false;
        }
        try {
            URL enclosedURL1 = new URL(file1.substring(0, sep1));
            try {
                if (!super.sameFile(enclosedURL1, new URL(file2.substring(0, sep2)))) {
                    return false;
                }
                return true;
            } catch (MalformedURLException e) {
                URL url = enclosedURL1;
                return super.sameFile(u1, u2);
            }
        } catch (MalformedURLException e2) {
            return super.sameFile(u1, u2);
        }
    }

    /* access modifiers changed from: protected */
    public int hashCode(URL u) {
        int h;
        int h2 = 0;
        String protocol = u.getProtocol();
        if (protocol != null) {
            h2 = protocol.hashCode() + 0;
        }
        String file = u.getFile();
        int sep = file.indexOf(separator);
        if (sep == -1) {
            return file.hashCode() + h2;
        }
        String fileWithoutEntry = file.substring(0, sep);
        try {
            URL enclosedURL = new URL(fileWithoutEntry);
            try {
                h = h2 + enclosedURL.hashCode();
                URL url = enclosedURL;
            } catch (MalformedURLException e) {
                URL url2 = enclosedURL;
                h = h2 + fileWithoutEntry.hashCode();
                return h + file.substring(sep + 2).hashCode();
            }
        } catch (MalformedURLException e2) {
            h = h2 + fileWithoutEntry.hashCode();
            return h + file.substring(sep + 2).hashCode();
        }
        return h + file.substring(sep + 2).hashCode();
    }

    /* access modifiers changed from: protected */
    public void parseURL(URL url, String spec, int start, int limit) {
        String file = null;
        String ref = null;
        int refPos = spec.indexOf(35, limit);
        boolean refOnly = refPos == start;
        if (refPos > -1) {
            ref = spec.substring(refPos + 1, spec.length());
            if (refOnly) {
                file = url.getFile();
            }
        }
        boolean absoluteSpec = false;
        if (spec.length() >= 4) {
            absoluteSpec = spec.substring(0, 4).equalsIgnoreCase("jar:");
        }
        String spec2 = spec.substring(start, limit);
        if (absoluteSpec) {
            file = parseAbsoluteSpec(spec2);
        } else if (!refOnly) {
            String file2 = parseContextSpec(url, spec2);
            int bangSlash = indexOfBangSlash(file2);
            file = file2.substring(0, bangSlash) + new ParseUtil().canonizeString(file2.substring(bangSlash));
        }
        setURL(url, "jar", "", -1, file, ref);
    }

    private String parseAbsoluteSpec(String spec) {
        int index = indexOfBangSlash(spec);
        if (index == -1) {
            throw new NullPointerException("no !/ in spec");
        }
        try {
            new URL(spec.substring(0, index - 1));
            return spec;
        } catch (MalformedURLException e) {
            throw new NullPointerException("invalid url: " + spec + " (" + e + ")");
        }
    }

    private String parseContextSpec(URL url, String spec) {
        String ctxFile = url.getFile();
        if (spec.startsWith("/")) {
            int bangSlash = indexOfBangSlash(ctxFile);
            if (bangSlash == -1) {
                throw new NullPointerException("malformed context url:" + url + ": no !/");
            }
            ctxFile = ctxFile.substring(0, bangSlash);
        }
        if (!ctxFile.endsWith("/") && !spec.startsWith("/")) {
            int lastSlash = ctxFile.lastIndexOf(47);
            if (lastSlash == -1) {
                throw new NullPointerException("malformed context url:" + url);
            }
            ctxFile = ctxFile.substring(0, lastSlash + 1);
        }
        return ctxFile + spec;
    }
}
