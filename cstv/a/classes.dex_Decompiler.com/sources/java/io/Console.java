package java.io;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Formatter;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ClassModifier.cleanInsnsInAnonymousConstructor(ClassModifier.java:334)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:60)
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
public final class Console implements Flushable {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f0assertionsDisabled = false;
    private static Console cons;
    private static boolean echoOff;
    private Charset cs;
    private Formatter formatter;
    private Writer out;
    private PrintWriter pw;
    /* access modifiers changed from: private */
    public char[] rcb;
    /* access modifiers changed from: private */
    public Object readLock;
    private Reader reader;
    private Object writeLock;

    class LineReader extends Reader {
        private char[] cb;
        private Reader in;
        boolean leftoverLF;
        private int nChars;
        private int nextChar;
        final /* synthetic */ Console this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.io.Console.LineReader.<init>(java.io.Console, java.io.Reader):void, dex: classes.dex in method: java.io.Console.LineReader.<init>(java.io.Console, java.io.Reader):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.io.Console.LineReader.<init>(java.io.Console, java.io.Reader):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
            	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
            	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        LineReader(java.io.Console r1, java.io.Reader r2) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.io.Console.LineReader.<init>(java.io.Console, java.io.Reader):void, dex: classes.dex in method: java.io.Console.LineReader.<init>(java.io.Console, java.io.Reader):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.Console.LineReader.<init>(java.io.Console, java.io.Reader):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.Console.LineReader.close():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void close() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.Console.LineReader.close():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.Console.LineReader.close():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.Console.LineReader.read(char[], int, int):int, dex: classes.dex
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
        public int read(char[] r1, int r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.Console.LineReader.read(char[], int, int):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.Console.LineReader.read(char[], int, int):int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.Console.LineReader.ready():boolean, dex: classes.dex
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
        public boolean ready() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.Console.LineReader.ready():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.Console.LineReader.ready():boolean");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.io.Console.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.io.Console.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.Console.<clinit>():void");
    }

    private static native boolean echo(boolean z) throws IOException;

    private static native String encoding();

    private static native boolean istty();

    public PrintWriter writer() {
        return this.pw;
    }

    public Reader reader() {
        return this.reader;
    }

    public Console format(String fmt, Object... args) {
        this.formatter.format(fmt, args).flush();
        return this;
    }

    public Console printf(String format, Object... args) {
        return format(format, args);
    }

    public String readLine(String fmt, Object... args) {
        String line = null;
        synchronized (this.writeLock) {
            synchronized (this.readLock) {
                if (fmt.length() != 0) {
                    this.pw.format(fmt, args);
                }
                try {
                    char[] ca = readline(false);
                    if (ca != null) {
                        line = new String(ca);
                    }
                } catch (IOException x) {
                    throw new IOError(x);
                }
            }
        }
        return line;
    }

    public String readLine() {
        return readLine("", new Object[0]);
    }

    public char[] readPassword(String fmt, Object... args) {
        IOError ioe;
        IOError ioe2;
        char[] passwd = null;
        synchronized (this.writeLock) {
            synchronized (this.readLock) {
                try {
                    echoOff = echo(false);
                    ioe = null;
                    if (fmt.length() != 0) {
                        this.pw.format(fmt, args);
                    }
                    passwd = readline(true);
                    try {
                        echoOff = echo(true);
                    } catch (IOException x) {
                        ioe = new IOError(x);
                    }
                    if (ioe != null) {
                        throw ioe;
                    }
                } catch (IOException x2) {
                    IOError ioe3 = new IOError(x2);
                    try {
                        echoOff = echo(true);
                        ioe2 = ioe3;
                    } catch (IOException x3) {
                        if (ioe3 == null) {
                            ioe2 = new IOError(x3);
                        } else {
                            ioe3.addSuppressed(x3);
                            ioe2 = ioe3;
                        }
                    }
                    if (ioe2 != null) {
                        throw ioe2;
                    }
                } catch (IOException x4) {
                    throw new IOError(x4);
                } catch (Throwable th) {
                    try {
                        echoOff = echo(true);
                    } catch (IOException x5) {
                        ioe = new IOError(x5);
                    }
                    if (ioe != null) {
                        throw ioe;
                    }
                    throw th;
                }
                this.pw.println();
            }
        }
        return passwd;
    }

    public char[] readPassword() {
        return readPassword("", new Object[0]);
    }

    public void flush() {
        this.pw.flush();
    }

    private char[] readline(boolean zeroOut) throws IOException {
        int len = this.reader.read(this.rcb, 0, this.rcb.length);
        if (len < 0) {
            return null;
        }
        if (this.rcb[len - 1] == 13) {
            len--;
        } else if (this.rcb[len - 1] == 10 && len - 1 > 0 && this.rcb[len - 1] == 13) {
            len--;
        }
        char[] b = new char[len];
        if (len > 0) {
            System.arraycopy(this.rcb, 0, b, 0, len);
            if (zeroOut) {
                Arrays.fill(this.rcb, 0, len, ' ');
            }
        }
        return b;
    }

    /* access modifiers changed from: private */
    public char[] grow() {
        if (f0assertionsDisabled || Thread.holdsLock(this.readLock)) {
            char[] t = new char[(this.rcb.length * 2)];
            System.arraycopy(this.rcb, 0, t, 0, this.rcb.length);
            this.rcb = t;
            return this.rcb;
        }
        throw new AssertionError();
    }

    public static Console console() {
        if (!istty()) {
            return null;
        }
        if (cons == null) {
            cons = new Console();
        }
        return cons;
    }

    private Console() {
        this(new FileInputStream(FileDescriptor.in), new FileOutputStream(FileDescriptor.out));
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private Console(java.io.InputStream r6, java.io.OutputStream r7) {
        /*
            r5 = this;
            r5.<init>()
            java.lang.Object r2 = new java.lang.Object
            r2.<init>()
            r5.readLock = r2
            java.lang.Object r2 = new java.lang.Object
            r2.<init>()
            r5.writeLock = r2
            java.lang.String r0 = encoding()
            if (r0 == 0) goto L_0x001d
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r0)     // Catch:{ Exception -> 0x005a }
            r5.cs = r2     // Catch:{ Exception -> 0x005a }
        L_0x001d:
            java.nio.charset.Charset r2 = r5.cs
            if (r2 != 0) goto L_0x0027
            java.nio.charset.Charset r2 = java.nio.charset.Charset.defaultCharset()
            r5.cs = r2
        L_0x0027:
            java.lang.Object r2 = r5.writeLock
            java.nio.charset.Charset r3 = r5.cs
            sun.nio.cs.StreamEncoder r2 = sun.nio.cs.StreamEncoder.forOutputStreamWriter((java.io.OutputStream) r7, (java.lang.Object) r2, (java.nio.charset.Charset) r3)
            r5.out = r2
            java.io.Console$1 r2 = new java.io.Console$1
            java.io.Writer r3 = r5.out
            r4 = 1
            r2.<init>(r5, r3, r4)
            r5.pw = r2
            java.util.Formatter r2 = new java.util.Formatter
            java.io.Writer r3 = r5.out
            r2.<init>((java.lang.Appendable) r3)
            r5.formatter = r2
            java.io.Console$LineReader r2 = new java.io.Console$LineReader
            java.lang.Object r3 = r5.readLock
            java.nio.charset.Charset r4 = r5.cs
            sun.nio.cs.StreamDecoder r3 = sun.nio.cs.StreamDecoder.forInputStreamReader((java.io.InputStream) r6, (java.lang.Object) r3, (java.nio.charset.Charset) r4)
            r2.<init>(r5, r3)
            r5.reader = r2
            r2 = 1024(0x400, float:1.435E-42)
            char[] r2 = new char[r2]
            r5.rcb = r2
            return
        L_0x005a:
            r1 = move-exception
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.Console.<init>(java.io.InputStream, java.io.OutputStream):void");
    }

    public static synchronized Console getConsole() {
        synchronized (Console.class) {
            if (!istty()) {
                return null;
            }
            if (cons == null) {
                cons = new Console();
            }
            Console console = cons;
            return console;
        }
    }
}
