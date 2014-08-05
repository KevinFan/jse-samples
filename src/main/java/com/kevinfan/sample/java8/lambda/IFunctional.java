package com.kevinfan.sample.java8.lambda;

import java.util.function.Supplier;

/**
 * Created by kevinjom on 14-7-30.
 */
@FunctionalInterface
public interface IFunctional {
    String toLowerAndTrim(String str);

    default void justForTestDefaultMethod() {
        System.out.println("this is a default impl, subclass can override this");
    }

    static IFunctional create(Supplier<IFunctional> supplier) {
        return supplier.get();
    }
}
