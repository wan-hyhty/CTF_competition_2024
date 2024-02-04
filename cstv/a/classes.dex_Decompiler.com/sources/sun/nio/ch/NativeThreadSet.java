package sun.nio.ch;

class NativeThreadSet {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f129assertionsDisabled = false;
    private long[] elts;
    private int used = 0;
    private boolean waitingToEmpty;

    NativeThreadSet(int n) {
        this.elts = new long[n];
    }

    /* access modifiers changed from: package-private */
    public int add() {
        long th = NativeThread.current();
        if (th == 0) {
            th = -1;
        }
        synchronized (this) {
            int start = 0;
            if (this.used >= this.elts.length) {
                int on = this.elts.length;
                long[] nelts = new long[(on * 2)];
                System.arraycopy(this.elts, 0, nelts, 0, on);
                this.elts = nelts;
                start = on;
            }
            for (int i = start; i < this.elts.length; i++) {
                if (this.elts[i] == 0) {
                    this.elts[i] = th;
                    this.used++;
                    return i;
                }
            }
            if (f129assertionsDisabled) {
                return -1;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void remove(int i) {
        synchronized (this) {
            this.elts[i] = 0;
            this.used--;
            if (this.used == 0 && this.waitingToEmpty) {
                notifyAll();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void signalAndWait() {
        synchronized (this) {
            int u = this.used;
            for (long th : this.elts) {
                if (th != 0) {
                    if (th != -1) {
                        NativeThread.signal(th);
                    }
                    u--;
                    if (u == 0) {
                        break;
                    }
                }
            }
            this.waitingToEmpty = true;
            boolean interrupted = false;
            while (this.used > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
