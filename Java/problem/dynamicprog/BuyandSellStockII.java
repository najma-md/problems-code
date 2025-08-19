package problem.dynamicprog;

public class BuyandSellStockII {

    public static void main(String[] args) {
        BuyandSellStockII solution = new BuyandSellStockII();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = solution.maxProfit(prices);
        System.out.println("Max Profit: " + profit);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int maxProfit = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }

}
