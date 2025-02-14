package com.example.day04exceptions.uncheckedexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RuntimeException {
    public static void checkArithmeticEx(int number, int integer) {
        try {
            int result = number / integer;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurs: " + e.getMessage());
        }
    }

    public static void checkInputMismatchEx(int integer) {
        try {
            int result  = integer;
        }
        catch (InputMismatchException e) {
            System.out.println("Input mismatch exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            System.out.print("Enter an integer for arithmetic operation: ");
            int number = s.nextInt();

            System.out.print("Enter another integer: ");
            int integer = s.nextInt();

            checkArithmeticEx(number, integer);
            checkInputMismatchEx(integer);

        }
        catch (InputMismatchException e) {
            System.out.println("Input mismatch occurred. Please enter valid integers.");
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurred");
        }
        finally {
            s.close();
        }
    }
}
