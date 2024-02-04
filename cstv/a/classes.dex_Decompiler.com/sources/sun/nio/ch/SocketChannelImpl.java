package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
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
class SocketChannelImpl extends SocketChannel implements SelChImpl {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f135assertionsDisabled = false;
    private static final int ST_CONNECTED = 2;
    private static final int ST_KILLED = 4;
    private static final int ST_KILLPENDING = 3;
    private static final int ST_PENDING = 1;
    private static final int ST_UNCONNECTED = 0;
    private static final int ST_UNINITIALIZED = -1;
    private static NativeDispatcher nd;
    private final FileDescriptor fd;
    private final int fdVal;
    private boolean isInputOpen;
    private boolean isOutputOpen;
    private boolean isReuseAddress;
    private InetSocketAddress localAddress;
    private final Object readLock;
    private volatile long readerThread;
    private boolean readyToConnect;
    private InetSocketAddress remoteAddress;
    private Socket socket;
    private int state;
    private final Object stateLock;
    private final Object writeLock;
    private volatile long writerThread;

    private static class DefaultOptionsHolder {
        static final Set<SocketOption<?>> defaultOptions = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.SocketChannelImpl.DefaultOptionsHolder.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private DefaultOptionsHolder() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.SocketChannelImpl.DefaultOptionsHolder.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.DefaultOptionsHolder.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.SocketChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set<java.net.SocketOption<?>>, dex: classes.dex
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
        private static java.util.Set<java.net.SocketOption<?>> defaultOptions() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.SocketChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set<java.net.SocketOption<?>>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.DefaultOptionsHolder.defaultOptions():java.util.Set");
        }
    }

    private static native int checkConnect(FileDescriptor fileDescriptor, boolean z, boolean z2) throws IOException;

    private static native int sendOutOfBandData(FileDescriptor fileDescriptor, byte b) throws IOException;

    SocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.readerThread = 0;
        this.writerThread = 0;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.isInputOpen = true;
        this.isOutputOpen = true;
        this.readyToConnect = f135assertionsDisabled;
        this.fd = Net.socket(true);
        this.fdVal = IOUtil.fdVal(this.fd);
        this.state = 0;
    }

    SocketChannelImpl(SelectorProvider sp, FileDescriptor fd2, boolean bound) throws IOException {
        super(sp);
        this.readerThread = 0;
        this.writerThread = 0;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.isInputOpen = true;
        this.isOutputOpen = true;
        this.readyToConnect = f135assertionsDisabled;
        this.fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 0;
        if (bound) {
            this.localAddress = Net.localAddress(fd2);
        }
    }

    SocketChannelImpl(SelectorProvider sp, FileDescriptor fd2, InetSocketAddress remote) throws IOException {
        super(sp);
        this.readerThread = 0;
        this.writerThread = 0;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.isInputOpen = true;
        this.isOutputOpen = true;
        this.readyToConnect = f135assertionsDisabled;
        this.fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 2;
        this.localAddress = Net.localAddress(fd2);
        this.remoteAddress = remote;
    }

    public Socket socket() {
        Socket socket2;
        synchronized (this.stateLock) {
            if (this.socket == null) {
                this.socket = SocketAdaptor.create(this);
            }
            socket2 = this.socket;
        }
        return socket2;
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

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.nio.channels.SocketChannel setOption(java.net.SocketOption<T> r4, T r5) throws java.io.IOException {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0008
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0008:
            java.util.Set r0 = r3.supportedOptions()
            boolean r0 = r0.contains(r4)
            if (r0 != 0) goto L_0x0033
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "'"
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r2)
            java.lang.StringBuilder r1 = r1.append((java.lang.Object) r4)
            java.lang.String r2 = "' not supported"
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0033:
            java.lang.Object r1 = r3.stateLock
            monitor-enter(r1)
            boolean r0 = r3.isOpen()     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0045
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException     // Catch:{ all -> 0x0042 }
            r0.<init>()     // Catch:{ all -> 0x0042 }
            throw r0     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0045:
            java.net.SocketOption<java.lang.Integer> r0 = java.net.StandardSocketOptions.IP_TOS     // Catch:{ all -> 0x0042 }
            if (r4 != r0) goto L_0x0058
            boolean r0 = sun.nio.ch.Net.isIPv6Available()     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0056
            java.io.FileDescriptor r0 = r3.fd     // Catch:{ all -> 0x0042 }
            java.net.StandardProtocolFamily r2 = java.net.StandardProtocolFamily.INET     // Catch:{ all -> 0x0042 }
            sun.nio.ch.Net.setSocketOption(r0, r2, r4, r5)     // Catch:{ all -> 0x0042 }
        L_0x0056:
            monitor-exit(r1)
            return r3
        L_0x0058:
            java.net.SocketOption<java.lang.Boolean> r0 = java.net.StandardSocketOptions.SO_REUSEADDR     // Catch:{ all -> 0x0042 }
            if (r4 != r0) goto L_0x006c
            boolean r0 = sun.nio.ch.Net.useExclusiveBind()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x006c
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0042 }
            boolean r0 = r5.booleanValue()     // Catch:{ all -> 0x0042 }
            r3.isReuseAddress = r0     // Catch:{ all -> 0x0042 }
            monitor-exit(r1)
            return r3
        L_0x006c:
            java.io.FileDescriptor r0 = r3.fd     // Catch:{ all -> 0x0042 }
            java.net.ProtocolFamily r2 = sun.nio.ch.Net.UNSPEC     // Catch:{ all -> 0x0042 }
            sun.nio.ch.Net.setSocketOption(r0, r2, r4, r5)     // Catch:{ all -> 0x0042 }
            monitor-exit(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.setOption(java.net.SocketOption, java.lang.Object):java.nio.channels.SocketChannel");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0067, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getOption(java.net.SocketOption<T> r4) throws java.io.IOException {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0008
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0008:
            java.util.Set r0 = r3.supportedOptions()
            boolean r0 = r0.contains(r4)
            if (r0 != 0) goto L_0x0033
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "'"
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r2)
            java.lang.StringBuilder r1 = r1.append((java.lang.Object) r4)
            java.lang.String r2 = "' not supported"
            java.lang.StringBuilder r1 = r1.append((java.lang.String) r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0033:
            java.lang.Object r1 = r3.stateLock
            monitor-enter(r1)
            boolean r0 = r3.isOpen()     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0045
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException     // Catch:{ all -> 0x0042 }
            r0.<init>()     // Catch:{ all -> 0x0042 }
            throw r0     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0045:
            java.net.SocketOption<java.lang.Boolean> r0 = java.net.StandardSocketOptions.SO_REUSEADDR     // Catch:{ all -> 0x0042 }
            if (r4 != r0) goto L_0x0057
            boolean r0 = sun.nio.ch.Net.useExclusiveBind()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0057
            boolean r0 = r3.isReuseAddress     // Catch:{ all -> 0x0042 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf((boolean) r0)     // Catch:{ all -> 0x0042 }
            monitor-exit(r1)
            return r0
        L_0x0057:
            java.net.SocketOption<java.lang.Integer> r0 = java.net.StandardSocketOptions.IP_TOS     // Catch:{ all -> 0x0042 }
            if (r4 != r0) goto L_0x0071
            boolean r0 = sun.nio.ch.Net.isIPv6Available()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0068
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf((int) r0)     // Catch:{ all -> 0x0042 }
        L_0x0066:
            monitor-exit(r1)
            return r0
        L_0x0068:
            java.io.FileDescriptor r0 = r3.fd     // Catch:{ all -> 0x0042 }
            java.net.StandardProtocolFamily r2 = java.net.StandardProtocolFamily.INET     // Catch:{ all -> 0x0042 }
            java.lang.Object r0 = sun.nio.ch.Net.getSocketOption(r0, r2, r4)     // Catch:{ all -> 0x0042 }
            goto L_0x0066
        L_0x0071:
            java.io.FileDescriptor r0 = r3.fd     // Catch:{ all -> 0x0042 }
            java.net.ProtocolFamily r2 = sun.nio.ch.Net.UNSPEC     // Catch:{ all -> 0x0042 }
            java.lang.Object r0 = sun.nio.ch.Net.getSocketOption(r0, r2, r4)     // Catch:{ all -> 0x0042 }
            monitor-exit(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.getOption(java.net.SocketOption):java.lang.Object");
    }

    public final Set<SocketOption<?>> supportedOptions() {
        return DefaultOptionsHolder.defaultOptions;
    }

    private boolean ensureReadOpen() throws ClosedChannelException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (!isConnected()) {
                throw new NotYetConnectedException();
            } else if (!this.isInputOpen) {
                return f135assertionsDisabled;
            } else {
                return true;
            }
        }
    }

    private void ensureWriteOpen() throws ClosedChannelException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (!this.isOutputOpen) {
                throw new ClosedChannelException();
            } else if (!isConnected()) {
                throw new NotYetConnectedException();
            }
        }
    }

    private void readerCleanup() throws IOException {
        synchronized (this.stateLock) {
            this.readerThread = 0;
            if (this.state == 3) {
                kill();
            }
        }
    }

    private void writerCleanup() throws IOException {
        synchronized (this.stateLock) {
            this.writerThread = 0;
            if (this.state == 3) {
                kill();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0111, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0113, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0115, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0117, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x011c, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        readerCleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0037, code lost:
        if (isBlocking() == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0039, code lost:
        sun.misc.IoTrace.socketReadEnd(r0, r13.remoteAddress.getAddress(), r13.remoteAddress.getPort(), 0, (long) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004a, code lost:
        end(f135assertionsDisabled);
        r1 = r13.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
        if (r13.isInputOpen == false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
        if (f135assertionsDisabled != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
        if (sun.nio.ch.IOStatus.check(0) != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0065, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006b, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0070, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0078, code lost:
        r6 = sun.nio.ch.IOUtil.read(r13.fd, r14, -1, nd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0083, code lost:
        if (r6 != -3) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0089, code lost:
        if (isOpen() != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008b, code lost:
        r8 = sun.nio.ch.IOStatus.normalize(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        readerCleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0096, code lost:
        if (isBlocking() == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0098, code lost:
        r1 = r13.remoteAddress.getAddress();
        r2 = r13.remoteAddress.getPort();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a4, code lost:
        if (r6 <= 0) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a6, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00a7, code lost:
        sun.misc.IoTrace.socketReadEnd(r0, r1, r2, 0, (long) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ac, code lost:
        if (r6 > 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ae, code lost:
        if (r6 != -2) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00b0, code lost:
        end(r9);
        r1 = r13.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00b5, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00b6, code lost:
        if (r6 > 0) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00ba, code lost:
        if (r13.isInputOpen == false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00bf, code lost:
        if (f135assertionsDisabled != false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00c5, code lost:
        if (sun.nio.ch.IOStatus.check(r6) != false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00cc, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:109:0x0100=Splitter:B:109:0x0100, B:79:0x00bc=Splitter:B:79:0x00bc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(java.nio.ByteBuffer r14) throws java.io.IOException {
        /*
            r13 = this;
            r12 = -2
            r9 = 1
            r11 = -1
            r7 = 0
            if (r14 != 0) goto L_0x000c
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r1.<init>()
            throw r1
        L_0x000c:
            java.lang.Object r10 = r13.readLock
            monitor-enter(r10)
            boolean r1 = r13.ensureReadOpen()     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0017
            monitor-exit(r10)
            return r11
        L_0x0017:
            r0 = 0
            boolean r1 = r13.isBlocking()     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x0022
            java.lang.Object r0 = sun.misc.IoTrace.socketReadBegin()     // Catch:{ all -> 0x0066 }
        L_0x0022:
            r6 = 0
            r13.begin()     // Catch:{ all -> 0x00d0 }
            java.lang.Object r2 = r13.stateLock     // Catch:{ all -> 0x00d0 }
            monitor-enter(r2)     // Catch:{ all -> 0x00d0 }
            boolean r1 = r13.isOpen()     // Catch:{ all -> 0x00cd }
            if (r1 != 0) goto L_0x0071
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            r13.readerCleanup()     // Catch:{ all -> 0x0066 }
            boolean r1 = r13.isBlocking()     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x004a
            java.net.InetSocketAddress r1 = r13.remoteAddress     // Catch:{ all -> 0x0066 }
            java.net.InetAddress r1 = r1.getAddress()     // Catch:{ all -> 0x0066 }
            java.net.InetSocketAddress r2 = r13.remoteAddress     // Catch:{ all -> 0x0066 }
            int r2 = r2.getPort()     // Catch:{ all -> 0x0066 }
            long r4 = (long) r7     // Catch:{ all -> 0x0066 }
            r3 = 0
            sun.misc.IoTrace.socketReadEnd(r0, r1, r2, r3, r4)     // Catch:{ all -> 0x0066 }
        L_0x004a:
            r1 = 0
            r13.end(r1)     // Catch:{ all -> 0x0066 }
            java.lang.Object r1 = r13.stateLock     // Catch:{ all -> 0x0066 }
            monitor-enter(r1)     // Catch:{ all -> 0x0066 }
            boolean r2 = r13.isInputOpen     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x0069
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            boolean r1 = f135assertionsDisabled     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x006f
            boolean r1 = sun.nio.ch.IOStatus.check((int) r6)     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x006f
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0066 }
            r1.<init>()     // Catch:{ all -> 0x0066 }
            throw r1     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r1 = move-exception
            monitor-exit(r10)
            throw r1
        L_0x0069:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            monitor-exit(r10)
            return r11
        L_0x006c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            throw r2     // Catch:{ all -> 0x0066 }
        L_0x006f:
            monitor-exit(r10)
            return r7
        L_0x0071:
            long r4 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x00cd }
            r13.readerThread = r4     // Catch:{ all -> 0x00cd }
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
        L_0x0078:
            java.io.FileDescriptor r1 = r13.fd     // Catch:{ all -> 0x00d0 }
            r2 = -1
            sun.nio.ch.NativeDispatcher r4 = nd     // Catch:{ all -> 0x00d0 }
            int r6 = sun.nio.ch.IOUtil.read(r1, r14, r2, r4)     // Catch:{ all -> 0x00d0 }
            r1 = -3
            if (r6 != r1) goto L_0x008b
            boolean r1 = r13.isOpen()     // Catch:{ all -> 0x00d0 }
            if (r1 != 0) goto L_0x0078
        L_0x008b:
            int r8 = sun.nio.ch.IOStatus.normalize((int) r6)     // Catch:{ all -> 0x00d0 }
            r13.readerCleanup()     // Catch:{ all -> 0x0066 }
            boolean r1 = r13.isBlocking()     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x00ac
            java.net.InetSocketAddress r1 = r13.remoteAddress     // Catch:{ all -> 0x0066 }
            java.net.InetAddress r1 = r1.getAddress()     // Catch:{ all -> 0x0066 }
            java.net.InetSocketAddress r2 = r13.remoteAddress     // Catch:{ all -> 0x0066 }
            int r2 = r2.getPort()     // Catch:{ all -> 0x0066 }
            if (r6 <= 0) goto L_0x0111
            r3 = r6
        L_0x00a7:
            long r4 = (long) r3     // Catch:{ all -> 0x0066 }
            r3 = 0
            sun.misc.IoTrace.socketReadEnd(r0, r1, r2, r3, r4)     // Catch:{ all -> 0x0066 }
        L_0x00ac:
            if (r6 > 0) goto L_0x00b0
            if (r6 != r12) goto L_0x0113
        L_0x00b0:
            r13.end(r9)     // Catch:{ all -> 0x0066 }
            java.lang.Object r1 = r13.stateLock     // Catch:{ all -> 0x0066 }
            monitor-enter(r1)     // Catch:{ all -> 0x0066 }
            if (r6 > 0) goto L_0x00bc
            boolean r2 = r13.isInputOpen     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x0115
        L_0x00bc:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            boolean r1 = f135assertionsDisabled     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x011b
            boolean r1 = sun.nio.ch.IOStatus.check((int) r6)     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x011b
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0066 }
            r1.<init>()     // Catch:{ all -> 0x0066 }
            throw r1     // Catch:{ all -> 0x0066 }
        L_0x00cd:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            throw r1     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r1 = move-exception
            r8 = r1
            r13.readerCleanup()     // Catch:{ all -> 0x0066 }
            boolean r1 = r13.isBlocking()     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x00ef
            java.net.InetSocketAddress r1 = r13.remoteAddress     // Catch:{ all -> 0x0066 }
            java.net.InetAddress r1 = r1.getAddress()     // Catch:{ all -> 0x0066 }
            java.net.InetSocketAddress r2 = r13.remoteAddress     // Catch:{ all -> 0x0066 }
            int r2 = r2.getPort()     // Catch:{ all -> 0x0066 }
            if (r6 <= 0) goto L_0x011d
            r3 = r6
        L_0x00ea:
            long r4 = (long) r3     // Catch:{ all -> 0x0066 }
            r3 = 0
            sun.misc.IoTrace.socketReadEnd(r0, r1, r2, r3, r4)     // Catch:{ all -> 0x0066 }
        L_0x00ef:
            if (r6 > 0) goto L_0x00f3
            if (r6 != r12) goto L_0x00f4
        L_0x00f3:
            r7 = r9
        L_0x00f4:
            r13.end(r7)     // Catch:{ all -> 0x0066 }
            java.lang.Object r1 = r13.stateLock     // Catch:{ all -> 0x0066 }
            monitor-enter(r1)     // Catch:{ all -> 0x0066 }
            if (r6 > 0) goto L_0x0100
            boolean r2 = r13.isInputOpen     // Catch:{ all -> 0x0122 }
            if (r2 == 0) goto L_0x011f
        L_0x0100:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            boolean r1 = f135assertionsDisabled     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0125
            boolean r1 = sun.nio.ch.IOStatus.check((int) r6)     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0125
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0066 }
            r1.<init>()     // Catch:{ all -> 0x0066 }
            throw r1     // Catch:{ all -> 0x0066 }
        L_0x0111:
            r3 = r7
            goto L_0x00a7
        L_0x0113:
            r9 = r7
            goto L_0x00b0
        L_0x0115:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            monitor-exit(r10)
            return r11
        L_0x0118:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            throw r2     // Catch:{ all -> 0x0066 }
        L_0x011b:
            monitor-exit(r10)
            return r8
        L_0x011d:
            r3 = r7
            goto L_0x00ea
        L_0x011f:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            monitor-exit(r10)
            return r11
        L_0x0122:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            throw r2     // Catch:{ all -> 0x0066 }
        L_0x0125:
            throw r8     // Catch:{ all -> 0x0066 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.read(java.nio.ByteBuffer):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:0x013b, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x013f, code lost:
        r1 = f135assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0141, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0145, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x014a, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        readerCleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003c, code lost:
        if (isBlocking() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003e, code lost:
        sun.misc.IoTrace.socketReadEnd(r0, r12.remoteAddress.getAddress(), r12.remoteAddress.getPort(), 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        end(f135assertionsDisabled);
        r1 = r12.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0059, code lost:
        if (r12.isInputOpen == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
        if (f135assertionsDisabled != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0064, code lost:
        if (sun.nio.ch.IOStatus.check(0) != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0073, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x007a, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0082, code lost:
        r6 = sun.nio.ch.IOUtil.read(r12.fd, r13, r14, r15, nd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008e, code lost:
        if (r6 != -3) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0094, code lost:
        if (isOpen() != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0096, code lost:
        r10 = sun.nio.ch.IOStatus.normalize(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        readerCleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00a1, code lost:
        if (isBlocking() == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00a3, code lost:
        r1 = r12.remoteAddress.getAddress();
        r2 = r12.remoteAddress.getPort();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b3, code lost:
        if (r6 <= 0) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00b5, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00b6, code lost:
        sun.misc.IoTrace.socketReadEnd(r0, r1, r2, 0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00be, code lost:
        if (r6 > 0) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c4, code lost:
        if (r6 != -2) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00c6, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00c7, code lost:
        end(r1);
        r1 = r12.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00cc, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00d1, code lost:
        if (r6 > 0) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00d5, code lost:
        if (r12.isInputOpen == false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00da, code lost:
        if (f135assertionsDisabled != false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00e0, code lost:
        if (sun.nio.ch.IOStatus.check(r6) != false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x00e7, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:87:0x00d7=Splitter:B:87:0x00d7, B:120:0x012a=Splitter:B:120:0x012a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(java.nio.ByteBuffer[] r13, int r14, int r15) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 < 0) goto L_0x0004
            if (r15 >= 0) goto L_0x000a
        L_0x0004:
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            r1.<init>()
            throw r1
        L_0x000a:
            int r1 = r13.length
            int r1 = r1 - r15
            if (r14 > r1) goto L_0x0004
            java.lang.Object r9 = r12.readLock
            monitor-enter(r9)
            boolean r1 = r12.ensureReadOpen()     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x001b
            r2 = -1
            monitor-exit(r9)
            return r2
        L_0x001b:
            r6 = 0
            r0 = 0
            boolean r1 = r12.isBlocking()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0028
            java.lang.Object r0 = sun.misc.IoTrace.socketReadBegin()     // Catch:{ all -> 0x006c }
        L_0x0028:
            r12.begin()     // Catch:{ all -> 0x00eb }
            java.lang.Object r2 = r12.stateLock     // Catch:{ all -> 0x00eb }
            monitor-enter(r2)     // Catch:{ all -> 0x00eb }
            boolean r1 = r12.isOpen()     // Catch:{ all -> 0x00e8 }
            if (r1 != 0) goto L_0x007b
            monitor-exit(r2)     // Catch:{ all -> 0x00eb }
            r12.readerCleanup()     // Catch:{ all -> 0x006c }
            boolean r1 = r12.isBlocking()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0050
            java.net.InetSocketAddress r1 = r12.remoteAddress     // Catch:{ all -> 0x006c }
            java.net.InetAddress r1 = r1.getAddress()     // Catch:{ all -> 0x006c }
            java.net.InetSocketAddress r2 = r12.remoteAddress     // Catch:{ all -> 0x006c }
            int r2 = r2.getPort()     // Catch:{ all -> 0x006c }
            r4 = 0
            r3 = 0
            sun.misc.IoTrace.socketReadEnd(r0, r1, r2, r3, r4)     // Catch:{ all -> 0x006c }
        L_0x0050:
            r1 = 0
            r12.end(r1)     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r12.stateLock     // Catch:{ all -> 0x006c }
            monitor-enter(r1)     // Catch:{ all -> 0x006c }
            boolean r2 = r12.isInputOpen     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x006f
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            boolean r1 = f135assertionsDisabled     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0077
            boolean r1 = sun.nio.ch.IOStatus.check((long) r6)     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0077
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            throw r1     // Catch:{ all -> 0x006c }
        L_0x006c:
            r1 = move-exception
            monitor-exit(r9)
            throw r1
        L_0x006f:
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            r2 = -1
            monitor-exit(r9)
            return r2
        L_0x0074:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            throw r2     // Catch:{ all -> 0x006c }
        L_0x0077:
            r2 = 0
            monitor-exit(r9)
            return r2
        L_0x007b:
            long r4 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x00e8 }
            r12.readerThread = r4     // Catch:{ all -> 0x00e8 }
            monitor-exit(r2)     // Catch:{ all -> 0x00eb }
        L_0x0082:
            java.io.FileDescriptor r1 = r12.fd     // Catch:{ all -> 0x00eb }
            sun.nio.ch.NativeDispatcher r2 = nd     // Catch:{ all -> 0x00eb }
            long r6 = sun.nio.ch.IOUtil.read(r1, r13, r14, r15, r2)     // Catch:{ all -> 0x00eb }
            r2 = -3
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0096
            boolean r1 = r12.isOpen()     // Catch:{ all -> 0x00eb }
            if (r1 != 0) goto L_0x0082
        L_0x0096:
            long r10 = sun.nio.ch.IOStatus.normalize((long) r6)     // Catch:{ all -> 0x00eb }
            r12.readerCleanup()     // Catch:{ all -> 0x006c }
            boolean r1 = r12.isBlocking()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x00ba
            java.net.InetSocketAddress r1 = r12.remoteAddress     // Catch:{ all -> 0x006c }
            java.net.InetAddress r1 = r1.getAddress()     // Catch:{ all -> 0x006c }
            java.net.InetSocketAddress r2 = r12.remoteAddress     // Catch:{ all -> 0x006c }
            int r2 = r2.getPort()     // Catch:{ all -> 0x006c }
            r4 = 0
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x013b
            r4 = r6
        L_0x00b6:
            r3 = 0
            sun.misc.IoTrace.socketReadEnd(r0, r1, r2, r3, r4)     // Catch:{ all -> 0x006c }
        L_0x00ba:
            r2 = 0
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x00c6
            r2 = -2
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x013f
        L_0x00c6:
            r1 = 1
        L_0x00c7:
            r12.end(r1)     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r12.stateLock     // Catch:{ all -> 0x006c }
            monitor-enter(r1)     // Catch:{ all -> 0x006c }
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x00d7
            boolean r2 = r12.isInputOpen     // Catch:{ all -> 0x0146 }
            if (r2 == 0) goto L_0x0141
        L_0x00d7:
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            boolean r1 = f135assertionsDisabled     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0149
            boolean r1 = sun.nio.ch.IOStatus.check((long) r6)     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0149
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            throw r1     // Catch:{ all -> 0x006c }
        L_0x00e8:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00eb }
            throw r1     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r1 = move-exception
            r8 = r1
            r12.readerCleanup()     // Catch:{ all -> 0x006c }
            boolean r1 = r12.isBlocking()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x010d
            java.net.InetSocketAddress r1 = r12.remoteAddress     // Catch:{ all -> 0x006c }
            java.net.InetAddress r1 = r1.getAddress()     // Catch:{ all -> 0x006c }
            java.net.InetSocketAddress r2 = r12.remoteAddress     // Catch:{ all -> 0x006c }
            int r2 = r2.getPort()     // Catch:{ all -> 0x006c }
            r4 = 0
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x014b
            r4 = r6
        L_0x0109:
            r3 = 0
            sun.misc.IoTrace.socketReadEnd(r0, r1, r2, r3, r4)     // Catch:{ all -> 0x006c }
        L_0x010d:
            r2 = 0
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0119
            r2 = -2
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x014e
        L_0x0119:
            r1 = 1
        L_0x011a:
            r12.end(r1)     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r12.stateLock     // Catch:{ all -> 0x006c }
            monitor-enter(r1)     // Catch:{ all -> 0x006c }
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x012a
            boolean r2 = r12.isInputOpen     // Catch:{ all -> 0x0155 }
            if (r2 == 0) goto L_0x0150
        L_0x012a:
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            boolean r1 = f135assertionsDisabled     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0158
            boolean r1 = sun.nio.ch.IOStatus.check((long) r6)     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0158
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            throw r1     // Catch:{ all -> 0x006c }
        L_0x013b:
            r4 = 0
            goto L_0x00b6
        L_0x013f:
            r1 = 0
            goto L_0x00c7
        L_0x0141:
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            r2 = -1
            monitor-exit(r9)
            return r2
        L_0x0146:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            throw r2     // Catch:{ all -> 0x006c }
        L_0x0149:
            monitor-exit(r9)
            return r10
        L_0x014b:
            r4 = 0
            goto L_0x0109
        L_0x014e:
            r1 = 0
            goto L_0x011a
        L_0x0150:
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            r2 = -1
            monitor-exit(r9)
            return r2
        L_0x0155:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            throw r2     // Catch:{ all -> 0x006c }
        L_0x0158:
            throw r8     // Catch:{ all -> 0x006c }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.read(java.nio.ByteBuffer[], int, int):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x00f3, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x00fa, code lost:
        throw new java.nio.channels.AsynchronousCloseException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x00ff, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        writerCleanup();
        sun.misc.IoTrace.socketWriteEnd(r1, r13.remoteAddress.getAddress(), r13.remoteAddress.getPort(), (long) 0);
        end(f135assertionsDisabled);
        r4 = r13.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r13.isOutputOpen == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (f135assertionsDisabled != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004a, code lost:
        if (sun.nio.ch.IOStatus.check(0) != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005a, code lost:
        throw new java.nio.channels.AsynchronousCloseException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005f, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0067, code lost:
        r0 = sun.nio.ch.IOUtil.write(r13.fd, r14, -1, nd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0072, code lost:
        if (r0 != -3) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0078, code lost:
        if (isOpen() != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007a, code lost:
        r5 = sun.nio.ch.IOStatus.normalize(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        writerCleanup();
        r7 = r13.remoteAddress.getAddress();
        r8 = r13.remoteAddress.getPort();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008d, code lost:
        if (r0 <= 0) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x008f, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0090, code lost:
        sun.misc.IoTrace.socketWriteEnd(r1, r7, r8, (long) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0094, code lost:
        if (r0 > 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0096, code lost:
        if (r0 != -2) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0098, code lost:
        end(r4);
        r3 = r13.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x009d, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x009e, code lost:
        if (r0 > 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a2, code lost:
        if (r13.isOutputOpen == false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a7, code lost:
        if (f135assertionsDisabled != false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ad, code lost:
        if (sun.nio.ch.IOStatus.check(r0) != false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b4, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x00f1, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:91:0x00e0=Splitter:B:91:0x00e0, B:64:0x00a4=Splitter:B:64:0x00a4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int write(java.nio.ByteBuffer r14) throws java.io.IOException {
        /*
            r13 = this;
            r12 = -2
            r4 = 1
            r3 = 0
            if (r14 != 0) goto L_0x000b
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>()
            throw r2
        L_0x000b:
            java.lang.Object r6 = r13.writeLock
            monitor-enter(r6)
            r13.ensureWriteOpen()     // Catch:{ all -> 0x0052 }
            r0 = 0
            java.lang.Object r1 = sun.misc.IoTrace.socketWriteBegin()     // Catch:{ all -> 0x0052 }
            r13.begin()     // Catch:{ all -> 0x00b8 }
            java.lang.Object r5 = r13.stateLock     // Catch:{ all -> 0x00b8 }
            monitor-enter(r5)     // Catch:{ all -> 0x00b8 }
            boolean r2 = r13.isOpen()     // Catch:{ all -> 0x00b5 }
            if (r2 != 0) goto L_0x0060
            monitor-exit(r5)     // Catch:{ all -> 0x00b8 }
            r13.writerCleanup()     // Catch:{ all -> 0x0052 }
            java.net.InetSocketAddress r2 = r13.remoteAddress     // Catch:{ all -> 0x0052 }
            java.net.InetAddress r2 = r2.getAddress()     // Catch:{ all -> 0x0052 }
            java.net.InetSocketAddress r4 = r13.remoteAddress     // Catch:{ all -> 0x0052 }
            int r4 = r4.getPort()     // Catch:{ all -> 0x0052 }
            long r8 = (long) r3     // Catch:{ all -> 0x0052 }
            sun.misc.IoTrace.socketWriteEnd(r1, r2, r4, r8)     // Catch:{ all -> 0x0052 }
            r2 = 0
            r13.end(r2)     // Catch:{ all -> 0x0052 }
            java.lang.Object r4 = r13.stateLock     // Catch:{ all -> 0x0052 }
            monitor-enter(r4)     // Catch:{ all -> 0x0052 }
            boolean r2 = r13.isOutputOpen     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0055
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            boolean r2 = f135assertionsDisabled     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x005e
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x005e
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            throw r2     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r2 = move-exception
            monitor-exit(r6)
            throw r2
        L_0x0055:
            java.nio.channels.AsynchronousCloseException r2 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x005b }
            r2.<init>()     // Catch:{ all -> 0x005b }
            throw r2     // Catch:{ all -> 0x005b }
        L_0x005b:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            throw r2     // Catch:{ all -> 0x0052 }
        L_0x005e:
            monitor-exit(r6)
            return r3
        L_0x0060:
            long r8 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x00b5 }
            r13.writerThread = r8     // Catch:{ all -> 0x00b5 }
            monitor-exit(r5)     // Catch:{ all -> 0x00b8 }
        L_0x0067:
            java.io.FileDescriptor r2 = r13.fd     // Catch:{ all -> 0x00b8 }
            r8 = -1
            sun.nio.ch.NativeDispatcher r5 = nd     // Catch:{ all -> 0x00b8 }
            int r0 = sun.nio.ch.IOUtil.write(r2, r14, r8, r5)     // Catch:{ all -> 0x00b8 }
            r2 = -3
            if (r0 != r2) goto L_0x007a
            boolean r2 = r13.isOpen()     // Catch:{ all -> 0x00b8 }
            if (r2 != 0) goto L_0x0067
        L_0x007a:
            int r5 = sun.nio.ch.IOStatus.normalize((int) r0)     // Catch:{ all -> 0x00b8 }
            r13.writerCleanup()     // Catch:{ all -> 0x0052 }
            java.net.InetSocketAddress r2 = r13.remoteAddress     // Catch:{ all -> 0x0052 }
            java.net.InetAddress r7 = r2.getAddress()     // Catch:{ all -> 0x0052 }
            java.net.InetSocketAddress r2 = r13.remoteAddress     // Catch:{ all -> 0x0052 }
            int r8 = r2.getPort()     // Catch:{ all -> 0x0052 }
            if (r0 <= 0) goto L_0x00f1
            r2 = r0
        L_0x0090:
            long r10 = (long) r2     // Catch:{ all -> 0x0052 }
            sun.misc.IoTrace.socketWriteEnd(r1, r7, r8, r10)     // Catch:{ all -> 0x0052 }
            if (r0 > 0) goto L_0x0098
            if (r0 != r12) goto L_0x00f3
        L_0x0098:
            r13.end(r4)     // Catch:{ all -> 0x0052 }
            java.lang.Object r3 = r13.stateLock     // Catch:{ all -> 0x0052 }
            monitor-enter(r3)     // Catch:{ all -> 0x0052 }
            if (r0 > 0) goto L_0x00a4
            boolean r2 = r13.isOutputOpen     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x00f5
        L_0x00a4:
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            boolean r2 = f135assertionsDisabled     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x00fe
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x00fe
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            throw r2     // Catch:{ all -> 0x0052 }
        L_0x00b5:
            r2 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00b8 }
            throw r2     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r2 = move-exception
            r13.writerCleanup()     // Catch:{ all -> 0x0052 }
            java.net.InetSocketAddress r5 = r13.remoteAddress     // Catch:{ all -> 0x0052 }
            java.net.InetAddress r7 = r5.getAddress()     // Catch:{ all -> 0x0052 }
            java.net.InetSocketAddress r5 = r13.remoteAddress     // Catch:{ all -> 0x0052 }
            int r8 = r5.getPort()     // Catch:{ all -> 0x0052 }
            if (r0 <= 0) goto L_0x0100
            r5 = r0
        L_0x00cb:
            long r10 = (long) r5     // Catch:{ all -> 0x0052 }
            sun.misc.IoTrace.socketWriteEnd(r1, r7, r8, r10)     // Catch:{ all -> 0x0052 }
            if (r0 > 0) goto L_0x00d3
            if (r0 != r12) goto L_0x00d4
        L_0x00d3:
            r3 = r4
        L_0x00d4:
            r13.end(r3)     // Catch:{ all -> 0x0052 }
            java.lang.Object r3 = r13.stateLock     // Catch:{ all -> 0x0052 }
            monitor-enter(r3)     // Catch:{ all -> 0x0052 }
            if (r0 > 0) goto L_0x00e0
            boolean r4 = r13.isOutputOpen     // Catch:{ all -> 0x0108 }
            if (r4 == 0) goto L_0x0102
        L_0x00e0:
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            boolean r3 = f135assertionsDisabled     // Catch:{ all -> 0x0052 }
            if (r3 != 0) goto L_0x010b
            boolean r3 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0052 }
            if (r3 != 0) goto L_0x010b
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            throw r2     // Catch:{ all -> 0x0052 }
        L_0x00f1:
            r2 = r3
            goto L_0x0090
        L_0x00f3:
            r4 = r3
            goto L_0x0098
        L_0x00f5:
            java.nio.channels.AsynchronousCloseException r2 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x00fb }
            r2.<init>()     // Catch:{ all -> 0x00fb }
            throw r2     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            throw r2     // Catch:{ all -> 0x0052 }
        L_0x00fe:
            monitor-exit(r6)
            return r5
        L_0x0100:
            r5 = r3
            goto L_0x00cb
        L_0x0102:
            java.nio.channels.AsynchronousCloseException r2 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x0108 }
            r2.<init>()     // Catch:{ all -> 0x0108 }
            throw r2     // Catch:{ all -> 0x0108 }
        L_0x0108:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            throw r2     // Catch:{ all -> 0x0052 }
        L_0x010b:
            throw r2     // Catch:{ all -> 0x0052 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.write(java.nio.ByteBuffer):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0118, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x011b, code lost:
        r3 = f135assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0122, code lost:
        throw new java.nio.channels.AsynchronousCloseException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0127, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        writerCleanup();
        sun.misc.IoTrace.socketWriteEnd(r2, r12.remoteAddress.getAddress(), r12.remoteAddress.getPort(), 0);
        end(f135assertionsDisabled);
        r4 = r12.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r12.isOutputOpen == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (f135assertionsDisabled != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        if (sun.nio.ch.IOStatus.check(0) != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005f, code lost:
        throw new java.nio.channels.AsynchronousCloseException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006e, code lost:
        r0 = sun.nio.ch.IOUtil.write(r12.fd, r13, r14, r15, nd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007a, code lost:
        if (r0 != -3) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0080, code lost:
        if (isOpen() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0082, code lost:
        r8 = sun.nio.ch.IOStatus.normalize(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        writerCleanup();
        r3 = r12.remoteAddress.getAddress();
        r7 = r12.remoteAddress.getPort();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0099, code lost:
        if (r0 <= 0) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009b, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x009c, code lost:
        sun.misc.IoTrace.socketWriteEnd(r2, r3, r7, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a3, code lost:
        if (r0 > 0) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a9, code lost:
        if (r0 != -2) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ab, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ac, code lost:
        end(r3);
        r4 = r12.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b1, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b6, code lost:
        if (r0 > 0) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ba, code lost:
        if (r12.isOutputOpen == false) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00bf, code lost:
        if (f135assertionsDisabled != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00c5, code lost:
        if (sun.nio.ch.IOStatus.check(r0) != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00cc, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:99:0x0107=Splitter:B:99:0x0107, B:70:0x00bc=Splitter:B:70:0x00bc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long write(java.nio.ByteBuffer[] r13, int r14, int r15) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 < 0) goto L_0x0004
            if (r15 >= 0) goto L_0x000a
        L_0x0004:
            java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException
            r3.<init>()
            throw r3
        L_0x000a:
            int r3 = r13.length
            int r3 = r3 - r15
            if (r14 > r3) goto L_0x0004
            java.lang.Object r6 = r12.writeLock
            monitor-enter(r6)
            r12.ensureWriteOpen()     // Catch:{ all -> 0x0057 }
            r0 = 0
            java.lang.Object r2 = sun.misc.IoTrace.socketWriteBegin()     // Catch:{ all -> 0x0057 }
            r12.begin()     // Catch:{ all -> 0x00d0 }
            java.lang.Object r4 = r12.stateLock     // Catch:{ all -> 0x00d0 }
            monitor-enter(r4)     // Catch:{ all -> 0x00d0 }
            boolean r3 = r12.isOpen()     // Catch:{ all -> 0x00cd }
            if (r3 != 0) goto L_0x0067
            monitor-exit(r4)     // Catch:{ all -> 0x00d0 }
            r12.writerCleanup()     // Catch:{ all -> 0x0057 }
            java.net.InetSocketAddress r3 = r12.remoteAddress     // Catch:{ all -> 0x0057 }
            java.net.InetAddress r3 = r3.getAddress()     // Catch:{ all -> 0x0057 }
            java.net.InetSocketAddress r4 = r12.remoteAddress     // Catch:{ all -> 0x0057 }
            int r4 = r4.getPort()     // Catch:{ all -> 0x0057 }
            r8 = 0
            sun.misc.IoTrace.socketWriteEnd(r2, r3, r4, r8)     // Catch:{ all -> 0x0057 }
            r3 = 0
            r12.end(r3)     // Catch:{ all -> 0x0057 }
            java.lang.Object r4 = r12.stateLock     // Catch:{ all -> 0x0057 }
            monitor-enter(r4)     // Catch:{ all -> 0x0057 }
            boolean r3 = r12.isOutputOpen     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x005a
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            boolean r3 = f135assertionsDisabled     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0063
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0063
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x005a:
            java.nio.channels.AsynchronousCloseException r3 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            throw r3     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0063:
            r4 = 0
            monitor-exit(r6)
            return r4
        L_0x0067:
            long r8 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x00cd }
            r12.writerThread = r8     // Catch:{ all -> 0x00cd }
            monitor-exit(r4)     // Catch:{ all -> 0x00d0 }
        L_0x006e:
            java.io.FileDescriptor r3 = r12.fd     // Catch:{ all -> 0x00d0 }
            sun.nio.ch.NativeDispatcher r4 = nd     // Catch:{ all -> 0x00d0 }
            long r0 = sun.nio.ch.IOUtil.write(r3, r13, r14, r15, r4)     // Catch:{ all -> 0x00d0 }
            r4 = -3
            int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0082
            boolean r3 = r12.isOpen()     // Catch:{ all -> 0x00d0 }
            if (r3 != 0) goto L_0x006e
        L_0x0082:
            long r8 = sun.nio.ch.IOStatus.normalize((long) r0)     // Catch:{ all -> 0x00d0 }
            r12.writerCleanup()     // Catch:{ all -> 0x0057 }
            java.net.InetSocketAddress r3 = r12.remoteAddress     // Catch:{ all -> 0x0057 }
            java.net.InetAddress r3 = r3.getAddress()     // Catch:{ all -> 0x0057 }
            java.net.InetSocketAddress r4 = r12.remoteAddress     // Catch:{ all -> 0x0057 }
            int r7 = r4.getPort()     // Catch:{ all -> 0x0057 }
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0118
            r4 = r0
        L_0x009c:
            sun.misc.IoTrace.socketWriteEnd(r2, r3, r7, r4)     // Catch:{ all -> 0x0057 }
            r4 = 0
            int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x00ab
            r4 = -2
            int r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x011b
        L_0x00ab:
            r3 = 1
        L_0x00ac:
            r12.end(r3)     // Catch:{ all -> 0x0057 }
            java.lang.Object r4 = r12.stateLock     // Catch:{ all -> 0x0057 }
            monitor-enter(r4)     // Catch:{ all -> 0x0057 }
            r10 = 0
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x00bc
            boolean r3 = r12.isOutputOpen     // Catch:{ all -> 0x0123 }
            if (r3 == 0) goto L_0x011d
        L_0x00bc:
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            boolean r3 = f135assertionsDisabled     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0126
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0126
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x00cd:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00d0 }
            throw r3     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r3 = move-exception
            r12.writerCleanup()     // Catch:{ all -> 0x0057 }
            java.net.InetSocketAddress r4 = r12.remoteAddress     // Catch:{ all -> 0x0057 }
            java.net.InetAddress r7 = r4.getAddress()     // Catch:{ all -> 0x0057 }
            java.net.InetSocketAddress r4 = r12.remoteAddress     // Catch:{ all -> 0x0057 }
            int r8 = r4.getPort()     // Catch:{ all -> 0x0057 }
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0128
            r4 = r0
        L_0x00e7:
            sun.misc.IoTrace.socketWriteEnd(r2, r7, r8, r4)     // Catch:{ all -> 0x0057 }
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00f6
            r4 = -2
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x012b
        L_0x00f6:
            r4 = 1
        L_0x00f7:
            r12.end(r4)     // Catch:{ all -> 0x0057 }
            java.lang.Object r4 = r12.stateLock     // Catch:{ all -> 0x0057 }
            monitor-enter(r4)     // Catch:{ all -> 0x0057 }
            r8 = 0
            int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x0107
            boolean r5 = r12.isOutputOpen     // Catch:{ all -> 0x0133 }
            if (r5 == 0) goto L_0x012d
        L_0x0107:
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            boolean r4 = f135assertionsDisabled     // Catch:{ all -> 0x0057 }
            if (r4 != 0) goto L_0x0136
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0057 }
            if (r4 != 0) goto L_0x0136
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0118:
            r4 = 0
            goto L_0x009c
        L_0x011b:
            r3 = 0
            goto L_0x00ac
        L_0x011d:
            java.nio.channels.AsynchronousCloseException r3 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x0123 }
            r3.<init>()     // Catch:{ all -> 0x0123 }
            throw r3     // Catch:{ all -> 0x0123 }
        L_0x0123:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0126:
            monitor-exit(r6)
            return r8
        L_0x0128:
            r4 = 0
            goto L_0x00e7
        L_0x012b:
            r4 = 0
            goto L_0x00f7
        L_0x012d:
            java.nio.channels.AsynchronousCloseException r3 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x0133 }
            r3.<init>()     // Catch:{ all -> 0x0133 }
            throw r3     // Catch:{ all -> 0x0133 }
        L_0x0133:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0136:
            throw r3     // Catch:{ all -> 0x0057 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.write(java.nio.ByteBuffer[], int, int):long");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        writerCleanup();
        end(f135assertionsDisabled);
        r2 = r9.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        if (r9.isOutputOpen == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0028, code lost:
        if (f135assertionsDisabled != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002e, code lost:
        if (sun.nio.ch.IOStatus.check(0) != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003e, code lost:
        throw new java.nio.channels.AsynchronousCloseException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0043, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x004b, code lost:
        r0 = sendOutOfBandData(r9.fd, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0052, code lost:
        if (r0 != -3) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0058, code lost:
        if (isOpen() != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x005a, code lost:
        r1 = sun.nio.ch.IOStatus.normalize(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        writerCleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0061, code lost:
        if (r0 > 0) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0063, code lost:
        if (r0 != -2) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0065, code lost:
        end(r2);
        r2 = r9.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x006a, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x006b, code lost:
        if (r0 > 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x006f, code lost:
        if (r9.isOutputOpen == false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0074, code lost:
        if (f135assertionsDisabled != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x007a, code lost:
        if (sun.nio.ch.IOStatus.check(r0) != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0081, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00aa, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00b1, code lost:
        throw new java.nio.channels.AsynchronousCloseException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x00b6, code lost:
        return r1;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:58:0x0071=Splitter:B:58:0x0071, B:81:0x0099=Splitter:B:81:0x0099} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int sendOutOfBandData(byte r10) throws java.io.IOException {
        /*
            r9 = this;
            r8 = -2
            r2 = 1
            r3 = 0
            java.lang.Object r4 = r9.writeLock
            monitor-enter(r4)
            r9.ensureWriteOpen()     // Catch:{ all -> 0x0036 }
            r0 = 0
            r9.begin()     // Catch:{ all -> 0x0085 }
            java.lang.Object r5 = r9.stateLock     // Catch:{ all -> 0x0085 }
            monitor-enter(r5)     // Catch:{ all -> 0x0085 }
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0082 }
            if (r1 != 0) goto L_0x0044
            monitor-exit(r5)     // Catch:{ all -> 0x0085 }
            r9.writerCleanup()     // Catch:{ all -> 0x0036 }
            r1 = 0
            r9.end(r1)     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = r9.stateLock     // Catch:{ all -> 0x0036 }
            monitor-enter(r2)     // Catch:{ all -> 0x0036 }
            boolean r1 = r9.isOutputOpen     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x0039
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            boolean r1 = f135assertionsDisabled     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0042
            boolean r1 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0042
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0036 }
            r1.<init>()     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r1 = move-exception
            monitor-exit(r4)
            throw r1
        L_0x0039:
            java.nio.channels.AsynchronousCloseException r1 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x003f }
            r1.<init>()     // Catch:{ all -> 0x003f }
            throw r1     // Catch:{ all -> 0x003f }
        L_0x003f:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0042:
            monitor-exit(r4)
            return r3
        L_0x0044:
            long r6 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x0082 }
            r9.writerThread = r6     // Catch:{ all -> 0x0082 }
            monitor-exit(r5)     // Catch:{ all -> 0x0085 }
        L_0x004b:
            java.io.FileDescriptor r1 = r9.fd     // Catch:{ all -> 0x0085 }
            int r0 = sendOutOfBandData(r1, r10)     // Catch:{ all -> 0x0085 }
            r1 = -3
            if (r0 != r1) goto L_0x005a
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0085 }
            if (r1 != 0) goto L_0x004b
        L_0x005a:
            int r1 = sun.nio.ch.IOStatus.normalize((int) r0)     // Catch:{ all -> 0x0085 }
            r9.writerCleanup()     // Catch:{ all -> 0x0036 }
            if (r0 > 0) goto L_0x0065
            if (r0 != r8) goto L_0x00aa
        L_0x0065:
            r9.end(r2)     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = r9.stateLock     // Catch:{ all -> 0x0036 }
            monitor-enter(r2)     // Catch:{ all -> 0x0036 }
            if (r0 > 0) goto L_0x0071
            boolean r3 = r9.isOutputOpen     // Catch:{ all -> 0x00b2 }
            if (r3 == 0) goto L_0x00ac
        L_0x0071:
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            boolean r2 = f135assertionsDisabled     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x00b5
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x00b5
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0036 }
            r1.<init>()     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0082:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0085 }
            throw r1     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r1 = move-exception
            r9.writerCleanup()     // Catch:{ all -> 0x0036 }
            if (r0 > 0) goto L_0x008d
            if (r0 != r8) goto L_0x00b7
        L_0x008d:
            r9.end(r2)     // Catch:{ all -> 0x0036 }
            java.lang.Object r2 = r9.stateLock     // Catch:{ all -> 0x0036 }
            monitor-enter(r2)     // Catch:{ all -> 0x0036 }
            if (r0 > 0) goto L_0x0099
            boolean r3 = r9.isOutputOpen     // Catch:{ all -> 0x00bf }
            if (r3 == 0) goto L_0x00b9
        L_0x0099:
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            boolean r2 = f135assertionsDisabled     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x00c2
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x00c2
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0036 }
            r1.<init>()     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x00aa:
            r2 = r3
            goto L_0x0065
        L_0x00ac:
            java.nio.channels.AsynchronousCloseException r1 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x00b2 }
            r1.<init>()     // Catch:{ all -> 0x00b2 }
            throw r1     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x00b5:
            monitor-exit(r4)
            return r1
        L_0x00b7:
            r2 = r3
            goto L_0x008d
        L_0x00b9:
            java.nio.channels.AsynchronousCloseException r1 = new java.nio.channels.AsynchronousCloseException     // Catch:{ all -> 0x00bf }
            r1.<init>()     // Catch:{ all -> 0x00bf }
            throw r1     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x00c2:
            throw r1     // Catch:{ all -> 0x0036 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.sendOutOfBandData(byte):int");
    }

    /* access modifiers changed from: protected */
    public void implConfigureBlocking(boolean block) throws IOException {
        IOUtil.configureBlocking(this.fd, block);
    }

    public InetSocketAddress localAddress() {
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

    public SocketChannel bind(SocketAddress local) throws IOException {
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        throw new ClosedChannelException();
                    } else if (this.state == 1) {
                        throw new ConnectionPendingException();
                    } else if (this.localAddress != null) {
                        throw new AlreadyBoundException();
                    } else {
                        InetSocketAddress isa = local == null ? new InetSocketAddress(0) : Net.checkAddress(local);
                        NetHooks.beforeTcpBind(this.fd, isa.getAddress(), isa.getPort());
                        Net.bind(this.fd, isa.getAddress(), isa.getPort());
                        this.localAddress = Net.localAddress(this.fd);
                    }
                }
            }
        }
        return this;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.state == 2 ? true : f135assertionsDisabled;
        }
        return z;
    }

    public boolean isConnectionPending() {
        boolean z = true;
        synchronized (this.stateLock) {
            if (this.state != 1) {
                z = f135assertionsDisabled;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void ensureOpenAndUnconnected() throws IOException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (this.state == 2) {
                throw new AlreadyConnectedException();
            } else if (this.state == 1) {
                throw new ConnectionPendingException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x00df, code lost:
        if (r3 <= 0) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x00e1, code lost:
        r14.state = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x00e8, code lost:
        if (isOpen() == false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x00ea, code lost:
        r14.localAddress = sun.nio.ch.Net.localAddress(r14.fd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x00f7, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x00fc, code lost:
        if (isBlocking() != false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x00fe, code lost:
        r14.state = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0105, code lost:
        if (isOpen() == false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0107, code lost:
        r14.localAddress = sun.nio.ch.Net.localAddress(r14.fd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0114, code lost:
        return f135assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        readerCleanup();
        end(f135assertionsDisabled);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (f135assertionsDisabled != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (sun.nio.ch.IOStatus.check(0) != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x005f, code lost:
        return f135assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0078, code lost:
        r0 = r1.getAddress();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0080, code lost:
        if (r0.isAnyLocalAddress() == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0082, code lost:
        r0 = java.net.InetAddress.getLocalHost();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0086, code lost:
        r3 = sun.nio.ch.Net.connect(r14.fd, r0, r1.getPort());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0091, code lost:
        if (r3 != -3) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0097, code lost:
        if (isOpen() != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        readerCleanup();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x009c, code lost:
        if (r3 > 0) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x009f, code lost:
        if (r3 != -2) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a1, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a2, code lost:
        end(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00a7, code lost:
        if (f135assertionsDisabled != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ad, code lost:
        if (sun.nio.ch.IOStatus.check(r3) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00b4, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00d5, code lost:
        r6 = f135assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r7 = r14.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x00dc, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r14.remoteAddress = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean connect(java.net.SocketAddress r15) throws java.io.IOException {
        /*
            r14 = this;
            r2 = 0
            java.lang.Object r8 = r14.readLock
            monitor-enter(r8)
            java.lang.Object r9 = r14.writeLock     // Catch:{ all -> 0x0058 }
            monitor-enter(r9)     // Catch:{ all -> 0x0058 }
            r14.ensureOpenAndUnconnected()     // Catch:{ all -> 0x0055 }
            java.net.InetSocketAddress r1 = sun.nio.ch.Net.checkAddress(r15)     // Catch:{ all -> 0x0055 }
            java.lang.SecurityManager r4 = java.lang.System.getSecurityManager()     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x0023
            java.net.InetAddress r6 = r1.getAddress()     // Catch:{ all -> 0x0055 }
            java.lang.String r6 = r6.getHostAddress()     // Catch:{ all -> 0x0055 }
            int r7 = r1.getPort()     // Catch:{ all -> 0x0055 }
            r4.checkConnect(r6, r7)     // Catch:{ all -> 0x0055 }
        L_0x0023:
            java.lang.Object r10 = r14.blockingLock()     // Catch:{ all -> 0x0055 }
            monitor-enter(r10)     // Catch:{ all -> 0x0055 }
            r3 = 0
            r14.begin()     // Catch:{ all -> 0x00b8 }
            java.lang.Object r7 = r14.stateLock     // Catch:{ all -> 0x00b8 }
            monitor-enter(r7)     // Catch:{ all -> 0x00b8 }
            boolean r6 = r14.isOpen()     // Catch:{ all -> 0x00b5 }
            if (r6 != 0) goto L_0x0060
            monitor-exit(r7)     // Catch:{ all -> 0x00b8 }
            r14.readerCleanup()     // Catch:{ IOException -> 0x004d }
            r6 = 0
            r14.end(r6)     // Catch:{ IOException -> 0x004d }
            boolean r6 = f135assertionsDisabled     // Catch:{ IOException -> 0x004d }
            if (r6 != 0) goto L_0x005b
            boolean r6 = sun.nio.ch.IOStatus.check((int) r3)     // Catch:{ IOException -> 0x004d }
            if (r6 != 0) goto L_0x005b
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch:{ IOException -> 0x004d }
            r6.<init>()     // Catch:{ IOException -> 0x004d }
            throw r6     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            r5 = move-exception
            r14.close()     // Catch:{ all -> 0x0052 }
            throw r5     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r6 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            throw r6     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r6 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0058 }
            throw r6     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r6 = move-exception
            monitor-exit(r8)
            throw r6
        L_0x005b:
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            monitor-exit(r9)     // Catch:{ all -> 0x0058 }
            r6 = 0
            monitor-exit(r8)
            return r6
        L_0x0060:
            java.net.InetSocketAddress r6 = r14.localAddress     // Catch:{ all -> 0x00b5 }
            if (r6 != 0) goto L_0x0071
            java.io.FileDescriptor r6 = r14.fd     // Catch:{ all -> 0x00b5 }
            java.net.InetAddress r11 = r1.getAddress()     // Catch:{ all -> 0x00b5 }
            int r12 = r1.getPort()     // Catch:{ all -> 0x00b5 }
            sun.net.NetHooks.beforeTcpConnect(r6, r11, r12)     // Catch:{ all -> 0x00b5 }
        L_0x0071:
            long r12 = sun.nio.ch.NativeThread.current()     // Catch:{ all -> 0x00b5 }
            r14.readerThread = r12     // Catch:{ all -> 0x00b5 }
            monitor-exit(r7)     // Catch:{ all -> 0x00b8 }
        L_0x0078:
            java.net.InetAddress r0 = r1.getAddress()     // Catch:{ all -> 0x00b8 }
            boolean r6 = r0.isAnyLocalAddress()     // Catch:{ all -> 0x00b8 }
            if (r6 == 0) goto L_0x0086
            java.net.InetAddress r0 = java.net.InetAddress.getLocalHost()     // Catch:{ all -> 0x00b8 }
        L_0x0086:
            java.io.FileDescriptor r6 = r14.fd     // Catch:{ all -> 0x00b8 }
            int r7 = r1.getPort()     // Catch:{ all -> 0x00b8 }
            int r3 = sun.nio.ch.Net.connect(r6, r0, r7)     // Catch:{ all -> 0x00b8 }
            r6 = -3
            if (r3 != r6) goto L_0x0099
            boolean r6 = r14.isOpen()     // Catch:{ all -> 0x00b8 }
            if (r6 != 0) goto L_0x0078
        L_0x0099:
            r14.readerCleanup()     // Catch:{ IOException -> 0x004d }
            if (r3 > 0) goto L_0x00a1
            r6 = -2
            if (r3 != r6) goto L_0x00d5
        L_0x00a1:
            r6 = 1
        L_0x00a2:
            r14.end(r6)     // Catch:{ IOException -> 0x004d }
            boolean r6 = f135assertionsDisabled     // Catch:{ IOException -> 0x004d }
            if (r6 != 0) goto L_0x00da
            boolean r6 = sun.nio.ch.IOStatus.check((int) r3)     // Catch:{ IOException -> 0x004d }
            if (r6 != 0) goto L_0x00da
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch:{ IOException -> 0x004d }
            r6.<init>()     // Catch:{ IOException -> 0x004d }
            throw r6     // Catch:{ IOException -> 0x004d }
        L_0x00b5:
            r6 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00b8 }
            throw r6     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r6 = move-exception
            r14.readerCleanup()     // Catch:{ IOException -> 0x004d }
            if (r3 > 0) goto L_0x00c1
            r7 = -2
            if (r3 != r7) goto L_0x00d7
        L_0x00c1:
            r7 = 1
        L_0x00c2:
            r14.end(r7)     // Catch:{ IOException -> 0x004d }
            boolean r7 = f135assertionsDisabled     // Catch:{ IOException -> 0x004d }
            if (r7 != 0) goto L_0x00d9
            boolean r7 = sun.nio.ch.IOStatus.check((int) r3)     // Catch:{ IOException -> 0x004d }
            if (r7 != 0) goto L_0x00d9
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch:{ IOException -> 0x004d }
            r6.<init>()     // Catch:{ IOException -> 0x004d }
            throw r6     // Catch:{ IOException -> 0x004d }
        L_0x00d5:
            r6 = 0
            goto L_0x00a2
        L_0x00d7:
            r7 = 0
            goto L_0x00c2
        L_0x00d9:
            throw r6     // Catch:{ IOException -> 0x004d }
        L_0x00da:
            java.lang.Object r7 = r14.stateLock     // Catch:{ all -> 0x0052 }
            monitor-enter(r7)     // Catch:{ all -> 0x0052 }
            r14.remoteAddress = r1     // Catch:{ all -> 0x0115 }
            if (r3 <= 0) goto L_0x00f8
            r6 = 2
            r14.state = r6     // Catch:{ all -> 0x0115 }
            boolean r6 = r14.isOpen()     // Catch:{ all -> 0x0115 }
            if (r6 == 0) goto L_0x00f2
            java.io.FileDescriptor r6 = r14.fd     // Catch:{ all -> 0x0115 }
            java.net.InetSocketAddress r6 = sun.nio.ch.Net.localAddress(r6)     // Catch:{ all -> 0x0115 }
            r14.localAddress = r6     // Catch:{ all -> 0x0115 }
        L_0x00f2:
            monitor-exit(r7)     // Catch:{ all -> 0x0052 }
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            monitor-exit(r9)     // Catch:{ all -> 0x0058 }
            r6 = 1
            monitor-exit(r8)
            return r6
        L_0x00f8:
            boolean r6 = r14.isBlocking()     // Catch:{ all -> 0x0115 }
            if (r6 != 0) goto L_0x010f
            r6 = 1
            r14.state = r6     // Catch:{ all -> 0x0115 }
            boolean r6 = r14.isOpen()     // Catch:{ all -> 0x0115 }
            if (r6 == 0) goto L_0x010f
            java.io.FileDescriptor r6 = r14.fd     // Catch:{ all -> 0x0115 }
            java.net.InetSocketAddress r6 = sun.nio.ch.Net.localAddress(r6)     // Catch:{ all -> 0x0115 }
            r14.localAddress = r6     // Catch:{ all -> 0x0115 }
        L_0x010f:
            monitor-exit(r7)     // Catch:{ all -> 0x0052 }
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            monitor-exit(r9)     // Catch:{ all -> 0x0058 }
            r6 = 0
            monitor-exit(r8)
            return r6
        L_0x0115:
            r6 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0052 }
            throw r6     // Catch:{ all -> 0x0052 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.connect(java.net.SocketAddress):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r7 = r14.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x00a7, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r14.readerThread = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x00ae, code lost:
        if (r14.state != 3) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x00b0, code lost:
        kill();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x00b3, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x00b5, code lost:
        if (r0 > 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x00b7, code lost:
        if (r0 != -2) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x00b9, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        end(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x00bf, code lost:
        if (f135assertionsDisabled != false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x00c5, code lost:
        if (sun.nio.ch.IOStatus.check(r0) != false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x00cc, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x00d3, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x00d6, code lost:
        monitor-enter(r14.stateLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r14.readerThread = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x00dd, code lost:
        if (r14.state == 3) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x00df, code lost:
        kill();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x00e2, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x00e8, code lost:
        end(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x00ed, code lost:
        if (f135assertionsDisabled != false) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x00fa, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        r0 = checkConnect(r14.fd, true, r14.readyToConnect);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0104, code lost:
        if (r0 == 0) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0107, code lost:
        if (r0 != -3) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x010d, code lost:
        if (isOpen() == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0113, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0118, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x011a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x011b, code lost:
        if (r0 <= 0) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        r4 = r14.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x011f, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        r14.state = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0127, code lost:
        if (isOpen() == false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0129, code lost:
        r14.localAddress = sun.nio.ch.Net.localAddress(r14.fd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:?, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0134, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x013a, code lost:
        return f135assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0036, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        begin();
        r7 = blockingLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x003e, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r8 = r14.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0041, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0046, code lost:
        if (isOpen() != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r9 = r14.stateLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x004c, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r14.readerThread = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0053, code lost:
        if (r14.state != 3) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0055, code lost:
        kill();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0058, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x005a, code lost:
        if (0 < 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x005c, code lost:
        if (-2 != 0) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        end(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0063, code lost:
        if (f135assertionsDisabled != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0069, code lost:
        if (sun.nio.ch.IOStatus.check(r0) != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0070, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0075, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0079, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x007d, code lost:
        return f135assertionsDisabled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r14.readerThread = sun.nio.ch.NativeThread.current();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0085, code lost:
        dalvik.system.BlockGuard.getThreadPolicy().onNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0090, code lost:
        if (isBlocking() != false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0092, code lost:
        r0 = checkConnect(r14.fd, f135assertionsDisabled, r14.readyToConnect);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x009c, code lost:
        if (r0 != -3) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x00a2, code lost:
        if (isOpen() != false) goto L_0x0092;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:140:0x00e3=Splitter:B:140:0x00e3, B:115:0x00ba=Splitter:B:115:0x00ba, B:68:0x005e=Splitter:B:68:0x005e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean finishConnect() throws java.io.IOException {
        /*
            r14 = this;
            r13 = 3
            r12 = -2
            r3 = 1
            r4 = 0
            java.lang.Object r5 = r14.readLock
            monitor-enter(r5)
            java.lang.Object r6 = r14.writeLock     // Catch:{ all -> 0x001f }
            monitor-enter(r6)     // Catch:{ all -> 0x001f }
            java.lang.Object r7 = r14.stateLock     // Catch:{ all -> 0x001c }
            monitor-enter(r7)     // Catch:{ all -> 0x001c }
            boolean r2 = r14.isOpen()     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x0022
            java.nio.channels.ClosedChannelException r2 = new java.nio.channels.ClosedChannelException     // Catch:{ all -> 0x0019 }
            r2.<init>()     // Catch:{ all -> 0x0019 }
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r2 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x001c:
            r2 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x001f }
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r2 = move-exception
            monitor-exit(r5)
            throw r2
        L_0x0022:
            int r2 = r14.state     // Catch:{ all -> 0x0019 }
            r8 = 2
            if (r2 != r8) goto L_0x002b
            monitor-exit(r7)     // Catch:{ all -> 0x001c }
            monitor-exit(r6)     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r3
        L_0x002b:
            int r2 = r14.state     // Catch:{ all -> 0x0019 }
            if (r2 == r3) goto L_0x0035
            java.nio.channels.NoConnectionPendingException r2 = new java.nio.channels.NoConnectionPendingException     // Catch:{ all -> 0x0019 }
            r2.<init>()     // Catch:{ all -> 0x0019 }
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0035:
            monitor-exit(r7)     // Catch:{ all -> 0x001c }
            r0 = 0
            r14.begin()     // Catch:{  }
            java.lang.Object r7 = r14.blockingLock()     // Catch:{  }
            monitor-enter(r7)     // Catch:{  }
            java.lang.Object r8 = r14.stateLock     // Catch:{ all -> 0x00d0 }
            monitor-enter(r8)     // Catch:{ all -> 0x00d0 }
            boolean r2 = r14.isOpen()     // Catch:{  }
            if (r2 != 0) goto L_0x007e
            monitor-exit(r8)     // Catch:{ all -> 0x00d0 }
            monitor-exit(r7)     // Catch:{  }
            java.lang.Object r9 = r14.stateLock     // Catch:{ IOException -> 0x0071 }
            monitor-enter(r9)     // Catch:{ IOException -> 0x0071 }
            r10 = 0
            r14.readerThread = r10     // Catch:{ all -> 0x0076 }
            int r2 = r14.state     // Catch:{ all -> 0x0076 }
            if (r2 != r13) goto L_0x0059
            r14.kill()     // Catch:{ all -> 0x0076 }
            r0 = 0
        L_0x0059:
            monitor-exit(r9)     // Catch:{ all -> 0x00cd }
            if (r4 < 0) goto L_0x005e
            if (r12 != 0) goto L_0x0079
        L_0x005e:
            r14.end(r3)     // Catch:{ IOException -> 0x0071 }
            boolean r2 = f135assertionsDisabled     // Catch:{ IOException -> 0x0071 }
            if (r2 != 0) goto L_0x007b
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ IOException -> 0x0071 }
            if (r2 != 0) goto L_0x007b
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ IOException -> 0x0071 }
            r2.<init>()     // Catch:{ IOException -> 0x0071 }
            throw r2     // Catch:{ IOException -> 0x0071 }
        L_0x0071:
            r1 = move-exception
            r14.close()     // Catch:{ all -> 0x001c }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0076:
            r2 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00cd }
            throw r2     // Catch:{ IOException -> 0x0071 }
        L_0x0079:
            r3 = r4
            goto L_0x005e
        L_0x007b:
            monitor-exit(r6)     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r4
        L_0x007e:
            long r10 = sun.nio.ch.NativeThread.current()     // Catch:{  }
            r14.readerThread = r10     // Catch:{  }
            monitor-exit(r8)     // Catch:{ all -> 0x00d0 }
            dalvik.system.BlockGuard$Policy r2 = dalvik.system.BlockGuard.getThreadPolicy()     // Catch:{ all -> 0x00d0 }
            r2.onNetwork()     // Catch:{ all -> 0x00d0 }
            boolean r2 = r14.isBlocking()     // Catch:{ all -> 0x00d0 }
            if (r2 != 0) goto L_0x00fb
        L_0x0092:
            java.io.FileDescriptor r2 = r14.fd     // Catch:{ all -> 0x00d0 }
            boolean r8 = r14.readyToConnect     // Catch:{ all -> 0x00d0 }
            r9 = 0
            int r0 = checkConnect(r2, r9, r8)     // Catch:{ all -> 0x00d0 }
            r2 = -3
            if (r0 != r2) goto L_0x00a4
            boolean r2 = r14.isOpen()     // Catch:{ all -> 0x00d0 }
            if (r2 != 0) goto L_0x0092
        L_0x00a4:
            monitor-exit(r7)     // Catch:{  }
            java.lang.Object r7 = r14.stateLock     // Catch:{ IOException -> 0x0071 }
            monitor-enter(r7)     // Catch:{ IOException -> 0x0071 }
            r8 = 0
            r14.readerThread = r8     // Catch:{ all -> 0x0110 }
            int r2 = r14.state     // Catch:{ all -> 0x0110 }
            if (r2 != r13) goto L_0x00b4
            r14.kill()     // Catch:{ all -> 0x0110 }
            r0 = 0
        L_0x00b4:
            monitor-exit(r7)     // Catch:{ all -> 0x00d3 }
            if (r0 > 0) goto L_0x00b9
            if (r0 != r12) goto L_0x0113
        L_0x00b9:
            r2 = r3
        L_0x00ba:
            r14.end(r2)     // Catch:{ IOException -> 0x0071 }
            boolean r2 = f135assertionsDisabled     // Catch:{ IOException -> 0x0071 }
            if (r2 != 0) goto L_0x011b
            boolean r2 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ IOException -> 0x0071 }
            if (r2 != 0) goto L_0x011b
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ IOException -> 0x0071 }
            r2.<init>()     // Catch:{ IOException -> 0x0071 }
            throw r2     // Catch:{ IOException -> 0x0071 }
        L_0x00cd:
            r2 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00d0 }
            throw r2     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r2 = move-exception
            monitor-exit(r7)     // Catch:{  }
            throw r2     // Catch:{  }
        L_0x00d3:
            r2 = move-exception
            java.lang.Object r7 = r14.stateLock     // Catch:{ IOException -> 0x0071 }
            monitor-enter(r7)     // Catch:{ IOException -> 0x0071 }
            r8 = 0
            r14.readerThread = r8     // Catch:{ all -> 0x0115 }
            int r8 = r14.state     // Catch:{ all -> 0x0115 }
            if (r8 != r13) goto L_0x00e3
            r14.kill()     // Catch:{ all -> 0x0115 }
            r0 = 0
        L_0x00e3:
            monitor-exit(r7)     // Catch:{ IOException -> 0x0071 }
            if (r0 > 0) goto L_0x00e8
            if (r0 != r12) goto L_0x0118
        L_0x00e8:
            r14.end(r3)     // Catch:{ IOException -> 0x0071 }
            boolean r3 = f135assertionsDisabled     // Catch:{ IOException -> 0x0071 }
            if (r3 != 0) goto L_0x011a
            boolean r3 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ IOException -> 0x0071 }
            if (r3 != 0) goto L_0x011a
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ IOException -> 0x0071 }
            r2.<init>()     // Catch:{ IOException -> 0x0071 }
            throw r2     // Catch:{ IOException -> 0x0071 }
        L_0x00fb:
            java.io.FileDescriptor r2 = r14.fd     // Catch:{ all -> 0x00d0 }
            boolean r8 = r14.readyToConnect     // Catch:{ all -> 0x00d0 }
            r9 = 1
            int r0 = checkConnect(r2, r9, r8)     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x00fb
            r2 = -3
            if (r0 != r2) goto L_0x00a4
            boolean r2 = r14.isOpen()     // Catch:{ all -> 0x00d0 }
            if (r2 == 0) goto L_0x00a4
            goto L_0x00fb
        L_0x0110:
            r2 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00d3 }
            throw r2     // Catch:{ IOException -> 0x0071 }
        L_0x0113:
            r2 = r4
            goto L_0x00ba
        L_0x0115:
            r2 = move-exception
            monitor-exit(r7)     // Catch:{ IOException -> 0x0071 }
            throw r2     // Catch:{ IOException -> 0x0071 }
        L_0x0118:
            r3 = r4
            goto L_0x00e8
        L_0x011a:
            throw r2     // Catch:{ IOException -> 0x0071 }
        L_0x011b:
            if (r0 <= 0) goto L_0x0138
            java.lang.Object r4 = r14.stateLock     // Catch:{ all -> 0x001c }
            monitor-enter(r4)     // Catch:{ all -> 0x001c }
            r2 = 2
            r14.state = r2     // Catch:{ all -> 0x0135 }
            boolean r2 = r14.isOpen()     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x0131
            java.io.FileDescriptor r2 = r14.fd     // Catch:{ all -> 0x0135 }
            java.net.InetSocketAddress r2 = sun.nio.ch.Net.localAddress(r2)     // Catch:{ all -> 0x0135 }
            r14.localAddress = r2     // Catch:{ all -> 0x0135 }
        L_0x0131:
            monitor-exit(r4)     // Catch:{ all -> 0x001c }
            monitor-exit(r6)     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r3
        L_0x0135:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0138:
            monitor-exit(r6)     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.finishConnect():boolean");
    }

    public SocketChannel shutdownInput() throws IOException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (!isConnected()) {
                throw new NotYetConnectedException();
            } else if (this.isInputOpen) {
                Net.shutdown(this.fd, 0);
                if (this.readerThread != 0) {
                    NativeThread.signal(this.readerThread);
                }
                this.isInputOpen = f135assertionsDisabled;
            }
        }
        return this;
    }

    public SocketChannel shutdownOutput() throws IOException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (!isConnected()) {
                throw new NotYetConnectedException();
            } else if (this.isOutputOpen) {
                Net.shutdown(this.fd, 1);
                if (this.writerThread != 0) {
                    NativeThread.signal(this.writerThread);
                }
                this.isOutputOpen = f135assertionsDisabled;
            }
        }
        return this;
    }

    public boolean isInputOpen() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isInputOpen;
        }
        return z;
    }

    public boolean isOutputOpen() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isOutputOpen;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void implCloseSelectableChannel() throws IOException {
        synchronized (this.stateLock) {
            this.isInputOpen = f135assertionsDisabled;
            this.isOutputOpen = f135assertionsDisabled;
            if (this.state != 4) {
                nd.preClose(this.fd);
            }
            if (this.readerThread != 0) {
                NativeThread.signal(this.readerThread);
            }
            if (this.writerThread != 0) {
                NativeThread.signal(this.writerThread);
            }
            if (!isRegistered()) {
                kill();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void kill() throws java.io.IOException {
        /*
            r6 = this;
            r4 = 0
            r0 = 0
            r3 = 4
            java.lang.Object r1 = r6.stateLock
            monitor-enter(r1)
            int r2 = r6.state     // Catch:{ all -> 0x002f }
            if (r2 != r3) goto L_0x000d
            monitor-exit(r1)
            return
        L_0x000d:
            int r2 = r6.state     // Catch:{ all -> 0x002f }
            r3 = -1
            if (r2 != r3) goto L_0x0017
            r0 = 4
            r6.state = r0     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return
        L_0x0017:
            boolean r2 = f135assertionsDisabled     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0034
            boolean r2 = r6.isOpen()     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0027
            boolean r2 = r6.isRegistered()     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x0032
        L_0x0027:
            if (r0 != 0) goto L_0x0034
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x002f }
            r0.<init>()     // Catch:{ all -> 0x002f }
            throw r0     // Catch:{ all -> 0x002f }
        L_0x002f:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0032:
            r0 = 1
            goto L_0x0027
        L_0x0034:
            long r2 = r6.readerThread     // Catch:{ all -> 0x002f }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x004c
            long r2 = r6.writerThread     // Catch:{ all -> 0x002f }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x004c
            sun.nio.ch.NativeDispatcher r0 = nd     // Catch:{ all -> 0x002f }
            java.io.FileDescriptor r2 = r6.fd     // Catch:{ all -> 0x002f }
            r0.close(r2)     // Catch:{ all -> 0x002f }
            r0 = 4
            r6.state = r0     // Catch:{ all -> 0x002f }
        L_0x004a:
            monitor-exit(r1)
            return
        L_0x004c:
            r0 = 3
            r6.state = r0     // Catch:{ all -> 0x002f }
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.kill():void");
    }

    public boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
        int intOps = sk.nioInterestOps();
        int oldOps = sk.nioReadyOps();
        int newOps = initialOps;
        if ((ops & 32) != 0) {
            return f135assertionsDisabled;
        }
        if ((ops & 24) != 0) {
            int newOps2 = intOps;
            sk.nioReadyOps(intOps);
            this.readyToConnect = true;
            if (((~oldOps) & intOps) != 0) {
                return true;
            }
            return f135assertionsDisabled;
        }
        if (!((ops & 1) == 0 || (intOps & 1) == 0 || this.state != 2)) {
            newOps = initialOps | 1;
        }
        if (!((ops & 4) == 0 || (intOps & 8) == 0 || (this.state != 0 && this.state != 1))) {
            newOps |= 8;
            this.readyToConnect = true;
        }
        if (!((ops & 4) == 0 || (intOps & 4) == 0 || this.state != 2)) {
            newOps |= 4;
        }
        sk.nioReadyOps(newOps);
        if (((~oldOps) & newOps) != 0) {
            return true;
        }
        return f135assertionsDisabled;
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
            newOps |= 4;
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
        sb.append(getClass().getSuperclass().getName());
        sb.append('[');
        if (!isOpen()) {
            sb.append("closed");
        } else {
            synchronized (this.stateLock) {
                switch (this.state) {
                    case 0:
                        sb.append("unconnected");
                        break;
                    case 1:
                        sb.append("connection-pending");
                        break;
                    case 2:
                        sb.append("connected");
                        if (!this.isInputOpen) {
                            sb.append(" ishut");
                        }
                        if (!this.isOutputOpen) {
                            sb.append(" oshut");
                            break;
                        }
                        break;
                }
                InetSocketAddress addr = localAddress();
                if (addr != null) {
                    sb.append(" local=");
                    sb.append(Net.getRevealedLocalAddressAsString(addr));
                }
                if (remoteAddress() != null) {
                    sb.append(" remote=");
                    sb.append(remoteAddress().toString());
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
