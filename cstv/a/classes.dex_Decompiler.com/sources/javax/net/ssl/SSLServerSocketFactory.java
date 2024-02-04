package javax.net.ssl;

import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.net.ServerSocketFactory;

public abstract class SSLServerSocketFactory extends ServerSocketFactory {
    private static SSLServerSocketFactory defaultServerSocketFactory;
    private static int lastVersion;

    public abstract String[] getDefaultCipherSuites();

    public abstract String[] getSupportedCipherSuites();

    private static void log(String msg) {
        if (SSLSocketFactory.DEBUG) {
            System.out.println(msg);
        }
    }

    protected SSLServerSocketFactory() {
    }

    public static synchronized ServerSocketFactory getDefault() {
        synchronized (SSLServerSocketFactory.class) {
            if (defaultServerSocketFactory == null || lastVersion != Security.getVersion()) {
                lastVersion = Security.getVersion();
                SSLServerSocketFactory previousDefaultServerSocketFactory = defaultServerSocketFactory;
                defaultServerSocketFactory = null;
                String clsName = SSLSocketFactory.getSecurityProperty("ssl.ServerSocketFactory.provider");
                if (clsName != null) {
                    if (previousDefaultServerSocketFactory == null || !clsName.equals(previousDefaultServerSocketFactory.getClass().getName())) {
                        Class cls = null;
                        log("setting up default SSLServerSocketFactory");
                        try {
                            log("setting up default SSLServerSocketFactory");
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
                            log("class " + clsName + " is loaded");
                            log("instantiated an instance of class " + clsName);
                            defaultServerSocketFactory = (SSLServerSocketFactory) cls.newInstance();
                            if (defaultServerSocketFactory != null) {
                                SSLServerSocketFactory sSLServerSocketFactory = defaultServerSocketFactory;
                                return sSLServerSocketFactory;
                            }
                        } catch (Exception e2) {
                            log("SSLServerSocketFactory instantiation failed: " + e2);
                        }
                    } else {
                        defaultServerSocketFactory = previousDefaultServerSocketFactory;
                        SSLServerSocketFactory sSLServerSocketFactory2 = defaultServerSocketFactory;
                        return sSLServerSocketFactory2;
                    }
                }
                try {
                    SSLContext context = SSLContext.getDefault();
                    if (context != null) {
                        defaultServerSocketFactory = context.getServerSocketFactory();
                    }
                } catch (NoSuchAlgorithmException e3) {
                }
                if (defaultServerSocketFactory == null) {
                    defaultServerSocketFactory = new DefaultSSLServerSocketFactory(new IllegalStateException("No ServerSocketFactory implementation found"));
                }
                SSLServerSocketFactory sSLServerSocketFactory3 = defaultServerSocketFactory;
                return sSLServerSocketFactory3;
            }
            SSLServerSocketFactory sSLServerSocketFactory4 = defaultServerSocketFactory;
            return sSLServerSocketFactory4;
        }
    }
}
