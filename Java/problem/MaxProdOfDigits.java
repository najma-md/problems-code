package problem;

public class MaxProdOfDigits {

    public static void main(String[] args) {
        MaxProdOfDigits solver = new MaxProdOfDigits();
        int n = 2736;
        int result = solver.maxProduct(n);
        System.out.println("Maximum product of two digits: " + result);
    }

    public int maxProduct(int n) {
        if (n < 10) {
            return 0;
        }

        int max1 = 0;
        int max2 = 0;

        while (n > 0) {
            int digit = n % 10;

            n = n / 10;

            if (digit > max1 && digit > max2) {
                if (max1 > max2) {
                    max2 = digit; 
                }else {
                    max1 = digit;
                }
            } else if (digit > max1) {
                max1 = digit; 
            }else if (digit > max2) {
                max2 = digit;
            }
        }

        return max1 * max2;

    }
}
