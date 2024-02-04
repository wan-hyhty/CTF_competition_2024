package java.util;

import java.util.concurrent.CountedCompleter;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class ArraysParallelSortHelpers {

    static final class EmptyCompleter extends CountedCompleter<Void> {
        static final long serialVersionUID = 2446542900576103244L;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.EmptyCompleter.<init>(java.util.concurrent.CountedCompleter):void, dex: classes.dex
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
        EmptyCompleter(java.util.concurrent.CountedCompleter<?> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.EmptyCompleter.<init>(java.util.concurrent.CountedCompleter):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.EmptyCompleter.<init>(java.util.concurrent.CountedCompleter):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.EmptyCompleter.compute():void, dex: classes.dex
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
        public final void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.EmptyCompleter.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.EmptyCompleter.compute():void");
        }
    }

    static final class FJByte {

        static final class Merger extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final byte[] a;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final byte[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJByte.Merger.<init>(java.util.concurrent.CountedCompleter, byte[], byte[], int, int, int, int, int, int):void, dex: classes.dex
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
            Merger(java.util.concurrent.CountedCompleter<?> r1, byte[] r2, byte[] r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJByte.Merger.<init>(java.util.concurrent.CountedCompleter, byte[], byte[], int, int, int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJByte.Merger.<init>(java.util.concurrent.CountedCompleter, byte[], byte[], int, int, int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJByte.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJByte.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJByte.Merger.compute():void");
            }
        }

        static final class Sorter extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final byte[] a;
            final int base;
            final int gran;
            final int size;
            final byte[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJByte.Sorter.<init>(java.util.concurrent.CountedCompleter, byte[], byte[], int, int, int, int):void, dex: classes.dex
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
            Sorter(java.util.concurrent.CountedCompleter<?> r1, byte[] r2, byte[] r3, int r4, int r5, int r6, int r7) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJByte.Sorter.<init>(java.util.concurrent.CountedCompleter, byte[], byte[], int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJByte.Sorter.<init>(java.util.concurrent.CountedCompleter, byte[], byte[], int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJByte.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJByte.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJByte.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJByte.<init>():void, dex: classes.dex
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
        FJByte() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJByte.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJByte.<init>():void");
        }
    }

    static final class FJChar {

        static final class Merger extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final char[] a;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final char[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJChar.Merger.<init>(java.util.concurrent.CountedCompleter, char[], char[], int, int, int, int, int, int):void, dex: classes.dex
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
            Merger(java.util.concurrent.CountedCompleter<?> r1, char[] r2, char[] r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJChar.Merger.<init>(java.util.concurrent.CountedCompleter, char[], char[], int, int, int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJChar.Merger.<init>(java.util.concurrent.CountedCompleter, char[], char[], int, int, int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJChar.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJChar.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJChar.Merger.compute():void");
            }
        }

        static final class Sorter extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final char[] a;
            final int base;
            final int gran;
            final int size;
            final char[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJChar.Sorter.<init>(java.util.concurrent.CountedCompleter, char[], char[], int, int, int, int):void, dex: classes.dex
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
            Sorter(java.util.concurrent.CountedCompleter<?> r1, char[] r2, char[] r3, int r4, int r5, int r6, int r7) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJChar.Sorter.<init>(java.util.concurrent.CountedCompleter, char[], char[], int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJChar.Sorter.<init>(java.util.concurrent.CountedCompleter, char[], char[], int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJChar.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJChar.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJChar.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJChar.<init>():void, dex: classes.dex
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
        FJChar() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJChar.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJChar.<init>():void");
        }
    }

    static final class FJDouble {

        static final class Merger extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final double[] a;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final double[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJDouble.Merger.<init>(java.util.concurrent.CountedCompleter, double[], double[], int, int, int, int, int, int):void, dex: classes.dex
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
            Merger(java.util.concurrent.CountedCompleter<?> r1, double[] r2, double[] r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJDouble.Merger.<init>(java.util.concurrent.CountedCompleter, double[], double[], int, int, int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJDouble.Merger.<init>(java.util.concurrent.CountedCompleter, double[], double[], int, int, int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJDouble.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJDouble.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJDouble.Merger.compute():void");
            }
        }

        static final class Sorter extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final double[] a;
            final int base;
            final int gran;
            final int size;
            final double[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJDouble.Sorter.<init>(java.util.concurrent.CountedCompleter, double[], double[], int, int, int, int):void, dex: classes.dex
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
            Sorter(java.util.concurrent.CountedCompleter<?> r1, double[] r2, double[] r3, int r4, int r5, int r6, int r7) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJDouble.Sorter.<init>(java.util.concurrent.CountedCompleter, double[], double[], int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJDouble.Sorter.<init>(java.util.concurrent.CountedCompleter, double[], double[], int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJDouble.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJDouble.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJDouble.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJDouble.<init>():void, dex: classes.dex
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
        FJDouble() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJDouble.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJDouble.<init>():void");
        }
    }

    static final class FJFloat {

        static final class Merger extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final float[] a;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final float[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJFloat.Merger.<init>(java.util.concurrent.CountedCompleter, float[], float[], int, int, int, int, int, int):void, dex: classes.dex
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
            Merger(java.util.concurrent.CountedCompleter<?> r1, float[] r2, float[] r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJFloat.Merger.<init>(java.util.concurrent.CountedCompleter, float[], float[], int, int, int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJFloat.Merger.<init>(java.util.concurrent.CountedCompleter, float[], float[], int, int, int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJFloat.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJFloat.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJFloat.Merger.compute():void");
            }
        }

        static final class Sorter extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final float[] a;
            final int base;
            final int gran;
            final int size;
            final float[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJFloat.Sorter.<init>(java.util.concurrent.CountedCompleter, float[], float[], int, int, int, int):void, dex: classes.dex
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
            Sorter(java.util.concurrent.CountedCompleter<?> r1, float[] r2, float[] r3, int r4, int r5, int r6, int r7) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJFloat.Sorter.<init>(java.util.concurrent.CountedCompleter, float[], float[], int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJFloat.Sorter.<init>(java.util.concurrent.CountedCompleter, float[], float[], int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJFloat.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJFloat.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJFloat.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJFloat.<init>():void, dex: classes.dex
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
        FJFloat() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJFloat.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJFloat.<init>():void");
        }
    }

    static final class FJInt {

        static final class Merger extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final int[] a;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final int[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJInt.Merger.<init>(java.util.concurrent.CountedCompleter, int[], int[], int, int, int, int, int, int):void, dex: classes.dex
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
            Merger(java.util.concurrent.CountedCompleter<?> r1, int[] r2, int[] r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJInt.Merger.<init>(java.util.concurrent.CountedCompleter, int[], int[], int, int, int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJInt.Merger.<init>(java.util.concurrent.CountedCompleter, int[], int[], int, int, int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJInt.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJInt.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJInt.Merger.compute():void");
            }
        }

        static final class Sorter extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final int[] a;
            final int base;
            final int gran;
            final int size;
            final int[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJInt.Sorter.<init>(java.util.concurrent.CountedCompleter, int[], int[], int, int, int, int):void, dex: classes.dex
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
            Sorter(java.util.concurrent.CountedCompleter<?> r1, int[] r2, int[] r3, int r4, int r5, int r6, int r7) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJInt.Sorter.<init>(java.util.concurrent.CountedCompleter, int[], int[], int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJInt.Sorter.<init>(java.util.concurrent.CountedCompleter, int[], int[], int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJInt.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJInt.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJInt.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJInt.<init>():void, dex: classes.dex
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
        FJInt() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJInt.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJInt.<init>():void");
        }
    }

    static final class FJLong {

        static final class Merger extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final long[] a;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final long[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJLong.Merger.<init>(java.util.concurrent.CountedCompleter, long[], long[], int, int, int, int, int, int):void, dex: classes.dex
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
            Merger(java.util.concurrent.CountedCompleter<?> r1, long[] r2, long[] r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJLong.Merger.<init>(java.util.concurrent.CountedCompleter, long[], long[], int, int, int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJLong.Merger.<init>(java.util.concurrent.CountedCompleter, long[], long[], int, int, int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJLong.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJLong.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJLong.Merger.compute():void");
            }
        }

        static final class Sorter extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final long[] a;
            final int base;
            final int gran;
            final int size;
            final long[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJLong.Sorter.<init>(java.util.concurrent.CountedCompleter, long[], long[], int, int, int, int):void, dex: classes.dex
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
            Sorter(java.util.concurrent.CountedCompleter<?> r1, long[] r2, long[] r3, int r4, int r5, int r6, int r7) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJLong.Sorter.<init>(java.util.concurrent.CountedCompleter, long[], long[], int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJLong.Sorter.<init>(java.util.concurrent.CountedCompleter, long[], long[], int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJLong.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJLong.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJLong.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJLong.<init>():void, dex: classes.dex
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
        FJLong() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJLong.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJLong.<init>():void");
        }
    }

    static final class FJObject {

        static final class Merger<T> extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final T[] a;
            Comparator<? super T> comparator;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final T[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.ArraysParallelSortHelpers.FJObject.Merger.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, int, int, java.util.Comparator):void, dex: classes.dex in method: java.util.ArraysParallelSortHelpers.FJObject.Merger.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, int, int, java.util.Comparator):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.ArraysParallelSortHelpers.FJObject.Merger.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, int, int, java.util.Comparator):void, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
                	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            Merger(java.util.concurrent.CountedCompleter<?> r1, T[] r2, T[] r3, int r4, int r5, int r6, int r7, int r8, int r9, java.util.Comparator<? super T> r10) {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.ArraysParallelSortHelpers.FJObject.Merger.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, int, int, java.util.Comparator):void, dex: classes.dex in method: java.util.ArraysParallelSortHelpers.FJObject.Merger.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, int, int, java.util.Comparator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJObject.Merger.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, int, int, java.util.Comparator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJObject.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJObject.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJObject.Merger.compute():void");
            }
        }

        static final class Sorter<T> extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final T[] a;
            final int base;
            Comparator<? super T> comparator;
            final int gran;
            final int size;
            final T[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.ArraysParallelSortHelpers.FJObject.Sorter.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, java.util.Comparator):void, dex: classes.dex in method: java.util.ArraysParallelSortHelpers.FJObject.Sorter.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, java.util.Comparator):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.ArraysParallelSortHelpers.FJObject.Sorter.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, java.util.Comparator):void, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
                	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            Sorter(java.util.concurrent.CountedCompleter<?> r1, T[] r2, T[] r3, int r4, int r5, int r6, int r7, java.util.Comparator<? super T> r8) {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.ArraysParallelSortHelpers.FJObject.Sorter.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, java.util.Comparator):void, dex: classes.dex in method: java.util.ArraysParallelSortHelpers.FJObject.Sorter.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, java.util.Comparator):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJObject.Sorter.<init>(java.util.concurrent.CountedCompleter, java.lang.Object[], java.lang.Object[], int, int, int, int, java.util.Comparator):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJObject.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJObject.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJObject.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJObject.<init>():void, dex: classes.dex
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
        FJObject() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJObject.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJObject.<init>():void");
        }
    }

    static final class FJShort {

        static final class Merger extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final short[] a;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;
            final short[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJShort.Merger.<init>(java.util.concurrent.CountedCompleter, short[], short[], int, int, int, int, int, int):void, dex: classes.dex
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
            Merger(java.util.concurrent.CountedCompleter<?> r1, short[] r2, short[] r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJShort.Merger.<init>(java.util.concurrent.CountedCompleter, short[], short[], int, int, int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJShort.Merger.<init>(java.util.concurrent.CountedCompleter, short[], short[], int, int, int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJShort.Merger.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJShort.Merger.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJShort.Merger.compute():void");
            }
        }

        static final class Sorter extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;
            final short[] a;
            final int base;
            final int gran;
            final int size;
            final short[] w;
            final int wbase;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJShort.Sorter.<init>(java.util.concurrent.CountedCompleter, short[], short[], int, int, int, int):void, dex: classes.dex
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
            Sorter(java.util.concurrent.CountedCompleter<?> r1, short[] r2, short[] r3, int r4, int r5, int r6, int r7) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.ArraysParallelSortHelpers.FJShort.Sorter.<init>(java.util.concurrent.CountedCompleter, short[], short[], int, int, int, int):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJShort.Sorter.<init>(java.util.concurrent.CountedCompleter, short[], short[], int, int, int, int):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJShort.Sorter.compute():void, dex: classes.dex
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
            public final void compute() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.FJShort.Sorter.compute():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJShort.Sorter.compute():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJShort.<init>():void, dex: classes.dex
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
        FJShort() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.FJShort.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.FJShort.<init>():void");
        }
    }

    static final class Relay extends CountedCompleter<Void> {
        static final long serialVersionUID = 2446542900576103244L;
        final CountedCompleter<?> task;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.ArraysParallelSortHelpers.Relay.<init>(java.util.concurrent.CountedCompleter):void, dex: classes.dex in method: java.util.ArraysParallelSortHelpers.Relay.<init>(java.util.concurrent.CountedCompleter):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.ArraysParallelSortHelpers.Relay.<init>(java.util.concurrent.CountedCompleter):void, dex: classes.dex
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
        Relay(java.util.concurrent.CountedCompleter<?> r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.ArraysParallelSortHelpers.Relay.<init>(java.util.concurrent.CountedCompleter):void, dex: classes.dex in method: java.util.ArraysParallelSortHelpers.Relay.<init>(java.util.concurrent.CountedCompleter):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.Relay.<init>(java.util.concurrent.CountedCompleter):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.Relay.compute():void, dex: classes.dex
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
        public final void compute() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.Relay.compute():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.Relay.compute():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.Relay.onCompletion(java.util.concurrent.CountedCompleter):void, dex: classes.dex
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
        public final void onCompletion(java.util.concurrent.CountedCompleter<?> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.ArraysParallelSortHelpers.Relay.onCompletion(java.util.concurrent.CountedCompleter):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.Relay.onCompletion(java.util.concurrent.CountedCompleter):void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.<init>():void, dex: classes.dex
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
    ArraysParallelSortHelpers() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.ArraysParallelSortHelpers.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ArraysParallelSortHelpers.<init>():void");
    }
}
