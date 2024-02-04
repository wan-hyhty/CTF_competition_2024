package sun.security.provider.certpath;

import java.security.PublicKey;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import sun.security.util.Debug;
import sun.security.x509.NameConstraintsExtension;
import sun.security.x509.SubjectKeyIdentifierExtension;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
class ReverseState implements State {
    private static final Debug debug = null;
    AlgorithmChecker algorithmChecker;
    int certIndex;
    boolean crlSign;
    int explicitPolicy;
    int inhibitAnyPolicy;
    private boolean init;
    NameConstraintsExtension nc;
    int policyMapping;
    PublicKey pubKey;
    int remainingCACerts;
    RevocationChecker revChecker;
    PolicyNodeImpl rootNode;
    SubjectKeyIdentifierExtension subjKeyId;
    X500Principal subjectDN;
    TrustAnchor trustAnchor;
    UntrustedChecker untrustedChecker;
    ArrayList<PKIXCertPathChecker> userCheckers;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00eb in method: sun.security.provider.certpath.ReverseState.<init>():void, dex: classes.dex
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
    ReverseState() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00eb in method: sun.security.provider.certpath.ReverseState.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.ReverseState.updateState(java.security.PublicKey, javax.security.auth.x500.X500Principal):void, dex: classes.dex
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
    private void updateState(java.security.PublicKey r1, javax.security.auth.x500.X500Principal r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.ReverseState.updateState(java.security.PublicKey, javax.security.auth.x500.X500Principal):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.updateState(java.security.PublicKey, javax.security.auth.x500.X500Principal):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.ReverseState.clone():java.lang.Object, dex: classes.dex in method: sun.security.provider.certpath.ReverseState.clone():java.lang.Object, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.ReverseState.clone():java.lang.Object, dex: classes.dex
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
    public java.lang.Object clone() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.ReverseState.clone():java.lang.Object, dex: classes.dex in method: sun.security.provider.certpath.ReverseState.clone():java.lang.Object, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.clone():java.lang.Object");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.ReverseState.initState(sun.security.provider.certpath.PKIX$BuilderParams):void, dex: classes.dex
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
    public void initState(sun.security.provider.certpath.PKIX.BuilderParams r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.ReverseState.initState(sun.security.provider.certpath.PKIX$BuilderParams):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.initState(sun.security.provider.certpath.PKIX$BuilderParams):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.ReverseState.isInitial():boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public boolean isInitial() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.ReverseState.isInitial():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.isInitial():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.ReverseState.toString():java.lang.String, dex: classes.dex
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
    public java.lang.String toString() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.ReverseState.toString():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.toString():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.ReverseState.updateState(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$BuilderParams):void, dex: classes.dex
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
    public void updateState(java.security.cert.TrustAnchor r1, sun.security.provider.certpath.PKIX.BuilderParams r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.ReverseState.updateState(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$BuilderParams):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.updateState(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$BuilderParams):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.ReverseState.updateState(java.security.cert.X509Certificate):void, dex: classes.dex
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
    public void updateState(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.ReverseState.updateState(java.security.cert.X509Certificate):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.ReverseState.updateState(java.security.cert.X509Certificate):void");
    }

    public boolean keyParamsNeeded() {
        return false;
    }
}
