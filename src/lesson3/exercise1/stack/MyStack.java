package lesson3.exercise1.stack;

public interface MyStack<E> {

    void push(E value);

    E pop();

    E peek();

    int size();

    boolean isFull();

    boolean isEmpty();

    String display();
}
