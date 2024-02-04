package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import sun.security.pkcs.PKCS9Attribute;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

public class NameConstraintsExtension extends Extension implements CertAttrSet<String>, Cloneable {
    public static final String EXCLUDED_SUBTREES = "excluded_subtrees";
    public static final String IDENT = "x509.info.extensions.NameConstraints";
    public static final String NAME = "NameConstraints";
    public static final String PERMITTED_SUBTREES = "permitted_subtrees";
    private static final byte TAG_EXCLUDED = 1;
    private static final byte TAG_PERMITTED = 0;
    private GeneralSubtrees excluded = null;
    private boolean hasMax;
    private boolean hasMin;
    private boolean minMaxValid = false;
    private GeneralSubtrees permitted = null;

    private void calcMinMax() throws IOException {
        this.hasMin = false;
        this.hasMax = false;
        if (this.excluded != null) {
            for (int i = 0; i < this.excluded.size(); i++) {
                GeneralSubtree subtree = this.excluded.get(i);
                if (subtree.getMinimum() != 0) {
                    this.hasMin = true;
                }
                if (subtree.getMaximum() != -1) {
                    this.hasMax = true;
                }
            }
        }
        if (this.permitted != null) {
            for (int i2 = 0; i2 < this.permitted.size(); i2++) {
                GeneralSubtree subtree2 = this.permitted.get(i2);
                if (subtree2.getMinimum() != 0) {
                    this.hasMin = true;
                }
                if (subtree2.getMaximum() != -1) {
                    this.hasMax = true;
                }
            }
        }
        this.minMaxValid = true;
    }

    private void encodeThis() throws IOException {
        this.minMaxValid = false;
        if (this.permitted == null && this.excluded == null) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream seq = new DerOutputStream();
        DerOutputStream tagged = new DerOutputStream();
        if (this.permitted != null) {
            DerOutputStream tmp = new DerOutputStream();
            this.permitted.encode(tmp);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), tmp);
        }
        if (this.excluded != null) {
            DerOutputStream tmp2 = new DerOutputStream();
            this.excluded.encode(tmp2);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), tmp2);
        }
        seq.write((byte) 48, tagged);
        this.extensionValue = seq.toByteArray();
    }

    public NameConstraintsExtension(GeneralSubtrees permitted2, GeneralSubtrees excluded2) throws IOException {
        this.permitted = permitted2;
        this.excluded = excluded2;
        this.extensionId = PKIXExtensions.NameConstraints_Id;
        this.critical = true;
        encodeThis();
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 136 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NameConstraintsExtension(java.lang.Boolean r6, java.lang.Object r7) throws java.io.IOException {
        /*
            r5 = this;
            r4 = 48
            r3 = 0
            r2 = 0
            r5.<init>()
            r5.permitted = r2
            r5.excluded = r2
            r5.minMaxValid = r3
            sun.security.util.ObjectIdentifier r2 = sun.security.x509.PKIXExtensions.NameConstraints_Id
            r5.extensionId = r2
            boolean r2 = r6.booleanValue()
            r5.critical = r2
            byte[] r7 = (byte[]) r7
            r5.extensionValue = r7
            sun.security.util.DerValue r1 = new sun.security.util.DerValue
            byte[] r2 = r5.extensionValue
            r1.<init>((byte[]) r2)
            byte r2 = r1.tag
            if (r2 == r4) goto L_0x002f
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Invalid encoding for NameConstraintsExtension."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x002f:
            sun.security.util.DerInputStream r2 = r1.data
            if (r2 != 0) goto L_0x003e
            return
        L_0x0034:
            r0.resetTag(r4)
            sun.security.x509.GeneralSubtrees r2 = new sun.security.x509.GeneralSubtrees
            r2.<init>((sun.security.util.DerValue) r0)
            r5.permitted = r2
        L_0x003e:
            sun.security.util.DerInputStream r2 = r1.data
            int r2 = r2.available()
            if (r2 == 0) goto L_0x0093
            sun.security.util.DerInputStream r2 = r1.data
            sun.security.util.DerValue r0 = r2.getDerValue()
            boolean r2 = r0.isContextSpecific(r3)
            if (r2 == 0) goto L_0x0065
            boolean r2 = r0.isConstructed()
            if (r2 == 0) goto L_0x0065
            sun.security.x509.GeneralSubtrees r2 = r5.permitted
            if (r2 == 0) goto L_0x0034
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate permitted GeneralSubtrees in NameConstraintsExtension."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0065:
            r2 = 1
            boolean r2 = r0.isContextSpecific(r2)
            if (r2 == 0) goto L_0x008a
            boolean r2 = r0.isConstructed()
            if (r2 == 0) goto L_0x008a
            sun.security.x509.GeneralSubtrees r2 = r5.excluded
            if (r2 == 0) goto L_0x007f
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate excluded GeneralSubtrees in NameConstraintsExtension."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x007f:
            r0.resetTag(r4)
            sun.security.x509.GeneralSubtrees r2 = new sun.security.x509.GeneralSubtrees
            r2.<init>((sun.security.util.DerValue) r0)
            r5.excluded = r2
            goto L_0x003e
        L_0x008a:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Invalid encoding of NameConstraintsExtension."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0093:
            r5.minMaxValid = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.NameConstraintsExtension.<init>(java.lang.Boolean, java.lang.Object):void");
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder append = new StringBuilder().append(super.toString()).append("NameConstraints: [");
        if (this.permitted == null) {
            str = "";
        } else {
            str = "\n    Permitted:" + this.permitted.toString();
        }
        StringBuilder append2 = append.append(str);
        if (this.excluded == null) {
            str2 = "";
        } else {
            str2 = "\n    Excluded:" + this.excluded.toString();
        }
        return append2.append(str2).append("   ]\n").toString();
    }

    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = PKIXExtensions.NameConstraints_Id;
            this.critical = true;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase(PERMITTED_SUBTREES)) {
            if (!(obj instanceof GeneralSubtrees)) {
                throw new IOException("Attribute value should be of type GeneralSubtrees.");
            }
            this.permitted = (GeneralSubtrees) obj;
        } else if (!name.equalsIgnoreCase(EXCLUDED_SUBTREES)) {
            throw new IOException("Attribute name not recognized by CertAttrSet:NameConstraintsExtension.");
        } else if (!(obj instanceof GeneralSubtrees)) {
            throw new IOException("Attribute value should be of type GeneralSubtrees.");
        } else {
            this.excluded = (GeneralSubtrees) obj;
        }
        encodeThis();
    }

    public GeneralSubtrees get(String name) throws IOException {
        if (name.equalsIgnoreCase(PERMITTED_SUBTREES)) {
            return this.permitted;
        }
        if (name.equalsIgnoreCase(EXCLUDED_SUBTREES)) {
            return this.excluded;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:NameConstraintsExtension.");
    }

    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(PERMITTED_SUBTREES)) {
            this.permitted = null;
        } else if (name.equalsIgnoreCase(EXCLUDED_SUBTREES)) {
            this.excluded = null;
        } else {
            throw new IOException("Attribute name not recognized by CertAttrSet:NameConstraintsExtension.");
        }
        encodeThis();
    }

    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(PERMITTED_SUBTREES);
        elements.addElement(EXCLUDED_SUBTREES);
        return elements.elements();
    }

    public String getName() {
        return NAME;
    }

    public void merge(NameConstraintsExtension newConstraints) throws IOException {
        GeneralSubtrees newExcluded;
        GeneralSubtrees generalSubtrees;
        GeneralSubtrees generalSubtrees2;
        if (newConstraints != null) {
            GeneralSubtrees newExcluded2 = newConstraints.get(EXCLUDED_SUBTREES);
            if (this.excluded == null) {
                if (newExcluded2 != null) {
                    generalSubtrees2 = (GeneralSubtrees) newExcluded2.clone();
                } else {
                    generalSubtrees2 = null;
                }
                this.excluded = generalSubtrees2;
            } else if (newExcluded2 != null) {
                this.excluded.union(newExcluded2);
            }
            GeneralSubtrees newPermitted = newConstraints.get(PERMITTED_SUBTREES);
            if (this.permitted == null) {
                if (newPermitted != null) {
                    generalSubtrees = (GeneralSubtrees) newPermitted.clone();
                } else {
                    generalSubtrees = null;
                }
                this.permitted = generalSubtrees;
            } else if (!(newPermitted == null || (newExcluded = this.permitted.intersect(newPermitted)) == null)) {
                if (this.excluded != null) {
                    this.excluded.union(newExcluded);
                } else {
                    this.excluded = (GeneralSubtrees) newExcluded.clone();
                }
            }
            if (this.permitted != null) {
                this.permitted.reduce(this.excluded);
            }
            encodeThis();
        }
    }

    public boolean verify(X509Certificate cert) throws IOException {
        if (cert == null) {
            throw new IOException("Certificate is null");
        }
        if (!this.minMaxValid) {
            calcMinMax();
        }
        if (this.hasMin) {
            throw new IOException("Non-zero minimum BaseDistance in name constraints not supported");
        } else if (this.hasMax) {
            throw new IOException("Maximum BaseDistance in name constraints not supported");
        } else {
            X500Name subject = X500Name.asX500Name(cert.getSubjectX500Principal());
            if (!subject.isEmpty() && !verify((GeneralNameInterface) subject)) {
                return false;
            }
            GeneralNames altNames = null;
            try {
                SubjectAlternativeNameExtension altNameExt = X509CertImpl.toImpl(cert).getSubjectAlternativeNameExtension();
                if (altNameExt != null) {
                    altNames = altNameExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME);
                }
                if (altNames == null) {
                    return verifyRFC822SpecialCase(subject);
                }
                for (int i = 0; i < altNames.size(); i++) {
                    if (!verify(altNames.get(i).getName())) {
                        return false;
                    }
                }
                return true;
            } catch (CertificateException ce) {
                throw new IOException("Unable to extract extensions from certificate: " + ce.getMessage());
            }
        }
    }

    public boolean verify(GeneralNameInterface name) throws IOException {
        GeneralName gn;
        GeneralNameInterface perName;
        GeneralName gn2;
        GeneralNameInterface exName;
        if (name == null) {
            throw new IOException("name is null");
        }
        if (this.excluded != null && this.excluded.size() > 0) {
            for (int i = 0; i < this.excluded.size(); i++) {
                GeneralSubtree gs = this.excluded.get(i);
                if (!(gs == null || (gn2 = gs.getName()) == null || (exName = gn2.getName()) == null)) {
                    switch (exName.constrains(name)) {
                        case 0:
                        case 1:
                            return false;
                    }
                }
            }
        }
        if (this.permitted != null && this.permitted.size() > 0) {
            boolean sameType = false;
            for (int i2 = 0; i2 < this.permitted.size(); i2++) {
                GeneralSubtree gs2 = this.permitted.get(i2);
                if (!(gs2 == null || (gn = gs2.getName()) == null || (perName = gn.getName()) == null)) {
                    switch (perName.constrains(name)) {
                        case 0:
                        case 1:
                            return true;
                        case 2:
                        case 3:
                            sameType = true;
                            break;
                    }
                }
            }
            if (sameType) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyRFC822SpecialCase(X500Name subject) throws IOException {
        String attrValue;
        for (AVA ava : subject.allAvas()) {
            if (ava.getObjectIdentifier().equals((Object) PKCS9Attribute.EMAIL_ADDRESS_OID) && (attrValue = ava.getValueString()) != null) {
                try {
                    if (!verify((GeneralNameInterface) new RFC822Name(attrValue))) {
                        return false;
                    }
                } catch (IOException e) {
                }
            }
        }
        return true;
    }

    public Object clone() {
        try {
            NameConstraintsExtension newNCE = (NameConstraintsExtension) super.clone();
            if (this.permitted != null) {
                newNCE.permitted = (GeneralSubtrees) this.permitted.clone();
            }
            if (this.excluded != null) {
                newNCE.excluded = (GeneralSubtrees) this.excluded.clone();
            }
            return newNCE;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("CloneNotSupportedException while cloning NameConstraintsException. This should never happen.");
        }
    }
}
