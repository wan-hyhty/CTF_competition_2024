package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;

class IOUtil {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f126assertionsDisabled = false;
    static final int IOV_MAX = 0;

    static native void configureBlocking(FileDescriptor fileDescriptor, boolean z) throws IOException;

    static native boolean drain(int i) throws IOException;

    static native int fdLimit();

    static native int fdVal(FileDescriptor fileDescriptor);

    static native int iovMax();

    static native long makePipe(boolean z);

    static native boolean randomBytes(byte[] bArr);

    static native void setfdVal(FileDescriptor fileDescriptor, int i);

    private IOUtil() {
    }

    static int write(FileDescriptor fd, ByteBuffer src, long position, NativeDispatcher nd) throws IOException {
        int rem = 0;
        if (src instanceof DirectBuffer) {
            return writeFromNativeBuffer(fd, src, position, nd);
        }
        int pos = src.position();
        int lim = src.limit();
        if (!f126assertionsDisabled) {
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
            int n = writeFromNativeBuffer(fd, bb, position, nd);
            if (n > 0) {
                src.position(pos + n);
            }
            return n;
        } finally {
            Util.offerFirstTemporaryDirectBuffer(bb);
        }
    }

    private static int writeFromNativeBuffer(FileDescriptor fd, ByteBuffer bb, long position, NativeDispatcher nd) throws IOException {
        int rem;
        int written;
        int pos = bb.position();
        int lim = bb.limit();
        if (!f126assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        if (pos <= lim) {
            rem = lim - pos;
        } else {
            rem = 0;
        }
        if (rem == 0) {
            return 0;
        }
        if (position != -1) {
            written = nd.pwrite(fd, ((long) pos) + ((DirectBuffer) bb).address(), rem, position);
        } else {
            written = nd.write(fd, ((DirectBuffer) bb).address() + ((long) pos), rem);
        }
        if (written > 0) {
            bb.position(pos + written);
        }
        return written;
    }

    static long write(FileDescriptor fd, ByteBuffer[] bufs, NativeDispatcher nd) throws IOException {
        return write(fd, bufs, 0, bufs.length, nd);
    }

    static long write(FileDescriptor fd, ByteBuffer[] bufs, int offset, int length, NativeDispatcher nd) throws IOException {
        boolean z;
        IOVecWrapper vec = IOVecWrapper.get(length);
        int iov_len = 0;
        int count = offset + length;
        int i = offset;
        while (i < count) {
            try {
                if (iov_len >= IOV_MAX) {
                    break;
                }
                ByteBuffer buf = bufs[i];
                int pos = buf.position();
                int lim = buf.limit();
                if (!f126assertionsDisabled) {
                    if (pos <= lim) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                int rem = pos <= lim ? lim - pos : 0;
                if (rem > 0) {
                    vec.setBuffer(iov_len, buf, pos, rem);
                    if (!(buf instanceof DirectBuffer)) {
                        ByteBuffer shadow = Util.getTemporaryDirectBuffer(rem);
                        shadow.put(buf);
                        shadow.flip();
                        vec.setShadow(iov_len, shadow);
                        buf.position(pos);
                        buf = shadow;
                        pos = shadow.position();
                    }
                    vec.putBase(iov_len, ((DirectBuffer) buf).address() + ((long) pos));
                    vec.putLen(iov_len, (long) rem);
                    iov_len++;
                }
                i++;
            } catch (Throwable th) {
                if (0 == 0) {
                    for (int j = 0; j < iov_len; j++) {
                        ByteBuffer shadow2 = vec.getShadow(j);
                        if (shadow2 != null) {
                            Util.offerLastTemporaryDirectBuffer(shadow2);
                        }
                        vec.clearRefs(j);
                    }
                }
                throw th;
            }
        }
        if (iov_len == 0) {
            if (0 == 0) {
                for (int j2 = 0; j2 < iov_len; j2++) {
                    ByteBuffer shadow3 = vec.getShadow(j2);
                    if (shadow3 != null) {
                        Util.offerLastTemporaryDirectBuffer(shadow3);
                    }
                    vec.clearRefs(j2);
                }
            }
            return 0;
        }
        long bytesWritten = nd.writev(fd, vec.address, iov_len);
        long left = bytesWritten;
        for (int j3 = 0; j3 < iov_len; j3++) {
            if (left > 0) {
                ByteBuffer buf2 = vec.getBuffer(j3);
                int pos2 = vec.getPosition(j3);
                int rem2 = vec.getRemaining(j3);
                int n = left > ((long) rem2) ? rem2 : (int) left;
                buf2.position(pos2 + n);
                left -= (long) n;
            }
            ByteBuffer shadow4 = vec.getShadow(j3);
            if (shadow4 != null) {
                Util.offerLastTemporaryDirectBuffer(shadow4);
            }
            vec.clearRefs(j3);
        }
        if (1 == 0) {
            for (int j4 = 0; j4 < iov_len; j4++) {
                ByteBuffer shadow5 = vec.getShadow(j4);
                if (shadow5 != null) {
                    Util.offerLastTemporaryDirectBuffer(shadow5);
                }
                vec.clearRefs(j4);
            }
        }
        return bytesWritten;
    }

    static int read(FileDescriptor fd, ByteBuffer dst, long position, NativeDispatcher nd) throws IOException {
        if (dst.isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        } else if (dst instanceof DirectBuffer) {
            return readIntoNativeBuffer(fd, dst, position, nd);
        } else {
            ByteBuffer bb = Util.getTemporaryDirectBuffer(dst.remaining());
            try {
                int n = readIntoNativeBuffer(fd, bb, position, nd);
                bb.flip();
                if (n > 0) {
                    dst.put(bb);
                }
                return n;
            } finally {
                Util.offerFirstTemporaryDirectBuffer(bb);
            }
        }
    }

    private static int readIntoNativeBuffer(FileDescriptor fd, ByteBuffer bb, long position, NativeDispatcher nd) throws IOException {
        int rem;
        int n;
        int pos = bb.position();
        int lim = bb.limit();
        if (!f126assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        if (pos <= lim) {
            rem = lim - pos;
        } else {
            rem = 0;
        }
        if (rem == 0) {
            return 0;
        }
        if (position != -1) {
            n = nd.pread(fd, ((long) pos) + ((DirectBuffer) bb).address(), rem, position);
        } else {
            n = nd.read(fd, ((DirectBuffer) bb).address() + ((long) pos), rem);
        }
        if (n > 0) {
            bb.position(pos + n);
        }
        return n;
    }

    static long read(FileDescriptor fd, ByteBuffer[] bufs, NativeDispatcher nd) throws IOException {
        return read(fd, bufs, 0, bufs.length, nd);
    }

    static long read(FileDescriptor fd, ByteBuffer[] bufs, int offset, int length, NativeDispatcher nd) throws IOException {
        IOVecWrapper vec = IOVecWrapper.get(length);
        int iov_len = 0;
        int count = offset + length;
        int i = offset;
        while (i < count) {
            try {
                if (iov_len >= IOV_MAX) {
                    break;
                }
                ByteBuffer buf = bufs[i];
                if (buf.isReadOnly()) {
                    throw new IllegalArgumentException("Read-only buffer");
                }
                int pos = buf.position();
                int lim = buf.limit();
                if (!f126assertionsDisabled) {
                    if (!(pos <= lim)) {
                        throw new AssertionError();
                    }
                }
                int rem = pos <= lim ? lim - pos : 0;
                if (rem > 0) {
                    vec.setBuffer(iov_len, buf, pos, rem);
                    if (!(buf instanceof DirectBuffer)) {
                        ByteBuffer shadow = Util.getTemporaryDirectBuffer(rem);
                        vec.setShadow(iov_len, shadow);
                        buf = shadow;
                        pos = shadow.position();
                    }
                    vec.putBase(iov_len, ((DirectBuffer) buf).address() + ((long) pos));
                    vec.putLen(iov_len, (long) rem);
                    iov_len++;
                }
                i++;
            } catch (Throwable th) {
                if (0 == 0) {
                    for (int j = 0; j < iov_len; j++) {
                        ByteBuffer shadow2 = vec.getShadow(j);
                        if (shadow2 != null) {
                            Util.offerLastTemporaryDirectBuffer(shadow2);
                        }
                        vec.clearRefs(j);
                    }
                }
                throw th;
            }
        }
        if (iov_len == 0) {
            if (0 == 0) {
                for (int j2 = 0; j2 < iov_len; j2++) {
                    ByteBuffer shadow3 = vec.getShadow(j2);
                    if (shadow3 != null) {
                        Util.offerLastTemporaryDirectBuffer(shadow3);
                    }
                    vec.clearRefs(j2);
                }
            }
            return 0;
        }
        long bytesRead = nd.readv(fd, vec.address, iov_len);
        long left = bytesRead;
        for (int j3 = 0; j3 < iov_len; j3++) {
            ByteBuffer shadow4 = vec.getShadow(j3);
            if (left > 0) {
                ByteBuffer buf2 = vec.getBuffer(j3);
                int rem2 = vec.getRemaining(j3);
                int n = left > ((long) rem2) ? rem2 : (int) left;
                if (shadow4 == null) {
                    buf2.position(vec.getPosition(j3) + n);
                } else {
                    shadow4.limit(shadow4.position() + n);
                    buf2.put(shadow4);
                }
                left -= (long) n;
            }
            if (shadow4 != null) {
                Util.offerLastTemporaryDirectBuffer(shadow4);
            }
            vec.clearRefs(j3);
        }
        if (1 == 0) {
            for (int j4 = 0; j4 < iov_len; j4++) {
                ByteBuffer shadow5 = vec.getShadow(j4);
                if (shadow5 != null) {
                    Util.offerLastTemporaryDirectBuffer(shadow5);
                }
                vec.clearRefs(j4);
            }
        }
        return bytesRead;
    }

    static FileDescriptor newFD(int i) {
        FileDescriptor fd = new FileDescriptor();
        setfdVal(fd, i);
        return fd;
    }
}
