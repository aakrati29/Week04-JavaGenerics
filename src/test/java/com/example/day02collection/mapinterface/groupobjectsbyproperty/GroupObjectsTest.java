package com.example.day02collection.mapinterface.groupobjectsbyproperty;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GroupObjectsTest {

    @Test
    public void testGroupByDepartment_ValidInput() {
        // Arrange
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance")
        );

        // Act
        Map<String, List<Employee>> result = GroupObjectsByProperty.groupByDepartment(employees);

        // Assert
        assertEquals(3, result.size(), "There should be 3 departments.");
        assertTrue(result.containsKey("HR"), "HR department should be present.");
        assertTrue(result.containsKey("IT"), "IT department should be present.");
        assertTrue(result.containsKey("Finance"), "Finance department should be present.");

        // Validate HR department
        List<Employee> hrEmployees = result.get("HR");
        assertEquals(2, hrEmployees.size(), "HR department should have 2 employees.");
        assertTrue(hrEmployees.stream().anyMatch(e -> e.name.equals("Alice")), "Alice should be in HR.");
        assertTrue(hrEmployees.stream().anyMatch(e -> e.name.equals("Carol")), "Carol should be in HR.");

        // Validate IT department
        List<Employee> itEmployees = result.get("IT");
        assertEquals(1, itEmployees.size(), "IT department should have 1 employee.");
        assertTrue(itEmployees.stream().anyMatch(e -> e.name.equals("Bob")), "Bob should be in IT.");

        // Validate Finance department
        List<Employee> financeEmployees = result.get("Finance");
        assertEquals(1, financeEmployees.size(), "Finance department should have 1 employee.");
        assertTrue(financeEmployees.stream().anyMatch(e -> e.name.equals("David")), "David should be in Finance.");
    }

    @Test
    public void testGroupByDepartment_EmptyList() {
        // Arrange
        List<Employee> employees = Collections.emptyList();

        // Act
        Map<String, List<Employee>> result = GroupObjectsByProperty.groupByDepartment(employees);

        // Assert
        assertTrue(result.isEmpty(), "Result should be empty for an empty employee list.");
    }

    @Test
    public void testGroupByDepartment_SingleDepartment() {
        // Arrange
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Carol", "HR")
        );

        // Act
        Map<String, List<Employee>> result = GroupObjectsByProperty.groupByDepartment(employees);

        // Assert
        assertEquals(1, result.size(), "There should be only 1 department.");
        assertTrue(result.containsKey("HR"), "HR department should be present.");
        assertEquals(2, result.get("HR").size(), "HR department should have 2 employees.");
    }

    @Test
    public void testGroupByDepartment_SingleEmployee() {
        // Arrange
        List<Employee> employees = Collections.singletonList(new Employee("Alice", "HR"));

        // Act
        Map<String, List<Employee>> result = GroupObjectsByProperty.groupByDepartment(employees);

        // Assert
        assertEquals(1, result.size(), "There should be 1 department.");
        assertTrue(result.containsKey("HR"), "HR department should be present.");
        assertEquals(1, result.get("HR").size(), "HR department should have 1 employee.");
    }

    @Test
    public void testGroupByDepartment_MultipleDepartments() {
        // Arrange
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "IT"),
                new Employee("David", "Finance")
        );

        // Act
        Map<String, List<Employee>> result = GroupObjectsByProperty.groupByDepartment(employees);

        // Assert
        assertEquals(3, result.size(), "There should be 3 departments.");
        assertTrue(result.containsKey("HR"), "HR department should be present.");
        assertTrue(result.containsKey("IT"), "IT department should be present.");
        assertTrue(result.containsKey("Finance"), "Finance department should be present.");
    }
}

