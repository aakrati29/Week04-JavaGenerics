package com.example.day02collection.listinterface.findfrequency;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class FindFrequencyTest {

    @Test
    void testCountFrequency() {
        // Sample input
        String[] input = {"apple", "banana", "apple", "orange"};

        // Expected output
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("apple", 2);
        expected.put("banana", 1);
        expected.put("orange", 1);

        // Actual output
        HashMap<String, Integer> actual = FindFrequency.countFrequency(input);

        // Assertion to compare expected vs actual results
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyInput() {
        String[] input = {};
        HashMap<String, Integer> expected = new HashMap<>();
        HashMap<String, Integer> actual = FindFrequency.countFrequency(input);

        assertEquals(expected, actual);
    }

    @Test
    void testSingleElement() {
        String[] input = {"apple"};
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("apple", 1);

        HashMap<String, Integer> actual = FindFrequency.countFrequency(input);

        assertEquals(expected, actual);
    }

    @Test
    void testAllUniqueElements() {
        String[] input = {"apple", "banana", "orange"};
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("apple", 1);
        expected.put("banana", 1);
        expected.put("orange", 1);

        HashMap<String, Integer> actual = FindFrequency.countFrequency(input);

        assertEquals(expected, actual);
    }

    @Test
    void testCaseSensitivity() {
        String[] input = {"Apple", "apple", "APPLE"};
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Apple", 1);
        expected.put("apple", 1);
        expected.put("APPLE", 1);

        HashMap<String, Integer> actual = FindFrequency.countFrequency(input);

        assertEquals(expected, actual);
    }
}

