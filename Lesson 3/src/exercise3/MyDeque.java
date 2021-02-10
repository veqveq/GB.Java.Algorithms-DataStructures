package exercise3;

import exercise1.queue.MyQueue;

public interface MyDeque<E> extends MyQueue<E> {

    boolean addFirst(E value);

    boolean addLast(E value);

    E removeFirst();

    E removeLast();

    E peekFirst();

    E peekLast();

    int size();

    boolean isFull();

    boolean isEmpty();

    String display();

}
