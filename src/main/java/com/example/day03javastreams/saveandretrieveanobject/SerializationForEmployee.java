package com.example.day03javastreams.saveandretrieveanobject;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerializationForEmployee {
    public static void serializeEmployees(List<Employee> employees, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
        }
    }

    public static List<Employee> deserializeEmployees(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Employee>) ois.readObject();
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ankit", "HR", 50000),
                new Employee(2, "Anand", "IT", 60000),
                new Employee(3, "Aakrati", "Finance", 70000)
        );

        String filePath = "D://Capgemini//Week04-JavaGenerics//src//main//java//com//example//day03javastreams//saveandretrieveanobject//file.txt";
        try {
            serializeEmployees(employees, filePath);
            System.out.println("Employees serialized successfully!");

            List<Employee> deserializedEmployees = deserializeEmployees(filePath);
            System.out.println("Deserialized Employees: " + deserializedEmployees);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
