package com.example.day03javastream.efficientfilecopy;

import com.example.day03javastreams.efficientfilecopy.BufferedFileCopy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class BufferedFileCopyTest {
    private static final String SOURCE_FILE = "test_source.txt";
    private static final String DESTINATION_FILE = "test_destination.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a source file with test content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SOURCE_FILE))) {
            writer.write("Hello, this is a test file.");
        }
    }

    @AfterEach
    void tearDown() {
        // Clean up test files after execution
        new File(SOURCE_FILE).delete();
        new File(DESTINATION_FILE).delete();
    }

    @Test
    void testCopyFileBuffered() throws IOException {
        // Call the method to copy the file
        BufferedFileCopy.copyFileBuffered(SOURCE_FILE, DESTINATION_FILE);

        // Verify that the destination file exists
        File destFile = new File(DESTINATION_FILE);
        assertTrue(destFile.exists(), "Destination file should be created");

        // Compare the content of the source and destination files
        try (BufferedReader sourceReader = new BufferedReader(new FileReader(SOURCE_FILE));
             BufferedReader destReader = new BufferedReader(new FileReader(DESTINATION_FILE))) {

            assertEquals(sourceReader.readLine(), destReader.readLine(), "File content should match");
        }
    }
}

