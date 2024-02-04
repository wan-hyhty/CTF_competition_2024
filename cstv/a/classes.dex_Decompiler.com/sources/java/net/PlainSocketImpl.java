package java.net;

import java.io.FileDescriptor;
import java.io.IOException;

class PlainSocketImpl extends AbstractPlainSocketImpl {
    /* access modifiers changed from: package-private */
    public native void socketAccept(SocketImpl socketImpl) throws IOException;

    /* access modifiers changed from: package-private */
    public native int socketAvailable() throws IOException;

    /* access modifiers changed from: package-private */
    public native void socketBind(InetAddress inetAddress, int i) throws IOException;

    /* access modifiers changed from: package-private */
    public native void socketClose0() throws IOException;

    /* access modifiers changed from: package-private */
    public native void socketConnect(InetAddress inetAddress, int i, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public native void socketCreate(boolean z) throws IOException;

    /* access modifiers changed from: package-private */
    public native int socketGetOption(int i, Object obj) throws SocketException;

    /* access modifiers changed from: package-private */
    public native void socketListen(int i) throws IOException;

    /* access modifiers changed from: package-private */
    public native void socketSendUrgentData(int i) throws IOException;

    /* access modifiers changed from: package-private */
    public native void socketSetOption(int i, boolean z, Object obj) throws SocketException;

    /* access modifiers changed from: package-private */
    public native void socketShutdown(int i) throws IOException;

    PlainSocketImpl() {
        this(new FileDescriptor());
    }

    PlainSocketImpl(FileDescriptor fd) {
        this.fd = fd;
    }
}
