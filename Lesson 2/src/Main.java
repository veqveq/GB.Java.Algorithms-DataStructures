public class Main {
    private static final int ARRAY_SIZE = 10000;

    public static void main(String[] args) {
        bubbleSort(generateArr(ARRAY_SIZE));
        selectSort(generateArr(ARRAY_SIZE));
        insertSort(generateArr(ARRAY_SIZE));
    }

    public static ArrayImpl<Integer> generateArr(int size) {
        ArrayImpl<Integer> array = new ArrayImpl<>(size);
        for (int i = 0; i < size; i++) {
            array.add((int) (Math.random() * 1000));
        }
        return array;
    }

    public static void bubbleSort(ArrayImpl<Integer> array) {
        System.out.println(array);
        long start = System.nanoTime();
        array.bubbleSort();
        long finish = System.nanoTime();
        System.out.println(array);
        System.out.printf("Operation time: %d ms \n", finish - start);
    }

    public static void selectSort(ArrayImpl<Integer> array) {
        System.out.println(array);
        long start = System.nanoTime();
        array.sortSelect();
        long finish = System.nanoTime();
        System.out.println(array);
        System.out.printf("Operation time: %d ms \n", finish - start);
    }

    public static void insertSort(ArrayImpl<Integer> array) {
        System.out.println(array);
        long start = System.nanoTime();
        array.sortInsert();
        long finish = System.nanoTime();
        System.out.println(array);
        System.out.printf("Operation time: %d ms \n", finish - start);
    }
}
