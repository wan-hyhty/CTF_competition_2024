package java.lang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
public final class ProcessBuilder {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f5assertionsDisabled = false;
    private List<String> command;
    private File directory;
    private Map<String, String> environment;
    private boolean redirectErrorStream;
    private Redirect[] redirects;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.<clinit>():void");
    }

    public ProcessBuilder(List<String> command2) {
        if (command2 == null) {
            throw new NullPointerException();
        }
        this.command = command2;
    }

    public ProcessBuilder(String... command2) {
        this.command = new ArrayList(command2.length);
        for (String arg : command2) {
            this.command.add(arg);
        }
    }

    public ProcessBuilder command(List<String> command2) {
        if (command2 == null) {
            throw new NullPointerException();
        }
        this.command = command2;
        return this;
    }

    public ProcessBuilder command(String... command2) {
        this.command = new ArrayList(command2.length);
        for (String arg : command2) {
            this.command.add(arg);
        }
        return this;
    }

    public List<String> command() {
        return this.command;
    }

    public Map<String, String> environment() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(new RuntimePermission("getenv.*"));
        }
        if (this.environment == null) {
            this.environment = ProcessEnvironment.environment();
        }
        if (!f5assertionsDisabled) {
            if (!(this.environment != null)) {
                throw new AssertionError();
            }
        }
        return this.environment;
    }

    /* access modifiers changed from: package-private */
    public ProcessBuilder environment(String[] envp) {
        boolean z = true;
        if (!f5assertionsDisabled) {
            if (!(this.environment == null)) {
                throw new AssertionError();
            }
        }
        if (envp != null) {
            this.environment = ProcessEnvironment.emptyEnvironment(envp.length);
            if (!f5assertionsDisabled) {
                if (this.environment == null) {
                    z = false;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            for (String envstring : envp) {
                if (envstring.indexOf(0) != -1) {
                    envstring = envstring.replaceFirst("\u0000.*", "");
                }
                int eqlsign = envstring.indexOf(61, 0);
                if (eqlsign != -1) {
                    this.environment.put(envstring.substring(0, eqlsign), envstring.substring(eqlsign + 1));
                }
            }
        }
        return this;
    }

    public File directory() {
        return this.directory;
    }

    public ProcessBuilder directory(File directory2) {
        this.directory = directory2;
        return this;
    }

    static class NullInputStream extends InputStream {
        static final NullInputStream INSTANCE = null;

        private NullInputStream() {
        }

        public int read() {
            return -1;
        }

        public int available() {
            return 0;
        }
    }

    static class NullOutputStream extends OutputStream {
        static final NullOutputStream INSTANCE = null;

        private NullOutputStream() {
        }

        public void write(int b) throws IOException {
            throw new IOException("Stream closed");
        }
    }

    public static abstract class Redirect {

        /* renamed from: -assertionsDisabled  reason: not valid java name */
        static final /* synthetic */ boolean f6assertionsDisabled = false;
        public static final Redirect INHERIT = null;
        public static final Redirect PIPE = null;

        /*  JADX ERROR: NullPointerException in pass: EnumVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
            	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
            */
        public enum Type {
            ;

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.lang.ProcessBuilder.Redirect.Type.<clinit>():void, dex: classes.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
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
                	... 6 more
                */
            static {
                /*
                // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.lang.ProcessBuilder.Redirect.Type.<clinit>():void, dex: classes.dex
                */
                throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.Type.<clinit>():void");
            }
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.Redirect.<clinit>():void, dex: classes.dex
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
        static {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.Redirect.<clinit>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.<clinit>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.lang.ProcessBuilder.Redirect.<init>():void, dex: classes.dex
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
        private Redirect() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.lang.ProcessBuilder.Redirect.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.lang.ProcessBuilder.Redirect.<init>(java.lang.ProcessBuilder$Redirect):void, dex: classes.dex
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
        /* synthetic */ Redirect(java.lang.ProcessBuilder.Redirect r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.lang.ProcessBuilder.Redirect.<init>(java.lang.ProcessBuilder$Redirect):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.<init>(java.lang.ProcessBuilder$Redirect):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.Redirect.equals(java.lang.Object):boolean, dex: classes.dex
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
        public boolean equals(java.lang.Object r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.Redirect.equals(java.lang.Object):boolean, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.equals(java.lang.Object):boolean");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.Redirect.hashCode():int, dex: classes.dex
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
        public int hashCode() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.lang.ProcessBuilder.Redirect.hashCode():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.hashCode():int");
        }

        public abstract Type type();

        public File file() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean append() {
            throw new UnsupportedOperationException();
        }

        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        public static java.lang.ProcessBuilder.Redirect from(java.io.File r1) {
            /*
                if (r1 != 0) goto L_0x0008
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            L_0x0008:
                java.lang.ProcessBuilder$Redirect$3 r0 = new java.lang.ProcessBuilder$Redirect$3
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.from(java.io.File):java.lang.ProcessBuilder$Redirect");
        }

        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        public static java.lang.ProcessBuilder.Redirect to(java.io.File r1) {
            /*
                if (r1 != 0) goto L_0x0008
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            L_0x0008:
                java.lang.ProcessBuilder$Redirect$4 r0 = new java.lang.ProcessBuilder$Redirect$4
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.to(java.io.File):java.lang.ProcessBuilder$Redirect");
        }

        /*  JADX ERROR: NullPointerException in pass: ModVisitor
            java.lang.NullPointerException
            	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
            	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
            	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
            */
        public static java.lang.ProcessBuilder.Redirect appendTo(java.io.File r1) {
            /*
                if (r1 != 0) goto L_0x0008
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            L_0x0008:
                java.lang.ProcessBuilder$Redirect$5 r0 = new java.lang.ProcessBuilder$Redirect$5
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessBuilder.Redirect.appendTo(java.io.File):java.lang.ProcessBuilder$Redirect");
        }
    }

    private Redirect[] redirects() {
        if (this.redirects == null) {
            this.redirects = new Redirect[]{Redirect.PIPE, Redirect.PIPE, Redirect.PIPE};
        }
        return this.redirects;
    }

    public ProcessBuilder redirectInput(Redirect source) {
        if (source.type() == Redirect.Type.WRITE || source.type() == Redirect.Type.APPEND) {
            throw new IllegalArgumentException("Redirect invalid for reading: " + source);
        }
        redirects()[0] = source;
        return this;
    }

    public ProcessBuilder redirectOutput(Redirect destination) {
        if (destination.type() == Redirect.Type.READ) {
            throw new IllegalArgumentException("Redirect invalid for writing: " + destination);
        }
        redirects()[1] = destination;
        return this;
    }

    public ProcessBuilder redirectError(Redirect destination) {
        if (destination.type() == Redirect.Type.READ) {
            throw new IllegalArgumentException("Redirect invalid for writing: " + destination);
        }
        redirects()[2] = destination;
        return this;
    }

    public ProcessBuilder redirectInput(File file) {
        return redirectInput(Redirect.from(file));
    }

    public ProcessBuilder redirectOutput(File file) {
        return redirectOutput(Redirect.to(file));
    }

    public ProcessBuilder redirectError(File file) {
        return redirectError(Redirect.to(file));
    }

    public Redirect redirectInput() {
        return this.redirects == null ? Redirect.PIPE : this.redirects[0];
    }

    public Redirect redirectOutput() {
        return this.redirects == null ? Redirect.PIPE : this.redirects[1];
    }

    public Redirect redirectError() {
        return this.redirects == null ? Redirect.PIPE : this.redirects[2];
    }

    public ProcessBuilder inheritIO() {
        Arrays.fill((Object[]) redirects(), (Object) Redirect.INHERIT);
        return this;
    }

    public boolean redirectErrorStream() {
        return this.redirectErrorStream;
    }

    public ProcessBuilder redirectErrorStream(boolean redirectErrorStream2) {
        this.redirectErrorStream = redirectErrorStream2;
        return this;
    }

    public Process start() throws IOException {
        String[] cmdarray = (String[]) ((String[]) this.command.toArray(new String[this.command.size()])).clone();
        for (String arg : cmdarray) {
            if (arg == null) {
                throw new NullPointerException();
            }
        }
        String prog = cmdarray[0];
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkExec(prog);
        }
        String file = this.directory == null ? null : this.directory.toString();
        try {
            return ProcessImpl.start(cmdarray, this.environment, file, this.redirects, this.redirectErrorStream);
        } catch (IOException | IllegalArgumentException e) {
            String exceptionInfo = ": " + e.getMessage();
            Throwable cause = e;
            if ((e instanceof IOException) && security != null) {
                try {
                    security.checkRead(prog);
                } catch (AccessControlException ace) {
                    exceptionInfo = "";
                    cause = ace;
                }
            }
            throw new IOException("Cannot run program \"" + prog + "\"" + (file == null ? "" : " (in directory \"" + file + "\")") + exceptionInfo, cause);
        }
    }
}
