package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Locale;
import libcore.util.ZoneInfo;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.CalendarUtils;
import sun.util.calendar.Era;
import sun.util.calendar.Gregorian;
import sun.util.calendar.JulianCalendar;

public class GregorianCalendar extends Calendar {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f40assertionsDisabled = false;
    public static final int AD = 1;
    public static final int BC = 0;
    static final int BCE = 0;
    static final int CE = 1;
    static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
    private static final int EPOCH_OFFSET = 719163;
    private static final int EPOCH_YEAR = 1970;
    static final int[] LEAP_MONTH_LENGTH = null;
    static final int[] LEAST_MAX_VALUES = null;
    static final int[] MAX_VALUES = null;
    static final int[] MIN_VALUES = null;
    static final int[] MONTH_LENGTH = null;
    private static final long ONE_DAY = 86400000;
    private static final int ONE_HOUR = 3600000;
    private static final int ONE_MINUTE = 60000;
    private static final int ONE_SECOND = 1000;
    private static final long ONE_WEEK = 604800000;
    private static final Gregorian gcal = null;
    private static JulianCalendar jcal = null;
    private static Era[] jeras = null;
    static final long serialVersionUID = -8125100834729963327L;
    private transient long cachedFixedDate;
    private transient BaseCalendar calsys;
    private transient BaseCalendar.Date cdate;
    private transient BaseCalendar.Date gdate;
    private long gregorianCutover;
    private transient long gregorianCutoverDate;
    private transient int gregorianCutoverYear;
    private transient int gregorianCutoverYearJulian;
    private transient int[] originalFields;
    private transient int[] zoneOffsets;

    public GregorianCalendar() {
        this(TimeZone.getDefaultRef(), Locale.getDefault(Locale.Category.FORMAT));
        setZoneShared(true);
    }

    public GregorianCalendar(TimeZone zone) {
        this(zone, Locale.getDefault(Locale.Category.FORMAT));
    }

    public GregorianCalendar(Locale aLocale) {
        this(TimeZone.getDefaultRef(), aLocale);
        setZoneShared(true);
    }

    public GregorianCalendar(TimeZone zone, Locale aLocale) {
        super(zone, aLocale);
        this.gregorianCutover = DEFAULT_GREGORIAN_CUTOVER;
        this.gregorianCutoverDate = 577736;
        this.gregorianCutoverYear = 1582;
        this.gregorianCutoverYearJulian = 1582;
        this.cachedFixedDate = Long.MIN_VALUE;
        this.gdate = gcal.newCalendarDate(zone);
        setTimeInMillis(System.currentTimeMillis());
    }

    public GregorianCalendar(int year, int month, int dayOfMonth) {
        this(year, month, dayOfMonth, 0, 0, 0, 0);
    }

    public GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        this(year, month, dayOfMonth, hourOfDay, minute, 0, 0);
    }

    public GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        this(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second, int millis) {
        this.gregorianCutover = DEFAULT_GREGORIAN_CUTOVER;
        this.gregorianCutoverDate = 577736;
        this.gregorianCutoverYear = 1582;
        this.gregorianCutoverYearJulian = 1582;
        this.cachedFixedDate = Long.MIN_VALUE;
        this.gdate = gcal.newCalendarDate(getZone());
        set(1, year);
        set(2, month);
        set(5, dayOfMonth);
        if (hourOfDay < 12 || hourOfDay > 23) {
            internalSet(10, hourOfDay);
        } else {
            internalSet(9, 1);
            internalSet(10, hourOfDay - 12);
        }
        setFieldsComputed(1536);
        set(11, hourOfDay);
        set(12, minute);
        set(13, second);
        internalSet(14, millis);
    }

    GregorianCalendar(long milliseconds) {
        this();
        setTimeInMillis(milliseconds);
    }

    public void setGregorianChange(Date date) {
        long cutoverTime = date.getTime();
        if (cutoverTime != this.gregorianCutover) {
            complete();
            setGregorianChange(cutoverTime);
        }
    }

    private void setGregorianChange(long cutoverTime) {
        this.gregorianCutover = cutoverTime;
        this.gregorianCutoverDate = CalendarUtils.floorDivide(cutoverTime, (long) ONE_DAY) + 719163;
        if (cutoverTime == Long.MAX_VALUE) {
            this.gregorianCutoverDate++;
        }
        this.gregorianCutoverYear = getGregorianCutoverDate().getYear();
        BaseCalendar jcal2 = getJulianCalendarSystem();
        BaseCalendar.Date d = (BaseCalendar.Date) jcal2.newCalendarDate(TimeZone.NO_TIMEZONE);
        jcal2.getCalendarDateFromFixedDate(d, this.gregorianCutoverDate - 1);
        this.gregorianCutoverYearJulian = d.getNormalizedYear();
        if (this.time < this.gregorianCutover) {
            setUnnormalized();
        }
    }

    public final Date getGregorianChange() {
        return new Date(this.gregorianCutover);
    }

    public boolean isLeapYear(int year) {
        boolean gregorian;
        if ((year & 3) != 0) {
            return f40assertionsDisabled;
        }
        if (year > this.gregorianCutoverYear) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
            return f40assertionsDisabled;
        } else if (year < this.gregorianCutoverYearJulian) {
            return true;
        } else {
            if (this.gregorianCutoverYear == this.gregorianCutoverYearJulian) {
                gregorian = getCalendarDate(this.gregorianCutoverDate).getMonth() < 3 ? true : f40assertionsDisabled;
            } else {
                gregorian = year == this.gregorianCutoverYear ? true : f40assertionsDisabled;
            }
            if (!gregorian || year % 100 != 0 || year % 400 == 0) {
                return true;
            }
            return f40assertionsDisabled;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GregorianCalendar) || !super.equals(obj) || this.gregorianCutover != ((GregorianCalendar) obj).gregorianCutover) {
            return f40assertionsDisabled;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ ((int) this.gregorianCutoverDate);
    }

    public void add(int field, int amount) {
        int y_amount;
        if (amount != 0) {
            if (field < 0 || field >= 15) {
                throw new IllegalArgumentException();
            }
            complete();
            if (field == 1) {
                int year = internalGet(1);
                if (internalGetEra() == 1) {
                    int year2 = year + amount;
                    if (year2 > 0) {
                        set(1, year2);
                    } else {
                        set(1, 1 - year2);
                        set(0, 0);
                    }
                } else {
                    int year3 = year - amount;
                    if (year3 > 0) {
                        set(1, year3);
                    } else {
                        set(1, 1 - year3);
                        set(0, 1);
                    }
                }
                pinDayOfMonth();
            } else if (field == 2) {
                int month = internalGet(2) + amount;
                int year4 = internalGet(1);
                if (month >= 0) {
                    y_amount = month / 12;
                } else {
                    y_amount = ((month + 1) / 12) - 1;
                }
                if (y_amount != 0) {
                    if (internalGetEra() == 1) {
                        int year5 = year4 + y_amount;
                        if (year5 > 0) {
                            set(1, year5);
                        } else {
                            set(1, 1 - year5);
                            set(0, 0);
                        }
                    } else {
                        int year6 = year4 - y_amount;
                        if (year6 > 0) {
                            set(1, year6);
                        } else {
                            set(1, 1 - year6);
                            set(0, 1);
                        }
                    }
                }
                if (month >= 0) {
                    set(2, month % 12);
                } else {
                    int month2 = month % 12;
                    if (month2 < 0) {
                        month2 += 12;
                    }
                    set(2, month2 + 0);
                }
                pinDayOfMonth();
            } else if (field == 0) {
                int era = internalGet(0) + amount;
                if (era < 0) {
                    era = 0;
                }
                if (era > 1) {
                    era = 1;
                }
                set(0, era);
            } else {
                long delta = (long) amount;
                long timeOfDay = 0;
                switch (field) {
                    case 3:
                    case 4:
                    case 8:
                        delta *= 7;
                        break;
                    case 9:
                        delta = (long) (amount / 2);
                        timeOfDay = (long) ((amount % 2) * 12);
                        break;
                    case 10:
                    case 11:
                        delta *= 3600000;
                        break;
                    case 12:
                        delta *= 60000;
                        break;
                    case 13:
                        delta *= 1000;
                        break;
                }
                if (field >= 10) {
                    setTimeInMillis(this.time + delta);
                    return;
                }
                long fd = getCurrentFixedDate();
                long timeOfDay2 = ((((((timeOfDay + ((long) internalGet(11))) * 60) + ((long) internalGet(12))) * 60) + ((long) internalGet(13))) * 1000) + ((long) internalGet(14));
                if (timeOfDay2 >= ONE_DAY) {
                    fd++;
                    timeOfDay2 -= ONE_DAY;
                } else if (timeOfDay2 < 0) {
                    fd--;
                    timeOfDay2 += ONE_DAY;
                }
                setTimeInMillis(adjustForZoneAndDaylightSavingsTime(0, (((fd + delta) - 719163) * ONE_DAY) + timeOfDay2, getZone()));
            }
        }
    }

    public void roll(int field, boolean up) {
        roll(field, up ? 1 : -1);
    }

    public void roll(int field, int amount) {
        int weekOfYear;
        long month1;
        int monthLength;
        int dayOfMonth;
        BaseCalendar cal;
        if (amount != 0) {
            if (field < 0 || field >= 15) {
                throw new IllegalArgumentException();
            }
            complete();
            int min = getMinimum(field);
            int max = getMaximum(field);
            switch (field) {
                case 2:
                    if (!isCutoverYear(this.cdate.getNormalizedYear())) {
                        int mon = (internalGet(2) + amount) % 12;
                        if (mon < 0) {
                            mon += 12;
                        }
                        set(2, mon);
                        int monthLen = monthLength(mon);
                        if (internalGet(5) > monthLen) {
                            set(5, monthLen);
                            return;
                        }
                        return;
                    }
                    int yearLength = getActualMaximum(2) + 1;
                    int mon2 = (internalGet(2) + amount) % yearLength;
                    if (mon2 < 0) {
                        mon2 += yearLength;
                    }
                    set(2, mon2);
                    int monthLen2 = getActualMaximum(5);
                    if (internalGet(5) > monthLen2) {
                        set(5, monthLen2);
                        return;
                    }
                    return;
                case 3:
                    int y = this.cdate.getNormalizedYear();
                    max = getActualMaximum(3);
                    set(7, internalGet(7));
                    int woy = internalGet(3);
                    int value = woy + amount;
                    if (isCutoverYear(y)) {
                        long fd = getCurrentFixedDate();
                        if (this.gregorianCutoverYear == this.gregorianCutoverYearJulian) {
                            cal = getCutoverCalendarSystem();
                        } else {
                            if (y == this.gregorianCutoverYear) {
                                cal = gcal;
                            } else {
                                cal = getJulianCalendarSystem();
                            }
                        }
                        long day1 = fd - ((long) ((woy - min) * 7));
                        if (cal.getYearFromFixedDate(day1) != y) {
                            min++;
                        }
                        long fd2 = fd + ((long) ((max - woy) * 7));
                        if ((fd2 >= this.gregorianCutoverDate ? gcal : getJulianCalendarSystem()).getYearFromFixedDate(fd2) != y) {
                            max--;
                        }
                        BaseCalendar.Date d = getCalendarDate(((long) ((getRolledValue(woy, amount, min, max) - 1) * 7)) + day1);
                        set(2, d.getMonth() - 1);
                        set(5, d.getDayOfMonth());
                        return;
                    } else if (value <= min || value >= max) {
                        long fd3 = getCurrentFixedDate();
                        if (this.calsys.getYearFromFixedDate(fd3 - ((long) ((woy - min) * 7))) != y) {
                            min++;
                        }
                        if (this.calsys.getYearFromFixedDate(fd3 + ((long) ((max - internalGet(3)) * 7))) != y) {
                            max--;
                            break;
                        }
                    } else {
                        set(3, value);
                        return;
                    }
                    break;
                case 4:
                    boolean isCutoverYear = isCutoverYear(this.cdate.getNormalizedYear());
                    int dow = internalGet(7) - getFirstDayOfWeek();
                    if (dow < 0) {
                        dow += 7;
                    }
                    long fd4 = getCurrentFixedDate();
                    if (isCutoverYear) {
                        month1 = getFixedDateMonth1(this.cdate, fd4);
                        monthLength = actualMonthLength();
                    } else {
                        month1 = (fd4 - ((long) internalGet(5))) + 1;
                        monthLength = this.calsys.getMonthLength(this.cdate);
                    }
                    BaseCalendar baseCalendar = this.calsys;
                    long monthDay1st = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + month1, getFirstDayOfWeek());
                    if (((int) (monthDay1st - month1)) >= getMinimalDaysInFirstWeek()) {
                        monthDay1st -= 7;
                    }
                    long nfd = ((long) ((getRolledValue(internalGet(field), amount, 1, getActualMaximum(field)) - 1) * 7)) + monthDay1st + ((long) dow);
                    if (nfd < month1) {
                        nfd = month1;
                    } else if (nfd >= ((long) monthLength) + month1) {
                        nfd = (((long) monthLength) + month1) - 1;
                    }
                    if (isCutoverYear) {
                        dayOfMonth = getCalendarDate(nfd).getDayOfMonth();
                    } else {
                        dayOfMonth = ((int) (nfd - month1)) + 1;
                    }
                    set(5, dayOfMonth);
                    return;
                case 5:
                    if (!isCutoverYear(this.cdate.getNormalizedYear())) {
                        max = this.calsys.getMonthLength(this.cdate);
                        break;
                    } else {
                        long fd5 = getCurrentFixedDate();
                        long month12 = getFixedDateMonth1(this.cdate, fd5);
                        BaseCalendar.Date d2 = getCalendarDate(((long) getRolledValue((int) (fd5 - month12), amount, 0, actualMonthLength() - 1)) + month12);
                        if (!f40assertionsDisabled) {
                            if (!(d2.getMonth() + -1 == internalGet(2) ? true : f40assertionsDisabled)) {
                                throw new AssertionError();
                            }
                        }
                        set(5, d2.getDayOfMonth());
                        return;
                    }
                case 6:
                    max = getActualMaximum(field);
                    if (isCutoverYear(this.cdate.getNormalizedYear())) {
                        long fd6 = getCurrentFixedDate();
                        long jan1 = (fd6 - ((long) internalGet(6))) + 1;
                        BaseCalendar.Date d3 = getCalendarDate((((long) getRolledValue(((int) (fd6 - jan1)) + 1, amount, min, max)) + jan1) - 1);
                        set(2, d3.getMonth() - 1);
                        set(5, d3.getDayOfMonth());
                        return;
                    }
                    break;
                case 7:
                    if (!isCutoverYear(this.cdate.getNormalizedYear()) && (weekOfYear = internalGet(3)) > 1 && weekOfYear < 52) {
                        set(3, weekOfYear);
                        max = 7;
                        break;
                    } else {
                        int amount2 = amount % 7;
                        if (amount2 != 0) {
                            long fd7 = getCurrentFixedDate();
                            BaseCalendar baseCalendar2 = this.calsys;
                            long dowFirst = BaseCalendar.getDayOfWeekDateOnOrBefore(fd7, getFirstDayOfWeek());
                            long fd8 = fd7 + ((long) amount2);
                            if (fd8 < dowFirst) {
                                fd8 += 7;
                            } else if (fd8 >= 7 + dowFirst) {
                                fd8 -= 7;
                            }
                            BaseCalendar.Date d4 = getCalendarDate(fd8);
                            set(0, d4.getNormalizedYear() <= 0 ? 0 : 1);
                            set(d4.getYear(), d4.getMonth() - 1, d4.getDayOfMonth());
                            return;
                        }
                        return;
                    }
                case 8:
                    min = 1;
                    if (!isCutoverYear(this.cdate.getNormalizedYear())) {
                        int dom = internalGet(5);
                        int monthLength2 = this.calsys.getMonthLength(this.cdate);
                        max = monthLength2 / 7;
                        if ((dom - 1) % 7 < monthLength2 % 7) {
                            max++;
                        }
                        set(7, internalGet(7));
                        break;
                    } else {
                        long fd9 = getCurrentFixedDate();
                        long month13 = getFixedDateMonth1(this.cdate, fd9);
                        int monthLength3 = actualMonthLength();
                        int max2 = monthLength3 / 7;
                        int x = ((int) (fd9 - month13)) % 7;
                        if (x < monthLength3 % 7) {
                            max2++;
                        }
                        long fd10 = ((long) ((getRolledValue(internalGet(field), amount, 1, max2) - 1) * 7)) + month13 + ((long) x);
                        BaseCalendar cal2 = fd10 >= this.gregorianCutoverDate ? gcal : getJulianCalendarSystem();
                        BaseCalendar.Date d5 = (BaseCalendar.Date) cal2.newCalendarDate(TimeZone.NO_TIMEZONE);
                        cal2.getCalendarDateFromFixedDate(d5, fd10);
                        set(5, d5.getDayOfMonth());
                        return;
                    }
                case 10:
                case 11:
                    int unit = max + 1;
                    int h = internalGet(field);
                    int nh = (h + amount) % unit;
                    if (nh < 0) {
                        nh += unit;
                    }
                    this.time += (long) ((nh - h) * ONE_HOUR);
                    CalendarDate d6 = this.calsys.getCalendarDate(this.time, getZone());
                    if (internalGet(5) != d6.getDayOfMonth()) {
                        d6.setDate(internalGet(1), internalGet(2) + 1, internalGet(5));
                        if (field == 10) {
                            if (!f40assertionsDisabled) {
                                if (!(internalGet(9) == 1 ? true : f40assertionsDisabled)) {
                                    throw new AssertionError();
                                }
                            }
                            d6.addHours(12);
                        }
                        this.time = this.calsys.getTime(d6);
                    }
                    int hourOfDay = d6.getHours();
                    internalSet(field, hourOfDay % unit);
                    if (field == 10) {
                        internalSet(11, hourOfDay);
                    } else {
                        internalSet(9, hourOfDay / 12);
                        internalSet(10, hourOfDay % 12);
                    }
                    int zoneOffset = d6.getZoneOffset();
                    int saving = d6.getDaylightSaving();
                    internalSet(15, zoneOffset - saving);
                    internalSet(16, saving);
                    return;
            }
            set(field, getRolledValue(internalGet(field), amount, min, max));
        }
    }

    public int getMinimum(int field) {
        return MIN_VALUES[field];
    }

    public int getMaximum(int field) {
        switch (field) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                if (this.gregorianCutoverYear <= 200) {
                    GregorianCalendar gc = (GregorianCalendar) clone();
                    gc.setLenient(true);
                    gc.setTimeInMillis(this.gregorianCutover);
                    int v1 = gc.getActualMaximum(field);
                    gc.setTimeInMillis(this.gregorianCutover - 1);
                    return Math.max(MAX_VALUES[field], Math.max(v1, gc.getActualMaximum(field)));
                }
                break;
        }
        return MAX_VALUES[field];
    }

    public int getGreatestMinimum(int field) {
        if (field != 5) {
            return MIN_VALUES[field];
        }
        return Math.max(MIN_VALUES[field], getCalendarDate(getFixedDateMonth1(getGregorianCutoverDate(), this.gregorianCutoverDate)).getDayOfMonth());
    }

    public int getLeastMaximum(int field) {
        switch (field) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                GregorianCalendar gc = (GregorianCalendar) clone();
                gc.setLenient(true);
                gc.setTimeInMillis(this.gregorianCutover);
                int v1 = gc.getActualMaximum(field);
                gc.setTimeInMillis(this.gregorianCutover - 1);
                return Math.min(LEAST_MAX_VALUES[field], Math.min(v1, gc.getActualMaximum(field)));
            default:
                return LEAST_MAX_VALUES[field];
        }
    }

    public int getActualMinimum(int field) {
        if (field == 5) {
            GregorianCalendar gc = getNormalizedCalendar();
            int year = gc.cdate.getNormalizedYear();
            if (year == this.gregorianCutoverYear || year == this.gregorianCutoverYearJulian) {
                return getCalendarDate(getFixedDateMonth1(gc.cdate, gc.calsys.getFixedDate(gc.cdate))).getDayOfMonth();
            }
        }
        return getMinimum(field);
    }

    public int getActualMaximum(int field) {
        boolean z;
        int ndays;
        int dow1;
        int value;
        long jan1;
        boolean z2;
        long nextJan1;
        if (((1 << field) & 130689) != 0) {
            return getMaximum(field);
        }
        GregorianCalendar gc = getNormalizedCalendar();
        BaseCalendar.Date date = gc.cdate;
        BaseCalendar cal = gc.calsys;
        int normalizedYear = date.getNormalizedYear();
        switch (field) {
            case 1:
                if (gc == this) {
                    gc = (GregorianCalendar) clone();
                }
                long current = gc.getYearOffsetInMillis();
                if (gc.internalGetEra() == 1) {
                    gc.setTimeInMillis(Long.MAX_VALUE);
                    int value2 = gc.get(1);
                    if (current > gc.getYearOffsetInMillis()) {
                        return value2 - 1;
                    }
                    return value2;
                }
                CalendarSystem mincal = gc.getTimeInMillis() >= this.gregorianCutover ? gcal : getJulianCalendarSystem();
                CalendarDate d = mincal.getCalendarDate(Long.MIN_VALUE, getZone());
                long maxEnd = ((((((((cal.getDayOfYear(d) - 1) * 24) + ((long) d.getHours())) * 60) + ((long) d.getMinutes())) * 60) + ((long) d.getSeconds())) * 1000) + ((long) d.getMillis());
                int value3 = d.getYear();
                if (value3 <= 0) {
                    if (!f40assertionsDisabled) {
                        if (mincal == gcal) {
                            z = true;
                        } else {
                            z = f40assertionsDisabled;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                    }
                    value3 = 1 - value3;
                }
                if (current < maxEnd) {
                    return value3 - 1;
                }
                return value3;
            case 2:
                if (!gc.isCutoverYear(normalizedYear)) {
                    return 11;
                }
                do {
                    normalizedYear++;
                    nextJan1 = gcal.getFixedDate(normalizedYear, 1, 1, (BaseCalendar.Date) null);
                } while (nextJan1 < this.gregorianCutoverDate);
                BaseCalendar.Date d2 = (BaseCalendar.Date) date.clone();
                cal.getCalendarDateFromFixedDate(d2, nextJan1 - 1);
                return d2.getMonth() - 1;
            case 3:
                if (!gc.isCutoverYear(normalizedYear)) {
                    CalendarDate d3 = cal.newCalendarDate(TimeZone.NO_TIMEZONE);
                    d3.setDate(date.getYear(), 1, 1);
                    int dayOfWeek = cal.getDayOfWeek(d3) - getFirstDayOfWeek();
                    if (dayOfWeek < 0) {
                        dayOfWeek += 7;
                    }
                    int magic = (getMinimalDaysInFirstWeek() + dayOfWeek) - 1;
                    if (magic != 6) {
                        if (!date.isLeapYear()) {
                            return 52;
                        }
                        if (magic == 5 || magic == 12) {
                            return 53;
                        }
                        return 52;
                    }
                    return 53;
                }
                if (gc == this) {
                    gc = (GregorianCalendar) gc.clone();
                }
                int maxDayOfYear = getActualMaximum(6);
                gc.set(6, maxDayOfYear);
                int value4 = gc.get(3);
                if (internalGet(1) == gc.getWeekYear()) {
                    return value4;
                }
                gc.set(6, maxDayOfYear - 7);
                return gc.get(3);
            case 4:
                if (!gc.isCutoverYear(normalizedYear)) {
                    CalendarDate d4 = cal.newCalendarDate((TimeZone) null);
                    d4.setDate(date.getYear(), date.getMonth(), 1);
                    int dayOfWeek2 = cal.getDayOfWeek(d4);
                    int monthLength = cal.getMonthLength(d4);
                    int dayOfWeek3 = dayOfWeek2 - getFirstDayOfWeek();
                    if (dayOfWeek3 < 0) {
                        dayOfWeek3 += 7;
                    }
                    int nDaysFirstWeek = 7 - dayOfWeek3;
                    int value5 = 3;
                    if (nDaysFirstWeek >= getMinimalDaysInFirstWeek()) {
                        value5 = 4;
                    }
                    int monthLength2 = monthLength - (nDaysFirstWeek + 21);
                    if (monthLength2 <= 0) {
                        return value5;
                    }
                    int value6 = value5 + 1;
                    if (monthLength2 > 7) {
                        return value6 + 1;
                    }
                    return value6;
                }
                if (gc == this) {
                    gc = (GregorianCalendar) gc.clone();
                }
                int y = gc.internalGet(1);
                int m = gc.internalGet(2);
                do {
                    value = gc.get(4);
                    gc.add(4, 1);
                    if (!(gc.get(1) == y && gc.get(2) == m)) {
                        return value;
                    }
                    value = gc.get(4);
                    gc.add(4, 1);
                    return value;
                } while (gc.get(2) == m);
                return value;
            case 5:
                int value7 = cal.getMonthLength(date);
                if (!gc.isCutoverYear(normalizedYear) || date.getDayOfMonth() == value7) {
                    return value7;
                }
                long fd = gc.getCurrentFixedDate();
                if (fd >= this.gregorianCutoverDate) {
                    return value7;
                }
                return gc.getCalendarDate((gc.getFixedDateMonth1(gc.cdate, fd) + ((long) gc.actualMonthLength())) - 1).getDayOfMonth();
            case 6:
                if (!gc.isCutoverYear(normalizedYear)) {
                    return cal.getYearLength(date);
                }
                if (this.gregorianCutoverYear == this.gregorianCutoverYearJulian) {
                    jan1 = gc.getCutoverCalendarSystem().getFixedDate(normalizedYear, 1, 1, (BaseCalendar.Date) null);
                } else {
                    if (normalizedYear == this.gregorianCutoverYearJulian) {
                        jan1 = cal.getFixedDate(normalizedYear, 1, 1, (BaseCalendar.Date) null);
                    } else {
                        jan1 = this.gregorianCutoverDate;
                    }
                }
                long nextJan12 = gcal.getFixedDate(normalizedYear + 1, 1, 1, (BaseCalendar.Date) null);
                if (nextJan12 < this.gregorianCutoverDate) {
                    nextJan12 = this.gregorianCutoverDate;
                }
                if (!f40assertionsDisabled) {
                    if (jan1 <= cal.getFixedDate(date.getNormalizedYear(), date.getMonth(), date.getDayOfMonth(), date)) {
                        z2 = true;
                    } else {
                        z2 = f40assertionsDisabled;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                if (!f40assertionsDisabled) {
                    if (!(nextJan12 >= cal.getFixedDate(date.getNormalizedYear(), date.getMonth(), date.getDayOfMonth(), date) ? true : f40assertionsDisabled)) {
                        throw new AssertionError();
                    }
                }
                return (int) (nextJan12 - jan1);
            case 8:
                int dow = date.getDayOfWeek();
                if (!gc.isCutoverYear(normalizedYear)) {
                    BaseCalendar.Date d5 = (BaseCalendar.Date) date.clone();
                    ndays = cal.getMonthLength(d5);
                    d5.setDayOfMonth(1);
                    cal.normalize(d5);
                    dow1 = d5.getDayOfWeek();
                } else {
                    if (gc == this) {
                        gc = (GregorianCalendar) clone();
                    }
                    ndays = gc.actualMonthLength();
                    gc.set(5, gc.getActualMinimum(5));
                    dow1 = gc.get(7);
                }
                int x = dow - dow1;
                if (x < 0) {
                    x += 7;
                }
                return ((ndays - x) + 6) / 7;
            default:
                throw new ArrayIndexOutOfBoundsException(field);
        }
    }

    private final long getYearOffsetInMillis() {
        return (((long) internalGet(14)) + ((((((((long) ((internalGet(6) - 1) * 24)) + ((long) internalGet(11))) * 60) + ((long) internalGet(12))) * 60) + ((long) internalGet(13))) * 1000)) - ((long) (internalGet(15) + internalGet(16)));
    }

    public Object clone() {
        GregorianCalendar other = (GregorianCalendar) super.clone();
        other.gdate = (BaseCalendar.Date) this.gdate.clone();
        if (this.cdate != null) {
            if (this.cdate != this.gdate) {
                other.cdate = (BaseCalendar.Date) this.cdate.clone();
            } else {
                other.cdate = other.gdate;
            }
        }
        other.originalFields = null;
        other.zoneOffsets = null;
        return other;
    }

    public TimeZone getTimeZone() {
        TimeZone zone = super.getTimeZone();
        this.gdate.setZone(zone);
        if (!(this.cdate == null || this.cdate == this.gdate)) {
            this.cdate.setZone(zone);
        }
        return zone;
    }

    public void setTimeZone(TimeZone zone) {
        super.setTimeZone(zone);
        this.gdate.setZone(zone);
        if (this.cdate != null && this.cdate != this.gdate) {
            this.cdate.setZone(zone);
        }
    }

    public final boolean isWeekDateSupported() {
        return true;
    }

    public int getWeekYear() {
        int year = get(1);
        if (internalGetEra() == 0) {
            year = 1 - year;
        }
        if (year > this.gregorianCutoverYear + 1) {
            int weekOfYear = internalGet(3);
            if (internalGet(2) == 0) {
                if (weekOfYear >= 52) {
                    return year - 1;
                }
                return year;
            } else if (weekOfYear == 1) {
                return year + 1;
            } else {
                return year;
            }
        } else {
            int dayOfYear = internalGet(6);
            int maxDayOfYear = getActualMaximum(6);
            int minimalDays = getMinimalDaysInFirstWeek();
            if (dayOfYear > minimalDays && dayOfYear < maxDayOfYear - 6) {
                return year;
            }
            GregorianCalendar cal = (GregorianCalendar) clone();
            cal.setLenient(true);
            cal.setTimeZone(TimeZone.getTimeZone("GMT"));
            cal.set(6, 1);
            cal.complete();
            int delta = getFirstDayOfWeek() - cal.get(7);
            if (delta != 0) {
                if (delta < 0) {
                    delta += 7;
                }
                cal.add(6, delta);
            }
            int minDayOfYear = cal.get(6);
            if (dayOfYear >= minDayOfYear) {
                cal.set(1, year + 1);
                cal.set(6, 1);
                cal.complete();
                int del = getFirstDayOfWeek() - cal.get(7);
                if (del != 0) {
                    if (del < 0) {
                        del += 7;
                    }
                    cal.add(6, del);
                }
                int minDayOfYear2 = cal.get(6) - 1;
                if (minDayOfYear2 == 0) {
                    minDayOfYear2 = 7;
                }
                if (minDayOfYear2 < minimalDays || (maxDayOfYear - dayOfYear) + 1 > 7 - minDayOfYear2) {
                    return year;
                }
                return year + 1;
            } else if (minDayOfYear <= minimalDays) {
                return year - 1;
            } else {
                return year;
            }
        }
    }

    public void setWeekDate(int weekYear, int weekOfYear, int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new IllegalArgumentException("invalid dayOfWeek: " + dayOfWeek);
        }
        GregorianCalendar gc = (GregorianCalendar) clone();
        gc.setLenient(true);
        int era = gc.get(0);
        gc.clear();
        gc.setTimeZone(TimeZone.getTimeZone("GMT"));
        gc.set(0, era);
        gc.set(1, weekYear);
        gc.set(3, 1);
        gc.set(7, getFirstDayOfWeek());
        int days = dayOfWeek - getFirstDayOfWeek();
        if (days < 0) {
            days += 7;
        }
        int days2 = days + ((weekOfYear - 1) * 7);
        if (days2 != 0) {
            gc.add(6, days2);
        } else {
            gc.complete();
        }
        if (isLenient() || (gc.getWeekYear() == weekYear && gc.internalGet(3) == weekOfYear && gc.internalGet(7) == dayOfWeek)) {
            set(0, gc.internalGet(0));
            set(1, gc.internalGet(1));
            set(2, gc.internalGet(2));
            set(5, gc.internalGet(5));
            internalSet(3, weekOfYear);
            complete();
            return;
        }
        throw new IllegalArgumentException();
    }

    public int getWeeksInWeekYear() {
        GregorianCalendar gc = getNormalizedCalendar();
        int weekYear = gc.getWeekYear();
        if (weekYear == gc.internalGet(1)) {
            return gc.getActualMaximum(3);
        }
        if (gc == this) {
            gc = (GregorianCalendar) gc.clone();
        }
        gc.setWeekDate(weekYear, 2, internalGet(7));
        return gc.getActualMaximum(3);
    }

    /* access modifiers changed from: protected */
    public void computeFields() {
        int mask;
        boolean z = f40assertionsDisabled;
        if (isPartiallyNormalized()) {
            mask = getSetStateFields();
            int fieldMask = (~mask) & 131071;
            if (fieldMask != 0 || this.calsys == null) {
                mask |= computeFields(fieldMask, 98304 & mask);
                if (!f40assertionsDisabled) {
                    if (mask == 131071) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            }
        } else {
            mask = 131071;
            computeFields(131071, 0);
        }
        setFieldsComputed(mask);
    }

    private int computeFields(int fieldMask, int tzMask) {
        int year;
        int cutoverYear;
        long nextJan1;
        boolean z;
        int zoneOffset = 0;
        ZoneInfo zoneInfo = getZone();
        if (this.zoneOffsets == null) {
            this.zoneOffsets = new int[2];
        }
        if (tzMask != 98304) {
            if (zoneInfo instanceof ZoneInfo) {
                zoneOffset = zoneInfo.getOffsetsByUtcTime(this.time, this.zoneOffsets);
            } else {
                zoneOffset = zoneInfo.getOffset(this.time);
                this.zoneOffsets[0] = zoneInfo.getRawOffset();
                this.zoneOffsets[1] = zoneOffset - this.zoneOffsets[0];
            }
        }
        if (tzMask != 0) {
            if (isFieldSet(tzMask, 15)) {
                this.zoneOffsets[0] = internalGet(15);
            }
            if (isFieldSet(tzMask, 16)) {
                this.zoneOffsets[1] = internalGet(16);
            }
            zoneOffset = this.zoneOffsets[0] + this.zoneOffsets[1];
        }
        long fixedDate = (((long) zoneOffset) / ONE_DAY) + (this.time / ONE_DAY);
        int timeOfDay = (zoneOffset % 86400000) + ((int) (this.time % ONE_DAY));
        if (((long) timeOfDay) >= ONE_DAY) {
            timeOfDay = (int) (((long) timeOfDay) - ONE_DAY);
            fixedDate++;
        } else {
            while (timeOfDay < 0) {
                timeOfDay = (int) (((long) timeOfDay) + ONE_DAY);
                fixedDate--;
            }
        }
        long fixedDate2 = fixedDate + 719163;
        int era = 1;
        if (fixedDate2 >= this.gregorianCutoverDate) {
            if (!f40assertionsDisabled) {
                if (!(this.cachedFixedDate != Long.MIN_VALUE ? this.gdate.isNormalized() : true)) {
                    throw new AssertionError((Object) "cache control: not normalized");
                }
            }
            if (!f40assertionsDisabled) {
                if (this.cachedFixedDate != Long.MIN_VALUE) {
                    z = gcal.getFixedDate(this.gdate.getNormalizedYear(), this.gdate.getMonth(), this.gdate.getDayOfMonth(), this.gdate) == this.cachedFixedDate ? true : f40assertionsDisabled;
                } else {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError((Object) "cache control: inconsictency, cachedFixedDate=" + this.cachedFixedDate + ", computed=" + gcal.getFixedDate(this.gdate.getNormalizedYear(), this.gdate.getMonth(), this.gdate.getDayOfMonth(), this.gdate) + ", date=" + this.gdate);
                }
            }
            if (fixedDate2 != this.cachedFixedDate) {
                gcal.getCalendarDateFromFixedDate(this.gdate, fixedDate2);
                this.cachedFixedDate = fixedDate2;
            }
            year = this.gdate.getYear();
            if (year <= 0) {
                year = 1 - year;
                era = 0;
            }
            this.calsys = gcal;
            this.cdate = this.gdate;
            if (!f40assertionsDisabled) {
                if (!(this.cdate.getDayOfWeek() > 0 ? true : f40assertionsDisabled)) {
                    throw new AssertionError((Object) "dow=" + this.cdate.getDayOfWeek() + ", date=" + this.cdate);
                }
            }
        } else {
            this.calsys = getJulianCalendarSystem();
            this.cdate = jcal.newCalendarDate(getZone());
            jcal.getCalendarDateFromFixedDate(this.cdate, fixedDate2);
            if (this.cdate.getEra() == jeras[0]) {
                era = 0;
            }
            year = this.cdate.getYear();
        }
        internalSet(0, era);
        internalSet(1, year);
        int mask = fieldMask | 3;
        int month = this.cdate.getMonth() - 1;
        int dayOfMonth = this.cdate.getDayOfMonth();
        if ((fieldMask & 164) != 0) {
            internalSet(2, month);
            internalSet(5, dayOfMonth);
            internalSet(7, this.cdate.getDayOfWeek());
            mask |= 164;
        }
        if ((fieldMask & 32256) != 0) {
            if (timeOfDay != 0) {
                int hours = timeOfDay / ONE_HOUR;
                internalSet(11, hours);
                internalSet(9, hours / 12);
                internalSet(10, hours % 12);
                int r = timeOfDay % ONE_HOUR;
                internalSet(12, r / ONE_MINUTE);
                int r2 = r % ONE_MINUTE;
                internalSet(13, r2 / 1000);
                internalSet(14, r2 % 1000);
            } else {
                internalSet(11, 0);
                internalSet(9, 0);
                internalSet(10, 0);
                internalSet(12, 0);
                internalSet(13, 0);
                internalSet(14, 0);
            }
            mask |= 32256;
        }
        if ((98304 & fieldMask) != 0) {
            internalSet(15, this.zoneOffsets[0]);
            internalSet(16, this.zoneOffsets[1]);
            mask |= 98304;
        }
        if ((fieldMask & 344) == 0) {
            return mask;
        }
        int normalizedYear = this.cdate.getNormalizedYear();
        long fixedDateJan1 = this.calsys.getFixedDate(normalizedYear, 1, 1, this.cdate);
        int dayOfYear = ((int) (fixedDate2 - fixedDateJan1)) + 1;
        long fixedDateMonth1 = (fixedDate2 - ((long) dayOfMonth)) + 1;
        if (this.calsys == gcal) {
            cutoverYear = this.gregorianCutoverYear;
        } else {
            cutoverYear = this.gregorianCutoverYearJulian;
        }
        int relativeDayOfMonth = dayOfMonth - 1;
        if (normalizedYear == cutoverYear) {
            if (this.gregorianCutoverYearJulian <= this.gregorianCutoverYear) {
                fixedDateJan1 = getFixedDateJan1(this.cdate, fixedDate2);
                if (fixedDate2 >= this.gregorianCutoverDate) {
                    fixedDateMonth1 = getFixedDateMonth1(this.cdate, fixedDate2);
                }
            }
            int realDayOfYear = ((int) (fixedDate2 - fixedDateJan1)) + 1;
            int cutoverGap = dayOfYear - realDayOfYear;
            dayOfYear = realDayOfYear;
            relativeDayOfMonth = (int) (fixedDate2 - fixedDateMonth1);
        }
        internalSet(6, dayOfYear);
        internalSet(8, (relativeDayOfMonth / 7) + 1);
        int weekOfYear = getWeekNumber(fixedDateJan1, fixedDate2);
        if (weekOfYear == 0) {
            long fixedDec31 = fixedDateJan1 - 1;
            long prevJan1 = fixedDateJan1 - 365;
            if (normalizedYear <= cutoverYear + 1) {
                if (normalizedYear > this.gregorianCutoverYearJulian) {
                    BaseCalendar baseCalendar = this.calsys;
                    int prevYear = getCalendarDate(fixedDec31).getNormalizedYear();
                    if (prevYear == this.gregorianCutoverYear) {
                        BaseCalendar calForJan1 = getCutoverCalendarSystem();
                        if (calForJan1 == jcal) {
                            prevJan1 = calForJan1.getFixedDate(prevYear, 1, 1, (BaseCalendar.Date) null);
                        } else {
                            prevJan1 = this.gregorianCutoverDate;
                            BaseCalendar calForJan12 = gcal;
                        }
                    } else {
                        if (prevYear <= this.gregorianCutoverYearJulian) {
                            prevJan1 = getJulianCalendarSystem().getFixedDate(prevYear, 1, 1, (BaseCalendar.Date) null);
                        }
                    }
                } else if (CalendarUtils.isJulianLeapYear(normalizedYear - 1)) {
                    prevJan1--;
                }
            } else if (CalendarUtils.isGregorianLeapYear(normalizedYear - 1)) {
                prevJan1--;
            }
            weekOfYear = getWeekNumber(prevJan1, fixedDec31);
        } else {
            if (normalizedYear <= this.gregorianCutoverYear && normalizedYear >= this.gregorianCutoverYearJulian - 1) {
                BaseCalendar calForJan13 = this.calsys;
                int nextYear = normalizedYear + 1;
                if (nextYear == this.gregorianCutoverYearJulian + 1 && nextYear < this.gregorianCutoverYear) {
                    nextYear = this.gregorianCutoverYear;
                }
                if (nextYear == this.gregorianCutoverYear) {
                    calForJan13 = getCutoverCalendarSystem();
                }
                if (nextYear > this.gregorianCutoverYear || this.gregorianCutoverYearJulian == this.gregorianCutoverYear || nextYear == this.gregorianCutoverYearJulian) {
                    nextJan1 = calForJan13.getFixedDate(nextYear, 1, 1, (BaseCalendar.Date) null);
                } else {
                    nextJan1 = this.gregorianCutoverDate;
                    BaseCalendar calForJan14 = gcal;
                }
                long nextJan1st = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + nextJan1, getFirstDayOfWeek());
                if (((int) (nextJan1st - nextJan1)) >= getMinimalDaysInFirstWeek() && fixedDate2 >= nextJan1st - 7) {
                    weekOfYear = 1;
                }
            } else if (weekOfYear >= 52) {
                long nextJan12 = fixedDateJan1 + 365;
                if (this.cdate.isLeapYear()) {
                    nextJan12++;
                }
                BaseCalendar baseCalendar2 = this.calsys;
                long nextJan1st2 = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + nextJan12, getFirstDayOfWeek());
                if (((int) (nextJan1st2 - nextJan12)) >= getMinimalDaysInFirstWeek() && fixedDate2 >= nextJan1st2 - 7) {
                    weekOfYear = 1;
                }
            }
        }
        internalSet(3, weekOfYear);
        internalSet(4, getWeekNumber(fixedDateMonth1, fixedDate2));
        return mask | 344;
    }

    private final int getWeekNumber(long fixedDay1, long fixedDate) {
        boolean z = f40assertionsDisabled;
        Gregorian gregorian = gcal;
        long fixedDay1st = Gregorian.getDayOfWeekDateOnOrBefore(6 + fixedDay1, getFirstDayOfWeek());
        int ndays = (int) (fixedDay1st - fixedDay1);
        if (!f40assertionsDisabled) {
            if (ndays <= 7) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (ndays >= getMinimalDaysInFirstWeek()) {
            fixedDay1st -= 7;
        }
        int normalizedDayOfPeriod = (int) (fixedDate - fixedDay1st);
        if (normalizedDayOfPeriod >= 0) {
            return (normalizedDayOfPeriod / 7) + 1;
        }
        return CalendarUtils.floorDivide(normalizedDayOfPeriod, 7) + 1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0265  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeTime() {
        /*
            r30 = this;
            boolean r25 = r30.isLenient()
            if (r25 != 0) goto L_0x005e
            r0 = r30
            int[] r0 = r0.originalFields
            r25 = r0
            if (r25 != 0) goto L_0x001c
            r25 = 17
            r0 = r25
            int[] r0 = new int[r0]
            r25 = r0
            r0 = r25
            r1 = r30
            r1.originalFields = r0
        L_0x001c:
            r7 = 0
        L_0x001d:
            r25 = 17
            r0 = r25
            if (r7 >= r0) goto L_0x005e
            r0 = r30
            int r22 = r0.internalGet(r7)
            r0 = r30
            boolean r25 = r0.isExternallySet(r7)
            if (r25 == 0) goto L_0x0053
            r0 = r30
            int r25 = r0.getMinimum(r7)
            r0 = r22
            r1 = r25
            if (r0 < r1) goto L_0x0049
            r0 = r30
            int r25 = r0.getMaximum(r7)
            r0 = r22
            r1 = r25
            if (r0 <= r1) goto L_0x0053
        L_0x0049:
            java.lang.IllegalArgumentException r25 = new java.lang.IllegalArgumentException
            java.lang.String r26 = getFieldName(r7)
            r25.<init>((java.lang.String) r26)
            throw r25
        L_0x0053:
            r0 = r30
            int[] r0 = r0.originalFields
            r25 = r0
            r25[r7] = r22
            int r7 = r7 + 1
            goto L_0x001d
        L_0x005e:
            int r8 = r30.selectFields()
            r25 = 1
            r0 = r30
            r1 = r25
            boolean r25 = r0.isSet(r1)
            if (r25 == 0) goto L_0x0104
            r25 = 1
            r0 = r30
            r1 = r25
            int r23 = r0.internalGet(r1)
        L_0x0078:
            int r6 = r30.internalGetEra()
            if (r6 != 0) goto L_0x0108
            int r23 = 1 - r23
        L_0x0080:
            if (r23 > 0) goto L_0x008e
            r25 = 0
            r0 = r30
            r1 = r25
            boolean r25 = r0.isSet(r1)
            if (r25 == 0) goto L_0x0117
        L_0x008e:
            r25 = 11
            r0 = r25
            boolean r25 = isFieldSet(r8, r0)
            if (r25 == 0) goto L_0x0124
            r25 = 11
            r0 = r30
            r1 = r25
            int r25 = r0.internalGet(r1)
            r0 = r25
            long r0 = (long) r0
            r26 = r0
            r28 = 0
            long r20 = r28 + r26
        L_0x00ab:
            r26 = 60
            long r20 = r20 * r26
            r25 = 12
            r0 = r30
            r1 = r25
            int r25 = r0.internalGet(r1)
            r0 = r25
            long r0 = (long) r0
            r26 = r0
            long r20 = r20 + r26
            r26 = 60
            long r20 = r20 * r26
            r25 = 13
            r0 = r30
            r1 = r25
            int r25 = r0.internalGet(r1)
            r0 = r25
            long r0 = (long) r0
            r26 = r0
            long r20 = r20 + r26
            r26 = 1000(0x3e8, double:4.94E-321)
            long r20 = r20 * r26
            r25 = 14
            r0 = r30
            r1 = r25
            int r25 = r0.internalGet(r1)
            r0 = r25
            long r0 = (long) r0
            r26 = r0
            long r20 = r20 + r26
            r26 = 86400000(0x5265c00, double:4.2687272E-316)
            long r10 = r20 / r26
            r26 = 86400000(0x5265c00, double:4.2687272E-316)
            long r20 = r20 % r26
        L_0x00f4:
            r26 = 0
            int r25 = (r20 > r26 ? 1 : (r20 == r26 ? 0 : -1))
            if (r25 >= 0) goto L_0x0156
            r26 = 86400000(0x5265c00, double:4.2687272E-316)
            long r20 = r20 + r26
            r26 = 1
            long r10 = r10 - r26
            goto L_0x00f4
        L_0x0104:
            r23 = 1970(0x7b2, float:2.76E-42)
            goto L_0x0078
        L_0x0108:
            r25 = 1
            r0 = r25
            if (r6 == r0) goto L_0x0080
            java.lang.IllegalArgumentException r25 = new java.lang.IllegalArgumentException
            java.lang.String r26 = "Invalid era"
            r25.<init>((java.lang.String) r26)
            throw r25
        L_0x0117:
            r8 = r8 | 1
            r25 = 1
            r0 = r30
            r1 = r25
            r0.setFieldsComputed(r1)
            goto L_0x008e
        L_0x0124:
            r25 = 10
            r0 = r30
            r1 = r25
            int r25 = r0.internalGet(r1)
            r0 = r25
            long r0 = (long) r0
            r26 = r0
            r28 = 0
            long r20 = r28 + r26
            r25 = 9
            r0 = r25
            boolean r25 = isFieldSet(r8, r0)
            if (r25 == 0) goto L_0x00ab
            r25 = 9
            r0 = r30
            r1 = r25
            int r25 = r0.internalGet(r1)
            int r25 = r25 * 12
            r0 = r25
            long r0 = (long) r0
            r26 = r0
            long r20 = r20 + r26
            goto L_0x00ab
        L_0x0156:
            r0 = r30
            int r0 = r0.gregorianCutoverYear
            r25 = r0
            r0 = r23
            r1 = r25
            if (r0 <= r1) goto L_0x020f
            r0 = r30
            int r0 = r0.gregorianCutoverYearJulian
            r25 = r0
            r0 = r23
            r1 = r25
            if (r0 <= r1) goto L_0x020f
            sun.util.calendar.Gregorian r25 = gcal
            r0 = r30
            r1 = r25
            r2 = r23
            long r26 = r0.getFixedDate(r1, r2, r8)
            long r12 = r10 + r26
            r0 = r30
            long r0 = r0.gregorianCutoverDate
            r26 = r0
            int r25 = (r12 > r26 ? 1 : (r12 == r26 ? 0 : -1))
            if (r25 < 0) goto L_0x01d6
            r10 = r12
        L_0x0187:
            r26 = 719163(0xaf93b, double:3.553137E-318)
            long r26 = r10 - r26
            r28 = 86400000(0x5265c00, double:4.2687272E-316)
            long r26 = r26 * r28
            long r16 = r26 + r20
            java.util.TimeZone r24 = r30.getZone()
            r25 = 98304(0x18000, float:1.37753E-40)
            r19 = r8 & r25
            r0 = r30
            r1 = r19
            r2 = r16
            r4 = r24
            long r16 = r0.adjustForZoneAndDaylightSavingsTime(r1, r2, r4)
            r0 = r16
            r2 = r30
            r2.time = r0
            int r25 = r30.getSetStateFields()
            r25 = r25 | r8
            r0 = r30
            r1 = r25
            r2 = r19
            int r9 = r0.computeFields(r1, r2)
            boolean r25 = r30.isLenient()
            if (r25 != 0) goto L_0x034e
            r7 = 0
        L_0x01c5:
            r25 = 17
            r0 = r25
            if (r7 >= r0) goto L_0x034e
            r0 = r30
            boolean r25 = r0.isExternallySet(r7)
            if (r25 != 0) goto L_0x02c6
        L_0x01d3:
            int r7 = r7 + 1
            goto L_0x01c5
        L_0x01d6:
            sun.util.calendar.BaseCalendar r25 = getJulianCalendarSystem()
            r0 = r30
            r1 = r25
            r2 = r23
            long r26 = r0.getFixedDate(r1, r2, r8)
            long r14 = r10 + r26
        L_0x01e6:
            r25 = 6
            r0 = r25
            boolean r25 = isFieldSet(r8, r0)
            if (r25 != 0) goto L_0x01fa
            r25 = 3
            r0 = r25
            boolean r25 = isFieldSet(r8, r0)
            if (r25 == 0) goto L_0x0274
        L_0x01fa:
            r0 = r30
            int r0 = r0.gregorianCutoverYear
            r25 = r0
            r0 = r30
            int r0 = r0.gregorianCutoverYearJulian
            r26 = r0
            r0 = r25
            r1 = r26
            if (r0 != r1) goto L_0x0265
            r10 = r14
            goto L_0x0187
        L_0x020f:
            r0 = r30
            int r0 = r0.gregorianCutoverYear
            r25 = r0
            r0 = r23
            r1 = r25
            if (r0 >= r1) goto L_0x0246
            r0 = r30
            int r0 = r0.gregorianCutoverYearJulian
            r25 = r0
            r0 = r23
            r1 = r25
            if (r0 >= r1) goto L_0x0246
            sun.util.calendar.BaseCalendar r25 = getJulianCalendarSystem()
            r0 = r30
            r1 = r25
            r2 = r23
            long r26 = r0.getFixedDate(r1, r2, r8)
            long r14 = r10 + r26
            r0 = r30
            long r0 = r0.gregorianCutoverDate
            r26 = r0
            int r25 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r25 >= 0) goto L_0x0244
            r10 = r14
            goto L_0x0187
        L_0x0244:
            r12 = r14
            goto L_0x01e6
        L_0x0246:
            sun.util.calendar.BaseCalendar r25 = getJulianCalendarSystem()
            r0 = r30
            r1 = r25
            r2 = r23
            long r26 = r0.getFixedDate(r1, r2, r8)
            long r14 = r10 + r26
            sun.util.calendar.Gregorian r25 = gcal
            r0 = r30
            r1 = r25
            r2 = r23
            long r26 = r0.getFixedDate(r1, r2, r8)
            long r12 = r10 + r26
            goto L_0x01e6
        L_0x0265:
            r0 = r30
            int r0 = r0.gregorianCutoverYear
            r25 = r0
            r0 = r23
            r1 = r25
            if (r0 != r1) goto L_0x0274
            r10 = r12
            goto L_0x0187
        L_0x0274:
            r0 = r30
            long r0 = r0.gregorianCutoverDate
            r26 = r0
            int r25 = (r12 > r26 ? 1 : (r12 == r26 ? 0 : -1))
            if (r25 < 0) goto L_0x02a7
            r0 = r30
            long r0 = r0.gregorianCutoverDate
            r26 = r0
            int r25 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r25 < 0) goto L_0x028b
            r10 = r12
            goto L_0x0187
        L_0x028b:
            r0 = r30
            sun.util.calendar.BaseCalendar r0 = r0.calsys
            r25 = r0
            sun.util.calendar.Gregorian r26 = gcal
            r0 = r25
            r1 = r26
            if (r0 == r1) goto L_0x02a1
            r0 = r30
            sun.util.calendar.BaseCalendar r0 = r0.calsys
            r25 = r0
            if (r25 != 0) goto L_0x02a4
        L_0x02a1:
            r10 = r12
            goto L_0x0187
        L_0x02a4:
            r10 = r14
            goto L_0x0187
        L_0x02a7:
            r0 = r30
            long r0 = r0.gregorianCutoverDate
            r26 = r0
            int r25 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r25 >= 0) goto L_0x02b4
            r10 = r14
            goto L_0x0187
        L_0x02b4:
            boolean r25 = r30.isLenient()
            if (r25 != 0) goto L_0x02c3
            java.lang.IllegalArgumentException r25 = new java.lang.IllegalArgumentException
            java.lang.String r26 = "the specified date doesn't exist"
            r25.<init>((java.lang.String) r26)
            throw r25
        L_0x02c3:
            r10 = r14
            goto L_0x0187
        L_0x02c6:
            r0 = r30
            int[] r0 = r0.originalFields
            r25 = r0
            r25 = r25[r7]
            r0 = r30
            int r26 = r0.internalGet(r7)
            r0 = r25
            r1 = r26
            if (r0 == r1) goto L_0x01d3
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r25.<init>()
            r0 = r30
            int[] r0 = r0.originalFields
            r26 = r0
            r26 = r26[r7]
            java.lang.StringBuilder r25 = r25.append((int) r26)
            java.lang.String r26 = " -> "
            java.lang.StringBuilder r25 = r25.append((java.lang.String) r26)
            r0 = r30
            int r26 = r0.internalGet(r7)
            java.lang.StringBuilder r25 = r25.append((int) r26)
            java.lang.String r18 = r25.toString()
            r0 = r30
            int[] r0 = r0.originalFields
            r25 = r0
            r0 = r30
            int[] r0 = r0.fields
            r26 = r0
            r0 = r30
            int[] r0 = r0.fields
            r27 = r0
            r0 = r27
            int r0 = r0.length
            r27 = r0
            r28 = 0
            r29 = 0
            r0 = r25
            r1 = r28
            r2 = r26
            r3 = r29
            r4 = r27
            java.lang.System.arraycopy((int[]) r0, (int) r1, (int[]) r2, (int) r3, (int) r4)
            java.lang.IllegalArgumentException r25 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r26 = new java.lang.StringBuilder
            r26.<init>()
            java.lang.String r27 = getFieldName(r7)
            java.lang.StringBuilder r26 = r26.append((java.lang.String) r27)
            java.lang.String r27 = ": "
            java.lang.StringBuilder r26 = r26.append((java.lang.String) r27)
            r0 = r26
            r1 = r18
            java.lang.StringBuilder r26 = r0.append((java.lang.String) r1)
            java.lang.String r26 = r26.toString()
            r25.<init>((java.lang.String) r26)
            throw r25
        L_0x034e:
            r0 = r30
            r0.setFieldsNormalized(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.GregorianCalendar.computeTime():void");
    }

    private long adjustForZoneAndDaylightSavingsTime(int tzMask, long utcTimeInMillis, TimeZone zone) {
        int zoneOffset = 0;
        int dstOffset = 0;
        if (tzMask != 98304) {
            if (this.zoneOffsets == null) {
                this.zoneOffsets = new int[2];
            }
            long standardTimeInZone = utcTimeInMillis - ((long) (isFieldSet(tzMask, 15) ? internalGet(15) : zone.getRawOffset()));
            if (zone instanceof ZoneInfo) {
                ((ZoneInfo) zone).getOffsetsByUtcTime(standardTimeInZone, this.zoneOffsets);
            } else {
                zone.getOffsets(standardTimeInZone, this.zoneOffsets);
            }
            zoneOffset = this.zoneOffsets[0];
            dstOffset = adjustDstOffsetForInvalidWallClock(standardTimeInZone, zone, this.zoneOffsets[1]);
        }
        if (tzMask != 0) {
            if (isFieldSet(tzMask, 15)) {
                zoneOffset = internalGet(15);
            }
            if (isFieldSet(tzMask, 16)) {
                dstOffset = internalGet(16);
            }
        }
        return (utcTimeInMillis - ((long) zoneOffset)) - ((long) dstOffset);
    }

    private int adjustDstOffsetForInvalidWallClock(long standardTimeInZone, TimeZone zone, int dstOffset) {
        if (dstOffset == 0 || zone.inDaylightTime(new Date(standardTimeInZone - ((long) dstOffset)))) {
            return dstOffset;
        }
        return 0;
    }

    private long getFixedDate(BaseCalendar cal, int year, int fieldMask) {
        int dayOfWeek;
        int dayOfWeek2;
        int dowim;
        int month = 0;
        if (isFieldSet(fieldMask, 2)) {
            month = internalGet(2);
            if (month > 11) {
                year += month / 12;
                month %= 12;
            } else if (month < 0) {
                int[] rem = new int[1];
                year += CalendarUtils.floorDivide(month, 12, rem);
                month = rem[0];
            }
        }
        long fixedDate = cal.getFixedDate(year, month + 1, 1, cal == gcal ? this.gdate : null);
        if (!isFieldSet(fieldMask, 2)) {
            if (year == this.gregorianCutoverYear && cal == gcal && fixedDate < this.gregorianCutoverDate && this.gregorianCutoverYear != this.gregorianCutoverYearJulian) {
                fixedDate = this.gregorianCutoverDate;
            }
            if (isFieldSet(fieldMask, 6)) {
                return (fixedDate + ((long) internalGet(6))) - 1;
            }
            long firstDayOfWeek = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + fixedDate, getFirstDayOfWeek());
            if (firstDayOfWeek - fixedDate >= ((long) getMinimalDaysInFirstWeek())) {
                firstDayOfWeek -= 7;
            }
            if (isFieldSet(fieldMask, 7) && (dayOfWeek = internalGet(7)) != getFirstDayOfWeek()) {
                firstDayOfWeek = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + firstDayOfWeek, dayOfWeek);
            }
            return firstDayOfWeek + ((((long) internalGet(3)) - 1) * 7);
        } else if (isFieldSet(fieldMask, 5)) {
            return isSet(5) ? (fixedDate + ((long) internalGet(5))) - 1 : fixedDate;
        } else {
            if (isFieldSet(fieldMask, 4)) {
                long firstDayOfWeek2 = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + fixedDate, getFirstDayOfWeek());
                if (firstDayOfWeek2 - fixedDate >= ((long) getMinimalDaysInFirstWeek())) {
                    firstDayOfWeek2 -= 7;
                }
                if (isFieldSet(fieldMask, 7)) {
                    firstDayOfWeek2 = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + firstDayOfWeek2, internalGet(7));
                }
                return firstDayOfWeek2 + ((long) ((internalGet(4) - 1) * 7));
            }
            if (isFieldSet(fieldMask, 7)) {
                dayOfWeek2 = internalGet(7);
            } else {
                dayOfWeek2 = getFirstDayOfWeek();
            }
            if (isFieldSet(fieldMask, 8)) {
                dowim = internalGet(8);
            } else {
                dowim = 1;
            }
            if (dowim >= 0) {
                return BaseCalendar.getDayOfWeekDateOnOrBefore((((long) (dowim * 7)) + fixedDate) - 1, dayOfWeek2);
            }
            return BaseCalendar.getDayOfWeekDateOnOrBefore((((long) (monthLength(month, year) + ((dowim + 1) * 7))) + fixedDate) - 1, dayOfWeek2);
        }
    }

    private final GregorianCalendar getNormalizedCalendar() {
        if (isFullyNormalized()) {
            return this;
        }
        GregorianCalendar gc = (GregorianCalendar) clone();
        gc.setLenient(true);
        gc.complete();
        return gc;
    }

    private static final synchronized BaseCalendar getJulianCalendarSystem() {
        JulianCalendar julianCalendar;
        synchronized (GregorianCalendar.class) {
            if (jcal == null) {
                jcal = (JulianCalendar) CalendarSystem.forName("julian");
                jeras = jcal.getEras();
            }
            julianCalendar = jcal;
        }
        return julianCalendar;
    }

    private BaseCalendar getCutoverCalendarSystem() {
        if (this.gregorianCutoverYearJulian < this.gregorianCutoverYear) {
            return gcal;
        }
        return getJulianCalendarSystem();
    }

    private final boolean isCutoverYear(int normalizedYear) {
        if (normalizedYear == (this.calsys == gcal ? this.gregorianCutoverYear : this.gregorianCutoverYearJulian)) {
            return true;
        }
        return f40assertionsDisabled;
    }

    private final long getFixedDateJan1(BaseCalendar.Date date, long fixedDate) {
        boolean z;
        if (!f40assertionsDisabled) {
            if (date.getNormalizedYear() != this.gregorianCutoverYear) {
                z = date.getNormalizedYear() == this.gregorianCutoverYearJulian ? true : f40assertionsDisabled;
            } else {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (this.gregorianCutoverYear == this.gregorianCutoverYearJulian || fixedDate < this.gregorianCutoverDate) {
            return getJulianCalendarSystem().getFixedDate(date.getNormalizedYear(), 1, 1, (BaseCalendar.Date) null);
        }
        return this.gregorianCutoverDate;
    }

    private final long getFixedDateMonth1(BaseCalendar.Date date, long fixedDate) {
        boolean z;
        if (!f40assertionsDisabled) {
            if (date.getNormalizedYear() != this.gregorianCutoverYear) {
                z = date.getNormalizedYear() == this.gregorianCutoverYearJulian ? true : f40assertionsDisabled;
            } else {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        BaseCalendar.Date gCutover = getGregorianCutoverDate();
        if (gCutover.getMonth() == 1 && gCutover.getDayOfMonth() == 1) {
            return (fixedDate - ((long) date.getDayOfMonth())) + 1;
        }
        if (date.getMonth() != gCutover.getMonth()) {
            return (fixedDate - ((long) date.getDayOfMonth())) + 1;
        }
        BaseCalendar.Date jLastDate = getLastJulianDate();
        if (this.gregorianCutoverYear == this.gregorianCutoverYearJulian && gCutover.getMonth() == jLastDate.getMonth()) {
            return jcal.getFixedDate(date.getNormalizedYear(), date.getMonth(), 1, (BaseCalendar.Date) null);
        }
        return this.gregorianCutoverDate;
    }

    private final BaseCalendar.Date getCalendarDate(long fd) {
        BaseCalendar cal = fd >= this.gregorianCutoverDate ? gcal : getJulianCalendarSystem();
        BaseCalendar.Date d = (BaseCalendar.Date) cal.newCalendarDate(TimeZone.NO_TIMEZONE);
        cal.getCalendarDateFromFixedDate(d, fd);
        return d;
    }

    private final BaseCalendar.Date getGregorianCutoverDate() {
        return getCalendarDate(this.gregorianCutoverDate);
    }

    private final BaseCalendar.Date getLastJulianDate() {
        return getCalendarDate(this.gregorianCutoverDate - 1);
    }

    private final int monthLength(int month, int year) {
        return isLeapYear(year) ? LEAP_MONTH_LENGTH[month] : MONTH_LENGTH[month];
    }

    private final int monthLength(int month) {
        int year = internalGet(1);
        if (internalGetEra() == 0) {
            year = 1 - year;
        }
        return monthLength(month, year);
    }

    private final int actualMonthLength() {
        int year = this.cdate.getNormalizedYear();
        if (year != this.gregorianCutoverYear && year != this.gregorianCutoverYearJulian) {
            return this.calsys.getMonthLength(this.cdate);
        }
        BaseCalendar.Date date = (BaseCalendar.Date) this.cdate.clone();
        long month1 = getFixedDateMonth1(date, this.calsys.getFixedDate(date));
        long next1 = month1 + ((long) this.calsys.getMonthLength(date));
        if (next1 < this.gregorianCutoverDate) {
            return (int) (next1 - month1);
        }
        if (this.cdate != this.gdate) {
            date = gcal.newCalendarDate(TimeZone.NO_TIMEZONE);
        }
        gcal.getCalendarDateFromFixedDate(date, next1);
        return (int) (getFixedDateMonth1(date, next1) - month1);
    }

    private final int yearLength(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    private final int yearLength() {
        int year = internalGet(1);
        if (internalGetEra() == 0) {
            year = 1 - year;
        }
        return yearLength(year);
    }

    private final void pinDayOfMonth() {
        int monthLen;
        int year = internalGet(1);
        if (year > this.gregorianCutoverYear || year < this.gregorianCutoverYearJulian) {
            monthLen = monthLength(internalGet(2));
        } else {
            monthLen = getNormalizedCalendar().getActualMaximum(5);
        }
        if (internalGet(5) > monthLen) {
            set(5, monthLen);
        }
    }

    private final long getCurrentFixedDate() {
        return this.calsys == gcal ? this.cachedFixedDate : this.calsys.getFixedDate(this.cdate);
    }

    private static final int getRolledValue(int value, int amount, int min, int max) {
        boolean z = true;
        if (!f40assertionsDisabled) {
            if (!(value >= min && value <= max)) {
                throw new AssertionError();
            }
        }
        int range = (max - min) + 1;
        int n = value + (amount % range);
        if (n > max) {
            n -= range;
        } else if (n < min) {
            n += range;
        }
        if (!f40assertionsDisabled) {
            if (n < min || n > max) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return n;
    }

    private final int internalGetEra() {
        if (isSet(0)) {
            return internalGet(0);
        }
        return 1;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        if (this.gdate == null) {
            this.gdate = gcal.newCalendarDate(getZone());
            this.cachedFixedDate = Long.MIN_VALUE;
        }
        setGregorianChange(this.gregorianCutover);
    }
}
