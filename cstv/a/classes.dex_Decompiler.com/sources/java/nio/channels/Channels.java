package java.nio.channels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import sun.nio.ch.ChannelInputStream;
import sun.nio.cs.StreamDecoder;
import sun.nio.cs.StreamEncoder;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public final class Channels {

    private static class WritableByteChannelImpl extends AbstractInterruptibleChannel implements WritableByteChannel {
        private static final int TRANSFER_SIZE = 8192;
        private byte[] buf;
        private boolean open;
        OutputStream out;
        private Object writeLock;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.nio.channels.Channels.WritableByteChannelImpl.<init>(java.io.OutputStream):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        WritableByteChannelImpl(java.io.OutputStream r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.nio.channels.Channels.WritableByteChannelImpl.<init>(java.io.OutputStream):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.nio.channels.Channels.WritableByteChannelImpl.<init>(java.io.OutputStream):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.channels.Channels.WritableByteChannelImpl.implCloseChannel():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected void implCloseChannel() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.channels.Channels.WritableByteChannelImpl.implCloseChannel():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.nio.channels.Channels.WritableByteChannelImpl.implCloseChannel():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.nio.channels.Channels.WritableByteChannelImpl.write(java.nio.ByteBuffer):int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public int write(java.nio.ByteBuffer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.nio.channels.Channels.WritableByteChannelImpl.write(java.nio.ByteBuffer):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.nio.channels.Channels.WritableByteChannelImpl.write(java.nio.ByteBuffer):int");
        }
    }

    private Channels() {
    }

    private static void checkNotNull(Object o, String name) {
        if (o == null) {
            throw new NullPointerException("\"" + name + "\" is null!");
        }
    }

    private static void writeFullyImpl(WritableByteChannel ch, ByteBuffer bb) throws IOException {
        while (bb.remaining() > 0) {
            if (ch.write(bb) <= 0) {
                throw new RuntimeException("no bytes written");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void writeFully(WritableByteChannel ch, ByteBuffer bb) throws IOException {
        if (ch instanceof SelectableChannel) {
            SelectableChannel sc = (SelectableChannel) ch;
            synchronized (sc.blockingLock()) {
                if (!sc.isBlocking()) {
                    throw new IllegalBlockingModeException();
                }
                writeFullyImpl(ch, bb);
            }
            return;
        }
        writeFullyImpl(ch, bb);
    }

    public static InputStream newInputStream(ReadableByteChannel ch) {
        checkNotNull(ch, "ch");
        return new ChannelInputStream(ch);
    }

    public static OutputStream newOutputStream(final WritableByteChannel ch) {
        checkNotNull(ch, "ch");
        return new OutputStream() {
            private byte[] b1 = null;
            private ByteBuffer bb = null;
            private byte[] bs = null;

            public synchronized void write(int b) throws IOException {
                if (this.b1 == null) {
                    this.b1 = new byte[1];
                }
                this.b1[0] = (byte) b;
                write(this.b1);
            }

            public synchronized void write(byte[] bs2, int off, int len) throws IOException {
                ByteBuffer bb2;
                if (off >= 0) {
                    if (off <= bs2.length && len >= 0) {
                        if (off + len <= bs2.length && off + len >= 0) {
                            if (len != 0) {
                                if (this.bs == bs2) {
                                    bb2 = this.bb;
                                } else {
                                    bb2 = ByteBuffer.wrap(bs2);
                                }
                                bb2.limit(Math.min(off + len, bb2.capacity()));
                                bb2.position(off);
                                this.bb = bb2;
                                this.bs = bs2;
                                Channels.writeFully(ch, bb2);
                                return;
                            }
                            return;
                        }
                    }
                }
                throw new IndexOutOfBoundsException();
            }

            public void close() throws IOException {
                ch.close();
            }
        };
    }

    public static ReadableByteChannel newChannel(InputStream in) {
        checkNotNull(in, "in");
        if (!(in instanceof FileInputStream) || !FileInputStream.class.equals(in.getClass())) {
            return new ReadableByteChannelImpl(in);
        }
        return ((FileInputStream) in).getChannel();
    }

    private static class ReadableByteChannelImpl extends AbstractInterruptibleChannel implements ReadableByteChannel {
        private static final int TRANSFER_SIZE = 8192;
        private byte[] buf = new byte[0];
        InputStream in;
        private boolean open = true;
        private Object readLock = new Object();

        ReadableByteChannelImpl(InputStream in2) {
            this.in = in2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005a, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read(java.nio.ByteBuffer r11) throws java.io.IOException {
            /*
                r10 = this;
                r5 = 1
                r6 = 0
                int r2 = r11.remaining()
                r3 = 0
                r0 = 0
                java.lang.Object r7 = r10.readLock
                monitor-enter(r7)
            L_0x000b:
                if (r3 >= r2) goto L_0x0028
                int r4 = r2 - r3
                r8 = 8192(0x2000, float:1.14794E-41)
                int r1 = java.lang.Math.min((int) r4, (int) r8)     // Catch:{ all -> 0x004b }
                byte[] r4 = r10.buf     // Catch:{ all -> 0x004b }
                int r4 = r4.length     // Catch:{ all -> 0x004b }
                if (r4 >= r1) goto L_0x001e
                byte[] r4 = new byte[r1]     // Catch:{ all -> 0x004b }
                r10.buf = r4     // Catch:{ all -> 0x004b }
            L_0x001e:
                if (r3 <= 0) goto L_0x002f
                java.io.InputStream r4 = r10.in     // Catch:{ all -> 0x004b }
                int r4 = r4.available()     // Catch:{ all -> 0x004b }
                if (r4 > 0) goto L_0x002f
            L_0x0028:
                if (r0 >= 0) goto L_0x0059
                if (r3 != 0) goto L_0x0059
                r4 = -1
                monitor-exit(r7)
                return r4
            L_0x002f:
                r10.begin()     // Catch:{ all -> 0x0050 }
                java.io.InputStream r4 = r10.in     // Catch:{ all -> 0x0050 }
                byte[] r8 = r10.buf     // Catch:{ all -> 0x0050 }
                r9 = 0
                int r0 = r4.read(r8, r9, r1)     // Catch:{ all -> 0x0050 }
                if (r0 <= 0) goto L_0x004e
                r4 = r5
            L_0x003e:
                r10.end(r4)     // Catch:{ all -> 0x004b }
                if (r0 < 0) goto L_0x0028
                int r3 = r3 + r0
                byte[] r4 = r10.buf     // Catch:{ all -> 0x004b }
                r8 = 0
                r11.put(r4, r8, r0)     // Catch:{ all -> 0x004b }
                goto L_0x000b
            L_0x004b:
                r4 = move-exception
                monitor-exit(r7)
                throw r4
            L_0x004e:
                r4 = r6
                goto L_0x003e
            L_0x0050:
                r4 = move-exception
                if (r0 <= 0) goto L_0x0057
            L_0x0053:
                r10.end(r5)     // Catch:{ all -> 0x004b }
                throw r4     // Catch:{ all -> 0x004b }
            L_0x0057:
                r5 = r6
                goto L_0x0053
            L_0x0059:
                monitor-exit(r7)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: java.nio.channels.Channels.ReadableByteChannelImpl.read(java.nio.ByteBuffer):int");
        }

        /* access modifiers changed from: protected */
        public void implCloseChannel() throws IOException {
            this.in.close();
            this.open = false;
        }
    }

    public static WritableByteChannel newChannel(OutputStream out) {
        checkNotNull(out, "out");
        return new WritableByteChannelImpl(out);
    }

    public static Reader newReader(ReadableByteChannel ch, CharsetDecoder dec, int minBufferCap) {
        checkNotNull(ch, "ch");
        return StreamDecoder.forDecoder(ch, dec.reset(), minBufferCap);
    }

    public static Reader newReader(ReadableByteChannel ch, String csName) {
        checkNotNull(csName, "csName");
        return newReader(ch, Charset.forName(csName).newDecoder(), -1);
    }

    public static Writer newWriter(WritableByteChannel ch, CharsetEncoder enc, int minBufferCap) {
        checkNotNull(ch, "ch");
        return StreamEncoder.forEncoder(ch, enc.reset(), minBufferCap);
    }

    public static Writer newWriter(WritableByteChannel ch, String csName) {
        checkNotNull(csName, "csName");
        return newWriter(ch, Charset.forName(csName).newEncoder(), -1);
    }
}
