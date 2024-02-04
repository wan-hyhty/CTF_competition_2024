package java.security;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;
import javax.crypto.SecretKey;
import javax.security.auth.Destroyable;
import javax.security.auth.callback.CallbackHandler;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ClassModifier.cleanInsnsInAnonymousConstructor(ClassModifier.java:334)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:60)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class KeyStore {
    private static final String KEYSTORE_TYPE = "keystore.type";
    /* access modifiers changed from: private */
    public boolean initialized;
    private KeyStoreSpi keyStoreSpi;
    private Provider provider;
    private String type;

    public static class CallbackHandlerProtection implements ProtectionParameter {
        private final CallbackHandler handler;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.CallbackHandlerProtection.<init>(javax.security.auth.callback.CallbackHandler):void, dex: classes.dex
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
        public CallbackHandlerProtection(javax.security.auth.callback.CallbackHandler r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.CallbackHandlerProtection.<init>(javax.security.auth.callback.CallbackHandler):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.CallbackHandlerProtection.<init>(javax.security.auth.callback.CallbackHandler):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.CallbackHandlerProtection.getCallbackHandler():javax.security.auth.callback.CallbackHandler, dex: classes.dex
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
        public javax.security.auth.callback.CallbackHandler getCallbackHandler() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.CallbackHandlerProtection.getCallbackHandler():javax.security.auth.callback.CallbackHandler, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.CallbackHandlerProtection.getCallbackHandler():javax.security.auth.callback.CallbackHandler");
        }
    }

    public interface Entry {
    }

    public interface LoadStoreParameter {
        ProtectionParameter getProtectionParameter();
    }

    public static final class PrivateKeyEntry implements Entry {
        private final Certificate[] chain;
        private final PrivateKey privKey;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.PrivateKeyEntry.<init>(java.security.PrivateKey, java.security.cert.Certificate[]):void, dex: classes.dex
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
        public PrivateKeyEntry(java.security.PrivateKey r1, java.security.cert.Certificate[] r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.PrivateKeyEntry.<init>(java.security.PrivateKey, java.security.cert.Certificate[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PrivateKeyEntry.<init>(java.security.PrivateKey, java.security.cert.Certificate[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PrivateKeyEntry.getCertificate():java.security.cert.Certificate, dex: classes.dex
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
        public java.security.cert.Certificate getCertificate() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PrivateKeyEntry.getCertificate():java.security.cert.Certificate, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PrivateKeyEntry.getCertificate():java.security.cert.Certificate");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PrivateKeyEntry.getCertificateChain():java.security.cert.Certificate[], dex: classes.dex
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
        public java.security.cert.Certificate[] getCertificateChain() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PrivateKeyEntry.getCertificateChain():java.security.cert.Certificate[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PrivateKeyEntry.getCertificateChain():java.security.cert.Certificate[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PrivateKeyEntry.getPrivateKey():java.security.PrivateKey, dex: classes.dex
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
        public java.security.PrivateKey getPrivateKey() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PrivateKeyEntry.getPrivateKey():java.security.PrivateKey, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PrivateKeyEntry.getPrivateKey():java.security.PrivateKey");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.PrivateKeyEntry.toString():java.lang.String, dex: classes.dex
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
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.PrivateKeyEntry.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PrivateKeyEntry.toString():java.lang.String");
        }
    }

    public interface ProtectionParameter {
    }

    public static final class SecretKeyEntry implements Entry {
        private final SecretKey sKey;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.SecretKeyEntry.<init>(javax.crypto.SecretKey):void, dex: classes.dex
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
        public SecretKeyEntry(javax.crypto.SecretKey r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.SecretKeyEntry.<init>(javax.crypto.SecretKey):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.SecretKeyEntry.<init>(javax.crypto.SecretKey):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.SecretKeyEntry.getSecretKey():javax.crypto.SecretKey, dex: classes.dex
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
        public javax.crypto.SecretKey getSecretKey() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.SecretKeyEntry.getSecretKey():javax.crypto.SecretKey, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.SecretKeyEntry.getSecretKey():javax.crypto.SecretKey");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.SecretKeyEntry.toString():java.lang.String, dex: classes.dex
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
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.SecretKeyEntry.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.SecretKeyEntry.toString():java.lang.String");
        }
    }

    static class SimpleLoadStoreParameter implements LoadStoreParameter {
        private final ProtectionParameter protection;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.SimpleLoadStoreParameter.<init>(java.security.KeyStore$ProtectionParameter):void, dex: classes.dex
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
        SimpleLoadStoreParameter(java.security.KeyStore.ProtectionParameter r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.SimpleLoadStoreParameter.<init>(java.security.KeyStore$ProtectionParameter):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.SimpleLoadStoreParameter.<init>(java.security.KeyStore$ProtectionParameter):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.SimpleLoadStoreParameter.getProtectionParameter():java.security.KeyStore$ProtectionParameter, dex: classes.dex
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
        public java.security.KeyStore.ProtectionParameter getProtectionParameter() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.SimpleLoadStoreParameter.getProtectionParameter():java.security.KeyStore$ProtectionParameter, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.SimpleLoadStoreParameter.getProtectionParameter():java.security.KeyStore$ProtectionParameter");
        }
    }

    public static final class TrustedCertificateEntry implements Entry {
        private final Certificate cert;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.TrustedCertificateEntry.<init>(java.security.cert.Certificate):void, dex: classes.dex
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
        public TrustedCertificateEntry(java.security.cert.Certificate r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.TrustedCertificateEntry.<init>(java.security.cert.Certificate):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.TrustedCertificateEntry.<init>(java.security.cert.Certificate):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.TrustedCertificateEntry.getTrustedCertificate():java.security.cert.Certificate, dex: classes.dex
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
        public java.security.cert.Certificate getTrustedCertificate() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.TrustedCertificateEntry.getTrustedCertificate():java.security.cert.Certificate, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.TrustedCertificateEntry.getTrustedCertificate():java.security.cert.Certificate");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.TrustedCertificateEntry.toString():java.lang.String, dex: classes.dex
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
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.TrustedCertificateEntry.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.TrustedCertificateEntry.toString():java.lang.String");
        }
    }

    public static class PasswordProtection implements ProtectionParameter, Destroyable {
        private volatile boolean destroyed;
        private final char[] password;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.PasswordProtection.<init>(char[]):void, dex: classes.dex
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
        public PasswordProtection(char[] r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.PasswordProtection.<init>(char[]):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PasswordProtection.<init>(char[]):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PasswordProtection.destroy():void, dex: classes.dex
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
        public synchronized void destroy() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PasswordProtection.destroy():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PasswordProtection.destroy():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PasswordProtection.getPassword():char[], dex: classes.dex
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
        public synchronized char[] getPassword() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.PasswordProtection.getPassword():char[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.PasswordProtection.getPassword():char[]");
        }

        public synchronized boolean isDestroyed() {
            return this.destroyed;
        }
    }

    protected KeyStore(KeyStoreSpi keyStoreSpi2, Provider provider2, String type2) {
        this.initialized = false;
        this.keyStoreSpi = keyStoreSpi2;
        this.provider = provider2;
        this.type = type2;
    }

    public static KeyStore getInstance(String type2) throws KeyStoreException {
        try {
            Object[] objs = Security.getImpl(type2, "KeyStore", (String) null);
            return new KeyStore((KeyStoreSpi) objs[0], (Provider) objs[1], type2);
        } catch (NoSuchAlgorithmException nsae) {
            throw new KeyStoreException(type2 + " not found", nsae);
        } catch (NoSuchProviderException nspe) {
            throw new KeyStoreException(type2 + " not found", nspe);
        }
    }

    public static KeyStore getInstance(String type2, String provider2) throws KeyStoreException, NoSuchProviderException {
        if (provider2 == null || provider2.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        try {
            Object[] objs = Security.getImpl(type2, "KeyStore", provider2);
            return new KeyStore((KeyStoreSpi) objs[0], (Provider) objs[1], type2);
        } catch (NoSuchAlgorithmException nsae) {
            throw new KeyStoreException(type2 + " not found", nsae);
        }
    }

    public static KeyStore getInstance(String type2, Provider provider2) throws KeyStoreException {
        if (provider2 == null) {
            throw new IllegalArgumentException("missing provider");
        }
        try {
            Object[] objs = Security.getImpl(type2, "KeyStore", provider2);
            return new KeyStore((KeyStoreSpi) objs[0], (Provider) objs[1], type2);
        } catch (NoSuchAlgorithmException nsae) {
            throw new KeyStoreException(type2 + " not found", nsae);
        }
    }

    public static final String getDefaultType() {
        String kstype = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                return Security.getProperty(KeyStore.KEYSTORE_TYPE);
            }
        });
        if (kstype == null) {
            return "jks";
        }
        return kstype;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }

    public final Key getKey(String alias, char[] password) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (this.initialized) {
            return this.keyStoreSpi.engineGetKey(alias, password);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final Certificate[] getCertificateChain(String alias) throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineGetCertificateChain(alias);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final Certificate getCertificate(String alias) throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineGetCertificate(alias);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final Date getCreationDate(String alias) throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineGetCreationDate(alias);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final void setKeyEntry(String alias, Key key, char[] password, Certificate[] chain) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        } else if (!(key instanceof PrivateKey) || !(chain == null || chain.length == 0)) {
            this.keyStoreSpi.engineSetKeyEntry(alias, key, password, chain);
        } else {
            throw new IllegalArgumentException("Private key must be accompanied by certificate chain");
        }
    }

    public final void setKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineSetKeyEntry(alias, key, chain);
    }

    public final void setCertificateEntry(String alias, Certificate cert) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineSetCertificateEntry(alias, cert);
    }

    public final void deleteEntry(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineDeleteEntry(alias);
    }

    public final Enumeration<String> aliases() throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineAliases();
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final boolean containsAlias(String alias) throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineContainsAlias(alias);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final int size() throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineSize();
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final boolean isKeyEntry(String alias) throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineIsKeyEntry(alias);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final boolean isCertificateEntry(String alias) throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineIsCertificateEntry(alias);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final String getCertificateAlias(Certificate cert) throws KeyStoreException {
        if (this.initialized) {
            return this.keyStoreSpi.engineGetCertificateAlias(cert);
        }
        throw new KeyStoreException("Uninitialized keystore");
    }

    public final void store(OutputStream stream, char[] password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineStore(stream, password);
    }

    public final void store(LoadStoreParameter param) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineStore(param);
    }

    public final void load(InputStream stream, char[] password) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineLoad(stream, password);
        this.initialized = true;
    }

    public final void load(LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineLoad(param);
        this.initialized = true;
    }

    public final Entry getEntry(String alias, ProtectionParameter protParam) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        if (alias == null) {
            throw new NullPointerException("invalid null input");
        } else if (this.initialized) {
            return this.keyStoreSpi.engineGetEntry(alias, protParam);
        } else {
            throw new KeyStoreException("Uninitialized keystore");
        }
    }

    public final void setEntry(String alias, Entry entry, ProtectionParameter protParam) throws KeyStoreException {
        if (alias == null || entry == null) {
            throw new NullPointerException("invalid null input");
        } else if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        } else {
            this.keyStoreSpi.engineSetEntry(alias, entry, protParam);
        }
    }

    public final boolean entryInstanceOf(String alias, Class<? extends Entry> entryClass) throws KeyStoreException {
        if (alias == null || entryClass == null) {
            throw new NullPointerException("invalid null input");
        } else if (this.initialized) {
            return this.keyStoreSpi.engineEntryInstanceOf(alias, entryClass);
        } else {
            throw new KeyStoreException("Uninitialized keystore");
        }
    }

    public static abstract class Builder {
        static final int MAX_CALLBACK_TRIES = 3;

        private static final class FileBuilder extends Builder {
            private final AccessControlContext context;
            private final File file;
            private ProtectionParameter keyProtection;
            private KeyStore keyStore;
            private Throwable oldException;
            private ProtectionParameter protection;
            private final Provider provider;
            private final String type;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.-get0(java.security.KeyStore$Builder$FileBuilder):java.io.File, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            /* renamed from: -get0 */
            static /* synthetic */ java.io.File m157get0(java.security.KeyStore.Builder.FileBuilder r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.-get0(java.security.KeyStore$Builder$FileBuilder):java.io.File, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.m157get0(java.security.KeyStore$Builder$FileBuilder):java.io.File");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.-get1(java.security.KeyStore$Builder$FileBuilder):java.security.KeyStore$ProtectionParameter, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            /* renamed from: -get1 */
            static /* synthetic */ java.security.KeyStore.ProtectionParameter m158get1(java.security.KeyStore.Builder.FileBuilder r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.-get1(java.security.KeyStore$Builder$FileBuilder):java.security.KeyStore$ProtectionParameter, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.m158get1(java.security.KeyStore$Builder$FileBuilder):java.security.KeyStore$ProtectionParameter");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.-get2(java.security.KeyStore$Builder$FileBuilder):java.security.Provider, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            /* renamed from: -get2 */
            static /* synthetic */ java.security.Provider m159get2(java.security.KeyStore.Builder.FileBuilder r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.-get2(java.security.KeyStore$Builder$FileBuilder):java.security.Provider, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.m159get2(java.security.KeyStore$Builder$FileBuilder):java.security.Provider");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.security.KeyStore.Builder.FileBuilder.-get3(java.security.KeyStore$Builder$FileBuilder):java.lang.String, dex: classes.dex in method: java.security.KeyStore.Builder.FileBuilder.-get3(java.security.KeyStore$Builder$FileBuilder):java.lang.String, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.security.KeyStore.Builder.FileBuilder.-get3(java.security.KeyStore$Builder$FileBuilder):java.lang.String, dex: classes.dex
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                	... 6 more
                Caused by: java.io.EOFException
                	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                	at com.android.dx.io.instructions.InstructionCodec.decodeRegisterList(InstructionCodec.java:920)
                	at com.android.dx.io.instructions.InstructionCodec.access$900(InstructionCodec.java:31)
                	at com.android.dx.io.instructions.InstructionCodec$25.decode(InstructionCodec.java:572)
                	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                	... 7 more
                */
            /* renamed from: -get3 */
            static /* synthetic */ java.lang.String m160get3(java.security.KeyStore.Builder.FileBuilder r1) {
                /*
                // Can't load method instructions: Load method exception: null in method: java.security.KeyStore.Builder.FileBuilder.-get3(java.security.KeyStore$Builder$FileBuilder):java.lang.String, dex: classes.dex in method: java.security.KeyStore.Builder.FileBuilder.-get3(java.security.KeyStore$Builder$FileBuilder):java.lang.String, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.m160get3(java.security.KeyStore$Builder$FileBuilder):java.lang.String");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.Builder.FileBuilder.-set0(java.security.KeyStore$Builder$FileBuilder, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$ProtectionParameter, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            /* renamed from: -set0 */
            static /* synthetic */ java.security.KeyStore.ProtectionParameter m161set0(java.security.KeyStore.Builder.FileBuilder r1, java.security.KeyStore.ProtectionParameter r2) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.Builder.FileBuilder.-set0(java.security.KeyStore$Builder$FileBuilder, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$ProtectionParameter, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.m161set0(java.security.KeyStore$Builder$FileBuilder, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$ProtectionParameter");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.Builder.FileBuilder.<init>(java.lang.String, java.security.Provider, java.io.File, java.security.KeyStore$ProtectionParameter, java.security.AccessControlContext):void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            FileBuilder(java.lang.String r1, java.security.Provider r2, java.io.File r3, java.security.KeyStore.ProtectionParameter r4, java.security.AccessControlContext r5) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.security.KeyStore.Builder.FileBuilder.<init>(java.lang.String, java.security.Provider, java.io.File, java.security.KeyStore$ProtectionParameter, java.security.AccessControlContext):void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.<init>(java.lang.String, java.security.Provider, java.io.File, java.security.KeyStore$ProtectionParameter, java.security.AccessControlContext):void");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.getKeyStore():java.security.KeyStore, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            public synchronized java.security.KeyStore getKeyStore() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.getKeyStore():java.security.KeyStore, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.getKeyStore():java.security.KeyStore");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.getProtectionParameter(java.lang.String):java.security.KeyStore$ProtectionParameter, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            public synchronized java.security.KeyStore.ProtectionParameter getProtectionParameter(java.lang.String r1) {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.security.KeyStore.Builder.FileBuilder.getProtectionParameter(java.lang.String):java.security.KeyStore$ProtectionParameter, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.FileBuilder.getProtectionParameter(java.lang.String):java.security.KeyStore$ProtectionParameter");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.security.KeyStore.Builder.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 5 more
            */
        protected Builder() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.security.KeyStore.Builder.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.Builder.newInstance(java.lang.String, java.security.Provider, java.io.File, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$Builder, dex: classes.dex
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
        public static java.security.KeyStore.Builder newInstance(java.lang.String r1, java.security.Provider r2, java.io.File r3, java.security.KeyStore.ProtectionParameter r4) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.security.KeyStore.Builder.newInstance(java.lang.String, java.security.Provider, java.io.File, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$Builder, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.newInstance(java.lang.String, java.security.Provider, java.io.File, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$Builder");
        }

        public abstract KeyStore getKeyStore() throws KeyStoreException;

        public abstract ProtectionParameter getProtectionParameter(String str) throws KeyStoreException;

        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        public static java.security.KeyStore.Builder newInstance(java.security.KeyStore r2, java.security.KeyStore.ProtectionParameter r3) {
            /*
                if (r2 == 0) goto L_0x0004
                if (r3 != 0) goto L_0x000a
            L_0x0004:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            L_0x000a:
                boolean r0 = r2.initialized
                if (r0 != 0) goto L_0x0019
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "KeyStore not initialized"
                r0.<init>((java.lang.String) r1)
                throw r0
            L_0x0019:
                java.security.KeyStore$Builder$1 r0 = new java.security.KeyStore$Builder$1
                r0.<init>(r2, r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.newInstance(java.security.KeyStore, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$Builder");
        }

        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        public static java.security.KeyStore.Builder newInstance(java.lang.String r2, java.security.Provider r3, java.security.KeyStore.ProtectionParameter r4) {
            /*
                if (r2 == 0) goto L_0x0004
                if (r4 != 0) goto L_0x000a
            L_0x0004:
                java.lang.NullPointerException r1 = new java.lang.NullPointerException
                r1.<init>()
                throw r1
            L_0x000a:
                java.security.AccessControlContext r0 = java.security.AccessController.getContext()
                java.security.KeyStore$Builder$2 r1 = new java.security.KeyStore$Builder$2
                r1.<init>(r0, r4, r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java.security.KeyStore.Builder.newInstance(java.lang.String, java.security.Provider, java.security.KeyStore$ProtectionParameter):java.security.KeyStore$Builder");
        }
    }
}
