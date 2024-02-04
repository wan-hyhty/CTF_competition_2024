package java.util.zip;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InflaterInputStream extends FilterInputStream {
    private byte[] b;
    protected byte[] buf;
    protected boolean closed;
    protected Inflater inf;
    protected int len;
    private boolean reachEOF;
    private byte[] singleByteBuf;

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public InflaterInputStream(InputStream in, Inflater inf2, int size) {
        super(in);
        this.closed = false;
        this.reachEOF = false;
        this.singleByteBuf = new byte[1];
        this.b = new byte[512];
        if (in == null || inf2 == null) {
            throw new NullPointerException();
        } else if (size <= 0) {
            throw new IllegalArgumentException("buffer size <= 0");
        } else {
            this.inf = inf2;
            this.buf = new byte[size];
        }
    }

    public InflaterInputStream(InputStream in, Inflater inf2) {
        this(in, inf2, 512);
    }

    public InflaterInputStream(InputStream in) {
        this(in, new Inflater());
    }

    public int read() throws IOException {
        ensureOpen();
        if (read(this.singleByteBuf, 0, 1) == -1) {
            return -1;
        }
        return this.singleByteBuf[0] & Character.DIRECTIONALITY_UNDEFINED;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 139 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r4 = 0
            r5.ensureOpen()
            if (r6 != 0) goto L_0x000c
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            r3.<init>()
            throw r3
        L_0x000c:
            if (r7 < 0) goto L_0x0010
            if (r8 >= 0) goto L_0x0016
        L_0x0010:
            java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException
            r3.<init>()
            throw r3
        L_0x0016:
            int r3 = r6.length
            int r3 = r3 - r7
            if (r8 > r3) goto L_0x0010
            if (r8 != 0) goto L_0x0028
            return r4
        L_0x001d:
            java.util.zip.Inflater r3 = r5.inf     // Catch:{ DataFormatException -> 0x0051 }
            boolean r3 = r3.needsInput()     // Catch:{ DataFormatException -> 0x0051 }
            if (r3 == 0) goto L_0x0028
            r5.fill()     // Catch:{ DataFormatException -> 0x0051 }
        L_0x0028:
            java.util.zip.Inflater r3 = r5.inf     // Catch:{ DataFormatException -> 0x0051 }
            int r1 = r3.inflate(r6, r7, r8)     // Catch:{ DataFormatException -> 0x0051 }
            if (r1 != 0) goto L_0x0045
            java.util.zip.Inflater r3 = r5.inf     // Catch:{ DataFormatException -> 0x0051 }
            boolean r3 = r3.finished()     // Catch:{ DataFormatException -> 0x0051 }
            if (r3 != 0) goto L_0x0040
            java.util.zip.Inflater r3 = r5.inf     // Catch:{ DataFormatException -> 0x0051 }
            boolean r3 = r3.needsDictionary()     // Catch:{ DataFormatException -> 0x0051 }
            if (r3 == 0) goto L_0x001d
        L_0x0040:
            r3 = 1
            r5.reachEOF = r3     // Catch:{ DataFormatException -> 0x0051 }
            r3 = -1
            return r3
        L_0x0045:
            java.util.zip.Inflater r3 = r5.inf     // Catch:{ DataFormatException -> 0x0051 }
            boolean r3 = r3.finished()     // Catch:{ DataFormatException -> 0x0051 }
            if (r3 == 0) goto L_0x0050
            r3 = 1
            r5.reachEOF = r3     // Catch:{ DataFormatException -> 0x0051 }
        L_0x0050:
            return r1
        L_0x0051:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()
            java.util.zip.ZipException r3 = new java.util.zip.ZipException
            if (r2 == 0) goto L_0x005e
        L_0x005a:
            r3.<init>(r2)
            throw r3
        L_0x005e:
            java.lang.String r2 = "Invalid ZLIB data format"
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.zip.InflaterInputStream.read(byte[], int, int):int");
    }

    public int available() throws IOException {
        ensureOpen();
        if (this.reachEOF) {
            return 0;
        }
        return 1;
    }

    public long skip(long n) throws IOException {
        if (n < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        ensureOpen();
        int max = (int) Math.min(n, 2147483647L);
        int total = 0;
        while (true) {
            if (total >= max) {
                break;
            }
            int len2 = max - total;
            if (len2 > this.b.length) {
                len2 = this.b.length;
            }
            int len3 = read(this.b, 0, len2);
            if (len3 == -1) {
                this.reachEOF = true;
                break;
            }
            total += len3;
        }
        return (long) total;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.inf.end();
            this.in.close();
            this.closed = true;
        }
    }

    /* access modifiers changed from: protected */
    public void fill() throws IOException {
        ensureOpen();
        this.len = this.in.read(this.buf, 0, this.buf.length);
        if (this.len == -1) {
            throw new EOFException("Unexpected end of ZLIB input stream");
        }
        this.inf.setInput(this.buf, 0, this.len);
    }

    public boolean markSupported() {
        return false;
    }

    public synchronized void mark(int readlimit) {
    }

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }
}
