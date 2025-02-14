package com.example.day04exceptions.checkedexception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompileTimeExceptionTest {


        @Test
        void testCheckIOException() {
            // Redirect System.out to capture console output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            try {
                // Call the method
                CheckedException.checkIOException();

                // Normalize output by trimming whitespace and handling new lines
                String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
                String expectedOutput = "File not found";

                assertEquals(expectedOutput, actualOutput, "Mismatch in console output!");
            } finally {
                // Restore original System.out
                System.setOut(originalOut);
            }
        }
    }


