package java.net;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

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
public class ServerSocket implements Closeable {
    private static SocketImplFactory factory;
    private boolean bound;
    private Object closeLock;
    private boolean closed;
    private boolean created;
    /* access modifiers changed from: private */
    public SocketImpl impl;
    private boolean oldImpl;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.net.ServerSocket.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.net.ServerSocket.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.ServerSocket.<clinit>():void");
    }

    ServerSocket(SocketImpl impl2) {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        this.impl = impl2;
        impl2.setServerSocket(this);
    }

    public ServerSocket() throws IOException {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        setImpl();
    }

    public ServerSocket(int port) throws IOException {
        this(port, 50, (InetAddress) null);
    }

    public ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, (InetAddress) null);
    }

    public ServerSocket(int port, int backlog, InetAddress bindAddr) throws IOException {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        setImpl();
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("Port value out of range: " + port);
        }
        try {
            bind(new InetSocketAddress(bindAddr, port), backlog < 1 ? 50 : backlog);
        } catch (SecurityException e) {
            close();
            throw e;
        } catch (IOException e2) {
            close();
            throw e2;
        }
    }

    public SocketImpl getImpl() throws SocketException {
        if (!this.created) {
            createImpl();
        }
        return this.impl;
    }

    private void checkOldImpl() {
        if (this.impl != null) {
            try {
                AccessController.doPrivileged(new PrivilegedExceptionAction<Void>(this) {
                    final /* synthetic */ ServerSocket this$0;

                    /*  JADX ERROR: Method load error
                        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.net.ServerSocket.1.run():java.lang.Object, dex: classes.dex
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
                    public /* bridge */ /* synthetic */ java.lang.Object run() {
                        /*
                        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.net.ServerSocket.1.run():java.lang.Object, dex: classes.dex
                        */
                        throw new UnsupportedOperationException("Method not decompiled: java.net.ServerSocket.AnonymousClass1.run():java.lang.Object");
                    }

                    /*  JADX ERROR: Method load error
                        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.net.ServerSocket.1.run():java.lang.Void, dex: classes.dex
                        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
                        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                        	... 6 more
                        */
                    public java.lang.Void run() {
                        /*
                        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.net.ServerSocket.1.run():java.lang.Void, dex: classes.dex
                        */
                        throw new UnsupportedOperationException("Method not decompiled: java.net.ServerSocket.AnonymousClass1.run():java.lang.Void");
                    }
                });
            } catch (PrivilegedActionException e) {
                this.oldImpl = true;
            }
        }
    }

    private void setImpl() {
        if (factory != null) {
            this.impl = factory.createSocketImpl();
            checkOldImpl();
        } else {
            this.impl = new SocksSocketImpl();
        }
        if (this.impl != null) {
            this.impl.setServerSocket(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void createImpl() throws SocketException {
        if (this.impl == null) {
            setImpl();
        }
        try {
            this.impl.create(true);
            this.created = true;
        } catch (IOException e) {
            throw new SocketException(e.getMessage());
        }
    }

    public void bind(SocketAddress endpoint) throws IOException {
        bind(endpoint, 50);
    }

    public void bind(SocketAddress endpoint, int backlog) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (this.oldImpl || !isBound()) {
            if (endpoint == null) {
                endpoint = new InetSocketAddress(0);
            }
            if (!(endpoint instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Unsupported address type");
            }
            InetSocketAddress epoint = (InetSocketAddress) endpoint;
            if (epoint.isUnresolved()) {
                throw new SocketException("Unresolved address");
            }
            if (backlog < 1) {
                backlog = 50;
            }
            try {
                SecurityManager security = System.getSecurityManager();
                if (security != null) {
                    security.checkListen(epoint.getPort());
                }
                getImpl().bind(epoint.getAddress(), epoint.getPort());
                getImpl().listen(backlog);
                this.bound = true;
            } catch (SecurityException e) {
                this.bound = false;
                throw e;
            } catch (IOException e2) {
                this.bound = false;
                throw e2;
            }
        } else {
            throw new SocketException("Already bound");
        }
    }

    public InetAddress getInetAddress() {
        SecurityManager sm;
        if (!isBound()) {
            return null;
        }
        try {
            InetAddress in = getImpl().getInetAddress();
            if (!NetUtil.doRevealLocalAddress() && (sm = System.getSecurityManager()) != null) {
                sm.checkConnect(in.getHostAddress(), -1);
            }
            return in;
        } catch (SecurityException e) {
            return InetAddress.getLoopbackAddress();
        } catch (SocketException e2) {
            return null;
        }
    }

    public int getLocalPort() {
        if (!isBound()) {
            return -1;
        }
        try {
            return getImpl().getLocalPort();
        } catch (SocketException e) {
            return -1;
        }
    }

    public SocketAddress getLocalSocketAddress() {
        if (!isBound()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getLocalPort());
    }

    public Socket accept() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (!isBound()) {
            throw new SocketException("Socket is not bound yet");
        } else {
            Socket s = new Socket((SocketImpl) null);
            implAccept(s);
            return s;
        }
    }

    /* access modifiers changed from: protected */
    public final void implAccept(Socket s) throws IOException {
        SocketImpl socketImpl = null;
        try {
            if (s.impl == null) {
                s.setImpl();
            } else {
                s.impl.reset();
            }
            SocketImpl si = s.impl;
            s.impl = null;
            si.address = new InetAddress();
            si.fd = new FileDescriptor();
            getImpl().accept(si);
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkAccept(si.getInetAddress().getHostAddress(), si.getPort());
            }
            s.impl = si;
            s.postAccept();
        } catch (IOException e) {
            if (socketImpl != null) {
                socketImpl.reset();
            }
            s.impl = socketImpl;
            throw e;
        } catch (SecurityException e2) {
            if (socketImpl != null) {
                socketImpl.reset();
            }
            s.impl = socketImpl;
            throw e2;
        }
    }

    public void close() throws IOException {
        synchronized (this.closeLock) {
            if (!isClosed()) {
                if (this.created) {
                    this.impl.close();
                }
                this.closed = true;
            }
        }
    }

    public ServerSocketChannel getChannel() {
        return null;
    }

    public boolean isBound() {
        if (!this.bound) {
            return this.oldImpl;
        }
        return true;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.closeLock) {
            z = this.closed;
        }
        return z;
    }

    public synchronized void setSoTimeout(int timeout) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(SocketOptions.SO_TIMEOUT, new Integer(timeout));
    }

    public synchronized int getSoTimeout() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        Object o = getImpl().getOption(SocketOptions.SO_TIMEOUT);
        if (!(o instanceof Integer)) {
            return 0;
        }
        return ((Integer) o).intValue();
    }

    public void setReuseAddress(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(4, Boolean.valueOf(on));
    }

    public boolean getReuseAddress() throws SocketException {
        if (!isClosed()) {
            return ((Boolean) getImpl().getOption(4)).booleanValue();
        }
        throw new SocketException("Socket is closed");
    }

    public String toString() {
        InetAddress in;
        if (!isBound()) {
            return "ServerSocket[unbound]";
        }
        if (NetUtil.doRevealLocalAddress() || System.getSecurityManager() == null) {
            in = this.impl.getInetAddress();
        } else {
            in = InetAddress.getLoopbackAddress();
        }
        return "ServerSocket[addr=" + in + ",localport=" + this.impl.getLocalPort() + "]";
    }

    /* access modifiers changed from: package-private */
    public void setBound() {
        this.bound = true;
    }

    /* access modifiers changed from: package-private */
    public void setCreated() {
        this.created = true;
    }

    public static synchronized void setSocketFactory(SocketImplFactory fac) throws IOException {
        synchronized (ServerSocket.class) {
            if (factory != null) {
                throw new SocketException("factory already defined");
            }
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkSetFactory();
            }
            factory = fac;
        }
    }

    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("negative receive size");
        } else if (isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            getImpl().setOption(SocketOptions.SO_RCVBUF, new Integer(size));
        }
    }

    public synchronized int getReceiveBufferSize() throws SocketException {
        int result;
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        result = 0;
        Object o = getImpl().getOption(SocketOptions.SO_RCVBUF);
        if (o instanceof Integer) {
            result = ((Integer) o).intValue();
        }
        return result;
    }

    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
    }
}
