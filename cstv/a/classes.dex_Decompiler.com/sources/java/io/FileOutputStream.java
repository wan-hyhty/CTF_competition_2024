package java.io;

import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.nio.channels.FileChannel;
import libcore.io.IoBridge;
import sun.misc.IoTrace;
import sun.nio.ch.FileChannelImpl;

public class FileOutputStream extends OutputStream {
    private final boolean append;
    private FileChannel channel;
    private final Object closeLock;
    private volatile boolean closed;
    private final FileDescriptor fd;
    private final CloseGuard guard;
    private final boolean isFdOwner;
    private final String path;

    private native void open(String str, boolean z) throws FileNotFoundException;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileOutputStream(String name) throws FileNotFoundException {
        this(name != null ? new File(name) : null, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileOutputStream(String name, boolean append2) throws FileNotFoundException {
        this(name != null ? new File(name) : null, append2);
    }

    public FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
    }

    public FileOutputStream(File file, boolean append2) throws FileNotFoundException {
        this.closeLock = new Object();
        this.closed = false;
        this.guard = CloseGuard.get();
        String path2 = file != null ? file.getPath() : null;
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(path2);
        }
        if (path2 == null) {
            throw new NullPointerException();
        } else if (file.isInvalid()) {
            throw new FileNotFoundException("Invalid file path");
        } else {
            this.fd = new FileDescriptor();
            this.append = append2;
            this.path = path2;
            this.isFdOwner = true;
            BlockGuard.getThreadPolicy().onWriteToDisk();
            open(path2, append2);
            this.guard.open("close");
        }
    }

    public FileOutputStream(FileDescriptor fdObj) {
        this(fdObj, false);
    }

    public FileOutputStream(FileDescriptor fdObj, boolean isFdOwner2) {
        this.closeLock = new Object();
        this.closed = false;
        this.guard = CloseGuard.get();
        if (fdObj == null) {
            throw new NullPointerException("fdObj == null");
        }
        this.fd = fdObj;
        this.path = null;
        this.append = false;
        this.isFdOwner = isFdOwner2;
    }

    public void write(int b) throws IOException {
        write(new byte[]{(byte) b}, 0, 1);
    }

    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        if (!this.closed || len <= 0) {
            Object traceContext = IoTrace.fileWriteBegin(this.path);
            try {
                IoBridge.write(this.fd, b, off, len);
                int i = len;
                IoTrace.fileWriteEnd(traceContext, (long) len);
            } catch (Throwable th) {
                IoTrace.fileWriteEnd(traceContext, 0);
                throw th;
            }
        } else {
            throw new IOException("Stream Closed");
        }
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
        throw new UnsupportedOperationException("Method not decompiled: java.io.FileOutputStream.close():void");
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
                this.channel = FileChannelImpl.open(this.fd, this.path, false, true, this.append, this);
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
        if (this.fd == null) {
            return;
        }
        if (this.fd == FileDescriptor.out || this.fd == FileDescriptor.err) {
            flush();
        } else {
            close();
        }
    }
}
