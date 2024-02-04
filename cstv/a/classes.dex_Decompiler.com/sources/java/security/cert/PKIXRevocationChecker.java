package java.security.cert;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class PKIXRevocationChecker extends PKIXCertPathChecker {
    private List<Extension> ocspExtensions = Collections.emptyList();
    private URI ocspResponder;
    private X509Certificate ocspResponderCert;
    private Map<X509Certificate, byte[]> ocspResponses = Collections.emptyMap();
    private Set<Option> options = Collections.emptySet();

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum Option {
    }

    public abstract List<CertPathValidatorException> getSoftFailExceptions();

    protected PKIXRevocationChecker() {
    }

    public void setOcspResponder(URI uri) {
        this.ocspResponder = uri;
    }

    public URI getOcspResponder() {
        return this.ocspResponder;
    }

    public void setOcspResponderCert(X509Certificate cert) {
        this.ocspResponderCert = cert;
    }

    public X509Certificate getOcspResponderCert() {
        return this.ocspResponderCert;
    }

    public void setOcspExtensions(List<Extension> extensions) {
        List<Extension> arrayList;
        if (extensions == null) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList<>(extensions);
        }
        this.ocspExtensions = arrayList;
    }

    public List<Extension> getOcspExtensions() {
        return Collections.unmodifiableList(this.ocspExtensions);
    }

    public void setOcspResponses(Map<X509Certificate, byte[]> responses) {
        if (responses == null) {
            this.ocspResponses = Collections.emptyMap();
            return;
        }
        Map<X509Certificate, byte[]> copy = new HashMap<>(responses.size());
        for (Map.Entry<X509Certificate, byte[]> e : responses.entrySet()) {
            copy.put(e.getKey(), (byte[]) e.getValue().clone());
        }
        this.ocspResponses = copy;
    }

    public Map<X509Certificate, byte[]> getOcspResponses() {
        Map<X509Certificate, byte[]> copy = new HashMap<>(this.ocspResponses.size());
        for (Map.Entry<X509Certificate, byte[]> e : this.ocspResponses.entrySet()) {
            copy.put(e.getKey(), (byte[]) e.getValue().clone());
        }
        return copy;
    }

    public void setOptions(Set<Option> options2) {
        Set<Option> hashSet;
        if (options2 == null) {
            hashSet = Collections.emptySet();
        } else {
            hashSet = new HashSet<>(options2);
        }
        this.options = hashSet;
    }

    public Set<Option> getOptions() {
        return Collections.unmodifiableSet(this.options);
    }

    public PKIXRevocationChecker clone() {
        PKIXRevocationChecker copy = (PKIXRevocationChecker) super.clone();
        copy.ocspExtensions = new ArrayList(this.ocspExtensions);
        copy.ocspResponses = new HashMap(this.ocspResponses);
        for (Map.Entry<X509Certificate, byte[]> entry : copy.ocspResponses.entrySet()) {
            entry.setValue((byte[]) entry.getValue().clone());
        }
        copy.options = new HashSet(this.options);
        return copy;
    }
}
