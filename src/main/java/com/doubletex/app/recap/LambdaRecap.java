package com.doubletex.app.recap;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRecap {
    public static void basics() {
        Function<Integer, Integer> doubleNumber = (x) -> x * 2;
        Predicate<Integer> isPositive = (x) -> x >= 0; // Same as Function
    }

    public static void main(String[] args) {
//        processingOptionals();
    }
}
