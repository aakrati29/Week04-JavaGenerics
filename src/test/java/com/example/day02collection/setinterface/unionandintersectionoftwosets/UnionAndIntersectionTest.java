package com.example.day02collection.setinterface.unionandintersectionoftwosets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class UnionAndIntersectionTest {

    @Test
    public void testUnion_CommonAndUniqueElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 3, 5));

        // Testing the union of set1 and set2, should be {1, 2, 3, 4, 5}
        Set<Integer> result = UnionAndIntersection.union(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        assertEquals(expected, result);
    }

    @Test
    public void testUnion_NoCommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6));

        // Testing the union of set1 and set2, should be {1, 2, 3, 4, 5, 6}
        Set<Integer> result = UnionAndIntersection.union(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertEquals(expected, result);
    }

    @Test
    public void testUnion_IdenticalSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));

        // Testing the union of identical sets, should be {1, 2, 3}
        Set<Integer> result = UnionAndIntersection.union(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3));

        assertEquals(expected, result);
    }

    @Test
    public void testIntersection_CommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Testing the intersection of set1 and set2, should be {3}
        Set<Integer> result = UnionAndIntersection.intersection(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(3));

        assertEquals(expected, result);
    }

    @Test
    public void testIntersection_NoCommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6));

        // Testing the intersection of set1 and set2, should be an empty set
        Set<Integer> result = UnionAndIntersection.intersection(set1, set2);
        Set<Integer> expected = new HashSet<>();

        assertEquals(expected, result);
    }

    @Test
    public void testIntersection_IdenticalSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));

        // Testing the intersection of identical sets, should be {1, 2, 3}
        Set<Integer> result = UnionAndIntersection.intersection(set1, set2);
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3));

        assertEquals(expected, result);
    }

    @Test
    public void testIntersection_OneSetIsEmpty() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));

        // Testing the intersection where one set is empty, should be an empty set
        Set<Integer> result = UnionAndIntersection.intersection(set1, set2);
        Set<Integer> expected = new HashSet<>();

        assertEquals(expected, result);
    }

    @Test
    public void testUnion_EmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Testing the union where both sets are empty, should be an empty set
        Set<Integer> result = UnionAndIntersection.union(set1, set2);
        Set<Integer> expected = new HashSet<>();

        assertEquals(expected, result);
    }
}

