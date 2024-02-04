package java.lang;

public class ExceptionInInitializerError extends LinkageError {
    private static final long serialVersionUID = 1521711792217232256L;
    private Throwable exception;

    public ExceptionInInitializerError() {
        initCause((Throwable) null);
    }

    public ExceptionInInitializerError(Throwable thrown) {
        initCause((Throwable) null);
        this.exception = thrown;
    }

    public ExceptionInInitializerError(String s) {
        super(s);
        initCause((Throwable) null);
    }

    public Throwable getException() {
        return this.exception;
    }

    public Throwable getCause() {
        return this.exception;
    }
}
