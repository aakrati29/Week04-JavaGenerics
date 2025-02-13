package com.example.day02collection.queueinterface.generatebinarynumbersusingaqueue;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateBinaryNumbersTest {

    @Test
    public void testGenerateBinaryNumbers_ValidInput() {
        int N = 5;
        List<String> result = GenerateBinaryNumbersUsingQueue.generateBinaryNumbers(N, new LinkedList<>());

        // Assert that the list has the correct size
        assertEquals(N, result.size(), "The result list should have " + N + " elements.");

        // Assert the first few binary numbers
        assertEquals("1", result.get(0), "First binary number should be 1.");
        assertEquals("10", result.get(1), "Second binary number should be 10.");
        assertEquals("11", result.get(2), "Third binary number should be 11.");
        assertEquals("100", result.get(3), "Fourth binary number should be 100.");
        assertEquals("101", result.get(4), "Fifth binary number should be 101.");
    }

    @Test
    public void testGenerateBinaryNumbers_SingleElement() {
        int N = 1;
        List<String> result = GenerateBinaryNumbersUsingQueue.generateBinaryNumbers(N, new LinkedList<>());

        // Assert that the result contains exactly one element, which should be "1"
        assertEquals(1, result.size(), "The result should contain one element.");
        assertEquals("1", result.get(0), "The first binary number should be 1.");
    }

    @Test
    public void testGenerateBinaryNumbers_ZeroElements() {
        int N = 0;
        List<String> result = GenerateBinaryNumbersUsingQueue.generateBinaryNumbers(N, new LinkedList<>());

        // Assert that the result list is empty
        assertTrue(result.isEmpty(), "The result should be an empty list.");
    }

    @Test
    public void testGenerateBinaryNumbers_LargerInput() {
        int N = 10;
        List<String> result = GenerateBinaryNumbersUsingQueue.generateBinaryNumbers(N, new LinkedList<>());

        // Assert that the list has the correct size
        assertEquals(N, result.size(), "The result list should have " + N + " elements.");

        // Assert some expected binary numbers for the first 10 numbers
        assertEquals("1", result.get(0), "First binary number should be 1.");
        assertEquals("10", result.get(1), "Second binary number should be 10.");
        assertEquals("11", result.get(2), "Third binary number should be 11.");
        assertEquals("100", result.get(3), "Fourth binary number should be 100.");
        assertEquals("101", result.get(4), "Fifth binary number should be 101.");
        assertEquals("110", result.get(5), "Sixth binary number should be 110.");
        assertEquals("111", result.get(6), "Seventh binary number should be 111.");
        assertEquals("1000", result.get(7), "Eighth binary number should be 1000.");
        assertEquals("1001", result.get(8), "Ninth binary number should be 1001.");
        assertEquals("1010", result.get(9), "Tenth binary number should be 1010.");
    }
}

