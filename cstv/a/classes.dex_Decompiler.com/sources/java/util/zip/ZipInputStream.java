package java.util.zip;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ZipInputStream extends InflaterInputStream implements ZipConstants {
    private static final int DEFLATED = 8;
    private static final int STORED = 0;
    private byte[] b;
    private boolean closed;
    private CRC32 crc;
    private ZipEntry entry;
    private boolean entryEOF;
    private int flag;
    private long remaining;
    private byte[] tmpbuf;
    private ZipCoder zc;

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public ZipInputStream(InputStream in) {
        this(in, StandardCharsets.UTF_8);
    }

    public ZipInputStream(InputStream in, Charset charset) {
        super(new PushbackInputStream(in, 512), new Inflater(true), 512);
        this.crc = new CRC32();
        this.tmpbuf = new byte[512];
        this.closed = false;
        this.entryEOF = false;
        this.b = new byte[256];
        if (in == null) {
            throw new NullPointerException("in is null");
        } else if (charset == null) {
            throw new NullPointerException("charset is null");
        } else {
            this.zc = ZipCoder.get(charset);
        }
    }

    public ZipEntry getNextEntry() throws IOException {
        ensureOpen();
        if (this.entry != null) {
            closeEntry();
        }
        this.crc.reset();
        this.inf.reset();
        ZipEntry readLOC = readLOC();
        this.entry = readLOC;
        if (readLOC == null) {
            return null;
        }
        if (this.entry.method == 0 || this.entry.method == 8) {
            this.remaining = this.entry.size;
        }
        this.entryEOF = false;
        return this.entry;
    }

    public void closeEntry() throws IOException {
        ensureOpen();
        do {
        } while (read(this.tmpbuf, 0, this.tmpbuf.length) != -1);
        this.entryEOF = true;
    }

    public int available() throws IOException {
        ensureOpen();
        if (this.entryEOF) {
            return 0;
        }
        if (this.entry == null || this.remaining != 0) {
            return 1;
        }
        return 0;
    }

    public int read(byte[] b2, int off, int len) throws IOException {
        ensureOpen();
        if (off < 0 || len < 0 || off > b2.length - len) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        } else {
            if (this.entry == null) {
                return -1;
            }
            switch (this.entry.method) {
                case 0:
                    if (this.remaining <= 0) {
                        this.entryEOF = true;
                        this.entry = null;
                        return -1;
                    }
                    if (((long) len) > this.remaining) {
                        len = (int) this.remaining;
                    }
                    int len2 = this.in.read(b2, off, len);
                    if (len2 == -1) {
                        throw new ZipException("unexpected EOF");
                    }
                    this.crc.update(b2, off, len2);
                    this.remaining -= (long) len2;
                    if (this.remaining != 0 || this.entry.crc == this.crc.getValue()) {
                        return len2;
                    }
                    throw new ZipException("invalid entry CRC (expected 0x" + Long.toHexString(this.entry.crc) + " but got 0x" + Long.toHexString(this.crc.getValue()) + ")");
                case 8:
                    int len3 = super.read(b2, off, len);
                    if (len3 == -1) {
                        readEnd(this.entry);
                        this.entryEOF = true;
                        this.entry = null;
                    } else {
                        this.crc.update(b2, off, len3);
                        this.remaining -= (long) len3;
                    }
                    return len3;
                default:
                    throw new ZipException("invalid compression method");
            }
        }
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
            int len = max - total;
            if (len > this.tmpbuf.length) {
                len = this.tmpbuf.length;
            }
            int len2 = read(this.tmpbuf, 0, len);
            if (len2 == -1) {
                this.entryEOF = true;
                break;
            }
            total += len2;
        }
        return (long) total;
    }

    public void close() throws IOException {
        if (!this.closed) {
            super.close();
            this.closed = true;
        }
    }

    private ZipEntry readLOC() throws IOException {
        String zipCoder;
        try {
            readFully(this.tmpbuf, 0, 30);
            if (get32(this.tmpbuf, 0) != ZipConstants.LOCSIG) {
                return null;
            }
            this.flag = get16(this.tmpbuf, 6);
            int len = get16(this.tmpbuf, 26);
            int blen = this.b.length;
            if (len > blen) {
                do {
                    blen *= 2;
                } while (len > blen);
                this.b = new byte[blen];
            }
            readFully(this.b, 0, len);
            if ((this.flag & 2048) != 0) {
                zipCoder = this.zc.toStringUTF8(this.b, len);
            } else {
                zipCoder = this.zc.toString(this.b, len);
            }
            ZipEntry e = createZipEntry(zipCoder);
            if ((this.flag & 1) == 1) {
                throw new ZipException("encrypted ZIP entry not supported");
            }
            e.method = get16(this.tmpbuf, 8);
            e.time = get32(this.tmpbuf, 10);
            if ((this.flag & 8) != 8) {
                e.crc = get32(this.tmpbuf, 14);
                e.csize = get32(this.tmpbuf, 18);
                e.size = get32(this.tmpbuf, 22);
            } else if (e.method != 8) {
                throw new ZipException("only DEFLATED entries can have EXT descriptor");
            }
            int len2 = get16(this.tmpbuf, 28);
            if (len2 > 0) {
                byte[] bb = new byte[len2];
                readFully(bb, 0, len2);
                e.setExtra(bb);
                if (e.csize == 4294967295L || e.size == 4294967295L) {
                    int off = 0;
                    while (true) {
                        if (off + 4 >= len2) {
                            break;
                        }
                        int sz = get16(bb, off + 2);
                        if (get16(bb, off) == 1) {
                            int off2 = off + 4;
                            if (sz < 16 || off2 + sz > len2) {
                                return e;
                            }
                            e.size = get64(bb, off2);
                            e.csize = get64(bb, off2 + 8);
                        } else {
                            off += sz + 4;
                        }
                    }
                }
            }
            return e;
        } catch (EOFException e2) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public ZipEntry createZipEntry(String name) {
        return new ZipEntry(name);
    }

    private void readEnd(ZipEntry e) throws IOException {
        int n = this.inf.getRemaining();
        if (n > 0) {
            ((PushbackInputStream) this.in).unread(this.buf, this.len - n, n);
        }
        if ((this.flag & 8) == 8) {
            if (this.inf.getBytesWritten() > 4294967295L || this.inf.getBytesRead() > 4294967295L) {
                readFully(this.tmpbuf, 0, 24);
                long sig = get32(this.tmpbuf, 0);
                if (sig != ZipConstants.EXTSIG) {
                    e.crc = sig;
                    e.csize = get64(this.tmpbuf, 4);
                    e.size = get64(this.tmpbuf, 12);
                    ((PushbackInputStream) this.in).unread(this.tmpbuf, 19, 4);
                } else {
                    e.crc = get32(this.tmpbuf, 4);
                    e.csize = get64(this.tmpbuf, 8);
                    e.size = get64(this.tmpbuf, 16);
                }
            } else {
                readFully(this.tmpbuf, 0, 16);
                long sig2 = get32(this.tmpbuf, 0);
                if (sig2 != ZipConstants.EXTSIG) {
                    e.crc = sig2;
                    e.csize = get32(this.tmpbuf, 4);
                    e.size = get32(this.tmpbuf, 8);
                    ((PushbackInputStream) this.in).unread(this.tmpbuf, 11, 4);
                } else {
                    e.crc = get32(this.tmpbuf, 4);
                    e.csize = get32(this.tmpbuf, 8);
                    e.size = get32(this.tmpbuf, 12);
                }
            }
        }
        if (e.size != this.inf.getBytesWritten()) {
            throw new ZipException("invalid entry size (expected " + e.size + " but got " + this.inf.getBytesWritten() + " bytes)");
        } else if (e.csize != this.inf.getBytesRead()) {
            throw new ZipException("invalid entry compressed size (expected " + e.csize + " but got " + this.inf.getBytesRead() + " bytes)");
        } else if (e.crc != this.crc.getValue()) {
            throw new ZipException("invalid entry CRC (expected 0x" + Long.toHexString(e.crc) + " but got 0x" + Long.toHexString(this.crc.getValue()) + ")");
        }
    }

    private void readFully(byte[] b2, int off, int len) throws IOException {
        while (len > 0) {
            int n = this.in.read(b2, off, len);
            if (n == -1) {
                throw new EOFException();
            }
            off += n;
            len -= n;
        }
    }

    private static final int get16(byte[] b2, int off) {
        return (b2[off] & Character.DIRECTIONALITY_UNDEFINED) | ((b2[off + 1] & Character.DIRECTIONALITY_UNDEFINED) << 8);
    }

    private static final long get32(byte[] b2, int off) {
        return (((long) get16(b2, off)) | (((long) get16(b2, off + 2)) << 16)) & 4294967295L;
    }

    private static final long get64(byte[] b2, int off) {
        return get32(b2, off) | (get32(b2, off + 4) << 32);
    }
}
