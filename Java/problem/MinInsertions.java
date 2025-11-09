package problem;

public class MinInsertions {

    public static void main(String[] args) {
        MinInsertions solution = new MinInsertions();
        String s = "aa";
        int result = solution.inputString(s);
        System.out.println("Minimum insertions needed: " + result);
    }

    public int inputString(String s) {

        String pattern = "abc";

        int patternCounter = 0;
        int inputCounter = 0;

        int insertion = 0;
        while (inputCounter < s.length()) {
            if (s.charAt(inputCounter) == pattern.charAt(patternCounter)) {
                inputCounter += 1;
            } else {
                insertion += 1;

            }
            patternCounter += 1;

            if (patternCounter == pattern.length() && inputCounter < s.length()) {
                patternCounter = 0;
            }
        }
        return insertion + (pattern.length() - patternCounter);
    }
}
