package com.example.day02collection.setinterface.symmetricdifference;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SymmetricDifferenceTest {

    @Test
    public void testSymmetricDifference_CommonAndUniqueElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 3, 5));

        // Test where set1 and set2 have common and unique elements
        Set<Integer> result = SymmetricDifference.symmetricDifference(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 4, 5)); // Symmetric difference: {1, 2, 4, 5}

        assertEquals(expected, result);
    }

    @Test
    public void testSymmetricDifference_NoCommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6));

        // Test where set1 and set2 have no common elements
        Set<Integer> result = SymmetricDifference.symmetricDifference(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)); // Symmetric difference: {1, 2, 3, 4, 5, 6}

        assertEquals(expected, result);
    }

    @Test
    public void testSymmetricDifference_OneSetIsSubset() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Test where set1 is a subset of set2
        Set<Integer> result = SymmetricDifference.symmetricDifference(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(3, 4)); // Symmetric difference: {3, 4}

        assertEquals(expected, result);
    }

    @Test
    public void testSymmetricDifference_EmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Test where both sets are empty
        Set<Integer> result = SymmetricDifference.symmetricDifference(set1, set2);
        Set<Integer> expected = new HashSet<>(); // Symmetric difference: {}

        assertEquals(expected, result);
    }

    @Test
    public void testSymmetricDifference_SetsAreIdentical() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));

        // Test where set1 and set2 are identical (symmetric difference should be empty)
        Set<Integer> result = SymmetricDifference.symmetricDifference(set1, set2);
        Set<Integer> expected = new HashSet<>(); // Symmetric difference: {}

        assertEquals(expected, result);
    }
}

