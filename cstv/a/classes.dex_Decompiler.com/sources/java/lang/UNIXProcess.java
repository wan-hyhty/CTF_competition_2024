package java.lang;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ProcessBuilder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

final class UNIXProcess extends Process {
    private static final Executor processReaperExecutor = null;
    private int exitcode;
    private boolean hasExited;
    /* access modifiers changed from: private */
    public final int pid;
    private InputStream stderr;
    private OutputStream stdin;
    private InputStream stdout;

    private static native void destroyProcess(int i);

    private native int forkAndExec(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4, int[] iArr, boolean z) throws IOException;

    private static native void initIDs();

    /* access modifiers changed from: private */
    public native int waitForProcessExit(int i);

    private static class ProcessReaperThreadFactory implements ThreadFactory {
        private static final ThreadGroup group = null;

        /* synthetic */ ProcessReaperThreadFactory(ProcessReaperThreadFactory processReaperThreadFactory) {
            this();
        }

        private ProcessReaperThreadFactory() {
        }

        private static ThreadGroup getRootThreadGroup() {
            return (ThreadGroup) AccessController.doPrivileged(new PrivilegedAction<ThreadGroup>() {
                public ThreadGroup run() {
                    ThreadGroup root = Thread.currentThread().getThreadGroup();
                    while (root.getParent() != null) {
                        root = root.getParent();
                    }
                    return root;
                }
            });
        }

        public Thread newThread(Runnable grimReaper) {
            Thread t = new Thread(group, grimReaper, "process reaper", 32768);
            t.setDaemon(true);
            t.setPriority(10);
            return t;
        }
    }

    UNIXProcess(byte[] prog, byte[] argBlock, int argc, byte[] envBlock, int envc, byte[] dir, final int[] fds, boolean redirectErrorStream) throws IOException {
        this.pid = forkAndExec(prog, argBlock, argc, envBlock, envc, dir, fds, redirectErrorStream);
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                public Void run() throws IOException {
                    UNIXProcess.this.initStreams(fds);
                    return null;
                }
            });
        } catch (PrivilegedActionException ex) {
            throw ((IOException) ex.getException());
        }
    }

    static FileDescriptor newFileDescriptor(int fd) {
        FileDescriptor fileDescriptor = new FileDescriptor();
        fileDescriptor.setInt$(fd);
        return fileDescriptor;
    }

    /* access modifiers changed from: package-private */
    public void initStreams(int[] fds) throws IOException {
        OutputStream processPipeOutputStream;
        InputStream processPipeInputStream;
        InputStream processPipeInputStream2;
        if (fds[0] == -1) {
            processPipeOutputStream = ProcessBuilder.NullOutputStream.INSTANCE;
        } else {
            processPipeOutputStream = new ProcessPipeOutputStream(fds[0]);
        }
        this.stdin = processPipeOutputStream;
        if (fds[1] == -1) {
            processPipeInputStream = ProcessBuilder.NullInputStream.INSTANCE;
        } else {
            processPipeInputStream = new ProcessPipeInputStream(fds[1]);
        }
        this.stdout = processPipeInputStream;
        if (fds[2] == -1) {
            processPipeInputStream2 = ProcessBuilder.NullInputStream.INSTANCE;
        } else {
            processPipeInputStream2 = new ProcessPipeInputStream(fds[2]);
        }
        this.stderr = processPipeInputStream2;
        processReaperExecutor.execute(new Runnable() {
            public void run() {
                UNIXProcess.this.processExited(UNIXProcess.this.waitForProcessExit(UNIXProcess.this.pid));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void processExited(int exitcode2) {
        synchronized (this) {
            this.exitcode = exitcode2;
            this.hasExited = true;
            notifyAll();
        }
        if (this.stdout instanceof ProcessPipeInputStream) {
            ((ProcessPipeInputStream) this.stdout).processExited();
        }
        if (this.stderr instanceof ProcessPipeInputStream) {
            ((ProcessPipeInputStream) this.stderr).processExited();
        }
        if (this.stdin instanceof ProcessPipeOutputStream) {
            ((ProcessPipeOutputStream) this.stdin).processExited();
        }
    }

    public OutputStream getOutputStream() {
        return this.stdin;
    }

    public InputStream getInputStream() {
        return this.stdout;
    }

    public InputStream getErrorStream() {
        return this.stderr;
    }

    public synchronized int waitFor() throws InterruptedException {
        while (!this.hasExited) {
            wait();
        }
        return this.exitcode;
    }

    public synchronized int exitValue() {
        if (!this.hasExited) {
            throw new IllegalThreadStateException("process hasn't exited");
        }
        return this.exitcode;
    }

    public void destroy() {
        synchronized (this) {
            if (!this.hasExited) {
                destroyProcess(this.pid);
            }
        }
        try {
            this.stdin.close();
        } catch (IOException e) {
        }
        try {
            this.stdout.close();
        } catch (IOException e2) {
        }
        try {
            this.stderr.close();
        } catch (IOException e3) {
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Process[pid=");
        sb.append(this.pid);
        if (this.hasExited) {
            sb.append(" ,hasExited=true, exitcode=");
            sb.append(this.exitcode);
            sb.append("]");
        } else {
            sb.append(", hasExited=false]");
        }
        return sb.toString();
    }

    static class ProcessPipeInputStream extends BufferedInputStream {
        ProcessPipeInputStream(int fd) {
            super(new FileInputStream(UNIXProcess.newFileDescriptor(fd), true));
        }

        private static byte[] drainInputStream(InputStream in) throws IOException {
            if (in == null) {
                return null;
            }
            int n = 0;
            byte[] a = null;
            while (true) {
                int j = in.available();
                if (j <= 0) {
                    break;
                }
                a = a == null ? new byte[j] : Arrays.copyOf(a, n + j);
                n += in.read(a, n, j);
            }
            return (a == null || n == a.length) ? a : Arrays.copyOf(a, n);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void processExited() {
            /*
                r4 = this;
                monitor-enter(r4)
                java.io.InputStream r1 = r4.in     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
                if (r1 == 0) goto L_0x0019
                byte[] r2 = drainInputStream(r1)     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
                r1.close()     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
                if (r2 != 0) goto L_0x001b
                java.lang.ProcessBuilder$NullInputStream r3 = java.lang.ProcessBuilder.NullInputStream.INSTANCE     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
            L_0x0010:
                r4.in = r3     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
                byte[] r3 = r4.buf     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
                if (r3 != 0) goto L_0x0019
                r3 = 0
                r4.in = r3     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
            L_0x0019:
                monitor-exit(r4)
                return
            L_0x001b:
                java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
                r3.<init>(r2)     // Catch:{ IOException -> 0x0021, all -> 0x0023 }
                goto L_0x0010
            L_0x0021:
                r0 = move-exception
                goto L_0x0019
            L_0x0023:
                r3 = move-exception
                monitor-exit(r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.UNIXProcess.ProcessPipeInputStream.processExited():void");
        }
    }

    static class ProcessPipeOutputStream extends BufferedOutputStream {
        ProcessPipeOutputStream(int fd) {
            super(new FileOutputStream(UNIXProcess.newFileDescriptor(fd), true));
        }

        /* access modifiers changed from: package-private */
        public synchronized void processExited() {
            OutputStream out = this.out;
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
                this.out = ProcessBuilder.NullOutputStream.INSTANCE;
            }
        }
    }
}
