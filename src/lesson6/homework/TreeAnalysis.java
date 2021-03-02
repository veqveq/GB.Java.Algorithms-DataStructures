package lesson6.homework;

import lesson6.tree.BinaryTree;

public class TreeAnalysis {

    private static final int ITERATIONS = 20;

    public static void main(String[] args) {
        int countBalanced = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            BinaryTree<Integer> tree = new BinaryTree<>(4);
            for (int j = 0; j < 5; j++) {
                tree.add((int) (Math.random() * 50 - 25));
            }
            tree.display();
            System.out.printf("Tree #%d is balanced: %s%n", i + 1, tree.isBalanced());
            if (tree.isBalanced()) countBalanced++;
        }
        System.out.printf("Quantity of balanced trees: %d%n", countBalanced);
        System.out.printf("Quantity of non-balanced trees: %d%n", ITERATIONS - countBalanced);
        System.out.printf("Percent of balanced trees: %d%%%n", countBalanced * 100 / ITERATIONS);
    }
}
