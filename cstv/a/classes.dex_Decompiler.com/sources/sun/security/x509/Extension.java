package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

public class Extension implements java.security.cert.Extension {
    private static final int hashMagic = 31;
    protected boolean critical = false;
    protected ObjectIdentifier extensionId = null;
    protected byte[] extensionValue = null;

    public Extension() {
    }

    public Extension(DerValue derVal) throws IOException {
        DerInputStream in = derVal.toDerInputStream();
        this.extensionId = in.getOID();
        DerValue val = in.getDerValue();
        if (val.tag == 1) {
            this.critical = val.getBoolean();
            this.extensionValue = in.getDerValue().getOctetString();
            return;
        }
        this.critical = false;
        this.extensionValue = val.getOctetString();
    }

    public Extension(ObjectIdentifier extensionId2, boolean critical2, byte[] extensionValue2) throws IOException {
        this.extensionId = extensionId2;
        this.critical = critical2;
        this.extensionValue = new DerValue(extensionValue2).getOctetString();
    }

    public Extension(Extension ext) {
        this.extensionId = ext.extensionId;
        this.critical = ext.critical;
        this.extensionValue = ext.extensionValue;
    }

    public static Extension newExtension(ObjectIdentifier extensionId2, boolean critical2, byte[] rawExtensionValue) throws IOException {
        Extension ext = new Extension();
        ext.extensionId = extensionId2;
        ext.critical = critical2;
        ext.extensionValue = rawExtensionValue;
        return ext;
    }

    public void encode(OutputStream out) throws IOException {
        if (out == null) {
            throw new NullPointerException();
        }
        DerOutputStream dos1 = new DerOutputStream();
        DerOutputStream dos2 = new DerOutputStream();
        dos1.putOID(this.extensionId);
        if (this.critical) {
            dos1.putBoolean(this.critical);
        }
        dos1.putOctetString(this.extensionValue);
        dos2.write((byte) 48, dos1);
        out.write(dos2.toByteArray());
    }

    public void encode(DerOutputStream out) throws IOException {
        if (this.extensionId == null) {
            throw new IOException("Null OID to encode for the extension!");
        } else if (this.extensionValue == null) {
            throw new IOException("No value to encode for the extension!");
        } else {
            DerOutputStream dos = new DerOutputStream();
            dos.putOID(this.extensionId);
            if (this.critical) {
                dos.putBoolean(this.critical);
            }
            dos.putOctetString(this.extensionValue);
            out.write((byte) 48, dos);
        }
    }

    public boolean isCritical() {
        return this.critical;
    }

    public ObjectIdentifier getExtensionId() {
        return this.extensionId;
    }

    public byte[] getValue() {
        return (byte[]) this.extensionValue.clone();
    }

    public byte[] getExtensionValue() {
        return this.extensionValue;
    }

    public String getId() {
        return this.extensionId.toString();
    }

    public String toString() {
        String s = "ObjectId: " + this.extensionId.toString();
        if (this.critical) {
            return s + " Criticality=true\n";
        }
        return s + " Criticality=false\n";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r6 = this;
            r0 = 0
            byte[] r4 = r6.extensionValue
            if (r4 == 0) goto L_0x0013
            byte[] r3 = r6.extensionValue
            int r1 = r3.length
            r2 = r1
        L_0x0009:
            if (r2 <= 0) goto L_0x0013
            int r1 = r2 + -1
            byte r4 = r3[r1]
            int r4 = r4 * r2
            int r0 = r0 + r4
            r2 = r1
            goto L_0x0009
        L_0x0013:
            int r4 = r0 * 31
            sun.security.util.ObjectIdentifier r5 = r6.extensionId
            int r5 = r5.hashCode()
            int r0 = r4 + r5
            int r5 = r0 * 31
            boolean r4 = r6.critical
            if (r4 == 0) goto L_0x0028
            r4 = 1231(0x4cf, float:1.725E-42)
        L_0x0025:
            int r0 = r5 + r4
            return r0
        L_0x0028:
            r4 = 1237(0x4d5, float:1.733E-42)
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.Extension.hashCode():int");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Extension)) {
            return false;
        }
        Extension otherExt = (Extension) other;
        if (this.critical == otherExt.critical && this.extensionId.equals((Object) otherExt.extensionId)) {
            return Arrays.equals(this.extensionValue, otherExt.extensionValue);
        }
        return false;
    }
}
