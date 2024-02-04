package sun.reflect;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class Reflection {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.ensureMemberAccess(java.lang.Class, java.lang.Class, java.lang.Object, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public static void ensureMemberAccess(java.lang.Class r1, java.lang.Class r2, java.lang.Object r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.ensureMemberAccess(java.lang.Class, java.lang.Class, java.lang.Object, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.reflect.Reflection.ensureMemberAccess(java.lang.Class, java.lang.Class, java.lang.Object, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.isSameClassPackage(java.lang.Class, java.lang.Class):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    private static boolean isSameClassPackage(java.lang.Class r1, java.lang.Class r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.isSameClassPackage(java.lang.Class, java.lang.Class):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.reflect.Reflection.isSameClassPackage(java.lang.Class, java.lang.Class):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus registerCount: f in method: sun.reflect.Reflection.isSameClassPackage(java.lang.ClassLoader, java.lang.String, java.lang.ClassLoader, java.lang.String):boolean, dex: classes.dex in method: sun.reflect.Reflection.isSameClassPackage(java.lang.ClassLoader, java.lang.String, java.lang.ClassLoader, java.lang.String):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: bogus registerCount: f in method: sun.reflect.Reflection.isSameClassPackage(java.lang.ClassLoader, java.lang.String, java.lang.ClassLoader, java.lang.String):boolean, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: com.android.dex.DexException: bogus registerCount: f
        	at com.android.dx.io.instructions.InstructionCodec$32.decode(InstructionCodec.java:693)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    private static boolean isSameClassPackage(java.lang.ClassLoader r1, java.lang.String r2, java.lang.ClassLoader r3, java.lang.String r4) {
        /*
        // Can't load method instructions: Load method exception: bogus registerCount: f in method: sun.reflect.Reflection.isSameClassPackage(java.lang.ClassLoader, java.lang.String, java.lang.ClassLoader, java.lang.String):boolean, dex: classes.dex in method: sun.reflect.Reflection.isSameClassPackage(java.lang.ClassLoader, java.lang.String, java.lang.ClassLoader, java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.reflect.Reflection.isSameClassPackage(java.lang.ClassLoader, java.lang.String, java.lang.ClassLoader, java.lang.String):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.isSubclassOf(java.lang.Class, java.lang.Class):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static boolean isSubclassOf(java.lang.Class r1, java.lang.Class r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.isSubclassOf(java.lang.Class, java.lang.Class):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.reflect.Reflection.isSubclassOf(java.lang.Class, java.lang.Class):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.verifyMemberAccess(java.lang.Class, java.lang.Class, java.lang.Object, int):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public static boolean verifyMemberAccess(java.lang.Class r1, java.lang.Class r2, java.lang.Object r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.reflect.Reflection.verifyMemberAccess(java.lang.Class, java.lang.Class, java.lang.Object, int):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.reflect.Reflection.verifyMemberAccess(java.lang.Class, java.lang.Class, java.lang.Object, int):boolean");
    }
}
