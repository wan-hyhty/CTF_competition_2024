package java.util;

import java.lang.Enum;

class RegularEnumSet<E extends Enum<E>> extends EnumSet<E> {
    private static final long serialVersionUID = 3411599620347842686L;
    /* access modifiers changed from: private */
    public long elements = 0;

    RegularEnumSet(Class<E> elementType, Enum[] universe) {
        super(elementType, universe);
    }

    /* access modifiers changed from: package-private */
    public void addRange(E from, E to) {
        this.elements = (-1 >>> ((from.ordinal() - to.ordinal()) - 1)) << from.ordinal();
    }

    /* access modifiers changed from: package-private */
    public void addAll() {
        if (this.universe.length != 0) {
            this.elements = -1 >>> (-this.universe.length);
        }
    }

    /* access modifiers changed from: package-private */
    public void complement() {
        if (this.universe.length != 0) {
            this.elements = ~this.elements;
            this.elements &= -1 >>> (-this.universe.length);
        }
    }

    public Iterator<E> iterator() {
        return new EnumSetIterator();
    }

    private class EnumSetIterator<E extends Enum<E>> implements Iterator<E> {
        long lastReturned = 0;
        long unseen;

        EnumSetIterator() {
            this.unseen = RegularEnumSet.this.elements;
        }

        public boolean hasNext() {
            return this.unseen != 0;
        }

        public E next() {
            if (this.unseen == 0) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.unseen & (-this.unseen);
            this.unseen -= this.lastReturned;
            return RegularEnumSet.this.universe[Long.numberOfTrailingZeros(this.lastReturned)];
        }

        public void remove() {
            if (this.lastReturned == 0) {
                throw new IllegalStateException();
            }
            RegularEnumSet regularEnumSet = RegularEnumSet.this;
            long unused = regularEnumSet.elements = regularEnumSet.elements & (~this.lastReturned);
            this.lastReturned = 0;
        }
    }

    public int size() {
        return Long.bitCount(this.elements);
    }

    public boolean isEmpty() {
        return this.elements == 0;
    }

    public boolean contains(Object e) {
        if (e == null) {
            return false;
        }
        Class eClass = e.getClass();
        if ((eClass == this.elementType || eClass.getSuperclass() == this.elementType) && (this.elements & (1 << ((Enum) e).ordinal())) != 0) {
            return true;
        }
        return false;
    }

    public boolean add(E e) {
        typeCheck(e);
        long oldElements = this.elements;
        this.elements |= 1 << e.ordinal();
        return this.elements != oldElements;
    }

    public boolean remove(Object e) {
        if (e == null) {
            return false;
        }
        Class eClass = e.getClass();
        if (eClass != this.elementType && eClass.getSuperclass() != this.elementType) {
            return false;
        }
        long oldElements = this.elements;
        this.elements &= ~(1 << ((Enum) e).ordinal());
        if (this.elements != oldElements) {
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        if (!(c instanceof RegularEnumSet)) {
            return super.containsAll(c);
        }
        RegularEnumSet es = (RegularEnumSet) c;
        if (es.elementType != this.elementType) {
            return es.isEmpty();
        }
        return (es.elements & (~this.elements)) == 0;
    }

    public boolean addAll(Collection<? extends E> c) {
        if (!(c instanceof RegularEnumSet)) {
            return super.addAll(c);
        }
        RegularEnumSet es = (RegularEnumSet) c;
        if (es.elementType == this.elementType) {
            long oldElements = this.elements;
            this.elements |= es.elements;
            if (this.elements != oldElements) {
                return true;
            }
            return false;
        } else if (es.isEmpty()) {
            return false;
        } else {
            throw new ClassCastException(es.elementType + " != " + this.elementType);
        }
    }

    public boolean removeAll(Collection<?> c) {
        if (!(c instanceof RegularEnumSet)) {
            return super.removeAll(c);
        }
        RegularEnumSet es = (RegularEnumSet) c;
        if (es.elementType != this.elementType) {
            return false;
        }
        long oldElements = this.elements;
        this.elements &= ~es.elements;
        if (this.elements != oldElements) {
            return true;
        }
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        if (!(c instanceof RegularEnumSet)) {
            return super.retainAll(c);
        }
        RegularEnumSet<?> es = (RegularEnumSet) c;
        if (es.elementType != this.elementType) {
            boolean changed = this.elements != 0;
            this.elements = 0;
            return changed;
        }
        long oldElements = this.elements;
        this.elements &= es.elements;
        return this.elements != oldElements;
    }

    public void clear() {
        this.elements = 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof RegularEnumSet)) {
            return super.equals(o);
        }
        RegularEnumSet es = (RegularEnumSet) o;
        if (es.elementType != this.elementType) {
            if (this.elements == 0 && es.elements == 0) {
                return true;
            }
            return false;
        } else if (es.elements == this.elements) {
            return true;
        } else {
            return false;
        }
    }
}
