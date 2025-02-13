package com.example.day02collection.listinterface.reversealist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ReverseTest {

    @Test
    void testReverseByLinkedList() {
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> expectedOutput = new LinkedList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertEquals(expectedOutput, Reverse.reverseByLinkedList(input));
    }

    @Test
    void testReverseByLinkedListWithSingleElement() {
        LinkedList<Integer> input = new LinkedList<>(List.of(1));
        LinkedList<Integer> expectedOutput = new LinkedList<>(List.of(1));
        assertEquals(expectedOutput, Reverse.reverseByLinkedList(input));
    }

    @Test
    void testReverseByLinkedListWithEmptyList() {
        LinkedList<Integer> input = new LinkedList<>();
        LinkedList<Integer> expectedOutput = new LinkedList<>();
        assertEquals(expectedOutput, Reverse.reverseByLinkedList(input));
    }

    @Test
    void testReverseByArrayList() {
        int[] input = {1, 2, 3, 4, 5};
        List<Integer> expectedOutput = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expectedOutput, Reverse.reverseByArrayList(input));
    }

    @Test
    void testReverseByArrayListWithSingleElement() {
        int[] input = {1};
        List<Integer> expectedOutput = Arrays.asList(1);
        assertEquals(expectedOutput, Reverse.reverseByArrayList(input));
    }

    @Test
    void testReverseByArrayListWithEmptyArray() {
        int[] input = {};
        List<Integer> expectedOutput = List.of();
        assertEquals(expectedOutput, Reverse.reverseByArrayList(input));
    }
}

