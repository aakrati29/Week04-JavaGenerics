package com.example.day04exceptions.multiplecatchblocks;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MultipleCatchBlocksTest {

    @Test
    void testMultipleCatches_ValidInput() {
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Test with valid input
            int[] arr = {10, 20, 30};
            MultipleCatchBlocks.multipleCatches(arr, 2);

            String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
            assertTrue(actualOutput.contains("10"), "Valid case should print the division result");
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMultipleCatches_ArithmeticException() {
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            int[] arr = {10, 20, 30};
            MultipleCatchBlocks.multipleCatches(arr, 0);

            String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
            assertEquals("Arithmetic exception occur", actualOutput);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMultipleCatches_NullPointerException() {
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            int[] arr = null;
            MultipleCatchBlocks.multipleCatches(arr, 2);

            String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
            assertEquals("Null pointer exception occur", actualOutput);
        } finally {
            System.setOut(originalOut);
        }
    }
}

