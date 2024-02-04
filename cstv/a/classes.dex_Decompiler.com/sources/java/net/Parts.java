package java.net;

/* compiled from: URL */
class Parts {
    String path;
    String query;
    String ref;

    Parts(String file, String host) {
        String str = null;
        int ind = file.indexOf(35);
        this.ref = ind >= 0 ? file.substring(ind + 1) : str;
        file = ind >= 0 ? file.substring(0, ind) : file;
        int q = file.lastIndexOf(63);
        if (q != -1) {
            this.query = file.substring(q + 1);
            this.path = file.substring(0, q);
        } else {
            this.path = file;
        }
        if (this.path != null && this.path.length() > 0 && this.path.charAt(0) != '/' && host != null && !host.isEmpty()) {
            this.path = '/' + this.path;
        }
    }

    /* access modifiers changed from: package-private */
    public String getPath() {
        return this.path;
    }

    /* access modifiers changed from: package-private */
    public String getQuery() {
        return this.query;
    }

    /* access modifiers changed from: package-private */
    public String getRef() {
        return this.ref;
    }
}
