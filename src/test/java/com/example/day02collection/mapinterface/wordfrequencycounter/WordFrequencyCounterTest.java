package com.example.day02collection.mapinterface.wordfrequencycounter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class WordFrequencyCounterTest {

    @Test
    public void testCountFrequency_ValidInput() {
        String input = "Hello world, hello Java!";

        // Test counting word frequency
        HashMap<String, Integer> result = WordFrequencyCounter.countFrequency(input);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 1);

        assertEquals(expected, result);
    }

    @Test
    public void testCountFrequency_EmptyString() {
        String input = "";

        // Test with an empty input string
        HashMap<String, Integer> result = WordFrequencyCounter.countFrequency(input);
        HashMap<String, Integer> expected = new HashMap<>();

        assertEquals(expected, result);
    }

    @Test
    public void testCountFrequency_OnlySpaces() {
        String input = "     ";

        // Test with only spaces (no words)
        HashMap<String, Integer> result = WordFrequencyCounter.countFrequency(input);
        HashMap<String, Integer> expected = new HashMap<>();

        assertEquals(expected, result);
    }

    @Test
    public void testCountFrequency_MultipleSpacesBetweenWords() {
        String input = "hello    world   hello    java";

        // Test with multiple spaces between words
        HashMap<String, Integer> result = WordFrequencyCounter.countFrequency(input);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 1);

        assertEquals(expected, result);
    }

    @Test
    public void testCountFrequency_SpecialCharacters() {
        String input = "Hello!!! world, hello Java?";

        // Test with special characters
        HashMap<String, Integer> result = WordFrequencyCounter.countFrequency(input);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 1);

        assertEquals(expected, result);
    }

    @Test
    public void testCountFrequency_UpperAndLowerCase() {
        String input = "HELLO hello WORLD world";

        // Test case-insensitivity
        HashMap<String, Integer> result = WordFrequencyCounter.countFrequency(input);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 2);

        assertEquals(expected, result);
    }
}

