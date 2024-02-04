package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import sun.security.ec.ECKeyFactory;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.util.locale.LanguageTag;

public class AlgorithmId implements Serializable, DerEncoder {
    private static final int[] DH_PKIX_data = null;
    public static final ObjectIdentifier DH_PKIX_oid = null;
    private static final int[] DH_data = null;
    public static final ObjectIdentifier DH_oid = null;
    private static final int[] DSA_OIW_data = null;
    public static final ObjectIdentifier DSA_OIW_oid = null;
    private static final int[] DSA_PKIX_data = null;
    public static final ObjectIdentifier DSA_oid = null;
    public static final ObjectIdentifier EC_oid = null;
    public static final ObjectIdentifier MD2_oid = null;
    public static final ObjectIdentifier MD5_oid = null;
    private static final int[] RSAEncryption_data = null;
    public static final ObjectIdentifier RSAEncryption_oid = null;
    private static final int[] RSA_data = null;
    public static final ObjectIdentifier RSA_oid = null;
    public static final ObjectIdentifier SHA256_oid = null;
    public static final ObjectIdentifier SHA384_oid = null;
    public static final ObjectIdentifier SHA512_oid = null;
    public static final ObjectIdentifier SHA_oid = null;
    private static final int[] dsaWithSHA1_PKIX_data = null;
    private static int initOidTableVersion = 0;
    private static final int[] md2WithRSAEncryption_data = null;
    public static final ObjectIdentifier md2WithRSAEncryption_oid = null;
    private static final int[] md5WithRSAEncryption_data = null;
    public static final ObjectIdentifier md5WithRSAEncryption_oid = null;
    private static final Map<ObjectIdentifier, String> nameTable = null;
    private static final Map<String, ObjectIdentifier> oidTable = null;
    public static final ObjectIdentifier pbeWithMD5AndDES_oid = null;
    public static final ObjectIdentifier pbeWithMD5AndRC2_oid = null;
    public static final ObjectIdentifier pbeWithSHA1AndDES_oid = null;
    public static ObjectIdentifier pbeWithSHA1AndDESede_oid = null;
    public static ObjectIdentifier pbeWithSHA1AndRC2_40_oid = null;
    public static final ObjectIdentifier pbeWithSHA1AndRC2_oid = null;
    private static final long serialVersionUID = 7205873507486557157L;
    private static final int[] sha1WithDSA_OIW_data = null;
    public static final ObjectIdentifier sha1WithDSA_OIW_oid = null;
    public static final ObjectIdentifier sha1WithDSA_oid = null;
    public static final ObjectIdentifier sha1WithECDSA_oid = null;
    private static final int[] sha1WithRSAEncryption_OIW_data = null;
    public static final ObjectIdentifier sha1WithRSAEncryption_OIW_oid = null;
    private static final int[] sha1WithRSAEncryption_data = null;
    public static final ObjectIdentifier sha1WithRSAEncryption_oid = null;
    public static final ObjectIdentifier sha224WithECDSA_oid = null;
    public static final ObjectIdentifier sha256WithECDSA_oid = null;
    private static final int[] sha256WithRSAEncryption_data = null;
    public static final ObjectIdentifier sha256WithRSAEncryption_oid = null;
    public static final ObjectIdentifier sha384WithECDSA_oid = null;
    private static final int[] sha384WithRSAEncryption_data = null;
    public static final ObjectIdentifier sha384WithRSAEncryption_oid = null;
    public static final ObjectIdentifier sha512WithECDSA_oid = null;
    private static final int[] sha512WithRSAEncryption_data = null;
    public static final ObjectIdentifier sha512WithRSAEncryption_oid = null;
    private static final int[] shaWithDSA_OIW_data = null;
    public static final ObjectIdentifier shaWithDSA_OIW_oid = null;
    public static final ObjectIdentifier specifiedWithECDSA_oid = null;
    private AlgorithmParameters algParams;
    private ObjectIdentifier algid;
    private boolean constructedFromDer = true;
    protected DerValue params;

    @Deprecated
    public AlgorithmId() {
    }

    public AlgorithmId(ObjectIdentifier oid) {
        this.algid = oid;
    }

    public AlgorithmId(ObjectIdentifier oid, AlgorithmParameters algparams) {
        this.algid = oid;
        this.algParams = algparams;
        this.constructedFromDer = false;
    }

    private AlgorithmId(ObjectIdentifier oid, DerValue params2) throws IOException {
        this.algid = oid;
        this.params = params2;
        if (this.params != null) {
            decodeParams();
        }
    }

    /* access modifiers changed from: protected */
    public void decodeParams() throws IOException {
        String algidString = this.algid.toString();
        try {
            this.algParams = AlgorithmParameters.getInstance(algidString);
        } catch (NoSuchAlgorithmException e) {
            try {
                this.algParams = AlgorithmParameters.getInstance(algidString, ECKeyFactory.ecInternalProvider);
            } catch (NoSuchAlgorithmException e2) {
                this.algParams = null;
                return;
            }
        }
        this.algParams.init(this.params.toByteArray());
    }

    public final void encode(DerOutputStream out) throws IOException {
        derEncode(out);
    }

    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream bytes = new DerOutputStream();
        DerOutputStream tmp = new DerOutputStream();
        bytes.putOID(this.algid);
        if (!this.constructedFromDer) {
            if (this.algParams != null) {
                this.params = new DerValue(this.algParams.getEncoded());
            } else {
                this.params = null;
            }
        }
        if (this.params == null) {
            bytes.putNull();
        } else {
            bytes.putDerValue(this.params);
        }
        tmp.write((byte) 48, bytes);
        out.write(tmp.toByteArray());
    }

    public final byte[] encode() throws IOException {
        DerOutputStream out = new DerOutputStream();
        derEncode(out);
        return out.toByteArray();
    }

    public final ObjectIdentifier getOID() {
        return this.algid;
    }

    public String getName() {
        String algName;
        String algName2 = nameTable.get(this.algid);
        if (algName2 != null) {
            return algName2;
        }
        if (this.params != null && this.algid.equals(specifiedWithECDSA_oid)) {
            try {
                String paramsName = parse(new DerValue(getEncodedParams())).getName();
                if (paramsName.equals("SHA")) {
                    paramsName = "SHA1";
                }
                String algName3 = paramsName + "withECDSA";
            } catch (IOException e) {
            }
        }
        synchronized (oidTable) {
            reinitializeMappingTableLocked();
            algName = nameTable.get(this.algid);
        }
        return algName == null ? this.algid.toString() : algName;
    }

    public AlgorithmParameters getParameters() {
        return this.algParams;
    }

    public byte[] getEncodedParams() throws IOException {
        if (this.params == null) {
            return null;
        }
        return this.params.toByteArray();
    }

    public boolean equals(AlgorithmId other) {
        boolean equals = this.params == null ? other.params == null : this.params.equals(other.params);
        if (this.algid.equals(other.algid)) {
            return equals;
        }
        return false;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AlgorithmId) {
            return equals((AlgorithmId) other);
        }
        if (other instanceof ObjectIdentifier) {
            return equals((ObjectIdentifier) other);
        }
        return false;
    }

    public final boolean equals(ObjectIdentifier id) {
        return this.algid.equals(id);
    }

    public int hashCode() {
        return (this.algid.toString() + paramsToString()).hashCode();
    }

    /* access modifiers changed from: protected */
    public String paramsToString() {
        if (this.params == null) {
            return "";
        }
        if (this.algParams != null) {
            return this.algParams.toString();
        }
        return ", params unparsed";
    }

    public String toString() {
        return getName() + paramsToString();
    }

    public static AlgorithmId parse(DerValue val) throws IOException {
        DerValue params2;
        if (val.tag != 48) {
            throw new IOException("algid parse error, not a sequence");
        }
        DerInputStream in = val.toDerInputStream();
        ObjectIdentifier algid2 = in.getOID();
        if (in.available() == 0) {
            params2 = null;
        } else {
            params2 = in.getDerValue();
            if (params2.tag == 5) {
                if (params2.length() != 0) {
                    throw new IOException("invalid NULL");
                }
                params2 = null;
            }
            if (in.available() != 0) {
                throw new IOException("Invalid AlgorithmIdentifier: extra data");
            }
        }
        return new AlgorithmId(algid2, params2);
    }

    @Deprecated
    public static AlgorithmId getAlgorithmId(String algname) throws NoSuchAlgorithmException {
        return get(algname);
    }

    public static AlgorithmId get(String algname) throws NoSuchAlgorithmException {
        try {
            ObjectIdentifier oid = algOID(algname);
            if (oid != null) {
                return new AlgorithmId(oid);
            }
            throw new NoSuchAlgorithmException("unrecognized algorithm name: " + algname);
        } catch (IOException e) {
            throw new NoSuchAlgorithmException("Invalid ObjectIdentifier " + algname);
        }
    }

    public static AlgorithmId get(AlgorithmParameters algparams) throws NoSuchAlgorithmException {
        String algname = algparams.getAlgorithm();
        try {
            ObjectIdentifier oid = algOID(algname);
            if (oid != null) {
                return new AlgorithmId(oid, algparams);
            }
            throw new NoSuchAlgorithmException("unrecognized algorithm name: " + algname);
        } catch (IOException e) {
            throw new NoSuchAlgorithmException("Invalid ObjectIdentifier " + algname);
        }
    }

    private static ObjectIdentifier algOID(String name) throws IOException {
        ObjectIdentifier objectIdentifier;
        if (name.indexOf(46) != -1) {
            if (name.startsWith("OID.")) {
                return new ObjectIdentifier(name.substring("OID.".length()));
            }
            return new ObjectIdentifier(name);
        } else if (name.equalsIgnoreCase("MD5")) {
            return MD5_oid;
        } else {
            if (name.equalsIgnoreCase("MD2")) {
                return MD2_oid;
            }
            if (name.equalsIgnoreCase("SHA") || name.equalsIgnoreCase("SHA1") || name.equalsIgnoreCase("SHA-1")) {
                return SHA_oid;
            }
            if (name.equalsIgnoreCase("SHA-256") || name.equalsIgnoreCase("SHA256")) {
                return SHA256_oid;
            }
            if (name.equalsIgnoreCase("SHA-384") || name.equalsIgnoreCase("SHA384")) {
                return SHA384_oid;
            }
            if (name.equalsIgnoreCase("SHA-512") || name.equalsIgnoreCase("SHA512")) {
                return SHA512_oid;
            }
            if (name.equalsIgnoreCase("RSA")) {
                return RSAEncryption_oid;
            }
            if (name.equalsIgnoreCase("Diffie-Hellman") || name.equalsIgnoreCase("DH")) {
                return DH_oid;
            }
            if (name.equalsIgnoreCase("DSA")) {
                return DSA_oid;
            }
            if (name.equalsIgnoreCase("EC")) {
                return EC_oid;
            }
            if (name.equalsIgnoreCase("MD5withRSA") || name.equalsIgnoreCase("MD5/RSA")) {
                return md5WithRSAEncryption_oid;
            }
            if (name.equalsIgnoreCase("MD2withRSA") || name.equalsIgnoreCase("MD2/RSA")) {
                return md2WithRSAEncryption_oid;
            }
            if (name.equalsIgnoreCase("SHAwithDSA") || name.equalsIgnoreCase("SHA1withDSA") || name.equalsIgnoreCase("SHA/DSA") || name.equalsIgnoreCase("SHA1/DSA") || name.equalsIgnoreCase("DSAWithSHA1") || name.equalsIgnoreCase("DSS") || name.equalsIgnoreCase("SHA-1/DSA")) {
                return sha1WithDSA_oid;
            }
            if (name.equalsIgnoreCase("SHA1WithRSA") || name.equalsIgnoreCase("SHA1/RSA")) {
                return sha1WithRSAEncryption_oid;
            }
            if (name.equalsIgnoreCase("SHA1withECDSA") || name.equalsIgnoreCase("ECDSA")) {
                return sha1WithECDSA_oid;
            }
            if (name.equalsIgnoreCase("SHA224withECDSA")) {
                return sha224WithECDSA_oid;
            }
            if (name.equalsIgnoreCase("SHA256withECDSA")) {
                return sha256WithECDSA_oid;
            }
            if (name.equalsIgnoreCase("SHA384withECDSA")) {
                return sha384WithECDSA_oid;
            }
            if (name.equalsIgnoreCase("SHA512withECDSA")) {
                return sha512WithECDSA_oid;
            }
            synchronized (oidTable) {
                reinitializeMappingTableLocked();
                objectIdentifier = oidTable.get(name.toUpperCase(Locale.ENGLISH));
            }
            return objectIdentifier;
        }
    }

    private static void reinitializeMappingTableLocked() {
        String stdAlgName;
        int currentVersion = Security.getVersion();
        if (initOidTableVersion != currentVersion) {
            Provider[] provs = Security.getProviders();
            for (int i = 0; i < provs.length; i++) {
                Enumeration<Object> enum_ = provs[i].keys();
                while (enum_.hasMoreElements()) {
                    String alias = (String) enum_.nextElement();
                    String upperCaseAlias = alias.toUpperCase(Locale.ENGLISH);
                    if (upperCaseAlias.startsWith("ALG.ALIAS")) {
                        int index = upperCaseAlias.indexOf("OID.", 0);
                        if (index != -1) {
                            int index2 = index + "OID.".length();
                            if (index2 == alias.length()) {
                                break;
                            }
                            String oidString = alias.substring(index2);
                            String stdAlgName2 = provs[i].getProperty(alias);
                            if (stdAlgName2 != null) {
                                String stdAlgName3 = stdAlgName2.toUpperCase(Locale.ENGLISH);
                                ObjectIdentifier oid = null;
                                try {
                                    oid = new ObjectIdentifier(oidString);
                                } catch (IOException e) {
                                }
                                if (oid != null) {
                                    if (!oidTable.containsKey(stdAlgName3)) {
                                        oidTable.put(stdAlgName3, oid);
                                    }
                                    if (!nameTable.containsKey(oid)) {
                                        nameTable.put(oid, stdAlgName3);
                                    }
                                }
                            }
                        } else {
                            ObjectIdentifier oid2 = null;
                            try {
                                oid2 = new ObjectIdentifier(alias.substring(alias.indexOf(46, "ALG.ALIAS.".length()) + 1));
                            } catch (IOException e2) {
                            }
                            if (!(oid2 == null || (stdAlgName = provs[i].getProperty(alias)) == null)) {
                                String stdAlgName4 = stdAlgName.toUpperCase(Locale.ENGLISH);
                                if (!oidTable.containsKey(stdAlgName4)) {
                                    oidTable.put(stdAlgName4, oid2);
                                }
                                if (!nameTable.containsKey(oid2)) {
                                    nameTable.put(oid2, stdAlgName4);
                                }
                            }
                        }
                    }
                }
            }
            initOidTableVersion = currentVersion;
        }
    }

    private static ObjectIdentifier oid(int... values) {
        return ObjectIdentifier.newInternal(values);
    }

    public static String makeSigAlg(String digAlg, String encAlg) {
        String digAlg2 = digAlg.replace((CharSequence) LanguageTag.SEP, (CharSequence) "").toUpperCase(Locale.ENGLISH);
        if (digAlg2.equalsIgnoreCase("SHA")) {
            digAlg2 = "SHA1";
        }
        String encAlg2 = encAlg.toUpperCase(Locale.ENGLISH);
        if (encAlg2.equals("EC")) {
            encAlg2 = "ECDSA";
        }
        return digAlg2 + "with" + encAlg2;
    }

    public static String getEncAlgFromSigAlg(String signatureAlgorithm) {
        String keyAlgorithm;
        String signatureAlgorithm2 = signatureAlgorithm.toUpperCase(Locale.ENGLISH);
        int with = signatureAlgorithm2.indexOf("WITH");
        if (with <= 0) {
            return null;
        }
        int and = signatureAlgorithm2.indexOf("AND", with + 4);
        if (and > 0) {
            keyAlgorithm = signatureAlgorithm2.substring(with + 4, and);
        } else {
            keyAlgorithm = signatureAlgorithm2.substring(with + 4);
        }
        if (keyAlgorithm.equalsIgnoreCase("ECDSA")) {
            return "EC";
        }
        return keyAlgorithm;
    }

    public static String getDigAlgFromSigAlg(String signatureAlgorithm) {
        String signatureAlgorithm2 = signatureAlgorithm.toUpperCase(Locale.ENGLISH);
        int with = signatureAlgorithm2.indexOf("WITH");
        if (with > 0) {
            return signatureAlgorithm2.substring(0, with);
        }
        return null;
    }
}
