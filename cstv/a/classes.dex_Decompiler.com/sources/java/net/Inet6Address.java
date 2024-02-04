package java.net;

import android.system.OsConstants;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import libcore.io.Libcore;
import sun.security.util.DerValue;

public final class Inet6Address extends InetAddress {
    public static final InetAddress ANY = null;
    static final int INADDRSZ = 16;
    private static final int INT16SZ = 2;
    public static final InetAddress LOOPBACK = null;
    private static final long serialVersionUID = 6880410070516793377L;
    private String ifname;
    byte[] ipaddress;
    private int scope_id = 0;
    private boolean scope_id_set = false;
    private transient NetworkInterface scope_ifname = null;
    private boolean scope_ifname_set = false;

    Inet6Address() {
        holder().hostName = null;
        this.ipaddress = new byte[16];
        holder().family = OsConstants.AF_INET6;
    }

    Inet6Address(String hostName, byte[] addr, int scope_id2) {
        holder().hostName = hostName;
        if (addr.length == 16) {
            holder().family = OsConstants.AF_INET6;
            this.ipaddress = (byte[]) addr.clone();
        }
        if (scope_id2 > 0) {
            this.scope_id = scope_id2;
            this.scope_id_set = true;
        }
    }

    Inet6Address(String hostName, byte[] addr) {
        try {
            initif(hostName, addr, (NetworkInterface) null);
        } catch (UnknownHostException e) {
        }
    }

    Inet6Address(String hostName, byte[] addr, NetworkInterface nif) throws UnknownHostException {
        initif(hostName, addr, nif);
    }

    Inet6Address(String hostName, byte[] addr, String ifname2) throws UnknownHostException {
        initstr(hostName, addr, ifname2);
    }

    public static Inet6Address getByAddress(String host, byte[] addr, NetworkInterface nif) throws UnknownHostException {
        if (host != null && host.length() > 0 && host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']') {
            host = host.substring(1, host.length() - 1);
        }
        if (addr != null && addr.length == 16) {
            return new Inet6Address(host, addr, nif);
        }
        throw new UnknownHostException("addr is of illegal length");
    }

    public static Inet6Address getByAddress(String host, byte[] addr, int scope_id2) throws UnknownHostException {
        if (host != null && host.length() > 0 && host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']') {
            host = host.substring(1, host.length() - 1);
        }
        if (addr != null && addr.length == 16) {
            return new Inet6Address(host, addr, scope_id2);
        }
        throw new UnknownHostException("addr is of illegal length");
    }

    private void initstr(String hostName, byte[] addr, String ifname2) throws UnknownHostException {
        try {
            NetworkInterface nif = NetworkInterface.getByName(ifname2);
            if (nif == null) {
                throw new UnknownHostException("no such interface " + ifname2);
            }
            initif(hostName, addr, nif);
        } catch (SocketException e) {
            throw new UnknownHostException("SocketException thrown" + ifname2);
        }
    }

    private void initif(String hostName, byte[] addr, NetworkInterface nif) throws UnknownHostException {
        holder().hostName = hostName;
        if (addr.length == 16) {
            holder().family = OsConstants.AF_INET6;
            this.ipaddress = (byte[]) addr.clone();
        }
        if (nif != null) {
            this.scope_ifname = nif;
            this.scope_ifname_set = true;
            this.scope_id = deriveNumericScope(nif);
            this.scope_id_set = true;
        }
    }

    private boolean differentLocalAddressTypes(Inet6Address other) {
        if (isLinkLocalAddress() && !other.isLinkLocalAddress()) {
            return false;
        }
        if (!isSiteLocalAddress() || other.isSiteLocalAddress()) {
            return true;
        }
        return false;
    }

    private int deriveNumericScope(NetworkInterface ifc) throws UnknownHostException {
        Enumeration<InetAddress> addresses = ifc.getInetAddresses();
        while (addresses.hasMoreElements()) {
            InetAddress addr = addresses.nextElement();
            if (addr instanceof Inet6Address) {
                Inet6Address ia6_addr = (Inet6Address) addr;
                if (differentLocalAddressTypes(ia6_addr)) {
                    return ia6_addr.scope_id;
                }
            }
        }
        throw new UnknownHostException("no scope_id found");
    }

    private int deriveNumericScope(String ifname2) throws UnknownHostException {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface ifc = en.nextElement();
                if (ifc.getName().equals(ifname2)) {
                    Enumeration addresses = ifc.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress addr = addresses.nextElement();
                        if (addr instanceof Inet6Address) {
                            Inet6Address ia6_addr = (Inet6Address) addr;
                            if (differentLocalAddressTypes(ia6_addr)) {
                                return ia6_addr.scope_id;
                            }
                        }
                    }
                    continue;
                }
            }
            throw new UnknownHostException("No matching address found for interface : " + ifname2);
        } catch (SocketException e) {
            throw new UnknownHostException("could not enumerate local network interfaces");
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        this.scope_ifname = null;
        this.scope_ifname_set = false;
        if (getClass().getClassLoader() != Class.class.getClassLoader()) {
            throw new SecurityException("invalid address type");
        }
        s.defaultReadObject();
        if (this.ifname != null && !"".equals(this.ifname)) {
            try {
                this.scope_ifname = NetworkInterface.getByName(this.ifname);
                if (this.scope_ifname == null) {
                    this.scope_id_set = false;
                    this.scope_ifname_set = false;
                    this.scope_id = 0;
                } else {
                    try {
                        this.scope_id = deriveNumericScope(this.scope_ifname);
                    } catch (UnknownHostException e) {
                    }
                }
            } catch (SocketException e2) {
            }
        }
        this.ipaddress = (byte[]) this.ipaddress.clone();
        if (this.ipaddress.length != 16) {
            throw new InvalidObjectException("invalid address length: " + this.ipaddress.length);
        } else if (holder().getFamily() != OsConstants.AF_INET6) {
            throw new InvalidObjectException("invalid address family type");
        }
    }

    public boolean isMulticastAddress() {
        return (this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 255;
    }

    public boolean isAnyLocalAddress() {
        byte test = 0;
        for (int i = 0; i < 16; i++) {
            test = (byte) (this.ipaddress[i] | test);
        }
        if (test == 0) {
            return true;
        }
        return false;
    }

    public boolean isLoopbackAddress() {
        byte test = 0;
        for (int i = 0; i < 15; i++) {
            test = (byte) (this.ipaddress[i] | test);
        }
        if (test == 0 && this.ipaddress[15] == 1) {
            return true;
        }
        return false;
    }

    public boolean isLinkLocalAddress() {
        if ((this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 254) {
            return (this.ipaddress[1] & DerValue.TAG_PRIVATE) == 128;
        }
        return false;
    }

    public boolean isSiteLocalAddress() {
        if ((this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 254) {
            return (this.ipaddress[1] & DerValue.TAG_PRIVATE) == 192;
        }
        return false;
    }

    public boolean isMCGlobal() {
        if ((this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 255) {
            return (this.ipaddress[1] & 15) == 14;
        }
        return false;
    }

    public boolean isMCNodeLocal() {
        if ((this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 255) {
            return (this.ipaddress[1] & 15) == 1;
        }
        return false;
    }

    public boolean isMCLinkLocal() {
        if ((this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 255) {
            return (this.ipaddress[1] & 15) == 2;
        }
        return false;
    }

    public boolean isMCSiteLocal() {
        if ((this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 255) {
            return (this.ipaddress[1] & 15) == 5;
        }
        return false;
    }

    public boolean isMCOrgLocal() {
        if ((this.ipaddress[0] & Character.DIRECTIONALITY_UNDEFINED) == 255) {
            return (this.ipaddress[1] & 15) == 8;
        }
        return false;
    }

    public byte[] getAddress() {
        return (byte[]) this.ipaddress.clone();
    }

    public int getScopeId() {
        return this.scope_id;
    }

    public NetworkInterface getScopedInterface() {
        return this.scope_ifname;
    }

    public String getHostAddress() {
        return Libcore.os.getnameinfo(this, OsConstants.NI_NUMERICHOST);
    }

    public int hashCode() {
        if (this.ipaddress == null) {
            return 0;
        }
        int hash = 0;
        int i = 0;
        while (i < 16) {
            int j = 0;
            int component = 0;
            while (j < 4 && i < 16) {
                component = (component << 8) + this.ipaddress[i];
                j++;
                i++;
            }
            hash += component;
        }
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Inet6Address)) {
            return false;
        }
        Inet6Address inetAddr = (Inet6Address) obj;
        for (int i = 0; i < 16; i++) {
            if (this.ipaddress[i] != inetAddr.ipaddress[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv4CompatibleAddress() {
        return this.ipaddress[0] == 0 && this.ipaddress[1] == 0 && this.ipaddress[2] == 0 && this.ipaddress[3] == 0 && this.ipaddress[4] == 0 && this.ipaddress[5] == 0 && this.ipaddress[6] == 0 && this.ipaddress[7] == 0 && this.ipaddress[8] == 0 && this.ipaddress[9] == 0 && this.ipaddress[10] == 0 && this.ipaddress[11] == 0;
    }

    static String numericToTextFormat(byte[] src) {
        StringBuffer sb = new StringBuffer(39);
        for (int i = 0; i < 8; i++) {
            sb.append(Integer.toHexString(((src[i << 1] << 8) & 65280) | (src[(i << 1) + 1] & Character.DIRECTIONALITY_UNDEFINED)));
            if (i < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        if (this.scope_ifname_set) {
            this.ifname = this.scope_ifname.getName();
        }
        s.defaultWriteObject();
    }
}
