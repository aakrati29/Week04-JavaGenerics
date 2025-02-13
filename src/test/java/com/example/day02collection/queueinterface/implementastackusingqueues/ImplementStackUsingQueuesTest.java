package com.example.day02collection.queueinterface.implementastackusingqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackUsingQueuesTest {

    @Test
    public void testPushAndTop() {
        ImplementStackUsingQueues<Integer> stack = new ImplementStackUsingQueues<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test the top element
        assertEquals(3, stack.top(), "Top element should be 3.");
    }

    @Test
    public void testPop() {
        ImplementStackUsingQueues<Integer> stack = new ImplementStackUsingQueues<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop an element and test the result
        assertEquals(3, stack.pop(), "Popped element should be 3.");
        assertEquals(2, stack.pop(), "Popped element should be 2.");
        assertEquals(1, stack.pop(), "Popped element should be 1.");
    }

    @Test
    public void testPopEmptyStack() {
        ImplementStackUsingQueues<Integer> stack = new ImplementStackUsingQueues<>();

        // Attempt to pop from an empty stack
        Exception exception = assertThrows(RuntimeException.class, stack::pop);
        assertEquals("Stack is empty!", exception.getMessage(), "Exception message should be 'Stack is empty!'");
    }

    @Test
    public void testTopEmptyStack() {
        ImplementStackUsingQueues<Integer> stack = new ImplementStackUsingQueues<>();

        // Attempt to get the top element from an empty stack
        Exception exception = assertThrows(RuntimeException.class, stack::top);
        assertEquals("Stack is empty!", exception.getMessage(), "Exception message should be 'Stack is empty!'");
    }

    @Test
    public void testIsEmpty() {
        ImplementStackUsingQueues<Integer> stack = new ImplementStackUsingQueues<>();

        // The stack should be empty initially
        assertTrue(stack.isEmpty(), "Stack should be empty initially.");

        stack.push(1);
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing an element.");

        stack.pop();
        assertTrue(stack.isEmpty(), "Stack should be empty after popping the only element.");
    }
}

