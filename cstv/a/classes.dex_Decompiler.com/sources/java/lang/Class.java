package java.lang;

import com.android.dex.Dex;
import dalvik.system.VMStack;
import java.awt.font.NumericShaper;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import libcore.reflect.GenericSignatureParser;
import libcore.reflect.InternalNames;
import libcore.reflect.Types;
import libcore.util.BasicLruCache;
import libcore.util.CollectionUtils;
import libcore.util.EmptyArray;
import sun.reflect.CallerSensitive;
import sun.reflect.annotation.AnnotationType;

public final class Class<T> implements Serializable, GenericDeclaration, Type, AnnotatedElement {
    private static final int ANNOTATION = 8192;
    private static final int ENUM = 16384;
    private static final int FINALIZABLE = Integer.MIN_VALUE;
    private static final int SYNTHETIC = 4096;
    private static final long serialVersionUID = 3206093459760846163L;
    private transient int accessFlags;
    private AnnotationType annotationType;
    private transient int classFlags;
    private transient ClassLoader classLoader;
    private transient int classSize;
    private transient int clinitThreadId;
    private transient Class<?> componentType;
    private transient short copiedMethodsOffset;
    private transient DexCache dexCache;
    private transient long dexCacheStrings;
    private transient int dexClassDefIndex;
    private volatile transient int dexTypeIndex;
    private transient long iFields;
    private transient Object[] ifTable;
    private transient long methods;
    private transient String name;
    private transient int numReferenceInstanceFields;
    private transient int numReferenceStaticFields;
    private transient int objectSize;
    private transient int primitiveType;
    private transient int referenceInstanceOffsets;
    private transient long sFields;
    private transient int status;
    private transient Class<? super T> superClass;
    private transient Object verifyError;
    private transient short virtualMethodsOffset;
    private transient Object vtable;

    static native Class<?> classForName(String str, boolean z, ClassLoader classLoader2) throws ClassNotFoundException;

    private native Constructor<T> getDeclaredConstructorInternal(Class<?>[] clsArr);

    private native Constructor<?>[] getDeclaredConstructorsInternal(boolean z);

    private native Method getDeclaredMethodInternal(String str, Class<?>[] clsArr);

    private native Constructor<?> getEnclosingConstructorNative();

    private native Method getEnclosingMethodNative();

    private native int getInnerClassFlags(int i);

    private native String getInnerClassName();

    private native String getNameNative();

    private native Class<?>[] getProxyInterfaces();

    private native Field[] getPublicDeclaredFields();

    private native Field getPublicFieldRecursive(String str);

    private native String[] getSignatureAnnotation();

    private native boolean isDeclaredAnnotationPresent(Class<? extends Annotation> cls);

    public native <T extends Annotation> T getDeclaredAnnotation(Class<T> cls);

    public native Annotation[] getDeclaredAnnotations();

    public native Class<?>[] getDeclaredClasses();

    public native Field getDeclaredField(String str) throws NoSuchFieldException;

    public native Field[] getDeclaredFields();

    public native Field[] getDeclaredFieldsUnchecked(boolean z);

    public native Method[] getDeclaredMethodsUnchecked(boolean z);

    public native Class<?> getDeclaringClass();

    public native Class<?> getEnclosingClass();

    public native boolean isAnonymousClass();

    public native T newInstance() throws InstantiationException, IllegalAccessException;

    private Class() {
    }

    public String toString() {
        return (isInterface() ? "interface " : isPrimitive() ? "" : "class ") + getName();
    }

    @CallerSensitive
    public static Class<?> forName(String className) throws ClassNotFoundException {
        return forName(className, true, VMStack.getCallingClassLoader());
    }

    @CallerSensitive
    public static Class<?> forName(String name2, boolean initialize, ClassLoader loader) throws ClassNotFoundException {
        if (loader == null) {
            loader = BootClassLoader.getInstance();
        }
        try {
            return classForName(name2, initialize, loader);
        } catch (ClassNotFoundException e) {
            Throwable cause = e.getCause();
            if (cause instanceof LinkageError) {
                throw ((LinkageError) cause);
            }
            throw e;
        }
    }

    public boolean isInstance(Object object) {
        if (object == null) {
            return false;
        }
        return isAssignableFrom(object.getClass());
    }

    public boolean isAssignableFrom(Class<?> c) {
        if (this == c) {
            return true;
        }
        if (this == Object.class) {
            if (c.isPrimitive()) {
                return false;
            }
            return true;
        } else if (isArray()) {
            if (c.isArray()) {
                return this.componentType.isAssignableFrom(c.componentType);
            }
            return false;
        } else if (isInterface()) {
            Object[] iftable = c.ifTable;
            if (iftable != null) {
                for (int i = 0; i < iftable.length; i += 2) {
                    if (iftable[i] == this) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (!c.isInterface()) {
                for (Class<? super T> cls = c.superClass; cls != null; cls = cls.superClass) {
                    if (cls == this) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean isInterface() {
        return (this.accessFlags & 512) != 0;
    }

    public boolean isArray() {
        return getComponentType() != null;
    }

    public boolean isPrimitive() {
        return (this.primitiveType & 65535) != 0;
    }

    public boolean isFinalizable() {
        return (getModifiers() & Integer.MIN_VALUE) != 0;
    }

    public boolean isAnnotation() {
        return (getModifiers() & 8192) != 0;
    }

    public boolean isSynthetic() {
        return (getModifiers() & 4096) != 0;
    }

    public String getName() {
        String name2 = this.name;
        if (name2 != null) {
            return name2;
        }
        String name3 = getNameNative();
        this.name = name3;
        return name3;
    }

    public ClassLoader getClassLoader() {
        if (isPrimitive()) {
            return null;
        }
        return this.classLoader == null ? BootClassLoader.getInstance() : this.classLoader;
    }

    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        String annotationSignature = getSignatureAttribute();
        if (annotationSignature == null) {
            return EmptyArray.TYPE_VARIABLE;
        }
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, annotationSignature);
        return parser.formalTypeParameters;
    }

    public Class<? super T> getSuperclass() {
        if (isInterface()) {
            return null;
        }
        return this.superClass;
    }

    public Type getGenericSuperclass() {
        Type genericSuperclass = getSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        String annotationSignature = getSignatureAttribute();
        if (annotationSignature != null) {
            GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
            parser.parseForClass(this, annotationSignature);
            genericSuperclass = parser.superclassType;
        }
        return Types.getType(genericSuperclass);
    }

    public Package getPackage() {
        String packageName;
        ClassLoader loader = getClassLoader();
        if (loader == null || (packageName = getPackageName$()) == null) {
            return null;
        }
        return loader.getPackage(packageName);
    }

    public String getPackageName$() {
        String name2 = getName();
        int last = name2.lastIndexOf(46);
        if (last == -1) {
            return null;
        }
        return name2.substring(0, last);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?>[] getInterfaces() {
        /*
            r7 = this;
            boolean r4 = r7.isArray()
            if (r4 == 0) goto L_0x0014
            r4 = 2
            java.lang.Class[] r4 = new java.lang.Class[r4]
            java.lang.Class<java.lang.Cloneable> r5 = java.lang.Cloneable.class
            r6 = 0
            r4[r6] = r5
            java.lang.Class<java.io.Serializable> r5 = java.io.Serializable.class
            r6 = 1
            r4[r6] = r5
            return r4
        L_0x0014:
            boolean r4 = r7.isProxy()
            if (r4 == 0) goto L_0x001f
            java.lang.Class[] r4 = r7.getProxyInterfaces()
            return r4
        L_0x001f:
            com.android.dex.Dex r0 = r7.getDex()
            if (r0 != 0) goto L_0x0028
            java.lang.Class[] r4 = libcore.util.EmptyArray.CLASS
            return r4
        L_0x0028:
            int r4 = r7.dexClassDefIndex
            short[] r2 = r0.interfaceTypeIndicesFromClassDefIndex(r4)
            int r4 = r2.length
            java.lang.Class[] r3 = new java.lang.Class[r4]
            r1 = 0
        L_0x0032:
            int r4 = r2.length
            if (r1 >= r4) goto L_0x0040
            short r4 = r2[r1]
            java.lang.Class r4 = r7.getDexCacheType(r0, r4)
            r3[r1] = r4
            int r1 = r1 + 1
            goto L_0x0032
        L_0x0040:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Class.getInterfaces():java.lang.Class[]");
    }

    public Type[] getGenericInterfaces() {
        Type[] result;
        synchronized (Caches.genericInterfaces) {
            result = (Type[]) Caches.genericInterfaces.get(this);
            if (result == null) {
                String annotationSignature = getSignatureAttribute();
                if (annotationSignature == null) {
                    result = getInterfaces();
                } else {
                    GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
                    parser.parseForClass(this, annotationSignature);
                    result = Types.getTypeArray(parser.interfaceTypes, false);
                }
                Caches.genericInterfaces.put(this, result);
            }
        }
        return result.length == 0 ? result : (Type[]) result.clone();
    }

    public Class<?> getComponentType() {
        return this.componentType;
    }

    public int getModifiers() {
        if (!isArray()) {
            return getInnerClassFlags(this.accessFlags & 65535) & 65535;
        }
        int componentModifiers = getComponentType().getModifiers();
        if ((componentModifiers & 512) != 0) {
            componentModifiers &= -521;
        }
        return componentModifiers | 1040;
    }

    public Object[] getSigners() {
        return null;
    }

    public Method getEnclosingMethod() {
        if (classNameImpliesTopLevel()) {
            return null;
        }
        return getEnclosingMethodNative();
    }

    public Constructor<?> getEnclosingConstructor() {
        if (classNameImpliesTopLevel()) {
            return null;
        }
        return getEnclosingConstructorNative();
    }

    private boolean classNameImpliesTopLevel() {
        return !getName().contains("$");
    }

    public String getSimpleName() {
        if (isArray()) {
            return getComponentType().getSimpleName() + "[]";
        }
        if (isAnonymousClass()) {
            return "";
        }
        if (isMemberClass() || isLocalClass()) {
            return getInnerClassName();
        }
        String simpleName = getName();
        if (simpleName.lastIndexOf(".") > 0) {
            return simpleName.substring(simpleName.lastIndexOf(".") + 1);
        }
        return simpleName;
    }

    public String getCanonicalName() {
        if (isArray()) {
            String canonicalName = getComponentType().getCanonicalName();
            if (canonicalName != null) {
                return canonicalName + "[]";
            }
            return null;
        } else if (isLocalOrAnonymousClass()) {
            return null;
        } else {
            Class<?> enclosingClass = getEnclosingClass();
            if (enclosingClass == null) {
                return getName();
            }
            String enclosingName = enclosingClass.getCanonicalName();
            if (enclosingName == null) {
                return null;
            }
            return enclosingName + "." + getSimpleName();
        }
    }

    public boolean isLocalClass() {
        if ((getEnclosingMethod() != null || getEnclosingConstructor() != null) && !isAnonymousClass()) {
            return true;
        }
        return false;
    }

    public boolean isMemberClass() {
        return getDeclaringClass() != null;
    }

    private boolean isLocalOrAnonymousClass() {
        if (!isLocalClass()) {
            return isAnonymousClass();
        }
        return true;
    }

    @CallerSensitive
    public Class<?>[] getClasses() {
        List<Class<?>> result = new ArrayList<>();
        for (Class cls = this; cls != null; cls = cls.superClass) {
            for (Class<?> member : cls.getDeclaredClasses()) {
                if (Modifier.isPublic(member.getModifiers())) {
                    result.add(member);
                }
            }
        }
        return (Class[]) result.toArray(new Class[result.size()]);
    }

    @CallerSensitive
    public Field[] getFields() throws SecurityException {
        List<Field> fields = new ArrayList<>();
        getPublicFieldsRecursive(fields);
        return (Field[]) fields.toArray(new Field[fields.size()]);
    }

    private void getPublicFieldsRecursive(List<Field> result) {
        for (Class cls = this; cls != null; cls = cls.superClass) {
            Collections.addAll(result, cls.getPublicDeclaredFields());
        }
        Object[] iftable = this.ifTable;
        if (iftable != null) {
            for (int i = 0; i < iftable.length; i += 2) {
                Collections.addAll(result, ((Class) iftable[i]).getPublicDeclaredFields());
            }
        }
    }

    @CallerSensitive
    public Method[] getMethods() throws SecurityException {
        List<Method> methods2 = new ArrayList<>();
        getPublicMethodsInternal(methods2);
        CollectionUtils.removeDuplicates(methods2, Method.ORDER_BY_SIGNATURE);
        return (Method[]) methods2.toArray(new Method[methods2.size()]);
    }

    private void getPublicMethodsInternal(List<Method> result) {
        Collections.addAll(result, getDeclaredMethodsUnchecked(true));
        if (!isInterface()) {
            for (Class<? super T> cls = this.superClass; cls != null; cls = cls.superClass) {
                Collections.addAll(result, cls.getDeclaredMethodsUnchecked(true));
            }
        }
        Object[] iftable = this.ifTable;
        if (iftable != null) {
            for (int i = 0; i < iftable.length; i += 2) {
                Collections.addAll(result, ((Class) iftable[i]).getDeclaredMethodsUnchecked(true));
            }
        }
    }

    @CallerSensitive
    public Constructor<?>[] getConstructors() throws SecurityException {
        return getDeclaredConstructorsInternal(true);
    }

    public Field getField(String name2) throws NoSuchFieldException {
        if (name2 == null) {
            throw new NullPointerException("name == null");
        }
        Field result = getPublicFieldRecursive(name2);
        if (result != null) {
            return result;
        }
        throw new NoSuchFieldException(name2);
    }

    @CallerSensitive
    public Method getMethod(String name2, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getMethod(name2, parameterTypes, true);
    }

    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getConstructor0(parameterTypes, 0);
    }

    public Method[] getDeclaredMethods() throws SecurityException {
        Method[] result = getDeclaredMethodsUnchecked(false);
        for (Method m : result) {
            m.getReturnType();
            m.getParameterTypes();
        }
        return result;
    }

    public Constructor<?>[] getDeclaredConstructors() throws SecurityException {
        return getDeclaredConstructorsInternal(false);
    }

    @CallerSensitive
    public Method getDeclaredMethod(String name2, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getMethod(name2, parameterTypes, false);
    }

    private Method getMethod(String name2, Class<?>[] parameterTypes, boolean recursivePublicMethods) throws NoSuchMethodException {
        Method result;
        if (name2 == null) {
            throw new NullPointerException("name == null");
        }
        if (parameterTypes == null) {
            parameterTypes = EmptyArray.CLASS;
        }
        for (Class<?> c : parameterTypes) {
            if (c == null) {
                throw new NoSuchMethodException("parameter type is null");
            }
        }
        if (recursivePublicMethods) {
            result = getPublicMethodRecursive(name2, parameterTypes);
        } else {
            result = getDeclaredMethodInternal(name2, parameterTypes);
        }
        if (result != null && (!recursivePublicMethods || Modifier.isPublic(result.getAccessFlags()))) {
            return result;
        }
        throw new NoSuchMethodException(name2 + " " + Arrays.toString((Object[]) parameterTypes));
    }

    private Method getPublicMethodRecursive(String name2, Class<?>[] parameterTypes) {
        for (Class cls = this; cls != null; cls = cls.getSuperclass()) {
            Method result = cls.getDeclaredMethodInternal(name2, parameterTypes);
            if (result != null && Modifier.isPublic(result.getAccessFlags())) {
                return result;
            }
        }
        Object[] iftable = this.ifTable;
        if (iftable != null) {
            for (int i = iftable.length - 2; i >= 0; i -= 2) {
                Method result2 = ((Class) iftable[i]).getPublicMethodRecursive(name2, parameterTypes);
                if (result2 != null && Modifier.isPublic(result2.getAccessFlags())) {
                    return result2;
                }
            }
        }
        return null;
    }

    @CallerSensitive
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        return getConstructor0(parameterTypes, 1);
    }

    public InputStream getResourceAsStream(String name2) {
        String name3 = resolveName(name2);
        ClassLoader cl = getClassLoader();
        if (cl == null) {
            return ClassLoader.getSystemResourceAsStream(name3);
        }
        return cl.getResourceAsStream(name3);
    }

    public URL getResource(String name2) {
        String name3 = resolveName(name2);
        ClassLoader cl = getClassLoader();
        if (cl == null) {
            return ClassLoader.getSystemResource(name3);
        }
        return cl.getResource(name3);
    }

    public ProtectionDomain getProtectionDomain() {
        return null;
    }

    private String resolveName(String name2) {
        if (name2 == null) {
            return name2;
        }
        if (name2.startsWith("/")) {
            return name2.substring(1);
        }
        Class cls = this;
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        String baseName = cls.getName();
        int index = baseName.lastIndexOf(46);
        if (index != -1) {
            return baseName.substring(0, index).replace('.', '/') + "/" + name2;
        }
        return name2;
    }

    private Constructor<T> getConstructor0(Class<?>[] parameterTypes, int which) throws NoSuchMethodException {
        if (parameterTypes == null) {
            parameterTypes = EmptyArray.CLASS;
        }
        for (Class<?> c : parameterTypes) {
            if (c == null) {
                throw new NoSuchMethodException("parameter type is null");
            }
        }
        Constructor<T> result = getDeclaredConstructorInternal(parameterTypes);
        if (result != null && (which != 0 || Modifier.isPublic(result.getAccessFlags()))) {
            return result;
        }
        throw new NoSuchMethodException("<init> " + Arrays.toString((Object[]) parameterTypes));
    }

    public boolean desiredAssertionStatus() {
        return false;
    }

    public boolean isEnum() {
        if ((getModifiers() & 16384) == 0 || getSuperclass() != Enum.class) {
            return false;
        }
        return true;
    }

    public T[] getEnumConstants() {
        T[] values = getEnumConstantsShared();
        if (values != null) {
            return (Object[]) values.clone();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public T[] getEnumConstantsShared() {
        if (!isEnum()) {
            return null;
        }
        return Enum.getSharedConstants(this);
    }

    public T cast(Object obj) {
        if (obj == null || isInstance(obj)) {
            return obj;
        }
        throw new ClassCastException(cannotCastMsg(obj));
    }

    private String cannotCastMsg(Object obj) {
        return "Cannot cast " + obj.getClass().getName() + " to " + getName();
    }

    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        if (clazz.isAssignableFrom(this)) {
            return this;
        }
        throw new ClassCastException(toString() + " cannot be cast to " + clazz.getName());
    }

    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        if (annotationClass == null) {
            throw new NullPointerException();
        }
        A annotation = getDeclaredAnnotation(annotationClass);
        if (annotation != null) {
            return annotation;
        }
        if (annotationClass.isDeclaredAnnotationPresent(Inherited.class)) {
            for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
                A annotation2 = sup.getDeclaredAnnotation(annotationClass);
                if (annotation2 != null) {
                    return annotation2;
                }
            }
        }
        return null;
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType2) {
        if (annotationType2 == null) {
            throw new NullPointerException("annotationType == null");
        } else if (isDeclaredAnnotationPresent(annotationType2)) {
            return true;
        } else {
            if (!annotationType2.isDeclaredAnnotationPresent(Inherited.class)) {
                return false;
            }
            for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
                if (sup.isDeclaredAnnotationPresent(annotationType2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Annotation[] getAnnotations() {
        HashMap<Class<?>, Annotation> map = new HashMap<>();
        for (Annotation declaredAnnotation : getDeclaredAnnotations()) {
            map.put(declaredAnnotation.annotationType(), declaredAnnotation);
        }
        for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
            for (Annotation declaredAnnotation2 : sup.getDeclaredAnnotations()) {
                Class<? extends Annotation> clazz = declaredAnnotation2.annotationType();
                if (!map.containsKey(clazz) && clazz.isDeclaredAnnotationPresent(Inherited.class)) {
                    map.put(clazz, declaredAnnotation2);
                }
            }
        }
        Collection<Annotation> coll = map.values();
        return (Annotation[]) coll.toArray(new Annotation[coll.size()]);
    }

    public <T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass) {
        Class<?> superClass2;
        T[] annotations = super.getAnnotationsByType(annotationClass);
        if (annotations.length != 0) {
            return annotations;
        }
        if (!annotationClass.isDeclaredAnnotationPresent(Inherited.class) || (superClass2 = getSuperclass()) == null) {
            return (Annotation[]) Array.newInstance((Class<?>) annotationClass, 0);
        }
        return superClass2.getAnnotationsByType(annotationClass);
    }

    public void setAnnotationType(AnnotationType type) {
        this.annotationType = type;
    }

    public AnnotationType getAnnotationType() {
        return this.annotationType;
    }

    private String getSignatureAttribute() {
        String[] annotation = getSignatureAnnotation();
        if (annotation == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (String s : annotation) {
            result.append(s);
        }
        return result.toString();
    }

    public boolean isProxy() {
        return (this.accessFlags & NumericShaper.MONGOLIAN) != 0;
    }

    public Dex getDex() {
        if (this.dexCache == null) {
            return null;
        }
        return this.dexCache.getDex();
    }

    public String getDexCacheString(Dex dex, int dexStringIndex) {
        String s = this.dexCache.getResolvedString(dexStringIndex);
        if (s != null) {
            return s;
        }
        String s2 = ((String) dex.strings().get(dexStringIndex)).intern();
        this.dexCache.setResolvedString(dexStringIndex, s2);
        return s2;
    }

    public Class<?> getDexCacheType(Dex dex, int dexTypeIndex2) {
        Class<?> resolvedType = this.dexCache.getResolvedType(dexTypeIndex2);
        if (resolvedType != null) {
            return resolvedType;
        }
        Class<?> resolvedType2 = InternalNames.getClass(getClassLoader(), getDexCacheString(dex, ((Integer) dex.typeIds().get(dexTypeIndex2)).intValue()));
        this.dexCache.setResolvedType(dexTypeIndex2, resolvedType2);
        return resolvedType2;
    }

    public int getDexAnnotationDirectoryOffset() {
        int classDefIndex;
        Dex dex = getDex();
        if (dex != null && (classDefIndex = getDexClassDefIndex()) >= 0) {
            return dex.annotationDirectoryOffsetFromClassDefIndex(classDefIndex);
        }
        return 0;
    }

    public int getDexTypeIndex() {
        int typeIndex;
        int typeIndex2 = this.dexTypeIndex;
        if (typeIndex2 != 65535) {
            return typeIndex2;
        }
        synchronized (this) {
            typeIndex = this.dexTypeIndex;
            if (typeIndex == 65535) {
                if (this.dexClassDefIndex >= 0) {
                    typeIndex = getDex().typeIndexFromClassDefIndex(this.dexClassDefIndex);
                } else {
                    typeIndex = getDex().findTypeIndex(InternalNames.getInternalName(this));
                    if (typeIndex < 0) {
                        typeIndex = -1;
                    }
                }
                this.dexTypeIndex = typeIndex;
            }
        }
        return typeIndex;
    }

    private boolean canAccess(Class<?> c) {
        if (Modifier.isPublic(c.accessFlags)) {
            return true;
        }
        return inSamePackage(c);
    }

    private boolean canAccessMember(Class<?> memberClass, int memberModifiers) {
        if (memberClass == this || Modifier.isPublic(memberModifiers)) {
            return true;
        }
        if (Modifier.isPrivate(memberModifiers)) {
            return false;
        }
        if (Modifier.isProtected(memberModifiers)) {
            for (Class<? super T> cls = this.superClass; cls != null; cls = cls.superClass) {
                if (cls == memberClass) {
                    return true;
                }
            }
        }
        return inSamePackage(memberClass);
    }

    private boolean inSamePackage(Class<?> c) {
        if (this.classLoader != c.classLoader) {
            return false;
        }
        String packageName1 = getPackageName$();
        String packageName2 = c.getPackageName$();
        if (packageName1 == null) {
            if (packageName2 == null) {
                return true;
            }
            return false;
        } else if (packageName2 == null) {
            return false;
        } else {
            return packageName1.equals(packageName2);
        }
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    public int getDexClassDefIndex() {
        if (this.dexClassDefIndex == 65535) {
            return -1;
        }
        return this.dexClassDefIndex;
    }

    private static class Caches {
        /* access modifiers changed from: private */
        public static final BasicLruCache<Class, Type[]> genericInterfaces = null;

        private Caches() {
        }
    }
}
