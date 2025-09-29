package problem;

public class PowerofFour {

    public static void main(String[] args) {
        PowerofFour solver = new PowerofFour();
        int n = 16;
        boolean result = solver.isPowerOfFour(n);
        System.out.println("Is power of four: " + result);
    }

    public boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;

    }
}
