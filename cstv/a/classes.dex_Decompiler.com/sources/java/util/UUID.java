package java.util;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import sun.security.util.DerValue;
import sun.util.locale.LanguageTag;

public final class UUID implements Serializable, Comparable<UUID> {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f56assertionsDisabled = false;
    private static final long serialVersionUID = -4856846361193249489L;
    private final long leastSigBits;
    private final long mostSigBits;

    private static class Holder {
        static final SecureRandom numberGenerator = null;

        private Holder() {
        }
    }

    private UUID(byte[] data) {
        long msb = 0;
        long lsb = 0;
        if (!f56assertionsDisabled) {
            if (!(data.length == 16 ? true : f56assertionsDisabled)) {
                throw new AssertionError((Object) "data must be 16 bytes in length");
            }
        }
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | ((long) (data[i] & Character.DIRECTIONALITY_UNDEFINED));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            lsb = (lsb << 8) | ((long) (data[i2] & Character.DIRECTIONALITY_UNDEFINED));
        }
        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    public UUID(long mostSigBits2, long leastSigBits2) {
        this.mostSigBits = mostSigBits2;
        this.leastSigBits = leastSigBits2;
    }

    public static UUID randomUUID() {
        byte[] randomBytes = new byte[16];
        Holder.numberGenerator.nextBytes(randomBytes);
        randomBytes[6] = (byte) (randomBytes[6] & 15);
        randomBytes[6] = (byte) (randomBytes[6] | DerValue.TAG_APPLICATION);
        randomBytes[8] = (byte) (randomBytes[8] & 63);
        randomBytes[8] = (byte) (randomBytes[8] | 128);
        return new UUID(randomBytes);
    }

    public static UUID nameUUIDFromBytes(byte[] name) {
        try {
            byte[] md5Bytes = MessageDigest.getInstance("MD5").digest(name);
            md5Bytes[6] = (byte) (md5Bytes[6] & 15);
            md5Bytes[6] = (byte) (md5Bytes[6] | 48);
            md5Bytes[8] = (byte) (md5Bytes[8] & 63);
            md5Bytes[8] = (byte) (md5Bytes[8] | 128);
            return new UUID(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new InternalError("MD5 not supported");
        }
    }

    public static UUID fromString(String name) {
        String[] components = name.split(LanguageTag.SEP);
        if (components.length != 5) {
            throw new IllegalArgumentException("Invalid UUID string: " + name);
        }
        for (int i = 0; i < 5; i++) {
            components[i] = "0x" + components[i];
        }
        return new UUID((((Long.decode(components[0]).longValue() << 16) | Long.decode(components[1]).longValue()) << 16) | Long.decode(components[2]).longValue(), (Long.decode(components[3]).longValue() << 48) | Long.decode(components[4]).longValue());
    }

    public long getLeastSignificantBits() {
        return this.leastSigBits;
    }

    public long getMostSignificantBits() {
        return this.mostSigBits;
    }

    public int version() {
        return (int) ((this.mostSigBits >> 12) & 15);
    }

    public int variant() {
        return (int) ((this.leastSigBits >>> ((int) (64 - (this.leastSigBits >>> 62)))) & (this.leastSigBits >> 63));
    }

    public long timestamp() {
        if (version() == 1) {
            return ((this.mostSigBits & 4095) << 48) | (((this.mostSigBits >> 16) & 65535) << 32) | (this.mostSigBits >>> 32);
        }
        throw new UnsupportedOperationException("Not a time-based UUID");
    }

    public int clockSequence() {
        if (version() == 1) {
            return (int) ((this.leastSigBits & 4611404543450677248L) >>> 48);
        }
        throw new UnsupportedOperationException("Not a time-based UUID");
    }

    public long node() {
        if (version() == 1) {
            return this.leastSigBits & 281474976710655L;
        }
        throw new UnsupportedOperationException("Not a time-based UUID");
    }

    public String toString() {
        return digits(this.mostSigBits >> 32, 8) + LanguageTag.SEP + digits(this.mostSigBits >> 16, 4) + LanguageTag.SEP + digits(this.mostSigBits, 4) + LanguageTag.SEP + digits(this.leastSigBits >> 48, 4) + LanguageTag.SEP + digits(this.leastSigBits, 12);
    }

    private static String digits(long val, int digits) {
        long hi = 1 << (digits * 4);
        return Long.toHexString(((hi - 1) & val) | hi).substring(1);
    }

    public int hashCode() {
        long hilo = this.mostSigBits ^ this.leastSigBits;
        return ((int) (hilo >> 32)) ^ ((int) hilo);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != UUID.class) {
            return f56assertionsDisabled;
        }
        UUID id = (UUID) obj;
        if (this.mostSigBits == id.mostSigBits && this.leastSigBits == id.leastSigBits) {
            return true;
        }
        return f56assertionsDisabled;
    }

    public int compareTo(UUID val) {
        if (this.mostSigBits < val.mostSigBits) {
            return -1;
        }
        if (this.mostSigBits > val.mostSigBits) {
            return 1;
        }
        if (this.leastSigBits < val.leastSigBits) {
            return -1;
        }
        if (this.leastSigBits > val.leastSigBits) {
            return 1;
        }
        return 0;
    }
}
