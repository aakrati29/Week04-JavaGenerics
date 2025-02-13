package com.example.day03javastreams.saveandretrieveanobject;

import java.io.Serializable;

public class Employee implements Serializable {
    static final long serialVersionUID = 1L;
    public int id;
    public String name;
    public String department;
    public double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}



