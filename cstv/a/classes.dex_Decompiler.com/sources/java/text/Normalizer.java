package java.text;

import android.icu.text.Normalizer;

public final class Normalizer {
    private Normalizer() {
    }

    /*  JADX ERROR: NullPointerException in pass: EnumVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:118)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:47)
        */
    public enum Form {
        ;
        
        /* access modifiers changed from: private */
        public final Normalizer.Mode icuMode;

        private Form(Normalizer.Mode icuMode2) {
            this.icuMode = icuMode2;
        }
    }

    public static String normalize(CharSequence src, Form form) {
        return android.icu.text.Normalizer.normalize(src.toString(), form.icuMode);
    }

    public static boolean isNormalized(CharSequence src, Form form) {
        return android.icu.text.Normalizer.isNormalized(src.toString(), form.icuMode, 0);
    }
}
