package com.example.day05regex.basicregexproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

public class ValidateALicensePlateNumberTest {

    private static final String REGEX = "^[A-Z]{2}[0-9]{4}$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private boolean isValidLicensePlate(String plate) {
        return PATTERN.matcher(plate).matches();
    }

    @Test
    void testValidLicensePlates() {
        assertTrue(isValidLicensePlate("AB1234"), "Expected valid license plate");
        assertTrue(isValidLicensePlate("XY5678"), "Expected valid license plate");
        assertTrue(isValidLicensePlate("ZZ9999"), "Expected valid license plate");
    }

    @Test
    void testInvalidLicensePlates() {
        assertFalse(isValidLicensePlate("A12345"), "Invalid: Only one letter at the start");
        assertFalse(isValidLicensePlate("ABC123"), "Invalid: Too many letters at the start");
        assertFalse(isValidLicensePlate("AB123"), "Invalid: Not enough numbers");
        assertFalse(isValidLicensePlate("ABCD12"), "Invalid: Too many letters");
        assertFalse(isValidLicensePlate("AB12C3"), "Invalid: Contains non-numeric character in number part");
        assertFalse(isValidLicensePlate("ab1234"), "Invalid: Lowercase letters are not allowed");
        assertFalse(isValidLicensePlate("1234AB"), "Invalid: Incorrect format (numbers first)");
    }
}

