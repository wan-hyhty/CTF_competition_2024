package java.net;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import libcore.io.Libcore;

public class DatagramSocket implements Closeable {
    static final int ST_CONNECTED = 1;
    static final int ST_CONNECTED_NO_IMPL = 2;
    static final int ST_NOT_CONNECTED = 0;
    static DatagramSocketImplFactory factory;
    static Class implClass;
    private boolean bound;
    private Object closeLock;
    private boolean closed;
    int connectState;
    InetAddress connectedAddress;
    int connectedPort;
    private boolean created;
    DatagramSocketImpl impl;
    boolean oldImpl;
    private SocketException pendingConnectException;

    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0073=Splitter:B:35:0x0073, B:4:0x0008=Splitter:B:4:0x0008} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void connectInternal(java.net.InetAddress r6, int r7) throws java.net.SocketException {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r7 < 0) goto L_0x0008
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r7 <= r2) goto L_0x0025
        L_0x0008:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r3.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r4 = "connect: "
            java.lang.StringBuilder r3 = r3.append((java.lang.String) r4)     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r3 = r3.append((int) r7)     // Catch:{ all -> 0x0022 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0022 }
            r2.<init>((java.lang.String) r3)     // Catch:{ all -> 0x0022 }
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r2 = move-exception
            monitor-exit(r5)
            throw r2
        L_0x0025:
            if (r6 != 0) goto L_0x0030
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0022 }
            java.lang.String r3 = "connect: null address"
            r2.<init>((java.lang.String) r3)     // Catch:{ all -> 0x0022 }
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0030:
            java.lang.String r2 = "connect"
            r5.checkAddress(r6, r2)     // Catch:{ all -> 0x0022 }
            boolean r2 = r5.isClosed()     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x003e
            monitor-exit(r5)
            return
        L_0x003e:
            java.lang.SecurityManager r1 = java.lang.System.getSecurityManager()     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x004d
            boolean r2 = r6.isMulticastAddress()     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x0079
            r1.checkMulticast(r6)     // Catch:{ all -> 0x0022 }
        L_0x004d:
            boolean r2 = r5.isBound()     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x005c
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch:{ all -> 0x0022 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ all -> 0x0022 }
            r5.bind(r2)     // Catch:{ all -> 0x0022 }
        L_0x005c:
            boolean r2 = r5.oldImpl     // Catch:{ all -> 0x0098 }
            if (r2 != 0) goto L_0x0070
            java.net.DatagramSocketImpl r2 = r5.impl     // Catch:{ all -> 0x0098 }
            boolean r2 = r2 instanceof java.net.AbstractPlainDatagramSocketImpl     // Catch:{ all -> 0x0098 }
            if (r2 == 0) goto L_0x0088
            java.net.DatagramSocketImpl r2 = r5.impl     // Catch:{ all -> 0x0098 }
            java.net.AbstractPlainDatagramSocketImpl r2 = (java.net.AbstractPlainDatagramSocketImpl) r2     // Catch:{ all -> 0x0098 }
            boolean r2 = r2.nativeConnectDisabled()     // Catch:{ all -> 0x0098 }
            if (r2 == 0) goto L_0x0088
        L_0x0070:
            r2 = 2
            r5.connectState = r2     // Catch:{ all -> 0x0098 }
        L_0x0073:
            r5.connectedAddress = r6     // Catch:{ all -> 0x0022 }
            r5.connectedPort = r7     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return
        L_0x0079:
            java.lang.String r2 = r6.getHostAddress()     // Catch:{ all -> 0x0022 }
            r1.checkConnect(r2, r7)     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = r6.getHostAddress()     // Catch:{ all -> 0x0022 }
            r1.checkAccept(r2, r7)     // Catch:{ all -> 0x0022 }
            goto L_0x004d
        L_0x0088:
            java.net.DatagramSocketImpl r2 = r5.getImpl()     // Catch:{ SocketException -> 0x0093 }
            r2.connect(r6, r7)     // Catch:{ SocketException -> 0x0093 }
            r2 = 1
            r5.connectState = r2     // Catch:{ SocketException -> 0x0093 }
            goto L_0x0073
        L_0x0093:
            r0 = move-exception
            r2 = 2
            r5.connectState = r2     // Catch:{ all -> 0x0098 }
            throw r0     // Catch:{ all -> 0x0098 }
        L_0x0098:
            r2 = move-exception
            r5.connectedAddress = r6     // Catch:{ all -> 0x0022 }
            r5.connectedPort = r7     // Catch:{ all -> 0x0022 }
            throw r2     // Catch:{ all -> 0x0022 }
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.DatagramSocket.connectInternal(java.net.InetAddress, int):void");
    }

    public DatagramSocket() throws SocketException {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        this.connectState = 0;
        this.connectedAddress = null;
        this.connectedPort = -1;
        createImpl();
        bind(new InetSocketAddress(0));
    }

    protected DatagramSocket(DatagramSocketImpl impl2) {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        this.connectState = 0;
        this.connectedAddress = null;
        this.connectedPort = -1;
        if (impl2 == null) {
            throw new NullPointerException();
        }
        this.impl = impl2;
        checkOldImpl();
    }

    public DatagramSocket(SocketAddress bindaddr) throws SocketException {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        this.connectState = 0;
        this.connectedAddress = null;
        this.connectedPort = -1;
        createImpl();
        if (bindaddr != null) {
            bind(bindaddr);
        }
    }

    public DatagramSocket(int port) throws SocketException {
        this(port, (InetAddress) null);
    }

    public DatagramSocket(int port, InetAddress laddr) throws SocketException {
        this((SocketAddress) new InetSocketAddress(laddr, port));
    }

    private void checkOldImpl() {
        if (this.impl != null) {
            try {
                AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                    public Void run() throws NoSuchMethodException {
                        DatagramSocket.this.impl.getClass().getDeclaredMethod("peekData", DatagramPacket.class);
                        return null;
                    }
                });
            } catch (PrivilegedActionException e) {
                this.oldImpl = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void createImpl() throws SocketException {
        if (this.impl == null) {
            if (factory != null) {
                this.impl = factory.createDatagramSocketImpl();
                checkOldImpl();
            } else {
                this.impl = DefaultDatagramSocketImplFactory.createDatagramSocketImpl(this instanceof MulticastSocket);
                checkOldImpl();
            }
        }
        this.impl.create();
        this.created = true;
    }

    /* access modifiers changed from: package-private */
    public DatagramSocketImpl getImpl() throws SocketException {
        if (!this.created) {
            createImpl();
        }
        return this.impl;
    }

    public synchronized void bind(SocketAddress addr) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (isBound()) {
            throw new SocketException("already bound");
        } else {
            if (addr == null) {
                addr = new InetSocketAddress(0);
            }
            if (!(addr instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Unsupported address type!");
            }
            InetSocketAddress epoint = (InetSocketAddress) addr;
            if (epoint.isUnresolved()) {
                throw new SocketException("Unresolved address");
            }
            InetAddress iaddr = epoint.getAddress();
            int port = epoint.getPort();
            checkAddress(iaddr, "bind");
            SecurityManager sec = System.getSecurityManager();
            if (sec != null) {
                sec.checkListen(port);
            }
            try {
                getImpl().bind(port, iaddr);
                this.bound = true;
            } catch (SocketException e) {
                getImpl().close();
                throw e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkAddress(InetAddress addr, String op) {
        if (addr != null) {
            if (!(!(addr instanceof Inet4Address) ? addr instanceof Inet6Address : true)) {
                throw new IllegalArgumentException(op + ": invalid address type");
            }
        }
    }

    public void connect(InetAddress address, int port) {
        try {
            connectInternal(address, port);
        } catch (SocketException se) {
            this.pendingConnectException = se;
        }
    }

    public void connect(SocketAddress addr) throws SocketException {
        if (addr == null) {
            throw new IllegalArgumentException("Address can't be null");
        } else if (!(addr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        } else {
            InetSocketAddress epoint = (InetSocketAddress) addr;
            if (epoint.isUnresolved()) {
                throw new SocketException("Unresolved address");
            }
            connectInternal(epoint.getAddress(), epoint.getPort());
        }
    }

    public void disconnect() {
        synchronized (this) {
            if (!isClosed()) {
                if (this.connectState == 1) {
                    this.impl.disconnect();
                }
                this.connectedAddress = null;
                this.connectedPort = -1;
                this.connectState = 0;
            }
        }
    }

    public boolean isBound() {
        return this.bound;
    }

    public boolean isConnected() {
        return this.connectState != 0;
    }

    public InetAddress getInetAddress() {
        return this.connectedAddress;
    }

    public int getPort() {
        return this.connectedPort;
    }

    public SocketAddress getRemoteSocketAddress() {
        if (!isConnected()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getPort());
    }

    public SocketAddress getLocalSocketAddress() {
        if (!isClosed() && isBound()) {
            return new InetSocketAddress(getLocalAddress(), getLocalPort());
        }
        return null;
    }

    public void send(DatagramPacket p) throws IOException {
        synchronized (p) {
            if (isClosed()) {
                throw new SocketException("Socket is closed");
            }
            checkAddress(p.getAddress(), "send");
            if (this.connectState == 0) {
                SecurityManager security = System.getSecurityManager();
                if (security != null) {
                    if (p.getAddress().isMulticastAddress()) {
                        security.checkMulticast(p.getAddress());
                    } else {
                        security.checkConnect(p.getAddress().getHostAddress(), p.getPort());
                    }
                }
            } else {
                InetAddress packetAddress = p.getAddress();
                if (packetAddress == null) {
                    p.setAddress(this.connectedAddress);
                    p.setPort(this.connectedPort);
                } else if (!packetAddress.equals(this.connectedAddress) || p.getPort() != this.connectedPort) {
                    throw new IllegalArgumentException("connected address and packet address differ");
                }
            }
            if (!isBound()) {
                bind(new InetSocketAddress(0));
            }
            getImpl().send(p);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a5, code lost:
        getImpl().receive(new java.net.DatagramPacket(new byte[1], 1));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void receive(java.net.DatagramPacket r13) throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            monitor-enter(r13)     // Catch:{ all -> 0x0023 }
            boolean r9 = r12.isBound()     // Catch:{ all -> 0x0020 }
            if (r9 != 0) goto L_0x0011
            java.net.InetSocketAddress r9 = new java.net.InetSocketAddress     // Catch:{ all -> 0x0020 }
            r10 = 0
            r9.<init>(r10)     // Catch:{ all -> 0x0020 }
            r12.bind(r9)     // Catch:{ all -> 0x0020 }
        L_0x0011:
            java.net.SocketException r9 = r12.pendingConnectException     // Catch:{ all -> 0x0020 }
            if (r9 == 0) goto L_0x0026
            java.net.SocketException r9 = new java.net.SocketException     // Catch:{ all -> 0x0020 }
            java.lang.String r10 = "Pending connect failure"
            java.net.SocketException r11 = r12.pendingConnectException     // Catch:{ all -> 0x0020 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0020 }
            throw r9     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r9 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0023 }
            throw r9     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r9 = move-exception
            monitor-exit(r12)
            throw r9
        L_0x0026:
            int r9 = r12.connectState     // Catch:{ all -> 0x0020 }
            if (r9 != 0) goto L_0x0052
            java.lang.SecurityManager r6 = java.lang.System.getSecurityManager()     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x0052
        L_0x0030:
            r1 = 0
            r4 = 0
            boolean r9 = r12.oldImpl     // Catch:{ all -> 0x0020 }
            if (r9 != 0) goto L_0x0092
            java.net.DatagramPacket r3 = new java.net.DatagramPacket     // Catch:{ all -> 0x0020 }
            r9 = 1
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0020 }
            r10 = 1
            r3.<init>(r9, r10)     // Catch:{ all -> 0x0020 }
            java.net.DatagramSocketImpl r9 = r12.getImpl()     // Catch:{ all -> 0x0020 }
            int r4 = r9.peekData(r3)     // Catch:{ all -> 0x0020 }
            java.net.InetAddress r9 = r3.getAddress()     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r9.getHostAddress()     // Catch:{ all -> 0x0020 }
        L_0x004f:
            r6.checkAccept(r1, r4)     // Catch:{ SecurityException -> 0x00a4 }
        L_0x0052:
            int r9 = r12.connectState     // Catch:{ all -> 0x0020 }
            r10 = 2
            if (r9 != r10) goto L_0x00c7
            r7 = 0
        L_0x0058:
            if (r7 != 0) goto L_0x00c7
            r2 = 0
            r4 = -1
            boolean r9 = r12.oldImpl     // Catch:{ all -> 0x0020 }
            if (r9 != 0) goto L_0x00b7
            java.net.DatagramPacket r3 = new java.net.DatagramPacket     // Catch:{ all -> 0x0020 }
            r9 = 1
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0020 }
            r10 = 1
            r3.<init>(r9, r10)     // Catch:{ all -> 0x0020 }
            java.net.DatagramSocketImpl r9 = r12.getImpl()     // Catch:{ all -> 0x0020 }
            int r4 = r9.peekData(r3)     // Catch:{ all -> 0x0020 }
            java.net.InetAddress r2 = r3.getAddress()     // Catch:{ all -> 0x0020 }
        L_0x0075:
            java.net.InetAddress r9 = r12.connectedAddress     // Catch:{ all -> 0x0020 }
            boolean r9 = r9.equals(r2)     // Catch:{ all -> 0x0020 }
            if (r9 == 0) goto L_0x0081
            int r9 = r12.connectedPort     // Catch:{ all -> 0x0020 }
            if (r9 == r4) goto L_0x00c5
        L_0x0081:
            java.net.DatagramPacket r8 = new java.net.DatagramPacket     // Catch:{ all -> 0x0020 }
            r9 = 1
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0020 }
            r10 = 1
            r8.<init>(r9, r10)     // Catch:{ all -> 0x0020 }
            java.net.DatagramSocketImpl r9 = r12.getImpl()     // Catch:{ all -> 0x0020 }
            r9.receive(r8)     // Catch:{ all -> 0x0020 }
            goto L_0x0058
        L_0x0092:
            java.net.InetAddress r0 = new java.net.InetAddress     // Catch:{ all -> 0x0020 }
            r0.<init>()     // Catch:{ all -> 0x0020 }
            java.net.DatagramSocketImpl r9 = r12.getImpl()     // Catch:{ all -> 0x0020 }
            int r4 = r9.peek(r0)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r0.getHostAddress()     // Catch:{ all -> 0x0020 }
            goto L_0x004f
        L_0x00a4:
            r5 = move-exception
            java.net.DatagramPacket r8 = new java.net.DatagramPacket     // Catch:{ all -> 0x0020 }
            r9 = 1
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0020 }
            r10 = 1
            r8.<init>(r9, r10)     // Catch:{ all -> 0x0020 }
            java.net.DatagramSocketImpl r9 = r12.getImpl()     // Catch:{ all -> 0x0020 }
            r9.receive(r8)     // Catch:{ all -> 0x0020 }
            goto L_0x0030
        L_0x00b7:
            java.net.InetAddress r2 = new java.net.InetAddress     // Catch:{ all -> 0x0020 }
            r2.<init>()     // Catch:{ all -> 0x0020 }
            java.net.DatagramSocketImpl r9 = r12.getImpl()     // Catch:{ all -> 0x0020 }
            int r4 = r9.peek(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x0075
        L_0x00c5:
            r7 = 1
            goto L_0x0058
        L_0x00c7:
            java.net.DatagramSocketImpl r9 = r12.getImpl()     // Catch:{ all -> 0x0020 }
            r9.receive(r13)     // Catch:{ all -> 0x0020 }
            monitor-exit(r13)     // Catch:{ all -> 0x0023 }
            monitor-exit(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.DatagramSocket.receive(java.net.DatagramPacket):void");
    }

    public InetAddress getLocalAddress() {
        if (isClosed()) {
            return null;
        }
        try {
            InetAddress in = (InetAddress) getImpl().getOption(15);
            if (in.isAnyLocalAddress()) {
                in = InetAddress.anyLocalAddress();
            }
            SecurityManager s = System.getSecurityManager();
            if (s == null) {
                return in;
            }
            s.checkConnect(in.getHostAddress(), -1);
            return in;
        } catch (Exception e) {
            return InetAddress.anyLocalAddress();
        }
    }

    public int getLocalPort() {
        if (isClosed()) {
            return -1;
        }
        try {
            return getImpl().getLocalPort();
        } catch (Exception e) {
            return 0;
        }
    }

    public synchronized void setSoTimeout(int timeout) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(SocketOptions.SO_TIMEOUT, new Integer(timeout));
    }

    public synchronized int getSoTimeout() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (getImpl() == null) {
            return 0;
        } else {
            Object o = getImpl().getOption(SocketOptions.SO_TIMEOUT);
            if (!(o instanceof Integer)) {
                return 0;
            }
            return ((Integer) o).intValue();
        }
    }

    public synchronized void setSendBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("negative send size");
        } else if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            getImpl().setOption(SocketOptions.SO_SNDBUF, new Integer(size));
        }
    }

    public synchronized int getSendBufferSize() throws SocketException {
        int result;
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        result = 0;
        Object o = getImpl().getOption(SocketOptions.SO_SNDBUF);
        if (o instanceof Integer) {
            result = ((Integer) o).intValue();
        }
        return result;
    }

    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("invalid receive size");
        } else if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            getImpl().setOption(SocketOptions.SO_RCVBUF, new Integer(size));
        }
    }

    public synchronized int getReceiveBufferSize() throws SocketException {
        int result;
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        result = 0;
        Object o = getImpl().getOption(SocketOptions.SO_RCVBUF);
        if (o instanceof Integer) {
            result = ((Integer) o).intValue();
        }
        return result;
    }

    public synchronized void setReuseAddress(boolean on) throws SocketException {
        int i;
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (this.oldImpl) {
            DatagramSocketImpl impl2 = getImpl();
            if (on) {
                i = -1;
            } else {
                i = 0;
            }
            impl2.setOption(4, new Integer(i));
        } else {
            getImpl().setOption(4, Boolean.valueOf(on));
        }
    }

    public synchronized boolean getReuseAddress() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Boolean) getImpl().getOption(4)).booleanValue();
    }

    public synchronized void setBroadcast(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(32, Boolean.valueOf(on));
    }

    public synchronized boolean getBroadcast() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Boolean) getImpl().getOption(32)).booleanValue();
    }

    public synchronized void setTrafficClass(int tc) throws SocketException {
        if (tc < 0 || tc > 255) {
            throw new IllegalArgumentException("tc is not in range 0 -- 255");
        } else if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            getImpl().setOption(3, new Integer(tc));
        }
    }

    public synchronized int getTrafficClass() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Integer) getImpl().getOption(3)).intValue();
    }

    public void close() {
        synchronized (this.closeLock) {
            if (!isClosed()) {
                this.impl.close();
                this.closed = true;
            }
        }
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.closeLock) {
            z = this.closed;
        }
        return z;
    }

    public DatagramChannel getChannel() {
        return null;
    }

    public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        synchronized (DatagramSocket.class) {
            if (factory != null) {
                throw new SocketException("factory already defined");
            }
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkSetFactory();
            }
            factory = fac;
        }
    }

    public FileDescriptor getFileDescriptor$() {
        return this.impl.fd;
    }

    public void setNetworkInterface(NetworkInterface netInterface) throws SocketException {
        if (netInterface == null) {
            throw new NullPointerException("netInterface == null");
        }
        try {
            Libcore.os.setsockoptIfreq(this.impl.fd, OsConstants.SOL_SOCKET, OsConstants.SO_BINDTODEVICE, netInterface.getName());
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }
}
