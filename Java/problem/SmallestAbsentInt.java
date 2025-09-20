package problem;

public class SmallestAbsentInt {

    public static void main(String[] args) {
        SmallestAbsentInt solver = new SmallestAbsentInt();
        int[] nums = {0, 1, 2, 4, 5};
        int result = solver.smallestAbsent(nums);
        System.out.println("Smallest absent integer: " + result);
    }

    public int smallestAbsent(int[] nums) {
        int[] temp = new int[101];
        int maxNo = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                temp[nums[i]] = 1;
            }
            maxNo = Math.max(maxNo, nums[i]);
            sum += nums[i];
        }

        int roundInt = sum < 0 ? 0 : sum / nums.length;
        roundInt += 1;
        while (roundInt < temp.length && temp[roundInt] == 1) {
            roundInt += 1;
        }

        return roundInt;

    }

}
