package java.lang.ref;

public abstract class Reference<T> {
    private static boolean disableIntrinsic;
    private static boolean slowPathEnabled;
    Reference<?> pendingNext;
    final ReferenceQueue<? super T> queue;
    Reference queueNext;
    volatile T referent;

    private final native T getReferent();

    public T get() {
        return getReferent();
    }

    public void clear() {
        this.referent = null;
    }

    public boolean isEnqueued() {
        if (this.queue != null) {
            return this.queue.isEnqueued(this);
        }
        return false;
    }

    public boolean enqueue() {
        if (this.queue != null) {
            return this.queue.enqueue(this);
        }
        return false;
    }

    Reference(T referent2) {
        this(referent2, (ReferenceQueue) null);
    }

    Reference(T referent2, ReferenceQueue<? super T> queue2) {
        this.referent = referent2;
        this.queue = queue2;
    }
}
