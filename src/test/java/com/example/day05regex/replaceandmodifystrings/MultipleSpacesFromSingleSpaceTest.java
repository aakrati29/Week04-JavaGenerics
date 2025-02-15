package com.example.day05regex.replaceandmodifystrings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultipleSpacesFromSingleSpaceTest {

    private static final String REGEX = "\\s+";

    // Helper method to replace multiple spaces
    private String replaceMultipleSpaces(String input) {
        return input.replaceAll(REGEX, " ");
    }

    @Test
    void testReplaceMultipleSpaces() {
        String input = "This  is   an    example    with  multiple     spaces.";
        String expected = "This is an example with multiple spaces.";
        assertEquals(expected, replaceMultipleSpaces(input), "Multiple spaces should be replaced with a single space.");
    }

    @Test
    void testNoExtraSpaces() {
        String input = "This is a normal sentence.";
        assertEquals(input, replaceMultipleSpaces(input), "Text should remain unchanged if no extra spaces are present.");
    }

    @Test
    void testLeadingAndTrailingSpaces() {
        String input = "   Leading and trailing spaces   ";
        String expected = " Leading and trailing spaces ";
        assertEquals(expected, replaceMultipleSpaces(input), "Leading and trailing spaces should be reduced but not removed completely.");
    }

    @Test
    void testOnlySpaces() {
        String input = "       ";
        String expected = " ";
        assertEquals(expected, replaceMultipleSpaces(input), "Multiple spaces alone should be reduced to a single space.");
    }
}

