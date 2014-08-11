package com.kevinfan.sample.java8.concurrent;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import com.kevinfan.sample.java8.util.TimeCoster;

public class Sorter {
    public static void main(String[] args) {
        final int[] arr = randomArr(10000000);
        final int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);

        System.out.println(TimeCoster.costInMillis(() -> Arrays.sort(arr)));
        System.out.println(TimeCoster.costInMillis(() -> Arrays.parallelSort(arr2)));

        for (int i = 0; i < arr2.length; i++) {
            assert arr[i] == arr2[i];
        }
        
        System.out.println("DONE...");
    }

    private static int[] randomArr(int size) {
        int[] arr = new int[size];
        Arrays.parallelSetAll(arr, i -> ThreadLocalRandom.current().nextInt());
        return arr;
    }
}
