package com.example.day04exceptions.trywithresources;

import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class AutoClosingResourcesTest {

    @Test
    void testCheckIOException_FileNotFound() {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Call the method with a non-existing file (should trigger the catch block)
            AutoClosingResources.checkIOException();

            // Capture the output and verify the correct message
            String actualOutput = outContent.toString().trim();
            assertEquals("File not found", actualOutput, "Expected 'File not found' message.");
        } finally {
            System.setOut(originalOut); // Restore System.out
        }
    }

    @Test
    void testCheckIOException_ValidFile() throws Exception {
        // Create a temporary file named "info"
        File tempFile = new File("info");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Test file content\nAnother line");
        }

        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Now call the method (it should successfully read from the temp "info" file)
            AutoClosingResources.checkIOException();

            // Capture the output and check if it contains the file's content
            String actualOutput = outContent.toString().trim();
            assertTrue(actualOutput.contains("Test file content"), "File content should be printed.");
        } finally {
            System.setOut(originalOut); // Restore System.out
            tempFile.delete(); // Clean up the temporary file after the test
        }
    }
}
