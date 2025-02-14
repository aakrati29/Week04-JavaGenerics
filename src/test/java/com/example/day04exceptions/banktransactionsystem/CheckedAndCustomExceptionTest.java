package com.example.day04exceptions.banktransactionsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Initialize the BankAccount before each test
        account = new BankAccount(5000);
    }

    @Test
    void testValidWithdrawal() {
        // Test case for valid withdrawal
        try {
            account.withdraw(1000);
            assertTrue(true, "Withdrawal should be successful.");
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            fail("No exception should be thrown for valid withdrawal.");
        }
    }

    @Test
    void testInsufficientBalance() {
        // Test case for insufficient balance withdrawal
        Exception exception = assertThrows(InsufficientBalanceException.class, () -> {
            account.withdraw(6000);
        });

        // Check if the correct exception message is thrown
        assertEquals("Insufficient balance!", exception.getMessage());
    }

    @Test
    void testNegativeWithdrawal() {
        // Test case for withdrawal with negative amount
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-500);
        });

        // Check if the correct exception message is thrown
        assertEquals("Invalid amount!", exception.getMessage());
    }
}

