package problem;

import java.util.HashMap;
import java.util.Set;

public class CheckPrimeFreq {

    public static void main(String[] args) {
        CheckPrimeFreq solver = new CheckPrimeFreq();
        int[] nums = {4, 3, 2, 4, 1, 3, 2, 4};
        boolean result = solver.checkPrimeFrequency(nums);
        System.out.println("Contains prime frequency: " + result);
    }


    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> countRepeats = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            countRepeats.put(nums[i], countRepeats.getOrDefault(nums[i], 0) + 1);
        }

        Set<Integer> keys = countRepeats.keySet();
        for (int key : keys) {
            int count = countRepeats.get(key);
            if (isPrime(count)) {
                return true;
            }
        }

        return false;

    }

    private boolean isPrime(int val) {
        if (val <= 1) {
            return false;
        }

        for (int i = 2; i < val; i++) {
            if (val % i == 0) {
                return false;
            }
        }

        return true;
    }
}
