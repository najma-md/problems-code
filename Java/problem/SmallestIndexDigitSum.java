package problem;

public class SmallestIndexDigitSum {
    // Add methods and fields as needed

    public static void main(String[] args) {
        SmallestIndexDigitSum solver = new SmallestIndexDigitSum();
        int[] nums = {10, 23, 11, 5, 7};
        int result = solver.smallestIndex(nums);
        System.out.println("Smallest index: " + result);
    }

    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (digitSumCheck(nums[i], i)) {
                return i;
            }
        }

        return -1;
    }

    boolean digitSumCheck(int num, int index) {
        int sum = 0;
        while (num > 0) {
            if (sum > index) {
                return false;
            }
            sum += num % 10;
            num = num / 10;
        }
        return sum == index;
    }
}
