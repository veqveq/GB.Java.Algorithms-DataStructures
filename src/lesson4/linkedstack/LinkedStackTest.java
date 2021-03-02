package lesson4.linkedstack;

public class LinkedStackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new LinkedStackImpl<>();

        for (int i = 1; i < 7; i++) {
            System.out.printf("Push %d in stack: %s%n", i, addValue(stack, i));
        }

        System.out.printf("Stack is full: %s%n", stack.isFull());
        System.out.printf("Stack size : %d%n", stack.size());
        System.out.printf("Pop value from stack: %d%n", stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.display());

        System.out.printf("Stack is empty: %s%n", stack.isEmpty());
    }

    private static <E> boolean addValue(MyStack<E> stack, E value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

}
