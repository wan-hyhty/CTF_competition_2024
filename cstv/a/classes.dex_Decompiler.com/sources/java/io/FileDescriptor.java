package java.io;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;

public final class FileDescriptor {
    public static final FileDescriptor err = null;
    public static final FileDescriptor in = null;
    public static final FileDescriptor out = null;
    private int descriptor;

    private static native boolean isSocket(int i);

    public native void sync() throws SyncFailedException;

    public FileDescriptor() {
        this.descriptor = -1;
    }

    private FileDescriptor(int descriptor2) {
        this.descriptor = descriptor2;
    }

    public boolean valid() {
        return this.descriptor != -1;
    }

    public final int getInt$() {
        return this.descriptor;
    }

    public final void setInt$(int fd) {
        this.descriptor = fd;
    }

    public boolean isSocket$() {
        return isSocket(this.descriptor);
    }

    private static FileDescriptor dupFd(int fd) {
        try {
            return new FileDescriptor(Os.fcntlInt(new FileDescriptor(fd), OsConstants.F_DUPFD_CLOEXEC, 0));
        } catch (ErrnoException e) {
            throw new RuntimeException((Throwable) e);
        }
    }
}
