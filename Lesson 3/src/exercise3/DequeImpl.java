package exercise3;

import exercise1.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements MyDeque<E> {


    public DequeImpl(int capacity) {
        super(capacity);
    }

    @Override
    public boolean addLast(E value) {
        return super.insert(value);
    }

    @Override
    public E removeFirst() {
        return super.remove();
    }

    @Override
    public E peekLast() {
        if (tail == 0 && size != 0) return data[data.length - 1];
        return super.peek();

    }

    @Override
    public E peekFirst() {
        return data[head + 1];
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        if (data.length - 1 == 0 && size != 0) return data[data.length - 1];
        size--;
        return data[--tail];
    }

    @Override
    public boolean addFirst(E value) {
        if (isFull()) return false;
        if (head == -1) head = data.length - 1;
        data[head--] = value;
        size++;
        return true;
    }
}
