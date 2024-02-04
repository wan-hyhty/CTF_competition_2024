package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

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
class InheritedChannel {

    /* renamed from: -assertionsDisabled  reason: not valid java name */
    static final /* synthetic */ boolean f127assertionsDisabled = false;
    private static final int O_RDONLY = 0;
    private static final int O_RDWR = 2;
    private static final int O_WRONLY = 1;
    private static final int SOCK_DGRAM = 2;
    private static final int SOCK_STREAM = 1;
    private static final int UNKNOWN = -1;
    private static Channel channel;
    private static int devnull;
    private static boolean haveChannel;

    public static class InheritedDatagramChannelImpl extends DatagramChannelImpl {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor):void, dex: classes.dex
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
        InheritedDatagramChannelImpl(java.nio.channels.spi.SelectorProvider r1, java.io.FileDescriptor r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor):void");
        }

        public /* bridge */ /* synthetic */ DatagramChannel connect(SocketAddress sa) {
            return super.connect(sa);
        }

        public /* bridge */ /* synthetic */ DatagramChannel disconnect() {
            return super.disconnect();
        }

        public /* bridge */ /* synthetic */ FileDescriptor getFD() {
            return super.getFD();
        }

        public /* bridge */ /* synthetic */ int getFDVal() {
            return super.getFDVal();
        }

        public /* bridge */ /* synthetic */ SocketAddress getLocalAddress() {
            return super.getLocalAddress();
        }

        public /* bridge */ /* synthetic */ Object getOption(SocketOption name) {
            return super.getOption(name);
        }

        public /* bridge */ /* synthetic */ SocketAddress getRemoteAddress() {
            return super.getRemoteAddress();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.implCloseSelectableChannel():void, dex: classes.dex
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
        protected void implCloseSelectableChannel() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.implCloseSelectableChannel():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.implCloseSelectableChannel():void");
        }

        public /* bridge */ /* synthetic */ boolean isConnected() {
            return super.isConnected();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.kill():void, dex: classes.dex
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
        public /* bridge */ /* synthetic */ void kill() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.kill():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.kill():void");
        }

        public /* bridge */ /* synthetic */ SocketAddress localAddress() {
            return super.localAddress();
        }

        public /* bridge */ /* synthetic */ int read(ByteBuffer buf) {
            return super.read(buf);
        }

        public /* bridge */ /* synthetic */ long read(ByteBuffer[] dsts, int offset, int length) {
            return super.read(dsts, offset, length);
        }

        public /* bridge */ /* synthetic */ SocketAddress receive(ByteBuffer dst) {
            return super.receive(dst);
        }

        public /* bridge */ /* synthetic */ SocketAddress remoteAddress() {
            return super.remoteAddress();
        }

        public /* bridge */ /* synthetic */ int send(ByteBuffer src, SocketAddress target) {
            return super.send(src, target);
        }

        public /* bridge */ /* synthetic */ DatagramChannel setOption(SocketOption name, Object value) {
            return super.setOption(name, value);
        }

        public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption name, Object value) {
            return super.setOption(name, value);
        }

        public /* bridge */ /* synthetic */ DatagramSocket socket() {
            return super.socket();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void, dex: classes.dex
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
        public /* bridge */ /* synthetic */ void translateAndSetInterestOps(int r1, sun.nio.ch.SelectionKeyImpl r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedDatagramChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void");
        }

        public /* bridge */ /* synthetic */ boolean translateAndSetReadyOps(int ops, SelectionKeyImpl sk) {
            return super.translateAndSetReadyOps(ops, sk);
        }

        public /* bridge */ /* synthetic */ boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl sk) {
            return super.translateAndUpdateReadyOps(ops, sk);
        }

        public /* bridge */ /* synthetic */ boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
            return super.translateReadyOps(ops, initialOps, sk);
        }

        public /* bridge */ /* synthetic */ int write(ByteBuffer buf) {
            return super.write(buf);
        }

        public /* bridge */ /* synthetic */ long write(ByteBuffer[] srcs, int offset, int length) {
            return super.write(srcs, offset, length);
        }
    }

    public static class InheritedServerSocketChannelImpl extends ServerSocketChannelImpl {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor):void, dex: classes.dex
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
        InheritedServerSocketChannelImpl(java.nio.channels.spi.SelectorProvider r1, java.io.FileDescriptor r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor):void");
        }

        public /* bridge */ /* synthetic */ SocketChannel accept() {
            return super.accept();
        }

        public /* bridge */ /* synthetic */ ServerSocketChannel bind(SocketAddress local, int backlog) {
            return super.bind(local, backlog);
        }

        public /* bridge */ /* synthetic */ FileDescriptor getFD() {
            return super.getFD();
        }

        public /* bridge */ /* synthetic */ int getFDVal() {
            return super.getFDVal();
        }

        public /* bridge */ /* synthetic */ SocketAddress getLocalAddress() {
            return super.getLocalAddress();
        }

        public /* bridge */ /* synthetic */ Object getOption(SocketOption name) {
            return super.getOption(name);
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.implCloseSelectableChannel():void, dex: classes.dex
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
        protected void implCloseSelectableChannel() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.implCloseSelectableChannel():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.implCloseSelectableChannel():void");
        }

        public /* bridge */ /* synthetic */ boolean isBound() {
            return super.isBound();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.kill():void, dex: classes.dex
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
        public /* bridge */ /* synthetic */ void kill() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.kill():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.kill():void");
        }

        public /* bridge */ /* synthetic */ InetSocketAddress localAddress() {
            return super.localAddress();
        }

        public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption name, Object value) {
            return super.setOption(name, value);
        }

        public /* bridge */ /* synthetic */ ServerSocketChannel setOption(SocketOption name, Object value) {
            return super.setOption(name, value);
        }

        public /* bridge */ /* synthetic */ ServerSocket socket() {
            return super.socket();
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void, dex: classes.dex
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
        public /* bridge */ /* synthetic */ void translateAndSetInterestOps(int r1, sun.nio.ch.SelectionKeyImpl r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedServerSocketChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void");
        }

        public /* bridge */ /* synthetic */ boolean translateAndSetReadyOps(int ops, SelectionKeyImpl sk) {
            return super.translateAndSetReadyOps(ops, sk);
        }

        public /* bridge */ /* synthetic */ boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl sk) {
            return super.translateAndUpdateReadyOps(ops, sk);
        }

        public /* bridge */ /* synthetic */ boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
            return super.translateReadyOps(ops, initialOps, sk);
        }
    }

    public static class InheritedSocketChannelImpl extends SocketChannelImpl {
        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor, java.net.InetSocketAddress):void, dex: classes.dex
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
        InheritedSocketChannelImpl(java.nio.channels.spi.SelectorProvider r1, java.io.FileDescriptor r2, java.net.InetSocketAddress r3) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor, java.net.InetSocketAddress):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.<init>(java.nio.channels.spi.SelectorProvider, java.io.FileDescriptor, java.net.InetSocketAddress):void");
        }

        public /* bridge */ /* synthetic */ NetworkChannel bind(SocketAddress local) {
            return super.bind(local);
        }

        public /* bridge */ /* synthetic */ SocketChannel bind(SocketAddress local) {
            return super.bind(local);
        }

        public /* bridge */ /* synthetic */ boolean connect(SocketAddress sa) {
            return super.connect(sa);
        }

        public /* bridge */ /* synthetic */ boolean finishConnect() {
            return super.finishConnect();
        }

        public /* bridge */ /* synthetic */ FileDescriptor getFD() {
            return super.getFD();
        }

        public /* bridge */ /* synthetic */ int getFDVal() {
            return super.getFDVal();
        }

        public /* bridge */ /* synthetic */ SocketAddress getLocalAddress() {
            return super.getLocalAddress();
        }

        public /* bridge */ /* synthetic */ Object getOption(SocketOption name) {
            return super.getOption(name);
        }

        public /* bridge */ /* synthetic */ SocketAddress getRemoteAddress() {
            return super.getRemoteAddress();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.implCloseSelectableChannel():void, dex: classes.dex
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
        protected void implCloseSelectableChannel() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.implCloseSelectableChannel():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.implCloseSelectableChannel():void");
        }

        public /* bridge */ /* synthetic */ boolean isConnected() {
            return super.isConnected();
        }

        public /* bridge */ /* synthetic */ boolean isConnectionPending() {
            return super.isConnectionPending();
        }

        public /* bridge */ /* synthetic */ boolean isInputOpen() {
            return super.isInputOpen();
        }

        public /* bridge */ /* synthetic */ boolean isOutputOpen() {
            return super.isOutputOpen();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.kill():void, dex: classes.dex
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
        public /* bridge */ /* synthetic */ void kill() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.kill():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.kill():void");
        }

        public /* bridge */ /* synthetic */ InetSocketAddress localAddress() {
            return super.localAddress();
        }

        public /* bridge */ /* synthetic */ int read(ByteBuffer buf) {
            return super.read(buf);
        }

        public /* bridge */ /* synthetic */ long read(ByteBuffer[] dsts, int offset, int length) {
            return super.read(dsts, offset, length);
        }

        public /* bridge */ /* synthetic */ SocketAddress remoteAddress() {
            return super.remoteAddress();
        }

        public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption name, Object value) {
            return super.setOption(name, value);
        }

        public /* bridge */ /* synthetic */ SocketChannel setOption(SocketOption name, Object value) {
            return super.setOption(name, value);
        }

        public /* bridge */ /* synthetic */ SocketChannel shutdownInput() {
            return super.shutdownInput();
        }

        public /* bridge */ /* synthetic */ SocketChannel shutdownOutput() {
            return super.shutdownOutput();
        }

        public /* bridge */ /* synthetic */ Socket socket() {
            return super.socket();
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void, dex: classes.dex
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
        public /* bridge */ /* synthetic */ void translateAndSetInterestOps(int r1, sun.nio.ch.SelectionKeyImpl r2) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.InheritedSocketChannelImpl.translateAndSetInterestOps(int, sun.nio.ch.SelectionKeyImpl):void");
        }

        public /* bridge */ /* synthetic */ boolean translateAndSetReadyOps(int ops, SelectionKeyImpl sk) {
            return super.translateAndSetReadyOps(ops, sk);
        }

        public /* bridge */ /* synthetic */ boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl sk) {
            return super.translateAndUpdateReadyOps(ops, sk);
        }

        public /* bridge */ /* synthetic */ boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
            return super.translateReadyOps(ops, initialOps, sk);
        }

        public /* bridge */ /* synthetic */ int write(ByteBuffer buf) {
            return super.write(buf);
        }

        public /* bridge */ /* synthetic */ long write(ByteBuffer[] srcs, int offset, int length) {
            return super.write(srcs, offset, length);
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.InheritedChannel.<clinit>():void, dex: classes.dex
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
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.nio.ch.InheritedChannel.<clinit>():void, dex: classes.dex
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.InheritedChannel.<clinit>():void");
    }

    private static native void close0(int i) throws IOException;

    private static native int dup(int i) throws IOException;

    private static native void dup2(int i, int i2) throws IOException;

    private static native int open0(String str, int i) throws IOException;

    private static native InetAddress peerAddress0(int i);

    private static native int peerPort0(int i);

    private static native int soType0(int i);

    InheritedChannel() {
    }

    /* access modifiers changed from: private */
    public static void detachIOStreams() {
        try {
            dup2(devnull, 0);
            dup2(devnull, 1);
            dup2(devnull, 2);
        } catch (IOException e) {
            throw new InternalError();
        }
    }

    private static void checkAccess(Channel c) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("inheritedChannel"));
        }
    }

    private static Channel createChannel() throws IOException {
        boolean z = true;
        int fdVal = dup(0);
        int st = soType0(fdVal);
        if (st == 1 || st == 2) {
            FileDescriptor fd = (FileDescriptor) Reflect.invoke(Reflect.lookupConstructor("java.io.FileDescriptor", new Class[]{Integer.TYPE}), new Object[]{new Integer(fdVal)});
            SelectorProvider provider = SelectorProvider.provider();
            if (!f127assertionsDisabled && !(provider instanceof SelectorProviderImpl)) {
                throw new AssertionError();
            } else if (st != 1) {
                return new InheritedDatagramChannelImpl(provider, fd);
            } else {
                InetAddress ia = peerAddress0(fdVal);
                if (ia == null) {
                    return new InheritedServerSocketChannelImpl(provider, fd);
                }
                int port = peerPort0(fdVal);
                if (!f127assertionsDisabled) {
                    if (port <= 0) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                return new InheritedSocketChannelImpl(provider, fd, new InetSocketAddress(ia, port));
            }
        } else {
            close0(fdVal);
            return null;
        }
    }

    public static synchronized Channel getChannel() throws IOException {
        Channel channel2;
        synchronized (InheritedChannel.class) {
            if (devnull < 0) {
                devnull = open0("/dev/null", 2);
            }
            if (!haveChannel) {
                channel = createChannel();
                haveChannel = true;
            }
            if (channel != null) {
                checkAccess(channel);
            }
            channel2 = channel;
        }
        return channel2;
    }
}
