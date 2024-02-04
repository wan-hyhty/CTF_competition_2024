package sun.security.util;

import java.security.AccessController;
import java.security.AlgorithmConstraints;
import java.security.AlgorithmParameters;
import java.security.CryptoPrimitive;
import java.security.Key;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisabledAlgorithmConstraints implements AlgorithmConstraints {
    public static final String PROPERTY_CERTPATH_DISABLED_ALGS = "jdk.certpath.disabledAlgorithms";
    public static final String PROPERTY_TLS_DISABLED_ALGS = "jdk.tls.disabledAlgorithms";
    private static Map<String, String[]> disabledAlgorithmsMap;
    private static Map<String, KeySizeConstraints> keySizeConstraintsMap;
    private String[] disabledAlgorithms;
    private KeySizeConstraints keySizeConstraints;

    public DisabledAlgorithmConstraints(String propertyName) {
        synchronized (disabledAlgorithmsMap) {
            if (!disabledAlgorithmsMap.containsKey(propertyName)) {
                loadDisabledAlgorithmsMap(propertyName);
            }
            this.disabledAlgorithms = disabledAlgorithmsMap.get(propertyName);
            this.keySizeConstraints = keySizeConstraintsMap.get(propertyName);
        }
    }

    public final boolean permits(Set<CryptoPrimitive> primitives, String algorithm, AlgorithmParameters parameters) {
        if (algorithm == null || algorithm.length() == 0) {
            throw new IllegalArgumentException("No algorithm name specified");
        } else if (primitives == null || primitives.isEmpty()) {
            throw new IllegalArgumentException("No cryptographic primitive specified");
        } else {
            Set<String> elements = null;
            for (String disabled : this.disabledAlgorithms) {
                if (disabled != null && !disabled.isEmpty()) {
                    if (disabled.equalsIgnoreCase(algorithm)) {
                        return false;
                    }
                    if (elements == null) {
                        elements = decomposes(algorithm);
                    }
                    for (String element : elements) {
                        if (disabled.equalsIgnoreCase(element)) {
                            return false;
                        }
                    }
                    continue;
                }
            }
            return true;
        }
    }

    public final boolean permits(Set<CryptoPrimitive> primitives, Key key) {
        return checkConstraints(primitives, "", key, (AlgorithmParameters) null);
    }

    public final boolean permits(Set<CryptoPrimitive> primitives, String algorithm, Key key, AlgorithmParameters parameters) {
        if (algorithm != null && algorithm.length() != 0) {
            return checkConstraints(primitives, algorithm, key, parameters);
        }
        throw new IllegalArgumentException("No algorithm name specified");
    }

    /* access modifiers changed from: protected */
    public Set<String> decomposes(String algorithm) {
        if (algorithm == null || algorithm.length() == 0) {
            return new HashSet();
        }
        String[] transTockens = Pattern.compile("/").split(algorithm);
        Set<String> elements = new HashSet<>();
        for (String transTocken : transTockens) {
            if (!(transTocken == null || transTocken.length() == 0)) {
                for (String token : Pattern.compile("with|and", 2).split(transTocken)) {
                    if (!(token == null || token.length() == 0)) {
                        elements.add(token);
                    }
                }
            }
        }
        if (elements.contains("SHA1") && !elements.contains("SHA-1")) {
            elements.add("SHA-1");
        }
        if (elements.contains("SHA-1") && !elements.contains("SHA1")) {
            elements.add("SHA1");
        }
        if (elements.contains("SHA224") && !elements.contains("SHA-224")) {
            elements.add("SHA-224");
        }
        if (elements.contains("SHA-224") && !elements.contains("SHA224")) {
            elements.add("SHA224");
        }
        if (elements.contains("SHA256") && !elements.contains("SHA-256")) {
            elements.add("SHA-256");
        }
        if (elements.contains("SHA-256") && !elements.contains("SHA256")) {
            elements.add("SHA256");
        }
        if (elements.contains("SHA384") && !elements.contains("SHA-384")) {
            elements.add("SHA-384");
        }
        if (elements.contains("SHA-384") && !elements.contains("SHA384")) {
            elements.add("SHA384");
        }
        if (elements.contains("SHA512") && !elements.contains("SHA-512")) {
            elements.add("SHA-512");
        }
        if (elements.contains("SHA-512") && !elements.contains("SHA512")) {
            elements.add("SHA512");
        }
        return elements;
    }

    private boolean checkConstraints(Set<CryptoPrimitive> primitives, String algorithm, Key key, AlgorithmParameters parameters) {
        if (key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        } else if ((algorithm == null || algorithm.length() == 0 || permits(primitives, algorithm, parameters)) && permits(primitives, key.getAlgorithm(), (AlgorithmParameters) null) && !this.keySizeConstraints.disables(key)) {
            return true;
        } else {
            return false;
        }
    }

    private static void loadDisabledAlgorithmsMap(final String propertyName) {
        String property = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                return Security.getProperty(propertyName);
            }
        });
        String[] algorithmsInProperty = null;
        if (property != null && !property.isEmpty()) {
            if (property.charAt(0) == '\"' && property.charAt(property.length() - 1) == '\"') {
                property = property.substring(1, property.length() - 1);
            }
            algorithmsInProperty = property.split(",");
            for (int i = 0; i < algorithmsInProperty.length; i++) {
                algorithmsInProperty[i] = algorithmsInProperty[i].trim();
            }
        }
        if (algorithmsInProperty == null) {
            algorithmsInProperty = new String[0];
        }
        disabledAlgorithmsMap.put(propertyName, algorithmsInProperty);
        keySizeConstraintsMap.put(propertyName, new KeySizeConstraints(algorithmsInProperty));
    }

    private static class KeySizeConstraints {
        private static final Pattern pattern = null;
        private Map<String, Set<KeySizeConstraint>> constraintsMap = Collections.synchronizedMap(new HashMap());

        public KeySizeConstraints(String[] restrictions) {
            for (String restriction : restrictions) {
                if (restriction != null && !restriction.isEmpty()) {
                    Matcher matcher = pattern.matcher(restriction);
                    if (matcher.matches()) {
                        String algorithm = matcher.group(1);
                        KeySizeConstraint.Operator operator = KeySizeConstraint.Operator.of(matcher.group(2));
                        int length = Integer.parseInt(matcher.group(3));
                        String algorithm2 = algorithm.toLowerCase(Locale.ENGLISH);
                        synchronized (this.constraintsMap) {
                            if (!this.constraintsMap.containsKey(algorithm2)) {
                                this.constraintsMap.put(algorithm2, new HashSet());
                            }
                            this.constraintsMap.get(algorithm2).add(new KeySizeConstraint(operator, length));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean disables(java.security.Key r7) {
            /*
                r6 = this;
                java.lang.String r4 = r7.getAlgorithm()
                java.util.Locale r5 = java.util.Locale.ENGLISH
                java.lang.String r0 = r4.toLowerCase(r5)
                java.util.Map<java.lang.String, java.util.Set<sun.security.util.DisabledAlgorithmConstraints$KeySizeConstraint>> r5 = r6.constraintsMap
                monitor-enter(r5)
                java.util.Map<java.lang.String, java.util.Set<sun.security.util.DisabledAlgorithmConstraints$KeySizeConstraint>> r4 = r6.constraintsMap     // Catch:{ all -> 0x0039 }
                boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x0039 }
                if (r4 == 0) goto L_0x0036
                java.util.Map<java.lang.String, java.util.Set<sun.security.util.DisabledAlgorithmConstraints$KeySizeConstraint>> r4 = r6.constraintsMap     // Catch:{ all -> 0x0039 }
                java.lang.Object r3 = r4.get(r0)     // Catch:{ all -> 0x0039 }
                java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x0039 }
                java.util.Iterator r2 = r3.iterator()     // Catch:{ all -> 0x0039 }
            L_0x0021:
                boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0039 }
                if (r4 == 0) goto L_0x0036
                java.lang.Object r1 = r2.next()     // Catch:{ all -> 0x0039 }
                sun.security.util.DisabledAlgorithmConstraints$KeySizeConstraint r1 = (sun.security.util.DisabledAlgorithmConstraints.KeySizeConstraint) r1     // Catch:{ all -> 0x0039 }
                boolean r4 = r1.disables(r7)     // Catch:{ all -> 0x0039 }
                if (r4 == 0) goto L_0x0021
                r4 = 1
                monitor-exit(r5)
                return r4
            L_0x0036:
                monitor-exit(r5)
                r4 = 0
                return r4
            L_0x0039:
                r4 = move-exception
                monitor-exit(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.util.DisabledAlgorithmConstraints.KeySizeConstraints.disables(java.security.Key):boolean");
        }
    }

    private static class KeySizeConstraint {

        /* renamed from: -sun-security-util-DisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues  reason: not valid java name */
        private static final /* synthetic */ int[] f146sunsecurityutilDisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues = null;
        private int maxSize;
        private int minSize;
        private int prohibitedSize = -1;

        /* renamed from: -getsun-security-util-DisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues  reason: not valid java name */
        private static /* synthetic */ int[] m722getsunsecurityutilDisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues() {
            if (f146sunsecurityutilDisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues != null) {
                return f146sunsecurityutilDisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues;
            }
            int[] iArr = new int[Operator.values().length];
            try {
                iArr[Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Operator.GE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Operator.GT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Operator.LE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Operator.LT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Operator.NE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            f146sunsecurityutilDisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues = iArr;
            return iArr;
        }

        /*  JADX ERROR: NullPointerException in pass: EnumVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
            	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
            */
        enum Operator {
            ;

            static Operator of(String s) {
                if (s.equals("==")) {
                    return EQ;
                }
                if (s.equals("!=")) {
                    return NE;
                }
                if (s.equals("<")) {
                    return LT;
                }
                if (s.equals("<=")) {
                    return LE;
                }
                if (s.equals(">")) {
                    return GT;
                }
                if (s.equals(">=")) {
                    return GE;
                }
                throw new IllegalArgumentException(s + " is not a legal Operator");
            }
        }

        public KeySizeConstraint(Operator operator, int length) {
            int i = 0;
            switch (m722getsunsecurityutilDisabledAlgorithmConstraints$KeySizeConstraint$OperatorSwitchesValues()[operator.ordinal()]) {
                case 1:
                    this.minSize = 0;
                    this.maxSize = Integer.MAX_VALUE;
                    this.prohibitedSize = length;
                    return;
                case 2:
                    this.minSize = 0;
                    this.maxSize = length > 1 ? length - 1 : i;
                    return;
                case 3:
                    this.minSize = 0;
                    this.maxSize = length;
                    return;
                case 4:
                    this.minSize = length + 1;
                    this.maxSize = Integer.MAX_VALUE;
                    return;
                case 5:
                    this.minSize = length;
                    this.maxSize = Integer.MAX_VALUE;
                    return;
                case 6:
                    this.minSize = length;
                    this.maxSize = length;
                    return;
                default:
                    this.minSize = Integer.MAX_VALUE;
                    this.maxSize = -1;
                    return;
            }
        }

        public boolean disables(Key key) {
            int size = KeyUtil.getKeySize(key);
            if (size == 0) {
                return true;
            }
            if (size <= 0) {
                return false;
            }
            if (size < this.minSize || size > this.maxSize || this.prohibitedSize == size) {
                return true;
            }
            return false;
        }
    }
}
