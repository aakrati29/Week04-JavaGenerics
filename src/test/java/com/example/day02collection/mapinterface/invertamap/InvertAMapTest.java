package com.example.day02collection.mapinterface.invertamap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class InvertAMapTest {

    @Test
    public void testInvertMap_MultipleUniqueValues() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 3);

        // Test when the map has unique values for each key
        Map<Integer, List<String>> result = InvertAMap.invertMap(inputMap);
        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(1, Arrays.asList("A"));
        expected.put(2, Arrays.asList("B"));
        expected.put(3, Arrays.asList("C"));

        assertEquals(expected, result);
    }

    @Test
    public void testInvertMap_SameValuesForMultipleKeys() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 1);
        inputMap.put("C", 2);

        // Test when multiple keys have the same value
        Map<Integer, List<String>> result = InvertAMap.invertMap(inputMap);
        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(1, Arrays.asList("A", "B"));
        expected.put(2, Arrays.asList("C"));

        assertEquals(expected, result);
    }

    @Test
    public void testInvertMap_EmptyMap() {
        Map<String, Integer> inputMap = new HashMap<>();

        // Test when the map is empty
        Map<Integer, List<String>> result = InvertAMap.invertMap(inputMap);
        Map<Integer, List<String>> expected = new HashMap<>();

        assertEquals(expected, result);
    }

    @Test
    public void testInvertMap_NullValues() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", null);
        inputMap.put("B", 2);
        inputMap.put("C", null);

        // Test when the map has null values
        Map<Integer, List<String>> result = InvertAMap.invertMap(inputMap);
        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(2, Arrays.asList("B"));
        expected.put(null, Arrays.asList("A", "C"));

        assertEquals(expected, result);
    }

    @Test
    public void testInvertMap_MixedValuesAndKeys() {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);
        inputMap.put("D", 3);
        inputMap.put("E", 2);

        // Test when the map has mixed values and keys
        Map<Integer, List<String>> result = InvertAMap.invertMap(inputMap);
        Map<Integer, List<String>> expected = new HashMap<>();
        expected.put(1, Arrays.asList("A", "C"));
        expected.put(2, Arrays.asList("B", "E"));
        expected.put(3, Arrays.asList("D"));

        assertEquals(expected, result);
    }
}

