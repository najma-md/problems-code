package problem.dynamicprog;

public class IntegerBreak {

    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        int n = 10; // Example input
        int result = ib.integerBreak(n);
        System.out.println("Maximum product for " + n + " is: " + result);
    }

    public int integerBreak(int n) {

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                int diff = i - j;
                int product = diff * (dp[j] > j ? dp[j] : j);
                max = Math.max(max, product);
            }
            dp[i] = max;
        }

        return dp[n];

    }

}
