package se.yrgo.codetest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var weights = List.of(new WeightedValue<>("A", 1), 
                new WeightedValue<>("B", 2),
                new WeightedValue<>("C", 3));

        var random = new WeightedRandom<>(weights);

        System.out.println("Random value: " + random.next());
    }
}
