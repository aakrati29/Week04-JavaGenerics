package com.example.day05regex.extractionproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ExtractAllEmailAddressesTest {

    private static final String REGEX = "[a-zA-Z0-9-.+]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    // Helper method to extract emails
    private List<String> extractEmails(String input) {
        List<String> extractedEmails = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(input);

        while (matcher.find()) {
            extractedEmails.add(matcher.group());
        }
        return extractedEmails;
    }

    @Test
    void testValidEmails() {
        String input = "Contact us at support@example.com and info@company.org";
        List<String> expected = List.of("support@example.com", "info@company.org");
        assertEquals(expected, extractEmails(input), "Extracted emails should match expected values.");
    }

    @Test
    void testNoEmailsInText() {
        String input = "There are no emails in this text.";
        assertTrue(extractEmails(input).isEmpty(), "Expected an empty list when no emails are present.");
    }

    @Test
    void testInvalidEmails() {
        String input = "Emails like test@com, user@@example.com, and user.example.com are invalid.";
        assertTrue(extractEmails(input).isEmpty(), "Invalid email formats should not be extracted.");
    }

    @Test
    void testMixedValidAndInvalidEmails() {
        String input = "Valid: john.doe@gmail.com, Invalid: test@.com, example@domain";
        List<String> expected = List.of("john.doe@gmail.com");
        assertEquals(expected, extractEmails(input), "Only valid emails should be extracted.");
    }
}

