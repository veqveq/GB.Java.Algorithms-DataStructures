package lesson1;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        algorithm2();//более эффективный
    }


    public static void algorithm1() {
        System.out.println("Загадай число от 1 до 100");
        short counter = 0;
        int a = 1000;
        int da = a / 2;
        a /= 2;
        boolean win = false;
        while (!win) {
            counter++;
            da = Math.max(da / 2, 1);
            System.out.println(String.format("Ваше число: больше (+): меньше (-): равно (=) чем %d?", a));
            char ans = sc.nextLine().charAt(0);
            if (ans == '+') {
                a += da;
            } else if (ans == '-') {
                a -= da;
            } else if (ans == '=') {
                System.out.println(String.format("Я выиграл. Загаданное число: %d. Число попыток: %d", a, counter));
                win = true;
            }
        }
    }

    public static void algorithm2() {
        short counter = 0;
        long start = 0;
        long finish = 400000000;
        System.out.println("Загадай число от 1 до " + finish);
        boolean win = false;
        while (!win) {
            counter++;
            long delta = (finish + start) / 2;
            System.out.println(String.format("Ваше число: больше (+): меньше (-): равно (=) чем %d?", delta));
            char ans = sc.nextLine().charAt(0);
            if (ans == '+') {
                start = delta;
            } else if (ans == '-') {
                finish = delta;
            } else if (ans == '=') {
                System.out.println(String.format("Я выиграл. Загаданное число: %d. Число попыток: %d", delta, counter));
                win = true;
            }
        }
    }
}
