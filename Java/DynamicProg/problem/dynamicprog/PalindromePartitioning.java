package problem.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> result = pp.partition(s);
        System.err.println(result);
    }
    List<List<String>> output = new ArrayList();

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }

    public void navigatePath(String s, List<String> combintions) {

        if (s == null || s.length() == 0) {
            List<String> newPartition = new ArrayList();
            newPartition.addAll(combintions);
            output.add(newPartition);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String currSubStr = s.substring(0, i + 1);
            if (isPalindrome(currSubStr)) {
                combintions.add(currSubStr);
                navigatePath(s.substring(i + 1), combintions);
                combintions.remove(combintions.size() - 1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        int start = 0;

        List<String> combintions = new ArrayList();

        navigatePath(s, combintions);

        return output;
    }

}
