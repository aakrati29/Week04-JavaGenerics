package com.example.day05junit.basicjunitproblems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    private final FileProcessor fileProcessor = new FileProcessor();
    private final String testFilename = "testfile.txt";
    private final String testContent = "Hello, JUnit File Handling!";

    @Test
    void testWriteAndReadFile() throws IOException {
        fileProcessor.writeToFile(testFilename, testContent);
        String readContent = fileProcessor.readFromFile(testFilename);
        assertEquals(testContent, readContent, "File content should match written content");
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(testFilename, testContent);
        assertTrue(Files.exists(Path.of(testFilename)), "File should exist after writing");
    }

    // Test handling of IOException when file does not exist
    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistentfile.txt"),
                "Should throw IOException when file does not exist");
    }

    // Cleanup: Delete test file after each test
    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Path.of(testFilename));
    }
}

