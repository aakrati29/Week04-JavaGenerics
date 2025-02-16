package com.example.day06annotations.createatodoannotationforpendingtasks;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class TaskManager {

    @Todo(task = "Implement user authentication", assignedTo = "Ram", priority = "HIGH")
    public void implementAuth() {
        System.out.println("Authentication system pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Aakrati", priority = "MEDIUM")
    public void optimizeDB() {
        System.out.println("Database optimization pending...");
    }

    @Todo(task = "Add logging functionality", assignedTo = "Ankit", priority = "LOW")
    public void addLogging() {
        System.out.println("Logging feature pending...");
    }

    public void completedFeature() {
        System.out.println("This feature is completed.");
    }

    public static void getPendingTasks() {
        Method[] methods = TaskManager.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Pending Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("-------------------------------");
            }
        }
    }
}

public class TodoAnnotation {
    public static void main(String[] args) {
        TaskManager.getPendingTasks();
    }
}

