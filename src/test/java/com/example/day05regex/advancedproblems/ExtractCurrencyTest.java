package com.example.day05regex.advancedproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.regex.*;

public class ExtractCurrencyTest {

    private static final String CURRENCY_REGEX = "\\$?\\d+\\.\\d{2}";

    public static List<String> extractCurrencyValues(String text) {
        Pattern pattern = Pattern.compile(CURRENCY_REGEX);
        Matcher matcher = pattern.matcher(text);

        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    @Test
    void testCurrencyExtraction() {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> expected = Arrays.asList("$45.99", "10.50");

        assertEquals(expected, extractCurrencyValues(text), "Currency values should match expected output.");
    }

    @Test
    void testNoCurrencyValues() {
        String text = "No prices mentioned here.";
        List<String> expected = Collections.emptyList();

        assertEquals(expected, extractCurrencyValues(text), "Should return an empty list when no currency values are present.");
    }

    @Test
    void testMultipleCurrencyFormats() {
        String text = "Items cost $5.00, $12.99, 3.50, and 99.99.";
        List<String> expected = Arrays.asList("$5.00", "$12.99", "3.50", "99.99");

        assertEquals(expected, extractCurrencyValues(text), "Should extract all correctly formatted currency values.");
    }

    @Test
    void testCurrencyWithoutDecimal() {
        String text = "This product costs $100 and another is $200.50.";
        List<String> expected = Arrays.asList("$200.50"); // $100 is invalid (lacks decimals)

        assertEquals(expected, extractCurrencyValues(text), "Should extract only valid currency values.");
    }
}

