package linkedlist.twoside;

public class TwoSideLinkedListImpl<E>
        implements TwoSideLinkedList<E> {

    protected int size;
    private TwoSideNode<E> lastElement;
    private TwoSideNode<E> firstElement;

    @Override
    public void insertFirst(E value) {
        TwoSideNode<E> newNode = new TwoSideNode<>(value, firstElement, null);
        if (!isEmpty()) {
            firstElement.previous = newNode;
        } else {
            lastElement = newNode;
        }
        firstElement = newNode;
        size++;
    }

    @Override
    public void insertLast(E value) {
        TwoSideNode<E> newNode = new TwoSideNode<>(value, null, lastElement);
        if (!isEmpty()) {
            lastElement.setNext(newNode);
        } else {
            firstElement = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        if (firstElement == lastElement) {
            size--;
            return firstElement.getItem();
        }
        TwoSideNode<E> removed = firstElement;
        firstElement = firstElement.getNext();
        firstElement.previous = null;
        removed.setNext(null);
        size--;
        return removed.getItem();
    }


    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        if (firstElement == lastElement) {
            size--;
            return firstElement.getItem();
        }
        TwoSideNode<E> removed = lastElement;
        lastElement = lastElement.previous;
        removed.previous = null;
        lastElement.setNext(null);
        size--;
        return removed.getItem();
    }

    @Override
    public E getFirst() {
        return firstElement != null ? firstElement.getItem() : null;
    }

    @Override
    public TwoSideNode<E> getFirstNode() {
        return firstElement;
    }

    @Override
    public E getLast() {
        return lastElement != null ? lastElement.getItem() : null;
    }

    @Override
    public boolean remove(E value) {
        if (isEmpty()) return false;

        TwoSideNode<E> findNode = firstElement;
        while (findNode != null) {
            if (findNode.getItem().equals(value)) break;
            findNode = findNode.getNext();
        }
        if (findNode == null) return false;

        if (findNode.previous == null) {
            removeFirst();
        } else if (findNode.getNext() == null) {
            removeLast();
        } else {
            findNode.previous.setNext(findNode);
            findNode.getNext().previous = findNode.previous;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        TwoSideNode<E> findNode = firstElement;
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
}
