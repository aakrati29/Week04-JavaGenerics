package com.example.day06annotations.Createannotationforloggingmethod;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LogExecutionTimeTest {

    @Test
    void testProcessTask1ExecutionTime() {
        TaskProcessor processor = new TaskProcessor();
        long startTime = System.nanoTime();
        processor.processTask1();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;

        assertTrue(duration >= 100, "Execution time should be at least 100 ms");
    }

    @Test
    void testProcessTask2ExecutionTime() {
        TaskProcessor processor = new TaskProcessor();
        long startTime = System.nanoTime();
        processor.processTask2();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;

        assertTrue(duration >= 200, "Execution time should be at least 200 ms");
    }
}

