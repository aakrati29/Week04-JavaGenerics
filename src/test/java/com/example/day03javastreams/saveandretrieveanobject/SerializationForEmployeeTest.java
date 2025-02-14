package com.example.day03javastreams.saveandretrieveanobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SerializationForEmployeeTest {
    private static final String TEST_FILE_PATH = "test_employees.ser";
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = Arrays.asList(
                new Employee(1, "Ankit", "HR", 50000),
                new Employee(2, "Anand", "IT", 60000),
                new Employee(3, "Aakrati", "Finance", 70000)
        );
    }

    @AfterEach
    void tearDown() {
        // Delete test file after execution
        new File(TEST_FILE_PATH).delete();
    }

    @Test
    void testSerializeAndDeserializeEmployees() throws IOException, ClassNotFoundException {
        // Serialize employees
        SerializationForEmployee.serializeEmployees(employees, TEST_FILE_PATH);

        // Deserialize employees
        List<Employee> deserializedEmployees = SerializationForEmployee.deserializeEmployees(TEST_FILE_PATH);

        // Assertions
        assertNotNull(deserializedEmployees);
        assertEquals(employees.size(), deserializedEmployees.size());

        for (int i = 0; i < employees.size(); i++) {
            assertEquals(employees.get(i).id, deserializedEmployees.get(i).id);
            assertEquals(employees.get(i).name, deserializedEmployees.get(i).name);
            assertEquals(employees.get(i).department, deserializedEmployees.get(i).department);
            assertEquals(employees.get(i).salary, deserializedEmployees.get(i).salary);
        }
    }
}

