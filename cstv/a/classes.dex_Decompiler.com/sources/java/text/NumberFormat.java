package java.text;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.Format;
import java.text.spi.NumberFormatProvider;
import java.util.Currency;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import libcore.icu.LocaleData;
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
public abstract class NumberFormat extends Format {
    private static final int CURRENCYSTYLE = 1;
    public static final int FRACTION_FIELD = 1;
    private static final int INTEGERSTYLE = 3;
    public static final int INTEGER_FIELD = 0;
    private static final int NUMBERSTYLE = 0;
    private static final int PERCENTSTYLE = 2;
    private static final Hashtable cachedLocaleData = null;
    static final int currentSerialVersion = 1;
    static final long serialVersionUID = -2308460125733713944L;
    private boolean groupingUsed;
    private byte maxFractionDigits;
    private byte maxIntegerDigits;
    private int maximumFractionDigits;
    private int maximumIntegerDigits;
    private byte minFractionDigits;
    private byte minIntegerDigits;
    private int minimumFractionDigits;
    private int minimumIntegerDigits;
    private boolean parseIntegerOnly;
    private int serialVersionOnStream;

    public static class Field extends Format.Field {
        public static final Field CURRENCY = null;
        public static final Field DECIMAL_SEPARATOR = null;
        public static final Field EXPONENT = null;
        public static final Field EXPONENT_SIGN = null;
        public static final Field EXPONENT_SYMBOL = null;
        public static final Field FRACTION = null;
        public static final Field GROUPING_SEPARATOR = null;
        public static final Field INTEGER = null;
        public static final Field PERCENT = null;
        public static final Field PERMILLE = null;
        public static final Field SIGN = null;
        private static final Map instanceMap = null;
        private static final long serialVersionUID = 7494728892700160890L;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.Field.<init>(java.lang.String):void, dex: classes.dex
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
        protected Field(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.Field.<init>(java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.NumberFormat.Field.<init>(java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.Field.readResolve():java.lang.Object, dex: classes.dex
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
        protected java.lang.Object readResolve() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.Field.readResolve():java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.NumberFormat.Field.readResolve():java.lang.Object");
        }
    }

    private static class NumberFormatGetter implements LocaleServiceProviderPool.LocalizedObjectGetter<NumberFormatProvider, NumberFormat> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f31assertionsDisabled = false;
        /* access modifiers changed from: private */
        public static final NumberFormatGetter INSTANCE = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.NumberFormatGetter.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.NumberFormatGetter.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.NumberFormat.NumberFormatGetter.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.text.NumberFormat.NumberFormatGetter.<init>():void, dex: classes.dex
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
        private NumberFormatGetter() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.text.NumberFormat.NumberFormatGetter.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.NumberFormat.NumberFormatGetter.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.NumberFormatGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object, dex: classes.dex
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
        public /* bridge */ /* synthetic */ java.lang.Object getObject(java.lang.Object r1, java.util.Locale r2, java.lang.String r3, java.lang.Object[] r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.NumberFormatGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.NumberFormat.NumberFormatGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.NumberFormatGetter.getObject(java.text.spi.NumberFormatProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.NumberFormat, dex: classes.dex
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
        public java.text.NumberFormat getObject(java.text.spi.NumberFormatProvider r1, java.util.Locale r2, java.lang.String r3, java.lang.Object... r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.NumberFormat.NumberFormatGetter.getObject(java.text.spi.NumberFormatProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.NumberFormat, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.NumberFormat.NumberFormatGetter.getObject(java.text.spi.NumberFormatProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.NumberFormat");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.text.NumberFormat.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.text.NumberFormat.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.NumberFormat.<clinit>():void");
    }

    public abstract StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract Number parse(String str, ParsePosition parsePosition);

    protected NumberFormat() {
        this.groupingUsed = true;
        this.maxIntegerDigits = 40;
        this.minIntegerDigits = 1;
        this.maxFractionDigits = 3;
        this.minFractionDigits = 0;
        this.parseIntegerOnly = false;
        this.maximumIntegerDigits = 40;
        this.minimumIntegerDigits = 1;
        this.maximumFractionDigits = 3;
        this.minimumFractionDigits = 0;
        this.serialVersionOnStream = 1;
    }

    public StringBuffer format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
        if ((number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte) || (number instanceof AtomicInteger) || (number instanceof AtomicLong) || ((number instanceof BigInteger) && ((BigInteger) number).bitLength() < 64)) {
            return format(((Number) number).longValue(), toAppendTo, pos);
        }
        if (number instanceof Number) {
            return format(((Number) number).doubleValue(), toAppendTo, pos);
        }
        throw new IllegalArgumentException("Cannot format given Object as a Number");
    }

    public final Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }

    public final String format(double number) {
        return format(number, new StringBuffer(), DontCareFieldPosition.INSTANCE).toString();
    }

    public final String format(long number) {
        return format(number, new StringBuffer(), DontCareFieldPosition.INSTANCE).toString();
    }

    public Number parse(String source) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Number result = parse(source, parsePosition);
        if (parsePosition.index != 0) {
            return result;
        }
        throw new ParseException("Unparseable number: \"" + source + "\"", parsePosition.errorIndex);
    }

    public boolean isParseIntegerOnly() {
        return this.parseIntegerOnly;
    }

    public void setParseIntegerOnly(boolean value) {
        this.parseIntegerOnly = value;
    }

    public static final NumberFormat getInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), 0);
    }

    public static NumberFormat getInstance(Locale inLocale) {
        return getInstance(inLocale, 0);
    }

    public static final NumberFormat getNumberInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), 0);
    }

    public static NumberFormat getNumberInstance(Locale inLocale) {
        return getInstance(inLocale, 0);
    }

    public static final NumberFormat getIntegerInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), 3);
    }

    public static NumberFormat getIntegerInstance(Locale inLocale) {
        return getInstance(inLocale, 3);
    }

    public static final NumberFormat getCurrencyInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), 1);
    }

    public static NumberFormat getCurrencyInstance(Locale inLocale) {
        return getInstance(inLocale, 1);
    }

    public static final NumberFormat getPercentInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), 2);
    }

    public static NumberFormat getPercentInstance(Locale inLocale) {
        return getInstance(inLocale, 2);
    }

    public static Locale[] getAvailableLocales() {
        return LocaleServiceProviderPool.getPool(NumberFormatProvider.class).getAvailableLocales();
    }

    public int hashCode() {
        return (this.maximumIntegerDigits * 37) + this.maxFractionDigits;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NumberFormat other = (NumberFormat) obj;
        if (this.maximumIntegerDigits != other.maximumIntegerDigits || this.minimumIntegerDigits != other.minimumIntegerDigits || this.maximumFractionDigits != other.maximumFractionDigits || this.minimumFractionDigits != other.minimumFractionDigits || this.groupingUsed != other.groupingUsed) {
            return false;
        }
        if (this.parseIntegerOnly == other.parseIntegerOnly) {
            return true;
        }
        return false;
    }

    public Object clone() {
        return (NumberFormat) super.clone();
    }

    public boolean isGroupingUsed() {
        return this.groupingUsed;
    }

    public void setGroupingUsed(boolean newValue) {
        this.groupingUsed = newValue;
    }

    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    public void setMaximumIntegerDigits(int newValue) {
        this.maximumIntegerDigits = Math.max(0, newValue);
        if (this.minimumIntegerDigits > this.maximumIntegerDigits) {
            this.minimumIntegerDigits = this.maximumIntegerDigits;
        }
    }

    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    public void setMinimumIntegerDigits(int newValue) {
        this.minimumIntegerDigits = Math.max(0, newValue);
        if (this.minimumIntegerDigits > this.maximumIntegerDigits) {
            this.maximumIntegerDigits = this.minimumIntegerDigits;
        }
    }

    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    public void setMaximumFractionDigits(int newValue) {
        this.maximumFractionDigits = Math.max(0, newValue);
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.minimumFractionDigits = this.maximumFractionDigits;
        }
    }

    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    public void setMinimumFractionDigits(int newValue) {
        this.minimumFractionDigits = Math.max(0, newValue);
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.maximumFractionDigits = this.minimumFractionDigits;
        }
    }

    public Currency getCurrency() {
        throw new UnsupportedOperationException();
    }

    public void setCurrency(Currency currency) {
        throw new UnsupportedOperationException();
    }

    public RoundingMode getRoundingMode() {
        throw new UnsupportedOperationException();
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        throw new UnsupportedOperationException();
    }

    private static NumberFormat getInstance(Locale desiredLocale, int choice) {
        LocaleServiceProviderPool pool = LocaleServiceProviderPool.getPool(NumberFormatProvider.class);
        if (pool.hasProviders()) {
            NumberFormat providersInstance = (NumberFormat) pool.getLocalizedObject(NumberFormatGetter.INSTANCE, desiredLocale, Integer.valueOf(choice));
            if (providersInstance != null) {
                return providersInstance;
            }
        }
        String[] numberPatterns = (String[]) cachedLocaleData.get(desiredLocale);
        if (numberPatterns == null) {
            LocaleData data = LocaleData.get(desiredLocale);
            numberPatterns = new String[]{data.numberPattern, data.currencyPattern, data.percentPattern, data.integerPattern};
            cachedLocaleData.put(desiredLocale, numberPatterns);
        }
        DecimalFormat format = new DecimalFormat(numberPatterns[choice == 3 ? 0 : choice], DecimalFormatSymbols.getInstance(desiredLocale));
        if (choice == 3) {
            format.setMaximumFractionDigits(0);
            format.setDecimalSeparatorAlwaysShown(false);
            format.setParseIntegerOnly(true);
        } else if (choice == 1) {
            format.adjustForCurrencyDefaultFractionDigits();
        }
        return format;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            this.maximumIntegerDigits = this.maxIntegerDigits;
            this.minimumIntegerDigits = this.minIntegerDigits;
            this.maximumFractionDigits = this.maxFractionDigits;
            this.minimumFractionDigits = this.minFractionDigits;
        }
        if (this.minimumIntegerDigits > this.maximumIntegerDigits || this.minimumFractionDigits > this.maximumFractionDigits || this.minimumIntegerDigits < 0 || this.minimumFractionDigits < 0) {
            throw new InvalidObjectException("Digit count range invalid");
        }
        this.serialVersionOnStream = 1;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        byte b;
        byte b2;
        byte b3;
        byte b4 = Byte.MAX_VALUE;
        if (this.maximumIntegerDigits > 127) {
            b = Byte.MAX_VALUE;
        } else {
            b = (byte) this.maximumIntegerDigits;
        }
        this.maxIntegerDigits = b;
        if (this.minimumIntegerDigits > 127) {
            b2 = Byte.MAX_VALUE;
        } else {
            b2 = (byte) this.minimumIntegerDigits;
        }
        this.minIntegerDigits = b2;
        if (this.maximumFractionDigits > 127) {
            b3 = Byte.MAX_VALUE;
        } else {
            b3 = (byte) this.maximumFractionDigits;
        }
        this.maxFractionDigits = b3;
        if (this.minimumFractionDigits <= 127) {
            b4 = (byte) this.minimumFractionDigits;
        }
        this.minFractionDigits = b4;
        stream.defaultWriteObject();
    }
}
