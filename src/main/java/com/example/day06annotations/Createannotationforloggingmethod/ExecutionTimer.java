package com.example.day06annotations.Createannotationforloggingmethod;

import java.lang.reflect.Method;

public class ExecutionTimer {

    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1_000_000;
                System.out.println(methodName + " executed in: " + duration + " ms");
            } else {
                System.out.println("Method " + methodName + " is not annotated with @LogExecutionTime");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

