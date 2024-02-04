package sun.security.pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import sun.misc.HexDumpEncoder;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.CertificateExtensions;

public class PKCS9Attribute implements DerEncoder {
    private static final Class<?> BYTE_ARRAY_CLASS = null;
    public static final ObjectIdentifier CHALLENGE_PASSWORD_OID = null;
    public static final String CHALLENGE_PASSWORD_STR = "ChallengePassword";
    public static final ObjectIdentifier CONTENT_TYPE_OID = null;
    public static final String CONTENT_TYPE_STR = "ContentType";
    public static final ObjectIdentifier COUNTERSIGNATURE_OID = null;
    public static final String COUNTERSIGNATURE_STR = "Countersignature";
    public static final ObjectIdentifier EMAIL_ADDRESS_OID = null;
    public static final String EMAIL_ADDRESS_STR = "EmailAddress";
    public static final ObjectIdentifier EXTENDED_CERTIFICATE_ATTRIBUTES_OID = null;
    public static final String EXTENDED_CERTIFICATE_ATTRIBUTES_STR = "ExtendedCertificateAttributes";
    public static final ObjectIdentifier EXTENSION_REQUEST_OID = null;
    public static final String EXTENSION_REQUEST_STR = "ExtensionRequest";
    public static final ObjectIdentifier ISSUER_SERIALNUMBER_OID = null;
    public static final String ISSUER_SERIALNUMBER_STR = "IssuerAndSerialNumber";
    public static final ObjectIdentifier MESSAGE_DIGEST_OID = null;
    public static final String MESSAGE_DIGEST_STR = "MessageDigest";
    private static final Hashtable<String, ObjectIdentifier> NAME_OID_TABLE = null;
    private static final Hashtable<ObjectIdentifier, String> OID_NAME_TABLE = null;
    static final ObjectIdentifier[] PKCS9_OIDS = null;
    private static final Byte[][] PKCS9_VALUE_TAGS = null;
    private static final String RSA_PROPRIETARY_STR = "RSAProprietary";
    public static final ObjectIdentifier SIGNATURE_TIMESTAMP_TOKEN_OID = null;
    public static final String SIGNATURE_TIMESTAMP_TOKEN_STR = "SignatureTimestampToken";
    public static final ObjectIdentifier SIGNING_CERTIFICATE_OID = null;
    public static final String SIGNING_CERTIFICATE_STR = "SigningCertificate";
    public static final ObjectIdentifier SIGNING_TIME_OID = null;
    public static final String SIGNING_TIME_STR = "SigningTime";
    private static final boolean[] SINGLE_VALUED = null;
    public static final ObjectIdentifier SMIME_CAPABILITY_OID = null;
    public static final String SMIME_CAPABILITY_STR = "SMIMECapability";
    private static final String SMIME_SIGNING_DESC_STR = "SMIMESigningDesc";
    public static final ObjectIdentifier UNSTRUCTURED_ADDRESS_OID = null;
    public static final String UNSTRUCTURED_ADDRESS_STR = "UnstructuredAddress";
    public static final ObjectIdentifier UNSTRUCTURED_NAME_OID = null;
    public static final String UNSTRUCTURED_NAME_STR = "UnstructuredName";
    private static final Class[] VALUE_CLASSES = null;
    private static final Debug debug = null;
    private int index;
    private ObjectIdentifier oid;
    private Object value;

    public PKCS9Attribute(ObjectIdentifier oid2, Object value2) throws IllegalArgumentException {
        init(oid2, value2);
    }

    public PKCS9Attribute(String name, Object value2) throws IllegalArgumentException {
        ObjectIdentifier oid2 = getOID(name);
        if (oid2 == null) {
            throw new IllegalArgumentException("Unrecognized attribute name " + name + " constructing PKCS9Attribute.");
        }
        init(oid2, value2);
    }

    private void init(ObjectIdentifier oid2, Object value2) throws IllegalArgumentException {
        this.oid = oid2;
        this.index = indexOf(oid2, PKCS9_OIDS, 1);
        Class<?> clazz = this.index == -1 ? BYTE_ARRAY_CLASS : VALUE_CLASSES[this.index];
        if (!clazz.isInstance(value2)) {
            throw new IllegalArgumentException("Wrong value class  for attribute " + oid2 + " constructing PKCS9Attribute; was " + value2.getClass().toString() + ", should be " + clazz.toString());
        }
        this.value = value2;
    }

    public PKCS9Attribute(DerValue derVal) throws IOException {
        DerInputStream derIn = new DerInputStream(derVal.toByteArray());
        DerValue[] val = derIn.getSequence(2);
        if (derIn.available() != 0) {
            throw new IOException("Excess data parsing PKCS9Attribute");
        } else if (val.length != 2) {
            throw new IOException("PKCS9Attribute doesn't have two components");
        } else {
            this.oid = val[0].getOID();
            byte[] content = val[1].toByteArray();
            DerValue[] elems = new DerInputStream(content).getSet(1);
            this.index = indexOf(this.oid, PKCS9_OIDS, 1);
            if (this.index == -1) {
                if (debug != null) {
                    debug.println("Unsupported signer attribute: " + this.oid);
                }
                this.value = content;
                return;
            }
            if (SINGLE_VALUED[this.index] && elems.length > 1) {
                throwSingleValuedException();
            }
            for (DerValue derValue : elems) {
                Byte tag = new Byte(derValue.tag);
                if (indexOf(tag, PKCS9_VALUE_TAGS[this.index], 0) == -1) {
                    throwTagException(tag);
                }
            }
            switch (this.index) {
                case 1:
                case 2:
                case 8:
                    String[] values = new String[elems.length];
                    for (int i = 0; i < elems.length; i++) {
                        values[i] = elems[i].getAsString();
                    }
                    this.value = values;
                    return;
                case 3:
                    this.value = elems[0].getOID();
                    return;
                case 4:
                    this.value = elems[0].getOctetString();
                    return;
                case 5:
                    this.value = new DerInputStream(elems[0].toByteArray()).getUTCTime();
                    return;
                case 6:
                    SignerInfo[] values2 = new SignerInfo[elems.length];
                    for (int i2 = 0; i2 < elems.length; i2++) {
                        values2[i2] = new SignerInfo(elems[i2].toDerInputStream());
                    }
                    this.value = values2;
                    return;
                case 7:
                    this.value = elems[0].getAsString();
                    return;
                case 9:
                    throw new IOException("PKCS9 extended-certificate attribute not supported.");
                case 10:
                    throw new IOException("PKCS9 IssuerAndSerialNumberattribute not supported.");
                case 11:
                case 12:
                    throw new IOException("PKCS9 RSA DSI attributes11 and 12, not supported.");
                case 13:
                    throw new IOException("PKCS9 attribute #13 not supported.");
                case 14:
                    this.value = new CertificateExtensions(new DerInputStream(elems[0].toByteArray()));
                    return;
                case 15:
                    throw new IOException("PKCS9 SMIMECapability attribute not supported.");
                case 16:
                    this.value = new SigningCertificateInfo(elems[0].toByteArray());
                    return;
                case 17:
                    this.value = elems[0].toByteArray();
                    return;
                default:
                    return;
            }
        }
    }

    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream temp = new DerOutputStream();
        temp.putOID(this.oid);
        switch (this.index) {
            case -1:
                temp.write((byte[]) this.value);
                break;
            case 1:
            case 2:
                String[] values = (String[]) this.value;
                DerOutputStream[] temps = new DerOutputStream[values.length];
                for (int i = 0; i < values.length; i++) {
                    temps[i] = new DerOutputStream();
                    temps[i].putIA5String(values[i]);
                }
                temp.putOrderedSetOf((byte) 49, temps);
                break;
            case 3:
                DerOutputStream temp2 = new DerOutputStream();
                temp2.putOID((ObjectIdentifier) this.value);
                temp.write((byte) 49, temp2.toByteArray());
                break;
            case 4:
                DerOutputStream temp22 = new DerOutputStream();
                temp22.putOctetString((byte[]) this.value);
                temp.write((byte) 49, temp22.toByteArray());
                break;
            case 5:
                DerOutputStream temp23 = new DerOutputStream();
                temp23.putUTCTime((Date) this.value);
                temp.write((byte) 49, temp23.toByteArray());
                break;
            case 6:
                temp.putOrderedSetOf((byte) 49, (DerEncoder[]) this.value);
                break;
            case 7:
                DerOutputStream temp24 = new DerOutputStream();
                temp24.putPrintableString((String) this.value);
                temp.write((byte) 49, temp24.toByteArray());
                break;
            case 8:
                String[] values2 = (String[]) this.value;
                DerOutputStream[] temps2 = new DerOutputStream[values2.length];
                for (int i2 = 0; i2 < values2.length; i2++) {
                    temps2[i2] = new DerOutputStream();
                    temps2[i2].putPrintableString(values2[i2]);
                }
                temp.putOrderedSetOf((byte) 49, temps2);
                break;
            case 9:
                throw new IOException("PKCS9 extended-certificate attribute not supported.");
            case 10:
                throw new IOException("PKCS9 IssuerAndSerialNumberattribute not supported.");
            case 11:
            case 12:
                throw new IOException("PKCS9 RSA DSI attributes11 and 12, not supported.");
            case 13:
                throw new IOException("PKCS9 attribute #13 not supported.");
            case 14:
                DerOutputStream temp25 = new DerOutputStream();
                try {
                    ((CertificateExtensions) this.value).encode(temp25, true);
                    temp.write((byte) 49, temp25.toByteArray());
                    break;
                } catch (CertificateException ex) {
                    throw new IOException(ex.toString());
                }
            case 15:
                throw new IOException("PKCS9 attribute #15 not supported.");
            case 16:
                throw new IOException("PKCS9 SigningCertificate attribute not supported.");
            case 17:
                temp.write((byte) 49, (byte[]) this.value);
                break;
        }
        DerOutputStream derOut = new DerOutputStream();
        derOut.write((byte) 48, temp.toByteArray());
        out.write(derOut.toByteArray());
    }

    public boolean isKnown() {
        return this.index != -1;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isSingleValued() {
        if (this.index != -1) {
            return SINGLE_VALUED[this.index];
        }
        return true;
    }

    public ObjectIdentifier getOID() {
        return this.oid;
    }

    public String getName() {
        if (this.index == -1) {
            return this.oid.toString();
        }
        return OID_NAME_TABLE.get(PKCS9_OIDS[this.index]);
    }

    public static ObjectIdentifier getOID(String name) {
        return NAME_OID_TABLE.get(name.toLowerCase(Locale.ENGLISH));
    }

    public static String getName(ObjectIdentifier oid2) {
        return OID_NAME_TABLE.get(oid2);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer(100);
        buf.append("[");
        if (this.index == -1) {
            buf.append(this.oid.toString());
        } else {
            buf.append(OID_NAME_TABLE.get(PKCS9_OIDS[this.index]));
        }
        buf.append(": ");
        if (this.index == -1 || SINGLE_VALUED[this.index]) {
            if (this.value instanceof byte[]) {
                buf.append(new HexDumpEncoder().encodeBuffer((byte[]) this.value));
            } else {
                buf.append(this.value.toString());
            }
            buf.append("]");
            return buf.toString();
        }
        boolean first = true;
        Object[] values = (Object[]) this.value;
        for (Object obj : values) {
            if (first) {
                first = false;
            } else {
                buf.append(", ");
            }
            buf.append(obj.toString());
        }
        return buf.toString();
    }

    static int indexOf(Object obj, Object[] a, int start) {
        for (int i = start; i < a.length; i++) {
            if (obj.equals(a[i])) {
                return i;
            }
        }
        return -1;
    }

    private void throwSingleValuedException() throws IOException {
        throw new IOException("Single-value attribute " + this.oid + " (" + getName() + ")" + " has multiple values.");
    }

    private void throwTagException(Byte tag) throws IOException {
        Byte[] expectedTags = PKCS9_VALUE_TAGS[this.index];
        StringBuffer msg = new StringBuffer(100);
        msg.append("Value of attribute ");
        msg.append(this.oid.toString());
        msg.append(" (");
        msg.append(getName());
        msg.append(") has wrong tag: ");
        msg.append(tag.toString());
        msg.append(".  Expected tags: ");
        msg.append(expectedTags[0].toString());
        for (int i = 1; i < expectedTags.length; i++) {
            msg.append(", ");
            msg.append(expectedTags[i].toString());
        }
        msg.append(".");
        throw new IOException(msg.toString());
    }
}
