package java.security;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
final class UnresolvedPermissionCollection extends PermissionCollection implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = null;
    private static final long serialVersionUID = -7176153071733132400L;
    private transient Map<String, List<UnresolvedPermission>> perms;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.UnresolvedPermissionCollection.readObject(java.io.ObjectInputStream):void, dex: classes.dex
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
    private void readObject(java.io.ObjectInputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.UnresolvedPermissionCollection.readObject(java.io.ObjectInputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.UnresolvedPermissionCollection.readObject(java.io.ObjectInputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.UnresolvedPermissionCollection.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex in method: java.security.UnresolvedPermissionCollection.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.UnresolvedPermissionCollection.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
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
    private void writeObject(java.io.ObjectOutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: java.security.UnresolvedPermissionCollection.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex in method: java.security.UnresolvedPermissionCollection.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.UnresolvedPermissionCollection.writeObject(java.io.ObjectOutputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.UnresolvedPermissionCollection.add(java.security.Permission):void, dex: classes.dex
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
    public void add(java.security.Permission r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.UnresolvedPermissionCollection.add(java.security.Permission):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.UnresolvedPermissionCollection.add(java.security.Permission):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.UnresolvedPermissionCollection.elements():java.util.Enumeration<java.security.Permission>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.util.Enumeration<java.security.Permission> elements() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.UnresolvedPermissionCollection.elements():java.util.Enumeration<java.security.Permission>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.UnresolvedPermissionCollection.elements():java.util.Enumeration");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.UnresolvedPermissionCollection.getUnresolvedPermissions(java.security.Permission):java.util.List<java.security.UnresolvedPermission>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    java.util.List<java.security.UnresolvedPermission> getUnresolvedPermissions(java.security.Permission r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.UnresolvedPermissionCollection.getUnresolvedPermissions(java.security.Permission):java.util.List<java.security.UnresolvedPermission>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.UnresolvedPermissionCollection.getUnresolvedPermissions(java.security.Permission):java.util.List");
    }

    public boolean implies(Permission permission) {
        return false;
    }
}
