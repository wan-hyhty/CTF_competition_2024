package java.net;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Types;
import sun.security.action.GetPropertyAction;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class SocksSocketImpl extends PlainSocketImpl implements SocksConsts {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f9assertionsDisabled = false;
    private boolean applicationSetProxy;
    /* access modifiers changed from: private */
    public InputStream cmdIn;
    /* access modifiers changed from: private */
    public OutputStream cmdOut;
    /* access modifiers changed from: private */
    public Socket cmdsock;
    private InetSocketAddress external_address;
    /* access modifiers changed from: private */
    public String server;
    /* access modifiers changed from: private */
    public int serverPort;
    private boolean useV4;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.net.SocksSocketImpl.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.net.SocksSocketImpl.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.SocksSocketImpl.<clinit>():void");
    }

    SocksSocketImpl() {
        this.server = null;
        this.serverPort = SocksConsts.DEFAULT_PORT;
        this.useV4 = false;
        this.cmdsock = null;
        this.cmdIn = null;
        this.cmdOut = null;
    }

    SocksSocketImpl(String server2, int port) {
        this.server = null;
        this.serverPort = SocksConsts.DEFAULT_PORT;
        this.useV4 = false;
        this.cmdsock = null;
        this.cmdIn = null;
        this.cmdOut = null;
        this.server = server2;
        this.serverPort = port == -1 ? 1080 : port;
    }

    SocksSocketImpl(Proxy proxy) {
        this.server = null;
        this.serverPort = SocksConsts.DEFAULT_PORT;
        this.useV4 = false;
        this.cmdsock = null;
        this.cmdIn = null;
        this.cmdOut = null;
        SocketAddress a = proxy.address();
        if (a instanceof InetSocketAddress) {
            InetSocketAddress ad = (InetSocketAddress) a;
            this.server = ad.getHostString();
            this.serverPort = ad.getPort();
        }
    }

    /* access modifiers changed from: package-private */
    public void setV4() {
        this.useV4 = true;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private synchronized void privilegedConnect(java.lang.String r3, int r4, int r5) throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.net.SocksSocketImpl$1 r1 = new java.net.SocksSocketImpl$1     // Catch:{ PrivilegedActionException -> 0x000b }
            r1.<init>(r2, r3, r4, r5)     // Catch:{ PrivilegedActionException -> 0x000b }
            java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x000b }
            monitor-exit(r2)
            return
        L_0x000b:
            r0 = move-exception
            java.lang.Exception r1 = r0.getException()     // Catch:{ all -> 0x0013 }
            java.io.IOException r1 = (java.io.IOException) r1     // Catch:{ all -> 0x0013 }
            throw r1     // Catch:{ all -> 0x0013 }
        L_0x0013:
            r1 = move-exception
            monitor-exit(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.SocksSocketImpl.privilegedConnect(java.lang.String, int, int):void");
    }

    /* access modifiers changed from: private */
    public void superConnectServer(String host, int port, int timeout) throws IOException {
        super.connect((SocketAddress) new InetSocketAddress(host, port), timeout);
    }

    private static int remainingMillis(long deadlineMillis) throws IOException {
        if (deadlineMillis == 0) {
            return 0;
        }
        long remaining = deadlineMillis - System.currentTimeMillis();
        if (remaining > 0) {
            return (int) remaining;
        }
        throw new SocketTimeoutException();
    }

    private int readSocksReply(InputStream in, byte[] data) throws IOException {
        return readSocksReply(in, data, 0);
    }

    private int readSocksReply(InputStream in, byte[] data, long deadlineMillis) throws IOException {
        int len = data.length;
        int received = 0;
        int attempts = 0;
        while (received < len && attempts < 3) {
            try {
                int count = ((SocketInputStream) in).read(data, received, len - received, remainingMillis(deadlineMillis));
                if (count < 0) {
                    throw new SocketException("Malformed reply from SOCKS server");
                }
                received += count;
                attempts++;
            } catch (SocketTimeoutException e) {
                throw new SocketTimeoutException("Connect timed out");
            }
        }
        return received;
    }

    private boolean authenticate(byte method, InputStream in, BufferedOutputStream out) throws IOException {
        return authenticate(method, in, out, 0);
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private boolean authenticate(byte r11, java.io.InputStream r12, java.io.BufferedOutputStream r13, long r14) throws java.io.IOException {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0004
            r7 = 1
            return r7
        L_0x0004:
            r7 = 2
            if (r11 != r7) goto L_0x009a
            r3 = 0
            java.lang.String r7 = r10.server
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r7)
            java.net.SocksSocketImpl$2 r7 = new java.net.SocksSocketImpl$2
            r7.<init>(r10, r0)
            java.lang.Object r4 = java.security.AccessController.doPrivileged(r7)
            java.net.PasswordAuthentication r4 = (java.net.PasswordAuthentication) r4
            if (r4 == 0) goto L_0x002c
            java.lang.String r6 = r4.getUserName()
            java.lang.String r3 = new java.lang.String
            char[] r7 = r4.getPassword()
            r3.<init>((char[]) r7)
        L_0x0028:
            if (r6 != 0) goto L_0x003b
            r7 = 0
            return r7
        L_0x002c:
            sun.security.action.GetPropertyAction r7 = new sun.security.action.GetPropertyAction
            java.lang.String r8 = "user.name"
            r7.<init>(r8)
            java.lang.Object r6 = java.security.AccessController.doPrivileged(r7)
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0028
        L_0x003b:
            r7 = 1
            r13.write(r7)
            int r7 = r6.length()
            r13.write(r7)
            java.lang.String r7 = "ISO-8859-1"
            byte[] r7 = r6.getBytes((java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x007d }
            r13.write((byte[]) r7)     // Catch:{ UnsupportedEncodingException -> 0x007d }
        L_0x0050:
            if (r3 == 0) goto L_0x0093
            int r7 = r3.length()
            r13.write(r7)
            java.lang.String r7 = "ISO-8859-1"
            byte[] r7 = r3.getBytes((java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x0088 }
            r13.write((byte[]) r7)     // Catch:{ UnsupportedEncodingException -> 0x0088 }
        L_0x0063:
            r13.flush()
            r7 = 2
            byte[] r1 = new byte[r7]
            int r2 = r10.readSocksReply(r12, r1, r14)
            r7 = 2
            if (r2 != r7) goto L_0x0075
            r7 = 1
            byte r7 = r1[r7]
            if (r7 == 0) goto L_0x0098
        L_0x0075:
            r13.close()
            r12.close()
            r7 = 0
            return r7
        L_0x007d:
            r5 = move-exception
            boolean r7 = f9assertionsDisabled
            if (r7 != 0) goto L_0x0050
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x0088:
            r5 = move-exception
            boolean r7 = f9assertionsDisabled
            if (r7 != 0) goto L_0x0063
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x0093:
            r7 = 0
            r13.write(r7)
            goto L_0x0063
        L_0x0098:
            r7 = 1
            return r7
        L_0x009a:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.SocksSocketImpl.authenticate(byte, java.io.InputStream, java.io.BufferedOutputStream, long):boolean");
    }

    private void connectV4(InputStream in, OutputStream out, InetSocketAddress endpoint, long deadlineMillis) throws IOException {
        if (!(endpoint.getAddress() instanceof Inet4Address)) {
            throw new SocketException("SOCKS V4 requires IPv4 only addresses");
        }
        out.write(4);
        out.write(1);
        out.write((endpoint.getPort() >> 8) & 255);
        out.write((endpoint.getPort() >> 0) & 255);
        out.write(endpoint.getAddress().getAddress());
        try {
            out.write(getUserName().getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            if (!f9assertionsDisabled) {
                throw new AssertionError();
            }
        }
        out.write(0);
        out.flush();
        byte[] data = new byte[8];
        int n = readSocksReply(in, data, deadlineMillis);
        if (n != 8) {
            throw new SocketException("Reply from SOCKS server has bad length: " + n);
        } else if (data[0] == 0 || data[0] == 4) {
            SocketException socketException = null;
            switch (data[1]) {
                case 90:
                    this.external_address = endpoint;
                    break;
                case Types.DATE /*91*/:
                    socketException = new SocketException("SOCKS request rejected");
                    break;
                case Types.TIME /*92*/:
                    socketException = new SocketException("SOCKS server couldn't reach destination");
                    break;
                case Types.TIMESTAMP /*93*/:
                    socketException = new SocketException("SOCKS authentication failed");
                    break;
                default:
                    socketException = new SocketException("Reply from SOCKS server contains bad status");
                    break;
            }
            if (socketException != null) {
                in.close();
                out.close();
                throw socketException;
            }
        } else {
            throw new SocketException("Reply from SOCKS server has bad version");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(java.net.SocketAddress r26, int r27) throws java.io.IOException {
        /*
            r25 = this;
            if (r27 != 0) goto L_0x0039
            r6 = 0
        L_0x0004:
            java.lang.SecurityManager r23 = java.lang.System.getSecurityManager()
            if (r26 == 0) goto L_0x0051
            r0 = r26
            boolean r2 = r0 instanceof java.net.InetSocketAddress
            if (r2 == 0) goto L_0x0051
            r5 = r26
            java.net.InetSocketAddress r5 = (java.net.InetSocketAddress) r5
            if (r23 == 0) goto L_0x0029
            boolean r2 = r5.isUnresolved()
            if (r2 == 0) goto L_0x005a
            java.lang.String r2 = r5.getHostName()
            int r8 = r5.getPort()
            r0 = r23
            r0.checkConnect(r2, r8)
        L_0x0029:
            r0 = r25
            java.lang.String r2 = r0.server
            if (r2 != 0) goto L_0x006c
            int r2 = remainingMillis(r6)
            r0 = r25
            super.connect((java.net.SocketAddress) r5, (int) r2)
            return
        L_0x0039:
            long r8 = java.lang.System.currentTimeMillis()
            r0 = r27
            long r10 = (long) r0
            long r18 = r8 + r10
            r8 = 0
            int r2 = (r18 > r8 ? 1 : (r18 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x004e
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x0004
        L_0x004e:
            r6 = r18
            goto L_0x0004
        L_0x0051:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Unsupported address type"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x005a:
            java.net.InetAddress r2 = r5.getAddress()
            java.lang.String r2 = r2.getHostAddress()
            int r8 = r5.getPort()
            r0 = r23
            r0.checkConnect(r2, r8)
            goto L_0x0029
        L_0x006c:
            r0 = r25
            java.lang.String r2 = r0.server     // Catch:{ IOException -> 0x00a2 }
            r0 = r25
            int r8 = r0.serverPort     // Catch:{ IOException -> 0x00a2 }
            int r9 = remainingMillis(r6)     // Catch:{ IOException -> 0x00a2 }
            r0 = r25
            r0.privilegedConnect(r2, r8, r9)     // Catch:{ IOException -> 0x00a2 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream
            r0 = r25
            java.io.OutputStream r2 = r0.cmdOut
            r8 = 512(0x200, float:7.175E-43)
            r4.<init>(r2, r8)
            r0 = r25
            java.io.InputStream r3 = r0.cmdIn
            r0 = r25
            boolean r2 = r0.useV4
            if (r2 == 0) goto L_0x00b3
            boolean r2 = r5.isUnresolved()
            if (r2 == 0) goto L_0x00ad
            java.net.UnknownHostException r2 = new java.net.UnknownHostException
            java.lang.String r8 = r5.toString()
            r2.<init>(r8)
            throw r2
        L_0x00a2:
            r16 = move-exception
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = r16.getMessage()
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x00ad:
            r2 = r25
            r2.connectV4(r3, r4, r5, r6)
            return
        L_0x00b3:
            r2 = 5
            r4.write(r2)
            r2 = 2
            r4.write(r2)
            r2 = 0
            r4.write(r2)
            r2 = 2
            r4.write(r2)
            r4.flush()
            r2 = 2
            byte[] r15 = new byte[r2]
            r0 = r25
            int r21 = r0.readSocksReply(r3, r15, r6)
            r2 = 2
            r0 = r21
            if (r0 != r2) goto L_0x00da
            r2 = 0
            byte r2 = r15[r2]
            r8 = 5
            if (r2 == r8) goto L_0x00f0
        L_0x00da:
            boolean r2 = r5.isUnresolved()
            if (r2 == 0) goto L_0x00ea
            java.net.UnknownHostException r2 = new java.net.UnknownHostException
            java.lang.String r8 = r5.toString()
            r2.<init>(r8)
            throw r2
        L_0x00ea:
            r2 = r25
            r2.connectV4(r3, r4, r5, r6)
            return
        L_0x00f0:
            r2 = 1
            byte r2 = r15[r2]
            r8 = -1
            if (r2 != r8) goto L_0x00ff
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "SOCKS : No acceptable methods"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x00ff:
            r2 = 1
            byte r9 = r15[r2]
            r8 = r25
            r10 = r3
            r11 = r4
            r12 = r6
            boolean r2 = r8.authenticate(r9, r10, r11, r12)
            if (r2 != 0) goto L_0x0116
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "SOCKS : authentication failed"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x0116:
            r2 = 5
            r4.write(r2)
            r2 = 1
            r4.write(r2)
            r2 = 0
            r4.write(r2)
            boolean r2 = r5.isUnresolved()
            if (r2 == 0) goto L_0x0180
            r2 = 3
            r4.write(r2)
            java.lang.String r2 = r5.getHostName()
            int r2 = r2.length()
            r4.write(r2)
            java.lang.String r2 = r5.getHostName()     // Catch:{ UnsupportedEncodingException -> 0x0175 }
            java.lang.String r8 = "ISO-8859-1"
            byte[] r2 = r2.getBytes((java.lang.String) r8)     // Catch:{ UnsupportedEncodingException -> 0x0175 }
            r4.write((byte[]) r2)     // Catch:{ UnsupportedEncodingException -> 0x0175 }
        L_0x0145:
            int r2 = r5.getPort()
            int r2 = r2 >> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4.write(r2)
            int r2 = r5.getPort()
            int r2 = r2 >> 0
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4.write(r2)
        L_0x015b:
            r4.flush()
            r2 = 4
            byte[] r15 = new byte[r2]
            r0 = r25
            int r21 = r0.readSocksReply(r3, r15, r6)
            r2 = 4
            r0 = r21
            if (r0 == r2) goto L_0x01d4
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "Reply from SOCKS server has bad length"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x0175:
            r24 = move-exception
            boolean r2 = f9assertionsDisabled
            if (r2 != 0) goto L_0x0145
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0180:
            java.net.InetAddress r2 = r5.getAddress()
            boolean r2 = r2 instanceof java.net.Inet6Address
            if (r2 == 0) goto L_0x01ae
            r2 = 4
            r4.write(r2)
            java.net.InetAddress r2 = r5.getAddress()
            byte[] r2 = r2.getAddress()
            r4.write((byte[]) r2)
            int r2 = r5.getPort()
            int r2 = r2 >> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4.write(r2)
            int r2 = r5.getPort()
            int r2 = r2 >> 0
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4.write(r2)
            goto L_0x015b
        L_0x01ae:
            r2 = 1
            r4.write(r2)
            java.net.InetAddress r2 = r5.getAddress()
            byte[] r2 = r2.getAddress()
            r4.write((byte[]) r2)
            int r2 = r5.getPort()
            int r2 = r2 >> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4.write(r2)
            int r2 = r5.getPort()
            int r2 = r2 >> 0
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4.write(r2)
            goto L_0x015b
        L_0x01d4:
            r17 = 0
            r2 = 1
            byte r2 = r15[r2]
            switch(r2) {
                case 0: goto L_0x01e5;
                case 1: goto L_0x028e;
                case 2: goto L_0x029a;
                case 3: goto L_0x02a6;
                case 4: goto L_0x02b2;
                case 5: goto L_0x02be;
                case 6: goto L_0x02ca;
                case 7: goto L_0x02d6;
                case 8: goto L_0x02e2;
                default: goto L_0x01dc;
            }
        L_0x01dc:
            if (r17 == 0) goto L_0x02ee
            r3.close()
            r4.close()
            throw r17
        L_0x01e5:
            r2 = 3
            byte r2 = r15[r2]
            switch(r2) {
                case 1: goto L_0x01f6;
                case 2: goto L_0x01eb;
                case 3: goto L_0x0224;
                case 4: goto L_0x025b;
                default: goto L_0x01eb;
            }
        L_0x01eb:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "Reply from SOCKS server contains wrong code"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x01f6:
            r2 = 4
            byte[] r14 = new byte[r2]
            r0 = r25
            int r21 = r0.readSocksReply(r3, r14, r6)
            r2 = 4
            r0 = r21
            if (r0 == r2) goto L_0x020d
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "Reply from SOCKS server badly formatted"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x020d:
            r2 = 2
            byte[] r15 = new byte[r2]
            r0 = r25
            int r21 = r0.readSocksReply(r3, r15, r6)
            r2 = 2
            r0 = r21
            if (r0 == r2) goto L_0x01dc
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "Reply from SOCKS server badly formatted"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x0224:
            r2 = 1
            byte r22 = r15[r2]
            r0 = r22
            byte[] r0 = new byte[r0]
            r20 = r0
            r0 = r25
            r1 = r20
            int r21 = r0.readSocksReply(r3, r1, r6)
            r0 = r21
            r1 = r22
            if (r0 == r1) goto L_0x0244
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "Reply from SOCKS server badly formatted"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x0244:
            r2 = 2
            byte[] r15 = new byte[r2]
            r0 = r25
            int r21 = r0.readSocksReply(r3, r15, r6)
            r2 = 2
            r0 = r21
            if (r0 == r2) goto L_0x01dc
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "Reply from SOCKS server badly formatted"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x025b:
            r2 = 1
            byte r22 = r15[r2]
            r0 = r22
            byte[] r14 = new byte[r0]
            r0 = r25
            int r21 = r0.readSocksReply(r3, r14, r6)
            r0 = r21
            r1 = r22
            if (r0 == r1) goto L_0x0277
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "Reply from SOCKS server badly formatted"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x0277:
            r2 = 2
            byte[] r15 = new byte[r2]
            r0 = r25
            int r21 = r0.readSocksReply(r3, r15, r6)
            r2 = 2
            r0 = r21
            if (r0 == r2) goto L_0x01dc
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.String r8 = "Reply from SOCKS server badly formatted"
            r2.<init>((java.lang.String) r8)
            throw r2
        L_0x028e:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS server general failure"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x029a:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS: Connection not allowed by ruleset"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x02a6:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS: Network unreachable"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x02b2:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS: Host unreachable"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x02be:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS: Connection refused"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x02ca:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS: TTL expired"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x02d6:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS: Command not supported"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x02e2:
            java.net.SocketException r17 = new java.net.SocketException
            java.lang.String r2 = "SOCKS: address type not supported"
            r0 = r17
            r0.<init>((java.lang.String) r2)
            goto L_0x01dc
        L_0x02ee:
            r0 = r25
            r0.external_address = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.SocksSocketImpl.connect(java.net.SocketAddress, int):void");
    }

    private void bindV4(InputStream in, OutputStream out, InetAddress baddr, int lport) throws IOException {
        if (!(baddr instanceof Inet4Address)) {
            throw new SocketException("SOCKS V4 requires IPv4 only addresses");
        }
        super.bind(baddr, lport);
        byte[] addr1 = baddr.getAddress();
        InetAddress inetAddress = baddr;
        if (baddr.isAnyLocalAddress()) {
            addr1 = ((InetAddress) AccessController.doPrivileged(new PrivilegedAction<InetAddress>(this) {
                final /* synthetic */ SocksSocketImpl this$0;

                {
                    this.this$0 = this$0;
                }

                public /* bridge */ /* synthetic */ Object run() {
                    return run();
                }

                public InetAddress run() {
                    return this.this$0.cmdsock.getLocalAddress();
                }
            })).getAddress();
        }
        out.write(4);
        out.write(2);
        out.write((super.getLocalPort() >> 8) & 255);
        out.write((super.getLocalPort() >> 0) & 255);
        out.write(addr1);
        try {
            out.write(getUserName().getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            if (!f9assertionsDisabled) {
                throw new AssertionError();
            }
        }
        out.write(0);
        out.flush();
        byte[] data = new byte[8];
        int n = readSocksReply(in, data);
        if (n != 8) {
            throw new SocketException("Reply from SOCKS server has bad length: " + n);
        } else if (data[0] == 0 || data[0] == 4) {
            SocketException socketException = null;
            switch (data[1]) {
                case 90:
                    this.external_address = new InetSocketAddress(baddr, lport);
                    break;
                case Types.DATE /*91*/:
                    socketException = new SocketException("SOCKS request rejected");
                    break;
                case Types.TIME /*92*/:
                    socketException = new SocketException("SOCKS server couldn't reach destination");
                    break;
                case Types.TIMESTAMP /*93*/:
                    socketException = new SocketException("SOCKS authentication failed");
                    break;
                default:
                    socketException = new SocketException("Reply from SOCKS server contains bad status");
                    break;
            }
            if (socketException != null) {
                in.close();
                out.close();
                throw socketException;
            }
        } else {
            throw new SocketException("Reply from SOCKS server has bad version");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dc, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void socksBind(java.net.InetSocketAddress r28) throws java.io.IOException {
        /*
            r27 = this;
            monitor-enter(r27)
            r0 = r27
            java.net.Socket r0 = r0.socket     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 == 0) goto L_0x000b
            monitor-exit(r27)
            return
        L_0x000b:
            r0 = r27
            java.lang.String r0 = r0.server     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 != 0) goto L_0x01e4
            java.net.SocksSocketImpl$4 r24 = new java.net.SocksSocketImpl$4     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r27
            r0.<init>(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.Object r21 = java.security.AccessController.doPrivileged(r24)     // Catch:{ all -> 0x00d5 }
            java.net.ProxySelector r21 = (java.net.ProxySelector) r21     // Catch:{ all -> 0x00d5 }
            if (r21 != 0) goto L_0x0026
            monitor-exit(r27)
            return
        L_0x0026:
            java.lang.String r10 = r28.getHostString()     // Catch:{ all -> 0x00d5 }
            java.net.InetAddress r24 = r28.getAddress()     // Catch:{ all -> 0x00d5 }
            r0 = r24
            boolean r0 = r0 instanceof java.net.Inet6Address     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 == 0) goto L_0x0041
            java.lang.String r24 = "["
            r0 = r24
            boolean r24 = r10.startsWith(r0)     // Catch:{ all -> 0x00d5 }
            if (r24 == 0) goto L_0x009e
        L_0x0041:
            java.net.URI r23 = new java.net.URI     // Catch:{ URISyntaxException -> 0x00c8 }
            java.lang.StringBuilder r24 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00c8 }
            r24.<init>()     // Catch:{ URISyntaxException -> 0x00c8 }
            java.lang.String r25 = "serversocket://"
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ URISyntaxException -> 0x00c8 }
            java.lang.String r25 = sun.net.www.ParseUtil.encodePath(r10)     // Catch:{ URISyntaxException -> 0x00c8 }
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ URISyntaxException -> 0x00c8 }
            java.lang.String r25 = ":"
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ URISyntaxException -> 0x00c8 }
            int r25 = r28.getPort()     // Catch:{ URISyntaxException -> 0x00c8 }
            java.lang.StringBuilder r24 = r24.append((int) r25)     // Catch:{ URISyntaxException -> 0x00c8 }
            java.lang.String r24 = r24.toString()     // Catch:{ URISyntaxException -> 0x00c8 }
            r23.<init>(r24)     // Catch:{ URISyntaxException -> 0x00c8 }
        L_0x006d:
            r19 = 0
            r20 = 0
            r13 = 0
            r0 = r21
            r1 = r23
            java.util.List r24 = r0.select(r1)     // Catch:{ all -> 0x00d5 }
            java.util.Iterator r13 = r24.iterator()     // Catch:{ all -> 0x00d5 }
            if (r13 == 0) goto L_0x00db
            boolean r24 = r13.hasNext()     // Catch:{ all -> 0x00d5 }
            if (r24 == 0) goto L_0x00db
        L_0x0086:
            boolean r24 = r13.hasNext()     // Catch:{ all -> 0x00d5 }
            if (r24 == 0) goto L_0x01b6
            java.lang.Object r19 = r13.next()     // Catch:{ all -> 0x00d5 }
            java.net.Proxy r19 = (java.net.Proxy) r19     // Catch:{ all -> 0x00d5 }
            if (r19 == 0) goto L_0x009c
            java.net.Proxy r24 = java.net.Proxy.NO_PROXY     // Catch:{ all -> 0x00d5 }
            r0 = r19
            r1 = r24
            if (r0 != r1) goto L_0x00dd
        L_0x009c:
            monitor-exit(r27)
            return
        L_0x009e:
            java.lang.String r24 = ":"
            r0 = r24
            int r24 = r10.indexOf((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            if (r24 < 0) goto L_0x0041
            java.lang.StringBuilder r24 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r24.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "["
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            r0 = r24
            java.lang.StringBuilder r24 = r0.append((java.lang.String) r10)     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "]"
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            java.lang.String r10 = r24.toString()     // Catch:{ all -> 0x00d5 }
            goto L_0x0041
        L_0x00c8:
            r8 = move-exception
            boolean r24 = f9assertionsDisabled     // Catch:{ all -> 0x00d5 }
            if (r24 != 0) goto L_0x00d8
            java.lang.AssertionError r24 = new java.lang.AssertionError     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r0.<init>((java.lang.Object) r8)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r24 = move-exception
            monitor-exit(r27)
            throw r24
        L_0x00d8:
            r23 = 0
            goto L_0x006d
        L_0x00db:
            monitor-exit(r27)
            return
        L_0x00dd:
            java.net.Proxy$Type r24 = r19.type()     // Catch:{ all -> 0x00d5 }
            java.net.Proxy$Type r25 = java.net.Proxy.Type.SOCKS     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x0107
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r25 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r25.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = "Unknown proxy type : "
            java.lang.StringBuilder r25 = r25.append((java.lang.String) r26)     // Catch:{ all -> 0x00d5 }
            java.net.Proxy$Type r26 = r19.type()     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r25 = r25.append((java.lang.Object) r26)     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = r25.toString()     // Catch:{ all -> 0x00d5 }
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x0107:
            java.net.SocketAddress r24 = r19.address()     // Catch:{ all -> 0x00d5 }
            r0 = r24
            boolean r0 = r0 instanceof java.net.InetSocketAddress     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 != 0) goto L_0x0131
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r25 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r25.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = "Unknow address type for proxy: "
            java.lang.StringBuilder r25 = r25.append((java.lang.String) r26)     // Catch:{ all -> 0x00d5 }
            r0 = r25
            r1 = r19
            java.lang.StringBuilder r25 = r0.append((java.lang.Object) r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = r25.toString()     // Catch:{ all -> 0x00d5 }
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x0131:
            java.net.SocketAddress r24 = r19.address()     // Catch:{ all -> 0x00d5 }
            java.net.InetSocketAddress r24 = (java.net.InetSocketAddress) r24     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = r24.getHostString()     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r27
            r1.server = r0     // Catch:{ all -> 0x00d5 }
            java.net.SocketAddress r24 = r19.address()     // Catch:{ all -> 0x00d5 }
            java.net.InetSocketAddress r24 = (java.net.InetSocketAddress) r24     // Catch:{ all -> 0x00d5 }
            int r24 = r24.getPort()     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r27
            r1.serverPort = r0     // Catch:{ all -> 0x00d5 }
            r0 = r19
            boolean r0 = r0 instanceof sun.net.SocksProxy     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 == 0) goto L_0x0173
            r0 = r19
            sun.net.SocksProxy r0 = (sun.net.SocksProxy) r0     // Catch:{ all -> 0x00d5 }
            r24 = r0
            int r24 = r24.protocolVersion()     // Catch:{ all -> 0x00d5 }
            r25 = 4
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x0173
            r24 = 1
            r0 = r24
            r1 = r27
            r1.useV4 = r0     // Catch:{ all -> 0x00d5 }
        L_0x0173:
            java.net.SocksSocketImpl$5 r24 = new java.net.SocksSocketImpl$5     // Catch:{ Exception -> 0x0181 }
            r0 = r24
            r1 = r27
            r0.<init>(r1)     // Catch:{ Exception -> 0x0181 }
            java.security.AccessController.doPrivileged(r24)     // Catch:{ Exception -> 0x0181 }
            goto L_0x0086
        L_0x0181:
            r7 = move-exception
            java.net.SocketAddress r24 = r19.address()     // Catch:{ all -> 0x00d5 }
            java.net.SocketException r25 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = r7.getMessage()     // Catch:{ all -> 0x00d5 }
            r25.<init>((java.lang.String) r26)     // Catch:{ all -> 0x00d5 }
            r0 = r21
            r1 = r23
            r2 = r24
            r3 = r25
            r0.connectFailed(r1, r2, r3)     // Catch:{ all -> 0x00d5 }
            r24 = 0
            r0 = r24
            r1 = r27
            r1.server = r0     // Catch:{ all -> 0x00d5 }
            r24 = -1
            r0 = r24
            r1 = r27
            r1.serverPort = r0     // Catch:{ all -> 0x00d5 }
            r24 = 0
            r0 = r24
            r1 = r27
            r1.cmdsock = r0     // Catch:{ all -> 0x00d5 }
            r20 = r7
            goto L_0x0086
        L_0x01b6:
            r0 = r27
            java.lang.String r0 = r0.server     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 == 0) goto L_0x01c6
            r0 = r27
            java.net.Socket r0 = r0.cmdsock     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 != 0) goto L_0x01f0
        L_0x01c6:
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r25 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r25.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = "Can't connect to SOCKS proxy:"
            java.lang.StringBuilder r25 = r25.append((java.lang.String) r26)     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = r20.getMessage()     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r25 = r25.append((java.lang.String) r26)     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = r25.toString()     // Catch:{ all -> 0x00d5 }
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x01e4:
            java.net.SocksSocketImpl$6 r24 = new java.net.SocksSocketImpl$6     // Catch:{ Exception -> 0x0224 }
            r0 = r24
            r1 = r27
            r0.<init>(r1)     // Catch:{ Exception -> 0x0224 }
            java.security.AccessController.doPrivileged(r24)     // Catch:{ Exception -> 0x0224 }
        L_0x01f0:
            java.io.BufferedOutputStream r18 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00d5 }
            r0 = r27
            java.io.OutputStream r0 = r0.cmdOut     // Catch:{ all -> 0x00d5 }
            r24 = r0
            r25 = 512(0x200, float:7.175E-43)
            r0 = r18
            r1 = r24
            r2 = r25
            r0.<init>(r1, r2)     // Catch:{ all -> 0x00d5 }
            r0 = r27
            java.io.InputStream r14 = r0.cmdIn     // Catch:{ all -> 0x00d5 }
            r0 = r27
            boolean r0 = r0.useV4     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 == 0) goto L_0x022f
            java.net.InetAddress r24 = r28.getAddress()     // Catch:{ all -> 0x00d5 }
            int r25 = r28.getPort()     // Catch:{ all -> 0x00d5 }
            r0 = r27
            r1 = r18
            r2 = r24
            r3 = r25
            r0.bindV4(r14, r1, r2, r3)     // Catch:{ all -> 0x00d5 }
            monitor-exit(r27)
            return
        L_0x0224:
            r7 = move-exception
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = r7.getMessage()     // Catch:{ all -> 0x00d5 }
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x022f:
            r24 = 5
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r24 = 0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r18.flush()     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r24
            byte[] r6 = new byte[r0]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r6)     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r24
            if (r12 != r0) goto L_0x0274
            r24 = 0
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r25 = 5
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x0289
        L_0x0274:
            java.net.InetAddress r24 = r28.getAddress()     // Catch:{ all -> 0x00d5 }
            int r25 = r28.getPort()     // Catch:{ all -> 0x00d5 }
            r0 = r27
            r1 = r18
            r2 = r24
            r3 = r25
            r0.bindV4(r14, r1, r2, r3)     // Catch:{ all -> 0x00d5 }
            monitor-exit(r27)
            return
        L_0x0289:
            r24 = 1
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r25 = -1
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x029e
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "SOCKS : No acceptable methods"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x029e:
            r24 = 1
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            r1 = r24
            r2 = r18
            boolean r24 = r0.authenticate(r1, r14, r2)     // Catch:{ all -> 0x00d5 }
            if (r24 != 0) goto L_0x02b7
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "SOCKS : authentication failed"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x02b7:
            r24 = 5
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r24 = 0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            int r16 = r28.getPort()     // Catch:{ all -> 0x00d5 }
            boolean r24 = r28.isUnresolved()     // Catch:{ all -> 0x00d5 }
            if (r24 == 0) goto L_0x035d
            r24 = 3
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = r28.getHostName()     // Catch:{ all -> 0x00d5 }
            int r24 = r24.length()     // Catch:{ all -> 0x00d5 }
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = r28.getHostName()     // Catch:{ UnsupportedEncodingException -> 0x0352 }
            java.lang.String r25 = "ISO-8859-1"
            byte[] r24 = r24.getBytes((java.lang.String) r25)     // Catch:{ UnsupportedEncodingException -> 0x0352 }
            r0 = r18
            r1 = r24
            r0.write((byte[]) r1)     // Catch:{ UnsupportedEncodingException -> 0x0352 }
        L_0x0306:
            int r24 = r16 >> 8
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            int r24 = r16 >> 0
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
        L_0x0324:
            r24 = 4
            r0 = r24
            byte[] r6 = new byte[r0]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r6)     // Catch:{ all -> 0x00d5 }
            r9 = 0
            r24 = 1
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            switch(r24) {
                case 0: goto L_0x040d;
                case 1: goto L_0x0550;
                case 2: goto L_0x055c;
                case 3: goto L_0x0568;
                case 4: goto L_0x0574;
                case 5: goto L_0x0580;
                case 6: goto L_0x058c;
                case 7: goto L_0x0598;
                case 8: goto L_0x05a4;
                default: goto L_0x0338;
            }     // Catch:{ all -> 0x00d5 }
        L_0x0338:
            if (r9 == 0) goto L_0x05b0
            r14.close()     // Catch:{ all -> 0x00d5 }
            r18.close()     // Catch:{ all -> 0x00d5 }
            r0 = r27
            java.net.Socket r0 = r0.cmdsock     // Catch:{ all -> 0x00d5 }
            r24 = r0
            r24.close()     // Catch:{ all -> 0x00d5 }
            r24 = 0
            r0 = r24
            r1 = r27
            r1.cmdsock = r0     // Catch:{ all -> 0x00d5 }
            throw r9     // Catch:{ all -> 0x00d5 }
        L_0x0352:
            r22 = move-exception
            boolean r24 = f9assertionsDisabled     // Catch:{ all -> 0x00d5 }
            if (r24 != 0) goto L_0x0306
            java.lang.AssertionError r24 = new java.lang.AssertionError     // Catch:{ all -> 0x00d5 }
            r24.<init>()     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x035d:
            java.net.InetAddress r24 = r28.getAddress()     // Catch:{ all -> 0x00d5 }
            r0 = r24
            boolean r0 = r0 instanceof java.net.Inet4Address     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 == 0) goto L_0x03a1
            java.net.InetAddress r24 = r28.getAddress()     // Catch:{ all -> 0x00d5 }
            byte[] r5 = r24.getAddress()     // Catch:{ all -> 0x00d5 }
            r24 = 1
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r0 = r18
            r0.write((byte[]) r5)     // Catch:{ all -> 0x00d5 }
            int r24 = r16 >> 8
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            int r24 = r16 >> 0
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r18.flush()     // Catch:{ all -> 0x00d5 }
            goto L_0x0324
        L_0x03a1:
            java.net.InetAddress r24 = r28.getAddress()     // Catch:{ all -> 0x00d5 }
            r0 = r24
            boolean r0 = r0 instanceof java.net.Inet6Address     // Catch:{ all -> 0x00d5 }
            r24 = r0
            if (r24 == 0) goto L_0x03e6
            java.net.InetAddress r24 = r28.getAddress()     // Catch:{ all -> 0x00d5 }
            byte[] r5 = r24.getAddress()     // Catch:{ all -> 0x00d5 }
            r24 = 4
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r0 = r18
            r0.write((byte[]) r5)     // Catch:{ all -> 0x00d5 }
            int r24 = r16 >> 8
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            int r24 = r16 >> 0
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            r0 = r18
            r1 = r24
            r0.write(r1)     // Catch:{ all -> 0x00d5 }
            r18.flush()     // Catch:{ all -> 0x00d5 }
            goto L_0x0324
        L_0x03e6:
            r0 = r27
            java.net.Socket r0 = r0.cmdsock     // Catch:{ all -> 0x00d5 }
            r24 = r0
            r24.close()     // Catch:{ all -> 0x00d5 }
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r25 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            r25.<init>()     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = "unsupported address type : "
            java.lang.StringBuilder r25 = r25.append((java.lang.String) r26)     // Catch:{ all -> 0x00d5 }
            r0 = r25
            r1 = r28
            java.lang.StringBuilder r25 = r0.append((java.lang.Object) r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = r25.toString()     // Catch:{ all -> 0x00d5 }
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x040d:
            r24 = 3
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            switch(r24) {
                case 1: goto L_0x0416;
                case 2: goto L_0x0414;
                case 3: goto L_0x0483;
                case 4: goto L_0x04e7;
                default: goto L_0x0414;
            }     // Catch:{ all -> 0x00d5 }
        L_0x0414:
            goto L_0x0338
        L_0x0416:
            r24 = 4
            r0 = r24
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r4)     // Catch:{ all -> 0x00d5 }
            r24 = 4
            r0 = r24
            if (r12 == r0) goto L_0x0431
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "Reply from SOCKS server badly formatted"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x0431:
            r24 = 2
            r0 = r24
            byte[] r6 = new byte[r0]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r6)     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r24
            if (r12 == r0) goto L_0x044c
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "Reply from SOCKS server badly formatted"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x044c:
            r24 = 0
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            int r17 = r24 << 8
            r24 = 1
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            int r17 = r17 + r24
            java.net.InetSocketAddress r24 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00d5 }
            java.net.Inet4Address r25 = new java.net.Inet4Address     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = ""
            r0 = r25
            r1 = r26
            r0.<init>((java.lang.String) r1, (byte[]) r4)     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r25
            r2 = r17
            r0.<init>((java.net.InetAddress) r1, (int) r2)     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r27
            r1.external_address = r0     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x0483:
            r24 = 1
            byte r15 = r6[r24]     // Catch:{ all -> 0x00d5 }
            byte[] r11 = new byte[r15]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r11)     // Catch:{ all -> 0x00d5 }
            if (r12 == r15) goto L_0x049a
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "Reply from SOCKS server badly formatted"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x049a:
            r24 = 2
            r0 = r24
            byte[] r6 = new byte[r0]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r6)     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r24
            if (r12 == r0) goto L_0x04b5
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "Reply from SOCKS server badly formatted"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x04b5:
            r24 = 0
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            int r17 = r24 << 8
            r24 = 1
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            int r17 = r17 + r24
            java.net.InetSocketAddress r24 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = new java.lang.String     // Catch:{ all -> 0x00d5 }
            r0 = r25
            r0.<init>((byte[]) r11)     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r25
            r2 = r17
            r0.<init>((java.lang.String) r1, (int) r2)     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r27
            r1.external_address = r0     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x04e7:
            r24 = 1
            byte r15 = r6[r24]     // Catch:{ all -> 0x00d5 }
            byte[] r4 = new byte[r15]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r4)     // Catch:{ all -> 0x00d5 }
            if (r12 == r15) goto L_0x04fe
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "Reply from SOCKS server badly formatted"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x04fe:
            r24 = 2
            r0 = r24
            byte[] r6 = new byte[r0]     // Catch:{ all -> 0x00d5 }
            r0 = r27
            int r12 = r0.readSocksReply(r14, r6)     // Catch:{ all -> 0x00d5 }
            r24 = 2
            r0 = r24
            if (r12 == r0) goto L_0x0519
            java.net.SocketException r24 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r25 = "Reply from SOCKS server badly formatted"
            r24.<init>((java.lang.String) r25)     // Catch:{ all -> 0x00d5 }
            throw r24     // Catch:{ all -> 0x00d5 }
        L_0x0519:
            r24 = 0
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            int r17 = r24 << 8
            r24 = 1
            byte r24 = r6[r24]     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r24 = r0
            int r17 = r17 + r24
            java.net.InetSocketAddress r24 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00d5 }
            java.net.Inet6Address r25 = new java.net.Inet6Address     // Catch:{ all -> 0x00d5 }
            java.lang.String r26 = ""
            r0 = r25
            r1 = r26
            r0.<init>(r1, r4)     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r25
            r2 = r17
            r0.<init>((java.net.InetAddress) r1, (int) r2)     // Catch:{ all -> 0x00d5 }
            r0 = r24
            r1 = r27
            r1.external_address = r0     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x0550:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS server general failure"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x055c:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS: Bind not allowed by ruleset"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x0568:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS: Network unreachable"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x0574:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS: Host unreachable"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x0580:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS: Connection refused"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x058c:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS: TTL expired"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x0598:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS: Command not supported"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x05a4:
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x00d5 }
            java.lang.String r24 = "SOCKS: address type not supported"
            r0 = r24
            r9.<init>((java.lang.String) r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x0338
        L_0x05b0:
            r0 = r27
            r0.cmdIn = r14     // Catch:{ all -> 0x00d5 }
            r0 = r18
            r1 = r27
            r1.cmdOut = r0     // Catch:{ all -> 0x00d5 }
            monitor-exit(r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.SocksSocketImpl.socksBind(java.net.InetSocketAddress):void");
    }

    /* access modifiers changed from: protected */
    public InetAddress getInetAddress() {
        if (this.external_address != null) {
            return this.external_address.getAddress();
        }
        return super.getInetAddress();
    }

    /* access modifiers changed from: protected */
    public int getPort() {
        if (this.external_address != null) {
            return this.external_address.getPort();
        }
        return super.getPort();
    }

    /* access modifiers changed from: protected */
    public int getLocalPort() {
        if (this.socket != null) {
            return super.getLocalPort();
        }
        if (this.external_address != null) {
            return this.external_address.getPort();
        }
        return super.getLocalPort();
    }

    /* access modifiers changed from: protected */
    public void close() throws IOException {
        if (this.cmdsock != null) {
            this.cmdsock.close();
        }
        this.cmdsock = null;
        super.close();
    }

    private String getUserName() {
        if (!this.applicationSetProxy) {
            return (String) AccessController.doPrivileged(new GetPropertyAction("user.name"));
        }
        try {
            return System.getProperty("user.name");
        } catch (SecurityException e) {
            return "";
        }
    }
}
