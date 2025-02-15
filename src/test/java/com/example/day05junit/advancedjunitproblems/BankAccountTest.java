package com.example.day05junit.advancedjunitproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance(), "Balance should be 150 after depositing 50");
    }

    @Test
    void testWithdrawSuccess() {
        BankAccount account = new BankAccount(200);
        assertTrue(account.withdraw(100), "Withdrawal of 100 should succeed");
        assertEquals(100, account.getBalance(), "Balance should be 100 after withdrawal");
    }

    @Test
    void testWithdrawFailure() {
        BankAccount account = new BankAccount(50);
        assertFalse(account.withdraw(100), "Withdrawal should fail due to insufficient funds");
        assertEquals(50, account.getBalance(), "Balance should remain 50 after failed withdrawal");
    }

    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50), "Should throw exception for negative deposit");
    }

    @Test
    void testNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-100), "Should throw exception for negative initial balance");
    }
}

