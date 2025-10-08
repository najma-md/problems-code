package problem;

public class LastDigitChecker {

    public static void main(String[] args) {
        LastDigitChecker solver = new LastDigitChecker();
        int num1 = 41;
        int num2 = 22;
        int num3 = 71;
        boolean result = solver.hasSameLastDigit(num1, num2, num3);
        System.out.println("Has same last digit: " + result);
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (!isValid(num1) || !isValid(num2) || !isValid(num3)) {
            return false;
        }

        return (num1 % 10 == num2 % 10) || (num1 % 10 == num3 % 10) || (num2 % 10 == num3 % 10);
    }

    public static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}
