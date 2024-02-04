package java.lang;

import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;
import sun.misc.MessageUtils;
import sun.nio.cs.ArrayDecoder;
import sun.nio.cs.ArrayEncoder;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class StringCoding {
    private static final ThreadLocal<SoftReference<StringDecoder>> decoder = null;
    private static final ThreadLocal<SoftReference<StringEncoder>> encoder = null;
    private static boolean warnUnsupportedCharset;

    private static class StringDecoder {
        private final CharsetDecoder cd;
        private final Charset cs;
        private final boolean isTrusted;
        private final String requestedCharsetName;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.lang.StringCoding.StringDecoder.<init>(java.nio.charset.Charset, java.lang.String):void, dex: classes.dex
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
        private StringDecoder(java.nio.charset.Charset r1, java.lang.String r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.lang.StringCoding.StringDecoder.<init>(java.nio.charset.Charset, java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringDecoder.<init>(java.nio.charset.Charset, java.lang.String):void");
        }

        /* synthetic */ StringDecoder(Charset cs2, String rcn, StringDecoder stringDecoder) {
            this(cs2, rcn);
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringDecoder.charsetName():java.lang.String, dex: classes.dex
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
        java.lang.String charsetName() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringDecoder.charsetName():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringDecoder.charsetName():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus registerCount: 9 in method: java.lang.StringCoding.StringDecoder.decode(byte[], int, int):char[], dex: classes.dex in method: java.lang.StringCoding.StringDecoder.decode(byte[], int, int):char[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: bogus registerCount: 9 in method: java.lang.StringCoding.StringDecoder.decode(byte[], int, int):char[], dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: com.android.dex.DexException: bogus registerCount: 9
            	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:962)
            	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
            	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        char[] decode(byte[] r1, int r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus registerCount: 9 in method: java.lang.StringCoding.StringDecoder.decode(byte[], int, int):char[], dex: classes.dex in method: java.lang.StringCoding.StringDecoder.decode(byte[], int, int):char[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringDecoder.decode(byte[], int, int):char[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringDecoder.requestedCharsetName():java.lang.String, dex: classes.dex
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
        final java.lang.String requestedCharsetName() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringDecoder.requestedCharsetName():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringDecoder.requestedCharsetName():java.lang.String");
        }
    }

    private static class StringEncoder {
        private CharsetEncoder ce;
        private Charset cs;
        private final boolean isTrusted;
        private final String requestedCharsetName;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.lang.StringCoding.StringEncoder.<init>(java.nio.charset.Charset, java.lang.String):void, dex: classes.dex
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
        private StringEncoder(java.nio.charset.Charset r1, java.lang.String r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.lang.StringCoding.StringEncoder.<init>(java.nio.charset.Charset, java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringEncoder.<init>(java.nio.charset.Charset, java.lang.String):void");
        }

        /* synthetic */ StringEncoder(Charset cs2, String rcn, StringEncoder stringEncoder) {
            this(cs2, rcn);
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringEncoder.charsetName():java.lang.String, dex: classes.dex
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
        java.lang.String charsetName() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringEncoder.charsetName():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringEncoder.charsetName():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringEncoder.encode(char[], int, int):byte[], dex: classes.dex
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
        byte[] encode(char[] r1, int r2, int r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringEncoder.encode(char[], int, int):byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringEncoder.encode(char[], int, int):byte[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringEncoder.requestedCharsetName():java.lang.String, dex: classes.dex
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
        final java.lang.String requestedCharsetName() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.lang.StringCoding.StringEncoder.requestedCharsetName():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.StringCoding.StringEncoder.requestedCharsetName():java.lang.String");
        }
    }

    private StringCoding() {
    }

    private static <T> T deref(ThreadLocal<SoftReference<T>> tl) {
        SoftReference<T> sr = tl.get();
        if (sr == null) {
            return null;
        }
        return sr.get();
    }

    private static <T> void set(ThreadLocal<SoftReference<T>> tl, T ob) {
        tl.set(new SoftReference(ob));
    }

    /* access modifiers changed from: private */
    public static byte[] safeTrim(byte[] ba, int len, Charset cs, boolean isTrusted) {
        if (len != ba.length || !isTrusted) {
            return Arrays.copyOf(ba, len);
        }
        return ba;
    }

    /* access modifiers changed from: private */
    public static char[] safeTrim(char[] ca, int len, Charset cs, boolean isTrusted) {
        if (len != ca.length || !isTrusted) {
            return Arrays.copyOf(ca, len);
        }
        return ca;
    }

    /* access modifiers changed from: private */
    public static int scale(int len, float expansionFactor) {
        return (int) (((double) len) * ((double) expansionFactor));
    }

    private static Charset lookupCharset(String csn) {
        if (!Charset.isSupported(csn)) {
            return null;
        }
        try {
            return Charset.forName(csn);
        } catch (UnsupportedCharsetException x) {
            throw new Error((Throwable) x);
        }
    }

    private static void warnUnsupportedCharset(String csn) {
        if (warnUnsupportedCharset) {
            MessageUtils.err("WARNING: Default charset " + csn + " not supported, using ISO-8859-1 instead");
            warnUnsupportedCharset = false;
        }
    }

    static char[] decode(String charsetName, byte[] ba, int off, int len) throws UnsupportedEncodingException {
        StringDecoder sd = (StringDecoder) deref(decoder);
        String csn = charsetName == null ? "ISO-8859-1" : charsetName;
        if (sd == null || (!csn.equals(sd.requestedCharsetName()) && !csn.equals(sd.charsetName()))) {
            sd = null;
            try {
                Charset cs = lookupCharset(csn);
                if (cs != null) {
                    sd = new StringDecoder(cs, csn, (StringDecoder) null);
                }
            } catch (IllegalCharsetNameException e) {
            }
            if (sd == null) {
                throw new UnsupportedEncodingException(csn);
            }
            set(decoder, sd);
        }
        return sd.decode(ba, off, len);
    }

    static char[] decode(Charset cs, byte[] ba, int off, int len) {
        CharsetDecoder cd = cs.newDecoder();
        char[] ca = new char[scale(len, cd.maxCharsPerByte())];
        if (len == 0) {
            return ca;
        }
        boolean isTrusted = false;
        if (System.getSecurityManager() != null) {
            if (cs.getClass().getClassLoader() == null) {
                isTrusted = true;
            } else {
                isTrusted = false;
            }
            if (!isTrusted) {
                ba = Arrays.copyOfRange(ba, off, off + len);
                off = 0;
            }
        }
        cd.onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).reset();
        if (cd instanceof ArrayDecoder) {
            return safeTrim(ca, ((ArrayDecoder) cd).decode(ba, off, len, ca), cs, isTrusted);
        }
        ByteBuffer bb = ByteBuffer.wrap(ba, off, len);
        CharBuffer cb = CharBuffer.wrap(ca);
        try {
            CoderResult cr = cd.decode(bb, cb, true);
            if (!cr.isUnderflow()) {
                cr.throwException();
            }
            CoderResult cr2 = cd.flush(cb);
            if (!cr2.isUnderflow()) {
                cr2.throwException();
            }
            return safeTrim(ca, cb.position(), cs, isTrusted);
        } catch (CharacterCodingException x) {
            throw new Error((Throwable) x);
        }
    }

    static char[] decode(byte[] ba, int off, int len) {
        String csn = Charset.defaultCharset().name();
        try {
            return decode(csn, ba, off, len);
        } catch (UnsupportedEncodingException e) {
            warnUnsupportedCharset(csn);
            try {
                return decode("ISO-8859-1", ba, off, len);
            } catch (UnsupportedEncodingException x) {
                MessageUtils.err("ISO-8859-1 charset not available: " + x.toString());
                System.exit(1);
                return null;
            }
        }
    }

    static byte[] encode(String charsetName, char[] ca, int off, int len) throws UnsupportedEncodingException {
        StringEncoder se = (StringEncoder) deref(encoder);
        String csn = charsetName == null ? "ISO-8859-1" : charsetName;
        if (se == null || (!csn.equals(se.requestedCharsetName()) && !csn.equals(se.charsetName()))) {
            se = null;
            try {
                Charset cs = lookupCharset(csn);
                if (cs != null) {
                    se = new StringEncoder(cs, csn, (StringEncoder) null);
                }
            } catch (IllegalCharsetNameException e) {
            }
            if (se == null) {
                throw new UnsupportedEncodingException(csn);
            }
            set(encoder, se);
        }
        return se.encode(ca, off, len);
    }

    static byte[] encode(Charset cs, char[] ca, int off, int len) {
        CharsetEncoder ce = cs.newEncoder();
        byte[] ba = new byte[scale(len, ce.maxBytesPerChar())];
        if (len == 0) {
            return ba;
        }
        boolean isTrusted = false;
        if (System.getSecurityManager() != null) {
            if (cs.getClass().getClassLoader() == null) {
                isTrusted = true;
            } else {
                isTrusted = false;
            }
            if (!isTrusted) {
                ca = Arrays.copyOfRange(ca, off, off + len);
                off = 0;
            }
        }
        ce.onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).reset();
        if (ce instanceof ArrayEncoder) {
            return safeTrim(ba, ((ArrayEncoder) ce).encode(ca, off, len, ba), cs, isTrusted);
        }
        ByteBuffer bb = ByteBuffer.wrap(ba);
        try {
            CoderResult cr = ce.encode(CharBuffer.wrap(ca, off, len).asReadOnlyBuffer(), bb, true);
            if (!cr.isUnderflow()) {
                cr.throwException();
            }
            CoderResult cr2 = ce.flush(bb);
            if (!cr2.isUnderflow()) {
                cr2.throwException();
            }
            return safeTrim(ba, bb.position(), cs, isTrusted);
        } catch (CharacterCodingException x) {
            throw new Error((Throwable) x);
        }
    }

    static byte[] encode(Charset cs, String str) {
        ByteBuffer buffer = cs.encode(str);
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        return bytes;
    }

    static byte[] encode(char[] ca, int off, int len) {
        String csn = Charset.defaultCharset().name();
        try {
            return encode(csn, ca, off, len);
        } catch (UnsupportedEncodingException e) {
            warnUnsupportedCharset(csn);
            try {
                return encode("ISO-8859-1", ca, off, len);
            } catch (UnsupportedEncodingException x) {
                MessageUtils.err("ISO-8859-1 charset not available: " + x.toString());
                System.exit(1);
                return null;
            }
        }
    }
}
