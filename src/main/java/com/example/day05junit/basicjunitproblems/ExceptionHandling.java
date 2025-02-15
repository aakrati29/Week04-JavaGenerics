package com.example.day05junit.basicjunitproblems;

public class ExceptionHandling {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        ExceptionHandling obj = new ExceptionHandling();

        System.out.println("Division result (10 / 2): " + obj.divide(10, 2));

        try {
            System.out.println("Division result (10 / 0): " + obj.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}


