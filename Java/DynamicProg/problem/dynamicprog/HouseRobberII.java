package problem.dynamicprog;

class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII robber = new HouseRobberII();
        int[] nums = {2, 3, 2};
        int result = robber.rob(nums);
        System.out.println("Max money robbed: " + result);
    }

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] amount = new int[nums.length];
        int max = 0;
        int i;
        for (i = nums.length - 1; i >= 1; i--) {
            amount[i] = Math.max(i + 2 >= nums.length ? nums[i] : nums[i] + amount[i + 2],
                    i + 3 >= nums.length ? nums[i] : nums[i] + amount[i + 3]);
        }

        max = Math.max(amount[1], nums.length - 1 >= 2 ? amount[2] : amount[1]);

        for (i = nums.length - 2; i >= 0; i--) {
            amount[i] = Math.max(i + 2 >= nums.length - 1 ? nums[i] : nums[i] + amount[i + 2],
                    i + 3 >= nums.length - 1 ? nums[i] : nums[i] + amount[i + 3]);
        }

        return Math.max(max, Math.max(amount[0], amount[1]));
    }
}
