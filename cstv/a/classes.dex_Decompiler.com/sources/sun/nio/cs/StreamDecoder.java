package sun.nio.cs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import sun.nio.ch.ChannelInputStream;

public class StreamDecoder extends Reader {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f139assertionsDisabled = false;
    private static final int DEFAULT_BYTE_BUFFER_SIZE = 8192;
    private static final int MIN_BYTE_BUFFER_SIZE = 32;
    private static volatile boolean channelsAvailable;
    private ByteBuffer bb;
    private ReadableByteChannel ch;
    private Charset cs;
    private CharsetDecoder decoder;
    private boolean haveLeftoverChar;
    private InputStream in;
    private volatile boolean isOpen;
    private char leftoverChar;
    private boolean needsFlush;

    private void ensureOpen() throws IOException {
        if (!this.isOpen) {
            throw new IOException("Stream closed");
        }
    }

    public static StreamDecoder forInputStreamReader(InputStream in2, Object lock, String charsetName) throws UnsupportedEncodingException {
        String csn = charsetName;
        if (charsetName == null) {
            csn = Charset.defaultCharset().name();
        }
        try {
            if (Charset.isSupported(csn)) {
                return new StreamDecoder(in2, lock, Charset.forName(csn));
            }
        } catch (IllegalCharsetNameException e) {
        }
        throw new UnsupportedEncodingException(csn);
    }

    public static StreamDecoder forInputStreamReader(InputStream in2, Object lock, Charset cs2) {
        return new StreamDecoder(in2, lock, cs2);
    }

    public static StreamDecoder forInputStreamReader(InputStream in2, Object lock, CharsetDecoder dec) {
        return new StreamDecoder(in2, lock, dec);
    }

    public static StreamDecoder forDecoder(ReadableByteChannel ch2, CharsetDecoder dec, int minBufferCap) {
        return new StreamDecoder(ch2, dec, minBufferCap);
    }

    public String getEncoding() {
        if (isOpen()) {
            return encodingName();
        }
        return null;
    }

    public int read() throws IOException {
        return read0();
    }

    private int read0() throws IOException {
        synchronized (this.lock) {
            if (this.haveLeftoverChar) {
                this.haveLeftoverChar = f139assertionsDisabled;
                char c = this.leftoverChar;
                return c;
            }
            char[] cb = new char[2];
            int n = read(cb, 0, 2);
            switch (n) {
                case -1:
                    return -1;
                case 1:
                    break;
                case 2:
                    this.leftoverChar = cb[1];
                    this.haveLeftoverChar = true;
                    break;
                default:
                    if (f139assertionsDisabled) {
                        return -1;
                    }
                    throw new AssertionError((Object) Integer.valueOf(n));
            }
            char c2 = cb[0];
            return c2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x004f, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(char[] r11, int r12, int r13) throws java.io.IOException {
        /*
            r10 = this;
            r9 = 1
            r4 = -1
            r8 = 0
            r3 = r12
            r1 = r13
            java.lang.Object r5 = r10.lock
            monitor-enter(r5)
            r10.ensureOpen()     // Catch:{ all -> 0x0016 }
            if (r12 < 0) goto L_0x0010
            int r6 = r11.length     // Catch:{ all -> 0x0016 }
            if (r12 <= r6) goto L_0x0019
        L_0x0010:
            java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0016 }
            r4.<init>()     // Catch:{ all -> 0x0016 }
            throw r4     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        L_0x0019:
            if (r13 < 0) goto L_0x0010
            int r6 = r12 + r13
            int r7 = r11.length     // Catch:{ all -> 0x0016 }
            if (r6 > r7) goto L_0x0010
            int r6 = r12 + r13
            if (r6 < 0) goto L_0x0010
            if (r13 != 0) goto L_0x0028
            monitor-exit(r5)
            return r8
        L_0x0028:
            r2 = 0
            boolean r6 = r10.haveLeftoverChar     // Catch:{ all -> 0x0016 }
            if (r6 == 0) goto L_0x0041
            char r6 = r10.leftoverChar     // Catch:{ all -> 0x0016 }
            r11[r12] = r6     // Catch:{ all -> 0x0016 }
            int r3 = r12 + 1
            int r1 = r13 + -1
            r6 = 0
            r10.haveLeftoverChar = r6     // Catch:{ all -> 0x0016 }
            r2 = 1
            if (r1 == 0) goto L_0x004e
            boolean r6 = r10.implReady()     // Catch:{ all -> 0x0016 }
            if (r6 == 0) goto L_0x004e
        L_0x0041:
            if (r1 != r9) goto L_0x0057
            int r0 = r10.read0()     // Catch:{ all -> 0x0016 }
            if (r0 != r4) goto L_0x0050
            if (r2 != 0) goto L_0x004c
            r2 = r4
        L_0x004c:
            monitor-exit(r5)
            return r2
        L_0x004e:
            monitor-exit(r5)
            return r9
        L_0x0050:
            char r4 = (char) r0
            r11[r3] = r4     // Catch:{ all -> 0x0016 }
            int r4 = r2 + 1
            monitor-exit(r5)
            return r4
        L_0x0057:
            int r4 = r3 + r1
            int r4 = r10.implRead(r11, r3, r4)     // Catch:{ all -> 0x0016 }
            int r4 = r4 + r2
            monitor-exit(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.cs.StreamDecoder.read(char[], int, int):int");
    }

    public boolean ready() throws IOException {
        boolean implReady;
        synchronized (this.lock) {
            ensureOpen();
            implReady = !this.haveLeftoverChar ? implReady() : true;
        }
        return implReady;
    }

    public void close() throws IOException {
        synchronized (this.lock) {
            if (this.isOpen) {
                implClose();
                this.isOpen = f139assertionsDisabled;
            }
        }
    }

    private boolean isOpen() {
        return this.isOpen;
    }

    private static FileChannel getChannel(FileInputStream in2) {
        if (!channelsAvailable) {
            return null;
        }
        try {
            return in2.getChannel();
        } catch (UnsatisfiedLinkError e) {
            channelsAvailable = f139assertionsDisabled;
            return null;
        }
    }

    StreamDecoder(InputStream in2, Object lock, Charset cs2) {
        this(in2, lock, cs2.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    StreamDecoder(InputStream in2, Object lock, CharsetDecoder dec) {
        super(lock);
        this.isOpen = true;
        this.haveLeftoverChar = f139assertionsDisabled;
        this.needsFlush = f139assertionsDisabled;
        this.cs = dec.charset();
        this.decoder = dec;
        if (this.ch == null) {
            this.in = in2;
            this.ch = null;
            this.bb = ByteBuffer.allocate(8192);
        }
        this.bb.flip();
    }

    StreamDecoder(ReadableByteChannel ch2, CharsetDecoder dec, int mbc) {
        this.isOpen = true;
        this.haveLeftoverChar = f139assertionsDisabled;
        this.needsFlush = f139assertionsDisabled;
        this.in = null;
        this.ch = ch2;
        this.decoder = dec;
        this.cs = dec.charset();
        if (mbc < 0) {
            mbc = 8192;
        } else if (mbc < 32) {
            mbc = 32;
        }
        this.bb = ByteBuffer.allocate(mbc);
        this.bb.flip();
    }

    private int readBytes() throws IOException {
        boolean z;
        boolean z2 = true;
        this.bb.compact();
        try {
            if (this.ch != null) {
                int n = ChannelInputStream.read(this.ch, this.bb);
                if (n < 0) {
                    return n;
                }
            } else {
                int lim = this.bb.limit();
                int pos = this.bb.position();
                if (!f139assertionsDisabled) {
                    if (!(pos <= lim)) {
                        throw new AssertionError();
                    }
                }
                int rem = pos <= lim ? lim - pos : 0;
                if (!f139assertionsDisabled) {
                    if (rem > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                int n2 = this.in.read(this.bb.array(), this.bb.arrayOffset() + pos, rem);
                if (n2 < 0) {
                    this.bb.flip();
                    return n2;
                } else if (n2 == 0) {
                    throw new IOException("Underlying input stream returned zero bytes");
                } else {
                    if (!f139assertionsDisabled) {
                        if (!(n2 <= rem)) {
                            throw new AssertionError((Object) "n = " + n2 + ", rem = " + rem);
                        }
                    }
                    this.bb.position(pos + n2);
                }
            }
            this.bb.flip();
            int rem2 = this.bb.remaining();
            if (!f139assertionsDisabled) {
                if (rem2 == 0) {
                    z2 = false;
                }
                if (!z2) {
                    throw new AssertionError((Object) Integer.valueOf(rem2));
                }
            }
            return rem2;
        } finally {
            this.bb.flip();
        }
    }

    /* access modifiers changed from: package-private */
    public int implRead(char[] cbuf, int off, int end) throws IOException {
        boolean z = f139assertionsDisabled;
        if (!f139assertionsDisabled) {
            if (!(end - off > 1)) {
                throw new AssertionError();
            }
        }
        CharBuffer cb = CharBuffer.wrap(cbuf, off, end - off);
        if (cb.position() != 0) {
            cb = cb.slice();
        }
        if (this.needsFlush) {
            CoderResult cr = this.decoder.flush(cb);
            if (cr.isOverflow()) {
                return cb.position();
            }
            if (!cr.isUnderflow()) {
                cr.throwException();
            } else if (cb.position() == 0) {
                return -1;
            } else {
                return cb.position();
            }
        }
        boolean eof = f139assertionsDisabled;
        while (true) {
            CoderResult cr2 = this.decoder.decode(this.bb, cb, eof);
            if (cr2.isUnderflow()) {
                if (eof || !cb.hasRemaining() || (cb.position() > 0 && !inReady())) {
                    break;
                } else if (readBytes() < 0) {
                    eof = true;
                }
            } else if (!cr2.isOverflow()) {
                cr2.throwException();
            } else if (!f139assertionsDisabled) {
                if (cb.position() > 0) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
        }
        if (eof) {
            CoderResult cr3 = this.decoder.flush(cb);
            if (cr3.isOverflow()) {
                this.needsFlush = true;
                return cb.position();
            }
            this.decoder.reset();
            if (!cr3.isUnderflow()) {
                cr3.throwException();
            }
        }
        if (cb.position() == 0) {
            if (eof) {
                return -1;
            }
            if (!f139assertionsDisabled) {
                throw new AssertionError();
            }
        }
        return cb.position();
    }

    /* access modifiers changed from: package-private */
    public String encodingName() {
        if (this.cs instanceof HistoricallyNamedCharset) {
            return ((HistoricallyNamedCharset) this.cs).historicalName();
        }
        return this.cs.name();
    }

    private boolean inReady() {
        try {
            if (this.in == null || this.in.available() <= 0) {
                return this.ch instanceof FileChannel;
            }
            return true;
        } catch (IOException e) {
            return f139assertionsDisabled;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean implReady() {
        if (!this.bb.hasRemaining()) {
            return inReady();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void implClose() throws IOException {
        if (this.ch != null) {
            this.ch.close();
        } else {
            this.in.close();
        }
    }
}
