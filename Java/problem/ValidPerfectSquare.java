package problem;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        ValidPerfectSquare solver = new ValidPerfectSquare();
        int num = 16;
        boolean result = solver.isPerfectSquare(num);
        System.out.println("Is perfect square: " + result);
    }

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }

        int l = 1;
        int r = num;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            long prod = (long) mid * mid;
            if (prod == num) {
                return true;
            }
            if (prod > num) {
                r = mid - 1;
            }
            if (prod < num) {
                l = mid + 1;
            }
        }

        return false;

    }
}
