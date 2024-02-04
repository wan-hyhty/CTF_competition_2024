package java.util;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.Types;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import libcore.icu.LocaleData;
import sun.misc.FormattedFloatingDecimal;
import sun.misc.FpUtils;
import sun.net.www.protocol.http.AuthenticationInfo;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public final class Formatter implements Closeable, Flushable {
    private static final int MAX_FD_CHARS = 30;
    /* access modifiers changed from: private */
    public static double scaleUp;
    /* access modifiers changed from: private */
    public Appendable a;
    /* access modifiers changed from: private */
    public final Locale l;
    private IOException lastException;
    /* access modifiers changed from: private */
    public final char zero;

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum BigDecimalLayoutForm {
    }

    private interface FormatString {
        int index();

        void print(Object obj, Locale locale) throws IOException;

        String toString();
    }

    private static Charset toCharset(String csn) throws UnsupportedEncodingException {
        Objects.requireNonNull(csn, "charsetName");
        try {
            return Charset.forName(csn);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(csn);
        }
    }

    private static final Appendable nonNullAppendable(Appendable a2) {
        if (a2 == null) {
            return new StringBuilder();
        }
        return a2;
    }

    private Formatter(Locale l2, Appendable a2) {
        this.a = a2;
        this.l = l2;
        this.zero = getZero(l2);
    }

    private Formatter(Charset charset, Locale l2, File file) throws FileNotFoundException {
        this(l2, (Appendable) new BufferedWriter(new OutputStreamWriter((OutputStream) new FileOutputStream(file), charset)));
    }

    public Formatter() {
        this(Locale.getDefault(Locale.Category.FORMAT), (Appendable) new StringBuilder());
    }

    public Formatter(Appendable a2) {
        this(Locale.getDefault(Locale.Category.FORMAT), nonNullAppendable(a2));
    }

    public Formatter(Locale l2) {
        this(l2, (Appendable) new StringBuilder());
    }

    public Formatter(Appendable a2, Locale l2) {
        this(l2, nonNullAppendable(a2));
    }

    public Formatter(String fileName) throws FileNotFoundException {
        this(Locale.getDefault(Locale.Category.FORMAT), (Appendable) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))));
    }

    public Formatter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(fileName, csn, Locale.getDefault(Locale.Category.FORMAT));
    }

    public Formatter(String fileName, String csn, Locale l2) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), l2, new File(fileName));
    }

    public Formatter(File file) throws FileNotFoundException {
        this(Locale.getDefault(Locale.Category.FORMAT), (Appendable) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))));
    }

    public Formatter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(file, csn, Locale.getDefault(Locale.Category.FORMAT));
    }

    public Formatter(File file, String csn, Locale l2) throws FileNotFoundException, UnsupportedEncodingException {
        this(toCharset(csn), l2, file);
    }

    public Formatter(PrintStream ps) {
        this(Locale.getDefault(Locale.Category.FORMAT), (Appendable) Objects.requireNonNull(ps));
    }

    public Formatter(OutputStream os) {
        this(Locale.getDefault(Locale.Category.FORMAT), (Appendable) new BufferedWriter(new OutputStreamWriter(os)));
    }

    public Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault(Locale.Category.FORMAT));
    }

    public Formatter(OutputStream os, String csn, Locale l2) throws UnsupportedEncodingException {
        this(l2, (Appendable) new BufferedWriter(new OutputStreamWriter(os, csn)));
    }

    private static char getZero(Locale l2) {
        if (l2 == null || l2.equals(Locale.US)) {
            return '0';
        }
        return DecimalFormatSymbols.getInstance(l2).getZeroDigit();
    }

    public Locale locale() {
        ensureOpen();
        return this.l;
    }

    public Appendable out() {
        ensureOpen();
        return this.a;
    }

    public String toString() {
        ensureOpen();
        return this.a.toString();
    }

    public void flush() {
        ensureOpen();
        if (this.a instanceof Flushable) {
            try {
                ((Flushable) this.a).flush();
            } catch (IOException ioe) {
                this.lastException = ioe;
            }
        }
    }

    public void close() {
        if (this.a != null) {
            try {
                if (this.a instanceof Closeable) {
                    ((Closeable) this.a).close();
                }
            } catch (IOException ioe) {
                this.lastException = ioe;
            } catch (Throwable th) {
                this.a = null;
                throw th;
            }
            this.a = null;
        }
    }

    private void ensureOpen() {
        if (this.a == null) {
            throw new FormatterClosedException();
        }
    }

    public IOException ioException() {
        return this.lastException;
    }

    public Formatter format(String format, Object... args) {
        return format(this.l, format, args);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Formatter format(java.util.Locale r11, java.lang.String r12, java.lang.Object... r13) {
        /*
            r10 = this;
            r8 = 0
            r10.ensureOpen()
            r4 = -1
            r5 = -1
            java.util.Formatter$FormatString[] r1 = r10.parse(r12)
            r2 = 0
        L_0x000b:
            int r7 = r1.length
            if (r2 >= r7) goto L_0x007a
            r0 = r1[r2]
            int r3 = r0.index()
            switch(r3) {
                case -2: goto L_0x0030;
                case -1: goto L_0x0035;
                case 0: goto L_0x0052;
                default: goto L_0x0017;
            }
        L_0x0017:
            int r4 = r3 + -1
            if (r13 == 0) goto L_0x0070
            int r7 = r13.length     // Catch:{ IOException -> 0x002a }
            int r7 = r7 + -1
            if (r4 <= r7) goto L_0x0070
            java.util.MissingFormatArgumentException r7 = new java.util.MissingFormatArgumentException     // Catch:{ IOException -> 0x002a }
            java.lang.String r9 = r0.toString()     // Catch:{ IOException -> 0x002a }
            r7.<init>(r9)     // Catch:{ IOException -> 0x002a }
            throw r7     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            r6 = move-exception
            r10.lastException = r6
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0030:
            r7 = 0
            r0.print(r7, r11)     // Catch:{ IOException -> 0x002a }
            goto L_0x002d
        L_0x0035:
            if (r4 < 0) goto L_0x003e
            if (r13 == 0) goto L_0x0048
            int r7 = r13.length     // Catch:{ IOException -> 0x002a }
            int r7 = r7 + -1
            if (r4 <= r7) goto L_0x0048
        L_0x003e:
            java.util.MissingFormatArgumentException r7 = new java.util.MissingFormatArgumentException     // Catch:{ IOException -> 0x002a }
            java.lang.String r9 = r0.toString()     // Catch:{ IOException -> 0x002a }
            r7.<init>(r9)     // Catch:{ IOException -> 0x002a }
            throw r7     // Catch:{ IOException -> 0x002a }
        L_0x0048:
            if (r13 != 0) goto L_0x004f
            r7 = r8
        L_0x004b:
            r0.print(r7, r11)     // Catch:{ IOException -> 0x002a }
            goto L_0x002d
        L_0x004f:
            r7 = r13[r4]     // Catch:{ IOException -> 0x002a }
            goto L_0x004b
        L_0x0052:
            int r5 = r5 + 1
            r4 = r5
            if (r13 == 0) goto L_0x0066
            int r7 = r13.length     // Catch:{ IOException -> 0x002a }
            int r7 = r7 + -1
            if (r5 <= r7) goto L_0x0066
            java.util.MissingFormatArgumentException r7 = new java.util.MissingFormatArgumentException     // Catch:{ IOException -> 0x002a }
            java.lang.String r9 = r0.toString()     // Catch:{ IOException -> 0x002a }
            r7.<init>(r9)     // Catch:{ IOException -> 0x002a }
            throw r7     // Catch:{ IOException -> 0x002a }
        L_0x0066:
            if (r13 != 0) goto L_0x006d
            r7 = r8
        L_0x0069:
            r0.print(r7, r11)     // Catch:{ IOException -> 0x002a }
            goto L_0x002d
        L_0x006d:
            r7 = r13[r5]     // Catch:{ IOException -> 0x002a }
            goto L_0x0069
        L_0x0070:
            if (r13 != 0) goto L_0x0077
            r7 = r8
        L_0x0073:
            r0.print(r7, r11)     // Catch:{ IOException -> 0x002a }
            goto L_0x002d
        L_0x0077:
            r7 = r13[r4]     // Catch:{ IOException -> 0x002a }
            goto L_0x0073
        L_0x007a:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.format(java.util.Locale, java.lang.String, java.lang.Object[]):java.util.Formatter");
    }

    private FormatString[] parse(String s) {
        ArrayList<FormatString> al = new ArrayList<>();
        int i = 0;
        int len = s.length();
        while (i < len) {
            int nextPercent = s.indexOf(37, i);
            if (s.charAt(i) != '%') {
                int plainTextStart = i;
                int plainTextEnd = nextPercent == -1 ? len : nextPercent;
                al.add(new FixedString(s.substring(plainTextStart, plainTextEnd)));
                i = plainTextEnd;
            } else {
                FormatSpecifierParser fsp = new FormatSpecifierParser(s, i + 1);
                al.add(fsp.getFormatSpecifier());
                i = fsp.getEndIdx();
            }
        }
        return (FormatString[]) al.toArray(new FormatString[al.size()]);
    }

    private class FormatSpecifierParser {
        private static final String FLAGS = ",-(+# 0<";
        private String conv;
        private int cursor;
        private String flags;
        private final String format;
        private FormatSpecifier fs;
        private String index;
        private String precision;
        private String tT;
        private String width;

        public FormatSpecifierParser(String format2, int startIdx) {
            this.format = format2;
            this.cursor = startIdx;
            if (nextIsInt()) {
                String nint = nextInt();
                if (peek() == '$') {
                    this.index = nint;
                    advance();
                } else if (nint.charAt(0) == '0') {
                    back(nint.length());
                } else {
                    this.width = nint;
                }
            }
            this.flags = "";
            while (this.width == null && FLAGS.indexOf((int) peek()) >= 0) {
                this.flags += advance();
            }
            if (this.width == null && nextIsInt()) {
                this.width = nextInt();
            }
            if (peek() == '.') {
                advance();
                if (!nextIsInt()) {
                    throw new IllegalFormatPrecisionException(peek());
                }
                this.precision = nextInt();
            }
            if (peek() == 't' || peek() == 'T') {
                this.tT = String.valueOf(advance());
            }
            this.conv = String.valueOf(advance());
            this.fs = new FormatSpecifier(this.index, this.flags, this.width, this.precision, this.tT, this.conv);
        }

        private String nextInt() {
            int strBegin = this.cursor;
            while (nextIsInt()) {
                advance();
            }
            return this.format.substring(strBegin, this.cursor);
        }

        private boolean nextIsInt() {
            if (!isEnd()) {
                return Character.isDigit(peek());
            }
            return false;
        }

        private char peek() {
            if (!isEnd()) {
                return this.format.charAt(this.cursor);
            }
            throw new UnknownFormatConversionException("End of String");
        }

        private char advance() {
            if (isEnd()) {
                throw new UnknownFormatConversionException("End of String");
            }
            String str = this.format;
            int i = this.cursor;
            this.cursor = i + 1;
            return str.charAt(i);
        }

        private void back(int len) {
            this.cursor -= len;
        }

        private boolean isEnd() {
            return this.cursor == this.format.length();
        }

        public FormatSpecifier getFormatSpecifier() {
            return this.fs;
        }

        public int getEndIdx() {
            return this.cursor;
        }
    }

    private class FixedString implements FormatString {
        private String s;

        FixedString(String s2) {
            this.s = s2;
        }

        public int index() {
            return -2;
        }

        public void print(Object arg, Locale l) throws IOException {
            Formatter.this.a.append((CharSequence) this.s);
        }

        public String toString() {
            return this.s;
        }
    }

    private class FormatSpecifier implements FormatString {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f39assertionsDisabled = false;
        final /* synthetic */ boolean $assertionsDisabled;
        private char c;
        private boolean dt;
        private Flags f;
        private int index;
        private int precision;
        private int width;

        private class BigDecimalLayout {
            private boolean dot;
            private StringBuilder exp;
            private StringBuilder mant;
            private int scale;
            final /* synthetic */ FormatSpecifier this$1;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.<init>(java.util.Formatter$FormatSpecifier, java.math.BigInteger, int, java.util.Formatter$BigDecimalLayoutForm):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public BigDecimalLayout(java.util.Formatter.FormatSpecifier r1, java.math.BigInteger r2, int r3, java.util.Formatter.BigDecimalLayoutForm r4) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.<init>(java.util.Formatter$FormatSpecifier, java.math.BigInteger, int, java.util.Formatter$BigDecimalLayoutForm):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.<init>(java.util.Formatter$FormatSpecifier, java.math.BigInteger, int, java.util.Formatter$BigDecimalLayoutForm):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.layout(java.math.BigInteger, int, java.util.Formatter$BigDecimalLayoutForm):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            private void layout(java.math.BigInteger r1, int r2, java.util.Formatter.BigDecimalLayoutForm r3) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.layout(java.math.BigInteger, int, java.util.Formatter$BigDecimalLayoutForm):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.layout(java.math.BigInteger, int, java.util.Formatter$BigDecimalLayoutForm):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.toCharArray(java.lang.StringBuilder):char[], dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            private char[] toCharArray(java.lang.StringBuilder r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.toCharArray(java.lang.StringBuilder):char[], dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.toCharArray(java.lang.StringBuilder):char[]");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.exponent():char[], dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public char[] exponent() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.exponent():char[], dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.exponent():char[]");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.hasDot():boolean, dex: classes.dex in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.hasDot():boolean, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.hasDot():boolean, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
                	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            public boolean hasDot() {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.hasDot():boolean, dex: classes.dex in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.hasDot():boolean, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.hasDot():boolean");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.layoutChars():char[], dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public char[] layoutChars() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.layoutChars():char[], dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.layoutChars():char[]");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.mantissa():char[], dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 7 more
                */
            public char[] mantissa() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.mantissa():char[], dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.mantissa():char[]");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.scale():int, dex: classes.dex in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.scale():int, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.scale():int, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 7 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
                	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 8 more
                */
            public int scale() {
                /*
                // Can't load method instructions: Load method exception: null in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.scale():int, dex: classes.dex in method: java.util.Formatter.FormatSpecifier.BigDecimalLayout.scale():int, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.BigDecimalLayout.scale():int");
            }
        }

        private int index(String s) {
            if (s != null) {
                try {
                    this.index = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    if (!f39assertionsDisabled) {
                        throw new AssertionError();
                    }
                }
            } else {
                this.index = 0;
            }
            return this.index;
        }

        public int index() {
            return this.index;
        }

        private Flags flags(String s) {
            this.f = Flags.parse(s);
            if (this.f.contains(Flags.PREVIOUS)) {
                this.index = -1;
            }
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public Flags flags() {
            return this.f;
        }

        private int width(String s) {
            this.width = -1;
            if (s != null) {
                try {
                    this.width = Integer.parseInt(s);
                    if (this.width < 0) {
                        throw new IllegalFormatWidthException(this.width);
                    }
                } catch (NumberFormatException e) {
                    if (!f39assertionsDisabled) {
                        throw new AssertionError();
                    }
                }
            }
            return this.width;
        }

        /* access modifiers changed from: package-private */
        public int width() {
            return this.width;
        }

        private int precision(String s) {
            this.precision = -1;
            if (s != null) {
                try {
                    this.precision = Integer.parseInt(s);
                    if (this.precision < 0) {
                        throw new IllegalFormatPrecisionException(this.precision);
                    }
                } catch (NumberFormatException e) {
                    if (!f39assertionsDisabled) {
                        throw new AssertionError();
                    }
                }
            }
            return this.precision;
        }

        /* access modifiers changed from: package-private */
        public int precision() {
            return this.precision;
        }

        private char conversion(String s) {
            this.c = s.charAt(0);
            if (!this.dt) {
                if (!Conversion.isValid(this.c)) {
                    throw new UnknownFormatConversionException(String.valueOf(this.c));
                }
                if (Character.isUpperCase(this.c)) {
                    Flags unused = this.f.add(Flags.UPPERCASE);
                }
                this.c = Character.toLowerCase(this.c);
                if (Conversion.isText(this.c)) {
                    this.index = -2;
                }
            }
            return this.c;
        }

        private char conversion() {
            return this.c;
        }

        FormatSpecifier(String indexStr, String flagsStr, String widthStr, String precisionStr, String tTStr, String convStr) {
            this.index = -1;
            this.f = Flags.NONE;
            this.dt = false;
            index(indexStr);
            flags(flagsStr);
            width(widthStr);
            precision(precisionStr);
            if (tTStr != null) {
                this.dt = true;
                if (tTStr.equals("T")) {
                    Flags unused = this.f.add(Flags.UPPERCASE);
                }
            }
            conversion(convStr);
            if (this.dt) {
                checkDateTime();
            } else if (Conversion.isGeneral(this.c)) {
                checkGeneral();
            } else if (Conversion.isCharacter(this.c)) {
                checkCharacter();
            } else if (Conversion.isInteger(this.c)) {
                checkInteger();
            } else if (Conversion.isFloat(this.c)) {
                checkFloat();
            } else if (Conversion.isText(this.c)) {
                checkText();
            } else {
                throw new UnknownFormatConversionException(String.valueOf(this.c));
            }
        }

        public void print(Object arg, Locale l) throws IOException {
            if (this.dt) {
                printDateTime(arg, l);
                return;
            }
            switch (this.c) {
                case '%':
                    Formatter.this.a.append('%');
                    return;
                case 'C':
                case 'c':
                    printCharacter(arg);
                    return;
                case 'a':
                case 'e':
                case 'f':
                case 'g':
                    printFloat(arg, l);
                    return;
                case 'b':
                    printBoolean(arg);
                    return;
                case 'd':
                case 'o':
                case 'x':
                    printInteger(arg, l);
                    return;
                case 'h':
                    printHashCode(arg);
                    return;
                case 'n':
                    Formatter.this.a.append((CharSequence) System.lineSeparator());
                    return;
                case 's':
                    printString(arg, l);
                    return;
                default:
                    if (!f39assertionsDisabled) {
                        throw new AssertionError();
                    }
                    return;
            }
        }

        private void printInteger(Object arg, Locale l) throws IOException {
            if (arg == null) {
                print("null");
            } else if (arg instanceof Byte) {
                print(((Byte) arg).byteValue(), l);
            } else if (arg instanceof Short) {
                print(((Short) arg).shortValue(), l);
            } else if (arg instanceof Integer) {
                print(((Integer) arg).intValue(), l);
            } else if (arg instanceof Long) {
                print(((Long) arg).longValue(), l);
            } else if (arg instanceof BigInteger) {
                print((BigInteger) arg, l);
            } else {
                failConversion(this.c, arg);
            }
        }

        private void printFloat(Object arg, Locale l) throws IOException {
            if (arg == null) {
                print("null");
            } else if (arg instanceof Float) {
                print(((Float) arg).floatValue(), l);
            } else if (arg instanceof Double) {
                print(((Double) arg).doubleValue(), l);
            } else if (arg instanceof BigDecimal) {
                print((BigDecimal) arg, l);
            } else {
                failConversion(this.c, arg);
            }
        }

        private void printDateTime(Object arg, Locale l) throws IOException {
            Locale locale;
            Locale locale2;
            if (arg == null) {
                print("null");
                return;
            }
            Calendar cal = null;
            if (arg instanceof Long) {
                if (l == null) {
                    locale2 = Locale.US;
                } else {
                    locale2 = l;
                }
                cal = Calendar.getInstance(locale2);
                cal.setTimeInMillis(((Long) arg).longValue());
            } else if (arg instanceof Date) {
                if (l == null) {
                    locale = Locale.US;
                } else {
                    locale = l;
                }
                cal = Calendar.getInstance(locale);
                cal.setTime((Date) arg);
            } else if (arg instanceof Calendar) {
                cal = (Calendar) ((Calendar) arg).clone();
                cal.setLenient(true);
            } else {
                failConversion(this.c, arg);
            }
            print(cal, this.c, l);
        }

        private void printCharacter(Object arg) throws IOException {
            if (arg == null) {
                print("null");
                return;
            }
            String s = null;
            if (arg instanceof Character) {
                s = ((Character) arg).toString();
            } else if (arg instanceof Byte) {
                byte i = ((Byte) arg).byteValue();
                if (Character.isValidCodePoint(i)) {
                    s = new String(Character.toChars(i));
                } else {
                    throw new IllegalFormatCodePointException(i);
                }
            } else if (arg instanceof Short) {
                short i2 = ((Short) arg).shortValue();
                if (Character.isValidCodePoint(i2)) {
                    s = new String(Character.toChars(i2));
                } else {
                    throw new IllegalFormatCodePointException(i2);
                }
            } else if (arg instanceof Integer) {
                int i3 = ((Integer) arg).intValue();
                if (Character.isValidCodePoint(i3)) {
                    s = new String(Character.toChars(i3));
                } else {
                    throw new IllegalFormatCodePointException(i3);
                }
            } else {
                failConversion(this.c, arg);
            }
            print(s);
        }

        private void printString(Object arg, Locale l) throws IOException {
            if (arg instanceof Formattable) {
                Formatter fmt = Formatter.this;
                if (fmt.locale() != l) {
                    fmt = new Formatter(fmt.out(), l);
                }
                ((Formattable) arg).formatTo(fmt, this.f.valueOf(), this.width, this.precision);
                return;
            }
            if (this.f.contains(Flags.ALTERNATE)) {
                failMismatch(Flags.ALTERNATE, AuthenticationInfo.SERVER_AUTHENTICATION);
            }
            if (arg == null) {
                print("null");
            } else {
                print(arg.toString());
            }
        }

        private void printBoolean(Object arg) throws IOException {
            String s;
            if (arg == null) {
                s = Boolean.toString(false);
            } else if (arg instanceof Boolean) {
                s = ((Boolean) arg).toString();
            } else {
                s = Boolean.toString(true);
            }
            print(s);
        }

        private void printHashCode(Object arg) throws IOException {
            String s;
            if (arg == null) {
                s = "null";
            } else {
                s = Integer.toHexString(arg.hashCode());
            }
            print(s);
        }

        private void print(String s) throws IOException {
            if (this.precision != -1 && this.precision < s.length()) {
                s = s.substring(0, this.precision);
            }
            if (this.f.contains(Flags.UPPERCASE)) {
                s = s.toUpperCase(Formatter.this.l != null ? Formatter.this.l : Locale.getDefault());
            }
            Formatter.this.a.append((CharSequence) justify(s));
        }

        private String justify(String s) {
            if (this.width == -1) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            boolean pad = this.f.contains(Flags.LEFT_JUSTIFY);
            int sp = this.width - s.length();
            if (!pad) {
                for (int i = 0; i < sp; i++) {
                    sb.append(' ');
                }
            }
            sb.append(s);
            if (pad) {
                for (int i2 = 0; i2 < sp; i2++) {
                    sb.append(' ');
                }
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("%");
            sb.append(this.f.dup().remove(Flags.UPPERCASE).toString());
            if (this.index > 0) {
                sb.append(this.index).append('$');
            }
            if (this.width != -1) {
                sb.append(this.width);
            }
            if (this.precision != -1) {
                sb.append('.').append(this.precision);
            }
            if (this.dt) {
                sb.append(this.f.contains(Flags.UPPERCASE) ? 'T' : 't');
            }
            sb.append(this.f.contains(Flags.UPPERCASE) ? Character.toUpperCase(this.c) : this.c);
            return sb.toString();
        }

        private void checkGeneral() {
            if ((this.c == 'b' || this.c == 'h') && this.f.contains(Flags.ALTERNATE)) {
                failMismatch(Flags.ALTERNATE, this.c);
            }
            if (this.width != -1 || !this.f.contains(Flags.LEFT_JUSTIFY)) {
                checkBadFlags(Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES);
                return;
            }
            throw new MissingFormatWidthException(toString());
        }

        private void checkDateTime() {
            if (this.precision != -1) {
                throw new IllegalFormatPrecisionException(this.precision);
            } else if (!DateTime.isValid(this.c)) {
                throw new UnknownFormatConversionException("t" + this.c);
            } else {
                checkBadFlags(Flags.ALTERNATE, Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES);
                if (this.width == -1 && this.f.contains(Flags.LEFT_JUSTIFY)) {
                    throw new MissingFormatWidthException(toString());
                }
            }
        }

        private void checkCharacter() {
            if (this.precision != -1) {
                throw new IllegalFormatPrecisionException(this.precision);
            }
            checkBadFlags(Flags.ALTERNATE, Flags.PLUS, Flags.LEADING_SPACE, Flags.ZERO_PAD, Flags.GROUP, Flags.PARENTHESES);
            if (this.width == -1 && this.f.contains(Flags.LEFT_JUSTIFY)) {
                throw new MissingFormatWidthException(toString());
            }
        }

        private void checkInteger() {
            checkNumeric();
            if (this.precision != -1) {
                throw new IllegalFormatPrecisionException(this.precision);
            } else if (this.c == 'd') {
                checkBadFlags(Flags.ALTERNATE);
            } else if (this.c == 'o') {
                checkBadFlags(Flags.GROUP);
            } else {
                checkBadFlags(Flags.GROUP);
            }
        }

        private void checkBadFlags(Flags... badFlags) {
            for (int i = 0; i < badFlags.length; i++) {
                if (this.f.contains(badFlags[i])) {
                    failMismatch(badFlags[i], this.c);
                }
            }
        }

        private void checkFloat() {
            checkNumeric();
            if (this.c != 'f') {
                if (this.c == 'a') {
                    checkBadFlags(Flags.PARENTHESES, Flags.GROUP);
                } else if (this.c == 'e') {
                    checkBadFlags(Flags.GROUP);
                } else if (this.c == 'g') {
                    checkBadFlags(Flags.ALTERNATE);
                }
            }
        }

        private void checkNumeric() {
            if (this.width != -1 && this.width < 0) {
                throw new IllegalFormatWidthException(this.width);
            } else if (this.precision != -1 && this.precision < 0) {
                throw new IllegalFormatPrecisionException(this.precision);
            } else if (this.width == -1 && (this.f.contains(Flags.LEFT_JUSTIFY) || this.f.contains(Flags.ZERO_PAD))) {
                throw new MissingFormatWidthException(toString());
            } else if ((this.f.contains(Flags.PLUS) && this.f.contains(Flags.LEADING_SPACE)) || (this.f.contains(Flags.LEFT_JUSTIFY) && this.f.contains(Flags.ZERO_PAD))) {
                throw new IllegalFormatFlagsException(this.f.toString());
            }
        }

        private void checkText() {
            if (this.precision != -1) {
                throw new IllegalFormatPrecisionException(this.precision);
            }
            switch (this.c) {
                case '%':
                    if (this.f.valueOf() != Flags.LEFT_JUSTIFY.valueOf() && this.f.valueOf() != Flags.NONE.valueOf()) {
                        throw new IllegalFormatFlagsException(this.f.toString());
                    } else if (this.width == -1 && this.f.contains(Flags.LEFT_JUSTIFY)) {
                        throw new MissingFormatWidthException(toString());
                    } else {
                        return;
                    }
                case 'n':
                    if (this.width != -1) {
                        throw new IllegalFormatWidthException(this.width);
                    } else if (this.f.valueOf() != Flags.NONE.valueOf()) {
                        throw new IllegalFormatFlagsException(this.f.toString());
                    } else {
                        return;
                    }
                default:
                    if (!f39assertionsDisabled) {
                        throw new AssertionError();
                    }
                    return;
            }
        }

        private void print(byte value, Locale l) throws IOException {
            boolean z = false;
            long v = (long) value;
            if (value < 0 && (this.c == 'o' || this.c == 'x')) {
                v += 256;
                if (!f39assertionsDisabled) {
                    if (v >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError((Object) Long.valueOf(v));
                    }
                }
            }
            print(v, l);
        }

        private void print(short value, Locale l) throws IOException {
            boolean z = false;
            long v = (long) value;
            if (value < 0 && (this.c == 'o' || this.c == 'x')) {
                v += 65536;
                if (!f39assertionsDisabled) {
                    if (v >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError((Object) Long.valueOf(v));
                    }
                }
            }
            print(v, l);
        }

        private void print(int value, Locale l) throws IOException {
            boolean z = false;
            long v = (long) value;
            if (value < 0 && (this.c == 'o' || this.c == 'x')) {
                v += 4294967296L;
                if (!f39assertionsDisabled) {
                    if (v >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError((Object) Long.valueOf(v));
                    }
                }
            }
            print(v, l);
        }

        private void print(long value, Locale l) throws IOException {
            int len;
            int len2;
            char[] va;
            StringBuilder sb = new StringBuilder();
            if (this.c == 'd') {
                boolean neg = value < 0;
                if (value < 0) {
                    va = Long.toString(value, 10).substring(1).toCharArray();
                } else {
                    va = Long.toString(value, 10).toCharArray();
                }
                leadingSign(sb, neg);
                localizedMagnitude(sb, va, this.f, adjustWidth(this.width, this.f, neg), l);
                trailingSign(sb, neg);
            } else if (this.c == 'o') {
                checkBadFlags(Flags.PARENTHESES, Flags.LEADING_SPACE, Flags.PLUS);
                String s = Long.toOctalString(value);
                if (this.f.contains(Flags.ALTERNATE)) {
                    len2 = s.length() + 1;
                } else {
                    len2 = s.length();
                }
                if (this.f.contains(Flags.ALTERNATE)) {
                    sb.append('0');
                }
                if (this.f.contains(Flags.ZERO_PAD)) {
                    for (int i = 0; i < this.width - len2; i++) {
                        sb.append('0');
                    }
                }
                sb.append(s);
            } else if (this.c == 'x') {
                checkBadFlags(Flags.PARENTHESES, Flags.LEADING_SPACE, Flags.PLUS);
                String s2 = Long.toHexString(value);
                if (this.f.contains(Flags.ALTERNATE)) {
                    len = s2.length() + 2;
                } else {
                    len = s2.length();
                }
                if (this.f.contains(Flags.ALTERNATE)) {
                    sb.append(this.f.contains(Flags.UPPERCASE) ? "0X" : "0x");
                }
                if (this.f.contains(Flags.ZERO_PAD)) {
                    for (int i2 = 0; i2 < this.width - len; i2++) {
                        sb.append('0');
                    }
                }
                if (this.f.contains(Flags.UPPERCASE)) {
                    s2 = s2.toUpperCase();
                }
                sb.append(s2);
            }
            Formatter.this.a.append((CharSequence) justify(sb.toString()));
        }

        private StringBuilder leadingSign(StringBuilder sb, boolean neg) {
            if (!neg) {
                if (this.f.contains(Flags.PLUS)) {
                    sb.append('+');
                } else if (this.f.contains(Flags.LEADING_SPACE)) {
                    sb.append(' ');
                }
            } else if (this.f.contains(Flags.PARENTHESES)) {
                sb.append('(');
            } else {
                sb.append('-');
            }
            return sb;
        }

        private StringBuilder trailingSign(StringBuilder sb, boolean neg) {
            if (neg && this.f.contains(Flags.PARENTHESES)) {
                sb.append(')');
            }
            return sb;
        }

        private void print(BigInteger value, Locale l) throws IOException {
            StringBuilder sb = new StringBuilder();
            boolean neg = value.signum() == -1;
            BigInteger v = value.abs();
            leadingSign(sb, neg);
            if (this.c == 'd') {
                localizedMagnitude(sb, v.toString().toCharArray(), this.f, adjustWidth(this.width, this.f, neg), l);
            } else if (this.c == 'o') {
                String s = v.toString(8);
                int len = s.length() + sb.length();
                if (neg && this.f.contains(Flags.PARENTHESES)) {
                    len++;
                }
                if (this.f.contains(Flags.ALTERNATE)) {
                    len++;
                    sb.append('0');
                }
                if (this.f.contains(Flags.ZERO_PAD)) {
                    for (int i = 0; i < this.width - len; i++) {
                        sb.append('0');
                    }
                }
                sb.append(s);
            } else if (this.c == 'x') {
                String s2 = v.toString(16);
                int len2 = s2.length() + sb.length();
                if (neg && this.f.contains(Flags.PARENTHESES)) {
                    len2++;
                }
                if (this.f.contains(Flags.ALTERNATE)) {
                    len2 += 2;
                    sb.append(this.f.contains(Flags.UPPERCASE) ? "0X" : "0x");
                }
                if (this.f.contains(Flags.ZERO_PAD)) {
                    for (int i2 = 0; i2 < this.width - len2; i2++) {
                        sb.append('0');
                    }
                }
                if (this.f.contains(Flags.UPPERCASE)) {
                    s2 = s2.toUpperCase();
                }
                sb.append(s2);
            }
            trailingSign(sb, value.signum() == -1);
            Formatter.this.a.append((CharSequence) justify(sb.toString()));
        }

        private void print(float value, Locale l) throws IOException {
            print((double) value, l);
        }

        private void print(double value, Locale l) throws IOException {
            StringBuilder sb = new StringBuilder();
            boolean neg = Double.compare(value, 0.0d) == -1;
            if (!Double.isNaN(value)) {
                double v = Math.abs(value);
                leadingSign(sb, neg);
                if (!Double.isInfinite(v)) {
                    print(sb, v, l, this.f, this.c, this.precision, neg);
                } else {
                    sb.append(this.f.contains(Flags.UPPERCASE) ? "INFINITY" : "Infinity");
                }
                trailingSign(sb, neg);
            } else {
                sb.append(this.f.contains(Flags.UPPERCASE) ? "NAN" : "NaN");
            }
            Formatter.this.a.append((CharSequence) justify(sb.toString()));
        }

        private void print(StringBuilder sb, double value, Locale l, Flags f2, char c2, int precision2, boolean neg) throws IOException {
            int prec;
            boolean z;
            String lowerCase;
            boolean z2;
            if (c2 == 'e') {
                int prec2 = precision2 == -1 ? 6 : precision2;
                char[] v = new char[30];
                int len = new FormattedFloatingDecimal(value, prec2, FormattedFloatingDecimal.Form.SCIENTIFIC).getChars(v);
                char[] mant = addZeros(mantissa(v, len), prec2);
                if (f2.contains(Flags.ALTERNATE) && prec2 == 0) {
                    mant = addDot(mant);
                }
                char[] exp = value == 0.0d ? new char[]{'+', '0', '0'} : exponent(v, len);
                int newW = this.width;
                if (this.width != -1) {
                    newW = adjustWidth((this.width - exp.length) - 1, f2, neg);
                }
                localizedMagnitude(sb, mant, f2, newW, l);
                Locale separatorLocale = l != null ? l : Locale.getDefault();
                LocaleData localeData = LocaleData.get(separatorLocale);
                if (f2.contains(Flags.UPPERCASE)) {
                    lowerCase = localeData.exponentSeparator.toUpperCase(separatorLocale);
                } else {
                    lowerCase = localeData.exponentSeparator.toLowerCase(separatorLocale);
                }
                sb.append(lowerCase);
                Flags flags = f2.dup().remove(Flags.GROUP);
                char sign = exp[0];
                if (!f39assertionsDisabled) {
                    if (sign == '+' || sign == '-') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                sb.append(sign);
                char[] tmp = new char[(exp.length - 1)];
                System.arraycopy(exp, 1, tmp, 0, exp.length - 1);
                sb.append((CharSequence) localizedMagnitude((StringBuilder) null, tmp, flags, -1, l));
            } else if (c2 == 'f') {
                int prec3 = precision2 == -1 ? 6 : precision2;
                FormattedFloatingDecimal formattedFloatingDecimal = new FormattedFloatingDecimal(value, prec3, FormattedFloatingDecimal.Form.DECIMAL_FLOAT);
                char[] v2 = new char[(Math.abs(formattedFloatingDecimal.getExponent()) + 31)];
                char[] mant2 = addZeros(mantissa(v2, formattedFloatingDecimal.getChars(v2)), prec3);
                if (f2.contains(Flags.ALTERNATE) && prec3 == 0) {
                    mant2 = addDot(mant2);
                }
                int newW2 = this.width;
                if (this.width != -1) {
                    newW2 = adjustWidth(this.width, f2, neg);
                }
                localizedMagnitude(sb, mant2, f2, newW2, l);
            } else if (c2 == 'g') {
                int prec4 = precision2;
                if (precision2 == -1) {
                    prec4 = 6;
                } else if (precision2 == 0) {
                    prec4 = 1;
                }
                FormattedFloatingDecimal formattedFloatingDecimal2 = new FormattedFloatingDecimal(value, prec4, FormattedFloatingDecimal.Form.GENERAL);
                char[] v3 = new char[(Math.abs(formattedFloatingDecimal2.getExponent()) + 31)];
                int len2 = formattedFloatingDecimal2.getChars(v3);
                char[] exp2 = exponent(v3, len2);
                if (exp2 != null) {
                    prec = prec4 - 1;
                } else {
                    prec = (prec4 - (value == 0.0d ? 0 : formattedFloatingDecimal2.getExponentRounded())) - 1;
                }
                char[] mant3 = addZeros(mantissa(v3, len2), prec);
                if (f2.contains(Flags.ALTERNATE) && prec == 0) {
                    mant3 = addDot(mant3);
                }
                int newW3 = this.width;
                if (this.width != -1) {
                    if (exp2 != null) {
                        newW3 = adjustWidth((this.width - exp2.length) - 1, f2, neg);
                    } else {
                        newW3 = adjustWidth(this.width, f2, neg);
                    }
                }
                localizedMagnitude(sb, mant3, f2, newW3, l);
                if (exp2 != null) {
                    sb.append(f2.contains(Flags.UPPERCASE) ? 'E' : 'e');
                    Flags flags2 = f2.dup().remove(Flags.GROUP);
                    char sign2 = exp2[0];
                    if (!f39assertionsDisabled) {
                        if (sign2 == '+' || sign2 == '-') {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                    }
                    sb.append(sign2);
                    char[] tmp2 = new char[(exp2.length - 1)];
                    System.arraycopy(exp2, 1, tmp2, 0, exp2.length - 1);
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, tmp2, flags2, -1, l));
                }
            } else if (c2 == 'a') {
                int prec5 = precision2;
                if (precision2 == -1) {
                    prec5 = 0;
                } else if (precision2 == 0) {
                    prec5 = 1;
                }
                String s = hexDouble(value, prec5);
                boolean upper = f2.contains(Flags.UPPERCASE);
                sb.append(upper ? "0X" : "0x");
                if (f2.contains(Flags.ZERO_PAD)) {
                    for (int i = 0; i < (this.width - s.length()) - 2; i++) {
                        sb.append('0');
                    }
                }
                int idx = s.indexOf(112);
                char[] va = s.substring(0, idx).toCharArray();
                if (upper) {
                    va = new String(va).toUpperCase(Locale.US).toCharArray();
                }
                if (prec5 != 0) {
                    va = addZeros(va, prec5);
                }
                sb.append(va);
                sb.append(upper ? 'P' : AuthenticationInfo.PROXY_AUTHENTICATION);
                sb.append(s.substring(idx + 1));
            }
        }

        private char[] mantissa(char[] v, int len) {
            int i = 0;
            while (i < len && v[i] != 'e') {
                i++;
            }
            char[] tmp = new char[i];
            System.arraycopy(v, 0, tmp, 0, i);
            return tmp;
        }

        private char[] exponent(char[] v, int len) {
            int i = len - 1;
            while (i >= 0 && v[i] != 'e') {
                i--;
            }
            if (i == -1) {
                return null;
            }
            char[] tmp = new char[((len - i) - 1)];
            System.arraycopy(v, i + 1, tmp, 0, (len - i) - 1);
            return tmp;
        }

        private char[] addZeros(char[] v, int prec) {
            int i;
            boolean z;
            int i2 = 1;
            int i3 = 0;
            while (i3 < v.length && v[i3] != '.') {
                i3++;
            }
            boolean needDot = false;
            if (i3 == v.length) {
                needDot = true;
            }
            int length = v.length - i3;
            if (needDot) {
                i = 0;
            } else {
                i = 1;
            }
            int outPrec = length - i;
            if (!f39assertionsDisabled) {
                if (outPrec <= prec) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (outPrec == prec) {
                return v;
            }
            int length2 = (v.length + prec) - outPrec;
            if (!needDot) {
                i2 = 0;
            }
            char[] tmp = new char[(length2 + i2)];
            System.arraycopy(v, 0, tmp, 0, v.length);
            int start = v.length;
            if (needDot) {
                tmp[v.length] = '.';
                start++;
            }
            for (int j = start; j < tmp.length; j++) {
                tmp[j] = '0';
            }
            return tmp;
        }

        private String hexDouble(double d, int prec) {
            boolean sticky;
            boolean z;
            if (!FpUtils.isFinite(d) || d == 0.0d || prec == 0 || prec >= 13) {
                return Double.toHexString(d).substring(2);
            }
            if (!f39assertionsDisabled) {
                if (!(prec >= 1 && prec <= 12)) {
                    throw new AssertionError();
                }
            }
            boolean subnormal = FpUtils.getExponent(d) == -1023;
            if (subnormal) {
                double unused = Formatter.scaleUp = FpUtils.scalb(1.0d, 54);
                d *= Formatter.scaleUp;
                int exponent = FpUtils.getExponent(d);
                if (!f39assertionsDisabled) {
                    if (exponent >= -1022) {
                        z = exponent <= 1023;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError((Object) Integer.valueOf(exponent));
                    }
                }
            }
            int shiftDistance = 53 - ((prec * 4) + 1);
            if (!f39assertionsDisabled) {
                if (!(shiftDistance >= 1 && shiftDistance < 53)) {
                    throw new AssertionError();
                }
            }
            long doppel = Double.doubleToLongBits(d);
            long newSignif = (Long.MAX_VALUE & doppel) >> shiftDistance;
            long roundingBits = doppel & (~(-1 << shiftDistance));
            boolean leastZero = (1 & newSignif) == 0;
            boolean round = ((1 << (shiftDistance + -1)) & roundingBits) != 0;
            if (shiftDistance > 1) {
                sticky = ((~(1 << (shiftDistance + -1))) & roundingBits) != 0;
            } else {
                sticky = false;
            }
            if ((leastZero && round && sticky) || (!leastZero && round)) {
                newSignif++;
            }
            double result = Double.longBitsToDouble((doppel & Long.MIN_VALUE) | (newSignif << shiftDistance));
            if (Double.isInfinite(result)) {
                return "1.0p1024";
            }
            String res = Double.toHexString(result).substring(2);
            if (!subnormal) {
                return res;
            }
            int idx = res.indexOf(112);
            if (idx != -1) {
                return res.substring(0, idx) + "p" + Integer.toString(Integer.parseInt(res.substring(idx + 1)) - 54);
            } else if (f39assertionsDisabled) {
                return null;
            } else {
                throw new AssertionError();
            }
        }

        private void print(BigDecimal value, Locale l) throws IOException {
            if (this.c == 'a') {
                failConversion(this.c, value);
            }
            StringBuilder sb = new StringBuilder();
            boolean neg = value.signum() == -1;
            BigDecimal v = value.abs();
            leadingSign(sb, neg);
            print(sb, v, l, this.f, this.c, this.precision, neg);
            trailingSign(sb, neg);
            Formatter.this.a.append((CharSequence) justify(sb.toString()));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00dc, code lost:
            if (r45.contains(java.util.Formatter.Flags.ALTERNATE) != false) goto L_0x00de;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void print(java.lang.StringBuilder r42, java.math.BigDecimal r43, java.util.Locale r44, java.util.Formatter.Flags r45, char r46, int r47, boolean r48) throws java.io.IOException {
            /*
                r41 = this;
                r4 = 101(0x65, float:1.42E-43)
                r0 = r46
                if (r0 != r4) goto L_0x0116
                r4 = -1
                r0 = r47
                if (r0 != r4) goto L_0x00ca
                r19 = 6
            L_0x000d:
                int r35 = r43.scale()
                int r34 = r43.precision()
                r33 = 0
                int r4 = r34 + -1
                r0 = r19
                if (r0 <= r4) goto L_0x00ce
                r29 = r34
                int r4 = r34 + -1
                int r33 = r19 - r4
            L_0x0023:
                java.math.MathContext r32 = new java.math.MathContext
                r0 = r32
                r1 = r29
                r0.<init>(r1)
                java.math.BigDecimal r39 = new java.math.BigDecimal
                java.math.BigInteger r4 = r43.unscaledValue()
                r0 = r39
                r1 = r35
                r2 = r32
                r0.<init>(r4, r1, r2)
                java.util.Formatter$FormatSpecifier$BigDecimalLayout r28 = new java.util.Formatter$FormatSpecifier$BigDecimalLayout
                java.math.BigInteger r4 = r39.unscaledValue()
                int r5 = r39.scale()
                java.util.Formatter$BigDecimalLayoutForm r7 = java.util.Formatter.BigDecimalLayoutForm.SCIENTIFIC
                r0 = r28
                r1 = r41
                r0.<init>(r1, r4, r5, r7)
                char[] r6 = r28.mantissa()
                r4 = 1
                r0 = r34
                if (r0 == r4) goto L_0x00d2
                boolean r4 = r28.hasDot()
                if (r4 == 0) goto L_0x00d2
            L_0x005d:
                r0 = r41
                r1 = r33
                char[] r6 = r0.trailingZeros(r6, r1)
                char[] r31 = r28.exponent()
                r0 = r41
                int r8 = r0.width
                r0 = r41
                int r4 = r0.width
                r5 = -1
                if (r4 == r5) goto L_0x0088
                r0 = r41
                int r4 = r0.width
                r0 = r31
                int r5 = r0.length
                int r4 = r4 - r5
                int r4 = r4 + -1
                r0 = r41
                r1 = r45
                r2 = r48
                int r8 = r0.adjustWidth(r4, r1, r2)
            L_0x0088:
                r4 = r41
                r5 = r42
                r7 = r45
                r9 = r44
                r4.localizedMagnitude((java.lang.StringBuilder) r5, (char[]) r6, (java.util.Formatter.Flags) r7, (int) r8, (java.util.Locale) r9)
                java.util.Formatter$Flags r4 = java.util.Formatter.Flags.UPPERCASE
                r0 = r45
                boolean r4 = r0.contains(r4)
                if (r4 == 0) goto L_0x00e6
                r4 = 69
            L_0x009f:
                r0 = r42
                r0.append((char) r4)
                java.util.Formatter$Flags r4 = r45.dup()
                java.util.Formatter$Flags r5 = java.util.Formatter.Flags.GROUP
                java.util.Formatter$Flags r12 = r4.remove(r5)
                r4 = 0
                char r36 = r31[r4]
                boolean r4 = f39assertionsDisabled
                if (r4 != 0) goto L_0x00eb
                r4 = 43
                r0 = r36
                if (r0 == r4) goto L_0x00c1
                r4 = 45
                r0 = r36
                if (r0 != r4) goto L_0x00e9
            L_0x00c1:
                r4 = 1
            L_0x00c2:
                if (r4 != 0) goto L_0x00eb
                java.lang.AssertionError r4 = new java.lang.AssertionError
                r4.<init>()
                throw r4
            L_0x00ca:
                r19 = r47
                goto L_0x000d
            L_0x00ce:
                int r29 = r19 + 1
                goto L_0x0023
            L_0x00d2:
                if (r33 > 0) goto L_0x00de
                java.util.Formatter$Flags r4 = java.util.Formatter.Flags.ALTERNATE
                r0 = r45
                boolean r4 = r0.contains(r4)
                if (r4 == 0) goto L_0x005d
            L_0x00de:
                r0 = r41
                char[] r6 = r0.addDot(r6)
                goto L_0x005d
            L_0x00e6:
                r4 = 101(0x65, float:1.42E-43)
                goto L_0x009f
            L_0x00e9:
                r4 = 0
                goto L_0x00c2
            L_0x00eb:
                r4 = 0
                char r4 = r31[r4]
                r0 = r42
                r0.append((char) r4)
                r0 = r31
                int r4 = r0.length
                int r4 = r4 + -1
                char[] r11 = new char[r4]
                r0 = r31
                int r4 = r0.length
                int r4 = r4 + -1
                r5 = 1
                r7 = 0
                r0 = r31
                java.lang.System.arraycopy((char[]) r0, (int) r5, (char[]) r11, (int) r7, (int) r4)
                r10 = 0
                r13 = -1
                r9 = r41
                r14 = r44
                java.lang.StringBuilder r4 = r9.localizedMagnitude((java.lang.StringBuilder) r10, (char[]) r11, (java.util.Formatter.Flags) r12, (int) r13, (java.util.Locale) r14)
                r0 = r42
                r0.append((java.lang.CharSequence) r4)
            L_0x0115:
                return
            L_0x0116:
                r4 = 102(0x66, float:1.43E-43)
                r0 = r46
                if (r0 != r4) goto L_0x01c9
                r4 = -1
                r0 = r47
                if (r0 != r4) goto L_0x01a6
                r19 = 6
            L_0x0123:
                int r35 = r43.scale()
                r0 = r35
                r1 = r19
                if (r0 <= r1) goto L_0x0141
                int r29 = r43.precision()
                r0 = r29
                r1 = r35
                if (r0 > r1) goto L_0x01aa
                java.math.RoundingMode r4 = java.math.RoundingMode.HALF_UP
                r0 = r43
                r1 = r19
                java.math.BigDecimal r43 = r0.setScale(r1, r4)
            L_0x0141:
                java.util.Formatter$FormatSpecifier$BigDecimalLayout r28 = new java.util.Formatter$FormatSpecifier$BigDecimalLayout
                java.math.BigInteger r4 = r43.unscaledValue()
                int r5 = r43.scale()
                java.util.Formatter$BigDecimalLayoutForm r7 = java.util.Formatter.BigDecimalLayoutForm.DECIMAL_FLOAT
                r0 = r28
                r1 = r41
                r0.<init>(r1, r4, r5, r7)
                char[] r6 = r28.mantissa()
                int r4 = r28.scale()
                r0 = r19
                if (r4 >= r0) goto L_0x01c6
                int r4 = r28.scale()
                int r33 = r19 - r4
            L_0x0166:
                int r4 = r28.scale()
                if (r4 != 0) goto L_0x0182
                java.util.Formatter$Flags r4 = java.util.Formatter.Flags.ALTERNATE
                r0 = r45
                boolean r4 = r0.contains(r4)
                if (r4 != 0) goto L_0x0178
                if (r33 <= 0) goto L_0x0182
            L_0x0178:
                char[] r4 = r28.mantissa()
                r0 = r41
                char[] r6 = r0.addDot(r4)
            L_0x0182:
                r0 = r41
                r1 = r33
                char[] r6 = r0.trailingZeros(r6, r1)
                r0 = r41
                int r4 = r0.width
                r0 = r41
                r1 = r45
                r2 = r48
                int r17 = r0.adjustWidth(r4, r1, r2)
                r13 = r41
                r14 = r42
                r15 = r6
                r16 = r45
                r18 = r44
                r13.localizedMagnitude((java.lang.StringBuilder) r14, (char[]) r15, (java.util.Formatter.Flags) r16, (int) r17, (java.util.Locale) r18)
                goto L_0x0115
            L_0x01a6:
                r19 = r47
                goto L_0x0123
            L_0x01aa:
                int r4 = r35 - r19
                int r29 = r29 - r4
                java.math.BigDecimal r40 = new java.math.BigDecimal
                java.math.BigInteger r4 = r43.unscaledValue()
                java.math.MathContext r5 = new java.math.MathContext
                r0 = r29
                r5.<init>(r0)
                r0 = r40
                r1 = r35
                r0.<init>(r4, r1, r5)
                r43 = r40
                goto L_0x0141
            L_0x01c6:
                r33 = 0
                goto L_0x0166
            L_0x01c9:
                r4 = 103(0x67, float:1.44E-43)
                r0 = r46
                if (r0 != r4) goto L_0x024e
                r19 = r47
                r4 = -1
                r0 = r47
                if (r0 != r4) goto L_0x0234
                r19 = 6
            L_0x01d8:
                r4 = 1
                r7 = 4
                java.math.BigDecimal r37 = java.math.BigDecimal.valueOf(r4, r7)
                r4 = 1
                r0 = r19
                int r7 = -r0
                java.math.BigDecimal r38 = java.math.BigDecimal.valueOf(r4, r7)
                java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
                r0 = r43
                boolean r4 = r0.equals(r4)
                if (r4 != 0) goto L_0x0208
                r0 = r43
                r1 = r37
                int r4 = r0.compareTo(r1)
                r5 = -1
                if (r4 == r5) goto L_0x0239
                r0 = r43
                r1 = r38
                int r4 = r0.compareTo(r1)
                r5 = -1
                if (r4 != r5) goto L_0x0239
            L_0x0208:
                int r4 = r43.scale()
                int r4 = -r4
                java.math.BigInteger r5 = r43.unscaledValue()
                java.lang.String r5 = r5.toString()
                int r5 = r5.length()
                int r5 = r5 + -1
                int r30 = r4 + r5
                int r4 = r19 - r30
                int r19 = r4 + -1
                r18 = 102(0x66, float:1.43E-43)
                r13 = r41
                r14 = r42
                r15 = r43
                r16 = r44
                r17 = r45
                r20 = r48
                r13.print((java.lang.StringBuilder) r14, (java.math.BigDecimal) r15, (java.util.Locale) r16, (java.util.Formatter.Flags) r17, (char) r18, (int) r19, (boolean) r20)
                goto L_0x0115
            L_0x0234:
                if (r47 != 0) goto L_0x01d8
                r19 = 1
                goto L_0x01d8
            L_0x0239:
                int r26 = r19 + -1
                r25 = 101(0x65, float:1.42E-43)
                r20 = r41
                r21 = r42
                r22 = r43
                r23 = r44
                r24 = r45
                r27 = r48
                r20.print((java.lang.StringBuilder) r21, (java.math.BigDecimal) r22, (java.util.Locale) r23, (java.util.Formatter.Flags) r24, (char) r25, (int) r26, (boolean) r27)
                goto L_0x0115
            L_0x024e:
                r4 = 97
                r0 = r46
                if (r0 != r4) goto L_0x0115
                boolean r4 = f39assertionsDisabled
                if (r4 != 0) goto L_0x0115
                java.lang.AssertionError r4 = new java.lang.AssertionError
                r4.<init>()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Formatter.FormatSpecifier.print(java.lang.StringBuilder, java.math.BigDecimal, java.util.Locale, java.util.Formatter$Flags, char, int, boolean):void");
        }

        private int adjustWidth(int width2, Flags f2, boolean neg) {
            int newW = width2;
            if (width2 == -1 || !neg || !f2.contains(Flags.PARENTHESES)) {
                return newW;
            }
            return width2 - 1;
        }

        private char[] addDot(char[] mant) {
            char[] cArr = mant;
            char[] tmp = new char[(mant.length + 1)];
            System.arraycopy(mant, 0, tmp, 0, mant.length);
            tmp[tmp.length - 1] = '.';
            return tmp;
        }

        private char[] trailingZeros(char[] mant, int nzeros) {
            char[] tmp = mant;
            if (nzeros > 0) {
                tmp = new char[(mant.length + nzeros)];
                System.arraycopy(mant, 0, tmp, 0, mant.length);
                for (int i = mant.length; i < tmp.length; i++) {
                    tmp[i] = '0';
                }
            }
            return tmp;
        }

        private void print(Calendar t, char c2, Locale l) throws IOException {
            StringBuilder sb = new StringBuilder();
            print(sb, t, c2, l);
            String s = justify(sb.toString());
            if (this.f.contains(Flags.UPPERCASE)) {
                s = s.toUpperCase();
            }
            Formatter.this.a.append((CharSequence) s);
        }

        private Appendable print(StringBuilder sb, Calendar t, char c2, Locale l) throws IOException {
            Flags flags;
            Locale lt;
            Locale lt2;
            Flags flags2;
            if (!f39assertionsDisabled) {
                if (!(this.width == -1)) {
                    throw new AssertionError();
                }
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            switch (c2) {
                case 'A':
                case 'a':
                    int i = t.get(7);
                    if (l == null) {
                        lt2 = Locale.US;
                    } else {
                        lt2 = l;
                    }
                    DateFormatSymbols dfs = DateFormatSymbols.getInstance(lt2);
                    if (c2 != 'A') {
                        sb.append(dfs.getShortWeekdays()[i]);
                        break;
                    } else {
                        sb.append(dfs.getWeekdays()[i]);
                        break;
                    }
                case 'B':
                case 'b':
                case 'h':
                    int i2 = t.get(2);
                    if (l == null) {
                        lt = Locale.US;
                    } else {
                        lt = l;
                    }
                    DateFormatSymbols dfs2 = DateFormatSymbols.getInstance(lt);
                    if (c2 != 'B') {
                        sb.append(dfs2.getShortMonths()[i2]);
                        break;
                    } else {
                        sb.append(dfs2.getMonths()[i2]);
                        break;
                    }
                case 'C':
                case 'Y':
                case 'y':
                    int i3 = t.get(1);
                    int size = 2;
                    switch (c2) {
                        case 'C':
                            i3 /= 100;
                            break;
                        case 'Y':
                            size = 4;
                            break;
                        case 'y':
                            i3 %= 100;
                            break;
                    }
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) i3, Flags.ZERO_PAD, size, l));
                    break;
                case 'D':
                    print(sb, t, 'm', l).append('/');
                    print(sb, t, 'd', l).append('/');
                    print(sb, t, 'y', l);
                    break;
                case Types.DATALINK:
                    print(sb, t, 'Y', l).append('-');
                    print(sb, t, 'm', l).append('-');
                    print(sb, t, 'd', l);
                    break;
                case 'H':
                case 'I':
                case 'k':
                case 'l':
                    int i4 = t.get(11);
                    if (c2 == 'I' || c2 == 'l') {
                        i4 = (i4 == 0 || i4 == 12) ? 12 : i4 % 12;
                    }
                    if (c2 == 'H' || c2 == 'I') {
                        flags2 = Flags.ZERO_PAD;
                    } else {
                        flags2 = Flags.NONE;
                    }
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) i4, flags2, 2, l));
                    break;
                case 'L':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) t.get(14), Flags.ZERO_PAD, 3, l));
                    break;
                case 'M':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) t.get(12), Flags.ZERO_PAD, 2, l));
                    break;
                case 'N':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) (t.get(14) * 1000000), Flags.ZERO_PAD, 9, l));
                    break;
                case 'Q':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, t.getTimeInMillis(), Flags.NONE, this.width, l));
                    break;
                case 'R':
                case 'T':
                    print(sb, t, 'H', l).append(':');
                    print(sb, t, 'M', l);
                    if (c2 == 'T') {
                        sb.append(':');
                        print(sb, t, 'S', l);
                        break;
                    }
                    break;
                case 'S':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) t.get(13), Flags.ZERO_PAD, 2, l));
                    break;
                case 'Z':
                    TimeZone tz = t.getTimeZone();
                    boolean z = t.get(16) != 0;
                    if (l == null) {
                        l = Locale.US;
                    }
                    sb.append(tz.getDisplayName(z, 0, l));
                    break;
                case 'c':
                    print(sb, t, 'a', l).append(' ');
                    print(sb, t, 'b', l).append(' ');
                    print(sb, t, 'd', l).append(' ');
                    print(sb, t, 'T', l).append(' ');
                    print(sb, t, 'Z', l).append(' ');
                    print(sb, t, 'Y', l);
                    break;
                case 'd':
                case 'e':
                    int i5 = t.get(5);
                    if (c2 == 'd') {
                        flags = Flags.ZERO_PAD;
                    } else {
                        flags = Flags.NONE;
                    }
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) i5, flags, 2, l));
                    break;
                case 'j':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) t.get(6), Flags.ZERO_PAD, 3, l));
                    break;
                case 'm':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) (t.get(2) + 1), Flags.ZERO_PAD, 2, l));
                    break;
                case 'p':
                    String[] ampm = {"AM", "PM"};
                    if (!(l == null || l == Locale.US)) {
                        ampm = DateFormatSymbols.getInstance(l).getAmPmStrings();
                    }
                    String s = ampm[t.get(9)];
                    if (l == null) {
                        l = Locale.US;
                    }
                    sb.append(s.toLowerCase(l));
                    break;
                case 'r':
                    print(sb, t, 'I', l).append(':');
                    print(sb, t, 'M', l).append(':');
                    print(sb, t, 'S', l).append(' ');
                    StringBuilder tsb = new StringBuilder();
                    print(tsb, t, AuthenticationInfo.PROXY_AUTHENTICATION, l);
                    String sb2 = tsb.toString();
                    if (l == null) {
                        l = Locale.US;
                    }
                    sb.append(sb2.toUpperCase(l));
                    break;
                case 's':
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, t.getTimeInMillis() / 1000, Flags.NONE, this.width, l));
                    break;
                case 'z':
                    int i6 = t.get(15) + t.get(16);
                    boolean neg = i6 < 0;
                    sb.append(neg ? '-' : '+');
                    if (neg) {
                        i6 = -i6;
                    }
                    int min = i6 / 60000;
                    sb.append((CharSequence) localizedMagnitude((StringBuilder) null, (long) (((min / 60) * 100) + (min % 60)), Flags.ZERO_PAD, 4, l));
                    break;
                default:
                    if (!f39assertionsDisabled) {
                        throw new AssertionError();
                    }
                    break;
            }
            return sb;
        }

        private void failMismatch(Flags f2, char c2) {
            throw new FormatFlagsConversionMismatchException(f2.toString(), c2);
        }

        private void failConversion(char c2, Object arg) {
            throw new IllegalFormatConversionException(c2, arg.getClass());
        }

        private char getZero(Locale l) {
            if (l == null || l.equals(Formatter.this.locale())) {
                return Formatter.this.zero;
            }
            return DecimalFormatSymbols.getInstance(l).getZeroDigit();
        }

        private StringBuilder localizedMagnitude(StringBuilder sb, long value, Flags f2, int width2, Locale l) {
            return localizedMagnitude(sb, Long.toString(value, 10).toCharArray(), f2, width2, l);
        }

        private StringBuilder localizedMagnitude(StringBuilder sb, char[] value, Flags f2, int width2, Locale l) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            int begin = sb.length();
            char zero = getZero(l);
            char grpSep = 0;
            int grpSize = -1;
            char decSep = 0;
            int len = value.length;
            int dot = len;
            int j = 0;
            while (true) {
                if (j >= len) {
                    break;
                } else if (value[j] == '.') {
                    dot = j;
                    break;
                } else {
                    j++;
                }
            }
            if (dot < len) {
                if (l != null) {
                    if (!l.equals(Locale.US)) {
                        decSep = DecimalFormatSymbols.getInstance(l).getDecimalSeparator();
                    }
                }
                decSep = '.';
            }
            if (f2.contains(Flags.GROUP)) {
                if (l != null) {
                    if (!l.equals(Locale.US)) {
                        grpSep = DecimalFormatSymbols.getInstance(l).getGroupingSeparator();
                        DecimalFormat df = (DecimalFormat) NumberFormat.getIntegerInstance(l);
                        grpSize = df.getGroupingSize();
                        if (!df.isGroupingUsed() || df.getGroupingSize() == 0) {
                            grpSep = 0;
                        }
                    }
                }
                grpSep = ',';
                grpSize = 3;
            }
            for (int j2 = 0; j2 < len; j2++) {
                if (j2 == dot) {
                    sb.append(decSep);
                    grpSep = 0;
                } else {
                    sb.append((char) ((value[j2] - '0') + zero));
                    if (!(grpSep == 0 || j2 == dot - 1 || (dot - j2) % grpSize != 1)) {
                        sb.append(grpSep);
                    }
                }
            }
            int len2 = sb.length();
            if (width2 != -1) {
                if (f2.contains(Flags.ZERO_PAD)) {
                    for (int k = 0; k < width2 - len2; k++) {
                        sb.insert(begin, zero);
                    }
                }
            }
            return sb;
        }
    }

    private static class Flags {
        static final Flags ALTERNATE = null;
        static final Flags GROUP = null;
        static final Flags LEADING_SPACE = null;
        static final Flags LEFT_JUSTIFY = null;
        static final Flags NONE = null;
        static final Flags PARENTHESES = null;
        static final Flags PLUS = null;
        static final Flags PREVIOUS = null;
        static final Flags UPPERCASE = null;
        static final Flags ZERO_PAD = null;
        private int flags;

        private Flags(int f) {
            this.flags = f;
        }

        public int valueOf() {
            return this.flags;
        }

        public boolean contains(Flags f) {
            return (this.flags & f.valueOf()) == f.valueOf();
        }

        public Flags dup() {
            return new Flags(this.flags);
        }

        /* access modifiers changed from: private */
        public Flags add(Flags f) {
            this.flags |= f.valueOf();
            return this;
        }

        public Flags remove(Flags f) {
            this.flags &= ~f.valueOf();
            return this;
        }

        public static Flags parse(String s) {
            char[] ca = s.toCharArray();
            Flags f = new Flags(0);
            for (char parse : ca) {
                Flags v = parse(parse);
                if (f.contains(v)) {
                    throw new DuplicateFormatFlagsException(v.toString());
                }
                f.add(v);
            }
            return f;
        }

        private static Flags parse(char c) {
            switch (c) {
                case ' ':
                    return LEADING_SPACE;
                case '#':
                    return ALTERNATE;
                case '(':
                    return PARENTHESES;
                case '+':
                    return PLUS;
                case ',':
                    return GROUP;
                case '-':
                    return LEFT_JUSTIFY;
                case '0':
                    return ZERO_PAD;
                case '<':
                    return PREVIOUS;
                default:
                    throw new UnknownFormatFlagsException(String.valueOf(c));
            }
        }

        public static String toString(Flags f) {
            return f.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (contains(LEFT_JUSTIFY)) {
                sb.append('-');
            }
            if (contains(UPPERCASE)) {
                sb.append('^');
            }
            if (contains(ALTERNATE)) {
                sb.append('#');
            }
            if (contains(PLUS)) {
                sb.append('+');
            }
            if (contains(LEADING_SPACE)) {
                sb.append(' ');
            }
            if (contains(ZERO_PAD)) {
                sb.append('0');
            }
            if (contains(GROUP)) {
                sb.append(',');
            }
            if (contains(PARENTHESES)) {
                sb.append('(');
            }
            if (contains(PREVIOUS)) {
                sb.append('<');
            }
            return sb.toString();
        }
    }

    private static class Conversion {
        static final char BOOLEAN = 'b';
        static final char BOOLEAN_UPPER = 'B';
        static final char CHARACTER = 'c';
        static final char CHARACTER_UPPER = 'C';
        static final char DATE_TIME = 't';
        static final char DATE_TIME_UPPER = 'T';
        static final char DECIMAL_FLOAT = 'f';
        static final char DECIMAL_INTEGER = 'd';
        static final char GENERAL = 'g';
        static final char GENERAL_UPPER = 'G';
        static final char HASHCODE = 'h';
        static final char HASHCODE_UPPER = 'H';
        static final char HEXADECIMAL_FLOAT = 'a';
        static final char HEXADECIMAL_FLOAT_UPPER = 'A';
        static final char HEXADECIMAL_INTEGER = 'x';
        static final char HEXADECIMAL_INTEGER_UPPER = 'X';
        static final char LINE_SEPARATOR = 'n';
        static final char OCTAL_INTEGER = 'o';
        static final char PERCENT_SIGN = '%';
        static final char SCIENTIFIC = 'e';
        static final char SCIENTIFIC_UPPER = 'E';
        static final char STRING = 's';
        static final char STRING_UPPER = 'S';

        private Conversion() {
        }

        static boolean isValid(char c) {
            if (isGeneral(c) || isInteger(c) || isFloat(c) || isText(c) || c == 't') {
                return true;
            }
            return isCharacter(c);
        }

        static boolean isGeneral(char c) {
            switch (c) {
                case 'B':
                case 'H':
                case 'S':
                case 'b':
                case 'h':
                case 's':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isCharacter(char c) {
            switch (c) {
                case 'C':
                case 'c':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isInteger(char c) {
            switch (c) {
                case 'X':
                case 'd':
                case 'o':
                case 'x':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isFloat(char c) {
            switch (c) {
                case 'A':
                case 'E':
                case 'G':
                case 'a':
                case 'e':
                case 'f':
                case 'g':
                    return true;
                default:
                    return false;
            }
        }

        static boolean isText(char c) {
            switch (c) {
                case '%':
                case 'n':
                    return true;
                default:
                    return false;
            }
        }
    }

    private static class DateTime {
        static final char AM_PM = 'p';
        static final char CENTURY = 'C';
        static final char DATE = 'D';
        static final char DATE_TIME = 'c';
        static final char DAY_OF_MONTH = 'e';
        static final char DAY_OF_MONTH_0 = 'd';
        static final char DAY_OF_YEAR = 'j';
        static final char HOUR = 'l';
        static final char HOUR_0 = 'I';
        static final char HOUR_OF_DAY = 'k';
        static final char HOUR_OF_DAY_0 = 'H';
        static final char ISO_STANDARD_DATE = 'F';
        static final char MILLISECOND = 'L';
        static final char MILLISECOND_SINCE_EPOCH = 'Q';
        static final char MINUTE = 'M';
        static final char MONTH = 'm';
        static final char NAME_OF_DAY = 'A';
        static final char NAME_OF_DAY_ABBREV = 'a';
        static final char NAME_OF_MONTH = 'B';
        static final char NAME_OF_MONTH_ABBREV = 'b';
        static final char NAME_OF_MONTH_ABBREV_X = 'h';
        static final char NANOSECOND = 'N';
        static final char SECOND = 'S';
        static final char SECONDS_SINCE_EPOCH = 's';
        static final char TIME = 'T';
        static final char TIME_12_HOUR = 'r';
        static final char TIME_24_HOUR = 'R';
        static final char YEAR_2 = 'y';
        static final char YEAR_4 = 'Y';
        static final char ZONE = 'Z';
        static final char ZONE_NUMERIC = 'z';

        private DateTime() {
        }

        static boolean isValid(char c) {
            switch (c) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case Types.DATALINK:
                case 'H':
                case 'I':
                case 'L':
                case 'M':
                case 'N':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'h':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'p':
                case 'r':
                case 's':
                case 'y':
                case 'z':
                    return true;
                default:
                    return false;
            }
        }
    }
}
