package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channels;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class SocketAdaptor extends Socket {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f134assertionsDisabled = false;
    /* access modifiers changed from: private */
    public final SocketChannelImpl sc;
    private InputStream socketInputStream = null;
    /* access modifiers changed from: private */
    public volatile int timeout = 0;

    private SocketAdaptor(SocketChannelImpl sc2) throws SocketException {
        super((SocketImpl) new FileDescriptorHolderSocketImpl(sc2.getFD()));
        this.sc = sc2;
    }

    public static Socket create(SocketChannelImpl sc2) {
        try {
            return new SocketAdaptor(sc2);
        } catch (SocketException e) {
            throw new InternalError("Should not reach here");
        }
    }

    public SocketChannel getChannel() {
        return this.sc;
    }

    public void connect(SocketAddress remote) throws IOException {
        connect(remote, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        sun.nio.ch.Net.translateException(r11, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0074, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009a, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009b, code lost:
        if (r5 != null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r5.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a8, code lost:
        if (r16.sc.isOpen() != false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00aa, code lost:
        r16.sc.configureBlocking(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b2, code lost:
        if (r4 != null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b4, code lost:
        sun.nio.ch.Util.releaseTemporarySelector(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b7, code lost:
        throw r12;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:24:0x0040, B:78:0x00f0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(java.net.SocketAddress r17, int r18) throws java.io.IOException {
        /*
            r16 = this;
            if (r17 != 0) goto L_0x000b
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "connect: The address can't be null"
            r12.<init>((java.lang.String) r13)
            throw r12
        L_0x000b:
            if (r18 >= 0) goto L_0x0016
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "connect: timeout can't be negative"
            r12.<init>((java.lang.String) r13)
            throw r12
        L_0x0016:
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc
            java.lang.Object r13 = r12.blockingLock()
            monitor-enter(r13)
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ all -> 0x002f }
            boolean r12 = r12.isBlocking()     // Catch:{ all -> 0x002f }
            if (r12 != 0) goto L_0x0032
            java.nio.channels.IllegalBlockingModeException r12 = new java.nio.channels.IllegalBlockingModeException     // Catch:{ all -> 0x002f }
            r12.<init>()     // Catch:{ all -> 0x002f }
            throw r12     // Catch:{ all -> 0x002f }
        L_0x002f:
            r12 = move-exception
            monitor-exit(r13)
            throw r12
        L_0x0032:
            if (r18 != 0) goto L_0x004b
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ Exception -> 0x003f }
            r0 = r17
            r12.connect(r0)     // Catch:{ Exception -> 0x003f }
        L_0x003d:
            monitor-exit(r13)
            return
        L_0x003f:
            r2 = move-exception
            sun.nio.ch.Net.translateException(r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x003d
        L_0x0044:
            r11 = move-exception
            r12 = 1
            sun.nio.ch.Net.translateException(r11, r12)     // Catch:{ all -> 0x002f }
        L_0x0049:
            monitor-exit(r13)
            return
        L_0x004b:
            r5 = 0
            r4 = 0
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ Exception -> 0x0044 }
            r14 = 0
            r12.configureBlocking(r14)     // Catch:{ Exception -> 0x0044 }
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ all -> 0x009a }
            r0 = r17
            boolean r12 = r12.connect(r0)     // Catch:{ all -> 0x009a }
            if (r12 == 0) goto L_0x0075
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ Exception -> 0x0044 }
            boolean r12 = r12.isOpen()     // Catch:{ Exception -> 0x0044 }
            if (r12 == 0) goto L_0x0073
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ Exception -> 0x0044 }
            r14 = 1
            r12.configureBlocking(r14)     // Catch:{ Exception -> 0x0044 }
        L_0x0073:
            monitor-exit(r13)
            return
        L_0x0075:
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ all -> 0x009a }
            java.nio.channels.Selector r4 = sun.nio.ch.Util.getTemporarySelector(r12)     // Catch:{ all -> 0x009a }
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ all -> 0x009a }
            r14 = 8
            java.nio.channels.SelectionKey r5 = r12.register(r4, r14)     // Catch:{ all -> 0x009a }
            r0 = r18
            long r8 = (long) r0     // Catch:{ all -> 0x009a }
        L_0x008a:
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ all -> 0x009a }
            boolean r12 = r12.isOpen()     // Catch:{ all -> 0x009a }
            if (r12 != 0) goto L_0x00b8
            java.nio.channels.ClosedChannelException r12 = new java.nio.channels.ClosedChannelException     // Catch:{ all -> 0x009a }
            r12.<init>()     // Catch:{ all -> 0x009a }
            throw r12     // Catch:{ all -> 0x009a }
        L_0x009a:
            r12 = move-exception
            if (r5 == 0) goto L_0x00a0
            r5.cancel()     // Catch:{ Exception -> 0x0044 }
        L_0x00a0:
            r0 = r16
            sun.nio.ch.SocketChannelImpl r14 = r0.sc     // Catch:{ Exception -> 0x0044 }
            boolean r14 = r14.isOpen()     // Catch:{ Exception -> 0x0044 }
            if (r14 == 0) goto L_0x00b2
            r0 = r16
            sun.nio.ch.SocketChannelImpl r14 = r0.sc     // Catch:{ Exception -> 0x0044 }
            r15 = 1
            r14.configureBlocking(r15)     // Catch:{ Exception -> 0x0044 }
        L_0x00b2:
            if (r4 == 0) goto L_0x00b7
            sun.nio.ch.Util.releaseTemporarySelector(r4)     // Catch:{ Exception -> 0x0044 }
        L_0x00b7:
            throw r12     // Catch:{ Exception -> 0x0044 }
        L_0x00b8:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009a }
            int r3 = r4.select(r8)     // Catch:{ all -> 0x009a }
            if (r3 <= 0) goto L_0x00f0
            boolean r12 = r5.isConnectable()     // Catch:{ all -> 0x009a }
            if (r12 == 0) goto L_0x00f0
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ all -> 0x009a }
            boolean r12 = r12.finishConnect()     // Catch:{ all -> 0x009a }
            if (r12 == 0) goto L_0x00f0
            if (r5 == 0) goto L_0x00d7
            r5.cancel()     // Catch:{ Exception -> 0x0044 }
        L_0x00d7:
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ Exception -> 0x0044 }
            boolean r12 = r12.isOpen()     // Catch:{ Exception -> 0x0044 }
            if (r12 == 0) goto L_0x00e9
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ Exception -> 0x0044 }
            r14 = 1
            r12.configureBlocking(r14)     // Catch:{ Exception -> 0x0044 }
        L_0x00e9:
            if (r4 == 0) goto L_0x0049
            sun.nio.ch.Util.releaseTemporarySelector(r4)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0049
        L_0x00f0:
            java.util.Set r12 = r4.selectedKeys()     // Catch:{ all -> 0x009a }
            r12.remove(r5)     // Catch:{ all -> 0x009a }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009a }
            long r14 = r14 - r6
            long r8 = r8 - r14
            r14 = 0
            int r12 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r12 > 0) goto L_0x008a
            r0 = r16
            sun.nio.ch.SocketChannelImpl r12 = r0.sc     // Catch:{ IOException -> 0x0110 }
            r12.close()     // Catch:{ IOException -> 0x0110 }
        L_0x010a:
            java.net.SocketTimeoutException r12 = new java.net.SocketTimeoutException     // Catch:{ all -> 0x009a }
            r12.<init>()     // Catch:{ all -> 0x009a }
            throw r12     // Catch:{ all -> 0x009a }
        L_0x0110:
            r10 = move-exception
            goto L_0x010a
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketAdaptor.connect(java.net.SocketAddress, int):void");
    }

    public void bind(SocketAddress local) throws IOException {
        try {
            this.sc.bind(local);
        } catch (Exception x) {
            Net.translateException(x);
        }
    }

    public InetAddress getInetAddress() {
        SocketAddress remote;
        if (isConnected() && (remote = this.sc.remoteAddress()) != null) {
            return ((InetSocketAddress) remote).getAddress();
        }
        return null;
    }

    public InetAddress getLocalAddress() {
        InetSocketAddress local;
        if (!this.sc.isOpen() || (local = this.sc.localAddress()) == null) {
            return new InetSocketAddress(0).getAddress();
        }
        return Net.getRevealedLocalAddress(local).getAddress();
    }

    public int getPort() {
        SocketAddress remote;
        if (isConnected() && (remote = this.sc.remoteAddress()) != null) {
            return ((InetSocketAddress) remote).getPort();
        }
        return 0;
    }

    public int getLocalPort() {
        SocketAddress local = this.sc.localAddress();
        if (local == null) {
            return -1;
        }
        return ((InetSocketAddress) local).getPort();
    }

    private class SocketInputStream extends ChannelInputStream {
        /* synthetic */ SocketInputStream(SocketAdaptor this$02, SocketInputStream socketInputStream) {
            this();
        }

        private SocketInputStream() {
            super(SocketAdaptor.this.sc);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009b, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x017e, code lost:
            return r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read(java.nio.ByteBuffer r19) throws java.io.IOException {
            /*
                r18 = this;
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this
                sun.nio.ch.SocketChannelImpl r3 = r3.sc
                java.lang.Object r17 = r3.blockingLock()
                monitor-enter(r17)
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                boolean r3 = r3.isBlocking()     // Catch:{ all -> 0x0021 }
                if (r3 != 0) goto L_0x0024
                java.nio.channels.IllegalBlockingModeException r3 = new java.nio.channels.IllegalBlockingModeException     // Catch:{ all -> 0x0021 }
                r3.<init>()     // Catch:{ all -> 0x0021 }
                throw r3     // Catch:{ all -> 0x0021 }
            L_0x0021:
                r3 = move-exception
                monitor-exit(r17)
                throw r3
            L_0x0024:
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                int r3 = r3.timeout     // Catch:{ all -> 0x0021 }
                if (r3 != 0) goto L_0x003e
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                r0 = r19
                int r3 = r3.read(r0)     // Catch:{ all -> 0x0021 }
                monitor-exit(r17)
                return r3
            L_0x003e:
                r11 = 0
                r10 = 0
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                r4 = 0
                r3.configureBlocking(r4)     // Catch:{ all -> 0x0021 }
                r8 = 0
                java.lang.Object r2 = sun.misc.IoTrace.socketReadBegin()     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x00d4 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x00d4 }
                r0 = r19
                int r8 = r3.read(r0)     // Catch:{ all -> 0x00d4 }
                if (r8 == 0) goto L_0x009e
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                java.net.InetAddress r3 = r3.getInetAddress()     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r4 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                int r4 = r4.getPort()     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r5 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                int r5 = r5.timeout     // Catch:{ all -> 0x0021 }
                if (r8 <= 0) goto L_0x009c
                r6 = r8
            L_0x007c:
                long r6 = (long) r6     // Catch:{ all -> 0x0021 }
                sun.misc.IoTrace.socketReadEnd(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                boolean r3 = r3.isOpen()     // Catch:{ all -> 0x0021 }
                if (r3 == 0) goto L_0x009a
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                r4 = 1
                r3.configureBlocking(r4)     // Catch:{ all -> 0x0021 }
            L_0x009a:
                monitor-exit(r17)
                return r8
            L_0x009c:
                r6 = 0
                goto L_0x007c
            L_0x009e:
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x00d4 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x00d4 }
                java.nio.channels.Selector r10 = sun.nio.ch.Util.getTemporarySelector(r3)     // Catch:{ all -> 0x00d4 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x00d4 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x00d4 }
                r4 = 1
                java.nio.channels.SelectionKey r11 = r3.register(r10, r4)     // Catch:{ all -> 0x00d4 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x00d4 }
                int r3 = r3.timeout     // Catch:{ all -> 0x00d4 }
                long r14 = (long) r3     // Catch:{ all -> 0x00d4 }
            L_0x00c0:
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x00d4 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x00d4 }
                boolean r3 = r3.isOpen()     // Catch:{ all -> 0x00d4 }
                if (r3 != 0) goto L_0x011a
                java.nio.channels.ClosedChannelException r3 = new java.nio.channels.ClosedChannelException     // Catch:{ all -> 0x00d4 }
                r3.<init>()     // Catch:{ all -> 0x00d4 }
                throw r3     // Catch:{ all -> 0x00d4 }
            L_0x00d4:
                r3 = move-exception
                r16 = r3
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                java.net.InetAddress r3 = r3.getInetAddress()     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r4 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                int r4 = r4.getPort()     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r5 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                int r5 = r5.timeout     // Catch:{ all -> 0x0021 }
                if (r8 <= 0) goto L_0x019a
            L_0x00f1:
                long r6 = (long) r8     // Catch:{ all -> 0x0021 }
                sun.misc.IoTrace.socketReadEnd(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0021 }
                if (r11 == 0) goto L_0x00fa
                r11.cancel()     // Catch:{ all -> 0x0021 }
            L_0x00fa:
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                boolean r3 = r3.isOpen()     // Catch:{ all -> 0x0021 }
                if (r3 == 0) goto L_0x0114
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                r4 = 1
                r3.configureBlocking(r4)     // Catch:{ all -> 0x0021 }
            L_0x0114:
                if (r10 == 0) goto L_0x0119
                sun.nio.ch.Util.releaseTemporarySelector(r10)     // Catch:{ all -> 0x0021 }
            L_0x0119:
                throw r16     // Catch:{ all -> 0x0021 }
            L_0x011a:
                long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d4 }
                int r9 = r10.select(r14)     // Catch:{ all -> 0x00d4 }
                if (r9 <= 0) goto L_0x0181
                boolean r3 = r11.isReadable()     // Catch:{ all -> 0x00d4 }
                if (r3 == 0) goto L_0x0181
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x00d4 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x00d4 }
                r0 = r19
                int r8 = r3.read(r0)     // Catch:{ all -> 0x00d4 }
                if (r8 == 0) goto L_0x0181
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                java.net.InetAddress r3 = r3.getInetAddress()     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r4 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                int r4 = r4.getPort()     // Catch:{ all -> 0x0021 }
                r0 = r18
                sun.nio.ch.SocketAdaptor r5 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                int r5 = r5.timeout     // Catch:{ all -> 0x0021 }
                if (r8 <= 0) goto L_0x017f
                r6 = r8
            L_0x0155:
                long r6 = (long) r6     // Catch:{ all -> 0x0021 }
                sun.misc.IoTrace.socketReadEnd(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0021 }
                if (r11 == 0) goto L_0x015e
                r11.cancel()     // Catch:{ all -> 0x0021 }
            L_0x015e:
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                boolean r3 = r3.isOpen()     // Catch:{ all -> 0x0021 }
                if (r3 == 0) goto L_0x0178
                r0 = r18
                sun.nio.ch.SocketAdaptor r3 = sun.nio.ch.SocketAdaptor.this     // Catch:{ all -> 0x0021 }
                sun.nio.ch.SocketChannelImpl r3 = r3.sc     // Catch:{ all -> 0x0021 }
                r4 = 1
                r3.configureBlocking(r4)     // Catch:{ all -> 0x0021 }
            L_0x0178:
                if (r10 == 0) goto L_0x017d
                sun.nio.ch.Util.releaseTemporarySelector(r10)     // Catch:{ all -> 0x0021 }
            L_0x017d:
                monitor-exit(r17)
                return r8
            L_0x017f:
                r6 = 0
                goto L_0x0155
            L_0x0181:
                java.util.Set r3 = r10.selectedKeys()     // Catch:{ all -> 0x00d4 }
                r3.remove(r11)     // Catch:{ all -> 0x00d4 }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d4 }
                long r4 = r4 - r12
                long r14 = r14 - r4
                r4 = 0
                int r3 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
                if (r3 > 0) goto L_0x00c0
                java.net.SocketTimeoutException r3 = new java.net.SocketTimeoutException     // Catch:{ all -> 0x00d4 }
                r3.<init>()     // Catch:{ all -> 0x00d4 }
                throw r3     // Catch:{ all -> 0x00d4 }
            L_0x019a:
                r8 = 0
                goto L_0x00f1
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketAdaptor.SocketInputStream.read(java.nio.ByteBuffer):int");
        }
    }

    public InputStream getInputStream() throws IOException {
        if (!this.sc.isOpen()) {
            throw new SocketException("Socket is closed");
        } else if (!this.sc.isConnected()) {
            throw new SocketException("Socket is not connected");
        } else if (!this.sc.isInputOpen()) {
            throw new SocketException("Socket input is shutdown");
        } else {
            if (this.socketInputStream == null) {
                try {
                    this.socketInputStream = (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() {
                        public InputStream run() throws IOException {
                            return new SocketInputStream(SocketAdaptor.this, (SocketInputStream) null);
                        }
                    });
                } catch (PrivilegedActionException e) {
                    throw ((IOException) e.getException());
                }
            }
            return this.socketInputStream;
        }
    }

    public OutputStream getOutputStream() throws IOException {
        if (!this.sc.isOpen()) {
            throw new SocketException("Socket is closed");
        } else if (!this.sc.isConnected()) {
            throw new SocketException("Socket is not connected");
        } else if (!this.sc.isOutputOpen()) {
            throw new SocketException("Socket output is shutdown");
        } else {
            try {
                return (OutputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<OutputStream>() {
                    public OutputStream run() throws IOException {
                        return Channels.newOutputStream(SocketAdaptor.this.sc);
                    }
                });
            } catch (PrivilegedActionException e) {
                throw ((IOException) e.getException());
            }
        }
    }

    private void setBooleanOption(SocketOption<Boolean> name, boolean value) throws SocketException {
        try {
            this.sc.setOption((SocketOption) name, (Object) Boolean.valueOf(value));
        } catch (IOException x) {
            Net.translateToSocketException(x);
        }
    }

    private void setIntOption(SocketOption<Integer> name, int value) throws SocketException {
        try {
            this.sc.setOption((SocketOption) name, (Object) Integer.valueOf(value));
        } catch (IOException x) {
            Net.translateToSocketException(x);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.net.SocketOption<java.lang.Boolean>, java.net.SocketOption] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean getBooleanOption(java.net.SocketOption<java.lang.Boolean> r3) throws java.net.SocketException {
        /*
            r2 = this;
            sun.nio.ch.SocketChannelImpl r1 = r2.sc     // Catch:{ IOException -> 0x000d }
            java.lang.Object r1 = r1.getOption(r3)     // Catch:{ IOException -> 0x000d }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ IOException -> 0x000d }
            boolean r1 = r1.booleanValue()     // Catch:{ IOException -> 0x000d }
            return r1
        L_0x000d:
            r0 = move-exception
            sun.nio.ch.Net.translateToSocketException(r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketAdaptor.getBooleanOption(java.net.SocketOption):boolean");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.net.SocketOption<java.lang.Integer>, java.net.SocketOption] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getIntOption(java.net.SocketOption<java.lang.Integer> r3) throws java.net.SocketException {
        /*
            r2 = this;
            sun.nio.ch.SocketChannelImpl r1 = r2.sc     // Catch:{ IOException -> 0x000d }
            java.lang.Object r1 = r1.getOption(r3)     // Catch:{ IOException -> 0x000d }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x000d }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x000d }
            return r1
        L_0x000d:
            r0 = move-exception
            sun.nio.ch.Net.translateToSocketException(r0)
            r1 = -1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketAdaptor.getIntOption(java.net.SocketOption):int");
    }

    public void setTcpNoDelay(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.TCP_NODELAY, on);
    }

    public boolean getTcpNoDelay() throws SocketException {
        return getBooleanOption(StandardSocketOptions.TCP_NODELAY);
    }

    public void setSoLinger(boolean on, int linger) throws SocketException {
        if (!on) {
            linger = -1;
        }
        setIntOption(StandardSocketOptions.SO_LINGER, linger);
    }

    public int getSoLinger() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_LINGER);
    }

    public void sendUrgentData(int data) throws IOException {
        boolean z = true;
        synchronized (this.sc.blockingLock()) {
            if (!this.sc.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            int n = this.sc.sendOutOfBandData((byte) data);
            if (!f134assertionsDisabled) {
                if (n != 1) {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
        }
    }

    public void setOOBInline(boolean on) throws SocketException {
        setBooleanOption(ExtendedSocketOption.SO_OOBINLINE, on);
    }

    public boolean getOOBInline() throws SocketException {
        return getBooleanOption(ExtendedSocketOption.SO_OOBINLINE);
    }

    public void setSoTimeout(int timeout2) throws SocketException {
        if (timeout2 < 0) {
            throw new IllegalArgumentException("timeout can't be negative");
        }
        this.timeout = timeout2;
    }

    public int getSoTimeout() throws SocketException {
        return this.timeout;
    }

    public void setSendBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid send size");
        }
        setIntOption(StandardSocketOptions.SO_SNDBUF, size);
    }

    public int getSendBufferSize() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_SNDBUF);
    }

    public void setReceiveBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid receive size");
        }
        setIntOption(StandardSocketOptions.SO_RCVBUF, size);
    }

    public int getReceiveBufferSize() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_RCVBUF);
    }

    public void setKeepAlive(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.SO_KEEPALIVE, on);
    }

    public boolean getKeepAlive() throws SocketException {
        return getBooleanOption(StandardSocketOptions.SO_KEEPALIVE);
    }

    public void setTrafficClass(int tc) throws SocketException {
        setIntOption(StandardSocketOptions.IP_TOS, tc);
    }

    public int getTrafficClass() throws SocketException {
        return getIntOption(StandardSocketOptions.IP_TOS);
    }

    public void setReuseAddress(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.SO_REUSEADDR, on);
    }

    public boolean getReuseAddress() throws SocketException {
        return getBooleanOption(StandardSocketOptions.SO_REUSEADDR);
    }

    public void close() throws IOException {
        this.sc.close();
    }

    public void shutdownInput() throws IOException {
        try {
            this.sc.shutdownInput();
        } catch (Exception x) {
            Net.translateException(x);
        }
    }

    public void shutdownOutput() throws IOException {
        try {
            this.sc.shutdownOutput();
        } catch (Exception x) {
            Net.translateException(x);
        }
    }

    public String toString() {
        if (this.sc.isConnected()) {
            return "Socket[addr=" + getInetAddress() + ",port=" + getPort() + ",localport=" + getLocalPort() + "]";
        }
        return "Socket[unconnected]";
    }

    public boolean isConnected() {
        return this.sc.isConnected();
    }

    public boolean isBound() {
        return this.sc.localAddress() != null;
    }

    public boolean isClosed() {
        return !this.sc.isOpen();
    }

    public boolean isInputShutdown() {
        return !this.sc.isInputOpen();
    }

    public boolean isOutputShutdown() {
        return !this.sc.isOutputOpen();
    }

    public FileDescriptor getFileDescriptor$() {
        return this.sc.getFD();
    }
}
