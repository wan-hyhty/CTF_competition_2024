package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockImpl extends FileLock {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f125assertionsDisabled = false;
    private volatile boolean valid = true;

    FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
        super(channel, position, size, shared);
    }

    public boolean isValid() {
        return this.valid;
    }

    /* access modifiers changed from: package-private */
    public void invalidate() {
        if (f125assertionsDisabled || Thread.holdsLock(this)) {
            this.valid = false;
            return;
        }
        throw new AssertionError();
    }

    public synchronized void release() throws IOException {
        Channel ch = acquiredBy();
        if (!ch.isOpen()) {
            throw new ClosedChannelException();
        } else if (this.valid) {
            if (ch instanceof FileChannelImpl) {
                ((FileChannelImpl) ch).release(this);
                this.valid = false;
            } else {
                throw new AssertionError();
            }
        }
    }
}
