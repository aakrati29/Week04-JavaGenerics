package com.example.day02collection.queueinterface.hospitaltriagesystem;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;


class Patient implements Comparable<Patient> {
    String name;
    int severity; // Higher value means more severe

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Higher severity first
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalSystem {
    public static <T extends Comparable<T>> List<T> processPatients(PriorityQueue<T> queue) {
        List<T> treatedOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            treatedOrder.add(queue.poll()); // Treat highest priority patient
        }

        return treatedOrder;
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        queue.offer(new Patient("John", 3));
        queue.offer(new Patient("Alice", 5));
        queue.offer(new Patient("Bob", 2));

        List<Patient> treatedOrder = processPatients(queue);
        System.out.println("Treatment Order: " + treatedOrder);
    }
}



