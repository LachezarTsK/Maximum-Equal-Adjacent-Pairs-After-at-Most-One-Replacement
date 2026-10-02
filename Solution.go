
package main

func maxEqualAdjacentPairs(input []int) int {
    differentValuePairsToFrequency := map[int]map[int]int{}
    originalNumberOfSameValuePairs := 0
    maxNumberOfDifferentValuePairs := 0

    for i := 1; i < len(input); i++ {
        minValue := min(input[i - 1], input[i])
        maxValue := max(input[i - 1], input[i])

        if minValue == maxValue {
            originalNumberOfSameValuePairs++
            continue
        }

        putIfAbsent(differentValuePairsToFrequency, minValue, map[int]int{})
        newFrequency := getOrDefault(differentValuePairsToFrequency[minValue], maxValue, 0) + 1

        differentValuePairsToFrequency[minValue][maxValue] = newFrequency
        maxNumberOfDifferentValuePairs = max(maxNumberOfDifferentValuePairs, newFrequency)
}

return originalNumberOfSameValuePairs + maxNumberOfDifferentValuePairs
}

func getOrDefault[Key comparable, Value any](toCheck map[Key]Value, key Key, defaultValue Value) Value {
    if value, has := toCheck[key]; has {
        return value
    }
    return defaultValue
}

func containsKey[Key comparable, Value any](mapToCheck map[Key]Value, key Key) bool {
    var has bool
    _, has = mapToCheck[key]
    return has
}

func putIfAbsent[Key comparable, Value any](mapToCheck map[Key]Value, key Key, value Value) {
    if !containsKey(mapToCheck, key) {
        mapToCheck[key] = value
    }
}
