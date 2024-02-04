package java.net;

class DefaultDatagramSocketImplFactory {
    static Class prefixImplClass;

    DefaultDatagramSocketImplFactory() {
    }

    static DatagramSocketImpl createDatagramSocketImpl(boolean isMulticast) throws SocketException {
        if (prefixImplClass == null) {
            return new PlainDatagramSocketImpl();
        }
        try {
            return (DatagramSocketImpl) prefixImplClass.newInstance();
        } catch (Exception e) {
            throw new SocketException("can't instantiate DatagramSocketImpl");
        }
    }
}
