package java.net;

import java.io.IOException;
import java.util.Objects;
import sun.net.util.IPAddressUtil;

public abstract class URLStreamHandler {
    /* access modifiers changed from: protected */
    public abstract URLConnection openConnection(URL url) throws IOException;

    /* access modifiers changed from: protected */
    public URLConnection openConnection(URL u, Proxy p) throws IOException {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    /* access modifiers changed from: protected */
    public void parseURL(URL u, String spec, int start, int limit) {
        int limit2;
        int limit3;
        String protocol = u.getProtocol();
        String authority = u.getAuthority();
        String userInfo = u.getUserInfo();
        String host = u.getHost();
        int port = u.getPort();
        String path = u.getPath();
        String query = u.getQuery();
        String ref = u.getRef();
        boolean querySet = false;
        if (start < limit) {
            int queryStart = spec.indexOf(63);
            if (queryStart == start) {
            }
            if (queryStart != -1 && queryStart < limit) {
                query = spec.substring(queryStart + 1, limit);
                if (limit > queryStart) {
                    limit = queryStart;
                }
                spec = spec.substring(0, queryStart);
                querySet = true;
            }
        }
        if (0 == 0 && start <= limit - 2 && spec.charAt(start) == '/') {
            if (spec.charAt(start + 1) == '/') {
                int start2 = start + 2;
                int i = spec.indexOf(47, start2);
                if ((i < 0 || i > limit) && ((i = spec.indexOf(63, start2)) < 0 || i > limit)) {
                    i = limit;
                }
                authority = spec.substring(start2, i);
                host = authority;
                int ind = authority.indexOf(64);
                if (ind == -1) {
                    userInfo = null;
                } else if (ind != authority.lastIndexOf(64)) {
                    userInfo = null;
                    host = null;
                } else {
                    userInfo = authority.substring(0, ind);
                    host = authority.substring(ind + 1);
                }
                if (host == null) {
                    host = "";
                } else if (host.length() <= 0 || host.charAt(0) != '[') {
                    int ind2 = host.indexOf(58);
                    port = -1;
                    if (ind2 >= 0) {
                        if (host.length() > ind2 + 1) {
                            char firstPortChar = host.charAt(ind2 + 1);
                            if (firstPortChar < '0' || firstPortChar > '9') {
                                throw new IllegalArgumentException("invalid port: " + host.substring(ind2 + 1));
                            }
                            port = Integer.parseInt(host.substring(ind2 + 1));
                        }
                        host = host.substring(0, ind2);
                    }
                } else {
                    int ind3 = host.indexOf(93);
                    if (ind3 > 2) {
                        String nhost = host;
                        host = host.substring(0, ind3 + 1);
                        if (!IPAddressUtil.isIPv6LiteralAddress(host.substring(1, ind3))) {
                            throw new IllegalArgumentException("Invalid host: " + host);
                        }
                        port = -1;
                        if (nhost.length() > ind3 + 1) {
                            if (nhost.charAt(ind3 + 1) == ':') {
                                int ind4 = ind3 + 1;
                                if (nhost.length() > ind4 + 1) {
                                    port = Integer.parseInt(nhost.substring(ind4 + 1));
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid authority field: " + authority);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid authority field: " + authority);
                    }
                }
                if (port < -1) {
                    throw new IllegalArgumentException("Invalid port number :" + port);
                }
                start = i;
                path = null;
                if (!querySet) {
                    query = null;
                }
            }
        }
        if (host == null) {
            host = "";
        }
        if (start < limit) {
            if (spec.charAt(start) == '/') {
                path = spec.substring(start, limit);
            } else if (path == null || path.length() <= 0) {
                path = (authority != null ? "/" : "") + spec.substring(start, limit);
            } else {
                int ind5 = path.lastIndexOf(47);
                String seperator = "";
                if (ind5 == -1 && authority != null) {
                    seperator = "/";
                }
                path = path.substring(0, ind5 + 1) + seperator + spec.substring(start, limit);
            }
        }
        if (path == null) {
            path = "";
        }
        while (true) {
            int i2 = path.indexOf("/./");
            if (i2 < 0) {
                break;
            }
            path = path.substring(0, i2) + path.substring(i2 + 2);
        }
        int i3 = 0;
        while (true) {
            int i4 = path.indexOf("/../", i3);
            if (i4 < 0) {
                break;
            } else if (i4 == 0) {
                path = path.substring(i4 + 3);
                i3 = 0;
            } else if (i4 <= 0 || (limit3 = path.lastIndexOf(47, i4 - 1)) < 0 || path.indexOf("/../", limit3) == 0) {
                i3 = i4 + 3;
            } else {
                path = path.substring(0, limit3) + path.substring(i4 + 3);
                i3 = 0;
            }
        }
        while (path.endsWith("/..") && (limit2 = path.lastIndexOf(47, path.indexOf("/..") - 1)) >= 0) {
            path = path.substring(0, limit2 + 1);
        }
        if (path.startsWith("./") && path.length() > 2) {
            path = path.substring(2);
        }
        if (path.endsWith("/.")) {
            path = path.substring(0, path.length() - 1);
        }
        if (path.endsWith("?")) {
            path = path.substring(0, path.length() - 1);
        }
        setURL(u, protocol, host, port, authority, userInfo, path, query, ref);
    }

    /* access modifiers changed from: protected */
    public int getDefaultPort() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean equals(URL u1, URL u2) {
        if (!Objects.equals(u1.getRef(), u2.getRef()) || !Objects.equals(u1.getQuery(), u2.getQuery())) {
            return false;
        }
        return sameFile(u1, u2);
    }

    /* access modifiers changed from: protected */
    public int hashCode(URL u) {
        return Objects.hash(u.getRef(), u.getQuery(), u.getProtocol(), u.getFile(), u.getHost(), Integer.valueOf(u.getPort()));
    }

    /* access modifiers changed from: protected */
    public boolean sameFile(URL u1, URL u2) {
        boolean z;
        boolean z2;
        if (u1.getProtocol() == u2.getProtocol()) {
            z = true;
        } else if (u1.getProtocol() != null) {
            z = u1.getProtocol().equalsIgnoreCase(u2.getProtocol());
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (u1.getFile() == u2.getFile()) {
            z2 = true;
        } else if (u1.getFile() != null) {
            z2 = u1.getFile().equals(u2.getFile());
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        return (u1.getPort() != -1 ? u1.getPort() : u1.handler.getDefaultPort()) == (u2.getPort() != -1 ? u2.getPort() : u2.handler.getDefaultPort()) && hostsEqual(u1, u2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.net.InetAddress getHostAddress(java.net.URL r6) {
        /*
            r5 = this;
            r4 = 0
            monitor-enter(r5)
            java.net.InetAddress r3 = r6.hostAddress     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x000a
            java.net.InetAddress r3 = r6.hostAddress     // Catch:{ all -> 0x002b }
            monitor-exit(r5)
            return r3
        L_0x000a:
            java.lang.String r1 = r6.getHost()     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0019
            java.lang.String r3 = ""
            boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001b
        L_0x0019:
            monitor-exit(r5)
            return r4
        L_0x001b:
            java.net.InetAddress r3 = java.net.InetAddress.getByName(r1)     // Catch:{ UnknownHostException -> 0x0028, SecurityException -> 0x0025 }
            r6.hostAddress = r3     // Catch:{ UnknownHostException -> 0x0028, SecurityException -> 0x0025 }
            java.net.InetAddress r3 = r6.hostAddress     // Catch:{ all -> 0x002b }
            monitor-exit(r5)
            return r3
        L_0x0025:
            r2 = move-exception
            monitor-exit(r5)
            return r4
        L_0x0028:
            r0 = move-exception
            monitor-exit(r5)
            return r4
        L_0x002b:
            r3 = move-exception
            monitor-exit(r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URLStreamHandler.getHostAddress(java.net.URL):java.net.InetAddress");
    }

    /* access modifiers changed from: protected */
    public boolean hostsEqual(URL u1, URL u2) {
        if (u1.getHost() != null && u2.getHost() != null) {
            return u1.getHost().equalsIgnoreCase(u2.getHost());
        }
        if (u1.getHost() == null && u2.getHost() == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String toExternalForm(URL u) {
        int len = u.getProtocol().length() + 1;
        if (u.getAuthority() != null && u.getAuthority().length() > 0) {
            len += u.getAuthority().length() + 2;
        }
        if (u.getPath() != null) {
            len += u.getPath().length();
        }
        if (u.getQuery() != null) {
            len += u.getQuery().length() + 1;
        }
        if (u.getRef() != null) {
            len += u.getRef().length() + 1;
        }
        StringBuilder result = new StringBuilder(len);
        result.append(u.getProtocol());
        result.append(":");
        if (u.getAuthority() != null) {
            result.append("//");
            result.append(u.getAuthority());
        }
        String fileAndQuery = u.getFile();
        if (fileAndQuery != null) {
            result.append(fileAndQuery);
        }
        if (u.getRef() != null) {
            result.append("#");
            result.append(u.getRef());
        }
        return result.toString();
    }

    /* access modifiers changed from: protected */
    public void setURL(URL u, String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref) {
        if (this != u.handler) {
            throw new SecurityException("handler for url different from this handler");
        }
        u.set(u.getProtocol(), host, port, authority, userInfo, path, query, ref);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void setURL(URL u, String protocol, String host, int port, String file, String ref) {
        String authority = null;
        String userInfo = null;
        if (!(host == null || host.length() == 0)) {
            authority = port == -1 ? host : host + ":" + port;
            int at = host.lastIndexOf(64);
            if (at != -1) {
                userInfo = host.substring(0, at);
                host = host.substring(at + 1);
            }
        }
        String path = null;
        String query = null;
        if (file != null) {
            int q = file.lastIndexOf(63);
            if (q != -1) {
                query = file.substring(q + 1);
                path = file.substring(0, q);
            } else {
                path = file;
            }
        }
        setURL(u, protocol, host, port, authority, userInfo, path, query, ref);
    }
}
