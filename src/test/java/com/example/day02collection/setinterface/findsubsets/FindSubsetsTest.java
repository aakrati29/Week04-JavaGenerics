package com.example.day02collection.setinterface.findsubsets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class FindSubsetsTest {

    @Test
    public void testFindSubset_ValidSubset() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Test where set1 is a proper subset of set2
        assertTrue(FindSubsets.findSubset(set1, set2));
    }

    @Test
    public void testFindSubset_NotASubset() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(5, 6));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Test where set1 is not a subset of set2
        assertFalse(FindSubsets.findSubset(set1, set2));
    }

    @Test
    public void testFindSubset_EqualSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Test where set1 is equal to set2 (set1 should be a subset of set2)
        assertTrue(FindSubsets.findSubset(set1, set2));
    }

    @Test
    public void testFindSubset_EmptySet1() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Test where set1 is empty (an empty set is always a subset of any set)
        assertTrue(FindSubsets.findSubset(set1, set2));
    }

    @Test
    public void testFindSubset_EmptySet2() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>();

        // Test where set2 is empty (set1 cannot be a subset of an empty set)
        assertFalse(FindSubsets.findSubset(set1, set2));
    }

    @Test
    public void testFindSubset_Set1LargerThanSet2() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Test where set1 is larger than set2 (set1 cannot be a subset of set2)
        assertFalse(FindSubsets.findSubset(set1, set2));
    }
}

