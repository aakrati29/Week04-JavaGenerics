package com.example.day05junit.advancedjunitproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("StrongPass1"), "Valid password should return true");
    }

    @Test
    void testPasswordWithoutUppercase() {
        assertFalse(PasswordValidator.isValidPassword("weakpassword1"), "Password without uppercase should return false");
    }

    @Test
    void testPasswordWithoutDigit() {
        assertFalse(PasswordValidator.isValidPassword("NoDigitPass"), "Password without digit should return false");
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValidPassword("Shrt1"), "Password shorter than 8 characters should return false");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValidPassword(null), "Null password should return false");
    }

    @Test
    void testEmptyPassword() {
        assertFalse(PasswordValidator.isValidPassword(""), "Empty password should return false");
    }
}


