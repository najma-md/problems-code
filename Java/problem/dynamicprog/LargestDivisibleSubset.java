package problem.dynamicprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset lds = new LargestDivisibleSubset();
        int[] nums = {1, 2, 20, 22, 24, 36, 38, 66};
        List<Integer> result = lds.largestDivisibleSubset(nums);
        System.out.println(result);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> subsets = new HashMap<Integer, ArrayList<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);

        if (nums.length < 1) {
            return result;
        }

        int maxSubsetSize = 1;
        result.add(nums[0]);

        for (int i : nums) {

            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            newSubset.add(i);

            subsets.put(i, newSubset);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int currKey = nums[i];

            ArrayList<Integer> newSubsetList = new ArrayList<Integer>();
            int subsetSize = 0;

            for (int j = i + 1; j < nums.length; j++) {

                int numJ = nums[j];

                if (nums[j] % currKey == 0) {

                    ArrayList<Integer> subset = subsets.get(nums[j]);

                    ArrayList<Integer> newSubset = new ArrayList<Integer>();
                    newSubset.add(currKey);
                    newSubset.addAll(subset);

                    if (newSubset.size() > subsetSize) {
                        subsetSize = newSubset.size();

                        subsets.put(currKey, newSubset);
                        if (subsetSize > maxSubsetSize) {
                            maxSubsetSize = subsetSize;
                            result = newSubset;
                        }

                    }

                }

            }

        }

        return result;
    }

    /**
     * Optimized DP solution for Largest Divisible Subset.
     */
    public List<Integer> largestDivisibleSubsetDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i = prev[i]) {
            result.add(nums[i]);
            if (prev[i] == -1) {
                break;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
