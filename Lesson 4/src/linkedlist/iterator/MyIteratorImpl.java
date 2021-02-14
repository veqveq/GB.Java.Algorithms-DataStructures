package linkedlist.iterator;

import linkedlist.Node;
import linkedlist.simple.MyLinkedList;

public class MyIteratorImpl<E> implements MyIterator<E> {
    private Node<E> previous;
    private Node<E> current;
    private MyLinkedList<E> list;

    public MyIteratorImpl(MyLinkedList<E> list) {
        this.list = list;
        remove();
    }

    @Override
    public E next() {
        E item = current.getItem();
        if (hasNext()) {
            nextLink();
        }
        return item;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public void remove() {
        current = list.getFirstNode();
        previous = null;
    }

    @Override
    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    @Override
    public E getCurrent() {
        return current.getItem();
    }

    @Override
    public boolean atEnd() {
        return current.getNext() == null;
    }

    @Override
    public void insertAfter(E value) {
        current.insertAfter(value);
    }

    @Override
    public void insertBefore(E value) {
        current.insertBefore(previous, value);
        previous = previous.getNext();
    }

    @Override
    public E deleteCurrent() {
        try {
            return current.deleteCurrent(previous);
        } finally {
            current = previous.getNext();
        }
    }
}
