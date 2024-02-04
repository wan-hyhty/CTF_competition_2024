package java.io;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Formatter;
import java.util.Locale;

public class PrintStream extends FilterOutputStream implements Appendable, Closeable {
    private final boolean autoFlush;
    private OutputStreamWriter charOut;
    private Charset charset;
    private boolean closing;
    private Formatter formatter;
    private BufferedWriter textOut;
    private boolean trouble;

    private static <T> T requireNonNull(T obj, String message) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(message);
    }

    private static Charset toCharset(String csn) throws UnsupportedEncodingException {
        requireNonNull(csn, "charsetName");
        try {
            return Charset.forName(csn);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(csn);
        }
    }

    private PrintStream(boolean autoFlush2, OutputStream out) {
        super(out);
        this.trouble = false;
        this.closing = false;
        this.autoFlush = autoFlush2;
    }

    private PrintStream(boolean autoFlush2, OutputStream out, Charset charset2) {
        super(out);
        this.trouble = false;
        this.closing = false;
        this.autoFlush = autoFlush2;
    }

    private PrintStream(boolean autoFlush2, Charset charset2, OutputStream out) throws UnsupportedEncodingException {
        this(autoFlush2, out, charset2);
    }

    public PrintStream(OutputStream out) {
        this(out, false);
    }

    public PrintStream(OutputStream out, boolean autoFlush2) {
        this(autoFlush2, (OutputStream) requireNonNull(out, "Null output stream"));
    }

    public PrintStream(OutputStream out, boolean autoFlush2, String encoding) throws UnsupportedEncodingException {
        this(autoFlush2, (OutputStream) requireNonNull(out, "Null output stream"), toCharset(encoding));
    }

    public PrintStream(String fileName) throws FileNotFoundException {
        this(false, (OutputStream) new FileOutputStream(fileName));
    }

    public PrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(false, toCharset(csn), (OutputStream) new FileOutputStream(fileName));
    }

    public PrintStream(File file) throws FileNotFoundException {
        this(false, (OutputStream) new FileOutputStream(file));
    }

    public PrintStream(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(false, toCharset(csn), (OutputStream) new FileOutputStream(file));
    }

    private void ensureOpen() throws IOException {
        if (this.out == null) {
            throw new IOException("Stream closed");
        }
    }

    public void flush() {
        synchronized (this) {
            try {
                ensureOpen();
                this.out.flush();
            } catch (IOException e) {
                this.trouble = true;
            }
        }
        return;
    }

    private BufferedWriter getTextOut() {
        OutputStreamWriter outputStreamWriter;
        if (this.textOut == null) {
            if (this.charset != null) {
                outputStreamWriter = new OutputStreamWriter((OutputStream) this, this.charset);
            } else {
                outputStreamWriter = new OutputStreamWriter(this);
            }
            this.charOut = outputStreamWriter;
            this.textOut = new BufferedWriter(this.charOut);
        }
        return this.textOut;
    }

    public void close() {
        synchronized (this) {
            if (!this.closing) {
                this.closing = true;
                try {
                    if (this.textOut != null) {
                        this.textOut.close();
                    }
                    this.out.close();
                } catch (IOException e) {
                    this.trouble = true;
                }
                this.textOut = null;
                this.charOut = null;
                this.out = null;
            }
        }
        return;
    }

    public boolean checkError() {
        if (this.out != null) {
            flush();
        }
        if (this.out instanceof PrintStream) {
            return ((PrintStream) this.out).checkError();
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

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        r3.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x001b, IOException -> 0x0024 }
            r3.ensureOpen()     // Catch:{ all -> 0x0018 }
            java.io.OutputStream r2 = r3.out     // Catch:{ all -> 0x0018 }
            r2.write((int) r4)     // Catch:{ all -> 0x0018 }
            r2 = 10
            if (r4 != r2) goto L_0x0016
            boolean r2 = r3.autoFlush     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x0016
            java.io.OutputStream r2 = r3.out     // Catch:{ all -> 0x0018 }
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
            r3.trouble = r2
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintStream.write(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r3.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(byte[] r4, int r5, int r6) {
        /*
            r3 = this;
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x0017, IOException -> 0x0020 }
            r3.ensureOpen()     // Catch:{ all -> 0x0014 }
            java.io.OutputStream r2 = r3.out     // Catch:{ all -> 0x0014 }
            r2.write(r4, r5, r6)     // Catch:{ all -> 0x0014 }
            boolean r2 = r3.autoFlush     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x0012
            java.io.OutputStream r2 = r3.out     // Catch:{ all -> 0x0014 }
            r2.flush()     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0017, IOException -> 0x0020 }
        L_0x0013:
            return
        L_0x0014:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0017, IOException -> 0x0020 }
            throw r2     // Catch:{ InterruptedIOException -> 0x0017, IOException -> 0x0020 }
        L_0x0017:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x0013
        L_0x0020:
            r0 = move-exception
            r2 = 1
            r3.trouble = r2
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintStream.write(byte[], int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        r6.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void write(char[] r7) {
        /*
            r6 = this;
            monitor-enter(r6)     // Catch:{ InterruptedIOException -> 0x002e, IOException -> 0x0037 }
            r6.ensureOpen()     // Catch:{ all -> 0x002b }
            java.io.BufferedWriter r1 = r6.getTextOut()     // Catch:{ all -> 0x002b }
            r1.write((char[]) r7)     // Catch:{ all -> 0x002b }
            r1.flushBuffer()     // Catch:{ all -> 0x002b }
            java.io.OutputStreamWriter r4 = r6.charOut     // Catch:{ all -> 0x002b }
            r4.flushBuffer()     // Catch:{ all -> 0x002b }
            boolean r4 = r6.autoFlush     // Catch:{ all -> 0x002b }
            if (r4 == 0) goto L_0x0029
            r0 = 0
        L_0x0018:
            int r4 = r7.length     // Catch:{ all -> 0x002b }
            if (r0 >= r4) goto L_0x0029
            char r4 = r7[r0]     // Catch:{ all -> 0x002b }
            r5 = 10
            if (r4 != r5) goto L_0x0026
            java.io.OutputStream r4 = r6.out     // Catch:{ all -> 0x002b }
            r4.flush()     // Catch:{ all -> 0x002b }
        L_0x0026:
            int r0 = r0 + 1
            goto L_0x0018
        L_0x0029:
            monitor-exit(r6)     // Catch:{ InterruptedIOException -> 0x002e, IOException -> 0x0037 }
        L_0x002a:
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r6)     // Catch:{ InterruptedIOException -> 0x002e, IOException -> 0x0037 }
            throw r4     // Catch:{ InterruptedIOException -> 0x002e, IOException -> 0x0037 }
        L_0x002e:
            r3 = move-exception
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
            goto L_0x002a
        L_0x0037:
            r2 = move-exception
            r4 = 1
            r6.trouble = r4
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintStream.write(char[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r4.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void write(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
            r4.ensureOpen()     // Catch:{ all -> 0x0026 }
            java.io.BufferedWriter r0 = r4.getTextOut()     // Catch:{ all -> 0x0026 }
            r0.write((java.lang.String) r5)     // Catch:{ all -> 0x0026 }
            r0.flushBuffer()     // Catch:{ all -> 0x0026 }
            java.io.OutputStreamWriter r3 = r4.charOut     // Catch:{ all -> 0x0026 }
            r3.flushBuffer()     // Catch:{ all -> 0x0026 }
            boolean r3 = r4.autoFlush     // Catch:{ all -> 0x0026 }
            if (r3 == 0) goto L_0x0024
            r3 = 10
            int r3 = r5.indexOf((int) r3)     // Catch:{ all -> 0x0026 }
            if (r3 < 0) goto L_0x0024
            java.io.OutputStream r3 = r4.out     // Catch:{ all -> 0x0026 }
            r3.flush()     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r4)     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
        L_0x0025:
            return
        L_0x0026:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
            throw r3     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
        L_0x0029:
            r2 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            r3.interrupt()
            goto L_0x0025
        L_0x0032:
            r1 = move-exception
            r3 = 1
            r4.trouble = r3
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintStream.write(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r4.trouble = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void newLine() {
        /*
            r4 = this;
            monitor-enter(r4)     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
            r4.ensureOpen()     // Catch:{ all -> 0x001e }
            java.io.BufferedWriter r0 = r4.getTextOut()     // Catch:{ all -> 0x001e }
            r0.newLine()     // Catch:{ all -> 0x001e }
            r0.flushBuffer()     // Catch:{ all -> 0x001e }
            java.io.OutputStreamWriter r3 = r4.charOut     // Catch:{ all -> 0x001e }
            r3.flushBuffer()     // Catch:{ all -> 0x001e }
            boolean r3 = r4.autoFlush     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            java.io.OutputStream r3 = r4.out     // Catch:{ all -> 0x001e }
            r3.flush()     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r4)     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
        L_0x001d:
            return
        L_0x001e:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
            throw r3     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
        L_0x0021:
            r2 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            r3.interrupt()
            goto L_0x001d
        L_0x002a:
            r1 = move-exception
            r3 = 1
            r4.trouble = r3
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintStream.newLine():void");
    }

    public void print(boolean b) {
        write(b ? "true" : "false");
    }

    public void print(char c) {
        write(String.valueOf(c));
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
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(char x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(int x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(long x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(float x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(double x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(char[] x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(String x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }

    public void println(Object x) {
        String s = String.valueOf(x);
        synchronized (this) {
            print(s);
            newLine();
        }
    }

    public PrintStream printf(String format, Object... args) {
        return format(format, args);
    }

    public PrintStream printf(Locale l, String format, Object... args) {
        return format(l, format, args);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r4.trouble = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.PrintStream format(java.lang.String r5, java.lang.Object... r6) {
        /*
            r4 = this;
            monitor-enter(r4)     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
            r4.ensureOpen()     // Catch:{ all -> 0x0026 }
            java.util.Formatter r2 = r4.formatter     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0014
            java.util.Formatter r2 = r4.formatter     // Catch:{ all -> 0x0026 }
            java.util.Locale r2 = r2.locale()     // Catch:{ all -> 0x0026 }
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0026 }
            if (r2 == r3) goto L_0x001b
        L_0x0014:
            java.util.Formatter r2 = new java.util.Formatter     // Catch:{ all -> 0x0026 }
            r2.<init>((java.lang.Appendable) r4)     // Catch:{ all -> 0x0026 }
            r4.formatter = r2     // Catch:{ all -> 0x0026 }
        L_0x001b:
            java.util.Formatter r2 = r4.formatter     // Catch:{ all -> 0x0026 }
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0026 }
            r2.format(r3, r5, r6)     // Catch:{ all -> 0x0026 }
            monitor-exit(r4)     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
        L_0x0025:
            return r4
        L_0x0026:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
            throw r2     // Catch:{ InterruptedIOException -> 0x0029, IOException -> 0x0032 }
        L_0x0029:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x0025
        L_0x0032:
            r0 = move-exception
            r2 = 1
            r4.trouble = r2
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintStream.format(java.lang.String, java.lang.Object[]):java.io.PrintStream");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        r3.trouble = true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.PrintStream format(java.util.Locale r4, java.lang.String r5, java.lang.Object... r6) {
        /*
            r3 = this;
            monitor-enter(r3)     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
            r3.ensureOpen()     // Catch:{ all -> 0x001e }
            java.util.Formatter r2 = r3.formatter     // Catch:{ all -> 0x001e }
            if (r2 == 0) goto L_0x0010
            java.util.Formatter r2 = r3.formatter     // Catch:{ all -> 0x001e }
            java.util.Locale r2 = r2.locale()     // Catch:{ all -> 0x001e }
            if (r2 == r4) goto L_0x0017
        L_0x0010:
            java.util.Formatter r2 = new java.util.Formatter     // Catch:{ all -> 0x001e }
            r2.<init>((java.lang.Appendable) r3, (java.util.Locale) r4)     // Catch:{ all -> 0x001e }
            r3.formatter = r2     // Catch:{ all -> 0x001e }
        L_0x0017:
            java.util.Formatter r2 = r3.formatter     // Catch:{ all -> 0x001e }
            r2.format(r4, r5, r6)     // Catch:{ all -> 0x001e }
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
        L_0x001d:
            return r3
        L_0x001e:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
            throw r2     // Catch:{ InterruptedIOException -> 0x0021, IOException -> 0x002a }
        L_0x0021:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x001d
        L_0x002a:
            r0 = move-exception
            r2 = 1
            r3.trouble = r2
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PrintStream.format(java.util.Locale, java.lang.String, java.lang.Object[]):java.io.PrintStream");
    }

    public PrintStream append(CharSequence csq) {
        if (csq == null) {
            print("null");
        } else {
            print(csq.toString());
        }
        return this;
    }

    public PrintStream append(CharSequence csq, int start, int end) {
        CharSequence cs;
        if (csq == null) {
            cs = "null";
        } else {
            cs = csq;
        }
        write(cs.subSequence(start, end).toString());
        return this;
    }

    public PrintStream append(char c) {
        print(c);
        return this;
    }
}
