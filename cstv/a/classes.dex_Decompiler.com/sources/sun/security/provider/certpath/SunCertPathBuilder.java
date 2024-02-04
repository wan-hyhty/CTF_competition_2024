package sun.security.provider.certpath;

import java.security.PublicKey;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathChecker;
import java.security.cert.CertificateFactory;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public final class SunCertPathBuilder extends CertPathBuilderSpi {
    private static final Debug debug = null;
    private PKIX.BuilderParams buildParams;
    private CertificateFactory cf;
    private PublicKey finalPublicKey;
    private boolean pathCompleted;
    private PolicyNode policyTreeResult;
    private TrustAnchor trustAnchor;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.anchorIsTarget(java.security.cert.TrustAnchor, java.security.cert.CertSelector):boolean, dex: classes.dex
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
    private static boolean anchorIsTarget(java.security.cert.TrustAnchor r1, java.security.cert.CertSelector r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.anchorIsTarget(java.security.cert.TrustAnchor, java.security.cert.CertSelector):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.anchorIsTarget(java.security.cert.TrustAnchor, java.security.cert.CertSelector):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.build():java.security.cert.PKIXCertPathBuilderResult, dex: classes.dex
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
    private java.security.cert.PKIXCertPathBuilderResult build() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.build():java.security.cert.PKIXCertPathBuilderResult, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.build():java.security.cert.PKIXCertPathBuilderResult");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00eb in method: sun.security.provider.certpath.SunCertPathBuilder.buildCertPath(boolean, java.util.List):java.security.cert.PKIXCertPathBuilderResult, dex: classes.dex
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
    private java.security.cert.PKIXCertPathBuilderResult buildCertPath(boolean r1, java.util.List<java.util.List<sun.security.provider.certpath.Vertex>> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00eb in method: sun.security.provider.certpath.SunCertPathBuilder.buildCertPath(boolean, java.util.List):java.security.cert.PKIXCertPathBuilderResult, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.buildCertPath(boolean, java.util.List):java.security.cert.PKIXCertPathBuilderResult");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.buildForward(java.util.List, java.util.LinkedList, boolean):void, dex: classes.dex
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
    private void buildForward(java.util.List<java.util.List<sun.security.provider.certpath.Vertex>> r1, java.util.LinkedList<java.security.cert.X509Certificate> r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.buildForward(java.util.List, java.util.LinkedList, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.buildForward(java.util.List, java.util.LinkedList, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.buildReverse(java.util.List, java.util.LinkedList):void, dex: classes.dex
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
    private void buildReverse(java.util.List<java.util.List<sun.security.provider.certpath.Vertex>> r1, java.util.LinkedList<java.security.cert.X509Certificate> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.buildReverse(java.util.List, java.util.LinkedList):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.buildReverse(java.util.List, java.util.LinkedList):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.depthFirstSearchForward(javax.security.auth.x500.X500Principal, sun.security.provider.certpath.ForwardState, sun.security.provider.certpath.ForwardBuilder, java.util.List, java.util.LinkedList):void, dex: classes.dex
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
    private void depthFirstSearchForward(javax.security.auth.x500.X500Principal r1, sun.security.provider.certpath.ForwardState r2, sun.security.provider.certpath.ForwardBuilder r3, java.util.List<java.util.List<sun.security.provider.certpath.Vertex>> r4, java.util.LinkedList<java.security.cert.X509Certificate> r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.depthFirstSearchForward(javax.security.auth.x500.X500Principal, sun.security.provider.certpath.ForwardState, sun.security.provider.certpath.ForwardBuilder, java.util.List, java.util.LinkedList):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.depthFirstSearchForward(javax.security.auth.x500.X500Principal, sun.security.provider.certpath.ForwardState, sun.security.provider.certpath.ForwardBuilder, java.util.List, java.util.LinkedList):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.depthFirstSearchReverse(javax.security.auth.x500.X500Principal, sun.security.provider.certpath.ReverseState, sun.security.provider.certpath.ReverseBuilder, java.util.List, java.util.LinkedList):void, dex: classes.dex
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
    private void depthFirstSearchReverse(javax.security.auth.x500.X500Principal r1, sun.security.provider.certpath.ReverseState r2, sun.security.provider.certpath.ReverseBuilder r3, java.util.List<java.util.List<sun.security.provider.certpath.Vertex>> r4, java.util.LinkedList<java.security.cert.X509Certificate> r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.depthFirstSearchReverse(javax.security.auth.x500.X500Principal, sun.security.provider.certpath.ReverseState, sun.security.provider.certpath.ReverseBuilder, java.util.List, java.util.LinkedList):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.depthFirstSearchReverse(javax.security.auth.x500.X500Principal, sun.security.provider.certpath.ReverseState, sun.security.provider.certpath.ReverseBuilder, java.util.List, java.util.LinkedList):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.engineBuild(java.security.cert.CertPathParameters):java.security.cert.CertPathBuilderResult, dex: classes.dex
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
    public java.security.cert.CertPathBuilderResult engineBuild(java.security.cert.CertPathParameters r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.SunCertPathBuilder.engineBuild(java.security.cert.CertPathParameters):java.security.cert.CertPathBuilderResult, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.engineBuild(java.security.cert.CertPathParameters):java.security.cert.CertPathBuilderResult");
    }

    public CertPathChecker engineGetRevocationChecker() {
        return new RevocationChecker();
    }

    private static List<Vertex> addVertices(Collection<X509Certificate> certs, List<List<Vertex>> adjList) {
        List<Vertex> l = adjList.get(adjList.size() - 1);
        for (X509Certificate cert : certs) {
            l.add(new Vertex(cert));
        }
        return l;
    }
}
