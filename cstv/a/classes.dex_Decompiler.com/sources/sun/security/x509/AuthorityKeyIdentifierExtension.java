package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

public class AuthorityKeyIdentifierExtension extends Extension implements CertAttrSet<String> {
    public static final String AUTH_NAME = "auth_name";
    public static final String IDENT = "x509.info.extensions.AuthorityKeyIdentifier";
    public static final String KEY_ID = "key_id";
    public static final String NAME = "AuthorityKeyIdentifier";
    public static final String SERIAL_NUMBER = "serial_number";
    private static final byte TAG_ID = 0;
    private static final byte TAG_NAMES = 1;
    private static final byte TAG_SERIAL_NUM = 2;
    private KeyIdentifier id = null;
    private GeneralNames names = null;
    private SerialNumber serialNum = null;

    private void encodeThis() throws IOException {
        if (this.id == null && this.names == null && this.serialNum == null) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream seq = new DerOutputStream();
        DerOutputStream tmp = new DerOutputStream();
        if (this.id != null) {
            DerOutputStream tmp1 = new DerOutputStream();
            this.id.encode(tmp1);
            tmp.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 0), tmp1);
        }
        try {
            if (this.names != null) {
                DerOutputStream tmp12 = new DerOutputStream();
                this.names.encode(tmp12);
                tmp.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), tmp12);
            }
            if (this.serialNum != null) {
                DerOutputStream tmp13 = new DerOutputStream();
                this.serialNum.encode(tmp13);
                tmp.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 2), tmp13);
            }
            seq.write((byte) 48, tmp);
            this.extensionValue = seq.toByteArray();
        } catch (Exception e) {
            throw new IOException(e.toString());
        }
    }

    public AuthorityKeyIdentifierExtension(KeyIdentifier kid, GeneralNames name, SerialNumber sn) throws IOException {
        this.id = kid;
        this.names = name;
        this.serialNum = sn;
        this.extensionId = PKIXExtensions.AuthorityKey_Id;
        this.critical = false;
        encodeThis();
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 144 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthorityKeyIdentifierExtension(java.lang.Boolean r7, java.lang.Object r8) throws java.io.IOException {
        /*
            r6 = this;
            r5 = 48
            r4 = 2
            r3 = 0
            r2 = 0
            r6.<init>()
            r6.id = r2
            r6.names = r2
            r6.serialNum = r2
            sun.security.util.ObjectIdentifier r2 = sun.security.x509.PKIXExtensions.AuthorityKey_Id
            r6.extensionId = r2
            boolean r2 = r7.booleanValue()
            r6.critical = r2
            byte[] r8 = (byte[]) r8
            r6.extensionValue = r8
            sun.security.util.DerValue r1 = new sun.security.util.DerValue
            byte[] r2 = r6.extensionValue
            r1.<init>((byte[]) r2)
            byte r2 = r1.tag
            if (r2 == r5) goto L_0x003b
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Invalid encoding for AuthorityKeyIdentifierExtension."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0030:
            r2 = 4
            r0.resetTag(r2)
            sun.security.x509.KeyIdentifier r2 = new sun.security.x509.KeyIdentifier
            r2.<init>((sun.security.util.DerValue) r0)
            r6.id = r2
        L_0x003b:
            sun.security.util.DerInputStream r2 = r1.data
            if (r2 == 0) goto L_0x00b8
            sun.security.util.DerInputStream r2 = r1.data
            int r2 = r2.available()
            if (r2 == 0) goto L_0x00b8
            sun.security.util.DerInputStream r2 = r1.data
            sun.security.util.DerValue r0 = r2.getDerValue()
            boolean r2 = r0.isContextSpecific(r3)
            if (r2 == 0) goto L_0x0059
            boolean r2 = r0.isConstructed()
            if (r2 == 0) goto L_0x0073
        L_0x0059:
            r2 = 1
            boolean r2 = r0.isContextSpecific(r2)
            if (r2 == 0) goto L_0x008b
            boolean r2 = r0.isConstructed()
            if (r2 == 0) goto L_0x008b
            sun.security.x509.GeneralNames r2 = r6.names
            if (r2 == 0) goto L_0x0080
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate GeneralNames in AuthorityKeyIdentifier."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0073:
            sun.security.x509.KeyIdentifier r2 = r6.id
            if (r2 == 0) goto L_0x0030
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate KeyIdentifier in AuthorityKeyIdentifier."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0080:
            r0.resetTag(r5)
            sun.security.x509.GeneralNames r2 = new sun.security.x509.GeneralNames
            r2.<init>(r0)
            r6.names = r2
            goto L_0x003b
        L_0x008b:
            boolean r2 = r0.isContextSpecific(r4)
            if (r2 == 0) goto L_0x0097
            boolean r2 = r0.isConstructed()
            if (r2 == 0) goto L_0x00a0
        L_0x0097:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Invalid encoding of AuthorityKeyIdentifierExtension."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x00a0:
            sun.security.x509.SerialNumber r2 = r6.serialNum
            if (r2 == 0) goto L_0x00ad
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate SerialNumber in AuthorityKeyIdentifier."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x00ad:
            r0.resetTag(r4)
            sun.security.x509.SerialNumber r2 = new sun.security.x509.SerialNumber
            r2.<init>((sun.security.util.DerValue) r0)
            r6.serialNum = r2
            goto L_0x003b
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.AuthorityKeyIdentifierExtension.<init>(java.lang.Boolean, java.lang.Object):void");
    }

    public String toString() {
        String s = super.toString() + "AuthorityKeyIdentifier [\n";
        if (this.id != null) {
            s = s + this.id.toString();
        }
        if (this.names != null) {
            s = s + this.names.toString() + "\n";
        }
        if (this.serialNum != null) {
            s = s + this.serialNum.toString() + "\n";
        }
        return s + "]\n";
    }

    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.AuthorityKey_Id;
            this.critical = false;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase("key_id")) {
            if (!(obj instanceof KeyIdentifier)) {
                throw new IOException("Attribute value should be of type KeyIdentifier.");
            }
            this.id = (KeyIdentifier) obj;
        } else if (name.equalsIgnoreCase(AUTH_NAME)) {
            if (!(obj instanceof GeneralNames)) {
                throw new IOException("Attribute value should be of type GeneralNames.");
            }
            this.names = (GeneralNames) obj;
        } else if (!name.equalsIgnoreCase(SERIAL_NUMBER)) {
            throw new IOException("Attribute name not recognized by CertAttrSet:AuthorityKeyIdentifier.");
        } else if (!(obj instanceof SerialNumber)) {
            throw new IOException("Attribute value should be of type SerialNumber.");
        } else {
            this.serialNum = (SerialNumber) obj;
        }
        encodeThis();
    }

    public Object get(String name) throws IOException {
        if (name.equalsIgnoreCase("key_id")) {
            return this.id;
        }
        if (name.equalsIgnoreCase(AUTH_NAME)) {
            return this.names;
        }
        if (name.equalsIgnoreCase(SERIAL_NUMBER)) {
            return this.serialNum;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:AuthorityKeyIdentifier.");
    }

    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase("key_id")) {
            this.id = null;
        } else if (name.equalsIgnoreCase(AUTH_NAME)) {
            this.names = null;
        } else if (name.equalsIgnoreCase(SERIAL_NUMBER)) {
            this.serialNum = null;
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:AuthorityKeyIdentifier.");
        }
        encodeThis();
    }

    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement("key_id");
        elements.addElement(AUTH_NAME);
        elements.addElement(SERIAL_NUMBER);
        return elements.elements();
    }

    public String getName() {
        return NAME;
    }
}
