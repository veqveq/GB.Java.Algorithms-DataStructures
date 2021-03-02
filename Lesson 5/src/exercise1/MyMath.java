package exercise1;

public class MyMath {

    private static double result = 1;

    public static double power(double val, int power) {
        if (power == 0) {
            try {
                return result;
            } finally {
                result = 1;
            }
        }
        if (power > 0) {
            result *= val;
            return power(val, --power);
        } else {
            result /= val;
            return power(val, ++power);
        }
    }
}
