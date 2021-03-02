package lesson3.exercise1.queue.priority;

import exercise1.queue.MyQueue;
import exercise1.queue.QueueImpl;

public class PriorityQueue<E extends Object & Comparable<E>> extends QueueImpl<E> implements MyQueue<E> {

    public PriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) return false;
        if (isEmpty()) {
            super.insert(value);
        } else {
            int index;
            for (index = size() - 1; index >= 0; index--) {
                if (data[index].compareTo(value) > 0) {
                    data[index + 1] = data[index];
                } else {
                    break;
                }
            }
            data[index + 1] = value;
            size++;
        }
        return true;
    }

    @Override
    public E remove() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public E peek() {
        return isEmpty() ? null : data[size - 1];
    }
}
