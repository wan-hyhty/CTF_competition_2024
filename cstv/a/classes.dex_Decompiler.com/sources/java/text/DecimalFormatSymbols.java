package java.text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.spi.DecimalFormatSymbolsProvider;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
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
public class DecimalFormatSymbols implements Cloneable, Serializable {
    private static final ConcurrentHashMap<Locale, Object[]> cachedLocaleData = null;
    private static final int currentSerialVersion = 3;
    private static final ObjectStreamField[] serialPersistentFields = null;
    static final long serialVersionUID = 5772796243397350300L;
    private String NaN;
    private transient android.icu.text.DecimalFormatSymbols cachedIcuDFS;
    private transient Currency currency;
    private String currencySymbol;
    private char decimalSeparator;
    private char digit;
    private char exponential;
    private String exponentialSeparator;
    private char groupingSeparator;
    private String infinity;
    private String intlCurrencySymbol;
    private Locale locale;
    private char minusSign;
    private char monetarySeparator;
    private char patternSeparator;
    private char perMill;
    private char percent;
    private int serialVersionOnStream;
    private char zeroDigit;

    private static class DecimalFormatSymbolsGetter implements LocaleServiceProviderPool.LocalizedObjectGetter<DecimalFormatSymbolsProvider, DecimalFormatSymbols> {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f28assertionsDisabled = false;
        /* access modifiers changed from: private */
        public static final DecimalFormatSymbolsGetter INSTANCE = null;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.<clinit>():void, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.<init>():void, dex: classes.dex
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
        private DecimalFormatSymbolsGetter() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object, dex: classes.dex
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
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.getObject(java.lang.Object, java.util.Locale, java.lang.String, java.lang.Object[]):java.lang.Object");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.getObject(java.text.spi.DecimalFormatSymbolsProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.DecimalFormatSymbols, dex: classes.dex
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
        public java.text.DecimalFormatSymbols getObject(java.text.spi.DecimalFormatSymbolsProvider r1, java.util.Locale r2, java.lang.String r3, java.lang.Object... r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.getObject(java.text.spi.DecimalFormatSymbolsProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.DecimalFormatSymbols, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.text.DecimalFormatSymbols.DecimalFormatSymbolsGetter.getObject(java.text.spi.DecimalFormatSymbolsProvider, java.util.Locale, java.lang.String, java.lang.Object[]):java.text.DecimalFormatSymbols");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.text.DecimalFormatSymbols.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.text.DecimalFormatSymbols.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.DecimalFormatSymbols.<clinit>():void");
    }

    public DecimalFormatSymbols() {
        this.serialVersionOnStream = 3;
        this.cachedIcuDFS = null;
        initialize(Locale.getDefault(Locale.Category.FORMAT));
    }

    public DecimalFormatSymbols(Locale locale2) {
        this.serialVersionOnStream = 3;
        this.cachedIcuDFS = null;
        initialize(locale2);
    }

    public static Locale[] getAvailableLocales() {
        return LocaleServiceProviderPool.getPool(DecimalFormatSymbolsProvider.class).getAvailableLocales();
    }

    public static final DecimalFormatSymbols getInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT));
    }

    public static final DecimalFormatSymbols getInstance(Locale locale2) {
        DecimalFormatSymbols providersInstance;
        LocaleServiceProviderPool pool = LocaleServiceProviderPool.getPool(DecimalFormatSymbolsProvider.class);
        if (!pool.hasProviders() || (providersInstance = (DecimalFormatSymbols) pool.getLocalizedObject(DecimalFormatSymbolsGetter.INSTANCE, locale2, new Object[0])) == null) {
            return new DecimalFormatSymbols(locale2);
        }
        return providersInstance;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public void setZeroDigit(char zeroDigit2) {
        this.zeroDigit = zeroDigit2;
        this.cachedIcuDFS = null;
    }

    public char getGroupingSeparator() {
        return this.groupingSeparator;
    }

    public void setGroupingSeparator(char groupingSeparator2) {
        this.groupingSeparator = groupingSeparator2;
        this.cachedIcuDFS = null;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public void setDecimalSeparator(char decimalSeparator2) {
        this.decimalSeparator = decimalSeparator2;
        this.cachedIcuDFS = null;
    }

    public char getPerMill() {
        return this.perMill;
    }

    public void setPerMill(char perMill2) {
        this.perMill = perMill2;
        this.cachedIcuDFS = null;
    }

    public char getPercent() {
        return this.percent;
    }

    public String getPercentString() {
        return String.valueOf(this.percent);
    }

    public void setPercent(char percent2) {
        this.percent = percent2;
        this.cachedIcuDFS = null;
    }

    public char getDigit() {
        return this.digit;
    }

    public void setDigit(char digit2) {
        this.digit = digit2;
        this.cachedIcuDFS = null;
    }

    public char getPatternSeparator() {
        return this.patternSeparator;
    }

    public void setPatternSeparator(char patternSeparator2) {
        this.patternSeparator = patternSeparator2;
        this.cachedIcuDFS = null;
    }

    public String getInfinity() {
        return this.infinity;
    }

    public void setInfinity(String infinity2) {
        this.infinity = infinity2;
        this.cachedIcuDFS = null;
    }

    public String getNaN() {
        return this.NaN;
    }

    public void setNaN(String NaN2) {
        this.NaN = NaN2;
        this.cachedIcuDFS = null;
    }

    public char getMinusSign() {
        return this.minusSign;
    }

    public String getMinusSignString() {
        return String.valueOf(this.minusSign);
    }

    public void setMinusSign(char minusSign2) {
        this.minusSign = minusSign2;
        this.cachedIcuDFS = null;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String currency2) {
        this.currencySymbol = currency2;
        this.cachedIcuDFS = null;
    }

    public String getInternationalCurrencySymbol() {
        return this.intlCurrencySymbol;
    }

    public void setInternationalCurrencySymbol(String currencyCode) {
        this.intlCurrencySymbol = currencyCode;
        this.currency = null;
        if (currencyCode != null) {
            try {
                this.currency = Currency.getInstance(currencyCode);
                this.currencySymbol = this.currency.getSymbol(this.locale);
            } catch (IllegalArgumentException e) {
            }
        }
        this.cachedIcuDFS = null;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency2) {
        if (currency2 == null) {
            throw new NullPointerException();
        }
        this.currency = currency2;
        this.intlCurrencySymbol = currency2.getCurrencyCode();
        this.currencySymbol = currency2.getSymbol(this.locale);
        this.cachedIcuDFS = null;
    }

    public char getMonetaryDecimalSeparator() {
        return this.monetarySeparator;
    }

    public void setMonetaryDecimalSeparator(char sep) {
        this.monetarySeparator = sep;
        this.cachedIcuDFS = null;
    }

    /* access modifiers changed from: package-private */
    public char getExponentialSymbol() {
        return this.exponential;
    }

    public String getExponentSeparator() {
        return this.exponentialSeparator;
    }

    /* access modifiers changed from: package-private */
    public void setExponentialSymbol(char exp) {
        this.exponential = exp;
        this.cachedIcuDFS = null;
    }

    public void setExponentSeparator(String exp) {
        if (exp == null) {
            throw new NullPointerException();
        }
        this.exponentialSeparator = exp;
    }

    public Object clone() {
        try {
            return (DecimalFormatSymbols) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
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
        DecimalFormatSymbols other = (DecimalFormatSymbols) obj;
        if (this.zeroDigit == other.zeroDigit && this.groupingSeparator == other.groupingSeparator && this.decimalSeparator == other.decimalSeparator && this.percent == other.percent && this.perMill == other.perMill && this.digit == other.digit && this.minusSign == other.minusSign && this.patternSeparator == other.patternSeparator && this.infinity.equals(other.infinity) && this.NaN.equals(other.NaN) && this.currencySymbol.equals(other.currencySymbol) && this.intlCurrencySymbol.equals(other.intlCurrencySymbol) && this.currency == other.currency && this.monetarySeparator == other.monetarySeparator && this.exponentialSeparator.equals(other.exponentialSeparator)) {
            return this.locale.equals(other.locale);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.zeroDigit * 37) + this.groupingSeparator) * 37) + this.decimalSeparator) * 37) + this.percent) * 37) + this.perMill) * 37) + this.digit) * 37) + this.minusSign) * 37) + this.patternSeparator) * 37) + this.infinity.hashCode()) * 37) + this.NaN.hashCode()) * 37) + this.currencySymbol.hashCode()) * 37) + this.intlCurrencySymbol.hashCode()) * 37) + this.currency.hashCode()) * 37) + this.monetarySeparator) * 37) + this.exponentialSeparator.hashCode()) * 37) + this.locale.hashCode();
    }

    private void initialize(Locale locale2) {
        this.locale = locale2;
        boolean needCacheUpdate = false;
        Object[] data = cachedLocaleData.get(locale2);
        Object[] data2 = data;
        if (data == null) {
            locale2 = LocaleData.mapInvalidAndNullLocales(locale2);
            LocaleData localeData = LocaleData.get(locale2);
            Object[] data3 = new Object[3];
            data3[0] = new String[]{String.valueOf(localeData.decimalSeparator), String.valueOf(localeData.groupingSeparator), String.valueOf(localeData.patternSeparator), String.valueOf((Object) localeData.percent), String.valueOf(localeData.zeroDigit), "#", localeData.minusSign, localeData.exponentSeparator, String.valueOf(localeData.perMill), localeData.infinity, localeData.NaN};
            needCacheUpdate = true;
            data2 = data3;
        }
        String[] numberElements = (String[]) data2[0];
        this.decimalSeparator = numberElements[0].charAt(0);
        this.groupingSeparator = numberElements[1].charAt(0);
        this.patternSeparator = numberElements[2].charAt(0);
        this.percent = maybeStripMarkers(numberElements[3], '%');
        this.zeroDigit = numberElements[4].charAt(0);
        this.digit = numberElements[5].charAt(0);
        this.minusSign = maybeStripMarkers(numberElements[6], '-');
        this.exponential = numberElements[7].charAt(0);
        this.exponentialSeparator = numberElements[7];
        this.perMill = numberElements[8].charAt(0);
        this.infinity = numberElements[9];
        this.NaN = numberElements[10];
        if (!"".equals(locale2.getCountry())) {
            try {
                this.currency = Currency.getInstance(locale2);
            } catch (IllegalArgumentException e) {
            }
        }
        if (this.currency != null) {
            this.intlCurrencySymbol = this.currency.getCurrencyCode();
            if (data2[1] == null || data2[1] != this.intlCurrencySymbol) {
                this.currencySymbol = this.currency.getSymbol(locale2);
                data2[1] = this.intlCurrencySymbol;
                data2[2] = this.currencySymbol;
                needCacheUpdate = true;
            } else {
                this.currencySymbol = (String) data2[2];
            }
        } else {
            this.intlCurrencySymbol = "XXX";
            try {
                this.currency = Currency.getInstance(this.intlCurrencySymbol);
            } catch (IllegalArgumentException e2) {
            }
            this.currencySymbol = "¤";
        }
        this.monetarySeparator = this.decimalSeparator;
        if (needCacheUpdate) {
            cachedLocaleData.putIfAbsent(locale2, data2);
        }
    }

    private static char maybeStripMarkers(String symbol, char fallback) {
        int length = symbol.length();
        if (length == 1) {
            return symbol.charAt(0);
        }
        if (length != 2) {
            return fallback;
        }
        char first = symbol.charAt(0);
        if (first == 8206 || first == 8207 || first == 1564) {
        }
        return symbol.charAt(1);
    }

    /* access modifiers changed from: protected */
    public android.icu.text.DecimalFormatSymbols getIcuDecimalFormatSymbols() {
        if (this.cachedIcuDFS != null) {
            return this.cachedIcuDFS;
        }
        this.cachedIcuDFS = new android.icu.text.DecimalFormatSymbols(this.locale);
        this.cachedIcuDFS.setZeroDigit(this.zeroDigit);
        this.cachedIcuDFS.setDigit(this.digit);
        this.cachedIcuDFS.setDecimalSeparator(this.decimalSeparator);
        this.cachedIcuDFS.setGroupingSeparator(this.groupingSeparator);
        this.cachedIcuDFS.setPatternSeparator(this.patternSeparator);
        this.cachedIcuDFS.setPercent(this.percent);
        this.cachedIcuDFS.setMonetaryDecimalSeparator(this.monetarySeparator);
        this.cachedIcuDFS.setMinusSign(this.minusSign);
        this.cachedIcuDFS.setInfinity(this.infinity);
        this.cachedIcuDFS.setNaN(this.NaN);
        this.cachedIcuDFS.setExponentSeparator(this.exponentialSeparator);
        try {
            this.cachedIcuDFS.setCurrency(android.icu.util.Currency.getInstance(this.currency.getCurrencyCode()));
        } catch (NullPointerException e) {
            this.currency = Currency.getInstance("XXX");
        }
        this.cachedIcuDFS.setCurrencySymbol(this.currencySymbol);
        this.cachedIcuDFS.setInternationalCurrencySymbol(this.intlCurrencySymbol);
        return this.cachedIcuDFS;
    }

    protected static DecimalFormatSymbols fromIcuInstance(android.icu.text.DecimalFormatSymbols dfs) {
        DecimalFormatSymbols result = new DecimalFormatSymbols(dfs.getLocale());
        result.setZeroDigit(dfs.getZeroDigit());
        result.setDigit(dfs.getDigit());
        result.setDecimalSeparator(dfs.getDecimalSeparator());
        result.setGroupingSeparator(dfs.getGroupingSeparator());
        result.setPatternSeparator(dfs.getPatternSeparator());
        result.setPercent(dfs.getPercent());
        result.setPerMill(dfs.getPerMill());
        result.setMonetaryDecimalSeparator(dfs.getMonetaryDecimalSeparator());
        result.setMinusSign(dfs.getMinusSign());
        result.setInfinity(dfs.getInfinity());
        result.setNaN(dfs.getNaN());
        result.setExponentSeparator(dfs.getExponentSeparator());
        try {
            if (dfs.getCurrency() != null) {
                result.setCurrency(Currency.getInstance(dfs.getCurrency().getCurrencyCode()));
            } else {
                result.setCurrency(Currency.getInstance("XXX"));
            }
        } catch (IllegalArgumentException e) {
            result.setCurrency(Currency.getInstance("XXX"));
        }
        result.setInternationalCurrencySymbol(dfs.getInternationalCurrencySymbol());
        result.setCurrencySymbol(dfs.getCurrencySymbol());
        return result;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("currencySymbol", (Object) this.currencySymbol);
        fields.put("decimalSeparator", getDecimalSeparator());
        fields.put("digit", getDigit());
        fields.put("exponential", this.exponentialSeparator.charAt(0));
        fields.put("exponentialSeparator", (Object) this.exponentialSeparator);
        fields.put("groupingSeparator", getGroupingSeparator());
        fields.put("infinity", (Object) this.infinity);
        fields.put("intlCurrencySymbol", (Object) this.intlCurrencySymbol);
        fields.put("monetarySeparator", getMonetaryDecimalSeparator());
        fields.put("NaN", (Object) this.NaN);
        fields.put("patternSeparator", getPatternSeparator());
        fields.put("perMill", getPerMill());
        fields.put("serialVersionOnStream", 3);
        fields.put("zeroDigit", getZeroDigit());
        fields.put("locale", (Object) this.locale);
        fields.put("minusSign", this.minusSign);
        fields.put("percent", this.percent);
        fields.put("minusSignStr", (Object) getMinusSignString());
        fields.put("percentStr", (Object) getPercentString());
        stream.writeFields();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        int serialVersionOnStream2 = fields.get("serialVersionOnStream", 0);
        this.currencySymbol = (String) fields.get("currencySymbol", (Object) "");
        setDecimalSeparator(fields.get("decimalSeparator", '.'));
        setDigit(fields.get("digit", '#'));
        setGroupingSeparator(fields.get("groupingSeparator", ','));
        this.infinity = (String) fields.get("infinity", (Object) "");
        this.intlCurrencySymbol = (String) fields.get("intlCurrencySymbol", (Object) "");
        this.NaN = (String) fields.get("NaN", (Object) "");
        setPatternSeparator(fields.get("patternSeparator", ';'));
        String minusSignStr = (String) fields.get("minusSignStr", (Object) null);
        if (minusSignStr != null) {
            this.minusSign = minusSignStr.charAt(0);
        } else {
            setMinusSign(fields.get("minusSign", '-'));
        }
        String percentStr = (String) fields.get("percentStr", (Object) null);
        if (percentStr != null) {
            this.percent = percentStr.charAt(0);
        } else {
            setPercent(fields.get("percent", '%'));
        }
        setPerMill(fields.get("perMill", 8240));
        setZeroDigit(fields.get("zeroDigit", '0'));
        this.locale = (Locale) fields.get("locale", (Object) null);
        if (serialVersionOnStream2 == 0) {
            setMonetaryDecimalSeparator(getDecimalSeparator());
        } else {
            setMonetaryDecimalSeparator(fields.get("monetarySeparator", '.'));
        }
        if (serialVersionOnStream2 == 0) {
            this.exponentialSeparator = "E";
        } else if (serialVersionOnStream2 < 3) {
            setExponentSeparator(String.valueOf(fields.get("exponential", 'E')));
        } else {
            setExponentSeparator((String) fields.get("exponentialSeparator", (Object) "E"));
        }
        try {
            this.currency = Currency.getInstance(this.intlCurrencySymbol);
        } catch (IllegalArgumentException e) {
            this.currency = null;
        }
    }
}
