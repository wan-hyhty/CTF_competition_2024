package java.util.logging;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class FileHandler extends StreamHandler {
    private static final int MAX_LOCKS = 100;
    private static HashMap<String, String> locks;
    private boolean append;
    private int count;
    private File[] files;
    private int limit;
    private String lockFileName;
    private FileOutputStream lockStream;
    private MeteredStream meter;
    private String pattern;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.logging.FileHandler.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.logging.FileHandler.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.FileHandler.<clinit>():void");
    }

    private class MeteredStream extends OutputStream {
        OutputStream out;
        final /* synthetic */ FileHandler this$0;
        int written;

        MeteredStream(FileHandler this$02, OutputStream out2, int written2) {
            this.this$0 = this$02;
            this.out = out2;
            this.written = written2;
        }

        public void write(int b) throws IOException {
            this.out.write(b);
            this.written++;
        }

        public void write(byte[] buff) throws IOException {
            this.out.write(buff);
            this.written += buff.length;
        }

        public void write(byte[] buff, int off, int len) throws IOException {
            this.out.write(buff, off, len);
            this.written += len;
        }

        public void flush() throws IOException {
            this.out.flush();
        }

        public void close() throws IOException {
            this.out.close();
        }
    }

    private void open(File fname, boolean append2) throws IOException {
        int len = 0;
        if (append2) {
            len = (int) fname.length();
        }
        this.meter = new MeteredStream(this, new BufferedOutputStream(new FileOutputStream(fname.toString(), append2)), len);
        setOutputStream(this.meter);
    }

    private void configure() {
        LogManager manager = LogManager.getLogManager();
        String cname = getClass().getName();
        this.pattern = manager.getStringProperty(cname + ".pattern", "%h/java%u.log");
        this.limit = manager.getIntProperty(cname + ".limit", 0);
        if (this.limit < 0) {
            this.limit = 0;
        }
        this.count = manager.getIntProperty(cname + ".count", 1);
        if (this.count <= 0) {
            this.count = 1;
        }
        this.append = manager.getBooleanProperty(cname + ".append", false);
        setLevel(manager.getLevelProperty(cname + ".level", Level.ALL));
        setFilter(manager.getFilterProperty(cname + ".filter", (Filter) null));
        setFormatter(manager.getFormatterProperty(cname + ".formatter", new XMLFormatter()));
        try {
            setEncoding(manager.getStringProperty(cname + ".encoding", (String) null));
        } catch (Exception e) {
            try {
                setEncoding((String) null);
            } catch (Exception e2) {
            }
        }
    }

    public FileHandler() throws IOException, SecurityException {
        checkPermission();
        configure();
        openFiles();
    }

    public FileHandler(String pattern2) throws IOException, SecurityException {
        if (pattern2.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern2;
        this.limit = 0;
        this.count = 1;
        openFiles();
    }

    public FileHandler(String pattern2, boolean append2) throws IOException, SecurityException {
        if (pattern2.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern2;
        this.limit = 0;
        this.count = 1;
        this.append = append2;
        openFiles();
    }

    public FileHandler(String pattern2, int limit2, int count2) throws IOException, SecurityException {
        if (limit2 < 0 || count2 < 1 || pattern2.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern2;
        this.limit = limit2;
        this.count = count2;
        openFiles();
    }

    public FileHandler(String pattern2, int limit2, int count2, boolean append2) throws IOException, SecurityException {
        if (limit2 < 0 || count2 < 1 || pattern2.length() < 1) {
            throw new IllegalArgumentException();
        }
        checkPermission();
        configure();
        this.pattern = pattern2;
        this.limit = limit2;
        this.count = count2;
        this.append = append2;
        openFiles();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        locks.put(r14.lockFileName, r14.lockFileName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ac, code lost:
        r14.files = new java.io.File[r14.count];
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        if (r4 >= r14.count) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b7, code lost:
        r14.files[r4] = generate(r14.pattern, r4, r7);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d2, code lost:
        if (r14.append == false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d4, code lost:
        open(r14.files[0], true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00db, code lost:
        r2 = r1.lastException;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00dd, code lost:
        if (r2 == null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e1, code lost:
        if ((r2 instanceof java.io.IOException) == false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e5, code lost:
        throw ((java.io.IOException) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e6, code lost:
        rotate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ec, code lost:
        if ((r2 instanceof java.lang.SecurityException) == false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f0, code lost:
        throw ((java.lang.SecurityException) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010a, code lost:
        throw new java.io.IOException("Exception: " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010b, code lost:
        setErrorManager(new java.util.logging.ErrorManager());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0113, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void openFiles() throws java.io.IOException {
        /*
            r14 = this;
            r13 = 1
            r9 = 0
            r12 = 0
            java.util.logging.LogManager r6 = java.util.logging.LogManager.getLogManager()
            r6.checkPermission()
            int r8 = r14.count
            if (r8 >= r13) goto L_0x002a
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "file count = "
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            int r10 = r14.count
            java.lang.StringBuilder r9 = r9.append((int) r10)
            java.lang.String r9 = r9.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x002a:
            int r8 = r14.limit
            if (r8 >= 0) goto L_0x0030
            r14.limit = r12
        L_0x0030:
            java.util.logging.FileHandler$InitializationErrorManager r1 = new java.util.logging.FileHandler$InitializationErrorManager
            r1.<init>(r9)
            r14.setErrorManager(r1)
            r7 = -1
        L_0x0039:
            int r7 = r7 + 1
            r8 = 100
            if (r7 <= r8) goto L_0x005b
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't get lock for "
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            java.lang.String r10 = r14.pattern
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            java.lang.String r9 = r9.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x005b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r14.pattern
            java.io.File r9 = r14.generate(r9, r12, r7)
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)
            java.lang.String r9 = ".lck"
            java.lang.StringBuilder r8 = r8.append((java.lang.String) r9)
            java.lang.String r8 = r8.toString()
            r14.lockFileName = r8
            java.util.HashMap<java.lang.String, java.lang.String> r9 = locks
            monitor-enter(r9)
            java.util.HashMap<java.lang.String, java.lang.String> r8 = locks     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r14.lockFileName     // Catch:{ all -> 0x00cd }
            java.lang.Object r8 = r8.get(r10)     // Catch:{ all -> 0x00cd }
            if (r8 == 0) goto L_0x008a
        L_0x0088:
            monitor-exit(r9)
            goto L_0x0039
        L_0x008a:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0114 }
            java.lang.String r10 = r14.lockFileName     // Catch:{ IOException -> 0x0117 }
            r8.<init>((java.lang.String) r10)     // Catch:{ IOException -> 0x011a }
            r14.lockStream = r8     // Catch:{ IOException -> 0x011d }
            java.io.FileOutputStream r8 = r14.lockStream     // Catch:{ IOException -> 0x0120 }
            java.nio.channels.FileChannel r3 = r8.getChannel()     // Catch:{ IOException -> 0x0123 }
            java.nio.channels.FileLock r8 = r3.tryLock()     // Catch:{ IOException -> 0x00c6 }
            if (r8 == 0) goto L_0x00c4
            r0 = 1
        L_0x00a0:
            if (r0 == 0) goto L_0x00c9
            java.util.HashMap<java.lang.String, java.lang.String> r8 = locks     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r14.lockFileName     // Catch:{ all -> 0x00cd }
            java.lang.String r11 = r14.lockFileName     // Catch:{ all -> 0x00cd }
            r8.put(r10, r11)     // Catch:{ all -> 0x00cd }
            monitor-exit(r9)
            int r8 = r14.count
            java.io.File[] r8 = new java.io.File[r8]
            r14.files = r8
            r4 = 0
        L_0x00b3:
            int r8 = r14.count
            if (r4 >= r8) goto L_0x00d0
            java.io.File[] r8 = r14.files
            java.lang.String r9 = r14.pattern
            java.io.File r9 = r14.generate(r9, r4, r7)
            r8[r4] = r9
            int r4 = r4 + 1
            goto L_0x00b3
        L_0x00c4:
            r0 = 0
            goto L_0x00a0
        L_0x00c6:
            r5 = move-exception
            r0 = 1
            goto L_0x00a0
        L_0x00c9:
            r3.close()     // Catch:{ all -> 0x00cd }
            goto L_0x0088
        L_0x00cd:
            r8 = move-exception
            monitor-exit(r9)
            throw r8
        L_0x00d0:
            boolean r8 = r14.append
            if (r8 == 0) goto L_0x00e6
            java.io.File[] r8 = r14.files
            r8 = r8[r12]
            r14.open(r8, r13)
        L_0x00db:
            java.lang.Exception r2 = r1.lastException
            if (r2 == 0) goto L_0x010b
            boolean r8 = r2 instanceof java.io.IOException
            if (r8 == 0) goto L_0x00ea
            java.io.IOException r2 = (java.io.IOException) r2
            throw r2
        L_0x00e6:
            r14.rotate()
            goto L_0x00db
        L_0x00ea:
            boolean r8 = r2 instanceof java.lang.SecurityException
            if (r8 == 0) goto L_0x00f1
            java.lang.SecurityException r2 = (java.lang.SecurityException) r2
            throw r2
        L_0x00f1:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Exception: "
            java.lang.StringBuilder r9 = r9.append((java.lang.String) r10)
            java.lang.StringBuilder r9 = r9.append((java.lang.Object) r2)
            java.lang.String r9 = r9.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x010b:
            java.util.logging.ErrorManager r8 = new java.util.logging.ErrorManager
            r8.<init>()
            r14.setErrorManager(r8)
            return
        L_0x0114:
            r5 = move-exception
            goto L_0x0088
        L_0x0117:
            r5 = move-exception
            goto L_0x0088
        L_0x011a:
            r5 = move-exception
            goto L_0x0088
        L_0x011d:
            r5 = move-exception
            goto L_0x0088
        L_0x0120:
            r5 = move-exception
            goto L_0x0088
        L_0x0123:
            r5 = move-exception
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.FileHandler.openFiles():void");
    }

    private File generate(String pattern2, int generation, int unique) throws IOException {
        File file = null;
        String word = "";
        int ix = 0;
        boolean sawg = false;
        boolean sawu = false;
        while (ix < pattern2.length()) {
            char ch = pattern2.charAt(ix);
            ix++;
            char ch2 = 0;
            if (ix < pattern2.length()) {
                ch2 = Character.toLowerCase(pattern2.charAt(ix));
            }
            if (ch == '/') {
                if (file == null) {
                    file = new File(word);
                } else {
                    file = new File(file, word);
                }
                word = "";
            } else {
                if (ch == '%') {
                    if (ch2 == 't') {
                        String tmpDir = System.getProperty("java.io.tmpdir");
                        if (tmpDir == null) {
                            tmpDir = System.getProperty("user.home");
                        }
                        file = new File(tmpDir);
                        ix++;
                        word = "";
                    } else if (ch2 == 'h') {
                        file = new File(System.getProperty("user.home"));
                        ix++;
                        word = "";
                    } else if (ch2 == 'g') {
                        word = word + generation;
                        sawg = true;
                        ix++;
                    } else if (ch2 == 'u') {
                        word = word + unique;
                        sawu = true;
                        ix++;
                    } else if (ch2 == '%') {
                        word = word + "%";
                        ix++;
                    }
                }
                word = word + ch;
            }
        }
        if (this.count > 1 && !sawg) {
            word = word + "." + generation;
        }
        if (unique > 0 && !sawu) {
            word = word + "." + unique;
        }
        if (word.length() <= 0) {
            return file;
        }
        if (file == null) {
            return new File(word);
        }
        return new File(file, word);
    }

    /* access modifiers changed from: private */
    public synchronized void rotate() {
        Level oldLevel = getLevel();
        setLevel(Level.OFF);
        super.close();
        for (int i = this.count - 2; i >= 0; i--) {
            File f1 = this.files[i];
            File f2 = this.files[i + 1];
            if (f1.exists()) {
                if (f2.exists()) {
                    f2.delete();
                }
                f1.renameTo(f2);
            }
        }
        try {
            open(this.files[0], false);
        } catch (IOException ix) {
            reportError((String) null, ix, 4);
        }
        setLevel(oldLevel);
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void publish(java.util.logging.LogRecord r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isLoggable(r3)     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            super.publish(r3)     // Catch:{ all -> 0x0025 }
            r2.flush()     // Catch:{ all -> 0x0025 }
            int r0 = r2.limit     // Catch:{ all -> 0x0025 }
            if (r0 <= 0) goto L_0x0023
            java.util.logging.FileHandler$MeteredStream r0 = r2.meter     // Catch:{ all -> 0x0025 }
            int r0 = r0.written     // Catch:{ all -> 0x0025 }
            int r1 = r2.limit     // Catch:{ all -> 0x0025 }
            if (r0 < r1) goto L_0x0023
            java.util.logging.FileHandler$1 r0 = new java.util.logging.FileHandler$1     // Catch:{ all -> 0x0025 }
            r0.<init>(r2)     // Catch:{ all -> 0x0025 }
            java.security.AccessController.doPrivileged(r0)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.logging.FileHandler.publish(java.util.logging.LogRecord):void");
    }

    public synchronized void close() throws SecurityException {
        super.close();
        if (this.lockFileName != null) {
            try {
                this.lockStream.close();
            } catch (Exception e) {
            }
            synchronized (locks) {
                locks.remove(this.lockFileName);
            }
            new File(this.lockFileName).delete();
            this.lockFileName = null;
            this.lockStream = null;
        }
    }

    private static class InitializationErrorManager extends ErrorManager {
        Exception lastException;

        /* synthetic */ InitializationErrorManager(InitializationErrorManager initializationErrorManager) {
            this();
        }

        private InitializationErrorManager() {
        }

        public void error(String msg, Exception ex, int code) {
            this.lastException = ex;
        }
    }
}
