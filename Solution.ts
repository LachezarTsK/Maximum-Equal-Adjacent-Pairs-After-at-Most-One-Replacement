
function maxEqualAdjacentPairs(input: number[]): number {
    const differentValuePairsToFrequency = new CustomizedMap<number, CustomizedMap<number, number>>();
    let originalNumberOfSameValuePairs = 0;
    let maxNumberOfDifferentValuePairs = 0;

    for (let i = 1; i < input.length; ++i) {
        const minValue = Math.min(input[i - 1], input[i]);
        const maxValue = Math.max(input[i - 1], input[i]);

        if (minValue === maxValue) {
            ++originalNumberOfSameValuePairs;
            continue;
        }

        differentValuePairsToFrequency.putIfAbsent(minValue, new CustomizedMap());
        const newFrequency = differentValuePairsToFrequency.get(minValue).getOrDefault(maxValue, 0) + 1;

        differentValuePairsToFrequency.get(minValue).set(maxValue, newFrequency);
        maxNumberOfDifferentValuePairs = Math.max(maxNumberOfDifferentValuePairs, newFrequency);
    }

    return originalNumberOfSameValuePairs + maxNumberOfDifferentValuePairs;
};

class CustomizedMap<Key, Value> extends Map {

    putIfAbsent(key: Key, value: Value) {
        if (!this.has(key)) {
            this.set(key, value);
        }
    }

    getOrDefault(key: Key, defaultValue: Value): Value {
        if (!this.has(key)) {
            return defaultValue;
        }
        return this.get(key);
    }
}
