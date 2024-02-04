package java.net;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class SecureCacheResponse extends CacheResponse {
    public abstract String getCipherSuite();

    public abstract List<Certificate> getLocalCertificateChain();

    public abstract Principal getLocalPrincipal();

    public abstract Principal getPeerPrincipal() throws SSLPeerUnverifiedException;

    public abstract List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException;
}
