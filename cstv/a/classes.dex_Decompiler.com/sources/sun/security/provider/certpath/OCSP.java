package sun.security.provider.certpath;

import java.io.IOException;
import java.net.URI;
import java.security.cert.CRLReason;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.Extension;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import sun.security.util.Debug;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.X509CertImpl;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public final class OCSP {
    private static final int CONNECT_TIMEOUT = 0;
    private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    static final ObjectIdentifier NONCE_EXTENSION_OID = null;
    private static final Debug debug = null;

    public interface RevocationStatus {

        /*  JADX ERROR: NullPointerException in pass: EnumVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
            	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
            */
        public enum CertStatus {
        }

        CertStatus getCertStatus();

        CRLReason getRevocationReason();

        Date getRevocationTime();

        Map<String, Extension> getSingleExtensions();
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.OCSP.<init>():void, dex: classes.dex
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
    private OCSP() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.OCSP.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSP.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.check(java.security.cert.X509Certificate, java.security.cert.X509Certificate):sun.security.provider.certpath.OCSP$RevocationStatus, dex: classes.dex
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
    public static sun.security.provider.certpath.OCSP.RevocationStatus check(java.security.cert.X509Certificate r1, java.security.cert.X509Certificate r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.check(java.security.cert.X509Certificate, java.security.cert.X509Certificate):sun.security.provider.certpath.OCSP$RevocationStatus, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSP.check(java.security.cert.X509Certificate, java.security.cert.X509Certificate):sun.security.provider.certpath.OCSP$RevocationStatus");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.check(java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.net.URI, java.security.cert.X509Certificate, java.util.Date, java.util.List):sun.security.provider.certpath.OCSP$RevocationStatus, dex: classes.dex
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
    public static sun.security.provider.certpath.OCSP.RevocationStatus check(java.security.cert.X509Certificate r1, java.security.cert.X509Certificate r2, java.net.URI r3, java.security.cert.X509Certificate r4, java.util.Date r5, java.util.List<java.security.cert.Extension> r6) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.check(java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.net.URI, java.security.cert.X509Certificate, java.util.Date, java.util.List):sun.security.provider.certpath.OCSP$RevocationStatus, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSP.check(java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.net.URI, java.security.cert.X509Certificate, java.util.Date, java.util.List):sun.security.provider.certpath.OCSP$RevocationStatus");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.OCSP.check(java.util.List, java.net.URI, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.util.Date, java.util.List):sun.security.provider.certpath.OCSPResponse, dex: classes.dex
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
    static sun.security.provider.certpath.OCSPResponse check(java.util.List<sun.security.provider.certpath.CertId> r1, java.net.URI r2, java.security.cert.X509Certificate r3, java.security.cert.X509Certificate r4, java.util.Date r5, java.util.List<java.security.cert.Extension> r6) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.OCSP.check(java.util.List, java.net.URI, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.util.Date, java.util.List):sun.security.provider.certpath.OCSPResponse, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSP.check(java.util.List, java.net.URI, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.util.Date, java.util.List):sun.security.provider.certpath.OCSPResponse");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.getResponderURI(sun.security.x509.X509CertImpl):java.net.URI, dex: classes.dex
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
    static java.net.URI getResponderURI(sun.security.x509.X509CertImpl r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.getResponderURI(sun.security.x509.X509CertImpl):java.net.URI, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSP.getResponderURI(sun.security.x509.X509CertImpl):java.net.URI");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.initializeTimeout():int, dex: classes.dex
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
    private static int initializeTimeout() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.OCSP.initializeTimeout():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.OCSP.initializeTimeout():int");
    }

    public static RevocationStatus check(X509Certificate cert, X509Certificate issuerCert, URI responderURI, X509Certificate responderCert, Date date) throws IOException, CertPathValidatorException {
        return check(cert, issuerCert, responderURI, responderCert, date, (List<Extension>) Collections.emptyList());
    }

    public static URI getResponderURI(X509Certificate cert) {
        try {
            return getResponderURI(X509CertImpl.toImpl(cert));
        } catch (CertificateException e) {
            return null;
        }
    }
}
