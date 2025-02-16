package com.example.day06reflection.methodexecutiontiming;

import java.lang.reflect.Method;

public class ExecutionTimer {

    public static void measureExecutionTime(Object object, String methodName, Object... args) {
        try {
            Class<?> clazz = object.getClass();
            Method method;

            Class<?>[] paramTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                paramTypes[i] = args[i].getClass();
            }

            method = clazz.getMethod(methodName, paramTypes);

            long startTime = System.nanoTime();
            method.invoke(object, args);
            long endTime = System.nanoTime();

            System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) + " nanoseconds");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

