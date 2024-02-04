package sun.misc;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.jar.JarFile;

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
public class URLClassPath {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final boolean DISABLE_JAR_CHECKING = false;
    static final String JAVA_VERSION = null;
    static final String USER_AGENT_JAVA_VERSION = "UA-Java-Version";
    private boolean closed;
    private URLStreamHandler jarHandler;
    HashMap<String, Loader> lmap;
    ArrayList<Loader> loaders;
    private ArrayList<URL> path;
    Stack<URL> urls;

    private static class FileLoader extends Loader {
        private File dir;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.FileLoader.<init>(java.net.URL):void, dex: classes.dex
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
        FileLoader(java.net.URL r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.FileLoader.<init>(java.net.URL):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.FileLoader.<init>(java.net.URL):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.FileLoader.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
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
        java.net.URL findResource(java.lang.String r1, boolean r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.FileLoader.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.FileLoader.findResource(java.lang.String, boolean):java.net.URL");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.FileLoader.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
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
        sun.misc.Resource getResource(java.lang.String r1, boolean r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.FileLoader.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.FileLoader.getResource(java.lang.String, boolean):sun.misc.Resource");
        }
    }

    static class JarLoader extends Loader {
        private boolean closed;
        private URL csu;
        private URLStreamHandler handler;
        private JarIndex index;
        private JarFile jar;
        private HashMap<String, Loader> lmap;
        private MetaIndex metaIndex;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.-get0(sun.misc.URLClassPath$JarLoader):java.net.URL, dex: classes.dex
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
        /* renamed from: -get0 */
        static /* synthetic */ java.net.URL m657get0(sun.misc.URLClassPath.JarLoader r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.-get0(sun.misc.URLClassPath$JarLoader):java.net.URL, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m657get0(sun.misc.URLClassPath$JarLoader):java.net.URL");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-get1(sun.misc.URLClassPath$JarLoader):java.net.URLStreamHandler, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-get1(sun.misc.URLClassPath$JarLoader):java.net.URLStreamHandler, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.misc.URLClassPath.JarLoader.-get1(sun.misc.URLClassPath$JarLoader):java.net.URLStreamHandler, dex: classes.dex
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
        /* renamed from: -get1 */
        static /* synthetic */ java.net.URLStreamHandler m658get1(sun.misc.URLClassPath.JarLoader r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-get1(sun.misc.URLClassPath$JarLoader):java.net.URLStreamHandler, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-get1(sun.misc.URLClassPath$JarLoader):java.net.URLStreamHandler, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m658get1(sun.misc.URLClassPath$JarLoader):java.net.URLStreamHandler");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-get2(sun.misc.URLClassPath$JarLoader):sun.misc.JarIndex, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-get2(sun.misc.URLClassPath$JarLoader):sun.misc.JarIndex, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.misc.URLClassPath.JarLoader.-get2(sun.misc.URLClassPath$JarLoader):sun.misc.JarIndex, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        /* renamed from: -get2 */
        static /* synthetic */ sun.misc.JarIndex m659get2(sun.misc.URLClassPath.JarLoader r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-get2(sun.misc.URLClassPath$JarLoader):sun.misc.JarIndex, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-get2(sun.misc.URLClassPath$JarLoader):sun.misc.JarIndex, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m659get2(sun.misc.URLClassPath$JarLoader):sun.misc.JarIndex");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.-get3(sun.misc.URLClassPath$JarLoader):java.util.jar.JarFile, dex: classes.dex
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
        /* renamed from: -get3 */
        static /* synthetic */ java.util.jar.JarFile m660get3(sun.misc.URLClassPath.JarLoader r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.-get3(sun.misc.URLClassPath$JarLoader):java.util.jar.JarFile, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m660get3(sun.misc.URLClassPath$JarLoader):java.util.jar.JarFile");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.-get4(sun.misc.URLClassPath$JarLoader):java.util.HashMap, dex: classes.dex
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
        /* renamed from: -get4 */
        static /* synthetic */ java.util.HashMap m661get4(sun.misc.URLClassPath.JarLoader r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.-get4(sun.misc.URLClassPath$JarLoader):java.util.HashMap, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m661get4(sun.misc.URLClassPath$JarLoader):java.util.HashMap");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-get5(sun.misc.URLClassPath$JarLoader):sun.misc.MetaIndex, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-get5(sun.misc.URLClassPath$JarLoader):sun.misc.MetaIndex, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.misc.URLClassPath.JarLoader.-get5(sun.misc.URLClassPath$JarLoader):sun.misc.MetaIndex, dex: classes.dex
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
        /* renamed from: -get5 */
        static /* synthetic */ sun.misc.MetaIndex m662get5(sun.misc.URLClassPath.JarLoader r1) {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-get5(sun.misc.URLClassPath$JarLoader):sun.misc.MetaIndex, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-get5(sun.misc.URLClassPath$JarLoader):sun.misc.MetaIndex, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m662get5(sun.misc.URLClassPath$JarLoader):sun.misc.MetaIndex");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-set0(sun.misc.URLClassPath$JarLoader, sun.misc.JarIndex):sun.misc.JarIndex, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-set0(sun.misc.URLClassPath$JarLoader, sun.misc.JarIndex):sun.misc.JarIndex, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.misc.URLClassPath.JarLoader.-set0(sun.misc.URLClassPath$JarLoader, sun.misc.JarIndex):sun.misc.JarIndex, dex: classes.dex
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
            	... 6 more
            Caused by: java.io.EOFException
            	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
            	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
            	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
            	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
            	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
            	... 7 more
            */
        /* renamed from: -set0 */
        static /* synthetic */ sun.misc.JarIndex m663set0(sun.misc.URLClassPath.JarLoader r1, sun.misc.JarIndex r2) {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.-set0(sun.misc.URLClassPath$JarLoader, sun.misc.JarIndex):sun.misc.JarIndex, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.-set0(sun.misc.URLClassPath$JarLoader, sun.misc.JarIndex):sun.misc.JarIndex, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m663set0(sun.misc.URLClassPath$JarLoader, sun.misc.JarIndex):sun.misc.JarIndex");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.misc.URLClassPath.JarLoader.-set1(sun.misc.URLClassPath$JarLoader, java.util.jar.JarFile):java.util.jar.JarFile, dex: classes.dex
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
        /* renamed from: -set1 */
        static /* synthetic */ java.util.jar.JarFile m664set1(sun.misc.URLClassPath.JarLoader r1, java.util.jar.JarFile r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.misc.URLClassPath.JarLoader.-set1(sun.misc.URLClassPath$JarLoader, java.util.jar.JarFile):java.util.jar.JarFile, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.m664set1(sun.misc.URLClassPath$JarLoader, java.util.jar.JarFile):java.util.jar.JarFile");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.<init>(java.net.URL, java.net.URLStreamHandler, java.util.HashMap):void, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.<init>(java.net.URL, java.net.URLStreamHandler, java.util.HashMap):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.misc.URLClassPath.JarLoader.<init>(java.net.URL, java.net.URLStreamHandler, java.util.HashMap):void, dex: classes.dex
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
        JarLoader(java.net.URL r1, java.net.URLStreamHandler r2, java.util.HashMap<java.lang.String, sun.misc.URLClassPath.Loader> r3) {
            /*
            // Can't load method instructions: Load method exception: null in method: sun.misc.URLClassPath.JarLoader.<init>(java.net.URL, java.net.URLStreamHandler, java.util.HashMap):void, dex: classes.dex in method: sun.misc.URLClassPath.JarLoader.<init>(java.net.URL, java.net.URLStreamHandler, java.util.HashMap):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.<init>(java.net.URL, java.net.URLStreamHandler, java.util.HashMap):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.checkJar(java.util.jar.JarFile):java.util.jar.JarFile, dex: classes.dex
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
        static java.util.jar.JarFile checkJar(java.util.jar.JarFile r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.checkJar(java.util.jar.JarFile):java.util.jar.JarFile, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.checkJar(java.util.jar.JarFile):java.util.jar.JarFile");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.ensureOpen():void, dex: classes.dex
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
        private void ensureOpen() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.ensureOpen():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.ensureOpen():void");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.getJarFile(java.net.URL):java.util.jar.JarFile, dex: classes.dex
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
        public java.util.jar.JarFile getJarFile(java.net.URL r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.getJarFile(java.net.URL):java.util.jar.JarFile, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.getJarFile(java.net.URL):java.util.jar.JarFile");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.isOptimizable(java.net.URL):boolean, dex: classes.dex
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
        private boolean isOptimizable(java.net.URL r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.isOptimizable(java.net.URL):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.isOptimizable(java.net.URL):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.parseClassPath(java.net.URL, java.lang.String):java.net.URL[], dex: classes.dex
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
        private java.net.URL[] parseClassPath(java.net.URL r1, java.lang.String r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.parseClassPath(java.net.URL, java.lang.String):java.net.URL[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.parseClassPath(java.net.URL, java.lang.String):java.net.URL[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.misc.URLClassPath.JarLoader.parseExtensionsDependencies():void, dex: classes.dex
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
        private void parseExtensionsDependencies() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.misc.URLClassPath.JarLoader.parseExtensionsDependencies():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.parseExtensionsDependencies():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.checkResource(java.lang.String, boolean, java.util.jar.JarEntry):sun.misc.Resource, dex: classes.dex
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
        sun.misc.Resource checkResource(java.lang.String r1, boolean r2, java.util.jar.JarEntry r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.checkResource(java.lang.String, boolean, java.util.jar.JarEntry):sun.misc.Resource, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.checkResource(java.lang.String, boolean, java.util.jar.JarEntry):sun.misc.Resource");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.JarLoader.close():void, dex: classes.dex
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
        public void close() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.JarLoader.close():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.close():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
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
        java.net.URL findResource(java.lang.String r1, boolean r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.findResource(java.lang.String, boolean):java.net.URL");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getClassPath():java.net.URL[], dex: classes.dex
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
        java.net.URL[] getClassPath() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getClassPath():java.net.URL[], dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.getClassPath():java.net.URL[]");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getIndex():sun.misc.JarIndex, dex: classes.dex
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
        sun.misc.JarIndex getIndex() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getIndex():sun.misc.JarIndex, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.getIndex():sun.misc.JarIndex");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getJarFile():java.util.jar.JarFile, dex: classes.dex
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
        java.util.jar.JarFile getJarFile() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getJarFile():java.util.jar.JarFile, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.getJarFile():java.util.jar.JarFile");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
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
        sun.misc.Resource getResource(java.lang.String r1, boolean r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.getResource(java.lang.String, boolean):sun.misc.Resource");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getResource(java.lang.String, boolean, java.util.Set):sun.misc.Resource, dex: classes.dex
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
        sun.misc.Resource getResource(java.lang.String r1, boolean r2, java.util.Set<java.lang.String> r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.JarLoader.getResource(java.lang.String, boolean, java.util.Set):sun.misc.Resource, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.getResource(java.lang.String, boolean, java.util.Set):sun.misc.Resource");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.validIndex(java.lang.String):boolean, dex: classes.dex
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
        boolean validIndex(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.JarLoader.validIndex(java.lang.String):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.JarLoader.validIndex(java.lang.String):boolean");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.-get2(sun.misc.URLClassPath):java.net.URLStreamHandler, dex: classes.dex
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
    /* renamed from: -get2 */
    static /* synthetic */ java.net.URLStreamHandler m655get2(sun.misc.URLClassPath r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.-get2(sun.misc.URLClassPath):java.net.URLStreamHandler, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.m655get2(sun.misc.URLClassPath):java.net.URLStreamHandler");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.<clinit>():void, dex: classes.dex
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.<clinit>():void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.misc.URLClassPath.<init>(java.net.URL[]):void, dex: classes.dex
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
    public URLClassPath(java.net.URL[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.misc.URLClassPath.<init>(java.net.URL[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.<init>(java.net.URL[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.misc.URLClassPath.<init>(java.net.URL[], java.net.URLStreamHandlerFactory):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public URLClassPath(java.net.URL[] r1, java.net.URLStreamHandlerFactory r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.misc.URLClassPath.<init>(java.net.URL[], java.net.URLStreamHandlerFactory):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.<init>(java.net.URL[], java.net.URLStreamHandlerFactory):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.check(java.net.URL):void, dex: classes.dex
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
    static void check(java.net.URL r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.check(java.net.URL):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.check(java.net.URL):void");
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.getLoader(int):sun.misc.URLClassPath$Loader, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public synchronized sun.misc.URLClassPath.Loader getLoader(int r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.getLoader(int):sun.misc.URLClassPath$Loader, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getLoader(int):sun.misc.URLClassPath$Loader");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getLoader(java.net.URL):sun.misc.URLClassPath$Loader, dex: classes.dex
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
    private sun.misc.URLClassPath.Loader getLoader(java.net.URL r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getLoader(java.net.URL):sun.misc.URLClassPath$Loader, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getLoader(java.net.URL):sun.misc.URLClassPath$Loader");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.pathToURLs(java.lang.String):java.net.URL[], dex: classes.dex
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
    public static java.net.URL[] pathToURLs(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.pathToURLs(java.lang.String):java.net.URL[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.pathToURLs(java.lang.String):java.net.URL[]");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.push(java.net.URL[]):void, dex: classes.dex
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
    private void push(java.net.URL[] r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.push(java.net.URL[]):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.push(java.net.URL[]):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.addURL(java.net.URL):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public synchronized void addURL(java.net.URL r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.addURL(java.net.URL):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.addURL(java.net.URL):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.closeLoaders():java.util.List<java.io.IOException>, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
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
        	... 5 more
        */
    public synchronized java.util.List<java.io.IOException> closeLoaders() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00ef in method: sun.misc.URLClassPath.closeLoaders():java.util.List<java.io.IOException>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.closeLoaders():java.util.List");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
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
    public java.net.URL findResource(java.lang.String r1, boolean r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.findResource(java.lang.String, boolean):java.net.URL");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getResource(java.lang.String):sun.misc.Resource, dex: classes.dex
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
    public sun.misc.Resource getResource(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getResource(java.lang.String):sun.misc.Resource, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getResource(java.lang.String):sun.misc.Resource");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
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
    public sun.misc.Resource getResource(java.lang.String r1, boolean r2) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getResource(java.lang.String, boolean):sun.misc.Resource");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getResources(java.lang.String):java.util.Enumeration<sun.misc.Resource>, dex: classes.dex
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
    public java.util.Enumeration<sun.misc.Resource> getResources(java.lang.String r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.getResources(java.lang.String):java.util.Enumeration<sun.misc.Resource>, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getResources(java.lang.String):java.util.Enumeration");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.getURLs():java.net.URL[], dex: classes.dex
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
    public java.net.URL[] getURLs() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.getURLs():java.net.URL[], dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getURLs():java.net.URL[]");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public java.util.Enumeration<java.net.URL> findResources(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            sun.misc.URLClassPath$1 r0 = new sun.misc.URLClassPath$1
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.findResources(java.lang.String, boolean):java.util.Enumeration");
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public java.util.Enumeration<sun.misc.Resource> getResources(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            sun.misc.URLClassPath$2 r0 = new sun.misc.URLClassPath$2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getResources(java.lang.String, boolean):java.util.Enumeration");
    }

    public URL checkURL(URL url) {
        try {
            check(url);
            return url;
        } catch (Exception e) {
            return null;
        }
    }

    private static class Loader implements Closeable {
        private final URL base;
        private JarFile jarfile;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.-get0(sun.misc.URLClassPath$Loader):java.net.URL, dex: classes.dex
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
        /* renamed from: -get0 */
        static /* synthetic */ java.net.URL m666get0(sun.misc.URLClassPath.Loader r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.-get0(sun.misc.URLClassPath$Loader):java.net.URL, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.Loader.m666get0(sun.misc.URLClassPath$Loader):java.net.URL");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: sun.misc.URLClassPath.Loader.<init>(java.net.URL):void, dex: classes.dex
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
        Loader(java.net.URL r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: sun.misc.URLClassPath.Loader.<init>(java.net.URL):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.Loader.<init>(java.net.URL):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.close():void, dex: classes.dex
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
        public void close() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.close():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.Loader.close():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
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
        java.net.URL findResource(java.lang.String r1, boolean r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.findResource(java.lang.String, boolean):java.net.URL, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.Loader.findResource(java.lang.String, boolean):java.net.URL");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.getBaseURL():java.net.URL, dex: classes.dex
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
        java.net.URL getBaseURL() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.getBaseURL():java.net.URL, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.Loader.getBaseURL():java.net.URL");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.Loader.getResource(java.lang.String):sun.misc.Resource, dex: classes.dex
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
        sun.misc.Resource getResource(java.lang.String r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.misc.URLClassPath.Loader.getResource(java.lang.String):sun.misc.Resource, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.Loader.getResource(java.lang.String):sun.misc.Resource");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
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
        sun.misc.Resource getResource(java.lang.String r1, boolean r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: sun.misc.URLClassPath.Loader.getResource(java.lang.String, boolean):sun.misc.Resource, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.Loader.getResource(java.lang.String, boolean):sun.misc.Resource");
        }

        /* access modifiers changed from: package-private */
        public URL[] getClassPath() throws IOException {
            return null;
        }
    }
}
