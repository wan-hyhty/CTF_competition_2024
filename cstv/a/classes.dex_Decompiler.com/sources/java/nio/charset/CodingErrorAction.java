package java.nio.charset;

public class CodingErrorAction {
    public static final CodingErrorAction IGNORE = null;
    public static final CodingErrorAction REPLACE = null;
    public static final CodingErrorAction REPORT = null;
    private String name;

    private CodingErrorAction(String name2) {
        this.name = name2;
    }

    public String toString() {
        return this.name;
    }
}
