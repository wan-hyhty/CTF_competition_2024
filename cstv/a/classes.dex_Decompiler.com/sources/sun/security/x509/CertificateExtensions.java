package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import sun.misc.HexDumpEncoder;
import sun.security.util.Debug;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

public class CertificateExtensions implements CertAttrSet<Extension> {
    public static final String IDENT = "x509.info.extensions";
    public static final String NAME = "extensions";
    private static Class[] PARAMS;
    private static final Debug debug = null;
    private Map<String, Extension> map = Collections.synchronizedMap(new TreeMap());
    private Map<String, Extension> unparseableExtensions;
    private boolean unsupportedCritExt = false;

    public CertificateExtensions() {
    }

    public CertificateExtensions(DerInputStream in) throws IOException {
        init(in);
    }

    private void init(DerInputStream in) throws IOException {
        DerValue[] exts = in.getSequence(5);
        for (DerValue extension : exts) {
            parseExtension(new Extension(extension));
        }
    }

    private void parseExtension(Extension ext) throws IOException {
        try {
            Class extClass = OIDMap.getClass(ext.getExtensionId());
            if (extClass == null) {
                if (ext.isCritical()) {
                    this.unsupportedCritExt = true;
                }
                if (this.map.put(ext.getExtensionId().toString(), ext) != null) {
                    throw new IOException("Duplicate extensions not allowed");
                }
                return;
            }
            CertAttrSet certExt = (CertAttrSet) extClass.getConstructor(PARAMS).newInstance(Boolean.valueOf(ext.isCritical()), ext.getExtensionValue());
            if (this.map.put(certExt.getName(), (Extension) certExt) != null) {
                throw new IOException("Duplicate extensions not allowed");
            }
        } catch (InvocationTargetException invk) {
            Throwable e = invk.getTargetException();
            if (!ext.isCritical()) {
                if (this.unparseableExtensions == null) {
                    this.unparseableExtensions = new TreeMap();
                }
                this.unparseableExtensions.put(ext.getExtensionId().toString(), new UnparseableExtension(ext, e));
                if (debug != null) {
                    debug.println("Error parsing extension: " + ext);
                    e.printStackTrace();
                    System.err.println(new HexDumpEncoder().encodeBuffer(ext.getExtensionValue()));
                }
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw ((IOException) new IOException(e.toString()).initCause(e));
            }
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            throw ((IOException) new IOException(e3.toString()).initCause(e3));
        }
    }

    public void encode(OutputStream out) throws CertificateException, IOException {
        encode(out, false);
    }

    public void encode(OutputStream out, boolean isCertReq) throws CertificateException, IOException {
        DerOutputStream tmp;
        DerOutputStream extOut = new DerOutputStream();
        Object[] objs = this.map.values().toArray();
        for (int i = 0; i < objs.length; i++) {
            if (objs[i] instanceof CertAttrSet) {
                ((CertAttrSet) objs[i]).encode(extOut);
            } else if (objs[i] instanceof Extension) {
                ((Extension) objs[i]).encode(extOut);
            } else {
                throw new CertificateException("Illegal extension object");
            }
        }
        DerOutputStream seq = new DerOutputStream();
        seq.write((byte) 48, extOut);
        if (!isCertReq) {
            tmp = new DerOutputStream();
            tmp.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 3), seq);
        } else {
            tmp = seq;
        }
        out.write(tmp.toByteArray());
    }

    public void set(String name, Object obj) throws IOException {
        if (obj instanceof Extension) {
            this.map.put(name, (Extension) obj);
            return;
        }
        throw new IOException("Unknown extension type.");
    }

    public Object get(String name) throws IOException {
        Object obj = this.map.get(name);
        if (obj != null) {
            return obj;
        }
        throw new IOException("No extension found with name " + name);
    }

    /* access modifiers changed from: package-private */
    public Extension getExtension(String name) {
        return this.map.get(name);
    }

    public void delete(String name) throws IOException {
        if (this.map.get(name) == null) {
            throw new IOException("No extension found with name " + name);
        }
        this.map.remove(name);
    }

    public String getNameByOid(ObjectIdentifier oid) throws IOException {
        for (String name : this.map.keySet()) {
            if (this.map.get(name).getExtensionId().equals(oid)) {
                return name;
            }
        }
        return null;
    }

    public Enumeration<Extension> getElements() {
        return Collections.enumeration(this.map.values());
    }

    public Collection<Extension> getAllExtensions() {
        return this.map.values();
    }

    public Map<String, Extension> getUnparseableExtensions() {
        if (this.unparseableExtensions == null) {
            return Collections.emptyMap();
        }
        return this.unparseableExtensions;
    }

    public String getName() {
        return "extensions";
    }

    public boolean hasUnsupportedCriticalExtension() {
        return this.unsupportedCritExt;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r3 = ((sun.security.x509.CertificateExtensions) r10).getAllExtensions().toArray();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r10) {
        /*
            r9 = this;
            r8 = 0
            if (r9 != r10) goto L_0x0005
            r7 = 1
            return r7
        L_0x0005:
            boolean r7 = r10 instanceof sun.security.x509.CertificateExtensions
            if (r7 != 0) goto L_0x000a
            return r8
        L_0x000a:
            r7 = r10
            sun.security.x509.CertificateExtensions r7 = (sun.security.x509.CertificateExtensions) r7
            java.util.Collection r4 = r7.getAllExtensions()
            java.lang.Object[] r3 = r4.toArray()
            int r2 = r3.length
            java.util.Map<java.lang.String, sun.security.x509.Extension> r7 = r9.map
            int r7 = r7.size()
            if (r2 == r7) goto L_0x001f
            return r8
        L_0x001f:
            r1 = 0
            r0 = 0
        L_0x0021:
            if (r0 >= r2) goto L_0x0054
            r7 = r3[r0]
            boolean r7 = r7 instanceof sun.security.x509.CertAttrSet
            if (r7 == 0) goto L_0x0031
            r7 = r3[r0]
            sun.security.x509.CertAttrSet r7 = (sun.security.x509.CertAttrSet) r7
            java.lang.String r1 = r7.getName()
        L_0x0031:
            r5 = r3[r0]
            sun.security.x509.Extension r5 = (sun.security.x509.Extension) r5
            if (r1 != 0) goto L_0x003f
            sun.security.util.ObjectIdentifier r7 = r5.getExtensionId()
            java.lang.String r1 = r7.toString()
        L_0x003f:
            java.util.Map<java.lang.String, sun.security.x509.Extension> r7 = r9.map
            java.lang.Object r6 = r7.get(r1)
            sun.security.x509.Extension r6 = (sun.security.x509.Extension) r6
            if (r6 != 0) goto L_0x004a
            return r8
        L_0x004a:
            boolean r7 = r6.equals(r5)
            if (r7 != 0) goto L_0x0051
            return r8
        L_0x0051:
            int r0 = r0 + 1
            goto L_0x0021
        L_0x0054:
            java.util.Map r7 = r9.getUnparseableExtensions()
            sun.security.x509.CertificateExtensions r10 = (sun.security.x509.CertificateExtensions) r10
            java.util.Map r8 = r10.getUnparseableExtensions()
            boolean r7 = r7.equals(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.x509.CertificateExtensions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return this.map.hashCode() + getUnparseableExtensions().hashCode();
    }

    public String toString() {
        return this.map.toString();
    }
}
