package com.example.day04exceptions.customexception;

import java.util.Scanner;

class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {
        super(message);
    }

    public static void checkCustomEx(int age) throws InvalidAgeException {
            if (age < 18) {
                throw new InvalidAgeException("Invalid age exception occur");
            } else {
                System.out.println("Age is valid");
            }
        }
    }

public class UserDefinedException {
    public static void main(String[] args) throws InvalidAgeException {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the age : ");
        int age = s.nextInt();

        try {
            InvalidAgeException.checkCustomEx(age);
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        finally {
            s.close();
        }

    }
}
