package java.lang;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public interface Iterable<T> {
    Iterator<T> iterator();

    void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        Iterator t$iterator = iterator();
        while (t$iterator.hasNext()) {
            action.accept(t$iterator.next());
        }
    }

    Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
