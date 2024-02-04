package java.security;

import java.io.Serializable;
import java.security.cert.Certificate;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public final class UnresolvedPermission extends Permission implements Serializable {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.UnresolvedPermission.<init>(java.lang.String, java.lang.String, java.lang.String, java.security.cert.Certificate[]):void, dex: classes.dex
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
    public UnresolvedPermission(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.security.cert.Certificate[] r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.UnresolvedPermission.<init>(java.lang.String, java.lang.String, java.lang.String, java.security.cert.Certificate[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.UnresolvedPermission.<init>(java.lang.String, java.lang.String, java.lang.String, java.security.cert.Certificate[]):void");
    }

    public boolean implies(Permission p) {
        return false;
    }

    public String getActions() {
        return null;
    }

    public String getUnresolvedType() {
        return null;
    }

    public String getUnresolvedName() {
        return null;
    }

    public String getUnresolvedActions() {
        return null;
    }

    public Certificate[] getUnresolvedCerts() {
        return null;
    }
}
