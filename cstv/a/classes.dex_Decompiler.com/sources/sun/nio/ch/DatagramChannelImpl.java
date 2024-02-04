package sun.nio.ch;

import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.ProtocolFamily;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.UnsupportedAddressTypeException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;
import sun.net.ResourceManager;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class DatagramChannelImpl extends DatagramChannel implements SelChImpl {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f121assertionsDisabled = false;
    private static final int ST_CONNECTED = 1;
    private static final int ST_KILLED = 2;
    private static final int ST_UNCONNECTED = 0;
    private static final int ST_UNINITIALIZED = -1;
    private static NativeDispatcher nd;
    private InetAddress cachedSenderInetAddress;
    private int cachedSenderPort;
    private final ProtocolFamily family;
    final FileDescriptor fd;
    private final int fdVal;
    private boolean isReuseAddress;
    private InetSocketAddress localAddress;
    private final Object readLock;
    private volatile long readerThread;
    private InetSocketAddress remoteAddress;
    private boolean reuseAddressEmulated;
    private SocketAddress sender;
    private DatagramSocket socket;
    private int state;
    private final Object stateLock;
    private final Object writeLock;
    private volatile long writerThread;

    private static class DefaultOptionsHolder {
        static final Set<SocketOption<?>> defaultOptions = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.DatagramChannelImpl.DefaultOptionsHolder.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        private DefaultOptionsHolder() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.DatagramChannelImpl.DefaultOptionsHolder.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.DefaultOptionsHolder.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.DatagramChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set<java.net.SocketOption<?>>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        private static java.util.Set<java.net.SocketOption<?>> defaultOptions() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.DatagramChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set<java.net.SocketOption<?>>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set");
        }
    }

    private static native void disconnect0(FileDescriptor fileDescriptor, boolean z) throws IOException;

    private static native void initIDs();

    private native int receive0(FileDescriptor fileDescriptor, long j, int i, boolean z) throws IOException;

    private native int send0(boolean z, FileDescriptor fileDescriptor, long j, int i, InetAddress inetAddress, int i2) throws IOException;

    public DatagramChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.readerThread = 0;
        this.writerThread = 0;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        ResourceManager.beforeUdpCreate();
        try {
            this.family = Net.isIPv6Available() ? StandardProtocolFamily.INET6 : StandardProtocolFamily.INET;
            this.fd = Net.socket(this.family, f121assertionsDisabled);
            this.fdVal = IOUtil.fdVal(this.fd);
            this.state = 0;
        } catch (IOException ioe) {
            ResourceManager.afterUdpClose();
            throw ioe;
        }
    }

    public DatagramChannelImpl(SelectorProvider sp, ProtocolFamily family2) throws IOException {
        super(sp);
        this.readerThread = 0;
        this.writerThread = 0;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        if (family2 == StandardProtocolFamily.INET || family2 == StandardProtocolFamily.INET6) {
            if (family2 != StandardProtocolFamily.INET6 || Net.isIPv6Available()) {
                this.family = family2;
                this.fd = Net.socket(family2, f121assertionsDisabled);
                this.fdVal = IOUtil.fdVal(this.fd);
                this.state = 0;
                return;
            }
            throw new UnsupportedOperationException("IPv6 not available");
        } else if (family2 == null) {
            throw new NullPointerException("'family' is null");
        } else {
            throw new UnsupportedOperationException("Protocol family not supported");
        }
    }

    public DatagramChannelImpl(SelectorProvider sp, FileDescriptor fd2) throws IOException {
        super(sp);
        this.readerThread = 0;
        this.writerThread = 0;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.family = Net.isIPv6Available() ? StandardProtocolFamily.INET6 : StandardProtocolFamily.INET;
        this.fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 0;
        this.localAddress = Net.localAddress(fd2);
    }

    public DatagramSocket socket() {
        DatagramSocket datagramSocket;
        synchronized (this.stateLock) {
            if (this.socket == null) {
                this.socket = DatagramSocketAdaptor.create(this);
            }
            datagramSocket = this.socket;
        }
        return datagramSocket;
    }

    public SocketAddress getLocalAddress() throws IOException {
        InetSocketAddress revealedLocalAddress;
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            revealedLocalAddress = Net.getRevealedLocalAddress(this.localAddress);
        }
        return revealedLocalAddress;
    }

    public SocketAddress getRemoteAddress() throws IOException {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            inetSocketAddress = this.remoteAddress;
        }
        return inetSocketAddress;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008f, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.nio.channels.DatagramChannel setOption(java.net.SocketOption<T> r9, T r10) throws java.io.IOException {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0008
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            r5.<init>()
            throw r5
        L_0x0008:
            java.util.Set r5 = r8.supportedOptions()
            boolean r5 = r5.contains(r9)
            if (r5 != 0) goto L_0x0033
            java.lang.UnsupportedOperationException r5 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "'"
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)
            java.lang.StringBuilder r6 = r6.append((java.lang.Object) r9)
            java.lang.String r7 = "' not supported"
            java.lang.StringBuilder r6 = r6.append((java.lang.String) r7)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0033:
            java.lang.Object r6 = r8.stateLock
            monitor-enter(r6)
            r8.ensureOpen()     // Catch:{ all -> 0x006c }
            java.net.SocketOption<java.lang.Integer> r5 = java.net.StandardSocketOptions.IP_TOS     // Catch:{ all -> 0x006c }
            if (r9 != r5) goto L_0x004c
            java.net.ProtocolFamily r5 = r8.family     // Catch:{ all -> 0x006c }
            java.net.StandardProtocolFamily r7 = java.net.StandardProtocolFamily.INET     // Catch:{ all -> 0x006c }
            if (r5 != r7) goto L_0x004a
            java.io.FileDescriptor r5 = r8.fd     // Catch:{ all -> 0x006c }
            java.net.ProtocolFamily r7 = r8.family     // Catch:{ all -> 0x006c }
            sun.nio.ch.Net.setSocketOption(r5, r7, r9, r10)     // Catch:{ all -> 0x006c }
        L_0x004a:
            monitor-exit(r6)
            return r8
        L_0x004c:
            java.net.SocketOption<java.lang.Integer> r5 = java.net.StandardSocketOptions.IP_MULTICAST_TTL     // Catch:{ all -> 0x006c }
            if (r9 == r5) goto L_0x0054
            java.net.SocketOption<java.lang.Boolean> r5 = java.net.StandardSocketOptions.IP_MULTICAST_LOOP     // Catch:{ all -> 0x006c }
            if (r9 != r5) goto L_0x005d
        L_0x0054:
            java.io.FileDescriptor r5 = r8.fd     // Catch:{ all -> 0x006c }
            java.net.ProtocolFamily r7 = r8.family     // Catch:{ all -> 0x006c }
            sun.nio.ch.Net.setSocketOption(r5, r7, r9, r10)     // Catch:{ all -> 0x006c }
            monitor-exit(r6)
            return r8
        L_0x005d:
            java.net.SocketOption<java.net.NetworkInterface> r5 = java.net.StandardSocketOptions.IP_MULTICAST_IF     // Catch:{ all -> 0x006c }
            if (r9 != r5) goto L_0x00a9
            if (r10 != 0) goto L_0x006f
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006c }
            java.lang.String r7 = "Cannot set IP_MULTICAST_IF to 'null'"
            r5.<init>((java.lang.String) r7)     // Catch:{ all -> 0x006c }
            throw r5     // Catch:{ all -> 0x006c }
        L_0x006c:
            r5 = move-exception
            monitor-exit(r6)
            throw r5
        L_0x006f:
            r0 = r10
            java.net.NetworkInterface r0 = (java.net.NetworkInterface) r0     // Catch:{ all -> 0x006c }
            r2 = r0
            java.net.ProtocolFamily r5 = r8.family     // Catch:{ all -> 0x006c }
            java.net.StandardProtocolFamily r7 = java.net.StandardProtocolFamily.INET6     // Catch:{ all -> 0x006c }
            if (r5 != r7) goto L_0x0090
            int r1 = r2.getIndex()     // Catch:{ all -> 0x006c }
            r5 = -1
            if (r1 != r5) goto L_0x0089
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x006c }
            java.lang.String r7 = "Network interface cannot be identified"
            r5.<init>((java.lang.String) r7)     // Catch:{ all -> 0x006c }
            throw r5     // Catch:{ all -> 0x006c }
        L_0x0089:
            java.io.FileDescriptor r5 = r8.fd     // Catch:{ all -> 0x006c }
            sun.nio.ch.Net.setInterface6(r5, r1)     // Catch:{ all -> 0x006c }
        L_0x008e:
            monitor-exit(r6)
            return r8
        L_0x0090:
            java.net.Inet4Address r3 = sun.nio.ch.Net.anyInet4Address(r2)     // Catch:{ all -> 0x006c }
            if (r3 != 0) goto L_0x009f
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x006c }
            java.lang.String r7 = "Network interface not configured for IPv4"
            r5.<init>((java.lang.String) r7)     // Catch:{ all -> 0x006c }
            throw r5     // Catch:{ all -> 0x006c }
        L_0x009f:
            int r4 = sun.nio.ch.Net.inet4AsInt(r3)     // Catch:{ all -> 0x006c }
            java.io.FileDescriptor r5 = r8.fd     // Catch:{ all -> 0x006c }
            sun.nio.ch.Net.setInterface4(r5, r4)     // Catch:{ all -> 0x006c }
            goto L_0x008e
        L_0x00a9:
            java.net.SocketOption<java.lang.Boolean> r5 = java.net.StandardSocketOptions.SO_REUSEADDR     // Catch:{ all -> 0x006c }
            if (r9 != r5) goto L_0x00c4
            boolean r5 = sun.nio.ch.Net.useExclusiveBind()     // Catch:{ all -> 0x006c }
            if (r5 == 0) goto L_0x00c4
            java.net.InetSocketAddress r5 = r8.localAddress     // Catch:{ all -> 0x006c }
            if (r5 == 0) goto L_0x00c4
            r5 = 1
            r8.reuseAddressEmulated = r5     // Catch:{ all -> 0x006c }
            r0 = r10
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006c }
            r5 = r0
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x006c }
            r8.isReuseAddress = r5     // Catch:{ all -> 0x006c }
        L_0x00c4:
            java.io.FileDescriptor r5 = r8.fd     // Catch:{ all -> 0x006c }
            java.net.ProtocolFamily r7 = sun.nio.ch.Net.UNSPEC     // Catch:{ all -> 0x006c }
            sun.nio.ch.Net.setSocketOption(r5, r7, r9, r10)     // Catch:{ all -> 0x006c }
            monitor-exit(r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.setOption(java.net.SocketOption, java.lang.Object):java.nio.channels.DatagramChannel");
    }

    public <T> T getOption(SocketOption<T> name) throws IOException {
        if (name == null) {
            throw new NullPointerException();
        } else if (!supportedOptions().contains(name)) {
            throw new UnsupportedOperationException("'" + name + "' not supported");
        } else {
            synchronized (this.stateLock) {
                ensureOpen();
                if (name == StandardSocketOptions.IP_TOS) {
                    if (this.family != StandardProtocolFamily.INET) {
                        return 0;
                    }
                    T socketOption = Net.getSocketOption(this.fd, this.family, name);
                    return socketOption;
                } else if (name == StandardSocketOptions.IP_MULTICAST_TTL || name == StandardSocketOptions.IP_MULTICAST_LOOP) {
                    T socketOption2 = Net.getSocketOption(this.fd, this.family, name);
                    return socketOption2;
                } else if (name == StandardSocketOptions.IP_MULTICAST_IF) {
                    if (this.family == StandardProtocolFamily.INET) {
                        int address = Net.getInterface4(this.fd);
                        if (address == 0) {
                            return null;
                        }
                        NetworkInterface ni = NetworkInterface.getByInetAddress(Net.inet4FromInt(address));
                        if (ni != null) {
                            return ni;
                        }
                        throw new IOException("Unable to map address to interface");
                    }
                    int index = Net.getInterface6(this.fd);
                    if (index == 0) {
                        return null;
                    }
                    NetworkInterface ni2 = NetworkInterface.getByIndex(index);
                    if (ni2 != null) {
                        return ni2;
                    }
                    throw new IOException("Unable to map index to interface");
                } else if (name != StandardSocketOptions.SO_REUSEADDR || !this.reuseAddressEmulated) {
                    T socketOption3 = Net.getSocketOption(this.fd, Net.UNSPEC, name);
                    return socketOption3;
                } else {
                    T valueOf = Boolean.valueOf(this.isReuseAddress);
                    return valueOf;
                }
            }
        }
    }

    public final Set<SocketOption<?>> supportedOptions() {
        return DefaultOptionsHolder.defaultOptions;
    }

    private void ensureOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0111, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a9, code lost:
        if (r0 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        sun.nio.ch.Util.releaseTemporaryDirectBuffer(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ae, code lost:
        r14.readerThread = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b2, code lost:
        if (r2 > 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b4, code lost:
        if (r2 != -2) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b6, code lost:
        end(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00bb, code lost:
        if (f121assertionsDisabled != false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c1, code lost:
        if (sun.nio.ch.IOStatus.check(r2) != false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00c8, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c9, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00cc, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r0.flip();
        r15.put(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.SocketAddress receive(java.nio.ByteBuffer r15) throws java.io.IOException {
        /*
            r14 = this;
            r13 = -2
            r6 = 1
            r7 = 0
            r12 = 0
            boolean r5 = r15.isReadOnly()
            if (r5 == 0) goto L_0x0013
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Read-only buffer"
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0013:
            if (r15 != 0) goto L_0x001b
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            r5.<init>()
            throw r5
        L_0x001b:
            java.net.InetSocketAddress r5 = r14.localAddress
            if (r5 != 0) goto L_0x0020
            return r12
        L_0x0020:
            java.lang.Object r8 = r14.readLock
            monitor-enter(r8)
            r14.ensureOpen()     // Catch:{ all -> 0x0049 }
            r2 = 0
            r0 = 0
            r14.begin()     // Catch:{ all -> 0x0112 }
            boolean r5 = r14.isOpen()     // Catch:{ all -> 0x0112 }
            if (r5 != 0) goto L_0x004e
            r6 = 0
            r14.readerThread = r6     // Catch:{ all -> 0x0049 }
            r5 = 0
            r14.end(r5)     // Catch:{ all -> 0x0049 }
            boolean r5 = f121assertionsDisabled     // Catch:{ all -> 0x0049 }
            if (r5 != 0) goto L_0x004c
            boolean r5 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0049 }
            if (r5 != 0) goto L_0x004c
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch:{ all -> 0x0049 }
            r5.<init>()     // Catch:{ all -> 0x0049 }
            throw r5     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r5 = move-exception
            monitor-exit(r8)
            throw r5
        L_0x004c:
            monitor-exit(r8)
            return r12
        L_0x004e:
            java.lang.SecurityManager r4 = java.lang.System.getSecurityManager()     // Catch:{ all -> 0x0112 }
            long r10 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x0112 }
            r14.readerThread = r10     // Catch:{ all -> 0x0112 }
            boolean r5 = r14.isConnected()     // Catch:{ all -> 0x0112 }
            if (r5 != 0) goto L_0x0060
            if (r4 != 0) goto L_0x0090
        L_0x0060:
            java.io.FileDescriptor r5 = r14.fd     // Catch:{ all -> 0x0112 }
            int r2 = r14.receive(r5, r15)     // Catch:{ all -> 0x0112 }
            r5 = -3
            if (r2 != r5) goto L_0x006f
            boolean r5 = r14.isOpen()     // Catch:{ all -> 0x0112 }
            if (r5 != 0) goto L_0x0060
        L_0x006f:
            if (r2 != r13) goto L_0x00e6
            r10 = 0
            r14.readerThread = r10     // Catch:{ all -> 0x0049 }
            if (r2 > 0) goto L_0x0079
            if (r2 != r13) goto L_0x008c
        L_0x0079:
            r14.end(r6)     // Catch:{ all -> 0x0049 }
            boolean r5 = f121assertionsDisabled     // Catch:{ all -> 0x0049 }
            if (r5 != 0) goto L_0x008e
            boolean r5 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0049 }
            if (r5 != 0) goto L_0x008e
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch:{ all -> 0x0049 }
            r5.<init>()     // Catch:{ all -> 0x0049 }
            throw r5     // Catch:{ all -> 0x0049 }
        L_0x008c:
            r6 = r7
            goto L_0x0079
        L_0x008e:
            monitor-exit(r8)
            return r12
        L_0x0090:
            int r5 = r15.remaining()     // Catch:{ all -> 0x0112 }
            java.nio.ByteBuffer r0 = sun.nio.ch.Util.getTemporaryDirectBuffer(r5)     // Catch:{ all -> 0x0112 }
        L_0x0098:
            java.io.FileDescriptor r5 = r14.fd     // Catch:{ all -> 0x0112 }
            int r2 = r14.receive(r5, r0)     // Catch:{ all -> 0x0112 }
            r5 = -3
            if (r2 != r5) goto L_0x00a7
            boolean r5 = r14.isOpen()     // Catch:{ all -> 0x0112 }
            if (r5 != 0) goto L_0x0098
        L_0x00a7:
            if (r2 != r13) goto L_0x00cd
            if (r0 == 0) goto L_0x00ae
            sun.nio.ch.Util.releaseTemporaryDirectBuffer(r0)     // Catch:{ all -> 0x0049 }
        L_0x00ae:
            r10 = 0
            r14.readerThread = r10     // Catch:{ all -> 0x0049 }
            if (r2 > 0) goto L_0x00b6
            if (r2 != r13) goto L_0x00c9
        L_0x00b6:
            r14.end(r6)     // Catch:{ all -> 0x0049 }
            boolean r5 = f121assertionsDisabled     // Catch:{ all -> 0x0049 }
            if (r5 != 0) goto L_0x00cb
            boolean r5 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0049 }
            if (r5 != 0) goto L_0x00cb
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch:{ all -> 0x0049 }
            r5.<init>()     // Catch:{ all -> 0x0049 }
            throw r5     // Catch:{ all -> 0x0049 }
        L_0x00c9:
            r6 = r7
            goto L_0x00b6
        L_0x00cb:
            monitor-exit(r8)
            return r12
        L_0x00cd:
            java.net.SocketAddress r1 = r14.sender     // Catch:{ all -> 0x0112 }
            java.net.InetSocketAddress r1 = (java.net.InetSocketAddress) r1     // Catch:{ all -> 0x0112 }
            java.net.InetAddress r5 = r1.getAddress()     // Catch:{ SecurityException -> 0x0108 }
            java.lang.String r5 = r5.getHostAddress()     // Catch:{ SecurityException -> 0x0108 }
            int r9 = r1.getPort()     // Catch:{ SecurityException -> 0x0108 }
            r4.checkAccept(r5, r9)     // Catch:{ SecurityException -> 0x0108 }
            r0.flip()     // Catch:{ all -> 0x0112 }
            r15.put((java.nio.ByteBuffer) r0)     // Catch:{ all -> 0x0112 }
        L_0x00e6:
            java.net.SocketAddress r5 = r14.sender     // Catch:{ all -> 0x0112 }
            if (r0 == 0) goto L_0x00ed
            sun.nio.ch.Util.releaseTemporaryDirectBuffer(r0)     // Catch:{ all -> 0x0049 }
        L_0x00ed:
            r10 = 0
            r14.readerThread = r10     // Catch:{ all -> 0x0049 }
            if (r2 > 0) goto L_0x00f5
            if (r2 != r13) goto L_0x010e
        L_0x00f5:
            r14.end(r6)     // Catch:{ all -> 0x0049 }
            boolean r6 = f121assertionsDisabled     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x0110
            boolean r6 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x0110
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch:{ all -> 0x0049 }
            r5.<init>()     // Catch:{ all -> 0x0049 }
            throw r5     // Catch:{ all -> 0x0049 }
        L_0x0108:
            r3 = move-exception
            r0.clear()     // Catch:{ all -> 0x0112 }
            r2 = 0
            goto L_0x0098
        L_0x010e:
            r6 = r7
            goto L_0x00f5
        L_0x0110:
            monitor-exit(r8)
            return r5
        L_0x0112:
            r5 = move-exception
            if (r0 == 0) goto L_0x0118
            sun.nio.ch.Util.releaseTemporaryDirectBuffer(r0)     // Catch:{ all -> 0x0049 }
        L_0x0118:
            r10 = 0
            r14.readerThread = r10     // Catch:{ all -> 0x0049 }
            if (r2 > 0) goto L_0x0120
            if (r2 != r13) goto L_0x0133
        L_0x0120:
            r14.end(r6)     // Catch:{ all -> 0x0049 }
            boolean r6 = f121assertionsDisabled     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x0135
            boolean r6 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x0135
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch:{ all -> 0x0049 }
            r5.<init>()     // Catch:{ all -> 0x0049 }
            throw r5     // Catch:{ all -> 0x0049 }
        L_0x0133:
            r6 = r7
            goto L_0x0120
        L_0x0135:
            throw r5     // Catch:{ all -> 0x0049 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.receive(java.nio.ByteBuffer):java.net.SocketAddress");
    }

    private int receive(FileDescriptor fd2, ByteBuffer dst) throws IOException {
        boolean z = f121assertionsDisabled;
        int pos = dst.position();
        int lim = dst.limit();
        if (!f121assertionsDisabled) {
            if (pos <= lim) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        if ((dst instanceof DirectBuffer) && rem > 0) {
            return receiveIntoNativeBuffer(fd2, dst, rem, pos);
        }
        int newSize = Math.max(rem, 1);
        ByteBuffer bb = Util.getTemporaryDirectBuffer(newSize);
        try {
            BlockGuard.getThreadPolicy().onNetwork();
            int n = receiveIntoNativeBuffer(fd2, bb, newSize, 0);
            bb.flip();
            if (n > 0 && rem > 0) {
                dst.put(bb);
            }
            return n;
        } finally {
            Util.releaseTemporaryDirectBuffer(bb);
        }
    }

    private int receiveIntoNativeBuffer(FileDescriptor fd2, ByteBuffer bb, int rem, int pos) throws IOException {
        FileDescriptor fileDescriptor = fd2;
        int i = rem;
        int n = receive0(fileDescriptor, ((long) pos) + ((DirectBuffer) bb).address(), i, isConnected());
        if (n > 0) {
            bb.position(pos + n);
        }
        return n;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0102, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0103, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0106, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0107, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004b, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        begin();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0053, code lost:
        if (isOpen() != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r11.writerThread = 0;
        end(f121assertionsDisabled);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005f, code lost:
        if (f121assertionsDisabled != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0065, code lost:
        if (sun.nio.ch.IOStatus.check(0) != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006c, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0092, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r11.writerThread = sun.nio.ch.NativeThread.current();
        dalvik.system.BlockGuard.getThreadPolicy().onNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a0, code lost:
        r2 = send(r11.fd, r12, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a7, code lost:
        if (r2 != -3) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ad, code lost:
        if (isOpen() != false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00af, code lost:
        r8 = r11.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b1, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00b6, code lost:
        if (isOpen() == false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ba, code lost:
        if (r11.localAddress != null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00bc, code lost:
        r11.localAddress = sun.nio.ch.Net.localAddress(r11.fd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00c5, code lost:
        r4 = sun.nio.ch.IOStatus.normalize(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r11.writerThread = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00cd, code lost:
        if (r2 > 0) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00cf, code lost:
        if (r2 != -2) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00d1, code lost:
        end(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00d6, code lost:
        if (f121assertionsDisabled != false) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00dc, code lost:
        if (sun.nio.ch.IOStatus.check(r2) != false) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00e3, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00e7, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r11.writerThread = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x00f0, code lost:
        end(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x00f5, code lost:
        if (f121assertionsDisabled != false) goto L_0x0109;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int send(java.nio.ByteBuffer r12, java.net.SocketAddress r13) throws java.io.IOException {
        /*
            r11 = this;
            r10 = -2
            r5 = 1
            r6 = 0
            if (r12 != 0) goto L_0x000b
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            r4.<init>()
            throw r4
        L_0x000b:
            java.lang.Object r7 = r11.writeLock
            monitor-enter(r7)
            r11.ensureOpen()     // Catch:{ all -> 0x0024 }
            java.net.InetSocketAddress r1 = sun.nio.ch.Net.checkAddress(r13)     // Catch:{ all -> 0x0024 }
            java.net.InetAddress r0 = r1.getAddress()     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0027
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0024 }
            java.lang.String r5 = "Target address not resolved"
            r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0024 }
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r4 = move-exception
            monitor-exit(r7)
            throw r4
        L_0x0027:
            java.lang.Object r8 = r11.stateLock     // Catch:{ all -> 0x0024 }
            monitor-enter(r8)     // Catch:{ all -> 0x0024 }
            boolean r4 = r11.isConnected()     // Catch:{ all -> 0x0038 }
            if (r4 != 0) goto L_0x0079
            if (r13 != 0) goto L_0x003b
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ all -> 0x0038 }
            r4.<init>()     // Catch:{ all -> 0x0038 }
            throw r4     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r4 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0024 }
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x003b:
            java.lang.SecurityManager r3 = java.lang.System.getSecurityManager()     // Catch:{ all -> 0x0038 }
            if (r3 == 0) goto L_0x004a
            boolean r4 = r0.isMulticastAddress()     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x006d
            r3.checkMulticast(r0)     // Catch:{ all -> 0x0038 }
        L_0x004a:
            monitor-exit(r8)     // Catch:{ all -> 0x0024 }
            r2 = 0
            r11.begin()     // Catch:{ all -> 0x00e7 }
            boolean r4 = r11.isOpen()     // Catch:{ all -> 0x00e7 }
            if (r4 != 0) goto L_0x0093
            r4 = 0
            r11.writerThread = r4     // Catch:{ all -> 0x0024 }
            r4 = 0
            r11.end(r4)     // Catch:{ all -> 0x0024 }
            boolean r4 = f121assertionsDisabled     // Catch:{ all -> 0x0024 }
            if (r4 != 0) goto L_0x0091
            boolean r4 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0024 }
            if (r4 != 0) goto L_0x0091
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0024 }
            r4.<init>()     // Catch:{ all -> 0x0024 }
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x006d:
            java.lang.String r4 = r0.getHostAddress()     // Catch:{ all -> 0x0038 }
            int r9 = r1.getPort()     // Catch:{ all -> 0x0038 }
            r3.checkConnect(r4, r9)     // Catch:{ all -> 0x0038 }
            goto L_0x004a
        L_0x0079:
            java.net.InetSocketAddress r4 = r11.remoteAddress     // Catch:{ all -> 0x0038 }
            boolean r4 = r13.equals(r4)     // Catch:{ all -> 0x0038 }
            if (r4 != 0) goto L_0x008a
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0038 }
            java.lang.String r5 = "Connected address not equal to target address"
            r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0038 }
            throw r4     // Catch:{ all -> 0x0038 }
        L_0x008a:
            int r4 = r11.write(r12)     // Catch:{ all -> 0x0038 }
            monitor-exit(r8)     // Catch:{ all -> 0x0024 }
            monitor-exit(r7)
            return r4
        L_0x0091:
            monitor-exit(r7)
            return r6
        L_0x0093:
            long r8 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x00e7 }
            r11.writerThread = r8     // Catch:{ all -> 0x00e7 }
            dalvik.system.BlockGuard$Policy r4 = dalvik.system.BlockGuard.getThreadPolicy()     // Catch:{ all -> 0x00e7 }
            r4.onNetwork()     // Catch:{ all -> 0x00e7 }
        L_0x00a0:
            java.io.FileDescriptor r4 = r11.fd     // Catch:{ all -> 0x00e7 }
            int r2 = r11.send(r4, r12, r1)     // Catch:{ all -> 0x00e7 }
            r4 = -3
            if (r2 != r4) goto L_0x00af
            boolean r4 = r11.isOpen()     // Catch:{ all -> 0x00e7 }
            if (r4 != 0) goto L_0x00a0
        L_0x00af:
            java.lang.Object r8 = r11.stateLock     // Catch:{ all -> 0x00e7 }
            monitor-enter(r8)     // Catch:{ all -> 0x00e7 }
            boolean r4 = r11.isOpen()     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x00c4
            java.net.InetSocketAddress r4 = r11.localAddress     // Catch:{ all -> 0x00e4 }
            if (r4 != 0) goto L_0x00c4
            java.io.FileDescriptor r4 = r11.fd     // Catch:{ all -> 0x00e4 }
            java.net.InetSocketAddress r4 = sun.nio.ch.Net.localAddress(r4)     // Catch:{ all -> 0x00e4 }
            r11.localAddress = r4     // Catch:{ all -> 0x00e4 }
        L_0x00c4:
            monitor-exit(r8)     // Catch:{ all -> 0x00e7 }
            int r4 = sun.nio.ch.IOStatus.normalize((int) r2)     // Catch:{ all -> 0x00e7 }
            r8 = 0
            r11.writerThread = r8     // Catch:{ all -> 0x0024 }
            if (r2 > 0) goto L_0x00d1
            if (r2 != r10) goto L_0x0103
        L_0x00d1:
            r11.end(r5)     // Catch:{ all -> 0x0024 }
            boolean r5 = f121assertionsDisabled     // Catch:{ all -> 0x0024 }
            if (r5 != 0) goto L_0x0105
            boolean r5 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0024 }
            if (r5 != 0) goto L_0x0105
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0024 }
            r4.<init>()     // Catch:{ all -> 0x0024 }
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x00e4:
            r4 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00e7 }
            throw r4     // Catch:{ all -> 0x00e7 }
        L_0x00e7:
            r4 = move-exception
            r8 = 0
            r11.writerThread = r8     // Catch:{ all -> 0x0024 }
            if (r2 > 0) goto L_0x00f0
            if (r2 != r10) goto L_0x0107
        L_0x00f0:
            r11.end(r5)     // Catch:{ all -> 0x0024 }
            boolean r5 = f121assertionsDisabled     // Catch:{ all -> 0x0024 }
            if (r5 != 0) goto L_0x0109
            boolean r5 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0024 }
            if (r5 != 0) goto L_0x0109
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0024 }
            r4.<init>()     // Catch:{ all -> 0x0024 }
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x0103:
            r5 = r6
            goto L_0x00d1
        L_0x0105:
            monitor-exit(r7)
            return r4
        L_0x0107:
            r5 = r6
            goto L_0x00f0
        L_0x0109:
            throw r4     // Catch:{ all -> 0x0024 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.send(java.nio.ByteBuffer, java.net.SocketAddress):int");
    }

    private int send(FileDescriptor fd2, ByteBuffer src, InetSocketAddress target) throws IOException {
        int rem = 0;
        if (src instanceof DirectBuffer) {
            return sendFromNativeBuffer(fd2, src, target);
        }
        int pos = src.position();
        int lim = src.limit();
        if (!f121assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        if (pos <= lim) {
            rem = lim - pos;
        }
        ByteBuffer bb = Util.getTemporaryDirectBuffer(rem);
        try {
            bb.put(src);
            bb.flip();
            src.position(pos);
            int n = sendFromNativeBuffer(fd2, bb, target);
            if (n > 0) {
                src.position(pos + n);
            }
            return n;
        } finally {
            Util.releaseTemporaryDirectBuffer(bb);
        }
    }

    private int sendFromNativeBuffer(FileDescriptor fd2, ByteBuffer bb, InetSocketAddress target) throws IOException {
        int written;
        int pos = bb.position();
        int lim = bb.limit();
        if (!f121assertionsDisabled) {
            if (!(pos <= lim ? true : f121assertionsDisabled)) {
                throw new AssertionError();
            }
        }
        int rem = pos <= lim ? lim - pos : 0;
        try {
            written = send0(this.family != StandardProtocolFamily.INET ? true : f121assertionsDisabled, fd2, ((DirectBuffer) bb).address() + ((long) pos), rem, target.getAddress(), target.getPort());
        } catch (PortUnreachableException pue) {
            if (isConnected()) {
                throw pue;
            }
            written = rem;
        }
        if (written > 0) {
            bb.position(pos + written);
        }
        return written;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004a, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0086, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(java.nio.ByteBuffer r10) throws java.io.IOException {
        /*
            r9 = this;
            r8 = -2
            r2 = 1
            r3 = 0
            if (r10 != 0) goto L_0x000b
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r1.<init>()
            throw r1
        L_0x000b:
            java.lang.Object r4 = r9.readLock
            monitor-enter(r4)
            java.lang.Object r5 = r9.stateLock     // Catch:{ all -> 0x0023 }
            monitor-enter(r5)     // Catch:{ all -> 0x0023 }
            r9.ensureOpen()     // Catch:{ all -> 0x0020 }
            boolean r1 = r9.isConnected()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0026
            java.nio.channels.NotYetConnectedException r1 = new java.nio.channels.NotYetConnectedException     // Catch:{ all -> 0x0020 }
            r1.<init>()     // Catch:{ all -> 0x0020 }
            throw r1     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            monitor-exit(r4)
            throw r1
        L_0x0026:
            monitor-exit(r5)     // Catch:{ all -> 0x0023 }
            r0 = 0
            r9.begin()     // Catch:{ all -> 0x0087 }
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x004b
            r6 = 0
            r9.readerThread = r6     // Catch:{ all -> 0x0023 }
            r1 = 0
            r9.end(r1)     // Catch:{ all -> 0x0023 }
            boolean r1 = f121assertionsDisabled     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0049
            boolean r1 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0049
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0049:
            monitor-exit(r4)
            return r3
        L_0x004b:
            long r6 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x0087 }
            r9.readerThread = r6     // Catch:{ all -> 0x0087 }
        L_0x0051:
            java.io.FileDescriptor r1 = r9.fd     // Catch:{ all -> 0x0087 }
            r6 = -1
            sun.nio.ch.NativeDispatcher r5 = nd     // Catch:{ all -> 0x0087 }
            int r0 = sun.nio.ch.IOUtil.read(r1, r10, r6, r5)     // Catch:{ all -> 0x0087 }
            r1 = -3
            if (r0 != r1) goto L_0x0064
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x0051
        L_0x0064:
            int r1 = sun.nio.ch.IOStatus.normalize((int) r0)     // Catch:{ all -> 0x0087 }
            r6 = 0
            r9.readerThread = r6     // Catch:{ all -> 0x0023 }
            if (r0 > 0) goto L_0x0070
            if (r0 != r8) goto L_0x0083
        L_0x0070:
            r9.end(r2)     // Catch:{ all -> 0x0023 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0085
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0085
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0083:
            r2 = r3
            goto L_0x0070
        L_0x0085:
            monitor-exit(r4)
            return r1
        L_0x0087:
            r1 = move-exception
            r6 = 0
            r9.readerThread = r6     // Catch:{ all -> 0x0023 }
            if (r0 > 0) goto L_0x0090
            if (r0 != r8) goto L_0x00a3
        L_0x0090:
            r9.end(r2)     // Catch:{ all -> 0x0023 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x00a5
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x00a5
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x00a3:
            r2 = r3
            goto L_0x0090
        L_0x00a5:
            throw r1     // Catch:{ all -> 0x0023 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.read(java.nio.ByteBuffer):int");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0096, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(java.nio.ByteBuffer[] r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            if (r10 < 0) goto L_0x0004
            if (r11 >= 0) goto L_0x000a
        L_0x0004:
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException
            r2.<init>()
            throw r2
        L_0x000a:
            int r2 = r9.length
            int r2 = r2 - r11
            if (r10 > r2) goto L_0x0004
            java.lang.Object r4 = r8.readLock
            monitor-enter(r4)
            java.lang.Object r3 = r8.stateLock     // Catch:{ all -> 0x0026 }
            monitor-enter(r3)     // Catch:{ all -> 0x0026 }
            r8.ensureOpen()     // Catch:{ all -> 0x0023 }
            boolean r2 = r8.isConnected()     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0029
            java.nio.channels.NotYetConnectedException r2 = new java.nio.channels.NotYetConnectedException     // Catch:{ all -> 0x0023 }
            r2.<init>()     // Catch:{ all -> 0x0023 }
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r2 = move-exception
            monitor-exit(r4)
            throw r2
        L_0x0029:
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            r0 = 0
            r8.begin()     // Catch:{ all -> 0x0097 }
            boolean r2 = r8.isOpen()     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x0051
            r2 = 0
            r8.readerThread = r2     // Catch:{ all -> 0x0026 }
            r2 = 0
            r8.end(r2)     // Catch:{ all -> 0x0026 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x004d
            boolean r2 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x004d
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x004d:
            r2 = 0
            monitor-exit(r4)
            return r2
        L_0x0051:
            long r2 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x0097 }
            r8.readerThread = r2     // Catch:{ all -> 0x0097 }
        L_0x0057:
            java.io.FileDescriptor r2 = r8.fd     // Catch:{ all -> 0x0097 }
            sun.nio.ch.NativeDispatcher r3 = nd     // Catch:{ all -> 0x0097 }
            long r0 = sun.nio.ch.IOUtil.read(r2, r9, r10, r11, r3)     // Catch:{ all -> 0x0097 }
            r2 = -3
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x006b
            boolean r2 = r8.isOpen()     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x0057
        L_0x006b:
            long r6 = sun.nio.ch.IOStatus.normalize((long) r0)     // Catch:{ all -> 0x0097 }
            r2 = 0
            r8.readerThread = r2     // Catch:{ all -> 0x0026 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x007f
            r2 = -2
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0093
        L_0x007f:
            r2 = 1
        L_0x0080:
            r8.end(r2)     // Catch:{ all -> 0x0026 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x0095
            boolean r2 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x0095
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x0093:
            r2 = 0
            goto L_0x0080
        L_0x0095:
            monitor-exit(r4)
            return r6
        L_0x0097:
            r2 = move-exception
            r6 = 0
            r8.readerThread = r6     // Catch:{ all -> 0x0026 }
            r6 = 0
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x00a8
            r6 = -2
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x00bc
        L_0x00a8:
            r3 = 1
        L_0x00a9:
            r8.end(r3)     // Catch:{ all -> 0x0026 }
            boolean r3 = f121assertionsDisabled     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x00be
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x00be
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x00bc:
            r3 = 0
            goto L_0x00a9
        L_0x00be:
            throw r2     // Catch:{ all -> 0x0026 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.read(java.nio.ByteBuffer[], int, int):long");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004a, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0086, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int write(java.nio.ByteBuffer r10) throws java.io.IOException {
        /*
            r9 = this;
            r8 = -2
            r2 = 1
            r3 = 0
            if (r10 != 0) goto L_0x000b
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r1.<init>()
            throw r1
        L_0x000b:
            java.lang.Object r4 = r9.writeLock
            monitor-enter(r4)
            java.lang.Object r5 = r9.stateLock     // Catch:{ all -> 0x0023 }
            monitor-enter(r5)     // Catch:{ all -> 0x0023 }
            r9.ensureOpen()     // Catch:{ all -> 0x0020 }
            boolean r1 = r9.isConnected()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0026
            java.nio.channels.NotYetConnectedException r1 = new java.nio.channels.NotYetConnectedException     // Catch:{ all -> 0x0020 }
            r1.<init>()     // Catch:{ all -> 0x0020 }
            throw r1     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            monitor-exit(r4)
            throw r1
        L_0x0026:
            monitor-exit(r5)     // Catch:{ all -> 0x0023 }
            r0 = 0
            r9.begin()     // Catch:{ all -> 0x0087 }
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x004b
            r6 = 0
            r9.writerThread = r6     // Catch:{ all -> 0x0023 }
            r1 = 0
            r9.end(r1)     // Catch:{ all -> 0x0023 }
            boolean r1 = f121assertionsDisabled     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0049
            boolean r1 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0049
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0049:
            monitor-exit(r4)
            return r3
        L_0x004b:
            long r6 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x0087 }
            r9.writerThread = r6     // Catch:{ all -> 0x0087 }
        L_0x0051:
            java.io.FileDescriptor r1 = r9.fd     // Catch:{ all -> 0x0087 }
            r6 = -1
            sun.nio.ch.NativeDispatcher r5 = nd     // Catch:{ all -> 0x0087 }
            int r0 = sun.nio.ch.IOUtil.write(r1, r10, r6, r5)     // Catch:{ all -> 0x0087 }
            r1 = -3
            if (r0 != r1) goto L_0x0064
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x0051
        L_0x0064:
            int r1 = sun.nio.ch.IOStatus.normalize((int) r0)     // Catch:{ all -> 0x0087 }
            r6 = 0
            r9.writerThread = r6     // Catch:{ all -> 0x0023 }
            if (r0 > 0) goto L_0x0070
            if (r0 != r8) goto L_0x0083
        L_0x0070:
            r9.end(r2)     // Catch:{ all -> 0x0023 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0085
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0085
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0083:
            r2 = r3
            goto L_0x0070
        L_0x0085:
            monitor-exit(r4)
            return r1
        L_0x0087:
            r1 = move-exception
            r6 = 0
            r9.writerThread = r6     // Catch:{ all -> 0x0023 }
            if (r0 > 0) goto L_0x0090
            if (r0 != r8) goto L_0x00a3
        L_0x0090:
            r9.end(r2)     // Catch:{ all -> 0x0023 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x00a5
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x00a5
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x00a3:
            r2 = r3
            goto L_0x0090
        L_0x00a5:
            throw r1     // Catch:{ all -> 0x0023 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.write(java.nio.ByteBuffer):int");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0096, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long write(java.nio.ByteBuffer[] r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            if (r10 < 0) goto L_0x0004
            if (r11 >= 0) goto L_0x000a
        L_0x0004:
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException
            r2.<init>()
            throw r2
        L_0x000a:
            int r2 = r9.length
            int r2 = r2 - r11
            if (r10 > r2) goto L_0x0004
            java.lang.Object r4 = r8.writeLock
            monitor-enter(r4)
            java.lang.Object r3 = r8.stateLock     // Catch:{ all -> 0x0026 }
            monitor-enter(r3)     // Catch:{ all -> 0x0026 }
            r8.ensureOpen()     // Catch:{ all -> 0x0023 }
            boolean r2 = r8.isConnected()     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0029
            java.nio.channels.NotYetConnectedException r2 = new java.nio.channels.NotYetConnectedException     // Catch:{ all -> 0x0023 }
            r2.<init>()     // Catch:{ all -> 0x0023 }
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r2 = move-exception
            monitor-exit(r4)
            throw r2
        L_0x0029:
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            r0 = 0
            r8.begin()     // Catch:{ all -> 0x0097 }
            boolean r2 = r8.isOpen()     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x0051
            r2 = 0
            r8.writerThread = r2     // Catch:{ all -> 0x0026 }
            r2 = 0
            r8.end(r2)     // Catch:{ all -> 0x0026 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x004d
            boolean r2 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x004d
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x004d:
            r2 = 0
            monitor-exit(r4)
            return r2
        L_0x0051:
            long r2 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x0097 }
            r8.writerThread = r2     // Catch:{ all -> 0x0097 }
        L_0x0057:
            java.io.FileDescriptor r2 = r8.fd     // Catch:{ all -> 0x0097 }
            sun.nio.ch.NativeDispatcher r3 = nd     // Catch:{ all -> 0x0097 }
            long r0 = sun.nio.ch.IOUtil.write(r2, r9, r10, r11, r3)     // Catch:{ all -> 0x0097 }
            r2 = -3
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x006b
            boolean r2 = r8.isOpen()     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x0057
        L_0x006b:
            long r6 = sun.nio.ch.IOStatus.normalize((long) r0)     // Catch:{ all -> 0x0097 }
            r2 = 0
            r8.writerThread = r2     // Catch:{ all -> 0x0026 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x007f
            r2 = -2
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0093
        L_0x007f:
            r2 = 1
        L_0x0080:
            r8.end(r2)     // Catch:{ all -> 0x0026 }
            boolean r2 = f121assertionsDisabled     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x0095
            boolean r2 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x0095
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x0093:
            r2 = 0
            goto L_0x0080
        L_0x0095:
            monitor-exit(r4)
            return r6
        L_0x0097:
            r2 = move-exception
            r6 = 0
            r8.writerThread = r6     // Catch:{ all -> 0x0026 }
            r6 = 0
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x00a8
            r6 = -2
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x00bc
        L_0x00a8:
            r3 = 1
        L_0x00a9:
            r8.end(r3)     // Catch:{ all -> 0x0026 }
            boolean r3 = f121assertionsDisabled     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x00be
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x00be
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x00bc:
            r3 = 0
            goto L_0x00a9
        L_0x00be:
            throw r2     // Catch:{ all -> 0x0026 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.write(java.nio.ByteBuffer[], int, int):long");
    }

    /* access modifiers changed from: protected */
    public void implConfigureBlocking(boolean block) throws IOException {
        IOUtil.configureBlocking(this.fd, block);
    }

    public SocketAddress localAddress() {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            inetSocketAddress = this.localAddress;
        }
        return inetSocketAddress;
    }

    public SocketAddress remoteAddress() {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            inetSocketAddress = this.remoteAddress;
        }
        return inetSocketAddress;
    }

    public DatagramChannel bind(SocketAddress local) throws IOException {
        InetSocketAddress isa;
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    ensureOpen();
                    if (this.localAddress != null) {
                        throw new AlreadyBoundException();
                    }
                    if (local == null) {
                        isa = this.family == StandardProtocolFamily.INET ? new InetSocketAddress(InetAddress.getByName("0.0.0.0"), 0) : new InetSocketAddress(0);
                    } else {
                        isa = Net.checkAddress(local);
                        if (this.family == StandardProtocolFamily.INET && !(isa.getAddress() instanceof Inet4Address)) {
                            throw new UnsupportedAddressTypeException();
                        }
                    }
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkListen(isa.getPort());
                    }
                    Net.bind(this.family, this.fd, isa.getAddress(), isa.getPort());
                    this.localAddress = Net.localAddress(this.fd);
                }
            }
        }
        return this;
    }

    public boolean isConnected() {
        boolean z = true;
        synchronized (this.stateLock) {
            if (this.state != 1) {
                z = f121assertionsDisabled;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void ensureOpenAndUnconnected() throws IOException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (this.state != 0) {
                throw new IllegalStateException("Connect already invoked");
            }
        }
    }

    public DatagramChannel connect(SocketAddress sa) throws IOException {
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    ensureOpenAndUnconnected();
                    InetSocketAddress isa = Net.checkAddress(sa);
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkConnect(isa.getAddress().getHostAddress(), isa.getPort());
                    }
                    if (Net.connect(this.family, this.fd, isa.getAddress(), isa.getPort()) <= 0) {
                        throw new Error();
                    }
                    this.state = 1;
                    this.remoteAddress = isa;
                    this.sender = isa;
                    this.cachedSenderInetAddress = isa.getAddress();
                    this.cachedSenderPort = isa.getPort();
                    this.localAddress = Net.localAddress(this.fd);
                }
            }
        }
        return this;
    }

    public DatagramChannel disconnect() throws IOException {
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    if (!isConnected() || !isOpen()) {
                        return this;
                    }
                    InetSocketAddress isa = this.remoteAddress;
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkConnect(isa.getAddress().getHostAddress(), isa.getPort());
                    }
                    disconnect0(this.fd, this.family == StandardProtocolFamily.INET6 ? true : f121assertionsDisabled);
                    this.remoteAddress = null;
                    this.state = 0;
                    this.localAddress = Net.localAddress(this.fd);
                    return this;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void implCloseSelectableChannel() throws IOException {
        synchronized (this.stateLock) {
            if (this.state != 2) {
                nd.preClose(this.fd);
            }
            ResourceManager.afterUdpClose();
            long th = this.readerThread;
            if (th != 0) {
                NativeThread.signal(th);
            }
            long th2 = this.writerThread;
            if (th2 != 0) {
                NativeThread.signal(th2);
            }
            if (!isRegistered()) {
                kill();
            }
        }
    }

    public void kill() throws IOException {
        boolean z = f121assertionsDisabled;
        synchronized (this.stateLock) {
            if (this.state != 2) {
                if (this.state == -1) {
                    this.state = 2;
                    return;
                }
                if (!f121assertionsDisabled) {
                    if (!isOpen() && !isRegistered()) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                nd.close(this.fd);
                this.state = 2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws IOException {
        if (this.fd != null) {
            close();
        }
    }

    public boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
        int intOps = sk.nioInterestOps();
        int oldOps = sk.nioReadyOps();
        int newOps = initialOps;
        if ((ops & 32) != 0) {
            return f121assertionsDisabled;
        }
        if ((ops & 24) != 0) {
            int newOps2 = intOps;
            sk.nioReadyOps(intOps);
            if (((~oldOps) & intOps) != 0) {
                return true;
            }
            return f121assertionsDisabled;
        }
        if (!((ops & 1) == 0 || (intOps & 1) == 0)) {
            newOps = initialOps | 1;
        }
        if (!((ops & 4) == 0 || (intOps & 4) == 0)) {
            newOps |= 4;
        }
        sk.nioReadyOps(newOps);
        if (((~oldOps) & newOps) != 0) {
            return true;
        }
        return f121assertionsDisabled;
    }

    public boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, sk.nioReadyOps(), sk);
    }

    public boolean translateAndSetReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, 0, sk);
    }

    public void translateAndSetInterestOps(int ops, SelectionKeyImpl sk) {
        int newOps = 0;
        if ((ops & 1) != 0) {
            newOps = 1;
        }
        if ((ops & 4) != 0) {
            newOps |= 4;
        }
        if ((ops & 8) != 0) {
            newOps |= 1;
        }
        sk.selector.putEventOps(sk, newOps);
    }

    public FileDescriptor getFD() {
        return this.fd;
    }

    public int getFDVal() {
        return this.fdVal;
    }
}
