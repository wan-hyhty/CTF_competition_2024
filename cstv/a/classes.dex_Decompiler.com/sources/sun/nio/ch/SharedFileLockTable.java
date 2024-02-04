package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.channels.Channel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: FileLockTable */
class SharedFileLockTable extends FileLockTable {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f132assertionsDisabled = false;
    private static ConcurrentHashMap<FileKey, List<FileLockReference>> lockMap;
    private static ReferenceQueue<FileLock> queue;
    private final Channel channel;
    private final FileKey fileKey;

    /* compiled from: FileLockTable */
    private static class FileLockReference extends WeakReference<FileLock> {
        private FileKey fileKey;

        FileLockReference(FileLock referent, ReferenceQueue<FileLock> queue, FileKey key) {
            super(referent, queue);
            this.fileKey = key;
        }

        /* access modifiers changed from: package-private */
        public FileKey fileKey() {
            return this.fileKey;
        }
    }

    SharedFileLockTable(Channel channel2, FileDescriptor fd) throws IOException {
        this.channel = channel2;
        this.fileKey = FileKey.create(fd);
    }

    public void add(FileLock fl) throws OverlappingFileLockException {
        List<FileLockReference> list;
        List<FileLockReference> prev;
        List<FileLockReference> list2 = lockMap.get(this.fileKey);
        while (true) {
            if (list2 == null) {
                list2 = new ArrayList<>(2);
                synchronized (list2) {
                    prev = lockMap.putIfAbsent(this.fileKey, list2);
                    if (prev == null) {
                        list2.add(new FileLockReference(fl, queue, this.fileKey));
                        break;
                    }
                }
                list2 = prev;
            }
            synchronized (list2) {
                List<FileLockReference> current = lockMap.get(this.fileKey);
                if (list2 == current) {
                    checkList(list2, fl.position(), fl.size());
                    list2.add(new FileLockReference(fl, queue, this.fileKey));
                    break;
                }
                list = current;
            }
            list2 = list;
        }
        removeStaleEntries();
    }

    private void removeKeyIfEmpty(FileKey fk, List<FileLockReference> list) {
        if (f132assertionsDisabled || Thread.holdsLock(list)) {
            if (!f132assertionsDisabled) {
                if (!(lockMap.get(fk) == list)) {
                    throw new AssertionError();
                }
            }
            if (list.isEmpty()) {
                lockMap.remove(fk);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (f132assertionsDisabled != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r2 == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (r2.acquiredBy() != r8.channel) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r4 != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r3.clear();
        r1.remove(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void remove(java.nio.channels.FileLock r9) {
        /*
            r8 = this;
            r4 = 1
            r5 = 0
            boolean r6 = f132assertionsDisabled
            if (r6 != 0) goto L_0x0013
            if (r9 == 0) goto L_0x0011
            r6 = r4
        L_0x0009:
            if (r6 != 0) goto L_0x0013
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x0011:
            r6 = r5
            goto L_0x0009
        L_0x0013:
            java.util.concurrent.ConcurrentHashMap<sun.nio.ch.FileKey, java.util.List<sun.nio.ch.SharedFileLockTable$FileLockReference>> r6 = lockMap
            sun.nio.ch.FileKey r7 = r8.fileKey
            java.lang.Object r1 = r6.get(r7)
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto L_0x0020
            return
        L_0x0020:
            monitor-enter(r1)
            r0 = 0
        L_0x0022:
            int r6 = r1.size()     // Catch:{ all -> 0x004c }
            if (r0 >= r6) goto L_0x0057
            java.lang.Object r3 = r1.get(r0)     // Catch:{ all -> 0x004c }
            sun.nio.ch.SharedFileLockTable$FileLockReference r3 = (sun.nio.ch.SharedFileLockTable.FileLockReference) r3     // Catch:{ all -> 0x004c }
            java.lang.Object r2 = r3.get()     // Catch:{ all -> 0x004c }
            java.nio.channels.FileLock r2 = (java.nio.channels.FileLock) r2     // Catch:{ all -> 0x004c }
            if (r2 != r9) goto L_0x0059
            boolean r6 = f132assertionsDisabled     // Catch:{ all -> 0x004c }
            if (r6 != 0) goto L_0x0051
            if (r2 == 0) goto L_0x004f
            java.nio.channels.Channel r6 = r2.acquiredBy()     // Catch:{ all -> 0x004c }
            java.nio.channels.Channel r7 = r8.channel     // Catch:{ all -> 0x004c }
            if (r6 != r7) goto L_0x004f
        L_0x0044:
            if (r4 != 0) goto L_0x0051
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            throw r4     // Catch:{ all -> 0x004c }
        L_0x004c:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L_0x004f:
            r4 = r5
            goto L_0x0044
        L_0x0051:
            r3.clear()     // Catch:{ all -> 0x004c }
            r1.remove((int) r0)     // Catch:{ all -> 0x004c }
        L_0x0057:
            monitor-exit(r1)
            return
        L_0x0059:
            int r0 = r0 + 1
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SharedFileLockTable.remove(java.nio.channels.FileLock):void");
    }

    public List<FileLock> removeAll() {
        List<FileLock> result = new ArrayList<>();
        List<FileLockReference> list = lockMap.get(this.fileKey);
        if (list != null) {
            synchronized (list) {
                int index = 0;
                while (index < list.size()) {
                    FileLockReference ref = list.get(index);
                    FileLock lock = (FileLock) ref.get();
                    if (lock == null || lock.acquiredBy() != this.channel) {
                        index++;
                    } else {
                        ref.clear();
                        list.remove(index);
                        result.add(lock);
                    }
                }
                removeKeyIfEmpty(this.fileKey, list);
            }
        }
        return result;
    }

    public void replace(FileLock fromLock, FileLock toLock) {
        List<FileLockReference> list = lockMap.get(this.fileKey);
        if (!f132assertionsDisabled) {
            if (!(list != null)) {
                throw new AssertionError();
            }
        }
        synchronized (list) {
            int index = 0;
            while (true) {
                if (index >= list.size()) {
                    break;
                }
                FileLockReference ref = list.get(index);
                if (((FileLock) ref.get()) == fromLock) {
                    ref.clear();
                    list.set(index, new FileLockReference(toLock, queue, this.fileKey));
                    break;
                }
                index++;
            }
        }
    }

    private void checkList(List<FileLockReference> list, long position, long size) throws OverlappingFileLockException {
        if (f132assertionsDisabled || Thread.holdsLock(list)) {
            for (FileLockReference ref : list) {
                FileLock fl = (FileLock) ref.get();
                if (fl != null && fl.overlaps(position, size)) {
                    throw new OverlappingFileLockException();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    private void removeStaleEntries() {
        while (true) {
            FileLockReference ref = (FileLockReference) queue.poll();
            if (ref != null) {
                FileKey fk = ref.fileKey();
                List<FileLockReference> list = lockMap.get(fk);
                if (list != null) {
                    synchronized (list) {
                        list.remove((Object) ref);
                        removeKeyIfEmpty(fk, list);
                    }
                }
            } else {
                return;
            }
        }
    }
}
