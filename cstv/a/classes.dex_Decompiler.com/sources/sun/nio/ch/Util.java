package sun.nio.ch;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.security.AccessController;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import sun.misc.Cleaner;
import sun.misc.Unsafe;
import sun.misc.VM;
import sun.security.action.GetPropertyAction;

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
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class Util {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f137assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final int TEMP_BUF_POOL_SIZE = 0;
    private static ThreadLocal<BufferCache> bufferCache;
    private static volatile String bugLevel;
    private static ThreadLocal<SoftReference<SelectorWrapper>> localSelector;
    private static ThreadLocal<SelectorWrapper> localSelectorWrapper;
    private static int pageSize;
    private static Unsafe unsafe;

    private static class SelectorWrapper {
        private Selector sel;

        private static class Closer implements Runnable {
            private Selector sel;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.Util.SelectorWrapper.Closer.<init>(java.nio.channels.Selector):void, dex: classes.dex
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
            private Closer(java.nio.channels.Selector r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.Util.SelectorWrapper.Closer.<init>(java.nio.channels.Selector):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.Util.SelectorWrapper.Closer.<init>(java.nio.channels.Selector):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.Util.SelectorWrapper.Closer.<init>(java.nio.channels.Selector, sun.nio.ch.Util$SelectorWrapper$Closer):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            /* synthetic */ Closer(java.nio.channels.Selector r1, sun.nio.ch.Util.SelectorWrapper.Closer r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.Util.SelectorWrapper.Closer.<init>(java.nio.channels.Selector, sun.nio.ch.Util$SelectorWrapper$Closer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.Util.SelectorWrapper.Closer.<init>(java.nio.channels.Selector, sun.nio.ch.Util$SelectorWrapper$Closer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.Util.SelectorWrapper.Closer.run():void, dex: classes.dex
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
            public void run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.Util.SelectorWrapper.Closer.run():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.Util.SelectorWrapper.Closer.run():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.Util.SelectorWrapper.<init>(java.nio.channels.Selector):void, dex: classes.dex
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
        private SelectorWrapper(java.nio.channels.Selector r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.nio.ch.Util.SelectorWrapper.<init>(java.nio.channels.Selector):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.Util.SelectorWrapper.<init>(java.nio.channels.Selector):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.Util.SelectorWrapper.<init>(java.nio.channels.Selector, sun.nio.ch.Util$SelectorWrapper):void, dex: classes.dex
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
        /* synthetic */ SelectorWrapper(java.nio.channels.Selector r1, sun.nio.ch.Util.SelectorWrapper r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.Util.SelectorWrapper.<init>(java.nio.channels.Selector, sun.nio.ch.Util$SelectorWrapper):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.Util.SelectorWrapper.<init>(java.nio.channels.Selector, sun.nio.ch.Util$SelectorWrapper):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.Util.SelectorWrapper.get():java.nio.channels.Selector, dex: classes.dex
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
        public java.nio.channels.Selector get() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.nio.ch.Util.SelectorWrapper.get():java.nio.channels.Selector, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.Util.SelectorWrapper.get():java.nio.channels.Selector");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.Util.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.Util.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.Util.<clinit>():void");
    }

    Util() {
    }

    private static class BufferCache {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f138assertionsDisabled = false;
        private ByteBuffer[] buffers = new ByteBuffer[Util.TEMP_BUF_POOL_SIZE];
        private int count;
        private int start;

        private int next(int i) {
            return (i + 1) % Util.TEMP_BUF_POOL_SIZE;
        }

        BufferCache() {
        }

        /* access modifiers changed from: package-private */
        public ByteBuffer get(int size) {
            ByteBuffer bb;
            if (this.count == 0) {
                return null;
            }
            ByteBuffer[] buffers2 = this.buffers;
            ByteBuffer buf = buffers2[this.start];
            if (buf.capacity() < size) {
                buf = null;
                int i = this.start;
                while (true) {
                    i = next(i);
                    if (i != this.start && (bb = buffers2[i]) != null) {
                        if (bb.capacity() >= size) {
                            buf = bb;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (buf == null) {
                    return null;
                }
                buffers2[i] = buffers2[this.start];
            }
            buffers2[this.start] = null;
            this.start = next(this.start);
            this.count--;
            buf.rewind();
            buf.limit(size);
            return buf;
        }

        /* access modifiers changed from: package-private */
        public boolean offerFirst(ByteBuffer buf) {
            if (this.count >= Util.TEMP_BUF_POOL_SIZE) {
                return false;
            }
            this.start = ((this.start + Util.TEMP_BUF_POOL_SIZE) - 1) % Util.TEMP_BUF_POOL_SIZE;
            this.buffers[this.start] = buf;
            this.count++;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean offerLast(ByteBuffer buf) {
            if (this.count >= Util.TEMP_BUF_POOL_SIZE) {
                return false;
            }
            this.buffers[(this.start + this.count) % Util.TEMP_BUF_POOL_SIZE] = buf;
            this.count++;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.count == 0;
        }

        /* access modifiers changed from: package-private */
        public ByteBuffer removeFirst() {
            boolean z = false;
            if (!f138assertionsDisabled) {
                if (this.count > 0) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            ByteBuffer buf = this.buffers[this.start];
            this.buffers[this.start] = null;
            this.start = next(this.start);
            this.count--;
            return buf;
        }
    }

    static ByteBuffer getTemporaryDirectBuffer(int size) {
        BufferCache cache = bufferCache.get();
        ByteBuffer buf = cache.get(size);
        if (buf != null) {
            return buf;
        }
        if (!cache.isEmpty()) {
            free(cache.removeFirst());
        }
        return ByteBuffer.allocateDirect(size);
    }

    static void releaseTemporaryDirectBuffer(ByteBuffer buf) {
        offerFirstTemporaryDirectBuffer(buf);
    }

    static void offerFirstTemporaryDirectBuffer(ByteBuffer buf) {
        if (!f137assertionsDisabled) {
            if (!(buf != null)) {
                throw new AssertionError();
            }
        }
        if (!bufferCache.get().offerFirst(buf)) {
            free(buf);
        }
    }

    static void offerLastTemporaryDirectBuffer(ByteBuffer buf) {
        if (!f137assertionsDisabled) {
            if (!(buf != null)) {
                throw new AssertionError();
            }
        }
        if (!bufferCache.get().offerLast(buf)) {
            free(buf);
        }
    }

    private static void free(ByteBuffer buf) {
        Cleaner cleaner = ((DirectBuffer) buf).cleaner();
        if (cleaner != null) {
            cleaner.clean();
        }
    }

    static Selector getTemporarySelector(SelectableChannel sc) throws IOException {
        SelectorWrapper selWrapper;
        Selector sel;
        SoftReference<SelectorWrapper> ref = localSelector.get();
        if (ref == null || (selWrapper = ref.get()) == null || (sel = selWrapper.get()) == null || sel.provider() != sc.provider()) {
            sel = sc.provider().openSelector();
            selWrapper = new SelectorWrapper(sel, (SelectorWrapper) null);
            localSelector.set(new SoftReference(selWrapper));
        }
        localSelectorWrapper.set(selWrapper);
        return sel;
    }

    static void releaseTemporarySelector(Selector sel) throws IOException {
        sel.selectNow();
        if (f137assertionsDisabled || sel.keys().isEmpty()) {
            localSelectorWrapper.set(null);
            return;
        }
        throw new AssertionError((Object) "Temporary selector not empty");
    }

    static ByteBuffer[] subsequence(ByteBuffer[] bs, int offset, int length) {
        if (offset == 0 && length == bs.length) {
            return bs;
        }
        int i = length;
        ByteBuffer[] bs2 = new ByteBuffer[length];
        for (int i2 = 0; i2 < length; i2++) {
            bs2[i2] = bs[offset + i2];
        }
        return bs2;
    }

    static <E> Set<E> ungrowableSet(final Set<E> s) {
        return new Set<E>() {
            public int size() {
                return s.size();
            }

            public boolean isEmpty() {
                return s.isEmpty();
            }

            public boolean contains(Object o) {
                return s.contains(o);
            }

            public Object[] toArray() {
                return s.toArray();
            }

            public <T> T[] toArray(T[] a) {
                return s.toArray(a);
            }

            public String toString() {
                return s.toString();
            }

            public Iterator<E> iterator() {
                return s.iterator();
            }

            public boolean equals(Object o) {
                return s.equals(o);
            }

            public int hashCode() {
                return s.hashCode();
            }

            public void clear() {
                s.clear();
            }

            public boolean remove(Object o) {
                return s.remove(o);
            }

            public boolean containsAll(Collection<?> coll) {
                return s.containsAll(coll);
            }

            public boolean removeAll(Collection<?> coll) {
                return s.removeAll(coll);
            }

            public boolean retainAll(Collection<?> coll) {
                return s.retainAll(coll);
            }

            public boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static byte _get(long a) {
        return unsafe.getByte(a);
    }

    private static void _put(long a, byte b) {
        unsafe.putByte(a, b);
    }

    static void erase(ByteBuffer bb) {
        unsafe.setMemory(((DirectBuffer) bb).address(), (long) bb.capacity(), (byte) 0);
    }

    static Unsafe unsafe() {
        return unsafe;
    }

    static int pageSize() {
        if (pageSize == -1) {
            pageSize = unsafe().pageSize();
        }
        return pageSize;
    }

    static boolean atBugLevel(String bl) {
        if (bugLevel == null) {
            if (!VM.isBooted()) {
                return false;
            }
            String value = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.ch.bugLevel"));
            if (value == null) {
                value = "";
            }
            bugLevel = value;
        }
        return bugLevel.equals(bl);
    }
}
