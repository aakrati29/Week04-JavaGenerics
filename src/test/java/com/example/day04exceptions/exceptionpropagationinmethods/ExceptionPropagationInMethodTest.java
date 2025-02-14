package com.example.day04exceptions.exceptionpropagationinmethods;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionPropagationInMethodTest {

    @Test
    void testExceptionPropagation() {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the main method to trigger exception propagation
        try {
            String[] args = {}; // Passing empty args as we don't need input arguments
            ExceptionPropagationInMethod.main(args);
        } catch (Exception e) {
            fail("Exception should be caught in the main method, not here.");
        } finally {
            System.setOut(originalOut); // Restore System.out
        }

        // Capture the output and check if the exception handling message is printed
        String output = outContent.toString().trim();
        assertTrue(output.contains("Handled exception in main.."), "The 'Handled exception in main..' message should be printed.");
    }
}

