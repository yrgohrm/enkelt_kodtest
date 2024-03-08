package se.yrgo.codetest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.*;

class WeightedRandomTest {

    @Test
    void testSingleWeight() {
        var weights = List.of(new WeightedValue<>("A", 1));
        var random = new WeightedRandom<>(weights);
        var expected = "A";
        var actual = random.next();
        assertEquals(expected, actual);
    }

    @Test
    void testMultipleWeights() {
        var weights = List.of(new WeightedValue<>("A", 1), 
                new WeightedValue<>("B", 2),
                new WeightedValue<>("C", 3));

        var random = new WeightedRandom<>(weights);

        var resultMap = generateRandom(random);

        assertTrue(isResonablyCorrect(resultMap, weights));
    }

    @Test
    void testHugeWeightsList() {
        var weights = new ArrayList<WeightedValue<Integer>>();
        for (int i = 1; i < 10000; i++) {
            weights.add(new WeightedValue<>(i, 1));
        }
        weights.add(new WeightedValue<>(10000, 10000));

        var random = new WeightedRandom<>(weights);

        var resultMap = generateRandom(random);

        assertTrue(isResonablyCorrect(resultMap, weights));
    }

    /**
     * Generate a map of the result of running the random generator lots of times.
     * 
     * @param <T>
     * @param random the weighted random generator
     * @return a map containing generated values and their count.
     */
    private static <T> HashMap<T, Integer> generateRandom(WeightedRandom<T> random) {
        var resultMap = new HashMap<T, Integer>();

        for (int i = 0; i < 1000000; i++) {
            var value = random.next();
            resultMap.merge(value, 1, Integer::sum);
        }

        return resultMap;
    }

    /**
     * Check if the distribution according to the weights are resonably correct.
     * 
     * @param <T>
     * @param resultMap result map from running the random generator lots of times.
     * @param weightedValues the weighted values used to create the random generator
     * @return true if the distribution is resonably correct.
     */
    private static <T> boolean isResonablyCorrect(Map<T, Integer> resultMap,
            List<WeightedValue<T>> weightedValues) {
        int expectedTotalCount = 0;
        for (var value : weightedValues) {
            expectedTotalCount += value.weight();
        }

        int resultTotalCount = 0;
        for (var value : resultMap.values()) {
            resultTotalCount += value;
        }

        for (var value : weightedValues) {
            int count = resultMap.getOrDefault(value.value(), 0);

            var expected = value.weight() / (expectedTotalCount + Double.MIN_VALUE);
            var result = count / (resultTotalCount + Double.MIN_VALUE);

            if (Math.abs(expected - result) > 0.005) {
                return false;
            }
        }

        return true;
    }
}
