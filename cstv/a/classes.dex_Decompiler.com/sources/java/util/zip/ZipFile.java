package java.util.zip;

import dalvik.system.CloseGuard;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

public class ZipFile implements ZipConstants, Closeable {
    private static final int DEFLATED = 8;
    private static final int JZENTRY_COMMENT = 2;
    private static final int JZENTRY_EXTRA = 1;
    private static final int JZENTRY_NAME = 0;
    public static final int OPEN_DELETE = 4;
    public static final int OPEN_READ = 1;
    private static final int STORED = 0;
    private static final boolean usemmap = false;
    /* access modifiers changed from: private */
    public volatile boolean closeRequested;
    private final File fileToRemoveOnClose;
    private final CloseGuard guard;
    private Deque<Inflater> inflaterCache;
    /* access modifiers changed from: private */
    public long jzfile;
    private final boolean locsig;
    /* access modifiers changed from: private */
    public final String name;
    /* access modifiers changed from: private */
    public final Map<InputStream, Inflater> streams;
    /* access modifiers changed from: private */
    public final int total;
    private ZipCoder zc;

    private static native void close(long j);

    /* access modifiers changed from: private */
    public static native void freeEntry(long j, long j2);

    private static native byte[] getCommentBytes(long j);

    private static native long getEntry(long j, byte[] bArr, boolean z);

    private static native byte[] getEntryBytes(long j, int i);

    /* access modifiers changed from: private */
    public static native long getEntryCSize(long j);

    private static native long getEntryCrc(long j);

    private static native int getEntryFlag(long j);

    private static native int getEntryMethod(long j);

    /* access modifiers changed from: private */
    public static native long getEntrySize(long j);

    private static native long getEntryTime(long j);

    private static native int getFileDescriptor(long j);

    /* access modifiers changed from: private */
    public static native long getNextEntry(long j, int i);

    private static native int getTotal(long j);

    /* access modifiers changed from: private */
    public static native String getZipMessage(long j);

    private static native long open(String str, int i, long j, boolean z) throws IOException;

    /* access modifiers changed from: private */
    public static native int read(long j, long j2, long j3, byte[] bArr, int i, int i2);

    private static native boolean startsWithLOC(long j);

    public ZipFile(String name2) throws IOException {
        this(new File(name2), 1);
    }

    public ZipFile(File file, int mode) throws IOException {
        this(file, mode, StandardCharsets.UTF_8);
    }

    public ZipFile(File file) throws ZipException, IOException {
        this(file, 1);
    }

    public ZipFile(File file, int mode, Charset charset) throws IOException {
        File file2 = null;
        this.closeRequested = false;
        this.guard = CloseGuard.get();
        this.streams = new WeakHashMap();
        this.inflaterCache = new ArrayDeque();
        if ((mode & 1) == 0 || (mode & -6) != 0) {
            throw new IllegalArgumentException("Illegal mode: 0x" + Integer.toHexString(mode));
        }
        long length = file.length();
        if (length >= 22) {
            String name2 = file.getPath();
            this.fileToRemoveOnClose = (mode & 4) != 0 ? file : file2;
            if (charset == null) {
                throw new NullPointerException("charset is null");
            }
            this.zc = ZipCoder.get(charset);
            this.jzfile = open(name2, mode, file.lastModified(), usemmap);
            this.name = name2;
            this.total = getTotal(this.jzfile);
            this.locsig = startsWithLOC(this.jzfile);
            Enumeration<? extends ZipEntry> entries = entries();
            if (size() == 0 || !entries.hasMoreElements()) {
                close();
                throw new ZipException("No entries");
            } else {
                this.guard.open("close");
            }
        } else if (length != 0 || file.exists()) {
            throw new ZipException("File too short to be a zip file: " + file.length());
        } else {
            throw new FileNotFoundException("File doesn't exist: " + file);
        }
    }

    public ZipFile(String name2, Charset charset) throws IOException {
        this(new File(name2), 1, charset);
    }

    public ZipFile(File file, Charset charset) throws IOException {
        this(file, 1, charset);
    }

    public String getComment() {
        synchronized (this) {
            ensureOpen();
            byte[] bcomm = getCommentBytes(this.jzfile);
            if (bcomm == null) {
                return null;
            }
            String zipCoder = this.zc.toString(bcomm, bcomm.length);
            return zipCoder;
        }
    }

    public ZipEntry getEntry(String name2) {
        if (name2 == null) {
            throw new NullPointerException("name");
        }
        synchronized (this) {
            ensureOpen();
            long jzentry = getEntry(this.jzfile, this.zc.getBytes(name2), true);
            if (jzentry == 0) {
                return null;
            }
            ZipEntry ze = getZipEntry(name2, jzentry);
            freeEntry(this.jzfile, jzentry);
            return ze;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:871)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:128)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public java.io.InputStream getInputStream(java.util.zip.ZipEntry r13) throws java.io.IOException {
        /*
            r12 = this;
            if (r13 != 0) goto L_0x000b
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "entry"
            r8.<init>(r9)
            throw r8
        L_0x000b:
            r4 = 0
            r0 = 0
            monitor-enter(r12)
            r12.ensureOpen()     // Catch:{ all -> 0x00a1 }
            java.util.zip.ZipCoder r8 = r12.zc     // Catch:{ all -> 0x00a1 }
            boolean r8 = r8.isUTF8()     // Catch:{ all -> 0x00a1 }
            if (r8 != 0) goto L_0x0038
            int r8 = r13.flag     // Catch:{ all -> 0x00a1 }
            r8 = r8 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0038
            long r8 = r12.jzfile     // Catch:{ all -> 0x00a1 }
            java.util.zip.ZipCoder r10 = r12.zc     // Catch:{ all -> 0x00a1 }
            java.lang.String r11 = r13.name     // Catch:{ all -> 0x00a1 }
            byte[] r10 = r10.getBytesUTF8(r11)     // Catch:{ all -> 0x00a1 }
            r11 = 1
            long r4 = getEntry(r8, r10, r11)     // Catch:{ all -> 0x00a1 }
        L_0x002f:
            r8 = 0
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0048
            r8 = 0
            monitor-exit(r12)
            return r8
        L_0x0038:
            long r8 = r12.jzfile     // Catch:{ all -> 0x00a1 }
            java.util.zip.ZipCoder r10 = r12.zc     // Catch:{ all -> 0x00a1 }
            java.lang.String r11 = r13.name     // Catch:{ all -> 0x00a1 }
            byte[] r10 = r10.getBytes(r11)     // Catch:{ all -> 0x00a1 }
            r11 = 1
            long r4 = getEntry(r8, r10, r11)     // Catch:{ all -> 0x00a1 }
            goto L_0x002f
        L_0x0048:
            java.util.zip.ZipFile$ZipFileInputStream r1 = new java.util.zip.ZipFile$ZipFileInputStream     // Catch:{ all -> 0x00a1 }
            r1.<init>(r4)     // Catch:{ all -> 0x00a1 }
            int r8 = getEntryMethod(r4)     // Catch:{ all -> 0x005d }
            switch(r8) {
                case 0: goto L_0x0061;
                case 8: goto L_0x0070;
                default: goto L_0x0054;
            }     // Catch:{ all -> 0x005d }
        L_0x0054:
            java.util.zip.ZipException r8 = new java.util.zip.ZipException     // Catch:{ all -> 0x005d }
            java.lang.String r9 = "invalid compression method"
            r8.<init>(r9)     // Catch:{ all -> 0x005d }
            throw r8     // Catch:{ all -> 0x005d }
        L_0x005d:
            r8 = move-exception
            r0 = r1
        L_0x005f:
            monitor-exit(r12)
            throw r8
        L_0x0061:
            java.util.Map<java.io.InputStream, java.util.zip.Inflater> r9 = r12.streams     // Catch:{ all -> 0x005d }
            monitor-enter(r9)     // Catch:{ all -> 0x005d }
            java.util.Map<java.io.InputStream, java.util.zip.Inflater> r8 = r12.streams     // Catch:{ all -> 0x006d }
            r10 = 0
            r8.put(r1, r10)     // Catch:{ all -> 0x006d }
            monitor-exit(r9)     // Catch:{ all -> 0x005d }
            monitor-exit(r12)
            return r1
        L_0x006d:
            r8 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x005d }
            throw r8     // Catch:{ all -> 0x005d }
        L_0x0070:
            long r8 = getEntrySize(r4)     // Catch:{ all -> 0x005d }
            r10 = 2
            long r6 = r8 + r10
            r8 = 65536(0x10000, double:3.2379E-319)
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0081
            r6 = 8192(0x2000, double:4.0474E-320)
        L_0x0081:
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x0089
            r6 = 4096(0x1000, double:2.0237E-320)
        L_0x0089:
            java.util.zip.Inflater r2 = r12.getInflater()     // Catch:{ all -> 0x005d }
            java.util.zip.ZipFile$ZipFileInflaterInputStream r3 = new java.util.zip.ZipFile$ZipFileInflaterInputStream     // Catch:{ all -> 0x005d }
            int r8 = (int) r6     // Catch:{ all -> 0x005d }
            r3.<init>(r1, r2, r8)     // Catch:{ all -> 0x005d }
            java.util.Map<java.io.InputStream, java.util.zip.Inflater> r9 = r12.streams     // Catch:{ all -> 0x005d }
            monitor-enter(r9)     // Catch:{ all -> 0x005d }
            java.util.Map<java.io.InputStream, java.util.zip.Inflater> r8 = r12.streams     // Catch:{ all -> 0x009e }
            r8.put(r3, r2)     // Catch:{ all -> 0x009e }
            monitor-exit(r9)     // Catch:{ all -> 0x005d }
            monitor-exit(r12)
            return r3
        L_0x009e:
            r8 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x005d }
            throw r8     // Catch:{ all -> 0x005d }
        L_0x00a1:
            r8 = move-exception
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.zip.ZipFile.getInputStream(java.util.zip.ZipEntry):java.io.InputStream");
    }

    private class ZipFileInflaterInputStream extends InflaterInputStream {
        private volatile boolean closeRequested = false;
        private boolean eof = false;
        private final ZipFileInputStream zfin;

        ZipFileInflaterInputStream(ZipFileInputStream zfin2, Inflater inf, int size) {
            super(zfin2, inf, size);
            this.zfin = zfin2;
        }

        public void close() throws IOException {
            Inflater inf;
            if (!this.closeRequested) {
                this.closeRequested = true;
                super.close();
                synchronized (ZipFile.this.streams) {
                    inf = (Inflater) ZipFile.this.streams.remove(this);
                }
                if (inf != null) {
                    ZipFile.this.releaseInflater(inf);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void fill() throws IOException {
            if (this.eof) {
                throw new EOFException("Unexpected end of ZLIB input stream");
            }
            this.len = this.in.read(this.buf, 0, this.buf.length);
            if (this.len == -1) {
                this.buf[0] = 0;
                this.len = 1;
                this.eof = true;
            }
            this.inf.setInput(this.buf, 0, this.len);
        }

        public int available() throws IOException {
            if (this.closeRequested) {
                return 0;
            }
            long avail = this.zfin.size() - this.inf.getBytesWritten();
            if (avail > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) avail;
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            close();
        }
    }

    private Inflater getInflater() {
        Inflater inf;
        synchronized (this.inflaterCache) {
            do {
                inf = this.inflaterCache.poll();
                if (inf == null) {
                    return new Inflater(true);
                }
            } while (inf.ended());
            return inf;
        }
    }

    /* access modifiers changed from: private */
    public void releaseInflater(Inflater inf) {
        if (!inf.ended()) {
            inf.reset();
            synchronized (this.inflaterCache) {
                this.inflaterCache.add(inf);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Enumeration<? extends ZipEntry> entries() {
        ensureOpen();
        return new Enumeration<ZipEntry>() {
            private int i = 0;

            public boolean hasMoreElements() {
                boolean z;
                synchronized (ZipFile.this) {
                    ZipFile.this.ensureOpen();
                    z = this.i < ZipFile.this.total;
                }
                return z;
            }

            public ZipEntry nextElement() throws NoSuchElementException {
                ZipEntry ze;
                String message;
                synchronized (ZipFile.this) {
                    ZipFile.this.ensureOpen();
                    if (this.i >= ZipFile.this.total) {
                        throw new NoSuchElementException();
                    }
                    long r6 = ZipFile.this.jzfile;
                    int i2 = this.i;
                    this.i = i2 + 1;
                    long jzentry = ZipFile.getNextEntry(r6, i2);
                    if (jzentry == 0) {
                        if (ZipFile.this.closeRequested) {
                            message = "ZipFile concurrently closed";
                        } else {
                            message = ZipFile.getZipMessage(ZipFile.this.jzfile);
                        }
                        throw new ZipError("jzentry == 0,\n jzfile = " + ZipFile.this.jzfile + ",\n total = " + ZipFile.this.total + ",\n name = " + ZipFile.this.name + ",\n i = " + this.i + ",\n message = " + message);
                    }
                    ze = ZipFile.this.getZipEntry((String) null, jzentry);
                    ZipFile.freeEntry(ZipFile.this.jzfile, jzentry);
                }
                return ze;
            }
        };
    }

    /* access modifiers changed from: private */
    public ZipEntry getZipEntry(String name2, long jzentry) {
        ZipEntry e = new ZipEntry();
        e.flag = getEntryFlag(jzentry);
        if (name2 != null) {
            e.name = name2;
        } else {
            byte[] bname = getEntryBytes(jzentry, 0);
            if (this.zc.isUTF8() || (e.flag & 2048) == 0) {
                e.name = this.zc.toString(bname, bname.length);
            } else {
                e.name = this.zc.toStringUTF8(bname, bname.length);
            }
        }
        e.time = getEntryTime(jzentry);
        e.crc = getEntryCrc(jzentry);
        e.size = getEntrySize(jzentry);
        e.csize = getEntryCSize(jzentry);
        e.method = getEntryMethod(jzentry);
        e.extra = getEntryBytes(jzentry, 1);
        byte[] bcomm = getEntryBytes(jzentry, 2);
        if (bcomm == null) {
            e.comment = null;
        } else if (this.zc.isUTF8() || (e.flag & 2048) == 0) {
            e.comment = this.zc.toString(bcomm, bcomm.length);
        } else {
            e.comment = this.zc.toStringUTF8(bcomm, bcomm.length);
        }
        return e;
    }

    public int size() {
        ensureOpen();
        return this.total;
    }

    public void close() throws IOException {
        if (!this.closeRequested) {
            this.guard.close();
            this.closeRequested = true;
            synchronized (this) {
                synchronized (this.streams) {
                    if (!this.streams.isEmpty()) {
                        Map<InputStream, Inflater> copy = new HashMap<>(this.streams);
                        this.streams.clear();
                        for (Map.Entry<InputStream, Inflater> e : copy.entrySet()) {
                            e.getKey().close();
                            Inflater inf = e.getValue();
                            if (inf != null) {
                                inf.end();
                            }
                        }
                    }
                }
                synchronized (this.inflaterCache) {
                    while (true) {
                        Inflater inf2 = this.inflaterCache.poll();
                        if (inf2 != null) {
                            inf2.end();
                        }
                    }
                }
                if (this.jzfile != 0) {
                    long zf = this.jzfile;
                    this.jzfile = 0;
                    close(zf);
                }
                if (this.fileToRemoveOnClose != null) {
                    this.fileToRemoveOnClose.delete();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws IOException {
        if (this.guard != null) {
            this.guard.warnIfOpen();
        }
        close();
    }

    /* access modifiers changed from: private */
    public void ensureOpen() {
        if (this.closeRequested) {
            throw new IllegalStateException("zip file closed");
        } else if (this.jzfile == 0) {
            throw new IllegalStateException("The object is not initialized.");
        }
    }

    /* access modifiers changed from: private */
    public void ensureOpenOrZipException() throws IOException {
        if (this.closeRequested) {
            throw new ZipException("ZipFile closed");
        }
    }

    private class ZipFileInputStream extends InputStream {
        private volatile boolean closeRequested = false;
        protected long jzentry;
        private long pos = 0;
        protected long rem;
        protected long size;

        ZipFileInputStream(long jzentry2) {
            this.rem = ZipFile.getEntryCSize(jzentry2);
            this.size = ZipFile.getEntrySize(jzentry2);
            this.jzentry = jzentry2;
        }

        public int read(byte[] b, int off, int len) throws IOException {
            int len2;
            ZipFile.this.ensureOpenOrZipException();
            if (this.rem == 0) {
                return -1;
            }
            if (len <= 0) {
                return 0;
            }
            if (((long) len) > this.rem) {
                len = (int) this.rem;
            }
            synchronized (ZipFile.this) {
                len2 = ZipFile.read(ZipFile.this.jzfile, this.jzentry, this.pos, b, off, len);
            }
            if (len2 > 0) {
                this.pos += (long) len2;
                this.rem -= (long) len2;
            }
            if (this.rem == 0) {
                close();
            }
            return len2;
        }

        public int read() throws IOException {
            byte[] b = new byte[1];
            if (read(b, 0, 1) == 1) {
                return b[0] & Character.DIRECTIONALITY_UNDEFINED;
            }
            return -1;
        }

        public long skip(long n) {
            if (n > this.rem) {
                n = this.rem;
            }
            this.pos += n;
            this.rem -= n;
            if (this.rem == 0) {
                close();
            }
            return n;
        }

        public int available() {
            if (this.rem > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) this.rem;
        }

        public long size() {
            return this.size;
        }

        public void close() {
            if (!this.closeRequested) {
                this.closeRequested = true;
                this.rem = 0;
                synchronized (ZipFile.this) {
                    if (!(this.jzentry == 0 || ZipFile.this.jzfile == 0)) {
                        ZipFile.freeEntry(ZipFile.this.jzfile, this.jzentry);
                        this.jzentry = 0;
                    }
                }
                synchronized (ZipFile.this.streams) {
                    ZipFile.this.streams.remove(this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            close();
        }
    }

    public boolean startsWithLocHeader() {
        return this.locsig;
    }

    public int getFileDescriptor() {
        return getFileDescriptor(this.jzfile);
    }
}
