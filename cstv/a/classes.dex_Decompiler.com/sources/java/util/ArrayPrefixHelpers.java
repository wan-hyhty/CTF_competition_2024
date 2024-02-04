package java.util;

import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class ArrayPrefixHelpers {
    static final int CUMULATE = 1;
    static final int FINISHED = 4;
    static final int MIN_PARTITION = 16;
    static final int SUMMED = 2;

    static final class CumulateTask<T> extends CountedCompleter<Void> {
        private static final long serialVersionUID = 5293554502939613543L;
        final T[] array;
        final int fence;
        final BinaryOperator<T> function;
        final int hi;
        T in;
        CumulateTask<T> left;
        final int lo;
        final int origin;
        T out;
        CumulateTask<T> right;
        final int threshold;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.CumulateTask.<init>(java.util.ArrayPrefixHelpers$CumulateTask, java.util.function.BinaryOperator, java.lang.Object[], int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public CumulateTask(java.util.ArrayPrefixHelpers.CumulateTask<T> r1, java.util.function.BinaryOperator<T> r2, T[] r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.CumulateTask.<init>(java.util.ArrayPrefixHelpers$CumulateTask, java.util.function.BinaryOperator, java.lang.Object[], int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.CumulateTask.<init>(java.util.ArrayPrefixHelpers$CumulateTask, java.util.function.BinaryOperator, java.lang.Object[], int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.CumulateTask.<init>(java.util.ArrayPrefixHelpers$CumulateTask, java.util.function.BinaryOperator, java.lang.Object[], int, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        CumulateTask(java.util.ArrayPrefixHelpers.CumulateTask<T> r1, java.util.function.BinaryOperator<T> r2, T[] r3, int r4, int r5, int r6, int r7, int r8) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.CumulateTask.<init>(java.util.ArrayPrefixHelpers$CumulateTask, java.util.function.BinaryOperator, java.lang.Object[], int, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.CumulateTask.<init>(java.util.ArrayPrefixHelpers$CumulateTask, java.util.function.BinaryOperator, java.lang.Object[], int, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.CumulateTask.compute():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public final void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.CumulateTask.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.CumulateTask.compute():void");
        }
    }

    static final class DoubleCumulateTask extends CountedCompleter<Void> {
        private static final long serialVersionUID = -586947823794232033L;
        final double[] array;
        final int fence;
        final DoubleBinaryOperator function;
        final int hi;
        double in;
        DoubleCumulateTask left;
        final int lo;
        final int origin;
        double out;
        DoubleCumulateTask right;
        final int threshold;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.DoubleCumulateTask.<init>(java.util.ArrayPrefixHelpers$DoubleCumulateTask, java.util.function.DoubleBinaryOperator, double[], int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public DoubleCumulateTask(java.util.ArrayPrefixHelpers.DoubleCumulateTask r1, java.util.function.DoubleBinaryOperator r2, double[] r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.DoubleCumulateTask.<init>(java.util.ArrayPrefixHelpers$DoubleCumulateTask, java.util.function.DoubleBinaryOperator, double[], int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.DoubleCumulateTask.<init>(java.util.ArrayPrefixHelpers$DoubleCumulateTask, java.util.function.DoubleBinaryOperator, double[], int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.DoubleCumulateTask.<init>(java.util.ArrayPrefixHelpers$DoubleCumulateTask, java.util.function.DoubleBinaryOperator, double[], int, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        DoubleCumulateTask(java.util.ArrayPrefixHelpers.DoubleCumulateTask r1, java.util.function.DoubleBinaryOperator r2, double[] r3, int r4, int r5, int r6, int r7, int r8) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.DoubleCumulateTask.<init>(java.util.ArrayPrefixHelpers$DoubleCumulateTask, java.util.function.DoubleBinaryOperator, double[], int, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.DoubleCumulateTask.<init>(java.util.ArrayPrefixHelpers$DoubleCumulateTask, java.util.function.DoubleBinaryOperator, double[], int, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.DoubleCumulateTask.compute():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public final void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.DoubleCumulateTask.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.DoubleCumulateTask.compute():void");
        }
    }

    static final class IntCumulateTask extends CountedCompleter<Void> {
        private static final long serialVersionUID = 3731755594596840961L;
        final int[] array;
        final int fence;
        final IntBinaryOperator function;
        final int hi;
        int in;
        IntCumulateTask left;
        final int lo;
        final int origin;
        int out;
        IntCumulateTask right;
        final int threshold;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.IntCumulateTask.<init>(java.util.ArrayPrefixHelpers$IntCumulateTask, java.util.function.IntBinaryOperator, int[], int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public IntCumulateTask(java.util.ArrayPrefixHelpers.IntCumulateTask r1, java.util.function.IntBinaryOperator r2, int[] r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.IntCumulateTask.<init>(java.util.ArrayPrefixHelpers$IntCumulateTask, java.util.function.IntBinaryOperator, int[], int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.IntCumulateTask.<init>(java.util.ArrayPrefixHelpers$IntCumulateTask, java.util.function.IntBinaryOperator, int[], int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.IntCumulateTask.<init>(java.util.ArrayPrefixHelpers$IntCumulateTask, java.util.function.IntBinaryOperator, int[], int, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        IntCumulateTask(java.util.ArrayPrefixHelpers.IntCumulateTask r1, java.util.function.IntBinaryOperator r2, int[] r3, int r4, int r5, int r6, int r7, int r8) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.IntCumulateTask.<init>(java.util.ArrayPrefixHelpers$IntCumulateTask, java.util.function.IntBinaryOperator, int[], int, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.IntCumulateTask.<init>(java.util.ArrayPrefixHelpers$IntCumulateTask, java.util.function.IntBinaryOperator, int[], int, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.IntCumulateTask.compute():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public final void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.IntCumulateTask.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.IntCumulateTask.compute():void");
        }
    }

    static final class LongCumulateTask extends CountedCompleter<Void> {
        private static final long serialVersionUID = -5074099945909284273L;
        final long[] array;
        final int fence;
        final LongBinaryOperator function;
        final int hi;
        long in;
        LongCumulateTask left;
        final int lo;
        final int origin;
        long out;
        LongCumulateTask right;
        final int threshold;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.LongCumulateTask.<init>(java.util.ArrayPrefixHelpers$LongCumulateTask, java.util.function.LongBinaryOperator, long[], int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public LongCumulateTask(java.util.ArrayPrefixHelpers.LongCumulateTask r1, java.util.function.LongBinaryOperator r2, long[] r3, int r4, int r5) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.LongCumulateTask.<init>(java.util.ArrayPrefixHelpers$LongCumulateTask, java.util.function.LongBinaryOperator, long[], int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.LongCumulateTask.<init>(java.util.ArrayPrefixHelpers$LongCumulateTask, java.util.function.LongBinaryOperator, long[], int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.LongCumulateTask.<init>(java.util.ArrayPrefixHelpers$LongCumulateTask, java.util.function.LongBinaryOperator, long[], int, int, int, int, int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        LongCumulateTask(java.util.ArrayPrefixHelpers.LongCumulateTask r1, java.util.function.LongBinaryOperator r2, long[] r3, int r4, int r5, int r6, int r7, int r8) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArrayPrefixHelpers.LongCumulateTask.<init>(java.util.ArrayPrefixHelpers$LongCumulateTask, java.util.function.LongBinaryOperator, long[], int, int, int, int, int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.LongCumulateTask.<init>(java.util.ArrayPrefixHelpers$LongCumulateTask, java.util.function.LongBinaryOperator, long[], int, int, int, int, int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.LongCumulateTask.compute():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public final void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArrayPrefixHelpers.LongCumulateTask.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.LongCumulateTask.compute():void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArrayPrefixHelpers.<init>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    private ArrayPrefixHelpers() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArrayPrefixHelpers.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayPrefixHelpers.<init>():void");
    }
}
