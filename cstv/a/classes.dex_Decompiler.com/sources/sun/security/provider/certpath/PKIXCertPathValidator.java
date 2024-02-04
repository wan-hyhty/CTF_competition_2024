package sun.security.provider.certpath;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathChecker;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXReason;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;
import sun.security.x509.X509CertImpl;

public final class PKIXCertPathValidator extends CertPathValidatorSpi {
    private static final Debug debug = null;

    public CertPathChecker engineGetRevocationChecker() {
        return new RevocationChecker();
    }

    public CertPathValidatorResult engineValidate(CertPath cp, CertPathParameters params) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        return validate(PKIX.checkParams(cp, params));
    }

    private static PKIXCertPathValidatorResult validate(PKIX.ValidatorParams params) throws CertPathValidatorException {
        if (debug != null) {
            debug.println("PKIXCertPathValidator.engineValidate()...");
        }
        AdaptableX509CertSelector selector = null;
        List<X509Certificate> certList = params.certificates();
        if (!certList.isEmpty()) {
            selector = new AdaptableX509CertSelector();
            X509Certificate firstCert = certList.get(0);
            selector.setSubject(firstCert.getIssuerX500Principal());
            selector.setValidityPeriod(firstCert.getNotBefore(), firstCert.getNotAfter());
            try {
                selector.parseAuthorityKeyIdentifierExtension(X509CertImpl.toImpl(firstCert).getAuthorityKeyIdentifierExtension());
            } catch (IOException | CertificateException e) {
            }
        }
        CertPathValidatorException lastException = null;
        for (TrustAnchor anchor : params.trustAnchors()) {
            X509Certificate trustedCert = anchor.getTrustedCert();
            if (trustedCert != null) {
                if (selector == null || selector.match(trustedCert)) {
                    if (debug != null) {
                        debug.println("YES - try this trustedCert");
                        debug.println("anchor.getTrustedCert().getSubjectX500Principal() = " + trustedCert.getSubjectX500Principal());
                    }
                } else if (debug != null) {
                    debug.println("NO - don't try this trustedCert");
                }
            } else if (debug != null) {
                debug.println("PKIXCertPathValidator.engineValidate(): anchor.getTrustedCert() == null");
            }
            try {
                return validate(anchor, params);
            } catch (CertPathValidatorException cpe) {
                lastException = cpe;
            }
        }
        if (lastException != null) {
            throw lastException;
        }
        throw new CertPathValidatorException("Path does not chain with any of the trust anchors", (Throwable) null, (CertPath) null, -1, PKIXReason.NO_TRUST_ANCHOR);
    }

    private static PKIXCertPathValidatorResult validate(TrustAnchor anchor, PKIX.ValidatorParams params) throws CertPathValidatorException {
        int certPathLen = params.certificates().size();
        List<PKIXCertPathChecker> certPathCheckers = new ArrayList<>();
        certPathCheckers.add(new UntrustedChecker());
        certPathCheckers.add(new AlgorithmChecker(anchor));
        certPathCheckers.add(new KeyChecker(certPathLen, params.targetCertConstraints()));
        certPathCheckers.add(new ConstraintsChecker(certPathLen));
        int i = certPathLen;
        PolicyChecker pc = new PolicyChecker(params.initialPolicies(), i, params.explicitPolicyRequired(), params.policyMappingInhibited(), params.anyPolicyInhibited(), params.policyQualifiersRejected(), new PolicyNodeImpl((PolicyNodeImpl) null, "2.5.29.32.0", (Set<PolicyQualifierInfo>) null, false, Collections.singleton("2.5.29.32.0"), false));
        certPathCheckers.add(pc);
        BasicChecker bc = new BasicChecker(anchor, params.date(), params.sigProvider(), false);
        certPathCheckers.add(bc);
        boolean revCheckerAdded = false;
        List<PKIXCertPathChecker> checkers = params.certPathCheckers();
        for (PKIXCertPathChecker checker : checkers) {
            if (checker instanceof PKIXRevocationChecker) {
                if (revCheckerAdded) {
                    throw new CertPathValidatorException("Only one PKIXRevocationChecker can be specified");
                }
                revCheckerAdded = true;
                if (checker instanceof RevocationChecker) {
                    ((RevocationChecker) checker).init(anchor, params);
                }
            }
        }
        if (params.revocationEnabled() && !revCheckerAdded) {
            certPathCheckers.add(new RevocationChecker(anchor, params));
        }
        certPathCheckers.addAll(checkers);
        PKIXMasterCertPathValidator.validate(params.certPath(), params.certificates(), certPathCheckers);
        return new PKIXCertPathValidatorResult(anchor, pc.getPolicyTree(), bc.getPublicKey());
    }
}
