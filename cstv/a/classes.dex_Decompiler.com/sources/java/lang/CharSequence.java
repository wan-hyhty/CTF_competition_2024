package java.lang;

import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public interface CharSequence {

    /* renamed from: java.lang.CharSequence$-java_util_stream_IntStream_chars__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_IntStream_chars__LambdaImpl0 implements Supplier {
        public /* synthetic */ java_util_stream_IntStream_chars__LambdaImpl0() {
        }

        public Object get() {
            return CharSequence.this.m54java_lang_CharSequence_lambda$1();
        }
    }

    /* renamed from: java.lang.CharSequence$-java_util_stream_IntStream_codePoints__LambdaImpl0  reason: invalid class name */
    final /* synthetic */ class java_util_stream_IntStream_codePoints__LambdaImpl0 implements Supplier {
        public /* synthetic */ java_util_stream_IntStream_codePoints__LambdaImpl0() {
        }

        public Object get() {
            return CharSequence.this.m55java_lang_CharSequence_lambda$2();
        }
    }

    char charAt(int i);

    int length();

    CharSequence subSequence(int i, int i2);

    String toString();

    IntStream chars() {
        return StreamSupport.intStream(new java_util_stream_IntStream_chars__LambdaImpl0(), 16464, false);
    }

    /* renamed from: -java_lang_CharSequence_lambda$1  reason: not valid java name */
    /* synthetic */ Spliterator.OfInt m54java_lang_CharSequence_lambda$1() {
        return Spliterators.spliterator((PrimitiveIterator.OfInt) new PrimitiveIterator.OfInt() {
            int cur = 0;

            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            public boolean hasNext() {
                return this.cur < CharSequence.this.length();
            }

            public int nextInt() {
                if (hasNext()) {
                    CharSequence charSequence = CharSequence.this;
                    int i = this.cur;
                    this.cur = i + 1;
                    return charSequence.charAt(i);
                }
                throw new NoSuchElementException();
            }

            public void forEachRemaining(IntConsumer block) {
                while (this.cur < CharSequence.this.length()) {
                    block.accept(CharSequence.this.charAt(this.cur));
                    this.cur++;
                }
            }
        }, (long) length(), 16);
    }

    IntStream codePoints() {
        return StreamSupport.intStream(new java_util_stream_IntStream_codePoints__LambdaImpl0(), 16, false);
    }

    /* renamed from: -java_lang_CharSequence_lambda$2  reason: not valid java name */
    /* synthetic */ Spliterator.OfInt m55java_lang_CharSequence_lambda$2() {
        return Spliterators.spliteratorUnknownSize((PrimitiveIterator.OfInt) new PrimitiveIterator.OfInt() {
            int cur = 0;

            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            public void forEachRemaining(IntConsumer block) {
                int i;
                int length = CharSequence.this.length();
                int i2 = this.cur;
                while (i2 < length) {
                    try {
                        i = i2 + 1;
                        try {
                            char c1 = CharSequence.this.charAt(i2);
                            if (!Character.isHighSurrogate(c1) || i >= length) {
                                block.accept(c1);
                            } else {
                                char c2 = CharSequence.this.charAt(i);
                                if (Character.isLowSurrogate(c2)) {
                                    i++;
                                    block.accept(Character.toCodePoint(c1, c2));
                                } else {
                                    block.accept(c1);
                                }
                            }
                            i2 = i;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = i2;
                        this.cur = i;
                        throw th;
                    }
                }
                this.cur = i2;
            }

            public boolean hasNext() {
                return this.cur < CharSequence.this.length();
            }

            public int nextInt() {
                int length = CharSequence.this.length();
                if (this.cur >= length) {
                    throw new NoSuchElementException();
                }
                CharSequence charSequence = CharSequence.this;
                int i = this.cur;
                this.cur = i + 1;
                char c1 = charSequence.charAt(i);
                if (Character.isHighSurrogate(c1) && this.cur < length) {
                    char c2 = CharSequence.this.charAt(this.cur);
                    if (Character.isLowSurrogate(c2)) {
                        this.cur++;
                        return Character.toCodePoint(c1, c2);
                    }
                }
                return c1;
            }
        }, 16);
    }
}
