package java.security;

import java.util.Enumeration;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class Policy {
    public static final PermissionCollection UNSUPPORTED_EMPTY_COLLECTION = null;

    public interface Parameters {
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.Policy.setPolicy(java.security.Policy):void, dex: classes.dex
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
    public static void setPolicy(java.security.Policy r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.Policy.setPolicy(java.security.Policy):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.Policy.setPolicy(java.security.Policy):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.Policy.refresh():void, dex: classes.dex
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
    public void refresh() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.Policy.refresh():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.Policy.refresh():void");
    }

    public static Policy getPolicy() {
        return null;
    }

    public static Policy getInstance(String type, Parameters params) throws NoSuchAlgorithmException {
        return null;
    }

    public static Policy getInstance(String type, Parameters params, String provider) throws NoSuchProviderException, NoSuchAlgorithmException {
        return null;
    }

    public static Policy getInstance(String type, Parameters params, Provider provider) throws NoSuchAlgorithmException {
        return null;
    }

    public Provider getProvider() {
        return null;
    }

    public String getType() {
        return null;
    }

    public Parameters getParameters() {
        return null;
    }

    public PermissionCollection getPermissions(CodeSource codesource) {
        return null;
    }

    public PermissionCollection getPermissions(ProtectionDomain domain) {
        return null;
    }

    public boolean implies(ProtectionDomain domain, Permission permission) {
        return true;
    }

    private static class UnsupportedEmptyCollection extends PermissionCollection {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.Policy.UnsupportedEmptyCollection.add(java.security.Permission):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void add(java.security.Permission r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.Policy.UnsupportedEmptyCollection.add(java.security.Permission):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.Policy.UnsupportedEmptyCollection.add(java.security.Permission):void");
        }

        public boolean implies(Permission permission) {
            return true;
        }

        public Enumeration<Permission> elements() {
            return null;
        }
    }
}
