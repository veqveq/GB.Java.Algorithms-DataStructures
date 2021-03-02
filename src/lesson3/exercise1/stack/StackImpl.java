package lesson3.exercise1.stack;

public class StackImpl<E extends Object> implements MyStack<E> {

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E value) {
        data[size++] = value;
    }

    @Override
    public E pop() {
        return data[--size];
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!isEmpty()) {
            sb.append(pop())
                    .append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        while (!isEmpty()) {
            sb.append(pop());
        }
        return sb.toString();
    }
}
