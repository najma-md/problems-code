
import java.util.TreeSet;

public class UglyNumberII {

    public static void main(String[] args) {

        UglyNumberII un2 = new UglyNumberII();
        System.out.println(un2.nthUglyNumber(10));

    }

    private int uglyNumberIdentify(long numb, int requiredN, int currN, TreeSet<Long> uglyNums) {
        if (requiredN == currN) {
            return (int) numb;
        }

        uglyNums.add(numb * 2);
        uglyNums.add(numb * 3);
        uglyNums.add(numb * 5);

        long nextUglyNumber = !uglyNums.isEmpty() ? uglyNums.pollFirst() : 1;

        return uglyNumberIdentify(nextUglyNumber, requiredN, currN + 1, uglyNums);

    }

    public int nthUglyNumber(int n) {

        if (n == 0) {
            return 0;
        }

        TreeSet<Long> uglyNums = new TreeSet<Long>();
        return uglyNumberIdentify(Long.valueOf(1), n, 1, uglyNums);
    }

}
