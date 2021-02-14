import java.util.Arrays;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E>, SortedArr {

    private static final int DEFAULT_SIZE = 10;

    private int size;
    private E[] data;

    public ArrayImpl() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int size) {
        this.data = (E[]) new Comparable[size];
    }

    @Override
    public void add(E element) {
        checkAndGrow();
        data[size++] = element;
    }

    @Override
    public E get(int index) {
        if (checkArrIndex(index))
            throw new IndexOutOfBoundsException(String.format("Incorrect index value: %d. Array size: %d", index, size));
        return data[index];
    }

    @Override
    public boolean compareTo(E element) {
        for (E val : data) {
            if (val.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[size - 1] = null;
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 1; j < size; j++) {
                if (data[j].compareTo(data[j - 1]) < 0) swap(j, j - 1);
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[minIndex].compareTo(data[j]) > 0) minIndex = j;
            }
            swap(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E minValue = data[i];
            int minIndex = i;
            while (minIndex > 0 && data[minIndex - 1].compareTo(minValue) >= 0) {
                data[minIndex] = data[minIndex - 1];
                minIndex--;
            }
            data[minIndex] = minValue;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.append(data[size - 1]).append("]");
        return sb.toString();
    }

    private boolean checkArrIndex(int index) {
        return (index < 0 && index >= size);
    }

    private void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, recalcSize());
        }
    }

    private int recalcSize() {
        return size == 0 ? 1 : size * 2;
    }

    private void swap(int indexA, int indexB) {
        E tmp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = tmp;
    }
}
