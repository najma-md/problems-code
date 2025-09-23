package problem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MinDelsProb {

   

    public static void main(String[] args) {
        MinDelsProb solver = new MinDelsProb();
        String s = "aabbccdd";
        int k = 2;
        int result = solver.minDeletion(s, k);
        System.out.println("Minimum deletions: " + result);
    }

    public int minDeletion(String s, int k) {
        char[] inputChars = s.toCharArray();
        int totalLength = inputChars.length;
        HashMap<Character, Integer> unsortedMap = new HashMap<Character, Integer>();
        for (char c : inputChars) {
            unsortedMap.put(c, unsortedMap.getOrDefault(c, 0) + 1);
        }

        // Sort the HashMap by value in descending order
        Map<Character, Integer> sortedMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Set<Character> keys = sortedMap.keySet();
        for (char c : keys) {
            totalLength -= sortedMap.get(c);
            k--;
            if (k == 0 || totalLength <= 0) {
                return Math.max(totalLength, 0);
            }
        }

        return Math.max(totalLength, 0);
    }

}
