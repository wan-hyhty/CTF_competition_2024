package sun.security.pkcs;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import sun.security.util.Debug;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.X500Name;
import sun.security.x509.X509CRLImpl;
import sun.security.x509.X509CertImpl;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class PKCS7 {
    private Principal[] certIssuerNames;
    private X509Certificate[] certificates;
    private ContentInfo contentInfo;
    private ObjectIdentifier contentType;
    private X509CRL[] crls;
    private AlgorithmId[] digestAlgorithmIds;
    private boolean oldStyle;
    private SignerInfo[] signerInfos;
    private BigInteger version;

    private static class VerbatimX509Certificate extends WrappedX509Certificate {
        private byte[] encodedVerbatim;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.<init>(java.security.cert.X509Certificate, byte[]):void, dex: classes.dex in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.<init>(java.security.cert.X509Certificate, byte[]):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.<init>(java.security.cert.X509Certificate, byte[]):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        public VerbatimX509Certificate(java.security.cert.X509Certificate r1, byte[] r2) {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.<init>(java.security.cert.X509Certificate, byte[]):void, dex: classes.dex in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.<init>(java.security.cert.X509Certificate, byte[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.VerbatimX509Certificate.<init>(java.security.cert.X509Certificate, byte[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.getEncoded():byte[], dex: classes.dex in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.getEncoded():byte[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.getEncoded():byte[], dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        public byte[] getEncoded() {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.getEncoded():byte[], dex: classes.dex in method: sun.security.pkcs.PKCS7.VerbatimX509Certificate.getEncoded():byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.VerbatimX509Certificate.getEncoded():byte[]");
        }
    }

    private static class WrappedX509Certificate extends X509Certificate {
        private final X509Certificate wrapped;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.<init>(java.security.cert.X509Certificate):void, dex: classes.dex in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.<init>(java.security.cert.X509Certificate):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.<init>(java.security.cert.X509Certificate):void, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 5 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
            	at com.android.dx.io.instructions.InstructionCodec$22.decode(InstructionCodec.java:490)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 6 more
            */
        public WrappedX509Certificate(java.security.cert.X509Certificate r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.<init>(java.security.cert.X509Certificate):void, dex: classes.dex in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.<init>(java.security.cert.X509Certificate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.<init>(java.security.cert.X509Certificate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.checkValidity():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void checkValidity() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.checkValidity():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.checkValidity():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.checkValidity(java.util.Date):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void checkValidity(java.util.Date r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.checkValidity(java.util.Date):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.checkValidity(java.util.Date):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getBasicConstraints():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public int getBasicConstraints() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getBasicConstraints():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getBasicConstraints():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getCriticalExtensionOIDs():java.util.Set<java.lang.String>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.Set<java.lang.String> getCriticalExtensionOIDs() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getCriticalExtensionOIDs():java.util.Set<java.lang.String>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getCriticalExtensionOIDs():java.util.Set");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getEncoded():byte[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public byte[] getEncoded() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getEncoded():byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getEncoded():byte[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getExtendedKeyUsage():java.util.List<java.lang.String>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.List<java.lang.String> getExtendedKeyUsage() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getExtendedKeyUsage():java.util.List<java.lang.String>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getExtendedKeyUsage():java.util.List");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getExtensionValue(java.lang.String):byte[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public byte[] getExtensionValue(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getExtensionValue(java.lang.String):byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getExtensionValue(java.lang.String):byte[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerAlternativeNames():java.util.Collection<java.util.List<?>>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.Collection<java.util.List<?>> getIssuerAlternativeNames() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerAlternativeNames():java.util.Collection<java.util.List<?>>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerAlternativeNames():java.util.Collection");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerDN():java.security.Principal, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.security.Principal getIssuerDN() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerDN():java.security.Principal, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerDN():java.security.Principal");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerUniqueID():boolean[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean[] getIssuerUniqueID() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerUniqueID():boolean[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerUniqueID():boolean[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerX500Principal():javax.security.auth.x500.X500Principal, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerX500Principal():javax.security.auth.x500.X500Principal, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getIssuerX500Principal():javax.security.auth.x500.X500Principal");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getKeyUsage():boolean[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean[] getKeyUsage() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getKeyUsage():boolean[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getKeyUsage():boolean[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNonCriticalExtensionOIDs():java.util.Set<java.lang.String>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.Set<java.lang.String> getNonCriticalExtensionOIDs() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNonCriticalExtensionOIDs():java.util.Set<java.lang.String>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNonCriticalExtensionOIDs():java.util.Set");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNotAfter():java.util.Date, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.Date getNotAfter() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNotAfter():java.util.Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNotAfter():java.util.Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNotBefore():java.util.Date, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.Date getNotBefore() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNotBefore():java.util.Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getNotBefore():java.util.Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getPublicKey():java.security.PublicKey, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.security.PublicKey getPublicKey() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getPublicKey():java.security.PublicKey, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getPublicKey():java.security.PublicKey");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSerialNumber():java.math.BigInteger, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.math.BigInteger getSerialNumber() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSerialNumber():java.math.BigInteger, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSerialNumber():java.math.BigInteger");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgName():java.lang.String, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.lang.String getSigAlgName() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgName():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgName():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgOID():java.lang.String, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.lang.String getSigAlgOID() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgOID():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgOID():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgParams():byte[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public byte[] getSigAlgParams() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgParams():byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSigAlgParams():byte[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSignature():byte[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public byte[] getSignature() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSignature():byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSignature():byte[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectAlternativeNames():java.util.Collection<java.util.List<?>>, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.util.Collection<java.util.List<?>> getSubjectAlternativeNames() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectAlternativeNames():java.util.Collection<java.util.List<?>>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectAlternativeNames():java.util.Collection");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectDN():java.security.Principal, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.security.Principal getSubjectDN() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectDN():java.security.Principal, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectDN():java.security.Principal");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectUniqueID():boolean[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean[] getSubjectUniqueID() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectUniqueID():boolean[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectUniqueID():boolean[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectX500Principal():javax.security.auth.x500.X500Principal, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public javax.security.auth.x500.X500Principal getSubjectX500Principal() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectX500Principal():javax.security.auth.x500.X500Principal, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getSubjectX500Principal():javax.security.auth.x500.X500Principal");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getTBSCertificate():byte[], dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public byte[] getTBSCertificate() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getTBSCertificate():byte[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getTBSCertificate():byte[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getVersion():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public int getVersion() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.getVersion():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.getVersion():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.hasUnsupportedCriticalExtension():boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public boolean hasUnsupportedCriticalExtension() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.hasUnsupportedCriticalExtension():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.hasUnsupportedCriticalExtension():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.toString():java.lang.String, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.toString():java.lang.String");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void verify(java.security.PublicKey r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey, java.lang.String):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void verify(java.security.PublicKey r1, java.lang.String r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey, java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey, java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey, java.security.Provider):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e5
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        public void verify(java.security.PublicKey r1, java.security.Provider r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey, java.security.Provider):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.WrappedX509Certificate.verify(java.security.PublicKey, java.security.Provider):void");
        }
    }

    public PKCS7(InputStream in) throws ParsingException, IOException {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        DataInputStream dis = new DataInputStream(in);
        byte[] data = new byte[dis.available()];
        dis.readFully(data);
        parse(new DerInputStream(data));
    }

    public PKCS7(DerInputStream derin) throws ParsingException {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        parse(derin);
    }

    public PKCS7(byte[] bytes) throws ParsingException {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        try {
            parse(new DerInputStream(bytes));
        } catch (IOException ioe1) {
            ParsingException pe = new ParsingException("Unable to parse the encoded bytes");
            pe.initCause(ioe1);
            throw pe;
        }
    }

    private void parse(DerInputStream derin) throws ParsingException {
        try {
            derin.mark(derin.available());
            parse(derin, false);
        } catch (IOException ioe) {
            try {
                derin.reset();
                parse(derin, true);
                this.oldStyle = true;
            } catch (IOException ioe1) {
                ParsingException pe = new ParsingException(ioe1.getMessage());
                pe.initCause(ioe);
                pe.addSuppressed(ioe1);
                throw pe;
            }
        }
    }

    private void parse(DerInputStream derin, boolean oldStyle2) throws IOException {
        this.contentInfo = new ContentInfo(derin, oldStyle2);
        this.contentType = this.contentInfo.contentType;
        DerValue content = this.contentInfo.getContent();
        if (this.contentType.equals(ContentInfo.SIGNED_DATA_OID)) {
            parseSignedData(content);
        } else if (this.contentType.equals(ContentInfo.OLD_SIGNED_DATA_OID)) {
            parseOldSignedData(content);
        } else if (this.contentType.equals(ContentInfo.NETSCAPE_CERT_SEQUENCE_OID)) {
            parseNetscapeCertChain(content);
        } else {
            throw new ParsingException("content type " + this.contentType + " not supported.");
        }
    }

    public PKCS7(AlgorithmId[] digestAlgorithmIds2, ContentInfo contentInfo2, X509Certificate[] certificates2, X509CRL[] crls2, SignerInfo[] signerInfos2) {
        this.version = null;
        this.digestAlgorithmIds = null;
        this.contentInfo = null;
        this.certificates = null;
        this.crls = null;
        this.signerInfos = null;
        this.oldStyle = false;
        this.version = BigInteger.ONE;
        this.digestAlgorithmIds = digestAlgorithmIds2;
        this.contentInfo = contentInfo2;
        this.certificates = certificates2;
        this.crls = crls2;
        this.signerInfos = signerInfos2;
    }

    public PKCS7(AlgorithmId[] digestAlgorithmIds2, ContentInfo contentInfo2, X509Certificate[] certificates2, SignerInfo[] signerInfos2) {
        this(digestAlgorithmIds2, contentInfo2, certificates2, (X509CRL[]) null, signerInfos2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0057=Splitter:B:20:0x0057, B:28:0x006c=Splitter:B:28:0x006c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseNetscapeCertChain(sun.security.util.DerValue r15) throws sun.security.pkcs.ParsingException, java.io.IOException {
        /*
            r14 = this;
            r13 = 0
            sun.security.util.DerInputStream r5 = new sun.security.util.DerInputStream
            byte[] r10 = r15.toByteArray()
            r5.<init>((byte[]) r10)
            r10 = 2
            r11 = 1
            sun.security.util.DerValue[] r4 = r5.getSequence(r10, r11)
            int r10 = r4.length
            java.security.cert.X509Certificate[] r10 = new java.security.cert.X509Certificate[r10]
            r14.certificates = r10
            r3 = 0
            java.lang.String r10 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r10)     // Catch:{ CertificateException -> 0x0083 }
        L_0x001d:
            r6 = 0
        L_0x001e:
            int r10 = r4.length
            if (r6 >= r10) goto L_0x0079
            r0 = 0
            r10 = r4[r6]     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            byte[] r8 = r10.getOriginalEncodedForm()     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            if (r3 != 0) goto L_0x003d
            java.security.cert.X509Certificate[] r10 = r14.certificates     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            sun.security.x509.X509CertImpl r11 = new sun.security.x509.X509CertImpl     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            r12 = r4[r6]     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            r11.<init>(r12, r8)     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            r10[r6] = r11     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
        L_0x0035:
            if (r13 == 0) goto L_0x003a
            r0.close()
        L_0x003a:
            int r6 = r6 + 1
            goto L_0x001e
        L_0x003d:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            r1.<init>(r8)     // Catch:{ CertificateException -> 0x006b, IOException -> 0x0056 }
            java.security.cert.X509Certificate[] r11 = r14.certificates     // Catch:{ CertificateException -> 0x007d, IOException -> 0x0080, all -> 0x007a }
            sun.security.pkcs.PKCS7$VerbatimX509Certificate r12 = new sun.security.pkcs.PKCS7$VerbatimX509Certificate     // Catch:{ CertificateException -> 0x007d, IOException -> 0x0080, all -> 0x007a }
            java.security.cert.Certificate r10 = r3.generateCertificate(r1)     // Catch:{ CertificateException -> 0x007d, IOException -> 0x0080, all -> 0x007a }
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10     // Catch:{ CertificateException -> 0x007d, IOException -> 0x0080, all -> 0x007a }
            r12.<init>(r10, r8)     // Catch:{ CertificateException -> 0x007d, IOException -> 0x0080, all -> 0x007a }
            r11[r6] = r12     // Catch:{ CertificateException -> 0x007d, IOException -> 0x0080, all -> 0x007a }
            r1.close()     // Catch:{ CertificateException -> 0x007d, IOException -> 0x0080, all -> 0x007a }
            r0 = 0
            goto L_0x0035
        L_0x0056:
            r7 = move-exception
        L_0x0057:
            sun.security.pkcs.ParsingException r9 = new sun.security.pkcs.ParsingException     // Catch:{ all -> 0x0064 }
            java.lang.String r10 = r7.getMessage()     // Catch:{ all -> 0x0064 }
            r9.<init>(r10)     // Catch:{ all -> 0x0064 }
            r9.initCause(r7)     // Catch:{ all -> 0x0064 }
            throw r9     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r10 = move-exception
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()
        L_0x006a:
            throw r10
        L_0x006b:
            r2 = move-exception
        L_0x006c:
            sun.security.pkcs.ParsingException r9 = new sun.security.pkcs.ParsingException     // Catch:{ all -> 0x0064 }
            java.lang.String r10 = r2.getMessage()     // Catch:{ all -> 0x0064 }
            r9.<init>(r10)     // Catch:{ all -> 0x0064 }
            r9.initCause(r2)     // Catch:{ all -> 0x0064 }
            throw r9     // Catch:{ all -> 0x0064 }
        L_0x0079:
            return
        L_0x007a:
            r10 = move-exception
            r0 = r1
            goto L_0x0065
        L_0x007d:
            r2 = move-exception
            r0 = r1
            goto L_0x006c
        L_0x0080:
            r7 = move-exception
            r0 = r1
            goto L_0x0057
        L_0x0083:
            r2 = move-exception
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.parseNetscapeCertChain(sun.security.util.DerValue):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d6  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:44:0x0129=Splitter:B:44:0x0129, B:36:0x010c=Splitter:B:36:0x010c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseSignedData(sun.security.util.DerValue r28) throws sun.security.pkcs.ParsingException, java.io.IOException {
        /*
            r27 = this;
            sun.security.util.DerInputStream r11 = r28.toDerInputStream()
            java.math.BigInteger r24 = r11.getBigInteger()
            r0 = r24
            r1 = r27
            r1.version = r0
            r24 = 1
            r0 = r24
            sun.security.util.DerValue[] r10 = r11.getSet(r0)
            int r0 = r10.length
            r18 = r0
            r0 = r18
            sun.security.x509.AlgorithmId[] r0 = new sun.security.x509.AlgorithmId[r0]
            r24 = r0
            r0 = r24
            r1 = r27
            r1.digestAlgorithmIds = r0
            r15 = 0
        L_0x0026:
            r0 = r18
            if (r15 >= r0) goto L_0x0063
            r19 = r10[r15]     // Catch:{ IOException -> 0x003b }
            r0 = r27
            sun.security.x509.AlgorithmId[] r0 = r0.digestAlgorithmIds     // Catch:{ IOException -> 0x003b }
            r24 = r0
            sun.security.x509.AlgorithmId r25 = sun.security.x509.AlgorithmId.parse(r19)     // Catch:{ IOException -> 0x003b }
            r24[r15] = r25     // Catch:{ IOException -> 0x003b }
            int r15 = r15 + 1
            goto L_0x0026
        L_0x003b:
            r12 = move-exception
            sun.security.pkcs.ParsingException r21 = new sun.security.pkcs.ParsingException
            java.lang.StringBuilder r24 = new java.lang.StringBuilder
            r24.<init>()
            java.lang.String r25 = "Error parsing digest AlgorithmId IDs: "
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)
            java.lang.String r25 = r12.getMessage()
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)
            java.lang.String r24 = r24.toString()
            r0 = r21
            r1 = r24
            r0.<init>(r1)
            r0 = r21
            r0.initCause(r12)
            throw r21
        L_0x0063:
            sun.security.pkcs.ContentInfo r24 = new sun.security.pkcs.ContentInfo
            r0 = r24
            r0.<init>((sun.security.util.DerInputStream) r11)
            r0 = r24
            r1 = r27
            r1.contentInfo = r0
            r7 = 0
            java.lang.String r24 = "X.509"
            java.security.cert.CertificateFactory r7 = java.security.cert.CertificateFactory.getInstance(r24)     // Catch:{ CertificateException -> 0x0225 }
        L_0x0078:
            int r24 = r11.peekByte()
            r0 = r24
            byte r0 = (byte) r0
            r24 = r0
            r25 = -96
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x0154
            r24 = 2
            r25 = 1
            r26 = 1
            r0 = r24
            r1 = r25
            r2 = r26
            sun.security.util.DerValue[] r6 = r11.getSet(r0, r1, r2)
            int r0 = r6.length
            r18 = r0
            r0 = r18
            java.security.cert.X509Certificate[] r0 = new java.security.cert.X509Certificate[r0]
            r24 = r0
            r0 = r24
            r1 = r27
            r1.certificates = r0
            r8 = 0
            r15 = 0
        L_0x00aa:
            r0 = r18
            if (r15 >= r0) goto L_0x013c
            r3 = 0
            r24 = r6[r15]     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            byte r23 = r24.getTag()     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            r24 = 48
            r0 = r23
            r1 = r24
            if (r0 != r1) goto L_0x00dc
            r24 = r6[r15]     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            byte[] r20 = r24.getOriginalEncodedForm()     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            if (r7 != 0) goto L_0x00e6
            r0 = r27
            java.security.cert.X509Certificate[] r0 = r0.certificates     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            r24 = r0
            sun.security.x509.X509CertImpl r25 = new sun.security.x509.X509CertImpl     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            r26 = r6[r15]     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            r0 = r25
            r1 = r26
            r2 = r20
            r0.<init>(r1, r2)     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            r24[r8] = r25     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
        L_0x00da:
            int r8 = r8 + 1
        L_0x00dc:
            r24 = 0
            if (r24 == 0) goto L_0x00e3
            r3.close()
        L_0x00e3:
            int r15 = r15 + 1
            goto L_0x00aa
        L_0x00e6:
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            r0 = r20
            r4.<init>(r0)     // Catch:{ CertificateException -> 0x0128, IOException -> 0x010b }
            r0 = r27
            java.security.cert.X509Certificate[] r0 = r0.certificates     // Catch:{ CertificateException -> 0x021d, IOException -> 0x0221, all -> 0x0219 }
            r25 = r0
            sun.security.pkcs.PKCS7$VerbatimX509Certificate r26 = new sun.security.pkcs.PKCS7$VerbatimX509Certificate     // Catch:{ CertificateException -> 0x021d, IOException -> 0x0221, all -> 0x0219 }
            java.security.cert.Certificate r24 = r7.generateCertificate(r4)     // Catch:{ CertificateException -> 0x021d, IOException -> 0x0221, all -> 0x0219 }
            java.security.cert.X509Certificate r24 = (java.security.cert.X509Certificate) r24     // Catch:{ CertificateException -> 0x021d, IOException -> 0x0221, all -> 0x0219 }
            r0 = r26
            r1 = r24
            r2 = r20
            r0.<init>(r1, r2)     // Catch:{ CertificateException -> 0x021d, IOException -> 0x0221, all -> 0x0219 }
            r25[r8] = r26     // Catch:{ CertificateException -> 0x021d, IOException -> 0x0221, all -> 0x0219 }
            r4.close()     // Catch:{ CertificateException -> 0x021d, IOException -> 0x0221, all -> 0x0219 }
            r3 = 0
            goto L_0x00da
        L_0x010b:
            r17 = move-exception
        L_0x010c:
            sun.security.pkcs.ParsingException r21 = new sun.security.pkcs.ParsingException     // Catch:{ all -> 0x0121 }
            java.lang.String r24 = r17.getMessage()     // Catch:{ all -> 0x0121 }
            r0 = r21
            r1 = r24
            r0.<init>(r1)     // Catch:{ all -> 0x0121 }
            r0 = r21
            r1 = r17
            r0.initCause(r1)     // Catch:{ all -> 0x0121 }
            throw r21     // Catch:{ all -> 0x0121 }
        L_0x0121:
            r24 = move-exception
        L_0x0122:
            if (r3 == 0) goto L_0x0127
            r3.close()
        L_0x0127:
            throw r24
        L_0x0128:
            r5 = move-exception
        L_0x0129:
            sun.security.pkcs.ParsingException r21 = new sun.security.pkcs.ParsingException     // Catch:{ all -> 0x0121 }
            java.lang.String r24 = r5.getMessage()     // Catch:{ all -> 0x0121 }
            r0 = r21
            r1 = r24
            r0.<init>(r1)     // Catch:{ all -> 0x0121 }
            r0 = r21
            r0.initCause(r5)     // Catch:{ all -> 0x0121 }
            throw r21     // Catch:{ all -> 0x0121 }
        L_0x013c:
            r0 = r18
            if (r8 == r0) goto L_0x0154
            r0 = r27
            java.security.cert.X509Certificate[] r0 = r0.certificates
            r24 = r0
            r0 = r24
            java.lang.Object[] r24 = java.util.Arrays.copyOf((T[]) r0, (int) r8)
            java.security.cert.X509Certificate[] r24 = (java.security.cert.X509Certificate[]) r24
            r0 = r24
            r1 = r27
            r1.certificates = r0
        L_0x0154:
            int r24 = r11.peekByte()
            r0 = r24
            byte r0 = (byte) r0
            r24 = r0
            r25 = -95
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x01da
            r24 = 1
            r25 = 1
            r0 = r24
            r1 = r25
            sun.security.util.DerValue[] r9 = r11.getSet(r0, r1)
            int r0 = r9.length
            r18 = r0
            r0 = r18
            java.security.cert.X509CRL[] r0 = new java.security.cert.X509CRL[r0]
            r24 = r0
            r0 = r24
            r1 = r27
            r1.crls = r0
            r15 = 0
        L_0x0181:
            r0 = r18
            if (r15 >= r0) goto L_0x01da
            r3 = 0
            if (r7 != 0) goto L_0x01a1
            r0 = r27
            java.security.cert.X509CRL[] r0 = r0.crls     // Catch:{ CRLException -> 0x01bf }
            r24 = r0
            sun.security.x509.X509CRLImpl r25 = new sun.security.x509.X509CRLImpl     // Catch:{ CRLException -> 0x01bf }
            r26 = r9[r15]     // Catch:{ CRLException -> 0x01bf }
            r25.<init>((sun.security.util.DerValue) r26)     // Catch:{ CRLException -> 0x01bf }
            r24[r15] = r25     // Catch:{ CRLException -> 0x01bf }
        L_0x0197:
            r24 = 0
            if (r24 == 0) goto L_0x019e
            r3.close()
        L_0x019e:
            int r15 = r15 + 1
            goto L_0x0181
        L_0x01a1:
            r24 = r9[r15]     // Catch:{ CRLException -> 0x01bf }
            byte[] r14 = r24.toByteArray()     // Catch:{ CRLException -> 0x01bf }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ CRLException -> 0x01bf }
            r4.<init>(r14)     // Catch:{ CRLException -> 0x01bf }
            r0 = r27
            java.security.cert.X509CRL[] r0 = r0.crls     // Catch:{ CRLException -> 0x0216, all -> 0x0213 }
            r25 = r0
            java.security.cert.CRL r24 = r7.generateCRL(r4)     // Catch:{ CRLException -> 0x0216, all -> 0x0213 }
            java.security.cert.X509CRL r24 = (java.security.cert.X509CRL) r24     // Catch:{ CRLException -> 0x0216, all -> 0x0213 }
            r25[r15] = r24     // Catch:{ CRLException -> 0x0216, all -> 0x0213 }
            r4.close()     // Catch:{ CRLException -> 0x0216, all -> 0x0213 }
            r3 = 0
            goto L_0x0197
        L_0x01bf:
            r13 = move-exception
        L_0x01c0:
            sun.security.pkcs.ParsingException r21 = new sun.security.pkcs.ParsingException     // Catch:{ all -> 0x01d3 }
            java.lang.String r24 = r13.getMessage()     // Catch:{ all -> 0x01d3 }
            r0 = r21
            r1 = r24
            r0.<init>(r1)     // Catch:{ all -> 0x01d3 }
            r0 = r21
            r0.initCause(r13)     // Catch:{ all -> 0x01d3 }
            throw r21     // Catch:{ all -> 0x01d3 }
        L_0x01d3:
            r24 = move-exception
        L_0x01d4:
            if (r3 == 0) goto L_0x01d9
            r3.close()
        L_0x01d9:
            throw r24
        L_0x01da:
            r24 = 1
            r0 = r24
            sun.security.util.DerValue[] r22 = r11.getSet(r0)
            r0 = r22
            int r0 = r0.length
            r18 = r0
            r0 = r18
            sun.security.pkcs.SignerInfo[] r0 = new sun.security.pkcs.SignerInfo[r0]
            r24 = r0
            r0 = r24
            r1 = r27
            r1.signerInfos = r0
            r15 = 0
        L_0x01f4:
            r0 = r18
            if (r15 >= r0) goto L_0x0212
            r24 = r22[r15]
            sun.security.util.DerInputStream r16 = r24.toDerInputStream()
            r0 = r27
            sun.security.pkcs.SignerInfo[] r0 = r0.signerInfos
            r24 = r0
            sun.security.pkcs.SignerInfo r25 = new sun.security.pkcs.SignerInfo
            r0 = r25
            r1 = r16
            r0.<init>(r1)
            r24[r15] = r25
            int r15 = r15 + 1
            goto L_0x01f4
        L_0x0212:
            return
        L_0x0213:
            r24 = move-exception
            r3 = r4
            goto L_0x01d4
        L_0x0216:
            r13 = move-exception
            r3 = r4
            goto L_0x01c0
        L_0x0219:
            r24 = move-exception
            r3 = r4
            goto L_0x0122
        L_0x021d:
            r5 = move-exception
            r3 = r4
            goto L_0x0129
        L_0x0221:
            r17 = move-exception
            r3 = r4
            goto L_0x010c
        L_0x0225:
            r5 = move-exception
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.parseSignedData(sun.security.util.DerValue):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x00c4=Splitter:B:29:0x00c4, B:37:0x00df=Splitter:B:37:0x00df} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseOldSignedData(sun.security.util.DerValue r23) throws sun.security.pkcs.ParsingException, java.io.IOException {
        /*
            r22 = this;
            sun.security.util.DerInputStream r9 = r23.toDerInputStream()
            java.math.BigInteger r19 = r9.getBigInteger()
            r0 = r19
            r1 = r22
            r1.version = r0
            r19 = 1
            r0 = r19
            sun.security.util.DerValue[] r8 = r9.getSet(r0)
            int r14 = r8.length
            sun.security.x509.AlgorithmId[] r0 = new sun.security.x509.AlgorithmId[r14]
            r19 = r0
            r0 = r19
            r1 = r22
            r1.digestAlgorithmIds = r0
            r11 = 0
        L_0x0022:
            if (r11 >= r14) goto L_0x003f
            r15 = r8[r11]     // Catch:{ IOException -> 0x0035 }
            r0 = r22
            sun.security.x509.AlgorithmId[] r0 = r0.digestAlgorithmIds     // Catch:{ IOException -> 0x0035 }
            r19 = r0
            sun.security.x509.AlgorithmId r20 = sun.security.x509.AlgorithmId.parse(r15)     // Catch:{ IOException -> 0x0035 }
            r19[r11] = r20     // Catch:{ IOException -> 0x0035 }
            int r11 = r11 + 1
            goto L_0x0022
        L_0x0035:
            r10 = move-exception
            sun.security.pkcs.ParsingException r19 = new sun.security.pkcs.ParsingException
            java.lang.String r20 = "Error parsing digest AlgorithmId IDs"
            r19.<init>(r20)
            throw r19
        L_0x003f:
            sun.security.pkcs.ContentInfo r19 = new sun.security.pkcs.ContentInfo
            r20 = 1
            r0 = r19
            r1 = r20
            r0.<init>((sun.security.util.DerInputStream) r9, (boolean) r1)
            r0 = r19
            r1 = r22
            r1.contentInfo = r0
            r7 = 0
            java.lang.String r19 = "X.509"
            java.security.cert.CertificateFactory r7 = java.security.cert.CertificateFactory.getInstance(r19)     // Catch:{ CertificateException -> 0x0137 }
        L_0x0058:
            r19 = 2
            r20 = 0
            r21 = 1
            r0 = r19
            r1 = r20
            r2 = r21
            sun.security.util.DerValue[] r6 = r9.getSet(r0, r1, r2)
            int r14 = r6.length
            java.security.cert.X509Certificate[] r0 = new java.security.cert.X509Certificate[r14]
            r19 = r0
            r0 = r19
            r1 = r22
            r1.certificates = r0
            r11 = 0
        L_0x0074:
            if (r11 >= r14) goto L_0x00f2
            r3 = 0
            r19 = r6[r11]     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            byte[] r16 = r19.getOriginalEncodedForm()     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            if (r7 != 0) goto L_0x009e
            r0 = r22
            java.security.cert.X509Certificate[] r0 = r0.certificates     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            r19 = r0
            sun.security.x509.X509CertImpl r20 = new sun.security.x509.X509CertImpl     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            r21 = r6[r11]     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            r0 = r20
            r1 = r21
            r2 = r16
            r0.<init>(r1, r2)     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            r19[r11] = r20     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
        L_0x0094:
            r19 = 0
            if (r19 == 0) goto L_0x009b
            r3.close()
        L_0x009b:
            int r11 = r11 + 1
            goto L_0x0074
        L_0x009e:
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            r0 = r16
            r4.<init>(r0)     // Catch:{ CertificateException -> 0x00de, IOException -> 0x00c3 }
            r0 = r22
            java.security.cert.X509Certificate[] r0 = r0.certificates     // Catch:{ CertificateException -> 0x0131, IOException -> 0x0134, all -> 0x012e }
            r20 = r0
            sun.security.pkcs.PKCS7$VerbatimX509Certificate r21 = new sun.security.pkcs.PKCS7$VerbatimX509Certificate     // Catch:{ CertificateException -> 0x0131, IOException -> 0x0134, all -> 0x012e }
            java.security.cert.Certificate r19 = r7.generateCertificate(r4)     // Catch:{ CertificateException -> 0x0131, IOException -> 0x0134, all -> 0x012e }
            java.security.cert.X509Certificate r19 = (java.security.cert.X509Certificate) r19     // Catch:{ CertificateException -> 0x0131, IOException -> 0x0134, all -> 0x012e }
            r0 = r21
            r1 = r19
            r2 = r16
            r0.<init>(r1, r2)     // Catch:{ CertificateException -> 0x0131, IOException -> 0x0134, all -> 0x012e }
            r20[r11] = r21     // Catch:{ CertificateException -> 0x0131, IOException -> 0x0134, all -> 0x012e }
            r4.close()     // Catch:{ CertificateException -> 0x0131, IOException -> 0x0134, all -> 0x012e }
            r3 = 0
            goto L_0x0094
        L_0x00c3:
            r13 = move-exception
        L_0x00c4:
            sun.security.pkcs.ParsingException r17 = new sun.security.pkcs.ParsingException     // Catch:{ all -> 0x00d7 }
            java.lang.String r19 = r13.getMessage()     // Catch:{ all -> 0x00d7 }
            r0 = r17
            r1 = r19
            r0.<init>(r1)     // Catch:{ all -> 0x00d7 }
            r0 = r17
            r0.initCause(r13)     // Catch:{ all -> 0x00d7 }
            throw r17     // Catch:{ all -> 0x00d7 }
        L_0x00d7:
            r19 = move-exception
        L_0x00d8:
            if (r3 == 0) goto L_0x00dd
            r3.close()
        L_0x00dd:
            throw r19
        L_0x00de:
            r5 = move-exception
        L_0x00df:
            sun.security.pkcs.ParsingException r17 = new sun.security.pkcs.ParsingException     // Catch:{ all -> 0x00d7 }
            java.lang.String r19 = r5.getMessage()     // Catch:{ all -> 0x00d7 }
            r0 = r17
            r1 = r19
            r0.<init>(r1)     // Catch:{ all -> 0x00d7 }
            r0 = r17
            r0.initCause(r5)     // Catch:{ all -> 0x00d7 }
            throw r17     // Catch:{ all -> 0x00d7 }
        L_0x00f2:
            r19 = 0
            r0 = r19
            r9.getSet(r0)
            r19 = 1
            r0 = r19
            sun.security.util.DerValue[] r18 = r9.getSet(r0)
            r0 = r18
            int r14 = r0.length
            sun.security.pkcs.SignerInfo[] r0 = new sun.security.pkcs.SignerInfo[r14]
            r19 = r0
            r0 = r19
            r1 = r22
            r1.signerInfos = r0
            r11 = 0
        L_0x010f:
            if (r11 >= r14) goto L_0x012d
            r19 = r18[r11]
            sun.security.util.DerInputStream r12 = r19.toDerInputStream()
            r0 = r22
            sun.security.pkcs.SignerInfo[] r0 = r0.signerInfos
            r19 = r0
            sun.security.pkcs.SignerInfo r20 = new sun.security.pkcs.SignerInfo
            r21 = 1
            r0 = r20
            r1 = r21
            r0.<init>(r12, r1)
            r19[r11] = r20
            int r11 = r11 + 1
            goto L_0x010f
        L_0x012d:
            return
        L_0x012e:
            r19 = move-exception
            r3 = r4
            goto L_0x00d8
        L_0x0131:
            r5 = move-exception
            r3 = r4
            goto L_0x00df
        L_0x0134:
            r13 = move-exception
            r3 = r4
            goto L_0x00c4
        L_0x0137:
            r5 = move-exception
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.parseOldSignedData(sun.security.util.DerValue):void");
    }

    public void encodeSignedData(OutputStream out) throws IOException {
        DerOutputStream derout = new DerOutputStream();
        encodeSignedData(derout);
        out.write(derout.toByteArray());
    }

    public void encodeSignedData(DerOutputStream out) throws IOException {
        DerOutputStream signedData = new DerOutputStream();
        signedData.putInteger(this.version);
        signedData.putOrderedSetOf((byte) 49, this.digestAlgorithmIds);
        this.contentInfo.encode(signedData);
        if (!(this.certificates == null || this.certificates.length == 0)) {
            X509CertImpl[] implCerts = new X509CertImpl[this.certificates.length];
            for (int i = 0; i < this.certificates.length; i++) {
                if (this.certificates[i] instanceof X509CertImpl) {
                    implCerts[i] = (X509CertImpl) this.certificates[i];
                } else {
                    try {
                        implCerts[i] = new X509CertImpl(this.certificates[i].getEncoded());
                    } catch (CertificateException ce) {
                        IOException ie = new IOException(ce.getMessage());
                        ie.initCause(ce);
                        throw ie;
                    }
                }
            }
            signedData.putOrderedSetOf((byte) -96, implCerts);
        }
        if (!(this.crls == null || this.crls.length == 0)) {
            Set<X509CRLImpl> implCRLs = new HashSet<>(this.crls.length);
            for (X509CRL crl : this.crls) {
                if (crl instanceof X509CRLImpl) {
                    implCRLs.add((X509CRLImpl) crl);
                } else {
                    try {
                        implCRLs.add(new X509CRLImpl(crl.getEncoded()));
                    } catch (CRLException ce2) {
                        IOException ie2 = new IOException(ce2.getMessage());
                        ie2.initCause(ce2);
                        throw ie2;
                    }
                }
            }
            signedData.putOrderedSetOf((byte) -95, (DerEncoder[]) implCRLs.toArray(new X509CRLImpl[implCRLs.size()]));
        }
        signedData.putOrderedSetOf((byte) 49, this.signerInfos);
        new ContentInfo(ContentInfo.SIGNED_DATA_OID, new DerValue((byte) 48, signedData.toByteArray())).encode(out);
    }

    public SignerInfo verify(SignerInfo info, byte[] bytes) throws NoSuchAlgorithmException, SignatureException {
        return info.verify(this, bytes);
    }

    public SignerInfo verify(SignerInfo info, InputStream dataInputStream) throws NoSuchAlgorithmException, SignatureException, IOException {
        return info.verify(this, dataInputStream);
    }

    public SignerInfo[] verify(byte[] bytes) throws NoSuchAlgorithmException, SignatureException {
        Vector<SignerInfo> intResult = new Vector<>();
        for (SignerInfo verify : this.signerInfos) {
            SignerInfo signerInfo = verify(verify, bytes);
            if (signerInfo != null) {
                intResult.addElement(signerInfo);
            }
        }
        if (intResult.size() == 0) {
            return null;
        }
        SignerInfo[] result = new SignerInfo[intResult.size()];
        intResult.copyInto(result);
        return result;
    }

    public SignerInfo[] verify() throws NoSuchAlgorithmException, SignatureException {
        return verify((byte[]) null);
    }

    public BigInteger getVersion() {
        return this.version;
    }

    public AlgorithmId[] getDigestAlgorithmIds() {
        return this.digestAlgorithmIds;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public X509Certificate[] getCertificates() {
        if (this.certificates != null) {
            return (X509Certificate[]) this.certificates.clone();
        }
        return null;
    }

    public X509CRL[] getCRLs() {
        if (this.crls != null) {
            return (X509CRL[]) this.crls.clone();
        }
        return null;
    }

    public SignerInfo[] getSignerInfos() {
        return this.signerInfos;
    }

    public X509Certificate getCertificate(BigInteger serial, X500Name issuerName) {
        if (this.certificates != null) {
            if (this.certIssuerNames == null) {
                populateCertIssuerNames();
            }
            for (int i = 0; i < this.certificates.length; i++) {
                X509Certificate cert = this.certificates[i];
                if (serial.equals(cert.getSerialNumber()) && issuerName.equals(this.certIssuerNames[i])) {
                    return cert;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.security.Principal} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateCertIssuerNames() {
        /*
            r7 = this;
            java.security.cert.X509Certificate[] r6 = r7.certificates
            if (r6 != 0) goto L_0x0005
            return
        L_0x0005:
            java.security.cert.X509Certificate[] r6 = r7.certificates
            int r6 = r6.length
            java.security.Principal[] r6 = new java.security.Principal[r6]
            r7.certIssuerNames = r6
            r4 = 0
        L_0x000d:
            java.security.cert.X509Certificate[] r6 = r7.certificates
            int r6 = r6.length
            if (r4 >= r6) goto L_0x0039
            java.security.cert.X509Certificate[] r6 = r7.certificates
            r1 = r6[r4]
            java.security.Principal r2 = r1.getIssuerDN()
            boolean r6 = r2 instanceof sun.security.x509.X500Name
            if (r6 != 0) goto L_0x0032
            sun.security.x509.X509CertInfo r5 = new sun.security.x509.X509CertInfo     // Catch:{ Exception -> 0x003a }
            byte[] r6 = r1.getTBSCertificate()     // Catch:{ Exception -> 0x003a }
            r5.<init>((byte[]) r6)     // Catch:{ Exception -> 0x003a }
            java.lang.String r6 = "issuer.dname"
            java.lang.Object r6 = r5.get(r6)     // Catch:{ Exception -> 0x003a }
            r0 = r6
            java.security.Principal r0 = (java.security.Principal) r0     // Catch:{ Exception -> 0x003a }
            r2 = r0
        L_0x0032:
            java.security.Principal[] r6 = r7.certIssuerNames
            r6[r4] = r2
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0039:
            return
        L_0x003a:
            r3 = move-exception
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.pkcs.PKCS7.populateCertIssuerNames():void");
    }

    public String toString() {
        String out;
        String out2 = "" + this.contentInfo + "\n";
        if (this.version != null) {
            out2 = out2 + "PKCS7 :: version: " + Debug.toHexString(this.version) + "\n";
        }
        if (this.digestAlgorithmIds != null) {
            out = out + "PKCS7 :: digest AlgorithmIds: \n";
            for (int i = 0; i < this.digestAlgorithmIds.length; i++) {
                out = out + "\t" + this.digestAlgorithmIds[i] + "\n";
            }
        }
        if (this.certificates != null) {
            String out3 = out + "PKCS7 :: certificates: \n";
            for (int i2 = 0; i2 < this.certificates.length; i2++) {
                out3 = out + "\t" + i2 + ".   " + this.certificates[i2] + "\n";
            }
        }
        if (this.crls != null) {
            String out4 = out + "PKCS7 :: crls: \n";
            for (int i3 = 0; i3 < this.crls.length; i3++) {
                out4 = out + "\t" + i3 + ".   " + this.crls[i3] + "\n";
            }
        }
        if (this.signerInfos != null) {
            String out5 = out + "PKCS7 :: signer infos: \n";
            for (int i4 = 0; i4 < this.signerInfos.length; i4++) {
                out5 = out + "\t" + i4 + ".  " + this.signerInfos[i4] + "\n";
            }
        }
        return out;
    }

    public boolean isOldStyle() {
        return this.oldStyle;
    }
}
