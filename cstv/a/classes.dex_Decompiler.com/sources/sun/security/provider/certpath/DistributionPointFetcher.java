package sun.security.provider.certpath;

import java.security.PublicKey;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import sun.security.util.Debug;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class DistributionPointFetcher {
    private static final boolean[] ALL_REASONS = null;
    private static final Debug debug = null;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.DistributionPointFetcher.<init>():void, dex: classes.dex
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
    private DistributionPointFetcher() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.DistributionPointFetcher.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.getCRL(sun.security.x509.URIName):java.security.cert.X509CRL, dex: classes.dex
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
    private static java.security.cert.X509CRL getCRL(sun.security.x509.URIName r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.getCRL(sun.security.x509.URIName):java.security.cert.X509CRL, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.getCRL(sun.security.x509.URIName):java.security.cert.X509CRL");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(java.security.cert.X509CRLSelector, sun.security.x509.X509CertImpl, sun.security.x509.DistributionPoint, boolean[], boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.List, java.util.Set, java.util.Date):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
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
    private static java.util.Collection<java.security.cert.X509CRL> getCRLs(java.security.cert.X509CRLSelector r1, sun.security.x509.X509CertImpl r2, sun.security.x509.DistributionPoint r3, boolean[] r4, boolean r5, java.security.PublicKey r6, java.security.cert.X509Certificate r7, java.lang.String r8, java.util.List<java.security.cert.CertStore> r9, java.util.Set<java.security.cert.TrustAnchor> r10, java.util.Date r11) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(java.security.cert.X509CRLSelector, sun.security.x509.X509CertImpl, sun.security.x509.DistributionPoint, boolean[], boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.List, java.util.Set, java.util.Date):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(java.security.cert.X509CRLSelector, sun.security.x509.X509CertImpl, sun.security.x509.DistributionPoint, boolean[], boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.List, java.util.Set, java.util.Date):java.util.Collection");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(java.security.cert.X509CRLSelector, boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.List, boolean[], java.util.Set, java.util.Date):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
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
    public static java.util.Collection<java.security.cert.X509CRL> getCRLs(java.security.cert.X509CRLSelector r1, boolean r2, java.security.PublicKey r3, java.security.cert.X509Certificate r4, java.lang.String r5, java.util.List<java.security.cert.CertStore> r6, boolean[] r7, java.util.Set<java.security.cert.TrustAnchor> r8, java.util.Date r9) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ea in method: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(java.security.cert.X509CRLSelector, boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.List, boolean[], java.util.Set, java.util.Date):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(java.security.cert.X509CRLSelector, boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.List, boolean[], java.util.Set, java.util.Date):java.util.Collection");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(sun.security.x509.X500Name, javax.security.auth.x500.X500Principal, java.util.List):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
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
    private static java.util.Collection<java.security.cert.X509CRL> getCRLs(sun.security.x509.X500Name r1, javax.security.auth.x500.X500Principal r2, java.util.List<java.security.cert.CertStore> r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(sun.security.x509.X500Name, javax.security.auth.x500.X500Principal, java.util.List):java.util.Collection<java.security.cert.X509CRL>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.getCRLs(sun.security.x509.X500Name, javax.security.auth.x500.X500Principal, java.util.List):java.util.Collection");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.getFullNames(sun.security.x509.X500Name, sun.security.x509.RDN):sun.security.x509.GeneralNames, dex: classes.dex
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
    private static sun.security.x509.GeneralNames getFullNames(sun.security.x509.X500Name r1, sun.security.x509.RDN r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.getFullNames(sun.security.x509.X500Name, sun.security.x509.RDN):sun.security.x509.GeneralNames, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.getFullNames(sun.security.x509.X500Name, sun.security.x509.RDN):sun.security.x509.GeneralNames");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.issues(sun.security.x509.X509CertImpl, sun.security.x509.X509CRLImpl, java.lang.String):boolean, dex: classes.dex
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
    private static boolean issues(sun.security.x509.X509CertImpl r1, sun.security.x509.X509CRLImpl r2, java.lang.String r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.issues(sun.security.x509.X509CertImpl, sun.security.x509.X509CRLImpl, java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.issues(sun.security.x509.X509CertImpl, sun.security.x509.X509CRLImpl, java.lang.String):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.verifyCRL(sun.security.x509.X509CertImpl, sun.security.x509.DistributionPoint, java.security.cert.X509CRL, boolean[], boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.Set, java.util.List, java.util.Date):boolean, dex: classes.dex
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
    static boolean verifyCRL(sun.security.x509.X509CertImpl r1, sun.security.x509.DistributionPoint r2, java.security.cert.X509CRL r3, boolean[] r4, boolean r5, java.security.PublicKey r6, java.security.cert.X509Certificate r7, java.lang.String r8, java.util.Set<java.security.cert.TrustAnchor> r9, java.util.List<java.security.cert.CertStore> r10, java.util.Date r11) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.DistributionPointFetcher.verifyCRL(sun.security.x509.X509CertImpl, sun.security.x509.DistributionPoint, java.security.cert.X509CRL, boolean[], boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.Set, java.util.List, java.util.Date):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.verifyCRL(sun.security.x509.X509CertImpl, sun.security.x509.DistributionPoint, java.security.cert.X509CRL, boolean[], boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.Set, java.util.List, java.util.Date):boolean");
    }

    public static Collection<X509CRL> getCRLs(X509CRLSelector selector, boolean signFlag, PublicKey prevKey, String provider, List<CertStore> certStores, boolean[] reasonsMask, Set<TrustAnchor> trustAnchors, Date validity) throws CertStoreException {
        return getCRLs(selector, signFlag, prevKey, (X509Certificate) null, provider, certStores, reasonsMask, trustAnchors, validity);
    }
}
