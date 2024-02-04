package sun.security.provider.certpath;

import java.io.IOException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXReason;
import java.security.cert.PolicyNode;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sun.security.util.Debug;
import sun.security.x509.CertificatePoliciesExtension;
import sun.security.x509.CertificatePolicyMap;
import sun.security.x509.InhibitAnyPolicyExtension;
import sun.security.x509.PKIXExtensions;
import sun.security.x509.PolicyConstraintsExtension;
import sun.security.x509.PolicyInformation;
import sun.security.x509.PolicyMappingsExtension;
import sun.security.x509.X509CertImpl;

class PolicyChecker extends PKIXCertPathChecker {
    static final String ANY_POLICY = "2.5.29.32.0";
    private static final Debug debug = null;
    private final boolean anyPolicyInhibited;
    private int certIndex;
    private final int certPathLen;
    private final boolean expPolicyRequired;
    private int explicitPolicy;
    private int inhibitAnyPolicy;
    private final Set<String> initPolicies;
    private final boolean polMappingInhibited;
    private int policyMapping;
    private final boolean rejectPolicyQualifiers;
    private PolicyNodeImpl rootNode;
    private Set<String> supportedExts;

    PolicyChecker(Set<String> initialPolicies, int certPathLen2, boolean expPolicyRequired2, boolean polMappingInhibited2, boolean anyPolicyInhibited2, boolean rejectPolicyQualifiers2, PolicyNodeImpl rootNode2) {
        if (initialPolicies.isEmpty()) {
            this.initPolicies = new HashSet(1);
            this.initPolicies.add(ANY_POLICY);
        } else {
            this.initPolicies = new HashSet(initialPolicies);
        }
        this.certPathLen = certPathLen2;
        this.expPolicyRequired = expPolicyRequired2;
        this.polMappingInhibited = polMappingInhibited2;
        this.anyPolicyInhibited = anyPolicyInhibited2;
        this.rejectPolicyQualifiers = rejectPolicyQualifiers2;
        this.rootNode = rootNode2;
    }

    public void init(boolean forward) throws CertPathValidatorException {
        int i = 0;
        if (forward) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        this.certIndex = 1;
        this.explicitPolicy = this.expPolicyRequired ? 0 : this.certPathLen + 1;
        this.policyMapping = this.polMappingInhibited ? 0 : this.certPathLen + 1;
        if (!this.anyPolicyInhibited) {
            i = this.certPathLen + 1;
        }
        this.inhibitAnyPolicy = i;
    }

    public boolean isForwardCheckingSupported() {
        return false;
    }

    public Set<String> getSupportedExtensions() {
        if (this.supportedExts == null) {
            this.supportedExts = new HashSet(4);
            this.supportedExts.add(PKIXExtensions.CertificatePolicies_Id.toString());
            this.supportedExts.add(PKIXExtensions.PolicyMappings_Id.toString());
            this.supportedExts.add(PKIXExtensions.PolicyConstraints_Id.toString());
            this.supportedExts.add(PKIXExtensions.InhibitAnyPolicy_Id.toString());
            this.supportedExts = Collections.unmodifiableSet(this.supportedExts);
        }
        return this.supportedExts;
    }

    public void check(Certificate cert, Collection<String> unresCritExts) throws CertPathValidatorException {
        checkPolicy((X509Certificate) cert);
        if (unresCritExts != null && !unresCritExts.isEmpty()) {
            unresCritExts.remove(PKIXExtensions.CertificatePolicies_Id.toString());
            unresCritExts.remove(PKIXExtensions.PolicyMappings_Id.toString());
            unresCritExts.remove(PKIXExtensions.PolicyConstraints_Id.toString());
            unresCritExts.remove(PKIXExtensions.InhibitAnyPolicy_Id.toString());
        }
    }

    private void checkPolicy(X509Certificate currCert) throws CertPathValidatorException {
        if (debug != null) {
            debug.println("PolicyChecker.checkPolicy() ---checking " + "certificate policies" + "...");
            debug.println("PolicyChecker.checkPolicy() certIndex = " + this.certIndex);
            debug.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: explicitPolicy = " + this.explicitPolicy);
            debug.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: policyMapping = " + this.policyMapping);
            debug.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: inhibitAnyPolicy = " + this.inhibitAnyPolicy);
            debug.println("PolicyChecker.checkPolicy() BEFORE PROCESSING: policyTree = " + this.rootNode);
        }
        try {
            X509CertImpl currCertImpl = X509CertImpl.toImpl(currCert);
            boolean finalCert = this.certIndex == this.certPathLen;
            this.rootNode = processPolicies(this.certIndex, this.initPolicies, this.explicitPolicy, this.policyMapping, this.inhibitAnyPolicy, this.rejectPolicyQualifiers, this.rootNode, currCertImpl, finalCert);
            if (!finalCert) {
                this.explicitPolicy = mergeExplicitPolicy(this.explicitPolicy, currCertImpl, finalCert);
                this.policyMapping = mergePolicyMapping(this.policyMapping, currCertImpl);
                this.inhibitAnyPolicy = mergeInhibitAnyPolicy(this.inhibitAnyPolicy, currCertImpl);
            }
            this.certIndex++;
            if (debug != null) {
                debug.println("PolicyChecker.checkPolicy() AFTER PROCESSING: explicitPolicy = " + this.explicitPolicy);
                debug.println("PolicyChecker.checkPolicy() AFTER PROCESSING: policyMapping = " + this.policyMapping);
                debug.println("PolicyChecker.checkPolicy() AFTER PROCESSING: inhibitAnyPolicy = " + this.inhibitAnyPolicy);
                debug.println("PolicyChecker.checkPolicy() AFTER PROCESSING: policyTree = " + this.rootNode);
                debug.println("PolicyChecker.checkPolicy() " + "certificate policies" + " verified");
            }
        } catch (CertificateException ce) {
            throw new CertPathValidatorException((Throwable) ce);
        }
    }

    static int mergeExplicitPolicy(int explicitPolicy2, X509CertImpl currCert, boolean finalCert) throws CertPathValidatorException {
        if (explicitPolicy2 > 0 && !X509CertImpl.isSelfIssued(currCert)) {
            explicitPolicy2--;
        }
        try {
            PolicyConstraintsExtension polConstExt = currCert.getPolicyConstraintsExtension();
            if (polConstExt == null) {
                return explicitPolicy2;
            }
            int require = polConstExt.get(PolicyConstraintsExtension.REQUIRE).intValue();
            if (debug != null) {
                debug.println("PolicyChecker.mergeExplicitPolicy() require Index from cert = " + require);
            }
            if (!finalCert) {
                if (require == -1) {
                    return explicitPolicy2;
                }
                if (explicitPolicy2 == -1 || require < explicitPolicy2) {
                    return require;
                }
                return explicitPolicy2;
            } else if (require == 0) {
                return require;
            } else {
                return explicitPolicy2;
            }
        } catch (IOException e) {
            if (debug != null) {
                debug.println("PolicyChecker.mergeExplicitPolicy unexpected exception");
                e.printStackTrace();
            }
            throw new CertPathValidatorException((Throwable) e);
        }
    }

    static int mergePolicyMapping(int policyMapping2, X509CertImpl currCert) throws CertPathValidatorException {
        if (policyMapping2 > 0 && !X509CertImpl.isSelfIssued(currCert)) {
            policyMapping2--;
        }
        try {
            PolicyConstraintsExtension polConstExt = currCert.getPolicyConstraintsExtension();
            if (polConstExt == null) {
                return policyMapping2;
            }
            int inhibit = polConstExt.get(PolicyConstraintsExtension.INHIBIT).intValue();
            if (debug != null) {
                debug.println("PolicyChecker.mergePolicyMapping() inhibit Index from cert = " + inhibit);
            }
            if (inhibit == -1) {
                return policyMapping2;
            }
            if (policyMapping2 == -1 || inhibit < policyMapping2) {
                return inhibit;
            }
            return policyMapping2;
        } catch (IOException e) {
            if (debug != null) {
                debug.println("PolicyChecker.mergePolicyMapping unexpected exception");
                e.printStackTrace();
            }
            throw new CertPathValidatorException((Throwable) e);
        }
    }

    static int mergeInhibitAnyPolicy(int inhibitAnyPolicy2, X509CertImpl currCert) throws CertPathValidatorException {
        if (inhibitAnyPolicy2 > 0 && !X509CertImpl.isSelfIssued(currCert)) {
            inhibitAnyPolicy2--;
        }
        try {
            InhibitAnyPolicyExtension inhAnyPolExt = (InhibitAnyPolicyExtension) currCert.getExtension(PKIXExtensions.InhibitAnyPolicy_Id);
            if (inhAnyPolExt == null) {
                return inhibitAnyPolicy2;
            }
            int skipCerts = inhAnyPolExt.get(InhibitAnyPolicyExtension.SKIP_CERTS).intValue();
            if (debug != null) {
                debug.println("PolicyChecker.mergeInhibitAnyPolicy() skipCerts Index from cert = " + skipCerts);
            }
            if (skipCerts == -1 || skipCerts >= inhibitAnyPolicy2) {
                return inhibitAnyPolicy2;
            }
            return skipCerts;
        } catch (IOException e) {
            if (debug != null) {
                debug.println("PolicyChecker.mergeInhibitAnyPolicy unexpected exception");
                e.printStackTrace();
            }
            throw new CertPathValidatorException((Throwable) e);
        }
    }

    static PolicyNodeImpl processPolicies(int certIndex2, Set<String> initPolicies2, int explicitPolicy2, int policyMapping2, int inhibitAnyPolicy2, boolean rejectPolicyQualifiers2, PolicyNodeImpl origRootNode, X509CertImpl currCert, boolean finalCert) throws CertPathValidatorException {
        PolicyNodeImpl rootNode2;
        boolean policiesCritical = false;
        Set<PolicyQualifierInfo> anyQuals = new HashSet<>();
        if (origRootNode == null) {
            rootNode2 = null;
        } else {
            rootNode2 = origRootNode.copyTree();
        }
        CertificatePoliciesExtension currCertPolicies = currCert.getCertificatePoliciesExtension();
        if (currCertPolicies != null && rootNode2 != null) {
            policiesCritical = currCertPolicies.isCritical();
            if (debug != null) {
                debug.println("PolicyChecker.processPolicies() policiesCritical = " + policiesCritical);
            }
            try {
                List<PolicyInformation> policyInfo = currCertPolicies.get(CertificatePoliciesExtension.POLICIES);
                if (debug != null) {
                    debug.println("PolicyChecker.processPolicies() rejectPolicyQualifiers = " + rejectPolicyQualifiers2);
                }
                boolean foundAnyPolicy = false;
                for (PolicyInformation curPolInfo : policyInfo) {
                    String curPolicy = curPolInfo.getPolicyIdentifier().getIdentifier().toString();
                    if (curPolicy.equals(ANY_POLICY)) {
                        foundAnyPolicy = true;
                        anyQuals = curPolInfo.getPolicyQualifiers();
                    } else {
                        if (debug != null) {
                            debug.println("PolicyChecker.processPolicies() processing policy: " + curPolicy);
                        }
                        Set<PolicyQualifierInfo> pQuals = curPolInfo.getPolicyQualifiers();
                        if (!pQuals.isEmpty() && rejectPolicyQualifiers2 && policiesCritical) {
                            throw new CertPathValidatorException("critical policy qualifiers present in certificate", (Throwable) null, (CertPath) null, -1, PKIXReason.INVALID_POLICY);
                        } else if (!processParents(certIndex2, policiesCritical, rejectPolicyQualifiers2, rootNode2, curPolicy, pQuals, false)) {
                            processParents(certIndex2, policiesCritical, rejectPolicyQualifiers2, rootNode2, curPolicy, pQuals, true);
                        }
                    }
                }
                if (foundAnyPolicy && (inhibitAnyPolicy2 > 0 || (!finalCert && X509CertImpl.isSelfIssued(currCert)))) {
                    if (debug != null) {
                        debug.println("PolicyChecker.processPolicies() processing policy: 2.5.29.32.0");
                    }
                    processParents(certIndex2, policiesCritical, rejectPolicyQualifiers2, rootNode2, ANY_POLICY, anyQuals, true);
                }
                rootNode2.prune(certIndex2);
                if (!rootNode2.getChildren().hasNext()) {
                    rootNode2 = null;
                }
            } catch (IOException ioe) {
                throw new CertPathValidatorException("Exception while retrieving policyOIDs", ioe);
            }
        } else if (currCertPolicies == null) {
            if (debug != null) {
                debug.println("PolicyChecker.processPolicies() no policies present in cert");
            }
            rootNode2 = null;
        }
        if (rootNode2 != null && !finalCert) {
            rootNode2 = processPolicyMappings(currCert, certIndex2, policyMapping2, rootNode2, policiesCritical, anyQuals);
        }
        if (!(rootNode2 == null || initPolicies2.contains(ANY_POLICY) || currCertPolicies == null || (rootNode2 = removeInvalidNodes(rootNode2, certIndex2, initPolicies2, currCertPolicies)) == null || !finalCert)) {
            rootNode2 = rewriteLeafNodes(certIndex2, initPolicies2, rootNode2);
        }
        if (finalCert) {
            explicitPolicy2 = mergeExplicitPolicy(explicitPolicy2, currCert, finalCert);
        }
        if (explicitPolicy2 != 0 || rootNode2 != null) {
            return rootNode2;
        }
        throw new CertPathValidatorException("non-null policy tree required and policy tree is null", (Throwable) null, (CertPath) null, -1, PKIXReason.INVALID_POLICY);
    }

    private static PolicyNodeImpl rewriteLeafNodes(int certIndex2, Set<String> initPolicies2, PolicyNodeImpl rootNode2) {
        Set<PolicyNodeImpl> anyNodes = rootNode2.getPolicyNodesValid(certIndex2, ANY_POLICY);
        if (anyNodes.isEmpty()) {
            return rootNode2;
        }
        PolicyNodeImpl anyNode = anyNodes.iterator().next();
        PolicyNodeImpl parentNode = (PolicyNodeImpl) anyNode.getParent();
        parentNode.deleteChild(anyNode);
        Set<String> initial = new HashSet<>(initPolicies2);
        for (PolicyNodeImpl node : rootNode2.getPolicyNodes(certIndex2)) {
            initial.remove(node.getValidPolicy());
        }
        if (initial.isEmpty()) {
            rootNode2.prune(certIndex2);
            if (!rootNode2.getChildren().hasNext()) {
                return null;
            }
            return rootNode2;
        }
        boolean anyCritical = anyNode.isCritical();
        Set<PolicyQualifierInfo> anyQualifiers = anyNode.getPolicyQualifiers();
        for (String policy : initial) {
            new PolicyNodeImpl(parentNode, policy, anyQualifiers, anyCritical, Collections.singleton(policy), false);
        }
        return rootNode2;
    }

    private static boolean processParents(int certIndex2, boolean policiesCritical, boolean rejectPolicyQualifiers2, PolicyNodeImpl rootNode2, String curPolicy, Set<PolicyQualifierInfo> pQuals, boolean matchAny) throws CertPathValidatorException {
        boolean foundMatch = false;
        if (debug != null) {
            debug.println("PolicyChecker.processParents(): matchAny = " + matchAny);
        }
        for (PolicyNodeImpl curParent : rootNode2.getPolicyNodesExpected(certIndex2 - 1, curPolicy, matchAny)) {
            if (debug != null) {
                debug.println("PolicyChecker.processParents() found parent:\n" + curParent.asString());
            }
            foundMatch = true;
            String validPolicy = curParent.getValidPolicy();
            if (curPolicy.equals(ANY_POLICY)) {
                for (String curParExpPol : curParent.getExpectedPolicies()) {
                    Iterator<PolicyNodeImpl> childIter = curParent.getChildren();
                    while (true) {
                        if (!childIter.hasNext()) {
                            Set<String> expPols = new HashSet<>();
                            expPols.add(curParExpPol);
                            new PolicyNodeImpl(curParent, curParExpPol, pQuals, policiesCritical, expPols, false);
                            break;
                        }
                        String childPolicy = childIter.next().getValidPolicy();
                        if (curParExpPol.equals(childPolicy)) {
                            if (debug != null) {
                                debug.println(childPolicy + " in parent's " + "expected policy set already appears in " + "child node");
                            }
                        }
                    }
                }
            } else {
                Set<String> curExpPols = new HashSet<>();
                curExpPols.add(curPolicy);
                new PolicyNodeImpl(curParent, curPolicy, pQuals, policiesCritical, curExpPols, false);
            }
        }
        return foundMatch;
    }

    private static PolicyNodeImpl processPolicyMappings(X509CertImpl currCert, int certIndex2, int policyMapping2, PolicyNodeImpl rootNode2, boolean policiesCritical, Set<PolicyQualifierInfo> anyQuals) throws CertPathValidatorException {
        PolicyMappingsExtension polMappingsExt = currCert.getPolicyMappingsExtension();
        if (polMappingsExt == null) {
            return rootNode2;
        }
        if (debug != null) {
            debug.println("PolicyChecker.processPolicyMappings() inside policyMapping check");
        }
        try {
            boolean childDeleted = false;
            for (CertificatePolicyMap polMap : polMappingsExt.get(PolicyMappingsExtension.MAP)) {
                String issuerDomain = polMap.getIssuerIdentifier().getIdentifier().toString();
                String subjectDomain = polMap.getSubjectIdentifier().getIdentifier().toString();
                if (debug != null) {
                    debug.println("PolicyChecker.processPolicyMappings() issuerDomain = " + issuerDomain);
                    debug.println("PolicyChecker.processPolicyMappings() subjectDomain = " + subjectDomain);
                }
                if (issuerDomain.equals(ANY_POLICY)) {
                    throw new CertPathValidatorException("encountered an issuerDomainPolicy of ANY_POLICY", (Throwable) null, (CertPath) null, -1, PKIXReason.INVALID_POLICY);
                } else if (subjectDomain.equals(ANY_POLICY)) {
                    throw new CertPathValidatorException("encountered a subjectDomainPolicy of ANY_POLICY", (Throwable) null, (CertPath) null, -1, PKIXReason.INVALID_POLICY);
                } else {
                    Set<PolicyNodeImpl> validNodes = rootNode2.getPolicyNodesValid(certIndex2, issuerDomain);
                    if (!validNodes.isEmpty()) {
                        for (PolicyNodeImpl curNode : validNodes) {
                            if (policyMapping2 > 0 || policyMapping2 == -1) {
                                curNode.addExpectedPolicy(subjectDomain);
                            } else if (policyMapping2 == 0) {
                                PolicyNodeImpl parentNode = (PolicyNodeImpl) curNode.getParent();
                                if (debug != null) {
                                    debug.println("PolicyChecker.processPolicyMappings() before deleting: policy tree = " + rootNode2);
                                }
                                parentNode.deleteChild(curNode);
                                childDeleted = true;
                                if (debug != null) {
                                    debug.println("PolicyChecker.processPolicyMappings() after deleting: policy tree = " + rootNode2);
                                }
                            }
                        }
                    } else if (policyMapping2 > 0 || policyMapping2 == -1) {
                        for (PolicyNodeImpl curAnyNode : rootNode2.getPolicyNodesValid(certIndex2, ANY_POLICY)) {
                            Set<String> expPols = new HashSet<>();
                            expPols.add(subjectDomain);
                            new PolicyNodeImpl((PolicyNodeImpl) curAnyNode.getParent(), issuerDomain, anyQuals, policiesCritical, expPols, true);
                        }
                    }
                }
            }
            if (!childDeleted) {
                return rootNode2;
            }
            rootNode2.prune(certIndex2);
            if (rootNode2.getChildren().hasNext()) {
                return rootNode2;
            }
            if (debug != null) {
                debug.println("setting rootNode to null");
            }
            return null;
        } catch (IOException e) {
            if (debug != null) {
                debug.println("PolicyChecker.processPolicyMappings() mapping exception");
                e.printStackTrace();
            }
            throw new CertPathValidatorException("Exception while checking mapping", e);
        }
    }

    private static PolicyNodeImpl removeInvalidNodes(PolicyNodeImpl rootNode2, int certIndex2, Set<String> initPolicies2, CertificatePoliciesExtension currCertPolicies) throws CertPathValidatorException {
        try {
            boolean childDeleted = false;
            for (PolicyInformation curPolInfo : currCertPolicies.get(CertificatePoliciesExtension.POLICIES)) {
                String curPolicy = curPolInfo.getPolicyIdentifier().getIdentifier().toString();
                if (debug != null) {
                    debug.println("PolicyChecker.processPolicies() processing policy second time: " + curPolicy);
                }
                for (PolicyNodeImpl curNode : rootNode2.getPolicyNodesValid(certIndex2, curPolicy)) {
                    PolicyNodeImpl parentNode = (PolicyNodeImpl) curNode.getParent();
                    if (parentNode.getValidPolicy().equals(ANY_POLICY) && !initPolicies2.contains(curPolicy) && !curPolicy.equals(ANY_POLICY)) {
                        if (debug != null) {
                            debug.println("PolicyChecker.processPolicies() before deleting: policy tree = " + rootNode2);
                        }
                        parentNode.deleteChild(curNode);
                        childDeleted = true;
                        if (debug != null) {
                            debug.println("PolicyChecker.processPolicies() after deleting: policy tree = " + rootNode2);
                        }
                    }
                }
            }
            if (!childDeleted) {
                return rootNode2;
            }
            rootNode2.prune(certIndex2);
            if (!rootNode2.getChildren().hasNext()) {
                return null;
            }
            return rootNode2;
        } catch (IOException ioe) {
            throw new CertPathValidatorException("Exception while retrieving policyOIDs", ioe);
        }
    }

    /* access modifiers changed from: package-private */
    public PolicyNode getPolicyTree() {
        if (this.rootNode == null) {
            return null;
        }
        PolicyNodeImpl policyTree = this.rootNode.copyTree();
        policyTree.setImmutable();
        return policyTree;
    }
}
