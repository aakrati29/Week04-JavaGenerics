package com.example.day04exceptions.nestedtrycatchblock;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NestedTryCatchBlockTest {

    @Test
    void testDivision_InvalidIndex() {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Invalid index
        int[] arr = {10, 20, 30, 40};
        NestedTryCatchBlock.division(arr, 6, 3);

        // Capture the output and check if it's correct
        String output = outContent.toString().trim();
        assertTrue(output.contains("Invalid array index!"), "The exception for invalid index should be handled.");

        System.setOut(originalOut); // Restore System.out
    }

    @Test
    void testDivision_DivisionByZero() {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Division by zero
        int[] arr = {10, 20, 30, 40};
        NestedTryCatchBlock.division(arr, 2, 0);

        // Capture the output and check if it's correct
        String output = outContent.toString().trim();
        assertTrue(output.contains("Cannot divide by zero!"), "Division by zero should be caught.");

        System.setOut(originalOut); // Restore System.out
    }
}

