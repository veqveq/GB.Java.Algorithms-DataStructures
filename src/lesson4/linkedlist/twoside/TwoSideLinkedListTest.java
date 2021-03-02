package lesson4.linkedlist.twoside;

public class TwoSideLinkedListTest {
    public static void main(String[] args) {
        TwoSideLinkedList<Integer> list = new TwoSideLinkedListImpl<>();

        System.out.println("First element of empty list: " + list.getFirst());
        System.out.println("Last element of empty list: " + list.getLast());


        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);

        System.out.println("List is empty: " + list.isEmpty());

        System.out.println("List size: " + list.size());

        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        System.out.println("Remove first element: " + list.removeFirst());
        System.out.println("Remove last element: " + list.removeLast());

        System.out.println("Contains 6: " + list.contains(6));
        System.out.println("Contains 66: " + list.contains(66));

        System.out.println("Remove 5: " + list.remove(6));
        System.out.println("Remove 555: " + list.remove(666));

        System.out.println(list.display());
    }
}
