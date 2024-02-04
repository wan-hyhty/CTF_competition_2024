package sun.security.provider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import sun.misc.BASE64Decoder;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.ParsingException;
import sun.security.provider.certpath.X509CertPath;
import sun.security.provider.certpath.X509CertificatePair;
import sun.security.util.Cache;
import sun.security.x509.X509CRLImpl;
import sun.security.x509.X509CertImpl;
import sun.util.locale.LanguageTag;

public class X509Factory extends CertificateFactorySpi {
    public static final String BEGIN_CERT = "-----BEGIN CERTIFICATE-----";
    private static final int ENC_MAX_LENGTH = 4194304;
    public static final String END_CERT = "-----END CERTIFICATE-----";
    private static final Cache certCache = null;
    private static final Cache crlCache = null;

    public Certificate engineGenerateCertificate(InputStream is) throws CertificateException {
        if (is == null) {
            certCache.clear();
            X509CertificatePair.clearCache();
            throw new CertificateException("Missing input stream");
        }
        try {
            byte[] encoding = readOneBlock(is);
            if (encoding != null) {
                X509CertImpl cert = (X509CertImpl) getFromCache(certCache, encoding);
                if (cert != null) {
                    return cert;
                }
                X509CertImpl cert2 = new X509CertImpl(encoding);
                addToCache(certCache, cert2.getEncodedInternal(), cert2);
                return cert2;
            }
            throw new IOException("Empty input");
        } catch (IOException ioe) {
            throw ((CertificateException) new CertificateException("Could not parse certificate: " + ioe.toString()).initCause(ioe));
        }
    }

    private static int readFully(InputStream in, ByteArrayOutputStream bout, int length) throws IOException {
        int read = 0;
        byte[] buffer = new byte[2048];
        while (length > 0) {
            int n = in.read(buffer, 0, length < 2048 ? length : 2048);
            if (n <= 0) {
                break;
            }
            bout.write(buffer, 0, n);
            read += n;
            length -= n;
        }
        return read;
    }

    public static synchronized X509CertImpl intern(X509Certificate c) throws CertificateException {
        byte[] encoding;
        X509CertImpl newC;
        synchronized (X509Factory.class) {
            if (c == null) {
                return null;
            }
            boolean isImpl = c instanceof X509CertImpl;
            if (isImpl) {
                encoding = ((X509CertImpl) c).getEncodedInternal();
            } else {
                encoding = c.getEncoded();
            }
            X509CertImpl newC2 = (X509CertImpl) getFromCache(certCache, encoding);
            if (newC2 != null) {
                return newC2;
            }
            if (isImpl) {
                newC = (X509CertImpl) c;
            } else {
                newC = new X509CertImpl(encoding);
                encoding = newC.getEncodedInternal();
            }
            addToCache(certCache, encoding, newC);
            return newC;
        }
    }

    public static synchronized X509CRLImpl intern(X509CRL c) throws CRLException {
        byte[] encoding;
        X509CRLImpl newC;
        synchronized (X509Factory.class) {
            if (c == null) {
                return null;
            }
            boolean isImpl = c instanceof X509CRLImpl;
            if (isImpl) {
                encoding = ((X509CRLImpl) c).getEncodedInternal();
            } else {
                encoding = c.getEncoded();
            }
            X509CRLImpl newC2 = (X509CRLImpl) getFromCache(crlCache, encoding);
            if (newC2 != null) {
                return newC2;
            }
            if (isImpl) {
                newC = (X509CRLImpl) c;
            } else {
                newC = new X509CRLImpl(encoding);
                encoding = newC.getEncodedInternal();
            }
            addToCache(crlCache, encoding, newC);
            return newC;
        }
    }

    private static synchronized Object getFromCache(Cache cache, byte[] encoding) {
        Object value;
        synchronized (X509Factory.class) {
            value = cache.get(new Cache.EqualByteArray(encoding));
        }
        return value;
    }

    private static synchronized void addToCache(Cache cache, byte[] encoding, Object value) {
        synchronized (X509Factory.class) {
            if (encoding.length <= 4194304) {
                cache.put(new Cache.EqualByteArray(encoding), value);
            }
        }
    }

    public CertPath engineGenerateCertPath(InputStream inStream) throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("Missing input stream");
        }
        try {
            byte[] encoding = readOneBlock(inStream);
            if (encoding != null) {
                return new X509CertPath((InputStream) new ByteArrayInputStream(encoding));
            }
            throw new IOException("Empty input");
        } catch (IOException ioe) {
            throw new CertificateException(ioe.getMessage());
        }
    }

    public CertPath engineGenerateCertPath(InputStream inStream, String encoding) throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("Missing input stream");
        }
        try {
            byte[] data = readOneBlock(inStream);
            if (data != null) {
                return new X509CertPath(new ByteArrayInputStream(data), encoding);
            }
            throw new IOException("Empty input");
        } catch (IOException ioe) {
            throw new CertificateException(ioe.getMessage());
        }
    }

    public CertPath engineGenerateCertPath(List<? extends Certificate> certificates) throws CertificateException {
        return new X509CertPath(certificates);
    }

    public Iterator<String> engineGetCertPathEncodings() {
        return X509CertPath.getEncodingsStatic();
    }

    public Collection<? extends Certificate> engineGenerateCertificates(InputStream is) throws CertificateException {
        if (is == null) {
            throw new CertificateException("Missing input stream");
        }
        try {
            return parseX509orPKCS7Cert(is);
        } catch (IOException ioe) {
            throw new CertificateException((Throwable) ioe);
        }
    }

    public CRL engineGenerateCRL(InputStream is) throws CRLException {
        if (is == null) {
            crlCache.clear();
            throw new CRLException("Missing input stream");
        }
        try {
            byte[] encoding = readOneBlock(is);
            if (encoding != null) {
                X509CRLImpl crl = (X509CRLImpl) getFromCache(crlCache, encoding);
                if (crl != null) {
                    return crl;
                }
                X509CRLImpl crl2 = new X509CRLImpl(encoding);
                addToCache(crlCache, crl2.getEncodedInternal(), crl2);
                return crl2;
            }
            throw new IOException("Empty input");
        } catch (IOException ioe) {
            throw new CRLException(ioe.getMessage());
        }
    }

    public Collection<? extends CRL> engineGenerateCRLs(InputStream is) throws CRLException {
        if (is == null) {
            throw new CRLException("Missing input stream");
        }
        try {
            return parseX509orPKCS7CRL(is);
        } catch (IOException ioe) {
            throw new CRLException(ioe.getMessage());
        }
    }

    private Collection<? extends Certificate> parseX509orPKCS7Cert(InputStream is) throws CertificateException, IOException {
        Collection<X509CertImpl> coll = new ArrayList<>();
        byte[] data = readOneBlock(is);
        if (data == null) {
            return new ArrayList(0);
        }
        try {
            X509Certificate[] certs = new PKCS7(data).getCertificates();
            if (certs != null) {
                return Arrays.asList(certs);
            }
            return new ArrayList(0);
        } catch (ParsingException e) {
            while (data != null) {
                coll.add(new X509CertImpl(data));
                data = readOneBlock(is);
            }
            return coll;
        }
    }

    private Collection<? extends CRL> parseX509orPKCS7CRL(InputStream is) throws CRLException, IOException {
        Collection<X509CRLImpl> coll = new ArrayList<>();
        byte[] data = readOneBlock(is);
        if (data == null) {
            return new ArrayList(0);
        }
        try {
            X509CRL[] crls = new PKCS7(data).getCRLs();
            if (crls != null) {
                return Arrays.asList(crls);
            }
            return new ArrayList(0);
        } catch (ParsingException e) {
            while (data != null) {
                coll.add(new X509CRLImpl(data));
                data = readOneBlock(is);
            }
            return coll;
        }
    }

    private static byte[] readOneBlock(InputStream is) throws IOException {
        int end;
        int c = is.read();
        if (c == -1) {
            return null;
        }
        if (c == 48) {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(2048);
            bout.write(c);
            readBERInternal(is, bout, c);
            return bout.toByteArray();
        }
        char[] data = new char[2048];
        int pos = 0;
        int hyphen = c == 45 ? 1 : 0;
        int last = c == 45 ? -1 : c;
        while (true) {
            int next = is.read();
            if (next == -1) {
                return null;
            }
            if (next == 45) {
                hyphen++;
            } else {
                hyphen = 0;
                last = next;
            }
            if (!(hyphen == 5 && (last == -1 || last == 13 || last == 10))) {
            }
        }
        StringBuffer header = new StringBuffer("-----");
        while (true) {
            int next2 = is.read();
            if (next2 == -1) {
                throw new IOException("Incomplete data");
            } else if (next2 == 10) {
                end = 10;
                break;
            } else if (next2 == 13) {
                int next3 = is.read();
                if (next3 == -1) {
                    throw new IOException("Incomplete data");
                } else if (next3 == 10) {
                    end = 10;
                } else {
                    end = 13;
                    pos = 1;
                    data[0] = (char) next3;
                }
            } else {
                header.append((char) next2);
            }
        }
        while (true) {
            int next4 = is.read();
            if (next4 == -1) {
                throw new IOException("Incomplete data");
            } else if (next4 != 45) {
                int pos2 = pos + 1;
                data[pos] = (char) next4;
                if (pos2 >= data.length) {
                    data = Arrays.copyOf(data, data.length + 1024);
                }
                pos = pos2;
            } else {
                StringBuffer footer = new StringBuffer(LanguageTag.SEP);
                while (true) {
                    int next5 = is.read();
                    if (next5 == -1 || next5 == end || next5 == 10) {
                        checkHeaderFooter(header.toString(), footer.toString());
                    } else if (next5 != 13) {
                        footer.append((char) next5);
                    }
                }
                checkHeaderFooter(header.toString(), footer.toString());
                return new BASE64Decoder().decodeBuffer(new String(data, 0, pos));
            }
        }
    }

    private static void checkHeaderFooter(String header, String footer) throws IOException {
        if (header.length() < 16 || !header.startsWith("-----BEGIN ") || !header.endsWith("-----")) {
            throw new IOException("Illegal header: " + header);
        } else if (footer.length() < 14 || !footer.startsWith("-----END ") || !footer.endsWith("-----")) {
            throw new IOException("Illegal footer: " + footer);
        } else if (!header.substring(11, header.length() - 5).equals(footer.substring(9, footer.length() - 5))) {
            throw new IOException("Header and footer do not match: " + header + " " + footer);
        }
    }

    private static int readBERInternal(InputStream is, ByteArrayOutputStream bout, int tag) throws IOException {
        int length;
        if (tag == -1) {
            tag = is.read();
            if (tag == -1) {
                throw new IOException("BER/DER tag info absent");
            } else if ((tag & 31) == 31) {
                throw new IOException("Multi octets tag not supported");
            } else {
                bout.write(tag);
            }
        }
        int n = is.read();
        if (n == -1) {
            throw new IOException("BER/DER length info ansent");
        }
        bout.write(n);
        if (n != 128) {
            if (n < 128) {
                length = n;
            } else if (n == 129) {
                length = is.read();
                if (length == -1) {
                    throw new IOException("Incomplete BER/DER length info");
                }
                bout.write(length);
            } else if (n == 130) {
                int highByte = is.read();
                int lowByte = is.read();
                if (lowByte == -1) {
                    throw new IOException("Incomplete BER/DER length info");
                }
                bout.write(highByte);
                bout.write(lowByte);
                length = (highByte << 8) | lowByte;
            } else if (n == 131) {
                int highByte2 = is.read();
                int midByte = is.read();
                int lowByte2 = is.read();
                if (lowByte2 == -1) {
                    throw new IOException("Incomplete BER/DER length info");
                }
                bout.write(highByte2);
                bout.write(midByte);
                bout.write(lowByte2);
                length = (highByte2 << 16) | (midByte << 8) | lowByte2;
            } else if (n == 132) {
                int highByte3 = is.read();
                int nextByte = is.read();
                int midByte2 = is.read();
                int lowByte3 = is.read();
                if (lowByte3 == -1) {
                    throw new IOException("Incomplete BER/DER length info");
                } else if (highByte3 > 127) {
                    throw new IOException("Invalid BER/DER data (a little huge?)");
                } else {
                    bout.write(highByte3);
                    bout.write(nextByte);
                    bout.write(midByte2);
                    bout.write(lowByte3);
                    length = (highByte3 << 24) | (nextByte << 16) | (midByte2 << 8) | lowByte3;
                }
            } else {
                throw new IOException("Invalid BER/DER data (too huge?)");
            }
            if (readFully(is, bout, length) != length) {
                throw new IOException("Incomplete BER/DER data");
            }
        } else if ((tag & 32) != 32) {
            throw new IOException("Non constructed encoding must have definite length");
        } else {
            do {
            } while (readBERInternal(is, bout, -1) != 0);
        }
        return tag;
    }
}
