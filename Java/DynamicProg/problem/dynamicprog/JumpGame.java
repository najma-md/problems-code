package problem.dynamicprog;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        boolean canJump = solution.canJump(nums);
        System.out.println("Can Jump: " + canJump);
    }

    public boolean canJump(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        int maxDistanceItCanTravel = nums[0];
        int currIndex = 0;
        int nextIndex = 0;

        while (currIndex < nums.length) {

            if (nums[currIndex] == 0) {
                return false;
            }
            for (int curPos = currIndex + 1; curPos <= currIndex + nums[currIndex]; curPos++) {
                maxDistanceItCanTravel = curPos + nums[curPos];
                if (maxDistanceItCanTravel >= nums.length - 1) {
                    return true;
                }
                if (curPos != maxDistanceItCanTravel && maxDistanceItCanTravel >= nums[nextIndex] + nextIndex) {
                    nextIndex = curPos;
                }
            }

            if (currIndex == nextIndex) {
                return false;
            }
            currIndex = nextIndex;

        }

        return false;

    }
}
