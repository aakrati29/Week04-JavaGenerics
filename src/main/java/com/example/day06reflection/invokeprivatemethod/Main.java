package com.example.day06reflection.invokeprivatemethod;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();

            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            multiplyMethod.setAccessible(true);

            int result = (int) multiplyMethod.invoke(calculator, 6, 5);

            System.out.println("Multiplication Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
