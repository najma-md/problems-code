package problem.dynamicprog;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.err.println(mps.maxProduct(nums)); // Output: 6
        nums = new int[]{-2, 0, -1};
        System.err.println(mps.maxProduct(nums)); // Output: 0 
    }

    public int maxProduct(int[] nums) {

        int lprod = 1;
        int rprod = 1;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            rprod *= nums[i];
            max = Math.max(max, rprod);
            if (rprod == 0) {
                rprod = 1;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            lprod *= nums[i];
            max = Math.max(max, lprod);
            if (lprod == 0) {
                lprod = 1;
            }
        }

        return max;

    }
}
