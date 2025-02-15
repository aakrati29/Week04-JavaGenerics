package com.example.day05regex.replaceandmodifystrings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class CensorBadWordsInASentenceTest {

    @Test
    void testCensorBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String expected = "This is a ***** bad example with some ***** words.";
        assertEquals(expected, CensorBadWordsInASentence.searchBadWords(input, badWords), "Bad words should be censored.");
    }

    @Test
    void testNoBadWordsInText() {
        String input = "This is a clean sentence.";
        List<String> badWords = Arrays.asList("badword");
        assertEquals(input, CensorBadWordsInASentence.searchBadWords(input, badWords), "Text should remain unchanged if no bad words are found.");
    }

    @Test
    void testCensorWordsWithDifferentCases() {
        String input = "This is a Damn example with some STUPID words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String expected = "This is a ***** example with some ***** words.";
        assertEquals(expected, CensorBadWordsInASentence.searchBadWords(input, badWords), "Censoring should be case-insensitive.");
    }

    @Test
    void testCensorPartialWordNotReplaced() {
        String input = "I love programming in JavaScript.";
        List<String> badWords = Arrays.asList("Java");
        assertEquals(input, CensorBadWordsInASentence.searchBadWords(input, badWords), "Partial words should not be replaced.");
    }

    @Test
    void testCensorMultipleOccurrences() {
        String input = "Damn! This is stupid, damn it!";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String expected = "*****! This is *****, ***** it!";
        assertEquals(expected, CensorBadWordsInASentence.searchBadWords(input, badWords), "All occurrences of bad words should be replaced.");
    }
}

