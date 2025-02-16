package com.example.day06reflection.getclassinformation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ClassInformationTest {

    @Test
    void testValidClassReflection() {
        String className = "java.util.ArrayList";

        try {
            Class<?> clazz = Class.forName(className);

            assertNotNull(clazz, "Class should not be null");

            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            assertNotNull(constructors, "Constructors should not be null");

            Field[] fields = clazz.getDeclaredFields();
            assertNotNull(fields, "Fields should not be null");

            Method[] methods = clazz.getDeclaredMethods();
            assertNotNull(methods, "Methods should not be null");

        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should not occur for a valid class");
        }
    }

    @Test
    void testInvalidClassReflection() {
        String invalidClassName = "com.nonexistent.UnknownClass";

        Exception exception = assertThrows(ClassNotFoundException.class, () -> {
            Class.forName(invalidClassName);
        });

        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }
}

