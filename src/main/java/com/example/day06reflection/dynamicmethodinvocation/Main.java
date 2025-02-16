package com.example.day06reflection.dynamicmethodinvocation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter method name (like add, subtract, multiply) : ");
            String methodName = scanner.nextLine();

            System.out.println("Enter first number : ");
            int num1 = scanner.nextInt();

            System.out.println("Enter second number : ");
            int num2 = scanner.nextInt();

            scanner.close();

            Class<?> mathClass = MathOperations.class;

            Object mathInstance = mathClass.getDeclaredConstructor().newInstance();

            Method method = mathClass.getMethod(methodName, int.class, int.class);

            Object result = method.invoke(mathInstance, num1, num2);
            System.out.println("Result : " + result);

        } catch (Exception e) {
            System.out.println("Invalid method name or input!");
            e.printStackTrace();
        }
    }
}
