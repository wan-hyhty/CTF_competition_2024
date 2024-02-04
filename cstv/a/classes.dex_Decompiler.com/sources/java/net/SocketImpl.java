package java.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class SocketImpl implements SocketOptions {
    protected InetAddress address;
    protected FileDescriptor fd;
    protected int localport;
    protected int port;
    ServerSocket serverSocket = null;
    Socket socket = null;

    /* access modifiers changed from: protected */
    public abstract void accept(SocketImpl socketImpl) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int available() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void bind(InetAddress inetAddress, int i) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void close() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void connect(String str, int i) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void connect(InetAddress inetAddress, int i) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void connect(SocketAddress socketAddress, int i) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void create(boolean z) throws IOException;

    /* access modifiers changed from: protected */
    public abstract InputStream getInputStream() throws IOException;

    /* access modifiers changed from: protected */
    public abstract OutputStream getOutputStream() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void listen(int i) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void sendUrgentData(int i) throws IOException;

    /* access modifiers changed from: protected */
    public void shutdownInput() throws IOException {
        throw new IOException("Method not implemented!");
    }

    /* access modifiers changed from: protected */
    public void shutdownOutput() throws IOException {
        throw new IOException("Method not implemented!");
    }

    /* access modifiers changed from: protected */
    public FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    public FileDescriptor getFD$() {
        return this.fd;
    }

    /* access modifiers changed from: protected */
    public InetAddress getInetAddress() {
        return this.address;
    }

    /* access modifiers changed from: protected */
    public int getPort() {
        return this.port;
    }

    /* access modifiers changed from: protected */
    public boolean supportsUrgentData() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getLocalPort() {
        return this.localport;
    }

    /* access modifiers changed from: package-private */
    public void setSocket(Socket soc) {
        this.socket = soc;
    }

    /* access modifiers changed from: package-private */
    public Socket getSocket() {
        return this.socket;
    }

    /* access modifiers changed from: package-private */
    public void setServerSocket(ServerSocket soc) {
        this.serverSocket = soc;
    }

    /* access modifiers changed from: package-private */
    public ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    public String toString() {
        return "Socket[addr=" + getInetAddress() + ",port=" + getPort() + ",localport=" + getLocalPort() + "]";
    }

    /* access modifiers changed from: package-private */
    public void reset() throws IOException {
        this.address = null;
        this.port = 0;
        this.localport = 0;
    }

    /* access modifiers changed from: protected */
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
    }
}
