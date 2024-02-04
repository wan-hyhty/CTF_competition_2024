package java.net;

import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Enumeration;
import sun.net.ResourceManager;

abstract class AbstractPlainDatagramSocketImpl extends DatagramSocketImpl {
    private static final boolean connectDisabled = false;
    private static final String os = null;
    boolean connected = false;
    private InetAddress connectedAddress = null;
    private int connectedPort = -1;
    private final CloseGuard guard = CloseGuard.get();
    private boolean loopbackMode = true;
    private int multicastInterface = 0;
    int timeout = 0;
    private int trafficClass = 0;
    private int ttl = -1;

    /* access modifiers changed from: protected */
    public abstract void bind0(int i, InetAddress inetAddress) throws SocketException;

    /* access modifiers changed from: protected */
    public abstract void connect0(InetAddress inetAddress, int i) throws SocketException;

    /* access modifiers changed from: protected */
    public abstract void datagramSocketClose();

    /* access modifiers changed from: protected */
    public abstract void datagramSocketCreate() throws SocketException;

    /* access modifiers changed from: protected */
    public abstract void disconnect0(int i);

    /* access modifiers changed from: protected */
    public abstract byte getTTL() throws IOException;

    /* access modifiers changed from: protected */
    public abstract int getTimeToLive() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void join(InetAddress inetAddress, NetworkInterface networkInterface) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void leave(InetAddress inetAddress, NetworkInterface networkInterface) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int peek(InetAddress inetAddress) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int peekData(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void receive0(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void send(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void setTTL(byte b) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void setTimeToLive(int i) throws IOException;

    /* access modifiers changed from: protected */
    public abstract Object socketGetOption(int i) throws SocketException;

    /* access modifiers changed from: protected */
    public abstract void socketSetOption(int i, Object obj) throws SocketException;

    AbstractPlainDatagramSocketImpl() {
    }

    /* access modifiers changed from: protected */
    public synchronized void create() throws SocketException {
        ResourceManager.beforeUdpCreate();
        this.fd = new FileDescriptor();
        try {
            datagramSocketCreate();
            if (this.fd != null && this.fd.valid()) {
                this.guard.open("close");
            }
        } catch (SocketException ioe) {
            ResourceManager.afterUdpClose();
            this.fd = null;
            throw ioe;
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void bind(int lport, InetAddress laddr) throws SocketException {
        bind0(lport, laddr);
    }

    /* access modifiers changed from: protected */
    public void connect(InetAddress address, int port) throws SocketException {
        BlockGuard.getThreadPolicy().onNetwork();
        connect0(address, port);
        this.connectedAddress = address;
        this.connectedPort = port;
        this.connected = true;
    }

    /* access modifiers changed from: protected */
    public void disconnect() {
        disconnect0(this.connectedAddress.holder().getFamily());
        this.connected = false;
        this.connectedAddress = null;
        this.connectedPort = -1;
    }

    /* access modifiers changed from: protected */
    public synchronized void receive(DatagramPacket p) throws IOException {
        receive0(p);
    }

    /* access modifiers changed from: protected */
    public void join(InetAddress inetaddr) throws IOException {
        join(inetaddr, (NetworkInterface) null);
    }

    /* access modifiers changed from: protected */
    public void leave(InetAddress inetaddr) throws IOException {
        leave(inetaddr, (NetworkInterface) null);
    }

    /* access modifiers changed from: protected */
    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        join(((InetSocketAddress) mcastaddr).getAddress(), netIf);
    }

    /* access modifiers changed from: protected */
    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        leave(((InetSocketAddress) mcastaddr).getAddress(), netIf);
    }

    /* access modifiers changed from: protected */
    public void close() {
        this.guard.close();
        if (this.fd != null) {
            datagramSocketClose();
            ResourceManager.afterUdpClose();
            this.fd = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isClosed() {
        return this.fd == null;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.guard != null) {
            this.guard.warnIfOpen();
        }
        close();
    }

    public void setOption(int optID, Object o) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket Closed");
        }
        switch (optID) {
            case 3:
                if (o != null && (o instanceof Integer)) {
                    this.trafficClass = ((Integer) o).intValue();
                    break;
                } else {
                    throw new SocketException("bad argument for IP_TOS");
                }
            case 4:
                if (o == null || !(o instanceof Boolean)) {
                    throw new SocketException("bad argument for SO_REUSEADDR");
                }
            case 15:
                throw new SocketException("Cannot re-bind Socket");
            case 16:
                if (o == null || !(o instanceof InetAddress)) {
                    throw new SocketException("bad argument for IP_MULTICAST_IF");
                }
            case 18:
                if (o == null || !(o instanceof Boolean)) {
                    throw new SocketException("bad argument for IP_MULTICAST_LOOP");
                }
            case SocketOptions.IP_MULTICAST_IF2 /*31*/:
                if (o != null && ((o instanceof Integer) || (o instanceof NetworkInterface))) {
                    if (o instanceof NetworkInterface) {
                        o = new Integer(((NetworkInterface) o).getIndex());
                        break;
                    }
                } else {
                    throw new SocketException("bad argument for IP_MULTICAST_IF2");
                }
                break;
            case 32:
                if (o == null || !(o instanceof Boolean)) {
                    throw new SocketException("bad argument for SO_BROADCAST");
                }
            case SocketOptions.SO_SNDBUF /*4097*/:
            case SocketOptions.SO_RCVBUF /*4098*/:
                if (o == null || !(o instanceof Integer) || ((Integer) o).intValue() < 0) {
                    throw new SocketException("bad argument for SO_SNDBUF or SO_RCVBUF");
                }
            case SocketOptions.SO_TIMEOUT /*4102*/:
                if (o == null || !(o instanceof Integer)) {
                    throw new SocketException("bad argument for SO_TIMEOUT");
                }
                int tmp = ((Integer) o).intValue();
                if (tmp < 0) {
                    throw new IllegalArgumentException("timeout < 0");
                }
                this.timeout = tmp;
                return;
            default:
                throw new SocketException("invalid option: " + optID);
        }
        socketSetOption(optID, o);
    }

    public Object getOption(int optID) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket Closed");
        }
        switch (optID) {
            case 3:
                Object result = socketGetOption(optID);
                if (((Integer) result).intValue() == -1) {
                    return new Integer(this.trafficClass);
                }
                return result;
            case 4:
            case 15:
            case 16:
            case 18:
            case SocketOptions.IP_MULTICAST_IF2 /*31*/:
            case 32:
            case SocketOptions.SO_SNDBUF /*4097*/:
            case SocketOptions.SO_RCVBUF /*4098*/:
                Object result2 = socketGetOption(optID);
                if (optID == 16) {
                    return getNIFirstAddress(((Integer) result2).intValue());
                }
                return result2;
            case SocketOptions.SO_TIMEOUT /*4102*/:
                return new Integer(this.timeout);
            default:
                throw new SocketException("invalid option: " + optID);
        }
    }

    static InetAddress getNIFirstAddress(int niIndex) throws SocketException {
        if (niIndex > 0) {
            Enumeration<InetAddress> addressesEnum = NetworkInterface.getByIndex(niIndex).getInetAddresses();
            if (addressesEnum.hasMoreElements()) {
                return addressesEnum.nextElement();
            }
        }
        return InetAddress.anyLocalAddress();
    }

    /* access modifiers changed from: protected */
    public boolean nativeConnectDisabled() {
        return connectDisabled;
    }
}
