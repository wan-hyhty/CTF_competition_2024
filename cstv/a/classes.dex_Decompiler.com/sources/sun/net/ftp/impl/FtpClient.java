package sun.net.ftp.impl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpDirEntry;
import sun.net.ftp.FtpDirParser;
import sun.net.ftp.FtpProtocolException;
import sun.net.ftp.FtpReplyCode;
import sun.util.logging.PlatformLogger;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class FtpClient extends sun.net.ftp.FtpClient {
    private static String[] MDTMformats;
    private static SimpleDateFormat[] dateFormats;
    private static int defaultConnectTimeout;
    private static int defaultSoTimeout;
    private static String encoding;
    private static Pattern epsvPat;
    /* access modifiers changed from: private */
    public static Pattern linkp;
    private static final PlatformLogger logger = null;
    private static Pattern pasvPat;
    private static String[] patStrings;
    /* access modifiers changed from: private */
    public static int[][] patternGroups;
    /* access modifiers changed from: private */
    public static Pattern[] patterns;
    private static Pattern transPat;
    private int connectTimeout;
    private DateFormat df;
    private InputStream in;
    private String lastFileName;
    private FtpReplyCode lastReplyCode;
    private long lastTransSize;
    private boolean loggedIn;
    private FtpDirParser mlsxParser;
    private Socket oldSocket;
    private PrintStream out;
    private FtpDirParser parser;
    private final boolean passiveMode;
    private Proxy proxy;
    private int readTimeout;
    private boolean replyPending;
    private long restartOffset;
    private Socket server;
    private InetSocketAddress serverAddr;
    private Vector<String> serverResponse;
    private SSLSocketFactory sslFact;
    private FtpClient.TransferType type;
    private boolean useCrypto;
    private String welcomeMsg;

    private class DefaultParser implements FtpDirParser {
        final /* synthetic */ FtpClient this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.DefaultParser.<init>(sun.net.ftp.impl.FtpClient):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private DefaultParser(sun.net.ftp.impl.FtpClient r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.DefaultParser.<init>(sun.net.ftp.impl.FtpClient):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.DefaultParser.<init>(sun.net.ftp.impl.FtpClient):void");
        }

        /* synthetic */ DefaultParser(FtpClient this$02, DefaultParser defaultParser) {
            this(this$02);
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.DefaultParser.parseLine(java.lang.String):sun.net.ftp.FtpDirEntry, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public sun.net.ftp.FtpDirEntry parseLine(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.DefaultParser.parseLine(java.lang.String):sun.net.ftp.FtpDirEntry, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.DefaultParser.parseLine(java.lang.String):sun.net.ftp.FtpDirEntry");
        }
    }

    private class MLSxParser implements FtpDirParser {
        private SimpleDateFormat df;
        final /* synthetic */ FtpClient this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.MLSxParser.<init>(sun.net.ftp.impl.FtpClient):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private MLSxParser(sun.net.ftp.impl.FtpClient r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.MLSxParser.<init>(sun.net.ftp.impl.FtpClient):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.MLSxParser.<init>(sun.net.ftp.impl.FtpClient):void");
        }

        /* synthetic */ MLSxParser(FtpClient this$02, MLSxParser mLSxParser) {
            this(this$02);
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.MLSxParser.parseLine(java.lang.String):sun.net.ftp.FtpDirEntry, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public sun.net.ftp.FtpDirEntry parseLine(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.MLSxParser.parseLine(java.lang.String):sun.net.ftp.FtpDirEntry, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.MLSxParser.parseLine(java.lang.String):sun.net.ftp.FtpDirEntry");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.-get0(sun.net.ftp.impl.FtpClient):java.text.DateFormat, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    /* renamed from: -get0 */
    static /* synthetic */ java.text.DateFormat m672get0(sun.net.ftp.impl.FtpClient r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.-get0(sun.net.ftp.impl.FtpClient):java.text.DateFormat, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.m672get0(sun.net.ftp.impl.FtpClient):java.text.DateFormat");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.-get4(sun.net.ftp.impl.FtpClient):java.net.Proxy, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    /* renamed from: -get4 */
    static /* synthetic */ java.net.Proxy m676get4(sun.net.ftp.impl.FtpClient r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.-get4(sun.net.ftp.impl.FtpClient):java.net.Proxy, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.m676get4(sun.net.ftp.impl.FtpClient):java.net.Proxy");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.ftp.impl.FtpClient.-get5(sun.net.ftp.impl.FtpClient):java.net.Socket, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.-get5(sun.net.ftp.impl.FtpClient):java.net.Socket, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.ftp.impl.FtpClient.-get5(sun.net.ftp.impl.FtpClient):java.net.Socket, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$23.decode(InstructionCodec.java:514)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    /* renamed from: -get5 */
    static /* synthetic */ java.net.Socket m677get5(sun.net.ftp.impl.FtpClient r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.net.ftp.impl.FtpClient.-get5(sun.net.ftp.impl.FtpClient):java.net.Socket, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.-get5(sun.net.ftp.impl.FtpClient):java.net.Socket, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.m677get5(sun.net.ftp.impl.FtpClient):java.net.Socket");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.<clinit>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.ftp.impl.FtpClient.<init>():void, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.<init>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.ftp.impl.FtpClient.<init>():void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    protected FtpClient() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.net.ftp.impl.FtpClient.<init>():void, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.<init>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.createInputStream(java.io.InputStream):java.io.InputStream, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private java.io.InputStream createInputStream(java.io.InputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.createInputStream(java.io.InputStream):java.io.InputStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.createInputStream(java.io.InputStream):java.io.InputStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.createOutputStream(java.io.OutputStream):java.io.OutputStream, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private java.io.OutputStream createOutputStream(java.io.OutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.createOutputStream(java.io.OutputStream):java.io.OutputStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.createOutputStream(java.io.OutputStream):java.io.OutputStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.disconnect():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private void disconnect() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.disconnect():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.disconnect():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.doConnect(java.net.InetSocketAddress, int):java.net.Socket, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private java.net.Socket doConnect(java.net.InetSocketAddress r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.doConnect(java.net.InetSocketAddress, int):java.net.Socket, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.doConnect(java.net.InetSocketAddress, int):java.net.Socket");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getResponseString():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private java.lang.String getResponseString() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getResponseString():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getResponseString():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getResponseStrings():java.util.Vector<java.lang.String>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private java.util.Vector<java.lang.String> getResponseStrings() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getResponseStrings():java.util.Vector<java.lang.String>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getResponseStrings():java.util.Vector");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getSecurityData():byte[], dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private byte[] getSecurityData() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getSecurityData():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getSecurityData():byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.getTransferName():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private void getTransferName() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.getTransferName():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getTransferName():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e7 in method: sun.net.ftp.impl.FtpClient.getTransferSize():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e7
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private void getTransferSize() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e7 in method: sun.net.ftp.impl.FtpClient.getTransferSize():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getTransferSize():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.isASCIISuperset(java.lang.String):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private static boolean isASCIISuperset(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.isASCIISuperset(java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.isASCIISuperset(java.lang.String):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.issueCommand(java.lang.String):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private boolean issueCommand(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.issueCommand(java.lang.String):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.issueCommand(java.lang.String):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.issueCommandCheck(java.lang.String):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private void issueCommandCheck(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.issueCommandCheck(java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.issueCommandCheck(java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.openDataConnection(java.lang.String):java.net.Socket, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private java.net.Socket openDataConnection(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.openDataConnection(java.lang.String):java.net.Socket, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.openDataConnection(java.lang.String):java.net.Socket");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.openPassiveDataConnection(java.lang.String):java.net.Socket, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private java.net.Socket openPassiveDataConnection(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.openPassiveDataConnection(java.lang.String):java.net.Socket, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.openPassiveDataConnection(java.lang.String):java.net.Socket");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.readReply():boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private boolean readReply() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.readReply():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.readReply():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.readServerResponse():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private int readServerResponse() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.readServerResponse():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.readServerResponse():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.sendSecurityData(byte[]):boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private boolean sendSecurityData(byte[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.sendSecurityData(byte[]):boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.sendSecurityData(byte[]):boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.sendServer(java.lang.String):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private void sendServer(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.sendServer(java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.sendServer(java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.tryConnect(java.net.InetSocketAddress, int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private void tryConnect(java.net.InetSocketAddress r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.tryConnect(java.net.InetSocketAddress, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.tryConnect(java.net.InetSocketAddress, int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.tryLogin(java.lang.String, char[]):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private void tryLogin(java.lang.String r1, char[] r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.tryLogin(java.lang.String, char[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.tryLogin(java.lang.String, char[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.allocate(long):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient allocate(long r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.allocate(long):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.allocate(long):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus registerCount: f in method: sun.net.ftp.impl.FtpClient.appendFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.appendFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: bogus registerCount: f in method: sun.net.ftp.impl.FtpClient.appendFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: com.android.dex.DexException: bogus registerCount: f
        	at com.android.dx.io.instructions.InstructionCodec$32.decode(InstructionCodec.java:693)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    public sun.net.ftp.FtpClient appendFile(java.lang.String r1, java.io.InputStream r2) {
        /*
        // Can't load method instructions: Load method exception: bogus registerCount: f in method: sun.net.ftp.impl.FtpClient.appendFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.appendFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.appendFile(java.lang.String, java.io.InputStream):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.changeDirectory(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient changeDirectory(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.changeDirectory(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.changeDirectory(java.lang.String):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.close():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public void close() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.close():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.close():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.net.ftp.impl.FtpClient.completePending():sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient completePending() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.net.ftp.impl.FtpClient.completePending():sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.completePending():sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.connect(java.net.SocketAddress):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient connect(java.net.SocketAddress r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.connect(java.net.SocketAddress):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.connect(java.net.SocketAddress):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.connect(java.net.SocketAddress, int):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient connect(java.net.SocketAddress r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.connect(java.net.SocketAddress, int):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.connect(java.net.SocketAddress, int):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.deleteFile(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient deleteFile(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.deleteFile(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.deleteFile(java.lang.String):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.net.ftp.impl.FtpClient.endSecureSession():sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient endSecureSession() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.net.ftp.impl.FtpClient.endSecureSession():sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.endSecureSession():sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.net.ftp.impl.FtpClient.getConnectTimeout():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public int getConnectTimeout() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.net.ftp.impl.FtpClient.getConnectTimeout():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getConnectTimeout():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getFeatures():java.util.List<java.lang.String>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.util.List<java.lang.String> getFeatures() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getFeatures():java.util.List<java.lang.String>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getFeatures():java.util.List");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: sun.net.ftp.impl.FtpClient.getFile(java.lang.String, java.io.OutputStream):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient getFile(java.lang.String r1, java.io.OutputStream r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: sun.net.ftp.impl.FtpClient.getFile(java.lang.String, java.io.OutputStream):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getFile(java.lang.String, java.io.OutputStream):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: sun.net.ftp.impl.FtpClient.getFileStream(java.lang.String):java.io.InputStream, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.io.InputStream getFileStream(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: sun.net.ftp.impl.FtpClient.getFileStream(java.lang.String):java.io.InputStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getFileStream(java.lang.String):java.io.InputStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getHelp(java.lang.String):java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getHelp(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getHelp(java.lang.String):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getHelp(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getLastFileName():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getLastFileName() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getLastFileName():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getLastFileName():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getLastModified(java.lang.String):java.util.Date, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.util.Date getLastModified(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getLastModified(java.lang.String):java.util.Date, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getLastModified(java.lang.String):java.util.Date");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.ftp.impl.FtpClient.getLastReplyCode():sun.net.ftp.FtpReplyCode, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.getLastReplyCode():sun.net.ftp.FtpReplyCode, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.ftp.impl.FtpClient.getLastReplyCode():sun.net.ftp.FtpReplyCode, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
        	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    public sun.net.ftp.FtpReplyCode getLastReplyCode() {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.net.ftp.impl.FtpClient.getLastReplyCode():sun.net.ftp.FtpReplyCode, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.getLastReplyCode():sun.net.ftp.FtpReplyCode, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getLastReplyCode():sun.net.ftp.FtpReplyCode");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getLastResponseString():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getLastResponseString() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getLastResponseString():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getLastResponseString():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e4 in method: sun.net.ftp.impl.FtpClient.getLastTransferSize():long, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e4
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public long getLastTransferSize() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e4 in method: sun.net.ftp.impl.FtpClient.getLastTransferSize():long, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getLastTransferSize():long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getProxy():java.net.Proxy, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.net.Proxy getProxy() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getProxy():java.net.Proxy, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getProxy():java.net.Proxy");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.net.ftp.impl.FtpClient.getReadTimeout():int, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public int getReadTimeout() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.net.ftp.impl.FtpClient.getReadTimeout():int, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getReadTimeout():int");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getServerAddress():java.net.SocketAddress, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.net.SocketAddress getServerAddress() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getServerAddress():java.net.SocketAddress, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getServerAddress():java.net.SocketAddress");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getSize(java.lang.String):long, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public long getSize(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getSize(java.lang.String):long, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getSize(java.lang.String):long");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getStatus(java.lang.String):java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getStatus(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getStatus(java.lang.String):java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getStatus(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getSystem():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getSystem() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getSystem():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getSystem():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getWelcomeMsg():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getWelcomeMsg() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.getWelcomeMsg():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getWelcomeMsg():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getWorkingDirectory():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.lang.String getWorkingDirectory() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.getWorkingDirectory():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.getWorkingDirectory():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.isConnected():boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public boolean isConnected() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.isConnected():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.isConnected():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.net.ftp.impl.FtpClient.isLoggedIn():boolean, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public boolean isLoggedIn() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.net.ftp.impl.FtpClient.isLoggedIn():boolean, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.isLoggedIn():boolean");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.list(java.lang.String):java.io.InputStream, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.io.InputStream list(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.list(java.lang.String):java.io.InputStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.list(java.lang.String):java.io.InputStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.listFiles(java.lang.String):java.util.Iterator<sun.net.ftp.FtpDirEntry>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.util.Iterator<sun.net.ftp.FtpDirEntry> listFiles(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.listFiles(java.lang.String):java.util.Iterator<sun.net.ftp.FtpDirEntry>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.listFiles(java.lang.String):java.util.Iterator");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.login(java.lang.String, char[]):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient login(java.lang.String r1, char[] r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.login(java.lang.String, char[]):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.login(java.lang.String, char[]):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.login(java.lang.String, char[], java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient login(java.lang.String r1, char[] r2, java.lang.String r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.login(java.lang.String, char[], java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.login(java.lang.String, char[], java.lang.String):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.makeDirectory(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient makeDirectory(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.makeDirectory(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.makeDirectory(java.lang.String):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.nameList(java.lang.String):java.io.InputStream, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.io.InputStream nameList(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.nameList(java.lang.String):java.io.InputStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.nameList(java.lang.String):java.io.InputStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.putFile(java.lang.String, java.io.InputStream, boolean):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient putFile(java.lang.String r1, java.io.InputStream r2, boolean r3) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.putFile(java.lang.String, java.io.InputStream, boolean):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.putFile(java.lang.String, java.io.InputStream, boolean):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.putFileStream(java.lang.String, boolean):java.io.OutputStream, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public java.io.OutputStream putFileStream(java.lang.String r1, boolean r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.putFileStream(java.lang.String, boolean):java.io.OutputStream, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.putFileStream(java.lang.String, boolean):java.io.OutputStream");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00eb in method: sun.net.ftp.impl.FtpClient.reInit():sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00eb
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient reInit() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00eb in method: sun.net.ftp.impl.FtpClient.reInit():sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.reInit():sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.removeDirectory(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient removeDirectory(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.removeDirectory(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.removeDirectory(java.lang.String):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.rename(java.lang.String, java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient rename(java.lang.String r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.rename(java.lang.String, java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.rename(java.lang.String, java.lang.String):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.net.ftp.impl.FtpClient.setConnectTimeout(int):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient setConnectTimeout(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.net.ftp.impl.FtpClient.setConnectTimeout(int):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.setConnectTimeout(int):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.ftp.impl.FtpClient.setDirParser(sun.net.ftp.FtpDirParser):sun.net.ftp.FtpClient, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.setDirParser(sun.net.ftp.FtpDirParser):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.ftp.impl.FtpClient.setDirParser(sun.net.ftp.FtpDirParser):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
        	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    public sun.net.ftp.FtpClient setDirParser(sun.net.ftp.FtpDirParser r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.net.ftp.impl.FtpClient.setDirParser(sun.net.ftp.FtpDirParser):sun.net.ftp.FtpClient, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.setDirParser(sun.net.ftp.FtpDirParser):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.setDirParser(sun.net.ftp.FtpDirParser):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.setProxy(java.net.Proxy):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient setProxy(java.net.Proxy r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.setProxy(java.net.Proxy):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.setProxy(java.net.Proxy):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.net.ftp.impl.FtpClient.setReadTimeout(int):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient setReadTimeout(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.net.ftp.impl.FtpClient.setReadTimeout(int):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.setReadTimeout(int):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e7 in method: sun.net.ftp.impl.FtpClient.setRestartOffset(long):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e7
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient setRestartOffset(long r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e7 in method: sun.net.ftp.impl.FtpClient.setRestartOffset(long):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.setRestartOffset(long):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.setType(sun.net.ftp.FtpClient$TransferType):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient setType(sun.net.ftp.FtpClient.TransferType r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.setType(sun.net.ftp.FtpClient$TransferType):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.setType(sun.net.ftp.FtpClient$TransferType):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.siteCmd(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient siteCmd(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.siteCmd(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.siteCmd(java.lang.String):sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.startSecureSession():sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient startSecureSession() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.startSecureSession():sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.startSecureSession():sun.net.ftp.FtpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.structureMount(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public sun.net.ftp.FtpClient structureMount(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.structureMount(java.lang.String):sun.net.ftp.FtpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.structureMount(java.lang.String):sun.net.ftp.FtpClient");
    }

    public static sun.net.ftp.FtpClient create() {
        return new FtpClient();
    }

    public sun.net.ftp.FtpClient enablePassiveMode(boolean passive) {
        return this;
    }

    public boolean isPassiveModeEnabled() {
        return true;
    }

    public sun.net.ftp.FtpClient changeToParentDirectory() throws FtpProtocolException, IOException {
        issueCommandCheck("CDUP");
        return this;
    }

    public sun.net.ftp.FtpClient noop() throws FtpProtocolException, IOException {
        issueCommandCheck("NOOP");
        return this;
    }

    public sun.net.ftp.FtpClient abort() throws FtpProtocolException, IOException {
        issueCommandCheck("ABOR");
        return this;
    }

    private class FtpFileIterator implements Iterator<FtpDirEntry>, Closeable {
        private boolean eof;
        private FtpDirParser fparser;
        private BufferedReader in;
        private FtpDirEntry nextFile;
        final /* synthetic */ FtpClient this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.<init>(sun.net.ftp.impl.FtpClient, sun.net.ftp.FtpDirParser, java.io.BufferedReader):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public FtpFileIterator(sun.net.ftp.impl.FtpClient r1, sun.net.ftp.FtpDirParser r2, java.io.BufferedReader r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.<init>(sun.net.ftp.impl.FtpClient, sun.net.ftp.FtpDirParser, java.io.BufferedReader):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.FtpFileIterator.<init>(sun.net.ftp.impl.FtpClient, sun.net.ftp.FtpDirParser, java.io.BufferedReader):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.readNext():void, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.readNext():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.readNext():void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:73)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        private void readNext() {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.readNext():void, dex: classes.dex in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.readNext():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.FtpFileIterator.readNext():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.close():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void close() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.close():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.FtpFileIterator.close():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.hasNext():boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean hasNext() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.hasNext():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.FtpFileIterator.hasNext():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.next():java.lang.Object, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public /* bridge */ /* synthetic */ java.lang.Object next() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.next():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.FtpFileIterator.next():java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.next():sun.net.ftp.FtpDirEntry, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public sun.net.ftp.FtpDirEntry next() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.net.ftp.impl.FtpClient.FtpFileIterator.next():sun.net.ftp.FtpDirEntry, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.net.ftp.impl.FtpClient.FtpFileIterator.next():sun.net.ftp.FtpDirEntry");
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public sun.net.ftp.FtpClient useKerberos() throws FtpProtocolException, IOException {
        return this;
    }
}
