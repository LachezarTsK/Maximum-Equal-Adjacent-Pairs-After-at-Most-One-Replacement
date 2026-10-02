
using System;
using System.Collections.Generic;

public class Solution
{
    public int MaxEqualAdjacentPairs(int[] input)
    {
        Dictionary<int, Dictionary<int, int>> differentValuePairsToFrequency = [];
        int originalNumberOfSameValuePairs = 0;
        int maxNumberOfDifferentValuePairs = 0;

        for (int i = 1; i < input.Length; ++i)
        {
            int minValue = Math.Min(input[i - 1], input[i]);
            int maxValue = Math.Max(input[i - 1], input[i]);

            if (minValue == maxValue)
            {
                ++originalNumberOfSameValuePairs;
                continue;
            }

            differentValuePairsToFrequency.TryAdd(minValue, new Dictionary<int, int>());
            int newFrequency = differentValuePairsToFrequency[minValue].GetValueOrDefault(maxValue, 0) + 1;

            differentValuePairsToFrequency[minValue][maxValue] = newFrequency;
            maxNumberOfDifferentValuePairs = Math.Max(maxNumberOfDifferentValuePairs, newFrequency);
        }

        return originalNumberOfSameValuePairs + maxNumberOfDifferentValuePairs;
    }
}
