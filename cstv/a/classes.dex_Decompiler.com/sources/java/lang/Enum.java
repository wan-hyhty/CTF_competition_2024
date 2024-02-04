package java.lang;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.Enum;
import libcore.util.BasicLruCache;

public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable {
    private static final BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache = null;
    private final String name;
    private final int ordinal;

    public final String name() {
        return this.name;
    }

    public final int ordinal() {
        return this.ordinal;
    }

    protected Enum(String name2, int ordinal2) {
        this.name = name2;
        this.ordinal = ordinal2;
    }

    public String toString() {
        return this.name;
    }

    public final boolean equals(Object other) {
        return this == other;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: protected */
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final int compareTo(E o) {
        E e = o;
        if (getClass() == o.getClass() || getDeclaringClass() == o.getDeclaringClass()) {
            return this.ordinal - o.ordinal;
        }
        throw new ClassCastException();
    }

    public final Class<E> getDeclaringClass() {
        Class clazz = getClass();
        Class zuper = clazz.getSuperclass();
        return zuper == Enum.class ? clazz : zuper;
    }

    public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name2) {
        if (enumType == null) {
            throw new NullPointerException("enumType == null");
        } else if (name2 == null) {
            throw new NullPointerException("Name is null");
        } else {
            T[] values = getSharedConstants(enumType);
            T result = null;
            if (values != null) {
                for (T value : values) {
                    if (name2.equals(value.name())) {
                        result = value;
                    }
                }
                if (result != null) {
                    return result;
                }
                throw new IllegalArgumentException("No enum constant " + enumType.getCanonicalName() + "." + name2);
            }
            throw new IllegalArgumentException(enumType.toString() + " is not an enum type.");
        }
    }

    public static <T extends Enum<T>> T[] getSharedConstants(Class<T> enumType) {
        return (Enum[]) sharedConstantsCache.get(enumType);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }
}
