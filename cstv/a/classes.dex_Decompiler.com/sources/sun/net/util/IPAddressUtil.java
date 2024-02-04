package sun.net.util;

public class IPAddressUtil {
    private static final int INADDR16SZ = 16;
    private static final int INADDR4SZ = 4;
    private static final int INT16SZ = 2;

    public static byte[] textToNumericFormatV4(String src) {
        if (src.length() == 0) {
            return null;
        }
        byte[] res = new byte[4];
        String[] s = src.split("\\.", -1);
        try {
            switch (s.length) {
                case 4:
                    for (int i = 0; i < 4; i++) {
                        long val = (long) Integer.parseInt(s[i]);
                        if (val < 0 || val > 255) {
                            return null;
                        }
                        res[i] = (byte) ((int) (val & 255));
                    }
                    return res;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static byte[] textToNumericFormatV6(String src) {
        int j;
        byte[] v4addr;
        if (src.length() < 2) {
            return null;
        }
        char[] srcb = src.toCharArray();
        byte[] dst = new byte[16];
        int srcb_length = srcb.length;
        int pc = src.indexOf("%");
        if (pc == srcb_length - 1) {
            return null;
        }
        if (pc != -1) {
            srcb_length = pc;
        }
        int colonp = -1;
        int i = 0;
        if (srcb[0] == ':') {
            i = 1;
            if (srcb[1] != ':') {
                return null;
            }
        }
        int curtok = i;
        boolean saw_xdigit = false;
        int val = 0;
        int j2 = 0;
        while (true) {
            int i2 = i;
            if (i2 >= srcb_length) {
                break;
            }
            i = i2 + 1;
            char ch = srcb[i2];
            int chval = Character.digit(ch, 16);
            if (chval != -1) {
                val = (val << 4) | chval;
                if (val > 65535) {
                    return null;
                }
                saw_xdigit = true;
            } else if (ch == ':') {
                curtok = i;
                if (!saw_xdigit) {
                    if (colonp != -1) {
                        return null;
                    }
                    colonp = j2;
                } else if (i == srcb_length || j2 + 2 > 16) {
                    return null;
                } else {
                    int j3 = j2 + 1;
                    dst[j2] = (byte) ((val >> 8) & 255);
                    j2 = j3 + 1;
                    dst[j3] = (byte) (val & 255);
                    saw_xdigit = false;
                    val = 0;
                }
            } else if (ch != '.' || j2 + 4 > 16) {
                return null;
            } else {
                String ia4 = src.substring(curtok, srcb_length);
                int dot_count = 0;
                int index = 0;
                while (true) {
                    int index2 = ia4.indexOf(46, index);
                    if (index2 == -1) {
                        break;
                    }
                    dot_count++;
                    index = index2 + 1;
                }
                if (dot_count != 3 || (v4addr = textToNumericFormatV4(ia4)) == null) {
                    return null;
                }
                int k = 0;
                while (k < 4) {
                    dst[j2] = v4addr[k];
                    k++;
                    j2++;
                }
                saw_xdigit = false;
            }
        }
        if (!saw_xdigit) {
            j = j2;
        } else if (j2 + 2 > 16) {
            return null;
        } else {
            int j4 = j2 + 1;
            dst[j2] = (byte) ((val >> 8) & 255);
            dst[j4] = (byte) (val & 255);
            j = j4 + 1;
        }
        if (colonp != -1) {
            int n = j - colonp;
            if (j == 16) {
                return null;
            }
            for (int i3 = 1; i3 <= n; i3++) {
                dst[16 - i3] = dst[(colonp + n) - i3];
                dst[(colonp + n) - i3] = 0;
            }
            j = 16;
        }
        if (j != 16) {
            return null;
        }
        byte[] newdst = convertFromIPv4MappedAddress(dst);
        if (newdst != null) {
            return newdst;
        }
        return dst;
    }

    public static boolean isIPv4LiteralAddress(String src) {
        return textToNumericFormatV4(src) != null;
    }

    public static boolean isIPv6LiteralAddress(String src) {
        return textToNumericFormatV6(src) != null;
    }

    public static byte[] convertFromIPv4MappedAddress(byte[] addr) {
        if (!isIPv4MappedAddress(addr)) {
            return null;
        }
        byte[] newAddr = new byte[4];
        System.arraycopy(addr, 12, newAddr, 0, 4);
        return newAddr;
    }

    private static boolean isIPv4MappedAddress(byte[] addr) {
        return addr.length >= 16 && addr[0] == 0 && addr[1] == 0 && addr[2] == 0 && addr[3] == 0 && addr[4] == 0 && addr[5] == 0 && addr[6] == 0 && addr[7] == 0 && addr[8] == 0 && addr[9] == 0 && addr[10] == -1 && addr[11] == -1;
    }
}
