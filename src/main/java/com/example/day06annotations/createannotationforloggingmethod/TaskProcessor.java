package com.example.day06annotations.createannotationforloggingmethod;

public class TaskProcessor {

    @LogExecutionTime
    public void processTask1() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void processTask2() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalTask() {
        System.out.println("This method is not logged.");
    }
}


