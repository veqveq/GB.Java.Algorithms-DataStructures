package tree;

public interface Tree<E extends Comparable<? super E>> {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }

    void add(E value);

    boolean contains(E value);

    boolean remove(E value);

    void traverse(TraverseMode mode);

    boolean isBalanced();

    boolean isEmpty();

    int size();

    void display();
}
