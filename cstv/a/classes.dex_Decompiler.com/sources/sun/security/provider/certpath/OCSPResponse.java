package sun.security.provider.certpath;

import java.security.cert.CRLReason;
import java.security.cert.Extension;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import sun.security.provider.certpath.OCSP;
import sun.security.util.Debug;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.KeyIdentifier;
import sun.security.x509.X509CertImpl;

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
public final class OCSPResponse {

    /* renamed from: -sun-security-provider-certpath-OCSPResponse$ResponseStatusSwitchesValues  reason: not valid java name */
    private static final /* synthetic */ int[] f143sunsecurityprovidercertpathOCSPResponse$ResponseStatusSwitchesValues = null;
    private static final int CERT_STATUS_GOOD = 0;
    private static final int CERT_STATUS_REVOKED = 1;
    private static final int CERT_STATUS_UNKNOWN = 2;
    private static final int DEFAULT_MAX_CLOCK_SKEW = 900000;
    private static final int KEY_TAG = 2;
    private static final String KP_OCSP_SIGNING_OID = "1.3.6.1.5.5.7.3.9";
    private static final int MAX_CLOCK_SKEW = 0;
    private static final int NAME_TAG = 1;
    private static final ObjectIdentifier OCSP_BASIC_RESPONSE_OID = null;
    /* access modifiers changed from: private */
    public static final Debug debug = null;
    private static final boolean dump = false;
    private static ResponseStatus[] rsvalues;
    /* access modifiers changed from: private */
    public static CRLReason[] values;
    private List<X509CertImpl> certs;
    private KeyIdentifier responderKeyId;
    private X500Principal responderName;
    private final byte[] responseNonce;
    private final ResponseStatus responseStatus;
    private final AlgorithmId sigAlgId;
    private final byte[] signature;
    private X509CertImpl signerCert;
    private final Map<CertId, SingleResponse> singleResponseMap;
    private final byte[] tbsResponseData;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum ResponseStatus {
    }

    static final class SingleResponse implements OCSP.RevocationStatus {
        private final CertId certId;
        private final OCSP.RevocationStatus.CertStatus certStatus;
        private final Date nextUpdate;
        private final CRLReason revocationReason;
        private final Date revocationTime;
        private final Map<String, Extension> singleExtensions;
        private final Date thisUpdate;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.-get0(sun.security.provider.certpath.OCSPResponse$SingleResponse):java.util.Date, dex: classes.dex
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
        /* renamed from: -get0 */
        static /* synthetic */ java.util.Date m714get0(sun.security.provider.certpath.OCSPResponse.SingleResponse r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.-get0(sun.security.provider.certpath.OCSPResponse$SingleResponse):java.util.Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.m714get0(sun.security.provider.certpath.OCSPResponse$SingleResponse):java.util.Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.-get1(sun.security.provider.certpath.OCSPResponse$SingleResponse):java.util.Date, dex: classes.dex
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
        /* renamed from: -get1 */
        static /* synthetic */ java.util.Date m715get1(sun.security.provider.certpath.OCSPResponse.SingleResponse r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.-get1(sun.security.provider.certpath.OCSPResponse$SingleResponse):java.util.Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.m715get1(sun.security.provider.certpath.OCSPResponse$SingleResponse):java.util.Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00f0 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.<init>(sun.security.util.DerValue):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00f0
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        private SingleResponse(sun.security.util.DerValue r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00f0 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.<init>(sun.security.util.DerValue):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.<init>(sun.security.util.DerValue):void");
        }

        /* synthetic */ SingleResponse(DerValue der, SingleResponse singleResponse) {
            this(der);
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getCertId():sun.security.provider.certpath.CertId, dex: classes.dex
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
        public sun.security.provider.certpath.CertId getCertId() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getCertId():sun.security.provider.certpath.CertId, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.getCertId():sun.security.provider.certpath.CertId");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getCertStatus():sun.security.provider.certpath.OCSP$RevocationStatus$CertStatus, dex: classes.dex
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
        public sun.security.provider.certpath.OCSP.RevocationStatus.CertStatus getCertStatus() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getCertStatus():sun.security.provider.certpath.OCSP$RevocationStatus$CertStatus, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.getCertStatus():sun.security.provider.certpath.OCSP$RevocationStatus$CertStatus");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        public java.security.cert.CRLReason getRevocationReason() {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationReason():java.security.cert.CRLReason");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationTime():java.util.Date, dex: classes.dex
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
        public java.util.Date getRevocationTime() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationTime():java.util.Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.getRevocationTime():java.util.Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getSingleExtensions():java.util.Map<java.lang.String, java.security.cert.Extension>, dex: classes.dex
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
        public java.util.Map<java.lang.String, java.security.cert.Extension> getSingleExtensions() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.getSingleExtensions():java.util.Map<java.lang.String, java.security.cert.Extension>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.getSingleExtensions():java.util.Map");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.toString():java.lang.String, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSPResponse.SingleResponse.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.SingleResponse.toString():java.lang.String");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSPResponse.-getsun-security-provider-certpath-OCSPResponse$ResponseStatusSwitchesValues():int[], dex: classes.dex
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
    /* renamed from: -getsun-security-provider-certpath-OCSPResponse$ResponseStatusSwitchesValues */
    private static /* synthetic */ int[] m713getsunsecurityprovidercertpathOCSPResponse$ResponseStatusSwitchesValues() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSPResponse.-getsun-security-provider-certpath-OCSPResponse$ResponseStatusSwitchesValues():int[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.m713getsunsecurityprovidercertpathOCSPResponse$ResponseStatusSwitchesValues():int[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.OCSPResponse.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.OCSPResponse.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.<clinit>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.OCSPResponse.<init>(byte[]):void, dex: classes.dex
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
    OCSPResponse(byte[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.security.provider.certpath.OCSPResponse.<init>(byte[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.<init>(byte[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSPResponse.initializeClockSkew():int, dex: classes.dex
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
    private static int initializeClockSkew() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSPResponse.initializeClockSkew():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.initializeClockSkew():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.verifySignature(java.security.cert.X509Certificate):boolean, dex: classes.dex
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
    private boolean verifySignature(java.security.cert.X509Certificate r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.verifySignature(java.security.cert.X509Certificate):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.verifySignature(java.security.cert.X509Certificate):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.OCSPResponse.getResponseStatus():sun.security.provider.certpath.OCSPResponse$ResponseStatus, dex: classes.dex in method: sun.security.provider.certpath.OCSPResponse.getResponseStatus():sun.security.provider.certpath.OCSPResponse$ResponseStatus, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.OCSPResponse.getResponseStatus():sun.security.provider.certpath.OCSPResponse$ResponseStatus, dex: classes.dex
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
    sun.security.provider.certpath.OCSPResponse.ResponseStatus getResponseStatus() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.OCSPResponse.getResponseStatus():sun.security.provider.certpath.OCSPResponse$ResponseStatus, dex: classes.dex in method: sun.security.provider.certpath.OCSPResponse.getResponseStatus():sun.security.provider.certpath.OCSPResponse$ResponseStatus, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.getResponseStatus():sun.security.provider.certpath.OCSPResponse$ResponseStatus");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.OCSPResponse.getSignerCertificate():java.security.cert.X509Certificate, dex: classes.dex in method: sun.security.provider.certpath.OCSPResponse.getSignerCertificate():java.security.cert.X509Certificate, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.OCSPResponse.getSignerCertificate():java.security.cert.X509Certificate, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
        	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    java.security.cert.X509Certificate getSignerCertificate() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.OCSPResponse.getSignerCertificate():java.security.cert.X509Certificate, dex: classes.dex in method: sun.security.provider.certpath.OCSPResponse.getSignerCertificate():java.security.cert.X509Certificate, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.getSignerCertificate():java.security.cert.X509Certificate");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.getSingleResponse(sun.security.provider.certpath.CertId):sun.security.provider.certpath.OCSPResponse$SingleResponse, dex: classes.dex
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
    sun.security.provider.certpath.OCSPResponse.SingleResponse getSingleResponse(sun.security.provider.certpath.CertId r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.getSingleResponse(sun.security.provider.certpath.CertId):sun.security.provider.certpath.OCSPResponse$SingleResponse, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.getSingleResponse(sun.security.provider.certpath.CertId):sun.security.provider.certpath.OCSPResponse$SingleResponse");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.verify(java.util.List, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.util.Date, byte[]):void, dex: classes.dex
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
    void verify(java.util.List<sun.security.provider.certpath.CertId> r1, java.security.cert.X509Certificate r2, java.security.cert.X509Certificate r3, java.util.Date r4, byte[] r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.OCSPResponse.verify(java.util.List, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.util.Date, byte[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSPResponse.verify(java.util.List, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.util.Date, byte[]):void");
    }
}
