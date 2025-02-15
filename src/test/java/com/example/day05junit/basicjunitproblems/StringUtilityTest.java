package com.example.day05junit.basicjunitproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
    private StringUtilsMethods utils;

    @BeforeEach
    void setUp() {
        utils = new StringUtilsMethods();
    }

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"), "Reverse function failed");
        assertEquals("madam", utils.reverse("madam"), "Reverse function failed");
        assertEquals("", utils.reverse(""), "Reverse function failed for empty string");
    }

    @Test
    void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"), "Palindrome check failed");
        assertTrue(utils.isPalindrome("racecar"), "Palindrome check failed");
        assertFalse(utils.isPalindrome("hello"), "Palindrome check failed");
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"), "Uppercase conversion failed");
        assertEquals("JAVA", utils.toUpperCase("java"), "Uppercase conversion failed");
    }

    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> utils.reverse(null), "Expected exception for null input in reverse");
        assertThrows(IllegalArgumentException.class, () -> utils.isPalindrome(null), "Expected exception for null input in isPalindrome");
        assertThrows(IllegalArgumentException.class, () -> utils.toUpperCase(null), "Expected exception for null input in toUpperCase");
    }
}
