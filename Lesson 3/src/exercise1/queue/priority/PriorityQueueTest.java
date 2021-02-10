package exercise1.queue.priority;

import exercise1.queue.MyQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {

        MyQueue<Integer> queue = new PriorityQueue<>(5);

        System.out.println("Insert 1: " + queue.insert(1));
        System.out.println("Insert 6: " + queue.insert(6));
        System.out.println("Insert 2: " + queue.insert(2));
        System.out.println("Insert 5: " + queue.insert(5));
        System.out.println("Insert 4: " + queue.insert(4));
        System.out.println("Insert 3: " + queue.insert(3));

        System.out.println("Remove value: " + queue.remove());
        System.out.println("Insert 100: " + queue.insert(100));
        System.out.println("Remove value: " + queue.remove());
        System.out.println("Remove value: " + queue.remove());
        System.out.println("Insert 0: " + queue.insert(0));
        System.out.println("Insert 0: " + queue.insert(0));

        System.out.println(queue.display());
    }
}
