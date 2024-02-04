package java.net;

import java.io.IOException;
import java.util.Enumeration;

public class MulticastSocket extends DatagramSocket {
    private InetAddress infAddress;
    private Object infLock;
    private boolean interfaceSet;
    private Object ttlLock;

    public MulticastSocket() throws IOException {
        this((SocketAddress) new InetSocketAddress(0));
    }

    public MulticastSocket(int port) throws IOException {
        this((SocketAddress) new InetSocketAddress(port));
    }

    public MulticastSocket(SocketAddress bindaddr) throws IOException {
        super((SocketAddress) null);
        this.ttlLock = new Object();
        this.infLock = new Object();
        this.infAddress = null;
        setReuseAddress(true);
        if (bindaddr != null) {
            bind(bindaddr);
        }
    }

    @Deprecated
    public void setTTL(byte ttl) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setTTL(ttl);
    }

    public void setTimeToLive(int ttl) throws IOException {
        if (ttl < 0 || ttl > 255) {
            throw new IllegalArgumentException("ttl out of range");
        } else if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            getImpl().setTimeToLive(ttl);
        }
    }

    @Deprecated
    public byte getTTL() throws IOException {
        if (!isClosed()) {
            return getImpl().getTTL();
        }
        throw new SocketException("Socket is closed");
    }

    public int getTimeToLive() throws IOException {
        if (!isClosed()) {
            return getImpl().getTimeToLive();
        }
        throw new SocketException("Socket is closed");
    }

    public void joinGroup(InetAddress mcastaddr) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(mcastaddr, "joinGroup");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkMulticast(mcastaddr);
        }
        if (!mcastaddr.isMulticastAddress()) {
            throw new SocketException("Not a multicast address");
        }
        NetworkInterface defaultInterface = NetworkInterface.getDefault();
        if (!this.interfaceSet && defaultInterface != null) {
            setNetworkInterface(defaultInterface);
        }
        getImpl().join(mcastaddr);
    }

    public void leaveGroup(InetAddress mcastaddr) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(mcastaddr, "leaveGroup");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkMulticast(mcastaddr);
        }
        if (!mcastaddr.isMulticastAddress()) {
            throw new SocketException("Not a multicast address");
        }
        getImpl().leave(mcastaddr);
    }

    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        } else if (this.oldImpl) {
            throw new UnsupportedOperationException();
        } else {
            checkAddress(((InetSocketAddress) mcastaddr).getAddress(), "joinGroup");
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkMulticast(((InetSocketAddress) mcastaddr).getAddress());
            }
            if (!((InetSocketAddress) mcastaddr).getAddress().isMulticastAddress()) {
                throw new SocketException("Not a multicast address");
            }
            getImpl().joinGroup(mcastaddr, netIf);
        }
    }

    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        } else if (this.oldImpl) {
            throw new UnsupportedOperationException();
        } else {
            checkAddress(((InetSocketAddress) mcastaddr).getAddress(), "leaveGroup");
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkMulticast(((InetSocketAddress) mcastaddr).getAddress());
            }
            if (!((InetSocketAddress) mcastaddr).getAddress().isMulticastAddress()) {
                throw new SocketException("Not a multicast address");
            }
            getImpl().leaveGroup(mcastaddr, netIf);
        }
    }

    public void setInterface(InetAddress inf) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(inf, "setInterface");
        synchronized (this.infLock) {
            getImpl().setOption(16, inf);
            this.infAddress = inf;
            this.interfaceSet = true;
        }
    }

    public InetAddress getInterface() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        synchronized (this.infLock) {
            InetAddress ia = (InetAddress) getImpl().getOption(16);
            if (this.infAddress == null) {
                return ia;
            }
            if (ia.equals(this.infAddress)) {
                return ia;
            }
            try {
                Enumeration addrs = NetworkInterface.getByInetAddress(ia).getInetAddresses();
                while (addrs.hasMoreElements()) {
                    if (addrs.nextElement().equals(this.infAddress)) {
                        InetAddress inetAddress = this.infAddress;
                        return inetAddress;
                    }
                }
                this.infAddress = null;
                return ia;
            } catch (Exception e) {
                return ia;
            }
        }
    }

    public void setNetworkInterface(NetworkInterface netIf) throws SocketException {
        synchronized (this.infLock) {
            getImpl().setOption(31, netIf);
            this.infAddress = null;
            this.interfaceSet = true;
        }
    }

    public NetworkInterface getNetworkInterface() throws SocketException {
        Integer niIndex = (Integer) getImpl().getOption(31);
        if (niIndex.intValue() != 0) {
            return NetworkInterface.getByIndex(niIndex.intValue());
        }
        InetAddress[] addrs = {InetAddress.anyLocalAddress()};
        return new NetworkInterface(addrs[0].getHostName(), 0, addrs);
    }

    public void setLoopbackMode(boolean disable) throws SocketException {
        getImpl().setOption(18, Boolean.valueOf(disable));
    }

    public boolean getLoopbackMode() throws SocketException {
        return ((Boolean) getImpl().getOption(18)).booleanValue();
    }

    @Deprecated
    public void send(DatagramPacket p, byte ttl) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(p.getAddress(), "send");
        synchronized (this.ttlLock) {
            synchronized (p) {
                if (this.connectState == 0) {
                    SecurityManager security = System.getSecurityManager();
                    if (security != null) {
                        if (p.getAddress().isMulticastAddress()) {
                            security.checkMulticast(p.getAddress(), ttl);
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
                        throw new SecurityException("connected address and packet address differ");
                    }
                }
                byte dttl = getTTL();
                if (ttl != dttl) {
                    try {
                        getImpl().setTTL(ttl);
                    } catch (Throwable th) {
                        if (ttl != dttl) {
                            getImpl().setTTL(dttl);
                        }
                        throw th;
                    }
                }
                getImpl().send(p);
                if (ttl != dttl) {
                    getImpl().setTTL(dttl);
                }
            }
        }
    }
}
