package sun.security.provider.certpath;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.util.Debug;

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
class PKIX {
    /* access modifiers changed from: private */
    public static final Debug debug = null;

    static class BuilderParams extends ValidatorParams {
        private boolean buildForward;
        private PKIXBuilderParameters params;
        private List<CertStore> stores;
        private X500Principal targetSubject;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00eb in method: sun.security.provider.certpath.PKIX.BuilderParams.<init>(java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00eb
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        BuilderParams(java.security.cert.PKIXBuilderParameters r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00eb in method: sun.security.provider.certpath.PKIX.BuilderParams.<init>(java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.<init>(java.security.cert.PKIXBuilderParameters):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.BuilderParams.checkParams(java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        private void checkParams(java.security.cert.PKIXBuilderParameters r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.BuilderParams.checkParams(java.security.cert.PKIXBuilderParameters):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.checkParams(java.security.cert.PKIXBuilderParameters):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.BuilderParams.getTargetSubject(java.util.List, java.security.cert.X509CertSelector):javax.security.auth.x500.X500Principal, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        private static javax.security.auth.x500.X500Principal getTargetSubject(java.util.List<java.security.cert.CertStore> r1, java.security.cert.X509CertSelector r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.BuilderParams.getTargetSubject(java.util.List, java.security.cert.X509CertSelector):javax.security.auth.x500.X500Principal, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.getTargetSubject(java.util.List, java.security.cert.X509CertSelector):javax.security.auth.x500.X500Principal");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.PKIX.BuilderParams.buildForward():boolean, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00ef
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        boolean buildForward() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.security.provider.certpath.PKIX.BuilderParams.buildForward():boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.buildForward():boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.certStores():java.util.List<java.security.cert.CertStore>, dex: classes.dex
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
        java.util.List<java.security.cert.CertStore> certStores() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.certStores():java.util.List<java.security.cert.CertStore>, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.certStores():java.util.List");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.maxPathLength():int, dex: classes.dex
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
        int maxPathLength() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.maxPathLength():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.maxPathLength():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.params():java.security.cert.PKIXBuilderParameters, dex: classes.dex
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
        java.security.cert.PKIXBuilderParameters params() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.params():java.security.cert.PKIXBuilderParameters, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.params():java.security.cert.PKIXBuilderParameters");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.targetSubject():javax.security.auth.x500.X500Principal, dex: classes.dex
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
        javax.security.auth.x500.X500Principal targetSubject() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.BuilderParams.targetSubject():javax.security.auth.x500.X500Principal, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.BuilderParams.targetSubject():javax.security.auth.x500.X500Principal");
        }
    }

    private static class CertStoreComparator implements Comparator<CertStore> {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        private CertStoreComparator() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.CertStoreComparator.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.<init>(sun.security.provider.certpath.PKIX$CertStoreComparator):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        /* synthetic */ CertStoreComparator(sun.security.provider.certpath.PKIX.CertStoreComparator r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.<init>(sun.security.provider.certpath.PKIX$CertStoreComparator):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.CertStoreComparator.<init>(sun.security.provider.certpath.PKIX$CertStoreComparator):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.compare(java.lang.Object, java.lang.Object):int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        public /* bridge */ /* synthetic */ int compare(java.lang.Object r1, java.lang.Object r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.compare(java.lang.Object, java.lang.Object):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.CertStoreComparator.compare(java.lang.Object, java.lang.Object):int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.compare(java.security.cert.CertStore, java.security.cert.CertStore):int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        public int compare(java.security.cert.CertStore r1, java.security.cert.CertStore r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.CertStoreComparator.compare(java.security.cert.CertStore, java.security.cert.CertStore):int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.CertStoreComparator.compare(java.security.cert.CertStore, java.security.cert.CertStore):int");
        }
    }

    static class CertStoreTypeException extends CertStoreException {
        private static final long serialVersionUID = 7463352639238322556L;
        private final String type;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.CertStoreTypeException.<init>(java.lang.String, java.security.cert.CertStoreException):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
            	... 6 more
            */
        CertStoreTypeException(java.lang.String r1, java.security.cert.CertStoreException r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.security.provider.certpath.PKIX.CertStoreTypeException.<init>(java.lang.String, java.security.cert.CertStoreException):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.CertStoreTypeException.<init>(java.lang.String, java.security.cert.CertStoreException):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.CertStoreTypeException.getType():java.lang.String, dex: classes.dex
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
        java.lang.String getType() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.security.provider.certpath.PKIX.CertStoreTypeException.getType():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.CertStoreTypeException.getType():java.lang.String");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.PKIX.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.security.provider.certpath.PKIX.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.PKIX.<clinit>():void");
    }

    private PKIX() {
    }

    static boolean isDSAPublicKeyWithoutParams(PublicKey publicKey) {
        if (!(publicKey instanceof DSAPublicKey) || ((DSAPublicKey) publicKey).getParams() != null) {
            return false;
        }
        return true;
    }

    static ValidatorParams checkParams(CertPath cp, CertPathParameters params) throws InvalidAlgorithmParameterException {
        if (params instanceof PKIXParameters) {
            return new ValidatorParams(cp, (PKIXParameters) params);
        }
        throw new InvalidAlgorithmParameterException("inappropriate params, must be an instance of PKIXParameters");
    }

    static BuilderParams checkBuilderParams(CertPathParameters params) throws InvalidAlgorithmParameterException {
        if (params instanceof PKIXBuilderParameters) {
            return new BuilderParams((PKIXBuilderParameters) params);
        }
        throw new InvalidAlgorithmParameterException("inappropriate params, must be an instance of PKIXBuilderParameters");
    }

    static class ValidatorParams {
        private Set<TrustAnchor> anchors;
        private CertPath certPath;
        private List<X509Certificate> certs;
        private List<PKIXCertPathChecker> checkers;
        private CertSelector constraints;
        private Date date;
        private boolean gotConstraints;
        private boolean gotDate;
        private final PKIXParameters params;
        private Set<String> policies;
        private List<CertStore> stores;

        ValidatorParams(CertPath cp, PKIXParameters params2) throws InvalidAlgorithmParameterException {
            this(params2);
            if (cp.getType().equals("X.509") || cp.getType().equals("X509")) {
                this.certPath = cp;
                return;
            }
            throw new InvalidAlgorithmParameterException("inappropriate CertPath type specified, must be X.509 or X509");
        }

        ValidatorParams(PKIXParameters params2) throws InvalidAlgorithmParameterException {
            this.anchors = params2.getTrustAnchors();
            for (TrustAnchor anchor : this.anchors) {
                if (anchor.getNameConstraints() != null) {
                    throw new InvalidAlgorithmParameterException("name constraints in trust anchor not supported");
                }
            }
            this.params = params2;
        }

        /* access modifiers changed from: package-private */
        public CertPath certPath() {
            return this.certPath;
        }

        /* access modifiers changed from: package-private */
        public void setCertPath(CertPath cp) {
            this.certPath = cp;
        }

        /* access modifiers changed from: package-private */
        public List<X509Certificate> certificates() {
            if (this.certs == null) {
                if (this.certPath == null) {
                    this.certs = Collections.emptyList();
                } else {
                    List<X509Certificate> xc = new ArrayList<>(this.certPath.getCertificates());
                    Collections.reverse(xc);
                    this.certs = xc;
                }
            }
            return this.certs;
        }

        /* access modifiers changed from: package-private */
        public List<PKIXCertPathChecker> certPathCheckers() {
            if (this.checkers == null) {
                this.checkers = this.params.getCertPathCheckers();
            }
            return this.checkers;
        }

        /* access modifiers changed from: package-private */
        public List<CertStore> certStores() {
            if (this.stores == null) {
                this.stores = this.params.getCertStores();
            }
            return this.stores;
        }

        /* access modifiers changed from: package-private */
        public Date date() {
            if (!this.gotDate) {
                this.date = this.params.getDate();
                if (this.date == null) {
                    this.date = new Date();
                }
                this.gotDate = true;
            }
            return this.date;
        }

        /* access modifiers changed from: package-private */
        public Set<String> initialPolicies() {
            if (this.policies == null) {
                this.policies = this.params.getInitialPolicies();
            }
            return this.policies;
        }

        /* access modifiers changed from: package-private */
        public CertSelector targetCertConstraints() {
            if (!this.gotConstraints) {
                this.constraints = this.params.getTargetCertConstraints();
                this.gotConstraints = true;
            }
            return this.constraints;
        }

        /* access modifiers changed from: package-private */
        public Set<TrustAnchor> trustAnchors() {
            return this.anchors;
        }

        /* access modifiers changed from: package-private */
        public boolean revocationEnabled() {
            return this.params.isRevocationEnabled();
        }

        /* access modifiers changed from: package-private */
        public boolean policyMappingInhibited() {
            return this.params.isPolicyMappingInhibited();
        }

        /* access modifiers changed from: package-private */
        public boolean explicitPolicyRequired() {
            return this.params.isExplicitPolicyRequired();
        }

        /* access modifiers changed from: package-private */
        public boolean policyQualifiersRejected() {
            return this.params.getPolicyQualifiersRejected();
        }

        /* access modifiers changed from: package-private */
        public String sigProvider() {
            return this.params.getSigProvider();
        }

        /* access modifiers changed from: package-private */
        public boolean anyPolicyInhibited() {
            return this.params.isAnyPolicyInhibited();
        }

        /* access modifiers changed from: package-private */
        public PKIXParameters getPKIXParameters() {
            return this.params;
        }
    }
}
