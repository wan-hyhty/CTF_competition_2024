package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;
import sun.misc.Unsafe;

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
public class Random implements Serializable {
    static final String BadBound = "bound must be positive";
    static final String BadRange = "bound must be greater than origin";
    static final String BadSize = "size must be non-negative";
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16d;
    private static final long addend = 11;
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static final long seedOffset = 0;
    private static final AtomicLong seedUniquifier = null;
    private static final ObjectStreamField[] serialPersistentFields = null;
    static final long serialVersionUID = 3905348978240129619L;
    private static final Unsafe unsafe = null;
    private boolean haveNextNextGaussian;
    private double nextNextGaussian;
    private final AtomicLong seed;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Random.<clinit>():void");
    }

    public Random() {
        this(seedUniquifier() ^ System.nanoTime());
    }

    private static long seedUniquifier() {
        long current;
        long next;
        do {
            current = seedUniquifier.get();
            next = current * 181783497276652981L;
        } while (!seedUniquifier.compareAndSet(current, next));
        return next;
    }

    public Random(long seed2) {
        this.haveNextNextGaussian = false;
        if (getClass() == Random.class) {
            this.seed = new AtomicLong(initialScramble(seed2));
            return;
        }
        this.seed = new AtomicLong();
        setSeed(seed2);
    }

    private static long initialScramble(long seed2) {
        return (multiplier ^ seed2) & mask;
    }

    public synchronized void setSeed(long seed2) {
        this.seed.set(initialScramble(seed2));
        this.haveNextNextGaussian = false;
    }

    /* access modifiers changed from: protected */
    public int next(int bits) {
        long oldseed;
        long nextseed;
        AtomicLong seed2 = this.seed;
        do {
            oldseed = seed2.get();
            nextseed = ((multiplier * oldseed) + addend) & mask;
        } while (!seed2.compareAndSet(oldseed, nextseed));
        return (int) (nextseed >>> (48 - bits));
    }

    public void nextBytes(byte[] bytes) {
        int i;
        int i2 = 0;
        int len = bytes.length;
        while (i2 < len) {
            int rnd = nextInt();
            int n = Math.min(len - i2, 4);
            while (true) {
                int n2 = n;
                i = i2;
                n = n2 - 1;
                if (n2 <= 0) {
                    break;
                }
                i2 = i + 1;
                bytes[i] = (byte) rnd;
                rnd >>= 8;
            }
            i2 = i;
        }
    }

    /* access modifiers changed from: package-private */
    public final long internalNextLong(long origin, long bound) {
        long r = nextLong();
        if (origin >= bound) {
            return r;
        }
        long n = bound - origin;
        long m = n - 1;
        if ((n & m) == seedOffset) {
            return (r & m) + origin;
        }
        if (n > seedOffset) {
            long u = r >>> 1;
            while (true) {
                long r2 = u % n;
                if ((u + m) - r2 >= seedOffset) {
                    return r2 + origin;
                }
                u = nextLong() >>> 1;
            }
        } else {
            while (true) {
                if (r >= origin && r < bound) {
                    return r;
                }
                r = nextLong();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int internalNextInt(int origin, int bound) {
        if (origin >= bound) {
            return nextInt();
        }
        int n = bound - origin;
        if (n > 0) {
            return nextInt(n) + origin;
        }
        while (true) {
            int r = nextInt();
            if (r >= origin && r < bound) {
                return r;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final double internalNextDouble(double origin, double bound) {
        double r = nextDouble();
        if (origin >= bound) {
            return r;
        }
        double r2 = ((bound - origin) * r) + origin;
        if (r2 >= bound) {
            return Double.longBitsToDouble(Double.doubleToLongBits(bound) - 1);
        }
        return r2;
    }

    public int nextInt() {
        return next(32);
    }

    public int nextInt(int n) {
        int bits;
        int val;
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        } else if (((-n) & n) == n) {
            return (int) ((((long) n) * ((long) next(31))) >> 31);
        } else {
            do {
                bits = next(31);
                val = bits % n;
            } while ((bits - val) + (n - 1) < 0);
            return val;
        }
    }

    public long nextLong() {
        return (((long) next(32)) << 32) + ((long) next(32));
    }

    public boolean nextBoolean() {
        return next(1) != 0;
    }

    public float nextFloat() {
        return ((float) next(24)) / 1.6777216E7f;
    }

    public double nextDouble() {
        return ((double) ((((long) next(26)) << 27) + ((long) next(27)))) / 9.007199254740992E15d;
    }

    public synchronized double nextGaussian() {
        if (this.haveNextNextGaussian) {
            this.haveNextNextGaussian = false;
            return this.nextNextGaussian;
        }
        while (true) {
            double v1 = (nextDouble() * 2.0d) - 1.0d;
            double v2 = (nextDouble() * 2.0d) - 1.0d;
            double s = (v1 * v1) + (v2 * v2);
            if (s < 1.0d && s != 0.0d) {
                double multiplier2 = StrictMath.sqrt((StrictMath.log(s) * -2.0d) / s);
                this.nextNextGaussian = v2 * multiplier2;
                this.haveNextNextGaussian = true;
                return v1 * multiplier2;
            }
        }
    }

    public IntStream ints(long streamSize) {
        if (streamSize >= seedOffset) {
            return StreamSupport.intStream(new RandomIntsSpliterator(this, seedOffset, streamSize, Integer.MAX_VALUE, 0), false);
        }
        throw new IllegalArgumentException(BadSize);
    }

    public IntStream ints() {
        return StreamSupport.intStream(new RandomIntsSpliterator(this, seedOffset, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false);
    }

    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        if (streamSize < seedOffset) {
            throw new IllegalArgumentException(BadSize);
        } else if (randomNumberOrigin < randomNumberBound) {
            return StreamSupport.intStream(new RandomIntsSpliterator(this, seedOffset, streamSize, randomNumberOrigin, randomNumberBound), false);
        } else {
            throw new IllegalArgumentException(BadRange);
        }
    }

    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        if (randomNumberOrigin < randomNumberBound) {
            return StreamSupport.intStream(new RandomIntsSpliterator(this, seedOffset, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
        }
        throw new IllegalArgumentException(BadRange);
    }

    public LongStream longs(long streamSize) {
        if (streamSize >= seedOffset) {
            return StreamSupport.longStream(new RandomLongsSpliterator(this, seedOffset, streamSize, Long.MAX_VALUE, seedOffset), false);
        }
        throw new IllegalArgumentException(BadSize);
    }

    public LongStream longs() {
        return StreamSupport.longStream(new RandomLongsSpliterator(this, seedOffset, Long.MAX_VALUE, Long.MAX_VALUE, seedOffset), false);
    }

    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        if (streamSize < seedOffset) {
            throw new IllegalArgumentException(BadSize);
        } else if (randomNumberOrigin < randomNumberBound) {
            return StreamSupport.longStream(new RandomLongsSpliterator(this, seedOffset, streamSize, randomNumberOrigin, randomNumberBound), false);
        } else {
            throw new IllegalArgumentException(BadRange);
        }
    }

    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        if (randomNumberOrigin < randomNumberBound) {
            return StreamSupport.longStream(new RandomLongsSpliterator(this, seedOffset, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
        }
        throw new IllegalArgumentException(BadRange);
    }

    public DoubleStream doubles(long streamSize) {
        if (streamSize >= seedOffset) {
            return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, seedOffset, streamSize, Double.MAX_VALUE, 0.0d), false);
        }
        throw new IllegalArgumentException(BadSize);
    }

    public DoubleStream doubles() {
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, seedOffset, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d), false);
    }

    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        if (streamSize < seedOffset) {
            throw new IllegalArgumentException(BadSize);
        }
        if (randomNumberOrigin < randomNumberBound) {
            return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, seedOffset, streamSize, randomNumberOrigin, randomNumberBound), false);
        }
        throw new IllegalArgumentException(BadRange);
    }

    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        boolean z;
        if (randomNumberOrigin < randomNumberBound) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, seedOffset, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
        }
        throw new IllegalArgumentException(BadRange);
    }

    static final class RandomIntsSpliterator implements Spliterator.OfInt {
        final int bound;
        final long fence;
        long index;
        final int origin;
        final Random rng;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Random.RandomIntsSpliterator.<init>(java.util.Random, long, long, int, int):void, dex: classes.dex
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
        RandomIntsSpliterator(java.util.Random r1, long r2, long r4, int r6, int r7) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Random.RandomIntsSpliterator.<init>(java.util.Random, long, long, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.<init>(java.util.Random, long, long, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.Random.RandomIntsSpliterator.estimateSize():long, dex: classes.dex in method: java.util.Random.RandomIntsSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.Random.RandomIntsSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:72)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.Random.RandomIntsSpliterator.estimateSize():long, dex: classes.dex in method: java.util.Random.RandomIntsSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomIntsSpliterator.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void forEachRemaining(java.util.function.IntConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomIntsSpliterator.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.forEachRemaining(java.util.function.IntConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ boolean tryAdvance(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.tryAdvance(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomIntsSpliterator.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean tryAdvance(java.util.function.IntConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomIntsSpliterator.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.tryAdvance(java.util.function.IntConsumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Random$RandomIntsSpliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public java.util.Random.RandomIntsSpliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Random$RandomIntsSpliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Random$RandomIntsSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator.OfInt trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator$OfInt");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator$OfPrimitive");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomIntsSpliterator.trySplit():java.util.Spliterator");
        }

        public int characteristics() {
            return 17728;
        }
    }

    static final class RandomLongsSpliterator implements Spliterator.OfLong {
        final long bound;
        final long fence;
        long index;
        final long origin;
        final Random rng;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Random.RandomLongsSpliterator.<init>(java.util.Random, long, long, long, long):void, dex: classes.dex
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
        RandomLongsSpliterator(java.util.Random r1, long r2, long r4, long r6, long r8) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Random.RandomLongsSpliterator.<init>(java.util.Random, long, long, long, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.<init>(java.util.Random, long, long, long, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void forEachRemaining(java.util.function.LongConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.forEachRemaining(java.util.function.LongConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ boolean tryAdvance(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.tryAdvance(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean tryAdvance(java.util.function.LongConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.tryAdvance(java.util.function.LongConsumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Random$RandomLongsSpliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public java.util.Random.RandomLongsSpliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Random$RandomLongsSpliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Random$RandomLongsSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator.OfLong trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator$OfLong");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator$OfPrimitive");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomLongsSpliterator.trySplit():java.util.Spliterator");
        }

        public int characteristics() {
            return 17728;
        }
    }

    static final class RandomDoublesSpliterator implements Spliterator.OfDouble {
        final double bound;
        final long fence;
        long index;
        final double origin;
        final Random rng;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Random.RandomDoublesSpliterator.<init>(java.util.Random, long, long, double, double):void, dex: classes.dex
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
        RandomDoublesSpliterator(java.util.Random r1, long r2, long r4, double r6, double r8) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Random.RandomDoublesSpliterator.<init>(java.util.Random, long, long, double, double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.<init>(java.util.Random, long, long, double, double):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.Random.RandomDoublesSpliterator.estimateSize():long, dex: classes.dex in method: java.util.Random.RandomDoublesSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.Random.RandomDoublesSpliterator.estimateSize():long, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:72)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.Random.RandomDoublesSpliterator.estimateSize():long, dex: classes.dex in method: java.util.Random.RandomDoublesSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomDoublesSpliterator.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void forEachRemaining(java.util.function.DoubleConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomDoublesSpliterator.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.forEachRemaining(java.util.function.DoubleConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ boolean tryAdvance(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.tryAdvance(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomDoublesSpliterator.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean tryAdvance(java.util.function.DoubleConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomDoublesSpliterator.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.tryAdvance(java.util.function.DoubleConsumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Random$RandomDoublesSpliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public java.util.Random.RandomDoublesSpliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Random$RandomDoublesSpliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Random$RandomDoublesSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator.OfDouble trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator$OfDouble");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator$OfPrimitive");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Random.RandomDoublesSpliterator.trySplit():java.util.Spliterator");
        }

        public int characteristics() {
            return 17728;
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s.readFields();
        long seedVal = fields.get("seed", -1);
        if (seedVal < seedOffset) {
            throw new StreamCorruptedException("Random: invalid seed");
        }
        resetSeed(seedVal);
        this.nextNextGaussian = fields.get("nextNextGaussian", 0.0d);
        this.haveNextNextGaussian = fields.get("haveNextNextGaussian", false);
    }

    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        ObjectOutputStream.PutField fields = s.putFields();
        fields.put("seed", this.seed.get());
        fields.put("nextNextGaussian", this.nextNextGaussian);
        fields.put("haveNextNextGaussian", this.haveNextNextGaussian);
        s.writeFields();
    }

    private void resetSeed(long seedVal) {
        unsafe.putObjectVolatile(this, seedOffset, new AtomicLong(seedVal));
    }
}
