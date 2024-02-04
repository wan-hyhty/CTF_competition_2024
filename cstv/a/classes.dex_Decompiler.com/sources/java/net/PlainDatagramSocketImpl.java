package java.net;

import java.io.IOException;

class PlainDatagramSocketImpl extends AbstractPlainDatagramSocketImpl {
    private static native void init();

    /* access modifiers changed from: protected */
    public native synchronized void bind0(int i, InetAddress inetAddress) throws SocketException;

    /* access modifiers changed from: protected */
    public native void connect0(InetAddress inetAddress, int i) throws SocketException;

    /* access modifiers changed from: protected */
    public native void datagramSocketClose();

    /* access modifiers changed from: protected */
    public native void datagramSocketCreate() throws SocketException;

    /* access modifiers changed from: protected */
    public native void disconnect0(int i);

    /* access modifiers changed from: protected */
    public native byte getTTL() throws IOException;

    /* access modifiers changed from: protected */
    public native int getTimeToLive() throws IOException;

    /* access modifiers changed from: protected */
    public native void join(InetAddress inetAddress, NetworkInterface networkInterface) throws IOException;

    /* access modifiers changed from: protected */
    public native void leave(InetAddress inetAddress, NetworkInterface networkInterface) throws IOException;

    /* access modifiers changed from: protected */
    public native synchronized int peek(InetAddress inetAddress) throws IOException;

    /* access modifiers changed from: protected */
    public native synchronized int peekData(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public native synchronized void receive0(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public native void send(DatagramPacket datagramPacket) throws IOException;

    /* access modifiers changed from: protected */
    public native void setTTL(byte b) throws IOException;

    /* access modifiers changed from: protected */
    public native void setTimeToLive(int i) throws IOException;

    /* access modifiers changed from: protected */
    public native Object socketGetOption(int i) throws SocketException;

    /* access modifiers changed from: protected */
    public native void socketSetOption(int i, Object obj) throws SocketException;

    PlainDatagramSocketImpl() {
    }
}
