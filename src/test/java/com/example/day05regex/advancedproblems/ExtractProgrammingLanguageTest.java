package com.example.day05regex.advancedproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ExtractProgrammingLanguageTest {

    private static final String[] LANGUAGES = {"Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "PHP", "Rust", "Kotlin"};

    public static List<String> extractLanguages(String text) {
        List<String> foundLanguages = new ArrayList<>();

        for (String lang : LANGUAGES) {
            if (text.matches(".*\\b" + lang + "\\b.*")) {
                foundLanguages.add(lang);
            }
        }
        return foundLanguages;
    }

    @Test
    void testProgrammingLanguageExtraction() {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expected = Arrays.asList("Java", "Python", "JavaScript", "Go");

        assertEquals(expected, extractLanguages(text), "Extracted languages should match expected output.");
    }

    @Test
    void testNoLanguagesFound() {
        String text = "This sentence has no programming languages mentioned.";
        List<String> expected = Collections.emptyList();

        assertEquals(expected, extractLanguages(text), "Should return an empty list when no programming languages are found.");
    }

    @Test
    void testMultipleOccurrences() {
        String text = "Java is great. Java is powerful. Java and JavaScript are different!";
        List<String> expected = Arrays.asList("Java", "JavaScript");

        assertEquals(expected, extractLanguages(text), "Should extract 'Java' and 'JavaScript' only once.");
    }

    @Test
    void testEdgeCasePartialMatches() {
        String text = "This text contains the word JavaScript, but not Javanese.";
        List<String> expected = Arrays.asList("JavaScript");

        assertEquals(expected, extractLanguages(text), "Should extract 'JavaScript' but not 'Javanese'.");
    }
}
