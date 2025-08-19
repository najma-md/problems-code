package problem.dynamicprog;

public class HouseRobber {

    
    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        int maxAmount = robber.rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxAmount);
    }
   
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] amount = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            amount[i] = Math.max(i + 2 >= nums.length ? nums[i] : nums[i] + amount[i + 2],
                    i + 3 >= nums.length ? nums[i] : nums[i] + amount[i + 3]);
        }

        return Math.max(amount[0], amount[1]);
    }

}
