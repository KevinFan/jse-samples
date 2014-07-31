package com.kevinfan.sample.java8.lambda;

/**
 * Created by kevinjom on 14-7-31.
 */
public class IFunctionDemo {
    public static void main(String... args) {
        IFunctional functional = s -> {
            String result = s.toLowerCase();
            return result.trim();
        };

        System.out.println(functional.toLowerAndTrim("   Hello Functional interFace   "));
    }

}
