package com.example.day02collection.mapinterface.mergetwomaps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MergeTwoMapsTest {

    @Test
    public void testMergeMaps_NonOverlappingKeys() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("C", 3);
        map2.put("D", 4);

        // Test merging maps with non-overlapping keys
        Map<String, Integer> result = MergeTwoMaps.mergeMaps(map1, map2);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 1);
        expected.put("B", 2);
        expected.put("C", 3);
        expected.put("D", 4);

        assertEquals(expected, result);
    }

    @Test
    public void testMergeMaps_OverlappingKeys() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Test merging maps with overlapping keys
        Map<String, Integer> result = MergeTwoMaps.mergeMaps(map1, map2);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 1);
        expected.put("B", 5); // 2 from map1 + 3 from map2
        expected.put("C", 4);

        assertEquals(expected, result);
    }

    @Test
    public void testMergeMaps_EmptyFirstMap() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("A", 1);
        map2.put("B", 2);

        // Test merging an empty map with a non-empty map
        Map<String, Integer> result = MergeTwoMaps.mergeMaps(map1, map2);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 1);
        expected.put("B", 2);

        assertEquals(expected, result);
    }

    @Test
    public void testMergeMaps_EmptySecondMap() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();

        // Test merging a non-empty map with an empty map
        Map<String, Integer> result = MergeTwoMaps.mergeMaps(map1, map2);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 1);
        expected.put("B", 2);

        assertEquals(expected, result);
    }

    @Test
    public void testMergeMaps_EmptyMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // Test merging two empty maps
        Map<String, Integer> result = MergeTwoMaps.mergeMaps(map1, map2);
        Map<String, Integer> expected = new HashMap<>();

        assertEquals(expected, result);
    }

    @Test
    public void testMergeMaps_MixedEmptyAndNonEmpty() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 2);
        map2.put("C", 3);

        // Test merging a non-empty map with another non-empty map, with no overlapping keys
        Map<String, Integer> result = MergeTwoMaps.mergeMaps(map1, map2);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 1);
        expected.put("B", 2);
        expected.put("C", 3);

        assertEquals(expected, result);
    }
}

