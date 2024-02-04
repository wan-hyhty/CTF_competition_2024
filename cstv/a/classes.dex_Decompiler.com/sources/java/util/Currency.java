package java.util;

import java.io.Serializable;
import libcore.icu.ICU;
import sun.util.locale.BaseLocale;

public final class Currency implements Serializable {
    private static HashSet<Currency> available = null;
    private static HashMap<String, Currency> instances = null;
    private static final long serialVersionUID = -158308464356906721L;
    private final String currencyCode;
    private final transient android.icu.util.Currency icuCurrency;

    private Currency(android.icu.util.Currency icuCurrency2) {
        this.icuCurrency = icuCurrency2;
        this.currencyCode = icuCurrency2.getCurrencyCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Currency getInstance(java.lang.String r5) {
        /*
            r4 = 0
            java.util.HashMap<java.lang.String, java.util.Currency> r3 = instances
            monitor-enter(r3)
            java.util.HashMap<java.lang.String, java.util.Currency> r2 = instances     // Catch:{ all -> 0x0022 }
            java.lang.Object r1 = r2.get(r5)     // Catch:{ all -> 0x0022 }
            java.util.Currency r1 = (java.util.Currency) r1     // Catch:{ all -> 0x0022 }
            if (r1 != 0) goto L_0x0020
            android.icu.util.Currency r0 = android.icu.util.Currency.getInstance(r5)     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0016
            monitor-exit(r3)
            return r4
        L_0x0016:
            java.util.Currency r1 = new java.util.Currency     // Catch:{ all -> 0x0022 }
            r1.<init>(r0)     // Catch:{ all -> 0x0022 }
            java.util.HashMap<java.lang.String, java.util.Currency> r2 = instances     // Catch:{ all -> 0x0022 }
            r2.put(r5, r1)     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r3)
            return r1
        L_0x0022:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Currency.getInstance(java.lang.String):java.util.Currency");
    }

    public static Currency getInstance(Locale locale) {
        android.icu.util.Currency icuInstance = android.icu.util.Currency.getInstance(locale);
        String variant = locale.getVariant();
        String country = locale.getCountry();
        if (!variant.isEmpty() && (variant.equals("EURO") || variant.equals("HK") || variant.equals("PREEURO"))) {
            country = country + BaseLocale.SEP + variant;
        }
        String currencyCode2 = ICU.getCurrencyCode(country);
        if (currencyCode2 == null) {
            throw new IllegalArgumentException("Unsupported ISO 3166 country: " + locale);
        } else if (icuInstance == null || icuInstance.getCurrencyCode().equals("XXX")) {
            return null;
        } else {
            return getInstance(currencyCode2);
        }
    }

    public static Set<Currency> getAvailableCurrencies() {
        Set<Currency> set;
        synchronized (Currency.class) {
            if (available == null) {
                Set<android.icu.util.Currency> icuAvailableCurrencies = android.icu.util.Currency.getAvailableCurrencies();
                available = new HashSet<>();
                for (android.icu.util.Currency icuCurrency2 : icuAvailableCurrencies) {
                    Currency currency = getInstance(icuCurrency2.getCurrencyCode());
                    if (currency == null) {
                        currency = new Currency(icuCurrency2);
                        instances.put(currency.currencyCode, currency);
                    }
                    available.add(currency);
                }
            }
            set = (Set) available.clone();
        }
        return set;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public String getSymbol() {
        return this.icuCurrency.getSymbol();
    }

    public String getSymbol(Locale locale) {
        if (locale != null) {
            return this.icuCurrency.getSymbol(locale);
        }
        throw new NullPointerException("locale == null");
    }

    public int getDefaultFractionDigits() {
        if (this.icuCurrency.getCurrencyCode().equals("XXX")) {
            return -1;
        }
        return this.icuCurrency.getDefaultFractionDigits();
    }

    public int getNumericCode() {
        return this.icuCurrency.getNumericCode();
    }

    public String getDisplayName() {
        return this.icuCurrency.getDisplayName();
    }

    public String getDisplayName(Locale locale) {
        return this.icuCurrency.getDisplayName(locale);
    }

    public String toString() {
        return this.icuCurrency.toString();
    }

    private Object readResolve() {
        return getInstance(this.currencyCode);
    }
}
