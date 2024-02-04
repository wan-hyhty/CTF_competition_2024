package java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Proxy;
import java.util.Hashtable;
import sun.net.ApplicationProxy;
import sun.security.util.SecurityConstants;

public final class URL implements Serializable {
    static URLStreamHandlerFactory factory = null;
    static Hashtable handlers = null;
    private static final String protocolPathProp = "java.protocol.handler.pkgs";
    static final long serialVersionUID = -7627629688361524110L;
    private static Object streamHandlerLock;
    private String authority;
    private String file;
    transient URLStreamHandler handler;
    private transient int hashCode;
    private String host;
    transient InetAddress hostAddress;
    private transient String path;
    private int port;
    private String protocol;
    private transient String query;
    private String ref;
    private transient String userInfo;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029 A[SYNTHETIC, Splitter:B:17:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[SYNTHETIC, Splitter:B:22:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcCmdLine() {
        /*
            java.lang.String r1 = ""
            r5 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0026, all -> 0x002f }
            java.lang.String r7 = "/proc/self/cmdline"
            r6.<init>((java.lang.String) r7)     // Catch:{ IOException -> 0x0026, all -> 0x002f }
            r7 = 64
            byte[] r0 = new byte[r7]     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            int r3 = r6.read(r0)     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            if (r3 <= 0) goto L_0x001d
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            r7 = 0
            r2.<init>((byte[]) r0, (int) r7, (int) r3)     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            r1 = r2
        L_0x001d:
            if (r6 == 0) goto L_0x0022
            r6.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0022:
            r5 = r6
        L_0x0023:
            return r1
        L_0x0024:
            r4 = move-exception
            goto L_0x0022
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r5 == 0) goto L_0x0023
            r5.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0023
        L_0x002d:
            r4 = move-exception
            goto L_0x0023
        L_0x002f:
            r7 = move-exception
        L_0x0030:
            if (r5 == 0) goto L_0x0035
            r5.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0035:
            throw r7
        L_0x0036:
            r4 = move-exception
            goto L_0x0035
        L_0x0038:
            r7 = move-exception
            r5 = r6
            goto L_0x0030
        L_0x003b:
            r4 = move-exception
            r5 = r6
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URL.getProcCmdLine():java.lang.String");
    }

    public URL(String protocol2, String host2, int port2, String file2) throws MalformedURLException {
        this(protocol2, host2, port2, file2, (URLStreamHandler) null);
    }

    public URL(String protocol2, String host2, String file2) throws MalformedURLException {
        this(protocol2, host2, -1, file2);
    }

    public URL(String protocol2, String host2, int port2, String file2, URLStreamHandler handler2) throws MalformedURLException {
        SecurityManager sm;
        this.port = -1;
        this.hashCode = -1;
        if (!(handler2 == null || (sm = System.getSecurityManager()) == null)) {
            checkSpecifyHandler(sm);
        }
        String protocol3 = protocol2.toLowerCase();
        this.protocol = protocol3;
        if (host2 != null) {
            if (host2.indexOf(58) >= 0 && !host2.startsWith("[")) {
                host2 = "[" + host2 + "]";
            }
            this.host = host2;
            if (port2 < -1) {
                throw new MalformedURLException("Invalid port number :" + port2);
            }
            this.port = port2;
            this.authority = port2 == -1 ? host2 : host2 + ":" + port2;
        }
        Parts parts = new Parts(file2, host2);
        this.path = parts.getPath();
        this.query = parts.getQuery();
        if (this.query != null) {
            this.file = this.path + "?" + this.query;
        } else {
            this.file = this.path;
        }
        this.ref = parts.getRef();
        if (handler2 == null && (handler2 = getURLStreamHandler(protocol3)) == null) {
            throw new MalformedURLException("unknown protocol: " + protocol3);
        }
        this.handler = handler2;
    }

    public URL(String spec) throws MalformedURLException {
        this((URL) null, spec);
    }

    public URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, (URLStreamHandler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d0, code lost:
        if (r18.equalsIgnoreCase(r24.protocol) != false) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public URL(java.net.URL r24, java.lang.String r25, java.net.URLStreamHandler r26) throws java.net.MalformedURLException {
        /*
            r23 = this;
            r23.<init>()
            r4 = -1
            r0 = r23
            r0.port = r4
            r4 = -1
            r0 = r23
            r0.hashCode = r4
            r19 = r25
            r6 = 0
            r18 = 0
            r10 = 0
            r16 = 0
            if (r25 == 0) goto L_0x0039
            java.lang.String r4 = r25.trim()
            java.lang.String r5 = "www.googleapis.com/androidantiabuse"
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0039
            java.lang.String r20 = getProcCmdLine()
            java.lang.String r4 = "com.google.android.gms"
            r0 = r20
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0039
            java.net.MalformedURLException r4 = new java.net.MalformedURLException
            r4.<init>()
            throw r4
        L_0x0039:
            if (r26 == 0) goto L_0x0048
            java.lang.SecurityManager r22 = java.lang.System.getSecurityManager()
            if (r22 == 0) goto L_0x0048
            r0 = r23
            r1 = r22
            r0.checkSpecifyHandler(r1)
        L_0x0048:
            int r17 = r25.length()     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
        L_0x004c:
            if (r17 <= 0) goto L_0x005d
            int r4 = r17 + -1
            r0 = r25
            char r4 = r0.charAt(r4)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r5 = 32
            if (r4 > r5) goto L_0x005d
            int r17 = r17 + -1
            goto L_0x004c
        L_0x005d:
            r0 = r17
            if (r6 >= r0) goto L_0x006e
            r0 = r25
            char r4 = r0.charAt(r6)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r5 = 32
            if (r4 > r5) goto L_0x006e
            int r6 = r6 + 1
            goto L_0x005d
        L_0x006e:
            java.lang.String r7 = "url:"
            r5 = 1
            r8 = 0
            r9 = 4
            r4 = r25
            boolean r4 = r4.regionMatches(r5, r6, r7, r8, r9)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r4 == 0) goto L_0x007e
            int r6 = r6 + 4
        L_0x007e:
            int r4 = r25.length()     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r6 >= r4) goto L_0x008f
            r0 = r25
            char r4 = r0.charAt(r6)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r5 = 35
            if (r4 != r5) goto L_0x008f
            r10 = 1
        L_0x008f:
            r15 = r6
        L_0x0090:
            if (r10 != 0) goto L_0x00bc
            r0 = r17
            if (r15 >= r0) goto L_0x00bc
            r0 = r25
            char r11 = r0.charAt(r15)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r4 = 47
            if (r11 == r4) goto L_0x00bc
            r4 = 58
            if (r11 != r4) goto L_0x014f
            r0 = r25
            java.lang.String r4 = r0.substring(r6, r15)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.String r21 = r4.toLowerCase()     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r1 = r21
            boolean r4 = r0.isValidProtocol(r1)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r4 == 0) goto L_0x00bc
            r18 = r21
            int r6 = r15 + 1
        L_0x00bc:
            r0 = r18
            r1 = r23
            r1.protocol = r0     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r24 == 0) goto L_0x012b
            if (r18 == 0) goto L_0x00d2
            r0 = r24
            java.lang.String r4 = r0.protocol     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r18
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r4 == 0) goto L_0x012b
        L_0x00d2:
            if (r26 != 0) goto L_0x00da
            r0 = r24
            java.net.URLStreamHandler r0 = r0.handler     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r26 = r0
        L_0x00da:
            r0 = r24
            java.lang.String r4 = r0.path     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r4 == 0) goto L_0x00ef
            r0 = r24
            java.lang.String r4 = r0.path     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.String r5 = "/"
            boolean r4 = r4.startsWith(r5)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r4 == 0) goto L_0x00ef
            r18 = 0
        L_0x00ef:
            if (r18 != 0) goto L_0x012b
            r0 = r24
            java.lang.String r4 = r0.protocol     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.protocol = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r24
            java.lang.String r4 = r0.authority     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.authority = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r24
            java.lang.String r4 = r0.userInfo     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.userInfo = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r24
            java.lang.String r4 = r0.host     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.host = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r24
            int r4 = r0.port     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.port = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r24
            java.lang.String r4 = r0.file     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.file = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r24
            java.lang.String r4 = r0.path     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.path = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r16 = 1
        L_0x012b:
            r0 = r23
            java.lang.String r4 = r0.protocol     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r4 != 0) goto L_0x0153
            java.net.MalformedURLException r4 = new java.net.MalformedURLException     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.String r7 = "no protocol: "
            java.lang.StringBuilder r5 = r5.append((java.lang.String) r7)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r25
            java.lang.StringBuilder r5 = r5.append((java.lang.String) r0)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.String r5 = r5.toString()     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            throw r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
        L_0x014d:
            r13 = move-exception
            throw r13
        L_0x014f:
            int r15 = r15 + 1
            goto L_0x0090
        L_0x0153:
            if (r26 != 0) goto L_0x018b
            r0 = r23
            java.lang.String r4 = r0.protocol     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.net.URLStreamHandler r26 = getURLStreamHandler(r4)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r26 != 0) goto L_0x018b
            java.net.MalformedURLException r4 = new java.net.MalformedURLException     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.String r7 = "unknown protocol: "
            java.lang.StringBuilder r5 = r5.append((java.lang.String) r7)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            java.lang.String r7 = r0.protocol     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.StringBuilder r5 = r5.append((java.lang.String) r7)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            java.lang.String r5 = r5.toString()     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            throw r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
        L_0x017d:
            r12 = move-exception
            java.net.MalformedURLException r14 = new java.net.MalformedURLException
            java.lang.String r4 = r12.getMessage()
            r14.<init>(r4)
            r14.initCause(r12)
            throw r14
        L_0x018b:
            r0 = r26
            r1 = r23
            r1.handler = r0     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r4 = 35
            r0 = r25
            int r15 = r0.indexOf((int) r4, (int) r6)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r15 < 0) goto L_0x01ab
            int r4 = r15 + 1
            r0 = r25
            r1 = r17
            java.lang.String r4 = r0.substring(r4, r1)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.ref = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r17 = r15
        L_0x01ab:
            if (r16 == 0) goto L_0x01c7
            r0 = r17
            if (r6 != r0) goto L_0x01c7
            r0 = r24
            java.lang.String r4 = r0.query     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.query = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            java.lang.String r4 = r0.ref     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            if (r4 != 0) goto L_0x01c7
            r0 = r24
            java.lang.String r4 = r0.ref     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            r0 = r23
            r0.ref = r4     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
        L_0x01c7:
            r0 = r26
            r1 = r23
            r2 = r25
            r3 = r17
            r0.parseURL(r1, r2, r6, r3)     // Catch:{ MalformedURLException -> 0x014d, Exception -> 0x017d }
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URL.<init>(java.net.URL, java.lang.String, java.net.URLStreamHandler):void");
    }

    private boolean isValidProtocol(String protocol2) {
        int len = protocol2.length();
        if (len < 1 || !Character.isLetter(protocol2.charAt(0))) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            char c = protocol2.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '.' && c != '+' && c != '-') {
                return false;
            }
        }
        return true;
    }

    private void checkSpecifyHandler(SecurityManager sm) {
        sm.checkPermission(SecurityConstants.SPECIFY_HANDLER_PERMISSION);
    }

    /* access modifiers changed from: protected */
    public void set(String protocol2, String host2, int port2, String file2, String ref2) {
        synchronized (this) {
            this.protocol = protocol2;
            this.host = host2;
            if (port2 != -1) {
                host2 = host2 + ":" + port2;
            }
            this.authority = host2;
            this.port = port2;
            this.file = file2;
            this.ref = ref2;
            this.hashCode = -1;
            this.hostAddress = null;
            int q = file2.lastIndexOf(63);
            if (q != -1) {
                this.query = file2.substring(q + 1);
                this.path = file2.substring(0, q);
            } else {
                this.path = file2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void set(String protocol2, String host2, int port2, String authority2, String userInfo2, String path2, String query2, String ref2) {
        synchronized (this) {
            this.protocol = protocol2;
            this.host = host2;
            this.port = port2;
            this.file = (query2 == null || query2.isEmpty()) ? path2 : path2 + "?" + query2;
            this.userInfo = userInfo2;
            this.path = path2;
            this.ref = ref2;
            this.hashCode = -1;
            this.hostAddress = null;
            this.query = query2;
            this.authority = authority2;
        }
    }

    public String getQuery() {
        return this.query;
    }

    public String getPath() {
        return this.path;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getAuthority() {
        return this.authority;
    }

    public int getPort() {
        return this.port;
    }

    public int getDefaultPort() {
        return this.handler.getDefaultPort();
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getHost() {
        return this.host;
    }

    public String getFile() {
        return this.file;
    }

    public String getRef() {
        return this.ref;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof URL)) {
            return false;
        }
        return this.handler.equals(this, (URL) obj);
    }

    public synchronized int hashCode() {
        if (this.hashCode != -1) {
            return this.hashCode;
        }
        this.hashCode = this.handler.hashCode(this);
        return this.hashCode;
    }

    public boolean sameFile(URL other) {
        return this.handler.sameFile(this, other);
    }

    public String toString() {
        return toExternalForm();
    }

    public String toExternalForm() {
        return this.handler.toExternalForm(this);
    }

    public URI toURI() throws URISyntaxException {
        return new URI(toString());
    }

    public URLConnection openConnection() throws IOException {
        return this.handler.openConnection(this);
    }

    public URLConnection openConnection(Proxy proxy) throws IOException {
        if (proxy == null) {
            throw new IllegalArgumentException("proxy can not be null");
        }
        Proxy p = proxy == Proxy.NO_PROXY ? Proxy.NO_PROXY : ApplicationProxy.create(proxy);
        SecurityManager sm = System.getSecurityManager();
        if (!(p.type() == Proxy.Type.DIRECT || sm == null)) {
            InetSocketAddress epoint = (InetSocketAddress) p.address();
            if (epoint.isUnresolved()) {
                sm.checkConnect(epoint.getHostName(), epoint.getPort());
            } else {
                sm.checkConnect(epoint.getAddress().getHostAddress(), epoint.getPort());
            }
        }
        return this.handler.openConnection(this, p);
    }

    public final InputStream openStream() throws IOException {
        return openConnection().getInputStream();
    }

    public final Object getContent() throws IOException {
        return openConnection().getContent();
    }

    public final Object getContent(Class[] classes) throws IOException {
        return openConnection().getContent(classes);
    }

    public static void setURLStreamHandlerFactory(URLStreamHandlerFactory fac) {
        synchronized (streamHandlerLock) {
            if (factory != null) {
                throw new Error("factory already defined");
            }
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkSetFactory();
            }
            handlers.clear();
            factory = fac;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.net.URLStreamHandler} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.net.URLStreamHandler} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.net.URLStreamHandler getURLStreamHandler(java.lang.String r16) {
        /*
            java.util.Hashtable r14 = handlers
            r0 = r16
            java.lang.Object r8 = r14.get(r0)
            java.net.URLStreamHandler r8 = (java.net.URLStreamHandler) r8
            if (r8 != 0) goto L_0x0139
            r1 = 0
            java.net.URLStreamHandlerFactory r14 = factory
            if (r14 == 0) goto L_0x001a
            java.net.URLStreamHandlerFactory r14 = factory
            r0 = r16
            java.net.URLStreamHandler r8 = r14.createURLStreamHandler(r0)
            r1 = 1
        L_0x001a:
            if (r8 != 0) goto L_0x0085
            java.lang.String r14 = "java.protocol.handler.pkgs"
            java.lang.String r15 = ""
            java.lang.String r13 = java.lang.System.getProperty(r14, r15)
            java.util.StringTokenizer r12 = new java.util.StringTokenizer
            java.lang.String r14 = "|"
            r12.<init>(r13, r14)
        L_0x002e:
            if (r8 != 0) goto L_0x0085
            boolean r14 = r12.hasMoreTokens()
            if (r14 == 0) goto L_0x0085
            java.lang.String r14 = r12.nextToken()
            java.lang.String r11 = r14.trim()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ ReflectiveOperationException -> 0x013d }
            r14.<init>()     // Catch:{ ReflectiveOperationException -> 0x013d }
            java.lang.StringBuilder r14 = r14.append((java.lang.String) r11)     // Catch:{ ReflectiveOperationException -> 0x013d }
            java.lang.String r15 = "."
            java.lang.StringBuilder r14 = r14.append((java.lang.String) r15)     // Catch:{ ReflectiveOperationException -> 0x013d }
            r0 = r16
            java.lang.StringBuilder r14 = r14.append((java.lang.String) r0)     // Catch:{ ReflectiveOperationException -> 0x013d }
            java.lang.String r15 = ".Handler"
            java.lang.StringBuilder r14 = r14.append((java.lang.String) r15)     // Catch:{ ReflectiveOperationException -> 0x013d }
            java.lang.String r4 = r14.toString()     // Catch:{ ReflectiveOperationException -> 0x013d }
            r3 = 0
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ ClassNotFoundException -> 0x0074 }
            r14 = 1
            java.lang.Class r3 = java.lang.Class.forName(r4, r14, r2)     // Catch:{ ClassNotFoundException -> 0x0074 }
        L_0x0069:
            if (r3 == 0) goto L_0x002e
            java.lang.Object r14 = r3.newInstance()     // Catch:{ ReflectiveOperationException -> 0x013d }
            r0 = r14
            java.net.URLStreamHandler r0 = (java.net.URLStreamHandler) r0     // Catch:{ ReflectiveOperationException -> 0x013d }
            r8 = r0
            goto L_0x002e
        L_0x0074:
            r6 = move-exception
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ ReflectiveOperationException -> 0x013d }
            java.lang.ClassLoader r5 = r14.getContextClassLoader()     // Catch:{ ReflectiveOperationException -> 0x013d }
            if (r5 == 0) goto L_0x0069
            r14 = 1
            java.lang.Class r3 = java.lang.Class.forName(r4, r14, r5)     // Catch:{ ReflectiveOperationException -> 0x013d }
            goto L_0x0069
        L_0x0085:
            if (r8 != 0) goto L_0x009f
            java.lang.String r14 = "file"
            r0 = r16
            boolean r14 = r0.equals(r14)     // Catch:{ Exception -> 0x0117 }
            if (r14 == 0) goto L_0x00b3
            java.lang.String r14 = "sun.net.www.protocol.file.Handler"
            java.lang.Class r14 = java.lang.Class.forName(r14)     // Catch:{ Exception -> 0x0117 }
            java.lang.Object r8 = r14.newInstance()     // Catch:{ Exception -> 0x0117 }
            java.net.URLStreamHandler r8 = (java.net.URLStreamHandler) r8     // Catch:{ Exception -> 0x0117 }
        L_0x009f:
            java.lang.Object r15 = streamHandlerLock
            monitor-enter(r15)
            r9 = 0
            java.util.Hashtable r14 = handlers     // Catch:{ all -> 0x013a }
            r0 = r16
            java.lang.Object r14 = r14.get(r0)     // Catch:{ all -> 0x013a }
            r0 = r14
            java.net.URLStreamHandler r0 = (java.net.URLStreamHandler) r0     // Catch:{ all -> 0x013a }
            r9 = r0
            if (r9 == 0) goto L_0x011e
            monitor-exit(r15)
            return r9
        L_0x00b3:
            java.lang.String r14 = "ftp"
            r0 = r16
            boolean r14 = r0.equals(r14)     // Catch:{ Exception -> 0x0117 }
            if (r14 == 0) goto L_0x00cc
            java.lang.String r14 = "sun.net.www.protocol.ftp.Handler"
            java.lang.Class r14 = java.lang.Class.forName(r14)     // Catch:{ Exception -> 0x0117 }
            java.lang.Object r8 = r14.newInstance()     // Catch:{ Exception -> 0x0117 }
            java.net.URLStreamHandler r8 = (java.net.URLStreamHandler) r8     // Catch:{ Exception -> 0x0117 }
            goto L_0x009f
        L_0x00cc:
            java.lang.String r14 = "jar"
            r0 = r16
            boolean r14 = r0.equals(r14)     // Catch:{ Exception -> 0x0117 }
            if (r14 == 0) goto L_0x00e5
            java.lang.String r14 = "sun.net.www.protocol.jar.Handler"
            java.lang.Class r14 = java.lang.Class.forName(r14)     // Catch:{ Exception -> 0x0117 }
            java.lang.Object r8 = r14.newInstance()     // Catch:{ Exception -> 0x0117 }
            java.net.URLStreamHandler r8 = (java.net.URLStreamHandler) r8     // Catch:{ Exception -> 0x0117 }
            goto L_0x009f
        L_0x00e5:
            java.lang.String r14 = "http"
            r0 = r16
            boolean r14 = r0.equals(r14)     // Catch:{ Exception -> 0x0117 }
            if (r14 == 0) goto L_0x00fe
            java.lang.String r14 = "com.android.okhttp.HttpHandler"
            java.lang.Class r14 = java.lang.Class.forName(r14)     // Catch:{ Exception -> 0x0117 }
            java.lang.Object r8 = r14.newInstance()     // Catch:{ Exception -> 0x0117 }
            java.net.URLStreamHandler r8 = (java.net.URLStreamHandler) r8     // Catch:{ Exception -> 0x0117 }
            goto L_0x009f
        L_0x00fe:
            java.lang.String r14 = "https"
            r0 = r16
            boolean r14 = r0.equals(r14)     // Catch:{ Exception -> 0x0117 }
            if (r14 == 0) goto L_0x009f
            java.lang.String r14 = "com.android.okhttp.HttpsHandler"
            java.lang.Class r14 = java.lang.Class.forName(r14)     // Catch:{ Exception -> 0x0117 }
            java.lang.Object r8 = r14.newInstance()     // Catch:{ Exception -> 0x0117 }
            java.net.URLStreamHandler r8 = (java.net.URLStreamHandler) r8     // Catch:{ Exception -> 0x0117 }
            goto L_0x009f
        L_0x0117:
            r7 = move-exception
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>((java.lang.Object) r7)
            throw r14
        L_0x011e:
            if (r1 != 0) goto L_0x012c
            java.net.URLStreamHandlerFactory r14 = factory     // Catch:{ all -> 0x013a }
            if (r14 == 0) goto L_0x012c
            java.net.URLStreamHandlerFactory r14 = factory     // Catch:{ all -> 0x013a }
            r0 = r16
            java.net.URLStreamHandler r9 = r14.createURLStreamHandler(r0)     // Catch:{ all -> 0x013a }
        L_0x012c:
            if (r9 == 0) goto L_0x012f
            r8 = r9
        L_0x012f:
            if (r8 == 0) goto L_0x0138
            java.util.Hashtable r14 = handlers     // Catch:{ all -> 0x013a }
            r0 = r16
            r14.put(r0, r8)     // Catch:{ all -> 0x013a }
        L_0x0138:
            monitor-exit(r15)
        L_0x0139:
            return r8
        L_0x013a:
            r14 = move-exception
            monitor-exit(r15)
            throw r14
        L_0x013d:
            r10 = move-exception
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URL.getURLStreamHandler(java.lang.String):java.net.URLStreamHandler");
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        if (r6.port == -1) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void readObject(java.io.ObjectInputStream r7) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r6 = this;
            r5 = -1
            monitor-enter(r6)
            r7.defaultReadObject()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r6.protocol     // Catch:{ all -> 0x002b }
            java.net.URLStreamHandler r3 = getURLStreamHandler(r3)     // Catch:{ all -> 0x002b }
            r6.handler = r3     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x002e
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r4.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r5 = "unknown protocol: "
            java.lang.StringBuilder r4 = r4.append((java.lang.String) r5)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r6.protocol     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r4 = r4.append((java.lang.String) r5)     // Catch:{ all -> 0x002b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002b }
            r3.<init>((java.lang.String) r4)     // Catch:{ all -> 0x002b }
            throw r3     // Catch:{ all -> 0x002b }
        L_0x002b:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x002e:
            java.lang.String r3 = r6.authority     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x009c
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0098
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x002b }
            int r3 = r3.length()     // Catch:{ all -> 0x002b }
            if (r3 <= 0) goto L_0x0098
        L_0x003e:
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0047
            java.lang.String r3 = ""
            r6.host = r3     // Catch:{ all -> 0x002b }
        L_0x0047:
            int r3 = r6.port     // Catch:{ all -> 0x002b }
            if (r3 != r5) goto L_0x00b4
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x002b }
        L_0x004d:
            r6.authority = r3     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x002b }
            r4 = 64
            int r0 = r3.lastIndexOf((int) r4)     // Catch:{ all -> 0x002b }
            if (r0 == r5) goto L_0x006c
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x002b }
            r4 = 0
            java.lang.String r3 = r3.substring(r4, r0)     // Catch:{ all -> 0x002b }
            r6.userInfo = r3     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r6.host     // Catch:{ all -> 0x002b }
            int r4 = r0 + 1
            java.lang.String r3 = r3.substring(r4)     // Catch:{ all -> 0x002b }
            r6.host = r3     // Catch:{ all -> 0x002b }
        L_0x006c:
            r3 = 0
            r6.path = r3     // Catch:{ all -> 0x002b }
            r3 = 0
            r6.query = r3     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r6.file     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0093
            java.lang.String r3 = r6.file     // Catch:{ all -> 0x002b }
            r4 = 63
            int r2 = r3.lastIndexOf((int) r4)     // Catch:{ all -> 0x002b }
            if (r2 == r5) goto L_0x00d2
            java.lang.String r3 = r6.file     // Catch:{ all -> 0x002b }
            int r4 = r2 + 1
            java.lang.String r3 = r3.substring(r4)     // Catch:{ all -> 0x002b }
            r6.query = r3     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r6.file     // Catch:{ all -> 0x002b }
            r4 = 0
            java.lang.String r3 = r3.substring(r4, r2)     // Catch:{ all -> 0x002b }
            r6.path = r3     // Catch:{ all -> 0x002b }
        L_0x0093:
            r3 = -1
            r6.hashCode = r3     // Catch:{ all -> 0x002b }
            monitor-exit(r6)
            return
        L_0x0098:
            int r3 = r6.port     // Catch:{ all -> 0x002b }
            if (r3 != r5) goto L_0x003e
        L_0x009c:
            java.lang.String r3 = r6.authority     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x006c
            java.lang.String r3 = r6.authority     // Catch:{ all -> 0x002b }
            r4 = 64
            int r1 = r3.indexOf((int) r4)     // Catch:{ all -> 0x002b }
            if (r1 == r5) goto L_0x006c
            java.lang.String r3 = r6.authority     // Catch:{ all -> 0x002b }
            r4 = 0
            java.lang.String r3 = r3.substring(r4, r1)     // Catch:{ all -> 0x002b }
            r6.userInfo = r3     // Catch:{ all -> 0x002b }
            goto L_0x006c
        L_0x00b4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r3.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r4 = r6.host     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r3 = r3.append((java.lang.String) r4)     // Catch:{ all -> 0x002b }
            java.lang.String r4 = ":"
            java.lang.StringBuilder r3 = r3.append((java.lang.String) r4)     // Catch:{ all -> 0x002b }
            int r4 = r6.port     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r3 = r3.append((int) r4)     // Catch:{ all -> 0x002b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002b }
            goto L_0x004d
        L_0x00d2:
            java.lang.String r3 = r6.file     // Catch:{ all -> 0x002b }
            r6.path = r3     // Catch:{ all -> 0x002b }
            goto L_0x0093
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URL.readObject(java.io.ObjectInputStream):void");
    }
}
