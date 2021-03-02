package lesson4.linkedlist.simple;

public class SimpleLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new SimpleLinkedListImpl<>();

        System.out.println("First element of empty list: " + list.getFirst());


        list.insertFirst(1);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);
        list.insertFirst(8);

        System.out.println("List is empty: " + list.isEmpty());

        System.out.println("List size: " + list.size());

        System.out.println("First element: " + list.getFirst());

        System.out.println("Remove first element: " + list.removeFirst());

        System.out.println("Contains 6: " + list.contains(6));
        System.out.println("Contains 66: " + list.contains(66));

        System.out.println("Remove 5: " + list.remove(5));
        System.out.println("Remove 555: " + list.remove(555));

        System.out.println(list.display());
    }
}
