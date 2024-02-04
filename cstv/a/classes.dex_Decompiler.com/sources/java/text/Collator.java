package java.text;

import android.icu.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.Locale;
import libcore.icu.ICU;

public abstract class Collator implements Comparator<Object>, Cloneable {
    public static final int CANONICAL_DECOMPOSITION = 1;
    public static final int FULL_DECOMPOSITION = 2;
    public static final int IDENTICAL = 3;
    public static final int NO_DECOMPOSITION = 0;
    public static final int PRIMARY = 0;
    public static final int SECONDARY = 1;
    public static final int TERTIARY = 2;
    android.icu.text.Collator icuColl;

    public abstract int compare(String str, String str2);

    public abstract CollationKey getCollationKey(String str);

    public abstract int hashCode();

    Collator(android.icu.text.Collator icuColl2) {
        this.icuColl = icuColl2;
    }

    protected Collator() {
        this.icuColl = RuleBasedCollator.getInstance(Locale.getDefault());
    }

    public static synchronized Collator getInstance() {
        Collator instance;
        synchronized (Collator.class) {
            instance = getInstance(Locale.getDefault());
        }
        return instance;
    }

    public static synchronized Collator getInstance(Locale desiredLocale) {
        RuleBasedCollator ruleBasedCollator;
        synchronized (Collator.class) {
            if (desiredLocale == null) {
                throw new NullPointerException("locale == null");
            }
            ruleBasedCollator = new RuleBasedCollator((RuleBasedCollator) android.icu.text.Collator.getInstance(desiredLocale));
        }
        return ruleBasedCollator;
    }

    public static synchronized Locale[] getAvailableLocales() {
        Locale[] availableCollatorLocales;
        synchronized (Collator.class) {
            availableCollatorLocales = ICU.getAvailableCollatorLocales();
        }
        return availableCollatorLocales;
    }

    public Object clone() {
        try {
            Collator clone = (Collator) super.clone();
            clone.icuColl = (android.icu.text.Collator) this.icuColl.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError((Object) e);
        }
    }

    public int compare(Object o1, Object o2) {
        return compare((String) o1, (String) o2);
    }

    public boolean equals(String source, String target) {
        return compare(source, target) == 0;
    }

    public synchronized int getStrength() {
        int value;
        value = this.icuColl.getStrength();
        if (value == 15) {
            value = 3;
        }
        return value;
    }

    public synchronized void setStrength(int newStrength) {
        if (newStrength == 3) {
            newStrength = 15;
        }
        this.icuColl.setStrength(newStrength);
    }

    public synchronized int getDecomposition() {
        return decompositionMode_ICU_Java(this.icuColl.getDecomposition());
    }

    public synchronized void setDecomposition(int decompositionMode) {
        this.icuColl.setDecomposition(decompositionMode_Java_ICU(decompositionMode));
    }

    private int decompositionMode_Java_ICU(int mode) {
        switch (mode) {
            case 0:
                return 16;
            case 1:
                return 17;
            default:
                throw new IllegalArgumentException("Bad mode: " + mode);
        }
    }

    private int decompositionMode_ICU_Java(int mode) {
        int javaMode = mode;
        switch (mode) {
            case 16:
                return 0;
            case 17:
                return 1;
            default:
                return javaMode;
        }
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        Collator other = (Collator) that;
        if (this.icuColl != null) {
            return this.icuColl.equals(other.icuColl);
        }
        if (other.icuColl == null) {
            return true;
        }
        return false;
    }
}
