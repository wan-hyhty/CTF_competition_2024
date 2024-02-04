package java.net;

import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.net.ConnectionResetException;
import sun.net.NetHooks;
import sun.net.ResourceManager;

abstract class AbstractPlainSocketImpl extends SocketImpl {
    public static final int SHUT_RD = 0;
    public static final int SHUT_WR = 1;
    private int CONNECTION_NOT_RESET = 0;
    private int CONNECTION_RESET = 2;
    private int CONNECTION_RESET_PENDING = 1;
    protected boolean closePending = false;
    protected final Object fdLock = new Object();
    private final CloseGuard guard = CloseGuard.get();
    private final Object resetLock = new Object();
    private int resetState;
    private boolean shut_rd = false;
    private boolean shut_wr = false;
    private SocketInputStream socketInputStream = null;
    protected boolean stream;
    int timeout;
    private int trafficClass;

    /* access modifiers changed from: package-private */
    public abstract void socketAccept(SocketImpl socketImpl) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int socketAvailable() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void socketBind(InetAddress inetAddress, int i) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void socketClose0() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void socketConnect(InetAddress inetAddress, int i, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void socketCreate(boolean z) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract int socketGetOption(int i, Object obj) throws SocketException;

    /* access modifiers changed from: package-private */
    public abstract void socketListen(int i) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void socketSendUrgentData(int i) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void socketSetOption(int i, boolean z, Object obj) throws SocketException;

    /* access modifiers changed from: package-private */
    public abstract void socketShutdown(int i) throws IOException;

    AbstractPlainSocketImpl() {
    }

    /* access modifiers changed from: protected */
    public synchronized void create(boolean stream2) throws IOException {
        this.stream = stream2;
        if (!stream2) {
            ResourceManager.beforeUdpCreate();
            try {
                socketCreate(false);
            } catch (IOException ioe) {
                ResourceManager.afterUdpClose();
                throw ioe;
            }
        } else {
            socketCreate(true);
        }
        if (this.socket != null) {
            this.socket.setCreated();
        }
        if (this.serverSocket != null) {
            this.serverSocket.setCreated();
        }
        if (this.fd != null && this.fd.valid()) {
            this.guard.open("close");
        }
    }

    /* access modifiers changed from: protected */
    public void connect(String host, int port) throws UnknownHostException, IOException {
        boolean connected = false;
        try {
            InetAddress address = InetAddress.getByName(host);
            this.port = port;
            this.address = address;
            connectToAddress(address, port, this.timeout);
            connected = true;
        } finally {
            if (!connected) {
                try {
                    close();
                } catch (IOException e) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void connect(InetAddress address, int port) throws IOException {
        this.port = port;
        this.address = address;
        try {
            connectToAddress(address, port, this.timeout);
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public void connect(SocketAddress address, int timeout2) throws IOException {
        boolean connected = false;
        if (address != null) {
            try {
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress addr = (InetSocketAddress) address;
                    if (addr.isUnresolved()) {
                        throw new UnknownHostException(addr.getHostName());
                    }
                    this.port = addr.getPort();
                    this.address = addr.getAddress();
                    connectToAddress(this.address, this.port, timeout2);
                    connected = true;
                    if (!connected) {
                        try {
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } finally {
                if (!connected) {
                    try {
                        close();
                    } catch (IOException e2) {
                    }
                }
            }
        }
        throw new IllegalArgumentException("unsupported address type");
    }

    private void connectToAddress(InetAddress address, int port, int timeout2) throws IOException {
        if (address.isAnyLocalAddress()) {
            doConnect(InetAddress.getLocalHost(), port, timeout2);
        } else {
            doConnect(address, port, timeout2);
        }
    }

    public void setOption(int opt, Object val) throws SocketException {
        if (isClosedOrPending()) {
            throw new SocketException("Socket Closed");
        }
        boolean on = true;
        switch (opt) {
            case 1:
                if (val != null && (val instanceof Boolean)) {
                    on = ((Boolean) val).booleanValue();
                    break;
                } else {
                    throw new SocketException("bad parameter for TCP_NODELAY");
                }
            case 3:
                if (val != null && (val instanceof Integer)) {
                    this.trafficClass = ((Integer) val).intValue();
                    break;
                } else {
                    throw new SocketException("bad argument for IP_TOS");
                }
            case 4:
                if (val != null && (val instanceof Boolean)) {
                    on = ((Boolean) val).booleanValue();
                    break;
                } else {
                    throw new SocketException("bad parameter for SO_REUSEADDR");
                }
            case 8:
                if (val != null && (val instanceof Boolean)) {
                    on = ((Boolean) val).booleanValue();
                    break;
                } else {
                    throw new SocketException("bad parameter for SO_KEEPALIVE");
                }
            case 15:
                throw new SocketException("Cannot re-bind socket");
            case 128:
                if (val != null && ((val instanceof Integer) || (val instanceof Boolean))) {
                    if (val instanceof Boolean) {
                        on = false;
                        break;
                    }
                } else {
                    throw new SocketException("Bad parameter for option");
                }
                break;
            case SocketOptions.SO_SNDBUF:
            case SocketOptions.SO_RCVBUF:
                if (val == null || !(val instanceof Integer) || ((Integer) val).intValue() <= 0) {
                    throw new SocketException("bad parameter for SO_SNDBUF or SO_RCVBUF");
                }
            case SocketOptions.SO_OOBINLINE:
                if (val != null && (val instanceof Boolean)) {
                    on = ((Boolean) val).booleanValue();
                    break;
                } else {
                    throw new SocketException("bad parameter for SO_OOBINLINE");
                }
                break;
            case SocketOptions.SO_TIMEOUT:
                if (val != null && (val instanceof Integer)) {
                    int tmp = ((Integer) val).intValue();
                    if (tmp >= 0) {
                        this.timeout = tmp;
                        break;
                    } else {
                        throw new IllegalArgumentException("timeout < 0");
                    }
                } else {
                    throw new SocketException("Bad parameter for SO_TIMEOUT");
                }
                break;
            default:
                throw new SocketException("unrecognized TCP option: " + opt);
        }
        socketSetOption(opt, on, val);
    }

    public Object getOption(int opt) throws SocketException {
        boolean z = true;
        if (isClosedOrPending()) {
            throw new SocketException("Socket Closed");
        } else if (opt == 4102) {
            return new Integer(this.timeout);
        } else {
            switch (opt) {
                case 1:
                    if (socketGetOption(opt, (Object) null) == -1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 3:
                    int ret = socketGetOption(opt, (Object) null);
                    if (ret == -1) {
                        return new Integer(this.trafficClass);
                    }
                    return new Integer(ret);
                case 4:
                    if (socketGetOption(opt, (Object) null) == -1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 8:
                    if (socketGetOption(opt, (Object) null) == -1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 15:
                    InetAddressContainer in = new InetAddressContainer();
                    int ret2 = socketGetOption(opt, in);
                    return in.addr;
                case 128:
                    int ret3 = socketGetOption(opt, (Object) null);
                    return ret3 == -1 ? Boolean.FALSE : new Integer(ret3);
                case SocketOptions.SO_SNDBUF:
                case SocketOptions.SO_RCVBUF:
                    return new Integer(socketGetOption(opt, (Object) null));
                case SocketOptions.SO_OOBINLINE:
                    if (socketGetOption(opt, (Object) null) == -1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                default:
                    return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void doConnect(InetAddress address, int port, int timeout2) throws IOException {
        synchronized (this.fdLock) {
            if (!this.closePending && (this.socket == null || !this.socket.isBound())) {
                NetHooks.beforeTcpConnect(this.fd, address, port);
            }
        }
        try {
            BlockGuard.getThreadPolicy().onNetwork();
            socketConnect(address, port, timeout2);
            synchronized (this.fdLock) {
                if (this.closePending) {
                    throw new SocketException("Socket closed");
                }
            }
            if (this.socket != null) {
                this.socket.setBound();
                this.socket.setConnected();
            }
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void bind(InetAddress address, int lport) throws IOException {
        synchronized (this.fdLock) {
            if (!this.closePending && (this.socket == null || !this.socket.isBound())) {
                NetHooks.beforeTcpBind(this.fd, address, lport);
            }
        }
        socketBind(address, lport);
        if (this.socket != null) {
            this.socket.setBound();
        }
        if (this.serverSocket != null) {
            this.serverSocket.setBound();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void listen(int count) throws IOException {
        socketListen(count);
    }

    /* access modifiers changed from: protected */
    public void accept(SocketImpl s) throws IOException {
        BlockGuard.getThreadPolicy().onNetwork();
        socketAccept(s);
    }

    /* access modifiers changed from: protected */
    public synchronized InputStream getInputStream() throws IOException {
        if (isClosedOrPending()) {
            throw new IOException("Socket Closed");
        } else if (this.shut_rd) {
            throw new IOException("Socket input is shutdown");
        } else {
            if (this.socketInputStream == null) {
                this.socketInputStream = new SocketInputStream(this);
            }
        }
        return this.socketInputStream;
    }

    /* access modifiers changed from: package-private */
    public void setInputStream(SocketInputStream in) {
        this.socketInputStream = in;
    }

    /* access modifiers changed from: protected */
    public synchronized OutputStream getOutputStream() throws IOException {
        if (isClosedOrPending()) {
            throw new IOException("Socket Closed");
        } else if (this.shut_wr) {
            throw new IOException("Socket output is shutdown");
        }
        return new SocketOutputStream(this);
    }

    /* access modifiers changed from: package-private */
    public void setFileDescriptor(FileDescriptor fd) {
        this.fd = fd;
    }

    /* access modifiers changed from: package-private */
    public void setAddress(InetAddress address) {
        this.address = address;
    }

    /* access modifiers changed from: package-private */
    public void setPort(int port) {
        this.port = port;
    }

    /* access modifiers changed from: package-private */
    public void setLocalPort(int localport) {
        this.localport = localport;
    }

    /* access modifiers changed from: protected */
    public synchronized int available() throws IOException {
        int n;
        if (isClosedOrPending()) {
            throw new IOException("Stream closed.");
        } else if (isConnectionReset()) {
            return 0;
        } else {
            n = 0;
            try {
                n = socketAvailable();
                if (n == 0 && isConnectionResetPending()) {
                    setConnectionReset();
                }
            } catch (ConnectionResetException e) {
                setConnectionResetPending();
                try {
                    n = socketAvailable();
                    if (n == 0) {
                        setConnectionReset();
                    }
                } catch (ConnectionResetException e2) {
                }
            }
        }
        return n;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            java.lang.Object r1 = r2.fdLock
            monitor-enter(r1)
            java.io.FileDescriptor r0 = r2.fd     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            java.io.FileDescriptor r0 = r2.fd     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.valid()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            boolean r0 = r2.stream     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0016
            sun.net.ResourceManager.afterUdpClose()     // Catch:{ all -> 0x0026 }
        L_0x0016:
            boolean r0 = r2.closePending     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r1)
            return
        L_0x001c:
            r0 = 1
            r2.closePending = r0     // Catch:{ all -> 0x0026 }
            r2.socketClose()     // Catch:{ all -> 0x0026 }
            monitor-exit(r1)
            return
        L_0x0024:
            monitor-exit(r1)
            return
        L_0x0026:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.AbstractPlainSocketImpl.close():void");
    }

    /* access modifiers changed from: package-private */
    public void reset() throws IOException {
        if (this.fd != null && this.fd.valid()) {
            socketClose();
        }
        super.reset();
    }

    /* access modifiers changed from: protected */
    public void shutdownInput() throws IOException {
        if (this.fd != null && this.fd.valid()) {
            socketShutdown(0);
            if (this.socketInputStream != null) {
                this.socketInputStream.setEOF(true);
            }
            this.shut_rd = true;
        }
    }

    /* access modifiers changed from: protected */
    public void shutdownOutput() throws IOException {
        if (this.fd != null && this.fd.valid()) {
            socketShutdown(1);
            this.shut_wr = true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean supportsUrgentData() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void sendUrgentData(int data) throws IOException {
        if (this.fd == null || !this.fd.valid()) {
            throw new IOException("Socket Closed");
        }
        socketSendUrgentData(data);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws IOException {
        if (this.guard != null) {
            this.guard.warnIfOpen();
        }
        close();
    }

    /* access modifiers changed from: package-private */
    public FileDescriptor acquireFD() {
        FileDescriptor fileDescriptor;
        synchronized (this.fdLock) {
            fileDescriptor = this.fd;
        }
        return fileDescriptor;
    }

    public boolean isConnectionReset() {
        boolean z;
        synchronized (this.resetLock) {
            z = this.resetState == this.CONNECTION_RESET;
        }
        return z;
    }

    public boolean isConnectionResetPending() {
        boolean z;
        synchronized (this.resetLock) {
            z = this.resetState == this.CONNECTION_RESET_PENDING;
        }
        return z;
    }

    public void setConnectionReset() {
        synchronized (this.resetLock) {
            this.resetState = this.CONNECTION_RESET;
        }
    }

    public void setConnectionResetPending() {
        synchronized (this.resetLock) {
            if (this.resetState == this.CONNECTION_NOT_RESET) {
                this.resetState = this.CONNECTION_RESET_PENDING;
            }
        }
    }

    public boolean isClosedOrPending() {
        synchronized (this.fdLock) {
            if (!this.closePending && this.fd != null) {
                if (this.fd.valid()) {
                    return false;
                }
            }
            return true;
        }
    }

    public int getTimeout() {
        return this.timeout;
    }

    /* access modifiers changed from: protected */
    public void socketClose() throws IOException {
        this.guard.close();
        socketClose0();
    }
}
