package problem.dynamicprog;

public class MinCuttingCostProb {

    public static void main(String[] args) {
        MinCuttingCostProb solver = new MinCuttingCostProb();
        int n = 8, m = 5, k = 3;
        long result = solver.minCuttingCost(n, m, k);
        System.out.println("Minimum cutting cost: " + result);
    }

    public long minCuttingCost(int n, int m, int k) {
        if (n <= k && m <= k) {
            return 0;
        }
        long cost;

        if (m > n) {
            cost = (long) (m - k) * k;
        } else {
            cost = (long) (n - k) * k;
        }

        return cost;
    }
}
