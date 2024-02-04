package java.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class BufferedInputStream extends FilterInputStream {
    private static final AtomicReferenceFieldUpdater<BufferedInputStream, byte[]> bufUpdater = null;
    private static int defaultBufferSize;
    protected volatile byte[] buf;
    protected int count;
    protected int marklimit;
    protected int markpos;
    protected int pos;

    private InputStream getInIfOpen() throws IOException {
        InputStream input = this.in;
        if (input != null) {
            return input;
        }
        throw new IOException("Stream closed");
    }

    private byte[] getBufIfOpen() throws IOException {
        byte[] buffer = this.buf;
        if (buffer != null) {
            return buffer;
        }
        throw new IOException("Stream closed");
    }

    public BufferedInputStream(InputStream in) {
        this(in, defaultBufferSize);
    }

    public BufferedInputStream(InputStream in, int size) {
        super(in);
        this.markpos = -1;
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.buf = new byte[size];
    }

    private void fill() throws IOException {
        byte[] buffer = getBufIfOpen();
        if (this.markpos < 0) {
            this.pos = 0;
        } else if (this.pos >= buffer.length) {
            if (this.markpos > 0) {
                int sz = this.pos - this.markpos;
                System.arraycopy(buffer, this.markpos, buffer, 0, sz);
                this.pos = sz;
                this.markpos = 0;
            } else if (buffer.length >= this.marklimit) {
                this.markpos = -1;
                this.pos = 0;
            } else {
                int nsz = this.pos * 2;
                if (nsz > this.marklimit) {
                    nsz = this.marklimit;
                }
                byte[] nbuf = new byte[nsz];
                System.arraycopy(buffer, 0, nbuf, 0, this.pos);
                if (!bufUpdater.compareAndSet(this, buffer, nbuf)) {
                    throw new IOException("Stream closed");
                }
                buffer = nbuf;
            }
        }
        this.count = this.pos;
        int n = getInIfOpen().read(buffer, this.pos, buffer.length - this.pos);
        if (n > 0) {
            this.count = this.pos + n;
        }
    }

    public synchronized int read() throws IOException {
        if (this.pos >= this.count) {
            fill();
            if (this.pos >= this.count) {
                return -1;
            }
        }
        byte[] bufIfOpen = getBufIfOpen();
        int i = this.pos;
        this.pos = i + 1;
        return bufIfOpen[i] & Character.DIRECTIONALITY_UNDEFINED;
    }

    private int read1(byte[] b, int off, int len) throws IOException {
        int avail = this.count - this.pos;
        if (avail <= 0) {
            if (len >= getBufIfOpen().length && this.markpos < 0) {
                return getInIfOpen().read(b, off, len);
            }
            fill();
            avail = this.count - this.pos;
            if (avail <= 0) {
                return -1;
            }
        }
        int cnt = avail < len ? avail : len;
        System.arraycopy(getBufIfOpen(), this.pos, b, off, cnt);
        this.pos += cnt;
        return cnt;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r8, int r9, int r10) throws java.io.IOException {
        /*
            r7 = this;
            r6 = 0
            monitor-enter(r7)
            r7.getBufIfOpen()     // Catch:{ all -> 0x0017 }
            r3 = r9 | r10
            int r4 = r9 + r10
            r3 = r3 | r4
            int r4 = r8.length     // Catch:{ all -> 0x0017 }
            int r5 = r9 + r10
            int r4 = r4 - r5
            r3 = r3 | r4
            if (r3 >= 0) goto L_0x001a
            java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0017 }
            r3.<init>()     // Catch:{ all -> 0x0017 }
            throw r3     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r3 = move-exception
            monitor-exit(r7)
            throw r3
        L_0x001a:
            if (r10 != 0) goto L_0x001e
            monitor-exit(r7)
            return r6
        L_0x001e:
            r1 = 0
        L_0x001f:
            int r3 = r9 + r1
            int r4 = r10 - r1
            int r2 = r7.read1(r8, r3, r4)     // Catch:{ all -> 0x0017 }
            if (r2 > 0) goto L_0x002f
            if (r1 != 0) goto L_0x002d
        L_0x002b:
            monitor-exit(r7)
            return r2
        L_0x002d:
            r2 = r1
            goto L_0x002b
        L_0x002f:
            int r1 = r1 + r2
            if (r1 < r10) goto L_0x0034
            monitor-exit(r7)
            return r1
        L_0x0034:
            java.io.InputStream r0 = r7.in     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x001f
            int r3 = r0.available()     // Catch:{ all -> 0x0017 }
            if (r3 > 0) goto L_0x001f
            monitor-exit(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedInputStream.read(byte[], int, int):int");
    }

    public synchronized long skip(long n) throws IOException {
        getBufIfOpen();
        if (n <= 0) {
            return 0;
        }
        long avail = (long) (this.count - this.pos);
        if (avail <= 0) {
            if (this.markpos < 0) {
                return getInIfOpen().skip(n);
            }
            fill();
            avail = (long) (this.count - this.pos);
            if (avail <= 0) {
                return 0;
            }
        }
        long skipped = avail < n ? avail : n;
        this.pos = (int) (((long) this.pos) + skipped);
        return skipped;
    }

    public synchronized int available() throws IOException {
        int i = Integer.MAX_VALUE;
        synchronized (this) {
            int n = this.count - this.pos;
            int avail = getInIfOpen().available();
            if (n <= Integer.MAX_VALUE - avail) {
                i = n + avail;
            }
        }
        return i;
    }

    public synchronized void mark(int readlimit) {
        this.marklimit = readlimit;
        this.markpos = this.pos;
    }

    public synchronized void reset() throws IOException {
        getBufIfOpen();
        if (this.markpos < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.pos = this.markpos;
    }

    public boolean markSupported() {
        return true;
    }

    public void close() throws IOException {
        byte[] buffer;
        do {
            buffer = this.buf;
            if (buffer == null) {
                return;
            }
        } while (!bufUpdater.compareAndSet(this, buffer, (Object) null));
        InputStream input = this.in;
        this.in = null;
        if (input != null) {
            input.close();
        }
    }
}
