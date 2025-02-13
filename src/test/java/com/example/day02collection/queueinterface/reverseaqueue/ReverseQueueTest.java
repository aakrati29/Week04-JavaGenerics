package com.example.day02collection.queueinterface.reverseaqueue;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseQueueTest {

    @Test
    public void testReverseQueue() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

        // Reverse the queue and test the result
        Queue<Integer> reversedQueue = ReverseQueue.reverse(queue);

        // Verify the elements of the reversed queue
        assertEquals(30, reversedQueue.poll(), "First element should be 30.");
        assertEquals(20, reversedQueue.poll(), "Second element should be 20.");
        assertEquals(10, reversedQueue.poll(), "Third element should be 10.");
    }

    @Test
    public void testReverseEmptyQueue() {
        Queue<Integer> queue = new LinkedList<>();

        // Reverse an empty queue
        Queue<Integer> reversedQueue = ReverseQueue.reverse(queue);

        // Verify that the reversed queue is still empty
        assertTrue(reversedQueue.isEmpty(), "Reversed empty queue should be empty.");
    }

    @Test
    public void testReverseQueueWithOneElement() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(42));

        // Reverse a queue with one element
        Queue<Integer> reversedQueue = ReverseQueue.reverse(queue);

        // Verify that the single element remains in the same position
        assertEquals(42, reversedQueue.poll(), "The only element in the queue should be 42.");
    }
}
