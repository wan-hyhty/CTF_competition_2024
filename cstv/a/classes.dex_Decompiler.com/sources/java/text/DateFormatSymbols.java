package java.text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import libcore.icu.LocaleData;
import libcore.icu.TimeZoneNames;
import sun.util.LocaleServiceProviderPool;

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
public class DateFormatSymbols implements Serializable, Cloneable {
    static final int PATTERN_AM_PM = 14;
    static final int PATTERN_DAY_OF_MONTH = 3;
    static final int PATTERN_DAY_OF_WEEK = 9;
    static final int PATTERN_DAY_OF_WEEK_IN_MONTH = 11;
    static final int PATTERN_DAY_OF_YEAR = 10;
    static final int PATTERN_ERA = 0;
    static final int PATTERN_HOUR0 = 16;
    static final int PATTERN_HOUR1 = 15;
    static final int PATTERN_HOUR_OF_DAY0 = 5;
    static final int PATTERN_HOUR_OF_DAY1 = 4;
    static final int PATTERN_ISO_DAY_OF_WEEK = 20;
    static final int PATTERN_ISO_ZONE = 21;
    static final int PATTERN_MILLISECOND = 8;
    static final int PATTERN_MINUTE = 6;
    static final int PATTERN_MONTH = 2;
    static final int PATTERN_SECOND = 7;
    static final int PATTERN_STANDALONE_DAY_OF_WEEK = 23;
    static final int PATTERN_STANDALONE_MONTH = 22;
    static final int PATTERN_WEEK_OF_MONTH = 13;
    static final int PATTERN_WEEK_OF_YEAR = 12;
    static final int PATTERN_WEEK_YEAR = 19;
    static final int PATTERN_YEAR = 1;
    static final int PATTERN_ZONE_NAME = 17;
    static final int PATTERN_ZONE_VALUE = 18;
    private static final ConcurrentMap<Locale, SoftReference<DateFormatSymbols>> cachedInstances = null;
    static final int currentSerialVersion = 1;
    static final int millisPerHour = 3600000;
    static final String patternChars = "GyMdkHmsSEDFwWahKzZYuXLc";
    static final long serialVersionUID = -5987973545549424702L;
    String[] ampms;
    String[] eras;
    transient boolean isZoneStringsSet;
    private transient int lastZoneIndex;
    String localPatternChars;
    Locale locale;
    String[] months;
    private int serialVersionOnStream;
    String[] shortMonths;
    private String[] shortStandAloneMonths;
    private String[] shortStandAloneWeekdays;
    String[] shortWeekdays;
    private String[] standAloneMonths;
    private String[] standAloneWeekdays;
    private String[] tinyMonths;
    private String[] tinyStandAloneMonths;
    private String[] tinyStandAloneWeekdays;
    private String[] tinyWeekdays;
    String[] weekdays;
    String[][] zoneStrings;

    private static class DateFormatSymbolsGetter implements LocaleServiceProviderPool.LocalizedObjectGetter<DateFormatSymbolsProvider, DateFormatSymbols> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f26assertionsDisabled = false;
        /* access modifiers changed from: private */
        public static final DateFormatSymbolsGetter INSTANCE = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.<clinit>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DateFormatSymbols.DateFormatSymbolsGetter.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        private DateFormatSymbolsGetter() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DateFormatSymbols.DateFormatSymbolsGetter.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public /* bridge */ /* synthetic */ java.lang.Object getObject(java.lang.Object r1, java.util.Locale r2, java.lang.String r3, java.lang.Object[] r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DateFormatSymbols.DateFormatSymbolsGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.getObject(java.text.spi.DateFormatSymbolsProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.DateFormatSymbols, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.text.DateFormatSymbols getObject(java.text.spi.DateFormatSymbolsProvider r1, java.util.Locale r2, java.lang.String r3, java.lang.Object... r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.DateFormatSymbols.DateFormatSymbolsGetter.getObject(java.text.spi.DateFormatSymbolsProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.DateFormatSymbols, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DateFormatSymbols.DateFormatSymbolsGetter.getObject(java.text.spi.DateFormatSymbolsProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.DateFormatSymbols");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.text.DateFormatSymbols.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.text.DateFormatSymbols.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.DateFormatSymbols.<clinit>():void");
    }

    public DateFormatSymbols() {
        this.eras = null;
        this.months = null;
        this.shortMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.ampms = null;
        this.zoneStrings = null;
        this.isZoneStringsSet = false;
        this.localPatternChars = null;
        this.locale = null;
        this.serialVersionOnStream = 1;
        this.lastZoneIndex = 0;
        initializeData(Locale.getDefault(Locale.Category.FORMAT));
    }

    public DateFormatSymbols(Locale locale2) {
        this.eras = null;
        this.months = null;
        this.shortMonths = null;
        this.weekdays = null;
        this.shortWeekdays = null;
        this.ampms = null;
        this.zoneStrings = null;
        this.isZoneStringsSet = false;
        this.localPatternChars = null;
        this.locale = null;
        this.serialVersionOnStream = 1;
        this.lastZoneIndex = 0;
        initializeData(locale2);
    }

    public static Locale[] getAvailableLocales() {
        return LocaleServiceProviderPool.getPool(DateFormatSymbolsProvider.class).getAvailableLocales();
    }

    public static final DateFormatSymbols getInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT));
    }

    public static final DateFormatSymbols getInstance(Locale locale2) {
        DateFormatSymbols dfs = getProviderInstance(locale2);
        if (dfs != null) {
            return dfs;
        }
        return (DateFormatSymbols) getCachedInstance(locale2).clone();
    }

    static final DateFormatSymbols getInstanceRef(Locale locale2) {
        DateFormatSymbols dfs = getProviderInstance(locale2);
        if (dfs != null) {
            return dfs;
        }
        return getCachedInstance(locale2);
    }

    private static DateFormatSymbols getProviderInstance(Locale locale2) {
        LocaleServiceProviderPool pool = LocaleServiceProviderPool.getPool(DateFormatSymbolsProvider.class);
        if (pool.hasProviders()) {
            return (DateFormatSymbols) pool.getLocalizedObject(DateFormatSymbolsGetter.INSTANCE, locale2, new Object[0]);
        }
        return null;
    }

    private static DateFormatSymbols getCachedInstance(Locale locale2) {
        DateFormatSymbols dfs;
        SoftReference<DateFormatSymbols> ref = (SoftReference) cachedInstances.get(locale2);
        if (ref != null && (dfs = ref.get()) != null) {
            return dfs;
        }
        DateFormatSymbols dfs2 = new DateFormatSymbols(locale2);
        SoftReference<DateFormatSymbols> ref2 = new SoftReference<>(dfs2);
        SoftReference<DateFormatSymbols> x = cachedInstances.putIfAbsent(locale2, ref2);
        if (x == null) {
            return dfs2;
        }
        DateFormatSymbols y = x.get();
        if (y != null) {
            return y;
        }
        cachedInstances.put(locale2, ref2);
        return dfs2;
    }

    public String[] getEras() {
        return (String[]) Arrays.copyOf((T[]) this.eras, this.eras.length);
    }

    public void setEras(String[] newEras) {
        this.eras = (String[]) Arrays.copyOf((T[]) newEras, newEras.length);
    }

    public String[] getMonths() {
        return (String[]) Arrays.copyOf((T[]) this.months, this.months.length);
    }

    public void setMonths(String[] newMonths) {
        this.months = (String[]) Arrays.copyOf((T[]) newMonths, newMonths.length);
    }

    public String[] getShortMonths() {
        return (String[]) Arrays.copyOf((T[]) this.shortMonths, this.shortMonths.length);
    }

    public void setShortMonths(String[] newShortMonths) {
        this.shortMonths = (String[]) Arrays.copyOf((T[]) newShortMonths, newShortMonths.length);
    }

    public String[] getWeekdays() {
        return (String[]) Arrays.copyOf((T[]) this.weekdays, this.weekdays.length);
    }

    public void setWeekdays(String[] newWeekdays) {
        this.weekdays = (String[]) Arrays.copyOf((T[]) newWeekdays, newWeekdays.length);
    }

    public String[] getShortWeekdays() {
        return (String[]) Arrays.copyOf((T[]) this.shortWeekdays, this.shortWeekdays.length);
    }

    public void setShortWeekdays(String[] newShortWeekdays) {
        this.shortWeekdays = (String[]) Arrays.copyOf((T[]) newShortWeekdays, newShortWeekdays.length);
    }

    public String[] getAmPmStrings() {
        return (String[]) Arrays.copyOf((T[]) this.ampms, this.ampms.length);
    }

    public void setAmPmStrings(String[] newAmpms) {
        this.ampms = (String[]) Arrays.copyOf((T[]) newAmpms, newAmpms.length);
    }

    public String[][] getZoneStrings() {
        return getZoneStringsImpl(true);
    }

    public void setZoneStrings(String[][] newZoneStrings) {
        String[][] aCopy = new String[newZoneStrings.length][];
        for (int i = 0; i < newZoneStrings.length; i++) {
            int len = newZoneStrings[i].length;
            if (len < 5) {
                throw new IllegalArgumentException();
            }
            aCopy[i] = (String[]) Arrays.copyOf((T[]) newZoneStrings[i], len);
        }
        this.zoneStrings = aCopy;
        this.isZoneStringsSet = true;
    }

    public String getLocalPatternChars() {
        return this.localPatternChars;
    }

    public void setLocalPatternChars(String newLocalPatternChars) {
        this.localPatternChars = newLocalPatternChars.toString();
    }

    /* access modifiers changed from: package-private */
    public String[] getTinyMonths() {
        return this.tinyMonths;
    }

    /* access modifiers changed from: package-private */
    public String[] getStandAloneMonths() {
        return this.standAloneMonths;
    }

    /* access modifiers changed from: package-private */
    public String[] getShortStandAloneMonths() {
        return this.shortStandAloneMonths;
    }

    /* access modifiers changed from: package-private */
    public String[] getTinyStandAloneMonths() {
        return this.tinyStandAloneMonths;
    }

    /* access modifiers changed from: package-private */
    public String[] getTinyWeekdays() {
        return this.tinyWeekdays;
    }

    /* access modifiers changed from: package-private */
    public String[] getStandAloneWeekdays() {
        return this.standAloneWeekdays;
    }

    /* access modifiers changed from: package-private */
    public String[] getShortStandAloneWeekdays() {
        return this.shortStandAloneWeekdays;
    }

    /* access modifiers changed from: package-private */
    public String[] getTinyStandAloneWeekdays() {
        return this.tinyStandAloneWeekdays;
    }

    public Object clone() {
        try {
            DateFormatSymbols other = (DateFormatSymbols) super.clone();
            copyMembers(this, other);
            return other;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public int hashCode() {
        int hashcode = 0;
        String[][] zoneStrings2 = getZoneStringsWrapper();
        for (String hashCode : zoneStrings2[0]) {
            hashcode ^= hashCode.hashCode();
        }
        return hashcode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DateFormatSymbols that = (DateFormatSymbols) obj;
        if (!Arrays.equals((Object[]) this.eras, (Object[]) that.eras) || !Arrays.equals((Object[]) this.months, (Object[]) that.months) || !Arrays.equals((Object[]) this.shortMonths, (Object[]) that.shortMonths) || !Arrays.equals((Object[]) this.tinyMonths, (Object[]) that.tinyMonths) || !Arrays.equals((Object[]) this.weekdays, (Object[]) that.weekdays) || !Arrays.equals((Object[]) this.shortWeekdays, (Object[]) that.shortWeekdays) || !Arrays.equals((Object[]) this.tinyWeekdays, (Object[]) that.tinyWeekdays) || !Arrays.equals((Object[]) this.standAloneMonths, (Object[]) that.standAloneMonths) || !Arrays.equals((Object[]) this.shortStandAloneMonths, (Object[]) that.shortStandAloneMonths) || !Arrays.equals((Object[]) this.tinyStandAloneMonths, (Object[]) that.tinyStandAloneMonths) || !Arrays.equals((Object[]) this.standAloneWeekdays, (Object[]) that.standAloneWeekdays) || !Arrays.equals((Object[]) this.shortStandAloneWeekdays, (Object[]) that.shortStandAloneWeekdays) || !Arrays.equals((Object[]) this.tinyStandAloneWeekdays, (Object[]) that.tinyStandAloneWeekdays) || !Arrays.equals((Object[]) this.ampms, (Object[]) that.ampms) || !Arrays.deepEquals(getZoneStringsWrapper(), that.getZoneStringsWrapper())) {
            return false;
        }
        if (this.localPatternChars != null && this.localPatternChars.equals(that.localPatternChars)) {
            return true;
        }
        if (this.localPatternChars != null) {
            return false;
        }
        if (that.localPatternChars == null) {
            return true;
        }
        return false;
    }

    private void initializeData(Locale desiredLocale) {
        DateFormatSymbols dfs;
        this.locale = desiredLocale;
        SoftReference<DateFormatSymbols> ref = (SoftReference) cachedInstances.get(this.locale);
        if (ref == null || (dfs = ref.get()) == null) {
            this.locale = LocaleData.mapInvalidAndNullLocales(this.locale);
            LocaleData localeData = LocaleData.get(this.locale);
            this.eras = localeData.eras;
            this.months = localeData.longMonthNames;
            this.shortMonths = localeData.shortMonthNames;
            this.ampms = localeData.amPm;
            this.localPatternChars = patternChars;
            this.weekdays = localeData.longWeekdayNames;
            this.shortWeekdays = localeData.shortWeekdayNames;
            initializeSupplementaryData(localeData);
            return;
        }
        copyMembers(dfs, this);
    }

    private void initializeSupplementaryData(LocaleData localeData) {
        this.tinyMonths = localeData.tinyMonthNames;
        this.tinyWeekdays = localeData.tinyWeekdayNames;
        this.standAloneMonths = localeData.longStandAloneMonthNames;
        this.shortStandAloneMonths = localeData.shortStandAloneMonthNames;
        this.tinyStandAloneMonths = localeData.tinyStandAloneMonthNames;
        this.standAloneWeekdays = localeData.longStandAloneWeekdayNames;
        this.shortStandAloneWeekdays = localeData.shortStandAloneWeekdayNames;
        this.tinyStandAloneWeekdays = localeData.tinyStandAloneWeekdayNames;
    }

    /* access modifiers changed from: package-private */
    public final int getZoneIndex(String ID) {
        String[][] zoneStrings2 = getZoneStringsWrapper();
        if (this.lastZoneIndex < zoneStrings2.length && ID.equals(zoneStrings2[this.lastZoneIndex][0])) {
            return this.lastZoneIndex;
        }
        for (int index = 0; index < zoneStrings2.length; index++) {
            if (ID.equals(zoneStrings2[index][0])) {
                this.lastZoneIndex = index;
                return index;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final String[][] getZoneStringsWrapper() {
        if (isSubclassObject()) {
            return getZoneStrings();
        }
        return getZoneStringsImpl(false);
    }

    private final synchronized String[][] internalZoneStrings() {
        String[][] strArr;
        synchronized (this) {
            if (this.zoneStrings == null) {
                this.zoneStrings = TimeZoneNames.getZoneStrings(this.locale);
                for (String[] zone : this.zoneStrings) {
                    String id = zone[0];
                    if (zone[1] == null) {
                        zone[1] = TimeZone.getTimeZone(id).getDisplayName(false, 1, this.locale);
                    }
                    if (zone[2] == null) {
                        zone[2] = TimeZone.getTimeZone(id).getDisplayName(false, 0, this.locale);
                    }
                    if (zone[3] == null) {
                        zone[3] = TimeZone.getTimeZone(id).getDisplayName(true, 1, this.locale);
                    }
                    if (zone[4] == null) {
                        zone[4] = TimeZone.getTimeZone(id).getDisplayName(true, 0, this.locale);
                    }
                }
            }
            strArr = this.zoneStrings;
        }
        return strArr;
    }

    private final String[][] getZoneStringsImpl(boolean needsCopy) {
        String[][] zoneStrings2 = internalZoneStrings();
        if (!needsCopy) {
            return zoneStrings2;
        }
        int len = zoneStrings2.length;
        String[][] aCopy = new String[len][];
        for (int i = 0; i < len; i++) {
            aCopy[i] = (String[]) Arrays.copyOf((T[]) zoneStrings2[i], zoneStrings2[i].length);
        }
        return aCopy;
    }

    private final boolean isSubclassObject() {
        return !getClass().getName().equals("java.text.DateFormatSymbols");
    }

    private final void copyMembers(DateFormatSymbols src, DateFormatSymbols dst) {
        dst.eras = (String[]) Arrays.copyOf((T[]) src.eras, src.eras.length);
        dst.months = (String[]) Arrays.copyOf((T[]) src.months, src.months.length);
        dst.shortMonths = (String[]) Arrays.copyOf((T[]) src.shortMonths, src.shortMonths.length);
        dst.weekdays = (String[]) Arrays.copyOf((T[]) src.weekdays, src.weekdays.length);
        dst.shortWeekdays = (String[]) Arrays.copyOf((T[]) src.shortWeekdays, src.shortWeekdays.length);
        dst.ampms = (String[]) Arrays.copyOf((T[]) src.ampms, src.ampms.length);
        if (src.zoneStrings != null) {
            dst.zoneStrings = src.getZoneStringsImpl(true);
        } else {
            dst.zoneStrings = null;
        }
        dst.localPatternChars = src.localPatternChars;
        dst.tinyMonths = src.tinyMonths;
        dst.tinyWeekdays = src.tinyWeekdays;
        dst.standAloneMonths = src.standAloneMonths;
        dst.shortStandAloneMonths = src.shortStandAloneMonths;
        dst.tinyStandAloneMonths = src.tinyStandAloneMonths;
        dst.standAloneWeekdays = src.standAloneWeekdays;
        dst.shortStandAloneWeekdays = src.shortStandAloneWeekdays;
        dst.tinyStandAloneWeekdays = src.tinyStandAloneWeekdays;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            initializeSupplementaryData(LocaleData.get(this.locale));
        }
        this.serialVersionOnStream = 1;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        internalZoneStrings();
        stream.defaultWriteObject();
    }
}
