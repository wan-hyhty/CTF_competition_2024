package javax.crypto;

import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    */
public abstract class SecretKeyFactorySpi {
    /* access modifiers changed from: protected */
    public abstract SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException;

    /* access modifiers changed from: protected */
    public abstract KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) throws InvalidKeySpecException;

    /* access modifiers changed from: protected */
    public abstract SecretKey engineTranslateKey(SecretKey secretKey) throws InvalidKeyException;
}
