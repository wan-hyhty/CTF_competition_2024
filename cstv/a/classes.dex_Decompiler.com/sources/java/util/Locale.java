package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.MessageFormat;
import libcore.icu.ICU;
import sun.util.LocaleServiceProviderPool;
import sun.util.locale.BaseLocale;
import sun.util.locale.InternalLocaleBuilder;
import sun.util.locale.LanguageTag;
import sun.util.locale.LocaleExtensions;
import sun.util.locale.LocaleObjectCache;
import sun.util.locale.LocaleSyntaxException;
import sun.util.locale.LocaleUtils;
import sun.util.locale.ParseStatus;
import sun.util.locale.UnicodeLocaleExtension;

public final class Locale implements Cloneable, Serializable {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f41assertionsDisabled = false;

    /* renamed from: -java-util-Locale$CategorySwitchesValues  reason: not valid java name */
    private static final /* synthetic */ int[] f42javautilLocale$CategorySwitchesValues = null;
    public static final Locale CANADA = null;
    public static final Locale CANADA_FRENCH = null;
    public static final Locale CHINA = null;
    public static final Locale CHINESE = null;
    private static final int DISPLAY_COUNTRY = 1;
    private static final int DISPLAY_LANGUAGE = 0;
    private static final int DISPLAY_SCRIPT = 3;
    private static final int DISPLAY_VARIANT = 2;
    public static final Locale ENGLISH = null;
    public static final Locale FRANCE = null;
    public static final Locale FRENCH = null;
    public static final Locale GERMAN = null;
    public static final Locale GERMANY = null;
    public static final Locale ITALIAN = null;
    public static final Locale ITALY = null;
    public static final Locale JAPAN = null;
    public static final Locale JAPANESE = null;
    public static final Locale KOREA = null;
    public static final Locale KOREAN = null;
    private static final Cache LOCALECACHE = null;
    public static final Locale PRC = null;
    public static final char PRIVATE_USE_EXTENSION = 'x';
    public static final Locale ROOT = null;
    public static final Locale SIMPLIFIED_CHINESE = null;
    public static final Locale TAIWAN = null;
    public static final Locale TRADITIONAL_CHINESE = null;
    public static final Locale UK = null;
    private static final String UNDETERMINED_LANGUAGE = "und";
    public static final char UNICODE_LOCALE_EXTENSION = 'u';
    public static final Locale US = null;
    private static Locale defaultDisplayLocale = null;
    private static Locale defaultFormatLocale = null;
    private static Locale defaultLocale = null;
    private static volatile String[] isoCountries = null;
    private static volatile String[] isoLanguages = null;
    private static final ObjectStreamField[] serialPersistentFields = null;
    static final long serialVersionUID = 9149081749638150636L;
    /* access modifiers changed from: private */
    public transient BaseLocale baseLocale;
    private volatile transient int hashCodeValue;
    /* access modifiers changed from: private */
    public transient LocaleExtensions localeExtensions;

    /* renamed from: -getjava-util-Locale$CategorySwitchesValues  reason: not valid java name */
    private static /* synthetic */ int[] m258getjavautilLocale$CategorySwitchesValues() {
        if (f42javautilLocale$CategorySwitchesValues != null) {
            return f42javautilLocale$CategorySwitchesValues;
        }
        int[] iArr = new int[Category.values().length];
        try {
            iArr[Category.DISPLAY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            iArr[Category.FORMAT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f42javautilLocale$CategorySwitchesValues = iArr;
        return iArr;
    }

    /* synthetic */ Locale(BaseLocale baseLocale2, LocaleExtensions extensions, Locale locale) {
        this(baseLocale2, extensions);
    }

    private Locale(BaseLocale baseLocale2, LocaleExtensions extensions) {
        this.hashCodeValue = 0;
        this.baseLocale = baseLocale2;
        this.localeExtensions = extensions;
    }

    public Locale(String language, String country, String variant) {
        this.hashCodeValue = 0;
        if (language == null || country == null || variant == null) {
            throw new NullPointerException();
        }
        this.baseLocale = BaseLocale.getInstance(convertOldISOCodes(language), "", country, variant);
        this.localeExtensions = getCompatibilityExtensions(language, "", country, variant);
    }

    public Locale(String language, String country) {
        this(language, country, "");
    }

    public Locale(String language) {
        this(language, "", "");
    }

    private static Locale createConstant(String lang, String country) {
        return getInstance(BaseLocale.createInstance(lang, country), (LocaleExtensions) null);
    }

    static Locale getInstance(String language, String country, String variant) {
        return getInstance(language, "", country, variant, (LocaleExtensions) null);
    }

    static Locale getInstance(String language, String script, String country, String variant, LocaleExtensions extensions) {
        if (language == null || script == null || country == null || variant == null) {
            throw new NullPointerException();
        }
        if (extensions == null) {
            extensions = getCompatibilityExtensions(language, script, country, variant);
        }
        return getInstance(BaseLocale.getInstance(language, script, country, variant), extensions);
    }

    static Locale getInstance(BaseLocale baseloc, LocaleExtensions extensions) {
        return (Locale) LOCALECACHE.get(new LocaleKey(baseloc, extensions, (LocaleKey) null));
    }

    private static class Cache extends LocaleObjectCache<LocaleKey, Locale> {
        /* synthetic */ Cache(Cache cache) {
            this();
        }

        private Cache() {
        }

        /* access modifiers changed from: protected */
        public Locale createObject(LocaleKey key) {
            return new Locale(key.base, key.exts, (Locale) null);
        }
    }

    private static final class LocaleKey {
        /* access modifiers changed from: private */
        public final BaseLocale base;
        /* access modifiers changed from: private */
        public final LocaleExtensions exts;
        private final int hash;

        /* synthetic */ LocaleKey(BaseLocale baseLocale, LocaleExtensions extensions, LocaleKey localeKey) {
            this(baseLocale, extensions);
        }

        private LocaleKey(BaseLocale baseLocale, LocaleExtensions extensions) {
            this.base = baseLocale;
            this.exts = extensions;
            int h = this.base.hashCode();
            this.hash = this.exts != null ? h ^ this.exts.hashCode() : h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocaleKey)) {
                return Locale.f41assertionsDisabled;
            }
            LocaleKey other = (LocaleKey) obj;
            if (this.hash != other.hash || !this.base.equals(other.base)) {
                return Locale.f41assertionsDisabled;
            }
            if (this.exts != null) {
                return this.exts.equals(other.exts);
            }
            if (other.exts == null) {
                return true;
            }
            return Locale.f41assertionsDisabled;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    public static Locale getDefault() {
        if (defaultLocale == null) {
            defaultLocale = initDefault();
        }
        return defaultLocale;
    }

    public static Locale getDefault(Category category) {
        switch (m258getjavautilLocale$CategorySwitchesValues()[category.ordinal()]) {
            case 1:
                if (defaultDisplayLocale == null) {
                    defaultDisplayLocale = initDefault(category);
                }
                return defaultDisplayLocale;
            case 2:
                if (defaultFormatLocale == null) {
                    defaultFormatLocale = initDefault(category);
                }
                return defaultFormatLocale;
            default:
                if (f41assertionsDisabled) {
                    return getDefault();
                }
                throw new AssertionError((Object) "Unknown Category");
        }
    }

    public static Locale initDefault() {
        String script;
        String country;
        String variant;
        String languageTag = System.getProperty("user.locale", "");
        if (!languageTag.isEmpty()) {
            return forLanguageTag(languageTag);
        }
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region");
        if (region != null) {
            int i = region.indexOf(95);
            if (i >= 0) {
                country = region.substring(0, i);
                variant = region.substring(i + 1);
            } else {
                country = region;
                variant = "";
            }
            script = "";
        } else {
            script = System.getProperty("user.script", "");
            country = System.getProperty("user.country", "");
            variant = System.getProperty("user.variant", "");
        }
        return getInstance(language, script, country, variant, (LocaleExtensions) null);
    }

    private static Locale initDefault(Category category) {
        Locale defaultLocale2 = getDefault();
        return getInstance(System.getProperty(category.languageKey, defaultLocale2.getLanguage()), System.getProperty(category.scriptKey, defaultLocale2.getScript()), System.getProperty(category.countryKey, defaultLocale2.getCountry()), System.getProperty(category.variantKey, defaultLocale2.getVariant()), (LocaleExtensions) null);
    }

    public static synchronized void setDefault(Locale newLocale) {
        synchronized (Locale.class) {
            setDefault(Category.DISPLAY, newLocale);
            setDefault(Category.FORMAT, newLocale);
            defaultLocale = newLocale;
            ICU.setDefaultLocale(newLocale.toLanguageTag());
        }
    }

    public static synchronized void setDefault(Category category, Locale newLocale) {
        synchronized (Locale.class) {
            if (category != null) {
                if (newLocale != null) {
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkPermission(new PropertyPermission("user.language", "write"));
                    }
                    switch (m258getjavautilLocale$CategorySwitchesValues()[category.ordinal()]) {
                        case 1:
                            defaultDisplayLocale = newLocale;
                            break;
                        case 2:
                            defaultFormatLocale = newLocale;
                            break;
                        default:
                            if (!f41assertionsDisabled) {
                                throw new AssertionError((Object) "Unknown Category");
                            }
                            break;
                    }
                } else {
                    throw new NullPointerException("Can't set default locale to NULL");
                }
            } else {
                throw new NullPointerException("Category cannot be NULL");
            }
        }
    }

    public static Locale[] getAvailableLocales() {
        return LocaleServiceProviderPool.getAllAvailableLocales();
    }

    public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    public String getLanguage() {
        return this.baseLocale.getLanguage();
    }

    public String getScript() {
        return this.baseLocale.getScript();
    }

    public String getCountry() {
        return this.baseLocale.getRegion();
    }

    public String getVariant() {
        return this.baseLocale.getVariant();
    }

    public String getExtension(char key) {
        if (!LocaleExtensions.isValidKey(key)) {
            throw new IllegalArgumentException("Ill-formed extension key: " + key);
        } else if (this.localeExtensions == null) {
            return null;
        } else {
            return this.localeExtensions.getExtensionValue(Character.valueOf(key));
        }
    }

    public Set<Character> getExtensionKeys() {
        if (this.localeExtensions == null) {
            return Collections.emptySet();
        }
        return this.localeExtensions.getKeys();
    }

    public Set<String> getUnicodeLocaleAttributes() {
        if (this.localeExtensions == null) {
            return Collections.emptySet();
        }
        return this.localeExtensions.getUnicodeLocaleAttributes();
    }

    public String getUnicodeLocaleType(String key) {
        if (!UnicodeLocaleExtension.isKey(key)) {
            throw new IllegalArgumentException("Ill-formed Unicode locale key: " + key);
        } else if (this.localeExtensions == null) {
            return null;
        } else {
            return this.localeExtensions.getUnicodeLocaleType(key);
        }
    }

    public Set<String> getUnicodeLocaleKeys() {
        if (this.localeExtensions == null) {
            return Collections.emptySet();
        }
        return this.localeExtensions.getUnicodeLocaleKeys();
    }

    /* access modifiers changed from: package-private */
    public BaseLocale getBaseLocale() {
        return this.baseLocale;
    }

    /* access modifiers changed from: package-private */
    public LocaleExtensions getLocaleExtensions() {
        return this.localeExtensions;
    }

    public final String toString() {
        boolean l = this.baseLocale.getLanguage().length() != 0 ? true : f41assertionsDisabled;
        boolean s = this.baseLocale.getScript().length() != 0 ? true : f41assertionsDisabled;
        boolean r = this.baseLocale.getRegion().length() != 0 ? true : f41assertionsDisabled;
        boolean v = this.baseLocale.getVariant().length() != 0 ? true : f41assertionsDisabled;
        boolean e = (this.localeExtensions == null || this.localeExtensions.getID().length() == 0) ? f41assertionsDisabled : true;
        StringBuilder result = new StringBuilder(this.baseLocale.getLanguage());
        if (r || (l && (v || s || e))) {
            result.append('_').append(this.baseLocale.getRegion());
        }
        if (v && (l || r)) {
            result.append('_').append(this.baseLocale.getVariant());
        }
        if (s && (l || r)) {
            result.append("_#").append(this.baseLocale.getScript());
        }
        if (e && (l || r)) {
            result.append('_');
            if (!s) {
                result.append('#');
            }
            result.append(this.localeExtensions.getID());
        }
        return result.toString();
    }

    public String toLanguageTag() {
        LanguageTag tag = LanguageTag.parseLocale(this.baseLocale, this.localeExtensions);
        StringBuilder buf = new StringBuilder();
        String subtag = tag.getLanguage();
        if (subtag.length() > 0) {
            buf.append(LanguageTag.canonicalizeLanguage(subtag));
        }
        String subtag2 = tag.getScript();
        if (subtag2.length() > 0) {
            buf.append(LanguageTag.SEP);
            buf.append(LanguageTag.canonicalizeScript(subtag2));
        }
        String subtag3 = tag.getRegion();
        if (subtag3.length() > 0) {
            buf.append(LanguageTag.SEP);
            buf.append(LanguageTag.canonicalizeRegion(subtag3));
        }
        for (String s : tag.getVariants()) {
            buf.append(LanguageTag.SEP);
            buf.append(s);
        }
        for (String s2 : tag.getExtensions()) {
            buf.append(LanguageTag.SEP);
            buf.append(LanguageTag.canonicalizeExtension(s2));
        }
        String subtag4 = tag.getPrivateuse();
        if (subtag4.length() > 0) {
            if (buf.length() > 0) {
                buf.append(LanguageTag.SEP);
            }
            buf.append(LanguageTag.PRIVATEUSE).append(LanguageTag.SEP);
            buf.append(subtag4);
        }
        return buf.toString();
    }

    public static Locale forLanguageTag(String languageTag) {
        LanguageTag tag = LanguageTag.parse(languageTag, (ParseStatus) null);
        InternalLocaleBuilder bldr = new InternalLocaleBuilder();
        bldr.setLanguageTag(tag);
        BaseLocale base = bldr.getBaseLocale();
        LocaleExtensions exts = bldr.getLocaleExtensions();
        if (exts == null && base.getVariant().length() > 0) {
            exts = getCompatibilityExtensions(base.getLanguage(), base.getScript(), base.getRegion(), base.getVariant());
        }
        return getInstance(base, exts);
    }

    public String getISO3Language() throws MissingResourceException {
        String lang = this.baseLocale.getLanguage();
        if (lang.length() == 3) {
            return lang;
        }
        if (lang.isEmpty()) {
            return "";
        }
        String language3 = ICU.getISO3Language(lang);
        if (lang.isEmpty() || !language3.isEmpty()) {
            return language3;
        }
        throw new MissingResourceException("Couldn't find 3-letter language code for " + lang, "FormatData_" + toString(), "ShortLanguage");
    }

    public String getISO3Country() throws MissingResourceException {
        String region = this.baseLocale.getRegion();
        if (region.length() == 3) {
            return this.baseLocale.getRegion();
        }
        if (region.isEmpty()) {
            return "";
        }
        String country3 = ICU.getISO3Country("en-" + region);
        if (region.isEmpty() || !country3.isEmpty()) {
            return country3;
        }
        throw new MissingResourceException("Couldn't find 3-letter country code for " + this.baseLocale.getRegion(), "FormatData_" + toString(), "ShortCountry");
    }

    public final String getDisplayLanguage() {
        return getDisplayLanguage(getDefault(Category.DISPLAY));
    }

    public String getDisplayLanguage(Locale locale) {
        String languageCode = this.baseLocale.getLanguage();
        if (languageCode.isEmpty()) {
            return "";
        }
        if ("und".equals(normalizeAndValidateLanguage(languageCode, f41assertionsDisabled))) {
            return languageCode;
        }
        String result = ICU.getDisplayLanguage(this, locale);
        if (result == null) {
            return ICU.getDisplayLanguage(this, getDefault());
        }
        return result;
    }

    private static String normalizeAndValidateLanguage(String language, boolean strict) {
        if (language == null || language.isEmpty()) {
            return "";
        }
        String lowercaseLanguage = language.toLowerCase(ROOT);
        if (isValidBcp47Alpha(lowercaseLanguage, 2, 3)) {
            return lowercaseLanguage;
        }
        if (!strict) {
            return "und";
        }
        throw new IllformedLocaleException("Invalid language: " + language);
    }

    private static boolean isAsciiAlphaNum(String string) {
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if ((character < 'a' || character > 'z') && ((character < 'A' || character > 'Z') && (character < '0' || character > '9'))) {
                return f41assertionsDisabled;
            }
        }
        return true;
    }

    public String getDisplayScript() {
        return getDisplayScript(getDefault());
    }

    public String getDisplayScript(Locale locale) {
        if (this.baseLocale.getScript().isEmpty()) {
            return "";
        }
        String result = ICU.getDisplayScript(this, locale);
        if (result == null) {
            return ICU.getDisplayScript(this, getDefault());
        }
        return result;
    }

    public final String getDisplayCountry() {
        return getDisplayCountry(getDefault(Category.DISPLAY));
    }

    public String getDisplayCountry(Locale locale) {
        String countryCode = this.baseLocale.getRegion();
        if (countryCode.isEmpty()) {
            return "";
        }
        if (normalizeAndValidateRegion(countryCode, f41assertionsDisabled).isEmpty()) {
            return countryCode;
        }
        String result = ICU.getDisplayCountry(this, locale);
        if (result == null) {
            return ICU.getDisplayCountry(this, getDefault());
        }
        return result;
    }

    private static String normalizeAndValidateRegion(String region, boolean strict) {
        if (region == null || region.isEmpty()) {
            return "";
        }
        String uppercaseRegion = region.toUpperCase(ROOT);
        if (isValidBcp47Alpha(uppercaseRegion, 2, 2) || isUnM49AreaCode(uppercaseRegion)) {
            return uppercaseRegion;
        }
        if (!strict) {
            return "";
        }
        throw new IllformedLocaleException("Invalid region: " + region);
    }

    private static boolean isValidBcp47Alpha(String string, int lowerBound, int upperBound) {
        int length = string.length();
        if (length < lowerBound || length > upperBound) {
            return f41assertionsDisabled;
        }
        for (int i = 0; i < length; i++) {
            char character = string.charAt(i);
            if ((character < 'a' || character > 'z') && (character < 'A' || character > 'Z')) {
                return f41assertionsDisabled;
            }
        }
        return true;
    }

    private static boolean isUnM49AreaCode(String code) {
        if (code.length() != 3) {
            return f41assertionsDisabled;
        }
        for (int i = 0; i < 3; i++) {
            char character = code.charAt(i);
            if (character < '0' || character > '9') {
                return f41assertionsDisabled;
            }
        }
        return true;
    }

    public final String getDisplayVariant() {
        return getDisplayVariant(getDefault(Category.DISPLAY));
    }

    public String getDisplayVariant(Locale locale) {
        String variantCode = this.baseLocale.getVariant();
        if (variantCode.isEmpty()) {
            return "";
        }
        try {
            normalizeAndValidateVariant(variantCode);
            String result = ICU.getDisplayVariant(this, locale);
            if (result == null) {
                result = ICU.getDisplayVariant(this, getDefault());
            }
            if (result.isEmpty()) {
                return variantCode;
            }
            return result;
        } catch (IllformedLocaleException e) {
            return variantCode;
        }
    }

    private static String normalizeAndValidateVariant(String variant) {
        if (variant == null || variant.isEmpty()) {
            return "";
        }
        String normalizedVariant = variant.replace('-', '_');
        for (String subTag : normalizedVariant.split(BaseLocale.SEP)) {
            if (!isValidVariantSubtag(subTag)) {
                throw new IllformedLocaleException("Invalid variant: " + variant);
            }
        }
        return normalizedVariant;
    }

    private static boolean isValidVariantSubtag(String subTag) {
        char firstChar;
        if (subTag.length() < 5 || subTag.length() > 8) {
            if (subTag.length() != 4 || (firstChar = subTag.charAt(0)) < '0' || firstChar > '9' || !isAsciiAlphaNum(subTag)) {
                return f41assertionsDisabled;
            }
            return true;
        } else if (isAsciiAlphaNum(subTag)) {
            return true;
        }
        return f41assertionsDisabled;
    }

    public final String getDisplayName() {
        return getDisplayName(getDefault(Category.DISPLAY));
    }

    public String getDisplayName(Locale locale) {
        int count = 0;
        StringBuilder buffer = new StringBuilder();
        String languageCode = this.baseLocale.getLanguage();
        if (!languageCode.isEmpty()) {
            String displayLanguage = getDisplayLanguage(locale);
            if (!displayLanguage.isEmpty()) {
                languageCode = displayLanguage;
            }
            buffer.append(languageCode);
            count = 1;
        }
        String scriptCode = this.baseLocale.getScript();
        if (!scriptCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            }
            String displayScript = getDisplayScript(locale);
            if (!displayScript.isEmpty()) {
                scriptCode = displayScript;
            }
            buffer.append(scriptCode);
            count++;
        }
        String countryCode = this.baseLocale.getRegion();
        if (!countryCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            } else if (count == 2) {
                buffer.append(",");
            }
            String displayCountry = getDisplayCountry(locale);
            if (!displayCountry.isEmpty()) {
                countryCode = displayCountry;
            }
            buffer.append(countryCode);
            count++;
        }
        String variantCode = this.baseLocale.getVariant();
        if (!variantCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            } else if (count == 2 || count == 3) {
                buffer.append(",");
            }
            String displayVariant = getDisplayVariant(locale);
            if (!displayVariant.isEmpty()) {
                variantCode = displayVariant;
            }
            buffer.append(variantCode);
            count++;
        }
        if (count > 1) {
            buffer.append(")");
        }
        return buffer.toString();
    }

    public Object clone() {
        try {
            return (Locale) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public int hashCode() {
        int hc = this.hashCodeValue;
        if (hc == 0) {
            hc = this.baseLocale.hashCode();
            if (this.localeExtensions != null) {
                hc ^= this.localeExtensions.hashCode();
            }
            this.hashCodeValue = hc;
        }
        return hc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Locale)) {
            return f41assertionsDisabled;
        }
        if (!this.baseLocale.equals(((Locale) obj).baseLocale)) {
            return f41assertionsDisabled;
        }
        if (this.localeExtensions != null) {
            return this.localeExtensions.equals(((Locale) obj).localeExtensions);
        }
        if (((Locale) obj).localeExtensions == null) {
            return true;
        }
        return f41assertionsDisabled;
    }

    private static String formatList(String[] stringList, String listPattern, String listCompositionPattern) {
        if (listPattern == null || listCompositionPattern == null) {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < stringList.length; i++) {
                if (i > 0) {
                    result.append(',');
                }
                result.append(stringList[i]);
            }
            return result.toString();
        }
        if (stringList.length > 3) {
            stringList = composeList(new MessageFormat(listCompositionPattern), stringList);
        }
        Object[] args = new Object[(stringList.length + 1)];
        System.arraycopy((Object) stringList, 0, (Object) args, 1, stringList.length);
        args[0] = new Integer(stringList.length);
        return new MessageFormat(listPattern).format(args);
    }

    private static String[] composeList(MessageFormat format, String[] list) {
        if (list.length <= 3) {
            return list;
        }
        String newItem = format.format(new String[]{list[0], list[1]});
        String[] newList = new String[(list.length - 1)];
        System.arraycopy((Object) list, 2, (Object) newList, 1, newList.length - 1);
        newList[0] = newItem;
        return composeList(format, newList);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("language", (Object) this.baseLocale.getLanguage());
        fields.put("script", (Object) this.baseLocale.getScript());
        fields.put("country", (Object) this.baseLocale.getRegion());
        fields.put("variant", (Object) this.baseLocale.getVariant());
        fields.put("extensions", (Object) this.localeExtensions == null ? "" : this.localeExtensions.getID());
        fields.put("hashcode", -1);
        out.writeFields();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        String extStr = (String) fields.get("extensions", (Object) "");
        this.baseLocale = BaseLocale.getInstance(convertOldISOCodes((String) fields.get("language", (Object) "")), (String) fields.get("script", (Object) ""), (String) fields.get("country", (Object) ""), (String) fields.get("variant", (Object) ""));
        if (extStr == null || extStr.length() <= 0) {
            this.localeExtensions = null;
            return;
        }
        try {
            InternalLocaleBuilder bldr = new InternalLocaleBuilder();
            bldr.setExtensions(extStr);
            this.localeExtensions = bldr.getLocaleExtensions();
        } catch (LocaleSyntaxException e) {
            throw new IllformedLocaleException(e.getMessage());
        }
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance(this.baseLocale.getLanguage(), this.baseLocale.getScript(), this.baseLocale.getRegion(), this.baseLocale.getVariant(), this.localeExtensions);
    }

    private static String convertOldISOCodes(String language) {
        String language2 = LocaleUtils.toLowerString(language).intern();
        if (language2 == "he") {
            return "iw";
        }
        if (language2 == "yi") {
            return "ji";
        }
        if (language2 == "id") {
            return "in";
        }
        return language2;
    }

    /* access modifiers changed from: private */
    public static LocaleExtensions getCompatibilityExtensions(String language, String script, String country, String variant) {
        if (LocaleUtils.caseIgnoreMatch(language, "ja") && script.length() == 0 && LocaleUtils.caseIgnoreMatch(country, "jp") && "JP".equals(variant)) {
            return LocaleExtensions.CALENDAR_JAPANESE;
        }
        if (!LocaleUtils.caseIgnoreMatch(language, "th") || script.length() != 0 || !LocaleUtils.caseIgnoreMatch(country, "th") || !"TH".equals(variant)) {
            return null;
        }
        return LocaleExtensions.NUMBER_THAI;
    }

    public static String adjustLanguageCode(String languageCode) {
        String adjusted = languageCode.toLowerCase(US);
        if (languageCode.equals("he")) {
            return "iw";
        }
        if (languageCode.equals("id")) {
            return "in";
        }
        if (languageCode.equals("yi")) {
            return "ji";
        }
        return adjusted;
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum Category {
        ;
        
        final String countryKey;
        final String languageKey;
        final String scriptKey;
        final String variantKey;

        private Category(String languageKey2, String scriptKey2, String countryKey2, String variantKey2) {
            this.languageKey = languageKey2;
            this.scriptKey = scriptKey2;
            this.countryKey = countryKey2;
            this.variantKey = variantKey2;
        }
    }

    public static final class Builder {
        private final InternalLocaleBuilder localeBuilder = new InternalLocaleBuilder();

        public Builder setLocale(Locale locale) {
            try {
                this.localeBuilder.setLocale(locale.baseLocale, locale.localeExtensions);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setLanguageTag(String languageTag) {
            ParseStatus sts = new ParseStatus();
            LanguageTag tag = LanguageTag.parse(languageTag, sts);
            if (sts.isError()) {
                throw new IllformedLocaleException(sts.getErrorMessage(), sts.getErrorIndex());
            }
            this.localeBuilder.setLanguageTag(tag);
            return this;
        }

        public Builder setLanguage(String language) {
            try {
                this.localeBuilder.setLanguage(language);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setScript(String script) {
            try {
                this.localeBuilder.setScript(script);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setRegion(String region) {
            try {
                this.localeBuilder.setRegion(region);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setVariant(String variant) {
            try {
                this.localeBuilder.setVariant(variant);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setExtension(char key, String value) {
            try {
                this.localeBuilder.setExtension(key, value);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder setUnicodeLocaleKeyword(String key, String type) {
            try {
                this.localeBuilder.setUnicodeLocaleKeyword(key, type);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder addUnicodeLocaleAttribute(String attribute) {
            try {
                this.localeBuilder.addUnicodeLocaleAttribute(attribute);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder removeUnicodeLocaleAttribute(String attribute) {
            if (attribute == null) {
                throw new NullPointerException("attribute == null");
            }
            try {
                this.localeBuilder.removeUnicodeLocaleAttribute(attribute);
                return this;
            } catch (LocaleSyntaxException e) {
                throw new IllformedLocaleException(e.getMessage(), e.getErrorIndex());
            }
        }

        public Builder clear() {
            this.localeBuilder.clear();
            return this;
        }

        public Builder clearExtensions() {
            this.localeBuilder.clearExtensions();
            return this;
        }

        public Locale build() {
            BaseLocale baseloc = this.localeBuilder.getBaseLocale();
            LocaleExtensions extensions = this.localeBuilder.getLocaleExtensions();
            if (extensions == null && baseloc.getVariant().length() > 0) {
                extensions = Locale.getCompatibilityExtensions(baseloc.getLanguage(), baseloc.getScript(), baseloc.getRegion(), baseloc.getVariant());
            }
            return Locale.getInstance(baseloc, extensions);
        }
    }
}
