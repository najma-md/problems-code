package problem.dynamicprog;

public class EditDistance {

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        int result = ed.minDistance(word1, word2);
        System.out.println("Edit distance between \"" + word1 + "\" and \"" + word2 + "\" is: " + result);
    }
    public int minDistance(String word1, String word2) {

        if (word1 == null && word2 != null) {
            return word2.length();
        }
        if (word2 == null && word1 != null) {
            return word1.length();
        }
        int[][] operationsCount = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < operationsCount[0].length; i++) {
            operationsCount[0][i] = operationsCount[0][i - 1] + 1;
        }
        for (int i = 1; i < operationsCount.length; i++) {
            operationsCount[i][0] = operationsCount[i - 1][0] + 1;
        }

        char currentWord1Char = 0;
        char currentWord2Char = 0;
        for (int i = 1; i < operationsCount.length; i++) {
            currentWord1Char = word1.charAt(i - 1);
            for (int j = 1; j < operationsCount[0].length; j++) {
                currentWord2Char = word2.charAt(j - 1);

                if (currentWord1Char == currentWord2Char) {
                    operationsCount[i][j] = operationsCount[i - 1][j - 1]; 
                }else {
                    operationsCount[i][j] = getMin(operationsCount[i - 1][j - 1], operationsCount[i][j - 1], operationsCount[i - 1][j]) + 1;
                }

            }
        }
        return operationsCount[word1.length()][word2.length()];
    }

    public int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
