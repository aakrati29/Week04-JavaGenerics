package com.example.day02collection.queueinterface.hospitaltriagesystem;

import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {

    @Test
    public void testProcessPatients_CorrectTreatmentOrder() {
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        // Add patients with varying severity
        queue.offer(new Patient("John", 3));
        queue.offer(new Patient("Alice", 5));
        queue.offer(new Patient("Bob", 2));

        // Process patients
        List<Patient> treatedOrder = HospitalSystem.processPatients(queue);

        // Assert the order of treated patients, highest severity first
        assertEquals("Alice (Severity: 5)", treatedOrder.get(0).toString(), "First treated patient should be Alice with severity 5.");
        assertEquals("John (Severity: 3)", treatedOrder.get(1).toString(), "Second treated patient should be John with severity 3.");
        assertEquals("Bob (Severity: 2)", treatedOrder.get(2).toString(), "Third treated patient should be Bob with severity 2.");
    }

    @Test
    public void testProcessPatients_EmptyQueue() {
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        // Process patients from an empty queue
        List<Patient> treatedOrder = HospitalSystem.processPatients(queue);

        // Assert that the treated order list is empty
        assertTrue(treatedOrder.isEmpty(), "The treated order should be empty when there are no patients.");
    }

    @Test
    public void testProcessPatients_SinglePatient() {
        PriorityQueue<Patient> queue = new PriorityQueue<>();
        queue.offer(new Patient("Alice", 5));

        // Process patients with only one patient in the queue
        List<Patient> treatedOrder = HospitalSystem.processPatients(queue);

        // Assert that the treated order contains only the single patient
        assertEquals(1, treatedOrder.size(), "The treated order should contain one patient.");
        assertEquals("Alice (Severity: 5)", treatedOrder.get(0).toString(), "The only treated patient should be Alice.");
    }
}

