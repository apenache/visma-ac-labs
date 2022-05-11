package com.doubletex.app.recap;

import org.hibernate.annotations.Comment;

import java.util.Optional;

public class OptionalRecap {
    public static Optional<String> findQuestion(String... strings) {
        for(String string : strings) {
            if(string.endsWith("?")) {
                return Optional.of(string);
            }
        }
        return Optional.empty();
    }

    public static void createOptionals() {
        Optional<String> optional1 = Optional.of("Jenkins");
        Optional<String> optional2 = Optional.empty();
        Optional<String> optional3 = Optional.ofNullable("Abraham");
        Optional<String> optional4 = Optional.ofNullable(null);

        System.out.println(optional1);
        System.out.println(optional2);
        System.out.println(optional3);
        System.out.println(optional4);
    }

    public static void useCases() {
        Optional<String> foundQuestion1 = findQuestion(
            "Hello!",
            "How are you?",
            "I'm fine.",
            "How about you?",
            "Same."
        );
        System.out.println(foundQuestion1);

        Optional<String> foundQuestion2 = findQuestion(
            "Roses are red,",
            "Violets are blue,",
            "Unexpected token",
            "On line 32"
        );
        System.out.println(foundQuestion2);
    }

    public static void processingOptionals() {
//        Optional<String> foundQuestion = Optional.empty();
        Optional<String> foundQuestion = Optional.of("How are you?");

        if(foundQuestion.isPresent()) {
            System.out.println("Question found!");
        } else {
            System.err.println("Could not find any questions.");
        }

        foundQuestion.ifPresentOrElse(
            (actualString ) -> System.out.println("Question found!"),
            (/* NOTHING */) -> System.err.println("Could not find any questions.")
        );

        foundQuestion.ifPresent((actualString) -> {
            System.out.println("OK: " + actualString);
        });
    }

    public static void main(String[] args) {
        processingOptionals();
    }
}
