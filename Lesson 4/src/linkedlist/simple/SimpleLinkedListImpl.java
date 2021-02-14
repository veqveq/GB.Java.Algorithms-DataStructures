package linkedlist.simple;

public class SimpleLinkedListImpl<E> implements MyLinkedList<E> {

    protected int size;
    protected SimpleNode<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new SimpleNode<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        SimpleNode<E> removedNode = firstElement;
        firstElement = removedNode.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode.getItem();
    }

    @Override
    public boolean remove(E value) {
        if (isEmpty()) {
            return false;
        }

        if (firstElement.getItem().equals(value)) {
            removeFirst();
            size--;
            return true;
        }

        SimpleNode<E> findNode = firstElement.getNext();
        SimpleNode<E> previous = firstElement;
        while (findNode != null) {
            if (findNode.getItem().equals(value)) {
                break;
            }
            previous = findNode;
            findNode = findNode.getNext();
        }
        if (findNode == null) return false;
        previous.setNext(findNode.getNext());
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        SimpleNode<E> findNode = firstElement;
        while (findNode != null) {
            if (findNode.getItem().equals(value)) return true;
            findNode = findNode.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(removeFirst());
        while (size > 0) {
            sb.append(", ").append(removeFirst());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public E getFirst() {
        return firstElement != null ? firstElement.getItem() : null;
    }

    @Override
    public SimpleNode<E> getFirstNode() {
        return firstElement;
    }
}
