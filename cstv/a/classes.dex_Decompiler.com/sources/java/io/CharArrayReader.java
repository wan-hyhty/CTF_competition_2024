package java.io;

public class CharArrayReader extends Reader {
    protected char[] buf;
    protected int count;
    protected int markedPos = 0;
    protected int pos;

    public CharArrayReader(char[] buf2) {
        this.buf = buf2;
        this.pos = 0;
        this.count = buf2.length;
    }

    public CharArrayReader(char[] buf2, int offset, int length) {
        if (offset < 0 || offset > buf2.length || length < 0 || offset + length < 0) {
            throw new IllegalArgumentException();
        }
        this.buf = buf2;
        this.pos = offset;
        this.count = Math.min(offset + length, buf2.length);
        this.markedPos = offset;
    }

    private void ensureOpen() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream closed");
        }
    }

    public int read() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (this.pos >= this.count) {
                return -1;
            }
            char[] cArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            char c = cArr[i];
            return c;
        }
    }

    public int read(char[] b, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (off >= 0 && off <= b.length && len >= 0) {
                if (off + len <= b.length && off + len >= 0) {
                    if (len == 0) {
                        return 0;
                    }
                    if (this.pos >= this.count) {
                        return -1;
                    }
                    if (this.pos + len > this.count) {
                        len = this.count - this.pos;
                    }
                    if (len <= 0) {
                        return 0;
                    }
                    System.arraycopy(this.buf, this.pos, b, off, len);
                    this.pos += len;
                    return len;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public long skip(long n) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (((long) this.pos) + n > ((long) this.count)) {
                n = (long) (this.count - this.pos);
            }
            if (n < 0) {
                return 0;
            }
            this.pos = (int) (((long) this.pos) + n);
            return n;
        }
    }

    public boolean ready() throws IOException {
        boolean z = false;
        synchronized (this.lock) {
            ensureOpen();
            if (this.count - this.pos > 0) {
                z = true;
            }
        }
        return z;
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int readAheadLimit) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            this.markedPos = this.pos;
        }
    }

    public void reset() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            this.pos = this.markedPos;
        }
    }

    public void close() {
        this.buf = null;
    }
}
