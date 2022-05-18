package com.doubletex.app.recap;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class GenericsRecap {

    public static Object debugSimple(Object object) {
        System.out.println(object);
        return object;
    }

    public static <T> T debugSure(T object) {
        System.out.println(object);
        return object;
    }

    @AllArgsConstructor
    @ToString
    public static class Pair<Left, Right> {
        public final Left left;
        public final Right right;
    }

    public static <L, R> List<Pair<L, R>> makePairs(List<L> leftList, List<R> rightList) {
        if(leftList.size() != rightList.size()) {
            throw new IllegalArgumentException("Sizes of lists must be equal");
        }

        List<Pair<L, R>> pairedList = new LinkedList<>();
        Iterator<L> lefts = leftList.iterator();
        Iterator<R> rights = rightList.iterator();

        while(lefts.hasNext()) {
            pairedList.add(new Pair<>(lefts.next(), rights.next()));
        }

        return pairedList;
    }

    public static Pair<Long, Double> divide(double numerator, double denominator) {
        return new Pair<>((long) (numerator / denominator), numerator % denominator);
    }

    public static void debugPreview() {
        String message = "Hello world!";

        Object sameMessage = debugSimple(message);
//        String sameMessage = (String) debugSimple(message);
//        String sameMessage = debugSure(message);

        String differentMessage = message.substring(3).toUpperCase();
    }

    public static void pairPreview() {
        Pair<String, String> firstLastName = new Pair<>("Razvan", "Smeu");
        Pair<Long, Double> resultAndRemained = divide(23, 7);

        System.out.println(firstLastName);
        System.out.println(resultAndRemained);
    }

    public static void zipPreview() {
        List<String> names = List.of("Alex", "Razvan", "Ash");
        List<Integer> ages = List.of(21, 39, 10);

        List<Pair<String, Integer>> namesAndAges = makePairs(names, ages);

        System.out.println(namesAndAges);
    }

    public static void main(String[] args) {
        zipPreview();
    }
}
