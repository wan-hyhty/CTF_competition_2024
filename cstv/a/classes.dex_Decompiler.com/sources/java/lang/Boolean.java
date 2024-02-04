package java.lang;

import java.io.Serializable;

public final class Boolean implements Serializable, Comparable<Boolean> {
    public static final Boolean FALSE = null;
    public static final Boolean TRUE = null;
    public static final Class<Boolean> TYPE = null;
    private static final long serialVersionUID = -3665804199014368530L;
    private final boolean value;

    public Boolean(boolean value2) {
        this.value = value2;
    }

    public Boolean(String s) {
        this(toBoolean(s));
    }

    public static boolean parseBoolean(String s) {
        return toBoolean(s);
    }

    public boolean booleanValue() {
        return this.value;
    }

    public static Boolean valueOf(boolean b) {
        return b ? TRUE : FALSE;
    }

    public static Boolean valueOf(String s) {
        return toBoolean(s) ? TRUE : FALSE;
    }

    public static String toString(boolean b) {
        return b ? "true" : "false";
    }

    public String toString() {
        return this.value ? "true" : "false";
    }

    public int hashCode() {
        return this.value ? 1231 : 1237;
    }

    public static int hashCode(boolean value2) {
        return value2 ? 1231 : 1237;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Boolean) || this.value != ((Boolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean getBoolean(String name) {
        try {
            return toBoolean(System.getProperty(name));
        } catch (IllegalArgumentException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    public int compareTo(Boolean b) {
        return compare(this.value, b.value);
    }

    public static int compare(boolean x, boolean y) {
        if (x == y) {
            return 0;
        }
        return x ? 1 : -1;
    }

    private static boolean toBoolean(String name) {
        if (name != null) {
            return name.equalsIgnoreCase("true");
        }
        return false;
    }

    public static boolean logicalAnd(boolean a, boolean b) {
        if (a) {
            return b;
        }
        return false;
    }

    public static boolean logicalOr(boolean a, boolean b) {
        if (!a) {
            return b;
        }
        return true;
    }

    public static boolean logicalXor(boolean a, boolean b) {
        return a ^ b;
    }
}
