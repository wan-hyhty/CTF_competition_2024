package sun.net.www.http;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
/* compiled from: KeepAliveCache */
class ClientVector extends Stack<KeepAliveEntry> {
    private static final long serialVersionUID = -8680532108106489459L;
    int nap;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: sun.net.www.http.ClientVector.<init>(int):void, dex: classes.dex in method: sun.net.www.http.ClientVector.<init>(int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.DecodeException: null in method: sun.net.www.http.ClientVector.<init>(int):void, dex: classes.dex
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:55)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:135)
        	... 4 more
        Caused by: java.io.EOFException
        	at com.android.dx.io.instructions.ShortArrayCodeInput.read(ShortArrayCodeInput.java:54)
        	at com.android.dx.io.instructions.ShortArrayCodeInput.readLong(ShortArrayCodeInput.java:71)
        	at com.android.dx.io.instructions.InstructionCodec$31.decode(InstructionCodec.java:652)
        	at jadx.core.dex.instructions.InsnDecoder.decodeRawInsn(InsnDecoder.java:70)
        	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:52)
        	... 5 more
        */
    ClientVector(int r1) {
        /*
        // Can't load method instructions: Load method exception: null in method: sun.net.www.http.ClientVector.<init>(int):void, dex: classes.dex in method: sun.net.www.http.ClientVector.<init>(int):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.http.ClientVector.<init>(int):void");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.http.ClientVector.get():sun.net.www.http.HttpClient, dex: classes.dex
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
    synchronized sun.net.www.http.HttpClient get() {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.http.ClientVector.get():sun.net.www.http.HttpClient, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.http.ClientVector.get():sun.net.www.http.HttpClient");
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.net.www.http.ClientVector.put(sun.net.www.http.HttpClient):void, dex: classes.dex
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
    synchronized void put(sun.net.www.http.HttpClient r1) {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.net.www.http.ClientVector.put(sun.net.www.http.HttpClient):void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.http.ClientVector.put(sun.net.www.http.HttpClient):void");
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        throw new NotSerializableException();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        throw new NotSerializableException();
    }
}
