package java.io;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class BufferedReader extends Reader {
    private static final int INVALIDATED = -2;
    private static final int UNMARKED = -1;
    private static int defaultCharBufferSize;
    private static int defaultExpectedLineLength;
    private char[] cb;
    private Reader in;
    private int markedChar;
    private boolean markedSkipLF;
    private int nChars;
    private int nextChar;
    private int readAheadLimit;
    private boolean skipLF;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.BufferedReader.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.BufferedReader.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.<clinit>():void");
    }

    public BufferedReader(Reader in2, int sz) {
        super(in2);
        this.markedChar = -1;
        this.readAheadLimit = 0;
        this.skipLF = false;
        this.markedSkipLF = false;
        if (sz <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.in = in2;
        this.cb = new char[sz];
        this.nChars = 0;
        this.nextChar = 0;
    }

    public BufferedReader(Reader in2) {
        this(in2, defaultCharBufferSize);
    }

    private void ensureOpen() throws IOException {
        if (this.in == null) {
            throw new IOException("Stream closed");
        }
    }

    private void fill() throws IOException {
        int dst;
        int n;
        if (this.markedChar <= -1) {
            dst = 0;
        } else {
            int delta = this.nextChar - this.markedChar;
            if (delta >= this.readAheadLimit) {
                this.markedChar = -2;
                this.readAheadLimit = 0;
                dst = 0;
            } else {
                if (this.readAheadLimit <= this.cb.length) {
                    System.arraycopy(this.cb, this.markedChar, this.cb, 0, delta);
                    this.markedChar = 0;
                    dst = delta;
                } else {
                    int nlength = this.cb.length * 2;
                    if (nlength > this.readAheadLimit) {
                        nlength = this.readAheadLimit;
                    }
                    char[] ncb = new char[nlength];
                    System.arraycopy(this.cb, this.markedChar, ncb, 0, delta);
                    this.cb = ncb;
                    this.markedChar = 0;
                    dst = delta;
                }
                this.nChars = delta;
                this.nextChar = delta;
            }
        }
        do {
            n = this.in.read(this.cb, dst, this.cb.length - dst);
        } while (n == 0);
        if (n > 0) {
            this.nChars = dst + n;
            this.nextChar = dst;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = r4.cb;
        r2 = r4.nextChar;
        r4.nextChar = r2 + 1;
        r0 = r0[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r4 = this;
            java.lang.Object r1 = r4.lock
            monitor-enter(r1)
            r4.ensureOpen()     // Catch:{ all -> 0x0030 }
        L_0x0006:
            int r0 = r4.nextChar     // Catch:{ all -> 0x0030 }
            int r2 = r4.nChars     // Catch:{ all -> 0x0030 }
            if (r0 < r2) goto L_0x0018
            r4.fill()     // Catch:{ all -> 0x0030 }
            int r0 = r4.nextChar     // Catch:{ all -> 0x0030 }
            int r2 = r4.nChars     // Catch:{ all -> 0x0030 }
            if (r0 < r2) goto L_0x0018
            r0 = -1
            monitor-exit(r1)
            return r0
        L_0x0018:
            boolean r0 = r4.skipLF     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0033
            r0 = 0
            r4.skipLF = r0     // Catch:{ all -> 0x0030 }
            char[] r0 = r4.cb     // Catch:{ all -> 0x0030 }
            int r2 = r4.nextChar     // Catch:{ all -> 0x0030 }
            char r0 = r0[r2]     // Catch:{ all -> 0x0030 }
            r2 = 10
            if (r0 != r2) goto L_0x0033
            int r0 = r4.nextChar     // Catch:{ all -> 0x0030 }
            int r0 = r0 + 1
            r4.nextChar = r0     // Catch:{ all -> 0x0030 }
            goto L_0x0006
        L_0x0030:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0033:
            char[] r0 = r4.cb     // Catch:{ all -> 0x0030 }
            int r2 = r4.nextChar     // Catch:{ all -> 0x0030 }
            int r3 = r2 + 1
            r4.nextChar = r3     // Catch:{ all -> 0x0030 }
            char r0 = r0[r2]     // Catch:{ all -> 0x0030 }
            monitor-exit(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.read():int");
    }

    private int read1(char[] cbuf, int off, int len) throws IOException {
        if (this.nextChar >= this.nChars) {
            if (len >= this.cb.length && this.markedChar <= -1 && !this.skipLF) {
                return this.in.read(cbuf, off, len);
            }
            fill();
        }
        if (this.nextChar >= this.nChars) {
            return -1;
        }
        if (this.skipLF) {
            this.skipLF = false;
            if (this.cb[this.nextChar] == 10) {
                this.nextChar++;
                if (this.nextChar >= this.nChars) {
                    fill();
                }
                if (this.nextChar >= this.nChars) {
                    return -1;
                }
            }
        }
        int n = Math.min(len, this.nChars - this.nextChar);
        System.arraycopy(this.cb, this.nextChar, cbuf, off, n);
        this.nextChar += n;
        return n;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0042, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            r5 = 0
            java.lang.Object r3 = r6.lock
            monitor-enter(r3)
            r6.ensureOpen()     // Catch:{ all -> 0x0012 }
            if (r8 < 0) goto L_0x000c
            int r2 = r7.length     // Catch:{ all -> 0x0012 }
            if (r8 <= r2) goto L_0x0015
        L_0x000c:
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0012 }
            r2.<init>()     // Catch:{ all -> 0x0012 }
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        L_0x0015:
            if (r9 < 0) goto L_0x000c
            int r2 = r8 + r9
            int r4 = r7.length     // Catch:{ all -> 0x0012 }
            if (r2 > r4) goto L_0x000c
            int r2 = r8 + r9
            if (r2 < 0) goto L_0x000c
            if (r9 != 0) goto L_0x0024
            monitor-exit(r3)
            return r5
        L_0x0024:
            int r0 = r6.read1(r7, r8, r9)     // Catch:{ all -> 0x0012 }
            if (r0 > 0) goto L_0x002d
            monitor-exit(r3)
            return r0
        L_0x002c:
            int r0 = r0 + r1
        L_0x002d:
            if (r0 >= r9) goto L_0x0041
            java.io.Reader r2 = r6.in     // Catch:{ all -> 0x0012 }
            boolean r2 = r2.ready()     // Catch:{ all -> 0x0012 }
            if (r2 == 0) goto L_0x0041
            int r2 = r8 + r0
            int r4 = r9 - r0
            int r1 = r6.read1(r7, r2, r4)     // Catch:{ all -> 0x0012 }
            if (r1 > 0) goto L_0x002c
        L_0x0041:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.read(char[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005e, code lost:
        if (r5 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0060, code lost:
        r7 = new java.lang.String(r14.cb, r6, r2 - r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
        r14.nextChar++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006f, code lost:
        if (r0 != 13) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0071, code lost:
        r14.skipLF = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0075, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r5.append(r14.cb, r6, r2 - r6);
        r7 = r5.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readLine(boolean r15) throws java.io.IOException {
        /*
            r14 = this;
            r13 = 13
            r12 = 10
            r11 = 0
            r4 = 0
            java.lang.Object r9 = r14.lock
            monitor-enter(r9)
            r14.ensureOpen()     // Catch:{ all -> 0x0098 }
            if (r15 != 0) goto L_0x002e
            boolean r3 = r14.skipLF     // Catch:{ all -> 0x0098 }
            r5 = r4
        L_0x0011:
            int r8 = r14.nextChar     // Catch:{ all -> 0x009b }
            int r10 = r14.nChars     // Catch:{ all -> 0x009b }
            if (r8 < r10) goto L_0x001a
            r14.fill()     // Catch:{ all -> 0x009b }
        L_0x001a:
            int r8 = r14.nextChar     // Catch:{ all -> 0x009b }
            int r10 = r14.nChars     // Catch:{ all -> 0x009b }
            if (r8 < r10) goto L_0x0033
            if (r5 == 0) goto L_0x0031
            int r8 = r5.length()     // Catch:{ all -> 0x009b }
            if (r8 <= 0) goto L_0x0031
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x009b }
            monitor-exit(r9)
            return r8
        L_0x002e:
            r3 = 1
            r5 = r4
            goto L_0x0011
        L_0x0031:
            monitor-exit(r9)
            return r11
        L_0x0033:
            r1 = 0
            r0 = 0
            if (r3 == 0) goto L_0x0045
            char[] r8 = r14.cb     // Catch:{ all -> 0x009b }
            int r10 = r14.nextChar     // Catch:{ all -> 0x009b }
            char r8 = r8[r10]     // Catch:{ all -> 0x009b }
            if (r8 != r12) goto L_0x0045
            int r8 = r14.nextChar     // Catch:{ all -> 0x009b }
            int r8 = r8 + 1
            r14.nextChar = r8     // Catch:{ all -> 0x009b }
        L_0x0045:
            r8 = 0
            r14.skipLF = r8     // Catch:{ all -> 0x009b }
            r3 = 0
            int r2 = r14.nextChar     // Catch:{ all -> 0x009b }
        L_0x004b:
            int r8 = r14.nChars     // Catch:{ all -> 0x009b }
            if (r2 >= r8) goto L_0x0058
            char[] r8 = r14.cb     // Catch:{ all -> 0x009b }
            char r0 = r8[r2]     // Catch:{ all -> 0x009b }
            if (r0 == r12) goto L_0x0057
            if (r0 != r13) goto L_0x0076
        L_0x0057:
            r1 = 1
        L_0x0058:
            int r6 = r14.nextChar     // Catch:{ all -> 0x009b }
            r14.nextChar = r2     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0085
            if (r5 != 0) goto L_0x0079
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x009b }
            char[] r8 = r14.cb     // Catch:{ all -> 0x009b }
            int r10 = r2 - r6
            r7.<init>((char[]) r8, (int) r6, (int) r10)     // Catch:{ all -> 0x009b }
        L_0x0069:
            int r8 = r14.nextChar     // Catch:{ all -> 0x009b }
            int r8 = r8 + 1
            r14.nextChar = r8     // Catch:{ all -> 0x009b }
            if (r0 != r13) goto L_0x0074
            r8 = 1
            r14.skipLF = r8     // Catch:{ all -> 0x009b }
        L_0x0074:
            monitor-exit(r9)
            return r7
        L_0x0076:
            int r2 = r2 + 1
            goto L_0x004b
        L_0x0079:
            char[] r8 = r14.cb     // Catch:{ all -> 0x009b }
            int r10 = r2 - r6
            r5.append((char[]) r8, (int) r6, (int) r10)     // Catch:{ all -> 0x009b }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x009b }
            goto L_0x0069
        L_0x0085:
            if (r5 != 0) goto L_0x009e
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ all -> 0x009b }
            int r8 = defaultExpectedLineLength     // Catch:{ all -> 0x009b }
            r4.<init>((int) r8)     // Catch:{ all -> 0x009b }
        L_0x008e:
            char[] r8 = r14.cb     // Catch:{ all -> 0x0098 }
            int r10 = r2 - r6
            r4.append((char[]) r8, (int) r6, (int) r10)     // Catch:{ all -> 0x0098 }
            r5 = r4
            goto L_0x0011
        L_0x0098:
            r8 = move-exception
        L_0x0099:
            monitor-exit(r9)
            throw r8
        L_0x009b:
            r8 = move-exception
            r4 = r5
            goto L_0x0099
        L_0x009e:
            r4 = r5
            goto L_0x008e
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.readLine(boolean):java.lang.String");
    }

    public String readLine() throws IOException {
        return readLine(false);
    }

    public long skip(long n) throws IOException {
        long j;
        if (n < 0) {
            throw new IllegalArgumentException("skip value is negative");
        }
        synchronized (this.lock) {
            ensureOpen();
            long r = n;
            while (true) {
                if (r <= 0) {
                    break;
                }
                if (this.nextChar >= this.nChars) {
                    fill();
                }
                if (this.nextChar >= this.nChars) {
                    break;
                }
                if (this.skipLF) {
                    this.skipLF = false;
                    if (this.cb[this.nextChar] == 10) {
                        this.nextChar++;
                    }
                }
                long d = (long) (this.nChars - this.nextChar);
                if (r <= d) {
                    this.nextChar = (int) (((long) this.nextChar) + r);
                    r = 0;
                    break;
                }
                r -= d;
                this.nextChar = this.nChars;
            }
            j = n - r;
        }
        return j;
    }

    public boolean ready() throws IOException {
        boolean ready;
        synchronized (this.lock) {
            ensureOpen();
            if (this.skipLF) {
                if (this.nextChar >= this.nChars && this.in.ready()) {
                    fill();
                }
                if (this.nextChar < this.nChars) {
                    if (this.cb[this.nextChar] == 10) {
                        this.nextChar++;
                    }
                    this.skipLF = false;
                }
            }
            ready = this.nextChar >= this.nChars ? this.in.ready() : true;
        }
        return ready;
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int readAheadLimit2) throws IOException {
        if (readAheadLimit2 < 0) {
            throw new IllegalArgumentException("Read-ahead limit < 0");
        }
        synchronized (this.lock) {
            ensureOpen();
            this.readAheadLimit = readAheadLimit2;
            this.markedChar = this.nextChar;
            this.markedSkipLF = this.skipLF;
        }
    }

    public void reset() throws IOException {
        String str;
        synchronized (this.lock) {
            ensureOpen();
            if (this.markedChar < 0) {
                if (this.markedChar == -2) {
                    str = "Mark invalid";
                } else {
                    str = "Stream not marked";
                }
                throw new IOException(str);
            }
            this.nextChar = this.markedChar;
            this.skipLF = this.markedSkipLF;
        }
    }

    public void close() throws IOException {
        synchronized (this.lock) {
            if (this.in != null) {
                this.in.close();
                this.in = null;
                this.cb = null;
            }
        }
    }

    public Stream<String> lines() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<String>(this) {
            String nextLine;
            final /* synthetic */ BufferedReader this$0;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.BufferedReader.1.hasNext():boolean, dex: classes.dex
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
            public boolean hasNext() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.BufferedReader.1.hasNext():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.AnonymousClass1.hasNext():boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.io.BufferedReader.1.next():java.lang.Object, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.lang.Object next() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.io.BufferedReader.1.next():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.AnonymousClass1.next():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.BufferedReader.1.next():java.lang.String, dex: classes.dex
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
            public java.lang.String next() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.BufferedReader.1.next():java.lang.String, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.AnonymousClass1.next():java.lang.String");
            }
        }, 272), false);
    }
}
