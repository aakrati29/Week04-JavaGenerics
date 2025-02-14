package com.example.day04exceptions.throwvsthrows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IllegalArgumentExTest {

    @Test
    void testCalculateInterest_ValidInput() {
        // Test valid input values
        try {
            double result = IllegalArgumentEx.calculateInterest(1000, 5, 2);
            assertEquals(100.0, result, "Interest should be calculated correctly.");
        } catch (IllegalArgumentException e) {
            fail("Exception should not be thrown for valid inputs.");
        }
    }

    @Test
    void testCalculateInterest_NegativeAmount() {
        // Test negative amount
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            IllegalArgumentEx.calculateInterest(-1000, 5, 2);
        });
        assertEquals("IllegalArgumentException", thrown.getMessage(), "Exception message should be 'IllegalArgumentException'.");
    }

    @Test
    void testCalculateInterest_NegativeRate() {
        // Test negative rate
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            IllegalArgumentEx.calculateInterest(1000, -5, 2);
        });
        assertEquals("IllegalArgumentException", thrown.getMessage(), "Exception message should be 'IllegalArgumentException'.");
    }

    @Test
    void testCalculateInterest_NegativeYears() {
        // Test negative years
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            IllegalArgumentEx.calculateInterest(1000, 5, -2);
        });
        assertEquals("IllegalArgumentException", thrown.getMessage(), "Exception message should be 'IllegalArgumentException'.");
    }
}

