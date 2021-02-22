package linkedlist.iterator;

import java.util.Iterator;

public interface MyIterator<E> extends Iterator<E> {

    void nextLink();

    E getCurrent();

    boolean atEnd();

    void insertAfter(E value);

    void insertBefore(E value);

    E deleteCurrent();


}
