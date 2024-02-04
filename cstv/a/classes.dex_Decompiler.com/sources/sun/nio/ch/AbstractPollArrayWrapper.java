package sun.nio.ch;

abstract class AbstractPollArrayWrapper {
    static final short EVENT_OFFSET = 4;
    static final short FD_OFFSET = 0;
    static final short POLLERR = 8;
    static final short POLLHUP = 16;
    static final short POLLIN = 1;
    static final short POLLNVAL = 32;
    static final short POLLOUT = 4;
    static final short POLLREMOVE = 2048;
    static final short REVENT_OFFSET = 6;
    static final short SIZE_POLLFD = 8;
    protected AllocatedNativeObject pollArray;
    protected long pollArrayAddress;
    protected int totalChannels = 0;

    AbstractPollArrayWrapper() {
    }

    /* access modifiers changed from: package-private */
    public int getEventOps(int i) {
        return this.pollArray.getShort((i * 8) + 4);
    }

    /* access modifiers changed from: package-private */
    public int getReventOps(int i) {
        return this.pollArray.getShort((i * 8) + 6);
    }

    /* access modifiers changed from: package-private */
    public int getDescriptor(int i) {
        return this.pollArray.getInt((i * 8) + 0);
    }

    /* access modifiers changed from: package-private */
    public void putEventOps(int i, int event) {
        this.pollArray.putShort((i * 8) + 4, (short) event);
    }

    /* access modifiers changed from: package-private */
    public void putReventOps(int i, int revent) {
        this.pollArray.putShort((i * 8) + 6, (short) revent);
    }

    /* access modifiers changed from: package-private */
    public void putDescriptor(int i, int fd) {
        this.pollArray.putInt((i * 8) + 0, fd);
    }
}
