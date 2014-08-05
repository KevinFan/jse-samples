package com.kevinfan.sample.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Kevin Fan
 */
public class StreamCreator {
    public static void main(String[] args) {
        ofElements();

        arraysStreamUtil();

        strCharsMethod();

        generateWithSupplier();

    }

    private static void generateWithSupplier() {
        Stream.generate(() -> {
            return new int[] { 1, 2, 5 };
        });
    }

    private static void strCharsMethod() {
        String str = " hello stream api";
        IntStream intStream = str.chars();
        double avg = intStream.average().getAsDouble();
        System.out.println(avg);
    }

    private static void arraysStreamUtil() {
        IntStream intStream = Arrays.stream(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(intStream.sum());
    }

    private static void ofElements() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        long cnt = stream.count();
        System.out.println(cnt);
    }
}
