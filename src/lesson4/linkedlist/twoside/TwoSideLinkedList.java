package lesson4.linkedlist.twoside;

import lesson4.linkedlist.simple.MyLinkedList;
import linkedlist.Node;

public interface TwoSideLinkedList<E> extends MyLinkedList<E> {

    void insertLast(E value);

    E removeLast();

    E getLast();

    class TwoSideNode<E> extends Node<E> {
        TwoSideNode<E> previous;

        public TwoSideNode(E item, TwoSideNode<E> next, TwoSideNode<E> previous) {
            super(item, next);
            this.previous = previous;
        }

        public TwoSideNode<E> getNext() {
            return (TwoSideNode<E>) next;
        }

        @Override
        public void insertAfter(E item) {
            setNext(new TwoSideNode<E>(item, getNext(), this));
        }

        @Override
        public void insertBefore(Node<E> previous, E item) {
            TwoSideNode<E> newNode = new TwoSideNode<E>(item, this, this.getPrevious());
            setPrevious(newNode);
            previous.setNext(newNode);
        }

        @Override
        public E deleteCurrent(Node<E> previous) {
            setPrevious(null);
            return super.deleteCurrent(previous);
        }

        public void setNext(TwoSideNode<E> next) {
            this.next = next;
        }

        public TwoSideNode<E> getPrevious() {
            return previous;
        }

        public void setPrevious(TwoSideNode<E> previous) {
            this.previous = previous;
        }
    }
}
