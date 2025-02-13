package com.example.day02collection.queueinterface.circularbuffersimulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferSimulationTest {

    private CircularBufferSimulation<Integer> buffer;

    @BeforeEach
    public void setUp() {
        buffer = new CircularBufferSimulation<>(3);
    }

    @Test
    public void testEnqueue_InitialInsertions() {
        // Enqueue elements
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        // Assert buffer contents
        Object[] contents = buffer.getBufferContents();
        assertEquals(3, contents.length, "Buffer should contain 3 elements.");
        assertArrayEquals(new Object[]{1, 2, 3}, contents, "Buffer contents should be [1, 2, 3].");
    }

    @Test
    public void testEnqueue_OverwritingElements() {
        // Enqueue elements until buffer is full
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        // Overwrite the oldest elements when inserting new elements
        buffer.enqueue(4);  // This will overwrite 1
        Object[] contents = buffer.getBufferContents();
        assertEquals(3, contents.length, "Buffer should still contain 3 elements.");
        assertArrayEquals(new Object[]{2, 3, 4}, contents, "Buffer should contain [2, 3, 4] after inserting 4.");

        // Enqueue another element, which will overwrite the next oldest element
        buffer.enqueue(5);  // This will overwrite 2
        contents = buffer.getBufferContents();
        assertEquals(3, contents.length, "Buffer should still contain 3 elements.");
        assertArrayEquals(new Object[]{3, 4, 5}, contents, "Buffer should contain [3, 4, 5] after inserting 5.");
    }

    @Test
    public void testEnqueue_EmptyBuffer() {
        // Test with an empty buffer
        Object[] contents = buffer.getBufferContents();
        assertEquals(0, contents.length, "Buffer should be empty initially.");
    }

    @Test
    public void testEnqueue_PartialInsertions() {
        // Insert a single element
        buffer.enqueue(1);
        Object[] contents = buffer.getBufferContents();
        assertEquals(1, contents.length, "Buffer should contain 1 element.");
        assertArrayEquals(new Object[]{1}, contents, "Buffer contents should be [1].");

        // Insert two more elements
        buffer.enqueue(2);
        buffer.enqueue(3);
        contents = buffer.getBufferContents();
        assertEquals(3, contents.length, "Buffer should contain 3 elements.");
        assertArrayEquals(new Object[]{1, 2, 3}, contents, "Buffer contents should be [1, 2, 3].");
    }

    @Test
    public void testEnqueue_FullBuffer() {
        // Fill the buffer to its capacity
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);

        // The buffer is now full, so inserting new elements should overwrite old ones
        buffer.enqueue(4);
        Object[] contents = buffer.getBufferContents();
        assertEquals(3, contents.length, "Buffer should still contain 3 elements after overwriting.");
        assertArrayEquals(new Object[]{2, 3, 4}, contents, "Buffer contents should be [2, 3, 4].");
    }

    @Test
    public void testBuffer_EmptyAfterOverwriting() {
        // Fill the buffer, then overwrite all elements
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4);
        buffer.enqueue(5);

        // Assert the current buffer contents
        Object[] contents = buffer.getBufferContents();
        assertEquals(3, contents.length, "Buffer should contain 3 elements.");
        assertArrayEquals(new Object[]{3, 4, 5}, contents, "Buffer contents should be [3, 4, 5].");
    }
}

