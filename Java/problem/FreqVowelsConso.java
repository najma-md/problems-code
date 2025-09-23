package problem;

public class FreqVowelsConso {

    public static void main(String[] args) {
        FreqVowelsConso solver = new FreqVowelsConso();
        String s = "abciiidef";
        int result = solver.maxFreqSum(s);
        System.out.println("Max frequency sum: " + result);
    }

    
    public int maxFreqSum(String s) {
        if (s.equals(null)) {
            return 0;
        }

        char[] letters = s.toCharArray();
        int[] freq = new int[26];

        int maxVowels = 0;
        int maxConsonents = 0;
        for (int i = 0; i < letters.length; i++) {

            int currChar = letters[i] - 'a';
            freq[currChar] += 1;

            switch (letters[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    maxVowels = Math.max(maxVowels, freq[currChar]);
                    break;
                default:
                    maxConsonents = Math.max(maxConsonents, freq[currChar]);
                    break;
            }
        }
        return maxVowels + maxConsonents;
    }

}
