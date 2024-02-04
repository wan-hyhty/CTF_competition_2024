package java.util.zip;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ZipEntry implements ZipConstants, Cloneable {
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
    String comment;
    long crc = -1;
    long csize = -1;
    long dataOffset;
    byte[] extra;
    int flag = 0;
    int method = -1;
    String name;
    long size = -1;
    long time = -1;

    public ZipEntry(String name2, String comment2, long crc2, long compressedSize, long size2, int compressionMethod, int time2, byte[] extra2, long dataOffset2) {
        this.name = name2;
        this.comment = comment2;
        this.crc = crc2;
        this.csize = compressedSize;
        this.size = size2;
        this.method = compressionMethod;
        this.time = (long) time2;
        this.extra = extra2;
        this.dataOffset = dataOffset2;
    }

    public ZipEntry(String name2) {
        if (name2 == null) {
            throw new NullPointerException();
        } else if (name2.getBytes(StandardCharsets.UTF_8).length > 65535) {
            throw new IllegalArgumentException(name2 + " too long: " + name2.getBytes(StandardCharsets.UTF_8).length);
        } else {
            this.name = name2;
        }
    }

    public ZipEntry(ZipEntry e) {
        this.name = e.name;
        this.time = e.time;
        this.crc = e.crc;
        this.size = e.size;
        this.csize = e.csize;
        this.method = e.method;
        this.flag = e.flag;
        this.extra = e.extra;
        this.comment = e.comment;
        this.dataOffset = e.dataOffset;
    }

    ZipEntry() {
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    public String getName() {
        return this.name;
    }

    public void setTime(long time2) {
        this.time = javaToDosTime(time2);
    }

    public long getTime() {
        if (this.time != -1) {
            return dosToJavaTime(this.time);
        }
        return -1;
    }

    public void setSize(long size2) {
        if (size2 < 0) {
            throw new IllegalArgumentException("invalid entry size");
        }
        this.size = size2;
    }

    public long getSize() {
        return this.size;
    }

    public long getCompressedSize() {
        return this.csize;
    }

    public void setCompressedSize(long csize2) {
        this.csize = csize2;
    }

    public void setCrc(long crc2) {
        if (crc2 < 0 || crc2 > 4294967295L) {
            throw new IllegalArgumentException("invalid entry crc-32");
        }
        this.crc = crc2;
    }

    public long getCrc() {
        return this.crc;
    }

    public void setMethod(int method2) {
        if (method2 == 0 || method2 == 8) {
            this.method = method2;
            return;
        }
        throw new IllegalArgumentException("invalid compression method");
    }

    public int getMethod() {
        return this.method;
    }

    public void setExtra(byte[] extra2) {
        if (extra2 == null || extra2.length <= 65535) {
            this.extra = extra2;
            return;
        }
        throw new IllegalArgumentException("invalid extra field length");
    }

    public byte[] getExtra() {
        return this.extra;
    }

    public void setComment(String comment2) {
        if (comment2 == null) {
            this.comment = null;
        } else if (comment2.getBytes(StandardCharsets.UTF_8).length > 65535) {
            throw new IllegalArgumentException(comment2 + " too long: " + comment2.getBytes(StandardCharsets.UTF_8).length);
        } else {
            this.comment = comment2;
        }
    }

    public String getComment() {
        return this.comment;
    }

    public boolean isDirectory() {
        return this.name.endsWith("/");
    }

    public String toString() {
        return getName();
    }

    private static long dosToJavaTime(long dtime) {
        return new Date((int) (((dtime >> 25) & 127) + 80), (int) (((dtime >> 21) & 15) - 1), (int) ((dtime >> 16) & 31), (int) ((dtime >> 11) & 31), (int) ((dtime >> 5) & 63), (int) ((dtime << 1) & 62)).getTime();
    }

    private static long javaToDosTime(long time2) {
        Date d = new Date(time2);
        int year = d.getYear() + 1900;
        if (year < 1980) {
            return 2162688;
        }
        return (long) (((year - 1980) << 25) | ((d.getMonth() + 1) << 21) | (d.getDate() << 16) | (d.getHours() << 11) | (d.getMinutes() << 5) | (d.getSeconds() >> 1));
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public Object clone() {
        byte[] bArr = null;
        try {
            ZipEntry e = (ZipEntry) super.clone();
            if (this.extra != null) {
                bArr = (byte[]) this.extra.clone();
            }
            e.extra = bArr;
            return e;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError();
        }
    }
}
