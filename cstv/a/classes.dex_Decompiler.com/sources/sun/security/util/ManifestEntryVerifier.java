package sun.security.util;

import java.io.IOException;
import java.security.CodeSigner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarException;
import java.util.jar.Manifest;
import sun.misc.BASE64Decoder;

public class ManifestEntryVerifier {
    private static final Debug debug = null;
    private static final char[] hexc = null;
    HashMap<String, MessageDigest> createdDigests;
    private BASE64Decoder decoder;
    ArrayList<MessageDigest> digests;
    private JarEntry entry;
    private Manifest man;
    ArrayList<byte[]> manifestHashes;
    private String name;
    private CodeSigner[] signers;
    private boolean skip;

    private static class SunProviderHolder {
        /* access modifiers changed from: private */
        public static final Provider instance = null;

        private SunProviderHolder() {
        }
    }

    public ManifestEntryVerifier(Manifest man2) {
        this.decoder = null;
        this.name = null;
        this.skip = true;
        this.signers = null;
        this.createdDigests = new HashMap<>(11);
        this.digests = new ArrayList<>();
        this.manifestHashes = new ArrayList<>();
        this.decoder = new BASE64Decoder();
        this.man = man2;
    }

    public void setEntry(String name2, JarEntry entry2) throws IOException {
        this.digests.clear();
        this.manifestHashes.clear();
        this.name = name2;
        this.entry = entry2;
        this.skip = true;
        this.signers = null;
        if (this.man != null && name2 != null) {
            Attributes attr = this.man.getAttributes(name2);
            if (attr != null || (attr = this.man.getAttributes("./" + name2)) != null || (attr = this.man.getAttributes("/" + name2)) != null) {
                for (Map.Entry<Object, Object> se : attr.entrySet()) {
                    String key = se.getKey().toString();
                    if (key.toUpperCase(Locale.ENGLISH).endsWith("-DIGEST")) {
                        String algorithm = key.substring(0, key.length() - 7);
                        MessageDigest digest = this.createdDigests.get(algorithm);
                        if (digest == null) {
                            try {
                                digest = MessageDigest.getInstance(algorithm, SunProviderHolder.instance);
                                this.createdDigests.put(algorithm, digest);
                            } catch (NoSuchAlgorithmException e) {
                            }
                        }
                        if (digest != null) {
                            this.skip = false;
                            digest.reset();
                            this.digests.add(digest);
                            this.manifestHashes.add(this.decoder.decodeBuffer((String) se.getValue()));
                        }
                    }
                }
            }
        }
    }

    public void update(byte buffer) {
        if (!this.skip) {
            for (int i = 0; i < this.digests.size(); i++) {
                this.digests.get(i).update(buffer);
            }
        }
    }

    public void update(byte[] buffer, int off, int len) {
        if (!this.skip) {
            for (int i = 0; i < this.digests.size(); i++) {
                this.digests.get(i).update(buffer, off, len);
            }
        }
    }

    public JarEntry getEntry() {
        return this.entry;
    }

    public CodeSigner[] verify(Hashtable<String, CodeSigner[]> verifiedSigners, Hashtable<String, CodeSigner[]> sigFileSigners) throws JarException {
        if (this.skip) {
            return null;
        }
        if (this.signers != null) {
            return this.signers;
        }
        for (int i = 0; i < this.digests.size(); i++) {
            MessageDigest digest = this.digests.get(i);
            byte[] manHash = this.manifestHashes.get(i);
            byte[] theHash = digest.digest();
            if (debug != null) {
                debug.println("Manifest Entry: " + this.name + " digest=" + digest.getAlgorithm());
                debug.println("  manifest " + toHex(manHash));
                debug.println("  computed " + toHex(theHash));
                debug.println();
            }
            if (!MessageDigest.isEqual(theHash, manHash)) {
                throw new SecurityException(digest.getAlgorithm() + " digest error for " + this.name);
            }
        }
        this.signers = sigFileSigners.remove(this.name);
        if (this.signers != null) {
            verifiedSigners.put(this.name, this.signers);
        }
        return this.signers;
    }

    static String toHex(byte[] data) {
        StringBuffer sb = new StringBuffer(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            sb.append(hexc[(data[i] >> 4) & 15]);
            sb.append(hexc[data[i] & 15]);
        }
        return sb.toString();
    }
}
