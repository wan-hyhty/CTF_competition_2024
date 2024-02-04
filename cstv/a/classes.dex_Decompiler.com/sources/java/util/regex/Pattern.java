package java.util.regex;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;
import libcore.util.EmptyArray;
import libcore.util.NativeAllocationRegistry;

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
public final class Pattern implements Serializable {
    public static final int CANON_EQ = 128;
    public static final int CASE_INSENSITIVE = 2;
    public static final int COMMENTS = 4;
    public static final int DOTALL = 32;
    private static final String FASTSPLIT_METACHARACTERS = "\\?*+[](){}^$.|";
    public static final int LITERAL = 16;
    public static final int MULTILINE = 8;
    public static final int UNICODE_CASE = 64;
    public static final int UNICODE_CHARACTER_CLASS = 256;
    public static final int UNIX_LINES = 1;
    private static final NativeAllocationRegistry registry = null;
    private static final long serialVersionUID = 5073258162644648461L;
    transient long address;
    private final int flags;
    private final String pattern;

    /* renamed from: java.util.regex.Pattern$-java_util_function_Predicate_asPredicate__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_function_Predicate_asPredicate__LambdaImpl0 implements Predicate {
        private /* synthetic */ Pattern val$this;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.regex.Pattern.-java_util_function_Predicate_asPredicate__LambdaImpl0.<init>(java.util.regex.Pattern):void, dex: classes.dex
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
        public /* synthetic */ java_util_function_Predicate_asPredicate__LambdaImpl0(java.util.regex.Pattern r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.regex.Pattern.-java_util_function_Predicate_asPredicate__LambdaImpl0.<init>(java.util.regex.Pattern):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Pattern.java_util_function_Predicate_asPredicate__LambdaImpl0.<init>(java.util.regex.Pattern):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Pattern.-java_util_function_Predicate_asPredicate__LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
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
        public boolean test(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Pattern.-java_util_function_Predicate_asPredicate__LambdaImpl0.test(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Pattern.java_util_function_Predicate_asPredicate__LambdaImpl0.test(java.lang.Object):boolean");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Pattern.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Pattern.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Pattern.<clinit>():void");
    }

    private static native long compileImpl(String str, int i);

    private static native long getNativeFinalizer();

    private static native int nativeSize();

    public static Pattern compile(String regex) {
        return new Pattern(regex, 0);
    }

    public static Pattern compile(String regex, int flags2) throws PatternSyntaxException {
        return new Pattern(regex, flags2);
    }

    public String pattern() {
        return this.pattern;
    }

    public String toString() {
        return this.pattern;
    }

    public Matcher matcher(CharSequence input) {
        return new Matcher(this, input);
    }

    public int flags() {
        return this.flags;
    }

    public static boolean matches(String regex, CharSequence input) {
        return compile(regex).matcher(input).matches();
    }

    public String[] split(CharSequence input, int limit) {
        String[] fast = fastSplit(this.pattern, input.toString(), limit);
        if (fast != null) {
            return fast;
        }
        int index = 0;
        boolean matchLimited = limit > 0;
        ArrayList<String> matchList = new ArrayList<>();
        Matcher m = matcher(input);
        while (m.find()) {
            if (!matchLimited || matchList.size() < limit - 1) {
                matchList.add(input.subSequence(index, m.start()).toString());
                index = m.end();
            } else if (matchList.size() == limit - 1) {
                matchList.add(input.subSequence(index, input.length()).toString());
                index = m.end();
            }
        }
        if (index == 0) {
            return new String[]{input.toString()};
        }
        if (!matchLimited || matchList.size() < limit) {
            matchList.add(input.subSequence(index, input.length()).toString());
        }
        int resultSize = matchList.size();
        if (limit == 0) {
            while (resultSize > 0 && matchList.get(resultSize - 1).equals("")) {
                resultSize--;
            }
        }
        return (String[]) matchList.subList(0, resultSize).toArray(new String[resultSize]);
    }

    public static String[] fastSplit(String re, String input, int limit) {
        int end;
        int len = re.length();
        if (len == 0) {
            return null;
        }
        char ch = re.charAt(0);
        if (!(len == 1 && FASTSPLIT_METACHARACTERS.indexOf((int) ch) == -1)) {
            if (len != 2 || ch != '\\') {
                return null;
            }
            ch = re.charAt(1);
            if (FASTSPLIT_METACHARACTERS.indexOf((int) ch) == -1) {
                return null;
            }
        }
        if (input.isEmpty()) {
            return new String[]{""};
        }
        int separatorCount = 0;
        int begin = 0;
        while (separatorCount + 1 != limit && (end = input.indexOf((int) ch, begin)) != -1) {
            separatorCount++;
            begin = end + 1;
        }
        int lastPartEnd = input.length();
        if (limit == 0 && begin == lastPartEnd) {
            if (separatorCount == lastPartEnd) {
                return EmptyArray.STRING;
            }
            do {
                begin--;
            } while (input.charAt(begin - 1) == ch);
            separatorCount -= input.length() - begin;
            lastPartEnd = begin;
        }
        String[] result = new String[(separatorCount + 1)];
        int begin2 = 0;
        for (int i = 0; i != separatorCount; i++) {
            int end2 = input.indexOf((int) ch, begin2);
            result[i] = input.substring(begin2, end2);
            begin2 = end2 + 1;
        }
        result[separatorCount] = input.substring(begin2, lastPartEnd);
        return result;
    }

    public String[] split(CharSequence input) {
        return split(input, 0);
    }

    public static String quote(String s) {
        if (s.indexOf("\\E") == -1) {
            return "\\Q" + s + "\\E";
        }
        StringBuilder sb = new StringBuilder(s.length() * 2);
        sb.append("\\Q");
        int current = 0;
        while (true) {
            int slashEIndex = s.indexOf("\\E", current);
            if (slashEIndex != -1) {
                sb.append(s.substring(current, slashEIndex));
                current = slashEIndex + 2;
                sb.append("\\E\\\\E\\Q");
            } else {
                sb.append(s.substring(current, s.length()));
                sb.append("\\E");
                return sb.toString();
            }
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        compile();
    }

    private Pattern(String p, int f) {
        if ((f & 128) != 0) {
            throw new UnsupportedOperationException("CANON_EQ flag not supported");
        } else if (((~127) & f) != 0) {
            throw new IllegalArgumentException("Unsupported flags: " + ((~127) & f));
        } else {
            this.pattern = p;
            this.flags = f;
            compile();
        }
    }

    private void compile() throws PatternSyntaxException {
        if (this.pattern == null) {
            throw new NullPointerException("pattern == null");
        }
        String icuPattern = this.pattern;
        if ((this.flags & 16) != 0) {
            icuPattern = quote(this.pattern);
        }
        this.address = compileImpl(icuPattern, this.flags & 47);
        registry.registerNativeAllocation(this, this.address);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: -java_util_regex_Pattern_lambda$1  reason: not valid java name */
    public /* synthetic */ boolean m397java_util_regex_Pattern_lambda$1(String s) {
        return matcher(s).find();
    }

    public Predicate<String> asPredicate() {
        return new java_util_function_Predicate_asPredicate__LambdaImpl0(this);
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public java.util.stream.Stream<java.lang.String> splitAsStream(java.lang.CharSequence r3) {
        /*
            r2 = this;
            java.util.regex.Pattern$1MatcherIterator r0 = new java.util.regex.Pattern$1MatcherIterator
            r0.<init>(r2, r3)
            r1 = 272(0x110, float:3.81E-43)
            java.util.Spliterator r0 = java.util.Spliterators.spliteratorUnknownSize(r0, (int) r1)
            r1 = 0
            java.util.stream.Stream r0 = java.util.stream.StreamSupport.stream(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Pattern.splitAsStream(java.lang.CharSequence):java.util.stream.Stream");
    }
}
