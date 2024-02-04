package sun.security.provider.certpath;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PublicKey;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.Extension;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;

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
class RevocationChecker extends PKIXRevocationChecker {

    /* renamed from: -java-security-cert-PKIXRevocationChecker$OptionSwitchesValues  reason: not valid java name */
    private static final /* synthetic */ int[] f144javasecuritycertPKIXRevocationChecker$OptionSwitchesValues = null;

    /* renamed from: -sun-security-provider-certpath-RevocationChecker$ModeSwitchesValues  reason: not valid java name */
    private static final /* synthetic */ int[] f145sunsecurityprovidercertpathRevocationChecker$ModeSwitchesValues = null;
    private static final boolean[] ALL_REASONS = null;
    private static final boolean[] CRL_SIGN_USAGE = null;
    private static final String HEX_DIGITS = "0123456789ABCDEFabcdef";
    private static final long MAX_CLOCK_SKEW = 900000;
    /* access modifiers changed from: private */
    public static final Debug debug = null;
    private TrustAnchor anchor;
    private int certIndex;
    private List<CertStore> certStores;
    private boolean crlDP;
    private boolean crlSignFlag;
    private X509Certificate issuerCert;
    private boolean legacy;
    private Mode mode;
    private List<Extension> ocspExtensions;
    private Map<X509Certificate, byte[]> ocspResponses;
    private boolean onlyEE;
    private PKIX.ValidatorParams params;
    private PublicKey prevPubKey;
    private X509Certificate responderCert;
    private URI responderURI;
    private boolean softFail;
    private LinkedList<CertPathValidatorException> softFailExceptions;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    private enum Mode {
        ;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.Mode.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.Mode.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.Mode.<clinit>():void");
        }
    }

    private static class RejectKeySelector extends X509CertSelector {
        private final Set<PublicKey> badKeySet;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.<init>(java.util.Set):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        RejectKeySelector(java.util.Set<java.security.PublicKey> r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.<init>(java.util.Set):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.<init>(java.util.Set):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.match(java.security.cert.Certificate):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean match(java.security.cert.Certificate r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.match(java.security.cert.Certificate):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.match(java.security.cert.Certificate):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.toString():java.lang.String, dex: classes.dex
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
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.RejectKeySelector.toString():java.lang.String");
        }
    }

    private static class RevocationProperties {
        boolean crlDPEnabled;
        boolean ocspEnabled;
        String ocspIssuer;
        String ocspSerial;
        String ocspSubject;
        String ocspUrl;
        boolean onlyEE;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.RevocationProperties.<init>():void, dex: classes.dex
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
        private RevocationProperties() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.RevocationProperties.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.RevocationProperties.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.RevocationProperties.<init>(sun.security.provider.certpath.RevocationChecker$RevocationProperties):void, dex: classes.dex
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
        /* synthetic */ RevocationProperties(sun.security.provider.certpath.RevocationChecker.RevocationProperties r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.RevocationProperties.<init>(sun.security.provider.certpath.RevocationChecker$RevocationProperties):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.RevocationProperties.<init>(sun.security.provider.certpath.RevocationChecker$RevocationProperties):void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.-getjava-security-cert-PKIXRevocationChecker$OptionSwitchesValues():int[], dex: classes.dex
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
    /* renamed from: -getjava-security-cert-PKIXRevocationChecker$OptionSwitchesValues */
    private static /* synthetic */ int[] m719getjavasecuritycertPKIXRevocationChecker$OptionSwitchesValues() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.-getjava-security-cert-PKIXRevocationChecker$OptionSwitchesValues():int[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.m719getjavasecuritycertPKIXRevocationChecker$OptionSwitchesValues():int[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.-getsun-security-provider-certpath-RevocationChecker$ModeSwitchesValues():int[], dex: classes.dex
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
    /* renamed from: -getsun-security-provider-certpath-RevocationChecker$ModeSwitchesValues */
    private static /* synthetic */ int[] m720getsunsecurityprovidercertpathRevocationChecker$ModeSwitchesValues() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.-getsun-security-provider-certpath-RevocationChecker$ModeSwitchesValues():int[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.m720getsunsecurityprovidercertpathRevocationChecker$ModeSwitchesValues():int[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.<clinit>():void, dex: classes.dex
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.RevocationChecker.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.<clinit>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.<init>():void, dex: classes.dex
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
    RevocationChecker() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.<init>(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$ValidatorParams):void, dex: classes.dex
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
    RevocationChecker(java.security.cert.TrustAnchor r1, sun.security.provider.certpath.PKIX.ValidatorParams r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.<init>(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$ValidatorParams):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.<init>(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$ValidatorParams):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.buildToNewKey(java.security.cert.X509Certificate, java.security.PublicKey, java.util.Set):void, dex: classes.dex
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
    private void buildToNewKey(java.security.cert.X509Certificate r1, java.security.PublicKey r2, java.util.Set<java.security.cert.X509Certificate> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.buildToNewKey(java.security.cert.X509Certificate, java.security.PublicKey, java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.buildToNewKey(java.security.cert.X509Certificate, java.security.PublicKey, java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.certCanSignCrl(java.security.cert.X509Certificate):boolean, dex: classes.dex
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
    static boolean certCanSignCrl(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.certCanSignCrl(java.security.cert.X509Certificate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.certCanSignCrl(java.security.cert.X509Certificate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.RevocationChecker.check(java.security.cert.X509Certificate, java.util.Collection, java.security.PublicKey, boolean):void, dex: classes.dex
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
    private void check(java.security.cert.X509Certificate r1, java.util.Collection<java.lang.String> r2, java.security.PublicKey r3, boolean r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.RevocationChecker.check(java.security.cert.X509Certificate, java.util.Collection, java.security.PublicKey, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.check(java.security.cert.X509Certificate, java.util.Collection, java.security.PublicKey, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.RevocationChecker.checkApprovedCRLs(java.security.cert.X509Certificate, java.util.Set):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ea
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    private void checkApprovedCRLs(java.security.cert.X509Certificate r1, java.util.Set<java.security.cert.X509CRL> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.RevocationChecker.checkApprovedCRLs(java.security.cert.X509Certificate, java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.checkApprovedCRLs(java.security.cert.X509Certificate, java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.checkCRLs(java.security.cert.X509Certificate, java.security.PublicKey, java.security.cert.X509Certificate, boolean, boolean, java.util.Set, java.util.Set):void, dex: classes.dex
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
    private void checkCRLs(java.security.cert.X509Certificate r1, java.security.PublicKey r2, java.security.cert.X509Certificate r3, boolean r4, boolean r5, java.util.Set<java.security.cert.X509Certificate> r6, java.util.Set<java.security.cert.TrustAnchor> r7) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.checkCRLs(java.security.cert.X509Certificate, java.security.PublicKey, java.security.cert.X509Certificate, boolean, boolean, java.util.Set, java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.checkCRLs(java.security.cert.X509Certificate, java.security.PublicKey, java.security.cert.X509Certificate, boolean, boolean, java.util.Set, java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.checkCRLs(java.security.cert.X509Certificate, java.util.Collection, java.util.Set, java.security.PublicKey, boolean):void, dex: classes.dex
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
    private void checkCRLs(java.security.cert.X509Certificate r1, java.util.Collection<java.lang.String> r2, java.util.Set<java.security.cert.X509Certificate> r3, java.security.PublicKey r4, boolean r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.checkCRLs(java.security.cert.X509Certificate, java.util.Collection, java.util.Set, java.security.PublicKey, boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.checkCRLs(java.security.cert.X509Certificate, java.util.Collection, java.util.Set, java.security.PublicKey, boolean):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.checkOCSP(java.security.cert.X509Certificate, java.util.Collection):void, dex: classes.dex
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
    private void checkOCSP(java.security.cert.X509Certificate r1, java.util.Collection<java.lang.String> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.checkOCSP(java.security.cert.X509Certificate, java.util.Collection):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.checkOCSP(java.security.cert.X509Certificate, java.util.Collection):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.lang.String, java.lang.String, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
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
    private static java.security.cert.X509Certificate getResponderCert(java.lang.String r1, java.lang.String r2, java.util.Set<java.security.cert.TrustAnchor> r3, java.util.List<java.security.cert.CertStore> r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.lang.String, java.lang.String, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.lang.String, java.lang.String, java.util.Set, java.util.List):java.security.cert.X509Certificate");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.lang.String, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
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
    private static java.security.cert.X509Certificate getResponderCert(java.lang.String r1, java.util.Set<java.security.cert.TrustAnchor> r2, java.util.List<java.security.cert.CertStore> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.lang.String, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.lang.String, java.util.Set, java.util.List):java.security.cert.X509Certificate");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.security.cert.X509CertSelector, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
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
    private static java.security.cert.X509Certificate getResponderCert(java.security.cert.X509CertSelector r1, java.util.Set<java.security.cert.TrustAnchor> r2, java.util.List<java.security.cert.CertStore> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.security.cert.X509CertSelector, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.getResponderCert(java.security.cert.X509CertSelector, java.util.Set, java.util.List):java.security.cert.X509Certificate");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(sun.security.provider.certpath.RevocationChecker$RevocationProperties, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
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
    private static java.security.cert.X509Certificate getResponderCert(sun.security.provider.certpath.RevocationChecker.RevocationProperties r1, java.util.Set<java.security.cert.TrustAnchor> r2, java.util.List<java.security.cert.CertStore> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.getResponderCert(sun.security.provider.certpath.RevocationChecker$RevocationProperties, java.util.Set, java.util.List):java.security.cert.X509Certificate, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.getResponderCert(sun.security.provider.certpath.RevocationChecker$RevocationProperties, java.util.Set, java.util.List):java.security.cert.X509Certificate");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.RevocationChecker.isSoftFailException(java.security.cert.CertPathValidatorException):boolean, dex: classes.dex
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
    private boolean isSoftFailException(java.security.cert.CertPathValidatorException r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.RevocationChecker.isSoftFailException(java.security.cert.CertPathValidatorException):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.isSoftFailException(java.security.cert.CertPathValidatorException):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.stripOutSeparators(java.lang.String):java.lang.String, dex: classes.dex
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
    private static java.lang.String stripOutSeparators(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.stripOutSeparators(java.lang.String):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.stripOutSeparators(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.updateState(java.security.cert.X509Certificate):void, dex: classes.dex
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
    private void updateState(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.RevocationChecker.updateState(java.security.cert.X509Certificate):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.updateState(java.security.cert.X509Certificate):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.verifyPossibleCRLs(java.util.Set, java.security.cert.X509Certificate, java.security.PublicKey, boolean, boolean[], java.util.Set):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
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
    private java.util.Collection<java.security.cert.X509CRL> verifyPossibleCRLs(java.util.Set<java.security.cert.X509CRL> r1, java.security.cert.X509Certificate r2, java.security.PublicKey r3, boolean r4, boolean[] r5, java.util.Set<java.security.cert.TrustAnchor> r6) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.verifyPossibleCRLs(java.util.Set, java.security.cert.X509Certificate, java.security.PublicKey, boolean, boolean[], java.util.Set):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.verifyPossibleCRLs(java.util.Set, java.security.cert.X509Certificate, java.security.PublicKey, boolean, boolean[], java.util.Set):java.util.Collection");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.verifyWithSeparateSigningKey(java.security.cert.X509Certificate, java.security.PublicKey, boolean, java.util.Set):void, dex: classes.dex
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
    private void verifyWithSeparateSigningKey(java.security.cert.X509Certificate r1, java.security.PublicKey r2, boolean r3, java.util.Set<java.security.cert.X509Certificate> r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.verifyWithSeparateSigningKey(java.security.cert.X509Certificate, java.security.PublicKey, boolean, java.util.Set):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.verifyWithSeparateSigningKey(java.security.cert.X509Certificate, java.security.PublicKey, boolean, java.util.Set):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.check(java.security.cert.Certificate, java.util.Collection):void, dex: classes.dex
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
    public void check(java.security.cert.Certificate r1, java.util.Collection<java.lang.String> r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.check(java.security.cert.Certificate, java.util.Collection):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.check(java.security.cert.Certificate, java.util.Collection):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.clone():java.security.cert.PKIXRevocationChecker, dex: classes.dex
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
    public /* bridge */ /* synthetic */ java.security.cert.PKIXRevocationChecker clone() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.clone():java.security.cert.PKIXRevocationChecker, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.clone():java.security.cert.PKIXRevocationChecker");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.clone():sun.security.provider.certpath.RevocationChecker, dex: classes.dex
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
    public sun.security.provider.certpath.RevocationChecker clone() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.clone():sun.security.provider.certpath.RevocationChecker, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.clone():sun.security.provider.certpath.RevocationChecker");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.getSoftFailExceptions():java.util.List<java.security.cert.CertPathValidatorException>, dex: classes.dex
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
    public java.util.List<java.security.cert.CertPathValidatorException> getSoftFailExceptions() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.getSoftFailExceptions():java.util.List<java.security.cert.CertPathValidatorException>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.getSoftFailExceptions():java.util.List");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.init(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$ValidatorParams):void, dex: classes.dex
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
    void init(java.security.cert.TrustAnchor r1, sun.security.provider.certpath.PKIX.ValidatorParams r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.init(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$ValidatorParams):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.init(java.security.cert.TrustAnchor, sun.security.provider.certpath.PKIX$ValidatorParams):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.init(boolean):void, dex: classes.dex
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
    public void init(boolean r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.RevocationChecker.init(boolean):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.init(boolean):void");
    }

    private static URI toURI(String uriString) throws CertPathValidatorException {
        if (uriString == null) {
            return null;
        }
        try {
            return new URI(uriString);
        } catch (URISyntaxException e) {
            throw new CertPathValidatorException("cannot parse ocsp.responderURL property", e);
        }
    }

    private static RevocationProperties getRevocationProperties() {
        return (RevocationProperties) AccessController.doPrivileged(new PrivilegedAction<RevocationProperties>() {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.1.run():java.lang.Object, dex: classes.dex
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
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.RevocationChecker.1.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.AnonymousClass1.run():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.RevocationChecker.1.run():sun.security.provider.certpath.RevocationChecker$RevocationProperties, dex: classes.dex in method: sun.security.provider.certpath.RevocationChecker.1.run():sun.security.provider.certpath.RevocationChecker$RevocationProperties, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.RevocationChecker.1.run():sun.security.provider.certpath.RevocationChecker$RevocationProperties, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 5 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
                	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 6 more
                */
            public sun.security.provider.certpath.RevocationChecker.RevocationProperties run() {
                /*
                // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.RevocationChecker.1.run():sun.security.provider.certpath.RevocationChecker$RevocationProperties, dex: classes.dex in method: sun.security.provider.certpath.RevocationChecker.1.run():sun.security.provider.certpath.RevocationChecker$RevocationProperties, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.RevocationChecker.AnonymousClass1.run():sun.security.provider.certpath.RevocationChecker$RevocationProperties");
            }
        });
    }

    public boolean isForwardCheckingSupported() {
        return false;
    }

    public Set<String> getSupportedExtensions() {
        return null;
    }
}
