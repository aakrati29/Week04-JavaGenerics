package com.example.day05junit.basicjunitproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListOperationsTest {
    private ListOperations manager;
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        manager = new ListOperations();
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        manager.addElement(list, 5);
        manager.addElement(list, 10);
        assertEquals(2, list.size(), "Size should be 2 after adding two elements");
        assertTrue(list.contains(5), "List should contain 5");
        assertTrue(list.contains(10), "List should contain 10");
    }

    @Test
    void testRemoveElement() {
        manager.addElement(list, 15);
        manager.addElement(list, 20);
        manager.removeElement(list, 15);
        assertFalse(list.contains(15), "List should not contain 15 after removal");
        assertEquals(1, list.size(), "Size should be 1 after removing one element");
    }

    @Test
    void testGetSize() {
        manager.addElement(list, 1);
        manager.addElement(list, 2);
        manager.addElement(list, 3);
        assertEquals(3, manager.getSize(list), "Size should be 3");
    }

    @Test
    void testRemoveNonExistentElement() {
        manager.addElement(list, 5);
        manager.removeElement(list, 10);
        assertEquals(1, list.size(), "Size should remain unchanged when removing a non-existent element");
    }

    @Test
    void testNullList() {
        assertThrows(IllegalArgumentException.class, () -> manager.addElement(null, 5), "Should throw exception for null list in add");
        assertThrows(IllegalArgumentException.class, () -> manager.removeElement(null, 5), "Should throw exception for null list in remove");
        assertThrows(IllegalArgumentException.class, () -> manager.getSize(null), "Should throw exception for null list in getSize");
    }
}

