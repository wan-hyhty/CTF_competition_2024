package java.net;

import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import sun.misc.IoTrace;
import sun.net.ConnectionResetException;

class SocketInputStream extends FileInputStream {
    private boolean closing = false;
    private boolean eof;
    private AbstractPlainSocketImpl impl = null;
    private Socket socket = null;
    private byte[] temp;

    private native int socketRead0(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3) throws IOException;

    SocketInputStream(AbstractPlainSocketImpl impl2) throws IOException {
        super(impl2.getFileDescriptor());
        this.impl = impl2;
        this.socket = impl2.getSocket();
    }

    public final FileChannel getChannel() {
        return null;
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int length) throws IOException {
        return read(b, off, length, this.impl.getTimeout());
    }

    /* access modifiers changed from: package-private */
    public int read(byte[] b, int off, int length, int timeout) throws IOException {
        int n = 0;
        if (this.eof) {
            return -1;
        }
        if (this.impl.isConnectionReset()) {
            throw new SocketException("Connection reset");
        } else if (length > 0 && off >= 0 && off + length <= b.length) {
            boolean gotReset = false;
            Object traceContext = IoTrace.socketReadBegin();
            FileDescriptor fd = this.impl.acquireFD();
            try {
                BlockGuard.getThreadPolicy().onNetwork();
                n = socketRead0(fd, b, off, length, timeout);
                if (n > 0) {
                    IoTrace.socketReadEnd(traceContext, this.impl.address, this.impl.port, timeout, (long) (n > 0 ? n : 0));
                    return n;
                }
                IoTrace.socketReadEnd(traceContext, this.impl.address, this.impl.port, timeout, (long) (n > 0 ? n : 0));
                if (gotReset) {
                    Object traceContext2 = IoTrace.socketReadBegin();
                    this.impl.setConnectionResetPending();
                    try {
                        int n2 = socketRead0(fd, b, off, length, timeout);
                        if (n2 > 0) {
                            IoTrace.socketReadEnd(traceContext2, this.impl.address, this.impl.port, timeout, (long) (n2 > 0 ? n2 : 0));
                            return n2;
                        }
                        IoTrace.socketReadEnd(traceContext2, this.impl.address, this.impl.port, timeout, (long) (n2 > 0 ? n2 : 0));
                    } catch (ConnectionResetException e) {
                        IoTrace.socketReadEnd(traceContext2, this.impl.address, this.impl.port, timeout, (long) (n > 0 ? n : 0));
                    } catch (Throwable th) {
                        InetAddress inetAddress = this.impl.address;
                        int i = this.impl.port;
                        if (n <= 0) {
                            n = 0;
                        }
                        IoTrace.socketReadEnd(traceContext2, inetAddress, i, timeout, (long) n);
                        throw th;
                    }
                }
                if (this.impl.isClosedOrPending()) {
                    throw new SocketException("Socket closed");
                }
                if (this.impl.isConnectionResetPending()) {
                    this.impl.setConnectionReset();
                }
                if (this.impl.isConnectionReset()) {
                    throw new SocketException("Connection reset");
                }
                this.eof = true;
                return -1;
            } catch (ConnectionResetException e2) {
                gotReset = true;
                IoTrace.socketReadEnd(traceContext, this.impl.address, this.impl.port, timeout, (long) 0);
            } catch (Throwable th2) {
                IoTrace.socketReadEnd(traceContext, this.impl.address, this.impl.port, timeout, (long) 0);
                throw th2;
            }
        } else if (length == 0) {
            return 0;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int read() throws IOException {
        if (this.eof) {
            return -1;
        }
        this.temp = new byte[1];
        if (read(this.temp, 0, 1) <= 0) {
            return -1;
        }
        return this.temp[0] & Character.DIRECTIONALITY_UNDEFINED;
    }

    public long skip(long numbytes) throws IOException {
        int r;
        if (numbytes <= 0) {
            return 0;
        }
        long n = numbytes;
        int buflen = (int) Math.min(1024, numbytes);
        byte[] data = new byte[buflen];
        while (n > 0 && (r = read(data, 0, (int) Math.min((long) buflen, n))) >= 0) {
            n -= (long) r;
        }
        return numbytes - n;
    }

    public int available() throws IOException {
        if (this.eof) {
            return 0;
        }
        return this.impl.available();
    }

    public void close() throws IOException {
        if (!this.closing) {
            this.closing = true;
            if (this.socket == null) {
                this.impl.close();
            } else if (!this.socket.isClosed()) {
                this.socket.close();
            }
            this.closing = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void setEOF(boolean eof2) {
        this.eof = eof2;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
    }
}
