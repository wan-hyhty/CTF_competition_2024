package java.net;

import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

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
class NetUtil {
    private static volatile boolean propRevealLocalAddr;
    private static boolean revealLocalAddress;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.net.NetUtil.<init>():void, dex: classes.dex
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
    NetUtil() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.net.NetUtil.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.NetUtil.<init>():void");
    }

    static boolean doRevealLocalAddress() {
        if (propRevealLocalAddr) {
            return revealLocalAddress;
        }
        return readRevealLocalAddr();
    }

    private static boolean readRevealLocalAddr() {
        if (System.getSecurityManager() != null) {
            try {
                revealLocalAddress = Boolean.parseBoolean((String) AccessController.doPrivileged(new PrivilegedExceptionAction<String>() {
                    /*  JADX ERROR: Method load error
                        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.net.NetUtil.1.run():java.lang.Object, dex: classes.dex
                        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
                        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
                        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
                        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
                        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
                        	... 5 more
                        */
                    public /* bridge */ /* synthetic */ java.lang.Object run() {
                        /*
                        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.net.NetUtil.1.run():java.lang.Object, dex: classes.dex
                        */
                        throw new UnsupportedOperationException("Method not decompiled: java.net.NetUtil.AnonymousClass1.run():java.lang.Object");
                    }

                    public String run() {
                        return System.getProperty("jdk.net.revealLocalAddress");
                    }
                }));
            } catch (Exception e) {
            }
            propRevealLocalAddr = true;
        }
        return revealLocalAddress;
    }
}
