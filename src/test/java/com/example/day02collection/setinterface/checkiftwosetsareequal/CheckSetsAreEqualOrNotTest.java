package com.example.day02collection.setinterface.checkiftwosetsareequal;

import java.util.HashSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckSetsAreEqualOrNotTest {

    // Method to check if two sets are equal
    private static <T> boolean checkSetsAreEqualOrNot(HashSet<T> set1, HashSet<T> set2) {
        return set1.equals(set2); // Directly compare the sets
    }

    // JUnit Test Cases
    @Test
    public void testCheckSetsAreEqual_SameElements() {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Test for sets with same elements in different orders
        assertTrue(checkSetsAreEqualOrNot(set1, set2));
    }

    @Test
    public void testCheckSetsAreEqual_DifferentElements() {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);

        // Test for sets with different elements
        assertFalse(checkSetsAreEqualOrNot(set1, set2));
    }

    @Test
    public void testCheckSetsAreEqual_EmptySets() {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Test for two empty sets (should be equal)
        assertTrue(checkSetsAreEqualOrNot(set1, set2));
    }

    @Test
    public void testCheckSetsAreEqual_OneEmptySet() {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);

        HashSet<Integer> set2 = new HashSet<>();

        // Test for one empty set and one non-empty set (should not be equal)
        assertFalse(checkSetsAreEqualOrNot(set1, set2));
    }

    @Test
    public void testCheckSetsAreEqual_SameSizeDifferentElements() {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);

        // Test for sets with the same size but different elements
        assertFalse(checkSetsAreEqualOrNot(set1, set2));
    }
}

