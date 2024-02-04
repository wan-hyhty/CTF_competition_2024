package sun.net;

import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourceManager {
    private static final int DEFAULT_MAX_SOCKETS = 25;
    private static final int maxSockets = 0;
    private static final AtomicInteger numSockets = null;

    public static void beforeUdpCreate() throws SocketException {
        if (System.getSecurityManager() != null && numSockets.incrementAndGet() > maxSockets) {
            numSockets.decrementAndGet();
            throw new SocketException("maximum number of DatagramSockets reached");
        }
    }

    public static void afterUdpClose() {
        if (System.getSecurityManager() != null) {
            numSockets.decrementAndGet();
        }
    }
}
