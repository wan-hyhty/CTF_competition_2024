package sun.security.ec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import sun.security.util.DerOutputStream;
import sun.security.util.ObjectIdentifier;

public final class NamedCurve extends ECParameterSpec {
    private static final int B = 2;
    private static final int BD = 6;
    private static final int P = 1;
    private static final int PD = 5;
    private static Pattern SPLIT_PATTERN;
    private static final Map<Integer, NamedCurve> lengthMap = null;
    private static final Map<String, NamedCurve> nameMap = null;
    private static final Map<String, NamedCurve> oidMap = null;
    private final byte[] encoded;
    private final String name;
    private final ObjectIdentifier oid;

    private NamedCurve(String name2, ObjectIdentifier oid2, EllipticCurve curve, ECPoint g, BigInteger n, int h) throws IOException {
        super(curve, g, n, h);
        this.name = name2;
        this.oid = oid2;
        DerOutputStream out = new DerOutputStream();
        out.putOID(oid2);
        this.encoded = out.toByteArray();
    }

    public static ECParameterSpec getECParameterSpec(String name2) {
        NamedCurve spec = oidMap.get(name2);
        return spec != null ? spec : nameMap.get(name2);
    }

    static ECParameterSpec getECParameterSpec(ObjectIdentifier oid2) {
        return getECParameterSpec(oid2.toString());
    }

    public static ECParameterSpec getECParameterSpec(int length) {
        return lengthMap.get(Integer.valueOf(length));
    }

    public static Collection<? extends ECParameterSpec> knownECParameterSpecs() {
        return Collections.unmodifiableCollection(oidMap.values());
    }

    /* access modifiers changed from: package-private */
    public byte[] getEncoded() {
        return (byte[]) this.encoded.clone();
    }

    /* access modifiers changed from: package-private */
    public ObjectIdentifier getObjectIdentifier() {
        return this.oid;
    }

    public String toString() {
        return this.name + " (" + this.oid + ")";
    }

    private static BigInteger bi(String s) {
        return new BigInteger(s, 16);
    }

    private static void add(String name2, String soid, int type, String sfield, String a, String b, String x, String y, String n, int h) {
        ECField field;
        BigInteger p = bi(sfield);
        if (type == 1 || type == 5) {
            field = new ECFieldFp(p);
        } else if (type == 2 || type == 6) {
            field = new ECFieldF2m(p.bitLength() - 1, p);
        } else {
            throw new RuntimeException("Invalid type: " + type);
        }
        try {
            NamedCurve params = new NamedCurve(name2, new ObjectIdentifier(soid), new EllipticCurve(field, bi(a), bi(b)), new ECPoint(bi(x), bi(y)), bi(n), h);
            if (oidMap.put(soid, params) != null) {
                throw new RuntimeException("Duplication oid: " + soid);
            }
            for (String commonName : SPLIT_PATTERN.split(name2)) {
                if (nameMap.put(commonName.trim(), params) != null) {
                    throw new RuntimeException("Duplication name: " + commonName);
                }
            }
            int len = field.getFieldSize();
            if (type == 5 || type == 6 || lengthMap.get(Integer.valueOf(len)) == null) {
                lengthMap.put(Integer.valueOf(len), params);
            }
        } catch (IOException e) {
            throw new RuntimeException("Internal error", e);
        }
    }
}
