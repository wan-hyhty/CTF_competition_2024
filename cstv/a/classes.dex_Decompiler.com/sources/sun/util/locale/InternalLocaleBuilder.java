package sun.util.locale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public final class InternalLocaleBuilder {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f151assertionsDisabled = false;
    private static final CaseInsensitiveChar PRIVATEUSE_KEY = null;
    private Map<CaseInsensitiveChar, String> extensions;
    private String language;
    private String region;
    private String script;
    private Set<CaseInsensitiveString> uattributes;
    private Map<CaseInsensitiveString, String> ukeywords;
    private String variant;

    static final class CaseInsensitiveString {
        private final String lowerStr;
        private final String str;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.<init>(java.lang.String):void, dex: classes.dex
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
        CaseInsensitiveString(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.<init>(java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.<init>(java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.equals(java.lang.Object):boolean, dex: classes.dex
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
        public boolean equals(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.equals(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.equals(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.hashCode():int, dex: classes.dex
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
        public int hashCode() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.hashCode():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.hashCode():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.value():java.lang.String, dex: classes.dex
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
        public java.lang.String value() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.value():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.locale.InternalLocaleBuilder.CaseInsensitiveString.value():java.lang.String");
        }
    }

    public InternalLocaleBuilder() {
        this.language = "";
        this.script = "";
        this.region = "";
        this.variant = "";
    }

    public InternalLocaleBuilder setLanguage(String language2) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(language2)) {
            this.language = "";
        } else if (!LanguageTag.isLanguage(language2)) {
            throw new LocaleSyntaxException("Ill-formed language: " + language2, 0);
        } else {
            this.language = language2;
        }
        return this;
    }

    public InternalLocaleBuilder setScript(String script2) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(script2)) {
            this.script = "";
        } else if (!LanguageTag.isScript(script2)) {
            throw new LocaleSyntaxException("Ill-formed script: " + script2, 0);
        } else {
            this.script = script2;
        }
        return this;
    }

    public InternalLocaleBuilder setRegion(String region2) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(region2)) {
            this.region = "";
        } else if (!LanguageTag.isRegion(region2)) {
            throw new LocaleSyntaxException("Ill-formed region: " + region2, 0);
        } else {
            this.region = region2;
        }
        return this;
    }

    public InternalLocaleBuilder setVariant(String variant2) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(variant2)) {
            this.variant = "";
        } else {
            String var = variant2.replaceAll(LanguageTag.SEP, BaseLocale.SEP);
            int errIdx = checkVariants(var, BaseLocale.SEP);
            if (errIdx != -1) {
                throw new LocaleSyntaxException("Ill-formed variant: " + variant2, errIdx);
            }
            this.variant = var;
        }
        return this;
    }

    public InternalLocaleBuilder addUnicodeLocaleAttribute(String attribute) throws LocaleSyntaxException {
        if (!UnicodeLocaleExtension.isAttribute(attribute)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale attribute: " + attribute);
        }
        if (this.uattributes == null) {
            this.uattributes = new HashSet(4);
        }
        this.uattributes.add(new CaseInsensitiveString(attribute));
        return this;
    }

    public InternalLocaleBuilder removeUnicodeLocaleAttribute(String attribute) throws LocaleSyntaxException {
        if (attribute == null || !UnicodeLocaleExtension.isAttribute(attribute)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale attribute: " + attribute);
        }
        if (this.uattributes != null) {
            this.uattributes.remove(new CaseInsensitiveString(attribute));
        }
        return this;
    }

    public InternalLocaleBuilder setUnicodeLocaleKeyword(String key, String type) throws LocaleSyntaxException {
        if (!UnicodeLocaleExtension.isKey(key)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale keyword key: " + key);
        }
        CaseInsensitiveString cikey = new CaseInsensitiveString(key);
        if (type != null) {
            if (type.length() != 0) {
                StringTokenIterator itr = new StringTokenIterator(type.replaceAll(BaseLocale.SEP, LanguageTag.SEP), LanguageTag.SEP);
                while (!itr.isDone()) {
                    if (!UnicodeLocaleExtension.isTypeSubtag(itr.current())) {
                        throw new LocaleSyntaxException("Ill-formed Unicode locale keyword type: " + type, itr.currentStart());
                    }
                    itr.next();
                }
            }
            if (this.ukeywords == null) {
                this.ukeywords = new HashMap(4);
            }
            this.ukeywords.put(cikey, type);
        } else if (this.ukeywords != null) {
            this.ukeywords.remove(cikey);
        }
        return this;
    }

    public InternalLocaleBuilder setExtension(char singleton, String value) throws LocaleSyntaxException {
        boolean validSubtag;
        boolean isBcpPrivateuse = LanguageTag.isPrivateusePrefixChar(singleton);
        if (isBcpPrivateuse || LanguageTag.isExtensionSingletonChar(singleton)) {
            boolean remove = LocaleUtils.isEmpty(value);
            CaseInsensitiveChar key = new CaseInsensitiveChar(singleton);
            if (!remove) {
                String val = value.replaceAll(BaseLocale.SEP, LanguageTag.SEP);
                StringTokenIterator itr = new StringTokenIterator(val, LanguageTag.SEP);
                while (!itr.isDone()) {
                    String s = itr.current();
                    if (isBcpPrivateuse) {
                        validSubtag = LanguageTag.isPrivateuseSubtag(s);
                    } else {
                        validSubtag = LanguageTag.isExtensionSubtag(s);
                    }
                    if (!validSubtag) {
                        throw new LocaleSyntaxException("Ill-formed extension value: " + s, itr.currentStart());
                    }
                    itr.next();
                }
                if (UnicodeLocaleExtension.isSingletonChar(key.value())) {
                    setUnicodeLocaleExtension(val);
                } else {
                    if (this.extensions == null) {
                        this.extensions = new HashMap(4);
                    }
                    this.extensions.put(key, val);
                }
            } else if (UnicodeLocaleExtension.isSingletonChar(key.value())) {
                if (this.uattributes != null) {
                    this.uattributes.clear();
                }
                if (this.ukeywords != null) {
                    this.ukeywords.clear();
                }
            } else if (this.extensions != null && this.extensions.containsKey(key)) {
                this.extensions.remove(key);
            }
            return this;
        }
        throw new LocaleSyntaxException("Ill-formed extension key: " + singleton);
    }

    public InternalLocaleBuilder setExtensions(String subtags) throws LocaleSyntaxException {
        if (LocaleUtils.isEmpty(subtags)) {
            clearExtensions();
            return this;
        }
        String subtags2 = subtags.replaceAll(BaseLocale.SEP, LanguageTag.SEP);
        StringTokenIterator itr = new StringTokenIterator(subtags2, LanguageTag.SEP);
        List<String> extensions2 = null;
        String privateuse = null;
        int parsed = 0;
        while (!itr.isDone()) {
            String s = itr.current();
            if (!LanguageTag.isExtensionSingleton(s)) {
                break;
            }
            int start = itr.currentStart();
            String singleton = s;
            StringBuilder sb = new StringBuilder(s);
            itr.next();
            while (!itr.isDone()) {
                String s2 = itr.current();
                if (!LanguageTag.isExtensionSubtag(s2)) {
                    break;
                }
                sb.append(LanguageTag.SEP).append(s2);
                parsed = itr.currentEnd();
                itr.next();
            }
            if (parsed < start) {
                throw new LocaleSyntaxException("Incomplete extension '" + singleton + "'", start);
            }
            if (extensions2 == null) {
                extensions2 = new ArrayList<>(4);
            }
            extensions2.add(sb.toString());
        }
        if (!itr.isDone()) {
            String s3 = itr.current();
            if (LanguageTag.isPrivateusePrefix(s3)) {
                int start2 = itr.currentStart();
                StringBuilder sb2 = new StringBuilder(s3);
                itr.next();
                while (!itr.isDone()) {
                    String s4 = itr.current();
                    if (!LanguageTag.isPrivateuseSubtag(s4)) {
                        break;
                    }
                    sb2.append(LanguageTag.SEP).append(s4);
                    parsed = itr.currentEnd();
                    itr.next();
                }
                if (parsed <= start2) {
                    throw new LocaleSyntaxException("Incomplete privateuse:" + subtags2.substring(start2), start2);
                }
                privateuse = sb2.toString();
            }
        }
        if (itr.isDone()) {
            return setExtensions(extensions2, privateuse);
        }
        throw new LocaleSyntaxException("Ill-formed extension subtags:" + subtags2.substring(itr.currentStart()), itr.currentStart());
    }

    private InternalLocaleBuilder setExtensions(List<String> bcpExtensions, String privateuse) {
        clearExtensions();
        if (!LocaleUtils.isEmpty((List<?>) bcpExtensions)) {
            Set<CaseInsensitiveChar> done = new HashSet<>(bcpExtensions.size());
            for (String bcpExt : bcpExtensions) {
                CaseInsensitiveChar key = new CaseInsensitiveChar(bcpExt, (CaseInsensitiveChar) null);
                if (!done.contains(key)) {
                    if (UnicodeLocaleExtension.isSingletonChar(key.value())) {
                        setUnicodeLocaleExtension(bcpExt.substring(2));
                    } else {
                        if (this.extensions == null) {
                            this.extensions = new HashMap(4);
                        }
                        this.extensions.put(key, bcpExt.substring(2));
                    }
                }
                done.add(key);
            }
        }
        if (privateuse != null && privateuse.length() > 0) {
            if (this.extensions == null) {
                this.extensions = new HashMap(1);
            }
            this.extensions.put(new CaseInsensitiveChar(privateuse, (CaseInsensitiveChar) null), privateuse.substring(2));
        }
        return this;
    }

    public InternalLocaleBuilder setLanguageTag(LanguageTag langtag) {
        clear();
        if (!langtag.getExtlangs().isEmpty()) {
            this.language = langtag.getExtlangs().get(0);
        } else {
            String lang = langtag.getLanguage();
            if (!lang.equals(LanguageTag.UNDETERMINED)) {
                this.language = lang;
            }
        }
        this.script = langtag.getScript();
        this.region = langtag.getRegion();
        List<String> bcpVariants = langtag.getVariants();
        if (!bcpVariants.isEmpty()) {
            StringBuilder var = new StringBuilder(bcpVariants.get(0));
            int size = bcpVariants.size();
            for (int i = 1; i < size; i++) {
                var.append(BaseLocale.SEP).append(bcpVariants.get(i));
            }
            this.variant = var.toString();
        }
        setExtensions(langtag.getExtensions(), langtag.getPrivateuse());
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        r15 = r15.replaceAll(sun.util.locale.LanguageTag.SEP, sun.util.locale.BaseLocale.SEP);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public sun.util.locale.InternalLocaleBuilder setLocale(sun.util.locale.BaseLocale r20, sun.util.locale.LocaleExtensions r21) throws sun.util.locale.LocaleSyntaxException {
        /*
            r19 = this;
            java.lang.String r7 = r20.getLanguage()
            java.lang.String r9 = r20.getScript()
            java.lang.String r8 = r20.getRegion()
            java.lang.String r15 = r20.getVariant()
            java.lang.String r16 = "ja"
            r0 = r16
            boolean r16 = r7.equals(r0)
            if (r16 == 0) goto L_0x00b5
            java.lang.String r16 = "JP"
            r0 = r16
            boolean r16 = r8.equals(r0)
            if (r16 == 0) goto L_0x00b5
            java.lang.String r16 = "JP"
            boolean r16 = r15.equals(r16)
            if (r16 == 0) goto L_0x00b5
            boolean r16 = f151assertionsDisabled
            if (r16 != 0) goto L_0x004d
            java.lang.String r16 = "japanese"
            java.lang.String r17 = "ca"
            r0 = r21
            r1 = r17
            java.lang.String r17 = r0.getUnicodeLocaleType(r1)
            boolean r16 = r16.equals(r17)
            if (r16 != 0) goto L_0x004d
            java.lang.AssertionError r16 = new java.lang.AssertionError
            r16.<init>()
            throw r16
        L_0x004d:
            java.lang.String r15 = ""
        L_0x0050:
            int r16 = r7.length()
            if (r16 <= 0) goto L_0x005c
            boolean r16 = sun.util.locale.LanguageTag.isLanguage(r7)
            if (r16 == 0) goto L_0x011e
        L_0x005c:
            int r16 = r9.length()
            if (r16 <= 0) goto L_0x0068
            boolean r16 = sun.util.locale.LanguageTag.isScript(r9)
            if (r16 == 0) goto L_0x013a
        L_0x0068:
            int r16 = r8.length()
            if (r16 <= 0) goto L_0x0074
            boolean r16 = sun.util.locale.LanguageTag.isRegion(r8)
            if (r16 == 0) goto L_0x0156
        L_0x0074:
            int r16 = r15.length()
            if (r16 <= 0) goto L_0x0172
            java.lang.String r16 = "-"
            java.lang.String r17 = "_"
            java.lang.String r15 = r15.replaceAll(r16, r17)
            java.lang.String r16 = "_"
            r0 = r19
            r1 = r16
            int r3 = r0.checkVariants(r15, r1)
            r16 = -1
            r0 = r16
            if (r3 == r0) goto L_0x0172
            sun.util.locale.LocaleSyntaxException r16 = new sun.util.locale.LocaleSyntaxException
            java.lang.StringBuilder r17 = new java.lang.StringBuilder
            r17.<init>()
            java.lang.String r18 = "Ill-formed variant: "
            java.lang.StringBuilder r17 = r17.append((java.lang.String) r18)
            r0 = r17
            java.lang.StringBuilder r17 = r0.append((java.lang.String) r15)
            java.lang.String r17 = r17.toString()
            r0 = r16
            r1 = r17
            r0.<init>(r1, r3)
            throw r16
        L_0x00b5:
            java.lang.String r16 = "th"
            r0 = r16
            boolean r16 = r7.equals(r0)
            if (r16 == 0) goto L_0x00f7
            java.lang.String r16 = "TH"
            r0 = r16
            boolean r16 = r8.equals(r0)
            if (r16 == 0) goto L_0x00f7
            java.lang.String r16 = "TH"
            boolean r16 = r15.equals(r16)
            if (r16 == 0) goto L_0x00f7
            boolean r16 = f151assertionsDisabled
            if (r16 != 0) goto L_0x00f2
            java.lang.String r16 = "thai"
            java.lang.String r17 = "nu"
            r0 = r21
            r1 = r17
            java.lang.String r17 = r0.getUnicodeLocaleType(r1)
            boolean r16 = r16.equals(r17)
            if (r16 != 0) goto L_0x00f2
            java.lang.AssertionError r16 = new java.lang.AssertionError
            r16.<init>()
            throw r16
        L_0x00f2:
            java.lang.String r15 = ""
            goto L_0x0050
        L_0x00f7:
            java.lang.String r16 = "no"
            r0 = r16
            boolean r16 = r7.equals(r0)
            if (r16 == 0) goto L_0x0050
            java.lang.String r16 = "NO"
            r0 = r16
            boolean r16 = r8.equals(r0)
            if (r16 == 0) goto L_0x0050
            java.lang.String r16 = "NY"
            boolean r16 = r15.equals(r16)
            if (r16 == 0) goto L_0x0050
            java.lang.String r7 = "nn"
            java.lang.String r15 = ""
            goto L_0x0050
        L_0x011e:
            sun.util.locale.LocaleSyntaxException r16 = new sun.util.locale.LocaleSyntaxException
            java.lang.StringBuilder r17 = new java.lang.StringBuilder
            r17.<init>()
            java.lang.String r18 = "Ill-formed language: "
            java.lang.StringBuilder r17 = r17.append((java.lang.String) r18)
            r0 = r17
            java.lang.StringBuilder r17 = r0.append((java.lang.String) r7)
            java.lang.String r17 = r17.toString()
            r16.<init>(r17)
            throw r16
        L_0x013a:
            sun.util.locale.LocaleSyntaxException r16 = new sun.util.locale.LocaleSyntaxException
            java.lang.StringBuilder r17 = new java.lang.StringBuilder
            r17.<init>()
            java.lang.String r18 = "Ill-formed script: "
            java.lang.StringBuilder r17 = r17.append((java.lang.String) r18)
            r0 = r17
            java.lang.StringBuilder r17 = r0.append((java.lang.String) r9)
            java.lang.String r17 = r17.toString()
            r16.<init>(r17)
            throw r16
        L_0x0156:
            sun.util.locale.LocaleSyntaxException r16 = new sun.util.locale.LocaleSyntaxException
            java.lang.StringBuilder r17 = new java.lang.StringBuilder
            r17.<init>()
            java.lang.String r18 = "Ill-formed region: "
            java.lang.StringBuilder r17 = r17.append((java.lang.String) r18)
            r0 = r17
            java.lang.StringBuilder r17 = r0.append((java.lang.String) r8)
            java.lang.String r17 = r17.toString()
            r16.<init>(r17)
            throw r16
        L_0x0172:
            r0 = r19
            r0.language = r7
            r0 = r19
            r0.script = r9
            r0 = r19
            r0.region = r8
            r0 = r19
            r0.variant = r15
            r19.clearExtensions()
            if (r21 != 0) goto L_0x01e3
            r4 = 0
        L_0x0188:
            if (r4 == 0) goto L_0x0253
            java.util.Iterator r6 = r4.iterator()
        L_0x018e:
            boolean r16 = r6.hasNext()
            if (r16 == 0) goto L_0x0253
            java.lang.Object r5 = r6.next()
            java.lang.Character r5 = (java.lang.Character) r5
            r0 = r21
            sun.util.locale.Extension r2 = r0.getExtension(r5)
            boolean r0 = r2 instanceof sun.util.locale.UnicodeLocaleExtension
            r16 = r0
            if (r16 == 0) goto L_0x0226
            r12 = r2
            sun.util.locale.UnicodeLocaleExtension r12 = (sun.util.locale.UnicodeLocaleExtension) r12
            java.util.Set r16 = r12.getUnicodeLocaleAttributes()
            java.util.Iterator r11 = r16.iterator()
        L_0x01b1:
            boolean r16 = r11.hasNext()
            if (r16 == 0) goto L_0x01e8
            java.lang.Object r10 = r11.next()
            java.lang.String r10 = (java.lang.String) r10
            r0 = r19
            java.util.Set<sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString> r0 = r0.uattributes
            r16 = r0
            if (r16 != 0) goto L_0x01d2
            java.util.HashSet r16 = new java.util.HashSet
            r17 = 4
            r16.<init>((int) r17)
            r0 = r16
            r1 = r19
            r1.uattributes = r0
        L_0x01d2:
            r0 = r19
            java.util.Set<sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString> r0 = r0.uattributes
            r16 = r0
            sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString r17 = new sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString
            r0 = r17
            r0.<init>(r10)
            r16.add(r17)
            goto L_0x01b1
        L_0x01e3:
            java.util.Set r4 = r21.getKeys()
            goto L_0x0188
        L_0x01e8:
            java.util.Set r16 = r12.getUnicodeLocaleKeys()
            java.util.Iterator r14 = r16.iterator()
        L_0x01f0:
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x018e
            java.lang.Object r13 = r14.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = r19
            java.util.Map<sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString, java.lang.String> r0 = r0.ukeywords
            r16 = r0
            if (r16 != 0) goto L_0x0211
            java.util.HashMap r16 = new java.util.HashMap
            r17 = 4
            r16.<init>((int) r17)
            r0 = r16
            r1 = r19
            r1.ukeywords = r0
        L_0x0211:
            r0 = r19
            java.util.Map<sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString, java.lang.String> r0 = r0.ukeywords
            r16 = r0
            sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString r17 = new sun.util.locale.InternalLocaleBuilder$CaseInsensitiveString
            r0 = r17
            r0.<init>(r13)
            java.lang.String r18 = r12.getUnicodeLocaleType(r13)
            r16.put(r17, r18)
            goto L_0x01f0
        L_0x0226:
            r0 = r19
            java.util.Map<sun.util.locale.InternalLocaleBuilder$CaseInsensitiveChar, java.lang.String> r0 = r0.extensions
            r16 = r0
            if (r16 != 0) goto L_0x023b
            java.util.HashMap r16 = new java.util.HashMap
            r17 = 4
            r16.<init>((int) r17)
            r0 = r16
            r1 = r19
            r1.extensions = r0
        L_0x023b:
            r0 = r19
            java.util.Map<sun.util.locale.InternalLocaleBuilder$CaseInsensitiveChar, java.lang.String> r0 = r0.extensions
            r16 = r0
            sun.util.locale.InternalLocaleBuilder$CaseInsensitiveChar r17 = new sun.util.locale.InternalLocaleBuilder$CaseInsensitiveChar
            char r18 = r5.charValue()
            r17.<init>((char) r18)
            java.lang.String r18 = r2.getValue()
            r16.put(r17, r18)
            goto L_0x018e
        L_0x0253:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.util.locale.InternalLocaleBuilder.setLocale(sun.util.locale.BaseLocale, sun.util.locale.LocaleExtensions):sun.util.locale.InternalLocaleBuilder");
    }

    public InternalLocaleBuilder clear() {
        this.language = "";
        this.script = "";
        this.region = "";
        this.variant = "";
        clearExtensions();
        return this;
    }

    public InternalLocaleBuilder clearExtensions() {
        if (this.extensions != null) {
            this.extensions.clear();
        }
        if (this.uattributes != null) {
            this.uattributes.clear();
        }
        if (this.ukeywords != null) {
            this.ukeywords.clear();
        }
        return this;
    }

    public BaseLocale getBaseLocale() {
        String privuse;
        String language2 = this.language;
        String script2 = this.script;
        String region2 = this.region;
        String variant2 = this.variant;
        if (!(this.extensions == null || (privuse = this.extensions.get(PRIVATEUSE_KEY)) == null)) {
            StringTokenIterator itr = new StringTokenIterator(privuse, LanguageTag.SEP);
            boolean sawPrefix = false;
            int privVarStart = -1;
            while (true) {
                if (itr.isDone()) {
                    break;
                } else if (sawPrefix) {
                    privVarStart = itr.currentStart();
                    break;
                } else {
                    if (LocaleUtils.caseIgnoreMatch(itr.current(), LanguageTag.PRIVUSE_VARIANT_PREFIX)) {
                        sawPrefix = true;
                    }
                    itr.next();
                }
            }
            if (privVarStart != -1) {
                StringBuilder sb = new StringBuilder(variant2);
                if (sb.length() != 0) {
                    sb.append(BaseLocale.SEP);
                }
                sb.append(privuse.substring(privVarStart).replaceAll(LanguageTag.SEP, BaseLocale.SEP));
                variant2 = sb.toString();
            }
        }
        return BaseLocale.getInstance(language2, script2, region2, variant2);
    }

    public LocaleExtensions getLocaleExtensions() {
        if (LocaleUtils.isEmpty((Map<?, ?>) this.extensions) && LocaleUtils.isEmpty((Set<?>) this.uattributes) && LocaleUtils.isEmpty((Map<?, ?>) this.ukeywords)) {
            return null;
        }
        LocaleExtensions lext = new LocaleExtensions(this.extensions, this.uattributes, this.ukeywords);
        if (lext.isEmpty()) {
            return null;
        }
        return lext;
    }

    static String removePrivateuseVariant(String privuseVal) {
        boolean z = true;
        StringTokenIterator itr = new StringTokenIterator(privuseVal, LanguageTag.SEP);
        int prefixStart = -1;
        boolean sawPrivuseVar = false;
        while (true) {
            if (itr.isDone()) {
                break;
            } else if (prefixStart != -1) {
                sawPrivuseVar = true;
                break;
            } else {
                if (LocaleUtils.caseIgnoreMatch(itr.current(), LanguageTag.PRIVUSE_VARIANT_PREFIX)) {
                    prefixStart = itr.currentStart();
                }
                itr.next();
            }
        }
        if (!sawPrivuseVar) {
            return privuseVal;
        }
        if (!f151assertionsDisabled) {
            if (prefixStart != 0 && prefixStart <= 1) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (prefixStart == 0) {
            return null;
        }
        return privuseVal.substring(0, prefixStart - 1);
    }

    private int checkVariants(String variants, String sep) {
        StringTokenIterator itr = new StringTokenIterator(variants, sep);
        while (!itr.isDone()) {
            if (!LanguageTag.isVariant(itr.current())) {
                return itr.currentStart();
            }
            itr.next();
        }
        return -1;
    }

    private void setUnicodeLocaleExtension(String subtags) {
        boolean z;
        boolean z2 = true;
        if (this.uattributes != null) {
            this.uattributes.clear();
        }
        if (this.ukeywords != null) {
            this.ukeywords.clear();
        }
        StringTokenIterator itr = new StringTokenIterator(subtags, LanguageTag.SEP);
        while (!itr.isDone() && UnicodeLocaleExtension.isAttribute(itr.current())) {
            if (this.uattributes == null) {
                this.uattributes = new HashSet(4);
            }
            this.uattributes.add(new CaseInsensitiveString(itr.current()));
            itr.next();
        }
        CaseInsensitiveString key = null;
        int typeStart = -1;
        int typeEnd = -1;
        while (!itr.isDone()) {
            if (key != null) {
                if (UnicodeLocaleExtension.isKey(itr.current())) {
                    if (!f151assertionsDisabled) {
                        if (typeStart == -1 || typeEnd != -1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                    }
                    String type = typeStart == -1 ? "" : subtags.substring(typeStart, typeEnd);
                    if (this.ukeywords == null) {
                        this.ukeywords = new HashMap(4);
                    }
                    this.ukeywords.put(key, type);
                    CaseInsensitiveString tmpKey = new CaseInsensitiveString(itr.current());
                    key = this.ukeywords.containsKey(tmpKey) ? null : tmpKey;
                    typeEnd = -1;
                    typeStart = -1;
                } else {
                    if (typeStart == -1) {
                        typeStart = itr.currentStart();
                    }
                    typeEnd = itr.currentEnd();
                }
            } else if (UnicodeLocaleExtension.isKey(itr.current())) {
                key = new CaseInsensitiveString(itr.current());
                if (this.ukeywords != null && this.ukeywords.containsKey(key)) {
                    key = null;
                }
            }
            if (itr.hasNext()) {
                itr.next();
            } else if (key != null) {
                if (!f151assertionsDisabled) {
                    if (typeStart != -1 && typeEnd == -1) {
                        z2 = false;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                String type2 = typeStart == -1 ? "" : subtags.substring(typeStart, typeEnd);
                if (this.ukeywords == null) {
                    this.ukeywords = new HashMap(4);
                }
                this.ukeywords.put(key, type2);
                return;
            } else {
                return;
            }
        }
    }

    static final class CaseInsensitiveChar {
        private final char ch;
        private final char lowerCh;

        /* synthetic */ CaseInsensitiveChar(String s, CaseInsensitiveChar caseInsensitiveChar) {
            this(s);
        }

        private CaseInsensitiveChar(String s) {
            this(s.charAt(0));
        }

        CaseInsensitiveChar(char c) {
            this.ch = c;
            this.lowerCh = LocaleUtils.toLower(this.ch);
        }

        public char value() {
            return this.ch;
        }

        public int hashCode() {
            return this.lowerCh;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CaseInsensitiveChar)) {
                return false;
            }
            if (this.lowerCh == ((CaseInsensitiveChar) obj).lowerCh) {
                return true;
            }
            return false;
        }
    }
}
