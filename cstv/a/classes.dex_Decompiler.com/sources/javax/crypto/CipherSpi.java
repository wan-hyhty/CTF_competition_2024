package javax.crypto;

import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public abstract class CipherSpi {
    /* access modifiers changed from: protected */
    public abstract int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException;

    /* access modifiers changed from: protected */
    public abstract byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException;

    /* access modifiers changed from: protected */
    public abstract int engineGetBlockSize();

    /* access modifiers changed from: protected */
    public abstract byte[] engineGetIV();

    /* access modifiers changed from: protected */
    public abstract int engineGetOutputSize(int i);

    /* access modifiers changed from: protected */
    public abstract AlgorithmParameters engineGetParameters();

    /* access modifiers changed from: protected */
    public abstract void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* access modifiers changed from: protected */
    public abstract void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException;

    /* access modifiers changed from: protected */
    public abstract void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* access modifiers changed from: protected */
    public abstract void engineSetMode(String str) throws NoSuchAlgorithmException;

    /* access modifiers changed from: protected */
    public abstract void engineSetPadding(String str) throws NoSuchPaddingException;

    /* access modifiers changed from: protected */
    public abstract int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException;

    /* access modifiers changed from: protected */
    public abstract byte[] engineUpdate(byte[] bArr, int i, int i2);

    /* access modifiers changed from: protected */
    public int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        try {
            return bufferCrypt(input, output, true);
        } catch (IllegalBlockSizeException e) {
            throw new ProviderException("Internal error in update()");
        } catch (BadPaddingException e2) {
            throw new ProviderException("Internal error in update()");
        }
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        return bufferCrypt(input, output, false);
    }

    static int getTempArraySize(int totalSize) {
        return Math.min(4096, totalSize);
    }

    private int bufferCrypt(ByteBuffer input, ByteBuffer output, boolean isUpdate) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] inArray;
        int inOfs;
        int n;
        int n2;
        int n3;
        if (input == null || output == null) {
            throw new NullPointerException("Input and output buffers must not be null");
        }
        int inPos = input.position();
        int inLimit = input.limit();
        int inLen = inLimit - inPos;
        if (isUpdate && inLen == 0) {
            return 0;
        }
        int outLenNeeded = engineGetOutputSize(inLen);
        if (output.remaining() < outLenNeeded) {
            throw new ShortBufferException("Need at least " + outLenNeeded + " bytes of space in output buffer");
        }
        boolean a1 = input.hasArray();
        boolean a2 = output.hasArray();
        if (a1 && a2) {
            byte[] inArray2 = input.array();
            int inOfs2 = input.arrayOffset() + inPos;
            byte[] outArray = output.array();
            int outPos = output.position();
            int outOfs = output.arrayOffset() + outPos;
            if (isUpdate) {
                n3 = engineUpdate(inArray2, inOfs2, inLen, outArray, outOfs);
            } else {
                n3 = engineDoFinal(inArray2, inOfs2, inLen, outArray, outOfs);
            }
            input.position(inLimit);
            output.position(outPos + n3);
            return n3;
        } else if (a1 || !a2) {
            if (a1) {
                inArray = input.array();
                inOfs = input.arrayOffset() + inPos;
            } else {
                inArray = new byte[getTempArraySize(inLen)];
                inOfs = 0;
            }
            byte[] outArray2 = new byte[getTempArraySize(outLenNeeded)];
            int outSize = outArray2.length;
            int total = 0;
            boolean resized = false;
            do {
                int chunk = Math.min(inLen, outSize);
                if (!a1 && !resized) {
                    input.get(inArray, 0, chunk);
                    inOfs = 0;
                }
                if (isUpdate || inLen != chunk) {
                    try {
                        n = engineUpdate(inArray, inOfs, chunk, outArray2, 0);
                    } catch (ShortBufferException e) {
                        if (resized) {
                            throw ((ProviderException) new ProviderException("Could not determine buffer size").initCause(e));
                        }
                        resized = true;
                        outArray2 = new byte[engineGetOutputSize(chunk)];
                        continue;
                    }
                } else {
                    n = engineDoFinal(inArray, inOfs, chunk, outArray2, 0);
                }
                resized = false;
                inOfs += chunk;
                inLen -= chunk;
                output.put(outArray2, 0, n);
                total += n;
                continue;
            } while (inLen > 0);
            input.position(inLimit);
            return total;
        } else {
            int outPos2 = output.position();
            byte[] outArray3 = output.array();
            int outOfs2 = output.arrayOffset() + outPos2;
            byte[] inArray3 = new byte[getTempArraySize(inLen)];
            int total2 = 0;
            do {
                int chunk2 = Math.min(inLen, inArray3.length);
                input.get(inArray3, 0, chunk2);
                if (isUpdate || inLen != chunk2) {
                    n2 = engineUpdate(inArray3, 0, chunk2, outArray3, outOfs2);
                } else {
                    n2 = engineDoFinal(inArray3, 0, chunk2, outArray3, outOfs2);
                }
                total2 += n2;
                outOfs2 += n2;
                inLen -= chunk2;
            } while (inLen > 0);
            output.position(outPos2 + total2);
            return total2;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm, int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public void engineUpdateAAD(byte[] src, int offset, int len) {
        throw new UnsupportedOperationException("The underlying Cipher implementation does not support this method");
    }

    /* access modifiers changed from: protected */
    public void engineUpdateAAD(ByteBuffer src) {
        throw new UnsupportedOperationException("The underlying Cipher implementation does not support this method");
    }
}
