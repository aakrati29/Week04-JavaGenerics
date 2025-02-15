package com.example.day05junit.basicjunitproblems;

public class UsingTimeout {
    public void longRunningTask() throws InterruptedException {
        System.out.println("Task started...");
        Thread.sleep(3000); // Simulating a long-running task (3 seconds)
        System.out.println("Task completed.");
    }

    public static void main(String[] args) {
        UsingTimeout task = new UsingTimeout();
        try {
            task.longRunningTask();
        } catch (InterruptedException e) {
            System.out.println("Task was interrupted.");
        }
    }
}

