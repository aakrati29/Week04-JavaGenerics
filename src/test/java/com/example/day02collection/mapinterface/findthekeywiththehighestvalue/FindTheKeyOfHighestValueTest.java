package com.example.day02collection.mapinterface.findthekeywiththehighestvalue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class FindTheKeyOfHighestValueTest {

    @Test
    public void testFindTheKeyOfHighestValue_MultipleEntries() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Test when the map has multiple entries
        String result = FindTheKeyOfHighestValue.findTheKeyOfHighestValue(map);
        String expected = "B"; // B has the highest value (20)

        assertEquals(expected, result);
    }

    @Test
    public void testFindTheKeyOfHighestValue_SingleEntry() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);

        // Test when the map has only one entry
        String result = FindTheKeyOfHighestValue.findTheKeyOfHighestValue(map);
        String expected = "A"; // A is the only key in the map

        assertEquals(expected, result);
    }

    @Test
    public void testFindTheKeyOfHighestValue_EmptyMap() {
        Map<String, Integer> map = new HashMap<>();

        // Test when the map is empty
        String result = FindTheKeyOfHighestValue.findTheKeyOfHighestValue(map);
        String expected = null; // No keys in the map

        assertEquals(expected, result);
    }

    @Test
    public void testFindTheKeyOfHighestValue_MultipleKeysWithSameHighestValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 20);
        map.put("B", 20);
        map.put("C", 15);

        // Test when there are multiple keys with the same highest value
        String result = FindTheKeyOfHighestValue.findTheKeyOfHighestValue(map);
        String expected = "A"; // Since A is checked first, it should be returned (if order is maintained)

        assertEquals(expected, result);
    }

    @Test
    public void testFindTheKeyOfHighestValue_NegativeValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", -10);
        map.put("B", -20);
        map.put("C", -15);

        // Test when the map has negative values
        String result = FindTheKeyOfHighestValue.findTheKeyOfHighestValue(map);
        String expected = "A"; // A has the highest value (-10)

        assertEquals(expected, result);
    }
}

