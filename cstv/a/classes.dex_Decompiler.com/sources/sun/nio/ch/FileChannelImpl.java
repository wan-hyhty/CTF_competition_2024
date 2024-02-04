package sun.nio.ch;

import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.BlockGuard;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.DirectByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.FileLockInterruptionException;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.AccessController;
import java.util.List;
import libcore.io.Libcore;
import sun.misc.Cleaner;
import sun.misc.IoTrace;
import sun.security.action.GetPropertyAction;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class FileChannelImpl extends FileChannel {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f122assertionsDisabled = false;
    private static final long MAPPED_TRANSFER_SIZE = 8388608;
    private static final int MAP_PV = 2;
    private static final int MAP_RO = 0;
    private static final int MAP_RW = 1;
    private static final int TRANSFER_SIZE = 8192;
    private static final long allocationGranularity = 0;
    private static volatile boolean fileSupported;
    private static boolean isSharedFileLockTable;
    private static volatile boolean pipeSupported;
    private static volatile boolean propertyChecked;
    private static volatile boolean transferSupported;
    private final boolean append;
    public final FileDescriptor fd;
    private volatile FileLockTable fileLockTable;
    private final FileDispatcher nd;
    private final Object parent;
    private final String path;
    private final Object positionLock;
    private final boolean readable;
    private final NativeThreadSet threads;
    private final boolean writable;

    private static class SimpleFileLockTable extends FileLockTable {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f123assertionsDisabled = false;
        private final List<FileLock> lockList;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.checkList(long, long):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private void checkList(long r1, long r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.checkList(long, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.checkList(long, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.add(java.nio.channels.FileLock):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void add(java.nio.channels.FileLock r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.add(java.nio.channels.FileLock):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.add(java.nio.channels.FileLock):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.remove(java.nio.channels.FileLock):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void remove(java.nio.channels.FileLock r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.remove(java.nio.channels.FileLock):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.remove(java.nio.channels.FileLock):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.removeAll():java.util.List<java.nio.channels.FileLock>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public java.util.List<java.nio.channels.FileLock> removeAll() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.removeAll():java.util.List<java.nio.channels.FileLock>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.removeAll():java.util.List");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.replace(java.nio.channels.FileLock, java.nio.channels.FileLock):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void replace(java.nio.channels.FileLock r1, java.nio.channels.FileLock r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.replace(java.nio.channels.FileLock, java.nio.channels.FileLock):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.SimpleFileLockTable.replace(java.nio.channels.FileLock, java.nio.channels.FileLock):void");
        }
    }

    private static native long initIDs();

    private native long map0(int i, long j, long j2) throws IOException;

    private native long position0(FileDescriptor fileDescriptor, long j);

    private native long transferTo0(int i, long j, long j2, int i2);

    /* access modifiers changed from: private */
    public static native int unmap0(long j, long j2);

    private FileChannelImpl(FileDescriptor fd2, String path2, boolean readable2, boolean writable2, boolean append2, Object parent2) {
        this.threads = new NativeThreadSet(2);
        this.positionLock = new Object();
        this.fd = fd2;
        this.readable = readable2;
        this.writable = writable2;
        this.append = append2;
        this.parent = parent2;
        this.path = path2;
        this.nd = new FileDispatcherImpl(append2);
    }

    public static FileChannel open(FileDescriptor fd2, String path2, boolean readable2, boolean writable2, Object parent2) {
        return new FileChannelImpl(fd2, path2, readable2, writable2, f122assertionsDisabled, parent2);
    }

    public static FileChannel open(FileDescriptor fd2, String path2, boolean readable2, boolean writable2, boolean append2, Object parent2) {
        return new FileChannelImpl(fd2, path2, readable2, writable2, append2, parent2);
    }

    private void ensureOpen() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    /* access modifiers changed from: protected */
    public void implCloseChannel() throws IOException {
        if (this.fileLockTable != null) {
            for (FileLock fl : this.fileLockTable.removeAll()) {
                synchronized (fl) {
                    if (fl.isValid()) {
                        this.nd.release(this.fd, fl.position(), fl.size());
                        ((FileLockImpl) fl).invalidate();
                    }
                }
            }
        }
        this.threads.signalAndWait();
        if (this.parent != null) {
            ((Closeable) this.parent).close();
        } else {
            this.nd.close(this.fd);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0088, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(java.nio.ByteBuffer r11) throws java.io.IOException {
        /*
            r10 = this;
            r5 = 1
            r4 = 0
            r10.ensureOpen()
            boolean r3 = r10.readable
            if (r3 != 0) goto L_0x000f
            java.nio.channels.NonReadableChannelException r3 = new java.nio.channels.NonReadableChannelException
            r3.<init>()
            throw r3
        L_0x000f:
            java.lang.Object r7 = r10.positionLock
            monitor-enter(r7)
            r0 = 0
            r1 = -1
            java.lang.String r3 = r10.path     // Catch:{ all -> 0x0046 }
            java.lang.Object r2 = sun.misc.IoTrace.fileReadBegin(r3)     // Catch:{ all -> 0x0046 }
            r10.begin()     // Catch:{ all -> 0x0089 }
            sun.nio.ch.NativeThreadSet r3 = r10.threads     // Catch:{ all -> 0x0089 }
            int r1 = r3.add()     // Catch:{ all -> 0x0089 }
            boolean r3 = r10.isOpen()     // Catch:{ all -> 0x0089 }
            if (r3 != 0) goto L_0x004b
            sun.nio.ch.NativeThreadSet r3 = r10.threads     // Catch:{ all -> 0x0046 }
            r3.remove(r1)     // Catch:{ all -> 0x0046 }
            long r8 = (long) r4     // Catch:{ all -> 0x0046 }
            sun.misc.IoTrace.fileReadEnd(r2, r8)     // Catch:{ all -> 0x0046 }
            r3 = 0
            r10.end(r3)     // Catch:{ all -> 0x0046 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x0049
            boolean r3 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x0049
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            throw r3     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r3 = move-exception
            monitor-exit(r7)
            throw r3
        L_0x0049:
            monitor-exit(r7)
            return r4
        L_0x004b:
            java.io.FileDescriptor r3 = r10.fd     // Catch:{ all -> 0x0089 }
            r8 = -1
            sun.nio.ch.FileDispatcher r6 = r10.nd     // Catch:{ all -> 0x0089 }
            int r0 = sun.nio.ch.IOUtil.read(r3, r11, r8, r6)     // Catch:{ all -> 0x0089 }
            r3 = -3
            if (r0 != r3) goto L_0x005e
            boolean r3 = r10.isOpen()     // Catch:{ all -> 0x0089 }
            if (r3 != 0) goto L_0x004b
        L_0x005e:
            int r6 = sun.nio.ch.IOStatus.normalize((int) r0)     // Catch:{ all -> 0x0089 }
            sun.nio.ch.NativeThreadSet r3 = r10.threads     // Catch:{ all -> 0x0046 }
            r3.remove(r1)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x0083
            r3 = r0
        L_0x006a:
            long r8 = (long) r3     // Catch:{ all -> 0x0046 }
            sun.misc.IoTrace.fileReadEnd(r2, r8)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x0085
        L_0x0070:
            r10.end(r5)     // Catch:{ all -> 0x0046 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x0087
            boolean r3 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x0087
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            throw r3     // Catch:{ all -> 0x0046 }
        L_0x0083:
            r3 = r4
            goto L_0x006a
        L_0x0085:
            r5 = r4
            goto L_0x0070
        L_0x0087:
            monitor-exit(r7)
            return r6
        L_0x0089:
            r3 = move-exception
            sun.nio.ch.NativeThreadSet r6 = r10.threads     // Catch:{ all -> 0x0046 }
            r6.remove(r1)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x00ac
            r6 = r0
        L_0x0092:
            long r8 = (long) r6     // Catch:{ all -> 0x0046 }
            sun.misc.IoTrace.fileReadEnd(r2, r8)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x0099
            r4 = r5
        L_0x0099:
            r10.end(r4)     // Catch:{ all -> 0x0046 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x00ae
            boolean r4 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x00ae
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            throw r3     // Catch:{ all -> 0x0046 }
        L_0x00ac:
            r6 = r4
            goto L_0x0092
        L_0x00ae:
            throw r3     // Catch:{ all -> 0x0046 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.read(java.nio.ByteBuffer):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a2, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(java.nio.ByteBuffer[] r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            if (r11 < 0) goto L_0x0004
            if (r12 >= 0) goto L_0x000a
        L_0x0004:
            java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException
            r4.<init>()
            throw r4
        L_0x000a:
            int r4 = r10.length
            int r4 = r4 - r12
            if (r11 > r4) goto L_0x0004
            r9.ensureOpen()
            boolean r4 = r9.readable
            if (r4 != 0) goto L_0x001b
            java.nio.channels.NonReadableChannelException r4 = new java.nio.channels.NonReadableChannelException
            r4.<init>()
            throw r4
        L_0x001b:
            java.lang.Object r8 = r9.positionLock
            monitor-enter(r8)
            r0 = 0
            r2 = -1
            java.lang.String r4 = r9.path     // Catch:{ all -> 0x0054 }
            java.lang.Object r3 = sun.misc.IoTrace.fileReadBegin(r4)     // Catch:{ all -> 0x0054 }
            r9.begin()     // Catch:{ all -> 0x00a3 }
            sun.nio.ch.NativeThreadSet r4 = r9.threads     // Catch:{ all -> 0x00a3 }
            int r2 = r4.add()     // Catch:{ all -> 0x00a3 }
            boolean r4 = r9.isOpen()     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x005b
            sun.nio.ch.NativeThreadSet r4 = r9.threads     // Catch:{ all -> 0x0054 }
            r4.remove(r2)     // Catch:{ all -> 0x0054 }
            r4 = 0
            sun.misc.IoTrace.fileReadEnd(r3, r4)     // Catch:{ all -> 0x0054 }
            r4 = 0
            r9.end(r4)     // Catch:{ all -> 0x0054 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x0057
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x0057
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r4 = move-exception
            monitor-exit(r8)
            throw r4
        L_0x0057:
            r4 = 0
            monitor-exit(r8)
            return r4
        L_0x005b:
            java.io.FileDescriptor r4 = r9.fd     // Catch:{ all -> 0x00a3 }
            sun.nio.ch.FileDispatcher r5 = r9.nd     // Catch:{ all -> 0x00a3 }
            long r0 = sun.nio.ch.IOUtil.read(r4, r10, r11, r12, r5)     // Catch:{ all -> 0x00a3 }
            r4 = -3
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x006f
            boolean r4 = r9.isOpen()     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x005b
        L_0x006f:
            long r6 = sun.nio.ch.IOStatus.normalize((long) r0)     // Catch:{ all -> 0x00a3 }
            sun.nio.ch.NativeThreadSet r4 = r9.threads     // Catch:{ all -> 0x0054 }
            r4.remove(r2)     // Catch:{ all -> 0x0054 }
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x009c
            r4 = r0
        L_0x007f:
            sun.misc.IoTrace.fileReadEnd(r3, r4)     // Catch:{ all -> 0x0054 }
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x009f
            r4 = 1
        L_0x0089:
            r9.end(r4)     // Catch:{ all -> 0x0054 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x00a1
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x00a1
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x009c:
            r4 = 0
            goto L_0x007f
        L_0x009f:
            r4 = 0
            goto L_0x0089
        L_0x00a1:
            monitor-exit(r8)
            return r6
        L_0x00a3:
            r4 = move-exception
            sun.nio.ch.NativeThreadSet r5 = r9.threads     // Catch:{ all -> 0x0054 }
            r5.remove(r2)     // Catch:{ all -> 0x0054 }
            r6 = 0
            int r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x00cd
            r6 = r0
        L_0x00b0:
            sun.misc.IoTrace.fileReadEnd(r3, r6)     // Catch:{ all -> 0x0054 }
            r6 = 0
            int r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d0
            r5 = 1
        L_0x00ba:
            r9.end(r5)     // Catch:{ all -> 0x0054 }
            boolean r5 = f122assertionsDisabled     // Catch:{ all -> 0x0054 }
            if (r5 != 0) goto L_0x00d2
            boolean r5 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0054 }
            if (r5 != 0) goto L_0x00d2
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x00cd:
            r6 = 0
            goto L_0x00b0
        L_0x00d0:
            r5 = 0
            goto L_0x00ba
        L_0x00d2:
            throw r4     // Catch:{ all -> 0x0054 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.read(java.nio.ByteBuffer[], int, int):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0086, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int write(java.nio.ByteBuffer r11) throws java.io.IOException {
        /*
            r10 = this;
            r5 = 1
            r3 = 0
            r10.ensureOpen()
            boolean r4 = r10.writable
            if (r4 != 0) goto L_0x000f
            java.nio.channels.NonWritableChannelException r3 = new java.nio.channels.NonWritableChannelException
            r3.<init>()
            throw r3
        L_0x000f:
            java.lang.Object r6 = r10.positionLock
            monitor-enter(r6)
            r0 = 0
            r1 = -1
            java.lang.String r4 = r10.path     // Catch:{ all -> 0x0046 }
            java.lang.Object r2 = sun.misc.IoTrace.fileWriteBegin(r4)     // Catch:{ all -> 0x0046 }
            r10.begin()     // Catch:{ all -> 0x0087 }
            sun.nio.ch.NativeThreadSet r4 = r10.threads     // Catch:{ all -> 0x0087 }
            int r1 = r4.add()     // Catch:{ all -> 0x0087 }
            boolean r4 = r10.isOpen()     // Catch:{ all -> 0x0087 }
            if (r4 != 0) goto L_0x004b
            sun.nio.ch.NativeThreadSet r4 = r10.threads     // Catch:{ all -> 0x0046 }
            r4.remove(r1)     // Catch:{ all -> 0x0046 }
            r4 = 0
            r10.end(r4)     // Catch:{ all -> 0x0046 }
            long r4 = (long) r3     // Catch:{ all -> 0x0046 }
            sun.misc.IoTrace.fileWriteEnd(r2, r4)     // Catch:{ all -> 0x0046 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x0049
            boolean r4 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x0049
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            throw r3     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x0049:
            monitor-exit(r6)
            return r3
        L_0x004b:
            java.io.FileDescriptor r4 = r10.fd     // Catch:{ all -> 0x0087 }
            r8 = -1
            sun.nio.ch.FileDispatcher r7 = r10.nd     // Catch:{ all -> 0x0087 }
            int r0 = sun.nio.ch.IOUtil.write(r4, r11, r8, r7)     // Catch:{ all -> 0x0087 }
            r4 = -3
            if (r0 != r4) goto L_0x005e
            boolean r4 = r10.isOpen()     // Catch:{ all -> 0x0087 }
            if (r4 != 0) goto L_0x004b
        L_0x005e:
            int r4 = sun.nio.ch.IOStatus.normalize((int) r0)     // Catch:{ all -> 0x0087 }
            sun.nio.ch.NativeThreadSet r7 = r10.threads     // Catch:{ all -> 0x0046 }
            r7.remove(r1)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x0083
        L_0x0069:
            r10.end(r5)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x006f
            r3 = r0
        L_0x006f:
            long r8 = (long) r3     // Catch:{ all -> 0x0046 }
            sun.misc.IoTrace.fileWriteEnd(r2, r8)     // Catch:{ all -> 0x0046 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x0085
            boolean r3 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x0085
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            throw r3     // Catch:{ all -> 0x0046 }
        L_0x0083:
            r5 = r3
            goto L_0x0069
        L_0x0085:
            monitor-exit(r6)
            return r4
        L_0x0087:
            r4 = move-exception
            sun.nio.ch.NativeThreadSet r7 = r10.threads     // Catch:{ all -> 0x0046 }
            r7.remove(r1)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x00a9
        L_0x008f:
            r10.end(r5)     // Catch:{ all -> 0x0046 }
            if (r0 <= 0) goto L_0x0095
            r3 = r0
        L_0x0095:
            long r8 = (long) r3     // Catch:{ all -> 0x0046 }
            sun.misc.IoTrace.fileWriteEnd(r2, r8)     // Catch:{ all -> 0x0046 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x00ab
            boolean r3 = sun.nio.ch.IOStatus.check((int) r0)     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x00ab
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            throw r3     // Catch:{ all -> 0x0046 }
        L_0x00a9:
            r5 = r3
            goto L_0x008f
        L_0x00ab:
            throw r4     // Catch:{ all -> 0x0046 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.write(java.nio.ByteBuffer):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a2, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long write(java.nio.ByteBuffer[] r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            if (r11 < 0) goto L_0x0004
            if (r12 >= 0) goto L_0x000a
        L_0x0004:
            java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException
            r4.<init>()
            throw r4
        L_0x000a:
            int r4 = r10.length
            int r4 = r4 - r12
            if (r11 > r4) goto L_0x0004
            r9.ensureOpen()
            boolean r4 = r9.writable
            if (r4 != 0) goto L_0x001b
            java.nio.channels.NonWritableChannelException r4 = new java.nio.channels.NonWritableChannelException
            r4.<init>()
            throw r4
        L_0x001b:
            java.lang.Object r8 = r9.positionLock
            monitor-enter(r8)
            r0 = 0
            r2 = -1
            java.lang.String r4 = r9.path     // Catch:{ all -> 0x0054 }
            java.lang.Object r3 = sun.misc.IoTrace.fileWriteBegin(r4)     // Catch:{ all -> 0x0054 }
            r9.begin()     // Catch:{ all -> 0x00a3 }
            sun.nio.ch.NativeThreadSet r4 = r9.threads     // Catch:{ all -> 0x00a3 }
            int r2 = r4.add()     // Catch:{ all -> 0x00a3 }
            boolean r4 = r9.isOpen()     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x005b
            sun.nio.ch.NativeThreadSet r4 = r9.threads     // Catch:{ all -> 0x0054 }
            r4.remove(r2)     // Catch:{ all -> 0x0054 }
            r4 = 0
            sun.misc.IoTrace.fileWriteEnd(r3, r4)     // Catch:{ all -> 0x0054 }
            r4 = 0
            r9.end(r4)     // Catch:{ all -> 0x0054 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x0057
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x0057
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r4 = move-exception
            monitor-exit(r8)
            throw r4
        L_0x0057:
            r4 = 0
            monitor-exit(r8)
            return r4
        L_0x005b:
            java.io.FileDescriptor r4 = r9.fd     // Catch:{ all -> 0x00a3 }
            sun.nio.ch.FileDispatcher r5 = r9.nd     // Catch:{ all -> 0x00a3 }
            long r0 = sun.nio.ch.IOUtil.write(r4, r10, r11, r12, r5)     // Catch:{ all -> 0x00a3 }
            r4 = -3
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x006f
            boolean r4 = r9.isOpen()     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x005b
        L_0x006f:
            long r6 = sun.nio.ch.IOStatus.normalize((long) r0)     // Catch:{ all -> 0x00a3 }
            sun.nio.ch.NativeThreadSet r4 = r9.threads     // Catch:{ all -> 0x0054 }
            r4.remove(r2)     // Catch:{ all -> 0x0054 }
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x009c
            r4 = r0
        L_0x007f:
            sun.misc.IoTrace.fileWriteEnd(r3, r4)     // Catch:{ all -> 0x0054 }
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x009f
            r4 = 1
        L_0x0089:
            r9.end(r4)     // Catch:{ all -> 0x0054 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x00a1
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x00a1
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x009c:
            r4 = 0
            goto L_0x007f
        L_0x009f:
            r4 = 0
            goto L_0x0089
        L_0x00a1:
            monitor-exit(r8)
            return r6
        L_0x00a3:
            r4 = move-exception
            sun.nio.ch.NativeThreadSet r5 = r9.threads     // Catch:{ all -> 0x0054 }
            r5.remove(r2)     // Catch:{ all -> 0x0054 }
            r6 = 0
            int r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x00cd
            r6 = r0
        L_0x00b0:
            sun.misc.IoTrace.fileWriteEnd(r3, r6)     // Catch:{ all -> 0x0054 }
            r6 = 0
            int r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d0
            r5 = 1
        L_0x00ba:
            r9.end(r5)     // Catch:{ all -> 0x0054 }
            boolean r5 = f122assertionsDisabled     // Catch:{ all -> 0x0054 }
            if (r5 != 0) goto L_0x00d2
            boolean r5 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0054 }
            if (r5 != 0) goto L_0x00d2
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x0054 }
            r4.<init>()     // Catch:{ all -> 0x0054 }
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x00cd:
            r6 = 0
            goto L_0x00b0
        L_0x00d0:
            r5 = 0
            goto L_0x00ba
        L_0x00d2:
            throw r4     // Catch:{ all -> 0x0054 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.write(java.nio.ByteBuffer[], int, int):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        return r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007f A[SYNTHETIC, Splitter:B:40:0x007f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long position() throws java.io.IOException {
        /*
            r12 = this;
            r4 = 1
            r10 = -1
            r5 = 0
            r12.ensureOpen()
            java.lang.Object r6 = r12.positionLock
            monitor-enter(r6)
            r0 = -1
            r2 = -1
            r12.begin()     // Catch:{ all -> 0x008c }
            sun.nio.ch.NativeThreadSet r3 = r12.threads     // Catch:{ all -> 0x008c }
            int r2 = r3.add()     // Catch:{ all -> 0x008c }
            boolean r3 = r12.isOpen()     // Catch:{ all -> 0x008c }
            if (r3 != 0) goto L_0x003c
            sun.nio.ch.NativeThreadSet r3 = r12.threads     // Catch:{ all -> 0x0035 }
            r3.remove(r2)     // Catch:{ all -> 0x0035 }
            r3 = 0
            r12.end(r3)     // Catch:{ all -> 0x0035 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0038
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0038
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x0038:
            r4 = 0
            monitor-exit(r6)
            return r4
        L_0x003c:
            boolean r3 = r12.append     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x0047
            dalvik.system.BlockGuard$Policy r3 = dalvik.system.BlockGuard.getThreadPolicy()     // Catch:{ all -> 0x008c }
            r3.onWriteToDisk()     // Catch:{ all -> 0x008c }
        L_0x0047:
            boolean r3 = r12.append     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x007f
            sun.nio.ch.FileDispatcher r3 = r12.nd     // Catch:{ all -> 0x008c }
            java.io.FileDescriptor r7 = r12.fd     // Catch:{ all -> 0x008c }
            long r0 = r3.size(r7)     // Catch:{ all -> 0x008c }
        L_0x0053:
            r8 = -3
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x005f
            boolean r3 = r12.isOpen()     // Catch:{ all -> 0x008c }
            if (r3 != 0) goto L_0x0047
        L_0x005f:
            long r8 = sun.nio.ch.IOStatus.normalize((long) r0)     // Catch:{ all -> 0x008c }
            sun.nio.ch.NativeThreadSet r3 = r12.threads     // Catch:{ all -> 0x0035 }
            r3.remove(r2)     // Catch:{ all -> 0x0035 }
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x0088
        L_0x006c:
            r12.end(r4)     // Catch:{ all -> 0x0035 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x008a
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x008a
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x007f:
            java.io.FileDescriptor r3 = r12.fd     // Catch:{ all -> 0x008c }
            r8 = -1
            long r0 = r12.position0(r3, r8)     // Catch:{ all -> 0x008c }
            goto L_0x0053
        L_0x0088:
            r4 = r5
            goto L_0x006c
        L_0x008a:
            monitor-exit(r6)
            return r8
        L_0x008c:
            r3 = move-exception
            sun.nio.ch.NativeThreadSet r7 = r12.threads     // Catch:{ all -> 0x0035 }
            r7.remove(r2)     // Catch:{ all -> 0x0035 }
            int r7 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x00a9
        L_0x0096:
            r12.end(r4)     // Catch:{ all -> 0x0035 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x00ab
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x00ab
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x00a9:
            r4 = r5
            goto L_0x0096
        L_0x00ab:
            throw r3     // Catch:{ all -> 0x0035 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.position():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007f, code lost:
        return r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.channels.FileChannel position(long r14) throws java.io.IOException {
        /*
            r13 = this;
            r10 = -1
            r4 = 1
            r5 = 0
            r13.ensureOpen()
            r6 = 0
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0013
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            r3.<init>()
            throw r3
        L_0x0013:
            java.lang.Object r6 = r13.positionLock
            monitor-enter(r6)
            r0 = -1
            r2 = -1
            r13.begin()     // Catch:{ all -> 0x0080 }
            sun.nio.ch.NativeThreadSet r3 = r13.threads     // Catch:{ all -> 0x0080 }
            int r2 = r3.add()     // Catch:{ all -> 0x0080 }
            boolean r3 = r13.isOpen()     // Catch:{ all -> 0x0080 }
            if (r3 != 0) goto L_0x0047
            sun.nio.ch.NativeThreadSet r3 = r13.threads     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            r3 = 0
            r13.end(r3)     // Catch:{ all -> 0x0041 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0041 }
            if (r3 != 0) goto L_0x0044
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0041 }
            if (r3 != 0) goto L_0x0044
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0041 }
            r3.<init>()     // Catch:{ all -> 0x0041 }
            throw r3     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x0044:
            r3 = 0
            monitor-exit(r6)
            return r3
        L_0x0047:
            dalvik.system.BlockGuard$Policy r3 = dalvik.system.BlockGuard.getThreadPolicy()     // Catch:{ all -> 0x0080 }
            r3.onReadFromDisk()     // Catch:{ all -> 0x0080 }
        L_0x004e:
            java.io.FileDescriptor r3 = r13.fd     // Catch:{ all -> 0x0080 }
            long r0 = r13.position0(r3, r14)     // Catch:{ all -> 0x0080 }
            r8 = -3
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0060
            boolean r3 = r13.isOpen()     // Catch:{ all -> 0x0080 }
            if (r3 != 0) goto L_0x004e
        L_0x0060:
            sun.nio.ch.NativeThreadSet r3 = r13.threads     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x007c
        L_0x0069:
            r13.end(r4)     // Catch:{ all -> 0x0041 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0041 }
            if (r3 != 0) goto L_0x007e
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0041 }
            if (r3 != 0) goto L_0x007e
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0041 }
            r3.<init>()     // Catch:{ all -> 0x0041 }
            throw r3     // Catch:{ all -> 0x0041 }
        L_0x007c:
            r4 = r5
            goto L_0x0069
        L_0x007e:
            monitor-exit(r6)
            return r13
        L_0x0080:
            r3 = move-exception
            sun.nio.ch.NativeThreadSet r7 = r13.threads     // Catch:{ all -> 0x0041 }
            r7.remove(r2)     // Catch:{ all -> 0x0041 }
            int r7 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x009d
        L_0x008a:
            r13.end(r4)     // Catch:{ all -> 0x0041 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x009f
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x009f
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0041 }
            r3.<init>()     // Catch:{ all -> 0x0041 }
            throw r3     // Catch:{ all -> 0x0041 }
        L_0x009d:
            r4 = r5
            goto L_0x008a
        L_0x009f:
            throw r3     // Catch:{ all -> 0x0041 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.position(long):java.nio.channels.FileChannel");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0071, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long size() throws java.io.IOException {
        /*
            r12 = this;
            r4 = 1
            r10 = -1
            r5 = 0
            r12.ensureOpen()
            java.lang.Object r6 = r12.positionLock
            monitor-enter(r6)
            r0 = -1
            r2 = -1
            r12.begin()     // Catch:{ all -> 0x0072 }
            sun.nio.ch.NativeThreadSet r3 = r12.threads     // Catch:{ all -> 0x0072 }
            int r2 = r3.add()     // Catch:{ all -> 0x0072 }
            boolean r3 = r12.isOpen()     // Catch:{ all -> 0x0072 }
            if (r3 != 0) goto L_0x003a
            sun.nio.ch.NativeThreadSet r3 = r12.threads     // Catch:{ all -> 0x0035 }
            r3.remove(r2)     // Catch:{ all -> 0x0035 }
            r3 = 0
            r12.end(r3)     // Catch:{ all -> 0x0035 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0038
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0038
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x0038:
            monitor-exit(r6)
            return r10
        L_0x003a:
            sun.nio.ch.FileDispatcher r3 = r12.nd     // Catch:{ all -> 0x0072 }
            java.io.FileDescriptor r7 = r12.fd     // Catch:{ all -> 0x0072 }
            long r0 = r3.size(r7)     // Catch:{ all -> 0x0072 }
            r8 = -3
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x004e
            boolean r3 = r12.isOpen()     // Catch:{ all -> 0x0072 }
            if (r3 != 0) goto L_0x003a
        L_0x004e:
            long r8 = sun.nio.ch.IOStatus.normalize((long) r0)     // Catch:{ all -> 0x0072 }
            sun.nio.ch.NativeThreadSet r3 = r12.threads     // Catch:{ all -> 0x0035 }
            r3.remove(r2)     // Catch:{ all -> 0x0035 }
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x006e
        L_0x005b:
            r12.end(r4)     // Catch:{ all -> 0x0035 }
            boolean r3 = f122assertionsDisabled     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0070
            boolean r3 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x0070
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x006e:
            r4 = r5
            goto L_0x005b
        L_0x0070:
            monitor-exit(r6)
            return r8
        L_0x0072:
            r3 = move-exception
            sun.nio.ch.NativeThreadSet r7 = r12.threads     // Catch:{ all -> 0x0035 }
            r7.remove(r2)     // Catch:{ all -> 0x0035 }
            int r7 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x008f
        L_0x007c:
            r12.end(r4)     // Catch:{ all -> 0x0035 }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x0091
            boolean r4 = sun.nio.ch.IOStatus.check((long) r0)     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x0091
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x008f:
            r4 = r5
            goto L_0x007c
        L_0x0091:
            throw r3     // Catch:{ all -> 0x0035 }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.size():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0124, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0086, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00f2, code lost:
        return null;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:91:0x0107=Splitter:B:91:0x0107, B:104:0x0128=Splitter:B:104:0x0128} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.channels.FileChannel truncate(long r14) throws java.io.IOException {
        /*
            r13 = this;
            r12 = -3
            r11 = 0
            r10 = -1
            r5 = 1
            r6 = 0
            r13.ensureOpen()
            r8 = 0
            int r4 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0014
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>()
            throw r4
        L_0x0014:
            boolean r4 = r13.writable
            if (r4 != 0) goto L_0x001e
            java.nio.channels.NonWritableChannelException r4 = new java.nio.channels.NonWritableChannelException
            r4.<init>()
            throw r4
        L_0x001e:
            java.lang.Object r7 = r13.positionLock
            monitor-enter(r7)
            r2 = -1
            r0 = -1
            r3 = -1
            r13.begin()     // Catch:{ all -> 0x009a }
            sun.nio.ch.NativeThreadSet r4 = r13.threads     // Catch:{ all -> 0x009a }
            int r3 = r4.add()     // Catch:{ all -> 0x009a }
            boolean r4 = r13.isOpen()     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x0052
            sun.nio.ch.NativeThreadSet r4 = r13.threads     // Catch:{ all -> 0x004d }
            r4.remove(r3)     // Catch:{ all -> 0x004d }
            r4 = 0
            r13.end(r4)     // Catch:{ all -> 0x004d }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x0050
            boolean r4 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x0050
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ all -> 0x004d }
        L_0x004d:
            r4 = move-exception
            monitor-exit(r7)
            throw r4
        L_0x0050:
            monitor-exit(r7)
            return r11
        L_0x0052:
            java.io.FileDescriptor r4 = r13.fd     // Catch:{ all -> 0x009a }
            r8 = -1
            long r0 = r13.position0(r4, r8)     // Catch:{ all -> 0x009a }
            r8 = -3
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0066
            boolean r4 = r13.isOpen()     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x0052
        L_0x0066:
            boolean r4 = r13.isOpen()     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x0087
            sun.nio.ch.NativeThreadSet r4 = r13.threads     // Catch:{ all -> 0x004d }
            r4.remove(r3)     // Catch:{ all -> 0x004d }
            r4 = 0
            r13.end(r4)     // Catch:{ all -> 0x004d }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x0085
            boolean r4 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x0085
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ all -> 0x004d }
        L_0x0085:
            monitor-exit(r7)
            return r11
        L_0x0087:
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x00b7
            r8 = 0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x00b5
            r4 = r5
        L_0x0092:
            if (r4 != 0) goto L_0x00b7
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x009a }
            r4.<init>()     // Catch:{ all -> 0x009a }
            throw r4     // Catch:{ all -> 0x009a }
        L_0x009a:
            r4 = move-exception
            sun.nio.ch.NativeThreadSet r8 = r13.threads     // Catch:{ all -> 0x004d }
            r8.remove(r3)     // Catch:{ all -> 0x004d }
            if (r2 <= r10) goto L_0x0125
        L_0x00a2:
            r13.end(r5)     // Catch:{ all -> 0x004d }
            boolean r5 = f122assertionsDisabled     // Catch:{ all -> 0x004d }
            if (r5 != 0) goto L_0x0128
            boolean r5 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x004d }
            if (r5 != 0) goto L_0x0128
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ all -> 0x004d }
        L_0x00b5:
            r4 = r6
            goto L_0x0092
        L_0x00b7:
            long r8 = r13.size()     // Catch:{ all -> 0x009a }
            int r4 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f3
        L_0x00bf:
            sun.nio.ch.FileDispatcher r4 = r13.nd     // Catch:{ all -> 0x009a }
            java.io.FileDescriptor r8 = r13.fd     // Catch:{ all -> 0x009a }
            int r2 = r4.truncate(r8, r14)     // Catch:{ all -> 0x009a }
            if (r2 != r12) goto L_0x00cf
            boolean r4 = r13.isOpen()     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x00bf
        L_0x00cf:
            boolean r4 = r13.isOpen()     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x00f3
            sun.nio.ch.NativeThreadSet r4 = r13.threads     // Catch:{ all -> 0x004d }
            r4.remove(r3)     // Catch:{ all -> 0x004d }
            if (r2 <= r10) goto L_0x00ef
        L_0x00dc:
            r13.end(r5)     // Catch:{ all -> 0x004d }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x00f1
            boolean r4 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x00f1
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ all -> 0x004d }
        L_0x00ef:
            r5 = r6
            goto L_0x00dc
        L_0x00f1:
            monitor-exit(r7)
            return r11
        L_0x00f3:
            int r4 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x00f8
            r0 = r14
        L_0x00f8:
            java.io.FileDescriptor r4 = r13.fd     // Catch:{ all -> 0x009a }
            long r8 = r13.position0(r4, r0)     // Catch:{ all -> 0x009a }
            int r2 = (int) r8     // Catch:{ all -> 0x009a }
            if (r2 != r12) goto L_0x0107
            boolean r4 = r13.isOpen()     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x00f8
        L_0x0107:
            sun.nio.ch.NativeThreadSet r4 = r13.threads     // Catch:{ all -> 0x004d }
            r4.remove(r3)     // Catch:{ all -> 0x004d }
            if (r2 <= r10) goto L_0x0121
        L_0x010e:
            r13.end(r5)     // Catch:{ all -> 0x004d }
            boolean r4 = f122assertionsDisabled     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x0123
            boolean r4 = sun.nio.ch.IOStatus.check((int) r2)     // Catch:{ all -> 0x004d }
            if (r4 != 0) goto L_0x0123
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ all -> 0x004d }
        L_0x0121:
            r5 = r6
            goto L_0x010e
        L_0x0123:
            monitor-exit(r7)
            return r13
        L_0x0125:
            r5 = r6
            goto L_0x00a2
        L_0x0128:
            throw r4     // Catch:{ all -> 0x004d }
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.truncate(long):java.nio.channels.FileChannel");
    }

    /* JADX INFO: finally extract failed */
    public void force(boolean metaData) throws IOException {
        boolean z = true;
        ensureOpen();
        int rv = -1;
        int ti = -1;
        try {
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                this.threads.remove(ti);
                end(f122assertionsDisabled);
                if (!f122assertionsDisabled && !IOStatus.check(-1)) {
                    throw new AssertionError();
                }
                return;
            }
            do {
                rv = this.nd.force(this.fd, metaData);
                if (rv != -3 || !isOpen()) {
                    this.threads.remove(ti);
                }
                rv = this.nd.force(this.fd, metaData);
                break;
            } while (!isOpen());
            this.threads.remove(ti);
            if (rv <= -1) {
                z = false;
            }
            end(z);
            if (!f122assertionsDisabled && !IOStatus.check(rv)) {
                throw new AssertionError();
            }
        } catch (Throwable th) {
            this.threads.remove(ti);
            if (rv <= -1) {
                z = false;
            }
            end(z);
            if (f122assertionsDisabled || IOStatus.check(rv)) {
                throw th;
            }
            throw new AssertionError();
        }
    }

    private long transferToDirectly(long position, int icount, WritableByteChannel target) throws IOException {
        int thisFDVal;
        int targetFDVal;
        boolean z;
        if (!transferSupported) {
            return -4;
        }
        FileDescriptor targetFD = null;
        if (target instanceof FileChannelImpl) {
            if (!fileSupported) {
                return -6;
            }
            targetFD = ((FileChannelImpl) target).fd;
        } else if (target instanceof SelChImpl) {
            if ((target instanceof SinkChannelImpl) && !pipeSupported) {
                return -6;
            }
            targetFD = ((SelChImpl) target).getFD();
        }
        if (targetFD == null || (thisFDVal = IOUtil.fdVal(this.fd)) == (targetFDVal = IOUtil.fdVal(targetFD))) {
            return -4;
        }
        long n = -1;
        int ti = -1;
        try {
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                this.threads.remove(ti);
                end(f122assertionsDisabled);
                return -1;
            }
            BlockGuard.getThreadPolicy().onWriteToDisk();
            do {
                n = transferTo0(thisFDVal, position, (long) icount, targetFDVal);
                if (n != -3 || !isOpen()) {
                }
                n = transferTo0(thisFDVal, position, (long) icount, targetFDVal);
                break;
            } while (!isOpen());
            if (n == -6) {
                if (target instanceof SinkChannelImpl) {
                    pipeSupported = f122assertionsDisabled;
                }
                if (target instanceof FileChannelImpl) {
                    fileSupported = f122assertionsDisabled;
                }
                if (r0 <= 0) {
                    boolean z2 = f122assertionsDisabled;
                }
                return -6;
            } else if (n == -4) {
                transferSupported = f122assertionsDisabled;
                this.threads.remove(ti);
                if (n > -1) {
                    z = true;
                } else {
                    z = f122assertionsDisabled;
                }
                end(z);
                return -4;
            } else {
                long normalize = IOStatus.normalize(n);
                this.threads.remove(ti);
                end(n > -1 ? true : f122assertionsDisabled);
                return normalize;
            }
        } finally {
            this.threads.remove(ti);
            end(n > -1 ? true : f122assertionsDisabled);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        unmap(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long transferToTrustedChannel(long r18, long r20, java.nio.channels.WritableByteChannel r22) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r22
            boolean r11 = r0 instanceof sun.nio.ch.SelChImpl
            r0 = r22
            boolean r2 = r0 instanceof sun.nio.ch.FileChannelImpl
            if (r2 != 0) goto L_0x0010
            r2 = r11
        L_0x000b:
            if (r2 != 0) goto L_0x0012
            r2 = -4
            return r2
        L_0x0010:
            r2 = 1
            goto L_0x000b
        L_0x0012:
            r14 = r20
        L_0x0014:
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0062
            r2 = 8388608(0x800000, double:4.144523E-317)
            long r6 = java.lang.Math.min((long) r14, (long) r2)
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ ClosedByInterruptException -> 0x0045, IOException -> 0x007d }
            r2 = r17
            r4 = r18
            java.nio.MappedByteBuffer r8 = r2.map(r3, r4, r6)     // Catch:{ ClosedByInterruptException -> 0x0045, IOException -> 0x007d }
            r0 = r22
            int r12 = r0.write(r8)     // Catch:{ all -> 0x0040 }
            boolean r2 = f122assertionsDisabled     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x005b
            if (r12 < 0) goto L_0x0059
            r2 = 1
        L_0x0038:
            if (r2 != 0) goto L_0x005b
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0040 }
            r2.<init>()     // Catch:{ all -> 0x0040 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r2 = move-exception
            unmap(r8)     // Catch:{ ClosedByInterruptException -> 0x0045, IOException -> 0x007d }
            throw r2     // Catch:{ ClosedByInterruptException -> 0x0045, IOException -> 0x007d }
        L_0x0045:
            r9 = move-exception
            boolean r2 = f122assertionsDisabled
            if (r2 != 0) goto L_0x0085
            boolean r2 = r22.isOpen()
            if (r2 == 0) goto L_0x0083
            r2 = 0
        L_0x0051:
            if (r2 != 0) goto L_0x0085
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0059:
            r2 = 0
            goto L_0x0038
        L_0x005b:
            long r2 = (long) r12
            long r14 = r14 - r2
            if (r11 == 0) goto L_0x0065
            unmap(r8)     // Catch:{ ClosedByInterruptException -> 0x0045, IOException -> 0x007d }
        L_0x0062:
            long r2 = r20 - r14
            return r2
        L_0x0065:
            boolean r2 = f122assertionsDisabled     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0076
            if (r12 <= 0) goto L_0x0074
            r2 = 1
        L_0x006c:
            if (r2 != 0) goto L_0x0076
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0040 }
            r2.<init>()     // Catch:{ all -> 0x0040 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x0074:
            r2 = 0
            goto L_0x006c
        L_0x0076:
            long r2 = (long) r12
            long r18 = r18 + r2
            unmap(r8)     // Catch:{ ClosedByInterruptException -> 0x0045, IOException -> 0x007d }
            goto L_0x0014
        L_0x007d:
            r10 = move-exception
            int r2 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r2 != 0) goto L_0x0062
            throw r10
        L_0x0083:
            r2 = 1
            goto L_0x0051
        L_0x0085:
            r17.close()     // Catch:{ Throwable -> 0x0089 }
        L_0x0088:
            throw r9
        L_0x0089:
            r13 = move-exception
            r9.addSuppressed(r13)
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.transferToTrustedChannel(long, long, java.nio.channels.WritableByteChannel):long");
    }

    private long transferToArbitraryChannel(long position, int icount, WritableByteChannel target) throws IOException {
        ByteBuffer bb = Util.getTemporaryDirectBuffer(Math.min(icount, 8192));
        long tw = 0;
        long pos = position;
        try {
            Util.erase(bb);
            while (tw < ((long) icount)) {
                bb.limit(Math.min((int) (((long) icount) - tw), 8192));
                int nr = read(bb, pos);
                if (nr > 0) {
                    bb.flip();
                    int nw = target.write(bb);
                    tw += (long) nw;
                    if (nw != nr) {
                        break;
                    }
                    pos += (long) nw;
                    bb.clear();
                } else {
                    break;
                }
            }
            return tw;
        } catch (IOException x) {
            if (tw > 0) {
                return tw;
            }
            throw x;
        } finally {
            Util.releaseTemporaryDirectBuffer(bb);
        }
    }

    public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        ensureOpen();
        if (!target.isOpen()) {
            throw new ClosedChannelException();
        } else if (!this.readable) {
            throw new NonReadableChannelException();
        } else if ((target instanceof FileChannelImpl) && !((FileChannelImpl) target).writable) {
            throw new NonWritableChannelException();
        } else if (position < 0 || count < 0) {
            throw new IllegalArgumentException();
        } else {
            long sz = size();
            if (position > sz) {
                return 0;
            }
            int icount = (int) Math.min(count, 2147483647L);
            if (sz - position < ((long) icount)) {
                icount = (int) (sz - position);
            }
            long n = transferToDirectly(position, icount, target);
            if (n >= 0) {
                return n;
            }
            long n2 = transferToTrustedChannel(position, (long) icount, target);
            if (n2 >= 0) {
                return n2;
            }
            return transferToArbitraryChannel(position, icount, target);
        }
    }

    private long transferFromFileChannel(FileChannelImpl src, long position, long count) throws IOException {
        long nwritten;
        if (!src.readable) {
            throw new NonReadableChannelException();
        }
        synchronized (src.positionLock) {
            long pos = src.position();
            long max = Math.min(count, src.size() - pos);
            long remaining = max;
            long p = pos;
            while (remaining > 0) {
                MappedByteBuffer bb = src.map(FileChannel.MapMode.READ_ONLY, p, Math.min(remaining, (long) MAPPED_TRANSFER_SIZE));
                try {
                    long n = (long) write(bb, position);
                    if (!f122assertionsDisabled) {
                        if (!(n > 0 ? true : f122assertionsDisabled)) {
                            throw new AssertionError();
                        }
                    }
                    p += n;
                    position += n;
                    remaining -= n;
                    unmap(bb);
                } catch (IOException ioe) {
                    if (remaining == max) {
                        throw ioe;
                    }
                    unmap(bb);
                } catch (Throwable th) {
                    unmap(bb);
                    throw th;
                }
            }
            nwritten = max - remaining;
            src.position(pos + nwritten);
        }
        return nwritten;
    }

    private long transferFromArbitraryChannel(ReadableByteChannel src, long position, long count) throws IOException {
        ByteBuffer bb = Util.getTemporaryDirectBuffer((int) Math.min(count, 8192));
        long tw = 0;
        long pos = position;
        try {
            Util.erase(bb);
            while (tw < count) {
                bb.limit((int) Math.min(count - tw, 8192));
                int nr = src.read(bb);
                if (nr > 0) {
                    bb.flip();
                    int nw = write(bb, pos);
                    tw += (long) nw;
                    if (nw != nr) {
                        break;
                    }
                    pos += (long) nw;
                    bb.clear();
                } else {
                    break;
                }
            }
            return tw;
        } catch (IOException x) {
            if (tw > 0) {
                return tw;
            }
            throw x;
        } finally {
            Util.releaseTemporaryDirectBuffer(bb);
        }
    }

    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        ensureOpen();
        if (!src.isOpen()) {
            throw new ClosedChannelException();
        } else if (!this.writable) {
            throw new NonWritableChannelException();
        } else if (position < 0 || count < 0) {
            throw new IllegalArgumentException();
        } else if (position > size()) {
            return 0;
        } else {
            if (!(src instanceof FileChannelImpl)) {
                return transferFromArbitraryChannel(src, position, count);
            }
            return transferFromFileChannel((FileChannelImpl) src, position, count);
        }
    }

    public int read(ByteBuffer dst, long position) throws IOException {
        int readInternal;
        if (dst == null) {
            throw new NullPointerException();
        } else if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        } else if (!this.readable) {
            throw new NonReadableChannelException();
        } else {
            ensureOpen();
            if (!this.nd.needsPositionLock()) {
                return readInternal(dst, position);
            }
            synchronized (this.positionLock) {
                readInternal = readInternal(dst, position);
            }
            return readInternal;
        }
    }

    /* JADX INFO: finally extract failed */
    private int readInternal(ByteBuffer dst, long position) throws IOException {
        int i;
        int i2;
        boolean z = true;
        boolean z2 = f122assertionsDisabled;
        if (!f122assertionsDisabled) {
            if (!(this.nd.needsPositionLock() ? Thread.holdsLock(this.positionLock) : true)) {
                throw new AssertionError();
            }
        }
        int n = 0;
        int ti = -1;
        Object traceContext = IoTrace.fileReadBegin(this.path);
        try {
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                this.threads.remove(ti);
                IoTrace.fileReadEnd(traceContext, (long) 0);
                end(f122assertionsDisabled);
                if (f122assertionsDisabled || IOStatus.check(0)) {
                    return -1;
                }
                throw new AssertionError();
            }
            do {
                n = IOUtil.read(this.fd, dst, position, this.nd);
                if (n != -3 || !isOpen()) {
                    int normalize = IOStatus.normalize(n);
                }
                n = IOUtil.read(this.fd, dst, position, this.nd);
                break;
            } while (!isOpen());
            int normalize2 = IOStatus.normalize(n);
            this.threads.remove(ti);
            if (n > 0) {
                i2 = n;
            } else {
                i2 = 0;
            }
            IoTrace.fileReadEnd(traceContext, (long) i2);
            if (n > 0) {
                z2 = true;
            }
            end(z2);
            if (f122assertionsDisabled || IOStatus.check(n)) {
                return normalize2;
            }
            throw new AssertionError();
        } catch (Throwable th) {
            this.threads.remove(ti);
            if (n > 0) {
                i = n;
            } else {
                i = 0;
            }
            IoTrace.fileReadEnd(traceContext, (long) i);
            if (n <= 0) {
                z = false;
            }
            end(z);
            if (f122assertionsDisabled || IOStatus.check(n)) {
                throw th;
            }
            throw new AssertionError();
        }
    }

    public int write(ByteBuffer src, long position) throws IOException {
        int writeInternal;
        if (src == null) {
            throw new NullPointerException();
        } else if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        } else if (!this.writable) {
            throw new NonWritableChannelException();
        } else {
            ensureOpen();
            if (!this.nd.needsPositionLock()) {
                return writeInternal(src, position);
            }
            synchronized (this.positionLock) {
                writeInternal = writeInternal(src, position);
            }
            return writeInternal;
        }
    }

    /* JADX INFO: finally extract failed */
    private int writeInternal(ByteBuffer src, long position) throws IOException {
        boolean z = true;
        int i = 0;
        if (!f122assertionsDisabled) {
            if (!(this.nd.needsPositionLock() ? Thread.holdsLock(this.positionLock) : true)) {
                throw new AssertionError();
            }
        }
        int n = 0;
        int ti = -1;
        Object traceContext = IoTrace.fileWriteBegin(this.path);
        try {
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                this.threads.remove(ti);
                end(f122assertionsDisabled);
                IoTrace.fileWriteEnd(traceContext, (long) 0);
                if (f122assertionsDisabled || IOStatus.check(0)) {
                    return -1;
                }
                throw new AssertionError();
            }
            do {
                n = IOUtil.write(this.fd, src, position, this.nd);
                if (n != -3 || !isOpen()) {
                    int normalize = IOStatus.normalize(n);
                }
                n = IOUtil.write(this.fd, src, position, this.nd);
                break;
            } while (!isOpen());
            int normalize2 = IOStatus.normalize(n);
            this.threads.remove(ti);
            if (n <= 0) {
                z = false;
            }
            end(z);
            if (n > 0) {
                i = n;
            }
            IoTrace.fileWriteEnd(traceContext, (long) i);
            if (f122assertionsDisabled || IOStatus.check(n)) {
                return normalize2;
            }
            throw new AssertionError();
        } catch (Throwable th) {
            this.threads.remove(ti);
            if (n <= 0) {
                z = false;
            }
            end(z);
            if (n > 0) {
                i = n;
            }
            IoTrace.fileWriteEnd(traceContext, (long) i);
            if (f122assertionsDisabled || IOStatus.check(n)) {
                throw th;
            }
            throw new AssertionError();
        }
    }

    private static class Unmapper implements Runnable {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f124assertionsDisabled = false;
        static volatile int count;
        private static final NativeDispatcher nd = null;
        static volatile long totalCapacity;
        static volatile long totalSize;
        private volatile long address;
        private final int cap;
        private final FileDescriptor fd;
        private final long size;

        /* synthetic */ Unmapper(long address2, long size2, int cap2, FileDescriptor fd2, Unmapper unmapper) {
            this(address2, size2, cap2, fd2);
        }

        private Unmapper(long address2, long size2, int cap2, FileDescriptor fd2) {
            if (!f124assertionsDisabled) {
                if (!(address2 != 0 ? true : FileChannelImpl.f122assertionsDisabled)) {
                    throw new AssertionError();
                }
            }
            this.address = address2;
            this.size = size2;
            this.cap = cap2;
            this.fd = fd2;
            synchronized (Unmapper.class) {
                count++;
                totalSize += size2;
                totalCapacity += (long) cap2;
            }
        }

        public void run() {
            if (this.address != 0) {
                int unused = FileChannelImpl.unmap0(this.address, this.size);
                this.address = 0;
                if (this.fd.valid()) {
                    try {
                        nd.close(this.fd);
                    } catch (IOException e) {
                    }
                }
                synchronized (Unmapper.class) {
                    count--;
                    totalSize -= this.size;
                    totalCapacity -= (long) this.cap;
                }
            }
        }
    }

    private static void unmap(MappedByteBuffer bb) {
        Cleaner cl = ((DirectBuffer) bb).cleaner();
        if (cl != null) {
            cl.clean();
        }
    }

    public MappedByteBuffer map(FileChannel.MapMode mode, long position, long size) throws IOException {
        long mapPosition;
        long mapSize;
        ensureOpen();
        if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        } else if (size < 0) {
            throw new IllegalArgumentException("Negative size");
        } else if (position + size < 0) {
            throw new IllegalArgumentException("Position + size overflow");
        } else if (size > 2147483647L) {
            throw new IllegalArgumentException("Size exceeds Integer.MAX_VALUE");
        } else {
            int imode = -1;
            if (mode == FileChannel.MapMode.READ_ONLY) {
                imode = 0;
            } else if (mode == FileChannel.MapMode.READ_WRITE) {
                imode = 1;
            } else if (mode == FileChannel.MapMode.PRIVATE) {
                imode = 2;
            }
            if (!f122assertionsDisabled) {
                if (!(imode >= 0 ? true : f122assertionsDisabled)) {
                    throw new AssertionError();
                }
            }
            if (mode != FileChannel.MapMode.READ_ONLY && !this.writable) {
                throw new NonWritableChannelException();
            } else if (!this.readable) {
                throw new NonReadableChannelException();
            } else {
                long addr = -1;
                int ti = -1;
                try {
                    begin();
                    ti = this.threads.add();
                    if (!isOpen()) {
                        this.threads.remove(ti);
                        end(IOStatus.checkAll(-1));
                        return null;
                    }
                    if (size() < position + size) {
                        do {
                            try {
                                if (this.nd.truncate(this.fd, position + size) != -3) {
                                    break;
                                }
                            } catch (IOException r) {
                                if (OsConstants.S_ISREG(Libcore.os.fstat(this.fd).st_mode)) {
                                    throw r;
                                }
                            } catch (ErrnoException e) {
                                e.rethrowAsIOException();
                            }
                        } while (isOpen());
                    }
                    if (size == 0) {
                        DirectByteBuffer directByteBuffer = new DirectByteBuffer(0, 0, new FileDescriptor(), (Runnable) null, (!this.writable || imode == 0) ? true : f122assertionsDisabled);
                        this.threads.remove(ti);
                        end(IOStatus.checkAll(0));
                        return directByteBuffer;
                    }
                    int pagePosition = (int) (position % allocationGranularity);
                    mapPosition = position - ((long) pagePosition);
                    mapSize = size + ((long) pagePosition);
                    BlockGuard.getThreadPolicy().onReadFromDisk();
                    addr = map0(imode, mapPosition, mapSize);
                    FileDescriptor mfd = this.nd.duplicateForMapping(this.fd);
                    if (f122assertionsDisabled || IOStatus.checkAll(addr)) {
                        if (!f122assertionsDisabled) {
                            if (!(addr % allocationGranularity == 0 ? true : f122assertionsDisabled)) {
                                throw new AssertionError();
                            }
                        }
                        int isize = (int) size;
                        DirectByteBuffer directByteBuffer2 = new DirectByteBuffer(isize, addr + ((long) pagePosition), mfd, new Unmapper(addr, mapSize, isize, mfd, (Unmapper) null), (!this.writable || imode == 0) ? true : f122assertionsDisabled);
                        this.threads.remove(ti);
                        end(IOStatus.checkAll(addr));
                        return directByteBuffer2;
                    }
                    throw new AssertionError();
                } catch (IOException ioe) {
                    unmap0(addr, mapSize);
                    throw ioe;
                } catch (OutOfMemoryError y) {
                    throw new IOException("Map failed", y);
                } catch (OutOfMemoryError e2) {
                    System.gc();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e3) {
                        Thread.currentThread().interrupt();
                    }
                    addr = map0(imode, mapPosition, mapSize);
                } catch (Throwable th) {
                    this.threads.remove(ti);
                    end(IOStatus.checkAll(addr));
                    throw th;
                }
            }
        }
    }

    private static boolean isSharedFileLockTable() {
        boolean z = true;
        if (!propertyChecked) {
            synchronized (FileChannelImpl.class) {
                if (!propertyChecked) {
                    String value = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.ch.disableSystemWideOverlappingFileLockCheck"));
                    if (value != null) {
                        z = value.equals("false");
                    }
                    isSharedFileLockTable = z;
                    propertyChecked = true;
                }
            }
        }
        return isSharedFileLockTable;
    }

    private FileLockTable fileLockTable() throws IOException {
        if (this.fileLockTable == null) {
            synchronized (this) {
                if (this.fileLockTable == null) {
                    if (isSharedFileLockTable()) {
                        int ti = this.threads.add();
                        try {
                            ensureOpen();
                            this.fileLockTable = FileLockTable.newSharedFileLockTable(this, this.fd);
                            this.threads.remove(ti);
                        } catch (Throwable th) {
                            this.threads.remove(ti);
                            throw th;
                        }
                    } else {
                        this.fileLockTable = new SimpleFileLockTable();
                    }
                }
            }
        }
        return this.fileLockTable;
    }

    public FileLock lock(long position, long size, boolean shared) throws IOException {
        int n;
        ensureOpen();
        if (shared && !this.readable) {
            throw new NonReadableChannelException();
        } else if (shared || this.writable) {
            FileLockImpl fli = new FileLockImpl(this, position, size, shared);
            FileLockTable flt = fileLockTable();
            flt.add(fli);
            boolean completed = f122assertionsDisabled;
            int ti = -1;
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                if (!completed) {
                    flt.remove(fli);
                }
                this.threads.remove(ti);
                try {
                    end(completed);
                    return null;
                } catch (ClosedByInterruptException e) {
                    throw new FileLockInterruptionException();
                }
            } else {
                do {
                    try {
                        n = this.nd.lock(this.fd, true, position, size, shared);
                        if (n != 2 || !isOpen()) {
                        }
                        n = this.nd.lock(this.fd, true, position, size, shared);
                        break;
                    } finally {
                        if (!completed) {
                            flt.remove(fli);
                        }
                        this.threads.remove(ti);
                        try {
                            end(completed);
                        } catch (ClosedByInterruptException e2) {
                            throw new FileLockInterruptionException();
                        }
                    }
                } while (!isOpen());
                if (isOpen()) {
                    if (n == 1) {
                        if (f122assertionsDisabled || shared) {
                            FileLockImpl fli2 = new FileLockImpl(this, position, size, f122assertionsDisabled);
                            flt.replace(fli, fli2);
                            fli = fli2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                    completed = true;
                }
                try {
                    return fli;
                } catch (ClosedByInterruptException e3) {
                    throw new FileLockInterruptionException();
                }
            }
        } else {
            throw new NonWritableChannelException();
        }
    }

    public FileLock tryLock(long position, long size, boolean shared) throws IOException {
        ensureOpen();
        if (shared && !this.readable) {
            throw new NonReadableChannelException();
        } else if (shared || this.writable) {
            FileLockImpl fli = new FileLockImpl(this, position, size, shared);
            FileLockTable flt = fileLockTable();
            flt.add(fli);
            int ti = this.threads.add();
            try {
                ensureOpen();
                int result = this.nd.lock(this.fd, f122assertionsDisabled, position, size, shared);
                if (result == -1) {
                    flt.remove(fli);
                    this.threads.remove(ti);
                    return null;
                } else if (result != 1) {
                    this.threads.remove(ti);
                    return fli;
                } else if (f122assertionsDisabled || shared) {
                    FileLockImpl fli2 = new FileLockImpl(this, position, size, f122assertionsDisabled);
                    flt.replace(fli, fli2);
                    this.threads.remove(ti);
                    return fli2;
                } else {
                    throw new AssertionError();
                }
            } catch (IOException e) {
                flt.remove(fli);
                throw e;
            } catch (Throwable th) {
                this.threads.remove(ti);
                throw th;
            }
        } else {
            throw new NonWritableChannelException();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void release(FileLockImpl fli) throws IOException {
        int ti = this.threads.add();
        try {
            ensureOpen();
            this.nd.release(this.fd, fli.position(), fli.size());
            this.threads.remove(ti);
            if (!f122assertionsDisabled) {
                if (!(this.fileLockTable != null ? true : f122assertionsDisabled)) {
                    throw new AssertionError();
                }
            }
            this.fileLockTable.remove(fli);
        } catch (Throwable th) {
            this.threads.remove(ti);
            throw th;
        }
    }
}
