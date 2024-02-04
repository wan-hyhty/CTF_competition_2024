package sun.security.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.CodeSigner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarException;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import sun.misc.BASE64Decoder;
import sun.security.jca.Providers;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.PKCS9Attribute;
import sun.security.pkcs.PKCS9Attributes;
import sun.security.pkcs.SignerInfo;
import sun.security.timestamp.TimestampToken;
import sun.security.util.ManifestDigester;

public class SignatureFileVerifier {
    private static final String ATTR_DIGEST = null;
    private static final Debug debug = null;
    private static final char[] hexc = null;
    private PKCS7 block;
    private CertificateFactory certificateFactory = null;
    private HashMap<String, MessageDigest> createdDigests;
    private ManifestDigester md;
    private String name;
    private byte[] sfBytes;
    private ArrayList<CodeSigner[]> signerCache;
    private boolean workaround = false;

    /* JADX INFO: finally extract failed */
    public SignatureFileVerifier(ArrayList<CodeSigner[]> signerCache2, ManifestDigester md2, String name2, byte[] rawBytes) throws IOException, CertificateException {
        Object obj = null;
        try {
            obj = Providers.startJarVerification();
            this.block = new PKCS7(rawBytes);
            this.sfBytes = this.block.getContentInfo().getData();
            this.certificateFactory = CertificateFactory.getInstance("X509");
            Providers.stopJarVerification(obj);
            this.name = name2.substring(0, name2.lastIndexOf(".")).toUpperCase(Locale.ENGLISH);
            this.md = md2;
            this.signerCache = signerCache2;
        } catch (Throwable th) {
            Providers.stopJarVerification(obj);
            throw th;
        }
    }

    public boolean needSignatureFileBytes() {
        return this.sfBytes == null;
    }

    public boolean needSignatureFile(String name2) {
        return this.name.equalsIgnoreCase(name2);
    }

    public void setSignatureFile(byte[] sfBytes2) {
        this.sfBytes = sfBytes2;
    }

    public static boolean isBlockOrSF(String s) {
        if (s.endsWith(".SF") || s.endsWith(".DSA") || s.endsWith(".RSA") || s.endsWith(".EC")) {
            return true;
        }
        return false;
    }

    private MessageDigest getDigest(String algorithm) {
        if (this.createdDigests == null) {
            this.createdDigests = new HashMap<>();
        }
        MessageDigest digest = this.createdDigests.get(algorithm);
        if (digest != null) {
            return digest;
        }
        try {
            digest = MessageDigest.getInstance(algorithm);
            this.createdDigests.put(algorithm, digest);
            return digest;
        } catch (NoSuchAlgorithmException e) {
            return digest;
        }
    }

    public void process(Hashtable<String, CodeSigner[]> signers, List manifestDigests) throws IOException, SignatureException, NoSuchAlgorithmException, JarException, CertificateException {
        Object obj = null;
        try {
            obj = Providers.startJarVerification();
            processImpl(signers, manifestDigests);
        } finally {
            Providers.stopJarVerification(obj);
        }
    }

    private void processImpl(Hashtable<String, CodeSigner[]> signers, List manifestDigests) throws IOException, SignatureException, NoSuchAlgorithmException, JarException, CertificateException {
        Manifest sf = new Manifest();
        sf.read(new ByteArrayInputStream(this.sfBytes));
        String version = sf.getMainAttributes().getValue(Attributes.Name.SIGNATURE_VERSION);
        if (version != null && version.equalsIgnoreCase("1.0")) {
            SignerInfo[] infos = this.block.verify(this.sfBytes);
            if (infos == null) {
                throw new SecurityException("cannot verify signature block file " + this.name);
            }
            BASE64Decoder decoder = new BASE64Decoder();
            CodeSigner[] newSigners = getSigners(infos, this.block);
            if (newSigners != null) {
                boolean manifestSigned = verifyManifestHash(sf, this.md, decoder, manifestDigests);
                if (manifestSigned || verifyManifestMainAttrs(sf, this.md, decoder)) {
                    for (Map.Entry<String, Attributes> e : sf.getEntries().entrySet()) {
                        String name2 = e.getKey();
                        if (manifestSigned || verifySection(e.getValue(), name2, this.md, decoder)) {
                            if (name2.startsWith("./")) {
                                name2 = name2.substring(2);
                            }
                            if (name2.startsWith("/")) {
                                name2 = name2.substring(1);
                            }
                            updateSigners(newSigners, signers, name2);
                            if (debug != null) {
                                debug.println("processSignature signed name = " + name2);
                            }
                        } else if (debug != null) {
                            debug.println("processSignature unsigned name = " + name2);
                        }
                    }
                    updateSigners(newSigners, signers, JarFile.MANIFEST_NAME);
                    return;
                }
                throw new SecurityException("Invalid signature file digest for Manifest main attributes");
            }
        }
    }

    private boolean verifyManifestHash(Manifest sf, ManifestDigester md2, BASE64Decoder decoder, List manifestDigests) throws IOException {
        boolean manifestSigned = false;
        for (Map.Entry<Object, Object> se : sf.getMainAttributes().entrySet()) {
            String key = se.getKey().toString();
            if (key.toUpperCase(Locale.ENGLISH).endsWith("-DIGEST-MANIFEST")) {
                String algorithm = key.substring(0, key.length() - 16);
                manifestDigests.add(key);
                manifestDigests.add(se.getValue());
                MessageDigest digest = getDigest(algorithm);
                if (digest != null) {
                    byte[] computedHash = md2.manifestDigest(digest);
                    byte[] expectedHash = decoder.decodeBuffer((String) se.getValue());
                    if (debug != null) {
                        debug.println("Signature File: Manifest digest " + digest.getAlgorithm());
                        debug.println("  sigfile  " + toHex(expectedHash));
                        debug.println("  computed " + toHex(computedHash));
                        debug.println();
                    }
                    if (MessageDigest.isEqual(computedHash, expectedHash)) {
                        manifestSigned = true;
                    }
                }
            }
        }
        return manifestSigned;
    }

    private boolean verifyManifestMainAttrs(Manifest sf, ManifestDigester md2, BASE64Decoder decoder) throws IOException {
        MessageDigest digest;
        boolean attrsVerified = true;
        Iterator se$iterator = sf.getMainAttributes().entrySet().iterator();
        while (true) {
            if (!se$iterator.hasNext()) {
                break;
            }
            Map.Entry<Object, Object> se = (Map.Entry) se$iterator.next();
            String key = se.getKey().toString();
            if (key.toUpperCase(Locale.ENGLISH).endsWith(ATTR_DIGEST) && (digest = getDigest(key.substring(0, key.length() - ATTR_DIGEST.length()))) != null) {
                byte[] computedHash = md2.get(ManifestDigester.MF_MAIN_ATTRS, false).digest(digest);
                byte[] expectedHash = decoder.decodeBuffer((String) se.getValue());
                if (debug != null) {
                    debug.println("Signature File: Manifest Main Attributes digest " + digest.getAlgorithm());
                    debug.println("  sigfile  " + toHex(expectedHash));
                    debug.println("  computed " + toHex(computedHash));
                    debug.println();
                }
                if (!MessageDigest.isEqual(computedHash, expectedHash)) {
                    attrsVerified = false;
                    if (debug != null) {
                        debug.println("Verification of Manifest main attributes failed");
                        debug.println();
                    }
                }
            }
        }
        return attrsVerified;
    }

    private boolean verifySection(Attributes sfAttr, String name2, ManifestDigester md2, BASE64Decoder decoder) throws IOException {
        MessageDigest digest;
        byte[] computed;
        boolean oneDigestVerified = false;
        ManifestDigester.Entry mde = md2.get(name2, this.block.isOldStyle());
        if (mde == null) {
            throw new SecurityException("no manifiest section for signature file entry " + name2);
        }
        if (sfAttr != null) {
            for (Map.Entry<Object, Object> se : sfAttr.entrySet()) {
                String key = se.getKey().toString();
                if (key.toUpperCase(Locale.ENGLISH).endsWith("-DIGEST") && (digest = getDigest(key.substring(0, key.length() - 7))) != null) {
                    boolean ok = false;
                    byte[] expected = decoder.decodeBuffer((String) se.getValue());
                    if (this.workaround) {
                        computed = mde.digestWorkaround(digest);
                    } else {
                        computed = mde.digest(digest);
                    }
                    if (debug != null) {
                        debug.println("Signature Block File: " + name2 + " digest=" + digest.getAlgorithm());
                        debug.println("  expected " + toHex(expected));
                        debug.println("  computed " + toHex(computed));
                        debug.println();
                    }
                    if (MessageDigest.isEqual(computed, expected)) {
                        oneDigestVerified = true;
                        ok = true;
                    } else if (!this.workaround) {
                        byte[] computed2 = mde.digestWorkaround(digest);
                        if (MessageDigest.isEqual(computed2, expected)) {
                            if (debug != null) {
                                debug.println("  re-computed " + toHex(computed2));
                                debug.println();
                            }
                            this.workaround = true;
                            oneDigestVerified = true;
                            ok = true;
                        }
                    }
                    if (!ok) {
                        throw new SecurityException("invalid " + digest.getAlgorithm() + " signature file digest for " + name2);
                    }
                }
            }
        }
        return oneDigestVerified;
    }

    private CodeSigner[] getSigners(SignerInfo[] infos, PKCS7 block2) throws IOException, NoSuchAlgorithmException, SignatureException, CertificateException {
        ArrayList<CodeSigner> signers = null;
        for (SignerInfo info : infos) {
            ArrayList<X509Certificate> chain = info.getCertificateChain(block2);
            CertPath certChain = this.certificateFactory.generateCertPath((List<? extends Certificate>) chain);
            if (signers == null) {
                signers = new ArrayList<>();
            }
            signers.add(new CodeSigner(certChain, getTimestamp(info)));
            if (debug != null) {
                debug.println("Signature Block Certificate: " + chain.get(0));
            }
        }
        if (signers != null) {
            return (CodeSigner[]) signers.toArray(new CodeSigner[signers.size()]);
        }
        return null;
    }

    private Timestamp getTimestamp(SignerInfo info) throws IOException, NoSuchAlgorithmException, SignatureException, CertificateException {
        PKCS9Attribute timestampTokenAttr;
        PKCS9Attributes unsignedAttrs = info.getUnauthenticatedAttributes();
        if (unsignedAttrs == null || (timestampTokenAttr = unsignedAttrs.getAttribute("signatureTimestampToken")) == null) {
            return null;
        }
        PKCS7 timestampToken = new PKCS7((byte[]) timestampTokenAttr.getValue());
        byte[] encodedTimestampTokenInfo = timestampToken.getContentInfo().getData();
        CertPath tsaChain = this.certificateFactory.generateCertPath((List<? extends Certificate>) timestampToken.verify(encodedTimestampTokenInfo)[0].getCertificateChain(timestampToken));
        TimestampToken timestampTokenInfo = new TimestampToken(encodedTimestampTokenInfo);
        verifyTimestamp(timestampTokenInfo, info.getEncryptedDigest());
        return new Timestamp(timestampTokenInfo.getDate(), tsaChain);
    }

    private void verifyTimestamp(TimestampToken token, byte[] signature) throws NoSuchAlgorithmException, SignatureException {
        if (!Arrays.equals(token.getHashedMessage(), MessageDigest.getInstance(token.getHashAlgorithm().getName()).digest(signature))) {
            throw new SignatureException("Signature timestamp (#" + token.getSerialNumber() + ") generated on " + token.getDate() + " is inapplicable");
        } else if (debug != null) {
            debug.println();
            debug.println("Detected signature timestamp (#" + token.getSerialNumber() + ") generated on " + token.getDate());
            debug.println();
        }
    }

    static String toHex(byte[] data) {
        StringBuffer sb = new StringBuffer(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            sb.append(hexc[(data[i] >> 4) & 15]);
            sb.append(hexc[data[i] & 15]);
        }
        return sb.toString();
    }

    static boolean contains(CodeSigner[] set, CodeSigner signer) {
        for (CodeSigner equals : set) {
            if (equals.equals(signer)) {
                return true;
            }
        }
        return false;
    }

    static boolean isSubSet(CodeSigner[] subset, CodeSigner[] set) {
        if (set == subset) {
            return true;
        }
        for (CodeSigner contains : subset) {
            if (!contains(set, contains)) {
                return false;
            }
        }
        return true;
    }

    static boolean matches(CodeSigner[] signers, CodeSigner[] oldSigners, CodeSigner[] newSigners) {
        boolean found;
        if (oldSigners == null && signers == newSigners) {
            return true;
        }
        if ((oldSigners != null && !isSubSet(oldSigners, signers)) || !isSubSet(newSigners, signers)) {
            return false;
        }
        for (int i = 0; i < signers.length; i++) {
            if (oldSigners == null || !contains(oldSigners, signers[i])) {
                found = contains(newSigners, signers[i]);
            } else {
                found = true;
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void updateSigners(CodeSigner[] newSigners, Hashtable<String, CodeSigner[]> signers, String name2) {
        CodeSigner[] cachedSigners;
        CodeSigner[] oldSigners = signers.get(name2);
        for (int i = this.signerCache.size() - 1; i != -1; i--) {
            CodeSigner[] cachedSigners2 = this.signerCache.get(i);
            if (matches(cachedSigners2, oldSigners, newSigners)) {
                signers.put(name2, cachedSigners2);
                return;
            }
        }
        if (oldSigners == null) {
            cachedSigners = newSigners;
        } else {
            cachedSigners = new CodeSigner[(oldSigners.length + newSigners.length)];
            System.arraycopy((Object) oldSigners, 0, (Object) cachedSigners, 0, oldSigners.length);
            System.arraycopy((Object) newSigners, 0, (Object) cachedSigners, oldSigners.length, newSigners.length);
        }
        this.signerCache.add(cachedSigners);
        signers.put(name2, cachedSigners);
    }
}
