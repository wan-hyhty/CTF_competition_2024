package sun.reflect.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Map;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:574)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:220)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:151)
    	at java.util.ArrayList.forEach(ArrayList.java:1259)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:58)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:51)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class AnnotationType {
    private boolean inherited;
    private final Map<String, Object> memberDefaults;
    private final Map<String, Class<?>> memberTypes;
    private final Map<String, Method> members;
    private RetentionPolicy retention;

    public static synchronized AnnotationType getInstance(Class<? extends Annotation> annotationClass) {
        AnnotationType result;
        synchronized (AnnotationType.class) {
            result = annotationClass.getAnnotationType();
            if (result == null) {
                result = new AnnotationType(annotationClass);
            }
        }
        return result;
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    private AnnotationType(java.lang.Class<? extends java.lang.annotation.Annotation> r11) {
        /*
            r10 = this;
            r6 = 0
            r10.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r10.memberTypes = r7
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r10.memberDefaults = r7
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r10.members = r7
            java.lang.annotation.RetentionPolicy r7 = java.lang.annotation.RetentionPolicy.RUNTIME
            r10.retention = r7
            r10.inherited = r6
            boolean r7 = r11.isAnnotation()
            if (r7 != 0) goto L_0x002e
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Not an annotation type"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x002e:
            sun.reflect.annotation.AnnotationType$1 r7 = new sun.reflect.annotation.AnnotationType$1
            r7.<init>(r10, r11)
            java.lang.Object r2 = java.security.AccessController.doPrivileged(r7)
            java.lang.reflect.Method[] r2 = (java.lang.reflect.Method[]) r2
            int r7 = r2.length
        L_0x003a:
            if (r6 >= r7) goto L_0x0088
            r1 = r2[r6]
            java.lang.Class[] r8 = r1.getParameterTypes()
            int r8 = r8.length
            if (r8 == 0) goto L_0x005f
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r7 = r7.append((java.lang.Object) r1)
            java.lang.String r8 = " has params"
            java.lang.StringBuilder r7 = r7.append((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x005f:
            java.lang.String r3 = r1.getName()
            java.lang.Class r5 = r1.getReturnType()
            java.util.Map<java.lang.String, java.lang.Class<?>> r8 = r10.memberTypes
            java.lang.Class r9 = invocationHandlerReturnType(r5)
            r8.put(r3, r9)
            java.util.Map<java.lang.String, java.lang.reflect.Method> r8 = r10.members
            r8.put(r3, r1)
            java.lang.Object r0 = r1.getDefaultValue()
            if (r0 == 0) goto L_0x0080
            java.util.Map<java.lang.String, java.lang.Object> r8 = r10.memberDefaults
            r8.put(r3, r0)
        L_0x0080:
            java.util.Map<java.lang.String, java.lang.reflect.Method> r8 = r10.members
            r8.put(r3, r1)
            int r6 = r6 + 1
            goto L_0x003a
        L_0x0088:
            r11.setAnnotationType(r10)
            java.lang.Class<java.lang.annotation.Retention> r6 = java.lang.annotation.Retention.class
            if (r11 == r6) goto L_0x00a9
            java.lang.Class<java.lang.annotation.Inherited> r6 = java.lang.annotation.Inherited.class
            if (r11 == r6) goto L_0x00a9
            java.lang.Class<java.lang.annotation.Retention> r6 = java.lang.annotation.Retention.class
            java.lang.annotation.Annotation r4 = r11.getAnnotation(r6)
            java.lang.annotation.Retention r4 = (java.lang.annotation.Retention) r4
            if (r4 != 0) goto L_0x00aa
            java.lang.annotation.RetentionPolicy r6 = java.lang.annotation.RetentionPolicy.CLASS
        L_0x009f:
            r10.retention = r6
            java.lang.Class<java.lang.annotation.Inherited> r6 = java.lang.annotation.Inherited.class
            boolean r6 = r11.isAnnotationPresent(r6)
            r10.inherited = r6
        L_0x00a9:
            return
        L_0x00aa:
            java.lang.annotation.RetentionPolicy r6 = r4.value()
            goto L_0x009f
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.reflect.annotation.AnnotationType.<init>(java.lang.Class):void");
    }

    public static Class<?> invocationHandlerReturnType(Class<?> type) {
        if (type == Byte.TYPE) {
            return Byte.class;
        }
        if (type == Character.TYPE) {
            return Character.class;
        }
        if (type == Double.TYPE) {
            return Double.class;
        }
        if (type == Float.TYPE) {
            return Float.class;
        }
        if (type == Integer.TYPE) {
            return Integer.class;
        }
        if (type == Long.TYPE) {
            return Long.class;
        }
        if (type == Short.TYPE) {
            return Short.class;
        }
        if (type == Boolean.TYPE) {
            return Boolean.class;
        }
        return type;
    }

    public Map<String, Class<?>> memberTypes() {
        return this.memberTypes;
    }

    public Map<String, Method> members() {
        return this.members;
    }

    public Map<String, Object> memberDefaults() {
        return this.memberDefaults;
    }

    public RetentionPolicy retention() {
        return this.retention;
    }

    public boolean isInherited() {
        return this.inherited;
    }

    public String toString() {
        StringBuffer s = new StringBuffer("Annotation Type:\n");
        s.append("   Member types: " + this.memberTypes + "\n");
        s.append("   Member defaults: " + this.memberDefaults + "\n");
        s.append("   Retention policy: " + this.retention + "\n");
        s.append("   Inherited: " + this.inherited);
        return s.toString();
    }
}
