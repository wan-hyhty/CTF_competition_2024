package javax.net.ssl;

import java.net.IDN;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Pattern;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public final class SNIHostName extends SNIServerName {
    private final String hostname;

    private static final class SNIHostNameMatcher extends SNIMatcher {
        private final Pattern pattern;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: javax.net.ssl.SNIHostName.SNIHostNameMatcher.<init>(java.lang.String):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        SNIHostNameMatcher(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: javax.net.ssl.SNIHostName.SNIHostNameMatcher.<init>(java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SNIHostName.SNIHostNameMatcher.<init>(java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: javax.net.ssl.SNIHostName.SNIHostNameMatcher.matches(javax.net.ssl.SNIServerName):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean matches(javax.net.ssl.SNIServerName r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: javax.net.ssl.SNIHostName.SNIHostNameMatcher.matches(javax.net.ssl.SNIServerName):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SNIHostName.SNIHostNameMatcher.matches(javax.net.ssl.SNIServerName):boolean");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SNIHostName(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Server name value of host_name cannot be null"
            java.lang.Object r0 = java.util.Objects.requireNonNull(r3, (java.lang.String) r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 2
            java.lang.String r3 = java.net.IDN.toASCII(r0, r1)
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.US_ASCII
            byte[] r0 = r3.getBytes((java.nio.charset.Charset) r0)
            r1 = 0
            r2.<init>(r1, r0)
            r2.hostname = r3
            r2.checkHostName()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.SNIHostName.<init>(java.lang.String):void");
    }

    public SNIHostName(byte[] encoded) {
        super(0, encoded);
        try {
            this.hostname = IDN.toASCII(StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(encoded)).toString());
            checkHostName();
        } catch (RuntimeException | CharacterCodingException e) {
            throw new IllegalArgumentException("The encoded server name value is invalid", e);
        }
    }

    public String getAsciiName() {
        return this.hostname;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SNIHostName) {
            return this.hostname.equalsIgnoreCase(((SNIHostName) other).hostname);
        }
        return false;
    }

    public int hashCode() {
        return this.hostname.toUpperCase(Locale.ENGLISH).hashCode() + 527;
    }

    public String toString() {
        return "type=host_name (0), value=" + this.hostname;
    }

    public static SNIMatcher createSNIMatcher(String regex) {
        if (regex != null) {
            return new SNIHostNameMatcher(regex);
        }
        throw new NullPointerException("The regular expression cannot be null");
    }

    private void checkHostName() {
        if (this.hostname.isEmpty()) {
            throw new IllegalArgumentException("Server name value of host_name cannot be empty");
        } else if (this.hostname.endsWith(".")) {
            throw new IllegalArgumentException("Server name value of host_name cannot have the trailing dot");
        }
    }
}
