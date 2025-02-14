package com.example.day04exceptions.customexception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvalidAgeExceptionTest {

    @Test
    void testCheckCustomEx_ValidAge() {
        // Should not throw an exception for age >= 18
        assertDoesNotThrow(() -> InvalidAgeException.checkCustomEx(20));
    }

    @Test
    void testCheckCustomEx_InvalidAge() {
        // Should throw InvalidAgeException for age < 18
        Exception exception = assertThrows(InvalidAgeException.class, () -> {
            InvalidAgeException.checkCustomEx(16);
        });

        // Check exception message
        assertEquals("Invalid age exception occur", exception.getMessage());
    }
}

