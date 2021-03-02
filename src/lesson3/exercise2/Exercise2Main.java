package lesson3.exercise2;

public class Exercise2Main {

    private static final String TEST_STRING = "Hello, World!";

    public static void main(String[] args) {
        StringReverser sr = new StringReverser();
        sr.add(TEST_STRING);
        sr.append("Guys");
        System.out.println(sr.reverse());

    }
}
