package java.security;

import java.io.Serializable;
import java.net.URL;
import java.security.cert.Certificate;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class CodeSource implements Serializable {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.CodeSource.<init>(java.net.URL, java.security.CodeSigner[]):void, dex: classes.dex
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
    public CodeSource(java.net.URL r1, java.security.CodeSigner[] r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.CodeSource.<init>(java.net.URL, java.security.CodeSigner[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.CodeSource.<init>(java.net.URL, java.security.CodeSigner[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.CodeSource.<init>(java.net.URL, java.security.cert.Certificate[]):void, dex: classes.dex
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
    public CodeSource(java.net.URL r1, java.security.cert.Certificate[] r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.CodeSource.<init>(java.net.URL, java.security.cert.Certificate[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.CodeSource.<init>(java.net.URL, java.security.cert.Certificate[]):void");
    }

    public final URL getLocation() {
        return null;
    }

    public final Certificate[] getCertificates() {
        return null;
    }

    public final CodeSigner[] getCodeSigners() {
        return null;
    }

    public boolean implies(CodeSource codesource) {
        return true;
    }
}
