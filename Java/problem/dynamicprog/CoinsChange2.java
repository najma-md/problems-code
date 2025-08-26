package problem.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class CoinsChange2 {

    public static void main(String[] args) {
        List<Long> coins = new ArrayList<Long>();
        coins.add((long) 2);
        coins.add((long) 5);
        coins.add((long) 3);
        coins.add((long) 6);
        int amount = 10;
        long ways = getWays(amount, coins);
        System.out.println("Number of ways to make change: " + ways);
    }

    public static long getWays(int n, List<Long> c) {
        // Write your code here
        if (n == 0 || c.size() == 0) {
            return 0;
        }

        long[][] waysCount = new long[c.size() + 1][n + 1];
        for (int i = 0; i < waysCount.length; i++) {
            waysCount[i][0] = 1;
        }

        for (int i = 1; i < waysCount.length; i++) {
            long cVal = c.get(i - 1);
            for (int j = 1; j < waysCount[i].length; j++) {
                if (j < cVal) {
                    waysCount[i][j] = waysCount[i - 1][j];
                } else {
                    int diff = (int) (j - c.get(i - 1));
                    waysCount[i][j] = waysCount[i - 1][j] + waysCount[i][diff];
                }

            }
        }

        return waysCount[c.size()][n];

    }
}
