package com.thoughtworks.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Number can't be negative");
        }
        if (i == 0) {
            return 1;
        } else {
            int factorial = 1;

            for (int j = 1; j <= i; j++) {
                factorial = factorial * j;
            }

            return factorial;
        }
    }
}
