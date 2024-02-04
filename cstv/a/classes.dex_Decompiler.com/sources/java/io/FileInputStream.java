package java.io;

import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.nio.channels.FileChannel;
import libcore.io.IoBridge;
import sun.misc.IoTrace;
import sun.nio.ch.FileChannelImpl;

public class FileInputStream extends InputStream {
    private FileChannel channel;
    private final Object closeLock;
    private volatile boolean closed;
    private final FileDescriptor fd;
    private final CloseGuard guard;
    private final boolean isFdOwner;
    private final String path;

    private native int available0() throws IOException;

    private native void open(String str) throws FileNotFoundException;

    private native long skip0(long j) throws IOException, UseManualSkipException;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileInputStream(String name) throws FileNotFoundException {
        this(name != null ? new File(name) : null);
    }

    public FileInputStream(File file) throws FileNotFoundException {
        this.channel = null;
        this.closeLock = new Object();
        this.closed = false;
        this.guard = CloseGuard.get();
        String path2 = file != null ? file.getPath() : null;
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(path2);
        }
        if (path2 == null) {
            throw new NullPointerException();
        } else if (file.isInvalid()) {
            throw new FileNotFoundException("Invalid file path");
        } else {
            this.fd = new FileDescriptor();
            this.isFdOwner = true;
            this.path = path2;
            BlockGuard.getThreadPolicy().onReadFromDisk();
            open(path2);
            this.guard.open("close");
        }
    }

    public FileInputStream(FileDescriptor fdObj) {
        this(fdObj, false);
    }

    public FileInputStream(FileDescriptor fdObj, boolean isFdOwner2) {
        this.channel = null;
        this.closeLock = new Object();
        this.closed = false;
        this.guard = CloseGuard.get();
        if (fdObj == null) {
            throw new NullPointerException("fdObj == null");
        }
        this.fd = fdObj;
        this.isFdOwner = isFdOwner2;
        this.path = null;
    }

    public int read() throws IOException {
        Object traceContext = IoTrace.fileReadBegin(this.path);
        byte[] b = new byte[1];
        try {
            int res = read(b, 0, 1);
            IoTrace.fileReadEnd(traceContext, (long) res);
            if (res != -1) {
                return b[0] & Character.DIRECTIONALITY_UNDEFINED;
            }
            return -1;
        } catch (Throwable th) {
            IoTrace.fileReadEnd(traceContext, -1);
            throw th;
        }
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int i = 0;
        if (!this.closed || len <= 0) {
            Object traceContext = IoTrace.fileReadBegin(this.path);
            try {
                int bytesRead = IoBridge.read(this.fd, b, off, len);
                if (bytesRead != -1) {
                    i = bytesRead;
                }
                return bytesRead;
            } finally {
                IoTrace.fileReadEnd(traceContext, (long) i);
            }
        } else {
            throw new IOException("Stream Closed");
        }
    }

    public long skip(long n) throws IOException {
        if (this.closed) {
            throw new IOException("Stream Closed");
        }
        try {
            BlockGuard.getThreadPolicy().onReadFromDisk();
            return skip0(n);
        } catch (UseManualSkipException e) {
            return super.skip(n);
        }
    }

    private static class UseManualSkipException extends Exception {
        private UseManualSkipException() {
        }
    }

    public int available() throws IOException {
        if (!this.closed) {
            return available0();
        }
        throw new IOException("Stream Closed");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x000d, code lost:
        r2.guard.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        if (r2.channel == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r2.channel.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        if (r2.isFdOwner == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        libcore.io.IoBridge.closeAndSignalBlockedThreads(r2.fd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            java.lang.Object r1 = r2.closeLock
            monitor-enter(r1)
            boolean r0 = r2.closed     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            r0 = 1
            r2.closed = r0     // Catch:{ all -> 0x0025 }
            monitor-exit(r1)
            dalvik.system.CloseGuard r0 = r2.guard
            r0.close()
            java.nio.channels.FileChannel r0 = r2.channel
            if (r0 == 0) goto L_0x001b
            java.nio.channels.FileChannel r0 = r2.channel
            r0.close()
        L_0x001b:
            boolean r0 = r2.isFdOwner
            if (r0 == 0) goto L_0x0024
            java.io.FileDescriptor r0 = r2.fd
            libcore.io.IoBridge.closeAndSignalBlockedThreads(r0)
        L_0x0024:
            return
        L_0x0025:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.FileInputStream.close():void");
    }

    public final FileDescriptor getFD() throws IOException {
        if (this.fd != null) {
            return this.fd;
        }
        throw new IOException();
    }

    public FileChannel getChannel() {
        FileChannel fileChannel;
        synchronized (this) {
            if (this.channel == null) {
                this.channel = FileChannelImpl.open(this.fd, this.path, true, false, this);
            }
            fileChannel = this.channel;
        }
        return fileChannel;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws IOException {
        if (this.guard != null) {
            this.guard.warnIfOpen();
        }
        if (this.fd != null && this.fd != FileDescriptor.in) {
            close();
        }
    }
}
