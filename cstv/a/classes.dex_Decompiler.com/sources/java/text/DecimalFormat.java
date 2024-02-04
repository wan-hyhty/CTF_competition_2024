package java.text;

import android.icu.text.NumberFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import libcore.icu.LocaleData;
import sun.util.locale.LanguageTag;

public class DecimalFormat extends NumberFormat {

    /* renamed from: -java-math-RoundingModeSwitchesValues  reason: not valid java name */
    private static final /* synthetic */ int[] f27javamathRoundingModeSwitchesValues = null;
    static final int DOUBLE_FRACTION_DIGITS = 340;
    static final int DOUBLE_INTEGER_DIGITS = 309;
    static final int MAXIMUM_FRACTION_DIGITS = Integer.MAX_VALUE;
    static final int MAXIMUM_INTEGER_DIGITS = Integer.MAX_VALUE;
    private static final ConcurrentMap<Locale, String> cachedLocaleData = null;
    private static final int currentSerialVersion = 4;
    private static final ObjectStreamField[] serialPersistentFields = null;
    static final long serialVersionUID = 864413376551465018L;
    private transient android.icu.text.DecimalFormat icuDecimalFormat;
    private int maximumFractionDigits;
    private int maximumIntegerDigits;
    private int minimumFractionDigits;
    private int minimumIntegerDigits;
    private RoundingMode roundingMode;
    private DecimalFormatSymbols symbols;

    /* renamed from: -getjava-math-RoundingModeSwitchesValues  reason: not valid java name */
    private static /* synthetic */ int[] m186getjavamathRoundingModeSwitchesValues() {
        if (f27javamathRoundingModeSwitchesValues != null) {
            return f27javamathRoundingModeSwitchesValues;
        }
        int[] iArr = new int[RoundingMode.values().length];
        try {
            iArr[RoundingMode.CEILING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            iArr[RoundingMode.DOWN.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            iArr[RoundingMode.FLOOR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            iArr[RoundingMode.HALF_DOWN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            iArr[RoundingMode.HALF_EVEN.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            iArr[RoundingMode.HALF_UP.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            iArr[RoundingMode.UNNECESSARY.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            iArr[RoundingMode.UP.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        f27javamathRoundingModeSwitchesValues = iArr;
        return iArr;
    }

    public DecimalFormat() {
        this.roundingMode = RoundingMode.HALF_EVEN;
        Locale def = Locale.getDefault(Locale.Category.FORMAT);
        String pattern = (String) cachedLocaleData.get(def);
        if (pattern == null) {
            pattern = LocaleData.get(def).numberPattern;
            cachedLocaleData.putIfAbsent(def, pattern);
        }
        this.symbols = new DecimalFormatSymbols(def);
        init(pattern);
    }

    public DecimalFormat(String pattern) {
        this.roundingMode = RoundingMode.HALF_EVEN;
        this.symbols = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT));
        init(pattern);
    }

    public DecimalFormat(String pattern, DecimalFormatSymbols symbols2) {
        this.roundingMode = RoundingMode.HALF_EVEN;
        this.symbols = (DecimalFormatSymbols) symbols2.clone();
        init(pattern);
    }

    private void init(String pattern) {
        this.icuDecimalFormat = new android.icu.text.DecimalFormat(pattern, this.symbols.getIcuDecimalFormatSymbols());
        updateFieldsFromIcu();
    }

    private static FieldPosition getIcuFieldPosition(FieldPosition fp) {
        NumberFormat.Field attribute;
        if (fp.getFieldAttribute() == null) {
            return fp;
        }
        if (fp.getFieldAttribute() == NumberFormat.Field.INTEGER) {
            attribute = NumberFormat.Field.INTEGER;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.FRACTION) {
            attribute = NumberFormat.Field.FRACTION;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.DECIMAL_SEPARATOR) {
            attribute = NumberFormat.Field.DECIMAL_SEPARATOR;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.EXPONENT_SYMBOL) {
            attribute = NumberFormat.Field.EXPONENT_SYMBOL;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.EXPONENT_SIGN) {
            attribute = NumberFormat.Field.EXPONENT_SIGN;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.EXPONENT) {
            attribute = NumberFormat.Field.EXPONENT;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.GROUPING_SEPARATOR) {
            attribute = NumberFormat.Field.GROUPING_SEPARATOR;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.CURRENCY) {
            attribute = NumberFormat.Field.CURRENCY;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.PERCENT) {
            attribute = NumberFormat.Field.PERCENT;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.PERMILLE) {
            attribute = NumberFormat.Field.PERMILLE;
        } else if (fp.getFieldAttribute() == NumberFormat.Field.SIGN) {
            attribute = NumberFormat.Field.SIGN;
        } else {
            throw new IllegalArgumentException("Unexpected field position attribute type.");
        }
        FieldPosition icuFieldPosition = new FieldPosition((Format.Field) attribute);
        icuFieldPosition.setBeginIndex(fp.getBeginIndex());
        icuFieldPosition.setEndIndex(fp.getEndIndex());
        return icuFieldPosition;
    }

    private static NumberFormat.Field toJavaFieldAttribute(AttributedCharacterIterator.Attribute icuAttribute) {
        if (icuAttribute.getName().equals(NumberFormat.Field.INTEGER.getName())) {
            return NumberFormat.Field.INTEGER;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.CURRENCY.getName())) {
            return NumberFormat.Field.CURRENCY;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.DECIMAL_SEPARATOR.getName())) {
            return NumberFormat.Field.DECIMAL_SEPARATOR;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.EXPONENT.getName())) {
            return NumberFormat.Field.EXPONENT;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.EXPONENT_SIGN.getName())) {
            return NumberFormat.Field.EXPONENT_SIGN;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.EXPONENT_SYMBOL.getName())) {
            return NumberFormat.Field.EXPONENT_SYMBOL;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.FRACTION.getName())) {
            return NumberFormat.Field.FRACTION;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.GROUPING_SEPARATOR.getName())) {
            return NumberFormat.Field.GROUPING_SEPARATOR;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.SIGN.getName())) {
            return NumberFormat.Field.SIGN;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.PERCENT.getName())) {
            return NumberFormat.Field.PERCENT;
        }
        if (icuAttribute.getName().equals(NumberFormat.Field.PERMILLE.getName())) {
            return NumberFormat.Field.PERMILLE;
        }
        throw new IllegalArgumentException("Unrecognized attribute: " + icuAttribute.getName());
    }

    public final StringBuffer format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
        if ((number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte) || (number instanceof AtomicInteger) || (number instanceof AtomicLong) || ((number instanceof BigInteger) && ((BigInteger) number).bitLength() < 64)) {
            return format(((Number) number).longValue(), toAppendTo, pos);
        }
        if (number instanceof BigDecimal) {
            return format((BigDecimal) number, toAppendTo, pos);
        }
        if (number instanceof BigInteger) {
            return format((BigInteger) number, toAppendTo, pos);
        }
        if (number instanceof Number) {
            return format(((Number) number).doubleValue(), toAppendTo, pos);
        }
        throw new IllegalArgumentException("Cannot format given Object as a Number");
    }

    public StringBuffer format(double number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, icuFieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    public StringBuffer format(long number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, icuFieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    private StringBuffer format(BigDecimal number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, fieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    private StringBuffer format(BigInteger number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, fieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object == null");
        }
        AttributedCharacterIterator original = this.icuDecimalFormat.formatToCharacterIterator(obj);
        StringBuilder textBuilder = new StringBuilder(original.getEndIndex() - original.getBeginIndex());
        for (int i = original.getBeginIndex(); i < original.getEndIndex(); i++) {
            textBuilder.append(original.current());
            original.next();
        }
        AttributedString result = new AttributedString(textBuilder.toString());
        for (int i2 = original.getBeginIndex(); i2 < original.getEndIndex(); i2++) {
            original.setIndex(i2);
            for (AttributedCharacterIterator.Attribute attribute : original.getAttributes().keySet()) {
                int start = original.getRunStart();
                int end = original.getRunLimit();
                NumberFormat.Field javaAttr = toJavaFieldAttribute(attribute);
                result.addAttribute(javaAttr, javaAttr, start, end);
            }
        }
        return result.getIterator();
    }

    public Number parse(String text, ParsePosition pos) {
        Number number;
        if (pos.index < 0 || pos.index >= text.length() || (number = this.icuDecimalFormat.parse(text, pos)) == null) {
            return null;
        }
        if (isParseBigDecimal()) {
            if (number instanceof Long) {
                return new BigDecimal(number.longValue());
            }
            if ((number instanceof Double) && !((Double) number).isInfinite() && !((Double) number).isNaN()) {
                return new BigDecimal(number.toString());
            }
            if ((number instanceof Double) && (((Double) number).isNaN() || ((Double) number).isInfinite())) {
                return number;
            }
            if (number instanceof android.icu.math.BigDecimal) {
                return ((android.icu.math.BigDecimal) number).toBigDecimal();
            }
        }
        if ((number instanceof android.icu.math.BigDecimal) || (number instanceof BigInteger)) {
            return Double.valueOf(number.doubleValue());
        }
        if (!isParseIntegerOnly() || !number.equals(new Double(-0.0d))) {
            return number;
        }
        return 0L;
    }

    public DecimalFormatSymbols getDecimalFormatSymbols() {
        return DecimalFormatSymbols.fromIcuInstance(this.icuDecimalFormat.getDecimalFormatSymbols());
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols newSymbols) {
        try {
            this.symbols = (DecimalFormatSymbols) newSymbols.clone();
            this.icuDecimalFormat.setDecimalFormatSymbols(this.symbols.getIcuDecimalFormatSymbols());
        } catch (Exception e) {
        }
    }

    public String getPositivePrefix() {
        return this.icuDecimalFormat.getPositivePrefix();
    }

    public void setPositivePrefix(String newValue) {
        this.icuDecimalFormat.setPositivePrefix(newValue);
    }

    public String getNegativePrefix() {
        return this.icuDecimalFormat.getNegativePrefix();
    }

    public void setNegativePrefix(String newValue) {
        this.icuDecimalFormat.setNegativePrefix(newValue);
    }

    public String getPositiveSuffix() {
        return this.icuDecimalFormat.getPositiveSuffix();
    }

    public void setPositiveSuffix(String newValue) {
        this.icuDecimalFormat.setPositiveSuffix(newValue);
    }

    public String getNegativeSuffix() {
        return this.icuDecimalFormat.getNegativeSuffix();
    }

    public void setNegativeSuffix(String newValue) {
        this.icuDecimalFormat.setNegativeSuffix(newValue);
    }

    public int getMultiplier() {
        return this.icuDecimalFormat.getMultiplier();
    }

    public void setMultiplier(int newValue) {
        this.icuDecimalFormat.setMultiplier(newValue);
    }

    public int getGroupingSize() {
        return this.icuDecimalFormat.getGroupingSize();
    }

    public void setGroupingSize(int newValue) {
        this.icuDecimalFormat.setGroupingSize(newValue);
    }

    public boolean isGroupingUsed() {
        return this.icuDecimalFormat.isGroupingUsed();
    }

    public void setGroupingUsed(boolean newValue) {
        this.icuDecimalFormat.setGroupingUsed(newValue);
    }

    public boolean isDecimalSeparatorAlwaysShown() {
        return this.icuDecimalFormat.isDecimalSeparatorAlwaysShown();
    }

    public void setDecimalSeparatorAlwaysShown(boolean newValue) {
        this.icuDecimalFormat.setDecimalSeparatorAlwaysShown(newValue);
    }

    public boolean isParseBigDecimal() {
        return this.icuDecimalFormat.isParseBigDecimal();
    }

    public void setParseBigDecimal(boolean newValue) {
        this.icuDecimalFormat.setParseBigDecimal(newValue);
    }

    public void setParseIntegerOnly(boolean value) {
        super.setParseIntegerOnly(value);
        this.icuDecimalFormat.setParseIntegerOnly(value);
    }

    public boolean isParseIntegerOnly() {
        return this.icuDecimalFormat.isParseIntegerOnly();
    }

    public Object clone() {
        try {
            DecimalFormat other = (DecimalFormat) super.clone();
            other.icuDecimalFormat = (android.icu.text.DecimalFormat) this.icuDecimalFormat.clone();
            other.symbols = (DecimalFormatSymbols) this.symbols.clone();
            return other;
        } catch (Exception e) {
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
        if (!(obj instanceof DecimalFormat)) {
            return false;
        }
        DecimalFormat other = (DecimalFormat) obj;
        if (this.icuDecimalFormat.equals(other.icuDecimalFormat)) {
            return compareIcuRoundingIncrement(other.icuDecimalFormat);
        }
        return false;
    }

    private boolean compareIcuRoundingIncrement(android.icu.text.DecimalFormat other) {
        BigDecimal increment = this.icuDecimalFormat.getRoundingIncrement();
        if (increment != null) {
            if (other.getRoundingIncrement() != null) {
                return increment.equals(other.getRoundingIncrement());
            }
            return false;
        } else if (other.getRoundingIncrement() == null) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (super.hashCode() * 37) + getPositivePrefix().hashCode();
    }

    public String toPattern() {
        return this.icuDecimalFormat.toPattern();
    }

    public String toLocalizedPattern() {
        return this.icuDecimalFormat.toLocalizedPattern();
    }

    public void applyPattern(String pattern) {
        this.icuDecimalFormat.applyPattern(pattern);
        updateFieldsFromIcu();
    }

    public void applyLocalizedPattern(String pattern) {
        this.icuDecimalFormat.applyLocalizedPattern(pattern);
        updateFieldsFromIcu();
    }

    private void updateFieldsFromIcu() {
        if (this.icuDecimalFormat.getMaximumIntegerDigits() == DOUBLE_INTEGER_DIGITS) {
            this.icuDecimalFormat.setMaximumIntegerDigits(2000000000);
        }
        this.maximumIntegerDigits = this.icuDecimalFormat.getMaximumIntegerDigits();
        this.minimumIntegerDigits = this.icuDecimalFormat.getMinimumIntegerDigits();
        this.maximumFractionDigits = this.icuDecimalFormat.getMaximumFractionDigits();
        this.minimumFractionDigits = this.icuDecimalFormat.getMinimumFractionDigits();
    }

    public void setMaximumIntegerDigits(int newValue) {
        int i = DOUBLE_INTEGER_DIGITS;
        this.maximumIntegerDigits = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        super.setMaximumIntegerDigits(this.maximumIntegerDigits > DOUBLE_INTEGER_DIGITS ? DOUBLE_INTEGER_DIGITS : this.maximumIntegerDigits);
        if (this.minimumIntegerDigits > this.maximumIntegerDigits) {
            this.minimumIntegerDigits = this.maximumIntegerDigits;
            if (this.minimumIntegerDigits <= DOUBLE_INTEGER_DIGITS) {
                i = this.minimumIntegerDigits;
            }
            super.setMinimumIntegerDigits(i);
        }
        this.icuDecimalFormat.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    public void setMinimumIntegerDigits(int newValue) {
        int i = DOUBLE_INTEGER_DIGITS;
        this.minimumIntegerDigits = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        super.setMinimumIntegerDigits(this.minimumIntegerDigits > DOUBLE_INTEGER_DIGITS ? DOUBLE_INTEGER_DIGITS : this.minimumIntegerDigits);
        if (this.minimumIntegerDigits > this.maximumIntegerDigits) {
            this.maximumIntegerDigits = this.minimumIntegerDigits;
            if (this.maximumIntegerDigits <= DOUBLE_INTEGER_DIGITS) {
                i = this.maximumIntegerDigits;
            }
            super.setMaximumIntegerDigits(i);
        }
        this.icuDecimalFormat.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    public void setMaximumFractionDigits(int newValue) {
        int i = DOUBLE_FRACTION_DIGITS;
        this.maximumFractionDigits = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        super.setMaximumFractionDigits(this.maximumFractionDigits > DOUBLE_FRACTION_DIGITS ? DOUBLE_FRACTION_DIGITS : this.maximumFractionDigits);
        if (this.minimumFractionDigits > this.maximumFractionDigits) {
            this.minimumFractionDigits = this.maximumFractionDigits;
            if (this.minimumFractionDigits <= DOUBLE_FRACTION_DIGITS) {
                i = this.minimumFractionDigits;
            }
            super.setMinimumFractionDigits(i);
        }
        this.icuDecimalFormat.setMaximumFractionDigits(getMaximumFractionDigits());
    }

    public void setMinimumFractionDigits(int newValue) {
        int i = DOUBLE_FRACTION_DIGITS;
        this.minimumFractionDigits = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        super.setMinimumFractionDigits(this.minimumFractionDigits > DOUBLE_FRACTION_DIGITS ? DOUBLE_FRACTION_DIGITS : this.minimumFractionDigits);
        if (this.minimumFractionDigits > this.maximumFractionDigits) {
            this.maximumFractionDigits = this.minimumFractionDigits;
            if (this.maximumFractionDigits <= DOUBLE_FRACTION_DIGITS) {
                i = this.maximumFractionDigits;
            }
            super.setMaximumFractionDigits(i);
        }
        this.icuDecimalFormat.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    public Currency getCurrency() {
        return this.symbols.getCurrency();
    }

    public void setCurrency(Currency currency) {
        if (currency != this.symbols.getCurrency() || !currency.getSymbol().equals(this.symbols.getCurrencySymbol())) {
            this.symbols.setCurrency(currency);
            this.icuDecimalFormat.setDecimalFormatSymbols(this.symbols.getIcuDecimalFormatSymbols());
            this.icuDecimalFormat.setMinimumFractionDigits(this.minimumFractionDigits);
            this.icuDecimalFormat.setMaximumFractionDigits(this.maximumFractionDigits);
        }
    }

    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    private static int convertRoundingMode(RoundingMode rm) {
        switch (m186getjavamathRoundingModeSwitchesValues()[rm.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 3;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 4;
            case 7:
                return 7;
            case 8:
                return 0;
            default:
                throw new IllegalArgumentException("Invalid rounding mode specified");
        }
    }

    public void setRoundingMode(RoundingMode roundingMode2) {
        if (roundingMode2 == null) {
            throw new NullPointerException();
        }
        this.roundingMode = roundingMode2;
        this.icuDecimalFormat.setRoundingMode(convertRoundingMode(roundingMode2));
    }

    /* access modifiers changed from: package-private */
    public void adjustForCurrencyDefaultFractionDigits() {
        int digits;
        Currency currency = this.symbols.getCurrency();
        if (currency == null) {
            try {
                currency = Currency.getInstance(this.symbols.getInternationalCurrencySymbol());
            } catch (IllegalArgumentException e) {
            }
        }
        if (currency != null && (digits = currency.getDefaultFractionDigits()) != -1) {
            int oldMinDigits = getMinimumFractionDigits();
            if (oldMinDigits == getMaximumFractionDigits()) {
                setMinimumFractionDigits(digits);
                setMaximumFractionDigits(digits);
                return;
            }
            setMinimumFractionDigits(Math.min(digits, oldMinDigits));
            setMaximumFractionDigits(digits);
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("positivePrefix", (Object) this.icuDecimalFormat.getPositivePrefix());
        fields.put("positiveSuffix", (Object) this.icuDecimalFormat.getPositiveSuffix());
        fields.put("negativePrefix", (Object) this.icuDecimalFormat.getNegativePrefix());
        fields.put("negativeSuffix", (Object) this.icuDecimalFormat.getNegativeSuffix());
        fields.put("posPrefixPattern", (Object) null);
        fields.put("posSuffixPattern", (Object) null);
        fields.put("negPrefixPattern", (Object) null);
        fields.put("negSuffixPattern", (Object) null);
        fields.put("multiplier", this.icuDecimalFormat.getMultiplier());
        fields.put("groupingSize", (byte) this.icuDecimalFormat.getGroupingSize());
        fields.put("groupingUsed", this.icuDecimalFormat.isGroupingUsed());
        fields.put("decimalSeparatorAlwaysShown", this.icuDecimalFormat.isDecimalSeparatorAlwaysShown());
        fields.put("parseBigDecimal", this.icuDecimalFormat.isParseBigDecimal());
        fields.put("roundingMode", (Object) this.roundingMode);
        fields.put("symbols", (Object) this.symbols);
        fields.put("useExponentialNotation", false);
        fields.put("minExponentDigits", (byte) 0);
        fields.put("maximumIntegerDigits", this.icuDecimalFormat.getMaximumIntegerDigits());
        fields.put("minimumIntegerDigits", this.icuDecimalFormat.getMinimumIntegerDigits());
        fields.put("maximumFractionDigits", this.icuDecimalFormat.getMaximumFractionDigits());
        fields.put("minimumFractionDigits", this.icuDecimalFormat.getMinimumFractionDigits());
        fields.put("serialVersionOnStream", 4);
        stream.writeFields();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        this.symbols = (DecimalFormatSymbols) fields.get("symbols", (Object) null);
        init("");
        this.icuDecimalFormat.setPositivePrefix((String) fields.get("positivePrefix", (Object) ""));
        this.icuDecimalFormat.setPositiveSuffix((String) fields.get("positiveSuffix", (Object) ""));
        this.icuDecimalFormat.setNegativePrefix((String) fields.get("negativePrefix", (Object) LanguageTag.SEP));
        this.icuDecimalFormat.setNegativeSuffix((String) fields.get("negativeSuffix", (Object) ""));
        this.icuDecimalFormat.setMultiplier(fields.get("multiplier", 1));
        this.icuDecimalFormat.setGroupingSize(fields.get("groupingSize", (byte) 3));
        this.icuDecimalFormat.setGroupingUsed(fields.get("groupingUsed", true));
        this.icuDecimalFormat.setDecimalSeparatorAlwaysShown(fields.get("decimalSeparatorAlwaysShown", false));
        setRoundingMode((RoundingMode) fields.get("roundingMode", (Object) RoundingMode.HALF_EVEN));
        int maximumIntegerDigits2 = fields.get("maximumIntegerDigits", (int) DOUBLE_INTEGER_DIGITS);
        int minimumIntegerDigits2 = fields.get("minimumIntegerDigits", (int) DOUBLE_INTEGER_DIGITS);
        int maximumFractionDigits2 = fields.get("maximumFractionDigits", (int) DOUBLE_FRACTION_DIGITS);
        int minimumFractionDigits2 = fields.get("minimumFractionDigits", (int) DOUBLE_FRACTION_DIGITS);
        this.icuDecimalFormat.setMaximumIntegerDigits(maximumIntegerDigits2);
        super.setMaximumIntegerDigits(this.icuDecimalFormat.getMaximumIntegerDigits());
        setMinimumIntegerDigits(minimumIntegerDigits2);
        setMinimumFractionDigits(minimumFractionDigits2);
        setMaximumFractionDigits(maximumFractionDigits2);
        setParseBigDecimal(fields.get("parseBigDecimal", false));
        if (fields.get("serialVersionOnStream", 0) < 3) {
            setMaximumIntegerDigits(super.getMaximumIntegerDigits());
            setMinimumIntegerDigits(super.getMinimumIntegerDigits());
            setMaximumFractionDigits(super.getMaximumFractionDigits());
            setMinimumFractionDigits(super.getMinimumFractionDigits());
        }
    }
}
