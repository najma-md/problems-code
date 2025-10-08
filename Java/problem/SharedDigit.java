package problem;

public class SharedDigit {

    public static void main(String[] args) {
        SharedDigit solver = new SharedDigit();
        int num1 = 12;
        int num2 = 23;
        boolean result = solver.hasSharedDigit(num1, num2);
        System.out.println("Has shared digit: " + result);
    }

    public boolean hasSharedDigit(int num1, int num2) {
        if (num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }

        int[] numExist = new int[10];

        while (num1 > 0) {
            int digit = num1 % 10;
            numExist[digit] = 1;
            num1 /= 10;
        }

        while (num2 > 0) {
            int digit = num2 % 10;
            if (numExist[digit] == 1) {
                return true;
            }
            num2 /= 10;
        }

        return false;
    }

}
