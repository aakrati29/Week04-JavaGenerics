package com.example.day06reflection.dynamicmethodinvocation;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class DynamicMethodInvocationTest {

    @Test
    void testAdditionMethod() {
        try {
            Class<?> mathClass = MathOperations.class;

            Object mathInstance = mathClass.getDeclaredConstructor().newInstance();

            Method method = mathClass.getMethod("add", int.class, int.class);

            Object result = method.invoke(mathInstance, 5, 3);

            assertEquals(8, (int) result, "Addition method should return 8");

        } catch (Exception e) {
            fail("Exception occurred during addition method test: " + e.getMessage());
        }
    }

    @Test
    void testSubtractionMethod() {
        try {
            Class<?> mathClass = MathOperations.class;
            Object mathInstance = mathClass.getDeclaredConstructor().newInstance();
            Method method = mathClass.getMethod("subtract", int.class, int.class);
            Object result = method.invoke(mathInstance, 10, 4);
            assertEquals(6, (int) result, "Subtraction method should return 6");
        } catch (Exception e) {
            fail("Exception occurred during subtraction method test: " + e.getMessage());
        }
    }

    @Test
    void testMultiplicationMethod() {
        try {
            Class<?> mathClass = MathOperations.class;
            Object mathInstance = mathClass.getDeclaredConstructor().newInstance();
            Method method = mathClass.getMethod("multiply", int.class, int.class);
            Object result = method.invoke(mathInstance, 6, 7);
            assertEquals(42, (int) result, "Multiplication method should return 42");
        } catch (Exception e) {
            fail("Exception occurred during multiplication method test: " + e.getMessage());
        }
    }
}

