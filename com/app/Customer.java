package com.app;

import java.util.Random;

public class Customer {
    private static final Random random = new Random();

    public static int getRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        // quick smoke test to exercise the method and avoid "never used" warnings
        int min = 1, max = 5;
        System.out.println("Random samples between " + min + " and " + max + ":");
        for (int i = 0; i < 5; i++) {
            System.out.println(getRandomNumber(min, max));
        }
    }
}
