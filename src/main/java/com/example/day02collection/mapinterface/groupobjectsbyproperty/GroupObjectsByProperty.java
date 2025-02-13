package com.example.day02collection.mapinterface.groupobjectsbyproperty;

import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupObjectsByProperty {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedMap = new HashMap<>();

        for (Employee emp : employees) {
            // If department key doesn't exist, create a new list
            groupedMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        return groupedMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance")
        );

        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        groupedEmployees.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
    }
}

