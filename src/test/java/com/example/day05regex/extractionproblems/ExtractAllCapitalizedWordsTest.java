package com.example.day05regex.extractionproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ExtractAllCapitalizedWordsTest {

    private static final String REGEX = "\\b[A-Z][a-zA-Z]+\\b";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    // Helper method to extract capitalized words
    private List<String> extractCapitalWords(String input) {
        List<String> capitalizedWords = new ArrayList<>();
        Matcher matcher = PATTERN.matcher(input);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }

    @Test
    void testExtractCapitalizedWords() {
        String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> expected = List.of("The", "Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
        assertEquals(expected, extractCapitalWords(input), "Capitalized words should match expected output.");
    }

    @Test
    void testNoCapitalizedWords() {
        String input = "this is a sentence with no capitalized words.";
        assertTrue(extractCapitalWords(input).isEmpty(), "Expected an empty list when no capitalized words are present.");
    }

    @Test
    void testOnlyCapitalizedWords() {
        String input = "Hello World Java Python AI OpenAI";
        List<String> expected = List.of("Hello", "World", "Java", "Python", "AI", "OpenAI");
        assertEquals(expected, extractCapitalWords(input), "All words should be extracted since they are capitalized.");
    }

    @Test
    void testWordsWithNumbers() {
        String input = "This is a test with Capital1 and Hello2World.";
        List<String> expected = List.of("This");
        assertEquals(expected, extractCapitalWords(input), "Words with numbers should not be extracted.");
    }

}

