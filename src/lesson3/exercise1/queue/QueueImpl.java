package lesson3.exercise1.queue;

public class QueueImpl<E> implements MyQueue<E> {

    private static final int DEFAULT_HEAD = -1;
    private static final int DEFAULT_TAIL = 0;

    protected final E[] data;
    protected int size;
    protected int head;
    protected int tail;

    @SuppressWarnings("unchecked")
    public QueueImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) return false;
        if (tail == data.length) tail = DEFAULT_TAIL;
        size++;
        data[tail++] = value;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        if (head == data.length - 1) head = DEFAULT_HEAD;
        size--;
        return data[++head];
    }

    @Override
    public E peek() {
        return data[tail - 1];
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
            E val = remove();
            if (val != null) {
                sb.append(val)
                        .append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
