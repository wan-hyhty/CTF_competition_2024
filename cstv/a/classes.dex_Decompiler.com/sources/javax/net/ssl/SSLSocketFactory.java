package javax.net.ssl;

import java.io.IOException;
import java.net.Socket;
import java.security.AccessController;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.Security;
import javax.net.SocketFactory;

public abstract class SSLSocketFactory extends SocketFactory {
    static final boolean DEBUG = false;
    private static SSLSocketFactory defaultSocketFactory;
    private static int lastVersion;

    public abstract Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException;

    public abstract String[] getDefaultCipherSuites();

    public abstract String[] getSupportedCipherSuites();

    private static void log(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }

    public static synchronized SocketFactory getDefault() {
        synchronized (SSLSocketFactory.class) {
            if (defaultSocketFactory == null || lastVersion != Security.getVersion()) {
                lastVersion = Security.getVersion();
                SSLSocketFactory previousDefaultSocketFactory = defaultSocketFactory;
                defaultSocketFactory = null;
                String clsName = getSecurityProperty("ssl.SocketFactory.provider");
                if (clsName != null) {
                    if (previousDefaultSocketFactory == null || !clsName.equals(previousDefaultSocketFactory.getClass().getName())) {
                        log("setting up default SSLSocketFactory");
                        Class cls = null;
                        try {
                            cls = Class.forName(clsName);
                        } catch (ClassNotFoundException e) {
                            ClassLoader cl = Thread.currentThread().getContextClassLoader();
                            if (cl == null) {
                                cl = ClassLoader.getSystemClassLoader();
                            }
                            if (cl != null) {
                                cls = Class.forName(clsName, true, cl);
                            }
                        }
                        try {
                            log("class " + clsName + " is loaded");
                            defaultSocketFactory = (SSLSocketFactory) cls.newInstance();
                            log("instantiated an instance of class " + clsName);
                            if (defaultSocketFactory != null) {
                                SSLSocketFactory sSLSocketFactory = defaultSocketFactory;
                                return sSLSocketFactory;
                            }
                        } catch (Exception e2) {
                            log("SSLSocketFactory instantiation failed: " + e2.toString());
                        }
                    } else {
                        defaultSocketFactory = previousDefaultSocketFactory;
                        SSLSocketFactory sSLSocketFactory2 = defaultSocketFactory;
                        return sSLSocketFactory2;
                    }
                }
                try {
                    SSLContext context = SSLContext.getDefault();
                    if (context != null) {
                        defaultSocketFactory = context.getSocketFactory();
                    }
                } catch (NoSuchAlgorithmException e3) {
                }
                if (defaultSocketFactory == null) {
                    defaultSocketFactory = new DefaultSSLSocketFactory(new IllegalStateException("No factory found."));
                }
                SSLSocketFactory sSLSocketFactory3 = defaultSocketFactory;
                return sSLSocketFactory3;
            }
            SSLSocketFactory sSLSocketFactory4 = defaultSocketFactory;
            return sSLSocketFactory4;
        }
    }

    static String getSecurityProperty(final String name) {
        return (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                String s = Security.getProperty(name);
                if (s == null) {
                    return s;
                }
                String s2 = s.trim();
                if (s2.length() == 0) {
                    return null;
                }
                return s2;
            }
        });
    }
}
