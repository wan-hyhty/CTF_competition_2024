package java.lang;

public class ClassNotFoundException extends ReflectiveOperationException {
    private static final long serialVersionUID = 9176873029745254542L;
    private Throwable ex;

    public ClassNotFoundException() {
        super((Throwable) null);
    }

    public ClassNotFoundException(String s) {
        super(s, (Throwable) null);
    }

    public ClassNotFoundException(String s, Throwable ex2) {
        super(s, (Throwable) null);
        this.ex = ex2;
    }

    public Throwable getException() {
        return this.ex;
    }

    public Throwable getCause() {
        return this.ex;
    }
}
