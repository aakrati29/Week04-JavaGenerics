package com.example.day05regex.advancedproblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

public class ValidateAnIPAddressTest {

    private static final String IP_REGEX = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}" +
            "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])$";

    public static boolean isValidIPAddress(String ip) {
        return Pattern.matches(IP_REGEX, ip);
    }

    @Test
    void testValidIPAddresses() {
        assertTrue(isValidIPAddress("192.168.1.1"), "192.168.1.1 should be valid.");
        assertTrue(isValidIPAddress("255.255.255.255"), "255.255.255.255 should be valid.");
        assertTrue(isValidIPAddress("0.0.0.0"), "0.0.0.0 should be valid.");
        assertTrue(isValidIPAddress("122.84.255.165"), "122.84.255.165 should be valid.");
    }

    @Test
    void testInvalidIPAddresses() {
        assertFalse(isValidIPAddress("14,255,457"), "14,255,457 should be invalid (comma instead of dot).");
        assertFalse(isValidIPAddress("256.100.100.100"), "256.100.100.100 should be invalid (256 out of range).");
        assertFalse(isValidIPAddress("192.168.1"), "192.168.1 should be invalid (missing last octet).");
        assertFalse(isValidIPAddress("192.168.1.300"), "192.168.1.300 should be invalid (300 out of range).");
        assertFalse(isValidIPAddress("abc.def.ghi.jkl"), "abc.def.ghi.jkl should be invalid (not numbers).");
        assertFalse(isValidIPAddress("192.168.1.1.1"), "192.168.1.1.1 should be invalid (extra octet).");
        assertFalse(isValidIPAddress("192.168.-1.1"), "192.168.-1.1 should be invalid (negative number).");
        assertFalse(isValidIPAddress("..."), "... should be invalid (only dots).");
    }
}

