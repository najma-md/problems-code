package problem.dynamicprog;

public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();
        System.err.println(ms.maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}}));
    }

    public int maximalSquare(char[][] matrix) {

        int maxArea = 0;
        int min = 0;
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    newMatrix[i][j] = matrix[i][j] - '0';
                } else {
                    min = Math.min(Math.min(newMatrix[i - 1][j], newMatrix[i][j - 1]), newMatrix[i - 1][j - 1]);
                    newMatrix[i][j] = (min + 1);
                }
                maxArea = Math.max(maxArea, newMatrix[i][j]);
            }
        }

        return maxArea * maxArea;
    }
}
