package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

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
public class BitSet implements Cloneable, Serializable {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f34assertionsDisabled = false;
    private static final int ADDRESS_BITS_PER_WORD = 6;
    private static final int BITS_PER_WORD = 64;
    private static final int BIT_INDEX_MASK = 63;
    private static final long WORD_MASK = -1;
    private static final ObjectStreamField[] serialPersistentFields = null;
    private static final long serialVersionUID = 7997698588986878753L;
    private transient boolean sizeIsSticky;
    private long[] words;
    private transient int wordsInUse;

    /* renamed from: java.util.BitSet$-java_util_stream_IntStream_stream__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_IntStream_stream__LambdaImpl0 implements Supplier {
        private /* synthetic */ BitSet val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.BitSet.-java_util_stream_IntStream_stream__LambdaImpl0.<init>(java.util.BitSet):void, dex: classes.dex
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
        public /* synthetic */ java_util_stream_IntStream_stream__LambdaImpl0(java.util.BitSet r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.BitSet.-java_util_stream_IntStream_stream__LambdaImpl0.<init>(java.util.BitSet):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.BitSet.java_util_stream_IntStream_stream__LambdaImpl0.<init>(java.util.BitSet):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.BitSet.-java_util_stream_IntStream_stream__LambdaImpl0.get():java.lang.Object, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.BitSet.-java_util_stream_IntStream_stream__LambdaImpl0.get():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.BitSet.java_util_stream_IntStream_stream__LambdaImpl0.get():java.lang.Object");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.BitSet.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.BitSet.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.BitSet.<clinit>():void");
    }

    private static int wordIndex(int bitIndex) {
        return bitIndex >> 6;
    }

    private void checkInvariants() {
        boolean z = true;
        if (!f34assertionsDisabled) {
            if (!(this.wordsInUse == 0 || this.words[this.wordsInUse + -1] != 0)) {
                throw new AssertionError();
            }
        }
        if (!f34assertionsDisabled) {
            if (!(this.wordsInUse >= 0 && this.wordsInUse <= this.words.length)) {
                throw new AssertionError();
            }
        }
        if (!f34assertionsDisabled) {
            if (!(this.wordsInUse == this.words.length || this.words[this.wordsInUse] == 0)) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
    }

    private void recalculateWordsInUse() {
        int i = this.wordsInUse - 1;
        while (i >= 0 && this.words[i] == 0) {
            i--;
        }
        this.wordsInUse = i + 1;
    }

    public BitSet() {
        this.wordsInUse = 0;
        this.sizeIsSticky = f34assertionsDisabled;
        initWords(64);
        this.sizeIsSticky = f34assertionsDisabled;
    }

    public BitSet(int nbits) {
        this.wordsInUse = 0;
        this.sizeIsSticky = f34assertionsDisabled;
        if (nbits < 0) {
            throw new NegativeArraySizeException("nbits < 0: " + nbits);
        }
        initWords(nbits);
        this.sizeIsSticky = true;
    }

    private void initWords(int nbits) {
        this.words = new long[(wordIndex(nbits - 1) + 1)];
    }

    private BitSet(long[] words2) {
        this.wordsInUse = 0;
        this.sizeIsSticky = f34assertionsDisabled;
        this.words = words2;
        this.wordsInUse = words2.length;
        checkInvariants();
    }

    public static BitSet valueOf(long[] longs) {
        int n = longs.length;
        while (n > 0 && longs[n - 1] == 0) {
            n--;
        }
        return new BitSet(Arrays.copyOf(longs, n));
    }

    public static BitSet valueOf(LongBuffer lb) {
        LongBuffer lb2 = lb.slice();
        int n = lb2.remaining();
        while (n > 0 && lb2.get(n - 1) == 0) {
            n--;
        }
        long[] words2 = new long[n];
        lb2.get(words2);
        return new BitSet(words2);
    }

    public static BitSet valueOf(byte[] bytes) {
        return valueOf(ByteBuffer.wrap(bytes));
    }

    public static BitSet valueOf(ByteBuffer bb) {
        ByteBuffer bb2 = bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        int n = bb2.remaining();
        while (n > 0 && bb2.get(n - 1) == 0) {
            n--;
        }
        long[] words2 = new long[((n + 7) / 8)];
        bb2.limit(n);
        int i = 0;
        while (bb2.remaining() >= 8) {
            words2[i] = bb2.getLong();
            i++;
        }
        int remaining = bb2.remaining();
        for (int j = 0; j < remaining; j++) {
            words2[i] = words2[i] | ((((long) bb2.get()) & 255) << (j * 8));
        }
        return new BitSet(words2);
    }

    public byte[] toByteArray() {
        int n = this.wordsInUse;
        if (n == 0) {
            return new byte[0];
        }
        int len = (n - 1) * 8;
        for (long x = this.words[n - 1]; x != 0; x >>>= 8) {
            len++;
        }
        byte[] bytes = new byte[len];
        ByteBuffer bb = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < n - 1; i++) {
            bb.putLong(this.words[i]);
        }
        for (long x2 = this.words[n - 1]; x2 != 0; x2 >>>= 8) {
            bb.put((byte) ((int) (255 & x2)));
        }
        return bytes;
    }

    public long[] toLongArray() {
        return Arrays.copyOf(this.words, this.wordsInUse);
    }

    private void ensureCapacity(int wordsRequired) {
        if (this.words.length < wordsRequired) {
            this.words = Arrays.copyOf(this.words, Math.max(this.words.length * 2, wordsRequired));
            this.sizeIsSticky = f34assertionsDisabled;
        }
    }

    private void expandTo(int wordIndex) {
        int wordsRequired = wordIndex + 1;
        if (this.wordsInUse < wordsRequired) {
            ensureCapacity(wordsRequired);
            this.wordsInUse = wordsRequired;
        }
    }

    private static void checkRange(int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + fromIndex);
        } else if (toIndex < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + toIndex);
        } else if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + " > toIndex: " + toIndex);
        }
    }

    public void flip(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        int wordIndex = wordIndex(bitIndex);
        expandTo(wordIndex);
        long[] jArr = this.words;
        jArr[wordIndex] = jArr[wordIndex] ^ (1 << bitIndex);
        recalculateWordsInUse();
        checkInvariants();
    }

    public void flip(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        if (fromIndex != toIndex) {
            int startWordIndex = wordIndex(fromIndex);
            int endWordIndex = wordIndex(toIndex - 1);
            expandTo(endWordIndex);
            long firstWordMask = -1 << fromIndex;
            long lastWordMask = -1 >>> (-toIndex);
            if (startWordIndex == endWordIndex) {
                long[] jArr = this.words;
                jArr[startWordIndex] = jArr[startWordIndex] ^ (firstWordMask & lastWordMask);
            } else {
                long[] jArr2 = this.words;
                jArr2[startWordIndex] = jArr2[startWordIndex] ^ firstWordMask;
                for (int i = startWordIndex + 1; i < endWordIndex; i++) {
                    long[] jArr3 = this.words;
                    jArr3[i] = jArr3[i] ^ -1;
                }
                long[] jArr4 = this.words;
                jArr4[endWordIndex] = jArr4[endWordIndex] ^ lastWordMask;
            }
            recalculateWordsInUse();
            checkInvariants();
        }
    }

    public void set(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        int wordIndex = wordIndex(bitIndex);
        expandTo(wordIndex);
        long[] jArr = this.words;
        jArr[wordIndex] = jArr[wordIndex] | (1 << bitIndex);
        checkInvariants();
    }

    public void set(int bitIndex, boolean value) {
        if (value) {
            set(bitIndex);
        } else {
            clear(bitIndex);
        }
    }

    public void set(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        if (fromIndex != toIndex) {
            int startWordIndex = wordIndex(fromIndex);
            int endWordIndex = wordIndex(toIndex - 1);
            expandTo(endWordIndex);
            long firstWordMask = -1 << fromIndex;
            long lastWordMask = -1 >>> (-toIndex);
            if (startWordIndex == endWordIndex) {
                long[] jArr = this.words;
                jArr[startWordIndex] = jArr[startWordIndex] | (firstWordMask & lastWordMask);
            } else {
                long[] jArr2 = this.words;
                jArr2[startWordIndex] = jArr2[startWordIndex] | firstWordMask;
                for (int i = startWordIndex + 1; i < endWordIndex; i++) {
                    this.words[i] = -1;
                }
                long[] jArr3 = this.words;
                jArr3[endWordIndex] = jArr3[endWordIndex] | lastWordMask;
            }
            checkInvariants();
        }
    }

    public void set(int fromIndex, int toIndex, boolean value) {
        if (value) {
            set(fromIndex, toIndex);
        } else {
            clear(fromIndex, toIndex);
        }
    }

    public void clear(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        int wordIndex = wordIndex(bitIndex);
        if (wordIndex < this.wordsInUse) {
            long[] jArr = this.words;
            jArr[wordIndex] = jArr[wordIndex] & (~(1 << bitIndex));
            recalculateWordsInUse();
            checkInvariants();
        }
    }

    public void clear(int fromIndex, int toIndex) {
        int startWordIndex;
        checkRange(fromIndex, toIndex);
        if (fromIndex != toIndex && (startWordIndex = wordIndex(fromIndex)) < this.wordsInUse) {
            int endWordIndex = wordIndex(toIndex - 1);
            if (endWordIndex >= this.wordsInUse) {
                toIndex = length();
                endWordIndex = this.wordsInUse - 1;
            }
            long firstWordMask = -1 << fromIndex;
            long lastWordMask = -1 >>> (-toIndex);
            if (startWordIndex == endWordIndex) {
                long[] jArr = this.words;
                jArr[startWordIndex] = jArr[startWordIndex] & (~(firstWordMask & lastWordMask));
            } else {
                long[] jArr2 = this.words;
                jArr2[startWordIndex] = jArr2[startWordIndex] & (~firstWordMask);
                for (int i = startWordIndex + 1; i < endWordIndex; i++) {
                    this.words[i] = 0;
                }
                long[] jArr3 = this.words;
                jArr3[endWordIndex] = jArr3[endWordIndex] & (~lastWordMask);
            }
            recalculateWordsInUse();
            checkInvariants();
        }
    }

    public void clear() {
        while (this.wordsInUse > 0) {
            long[] jArr = this.words;
            int i = this.wordsInUse - 1;
            this.wordsInUse = i;
            jArr[i] = 0;
        }
    }

    public boolean get(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        checkInvariants();
        int wordIndex = wordIndex(bitIndex);
        if (wordIndex >= this.wordsInUse || (this.words[wordIndex] & (1 << bitIndex)) == 0) {
            return f34assertionsDisabled;
        }
        return true;
    }

    public BitSet get(int fromIndex, int toIndex) {
        long j;
        long j2;
        checkRange(fromIndex, toIndex);
        checkInvariants();
        int len = length();
        if (len <= fromIndex || fromIndex == toIndex) {
            return new BitSet(0);
        }
        if (toIndex > len) {
            toIndex = len;
        }
        BitSet result = new BitSet(toIndex - fromIndex);
        int targetWords = wordIndex((toIndex - fromIndex) - 1) + 1;
        int sourceIndex = wordIndex(fromIndex);
        boolean wordAligned = (fromIndex & BIT_INDEX_MASK) == 0 ? true : f34assertionsDisabled;
        int i = 0;
        while (i < targetWords - 1) {
            long[] jArr = result.words;
            if (wordAligned) {
                j2 = this.words[sourceIndex];
            } else {
                j2 = (this.words[sourceIndex] >>> fromIndex) | (this.words[sourceIndex + 1] << (-fromIndex));
            }
            jArr[i] = j2;
            i++;
            sourceIndex++;
        }
        long lastWordMask = -1 >>> (-toIndex);
        long[] jArr2 = result.words;
        int i2 = targetWords - 1;
        if (((toIndex - 1) & BIT_INDEX_MASK) < (fromIndex & BIT_INDEX_MASK)) {
            j = (this.words[sourceIndex] >>> fromIndex) | ((this.words[sourceIndex + 1] & lastWordMask) << (-fromIndex));
        } else {
            j = (this.words[sourceIndex] & lastWordMask) >>> fromIndex;
        }
        jArr2[i2] = j;
        result.wordsInUse = targetWords;
        result.recalculateWordsInUse();
        result.checkInvariants();
        return result;
    }

    public int nextSetBit(int fromIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + fromIndex);
        }
        checkInvariants();
        int u = wordIndex(fromIndex);
        if (u >= this.wordsInUse) {
            return -1;
        }
        long word = this.words[u] & (-1 << fromIndex);
        while (word == 0) {
            u++;
            if (u == this.wordsInUse) {
                return -1;
            }
            word = this.words[u];
        }
        return (u * 64) + Long.numberOfTrailingZeros(word);
    }

    public int nextClearBit(int fromIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + fromIndex);
        }
        checkInvariants();
        int u = wordIndex(fromIndex);
        if (u >= this.wordsInUse) {
            return fromIndex;
        }
        long word = (~this.words[u]) & (-1 << fromIndex);
        while (word == 0) {
            u++;
            if (u == this.wordsInUse) {
                return this.wordsInUse * 64;
            }
            word = ~this.words[u];
        }
        return (u * 64) + Long.numberOfTrailingZeros(word);
    }

    public int previousSetBit(int fromIndex) {
        if (fromIndex >= 0) {
            checkInvariants();
            int u = wordIndex(fromIndex);
            if (u >= this.wordsInUse) {
                return length() - 1;
            }
            long word = this.words[u] & (-1 >>> (-(fromIndex + 1)));
            while (true) {
                int u2 = u;
                if (word != 0) {
                    return (((u2 + 1) * 64) - 1) - Long.numberOfLeadingZeros(word);
                }
                u = u2 - 1;
                if (u2 == 0) {
                    return -1;
                }
                word = this.words[u];
            }
        } else if (fromIndex == -1) {
            return -1;
        } else {
            throw new IndexOutOfBoundsException("fromIndex < -1: " + fromIndex);
        }
    }

    public int previousClearBit(int fromIndex) {
        if (fromIndex >= 0) {
            checkInvariants();
            int u = wordIndex(fromIndex);
            if (u >= this.wordsInUse) {
                return fromIndex;
            }
            long word = (~this.words[u]) & (-1 >>> (-(fromIndex + 1)));
            while (true) {
                int u2 = u;
                if (word != 0) {
                    return (((u2 + 1) * 64) - 1) - Long.numberOfLeadingZeros(word);
                }
                u = u2 - 1;
                if (u2 == 0) {
                    return -1;
                }
                word = ~this.words[u];
            }
        } else if (fromIndex == -1) {
            return -1;
        } else {
            throw new IndexOutOfBoundsException("fromIndex < -1: " + fromIndex);
        }
    }

    public int length() {
        if (this.wordsInUse == 0) {
            return 0;
        }
        return ((this.wordsInUse - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.words[this.wordsInUse - 1]));
    }

    public boolean isEmpty() {
        if (this.wordsInUse == 0) {
            return true;
        }
        return f34assertionsDisabled;
    }

    public boolean intersects(BitSet set) {
        for (int i = Math.min(this.wordsInUse, set.wordsInUse) - 1; i >= 0; i--) {
            if ((this.words[i] & set.words[i]) != 0) {
                return true;
            }
        }
        return f34assertionsDisabled;
    }

    public int cardinality() {
        int sum = 0;
        for (int i = 0; i < this.wordsInUse; i++) {
            sum += Long.bitCount(this.words[i]);
        }
        return sum;
    }

    public void and(BitSet set) {
        if (this != set) {
            while (this.wordsInUse > set.wordsInUse) {
                long[] jArr = this.words;
                int i = this.wordsInUse - 1;
                this.wordsInUse = i;
                jArr[i] = 0;
            }
            for (int i2 = 0; i2 < this.wordsInUse; i2++) {
                long[] jArr2 = this.words;
                jArr2[i2] = jArr2[i2] & set.words[i2];
            }
            recalculateWordsInUse();
            checkInvariants();
        }
    }

    public void or(BitSet set) {
        if (this != set) {
            int wordsInCommon = Math.min(this.wordsInUse, set.wordsInUse);
            if (this.wordsInUse < set.wordsInUse) {
                ensureCapacity(set.wordsInUse);
                this.wordsInUse = set.wordsInUse;
            }
            for (int i = 0; i < wordsInCommon; i++) {
                long[] jArr = this.words;
                jArr[i] = jArr[i] | set.words[i];
            }
            if (wordsInCommon < set.wordsInUse) {
                System.arraycopy(set.words, wordsInCommon, this.words, wordsInCommon, this.wordsInUse - wordsInCommon);
            }
            checkInvariants();
        }
    }

    public void xor(BitSet set) {
        int wordsInCommon = Math.min(this.wordsInUse, set.wordsInUse);
        if (this.wordsInUse < set.wordsInUse) {
            ensureCapacity(set.wordsInUse);
            this.wordsInUse = set.wordsInUse;
        }
        for (int i = 0; i < wordsInCommon; i++) {
            long[] jArr = this.words;
            jArr[i] = jArr[i] ^ set.words[i];
        }
        if (wordsInCommon < set.wordsInUse) {
            System.arraycopy(set.words, wordsInCommon, this.words, wordsInCommon, set.wordsInUse - wordsInCommon);
        }
        recalculateWordsInUse();
        checkInvariants();
    }

    public void andNot(BitSet set) {
        for (int i = Math.min(this.wordsInUse, set.wordsInUse) - 1; i >= 0; i--) {
            long[] jArr = this.words;
            jArr[i] = jArr[i] & (~set.words[i]);
        }
        recalculateWordsInUse();
        checkInvariants();
    }

    public int hashCode() {
        long h = 1234;
        int i = this.wordsInUse;
        while (true) {
            i--;
            if (i < 0) {
                return (int) ((h >> 32) ^ h);
            }
            h ^= this.words[i] * ((long) (i + 1));
        }
    }

    public int size() {
        return this.words.length * 64;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitSet)) {
            return f34assertionsDisabled;
        }
        if (this == obj) {
            return true;
        }
        BitSet set = (BitSet) obj;
        checkInvariants();
        set.checkInvariants();
        if (this.wordsInUse != set.wordsInUse) {
            return f34assertionsDisabled;
        }
        for (int i = 0; i < this.wordsInUse; i++) {
            if (this.words[i] != set.words[i]) {
                return f34assertionsDisabled;
            }
        }
        return true;
    }

    public Object clone() {
        if (!this.sizeIsSticky) {
            trimToSize();
        }
        try {
            BitSet result = (BitSet) super.clone();
            result.words = (long[]) this.words.clone();
            result.checkInvariants();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void trimToSize() {
        if (this.wordsInUse != this.words.length) {
            this.words = Arrays.copyOf(this.words, this.wordsInUse);
            checkInvariants();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        checkInvariants();
        if (!this.sizeIsSticky) {
            trimToSize();
        }
        s.putFields().put("bits", (Object) this.words);
        s.writeFields();
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        boolean z;
        this.words = (long[]) s.readFields().get("bits", (Object) null);
        this.wordsInUse = this.words.length;
        recalculateWordsInUse();
        if (this.words.length <= 0 || this.words[this.words.length - 1] != 0) {
            z = false;
        } else {
            z = true;
        }
        this.sizeIsSticky = z;
        checkInvariants();
    }

    public String toString() {
        checkInvariants();
        StringBuilder b = new StringBuilder(((this.wordsInUse > 128 ? cardinality() : this.wordsInUse * 64) * 6) + 2);
        b.append('{');
        int i = nextSetBit(0);
        if (i != -1) {
            b.append(i);
            int i2 = nextSetBit(i + 1);
            while (i2 >= 0) {
                int endOfRun = nextClearBit(i2);
                do {
                    b.append(", ").append(i2);
                    i2++;
                } while (i2 < endOfRun);
                i2 = nextSetBit(i2 + 1);
            }
        }
        b.append('}');
        return b.toString();
    }

    public IntStream stream() {
        return StreamSupport.intStream(new java_util_stream_IntStream_stream__LambdaImpl0(this), 16469, f34assertionsDisabled);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: -java_util_BitSet_lambda$1  reason: not valid java name */
    public /* synthetic */ Spliterator.OfInt m199java_util_BitSet_lambda$1() {
        return Spliterators.spliterator((PrimitiveIterator.OfInt) new PrimitiveIterator.OfInt(this) {
            int next;
            final /* synthetic */ BitSet this$0;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.BitSet.1BitSetIterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.BitSet.1BitSetIterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.BitSet.AnonymousClass1BitSetIterator.forEachRemaining(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.BitSet.1BitSetIterator.hasNext():boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 6 more
                */
            public boolean hasNext() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.BitSet.1BitSetIterator.hasNext():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.BitSet.AnonymousClass1BitSetIterator.hasNext():boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.BitSet.1BitSetIterator.nextInt():int, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 6 more
                */
            public int nextInt() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.BitSet.1BitSetIterator.nextInt():int, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.BitSet.AnonymousClass1BitSetIterator.nextInt():int");
            }

            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }
        }, (long) cardinality(), 21);
    }
}
