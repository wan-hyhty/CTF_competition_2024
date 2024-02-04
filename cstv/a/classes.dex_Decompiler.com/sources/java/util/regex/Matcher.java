package java.util.regex;

import libcore.util.NativeAllocationRegistry;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public final class Matcher implements MatchResult {
    private static final NativeAllocationRegistry registry = null;
    private long address;
    private boolean anchoringBounds;
    private int appendPos;
    private String input;
    private boolean matchFound;
    private int[] matchOffsets;
    private Runnable nativeFinalizer;
    private Pattern pattern;
    private int regionEnd;
    private int regionStart;
    private boolean transparentBounds;

    static final class OffsetBasedMatchResult implements MatchResult {
        private final String input;
        private final int[] offsets;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.regex.Matcher.OffsetBasedMatchResult.<init>(java.lang.String, int[]):void, dex: classes.dex
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
        OffsetBasedMatchResult(java.lang.String r1, int[] r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.regex.Matcher.OffsetBasedMatchResult.<init>(java.lang.String, int[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.<init>(java.lang.String, int[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.end():int, dex: classes.dex
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
        public int end() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.end():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.end():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Matcher.OffsetBasedMatchResult.end(int):int, dex: classes.dex
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
        public int end(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Matcher.OffsetBasedMatchResult.end(int):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.end(int):int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.group():java.lang.String, dex: classes.dex
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
        public java.lang.String group() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.group():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.group():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.group(int):java.lang.String, dex: classes.dex
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
        public java.lang.String group(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.group(int):java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.group(int):java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Matcher.OffsetBasedMatchResult.groupCount():int, dex: classes.dex
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
        public int groupCount() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Matcher.OffsetBasedMatchResult.groupCount():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.groupCount():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.start():int, dex: classes.dex
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
        public int start() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.regex.Matcher.OffsetBasedMatchResult.start():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.start():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Matcher.OffsetBasedMatchResult.start(int):int, dex: classes.dex
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
        public int start(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.regex.Matcher.OffsetBasedMatchResult.start(int):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.regex.Matcher.OffsetBasedMatchResult.start(int):int");
        }
    }

    private static native boolean findImpl(long j, String str, int i, int[] iArr);

    private static native boolean findNextImpl(long j, String str, int[] iArr);

    private static native long getNativeFinalizer();

    private static native int groupCountImpl(long j);

    private static native boolean hitEndImpl(long j);

    private static native boolean lookingAtImpl(long j, String str, int[] iArr);

    private static native boolean matchesImpl(long j, String str, int[] iArr);

    private static native int nativeSize();

    private static native long openImpl(long j);

    private static native boolean requireEndImpl(long j);

    private static native void setInputImpl(long j, String str, int i, int i2);

    private static native void useAnchoringBoundsImpl(long j, boolean z);

    private static native void useTransparentBoundsImpl(long j, boolean z);

    Matcher(Pattern parent, CharSequence text) {
        this.anchoringBounds = true;
        usePattern(parent);
        reset(text);
    }

    public Pattern pattern() {
        return this.pattern;
    }

    public MatchResult toMatchResult() {
        ensureMatch();
        return new OffsetBasedMatchResult(this.input, this.matchOffsets);
    }

    public Matcher usePattern(Pattern newPattern) {
        if (newPattern == null) {
            throw new IllegalArgumentException("newPattern == null");
        }
        this.pattern = newPattern;
        synchronized (this) {
            if (this.nativeFinalizer != null) {
                this.nativeFinalizer.run();
                this.address = 0;
                this.nativeFinalizer = null;
            }
            this.address = openImpl(this.pattern.address);
            this.nativeFinalizer = registry.registerNativeAllocation(this, this.address);
        }
        if (this.input != null) {
            resetForInput();
        }
        this.matchOffsets = new int[((groupCount() + 1) * 2)];
        this.matchFound = false;
        return this;
    }

    public int end() {
        return end(0);
    }

    public int end(int group) {
        ensureMatch();
        return this.matchOffsets[(group * 2) + 1];
    }

    public String group() {
        return group(0);
    }

    public String group(int group) {
        ensureMatch();
        int from = this.matchOffsets[group * 2];
        int to = this.matchOffsets[(group * 2) + 1];
        if (from == -1 || to == -1) {
            return null;
        }
        return this.input.substring(from, to);
    }

    public String group(String name) {
        throw new UnsupportedOperationException();
    }

    public int groupCount() {
        int groupCountImpl;
        synchronized (this) {
            groupCountImpl = groupCountImpl(this.address);
        }
        return groupCountImpl;
    }

    public boolean matches() {
        synchronized (this) {
            this.matchFound = matchesImpl(this.address, this.input, this.matchOffsets);
        }
        return this.matchFound;
    }

    public boolean find() {
        synchronized (this) {
            this.matchFound = findNextImpl(this.address, this.input, this.matchOffsets);
        }
        return this.matchFound;
    }

    public boolean find(int start) {
        if (start < 0 || start > this.input.length()) {
            throw new IndexOutOfBoundsException("start=" + start + "; length=" + this.input.length());
        }
        synchronized (this) {
            this.matchFound = findImpl(this.address, this.input, start, this.matchOffsets);
        }
        return this.matchFound;
    }

    public boolean lookingAt() {
        synchronized (this) {
            this.matchFound = lookingAtImpl(this.address, this.input, this.matchOffsets);
        }
        return this.matchFound;
    }

    public static String quoteReplacement(String s) {
        if (s.indexOf(92) == -1 && s.indexOf(36) == -1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' || c == '$') {
                sb.append('\\');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public Matcher appendReplacement(StringBuffer sb, String replacement) {
        sb.append(this.input.substring(this.appendPos, start()));
        appendEvaluated(sb, replacement);
        this.appendPos = end();
        return this;
    }

    private void appendEvaluated(StringBuffer buffer, String s) {
        boolean escape = false;
        boolean dollar = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && !escape) {
                escape = true;
            } else if (c == '$' && !escape) {
                dollar = true;
            } else if (c < '0' || c > '9' || !dollar) {
                buffer.append(c);
                dollar = false;
                escape = false;
            } else {
                buffer.append(group(c - '0'));
                dollar = false;
            }
        }
        if (escape) {
            throw new ArrayIndexOutOfBoundsException(s.length());
        }
    }

    public StringBuffer appendTail(StringBuffer sb) {
        if (this.appendPos < this.regionEnd) {
            sb.append(this.input.substring(this.appendPos, this.regionEnd));
        }
        return sb;
    }

    public String replaceAll(String replacement) {
        reset();
        StringBuffer buffer = new StringBuffer(this.input.length());
        while (find()) {
            appendReplacement(buffer, replacement);
        }
        return appendTail(buffer).toString();
    }

    public String replaceFirst(String replacement) {
        reset();
        StringBuffer buffer = new StringBuffer(this.input.length());
        if (find()) {
            appendReplacement(buffer, replacement);
        }
        return appendTail(buffer).toString();
    }

    public Matcher region(int start, int end) {
        return reset(this.input, start, end);
    }

    public int regionStart() {
        return this.regionStart;
    }

    public int regionEnd() {
        return this.regionEnd;
    }

    public boolean hasTransparentBounds() {
        return this.transparentBounds;
    }

    public Matcher useTransparentBounds(boolean value) {
        synchronized (this) {
            this.transparentBounds = value;
            useTransparentBoundsImpl(this.address, value);
        }
        return this;
    }

    public boolean hasAnchoringBounds() {
        return this.anchoringBounds;
    }

    public Matcher useAnchoringBounds(boolean value) {
        synchronized (this) {
            this.anchoringBounds = value;
            useAnchoringBoundsImpl(this.address, value);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("java.util.regex.Matcher");
        sb.append("[pattern=").append((Object) pattern());
        sb.append(" region=");
        sb.append(regionStart()).append(",").append(regionEnd());
        sb.append(" lastmatch=");
        if (this.matchFound && group() != null) {
            sb.append(group());
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean hitEnd() {
        boolean hitEndImpl;
        synchronized (this) {
            hitEndImpl = hitEndImpl(this.address);
        }
        return hitEndImpl;
    }

    public boolean requireEnd() {
        boolean requireEndImpl;
        synchronized (this) {
            requireEndImpl = requireEndImpl(this.address);
        }
        return requireEndImpl;
    }

    public Matcher reset() {
        return reset(this.input, 0, this.input.length());
    }

    public Matcher reset(CharSequence input2) {
        return reset(input2, 0, input2.length());
    }

    private Matcher reset(CharSequence input2, int start, int end) {
        if (input2 == null) {
            throw new IllegalArgumentException("input == null");
        } else if (start < 0 || end < 0 || start > input2.length() || end > input2.length() || start > end) {
            throw new IndexOutOfBoundsException();
        } else {
            this.input = input2.toString();
            this.regionStart = start;
            this.regionEnd = end;
            resetForInput();
            this.matchFound = false;
            this.appendPos = 0;
            return this;
        }
    }

    private void resetForInput() {
        synchronized (this) {
            setInputImpl(this.address, this.input, this.regionStart, this.regionEnd);
            useAnchoringBoundsImpl(this.address, this.anchoringBounds);
            useTransparentBoundsImpl(this.address, this.transparentBounds);
        }
    }

    private void ensureMatch() {
        if (!this.matchFound) {
            throw new IllegalStateException("No successful match so far");
        }
    }

    public int start() {
        return start(0);
    }

    public int start(int group) throws IllegalStateException {
        ensureMatch();
        return this.matchOffsets[group * 2];
    }
}
