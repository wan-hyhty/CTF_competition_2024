package sun.net.ftp.impl;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpClientProvider;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class DefaultFtpClientProvider extends FtpClientProvider {
    public FtpClient createFtpClient() {
        return FtpClient.create();
    }
}
