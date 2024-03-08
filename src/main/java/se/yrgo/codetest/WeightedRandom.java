package se.yrgo.codetest;

import java.util.*;
import java.util.concurrent.*;

/**
 * A class that will generate a random value from a list of weighted values.
 *
 * I.e. for a list of weighted values:
 * <pre>{@code
 *      List.of(new WeightedValue<>("A", 1), 
 *              new WeightedValue<>("B", 2), 
 *              new WeightedValue<>("C", 3));}
 * </pre>
 * 
 * It will generate values, with A having a probability of 1/6, B 2/6 and C 3/6.
 * 
 * @param <T> The type of the values.
 *
 */
public class WeightedRandom<T> {

    public WeightedRandom(List<WeightedValue<T>> weightedValues) {
        
    }

    public T next() {
        return null;
    }
}
