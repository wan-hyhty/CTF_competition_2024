package java.io;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;
import sun.security.action.GetPropertyAction;

public class PrintWriter extends Writer {
    private final boolean autoFlush;
    private Formatter formatter;
    private final String lineSeparator;
    protected Writer out;
    private PrintStream psOut;
    private boolean trouble;

    private static Charset toCharset(String csn) throws UnsupportedEncodingException {
        Objects.requireNonNull(csn, "charsetName");
        try {
            return Charset.forName(csn);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(csn);
        }
    }

    public PrintWriter(Writer out2) {
        this(out2, false);
    }

    public PrintWriter(Writer out2, boolean autoFlush2) {
        super(out2);
        this.trouble = false;
        this.psOut = null;
        this.out = out2;
        this.autoFlush = autoFlush2;
        this.lineSeparator = (String) AccessController.doPrivileged(new GetPropertyAction("line.separator"));
    }

    public PrintWriter(OutputStream out2) {
        this(out2, false);
    }

    public PrintWriter(OutputStream out2, boolean autoFlush2) {
        this((Writer) new BufferedWriter(new OutputStreamWriter(out2)), autoFlush2);
        if (out2 instanceof PrintStream) {
            this.psOut = (PrintStream) out2;
        }
    }

    public PrintWriter(String fileName) throws FileNotFoundException {
        this((Writer) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))), false);
    }

    private PrintWriter(Charset charset, File file) throws FileNotFoundException {
        this((Writer) new BufferedWriter(new OutputStreamWriter((OutputStream) new FileOutputStream(file), charset)), false);
    }

    public PrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), new File(fileName));
    }

    public PrintWriter(File file) throws FileNotFoundException {
        this((Writer) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))), false);
    }

    public PrintWriter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), file);
    }

    private void ensureOpen() throws IOException {
        if (this.out == null) {
            throw new IOException("Stream closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        r3.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flush() {
        /*
            r3 = this;
            java.lang.Object r2 = r3.lock     // Catch:{ IOException -> 0x0010 }
            monitor-enter(r2)     // Catch:{ IOException -> 0x0010 }
            r3.ensureOpen()     // Catch:{ all -> 0x000d }
            java.io.Writer r1 = r3.out     // Catch:{ all -> 0x000d }
            r1.flush()     // Catch:{ all -> 0x000d }
            monitor-exit(r2)     // Catch:{ IOException -> 0x0010 }
        L_0x000c:
            return
        L_0x000d:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ IOException -> 0x0010 }
            throw r1     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            r0 = move-exception
            r1 = 1
            r3.trouble = r1
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.flush():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0017, code lost:
        r3.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r3 = this;
            java.lang.Object r2 = r3.lock     // Catch:{ IOException -> 0x0016 }
            monitor-enter(r2)     // Catch:{ IOException -> 0x0016 }
            java.io.Writer r1 = r3.out     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r2)     // Catch:{ IOException -> 0x0016 }
            return
        L_0x0009:
            java.io.Writer r1 = r3.out     // Catch:{ all -> 0x0013 }
            r1.close()     // Catch:{ all -> 0x0013 }
            r1 = 0
            r3.out = r1     // Catch:{ all -> 0x0013 }
            monitor-exit(r2)     // Catch:{ IOException -> 0x0016 }
        L_0x0012:
            return
        L_0x0013:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ IOException -> 0x0016 }
            throw r1     // Catch:{ IOException -> 0x0016 }
        L_0x0016:
            r0 = move-exception
            r1 = 1
            r3.trouble = r1
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.close():void");
    }

    public boolean checkError() {
        if (this.out != null) {
            flush();
        }
        if (this.out instanceof PrintWriter) {
            return ((PrintWriter) this.out).checkError();
        }
        if (this.psOut != null) {
            return this.psOut.checkError();
        }
        return this.trouble;
    }

    /* access modifiers changed from: protected */
    public void setError() {
        this.trouble = true;
    }

    /* access modifiers changed from: protected */
    public void clearError() {
        this.trouble = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        r4.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(int r5) {
        /*
            r4 = this;
            java.lang.Object r3 = r4.lock     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            r4.ensureOpen()     // Catch:{ all -> 0x000d }
            java.io.Writer r2 = r4.out     // Catch:{ all -> 0x000d }
            r2.write((int) r5)     // Catch:{ all -> 0x000d }
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
        L_0x000c:
            return
        L_0x000d:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            throw r2     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
        L_0x0010:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x000c
        L_0x0019:
            r0 = move-exception
            r2 = 1
            r4.trouble = r2
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.write(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        r4.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(char[] r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.Object r3 = r4.lock     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            r4.ensureOpen()     // Catch:{ all -> 0x000d }
            java.io.Writer r2 = r4.out     // Catch:{ all -> 0x000d }
            r2.write((char[]) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x000d }
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
        L_0x000c:
            return
        L_0x000d:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            throw r2     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
        L_0x0010:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x000c
        L_0x0019:
            r0 = move-exception
            r2 = 1
            r4.trouble = r2
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.write(char[], int, int):void");
    }

    public void write(char[] buf) {
        write(buf, 0, buf.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        r4.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(java.lang.String r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.Object r3 = r4.lock     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            r4.ensureOpen()     // Catch:{ all -> 0x000d }
            java.io.Writer r2 = r4.out     // Catch:{ all -> 0x000d }
            r2.write((java.lang.String) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x000d }
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
        L_0x000c:
            return
        L_0x000d:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
            throw r2     // Catch:{ InterruptedIOException -> 0x0010, IOException -> 0x0019 }
        L_0x0010:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x000c
        L_0x0019:
            r0 = move-exception
            r2 = 1
            r4.trouble = r2
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.write(java.lang.String, int, int):void");
    }

    public void write(String s) {
        write(s, 0, s.length());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        r5.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void newLine() {
        /*
            r5 = this;
            java.lang.Object r3 = r5.lock     // Catch:{ InterruptedIOException -> 0x001b, IOException -> 0x0024 }
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x001b, IOException -> 0x0024 }
            r5.ensureOpen()     // Catch:{ all -> 0x0018 }
            java.io.Writer r2 = r5.out     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = r5.lineSeparator     // Catch:{ all -> 0x0018 }
            r2.write((java.lang.String) r4)     // Catch:{ all -> 0x0018 }
            boolean r2 = r5.autoFlush     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x0016
            java.io.Writer r2 = r5.out     // Catch:{ all -> 0x0018 }
            r2.flush()     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x001b, IOException -> 0x0024 }
        L_0x0017:
            return
        L_0x0018:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x001b, IOException -> 0x0024 }
            throw r2     // Catch:{ InterruptedIOException -> 0x001b, IOException -> 0x0024 }
        L_0x001b:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x0017
        L_0x0024:
            r0 = move-exception
            r2 = 1
            r5.trouble = r2
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.newLine():void");
    }

    public void print(boolean b) {
        write(b ? "true" : "false");
    }

    public void print(char c) {
        write((int) c);
    }

    public void print(int i) {
        write(String.valueOf(i));
    }

    public void print(long l) {
        write(String.valueOf(l));
    }

    public void print(float f) {
        write(String.valueOf(f));
    }

    public void print(double d) {
        write(String.valueOf(d));
    }

    public void print(char[] s) {
        write(s);
    }

    public void print(String s) {
        if (s == null) {
            s = "null";
        }
        write(s);
    }

    public void print(Object obj) {
        write(String.valueOf(obj));
    }

    public void println() {
        newLine();
    }

    public void println(boolean x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(char x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(int x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(long x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(float x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(double x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(char[] x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(String x) {
        synchronized (this.lock) {
            print(x);
            println();
        }
    }

    public void println(Object x) {
        String s = String.valueOf(x);
        synchronized (this.lock) {
            print(s);
            println();
        }
    }

    public PrintWriter printf(String format, Object... args) {
        return format(format, args);
    }

    public PrintWriter printf(Locale l, String format, Object... args) {
        return format(l, format, args);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        r5.trouble = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.PrintWriter format(java.lang.String r6, java.lang.Object... r7) {
        /*
            r5 = this;
            java.lang.Object r3 = r5.lock     // Catch:{ InterruptedIOException -> 0x0034, IOException -> 0x003d }
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x0034, IOException -> 0x003d }
            r5.ensureOpen()     // Catch:{ all -> 0x0031 }
            java.util.Formatter r2 = r5.formatter     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0016
            java.util.Formatter r2 = r5.formatter     // Catch:{ all -> 0x0031 }
            java.util.Locale r2 = r2.locale()     // Catch:{ all -> 0x0031 }
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0031 }
            if (r2 == r4) goto L_0x001d
        L_0x0016:
            java.util.Formatter r2 = new java.util.Formatter     // Catch:{ all -> 0x0031 }
            r2.<init>((java.lang.Appendable) r5)     // Catch:{ all -> 0x0031 }
            r5.formatter = r2     // Catch:{ all -> 0x0031 }
        L_0x001d:
            java.util.Formatter r2 = r5.formatter     // Catch:{ all -> 0x0031 }
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0031 }
            r2.format(r4, r6, r7)     // Catch:{ all -> 0x0031 }
            boolean r2 = r5.autoFlush     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x002f
            java.io.Writer r2 = r5.out     // Catch:{ all -> 0x0031 }
            r2.flush()     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0034, IOException -> 0x003d }
        L_0x0030:
            return r5
        L_0x0031:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0034, IOException -> 0x003d }
            throw r2     // Catch:{ InterruptedIOException -> 0x0034, IOException -> 0x003d }
        L_0x0034:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x0030
        L_0x003d:
            r0 = move-exception
            r2 = 1
            r5.trouble = r2
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.format(java.lang.String, java.lang.Object[]):java.io.PrintWriter");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r4.trouble = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.PrintWriter format(java.util.Locale r5, java.lang.String r6, java.lang.Object... r7) {
        /*
            r4 = this;
            java.lang.Object r3 = r4.lock     // Catch:{ InterruptedIOException -> 0x002c, IOException -> 0x0035 }
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x002c, IOException -> 0x0035 }
            r4.ensureOpen()     // Catch:{ all -> 0x0029 }
            java.util.Formatter r2 = r4.formatter     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0012
            java.util.Formatter r2 = r4.formatter     // Catch:{ all -> 0x0029 }
            java.util.Locale r2 = r2.locale()     // Catch:{ all -> 0x0029 }
            if (r2 == r5) goto L_0x0019
        L_0x0012:
            java.util.Formatter r2 = new java.util.Formatter     // Catch:{ all -> 0x0029 }
            r2.<init>((java.lang.Appendable) r4, (java.util.Locale) r5)     // Catch:{ all -> 0x0029 }
            r4.formatter = r2     // Catch:{ all -> 0x0029 }
        L_0x0019:
            java.util.Formatter r2 = r4.formatter     // Catch:{ all -> 0x0029 }
            r2.format(r5, r6, r7)     // Catch:{ all -> 0x0029 }
            boolean r2 = r4.autoFlush     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0027
            java.io.Writer r2 = r4.out     // Catch:{ all -> 0x0029 }
            r2.flush()     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x002c, IOException -> 0x0035 }
        L_0x0028:
            return r4
        L_0x0029:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x002c, IOException -> 0x0035 }
            throw r2     // Catch:{ InterruptedIOException -> 0x002c, IOException -> 0x0035 }
        L_0x002c:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x0028
        L_0x0035:
            r0 = move-exception
            r2 = 1
            r4.trouble = r2
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintWriter.format(java.util.Locale, java.lang.String, java.lang.Object[]):java.io.PrintWriter");
    }

    public PrintWriter append(CharSequence csq) {
        if (csq == null) {
            write("null");
        } else {
            write(csq.toString());
        }
        return this;
    }

    public PrintWriter append(CharSequence csq, int start, int end) {
        CharSequence cs;
        if (csq == null) {
            cs = "null";
        } else {
            cs = csq;
        }
        write(cs.subSequence(start, end).toString());
        return this;
    }

    public PrintWriter append(char c) {
        write((int) c);
        return this;
    }
}
