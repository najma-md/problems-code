package problem;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        
        int num1 = 81;
        int num2 = 153;
        int result = getGreatestCommonDivisor(num1, num2);
        System.out.println("Greatest common divisor: " + result);
    }


    public static int getGreatestCommonDivisor(int num1, int num2) {
        if (num1 < 10 || num2 < 10) {
            return -1;
        }

        int smallestNum = Math.min(num1, num2);
        while (smallestNum > 0) {
            if (num1 % smallestNum == 0 && num2 % smallestNum == 0) {
                return smallestNum;
            }
            smallestNum -= 1;

        }

        return -1;
    }
}
