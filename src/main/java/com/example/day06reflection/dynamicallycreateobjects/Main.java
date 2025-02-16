package com.example.day06reflection.dynamicallycreateobjects;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Students.class;

            Constructor<?> constructor = studentClass.getDeclaredConstructor();

            Object studentInstance = constructor.newInstance();

            Method displayMethod = studentClass.getMethod("display");
            displayMethod.invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
