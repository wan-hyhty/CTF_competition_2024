package java.lang;

import libcore.util.EmptyArray;

public final class Void {
    public static final Class<Void> TYPE = null;

    private static Class<Void> lookupType() {
        try {
            return Runnable.class.getMethod("run", EmptyArray.CLASS).getReturnType();
        } catch (Exception e) {
            throw new AssertionError((Object) e);
        }
    }

    private Void() {
    }
}
