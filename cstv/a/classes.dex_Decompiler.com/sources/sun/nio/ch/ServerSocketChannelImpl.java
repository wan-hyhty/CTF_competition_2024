package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;
import sun.net.NetHooks;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class ServerSocketChannelImpl extends ServerSocketChannel implements SelChImpl {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f131assertionsDisabled = false;
    private static final int ST_INUSE = 0;
    private static final int ST_KILLED = 1;
    private static final int ST_UNINITIALIZED = -1;
    private static NativeDispatcher nd;
    private final FileDescriptor fd;
    private int fdVal;
    private boolean isReuseAddress;
    private InetSocketAddress localAddress;
    private final Object lock;
    ServerSocket socket;
    private int state;
    private final Object stateLock;
    private volatile long thread;

    private static class DefaultOptionsHolder {
        static final Set<SocketOption<?>> defaultOptions = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.ServerSocketChannelImpl.DefaultOptionsHolder.<init>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.ServerSocketChannelImpl.DefaultOptionsHolder.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.ServerSocketChannelImpl.DefaultOptionsHolder.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.ServerSocketChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set<java.net.SocketOption<?>>, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.ServerSocketChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set<java.net.SocketOption<?>>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.ServerSocketChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set");
        }
    }

    private native int accept0(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, InetSocketAddress[] inetSocketAddressArr) throws IOException;

    private static native void initIDs();

    ServerSocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.thread = 0;
        this.lock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.fd = Net.serverSocket(true);
        this.fdVal = IOUtil.fdVal(this.fd);
        this.state = 0;
    }

    ServerSocketChannelImpl(SelectorProvider sp, FileDescriptor fd2, boolean bound) throws IOException {
        super(sp);
        this.thread = 0;
        this.lock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 0;
        if (bound) {
            this.localAddress = Net.localAddress(fd2);
        }
    }

    public ServerSocket socket() {
        ServerSocket serverSocket;
        synchronized (this.stateLock) {
            if (this.socket == null) {
                this.socket = ServerSocketAdaptor.create(this);
            }
            serverSocket = this.socket;
        }
        return serverSocket;
    }

    public SocketAddress getLocalAddress() throws IOException {
        InetSocketAddress revealedLocalAddress;
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (this.localAddress == null) {
                revealedLocalAddress = this.localAddress;
            } else {
                revealedLocalAddress = Net.getRevealedLocalAddress(Net.asInetSocketAddress(this.localAddress));
            }
        }
        return revealedLocalAddress;
    }

    public <T> ServerSocketChannel setOption(SocketOption<T> name, T value) throws IOException {
        if (name == null) {
            throw new NullPointerException();
        } else if (!supportedOptions().contains(name)) {
            throw new UnsupportedOperationException("'" + name + "' not supported");
        } else {
            synchronized (this.stateLock) {
                if (!isOpen()) {
                    throw new ClosedChannelException();
                } else if (name != StandardSocketOptions.SO_REUSEADDR || !Net.useExclusiveBind()) {
                    Net.setSocketOption(this.fd, Net.UNSPEC, name, value);
                } else {
                    this.isReuseAddress = ((Boolean) value).booleanValue();
                }
            }
            return this;
        }
    }

    public <T> T getOption(SocketOption<T> name) throws IOException {
        if (name == null) {
            throw new NullPointerException();
        } else if (!supportedOptions().contains(name)) {
            throw new UnsupportedOperationException("'" + name + "' not supported");
        } else {
            synchronized (this.stateLock) {
                if (!isOpen()) {
                    throw new ClosedChannelException();
                } else if (name != StandardSocketOptions.SO_REUSEADDR || !Net.useExclusiveBind()) {
                    T socketOption = Net.getSocketOption(this.fd, Net.UNSPEC, name);
                    return socketOption;
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

    public boolean isBound() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.localAddress != null ? true : f131assertionsDisabled;
        }
        return z;
    }

    public InetSocketAddress localAddress() {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            inetSocketAddress = this.localAddress;
        }
        return inetSocketAddress;
    }

    public ServerSocketChannel bind(SocketAddress local, int backlog) throws IOException {
        InetSocketAddress isa;
        synchronized (this.lock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (isBound()) {
                throw new AlreadyBoundException();
            } else {
                if (local == null) {
                    isa = new InetSocketAddress(0);
                } else {
                    isa = Net.checkAddress(local);
                }
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    sm.checkListen(isa.getPort());
                }
                NetHooks.beforeTcpBind(this.fd, isa.getAddress(), isa.getPort());
                Net.bind(this.fd, isa.getAddress(), isa.getPort());
                FileDescriptor fileDescriptor = this.fd;
                if (backlog < 1) {
                    backlog = 50;
                }
                Net.listen(fileDescriptor, backlog);
                synchronized (this.stateLock) {
                    this.localAddress = Net.localAddress(this.fd);
                }
            }
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c4, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.channels.SocketChannel accept() throws java.io.IOException {
        /*
            r14 = this;
            r11 = 0
            r8 = 1
            r9 = 0
            java.lang.Object r10 = r14.lock
            monitor-enter(r10)
            boolean r7 = r14.isOpen()     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x0015
            java.nio.channels.ClosedChannelException r7 = new java.nio.channels.ClosedChannelException     // Catch:{ all -> 0x0012 }
            r7.<init>()     // Catch:{ all -> 0x0012 }
            throw r7     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r7 = move-exception
            monitor-exit(r10)
            throw r7
        L_0x0015:
            boolean r7 = r14.isBound()     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x0021
            java.nio.channels.NotYetBoundException r7 = new java.nio.channels.NotYetBoundException     // Catch:{ all -> 0x0012 }
            r7.<init>()     // Catch:{ all -> 0x0012 }
            throw r7     // Catch:{ all -> 0x0012 }
        L_0x0021:
            r4 = 0
            r2 = 0
            java.io.FileDescriptor r3 = new java.io.FileDescriptor     // Catch:{ all -> 0x0012 }
            r3.<init>()     // Catch:{ all -> 0x0012 }
            r7 = 1
            java.net.InetSocketAddress[] r1 = new java.net.InetSocketAddress[r7]     // Catch:{ all -> 0x0012 }
            r14.begin()     // Catch:{ all -> 0x007d }
            boolean r7 = r14.isOpen()     // Catch:{ all -> 0x007d }
            if (r7 != 0) goto L_0x004e
            r8 = 0
            r14.thread = r8     // Catch:{ all -> 0x0012 }
            r7 = 0
            r14.end(r7)     // Catch:{ all -> 0x0012 }
            boolean r7 = f131assertionsDisabled     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x004c
            boolean r7 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x004c
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x0012 }
            r7.<init>()     // Catch:{ all -> 0x0012 }
            throw r7     // Catch:{ all -> 0x0012 }
        L_0x004c:
            monitor-exit(r10)
            return r11
        L_0x004e:
            long r12 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x007d }
            r14.thread = r12     // Catch:{ all -> 0x007d }
        L_0x0054:
            java.io.FileDescriptor r7 = r14.fd     // Catch:{ all -> 0x007d }
            int r2 = r14.accept0(r7, r3, r1)     // Catch:{ all -> 0x007d }
            r7 = -3
            if (r2 != r7) goto L_0x0063
            boolean r7 = r14.isOpen()     // Catch:{ all -> 0x007d }
            if (r7 != 0) goto L_0x0054
        L_0x0063:
            r12 = 0
            r14.thread = r12     // Catch:{ all -> 0x0012 }
            if (r2 <= 0) goto L_0x006a
            r9 = r8
        L_0x006a:
            r14.end(r9)     // Catch:{ all -> 0x0012 }
            boolean r7 = f131assertionsDisabled     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x009a
            boolean r7 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x009a
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x0012 }
            r7.<init>()     // Catch:{ all -> 0x0012 }
            throw r7     // Catch:{ all -> 0x0012 }
        L_0x007d:
            r7 = move-exception
            r12 = 0
            r14.thread = r12     // Catch:{ all -> 0x0012 }
            if (r2 <= 0) goto L_0x0097
        L_0x0084:
            r14.end(r8)     // Catch:{ all -> 0x0012 }
            boolean r8 = f131assertionsDisabled     // Catch:{ all -> 0x0012 }
            if (r8 != 0) goto L_0x0099
            boolean r8 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x0012 }
            if (r8 != 0) goto L_0x0099
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x0012 }
            r7.<init>()     // Catch:{ all -> 0x0012 }
            throw r7     // Catch:{ all -> 0x0012 }
        L_0x0097:
            r8 = r9
            goto L_0x0084
        L_0x0099:
            throw r7     // Catch:{ all -> 0x0012 }
        L_0x009a:
            if (r2 >= r8) goto L_0x009e
            monitor-exit(r10)
            return r11
        L_0x009e:
            r7 = 1
            sun.nio.ch.IOUtil.configureBlocking(r3, r7)     // Catch:{ all -> 0x0012 }
            r7 = 0
            r0 = r1[r7]     // Catch:{ all -> 0x0012 }
            sun.nio.ch.SocketChannelImpl r4 = new sun.nio.ch.SocketChannelImpl     // Catch:{ all -> 0x0012 }
            java.nio.channels.spi.SelectorProvider r7 = r14.provider()     // Catch:{ all -> 0x0012 }
            r4.<init>((java.nio.channels.spi.SelectorProvider) r7, (java.io.FileDescriptor) r3, (java.net.InetSocketAddress) r0)     // Catch:{ all -> 0x0012 }
            java.lang.SecurityManager r5 = java.lang.System.getSecurityManager()     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x00c3
            java.net.InetAddress r7 = r0.getAddress()     // Catch:{ SecurityException -> 0x00c5 }
            java.lang.String r7 = r7.getHostAddress()     // Catch:{ SecurityException -> 0x00c5 }
            int r8 = r0.getPort()     // Catch:{ SecurityException -> 0x00c5 }
            r5.checkAccept(r7, r8)     // Catch:{ SecurityException -> 0x00c5 }
        L_0x00c3:
            monitor-exit(r10)
            return r4
        L_0x00c5:
            r6 = move-exception
            r4.close()     // Catch:{ all -> 0x0012 }
            throw r6     // Catch:{ all -> 0x0012 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.ServerSocketChannelImpl.accept():java.nio.channels.SocketChannel");
    }

    /* access modifiers changed from: protected */
    public void implConfigureBlocking(boolean block) throws IOException {
        IOUtil.configureBlocking(this.fd, block);
    }

    /* access modifiers changed from: protected */
    public void implCloseSelectableChannel() throws IOException {
        synchronized (this.stateLock) {
            if (this.state != 1) {
                nd.preClose(this.fd);
            }
            long th = this.thread;
            if (th != 0) {
                NativeThread.signal(th);
            }
            if (!isRegistered()) {
                kill();
            }
        }
    }

    public void kill() throws IOException {
        boolean z = f131assertionsDisabled;
        synchronized (this.stateLock) {
            if (this.state != 1) {
                if (this.state == -1) {
                    this.state = 1;
                    return;
                }
                if (!f131assertionsDisabled) {
                    if (!isOpen() && !isRegistered()) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                nd.close(this.fd);
                this.state = 1;
            }
        }
    }

    public boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
        int intOps = sk.nioInterestOps();
        int oldOps = sk.nioReadyOps();
        int newOps = initialOps;
        if ((ops & 32) != 0) {
            return f131assertionsDisabled;
        }
        if ((ops & 24) != 0) {
            int newOps2 = intOps;
            sk.nioReadyOps(intOps);
            if (((~oldOps) & intOps) != 0) {
                return true;
            }
            return f131assertionsDisabled;
        }
        if (!((ops & 1) == 0 || (intOps & 16) == 0)) {
            newOps = initialOps | 16;
        }
        sk.nioReadyOps(newOps);
        if (((~oldOps) & newOps) != 0) {
            return true;
        }
        return f131assertionsDisabled;
    }

    public boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, sk.nioReadyOps(), sk);
    }

    public boolean translateAndSetReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, 0, sk);
    }

    public void translateAndSetInterestOps(int ops, SelectionKeyImpl sk) {
        int newOps = 0;
        if ((ops & 16) != 0) {
            newOps = 1;
        }
        sk.selector.putEventOps(sk, newOps);
    }

    public FileDescriptor getFD() {
        return this.fd;
    }

    public int getFDVal() {
        return this.fdVal;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(getClass().getName());
        sb.append('[');
        if (!isOpen()) {
            sb.append("closed");
        } else {
            synchronized (this.stateLock) {
                InetSocketAddress addr = localAddress();
                if (addr == null) {
                    sb.append("unbound");
                } else {
                    sb.append(Net.getRevealedLocalAddressAsString(addr));
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
