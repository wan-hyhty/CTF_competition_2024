package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AccessControlContext;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.concurrent.ConcurrentMap;
import libcore.icu.LocaleData;
import sun.util.logging.PlatformLogger;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f35assertionsDisabled = false;
    static final int ALL_FIELDS = 131071;
    public static final int ALL_STYLES = 0;
    public static final int AM = 0;
    public static final int AM_PM = 9;
    static final int AM_PM_MASK = 512;
    public static final int APRIL = 3;
    public static final int AUGUST = 7;
    private static final int COMPUTED = 1;
    public static final int DATE = 5;
    static final int DATE_MASK = 32;
    public static final int DAY_OF_MONTH = 5;
    static final int DAY_OF_MONTH_MASK = 32;
    public static final int DAY_OF_WEEK = 7;
    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    static final int DAY_OF_WEEK_IN_MONTH_MASK = 256;
    static final int DAY_OF_WEEK_MASK = 128;
    public static final int DAY_OF_YEAR = 6;
    static final int DAY_OF_YEAR_MASK = 64;
    public static final int DECEMBER = 11;
    public static final int DST_OFFSET = 16;
    static final int DST_OFFSET_MASK = 65536;
    public static final int ERA = 0;
    static final int ERA_MASK = 1;
    public static final int FEBRUARY = 1;
    public static final int FIELD_COUNT = 17;
    private static final String[] FIELD_NAME = null;
    public static final int FRIDAY = 6;
    public static final int HOUR = 10;
    static final int HOUR_MASK = 1024;
    public static final int HOUR_OF_DAY = 11;
    static final int HOUR_OF_DAY_MASK = 2048;
    public static final int JANUARY = 0;
    public static final int JULY = 6;
    public static final int JUNE = 5;
    public static final int LONG = 2;
    public static final int MARCH = 2;
    public static final int MAY = 4;
    public static final int MILLISECOND = 14;
    static final int MILLISECOND_MASK = 16384;
    private static final int MINIMUM_USER_STAMP = 2;
    public static final int MINUTE = 12;
    static final int MINUTE_MASK = 4096;
    public static final int MONDAY = 2;
    public static final int MONTH = 2;
    static final int MONTH_MASK = 4;
    public static final int NOVEMBER = 10;
    public static final int OCTOBER = 9;
    public static final int PM = 1;
    public static final int SATURDAY = 7;
    public static final int SECOND = 13;
    static final int SECOND_MASK = 8192;
    public static final int SEPTEMBER = 8;
    public static final int SHORT = 1;
    public static final int SUNDAY = 1;
    public static final int THURSDAY = 5;
    public static final int TUESDAY = 3;
    public static final int UNDECIMBER = 12;
    private static final int UNSET = 0;
    public static final int WEDNESDAY = 4;
    public static final int WEEK_OF_MONTH = 4;
    static final int WEEK_OF_MONTH_MASK = 16;
    public static final int WEEK_OF_YEAR = 3;
    static final int WEEK_OF_YEAR_MASK = 8;
    public static final int YEAR = 1;
    static final int YEAR_MASK = 2;
    public static final int ZONE_OFFSET = 15;
    static final int ZONE_OFFSET_MASK = 32768;
    private static final ConcurrentMap<Locale, int[]> cachedLocaleData = null;
    static final int currentSerialVersion = 1;
    static final long serialVersionUID = -1807547505821590642L;
    transient boolean areAllFieldsSet;
    protected boolean areFieldsSet;
    protected int[] fields;
    private int firstDayOfWeek;
    protected boolean[] isSet;
    protected boolean isTimeSet;
    private boolean lenient;
    private int minimalDaysInFirstWeek;
    private int nextStamp;
    private int serialVersionOnStream;
    private transient boolean sharedZone;
    private transient int[] stamp;
    protected long time;
    private TimeZone zone;

    private static class CalendarAccessControlContext {
        private static final AccessControlContext INSTANCE = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.Calendar.CalendarAccessControlContext.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private CalendarAccessControlContext() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.Calendar.CalendarAccessControlContext.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Calendar.CalendarAccessControlContext.<init>():void");
        }
    }

    public abstract void add(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void computeFields();

    /* access modifiers changed from: protected */
    public abstract void computeTime();

    public abstract int getGreatestMinimum(int i);

    public abstract int getLeastMaximum(int i);

    public abstract int getMaximum(int i);

    public abstract int getMinimum(int i);

    public abstract void roll(int i, boolean z);

    protected Calendar() {
        this(TimeZone.getDefaultRef(), Locale.getDefault(Locale.Category.FORMAT));
        this.sharedZone = true;
    }

    protected Calendar(TimeZone zone2, Locale aLocale) {
        this.lenient = true;
        this.sharedZone = f35assertionsDisabled;
        this.nextStamp = 2;
        this.serialVersionOnStream = 1;
        aLocale = aLocale == null ? Locale.getDefault() : aLocale;
        this.fields = new int[17];
        this.isSet = new boolean[17];
        this.stamp = new int[17];
        this.zone = zone2;
        setWeekCountData(aLocale);
    }

    public static Calendar getInstance() {
        Calendar cal = createCalendar(TimeZone.getDefaultRef(), Locale.getDefault(Locale.Category.FORMAT));
        cal.sharedZone = true;
        return cal;
    }

    public static Calendar getInstance(TimeZone zone2) {
        return createCalendar(zone2, Locale.getDefault(Locale.Category.FORMAT));
    }

    public static Calendar getInstance(Locale aLocale) {
        Calendar cal = createCalendar(TimeZone.getDefaultRef(), aLocale);
        cal.sharedZone = true;
        return cal;
    }

    public static Calendar getInstance(TimeZone zone2, Locale aLocale) {
        return createCalendar(zone2, aLocale);
    }

    private static Calendar createCalendar(TimeZone zone2, Locale aLocale) {
        return new GregorianCalendar(zone2, aLocale);
    }

    public static synchronized Locale[] getAvailableLocales() {
        Locale[] availableLocales;
        synchronized (Calendar.class) {
            availableLocales = DateFormat.getAvailableLocales();
        }
        return availableLocales;
    }

    public final Date getTime() {
        return new Date(getTimeInMillis());
    }

    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }

    public long getTimeInMillis() {
        if (!this.isTimeSet) {
            updateTime();
        }
        return this.time;
    }

    public void setTimeInMillis(long millis) {
        if (this.time != millis || !this.isTimeSet || !this.areFieldsSet || !this.areAllFieldsSet) {
            this.time = millis;
            this.isTimeSet = true;
            this.areFieldsSet = f35assertionsDisabled;
            computeFields();
            this.areFieldsSet = true;
            this.areAllFieldsSet = true;
        }
    }

    public int get(int field) {
        complete();
        return internalGet(field);
    }

    /* access modifiers changed from: protected */
    public final int internalGet(int field) {
        return this.fields[field];
    }

    /* access modifiers changed from: package-private */
    public final void internalSet(int field, int value) {
        this.fields[field] = value;
    }

    public void set(int field, int value) {
        if (this.areFieldsSet && !this.areAllFieldsSet) {
            computeFields();
        }
        internalSet(field, value);
        this.isTimeSet = f35assertionsDisabled;
        this.areFieldsSet = f35assertionsDisabled;
        this.isSet[field] = true;
        int[] iArr = this.stamp;
        int i = this.nextStamp;
        this.nextStamp = i + 1;
        iArr[field] = i;
        if (this.nextStamp == Integer.MAX_VALUE) {
            adjustStamp();
        }
    }

    public final void set(int year, int month, int date) {
        set(1, year);
        set(2, month);
        set(5, date);
    }

    public final void set(int year, int month, int date, int hourOfDay, int minute) {
        set(1, year);
        set(2, month);
        set(5, date);
        set(11, hourOfDay);
        set(12, minute);
    }

    public final void set(int year, int month, int date, int hourOfDay, int minute, int second) {
        set(1, year);
        set(2, month);
        set(5, date);
        set(11, hourOfDay);
        set(12, minute);
        set(13, second);
    }

    public final void clear() {
        for (int i = 0; i < this.fields.length; i++) {
            int[] iArr = this.stamp;
            this.fields[i] = 0;
            iArr[i] = 0;
            this.isSet[i] = f35assertionsDisabled;
        }
        this.areFieldsSet = f35assertionsDisabled;
        this.areAllFieldsSet = f35assertionsDisabled;
        this.isTimeSet = f35assertionsDisabled;
    }

    public final void clear(int field) {
        this.fields[field] = 0;
        this.stamp[field] = 0;
        this.isSet[field] = f35assertionsDisabled;
        this.areFieldsSet = f35assertionsDisabled;
        this.areAllFieldsSet = f35assertionsDisabled;
        this.isTimeSet = f35assertionsDisabled;
    }

    public final boolean isSet(int field) {
        if (this.stamp[field] != 0) {
            return true;
        }
        return f35assertionsDisabled;
    }

    public String getDisplayName(int field, int style, Locale locale) {
        String[] strings;
        int fieldValue;
        if (checkDisplayNameParams(field, style, 0, 2, locale, 645) && (strings = getFieldStrings(field, style, DateFormatSymbols.getInstance(locale))) != null && (fieldValue = get(field)) < strings.length) {
            return strings[fieldValue];
        }
        return null;
    }

    public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        if (!checkDisplayNameParams(field, style, 0, 2, locale, 645)) {
            return null;
        }
        complete();
        if (style != 0) {
            return getDisplayNamesImpl(field, style, locale);
        }
        Map<String, Integer> shortNames = getDisplayNamesImpl(field, 1, locale);
        if (field == 0 || field == 9) {
            return shortNames;
        }
        Map<String, Integer> longNames = getDisplayNamesImpl(field, 2, locale);
        if (shortNames == null) {
            return longNames;
        }
        if (longNames != null) {
            shortNames.putAll(longNames);
        }
        return shortNames;
    }

    private Map<String, Integer> getDisplayNamesImpl(int field, int style, Locale locale) {
        String[] strings = getFieldStrings(field, style, DateFormatSymbols.getInstance(locale));
        if (strings == null) {
            return null;
        }
        Map<String, Integer> names = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() != 0) {
                names.put(strings[i], Integer.valueOf(i));
            }
        }
        return names;
    }

    /* access modifiers changed from: package-private */
    public boolean checkDisplayNameParams(int field, int style, int minStyle, int maxStyle, Locale locale, int fieldMask) {
        if (field < 0 || field >= this.fields.length || style < minStyle || style > maxStyle) {
            throw new IllegalArgumentException();
        } else if (locale != null) {
            return isFieldSet(fieldMask, field);
        } else {
            throw new NullPointerException();
        }
    }

    private String[] getFieldStrings(int field, int style, DateFormatSymbols symbols) {
        switch (field) {
            case 0:
                return symbols.getEras();
            case 2:
                return style == 2 ? symbols.getMonths() : symbols.getShortMonths();
            case 7:
                return style == 2 ? symbols.getWeekdays() : symbols.getShortWeekdays();
            case 9:
                return symbols.getAmPmStrings();
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public void complete() {
        if (!this.isTimeSet) {
            updateTime();
        }
        if (!this.areFieldsSet || !this.areAllFieldsSet) {
            computeFields();
            this.areFieldsSet = true;
            this.areAllFieldsSet = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isExternallySet(int field) {
        if (this.stamp[field] >= 2) {
            return true;
        }
        return f35assertionsDisabled;
    }

    /* access modifiers changed from: package-private */
    public final int getSetStateFields() {
        int mask = 0;
        for (int i = 0; i < this.fields.length; i++) {
            if (this.stamp[i] != 0) {
                mask |= 1 << i;
            }
        }
        return mask;
    }

    /* access modifiers changed from: package-private */
    public final void setFieldsComputed(int fieldMask) {
        if (fieldMask == ALL_FIELDS) {
            for (int i = 0; i < this.fields.length; i++) {
                this.stamp[i] = 1;
                this.isSet[i] = true;
            }
            this.areAllFieldsSet = true;
            this.areFieldsSet = true;
            return;
        }
        for (int i2 = 0; i2 < this.fields.length; i2++) {
            if ((fieldMask & 1) == 1) {
                this.stamp[i2] = 1;
                this.isSet[i2] = true;
            } else if (this.areAllFieldsSet && !this.isSet[i2]) {
                this.areAllFieldsSet = f35assertionsDisabled;
            }
            fieldMask >>>= 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void setFieldsNormalized(int fieldMask) {
        if (fieldMask != ALL_FIELDS) {
            for (int i = 0; i < this.fields.length; i++) {
                if ((fieldMask & 1) == 0) {
                    int[] iArr = this.stamp;
                    this.fields[i] = 0;
                    iArr[i] = 0;
                    this.isSet[i] = f35assertionsDisabled;
                }
                fieldMask >>= 1;
            }
        }
        this.areFieldsSet = true;
        this.areAllFieldsSet = f35assertionsDisabled;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartiallyNormalized() {
        if (!this.areFieldsSet || this.areAllFieldsSet) {
            return f35assertionsDisabled;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isFullyNormalized() {
        return this.areFieldsSet ? this.areAllFieldsSet : f35assertionsDisabled;
    }

    /* access modifiers changed from: package-private */
    public final void setUnnormalized() {
        this.areAllFieldsSet = f35assertionsDisabled;
        this.areFieldsSet = f35assertionsDisabled;
    }

    static final boolean isFieldSet(int fieldMask, int field) {
        if (((1 << field) & fieldMask) != 0) {
            return true;
        }
        return f35assertionsDisabled;
    }

    /* access modifiers changed from: package-private */
    public final int selectFields() {
        int fieldMask;
        int bestStamp;
        boolean z;
        int fieldMask2 = 2;
        if (this.stamp[0] != 0) {
            fieldMask2 = 3;
        }
        int dowStamp = this.stamp[7];
        int monthStamp = this.stamp[2];
        int domStamp = this.stamp[5];
        int womStamp = aggregateStamp(this.stamp[4], dowStamp);
        int dowimStamp = aggregateStamp(this.stamp[8], dowStamp);
        int doyStamp = this.stamp[6];
        int woyStamp = aggregateStamp(this.stamp[3], dowStamp);
        int bestStamp2 = domStamp;
        if (womStamp > domStamp) {
            bestStamp2 = womStamp;
        }
        if (dowimStamp > bestStamp2) {
            bestStamp2 = dowimStamp;
        }
        if (doyStamp > bestStamp2) {
            bestStamp2 = doyStamp;
        }
        if (woyStamp > bestStamp2) {
            bestStamp2 = woyStamp;
        }
        if (bestStamp2 == 0) {
            womStamp = this.stamp[4];
            dowimStamp = Math.max(this.stamp[8], dowStamp);
            woyStamp = this.stamp[3];
            bestStamp2 = Math.max(Math.max(womStamp, dowimStamp), woyStamp);
            if (bestStamp2 == 0) {
                domStamp = monthStamp;
                bestStamp2 = monthStamp;
            }
        }
        if (bestStamp2 == domStamp || ((bestStamp2 == womStamp && this.stamp[4] >= this.stamp[3]) || (bestStamp2 == dowimStamp && this.stamp[8] >= this.stamp[3]))) {
            fieldMask = fieldMask2 | 4;
            if (bestStamp2 == domStamp) {
                fieldMask |= 32;
            } else {
                if (!f35assertionsDisabled) {
                    if (!((bestStamp2 == womStamp || bestStamp2 == dowimStamp) ? true : f35assertionsDisabled)) {
                        throw new AssertionError();
                    }
                }
                if (dowStamp != 0) {
                    fieldMask |= 128;
                }
                if (womStamp == dowimStamp) {
                    if (this.stamp[4] >= this.stamp[8]) {
                        fieldMask |= 16;
                    } else {
                        fieldMask |= 256;
                    }
                } else if (bestStamp2 == womStamp) {
                    fieldMask |= 16;
                } else {
                    if (!f35assertionsDisabled) {
                        if (!(bestStamp2 == dowimStamp ? true : f35assertionsDisabled)) {
                            throw new AssertionError();
                        }
                    }
                    if (this.stamp[8] != 0) {
                        fieldMask |= 256;
                    }
                }
            }
        } else {
            if (!f35assertionsDisabled) {
                if (bestStamp2 == doyStamp || bestStamp2 == woyStamp) {
                    z = true;
                } else {
                    z = bestStamp2 == 0 ? true : f35assertionsDisabled;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if (bestStamp2 == doyStamp) {
                fieldMask = fieldMask2 | 64;
            } else {
                if (!f35assertionsDisabled) {
                    if (!(bestStamp2 == woyStamp ? true : f35assertionsDisabled)) {
                        throw new AssertionError();
                    }
                }
                if (dowStamp != 0) {
                    fieldMask2 |= 128;
                }
                fieldMask = fieldMask2 | 8;
            }
        }
        int hourOfDayStamp = this.stamp[11];
        int hourStamp = aggregateStamp(this.stamp[10], this.stamp[9]);
        if (hourStamp > hourOfDayStamp) {
            bestStamp = hourStamp;
        } else {
            bestStamp = hourOfDayStamp;
        }
        if (bestStamp == 0) {
            bestStamp = Math.max(this.stamp[10], this.stamp[9]);
        }
        if (bestStamp != 0) {
            if (bestStamp == hourOfDayStamp) {
                fieldMask |= 2048;
            } else {
                fieldMask |= 1024;
                if (this.stamp[9] != 0) {
                    fieldMask |= 512;
                }
            }
        }
        if (this.stamp[12] != 0) {
            fieldMask |= 4096;
        }
        if (this.stamp[13] != 0) {
            fieldMask |= 8192;
        }
        if (this.stamp[14] != 0) {
            fieldMask |= 16384;
        }
        if (this.stamp[15] >= 2) {
            fieldMask |= 32768;
        }
        if (this.stamp[16] >= 2) {
            return fieldMask | 65536;
        }
        return fieldMask;
    }

    private static final int aggregateStamp(int stamp_a, int stamp_b) {
        if (stamp_a == 0 || stamp_b == 0) {
            return 0;
        }
        return stamp_a > stamp_b ? stamp_a : stamp_b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            Calendar that = (Calendar) obj;
            if (compareTo(getMillisOf(that)) == 0 && this.lenient == that.lenient && this.firstDayOfWeek == that.firstDayOfWeek && this.minimalDaysInFirstWeek == that.minimalDaysInFirstWeek) {
                return this.zone.equals(that.zone);
            }
            return f35assertionsDisabled;
        } catch (Exception e) {
            return f35assertionsDisabled;
        }
    }

    public int hashCode() {
        int otheritems = (this.lenient ? 1 : 0) | (this.firstDayOfWeek << 1) | (this.minimalDaysInFirstWeek << 4) | (this.zone.hashCode() << 7);
        long t = getMillisOf(this);
        return (((int) t) ^ ((int) (t >> 32))) ^ otheritems;
    }

    public boolean before(Object when) {
        if (!(when instanceof Calendar) || compareTo((Calendar) when) >= 0) {
            return f35assertionsDisabled;
        }
        return true;
    }

    public boolean after(Object when) {
        if (!(when instanceof Calendar) || compareTo((Calendar) when) <= 0) {
            return f35assertionsDisabled;
        }
        return true;
    }

    public int compareTo(Calendar anotherCalendar) {
        return compareTo(getMillisOf(anotherCalendar));
    }

    public void roll(int field, int amount) {
        while (amount > 0) {
            roll(field, true);
            amount--;
        }
        while (amount < 0) {
            roll(field, (boolean) f35assertionsDisabled);
            amount++;
        }
    }

    public void setTimeZone(TimeZone value) {
        this.zone = value;
        this.sharedZone = f35assertionsDisabled;
        this.areFieldsSet = f35assertionsDisabled;
        this.areAllFieldsSet = f35assertionsDisabled;
    }

    public TimeZone getTimeZone() {
        if (this.sharedZone) {
            this.zone = (TimeZone) this.zone.clone();
            this.sharedZone = f35assertionsDisabled;
        }
        return this.zone;
    }

    /* access modifiers changed from: package-private */
    public TimeZone getZone() {
        return this.zone;
    }

    /* access modifiers changed from: package-private */
    public void setZoneShared(boolean shared) {
        this.sharedZone = shared;
    }

    public void setLenient(boolean lenient2) {
        this.lenient = lenient2;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public void setFirstDayOfWeek(int value) {
        if (this.firstDayOfWeek != value) {
            this.firstDayOfWeek = value;
            invalidateWeekFields();
        }
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public void setMinimalDaysInFirstWeek(int value) {
        if (this.minimalDaysInFirstWeek != value) {
            this.minimalDaysInFirstWeek = value;
            invalidateWeekFields();
        }
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDaysInFirstWeek;
    }

    public boolean isWeekDateSupported() {
        return f35assertionsDisabled;
    }

    public int getWeekYear() {
        throw new UnsupportedOperationException();
    }

    public void setWeekDate(int weekYear, int weekOfYear, int dayOfWeek) {
        throw new UnsupportedOperationException();
    }

    public int getWeeksInWeekYear() {
        throw new UnsupportedOperationException();
    }

    public int getActualMinimum(int field) {
        int fieldValue = getGreatestMinimum(field);
        int endValue = getMinimum(field);
        if (fieldValue == endValue) {
            return fieldValue;
        }
        Calendar work = (Calendar) clone();
        work.setLenient(true);
        int result = fieldValue;
        do {
            work.set(field, fieldValue);
            if (work.get(field) != fieldValue) {
                break;
            }
            result = fieldValue;
            fieldValue--;
        } while (fieldValue >= endValue);
        return result;
    }

    public int getActualMaximum(int field) {
        int fieldValue = getLeastMaximum(field);
        int endValue = getMaximum(field);
        if (fieldValue == endValue) {
            return fieldValue;
        }
        Calendar work = (Calendar) clone();
        work.setLenient(true);
        if (field == 3 || field == 4) {
            work.set(7, this.firstDayOfWeek);
        }
        int result = fieldValue;
        do {
            work.set(field, fieldValue);
            if (work.get(field) != fieldValue) {
                break;
            }
            result = fieldValue;
            fieldValue++;
        } while (fieldValue <= endValue);
        return result;
    }

    public Object clone() {
        try {
            Calendar other = (Calendar) super.clone();
            other.fields = new int[17];
            other.isSet = new boolean[17];
            other.stamp = new int[17];
            for (int i = 0; i < 17; i++) {
                other.fields[i] = this.fields[i];
                other.stamp[i] = this.stamp[i];
                other.isSet[i] = this.isSet[i];
            }
            other.zone = (TimeZone) this.zone.clone();
            return other;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    static final String getFieldName(int field) {
        return FIELD_NAME[field];
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder((int) PlatformLogger.INFO);
        buffer.append(getClass().getName()).append('[');
        appendValue(buffer, "time", this.isTimeSet, this.time);
        buffer.append(",areFieldsSet=").append(this.areFieldsSet);
        buffer.append(",areAllFieldsSet=").append(this.areAllFieldsSet);
        buffer.append(",lenient=").append(this.lenient);
        buffer.append(",zone=").append((Object) this.zone);
        appendValue(buffer, ",firstDayOfWeek", true, (long) this.firstDayOfWeek);
        appendValue(buffer, ",minimalDaysInFirstWeek", true, (long) this.minimalDaysInFirstWeek);
        for (int i = 0; i < 17; i++) {
            buffer.append(',');
            appendValue(buffer, FIELD_NAME[i], isSet(i), (long) this.fields[i]);
        }
        buffer.append(']');
        return buffer.toString();
    }

    private static final void appendValue(StringBuilder sb, String item, boolean valid, long value) {
        sb.append(item).append('=');
        if (valid) {
            sb.append(value);
        } else {
            sb.append('?');
        }
    }

    private void setWeekCountData(Locale desiredLocale) {
        int[] data = (int[]) cachedLocaleData.get(desiredLocale);
        if (data == null) {
            LocaleData localeData = LocaleData.get(desiredLocale);
            data = new int[]{localeData.firstDayOfWeek.intValue(), localeData.minimalDaysInFirstWeek.intValue()};
            cachedLocaleData.putIfAbsent(desiredLocale, data);
        }
        this.firstDayOfWeek = data[0];
        this.minimalDaysInFirstWeek = data[1];
    }

    private void updateTime() {
        computeTime();
        this.isTimeSet = true;
    }

    private int compareTo(long t) {
        long thisTime = getMillisOf(this);
        if (thisTime > t) {
            return 1;
        }
        return thisTime == t ? 0 : -1;
    }

    private static final long getMillisOf(Calendar calendar) {
        if (calendar.isTimeSet) {
            return calendar.time;
        }
        Calendar cal = (Calendar) calendar.clone();
        cal.setLenient(true);
        return cal.getTimeInMillis();
    }

    private final void adjustStamp() {
        int min;
        int max = 2;
        int newStamp = 2;
        do {
            min = Integer.MAX_VALUE;
            for (int v : this.stamp) {
                if (v >= newStamp && min > v) {
                    min = v;
                }
                if (max < v) {
                    max = v;
                }
            }
            if (max != min && min == Integer.MAX_VALUE) {
                break;
            }
            for (int i = 0; i < this.stamp.length; i++) {
                if (this.stamp[i] == min) {
                    this.stamp[i] = newStamp;
                }
            }
            newStamp++;
        } while (min != max);
        this.nextStamp = newStamp;
    }

    private void invalidateWeekFields() {
        int weekOfYear;
        int weekOfMonth;
        if (this.stamp[4] == 1 || this.stamp[3] == 1) {
            Calendar cal = (Calendar) clone();
            cal.setLenient(true);
            cal.clear(4);
            cal.clear(3);
            if (this.stamp[4] == 1 && this.fields[4] != (weekOfMonth = cal.get(4))) {
                this.fields[4] = weekOfMonth;
            }
            if (this.stamp[3] == 1 && this.fields[3] != (weekOfYear = cal.get(3))) {
                this.fields[3] = weekOfYear;
            }
        }
    }

    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        if (!this.isTimeSet) {
            try {
                updateTime();
            } catch (IllegalArgumentException e) {
            }
        }
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        int i;
        String id;
        TimeZone tz;
        ObjectInputStream objectInputStream = stream;
        stream.defaultReadObject();
        this.stamp = new int[17];
        if (this.serialVersionOnStream >= 2) {
            this.isTimeSet = true;
            if (this.fields == null) {
                this.fields = new int[17];
            }
            if (this.isSet == null) {
                this.isSet = new boolean[17];
            }
        } else if (this.serialVersionOnStream >= 0) {
            for (int i2 = 0; i2 < 17; i2++) {
                int[] iArr = this.stamp;
                if (this.isSet[i2]) {
                    i = 1;
                } else {
                    i = 0;
                }
                iArr[i2] = i;
            }
        }
        this.serialVersionOnStream = 1;
        if ((this.zone instanceof SimpleTimeZone) && (tz = TimeZone.getTimeZone(id)) != null && tz.hasSameRules(this.zone) && tz.getID().equals((id = this.zone.getID()))) {
            this.zone = tz;
        }
    }
}
