package sun.misc;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class BASE64Encoder extends CharacterEncoder {
    private static final char[] pem_array = null;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.BASE64Encoder.encodeAtom(java.io.OutputStream, byte[], int, int):void, dex: classes.dex
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
    protected void encodeAtom(java.io.OutputStream r1, byte[] r2, int r3, int r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.BASE64Encoder.encodeAtom(java.io.OutputStream, byte[], int, int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.BASE64Encoder.encodeAtom(java.io.OutputStream, byte[], int, int):void");
    }

    /* access modifiers changed from: protected */
    public int bytesPerAtom() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public int bytesPerLine() {
        return 57;
    }
}
