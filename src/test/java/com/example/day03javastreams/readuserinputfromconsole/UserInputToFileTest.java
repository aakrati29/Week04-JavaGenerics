package com.example.day03javastreams.readuserinputfromconsole;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UserInputToFileTest {
    private static final String TEST_FILE_PATH = "test_input.txt";
    private final String simulatedInput = "John Doe\n25\nJava\n"; // Simulated console input

    @BeforeEach
    void setUp() {
        // Redirect System.in with predefined input
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    @AfterEach
    void tearDown() {
        // Delete test file after execution
        new File(TEST_FILE_PATH).delete();
        System.setIn(System.in); // Reset System.in
    }

    @Test
    void testSaveUserInput() throws IOException {
        // Call the method to test
        UserInputToFile.saveUserInput(TEST_FILE_PATH);

        // Verify the output file content
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_PATH))) {
            assertEquals("Name: John Doe", reader.readLine());
            assertEquals("Age: 25", reader.readLine());
            assertEquals("Favorite Language: Java", reader.readLine());
        }
    }
}
