package java.text;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import libcore.icu.LocaleData;
import libcore.icu.TimeZoneNames;
import sun.util.calendar.CalendarUtils;

public class SimpleDateFormat extends DateFormat {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f32assertionsDisabled = false;
    private static final String GMT = "GMT";
    private static final int MILLIS_PER_MINUTE = 60000;
    private static final int[] PATTERN_INDEX_TO_CALENDAR_FIELD = null;
    private static final int[] PATTERN_INDEX_TO_DATE_FORMAT_FIELD = null;
    private static final DateFormat.Field[] PATTERN_INDEX_TO_DATE_FORMAT_FIELD_ID = null;
    private static final int TAG_QUOTE_ASCII_CHAR = 100;
    private static final int TAG_QUOTE_CHARS = 101;
    private static final ConcurrentMap<Locale, NumberFormat> cachedNumberFormatData = null;
    static final int currentSerialVersion = 1;
    static final long serialVersionUID = 4774881970558875024L;
    private transient char[] compiledPattern;
    private Date defaultCenturyStart;
    private transient int defaultCenturyStartYear;
    private DateFormatSymbols formatData;
    private transient boolean hasFollowingMinusSign;
    private Locale locale;
    private transient char minusSign;
    private transient NumberFormat originalNumberFormat;
    private transient String originalNumberPattern;
    private String pattern;
    private int serialVersionOnStream;
    transient boolean useDateFormatSymbols;
    private transient char zeroDigit;

    public SimpleDateFormat() {
        this(3, 3, Locale.getDefault(Locale.Category.FORMAT));
    }

    public SimpleDateFormat(String pattern2) {
        this(pattern2, Locale.getDefault(Locale.Category.FORMAT));
    }

    public SimpleDateFormat(String pattern2, Locale locale2) {
        this.serialVersionOnStream = 1;
        this.minusSign = '-';
        this.hasFollowingMinusSign = f32assertionsDisabled;
        if (pattern2 == null || locale2 == null) {
            throw new NullPointerException();
        }
        initializeCalendar(locale2);
        this.pattern = pattern2;
        this.formatData = DateFormatSymbols.getInstanceRef(locale2);
        this.locale = locale2;
        initialize(locale2);
    }

    public SimpleDateFormat(String pattern2, DateFormatSymbols formatSymbols) {
        this.serialVersionOnStream = 1;
        this.minusSign = '-';
        this.hasFollowingMinusSign = f32assertionsDisabled;
        if (pattern2 == null || formatSymbols == null) {
            throw new NullPointerException();
        }
        this.pattern = pattern2;
        this.formatData = (DateFormatSymbols) formatSymbols.clone();
        this.locale = Locale.getDefault(Locale.Category.FORMAT);
        initializeCalendar(this.locale);
        initialize(this.locale);
        this.useDateFormatSymbols = true;
    }

    SimpleDateFormat(int timeStyle, int dateStyle, Locale loc) {
        this.serialVersionOnStream = 1;
        this.minusSign = '-';
        this.hasFollowingMinusSign = f32assertionsDisabled;
        if (loc == null) {
            throw new NullPointerException();
        }
        this.locale = loc;
        initializeCalendar(loc);
        this.formatData = DateFormatSymbols.getInstanceRef(loc);
        LocaleData localeData = LocaleData.get(loc);
        if (timeStyle >= 0 && dateStyle >= 0) {
            this.pattern = MessageFormat.format("{0} {1}", localeData.getDateFormat(dateStyle), localeData.getTimeFormat(timeStyle));
        } else if (timeStyle >= 0) {
            this.pattern = localeData.getTimeFormat(timeStyle);
        } else if (dateStyle >= 0) {
            this.pattern = localeData.getDateFormat(dateStyle);
        } else {
            throw new IllegalArgumentException("No date or time style specified");
        }
        initialize(loc);
    }

    private void initialize(Locale loc) {
        this.compiledPattern = compile(this.pattern);
        this.numberFormat = (NumberFormat) cachedNumberFormatData.get(loc);
        if (this.numberFormat == null) {
            this.numberFormat = NumberFormat.getIntegerInstance(loc);
            this.numberFormat.setGroupingUsed(f32assertionsDisabled);
            cachedNumberFormatData.putIfAbsent(loc, this.numberFormat);
        }
        this.numberFormat = (NumberFormat) this.numberFormat.clone();
        initializeDefaultCentury();
    }

    private void initializeCalendar(Locale loc) {
        if (this.calendar == null) {
            if (!f32assertionsDisabled) {
                if (!(loc != null ? true : f32assertionsDisabled)) {
                    throw new AssertionError();
                }
            }
            this.calendar = Calendar.getInstance(TimeZone.getDefault(), loc);
        }
    }

    private char[] compile(String pattern2) {
        char c;
        int length = pattern2.length();
        boolean inQuote = f32assertionsDisabled;
        StringBuilder compiledPattern2 = new StringBuilder(length * 2);
        StringBuilder tmpBuffer = null;
        int count = 0;
        int lastTag = -1;
        int i = 0;
        while (i < length) {
            char c2 = pattern2.charAt(i);
            if (c2 == '\'') {
                if (i + 1 < length && (c = pattern2.charAt(i + 1)) == '\'') {
                    i++;
                    if (count != 0) {
                        encode(lastTag, count, compiledPattern2);
                        lastTag = -1;
                        count = 0;
                    }
                    if (inQuote) {
                        tmpBuffer.append(c);
                    } else {
                        compiledPattern2.append((char) (c | 25600));
                    }
                } else if (!inQuote) {
                    if (count != 0) {
                        encode(lastTag, count, compiledPattern2);
                        lastTag = -1;
                        count = 0;
                    }
                    if (tmpBuffer == null) {
                        tmpBuffer = new StringBuilder(length);
                    } else {
                        tmpBuffer.setLength(0);
                    }
                    inQuote = true;
                } else {
                    int len = tmpBuffer.length();
                    if (len == 1) {
                        char ch = tmpBuffer.charAt(0);
                        if (ch < 128) {
                            compiledPattern2.append((char) (ch | 25600));
                        } else {
                            compiledPattern2.append(25857);
                            compiledPattern2.append(ch);
                        }
                    } else {
                        encode(TAG_QUOTE_CHARS, len, compiledPattern2);
                        compiledPattern2.append((CharSequence) tmpBuffer);
                    }
                    inQuote = f32assertionsDisabled;
                }
            } else if (inQuote) {
                tmpBuffer.append(c2);
            } else if ((c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z')) {
                if (count != 0) {
                    encode(lastTag, count, compiledPattern2);
                    lastTag = -1;
                    count = 0;
                }
                if (c2 < 128) {
                    compiledPattern2.append((char) (c2 | 25600));
                } else {
                    int j = i + 1;
                    while (j < length) {
                        char d = pattern2.charAt(j);
                        if (d == '\'' || ((d >= 'a' && d <= 'z') || (d >= 'A' && d <= 'Z'))) {
                            break;
                        }
                        j++;
                    }
                    compiledPattern2.append((char) ((j - i) | 25856));
                    while (i < j) {
                        compiledPattern2.append(pattern2.charAt(i));
                        i++;
                    }
                    i--;
                }
            } else {
                int tag = "GyMdkHmsSEDFwWahKzZYuXLc".indexOf((int) c2);
                if (tag == -1) {
                    throw new IllegalArgumentException("Illegal pattern character '" + c2 + "'");
                } else if (lastTag == -1 || lastTag == tag) {
                    lastTag = tag;
                    count++;
                } else {
                    encode(lastTag, count, compiledPattern2);
                    lastTag = tag;
                    count = 1;
                }
            }
            i++;
        }
        if (inQuote) {
            throw new IllegalArgumentException("Unterminated quote");
        }
        if (count != 0) {
            encode(lastTag, count, compiledPattern2);
        }
        int len2 = compiledPattern2.length();
        char[] r = new char[len2];
        compiledPattern2.getChars(0, len2, r, 0);
        return r;
    }

    private static final void encode(int tag, int length, StringBuilder buffer) {
        if (tag == 21 && length >= 4) {
            throw new IllegalArgumentException("invalid ISO 8601 format: length=" + length);
        } else if (length < 255) {
            buffer.append((char) ((tag << 8) | length));
        } else {
            buffer.append((char) ((tag << 8) | 255));
            buffer.append((char) (length >>> 16));
            buffer.append((char) (65535 & length));
        }
    }

    private void initializeDefaultCentury() {
        this.calendar.setTimeInMillis(System.currentTimeMillis());
        this.calendar.add(1, -80);
        parseAmbiguousDatesAsAfter(this.calendar.getTime());
    }

    private void parseAmbiguousDatesAsAfter(Date startDate) {
        this.defaultCenturyStart = startDate;
        this.calendar.setTime(startDate);
        this.defaultCenturyStartYear = this.calendar.get(1);
    }

    public void set2DigitYearStart(Date startDate) {
        parseAmbiguousDatesAsAfter(new Date(startDate.getTime()));
    }

    public Date get2DigitYearStart() {
        return (Date) this.defaultCenturyStart.clone();
    }

    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {
        pos.endIndex = 0;
        pos.beginIndex = 0;
        return format(date, toAppendTo, pos.getFieldDelegate());
    }

    private StringBuffer format(Date date, StringBuffer toAppendTo, Format.FieldDelegate delegate) {
        this.calendar.setTime(date);
        boolean useDateFormatSymbols2 = useDateFormatSymbols();
        int i = 0;
        while (i < this.compiledPattern.length) {
            int tag = this.compiledPattern[i] >>> 8;
            int i2 = i + 1;
            int count = this.compiledPattern[i] & 255;
            if (count == 255) {
                int i3 = i2 + 1;
                count = (this.compiledPattern[i2] << 16) | this.compiledPattern[i3];
                i = i3 + 1;
            } else {
                i = i2;
            }
            switch (tag) {
                case TAG_QUOTE_ASCII_CHAR /*100*/:
                    toAppendTo.append((char) count);
                    break;
                case TAG_QUOTE_CHARS /*101*/:
                    toAppendTo.append(this.compiledPattern, i, count);
                    i += count;
                    break;
                default:
                    subFormat(tag, count, delegate, toAppendTo, useDateFormatSymbols2);
                    break;
            }
        }
        return toAppendTo;
    }

    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        StringBuffer sb = new StringBuffer();
        CharacterIteratorFieldDelegate delegate = new CharacterIteratorFieldDelegate();
        if (obj instanceof Date) {
            format((Date) obj, sb, (Format.FieldDelegate) delegate);
        } else if (obj instanceof Number) {
            format(new Date(((Number) obj).longValue()), sb, (Format.FieldDelegate) delegate);
        } else if (obj == null) {
            throw new NullPointerException("formatToCharacterIterator must be passed non-null object");
        } else {
            throw new IllegalArgumentException("Cannot format given Object as a Date");
        }
        return delegate.getIterator(sb.toString());
    }

    private void subFormat(int patternCharIndex, int count, Format.FieldDelegate delegate, StringBuffer buffer, boolean useDateFormatSymbols2) {
        int value;
        String zoneString;
        String current = null;
        int beginOffset = buffer.length();
        int field = PATTERN_INDEX_TO_CALENDAR_FIELD[patternCharIndex];
        if (field == 17) {
            if (this.calendar.isWeekDateSupported()) {
                value = this.calendar.getWeekYear();
            } else {
                patternCharIndex = 1;
                field = PATTERN_INDEX_TO_CALENDAR_FIELD[1];
                value = this.calendar.get(field);
            }
        } else if (field == 1000) {
            value = CalendarBuilder.toISODayOfWeek(this.calendar.get(7));
        } else {
            value = this.calendar.get(field);
        }
        int style = count >= 4 ? 2 : 1;
        if (!useDateFormatSymbols2 && field != 1000) {
            current = this.calendar.getDisplayName(field, style, this.locale);
        }
        switch (patternCharIndex) {
            case 0:
                if (useDateFormatSymbols2) {
                    String[] eras = this.formatData.getEras();
                    if (value < eras.length) {
                        current = eras[value];
                    }
                }
                if (current == null) {
                    current = "";
                    break;
                }
                break;
            case 1:
            case DigitList.MAX_COUNT:
                if (!(this.calendar instanceof GregorianCalendar)) {
                    if (current == null) {
                        if (style == 2) {
                            count = 1;
                        }
                        zeroPaddingNumber(value, count, Integer.MAX_VALUE, buffer);
                        break;
                    }
                } else if (count == 2) {
                    zeroPaddingNumber(value, 2, 2, buffer);
                    break;
                } else {
                    zeroPaddingNumber(value, count, Integer.MAX_VALUE, buffer);
                    break;
                }
                break;
            case 2:
                current = formatMonth(count, value, Integer.MAX_VALUE, buffer, useDateFormatSymbols2, f32assertionsDisabled);
                break;
            case 4:
                if (current == null) {
                    if (value != 0) {
                        zeroPaddingNumber(value, count, Integer.MAX_VALUE, buffer);
                        break;
                    } else {
                        zeroPaddingNumber(this.calendar.getMaximum(11) + 1, count, Integer.MAX_VALUE, buffer);
                        break;
                    }
                }
                break;
            case 8:
                if (current == null) {
                    zeroPaddingNumber((int) ((((double) value) / 1000.0d) * Math.pow(10.0d, (double) count)), count, count, buffer);
                    break;
                }
                break;
            case 9:
                current = formatWeekday(count, value, useDateFormatSymbols2, f32assertionsDisabled);
                break;
            case 14:
                if (useDateFormatSymbols2) {
                    current = this.formatData.getAmPmStrings()[value];
                    break;
                }
                break;
            case 15:
                if (current == null) {
                    if (value != 0) {
                        zeroPaddingNumber(value, count, Integer.MAX_VALUE, buffer);
                        break;
                    } else {
                        zeroPaddingNumber(this.calendar.getLeastMaximum(10) + 1, count, Integer.MAX_VALUE, buffer);
                        break;
                    }
                }
                break;
            case 17:
                if (current == null) {
                    TimeZone tz = this.calendar.getTimeZone();
                    boolean daylight = this.calendar.get(16) != 0 ? true : f32assertionsDisabled;
                    int tzstyle = count < 4 ? 0 : 1;
                    if (this.formatData.isZoneStringsSet) {
                        zoneString = TimeZoneNames.getDisplayName(this.formatData.getZoneStringsWrapper(), tz.getID(), daylight, tzstyle);
                    } else {
                        zoneString = tz.getDisplayName(daylight, tzstyle, this.formatData.locale);
                    }
                    if (zoneString == null) {
                        buffer.append(TimeZone.createGmtOffsetString(true, true, this.calendar.get(15) + this.calendar.get(16)));
                        break;
                    } else {
                        buffer.append(zoneString);
                        break;
                    }
                }
                break;
            case 18:
                int value2 = this.calendar.get(15) + this.calendar.get(16);
                buffer.append(TimeZone.createGmtOffsetString(count == 4 ? true : f32assertionsDisabled, count >= 4 ? true : f32assertionsDisabled, value2));
                break;
            case 21:
                int value3 = this.calendar.get(15) + this.calendar.get(16);
                if (value3 != 0) {
                    int value4 = value3 / MILLIS_PER_MINUTE;
                    if (value4 >= 0) {
                        buffer.append('+');
                    } else {
                        buffer.append('-');
                        value4 = -value4;
                    }
                    CalendarUtils.sprintf0d(buffer, value4 / 60, 2);
                    if (count != 1) {
                        if (count == 3) {
                            buffer.append(':');
                        }
                        CalendarUtils.sprintf0d(buffer, value4 % 60, 2);
                        break;
                    }
                } else {
                    buffer.append('Z');
                    break;
                }
                break;
            case 22:
                current = formatMonth(count, value, Integer.MAX_VALUE, buffer, useDateFormatSymbols2, true);
                break;
            case SecureRandom.DEFAULT_SDK_TARGET_FOR_CRYPTO_PROVIDER_WORKAROUND:
                current = formatWeekday(count, value, useDateFormatSymbols2, true);
                break;
            default:
                if (current == null) {
                    zeroPaddingNumber(value, count, Integer.MAX_VALUE, buffer);
                    break;
                }
                break;
        }
        if (current != null) {
            buffer.append(current);
        }
        int fieldID = PATTERN_INDEX_TO_DATE_FORMAT_FIELD[patternCharIndex];
        DateFormat.Field f = PATTERN_INDEX_TO_DATE_FORMAT_FIELD_ID[patternCharIndex];
        delegate.formatted(fieldID, f, f, beginOffset, buffer.length(), buffer);
    }

    private String formatWeekday(int count, int value, boolean useDateFormatSymbols2, boolean standalone) {
        String[] weekdays;
        if (!useDateFormatSymbols2) {
            return null;
        }
        if (count == 4) {
            weekdays = standalone ? this.formatData.getStandAloneWeekdays() : this.formatData.getWeekdays();
        } else if (count == 5) {
            weekdays = standalone ? this.formatData.getTinyStandAloneWeekdays() : this.formatData.getTinyWeekdays();
        } else {
            weekdays = standalone ? this.formatData.getShortStandAloneWeekdays() : this.formatData.getShortWeekdays();
        }
        return weekdays[value];
    }

    private String formatMonth(int count, int value, int maxIntCount, StringBuffer buffer, boolean useDateFormatSymbols2, boolean standalone) {
        String[] months;
        String current = null;
        if (useDateFormatSymbols2) {
            if (count == 4) {
                months = standalone ? this.formatData.getStandAloneMonths() : this.formatData.getMonths();
            } else if (count == 5) {
                months = standalone ? this.formatData.getTinyStandAloneMonths() : this.formatData.getTinyMonths();
            } else if (count == 3) {
                months = standalone ? this.formatData.getShortStandAloneMonths() : this.formatData.getShortMonths();
            } else {
                months = null;
            }
            if (months != null) {
                current = months[value];
            }
        } else if (count < 3) {
            current = null;
        }
        if (current == null) {
            zeroPaddingNumber(value + 1, count, maxIntCount, buffer);
        }
        return current;
    }

    private final void zeroPaddingNumber(int value, int minDigits, int maxDigits, StringBuffer buffer) {
        try {
            if (this.zeroDigit == 0) {
                this.zeroDigit = ((DecimalFormat) this.numberFormat).getDecimalFormatSymbols().getZeroDigit();
            }
            if (value >= 0) {
                if (value >= TAG_QUOTE_ASCII_CHAR || minDigits < 1 || minDigits > 2) {
                    if (value >= 1000 && value < 10000) {
                        if (minDigits == 4) {
                            buffer.append((char) (this.zeroDigit + (value / 1000)));
                            int value2 = value % 1000;
                            buffer.append((char) (this.zeroDigit + (value2 / TAG_QUOTE_ASCII_CHAR)));
                            int value3 = value2 % TAG_QUOTE_ASCII_CHAR;
                            buffer.append((char) (this.zeroDigit + (value3 / 10)));
                            buffer.append((char) (this.zeroDigit + (value3 % 10)));
                            return;
                        } else if (minDigits == 2 && maxDigits == 2) {
                            zeroPaddingNumber(value % TAG_QUOTE_ASCII_CHAR, 2, 2, buffer);
                            return;
                        }
                    }
                } else if (value < 10) {
                    if (minDigits == 2) {
                        buffer.append(this.zeroDigit);
                    }
                    buffer.append((char) (this.zeroDigit + value));
                    return;
                } else {
                    buffer.append((char) (this.zeroDigit + (value / 10)));
                    buffer.append((char) (this.zeroDigit + (value % 10)));
                    return;
                }
            }
        } catch (Exception e) {
        }
        this.numberFormat.setMinimumIntegerDigits(minDigits);
        this.numberFormat.setMaximumIntegerDigits(maxDigits);
        this.numberFormat.format((long) value, buffer, DontCareFieldPosition.INSTANCE);
    }

    public Date parse(String text, ParsePosition pos) {
        TimeZone tz = getTimeZone();
        try {
            return parseInternal(text, pos);
        } finally {
            setTimeZone(tz);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: char} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ca, code lost:
        if (r13 <= 0) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ce, code lost:
        if (r4 >= r20) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d0, code lost:
        r15 = r16 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00de, code lost:
        if (r22.charAt(r4) == r21.compiledPattern[r16]) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e0, code lost:
        r23.index = r18;
        r23.errorIndex = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00eb, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ec, code lost:
        r15 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f5, code lost:
        r15 = r16;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r12v0, types: [char] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Date parseInternal(java.lang.String r22, java.text.ParsePosition r23) {
        /*
            r21 = this;
            r21.checkNegativeNumberExpression()
            r0 = r23
            int r4 = r0.index
            r18 = r4
            int r20 = r22.length()
            r2 = 1
            boolean[] r8 = new boolean[r2]
            r2 = 0
            r3 = 0
            r8[r3] = r2
            java.text.CalendarBuilder r11 = new java.text.CalendarBuilder
            r11.<init>()
            r15 = 0
        L_0x001a:
            r0 = r21
            char[] r2 = r0.compiledPattern
            int r2 = r2.length
            if (r15 >= r2) goto L_0x0102
            r0 = r21
            char[] r2 = r0.compiledPattern
            char r2 = r2[r15]
            int r5 = r2 >>> 8
            r0 = r21
            char[] r2 = r0.compiledPattern
            int r16 = r15 + 1
            char r2 = r2[r15]
            r6 = r2 & 255(0xff, float:3.57E-43)
            r2 = 255(0xff, float:3.57E-43)
            if (r6 != r2) goto L_0x0143
            r0 = r21
            char[] r2 = r0.compiledPattern
            int r15 = r16 + 1
            char r2 = r2[r16]
            int r6 = r2 << 16
            r0 = r21
            char[] r2 = r0.compiledPattern
            int r16 = r15 + 1
            char r2 = r2[r15]
            r6 = r6 | r2
            r15 = r16
        L_0x004c:
            switch(r5) {
                case 100: goto L_0x00a8;
                case 101: goto L_0x00c5;
                default: goto L_0x004f;
            }
        L_0x004f:
            r7 = 0
            r10 = 0
            r0 = r21
            char[] r2 = r0.compiledPattern
            int r2 = r2.length
            if (r15 >= r2) goto L_0x0094
            r0 = r21
            char[] r2 = r0.compiledPattern
            char r2 = r2[r15]
            int r17 = r2 >>> 8
            r2 = 100
            r0 = r17
            if (r0 == r2) goto L_0x006d
            r2 = 101(0x65, float:1.42E-43)
            r0 = r17
            if (r0 == r2) goto L_0x006d
            r7 = 1
        L_0x006d:
            r0 = r21
            boolean r2 = r0.hasFollowingMinusSign
            if (r2 == 0) goto L_0x0094
            r2 = 100
            r0 = r17
            if (r0 == r2) goto L_0x007f
            r2 = 101(0x65, float:1.42E-43)
            r0 = r17
            if (r0 != r2) goto L_0x0094
        L_0x007f:
            r2 = 100
            r0 = r17
            if (r0 != r2) goto L_0x00f9
            r0 = r21
            char[] r2 = r0.compiledPattern
            char r2 = r2[r15]
            r12 = r2 & 255(0xff, float:3.57E-43)
        L_0x008d:
            r0 = r21
            char r2 = r0.minusSign
            if (r12 != r2) goto L_0x0094
            r10 = 1
        L_0x0094:
            r2 = r21
            r3 = r22
            r9 = r23
            int r4 = r2.subParse(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r4 >= 0) goto L_0x001a
            r0 = r18
            r1 = r23
            r1.index = r0
            r2 = 0
            return r2
        L_0x00a8:
            r0 = r20
            if (r4 >= r0) goto L_0x00b5
            r0 = r22
            char r2 = r0.charAt(r4)
            char r3 = (char) r6
            if (r2 == r3) goto L_0x00c1
        L_0x00b5:
            r0 = r18
            r1 = r23
            r1.index = r0
            r0 = r23
            r0.errorIndex = r4
            r2 = 0
            return r2
        L_0x00c1:
            int r4 = r4 + 1
            goto L_0x001a
        L_0x00c5:
            r13 = r6
            r16 = r15
        L_0x00c8:
            int r6 = r13 + -1
            if (r13 <= 0) goto L_0x00f5
            r0 = r20
            if (r4 >= r0) goto L_0x00ec
            r0 = r22
            char r2 = r0.charAt(r4)
            r0 = r21
            char[] r3 = r0.compiledPattern
            int r15 = r16 + 1
            char r3 = r3[r16]
            if (r2 == r3) goto L_0x00ef
        L_0x00e0:
            r0 = r18
            r1 = r23
            r1.index = r0
            r0 = r23
            r0.errorIndex = r4
            r2 = 0
            return r2
        L_0x00ec:
            r15 = r16
            goto L_0x00e0
        L_0x00ef:
            int r4 = r4 + 1
            r13 = r6
            r16 = r15
            goto L_0x00c8
        L_0x00f5:
            r15 = r16
            goto L_0x001a
        L_0x00f9:
            r0 = r21
            char[] r2 = r0.compiledPattern
            int r3 = r15 + 1
            char r12 = r2[r3]
            goto L_0x008d
        L_0x0102:
            r0 = r23
            r0.index = r4
            r0 = r21
            java.util.Calendar r2 = r0.calendar     // Catch:{ IllegalArgumentException -> 0x0136 }
            java.util.Calendar r2 = r11.establish(r2)     // Catch:{ IllegalArgumentException -> 0x0136 }
            java.util.Date r19 = r2.getTime()     // Catch:{ IllegalArgumentException -> 0x0136 }
            r2 = 0
            boolean r2 = r8[r2]     // Catch:{ IllegalArgumentException -> 0x0136 }
            if (r2 == 0) goto L_0x0135
            r0 = r21
            java.util.Date r2 = r0.defaultCenturyStart     // Catch:{ IllegalArgumentException -> 0x0136 }
            r0 = r19
            boolean r2 = r0.before(r2)     // Catch:{ IllegalArgumentException -> 0x0136 }
            if (r2 == 0) goto L_0x0135
            r2 = 100
            java.text.CalendarBuilder r2 = r11.addYear(r2)     // Catch:{ IllegalArgumentException -> 0x0136 }
            r0 = r21
            java.util.Calendar r3 = r0.calendar     // Catch:{ IllegalArgumentException -> 0x0136 }
            java.util.Calendar r2 = r2.establish(r3)     // Catch:{ IllegalArgumentException -> 0x0136 }
            java.util.Date r19 = r2.getTime()     // Catch:{ IllegalArgumentException -> 0x0136 }
        L_0x0135:
            return r19
        L_0x0136:
            r14 = move-exception
            r0 = r23
            r0.errorIndex = r4
            r0 = r18
            r1 = r23
            r1.index = r0
            r2 = 0
            return r2
        L_0x0143:
            r15 = r16
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.parseInternal(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private int matchString(String text, int start, int field, String[] data, CalendarBuilder calb) {
        int i = 0;
        int count = data.length;
        if (field == 7) {
            i = 1;
        }
        int bestMatchLength = 0;
        int bestMatch = -1;
        while (i < count) {
            int length = data[i].length();
            if (length > bestMatchLength) {
                if (text.regionMatches(true, start, data[i], 0, length)) {
                    bestMatch = i;
                    bestMatchLength = length;
                }
            }
            if (data[i].charAt(length - 1) == '.' && length - 1 > bestMatchLength) {
                if (text.regionMatches(true, start, data[i], 0, length - 1)) {
                    bestMatch = i;
                    bestMatchLength = length - 1;
                }
            }
            i++;
        }
        if (bestMatch < 0) {
            return -start;
        }
        calb.set(field, bestMatch);
        return start + bestMatchLength;
    }

    private int matchString(String text, int start, int field, Map<String, Integer> data, CalendarBuilder calb) {
        if (data != null) {
            String bestMatch = null;
            for (String name : data.keySet()) {
                int length = name.length();
                if ((bestMatch == null || length > bestMatch.length()) && text.regionMatches(true, start, name, 0, length)) {
                    bestMatch = name;
                }
            }
            if (bestMatch != null) {
                calb.set(field, data.get(bestMatch).intValue());
                return bestMatch.length() + start;
            }
        }
        return -start;
    }

    private int matchZoneString(String text, int start, String[] zoneNames) {
        for (int i = 1; i <= 4; i++) {
            String zoneName = zoneNames[i];
            if (text.regionMatches(true, start, zoneName, 0, zoneName.length())) {
                return i;
            }
        }
        return -1;
    }

    private boolean matchDSTString(String text, int start, int zoneIndex, int standardIndex, String[][] zoneStrings) {
        String zoneName = zoneStrings[zoneIndex][standardIndex + 2];
        if (text.regionMatches(true, start, zoneName, 0, zoneName.length())) {
            return true;
        }
        return f32assertionsDisabled;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        r8 = r9[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r8 = r9[r7];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int subParseZoneString(java.lang.String r13, int r14, java.text.CalendarBuilder r15) {
        /*
            r12 = this;
            r6 = 0
            java.util.TimeZone r0 = r12.getTimeZone()
            java.text.DateFormatSymbols r10 = r12.formatData
            java.lang.String r11 = r0.getID()
            int r7 = r10.getZoneIndex(r11)
            r5 = 0
            java.text.DateFormatSymbols r10 = r12.formatData
            java.lang.String[][] r9 = r10.getZoneStringsWrapper()
            r8 = 0
            r4 = 0
            r10 = -1
            if (r7 == r10) goto L_0x0037
            r8 = r9[r7]
            int r4 = r12.matchZoneString(r13, r14, r8)
            if (r4 <= 0) goto L_0x0037
            r10 = 2
            if (r4 > r10) goto L_0x0030
            r10 = r8[r4]
            int r11 = r4 + 2
            r11 = r8[r11]
            boolean r6 = r10.equalsIgnoreCase(r11)
        L_0x0030:
            r10 = 0
            r10 = r8[r10]
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r10)
        L_0x0037:
            if (r5 != 0) goto L_0x0066
            java.text.DateFormatSymbols r10 = r12.formatData
            java.util.TimeZone r11 = java.util.TimeZone.getDefault()
            java.lang.String r11 = r11.getID()
            int r7 = r10.getZoneIndex(r11)
            r10 = -1
            if (r7 == r10) goto L_0x0066
            r8 = r9[r7]
            int r4 = r12.matchZoneString(r13, r14, r8)
            if (r4 <= 0) goto L_0x0066
            r10 = 2
            if (r4 > r10) goto L_0x005f
            r10 = r8[r4]
            int r11 = r4 + 2
            r11 = r8[r11]
            boolean r6 = r10.equalsIgnoreCase(r11)
        L_0x005f:
            r10 = 0
            r10 = r8[r10]
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r10)
        L_0x0066:
            if (r5 != 0) goto L_0x0088
            int r3 = r9.length
            r2 = 0
        L_0x006a:
            if (r2 >= r3) goto L_0x0088
            r8 = r9[r2]
            int r4 = r12.matchZoneString(r13, r14, r8)
            if (r4 <= 0) goto L_0x00b7
            r10 = 2
            if (r4 > r10) goto L_0x0081
            r10 = r8[r4]
            int r11 = r4 + 2
            r11 = r8[r11]
            boolean r6 = r10.equalsIgnoreCase(r11)
        L_0x0081:
            r10 = 0
            r10 = r8[r10]
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r10)
        L_0x0088:
            if (r5 == 0) goto L_0x00be
            boolean r10 = r5.equals(r0)
            if (r10 != 0) goto L_0x0093
            r12.setTimeZone(r5)
        L_0x0093:
            r10 = 3
            if (r4 < r10) goto L_0x00ba
            int r1 = r5.getDSTSavings()
        L_0x009a:
            if (r6 != 0) goto L_0x00a1
            r10 = 3
            if (r4 < r10) goto L_0x00bc
            if (r1 != 0) goto L_0x00bc
        L_0x00a1:
            r10 = 1
        L_0x00a2:
            if (r10 != 0) goto L_0x00af
            r10 = 15
            java.text.CalendarBuilder r10 = r15.clear(r10)
            r11 = 16
            r10.set(r11, r1)
        L_0x00af:
            r10 = r8[r4]
            int r10 = r10.length()
            int r10 = r10 + r14
            return r10
        L_0x00b7:
            int r2 = r2 + 1
            goto L_0x006a
        L_0x00ba:
            r1 = 0
            goto L_0x009a
        L_0x00bc:
            r10 = 0
            goto L_0x00a2
        L_0x00be:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.subParseZoneString(java.lang.String, int, java.text.CalendarBuilder):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (r5 <= 59) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int subParseNumericZone(java.lang.String r10, int r11, int r12, int r13, boolean r14, java.text.CalendarBuilder r15) {
        /*
            r9 = this;
            r3 = r11
            int r3 = r11 + 1
            char r0 = r10.charAt(r11)     // Catch:{ IndexOutOfBoundsException -> 0x007b }
            boolean r6 = r9.isDigit(r0)     // Catch:{ IndexOutOfBoundsException -> 0x007b }
            if (r6 != 0) goto L_0x0010
        L_0x000d:
            int r6 = 1 - r3
            return r6
        L_0x0010:
            int r2 = r0 + -48
            int r4 = r3 + 1
            char r0 = r10.charAt(r3)     // Catch:{ IndexOutOfBoundsException -> 0x007d }
            boolean r6 = r9.isDigit(r0)     // Catch:{ IndexOutOfBoundsException -> 0x007d }
            if (r6 == 0) goto L_0x002a
            int r6 = r2 * 10
            int r7 = r0 + -48
            int r2 = r6 + r7
        L_0x0024:
            r6 = 23
            if (r2 <= r6) goto L_0x002e
            r3 = r4
            goto L_0x000d
        L_0x002a:
            int r3 = r4 + -1
            r4 = r3
            goto L_0x0024
        L_0x002e:
            r5 = 0
            r6 = 1
            if (r13 == r6) goto L_0x0080
            int r3 = r4 + 1
            char r0 = r10.charAt(r4)     // Catch:{ IndexOutOfBoundsException -> 0x007b }
            r6 = 58
            if (r0 != r6) goto L_0x004a
            int r4 = r3 + 1
            char r0 = r10.charAt(r3)     // Catch:{ IndexOutOfBoundsException -> 0x007d }
        L_0x0042:
            boolean r6 = r9.isDigit(r0)     // Catch:{ IndexOutOfBoundsException -> 0x007d }
            if (r6 != 0) goto L_0x004e
            r3 = r4
            goto L_0x000d
        L_0x004a:
            if (r14 != 0) goto L_0x000d
            r4 = r3
            goto L_0x0042
        L_0x004e:
            int r5 = r0 + -48
            int r3 = r4 + 1
            char r0 = r10.charAt(r4)     // Catch:{ IndexOutOfBoundsException -> 0x007b }
            boolean r6 = r9.isDigit(r0)     // Catch:{ IndexOutOfBoundsException -> 0x007b }
            if (r6 == 0) goto L_0x000d
            int r6 = r5 * 10
            int r7 = r0 + -48
            int r5 = r6 + r7
            r6 = 59
            if (r5 > r6) goto L_0x000d
        L_0x0066:
            int r6 = r2 * 60
            int r5 = r5 + r6
            r6 = 60000(0xea60, float:8.4078E-41)
            int r6 = r6 * r5
            int r6 = r6 * r12
            r7 = 15
            java.text.CalendarBuilder r6 = r15.set(r7, r6)     // Catch:{ IndexOutOfBoundsException -> 0x007b }
            r7 = 16
            r8 = 0
            r6.set(r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x007b }
            return r3
        L_0x007b:
            r1 = move-exception
            goto L_0x000d
        L_0x007d:
            r1 = move-exception
            r3 = r4
            goto L_0x000d
        L_0x0080:
            r3 = r4
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.subParseNumericZone(java.lang.String, int, int, int, boolean, java.text.CalendarBuilder):int");
    }

    private boolean isDigit(char c) {
        if (c < '0' || c > '9') {
            return f32assertionsDisabled;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:225:0x047d, code lost:
        if (r43.charAt(r15.index - 1) == r42.minusSign) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e3, code lost:
        if (r43.charAt(r15.index) != r42.minusSign) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e5, code lost:
        r12 = -r12;
        r15.index--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0112, code lost:
        if ((r42.calendar instanceof java.util.GregorianCalendar) == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013d, code lost:
        if (r43.charAt(r15.index) != r42.minusSign) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x013f, code lost:
        r12 = -r12;
        r15.index--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015e, code lost:
        if (r43.charAt(r15.index - 1) == r42.minusSign) goto L_0x013f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0388 A[Catch:{ IndexOutOfBoundsException -> 0x03a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int subParse(java.lang.String r43, int r44, int r45, int r46, boolean r47, boolean[] r48, java.text.ParsePosition r49, boolean r50, java.text.CalendarBuilder r51) {
        /*
            r42 = this;
            r38 = 0
            r12 = 0
            java.text.ParsePosition r15 = new java.text.ParsePosition
            r4 = 0
            r15.<init>(r4)
            r0 = r44
            r15.index = r0
            r4 = 19
            r0 = r45
            if (r0 != r4) goto L_0x001d
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            boolean r4 = r4.isWeekDateSupported()
            if (r4 == 0) goto L_0x0031
        L_0x001d:
            int[] r4 = PATTERN_INDEX_TO_CALENDAR_FIELD
            r7 = r4[r45]
        L_0x0021:
            int r4 = r15.index
            int r5 = r43.length()
            if (r4 < r5) goto L_0x0034
            r0 = r44
            r1 = r49
            r1.errorIndex = r0
            r4 = -1
            return r4
        L_0x0031:
            r45 = 1
            goto L_0x001d
        L_0x0034:
            int r4 = r15.index
            r0 = r43
            char r29 = r0.charAt(r4)
            r4 = 32
            r0 = r29
            if (r0 == r4) goto L_0x0065
            r4 = 9
            r0 = r29
            if (r0 == r4) goto L_0x0065
            r4 = 4
            r0 = r45
            if (r0 == r4) goto L_0x0053
            r4 = 15
            r0 = r45
            if (r0 != r4) goto L_0x006c
        L_0x0053:
            if (r47 == 0) goto L_0x0116
            int r4 = r44 + r46
            int r5 = r43.length()
            if (r4 <= r5) goto L_0x00f4
        L_0x005d:
            int r4 = r15.index
            r0 = r49
            r0.errorIndex = r4
            r4 = -1
            return r4
        L_0x0065:
            int r4 = r15.index
            int r4 = r4 + 1
            r15.index = r4
            goto L_0x0021
        L_0x006c:
            r4 = 2
            r0 = r45
            if (r0 != r4) goto L_0x0076
            r4 = 2
            r0 = r46
            if (r0 <= r4) goto L_0x0053
        L_0x0076:
            r4 = 1
            r0 = r45
            if (r0 == r4) goto L_0x0053
            r4 = 19
            r0 = r45
            if (r0 == r4) goto L_0x0053
        L_0x0081:
            boolean r16 = r42.useDateFormatSymbols()
            switch(r45) {
                case 0: goto L_0x0161;
                case 1: goto L_0x0197;
                case 2: goto L_0x0232;
                case 3: goto L_0x0088;
                case 4: goto L_0x0246;
                case 5: goto L_0x0088;
                case 6: goto L_0x0088;
                case 7: goto L_0x0088;
                case 8: goto L_0x0088;
                case 9: goto L_0x0281;
                case 10: goto L_0x0088;
                case 11: goto L_0x0088;
                case 12: goto L_0x0088;
                case 13: goto L_0x0088;
                case 14: goto L_0x0296;
                case 15: goto L_0x02cd;
                case 16: goto L_0x0088;
                case 17: goto L_0x02f3;
                case 18: goto L_0x02f3;
                case 19: goto L_0x0197;
                case 20: goto L_0x0088;
                case 21: goto L_0x03e5;
                case 22: goto L_0x021e;
                case 23: goto L_0x026c;
                default: goto L_0x0088;
            }
        L_0x0088:
            int r39 = r15.getIndex()
            if (r47 == 0) goto L_0x0455
            int r4 = r44 + r46
            int r5 = r43.length()
            if (r4 > r5) goto L_0x005d
            r0 = r42
            java.text.NumberFormat r4 = r0.numberFormat
            int r5 = r44 + r46
            r6 = 0
            r0 = r43
            java.lang.String r5 = r0.substring(r6, r5)
            java.lang.Number r38 = r4.parse(r5, r15)
        L_0x00a7:
            if (r38 == 0) goto L_0x005d
            r4 = 8
            r0 = r45
            if (r0 != r4) goto L_0x0461
            double r32 = r38.doubleValue()
            int r4 = r15.getIndex()
            int r41 = r4 - r39
            r4 = 4621819117588971520(0x4024000000000000, double:10.0)
            r0 = r41
            double r10 = (double) r0
            double r30 = java.lang.Math.pow(r4, r10)
            double r4 = r32 / r30
            r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r4 = r4 * r10
            int r12 = (int) r4
        L_0x00cb:
            if (r50 == 0) goto L_0x00ec
            if (r12 >= 0) goto L_0x00ec
            int r4 = r15.index
            int r5 = r43.length()
            if (r4 >= r5) goto L_0x0467
            int r4 = r15.index
            r0 = r43
            char r4 = r0.charAt(r4)
            r0 = r42
            char r5 = r0.minusSign
            if (r4 == r5) goto L_0x0467
        L_0x00e5:
            int r12 = -r12
            int r4 = r15.index
            int r4 = r4 + -1
            r15.index = r4
        L_0x00ec:
            r0 = r51
            r0.set(r7, r12)
            int r4 = r15.index
            return r4
        L_0x00f4:
            r0 = r42
            java.text.NumberFormat r4 = r0.numberFormat
            int r5 = r44 + r46
            r6 = 0
            r0 = r43
            java.lang.String r5 = r0.substring(r6, r5)
            java.lang.Number r38 = r4.parse(r5, r15)
        L_0x0105:
            if (r38 != 0) goto L_0x0121
            r4 = 1
            r0 = r45
            if (r0 != r4) goto L_0x005d
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            boolean r4 = r4 instanceof java.util.GregorianCalendar
            if (r4 == 0) goto L_0x0081
            goto L_0x005d
        L_0x0116:
            r0 = r42
            java.text.NumberFormat r4 = r0.numberFormat
            r0 = r43
            java.lang.Number r38 = r4.parse(r0, r15)
            goto L_0x0105
        L_0x0121:
            int r12 = r38.intValue()
            if (r50 == 0) goto L_0x0081
            if (r12 >= 0) goto L_0x0081
            int r4 = r15.index
            int r5 = r43.length()
            if (r4 >= r5) goto L_0x0148
            int r4 = r15.index
            r0 = r43
            char r4 = r0.charAt(r4)
            r0 = r42
            char r5 = r0.minusSign
            if (r4 == r5) goto L_0x0148
        L_0x013f:
            int r12 = -r12
            int r4 = r15.index
            int r4 = r4 + -1
            r15.index = r4
            goto L_0x0081
        L_0x0148:
            int r4 = r15.index
            int r5 = r43.length()
            if (r4 != r5) goto L_0x0081
            int r4 = r15.index
            int r4 = r4 + -1
            r0 = r43
            char r4 = r0.charAt(r4)
            r0 = r42
            char r5 = r0.minusSign
            if (r4 != r5) goto L_0x0081
            goto L_0x013f
        L_0x0161:
            if (r16 == 0) goto L_0x017b
            r0 = r42
            java.text.DateFormatSymbols r4 = r0.formatData
            java.lang.String[] r8 = r4.getEras()
            r7 = 0
            r4 = r42
            r5 = r43
            r6 = r44
            r9 = r51
            int r37 = r4.matchString((java.lang.String) r5, (int) r6, (int) r7, (java.lang.String[]) r8, (java.text.CalendarBuilder) r9)
            if (r37 <= 0) goto L_0x005d
            return r37
        L_0x017b:
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            r0 = r42
            java.util.Locale r5 = r0.locale
            r6 = 0
            java.util.Map r8 = r4.getDisplayNames(r7, r6, r5)
            r4 = r42
            r5 = r43
            r6 = r44
            r9 = r51
            int r37 = r4.matchString((java.lang.String) r5, (int) r6, (int) r7, (java.util.Map<java.lang.String, java.lang.Integer>) r8, (java.text.CalendarBuilder) r9)
            if (r37 <= 0) goto L_0x005d
            return r37
        L_0x0197:
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            boolean r4 = r4 instanceof java.util.GregorianCalendar
            if (r4 != 0) goto L_0x01d0
            r4 = 4
            r0 = r46
            if (r0 < r4) goto L_0x01c5
            r40 = 2
        L_0x01a6:
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            r0 = r42
            java.util.Locale r5 = r0.locale
            r0 = r40
            java.util.Map r8 = r4.getDisplayNames(r7, r0, r5)
            if (r8 == 0) goto L_0x01c8
            r4 = r42
            r5 = r43
            r6 = r44
            r9 = r51
            int r37 = r4.matchString((java.lang.String) r5, (int) r6, (int) r7, (java.util.Map<java.lang.String, java.lang.Integer>) r8, (java.text.CalendarBuilder) r9)
            if (r37 <= 0) goto L_0x01c8
            return r37
        L_0x01c5:
            r40 = 1
            goto L_0x01a6
        L_0x01c8:
            r0 = r51
            r0.set(r7, r12)
            int r4 = r15.index
            return r4
        L_0x01d0:
            r4 = 2
            r0 = r46
            if (r0 > r4) goto L_0x0212
            int r4 = r15.index
            int r4 = r4 - r44
            r5 = 2
            if (r4 != r5) goto L_0x0212
            char r4 = r43.charAt(r44)
            boolean r4 = java.lang.Character.isDigit((char) r4)
            if (r4 == 0) goto L_0x0212
            int r4 = r44 + 1
            r0 = r43
            char r4 = r0.charAt(r4)
            boolean r4 = java.lang.Character.isDigit((char) r4)
            if (r4 == 0) goto L_0x0212
            r0 = r42
            int r4 = r0.defaultCenturyStartYear
            int r28 = r4 % 100
            r0 = r28
            if (r12 != r0) goto L_0x021a
            r4 = 1
        L_0x01ff:
            r5 = 0
            r48[r5] = r4
            r0 = r42
            int r4 = r0.defaultCenturyStartYear
            int r4 = r4 / 100
            int r5 = r4 * 100
            r0 = r28
            if (r12 >= r0) goto L_0x021c
            r4 = 100
        L_0x0210:
            int r4 = r4 + r5
            int r12 = r12 + r4
        L_0x0212:
            r0 = r51
            r0.set(r7, r12)
            int r4 = r15.index
            return r4
        L_0x021a:
            r4 = 0
            goto L_0x01ff
        L_0x021c:
            r4 = 0
            goto L_0x0210
        L_0x021e:
            r17 = 1
            r9 = r42
            r10 = r43
            r11 = r46
            r13 = r44
            r14 = r7
            r18 = r51
            int r36 = r9.parseMonth(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            if (r36 <= 0) goto L_0x005d
            return r36
        L_0x0232:
            r17 = 0
            r9 = r42
            r10 = r43
            r11 = r46
            r13 = r44
            r14 = r7
            r18 = r51
            int r36 = r9.parseMonth(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            if (r36 <= 0) goto L_0x005d
            return r36
        L_0x0246:
            boolean r4 = r42.isLenient()
            if (r4 != 0) goto L_0x0253
            r4 = 1
            if (r12 < r4) goto L_0x005d
            r4 = 24
            if (r12 > r4) goto L_0x005d
        L_0x0253:
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            r5 = 11
            int r4 = r4.getMaximum(r5)
            int r4 = r4 + 1
            if (r12 != r4) goto L_0x0262
            r12 = 0
        L_0x0262:
            r4 = 11
            r0 = r51
            r0.set(r4, r12)
            int r4 = r15.index
            return r4
        L_0x026c:
            r22 = 1
            r17 = r42
            r18 = r43
            r19 = r44
            r20 = r7
            r21 = r16
            r23 = r51
            int r36 = r17.parseWeekday(r18, r19, r20, r21, r22, r23)
            if (r36 <= 0) goto L_0x005d
            return r36
        L_0x0281:
            r22 = 0
            r17 = r42
            r18 = r43
            r19 = r44
            r20 = r7
            r21 = r16
            r23 = r51
            int r36 = r17.parseWeekday(r18, r19, r20, r21, r22, r23)
            if (r36 <= 0) goto L_0x005d
            return r36
        L_0x0296:
            if (r16 == 0) goto L_0x02b1
            r0 = r42
            java.text.DateFormatSymbols r4 = r0.formatData
            java.lang.String[] r21 = r4.getAmPmStrings()
            r20 = 9
            r17 = r42
            r18 = r43
            r19 = r44
            r22 = r51
            int r37 = r17.matchString((java.lang.String) r18, (int) r19, (int) r20, (java.lang.String[]) r21, (java.text.CalendarBuilder) r22)
            if (r37 <= 0) goto L_0x005d
            return r37
        L_0x02b1:
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            r0 = r42
            java.util.Locale r5 = r0.locale
            r6 = 0
            java.util.Map r8 = r4.getDisplayNames(r7, r6, r5)
            r4 = r42
            r5 = r43
            r6 = r44
            r9 = r51
            int r37 = r4.matchString((java.lang.String) r5, (int) r6, (int) r7, (java.util.Map<java.lang.String, java.lang.Integer>) r8, (java.text.CalendarBuilder) r9)
            if (r37 <= 0) goto L_0x005d
            return r37
        L_0x02cd:
            boolean r4 = r42.isLenient()
            if (r4 != 0) goto L_0x02da
            r4 = 1
            if (r12 < r4) goto L_0x005d
            r4 = 12
            if (r12 > r4) goto L_0x005d
        L_0x02da:
            r0 = r42
            java.util.Calendar r4 = r0.calendar
            r5 = 10
            int r4 = r4.getLeastMaximum(r5)
            int r4 = r4 + 1
            if (r12 != r4) goto L_0x02e9
            r12 = 0
        L_0x02e9:
            r4 = 10
            r0 = r51
            r0.set(r4, r12)
            int r4 = r15.index
            return r4
        L_0x02f3:
            r20 = 0
            int r4 = r15.index     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            r0 = r43
            char r29 = r0.charAt(r4)     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            r4 = 43
            r0 = r29
            if (r0 != r4) goto L_0x0374
            r20 = 1
            r24 = r20
        L_0x0307:
            if (r24 != 0) goto L_0x03c3
            r4 = 71
            r0 = r29
            if (r0 == r4) goto L_0x0315
            r4 = 103(0x67, float:1.44E-43)
            r0 = r29
            if (r0 != r4) goto L_0x03ab
        L_0x0315:
            int r4 = r43.length()     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            int r4 = r4 - r44
            java.lang.String r5 = "GMT"
            int r5 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            if (r4 < r5) goto L_0x03ab
            java.lang.String r20 = "GMT"
            java.lang.String r4 = "GMT"
            int r22 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            r18 = 1
            r21 = 0
            r17 = r43
            r19 = r44
            boolean r4 = r17.regionMatches(r18, r19, r20, r21, r22)     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            if (r4 == 0) goto L_0x03ab
            java.lang.String r4 = "GMT"
            int r4 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            int r4 = r4 + r44
            r15.index = r4     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            int r4 = r43.length()     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            int r5 = r15.index     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            int r4 = r4 - r5
            if (r4 <= 0) goto L_0x0486
            int r4 = r15.index     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            r0 = r43
            char r29 = r0.charAt(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            r4 = 43
            r0 = r29
            if (r0 != r4) goto L_0x037f
            r20 = 1
        L_0x0360:
            if (r20 != 0) goto L_0x0388
            r4 = 15
            r5 = 0
            r0 = r51
            java.text.CalendarBuilder r4 = r0.set(r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            r5 = 16
            r6 = 0
            r4.set(r5, r6)     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            int r4 = r15.index     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            return r4
        L_0x0374:
            r4 = 45
            r0 = r29
            if (r0 != r4) goto L_0x048a
            r20 = -1
            r24 = r20
            goto L_0x0307
        L_0x037f:
            r4 = 45
            r0 = r29
            if (r0 != r4) goto L_0x0486
            r20 = -1
            goto L_0x0360
        L_0x0388:
            int r4 = r15.index     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            int r19 = r4 + 1
            r0 = r19
            r15.index = r0     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            r21 = 0
            r22 = 0
            r17 = r42
            r18 = r43
            r23 = r51
            int r35 = r17.subParseNumericZone(r18, r19, r20, r21, r22, r23)     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            if (r35 <= 0) goto L_0x03a1
            return r35
        L_0x03a1:
            r0 = r35
            int r4 = -r0
            r15.index = r4     // Catch:{ IndexOutOfBoundsException -> 0x03a8 }
            goto L_0x005d
        L_0x03a8:
            r34 = move-exception
            goto L_0x005d
        L_0x03ab:
            int r4 = r15.index     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            r0 = r42
            r1 = r43
            r2 = r51
            int r35 = r0.subParseZoneString(r1, r4, r2)     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            if (r35 <= 0) goto L_0x03ba
            return r35
        L_0x03ba:
            r0 = r35
            int r4 = -r0
            r15.index = r4     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            r20 = r24
            goto L_0x005d
        L_0x03c3:
            int r4 = r15.index     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            int r23 = r4 + 1
            r0 = r23
            r15.index = r0     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            r25 = 0
            r26 = 0
            r21 = r42
            r22 = r43
            r27 = r51
            int r35 = r21.subParseNumericZone(r22, r23, r24, r25, r26, r27)     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            if (r35 <= 0) goto L_0x03dc
            return r35
        L_0x03dc:
            r0 = r35
            int r4 = -r0
            r15.index = r4     // Catch:{ IndexOutOfBoundsException -> 0x0481 }
            r20 = r24
            goto L_0x005d
        L_0x03e5:
            int r4 = r43.length()
            int r5 = r15.index
            int r4 = r4 - r5
            if (r4 <= 0) goto L_0x005d
            r20 = 0
            int r4 = r15.index
            r0 = r43
            char r29 = r0.charAt(r4)
            r4 = 90
            r0 = r29
            if (r0 != r4) goto L_0x0414
            r4 = 15
            r5 = 0
            r0 = r51
            java.text.CalendarBuilder r4 = r0.set(r4, r5)
            r5 = 16
            r6 = 0
            r4.set(r5, r6)
            int r4 = r15.index
            int r4 = r4 + 1
            r15.index = r4
            return r4
        L_0x0414:
            r4 = 43
            r0 = r29
            if (r0 != r4) goto L_0x043a
            r20 = 1
        L_0x041c:
            int r4 = r15.index
            int r19 = r4 + 1
            r0 = r19
            r15.index = r0
            r4 = 3
            r0 = r46
            if (r0 != r4) goto L_0x044b
            r22 = 1
        L_0x042b:
            r17 = r42
            r18 = r43
            r21 = r46
            r23 = r51
            int r35 = r17.subParseNumericZone(r18, r19, r20, r21, r22, r23)
            if (r35 <= 0) goto L_0x044e
            return r35
        L_0x043a:
            r4 = 45
            r0 = r29
            if (r0 != r4) goto L_0x0443
            r20 = -1
            goto L_0x041c
        L_0x0443:
            int r4 = r15.index
            int r4 = r4 + 1
            r15.index = r4
            goto L_0x005d
        L_0x044b:
            r22 = 0
            goto L_0x042b
        L_0x044e:
            r0 = r35
            int r4 = -r0
            r15.index = r4
            goto L_0x005d
        L_0x0455:
            r0 = r42
            java.text.NumberFormat r4 = r0.numberFormat
            r0 = r43
            java.lang.Number r38 = r4.parse(r0, r15)
            goto L_0x00a7
        L_0x0461:
            int r12 = r38.intValue()
            goto L_0x00cb
        L_0x0467:
            int r4 = r15.index
            int r5 = r43.length()
            if (r4 != r5) goto L_0x00ec
            int r4 = r15.index
            int r4 = r4 + -1
            r0 = r43
            char r4 = r0.charAt(r4)
            r0 = r42
            char r5 = r0.minusSign
            if (r4 != r5) goto L_0x00ec
            goto L_0x00e5
        L_0x0481:
            r34 = move-exception
            r20 = r24
            goto L_0x005d
        L_0x0486:
            r20 = r24
            goto L_0x0360
        L_0x048a:
            r24 = r20
            goto L_0x0307
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.subParse(java.lang.String, int, int, int, boolean, boolean[], java.text.ParsePosition, boolean, java.text.CalendarBuilder):int");
    }

    private int parseMonth(String text, int count, int value, int start, int field, ParsePosition pos, boolean useDateFormatSymbols2, boolean standalone, CalendarBuilder out) {
        int index;
        if (count <= 2) {
            out.set(2, value - 1);
            return pos.index;
        }
        if (useDateFormatSymbols2) {
            int index2 = matchString(text, start, 2, standalone ? this.formatData.getStandAloneMonths() : this.formatData.getMonths(), out);
            if (index2 > 0) {
                return index2;
            }
            index = matchString(text, start, 2, standalone ? this.formatData.getShortStandAloneMonths() : this.formatData.getShortMonths(), out);
            if (index > 0) {
                return index;
            }
        } else {
            index = matchString(text, start, field, this.calendar.getDisplayNames(field, 0, this.locale), out);
            if (index > 0) {
                return index;
            }
        }
        return index;
    }

    private int parseWeekday(String text, int start, int field, boolean useDateFormatSymbols2, boolean standalone, CalendarBuilder out) {
        int index = -1;
        if (useDateFormatSymbols2) {
            int index2 = matchString(text, start, 7, standalone ? this.formatData.getStandAloneWeekdays() : this.formatData.getWeekdays(), out);
            if (index2 > 0) {
                return index2;
            }
            index = matchString(text, start, 7, standalone ? this.formatData.getShortStandAloneWeekdays() : this.formatData.getShortWeekdays(), out);
            if (index > 0) {
                return index;
            }
        } else {
            for (int style : new int[]{2, 1}) {
                index = matchString(text, start, field, this.calendar.getDisplayNames(field, style, this.locale), out);
                if (index > 0) {
                    return index;
                }
            }
        }
        return index;
    }

    private final String getCalendarName() {
        return this.calendar.getClass().getName();
    }

    private boolean useDateFormatSymbols() {
        if (!this.useDateFormatSymbols && !isGregorianCalendar() && this.locale != null) {
            return f32assertionsDisabled;
        }
        return true;
    }

    private boolean isGregorianCalendar() {
        return "java.util.GregorianCalendar".equals(getCalendarName());
    }

    private String translatePattern(String pattern2, String from, String to) {
        StringBuilder result = new StringBuilder();
        boolean inQuote = f32assertionsDisabled;
        for (int i = 0; i < pattern2.length(); i++) {
            char c = pattern2.charAt(i);
            if (inQuote) {
                if (c == '\'') {
                    inQuote = f32assertionsDisabled;
                }
            } else if (c == '\'') {
                inQuote = true;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                int ci = from.indexOf((int) c);
                if (ci < 0) {
                    throw new IllegalArgumentException("Illegal pattern  character '" + c + "'");
                } else if (ci < to.length()) {
                    c = to.charAt(ci);
                }
            }
            result.append(c);
        }
        if (!inQuote) {
            return result.toString();
        }
        throw new IllegalArgumentException("Unfinished quote in pattern");
    }

    public String toPattern() {
        return this.pattern;
    }

    public String toLocalizedPattern() {
        return translatePattern(this.pattern, "GyMdkHmsSEDFwWahKzZYuXLc", this.formatData.getLocalPatternChars());
    }

    public void applyPattern(String pattern2) {
        this.compiledPattern = compile(pattern2);
        this.pattern = pattern2;
    }

    public void applyLocalizedPattern(String pattern2) {
        String p = translatePattern(pattern2, this.formatData.getLocalPatternChars(), "GyMdkHmsSEDFwWahKzZYuXLc");
        this.compiledPattern = compile(p);
        this.pattern = p;
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return (DateFormatSymbols) this.formatData.clone();
    }

    public void setDateFormatSymbols(DateFormatSymbols newFormatSymbols) {
        this.formatData = (DateFormatSymbols) newFormatSymbols.clone();
        this.useDateFormatSymbols = true;
    }

    public Object clone() {
        SimpleDateFormat other = (SimpleDateFormat) super.clone();
        other.formatData = (DateFormatSymbols) this.formatData.clone();
        return other;
    }

    public int hashCode() {
        return this.pattern.hashCode();
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return f32assertionsDisabled;
        }
        SimpleDateFormat that = (SimpleDateFormat) obj;
        if (this.pattern.equals(that.pattern)) {
            return this.formatData.equals(that.formatData);
        }
        return f32assertionsDisabled;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r1 = r2.getID();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readObject(java.io.ObjectInputStream r7) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r6 = this;
            r5 = 1
            r7.defaultReadObject()
            java.lang.String r4 = r6.pattern     // Catch:{ Exception -> 0x003b }
            char[] r4 = r6.compile(r4)     // Catch:{ Exception -> 0x003b }
            r6.compiledPattern = r4     // Catch:{ Exception -> 0x003b }
            int r4 = r6.serialVersionOnStream
            if (r4 >= r5) goto L_0x0045
            r6.initializeDefaultCentury()
        L_0x0013:
            r6.serialVersionOnStream = r5
            java.util.TimeZone r2 = r6.getTimeZone()
            boolean r4 = r2 instanceof java.util.SimpleTimeZone
            if (r4 == 0) goto L_0x003a
            java.lang.String r1 = r2.getID()
            java.util.TimeZone r3 = java.util.TimeZone.getTimeZone(r1)
            if (r3 == 0) goto L_0x003a
            boolean r4 = r3.hasSameRules(r2)
            if (r4 == 0) goto L_0x003a
            java.lang.String r4 = r3.getID()
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x003a
            r6.setTimeZone(r3)
        L_0x003a:
            return
        L_0x003b:
            r0 = move-exception
            java.io.InvalidObjectException r4 = new java.io.InvalidObjectException
            java.lang.String r5 = "invalid pattern"
            r4.<init>(r5)
            throw r4
        L_0x0045:
            java.util.Date r4 = r6.defaultCenturyStart
            r6.parseAmbiguousDatesAsAfter(r4)
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.readObject(java.io.ObjectInputStream):void");
    }

    private void checkNegativeNumberExpression() {
        int minusIndex;
        if ((this.numberFormat instanceof DecimalFormat) && !this.numberFormat.equals(this.originalNumberFormat)) {
            String numberPattern = ((DecimalFormat) this.numberFormat).toPattern();
            if (!numberPattern.equals(this.originalNumberPattern)) {
                this.hasFollowingMinusSign = f32assertionsDisabled;
                int separatorIndex = numberPattern.indexOf(59);
                if (separatorIndex > -1 && (minusIndex = numberPattern.indexOf(45, separatorIndex)) > numberPattern.lastIndexOf(48) && minusIndex > numberPattern.lastIndexOf(35)) {
                    this.hasFollowingMinusSign = true;
                    this.minusSign = ((DecimalFormat) this.numberFormat).getDecimalFormatSymbols().getMinusSign();
                }
                this.originalNumberPattern = numberPattern;
            }
            this.originalNumberFormat = this.numberFormat;
        }
    }
}
