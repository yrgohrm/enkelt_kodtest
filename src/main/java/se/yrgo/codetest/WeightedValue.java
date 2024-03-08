package se.yrgo.codetest;

/**
 * A value with a weight.
 */
public record WeightedValue<T>(T value, int weight) {
    public WeightedValue {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }
    }
}
