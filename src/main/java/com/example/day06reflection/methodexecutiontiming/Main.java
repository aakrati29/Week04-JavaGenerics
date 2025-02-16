package com.example.day06reflection.methodexecutiontiming;

public class Main {
    public static void main(String[] args) {
        SampleOperations operations = new SampleOperations();

        ExecutionTimer.measureExecutionTime(operations, "fastMethod");
        ExecutionTimer.measureExecutionTime(operations, "slowMethod");
    }
}

