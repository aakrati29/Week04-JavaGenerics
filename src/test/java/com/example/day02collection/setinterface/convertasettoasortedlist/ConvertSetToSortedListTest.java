package com.example.day02collection.setinterface.convertasettoasortedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ConvertSetToSortedListTest {

    @Test
    public void testConvertSetToSortedList_UnorderedSet() {
        Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));

        // Testing with unordered set, the result should be a sorted list: [1, 3, 5, 9]
        List<Integer> result = ConvertSeToSortedList.convertSetToSortedList(set);
        List<Integer> expected = Arrays.asList(1, 3, 5, 9);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertSetToSortedList_EmptySet() {
        Set<Integer> set = new HashSet<>();

        // Testing with an empty set, the result should be an empty list: []
        List<Integer> result = ConvertSeToSortedList.convertSetToSortedList(set);
        List<Integer> expected = new ArrayList<>();

        assertEquals(expected, result);
    }

    @Test
    public void testConvertSetToSortedList_AlreadySortedSet() {
        Set<Integer> set = new HashSet<>(Set.of(1, 3, 5, 9));

        // Testing with a set that is already sorted, the result should be the same sorted list: [1, 3, 5, 9]
        List<Integer> result = ConvertSeToSortedList.convertSetToSortedList(set);
        List<Integer> expected = Arrays.asList(1, 3, 5, 9);

        assertEquals(expected, result);
    }
}
