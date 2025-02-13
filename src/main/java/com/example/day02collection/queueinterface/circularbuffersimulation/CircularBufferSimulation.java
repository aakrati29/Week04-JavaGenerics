package com.example.day02collection.queueinterface.circularbuffersimulation;

import java.util.Arrays;

public class CircularBufferSimulation<T> {
    private final Object[] buffer;
    private int front = 0, rear = 0, size = 0, capacity;

    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        this.buffer = new Object[capacity];
    }

    // Insert an element, overwriting if full
    public void enqueue(T value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity;
        }
    }

    // Get elements in order
    public Object[] getBufferContents() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(front + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBufferSimulation<Integer> buffer = new CircularBufferSimulation<>(3);

        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        System.out.println("Buffer: " + Arrays.toString(buffer.getBufferContents()));

        buffer.enqueue(4);
        System.out.println("Buffer after inserting 4: " + Arrays.toString(buffer.getBufferContents()));

        buffer.enqueue(5);
        System.out.println("Buffer after inserting 5: " + Arrays.toString(buffer.getBufferContents()));
    }
}

