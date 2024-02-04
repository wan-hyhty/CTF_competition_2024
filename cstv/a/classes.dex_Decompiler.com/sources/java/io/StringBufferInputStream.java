package java.io;

@Deprecated
public class StringBufferInputStream extends InputStream {
    protected String buffer;
    protected int count;
    protected int pos;

    public StringBufferInputStream(String s) {
        this.buffer = s;
        this.count = s.length();
    }

    public synchronized int read() {
        char c;
        if (this.pos < this.count) {
            String str = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            c = str.charAt(i) & 255;
        } else {
            c = 65535;
        }
        return c;
    }

    public synchronized int read(byte[] b, int off, int len) {
        if (b == null) {
            try {
                throw new NullPointerException();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } else {
            if (off >= 0) {
                if (off <= b.length && len >= 0 && off + len <= b.length && off + len >= 0) {
                    if (this.pos >= this.count) {
                        return -1;
                    }
                    if (this.pos + len > this.count) {
                        len = this.count - this.pos;
                    }
                    if (len <= 0) {
                        return 0;
                    }
                    String s = this.buffer;
                    int cnt = len;
                    while (true) {
                        cnt--;
                        if (cnt < 0) {
                            return len;
                        }
                        int off2 = off + 1;
                        try {
                            int i = this.pos;
                            this.pos = i + 1;
                            b[off] = (byte) s.charAt(i);
                            off = off2;
                        } catch (Throwable th2) {
                            th = th2;
                            int i2 = off2;
                            throw th;
                        }
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized long skip(long n) {
        if (n < 0) {
            return 0;
        }
        if (n > ((long) (this.count - this.pos))) {
            n = (long) (this.count - this.pos);
        }
        this.pos = (int) (((long) this.pos) + n);
        return n;
    }

    public synchronized int available() {
        return this.count - this.pos;
    }

    public synchronized void reset() {
        this.pos = 0;
    }
}
