package problem.dynamicprog;

public class InterleavingString {

    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean result = solution.isInterleave(s1, s2, s3);
        System.out.println("Is Interleaving: " + result);
    }

    int record[][] = new int[101][101];

    public boolean compareChar(int s1Index, int s2Index, String s1, String s2, String s3) {
        if (s1Index + s2Index == s3.length()) {
            return true;
        }

        if (record[s1Index][s2Index] == 2) {
            return true; 
        }else if (record[s1Index][s2Index] == 1) {
            return false;
        }

        char s3Char = s3.charAt(s1Index + s2Index);

        if (s1Index < s1.length() && s1.charAt(s1Index) == s3Char) {

            record[s1Index][s2Index] = compareChar(s1Index + 1, s2Index, s1, s2, s3) ? 2 : 1;
            if (record[s1Index][s2Index] == 2) {
                return true;
            }
        }

        if (s2Index < s2.length() && s2.charAt(s2Index) == s3Char) {
            record[s1Index][s2Index] = compareChar(s1Index, s2Index + 1, s1, s2, s3) ? 2 : 1;
            if (record[s1Index][s2Index] == 2) {
                return true;
            }
        }

        return false;

    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return compareChar(0, 0, s1, s2, s3);
    }

}
