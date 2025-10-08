package problem;

public class FirstLastDigitSum {

    public static void main(String[] args) {
        FirstLastDigitSum solver = new FirstLastDigitSum();
        int number = 1234;
        int result = solver.sumFirstAndLastDigit(number);
        System.out.println("Sum of first and last digit: " + result);
    }

    public int sumFirstAndLastDigit(int number) {

        if (number < 0) {
            return -1;
        }

        String inputNum = number + "";

        return (inputNum.charAt(0) - '0') + (inputNum.charAt(inputNum.length() - 1) - '0');

    }

}
