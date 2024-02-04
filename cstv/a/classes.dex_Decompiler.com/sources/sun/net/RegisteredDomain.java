package sun.net;

import java.util.Map;
import java.util.Set;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class RegisteredDomain {
    private static Set<String> arSet;
    private static Set<String> jp2Set;
    private static Set<String> jpSet;
    private static Set<String> omSet;
    private static Set<String> top1Set;
    private static Set<String> top2Set;
    private static Map<String, Set> top3Map;
    private static Set<String> top3Set;
    private static Set<String> top4Set;
    private static Set<String> top5Set;
    private static Map<String, Set> topMap;
    private static Set<String> ukSet;
    private static Set<String> usStateSet;
    private static Set<String> usSubStateSet;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.RegisteredDomain.getRegisteredDomain(java.lang.String):java.lang.String, dex: classes.dex
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
    public static java.lang.String getRegisteredDomain(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.RegisteredDomain.getRegisteredDomain(java.lang.String):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.RegisteredDomain.getRegisteredDomain(java.lang.String):java.lang.String");
    }
}
