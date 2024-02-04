package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public abstract class AbstractSelectableChannel extends SelectableChannel {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f21assertionsDisabled = false;
    boolean blocking = true;
    private int keyCount = 0;
    private final Object keyLock = new Object();
    private SelectionKey[] keys = null;
    private final SelectorProvider provider;
    private final Object regLock = new Object();

    /* access modifiers changed from: protected */
    public abstract void implCloseSelectableChannel() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void implConfigureBlocking(boolean z) throws IOException;

    protected AbstractSelectableChannel(SelectorProvider provider2) {
        this.provider = provider2;
    }

    public final SelectorProvider provider() {
        return this.provider;
    }

    private void addKey(SelectionKey k) {
        if (f21assertionsDisabled || Thread.holdsLock(this.keyLock)) {
            int i = 0;
            if (this.keys != null && this.keyCount < this.keys.length) {
                i = 0;
                while (i < this.keys.length && this.keys[i] != null) {
                    i++;
                }
            } else if (this.keys == null) {
                this.keys = new SelectionKey[3];
            } else {
                SelectionKey[] ks = new SelectionKey[(this.keys.length * 2)];
                for (int i2 = 0; i2 < this.keys.length; i2++) {
                    ks[i2] = this.keys[i2];
                }
                this.keys = ks;
                i = this.keyCount;
            }
            this.keys[i] = k;
            this.keyCount++;
            return;
        }
        throw new AssertionError();
    }

    private SelectionKey findKey(Selector sel) {
        synchronized (this.keyLock) {
            if (this.keys == null) {
                return null;
            }
            int i = 0;
            while (i < this.keys.length) {
                if (this.keys[i] == null || this.keys[i].selector() != sel) {
                    i++;
                } else {
                    SelectionKey selectionKey = this.keys[i];
                    return selectionKey;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void removeKey(SelectionKey k) {
        synchronized (this.keyLock) {
            for (int i = 0; i < this.keys.length; i++) {
                if (this.keys[i] == k) {
                    this.keys[i] = null;
                    this.keyCount--;
                }
            }
            ((AbstractSelectionKey) k).invalidate();
        }
    }

    private boolean haveValidKeys() {
        synchronized (this.keyLock) {
            if (this.keyCount == 0) {
                return false;
            }
            for (int i = 0; i < this.keys.length; i++) {
                if (this.keys[i] != null && this.keys[i].isValid()) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean isRegistered() {
        boolean z = false;
        synchronized (this.keyLock) {
            if (this.keyCount != 0) {
                z = true;
            }
        }
        return z;
    }

    public final SelectionKey keyFor(Selector sel) {
        return findKey(sel);
    }

    public final SelectionKey register(Selector sel, int ops, Object att) throws ClosedChannelException {
        SelectionKey k;
        synchronized (this.regLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (((~validOps()) & ops) != 0) {
                throw new IllegalArgumentException();
            } else if (this.blocking) {
                throw new IllegalBlockingModeException();
            } else {
                k = findKey(sel);
                if (k != null) {
                    k.interestOps(ops);
                    k.attach(att);
                }
                if (k == null) {
                    synchronized (this.keyLock) {
                        if (!isOpen()) {
                            throw new ClosedChannelException();
                        }
                        k = ((AbstractSelector) sel).register(this, ops, att);
                        addKey(k);
                    }
                }
            }
        }
        return k;
    }

    /* access modifiers changed from: protected */
    public final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
        synchronized (this.keyLock) {
            int count = this.keys == null ? 0 : this.keys.length;
            for (int i = 0; i < count; i++) {
                SelectionKey k = this.keys[i];
                if (k != null) {
                    k.cancel();
                }
            }
        }
    }

    public final boolean isBlocking() {
        boolean z;
        synchronized (this.regLock) {
            z = this.blocking;
        }
        return z;
    }

    public final Object blockingLock() {
        return this.regLock;
    }

    public final SelectableChannel configureBlocking(boolean block) throws IOException {
        synchronized (this.regLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (this.blocking == block) {
                return this;
            } else {
                if (block) {
                    if (haveValidKeys()) {
                        throw new IllegalBlockingModeException();
                    }
                }
                implConfigureBlocking(block);
                this.blocking = block;
                return this;
            }
        }
    }
}
