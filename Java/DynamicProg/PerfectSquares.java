
import java.util.ArrayList;
import java.util.HashMap;

class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(13));

    }

    HashMap<Integer, Integer> calculatedPfVal = new HashMap();

    private int calculatePerfectSquares(int n, int lns, ArrayList<Integer> perfectSquares) {
        if (n == 0) {
            return 0;
        }
        if (calculatedPfVal.containsKey(n)) {
            return calculatedPfVal.get(n);
        }

        int leastNoOfSqrs = Integer.MAX_VALUE;
        for (int i = 0; i < perfectSquares.size() && perfectSquares.get(i) <= n; i++) {
            int pf = perfectSquares.get(i);
            int returnedPf = calculatePerfectSquares(n - pf, lns + 1, perfectSquares) + 1;

            // calculatePerfectSquares(n-pf,lns+1,perfectSquares);
            leastNoOfSqrs = Math.min(leastNoOfSqrs, returnedPf);
        }

        calculatedPfVal.put(n, leastNoOfSqrs);
        return leastNoOfSqrs;

    }

    private ArrayList<Integer> getPerfectSquares(int n) {
        ArrayList pf = new ArrayList<Integer>();
        int i = 1;

        while (i * i <= n) {
            pf.add(i * i);
            i += 1;
        }
        return pf;
    }

    public int numSquares(int n) {

        if (n == 0) {
            return 0;
        }

        ArrayList<Integer> ps = getPerfectSquares(n);
        return calculatePerfectSquares(n, 0, ps);
    }
}
