package com.learning.java.samples.level0;

public class ObjectEquality {
    private static final Complex ORIGIN = new Complex(0, 0);

    public static void main(String[] args) {
        final Complex c1 = new Complex(0, 0);
        if(isOriginRef(c1)) {
            System.out.println("Origin and C1 has the same reference");
        }
        if(isOrigin(c1)) {
            System.out.println("Point C1 is at origin");
        }
    }

    // Wrong way to compare if the point is origin
    // may not what you have envisioned
    private static boolean isOriginRef(final Complex c) {
        // Checking equality based on reference
        return c == ORIGIN;
    }

    // Correct way
    private static boolean isOrigin(final Complex c) {
        // equality based on .equals
        return ORIGIN.equals(c);
    }
}
