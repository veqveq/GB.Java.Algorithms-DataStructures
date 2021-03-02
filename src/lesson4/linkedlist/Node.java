package linkedlist;

public abstract class Node<E> {
    protected final E item;
    protected Node<E> next;

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public abstract void insertAfter(E item);

    public abstract void insertBefore(Node<E> previous, E item);

    public E deleteCurrent(Node<E> previous) {
        previous.setNext(this.getNext());
        setNext(null);
        return getItem();
    }
}
