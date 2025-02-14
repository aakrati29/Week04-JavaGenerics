package com.example.day04exceptions.finallyblockexecution;

import java.util.Scanner;

public class FinallyBlockExecution {

    public static void division(int num1, int num2){
        try{
            int result = num1/num2;
            System.out.println(result);
        }
        catch (Exception e) {
            System.out.println("Arithmetics Exception Occur");
        }
        finally{
            System.out.println("Operation complete");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        int num1 = s.nextInt();

        System.out.println("Enter second number:");
        int num2 = s.nextInt();

        division(num1, num2);

    }
}
