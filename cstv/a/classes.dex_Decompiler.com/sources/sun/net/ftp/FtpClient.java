package sun.net.ftp;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class FtpClient implements Closeable {
    private static final int FTP_PORT = 21;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum TransferType {
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.net.ftp.FtpClient.<init>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    protected FtpClient() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.net.ftp.FtpClient.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.FtpClient.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.create():sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public static sun.net.ftp.FtpClient create() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.create():sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.FtpClient.create():sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.create(java.net.InetSocketAddress):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public static sun.net.ftp.FtpClient create(java.net.InetSocketAddress r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.create(java.net.InetSocketAddress):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.FtpClient.create(java.net.InetSocketAddress):sun.net.ftp.FtpClient");
    }

    public abstract FtpClient abort() throws FtpProtocolException, IOException;

    public abstract FtpClient allocate(long j) throws FtpProtocolException, IOException;

    public abstract FtpClient appendFile(String str, InputStream inputStream) throws FtpProtocolException, IOException;

    public abstract FtpClient changeDirectory(String str) throws FtpProtocolException, IOException;

    public abstract FtpClient changeToParentDirectory() throws FtpProtocolException, IOException;

    public abstract void close() throws IOException;

    public abstract FtpClient completePending() throws FtpProtocolException, IOException;

    public abstract FtpClient connect(SocketAddress socketAddress) throws FtpProtocolException, IOException;

    public abstract FtpClient connect(SocketAddress socketAddress, int i) throws FtpProtocolException, IOException;

    public abstract FtpClient deleteFile(String str) throws FtpProtocolException, IOException;

    public abstract FtpClient enablePassiveMode(boolean z);

    public abstract FtpClient endSecureSession() throws FtpProtocolException, IOException;

    public abstract int getConnectTimeout();

    public abstract List<String> getFeatures() throws FtpProtocolException, IOException;

    public abstract FtpClient getFile(String str, OutputStream outputStream) throws FtpProtocolException, IOException;

    public abstract InputStream getFileStream(String str) throws FtpProtocolException, IOException;

    public abstract String getHelp(String str) throws FtpProtocolException, IOException;

    public abstract String getLastFileName();

    public abstract Date getLastModified(String str) throws FtpProtocolException, IOException;

    public abstract FtpReplyCode getLastReplyCode();

    public abstract String getLastResponseString();

    public abstract long getLastTransferSize();

    public abstract Proxy getProxy();

    public abstract int getReadTimeout();

    public abstract SocketAddress getServerAddress();

    public abstract long getSize(String str) throws FtpProtocolException, IOException;

    public abstract String getStatus(String str) throws FtpProtocolException, IOException;

    public abstract String getSystem() throws FtpProtocolException, IOException;

    public abstract String getWelcomeMsg();

    public abstract String getWorkingDirectory() throws FtpProtocolException, IOException;

    public abstract boolean isConnected();

    public abstract boolean isLoggedIn();

    public abstract boolean isPassiveModeEnabled();

    public abstract InputStream list(String str) throws FtpProtocolException, IOException;

    public abstract Iterator<FtpDirEntry> listFiles(String str) throws FtpProtocolException, IOException;

    public abstract FtpClient login(String str, char[] cArr) throws FtpProtocolException, IOException;

    public abstract FtpClient login(String str, char[] cArr, String str2) throws FtpProtocolException, IOException;

    public abstract FtpClient makeDirectory(String str) throws FtpProtocolException, IOException;

    public abstract InputStream nameList(String str) throws FtpProtocolException, IOException;

    public abstract FtpClient noop() throws FtpProtocolException, IOException;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.putFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public sun.net.ftp.FtpClient putFile(java.lang.String r1, java.io.InputStream r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.putFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.FtpClient.putFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient");
    }

    public abstract FtpClient putFile(String str, InputStream inputStream, boolean z) throws FtpProtocolException, IOException;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.putFileStream(java.lang.String):java.io.OutputStream, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.io.OutputStream putFileStream(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.putFileStream(java.lang.String):java.io.OutputStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.FtpClient.putFileStream(java.lang.String):java.io.OutputStream");
    }

    public abstract OutputStream putFileStream(String str, boolean z) throws FtpProtocolException, IOException;

    public abstract FtpClient reInit() throws FtpProtocolException, IOException;

    public abstract FtpClient removeDirectory(String str) throws FtpProtocolException, IOException;

    public abstract FtpClient rename(String str, String str2) throws FtpProtocolException, IOException;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.setAsciiType():sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public sun.net.ftp.FtpClient setAsciiType() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.setAsciiType():sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.FtpClient.setAsciiType():sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.setBinaryType():sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public sun.net.ftp.FtpClient setBinaryType() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.FtpClient.setBinaryType():sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.FtpClient.setBinaryType():sun.net.ftp.FtpClient");
    }

    public abstract FtpClient setConnectTimeout(int i);

    public abstract FtpClient setDirParser(FtpDirParser ftpDirParser);

    public abstract FtpClient setProxy(Proxy proxy);

    public abstract FtpClient setReadTimeout(int i);

    public abstract FtpClient setRestartOffset(long j);

    public abstract FtpClient setType(TransferType transferType) throws FtpProtocolException, IOException;

    public abstract FtpClient siteCmd(String str) throws FtpProtocolException, IOException;

    public abstract FtpClient startSecureSession() throws FtpProtocolException, IOException;

    public abstract FtpClient structureMount(String str) throws FtpProtocolException, IOException;

    public abstract FtpClient useKerberos() throws FtpProtocolException, IOException;

    public static final int defaultPort() {
        return FTP_PORT;
    }

    public static FtpClient create(String dest) throws FtpProtocolException, IOException {
        return create(new InetSocketAddress(dest, (int) FTP_PORT));
    }
}
