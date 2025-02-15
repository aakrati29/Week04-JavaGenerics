package com.example.day05regex.basicregexproblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateHexColorCodeTest {

    @Test
    void testValidHexColors() {
        assertTrue(ValidateHexColorCode.isValidHexColor("#FFA500"), "Expected valid hex color");
        assertTrue(ValidateHexColorCode.isValidHexColor("#ff4500"), "Expected valid hex color");
        assertTrue(ValidateHexColorCode.isValidHexColor("#123456"), "Expected valid hex color");
        assertTrue(ValidateHexColorCode.isValidHexColor("#ABCDEF"), "Expected valid hex color");
        assertTrue(ValidateHexColorCode.isValidHexColor("#abcdef"), "Expected valid hex color");
    }

    @Test
    void testInvalidHexColors() {
        assertFalse(ValidateHexColorCode.isValidHexColor("#123"), "Invalid: Too short");
        assertFalse(ValidateHexColorCode.isValidHexColor("FFA500"), "Invalid: Missing #");
        assertFalse(ValidateHexColorCode.isValidHexColor("#ZZZZZZ"), "Invalid: Contains non-hex characters");
        assertFalse(ValidateHexColorCode.isValidHexColor("#ABC12G"), "Invalid: Contains 'G', which is not a hex digit");
        assertFalse(ValidateHexColorCode.isValidHexColor("#1234567"), "Invalid: Too many characters");
    }
}

