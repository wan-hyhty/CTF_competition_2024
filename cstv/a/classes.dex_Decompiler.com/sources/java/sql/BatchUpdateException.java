package java.sql;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class BatchUpdateException extends SQLException {
    private static final long serialVersionUID = 5977529877145521757L;
    private final int[] updateCounts;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.sql.BatchUpdateException.<init>(java.lang.String, java.lang.String, int, int[]):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public BatchUpdateException(java.lang.String r1, java.lang.String r2, int r3, int[] r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.sql.BatchUpdateException.<init>(java.lang.String, java.lang.String, int, int[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.sql.BatchUpdateException.<init>(java.lang.String, java.lang.String, int, int[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.sql.BatchUpdateException.<init>(java.lang.String, java.lang.String, int, int[], java.lang.Throwable):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public BatchUpdateException(java.lang.String r1, java.lang.String r2, int r3, int[] r4, java.lang.Throwable r5) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.sql.BatchUpdateException.<init>(java.lang.String, java.lang.String, int, int[], java.lang.Throwable):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.sql.BatchUpdateException.<init>(java.lang.String, java.lang.String, int, int[], java.lang.Throwable):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.sql.BatchUpdateException.<init>(java.lang.Throwable):void, dex: classes.dex
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
    public BatchUpdateException(java.lang.Throwable r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.sql.BatchUpdateException.<init>(java.lang.Throwable):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.sql.BatchUpdateException.<init>(java.lang.Throwable):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.sql.BatchUpdateException.<init>(int[], java.lang.Throwable):void, dex: classes.dex
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
    public BatchUpdateException(int[] r1, java.lang.Throwable r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.sql.BatchUpdateException.<init>(int[], java.lang.Throwable):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.sql.BatchUpdateException.<init>(int[], java.lang.Throwable):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.sql.BatchUpdateException.getUpdateCounts():int[], dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public int[] getUpdateCounts() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.sql.BatchUpdateException.getUpdateCounts():int[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.sql.BatchUpdateException.getUpdateCounts():int[]");
    }

    public BatchUpdateException(String reason, String SQLState, int[] updateCounts2) {
        this(reason, SQLState, 0, updateCounts2);
    }

    public BatchUpdateException(String reason, int[] updateCounts2) {
        this(reason, (String) null, 0, updateCounts2);
    }

    public BatchUpdateException(int[] updateCounts2) {
        this((String) null, (String) null, 0, updateCounts2);
    }

    public BatchUpdateException() {
        this((String) null, (String) null, 0, (int[]) null);
    }

    public BatchUpdateException(String reason, int[] updateCounts2, Throwable cause) {
        this(reason, (String) null, 0, updateCounts2, cause);
    }

    public BatchUpdateException(String reason, String SQLState, int[] updateCounts2, Throwable cause) {
        this(reason, SQLState, 0, updateCounts2, cause);
    }
}
