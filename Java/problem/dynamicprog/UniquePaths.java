package problem.dynamicprog;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3;
        int n = 7;
        int result = solution.uniquePaths(m, n);
        System.out.println("Unique Paths: " + result);
    }

    public int uniquePaths(int m, int n) {
        int[][] arrayPaths = new int[m][n];

        int currPathsValm = 0;
        int currPathsValn = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    arrayPaths[i][j] = 1;
                    continue;
                }

                currPathsValm = i - 1 < 0 ? 0 : arrayPaths[i - 1][j];
                currPathsValn = j - 1 < 0 ? 0 : arrayPaths[i][j - 1];
                arrayPaths[i][j] = currPathsValm + currPathsValn;
            }
        }

        return arrayPaths[m - 1][n - 1];
    }

}
