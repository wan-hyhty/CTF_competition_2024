package javax.crypto;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import sun.security.jca.GetInstance;

final class JceSecurity {
    /* access modifiers changed from: private */
    public static final URL NULL_URL = null;
    private static final Object PROVIDER_VERIFIED = null;
    static final SecureRandom RANDOM = null;
    private static final Map codeBaseCacheRef = null;
    private static CryptoPermissions defaultPolicy;
    private static CryptoPermissions exemptPolicy;
    private static boolean isRestricted;
    private static final Map verificationResults = null;
    private static final Map verifyingProviders = null;

    private JceSecurity() {
    }

    static GetInstance.Instance getInstance(String type, Class clazz, String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        Provider.Service s = GetInstance.getService(type, algorithm, provider);
        Exception ve = getVerificationResult(s.getProvider());
        if (ve == null) {
            return GetInstance.getInstance(s, clazz);
        }
        throw ((NoSuchProviderException) new NoSuchProviderException("JCE cannot authenticate the provider " + provider).initCause(ve));
    }

    static GetInstance.Instance getInstance(String type, Class clazz, String algorithm, Provider provider) throws NoSuchAlgorithmException {
        Provider.Service s = GetInstance.getService(type, algorithm, provider);
        Exception ve = getVerificationResult(provider);
        if (ve == null) {
            return GetInstance.getInstance(s, clazz);
        }
        throw new SecurityException("JCE cannot authenticate the provider " + provider.getName(), ve);
    }

    static GetInstance.Instance getInstance(String type, Class clazz, String algorithm) throws NoSuchAlgorithmException {
        NoSuchAlgorithmException failure = null;
        for (Provider.Service s : GetInstance.getServices(type, algorithm)) {
            if (canUseProvider(s.getProvider())) {
                try {
                    return GetInstance.getInstance(s, clazz);
                } catch (NoSuchAlgorithmException e) {
                    failure = e;
                }
            }
        }
        throw new NoSuchAlgorithmException("Algorithm " + algorithm + " not available", failure);
    }

    static CryptoPermissions verifyExemptJar(URL codeBase) throws Exception {
        JarVerifier jv = new JarVerifier(codeBase, true);
        jv.verify();
        return jv.getPermissions();
    }

    static void verifyProviderJar(URL codeBase) throws Exception {
        new JarVerifier(codeBase, false).verify();
    }

    static synchronized Exception getVerificationResult(Provider p) {
        synchronized (JceSecurity.class) {
            Object o = verificationResults.get(p);
            if (o == PROVIDER_VERIFIED) {
                return null;
            }
            if (o != null) {
                Exception exc = (Exception) o;
                return exc;
            } else if (verifyingProviders.get(p) != null) {
                NoSuchProviderException noSuchProviderException = new NoSuchProviderException("Recursion during verification");
                return noSuchProviderException;
            } else {
                try {
                    verifyingProviders.put(p, Boolean.FALSE);
                    verifyProviderJar(getCodeBase(p.getClass()));
                    verificationResults.put(p, PROVIDER_VERIFIED);
                    verifyingProviders.remove(p);
                    return null;
                } catch (Exception e) {
                    verificationResults.put(p, e);
                    verifyingProviders.remove(p);
                    return e;
                } catch (Throwable th) {
                    verifyingProviders.remove(p);
                    throw th;
                }
            }
        }
    }

    static boolean canUseProvider(Provider p) {
        return true;
    }

    static URL getCodeBase(final Class clazz) {
        URL url = (URL) codeBaseCacheRef.get(clazz);
        if (url == null) {
            url = (URL) AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    CodeSource cs;
                    ProtectionDomain pd = clazz.getProtectionDomain();
                    if (pd == null || (cs = pd.getCodeSource()) == null) {
                        return JceSecurity.NULL_URL;
                    }
                    return cs.getLocation();
                }
            });
            codeBaseCacheRef.put(clazz, url);
        }
        if (url == NULL_URL) {
            return null;
        }
        return url;
    }

    private static void setupJurisdictionPolicies() throws Exception {
        String javaHomeDir = System.getProperty("java.home");
        String sep = File.separator;
        String pathToPolicyJar = javaHomeDir + sep + "lib" + sep + "security" + sep;
        File exportJar = new File(pathToPolicyJar, "US_export_policy.jar");
        File importJar = new File(pathToPolicyJar, "local_policy.jar");
        if (ClassLoader.getSystemResource("javax/crypto/Cipher.class") == null || !exportJar.exists() || !importJar.exists()) {
            throw new SecurityException("Cannot locate policy or framework files!");
        }
        CryptoPermissions defaultExport = new CryptoPermissions();
        CryptoPermissions exemptExport = new CryptoPermissions();
        loadPolicies(exportJar, defaultExport, exemptExport);
        CryptoPermissions defaultImport = new CryptoPermissions();
        CryptoPermissions exemptImport = new CryptoPermissions();
        loadPolicies(importJar, defaultImport, exemptImport);
        if (defaultExport.isEmpty() || defaultImport.isEmpty()) {
            throw new SecurityException("Missing mandatory jurisdiction policy files");
        }
        defaultPolicy = defaultExport.getMinimum(defaultImport);
        if (exemptExport.isEmpty()) {
            if (exemptImport.isEmpty()) {
                exemptImport = null;
            }
            exemptPolicy = exemptImport;
            return;
        }
        exemptPolicy = exemptExport.getMinimum(exemptImport);
    }

    private static void loadPolicies(File jarPathName, CryptoPermissions defaultPolicy2, CryptoPermissions exemptPolicy2) throws Exception {
        InputStream is;
        JarFile jf = new JarFile(jarPathName);
        Enumeration entries = jf.entries();
        while (entries.hasMoreElements()) {
            JarEntry je = entries.nextElement();
            InputStream is2 = null;
            try {
                if (je.getName().startsWith("default_")) {
                    is = jf.getInputStream(je);
                    defaultPolicy2.load(is);
                } else if (je.getName().startsWith("exempt_")) {
                    is = jf.getInputStream(je);
                    exemptPolicy2.load(is);
                }
                JarVerifier.verifyPolicySigned(je.getCertificates());
            } finally {
                if (is2 != null) {
                    is2.close();
                }
            }
        }
        jf.close();
    }

    static CryptoPermissions getDefaultPolicy() {
        return defaultPolicy;
    }

    static CryptoPermissions getExemptPolicy() {
        return exemptPolicy;
    }

    static boolean isRestricted() {
        return isRestricted;
    }
}
