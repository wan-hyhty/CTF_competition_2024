package java.security;

import java.util.HashMap;
import sun.security.util.Debug;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class SecureClassLoader extends ClassLoader {
    private static final Debug debug = null;
    private final boolean initialized;
    private final HashMap<CodeSource, ProtectionDomain> pdcache;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.SecureClassLoader.<init>():void, dex: classes.dex in method: java.security.SecureClassLoader.<init>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.SecureClassLoader.<init>():void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$23.decode(InstructionCodec.java:514)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    protected SecureClassLoader() {
        /*
        // Can't load method instructions: Load method exception: null in method: java.security.SecureClassLoader.<init>():void, dex: classes.dex in method: java.security.SecureClassLoader.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.SecureClassLoader.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.SecureClassLoader.<init>(java.lang.ClassLoader):void, dex: classes.dex in method: java.security.SecureClassLoader.<init>(java.lang.ClassLoader):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.SecureClassLoader.<init>(java.lang.ClassLoader):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$23.decode(InstructionCodec.java:514)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    protected SecureClassLoader(java.lang.ClassLoader r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.security.SecureClassLoader.<init>(java.lang.ClassLoader):void, dex: classes.dex in method: java.security.SecureClassLoader.<init>(java.lang.ClassLoader):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.SecureClassLoader.<init>(java.lang.ClassLoader):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: java.security.SecureClassLoader.check():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    private void check() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: java.security.SecureClassLoader.check():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.SecureClassLoader.check():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.SecureClassLoader.getProtectionDomain(java.security.CodeSource):java.security.ProtectionDomain, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    private java.security.ProtectionDomain getProtectionDomain(java.security.CodeSource r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.SecureClassLoader.getProtectionDomain(java.security.CodeSource):java.security.ProtectionDomain, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.SecureClassLoader.getProtectionDomain(java.security.CodeSource):java.security.ProtectionDomain");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.SecureClassLoader.defineClass(java.lang.String, java.nio.ByteBuffer, java.security.CodeSource):java.lang.Class<?>, dex: classes.dex
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
    protected final java.lang.Class<?> defineClass(java.lang.String r1, java.nio.ByteBuffer r2, java.security.CodeSource r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.SecureClassLoader.defineClass(java.lang.String, java.nio.ByteBuffer, java.security.CodeSource):java.lang.Class<?>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.SecureClassLoader.defineClass(java.lang.String, java.nio.ByteBuffer, java.security.CodeSource):java.lang.Class");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: java.security.SecureClassLoader.defineClass(java.lang.String, byte[], int, int, java.security.CodeSource):java.lang.Class<?>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    protected final java.lang.Class<?> defineClass(java.lang.String r1, byte[] r2, int r3, int r4, java.security.CodeSource r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: java.security.SecureClassLoader.defineClass(java.lang.String, byte[], int, int, java.security.CodeSource):java.lang.Class<?>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.SecureClassLoader.defineClass(java.lang.String, byte[], int, int, java.security.CodeSource):java.lang.Class");
    }

    /* access modifiers changed from: protected */
    public PermissionCollection getPermissions(CodeSource codesource) {
        check();
        return new Permissions();
    }
}
