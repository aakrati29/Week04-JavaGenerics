package com.example.day05regex.advancedproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateASocialSecurityNumberTest {

    @Test
    void testValidSSNs() {
        assertTrue(ValidateASocialSecurityNumber.isValidSSN("123-45-6789"), "Valid SSN should pass");
    }

    @Test
    void testInvalidSSNs() {
        assertFalse(ValidateASocialSecurityNumber.isValidSSN("123456789"), "Missing dashes should fail");
        assertFalse(ValidateASocialSecurityNumber.isValidSSN("000-12-3456"), "SSN starting with 000 should fail");
        assertFalse(ValidateASocialSecurityNumber.isValidSSN("666-45-6789"), "SSN starting with 666 should fail");
        assertFalse(ValidateASocialSecurityNumber.isValidSSN("900-12-3456"), "SSN starting with 900-999 should fail");
        assertFalse(ValidateASocialSecurityNumber.isValidSSN("12-345-6789"), "Incorrect format should fail");
        assertFalse(ValidateASocialSecurityNumber.isValidSSN("123-4A-6789"), "Contains letters, should fail");
    }
}

