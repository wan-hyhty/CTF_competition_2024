package java.sql;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class Types {
    public static final int ARRAY = 2003;
    public static final int BIGINT = -5;
    public static final int BINARY = -2;
    public static final int BIT = -7;
    public static final int BLOB = 2004;
    public static final int BOOLEAN = 16;
    public static final int CHAR = 1;
    public static final int CLOB = 2005;
    public static final int DATALINK = 70;
    public static final int DATE = 91;
    public static final int DECIMAL = 3;
    public static final int DISTINCT = 2001;
    public static final int DOUBLE = 8;
    public static final int FLOAT = 6;
    public static final int INTEGER = 4;
    public static final int JAVA_OBJECT = 2000;
    public static final int LONGNVARCHAR = -16;
    public static final int LONGVARBINARY = -4;
    public static final int LONGVARCHAR = -1;
    public static final int NCHAR = -15;
    public static final int NCLOB = 2011;
    public static final int NULL = 0;
    public static final int NUMERIC = 2;
    public static final int NVARCHAR = -9;
    public static final int OTHER = 1111;
    public static final int REAL = 7;
    public static final int REF = 2006;
    public static final int ROWID = -8;
    public static final int SMALLINT = 5;
    public static final int SQLXML = 2009;
    public static final int STRUCT = 2002;
    public static final int TIME = 92;
    public static final int TIMESTAMP = 93;
    public static final int TINYINT = -6;
    public static final int VARBINARY = -3;
    public static final int VARCHAR = 12;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.sql.Types.<init>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private Types() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.sql.Types.<init>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.sql.Types.<init>():void");
    }
}
