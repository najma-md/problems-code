package problem;

public class RangeAddition2 {

    public static void main(String[] args) {
        RangeAddition2 solver = new RangeAddition2();
        int m = 3;
        int n = 3;
        int[][] ops = { { 2, 2 }, { 3, 3 } };
        int result = solver.maxCount(m, n, ops);
        System.out.println("Maximum count of elements: " + result);
    }

    public int maxCount(int m, int n, int[][] ops) {

        if (ops.length == 0) {
            return m * n;
        }

        int minR = m;
        int minC = n;

        for (int i = 0; i < ops.length; i++) {
            minR = Math.min(minR, ops[i][0]);
            minC = Math.min(minC, ops[i][1]);
        }

        return minR * minC;

    }

}
