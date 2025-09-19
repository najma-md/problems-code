package problem;

import java.util.TreeSet;

public class MaxKDistinctProb {

    public static void main(String[] args) {
        MaxKDistinctProb solver = new MaxKDistinctProb();
        int[] nums = {5, 3, 9, 1, 5, 7, 9};
        int k = 3;
        int[] result = solver.maxKDistinct(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] maxKDistinct(int[] nums, int k) {

        TreeSet<Integer> ipNum = new TreeSet<>();

        for (int i : nums) {
            ipNum.add(i);
        }

        int[] output = new int[k < ipNum.size() ? k : ipNum.size()];
        int index = 0;

        while (k > 0 && !ipNum.isEmpty()) {
            output[index++] = ipNum.pollLast();
            k -= 1;
        }

        return output;
    }

}
