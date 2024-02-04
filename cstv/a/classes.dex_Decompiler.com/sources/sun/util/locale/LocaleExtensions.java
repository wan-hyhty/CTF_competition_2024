package sun.util.locale;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import sun.util.locale.InternalLocaleBuilder;

public class LocaleExtensions {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f152assertionsDisabled = false;
    public static final LocaleExtensions CALENDAR_JAPANESE = null;
    public static final LocaleExtensions NUMBER_THAI = null;
    private final Map<Character, Extension> extensionMap;
    private final String id;

    private LocaleExtensions(String id2, Character key, Extension value) {
        this.id = id2;
        this.extensionMap = Collections.singletonMap(key, value);
    }

    LocaleExtensions(Map<InternalLocaleBuilder.CaseInsensitiveChar, String> extensions, Set<InternalLocaleBuilder.CaseInsensitiveString> uattributes, Map<InternalLocaleBuilder.CaseInsensitiveString, String> ukeywords) {
        boolean hasExtension = !LocaleUtils.isEmpty((Map<?, ?>) extensions);
        boolean hasUAttributes = !LocaleUtils.isEmpty((Set<?>) uattributes);
        boolean hasUKeywords = !LocaleUtils.isEmpty((Map<?, ?>) ukeywords);
        if (hasExtension || hasUAttributes || hasUKeywords) {
            SortedMap<Character, Extension> map = new TreeMap<>();
            if (hasExtension) {
                for (Map.Entry<InternalLocaleBuilder.CaseInsensitiveChar, String> ext : extensions.entrySet()) {
                    char key = LocaleUtils.toLower(ext.getKey().value());
                    String value = ext.getValue();
                    if (!LanguageTag.isPrivateusePrefixChar(key) || (value = InternalLocaleBuilder.removePrivateuseVariant(value)) != null) {
                        map.put(Character.valueOf(key), new Extension(key, LocaleUtils.toLowerString(value)));
                    }
                }
            }
            if (hasUAttributes || hasUKeywords) {
                SortedSet<String> uaset = null;
                TreeMap treeMap = null;
                if (hasUAttributes) {
                    uaset = new TreeSet<>();
                    for (InternalLocaleBuilder.CaseInsensitiveString cis : uattributes) {
                        uaset.add(LocaleUtils.toLowerString(cis.value()));
                    }
                }
                if (hasUKeywords) {
                    treeMap = new TreeMap();
                    for (Map.Entry<InternalLocaleBuilder.CaseInsensitiveString, String> kwd : ukeywords.entrySet()) {
                        treeMap.put(LocaleUtils.toLowerString(kwd.getKey().value()), LocaleUtils.toLowerString(kwd.getValue()));
                    }
                }
                map.put(117, new UnicodeLocaleExtension(uaset, (SortedMap<String, String>) treeMap));
            }
            if (map.isEmpty()) {
                this.id = "";
                this.extensionMap = Collections.emptyMap();
                return;
            }
            this.id = toID(map);
            this.extensionMap = map;
            return;
        }
        this.id = "";
        this.extensionMap = Collections.emptyMap();
    }

    public Set<Character> getKeys() {
        if (this.extensionMap.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(this.extensionMap.keySet());
    }

    public Extension getExtension(Character key) {
        return this.extensionMap.get(Character.valueOf(LocaleUtils.toLower(key.charValue())));
    }

    public String getExtensionValue(Character key) {
        Extension ext = this.extensionMap.get(Character.valueOf(LocaleUtils.toLower(key.charValue())));
        if (ext == null) {
            return null;
        }
        return ext.getValue();
    }

    public Set<String> getUnicodeLocaleAttributes() {
        Extension ext = this.extensionMap.get('u');
        if (ext == null) {
            return Collections.emptySet();
        }
        if (f152assertionsDisabled || (ext instanceof UnicodeLocaleExtension)) {
            return ((UnicodeLocaleExtension) ext).getUnicodeLocaleAttributes();
        }
        throw new AssertionError();
    }

    public Set<String> getUnicodeLocaleKeys() {
        Extension ext = this.extensionMap.get('u');
        if (ext == null) {
            return Collections.emptySet();
        }
        if (f152assertionsDisabled || (ext instanceof UnicodeLocaleExtension)) {
            return ((UnicodeLocaleExtension) ext).getUnicodeLocaleKeys();
        }
        throw new AssertionError();
    }

    public String getUnicodeLocaleType(String unicodeLocaleKey) {
        Extension ext = this.extensionMap.get('u');
        if (ext == null) {
            return null;
        }
        if (f152assertionsDisabled || (ext instanceof UnicodeLocaleExtension)) {
            return ((UnicodeLocaleExtension) ext).getUnicodeLocaleType(LocaleUtils.toLowerString(unicodeLocaleKey));
        }
        throw new AssertionError();
    }

    public boolean isEmpty() {
        return this.extensionMap.isEmpty();
    }

    public static boolean isValidKey(char c) {
        if (!LanguageTag.isExtensionSingletonChar(c)) {
            return LanguageTag.isPrivateusePrefixChar(c);
        }
        return true;
    }

    public static boolean isValidUnicodeLocaleKey(String ukey) {
        return UnicodeLocaleExtension.isKey(ukey);
    }

    private static String toID(SortedMap<Character, Extension> map) {
        StringBuilder buf = new StringBuilder();
        Extension privuse = null;
        for (Map.Entry<Character, Extension> entry : map.entrySet()) {
            char singleton = entry.getKey().charValue();
            Extension extension = entry.getValue();
            if (LanguageTag.isPrivateusePrefixChar(singleton)) {
                privuse = extension;
            } else {
                if (buf.length() > 0) {
                    buf.append(LanguageTag.SEP);
                }
                buf.append((Object) extension);
            }
        }
        if (privuse != null) {
            if (buf.length() > 0) {
                buf.append(LanguageTag.SEP);
            }
            buf.append((Object) privuse);
        }
        return buf.toString();
    }

    public String toString() {
        return this.id;
    }

    public String getID() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocaleExtensions)) {
            return false;
        }
        return this.id.equals(((LocaleExtensions) other).id);
    }
}
