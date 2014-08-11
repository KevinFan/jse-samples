package com.kevinfan.sample.java8.date;

import java.time.Clock;

public class SimpleDemo {
    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());

        clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
    }
}
