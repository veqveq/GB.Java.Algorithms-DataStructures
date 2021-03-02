package lesson6.tree;

public class TreeNode<T extends Comparable<? super T>> {
    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(T value) {
        return data.compareTo(value) > 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyChild() {
        return leftChild != null ^ rightChild != null;
    }
}
