package lesson4.linkedqueue;


import lesson4.linkedlist.twoside.TwoSideLinkedList;
import lesson4.linkedlist.twoside.TwoSideLinkedListImpl;

public class LinkedQueueImpl<E> implements MyQueue<E> {
    TwoSideLinkedList<E> list = new TwoSideLinkedListImpl<>();

    @Override
    public boolean insert(E value) {
        list.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        list.removeFirst();
        return null;
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String display() {
        return list.display();
    }
}
