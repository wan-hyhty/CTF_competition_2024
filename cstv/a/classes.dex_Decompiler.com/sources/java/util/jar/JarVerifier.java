package java.util.jar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import sun.security.util.Debug;
import sun.security.util.ManifestDigester;
import sun.security.util.ManifestEntryVerifier;
import sun.security.util.SignatureFileVerifier;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
class JarVerifier {
    static final Debug debug = null;
    private boolean anyToVerify;
    private ByteArrayOutputStream baos;
    private Object csdomain;
    boolean eagerValidation;
    private Enumeration emptyEnumeration;
    private CodeSigner[] emptySigner;
    private List jarCodeSigners;
    private URL lastURL;
    private Map lastURLMap;
    private volatile ManifestDigester manDig;
    private List manifestDigests;
    byte[] manifestRawBytes;
    private boolean parsingBlockOrSF;
    private boolean parsingMeta;
    private ArrayList pendingBlocks;
    private Hashtable sigFileData;
    private Hashtable sigFileSigners;
    private ArrayList signerCache;
    private Map signerMap;
    private Map signerToCodeSource;
    private Map urlToCodeSourceMap;
    private Hashtable verifiedSigners;

    private static class VerifierCodeSource extends CodeSource {
        Object csdomain;
        Certificate[] vcerts;
        URL vlocation;
        CodeSigner[] vsigners;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.CodeSigner[]):void, dex: classes.dex in method: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.CodeSigner[]):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.CodeSigner[]):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        VerifierCodeSource(java.lang.Object r1, java.net.URL r2, java.security.CodeSigner[] r3) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.CodeSigner[]):void, dex: classes.dex in method: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.CodeSigner[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.CodeSigner[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.cert.Certificate[]):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e8
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        VerifierCodeSource(java.lang.Object r1, java.net.URL r2, java.security.cert.Certificate[] r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.cert.Certificate[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.VerifierCodeSource.<init>(java.lang.Object, java.net.URL, java.security.cert.Certificate[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateCertificates():java.security.cert.Certificate[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        private java.security.cert.Certificate[] getPrivateCertificates() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateCertificates():java.security.cert.Certificate[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateCertificates():java.security.cert.Certificate[]");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateSigners():java.security.CodeSigner[], dex: classes.dex in method: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateSigners():java.security.CodeSigner[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateSigners():java.security.CodeSigner[], dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        public java.security.CodeSigner[] getPrivateSigners() {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateSigners():java.security.CodeSigner[], dex: classes.dex in method: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateSigners():java.security.CodeSigner[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.VerifierCodeSource.getPrivateSigners():java.security.CodeSigner[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.jar.JarVerifier.VerifierCodeSource.equals(java.lang.Object):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public boolean equals(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.jar.JarVerifier.VerifierCodeSource.equals(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.VerifierCodeSource.equals(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.jar.JarVerifier.VerifierCodeSource.isSameDomain(java.lang.Object):boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        boolean isSameDomain(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.jar.JarVerifier.VerifierCodeSource.isSameDomain(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.VerifierCodeSource.isSameDomain(java.lang.Object):boolean");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.jar.JarVerifier.<clinit>():void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.jar.JarVerifier.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.<clinit>():void");
    }

    public JarVerifier(byte[] rawBytes) {
        this.parsingBlockOrSF = false;
        this.parsingMeta = true;
        this.anyToVerify = true;
        this.manifestRawBytes = null;
        this.csdomain = new Object();
        this.urlToCodeSourceMap = new HashMap();
        this.signerToCodeSource = new HashMap();
        this.emptySigner = new CodeSigner[0];
        this.emptyEnumeration = new Enumeration<String>() {
            public boolean hasMoreElements() {
                return false;
            }

            public String nextElement() {
                throw new NoSuchElementException();
            }
        };
        this.manifestRawBytes = rawBytes;
        this.sigFileSigners = new Hashtable();
        this.verifiedSigners = new Hashtable();
        this.sigFileData = new Hashtable(11);
        this.pendingBlocks = new ArrayList();
        this.baos = new ByteArrayOutputStream();
        this.manifestDigests = new ArrayList();
    }

    public void beginEntry(JarEntry je, ManifestEntryVerifier mev) throws IOException {
        if (je != null) {
            if (debug != null) {
                debug.println("beginEntry " + je.getName());
            }
            String name = je.getName();
            if (this.parsingMeta) {
                String uname = name.toUpperCase(Locale.ENGLISH);
                if (uname.startsWith("META-INF/") || uname.startsWith("/META-INF/")) {
                    if (je.isDirectory()) {
                        mev.setEntry((String) null, je);
                        return;
                    } else if (SignatureFileVerifier.isBlockOrSF(uname)) {
                        this.parsingBlockOrSF = true;
                        this.baos.reset();
                        mev.setEntry((String) null, je);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (this.parsingMeta) {
                doneWithMeta();
            }
            if (je.isDirectory()) {
                mev.setEntry((String) null, je);
                return;
            }
            if (name.startsWith("./")) {
                name = name.substring(2);
            }
            if (name.startsWith("/")) {
                name = name.substring(1);
            }
            if (this.sigFileSigners.get(name) != null) {
                mev.setEntry(name, je);
            } else {
                mev.setEntry((String) null, je);
            }
        }
    }

    public void update(int b, ManifestEntryVerifier mev) throws IOException {
        if (b == -1) {
            processEntry(mev);
        } else if (this.parsingBlockOrSF) {
            this.baos.write(b);
        } else {
            mev.update((byte) b);
        }
    }

    public void update(int n, byte[] b, int off, int len, ManifestEntryVerifier mev) throws IOException {
        if (n == -1) {
            processEntry(mev);
        } else if (this.parsingBlockOrSF) {
            this.baos.write(b, off, n);
        } else {
            mev.update(b, off, n);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        if (debug != null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
        debug.println("processEntry caught: " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0110, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0113, code lost:
        if (debug != null) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0115, code lost:
        debug.println("processEntry caught: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013c, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013f, code lost:
        if (debug != null) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0141, code lost:
        debug.println("processEntry caught: " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015f, code lost:
        if (debug != null) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0161, code lost:
        debug.println("processEntry caught: " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processEntry(sun.security.util.ManifestEntryVerifier r14) throws java.io.IOException {
        /*
            r13 = this;
            boolean r10 = r13.parsingBlockOrSF
            if (r10 != 0) goto L_0x0021
            java.util.jar.JarEntry r4 = r14.getEntry()
            if (r4 == 0) goto L_0x0020
            java.security.CodeSigner[] r10 = r4.signers
            if (r10 != 0) goto L_0x0020
            java.util.Hashtable r10 = r13.verifiedSigners
            java.util.Hashtable r11 = r13.sigFileSigners
            java.security.CodeSigner[] r10 = r14.verify(r10, r11)
            r4.signers = r10
            java.security.CodeSigner[] r10 = r4.signers
            java.security.cert.Certificate[] r10 = mapSignersToCertArray(r10)
            r4.certs = r10
        L_0x0020:
            return
        L_0x0021:
            r10 = 0
            r13.parsingBlockOrSF = r10     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            sun.security.util.Debug r10 = debug     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 == 0) goto L_0x0030
            sun.security.util.Debug r10 = debug     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.lang.String r11 = "processEntry: processing block"
            r10.println(r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x0030:
            java.util.jar.JarEntry r10 = r14.getEntry()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.lang.String r10 = r10.getName()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.Locale r11 = java.util.Locale.ENGLISH     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.lang.String r9 = r10.toUpperCase(r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.lang.String r10 = ".SF"
            boolean r10 = r9.endsWith(r10)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 == 0) goto L_0x00ad
            int r10 = r9.length()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            int r10 = r10 + -3
            r11 = 0
            java.lang.String r5 = r9.substring(r11, r10)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.io.ByteArrayOutputStream r10 = r13.baos     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            byte[] r0 = r10.toByteArray()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.Hashtable r10 = r13.sigFileData     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r10.put(r5, r0)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.ArrayList r10 = r13.pendingBlocks     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.Iterator r3 = r10.iterator()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x0063:
            boolean r10 = r3.hasNext()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 == 0) goto L_0x00ac
            java.lang.Object r8 = r3.next()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            sun.security.util.SignatureFileVerifier r8 = (sun.security.util.SignatureFileVerifier) r8     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            boolean r10 = r8.needSignatureFile(r5)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 == 0) goto L_0x0063
            sun.security.util.Debug r10 = debug     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 == 0) goto L_0x0081
            sun.security.util.Debug r10 = debug     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.lang.String r11 = "processEntry: processing pending block"
            r10.println(r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x0081:
            r8.setSignatureFile(r0)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.Hashtable r10 = r13.sigFileSigners     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.List r11 = r13.manifestDigests     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r8.process(r10, r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            goto L_0x0063
        L_0x008c:
            r2 = move-exception
            sun.security.util.Debug r10 = debug
            if (r10 == 0) goto L_0x0020
            sun.security.util.Debug r10 = debug
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "processEntry caught: "
            java.lang.StringBuilder r11 = r11.append((java.lang.String) r12)
            java.lang.StringBuilder r11 = r11.append((java.lang.Object) r2)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
            goto L_0x0020
        L_0x00ac:
            return
        L_0x00ad:
            java.lang.String r10 = "."
            int r10 = r9.lastIndexOf((java.lang.String) r10)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r11 = 0
            java.lang.String r5 = r9.substring(r11, r10)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.ArrayList r10 = r13.signerCache     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 != 0) goto L_0x00c4
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r10.<init>()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r13.signerCache = r10     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x00c4:
            sun.security.util.ManifestDigester r10 = r13.manDig     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 != 0) goto L_0x00dc
            byte[] r11 = r13.manifestRawBytes     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            monitor-enter(r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            sun.security.util.ManifestDigester r10 = r13.manDig     // Catch:{ all -> 0x010d }
            if (r10 != 0) goto L_0x00db
            sun.security.util.ManifestDigester r10 = new sun.security.util.ManifestDigester     // Catch:{ all -> 0x010d }
            byte[] r12 = r13.manifestRawBytes     // Catch:{ all -> 0x010d }
            r10.<init>(r12)     // Catch:{ all -> 0x010d }
            r13.manDig = r10     // Catch:{ all -> 0x010d }
            r10 = 0
            r13.manifestRawBytes = r10     // Catch:{ all -> 0x010d }
        L_0x00db:
            monitor-exit(r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x00dc:
            sun.security.util.SignatureFileVerifier r8 = new sun.security.util.SignatureFileVerifier     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.ArrayList r10 = r13.signerCache     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            sun.security.util.ManifestDigester r11 = r13.manDig     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.io.ByteArrayOutputStream r12 = r13.baos     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            byte[] r12 = r12.toByteArray()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r8.<init>(r10, r11, r9, r12)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            boolean r10 = r8.needSignatureFileBytes()     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 == 0) goto L_0x0133
            java.util.Hashtable r10 = r13.sigFileData     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.lang.Object r0 = r10.get(r5)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            byte[] r0 = (byte[]) r0     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r0 != 0) goto L_0x0130
            sun.security.util.Debug r10 = debug     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            if (r10 == 0) goto L_0x0107
            sun.security.util.Debug r10 = debug     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.lang.String r11 = "adding pending block"
            r10.println(r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x0107:
            java.util.ArrayList r10 = r13.pendingBlocks     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r10.add(r8)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            return
        L_0x010d:
            r10 = move-exception
            monitor-exit(r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            throw r10     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x0110:
            r7 = move-exception
            sun.security.util.Debug r10 = debug
            if (r10 == 0) goto L_0x0020
            sun.security.util.Debug r10 = debug
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "processEntry caught: "
            java.lang.StringBuilder r11 = r11.append((java.lang.String) r12)
            java.lang.StringBuilder r11 = r11.append((java.lang.Object) r7)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
            goto L_0x0020
        L_0x0130:
            r8.setSignatureFile(r0)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
        L_0x0133:
            java.util.Hashtable r10 = r13.sigFileSigners     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            java.util.List r11 = r13.manifestDigests     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            r8.process(r10, r11)     // Catch:{ IOException -> 0x008c, SignatureException -> 0x0110, NoSuchAlgorithmException -> 0x013c, CertificateException -> 0x015c }
            goto L_0x0020
        L_0x013c:
            r6 = move-exception
            sun.security.util.Debug r10 = debug
            if (r10 == 0) goto L_0x0020
            sun.security.util.Debug r10 = debug
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "processEntry caught: "
            java.lang.StringBuilder r11 = r11.append((java.lang.String) r12)
            java.lang.StringBuilder r11 = r11.append((java.lang.Object) r6)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
            goto L_0x0020
        L_0x015c:
            r1 = move-exception
            sun.security.util.Debug r10 = debug
            if (r10 == 0) goto L_0x0020
            sun.security.util.Debug r10 = debug
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "processEntry caught: "
            java.lang.StringBuilder r11 = r11.append((java.lang.String) r12)
            java.lang.StringBuilder r11 = r11.append((java.lang.Object) r1)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.processEntry(sun.security.util.ManifestEntryVerifier):void");
    }

    @Deprecated
    public Certificate[] getCerts(String name) {
        return mapSignersToCertArray(getCodeSigners(name));
    }

    public Certificate[] getCerts(JarFile jar, JarEntry entry) {
        return mapSignersToCertArray(getCodeSigners(jar, entry));
    }

    public CodeSigner[] getCodeSigners(String name) {
        return (CodeSigner[]) this.verifiedSigners.get(name);
    }

    public CodeSigner[] getCodeSigners(JarFile jar, JarEntry entry) {
        String name = entry.getName();
        if (this.eagerValidation && this.sigFileSigners.get(name) != null) {
            try {
                InputStream s = jar.getInputStream(entry);
                byte[] buffer = new byte[1024];
                for (int n = buffer.length; n != -1; n = s.read(buffer, 0, buffer.length)) {
                }
                s.close();
            } catch (IOException e) {
            }
        }
        return getCodeSigners(name);
    }

    private static Certificate[] mapSignersToCertArray(CodeSigner[] signers) {
        if (signers == null) {
            return null;
        }
        ArrayList certChains = new ArrayList();
        for (CodeSigner signerCertPath : signers) {
            certChains.addAll(signerCertPath.getSignerCertPath().getCertificates());
        }
        return (Certificate[]) certChains.toArray(new Certificate[certChains.size()]);
    }

    /* access modifiers changed from: package-private */
    public boolean nothingToVerify() {
        return !this.anyToVerify;
    }

    /* access modifiers changed from: package-private */
    public void doneWithMeta() {
        boolean z = false;
        this.parsingMeta = false;
        if (!this.sigFileSigners.isEmpty()) {
            z = true;
        }
        this.anyToVerify = z;
        this.baos = null;
        this.sigFileData = null;
        this.pendingBlocks = null;
        this.signerCache = null;
        this.manDig = null;
        if (this.sigFileSigners.containsKey(JarFile.MANIFEST_NAME)) {
            this.verifiedSigners.put(JarFile.MANIFEST_NAME, this.sigFileSigners.remove(JarFile.MANIFEST_NAME));
        }
    }

    static class VerifierStream extends InputStream {
        private InputStream is;
        private JarVerifier jv;
        private ManifestEntryVerifier mev;
        private long numLeft;

        VerifierStream(Manifest man, JarEntry je, InputStream is2, JarVerifier jv2) throws IOException {
            if (is2 == null) {
                throw new NullPointerException("is == null");
            }
            this.is = is2;
            this.jv = jv2;
            this.mev = new ManifestEntryVerifier(man);
            this.jv.beginEntry(je, this.mev);
            this.numLeft = je.getSize();
            if (this.numLeft == 0) {
                this.jv.update(-1, this.mev);
            }
        }

        public int read() throws IOException {
            if (this.is == null) {
                throw new IOException("stream closed");
            } else if (this.numLeft <= 0) {
                return -1;
            } else {
                int b = this.is.read();
                this.jv.update(b, this.mev);
                this.numLeft--;
                if (this.numLeft == 0) {
                    this.jv.update(-1, this.mev);
                }
                return b;
            }
        }

        public int read(byte[] b, int off, int len) throws IOException {
            if (this.is == null) {
                throw new IOException("stream closed");
            }
            if (this.numLeft > 0 && this.numLeft < ((long) len)) {
                len = (int) this.numLeft;
            }
            if (this.numLeft <= 0) {
                return -1;
            }
            int n = this.is.read(b, off, len);
            this.jv.update(n, b, off, len, this.mev);
            this.numLeft -= (long) n;
            if (this.numLeft == 0) {
                this.jv.update(-1, b, off, len, this.mev);
            }
            return n;
        }

        public void close() throws IOException {
            if (this.is != null) {
                this.is.close();
            }
            this.is = null;
            this.mev = null;
            this.jv = null;
        }

        public int available() throws IOException {
            if (this.is != null) {
                return this.is.available();
            }
            throw new IOException("stream closed");
        }
    }

    private synchronized CodeSource mapSignersToCodeSource(URL url, CodeSigner[] signers) {
        Map map;
        CodeSource cs;
        if (url == this.lastURL) {
            map = this.lastURLMap;
        } else {
            map = (Map) this.urlToCodeSourceMap.get(url);
            if (map == null) {
                map = new HashMap();
                this.urlToCodeSourceMap.put(url, map);
            }
            this.lastURLMap = map;
            this.lastURL = url;
        }
        cs = (CodeSource) map.get(signers);
        if (cs == null) {
            cs = new VerifierCodeSource(this.csdomain, url, signers);
            this.signerToCodeSource.put(signers, cs);
        }
        return cs;
    }

    private CodeSource[] mapSignersToCodeSources(URL url, List signers, boolean unsigned) {
        List sources = new ArrayList();
        for (int i = 0; i < signers.size(); i++) {
            sources.add(mapSignersToCodeSource(url, (CodeSigner[]) signers.get(i)));
        }
        if (unsigned) {
            sources.add(mapSignersToCodeSource(url, (CodeSigner[]) null));
        }
        return (CodeSource[]) sources.toArray(new CodeSource[sources.size()]);
    }

    private CodeSigner[] findMatchingSigners(CodeSource cs) {
        if ((cs instanceof VerifierCodeSource) && ((VerifierCodeSource) cs).isSameDomain(this.csdomain)) {
            return ((VerifierCodeSource) cs).getPrivateSigners();
        }
        CodeSource[] sources = mapSignersToCodeSources(cs.getLocation(), getJarCodeSigners(), true);
        List sourceList = new ArrayList();
        for (CodeSource add : sources) {
            sourceList.add(add);
        }
        int j = sourceList.indexOf(cs);
        if (j == -1) {
            return null;
        }
        CodeSigner[] match = ((VerifierCodeSource) sourceList.get(j)).getPrivateSigners();
        if (match == null) {
            return this.emptySigner;
        }
        return match;
    }

    private synchronized Map signerMap() {
        if (this.signerMap == null) {
            this.signerMap = new HashMap(this.verifiedSigners.size() + this.sigFileSigners.size());
            this.signerMap.putAll(this.verifiedSigners);
            this.signerMap.putAll(this.sigFileSigners);
        }
        return this.signerMap;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public synchronized java.util.Enumeration<java.lang.String> entryNames(java.util.jar.JarFile r10, java.security.CodeSource[] r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.Map r3 = r9.signerMap()     // Catch:{ all -> 0x003c }
            java.util.Set r8 = r3.entrySet()     // Catch:{ all -> 0x003c }
            java.util.Iterator r2 = r8.iterator()     // Catch:{ all -> 0x003c }
            r5 = 0
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x003c }
            int r8 = r11.length     // Catch:{ all -> 0x003c }
            r6.<init>((int) r8)     // Catch:{ all -> 0x003c }
            r1 = 0
        L_0x0015:
            int r8 = r11.length     // Catch:{ all -> 0x003c }
            if (r1 >= r8) goto L_0x002b
            r8 = r11[r1]     // Catch:{ all -> 0x003c }
            java.security.CodeSigner[] r4 = r9.findMatchingSigners(r8)     // Catch:{ all -> 0x003c }
            if (r4 == 0) goto L_0x0026
            int r8 = r4.length     // Catch:{ all -> 0x003c }
            if (r8 <= 0) goto L_0x0029
            r6.add(r4)     // Catch:{ all -> 0x003c }
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x0015
        L_0x0029:
            r5 = 1
            goto L_0x0026
        L_0x002b:
            r7 = r6
            if (r5 == 0) goto L_0x0039
            java.util.Enumeration r0 = r9.unsignedEntryNames(r10)     // Catch:{ all -> 0x003c }
        L_0x0032:
            java.util.jar.JarVerifier$2 r8 = new java.util.jar.JarVerifier$2     // Catch:{ all -> 0x003c }
            r8.<init>(r9, r2, r6, r0)     // Catch:{ all -> 0x003c }
            monitor-exit(r9)
            return r8
        L_0x0039:
            java.util.Enumeration r0 = r9.emptyEnumeration     // Catch:{ all -> 0x003c }
            goto L_0x0032
        L_0x003c:
            r8 = move-exception
            monitor-exit(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.entryNames(java.util.jar.JarFile, java.security.CodeSource[]):java.util.Enumeration");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public java.util.Enumeration<java.util.jar.JarEntry> entries2(java.util.jar.JarFile r4, java.util.Enumeration r5) {
        /*
            r3 = this;
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r2 = r3.signerMap()
            r1.putAll(r2)
            r0 = r5
            java.util.jar.JarVerifier$3 r2 = new java.util.jar.JarVerifier$3
            r2.<init>(r3, r5, r4, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.entries2(java.util.jar.JarFile, java.util.Enumeration):java.util.Enumeration");
    }

    static boolean isSigningRelated(String name) {
        String name2 = name.toUpperCase(Locale.ENGLISH);
        if (!name2.startsWith("META-INF/")) {
            return false;
        }
        String name3 = name2.substring(9);
        if (name3.indexOf(47) != -1) {
            return false;
        }
        if (name3.endsWith(".DSA") || name3.endsWith(".RSA") || name3.endsWith(".SF") || name3.endsWith(".EC") || name3.startsWith("SIG-") || name3.equals("MANIFEST.MF")) {
            return true;
        }
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private java.util.Enumeration<java.lang.String> unsignedEntryNames(java.util.jar.JarFile r4) {
        /*
            r3 = this;
            java.util.Map r1 = r3.signerMap()
            java.util.Enumeration r0 = r4.entries()
            java.util.jar.JarVerifier$4 r2 = new java.util.jar.JarVerifier$4
            r2.<init>(r3, r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarVerifier.unsignedEntryNames(java.util.jar.JarFile):java.util.Enumeration");
    }

    private synchronized List getJarCodeSigners() {
        if (this.jarCodeSigners == null) {
            HashSet set = new HashSet();
            set.addAll(signerMap().values());
            this.jarCodeSigners = new ArrayList();
            this.jarCodeSigners.addAll(set);
        }
        return this.jarCodeSigners;
    }

    public synchronized CodeSource[] getCodeSources(JarFile jar, URL url) {
        return mapSignersToCodeSources(url, getJarCodeSigners(), unsignedEntryNames(jar).hasMoreElements());
    }

    public CodeSource getCodeSource(URL url, String name) {
        return mapSignersToCodeSource(url, (CodeSigner[]) signerMap().get(name));
    }

    public CodeSource getCodeSource(URL url, JarFile jar, JarEntry je) {
        return mapSignersToCodeSource(url, getCodeSigners(jar, je));
    }

    public void setEagerValidation(boolean eager) {
        this.eagerValidation = eager;
    }

    public synchronized List getManifestDigests() {
        return Collections.unmodifiableList(this.manifestDigests);
    }

    static CodeSource getUnsignedCS(URL url) {
        return new VerifierCodeSource((Object) null, url, (Certificate[]) null);
    }
}
