package java.lang.reflect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import libcore.util.EmptyArray;
import sun.reflect.CallerSensitive;

public class Proxy implements Serializable {
    private static final Comparator<Method> ORDER_BY_SIGNATURE_AND_SUBTYPE = null;
    private static final Class[] constructorParams = null;
    private static Map<ClassLoader, Map<List<String>, Object>> loaderToCache = null;
    private static long nextUniqueNumber = 0;
    private static Object nextUniqueNumberLock = null;
    private static Object pendingGenerationMarker = null;
    private static final String proxyClassNamePrefix = "$Proxy";
    private static Map<Class<?>, Void> proxyClasses = null;
    private static final long serialVersionUID = -2222568056686623797L;
    protected InvocationHandler h;

    private static native Class<?> generateProxy(String str, Class<?>[] clsArr, ClassLoader classLoader, Method[] methodArr, Class<?>[][] clsArr2);

    private Proxy() {
    }

    protected Proxy(InvocationHandler h2) {
        this.h = h2;
    }

    @CallerSensitive
    public static Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces) throws IllegalArgumentException {
        return getProxyClass0(loader, interfaces);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: java.lang.Class<?>} */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        r4.remove(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r4.remove(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r4.put(r15, pendingGenerationMarker);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0115, code lost:
        r25 = null;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011f, code lost:
        if (r10 >= r33.length) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012b, code lost:
        if (java.lang.reflect.Modifier.isPublic(r33[r10].getModifiers()) != false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012d, code lost:
        r19 = r33[r10].getName();
        r18 = r19.lastIndexOf(46);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0143, code lost:
        if (r18 != -1) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        r22 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0148, code lost:
        if (r25 != null) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014a, code lost:
        r25 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x014c, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r22 = r19.substring(0, r18 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0169, code lost:
        if (r22.equals(r25) != false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0173, code lost:
        throw new java.lang.IllegalArgumentException("non-public interfaces from different packages");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0174, code lost:
        r27 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0175, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0176, code lost:
        if (r23 != null) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r4.put(r15, new java.lang.ref.WeakReference(r23));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0186, code lost:
        r4.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018a, code lost:
        throw r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018b, code lost:
        if (r25 != null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x018d, code lost:
        r25 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r16 = getMethods(r33);
        java.util.Collections.sort(r16, ORDER_BY_SIGNATURE_AND_SUBTYPE);
        validateReturnTypes(r16);
        r7 = deduplicateAndGetExceptions(r16);
        r17 = (java.lang.reflect.Method[]) r16.toArray(new java.lang.reflect.Method[r16.size()]);
        r8 = (java.lang.Class[][]) r7.toArray(new java.lang.Class[r7.size()][]);
        r28 = nextUniqueNumberLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01cc, code lost:
        monitor-enter(r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r20 = nextUniqueNumber;
        nextUniqueNumber = 1 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        monitor-exit(r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d6, code lost:
        r23 = generateProxy(r25 + proxyClassNamePrefix + r20, r33, r32, r17, r8);
        proxyClasses.put(r23, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x020f, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0210, code lost:
        if (r23 == null) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r4.put(r15, new java.lang.ref.WeakReference(r23));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0220, code lost:
        r4.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0223, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0224, code lost:
        return r23;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Class<?> getProxyClass0(java.lang.ClassLoader r32, java.lang.Class<?>... r33) {
        /*
            r0 = r33
            int r0 = r0.length
            r27 = r0
            r28 = 65535(0xffff, float:9.1834E-41)
            r0 = r27
            r1 = r28
            if (r0 <= r1) goto L_0x0017
            java.lang.IllegalArgumentException r27 = new java.lang.IllegalArgumentException
            java.lang.String r28 = "interface limit exceeded"
            r27.<init>((java.lang.String) r28)
            throw r27
        L_0x0017:
            r23 = 0
            r0 = r33
            int r0 = r0.length
            r27 = r0
            r0 = r27
            java.lang.String[] r13 = new java.lang.String[r0]
            java.util.HashSet r14 = new java.util.HashSet
            r14.<init>()
            r10 = 0
        L_0x0028:
            r0 = r33
            int r0 = r0.length
            r27 = r0
            r0 = r27
            if (r10 >= r0) goto L_0x00b7
            r27 = r33[r10]
            java.lang.String r12 = r27.getName()
            r11 = 0
            r27 = 0
            r0 = r27
            r1 = r32
            java.lang.Class r11 = java.lang.Class.forName(r12, r0, r1)     // Catch:{ ClassNotFoundException -> 0x0064 }
        L_0x0042:
            r27 = r33[r10]
            r0 = r27
            if (r11 == r0) goto L_0x0066
            java.lang.IllegalArgumentException r27 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r28.<init>()
            r29 = r33[r10]
            java.lang.StringBuilder r28 = r28.append((java.lang.Object) r29)
            java.lang.String r29 = " is not visible from class loader"
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r28 = r28.toString()
            r27.<init>((java.lang.String) r28)
            throw r27
        L_0x0064:
            r5 = move-exception
            goto L_0x0042
        L_0x0066:
            boolean r27 = r11.isInterface()
            if (r27 != 0) goto L_0x008a
            java.lang.IllegalArgumentException r27 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r28.<init>()
            java.lang.String r29 = r11.getName()
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r29 = " is not an interface"
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r28 = r28.toString()
            r27.<init>((java.lang.String) r28)
            throw r27
        L_0x008a:
            boolean r27 = r14.contains(r11)
            if (r27 == 0) goto L_0x00ae
            java.lang.IllegalArgumentException r27 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r28 = new java.lang.StringBuilder
            r28.<init>()
            java.lang.String r29 = "repeated interface: "
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r29 = r11.getName()
            java.lang.StringBuilder r28 = r28.append((java.lang.String) r29)
            java.lang.String r28 = r28.toString()
            r27.<init>((java.lang.String) r28)
            throw r27
        L_0x00ae:
            r14.add(r11)
            r13[r10] = r12
            int r10 = r10 + 1
            goto L_0x0028
        L_0x00b7:
            java.util.List r15 = java.util.Arrays.asList(r13)
            java.util.Map<java.lang.ClassLoader, java.util.Map<java.util.List<java.lang.String>, java.lang.Object>> r28 = loaderToCache
            monitor-enter(r28)
            java.util.Map<java.lang.ClassLoader, java.util.Map<java.util.List<java.lang.String>, java.lang.Object>> r27 = loaderToCache     // Catch:{ all -> 0x00fc }
            r0 = r27
            r1 = r32
            java.lang.Object r4 = r0.get(r1)     // Catch:{ all -> 0x00fc }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x00fc }
            if (r4 != 0) goto L_0x00da
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00fc }
            r4.<init>()     // Catch:{ all -> 0x00fc }
            java.util.Map<java.lang.ClassLoader, java.util.Map<java.util.List<java.lang.String>, java.lang.Object>> r27 = loaderToCache     // Catch:{ all -> 0x00fc }
            r0 = r27
            r1 = r32
            r0.put(r1, r4)     // Catch:{ all -> 0x00fc }
        L_0x00da:
            monitor-exit(r28)
            monitor-enter(r4)
        L_0x00dc:
            java.lang.Object r26 = r4.get(r15)     // Catch:{ all -> 0x014f }
            r0 = r26
            boolean r0 = r0 instanceof java.lang.ref.Reference     // Catch:{ all -> 0x014f }
            r27 = r0
            if (r27 == 0) goto L_0x00f8
            r0 = r26
            java.lang.ref.Reference r0 = (java.lang.ref.Reference) r0     // Catch:{ all -> 0x014f }
            r27 = r0
            java.lang.Object r27 = r27.get()     // Catch:{ all -> 0x014f }
            r0 = r27
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x014f }
            r23 = r0
        L_0x00f8:
            if (r23 == 0) goto L_0x00ff
            monitor-exit(r4)
            return r23
        L_0x00fc:
            r27 = move-exception
            monitor-exit(r28)
            throw r27
        L_0x00ff:
            java.lang.Object r27 = pendingGenerationMarker     // Catch:{ all -> 0x014f }
            r0 = r26
            r1 = r27
            if (r0 != r1) goto L_0x010d
            r4.wait()     // Catch:{ InterruptedException -> 0x010b }
            goto L_0x00dc
        L_0x010b:
            r6 = move-exception
            goto L_0x00dc
        L_0x010d:
            java.lang.Object r27 = pendingGenerationMarker     // Catch:{ all -> 0x014f }
            r0 = r27
            r4.put(r15, r0)     // Catch:{ all -> 0x014f }
            monitor-exit(r4)
            r25 = 0
            r10 = 0
        L_0x0118:
            r0 = r33
            int r0 = r0.length     // Catch:{ all -> 0x0174 }
            r27 = r0
            r0 = r27
            if (r10 >= r0) goto L_0x018b
            r27 = r33[r10]     // Catch:{ all -> 0x0174 }
            int r9 = r27.getModifiers()     // Catch:{ all -> 0x0174 }
            boolean r27 = java.lang.reflect.Modifier.isPublic(r9)     // Catch:{ all -> 0x0174 }
            if (r27 != 0) goto L_0x014c
            r27 = r33[r10]     // Catch:{ all -> 0x0174 }
            java.lang.String r19 = r27.getName()     // Catch:{ all -> 0x0174 }
            r27 = 46
            r0 = r19
            r1 = r27
            int r18 = r0.lastIndexOf((int) r1)     // Catch:{ all -> 0x0174 }
            r27 = -1
            r0 = r18
            r1 = r27
            if (r0 != r1) goto L_0x0152
            java.lang.String r22 = ""
        L_0x0148:
            if (r25 != 0) goto L_0x0161
            r25 = r22
        L_0x014c:
            int r10 = r10 + 1
            goto L_0x0118
        L_0x014f:
            r27 = move-exception
            monitor-exit(r4)
            throw r27
        L_0x0152:
            int r27 = r18 + 1
            r28 = 0
            r0 = r19
            r1 = r28
            r2 = r27
            java.lang.String r22 = r0.substring(r1, r2)     // Catch:{ all -> 0x0174 }
            goto L_0x0148
        L_0x0161:
            r0 = r22
            r1 = r25
            boolean r27 = r0.equals(r1)     // Catch:{ all -> 0x0174 }
            if (r27 != 0) goto L_0x014c
            java.lang.IllegalArgumentException r27 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0174 }
            java.lang.String r28 = "non-public interfaces from different packages"
            r27.<init>((java.lang.String) r28)     // Catch:{ all -> 0x0174 }
            throw r27     // Catch:{ all -> 0x0174 }
        L_0x0174:
            r27 = move-exception
            monitor-enter(r4)
            if (r23 == 0) goto L_0x022f
            java.lang.ref.WeakReference r28 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0234 }
            r0 = r28
            r1 = r23
            r0.<init>(r1)     // Catch:{ all -> 0x0234 }
            r0 = r28
            r4.put(r15, r0)     // Catch:{ all -> 0x0234 }
        L_0x0186:
            r4.notifyAll()     // Catch:{ all -> 0x0234 }
            monitor-exit(r4)
            throw r27
        L_0x018b:
            if (r25 != 0) goto L_0x0190
            java.lang.String r25 = ""
        L_0x0190:
            java.util.List r16 = getMethods(r33)     // Catch:{ all -> 0x0174 }
            java.util.Comparator<java.lang.reflect.Method> r27 = ORDER_BY_SIGNATURE_AND_SUBTYPE     // Catch:{ all -> 0x0174 }
            r0 = r16
            r1 = r27
            java.util.Collections.sort(r0, r1)     // Catch:{ all -> 0x0174 }
            validateReturnTypes(r16)     // Catch:{ all -> 0x0174 }
            java.util.List r7 = deduplicateAndGetExceptions(r16)     // Catch:{ all -> 0x0174 }
            int r27 = r16.size()     // Catch:{ all -> 0x0174 }
            r0 = r27
            java.lang.reflect.Method[] r0 = new java.lang.reflect.Method[r0]     // Catch:{ all -> 0x0174 }
            r27 = r0
            r0 = r16
            r1 = r27
            java.lang.Object[] r17 = r0.toArray(r1)     // Catch:{ all -> 0x0174 }
            java.lang.reflect.Method[] r17 = (java.lang.reflect.Method[]) r17     // Catch:{ all -> 0x0174 }
            int r27 = r7.size()     // Catch:{ all -> 0x0174 }
            r0 = r27
            java.lang.Class[][] r0 = new java.lang.Class[r0][]     // Catch:{ all -> 0x0174 }
            r27 = r0
            r0 = r27
            java.lang.Object[] r8 = r7.toArray(r0)     // Catch:{ all -> 0x0174 }
            java.lang.Class[][] r8 = (java.lang.Class[][]) r8     // Catch:{ all -> 0x0174 }
            java.lang.Object r28 = nextUniqueNumberLock     // Catch:{ all -> 0x0174 }
            monitor-enter(r28)     // Catch:{ all -> 0x0174 }
            long r20 = nextUniqueNumber     // Catch:{ all -> 0x0225 }
            r30 = 1
            long r30 = r30 + r20
            nextUniqueNumber = r30     // Catch:{ all -> 0x0225 }
            monitor-exit(r28)     // Catch:{ all -> 0x0174 }
            java.lang.StringBuilder r27 = new java.lang.StringBuilder     // Catch:{ all -> 0x0174 }
            r27.<init>()     // Catch:{ all -> 0x0174 }
            r0 = r27
            r1 = r25
            java.lang.StringBuilder r27 = r0.append((java.lang.String) r1)     // Catch:{ all -> 0x0174 }
            java.lang.String r28 = "$Proxy"
            java.lang.StringBuilder r27 = r27.append((java.lang.String) r28)     // Catch:{ all -> 0x0174 }
            r0 = r27
            r1 = r20
            java.lang.StringBuilder r27 = r0.append((long) r1)     // Catch:{ all -> 0x0174 }
            java.lang.String r24 = r27.toString()     // Catch:{ all -> 0x0174 }
            r0 = r24
            r1 = r33
            r2 = r32
            r3 = r17
            java.lang.Class r23 = generateProxy(r0, r1, r2, r3, r8)     // Catch:{ all -> 0x0174 }
            java.util.Map<java.lang.Class<?>, java.lang.Void> r27 = proxyClasses     // Catch:{ all -> 0x0174 }
            r28 = 0
            r0 = r27
            r1 = r23
            r2 = r28
            r0.put(r1, r2)     // Catch:{ all -> 0x0174 }
            monitor-enter(r4)
            if (r23 == 0) goto L_0x0228
            java.lang.ref.WeakReference r27 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x022c }
            r0 = r27
            r1 = r23
            r0.<init>(r1)     // Catch:{ all -> 0x022c }
            r0 = r27
            r4.put(r15, r0)     // Catch:{ all -> 0x022c }
        L_0x0220:
            r4.notifyAll()     // Catch:{ all -> 0x022c }
            monitor-exit(r4)
            return r23
        L_0x0225:
            r27 = move-exception
            monitor-exit(r28)     // Catch:{ all -> 0x0174 }
            throw r27     // Catch:{ all -> 0x0174 }
        L_0x0228:
            r4.remove(r15)     // Catch:{ all -> 0x022c }
            goto L_0x0220
        L_0x022c:
            r27 = move-exception
            monitor-exit(r4)
            throw r27
        L_0x022f:
            r4.remove(r15)     // Catch:{ all -> 0x0234 }
            goto L_0x0186
        L_0x0234:
            r27 = move-exception
            monitor-exit(r4)
            throw r27
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.reflect.Proxy.getProxyClass0(java.lang.ClassLoader, java.lang.Class[]):java.lang.Class");
    }

    private static List<Class<?>[]> deduplicateAndGetExceptions(List<Method> methods) {
        List<Class<?>[]> exceptions = new ArrayList<>(methods.size());
        int i = 0;
        while (i < methods.size()) {
            Method method = methods.get(i);
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (i <= 0 || Method.ORDER_BY_SIGNATURE.compare(method, methods.get(i - 1)) != 0) {
                exceptions.add(exceptionTypes);
                i++;
            } else {
                exceptions.set(i - 1, intersectExceptions((Class[]) exceptions.get(i - 1), exceptionTypes));
                methods.remove(i);
            }
        }
        return exceptions;
    }

    private static Class<?>[] intersectExceptions(Class<?>[] aExceptions, Class<?>[] bExceptions) {
        if (aExceptions.length == 0 || bExceptions.length == 0) {
            return EmptyArray.CLASS;
        }
        if (Arrays.equals((Object[]) aExceptions, (Object[]) bExceptions)) {
            return aExceptions;
        }
        Set<Class<?>> intersection = new HashSet<>();
        for (Class<?> a : aExceptions) {
            for (Class<?> b : bExceptions) {
                if (a.isAssignableFrom(b)) {
                    intersection.add(b);
                } else if (b.isAssignableFrom(a)) {
                    intersection.add(a);
                }
            }
        }
        return (Class[]) intersection.toArray(new Class[intersection.size()]);
    }

    private static void validateReturnTypes(List<Method> methods) {
        Method vs = null;
        for (Method method : methods) {
            if (vs == null || !vs.equalNameAndParameters(method)) {
                vs = method;
            } else {
                Class<?> returnType = method.getReturnType();
                Class<?> vsReturnType = vs.getReturnType();
                if (!returnType.isInterface() || !vsReturnType.isInterface()) {
                    if (vsReturnType.isAssignableFrom(returnType)) {
                        vs = method;
                    } else if (!returnType.isAssignableFrom(vsReturnType)) {
                        throw new IllegalArgumentException("proxied interface methods have incompatible return types:\n  " + vs + "\n  " + method);
                    }
                }
            }
        }
    }

    private static List<Method> getMethods(Class<?>[] interfaces) {
        List<Method> result = new ArrayList<>();
        try {
            result.add(Object.class.getMethod("equals", Object.class));
            result.add(Object.class.getMethod("hashCode", EmptyArray.CLASS));
            result.add(Object.class.getMethod("toString", EmptyArray.CLASS));
            getMethodsRecursive(interfaces, result);
            return result;
        } catch (NoSuchMethodException e) {
            throw new AssertionError();
        }
    }

    private static void getMethodsRecursive(Class<?>[] interfaces, List<Method> methods) {
        for (Class<?> i : interfaces) {
            getMethodsRecursive(i.getInterfaces(), methods);
            Collections.addAll(methods, i.getDeclaredMethods());
        }
    }

    @CallerSensitive
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h2) throws IllegalArgumentException {
        if (h2 == null) {
            throw new NullPointerException();
        }
        try {
            return newInstance(getProxyClass0(loader, interfaces).getConstructor(constructorParams), h2);
        } catch (NoSuchMethodException e) {
            throw new InternalError(e.toString());
        }
    }

    private static Object newInstance(Constructor<?> cons, InvocationHandler h2) {
        try {
            return cons.newInstance(h2);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new InternalError(e.toString());
        } catch (InvocationTargetException e2) {
            Throwable t = e2.getCause();
            if (t instanceof RuntimeException) {
                throw ((RuntimeException) t);
            }
            throw new InternalError(t.toString());
        }
    }

    public static boolean isProxyClass(Class<?> cl) {
        if (cl != null) {
            return proxyClasses.containsKey(cl);
        }
        throw new NullPointerException();
    }

    public static InvocationHandler getInvocationHandler(Object proxy) throws IllegalArgumentException {
        if (proxy instanceof Proxy) {
            return ((Proxy) proxy).h;
        }
        throw new IllegalArgumentException("not a proxy instance");
    }

    private static Object invoke(Proxy proxy, Method method, Object[] args) throws Throwable {
        return proxy.h.invoke(proxy, method, args);
    }

    private static void reserved1() {
    }

    private static void reserved2() {
    }
}
