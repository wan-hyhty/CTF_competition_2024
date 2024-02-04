package sun.util.locale;

public final class BaseLocale {
    private static final Cache CACHE = null;
    public static final String SEP = "_";
    private volatile int hash;
    private final String language;
    private final String region;
    private final String script;
    private final String variant;

    /* synthetic */ BaseLocale(String language2, String script2, String region2, String variant2, BaseLocale baseLocale) {
        this(language2, script2, region2, variant2);
    }

    private BaseLocale(String language2, String region2) {
        this.hash = 0;
        this.language = language2;
        this.script = "";
        this.region = region2;
        this.variant = "";
    }

    private BaseLocale(String language2, String script2, String region2, String variant2) {
        this.hash = 0;
        this.language = language2 != null ? LocaleUtils.toLowerString(language2).intern() : "";
        this.script = script2 != null ? LocaleUtils.toTitleString(script2).intern() : "";
        this.region = region2 != null ? LocaleUtils.toUpperString(region2).intern() : "";
        this.variant = variant2 != null ? variant2.intern() : "";
    }

    public static BaseLocale createInstance(String language2, String region2) {
        BaseLocale base = new BaseLocale(language2, region2);
        CACHE.put(new Key(language2, region2, (Key) null), base);
        return base;
    }

    public static BaseLocale getInstance(String language2, String script2, String region2, String variant2) {
        if (language2 != null) {
            if (LocaleUtils.caseIgnoreMatch(language2, "he")) {
                language2 = "iw";
            } else if (LocaleUtils.caseIgnoreMatch(language2, "yi")) {
                language2 = "ji";
            } else if (LocaleUtils.caseIgnoreMatch(language2, "id")) {
                language2 = "in";
            }
        }
        return (BaseLocale) CACHE.get(new Key(language2, script2, region2, variant2));
    }

    public String getLanguage() {
        return this.language;
    }

    public String getScript() {
        return this.script;
    }

    public String getRegion() {
        return this.region;
    }

    public String getVariant() {
        return this.variant;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseLocale)) {
            return false;
        }
        BaseLocale other = (BaseLocale) obj;
        if (this.language != other.language || this.script != other.script || this.region != other.region) {
            return false;
        }
        if (this.variant == other.variant) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (this.language.length() > 0) {
            buf.append("language=");
            buf.append(this.language);
        }
        if (this.script.length() > 0) {
            if (buf.length() > 0) {
                buf.append(", ");
            }
            buf.append("script=");
            buf.append(this.script);
        }
        if (this.region.length() > 0) {
            if (buf.length() > 0) {
                buf.append(", ");
            }
            buf.append("region=");
            buf.append(this.region);
        }
        if (this.variant.length() > 0) {
            if (buf.length() > 0) {
                buf.append(", ");
            }
            buf.append("variant=");
            buf.append(this.variant);
        }
        return buf.toString();
    }

    public int hashCode() {
        int h = this.hash;
        if (h != 0) {
            return h;
        }
        int h2 = (((((this.language.hashCode() * 31) + this.script.hashCode()) * 31) + this.region.hashCode()) * 31) + this.variant.hashCode();
        this.hash = h2;
        return h2;
    }

    private static final class Key implements Comparable<Key> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f150assertionsDisabled = false;
        private final int hash;
        /* access modifiers changed from: private */
        public final String lang;
        private final boolean normalized;
        /* access modifiers changed from: private */
        public final String regn;
        /* access modifiers changed from: private */
        public final String scrt;
        /* access modifiers changed from: private */
        public final String vart;

        /* synthetic */ Key(String language, String region, Key key) {
            this(language, region);
        }

        private Key(String language, String region) {
            boolean z = false;
            if (!f150assertionsDisabled) {
                if (language.intern() == language && region.intern() == region) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            this.lang = language;
            this.scrt = "";
            this.regn = region;
            this.vart = "";
            this.normalized = true;
            int h = language.hashCode();
            if (region != "") {
                int len = region.length();
                for (int i = 0; i < len; i++) {
                    h = (h * 31) + LocaleUtils.toLower(region.charAt(i));
                }
            }
            this.hash = h;
        }

        public Key(String language, String script, String region, String variant) {
            this(language, script, region, variant, false);
        }

        private Key(String language, String script, String region, String variant, boolean normalized2) {
            int h = 0;
            if (language != null) {
                this.lang = language;
                int len = language.length();
                for (int i = 0; i < len; i++) {
                    h = (h * 31) + LocaleUtils.toLower(language.charAt(i));
                }
            } else {
                this.lang = "";
            }
            if (script != null) {
                this.scrt = script;
                int len2 = script.length();
                for (int i2 = 0; i2 < len2; i2++) {
                    h = (h * 31) + LocaleUtils.toLower(script.charAt(i2));
                }
            } else {
                this.scrt = "";
            }
            if (region != null) {
                this.regn = region;
                int len3 = region.length();
                for (int i3 = 0; i3 < len3; i3++) {
                    h = (h * 31) + LocaleUtils.toLower(region.charAt(i3));
                }
            } else {
                this.regn = "";
            }
            if (variant != null) {
                this.vart = variant;
                int len4 = variant.length();
                for (int i4 = 0; i4 < len4; i4++) {
                    h = (h * 31) + variant.charAt(i4);
                }
            } else {
                this.vart = "";
            }
            this.hash = h;
            this.normalized = normalized2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key) || this.hash != ((Key) obj).hash || !LocaleUtils.caseIgnoreMatch(((Key) obj).lang, this.lang) || !LocaleUtils.caseIgnoreMatch(((Key) obj).scrt, this.scrt) || !LocaleUtils.caseIgnoreMatch(((Key) obj).regn, this.regn)) {
                return false;
            }
            return ((Key) obj).vart.equals(this.vart);
        }

        public int compareTo(Key other) {
            int res = LocaleUtils.caseIgnoreCompare(this.lang, other.lang);
            if (res != 0) {
                return res;
            }
            int res2 = LocaleUtils.caseIgnoreCompare(this.scrt, other.scrt);
            if (res2 != 0) {
                return res2;
            }
            int res3 = LocaleUtils.caseIgnoreCompare(this.regn, other.regn);
            if (res3 == 0) {
                return this.vart.compareTo(other.vart);
            }
            return res3;
        }

        public int hashCode() {
            return this.hash;
        }

        public static Key normalize(Key key) {
            if (key.normalized) {
                return key;
            }
            return new Key(LocaleUtils.toLowerString(key.lang).intern(), LocaleUtils.toTitleString(key.scrt).intern(), LocaleUtils.toUpperString(key.regn).intern(), key.vart.intern(), true);
        }
    }

    private static class Cache extends LocaleObjectCache<Key, BaseLocale> {
        /* access modifiers changed from: protected */
        public Key normalizeKey(Key key) {
            return Key.normalize(key);
        }

        /* access modifiers changed from: protected */
        public BaseLocale createObject(Key key) {
            return new BaseLocale(key.lang, key.scrt, key.regn, key.vart, (BaseLocale) null);
        }
    }
}
