package java.security.cert;

import java.util.Date;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public class CertificateRevokedException extends CertificateException {
    private static final long serialVersionUID = 7839996631571608627L;
    private final X500Principal authority;
    private transient Map<String, Extension> extensions;
    private final CRLReason reason;
    private Date revocationDate;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.<init>(java.util.Date, java.security.cert.CRLReason, javax.security.auth.x500.X500Principal, java.util.Map):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public CertificateRevokedException(java.util.Date r1, java.security.cert.CRLReason r2, javax.security.auth.x500.X500Principal r3, java.util.Map<java.lang.String, java.security.cert.Extension> r4) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.<init>(java.util.Date, java.security.cert.CRLReason, javax.security.auth.x500.X500Principal, java.util.Map):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.<init>(java.util.Date, java.security.cert.CRLReason, javax.security.auth.x500.X500Principal, java.util.Map):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.readObject(java.io.ObjectInputStream):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    private void readObject(java.io.ObjectInputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.readObject(java.io.ObjectInputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.readObject(java.io.ObjectInputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    private void writeObject(java.io.ObjectOutputStream r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.writeObject(java.io.ObjectOutputStream):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.writeObject(java.io.ObjectOutputStream):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertificateRevokedException.getAuthorityName():javax.security.auth.x500.X500Principal, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public javax.security.auth.x500.X500Principal getAuthorityName() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertificateRevokedException.getAuthorityName():javax.security.auth.x500.X500Principal, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.getAuthorityName():javax.security.auth.x500.X500Principal");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertificateRevokedException.getExtensions():java.util.Map<java.lang.String, java.security.cert.Extension>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.util.Map<java.lang.String, java.security.cert.Extension> getExtensions() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertificateRevokedException.getExtensions():java.util.Map<java.lang.String, java.security.cert.Extension>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.getExtensions():java.util.Map");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.getInvalidityDate():java.util.Date, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.util.Date getInvalidityDate() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.getInvalidityDate():java.util.Date, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.getInvalidityDate():java.util.Date");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.getMessage():java.lang.String, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.lang.String getMessage() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.cert.CertificateRevokedException.getMessage():java.lang.String, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.getMessage():java.lang.String");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertificateRevokedException.getRevocationDate():java.util.Date, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
        	... 4 more
        */
    public java.util.Date getRevocationDate() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.cert.CertificateRevokedException.getRevocationDate():java.util.Date, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.getRevocationDate():java.util.Date");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.cert.CertificateRevokedException.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex in method: java.security.cert.CertificateRevokedException.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.cert.CertificateRevokedException.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
        	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
        	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    public java.security.cert.CRLReason getRevocationReason() {
        /*
        // Can't load method instructions: Load method exception: null in method: java.security.cert.CertificateRevokedException.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex in method: java.security.cert.CertificateRevokedException.getRevocationReason():java.security.cert.CRLReason, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.CertificateRevokedException.getRevocationReason():java.security.cert.CRLReason");
    }
}
