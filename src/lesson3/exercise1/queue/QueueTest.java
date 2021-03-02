package lesson3.exercise1.queue;


public class QueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new QueueImpl<>(5);

        for (int i = 1; i < 7; i++) {
            System.out.printf("Push %d in queue: %s%n", i, queue.insert(i));
        }

        System.out.printf("Queue is full: %s%n", queue.isFull());
        System.out.printf("Pop value from queue: %d%n", queue.peek());
        System.out.printf("Queue size : %d%n", queue.size());
        System.out.println("Remove once element from queue: " + queue.remove());
        int testVal = 256;
        System.out.printf("Add %d in queue: %s%n", testVal, queue.insert(testVal));

        System.out.println(queue.display());

        System.out.printf("Stack is empty: %s%n", queue.isEmpty());
    }
}
