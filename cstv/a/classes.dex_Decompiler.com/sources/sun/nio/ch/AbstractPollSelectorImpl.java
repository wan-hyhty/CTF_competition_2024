package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

abstract class AbstractPollSelectorImpl extends SelectorImpl {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f120assertionsDisabled = false;
    protected final int INIT_CAP = 10;
    protected SelectionKeyImpl[] channelArray;
    protected int channelOffset = 0;
    private Object closeLock = new Object();
    private boolean closed = false;
    PollArrayWrapper pollWrapper;
    protected int totalChannels;

    /* access modifiers changed from: protected */
    public abstract int doSelect(long j) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void implCloseInterrupt() throws IOException;

    AbstractPollSelectorImpl(SelectorProvider sp, int channels, int offset) {
        super(sp);
        this.totalChannels = channels;
        this.channelOffset = offset;
    }

    /* access modifiers changed from: package-private */
    public void putEventOps(SelectionKeyImpl sk, int ops) {
        synchronized (this.closeLock) {
            if (this.closed) {
                throw new ClosedSelectorException();
            }
            this.pollWrapper.putEventOps(sk.getIndex(), ops);
        }
    }

    public Selector wakeup() {
        this.pollWrapper.interrupt();
        return this;
    }

    /* access modifiers changed from: protected */
    public void implClose() throws IOException {
        synchronized (this.closeLock) {
            if (!this.closed) {
                this.closed = true;
                for (int i = this.channelOffset; i < this.totalChannels; i++) {
                    SelectionKeyImpl ski = this.channelArray[i];
                    if (!f120assertionsDisabled) {
                        if (!(ski.getIndex() != -1)) {
                            throw new AssertionError();
                        }
                    }
                    ski.setIndex(-1);
                    deregister(ski);
                    SelectableChannel selch = this.channelArray[i].channel();
                    if (!selch.isOpen() && !selch.isRegistered()) {
                        ((SelChImpl) selch).kill();
                    }
                }
                implCloseInterrupt();
                this.pollWrapper.free();
                this.pollWrapper = null;
                this.selectedKeys = null;
                this.channelArray = null;
                this.totalChannels = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int updateSelectedKeys() {
        int numKeysUpdated = 0;
        for (int i = this.channelOffset; i < this.totalChannels; i++) {
            int rOps = this.pollWrapper.getReventOps(i);
            if (rOps != 0) {
                SelectionKeyImpl sk = this.channelArray[i];
                this.pollWrapper.putReventOps(i, 0);
                if (!this.selectedKeys.contains(sk)) {
                    sk.channel.translateAndSetReadyOps(rOps, sk);
                    if ((sk.nioReadyOps() & sk.nioInterestOps()) != 0) {
                        this.selectedKeys.add(sk);
                        numKeysUpdated++;
                    }
                } else if (sk.channel.translateAndSetReadyOps(rOps, sk)) {
                    numKeysUpdated++;
                }
            }
        }
        return numKeysUpdated;
    }

    /* access modifiers changed from: protected */
    public void implRegister(SelectionKeyImpl ski) {
        synchronized (this.closeLock) {
            if (this.closed) {
                throw new ClosedSelectorException();
            }
            if (this.channelArray.length == this.totalChannels) {
                int newSize = this.pollWrapper.totalChannels * 2;
                SelectionKeyImpl[] temp = new SelectionKeyImpl[newSize];
                for (int i = this.channelOffset; i < this.totalChannels; i++) {
                    temp[i] = this.channelArray[i];
                }
                this.channelArray = temp;
                this.pollWrapper.grow(newSize);
            }
            this.channelArray[this.totalChannels] = ski;
            ski.setIndex(this.totalChannels);
            this.pollWrapper.addEntry(ski.channel);
            this.totalChannels++;
            this.keys.add(ski);
        }
    }

    /* access modifiers changed from: protected */
    public void implDereg(SelectionKeyImpl ski) throws IOException {
        boolean z = false;
        int i = ski.getIndex();
        if (!f120assertionsDisabled) {
            if (i >= 0) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (i != this.totalChannels - 1) {
            SelectionKeyImpl endChannel = this.channelArray[this.totalChannels - 1];
            this.channelArray[i] = endChannel;
            endChannel.setIndex(i);
            this.pollWrapper.release(i);
            PollArrayWrapper.replaceEntry(this.pollWrapper, this.totalChannels - 1, this.pollWrapper, i);
        } else {
            this.pollWrapper.release(i);
        }
        this.channelArray[this.totalChannels - 1] = null;
        this.totalChannels--;
        PollArrayWrapper pollArrayWrapper = this.pollWrapper;
        pollArrayWrapper.totalChannels--;
        ski.setIndex(-1);
        this.keys.remove(ski);
        this.selectedKeys.remove(ski);
        deregister(ski);
        SelectableChannel selch = ski.channel();
        if (!selch.isOpen() && !selch.isRegistered()) {
            ((SelChImpl) selch).kill();
        }
    }
}
