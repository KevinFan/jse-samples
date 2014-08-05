package com.kevinfan.sample.java8.lambda;

/**
 * @author Kevin Fan
 */
public class IFunctionDemo {
    public static void main(String... args) {
        /*
         * Each lambda expression can be implicitly assigned to one of the
         * interface called Functional interface.
         */
        IFunctional functional = s -> {
            return s.toLowerCase().trim();
        };

        System.out.println(functional.toLowerAndTrim("   Hello Functional interFace   "));

        /*
         * Method reference can also be assigned to Functional interface
         */
        IFunctional methodRefFunctional = IFunctionDemo::lowerAndTrim;
        System.out.println(methodRefFunctional.toLowerAndTrim(" test meTHod Ref"));

    }

    private static String lowerAndTrim(String str) {
        return str.toLowerCase().trim();
    }
}
