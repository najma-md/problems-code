package problem.dynamicprog;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int result = solution.minPathSum(grid);
        System.out.println("Minimum Path Sum: " + result);
    }

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }
                grid[row][col] += Math.min((row - 1 < 0 ? Integer.MAX_VALUE : grid[row - 1][col]), (col - 1 < 0 ? Integer.MAX_VALUE : grid[row][col - 1]));
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
