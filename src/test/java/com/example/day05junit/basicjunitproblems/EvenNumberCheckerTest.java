package com.example.day05junit.basicjunitproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EvenNumberCheckerTest {

    private final EvenNumberChecker checker = new EvenNumberChecker();

    @Test
    void testEvenNumber() {
        assertTrue(checker.isEven(2), "2 should be even");
        assertTrue(checker.isEven(10), "10 should be even");
        assertTrue(checker.isEven(100), "100 should be even");
    }

    @Test
    void testOddNumber() {
        assertFalse(checker.isEven(3), "3 should be odd");
        assertFalse(checker.isEven(9), "9 should be odd");
        assertFalse(checker.isEven(101), "101 should be odd");
    }

    @Test
    void testZero() {
        assertTrue(checker.isEven(0), "0 should be even");
    }

    @Test
    void testNegativeEvenNumber() {
        assertTrue(checker.isEven(-4), "-4 should be even");
        assertTrue(checker.isEven(-20), "-20 should be even");
    }

    @Test
    void testNegativeOddNumber() {
        assertFalse(checker.isEven(-7), "-7 should be odd");
        assertFalse(checker.isEven(-15), "-15 should be odd");
    }
}

