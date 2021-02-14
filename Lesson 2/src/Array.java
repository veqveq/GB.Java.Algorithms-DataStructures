public interface Array <E> {

    void add(E element);
    E get(int index);
    int indexOf(E element);
    boolean compareTo(E element);
    void remove(int index);
    void remove (E element);
    boolean isEmpty();
    int size();
    void display();
}
