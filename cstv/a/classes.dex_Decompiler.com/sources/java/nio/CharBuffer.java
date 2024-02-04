package java.nio;

import java.io.IOException;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
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
public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, Appendable, CharSequence, Readable {
    final char[] hb;
    boolean isReadOnly;
    final int offset;

    /* renamed from: java.nio.CharBuffer$-java_util_stream_IntStream_chars__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_IntStream_chars__LambdaImpl0 implements Supplier {
        private /* synthetic */ CharBuffer val$self;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.nio.CharBuffer.-java_util_stream_IntStream_chars__LambdaImpl0.<init>(java.nio.CharBuffer):void, dex: classes.dex
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
        public /* synthetic */ java_util_stream_IntStream_chars__LambdaImpl0(java.nio.CharBuffer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.nio.CharBuffer.-java_util_stream_IntStream_chars__LambdaImpl0.<init>(java.nio.CharBuffer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.nio.CharBuffer.java_util_stream_IntStream_chars__LambdaImpl0.<init>(java.nio.CharBuffer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.nio.CharBuffer.-java_util_stream_IntStream_chars__LambdaImpl0.get():java.lang.Object, dex: classes.dex
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
        public java.lang.Object get() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.nio.CharBuffer.-java_util_stream_IntStream_chars__LambdaImpl0.get():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.nio.CharBuffer.java_util_stream_IntStream_chars__LambdaImpl0.get():java.lang.Object");
        }
    }

    public abstract CharBuffer asReadOnlyBuffer();

    public abstract CharBuffer compact();

    public abstract CharBuffer duplicate();

    public abstract char get();

    public abstract char get(int i);

    /* access modifiers changed from: package-private */
    public abstract char getUnchecked(int i);

    public abstract boolean isDirect();

    public abstract ByteOrder order();

    public abstract CharBuffer put(char c);

    public abstract CharBuffer put(int i, char c);

    public abstract CharBuffer slice();

    public abstract CharBuffer subSequence(int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract String toString(int i, int i2);

    CharBuffer(int mark, int pos, int lim, int cap, char[] hb2, int offset2) {
        super(mark, pos, lim, cap, 1);
        this.hb = hb2;
        this.offset = offset2;
    }

    CharBuffer(int mark, int pos, int lim, int cap) {
        this(mark, pos, lim, cap, (char[]) null, 0);
    }

    public static CharBuffer allocate(int capacity) {
        if (capacity >= 0) {
            return new HeapCharBuffer(capacity, capacity);
        }
        throw new IllegalArgumentException();
    }

    public static CharBuffer wrap(char[] array, int offset2, int length) {
        try {
            return new HeapCharBuffer(array, offset2, length);
        } catch (IllegalArgumentException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    public int read(CharBuffer target) throws IOException {
        int targetRemaining = target.remaining();
        int remaining = remaining();
        if (remaining == 0) {
            return -1;
        }
        int n = Math.min(remaining, targetRemaining);
        int limit = limit();
        if (targetRemaining < remaining) {
            limit(position() + n);
        }
        if (n > 0) {
            try {
                target.put(this);
            } catch (Throwable th) {
                limit(limit);
                throw th;
            }
        }
        limit(limit);
        return n;
    }

    public static CharBuffer wrap(CharSequence csq, int start, int end) {
        try {
            return new StringCharBuffer(csq, start, end);
        } catch (IllegalArgumentException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static CharBuffer wrap(CharSequence csq) {
        return wrap(csq, 0, csq.length());
    }

    public CharBuffer get(char[] dst, int offset2, int length) {
        checkBounds(offset2, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        int end = offset2 + length;
        for (int i = offset2; i < end; i++) {
            dst[i] = get();
        }
        return this;
    }

    public CharBuffer get(char[] dst) {
        return get(dst, 0, dst.length);
    }

    public CharBuffer put(CharBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        int n = src.remaining();
        if (n > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = 0; i < n; i++) {
            put(src.get());
        }
        return this;
    }

    public CharBuffer put(char[] src, int offset2, int length) {
        checkBounds(offset2, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        int end = offset2 + length;
        for (int i = offset2; i < end; i++) {
            put(src[i]);
        }
        return this;
    }

    public final CharBuffer put(char[] src) {
        return put(src, 0, src.length);
    }

    public CharBuffer put(String src, int start, int end) {
        checkBounds(start, end - start, src.length());
        if (start == end) {
            return this;
        }
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (end - start > remaining()) {
            throw new BufferOverflowException();
        } else {
            for (int i = start; i < end; i++) {
                put(src.charAt(i));
            }
            return this;
        }
    }

    public final CharBuffer put(String src) {
        return put(src, 0, src.length());
    }

    public final boolean hasArray() {
        return this.hb != null && !this.isReadOnly;
    }

    public /* bridge */ /* synthetic */ Object array() {
        return array();
    }

    public final char[] array() {
        if (this.hb == null) {
            throw new UnsupportedOperationException();
        } else if (!this.isReadOnly) {
            return this.hb;
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public final int arrayOffset() {
        if (this.hb == null) {
            throw new UnsupportedOperationException();
        } else if (!this.isReadOnly) {
            return this.offset;
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public int hashCode() {
        int h = 1;
        int p = position();
        for (int i = limit() - 1; i >= p; i--) {
            h = (h * 31) + get(i);
        }
        return h;
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof CharBuffer)) {
            return false;
        }
        CharBuffer that = (CharBuffer) ob;
        if (remaining() != that.remaining()) {
            return false;
        }
        int p = position();
        int i = limit() - 1;
        int j = that.limit() - 1;
        while (i >= p) {
            if (!equals(get(i), that.get(j))) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    private static boolean equals(char x, char y) {
        return x == y;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object that) {
        return compareTo((CharBuffer) that);
    }

    public int compareTo(CharBuffer that) {
        int n = position() + Math.min(remaining(), that.remaining());
        int i = position();
        int j = that.position();
        while (i < n) {
            int cmp = compare(get(i), that.get(j));
            if (cmp != 0) {
                return cmp;
            }
            i++;
            j++;
        }
        return remaining() - that.remaining();
    }

    private static int compare(char x, char y) {
        return Character.compare(x, y);
    }

    public String toString() {
        return toString(position(), limit());
    }

    public final int length() {
        return remaining();
    }

    public final char charAt(int index) {
        return get(position() + checkIndex(index, 1));
    }

    public /* bridge */ /* synthetic */ CharSequence subSequence(int start, int end) {
        return subSequence(start, end);
    }

    public /* bridge */ /* synthetic */ Appendable append(CharSequence csq) throws IOException {
        return append(csq);
    }

    public CharBuffer append(CharSequence csq) {
        if (csq == null) {
            return put("null");
        }
        return put(csq.toString());
    }

    public /* bridge */ /* synthetic */ Appendable append(CharSequence csq, int start, int end) throws IOException {
        return append(csq, start, end);
    }

    public CharBuffer append(CharSequence csq, int start, int end) {
        CharSequence cs;
        if (csq == null) {
            cs = "null";
        } else {
            cs = csq;
        }
        return put(cs.subSequence(start, end).toString());
    }

    public /* bridge */ /* synthetic */ Appendable append(char c) throws IOException {
        return append(c);
    }

    public CharBuffer append(char c) {
        return put(c);
    }

    public IntStream chars() {
        return StreamSupport.intStream(new java_util_stream_IntStream_chars__LambdaImpl0(this), 16464, false);
    }

    /* renamed from: -java_nio_CharBuffer_lambda$1  reason: not valid java name */
    static /* synthetic */ Spliterator.OfInt m141java_nio_CharBuffer_lambda$1(CharBuffer self) {
        return new CharBufferSpliterator(self);
    }
}
