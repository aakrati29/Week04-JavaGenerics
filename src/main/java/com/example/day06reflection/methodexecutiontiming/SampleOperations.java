package com.example.day06reflection.methodexecutiontiming;

public class SampleOperations {

    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    public void slowMethod() {
        try {
            Thread.sleep(500);
            System.out.println("Executing slow method...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

