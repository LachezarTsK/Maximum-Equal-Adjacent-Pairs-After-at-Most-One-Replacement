
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxEqualAdjacentPairs(int[] input) {
        Map<Integer, Map<Integer, Integer>> differentValuePairsToFrequency = new HashMap<>();
        int originalNumberOfSameValuePairs = 0;
        int maxNumberOfDifferentValuePairs = 0;

        for (int i = 1; i < input.length; ++i) {
            int minValue = Math.min(input[i - 1], input[i]);
            int maxValue = Math.max(input[i - 1], input[i]);

            if (minValue == maxValue) {
                ++originalNumberOfSameValuePairs;
                continue;
            }

            differentValuePairsToFrequency.putIfAbsent(minValue, new HashMap<>());
            int newFrequency = differentValuePairsToFrequency.get(minValue).getOrDefault(maxValue, 0) + 1;

            differentValuePairsToFrequency.get(minValue).put(maxValue, newFrequency);
            maxNumberOfDifferentValuePairs = Math.max(maxNumberOfDifferentValuePairs, newFrequency);
        }

        return originalNumberOfSameValuePairs + maxNumberOfDifferentValuePairs;
    }
}
