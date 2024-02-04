package sun.security.x509;

import java.io.IOException;
import java.util.Arrays;
import sun.security.util.BitArray;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

public class DistributionPoint {
    public static final int AA_COMPROMISE = 8;
    public static final int AFFILIATION_CHANGED = 3;
    public static final int CA_COMPROMISE = 2;
    public static final int CERTIFICATE_HOLD = 6;
    public static final int CESSATION_OF_OPERATION = 5;
    public static final int KEY_COMPROMISE = 1;
    public static final int PRIVILEGE_WITHDRAWN = 7;
    private static final String[] REASON_STRINGS = null;
    public static final int SUPERSEDED = 4;
    private static final byte TAG_DIST_PT = 0;
    private static final byte TAG_FULL_NAME = 0;
    private static final byte TAG_ISSUER = 2;
    private static final byte TAG_REASONS = 1;
    private static final byte TAG_REL_NAME = 1;
    private GeneralNames crlIssuer;
    private GeneralNames fullName;
    private volatile int hashCode;
    private boolean[] reasonFlags;
    private RDN relativeName;

    public DistributionPoint(GeneralNames fullName2, boolean[] reasonFlags2, GeneralNames crlIssuer2) {
        if (fullName2 == null && crlIssuer2 == null) {
            throw new IllegalArgumentException("fullName and crlIssuer may not both be null");
        }
        this.fullName = fullName2;
        this.reasonFlags = reasonFlags2;
        this.crlIssuer = crlIssuer2;
    }

    public DistributionPoint(RDN relativeName2, boolean[] reasonFlags2, GeneralNames crlIssuer2) {
        if (relativeName2 == null && crlIssuer2 == null) {
            throw new IllegalArgumentException("relativeName and crlIssuer may not both be null");
        }
        this.relativeName = relativeName2;
        this.reasonFlags = reasonFlags2;
        this.crlIssuer = crlIssuer2;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 168 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DistributionPoint(sun.security.util.DerValue r7) throws java.io.IOException {
        /*
            r6 = this;
            r5 = 1
            r4 = 48
            r3 = 0
            r6.<init>()
            byte r2 = r7.tag
            if (r2 == r4) goto L_0x0030
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Invalid encoding of DistributionPoint."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0014:
            sun.security.util.DerInputStream r2 = r1.data
            sun.security.util.DerValue r0 = r2.getDerValue()
            boolean r2 = r0.isContextSpecific(r3)
            if (r2 == 0) goto L_0x005f
            boolean r2 = r0.isConstructed()
            if (r2 == 0) goto L_0x005f
            r0.resetTag(r4)
            sun.security.x509.GeneralNames r2 = new sun.security.x509.GeneralNames
            r2.<init>(r0)
            r6.fullName = r2
        L_0x0030:
            sun.security.util.DerInputStream r2 = r7.data
            if (r2 == 0) goto L_0x00d9
            sun.security.util.DerInputStream r2 = r7.data
            int r2 = r2.available()
            if (r2 == 0) goto L_0x00d9
            sun.security.util.DerInputStream r2 = r7.data
            sun.security.util.DerValue r1 = r2.getDerValue()
            boolean r2 = r1.isContextSpecific(r3)
            if (r2 == 0) goto L_0x0081
            boolean r2 = r1.isConstructed()
            if (r2 == 0) goto L_0x0081
            sun.security.x509.GeneralNames r2 = r6.fullName
            if (r2 != 0) goto L_0x0056
            sun.security.x509.RDN r2 = r6.relativeName
            if (r2 == 0) goto L_0x0014
        L_0x0056:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate DistributionPointName in DistributionPoint."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x005f:
            boolean r2 = r0.isContextSpecific(r5)
            if (r2 == 0) goto L_0x0078
            boolean r2 = r0.isConstructed()
            if (r2 == 0) goto L_0x0078
            r2 = 49
            r0.resetTag(r2)
            sun.security.x509.RDN r2 = new sun.security.x509.RDN
            r2.<init>((sun.security.util.DerValue) r0)
            r6.relativeName = r2
            goto L_0x0030
        L_0x0078:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Invalid DistributionPointName in DistributionPoint"
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0081:
            boolean r2 = r1.isContextSpecific(r5)
            if (r2 == 0) goto L_0x008d
            boolean r2 = r1.isConstructed()
            if (r2 == 0) goto L_0x00a7
        L_0x008d:
            r2 = 2
            boolean r2 = r1.isContextSpecific(r2)
            if (r2 == 0) goto L_0x00d0
            boolean r2 = r1.isConstructed()
            if (r2 == 0) goto L_0x00d0
            sun.security.x509.GeneralNames r2 = r6.crlIssuer
            if (r2 == 0) goto L_0x00c4
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate CRLIssuer in DistributionPoint."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x00a7:
            boolean[] r2 = r6.reasonFlags
            if (r2 == 0) goto L_0x00b4
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Duplicate Reasons in DistributionPoint."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x00b4:
            r2 = 3
            r1.resetTag(r2)
            sun.security.util.BitArray r2 = r1.getUnalignedBitString()
            boolean[] r2 = r2.toBooleanArray()
            r6.reasonFlags = r2
            goto L_0x0030
        L_0x00c4:
            r1.resetTag(r4)
            sun.security.x509.GeneralNames r2 = new sun.security.x509.GeneralNames
            r2.<init>(r1)
            r6.crlIssuer = r2
            goto L_0x0030
        L_0x00d0:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Invalid encoding of DistributionPoint."
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x00d9:
            sun.security.x509.GeneralNames r2 = r6.crlIssuer
            if (r2 != 0) goto L_0x00ee
            sun.security.x509.GeneralNames r2 = r6.fullName
            if (r2 != 0) goto L_0x00ee
            sun.security.x509.RDN r2 = r6.relativeName
            if (r2 != 0) goto L_0x00ee
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "One of fullName, relativeName,  and crlIssuer has to be set"
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.DistributionPoint.<init>(sun.security.util.DerValue):void");
    }

    public GeneralNames getFullName() {
        return this.fullName;
    }

    public RDN getRelativeName() {
        return this.relativeName;
    }

    public boolean[] getReasonFlags() {
        return this.reasonFlags;
    }

    public GeneralNames getCRLIssuer() {
        return this.crlIssuer;
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tagged = new DerOutputStream();
        if (!(this.fullName == null && this.relativeName == null)) {
            DerOutputStream distributionPoint = new DerOutputStream();
            if (this.fullName != null) {
                DerOutputStream derOut = new DerOutputStream();
                this.fullName.encode(derOut);
                distributionPoint.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), derOut);
            } else if (this.relativeName != null) {
                DerOutputStream derOut2 = new DerOutputStream();
                this.relativeName.encode(derOut2);
                distributionPoint.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), derOut2);
            }
            tagged.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), distributionPoint);
        }
        if (this.reasonFlags != null) {
            DerOutputStream reasons = new DerOutputStream();
            reasons.putTruncatedUnalignedBitString(new BitArray(this.reasonFlags));
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 1), reasons);
        }
        if (this.crlIssuer != null) {
            DerOutputStream issuer = new DerOutputStream();
            this.crlIssuer.encode(issuer);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 2), issuer);
        }
        out.write((byte) 48, tagged);
    }

    private static boolean equals(Object a, Object b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DistributionPoint)) {
            return false;
        }
        DistributionPoint other = (DistributionPoint) obj;
        if (!equals(this.fullName, other.fullName) || !equals(this.relativeName, other.relativeName) || !equals(this.crlIssuer, other.crlIssuer)) {
            return false;
        }
        return Arrays.equals(this.reasonFlags, other.reasonFlags);
    }

    public int hashCode() {
        int hash = this.hashCode;
        if (hash == 0) {
            hash = 1;
            if (this.fullName != null) {
                hash = this.fullName.hashCode() + 1;
            }
            if (this.relativeName != null) {
                hash += this.relativeName.hashCode();
            }
            if (this.crlIssuer != null) {
                hash += this.crlIssuer.hashCode();
            }
            if (this.reasonFlags != null) {
                for (int i = 0; i < this.reasonFlags.length; i++) {
                    if (this.reasonFlags[i]) {
                        hash += i;
                    }
                }
            }
            this.hashCode = hash;
        }
        return hash;
    }

    private static String reasonToString(int reason) {
        if (reason <= 0 || reason >= REASON_STRINGS.length) {
            return "Unknown reason " + reason;
        }
        return REASON_STRINGS[reason];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.fullName != null) {
            sb.append("DistributionPoint:\n     ").append((Object) this.fullName).append("\n");
        }
        if (this.relativeName != null) {
            sb.append("DistributionPoint:\n     ").append((Object) this.relativeName).append("\n");
        }
        if (this.reasonFlags != null) {
            sb.append("   ReasonFlags:\n");
            for (int i = 0; i < this.reasonFlags.length; i++) {
                if (this.reasonFlags[i]) {
                    sb.append("    ").append(reasonToString(i)).append("\n");
                }
            }
        }
        if (this.crlIssuer != null) {
            sb.append("   CRLIssuer:").append((Object) this.crlIssuer).append("\n");
        }
        return sb.toString();
    }
}
