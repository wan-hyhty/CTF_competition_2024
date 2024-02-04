package java.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.icu.TimeZoneNames;
import libcore.io.IoUtils;
import libcore.util.ZoneInfoDB;
import org.apache.harmony.luni.internal.util.TimezoneGetter;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public abstract class TimeZone implements Serializable, Cloneable {
    private static final TimeZone GMT = null;
    public static final int LONG = 1;
    static final TimeZone NO_TIMEZONE = null;
    public static final int SHORT = 0;
    private static final TimeZone UTC = null;
    private static volatile TimeZone defaultTimeZone = null;
    static final long serialVersionUID = 3581463369166924961L;
    private String ID;

    private static class NoImagePreloadHolder {
        public static final Pattern CUSTOM_ZONE_ID_PATTERN = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.TimeZone.NoImagePreloadHolder.<init>():void, dex: classes.dex
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
        private NoImagePreloadHolder() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.TimeZone.NoImagePreloadHolder.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.TimeZone.NoImagePreloadHolder.<init>():void");
        }
    }

    private static native String getSystemGMTOffsetID();

    private static native String getSystemTimeZoneID(String str, String str2);

    public abstract int getOffset(int i, int i2, int i3, int i4, int i5, int i6);

    public abstract int getRawOffset();

    public abstract boolean inDaylightTime(Date date);

    public abstract void setRawOffset(int i);

    public abstract boolean useDaylightTime();

    public int getOffset(long date) {
        if (inDaylightTime(new Date(date))) {
            return getRawOffset() + getDSTSavings();
        }
        return getRawOffset();
    }

    /* access modifiers changed from: package-private */
    public int getOffsets(long date, int[] offsets) {
        int rawoffset = getRawOffset();
        int dstoffset = 0;
        if (inDaylightTime(new Date(date))) {
            dstoffset = getDSTSavings();
        }
        if (offsets != null) {
            offsets[0] = rawoffset;
            offsets[1] = dstoffset;
        }
        return rawoffset + dstoffset;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID2) {
        if (ID2 == null) {
            throw new NullPointerException();
        }
        this.ID = ID2;
    }

    public final String getDisplayName() {
        return getDisplayName(false, 1, Locale.getDefault(Locale.Category.DISPLAY));
    }

    public final String getDisplayName(Locale locale) {
        return getDisplayName(false, 1, locale);
    }

    public final String getDisplayName(boolean daylight, int style) {
        return getDisplayName(daylight, style, Locale.getDefault(Locale.Category.DISPLAY));
    }

    public String getDisplayName(boolean daylightTime, int style, Locale locale) {
        if (style == 0 || style == 1) {
            String result = TimeZoneNames.getDisplayName(TimeZoneNames.getZoneStrings(locale), getID(), daylightTime, style);
            if (result != null) {
                return result;
            }
            int offsetMillis = getRawOffset();
            if (daylightTime) {
                offsetMillis += getDSTSavings();
            }
            return createGmtOffsetString(true, true, offsetMillis);
        }
        throw new IllegalArgumentException("Bad style: " + style);
    }

    public static String createGmtOffsetString(boolean includeGmt, boolean includeMinuteSeparator, int offsetMillis) {
        int offsetMinutes = offsetMillis / 60000;
        char sign = '+';
        if (offsetMinutes < 0) {
            sign = '-';
            offsetMinutes = -offsetMinutes;
        }
        StringBuilder builder = new StringBuilder(9);
        if (includeGmt) {
            builder.append("GMT");
        }
        builder.append(sign);
        appendNumber(builder, 2, offsetMinutes / 60);
        if (includeMinuteSeparator) {
            builder.append(':');
        }
        appendNumber(builder, 2, offsetMinutes % 60);
        return builder.toString();
    }

    private static void appendNumber(StringBuilder builder, int count, int value) {
        String string = Integer.toString(value);
        for (int i = 0; i < count - string.length(); i++) {
            builder.append('0');
        }
        builder.append(string);
    }

    public int getDSTSavings() {
        if (useDaylightTime()) {
            return 3600000;
        }
        return 0;
    }

    public boolean observesDaylightTime() {
        if (!useDaylightTime()) {
            return inDaylightTime(new Date());
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.TimeZone getTimeZone(java.lang.String r5) {
        /*
            r4 = 3
            java.lang.Class<java.util.TimeZone> r3 = java.util.TimeZone.class
            monitor-enter(r3)
            if (r5 != 0) goto L_0x0012
            java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ all -> 0x000f }
            java.lang.String r4 = "id == null"
            r2.<init>(r4)     // Catch:{ all -> 0x000f }
            throw r2     // Catch:{ all -> 0x000f }
        L_0x000f:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        L_0x0012:
            int r2 = r5.length()     // Catch:{ all -> 0x000f }
            if (r2 != r4) goto L_0x003e
            java.lang.String r2 = "GMT"
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x000f }
            if (r2 == 0) goto L_0x002b
            java.util.TimeZone r2 = GMT     // Catch:{ all -> 0x000f }
            java.lang.Object r2 = r2.clone()     // Catch:{ all -> 0x000f }
            java.util.TimeZone r2 = (java.util.TimeZone) r2     // Catch:{ all -> 0x000f }
            monitor-exit(r3)
            return r2
        L_0x002b:
            java.lang.String r2 = "UTC"
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x000f }
            if (r2 == 0) goto L_0x003e
            java.util.TimeZone r2 = UTC     // Catch:{ all -> 0x000f }
            java.lang.Object r2 = r2.clone()     // Catch:{ all -> 0x000f }
            java.util.TimeZone r2 = (java.util.TimeZone) r2     // Catch:{ all -> 0x000f }
            monitor-exit(r3)
            return r2
        L_0x003e:
            r1 = 0
            libcore.util.ZoneInfoDB$TzData r2 = libcore.util.ZoneInfoDB.getInstance()     // Catch:{ IOException -> 0x006a }
            libcore.util.ZoneInfo r1 = r2.makeTimeZone(r5)     // Catch:{ IOException -> 0x006a }
        L_0x0047:
            if (r1 != 0) goto L_0x005c
            int r2 = r5.length()     // Catch:{ all -> 0x000f }
            if (r2 <= r4) goto L_0x005c
            java.lang.String r2 = "GMT"
            boolean r2 = r5.startsWith(r2)     // Catch:{ all -> 0x000f }
            if (r2 == 0) goto L_0x005c
            java.util.TimeZone r1 = getCustomTimeZone(r5)     // Catch:{ all -> 0x000f }
        L_0x005c:
            if (r1 == 0) goto L_0x0060
        L_0x005e:
            monitor-exit(r3)
            return r1
        L_0x0060:
            java.util.TimeZone r2 = GMT     // Catch:{ all -> 0x000f }
            java.lang.Object r2 = r2.clone()     // Catch:{ all -> 0x000f }
            java.util.TimeZone r2 = (java.util.TimeZone) r2     // Catch:{ all -> 0x000f }
            r1 = r2
            goto L_0x005e
        L_0x006a:
            r0 = move-exception
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimeZone.getTimeZone(java.lang.String):java.util.TimeZone");
    }

    private static TimeZone getCustomTimeZone(String id) {
        Matcher m = NoImagePreloadHolder.CUSTOM_ZONE_ID_PATTERN.matcher(id);
        if (!m.matches()) {
            return null;
        }
        int minute = 0;
        try {
            int hour = Integer.parseInt(m.group(1));
            if (m.group(3) != null) {
                minute = Integer.parseInt(m.group(3));
            }
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                return null;
            }
            char sign = id.charAt(3);
            int raw = (3600000 * hour) + (60000 * minute);
            if (sign == '-') {
                raw = -raw;
            }
            return new SimpleTimeZone(raw, String.format(Locale.ROOT, "GMT%c%02d:%02d", Character.valueOf(sign), Integer.valueOf(hour), Integer.valueOf(minute)));
        } catch (NumberFormatException impossible) {
            throw new AssertionError((Object) impossible);
        }
    }

    public static synchronized String[] getAvailableIDs(int rawOffset) {
        String[] availableIDs;
        synchronized (TimeZone.class) {
            availableIDs = ZoneInfoDB.getInstance().getAvailableIDs(rawOffset);
        }
        return availableIDs;
    }

    public static synchronized String[] getAvailableIDs() {
        String[] availableIDs;
        synchronized (TimeZone.class) {
            availableIDs = ZoneInfoDB.getInstance().getAvailableIDs();
        }
        return availableIDs;
    }

    public static TimeZone getDefault() {
        return (TimeZone) getDefaultRef().clone();
    }

    static synchronized TimeZone getDefaultRef() {
        TimeZone timeZone;
        synchronized (TimeZone.class) {
            if (defaultTimeZone == null) {
                TimezoneGetter tzGetter = TimezoneGetter.getInstance();
                String id = tzGetter != null ? tzGetter.getId() : null;
                if (id != null) {
                    id = id.trim();
                }
                if (id == null || id.isEmpty()) {
                    try {
                        id = IoUtils.readFileAsString("/etc/timezone");
                    } catch (IOException e) {
                        id = "GMT";
                    }
                }
                defaultTimeZone = getTimeZone(id);
            }
            timeZone = defaultTimeZone;
        }
        return timeZone;
    }

    private static boolean hasPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            return true;
        }
        try {
            sm.checkPermission(new PropertyPermission("user.timezone", "write"));
            return true;
        } catch (SecurityException e) {
            return false;
        }
    }

    public static synchronized void setDefault(TimeZone timeZone) {
        TimeZone timeZone2 = null;
        synchronized (TimeZone.class) {
            if (hasPermission()) {
                if (timeZone != null) {
                    timeZone2 = (TimeZone) timeZone.clone();
                }
                defaultTimeZone = timeZone2;
                android.icu.util.TimeZone.clearCachedDefault();
            }
        }
    }

    public boolean hasSameRules(TimeZone other) {
        if (other != null && getRawOffset() == other.getRawOffset() && useDaylightTime() == other.useDaylightTime()) {
            return true;
        }
        return false;
    }

    public Object clone() {
        try {
            TimeZone other = (TimeZone) super.clone();
            other.ID = this.ID;
            return other;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
