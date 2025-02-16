package com.example.day06reflection.methodexecutiontiming;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExecutionTimerTest {

    @Test
    void testFastMethodExecutionTime() {
        SampleOperations operations = new SampleOperations();

        long startTime = System.nanoTime();
        operations.fastMethod();
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;
        assertTrue(executionTime < 1_000_000, "Fast method took too long!");
    }

    @Test
    void testSlowMethodExecutionTime() {
        SampleOperations operations = new SampleOperations();

        long startTime = System.nanoTime();
        operations.slowMethod();
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;
        assertTrue(executionTime > 400_000_000, "Slow method executed too fast!");
    }
}
