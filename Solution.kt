
import kotlin.math.min
import kotlin.math.max

class Solution {
    
    fun maxEqualAdjacentPairs(input: IntArray): Int {
        val differentValuePairsToFrequency = mutableMapOf<Int, MutableMap<Int, Int>>()
        var originalNumberOfSameValuePairs = 0
        var maxNumberOfDifferentValuePairs = 0

        for (i in 1..<input.size) {
            val minValue = min(input[i - 1], input[i])
            val maxValue = max(input[i - 1], input[i])

            if (minValue == maxValue) {
                ++originalNumberOfSameValuePairs
                continue
            }

            differentValuePairsToFrequency.putIfAbsent(minValue, mutableMapOf<Int, Int>())
            val newFrequency = differentValuePairsToFrequency[minValue]!!.getOrDefault(maxValue, 0) + 1

            differentValuePairsToFrequency[minValue]!!.put(maxValue, newFrequency)
            maxNumberOfDifferentValuePairs = max(maxNumberOfDifferentValuePairs, newFrequency)
        }

        return originalNumberOfSameValuePairs + maxNumberOfDifferentValuePairs
    }
}
