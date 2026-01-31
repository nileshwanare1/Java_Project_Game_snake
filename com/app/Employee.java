package com.app;

public class Employee {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return !isEven(number);
    }

    public static void main(String[] args) {
        // exercise the helper methods to avoid "never used" warnings
        int[] samples = {0, 1, 2, -3, 4};
        for (int n : samples) {
            System.out.println(n + ": isEven=" + isEven(n) + ", isOdd=" + isOdd(n));
        }
    }
}