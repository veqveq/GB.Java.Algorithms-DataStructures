public class HashMapImpl<K, V> implements HashMap<K, V> {

    private int size;

    private final Item<K, V>[] data;

    private static class Item<K, V> implements Entry<K, V> {

        private K key;
        private V value;
        private Item<K, V> child;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        public Item<K, V> getChild() {
            return child;
        }

        public void setChild(Item<K, V> child) {
            this.child = child;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

    @SuppressWarnings("unchecked")
    public HashMapImpl(int maxSize) {
        this.data = new Item[maxSize * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    private void addParentEntry(Item<K, V> currentItem, Item<K, V> newItem) {
        if (currentItem.getChild() == null) {
            currentItem.setChild(newItem);
        } else {
            addParentEntry(currentItem.getChild(), newItem);
        }
    }

    @Override
    public boolean put(K key, V value) {
        Item<K, V> newItem = new Item<>(key, value);
        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = newItem;
        } else {
            if (data[index].getKey().equals(key)) {
                data[index].setValue(value);
            } else {
                addParentEntry(data[index], newItem);
            }
        }
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return null;
        } else {
            if (data[index].getKey().equals(key)) {
                return data[index].getValue();
            } else {
                Item<K, V> currentItem = data[index].getChild();
                while (currentItem != null) {
                    if (currentItem.getKey().equals(key)) {
                        return currentItem.getValue();
                    } else {
                        currentItem = currentItem.getChild();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return false;
        } else {
            if (data[index].getKey().equals(key)) {
                if (data[index].getChild() == null) {
                    data[index] = null;
                } else {
                    data[index] = data[index].getChild();
                }
                size--;
                return true;
            } else {
                Item<K, V> parentItem = data[index];
                Item<K, V> currentItem = data[index].getChild();
                while (currentItem != null) {
                    if (currentItem.getKey().equals(key)) {
                        if (currentItem.getChild() != null) {
                            parentItem.setChild(currentItem.getChild());
                        } else {
                            parentItem.setChild(null);
                        }
                        size--;
                        return true;
                    } else {
                        parentItem = currentItem;
                        currentItem = currentItem.getChild();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(".....................................................");
        for (Item<K, V> item : data) {
            if (item != null) {
                if (item.getChild() == null) {
                    System.out.println(item);
                } else {
                    Item<K, V> currentItem = item;
                    while (currentItem != null) {
                        System.out.println(currentItem);
                        currentItem = currentItem.getChild();
                    }
                }
            } else {
                System.out.println(item);
            }
        }
        System.out.println(".....................................................");
    }
}
