package java.nio.channels;

import java.io.IOException;

public abstract class FileLock implements AutoCloseable {
    private final Channel channel;
    private final long position;
    private final boolean shared;
    private final long size;

    public abstract boolean isValid();

    public abstract void release() throws IOException;

    protected FileLock(FileChannel channel2, long position2, long size2, boolean shared2) {
        if (position2 < 0) {
            throw new IllegalArgumentException("Negative position");
        } else if (size2 < 0) {
            throw new IllegalArgumentException("Negative size");
        } else if (position2 + size2 < 0) {
            throw new IllegalArgumentException("Negative position + size");
        } else {
            this.channel = channel2;
            this.position = position2;
            this.size = size2;
            this.shared = shared2;
        }
    }

    public final FileChannel channel() {
        if (this.channel instanceof FileChannel) {
            return (FileChannel) this.channel;
        }
        return null;
    }

    public Channel acquiredBy() {
        return this.channel;
    }

    public final long position() {
        return this.position;
    }

    public final long size() {
        return this.size;
    }

    public final boolean isShared() {
        return this.shared;
    }

    public final boolean overlaps(long position2, long size2) {
        if (position2 + size2 > this.position && this.position + this.size > position2) {
            return true;
        }
        return false;
    }

    public final void close() throws IOException {
        release();
    }

    public final String toString() {
        return getClass().getName() + "[" + this.position + ":" + this.size + " " + (this.shared ? "shared" : "exclusive") + " " + (isValid() ? "valid" : "invalid") + "]";
    }
}
