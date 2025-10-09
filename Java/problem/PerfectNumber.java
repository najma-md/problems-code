package problem;

public class PerfectNumber {

    public static void main(String[] args) {
        int num = 6;
        boolean result = isPerfectNumber(num);
        System.out.println("Is perfect number: " + result);
    }

    public static boolean isPerfectNumber(int num) {
        if (num < 1) {
            return false;
        }

        int sum = 0;
        int factor = 1;
        while (factor < num) {
            if (num % factor == 0) {
                sum += factor;
            }
            factor += 1;
        }

        return sum == num;
    }
}
