package linkedlist.simple;

import linkedlist.Node;
import linkedlist.iterator.MyIterator;
import linkedlist.iterator.MyIteratorImpl;

public interface MyLinkedList<E> extends Iterable<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    String display();

    E getFirst();

    Node<E> getFirstNode();


    @Override
    default MyIterator<E> iterator() {
        return new MyIteratorImpl<E>(this);
    }

    class SimpleNode<E> extends Node<E> {

        public SimpleNode(E item, SimpleNode<E> next) {
            super(item, next);
        }

        public SimpleNode<E> getNext() {
            return (SimpleNode<E>) next;
        }

        @Override
        public void insertAfter(E value) {
            setNext(new SimpleNode<>(value, getNext()));
        }

        @Override
        public void insertBefore(Node<E> previous, E item) {
            previous.setNext(new SimpleNode<>(item, this));
        }

        public void setNext(SimpleNode<E> next) {
            this.next = next;
        }
    }
}
