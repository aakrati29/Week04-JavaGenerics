package com.example.day04exceptions.exceptionpropagationinmethods;

import java.util.Scanner;

public class ExceptionPropagationInMethod {
    public static void addMethod(){
        int result = 10/0;
        System.out.println(result);
    }

    public static void callAddMethod(){
        addMethod();
    }

    public static void main(String[] args) {
        try{
            callAddMethod();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main..");
        }
    }
}
