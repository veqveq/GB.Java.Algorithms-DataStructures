package lesson6.tree;


import java.util.Stack;

public class BinaryTree<E extends Comparable<? super E>> implements Tree<E> {

    private int size;
    private TreeNode<E> root;
    private final int maxLevel;

    private class ParentTreeNode {
        TreeNode<E> current;
        TreeNode<E> parent;

        public ParentTreeNode(TreeNode<E> current, TreeNode<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    public BinaryTree() {
        this.maxLevel = -1;
    }

    public BinaryTree(int maxLevel) {
        if (maxLevel > 0) {
            this.maxLevel = maxLevel;
        } else {
            throw new IllegalArgumentException("Level must be positive number");
        }
    }

    private ParentTreeNode doFind(E value) {
        TreeNode<E> current = root;
        TreeNode<E> previous = null;
        while (current != null) {
            if (current.getData().equals(value)) {
                return new ParentTreeNode(current, previous);
            }
            previous = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return new ParentTreeNode(null, previous);
    }

    private TreeNode<E> findSuccessor(TreeNode<E> removedNode) {
        if (removedNode.getLeftChild() == null) {
            return removedNode;
        } else {
            return findSuccessor(removedNode.getLeftChild());
        }
    }

    private void postOrder(TreeNode<E> current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
        System.out.println(current.getData());

    }

    private void preOrder(TreeNode<E> current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getData());
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
    }

    private void inOrder(TreeNode<E> current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeftChild());
        System.out.println(current.getData());
        inOrder(current.getRightChild());
    }

    private boolean checkBalance(TreeNode<E> current) {
        return current == null ||
                checkBalance(current.getLeftChild()) &&
                        checkBalance(current.getLeftChild()) &&
                        Math.abs(height(current.getLeftChild()) - height(current.getRightChild())) <= 1;
    }

    private int height(TreeNode<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    private int checkLevel(E value) {
        int level = 0;
        TreeNode<E> current = doFind(value).parent;
        while (current != null) {
            current = doFind(current.getData()).parent;
            level++;
        }
        return level;
    }

    @Override
    public void add(E value) {
        TreeNode<E> newNode = new TreeNode<>(value);
        if (isEmpty()) {
            root = newNode;
        }
        if (checkLevel(value) < maxLevel ^ maxLevel == -1) {
            ParentTreeNode parentTreeNode = doFind(value);
            if (parentTreeNode.current == null) {
                TreeNode<E> parent = parentTreeNode.parent;
                if (parent.isLeftChild(value)) {
                    parent.setLeftChild(newNode);
                } else {
                    parent.setRightChild(newNode);
                }
            }
            size++;
        }
    }

    @Override
    public boolean contains(E value) {
        ParentTreeNode parentTreeNode = doFind(value);
        return parentTreeNode.current != null;
    }

    @Override
    public boolean remove(E value) {

        ParentTreeNode removedParentNode = doFind(value);

        TreeNode<E> removedNode = removedParentNode.current;
        if (removedNode == null) return false;

        TreeNode<E> parentNode = removedParentNode.parent;
        if (removedNode.isLeaf()) {
            if (removedNode == root) {
                root = null;
            } else if (parentNode.isLeftChild(value)) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
            size--;
            return true;
        }

        TreeNode<E> childNode;
        if (removedNode.hasOnlyChild()) {
            childNode = removedNode.getLeftChild() != null
                    ? removedNode.getLeftChild()
                    : removedNode.getRightChild();
            if (removedNode == root) {
                root = childNode;
            } else if (parentNode.isLeftChild(value)) {
                parentNode.setLeftChild(childNode);
            } else {
                parentNode.setRightChild(childNode);
            }
        } else {
            childNode = findSuccessor(removedNode.getRightChild());
            childNode.setLeftChild(removedNode.getLeftChild());
            if (removedNode == root) {
                root = removedNode.getRightChild();
            } else if (parentNode.isLeftChild(value)) {
                parentNode.setLeftChild(removedNode.getRightChild());
            } else {
                parentNode.setRightChild(removedNode.getRightChild());
            }
        }
        size--;
        return true;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown traverse mode: %s", mode));
        }
    }

    @Override
    public boolean isBalanced() {
        return checkBalance(root);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<TreeNode<E>> globalStack = new Stack<>();
        int nBlanks = 64;
        boolean isRowEmpty = false;

        globalStack.push(root);
        System.out.println(".....................................................................................");

        while (!isRowEmpty) {
            Stack<TreeNode<E>> localStack = new Stack<>();

            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                TreeNode<E> tmpNode = globalStack.pop();
                if (tmpNode != null) {
                    System.out.print(tmpNode.getData());
                    localStack.push(tmpNode.getLeftChild());
                    localStack.push(tmpNode.getRightChild());
                    if (tmpNode.getLeftChild() != null || tmpNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println(".....................................................................................");
    }
}