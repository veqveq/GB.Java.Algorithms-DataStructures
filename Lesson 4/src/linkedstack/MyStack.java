package linkedstack;

public interface MyStack<E> {

    boolean push(E value);

    E pop();

    E peek();

    int size();

    boolean isFull();

    boolean isEmpty();

    String display();
}
