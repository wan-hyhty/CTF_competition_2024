package java.lang;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class Character implements Serializable, Comparable<Character> {
    public static final int BYTES = 2;
    public static final byte COMBINING_SPACING_MARK = 8;
    public static final byte CONNECTOR_PUNCTUATION = 23;
    public static final byte CONTROL = 15;
    public static final byte CURRENCY_SYMBOL = 26;
    public static final byte DASH_PUNCTUATION = 20;
    public static final byte DECIMAL_DIGIT_NUMBER = 9;
    private static final byte[] DIRECTIONALITY = null;
    public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6;
    public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9;
    public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15;
    public static final byte DIRECTIONALITY_NONSPACING_MARK = 8;
    public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13;
    public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10;
    public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17;
    public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11;
    public static final byte DIRECTIONALITY_UNDEFINED = -1;
    public static final byte DIRECTIONALITY_WHITESPACE = 12;
    public static final byte ENCLOSING_MARK = 7;
    public static final byte END_PUNCTUATION = 22;
    static final int ERROR = -1;
    public static final byte FINAL_QUOTE_PUNCTUATION = 30;
    public static final byte FORMAT = 16;
    public static final byte INITIAL_QUOTE_PUNCTUATION = 29;
    public static final byte LETTER_NUMBER = 10;
    public static final byte LINE_SEPARATOR = 13;
    public static final byte LOWERCASE_LETTER = 2;
    public static final byte MATH_SYMBOL = 25;
    public static final int MAX_CODE_POINT = 1114111;
    public static final char MAX_HIGH_SURROGATE = '?';
    public static final char MAX_LOW_SURROGATE = '?';
    public static final int MAX_RADIX = 36;
    public static final char MAX_SURROGATE = '?';
    public static final char MAX_VALUE = '￿';
    public static final int MIN_CODE_POINT = 0;
    public static final char MIN_HIGH_SURROGATE = '?';
    public static final char MIN_LOW_SURROGATE = '?';
    public static final int MIN_RADIX = 2;
    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 65536;
    public static final char MIN_SURROGATE = '?';
    public static final char MIN_VALUE = '\u0000';
    public static final byte MODIFIER_LETTER = 4;
    public static final byte MODIFIER_SYMBOL = 27;
    public static final byte NON_SPACING_MARK = 6;
    public static final byte OTHER_LETTER = 5;
    public static final byte OTHER_NUMBER = 11;
    public static final byte OTHER_PUNCTUATION = 24;
    public static final byte OTHER_SYMBOL = 28;
    public static final byte PARAGRAPH_SEPARATOR = 14;
    public static final byte PRIVATE_USE = 18;
    public static final int SIZE = 16;
    public static final byte SPACE_SEPARATOR = 12;
    public static final byte START_PUNCTUATION = 21;
    public static final byte SURROGATE = 19;
    public static final byte TITLECASE_LETTER = 3;
    public static final Class<Character> TYPE = null;
    public static final byte UNASSIGNED = 0;
    public static final byte UPPERCASE_LETTER = 1;
    private static final long serialVersionUID = 3786198910865385080L;
    private final char value;

    static native int digitImpl(int i, int i2);

    static native byte getDirectionalityImpl(int i);

    private static native String getNameImpl(int i);

    static native int getNumericValueImpl(int i);

    static native int getTypeImpl(int i);

    static native boolean isAlphabeticImpl(int i);

    static native boolean isDefinedImpl(int i);

    static native boolean isDigitImpl(int i);

    static native boolean isIdentifierIgnorableImpl(int i);

    static native boolean isIdeographicImpl(int i);

    static native boolean isLetterImpl(int i);

    static native boolean isLetterOrDigitImpl(int i);

    static native boolean isLowerCaseImpl(int i);

    static native boolean isMirroredImpl(int i);

    static native boolean isSpaceCharImpl(int i);

    static native boolean isTitleCaseImpl(int i);

    static native boolean isUnicodeIdentifierPartImpl(int i);

    static native boolean isUnicodeIdentifierStartImpl(int i);

    static native boolean isUpperCaseImpl(int i);

    static native boolean isWhitespaceImpl(int i);

    static native int toLowerCaseImpl(int i);

    static native int toTitleCaseImpl(int i);

    static native int toUpperCaseImpl(int i);

    public static class Subset {
        private String name;

        protected Subset(String name2) {
            if (name2 == null) {
                throw new NullPointerException("name");
            }
            this.name = name2;
        }

        public final boolean equals(Object obj) {
            return this == obj;
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return this.name;
        }
    }

    public static final class UnicodeBlock extends Subset {
        public static final UnicodeBlock AEGEAN_NUMBERS = null;
        public static final UnicodeBlock ALCHEMICAL_SYMBOLS = null;
        public static final UnicodeBlock ALPHABETIC_PRESENTATION_FORMS = null;
        public static final UnicodeBlock ANCIENT_GREEK_MUSICAL_NOTATION = null;
        public static final UnicodeBlock ANCIENT_GREEK_NUMBERS = null;
        public static final UnicodeBlock ANCIENT_SYMBOLS = null;
        public static final UnicodeBlock ARABIC = null;
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_A = null;
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_B = null;
        public static final UnicodeBlock ARABIC_SUPPLEMENT = null;
        public static final UnicodeBlock ARMENIAN = null;
        public static final UnicodeBlock ARROWS = null;
        public static final UnicodeBlock AVESTAN = null;
        public static final UnicodeBlock BALINESE = null;
        public static final UnicodeBlock BAMUM = null;
        public static final UnicodeBlock BAMUM_SUPPLEMENT = null;
        public static final UnicodeBlock BASIC_LATIN = null;
        public static final UnicodeBlock BATAK = null;
        public static final UnicodeBlock BENGALI = null;
        public static final UnicodeBlock BLOCK_ELEMENTS = null;
        public static final UnicodeBlock BOPOMOFO = null;
        public static final UnicodeBlock BOPOMOFO_EXTENDED = null;
        public static final UnicodeBlock BOX_DRAWING = null;
        public static final UnicodeBlock BRAHMI = null;
        public static final UnicodeBlock BRAILLE_PATTERNS = null;
        public static final UnicodeBlock BUGINESE = null;
        public static final UnicodeBlock BUHID = null;
        public static final UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS = null;
        public static final UnicodeBlock CARIAN = null;
        public static final UnicodeBlock CHAM = null;
        public static final UnicodeBlock CHEROKEE = null;
        public static final UnicodeBlock CJK_COMPATIBILITY = null;
        public static final UnicodeBlock CJK_COMPATIBILITY_FORMS = null;
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS = null;
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = null;
        public static final UnicodeBlock CJK_RADICALS_SUPPLEMENT = null;
        public static final UnicodeBlock CJK_STROKES = null;
        public static final UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION = null;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS = null;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = null;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = null;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C = null;
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D = null;
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS = null;
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS_SUPPLEMENT = null;
        public static final UnicodeBlock COMBINING_HALF_MARKS = null;
        public static final UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS = null;
        public static final UnicodeBlock COMMON_INDIC_NUMBER_FORMS = null;
        public static final UnicodeBlock CONTROL_PICTURES = null;
        public static final UnicodeBlock COPTIC = null;
        public static final UnicodeBlock COUNTING_ROD_NUMERALS = null;
        public static final UnicodeBlock CUNEIFORM = null;
        public static final UnicodeBlock CUNEIFORM_NUMBERS_AND_PUNCTUATION = null;
        public static final UnicodeBlock CURRENCY_SYMBOLS = null;
        public static final UnicodeBlock CYPRIOT_SYLLABARY = null;
        public static final UnicodeBlock CYRILLIC = null;
        public static final UnicodeBlock CYRILLIC_EXTENDED_A = null;
        public static final UnicodeBlock CYRILLIC_EXTENDED_B = null;
        public static final UnicodeBlock CYRILLIC_SUPPLEMENTARY = null;
        public static final UnicodeBlock DESERET = null;
        public static final UnicodeBlock DEVANAGARI = null;
        public static final UnicodeBlock DEVANAGARI_EXTENDED = null;
        public static final UnicodeBlock DINGBATS = null;
        public static final UnicodeBlock DOMINO_TILES = null;
        public static final UnicodeBlock EGYPTIAN_HIEROGLYPHS = null;
        public static final UnicodeBlock EMOTICONS = null;
        public static final UnicodeBlock ENCLOSED_ALPHANUMERICS = null;
        public static final UnicodeBlock ENCLOSED_ALPHANUMERIC_SUPPLEMENT = null;
        public static final UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS = null;
        public static final UnicodeBlock ENCLOSED_IDEOGRAPHIC_SUPPLEMENT = null;
        public static final UnicodeBlock ETHIOPIC = null;
        public static final UnicodeBlock ETHIOPIC_EXTENDED = null;
        public static final UnicodeBlock ETHIOPIC_EXTENDED_A = null;
        public static final UnicodeBlock ETHIOPIC_SUPPLEMENT = null;
        public static final UnicodeBlock GENERAL_PUNCTUATION = null;
        public static final UnicodeBlock GEOMETRIC_SHAPES = null;
        public static final UnicodeBlock GEORGIAN = null;
        public static final UnicodeBlock GEORGIAN_SUPPLEMENT = null;
        public static final UnicodeBlock GLAGOLITIC = null;
        public static final UnicodeBlock GOTHIC = null;
        public static final UnicodeBlock GREEK = null;
        public static final UnicodeBlock GREEK_EXTENDED = null;
        public static final UnicodeBlock GUJARATI = null;
        public static final UnicodeBlock GURMUKHI = null;
        public static final UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS = null;
        public static final UnicodeBlock HANGUL_COMPATIBILITY_JAMO = null;
        public static final UnicodeBlock HANGUL_JAMO = null;
        public static final UnicodeBlock HANGUL_JAMO_EXTENDED_A = null;
        public static final UnicodeBlock HANGUL_JAMO_EXTENDED_B = null;
        public static final UnicodeBlock HANGUL_SYLLABLES = null;
        public static final UnicodeBlock HANUNOO = null;
        public static final UnicodeBlock HEBREW = null;
        public static final UnicodeBlock HIGH_PRIVATE_USE_SURROGATES = null;
        public static final UnicodeBlock HIGH_SURROGATES = null;
        public static final UnicodeBlock HIRAGANA = null;
        public static final UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS = null;
        public static final UnicodeBlock IMPERIAL_ARAMAIC = null;
        public static final UnicodeBlock INSCRIPTIONAL_PAHLAVI = null;
        public static final UnicodeBlock INSCRIPTIONAL_PARTHIAN = null;
        public static final UnicodeBlock IPA_EXTENSIONS = null;
        public static final UnicodeBlock JAVANESE = null;
        public static final UnicodeBlock KAITHI = null;
        public static final UnicodeBlock KANA_SUPPLEMENT = null;
        public static final UnicodeBlock KANBUN = null;
        public static final UnicodeBlock KANGXI_RADICALS = null;
        public static final UnicodeBlock KANNADA = null;
        public static final UnicodeBlock KATAKANA = null;
        public static final UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS = null;
        public static final UnicodeBlock KAYAH_LI = null;
        public static final UnicodeBlock KHAROSHTHI = null;
        public static final UnicodeBlock KHMER = null;
        public static final UnicodeBlock KHMER_SYMBOLS = null;
        public static final UnicodeBlock LAO = null;
        public static final UnicodeBlock LATIN_1_SUPPLEMENT = null;
        public static final UnicodeBlock LATIN_EXTENDED_A = null;
        public static final UnicodeBlock LATIN_EXTENDED_ADDITIONAL = null;
        public static final UnicodeBlock LATIN_EXTENDED_B = null;
        public static final UnicodeBlock LATIN_EXTENDED_C = null;
        public static final UnicodeBlock LATIN_EXTENDED_D = null;
        public static final UnicodeBlock LEPCHA = null;
        public static final UnicodeBlock LETTERLIKE_SYMBOLS = null;
        public static final UnicodeBlock LIMBU = null;
        public static final UnicodeBlock LINEAR_B_IDEOGRAMS = null;
        public static final UnicodeBlock LINEAR_B_SYLLABARY = null;
        public static final UnicodeBlock LISU = null;
        public static final UnicodeBlock LOW_SURROGATES = null;
        public static final UnicodeBlock LYCIAN = null;
        public static final UnicodeBlock LYDIAN = null;
        public static final UnicodeBlock MAHJONG_TILES = null;
        public static final UnicodeBlock MALAYALAM = null;
        public static final UnicodeBlock MANDAIC = null;
        public static final UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS = null;
        public static final UnicodeBlock MATHEMATICAL_OPERATORS = null;
        public static final UnicodeBlock MEETEI_MAYEK = null;
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = null;
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = null;
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS = null;
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS = null;
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS = null;
        public static final UnicodeBlock MISCELLANEOUS_TECHNICAL = null;
        public static final UnicodeBlock MODIFIER_TONE_LETTERS = null;
        public static final UnicodeBlock MONGOLIAN = null;
        public static final UnicodeBlock MUSICAL_SYMBOLS = null;
        public static final UnicodeBlock MYANMAR = null;
        public static final UnicodeBlock MYANMAR_EXTENDED_A = null;
        public static final UnicodeBlock NEW_TAI_LUE = null;
        public static final UnicodeBlock NKO = null;
        public static final UnicodeBlock NUMBER_FORMS = null;
        public static final UnicodeBlock OGHAM = null;
        public static final UnicodeBlock OLD_ITALIC = null;
        public static final UnicodeBlock OLD_PERSIAN = null;
        public static final UnicodeBlock OLD_SOUTH_ARABIAN = null;
        public static final UnicodeBlock OLD_TURKIC = null;
        public static final UnicodeBlock OL_CHIKI = null;
        public static final UnicodeBlock OPTICAL_CHARACTER_RECOGNITION = null;
        public static final UnicodeBlock ORIYA = null;
        public static final UnicodeBlock OSMANYA = null;
        public static final UnicodeBlock PHAGS_PA = null;
        public static final UnicodeBlock PHAISTOS_DISC = null;
        public static final UnicodeBlock PHOENICIAN = null;
        public static final UnicodeBlock PHONETIC_EXTENSIONS = null;
        public static final UnicodeBlock PHONETIC_EXTENSIONS_SUPPLEMENT = null;
        public static final UnicodeBlock PLAYING_CARDS = null;
        public static final UnicodeBlock PRIVATE_USE_AREA = null;
        public static final UnicodeBlock REJANG = null;
        public static final UnicodeBlock RUMI_NUMERAL_SYMBOLS = null;
        public static final UnicodeBlock RUNIC = null;
        public static final UnicodeBlock SAMARITAN = null;
        public static final UnicodeBlock SAURASHTRA = null;
        public static final UnicodeBlock SHAVIAN = null;
        public static final UnicodeBlock SINHALA = null;
        public static final UnicodeBlock SMALL_FORM_VARIANTS = null;
        public static final UnicodeBlock SPACING_MODIFIER_LETTERS = null;
        public static final UnicodeBlock SPECIALS = null;
        public static final UnicodeBlock SUNDANESE = null;
        public static final UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS = null;
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_A = null;
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_B = null;
        public static final UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS = null;
        public static final UnicodeBlock SUPPLEMENTAL_PUNCTUATION = null;
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A = null;
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B = null;
        @Deprecated
        public static final UnicodeBlock SURROGATES_AREA = null;
        public static final UnicodeBlock SYLOTI_NAGRI = null;
        public static final UnicodeBlock SYRIAC = null;
        public static final UnicodeBlock TAGALOG = null;
        public static final UnicodeBlock TAGBANWA = null;
        public static final UnicodeBlock TAGS = null;
        public static final UnicodeBlock TAI_LE = null;
        public static final UnicodeBlock TAI_THAM = null;
        public static final UnicodeBlock TAI_VIET = null;
        public static final UnicodeBlock TAI_XUAN_JING_SYMBOLS = null;
        public static final UnicodeBlock TAMIL = null;
        public static final UnicodeBlock TELUGU = null;
        public static final UnicodeBlock THAANA = null;
        public static final UnicodeBlock THAI = null;
        public static final UnicodeBlock TIBETAN = null;
        public static final UnicodeBlock TIFINAGH = null;
        public static final UnicodeBlock TRANSPORT_AND_MAP_SYMBOLS = null;
        public static final UnicodeBlock UGARITIC = null;
        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = null;
        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED = null;
        public static final UnicodeBlock VAI = null;
        public static final UnicodeBlock VARIATION_SELECTORS = null;
        public static final UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT = null;
        public static final UnicodeBlock VEDIC_EXTENSIONS = null;
        public static final UnicodeBlock VERTICAL_FORMS = null;
        public static final UnicodeBlock YIJING_HEXAGRAM_SYMBOLS = null;
        public static final UnicodeBlock YI_RADICALS = null;
        public static final UnicodeBlock YI_SYLLABLES = null;
        private static final int[] blockStarts = null;
        private static final UnicodeBlock[] blocks = null;
        private static Map<String, UnicodeBlock> map;

        private UnicodeBlock(String idName) {
            this(idName, true);
        }

        private UnicodeBlock(String idName, boolean isMap) {
            super(idName);
            if (isMap) {
                map.put(idName, this);
            }
        }

        private UnicodeBlock(String idName, String alias) {
            this(idName, true);
            map.put(alias, this);
        }

        private UnicodeBlock(String idName, String... aliases) {
            this(idName, true);
            for (String alias : aliases) {
                map.put(alias, this);
            }
        }

        public static UnicodeBlock of(char c) {
            return of((int) c);
        }

        public static UnicodeBlock of(int codePoint) {
            if (!Character.isValidCodePoint(codePoint)) {
                throw new IllegalArgumentException();
            }
            int bottom = 0;
            int top = blockStarts.length;
            int current = top / 2;
            while (top - bottom > 1) {
                if (codePoint >= blockStarts[current]) {
                    bottom = current;
                } else {
                    top = current;
                }
                current = (top + bottom) / 2;
            }
            return blocks[current];
        }

        public static final UnicodeBlock forName(String blockName) {
            UnicodeBlock block = map.get(blockName.toUpperCase(Locale.US));
            if (block != null) {
                return block;
            }
            throw new IllegalArgumentException();
        }
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum UnicodeScript {
        ;
        
        private static HashMap<String, UnicodeScript> aliases;
        private static final int[] scriptStarts = null;
        private static final UnicodeScript[] scripts = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.Character.UnicodeScript.forName(java.lang.String):java.lang.Character$UnicodeScript, dex: classes.dex
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
        public static final java.lang.Character.UnicodeScript forName(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.Character.UnicodeScript.forName(java.lang.String):java.lang.Character$UnicodeScript, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.Character.UnicodeScript.forName(java.lang.String):java.lang.Character$UnicodeScript");
        }

        public static UnicodeScript of(int codePoint) {
            if (!Character.isValidCodePoint(codePoint)) {
                throw new IllegalArgumentException();
            } else if (Character.getType(codePoint) == 0) {
                return UNKNOWN;
            } else {
                int index = Arrays.binarySearch(scriptStarts, codePoint);
                if (index < 0) {
                    index = (-index) - 2;
                }
                return scripts[index];
            }
        }
    }

    public Character(char value2) {
        this.value = value2;
    }

    private static class CharacterCache {
        static final Character[] cache = null;

        private CharacterCache() {
        }
    }

    public static Character valueOf(char c) {
        if (c <= 127) {
            return CharacterCache.cache[c];
        }
        return new Character(c);
    }

    public char charValue() {
        return this.value;
    }

    public int hashCode() {
        return hashCode(this.value);
    }

    public static int hashCode(char value2) {
        return value2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Character) || this.value != ((Character) obj).charValue()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.valueOf(new char[]{this.value});
    }

    public static String toString(char c) {
        return String.valueOf(c);
    }

    public static boolean isValidCodePoint(int codePoint) {
        return (codePoint >>> 16) < 17;
    }

    public static boolean isBmpCodePoint(int codePoint) {
        return (codePoint >>> 16) == 0;
    }

    public static boolean isSupplementaryCodePoint(int codePoint) {
        if (codePoint < 65536 || codePoint >= 1114112) {
            return false;
        }
        return true;
    }

    public static boolean isHighSurrogate(char ch) {
        return ch >= 55296 && ch < 56320;
    }

    public static boolean isLowSurrogate(char ch) {
        return ch >= 56320 && ch < 57344;
    }

    public static boolean isSurrogate(char ch) {
        return ch >= 55296 && ch < 57344;
    }

    public static boolean isSurrogatePair(char high, char low) {
        if (isHighSurrogate(high)) {
            return isLowSurrogate(low);
        }
        return false;
    }

    public static int charCount(int codePoint) {
        return codePoint >= 65536 ? 2 : 1;
    }

    public static int toCodePoint(char high, char low) {
        return ((high << 10) + low) - 56613888;
    }

    public static int codePointAt(CharSequence seq, int index) {
        int index2 = index + 1;
        char c1 = seq.charAt(index);
        if (isHighSurrogate(c1) && index2 < seq.length()) {
            char c2 = seq.charAt(index2);
            if (isLowSurrogate(c2)) {
                return toCodePoint(c1, c2);
            }
        }
        return c1;
    }

    public static int codePointAt(char[] a, int index) {
        return codePointAtImpl(a, index, a.length);
    }

    public static int codePointAt(char[] a, int index, int limit) {
        if (index < limit && limit >= 0 && limit <= a.length) {
            return codePointAtImpl(a, index, limit);
        }
        throw new IndexOutOfBoundsException();
    }

    static int codePointAtImpl(char[] a, int index, int limit) {
        int index2 = index + 1;
        char c1 = a[index];
        if (isHighSurrogate(c1) && index2 < limit) {
            char c2 = a[index2];
            if (isLowSurrogate(c2)) {
                return toCodePoint(c1, c2);
            }
        }
        return c1;
    }

    public static int codePointBefore(CharSequence seq, int index) {
        int index2 = index - 1;
        char c2 = seq.charAt(index2);
        if (isLowSurrogate(c2) && index2 > 0) {
            char c1 = seq.charAt(index2 - 1);
            if (isHighSurrogate(c1)) {
                return toCodePoint(c1, c2);
            }
        }
        return c2;
    }

    public static int codePointBefore(char[] a, int index) {
        return codePointBeforeImpl(a, index, 0);
    }

    public static int codePointBefore(char[] a, int index, int start) {
        if (index > start && start >= 0 && start < a.length) {
            return codePointBeforeImpl(a, index, start);
        }
        throw new IndexOutOfBoundsException();
    }

    static int codePointBeforeImpl(char[] a, int index, int start) {
        int index2 = index - 1;
        char c2 = a[index2];
        if (isLowSurrogate(c2) && index2 > start) {
            char c1 = a[index2 - 1];
            if (isHighSurrogate(c1)) {
                return toCodePoint(c1, c2);
            }
        }
        return c2;
    }

    public static char highSurrogate(int codePoint) {
        return (char) ((codePoint >>> 10) + 55232);
    }

    public static char lowSurrogate(int codePoint) {
        return (char) ((codePoint & 1023) + 56320);
    }

    public static int toChars(int codePoint, char[] dst, int dstIndex) {
        if (isBmpCodePoint(codePoint)) {
            dst[dstIndex] = (char) codePoint;
            return 1;
        } else if (isValidCodePoint(codePoint)) {
            toSurrogates(codePoint, dst, dstIndex);
            return 2;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static char[] toChars(int codePoint) {
        if (isBmpCodePoint(codePoint)) {
            return new char[]{(char) codePoint};
        } else if (isValidCodePoint(codePoint)) {
            char[] result = new char[2];
            toSurrogates(codePoint, result, 0);
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static void toSurrogates(int codePoint, char[] dst, int index) {
        dst[index + 1] = lowSurrogate(codePoint);
        dst[index] = highSurrogate(codePoint);
    }

    public static int codePointCount(CharSequence seq, int beginIndex, int endIndex) {
        int length = seq.length();
        if (beginIndex < 0 || endIndex > length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        int n = endIndex - beginIndex;
        int i = beginIndex;
        while (i < endIndex) {
            int i2 = i + 1;
            if (isHighSurrogate(seq.charAt(i)) && i2 < endIndex && isLowSurrogate(seq.charAt(i2))) {
                n--;
                i2++;
            }
            i = i2;
        }
        return n;
    }

    public static int codePointCount(char[] a, int offset, int count) {
        if (count <= a.length - offset && offset >= 0 && count >= 0) {
            return codePointCountImpl(a, offset, count);
        }
        throw new IndexOutOfBoundsException();
    }

    static int codePointCountImpl(char[] a, int offset, int count) {
        int endIndex = offset + count;
        int n = count;
        int i = offset;
        while (i < endIndex) {
            int i2 = i + 1;
            if (isHighSurrogate(a[i]) && i2 < endIndex && isLowSurrogate(a[i2])) {
                n--;
                i2++;
            }
            i = i2;
        }
        return n;
    }

    public static int offsetByCodePoints(CharSequence seq, int index, int codePointOffset) {
        int length = seq.length();
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        int x = index;
        if (codePointOffset >= 0) {
            int i = 0;
            int x2 = x;
            while (x2 < length && i < codePointOffset) {
                int x3 = x2 + 1;
                if (isHighSurrogate(seq.charAt(x2)) && x3 < length && isLowSurrogate(seq.charAt(x3))) {
                    x3++;
                }
                i++;
                x2 = x3;
            }
            if (i >= codePointOffset) {
                return x2;
            }
            throw new IndexOutOfBoundsException();
        }
        int i2 = codePointOffset;
        while (x > 0 && i2 < 0) {
            x--;
            if (isLowSurrogate(seq.charAt(x)) && x > 0 && isHighSurrogate(seq.charAt(x - 1))) {
                x--;
            }
            i2++;
        }
        if (i2 >= 0) {
            return x;
        }
        throw new IndexOutOfBoundsException();
    }

    public static int offsetByCodePoints(char[] a, int start, int count, int index, int codePointOffset) {
        if (count <= a.length - start && start >= 0 && count >= 0 && index >= start && index <= start + count) {
            return offsetByCodePointsImpl(a, start, count, index, codePointOffset);
        }
        throw new IndexOutOfBoundsException();
    }

    static int offsetByCodePointsImpl(char[] a, int start, int count, int index, int codePointOffset) {
        int x = index;
        if (codePointOffset >= 0) {
            int limit = start + count;
            int i = 0;
            int x2 = x;
            while (x2 < limit && i < codePointOffset) {
                int x3 = x2 + 1;
                if (isHighSurrogate(a[x2]) && x3 < limit && isLowSurrogate(a[x3])) {
                    x3++;
                }
                i++;
                x2 = x3;
            }
            if (i >= codePointOffset) {
                return x2;
            }
            throw new IndexOutOfBoundsException();
        }
        int i2 = codePointOffset;
        while (x > start && i2 < 0) {
            x--;
            if (isLowSurrogate(a[x]) && x > start && isHighSurrogate(a[x - 1])) {
                x--;
            }
            i2++;
        }
        if (i2 >= 0) {
            return x;
        }
        throw new IndexOutOfBoundsException();
    }

    public static boolean isLowerCase(char ch) {
        return isLowerCase((int) ch);
    }

    public static boolean isLowerCase(int codePoint) {
        return isLowerCaseImpl(codePoint);
    }

    public static boolean isUpperCase(char ch) {
        return isUpperCase((int) ch);
    }

    public static boolean isUpperCase(int codePoint) {
        return isUpperCaseImpl(codePoint);
    }

    public static boolean isTitleCase(char ch) {
        return isTitleCase((int) ch);
    }

    public static boolean isTitleCase(int codePoint) {
        return isTitleCaseImpl(codePoint);
    }

    public static boolean isDigit(char ch) {
        return isDigit((int) ch);
    }

    public static boolean isDigit(int codePoint) {
        return isDigitImpl(codePoint);
    }

    public static boolean isDefined(char ch) {
        return isDefined((int) ch);
    }

    public static boolean isDefined(int codePoint) {
        return isDefinedImpl(codePoint);
    }

    public static boolean isLetter(char ch) {
        return isLetter((int) ch);
    }

    public static boolean isLetter(int codePoint) {
        return isLetterImpl(codePoint);
    }

    public static boolean isLetterOrDigit(char ch) {
        return isLetterOrDigit((int) ch);
    }

    public static boolean isLetterOrDigit(int codePoint) {
        return isLetterOrDigitImpl(codePoint);
    }

    @Deprecated
    public static boolean isJavaLetter(char ch) {
        return isJavaIdentifierStart(ch);
    }

    @Deprecated
    public static boolean isJavaLetterOrDigit(char ch) {
        return isJavaIdentifierPart(ch);
    }

    public static boolean isAlphabetic(int codePoint) {
        return isAlphabeticImpl(codePoint);
    }

    public static boolean isIdeographic(int codePoint) {
        return isIdeographicImpl(codePoint);
    }

    public static boolean isJavaIdentifierStart(char ch) {
        return isJavaIdentifierStart((int) ch);
    }

    public static boolean isJavaIdentifierStart(int codePoint) {
        if (codePoint < 64) {
            if (codePoint == 36) {
                return true;
            }
            return false;
        } else if (codePoint < 128) {
            if (((1 << (codePoint - 64)) & 576460745995190270L) != 0) {
                return true;
            }
            return false;
        } else if (((1 << getType(codePoint)) & 75498558) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isJavaIdentifierPart(char ch) {
        return isJavaIdentifierPart((int) ch);
    }

    public static boolean isJavaIdentifierPart(int codePoint) {
        if (codePoint < 64) {
            if (((1 << codePoint) & 287948970162897407L) != 0) {
                return true;
            }
            return false;
        } else if (codePoint < 128) {
            if (((1 << (codePoint - 64)) & -8646911290859585538L) != 0) {
                return true;
            }
            return false;
        } else if (((1 << getType(codePoint)) & 75564926) != 0) {
            return true;
        } else {
            if (codePoint >= 0 && codePoint <= 8) {
                return true;
            }
            if (codePoint >= 14 && codePoint <= 27) {
                return true;
            }
            if (codePoint < 127 || codePoint > 159) {
                return false;
            }
            return true;
        }
    }

    public static boolean isUnicodeIdentifierStart(char ch) {
        return isUnicodeIdentifierStart((int) ch);
    }

    public static boolean isUnicodeIdentifierStart(int codePoint) {
        return isUnicodeIdentifierStartImpl(codePoint);
    }

    public static boolean isUnicodeIdentifierPart(char ch) {
        return isUnicodeIdentifierPart((int) ch);
    }

    public static boolean isUnicodeIdentifierPart(int codePoint) {
        return isUnicodeIdentifierPartImpl(codePoint);
    }

    public static boolean isIdentifierIgnorable(char ch) {
        return isIdentifierIgnorable((int) ch);
    }

    public static boolean isIdentifierIgnorable(int codePoint) {
        return isIdentifierIgnorableImpl(codePoint);
    }

    public static char toLowerCase(char ch) {
        return (char) toLowerCase((int) ch);
    }

    public static int toLowerCase(int codePoint) {
        if (codePoint >= 65 && codePoint <= 90) {
            return codePoint + 32;
        }
        if (codePoint < 128) {
            return codePoint;
        }
        return toLowerCaseImpl(codePoint);
    }

    public static char toUpperCase(char ch) {
        return (char) toUpperCase((int) ch);
    }

    public static int toUpperCase(int codePoint) {
        if (codePoint >= 97 && codePoint <= 122) {
            return codePoint - 32;
        }
        if (codePoint < 128) {
            return codePoint;
        }
        return toUpperCaseImpl(codePoint);
    }

    public static char toTitleCase(char ch) {
        return (char) toTitleCase((int) ch);
    }

    public static int toTitleCase(int codePoint) {
        return toTitleCaseImpl(codePoint);
    }

    public static int digit(char ch, int radix) {
        return digit((int) ch, radix);
    }

    public static int digit(int codePoint, int radix) {
        if (radix < 2 || radix > 36) {
            return -1;
        }
        if (codePoint >= 128) {
            return digitImpl(codePoint, radix);
        }
        int result = -1;
        if (48 <= codePoint && codePoint <= 57) {
            result = codePoint - 48;
        } else if (97 <= codePoint && codePoint <= 122) {
            result = (codePoint - 97) + 10;
        } else if (65 <= codePoint && codePoint <= 90) {
            result = (codePoint - 65) + 10;
        }
        if (result < radix) {
            return result;
        }
        return -1;
    }

    public static int getNumericValue(char ch) {
        return getNumericValue((int) ch);
    }

    public static int getNumericValue(int codePoint) {
        if (codePoint < 128) {
            if (codePoint >= 48 && codePoint <= 57) {
                return codePoint - 48;
            }
            if (codePoint >= 97 && codePoint <= 122) {
                return codePoint - 87;
            }
            if (codePoint < 65 || codePoint > 90) {
                return -1;
            }
            return codePoint - 55;
        } else if (codePoint >= 65313 && codePoint <= 65338) {
            return codePoint - 65303;
        } else {
            if (codePoint < 65345 || codePoint > 65370) {
                return getNumericValueImpl(codePoint);
            }
            return codePoint - 65335;
        }
    }

    @Deprecated
    public static boolean isSpace(char ch) {
        if (ch > ' ' || ((13824 >> ch) & 1) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isSpaceChar(char ch) {
        return isSpaceChar((int) ch);
    }

    public static boolean isSpaceChar(int codePoint) {
        if (codePoint == 32 || codePoint == 160) {
            return true;
        }
        if (codePoint < 4096) {
            return false;
        }
        if (codePoint == 5760 || codePoint == 6158) {
            return true;
        }
        if (codePoint < 8192) {
            return false;
        }
        if (codePoint > 65535) {
            return isSpaceCharImpl(codePoint);
        }
        if (codePoint <= 8202 || codePoint == 8232 || codePoint == 8233 || codePoint == 8239 || codePoint == 8287 || codePoint == 12288) {
            return true;
        }
        return false;
    }

    public static boolean isWhitespace(char ch) {
        return isWhitespace((int) ch);
    }

    public static boolean isWhitespace(int codePoint) {
        if ((codePoint >= 28 && codePoint <= 32) || (codePoint >= 9 && codePoint <= 13)) {
            return true;
        }
        if (codePoint < 4096) {
            return false;
        }
        if (codePoint == 5760 || codePoint == 6158) {
            return true;
        }
        if (codePoint < 8192 || codePoint == 8199 || codePoint == 8239) {
            return false;
        }
        if (codePoint > 65535) {
            return isWhitespaceImpl(codePoint);
        }
        if (codePoint <= 8202 || codePoint == 8232 || codePoint == 8233 || codePoint == 8287 || codePoint == 12288) {
            return true;
        }
        return false;
    }

    public static boolean isISOControl(char ch) {
        return isISOControl((int) ch);
    }

    public static boolean isISOControl(int codePoint) {
        if (codePoint <= 159) {
            return codePoint >= 127 || (codePoint >>> 5) == 0;
        }
        return false;
    }

    public static int getType(char ch) {
        return getType((int) ch);
    }

    public static int getType(int codePoint) {
        int type = getTypeImpl(codePoint);
        if (type <= 16) {
            return type;
        }
        return type + 1;
    }

    public static char forDigit(int digit, int radix) {
        if (digit >= radix || digit < 0 || radix < 2 || radix > 36) {
            return 0;
        }
        if (digit < 10) {
            return (char) (digit + 48);
        }
        return (char) (digit + 87);
    }

    public static byte getDirectionality(char ch) {
        return getDirectionality((int) ch);
    }

    public static byte getDirectionality(int codePoint) {
        byte directionality;
        if (getType(codePoint) != 0 && (directionality = getDirectionalityImpl(codePoint)) >= 0 && directionality < DIRECTIONALITY.length) {
            return DIRECTIONALITY[directionality];
        }
        return -1;
    }

    public static boolean isMirrored(char ch) {
        return isMirrored((int) ch);
    }

    public static boolean isMirrored(int codePoint) {
        return isMirroredImpl(codePoint);
    }

    public int compareTo(Character anotherCharacter) {
        return compare(this.value, anotherCharacter.value);
    }

    public static int compare(char x, char y) {
        return x - y;
    }

    public static char reverseBytes(char ch) {
        return (char) (((65280 & ch) >> 8) | (ch << 8));
    }

    public static String getName(int codePoint) {
        if (!isValidCodePoint(codePoint)) {
            throw new IllegalArgumentException();
        }
        String name = getNameImpl(codePoint);
        if (name != null) {
            return name;
        }
        if (getType(codePoint) == 0) {
            return null;
        }
        UnicodeBlock block = UnicodeBlock.of(codePoint);
        if (block != null) {
            return block.toString().replace('_', ' ') + " " + Integer.toHexString(codePoint).toUpperCase(Locale.ENGLISH);
        }
        return Integer.toHexString(codePoint).toUpperCase(Locale.ENGLISH);
    }
}
