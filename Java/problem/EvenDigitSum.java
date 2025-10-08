package problem;

public class EvenDigitSum {

    public static void main(String[] args) {
        EvenDigitSum solver = new EvenDigitSum();
        int number = 123456;
        int result = solver.sumEvenDigits(number);
        System.out.println("Sum of even digits: " + result);
    }

    public int sumEvenDigits(int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                sum += digit;
            }
            number /= 10;
        }

        return sum;
    }
}
