public class HashMapTest {
    public static void main(String[] args) {
        hashMapTest();
    }

    public static void hashMapTest() {
        HashMap<Product, Integer> products = new HashMapImpl<>(5);
        products.put(new Product(1, "Apple"), 60);
        products.put(new Product(21, "Pineapple"), 130);
        products.put(new Product(60, "Orange"), 15);
        products.put(new Product(16, "Lemon"), 5);
        products.put(new Product(25, "Cherry"), 550);
        products.put(new Product(152, "Strawberry"), 1200);
        products.put(new Product(60, "Banana"), 80);

        System.out.println("Map size = " + products.size());
        System.out.println("Cost by product Apple = " + products.get(new Product(1, "Apple")));
        System.out.println("Cost by product Lemon = " + products.get(new Product(16, "Lemon")));
        products.display();

        System.out.println("Remove product Cherry: " + products.remove(new Product(25, "Cherry")));
        System.out.println("Remove product Orange: " + products.remove(new Product(60, "Orange")));
        System.out.println("Remove product Cucumber: " + products.remove(new Product(166, "Cucumber")));
        System.out.println("Map size = " + products.size());
        products.display();
    }
}
