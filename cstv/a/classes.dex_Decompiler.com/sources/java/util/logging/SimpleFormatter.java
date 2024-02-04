package java.util.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

public class SimpleFormatter extends Formatter {
    private static final String format = null;
    private final Date dat = new Date();

    public synchronized String format(LogRecord record) {
        String source;
        String message;
        String throwable;
        this.dat.setTime(record.getMillis());
        if (record.getSourceClassName() != null) {
            source = record.getSourceClassName();
            if (record.getSourceMethodName() != null) {
                source = source + " " + record.getSourceMethodName();
            }
        } else {
            source = record.getLoggerName();
        }
        message = formatMessage(record);
        throwable = "";
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter((Writer) sw);
            pw.println();
            record.getThrown().printStackTrace(pw);
            pw.close();
            throwable = sw.toString();
        }
        return String.format(format, this.dat, source, record.getLoggerName(), record.getLevel().getLocalizedLevelName(), message, throwable);
    }
}
