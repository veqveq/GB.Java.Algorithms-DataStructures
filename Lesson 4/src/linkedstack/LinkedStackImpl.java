package linkedstack;

import linkedlist.simple.MyLinkedList;
import linkedlist.simple.SimpleLinkedListImpl;

public class LinkedStackImpl<E> implements MyStack<E> {

    MyLinkedList<E> list = new SimpleLinkedListImpl<>();

    @Override
    public boolean push(E value) {
        list.insertFirst(value);
        return true;
    }

    @Override
    public E pop() {
        return list.removeFirst();
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
