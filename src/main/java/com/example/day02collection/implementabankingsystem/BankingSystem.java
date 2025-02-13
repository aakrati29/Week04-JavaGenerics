package com.example.day02collection.implementabankingsystem;

import java.util.*;

public class BankingSystem {
    public Map<Integer, Double> accounts = new HashMap<>(); // Stores account balances
    public TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>(); // Sorts by balance
    public Queue<Integer> withdrawalQueue = new LinkedList<>(); // Processes withdrawal requests

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            double newBalance = oldBalance + amount;

            accounts.put(accountNumber, newBalance);

            sortedAccounts.get(oldBalance).remove((Integer) accountNumber);
            if (sortedAccounts.get(oldBalance).isEmpty()) {
                sortedAccounts.remove(oldBalance);
            }
            sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
        }
    }

    public void requestWithdrawal(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for Account: " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid account.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account: " + accountNumber);
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts Sorted by Balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            for (Integer accountNumber : entry.getValue()) {
                System.out.println("Account: " + accountNumber + " → Balance: $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 5000.0);
        bank.createAccount(102, 2000.0);
        bank.createAccount(103, 8000.0);

        bank.deposit(101, 1000.0);
        bank.deposit(102, 500.0);

        bank.requestWithdrawal(101, 3000.0);
        bank.requestWithdrawal(103, 5000.0);

        bank.displaySortedAccounts();

        bank.processWithdrawals();
    }
}

