package problem.dynamicprog;

import java.util.TreeSet;

public class SuperUglyNumber {

    public static void main(String[] args) {
        SuperUglyNumber solver = new SuperUglyNumber();
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int result = solver.nthSuperUglyNumber(n, primes);
        System.out.println("The " + n + "th super ugly number is: " + result);
    }

   public int nthSuperUglyNumber(int n, int[] primes) {

        if (n == 0 || primes.length == 0) {
            return 0;
        }

        TreeSet<Double> uglyNumbers = new TreeSet();
        uglyNumbers.add((double) 1);

        int noOfUglyNumbers = 0;
        double currUglyNumber = primes[0];

        while (noOfUglyNumbers < n) {
            currUglyNumber = uglyNumbers.pollFirst();
            noOfUglyNumbers += 1;
            calSuperUglyNumbers(currUglyNumber, primes, n, uglyNumbers);

        }

        return (int) currUglyNumber;

    }

    private void calSuperUglyNumbers(double currUglyNumber, int[] primes, int n, TreeSet<Double> uglyNumbers) {
        for (int i : primes) {
            if (uglyNumbers.size() > n) {
                if (currUglyNumber * i < uglyNumbers.last()) {
                    uglyNumbers.pollLast();
                    uglyNumbers.add(currUglyNumber * i);
                }
            } else {
                uglyNumbers.add(currUglyNumber * i);
            }
        }

    }

}
