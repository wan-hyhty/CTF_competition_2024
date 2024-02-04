package java.net;

public final class DatagramPacket {
    InetAddress address;
    byte[] buf;
    int bufLength;
    int length;
    int offset;
    int port;

    private static native void init();

    public DatagramPacket(byte[] buf2, int offset2, int length2) {
        setData(buf2, offset2, length2);
        this.address = null;
        this.port = -1;
    }

    public DatagramPacket(byte[] buf2, int length2) {
        this(buf2, 0, length2);
    }

    public DatagramPacket(byte[] buf2, int offset2, int length2, InetAddress address2, int port2) {
        setData(buf2, offset2, length2);
        setAddress(address2);
        setPort(port2);
    }

    public DatagramPacket(byte[] buf2, int offset2, int length2, SocketAddress address2) throws SocketException {
        setData(buf2, offset2, length2);
        setSocketAddress(address2);
    }

    public DatagramPacket(byte[] buf2, int length2, InetAddress address2, int port2) {
        this(buf2, 0, length2, address2, port2);
    }

    public DatagramPacket(byte[] buf2, int length2, SocketAddress address2) throws SocketException {
        this(buf2, 0, length2, address2);
    }

    public synchronized InetAddress getAddress() {
        return this.address;
    }

    public synchronized int getPort() {
        return this.port;
    }

    public synchronized byte[] getData() {
        return this.buf;
    }

    public synchronized int getOffset() {
        return this.offset;
    }

    public synchronized int getLength() {
        return this.length;
    }

    public synchronized void setData(byte[] buf2, int offset2, int length2) {
        if (length2 >= 0 && offset2 >= 0 && length2 + offset2 >= 0) {
            if (length2 + offset2 <= buf2.length) {
                this.buf = buf2;
                this.length = length2;
                this.bufLength = length2;
                this.offset = offset2;
            }
        }
        throw new IllegalArgumentException("illegal length or offset");
    }

    public synchronized void setAddress(InetAddress iaddr) {
        this.address = iaddr;
    }

    public void setReceivedLength(int length2) {
        this.length = length2;
    }

    public synchronized void setPort(int iport) {
        if (iport < 0 || iport > 65535) {
            throw new IllegalArgumentException("Port out of range:" + iport);
        }
        this.port = iport;
    }

    public synchronized void setSocketAddress(SocketAddress address2) {
        if (address2 != null) {
            if (address2 instanceof InetSocketAddress) {
                InetSocketAddress addr = (InetSocketAddress) address2;
                if (addr.isUnresolved()) {
                    throw new IllegalArgumentException("unresolved address");
                }
                setAddress(addr.getAddress());
                setPort(addr.getPort());
            }
        }
        throw new IllegalArgumentException("unsupported address type");
    }

    public synchronized SocketAddress getSocketAddress() {
        return new InetSocketAddress(getAddress(), getPort());
    }

    public synchronized void setData(byte[] buf2) {
        if (buf2 == null) {
            throw new NullPointerException("null packet buffer");
        }
        this.buf = buf2;
        this.offset = 0;
        this.length = buf2.length;
        this.bufLength = buf2.length;
    }

    public synchronized void setLength(int length2) {
        if (this.offset + length2 <= this.buf.length && length2 >= 0) {
            if (this.offset + length2 >= 0) {
                this.length = length2;
                this.bufLength = this.length;
            }
        }
        throw new IllegalArgumentException("illegal length");
    }
}
