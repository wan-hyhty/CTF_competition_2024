package java.security;

import java.security.spec.AlgorithmParameterSpec;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class AlgorithmParameterGeneratorSpi {
    /* access modifiers changed from: protected */
    public abstract AlgorithmParameters engineGenerateParameters();

    /* access modifiers changed from: protected */
    public abstract void engineInit(int i, SecureRandom secureRandom);

    /* access modifiers changed from: protected */
    public abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException;
}
