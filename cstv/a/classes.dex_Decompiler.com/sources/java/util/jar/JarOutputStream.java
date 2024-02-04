package java.util.jar;

import java.util.zip.ZipOutputStream;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class JarOutputStream extends ZipOutputStream {
    private static final int JAR_MAGIC = 51966;
    private boolean firstEntry;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00eb in method: java.util.jar.JarOutputStream.<init>(java.io.OutputStream):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00eb
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public JarOutputStream(java.io.OutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00eb in method: java.util.jar.JarOutputStream.<init>(java.io.OutputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarOutputStream.<init>(java.io.OutputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.jar.JarOutputStream.<init>(java.io.OutputStream, java.util.jar.Manifest):void, dex: classes.dex in method: java.util.jar.JarOutputStream.<init>(java.io.OutputStream, java.util.jar.Manifest):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.jar.JarOutputStream.<init>(java.io.OutputStream, java.util.jar.Manifest):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec$21.decode(InstructionCodec.java:471)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public JarOutputStream(java.io.OutputStream r1, java.util.jar.Manifest r2) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.util.jar.JarOutputStream.<init>(java.io.OutputStream, java.util.jar.Manifest):void, dex: classes.dex in method: java.util.jar.JarOutputStream.<init>(java.io.OutputStream, java.util.jar.Manifest):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarOutputStream.<init>(java.io.OutputStream, java.util.jar.Manifest):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.jar.JarOutputStream.set16(byte[], int, int):void, dex: classes.dex
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
    private static void set16(byte[] r1, int r2, int r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.jar.JarOutputStream.set16(byte[], int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarOutputStream.set16(byte[], int, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.util.jar.JarOutputStream.putNextEntry(java.util.zip.ZipEntry):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public void putNextEntry(java.util.zip.ZipEntry r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.util.jar.JarOutputStream.putNextEntry(java.util.zip.ZipEntry):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarOutputStream.putNextEntry(java.util.zip.ZipEntry):void");
    }

    private static boolean hasMagic(byte[] edata) {
        int i = 0;
        while (i < edata.length) {
            try {
                if (get16(edata, i) == JAR_MAGIC) {
                    return true;
                }
                i += get16(edata, i + 2) + 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return false;
    }

    private static int get16(byte[] b, int off) {
        return (b[off] & Character.DIRECTIONALITY_UNDEFINED) | ((b[off + 1] & Character.DIRECTIONALITY_UNDEFINED) << 8);
    }
}
