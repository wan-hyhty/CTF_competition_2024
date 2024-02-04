package java.net;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import sun.misc.Unsafe;

public class InetSocketAddress extends SocketAddress {
    private static final long FIELDS_OFFSET = 0;
    private static final Unsafe UNSAFE = null;
    private static final ObjectStreamField[] serialPersistentFields = null;
    private static final long serialVersionUID = 5076001401234631237L;
    private final transient InetSocketAddressHolder holder;

    private static class InetSocketAddressHolder {
        /* access modifiers changed from: private */
        public InetAddress addr;
        /* access modifiers changed from: private */
        public String hostname;
        /* access modifiers changed from: private */
        public int port;

        /* synthetic */ InetSocketAddressHolder(String hostname2, InetAddress addr2, int port2, InetSocketAddressHolder inetSocketAddressHolder) {
            this(hostname2, addr2, port2);
        }

        private InetSocketAddressHolder(String hostname2, InetAddress addr2, int port2) {
            this.hostname = hostname2;
            this.addr = addr2;
            this.port = port2;
        }

        /* access modifiers changed from: private */
        public int getPort() {
            return this.port;
        }

        /* access modifiers changed from: private */
        public InetAddress getAddress() {
            return this.addr;
        }

        /* access modifiers changed from: private */
        public String getHostName() {
            if (this.hostname != null) {
                return this.hostname;
            }
            if (this.addr != null) {
                return this.addr.getHostName();
            }
            return null;
        }

        /* access modifiers changed from: private */
        public String getHostString() {
            if (this.hostname != null) {
                return this.hostname;
            }
            if (this.addr == null) {
                return null;
            }
            if (this.addr.holder().getHostName() != null) {
                return this.addr.holder().getHostName();
            }
            return this.addr.getHostAddress();
        }

        /* access modifiers changed from: private */
        public boolean isUnresolved() {
            return this.addr == null;
        }

        public String toString() {
            if (isUnresolved()) {
                return this.hostname + ":" + this.port;
            }
            return this.addr.toString() + ":" + this.port;
        }

        public final boolean equals(Object obj) {
            boolean sameIP;
            if (obj == null || !(obj instanceof InetSocketAddressHolder)) {
                return false;
            }
            InetSocketAddressHolder that = (InetSocketAddressHolder) obj;
            if (this.addr != null) {
                sameIP = this.addr.equals(that.addr);
            } else if (this.hostname != null) {
                sameIP = that.addr == null ? this.hostname.equalsIgnoreCase(that.hostname) : false;
            } else {
                sameIP = that.addr == null && that.hostname == null;
            }
            if (!sameIP || this.port != that.port) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            if (this.addr != null) {
                return this.addr.hashCode() + this.port;
            }
            if (this.hostname != null) {
                return this.hostname.toLowerCase().hashCode() + this.port;
            }
            return this.port;
        }
    }

    private static int checkPort(int port) {
        if (port >= 0 && port <= 65535) {
            return port;
        }
        throw new IllegalArgumentException("port out of range:" + port);
    }

    private static String checkHost(String hostname) {
        if (hostname != null) {
            return hostname;
        }
        throw new IllegalArgumentException("hostname can't be null");
    }

    public InetSocketAddress() {
        this.holder = new InetSocketAddressHolder((String) null, (InetAddress) null, 0, (InetSocketAddressHolder) null);
    }

    public InetSocketAddress(int port) {
        this((InetAddress) null, port);
    }

    public InetSocketAddress(InetAddress addr, int port) {
        this.holder = new InetSocketAddressHolder((String) null, addr == null ? Inet6Address.ANY : addr, checkPort(port), (InetSocketAddressHolder) null);
    }

    public InetSocketAddress(String hostname, int port) {
        checkHost(hostname);
        InetAddress addr = null;
        String host = null;
        try {
            addr = InetAddress.getByName(hostname);
        } catch (UnknownHostException e) {
            host = hostname;
        }
        this.holder = new InetSocketAddressHolder(host, addr, checkPort(port), (InetSocketAddressHolder) null);
    }

    private InetSocketAddress(int port, String hostname) {
        this.holder = new InetSocketAddressHolder(hostname, (InetAddress) null, port, (InetSocketAddressHolder) null);
    }

    public static InetSocketAddress createUnresolved(String host, int port) {
        return new InetSocketAddress(checkPort(port), checkHost(host));
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("hostname", (Object) this.holder.hostname);
        pfields.put("addr", (Object) this.holder.addr);
        pfields.put("port", this.holder.port);
        out.writeFields();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField oisFields = in.readFields();
        String oisHostname = (String) oisFields.get("hostname", (Object) null);
        InetAddress oisAddr = (InetAddress) oisFields.get("addr", (Object) null);
        int oisPort = oisFields.get("port", -1);
        checkPort(oisPort);
        if (oisHostname == null && oisAddr == null) {
            throw new InvalidObjectException("hostname and addr can't both be null");
        }
        UNSAFE.putObject(this, FIELDS_OFFSET, new InetSocketAddressHolder(oisHostname, oisAddr, oisPort, (InetSocketAddressHolder) null));
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }

    public final int getPort() {
        return this.holder.getPort();
    }

    public final InetAddress getAddress() {
        return this.holder.getAddress();
    }

    public final String getHostName() {
        return this.holder.getHostName();
    }

    public final String getHostString() {
        return this.holder.getHostString();
    }

    public final boolean isUnresolved() {
        return this.holder.isUnresolved();
    }

    public String toString() {
        return this.holder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InetSocketAddress)) {
            return false;
        }
        return this.holder.equals(((InetSocketAddress) obj).holder);
    }

    public final int hashCode() {
        return this.holder.hashCode();
    }
}
