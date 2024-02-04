package java.beans;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

public class PropertyChangeSupport implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = null;
    static final long serialVersionUID = 6401253773779951803L;
    private PropertyChangeListenerMap map = new PropertyChangeListenerMap((PropertyChangeListenerMap) null);
    private Object source;

    public PropertyChangeSupport(Object sourceBean) {
        if (sourceBean == null) {
            throw new NullPointerException();
        }
        this.source = sourceBean;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null) {
            if (listener instanceof PropertyChangeListenerProxy) {
                PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) listener;
                addPropertyChangeListener(proxy.getPropertyName(), (PropertyChangeListener) proxy.getListener());
                return;
            }
            this.map.add((String) null, listener);
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null) {
            if (listener instanceof PropertyChangeListenerProxy) {
                PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) listener;
                removePropertyChangeListener(proxy.getPropertyName(), (PropertyChangeListener) proxy.getListener());
                return;
            }
            this.map.remove((String) null, listener);
        }
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        return (PropertyChangeListener[]) this.map.getListeners();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        PropertyChangeListener listener2;
        if (listener != null && propertyName != null && (listener2 = this.map.extract(listener)) != null) {
            this.map.add(propertyName, listener2);
        }
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        PropertyChangeListener listener2;
        if (listener != null && propertyName != null && (listener2 = this.map.extract(listener)) != null) {
            this.map.remove(propertyName, listener2);
        }
    }

    public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
        return (PropertyChangeListener[]) this.map.getListeners(propertyName);
    }

    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            firePropertyChange(new PropertyChangeEvent(this.source, propertyName, oldValue, newValue));
        }
    }

    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        if (oldValue != newValue) {
            firePropertyChange(propertyName, (Object) Integer.valueOf(oldValue), (Object) Integer.valueOf(newValue));
        }
    }

    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        if (oldValue != newValue) {
            firePropertyChange(propertyName, (Object) Boolean.valueOf(oldValue), (Object) Boolean.valueOf(newValue));
        }
    }

    public void firePropertyChange(PropertyChangeEvent event) {
        PropertyChangeListener[] propertyChangeListenerArr;
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            String name = event.getPropertyName();
            PropertyChangeListener[] common = (PropertyChangeListener[]) this.map.get((String) null);
            if (name != null) {
                propertyChangeListenerArr = (PropertyChangeListener[]) this.map.get(name);
            } else {
                propertyChangeListenerArr = null;
            }
            fire(common, event);
            fire(propertyChangeListenerArr, event);
        }
    }

    private static void fire(PropertyChangeListener[] listeners, PropertyChangeEvent event) {
        if (listeners != null) {
            for (PropertyChangeListener listener : listeners) {
                listener.propertyChange(event);
            }
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue) {
        if (oldValue == null || newValue == null || !oldValue.equals(newValue)) {
            firePropertyChange(new IndexedPropertyChangeEvent(this.source, propertyName, oldValue, newValue, index));
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, int oldValue, int newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index, (Object) Integer.valueOf(oldValue), (Object) Integer.valueOf(newValue));
        }
    }

    public void fireIndexedPropertyChange(String propertyName, int index, boolean oldValue, boolean newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index, (Object) Boolean.valueOf(oldValue), (Object) Boolean.valueOf(newValue));
        }
    }

    public boolean hasListeners(String propertyName) {
        return this.map.hasListeners(propertyName);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.beans.PropertyChangeListener[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r5 = r16.putFields();
        r5.put("children", (java.lang.Object) r2);
        r5.put("source", r15.source);
        r5.put("propertyChangeSupportSerializedDataVersion", 2);
        r16.writeFields();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r7 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        r10 = 0;
        r11 = r7.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        if (r10 >= r11) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        r6 = r7[r10];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        if ((r6 instanceof java.io.Serializable) == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        r16.writeObject(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        r16.writeObject((java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeObject(java.io.ObjectOutputStream r16) throws java.io.IOException {
        /*
            r15 = this;
            r14 = 0
            r1 = 0
            r7 = 0
            java.beans.PropertyChangeSupport$PropertyChangeListenerMap r11 = r15.map
            monitor-enter(r11)
            java.beans.PropertyChangeSupport$PropertyChangeListenerMap r10 = r15.map     // Catch:{ all -> 0x004e }
            java.util.Set r10 = r10.getEntries()     // Catch:{ all -> 0x004e }
            java.util.Iterator r4 = r10.iterator()     // Catch:{ all -> 0x004e }
            r2 = r1
        L_0x0011:
            boolean r10 = r4.hasNext()     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x0051
            java.lang.Object r3 = r4.next()     // Catch:{ all -> 0x0088 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r9 = r3.getKey()     // Catch:{ all -> 0x0088 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0088 }
            if (r9 != 0) goto L_0x0030
            java.lang.Object r10 = r3.getValue()     // Catch:{ all -> 0x0088 }
            r0 = r10
            java.beans.PropertyChangeListener[] r0 = (java.beans.PropertyChangeListener[]) r0     // Catch:{ all -> 0x0088 }
            r7 = r0
            r1 = r2
        L_0x002e:
            r2 = r1
            goto L_0x0011
        L_0x0030:
            if (r2 != 0) goto L_0x008b
            java.util.Hashtable r1 = new java.util.Hashtable     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
        L_0x0037:
            java.beans.PropertyChangeSupport r8 = new java.beans.PropertyChangeSupport     // Catch:{ all -> 0x004e }
            java.lang.Object r10 = r15.source     // Catch:{ all -> 0x004e }
            r8.<init>(r10)     // Catch:{ all -> 0x004e }
            java.beans.PropertyChangeSupport$PropertyChangeListenerMap r12 = r8.map     // Catch:{ all -> 0x004e }
            java.lang.Object r10 = r3.getValue()     // Catch:{ all -> 0x004e }
            java.beans.PropertyChangeListener[] r10 = (java.beans.PropertyChangeListener[]) r10     // Catch:{ all -> 0x004e }
            r13 = 0
            r12.set(r13, r10)     // Catch:{ all -> 0x004e }
            r1.put(r9, r8)     // Catch:{ all -> 0x004e }
            goto L_0x002e
        L_0x004e:
            r10 = move-exception
        L_0x004f:
            monitor-exit(r11)
            throw r10
        L_0x0051:
            monitor-exit(r11)
            java.io.ObjectOutputStream$PutField r5 = r16.putFields()
            java.lang.String r10 = "children"
            r5.put((java.lang.String) r10, (java.lang.Object) r2)
            java.lang.String r10 = "source"
            java.lang.Object r11 = r15.source
            r5.put((java.lang.String) r10, (java.lang.Object) r11)
            java.lang.String r10 = "propertyChangeSupportSerializedDataVersion"
            r11 = 2
            r5.put((java.lang.String) r10, (int) r11)
            r16.writeFields()
            if (r7 == 0) goto L_0x0082
            r10 = 0
            int r11 = r7.length
        L_0x0072:
            if (r10 >= r11) goto L_0x0082
            r6 = r7[r10]
            boolean r12 = r6 instanceof java.io.Serializable
            if (r12 == 0) goto L_0x007f
            r0 = r16
            r0.writeObject(r6)
        L_0x007f:
            int r10 = r10 + 1
            goto L_0x0072
        L_0x0082:
            r0 = r16
            r0.writeObject(r14)
            return
        L_0x0088:
            r10 = move-exception
            r1 = r2
            goto L_0x004f
        L_0x008b:
            r1 = r2
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: java.beans.PropertyChangeSupport.writeObject(java.io.ObjectOutputStream):void");
    }

    private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
        this.map = new PropertyChangeListenerMap((PropertyChangeListenerMap) null);
        ObjectInputStream.GetField fields = s.readFields();
        Hashtable<String, PropertyChangeSupport> children = (Hashtable) fields.get("children", (Object) null);
        this.source = fields.get("source", (Object) null);
        fields.get("propertyChangeSupportSerializedDataVersion", 2);
        while (true) {
            Object listenerOrNull = s.readObject();
            if (listenerOrNull == null) {
                break;
            }
            this.map.add((String) null, (PropertyChangeListener) listenerOrNull);
        }
        if (children != null) {
            for (Map.Entry<String, PropertyChangeSupport> entry : children.entrySet()) {
                for (PropertyChangeListener listener : entry.getValue().getPropertyChangeListeners()) {
                    this.map.add(entry.getKey(), listener);
                }
            }
        }
    }

    private static final class PropertyChangeListenerMap extends ChangeListenerMap<PropertyChangeListener> {
        private static final PropertyChangeListener[] EMPTY = null;

        /* synthetic */ PropertyChangeListenerMap(PropertyChangeListenerMap propertyChangeListenerMap) {
            this();
        }

        private PropertyChangeListenerMap() {
        }

        /* access modifiers changed from: protected */
        public PropertyChangeListener[] newArray(int length) {
            if (length > 0) {
                return new PropertyChangeListener[length];
            }
            return EMPTY;
        }

        /* access modifiers changed from: protected */
        public PropertyChangeListener newProxy(String name, PropertyChangeListener listener) {
            return new PropertyChangeListenerProxy(name, listener);
        }

        public final PropertyChangeListener extract(PropertyChangeListener listener) {
            while (listener instanceof PropertyChangeListenerProxy) {
                listener = (PropertyChangeListener) ((PropertyChangeListenerProxy) listener).getListener();
            }
            return listener;
        }
    }
}
