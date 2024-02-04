package sun.security.provider.certpath;

import java.security.cert.CertPath;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class X509CertPath extends CertPath {
    private static final String COUNT_ENCODING = "count";
    private static final String PKCS7_ENCODING = "PKCS7";
    private static final String PKIPATH_ENCODING = "PkiPath";
    private static final Collection<String> encodingList = null;
    private static final long serialVersionUID = 4989800333263052980L;
    private List<X509Certificate> certs;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.X509CertPath.<init>(java.io.InputStream):void, dex: classes.dex
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
    public X509CertPath(java.io.InputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.X509CertPath.<init>(java.io.InputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.<init>(java.io.InputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.<init>(java.io.InputStream, java.lang.String):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public X509CertPath(java.io.InputStream r1, java.lang.String r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.<init>(java.io.InputStream, java.lang.String):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.<init>(java.io.InputStream, java.lang.String):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.<init>(java.util.List):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public X509CertPath(java.util.List<? extends java.security.cert.Certificate> r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.<init>(java.util.List):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.<init>(java.util.List):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.X509CertPath.encodePKCS7():byte[], dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    private byte[] encodePKCS7() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.X509CertPath.encodePKCS7():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.encodePKCS7():byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.X509CertPath.encodePKIPATH():byte[], dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    private byte[] encodePKIPATH() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.X509CertPath.encodePKIPATH():byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.encodePKIPATH():byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.provider.certpath.X509CertPath.parsePKCS7(java.io.InputStream):java.util.List<java.security.cert.X509Certificate>, dex: classes.dex in method: sun.security.provider.certpath.X509CertPath.parsePKCS7(java.io.InputStream):java.util.List<java.security.cert.X509Certificate>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.provider.certpath.X509CertPath.parsePKCS7(java.io.InputStream):java.util.List<java.security.cert.X509Certificate>, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 5 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec$33.decode(InstructionCodec.java:728)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 6 more
        */
    private static java.util.List<java.security.cert.X509Certificate> parsePKCS7(java.io.InputStream r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.security.provider.certpath.X509CertPath.parsePKCS7(java.io.InputStream):java.util.List<java.security.cert.X509Certificate>, dex: classes.dex in method: sun.security.provider.certpath.X509CertPath.parsePKCS7(java.io.InputStream):java.util.List<java.security.cert.X509Certificate>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.parsePKCS7(java.io.InputStream):java.util.List");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.parsePKIPATH(java.io.InputStream):java.util.List<java.security.cert.X509Certificate>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private static java.util.List<java.security.cert.X509Certificate> parsePKIPATH(java.io.InputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.parsePKIPATH(java.io.InputStream):java.util.List<java.security.cert.X509Certificate>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.parsePKIPATH(java.io.InputStream):java.util.List");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.readAllBytes(java.io.InputStream):byte[], dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    private static byte[] readAllBytes(java.io.InputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.readAllBytes(java.io.InputStream):byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.readAllBytes(java.io.InputStream):byte[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.X509CertPath.getCertificates():java.util.List<java.security.cert.X509Certificate>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public java.util.List<java.security.cert.X509Certificate> getCertificates() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.X509CertPath.getCertificates():java.util.List<java.security.cert.X509Certificate>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.getCertificates():java.util.List");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.getEncoded(java.lang.String):byte[], dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 5 more
        */
    public byte[] getEncoded(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.X509CertPath.getEncoded(java.lang.String):byte[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.X509CertPath.getEncoded(java.lang.String):byte[]");
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return encodePKIPATH();
    }

    public static Iterator<String> getEncodingsStatic() {
        return encodingList.iterator();
    }

    public Iterator<String> getEncodings() {
        return getEncodingsStatic();
    }
}
