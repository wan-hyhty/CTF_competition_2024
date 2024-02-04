package java.util.prefs;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import sun.util.locale.BaseLocale;
import sun.util.logging.PlatformLogger;

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
public class FileSystemPreferences extends AbstractPreferences {
    private static final int EACCES = 13;
    private static final int EAGAIN = 11;
    /* access modifiers changed from: private */
    public static final String[] EMPTY_STRING_ARRAY = null;
    private static final int ERROR_CODE = 1;
    private static int INIT_SLEEP_TIME = 0;
    private static final int LOCK_HANDLE = 0;
    private static int MAX_ATTEMPTS = 0;
    private static final int USER_READ_WRITE = 384;
    private static final int USER_RWX = 448;
    private static final int USER_RWX_ALL_RX = 493;
    private static final int USER_RW_ALL_READ = 420;
    /* access modifiers changed from: private */
    public static boolean isSystemRootModified;
    /* access modifiers changed from: private */
    public static boolean isSystemRootWritable;
    /* access modifiers changed from: private */
    public static boolean isUserRootModified;
    /* access modifiers changed from: private */
    public static boolean isUserRootWritable;
    static File systemLockFile;
    static Preferences systemRoot;
    /* access modifiers changed from: private */
    public static File systemRootDir;
    private static int systemRootLockHandle;
    /* access modifiers changed from: private */
    public static File systemRootModFile;
    /* access modifiers changed from: private */
    public static long systemRootModTime;
    static File userLockFile;
    static Preferences userRoot;
    /* access modifiers changed from: private */
    public static File userRootDir;
    private static int userRootLockHandle;
    /* access modifiers changed from: private */
    public static File userRootModFile;
    /* access modifiers changed from: private */
    public static long userRootModTime;
    final List<Change> changeLog;
    /* access modifiers changed from: private */
    public final File dir;
    private final boolean isUserNode;
    private long lastSyncTime;
    NodeCreate nodeCreate;
    /* access modifiers changed from: private */
    public Map<String, String> prefsCache;
    /* access modifiers changed from: private */
    public final File prefsFile;
    /* access modifiers changed from: private */
    public final File tmpFile;

    private abstract class Change {
        final /* synthetic */ FileSystemPreferences this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.FileSystemPreferences.Change.<init>(java.util.prefs.FileSystemPreferences):void, dex: classes.dex
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
        private Change(java.util.prefs.FileSystemPreferences r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.FileSystemPreferences.Change.<init>(java.util.prefs.FileSystemPreferences):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.Change.<init>(java.util.prefs.FileSystemPreferences):void");
        }

        /* synthetic */ Change(FileSystemPreferences this$02, Change change) {
            this(this$02);
        }

        /* access modifiers changed from: package-private */
        public abstract void replay();
    }

    private class NodeCreate extends Change {
        final /* synthetic */ FileSystemPreferences this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.FileSystemPreferences.NodeCreate.<init>(java.util.prefs.FileSystemPreferences):void, dex: classes.dex
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
        private NodeCreate(java.util.prefs.FileSystemPreferences r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.FileSystemPreferences.NodeCreate.<init>(java.util.prefs.FileSystemPreferences):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.NodeCreate.<init>(java.util.prefs.FileSystemPreferences):void");
        }

        /* synthetic */ NodeCreate(FileSystemPreferences this$02, NodeCreate nodeCreate) {
            this(this$02);
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.prefs.FileSystemPreferences.NodeCreate.replay():void, dex: classes.dex
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
        void replay() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.prefs.FileSystemPreferences.NodeCreate.replay():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.NodeCreate.replay():void");
        }
    }

    private class Put extends Change {
        String key;
        final /* synthetic */ FileSystemPreferences this$0;
        String value;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.prefs.FileSystemPreferences.Put.<init>(java.util.prefs.FileSystemPreferences, java.lang.String, java.lang.String):void, dex: classes.dex in method: java.util.prefs.FileSystemPreferences.Put.<init>(java.util.prefs.FileSystemPreferences, java.lang.String, java.lang.String):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.prefs.FileSystemPreferences.Put.<init>(java.util.prefs.FileSystemPreferences, java.lang.String, java.lang.String):void, dex: classes.dex
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
        Put(java.util.prefs.FileSystemPreferences r1, java.lang.String r2, java.lang.String r3) {
            /*
            // Can't load method instructions: Load method exception: null in method: java.util.prefs.FileSystemPreferences.Put.<init>(java.util.prefs.FileSystemPreferences, java.lang.String, java.lang.String):void, dex: classes.dex in method: java.util.prefs.FileSystemPreferences.Put.<init>(java.util.prefs.FileSystemPreferences, java.lang.String, java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.Put.<init>(java.util.prefs.FileSystemPreferences, java.lang.String, java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.Put.replay():void, dex: classes.dex
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
        void replay() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.Put.replay():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.Put.replay():void");
        }
    }

    private class Remove extends Change {
        String key;
        final /* synthetic */ FileSystemPreferences this$0;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.FileSystemPreferences.Remove.<init>(java.util.prefs.FileSystemPreferences, java.lang.String):void, dex: classes.dex
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
        Remove(java.util.prefs.FileSystemPreferences r1, java.lang.String r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e8 in method: java.util.prefs.FileSystemPreferences.Remove.<init>(java.util.prefs.FileSystemPreferences, java.lang.String):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.Remove.<init>(java.util.prefs.FileSystemPreferences, java.lang.String):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.Remove.replay():void, dex: classes.dex
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
        void replay() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.Remove.replay():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.Remove.replay():void");
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.<clinit>():void, dex: classes.dex
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
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.<clinit>():void");
    }

    /* access modifiers changed from: private */
    public static native int chmod(String str, int i);

    private static native int[] lockFile0(String str, int i, boolean z);

    private static native int unlockFile0(int i);

    /* access modifiers changed from: private */
    public static PlatformLogger getLogger() {
        return PlatformLogger.getLogger("java.util.prefs");
    }

    static synchronized Preferences getUserRoot() {
        Preferences preferences;
        synchronized (FileSystemPreferences.class) {
            if (userRoot == null) {
                setupUserRoot();
                userRoot = new FileSystemPreferences(true);
            }
            preferences = userRoot;
        }
        return preferences;
    }

    private static void setupUserRoot() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.2.run():java.lang.Object, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.2.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass2.run():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.2.run():java.lang.Void, dex: classes.dex
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
            public java.lang.Void run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.2.run():java.lang.Void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass2.run():java.lang.Void");
            }
        });
    }

    static synchronized Preferences getSystemRoot() {
        Preferences preferences;
        synchronized (FileSystemPreferences.class) {
            if (systemRoot == null) {
                setupSystemRoot();
                systemRoot = new FileSystemPreferences(false);
            }
            preferences = systemRoot;
        }
        return preferences;
    }

    private static void setupSystemRoot() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.3.run():java.lang.Object, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.3.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass3.run():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.3.run():java.lang.Void, dex: classes.dex
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
            public java.lang.Void run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.3.run():java.lang.Void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass3.run():java.lang.Void");
            }
        });
    }

    private void replayChanges() {
        int n = this.changeLog.size();
        for (int i = 0; i < n; i++) {
            this.changeLog.get(i).replay();
        }
    }

    /* access modifiers changed from: private */
    public static void syncWorld() {
        Preferences userRt;
        Preferences systemRt;
        synchronized (FileSystemPreferences.class) {
            userRt = userRoot;
            systemRt = systemRoot;
        }
        if (userRt != null) {
            try {
                userRt.flush();
            } catch (BackingStoreException e) {
                getLogger().warning("Couldn't flush user prefs: " + e);
            }
        }
        if (systemRt != null) {
            try {
                systemRt.flush();
            } catch (BackingStoreException e2) {
                getLogger().warning("Couldn't flush system prefs: " + e2);
            }
        }
    }

    private FileSystemPreferences(boolean user) {
        super((AbstractPreferences) null, "");
        this.prefsCache = null;
        this.lastSyncTime = 0;
        this.changeLog = new ArrayList();
        this.nodeCreate = null;
        this.isUserNode = user;
        this.dir = user ? userRootDir : systemRootDir;
        this.prefsFile = new File(this.dir, "prefs.xml");
        this.tmpFile = new File(this.dir, "prefs.tmp");
    }

    public FileSystemPreferences(String path, File lockFile, boolean isUserNode2) {
        super((AbstractPreferences) null, "");
        this.prefsCache = null;
        this.lastSyncTime = 0;
        this.changeLog = new ArrayList();
        this.nodeCreate = null;
        this.isUserNode = isUserNode2;
        this.dir = new File(path);
        this.prefsFile = new File(this.dir, "prefs.xml");
        this.tmpFile = new File(this.dir, "prefs.tmp");
        this.newNode = !this.dir.exists();
        if (this.newNode) {
            this.prefsCache = new TreeMap();
            this.nodeCreate = new NodeCreate(this, (NodeCreate) null);
            this.changeLog.add(this.nodeCreate);
        }
        if (isUserNode2) {
            userLockFile = lockFile;
            userRootModFile = new File(lockFile.getParentFile(), lockFile.getName() + ".rootmod");
            return;
        }
        systemLockFile = lockFile;
        systemRootModFile = new File(lockFile.getParentFile(), lockFile.getName() + ".rootmod");
    }

    private FileSystemPreferences(FileSystemPreferences parent, String name) {
        super(parent, name);
        this.prefsCache = null;
        this.lastSyncTime = 0;
        this.changeLog = new ArrayList();
        this.nodeCreate = null;
        this.isUserNode = parent.isUserNode;
        this.dir = new File(parent.dir, dirName(name));
        this.prefsFile = new File(this.dir, "prefs.xml");
        this.tmpFile = new File(this.dir, "prefs.tmp");
        AccessController.doPrivileged(new PrivilegedAction<Void>(this) {
            final /* synthetic */ FileSystemPreferences this$0;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.4.run():java.lang.Object, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.4.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass4.run():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.4.run():java.lang.Void, dex: classes.dex
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
            public java.lang.Void run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.4.run():java.lang.Void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass4.run():java.lang.Void");
            }
        });
        if (this.newNode) {
            this.prefsCache = new TreeMap();
            this.nodeCreate = new NodeCreate(this, (NodeCreate) null);
            this.changeLog.add(this.nodeCreate);
        }
    }

    public boolean isUserNode() {
        return this.isUserNode;
    }

    /* access modifiers changed from: protected */
    public void putSpi(String key, String value) {
        initCacheIfNecessary();
        this.changeLog.add(new Put(this, key, value));
        this.prefsCache.put(key, value);
    }

    /* access modifiers changed from: protected */
    public String getSpi(String key) {
        initCacheIfNecessary();
        return this.prefsCache.get(key);
    }

    /* access modifiers changed from: protected */
    public void removeSpi(String key) {
        initCacheIfNecessary();
        this.changeLog.add(new Remove(this, key));
        this.prefsCache.remove(key);
    }

    private void initCacheIfNecessary() {
        if (this.prefsCache == null) {
            try {
                loadCache();
            } catch (Exception e) {
                this.prefsCache = new TreeMap();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e A[SYNTHETIC, Splitter:B:27:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[SYNTHETIC, Splitter:B:30:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f A[Catch:{ Exception -> 0x0021 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadCache() throws java.util.prefs.BackingStoreException {
        /*
            r11 = this;
            r7 = 0
            java.util.TreeMap r3 = new java.util.TreeMap
            r3.<init>()
            r4 = 0
            java.io.File r6 = r11.prefsFile     // Catch:{ Exception -> 0x0021 }
            long r4 = r6.lastModified()     // Catch:{ Exception -> 0x0021 }
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0066, all -> 0x00cb }
            java.io.File r6 = r11.prefsFile     // Catch:{ Throwable -> 0x0066, all -> 0x00cb }
            r2.<init>((java.io.File) r6)     // Catch:{ Throwable -> 0x0066, all -> 0x00cb }
            java.util.prefs.XmlSupport.importMap(r2, r3)     // Catch:{ Throwable -> 0x00d0, all -> 0x00cd }
            if (r2 == 0) goto L_0x001e
            r2.close()     // Catch:{ Throwable -> 0x0064 }
        L_0x001e:
            if (r7 == 0) goto L_0x005f
            throw r7     // Catch:{ Exception -> 0x0021 }
        L_0x0021:
            r0 = move-exception
            boolean r6 = r0 instanceof java.util.prefs.InvalidPreferencesFormatException
            if (r6 == 0) goto L_0x0080
            sun.util.logging.PlatformLogger r6 = getLogger()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Invalid preferences format in "
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)
            java.io.File r8 = r11.prefsFile
            java.lang.String r8 = r8.getPath()
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            r6.warning(r7)
            java.io.File r6 = r11.prefsFile
            java.io.File r7 = new java.io.File
            java.io.File r8 = r11.prefsFile
            java.io.File r8 = r8.getParentFile()
            java.lang.String r9 = "IncorrectFormatPrefs.xml"
            r7.<init>((java.io.File) r8, (java.lang.String) r9)
            r6.renameTo(r7)
            java.util.TreeMap r3 = new java.util.TreeMap
            r3.<init>()
        L_0x005f:
            r11.prefsCache = r3
            r11.lastSyncTime = r4
            return
        L_0x0064:
            r7 = move-exception
            goto L_0x001e
        L_0x0066:
            r6 = move-exception
        L_0x0067:
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r7 = move-exception
            r10 = r7
            r7 = r6
            r6 = r10
        L_0x006c:
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ Throwable -> 0x0074 }
        L_0x0071:
            if (r7 == 0) goto L_0x007f
            throw r7     // Catch:{ Exception -> 0x0021 }
        L_0x0074:
            r8 = move-exception
            if (r7 != 0) goto L_0x0079
            r7 = r8
            goto L_0x0071
        L_0x0079:
            if (r7 == r8) goto L_0x0071
            r7.addSuppressed(r8)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0071
        L_0x007f:
            throw r6     // Catch:{ Exception -> 0x0021 }
        L_0x0080:
            boolean r6 = r0 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L_0x00a6
            sun.util.logging.PlatformLogger r6 = getLogger()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Prefs file removed in background "
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)
            java.io.File r8 = r11.prefsFile
            java.lang.String r8 = r8.getPath()
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            r6.warning(r7)
            goto L_0x005f
        L_0x00a6:
            sun.util.logging.PlatformLogger r6 = getLogger()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Exception while reading cache: "
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)
            java.lang.String r8 = r0.getMessage()
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            r6.warning(r7)
            java.util.prefs.BackingStoreException r6 = new java.util.prefs.BackingStoreException
            r6.<init>((java.lang.Throwable) r0)
            throw r6
        L_0x00cb:
            r6 = move-exception
            goto L_0x006c
        L_0x00cd:
            r6 = move-exception
            r1 = r2
            goto L_0x006c
        L_0x00d0:
            r6 = move-exception
            r1 = r2
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.loadCache():void");
    }

    private void writeBackCache() throws BackingStoreException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>(this) {
                final /* synthetic */ FileSystemPreferences this$0;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.5.run():java.lang.Object, dex: classes.dex
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
                public /* bridge */ /* synthetic */ java.lang.Object run() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.5.run():java.lang.Object, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass5.run():java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.5.run():java.lang.Void, dex: classes.dex
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
                public java.lang.Void run() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.5.run():java.lang.Void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass5.run():java.lang.Void");
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((BackingStoreException) e.getException());
        }
    }

    /* access modifiers changed from: protected */
    public String[] keysSpi() {
        initCacheIfNecessary();
        return (String[]) this.prefsCache.keySet().toArray(new String[this.prefsCache.size()]);
    }

    /* access modifiers changed from: protected */
    public String[] childrenNamesSpi() {
        return (String[]) AccessController.doPrivileged(new PrivilegedAction<String[]>(this) {
            final /* synthetic */ FileSystemPreferences this$0;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.6.run():java.lang.Object, dex: classes.dex
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
            public /* bridge */ /* synthetic */ java.lang.Object run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.6.run():java.lang.Object, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass6.run():java.lang.Object");
            }

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.6.run():java.lang.String[], dex: classes.dex
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
            public java.lang.String[] run() {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 00e5 in method: java.util.prefs.FileSystemPreferences.6.run():java.lang.String[], dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass6.run():java.lang.String[]");
            }
        });
    }

    /* access modifiers changed from: protected */
    public AbstractPreferences childSpi(String name) {
        return new FileSystemPreferences(this, name);
    }

    public void removeNode() throws BackingStoreException {
        synchronized ((isUserNode() ? userLockFile : systemLockFile)) {
            if (!lockFile(false)) {
                throw new BackingStoreException("Couldn't get file lock.");
            }
            try {
                super.removeNode();
            } finally {
                unlockFile();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeNodeSpi() throws BackingStoreException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>(this) {
                final /* synthetic */ FileSystemPreferences this$0;

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.7.run():java.lang.Object, dex: classes.dex
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
                public /* bridge */ /* synthetic */ java.lang.Object run() {
                    /*
                    // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.prefs.FileSystemPreferences.7.run():java.lang.Object, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass7.run():java.lang.Object");
                }

                /*  JADX ERROR: Method load error
                    jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: java.util.prefs.FileSystemPreferences.7.run():java.lang.Void, dex: classes.dex in method: java.util.prefs.FileSystemPreferences.7.run():java.lang.Void, dex: classes.dex
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.DecodeException: null in method: java.util.prefs.FileSystemPreferences.7.run():java.lang.Void, dex: classes.dex
                    	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
                    	... 5 more
                    Caused by: java.io.EOFException
                    	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
                    	at com.android.dx.io.instructions.ShortArrayCodeInput.readInt(ShortArrayCodeInput.java:62)
                    	at com.android.dx.io.instructions.InstructionCodec$34.decode(InstructionCodec.java:756)
                    	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
                    	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
                    	... 6 more
                    */
                public java.lang.Void run() {
                    /*
                    // Can't load method instructions: Load method exception: null in method: java.util.prefs.FileSystemPreferences.7.run():java.lang.Void, dex: classes.dex in method: java.util.prefs.FileSystemPreferences.7.run():java.lang.Void, dex: classes.dex
                    */
                    throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.AnonymousClass7.run():java.lang.Void");
                }
            });
        } catch (PrivilegedActionException e) {
            throw ((BackingStoreException) e.getException());
        }
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public synchronized void sync() throws java.util.prefs.BackingStoreException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r2 = r6.isUserNode()     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x0027
            r1 = 0
        L_0x0008:
            boolean r3 = r6.isUserNode()     // Catch:{ all -> 0x0024 }
            if (r3 == 0) goto L_0x002f
            java.io.File r3 = userLockFile     // Catch:{ all -> 0x0024 }
            r4 = r3
        L_0x0011:
            monitor-enter(r4)     // Catch:{ all -> 0x0024 }
            boolean r3 = r6.lockFile(r1)     // Catch:{ all -> 0x0021 }
            if (r3 != 0) goto L_0x0033
            java.util.prefs.BackingStoreException r3 = new java.util.prefs.BackingStoreException     // Catch:{ all -> 0x0021 }
            java.lang.String r5 = "Couldn't get file lock."
            r3.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0021 }
            throw r3     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0024 }
            throw r3     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r3 = move-exception
            monitor-exit(r6)
            throw r3
        L_0x0027:
            boolean r3 = isSystemRootWritable     // Catch:{ all -> 0x0024 }
            if (r3 == 0) goto L_0x002d
            r1 = 0
            goto L_0x0008
        L_0x002d:
            r1 = 1
            goto L_0x0008
        L_0x002f:
            java.io.File r3 = systemLockFile     // Catch:{ all -> 0x0024 }
            r4 = r3
            goto L_0x0011
        L_0x0033:
            java.util.prefs.FileSystemPreferences$8 r3 = new java.util.prefs.FileSystemPreferences$8     // Catch:{ all -> 0x0021 }
            r3.<init>(r6)     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r3)     // Catch:{ all -> 0x0021 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0021 }
            super.sync()     // Catch:{ all -> 0x004f }
            java.util.prefs.FileSystemPreferences$9 r3 = new java.util.prefs.FileSystemPreferences$9     // Catch:{ all -> 0x004f }
            r3.<init>(r6, r0)     // Catch:{ all -> 0x004f }
            java.security.AccessController.doPrivileged(r3)     // Catch:{ all -> 0x004f }
            r6.unlockFile()     // Catch:{ all -> 0x0021 }
            monitor-exit(r4)     // Catch:{ all -> 0x0024 }
            monitor-exit(r6)
            return
        L_0x004f:
            r3 = move-exception
            r6.unlockFile()     // Catch:{ all -> 0x0021 }
            throw r3     // Catch:{ all -> 0x0021 }
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.prefs.FileSystemPreferences.sync():void");
    }

    /* access modifiers changed from: protected */
    public void syncSpi() throws BackingStoreException {
        syncSpiPrivileged();
    }

    private void syncSpiPrivileged() throws BackingStoreException {
        if (isRemoved()) {
            throw new IllegalStateException("Node has been removed");
        } else if (this.prefsCache != null) {
            if (isUserNode() ? isUserRootModified : isSystemRootModified) {
                long lastModifiedTime = this.prefsFile.lastModified();
                if (lastModifiedTime != this.lastSyncTime) {
                    loadCache();
                    replayChanges();
                    this.lastSyncTime = lastModifiedTime;
                }
            } else if (this.lastSyncTime != 0 && !this.dir.exists()) {
                this.prefsCache = new TreeMap();
                replayChanges();
            }
            if (!this.changeLog.isEmpty()) {
                writeBackCache();
                long lastModifiedTime2 = this.prefsFile.lastModified();
                if (this.lastSyncTime <= lastModifiedTime2) {
                    this.lastSyncTime = 1000 + lastModifiedTime2;
                    this.prefsFile.setLastModified(this.lastSyncTime);
                }
                this.changeLog.clear();
            }
        }
    }

    public void flush() throws BackingStoreException {
        if (!isRemoved()) {
            sync();
        }
    }

    /* access modifiers changed from: protected */
    public void flushSpi() throws BackingStoreException {
    }

    private static boolean isDirChar(char ch) {
        return (ch <= 31 || ch >= 127 || ch == '/' || ch == '.' || ch == '_') ? false : true;
    }

    private static String dirName(String nodeName) {
        int n = nodeName.length();
        for (int i = 0; i < n; i++) {
            if (!isDirChar(nodeName.charAt(i))) {
                return BaseLocale.SEP + Base64.byteArrayToAltBase64(byteArray(nodeName));
            }
        }
        return nodeName;
    }

    private static byte[] byteArray(String s) {
        int len = s.length();
        byte[] result = new byte[(len * 2)];
        int j = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int j2 = j + 1;
            result[j] = (byte) (c >> 8);
            j = j2 + 1;
            result[j2] = (byte) c;
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static String nodeName(String dirName) {
        if (dirName.charAt(0) != '_') {
            return dirName;
        }
        byte[] a = Base64.altBase64ToByteArray(dirName.substring(1));
        StringBuffer result = new StringBuffer(a.length / 2);
        int i = 0;
        while (i < a.length) {
            int i2 = i + 1;
            int highByte = a[i] & 255;
            i = i2 + 1;
            result.append((char) ((highByte << 8) | (a[i2] & 255)));
        }
        return result.toString();
    }

    private boolean lockFile(boolean shared) throws SecurityException {
        boolean usernode = isUserNode();
        int errorCode = 0;
        File lockFile = usernode ? userLockFile : systemLockFile;
        long sleepTime = (long) INIT_SLEEP_TIME;
        int i = 0;
        while (i < MAX_ATTEMPTS) {
            try {
                int[] result = lockFile0(lockFile.getCanonicalPath(), usernode ? USER_READ_WRITE : USER_RW_ALL_READ, shared);
                errorCode = result[1];
                if (result[0] != 0) {
                    if (usernode) {
                        userRootLockHandle = result[0];
                    } else {
                        systemRootLockHandle = result[0];
                    }
                    return true;
                }
            } catch (IOException e) {
            }
            try {
                Thread.sleep(sleepTime);
                sleepTime *= 2;
                i++;
            } catch (InterruptedException e2) {
                checkLockFile0ErrorCode(errorCode);
                return false;
            }
        }
        checkLockFile0ErrorCode(errorCode);
        return false;
    }

    private void checkLockFile0ErrorCode(int errorCode) throws SecurityException {
        if (errorCode == 13) {
            throw new SecurityException("Could not lock " + (isUserNode() ? "User prefs." : "System prefs.") + " Lock file access denied.");
        } else if (errorCode != 11) {
            getLogger().warning("Could not lock " + (isUserNode() ? "User prefs. " : "System prefs.") + " Unix error code " + errorCode + ".");
        }
    }

    private void unlockFile() {
        boolean usernode = isUserNode();
        if (usernode) {
            File file = userLockFile;
        } else {
            File lockFile = systemLockFile;
        }
        int lockHandle = usernode ? userRootLockHandle : systemRootLockHandle;
        if (lockHandle == 0) {
            getLogger().warning("Unlock: zero lockHandle for " + (usernode ? "user" : "system") + " preferences.)");
            return;
        }
        int result = unlockFile0(lockHandle);
        if (result != 0) {
            getLogger().warning("Could not drop file-lock on " + (isUserNode() ? "user" : "system") + " preferences." + " Unix error code " + result + ".");
            if (result == 13) {
                throw new SecurityException("Could not unlock" + (isUserNode() ? "User prefs." : "System prefs.") + " Lock file access denied.");
            }
        }
        if (isUserNode()) {
            userRootLockHandle = 0;
        } else {
            systemRootLockHandle = 0;
        }
    }
}
