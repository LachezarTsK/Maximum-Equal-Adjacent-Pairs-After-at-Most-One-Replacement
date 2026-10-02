
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {

public:
    int maxEqualAdjacentPairs(vector<int>& input) {
        unordered_map<int, unordered_map<int, int>> differentValuePairsToFrequency;
        int originalNumberOfSameValuePairs = 0;
        int maxNumberOfDifferentValuePairs = 0;

        for (int i = 1; i < input.size(); ++i) {
            int minValue = min(input[i - 1], input[i]);
            int maxValue = max(input[i - 1], input[i]);

            if (minValue == maxValue) {
                ++originalNumberOfSameValuePairs;
                continue;
            }

            int newFrequency = ++differentValuePairsToFrequency[minValue][maxValue];
            maxNumberOfDifferentValuePairs = max(maxNumberOfDifferentValuePairs, newFrequency);
        }

        return originalNumberOfSameValuePairs + maxNumberOfDifferentValuePairs;
    }
};
