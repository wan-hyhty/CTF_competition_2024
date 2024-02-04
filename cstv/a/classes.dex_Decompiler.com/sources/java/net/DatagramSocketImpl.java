package java.net;

import java.io.FileDescriptor;
import java.io.IOException;

public abstract class DatagramSocketImpl implements SocketOptions {
    protected FileDescriptor fd;
    protected int localPort;

    /* access modifiers changed from: protected */
    public abstract void bind(int i, InetAddress inetAddress) throws SocketException;

    /* access modifiers changed from: protected */
    public abstract void close();

    /* access modifiers changed from: protected */
    public abstract void create() throws SocketException;

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract byte getTTL() throws IOException;

    /* access modifiers changed from: protected */
    public abstract int getTimeToLive() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void join(InetAddress inetAddress) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void leave(InetAddress inetAddress) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int peek(InetAddress inetAddress) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int peekData(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void receive(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void send(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract void setTTL(byte b) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void setTimeToLive(int i) throws IOException;

    /* access modifiers changed from: protected */
    public void connect(InetAddress address, int port) throws SocketException {
    }

    /* access modifiers changed from: protected */
    public void disconnect() {
    }

    /* access modifiers changed from: protected */
    public int getLocalPort() {
        return this.localPort;
    }

    /* access modifiers changed from: protected */
    public FileDescriptor getFileDescriptor() {
        return this.fd;
    }
}
