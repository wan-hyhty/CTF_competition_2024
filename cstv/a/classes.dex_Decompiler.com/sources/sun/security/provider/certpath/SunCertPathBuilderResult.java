package sun.security.provider.certpath;

import java.security.cert.PKIXCertPathBuilderResult;
import sun.security.util.Debug;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class SunCertPathBuilderResult extends PKIXCertPathBuilderResult {
    private static final Debug debug = null;
    private AdjacencyList adjList;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.SunCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey, sun.security.provider.certpath.AdjacencyList):void, dex: classes.dex in method: sun.security.provider.certpath.SunCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey, sun.security.provider.certpath.AdjacencyList):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.SunCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey, sun.security.provider.certpath.AdjacencyList):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    SunCertPathBuilderResult(java.security.cert.CertPath r1, java.security.cert.TrustAnchor r2, java.security.cert.PolicyNode r3, java.security.PublicKey r4, sun.security.provider.certpath.AdjacencyList r5) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.SunCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey, sun.security.provider.certpath.AdjacencyList):void, dex: classes.dex in method: sun.security.provider.certpath.SunCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey, sun.security.provider.certpath.AdjacencyList):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilderResult.<init>(java.security.cert.CertPath, java.security.cert.TrustAnchor, java.security.cert.PolicyNode, java.security.PublicKey, sun.security.provider.certpath.AdjacencyList):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.SunCertPathBuilderResult.getAdjacencyList():sun.security.provider.certpath.AdjacencyList, dex: classes.dex in method: sun.security.provider.certpath.SunCertPathBuilderResult.getAdjacencyList():sun.security.provider.certpath.AdjacencyList, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.SunCertPathBuilderResult.getAdjacencyList():sun.security.provider.certpath.AdjacencyList, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public sun.security.provider.certpath.AdjacencyList getAdjacencyList() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.SunCertPathBuilderResult.getAdjacencyList():sun.security.provider.certpath.AdjacencyList, dex: classes.dex in method: sun.security.provider.certpath.SunCertPathBuilderResult.getAdjacencyList():sun.security.provider.certpath.AdjacencyList, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilderResult.getAdjacencyList():sun.security.provider.certpath.AdjacencyList");
    }
}
