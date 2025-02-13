package com.example.day02collection.listinterface.rotateelementsinalist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RotateElementTest {

    @Test
    void testRotateElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        RotateElement.rotateElement(input, 2);
        List<Integer> expectedOutput = Arrays.asList(30, 40, 50, 10, 20);
        assertEquals(expectedOutput, input);
    }

    @Test
    void testRotateElementWithKGreaterThanSize() {
        List<Integer> input = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        RotateElement.rotateElement(input, 7); // Equivalent to rotating by 2
        List<Integer> expectedOutput = Arrays.asList(30, 40, 50, 10, 20);
        assertEquals(expectedOutput, input);
    }

    @Test
    void testRotateElementWithKEqualToSize() {
        List<Integer> input = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        RotateElement.rotateElement(input, 5); // Should remain the same
        List<Integer> expectedOutput = Arrays.asList(10, 20, 30, 40, 50);
        assertEquals(expectedOutput, input);
    }

    @Test
    void testRotateElementWithKZero() {
        List<Integer> input = new ArrayList<>(Arrays.asList(20, 30, 40, 50, 10));
        RotateElement.rotateElement(input, 1); // No rotation
        List<Integer> expectedOutput = Arrays.asList(30, 40, 50, 10, 20);
        assertEquals(expectedOutput, input);
    }

    @Test
    void testRotateElementWithSingleElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(100));
        RotateElement.rotateElement(input, 4); // Rotating a single element shouldn't change the list
        List<Integer> expectedOutput = Arrays.asList(100);
        assertEquals(expectedOutput, input);
    }
}
