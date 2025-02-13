package com.example.day03javastream.convertuppercasetolowercase;

import com.example.day03javastreams.convertuppercasetolowercase.UpperCaseToLowerCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpperCaseToLowerCaseTest {
    private static final String TEST_INPUT_FILE = "test_input.txt";
    private static final String TEST_OUTPUT_FILE = "test_output.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create test input file with uppercase content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_INPUT_FILE))) {
            writer.write("HELLO WORLD\n");
            writer.write("JAVA PROGRAMMING\n");
            writer.write("UNIT TESTING\n");
        }
    }

    @AfterEach
    void tearDown() {
        // Delete test files after execution
        new File(TEST_INPUT_FILE).delete();
        new File(TEST_OUTPUT_FILE).delete();
    }

    @Test
    void testConvertFileToLowercase() throws IOException {
        // Convert uppercase to lowercase
        UpperCaseToLowerCase.convertFileToLowercase(TEST_INPUT_FILE, TEST_OUTPUT_FILE);

        // Read the output file
        List<String> outputLines = Files.readAllLines(Paths.get(TEST_OUTPUT_FILE));

        // Expected output
        assertEquals("hello world", outputLines.get(0));
        assertEquals("java programming", outputLines.get(1));
        assertEquals("unit testing", outputLines.get(2));
    }
}

