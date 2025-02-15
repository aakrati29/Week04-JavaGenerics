package com.example.day05junit.basicjunitproblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorClassTest {

    private CalculatorClass calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorClass(); // Initialize CalculatorClass before each test
    }

    @Test
    void testAddition() {
        assertEquals(15, calculator.add(10, 5), "10 + 5 should be 15");
        assertEquals(0, calculator.add(-5, 5), "-5 + 5 should be 0");
        assertEquals(-10, calculator.add(-5, -5), "-5 + (-5) should be -10");
    }

    @Test
    void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5), "10 - 5 should be 5");
        assertEquals(-10, calculator.subtract(-5, 5), "-5 - 5 should be -10");
        assertEquals(0, calculator.subtract(5, 5), "5 - 5 should be 0");
    }

    @Test
    void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5), "10 * 5 should be 50");
        assertEquals(0, calculator.multiply(0, 10), "0 * 10 should be 0");
        assertEquals(-20, calculator.multiply(-4, 5), "-4 * 5 should be -20");
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(10, 5), "10 / 5 should be 2");
        assertEquals(-3, calculator.divide(-9, 3), "-9 / 3 should be -3");
        assertEquals(0, calculator.divide(0, 5), "0 / 5 should be 0");
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage(), "Exception message should match");
    }
}
