package problem;

import java.util.List;

public class HourGlassSum {

    /*-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5 */

    public static void main(String[] args) {
        System.out.println("Hour Glass Sum");
        List<List<Integer>> arr = List.of(
                List.of(-1, -1, 0, -9, -2, -2),
                List.of(-2, -1, -6, -8, -2, -5),
                List.of(-1, -1, -1, -2, -3, -4),
                List.of(-1, -9, -2, -4, -4, -5),
                List.of(-7, -3, -3, -2, -9, -9),
                List.of(-1, -3, -1, -2, -4, -5)
        );
        int result = hourglassSum(arr);
        System.out.println("Result: " + result);
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here

        int sum = Integer.MIN_VALUE;

        int[][] arrInput = new int[6][6];
        int row = 0;
        int col = 0;
        for (List<Integer> i : arr) {
            for (int val : i) {
                arrInput[row][col] = val;
                col += 1;
            }
            row += 1;
              col=0;
        

        }

        int i = 0;
        int j = 0;

        for (i = 0; i <= arrInput.length - 3; i++) {
            for (j = 0; j <= arrInput[0].length - 3; j++) {
                sum = Math.max(sum, getSum(i, j, i + 2, j + 2, arrInput));
            }
        }

        return sum;

    }

    public static int getSum(int row, int col, int maxRow, int maxCol, int[][] arrInput) {
        int sumRet = 0;
        for (int i = row; i <= maxRow; i++) {
            for (int j = col; j <= maxCol; j++) {
                sumRet += arrInput[i][j];
            }
        }

        sumRet = sumRet - arrInput[row + 1][col] - arrInput[row + 1][maxCol];
        return sumRet;
    }

}
