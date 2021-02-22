package linkedlist.iterator;

import linkedlist.simple.MyLinkedList;
import linkedlist.simple.SimpleLinkedListImpl;

public class IteratorTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new SimpleLinkedListImpl<>();
//        MyLinkedList<Integer> list = new TwoSideLinkedListImpl<>();

        list.insertFirst(1);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);
        list.insertFirst(8);

        MyIterator<Integer> iterator = list.iterator();

        System.out.println(iterator.next());
        System.out.println("Current element: " + iterator.getCurrent());

        iterator.insertAfter(10);
        iterator.insertBefore(12);
        System.out.println("Delete current element: " + iterator.deleteCurrent());

        System.out.println("Iterator is at the end of the list: " + iterator.atEnd());

        System.out.println("Iterator has next position: " + iterator.hasNext());

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
