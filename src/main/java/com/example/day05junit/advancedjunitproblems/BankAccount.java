package com.example.day05junit.advancedjunitproblems;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);

        System.out.println("Initial Balance: $" + account.getBalance());
        account.deposit(200);
        System.out.println("After Deposit: $" + account.getBalance());

        if (account.withdraw(100)) {
            System.out.println("After Withdrawal: $" + account.getBalance());
        } else {
            System.out.println("Withdrawal Failed: Insufficient funds");
        }
    }
}

