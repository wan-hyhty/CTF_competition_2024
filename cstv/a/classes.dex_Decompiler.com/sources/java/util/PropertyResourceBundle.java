package java.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import sun.util.ResourceBundleEnumeration;

public class PropertyResourceBundle extends ResourceBundle {
    private Map<String, Object> lookup;

    public PropertyResourceBundle(InputStream stream) throws IOException {
        Properties properties = new Properties();
        properties.load(stream);
        this.lookup = new HashMap(properties);
    }

    public PropertyResourceBundle(Reader reader) throws IOException {
        Properties properties = new Properties();
        properties.load(reader);
        this.lookup = new HashMap(properties);
    }

    public Object handleGetObject(String key) {
        if (key != null) {
            return this.lookup.get(key);
        }
        throw new NullPointerException();
    }

    public Enumeration<String> getKeys() {
        Enumeration<String> enumeration = null;
        ResourceBundle parent = this.parent;
        Set<String> keySet = this.lookup.keySet();
        if (parent != null) {
            enumeration = parent.getKeys();
        }
        return new ResourceBundleEnumeration(keySet, enumeration);
    }

    /* access modifiers changed from: protected */
    public Set<String> handleKeySet() {
        return this.lookup.keySet();
    }
}
