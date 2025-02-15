package com.example.day05regex.extractionproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ExtractDatesTest {

    private static final String REGEX = "\\b[0-9]{2}/[0-9]{2}/[0-9]{4}\\b";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    // Helper method to extract dates
    private List<String> extractDates(String input) {
        List<String> extractedDates = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(input);

        while (matcher.find()) {
            extractedDates.add(matcher.group());
        }
        return extractedDates;
    }

    @Test
    void testValidDates() {
        String input = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> expected = List.of("12/05/2023", "15/08/2024", "29/02/2020");
        assertEquals(expected, extractDates(input), "Extracted dates should match expected values.");
    }

    @Test
    void testNoDatesInText() {
        String input = "There are no dates in this text.";
        assertTrue(extractDates(input).isEmpty(), "Expected an empty list when no dates are present.");
    }
}

