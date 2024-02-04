package sun.misc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

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
public class Cleaner extends PhantomReference {
    private static final ReferenceQueue dummyQueue = null;
    private static Cleaner first;
    private Cleaner next;
    private Cleaner prev;
    private final Runnable thunk;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.misc.Cleaner.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.misc.Cleaner.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.Cleaner.<clinit>():void");
    }

    private static synchronized Cleaner add(Cleaner cl) {
        synchronized (Cleaner.class) {
            if (first != null) {
                cl.next = first;
                first.prev = cl;
            }
            first = cl;
        }
        return cl;
    }

    private static synchronized boolean remove(Cleaner cl) {
        synchronized (Cleaner.class) {
            if (cl.next == cl) {
                return false;
            }
            if (first == cl) {
                if (cl.next != null) {
                    first = cl.next;
                } else {
                    first = cl.prev;
                }
            }
            if (cl.next != null) {
                cl.next.prev = cl.prev;
            }
            if (cl.prev != null) {
                cl.prev.next = cl.next;
            }
            cl.next = cl;
            cl.prev = cl;
            return true;
        }
    }

    private Cleaner(Object referent, Runnable thunk2) {
        super(referent, dummyQueue);
        this.next = null;
        this.prev = null;
        this.thunk = thunk2;
    }

    public static Cleaner create(Object ob, Runnable thunk2) {
        if (thunk2 == null) {
            return null;
        }
        return add(new Cleaner(ob, thunk2));
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    public void clean() {
        /*
            r2 = this;
            boolean r1 = remove(r2)
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Runnable r1 = r2.thunk     // Catch:{ Throwable -> 0x000d }
            r1.run()     // Catch:{ Throwable -> 0x000d }
        L_0x000c:
            return
        L_0x000d:
            r0 = move-exception
            sun.misc.Cleaner$1 r1 = new sun.misc.Cleaner$1
            r1.<init>(r2, r0)
            java.security.AccessController.doPrivileged(r1)
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.Cleaner.clean():void");
    }
}
