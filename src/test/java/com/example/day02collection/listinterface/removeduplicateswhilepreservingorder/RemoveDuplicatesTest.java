package com.example.day02collection.listinterface.removeduplicateswhilepreservingorder;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {

    @Test
    void testRemoveDuplicate() {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> expectedOutput = Arrays.asList(3, 1, 2, 4);
        assertEquals(expectedOutput, RemoveDuplicates.removeDuplicate(input));
    }
    @Test
    void testRemoveDuplicateWithNoDuplicates() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expectedOutput = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expectedOutput, RemoveDuplicates.removeDuplicate(input));
    }

    @Test
    void testRemoveDuplicateWithAllDuplicates() {
        List<Integer> input = Arrays.asList(1, 1, 1, 1);
        List<Integer> expectedOutput = Arrays.asList(1);
        assertEquals(expectedOutput, RemoveDuplicates.removeDuplicate(input));
    }

    @Test
    void testRemoveDuplicateWithEmptyList() {
        List<Integer> input = Arrays.asList();
        List<Integer> expectedOutput = Arrays.asList();
        assertEquals(expectedOutput, RemoveDuplicates.removeDuplicate(input));
    }

    @Test
    void testRemoveDuplicateWithDifferentDataTypes() {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        List<String> expectedOutput = Arrays.asList("apple", "banana", "orange");
        assertEquals(expectedOutput, RemoveDuplicates.removeDuplicate(input));
    }
}
