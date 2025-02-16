package com.example.day06annotations.cachingsystemwithcacheresult;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CacheProxyTest {

    @Test
    void testCachingBehavior() {
        ExpensiveComputation computation = CacheProxy.create(new ExpensiveComputationImplementation(), ExpensiveComputation.class);

        long startTime = System.nanoTime();
        int result1 = computation.compute(5);
        long endTime = System.nanoTime();
        long duration1 = endTime - startTime;

        startTime = System.nanoTime();
        int result2 = computation.compute(5);
        endTime = System.nanoTime();
        long duration2 = endTime - startTime;

        assertEquals(25, result1);
        assertEquals(25, result2);
        assertTrue(duration2 < duration1, "Cached call should be faster than initial computation");
    }

    @Test
    void testDifferentValues() {
        ExpensiveComputation computation = CacheProxy.create(new ExpensiveComputationImplementation(), ExpensiveComputation.class);

        int result1 = computation.compute(4);
        int result2 = computation.compute(9);

        assertEquals(16, result1);
        assertEquals(81, result2);
    }
}

