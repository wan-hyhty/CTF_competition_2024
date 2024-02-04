package sun.security.x509;

import java.io.IOException;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

public final class AccessDescription {
    public static final ObjectIdentifier Ad_CAISSUERS_Id = null;
    public static final ObjectIdentifier Ad_CAREPOSITORY_Id = null;
    public static final ObjectIdentifier Ad_OCSP_Id = null;
    public static final ObjectIdentifier Ad_TIMESTAMPING_Id = null;
    private GeneralName accessLocation;
    private ObjectIdentifier accessMethod;
    private int myhash = -1;

    public AccessDescription(ObjectIdentifier accessMethod2, GeneralName accessLocation2) {
        this.accessMethod = accessMethod2;
        this.accessLocation = accessLocation2;
    }

    public AccessDescription(DerValue derValue) throws IOException {
        DerInputStream derIn = derValue.getData();
        this.accessMethod = derIn.getOID();
        this.accessLocation = new GeneralName(derIn.getDerValue());
    }

    public ObjectIdentifier getAccessMethod() {
        return this.accessMethod;
    }

    public GeneralName getAccessLocation() {
        return this.accessLocation;
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        tmp.putOID(this.accessMethod);
        this.accessLocation.encode(tmp);
        out.write((byte) 48, tmp);
    }

    public int hashCode() {
        if (this.myhash == -1) {
            this.myhash = this.accessMethod.hashCode() + this.accessLocation.hashCode();
        }
        return this.myhash;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AccessDescription)) {
            return false;
        }
        AccessDescription that = (AccessDescription) obj;
        if (this == that) {
            return true;
        }
        if (this.accessMethod.equals(that.getAccessMethod())) {
            return this.accessLocation.equals(that.getAccessLocation());
        }
        return false;
    }

    public String toString() {
        String method;
        if (this.accessMethod.equals(Ad_CAISSUERS_Id)) {
            method = "caIssuers";
        } else if (this.accessMethod.equals(Ad_CAREPOSITORY_Id)) {
            method = "caRepository";
        } else if (this.accessMethod.equals(Ad_TIMESTAMPING_Id)) {
            method = "timeStamping";
        } else if (this.accessMethod.equals(Ad_OCSP_Id)) {
            method = "ocsp";
        } else {
            method = this.accessMethod.toString();
        }
        return "\n   accessMethod: " + method + "\n   accessLocation: " + this.accessLocation.toString() + "\n";
    }
}
