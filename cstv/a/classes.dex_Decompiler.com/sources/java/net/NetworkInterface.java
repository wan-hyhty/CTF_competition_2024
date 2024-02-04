package java.net;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

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
public final class NetworkInterface {
    private static final int defaultIndex = 0;
    private static final NetworkInterface defaultInterface = null;
    /* access modifiers changed from: private */
    public InetAddress[] addrs;
    private InterfaceAddress[] bindings;
    /* access modifiers changed from: private */
    public NetworkInterface[] childs;
    private String displayName;
    private byte[] hardwareAddr;
    private int index;
    private String name;
    private NetworkInterface parent;
    private boolean virtual;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.net.NetworkInterface.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.net.NetworkInterface.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.NetworkInterface.<clinit>():void");
    }

    private static native NetworkInterface[] getAll() throws SocketException;

    private static native NetworkInterface getByIndex0(int i) throws SocketException;

    private static native NetworkInterface getByInetAddress0(InetAddress inetAddress) throws SocketException;

    private static native NetworkInterface getByName0(String str) throws SocketException;

    private static native int getMTU0(String str, int i) throws SocketException;

    private static native boolean isLoopback0(String str, int i) throws SocketException;

    private static native boolean isP2P0(String str, int i) throws SocketException;

    private static native boolean isUp0(String str, int i) throws SocketException;

    private static native boolean supportsMulticast0(String str, int i) throws SocketException;

    NetworkInterface() {
        this.parent = null;
        this.virtual = false;
    }

    NetworkInterface(String name2, int index2, InetAddress[] addrs2) {
        this.parent = null;
        this.virtual = false;
        this.name = name2;
        this.index = index2;
        this.addrs = addrs2;
    }

    public String getName() {
        return this.name;
    }

    public Enumeration<InetAddress> getInetAddresses() {
        return new Enumeration<InetAddress>() {
            private int count = 0;
            private int i = 0;
            private InetAddress[] local_addrs;

            /* JADX WARNING: Removed duplicated region for block: B:7:0x002d A[ADDED_TO_REGION] */
            {
                /*
                    r7 = this;
                    r4 = 0
                    java.net.NetworkInterface.this = r8
                    r7.<init>()
                    r7.i = r4
                    r7.count = r4
                    java.net.InetAddress[] r4 = r8.addrs
                    int r4 = r4.length
                    java.net.InetAddress[] r4 = new java.net.InetAddress[r4]
                    r7.local_addrs = r4
                    r3 = 1
                    java.lang.SecurityManager r2 = java.lang.System.getSecurityManager()
                    if (r2 == 0) goto L_0x0025
                    java.net.NetPermission r4 = new java.net.NetPermission     // Catch:{ SecurityException -> 0x0044 }
                    java.lang.String r5 = "getNetworkInformation"
                    r4.<init>(r5)     // Catch:{ SecurityException -> 0x0044 }
                    r2.checkPermission(r4)     // Catch:{ SecurityException -> 0x0044 }
                L_0x0025:
                    r1 = 0
                L_0x0026:
                    java.net.InetAddress[] r4 = r8.addrs
                    int r4 = r4.length
                    if (r1 >= r4) goto L_0x0058
                    if (r2 == 0) goto L_0x0031
                    if (r3 == 0) goto L_0x0047
                L_0x0031:
                    java.net.InetAddress[] r4 = r7.local_addrs     // Catch:{ SecurityException -> 0x0056 }
                    int r5 = r7.count     // Catch:{ SecurityException -> 0x0056 }
                    int r6 = r5 + 1
                    r7.count = r6     // Catch:{ SecurityException -> 0x0056 }
                    java.net.InetAddress[] r6 = r8.addrs     // Catch:{ SecurityException -> 0x0056 }
                    r6 = r6[r1]     // Catch:{ SecurityException -> 0x0056 }
                    r4[r5] = r6     // Catch:{ SecurityException -> 0x0056 }
                L_0x0041:
                    int r1 = r1 + 1
                    goto L_0x0026
                L_0x0044:
                    r0 = move-exception
                    r3 = 0
                    goto L_0x0025
                L_0x0047:
                    java.net.InetAddress[] r4 = r8.addrs     // Catch:{ SecurityException -> 0x0056 }
                    r4 = r4[r1]     // Catch:{ SecurityException -> 0x0056 }
                    java.lang.String r4 = r4.getHostAddress()     // Catch:{ SecurityException -> 0x0056 }
                    r5 = -1
                    r2.checkConnect(r4, r5)     // Catch:{ SecurityException -> 0x0056 }
                    goto L_0x0031
                L_0x0056:
                    r0 = move-exception
                    goto L_0x0041
                L_0x0058:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: java.net.NetworkInterface.AnonymousClass1checkedAddresses.<init>(java.net.NetworkInterface):void");
            }

            public InetAddress nextElement() {
                if (this.i < this.count) {
                    InetAddress[] inetAddressArr = this.local_addrs;
                    int i2 = this.i;
                    this.i = i2 + 1;
                    return inetAddressArr[i2];
                }
                throw new NoSuchElementException();
            }

            public boolean hasMoreElements() {
                return this.i < this.count;
            }
        };
    }

    public List<InterfaceAddress> getInterfaceAddresses() {
        List<InterfaceAddress> lst = new ArrayList<>(1);
        SecurityManager sec = System.getSecurityManager();
        for (int j = 0; j < this.bindings.length; j++) {
            if (sec != null) {
                try {
                    sec.checkConnect(this.bindings[j].getAddress().getHostAddress(), -1);
                } catch (SecurityException e) {
                }
            }
            lst.add(this.bindings[j]);
        }
        return lst;
    }

    public Enumeration<NetworkInterface> getSubInterfaces() {
        return new Enumeration<NetworkInterface>(this) {
            private int i;
            final /* synthetic */ NetworkInterface this$0;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.net.NetworkInterface.1subIFs.hasMoreElements():boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 6 more
                */
            public boolean hasMoreElements() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.net.NetworkInterface.1subIFs.hasMoreElements():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.net.NetworkInterface.AnonymousClass1subIFs.hasMoreElements():boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.net.NetworkInterface.1subIFs.nextElement():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            public /* bridge */ /* synthetic */ java.lang.Object nextElement() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.net.NetworkInterface.1subIFs.nextElement():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.net.NetworkInterface.AnonymousClass1subIFs.nextElement():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.net.NetworkInterface.1subIFs.nextElement():java.net.NetworkInterface, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 6 more
                */
            public java.net.NetworkInterface nextElement() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.net.NetworkInterface.1subIFs.nextElement():java.net.NetworkInterface, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.net.NetworkInterface.AnonymousClass1subIFs.nextElement():java.net.NetworkInterface");
            }
        };
    }

    public NetworkInterface getParent() {
        return this.parent;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDisplayName() {
        if ("".equals(this.displayName)) {
            return null;
        }
        return this.displayName;
    }

    public static NetworkInterface getByName(String name2) throws SocketException {
        if (name2 != null) {
            return getByName0(name2);
        }
        throw new NullPointerException();
    }

    public static NetworkInterface getByIndex(int index2) throws SocketException {
        if (index2 >= 0) {
            return getByIndex0(index2);
        }
        throw new IllegalArgumentException("Interface index can't be negative");
    }

    public static NetworkInterface getByInetAddress(InetAddress addr) throws SocketException {
        if (addr == null) {
            throw new NullPointerException();
        }
        if (!(addr instanceof Inet4Address) ? addr instanceof Inet6Address : true) {
            return getByInetAddress0(addr);
        }
        throw new IllegalArgumentException("invalid address type");
    }

    public static Enumeration<NetworkInterface> getNetworkInterfaces() throws SocketException {
        final NetworkInterface[] netifs = getAll();
        if (netifs == null) {
            return null;
        }
        return new Enumeration<NetworkInterface>() {
            private int i = 0;

            public NetworkInterface nextElement() {
                if (netifs == null || this.i >= netifs.length) {
                    throw new NoSuchElementException();
                }
                NetworkInterface[] networkInterfaceArr = netifs;
                int i2 = this.i;
                this.i = i2 + 1;
                return networkInterfaceArr[i2];
            }

            public boolean hasMoreElements() {
                return netifs != null && this.i < netifs.length;
            }
        };
    }

    public boolean isUp() throws SocketException {
        return isUp0(this.name, this.index);
    }

    public boolean isLoopback() throws SocketException {
        return isLoopback0(this.name, this.index);
    }

    public boolean isPointToPoint() throws SocketException {
        return isP2P0(this.name, this.index);
    }

    public boolean supportsMulticast() throws SocketException {
        return supportsMulticast0(this.name, this.index);
    }

    public byte[] getHardwareAddress() throws SocketException {
        NetworkInterface ni = getByName0(this.name);
        if (ni != null) {
            return ni.hardwareAddr;
        }
        throw new SocketException("NetworkInterface doesn't exist anymore");
    }

    public int getMTU() throws SocketException {
        return getMTU0(this.name, this.index);
    }

    public boolean isVirtual() {
        return this.virtual;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NetworkInterface)) {
            return false;
        }
        NetworkInterface that = (NetworkInterface) obj;
        if (this.name != null) {
            if (!this.name.equals(that.name)) {
                return false;
            }
        } else if (that.name != null) {
            return false;
        }
        if (this.addrs == null) {
            if (that.addrs == null) {
                return true;
            }
            return false;
        } else if (that.addrs == null || this.addrs.length != that.addrs.length) {
            return false;
        } else {
            InetAddress[] thatAddrs = that.addrs;
            int count = thatAddrs.length;
            for (int i = 0; i < count; i++) {
                boolean found = false;
                int j = 0;
                while (true) {
                    if (j >= count) {
                        break;
                    } else if (this.addrs[i].equals(thatAddrs[j])) {
                        found = true;
                        break;
                    } else {
                        j++;
                    }
                }
                if (!found) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        if (this.name == null) {
            return 0;
        }
        return this.name.hashCode();
    }

    public String toString() {
        String result = "name:" + (this.name == null ? "null" : this.name);
        if (this.displayName != null) {
            return result + " (" + this.displayName + ")";
        }
        return result;
    }

    static NetworkInterface getDefault() {
        return defaultInterface;
    }
}
