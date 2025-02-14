package com.example.day04exceptions.throwvsthrows;

class IllegalArgumentEx{

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if(amount < 0 || rate < 0 || years < 0){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        double calculate = (amount*rate*years)/100;
        return calculate;
    }
}
public class ExceptionPropagation {
    public static void main(String[] args) throws IllegalArgumentException {
        double amount;
        double rate;
        int year;
        try {
            IllegalArgumentEx.calculateInterest(1000, 200, 2);
            IllegalArgumentEx.calculateInterest(2000, -500, 1);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
