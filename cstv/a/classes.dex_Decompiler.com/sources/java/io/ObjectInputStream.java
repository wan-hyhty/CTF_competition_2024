package java.io;

import dalvik.system.VMStack;
import java.io.ObjectStreamClass;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;
import sun.reflect.misc.ReflectUtil;

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
public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants {
    private static final int NULL_HANDLE = -1;
    private static final HashMap<String, Class<?>> primClasses = null;
    private static final Object unsharedMarker = null;
    /* access modifiers changed from: private */
    public final BlockDataInputStream bin;
    private boolean closed;
    private SerialCallbackContext curContext;
    /* access modifiers changed from: private */
    public boolean defaultDataEnd;
    private int depth;
    private final boolean enableOverride;
    private boolean enableResolve;
    /* access modifiers changed from: private */
    public final HandleTable handles;
    /* access modifiers changed from: private */
    public int passHandle;
    private byte[] primVals;
    private final ValidationList vlist;

    private static class Caches {
        static final ConcurrentMap<ObjectStreamClass.WeakClassKey, Boolean> subclassAudits = null;
        static final ReferenceQueue<Class<?>> subclassAuditsQueue = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.ObjectInputStream.Caches.<clinit>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.ObjectInputStream.Caches.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.Caches.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.ObjectInputStream.Caches.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private Caches() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.ObjectInputStream.Caches.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.Caches.<init>():void");
        }
    }

    public static abstract class GetField {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.ObjectInputStream.GetField.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public GetField() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.ObjectInputStream.GetField.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetField.<init>():void");
        }

        public abstract boolean defaulted(String str) throws IOException;

        public abstract byte get(String str, byte b) throws IOException;

        public abstract char get(String str, char c) throws IOException;

        public abstract double get(String str, double d) throws IOException;

        public abstract float get(String str, float f) throws IOException;

        public abstract int get(String str, int i) throws IOException;

        public abstract long get(String str, long j) throws IOException;

        public abstract Object get(String str, Object obj) throws IOException;

        public abstract short get(String str, short s) throws IOException;

        public abstract boolean get(String str, boolean z) throws IOException;

        public abstract ObjectStreamClass getObjectStreamClass();
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectInputStream.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectInputStream.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.<clinit>():void");
    }

    /* access modifiers changed from: private */
    public static native void bytesToDoubles(byte[] bArr, int i, double[] dArr, int i2, int i3);

    /* access modifiers changed from: private */
    public static native void bytesToFloats(byte[] bArr, int i, float[] fArr, int i2, int i3);

    public ObjectInputStream(InputStream in) throws IOException {
        this.passHandle = -1;
        this.defaultDataEnd = false;
        verifySubclass();
        this.bin = new BlockDataInputStream(this, in);
        this.handles = new HandleTable(10);
        this.vlist = new ValidationList();
        this.enableOverride = false;
        readStreamHeader();
        this.bin.setBlockDataMode(true);
    }

    protected ObjectInputStream() throws IOException, SecurityException {
        this.passHandle = -1;
        this.defaultDataEnd = false;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
        }
        this.bin = null;
        this.handles = null;
        this.vlist = null;
        this.enableOverride = true;
    }

    public final Object readObject() throws IOException, ClassNotFoundException {
        if (this.enableOverride) {
            return readObjectOverride();
        }
        int outerHandle = this.passHandle;
        try {
            Object obj = readObject0(false);
            this.handles.markDependency(outerHandle, this.passHandle);
            ClassNotFoundException ex = this.handles.lookupException(this.passHandle);
            if (ex != null) {
                throw ex;
            }
            if (this.depth == 0) {
                this.vlist.doCallbacks();
            }
            return obj;
        } finally {
            this.passHandle = outerHandle;
            if (this.closed && this.depth == 0) {
                clear();
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object readObjectOverride() throws IOException, ClassNotFoundException {
        return null;
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        int outerHandle = this.passHandle;
        try {
            Object obj = readObject0(true);
            this.handles.markDependency(outerHandle, this.passHandle);
            ClassNotFoundException ex = this.handles.lookupException(this.passHandle);
            if (ex != null) {
                throw ex;
            }
            if (this.depth == 0) {
                this.vlist.doCallbacks();
            }
            return obj;
        } finally {
            this.passHandle = outerHandle;
            if (this.closed && this.depth == 0) {
                clear();
            }
        }
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException {
        if (this.curContext == null) {
            throw new NotActiveException("not in call to readObject");
        }
        Object curObj = this.curContext.getObj();
        ObjectStreamClass curDesc = this.curContext.getDesc();
        this.bin.setBlockDataMode(false);
        defaultReadFields(curObj, curDesc);
        this.bin.setBlockDataMode(true);
        if (!curDesc.hasWriteObjectData()) {
            this.defaultDataEnd = true;
        }
        ClassNotFoundException ex = this.handles.lookupException(this.passHandle);
        if (ex != null) {
            throw ex;
        }
    }

    public GetField readFields() throws IOException, ClassNotFoundException {
        if (this.curContext == null) {
            throw new NotActiveException("not in call to readObject");
        }
        Object obj = this.curContext.getObj();
        ObjectStreamClass curDesc = this.curContext.getDesc();
        this.bin.setBlockDataMode(false);
        GetFieldImpl getField = new GetFieldImpl(this, curDesc);
        getField.readFields();
        this.bin.setBlockDataMode(true);
        if (!curDesc.hasWriteObjectData()) {
            this.defaultDataEnd = true;
        }
        return getField;
    }

    public void registerValidation(ObjectInputValidation obj, int prio) throws NotActiveException, InvalidObjectException {
        if (this.depth == 0) {
            throw new NotActiveException("stream inactive");
        }
        this.vlist.register(obj, prio);
    }

    /* access modifiers changed from: protected */
    public Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        String name = desc.getName();
        try {
            return Class.forName(name, false, latestUserDefinedLoader());
        } catch (ClassNotFoundException ex) {
            Class<?> cl = primClasses.get(name);
            if (cl != null) {
                return cl;
            }
            throw ex;
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> resolveProxyClass(String[] interfaces) throws IOException, ClassNotFoundException {
        ClassLoader latestLoader = latestUserDefinedLoader();
        ClassLoader nonPublicLoader = null;
        boolean hasNonPublicInterface = false;
        Class[] classObjs = new Class[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            Class cl = Class.forName(interfaces[i], false, latestLoader);
            if ((cl.getModifiers() & 1) == 0) {
                if (!hasNonPublicInterface) {
                    nonPublicLoader = cl.getClassLoader();
                    hasNonPublicInterface = true;
                } else if (nonPublicLoader != cl.getClassLoader()) {
                    throw new IllegalAccessError("conflicting non-public interface class loaders");
                }
            }
            classObjs[i] = cl;
        }
        if (!hasNonPublicInterface) {
            nonPublicLoader = latestLoader;
        }
        try {
            return Proxy.getProxyClass(nonPublicLoader, classObjs);
        } catch (IllegalArgumentException e) {
            throw new ClassNotFoundException((String) null, e);
        }
    }

    /* access modifiers changed from: protected */
    public Object resolveObject(Object obj) throws IOException {
        return obj;
    }

    /* access modifiers changed from: protected */
    public boolean enableResolveObject(boolean enable) throws SecurityException {
        SecurityManager sm;
        if (enable == this.enableResolve) {
            return enable;
        }
        if (enable && (sm = System.getSecurityManager()) != null) {
            sm.checkPermission(SUBSTITUTION_PERMISSION);
        }
        this.enableResolve = enable;
        return !this.enableResolve;
    }

    /* access modifiers changed from: protected */
    public void readStreamHeader() throws IOException, StreamCorruptedException {
        short s0 = this.bin.readShort();
        short s1 = this.bin.readShort();
        if (s0 != -21267 || s1 != 5) {
            throw new StreamCorruptedException(String.format("invalid stream header: %04X%04X", Short.valueOf(s0), Short.valueOf(s1)));
        }
    }

    /* access modifiers changed from: protected */
    public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass desc = new ObjectStreamClass();
        desc.readNonProxy(this);
        return desc;
    }

    public int read() throws IOException {
        return this.bin.read();
    }

    public int read(byte[] buf, int off, int len) throws IOException {
        if (buf == null) {
            throw new NullPointerException();
        }
        int endoff = off + len;
        if (off >= 0 && len >= 0 && endoff <= buf.length && endoff >= 0) {
            return this.bin.read(buf, off, len, false);
        }
        throw new IndexOutOfBoundsException();
    }

    public int available() throws IOException {
        return this.bin.available();
    }

    public void close() throws IOException {
        this.closed = true;
        if (this.depth == 0) {
            clear();
        }
        this.bin.close();
    }

    public boolean readBoolean() throws IOException {
        return this.bin.readBoolean();
    }

    public byte readByte() throws IOException {
        return this.bin.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return this.bin.readUnsignedByte();
    }

    public char readChar() throws IOException {
        return this.bin.readChar();
    }

    public short readShort() throws IOException {
        return this.bin.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return this.bin.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return this.bin.readInt();
    }

    public long readLong() throws IOException {
        return this.bin.readLong();
    }

    public float readFloat() throws IOException {
        return this.bin.readFloat();
    }

    public double readDouble() throws IOException {
        return this.bin.readDouble();
    }

    public void readFully(byte[] buf) throws IOException {
        this.bin.readFully(buf, 0, buf.length, false);
    }

    public void readFully(byte[] buf, int off, int len) throws IOException {
        int endoff = off + len;
        if (off < 0 || len < 0 || endoff > buf.length || endoff < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.bin.readFully(buf, off, len, false);
    }

    public int skipBytes(int len) throws IOException {
        return this.bin.skipBytes(len);
    }

    @Deprecated
    public String readLine() throws IOException {
        return this.bin.readLine();
    }

    public String readUTF() throws IOException {
        return this.bin.readUTF();
    }

    private void verifySubclass() {
        SecurityManager sm;
        Class cl = getClass();
        if (cl != ObjectInputStream.class && (sm = System.getSecurityManager()) != null) {
            ObjectStreamClass.processQueue(Caches.subclassAuditsQueue, Caches.subclassAudits);
            ObjectStreamClass.WeakClassKey key = new ObjectStreamClass.WeakClassKey(cl, Caches.subclassAuditsQueue);
            Boolean result = (Boolean) Caches.subclassAudits.get(key);
            if (result == null) {
                result = Boolean.valueOf(auditSubclass(cl));
                Caches.subclassAudits.putIfAbsent(key, result);
            }
            if (!result.booleanValue()) {
                sm.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private static boolean auditSubclass(java.lang.Class<?> r2) {
        /*
            java.io.ObjectInputStream$1 r1 = new java.io.ObjectInputStream$1
            r1.<init>(r2)
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r1 = r0.booleanValue()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.auditSubclass(java.lang.Class):boolean");
    }

    private void clear() {
        this.handles.clear();
        this.vlist.clear();
    }

    /* access modifiers changed from: private */
    public Object readObject0(boolean unshared) throws IOException {
        byte tc;
        boolean oldMode = this.bin.getBlockDataMode();
        if (oldMode) {
            int remain = this.bin.currentBlockRemaining();
            if (remain > 0) {
                throw new OptionalDataException(remain);
            } else if (this.defaultDataEnd) {
                throw new OptionalDataException(true);
            } else {
                this.bin.setBlockDataMode(false);
            }
        }
        while (true) {
            tc = this.bin.peekByte();
            if (tc != 121) {
                break;
            }
            this.bin.readByte();
            handleReset();
        }
        this.depth++;
        switch (tc) {
            case 112:
                Object readNull = readNull();
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return readNull;
            case 113:
                Object readHandle = readHandle(unshared);
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return readHandle;
            case 114:
            case 125:
                ObjectStreamClass readClassDesc = readClassDesc(unshared);
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return readClassDesc;
            case 115:
                Object checkResolve = checkResolve(readOrdinaryObject(unshared));
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return checkResolve;
            case 116:
            case 124:
                Object checkResolve2 = checkResolve(readString(unshared));
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return checkResolve2;
            case 117:
                Object checkResolve3 = checkResolve(readArray(unshared));
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return checkResolve3;
            case 118:
                Class readClass = readClass(unshared);
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return readClass;
            case 119:
            case 122:
                if (oldMode) {
                    this.bin.setBlockDataMode(true);
                    this.bin.peek();
                    throw new OptionalDataException(this.bin.currentBlockRemaining());
                }
                throw new StreamCorruptedException("unexpected block data");
            case 120:
                if (oldMode) {
                    throw new OptionalDataException(true);
                }
                throw new StreamCorruptedException("unexpected end of block data");
            case 123:
                throw new WriteAbortedException("writing aborted", readFatalException());
            case 126:
                Object checkResolve4 = checkResolve(readEnum(unshared));
                this.depth--;
                this.bin.setBlockDataMode(oldMode);
                return checkResolve4;
            default:
                try {
                    throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc)));
                } catch (Throwable th) {
                    this.depth--;
                    this.bin.setBlockDataMode(oldMode);
                    throw th;
                }
        }
        this.depth--;
        this.bin.setBlockDataMode(oldMode);
        throw th;
    }

    private Object checkResolve(Object obj) throws IOException {
        if (!this.enableResolve || this.handles.lookupException(this.passHandle) != null) {
            return obj;
        }
        Object rep = resolveObject(obj);
        if (rep != obj) {
            this.handles.setObject(this.passHandle, rep);
        }
        return rep;
    }

    /* access modifiers changed from: package-private */
    public String readTypeString() throws IOException {
        int oldHandle = this.passHandle;
        try {
            byte tc = this.bin.peekByte();
            switch (tc) {
                case 112:
                    return (String) readNull();
                case 113:
                    String str = (String) readHandle(false);
                    this.passHandle = oldHandle;
                    return str;
                case 116:
                case 124:
                    String readString = readString(false);
                    this.passHandle = oldHandle;
                    return readString;
                default:
                    throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc)));
            }
        } finally {
            this.passHandle = oldHandle;
        }
        this.passHandle = oldHandle;
    }

    private Object readNull() throws IOException {
        if (this.bin.readByte() != 112) {
            throw new InternalError();
        }
        this.passHandle = -1;
        return null;
    }

    private Object readHandle(boolean unshared) throws IOException {
        if (this.bin.readByte() != 113) {
            throw new InternalError();
        }
        this.passHandle = this.bin.readInt() - ObjectStreamConstants.baseWireHandle;
        if (this.passHandle < 0 || this.passHandle >= this.handles.size()) {
            throw new StreamCorruptedException(String.format("invalid handle value: %08X", Integer.valueOf(this.passHandle + ObjectStreamConstants.baseWireHandle)));
        } else if (unshared) {
            throw new InvalidObjectException("cannot read back reference as unshared");
        } else {
            Object obj = this.handles.lookupObject(this.passHandle);
            if (obj != unsharedMarker) {
                return obj;
            }
            throw new InvalidObjectException("cannot read back reference to unshared object");
        }
    }

    private Class readClass(boolean unshared) throws IOException {
        Object obj;
        if (this.bin.readByte() != 118) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        Class cl = desc.forClass();
        HandleTable handleTable = this.handles;
        if (unshared) {
            obj = unsharedMarker;
        } else {
            obj = cl;
        }
        this.passHandle = handleTable.assign(obj);
        ClassNotFoundException resolveEx = desc.getResolveException();
        if (resolveEx != null) {
            this.handles.markException(this.passHandle, resolveEx);
        }
        this.handles.finish(this.passHandle);
        return cl;
    }

    private ObjectStreamClass readClassDesc(boolean unshared) throws IOException {
        byte tc = this.bin.peekByte();
        switch (tc) {
            case 112:
                return (ObjectStreamClass) readNull();
            case 113:
                return (ObjectStreamClass) readHandle(unshared);
            case 114:
                return readNonProxyDesc(unshared);
            case 125:
                return readProxyDesc(unshared);
            default:
                throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc)));
        }
    }

    private boolean isCustomSubclass() {
        return getClass().getClassLoader() != ObjectInputStream.class.getClassLoader();
    }

    private ObjectStreamClass readProxyDesc(boolean unshared) throws IOException {
        Object obj;
        if (this.bin.readByte() != 125) {
            throw new InternalError();
        }
        ObjectStreamClass desc = new ObjectStreamClass();
        HandleTable handleTable = this.handles;
        if (unshared) {
            obj = unsharedMarker;
        } else {
            obj = desc;
        }
        int descHandle = handleTable.assign(obj);
        this.passHandle = -1;
        int numIfaces = this.bin.readInt();
        String[] ifaces = new String[numIfaces];
        for (int i = 0; i < numIfaces; i++) {
            ifaces[i] = this.bin.readUTF();
        }
        Class cl = null;
        ClassNotFoundException classNotFoundException = null;
        this.bin.setBlockDataMode(true);
        try {
            cl = resolveProxyClass(ifaces);
            if (cl == null) {
                classNotFoundException = new ClassNotFoundException("null class");
            } else if (!Proxy.isProxyClass(cl)) {
                throw new InvalidClassException("Not a proxy");
            } else {
                ReflectUtil.checkProxyPackageAccess(getClass().getClassLoader(), cl.getInterfaces());
            }
        } catch (ClassNotFoundException ex) {
            classNotFoundException = ex;
        }
        skipCustomData();
        desc.initProxy(cl, classNotFoundException, readClassDesc(false));
        this.handles.finish(descHandle);
        this.passHandle = descHandle;
        return desc;
    }

    private ObjectStreamClass readNonProxyDesc(boolean unshared) throws IOException {
        Object obj;
        if (this.bin.readByte() != 114) {
            throw new InternalError();
        }
        ObjectStreamClass desc = new ObjectStreamClass();
        HandleTable handleTable = this.handles;
        if (unshared) {
            obj = unsharedMarker;
        } else {
            obj = desc;
        }
        int descHandle = handleTable.assign(obj);
        this.passHandle = -1;
        try {
            ObjectStreamClass readDesc = readClassDescriptor();
            Class cl = null;
            ClassNotFoundException classNotFoundException = null;
            this.bin.setBlockDataMode(true);
            boolean checksRequired = isCustomSubclass();
            try {
                cl = resolveClass(readDesc);
                if (cl == null) {
                    classNotFoundException = new ClassNotFoundException("null class");
                } else if (checksRequired) {
                    ReflectUtil.checkPackageAccess((Class<?>) cl);
                }
            } catch (ClassNotFoundException ex) {
                classNotFoundException = ex;
            }
            skipCustomData();
            desc.initNonProxy(readDesc, cl, classNotFoundException, readClassDesc(false));
            this.handles.finish(descHandle);
            this.passHandle = descHandle;
            return desc;
        } catch (ClassNotFoundException ex2) {
            throw ((IOException) new InvalidClassException("failed to read class descriptor").initCause(ex2));
        }
    }

    private String readString(boolean unshared) throws IOException {
        String str;
        Object obj;
        byte tc = this.bin.readByte();
        switch (tc) {
            case 116:
                str = this.bin.readUTF();
                break;
            case 124:
                str = this.bin.readLongUTF();
                break;
            default:
                throw new StreamCorruptedException(String.format("invalid type code: %02X", Byte.valueOf(tc)));
        }
        HandleTable handleTable = this.handles;
        if (unshared) {
            obj = unsharedMarker;
        } else {
            obj = str;
        }
        this.passHandle = handleTable.assign(obj);
        this.handles.finish(this.passHandle);
        return str;
    }

    private Object readArray(boolean unshared) throws IOException {
        Object obj;
        if (this.bin.readByte() != 117) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        int len = this.bin.readInt();
        Object array = null;
        Class ccl = null;
        Class cl = desc.forClass();
        if (cl != null) {
            ccl = cl.getComponentType();
            array = Array.newInstance((Class<?>) ccl, len);
        }
        HandleTable handleTable = this.handles;
        if (unshared) {
            obj = unsharedMarker;
        } else {
            obj = array;
        }
        int arrayHandle = handleTable.assign(obj);
        ClassNotFoundException resolveEx = desc.getResolveException();
        if (resolveEx != null) {
            this.handles.markException(arrayHandle, resolveEx);
        }
        if (ccl == null) {
            for (int i = 0; i < len; i++) {
                readObject0(false);
            }
        } else if (!ccl.isPrimitive()) {
            Object[] oa = (Object[]) array;
            for (int i2 = 0; i2 < len; i2++) {
                oa[i2] = readObject0(false);
                this.handles.markDependency(arrayHandle, this.passHandle);
            }
        } else if (ccl == Integer.TYPE) {
            this.bin.readInts((int[]) array, 0, len);
        } else if (ccl == Byte.TYPE) {
            this.bin.readFully((byte[]) array, 0, len, true);
        } else if (ccl == Long.TYPE) {
            this.bin.readLongs((long[]) array, 0, len);
        } else if (ccl == Float.TYPE) {
            this.bin.readFloats((float[]) array, 0, len);
        } else if (ccl == Double.TYPE) {
            this.bin.readDoubles((double[]) array, 0, len);
        } else if (ccl == Short.TYPE) {
            this.bin.readShorts((short[]) array, 0, len);
        } else if (ccl == Character.TYPE) {
            this.bin.readChars((char[]) array, 0, len);
        } else if (ccl == Boolean.TYPE) {
            this.bin.readBooleans((boolean[]) array, 0, len);
        } else {
            throw new InternalError();
        }
        this.handles.finish(arrayHandle);
        this.passHandle = arrayHandle;
        return array;
    }

    private Enum readEnum(boolean unshared) throws IOException {
        Object obj = null;
        if (this.bin.readByte() != 126) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        if (!desc.isEnum()) {
            throw new InvalidClassException("non-enum class: " + desc);
        }
        HandleTable handleTable = this.handles;
        if (unshared) {
            obj = unsharedMarker;
        }
        int enumHandle = handleTable.assign(obj);
        ClassNotFoundException resolveEx = desc.getResolveException();
        if (resolveEx != null) {
            this.handles.markException(enumHandle, resolveEx);
        }
        String name = readString(false);
        Enum en = null;
        Class cl = desc.forClass();
        if (cl != null) {
            try {
                en = Enum.valueOf(cl, name);
                if (!unshared) {
                    this.handles.setObject(enumHandle, en);
                }
            } catch (IllegalArgumentException ex) {
                throw ((IOException) new InvalidObjectException("enum constant " + name + " does not exist in " + cl).initCause(ex));
            }
        }
        this.handles.finish(enumHandle);
        this.passHandle = enumHandle;
        return en;
    }

    private Object readOrdinaryObject(boolean unshared) throws IOException {
        Object obj;
        if (this.bin.readByte() != 115) {
            throw new InternalError();
        }
        ObjectStreamClass desc = readClassDesc(false);
        desc.checkDeserialize();
        Class<?> cl = desc.forClass();
        if (cl == String.class || cl == Class.class || cl == ObjectStreamClass.class) {
            throw new InvalidClassException("invalid class descriptor");
        }
        try {
            Object obj2 = desc.isInstantiable() ? desc.newInstance() : null;
            HandleTable handleTable = this.handles;
            if (unshared) {
                obj = unsharedMarker;
            } else {
                obj = obj2;
            }
            this.passHandle = handleTable.assign(obj);
            ClassNotFoundException resolveEx = desc.getResolveException();
            if (resolveEx != null) {
                this.handles.markException(this.passHandle, resolveEx);
            }
            if (desc.isExternalizable()) {
                readExternalData((Externalizable) obj2, desc);
            } else {
                readSerialData(obj2, desc);
            }
            this.handles.finish(this.passHandle);
            if (obj2 == null || this.handles.lookupException(this.passHandle) != null || !desc.hasReadResolveMethod()) {
                return obj2;
            }
            Object rep = desc.invokeReadResolve(obj2);
            if (unshared && rep.getClass().isArray()) {
                rep = cloneArray(rep);
            }
            if (rep == obj2) {
                return obj2;
            }
            Object obj3 = rep;
            this.handles.setObject(this.passHandle, rep);
            return obj3;
        } catch (Exception ex) {
            throw ((IOException) new InvalidClassException(desc.forClass().getName(), "unable to create instance").initCause(ex));
        }
    }

    private void readExternalData(Externalizable obj, ObjectStreamClass desc) throws IOException {
        boolean blocked;
        SerialCallbackContext oldContext = this.curContext;
        this.curContext = null;
        try {
            blocked = desc.hasBlockExternalData();
            if (blocked) {
                this.bin.setBlockDataMode(true);
            }
            if (obj != null) {
                obj.readExternal(this);
            }
        } catch (ClassNotFoundException ex) {
            this.handles.markException(this.passHandle, ex);
        } catch (Throwable th) {
            this.curContext = oldContext;
            throw th;
        }
        if (blocked) {
            skipCustomData();
        }
        this.curContext = oldContext;
    }

    private void readSerialData(Object obj, ObjectStreamClass desc) throws IOException {
        ObjectStreamClass.ClassDataSlot[] slots = desc.getClassDataLayout();
        for (int i = 0; i < slots.length; i++) {
            ObjectStreamClass slotDesc = slots[i].desc;
            if (slots[i].hasData) {
                if (obj == null || !slotDesc.hasReadObjectMethod() || this.handles.lookupException(this.passHandle) != null) {
                    defaultReadFields(obj, slotDesc);
                } else {
                    SerialCallbackContext oldContext = this.curContext;
                    try {
                        this.curContext = new SerialCallbackContext(obj, slotDesc);
                        this.bin.setBlockDataMode(true);
                        slotDesc.invokeReadObject(obj, this);
                        this.curContext.setUsed();
                    } catch (ClassNotFoundException ex) {
                        this.handles.markException(this.passHandle, ex);
                        this.curContext.setUsed();
                    } catch (Throwable th) {
                        this.curContext.setUsed();
                        this.curContext = oldContext;
                        throw th;
                    }
                    this.curContext = oldContext;
                    this.defaultDataEnd = false;
                }
                if (slotDesc.hasWriteObjectData()) {
                    skipCustomData();
                } else {
                    this.bin.setBlockDataMode(false);
                }
            } else if (obj != null && slotDesc.hasReadObjectNoDataMethod() && this.handles.lookupException(this.passHandle) == null) {
                slotDesc.invokeReadObjectNoData(obj);
            }
        }
    }

    private void skipCustomData() throws IOException {
        int oldHandle = this.passHandle;
        while (true) {
            if (this.bin.getBlockDataMode()) {
                this.bin.skipBlockData();
                this.bin.setBlockDataMode(false);
            }
            switch (this.bin.peekByte()) {
                case 119:
                case 122:
                    this.bin.setBlockDataMode(true);
                    break;
                case 120:
                    this.bin.readByte();
                    this.passHandle = oldHandle;
                    return;
                default:
                    readObject0(false);
                    break;
            }
        }
    }

    private void defaultReadFields(Object obj, ObjectStreamClass desc) throws IOException {
        Class cl = desc.forClass();
        if (cl == null || obj == null || cl.isInstance(obj)) {
            int primDataSize = desc.getPrimDataSize();
            if (this.primVals == null || this.primVals.length < primDataSize) {
                this.primVals = new byte[primDataSize];
            }
            this.bin.readFully(this.primVals, 0, primDataSize, false);
            if (obj != null) {
                desc.setPrimFieldValues(obj, this.primVals);
            }
            int objHandle = this.passHandle;
            ObjectStreamField[] fields = desc.getFields(false);
            Object[] objVals = new Object[desc.getNumObjFields()];
            int numPrimFields = fields.length - objVals.length;
            for (int i = 0; i < objVals.length; i++) {
                ObjectStreamField f = fields[numPrimFields + i];
                objVals[i] = readObject0(f.isUnshared());
                if (f.getField() != null) {
                    this.handles.markDependency(objHandle, this.passHandle);
                }
            }
            if (obj != null) {
                desc.setObjFieldValues(obj, objVals);
            }
            this.passHandle = objHandle;
            return;
        }
        throw new ClassCastException();
    }

    private IOException readFatalException() throws IOException {
        if (this.bin.readByte() != 123) {
            throw new InternalError();
        }
        clear();
        IOException e = (IOException) readObject0(false);
        clear();
        return e;
    }

    /* access modifiers changed from: private */
    public void handleReset() throws StreamCorruptedException {
        if (this.depth > 0) {
            throw new StreamCorruptedException("unexpected reset; recursion depth: " + this.depth);
        }
        clear();
    }

    private static ClassLoader latestUserDefinedLoader() {
        return VMStack.getClosestUserClassLoader();
    }

    private class GetFieldImpl extends GetField {
        private final ObjectStreamClass desc;
        private final int[] objHandles;
        private final Object[] objVals;
        private final byte[] primVals;
        final /* synthetic */ ObjectInputStream this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.io.ObjectInputStream.GetFieldImpl.<init>(java.io.ObjectInputStream, java.io.ObjectStreamClass):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        GetFieldImpl(java.io.ObjectInputStream r1, java.io.ObjectStreamClass r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.io.ObjectInputStream.GetFieldImpl.<init>(java.io.ObjectInputStream, java.io.ObjectStreamClass):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.<init>(java.io.ObjectInputStream, java.io.ObjectStreamClass):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.getFieldOffset(java.lang.String, java.lang.Class):int, dex: classes.dex
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
        private int getFieldOffset(java.lang.String r1, java.lang.Class r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.getFieldOffset(java.lang.String, java.lang.Class):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.getFieldOffset(java.lang.String, java.lang.Class):int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, byte):byte, dex: classes.dex
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
        public byte get(java.lang.String r1, byte r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, byte):byte, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, byte):byte");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, char):char, dex: classes.dex
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
        public char get(java.lang.String r1, char r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, char):char, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, char):char");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, double):double, dex: classes.dex
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
        public double get(java.lang.String r1, double r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, double):double, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, double):double");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, float):float, dex: classes.dex
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
        public float get(java.lang.String r1, float r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, float):float, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, float):float");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, int):int, dex: classes.dex
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
        public int get(java.lang.String r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, int):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, int):int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, long):long, dex: classes.dex
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
        public long get(java.lang.String r1, long r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, long):long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, long):long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, java.lang.Object):java.lang.Object, dex: classes.dex
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
        public java.lang.Object get(java.lang.String r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, java.lang.Object):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, java.lang.Object):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, short):short, dex: classes.dex
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
        public short get(java.lang.String r1, short r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, short):short, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, short):short");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, boolean):boolean, dex: classes.dex
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
        public boolean get(java.lang.String r1, boolean r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, boolean):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.get(java.lang.String, boolean):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.getObjectStreamClass():java.io.ObjectStreamClass, dex: classes.dex
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
        public java.io.ObjectStreamClass getObjectStreamClass() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.getObjectStreamClass():java.io.ObjectStreamClass, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.getObjectStreamClass():java.io.ObjectStreamClass");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.readFields():void, dex: classes.dex
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
        void readFields() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.GetFieldImpl.readFields():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.GetFieldImpl.readFields():void");
        }

        public boolean defaulted(String name) throws IOException {
            return getFieldOffset(name, (Class) null) < 0;
        }
    }

    private static class ValidationList {
        /* access modifiers changed from: private */
        public Callback list;

        private static class Callback {
            final AccessControlContext acc;
            Callback next;
            final ObjectInputValidation obj;
            final int priority;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.io.ObjectInputStream.ValidationList.Callback.<init>(java.io.ObjectInputValidation, int, java.io.ObjectInputStream$ValidationList$Callback, java.security.AccessControlContext):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            Callback(java.io.ObjectInputValidation r1, int r2, java.io.ObjectInputStream.ValidationList.Callback r3, java.security.AccessControlContext r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.io.ObjectInputStream.ValidationList.Callback.<init>(java.io.ObjectInputValidation, int, java.io.ObjectInputStream$ValidationList$Callback, java.security.AccessControlContext):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.ValidationList.Callback.<init>(java.io.ObjectInputValidation, int, java.io.ObjectInputStream$ValidationList$Callback, java.security.AccessControlContext):void");
            }
        }

        ValidationList() {
        }

        /* access modifiers changed from: package-private */
        public void register(ObjectInputValidation obj, int priority) throws InvalidObjectException {
            if (obj == null) {
                throw new InvalidObjectException("null callback");
            }
            Callback prev = null;
            Callback cur = this.list;
            while (cur != null && priority < cur.priority) {
                prev = cur;
                cur = cur.next;
            }
            AccessControlContext acc = AccessController.getContext();
            if (prev != null) {
                prev.next = new Callback(obj, priority, cur, acc);
            } else {
                this.list = new Callback(obj, priority, this.list, acc);
            }
        }

        /* access modifiers changed from: package-private */
        public void doCallbacks() throws InvalidObjectException {
            while (this.list != null) {
                try {
                    AccessController.doPrivileged(new PrivilegedExceptionAction<Void>(this) {
                        final /* synthetic */ ValidationList this$1;

                        /*  JADX ERROR: Method load error
                            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectInputStream.ValidationList.1.run():java.lang.Object, dex: classes.dex
                            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
                            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                            	... 7 more
                            */
                        public /* bridge */ /* synthetic */ java.lang.Object run() {
                            /*
                            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectInputStream.ValidationList.1.run():java.lang.Object, dex: classes.dex
                            */
                            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.ValidationList.AnonymousClass1.run():java.lang.Object");
                        }

                        /*  JADX ERROR: Method load error
                            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.ValidationList.1.run():java.lang.Void, dex: classes.dex
                            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                            	... 7 more
                            */
                        public java.lang.Void run() {
                            /*
                            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.io.ObjectInputStream.ValidationList.1.run():java.lang.Void, dex: classes.dex
                            */
                            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.ValidationList.AnonymousClass1.run():java.lang.Void");
                        }
                    }, this.list.acc);
                    this.list = this.list.next;
                } catch (PrivilegedActionException ex) {
                    this.list = null;
                    throw ((InvalidObjectException) ex.getException());
                }
            }
        }

        public void clear() {
            this.list = null;
        }
    }

    private static class PeekInputStream extends InputStream {
        private final InputStream in;
        private int peekb;

        PeekInputStream(InputStream in2) {
            this.peekb = -1;
            this.in = in2;
        }

        /* access modifiers changed from: package-private */
        public int peek() throws IOException {
            if (this.peekb >= 0) {
                return this.peekb;
            }
            int read = this.in.read();
            this.peekb = read;
            return read;
        }

        public int read() throws IOException {
            if (this.peekb < 0) {
                return this.in.read();
            }
            int v = this.peekb;
            this.peekb = -1;
            return v;
        }

        public int read(byte[] b, int off, int len) throws IOException {
            if (len == 0) {
                return 0;
            }
            if (this.peekb < 0) {
                return this.in.read(b, off, len);
            }
            b[off] = (byte) this.peekb;
            this.peekb = -1;
            int n = this.in.read(b, off + 1, len - 1);
            if (n >= 0) {
                return n + 1;
            }
            return 1;
        }

        /* access modifiers changed from: package-private */
        public void readFully(byte[] b, int off, int len) throws IOException {
            int n = 0;
            while (n < len) {
                int count = read(b, off + n, len - n);
                if (count < 0) {
                    throw new EOFException();
                }
                n += count;
            }
        }

        public long skip(long n) throws IOException {
            if (n <= 0) {
                return 0;
            }
            int skipped = 0;
            if (this.peekb >= 0) {
                this.peekb = -1;
                skipped = 1;
                n--;
            }
            return ((long) skipped) + skip(n);
        }

        public int available() throws IOException {
            int i = 0;
            int available = this.in.available();
            if (this.peekb >= 0) {
                i = 1;
            }
            return i + available;
        }

        public void close() throws IOException {
            this.in.close();
        }
    }

    private class BlockDataInputStream extends InputStream implements DataInput {
        private static final int CHAR_BUF_SIZE = 256;
        private static final int HEADER_BLOCKED = -2;
        private static final int MAX_BLOCK_SIZE = 1024;
        private static final int MAX_HEADER_SIZE = 5;
        private boolean blkmode;
        private final byte[] buf;
        private final char[] cbuf;
        private final DataInputStream din;
        private int end;
        private final byte[] hbuf;
        private final PeekInputStream in;
        private int pos;
        final /* synthetic */ ObjectInputStream this$0;
        private int unread;

        BlockDataInputStream(ObjectInputStream this$02, InputStream in2) {
            this.this$0 = this$02;
            this.buf = new byte[1024];
            this.hbuf = new byte[5];
            this.cbuf = new char[256];
            this.blkmode = false;
            this.pos = 0;
            this.end = -1;
            this.unread = 0;
            this.in = new PeekInputStream(in2);
            this.din = new DataInputStream(this);
        }

        /* access modifiers changed from: package-private */
        public boolean setBlockDataMode(boolean newmode) throws IOException {
            if (this.blkmode == newmode) {
                return this.blkmode;
            }
            if (newmode) {
                this.pos = 0;
                this.end = 0;
                this.unread = 0;
            } else if (this.pos < this.end) {
                throw new IllegalStateException("unread block data");
            }
            this.blkmode = newmode;
            if (this.blkmode) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean getBlockDataMode() {
            return this.blkmode;
        }

        /* access modifiers changed from: package-private */
        public void skipBlockData() throws IOException {
            if (!this.blkmode) {
                throw new IllegalStateException("not in block data mode");
            }
            while (this.end >= 0) {
                refill();
            }
        }

        private int readBlockHeader(boolean canBlock) throws IOException {
            if (this.this$0.defaultDataEnd) {
                return -1;
            }
            while (true) {
                int avail = canBlock ? Integer.MAX_VALUE : this.in.available();
                if (avail == 0) {
                    return -2;
                }
                int tc = this.in.peek();
                switch (tc) {
                    case 119:
                        if (avail < 2) {
                            return -2;
                        }
                        this.in.readFully(this.hbuf, 0, 2);
                        return this.hbuf[1] & Character.DIRECTIONALITY_UNDEFINED;
                    case 121:
                        try {
                            this.in.read();
                            this.this$0.handleReset();
                        } catch (EOFException e) {
                            throw new StreamCorruptedException("unexpected EOF while reading block data header");
                        }
                    case 122:
                        if (avail < 5) {
                            return -2;
                        }
                        this.in.readFully(this.hbuf, 0, 5);
                        int len = Bits.getInt(this.hbuf, 1);
                        if (len >= 0) {
                            return len;
                        }
                        throw new StreamCorruptedException("illegal block data header length: " + len);
                    default:
                        if (tc < 0 || (tc >= 112 && tc <= 126)) {
                            return -1;
                        }
                        throw new StreamCorruptedException(String.format("invalid type code: %02X", Integer.valueOf(tc)));
                }
                throw new StreamCorruptedException("unexpected EOF while reading block data header");
            }
        }

        private void refill() throws IOException {
            do {
                try {
                    this.pos = 0;
                    if (this.unread > 0) {
                        int n = this.in.read(this.buf, 0, Math.min(this.unread, 1024));
                        if (n >= 0) {
                            this.end = n;
                            this.unread -= n;
                        } else {
                            throw new StreamCorruptedException("unexpected EOF in middle of data block");
                        }
                    } else {
                        int n2 = readBlockHeader(true);
                        if (n2 >= 0) {
                            this.end = 0;
                            this.unread = n2;
                        } else {
                            this.end = -1;
                            this.unread = 0;
                        }
                    }
                } catch (IOException ex) {
                    this.pos = 0;
                    this.end = -1;
                    this.unread = 0;
                    throw ex;
                }
            } while (this.pos == this.end);
        }

        /* access modifiers changed from: package-private */
        public int currentBlockRemaining() {
            if (!this.blkmode) {
                throw new IllegalStateException();
            } else if (this.end >= 0) {
                return (this.end - this.pos) + this.unread;
            } else {
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int peek() throws IOException {
            if (!this.blkmode) {
                return this.in.peek();
            }
            if (this.pos == this.end) {
                refill();
            }
            if (this.end >= 0) {
                return this.buf[this.pos] & Character.DIRECTIONALITY_UNDEFINED;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public byte peekByte() throws IOException {
            int val = peek();
            if (val >= 0) {
                return (byte) val;
            }
            throw new EOFException();
        }

        public int read() throws IOException {
            if (!this.blkmode) {
                return this.in.read();
            }
            if (this.pos == this.end) {
                refill();
            }
            if (this.end < 0) {
                return -1;
            }
            byte[] bArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i] & Character.DIRECTIONALITY_UNDEFINED;
        }

        public int read(byte[] b, int off, int len) throws IOException {
            return read(b, off, len, false);
        }

        public long skip(long len) throws IOException {
            long remain = len;
            while (remain > 0) {
                if (!this.blkmode) {
                    int nread = this.in.read(this.buf, 0, (int) Math.min(remain, 1024));
                    if (nread < 0) {
                        break;
                    }
                    remain -= (long) nread;
                } else {
                    if (this.pos == this.end) {
                        refill();
                    }
                    if (this.end < 0) {
                        break;
                    }
                    int nread2 = (int) Math.min(remain, (long) (this.end - this.pos));
                    remain -= (long) nread2;
                    this.pos += nread2;
                }
            }
            return len - remain;
        }

        public int available() throws IOException {
            int n;
            if (!this.blkmode) {
                return this.in.available();
            }
            if (this.pos == this.end && this.unread == 0) {
                do {
                    n = readBlockHeader(false);
                } while (n == 0);
                switch (n) {
                    case -2:
                        break;
                    case -1:
                        this.pos = 0;
                        this.end = -1;
                        break;
                    default:
                        this.pos = 0;
                        this.end = 0;
                        this.unread = n;
                        break;
                }
            }
            int unreadAvail = this.unread > 0 ? Math.min(this.in.available(), this.unread) : 0;
            if (this.end >= 0) {
                return (this.end - this.pos) + unreadAvail;
            }
            return 0;
        }

        public void close() throws IOException {
            if (this.blkmode) {
                this.pos = 0;
                this.end = -1;
                this.unread = 0;
            }
            this.in.close();
        }

        /* access modifiers changed from: package-private */
        public int read(byte[] b, int off, int len, boolean copy) throws IOException {
            if (len == 0) {
                return 0;
            }
            if (this.blkmode) {
                if (this.pos == this.end) {
                    refill();
                }
                if (this.end < 0) {
                    return -1;
                }
                int nread = Math.min(len, this.end - this.pos);
                System.arraycopy(this.buf, this.pos, b, off, nread);
                this.pos += nread;
                return nread;
            } else if (!copy) {
                return this.in.read(b, off, len);
            } else {
                int nread2 = this.in.read(this.buf, 0, Math.min(len, 1024));
                if (nread2 > 0) {
                    System.arraycopy(this.buf, 0, b, off, nread2);
                }
                return nread2;
            }
        }

        public void readFully(byte[] b) throws IOException {
            readFully(b, 0, b.length, false);
        }

        public void readFully(byte[] b, int off, int len) throws IOException {
            readFully(b, off, len, false);
        }

        public void readFully(byte[] b, int off, int len, boolean copy) throws IOException {
            while (len > 0) {
                int n = read(b, off, len, copy);
                if (n < 0) {
                    throw new EOFException();
                }
                off += n;
                len -= n;
            }
        }

        public int skipBytes(int n) throws IOException {
            return this.din.skipBytes(n);
        }

        public boolean readBoolean() throws IOException {
            int v = read();
            if (v < 0) {
                throw new EOFException();
            } else if (v != 0) {
                return true;
            } else {
                return false;
            }
        }

        public byte readByte() throws IOException {
            int v = read();
            if (v >= 0) {
                return (byte) v;
            }
            throw new EOFException();
        }

        public int readUnsignedByte() throws IOException {
            int v = read();
            if (v >= 0) {
                return v;
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 2);
            } else if (this.end - this.pos < 2) {
                return this.din.readChar();
            }
            char v = Bits.getChar(this.buf, this.pos);
            this.pos += 2;
            return v;
        }

        public short readShort() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 2);
            } else if (this.end - this.pos < 2) {
                return this.din.readShort();
            }
            short v = Bits.getShort(this.buf, this.pos);
            this.pos += 2;
            return v;
        }

        public int readUnsignedShort() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 2);
            } else if (this.end - this.pos < 2) {
                return this.din.readUnsignedShort();
            }
            int v = Bits.getShort(this.buf, this.pos) & 65535;
            this.pos += 2;
            return v;
        }

        public int readInt() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 4);
            } else if (this.end - this.pos < 4) {
                return this.din.readInt();
            }
            int v = Bits.getInt(this.buf, this.pos);
            this.pos += 4;
            return v;
        }

        public float readFloat() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 4);
            } else if (this.end - this.pos < 4) {
                return this.din.readFloat();
            }
            float v = Bits.getFloat(this.buf, this.pos);
            this.pos += 4;
            return v;
        }

        public long readLong() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 8);
            } else if (this.end - this.pos < 8) {
                return this.din.readLong();
            }
            long v = Bits.getLong(this.buf, this.pos);
            this.pos += 8;
            return v;
        }

        public double readDouble() throws IOException {
            if (!this.blkmode) {
                this.pos = 0;
                this.in.readFully(this.buf, 0, 8);
            } else if (this.end - this.pos < 8) {
                return this.din.readDouble();
            }
            double v = Bits.getDouble(this.buf, this.pos);
            this.pos += 8;
            return v;
        }

        public String readUTF() throws IOException {
            return readUTFBody((long) readUnsignedShort());
        }

        public String readLine() throws IOException {
            return this.din.readLine();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x001f A[LOOP:1: B:5:0x001d->B:6:0x001f, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void readBooleans(boolean[] r9, int r10, int r11) throws java.io.IOException {
            /*
                r8 = this;
                r7 = 0
                int r0 = r10 + r11
                r1 = r10
            L_0x0004:
                if (r1 >= r0) goto L_0x0050
                boolean r4 = r8.blkmode
                if (r4 != 0) goto L_0x0031
                int r4 = r0 - r1
                r5 = 1024(0x400, float:1.435E-42)
                int r2 = java.lang.Math.min((int) r4, (int) r5)
                java.io.ObjectInputStream$PeekInputStream r4 = r8.in
                byte[] r5 = r8.buf
                r4.readFully(r5, r7, r2)
                int r3 = r1 + r2
                r8.pos = r7
            L_0x001d:
                if (r1 >= r3) goto L_0x0004
                int r10 = r1 + 1
                byte[] r4 = r8.buf
                int r5 = r8.pos
                int r6 = r5 + 1
                r8.pos = r6
                boolean r4 = java.io.Bits.getBoolean(r4, r5)
                r9[r1] = r4
                r1 = r10
                goto L_0x001d
            L_0x0031:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                r5 = 1
                if (r4 >= r5) goto L_0x0045
                int r10 = r1 + 1
                java.io.DataInputStream r4 = r8.din
                boolean r4 = r4.readBoolean()
                r9[r1] = r4
                r1 = r10
                goto L_0x0004
            L_0x0045:
                int r4 = r8.end
                int r4 = r4 + r1
                int r5 = r8.pos
                int r4 = r4 - r5
                int r3 = java.lang.Math.min((int) r0, (int) r4)
                goto L_0x001d
            L_0x0050:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.readBooleans(boolean[], int, int):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0021 A[LOOP:1: B:5:0x001f->B:6:0x0021, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void readChars(char[] r9, int r10, int r11) throws java.io.IOException {
            /*
                r8 = this;
                r7 = 0
                int r0 = r10 + r11
                r1 = r10
            L_0x0004:
                if (r1 >= r0) goto L_0x0056
                boolean r4 = r8.blkmode
                if (r4 != 0) goto L_0x0035
                int r4 = r0 - r1
                r5 = 512(0x200, float:7.175E-43)
                int r2 = java.lang.Math.min((int) r4, (int) r5)
                java.io.ObjectInputStream$PeekInputStream r4 = r8.in
                byte[] r5 = r8.buf
                int r6 = r2 << 1
                r4.readFully(r5, r7, r6)
                int r3 = r1 + r2
                r8.pos = r7
            L_0x001f:
                if (r1 >= r3) goto L_0x0004
                int r10 = r1 + 1
                byte[] r4 = r8.buf
                int r5 = r8.pos
                char r4 = java.io.Bits.getChar(r4, r5)
                r9[r1] = r4
                int r4 = r8.pos
                int r4 = r4 + 2
                r8.pos = r4
                r1 = r10
                goto L_0x001f
            L_0x0035:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                r5 = 2
                if (r4 >= r5) goto L_0x0049
                int r10 = r1 + 1
                java.io.DataInputStream r4 = r8.din
                char r4 = r4.readChar()
                r9[r1] = r4
                r1 = r10
                goto L_0x0004
            L_0x0049:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                int r4 = r4 >> 1
                int r4 = r4 + r1
                int r3 = java.lang.Math.min((int) r0, (int) r4)
                goto L_0x001f
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.readChars(char[], int, int):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0021 A[LOOP:1: B:5:0x001f->B:6:0x0021, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void readShorts(short[] r9, int r10, int r11) throws java.io.IOException {
            /*
                r8 = this;
                r7 = 0
                int r0 = r10 + r11
                r1 = r10
            L_0x0004:
                if (r1 >= r0) goto L_0x0056
                boolean r4 = r8.blkmode
                if (r4 != 0) goto L_0x0035
                int r4 = r0 - r1
                r5 = 512(0x200, float:7.175E-43)
                int r2 = java.lang.Math.min((int) r4, (int) r5)
                java.io.ObjectInputStream$PeekInputStream r4 = r8.in
                byte[] r5 = r8.buf
                int r6 = r2 << 1
                r4.readFully(r5, r7, r6)
                int r3 = r1 + r2
                r8.pos = r7
            L_0x001f:
                if (r1 >= r3) goto L_0x0004
                int r10 = r1 + 1
                byte[] r4 = r8.buf
                int r5 = r8.pos
                short r4 = java.io.Bits.getShort(r4, r5)
                r9[r1] = r4
                int r4 = r8.pos
                int r4 = r4 + 2
                r8.pos = r4
                r1 = r10
                goto L_0x001f
            L_0x0035:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                r5 = 2
                if (r4 >= r5) goto L_0x0049
                int r10 = r1 + 1
                java.io.DataInputStream r4 = r8.din
                short r4 = r4.readShort()
                r9[r1] = r4
                r1 = r10
                goto L_0x0004
            L_0x0049:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                int r4 = r4 >> 1
                int r4 = r4 + r1
                int r3 = java.lang.Math.min((int) r0, (int) r4)
                goto L_0x001f
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.readShorts(short[], int, int):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0021 A[LOOP:1: B:5:0x001f->B:6:0x0021, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void readInts(int[] r9, int r10, int r11) throws java.io.IOException {
            /*
                r8 = this;
                r7 = 0
                int r0 = r10 + r11
                r1 = r10
            L_0x0004:
                if (r1 >= r0) goto L_0x0056
                boolean r4 = r8.blkmode
                if (r4 != 0) goto L_0x0035
                int r4 = r0 - r1
                r5 = 256(0x100, float:3.59E-43)
                int r2 = java.lang.Math.min((int) r4, (int) r5)
                java.io.ObjectInputStream$PeekInputStream r4 = r8.in
                byte[] r5 = r8.buf
                int r6 = r2 << 2
                r4.readFully(r5, r7, r6)
                int r3 = r1 + r2
                r8.pos = r7
            L_0x001f:
                if (r1 >= r3) goto L_0x0004
                int r10 = r1 + 1
                byte[] r4 = r8.buf
                int r5 = r8.pos
                int r4 = java.io.Bits.getInt(r4, r5)
                r9[r1] = r4
                int r4 = r8.pos
                int r4 = r4 + 4
                r8.pos = r4
                r1 = r10
                goto L_0x001f
            L_0x0035:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                r5 = 4
                if (r4 >= r5) goto L_0x0049
                int r10 = r1 + 1
                java.io.DataInputStream r4 = r8.din
                int r4 = r4.readInt()
                r9[r1] = r4
                r1 = r10
                goto L_0x0004
            L_0x0049:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                int r4 = r4 >> 2
                int r4 = r4 + r1
                int r3 = java.lang.Math.min((int) r0, (int) r4)
                goto L_0x001f
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.readInts(int[], int, int):void");
        }

        /* access modifiers changed from: package-private */
        public void readFloats(float[] v, int off, int len) throws IOException {
            int span;
            int endoff = off + len;
            int off2 = off;
            while (off2 < endoff) {
                if (!this.blkmode) {
                    span = Math.min(endoff - off2, 256);
                    this.in.readFully(this.buf, 0, span << 2);
                    this.pos = 0;
                } else if (this.end - this.pos < 4) {
                    v[off2] = this.din.readFloat();
                    off2++;
                } else {
                    span = Math.min(endoff - off2, (this.end - this.pos) >> 2);
                }
                ObjectInputStream.bytesToFloats(this.buf, this.pos, v, off2, span);
                this.pos += span << 2;
                off2 += span;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0021 A[LOOP:1: B:5:0x001f->B:6:0x0021, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void readLongs(long[] r9, int r10, int r11) throws java.io.IOException {
            /*
                r8 = this;
                r7 = 0
                int r0 = r10 + r11
                r1 = r10
            L_0x0004:
                if (r1 >= r0) goto L_0x0057
                boolean r4 = r8.blkmode
                if (r4 != 0) goto L_0x0035
                int r4 = r0 - r1
                r5 = 128(0x80, float:1.794E-43)
                int r2 = java.lang.Math.min((int) r4, (int) r5)
                java.io.ObjectInputStream$PeekInputStream r4 = r8.in
                byte[] r5 = r8.buf
                int r6 = r2 << 3
                r4.readFully(r5, r7, r6)
                int r3 = r1 + r2
                r8.pos = r7
            L_0x001f:
                if (r1 >= r3) goto L_0x0004
                int r10 = r1 + 1
                byte[] r4 = r8.buf
                int r5 = r8.pos
                long r4 = java.io.Bits.getLong(r4, r5)
                r9[r1] = r4
                int r4 = r8.pos
                int r4 = r4 + 8
                r8.pos = r4
                r1 = r10
                goto L_0x001f
            L_0x0035:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                r5 = 8
                if (r4 >= r5) goto L_0x004a
                int r10 = r1 + 1
                java.io.DataInputStream r4 = r8.din
                long r4 = r4.readLong()
                r9[r1] = r4
                r1 = r10
                goto L_0x0004
            L_0x004a:
                int r4 = r8.end
                int r5 = r8.pos
                int r4 = r4 - r5
                int r4 = r4 >> 3
                int r4 = r4 + r1
                int r3 = java.lang.Math.min((int) r0, (int) r4)
                goto L_0x001f
            L_0x0057:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.readLongs(long[], int, int):void");
        }

        /* access modifiers changed from: package-private */
        public void readDoubles(double[] v, int off, int len) throws IOException {
            int span;
            int endoff = off + len;
            int off2 = off;
            while (off2 < endoff) {
                if (!this.blkmode) {
                    span = Math.min(endoff - off2, 128);
                    this.in.readFully(this.buf, 0, span << 3);
                    this.pos = 0;
                } else if (this.end - this.pos < 8) {
                    v[off2] = this.din.readDouble();
                    off2++;
                } else {
                    span = Math.min(endoff - off2, (this.end - this.pos) >> 3);
                }
                ObjectInputStream.bytesToDoubles(this.buf, this.pos, v, off2, span);
                this.pos += span << 3;
                off2 += span;
            }
        }

        /* access modifiers changed from: package-private */
        public String readLongUTF() throws IOException {
            return readUTFBody(readLong());
        }

        private String readUTFBody(long utflen) throws IOException {
            StringBuilder sbuf = new StringBuilder();
            if (!this.blkmode) {
                this.pos = 0;
                this.end = 0;
            }
            while (utflen > 0) {
                int avail = this.end - this.pos;
                if (avail >= 3 || ((long) avail) == utflen) {
                    utflen -= readUTFSpan(sbuf, utflen);
                } else if (this.blkmode) {
                    utflen -= (long) readUTFChar(sbuf, utflen);
                } else {
                    if (avail > 0) {
                        System.arraycopy(this.buf, this.pos, this.buf, 0, avail);
                    }
                    this.pos = 0;
                    this.end = (int) Math.min(1024, utflen);
                    this.in.readFully(this.buf, avail, this.end - avail);
                }
            }
            return sbuf.toString();
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x013a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long readUTFSpan(java.lang.StringBuilder r17, long r18) throws java.io.IOException {
            /*
                r16 = this;
                r6 = 0
                r0 = r16
                int r10 = r0.pos
                r0 = r16
                int r12 = r0.end
                r0 = r16
                int r13 = r0.pos
                int r12 = r12 - r13
                r13 = 256(0x100, float:3.59E-43)
                int r2 = java.lang.Math.min((int) r12, (int) r13)
                r0 = r16
                int r13 = r0.pos
                long r14 = (long) r2
                int r12 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
                if (r12 <= 0) goto L_0x0063
                int r12 = r2 + -2
            L_0x001f:
                int r11 = r13 + r12
                r9 = 0
                r7 = r6
            L_0x0023:
                r0 = r16
                int r12 = r0.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                if (r12 >= r11) goto L_0x010e
                r0 = r16
                byte[] r12 = r0.buf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r0 = r16
                int r13 = r0.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r14 = r13 + 1
                r0 = r16
                r0.pos = r14     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                byte r12 = r12[r13]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r3 = r12 & 255(0xff, float:3.57E-43)
                int r12 = r3 >> 4
                switch(r12) {
                    case 0: goto L_0x0067;
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0067;
                    case 3: goto L_0x0067;
                    case 4: goto L_0x0067;
                    case 5: goto L_0x0067;
                    case 6: goto L_0x0067;
                    case 7: goto L_0x0067;
                    case 8: goto L_0x0040;
                    case 9: goto L_0x0040;
                    case 10: goto L_0x0040;
                    case 11: goto L_0x0040;
                    case 12: goto L_0x0072;
                    case 13: goto L_0x0072;
                    case 14: goto L_0x00bf;
                    default: goto L_0x0040;
                }     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
            L_0x0040:
                java.io.UTFDataFormatException r12 = new java.io.UTFDataFormatException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r12.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                throw r12     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
            L_0x0046:
                r8 = move-exception
                r6 = r7
            L_0x0048:
                r9 = 1
                if (r9 != 0) goto L_0x0055
                r0 = r16
                int r12 = r0.pos
                int r12 = r12 - r10
                long r12 = (long) r12
                int r12 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
                if (r12 <= 0) goto L_0x0129
            L_0x0055:
                r0 = r18
                int r12 = (int) r0
                int r12 = r12 + r10
                r0 = r16
                r0.pos = r12
                java.io.UTFDataFormatException r12 = new java.io.UTFDataFormatException
                r12.<init>()
                throw r12
            L_0x0063:
                r0 = r18
                int r12 = (int) r0
                goto L_0x001f
            L_0x0067:
                r0 = r16
                char[] r12 = r0.cbuf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r6 = r7 + 1
                char r13 = (char) r3
                r12[r7] = r13     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00bd, all -> 0x010c }
            L_0x0070:
                r7 = r6
                goto L_0x0023
            L_0x0072:
                r0 = r16
                byte[] r12 = r0.buf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r0 = r16
                int r13 = r0.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r14 = r13 + 1
                r0 = r16
                r0.pos = r14     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                byte r4 = r12[r13]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r12 = r4 & 192(0xc0, float:2.69E-43)
                r13 = 128(0x80, float:1.794E-43)
                if (r12 == r13) goto L_0x00aa
                java.io.UTFDataFormatException r12 = new java.io.UTFDataFormatException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r12.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                throw r12     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
            L_0x008e:
                r12 = move-exception
                r6 = r7
            L_0x0090:
                if (r9 != 0) goto L_0x009c
                r0 = r16
                int r13 = r0.pos
                int r13 = r13 - r10
                long r14 = (long) r13
                int r13 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
                if (r13 <= 0) goto L_0x013a
            L_0x009c:
                r0 = r18
                int r12 = (int) r0
                int r12 = r12 + r10
                r0 = r16
                r0.pos = r12
                java.io.UTFDataFormatException r12 = new java.io.UTFDataFormatException
                r12.<init>()
                throw r12
            L_0x00aa:
                r0 = r16
                char[] r12 = r0.cbuf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r6 = r7 + 1
                r13 = r3 & 31
                int r13 = r13 << 6
                r14 = r4 & 63
                int r14 = r14 << 0
                r13 = r13 | r14
                char r13 = (char) r13
                r12[r7] = r13     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00bd, all -> 0x010c }
                goto L_0x0070
            L_0x00bd:
                r8 = move-exception
                goto L_0x0048
            L_0x00bf:
                r0 = r16
                byte[] r12 = r0.buf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r0 = r16
                int r13 = r0.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r13 = r13 + 1
                byte r5 = r12[r13]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r0 = r16
                byte[] r12 = r0.buf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r0 = r16
                int r13 = r0.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r13 = r13 + 0
                byte r4 = r12[r13]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r0 = r16
                int r12 = r0.pos     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r12 = r12 + 2
                r0 = r16
                r0.pos = r12     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r12 = r4 & 192(0xc0, float:2.69E-43)
                r13 = 128(0x80, float:1.794E-43)
                if (r12 != r13) goto L_0x00ed
                r12 = r5 & 192(0xc0, float:2.69E-43)
                r13 = 128(0x80, float:1.794E-43)
                if (r12 == r13) goto L_0x00f3
            L_0x00ed:
                java.io.UTFDataFormatException r12 = new java.io.UTFDataFormatException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                r12.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                throw r12     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
            L_0x00f3:
                r0 = r16
                char[] r12 = r0.cbuf     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0046, all -> 0x008e }
                int r6 = r7 + 1
                r13 = r3 & 15
                int r13 = r13 << 12
                r14 = r4 & 63
                int r14 = r14 << 6
                r13 = r13 | r14
                r14 = r5 & 63
                int r14 = r14 << 0
                r13 = r13 | r14
                char r13 = (char) r13
                r12[r7] = r13     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00bd, all -> 0x010c }
                goto L_0x0070
            L_0x010c:
                r12 = move-exception
                goto L_0x0090
            L_0x010e:
                if (r9 != 0) goto L_0x011a
                r0 = r16
                int r12 = r0.pos
                int r12 = r12 - r10
                long r12 = (long) r12
                int r12 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
                if (r12 <= 0) goto L_0x0128
            L_0x011a:
                r0 = r18
                int r12 = (int) r0
                int r12 = r12 + r10
                r0 = r16
                r0.pos = r12
                java.io.UTFDataFormatException r12 = new java.io.UTFDataFormatException
                r12.<init>()
                throw r12
            L_0x0128:
                r6 = r7
            L_0x0129:
                r0 = r16
                char[] r12 = r0.cbuf
                r13 = 0
                r0 = r17
                r0.append((char[]) r12, (int) r13, (int) r6)
                r0 = r16
                int r12 = r0.pos
                int r12 = r12 - r10
                long r12 = (long) r12
                return r12
            L_0x013a:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectInputStream.BlockDataInputStream.readUTFSpan(java.lang.StringBuilder, long):long");
        }

        private int readUTFChar(StringBuilder sbuf, long utflen) throws IOException {
            int b1 = readByte() & 255;
            switch (b1 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    sbuf.append((char) b1);
                    return 1;
                case 12:
                case 13:
                    if (utflen < 2) {
                        throw new UTFDataFormatException();
                    }
                    int b2 = readByte();
                    if ((b2 & 192) != 128) {
                        throw new UTFDataFormatException();
                    }
                    sbuf.append((char) (((b1 & 31) << 6) | ((b2 & 63) << 0)));
                    return 2;
                case 14:
                    if (utflen < 3) {
                        if (utflen == 2) {
                            readByte();
                        }
                        throw new UTFDataFormatException();
                    }
                    int b22 = readByte();
                    int b3 = readByte();
                    if ((b22 & 192) == 128 && (b3 & 192) == 128) {
                        sbuf.append((char) (((b1 & 15) << 12) | ((b22 & 63) << 6) | ((b3 & 63) << 0)));
                        return 3;
                    }
                    throw new UTFDataFormatException();
                default:
                    throw new UTFDataFormatException();
            }
        }
    }

    private static class HandleTable {
        private static final byte STATUS_EXCEPTION = 3;
        private static final byte STATUS_OK = 1;
        private static final byte STATUS_UNKNOWN = 2;
        HandleList[] deps;
        Object[] entries;
        int lowDep;
        int size;
        byte[] status;

        HandleTable(int initialCapacity) {
            this.lowDep = -1;
            this.size = 0;
            this.status = new byte[initialCapacity];
            this.entries = new Object[initialCapacity];
            this.deps = new HandleList[initialCapacity];
        }

        /* access modifiers changed from: package-private */
        public int assign(Object obj) {
            if (this.size >= this.entries.length) {
                grow();
            }
            this.status[this.size] = 2;
            this.entries[this.size] = obj;
            int i = this.size;
            this.size = i + 1;
            return i;
        }

        /* access modifiers changed from: package-private */
        public void markDependency(int dependent, int target) {
            if (dependent != -1 && target != -1) {
                switch (this.status[dependent]) {
                    case 2:
                        switch (this.status[target]) {
                            case 1:
                                return;
                            case 2:
                                if (this.deps[target] == null) {
                                    this.deps[target] = new HandleList();
                                }
                                this.deps[target].add(dependent);
                                if (this.lowDep < 0 || this.lowDep > target) {
                                    this.lowDep = target;
                                    return;
                                }
                                return;
                            case 3:
                                markException(dependent, (ClassNotFoundException) this.entries[target]);
                                return;
                            default:
                                throw new InternalError();
                        }
                    case 3:
                        return;
                    default:
                        throw new InternalError();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void markException(int handle, ClassNotFoundException ex) {
            switch (this.status[handle]) {
                case 2:
                    this.status[handle] = 3;
                    this.entries[handle] = ex;
                    HandleList dlist = this.deps[handle];
                    if (dlist != null) {
                        int ndeps = dlist.size();
                        for (int i = 0; i < ndeps; i++) {
                            markException(dlist.get(i), ex);
                        }
                        this.deps[handle] = null;
                        return;
                    }
                    return;
                case 3:
                    return;
                default:
                    throw new InternalError();
            }
        }

        /* access modifiers changed from: package-private */
        public void finish(int handle) {
            int end;
            if (this.lowDep < 0) {
                end = handle + 1;
            } else if (this.lowDep >= handle) {
                end = this.size;
                this.lowDep = -1;
            } else {
                return;
            }
            for (int i = handle; i < end; i++) {
                switch (this.status[i]) {
                    case 1:
                    case 3:
                        break;
                    case 2:
                        this.status[i] = 1;
                        this.deps[i] = null;
                        break;
                    default:
                        throw new InternalError();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setObject(int handle, Object obj) {
            switch (this.status[handle]) {
                case 1:
                case 2:
                    this.entries[handle] = obj;
                    return;
                case 3:
                    return;
                default:
                    throw new InternalError();
            }
        }

        /* access modifiers changed from: package-private */
        public Object lookupObject(int handle) {
            if (handle == -1 || this.status[handle] == 3) {
                return null;
            }
            return this.entries[handle];
        }

        /* access modifiers changed from: package-private */
        public ClassNotFoundException lookupException(int handle) {
            if (handle == -1 || this.status[handle] != 3) {
                return null;
            }
            return (ClassNotFoundException) this.entries[handle];
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            Arrays.fill(this.status, 0, this.size, (byte) 0);
            Arrays.fill(this.entries, 0, this.size, (Object) null);
            Arrays.fill((Object[]) this.deps, 0, this.size, (Object) null);
            this.lowDep = -1;
            this.size = 0;
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.size;
        }

        private void grow() {
            int newCapacity = (this.entries.length << 1) + 1;
            byte[] newStatus = new byte[newCapacity];
            Object[] newEntries = new Object[newCapacity];
            HandleList[] newDeps = new HandleList[newCapacity];
            System.arraycopy(this.status, 0, newStatus, 0, this.size);
            System.arraycopy((Object) this.entries, 0, (Object) newEntries, 0, this.size);
            System.arraycopy((Object) this.deps, 0, (Object) newDeps, 0, this.size);
            this.status = newStatus;
            this.entries = newEntries;
            this.deps = newDeps;
        }

        private static class HandleList {
            private int[] list;
            private int size;

            public HandleList() {
                this.list = new int[4];
                this.size = 0;
            }

            public void add(int handle) {
                if (this.size >= this.list.length) {
                    int[] newList = new int[(this.list.length << 1)];
                    System.arraycopy(this.list, 0, newList, 0, this.list.length);
                    this.list = newList;
                }
                int[] iArr = this.list;
                int i = this.size;
                this.size = i + 1;
                iArr[i] = handle;
            }

            public int get(int index) {
                if (index < this.size) {
                    return this.list[index];
                }
                throw new ArrayIndexOutOfBoundsException();
            }

            public int size() {
                return this.size;
            }
        }
    }

    private static Object cloneArray(Object array) {
        if (array instanceof Object[]) {
            return ((Object[]) array).clone();
        }
        if (array instanceof boolean[]) {
            return ((boolean[]) array).clone();
        }
        if (array instanceof byte[]) {
            return ((byte[]) array).clone();
        }
        if (array instanceof char[]) {
            return ((char[]) array).clone();
        }
        if (array instanceof double[]) {
            return ((double[]) array).clone();
        }
        if (array instanceof float[]) {
            return ((float[]) array).clone();
        }
        if (array instanceof int[]) {
            return ((int[]) array).clone();
        }
        if (array instanceof long[]) {
            return ((long[]) array).clone();
        }
        if (array instanceof short[]) {
            return ((short[]) array).clone();
        }
        throw new AssertionError();
    }
}
