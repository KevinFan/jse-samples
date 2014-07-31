package com.kevinfan.sample.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kevinjom on 14-7-31.
 */
public class LambdaWithStream {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(sumWithStream(numbers));

        printSquareForEachEle(numbers);

        int sum = squareSum(numbers);
        System.out.println(sum);
    }

    private static int squareSum(List<Integer> numbers) {
        int sum = numbers.stream().map(x -> x * x).reduce((x, y) -> x + y).get();
        return sum;
    }

    private static void printSquareForEachEle(List<Integer> numbers) {
        numbers.stream().map(x -> x * x).forEach(e -> System.out.println(e));
    }

    private static int sumWithStream(List<Integer> numbers) {
        int sum = numbers.stream().reduce((x, y) -> x + y).get();
        return sum;
    }
}
