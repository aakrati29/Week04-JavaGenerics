package com.example.day06annotations.Createannotationforloggingmethod;

public class CreateLogExecutionTimeAnno {
    public static void main(String[] args) {
        TaskProcessor processor = new TaskProcessor();

        ExecutionTimer.measureExecutionTime(processor, "processTask1");
        ExecutionTimer.measureExecutionTime(processor, "processTask2");

        ExecutionTimer.measureExecutionTime(processor, "normalTask");
    }
}

