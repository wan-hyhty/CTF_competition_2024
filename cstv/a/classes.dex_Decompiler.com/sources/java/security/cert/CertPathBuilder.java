package java.security.cert;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.Security;
import sun.security.validator.Validator;

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
public class CertPathBuilder {
    private static final String CPB_TYPE = "certpathbuilder.type";
    private final String algorithm;
    private final CertPathBuilderSpi builderSpi;
    private final Provider provider;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.cert.CertPathBuilder.<init>(java.security.cert.CertPathBuilderSpi, java.security.Provider, java.lang.String):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    protected CertPathBuilder(java.security.cert.CertPathBuilderSpi r1, java.security.Provider r2, java.lang.String r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.cert.CertPathBuilder.<init>(java.security.cert.CertPathBuilderSpi, java.security.Provider, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.<init>(java.security.cert.CertPathBuilderSpi, java.security.Provider, java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getInstance(java.lang.String):java.security.cert.CertPathBuilder, dex: classes.dex
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
    public static java.security.cert.CertPathBuilder getInstance(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getInstance(java.lang.String):java.security.cert.CertPathBuilder, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.getInstance(java.lang.String):java.security.cert.CertPathBuilder");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getInstance(java.lang.String, java.lang.String):java.security.cert.CertPathBuilder, dex: classes.dex
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
    public static java.security.cert.CertPathBuilder getInstance(java.lang.String r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getInstance(java.lang.String, java.lang.String):java.security.cert.CertPathBuilder, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.getInstance(java.lang.String, java.lang.String):java.security.cert.CertPathBuilder");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getInstance(java.lang.String, java.security.Provider):java.security.cert.CertPathBuilder, dex: classes.dex
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
    public static java.security.cert.CertPathBuilder getInstance(java.lang.String r1, java.security.Provider r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getInstance(java.lang.String, java.security.Provider):java.security.cert.CertPathBuilder, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.getInstance(java.lang.String, java.security.Provider):java.security.cert.CertPathBuilder");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.build(java.security.cert.CertPathParameters):java.security.cert.CertPathBuilderResult, dex: classes.dex
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
    public final java.security.cert.CertPathBuilderResult build(java.security.cert.CertPathParameters r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.build(java.security.cert.CertPathParameters):java.security.cert.CertPathBuilderResult, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.build(java.security.cert.CertPathParameters):java.security.cert.CertPathBuilderResult");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getAlgorithm():java.lang.String, dex: classes.dex
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
    public final java.lang.String getAlgorithm() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getAlgorithm():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.getAlgorithm():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getProvider():java.security.Provider, dex: classes.dex
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
    public final java.security.Provider getProvider() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getProvider():java.security.Provider, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.getProvider():java.security.Provider");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getRevocationChecker():java.security.cert.CertPathChecker, dex: classes.dex
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
    public final java.security.cert.CertPathChecker getRevocationChecker() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertPathBuilder.getRevocationChecker():java.security.cert.CertPathChecker, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.getRevocationChecker():java.security.cert.CertPathChecker");
    }

    public static final String getDefaultType() {
        String cpbtype = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertPathBuilder.1.run():java.lang.Object, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertPathBuilder.1.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertPathBuilder.AnonymousClass1.run():java.lang.Object");
            }

            public String run() {
                return Security.getProperty(CertPathBuilder.CPB_TYPE);
            }
        });
        return cpbtype == null ? Validator.TYPE_PKIX : cpbtype;
    }
}
