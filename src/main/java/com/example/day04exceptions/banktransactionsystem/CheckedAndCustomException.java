package com.example.day04exceptions.banktransactionsystem;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class CheckedAndCustomException {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);

        // Test Cases
        try {
            System.out.println("Case 1: Valid Withdrawal");
            account.withdraw(1000);

            System.out.println("\nCase 2: Insufficient Balance");
            account.withdraw(6000);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nCase 3: Negative Withdrawal");
            account.withdraw(-500);
        }
        catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

