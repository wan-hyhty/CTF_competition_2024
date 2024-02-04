package java.util.stream;

import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Sink;
import java.util.stream.SpinedBuffer;

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
class StreamSpliterators {

    private static abstract class AbstractWrappingSpliterator<P_IN, P_OUT, T_BUFFER extends AbstractSpinedBuffer> implements Spliterator<P_OUT> {
        T_BUFFER buffer;
        Sink<P_IN> bufferSink;
        boolean finished;
        final boolean isParallel;
        long nextToConsume;
        final PipelineHelper<P_OUT> ph;
        BooleanSupplier pusher;
        Spliterator<P_IN> spliterator;
        private Supplier<Spliterator<P_IN>> spliteratorSupplier;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        AbstractWrappingSpliterator(java.util.stream.PipelineHelper<P_OUT> r1, java.util.Spliterator<P_IN> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        AbstractWrappingSpliterator(java.util.stream.PipelineHelper<P_OUT> r1, java.util.function.Supplier<java.util.Spliterator<P_IN>> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.fillBuffer():boolean, dex: classes.dex
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
        private boolean fillBuffer() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.fillBuffer():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.fillBuffer():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.characteristics():int, dex: classes.dex
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
        public final int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.doAdvance():boolean, dex: classes.dex
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
        final boolean doAdvance() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.doAdvance():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.doAdvance():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.estimateSize():long, dex: classes.dex
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
        public final long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.getComparator():java.util.Comparator<? super P_OUT>, dex: classes.dex
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
        public java.util.Comparator<? super P_OUT> getComparator() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.getComparator():java.util.Comparator<? super P_OUT>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.getComparator():java.util.Comparator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.getExactSizeIfKnown():long, dex: classes.dex
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
        public final long getExactSizeIfKnown() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.getExactSizeIfKnown():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.getExactSizeIfKnown():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.init():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.init():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.init():void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        final void init() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.init():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.init():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.init():void");
        }

        /* access modifiers changed from: package-private */
        public abstract void initPartialTraversalState();

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.toString():java.lang.String, dex: classes.dex
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
        public final java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.toString():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.trySplit():java.util.Spliterator<P_OUT>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public java.util.Spliterator<P_OUT> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.trySplit():java.util.Spliterator<P_OUT>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.AbstractWrappingSpliterator.trySplit():java.util.Spliterator");
        }

        /* access modifiers changed from: package-private */
        public abstract AbstractWrappingSpliterator<P_IN, P_OUT, ?> wrap(Spliterator<P_IN> spliterator2);
    }

    static abstract class ArrayBuffer {
        int index;

        static final class OfDouble extends OfPrimitive<DoubleConsumer> implements DoubleConsumer {
            final double[] array;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.<init>(int):void, dex: classes.dex
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
            OfDouble(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.<init>(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.<init>(int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.accept(double):void, dex: classes.dex
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
            public void accept(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.accept(double):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.forEach(java.lang.Object, long):void, dex: classes.dex
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
            /* bridge */ /* synthetic */ void forEach(java.lang.Object r1, long r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.forEach(java.lang.Object, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.forEach(java.lang.Object, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.forEach(java.util.function.DoubleConsumer, long):void, dex: classes.dex
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
            void forEach(java.util.function.DoubleConsumer r1, long r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.forEach(java.util.function.DoubleConsumer, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfDouble.forEach(java.util.function.DoubleConsumer, long):void");
            }
        }

        static final class OfInt extends OfPrimitive<IntConsumer> implements IntConsumer {
            final int[] array;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.<init>(int):void, dex: classes.dex
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
            OfInt(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.<init>(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.<init>(int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.accept(int):void, dex: classes.dex
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
            public void accept(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.accept(int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.forEach(java.lang.Object, long):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEach(java.lang.Object r1, long r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.forEach(java.lang.Object, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.forEach(java.lang.Object, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.forEach(java.util.function.IntConsumer, long):void, dex: classes.dex
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
            public void forEach(java.util.function.IntConsumer r1, long r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.forEach(java.util.function.IntConsumer, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfInt.forEach(java.util.function.IntConsumer, long):void");
            }
        }

        static final class OfLong extends OfPrimitive<LongConsumer> implements LongConsumer {
            final long[] array;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.<init>(int):void, dex: classes.dex
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
            OfLong(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.<init>(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.<init>(int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.accept(long):void, dex: classes.dex
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
            public void accept(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.accept(long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.forEach(java.lang.Object, long):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEach(java.lang.Object r1, long r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.forEach(java.lang.Object, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.forEach(java.lang.Object, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.forEach(java.util.function.LongConsumer, long):void, dex: classes.dex
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
            public void forEach(java.util.function.LongConsumer r1, long r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.forEach(java.util.function.LongConsumer, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfLong.forEach(java.util.function.LongConsumer, long):void");
            }
        }

        static abstract class OfPrimitive<T_CONS> extends ArrayBuffer {
            int index;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive.<init>():void, dex: classes.dex
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
            OfPrimitive() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive.<init>():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive.<init>():void");
            }

            /* access modifiers changed from: package-private */
            public abstract void forEach(T_CONS t_cons, long j);

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive.reset():void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            void reset() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive.reset():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive.reset():void");
            }
        }

        static final class OfRef<T> extends ArrayBuffer implements Consumer<T> {
            final Object[] array;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.<init>(int):void, dex: classes.dex
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
            OfRef(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.<init>(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.<init>(int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.accept(java.lang.Object):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.accept(java.lang.Object):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.accept(java.lang.Object):void, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:61)
                	at com.android.dx.io.instructions.InstructionCodec$34.decode(InstructionCodec.java:752)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            public void accept(T r1) {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.accept(java.lang.Object):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.accept(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.accept(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.forEach(java.util.function.Consumer, long):void, dex: classes.dex
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
            public void forEach(java.util.function.Consumer<? super T> r1, long r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.forEach(java.util.function.Consumer, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.OfRef.forEach(java.util.function.Consumer, long):void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.ArrayBuffer.<init>():void, dex: classes.dex
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
        ArrayBuffer() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.ArrayBuffer.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: java.util.stream.StreamSpliterators.ArrayBuffer.reset():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        void reset() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: java.util.stream.StreamSpliterators.ArrayBuffer.reset():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.ArrayBuffer.reset():void");
        }
    }

    static class DelegatingSpliterator<T, T_SPLITR extends Spliterator<T>> implements Spliterator<T> {
        private T_SPLITR s;
        private final Supplier<? extends T_SPLITR> supplier;

        static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, Spliterator.OfDouble> implements Spliterator.OfDouble {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.<init>(java.util.function.Supplier):void, dex: classes.dex
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
            OfDouble(java.util.function.Supplier<java.util.Spliterator.OfDouble> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.<init>(java.util.function.Supplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.<init>(java.util.function.Supplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfDouble trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble");
            }
        }

        static final class OfInt extends OfPrimitive<Integer, IntConsumer, Spliterator.OfInt> implements Spliterator.OfInt {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.<init>(java.util.function.Supplier):void, dex: classes.dex
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
            OfInt(java.util.function.Supplier<java.util.Spliterator.OfInt> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.<init>(java.util.function.Supplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.<init>(java.util.function.Supplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfInt trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt");
            }
        }

        static final class OfLong extends OfPrimitive<Long, LongConsumer, Spliterator.OfLong> implements Spliterator.OfLong {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.<init>(java.util.function.Supplier):void, dex: classes.dex
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
            OfLong(java.util.function.Supplier<java.util.Spliterator.OfLong> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.<init>(java.util.function.Supplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.<init>(java.util.function.Supplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfLong trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong");
            }
        }

        static class OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends DelegatingSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.<init>(java.util.function.Supplier):void, dex: classes.dex
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
            OfPrimitive(java.util.function.Supplier<? extends T_SPLITR> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.<init>(java.util.function.Supplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.<init>(java.util.function.Supplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            public void forEachRemaining(T_CONS r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            public boolean tryAdvance(T_CONS r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.<init>(java.util.function.Supplier):void, dex: classes.dex
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
        DelegatingSpliterator(java.util.function.Supplier<? extends T_SPLITR> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.<init>(java.util.function.Supplier):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.<init>(java.util.function.Supplier):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.characteristics():int, dex: classes.dex
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
        public int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.estimateSize():long, dex: classes.dex
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
        public long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super T> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.get():T_SPLITR, dex: classes.dex
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
        T_SPLITR get() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.get():T_SPLITR, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.get():java.util.Spliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.getComparator():java.util.Comparator<? super T>, dex: classes.dex
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
        public java.util.Comparator<? super T> getComparator() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.getComparator():java.util.Comparator<? super T>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.getComparator():java.util.Comparator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.getExactSizeIfKnown():long, dex: classes.dex
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
        public long getExactSizeIfKnown() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.getExactSizeIfKnown():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.getExactSizeIfKnown():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.toString():java.lang.String, dex: classes.dex
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
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.toString():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super T> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.trySplit():T_SPLITR, dex: classes.dex
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
        public T_SPLITR trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DelegatingSpliterator.trySplit():T_SPLITR, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DelegatingSpliterator.trySplit():java.util.Spliterator");
        }
    }

    static final class WrappingSpliterator<P_IN, P_OUT> extends AbstractWrappingSpliterator<P_IN, P_OUT, SpinedBuffer<P_OUT>> {

        /* renamed from: java.util.stream.StreamSpliterators$WrappingSpliterator$-void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0 implements Sink {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ Consumer f98val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0(java.util.function.Consumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0.<init>(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0.<init>(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
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
            public void accept(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.void_forEachRemaining_java_util_function_Consumer_consumer_LambdaImpl0.accept(java.lang.Object):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$WrappingSpliterator$-void_initPartialTraversalState__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl0 implements Sink {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ SpinedBuffer f99val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl0(java.util.stream.SpinedBuffer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
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
            public void accept(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.accept(java.lang.Object):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$WrappingSpliterator$-void_initPartialTraversalState__LambdaImpl1  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl1 implements BooleanSupplier {
            private /* synthetic */ WrappingSpliterator val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$WrappingSpliterator):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl1(java.util.stream.StreamSpliterators.WrappingSpliterator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$WrappingSpliterator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$WrappingSpliterator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
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
            public boolean getAsBoolean() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-java_util_stream_StreamSpliterators$WrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer, java.lang.Object):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$WrappingSpliterator-mthref-0 */
        static /* synthetic */ void m611java_util_stream_StreamSpliterators$WrappingSpliteratormthref0(java.util.stream.SpinedBuffer r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-java_util_stream_StreamSpliterators$WrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.m611java_util_stream_StreamSpliterators$WrappingSpliteratormthref0(java.util.stream.SpinedBuffer, java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-java_util_stream_StreamSpliterators$WrappingSpliterator-mthref-1(java.util.function.Consumer, java.lang.Object):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$WrappingSpliterator-mthref-1 */
        static /* synthetic */ void m612java_util_stream_StreamSpliterators$WrappingSpliteratormthref1(java.util.function.Consumer r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-java_util_stream_StreamSpliterators$WrappingSpliterator-mthref-1(java.util.function.Consumer, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.m612java_util_stream_StreamSpliterators$WrappingSpliteratormthref1(java.util.function.Consumer, java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
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
        WrappingSpliterator(java.util.stream.PipelineHelper<P_OUT> r1, java.util.Spliterator<P_IN> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
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
        WrappingSpliterator(java.util.stream.PipelineHelper<P_OUT> r1, java.util.function.Supplier<java.util.Spliterator<P_IN>> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-java_util_stream_StreamSpliterators$WrappingSpliterator_lambda$2():boolean, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$WrappingSpliterator_lambda$2 */
        /* synthetic */ boolean m613java_util_stream_StreamSpliterators$WrappingSpliterator_lambda$2() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.-java_util_stream_StreamSpliterators$WrappingSpliterator_lambda$2():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.m613java_util_stream_StreamSpliterators$WrappingSpliterator_lambda$2():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super P_OUT> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.WrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.WrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.WrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        void initPartialTraversalState() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.WrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.WrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.initPartialTraversalState():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super P_OUT> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator, dex: classes.dex in method: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        /* bridge */ /* synthetic */ java.util.stream.StreamSpliterators.AbstractWrappingSpliterator wrap(java.util.Spliterator r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator, dex: classes.dex in method: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$WrappingSpliterator<P_IN, P_OUT>, dex: classes.dex
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
        java.util.stream.StreamSpliterators.WrappingSpliterator<P_IN, P_OUT> wrap(java.util.Spliterator<P_IN> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$WrappingSpliterator<P_IN, P_OUT>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.WrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$WrappingSpliterator");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.<init>():void, dex: classes.dex
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
    StreamSpliterators() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.<init>():void");
    }

    static final class IntWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Integer, SpinedBuffer.OfInt> implements Spliterator.OfInt {

        /* renamed from: java.util.stream.StreamSpliterators$IntWrappingSpliterator$-void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0 implements Sink.OfInt {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ IntConsumer f92val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0.<init>(java.util.function.IntConsumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0.<init>(java.util.function.IntConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0.<init>(java.util.function.IntConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0.accept(int):void, dex: classes.dex
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
            public void accept(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.void_forEachRemaining_java_util_function_IntConsumer_consumer_LambdaImpl0.accept(int):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$IntWrappingSpliterator$-void_initPartialTraversalState__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl0 implements Sink.OfInt {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ SpinedBuffer.OfInt f93val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfInt):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl0(java.util.stream.SpinedBuffer.OfInt r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfInt):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfInt):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(int):void, dex: classes.dex
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
            public void accept(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.accept(int):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$IntWrappingSpliterator$-void_initPartialTraversalState__LambdaImpl1  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl1 implements BooleanSupplier {
            private /* synthetic */ IntWrappingSpliterator val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$IntWrappingSpliterator):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl1(java.util.stream.StreamSpliterators.IntWrappingSpliterator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$IntWrappingSpliterator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$IntWrappingSpliterator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
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
            public boolean getAsBoolean() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-java_util_stream_StreamSpliterators$IntWrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer$OfInt, int):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$IntWrappingSpliterator-mthref-0 */
        static /* synthetic */ void m600java_util_stream_StreamSpliterators$IntWrappingSpliteratormthref0(java.util.stream.SpinedBuffer.OfInt r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-java_util_stream_StreamSpliterators$IntWrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer$OfInt, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.m600java_util_stream_StreamSpliterators$IntWrappingSpliteratormthref0(java.util.stream.SpinedBuffer$OfInt, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-java_util_stream_StreamSpliterators$IntWrappingSpliterator-mthref-1(java.util.function.IntConsumer, int):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$IntWrappingSpliterator-mthref-1 */
        static /* synthetic */ void m601java_util_stream_StreamSpliterators$IntWrappingSpliteratormthref1(java.util.function.IntConsumer r1, int r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-java_util_stream_StreamSpliterators$IntWrappingSpliterator-mthref-1(java.util.function.IntConsumer, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.m601java_util_stream_StreamSpliterators$IntWrappingSpliteratormthref1(java.util.function.IntConsumer, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
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
        IntWrappingSpliterator(java.util.stream.PipelineHelper<java.lang.Integer> r1, java.util.Spliterator<P_IN> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
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
        IntWrappingSpliterator(java.util.stream.PipelineHelper<java.lang.Integer> r1, java.util.function.Supplier<java.util.Spliterator<P_IN>> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-java_util_stream_StreamSpliterators$IntWrappingSpliterator_lambda$5():boolean, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$IntWrappingSpliterator_lambda$5 */
        /* synthetic */ boolean m602java_util_stream_StreamSpliterators$IntWrappingSpliterator_lambda$5() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.-java_util_stream_StreamSpliterators$IntWrappingSpliterator_lambda$5():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.m602java_util_stream_StreamSpliterators$IntWrappingSpliterator_lambda$5():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.IntConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.forEachRemaining(java.util.function.IntConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        void initPartialTraversalState() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.initPartialTraversalState():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.tryAdvance(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.IntConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.tryAdvance(java.util.function.IntConsumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.trySplit():java.util.Spliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator<P_IN, java.lang.Integer, ?>, dex: classes.dex
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
        java.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Integer, ?> wrap(java.util.Spliterator<P_IN> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.IntWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator<P_IN, java.lang.Integer, ?>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.IntWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator");
        }

        public Spliterator.OfInt trySplit() {
            return (Spliterator.OfInt) super.trySplit();
        }
    }

    static final class LongWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Long, SpinedBuffer.OfLong> implements Spliterator.OfLong {

        /* renamed from: java.util.stream.StreamSpliterators$LongWrappingSpliterator$-void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0 implements Sink.OfLong {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ LongConsumer f94val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0.<init>(java.util.function.LongConsumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0.<init>(java.util.function.LongConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0.<init>(java.util.function.LongConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0.accept(long):void, dex: classes.dex
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
            public void accept(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.void_forEachRemaining_java_util_function_LongConsumer_consumer_LambdaImpl0.accept(long):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$LongWrappingSpliterator$-void_initPartialTraversalState__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl0 implements Sink.OfLong {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ SpinedBuffer.OfLong f95val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfLong):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl0(java.util.stream.SpinedBuffer.OfLong r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfLong):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfLong):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(long):void, dex: classes.dex
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
            public void accept(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.accept(long):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$LongWrappingSpliterator$-void_initPartialTraversalState__LambdaImpl1  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl1 implements BooleanSupplier {
            private /* synthetic */ LongWrappingSpliterator val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$LongWrappingSpliterator):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl1(java.util.stream.StreamSpliterators.LongWrappingSpliterator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$LongWrappingSpliterator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$LongWrappingSpliterator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
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
            public boolean getAsBoolean() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-java_util_stream_StreamSpliterators$LongWrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer$OfLong, long):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$LongWrappingSpliterator-mthref-0 */
        static /* synthetic */ void m603java_util_stream_StreamSpliterators$LongWrappingSpliteratormthref0(java.util.stream.SpinedBuffer.OfLong r1, long r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-java_util_stream_StreamSpliterators$LongWrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer$OfLong, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.m603java_util_stream_StreamSpliterators$LongWrappingSpliteratormthref0(java.util.stream.SpinedBuffer$OfLong, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-java_util_stream_StreamSpliterators$LongWrappingSpliterator-mthref-1(java.util.function.LongConsumer, long):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$LongWrappingSpliterator-mthref-1 */
        static /* synthetic */ void m604java_util_stream_StreamSpliterators$LongWrappingSpliteratormthref1(java.util.function.LongConsumer r1, long r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-java_util_stream_StreamSpliterators$LongWrappingSpliterator-mthref-1(java.util.function.LongConsumer, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.m604java_util_stream_StreamSpliterators$LongWrappingSpliteratormthref1(java.util.function.LongConsumer, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
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
        LongWrappingSpliterator(java.util.stream.PipelineHelper<java.lang.Long> r1, java.util.Spliterator<P_IN> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
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
        LongWrappingSpliterator(java.util.stream.PipelineHelper<java.lang.Long> r1, java.util.function.Supplier<java.util.Spliterator<P_IN>> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-java_util_stream_StreamSpliterators$LongWrappingSpliterator_lambda$8():boolean, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$LongWrappingSpliterator_lambda$8 */
        /* synthetic */ boolean m605java_util_stream_StreamSpliterators$LongWrappingSpliterator_lambda$8() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.-java_util_stream_StreamSpliterators$LongWrappingSpliterator_lambda$8():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.m605java_util_stream_StreamSpliterators$LongWrappingSpliterator_lambda$8():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.LongConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.forEachRemaining(java.util.function.LongConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        void initPartialTraversalState() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.initPartialTraversalState():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.tryAdvance(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.LongConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.tryAdvance(java.util.function.LongConsumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.trySplit():java.util.Spliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator<P_IN, java.lang.Long, ?>, dex: classes.dex
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
        java.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Long, ?> wrap(java.util.Spliterator<P_IN> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.LongWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator<P_IN, java.lang.Long, ?>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.LongWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator");
        }

        public Spliterator.OfLong trySplit() {
            return (Spliterator.OfLong) super.trySplit();
        }
    }

    static final class DoubleWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Double, SpinedBuffer.OfDouble> implements Spliterator.OfDouble {

        /* renamed from: java.util.stream.StreamSpliterators$DoubleWrappingSpliterator$-void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0 implements Sink.OfDouble {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ DoubleConsumer f90val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0.<init>(java.util.function.DoubleConsumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0.<init>(java.util.function.DoubleConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0.<init>(java.util.function.DoubleConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0.accept(double):void, dex: classes.dex
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
            public void accept(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.void_forEachRemaining_java_util_function_DoubleConsumer_consumer_LambdaImpl0.accept(double):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$DoubleWrappingSpliterator$-void_initPartialTraversalState__LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl0 implements Sink.OfDouble {

            /* renamed from: val$-lambdaCtx  reason: not valid java name */
            private /* synthetic */ SpinedBuffer.OfDouble f91val$lambdaCtx;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfDouble):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl0(java.util.stream.SpinedBuffer.OfDouble r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfDouble):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.<init>(java.util.stream.SpinedBuffer$OfDouble):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(double):void, dex: classes.dex
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
            public void accept(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl0.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.void_initPartialTraversalState__LambdaImpl0.accept(double):void");
            }
        }

        /* renamed from: java.util.stream.StreamSpliterators$DoubleWrappingSpliterator$-void_initPartialTraversalState__LambdaImpl1  reason: invalid class name */
        final /* synthetic */ class void_initPartialTraversalState__LambdaImpl1 implements BooleanSupplier {
            private /* synthetic */ DoubleWrappingSpliterator val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$DoubleWrappingSpliterator):void, dex: classes.dex
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
            public /* synthetic */ void_initPartialTraversalState__LambdaImpl1(java.util.stream.StreamSpliterators.DoubleWrappingSpliterator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$DoubleWrappingSpliterator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.<init>(java.util.stream.StreamSpliterators$DoubleWrappingSpliterator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
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
            public boolean getAsBoolean() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.void_initPartialTraversalState__LambdaImpl1.getAsBoolean():boolean");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-java_util_stream_StreamSpliterators$DoubleWrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer$OfDouble, double):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$DoubleWrappingSpliterator-mthref-0 */
        static /* synthetic */ void m597java_util_stream_StreamSpliterators$DoubleWrappingSpliteratormthref0(java.util.stream.SpinedBuffer.OfDouble r1, double r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-java_util_stream_StreamSpliterators$DoubleWrappingSpliterator-mthref-0(java.util.stream.SpinedBuffer$OfDouble, double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.m597java_util_stream_StreamSpliterators$DoubleWrappingSpliteratormthref0(java.util.stream.SpinedBuffer$OfDouble, double):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-java_util_stream_StreamSpliterators$DoubleWrappingSpliterator-mthref-1(java.util.function.DoubleConsumer, double):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$DoubleWrappingSpliterator-mthref-1 */
        static /* synthetic */ void m598java_util_stream_StreamSpliterators$DoubleWrappingSpliteratormthref1(java.util.function.DoubleConsumer r1, double r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-java_util_stream_StreamSpliterators$DoubleWrappingSpliterator-mthref-1(java.util.function.DoubleConsumer, double):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.m598java_util_stream_StreamSpliterators$DoubleWrappingSpliteratormthref1(java.util.function.DoubleConsumer, double):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
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
        DoubleWrappingSpliterator(java.util.stream.PipelineHelper<java.lang.Double> r1, java.util.Spliterator<P_IN> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.Spliterator, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
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
        DoubleWrappingSpliterator(java.util.stream.PipelineHelper<java.lang.Double> r1, java.util.function.Supplier<java.util.Spliterator<P_IN>> r2, boolean r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.<init>(java.util.stream.PipelineHelper, java.util.function.Supplier, boolean):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-java_util_stream_StreamSpliterators$DoubleWrappingSpliterator_lambda$11():boolean, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$DoubleWrappingSpliterator_lambda$11 */
        /* synthetic */ boolean m599java_util_stream_StreamSpliterators$DoubleWrappingSpliterator_lambda$11() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.-java_util_stream_StreamSpliterators$DoubleWrappingSpliterator_lambda$11():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.m599java_util_stream_StreamSpliterators$DoubleWrappingSpliterator_lambda$11():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.forEachRemaining(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.forEachRemaining(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.DoubleConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.forEachRemaining(java.util.function.DoubleConsumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        void initPartialTraversalState() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.initPartialTraversalState():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.initPartialTraversalState():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.tryAdvance(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.tryAdvance(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.DoubleConsumer r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.tryAdvance(java.util.function.DoubleConsumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.trySplit():java.util.Spliterator$OfPrimitive");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.trySplit():java.util.Spliterator, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.trySplit():java.util.Spliterator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator<P_IN, java.lang.Double, ?>, dex: classes.dex
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
        java.util.stream.StreamSpliterators.AbstractWrappingSpliterator<P_IN, java.lang.Double, ?> wrap(java.util.Spliterator<P_IN> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator<P_IN, java.lang.Double, ?>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DoubleWrappingSpliterator.wrap(java.util.Spliterator):java.util.stream.StreamSpliterators$AbstractWrappingSpliterator");
        }

        public Spliterator.OfDouble trySplit() {
            return (Spliterator.OfDouble) super.trySplit();
        }
    }

    static abstract class SliceSpliterator<T, T_SPLITR extends Spliterator<T>> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f96assertionsDisabled = false;
        long fence;
        long index;
        T_SPLITR s;
        final long sliceFence;
        final long sliceOrigin;

        static abstract class OfPrimitive<T, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_CONS> extends SliceSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long):void, dex: classes.dex
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
            OfPrimitive(T_SPLITR r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long, long, long):void, dex: classes.dex
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
            private OfPrimitive(T_SPLITR r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long, long, long, java.util.stream.StreamSpliterators$SliceSpliterator$OfPrimitive):void, dex: classes.dex
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
            /* synthetic */ OfPrimitive(java.util.Spliterator.OfPrimitive r1, long r2, long r4, long r6, long r8, java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive r10) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long, long, long, java.util.stream.StreamSpliterators$SliceSpliterator$OfPrimitive):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long, long, long, java.util.stream.StreamSpliterators$SliceSpliterator$OfPrimitive):void");
            }

            /* access modifiers changed from: protected */
            public abstract T_CONS emptyConsumer();

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
                	at com.android.dx.io.instructions.InstructionCodec$35.decode(InstructionCodec.java:790)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            public void forEachRemaining(T_CONS r1) {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public boolean tryAdvance(T_CONS r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.<init>(java.util.Spliterator, long, long, long, long):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.<init>(java.util.Spliterator, long, long, long, long):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.<init>(java.util.Spliterator, long, long, long, long):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        SliceSpliterator(T_SPLITR r1, long r2, long r4, long r6, long r8) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.<init>(java.util.Spliterator, long, long, long, long):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.<init>(java.util.Spliterator, long, long, long, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.<init>(java.util.Spliterator, long, long, long, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.SliceSpliterator.characteristics():int, dex: classes.dex
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
        public int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.SliceSpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.estimateSize():long, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.estimateSize():long");
        }

        /* access modifiers changed from: protected */
        public abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr, long j, long j2, long j3, long j4);

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.trySplit():T_SPLITR, dex: classes.dex
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
        public T_SPLITR trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.trySplit():T_SPLITR, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.trySplit():java.util.Spliterator");
        }

        static final class OfRef<T> extends SliceSpliterator<T, Spliterator<T>> implements Spliterator<T> {

            /* renamed from: java.util.stream.StreamSpliterators$SliceSpliterator$OfRef$-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
            final /* synthetic */ class boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0 implements Consumer {
                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public /* synthetic */ boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.<init>():void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public void accept(java.lang.Object r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.boolean_tryAdvance_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void");
                }
            }

            /* renamed from: java.util.stream.StreamSpliterators$SliceSpliterator$OfRef$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
            final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements Consumer {
                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public /* synthetic */ void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>():void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public void accept(java.lang.Object r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void");
                }
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$13(java.lang.Object):void, dex: classes.dex
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
            /* renamed from: -java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$13 */
            static /* synthetic */ void m609java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$13(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$13(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.m609java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$13(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$14(java.lang.Object):void, dex: classes.dex
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
            /* renamed from: -java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$14 */
            static /* synthetic */ void m610java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$14(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.-java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$14(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.m610java_util_stream_StreamSpliterators$SliceSpliterator$OfRef_lambda$14(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long):void, dex: classes.dex
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
            OfRef(java.util.Spliterator<T> r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long, long, long):void, dex: classes.dex
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
            private OfRef(java.util.Spliterator<T> r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:61)
                	at com.android.dx.io.instructions.InstructionCodec$35.decode(InstructionCodec.java:790)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            public void forEachRemaining(java.util.function.Consumer<? super T> r1) {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public boolean tryAdvance(java.util.function.Consumer<? super T> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean");
            }

            /* access modifiers changed from: protected */
            public Spliterator<T> makeSpliterator(Spliterator<T> s, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfRef(s, sliceOrigin, sliceFence, origin, fence);
            }
        }

        static final class OfInt extends OfPrimitive<Integer, Spliterator.OfInt, IntConsumer> implements Spliterator.OfInt {

            /* renamed from: java.util.stream.StreamSpliterators$SliceSpliterator$OfInt$-java_util_function_IntConsumer_emptyConsumer__LambdaImpl0  reason: invalid class name */
            final /* synthetic */ class java_util_function_IntConsumer_emptyConsumer__LambdaImpl0 implements IntConsumer {
                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.-java_util_function_IntConsumer_emptyConsumer__LambdaImpl0.<init>():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public /* synthetic */ java_util_function_IntConsumer_emptyConsumer__LambdaImpl0() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.-java_util_function_IntConsumer_emptyConsumer__LambdaImpl0.<init>():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.java_util_function_IntConsumer_emptyConsumer__LambdaImpl0.<init>():void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.-java_util_function_IntConsumer_emptyConsumer__LambdaImpl0.accept(int):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public void accept(int r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.-java_util_function_IntConsumer_emptyConsumer__LambdaImpl0.accept(int):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.java_util_function_IntConsumer_emptyConsumer__LambdaImpl0.accept(int):void");
                }
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.-java_util_stream_StreamSpliterators$SliceSpliterator$OfInt_lambda$15(int):void, dex: classes.dex
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
            /* renamed from: -java_util_stream_StreamSpliterators$SliceSpliterator$OfInt_lambda$15 */
            static /* synthetic */ void m607java_util_stream_StreamSpliterators$SliceSpliterator$OfInt_lambda$15(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.-java_util_stream_StreamSpliterators$SliceSpliterator$OfInt_lambda$15(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.m607java_util_stream_StreamSpliterators$SliceSpliterator$OfInt_lambda$15(int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long):void, dex: classes.dex
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
            OfInt(java.util.Spliterator.OfInt r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long, long, long):void, dex: classes.dex
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
            OfInt(java.util.Spliterator.OfInt r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.emptyConsumer():java.lang.Object, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.emptyConsumer():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.emptyConsumer():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
                	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            protected /* bridge */ /* synthetic */ java.lang.Object emptyConsumer() {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.emptyConsumer():java.lang.Object, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.emptyConsumer():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.emptyConsumer():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ea
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            protected /* bridge */ /* synthetic */ java.util.Spliterator makeSpliterator(java.util.Spliterator r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfInt trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt");
            }

            /* access modifiers changed from: protected */
            public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfInt(s, sliceOrigin, sliceFence, origin, fence);
            }

            /* access modifiers changed from: protected */
            public IntConsumer emptyConsumer() {
                return new java_util_function_IntConsumer_emptyConsumer__LambdaImpl0();
            }
        }

        static final class OfLong extends OfPrimitive<Long, Spliterator.OfLong, LongConsumer> implements Spliterator.OfLong {

            /* renamed from: java.util.stream.StreamSpliterators$SliceSpliterator$OfLong$-java_util_function_LongConsumer_emptyConsumer__LambdaImpl0  reason: invalid class name */
            final /* synthetic */ class java_util_function_LongConsumer_emptyConsumer__LambdaImpl0 implements LongConsumer {
                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.-java_util_function_LongConsumer_emptyConsumer__LambdaImpl0.<init>():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public /* synthetic */ java_util_function_LongConsumer_emptyConsumer__LambdaImpl0() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.-java_util_function_LongConsumer_emptyConsumer__LambdaImpl0.<init>():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.java_util_function_LongConsumer_emptyConsumer__LambdaImpl0.<init>():void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.-java_util_function_LongConsumer_emptyConsumer__LambdaImpl0.accept(long):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public void accept(long r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.-java_util_function_LongConsumer_emptyConsumer__LambdaImpl0.accept(long):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.java_util_function_LongConsumer_emptyConsumer__LambdaImpl0.accept(long):void");
                }
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.-java_util_stream_StreamSpliterators$SliceSpliterator$OfLong_lambda$16(long):void, dex: classes.dex
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
            /* renamed from: -java_util_stream_StreamSpliterators$SliceSpliterator$OfLong_lambda$16 */
            static /* synthetic */ void m608java_util_stream_StreamSpliterators$SliceSpliterator$OfLong_lambda$16(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.-java_util_stream_StreamSpliterators$SliceSpliterator$OfLong_lambda$16(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.m608java_util_stream_StreamSpliterators$SliceSpliterator$OfLong_lambda$16(long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long):void, dex: classes.dex
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
            OfLong(java.util.Spliterator.OfLong r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long, long, long):void, dex: classes.dex
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
            OfLong(java.util.Spliterator.OfLong r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.emptyConsumer():java.lang.Object, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.emptyConsumer():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.emptyConsumer():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
                	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            protected /* bridge */ /* synthetic */ java.lang.Object emptyConsumer() {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.emptyConsumer():java.lang.Object, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.emptyConsumer():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.emptyConsumer():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ea
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            protected /* bridge */ /* synthetic */ java.util.Spliterator makeSpliterator(java.util.Spliterator r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfLong trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong");
            }

            /* access modifiers changed from: protected */
            public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfLong(s, sliceOrigin, sliceFence, origin, fence);
            }

            /* access modifiers changed from: protected */
            public LongConsumer emptyConsumer() {
                return new java_util_function_LongConsumer_emptyConsumer__LambdaImpl0();
            }
        }

        static final class OfDouble extends OfPrimitive<Double, Spliterator.OfDouble, DoubleConsumer> implements Spliterator.OfDouble {

            /* renamed from: java.util.stream.StreamSpliterators$SliceSpliterator$OfDouble$-java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0  reason: invalid class name */
            final /* synthetic */ class java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0 implements DoubleConsumer {
                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.-java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0.<init>():void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public /* synthetic */ java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.-java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0.<init>():void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0.<init>():void");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.-java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0.accept(double):void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                    	... 8 more
                    */
                public void accept(double r1) {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.-java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0.accept(double):void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0.accept(double):void");
                }
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.-java_util_stream_StreamSpliterators$SliceSpliterator$OfDouble_lambda$17(double):void, dex: classes.dex
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
            /* renamed from: -java_util_stream_StreamSpliterators$SliceSpliterator$OfDouble_lambda$17 */
            static /* synthetic */ void m606java_util_stream_StreamSpliterators$SliceSpliterator$OfDouble_lambda$17(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.-java_util_stream_StreamSpliterators$SliceSpliterator$OfDouble_lambda$17(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.m606java_util_stream_StreamSpliterators$SliceSpliterator$OfDouble_lambda$17(double):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long):void, dex: classes.dex
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
            OfDouble(java.util.Spliterator.OfDouble r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long, long, long):void, dex: classes.dex
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
            OfDouble(java.util.Spliterator.OfDouble r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.emptyConsumer():java.lang.Object, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.emptyConsumer():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.emptyConsumer():java.lang.Object, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
                	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            protected /* bridge */ /* synthetic */ java.lang.Object emptyConsumer() {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.emptyConsumer():java.lang.Object, dex: classes.dex in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.emptyConsumer():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.emptyConsumer():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ea
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            protected /* bridge */ /* synthetic */ java.util.Spliterator makeSpliterator(java.util.Spliterator r1, long r2, long r4, long r6, long r8) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.makeSpliterator(java.util.Spliterator, long, long, long, long):java.util.Spliterator");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfDouble trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.SliceSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble");
            }

            /* access modifiers changed from: protected */
            public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfDouble(s, sliceOrigin, sliceFence, origin, fence);
            }

            /* access modifiers changed from: protected */
            public DoubleConsumer emptyConsumer() {
                return new java_util_function_DoubleConsumer_emptyConsumer__LambdaImpl0();
            }
        }
    }

    static abstract class UnorderedSliceSpliterator<T, T_SPLITR extends Spliterator<T>> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f97assertionsDisabled = false;
        static final int CHUNK_SIZE = 128;
        private final AtomicLong permits;
        protected final T_SPLITR s;
        private final long skipThreshold;
        protected final boolean unlimited;

        static abstract class OfPrimitive<T, T_CONS, T_BUFF extends ArrayBuffer.OfPrimitive<T_CONS>, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends UnorderedSliceSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long):void, dex: classes.dex
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
            OfPrimitive(T_SPLITR r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfPrimitive):void, dex: classes.dex
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
            OfPrimitive(T_SPLITR r1, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive<T, T_CONS, T_BUFF, T_SPLITR> r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfPrimitive):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.<init>(java.util.Spliterator$OfPrimitive, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfPrimitive):void");
            }

            /* access modifiers changed from: protected */
            public abstract void acceptConsumed(T_CONS t_cons);

            /* access modifiers changed from: protected */
            public abstract T_BUFF bufferCreate(int i);

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            public void forEachRemaining(T_CONS r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.forEachRemaining(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            public boolean tryAdvance(T_CONS r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.tryAdvance(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive.trySplit():java.util.Spliterator$OfPrimitive");
            }
        }

        /*  JADX ERROR: NullPointerException in pass: EnumVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
            	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
            */
        enum PermitStatus {
            ;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.<clinit>():void, dex: classes.dex
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
            static {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.<clinit>():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus.<clinit>():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<init>(java.util.Spliterator, long, long):void, dex: classes.dex
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
        UnorderedSliceSpliterator(T_SPLITR r1, long r2, long r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<init>(java.util.Spliterator, long, long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<init>(java.util.Spliterator, long, long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<init>(java.util.Spliterator, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator):void, dex: classes.dex
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
        UnorderedSliceSpliterator(T_SPLITR r1, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator<T, T_SPLITR> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<init>(java.util.Spliterator, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.<init>(java.util.Spliterator, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.acquirePermits(long):long, dex: classes.dex
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
        protected final long acquirePermits(long r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.acquirePermits(long):long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.acquirePermits(long):long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.characteristics():int, dex: classes.dex
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
        public final int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.estimateSize():long, dex: classes.dex
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
        public final long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.estimateSize():long");
        }

        /* access modifiers changed from: protected */
        public abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr);

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.permitStatus():java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$PermitStatus, dex: classes.dex
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
        protected final java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.PermitStatus permitStatus() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.permitStatus():java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$PermitStatus, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.permitStatus():java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$PermitStatus");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.trySplit():T_SPLITR, dex: classes.dex
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
        public final T_SPLITR trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.trySplit():T_SPLITR, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.trySplit():java.util.Spliterator");
        }

        static final class OfRef<T> extends UnorderedSliceSpliterator<T, Spliterator<T>> implements Spliterator<T>, Consumer<T> {
            T tmpSlot;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long):void, dex: classes.dex
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
            OfRef(java.util.Spliterator<T> r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.<init>(java.util.Spliterator, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.<init>(java.util.Spliterator, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfRef):void, dex: classes.dex
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
            OfRef(java.util.Spliterator<T> r1, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef<T> r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.<init>(java.util.Spliterator, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfRef):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.<init>(java.util.Spliterator, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfRef):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.accept(java.lang.Object):void, dex: classes.dex
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
            public final void accept(T r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.accept(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.accept(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
            public void forEachRemaining(java.util.function.Consumer<? super T> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.forEachRemaining(java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
            public boolean tryAdvance(java.util.function.Consumer<? super T> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean");
            }

            /* access modifiers changed from: protected */
            public Spliterator<T> makeSpliterator(Spliterator<T> s) {
                return new OfRef(s, this);
            }
        }

        static final class OfInt extends OfPrimitive<Integer, IntConsumer, ArrayBuffer.OfInt, Spliterator.OfInt> implements Spliterator.OfInt, IntConsumer {
            int tmpValue;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long):void, dex: classes.dex
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
            OfInt(java.util.Spliterator.OfInt r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfInt):void, dex: classes.dex
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
            OfInt(java.util.Spliterator.OfInt r1, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfInt):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.<init>(java.util.Spliterator$OfInt, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfInt):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.accept(int):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            public void accept(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.accept(int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.accept(int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.acceptConsumed(java.lang.Object):void, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ void acceptConsumed(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.acceptConsumed(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.acceptConsumed(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.acceptConsumed(java.util.function.IntConsumer):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            protected void acceptConsumed(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.acceptConsumed(java.util.function.IntConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.acceptConsumed(java.util.function.IntConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive bufferCreate(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.forEachRemaining(java.util.function.IntConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.makeSpliterator(java.util.Spliterator):java.util.Spliterator, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ java.util.Spliterator makeSpliterator(java.util.Spliterator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.makeSpliterator(java.util.Spliterator):java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.makeSpliterator(java.util.Spliterator):java.util.Spliterator");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfInt trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt");
            }

            /* access modifiers changed from: protected */
            public ArrayBuffer.OfInt bufferCreate(int initialCapacity) {
                return new ArrayBuffer.OfInt(initialCapacity);
            }

            /* access modifiers changed from: protected */
            public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s) {
                return new OfInt(s, this);
            }
        }

        static final class OfLong extends OfPrimitive<Long, LongConsumer, ArrayBuffer.OfLong, Spliterator.OfLong> implements Spliterator.OfLong, LongConsumer {
            long tmpValue;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long):void, dex: classes.dex
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
            OfLong(java.util.Spliterator.OfLong r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfLong):void, dex: classes.dex
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
            OfLong(java.util.Spliterator.OfLong r1, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfLong):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.<init>(java.util.Spliterator$OfLong, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfLong):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e7 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.accept(long):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e7
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            public void accept(long r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e7 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.accept(long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.accept(long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.lang.Object):void, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ void acceptConsumed(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.util.function.LongConsumer):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.util.function.LongConsumer):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.util.function.LongConsumer):void, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.InstructionCodec$21.decode(InstructionCodec.java:471)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            protected void acceptConsumed(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.util.function.LongConsumer):void, dex: classes.dex in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.util.function.LongConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.acceptConsumed(java.util.function.LongConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive bufferCreate(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.forEachRemaining(java.util.function.LongConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.makeSpliterator(java.util.Spliterator):java.util.Spliterator, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ java.util.Spliterator makeSpliterator(java.util.Spliterator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.makeSpliterator(java.util.Spliterator):java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.makeSpliterator(java.util.Spliterator):java.util.Spliterator");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfLong trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong");
            }

            /* access modifiers changed from: protected */
            public ArrayBuffer.OfLong bufferCreate(int initialCapacity) {
                return new ArrayBuffer.OfLong(initialCapacity);
            }

            /* access modifiers changed from: protected */
            public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s) {
                return new OfLong(s, this);
            }
        }

        static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, ArrayBuffer.OfDouble, Spliterator.OfDouble> implements Spliterator.OfDouble, DoubleConsumer {
            double tmpValue;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long):void, dex: classes.dex
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
            OfDouble(java.util.Spliterator.OfDouble r1, long r2, long r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, long, long):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfDouble):void, dex: classes.dex
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
            OfDouble(java.util.Spliterator.OfDouble r1, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfDouble):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.<init>(java.util.Spliterator$OfDouble, java.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfDouble):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e7 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.accept(double):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e7
                	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                	... 7 more
                */
            public void accept(double r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e7 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.accept(double):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.accept(double):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.acceptConsumed(java.lang.Object):void, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ void acceptConsumed(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.acceptConsumed(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.acceptConsumed(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.acceptConsumed(java.util.function.DoubleConsumer):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            protected void acceptConsumed(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.acceptConsumed(java.util.function.DoubleConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.acceptConsumed(java.util.function.DoubleConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive bufferCreate(int r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.bufferCreate(int):java.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.forEachRemaining(java.util.function.DoubleConsumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.makeSpliterator(java.util.Spliterator):java.util.Spliterator, dex: classes.dex
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
            protected /* bridge */ /* synthetic */ java.util.Spliterator makeSpliterator(java.util.Spliterator r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.makeSpliterator(java.util.Spliterator):java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.makeSpliterator(java.util.Spliterator):java.util.Spliterator");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfDouble trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble");
            }

            /* access modifiers changed from: protected */
            public ArrayBuffer.OfDouble bufferCreate(int initialCapacity) {
                return new ArrayBuffer.OfDouble(initialCapacity);
            }

            /* access modifiers changed from: protected */
            public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s) {
                return new OfDouble(s, this);
            }
        }
    }

    static final class DistinctSpliterator<T> implements Spliterator<T>, Consumer<T> {
        private static final Object NULL_VALUE = null;
        private final Spliterator<T> s;
        private final ConcurrentHashMap<T, Boolean> seen;
        private T tmpSlot;

        /* renamed from: java.util.stream.StreamSpliterators$DistinctSpliterator$-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0  reason: invalid class name */
        final /* synthetic */ class void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0 implements Consumer {
            private /* synthetic */ Consumer val$action;
            private /* synthetic */ DistinctSpliterator val$this;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.stream.StreamSpliterators$DistinctSpliterator, java.util.function.Consumer):void, dex: classes.dex
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
            public /* synthetic */ void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0(java.util.stream.StreamSpliterators.DistinctSpliterator r1, java.util.function.Consumer r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.stream.StreamSpliterators$DistinctSpliterator, java.util.function.Consumer):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.<init>(java.util.stream.StreamSpliterators$DistinctSpliterator, java.util.function.Consumer):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
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
            public void accept(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.-void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.void_forEachRemaining_java_util_function_Consumer_action_LambdaImpl0.accept(java.lang.Object):void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.<clinit>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.<init>(java.util.Spliterator, java.util.concurrent.ConcurrentHashMap):void, dex: classes.dex
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
        private DistinctSpliterator(java.util.Spliterator<T> r1, java.util.concurrent.ConcurrentHashMap<T, java.lang.Boolean> r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.<init>(java.util.Spliterator, java.util.concurrent.ConcurrentHashMap):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.<init>(java.util.Spliterator, java.util.concurrent.ConcurrentHashMap):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.-java_util_stream_StreamSpliterators$DistinctSpliterator_lambda$18(java.util.function.Consumer, java.lang.Object):void, dex: classes.dex
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
        /* renamed from: -java_util_stream_StreamSpliterators$DistinctSpliterator_lambda$18 */
        /* synthetic */ void m596java_util_stream_StreamSpliterators$DistinctSpliterator_lambda$18(java.util.function.Consumer r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.-java_util_stream_StreamSpliterators$DistinctSpliterator_lambda$18(java.util.function.Consumer, java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.m596java_util_stream_StreamSpliterators$DistinctSpliterator_lambda$18(java.util.function.Consumer, java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.accept(java.lang.Object):void, dex: classes.dex
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
        public void accept(T r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.accept(java.lang.Object):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.accept(java.lang.Object):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.characteristics():int, dex: classes.dex
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
        public int characteristics() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.characteristics():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.characteristics():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.estimateSize():long, dex: classes.dex
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
        public long estimateSize() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.estimateSize():long");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
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
        public void forEachRemaining(java.util.function.Consumer<? super T> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.forEachRemaining(java.util.function.Consumer):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.forEachRemaining(java.util.function.Consumer):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.getComparator():java.util.Comparator<? super T>, dex: classes.dex
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
        public java.util.Comparator<? super T> getComparator() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.getComparator():java.util.Comparator<? super T>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.getComparator():java.util.Comparator");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
        public boolean tryAdvance(java.util.function.Consumer<? super T> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.trySplit():java.util.Spliterator<T>, dex: classes.dex
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
        public java.util.Spliterator<T> trySplit() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.DistinctSpliterator.trySplit():java.util.Spliterator<T>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.DistinctSpliterator.trySplit():java.util.Spliterator");
        }

        DistinctSpliterator(Spliterator<T> s2) {
            this(s2, new ConcurrentHashMap());
        }

        private T mapNull(T t) {
            return t != null ? t : NULL_VALUE;
        }
    }

    static abstract class InfiniteSupplyingSpliterator<T> implements Spliterator<T> {
        long estimate;

        static final class OfDouble extends InfiniteSupplyingSpliterator<Double> implements Spliterator.OfDouble {
            final DoubleSupplier s;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.<init>(long, java.util.function.DoubleSupplier):void, dex: classes.dex
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
            OfDouble(long r1, java.util.function.DoubleSupplier r3) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.<init>(long, java.util.function.DoubleSupplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.<init>(long, java.util.function.DoubleSupplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.forEachRemaining(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.forEachRemaining(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.tryAdvance(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.tryAdvance(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
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
            public boolean tryAdvance(java.util.function.DoubleConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.tryAdvance(java.util.function.DoubleConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.util.Spliterator.OfDouble trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfDouble");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator$OfPrimitive");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfDouble.trySplit():java.util.Spliterator");
            }
        }

        static final class OfInt extends InfiniteSupplyingSpliterator<Integer> implements Spliterator.OfInt {
            final IntSupplier s;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.<init>(long, java.util.function.IntSupplier):void, dex: classes.dex
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
            OfInt(long r1, java.util.function.IntSupplier r3) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.<init>(long, java.util.function.IntSupplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.<init>(long, java.util.function.IntSupplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.forEachRemaining(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.forEachRemaining(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.tryAdvance(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.tryAdvance(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
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
            public boolean tryAdvance(java.util.function.IntConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.tryAdvance(java.util.function.IntConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.util.Spliterator.OfInt trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator$OfInt");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator$OfPrimitive");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfInt.trySplit():java.util.Spliterator");
            }
        }

        static final class OfLong extends InfiniteSupplyingSpliterator<Long> implements Spliterator.OfLong {
            final LongSupplier s;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.<init>(long, java.util.function.LongSupplier):void, dex: classes.dex
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
            OfLong(long r1, java.util.function.LongSupplier r3) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.<init>(long, java.util.function.LongSupplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.<init>(long, java.util.function.LongSupplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.forEachRemaining(java.lang.Object):void, dex: classes.dex
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
            public /* bridge */ /* synthetic */ void forEachRemaining(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.forEachRemaining(java.lang.Object):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.forEachRemaining(java.lang.Object):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.tryAdvance(java.lang.Object):boolean, dex: classes.dex
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
            public /* bridge */ /* synthetic */ boolean tryAdvance(java.lang.Object r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.tryAdvance(java.lang.Object):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.tryAdvance(java.lang.Object):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
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
            public boolean tryAdvance(java.util.function.LongConsumer r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.tryAdvance(java.util.function.LongConsumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.util.Spliterator.OfLong trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator$OfLong");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator.OfPrimitive trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator$OfPrimitive, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator$OfPrimitive");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.util.Spliterator trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfLong.trySplit():java.util.Spliterator");
            }
        }

        static final class OfRef<T> extends InfiniteSupplyingSpliterator<T> {
            final Supplier<T> s;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.<init>(long, java.util.function.Supplier):void, dex: classes.dex
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
            OfRef(long r1, java.util.function.Supplier<T> r3) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.<init>(long, java.util.function.Supplier):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.<init>(long, java.util.function.Supplier):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
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
            public boolean tryAdvance(java.util.function.Consumer<? super T> r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.tryAdvance(java.util.function.Consumer):boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.trySplit():java.util.Spliterator<T>, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public java.util.Spliterator<T> trySplit() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.trySplit():java.util.Spliterator<T>, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.OfRef.trySplit():java.util.Spliterator");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e7 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.<init>(long):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e7
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        protected InfiniteSupplyingSpliterator(long r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e7 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.<init>(long):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.<init>(long):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.estimateSize():long, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.estimateSize():long, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.stream.StreamSpliterators.InfiniteSupplyingSpliterator.estimateSize():long");
        }

        public int characteristics() {
            return 1024;
        }
    }
}
