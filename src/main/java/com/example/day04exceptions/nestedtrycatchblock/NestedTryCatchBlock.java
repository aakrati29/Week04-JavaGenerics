package com.example.day04exceptions.nestedtrycatchblock;

import java.util.Scanner;

public class NestedTryCatchBlock {
    public static void division(int[] arr, int index, int divisor) {
        try {
            System.out.println("Accessing index: " + index);
            int value = arr[index];

            try {
                System.out.println("Dividing " + value + " by " + divisor);
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40};

        int validIndex = 2;
        int invalidIndex = 6;
        int validDivisor = 3;
        int byZero = 0;

        System.out.println("Case 1: Valid Index and Valid Divisor");
        division(arr, validIndex, validDivisor);

        System.out.println("\nCase 2: Invalid Index");
        division(arr, invalidIndex, validDivisor);

        System.out.println("\nCase 3: Division by Zero");
        division(arr, validIndex, byZero);
    }
}
