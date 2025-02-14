package com.example.day03javastreams.datastreams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataHandlerTest {
    private static final String TEST_FILE_PATH = "test_student_data.txt";
    private Student testStudent;

    @BeforeEach
    void setUp() {
        // Initialize a test student object before each test
        testStudent = new Student(101, "Ankit", 9.8);
    }

    @AfterEach
    void tearDown() {
        // Clean up test file after each test
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveAndRetrieveStudentData() throws IOException {
        // Save student data to file
        DataHandler.saveStudentData(testStudent, TEST_FILE_PATH);

        // Retrieve student data from file
        Student retrievedStudent = DataHandler.retrieveStudentData(TEST_FILE_PATH);

        // Validate retrieved data
        assertEquals(testStudent.getRollNumber(), retrievedStudent.getRollNumber());
        assertEquals(testStudent.getName(), retrievedStudent.getName());
        assertEquals(testStudent.getGpa(), retrievedStudent.getGpa(), 0.01);
    }
}

