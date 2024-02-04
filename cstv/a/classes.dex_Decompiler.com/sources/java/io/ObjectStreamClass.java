package java.io;

import dalvik.system.VMRuntime;
import dalvik.system.VMStack;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import sun.misc.Unsafe;
import sun.reflect.CallerSensitive;
import sun.reflect.misc.ReflectUtil;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class ObjectStreamClass implements Serializable {
    static final int MAX_SDK_TARGET_FOR_CLINIT_UIDGEN_WORKAROUND = 23;
    public static final ObjectStreamField[] NO_FIELDS = null;
    private static final ObjectStreamField[] serialPersistentFields = null;
    private static final long serialVersionUID = -6120832682080437368L;
    /* access modifiers changed from: private */
    public Class<?> cl;
    /* access modifiers changed from: private */
    public Constructor cons;
    private volatile ClassDataSlot[] dataLayout;
    private ExceptionInfo defaultSerializeEx;
    /* access modifiers changed from: private */
    public ExceptionInfo deserializeEx;
    /* access modifiers changed from: private */
    public boolean externalizable;
    private FieldReflector fieldRefl;
    /* access modifiers changed from: private */
    public ObjectStreamField[] fields;
    private boolean hasBlockExternalData;
    /* access modifiers changed from: private */
    public boolean hasWriteObjectData;
    /* access modifiers changed from: private */
    public boolean isEnum;
    private boolean isProxy;
    private ObjectStreamClass localDesc;
    private String name;
    private int numObjFields;
    private int primDataSize;
    /* access modifiers changed from: private */
    public Method readObjectMethod;
    /* access modifiers changed from: private */
    public Method readObjectNoDataMethod;
    /* access modifiers changed from: private */
    public Method readResolveMethod;
    private ClassNotFoundException resolveEx;
    private boolean serializable;
    /* access modifiers changed from: private */
    public ExceptionInfo serializeEx;
    /* access modifiers changed from: private */
    public volatile Long suid;
    private ObjectStreamClass superDesc;
    /* access modifiers changed from: private */
    public Method writeObjectMethod;
    /* access modifiers changed from: private */
    public Method writeReplaceMethod;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.ObjectStreamClass.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.ObjectStreamClass.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.<clinit>():void");
    }

    private static native boolean hasStaticInitializer(Class<?> cls, boolean z);

    private static class Caches {
        static final ConcurrentMap<WeakClassKey, Reference<?>> localDescs = null;
        /* access modifiers changed from: private */
        public static final ReferenceQueue<Class<?>> localDescsQueue = null;
        static final ConcurrentMap<FieldReflectorKey, Reference<?>> reflectors = null;
        /* access modifiers changed from: private */
        public static final ReferenceQueue<Class<?>> reflectorsQueue = null;

        private Caches() {
        }
    }

    private static class ExceptionInfo {
        private final String className;
        private final String message;

        ExceptionInfo(String cn, String msg) {
            this.className = cn;
            this.message = msg;
        }

        /* access modifiers changed from: package-private */
        public InvalidClassException newInvalidClassException() {
            return new InvalidClassException(this.className, this.message);
        }
    }

    public static ObjectStreamClass lookup(Class<?> cl2) {
        return lookup(cl2, false);
    }

    public static ObjectStreamClass lookupAny(Class<?> cl2) {
        return lookup(cl2, true);
    }

    public String getName() {
        return this.name;
    }

    public long getSerialVersionUID() {
        if (this.suid == null) {
            this.suid = (Long) AccessController.doPrivileged(new PrivilegedAction<Long>() {
                public Long run() {
                    return Long.valueOf(ObjectStreamClass.computeDefaultSUID(ObjectStreamClass.this.cl));
                }
            });
        }
        return this.suid.longValue();
    }

    @CallerSensitive
    public Class<?> forClass() {
        if (this.cl == null) {
            return null;
        }
        if (System.getSecurityManager() != null && ReflectUtil.needsPackageAccessCheck(VMStack.getCallingClassLoader(), this.cl.getClassLoader())) {
            ReflectUtil.checkPackageAccess(this.cl);
        }
        return this.cl;
    }

    public ObjectStreamField[] getFields() {
        return getFields(true);
    }

    public ObjectStreamField getField(String name2) {
        return getField(name2, (Class<?>) null);
    }

    public String toString() {
        return this.name + ": static final long serialVersionUID = " + getSerialVersionUID() + "L;";
    }

    static ObjectStreamClass lookup(Class<?> cl2, boolean all) {
        Object entry;
        if (!(!all ? Serializable.class.isAssignableFrom(cl2) : true)) {
            return null;
        }
        processQueue(Caches.localDescsQueue, Caches.localDescs);
        WeakClassKey key = new WeakClassKey(cl2, Caches.localDescsQueue);
        Reference<?> ref = (Reference) Caches.localDescs.get(key);
        Object entry2 = null;
        if (ref != null) {
            entry2 = ref.get();
        }
        EntryFuture future = null;
        if (entry2 == null) {
            EntryFuture newEntry = new EntryFuture((EntryFuture) null);
            Reference<?> newRef = new SoftReference<>(newEntry);
            do {
                if (ref != null) {
                    Caches.localDescs.remove(key, ref);
                }
                ref = Caches.localDescs.putIfAbsent(key, newRef);
                if (ref != null) {
                    entry2 = ref.get();
                }
                if (ref == null) {
                    break;
                }
            } while (entry2 == null);
            if (entry2 == null) {
                future = newEntry;
            }
        }
        if (entry2 instanceof ObjectStreamClass) {
            return (ObjectStreamClass) entry2;
        }
        if (entry2 instanceof EntryFuture) {
            future = (EntryFuture) entry2;
            if (future.getOwner() == Thread.currentThread()) {
                entry2 = null;
            } else {
                entry2 = future.get();
            }
        }
        if (entry == null) {
            try {
                entry = new ObjectStreamClass(cl2);
            } catch (Throwable th) {
                entry = th;
            }
            if (future.set(entry)) {
                Caches.localDescs.put(key, new SoftReference(entry));
            } else {
                entry = future.get();
            }
        }
        if (entry instanceof ObjectStreamClass) {
            return (ObjectStreamClass) entry;
        }
        if (entry instanceof RuntimeException) {
            throw ((RuntimeException) entry);
        } else if (entry instanceof Error) {
            throw ((Error) entry);
        } else {
            throw new InternalError("unexpected entry: " + entry);
        }
    }

    private static class EntryFuture {
        private static final Object unset = null;
        private Object entry;
        private final Thread owner;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.ObjectStreamClass.EntryFuture.<clinit>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.ObjectStreamClass.EntryFuture.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.EntryFuture.<clinit>():void");
        }

        /* synthetic */ EntryFuture(EntryFuture entryFuture) {
            this();
        }

        private EntryFuture() {
            this.owner = Thread.currentThread();
            this.entry = unset;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean set(Object entry2) {
            if (this.entry != unset) {
                return false;
            }
            this.entry = entry2;
            notifyAll();
            return true;
        }

        /* access modifiers changed from: package-private */
        public synchronized Object get() {
            boolean interrupted = false;
            while (this.entry == unset) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
            if (interrupted) {
                AccessController.doPrivileged(new PrivilegedAction<Void>(this) {
                    final /* synthetic */ EntryFuture this$1;

                    /*  JADX ERROR: Method load error
                        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectStreamClass.EntryFuture.1.run():java.lang.Object, dex: classes.dex
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
                        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectStreamClass.EntryFuture.1.run():java.lang.Object, dex: classes.dex
                        */
                        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.EntryFuture.AnonymousClass1.run():java.lang.Object");
                    }

                    /*  JADX ERROR: Method load error
                        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectStreamClass.EntryFuture.1.run():java.lang.Void, dex: classes.dex
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
                    public java.lang.Void run() {
                        /*
                        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.io.ObjectStreamClass.EntryFuture.1.run():java.lang.Void, dex: classes.dex
                        */
                        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.EntryFuture.AnonymousClass1.run():java.lang.Void");
                    }
                });
            }
            return this.entry;
        }

        /* access modifiers changed from: package-private */
        public Thread getOwner() {
            return this.owner;
        }
    }

    private ObjectStreamClass(final Class<?> cl2) {
        ObjectStreamClass objectStreamClass = null;
        this.hasBlockExternalData = true;
        this.cl = cl2;
        this.name = cl2.getName();
        this.isProxy = Proxy.isProxyClass(cl2);
        this.isEnum = Enum.class.isAssignableFrom(cl2);
        this.serializable = Serializable.class.isAssignableFrom(cl2);
        this.externalizable = Externalizable.class.isAssignableFrom(cl2);
        Class<? super Object> superclass = cl2.getSuperclass();
        this.superDesc = superclass != null ? lookup(superclass, false) : objectStreamClass;
        this.localDesc = this;
        if (this.serializable) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    boolean z = true;
                    if (ObjectStreamClass.this.isEnum) {
                        Long unused = ObjectStreamClass.this.suid = 0L;
                        ObjectStreamField[] unused2 = ObjectStreamClass.this.fields = ObjectStreamClass.NO_FIELDS;
                        return null;
                    } else if (cl2.isArray()) {
                        ObjectStreamField[] unused3 = ObjectStreamClass.this.fields = ObjectStreamClass.NO_FIELDS;
                        return null;
                    } else {
                        Long unused4 = ObjectStreamClass.this.suid = ObjectStreamClass.getDeclaredSUID(cl2);
                        try {
                            ObjectStreamField[] unused5 = ObjectStreamClass.this.fields = ObjectStreamClass.getSerialFields(cl2);
                            ObjectStreamClass.this.computeFieldOffsets();
                        } catch (InvalidClassException e) {
                            ExceptionInfo unused6 = ObjectStreamClass.this.serializeEx = ObjectStreamClass.this.deserializeEx = new ExceptionInfo(e.classname, e.getMessage());
                            ObjectStreamField[] unused7 = ObjectStreamClass.this.fields = ObjectStreamClass.NO_FIELDS;
                        }
                        if (ObjectStreamClass.this.externalizable) {
                            Constructor unused8 = ObjectStreamClass.this.cons = ObjectStreamClass.getExternalizableConstructor(cl2);
                        } else {
                            Constructor unused9 = ObjectStreamClass.this.cons = ObjectStreamClass.getSerializableConstructor(cl2);
                            Method unused10 = ObjectStreamClass.this.writeObjectMethod = ObjectStreamClass.getPrivateMethod(cl2, "writeObject", new Class[]{ObjectOutputStream.class}, Void.TYPE);
                            Method unused11 = ObjectStreamClass.this.readObjectMethod = ObjectStreamClass.getPrivateMethod(cl2, "readObject", new Class[]{ObjectInputStream.class}, Void.TYPE);
                            Method unused12 = ObjectStreamClass.this.readObjectNoDataMethod = ObjectStreamClass.getPrivateMethod(cl2, "readObjectNoData", (Class<?>[]) null, Void.TYPE);
                            ObjectStreamClass objectStreamClass = ObjectStreamClass.this;
                            if (ObjectStreamClass.this.writeObjectMethod == null) {
                                z = false;
                            }
                            boolean unused13 = objectStreamClass.hasWriteObjectData = z;
                        }
                        Method unused14 = ObjectStreamClass.this.writeReplaceMethod = ObjectStreamClass.getInheritableMethod(cl2, "writeReplace", (Class<?>[]) null, Object.class);
                        Method unused15 = ObjectStreamClass.this.readResolveMethod = ObjectStreamClass.getInheritableMethod(cl2, "readResolve", (Class<?>[]) null, Object.class);
                        return null;
                    }
                }
            });
        } else {
            this.suid = 0L;
            this.fields = NO_FIELDS;
        }
        try {
            this.fieldRefl = getReflector(this.fields, this);
            if (this.deserializeEx == null) {
                if (this.isEnum) {
                    this.deserializeEx = new ExceptionInfo(this.name, "enum type");
                } else if (this.cons == null) {
                    this.deserializeEx = new ExceptionInfo(this.name, "no valid constructor");
                }
            }
            for (ObjectStreamField field : this.fields) {
                if (field.getField() == null) {
                    this.defaultSerializeEx = new ExceptionInfo(this.name, "unmatched serializable field(s) declared");
                }
            }
        } catch (InvalidClassException e) {
            throw new InternalError();
        }
    }

    ObjectStreamClass() {
        this.hasBlockExternalData = true;
    }

    /* access modifiers changed from: package-private */
    public void initProxy(Class<?> cl2, ClassNotFoundException resolveEx2, ObjectStreamClass superDesc2) throws InvalidClassException {
        this.cl = cl2;
        this.resolveEx = resolveEx2;
        this.superDesc = superDesc2;
        this.isProxy = true;
        this.serializable = true;
        this.suid = 0L;
        this.fields = NO_FIELDS;
        if (cl2 != null) {
            this.localDesc = lookup(cl2, true);
            if (!this.localDesc.isProxy) {
                throw new InvalidClassException("cannot bind proxy descriptor to a non-proxy class");
            }
            this.name = this.localDesc.name;
            this.externalizable = this.localDesc.externalizable;
            this.cons = this.localDesc.cons;
            this.writeReplaceMethod = this.localDesc.writeReplaceMethod;
            this.readResolveMethod = this.localDesc.readResolveMethod;
            this.deserializeEx = this.localDesc.deserializeEx;
        }
        this.fieldRefl = getReflector(this.fields, this.localDesc);
    }

    /* access modifiers changed from: package-private */
    public void initNonProxy(ObjectStreamClass model, Class<?> cl2, ClassNotFoundException resolveEx2, ObjectStreamClass superDesc2) throws InvalidClassException {
        String str;
        this.cl = cl2;
        this.resolveEx = resolveEx2;
        this.superDesc = superDesc2;
        this.name = model.name;
        this.suid = Long.valueOf(model.getSerialVersionUID());
        this.isProxy = false;
        this.isEnum = model.isEnum;
        this.serializable = model.serializable;
        this.externalizable = model.externalizable;
        this.hasBlockExternalData = model.hasBlockExternalData;
        this.hasWriteObjectData = model.hasWriteObjectData;
        this.fields = model.fields;
        this.primDataSize = model.primDataSize;
        this.numObjFields = model.numObjFields;
        if (cl2 != null) {
            this.localDesc = lookup(cl2, true);
            if (this.localDesc.isProxy) {
                throw new InvalidClassException("cannot bind non-proxy descriptor to a proxy class");
            } else if (this.isEnum != this.localDesc.isEnum) {
                if (this.isEnum) {
                    str = "cannot bind enum descriptor to a non-enum class";
                } else {
                    str = "cannot bind non-enum descriptor to an enum class";
                }
                throw new InvalidClassException(str);
            } else if (this.serializable == this.localDesc.serializable && !cl2.isArray() && this.suid.longValue() != this.localDesc.getSerialVersionUID()) {
                throw new InvalidClassException(this.localDesc.name, "local class incompatible: stream classdesc serialVersionUID = " + this.suid + ", local class serialVersionUID = " + this.localDesc.getSerialVersionUID());
            } else if (!classNamesEqual(this.name, this.localDesc.name)) {
                throw new InvalidClassException(this.localDesc.name, "local class name incompatible with stream class name \"" + this.name + "\"");
            } else {
                if (!this.isEnum) {
                    if (this.serializable == this.localDesc.serializable && this.externalizable != this.localDesc.externalizable) {
                        throw new InvalidClassException(this.localDesc.name, "Serializable incompatible with Externalizable");
                    } else if (!(this.serializable == this.localDesc.serializable && this.externalizable == this.localDesc.externalizable && (this.serializable || this.externalizable))) {
                        this.deserializeEx = new ExceptionInfo(this.localDesc.name, "class invalid for deserialization");
                    }
                }
                this.cons = this.localDesc.cons;
                this.writeObjectMethod = this.localDesc.writeObjectMethod;
                this.readObjectMethod = this.localDesc.readObjectMethod;
                this.readObjectNoDataMethod = this.localDesc.readObjectNoDataMethod;
                this.writeReplaceMethod = this.localDesc.writeReplaceMethod;
                this.readResolveMethod = this.localDesc.readResolveMethod;
                if (this.deserializeEx == null) {
                    this.deserializeEx = this.localDesc.deserializeEx;
                }
            }
        }
        this.fieldRefl = getReflector(this.fields, this.localDesc);
        this.fields = this.fieldRefl.getFields();
    }

    /* access modifiers changed from: package-private */
    public void readNonProxy(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.suid = Long.valueOf(in.readLong());
        this.isProxy = false;
        byte flags = in.readByte();
        this.hasWriteObjectData = (flags & 1) != 0;
        this.hasBlockExternalData = (flags & 8) != 0;
        this.externalizable = (flags & 4) != 0;
        boolean sflag = (flags & 2) != 0;
        if (!this.externalizable || !sflag) {
            if (this.externalizable) {
                sflag = true;
            }
            this.serializable = sflag;
            this.isEnum = (flags & 16) != 0;
            if (!this.isEnum || this.suid.longValue() == 0) {
                int numFields = in.readShort();
                if (!this.isEnum || numFields == 0) {
                    this.fields = numFields > 0 ? new ObjectStreamField[numFields] : NO_FIELDS;
                    int i = 0;
                    while (i < numFields) {
                        char tcode = (char) in.readByte();
                        String fname = in.readUTF();
                        try {
                            this.fields[i] = new ObjectStreamField(fname, (tcode == 'L' || tcode == '[') ? in.readTypeString() : new String(new char[]{tcode}), false);
                            i++;
                        } catch (RuntimeException e) {
                            throw ((IOException) new InvalidClassException(this.name, "invalid descriptor for field " + fname).initCause(e));
                        }
                    }
                    computeFieldOffsets();
                    return;
                }
                throw new InvalidClassException(this.name, "enum descriptor has non-zero field count: " + numFields);
            }
            throw new InvalidClassException(this.name, "enum descriptor has non-zero serialVersionUID: " + this.suid);
        }
        throw new InvalidClassException(this.name, "serializable and externalizable flags conflict");
    }

    /* access modifiers changed from: package-private */
    public void writeNonProxy(ObjectOutputStream out) throws IOException {
        out.writeUTF(this.name);
        out.writeLong(getSerialVersionUID());
        byte flags = 0;
        if (this.externalizable) {
            flags = (byte) 4;
            if (out.getProtocolVersion() != 1) {
                flags = (byte) (flags | 8);
            }
        } else if (this.serializable) {
            flags = (byte) 2;
        }
        if (this.hasWriteObjectData) {
            flags = (byte) (flags | 1);
        }
        if (this.isEnum) {
            flags = (byte) (flags | 16);
        }
        out.writeByte(flags);
        out.writeShort(this.fields.length);
        for (ObjectStreamField f : this.fields) {
            out.writeByte(f.getTypeCode());
            out.writeUTF(f.getName());
            if (!f.isPrimitive()) {
                out.writeTypeString(f.getTypeString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ClassNotFoundException getResolveException() {
        return this.resolveEx;
    }

    /* access modifiers changed from: package-private */
    public void checkDeserialize() throws InvalidClassException {
        if (this.deserializeEx != null) {
            throw this.deserializeEx.newInvalidClassException();
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSerialize() throws InvalidClassException {
        if (this.serializeEx != null) {
            throw this.serializeEx.newInvalidClassException();
        }
    }

    /* access modifiers changed from: package-private */
    public void checkDefaultSerialize() throws InvalidClassException {
        if (this.defaultSerializeEx != null) {
            throw this.defaultSerializeEx.newInvalidClassException();
        }
    }

    /* access modifiers changed from: package-private */
    public ObjectStreamClass getSuperDesc() {
        return this.superDesc;
    }

    /* access modifiers changed from: package-private */
    public ObjectStreamClass getLocalDesc() {
        return this.localDesc;
    }

    /* access modifiers changed from: package-private */
    public ObjectStreamField[] getFields(boolean copy) {
        return copy ? (ObjectStreamField[]) this.fields.clone() : this.fields;
    }

    /* access modifiers changed from: package-private */
    public ObjectStreamField getField(String name2, Class<?> type) {
        for (ObjectStreamField f : this.fields) {
            if (f.getName().equals(name2)) {
                if (type == null || (type == Object.class && !f.isPrimitive())) {
                    return f;
                }
                Class<?> ftype = f.getType();
                if (ftype != null && type.isAssignableFrom(ftype)) {
                    return f;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isProxy() {
        return this.isProxy;
    }

    /* access modifiers changed from: package-private */
    public boolean isEnum() {
        return this.isEnum;
    }

    /* access modifiers changed from: package-private */
    public boolean isExternalizable() {
        return this.externalizable;
    }

    /* access modifiers changed from: package-private */
    public boolean isSerializable() {
        return this.serializable;
    }

    /* access modifiers changed from: package-private */
    public boolean hasBlockExternalData() {
        return this.hasBlockExternalData;
    }

    /* access modifiers changed from: package-private */
    public boolean hasWriteObjectData() {
        return this.hasWriteObjectData;
    }

    /* access modifiers changed from: package-private */
    public boolean isInstantiable() {
        return this.cons != null;
    }

    /* access modifiers changed from: package-private */
    public boolean hasWriteObjectMethod() {
        return this.writeObjectMethod != null;
    }

    /* access modifiers changed from: package-private */
    public boolean hasReadObjectMethod() {
        return this.readObjectMethod != null;
    }

    /* access modifiers changed from: package-private */
    public boolean hasReadObjectNoDataMethod() {
        return this.readObjectNoDataMethod != null;
    }

    /* access modifiers changed from: package-private */
    public boolean hasWriteReplaceMethod() {
        return this.writeReplaceMethod != null;
    }

    /* access modifiers changed from: package-private */
    public boolean hasReadResolveMethod() {
        return this.readResolveMethod != null;
    }

    /* access modifiers changed from: package-private */
    public Object newInstance() throws InstantiationException, InvocationTargetException, UnsupportedOperationException {
        if (this.cons != null) {
            try {
                return this.cons.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throw new InternalError();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    public void invokeWriteObject(Object obj, ObjectOutputStream out) throws IOException, UnsupportedOperationException {
        if (this.writeObjectMethod != null) {
            try {
                this.writeObjectMethod.invoke(obj, out);
            } catch (InvocationTargetException ex) {
                Throwable th = ex.getTargetException();
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throwMiscException(th);
            } catch (IllegalAccessException e) {
                throw new InternalError();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    public void invokeReadObject(Object obj, ObjectInputStream in) throws ClassNotFoundException, IOException, UnsupportedOperationException {
        if (this.readObjectMethod != null) {
            try {
                this.readObjectMethod.invoke(obj, in);
            } catch (InvocationTargetException ex) {
                Throwable th = ex.getTargetException();
                if (th instanceof ClassNotFoundException) {
                    throw ((ClassNotFoundException) th);
                } else if (th instanceof IOException) {
                    throw ((IOException) th);
                } else {
                    throwMiscException(th);
                }
            } catch (IllegalAccessException e) {
                throw new InternalError();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    public void invokeReadObjectNoData(Object obj) throws IOException, UnsupportedOperationException {
        if (this.readObjectNoDataMethod != null) {
            try {
                this.readObjectNoDataMethod.invoke(obj, (Object[]) null);
            } catch (InvocationTargetException ex) {
                Throwable th = ex.getTargetException();
                if (th instanceof ObjectStreamException) {
                    throw ((ObjectStreamException) th);
                }
                throwMiscException(th);
            } catch (IllegalAccessException e) {
                throw new InternalError();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    public Object invokeWriteReplace(Object obj) throws IOException, UnsupportedOperationException {
        if (this.writeReplaceMethod != null) {
            try {
                return this.writeReplaceMethod.invoke(obj, (Object[]) null);
            } catch (InvocationTargetException ex) {
                Throwable th = ex.getTargetException();
                if (th instanceof ObjectStreamException) {
                    throw ((ObjectStreamException) th);
                }
                throwMiscException(th);
                throw new InternalError();
            } catch (IllegalAccessException e) {
                throw new InternalError();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    public Object invokeReadResolve(Object obj) throws IOException, UnsupportedOperationException {
        if (this.readResolveMethod != null) {
            try {
                return this.readResolveMethod.invoke(obj, (Object[]) null);
            } catch (InvocationTargetException ex) {
                Throwable th = ex.getTargetException();
                if (th instanceof ObjectStreamException) {
                    throw ((ObjectStreamException) th);
                }
                throwMiscException(th);
                throw new InternalError();
            } catch (IllegalAccessException e) {
                throw new InternalError();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    static class ClassDataSlot {
        final ObjectStreamClass desc;
        final boolean hasData;

        ClassDataSlot(ObjectStreamClass desc2, boolean hasData2) {
            this.desc = desc2;
            this.hasData = hasData2;
        }
    }

    /* access modifiers changed from: package-private */
    public ClassDataSlot[] getClassDataLayout() throws InvalidClassException {
        if (this.dataLayout == null) {
            this.dataLayout = getClassDataLayout0();
        }
        return this.dataLayout;
    }

    private ClassDataSlot[] getClassDataLayout0() throws InvalidClassException {
        ArrayList<ClassDataSlot> slots = new ArrayList<>();
        Class<?> start = this.cl;
        Class<?> end = this.cl;
        while (end != null && Serializable.class.isAssignableFrom(end)) {
            end = end.getSuperclass();
        }
        HashSet<String> oscNames = new HashSet<>(3);
        for (ObjectStreamClass d = this; d != null; d = d.superDesc) {
            if (oscNames.contains(d.name)) {
                throw new InvalidClassException("Circular reference.");
            }
            oscNames.add(d.name);
            String searchName = d.cl != null ? d.cl.getName() : d.name;
            Class<?> match = null;
            Class<?> c = start;
            while (true) {
                if (c == end) {
                    break;
                } else if (searchName.equals(c.getName())) {
                    match = c;
                    break;
                } else {
                    c = c.getSuperclass();
                }
            }
            if (match != null) {
                for (Class<?> c2 = start; c2 != match; c2 = c2.getSuperclass()) {
                    slots.add(new ClassDataSlot(lookup(c2, true), false));
                }
                start = match.getSuperclass();
            }
            slots.add(new ClassDataSlot(d.getVariantFor(match), true));
        }
        for (Class<? super Object> c3 = start; c3 != end; c3 = c3.getSuperclass()) {
            slots.add(new ClassDataSlot(lookup(c3, true), false));
        }
        Collections.reverse(slots);
        return (ClassDataSlot[]) slots.toArray(new ClassDataSlot[slots.size()]);
    }

    /* access modifiers changed from: package-private */
    public int getPrimDataSize() {
        return this.primDataSize;
    }

    /* access modifiers changed from: package-private */
    public int getNumObjFields() {
        return this.numObjFields;
    }

    /* access modifiers changed from: package-private */
    public void getPrimFieldValues(Object obj, byte[] buf) {
        this.fieldRefl.getPrimFieldValues(obj, buf);
    }

    /* access modifiers changed from: package-private */
    public void setPrimFieldValues(Object obj, byte[] buf) {
        this.fieldRefl.setPrimFieldValues(obj, buf);
    }

    /* access modifiers changed from: package-private */
    public void getObjFieldValues(Object obj, Object[] vals) {
        this.fieldRefl.getObjFieldValues(obj, vals);
    }

    /* access modifiers changed from: package-private */
    public void setObjFieldValues(Object obj, Object[] vals) {
        this.fieldRefl.setObjFieldValues(obj, vals);
    }

    /* access modifiers changed from: private */
    public void computeFieldOffsets() throws InvalidClassException {
        this.primDataSize = 0;
        this.numObjFields = 0;
        int firstObjIndex = -1;
        for (int i = 0; i < this.fields.length; i++) {
            ObjectStreamField f = this.fields[i];
            switch (f.getTypeCode()) {
                case 'B':
                case 'Z':
                    int i2 = this.primDataSize;
                    this.primDataSize = i2 + 1;
                    f.setOffset(i2);
                    break;
                case 'C':
                case 'S':
                    f.setOffset(this.primDataSize);
                    this.primDataSize += 2;
                    break;
                case 'D':
                case 'J':
                    f.setOffset(this.primDataSize);
                    this.primDataSize += 8;
                    break;
                case Types.DATALINK /*70*/:
                case 'I':
                    f.setOffset(this.primDataSize);
                    this.primDataSize += 4;
                    break;
                case 'L':
                case Types.DATE /*91*/:
                    int i3 = this.numObjFields;
                    this.numObjFields = i3 + 1;
                    f.setOffset(i3);
                    if (firstObjIndex != -1) {
                        break;
                    } else {
                        firstObjIndex = i;
                        break;
                    }
                default:
                    throw new InternalError();
            }
        }
        if (firstObjIndex != -1 && this.numObjFields + firstObjIndex != this.fields.length) {
            throw new InvalidClassException(this.name, "illegal field order");
        }
    }

    private ObjectStreamClass getVariantFor(Class<?> cl2) throws InvalidClassException {
        if (this.cl == cl2) {
            return this;
        }
        ObjectStreamClass desc = new ObjectStreamClass();
        if (this.isProxy) {
            desc.initProxy(cl2, (ClassNotFoundException) null, this.superDesc);
        } else {
            desc.initNonProxy(this, cl2, (ClassNotFoundException) null, this.superDesc);
        }
        return desc;
    }

    /* access modifiers changed from: private */
    public static Constructor getExternalizableConstructor(Class<?> cl2) {
        try {
            Constructor cons2 = cl2.getDeclaredConstructor((Class<?>[]) null);
            cons2.setAccessible(true);
            if ((cons2.getModifiers() & 1) != 0) {
                return cons2;
            }
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static Constructor getSerializableConstructor(Class<?> cl2) {
        Class<?> initCl = cl2;
        while (Serializable.class.isAssignableFrom(initCl)) {
            initCl = initCl.getSuperclass();
            if (initCl == null) {
                return null;
            }
        }
        try {
            Constructor cons2 = initCl.getDeclaredConstructor((Class<?>[]) null);
            int mods = cons2.getModifiers();
            if ((mods & 2) != 0 || ((mods & 5) == 0 && !packageEquals(cl2, initCl))) {
                return null;
            }
            if (cons2.getDeclaringClass() != cl2) {
                cons2 = cons2.serializationCopy(cons2.getDeclaringClass(), cl2);
            }
            cons2.setAccessible(true);
            return cons2;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static Method getInheritableMethod(Class<?> cl2, String name2, Class<?>[] argTypes, Class<?> returnType) {
        Method meth = null;
        Class<? super Object> defCl = cl2;
        while (defCl != null) {
            try {
                meth = defCl.getDeclaredMethod(name2, argTypes);
                break;
            } catch (NoSuchMethodException e) {
                defCl = defCl.getSuperclass();
            }
        }
        if (meth == null || meth.getReturnType() != returnType) {
            return null;
        }
        meth.setAccessible(true);
        int mods = meth.getModifiers();
        if ((mods & 1032) != 0) {
            return null;
        }
        if ((mods & 5) != 0) {
            return meth;
        }
        if ((mods & 2) != 0) {
            if (cl2 == defCl) {
                return meth;
            }
            return null;
        } else if (packageEquals(cl2, defCl)) {
            return meth;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static Method getPrivateMethod(Class<?> cl2, String name2, Class<?>[] argTypes, Class<?> returnType) {
        try {
            Method meth = cl2.getDeclaredMethod(name2, argTypes);
            meth.setAccessible(true);
            int mods = meth.getModifiers();
            if (meth.getReturnType() == returnType && (mods & 8) == 0 && (mods & 2) != 0) {
                return meth;
            }
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static boolean packageEquals(Class<?> cl1, Class<?> cl2) {
        if (cl1.getClassLoader() == cl2.getClassLoader()) {
            return getPackageName(cl1).equals(getPackageName(cl2));
        }
        return false;
    }

    private static String getPackageName(Class<?> cl2) {
        String s = cl2.getName();
        int i = s.lastIndexOf(91);
        if (i >= 0) {
            s = s.substring(i + 2);
        }
        int i2 = s.lastIndexOf(46);
        return i2 >= 0 ? s.substring(0, i2) : "";
    }

    private static boolean classNamesEqual(String name1, String name2) {
        return name1.substring(name1.lastIndexOf(46) + 1).equals(name2.substring(name2.lastIndexOf(46) + 1));
    }

    /* access modifiers changed from: private */
    public static String getClassSignature(Class<?> cl2) {
        StringBuilder sbuf = new StringBuilder();
        while (cl2.isArray()) {
            sbuf.append('[');
            cl2 = cl2.getComponentType();
        }
        if (!cl2.isPrimitive()) {
            sbuf.append('L').append(cl2.getName().replace('.', '/')).append(';');
        } else if (cl2 == Integer.TYPE) {
            sbuf.append('I');
        } else if (cl2 == Byte.TYPE) {
            sbuf.append('B');
        } else if (cl2 == Long.TYPE) {
            sbuf.append('J');
        } else if (cl2 == Float.TYPE) {
            sbuf.append('F');
        } else if (cl2 == Double.TYPE) {
            sbuf.append('D');
        } else if (cl2 == Short.TYPE) {
            sbuf.append('S');
        } else if (cl2 == Character.TYPE) {
            sbuf.append('C');
        } else if (cl2 == Boolean.TYPE) {
            sbuf.append('Z');
        } else if (cl2 == Void.TYPE) {
            sbuf.append('V');
        } else {
            throw new InternalError();
        }
        return sbuf.toString();
    }

    /* access modifiers changed from: private */
    public static String getMethodSignature(Class<?>[] paramTypes, Class<?> retType) {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append('(');
        for (Class<?> classSignature : paramTypes) {
            sbuf.append(getClassSignature(classSignature));
        }
        sbuf.append(')');
        sbuf.append(getClassSignature(retType));
        return sbuf.toString();
    }

    private static void throwMiscException(Throwable th) throws IOException {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            IOException ex = new IOException("unexpected exception type");
            ex.initCause(th);
            throw ex;
        }
    }

    /* access modifiers changed from: private */
    public static ObjectStreamField[] getSerialFields(Class<?> cl2) throws InvalidClassException {
        if (!Serializable.class.isAssignableFrom(cl2) || Externalizable.class.isAssignableFrom(cl2) || Proxy.isProxyClass(cl2) || cl2.isInterface()) {
            return NO_FIELDS;
        }
        ObjectStreamField[] fields2 = getDeclaredSerialFields(cl2);
        if (fields2 == null) {
            fields2 = getDefaultSerialFields(cl2);
        }
        Arrays.sort((Object[]) fields2);
        return fields2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.ObjectStreamField[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.ObjectStreamField[] getDeclaredSerialFields(java.lang.Class<?> r13) throws java.io.InvalidClassException {
        /*
            r12 = 0
            r8 = 0
            java.lang.String r10 = "serialPersistentFields"
            java.lang.reflect.Field r4 = r13.getDeclaredField(r10)     // Catch:{ Exception -> 0x009a }
            int r10 = r4.getModifiers()     // Catch:{ Exception -> 0x009a }
            r10 = r10 & 26
            r11 = 26
            if (r10 != r11) goto L_0x0020
            r10 = 1
            r4.setAccessible(r10)     // Catch:{ Exception -> 0x009a }
            r10 = 0
            java.lang.Object r10 = r4.get(r10)     // Catch:{ Exception -> 0x009a }
            r0 = r10
            java.io.ObjectStreamField[] r0 = (java.io.ObjectStreamField[]) r0     // Catch:{ Exception -> 0x009a }
            r8 = r0
        L_0x0020:
            if (r8 != 0) goto L_0x0023
            return r12
        L_0x0023:
            int r10 = r8.length
            if (r10 != 0) goto L_0x0029
            java.io.ObjectStreamField[] r10 = NO_FIELDS
            return r10
        L_0x0029:
            int r10 = r8.length
            java.io.ObjectStreamField[] r1 = new java.io.ObjectStreamField[r10]
            java.util.HashSet r5 = new java.util.HashSet
            int r10 = r8.length
            r5.<init>((int) r10)
            r7 = 0
        L_0x0033:
            int r10 = r8.length
            if (r7 >= r10) goto L_0x0097
            r9 = r8[r7]
            java.lang.String r6 = r9.getName()
            boolean r10 = r5.contains(r6)
            if (r10 == 0) goto L_0x005c
            java.io.InvalidClassException r10 = new java.io.InvalidClassException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "multiple serializable fields named "
            java.lang.StringBuilder r11 = r11.append((java.lang.String) r12)
            java.lang.StringBuilder r11 = r11.append((java.lang.String) r6)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x005c:
            r5.add(r6)
            java.lang.reflect.Field r4 = r13.getDeclaredField(r6)     // Catch:{ NoSuchFieldException -> 0x0098 }
            java.lang.Class r10 = r4.getType()     // Catch:{ NoSuchFieldException -> 0x0098 }
            java.lang.Class r11 = r9.getType()     // Catch:{ NoSuchFieldException -> 0x0098 }
            if (r10 != r11) goto L_0x0081
            int r10 = r4.getModifiers()     // Catch:{ NoSuchFieldException -> 0x0098 }
            r10 = r10 & 8
            if (r10 != 0) goto L_0x0081
            java.io.ObjectStreamField r10 = new java.io.ObjectStreamField     // Catch:{ NoSuchFieldException -> 0x0098 }
            boolean r11 = r9.isUnshared()     // Catch:{ NoSuchFieldException -> 0x0098 }
            r12 = 1
            r10.<init>((java.lang.reflect.Field) r4, (boolean) r11, (boolean) r12)     // Catch:{ NoSuchFieldException -> 0x0098 }
            r1[r7] = r10     // Catch:{ NoSuchFieldException -> 0x0098 }
        L_0x0081:
            r10 = r1[r7]
            if (r10 != 0) goto L_0x0094
            java.io.ObjectStreamField r10 = new java.io.ObjectStreamField
            java.lang.Class r11 = r9.getType()
            boolean r12 = r9.isUnshared()
            r10.<init>((java.lang.String) r6, (java.lang.Class<?>) r11, (boolean) r12)
            r1[r7] = r10
        L_0x0094:
            int r7 = r7 + 1
            goto L_0x0033
        L_0x0097:
            return r1
        L_0x0098:
            r3 = move-exception
            goto L_0x0081
        L_0x009a:
            r2 = move-exception
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.getDeclaredSerialFields(java.lang.Class):java.io.ObjectStreamField[]");
    }

    private static ObjectStreamField[] getDefaultSerialFields(Class<?> cl2) {
        Field[] clFields = cl2.getDeclaredFields();
        ArrayList<ObjectStreamField> list = new ArrayList<>();
        for (int i = 0; i < clFields.length; i++) {
            if ((clFields[i].getModifiers() & 136) == 0) {
                list.add(new ObjectStreamField(clFields[i], false, true));
            }
        }
        int size = list.size();
        if (size == 0) {
            return NO_FIELDS;
        }
        return (ObjectStreamField[]) list.toArray(new ObjectStreamField[size]);
    }

    /* access modifiers changed from: private */
    public static Long getDeclaredSUID(Class<?> cl2) {
        try {
            Field f = cl2.getDeclaredField("serialVersionUID");
            if ((f.getModifiers() & 24) == 24) {
                f.setAccessible(true);
                return Long.valueOf(f.getLong((Object) null));
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static long computeDefaultSUID(Class<?> cl2) {
        if (!Serializable.class.isAssignableFrom(cl2) || Proxy.isProxyClass(cl2)) {
            return 0;
        }
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            DataOutputStream dout = new DataOutputStream(bout);
            dout.writeUTF(cl2.getName());
            int classMods = cl2.getModifiers() & 1553;
            Method[] methods = cl2.getDeclaredMethods();
            if ((classMods & 512) != 0) {
                if (methods.length > 0) {
                    classMods |= 1024;
                } else {
                    classMods &= -1025;
                }
            }
            dout.writeInt(classMods);
            if (!cl2.isArray()) {
                Class<?>[] interfaces = cl2.getInterfaces();
                String[] ifaceNames = new String[interfaces.length];
                for (int i = 0; i < interfaces.length; i++) {
                    ifaceNames[i] = interfaces[i].getName();
                }
                Arrays.sort((Object[]) ifaceNames);
                for (String writeUTF : ifaceNames) {
                    dout.writeUTF(writeUTF);
                }
            }
            Field[] fields2 = cl2.getDeclaredFields();
            MemberSignature[] fieldSigs = new MemberSignature[fields2.length];
            for (int i2 = 0; i2 < fields2.length; i2++) {
                fieldSigs[i2] = new MemberSignature(fields2[i2]);
            }
            Arrays.sort(fieldSigs, new Comparator<MemberSignature>() {
                public int compare(MemberSignature ms1, MemberSignature ms2) {
                    return ms1.name.compareTo(ms2.name);
                }
            });
            for (MemberSignature sig : fieldSigs) {
                int mods = sig.member.getModifiers() & 223;
                if ((mods & 2) == 0 || (mods & 136) == 0) {
                    dout.writeUTF(sig.name);
                    dout.writeInt(mods);
                    dout.writeUTF(sig.signature);
                }
            }
            if (hasStaticInitializer(cl2, VMRuntime.getRuntime().getTargetSdkVersion() > 23)) {
                dout.writeUTF("<clinit>");
                dout.writeInt(8);
                dout.writeUTF("()V");
            }
            Constructor[] cons2 = cl2.getDeclaredConstructors();
            MemberSignature[] consSigs = new MemberSignature[cons2.length];
            for (int i3 = 0; i3 < cons2.length; i3++) {
                consSigs[i3] = new MemberSignature(cons2[i3]);
            }
            Arrays.sort(consSigs, new Comparator<MemberSignature>() {
                public int compare(MemberSignature ms1, MemberSignature ms2) {
                    return ms1.signature.compareTo(ms2.signature);
                }
            });
            for (MemberSignature sig2 : consSigs) {
                int mods2 = sig2.member.getModifiers() & 3391;
                if ((mods2 & 2) == 0) {
                    dout.writeUTF("<init>");
                    dout.writeInt(mods2);
                    dout.writeUTF(sig2.signature.replace('/', '.'));
                }
            }
            MemberSignature[] methSigs = new MemberSignature[methods.length];
            for (int i4 = 0; i4 < methods.length; i4++) {
                methSigs[i4] = new MemberSignature(methods[i4]);
            }
            Arrays.sort(methSigs, new Comparator<MemberSignature>() {
                public int compare(MemberSignature ms1, MemberSignature ms2) {
                    int comp = ms1.name.compareTo(ms2.name);
                    if (comp == 0) {
                        return ms1.signature.compareTo(ms2.signature);
                    }
                    return comp;
                }
            });
            for (MemberSignature sig3 : methSigs) {
                int mods3 = sig3.member.getModifiers() & 3391;
                if ((mods3 & 2) == 0) {
                    dout.writeUTF(sig3.name);
                    dout.writeInt(mods3);
                    dout.writeUTF(sig3.signature.replace('/', '.'));
                }
            }
            dout.flush();
            byte[] hashBytes = MessageDigest.getInstance("SHA").digest(bout.toByteArray());
            long hash = 0;
            for (int i5 = Math.min(hashBytes.length, 8) - 1; i5 >= 0; i5--) {
                hash = (hash << 8) | ((long) (hashBytes[i5] & Character.DIRECTIONALITY_UNDEFINED));
            }
            return hash;
        } catch (IOException e) {
            throw new InternalError();
        } catch (NoSuchAlgorithmException ex) {
            throw new SecurityException(ex.getMessage());
        }
    }

    private static class MemberSignature {
        public final Member member;
        public final String name;
        public final String signature;

        public MemberSignature(Field field) {
            this.member = field;
            this.name = field.getName();
            this.signature = ObjectStreamClass.getClassSignature(field.getType());
        }

        public MemberSignature(Constructor cons) {
            this.member = cons;
            this.name = cons.getName();
            this.signature = ObjectStreamClass.getMethodSignature(cons.getParameterTypes(), Void.TYPE);
        }

        public MemberSignature(Method meth) {
            this.member = meth;
            this.name = meth.getName();
            this.signature = ObjectStreamClass.getMethodSignature(meth.getParameterTypes(), meth.getReturnType());
        }
    }

    private static class FieldReflector {
        private static final Unsafe unsafe = null;
        private final ObjectStreamField[] fields;
        private final int numPrimFields;
        private final int[] offsets;
        private final long[] readKeys;
        private final char[] typeCodes;
        private final Class<?>[] types;
        private final long[] writeKeys;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.ObjectStreamClass.FieldReflector.<clinit>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.ObjectStreamClass.FieldReflector.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.FieldReflector.<clinit>():void");
        }

        FieldReflector(ObjectStreamField[] fields2) {
            Class<?> cls;
            this.fields = fields2;
            int nfields = fields2.length;
            this.readKeys = new long[nfields];
            this.writeKeys = new long[nfields];
            this.offsets = new int[nfields];
            this.typeCodes = new char[nfields];
            ArrayList<Class<?>> typeList = new ArrayList<>();
            Set<Long> usedKeys = new HashSet<>();
            for (int i = 0; i < nfields; i++) {
                ObjectStreamField f = fields2[i];
                Field rf = f.getField();
                long key = rf != null ? unsafe.objectFieldOffset(rf) : -1;
                this.readKeys[i] = key;
                this.writeKeys[i] = !usedKeys.add(Long.valueOf(key)) ? -1 : key;
                this.offsets[i] = f.getOffset();
                this.typeCodes[i] = f.getTypeCode();
                if (!f.isPrimitive()) {
                    if (rf != null) {
                        cls = rf.getType();
                    } else {
                        cls = null;
                    }
                    typeList.add(cls);
                }
            }
            this.types = (Class[]) typeList.toArray(new Class[typeList.size()]);
            this.numPrimFields = nfields - this.types.length;
        }

        /* access modifiers changed from: package-private */
        public ObjectStreamField[] getFields() {
            return this.fields;
        }

        /* access modifiers changed from: package-private */
        public void getPrimFieldValues(Object obj, byte[] buf) {
            if (obj == null) {
                throw new NullPointerException();
            }
            for (int i = 0; i < this.numPrimFields; i++) {
                long key = this.readKeys[i];
                int off = this.offsets[i];
                switch (this.typeCodes[i]) {
                    case 'B':
                        buf[off] = unsafe.getByte(obj, key);
                        break;
                    case 'C':
                        Bits.putChar(buf, off, unsafe.getChar(obj, key));
                        break;
                    case 'D':
                        Bits.putDouble(buf, off, unsafe.getDouble(obj, key));
                        break;
                    case Types.DATALINK /*70*/:
                        Bits.putFloat(buf, off, unsafe.getFloat(obj, key));
                        break;
                    case 'I':
                        Bits.putInt(buf, off, unsafe.getInt(obj, key));
                        break;
                    case 'J':
                        Bits.putLong(buf, off, unsafe.getLong(obj, key));
                        break;
                    case 'S':
                        Bits.putShort(buf, off, unsafe.getShort(obj, key));
                        break;
                    case 'Z':
                        Bits.putBoolean(buf, off, unsafe.getBoolean(obj, key));
                        break;
                    default:
                        throw new InternalError();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setPrimFieldValues(Object obj, byte[] buf) {
            if (obj == null) {
                throw new NullPointerException();
            }
            for (int i = 0; i < this.numPrimFields; i++) {
                long key = this.writeKeys[i];
                if (key != -1) {
                    int off = this.offsets[i];
                    switch (this.typeCodes[i]) {
                        case 'B':
                            unsafe.putByte(obj, key, buf[off]);
                            break;
                        case 'C':
                            unsafe.putChar(obj, key, Bits.getChar(buf, off));
                            break;
                        case 'D':
                            unsafe.putDouble(obj, key, Bits.getDouble(buf, off));
                            break;
                        case Types.DATALINK /*70*/:
                            unsafe.putFloat(obj, key, Bits.getFloat(buf, off));
                            break;
                        case 'I':
                            unsafe.putInt(obj, key, Bits.getInt(buf, off));
                            break;
                        case 'J':
                            unsafe.putLong(obj, key, Bits.getLong(buf, off));
                            break;
                        case 'S':
                            unsafe.putShort(obj, key, Bits.getShort(buf, off));
                            break;
                        case 'Z':
                            unsafe.putBoolean(obj, key, Bits.getBoolean(buf, off));
                            break;
                        default:
                            throw new InternalError();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void getObjFieldValues(Object obj, Object[] vals) {
            if (obj == null) {
                throw new NullPointerException();
            }
            int i = this.numPrimFields;
            while (i < this.fields.length) {
                switch (this.typeCodes[i]) {
                    case 'L':
                    case Types.DATE /*91*/:
                        vals[this.offsets[i]] = unsafe.getObject(obj, this.readKeys[i]);
                        i++;
                    default:
                        throw new InternalError();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setObjFieldValues(Object obj, Object[] vals) {
            if (obj == null) {
                throw new NullPointerException();
            }
            for (int i = this.numPrimFields; i < this.fields.length; i++) {
                long key = this.writeKeys[i];
                if (key != -1) {
                    switch (this.typeCodes[i]) {
                        case 'L':
                        case Types.DATE /*91*/:
                            Object val = vals[this.offsets[i]];
                            if (val == null || this.types[i - this.numPrimFields].isInstance(val)) {
                                unsafe.putObject(obj, key, val);
                                break;
                            } else {
                                Field f = this.fields[i].getField();
                                throw new ClassCastException("cannot assign instance of " + val.getClass().getName() + " to field " + f.getDeclaringClass().getName() + "." + f.getName() + " of type " + f.getType().getName() + " in instance of " + obj.getClass().getName());
                            }
                        default:
                            throw new InternalError();
                    }
                }
            }
        }
    }

    private static FieldReflector getReflector(ObjectStreamField[] fields2, ObjectStreamClass localDesc2) throws InvalidClassException {
        Object entry;
        Class<?> cls = (localDesc2 == null || fields2.length <= 0) ? null : localDesc2.cl;
        processQueue(Caches.reflectorsQueue, Caches.reflectors);
        FieldReflectorKey key = new FieldReflectorKey(cls, fields2, Caches.reflectorsQueue);
        Reference<?> ref = (Reference) Caches.reflectors.get(key);
        Object entry2 = null;
        if (ref != null) {
            entry2 = ref.get();
        }
        EntryFuture future = null;
        if (entry2 == null) {
            EntryFuture newEntry = new EntryFuture((EntryFuture) null);
            Reference<?> newRef = new SoftReference<>(newEntry);
            do {
                if (ref != null) {
                    Caches.reflectors.remove(key, ref);
                }
                ref = Caches.reflectors.putIfAbsent(key, newRef);
                if (ref != null) {
                    entry2 = ref.get();
                }
                if (ref == null) {
                    break;
                }
            } while (entry2 == null);
            if (entry2 == null) {
                future = newEntry;
            }
        }
        if (entry instanceof FieldReflector) {
            return (FieldReflector) entry;
        }
        if (entry instanceof EntryFuture) {
            entry = ((EntryFuture) entry).get();
        } else if (entry == null) {
            try {
                entry = new FieldReflector(matchFields(fields2, localDesc2));
            } catch (Throwable th) {
                entry = th;
            }
            future.set(entry);
            Caches.reflectors.put(key, new SoftReference(entry));
        }
        if (entry instanceof FieldReflector) {
            return (FieldReflector) entry;
        }
        if (entry instanceof InvalidClassException) {
            throw ((InvalidClassException) entry);
        } else if (entry instanceof RuntimeException) {
            throw ((RuntimeException) entry);
        } else if (entry instanceof Error) {
            throw ((Error) entry);
        } else {
            throw new InternalError("unexpected entry: " + entry);
        }
    }

    private static class FieldReflectorKey extends WeakReference<Class<?>> {
        private final int hash;
        private final boolean nullClass;
        private final String sigs;

        FieldReflectorKey(Class<?> cl, ObjectStreamField[] fields, ReferenceQueue<Class<?>> queue) {
            super(cl, queue);
            this.nullClass = cl == null;
            StringBuilder sbuf = new StringBuilder();
            for (ObjectStreamField f : fields) {
                sbuf.append(f.getName()).append(f.getSignature());
            }
            this.sigs = sbuf.toString();
            this.hash = System.identityHashCode(cl) + this.sigs.hashCode();
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldReflectorKey)) {
                return false;
            }
            FieldReflectorKey other = (FieldReflectorKey) obj;
            if (!this.nullClass) {
                Class<?> referent = (Class) get();
                if (referent == null || referent != other.get()) {
                    return false;
                }
            } else if (!other.nullClass) {
                return false;
            }
            return this.sigs.equals(other.sigs);
        }
    }

    private static ObjectStreamField[] matchFields(ObjectStreamField[] fields2, ObjectStreamClass localDesc2) throws InvalidClassException {
        ObjectStreamField[] localFields = localDesc2 != null ? localDesc2.fields : NO_FIELDS;
        ObjectStreamField[] matches = new ObjectStreamField[fields2.length];
        for (int i = 0; i < fields2.length; i++) {
            ObjectStreamField f = fields2[i];
            ObjectStreamField m = null;
            for (ObjectStreamField lf : localFields) {
                if (f.getName().equals(lf.getName()) && f.getSignature().equals(lf.getSignature())) {
                    if (lf.getField() != null) {
                        m = new ObjectStreamField(lf.getField(), lf.isUnshared(), false);
                    } else {
                        m = new ObjectStreamField(lf.getName(), lf.getSignature(), lf.isUnshared());
                    }
                }
            }
            if (m == null) {
                m = new ObjectStreamField(f.getName(), f.getSignature(), false);
            }
            m.setOffset(f.getOffset());
            matches[i] = m;
        }
        return matches;
    }

    private static long getConstructorId(Class<?> cls) {
        System.logE("WARNING: ObjectStreamClass.getConstructorId(Class<?>) is private API andwill be removed in a future Android release.");
        return 1189998819991197253L;
    }

    private static Object newInstance(Class<?> clazz, long constructorId) {
        System.logE("WARNING: ObjectStreamClass.newInstance(Class<?>, long) is private API andwill be removed in a future Android release.");
        return Unsafe.getUnsafe().allocateInstance(clazz);
    }

    static void processQueue(ReferenceQueue<Class<?>> queue, ConcurrentMap<? extends WeakReference<Class<?>>, ?> map) {
        while (true) {
            Reference<? extends Class<?>> ref = queue.poll();
            if (ref != null) {
                map.remove(ref);
            } else {
                return;
            }
        }
    }

    static class WeakClassKey extends WeakReference<Class<?>> {
        private final int hash;

        WeakClassKey(Class<?> cl, ReferenceQueue<Class<?>> refQueue) {
            super(cl, refQueue);
            this.hash = System.identityHashCode(cl);
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WeakClassKey)) {
                return false;
            }
            Object referent = get();
            if (referent == null) {
                return false;
            }
            if (referent == ((WeakClassKey) obj).get()) {
                return true;
            }
            return false;
        }
    }
}
