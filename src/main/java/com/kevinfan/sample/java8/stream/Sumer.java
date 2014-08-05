package com.kevinfan.sample.java8.stream;

import java.util.Arrays;
import java.util.List;

public class Sumer {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 6, 9, 10, 11);

        System.out.println(sumOddNumbers(numbers));

        System.out.println(sumOddNunbersWithStream(numbers));
    }

    public static int sumOddNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            if (isOdd(num)) {
                sum += num;
            }
        }

        return sum;
    }

    public static int sumOddNunbersWithStream(List<Integer> numbers) {
        return numbers.stream().filter(Sumer::isOdd).mapToInt(n -> n).sum();
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
