package java.io;

import dalvik.system.BlockGuard;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;

class UnixFileSystem extends FileSystem {
    private ExpiringCache cache = new ExpiringCache();
    private final char colon = ((String) AccessController.doPrivileged(new GetPropertyAction("path.separator"))).charAt(0);
    private final String javaHome = ((String) AccessController.doPrivileged(new GetPropertyAction("java.home")));
    private ExpiringCache javaHomePrefixCache = new ExpiringCache();
    private final char slash = ((String) AccessController.doPrivileged(new GetPropertyAction("file.separator"))).charAt(0);

    private native String canonicalize0(String str) throws IOException;

    private native boolean checkAccess0(File file, int i);

    private native boolean createDirectory0(File file);

    private native boolean createFileExclusively0(String str) throws IOException;

    private native boolean delete0(File file);

    private native int getBooleanAttributes0(String str);

    private native long getLastModifiedTime0(File file);

    private native long getLength0(File file);

    private native long getSpace0(File file, int i);

    private static native void initIDs();

    private native String[] list0(File file);

    private native boolean rename0(File file, File file2);

    private native boolean setLastModifiedTime0(File file, long j);

    private native boolean setPermission0(File file, int i, boolean z, boolean z2);

    private native boolean setReadOnly0(File file);

    public char getSeparator() {
        return this.slash;
    }

    public char getPathSeparator() {
        return this.colon;
    }

    public String normalize(String pathname) {
        int index;
        int index2;
        int n = pathname.length();
        char[] normalized = pathname.toCharArray();
        char prevChar = 0;
        int i = 0;
        int index3 = 0;
        while (i < n) {
            char current = normalized[i];
            if (current == '/' && prevChar == '/') {
                index2 = index3;
            } else {
                index2 = index3 + 1;
                normalized[index3] = current;
            }
            prevChar = current;
            i++;
            index3 = index2;
        }
        if (prevChar != '/' || n <= 1) {
            index = index3;
        } else {
            index = index3 - 1;
        }
        return index != n ? new String(normalized, 0, index) : pathname;
    }

    public int prefixLength(String pathname) {
        if (pathname.length() != 0 && pathname.charAt(0) == '/') {
            return 1;
        }
        return 0;
    }

    public String resolve(String parent, String child) {
        if (child.isEmpty() || child.equals("/")) {
            return parent;
        }
        if (child.charAt(0) == '/') {
            if (parent.equals("/")) {
                return child;
            }
            return parent + child;
        } else if (parent.equals("/")) {
            return parent + child;
        } else {
            return parent + '/' + child;
        }
    }

    public String getDefaultParent() {
        return "/";
    }

    public String fromURIPath(String path) {
        String p = path;
        if (!path.endsWith("/") || path.length() <= 1) {
            return p;
        }
        return path.substring(0, path.length() - 1);
    }

    public boolean isAbsolute(File f) {
        return f.getPrefixLength() != 0;
    }

    public String resolve(File f) {
        if (isAbsolute(f)) {
            return f.getPath();
        }
        return resolve(System.getProperty("user.dir"), f.getPath());
    }

    public String canonicalize(String path) throws IOException {
        String resDir;
        String resDir2;
        if (!useCanonCaches) {
            return canonicalize0(path);
        }
        String res = this.cache.get(path);
        if (res == null) {
            String dir = null;
            if (!(!useCanonPrefixCache || (dir = parentOrNull(path)) == null || (resDir2 = this.javaHomePrefixCache.get(dir)) == null)) {
                String filename = path.substring(dir.length() + 1);
                res = resDir2 + this.slash + filename;
                this.cache.put(dir + this.slash + filename, res);
            }
            if (res == null) {
                BlockGuard.getThreadPolicy().onReadFromDisk();
                res = canonicalize0(path);
                this.cache.put(path, res);
                if (useCanonPrefixCache && dir != null && dir.startsWith(this.javaHome) && (resDir = parentOrNull(res)) != null && resDir.equals(dir)) {
                    File f = new File(res);
                    if (f.exists() && !f.isDirectory()) {
                        this.javaHomePrefixCache.put(dir, resDir);
                    }
                }
            }
        }
        return res;
    }

    static String parentOrNull(String path) {
        if (path == null) {
            return null;
        }
        char sep = File.separatorChar;
        int last = path.length() - 1;
        int adjacentDots = 0;
        int nonDotCount = 0;
        for (int idx = last; idx > 0; idx--) {
            char c = path.charAt(idx);
            if (c == '.') {
                adjacentDots++;
                if (adjacentDots >= 2) {
                    return null;
                }
            } else if (c != sep) {
                nonDotCount++;
                adjacentDots = 0;
            } else if ((adjacentDots == 1 && nonDotCount == 0) || idx == 0 || idx >= last - 1 || path.charAt(idx - 1) == sep) {
                return null;
            } else {
                return path.substring(0, idx);
            }
        }
        return null;
    }

    public int getBooleanAttributes(File f) {
        boolean hidden;
        int i = 0;
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int rv = getBooleanAttributes0(f.getPath());
        String name = f.getName();
        if (name.length() <= 0 || name.charAt(0) != '.') {
            hidden = false;
        } else {
            hidden = true;
        }
        if (hidden) {
            i = 8;
        }
        return i | rv;
    }

    public boolean checkAccess(File f, int access) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return checkAccess0(f, access);
    }

    public long getLastModifiedTime(File f) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return getLastModifiedTime0(f);
    }

    public long getLength(File f) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return getLength0(f);
    }

    public boolean setPermission(File f, int access, boolean enable, boolean owneronly) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return setPermission0(f, access, enable, owneronly);
    }

    public boolean createFileExclusively(String path) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return createFileExclusively0(path);
    }

    public boolean delete(File f) {
        this.cache.clear();
        this.javaHomePrefixCache.clear();
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return delete0(f);
    }

    public String[] list(File f) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return list0(f);
    }

    public boolean createDirectory(File f) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return createDirectory0(f);
    }

    public boolean rename(File f1, File f2) {
        this.cache.clear();
        this.javaHomePrefixCache.clear();
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return rename0(f1, f2);
    }

    public boolean setLastModifiedTime(File f, long time) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return setLastModifiedTime0(f, time);
    }

    public boolean setReadOnly(File f) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return setReadOnly0(f);
    }

    public File[] listRoots() {
        try {
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkRead("/");
            }
            return new File[]{new File("/")};
        } catch (SecurityException e) {
            return new File[0];
        }
    }

    public long getSpace(File f, int t) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return getSpace0(f, t);
    }

    public int compare(File f1, File f2) {
        return f1.getPath().compareTo(f2.getPath());
    }

    public int hashCode(File f) {
        return f.getPath().hashCode() ^ 1234321;
    }
}
