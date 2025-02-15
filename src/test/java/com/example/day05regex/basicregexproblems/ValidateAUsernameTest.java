package com.example.day05regex.basicregexproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

public class ValidateAUsernameTest {

    private static final String REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private boolean isValidUsername(String username) {
        return PATTERN.matcher(username).matches();
    }

    @Test
    void testValidUsernames() {
        assertTrue(isValidUsername("user_123"), "Expected valid username");
        assertTrue(isValidUsername("Username123"), "Expected valid username");
        assertTrue(isValidUsername("User_4567"), "Expected valid username");
        assertTrue(isValidUsername("A_user_789"), "Expected valid username");
    }

    @Test
    void testInvalidUsernames() {
        assertFalse(isValidUsername("123user"), "Username cannot start with a number");
        assertFalse(isValidUsername("us"), "Username is too short");
        assertFalse(isValidUsername("user@name"), "Username contains invalid character '@'");
        assertFalse(isValidUsername("user-name"), "Username contains invalid character '-'");
        assertFalse(isValidUsername("User!Name"), "Username contains special character '!'");
        assertFalse(isValidUsername("a"), "Username is too short");
        assertFalse(isValidUsername("this_is_a_very_long_username"), "Username is too long");
    }
}

