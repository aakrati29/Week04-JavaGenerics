package com.example.day05junit.basicjunitproblems;

import java.util.Scanner;

public class EvenNumberChecker {

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        EvenNumberChecker checker = new EvenNumberChecker();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check: ");
        int number = scanner.nextInt();

        if (checker.isEven(number)) {
            System.out.println(number + " is even.");
        }
        else {
            System.out.println(number + " is odd.");
        }

        scanner.close();
    }
}

