package javax.crypto.spec;

import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class DESKeySpec implements KeySpec {
    public static final int DES_KEY_LEN = 8;
    private static final byte[][] WEAK_KEYS = null;
    private byte[] key;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: javax.crypto.spec.DESKeySpec.<init>(byte[]):void, dex: classes.dex
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
    public DESKeySpec(byte[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: javax.crypto.spec.DESKeySpec.<init>(byte[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.spec.DESKeySpec.<init>(byte[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: javax.crypto.spec.DESKeySpec.<init>(byte[], int):void, dex: classes.dex
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
    public DESKeySpec(byte[] r1, int r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: javax.crypto.spec.DESKeySpec.<init>(byte[], int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.spec.DESKeySpec.<init>(byte[], int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: javax.crypto.spec.DESKeySpec.getKey():byte[], dex: classes.dex
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
    public byte[] getKey() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: javax.crypto.spec.DESKeySpec.getKey():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.spec.DESKeySpec.getKey():byte[]");
    }

    public static boolean isParityAdjusted(byte[] key2, int offset) throws InvalidKeyException {
        if (key2 == null) {
            throw new InvalidKeyException("null key");
        } else if (key2.length - offset < 8) {
            throw new InvalidKeyException("Wrong key size");
        } else {
            int i = 0;
            int offset2 = offset;
            while (i < 8) {
                int offset3 = offset2 + 1;
                if ((Integer.bitCount(key2[offset2] & Character.DIRECTIONALITY_UNDEFINED) & 1) == 0) {
                    return false;
                }
                i++;
                offset2 = offset3;
            }
            return true;
        }
    }

    public static boolean isWeak(byte[] key2, int offset) throws InvalidKeyException {
        if (key2 == null) {
            throw new InvalidKeyException("null key");
        } else if (key2.length - offset < 8) {
            throw new InvalidKeyException("Wrong key size");
        } else {
            for (int i = 0; i < WEAK_KEYS.length; i++) {
                boolean found = true;
                for (int j = 0; j < 8 && found; j++) {
                    if (WEAK_KEYS[i][j] != key2[j + offset]) {
                        found = false;
                    }
                }
                if (found) {
                    return found;
                }
            }
            return false;
        }
    }
}
