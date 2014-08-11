package com.kevinfan.sample.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kevin Fan
 */
public class IntermediateOperations {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("dest", "goal", "DongJi", "YunNan", "Phi", "Tai");

        //filter
        strings.stream().filter(s -> s.startsWith("d")).forEach(System.out::println);

        println();

        //map, apply a function
        strings.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        println();
        //sorted
        strings.stream().sorted((String a, String b) -> a.toUpperCase().compareTo(b.toUpperCase()))
                .forEach(System.out::println);
    }

    public static void println() {
        System.out.println("\n*********************\n");
    }
}
