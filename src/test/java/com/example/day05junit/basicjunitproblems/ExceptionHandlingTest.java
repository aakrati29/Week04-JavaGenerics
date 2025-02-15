package com.example.day05junit.basicjunitproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExceptionHandlingTest {
    private ExceptionHandling obj;

    @BeforeEach
    void setUp() {
        obj = new ExceptionHandling();
    }

    @Test
    void testValidDivision() {
        assertEquals(5, obj.divide(10, 2), "10 / 2 should be 5");
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> obj.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage(), "Exception message should match");
    }
}
