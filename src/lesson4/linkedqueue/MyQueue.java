package lesson4.linkedqueue;

public interface MyQueue<E> {
    boolean insert(E value);

    E remove();

    E peek();

    int size();

    boolean isFull();

    boolean isEmpty();

    String display();

}
