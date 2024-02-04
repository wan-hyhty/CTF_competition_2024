package java.util;

import java.io.Serializable;

public class EventObject implements Serializable {
    private static final long serialVersionUID = 5516075349620653480L;
    protected transient Object source;

    public EventObject(Object source2) {
        if (source2 == null) {
            throw new IllegalArgumentException("null source");
        }
        this.source = source2;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        return getClass().getName() + "[source=" + this.source + "]";
    }
}
