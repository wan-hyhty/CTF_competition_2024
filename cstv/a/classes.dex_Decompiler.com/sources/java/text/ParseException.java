package java.text;

public class ParseException extends Exception {
    private int errorOffset;

    public ParseException(String s, int errorOffset2) {
        super(s);
        this.errorOffset = errorOffset2;
    }

    public int getErrorOffset() {
        return this.errorOffset;
    }
}
