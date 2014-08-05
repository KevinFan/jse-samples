package com.kevinfan.sample.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class NamePrinter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("kevinfan", "kevinjom", "pack");

        printAllNames(names);

        printNamesStartsWith(names, "k");
    }

    private static void printAllNames(List<String> names) {
        names.forEach(name -> System.out.println(name));
    }

    private static void printNamesStartsWith(List<String> names, String startStr) {
        names.forEach(name -> {
            if (name.startsWith(startStr)) {
                System.out.println(name);
            }
        });
    }

}
