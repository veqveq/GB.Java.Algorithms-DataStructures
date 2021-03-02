package lesson6.tree;

public class TreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> test = new BinaryTree<>(4);
        test.add(60);
        test.add(40);
        test.add(75);
        test.add(55);
        test.add(15);
        test.add(90);
        test.add(65);
        test.add(30);
        test.add(5);
        test.add(95);
        test.add(80);
        test.add(63);


        test.display();

        System.out.printf("Tree size: %d%n", test.size());
        System.out.printf("Tree is balanced: %s%n", test.isBalanced());
        System.out.printf("Tree contains 60: %s%n", test.contains(60));
        System.out.printf("Tree contains 600: %s%n", test.contains(600));

        test.display();

        System.out.printf("Tree remove 600: %s%n", test.remove(600));
        System.out.printf("Tree remove 60: %s%n", test.remove(40));

        test.display();

        System.out.printf("Tree size after remove: %d%n", test.size());
        System.out.printf("Tree is balanced: %s%n", test.isBalanced());


    }
}
