package com.example.day05regex.extractionproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ExtractLinksFromAWebPageTest {

    private static final String REGEX = "\\bhttps?://(www\\.)?[a-zA-Z\\d@#$%.-]+\\b";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    // Helper method to extract links
    private List<String> extractLinks(String input) {
        List<String> extractedLinks = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(input);

        while (matcher.find()) {
            extractedLinks.add(matcher.group());
        }
        return extractedLinks;
    }

    @Test
    void testValidLinks() {
        String input = "Visit https://www.google.com and http://example.org for more info.";
        List<String> expected = List.of("https://www.google.com", "http://example.org");
        assertEquals(expected, extractLinks(input), "Extracted links should match expected values.");
    }

    @Test
    void testNoLinksInText() {
        String input = "This text has no URLs.";
        assertTrue(extractLinks(input).isEmpty(), "Expected an empty list when no links are present.");
    }

    @Test
    void testInvalidLinks() {
        String input = "Check example.com or www.google for info.";
        assertTrue(extractLinks(input).isEmpty(), "Invalid URLs without 'http' or 'https' should not be extracted.");
    }

    @Test
    void testMixedValidAndInvalidLinks() {
        String input = "Correct: https://github.com, Incorrect: ftp://file.com and www.test.com.";
        List<String> expected = List.of("https://github.com");
        assertEquals(expected, extractLinks(input), "Only valid links should be extracted.");
    }
}

