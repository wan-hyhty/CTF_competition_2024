package sun.util.locale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LanguageTag {
    private static final Map<String, String[]> GRANDFATHERED = null;
    public static final String PRIVATEUSE = "x";
    public static final String PRIVUSE_VARIANT_PREFIX = "lvariant";
    public static final String SEP = "-";
    public static final String UNDETERMINED = "und";
    private List<String> extensions = Collections.emptyList();
    private List<String> extlangs = Collections.emptyList();
    private String language = "";
    private String privateuse = "";
    private String region = "";
    private String script = "";
    private List<String> variants = Collections.emptyList();

    private LanguageTag() {
    }

    public static LanguageTag parse(String languageTag, ParseStatus sts) {
        StringTokenIterator itr;
        if (sts == null) {
            sts = new ParseStatus();
        } else {
            sts.reset();
        }
        String[] gfmap = GRANDFATHERED.get(LocaleUtils.toLowerString(languageTag));
        if (gfmap != null) {
            itr = new StringTokenIterator(gfmap[1], SEP);
        } else {
            itr = new StringTokenIterator(languageTag, SEP);
        }
        LanguageTag tag = new LanguageTag();
        if (tag.parseLanguage(itr, sts)) {
            tag.parseExtlangs(itr, sts);
            tag.parseScript(itr, sts);
            tag.parseRegion(itr, sts);
            tag.parseVariants(itr, sts);
            tag.parseExtensions(itr, sts);
        }
        tag.parsePrivateuse(itr, sts);
        if (!itr.isDone() && !sts.isError()) {
            String s = itr.current();
            sts.errorIndex = itr.currentStart();
            if (s.length() == 0) {
                sts.errorMsg = "Empty subtag";
            } else {
                sts.errorMsg = "Invalid subtag: " + s;
            }
        }
        return tag;
    }

    private boolean parseLanguage(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s = itr.current();
        if (!isLanguage(s)) {
            return false;
        }
        this.language = s;
        sts.parseLength = itr.currentEnd();
        itr.next();
        return true;
    }

    private boolean parseExtlangs(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        boolean found = false;
        while (!itr.isDone()) {
            String s = itr.current();
            if (isExtlang(s)) {
                found = true;
                if (this.extlangs.isEmpty()) {
                    this.extlangs = new ArrayList(3);
                }
                this.extlangs.add(s);
                sts.parseLength = itr.currentEnd();
                itr.next();
                if (this.extlangs.size() == 3) {
                    break;
                }
            } else {
                break;
            }
        }
        return found;
    }

    private boolean parseScript(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s = itr.current();
        if (!isScript(s)) {
            return false;
        }
        this.script = s;
        sts.parseLength = itr.currentEnd();
        itr.next();
        return true;
    }

    private boolean parseRegion(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s = itr.current();
        if (!isRegion(s)) {
            return false;
        }
        this.region = s;
        sts.parseLength = itr.currentEnd();
        itr.next();
        return true;
    }

    private boolean parseVariants(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        boolean found = false;
        while (!itr.isDone()) {
            String s = itr.current();
            if (!isVariant(s)) {
                break;
            }
            found = true;
            if (this.variants.isEmpty()) {
                this.variants = new ArrayList(3);
            }
            this.variants.add(s);
            sts.parseLength = itr.currentEnd();
            itr.next();
        }
        return found;
    }

    private boolean parseExtensions(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        boolean found = false;
        while (true) {
            if (itr.isDone()) {
                break;
            }
            String s = itr.current();
            if (!isExtensionSingleton(s)) {
                break;
            }
            int start = itr.currentStart();
            String singleton = s;
            StringBuilder sb = new StringBuilder(s);
            itr.next();
            while (!itr.isDone()) {
                String s2 = itr.current();
                if (!isExtensionSubtag(s2)) {
                    break;
                }
                sb.append(SEP).append(s2);
                sts.parseLength = itr.currentEnd();
                itr.next();
            }
            if (sts.parseLength <= start) {
                sts.errorIndex = start;
                sts.errorMsg = "Incomplete extension '" + singleton + "'";
                break;
            }
            if (this.extensions.isEmpty()) {
                this.extensions = new ArrayList(4);
            }
            this.extensions.add(sb.toString());
            found = true;
        }
        return found;
    }

    private boolean parsePrivateuse(StringTokenIterator itr, ParseStatus sts) {
        if (itr.isDone() || sts.isError()) {
            return false;
        }
        String s = itr.current();
        if (!isPrivateusePrefix(s)) {
            return false;
        }
        int start = itr.currentStart();
        StringBuilder sb = new StringBuilder(s);
        itr.next();
        while (!itr.isDone()) {
            String s2 = itr.current();
            if (!isPrivateuseSubtag(s2)) {
                break;
            }
            sb.append(SEP).append(s2);
            sts.parseLength = itr.currentEnd();
            itr.next();
        }
        if (sts.parseLength <= start) {
            sts.errorIndex = start;
            sts.errorMsg = "Incomplete privateuse";
            return false;
        }
        this.privateuse = sb.toString();
        return true;
    }

    public static LanguageTag parseLocale(BaseLocale baseLocale, LocaleExtensions localeExtensions) {
        LanguageTag tag = new LanguageTag();
        String language2 = baseLocale.getLanguage();
        String script2 = baseLocale.getScript();
        String region2 = baseLocale.getRegion();
        String variant = baseLocale.getVariant();
        boolean hasSubtag = false;
        String privuseVar = null;
        if (isLanguage(language2)) {
            if (language2.equals("iw")) {
                language2 = "he";
            } else if (language2.equals("ji")) {
                language2 = "yi";
            } else if (language2.equals("in")) {
                language2 = "id";
            }
            tag.language = language2;
        }
        if (isScript(script2)) {
            tag.script = canonicalizeScript(script2);
            hasSubtag = true;
        }
        if (isRegion(region2)) {
            tag.region = canonicalizeRegion(region2);
            hasSubtag = true;
        }
        if (tag.language.equals("no") && tag.region.equals("NO") && variant.equals("NY")) {
            tag.language = "nn";
            variant = "";
        }
        if (variant.length() > 0) {
            List<String> variants2 = null;
            StringTokenIterator stringTokenIterator = new StringTokenIterator(variant, BaseLocale.SEP);
            while (!stringTokenIterator.isDone()) {
                String var = stringTokenIterator.current();
                if (!isVariant(var)) {
                    break;
                }
                if (variants2 == null) {
                    variants2 = new ArrayList<>();
                }
                variants2.add(var);
                stringTokenIterator.next();
            }
            if (variants2 != null) {
                tag.variants = variants2;
                hasSubtag = true;
            }
            if (!stringTokenIterator.isDone()) {
                StringBuilder buf = new StringBuilder();
                while (!stringTokenIterator.isDone()) {
                    String prvv = stringTokenIterator.current();
                    if (!isPrivateuseSubtag(prvv)) {
                        break;
                    }
                    if (buf.length() > 0) {
                        buf.append(SEP);
                    }
                    buf.append(prvv);
                    stringTokenIterator.next();
                }
                if (buf.length() > 0) {
                    privuseVar = buf.toString();
                }
            }
        }
        List<String> extensions2 = null;
        String privateuse2 = null;
        if (localeExtensions != null) {
            for (Character locextKey : localeExtensions.getKeys()) {
                Extension ext = localeExtensions.getExtension(locextKey);
                if (isPrivateusePrefixChar(locextKey.charValue())) {
                    privateuse2 = ext.getValue();
                } else {
                    if (extensions2 == null) {
                        extensions2 = new ArrayList<>();
                    }
                    extensions2.add(locextKey.toString() + SEP + ext.getValue());
                }
            }
        }
        if (extensions2 != null) {
            tag.extensions = extensions2;
            hasSubtag = true;
        }
        if (privuseVar != null) {
            if (privateuse2 == null) {
                privateuse2 = "lvariant-" + privuseVar;
            } else {
                privateuse2 = privateuse2 + SEP + PRIVUSE_VARIANT_PREFIX + SEP + privuseVar.replace((CharSequence) BaseLocale.SEP, (CharSequence) SEP);
            }
        }
        if (privateuse2 != null) {
            tag.privateuse = privateuse2;
        }
        if (tag.language.length() == 0 && (hasSubtag || privateuse2 == null)) {
            tag.language = UNDETERMINED;
        }
        return tag;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<String> getExtlangs() {
        if (this.extlangs.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.extlangs);
    }

    public String getScript() {
        return this.script;
    }

    public String getRegion() {
        return this.region;
    }

    public List<String> getVariants() {
        if (this.variants.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.variants);
    }

    public List<String> getExtensions() {
        if (this.extensions.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.extensions);
    }

    public String getPrivateuse() {
        return this.privateuse;
    }

    public static boolean isLanguage(String s) {
        int len = s.length();
        if (len < 2 || len > 8) {
            return false;
        }
        return LocaleUtils.isAlphaString(s);
    }

    public static boolean isExtlang(String s) {
        if (s.length() == 3) {
            return LocaleUtils.isAlphaString(s);
        }
        return false;
    }

    public static boolean isScript(String s) {
        if (s.length() == 4) {
            return LocaleUtils.isAlphaString(s);
        }
        return false;
    }

    public static boolean isRegion(String s) {
        if (s.length() == 2 && LocaleUtils.isAlphaString(s)) {
            return true;
        }
        if (s.length() == 3) {
            return LocaleUtils.isNumericString(s);
        }
        return false;
    }

    public static boolean isVariant(String s) {
        int len = s.length();
        if (len >= 5 && len <= 8) {
            return LocaleUtils.isAlphaNumericString(s);
        }
        if (len != 4 || !LocaleUtils.isNumeric(s.charAt(0)) || !LocaleUtils.isAlphaNumeric(s.charAt(1)) || !LocaleUtils.isAlphaNumeric(s.charAt(2))) {
            return false;
        }
        return LocaleUtils.isAlphaNumeric(s.charAt(3));
    }

    public static boolean isExtensionSingleton(String s) {
        return s.length() == 1 && LocaleUtils.isAlphaString(s) && !LocaleUtils.caseIgnoreMatch(PRIVATEUSE, s);
    }

    public static boolean isExtensionSingletonChar(char c) {
        return isExtensionSingleton(String.valueOf(c));
    }

    public static boolean isExtensionSubtag(String s) {
        int len = s.length();
        if (len < 2 || len > 8) {
            return false;
        }
        return LocaleUtils.isAlphaNumericString(s);
    }

    public static boolean isPrivateusePrefix(String s) {
        if (s.length() == 1) {
            return LocaleUtils.caseIgnoreMatch(PRIVATEUSE, s);
        }
        return false;
    }

    public static boolean isPrivateusePrefixChar(char c) {
        return LocaleUtils.caseIgnoreMatch(PRIVATEUSE, String.valueOf(c));
    }

    public static boolean isPrivateuseSubtag(String s) {
        int len = s.length();
        if (len < 1 || len > 8) {
            return false;
        }
        return LocaleUtils.isAlphaNumericString(s);
    }

    public static String canonicalizeLanguage(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public static String canonicalizeExtlang(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public static String canonicalizeScript(String s) {
        return LocaleUtils.toTitleString(s);
    }

    public static String canonicalizeRegion(String s) {
        return LocaleUtils.toUpperString(s);
    }

    public static String canonicalizeVariant(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public static String canonicalizeExtension(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public static String canonicalizeExtensionSingleton(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public static String canonicalizeExtensionSubtag(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public static String canonicalizePrivateuse(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public static String canonicalizePrivateuseSubtag(String s) {
        return LocaleUtils.toLowerString(s);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.language.length() > 0) {
            sb.append(this.language);
            for (String extlang : this.extlangs) {
                sb.append(SEP).append(extlang);
            }
            if (this.script.length() > 0) {
                sb.append(SEP).append(this.script);
            }
            if (this.region.length() > 0) {
                sb.append(SEP).append(this.region);
            }
            for (String variant : this.variants) {
                sb.append(SEP).append(variant);
            }
            for (String extension : this.extensions) {
                sb.append(SEP).append(extension);
            }
        }
        if (this.privateuse.length() > 0) {
            if (sb.length() > 0) {
                sb.append(SEP);
            }
            sb.append(this.privateuse);
        }
        return sb.toString();
    }
}
