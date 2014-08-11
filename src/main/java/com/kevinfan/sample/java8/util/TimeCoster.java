package com.kevinfan.sample.java8.util;

public abstract class TimeCoster {
    public static long costInMillis(Action action) {
        long start = System.currentTimeMillis();

        action.execute();

        return System.currentTimeMillis() - start;
    }
}
