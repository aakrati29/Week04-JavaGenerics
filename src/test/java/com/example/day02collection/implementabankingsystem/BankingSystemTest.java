package com.example.day02collection.implementabankingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankingSystemTest {
    public BankingSystem bank;

    @BeforeEach
    public void setUp() {
        bank = new BankingSystem();
        bank.createAccount(101, 5000.0);
        bank.createAccount(102, 2000.0);
        bank.createAccount(103, 8000.0);
    }

    @Test
    public void testCreateAccount() {
        // Verify that an account was created successfully
        assertTrue(bank.accounts.containsKey(101));
        assertTrue(bank.accounts.containsKey(102));
        assertTrue(bank.accounts.containsKey(103));
    }

    @Test
    public void testDeposit() {
        bank.deposit(101, 1000.0);

        // Verify that the balance has been updated correctly
        assertEquals(6000.0, bank.accounts.get(101));
    }

    @Test
    public void testDepositToNonExistingAccount() {
        bank.deposit(999, 1000.0);

        // Verify that non-existing accounts do not cause issues (balance should not change)
        assertFalse(bank.accounts.containsKey(999));
    }

    @Test
    public void testRequestWithdrawal() {
        bank.requestWithdrawal(101, 3000.0);

        // Verify that the withdrawal request has been added to the queue
        assertFalse(bank.withdrawalQueue.isEmpty());
    }

    @Test
    public void testRequestWithdrawalWithInsufficientBalance() {
        bank.requestWithdrawal(102, 3000.0);

        // Verify that the withdrawal request is not added when the balance is insufficient
        assertTrue(bank.withdrawalQueue.isEmpty());
    }

    @Test
    public void testProcessWithdrawals() {
        bank.requestWithdrawal(101, 3000.0);
        bank.processWithdrawals();

        // Verify that withdrawal requests are processed
        assertTrue(bank.withdrawalQueue.isEmpty());
    }
    
}
