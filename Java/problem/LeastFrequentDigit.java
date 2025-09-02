package problem;

public class LeastFrequentDigit {

    public static void main(String[] args) {
        LeastFrequentDigit lfd = new LeastFrequentDigit();
        int n = 2234444;
        int result = lfd.getLeastFrequentDigit(n);
        System.out.println(result);
    }

    public int getLeastFrequentDigit(int n) {

        int[] counts = new int[10];

        int digit = 0;
        int leastCountNumb = Integer.MAX_VALUE;
        int leastRepeatedVal = 0;

        while (n > 0) {
            digit = n % 10;
            counts[digit] += 1;
            n = n / 10;
        }

        for (int i = 0; i < 10; i++) {
            int newCount = counts[i];
            if (newCount > 0 && leastCountNumb > newCount) {
                leastCountNumb = newCount;
                leastRepeatedVal = i;
            }
        }

        return leastRepeatedVal;
    }
}
