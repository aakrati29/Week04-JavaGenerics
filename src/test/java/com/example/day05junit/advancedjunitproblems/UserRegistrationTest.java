package com.example.day05junit.advancedjunitproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private final UserRegistration userReg = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userReg.registerUser("JohnDoe", "john.doe@example.com", "Password1"));
    }

    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("", "john.doe@example.com", "Password1"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("JohnDoe", "invalid-email", "Password1"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userReg.registerUser("JohnDoe", "john.doe@example.com", "pass"));
        assertEquals("Password must have at least 8 characters, one uppercase letter, and one digit", exception.getMessage());
    }
}

