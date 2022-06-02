package com.doubletex.app.recap;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
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
        Pair<Long, Double> resultAndRemainder = divide(23, 7);

        System.out.println(firstLastName);
        System.out.println(resultAndRemainder);
    }


    public static void zipPreview() {
        List<String> names = List.of("Alex", "Razvan", "Ash");
        List<Integer> ages = List.of(21, 39, 10);

        List<  Pair<String, Integer>  > namesAndAges = makePairs(names, ages);

        System.out.println(namesAndAges);
    }

    static class Animal {
        public void beCute() {}
    }
    static class Dog extends Animal {
        public void bark() {}
    }
    static class Cat extends Animal {
        public void meow() {}
    }
    static class Hamster extends Animal {
        public void fillCheeks() {}
    }

    public static void listPreview() {
        List<Animal> animals = new LinkedList<>();
        animals.add(new Cat());
        animals.add(new Animal());
        animals.get(0).beCute();
//        animals.get(0).meow(); //!!

        List<Hamster> hamsters = new LinkedList<>();
        hamsters.add(new Hamster());
        hamsters.add(new Hamster());
//        hamsters.add(new Dog());
        hamsters.get(0).fillCheeks();

        List<Animal> animals2 = null; //hamsters;
        animals2.add(new Dog());
        List<? extends Animal> animals3 = hamsters;
//        animals3.add(new Hamster());
//        animals3.add(new Dog());
    }

    public static List<Dog> dogServiceGet() {
        return List.of(new Dog());
    }

    public static List<Cat> catServiceGet() {
        return List.of(new Cat());
    }

    public static List<Hamster> hamsterServiceGet() {
        return List.of(new Hamster());
    }

    public static List<? extends Animal> getMyAPIAnimals(String type) {
        switch(type) {
            case "DOG": return dogServiceGet();
            case "CAT": return catServiceGet();
            case "HAMSTER": return hamsterServiceGet();
            default: return List.of();
        }
    }

    public static void main(String[] args) {

        zipPreview();
    }
}
