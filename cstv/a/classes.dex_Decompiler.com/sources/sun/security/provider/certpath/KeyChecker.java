package sun.security.provider.certpath;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXReason;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import sun.security.util.Debug;
import sun.security.x509.PKIXExtensions;

class KeyChecker extends PKIXCertPathChecker {
    private static final int KEY_CERT_SIGN = 5;
    private static final Debug debug = null;
    private final int certPathLen;
    private int remainingCerts;
    private Set<String> supportedExts;
    private final CertSelector targetConstraints;

    KeyChecker(int certPathLen2, CertSelector targetCertSel) {
        this.certPathLen = certPathLen2;
        this.targetConstraints = targetCertSel;
    }

    public void init(boolean forward) throws CertPathValidatorException {
        if (!forward) {
            this.remainingCerts = this.certPathLen;
            return;
        }
        throw new CertPathValidatorException("forward checking not supported");
    }

    public boolean isForwardCheckingSupported() {
        return false;
    }

    public Set<String> getSupportedExtensions() {
        if (this.supportedExts == null) {
            this.supportedExts = new HashSet(3);
            this.supportedExts.add(PKIXExtensions.KeyUsage_Id.toString());
            this.supportedExts.add(PKIXExtensions.ExtendedKeyUsage_Id.toString());
            this.supportedExts.add(PKIXExtensions.SubjectAlternativeName_Id.toString());
            this.supportedExts = Collections.unmodifiableSet(this.supportedExts);
        }
        return this.supportedExts;
    }

    public void check(Certificate cert, Collection<String> unresCritExts) throws CertPathValidatorException {
        X509Certificate currCert = (X509Certificate) cert;
        this.remainingCerts--;
        if (this.remainingCerts != 0) {
            verifyCAKeyUsage(currCert);
        } else if (this.targetConstraints != null && !this.targetConstraints.match(currCert)) {
            throw new CertPathValidatorException("target certificate constraints check failed");
        }
        if (unresCritExts != null && !unresCritExts.isEmpty()) {
            unresCritExts.remove(PKIXExtensions.KeyUsage_Id.toString());
            unresCritExts.remove(PKIXExtensions.ExtendedKeyUsage_Id.toString());
            unresCritExts.remove(PKIXExtensions.SubjectAlternativeName_Id.toString());
        }
    }

    static void verifyCAKeyUsage(X509Certificate cert) throws CertPathValidatorException {
        if (debug != null) {
            debug.println("KeyChecker.verifyCAKeyUsage() ---checking " + "CA key usage" + "...");
        }
        boolean[] keyUsageBits = cert.getKeyUsage();
        if (keyUsageBits != null) {
            if (!keyUsageBits[5]) {
                throw new CertPathValidatorException("CA key usage" + " check failed: keyCertSign bit is not set", (Throwable) null, (CertPath) null, -1, PKIXReason.INVALID_KEY_USAGE);
            } else if (debug != null) {
                debug.println("KeyChecker.verifyCAKeyUsage() " + "CA key usage" + " verified.");
            }
        }
    }
}
