package java.io;

public class PushbackReader extends FilterReader {
    private char[] buf;
    private int pos;

    public PushbackReader(Reader in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = new char[size];
        this.pos = size;
    }

    public PushbackReader(Reader in) {
        this(in, 1);
    }

    private void ensureOpen() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream closed");
        }
    }

    public int read() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (this.pos < this.buf.length) {
                char[] cArr = this.buf;
                int i = this.pos;
                this.pos = i + 1;
                char c = cArr[i];
                return c;
            }
            int read = super.read();
            return read;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004f, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            r2 = -1
            r4 = 0
            java.lang.Object r3 = r6.lock
            monitor-enter(r3)
            r6.ensureOpen()     // Catch:{ all -> 0x0019 }
            if (r9 > 0) goto L_0x0029
            if (r9 >= 0) goto L_0x001c
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            r2.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            throw r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
        L_0x0012:
            r1 = move-exception
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0019 }
            r2.<init>()     // Catch:{ all -> 0x0019 }
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        L_0x001c:
            if (r8 < 0) goto L_0x0021
            int r2 = r7.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            if (r8 <= r2) goto L_0x0027
        L_0x0021:
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            r2.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            throw r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
        L_0x0027:
            monitor-exit(r3)
            return r4
        L_0x0029:
            char[] r4 = r6.buf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            int r4 = r4.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            int r5 = r6.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            int r0 = r4 - r5
            if (r0 <= 0) goto L_0x0043
            if (r9 >= r0) goto L_0x0035
            r0 = r9
        L_0x0035:
            char[] r4 = r6.buf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            int r5 = r6.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            java.lang.System.arraycopy((char[]) r4, (int) r5, (char[]) r7, (int) r8, (int) r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            int r4 = r6.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            int r4 = r4 + r0
            r6.pos = r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            int r8 = r8 + r0
            int r9 = r9 - r0
        L_0x0043:
            if (r9 <= 0) goto L_0x0054
            int r9 = super.read(r7, r8, r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0012 }
            if (r9 != r2) goto L_0x0050
            if (r0 != 0) goto L_0x004e
            r0 = r2
        L_0x004e:
            monitor-exit(r3)
            return r0
        L_0x0050:
            int r2 = r0 + r9
            monitor-exit(r3)
            return r2
        L_0x0054:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PushbackReader.read(char[], int, int):int");
    }

    public void unread(int c) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (this.pos == 0) {
                throw new IOException("Pushback buffer overflow");
            }
            char[] cArr = this.buf;
            int i = this.pos - 1;
            this.pos = i;
            cArr[i] = (char) c;
        }
    }

    public void unread(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (len > this.pos) {
                throw new IOException("Pushback buffer overflow");
            }
            this.pos -= len;
            System.arraycopy(cbuf, off, this.buf, this.pos, len);
        }
    }

    public void unread(char[] cbuf) throws IOException {
        unread(cbuf, 0, cbuf.length);
    }

    public boolean ready() throws IOException {
        boolean ready;
        synchronized (this.lock) {
            ensureOpen();
            ready = this.pos >= this.buf.length ? super.ready() : true;
        }
        return ready;
    }

    public void mark(int readAheadLimit) throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public boolean markSupported() {
        return false;
    }

    public void close() throws IOException {
        super.close();
        this.buf = null;
    }

    public long skip(long n) throws IOException {
        if (n < 0) {
            throw new IllegalArgumentException("skip value is negative");
        }
        synchronized (this.lock) {
            ensureOpen();
            int avail = this.buf.length - this.pos;
            if (avail > 0) {
                if (n <= ((long) avail)) {
                    this.pos = (int) (((long) this.pos) + n);
                    return n;
                }
                this.pos = this.buf.length;
                n -= (long) avail;
            }
            long skip = ((long) avail) + super.skip(n);
            return skip;
        }
    }
}
