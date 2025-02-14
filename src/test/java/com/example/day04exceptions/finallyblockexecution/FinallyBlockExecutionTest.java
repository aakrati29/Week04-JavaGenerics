package com.example.day04exceptions.finallyblockexecution;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FinallyBlockExecutionTest {

    @Test
    void testDivision_ValidNumbers() {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Valid input, should not throw any exception
            FinallyBlockExecution.division(10, 2);

            // Capture the output and check if it's correct
            String output = outContent.toString().trim();
            assertTrue(output.contains("5"), "The result should be printed correctly.");
            assertTrue(output.contains("Operation complete"), "The 'finally' block should execute.");
        } finally {
            System.setOut(originalOut); // Restore System.out
        }
    }

    @Test
    void testDivision_DivisionByZero() {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Division by zero, should trigger the ArithmeticException in the catch block
            FinallyBlockExecution.division(10, 0);

            // Capture the output and check if it's correct
            String output = outContent.toString().trim();
            assertTrue(output.contains("Arithmetics Exception Occur"), "The 'catch' block should handle division by zero.");
            assertTrue(output.contains("Operation complete"), "The 'finally' block should execute.");
        } finally {
            System.setOut(originalOut); // Restore System.out
        }
    }

    @Test
    void testDivision_ValidNumbersNegativeResult() {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Valid input with negative result
            FinallyBlockExecution.division(-10, 2);

            // Capture the output and check if it's correct
            String output = outContent.toString().trim();
            assertTrue(output.contains("-5"), "The result should be correctly calculated.");
            assertTrue(output.contains("Operation complete"), "The 'finally' block should execute.");
        } finally {
            System.setOut(originalOut); // Restore System.out
        }
    }
}

