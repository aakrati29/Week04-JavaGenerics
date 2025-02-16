package com.example.day06reflection.invokeprivatemethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

class InvokePrivateMethodTest {

    @Test
    void testPrivateMethodInvocation() {
        try {
            Calculator calculator = new Calculator();

            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            multiplyMethod.setAccessible(true);

            int result = (int) multiplyMethod.invoke(calculator, 5, 10);

            assertEquals(50, result, "Multiplication should return 50");

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testInvalidMethodInvocation() {
        Exception exception = assertThrows(NoSuchMethodException.class, () -> {
            Calculator.class.getDeclaredMethod("nonExistentMethod", int.class);
        });

        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }
}

