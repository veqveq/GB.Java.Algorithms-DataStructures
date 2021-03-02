package lesson3.exercise3;

public class DequeTest {
    public static void main(String[] args) {
        MyDeque<Integer> deque = new DequeImpl<>(11);
        int testVal = 256;

        for (int i = 1; i < 6; i++) {
            System.out.printf("Push first %d in dec: %s%n", i, deque.addFirst(i));
        }

        for (int i = 1; i < 7; i++) {
            System.out.printf("Push first %d in dec: %s%n", i, deque.addLast(i));
        }

        System.out.printf("Dec is full: %s%n", deque.isFull());
        System.out.printf("Peek first value: %d%n", deque.peekFirst());
        System.out.printf("Peek last value: %d%n", deque.peekLast());
        System.out.printf("Queue size : %d%n", deque.size());
        System.out.println("Remove last element: " + deque.removeLast());
        System.out.println("Remove first element: " + deque.removeFirst());
        System.out.println("Remove first element: " + deque.removeFirst());
        System.out.printf("Add %d in first: %s%n", testVal*2, deque.addFirst(testVal*2));
        System.out.printf("Add %d in last: %s%n", testVal, deque.addLast(testVal));
        System.out.printf("Add %d in first: %s%n", testVal*2, deque.addFirst(testVal*2));

        System.out.println(deque.display());

        System.out.printf("Stack is empty: %s%n", deque.isEmpty());
    }
}
