package problem;

public class NumberPalindrome {

    public static void main(String[] args) {
        NumberPalindrome solver = new NumberPalindrome();
        int x = -222;
        boolean result = solver.isPalindrome(x);
        System.out.println("Is palindrome: " + result);
    }

    public boolean isPalindrome(int x) {

        int input = Math.abs(x);
        int palindromeNum = 0;

        while (input > 0) {
            palindromeNum += input % 10;
            input /= 10;
            palindromeNum *= 10;
        }
        palindromeNum /= 10;

        return palindromeNum == Math.abs(x);

    }

}
