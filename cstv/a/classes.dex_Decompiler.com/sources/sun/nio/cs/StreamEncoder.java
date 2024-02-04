package sun.nio.cs;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;

public class StreamEncoder extends Writer {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f140assertionsDisabled = false;
    private static final int DEFAULT_BYTE_BUFFER_SIZE = 8192;
    private ByteBuffer bb;
    private WritableByteChannel ch;
    private Charset cs;
    private CharsetEncoder encoder;
    private boolean haveLeftoverChar;
    private volatile boolean isOpen;
    private CharBuffer lcb;
    private char leftoverChar;
    private final OutputStream out;

    private void ensureOpen() throws IOException {
        if (!this.isOpen) {
            throw new IOException("Stream closed");
        }
    }

    public static StreamEncoder forOutputStreamWriter(OutputStream out2, Object lock, String charsetName) throws UnsupportedEncodingException {
        String csn = charsetName;
        if (charsetName == null) {
            csn = Charset.defaultCharset().name();
        }
        try {
            if (Charset.isSupported(csn)) {
                return new StreamEncoder(out2, lock, Charset.forName(csn));
            }
        } catch (IllegalCharsetNameException e) {
        }
        throw new UnsupportedEncodingException(csn);
    }

    public static StreamEncoder forOutputStreamWriter(OutputStream out2, Object lock, Charset cs2) {
        return new StreamEncoder(out2, lock, cs2);
    }

    public static StreamEncoder forOutputStreamWriter(OutputStream out2, Object lock, CharsetEncoder enc) {
        return new StreamEncoder(out2, lock, enc);
    }

    public static StreamEncoder forEncoder(WritableByteChannel ch2, CharsetEncoder enc, int minBufferCap) {
        return new StreamEncoder(ch2, enc, minBufferCap);
    }

    public String getEncoding() {
        if (isOpen()) {
            return encodingName();
        }
        return null;
    }

    public void flushBuffer() throws IOException {
        synchronized (this.lock) {
            if (isOpen()) {
                implFlushBuffer();
            } else {
                throw new IOException("Stream closed");
            }
        }
    }

    public void write(int c) throws IOException {
        write(new char[]{(char) c}, 0, 1);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (off >= 0 && off <= cbuf.length && len >= 0) {
                if (off + len <= cbuf.length && off + len >= 0) {
                    if (len != 0) {
                        implWrite(cbuf, off, len);
                        return;
                    }
                    return;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public void write(String str, int off, int len) throws IOException {
        if (len < 0) {
            throw new IndexOutOfBoundsException();
        }
        char[] cbuf = new char[len];
        str.getChars(off, off + len, cbuf, 0);
        write(cbuf, 0, len);
    }

    public void flush() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            implFlush();
        }
    }

    public void close() throws IOException {
        synchronized (this.lock) {
            if (this.isOpen) {
                implClose();
                this.isOpen = f140assertionsDisabled;
            }
        }
    }

    private boolean isOpen() {
        return this.isOpen;
    }

    private StreamEncoder(OutputStream out2, Object lock, Charset cs2) {
        this(out2, lock, cs2.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    private StreamEncoder(OutputStream out2, Object lock, CharsetEncoder enc) {
        super(lock);
        this.isOpen = true;
        this.haveLeftoverChar = f140assertionsDisabled;
        this.lcb = null;
        this.out = out2;
        this.ch = null;
        this.cs = enc.charset();
        this.encoder = enc;
        if (this.ch == null) {
            this.bb = ByteBuffer.allocate(8192);
        }
    }

    private StreamEncoder(WritableByteChannel ch2, CharsetEncoder enc, int mbc) {
        this.isOpen = true;
        this.haveLeftoverChar = f140assertionsDisabled;
        this.lcb = null;
        this.out = null;
        this.ch = ch2;
        this.cs = enc.charset();
        this.encoder = enc;
        this.bb = ByteBuffer.allocate(mbc < 0 ? 8192 : mbc);
    }

    private void writeBytes() throws IOException {
        int rem = 0;
        this.bb.flip();
        int lim = this.bb.limit();
        int pos = this.bb.position();
        if (!f140assertionsDisabled) {
            if (!(pos <= lim)) {
                throw new AssertionError();
            }
        }
        if (pos <= lim) {
            rem = lim - pos;
        }
        if (rem > 0) {
            if (this.ch == null) {
                this.out.write(this.bb.array(), this.bb.arrayOffset() + pos, rem);
            } else if (this.ch.write(this.bb) != rem && !f140assertionsDisabled) {
                throw new AssertionError((Object) Integer.valueOf(rem));
            }
        }
        this.bb.clear();
    }

    private void flushLeftoverChar(CharBuffer cb, boolean endOfInput) throws IOException {
        if (this.haveLeftoverChar || endOfInput) {
            if (this.lcb == null) {
                this.lcb = CharBuffer.allocate(2);
            } else {
                this.lcb.clear();
            }
            if (this.haveLeftoverChar) {
                this.lcb.put(this.leftoverChar);
            }
            if (cb != null && cb.hasRemaining()) {
                this.lcb.put(cb.get());
            }
            this.lcb.flip();
            while (true) {
                if (!this.lcb.hasRemaining() && !endOfInput) {
                    break;
                }
                CoderResult cr = this.encoder.encode(this.lcb, this.bb, endOfInput);
                if (cr.isUnderflow()) {
                    if (this.lcb.hasRemaining()) {
                        this.leftoverChar = this.lcb.get();
                        if (cb != null && cb.hasRemaining()) {
                            flushLeftoverChar(cb, endOfInput);
                            return;
                        }
                        return;
                    }
                } else if (cr.isOverflow()) {
                    if (!f140assertionsDisabled) {
                        if (!(this.bb.position() > 0)) {
                            throw new AssertionError();
                        }
                    }
                    writeBytes();
                } else {
                    cr.throwException();
                }
            }
            this.haveLeftoverChar = f140assertionsDisabled;
        }
    }

    /* access modifiers changed from: package-private */
    public void implWrite(char[] cbuf, int off, int len) throws IOException {
        boolean z = f140assertionsDisabled;
        CharBuffer cb = CharBuffer.wrap(cbuf, off, len);
        if (this.haveLeftoverChar) {
            flushLeftoverChar(cb, f140assertionsDisabled);
        }
        while (cb.hasRemaining()) {
            CoderResult cr = this.encoder.encode(cb, this.bb, f140assertionsDisabled);
            if (cr.isUnderflow()) {
                if (!f140assertionsDisabled) {
                    if (cb.remaining() <= 1) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError((Object) Integer.valueOf(cb.remaining()));
                    }
                }
                if (cb.remaining() == 1) {
                    this.haveLeftoverChar = true;
                    this.leftoverChar = cb.get();
                    return;
                }
                return;
            } else if (cr.isOverflow()) {
                if (!f140assertionsDisabled) {
                    if (!(this.bb.position() > 0)) {
                        throw new AssertionError();
                    }
                }
                writeBytes();
            } else {
                cr.throwException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void implFlushBuffer() throws IOException {
        if (this.bb.position() > 0) {
            writeBytes();
        }
    }

    /* access modifiers changed from: package-private */
    public void implFlush() throws IOException {
        implFlushBuffer();
        if (this.out != null) {
            this.out.flush();
        }
    }

    /* access modifiers changed from: package-private */
    public void implClose() throws IOException {
        boolean z;
        flushLeftoverChar((CharBuffer) null, true);
        while (true) {
            try {
                CoderResult cr = this.encoder.flush(this.bb);
                if (cr.isUnderflow()) {
                    if (this.bb.position() > 0) {
                        writeBytes();
                    }
                    if (this.ch != null) {
                        this.ch.close();
                        return;
                    } else {
                        this.out.close();
                        return;
                    }
                } else if (cr.isOverflow()) {
                    if (!f140assertionsDisabled) {
                        if (this.bb.position() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                    }
                    writeBytes();
                } else {
                    cr.throwException();
                }
            } catch (IOException x) {
                this.encoder.reset();
                throw x;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String encodingName() {
        if (this.cs instanceof HistoricallyNamedCharset) {
            return ((HistoricallyNamedCharset) this.cs).historicalName();
        }
        return this.cs.name();
    }
}
