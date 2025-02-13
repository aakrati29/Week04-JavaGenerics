package com.example.day02collection.votingmanagementsystem;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); // Stores candidate votes
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintains voting order
    private TreeMap<String, Integer> sortedResults = new TreeMap<>(); // Sorted order

    public void vote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate));
        sortedResults.put(candidate, voteMap.get(candidate));
    }

    public int getVoteCount(String candidate) {
        return voteMap.getOrDefault(candidate, 0);
    }

    public void displayVoteOrder() {
        System.out.println("Votes in order of casting:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public void displayResults() {
        System.out.println("Results (Alphabetically Sorted):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public void findWinner() {
        String winner = Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Winner: " + winner + " with " + voteMap.get(winner) + " votes!");
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.vote("Aakrati");
        votingSystem.vote("Ankit");
        votingSystem.vote("Aakrati");
        votingSystem.vote("Anand");
        votingSystem.vote("Ankit");
        votingSystem.vote("Aakrati");

        votingSystem.displayVoteOrder();

        votingSystem.displayResults();

        votingSystem.findWinner();
    }
}

