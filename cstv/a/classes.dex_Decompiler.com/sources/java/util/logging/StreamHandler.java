package java.util.logging;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class StreamHandler extends Handler {
    private boolean doneHeader;
    private LogManager manager = LogManager.getLogManager();
    private OutputStream output;
    private Writer writer;

    private void configure() {
        LogManager manager2 = LogManager.getLogManager();
        String cname = getClass().getName();
        setLevel(manager2.getLevelProperty(cname + ".level", Level.INFO));
        setFilter(manager2.getFilterProperty(cname + ".filter", (Filter) null));
        setFormatter(manager2.getFormatterProperty(cname + ".formatter", new SimpleFormatter()));
        try {
            setEncoding(manager2.getStringProperty(cname + ".encoding", (String) null));
        } catch (Exception e) {
            try {
                setEncoding((String) null);
            } catch (Exception e2) {
            }
        }
    }

    public StreamHandler() {
        this.sealed = false;
        configure();
        this.sealed = true;
    }

    public StreamHandler(OutputStream out, Formatter formatter) {
        this.sealed = false;
        configure();
        setFormatter(formatter);
        setOutputStream(out);
        this.sealed = true;
    }

    /* access modifiers changed from: protected */
    public synchronized void setOutputStream(OutputStream out) throws SecurityException {
        if (out == null) {
            throw new NullPointerException();
        }
        flushAndClose();
        this.output = out;
        this.doneHeader = false;
        String encoding = getEncoding();
        if (encoding == null) {
            this.writer = new OutputStreamWriter(this.output);
        } else {
            try {
                this.writer = new OutputStreamWriter(this.output, encoding);
            } catch (UnsupportedEncodingException ex) {
                throw new Error("Unexpected exception " + ex);
            }
        }
    }

    public void setEncoding(String encoding) throws SecurityException, UnsupportedEncodingException {
        super.setEncoding(encoding);
        if (this.output != null) {
            flush();
            if (encoding == null) {
                this.writer = new OutputStreamWriter(this.output);
            } else {
                this.writer = new OutputStreamWriter(this.output, encoding);
            }
        }
    }

    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            try {
                String msg = getFormatter().format(record);
                try {
                    if (!this.doneHeader) {
                        this.writer.write(getFormatter().getHead(this));
                        this.doneHeader = true;
                    }
                    this.writer.write(msg);
                } catch (Exception ex) {
                    reportError((String) null, ex, 1);
                }
            } catch (Exception ex2) {
                reportError((String) null, ex2, 5);
                return;
            }
        } else {
            return;
        }
        return;
    }

    public boolean isLoggable(LogRecord record) {
        if (this.writer == null || record == null) {
            return false;
        }
        return super.isLoggable(record);
    }

    public synchronized void flush() {
        if (this.writer != null) {
            try {
                this.writer.flush();
            } catch (Exception ex) {
                reportError((String) null, ex, 2);
            }
        }
        return;
    }

    private synchronized void flushAndClose() throws SecurityException {
        checkPermission();
        if (this.writer != null) {
            try {
                if (!this.doneHeader) {
                    this.writer.write(getFormatter().getHead(this));
                    this.doneHeader = true;
                }
                this.writer.write(getFormatter().getTail(this));
                this.writer.flush();
                this.writer.close();
            } catch (Exception ex) {
                reportError((String) null, ex, 3);
            }
            this.writer = null;
            this.output = null;
        }
        return;
    }

    public synchronized void close() throws SecurityException {
        flushAndClose();
    }
}
